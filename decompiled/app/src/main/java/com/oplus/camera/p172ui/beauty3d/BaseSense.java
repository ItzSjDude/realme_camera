package com.oplus.camera.p172ui.beauty3d;

import android.graphics.drawable.Drawable;

/* compiled from: BaseSense.java */
/* renamed from: com.oplus.camera.ui.beauty3d.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class BaseSense {

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int f17629b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int f17630c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public int f17631d;

    /* renamed from: COUIBaseListPopupWindow_12 */
    public Drawable f17633f;

    /* renamed from: PlatformImplementations.kt_3 */
    public int f17628a = 0;

    /* renamed from: COUIBaseListPopupWindow_8 */
    public int f17632e = 0;

    public BaseSense(int OplusGLSurfaceView_13, int i2, Drawable drawable, int i3) {
        this.f17629b = 0;
        this.f17630c = 0;
        this.f17631d = 0;
        this.f17633f = null;
        this.f17629b = i2;
        this.f17633f = drawable;
        this.f17630c = OplusGLSurfaceView_13;
        this.f17631d = i3;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m18571a() {
        return this.f17632e;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18572a(int OplusGLSurfaceView_13) {
        this.f17632e = OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m18573b() {
        return this.f17628a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m18574b(int OplusGLSurfaceView_13) {
        this.f17628a = OplusGLSurfaceView_13;
    }
}
