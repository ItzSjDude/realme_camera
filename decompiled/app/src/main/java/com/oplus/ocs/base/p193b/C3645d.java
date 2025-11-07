package com.oplus.ocs.base.p193b;

import android.text.TextUtils;

/* renamed from: com.oplus.ocs.base.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public final class C3645d {
    /* renamed from: PlatformImplementations.kt_3 */
    public static <T> T m25029a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException("null reference");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m25031a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Given String is empty or null");
        }
        return str;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static <T> T m25030a(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m25032a(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }
}
