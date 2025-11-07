package androidx.appcompat.app;

/* compiled from: AppCompatActivity.java */
/* loaded from: classes.dex */
public class c_renamed extends androidx.fragment.app.c_renamed implements androidx.appcompat.app.d_renamed, androidx.core.app.m_renamed.a_renamed {
    private androidx.appcompat.app.e_renamed k_renamed;
    private android.content.res.Resources l_renamed;

    protected void a_renamed(int i_renamed) {
    }

    public void b_renamed(androidx.core.app.m_renamed mVar) {
    }

    @java.lang.Deprecated
    public void g_renamed() {
    }

    @Override // androidx.appcompat.app.d_renamed
    public void onSupportActionModeFinished(androidx.appcompat.view.b_renamed bVar) {
    }

    @Override // androidx.appcompat.app.d_renamed
    public void onSupportActionModeStarted(androidx.appcompat.view.b_renamed bVar) {
    }

    @Override // androidx.appcompat.app.d_renamed
    public androidx.appcompat.view.b_renamed onWindowStartingSupportActionMode(androidx.appcompat.view.b_renamed.a_renamed aVar) {
        return null;
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(android.content.Context context) {
        super.attachBaseContext(context);
        h_renamed().a_renamed(context);
    }

    @Override // androidx.fragment.app.c_renamed, androidx.activity.b_renamed, androidx.core.app.e_renamed, android.app.Activity
    protected void onCreate(android.os.Bundle bundle) {
        androidx.appcompat.app.e_renamed eVarH = h_renamed();
        eVarH.h_renamed();
        eVarH.a_renamed(bundle);
        super.onCreate(bundle);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i_renamed) {
        super.setTheme(i_renamed);
        h_renamed().a_renamed(i_renamed);
    }

    @Override // android.app.Activity
    protected void onPostCreate(android.os.Bundle bundle) {
        super.onPostCreate(bundle);
        h_renamed().b_renamed(bundle);
    }

    public androidx.appcompat.app.a_renamed i__renamed() {
        return h_renamed().a_renamed();
    }

    public void a_renamed(androidx.appcompat.widget.Toolbar toolbar) {
        h_renamed().a_renamed(toolbar);
    }

    @Override // android.app.Activity
    public android.view.MenuInflater getMenuInflater() {
        return h_renamed().b_renamed();
    }

    @Override // android.app.Activity
    public void setContentView(int i_renamed) {
        h_renamed().c_renamed(i_renamed);
    }

    @Override // android.app.Activity
    public void setContentView(android.view.View view) {
        h_renamed().a_renamed(view);
    }

    @Override // android.app.Activity
    public void setContentView(android.view.View view, android.view.ViewGroup.LayoutParams layoutParams) {
        h_renamed().a_renamed(view, layoutParams);
    }

    @Override // android.app.Activity
    public void addContentView(android.view.View view, android.view.ViewGroup.LayoutParams layoutParams) {
        h_renamed().b_renamed(view, layoutParams);
    }

    @Override // androidx.fragment.app.c_renamed, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.l_renamed != null) {
            this.l_renamed.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
        h_renamed().a_renamed(configuration);
    }

    @Override // androidx.fragment.app.c_renamed, android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        h_renamed().e_renamed();
    }

    @Override // androidx.fragment.app.c_renamed, android.app.Activity
    protected void onStart() {
        super.onStart();
        h_renamed().c_renamed();
    }

    @Override // androidx.fragment.app.c_renamed, android.app.Activity
    protected void onStop() {
        super.onStop();
        h_renamed().d_renamed();
    }

    @Override // android.app.Activity
    public <T_renamed extends android.view.View> T_renamed findViewById(int i_renamed) {
        return (T_renamed) h_renamed().b_renamed(i_renamed);
    }

    @Override // androidx.fragment.app.c_renamed, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i_renamed, android.view.MenuItem menuItem) {
        if (super.onMenuItemSelected(i_renamed, menuItem)) {
            return true;
        }
        androidx.appcompat.app.a_renamed aVarI_ = i__renamed();
        if (menuItem.getItemId() != 16908332 || aVarI_ == null || (aVarI_.a_renamed() & 4) == 0) {
            return false;
        }
        return e_renamed();
    }

    @Override // androidx.fragment.app.c_renamed, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        h_renamed().g_renamed();
    }

    @Override // android.app.Activity
    protected void onTitleChanged(java.lang.CharSequence charSequence, int i_renamed) {
        super.onTitleChanged(charSequence, i_renamed);
        h_renamed().a_renamed(charSequence);
    }

    @Override // androidx.fragment.app.c_renamed
    public void d_renamed() {
        h_renamed().f_renamed();
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        h_renamed().f_renamed();
    }

    public void a_renamed(androidx.core.app.m_renamed mVar) {
        mVar.a_renamed((android.app.Activity) this);
    }

    public boolean e_renamed() {
        android.content.Intent intentF = f_renamed();
        if (intentF == null) {
            return false;
        }
        if (a_renamed(intentF)) {
            androidx.core.app.m_renamed mVarA = androidx.core.app.m_renamed.a_renamed((android.content.Context) this);
            a_renamed(mVarA);
            b_renamed(mVarA);
            mVarA.a_renamed();
            try {
                androidx.core.app.a_renamed.a_renamed((android.app.Activity) this);
                return true;
            } catch (java.lang.IllegalStateException unused) {
                finish();
                return true;
            }
        }
        b_renamed(intentF);
        return true;
    }

    @Override // androidx.core.app.m_renamed.a_renamed
    public android.content.Intent f_renamed() {
        return androidx.core.app.f_renamed.a_renamed(this);
    }

    public boolean a_renamed(android.content.Intent intent) {
        return androidx.core.app.f_renamed.a_renamed(this, intent);
    }

    public void b_renamed(android.content.Intent intent) {
        androidx.core.app.f_renamed.b_renamed(this, intent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        g_renamed();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i_renamed, android.view.Menu menu) {
        return super.onMenuOpened(i_renamed, menu);
    }

    @Override // androidx.fragment.app.c_renamed, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i_renamed, android.view.Menu menu) {
        super.onPanelClosed(i_renamed, menu);
    }

    @Override // androidx.fragment.app.c_renamed, androidx.activity.b_renamed, androidx.core.app.e_renamed, android.app.Activity
    protected void onSaveInstanceState(android.os.Bundle bundle) {
        super.onSaveInstanceState(bundle);
        h_renamed().c_renamed(bundle);
    }

    public androidx.appcompat.app.e_renamed h_renamed() {
        if (this.k_renamed == null) {
            this.k_renamed = androidx.appcompat.app.e_renamed.a_renamed(this, this);
        }
        return this.k_renamed;
    }

    @Override // androidx.core.app.e_renamed, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(android.view.KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        androidx.appcompat.app.a_renamed aVarI_ = i__renamed();
        if (keyCode == 82 && aVarI_ != null && aVarI_.a_renamed(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public android.content.res.Resources getResources() {
        if (this.l_renamed == null && androidx.appcompat.widget.aw_renamed.a_renamed()) {
            this.l_renamed = new androidx.appcompat.widget.aw_renamed(this, super.getResources());
        }
        android.content.res.Resources resources = this.l_renamed;
        return resources == null ? super.getResources() : resources;
    }

    private boolean a_renamed(int i_renamed, android.view.KeyEvent keyEvent) {
        android.view.Window window;
        return (android.os.Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || android.view.KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || android.view.KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) ? false : true;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i_renamed, android.view.KeyEvent keyEvent) {
        if (a_renamed(i_renamed, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i_renamed, keyEvent);
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        androidx.appcompat.app.a_renamed aVarI_ = i__renamed();
        if (getWindow().hasFeature(0)) {
            if (aVarI_ == null || !aVarI_.c_renamed()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        androidx.appcompat.app.a_renamed aVarI_ = i__renamed();
        if (getWindow().hasFeature(0)) {
            if (aVarI_ == null || !aVarI_.d_renamed()) {
                super.closeOptionsMenu();
            }
        }
    }
}
