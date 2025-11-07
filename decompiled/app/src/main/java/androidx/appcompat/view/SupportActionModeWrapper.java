package androidx.appcompat.view;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuWrapperICS;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.collection.SimpleArrayMap;
import androidx.core.p029b.p030a.SupportMenu;
import androidx.core.p029b.p030a.SupportMenuItem;
import java.util.ArrayList;

/* compiled from: SupportActionModeWrapper.java */
/* renamed from: androidx.appcompat.view.COUIBaseListPopupWindow_12 */
/* loaded from: classes.dex */
public class SupportActionModeWrapper extends ActionMode {

    /* renamed from: PlatformImplementations.kt_3 */
    final Context f1182a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    final ActionMode f1183b;

    public SupportActionModeWrapper(Context context, ActionMode abstractC0221b) {
        this.f1182a = context;
        this.f1183b = abstractC0221b;
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f1183b.m1056j();
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f1183b.m1055a(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f1183b.mo972b(charSequence);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f1183b.mo968a(charSequence);
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f1183b.mo974d();
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f1183b.mo973c();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new MenuWrapperICS(this.f1182a, (SupportMenu) this.f1183b.mo970b());
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f1183b.mo976f();
    }

    @Override // android.view.ActionMode
    public void setTitle(int OplusGLSurfaceView_13) {
        this.f1183b.mo966a(OplusGLSurfaceView_13);
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f1183b.mo977g();
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int OplusGLSurfaceView_13) {
        this.f1183b.mo971b(OplusGLSurfaceView_13);
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f1183b.mo979i();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f1183b.mo967a(view);
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f1183b.mo965a();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f1183b.m1057k();
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z) {
        this.f1183b.mo969a(z);
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f1183b.mo978h();
    }

    /* compiled from: SupportActionModeWrapper.java */
    /* renamed from: androidx.appcompat.view.COUIBaseListPopupWindow_12$PlatformImplementations.kt_3 */
    public static class PlatformImplementations.kt_3 implements ActionMode.PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        final ActionMode.Callback f1184a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        final Context f1185b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        final ArrayList<SupportActionModeWrapper> f1186c = new ArrayList<>();

        /* renamed from: IntrinsicsJvm.kt_5 */
        final SimpleArrayMap<Menu, Menu> f1187d = new SimpleArrayMap<>();

        public PlatformImplementations.kt_3(Context context, ActionMode.Callback callback) {
            this.f1185b = context;
            this.f1184a = callback;
        }

        @Override // androidx.appcompat.view.ActionMode.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo864a(ActionMode abstractC0221b, Menu menu) {
            return this.f1184a.onCreateActionMode(m1064b(abstractC0221b), m1063a(menu));
        }

        @Override // androidx.appcompat.view.ActionMode.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_4 */
        public boolean mo866b(ActionMode abstractC0221b, Menu menu) {
            return this.f1184a.onPrepareActionMode(m1064b(abstractC0221b), m1063a(menu));
        }

        @Override // androidx.appcompat.view.ActionMode.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo865a(ActionMode abstractC0221b, MenuItem menuItem) {
            return this.f1184a.onActionItemClicked(m1064b(abstractC0221b), new MenuItemWrapperICS(this.f1185b, (SupportMenuItem) menuItem));
        }

        @Override // androidx.appcompat.view.ActionMode.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo863a(ActionMode abstractC0221b) {
            this.f1184a.onDestroyActionMode(m1064b(abstractC0221b));
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private Menu m1063a(Menu menu) {
            Menu menu2 = this.f1187d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            MenuWrapperICS menuC0244p = new MenuWrapperICS(this.f1185b, (SupportMenu) menu);
            this.f1187d.put(menu, menuC0244p);
            return menuC0244p;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public ActionMode m1064b(ActionMode abstractC0221b) {
            int size = this.f1186c.size();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                SupportActionModeWrapper c0225f = this.f1186c.get(OplusGLSurfaceView_13);
                if (c0225f != null && c0225f.f1183b == abstractC0221b) {
                    return c0225f;
                }
            }
            SupportActionModeWrapper c0225f2 = new SupportActionModeWrapper(this.f1185b, abstractC0221b);
            this.f1186c.add(c0225f2);
            return c0225f2;
        }
    }
}
