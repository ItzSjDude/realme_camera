package androidx.fragment.app;

/* compiled from: FragmentController.java */
/* loaded from: classes.dex */
public class e_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final androidx.fragment.app.g_renamed<?> f1135a;

    public static androidx.fragment.app.e_renamed a_renamed(androidx.fragment.app.g_renamed<?> gVar) {
        return new androidx.fragment.app.e_renamed((androidx.fragment.app.g_renamed) androidx.core.g_renamed.f_renamed.a_renamed(gVar, "callbacks == null"));
    }

    private e_renamed(androidx.fragment.app.g_renamed<?> gVar) {
        this.f1135a = gVar;
    }

    public androidx.fragment.app.h_renamed a_renamed() {
        return this.f1135a.f1138b;
    }

    public androidx.fragment.app.Fragment a_renamed(java.lang.String str) {
        return this.f1135a.f1138b.b_renamed(str);
    }

    public void a_renamed(androidx.fragment.app.Fragment fragment) {
        androidx.fragment.app.i_renamed iVar = this.f1135a.f1138b;
        androidx.fragment.app.g_renamed<?> gVar = this.f1135a;
        iVar.a_renamed(gVar, gVar, fragment);
    }

    public android.view.View a_renamed(android.view.View view, java.lang.String str, android.content.Context context, android.util.AttributeSet attributeSet) {
        return this.f1135a.f1138b.onCreateView(view, str, context, attributeSet);
    }

    public void b_renamed() {
        this.f1135a.f1138b.p_renamed();
    }

    public android.os.Parcelable c_renamed() {
        return this.f1135a.f1138b.o_renamed();
    }

    public void a_renamed(android.os.Parcelable parcelable) {
        androidx.fragment.app.g_renamed<?> gVar = this.f1135a;
        if (!(gVar instanceof androidx.lifecycle.t_renamed)) {
            throw new java.lang.IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
        }
        gVar.f1138b.a_renamed(parcelable);
    }

    public void d_renamed() {
        this.f1135a.f1138b.q_renamed();
    }

    public void e_renamed() {
        this.f1135a.f1138b.r_renamed();
    }

    public void f_renamed() {
        this.f1135a.f1138b.s_renamed();
    }

    public void g_renamed() {
        this.f1135a.f1138b.t_renamed();
    }

    public void h_renamed() {
        this.f1135a.f1138b.u_renamed();
    }

    public void i_renamed() {
        this.f1135a.f1138b.v_renamed();
    }

    public void j_renamed() {
        this.f1135a.f1138b.x_renamed();
    }

    public void a_renamed(boolean z_renamed) {
        this.f1135a.f1138b.a_renamed(z_renamed);
    }

    public void b_renamed(boolean z_renamed) {
        this.f1135a.f1138b.b_renamed(z_renamed);
    }

    public void a_renamed(android.content.res.Configuration configuration) {
        this.f1135a.f1138b.a_renamed(configuration);
    }

    public void k_renamed() {
        this.f1135a.f1138b.y_renamed();
    }

    public boolean a_renamed(android.view.Menu menu, android.view.MenuInflater menuInflater) {
        return this.f1135a.f1138b.a_renamed(menu, menuInflater);
    }

    public boolean a_renamed(android.view.Menu menu) {
        return this.f1135a.f1138b.a_renamed(menu);
    }

    public boolean a_renamed(android.view.MenuItem menuItem) {
        return this.f1135a.f1138b.a_renamed(menuItem);
    }

    public boolean b_renamed(android.view.MenuItem menuItem) {
        return this.f1135a.f1138b.b_renamed(menuItem);
    }

    public void b_renamed(android.view.Menu menu) {
        this.f1135a.f1138b.b_renamed(menu);
    }

    public boolean l_renamed() {
        return this.f1135a.f1138b.l_renamed();
    }
}
