package androidx.appcompat.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NavUtils;
import androidx.core.app.TaskStackBuilder;
import androidx.fragment.app.FragmentActivity;

/* compiled from: AppCompatActivity.java */
/* renamed from: androidx.appcompat.app.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public class AppCompatActivity extends FragmentActivity implements AppCompatCallback, TaskStackBuilder.PlatformImplementations.kt_3 {

    /* renamed from: OplusGLSurfaceView_5 */
    private AppCompatDelegate f1008k;

    /* renamed from: OplusGLSurfaceView_14 */
    private Resources f1009l;

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m907a(int OplusGLSurfaceView_13) {
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m912b(TaskStackBuilder c0439m) {
    }

    @Deprecated
    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m916g() {
    }

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

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        m917h().mo802a(context);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity_3, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        AppCompatDelegate abstractC0207eM917h = m917h();
        abstractC0207eM917h.mo832h();
        abstractC0207eM917h.mo804a(bundle);
        super.onCreate(bundle);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int OplusGLSurfaceView_13) {
        super.setTheme(OplusGLSurfaceView_13);
        m917h().mo800a(OplusGLSurfaceView_13);
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        m917h().mo817b(bundle);
    }

    /* renamed from: i_ */
    public ActionBar m918i_() {
        return m917h().mo798a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m908a(Toolbar toolbar) {
        m917h().mo810a(toolbar);
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return m917h().mo814b();
    }

    @Override // android.app.Activity
    public void setContentView(int OplusGLSurfaceView_13) {
        m917h().mo821c(OplusGLSurfaceView_13);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        m917h().mo805a(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m917h().mo806a(view, layoutParams);
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m917h().mo818b(view, layoutParams);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f1009l != null) {
            this.f1009l.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
        m917h().mo803a(configuration);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        m917h().mo826e();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        m917h().mo820c();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        m917h().mo824d();
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int OplusGLSurfaceView_13) {
        return (T) m917h().mo815b(OplusGLSurfaceView_13);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int OplusGLSurfaceView_13, MenuItem menuItem) {
        if (super.onMenuItemSelected(OplusGLSurfaceView_13, menuItem)) {
            return true;
        }
        ActionBar abstractC0203aM918i_ = m918i_();
        if (menuItem.getItemId() != 16908332 || abstractC0203aM918i_ == null || (abstractC0203aM918i_.mo875a() & 4) == 0) {
            return false;
        }
        return m914e();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        m917h().mo830g();
    }

    @Override // android.app.Activity
    protected void onTitleChanged(CharSequence charSequence, int OplusGLSurfaceView_13) {
        super.onTitleChanged(charSequence, OplusGLSurfaceView_13);
        m917h().mo811a(charSequence);
    }

    @Override // androidx.fragment.app.FragmentActivity
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo913d() {
        m917h().mo828f();
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        m917h().mo828f();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m909a(TaskStackBuilder c0439m) {
        c0439m.m2441a((Activity) this);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m914e() {
        Intent intentMo915f = mo915f();
        if (intentMo915f == null) {
            return false;
        }
        if (m910a(intentMo915f)) {
            TaskStackBuilder c0439mM2440a = TaskStackBuilder.m2440a((Context) this);
            m909a(c0439mM2440a);
            m912b(c0439mM2440a);
            c0439mM2440a.m2444a();
            try {
                ActivityCompat.m2344a((Activity) this);
                return true;
            } catch (IllegalStateException unused) {
                finish();
                return true;
            }
        }
        m911b(intentMo915f);
        return true;
    }

    @Override // androidx.core.app.TaskStackBuilder.PlatformImplementations.kt_3
    /* renamed from: COUIBaseListPopupWindow_12 */
    public Intent mo915f() {
        return NavUtils.m2370a(this);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m910a(Intent intent) {
        return NavUtils.m2372a(this, intent);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m911b(Intent intent) {
        NavUtils.m2375b(this, intent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        m916g();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int OplusGLSurfaceView_13, Menu menu) {
        return super.onMenuOpened(OplusGLSurfaceView_13, menu);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int OplusGLSurfaceView_13, Menu menu) {
        super.onPanelClosed(OplusGLSurfaceView_13, menu);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity_3, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        m917h().mo822c(bundle);
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public AppCompatDelegate m917h() {
        if (this.f1008k == null) {
            this.f1008k = AppCompatDelegate.m919a(this, this);
        }
        return this.f1008k;
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        ActionBar abstractC0203aM918i_ = m918i_();
        if (keyCode == 82 && abstractC0203aM918i_ != null && abstractC0203aM918i_.mo882a(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.f1009l == null && VectorEnabledTintResources.m1619a()) {
            this.f1009l = new VectorEnabledTintResources(this, super.getResources());
        }
        Resources resources = this.f1009l;
        return resources == null ? super.getResources() : resources;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m906a(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
        Window window;
        return (Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) ? false : true;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
        if (m906a(OplusGLSurfaceView_13, keyEvent)) {
            return true;
        }
        return super.onKeyDown(OplusGLSurfaceView_13, keyEvent);
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        ActionBar abstractC0203aM918i_ = m918i_();
        if (getWindow().hasFeature(0)) {
            if (abstractC0203aM918i_ == null || !abstractC0203aM918i_.mo886c()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        ActionBar abstractC0203aM918i_ = m918i_();
        if (getWindow().hasFeature(0)) {
            if (abstractC0203aM918i_ == null || !abstractC0203aM918i_.mo888d()) {
                super.closeOptionsMenu();
            }
        }
    }
}
