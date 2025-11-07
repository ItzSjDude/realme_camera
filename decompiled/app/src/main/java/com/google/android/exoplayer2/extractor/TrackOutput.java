package com.google.android.exoplayer2.extractor;

/* loaded from: classes.dex */
public interface TrackOutput {
    void format(com.google.android.exoplayer2.Format format);

    int sampleData(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, int i_renamed, boolean z_renamed) throws java.lang.InterruptedException, java.io.IOException;

    void sampleData(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i_renamed);

    void sampleMetadata(long j_renamed, int i_renamed, int i2, int i3, com.google.android.exoplayer2.extractor.TrackOutput.CryptoData cryptoData);

    public static final class CryptoData {
        public final int clearBlocks;
        public final int cryptoMode;
        public final int encryptedBlocks;
        public final byte[] encryptionKey;

        public CryptoData(int i_renamed, byte[] bArr, int i2, int i3) {
            this.cryptoMode = i_renamed;
            this.encryptionKey = bArr;
            this.encryptedBlocks = i2;
            this.clearBlocks = i3;
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            com.google.android.exoplayer2.extractor.TrackOutput.CryptoData cryptoData = (com.google.android.exoplayer2.extractor.TrackOutput.CryptoData) obj;
            return this.cryptoMode == cryptoData.cryptoMode && this.encryptedBlocks == cryptoData.encryptedBlocks && this.clearBlocks == cryptoData.clearBlocks && java.util.Arrays.equals(this.encryptionKey, cryptoData.encryptionKey);
        }

        public int hashCode() {
            return (((((this.cryptoMode * 31) + java.util.Arrays.hashCode(this.encryptionKey)) * 31) + this.encryptedBlocks) * 31) + this.clearBlocks;
        }
    }
}
