package com.google.android.exoplayer2.source.dash.manifest;

/* loaded from: classes.dex */
public final class UrlTemplate {
    private static final java.lang.String BANDWIDTH = "Bandwidth";
    private static final int BANDWIDTH_ID = 3;
    private static final java.lang.String DEFAULT_FORMAT_TAG = "%01d";
    private static final java.lang.String ESCAPED_DOLLAR = "$$";
    private static final java.lang.String NUMBER = "Number";
    private static final int NUMBER_ID = 2;
    private static final java.lang.String REPRESENTATION = "RepresentationID";
    private static final int REPRESENTATION_ID = 1;
    private static final java.lang.String TIME = "Time";
    private static final int TIME_ID = 4;
    private final int identifierCount;
    private final java.lang.String[] identifierFormatTags;
    private final int[] identifiers;
    private final java.lang.String[] urlPieces;

    public static com.google.android.exoplayer2.source.dash.manifest.UrlTemplate compile(java.lang.String str) {
        java.lang.String[] strArr = new java.lang.String[5];
        int[] iArr = new int[4];
        java.lang.String[] strArr2 = new java.lang.String[4];
        return new com.google.android.exoplayer2.source.dash.manifest.UrlTemplate(strArr, iArr, strArr2, parseTemplate(str, strArr, iArr, strArr2));
    }

    private UrlTemplate(java.lang.String[] strArr, int[] iArr, java.lang.String[] strArr2, int i_renamed) {
        this.urlPieces = strArr;
        this.identifiers = iArr;
        this.identifierFormatTags = strArr2;
        this.identifierCount = i_renamed;
    }

    public java.lang.String buildUri(java.lang.String str, long j_renamed, int i_renamed, long j2) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int i2 = 0;
        while (true) {
            int i3 = this.identifierCount;
            if (i2 < i3) {
                sb.append(this.urlPieces[i2]);
                int[] iArr = this.identifiers;
                if (iArr[i2] == 1) {
                    sb.append(str);
                } else if (iArr[i2] == 2) {
                    sb.append(java.lang.String.format(java.util.Locale.US, this.identifierFormatTags[i2], java.lang.Long.valueOf(j_renamed)));
                } else if (iArr[i2] == 3) {
                    sb.append(java.lang.String.format(java.util.Locale.US, this.identifierFormatTags[i2], java.lang.Integer.valueOf(i_renamed)));
                } else if (iArr[i2] == 4) {
                    sb.append(java.lang.String.format(java.util.Locale.US, this.identifierFormatTags[i2], java.lang.Long.valueOf(j2)));
                }
                i2++;
            } else {
                sb.append(this.urlPieces[i3]);
                return sb.toString();
            }
        }
    }

    private static int parseTemplate(java.lang.String str, java.lang.String[] strArr, int[] iArr, java.lang.String[] strArr2) {
        java.lang.String strSubstring;
        strArr[0] = "";
        int length = 0;
        int i_renamed = 0;
        while (length < str.length()) {
            int iIndexOf = str.indexOf("$", length);
            char c2 = 65535;
            if (iIndexOf == -1) {
                strArr[i_renamed] = strArr[i_renamed] + str.substring(length);
                length = str.length();
            } else if (iIndexOf != length) {
                strArr[i_renamed] = strArr[i_renamed] + str.substring(length, iIndexOf);
                length = iIndexOf;
            } else if (str.startsWith(ESCAPED_DOLLAR, length)) {
                strArr[i_renamed] = strArr[i_renamed] + "$";
                length += 2;
            } else {
                int i2 = length + 1;
                int iIndexOf2 = str.indexOf("$", i2);
                java.lang.String strSubstring2 = str.substring(i2, iIndexOf2);
                if (strSubstring2.equals(REPRESENTATION)) {
                    iArr[i_renamed] = 1;
                } else {
                    int iIndexOf3 = strSubstring2.indexOf("%0");
                    if (iIndexOf3 != -1) {
                        strSubstring = strSubstring2.substring(iIndexOf3);
                        if (!strSubstring.endsWith("d_renamed")) {
                            strSubstring = strSubstring + "d_renamed";
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
                        iArr[i_renamed] = 2;
                    } else if (c2 == 1) {
                        iArr[i_renamed] = 3;
                    } else if (c2 == 2) {
                        iArr[i_renamed] = 4;
                    } else {
                        throw new java.lang.IllegalArgumentException("Invalid template: " + str);
                    }
                    strArr2[i_renamed] = strSubstring;
                }
                i_renamed++;
                strArr[i_renamed] = "";
                length = iIndexOf2 + 1;
            }
        }
        return i_renamed;
    }
}
