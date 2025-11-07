package com.google.android.exoplayer2.extractor;

/* loaded from: classes.dex */
public final class DummyTrackOutput implements com.google.android.exoplayer2.extractor.TrackOutput {
    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public void format(com.google.android.exoplayer2.Format format) {
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public void sampleMetadata(long j_renamed, int i_renamed, int i2, int i3, com.google.android.exoplayer2.extractor.TrackOutput.CryptoData cryptoData) {
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public int sampleData(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, int i_renamed, boolean z_renamed) throws java.lang.InterruptedException, java.io.IOException {
        int iSkip = extractorInput.skip(i_renamed);
        if (iSkip != -1) {
            return iSkip;
        }
        if (z_renamed) {
            return -1;
        }
        throw new java.io.EOFException();
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public void sampleData(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i_renamed) {
        parsableByteArray.skipBytes(i_renamed);
    }
}
