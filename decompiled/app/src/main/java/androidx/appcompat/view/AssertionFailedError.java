package androidx.appcompat.view;

/* compiled from: ActionMode.java */
/* loaded from: classes.dex */
public abstract class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.lang.Object f322a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private boolean f323b;

    /* compiled from: ActionMode.java */
    public interface a_renamed {
        void a_renamed(androidx.appcompat.view.b_renamed bVar);

        boolean a_renamed(androidx.appcompat.view.b_renamed bVar, android.view.Menu menu);

        boolean a_renamed(androidx.appcompat.view.b_renamed bVar, android.view.MenuItem menuItem);

        boolean b_renamed(androidx.appcompat.view.b_renamed bVar, android.view.Menu menu);
    }

    public abstract android.view.MenuInflater a_renamed();

    public abstract void a_renamed(int i_renamed);

    public abstract void a_renamed(android.view.View view);

    public abstract void a_renamed(java.lang.CharSequence charSequence);

    public abstract android.view.Menu b_renamed();

    public abstract void b_renamed(int i_renamed);

    public abstract void b_renamed(java.lang.CharSequence charSequence);

    public abstract void c_renamed();

    public abstract void d_renamed();

    public abstract java.lang.CharSequence f_renamed();

    public abstract java.lang.CharSequence g_renamed();

    public boolean h_renamed() {
        return false;
    }

    public abstract android.view.View i_renamed();

    public void a_renamed(java.lang.Object obj) {
        this.f322a = obj;
    }

    public java.lang.Object j_renamed() {
        return this.f322a;
    }

    public void a_renamed(boolean z_renamed) {
        this.f323b = z_renamed;
    }

    public boolean k_renamed() {
        return this.f323b;
    }
}
