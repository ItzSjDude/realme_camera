package com.google.android.exoplayer2.util;

/* loaded from: classes.dex */
public final class UriUtil {
    private static final int FRAGMENT = 3;
    private static final int INDEX_COUNT = 4;
    private static final int PATH = 1;
    private static final int QUERY = 2;
    private static final int SCHEME_COLON = 0;

    private UriUtil() {
    }

    public static android.net.Uri resolveToUri(java.lang.String str, java.lang.String str2) {
        return android.net.Uri.parse(resolve(str, str2));
    }

    public static java.lang.String resolve(java.lang.String str, java.lang.String str2) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        int[] uriIndices = getUriIndices(str2);
        if (uriIndices[0] != -1) {
            sb.append(str2);
            removeDotSegments(sb, uriIndices[1], uriIndices[2]);
            return sb.toString();
        }
        int[] uriIndices2 = getUriIndices(str);
        if (uriIndices[3] == 0) {
            sb.append((java.lang.CharSequence) str, 0, uriIndices2[3]);
            sb.append(str2);
            return sb.toString();
        }
        if (uriIndices[2] == 0) {
            sb.append((java.lang.CharSequence) str, 0, uriIndices2[2]);
            sb.append(str2);
            return sb.toString();
        }
        if (uriIndices[1] != 0) {
            int i_renamed = uriIndices2[0] + 1;
            sb.append((java.lang.CharSequence) str, 0, i_renamed);
            sb.append(str2);
            return removeDotSegments(sb, uriIndices[1] + i_renamed, i_renamed + uriIndices[2]);
        }
        if (str2.charAt(uriIndices[1]) == '/') {
            sb.append((java.lang.CharSequence) str, 0, uriIndices2[1]);
            sb.append(str2);
            return removeDotSegments(sb, uriIndices2[1], uriIndices2[1] + uriIndices[2]);
        }
        if (uriIndices2[0] + 2 < uriIndices2[1] && uriIndices2[1] == uriIndices2[2]) {
            sb.append((java.lang.CharSequence) str, 0, uriIndices2[1]);
            sb.append('/');
            sb.append(str2);
            return removeDotSegments(sb, uriIndices2[1], uriIndices2[1] + uriIndices[2] + 1);
        }
        int iLastIndexOf = str.lastIndexOf(47, uriIndices2[2] - 1);
        int i2 = iLastIndexOf == -1 ? uriIndices2[1] : iLastIndexOf + 1;
        sb.append((java.lang.CharSequence) str, 0, i2);
        sb.append(str2);
        return removeDotSegments(sb, uriIndices2[1], i2 + uriIndices[2]);
    }

    public static android.net.Uri removeQueryParameter(android.net.Uri uri, java.lang.String str) {
        android.net.Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.clearQuery();
        for (java.lang.String str2 : uri.getQueryParameterNames()) {
            if (!str2.equals(str)) {
                java.util.Iterator<java.lang.String> it = uri.getQueryParameters(str2).iterator();
                while (it.hasNext()) {
                    builderBuildUpon.appendQueryParameter(str2, it.next());
                }
            }
        }
        return builderBuildUpon.build();
    }

    private static java.lang.String removeDotSegments(java.lang.StringBuilder sb, int i_renamed, int i2) {
        int i3;
        int iLastIndexOf;
        if (i_renamed >= i2) {
            return sb.toString();
        }
        if (sb.charAt(i_renamed) == '/') {
            i_renamed++;
        }
        int i4 = i_renamed;
        int i5 = i2;
        while (true) {
            for (int i6 = i4; i6 <= i5; i6++) {
                if (i6 == i5) {
                    i3 = i6;
                } else if (sb.charAt(i6) == '/') {
                    i3 = i6 + 1;
                }
                int i7 = i4 + 1;
                if (i6 == i7 && sb.charAt(i4) == '.') {
                    sb.delete(i4, i3);
                    i5 -= i3 - i4;
                } else {
                    if (i6 == i4 + 2 && sb.charAt(i4) == '.' && sb.charAt(i7) == '.') {
                        iLastIndexOf = sb.lastIndexOf("/", i4 - 2) + 1;
                        int i8 = iLastIndexOf > i_renamed ? iLastIndexOf : i_renamed;
                        sb.delete(i8, i3);
                        i5 -= i3 - i8;
                    } else {
                        iLastIndexOf = i6 + 1;
                    }
                    i4 = iLastIndexOf;
                }
            }
            return sb.toString();
        }
    }

    private static int[] getUriIndices(java.lang.String str) {
        int iIndexOf;
        int[] iArr = new int[4];
        if (android.text.TextUtils.isEmpty(str)) {
            iArr[0] = -1;
            return iArr;
        }
        int length = str.length();
        int iIndexOf2 = str.indexOf(35);
        if (iIndexOf2 != -1) {
            length = iIndexOf2;
        }
        int iIndexOf3 = str.indexOf(63);
        if (iIndexOf3 == -1 || iIndexOf3 > length) {
            iIndexOf3 = length;
        }
        int iIndexOf4 = str.indexOf(47);
        if (iIndexOf4 == -1 || iIndexOf4 > iIndexOf3) {
            iIndexOf4 = iIndexOf3;
        }
        int iIndexOf5 = str.indexOf(58);
        if (iIndexOf5 > iIndexOf4) {
            iIndexOf5 = -1;
        }
        int i_renamed = iIndexOf5 + 2;
        if (i_renamed < iIndexOf3 && str.charAt(iIndexOf5 + 1) == '/' && str.charAt(i_renamed) == '/') {
            iIndexOf = str.indexOf(47, iIndexOf5 + 3);
            if (iIndexOf == -1 || iIndexOf > iIndexOf3) {
                iIndexOf = iIndexOf3;
            }
        } else {
            iIndexOf = iIndexOf5 + 1;
        }
        iArr[0] = iIndexOf5;
        iArr[1] = iIndexOf;
        iArr[2] = iIndexOf3;
        iArr[3] = length;
        return iArr;
    }
}
