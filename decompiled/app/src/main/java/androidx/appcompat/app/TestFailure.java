package androidx.appcompat.app;

/* compiled from: AppCompatDialog.java */
/* loaded from: classes.dex */
public class f_renamed extends android.app.Dialog implements androidx.appcompat.app.d_renamed {
    private androidx.appcompat.app.e_renamed mDelegate;
    private final androidx.core.h_renamed.d_renamed.a_renamed mKeyDispatcher;

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

    public f_renamed(android.content.Context context) {
        this(context, 0);
    }

    public f_renamed(android.content.Context context, int i_renamed) {
        super(context, getThemeResId(context, i_renamed));
        this.mKeyDispatcher = new androidx.core.h_renamed.d_renamed.a_renamed() { // from class: androidx.appcompat.app.f_renamed.1
            @Override // androidx.core.h_renamed.d_renamed.a_renamed
            public boolean a_renamed(android.view.KeyEvent keyEvent) {
                return androidx.appcompat.app.f_renamed.this.superDispatchKeyEvent(keyEvent);
            }
        };
        androidx.appcompat.app.e_renamed delegate = getDelegate();
        delegate.a_renamed(getThemeResId(context, i_renamed));
        delegate.a_renamed((android.os.Bundle) null);
    }

    protected f_renamed(android.content.Context context, boolean z_renamed, android.content.DialogInterface.OnCancelListener onCancelListener) {
        super(context, z_renamed, onCancelListener);
        this.mKeyDispatcher = new androidx.core.h_renamed.d_renamed.a_renamed() { // from class: androidx.appcompat.app.f_renamed.1
            @Override // androidx.core.h_renamed.d_renamed.a_renamed
            public boolean a_renamed(android.view.KeyEvent keyEvent) {
                return androidx.appcompat.app.f_renamed.this.superDispatchKeyEvent(keyEvent);
            }
        };
    }

    @Override // android.app.Dialog
    protected void onCreate(android.os.Bundle bundle) {
        getDelegate().h_renamed();
        super.onCreate(bundle);
        getDelegate().a_renamed(bundle);
    }

    public androidx.appcompat.app.a_renamed getSupportActionBar() {
        return getDelegate().a_renamed();
    }

    @Override // android.app.Dialog
    public void setContentView(int i_renamed) {
        getDelegate().c_renamed(i_renamed);
    }

    @Override // android.app.Dialog
    public void setContentView(android.view.View view) {
        getDelegate().a_renamed(view);
    }

    @Override // android.app.Dialog
    public void setContentView(android.view.View view, android.view.ViewGroup.LayoutParams layoutParams) {
        getDelegate().a_renamed(view, layoutParams);
    }

    @Override // android.app.Dialog
    public <T_renamed extends android.view.View> T_renamed findViewById(int i_renamed) {
        return (T_renamed) getDelegate().b_renamed(i_renamed);
    }

    @Override // android.app.Dialog
    public void setTitle(java.lang.CharSequence charSequence) {
        super.setTitle(charSequence);
        getDelegate().a_renamed(charSequence);
    }

    @Override // android.app.Dialog
    public void setTitle(int i_renamed) {
        super.setTitle(i_renamed);
        getDelegate().a_renamed(getContext().getString(i_renamed));
    }

    @Override // android.app.Dialog
    public void addContentView(android.view.View view, android.view.ViewGroup.LayoutParams layoutParams) {
        getDelegate().b_renamed(view, layoutParams);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        getDelegate().d_renamed();
    }

    public boolean supportRequestWindowFeature(int i_renamed) {
        return getDelegate().d_renamed(i_renamed);
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        getDelegate().f_renamed();
    }

    public androidx.appcompat.app.e_renamed getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = androidx.appcompat.app.e_renamed.a_renamed(this, this);
        }
        return this.mDelegate;
    }

    private static int getThemeResId(android.content.Context context, int i_renamed) {
        if (i_renamed != 0) {
            return i_renamed;
        }
        android.util.TypedValue typedValue = new android.util.TypedValue();
        context.getTheme().resolveAttribute(androidx.appcompat.R_renamed.attr.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    boolean superDispatchKeyEvent(android.view.KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(android.view.KeyEvent keyEvent) {
        return androidx.core.h_renamed.d_renamed.a_renamed(this.mKeyDispatcher, getWindow().getDecorView(), this, keyEvent);
    }
}
