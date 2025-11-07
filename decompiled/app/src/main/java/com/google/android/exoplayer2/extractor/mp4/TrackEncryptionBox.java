package com.google.android.exoplayer2.extractor.mp4;

/* loaded from: classes.dex */
public final class TrackEncryptionBox {
    private static final java.lang.String TAG = "TrackEncryptionBox";
    public final com.google.android.exoplayer2.extractor.TrackOutput.CryptoData cryptoData;
    public final byte[] defaultInitializationVector;
    public final boolean isEncrypted;
    public final int perSampleIvSize;
    public final java.lang.String schemeType;

    public TrackEncryptionBox(boolean z_renamed, java.lang.String str, int i_renamed, byte[] bArr, int i2, int i3, byte[] bArr2) {
        com.google.android.exoplayer2.util.Assertions.checkArgument((bArr2 == null) ^ (i_renamed == 0));
        this.isEncrypted = z_renamed;
        this.schemeType = str;
        this.perSampleIvSize = i_renamed;
        this.defaultInitializationVector = bArr2;
        this.cryptoData = new com.google.android.exoplayer2.extractor.TrackOutput.CryptoData(schemeToCryptoMode(str), bArr, i2, i3);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as_renamed a_renamed decompilation issue */
    private static int schemeToCryptoMode(java.lang.String str) {
        if (str == null) {
            return 1;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case 3046605:
                if (str.equals(com.google.android.exoplayer2.C_renamed.CENC_TYPE_cbc1)) {
                    c2 = 2;
                    break;
                }
                break;
            case 3046671:
                if (str.equals(com.google.android.exoplayer2.C_renamed.CENC_TYPE_cbcs)) {
                    c2 = 3;
                    break;
                }
                break;
            case 3049879:
                if (str.equals(com.google.android.exoplayer2.C_renamed.CENC_TYPE_cenc)) {
                    c2 = 0;
                    break;
                }
                break;
            case 3049895:
                if (str.equals(com.google.android.exoplayer2.C_renamed.CENC_TYPE_cens)) {
                    c2 = 1;
                    break;
                }
                break;
        }
        if (c2 == 0 || c2 == 1) {
            return 1;
        }
        if (c2 == 2 || c2 == 3) {
            return 2;
        }
        com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Unsupported protection scheme type '" + str + "'. Assuming AES-CTR crypto mode.");
        return 1;
    }
}
