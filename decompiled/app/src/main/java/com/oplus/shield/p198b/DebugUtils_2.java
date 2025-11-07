package com.oplus.shield.p198b;

/* compiled from: DebugUtils.java */
/* renamed from: com.oplus.shield.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class DebugUtils_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private static volatile DebugUtils_2 f23772a = null;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static boolean f23773c = true;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static boolean f23774d;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean f23775b = false;

    private DebugUtils_2() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m25193a() {
        return !f23773c && f23774d;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static DebugUtils_2 m25192b() {
        if (f23772a == null) {
            synchronized (DebugUtils_2.class) {
                if (f23772a == null) {
                    f23772a = new DebugUtils_2();
                }
            }
        }
        return f23772a;
    }
}
