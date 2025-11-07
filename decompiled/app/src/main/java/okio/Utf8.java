package okio;

/* loaded from: classes2.dex */
public final class Utf8 {
    private Utf8() {
    }

    public static long size(java.lang.String str) {
        return size(str, 0, str.length());
    }

    public static long size(java.lang.String str, int i_renamed, int i2) {
        long j_renamed;
        if (str == null) {
            throw new java.lang.IllegalArgumentException("string == null");
        }
        if (i_renamed < 0) {
            throw new java.lang.IllegalArgumentException("beginIndex < 0: " + i_renamed);
        }
        if (i2 < i_renamed) {
            throw new java.lang.IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i_renamed);
        }
        if (i2 > str.length()) {
            throw new java.lang.IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
        long j2 = 0;
        while (i_renamed < i2) {
            char cCharAt = str.charAt(i_renamed);
            if (cCharAt < 128) {
                j2++;
            } else {
                if (cCharAt < 2048) {
                    j_renamed = 2;
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    j_renamed = 3;
                } else {
                    int i3 = i_renamed + 1;
                    char cCharAt2 = i3 < i2 ? str.charAt(i3) : (char) 0;
                    if (cCharAt > 56319 || cCharAt2 < 56320 || cCharAt2 > 57343) {
                        j2++;
                        i_renamed = i3;
                    } else {
                        j2 += 4;
                        i_renamed += 2;
                    }
                }
                j2 += j_renamed;
            }
            i_renamed++;
        }
        return j2;
    }
}
