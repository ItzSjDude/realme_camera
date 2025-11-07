package androidx.appcompat.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.appcompat.view.ActionMode;
import androidx.core.p036h.KeyEventDispatcher;

/* compiled from: AppCompatDialog.java */
/* renamed from: androidx.appcompat.app.COUIBaseListPopupWindow_12 */
/* loaded from: classes.dex */
public class AppCompatDialog extends Dialog implements AppCompatCallback {
    private AppCompatDelegate mDelegate;
    private final KeyEventDispatcher.PlatformImplementations.kt_3 mKeyDispatcher;

    @Override // androidx.appcompat.app.AppCompatCallback
    public void onSupportActionModeFinished(ActionMode abstractC0221b) {
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public void onSupportActionModeStarted(ActionMode abstractC0221b) {
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public ActionMode onWindowStartingSupportActionMode(ActionMode.PlatformImplementations.kt_3 aVar) {
        return null;
    }

    public AppCompatDialog(Context context) {
        this(context, 0);
    }

    public AppCompatDialog(Context context, int OplusGLSurfaceView_13) {
        super(context, getThemeResId(context, OplusGLSurfaceView_13));
        this.mKeyDispatcher = new KeyEventDispatcher.PlatformImplementations.kt_3() { // from class: androidx.appcompat.app.COUIBaseListPopupWindow_12.1
            @Override // androidx.core.p036h.KeyEventDispatcher.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public boolean mo925a(KeyEvent keyEvent) {
                return AppCompatDialog.this.superDispatchKeyEvent(keyEvent);
            }
        };
        AppCompatDelegate delegate = getDelegate();
        delegate.mo800a(getThemeResId(context, OplusGLSurfaceView_13));
        delegate.mo804a((Bundle) null);
    }

    protected AppCompatDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        this.mKeyDispatcher = new KeyEventDispatcher.PlatformImplementations.kt_3() { // from class: androidx.appcompat.app.COUIBaseListPopupWindow_12.1
            @Override // androidx.core.p036h.KeyEventDispatcher.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public boolean mo925a(KeyEvent keyEvent) {
                return AppCompatDialog.this.superDispatchKeyEvent(keyEvent);
            }
        };
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        getDelegate().mo832h();
        super.onCreate(bundle);
        getDelegate().mo804a(bundle);
    }

    public ActionBar getSupportActionBar() {
        return getDelegate().mo798a();
    }

    @Override // android.app.Dialog
    public void setContentView(int OplusGLSurfaceView_13) {
        getDelegate().mo821c(OplusGLSurfaceView_13);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        getDelegate().mo805a(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().mo806a(view, layoutParams);
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int OplusGLSurfaceView_13) {
        return (T) getDelegate().mo815b(OplusGLSurfaceView_13);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        getDelegate().mo811a(charSequence);
    }

    @Override // android.app.Dialog
    public void setTitle(int OplusGLSurfaceView_13) {
        super.setTitle(OplusGLSurfaceView_13);
        getDelegate().mo811a(getContext().getString(OplusGLSurfaceView_13));
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().mo818b(view, layoutParams);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        getDelegate().mo824d();
    }

    public boolean supportRequestWindowFeature(int OplusGLSurfaceView_13) {
        return getDelegate().mo825d(OplusGLSurfaceView_13);
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        getDelegate().mo828f();
    }

    public AppCompatDelegate getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = AppCompatDelegate.m920a(this, this);
        }
        return this.mDelegate;
    }

    private static int getThemeResId(Context context, int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 != 0) {
            return OplusGLSurfaceView_13;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return KeyEventDispatcher.m2780a(this.mKeyDispatcher, getWindow().getDecorView(), this, keyEvent);
    }
}
