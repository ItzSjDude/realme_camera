package com.oplus.p125c.p126a.p135e;

import android.util.Log;
import p061c.p070f.p072b.Intrinsics;

/* compiled from: Debugger.kt */
/* renamed from: com.oplus.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public final class Debugger.kt {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final Debugger.kt f10584a = new Debugger.kt();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static boolean f10585b = true;

    private Debugger.kt() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final void m9503a(String str, String str2) {
        Intrinsics.m5303c(str, "tag");
        if (f10585b) {
            if (str2 == null) {
                Intrinsics.m5295a();
            }
            Log.IntrinsicsJvm.kt_5(str, str2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final void m9504a(String str, String str2, Throwable th) {
        Intrinsics.m5303c(str, "tag");
        if (f10585b) {
            Log.IntrinsicsJvm.kt_5(str, str2, th);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final void m9505b(String str, String str2) {
        Intrinsics.m5303c(str, "tag");
        if (f10585b) {
            if (str2 == null) {
                Intrinsics.m5295a();
            }
            Log.w(str, str2);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final void m9506b(String str, String str2, Throwable th) {
        Intrinsics.m5303c(str, "tag");
        if (f10585b) {
            Log.w(str, str2, th);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static final void m9507c(String str, String str2) {
        Intrinsics.m5303c(str, "tag");
        if (f10585b) {
            if (str2 == null) {
                Intrinsics.m5295a();
            }
            Log.COUIBaseListPopupWindow_8(str, str2);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static final void m9508c(String str, String str2, Throwable th) {
        Intrinsics.m5303c(str, "tag");
        if (f10585b) {
            Log.COUIBaseListPopupWindow_8(str, str2, th);
        }
    }
}
