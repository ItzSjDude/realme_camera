package com.google.android.exoplayer2.extractor.mp4;

/* loaded from: classes.dex */
public final class Mp4Extractor implements com.google.android.exoplayer2.extractor.Extractor, com.google.android.exoplayer2.extractor.SeekMap {
    public static final int FLAG_WORKAROUND_IGNORE_EDIT_LISTS = 1;
    private static final long MAXIMUM_READ_AHEAD_BYTES_STREAM = 10485760;
    private static final long RELOAD_MINIMUM_SEEK_DISTANCE = 262144;
    private static final int STATE_READING_ATOM_HEADER = 0;
    private static final int STATE_READING_ATOM_PAYLOAD = 1;
    private static final int STATE_READING_SAMPLE = 2;
    private int ac4SampleHeaderSize;
    private long[][] accumulatedSampleSizes;
    private com.google.android.exoplayer2.util.ParsableByteArray atomData;
    private final com.google.android.exoplayer2.util.ParsableByteArray atomHeader;
    private int atomHeaderBytesRead;
    private long atomSize;
    private int atomType;
    private final java.util.ArrayDeque<com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom> containerAtoms;
    private long durationUs;
    private com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput;
    private int firstVideoTrackIndex;
    private final int flags;
    private boolean isAc4HeaderAdded;
    private boolean isQuickTime;
    private final com.google.android.exoplayer2.util.ParsableByteArray nalLength;
    private final com.google.android.exoplayer2.util.ParsableByteArray nalStartCode;
    private int parserState;
    private int sampleBytesWritten;
    private int sampleCurrentNalBytesRemaining;
    private int sampleTrackIndex;
    private com.google.android.exoplayer2.extractor.mp4.Mp4Extractor.Mp4Track[] tracks;
    public static final com.google.android.exoplayer2.extractor.ExtractorsFactory FACTORY = new com.google.android.exoplayer2.extractor.ExtractorsFactory() { // from class: com.google.android.exoplayer2.extractor.mp4.-$$Lambda$Mp4Extractor$quy71uYOGsneho91FZy1d2UGE1Q
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public final com.google.android.exoplayer2.extractor.Extractor[] createExtractors() {
            return com.google.android.exoplayer2.extractor.mp4.Mp4Extractor.lambda$static$0();
        }
    };
    private static final int BRAND_QUICKTIME = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("qt  ");

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    static /* synthetic */ com.google.android.exoplayer2.extractor.Extractor[] lambda$static$0() {
        return new com.google.android.exoplayer2.extractor.Extractor[]{new com.google.android.exoplayer2.extractor.mp4.Mp4Extractor()};
    }

    public Mp4Extractor() {
        this(0);
    }

    public Mp4Extractor(int i_renamed) {
        this.flags = i_renamed;
        this.atomHeader = new com.google.android.exoplayer2.util.ParsableByteArray(16);
        this.containerAtoms = new java.util.ArrayDeque<>();
        this.nalStartCode = new com.google.android.exoplayer2.util.ParsableByteArray(com.google.android.exoplayer2.util.NalUnitUtil.NAL_START_CODE);
        this.nalLength = new com.google.android.exoplayer2.util.ParsableByteArray(4);
        this.sampleTrackIndex = -1;
        this.isAc4HeaderAdded = false;
        this.ac4SampleHeaderSize = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        return com.google.android.exoplayer2.extractor.mp4.Sniffer.sniffUnfragmented(extractorInput);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput) {
        this.extractorOutput = extractorOutput;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j_renamed, long j2) {
        this.containerAtoms.clear();
        this.atomHeaderBytesRead = 0;
        this.sampleTrackIndex = -1;
        this.sampleBytesWritten = 0;
        this.sampleCurrentNalBytesRemaining = 0;
        if (j_renamed == 0) {
            enterReadingAtomHeaderState();
        } else if (this.tracks != null) {
            updateSampleIndices(j2);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder) throws java.lang.InterruptedException, java.io.IOException {
        while (true) {
            int i_renamed = this.parserState;
            if (i_renamed != 0) {
                if (i_renamed != 1) {
                    if (i_renamed == 2) {
                        return readSample(extractorInput, positionHolder);
                    }
                    throw new java.lang.IllegalStateException();
                }
                if (readAtomPayload(extractorInput, positionHolder)) {
                    return 1;
                }
            } else if (!readAtomHeader(extractorInput)) {
                return -1;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.durationUs;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public com.google.android.exoplayer2.extractor.SeekMap.SeekPoints getSeekPoints(long j_renamed) {
        long j2;
        long jMaybeAdjustSeekOffset;
        long j3;
        long j4;
        int indexOfLaterOrEqualSynchronizationSample;
        com.google.android.exoplayer2.extractor.mp4.Mp4Extractor.Mp4Track[] mp4TrackArr = this.tracks;
        if (mp4TrackArr.length == 0) {
            return new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(com.google.android.exoplayer2.extractor.SeekPoint.START);
        }
        int i_renamed = this.firstVideoTrackIndex;
        if (i_renamed != -1) {
            com.google.android.exoplayer2.extractor.mp4.TrackSampleTable trackSampleTable = mp4TrackArr[i_renamed].sampleTable;
            int synchronizationSampleIndex = getSynchronizationSampleIndex(trackSampleTable, j_renamed);
            if (synchronizationSampleIndex == -1) {
                return new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(com.google.android.exoplayer2.extractor.SeekPoint.START);
            }
            long j5 = trackSampleTable.timestampsUs[synchronizationSampleIndex];
            j2 = trackSampleTable.offsets[synchronizationSampleIndex];
            if (j5 >= j_renamed || synchronizationSampleIndex >= trackSampleTable.sampleCount - 1 || (indexOfLaterOrEqualSynchronizationSample = trackSampleTable.getIndexOfLaterOrEqualSynchronizationSample(j_renamed)) == -1 || indexOfLaterOrEqualSynchronizationSample == synchronizationSampleIndex) {
                j4 = -1;
                j3 = -9223372036854775807L;
            } else {
                j3 = trackSampleTable.timestampsUs[indexOfLaterOrEqualSynchronizationSample];
                j4 = trackSampleTable.offsets[indexOfLaterOrEqualSynchronizationSample];
            }
            jMaybeAdjustSeekOffset = j4;
            j_renamed = j5;
        } else {
            j2 = Long.MAX_VALUE;
            jMaybeAdjustSeekOffset = -1;
            j3 = -9223372036854775807L;
        }
        int i2 = 0;
        while (true) {
            com.google.android.exoplayer2.extractor.mp4.Mp4Extractor.Mp4Track[] mp4TrackArr2 = this.tracks;
            if (i2 >= mp4TrackArr2.length) {
                break;
            }
            if (i2 != this.firstVideoTrackIndex) {
                com.google.android.exoplayer2.extractor.mp4.TrackSampleTable trackSampleTable2 = mp4TrackArr2[i2].sampleTable;
                long jMaybeAdjustSeekOffset2 = maybeAdjustSeekOffset(trackSampleTable2, j_renamed, j2);
                if (j3 != -9223372036854775807L) {
                    jMaybeAdjustSeekOffset = maybeAdjustSeekOffset(trackSampleTable2, j3, jMaybeAdjustSeekOffset);
                }
                j2 = jMaybeAdjustSeekOffset2;
            }
            i2++;
        }
        com.google.android.exoplayer2.extractor.SeekPoint seekPoint = new com.google.android.exoplayer2.extractor.SeekPoint(j_renamed, j2);
        if (j3 == -9223372036854775807L) {
            return new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(seekPoint);
        }
        return new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(seekPoint, new com.google.android.exoplayer2.extractor.SeekPoint(j3, jMaybeAdjustSeekOffset));
    }

    private void enterReadingAtomHeaderState() {
        this.parserState = 0;
        this.atomHeaderBytesRead = 0;
    }

    private boolean readAtomHeader(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        if (this.atomHeaderBytesRead == 0) {
            if (!extractorInput.readFully(this.atomHeader.data, 0, 8, true)) {
                return false;
            }
            this.atomHeaderBytesRead = 8;
            this.atomHeader.setPosition(0);
            this.atomSize = this.atomHeader.readUnsignedInt();
            this.atomType = this.atomHeader.readInt();
        }
        long j_renamed = this.atomSize;
        if (j_renamed == 1) {
            extractorInput.readFully(this.atomHeader.data, 8, 8);
            this.atomHeaderBytesRead += 8;
            this.atomSize = this.atomHeader.readUnsignedLongToLong();
        } else if (j_renamed == 0) {
            long length = extractorInput.getLength();
            if (length == -1 && !this.containerAtoms.isEmpty()) {
                length = this.containerAtoms.peek().endPosition;
            }
            if (length != -1) {
                this.atomSize = (length - extractorInput.getPosition()) + this.atomHeaderBytesRead;
            }
        }
        if (this.atomSize < this.atomHeaderBytesRead) {
            throw new com.google.android.exoplayer2.ParserException("Atom size less than header length (unsupported).");
        }
        if (shouldParseContainerAtom(this.atomType)) {
            long position = (extractorInput.getPosition() + this.atomSize) - this.atomHeaderBytesRead;
            this.containerAtoms.push(new com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom(this.atomType, position));
            if (this.atomSize == this.atomHeaderBytesRead) {
                processAtomEnded(position);
            } else {
                enterReadingAtomHeaderState();
            }
        } else if (shouldParseLeafAtom(this.atomType)) {
            com.google.android.exoplayer2.util.Assertions.checkState(this.atomHeaderBytesRead == 8);
            com.google.android.exoplayer2.util.Assertions.checkState(this.atomSize <= 2147483647L);
            this.atomData = new com.google.android.exoplayer2.util.ParsableByteArray((int) this.atomSize);
            java.lang.System.arraycopy(this.atomHeader.data, 0, this.atomData.data, 0, 8);
            this.parserState = 1;
        } else {
            this.atomData = null;
            this.parserState = 1;
        }
        return true;
    }

    private boolean readAtomPayload(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder) throws java.lang.InterruptedException, java.io.IOException {
        boolean z_renamed;
        long j_renamed = this.atomSize - this.atomHeaderBytesRead;
        long position = extractorInput.getPosition() + j_renamed;
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = this.atomData;
        if (parsableByteArray != null) {
            extractorInput.readFully(parsableByteArray.data, this.atomHeaderBytesRead, (int) j_renamed);
            if (this.atomType == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_ftyp) {
                this.isQuickTime = processFtypAtom(this.atomData);
            } else if (!this.containerAtoms.isEmpty()) {
                this.containerAtoms.peek().add(new com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom(this.atomType, this.atomData));
            }
        } else if (j_renamed < 262144) {
            extractorInput.skipFully((int) j_renamed);
        } else {
            positionHolder.position = extractorInput.getPosition() + j_renamed;
            z_renamed = true;
            processAtomEnded(position);
            return (z_renamed || this.parserState == 2) ? false : true;
        }
        z_renamed = false;
        processAtomEnded(position);
        if (z_renamed) {
        }
    }

    private void processAtomEnded(long j_renamed) throws com.google.android.exoplayer2.ParserException {
        while (!this.containerAtoms.isEmpty() && this.containerAtoms.peek().endPosition == j_renamed) {
            com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom containerAtomPop = this.containerAtoms.pop();
            if (containerAtomPop.type == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_moov) {
                processMoovAtom(containerAtomPop);
                this.containerAtoms.clear();
                this.parserState = 2;
            } else if (!this.containerAtoms.isEmpty()) {
                this.containerAtoms.peek().add(containerAtomPop);
            }
        }
        if (this.parserState != 2) {
            enterReadingAtomHeaderState();
        }
    }

    private void processMoovAtom(com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom containerAtom) throws com.google.android.exoplayer2.ParserException {
        com.google.android.exoplayer2.metadata.Metadata udta;
        boolean z_renamed;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.google.android.exoplayer2.extractor.GaplessInfoHolder gaplessInfoHolder = new com.google.android.exoplayer2.extractor.GaplessInfoHolder();
        com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_udta);
        if (leafAtomOfType != null) {
            udta = com.google.android.exoplayer2.extractor.mp4.AtomParsers.parseUdta(leafAtomOfType, this.isQuickTime);
            if (udta != null) {
                gaplessInfoHolder.setFromMetadata(udta);
            }
        } else {
            udta = null;
        }
        com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom containerAtomOfType = containerAtom.getContainerAtomOfType(com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_meta);
        com.google.android.exoplayer2.metadata.Metadata mdtaFromMeta = containerAtomOfType != null ? com.google.android.exoplayer2.extractor.mp4.AtomParsers.parseMdtaFromMeta(containerAtomOfType) : null;
        int i_renamed = 0;
        java.util.ArrayList<com.google.android.exoplayer2.extractor.mp4.TrackSampleTable> trackSampleTables = getTrackSampleTables(containerAtom, gaplessInfoHolder, (this.flags & 1) != 0);
        int size = trackSampleTables.size();
        long j_renamed = -9223372036854775807L;
        long j2 = -9223372036854775807L;
        int size2 = -1;
        while (i_renamed < size) {
            com.google.android.exoplayer2.extractor.mp4.TrackSampleTable trackSampleTable = trackSampleTables.get(i_renamed);
            com.google.android.exoplayer2.extractor.mp4.Track track = trackSampleTable.track;
            int i2 = i_renamed;
            long j3 = track.durationUs != j_renamed ? track.durationUs : trackSampleTable.durationUs;
            long jMax = java.lang.Math.max(j2, j3);
            java.util.ArrayList<com.google.android.exoplayer2.extractor.mp4.TrackSampleTable> arrayList2 = trackSampleTables;
            int i3 = size;
            com.google.android.exoplayer2.extractor.mp4.Mp4Extractor.Mp4Track mp4Track = new com.google.android.exoplayer2.extractor.mp4.Mp4Extractor.Mp4Track(track, trackSampleTable, this.extractorOutput.track(i2, track.type));
            com.google.android.exoplayer2.Format formatCopyWithMaxInputSize = track.format.copyWithMaxInputSize(trackSampleTable.maximumSize + 30);
            if (track.type != 2 || j3 <= 0) {
                z_renamed = true;
            } else {
                z_renamed = true;
                if (trackSampleTable.sampleCount > 1) {
                    formatCopyWithMaxInputSize = formatCopyWithMaxInputSize.copyWithFrameRate(trackSampleTable.sampleCount / (j3 / 1000000.0f));
                }
            }
            mp4Track.trackOutput.format(com.google.android.exoplayer2.extractor.mp4.MetadataUtil.getFormatWithMetadata(track.type, formatCopyWithMaxInputSize, udta, mdtaFromMeta, gaplessInfoHolder));
            if (track.type == 2 && size2 == -1) {
                size2 = arrayList.size();
            }
            arrayList.add(mp4Track);
            i_renamed = i2 + 1;
            trackSampleTables = arrayList2;
            size = i3;
            j2 = jMax;
            j_renamed = -9223372036854775807L;
        }
        this.firstVideoTrackIndex = size2;
        this.durationUs = j2;
        this.tracks = (com.google.android.exoplayer2.extractor.mp4.Mp4Extractor.Mp4Track[]) arrayList.toArray(new com.google.android.exoplayer2.extractor.mp4.Mp4Extractor.Mp4Track[arrayList.size()]);
        this.accumulatedSampleSizes = calculateAccumulatedSampleSizes(this.tracks);
        this.extractorOutput.endTracks();
        this.extractorOutput.seekMap(this);
    }

    private java.util.ArrayList<com.google.android.exoplayer2.extractor.mp4.TrackSampleTable> getTrackSampleTables(com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom containerAtom, com.google.android.exoplayer2.extractor.GaplessInfoHolder gaplessInfoHolder, boolean z_renamed) throws com.google.android.exoplayer2.ParserException {
        com.google.android.exoplayer2.extractor.mp4.Track trak;
        java.util.ArrayList<com.google.android.exoplayer2.extractor.mp4.TrackSampleTable> arrayList = new java.util.ArrayList<>();
        for (int i_renamed = 0; i_renamed < containerAtom.containerChildren.size(); i_renamed++) {
            com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom containerAtom2 = containerAtom.containerChildren.get(i_renamed);
            if (containerAtom2.type == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_trak && (trak = com.google.android.exoplayer2.extractor.mp4.AtomParsers.parseTrak(containerAtom2, containerAtom.getLeafAtomOfType(com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_mvhd), -9223372036854775807L, null, z_renamed, this.isQuickTime)) != null) {
                com.google.android.exoplayer2.extractor.mp4.TrackSampleTable stbl = com.google.android.exoplayer2.extractor.mp4.AtomParsers.parseStbl(trak, containerAtom2.getContainerAtomOfType(com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_mdia).getContainerAtomOfType(com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_minf).getContainerAtomOfType(com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_stbl), gaplessInfoHolder);
                if (stbl.sampleCount != 0) {
                    arrayList.add(stbl);
                }
            }
        }
        return arrayList;
    }

    private int readSample(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder) throws java.lang.InterruptedException, java.io.IOException {
        long position = extractorInput.getPosition();
        if (this.sampleTrackIndex == -1) {
            this.sampleTrackIndex = getTrackIndexOfNextReadSample(position);
            if (this.sampleTrackIndex == -1) {
                return -1;
            }
            this.isAc4HeaderAdded = false;
        }
        com.google.android.exoplayer2.extractor.mp4.Mp4Extractor.Mp4Track mp4Track = this.tracks[this.sampleTrackIndex];
        com.google.android.exoplayer2.extractor.TrackOutput trackOutput = mp4Track.trackOutput;
        int i_renamed = mp4Track.sampleIndex;
        long j_renamed = mp4Track.sampleTable.offsets[i_renamed];
        int i2 = mp4Track.sampleTable.sizes[i_renamed];
        long j2 = (j_renamed - position) + this.sampleBytesWritten;
        if (j2 < 0 || j2 >= 262144) {
            positionHolder.position = j_renamed;
            return 1;
        }
        if (mp4Track.track.sampleTransformation == 1) {
            j2 += 8;
            i2 -= 8;
        }
        extractorInput.skipFully((int) j2);
        if (mp4Track.track.nalUnitLengthFieldLength != 0) {
            byte[] bArr = this.nalLength.data;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i3 = mp4Track.track.nalUnitLengthFieldLength;
            int i4 = 4 - mp4Track.track.nalUnitLengthFieldLength;
            while (this.sampleBytesWritten < i2) {
                int i5 = this.sampleCurrentNalBytesRemaining;
                if (i5 == 0) {
                    extractorInput.readFully(this.nalLength.data, i4, i3);
                    this.nalLength.setPosition(0);
                    this.sampleCurrentNalBytesRemaining = this.nalLength.readUnsignedIntToInt();
                    this.nalStartCode.setPosition(0);
                    trackOutput.sampleData(this.nalStartCode, 4);
                    this.sampleBytesWritten += 4;
                    i2 += i4;
                } else {
                    int iSampleData = trackOutput.sampleData(extractorInput, i5, false);
                    this.sampleBytesWritten += iSampleData;
                    this.sampleCurrentNalBytesRemaining -= iSampleData;
                }
            }
        } else {
            if (com.google.android.exoplayer2.util.MimeTypes.AUDIO_AC4.equals(mp4Track.track.format.sampleMimeType) && !this.isAc4HeaderAdded) {
                com.google.android.exoplayer2.util.ParsableByteArray ac4SampleHeader = com.google.android.exoplayer2.audio.Ac4Util.getAc4SampleHeader(i2);
                trackOutput.sampleData(ac4SampleHeader, ac4SampleHeader.capacity());
                this.ac4SampleHeaderSize = ac4SampleHeader.capacity();
                this.isAc4HeaderAdded = true;
            }
            while (true) {
                int i6 = this.sampleBytesWritten;
                if (i6 >= i2) {
                    break;
                }
                int iSampleData2 = trackOutput.sampleData(extractorInput, i2 - i6, false);
                this.sampleBytesWritten += iSampleData2;
                this.sampleCurrentNalBytesRemaining -= iSampleData2;
            }
            if (com.google.android.exoplayer2.util.MimeTypes.AUDIO_AC4.equals(mp4Track.track.format.sampleMimeType)) {
                i2 += this.ac4SampleHeaderSize;
                this.isAc4HeaderAdded = false;
            }
        }
        trackOutput.sampleMetadata(mp4Track.sampleTable.timestampsUs[i_renamed], mp4Track.sampleTable.flags[i_renamed], i2, 0, null);
        mp4Track.sampleIndex++;
        this.sampleTrackIndex = -1;
        this.sampleBytesWritten = 0;
        this.sampleCurrentNalBytesRemaining = 0;
        return 0;
    }

    private int getTrackIndexOfNextReadSample(long j_renamed) {
        int i_renamed = -1;
        int i2 = -1;
        int i3 = 0;
        long j2 = Long.MAX_VALUE;
        boolean z_renamed = true;
        long j3 = Long.MAX_VALUE;
        boolean z2 = true;
        long j4 = Long.MAX_VALUE;
        while (true) {
            com.google.android.exoplayer2.extractor.mp4.Mp4Extractor.Mp4Track[] mp4TrackArr = this.tracks;
            if (i3 >= mp4TrackArr.length) {
                break;
            }
            com.google.android.exoplayer2.extractor.mp4.Mp4Extractor.Mp4Track mp4Track = mp4TrackArr[i3];
            int i4 = mp4Track.sampleIndex;
            if (i4 != mp4Track.sampleTable.sampleCount) {
                long j5 = mp4Track.sampleTable.offsets[i4];
                long j6 = this.accumulatedSampleSizes[i3][i4];
                long j7 = j5 - j_renamed;
                boolean z3 = j7 < 0 || j7 >= 262144;
                if ((!z3 && z2) || (z3 == z2 && j7 < j4)) {
                    z2 = z3;
                    i2 = i3;
                    j4 = j7;
                    j3 = j6;
                }
                if (j6 < j2) {
                    z_renamed = z3;
                    i_renamed = i3;
                    j2 = j6;
                }
            }
            i3++;
        }
        return (j2 == Long.MAX_VALUE || !z_renamed || j3 < j2 + MAXIMUM_READ_AHEAD_BYTES_STREAM) ? i2 : i_renamed;
    }

    private void updateSampleIndices(long j_renamed) {
        for (com.google.android.exoplayer2.extractor.mp4.Mp4Extractor.Mp4Track mp4Track : this.tracks) {
            com.google.android.exoplayer2.extractor.mp4.TrackSampleTable trackSampleTable = mp4Track.sampleTable;
            int indexOfEarlierOrEqualSynchronizationSample = trackSampleTable.getIndexOfEarlierOrEqualSynchronizationSample(j_renamed);
            if (indexOfEarlierOrEqualSynchronizationSample == -1) {
                indexOfEarlierOrEqualSynchronizationSample = trackSampleTable.getIndexOfLaterOrEqualSynchronizationSample(j_renamed);
            }
            mp4Track.sampleIndex = indexOfEarlierOrEqualSynchronizationSample;
        }
    }

    private static long[][] calculateAccumulatedSampleSizes(com.google.android.exoplayer2.extractor.mp4.Mp4Extractor.Mp4Track[] mp4TrackArr) {
        long[][] jArr = new long[mp4TrackArr.length][];
        int[] iArr = new int[mp4TrackArr.length];
        long[] jArr2 = new long[mp4TrackArr.length];
        boolean[] zArr = new boolean[mp4TrackArr.length];
        for (int i_renamed = 0; i_renamed < mp4TrackArr.length; i_renamed++) {
            jArr[i_renamed] = new long[mp4TrackArr[i_renamed].sampleTable.sampleCount];
            jArr2[i_renamed] = mp4TrackArr[i_renamed].sampleTable.timestampsUs[0];
        }
        long j_renamed = 0;
        int i2 = 0;
        while (i2 < mp4TrackArr.length) {
            int i3 = -1;
            long j2 = Long.MAX_VALUE;
            for (int i4 = 0; i4 < mp4TrackArr.length; i4++) {
                if (!zArr[i4] && jArr2[i4] <= j2) {
                    j2 = jArr2[i4];
                    i3 = i4;
                }
            }
            int i5 = iArr[i3];
            jArr[i3][i5] = j_renamed;
            j_renamed += mp4TrackArr[i3].sampleTable.sizes[i5];
            int i6 = i5 + 1;
            iArr[i3] = i6;
            if (i6 < jArr[i3].length) {
                jArr2[i3] = mp4TrackArr[i3].sampleTable.timestampsUs[i6];
            } else {
                zArr[i3] = true;
                i2++;
            }
        }
        return jArr;
    }

    private static long maybeAdjustSeekOffset(com.google.android.exoplayer2.extractor.mp4.TrackSampleTable trackSampleTable, long j_renamed, long j2) {
        int synchronizationSampleIndex = getSynchronizationSampleIndex(trackSampleTable, j_renamed);
        return synchronizationSampleIndex == -1 ? j2 : java.lang.Math.min(trackSampleTable.offsets[synchronizationSampleIndex], j2);
    }

    private static int getSynchronizationSampleIndex(com.google.android.exoplayer2.extractor.mp4.TrackSampleTable trackSampleTable, long j_renamed) {
        int indexOfEarlierOrEqualSynchronizationSample = trackSampleTable.getIndexOfEarlierOrEqualSynchronizationSample(j_renamed);
        return indexOfEarlierOrEqualSynchronizationSample == -1 ? trackSampleTable.getIndexOfLaterOrEqualSynchronizationSample(j_renamed) : indexOfEarlierOrEqualSynchronizationSample;
    }

    private static boolean processFtypAtom(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        if (parsableByteArray.readInt() == BRAND_QUICKTIME) {
            return true;
        }
        parsableByteArray.skipBytes(4);
        while (parsableByteArray.bytesLeft() > 0) {
            if (parsableByteArray.readInt() == BRAND_QUICKTIME) {
                return true;
            }
        }
        return false;
    }

    private static boolean shouldParseLeafAtom(int i_renamed) {
        return i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_mdhd || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_mvhd || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_hdlr || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_stsd || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_stts || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_stss || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_ctts || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_elst || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_stsc || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_stsz || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_stz2 || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_stco || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_co64 || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_tkhd || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_ftyp || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_udta || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_keys || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_ilst;
    }

    private static boolean shouldParseContainerAtom(int i_renamed) {
        return i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_moov || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_trak || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_mdia || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_minf || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_stbl || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_edts || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_meta;
    }

    private static final class Mp4Track {
        public int sampleIndex;
        public final com.google.android.exoplayer2.extractor.mp4.TrackSampleTable sampleTable;
        public final com.google.android.exoplayer2.extractor.mp4.Track track;
        public final com.google.android.exoplayer2.extractor.TrackOutput trackOutput;

        public Mp4Track(com.google.android.exoplayer2.extractor.mp4.Track track, com.google.android.exoplayer2.extractor.mp4.TrackSampleTable trackSampleTable, com.google.android.exoplayer2.extractor.TrackOutput trackOutput) {
            this.track = track;
            this.sampleTable = trackSampleTable;
            this.trackOutput = trackOutput;
        }
    }
}
