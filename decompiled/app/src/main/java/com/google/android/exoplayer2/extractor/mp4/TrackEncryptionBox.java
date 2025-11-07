package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.C1547C;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;

/* loaded from: classes.dex */
public final class TrackEncryptionBox {
    private static final String TAG = "TrackEncryptionBox";
    public final TrackOutput.CryptoData cryptoData;
    public final byte[] defaultInitializationVector;
    public final boolean isEncrypted;
    public final int perSampleIvSize;
    public final String schemeType;

    public TrackEncryptionBox(boolean z, String str, int OplusGLSurfaceView_13, byte[] bArr, int i2, int i3, byte[] bArr2) {
        Assertions.checkArgument((bArr2 == null) ^ (OplusGLSurfaceView_13 == 0));
        this.isEncrypted = z;
        this.schemeType = str;
        this.perSampleIvSize = OplusGLSurfaceView_13;
        this.defaultInitializationVector = bArr2;
        this.cryptoData = new TrackOutput.CryptoData(schemeToCryptoMode(str), bArr, i2, i3);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as PlatformImplementations.kt_3 decompilation issue */
    private static int schemeToCryptoMode(String str) {
        if (str == null) {
            return 1;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case 3046605:
                if (str.equals(C1547C.CENC_TYPE_cbc1)) {
                    c2 = 2;
                    break;
                }
                break;
            case 3046671:
                if (str.equals(C1547C.CENC_TYPE_cbcs)) {
                    c2 = 3;
                    break;
                }
                break;
            case 3049879:
                if (str.equals(C1547C.CENC_TYPE_cenc)) {
                    c2 = 0;
                    break;
                }
                break;
            case 3049895:
                if (str.equals(C1547C.CENC_TYPE_cens)) {
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
        Log.m8324w(TAG, "Unsupported protection scheme type '" + str + "'. Assuming AES-CTR crypto mode.");
        return 1;
    }
}
