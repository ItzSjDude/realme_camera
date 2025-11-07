package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ChildHelper.java */
/* renamed from: androidx.recyclerview.widget.IntrinsicsJvm.kt_5 */
/* loaded from: classes.dex */
class ChildHelper {

    /* renamed from: PlatformImplementations.kt_3 */
    final IntrinsicsJvm.kt_4 f4150a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    final PlatformImplementations.kt_3 f4151b = new PlatformImplementations.kt_3();

    /* renamed from: IntrinsicsJvm.kt_3 */
    final List<View> f4152c = new ArrayList();

    /* compiled from: ChildHelper.java */
    /* renamed from: androidx.recyclerview.widget.IntrinsicsJvm.kt_5$IntrinsicsJvm.kt_4 */
    interface IntrinsicsJvm.kt_4 {
        /* renamed from: PlatformImplementations.kt_3 */
        int mo4088a();

        /* renamed from: PlatformImplementations.kt_3 */
        int mo4089a(View view);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo4090a(int OplusGLSurfaceView_13);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo4091a(View view, int OplusGLSurfaceView_13);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo4092a(View view, int OplusGLSurfaceView_13, ViewGroup.LayoutParams layoutParams);

        /* renamed from: IntrinsicsJvm.kt_4 */
        View mo4093b(int OplusGLSurfaceView_13);

        /* renamed from: IntrinsicsJvm.kt_4 */
        RecyclerView.AbstractC0707w mo4094b(View view);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo4095b();

        /* renamed from: IntrinsicsJvm.kt_3 */
        void mo4096c(int OplusGLSurfaceView_13);

        /* renamed from: IntrinsicsJvm.kt_3 */
        void mo4097c(View view);

        /* renamed from: IntrinsicsJvm.kt_5 */
        void mo4098d(View view);
    }

    ChildHelper(IntrinsicsJvm.kt_4 bVar) {
        this.f4150a = bVar;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m4376g(View view) {
        this.f4152c.add(view);
        this.f4150a.mo4097c(view);
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean m4377h(View view) {
        if (!this.f4152c.remove(view)) {
            return false;
        }
        this.f4150a.mo4098d(view);
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m4383a(View view, boolean z) {
        m4382a(view, -1, z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m4382a(View view, int OplusGLSurfaceView_13, boolean z) {
        int iM4375f;
        if (OplusGLSurfaceView_13 < 0) {
            iM4375f = this.f4150a.mo4088a();
        } else {
            iM4375f = m4375f(OplusGLSurfaceView_13);
        }
        this.f4151b.m4398a(iM4375f, z);
        if (z) {
            m4376g(view);
        }
        this.f4150a.mo4091a(view, iM4375f);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int m4375f(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0) {
            return -1;
        }
        int iMo4088a = this.f4150a.mo4088a();
        int i2 = OplusGLSurfaceView_13;
        while (i2 < iMo4088a) {
            int iM4402e = OplusGLSurfaceView_13 - (i2 - this.f4151b.m4402e(i2));
            if (iM4402e == 0) {
                while (this.f4151b.m4400c(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += iM4402e;
        }
        return -1;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m4380a(View view) {
        int iMo4089a = this.f4150a.mo4089a(view);
        if (iMo4089a < 0) {
            return;
        }
        if (this.f4151b.m4401d(iMo4089a)) {
            m4377h(view);
        }
        this.f4150a.mo4090a(iMo4089a);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m4379a(int OplusGLSurfaceView_13) {
        int iM4375f = m4375f(OplusGLSurfaceView_13);
        View viewMo4093b = this.f4150a.mo4093b(iM4375f);
        if (viewMo4093b == null) {
            return;
        }
        if (this.f4151b.m4401d(iM4375f)) {
            m4377h(viewMo4093b);
        }
        this.f4150a.mo4090a(iM4375f);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    View m4386b(int OplusGLSurfaceView_13) {
        return this.f4150a.mo4093b(m4375f(OplusGLSurfaceView_13));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m4378a() {
        this.f4151b.m4396a();
        for (int size = this.f4152c.size() - 1; size >= 0; size--) {
            this.f4150a.mo4098d(this.f4152c.get(size));
            this.f4152c.remove(size);
        }
        this.f4150a.mo4095b();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    View m4388c(int OplusGLSurfaceView_13) {
        int size = this.f4152c.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.f4152c.get(i2);
            RecyclerView.AbstractC0707w abstractC0707wMo4094b = this.f4150a.mo4094b(view);
            if (abstractC0707wMo4094b.getLayoutPosition() == OplusGLSurfaceView_13 && !abstractC0707wMo4094b.isInvalid() && !abstractC0707wMo4094b.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m4381a(View view, int OplusGLSurfaceView_13, ViewGroup.LayoutParams layoutParams, boolean z) {
        int iM4375f;
        if (OplusGLSurfaceView_13 < 0) {
            iM4375f = this.f4150a.mo4088a();
        } else {
            iM4375f = m4375f(OplusGLSurfaceView_13);
        }
        this.f4151b.m4398a(iM4375f, z);
        if (z) {
            m4376g(view);
        }
        this.f4150a.mo4092a(view, iM4375f, layoutParams);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    int m4384b() {
        return this.f4150a.mo4088a() - this.f4152c.size();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    int m4387c() {
        return this.f4150a.mo4088a();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    View m4390d(int OplusGLSurfaceView_13) {
        return this.f4150a.mo4093b(OplusGLSurfaceView_13);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    void m4392e(int OplusGLSurfaceView_13) {
        int iM4375f = m4375f(OplusGLSurfaceView_13);
        this.f4151b.m4401d(iM4375f);
        this.f4150a.mo4096c(iM4375f);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    int m4385b(View view) {
        int iMo4089a = this.f4150a.mo4089a(view);
        if (iMo4089a == -1 || this.f4151b.m4400c(iMo4089a)) {
            return -1;
        }
        return iMo4089a - this.f4151b.m4402e(iMo4089a);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    boolean m4389c(View view) {
        return this.f4152c.contains(view);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    void m4391d(View view) {
        int iMo4089a = this.f4150a.mo4089a(view);
        if (iMo4089a < 0) {
            throw new IllegalArgumentException("view is not PlatformImplementations.kt_3 child, cannot hide " + view);
        }
        this.f4151b.m4397a(iMo4089a);
        m4376g(view);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    void m4393e(View view) {
        int iMo4089a = this.f4150a.mo4089a(view);
        if (iMo4089a < 0) {
            throw new IllegalArgumentException("view is not PlatformImplementations.kt_3 child, cannot hide " + view);
        }
        if (!this.f4151b.m4400c(iMo4089a)) {
            throw new RuntimeException("trying to unhide PlatformImplementations.kt_3 view that was not hidden" + view);
        }
        this.f4151b.m4399b(iMo4089a);
        m4377h(view);
    }

    public String toString() {
        return this.f4151b.toString() + ", hidden list:" + this.f4152c.size();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    boolean m4394f(View view) {
        int iMo4089a = this.f4150a.mo4089a(view);
        if (iMo4089a == -1) {
            m4377h(view);
            return true;
        }
        if (!this.f4151b.m4400c(iMo4089a)) {
            return false;
        }
        this.f4151b.m4401d(iMo4089a);
        m4377h(view);
        this.f4150a.mo4090a(iMo4089a);
        return true;
    }

    /* compiled from: ChildHelper.java */
    /* renamed from: androidx.recyclerview.widget.IntrinsicsJvm.kt_5$PlatformImplementations.kt_3 */
    static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        long f4153a = 0;

        /* renamed from: IntrinsicsJvm.kt_4 */
        PlatformImplementations.kt_3 f4154b;

        PlatformImplementations.kt_3() {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m4397a(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 >= 64) {
                m4395b();
                this.f4154b.m4397a(OplusGLSurfaceView_13 - 64);
            } else {
                this.f4153a |= 1 << OplusGLSurfaceView_13;
            }
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        private void m4395b() {
            if (this.f4154b == null) {
                this.f4154b = new PlatformImplementations.kt_3();
            }
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        void m4399b(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 >= 64) {
                PlatformImplementations.kt_3 aVar = this.f4154b;
                if (aVar != null) {
                    aVar.m4399b(OplusGLSurfaceView_13 - 64);
                    return;
                }
                return;
            }
            this.f4153a &= ~(1 << OplusGLSurfaceView_13);
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        boolean m4400c(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 < 64) {
                return ((1 << OplusGLSurfaceView_13) & this.f4153a) != 0;
            }
            m4395b();
            return this.f4154b.m4400c(OplusGLSurfaceView_13 - 64);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m4396a() {
            this.f4153a = 0L;
            PlatformImplementations.kt_3 aVar = this.f4154b;
            if (aVar != null) {
                aVar.m4396a();
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m4398a(int OplusGLSurfaceView_13, boolean z) {
            if (OplusGLSurfaceView_13 >= 64) {
                m4395b();
                this.f4154b.m4398a(OplusGLSurfaceView_13 - 64, z);
                return;
            }
            boolean z2 = (this.f4153a & Long.MIN_VALUE) != 0;
            long OplusGLSurfaceView_15 = (1 << OplusGLSurfaceView_13) - 1;
            long j2 = this.f4153a;
            this.f4153a = ((j2 & (~OplusGLSurfaceView_15)) << 1) | (j2 & OplusGLSurfaceView_15);
            if (z) {
                m4397a(OplusGLSurfaceView_13);
            } else {
                m4399b(OplusGLSurfaceView_13);
            }
            if (z2 || this.f4154b != null) {
                m4395b();
                this.f4154b.m4398a(0, z2);
            }
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        boolean m4401d(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 >= 64) {
                m4395b();
                return this.f4154b.m4401d(OplusGLSurfaceView_13 - 64);
            }
            long OplusGLSurfaceView_15 = 1 << OplusGLSurfaceView_13;
            boolean z = (this.f4153a & OplusGLSurfaceView_15) != 0;
            this.f4153a &= ~OplusGLSurfaceView_15;
            long j2 = OplusGLSurfaceView_15 - 1;
            long j3 = this.f4153a;
            this.f4153a = Long.rotateRight(j3 & (~j2), 1) | (j3 & j2);
            PlatformImplementations.kt_3 aVar = this.f4154b;
            if (aVar != null) {
                if (aVar.m4400c(0)) {
                    m4397a(63);
                }
                this.f4154b.m4401d(0);
            }
            return z;
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        int m4402e(int OplusGLSurfaceView_13) {
            PlatformImplementations.kt_3 aVar = this.f4154b;
            if (aVar == null) {
                if (OplusGLSurfaceView_13 >= 64) {
                    return Long.bitCount(this.f4153a);
                }
                return Long.bitCount(((1 << OplusGLSurfaceView_13) - 1) & this.f4153a);
            }
            if (OplusGLSurfaceView_13 < 64) {
                return Long.bitCount(((1 << OplusGLSurfaceView_13) - 1) & this.f4153a);
            }
            return aVar.m4402e(OplusGLSurfaceView_13 - 64) + Long.bitCount(this.f4153a);
        }

        public String toString() {
            if (this.f4154b == null) {
                return Long.toBinaryString(this.f4153a);
            }
            return this.f4154b.toString() + "xx" + Long.toBinaryString(this.f4153a);
        }
    }
}
