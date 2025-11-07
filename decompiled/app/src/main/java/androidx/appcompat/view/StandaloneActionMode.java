package androidx.appcompat.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* compiled from: StandaloneActionMode.java */
/* renamed from: androidx.appcompat.view.COUIBaseListPopupWindow_8 */
/* loaded from: classes.dex */
public class StandaloneActionMode extends ActionMode implements MenuBuilder.PlatformImplementations.kt_3 {

    /* renamed from: PlatformImplementations.kt_3 */
    private Context f1175a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private ActionBarContextView f1176b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private ActionMode.PlatformImplementations.kt_3 f1177c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private WeakReference<View> f1178d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f1179e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f1180f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private MenuBuilder f1181g;

    public StandaloneActionMode(Context context, ActionBarContextView actionBarContextView, ActionMode.PlatformImplementations.kt_3 aVar, boolean z) {
        this.f1175a = context;
        this.f1176b = actionBarContextView;
        this.f1177c = aVar;
        this.f1181g = new MenuBuilder(actionBarContextView.getContext()).setDefaultShowAsAction(1);
        this.f1181g.setCallback(this);
        this.f1180f = z;
    }

    @Override // androidx.appcompat.view.ActionMode
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo972b(CharSequence charSequence) {
        this.f1176b.setTitle(charSequence);
    }

    @Override // androidx.appcompat.view.ActionMode
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo968a(CharSequence charSequence) {
        this.f1176b.setSubtitle(charSequence);
    }

    @Override // androidx.appcompat.view.ActionMode
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo966a(int OplusGLSurfaceView_13) {
        mo972b(this.f1175a.getString(OplusGLSurfaceView_13));
    }

    @Override // androidx.appcompat.view.ActionMode
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo971b(int OplusGLSurfaceView_13) {
        mo968a((CharSequence) this.f1175a.getString(OplusGLSurfaceView_13));
    }

    @Override // androidx.appcompat.view.ActionMode
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo969a(boolean z) {
        super.mo969a(z);
        this.f1176b.setTitleOptional(z);
    }

    @Override // androidx.appcompat.view.ActionMode
    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean mo978h() {
        return this.f1176b.m1223d();
    }

    @Override // androidx.appcompat.view.ActionMode
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo967a(View view) {
        this.f1176b.setCustomView(view);
        this.f1178d = view != null ? new WeakReference<>(view) : null;
    }

    @Override // androidx.appcompat.view.ActionMode
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo974d() {
        this.f1177c.mo866b(this, this.f1181g);
    }

    @Override // androidx.appcompat.view.ActionMode
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo973c() {
        if (this.f1179e) {
            return;
        }
        this.f1179e = true;
        this.f1176b.sendAccessibilityEvent(32);
        this.f1177c.mo863a(this);
    }

    @Override // androidx.appcompat.view.ActionMode
    /* renamed from: IntrinsicsJvm.kt_4 */
    public Menu mo970b() {
        return this.f1181g;
    }

    @Override // androidx.appcompat.view.ActionMode
    /* renamed from: COUIBaseListPopupWindow_12 */
    public CharSequence mo976f() {
        return this.f1176b.getTitle();
    }

    @Override // androidx.appcompat.view.ActionMode
    /* renamed from: COUIBaseListPopupWindow_11 */
    public CharSequence mo977g() {
        return this.f1176b.getSubtitle();
    }

    @Override // androidx.appcompat.view.ActionMode
    /* renamed from: OplusGLSurfaceView_13 */
    public View mo979i() {
        WeakReference<View> weakReference = this.f1178d;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // androidx.appcompat.view.ActionMode
    /* renamed from: PlatformImplementations.kt_3 */
    public MenuInflater mo965a() {
        return new SupportMenuInflater(this.f1176b.getContext());
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.PlatformImplementations.kt_3
    public boolean onMenuItemSelected(MenuBuilder c0236h, MenuItem menuItem) {
        return this.f1177c.mo865a(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.PlatformImplementations.kt_3
    public void onMenuModeChange(MenuBuilder c0236h) {
        mo974d();
        this.f1176b.mo1220a();
    }
}
