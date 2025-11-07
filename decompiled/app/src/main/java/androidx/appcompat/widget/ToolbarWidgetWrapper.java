package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.appcompat.R;
import androidx.appcompat.p016a.p017a.AppCompatResources;
import androidx.appcompat.view.menu.ActionMenuItem;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.Toolbar;
import androidx.core.p036h.ViewPropertyAnimatorListenerAdapter;
import androidx.core.p036h.ViewCompat;
import androidx.core.p036h.ViewPropertyAnimatorCompat;
import com.google.android.material.badge.BadgeDrawable;

/* compiled from: ToolbarWidgetWrapper.java */
/* renamed from: androidx.appcompat.widget.as */
/* loaded from: classes.dex */
public class ToolbarWidgetWrapper implements DecorToolbar {

    /* renamed from: PlatformImplementations.kt_3 */
    Toolbar f1877a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    CharSequence f1878b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    Window.Callback f1879c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    boolean f1880d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f1881e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private View f1882f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private View f1883g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private Drawable f1884h;

    /* renamed from: OplusGLSurfaceView_13 */
    private Drawable f1885i;

    /* renamed from: OplusGLSurfaceView_15 */
    private Drawable f1886j;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f1887k;

    /* renamed from: OplusGLSurfaceView_14 */
    private CharSequence f1888l;

    /* renamed from: OplusGLSurfaceView_6 */
    private CharSequence f1889m;

    /* renamed from: OplusGLSurfaceView_11 */
    private ActionMenuPresenter f1890n;

    /* renamed from: o */
    private int f1891o;

    /* renamed from: p */
    private int f1892p;

    /* renamed from: q */
    private Drawable f1893q;

    @Override // androidx.appcompat.widget.DecorToolbar
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo1582b(boolean z) {
    }

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z) {
        this(toolbar, z, R.string.abc_action_bar_up_description, R.drawable.abc_ic_ab_back_material);
    }

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z, int OplusGLSurfaceView_13, int i2) {
        Drawable drawable;
        this.f1891o = 0;
        this.f1892p = 0;
        this.f1877a = toolbar;
        this.f1878b = toolbar.getTitle();
        this.f1888l = toolbar.getSubtitle();
        this.f1887k = this.f1878b != null;
        this.f1886j = toolbar.getNavigationIcon();
        TintTypedArray c0322arM1541a = TintTypedArray.m1541a(toolbar.getContext(), null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        this.f1893q = c0322arM1541a.m1546a(R.styleable.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence charSequenceM1553c = c0322arM1541a.m1553c(R.styleable.ActionBar_title);
            if (!TextUtils.isEmpty(charSequenceM1553c)) {
                m1581b(charSequenceM1553c);
            }
            CharSequence charSequenceM1553c2 = c0322arM1541a.m1553c(R.styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(charSequenceM1553c2)) {
                m1585c(charSequenceM1553c2);
            }
            Drawable drawableM1546a = c0322arM1541a.m1546a(R.styleable.ActionBar_logo);
            if (drawableM1546a != null) {
                m1580b(drawableM1546a);
            }
            Drawable drawableM1546a2 = c0322arM1541a.m1546a(R.styleable.ActionBar_icon);
            if (drawableM1546a2 != null) {
                mo1570a(drawableM1546a2);
            }
            if (this.f1886j == null && (drawable = this.f1893q) != null) {
                m1584c(drawable);
            }
            mo1583c(c0322arM1541a.m1544a(R.styleable.ActionBar_displayOptions, 0));
            int iM1560g = c0322arM1541a.m1560g(R.styleable.ActionBar_customNavigationLayout, 0);
            if (iM1560g != 0) {
                m1572a(LayoutInflater.from(this.f1877a.getContext()).inflate(iM1560g, (ViewGroup) this.f1877a, false));
                mo1583c(this.f1881e | 16);
            }
            int iM1558f = c0322arM1541a.m1558f(R.styleable.ActionBar_height, 0);
            if (iM1558f > 0) {
                ViewGroup.LayoutParams layoutParams = this.f1877a.getLayoutParams();
                layoutParams.height = iM1558f;
                this.f1877a.setLayoutParams(layoutParams);
            }
            int iM1554d = c0322arM1541a.m1554d(R.styleable.ActionBar_contentInsetStart, -1);
            int iM1554d2 = c0322arM1541a.m1554d(R.styleable.ActionBar_contentInsetEnd, -1);
            if (iM1554d >= 0 || iM1554d2 >= 0) {
                this.f1877a.setContentInsetsRelative(Math.max(iM1554d, 0), Math.max(iM1554d2, 0));
            }
            int iM1560g2 = c0322arM1541a.m1560g(R.styleable.ActionBar_titleTextStyle, 0);
            if (iM1560g2 != 0) {
                Toolbar toolbar2 = this.f1877a;
                toolbar2.setTitleTextAppearance(toolbar2.getContext(), iM1560g2);
            }
            int iM1560g3 = c0322arM1541a.m1560g(R.styleable.ActionBar_subtitleTextStyle, 0);
            if (iM1560g3 != 0) {
                Toolbar toolbar3 = this.f1877a;
                toolbar3.setSubtitleTextAppearance(toolbar3.getContext(), iM1560g3);
            }
            int iM1560g4 = c0322arM1541a.m1560g(R.styleable.ActionBar_popupTheme, 0);
            if (iM1560g4 != 0) {
                this.f1877a.setPopupTheme(iM1560g4);
            }
        } else {
            this.f1881e = m1563r();
        }
        c0322arM1541a.m1551b();
        m1591e(OplusGLSurfaceView_13);
        this.f1889m = this.f1877a.getNavigationContentDescription();
        this.f1877a.setNavigationOnClickListener(new View.OnClickListener() { // from class: androidx.appcompat.widget.as.1

            /* renamed from: PlatformImplementations.kt_3 */
            final ActionMenuItem f1894a;

            {
                this.f1894a = new ActionMenuItem(ToolbarWidgetWrapper.this.f1877a.getContext(), 0, android.R.id_renamed.home, 0, 0, ToolbarWidgetWrapper.this.f1878b);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ToolbarWidgetWrapper.this.f1879c == null || !ToolbarWidgetWrapper.this.f1880d) {
                    return;
                }
                ToolbarWidgetWrapper.this.f1879c.onMenuItemSelected(0, this.f1894a);
            }
        });
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m1591e(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == this.f1892p) {
            return;
        }
        this.f1892p = OplusGLSurfaceView_13;
        if (TextUtils.isEmpty(this.f1877a.getNavigationContentDescription())) {
            m1593f(this.f1892p);
        }
    }

    /* renamed from: r */
    private int m1563r() {
        if (this.f1877a.getNavigationIcon() == null) {
            return 11;
        }
        this.f1893q = this.f1877a.getNavigationIcon();
        return 15;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    /* renamed from: PlatformImplementations.kt_3 */
    public ViewGroup mo1567a() {
        return this.f1877a;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    /* renamed from: IntrinsicsJvm.kt_4 */
    public Context mo1578b() {
        return this.f1877a.getContext();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean mo1586c() {
        return this.f1877a.hasExpandedActionView();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo1587d() {
        this.f1877a.collapseActionView();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo1573a(Window.Callback callback) {
        this.f1879c = callback;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo1576a(CharSequence charSequence) {
        if (this.f1887k) {
            return;
        }
        m1562e(charSequence);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    /* renamed from: COUIBaseListPopupWindow_8 */
    public CharSequence mo1590e() {
        return this.f1877a.getTitle();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m1581b(CharSequence charSequence) {
        this.f1887k = true;
        m1562e(charSequence);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m1562e(CharSequence charSequence) {
        this.f1878b = charSequence;
        if ((this.f1881e & 8) != 0) {
            this.f1877a.setTitle(charSequence);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m1585c(CharSequence charSequence) {
        this.f1888l = charSequence;
        if ((this.f1881e & 8) != 0) {
            this.f1877a.setSubtitle(charSequence);
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void mo1592f() {
        Log.OplusGLSurfaceView_13("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    /* renamed from: COUIBaseListPopupWindow_11 */
    public void mo1594g() {
        Log.OplusGLSurfaceView_13("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo1569a(int OplusGLSurfaceView_13) {
        mo1570a(OplusGLSurfaceView_13 != 0 ? AppCompatResources.m732b(mo1578b(), OplusGLSurfaceView_13) : null);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo1570a(Drawable drawable) {
        this.f1884h = drawable;
        m1564s();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo1579b(int OplusGLSurfaceView_13) {
        m1580b(OplusGLSurfaceView_13 != 0 ? AppCompatResources.m732b(mo1578b(), OplusGLSurfaceView_13) : null);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m1580b(Drawable drawable) {
        this.f1885i = drawable;
        m1564s();
    }

    /* renamed from: s */
    private void m1564s() {
        Drawable drawable;
        int OplusGLSurfaceView_13 = this.f1881e;
        if ((OplusGLSurfaceView_13 & 2) == 0) {
            drawable = null;
        } else if ((OplusGLSurfaceView_13 & 1) == 0 || (drawable = this.f1885i) == null) {
            drawable = this.f1884h;
        }
        this.f1877a.setLogo(drawable);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean mo1595h() {
        return this.f1877a.canShowOverflowMenu();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    /* renamed from: OplusGLSurfaceView_13 */
    public boolean mo1596i() {
        return this.f1877a.isOverflowMenuShowing();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    /* renamed from: OplusGLSurfaceView_15 */
    public boolean mo1597j() {
        return this.f1877a.isOverflowMenuShowPending();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    /* renamed from: OplusGLSurfaceView_5 */
    public boolean mo1598k() {
        return this.f1877a.showOverflowMenu();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    /* renamed from: OplusGLSurfaceView_14 */
    public boolean mo1599l() {
        return this.f1877a.hideOverflowMenu();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    /* renamed from: OplusGLSurfaceView_6 */
    public void mo1600m() {
        this.f1880d = true;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo1571a(Menu menu, MenuPresenter.PlatformImplementations.kt_3 aVar) {
        if (this.f1890n == null) {
            this.f1890n = new ActionMenuPresenter(this.f1877a.getContext());
            this.f1890n.m1113a(R.id_renamed.action_menu_presenter);
        }
        this.f1890n.setCallback(aVar);
        this.f1877a.setMenu((MenuBuilder) menu, this.f1890n);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    /* renamed from: OplusGLSurfaceView_11 */
    public void mo1601n() {
        this.f1877a.dismissPopupMenus();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    /* renamed from: o */
    public int mo1602o() {
        return this.f1881e;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo1583c(int OplusGLSurfaceView_13) {
        View view;
        int i2 = this.f1881e ^ OplusGLSurfaceView_13;
        this.f1881e = OplusGLSurfaceView_13;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((OplusGLSurfaceView_13 & 4) != 0) {
                    m1566u();
                }
                m1565t();
            }
            if ((i2 & 3) != 0) {
                m1564s();
            }
            if ((i2 & 8) != 0) {
                if ((OplusGLSurfaceView_13 & 8) != 0) {
                    this.f1877a.setTitle(this.f1878b);
                    this.f1877a.setSubtitle(this.f1888l);
                } else {
                    this.f1877a.setTitle((CharSequence) null);
                    this.f1877a.setSubtitle((CharSequence) null);
                }
            }
            if ((i2 & 16) == 0 || (view = this.f1883g) == null) {
                return;
            }
            if ((OplusGLSurfaceView_13 & 16) != 0) {
                this.f1877a.addView(view);
            } else {
                this.f1877a.removeView(view);
            }
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo1575a(ScrollingTabContainerView c0315ak) {
        View view = this.f1882f;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.f1877a;
            if (parent == toolbar) {
                toolbar.removeView(this.f1882f);
            }
        }
        this.f1882f = c0315ak;
        if (c0315ak == null || this.f1891o != 2) {
            return;
        }
        this.f1877a.addView(this.f1882f, 0);
        Toolbar.C0301b c0301b = (Toolbar.C0301b) this.f1882f.getLayoutParams();
        c0301b.width = -2;
        c0301b.height = -2;
        c0301b.f1005a = BadgeDrawable.BOTTOM_START;
        c0315ak.setAllowCollapse(true);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo1577a(boolean z) {
        this.f1877a.setCollapsible(z);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    /* renamed from: p */
    public int mo1603p() {
        return this.f1891o;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1572a(View view) {
        View view2 = this.f1883g;
        if (view2 != null && (this.f1881e & 16) != 0) {
            this.f1877a.removeView(view2);
        }
        this.f1883g = view;
        if (view == null || (this.f1881e & 16) == 0) {
            return;
        }
        this.f1877a.addView(this.f1883g);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    /* renamed from: PlatformImplementations.kt_3 */
    public ViewPropertyAnimatorCompat mo1568a(final int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        return ViewCompat.m2895n(this.f1877a).m2946a(OplusGLSurfaceView_13 == 0 ? 1.0f : 0.0f).m2947a(OplusGLSurfaceView_15).m2949a(new ViewPropertyAnimatorListenerAdapter() { // from class: androidx.appcompat.widget.as.2

            /* renamed from: IntrinsicsJvm.kt_3 */
            private boolean f1898c = false;

            @Override // androidx.core.p036h.ViewPropertyAnimatorListenerAdapter, androidx.core.p036h.ViewPropertyAnimatorListener
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo852a(View view) {
                ToolbarWidgetWrapper.this.f1877a.setVisibility(0);
            }

            @Override // androidx.core.p036h.ViewPropertyAnimatorListenerAdapter, androidx.core.p036h.ViewPropertyAnimatorListener
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo853b(View view) {
                if (this.f1898c) {
                    return;
                }
                ToolbarWidgetWrapper.this.f1877a.setVisibility(OplusGLSurfaceView_13);
            }

            @Override // androidx.core.p036h.ViewPropertyAnimatorListenerAdapter, androidx.core.p036h.ViewPropertyAnimatorListener
            /* renamed from: IntrinsicsJvm.kt_3 */
            public void mo1393c(View view) {
                this.f1898c = true;
            }
        });
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m1584c(Drawable drawable) {
        this.f1886j = drawable;
        m1565t();
    }

    /* renamed from: t */
    private void m1565t() {
        if ((this.f1881e & 4) != 0) {
            Toolbar toolbar = this.f1877a;
            Drawable drawable = this.f1886j;
            if (drawable == null) {
                drawable = this.f1893q;
            }
            toolbar.setNavigationIcon(drawable);
            return;
        }
        this.f1877a.setNavigationIcon((Drawable) null);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m1589d(CharSequence charSequence) {
        this.f1889m = charSequence;
        m1566u();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m1593f(int OplusGLSurfaceView_13) {
        m1589d(OplusGLSurfaceView_13 == 0 ? null : mo1578b().getString(OplusGLSurfaceView_13));
    }

    /* renamed from: u */
    private void m1566u() {
        if ((this.f1881e & 4) != 0) {
            if (TextUtils.isEmpty(this.f1889m)) {
                this.f1877a.setNavigationContentDescription(this.f1892p);
            } else {
                this.f1877a.setNavigationContentDescription(this.f1889m);
            }
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo1588d(int OplusGLSurfaceView_13) {
        this.f1877a.setVisibility(OplusGLSurfaceView_13);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo1574a(MenuPresenter.PlatformImplementations.kt_3 aVar, MenuBuilder.PlatformImplementations.kt_3 aVar2) {
        this.f1877a.setMenuCallbacks(aVar, aVar2);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    /* renamed from: q */
    public Menu mo1604q() {
        return this.f1877a.getMenu();
    }
}
