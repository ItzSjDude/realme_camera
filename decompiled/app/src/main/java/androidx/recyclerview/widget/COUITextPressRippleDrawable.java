package androidx.recyclerview.widget;

/* compiled from: SimpleItemAnimator.java */
/* loaded from: classes.dex */
public abstract class r_renamed extends androidx.recyclerview.widget.RecyclerView.f_renamed {
    boolean h_renamed = true;

    public abstract boolean a_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar);

    public abstract boolean a_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar, int i_renamed, int i2, int i3, int i4);

    public abstract boolean a_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar, androidx.recyclerview.widget.RecyclerView.w_renamed wVar2, int i_renamed, int i2, int i3, int i4);

    public abstract boolean b_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar);

    public void c_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar, boolean z_renamed) {
    }

    public void d_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar, boolean z_renamed) {
    }

    public void o_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
    }

    public void p_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
    }

    public void q_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
    }

    public void r_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
    }

    public void s_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
    }

    public void t_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
    }

    public void a_renamed(boolean z_renamed) {
        this.h_renamed = z_renamed;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f_renamed
    public boolean h_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
        return !this.h_renamed || wVar.isInvalid();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f_renamed
    public boolean a_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar, androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed cVar, androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed cVar2) {
        int i_renamed = cVar.f1413a;
        int i2 = cVar.f1414b;
        android.view.View view = wVar.itemView;
        int left = cVar2 == null ? view.getLeft() : cVar2.f1413a;
        int top = cVar2 == null ? view.getTop() : cVar2.f1414b;
        if (!wVar.isRemoved() && (i_renamed != left || i2 != top)) {
            view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
            return a_renamed(wVar, i_renamed, i2, left, top);
        }
        return a_renamed(wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f_renamed
    public boolean b_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar, androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed cVar, androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed cVar2) {
        if (cVar != null && (cVar.f1413a != cVar2.f1413a || cVar.f1414b != cVar2.f1414b)) {
            return a_renamed(wVar, cVar.f1413a, cVar.f1414b, cVar2.f1413a, cVar2.f1414b);
        }
        return b_renamed(wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f_renamed
    public boolean c_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar, androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed cVar, androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed cVar2) {
        if (cVar.f1413a != cVar2.f1413a || cVar.f1414b != cVar2.f1414b) {
            return a_renamed(wVar, cVar.f1413a, cVar.f1414b, cVar2.f1413a, cVar2.f1414b);
        }
        j_renamed(wVar);
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f_renamed
    public boolean a_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar, androidx.recyclerview.widget.RecyclerView.w_renamed wVar2, androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed cVar, androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed cVar2) {
        int i_renamed;
        int i2;
        int i3 = cVar.f1413a;
        int i4 = cVar.f1414b;
        if (wVar2.shouldIgnore()) {
            int i5 = cVar.f1413a;
            i2 = cVar.f1414b;
            i_renamed = i5;
        } else {
            i_renamed = cVar2.f1413a;
            i2 = cVar2.f1414b;
        }
        return a_renamed(wVar, wVar2, i3, i4, i_renamed, i2);
    }

    public final void i_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
        p_renamed(wVar);
        f_renamed(wVar);
    }

    public final void j_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
        t_renamed(wVar);
        f_renamed(wVar);
    }

    public final void k_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
        r_renamed(wVar);
        f_renamed(wVar);
    }

    public final void a_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar, boolean z_renamed) {
        d_renamed(wVar, z_renamed);
        f_renamed(wVar);
    }

    public final void l_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
        o_renamed(wVar);
    }

    public final void m_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
        s_renamed(wVar);
    }

    public final void n_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
        q_renamed(wVar);
    }

    public final void b_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar, boolean z_renamed) {
        c_renamed(wVar, z_renamed);
    }
}
