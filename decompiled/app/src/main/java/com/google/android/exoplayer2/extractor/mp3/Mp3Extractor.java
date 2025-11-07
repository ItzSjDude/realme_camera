package com.google.android.exoplayer2.extractor.mp3;

/* loaded from: classes.dex */
public final class Mp3Extractor implements com.google.android.exoplayer2.extractor.Extractor {
    public static final int FLAG_DISABLE_ID3_METADATA = 2;
    public static final int FLAG_ENABLE_CONSTANT_BITRATE_SEEKING = 1;
    private static final int MAX_SNIFF_BYTES = 16384;
    private static final int MAX_SYNC_BYTES = 131072;
    private static final int MPEG_AUDIO_HEADER_MASK = -128000;
    private static final int SCRATCH_LENGTH = 10;
    private static final int SEEK_HEADER_UNSET = 0;
    private long basisTimeUs;
    private com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput;
    private final int flags;
    private final long forcedFirstSampleTimestampUs;
    private final com.google.android.exoplayer2.extractor.GaplessInfoHolder gaplessInfoHolder;
    private final com.google.android.exoplayer2.extractor.Id3Peeker id3Peeker;
    private com.google.android.exoplayer2.metadata.Metadata metadata;
    private int sampleBytesRemaining;
    private long samplesRead;
    private final com.google.android.exoplayer2.util.ParsableByteArray scratch;
    private com.google.android.exoplayer2.extractor.mp3.Mp3Extractor.Seeker seeker;
    private final com.google.android.exoplayer2.extractor.MpegAudioHeader synchronizedHeader;
    private int synchronizedHeaderData;
    private com.google.android.exoplayer2.extractor.TrackOutput trackOutput;
    public static final com.google.android.exoplayer2.extractor.ExtractorsFactory FACTORY = new com.google.android.exoplayer2.extractor.ExtractorsFactory() { // from class: com.google.android.exoplayer2.extractor.mp3.-$$Lambda$Mp3Extractor$6eyGfoogMVGFHZKg1gVp93FAKZA
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public final com.google.android.exoplayer2.extractor.Extractor[] createExtractors() {
            return com.google.android.exoplayer2.extractor.mp3.Mp3Extractor.lambda$static$0();
        }
    };
    private static final com.google.android.exoplayer2.metadata.id3.Id3Decoder.FramePredicate REQUIRED_ID3_FRAME_PREDICATE = new com.google.android.exoplayer2.metadata.id3.Id3Decoder.FramePredicate() { // from class: com.google.android.exoplayer2.extractor.mp3.-$$Lambda$Mp3Extractor$bb754AZIAMUosKBF4SefP1vYq88
        @Override // com.google.android.exoplayer2.metadata.id3.Id3Decoder.FramePredicate
        public final boolean evaluate(int i_renamed, int i2, int i3, int i4, int i5) {
            return com.google.android.exoplayer2.extractor.mp3.Mp3Extractor.lambda$static$1(i_renamed, i2, i3, i4, i5);
        }
    };
    private static final int SEEK_HEADER_XING = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("Xing");
    private static final int SEEK_HEADER_INFO = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("Info");
    private static final int SEEK_HEADER_VBRI = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("VBRI");

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    interface Seeker extends com.google.android.exoplayer2.extractor.SeekMap {
        long getDataEndPosition();

        long getTimeUs(long j_renamed);
    }

    private static boolean headersMatch(int i_renamed, long j_renamed) {
        return ((long) (i_renamed & MPEG_AUDIO_HEADER_MASK)) == (j_renamed & (-128000));
    }

    static /* synthetic */ boolean lambda$static$1(int i_renamed, int i2, int i3, int i4, int i5) {
        return (i2 == 67 && i3 == 79 && i4 == 77 && (i5 == 77 || i_renamed == 2)) || (i2 == 77 && i3 == 76 && i4 == 76 && (i5 == 84 || i_renamed == 2));
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    static /* synthetic */ com.google.android.exoplayer2.extractor.Extractor[] lambda$static$0() {
        return new com.google.android.exoplayer2.extractor.Extractor[]{new com.google.android.exoplayer2.extractor.mp3.Mp3Extractor()};
    }

    public Mp3Extractor() {
        this(0);
    }

    public Mp3Extractor(int i_renamed) {
        this(i_renamed, -9223372036854775807L);
    }

    public Mp3Extractor(int i_renamed, long j_renamed) {
        this.flags = i_renamed;
        this.forcedFirstSampleTimestampUs = j_renamed;
        this.scratch = new com.google.android.exoplayer2.util.ParsableByteArray(10);
        this.synchronizedHeader = new com.google.android.exoplayer2.extractor.MpegAudioHeader();
        this.gaplessInfoHolder = new com.google.android.exoplayer2.extractor.GaplessInfoHolder();
        this.basisTimeUs = -9223372036854775807L;
        this.id3Peeker = new com.google.android.exoplayer2.extractor.Id3Peeker();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        return synchronize(extractorInput, true);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput) {
        this.extractorOutput = extractorOutput;
        this.trackOutput = this.extractorOutput.track(0, 1);
        this.extractorOutput.endTracks();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j_renamed, long j2) {
        this.synchronizedHeaderData = 0;
        this.basisTimeUs = -9223372036854775807L;
        this.samplesRead = 0L;
        this.sampleBytesRemaining = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder) throws java.lang.InterruptedException, java.io.IOException {
        if (this.synchronizedHeaderData == 0) {
            try {
                synchronize(extractorInput, false);
            } catch (java.io.EOFException unused) {
                return -1;
            }
        }
        if (this.seeker == null) {
            com.google.android.exoplayer2.extractor.mp3.Mp3Extractor.Seeker seekerMaybeReadSeekFrame = maybeReadSeekFrame(extractorInput);
            com.google.android.exoplayer2.extractor.mp3.MlltSeeker mlltSeekerMaybeHandleSeekMetadata = maybeHandleSeekMetadata(this.metadata, extractorInput.getPosition());
            if (mlltSeekerMaybeHandleSeekMetadata != null) {
                this.seeker = mlltSeekerMaybeHandleSeekMetadata;
            } else if (seekerMaybeReadSeekFrame != null) {
                this.seeker = seekerMaybeReadSeekFrame;
            }
            com.google.android.exoplayer2.extractor.mp3.Mp3Extractor.Seeker seeker = this.seeker;
            if (seeker == null || (!seeker.isSeekable() && (this.flags & 1) != 0)) {
                this.seeker = getConstantBitrateSeeker(extractorInput);
            }
            this.extractorOutput.seekMap(this.seeker);
            this.trackOutput.format(com.google.android.exoplayer2.Format.createAudioSampleFormat(null, this.synchronizedHeader.mimeType, null, -1, 4096, this.synchronizedHeader.channels, this.synchronizedHeader.sampleRate, -1, this.gaplessInfoHolder.encoderDelay, this.gaplessInfoHolder.encoderPadding, null, null, 0, null, (this.flags & 2) != 0 ? null : this.metadata));
        }
        return readSample(extractorInput);
    }

    private int readSample(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        if (this.sampleBytesRemaining == 0) {
            extractorInput.resetPeekPosition();
            if (peekEndOfStreamOrHeader(extractorInput)) {
                return -1;
            }
            this.scratch.setPosition(0);
            int i_renamed = this.scratch.readInt();
            if (!headersMatch(i_renamed, this.synchronizedHeaderData) || com.google.android.exoplayer2.extractor.MpegAudioHeader.getFrameSize(i_renamed) == -1) {
                extractorInput.skipFully(1);
                this.synchronizedHeaderData = 0;
                return 0;
            }
            com.google.android.exoplayer2.extractor.MpegAudioHeader.populateHeader(i_renamed, this.synchronizedHeader);
            if (this.basisTimeUs == -9223372036854775807L) {
                this.basisTimeUs = this.seeker.getTimeUs(extractorInput.getPosition());
                if (this.forcedFirstSampleTimestampUs != -9223372036854775807L) {
                    this.basisTimeUs += this.forcedFirstSampleTimestampUs - this.seeker.getTimeUs(0L);
                }
            }
            this.sampleBytesRemaining = this.synchronizedHeader.frameSize;
        }
        int iSampleData = this.trackOutput.sampleData(extractorInput, this.sampleBytesRemaining, true);
        if (iSampleData == -1) {
            return -1;
        }
        this.sampleBytesRemaining -= iSampleData;
        if (this.sampleBytesRemaining > 0) {
            return 0;
        }
        this.trackOutput.sampleMetadata(this.basisTimeUs + ((this.samplesRead * 1000000) / this.synchronizedHeader.sampleRate), 1, this.synchronizedHeader.frameSize, 0, null);
        this.samplesRead += this.synchronizedHeader.samplesPerFrame;
        this.sampleBytesRemaining = 0;
        return 0;
    }

    private boolean synchronize(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, boolean z_renamed) throws java.lang.InterruptedException, java.io.IOException {
        int i_renamed;
        int i2;
        int i3;
        int i4;
        int frameSize;
        int i5 = z_renamed ? 16384 : 131072;
        extractorInput.resetPeekPosition();
        if (extractorInput.getPosition() == 0) {
            this.metadata = this.id3Peeker.peekId3Data(extractorInput, (this.flags & 2) == 0 ? null : REQUIRED_ID3_FRAME_PREDICATE);
            com.google.android.exoplayer2.metadata.Metadata metadata = this.metadata;
            if (metadata != null) {
                this.gaplessInfoHolder.setFromMetadata(metadata);
            }
            int peekPosition = (int) extractorInput.getPeekPosition();
            if (!z_renamed) {
                extractorInput.skipFully(peekPosition);
            }
            i4 = peekPosition;
            i_renamed = 0;
            i2 = 0;
            i3 = 0;
        } else {
            i_renamed = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
        }
        while (true) {
            if (!peekEndOfStreamOrHeader(extractorInput)) {
                this.scratch.setPosition(0);
                int i6 = this.scratch.readInt();
                if ((i_renamed == 0 || headersMatch(i6, i_renamed)) && (frameSize = com.google.android.exoplayer2.extractor.MpegAudioHeader.getFrameSize(i6)) != -1) {
                    i2++;
                    if (i2 != 1) {
                        if (i2 == 4) {
                            break;
                        }
                    } else {
                        com.google.android.exoplayer2.extractor.MpegAudioHeader.populateHeader(i6, this.synchronizedHeader);
                        i_renamed = i6;
                    }
                    extractorInput.advancePeekPosition(frameSize - 4);
                } else {
                    int i7 = i3 + 1;
                    if (i3 == i5) {
                        if (z_renamed) {
                            return false;
                        }
                        throw new com.google.android.exoplayer2.ParserException("Searched too many bytes.");
                    }
                    if (z_renamed) {
                        extractorInput.resetPeekPosition();
                        extractorInput.advancePeekPosition(i4 + i7);
                    } else {
                        extractorInput.skipFully(1);
                    }
                    i3 = i7;
                    i_renamed = 0;
                    i2 = 0;
                }
            } else if (i2 <= 0) {
                throw new java.io.EOFException();
            }
        }
        if (z_renamed) {
            extractorInput.skipFully(i4 + i3);
        } else {
            extractorInput.resetPeekPosition();
        }
        this.synchronizedHeaderData = i_renamed;
        return true;
    }

    private boolean peekEndOfStreamOrHeader(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        return (this.seeker != null && extractorInput.getPeekPosition() == this.seeker.getDataEndPosition()) || !extractorInput.peekFully(this.scratch.data, 0, 4, true);
    }

    private com.google.android.exoplayer2.extractor.mp3.Mp3Extractor.Seeker maybeReadSeekFrame(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(this.synchronizedHeader.frameSize);
        extractorInput.peekFully(parsableByteArray.data, 0, this.synchronizedHeader.frameSize);
        int i_renamed = 21;
        if ((this.synchronizedHeader.version & 1) != 0) {
            if (this.synchronizedHeader.channels != 1) {
                i_renamed = 36;
            }
        } else if (this.synchronizedHeader.channels == 1) {
            i_renamed = 13;
        }
        int i2 = i_renamed;
        int seekFrameHeader = getSeekFrameHeader(parsableByteArray, i2);
        if (seekFrameHeader == SEEK_HEADER_XING || seekFrameHeader == SEEK_HEADER_INFO) {
            com.google.android.exoplayer2.extractor.mp3.XingSeeker xingSeekerCreate = com.google.android.exoplayer2.extractor.mp3.XingSeeker.create(extractorInput.getLength(), extractorInput.getPosition(), this.synchronizedHeader, parsableByteArray);
            if (xingSeekerCreate != null && !this.gaplessInfoHolder.hasGaplessInfo()) {
                extractorInput.resetPeekPosition();
                extractorInput.advancePeekPosition(i2 + 141);
                extractorInput.peekFully(this.scratch.data, 0, 3);
                this.scratch.setPosition(0);
                this.gaplessInfoHolder.setFromXingHeaderValue(this.scratch.readUnsignedInt24());
            }
            extractorInput.skipFully(this.synchronizedHeader.frameSize);
            return (xingSeekerCreate == null || xingSeekerCreate.isSeekable() || seekFrameHeader != SEEK_HEADER_INFO) ? xingSeekerCreate : getConstantBitrateSeeker(extractorInput);
        }
        if (seekFrameHeader == SEEK_HEADER_VBRI) {
            com.google.android.exoplayer2.extractor.mp3.VbriSeeker vbriSeekerCreate = com.google.android.exoplayer2.extractor.mp3.VbriSeeker.create(extractorInput.getLength(), extractorInput.getPosition(), this.synchronizedHeader, parsableByteArray);
            extractorInput.skipFully(this.synchronizedHeader.frameSize);
            return vbriSeekerCreate;
        }
        extractorInput.resetPeekPosition();
        return null;
    }

    private com.google.android.exoplayer2.extractor.mp3.Mp3Extractor.Seeker getConstantBitrateSeeker(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        extractorInput.peekFully(this.scratch.data, 0, 4);
        this.scratch.setPosition(0);
        com.google.android.exoplayer2.extractor.MpegAudioHeader.populateHeader(this.scratch.readInt(), this.synchronizedHeader);
        return new com.google.android.exoplayer2.extractor.mp3.ConstantBitrateSeeker(extractorInput.getLength(), extractorInput.getPosition(), this.synchronizedHeader);
    }

    private static int getSeekFrameHeader(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i_renamed) {
        if (parsableByteArray.limit() >= i_renamed + 4) {
            parsableByteArray.setPosition(i_renamed);
            int i2 = parsableByteArray.readInt();
            if (i2 == SEEK_HEADER_XING || i2 == SEEK_HEADER_INFO) {
                return i2;
            }
        }
        if (parsableByteArray.limit() < 40) {
            return 0;
        }
        parsableByteArray.setPosition(36);
        int i3 = parsableByteArray.readInt();
        int i4 = SEEK_HEADER_VBRI;
        if (i3 == i4) {
            return i4;
        }
        return 0;
    }

    private static com.google.android.exoplayer2.extractor.mp3.MlltSeeker maybeHandleSeekMetadata(com.google.android.exoplayer2.metadata.Metadata metadata, long j_renamed) {
        if (metadata == null) {
            return null;
        }
        int length = metadata.length();
        for (int i_renamed = 0; i_renamed < length; i_renamed++) {
            com.google.android.exoplayer2.metadata.Metadata.Entry entry = metadata.get(i_renamed);
            if (entry instanceof com.google.android.exoplayer2.metadata.id3.MlltFrame) {
                return com.google.android.exoplayer2.extractor.mp3.MlltSeeker.create(j_renamed, (com.google.android.exoplayer2.metadata.id3.MlltFrame) entry);
            }
        }
        return null;
    }
}
