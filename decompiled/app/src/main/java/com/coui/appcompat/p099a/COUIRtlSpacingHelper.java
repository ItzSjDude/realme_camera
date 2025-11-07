package com.coui.appcompat.p099a;

/* compiled from: COUIRtlSpacingHelper.java */
/* renamed from: com.coui.appcompat.PlatformImplementations.kt_3.p */
/* loaded from: classes.dex */
public class COUIRtlSpacingHelper {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f6336a = 0;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f6337b = 0;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f6338c = Integer.MIN_VALUE;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f6339d = Integer.MIN_VALUE;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f6340e = 0;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f6341f = 0;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f6342g = false;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f6343h = false;

    /* renamed from: PlatformImplementations.kt_3 */
    public int m6453a() {
        return this.f6336a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m6456b() {
        return this.f6337b;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int m6458c() {
        return this.f6342g ? this.f6337b : this.f6336a;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public int m6459d() {
        return this.f6342g ? this.f6336a : this.f6337b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6454a(int OplusGLSurfaceView_13, int i2) {
        this.f6338c = OplusGLSurfaceView_13;
        this.f6339d = i2;
        this.f6343h = true;
        if (this.f6342g) {
            if (i2 != Integer.MIN_VALUE) {
                this.f6336a = i2;
            }
            if (OplusGLSurfaceView_13 != Integer.MIN_VALUE) {
                this.f6337b = OplusGLSurfaceView_13;
                return;
            }
            return;
        }
        if (OplusGLSurfaceView_13 != Integer.MIN_VALUE) {
            this.f6336a = OplusGLSurfaceView_13;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f6337b = i2;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m6457b(int OplusGLSurfaceView_13, int i2) {
        this.f6343h = false;
        if (OplusGLSurfaceView_13 != Integer.MIN_VALUE) {
            this.f6340e = OplusGLSurfaceView_13;
            this.f6336a = OplusGLSurfaceView_13;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f6341f = i2;
            this.f6337b = i2;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6455a(boolean z) {
        if (z == this.f6342g) {
            return;
        }
        this.f6342g = z;
        if (!this.f6343h) {
            this.f6336a = this.f6340e;
            this.f6337b = this.f6341f;
            return;
        }
        if (z) {
            int OplusGLSurfaceView_13 = this.f6339d;
            if (OplusGLSurfaceView_13 == Integer.MIN_VALUE) {
                OplusGLSurfaceView_13 = this.f6340e;
            }
            this.f6336a = OplusGLSurfaceView_13;
            int i2 = this.f6338c;
            if (i2 == Integer.MIN_VALUE) {
                i2 = this.f6341f;
            }
            this.f6337b = i2;
            return;
        }
        int i3 = this.f6338c;
        if (i3 == Integer.MIN_VALUE) {
            i3 = this.f6340e;
        }
        this.f6336a = i3;
        int i4 = this.f6339d;
        if (i4 == Integer.MIN_VALUE) {
            i4 = this.f6341f;
        }
        this.f6337b = i4;
    }
}
