package androidx.recyclerview.widget;

/* compiled from: LayoutState.java */
/* loaded from: classes.dex */
class i_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    int f1536b;

    /* renamed from: c_renamed, reason: collision with root package name */
    int f1537c;
    int d_renamed;
    int e_renamed;
    boolean h_renamed;
    boolean i_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    boolean f1535a = true;
    int f_renamed = 0;
    int g_renamed = 0;

    i_renamed() {
    }

    boolean a_renamed(androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        int i_renamed = this.f1537c;
        return i_renamed >= 0 && i_renamed < tVar.e_renamed();
    }

    android.view.View a_renamed(androidx.recyclerview.widget.RecyclerView.p_renamed pVar) {
        android.view.View viewC = pVar.c_renamed(this.f1537c);
        this.f1537c += this.d_renamed;
        return viewC;
    }

    public java.lang.String toString() {
        return "LayoutState{mAvailable=" + this.f1536b + ", mCurrentPosition=" + this.f1537c + ", mItemDirection=" + this.d_renamed + ", mLayoutDirection=" + this.e_renamed + ", mStartLine=" + this.f_renamed + ", mEndLine=" + this.g_renamed + '}';
    }
}
