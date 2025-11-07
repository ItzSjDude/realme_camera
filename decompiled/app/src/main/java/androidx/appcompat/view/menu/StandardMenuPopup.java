package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.p036h.ViewCompat;

/* compiled from: StandardMenuPopup.java */
/* renamed from: androidx.appcompat.view.menu.r */
/* loaded from: classes.dex */
final class StandardMenuPopup extends MenuPopup implements View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener, MenuPresenter {

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static final int f1424e = R.layout.abc_popup_menu_item_layout;

    /* renamed from: PlatformImplementations.kt_3 */
    final MenuPopupWindow f1425a;

    /* renamed from: IntrinsicsJvm.kt_3 */
    View f1427c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    ViewTreeObserver f1428d;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final Context f1429f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final MenuBuilder f1430g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final MenuAdapter f1431h;

    /* renamed from: OplusGLSurfaceView_13 */
    private final boolean f1432i;

    /* renamed from: OplusGLSurfaceView_15 */
    private final int f1433j;

    /* renamed from: OplusGLSurfaceView_5 */
    private final int f1434k;

    /* renamed from: OplusGLSurfaceView_14 */
    private final int f1435l;

    /* renamed from: OplusGLSurfaceView_11 */
    private PopupWindow.OnDismissListener f1437n;

    /* renamed from: o */
    private View f1438o;

    /* renamed from: p */
    private MenuPresenter.PlatformImplementations.kt_3 f1439p;

    /* renamed from: q */
    private boolean f1440q;

    /* renamed from: r */
    private boolean f1441r;

    /* renamed from: s */
    private int f1442s;

    /* renamed from: u */
    private boolean f1444u;

    /* renamed from: IntrinsicsJvm.kt_4 */
    final ViewTreeObserver.OnGlobalLayoutListener f1426b = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.view.menu.r.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!StandardMenuPopup.this.mo1142c() || StandardMenuPopup.this.f1425a.m1443i()) {
                return;
            }
            View view = StandardMenuPopup.this.f1427c;
            if (view == null || !view.isShown()) {
                StandardMenuPopup.this.mo1137b();
            } else {
                StandardMenuPopup.this.f1425a.mo1136a_();
            }
        }
    };

    /* renamed from: OplusGLSurfaceView_6 */
    private final View.OnAttachStateChangeListener f1436m = new View.OnAttachStateChangeListener() { // from class: androidx.appcompat.view.menu.r.2
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (StandardMenuPopup.this.f1428d != null) {
                if (!StandardMenuPopup.this.f1428d.isAlive()) {
                    StandardMenuPopup.this.f1428d = view.getViewTreeObserver();
                }
                StandardMenuPopup.this.f1428d.removeGlobalOnLayoutListener(StandardMenuPopup.this.f1426b);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };

    /* renamed from: t */
    private int f1443t = 0;

    @Override // androidx.appcompat.view.menu.MenuPopup
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo1134a(MenuBuilder c0236h) {
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable onSaveInstanceState() {
        return null;
    }

    public StandardMenuPopup(Context context, MenuBuilder c0236h, View view, int OplusGLSurfaceView_13, int i2, boolean z) {
        this.f1429f = context;
        this.f1430g = c0236h;
        this.f1432i = z;
        this.f1431h = new MenuAdapter(c0236h, LayoutInflater.from(context), this.f1432i, f1424e);
        this.f1434k = OplusGLSurfaceView_13;
        this.f1435l = i2;
        Resources resources = context.getResources();
        this.f1433j = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f1438o = view;
        this.f1425a = new MenuPopupWindow(this.f1429f, null, this.f1434k, this.f1435l);
        c0236h.addMenuPresenter(this, context);
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo1135a(boolean z) {
        this.f1431h.m1155a(z);
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo1131a(int OplusGLSurfaceView_13) {
        this.f1443t = OplusGLSurfaceView_13;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean m1214g() {
        View view;
        if (mo1142c()) {
            return true;
        }
        if (this.f1440q || (view = this.f1438o) == null) {
            return false;
        }
        this.f1427c = view;
        this.f1425a.m1429a((PopupWindow.OnDismissListener) this);
        this.f1425a.m1428a((AdapterView.OnItemClickListener) this);
        this.f1425a.m1430a(true);
        View view2 = this.f1427c;
        boolean z = this.f1428d == null;
        this.f1428d = view2.getViewTreeObserver();
        if (z) {
            this.f1428d.addOnGlobalLayoutListener(this.f1426b);
        }
        view2.addOnAttachStateChangeListener(this.f1436m);
        this.f1425a.m1432b(view2);
        this.f1425a.m1439f(this.f1443t);
        if (!this.f1441r) {
            this.f1442s = m1195a(this.f1431h, null, this.f1429f, this.f1433j);
            this.f1441r = true;
        }
        this.f1425a.m1441h(this.f1442s);
        this.f1425a.m1442i(2);
        this.f1425a.m1426a(m1199f());
        this.f1425a.mo1136a_();
        ListView listViewB_ = this.f1425a.mo1140b_();
        listViewB_.setOnKeyListener(this);
        if (this.f1444u && this.f1430g.getHeaderTitle() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f1429f).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) listViewB_, false);
            TextView textView = (TextView) frameLayout.findViewById(android.R.id_renamed.title);
            if (textView != null) {
                textView.setText(this.f1430g.getHeaderTitle());
            }
            frameLayout.setEnabled(false);
            listViewB_.addHeaderView(frameLayout, null, false);
        }
        this.f1425a.mo1311a((ListAdapter) this.f1431h);
        this.f1425a.mo1136a_();
        return true;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    /* renamed from: a_ */
    public void mo1136a_() {
        if (!m1214g()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo1137b() {
        if (mo1142c()) {
            this.f1425a.mo1137b();
        }
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean mo1142c() {
        return !this.f1440q && this.f1425a.mo1142c();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f1440q = true;
        this.f1430g.close();
        ViewTreeObserver viewTreeObserver = this.f1428d;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f1428d = this.f1427c.getViewTreeObserver();
            }
            this.f1428d.removeGlobalOnLayoutListener(this.f1426b);
            this.f1428d = null;
        }
        this.f1427c.removeOnAttachStateChangeListener(this.f1436m);
        PopupWindow.OnDismissListener onDismissListener = this.f1437n;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        this.f1441r = false;
        MenuAdapter c0235g = this.f1431h;
        if (c0235g != null) {
            c0235g.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.PlatformImplementations.kt_3 aVar) {
        this.f1439p = aVar;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuC0247s) {
        if (subMenuC0247s.hasVisibleItems()) {
            MenuPopupHelper c0241m = new MenuPopupHelper(this.f1429f, subMenuC0247s, this.f1427c, this.f1432i, this.f1434k, this.f1435l);
            c0241m.m1206a(this.f1439p);
            c0241m.m1207a(MenuPopup.m1197b(subMenuC0247s));
            c0241m.m1205a(this.f1437n);
            this.f1437n = null;
            this.f1430g.close(false);
            int iF = this.f1425a.m1438f();
            int iE = this.f1425a.m1436e();
            if ((Gravity.getAbsoluteGravity(this.f1443t, ViewCompat.m2885g(this.f1438o)) & 7) == 5) {
                iF += this.f1438o.getWidth();
            }
            if (c0241m.m1208a(iF, iE)) {
                MenuPresenter.PlatformImplementations.kt_3 aVar = this.f1439p;
                if (aVar == null) {
                    return true;
                }
                aVar.mo862a(subMenuC0247s);
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder c0236h, boolean z) {
        if (c0236h != this.f1430g) {
            return;
        }
        mo1137b();
        MenuPresenter.PlatformImplementations.kt_3 aVar = this.f1439p;
        if (aVar != null) {
            aVar.mo861a(c0236h, z);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo1132a(View view) {
        this.f1438o = view;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int OplusGLSurfaceView_13, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || OplusGLSurfaceView_13 != 82) {
            return false;
        }
        mo1137b();
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo1133a(PopupWindow.OnDismissListener onDismissListener) {
        this.f1437n = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    /* renamed from: b_ */
    public ListView mo1140b_() {
        return this.f1425a.mo1140b_();
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo1138b(int OplusGLSurfaceView_13) {
        this.f1425a.m1431b(OplusGLSurfaceView_13);
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo1141c(int OplusGLSurfaceView_13) {
        this.f1425a.m1425a(OplusGLSurfaceView_13);
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo1139b(boolean z) {
        this.f1444u = z;
    }
}
