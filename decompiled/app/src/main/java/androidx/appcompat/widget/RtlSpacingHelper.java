package androidx.appcompat.widget;

/* compiled from: RtlSpacingHelper.java */
/* renamed from: androidx.appcompat.widget.aj */
/* loaded from: classes.dex */
class RtlSpacingHelper {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f1807a = 0;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f1808b = 0;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f1809c = Integer.MIN_VALUE;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f1810d = Integer.MIN_VALUE;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f1811e = 0;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f1812f = 0;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f1813g = false;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f1814h = false;

    RtlSpacingHelper() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m1490a() {
        return this.f1807a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m1493b() {
        return this.f1808b;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int m1495c() {
        return this.f1813g ? this.f1808b : this.f1807a;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public int m1496d() {
        return this.f1813g ? this.f1807a : this.f1808b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1491a(int OplusGLSurfaceView_13, int i2) {
        this.f1809c = OplusGLSurfaceView_13;
        this.f1810d = i2;
        this.f1814h = true;
        if (this.f1813g) {
            if (i2 != Integer.MIN_VALUE) {
                this.f1807a = i2;
            }
            if (OplusGLSurfaceView_13 != Integer.MIN_VALUE) {
                this.f1808b = OplusGLSurfaceView_13;
                return;
            }
            return;
        }
        if (OplusGLSurfaceView_13 != Integer.MIN_VALUE) {
            this.f1807a = OplusGLSurfaceView_13;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f1808b = i2;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m1494b(int OplusGLSurfaceView_13, int i2) {
        this.f1814h = false;
        if (OplusGLSurfaceView_13 != Integer.MIN_VALUE) {
            this.f1811e = OplusGLSurfaceView_13;
            this.f1807a = OplusGLSurfaceView_13;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f1812f = i2;
            this.f1808b = i2;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1492a(boolean z) {
        if (z == this.f1813g) {
            return;
        }
        this.f1813g = z;
        if (!this.f1814h) {
            this.f1807a = this.f1811e;
            this.f1808b = this.f1812f;
            return;
        }
        if (z) {
            int OplusGLSurfaceView_13 = this.f1810d;
            if (OplusGLSurfaceView_13 == Integer.MIN_VALUE) {
                OplusGLSurfaceView_13 = this.f1811e;
            }
            this.f1807a = OplusGLSurfaceView_13;
            int i2 = this.f1809c;
            if (i2 == Integer.MIN_VALUE) {
                i2 = this.f1812f;
            }
            this.f1808b = i2;
            return;
        }
        int i3 = this.f1809c;
        if (i3 == Integer.MIN_VALUE) {
            i3 = this.f1811e;
        }
        this.f1807a = i3;
        int i4 = this.f1810d;
        if (i4 == Integer.MIN_VALUE) {
            i4 = this.f1812f;
        }
        this.f1808b = i4;
    }
}
