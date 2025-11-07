package androidx.appcompat.view;

/* compiled from: StandaloneActionMode.java */
/* loaded from: classes.dex */
public class e_renamed extends androidx.appcompat.view.b_renamed implements androidx.appcompat.view.menu.h_renamed.a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.content.Context f327a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private androidx.appcompat.widget.ActionBarContextView f328b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private androidx.appcompat.view.b_renamed.a_renamed f329c;
    private java.lang.ref.WeakReference<android.view.View> d_renamed;
    private boolean e_renamed;
    private boolean f_renamed;
    private androidx.appcompat.view.menu.h_renamed g_renamed;

    public e_renamed(android.content.Context context, androidx.appcompat.widget.ActionBarContextView actionBarContextView, androidx.appcompat.view.b_renamed.a_renamed aVar, boolean z_renamed) {
        this.f327a = context;
        this.f328b = actionBarContextView;
        this.f329c = aVar;
        this.g_renamed = new androidx.appcompat.view.menu.h_renamed(actionBarContextView.getContext()).setDefaultShowAsAction(1);
        this.g_renamed.setCallback(this);
        this.f_renamed = z_renamed;
    }

    @Override // androidx.appcompat.view.b_renamed
    public void b_renamed(java.lang.CharSequence charSequence) {
        this.f328b.setTitle(charSequence);
    }

    @Override // androidx.appcompat.view.b_renamed
    public void a_renamed(java.lang.CharSequence charSequence) {
        this.f328b.setSubtitle(charSequence);
    }

    @Override // androidx.appcompat.view.b_renamed
    public void a_renamed(int i_renamed) {
        b_renamed(this.f327a.getString(i_renamed));
    }

    @Override // androidx.appcompat.view.b_renamed
    public void b_renamed(int i_renamed) {
        a_renamed((java.lang.CharSequence) this.f327a.getString(i_renamed));
    }

    @Override // androidx.appcompat.view.b_renamed
    public void a_renamed(boolean z_renamed) {
        super.a_renamed(z_renamed);
        this.f328b.setTitleOptional(z_renamed);
    }

    @Override // androidx.appcompat.view.b_renamed
    public boolean h_renamed() {
        return this.f328b.d_renamed();
    }

    @Override // androidx.appcompat.view.b_renamed
    public void a_renamed(android.view.View view) {
        this.f328b.setCustomView(view);
        this.d_renamed = view != null ? new java.lang.ref.WeakReference<>(view) : null;
    }

    @Override // androidx.appcompat.view.b_renamed
    public void d_renamed() {
        this.f329c.b_renamed(this, this.g_renamed);
    }

    @Override // androidx.appcompat.view.b_renamed
    public void c_renamed() {
        if (this.e_renamed) {
            return;
        }
        this.e_renamed = true;
        this.f328b.sendAccessibilityEvent(32);
        this.f329c.a_renamed(this);
    }

    @Override // androidx.appcompat.view.b_renamed
    public android.view.Menu b_renamed() {
        return this.g_renamed;
    }

    @Override // androidx.appcompat.view.b_renamed
    public java.lang.CharSequence f_renamed() {
        return this.f328b.getTitle();
    }

    @Override // androidx.appcompat.view.b_renamed
    public java.lang.CharSequence g_renamed() {
        return this.f328b.getSubtitle();
    }

    @Override // androidx.appcompat.view.b_renamed
    public android.view.View i_renamed() {
        java.lang.ref.WeakReference<android.view.View> weakReference = this.d_renamed;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // androidx.appcompat.view.b_renamed
    public android.view.MenuInflater a_renamed() {
        return new androidx.appcompat.view.g_renamed(this.f328b.getContext());
    }

    @Override // androidx.appcompat.view.menu.h_renamed.a_renamed
    public boolean onMenuItemSelected(androidx.appcompat.view.menu.h_renamed hVar, android.view.MenuItem menuItem) {
        return this.f329c.a_renamed(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.h_renamed.a_renamed
    public void onMenuModeChange(androidx.appcompat.view.menu.h_renamed hVar) {
        d_renamed();
        this.f328b.a_renamed();
    }
}
