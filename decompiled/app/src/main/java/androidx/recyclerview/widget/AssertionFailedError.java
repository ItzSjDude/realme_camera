package androidx.recyclerview.widget;

/* compiled from: AdapterListUpdateCallback.java */
/* loaded from: classes.dex */
public final class b_renamed implements androidx.recyclerview.widget.l_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final androidx.recyclerview.widget.RecyclerView.a_renamed f1461a;

    public b_renamed(androidx.recyclerview.widget.RecyclerView.a_renamed aVar) {
        this.f1461a = aVar;
    }

    @Override // androidx.recyclerview.widget.l_renamed
    public void a_renamed(int i_renamed, int i2) {
        this.f1461a.notifyItemRangeInserted(i_renamed, i2);
    }

    @Override // androidx.recyclerview.widget.l_renamed
    public void b_renamed(int i_renamed, int i2) {
        this.f1461a.notifyItemRangeRemoved(i_renamed, i2);
    }

    @Override // androidx.recyclerview.widget.l_renamed
    public void c_renamed(int i_renamed, int i2) {
        this.f1461a.notifyItemMoved(i_renamed, i2);
    }

    @Override // androidx.recyclerview.widget.l_renamed
    public void a_renamed(int i_renamed, int i2, java.lang.Object obj) {
        this.f1461a.notifyItemRangeChanged(i_renamed, i2, obj);
    }
}
