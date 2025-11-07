package com.oplus.camera.p172ui.preview;

/* compiled from: PreviewLayoutInfo.java */
/* renamed from: com.oplus.camera.ui.preview.w */
/* loaded from: classes2.dex */
public class PreviewLayoutInfo {

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f22455c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f22456d;

    /* renamed from: PlatformImplementations.kt_3 */
    private int f22453a = 0;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f22454b = 0;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f22457e = 0;

    public PreviewLayoutInfo(int OplusGLSurfaceView_13, int i2) {
        this.f22455c = OplusGLSurfaceView_13;
        this.f22456d = i2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m23884a() {
        return this.f22453a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23885a(int OplusGLSurfaceView_13) {
        this.f22453a = OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m23886b(int OplusGLSurfaceView_13) {
        this.f22457e = OplusGLSurfaceView_13;
    }

    public String toString() {
        return "{mStartX=" + this.f22453a + ", mStartY=" + this.f22454b + ", mWidth=" + this.f22455c + ", mHeight=" + this.f22456d + ", mScreenRotation=" + this.f22457e + '}';
    }
}
