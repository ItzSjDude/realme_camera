package com.coui.appcompat.p099a;

/* compiled from: COUIMathUtils.java */
/* renamed from: com.coui.appcompat.PlatformImplementations.kt_3.OplusGLSurfaceView_15 */
/* loaded from: classes.dex */
public class COUIMathUtils {
    /* renamed from: PlatformImplementations.kt_3 */
    public static int m6429a(int OplusGLSurfaceView_13, int i2) {
        return OplusGLSurfaceView_13 - (m6430b(OplusGLSurfaceView_13, i2) * i2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static int m6430b(int OplusGLSurfaceView_13, int i2) {
        int i3 = OplusGLSurfaceView_13 / i2;
        return ((OplusGLSurfaceView_13 ^ i2) >= 0 || i2 * i3 == OplusGLSurfaceView_13) ? i3 : i3 - 1;
    }
}
