package com.oplus.camera.p156o;

import android.text.TextUtils;
import java.util.ArrayList;

/* compiled from: WifiResultParser.java */
/* renamed from: com.oplus.camera.o.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public final class WifiResultParser {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String[] f14781a = new String[0];

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m14818a(String str) {
        String strM14815b = m14815b(str);
        return strM14815b.startsWith("WIFI:") && !TextUtils.isEmpty(m14816b("S:", strM14815b.substring(5), ';', false));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static String m14815b(String str) {
        return str.startsWith("\ufeff") ? str.substring(1) : str;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static String m14817c(String str) {
        int iIndexOf = str.indexOf(92);
        if (iIndexOf < 0) {
            return str;
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(length - 1);
        sb.append(str.toCharArray(), 0, iIndexOf);
        boolean z = false;
        while (iIndexOf < length) {
            char cCharAt = str.charAt(iIndexOf);
            if (z || cCharAt != '\\') {
                sb.append(cCharAt);
                z = false;
            } else {
                z = true;
            }
            iIndexOf++;
        }
        return sb.toString();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static String[] m14814a(String str, String str2, char c2, boolean z) {
        int length;
        int length2 = str2.length();
        ArrayList arrayList = null;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length2; OplusGLSurfaceView_13 = length) {
            int iIndexOf = str2.indexOf(str, OplusGLSurfaceView_13);
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
                } else if (m14813a(str2, iIndexOf2) % 2 != 0) {
                    length = iIndexOf2 + 1;
                } else {
                    if (arrayList == null) {
                        arrayList = new ArrayList(3);
                    }
                    String strM14817c = m14817c(str2.substring(length3, iIndexOf2));
                    if (z) {
                        strM14817c = strM14817c.trim();
                    }
                    if (!strM14817c.isEmpty()) {
                        arrayList.add(strM14817c);
                    }
                    length = iIndexOf2 + 1;
                }
                z2 = false;
            }
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        return (String[]) arrayList.toArray(f14781a);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static int m14813a(CharSequence charSequence, int OplusGLSurfaceView_13) {
        int i2 = 0;
        for (int i3 = OplusGLSurfaceView_13 - 1; i3 >= 0 && charSequence.charAt(i3) == '\\'; i3--) {
            i2++;
        }
        return i2;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static String m14816b(String str, String str2, char c2, boolean z) {
        String[] strArrM14814a = m14814a(str, str2, c2, z);
        if (strArrM14814a == null || strArrM14814a.length == 0) {
            return null;
        }
        return strArrM14814a[0];
    }
}
