package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.WindowCallbackWrapper;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.Toolbar;
import androidx.core.p036h.ViewCompat;
import java.util.ArrayList;

/* compiled from: ToolbarActionBar.java */
/* renamed from: androidx.appcompat.app.OplusGLSurfaceView_13 */
/* loaded from: classes.dex */
class ToolbarActionBar extends ActionBar {

    /* renamed from: PlatformImplementations.kt_3 */
    DecorToolbar f1022a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    boolean f1023b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    Window.Callback f1024c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f1025d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f1026e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private ArrayList<ActionBar.IntrinsicsJvm.kt_4> f1027f = new ArrayList<>();

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final Runnable f1028g = new Runnable() { // from class: androidx.appcompat.app.OplusGLSurfaceView_13.1
        @Override // java.lang.Runnable
        public void run() {
            ToolbarActionBar.this.m934i();
        }
    };

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final Toolbar.InterfaceC0302c f1029h = new Toolbar.InterfaceC0302c() { // from class: androidx.appcompat.app.OplusGLSurfaceView_13.2
        @Override // androidx.appcompat.widget.Toolbar.InterfaceC0302c
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo935a(MenuItem menuItem) {
            return ToolbarActionBar.this.f1024c.onMenuItemSelected(0, menuItem);
        }
    };

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo884b(boolean z) {
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo887d(boolean z) {
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo889e(boolean z) {
    }

    ToolbarActionBar(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        this.f1022a = new ToolbarWidgetWrapper(toolbar, false);
        this.f1024c = new IntrinsicsJvm.kt_3(callback);
        this.f1022a.mo1573a(this.f1024c);
        toolbar.setOnMenuItemClickListener(this.f1029h);
        this.f1022a.mo1576a(charSequence);
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public Window.Callback m933h() {
        return this.f1024c;
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo877a(float COUIBaseListPopupWindow_12) {
        ViewCompat.m2841a(this.f1022a.mo1567a(), COUIBaseListPopupWindow_12);
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: IntrinsicsJvm.kt_4 */
    public Context mo883b() {
        return this.f1022a.mo1578b();
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo878a(Configuration configuration) {
        super.mo878a(configuration);
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo879a(CharSequence charSequence) {
        this.f1022a.mo1576a(charSequence);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m932a(int OplusGLSurfaceView_13, int i2) {
        this.f1022a.mo1583c((OplusGLSurfaceView_13 & i2) | ((~i2) & this.f1022a.mo1602o()));
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo880a(boolean z) {
        m932a(z ? 4 : 0, 4);
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: PlatformImplementations.kt_3 */
    public int mo875a() {
        return this.f1022a.mo1602o();
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean mo886c() {
        return this.f1022a.mo1598k();
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean mo888d() {
        return this.f1022a.mo1599l();
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean mo890e() {
        this.f1022a.mo1567a().removeCallbacks(this.f1028g);
        ViewCompat.m2857a(this.f1022a.mo1567a(), this.f1028g);
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: COUIBaseListPopupWindow_12 */
    public boolean mo892f() {
        if (!this.f1022a.mo1586c()) {
            return false;
        }
        this.f1022a.mo1587d();
        return true;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    void m934i() {
        Menu menuM931j = m931j();
        MenuBuilder c0236h = menuM931j instanceof MenuBuilder ? (MenuBuilder) menuM931j : null;
        if (c0236h != null) {
            c0236h.stopDispatchingItemsChanged();
        }
        try {
            menuM931j.clear();
            if (!this.f1024c.onCreatePanelMenu(0, menuM931j) || !this.f1024c.onPreparePanel(0, null, menuM931j)) {
                menuM931j.clear();
            }
        } finally {
            if (c0236h != null) {
                c0236h.startDispatchingItemsChanged();
            }
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo882a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            mo886c();
        }
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo881a(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
        Menu menuM931j = m931j();
        if (menuM931j == null) {
            return false;
        }
        menuM931j.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuM931j.performShortcut(OplusGLSurfaceView_13, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: COUIBaseListPopupWindow_11 */
    void mo893g() {
        this.f1022a.mo1567a().removeCallbacks(this.f1028g);
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void mo891f(boolean z) {
        if (z == this.f1026e) {
            return;
        }
        this.f1026e = z;
        int size = this.f1027f.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            this.f1027f.get(OplusGLSurfaceView_13).m894a(z);
        }
    }

    /* compiled from: ToolbarActionBar.java */
    /* renamed from: androidx.appcompat.app.OplusGLSurfaceView_13$IntrinsicsJvm.kt_3 */
    private class IntrinsicsJvm.kt_3 extends WindowCallbackWrapper {
        public IntrinsicsJvm.kt_3(Window.Callback callback) {
            super(callback);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onPreparePanel(int OplusGLSurfaceView_13, View view, Menu menu) {
            boolean zOnPreparePanel = super.onPreparePanel(OplusGLSurfaceView_13, view, menu);
            if (zOnPreparePanel && !ToolbarActionBar.this.f1023b) {
                ToolbarActionBar.this.f1022a.mo1600m();
                ToolbarActionBar.this.f1023b = true;
            }
            return zOnPreparePanel;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public View onCreatePanelView(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 == 0) {
                return new View(ToolbarActionBar.this.f1022a.mo1578b());
            }
            return super.onCreatePanelView(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private Menu m931j() {
        if (!this.f1025d) {
            this.f1022a.mo1574a(new PlatformImplementations.kt_3(), new IntrinsicsJvm.kt_4());
            this.f1025d = true;
        }
        return this.f1022a.mo1604q();
    }

    /* compiled from: ToolbarActionBar.java */
    /* renamed from: androidx.appcompat.app.OplusGLSurfaceView_13$PlatformImplementations.kt_3 */
    private final class PlatformImplementations.kt_3 implements MenuPresenter.PlatformImplementations.kt_3 {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private boolean f1033b;

        PlatformImplementations.kt_3() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo862a(MenuBuilder c0236h) {
            if (ToolbarActionBar.this.f1024c == null) {
                return false;
            }
            ToolbarActionBar.this.f1024c.onMenuOpened(108, c0236h);
            return true;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo861a(MenuBuilder c0236h, boolean z) {
            if (this.f1033b) {
                return;
            }
            this.f1033b = true;
            ToolbarActionBar.this.f1022a.mo1601n();
            if (ToolbarActionBar.this.f1024c != null) {
                ToolbarActionBar.this.f1024c.onPanelClosed(108, c0236h);
            }
            this.f1033b = false;
        }
    }

    /* compiled from: ToolbarActionBar.java */
    /* renamed from: androidx.appcompat.app.OplusGLSurfaceView_13$IntrinsicsJvm.kt_4 */
    private final class IntrinsicsJvm.kt_4 implements MenuBuilder.PlatformImplementations.kt_3 {
        @Override // androidx.appcompat.view.menu.MenuBuilder.PlatformImplementations.kt_3
        public boolean onMenuItemSelected(MenuBuilder c0236h, MenuItem menuItem) {
            return false;
        }

        IntrinsicsJvm.kt_4() {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.PlatformImplementations.kt_3
        public void onMenuModeChange(MenuBuilder c0236h) {
            if (ToolbarActionBar.this.f1024c != null) {
                if (ToolbarActionBar.this.f1022a.mo1596i()) {
                    ToolbarActionBar.this.f1024c.onPanelClosed(108, c0236h);
                } else if (ToolbarActionBar.this.f1024c.onPreparePanel(0, null, c0236h)) {
                    ToolbarActionBar.this.f1024c.onMenuOpened(108, c0236h);
                }
            }
        }
    }
}
