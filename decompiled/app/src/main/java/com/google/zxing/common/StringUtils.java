package com.google.zxing.common;

/* loaded from: classes.dex */
public final class StringUtils {
    private static final boolean ASSUME_SHIFT_JIS;
    private static final java.lang.String EUC_JP = "EUC_JP";
    public static final java.lang.String GB2312 = "GB2312";
    private static final java.lang.String ISO88591 = "ISO8859_1";
    private static final java.lang.String PLATFORM_DEFAULT_ENCODING = java.nio.charset.Charset.defaultCharset().name();
    public static final java.lang.String SHIFT_JIS = "SJIS";
    private static final java.lang.String UTF8 = "UTF8";

    static {
        ASSUME_SHIFT_JIS = SHIFT_JIS.equalsIgnoreCase(PLATFORM_DEFAULT_ENCODING) || EUC_JP.equalsIgnoreCase(PLATFORM_DEFAULT_ENCODING);
    }

    private StringUtils() {
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:42:0x0081 A_renamed[PHI: r10
      0x0081: PHI (r10v6 int) = (r10v1 int), (r10v5 int), (r10v1 int) binds: [B_renamed:32:0x0064, B_renamed:40:0x007c, B_renamed:27:0x0059] A_renamed[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:92:0x00ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String guessEncoding(byte[] r19, java.util.Map<com.google.zxing.DecodeHintType, ?> r20) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.common.StringUtils.guessEncoding(byte[], java.util.Map):java.lang.String");
    }
}
