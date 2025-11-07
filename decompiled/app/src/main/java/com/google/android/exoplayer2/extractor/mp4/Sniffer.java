package com.google.android.exoplayer2.extractor.mp4;

/* loaded from: classes.dex */
final class Sniffer {
    private static final int[] COMPATIBLE_BRANDS = {com.google.android.exoplayer2.util.Util.getIntegerCodeForString("isom"), com.google.android.exoplayer2.util.Util.getIntegerCodeForString("iso2"), com.google.android.exoplayer2.util.Util.getIntegerCodeForString("iso3"), com.google.android.exoplayer2.util.Util.getIntegerCodeForString("iso4"), com.google.android.exoplayer2.util.Util.getIntegerCodeForString("iso5"), com.google.android.exoplayer2.util.Util.getIntegerCodeForString("iso6"), com.google.android.exoplayer2.util.Util.getIntegerCodeForString("avc1"), com.google.android.exoplayer2.util.Util.getIntegerCodeForString("av01"), com.google.android.exoplayer2.util.Util.getIntegerCodeForString("hvc1"), com.google.android.exoplayer2.util.Util.getIntegerCodeForString("hev1"), com.google.android.exoplayer2.util.Util.getIntegerCodeForString("mp41"), com.google.android.exoplayer2.util.Util.getIntegerCodeForString("mp42"), com.google.android.exoplayer2.util.Util.getIntegerCodeForString("3g2a"), com.google.android.exoplayer2.util.Util.getIntegerCodeForString("3g2b"), com.google.android.exoplayer2.util.Util.getIntegerCodeForString("3gr6"), com.google.android.exoplayer2.util.Util.getIntegerCodeForString("3gs6"), com.google.android.exoplayer2.util.Util.getIntegerCodeForString("3ge6"), com.google.android.exoplayer2.util.Util.getIntegerCodeForString("3gg6"), com.google.android.exoplayer2.util.Util.getIntegerCodeForString("M4V "), com.google.android.exoplayer2.util.Util.getIntegerCodeForString("M4A "), com.google.android.exoplayer2.util.Util.getIntegerCodeForString("f4v "), com.google.android.exoplayer2.util.Util.getIntegerCodeForString("kddi"), com.google.android.exoplayer2.util.Util.getIntegerCodeForString("M4VP"), com.google.android.exoplayer2.util.Util.getIntegerCodeForString("qt  "), com.google.android.exoplayer2.util.Util.getIntegerCodeForString("MSNV")};
    private static final int SEARCH_LENGTH = 4096;

    public static boolean sniffFragmented(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        return sniffInternal(extractorInput, true);
    }

    public static boolean sniffUnfragmented(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        return sniffInternal(extractorInput, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B_renamed:62:0x00db, code lost:
    
        r20 = r8 ? 1 : 0;
        r9 = true;
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:64:0x00e3, code lost:
    
        r0 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:65:0x00e5, code lost:
    
        if (r10 == false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:67:0x00e9, code lost:
    
        if (r24 != r0) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:69:0x00ed, code lost:
    
        return r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:85:?, code lost:
    
        return r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:86:?, code lost:
    
        return r20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean sniffInternal(com.google.android.exoplayer2.extractor.ExtractorInput r23, boolean r24) throws java.lang.InterruptedException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.Sniffer.sniffInternal(com.google.android.exoplayer2.extractor.ExtractorInput, boolean):boolean");
    }

    private static boolean isCompatibleBrand(int i_renamed) {
        if ((i_renamed >>> 8) == com.google.android.exoplayer2.util.Util.getIntegerCodeForString("3gp")) {
            return true;
        }
        for (int i2 : COMPATIBLE_BRANDS) {
            if (i2 == i_renamed) {
                return true;
            }
        }
        return false;
    }

    private Sniffer() {
    }
}
