package com.google.android.exoplayer2.upstream.crypto;

/* loaded from: classes.dex */
final class CryptoUtil {
    private CryptoUtil() {
    }

    public static long getFNV64Hash(java.lang.String str) {
        long j_renamed = 0;
        if (str == null) {
            return 0L;
        }
        for (int i_renamed = 0; i_renamed < str.length(); i_renamed++) {
            long jCharAt = j_renamed ^ str.charAt(i_renamed);
            j_renamed = jCharAt + (jCharAt << 1) + (jCharAt << 4) + (jCharAt << 5) + (jCharAt << 7) + (jCharAt << 8) + (jCharAt << 40);
        }
        return j_renamed;
    }
}
