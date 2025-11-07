package com.oplus.camera.p146gl;

import android.os.SystemClock;

/* compiled from: AnimationTime.java */
/* renamed from: com.oplus.camera.gl.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class AnimationTime {

    /* renamed from: PlatformImplementations.kt_3 */
    private static volatile long f13918a;

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m13866a() {
        f13918a = SystemClock.uptimeMillis();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static long m13867b() {
        return f13918a;
    }
}
