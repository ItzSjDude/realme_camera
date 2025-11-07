package androidx.recyclerview.widget;

import android.view.View;

/* compiled from: ViewBoundsCheck.java */
/* renamed from: androidx.recyclerview.widget.t */
/* loaded from: classes.dex */
class ViewBoundsCheck {

    /* renamed from: PlatformImplementations.kt_3 */
    final IntrinsicsJvm.kt_4 f4309a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    PlatformImplementations.kt_3 f4310b = new PlatformImplementations.kt_3();

    /* compiled from: ViewBoundsCheck.java */
    /* renamed from: androidx.recyclerview.widget.t$IntrinsicsJvm.kt_4 */
    interface IntrinsicsJvm.kt_4 {
        /* renamed from: PlatformImplementations.kt_3 */
        int mo4148a();

        /* renamed from: PlatformImplementations.kt_3 */
        int mo4149a(View view);

        /* renamed from: PlatformImplementations.kt_3 */
        View mo4150a(int OplusGLSurfaceView_13);

        /* renamed from: IntrinsicsJvm.kt_4 */
        int mo4151b();

        /* renamed from: IntrinsicsJvm.kt_4 */
        int mo4152b(View view);
    }

    ViewBoundsCheck(IntrinsicsJvm.kt_4 bVar) {
        this.f4309a = bVar;
    }

    /* compiled from: ViewBoundsCheck.java */
    /* renamed from: androidx.recyclerview.widget.t$PlatformImplementations.kt_3 */
    static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        int f4311a = 0;

        /* renamed from: IntrinsicsJvm.kt_4 */
        int f4312b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        int f4313c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        int f4314d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        int f4315e;

        /* renamed from: PlatformImplementations.kt_3 */
        int m4554a(int OplusGLSurfaceView_13, int i2) {
            if (OplusGLSurfaceView_13 > i2) {
                return 1;
            }
            return OplusGLSurfaceView_13 == i2 ? 2 : 4;
        }

        PlatformImplementations.kt_3() {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m4557a(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
            this.f4312b = OplusGLSurfaceView_13;
            this.f4313c = i2;
            this.f4314d = i3;
            this.f4315e = i4;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m4556a(int OplusGLSurfaceView_13) {
            this.f4311a = OplusGLSurfaceView_13 | this.f4311a;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m4555a() {
            this.f4311a = 0;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        boolean m4558b() {
            int OplusGLSurfaceView_13 = this.f4311a;
            if ((OplusGLSurfaceView_13 & 7) != 0 && (OplusGLSurfaceView_13 & (m4554a(this.f4314d, this.f4312b) << 0)) == 0) {
                return false;
            }
            int i2 = this.f4311a;
            if ((i2 & 112) != 0 && (i2 & (m4554a(this.f4314d, this.f4313c) << 4)) == 0) {
                return false;
            }
            int i3 = this.f4311a;
            if ((i3 & 1792) != 0 && (i3 & (m4554a(this.f4315e, this.f4312b) << 8)) == 0) {
                return false;
            }
            int i4 = this.f4311a;
            return (i4 & 28672) == 0 || ((m4554a(this.f4315e, this.f4313c) << 12) & i4) != 0;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    View m4552a(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        int iMo4148a = this.f4309a.mo4148a();
        int iMo4151b = this.f4309a.mo4151b();
        int i5 = i2 > OplusGLSurfaceView_13 ? 1 : -1;
        View view = null;
        while (OplusGLSurfaceView_13 != i2) {
            View viewMo4150a = this.f4309a.mo4150a(OplusGLSurfaceView_13);
            this.f4310b.m4557a(iMo4148a, iMo4151b, this.f4309a.mo4149a(viewMo4150a), this.f4309a.mo4152b(viewMo4150a));
            if (i3 != 0) {
                this.f4310b.m4555a();
                this.f4310b.m4556a(i3);
                if (this.f4310b.m4558b()) {
                    return viewMo4150a;
                }
            }
            if (i4 != 0) {
                this.f4310b.m4555a();
                this.f4310b.m4556a(i4);
                if (this.f4310b.m4558b()) {
                    view = viewMo4150a;
                }
            }
            OplusGLSurfaceView_13 += i5;
        }
        return view;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    boolean m4553a(View view, int OplusGLSurfaceView_13) {
        this.f4310b.m4557a(this.f4309a.mo4148a(), this.f4309a.mo4151b(), this.f4309a.mo4149a(view), this.f4309a.mo4152b(view));
        if (OplusGLSurfaceView_13 == 0) {
            return false;
        }
        this.f4310b.m4555a();
        this.f4310b.m4556a(OplusGLSurfaceView_13);
        return this.f4310b.m4558b();
    }
}
