package com.google.android.exoplayer2.extractor.wav;

/* loaded from: classes.dex */
public final class WavExtractor implements com.google.android.exoplayer2.extractor.Extractor {
    public static final com.google.android.exoplayer2.extractor.ExtractorsFactory FACTORY = new com.google.android.exoplayer2.extractor.ExtractorsFactory() { // from class: com.google.android.exoplayer2.extractor.wav.-$$Lambda$WavExtractor$5r6M_S0QCNNj_Xavzq9WwuFHep0
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public final com.google.android.exoplayer2.extractor.Extractor[] createExtractors() {
            return com.google.android.exoplayer2.extractor.wav.WavExtractor.lambda$static$0();
        }
    };
    private static final int MAX_INPUT_SIZE = 32768;
    private int bytesPerFrame;
    private com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput;
    private int pendingBytes;
    private com.google.android.exoplayer2.extractor.TrackOutput trackOutput;
    private com.google.android.exoplayer2.extractor.wav.WavHeader wavHeader;

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    static /* synthetic */ com.google.android.exoplayer2.extractor.Extractor[] lambda$static$0() {
        return new com.google.android.exoplayer2.extractor.Extractor[]{new com.google.android.exoplayer2.extractor.wav.WavExtractor()};
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        return com.google.android.exoplayer2.extractor.wav.WavHeaderReader.peek(extractorInput) != null;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput) {
        this.extractorOutput = extractorOutput;
        this.trackOutput = extractorOutput.track(0, 1);
        this.wavHeader = null;
        extractorOutput.endTracks();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j_renamed, long j2) {
        this.pendingBytes = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder) throws java.lang.InterruptedException, java.io.IOException {
        if (this.wavHeader == null) {
            this.wavHeader = com.google.android.exoplayer2.extractor.wav.WavHeaderReader.peek(extractorInput);
            com.google.android.exoplayer2.extractor.wav.WavHeader wavHeader = this.wavHeader;
            if (wavHeader == null) {
                throw new com.google.android.exoplayer2.ParserException("Unsupported or unrecognized wav header.");
            }
            this.trackOutput.format(com.google.android.exoplayer2.Format.createAudioSampleFormat(null, com.google.android.exoplayer2.util.MimeTypes.AUDIO_RAW, null, wavHeader.getBitrate(), 32768, this.wavHeader.getNumChannels(), this.wavHeader.getSampleRateHz(), this.wavHeader.getEncoding(), null, null, 0, null));
            this.bytesPerFrame = this.wavHeader.getBytesPerFrame();
        }
        if (!this.wavHeader.hasDataBounds()) {
            com.google.android.exoplayer2.extractor.wav.WavHeaderReader.skipToData(extractorInput, this.wavHeader);
            this.extractorOutput.seekMap(this.wavHeader);
        }
        long dataLimit = this.wavHeader.getDataLimit();
        com.google.android.exoplayer2.util.Assertions.checkState(dataLimit != -1);
        long position = dataLimit - extractorInput.getPosition();
        if (position <= 0) {
            return -1;
        }
        int iSampleData = this.trackOutput.sampleData(extractorInput, (int) java.lang.Math.min(32768 - this.pendingBytes, position), true);
        if (iSampleData != -1) {
            this.pendingBytes += iSampleData;
        }
        int i_renamed = this.pendingBytes / this.bytesPerFrame;
        if (i_renamed > 0) {
            long timeUs = this.wavHeader.getTimeUs(extractorInput.getPosition() - this.pendingBytes);
            int i2 = i_renamed * this.bytesPerFrame;
            this.pendingBytes -= i2;
            this.trackOutput.sampleMetadata(timeUs, 1, i2, this.pendingBytes, null);
        }
        return iSampleData == -1 ? -1 : 0;
    }
}
