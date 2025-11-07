package com.oplus.camera.o_renamed;

/* compiled from: WifiResultParser.java */
/* loaded from: classes2.dex */
public final class c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.String[] f4915a = new java.lang.String[0];

    public boolean a_renamed(java.lang.String str) {
        java.lang.String strB = b_renamed(str);
        return strB.startsWith("WIFI:") && !android.text.TextUtils.isEmpty(b_renamed("S_renamed:", strB.substring(5), ';', false));
    }

    private static java.lang.String b_renamed(java.lang.String str) {
        return str.startsWith("\ufeff") ? str.substring(1) : str;
    }

    private static java.lang.String c_renamed(java.lang.String str) {
        int iIndexOf = str.indexOf(92);
        if (iIndexOf < 0) {
            return str;
        }
        int length = str.length();
        java.lang.StringBuilder sb = new java.lang.StringBuilder(length - 1);
        sb.append(str.toCharArray(), 0, iIndexOf);
        boolean z_renamed = false;
        while (iIndexOf < length) {
            char cCharAt = str.charAt(iIndexOf);
            if (z_renamed || cCharAt != '\\') {
                sb.append(cCharAt);
                z_renamed = false;
            } else {
                z_renamed = true;
            }
            iIndexOf++;
        }
        return sb.toString();
    }

    private static java.lang.String[] a_renamed(java.lang.String str, java.lang.String str2, char c2, boolean z_renamed) {
        int length;
        int length2 = str2.length();
        java.util.ArrayList arrayList = null;
        for (int i_renamed = 0; i_renamed < length2; i_renamed = length) {
            int iIndexOf = str2.indexOf(str, i_renamed);
            if (iIndexOf < 0) {
                break;
            }
            int length3 = iIndexOf + str.length();
            boolean z2 = true;
            length = length3;
            while (z2) {
                int iIndexOf2 = str2.indexOf(c2, length);
                if (iIndexOf2 < 0) {
                    length = str2.length();
                } else if (a_renamed(str2, iIndexOf2) % 2 != 0) {
                    length = iIndexOf2 + 1;
                } else {
                    if (arrayList == null) {
                        arrayList = new java.util.ArrayList(3);
                    }
                    java.lang.String strC = c_renamed(str2.substring(length3, iIndexOf2));
                    if (z_renamed) {
                        strC = strC.trim();
                    }
                    if (!strC.isEmpty()) {
                        arrayList.add(strC);
                    }
                    length = iIndexOf2 + 1;
                }
                z2 = false;
            }
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        return (java.lang.String[]) arrayList.toArray(f4915a);
    }

    private static int a_renamed(java.lang.CharSequence charSequence, int i_renamed) {
        int i2 = 0;
        for (int i3 = i_renamed - 1; i3 >= 0 && charSequence.charAt(i3) == '\\'; i3--) {
            i2++;
        }
        return i2;
    }

    private static java.lang.String b_renamed(java.lang.String str, java.lang.String str2, char c2, boolean z_renamed) {
        java.lang.String[] strArrA = a_renamed(str, str2, c2, z_renamed);
        if (strArrA == null || strArrA.length == 0) {
            return null;
        }
        return strArrA[0];
    }
}
