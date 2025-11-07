package com.oplus.camera;

/* compiled from: PhoneMotionState.java */
/* renamed from: com.oplus.camera.y */
/* loaded from: classes2.dex */
public class PhoneMotionState {

    /* renamed from: PlatformImplementations.kt_3 */
    private static volatile boolean f23236a = false;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static float f23237b = 1.0f;

    /* renamed from: PlatformImplementations.kt_3 */
    public static float m24831a() {
        return f23237b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24832a(boolean z) {
        f23236a = z;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static boolean m24833b() {
        CameraLog.m12954a("PhoneMotionState", "isPhoneMovingState: " + f23236a);
        return f23236a;
    }
}
