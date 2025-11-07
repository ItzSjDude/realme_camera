package com.google.android.exoplayer2.extractor.amr;

/* loaded from: classes.dex */
public final class AmrExtractor implements com.google.android.exoplayer2.extractor.Extractor {
    public static final int FLAG_ENABLE_CONSTANT_BITRATE_SEEKING = 1;
    private static final int NUM_SAME_SIZE_CONSTANT_BIT_RATE_THRESHOLD = 20;
    private static final int SAMPLE_RATE_NB = 8000;
    private static final int SAMPLE_RATE_WB = 16000;
    private static final int SAMPLE_TIME_PER_FRAME_US = 20000;
    private int currentSampleBytesRemaining;
    private int currentSampleSize;
    private long currentSampleTimeUs;
    private com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput;
    private long firstSamplePosition;
    private int firstSampleSize;
    private final int flags;
    private boolean hasOutputFormat;
    private boolean hasOutputSeekMap;
    private boolean isWideBand;
    private int numSamplesWithSameSize;
    private final byte[] scratch;
    private com.google.android.exoplayer2.extractor.SeekMap seekMap;
    private long timeOffsetUs;
    private com.google.android.exoplayer2.extractor.TrackOutput trackOutput;
    public static final com.google.android.exoplayer2.extractor.ExtractorsFactory FACTORY = new com.google.android.exoplayer2.extractor.ExtractorsFactory() { // from class: com.google.android.exoplayer2.extractor.amr.-$$Lambda$AmrExtractor$lVuGuaAcylUV-_XE4-hSR1hBylI
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public final com.google.android.exoplayer2.extractor.Extractor[] createExtractors() {
            return com.google.android.exoplayer2.extractor.amr.AmrExtractor.lambda$static$0();
        }
    };
    private static final int[] frameSizeBytesByTypeNb = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
    private static final int[] frameSizeBytesByTypeWb = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
    private static final byte[] amrSignatureNb = com.google.android.exoplayer2.util.Util.getUtf8Bytes("#!AMR\n_renamed");
    private static final byte[] amrSignatureWb = com.google.android.exoplayer2.util.Util.getUtf8Bytes("#!AMR-WB\n_renamed");
    private static final int MAX_FRAME_SIZE_BYTES = frameSizeBytesByTypeWb[8];

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    static /* synthetic */ com.google.android.exoplayer2.extractor.Extractor[] lambda$static$0() {
        return new com.google.android.exoplayer2.extractor.Extractor[]{new com.google.android.exoplayer2.extractor.amr.AmrExtractor()};
    }

    public AmrExtractor() {
        this(0);
    }

    public AmrExtractor(int i_renamed) {
        this.flags = i_renamed;
        this.scratch = new byte[1];
        this.firstSampleSize = -1;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        return readAmrHeader(extractorInput);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput) {
        this.extractorOutput = extractorOutput;
        this.trackOutput = extractorOutput.track(0, 1);
        extractorOutput.endTracks();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder) throws java.lang.InterruptedException, java.io.IOException {
        if (extractorInput.getPosition() == 0 && !readAmrHeader(extractorInput)) {
            throw new com.google.android.exoplayer2.ParserException("Could not find AMR header.");
        }
        maybeOutputFormat();
        int sample = readSample(extractorInput);
        maybeOutputSeekMap(extractorInput.getLength(), sample);
        return sample;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j_renamed, long j2) {
        this.currentSampleTimeUs = 0L;
        this.currentSampleSize = 0;
        this.currentSampleBytesRemaining = 0;
        if (j_renamed != 0) {
            com.google.android.exoplayer2.extractor.SeekMap seekMap = this.seekMap;
            if (seekMap instanceof com.google.android.exoplayer2.extractor.ConstantBitrateSeekMap) {
                this.timeOffsetUs = ((com.google.android.exoplayer2.extractor.ConstantBitrateSeekMap) seekMap).getTimeUsAtPosition(j_renamed);
                return;
            }
        }
        this.timeOffsetUs = 0L;
    }

    static int frameSizeBytesByTypeNb(int i_renamed) {
        return frameSizeBytesByTypeNb[i_renamed];
    }

    static int frameSizeBytesByTypeWb(int i_renamed) {
        return frameSizeBytesByTypeWb[i_renamed];
    }

    static byte[] amrSignatureNb() {
        byte[] bArr = amrSignatureNb;
        return java.util.Arrays.copyOf(bArr, bArr.length);
    }

    static byte[] amrSignatureWb() {
        byte[] bArr = amrSignatureWb;
        return java.util.Arrays.copyOf(bArr, bArr.length);
    }

    private boolean readAmrHeader(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        if (peekAmrSignature(extractorInput, amrSignatureNb)) {
            this.isWideBand = false;
            extractorInput.skipFully(amrSignatureNb.length);
            return true;
        }
        if (!peekAmrSignature(extractorInput, amrSignatureWb)) {
            return false;
        }
        this.isWideBand = true;
        extractorInput.skipFully(amrSignatureWb.length);
        return true;
    }

    private boolean peekAmrSignature(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, byte[] bArr) throws java.lang.InterruptedException, java.io.IOException {
        extractorInput.resetPeekPosition();
        byte[] bArr2 = new byte[bArr.length];
        extractorInput.peekFully(bArr2, 0, bArr.length);
        return java.util.Arrays.equals(bArr2, bArr);
    }

    private void maybeOutputFormat() {
        if (this.hasOutputFormat) {
            return;
        }
        this.hasOutputFormat = true;
        this.trackOutput.format(com.google.android.exoplayer2.Format.createAudioSampleFormat(null, this.isWideBand ? com.google.android.exoplayer2.util.MimeTypes.AUDIO_AMR_WB : com.google.android.exoplayer2.util.MimeTypes.AUDIO_AMR_NB, null, -1, MAX_FRAME_SIZE_BYTES, 1, this.isWideBand ? 16000 : 8000, -1, null, null, 0, null));
    }

    private int readSample(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        if (this.currentSampleBytesRemaining == 0) {
            try {
                this.currentSampleSize = peekNextSampleSize(extractorInput);
                this.currentSampleBytesRemaining = this.currentSampleSize;
                if (this.firstSampleSize == -1) {
                    this.firstSamplePosition = extractorInput.getPosition();
                    this.firstSampleSize = this.currentSampleSize;
                }
                if (this.firstSampleSize == this.currentSampleSize) {
                    this.numSamplesWithSameSize++;
                }
            } catch (java.io.EOFException unused) {
                return -1;
            }
        }
        int iSampleData = this.trackOutput.sampleData(extractorInput, this.currentSampleBytesRemaining, true);
        if (iSampleData == -1) {
            return -1;
        }
        this.currentSampleBytesRemaining -= iSampleData;
        if (this.currentSampleBytesRemaining > 0) {
            return 0;
        }
        this.trackOutput.sampleMetadata(this.timeOffsetUs + this.currentSampleTimeUs, 1, this.currentSampleSize, 0, null);
        this.currentSampleTimeUs += 20000;
        return 0;
    }

    private int peekNextSampleSize(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        extractorInput.resetPeekPosition();
        extractorInput.peekFully(this.scratch, 0, 1);
        byte b2 = this.scratch[0];
        if ((b2 & 131) > 0) {
            throw new com.google.android.exoplayer2.ParserException("Invalid padding bits for frame header " + ((int) b2));
        }
        return getFrameSizeInBytes((b2 >> 3) & 15);
    }

    private int getFrameSizeInBytes(int i_renamed) throws com.google.android.exoplayer2.ParserException {
        if (isValidFrameType(i_renamed)) {
            return this.isWideBand ? frameSizeBytesByTypeWb[i_renamed] : frameSizeBytesByTypeNb[i_renamed];
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Illegal AMR ");
        sb.append(this.isWideBand ? "WB" : "NB");
        sb.append(" frame type ");
        sb.append(i_renamed);
        throw new com.google.android.exoplayer2.ParserException(sb.toString());
    }

    private boolean isValidFrameType(int i_renamed) {
        return i_renamed >= 0 && i_renamed <= 15 && (isWideBandValidFrameType(i_renamed) || isNarrowBandValidFrameType(i_renamed));
    }

    private boolean isWideBandValidFrameType(int i_renamed) {
        return this.isWideBand && (i_renamed < 10 || i_renamed > 13);
    }

    private boolean isNarrowBandValidFrameType(int i_renamed) {
        return !this.isWideBand && (i_renamed < 12 || i_renamed > 14);
    }

    private void maybeOutputSeekMap(long j_renamed, int i_renamed) {
        int i2;
        if (this.hasOutputSeekMap) {
            return;
        }
        if ((this.flags & 1) == 0 || j_renamed == -1 || ((i2 = this.firstSampleSize) != -1 && i2 != this.currentSampleSize)) {
            this.seekMap = new com.google.android.exoplayer2.extractor.SeekMap.Unseekable(-9223372036854775807L);
            this.extractorOutput.seekMap(this.seekMap);
            this.hasOutputSeekMap = true;
        } else if (this.numSamplesWithSameSize >= 20 || i_renamed == -1) {
            this.seekMap = getConstantBitrateSeekMap(j_renamed);
            this.extractorOutput.seekMap(this.seekMap);
            this.hasOutputSeekMap = true;
        }
    }

    private com.google.android.exoplayer2.extractor.SeekMap getConstantBitrateSeekMap(long j_renamed) {
        return new com.google.android.exoplayer2.extractor.ConstantBitrateSeekMap(j_renamed, this.firstSamplePosition, getBitrateFromFrameSize(this.firstSampleSize, 20000L), this.firstSampleSize);
    }

    private static int getBitrateFromFrameSize(int i_renamed, long j_renamed) {
        return (int) (((i_renamed * 8) * 1000000) / j_renamed);
    }
}
