package com.google.android.exoplayer2.source.dash.manifest;

import java.util.Locale;

/* loaded from: classes.dex */
public final class UrlTemplate {
    private static final String BANDWIDTH = "Bandwidth";
    private static final int BANDWIDTH_ID = 3;
    private static final String DEFAULT_FORMAT_TAG = "%01d";
    private static final String ESCAPED_DOLLAR = "$$";
    private static final String NUMBER = "Number";
    private static final int NUMBER_ID = 2;
    private static final String REPRESENTATION = "RepresentationID";
    private static final int REPRESENTATION_ID = 1;
    private static final String TIME = "Time";
    private static final int TIME_ID = 4;
    private final int identifierCount;
    private final String[] identifierFormatTags;
    private final int[] identifiers;
    private final String[] urlPieces;

    public static UrlTemplate compile(String str) {
        String[] strArr = new String[5];
        int[] iArr = new int[4];
        String[] strArr2 = new String[4];
        return new UrlTemplate(strArr, iArr, strArr2, parseTemplate(str, strArr, iArr, strArr2));
    }

    private UrlTemplate(String[] strArr, int[] iArr, String[] strArr2, int OplusGLSurfaceView_13) {
        this.urlPieces = strArr;
        this.identifiers = iArr;
        this.identifierFormatTags = strArr2;
        this.identifierCount = OplusGLSurfaceView_13;
    }

    public String buildUri(String str, long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, long j2) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (true) {
            int i3 = this.identifierCount;
            if (i2 < i3) {
                sb.append(this.urlPieces[i2]);
                int[] iArr = this.identifiers;
                if (iArr[i2] == 1) {
                    sb.append(str);
                } else if (iArr[i2] == 2) {
                    sb.append(String.format(Locale.US, this.identifierFormatTags[i2], Long.valueOf(OplusGLSurfaceView_15)));
                } else if (iArr[i2] == 3) {
                    sb.append(String.format(Locale.US, this.identifierFormatTags[i2], Integer.valueOf(OplusGLSurfaceView_13)));
                } else if (iArr[i2] == 4) {
                    sb.append(String.format(Locale.US, this.identifierFormatTags[i2], Long.valueOf(j2)));
                }
                i2++;
            } else {
                sb.append(this.urlPieces[i3]);
                return sb.toString();
            }
        }
    }

    private static int parseTemplate(String str, String[] strArr, int[] iArr, String[] strArr2) {
        String strSubstring;
        strArr[0] = "";
        int length = 0;
        int OplusGLSurfaceView_13 = 0;
        while (length < str.length()) {
            int iIndexOf = str.indexOf("$", length);
            char c2 = 65535;
            if (iIndexOf == -1) {
                strArr[OplusGLSurfaceView_13] = strArr[OplusGLSurfaceView_13] + str.substring(length);
                length = str.length();
            } else if (iIndexOf != length) {
                strArr[OplusGLSurfaceView_13] = strArr[OplusGLSurfaceView_13] + str.substring(length, iIndexOf);
                length = iIndexOf;
            } else if (str.startsWith(ESCAPED_DOLLAR, length)) {
                strArr[OplusGLSurfaceView_13] = strArr[OplusGLSurfaceView_13] + "$";
                length += 2;
            } else {
                int i2 = length + 1;
                int iIndexOf2 = str.indexOf("$", i2);
                String strSubstring2 = str.substring(i2, iIndexOf2);
                if (strSubstring2.equals(REPRESENTATION)) {
                    iArr[OplusGLSurfaceView_13] = 1;
                } else {
                    int iIndexOf3 = strSubstring2.indexOf("%0");
                    if (iIndexOf3 != -1) {
                        strSubstring = strSubstring2.substring(iIndexOf3);
                        if (!strSubstring.endsWith("IntrinsicsJvm.kt_5")) {
                            strSubstring = strSubstring + "IntrinsicsJvm.kt_5";
                        }
                        strSubstring2 = strSubstring2.substring(0, iIndexOf3);
                    } else {
                        strSubstring = DEFAULT_FORMAT_TAG;
                    }
                    int iHashCode = strSubstring2.hashCode();
                    if (iHashCode != -1950496919) {
                        if (iHashCode != 2606829) {
                            if (iHashCode == 38199441 && strSubstring2.equals(BANDWIDTH)) {
                                c2 = 1;
                            }
                        } else if (strSubstring2.equals(TIME)) {
                            c2 = 2;
                        }
                    } else if (strSubstring2.equals(NUMBER)) {
                        c2 = 0;
                    }
                    if (c2 == 0) {
                        iArr[OplusGLSurfaceView_13] = 2;
                    } else if (c2 == 1) {
                        iArr[OplusGLSurfaceView_13] = 3;
                    } else if (c2 == 2) {
                        iArr[OplusGLSurfaceView_13] = 4;
                    } else {
                        throw new IllegalArgumentException("Invalid template: " + str);
                    }
                    strArr2[OplusGLSurfaceView_13] = strSubstring;
                }
                OplusGLSurfaceView_13++;
                strArr[OplusGLSurfaceView_13] = "";
                length = iIndexOf2 + 1;
            }
        }
        return OplusGLSurfaceView_13;
    }
}
