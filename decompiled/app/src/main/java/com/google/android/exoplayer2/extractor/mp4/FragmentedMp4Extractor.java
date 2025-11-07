package com.google.android.exoplayer2.extractor.mp4;

/* loaded from: classes.dex */
public final class FragmentedMp4Extractor implements com.google.android.exoplayer2.extractor.Extractor {
    public static final int FLAG_ENABLE_EMSG_TRACK = 4;
    private static final int FLAG_SIDELOADED = 8;
    public static final int FLAG_WORKAROUND_EVERY_VIDEO_FRAME_IS_SYNC_FRAME = 1;
    public static final int FLAG_WORKAROUND_IGNORE_EDIT_LISTS = 16;
    public static final int FLAG_WORKAROUND_IGNORE_TFDT_BOX = 2;
    private static final int STATE_READING_ATOM_HEADER = 0;
    private static final int STATE_READING_ATOM_PAYLOAD = 1;
    private static final int STATE_READING_ENCRYPTION_DATA = 2;
    private static final int STATE_READING_SAMPLE_CONTINUE = 4;
    private static final int STATE_READING_SAMPLE_START = 3;
    private static final java.lang.String TAG = "FragmentedMp4Extractor";
    private int ac4SampleHeaderSize;
    private final com.google.android.exoplayer2.extractor.TrackOutput additionalEmsgTrackOutput;
    private com.google.android.exoplayer2.util.ParsableByteArray atomData;
    private final com.google.android.exoplayer2.util.ParsableByteArray atomHeader;
    private int atomHeaderBytesRead;
    private long atomSize;
    private int atomType;
    private com.google.android.exoplayer2.extractor.TrackOutput[] cea608TrackOutputs;
    private final java.util.List<com.google.android.exoplayer2.Format> closedCaptionFormats;
    private final java.util.ArrayDeque<com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom> containerAtoms;
    private com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle currentTrackBundle;
    private long durationUs;
    private com.google.android.exoplayer2.extractor.TrackOutput[] emsgTrackOutputs;
    private long endOfMdatPosition;
    private final byte[] extendedTypeScratch;
    private com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput;
    private final int flags;
    private boolean haveOutputSeekMap;
    private boolean isAc4HeaderAdded;
    private final com.google.android.exoplayer2.util.ParsableByteArray nalBuffer;
    private final com.google.android.exoplayer2.util.ParsableByteArray nalPrefix;
    private final com.google.android.exoplayer2.util.ParsableByteArray nalStartCode;
    private int parserState;
    private int pendingMetadataSampleBytes;
    private final java.util.ArrayDeque<com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.MetadataSampleInfo> pendingMetadataSampleInfos;
    private long pendingSeekTimeUs;
    private boolean processSeiNalUnitPayload;
    private int sampleBytesWritten;
    private int sampleCurrentNalBytesRemaining;
    private int sampleSize;
    private long segmentIndexEarliestPresentationTimeUs;
    private final com.google.android.exoplayer2.drm.DrmInitData sideloadedDrmInitData;
    private final com.google.android.exoplayer2.extractor.mp4.Track sideloadedTrack;
    private final com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster;
    private final android.util.SparseArray<com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle> trackBundles;
    public static final com.google.android.exoplayer2.extractor.ExtractorsFactory FACTORY = new com.google.android.exoplayer2.extractor.ExtractorsFactory() { // from class: com.google.android.exoplayer2.extractor.mp4.-$$Lambda$FragmentedMp4Extractor$i0zfpH_PcF0vytkdatCL0xeWFhQ
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public final com.google.android.exoplayer2.extractor.Extractor[] createExtractors() {
            return com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.lambda$static$0();
        }
    };
    private static final int SAMPLE_GROUP_TYPE_seig = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("seig");
    private static final byte[] PIFF_SAMPLE_ENCRYPTION_BOX_EXTENDED_TYPE = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    private static final com.google.android.exoplayer2.Format EMSG_FORMAT = com.google.android.exoplayer2.Format.createSampleFormat(null, com.google.android.exoplayer2.util.MimeTypes.APPLICATION_EMSG, Long.MAX_VALUE);

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    static /* synthetic */ com.google.android.exoplayer2.extractor.Extractor[] lambda$static$0() {
        return new com.google.android.exoplayer2.extractor.Extractor[]{new com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor()};
    }

    public FragmentedMp4Extractor() {
        this(0);
    }

    public FragmentedMp4Extractor(int i_renamed) {
        this(i_renamed, null);
    }

    public FragmentedMp4Extractor(int i_renamed, com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster) {
        this(i_renamed, timestampAdjuster, null, null);
    }

    public FragmentedMp4Extractor(int i_renamed, com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster, com.google.android.exoplayer2.extractor.mp4.Track track, com.google.android.exoplayer2.drm.DrmInitData drmInitData) {
        this(i_renamed, timestampAdjuster, track, drmInitData, java.util.Collections.emptyList());
    }

    public FragmentedMp4Extractor(int i_renamed, com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster, com.google.android.exoplayer2.extractor.mp4.Track track, com.google.android.exoplayer2.drm.DrmInitData drmInitData, java.util.List<com.google.android.exoplayer2.Format> list) {
        this(i_renamed, timestampAdjuster, track, drmInitData, list, null);
    }

    public FragmentedMp4Extractor(int i_renamed, com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster, com.google.android.exoplayer2.extractor.mp4.Track track, com.google.android.exoplayer2.drm.DrmInitData drmInitData, java.util.List<com.google.android.exoplayer2.Format> list, com.google.android.exoplayer2.extractor.TrackOutput trackOutput) {
        this.flags = i_renamed | (track != null ? 8 : 0);
        this.timestampAdjuster = timestampAdjuster;
        this.sideloadedTrack = track;
        this.sideloadedDrmInitData = drmInitData;
        this.closedCaptionFormats = java.util.Collections.unmodifiableList(list);
        this.additionalEmsgTrackOutput = trackOutput;
        this.atomHeader = new com.google.android.exoplayer2.util.ParsableByteArray(16);
        this.nalStartCode = new com.google.android.exoplayer2.util.ParsableByteArray(com.google.android.exoplayer2.util.NalUnitUtil.NAL_START_CODE);
        this.nalPrefix = new com.google.android.exoplayer2.util.ParsableByteArray(5);
        this.nalBuffer = new com.google.android.exoplayer2.util.ParsableByteArray();
        this.extendedTypeScratch = new byte[16];
        this.containerAtoms = new java.util.ArrayDeque<>();
        this.pendingMetadataSampleInfos = new java.util.ArrayDeque<>();
        this.trackBundles = new android.util.SparseArray<>();
        this.durationUs = -9223372036854775807L;
        this.pendingSeekTimeUs = -9223372036854775807L;
        this.segmentIndexEarliestPresentationTimeUs = -9223372036854775807L;
        this.isAc4HeaderAdded = false;
        this.ac4SampleHeaderSize = 0;
        enterReadingAtomHeaderState();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        return com.google.android.exoplayer2.extractor.mp4.Sniffer.sniffFragmented(extractorInput);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput) {
        this.extractorOutput = extractorOutput;
        com.google.android.exoplayer2.extractor.mp4.Track track = this.sideloadedTrack;
        if (track != null) {
            com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle trackBundle = new com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle(extractorOutput.track(0, track.type));
            trackBundle.init(this.sideloadedTrack, new com.google.android.exoplayer2.extractor.mp4.DefaultSampleValues(0, 0, 0, 0));
            this.trackBundles.put(0, trackBundle);
            maybeInitExtraTracks();
            this.extractorOutput.endTracks();
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j_renamed, long j2) {
        int size = this.trackBundles.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            this.trackBundles.valueAt(i_renamed).reset();
        }
        this.pendingMetadataSampleInfos.clear();
        this.pendingMetadataSampleBytes = 0;
        this.pendingSeekTimeUs = j2;
        this.containerAtoms.clear();
        enterReadingAtomHeaderState();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder) throws java.lang.InterruptedException, java.io.IOException {
        while (true) {
            int i_renamed = this.parserState;
            if (i_renamed != 0) {
                if (i_renamed == 1) {
                    readAtomPayload(extractorInput);
                } else if (i_renamed == 2) {
                    readEncryptionData(extractorInput);
                } else if (readSample(extractorInput)) {
                    return 0;
                }
            } else if (!readAtomHeader(extractorInput)) {
                return -1;
            }
        }
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
        long position = extractorInput.getPosition() - this.atomHeaderBytesRead;
        if (this.atomType == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_moof) {
            int size = this.trackBundles.size();
            for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                com.google.android.exoplayer2.extractor.mp4.TrackFragment trackFragment = this.trackBundles.valueAt(i_renamed).fragment;
                trackFragment.atomPosition = position;
                trackFragment.auxiliaryDataPosition = position;
                trackFragment.dataPosition = position;
            }
        }
        if (this.atomType == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_mdat) {
            this.currentTrackBundle = null;
            this.endOfMdatPosition = this.atomSize + position;
            if (!this.haveOutputSeekMap) {
                this.extractorOutput.seekMap(new com.google.android.exoplayer2.extractor.SeekMap.Unseekable(this.durationUs, position));
                this.haveOutputSeekMap = true;
            }
            this.parserState = 2;
            return true;
        }
        if (shouldParseContainerAtom(this.atomType)) {
            long position2 = (extractorInput.getPosition() + this.atomSize) - 8;
            this.containerAtoms.push(new com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom(this.atomType, position2));
            if (this.atomSize == this.atomHeaderBytesRead) {
                processAtomEnded(position2);
            } else {
                enterReadingAtomHeaderState();
            }
        } else if (shouldParseLeafAtom(this.atomType)) {
            if (this.atomHeaderBytesRead != 8) {
                throw new com.google.android.exoplayer2.ParserException("Leaf atom defines extended atom size (unsupported).");
            }
            long j2 = this.atomSize;
            if (j2 > 2147483647L) {
                throw new com.google.android.exoplayer2.ParserException("Leaf atom with length > 2147483647 (unsupported).");
            }
            this.atomData = new com.google.android.exoplayer2.util.ParsableByteArray((int) j2);
            java.lang.System.arraycopy(this.atomHeader.data, 0, this.atomData.data, 0, 8);
            this.parserState = 1;
        } else {
            if (this.atomSize > 2147483647L) {
                throw new com.google.android.exoplayer2.ParserException("Skipping atom with length > 2147483647 (unsupported).");
            }
            this.atomData = null;
            this.parserState = 1;
        }
        return true;
    }

    private void readAtomPayload(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        int i_renamed = ((int) this.atomSize) - this.atomHeaderBytesRead;
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = this.atomData;
        if (parsableByteArray != null) {
            extractorInput.readFully(parsableByteArray.data, 8, i_renamed);
            onLeafAtomRead(new com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom(this.atomType, this.atomData), extractorInput.getPosition());
        } else {
            extractorInput.skipFully(i_renamed);
        }
        processAtomEnded(extractorInput.getPosition());
    }

    private void processAtomEnded(long j_renamed) throws com.google.android.exoplayer2.ParserException {
        while (!this.containerAtoms.isEmpty() && this.containerAtoms.peek().endPosition == j_renamed) {
            onContainerAtomRead(this.containerAtoms.pop());
        }
        enterReadingAtomHeaderState();
    }

    private void onLeafAtomRead(com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom leafAtom, long j_renamed) throws com.google.android.exoplayer2.ParserException {
        if (!this.containerAtoms.isEmpty()) {
            this.containerAtoms.peek().add(leafAtom);
            return;
        }
        if (leafAtom.type == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_sidx) {
            android.util.Pair<java.lang.Long, com.google.android.exoplayer2.extractor.ChunkIndex> sidx = parseSidx(leafAtom.data, j_renamed);
            this.segmentIndexEarliestPresentationTimeUs = ((java.lang.Long) sidx.first).longValue();
            this.extractorOutput.seekMap((com.google.android.exoplayer2.extractor.SeekMap) sidx.second);
            this.haveOutputSeekMap = true;
            return;
        }
        if (leafAtom.type == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_emsg) {
            onEmsgLeafAtomRead(leafAtom.data);
        }
    }

    private void onContainerAtomRead(com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom containerAtom) throws com.google.android.exoplayer2.ParserException {
        if (containerAtom.type == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_moov) {
            onMoovContainerAtomRead(containerAtom);
        } else if (containerAtom.type == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_moof) {
            onMoofContainerAtomRead(containerAtom);
        } else {
            if (this.containerAtoms.isEmpty()) {
                return;
            }
            this.containerAtoms.peek().add(containerAtom);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void onMoovContainerAtomRead(com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom containerAtom) throws com.google.android.exoplayer2.ParserException {
        int i_renamed;
        int i2;
        int i3 = 0;
        com.google.android.exoplayer2.util.Assertions.checkState(this.sideloadedTrack == null, "Unexpected moov box.");
        com.google.android.exoplayer2.drm.DrmInitData drmInitDataFromAtoms = this.sideloadedDrmInitData;
        if (drmInitDataFromAtoms == null) {
            drmInitDataFromAtoms = getDrmInitDataFromAtoms(containerAtom.leafChildren);
        }
        com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom containerAtomOfType = containerAtom.getContainerAtomOfType(com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_mvex);
        android.util.SparseArray sparseArray = new android.util.SparseArray();
        int size = containerAtomOfType.leafChildren.size();
        long mehd = -9223372036854775807L;
        for (int i4 = 0; i4 < size; i4++) {
            com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom leafAtom = containerAtomOfType.leafChildren.get(i4);
            if (leafAtom.type == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_trex) {
                android.util.Pair<java.lang.Integer, com.google.android.exoplayer2.extractor.mp4.DefaultSampleValues> trex = parseTrex(leafAtom.data);
                sparseArray.put(((java.lang.Integer) trex.first).intValue(), trex.second);
            } else if (leafAtom.type == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_mehd) {
                mehd = parseMehd(leafAtom.data);
            }
        }
        android.util.SparseArray sparseArray2 = new android.util.SparseArray();
        int size2 = containerAtom.containerChildren.size();
        int i5 = 0;
        while (i5 < size2) {
            com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom containerAtom2 = containerAtom.containerChildren.get(i5);
            if (containerAtom2.type == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_trak) {
                i_renamed = i5;
                i2 = size2;
                com.google.android.exoplayer2.extractor.mp4.Track trak = com.google.android.exoplayer2.extractor.mp4.AtomParsers.parseTrak(containerAtom2, containerAtom.getLeafAtomOfType(com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_mvhd), mehd, drmInitDataFromAtoms, (this.flags & 16) != 0, false);
                if (trak != null) {
                    sparseArray2.put(trak.id_renamed, trak);
                }
            } else {
                i_renamed = i5;
                i2 = size2;
            }
            i5 = i_renamed + 1;
            size2 = i2;
        }
        int size3 = sparseArray2.size();
        if (this.trackBundles.size() == 0) {
            while (i3 < size3) {
                com.google.android.exoplayer2.extractor.mp4.Track track = (com.google.android.exoplayer2.extractor.mp4.Track) sparseArray2.valueAt(i3);
                com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle trackBundle = new com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle(this.extractorOutput.track(i3, track.type));
                trackBundle.init(track, getDefaultSampleValues(sparseArray, track.id_renamed));
                this.trackBundles.put(track.id_renamed, trackBundle);
                this.durationUs = java.lang.Math.max(this.durationUs, track.durationUs);
                i3++;
            }
            maybeInitExtraTracks();
            this.extractorOutput.endTracks();
            return;
        }
        com.google.android.exoplayer2.util.Assertions.checkState(this.trackBundles.size() == size3);
        while (i3 < size3) {
            com.google.android.exoplayer2.extractor.mp4.Track track2 = (com.google.android.exoplayer2.extractor.mp4.Track) sparseArray2.valueAt(i3);
            this.trackBundles.get(track2.id_renamed).init(track2, getDefaultSampleValues(sparseArray, track2.id_renamed));
            i3++;
        }
    }

    private com.google.android.exoplayer2.extractor.mp4.DefaultSampleValues getDefaultSampleValues(android.util.SparseArray<com.google.android.exoplayer2.extractor.mp4.DefaultSampleValues> sparseArray, int i_renamed) {
        if (sparseArray.size() == 1) {
            return sparseArray.valueAt(0);
        }
        return (com.google.android.exoplayer2.extractor.mp4.DefaultSampleValues) com.google.android.exoplayer2.util.Assertions.checkNotNull(sparseArray.get(i_renamed));
    }

    private void onMoofContainerAtomRead(com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom containerAtom) throws com.google.android.exoplayer2.ParserException {
        parseMoof(containerAtom, this.trackBundles, this.flags, this.extendedTypeScratch);
        com.google.android.exoplayer2.drm.DrmInitData drmInitDataFromAtoms = this.sideloadedDrmInitData != null ? null : getDrmInitDataFromAtoms(containerAtom.leafChildren);
        if (drmInitDataFromAtoms != null) {
            int size = this.trackBundles.size();
            for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                this.trackBundles.valueAt(i_renamed).updateDrmInitData(drmInitDataFromAtoms);
            }
        }
        if (this.pendingSeekTimeUs != -9223372036854775807L) {
            int size2 = this.trackBundles.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.trackBundles.valueAt(i2).seek(this.pendingSeekTimeUs);
            }
            this.pendingSeekTimeUs = -9223372036854775807L;
        }
    }

    private void maybeInitExtraTracks() {
        int i_renamed;
        if (this.emsgTrackOutputs == null) {
            this.emsgTrackOutputs = new com.google.android.exoplayer2.extractor.TrackOutput[2];
            com.google.android.exoplayer2.extractor.TrackOutput trackOutput = this.additionalEmsgTrackOutput;
            if (trackOutput != null) {
                this.emsgTrackOutputs[0] = trackOutput;
                i_renamed = 1;
            } else {
                i_renamed = 0;
            }
            if ((this.flags & 4) != 0) {
                this.emsgTrackOutputs[i_renamed] = this.extractorOutput.track(this.trackBundles.size(), 4);
                i_renamed++;
            }
            this.emsgTrackOutputs = (com.google.android.exoplayer2.extractor.TrackOutput[]) java.util.Arrays.copyOf(this.emsgTrackOutputs, i_renamed);
            for (com.google.android.exoplayer2.extractor.TrackOutput trackOutput2 : this.emsgTrackOutputs) {
                trackOutput2.format(EMSG_FORMAT);
            }
        }
        if (this.cea608TrackOutputs == null) {
            this.cea608TrackOutputs = new com.google.android.exoplayer2.extractor.TrackOutput[this.closedCaptionFormats.size()];
            for (int i2 = 0; i2 < this.cea608TrackOutputs.length; i2++) {
                com.google.android.exoplayer2.extractor.TrackOutput trackOutputTrack = this.extractorOutput.track(this.trackBundles.size() + 1 + i2, 3);
                trackOutputTrack.format(this.closedCaptionFormats.get(i2));
                this.cea608TrackOutputs[i2] = trackOutputTrack;
            }
        }
    }

    private void onEmsgLeafAtomRead(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        com.google.android.exoplayer2.extractor.TrackOutput[] trackOutputArr = this.emsgTrackOutputs;
        if (trackOutputArr == null || trackOutputArr.length == 0) {
            return;
        }
        parsableByteArray.setPosition(12);
        int iBytesLeft = parsableByteArray.bytesLeft();
        parsableByteArray.readNullTerminatedString();
        parsableByteArray.readNullTerminatedString();
        long jScaleLargeTimestamp = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(parsableByteArray.readUnsignedInt(), 1000000L, parsableByteArray.readUnsignedInt());
        int position = parsableByteArray.getPosition();
        parsableByteArray.data[position - 4] = 0;
        parsableByteArray.data[position - 3] = 0;
        parsableByteArray.data[position - 2] = 0;
        parsableByteArray.data[position - 1] = 0;
        for (com.google.android.exoplayer2.extractor.TrackOutput trackOutput : this.emsgTrackOutputs) {
            parsableByteArray.setPosition(12);
            trackOutput.sampleData(parsableByteArray, iBytesLeft);
        }
        long j_renamed = this.segmentIndexEarliestPresentationTimeUs;
        if (j_renamed != -9223372036854775807L) {
            long j2 = j_renamed + jScaleLargeTimestamp;
            com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster = this.timestampAdjuster;
            long jAdjustSampleTimestamp = timestampAdjuster != null ? timestampAdjuster.adjustSampleTimestamp(j2) : j2;
            for (com.google.android.exoplayer2.extractor.TrackOutput trackOutput2 : this.emsgTrackOutputs) {
                trackOutput2.sampleMetadata(jAdjustSampleTimestamp, 1, iBytesLeft, 0, null);
            }
            return;
        }
        this.pendingMetadataSampleInfos.addLast(new com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.MetadataSampleInfo(jScaleLargeTimestamp, iBytesLeft));
        this.pendingMetadataSampleBytes += iBytesLeft;
    }

    private static android.util.Pair<java.lang.Integer, com.google.android.exoplayer2.extractor.mp4.DefaultSampleValues> parseTrex(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(12);
        return android.util.Pair.create(java.lang.Integer.valueOf(parsableByteArray.readInt()), new com.google.android.exoplayer2.extractor.mp4.DefaultSampleValues(parsableByteArray.readUnsignedIntToInt() - 1, parsableByteArray.readUnsignedIntToInt(), parsableByteArray.readUnsignedIntToInt(), parsableByteArray.readInt()));
    }

    private static long parseMehd(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        return com.google.android.exoplayer2.extractor.mp4.Atom.parseFullAtomVersion(parsableByteArray.readInt()) == 0 ? parsableByteArray.readUnsignedInt() : parsableByteArray.readUnsignedLongToLong();
    }

    private static void parseMoof(com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom containerAtom, android.util.SparseArray<com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle> sparseArray, int i_renamed, byte[] bArr) throws com.google.android.exoplayer2.ParserException {
        int size = containerAtom.containerChildren.size();
        for (int i2 = 0; i2 < size; i2++) {
            com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom containerAtom2 = containerAtom.containerChildren.get(i2);
            if (containerAtom2.type == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_traf) {
                parseTraf(containerAtom2, sparseArray, i_renamed, bArr);
            }
        }
    }

    private static void parseTraf(com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom containerAtom, android.util.SparseArray<com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle> sparseArray, int i_renamed, byte[] bArr) throws com.google.android.exoplayer2.ParserException {
        com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle tfhd = parseTfhd(containerAtom.getLeafAtomOfType(com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_tfhd).data, sparseArray);
        if (tfhd == null) {
            return;
        }
        com.google.android.exoplayer2.extractor.mp4.TrackFragment trackFragment = tfhd.fragment;
        long tfdt = trackFragment.nextFragmentDecodeTime;
        tfhd.reset();
        if (containerAtom.getLeafAtomOfType(com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_tfdt) != null && (i_renamed & 2) == 0) {
            tfdt = parseTfdt(containerAtom.getLeafAtomOfType(com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_tfdt).data);
        }
        parseTruns(containerAtom, tfhd, tfdt, i_renamed);
        com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox sampleDescriptionEncryptionBox = tfhd.track.getSampleDescriptionEncryptionBox(trackFragment.header.sampleDescriptionIndex);
        com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_saiz);
        if (leafAtomOfType != null) {
            parseSaiz(sampleDescriptionEncryptionBox, leafAtomOfType.data, trackFragment);
        }
        com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom leafAtomOfType2 = containerAtom.getLeafAtomOfType(com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_saio);
        if (leafAtomOfType2 != null) {
            parseSaio(leafAtomOfType2.data, trackFragment);
        }
        com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom leafAtomOfType3 = containerAtom.getLeafAtomOfType(com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_senc);
        if (leafAtomOfType3 != null) {
            parseSenc(leafAtomOfType3.data, trackFragment);
        }
        com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom leafAtomOfType4 = containerAtom.getLeafAtomOfType(com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_sbgp);
        com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom leafAtomOfType5 = containerAtom.getLeafAtomOfType(com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_sgpd);
        if (leafAtomOfType4 != null && leafAtomOfType5 != null) {
            parseSgpd(leafAtomOfType4.data, leafAtomOfType5.data, sampleDescriptionEncryptionBox != null ? sampleDescriptionEncryptionBox.schemeType : null, trackFragment);
        }
        int size = containerAtom.leafChildren.size();
        for (int i2 = 0; i2 < size; i2++) {
            com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom leafAtom = containerAtom.leafChildren.get(i2);
            if (leafAtom.type == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_uuid) {
                parseUuid(leafAtom.data, trackFragment, bArr);
            }
        }
    }

    private static void parseTruns(com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom containerAtom, com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle trackBundle, long j_renamed, int i_renamed) {
        java.util.List<com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom> list = containerAtom.leafChildren;
        int size = list.size();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom leafAtom = list.get(i4);
            if (leafAtom.type == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_trun) {
                com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = leafAtom.data;
                parsableByteArray.setPosition(12);
                int unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
                if (unsignedIntToInt > 0) {
                    i3 += unsignedIntToInt;
                    i2++;
                }
            }
        }
        trackBundle.currentTrackRunIndex = 0;
        trackBundle.currentSampleInTrackRun = 0;
        trackBundle.currentSampleIndex = 0;
        trackBundle.fragment.initTables(i2, i3);
        int i5 = 0;
        int trun = 0;
        for (int i6 = 0; i6 < size; i6++) {
            com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom leafAtom2 = list.get(i6);
            if (leafAtom2.type == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_trun) {
                trun = parseTrun(trackBundle, i5, j_renamed, i_renamed, leafAtom2.data, trun);
                i5++;
            }
        }
    }

    private static void parseSaiz(com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox trackEncryptionBox, com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, com.google.android.exoplayer2.extractor.mp4.TrackFragment trackFragment) throws com.google.android.exoplayer2.ParserException {
        int i_renamed;
        int i2 = trackEncryptionBox.perSampleIvSize;
        parsableByteArray.setPosition(8);
        if ((com.google.android.exoplayer2.extractor.mp4.Atom.parseFullAtomFlags(parsableByteArray.readInt()) & 1) == 1) {
            parsableByteArray.skipBytes(8);
        }
        int unsignedByte = parsableByteArray.readUnsignedByte();
        int unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        if (unsignedIntToInt != trackFragment.sampleCount) {
            throw new com.google.android.exoplayer2.ParserException("Length mismatch: " + unsignedIntToInt + ", " + trackFragment.sampleCount);
        }
        if (unsignedByte == 0) {
            boolean[] zArr = trackFragment.sampleHasSubsampleEncryptionTable;
            i_renamed = 0;
            for (int i3 = 0; i3 < unsignedIntToInt; i3++) {
                int unsignedByte2 = parsableByteArray.readUnsignedByte();
                i_renamed += unsignedByte2;
                zArr[i3] = unsignedByte2 > i2;
            }
        } else {
            i_renamed = (unsignedByte * unsignedIntToInt) + 0;
            java.util.Arrays.fill(trackFragment.sampleHasSubsampleEncryptionTable, 0, unsignedIntToInt, unsignedByte > i2);
        }
        trackFragment.initEncryptionData(i_renamed);
    }

    private static void parseSaio(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, com.google.android.exoplayer2.extractor.mp4.TrackFragment trackFragment) throws com.google.android.exoplayer2.ParserException {
        parsableByteArray.setPosition(8);
        int i_renamed = parsableByteArray.readInt();
        if ((com.google.android.exoplayer2.extractor.mp4.Atom.parseFullAtomFlags(i_renamed) & 1) == 1) {
            parsableByteArray.skipBytes(8);
        }
        int unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        if (unsignedIntToInt != 1) {
            throw new com.google.android.exoplayer2.ParserException("Unexpected saio entry count: " + unsignedIntToInt);
        }
        trackFragment.auxiliaryDataPosition += com.google.android.exoplayer2.extractor.mp4.Atom.parseFullAtomVersion(i_renamed) == 0 ? parsableByteArray.readUnsignedInt() : parsableByteArray.readUnsignedLongToLong();
    }

    private static com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle parseTfhd(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, android.util.SparseArray<com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle> sparseArray) {
        parsableByteArray.setPosition(8);
        int fullAtomFlags = com.google.android.exoplayer2.extractor.mp4.Atom.parseFullAtomFlags(parsableByteArray.readInt());
        com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle trackBundle = getTrackBundle(sparseArray, parsableByteArray.readInt());
        if (trackBundle == null) {
            return null;
        }
        if ((fullAtomFlags & 1) != 0) {
            long unsignedLongToLong = parsableByteArray.readUnsignedLongToLong();
            trackBundle.fragment.dataPosition = unsignedLongToLong;
            trackBundle.fragment.auxiliaryDataPosition = unsignedLongToLong;
        }
        com.google.android.exoplayer2.extractor.mp4.DefaultSampleValues defaultSampleValues = trackBundle.defaultSampleValues;
        trackBundle.fragment.header = new com.google.android.exoplayer2.extractor.mp4.DefaultSampleValues((fullAtomFlags & 2) != 0 ? parsableByteArray.readUnsignedIntToInt() - 1 : defaultSampleValues.sampleDescriptionIndex, (fullAtomFlags & 8) != 0 ? parsableByteArray.readUnsignedIntToInt() : defaultSampleValues.duration, (fullAtomFlags & 16) != 0 ? parsableByteArray.readUnsignedIntToInt() : defaultSampleValues.size, (fullAtomFlags & 32) != 0 ? parsableByteArray.readUnsignedIntToInt() : defaultSampleValues.flags);
        return trackBundle;
    }

    private static com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle getTrackBundle(android.util.SparseArray<com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle> sparseArray, int i_renamed) {
        if (sparseArray.size() == 1) {
            return sparseArray.valueAt(0);
        }
        return sparseArray.get(i_renamed);
    }

    private static long parseTfdt(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        return com.google.android.exoplayer2.extractor.mp4.Atom.parseFullAtomVersion(parsableByteArray.readInt()) == 1 ? parsableByteArray.readUnsignedLongToLong() : parsableByteArray.readUnsignedInt();
    }

    private static int parseTrun(com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle trackBundle, int i_renamed, long j_renamed, int i2, com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i3) {
        boolean[] zArr;
        long[] jArr;
        long j2;
        boolean z_renamed;
        int unsignedIntToInt;
        boolean z2;
        int i4;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        parsableByteArray.setPosition(8);
        int fullAtomFlags = com.google.android.exoplayer2.extractor.mp4.Atom.parseFullAtomFlags(parsableByteArray.readInt());
        com.google.android.exoplayer2.extractor.mp4.Track track = trackBundle.track;
        com.google.android.exoplayer2.extractor.mp4.TrackFragment trackFragment = trackBundle.fragment;
        com.google.android.exoplayer2.extractor.mp4.DefaultSampleValues defaultSampleValues = trackFragment.header;
        trackFragment.trunLength[i_renamed] = parsableByteArray.readUnsignedIntToInt();
        trackFragment.trunDataPosition[i_renamed] = trackFragment.dataPosition;
        if ((fullAtomFlags & 1) != 0) {
            long[] jArr2 = trackFragment.trunDataPosition;
            jArr2[i_renamed] = jArr2[i_renamed] + parsableByteArray.readInt();
        }
        boolean z7 = (fullAtomFlags & 4) != 0;
        int unsignedIntToInt2 = defaultSampleValues.flags;
        if (z7) {
            unsignedIntToInt2 = parsableByteArray.readUnsignedIntToInt();
        }
        boolean z8 = (fullAtomFlags & 256) != 0;
        boolean z9 = (fullAtomFlags & 512) != 0;
        boolean z10 = (fullAtomFlags & 1024) != 0;
        boolean z11 = (fullAtomFlags & 2048) != 0;
        long jScaleLargeTimestamp = 0;
        if (track.editListDurations != null && track.editListDurations.length == 1 && track.editListDurations[0] == 0) {
            jScaleLargeTimestamp = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(track.editListMediaTimes[0], 1000L, track.timescale);
        }
        int[] iArr = trackFragment.sampleSizeTable;
        int[] iArr2 = trackFragment.sampleCompositionTimeOffsetTable;
        long[] jArr3 = trackFragment.sampleDecodingTimeTable;
        boolean[] zArr2 = trackFragment.sampleIsSyncFrameTable;
        int i5 = unsignedIntToInt2;
        boolean z12 = track.type == 2 && (i2 & 1) != 0;
        int i6 = i3 + trackFragment.trunLength[i_renamed];
        long j3 = jScaleLargeTimestamp;
        long j4 = track.timescale;
        if (i_renamed > 0) {
            zArr = zArr2;
            jArr = jArr3;
            j2 = trackFragment.nextFragmentDecodeTime;
        } else {
            zArr = zArr2;
            jArr = jArr3;
            j2 = j_renamed;
        }
        long j5 = j2;
        int i7 = i3;
        while (i7 < i6) {
            int unsignedIntToInt3 = z8 ? parsableByteArray.readUnsignedIntToInt() : defaultSampleValues.duration;
            if (z9) {
                z_renamed = z8;
                unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            } else {
                z_renamed = z8;
                unsignedIntToInt = defaultSampleValues.size;
            }
            if (i7 == 0 && z7) {
                z2 = z7;
                i4 = i5;
            } else if (z10) {
                z2 = z7;
                i4 = parsableByteArray.readInt();
            } else {
                z2 = z7;
                i4 = defaultSampleValues.flags;
            }
            if (z11) {
                z3 = z11;
                z4 = z9;
                z5 = z10;
                iArr2[i7] = (int) ((parsableByteArray.readInt() * 1000) / j4);
                z6 = false;
            } else {
                z3 = z11;
                z4 = z9;
                z5 = z10;
                z6 = false;
                iArr2[i7] = 0;
            }
            jArr[i7] = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(j5, 1000L, j4) - j3;
            iArr[i7] = unsignedIntToInt;
            zArr[i7] = (((i4 >> 16) & 1) != 0 || (z12 && i7 != 0)) ? z6 : true;
            i7++;
            j5 += unsignedIntToInt3;
            z8 = z_renamed;
            z7 = z2;
            z11 = z3;
            z9 = z4;
            z10 = z5;
            i6 = i6;
        }
        int i8 = i6;
        trackFragment.nextFragmentDecodeTime = j5;
        return i8;
    }

    private static void parseUuid(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, com.google.android.exoplayer2.extractor.mp4.TrackFragment trackFragment, byte[] bArr) throws com.google.android.exoplayer2.ParserException {
        parsableByteArray.setPosition(8);
        parsableByteArray.readBytes(bArr, 0, 16);
        if (java.util.Arrays.equals(bArr, PIFF_SAMPLE_ENCRYPTION_BOX_EXTENDED_TYPE)) {
            parseSenc(parsableByteArray, 16, trackFragment);
        }
    }

    private static void parseSenc(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, com.google.android.exoplayer2.extractor.mp4.TrackFragment trackFragment) throws com.google.android.exoplayer2.ParserException {
        parseSenc(parsableByteArray, 0, trackFragment);
    }

    private static void parseSenc(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i_renamed, com.google.android.exoplayer2.extractor.mp4.TrackFragment trackFragment) throws com.google.android.exoplayer2.ParserException {
        parsableByteArray.setPosition(i_renamed + 8);
        int fullAtomFlags = com.google.android.exoplayer2.extractor.mp4.Atom.parseFullAtomFlags(parsableByteArray.readInt());
        if ((fullAtomFlags & 1) != 0) {
            throw new com.google.android.exoplayer2.ParserException("Overriding TrackEncryptionBox parameters is_renamed unsupported.");
        }
        boolean z_renamed = (fullAtomFlags & 2) != 0;
        int unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        if (unsignedIntToInt != trackFragment.sampleCount) {
            throw new com.google.android.exoplayer2.ParserException("Length mismatch: " + unsignedIntToInt + ", " + trackFragment.sampleCount);
        }
        java.util.Arrays.fill(trackFragment.sampleHasSubsampleEncryptionTable, 0, unsignedIntToInt, z_renamed);
        trackFragment.initEncryptionData(parsableByteArray.bytesLeft());
        trackFragment.fillEncryptionData(parsableByteArray);
    }

    private static void parseSgpd(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray2, java.lang.String str, com.google.android.exoplayer2.extractor.mp4.TrackFragment trackFragment) throws com.google.android.exoplayer2.ParserException {
        byte[] bArr;
        parsableByteArray.setPosition(8);
        int i_renamed = parsableByteArray.readInt();
        if (parsableByteArray.readInt() != SAMPLE_GROUP_TYPE_seig) {
            return;
        }
        if (com.google.android.exoplayer2.extractor.mp4.Atom.parseFullAtomVersion(i_renamed) == 1) {
            parsableByteArray.skipBytes(4);
        }
        if (parsableByteArray.readInt() != 1) {
            throw new com.google.android.exoplayer2.ParserException("Entry count in_renamed sbgp != 1 (unsupported).");
        }
        parsableByteArray2.setPosition(8);
        int i2 = parsableByteArray2.readInt();
        if (parsableByteArray2.readInt() != SAMPLE_GROUP_TYPE_seig) {
            return;
        }
        int fullAtomVersion = com.google.android.exoplayer2.extractor.mp4.Atom.parseFullAtomVersion(i2);
        if (fullAtomVersion == 1) {
            if (parsableByteArray2.readUnsignedInt() == 0) {
                throw new com.google.android.exoplayer2.ParserException("Variable length description in_renamed sgpd found (unsupported)");
            }
        } else if (fullAtomVersion >= 2) {
            parsableByteArray2.skipBytes(4);
        }
        if (parsableByteArray2.readUnsignedInt() != 1) {
            throw new com.google.android.exoplayer2.ParserException("Entry count in_renamed sgpd != 1 (unsupported).");
        }
        parsableByteArray2.skipBytes(1);
        int unsignedByte = parsableByteArray2.readUnsignedByte();
        int i3 = (unsignedByte & 240) >> 4;
        int i4 = unsignedByte & 15;
        boolean z_renamed = parsableByteArray2.readUnsignedByte() == 1;
        if (z_renamed) {
            int unsignedByte2 = parsableByteArray2.readUnsignedByte();
            byte[] bArr2 = new byte[16];
            parsableByteArray2.readBytes(bArr2, 0, bArr2.length);
            if (z_renamed && unsignedByte2 == 0) {
                int unsignedByte3 = parsableByteArray2.readUnsignedByte();
                byte[] bArr3 = new byte[unsignedByte3];
                parsableByteArray2.readBytes(bArr3, 0, unsignedByte3);
                bArr = bArr3;
            } else {
                bArr = null;
            }
            trackFragment.definesEncryptionData = true;
            trackFragment.trackEncryptionBox = new com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox(z_renamed, str, unsignedByte2, bArr2, i3, i4, bArr);
        }
    }

    private static android.util.Pair<java.lang.Long, com.google.android.exoplayer2.extractor.ChunkIndex> parseSidx(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, long j_renamed) throws com.google.android.exoplayer2.ParserException {
        long unsignedLongToLong;
        long unsignedLongToLong2;
        parsableByteArray.setPosition(8);
        int fullAtomVersion = com.google.android.exoplayer2.extractor.mp4.Atom.parseFullAtomVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(4);
        long unsignedInt = parsableByteArray.readUnsignedInt();
        if (fullAtomVersion == 0) {
            unsignedLongToLong = parsableByteArray.readUnsignedInt();
            unsignedLongToLong2 = parsableByteArray.readUnsignedInt();
        } else {
            unsignedLongToLong = parsableByteArray.readUnsignedLongToLong();
            unsignedLongToLong2 = parsableByteArray.readUnsignedLongToLong();
        }
        long j2 = unsignedLongToLong;
        long j3 = j_renamed + unsignedLongToLong2;
        long jScaleLargeTimestamp = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(j2, 1000000L, unsignedInt);
        parsableByteArray.skipBytes(2);
        int unsignedShort = parsableByteArray.readUnsignedShort();
        int[] iArr = new int[unsignedShort];
        long[] jArr = new long[unsignedShort];
        long[] jArr2 = new long[unsignedShort];
        long[] jArr3 = new long[unsignedShort];
        long j4 = j2;
        int i_renamed = 0;
        long jScaleLargeTimestamp2 = jScaleLargeTimestamp;
        while (i_renamed < unsignedShort) {
            int i2 = parsableByteArray.readInt();
            if ((i2 & Integer.MIN_VALUE) != 0) {
                throw new com.google.android.exoplayer2.ParserException("Unhandled indirect reference");
            }
            long unsignedInt2 = parsableByteArray.readUnsignedInt();
            iArr[i_renamed] = i2 & Integer.MAX_VALUE;
            jArr[i_renamed] = j3;
            jArr3[i_renamed] = jScaleLargeTimestamp2;
            j4 += unsignedInt2;
            long[] jArr4 = jArr2;
            long[] jArr5 = jArr3;
            int i3 = unsignedShort;
            jScaleLargeTimestamp2 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(j4, 1000000L, unsignedInt);
            jArr4[i_renamed] = jScaleLargeTimestamp2 - jArr5[i_renamed];
            parsableByteArray.skipBytes(4);
            j3 += r1[i_renamed];
            i_renamed++;
            iArr = iArr;
            jArr3 = jArr5;
            jArr2 = jArr4;
            jArr = jArr;
            unsignedShort = i3;
        }
        return android.util.Pair.create(java.lang.Long.valueOf(jScaleLargeTimestamp), new com.google.android.exoplayer2.extractor.ChunkIndex(iArr, jArr, jArr2, jArr3));
    }

    private void readEncryptionData(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        int size = this.trackBundles.size();
        com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle trackBundleValueAt = null;
        long j_renamed = Long.MAX_VALUE;
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            com.google.android.exoplayer2.extractor.mp4.TrackFragment trackFragment = this.trackBundles.valueAt(i_renamed).fragment;
            if (trackFragment.sampleEncryptionDataNeedsFill && trackFragment.auxiliaryDataPosition < j_renamed) {
                long j2 = trackFragment.auxiliaryDataPosition;
                trackBundleValueAt = this.trackBundles.valueAt(i_renamed);
                j_renamed = j2;
            }
        }
        if (trackBundleValueAt == null) {
            this.parserState = 3;
            return;
        }
        int position = (int) (j_renamed - extractorInput.getPosition());
        if (position < 0) {
            throw new com.google.android.exoplayer2.ParserException("Offset to encryption data was negative.");
        }
        extractorInput.skipFully(position);
        trackBundleValueAt.fragment.fillEncryptionData(extractorInput);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean readSample(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        int i_renamed;
        com.google.android.exoplayer2.extractor.TrackOutput.CryptoData cryptoData;
        int iSampleData;
        int i2 = 4;
        int i3 = 1;
        int i4 = 0;
        if (this.parserState == 3) {
            if (this.currentTrackBundle == null) {
                com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle nextFragmentRun = getNextFragmentRun(this.trackBundles);
                if (nextFragmentRun == null) {
                    int position = (int) (this.endOfMdatPosition - extractorInput.getPosition());
                    if (position < 0) {
                        throw new com.google.android.exoplayer2.ParserException("Offset to end of_renamed mdat was negative.");
                    }
                    extractorInput.skipFully(position);
                    enterReadingAtomHeaderState();
                    return false;
                }
                int position2 = (int) (nextFragmentRun.fragment.trunDataPosition[nextFragmentRun.currentTrackRunIndex] - extractorInput.getPosition());
                if (position2 < 0) {
                    com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Ignoring negative offset to sample data.");
                    position2 = 0;
                }
                extractorInput.skipFully(position2);
                this.currentTrackBundle = nextFragmentRun;
            }
            this.sampleSize = this.currentTrackBundle.fragment.sampleSizeTable[this.currentTrackBundle.currentSampleIndex];
            if (this.currentTrackBundle.currentSampleIndex < this.currentTrackBundle.firstSampleToOutputIndex) {
                extractorInput.skipFully(this.sampleSize);
                this.currentTrackBundle.skipSampleEncryptionData();
                if (!this.currentTrackBundle.next()) {
                    this.currentTrackBundle = null;
                }
                this.parserState = 3;
                return true;
            }
            if (this.currentTrackBundle.track.sampleTransformation == 1) {
                this.sampleSize -= 8;
                extractorInput.skipFully(8);
            }
            this.sampleBytesWritten = this.currentTrackBundle.outputSampleEncryptionData();
            this.sampleSize += this.sampleBytesWritten;
            this.parserState = 4;
            this.sampleCurrentNalBytesRemaining = 0;
            this.isAc4HeaderAdded = false;
        }
        com.google.android.exoplayer2.extractor.mp4.TrackFragment trackFragment = this.currentTrackBundle.fragment;
        com.google.android.exoplayer2.extractor.mp4.Track track = this.currentTrackBundle.track;
        com.google.android.exoplayer2.extractor.TrackOutput trackOutput = this.currentTrackBundle.output;
        int i5 = this.currentTrackBundle.currentSampleIndex;
        long samplePresentationTime = trackFragment.getSamplePresentationTime(i5) * 1000;
        com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster = this.timestampAdjuster;
        if (timestampAdjuster != null) {
            samplePresentationTime = timestampAdjuster.adjustSampleTimestamp(samplePresentationTime);
        }
        long j_renamed = samplePresentationTime;
        if (track.nalUnitLengthFieldLength != 0) {
            byte[] bArr = this.nalPrefix.data;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i6 = track.nalUnitLengthFieldLength + 1;
            int i7 = 4 - track.nalUnitLengthFieldLength;
            while (this.sampleBytesWritten < this.sampleSize) {
                int i8 = this.sampleCurrentNalBytesRemaining;
                if (i8 == 0) {
                    extractorInput.readFully(bArr, i7, i6);
                    this.nalPrefix.setPosition(i4);
                    this.sampleCurrentNalBytesRemaining = this.nalPrefix.readUnsignedIntToInt() - i3;
                    this.nalStartCode.setPosition(i4);
                    trackOutput.sampleData(this.nalStartCode, i2);
                    trackOutput.sampleData(this.nalPrefix, i3);
                    this.processSeiNalUnitPayload = (this.cea608TrackOutputs.length <= 0 || !com.google.android.exoplayer2.util.NalUnitUtil.isNalUnitSei(track.format.sampleMimeType, bArr[i2])) ? i4 : i3;
                    this.sampleBytesWritten += 5;
                    this.sampleSize += i7;
                } else {
                    if (this.processSeiNalUnitPayload) {
                        this.nalBuffer.reset(i8);
                        extractorInput.readFully(this.nalBuffer.data, i4, this.sampleCurrentNalBytesRemaining);
                        trackOutput.sampleData(this.nalBuffer, this.sampleCurrentNalBytesRemaining);
                        iSampleData = this.sampleCurrentNalBytesRemaining;
                        int iUnescapeStream = com.google.android.exoplayer2.util.NalUnitUtil.unescapeStream(this.nalBuffer.data, this.nalBuffer.limit());
                        this.nalBuffer.setPosition(com.google.android.exoplayer2.util.MimeTypes.VIDEO_H265.equals(track.format.sampleMimeType) ? 1 : 0);
                        this.nalBuffer.setLimit(iUnescapeStream);
                        com.google.android.exoplayer2.text.cea.CeaUtil.consume(j_renamed, this.nalBuffer, this.cea608TrackOutputs);
                    } else {
                        iSampleData = trackOutput.sampleData(extractorInput, i8, i4);
                    }
                    this.sampleBytesWritten += iSampleData;
                    this.sampleCurrentNalBytesRemaining -= iSampleData;
                    i2 = 4;
                    i3 = 1;
                    i4 = 0;
                }
            }
        } else {
            if (com.google.android.exoplayer2.util.MimeTypes.AUDIO_AC4.equals(track.format.sampleMimeType) && !this.isAc4HeaderAdded) {
                com.google.android.exoplayer2.util.ParsableByteArray ac4SampleHeader = com.google.android.exoplayer2.audio.Ac4Util.getAc4SampleHeader(this.sampleSize);
                trackOutput.sampleData(ac4SampleHeader, ac4SampleHeader.capacity());
                this.ac4SampleHeaderSize = ac4SampleHeader.capacity();
                this.isAc4HeaderAdded = true;
            }
            while (true) {
                int i9 = this.sampleBytesWritten;
                int i10 = this.sampleSize;
                if (i9 >= i10) {
                    break;
                }
                this.sampleBytesWritten += trackOutput.sampleData(extractorInput, i10 - i9, false);
            }
            if (com.google.android.exoplayer2.util.MimeTypes.AUDIO_AC4.equals(track.format.sampleMimeType)) {
                this.sampleSize += this.ac4SampleHeaderSize;
                this.isAc4HeaderAdded = false;
            }
        }
        boolean z_renamed = trackFragment.sampleIsSyncFrameTable[i5];
        com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox encryptionBoxIfEncrypted = this.currentTrackBundle.getEncryptionBoxIfEncrypted();
        if (encryptionBoxIfEncrypted != null) {
            i_renamed = (z_renamed ? 1 : 0) | 1073741824;
            cryptoData = encryptionBoxIfEncrypted.cryptoData;
        } else {
            i_renamed = z_renamed ? 1 : 0;
            cryptoData = null;
        }
        trackOutput.sampleMetadata(j_renamed, i_renamed, this.sampleSize, 0, cryptoData);
        outputPendingMetadataSamples(j_renamed);
        if (!this.currentTrackBundle.next()) {
            this.currentTrackBundle = null;
        }
        this.parserState = 3;
        return true;
    }

    private void outputPendingMetadataSamples(long j_renamed) {
        while (!this.pendingMetadataSampleInfos.isEmpty()) {
            com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.MetadataSampleInfo metadataSampleInfoRemoveFirst = this.pendingMetadataSampleInfos.removeFirst();
            this.pendingMetadataSampleBytes -= metadataSampleInfoRemoveFirst.size;
            long jAdjustSampleTimestamp = metadataSampleInfoRemoveFirst.presentationTimeDeltaUs + j_renamed;
            com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster = this.timestampAdjuster;
            if (timestampAdjuster != null) {
                jAdjustSampleTimestamp = timestampAdjuster.adjustSampleTimestamp(jAdjustSampleTimestamp);
            }
            for (com.google.android.exoplayer2.extractor.TrackOutput trackOutput : this.emsgTrackOutputs) {
                trackOutput.sampleMetadata(jAdjustSampleTimestamp, 1, metadataSampleInfoRemoveFirst.size, this.pendingMetadataSampleBytes, null);
            }
        }
    }

    private static com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle getNextFragmentRun(android.util.SparseArray<com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle> sparseArray) {
        int size = sparseArray.size();
        com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle trackBundle = null;
        long j_renamed = Long.MAX_VALUE;
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle trackBundleValueAt = sparseArray.valueAt(i_renamed);
            if (trackBundleValueAt.currentTrackRunIndex != trackBundleValueAt.fragment.trunCount) {
                long j2 = trackBundleValueAt.fragment.trunDataPosition[trackBundleValueAt.currentTrackRunIndex];
                if (j2 < j_renamed) {
                    trackBundle = trackBundleValueAt;
                    j_renamed = j2;
                }
            }
        }
        return trackBundle;
    }

    private static com.google.android.exoplayer2.drm.DrmInitData getDrmInitDataFromAtoms(java.util.List<com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom> list) {
        int size = list.size();
        java.util.ArrayList arrayList = null;
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom leafAtom = list.get(i_renamed);
            if (leafAtom.type == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_pssh) {
                if (arrayList == null) {
                    arrayList = new java.util.ArrayList();
                }
                byte[] bArr = leafAtom.data.data;
                java.util.UUID uuid = com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil.parseUuid(bArr);
                if (uuid == null) {
                    com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new com.google.android.exoplayer2.drm.DrmInitData.SchemeData(uuid, com.google.android.exoplayer2.util.MimeTypes.VIDEO_MP4, bArr));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new com.google.android.exoplayer2.drm.DrmInitData(arrayList);
    }

    private static boolean shouldParseLeafAtom(int i_renamed) {
        return i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_hdlr || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_mdhd || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_mvhd || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_sidx || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_stsd || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_tfdt || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_tfhd || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_tkhd || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_trex || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_trun || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_pssh || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_saiz || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_saio || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_senc || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_uuid || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_sbgp || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_sgpd || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_elst || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_mehd || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_emsg;
    }

    private static boolean shouldParseContainerAtom(int i_renamed) {
        return i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_moov || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_trak || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_mdia || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_minf || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_stbl || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_moof || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_traf || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_mvex || i_renamed == com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_edts;
    }

    private static final class MetadataSampleInfo {
        public final long presentationTimeDeltaUs;
        public final int size;

        public MetadataSampleInfo(long j_renamed, int i_renamed) {
            this.presentationTimeDeltaUs = j_renamed;
            this.size = i_renamed;
        }
    }

    private static final class TrackBundle {
        public int currentSampleInTrackRun;
        public int currentSampleIndex;
        public int currentTrackRunIndex;
        public com.google.android.exoplayer2.extractor.mp4.DefaultSampleValues defaultSampleValues;
        public int firstSampleToOutputIndex;
        public final com.google.android.exoplayer2.extractor.TrackOutput output;
        public com.google.android.exoplayer2.extractor.mp4.Track track;
        public final com.google.android.exoplayer2.extractor.mp4.TrackFragment fragment = new com.google.android.exoplayer2.extractor.mp4.TrackFragment();
        private final com.google.android.exoplayer2.util.ParsableByteArray encryptionSignalByte = new com.google.android.exoplayer2.util.ParsableByteArray(1);
        private final com.google.android.exoplayer2.util.ParsableByteArray defaultInitializationVector = new com.google.android.exoplayer2.util.ParsableByteArray();

        public TrackBundle(com.google.android.exoplayer2.extractor.TrackOutput trackOutput) {
            this.output = trackOutput;
        }

        public void init(com.google.android.exoplayer2.extractor.mp4.Track track, com.google.android.exoplayer2.extractor.mp4.DefaultSampleValues defaultSampleValues) {
            this.track = (com.google.android.exoplayer2.extractor.mp4.Track) com.google.android.exoplayer2.util.Assertions.checkNotNull(track);
            this.defaultSampleValues = (com.google.android.exoplayer2.extractor.mp4.DefaultSampleValues) com.google.android.exoplayer2.util.Assertions.checkNotNull(defaultSampleValues);
            this.output.format(track.format);
            reset();
        }

        public void updateDrmInitData(com.google.android.exoplayer2.drm.DrmInitData drmInitData) {
            com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox sampleDescriptionEncryptionBox = this.track.getSampleDescriptionEncryptionBox(this.fragment.header.sampleDescriptionIndex);
            this.output.format(this.track.format.copyWithDrmInitData(drmInitData.copyWithSchemeType(sampleDescriptionEncryptionBox != null ? sampleDescriptionEncryptionBox.schemeType : null)));
        }

        public void reset() {
            this.fragment.reset();
            this.currentSampleIndex = 0;
            this.currentTrackRunIndex = 0;
            this.currentSampleInTrackRun = 0;
            this.firstSampleToOutputIndex = 0;
        }

        public void seek(long j_renamed) {
            long jUsToMs = com.google.android.exoplayer2.C_renamed.usToMs(j_renamed);
            for (int i_renamed = this.currentSampleIndex; i_renamed < this.fragment.sampleCount && this.fragment.getSamplePresentationTime(i_renamed) < jUsToMs; i_renamed++) {
                if (this.fragment.sampleIsSyncFrameTable[i_renamed]) {
                    this.firstSampleToOutputIndex = i_renamed;
                }
            }
        }

        public boolean next() {
            this.currentSampleIndex++;
            this.currentSampleInTrackRun++;
            int i_renamed = this.currentSampleInTrackRun;
            int[] iArr = this.fragment.trunLength;
            int i2 = this.currentTrackRunIndex;
            if (i_renamed != iArr[i2]) {
                return true;
            }
            this.currentTrackRunIndex = i2 + 1;
            this.currentSampleInTrackRun = 0;
            return false;
        }

        public int outputSampleEncryptionData() {
            com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray;
            int length;
            com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox encryptionBoxIfEncrypted = getEncryptionBoxIfEncrypted();
            if (encryptionBoxIfEncrypted == null) {
                return 0;
            }
            if (encryptionBoxIfEncrypted.perSampleIvSize != 0) {
                parsableByteArray = this.fragment.sampleEncryptionData;
                length = encryptionBoxIfEncrypted.perSampleIvSize;
            } else {
                byte[] bArr = encryptionBoxIfEncrypted.defaultInitializationVector;
                this.defaultInitializationVector.reset(bArr, bArr.length);
                parsableByteArray = this.defaultInitializationVector;
                length = bArr.length;
            }
            boolean zSampleHasSubsampleEncryptionTable = this.fragment.sampleHasSubsampleEncryptionTable(this.currentSampleIndex);
            this.encryptionSignalByte.data[0] = (byte) ((zSampleHasSubsampleEncryptionTable ? 128 : 0) | length);
            this.encryptionSignalByte.setPosition(0);
            this.output.sampleData(this.encryptionSignalByte, 1);
            this.output.sampleData(parsableByteArray, length);
            if (!zSampleHasSubsampleEncryptionTable) {
                return length + 1;
            }
            com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray2 = this.fragment.sampleEncryptionData;
            int unsignedShort = parsableByteArray2.readUnsignedShort();
            parsableByteArray2.skipBytes(-2);
            int i_renamed = (unsignedShort * 6) + 2;
            this.output.sampleData(parsableByteArray2, i_renamed);
            return length + 1 + i_renamed;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void skipSampleEncryptionData() {
            com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox encryptionBoxIfEncrypted = getEncryptionBoxIfEncrypted();
            if (encryptionBoxIfEncrypted == null) {
                return;
            }
            com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = this.fragment.sampleEncryptionData;
            if (encryptionBoxIfEncrypted.perSampleIvSize != 0) {
                parsableByteArray.skipBytes(encryptionBoxIfEncrypted.perSampleIvSize);
            }
            if (this.fragment.sampleHasSubsampleEncryptionTable(this.currentSampleIndex)) {
                parsableByteArray.skipBytes(parsableByteArray.readUnsignedShort() * 6);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox getEncryptionBoxIfEncrypted() {
            com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox sampleDescriptionEncryptionBox = this.fragment.trackEncryptionBox != null ? this.fragment.trackEncryptionBox : this.track.getSampleDescriptionEncryptionBox(this.fragment.header.sampleDescriptionIndex);
            if (sampleDescriptionEncryptionBox == null || !sampleDescriptionEncryptionBox.isEncrypted) {
                return null;
            }
            return sampleDescriptionEncryptionBox;
        }
    }
}
