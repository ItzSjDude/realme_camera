package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: SimpleItemAnimator.java */
/* renamed from: androidx.recyclerview.widget.r */
/* loaded from: classes.dex */
public abstract class SimpleItemAnimator extends RecyclerView.AbstractC0690f {

    /* renamed from: COUIBaseListPopupWindow_10 */
    boolean f4302h = true;

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract boolean mo4410a(RecyclerView.AbstractC0707w abstractC0707w);

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract boolean mo4411a(RecyclerView.AbstractC0707w abstractC0707w, int OplusGLSurfaceView_13, int i2, int i3, int i4);

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract boolean mo4412a(RecyclerView.AbstractC0707w abstractC0707w, RecyclerView.AbstractC0707w abstractC0707w2, int OplusGLSurfaceView_13, int i2, int i3, int i4);

    /* renamed from: IntrinsicsJvm.kt_4 */
    public abstract boolean mo4414b(RecyclerView.AbstractC0707w abstractC0707w);

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m4531c(RecyclerView.AbstractC0707w abstractC0707w, boolean z) {
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m4532d(RecyclerView.AbstractC0707w abstractC0707w, boolean z) {
    }

    /* renamed from: o */
    public void m4539o(RecyclerView.AbstractC0707w abstractC0707w) {
    }

    /* renamed from: p */
    public void m4540p(RecyclerView.AbstractC0707w abstractC0707w) {
    }

    /* renamed from: q */
    public void m4541q(RecyclerView.AbstractC0707w abstractC0707w) {
    }

    /* renamed from: r */
    public void m4542r(RecyclerView.AbstractC0707w abstractC0707w) {
    }

    /* renamed from: s */
    public void m4543s(RecyclerView.AbstractC0707w abstractC0707w) {
    }

    /* renamed from: t */
    public void m4544t(RecyclerView.AbstractC0707w abstractC0707w) {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m4529a(boolean z) {
        this.f4302h = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0690f
    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean mo4141h(RecyclerView.AbstractC0707w abstractC0707w) {
        return !this.f4302h || abstractC0707w.isInvalid();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0690f
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo4127a(RecyclerView.AbstractC0707w abstractC0707w, RecyclerView.AbstractC0690f.IntrinsicsJvm.kt_3 cVar, RecyclerView.AbstractC0690f.IntrinsicsJvm.kt_3 cVar2) {
        int OplusGLSurfaceView_13 = cVar.f4028a;
        int i2 = cVar.f4029b;
        View view = abstractC0707w.itemView;
        int left = cVar2 == null ? view.getLeft() : cVar2.f4028a;
        int top = cVar2 == null ? view.getTop() : cVar2.f4029b;
        if (!abstractC0707w.isRemoved() && (OplusGLSurfaceView_13 != left || i2 != top)) {
            view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
            return mo4411a(abstractC0707w, OplusGLSurfaceView_13, i2, left, top);
        }
        return mo4410a(abstractC0707w);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0690f
    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean mo4131b(RecyclerView.AbstractC0707w abstractC0707w, RecyclerView.AbstractC0690f.IntrinsicsJvm.kt_3 cVar, RecyclerView.AbstractC0690f.IntrinsicsJvm.kt_3 cVar2) {
        if (cVar != null && (cVar.f4028a != cVar2.f4028a || cVar.f4029b != cVar2.f4029b)) {
            return mo4411a(abstractC0707w, cVar.f4028a, cVar.f4029b, cVar2.f4028a, cVar2.f4029b);
        }
        return mo4414b(abstractC0707w);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0690f
    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean mo4132c(RecyclerView.AbstractC0707w abstractC0707w, RecyclerView.AbstractC0690f.IntrinsicsJvm.kt_3 cVar, RecyclerView.AbstractC0690f.IntrinsicsJvm.kt_3 cVar2) {
        if (cVar.f4028a != cVar2.f4028a || cVar.f4029b != cVar2.f4029b) {
            return mo4411a(abstractC0707w, cVar.f4028a, cVar.f4029b, cVar2.f4028a, cVar2.f4029b);
        }
        m4534j(abstractC0707w);
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0690f
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo4128a(RecyclerView.AbstractC0707w abstractC0707w, RecyclerView.AbstractC0707w abstractC0707w2, RecyclerView.AbstractC0690f.IntrinsicsJvm.kt_3 cVar, RecyclerView.AbstractC0690f.IntrinsicsJvm.kt_3 cVar2) {
        int OplusGLSurfaceView_13;
        int i2;
        int i3 = cVar.f4028a;
        int i4 = cVar.f4029b;
        if (abstractC0707w2.shouldIgnore()) {
            int i5 = cVar.f4028a;
            i2 = cVar.f4029b;
            OplusGLSurfaceView_13 = i5;
        } else {
            OplusGLSurfaceView_13 = cVar2.f4028a;
            i2 = cVar2.f4029b;
        }
        return mo4412a(abstractC0707w, abstractC0707w2, i3, i4, OplusGLSurfaceView_13, i2);
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public final void m4533i(RecyclerView.AbstractC0707w abstractC0707w) {
        m4540p(abstractC0707w);
        m4137f(abstractC0707w);
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public final void m4534j(RecyclerView.AbstractC0707w abstractC0707w) {
        m4544t(abstractC0707w);
        m4137f(abstractC0707w);
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public final void m4535k(RecyclerView.AbstractC0707w abstractC0707w) {
        m4542r(abstractC0707w);
        m4137f(abstractC0707w);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m4528a(RecyclerView.AbstractC0707w abstractC0707w, boolean z) {
        m4532d(abstractC0707w, z);
        m4137f(abstractC0707w);
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public final void m4536l(RecyclerView.AbstractC0707w abstractC0707w) {
        m4539o(abstractC0707w);
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public final void m4537m(RecyclerView.AbstractC0707w abstractC0707w) {
        m4543s(abstractC0707w);
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public final void m4538n(RecyclerView.AbstractC0707w abstractC0707w) {
        m4541q(abstractC0707w);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public final void m4530b(RecyclerView.AbstractC0707w abstractC0707w, boolean z) {
        m4531c(abstractC0707w, z);
    }
}
