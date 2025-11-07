package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.ViewPropertyAnimatorCompatSet;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.Toolbar;
import androidx.core.p036h.ViewPropertyAnimatorListenerAdapter;
import androidx.core.p036h.ViewCompat;
import androidx.core.p036h.ViewPropertyAnimatorCompat;
import androidx.core.p036h.ViewPropertyAnimatorListener;
import androidx.core.p036h.ViewPropertyAnimatorUpdateListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: WindowDecorActionBar.java */
/* renamed from: androidx.appcompat.app.OplusGLSurfaceView_14 */
/* loaded from: classes.dex */
public class WindowDecorActionBar extends ActionBar implements ActionBarOverlayLayout.InterfaceC0253a {

    /* renamed from: s */
    static final /* synthetic */ boolean f1050s = !WindowDecorActionBar.class.desiredAssertionStatus();

    /* renamed from: t */
    private static final Interpolator f1051t = new AccelerateInterpolator();

    /* renamed from: u */
    private static final Interpolator f1052u = new DecelerateInterpolator();

    /* renamed from: A */
    private boolean f1053A;

    /* renamed from: B */
    private boolean f1054B;

    /* renamed from: D */
    private boolean f1056D;

    /* renamed from: F */
    private boolean f1058F;

    /* renamed from: H */
    private boolean f1060H;

    /* renamed from: PlatformImplementations.kt_3 */
    Context f1061a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    ActionBarOverlayLayout f1062b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    ActionBarContainer f1063c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    DecorToolbar f1064d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    ActionBarContextView f1065e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    View f1066f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    ScrollingTabContainerView f1067g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    PlatformImplementations.kt_3 f1068h;

    /* renamed from: OplusGLSurfaceView_13 */
    ActionMode f1069i;

    /* renamed from: OplusGLSurfaceView_15 */
    ActionMode.PlatformImplementations.kt_3 f1070j;

    /* renamed from: OplusGLSurfaceView_14 */
    boolean f1072l;

    /* renamed from: OplusGLSurfaceView_6 */
    boolean f1073m;

    /* renamed from: OplusGLSurfaceView_11 */
    ViewPropertyAnimatorCompatSet f1074n;

    /* renamed from: o */
    boolean f1075o;

    /* renamed from: v */
    private Context f1079v;

    /* renamed from: w */
    private Activity f1080w;

    /* renamed from: x */
    private Dialog f1081x;

    /* renamed from: y */
    private ArrayList<Object> f1082y = new ArrayList<>();

    /* renamed from: z */
    private int f1083z = -1;

    /* renamed from: C */
    private ArrayList<ActionBar.IntrinsicsJvm.kt_4> f1055C = new ArrayList<>();

    /* renamed from: E */
    private int f1057E = 0;

    /* renamed from: OplusGLSurfaceView_5 */
    boolean f1071k = true;

    /* renamed from: G */
    private boolean f1059G = true;

    /* renamed from: p */
    final ViewPropertyAnimatorListener f1076p = new ViewPropertyAnimatorListenerAdapter() { // from class: androidx.appcompat.app.OplusGLSurfaceView_14.1
        @Override // androidx.core.p036h.ViewPropertyAnimatorListenerAdapter, androidx.core.p036h.ViewPropertyAnimatorListener
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo853b(View view) {
            if (WindowDecorActionBar.this.f1071k && WindowDecorActionBar.this.f1066f != null) {
                WindowDecorActionBar.this.f1066f.setTranslationY(0.0f);
                WindowDecorActionBar.this.f1063c.setTranslationY(0.0f);
            }
            WindowDecorActionBar.this.f1063c.setVisibility(8);
            WindowDecorActionBar.this.f1063c.setTransitioning(false);
            WindowDecorActionBar c0214l = WindowDecorActionBar.this;
            c0214l.f1074n = null;
            c0214l.m955h();
            if (WindowDecorActionBar.this.f1062b != null) {
                ViewCompat.m2900s(WindowDecorActionBar.this.f1062b);
            }
        }
    };

    /* renamed from: q */
    final ViewPropertyAnimatorListener f1077q = new ViewPropertyAnimatorListenerAdapter() { // from class: androidx.appcompat.app.OplusGLSurfaceView_14.2
        @Override // androidx.core.p036h.ViewPropertyAnimatorListenerAdapter, androidx.core.p036h.ViewPropertyAnimatorListener
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo853b(View view) {
            WindowDecorActionBar c0214l = WindowDecorActionBar.this;
            c0214l.f1074n = null;
            c0214l.f1063c.requestLayout();
        }
    };

    /* renamed from: r */
    final ViewPropertyAnimatorUpdateListener f1078r = new ViewPropertyAnimatorUpdateListener() { // from class: androidx.appcompat.app.OplusGLSurfaceView_14.3
        @Override // androidx.core.p036h.ViewPropertyAnimatorUpdateListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo964a(View view) {
            ((View) WindowDecorActionBar.this.f1063c.getParent()).invalidate();
        }
    };

    /* renamed from: PlatformImplementations.kt_3 */
    static boolean m945a(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        return (z || z2) ? false : true;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.InterfaceC0253a
    /* renamed from: OplusGLSurfaceView_6 */
    public void mo963m() {
    }

    public WindowDecorActionBar(Activity activity, boolean z) {
        this.f1080w = activity;
        View decorView = activity.getWindow().getDecorView();
        m944a(decorView);
        if (z) {
            return;
        }
        this.f1066f = decorView.findViewById(R.id_renamed.content);
    }

    public WindowDecorActionBar(Dialog dialog) {
        this.f1081x = dialog;
        m944a(dialog.getWindow().getDecorView());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m944a(View view) {
        this.f1062b = (ActionBarOverlayLayout) view.findViewById(androidx.appcompat.R.id_renamed.decor_content_parent);
        ActionBarOverlayLayout actionBarOverlayLayout = this.f1062b;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f1064d = m946b(view.findViewById(androidx.appcompat.R.id_renamed.action_bar));
        this.f1065e = (ActionBarContextView) view.findViewById(androidx.appcompat.R.id_renamed.action_context_bar);
        this.f1063c = (ActionBarContainer) view.findViewById(androidx.appcompat.R.id_renamed.action_bar_container);
        DecorToolbar interfaceC0354z = this.f1064d;
        if (interfaceC0354z == null || this.f1065e == null || this.f1063c == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with PlatformImplementations.kt_3 compatible window decor layout");
        }
        this.f1061a = interfaceC0354z.mo1578b();
        boolean z = (this.f1064d.mo1602o() & 4) != 0;
        if (z) {
            this.f1053A = true;
        }
        ActionBarPolicy c0220aM1047a = ActionBarPolicy.m1047a(this.f1061a);
        mo884b(c0220aM1047a.m1053f() || z);
        m947k(c0220aM1047a.m1051d());
        TypedArray typedArrayObtainStyledAttributes = this.f1061a.obtainStyledAttributes(null, androidx.appcompat.R.styleable.ActionBar, androidx.appcompat.R.attr.actionBarStyle, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.ActionBar_hideOnContentScroll, false)) {
            mo885c(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            mo877a(dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: IntrinsicsJvm.kt_4 */
    private DecorToolbar m946b(View view) {
        if (view instanceof DecorToolbar) {
            return (DecorToolbar) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make PlatformImplementations.kt_3 decor toolbar out of ");
        sb.append(view != 0 ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo877a(float COUIBaseListPopupWindow_12) {
        ViewCompat.m2841a(this.f1063c, COUIBaseListPopupWindow_12);
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo878a(Configuration configuration) {
        m947k(ActionBarPolicy.m1047a(this.f1061a).m1051d());
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private void m947k(boolean z) {
        this.f1056D = z;
        if (!this.f1056D) {
            this.f1064d.mo1575a((ScrollingTabContainerView) null);
            this.f1063c.setTabContainer(this.f1067g);
        } else {
            this.f1063c.setTabContainer(null);
            this.f1064d.mo1575a(this.f1067g);
        }
        boolean z2 = m957i() == 2;
        ScrollingTabContainerView c0315ak = this.f1067g;
        if (c0315ak != null) {
            if (z2) {
                c0315ak.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f1062b;
                if (actionBarOverlayLayout != null) {
                    ViewCompat.m2900s(actionBarOverlayLayout);
                }
            } else {
                c0315ak.setVisibility(8);
            }
        }
        this.f1064d.mo1577a(!this.f1056D && z2);
        this.f1062b.setHasNonEmbeddedTabs(!this.f1056D && z2);
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    void m955h() {
        ActionMode.PlatformImplementations.kt_3 aVar = this.f1070j;
        if (aVar != null) {
            aVar.mo863a(this.f1069i);
            this.f1069i = null;
            this.f1070j = null;
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.InterfaceC0253a
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo952a(int OplusGLSurfaceView_13) {
        this.f1057E = OplusGLSurfaceView_13;
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo889e(boolean z) {
        ViewPropertyAnimatorCompatSet c0227h;
        this.f1060H = z;
        if (z || (c0227h = this.f1074n) == null) {
            return;
        }
        c0227h.m1084c();
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void mo891f(boolean z) {
        if (z == this.f1054B) {
            return;
        }
        this.f1054B = z;
        int size = this.f1055C.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            this.f1055C.get(OplusGLSurfaceView_13).m894a(z);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo880a(boolean z) {
        m953a(z ? 4 : 0, 4);
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo884b(boolean z) {
        this.f1064d.mo1582b(z);
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo879a(CharSequence charSequence) {
        this.f1064d.mo1576a(charSequence);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m953a(int OplusGLSurfaceView_13, int i2) {
        int iMo1602o = this.f1064d.mo1602o();
        if ((i2 & 4) != 0) {
            this.f1053A = true;
        }
        this.f1064d.mo1583c((OplusGLSurfaceView_13 & i2) | ((~i2) & iMo1602o));
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public int m957i() {
        return this.f1064d.mo1603p();
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: PlatformImplementations.kt_3 */
    public int mo875a() {
        return this.f1064d.mo1602o();
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: PlatformImplementations.kt_3 */
    public ActionMode mo876a(ActionMode.PlatformImplementations.kt_3 aVar) {
        PlatformImplementations.kt_3 aVar2 = this.f1068h;
        if (aVar2 != null) {
            aVar2.mo973c();
        }
        this.f1062b.setHideOnContentScrollEnabled(false);
        this.f1065e.m1222c();
        PlatformImplementations.kt_3 aVar3 = new PlatformImplementations.kt_3(this.f1065e.getContext(), aVar);
        if (!aVar3.m975e()) {
            return null;
        }
        this.f1068h = aVar3;
        aVar3.mo974d();
        this.f1065e.m1219a(aVar3);
        m960j(true);
        this.f1065e.sendAccessibilityEvent(32);
        return aVar3;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.InterfaceC0253a
    /* renamed from: COUIBaseListPopupWindow_11 */
    public void mo954g(boolean z) {
        this.f1071k = z;
    }

    /* renamed from: OplusGLSurfaceView_11 */
    private void m949n() {
        if (this.f1058F) {
            return;
        }
        this.f1058F = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.f1062b;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setShowingForActionMode(true);
        }
        m948l(false);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.InterfaceC0253a
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo959j() {
        if (this.f1073m) {
            this.f1073m = false;
            m948l(true);
        }
    }

    /* renamed from: o */
    private void m950o() {
        if (this.f1058F) {
            this.f1058F = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f1062b;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            m948l(false);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.InterfaceC0253a
    /* renamed from: OplusGLSurfaceView_5 */
    public void mo961k() {
        if (this.f1073m) {
            return;
        }
        this.f1073m = true;
        m948l(true);
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo885c(boolean z) {
        if (z && !this.f1062b.m1235a()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.f1075o = z;
        this.f1062b.setHideOnContentScrollEnabled(z);
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private void m948l(boolean z) {
        if (m945a(this.f1072l, this.f1073m, this.f1058F)) {
            if (this.f1059G) {
                return;
            }
            this.f1059G = true;
            m956h(z);
            return;
        }
        if (this.f1059G) {
            this.f1059G = false;
            m958i(z);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m956h(boolean z) {
        View view;
        View view2;
        ViewPropertyAnimatorCompatSet c0227h = this.f1074n;
        if (c0227h != null) {
            c0227h.m1084c();
        }
        this.f1063c.setVisibility(0);
        if (this.f1057E == 0 && (this.f1060H || z)) {
            this.f1063c.setTranslationY(0.0f);
            float COUIBaseListPopupWindow_12 = -this.f1063c.getHeight();
            if (z) {
                this.f1063c.getLocationInWindow(new int[]{0, 0});
                COUIBaseListPopupWindow_12 -= r5[1];
            }
            this.f1063c.setTranslationY(COUIBaseListPopupWindow_12);
            ViewPropertyAnimatorCompatSet c0227h2 = new ViewPropertyAnimatorCompatSet();
            ViewPropertyAnimatorCompat c0517zM2951b = ViewCompat.m2895n(this.f1063c).m2951b(0.0f);
            c0517zM2951b.m2950a(this.f1078r);
            c0227h2.m1080a(c0517zM2951b);
            if (this.f1071k && (view2 = this.f1066f) != null) {
                view2.setTranslationY(COUIBaseListPopupWindow_12);
                c0227h2.m1080a(ViewCompat.m2895n(this.f1066f).m2951b(0.0f));
            }
            c0227h2.m1078a(f1052u);
            c0227h2.m1077a(250L);
            c0227h2.m1079a(this.f1077q);
            this.f1074n = c0227h2;
            c0227h2.m1082a();
        } else {
            this.f1063c.setAlpha(1.0f);
            this.f1063c.setTranslationY(0.0f);
            if (this.f1071k && (view = this.f1066f) != null) {
                view.setTranslationY(0.0f);
            }
            this.f1077q.mo853b(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f1062b;
        if (actionBarOverlayLayout != null) {
            ViewCompat.m2900s(actionBarOverlayLayout);
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m958i(boolean z) {
        View view;
        ViewPropertyAnimatorCompatSet c0227h = this.f1074n;
        if (c0227h != null) {
            c0227h.m1084c();
        }
        if (this.f1057E == 0 && (this.f1060H || z)) {
            this.f1063c.setAlpha(1.0f);
            this.f1063c.setTransitioning(true);
            ViewPropertyAnimatorCompatSet c0227h2 = new ViewPropertyAnimatorCompatSet();
            float COUIBaseListPopupWindow_12 = -this.f1063c.getHeight();
            if (z) {
                this.f1063c.getLocationInWindow(new int[]{0, 0});
                COUIBaseListPopupWindow_12 -= r5[1];
            }
            ViewPropertyAnimatorCompat c0517zM2951b = ViewCompat.m2895n(this.f1063c).m2951b(COUIBaseListPopupWindow_12);
            c0517zM2951b.m2950a(this.f1078r);
            c0227h2.m1080a(c0517zM2951b);
            if (this.f1071k && (view = this.f1066f) != null) {
                c0227h2.m1080a(ViewCompat.m2895n(view).m2951b(COUIBaseListPopupWindow_12));
            }
            c0227h2.m1078a(f1051t);
            c0227h2.m1077a(250L);
            c0227h2.m1079a(this.f1076p);
            this.f1074n = c0227h2;
            c0227h2.m1082a();
            return;
        }
        this.f1076p.mo853b(null);
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void m960j(boolean z) {
        ViewPropertyAnimatorCompat c0517zMo1568a;
        ViewPropertyAnimatorCompat c0517zMo1218a;
        if (z) {
            m949n();
        } else {
            m950o();
        }
        if (!m951p()) {
            if (z) {
                this.f1064d.mo1588d(4);
                this.f1065e.setVisibility(0);
                return;
            } else {
                this.f1064d.mo1588d(0);
                this.f1065e.setVisibility(8);
                return;
            }
        }
        if (z) {
            ViewPropertyAnimatorCompat c0517zMo1568a2 = this.f1064d.mo1568a(4, 100L);
            c0517zMo1568a = this.f1065e.mo1218a(0, 200L);
            c0517zMo1218a = c0517zMo1568a2;
        } else {
            c0517zMo1568a = this.f1064d.mo1568a(0, 200L);
            c0517zMo1218a = this.f1065e.mo1218a(8, 100L);
        }
        ViewPropertyAnimatorCompatSet c0227h = new ViewPropertyAnimatorCompatSet();
        c0227h.m1081a(c0517zMo1218a, c0517zMo1568a);
        c0227h.m1082a();
    }

    /* renamed from: p */
    private boolean m951p() {
        return ViewCompat.m2823A(this.f1063c);
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: IntrinsicsJvm.kt_4 */
    public Context mo883b() {
        if (this.f1079v == null) {
            TypedValue typedValue = new TypedValue();
            this.f1061a.getTheme().resolveAttribute(androidx.appcompat.R.attr.actionBarWidgetTheme, typedValue, true);
            int OplusGLSurfaceView_13 = typedValue.resourceId;
            if (OplusGLSurfaceView_13 != 0) {
                this.f1079v = new ContextThemeWrapper(this.f1061a, OplusGLSurfaceView_13);
            } else {
                this.f1079v = this.f1061a;
            }
        }
        return this.f1079v;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.InterfaceC0253a
    /* renamed from: OplusGLSurfaceView_14 */
    public void mo962l() {
        ViewPropertyAnimatorCompatSet c0227h = this.f1074n;
        if (c0227h != null) {
            c0227h.m1084c();
            this.f1074n = null;
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: COUIBaseListPopupWindow_12 */
    public boolean mo892f() {
        DecorToolbar interfaceC0354z = this.f1064d;
        if (interfaceC0354z == null || !interfaceC0354z.mo1586c()) {
            return false;
        }
        this.f1064d.mo1587d();
        return true;
    }

    /* compiled from: WindowDecorActionBar.java */
    /* renamed from: androidx.appcompat.app.OplusGLSurfaceView_14$PlatformImplementations.kt_3 */
    public class PlatformImplementations.kt_3 extends ActionMode implements MenuBuilder.PlatformImplementations.kt_3 {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final Context f1088b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private final MenuBuilder f1089c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private ActionMode.PlatformImplementations.kt_3 f1090d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private WeakReference<View> f1091e;

        public PlatformImplementations.kt_3(Context context, ActionMode.PlatformImplementations.kt_3 aVar) {
            this.f1088b = context;
            this.f1090d = aVar;
            this.f1089c = new MenuBuilder(context).setDefaultShowAsAction(1);
            this.f1089c.setCallback(this);
        }

        @Override // androidx.appcompat.view.ActionMode
        /* renamed from: PlatformImplementations.kt_3 */
        public MenuInflater mo965a() {
            return new SupportMenuInflater(this.f1088b);
        }

        @Override // androidx.appcompat.view.ActionMode
        /* renamed from: IntrinsicsJvm.kt_4 */
        public Menu mo970b() {
            return this.f1089c;
        }

        @Override // androidx.appcompat.view.ActionMode
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo973c() {
            if (WindowDecorActionBar.this.f1068h != this) {
                return;
            }
            if (!WindowDecorActionBar.m945a(WindowDecorActionBar.this.f1072l, WindowDecorActionBar.this.f1073m, false)) {
                WindowDecorActionBar c0214l = WindowDecorActionBar.this;
                c0214l.f1069i = this;
                c0214l.f1070j = this.f1090d;
            } else {
                this.f1090d.mo863a(this);
            }
            this.f1090d = null;
            WindowDecorActionBar.this.m960j(false);
            WindowDecorActionBar.this.f1065e.m1221b();
            WindowDecorActionBar.this.f1064d.mo1567a().sendAccessibilityEvent(32);
            WindowDecorActionBar.this.f1062b.setHideOnContentScrollEnabled(WindowDecorActionBar.this.f1075o);
            WindowDecorActionBar.this.f1068h = null;
        }

        @Override // androidx.appcompat.view.ActionMode
        /* renamed from: IntrinsicsJvm.kt_5 */
        public void mo974d() {
            if (WindowDecorActionBar.this.f1068h != this) {
                return;
            }
            this.f1089c.stopDispatchingItemsChanged();
            try {
                this.f1090d.mo866b(this, this.f1089c);
            } finally {
                this.f1089c.startDispatchingItemsChanged();
            }
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        public boolean m975e() {
            this.f1089c.stopDispatchingItemsChanged();
            try {
                return this.f1090d.mo864a(this, this.f1089c);
            } finally {
                this.f1089c.startDispatchingItemsChanged();
            }
        }

        @Override // androidx.appcompat.view.ActionMode
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo967a(View view) {
            WindowDecorActionBar.this.f1065e.setCustomView(view);
            this.f1091e = new WeakReference<>(view);
        }

        @Override // androidx.appcompat.view.ActionMode
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo968a(CharSequence charSequence) {
            WindowDecorActionBar.this.f1065e.setSubtitle(charSequence);
        }

        @Override // androidx.appcompat.view.ActionMode
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo972b(CharSequence charSequence) {
            WindowDecorActionBar.this.f1065e.setTitle(charSequence);
        }

        @Override // androidx.appcompat.view.ActionMode
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo966a(int OplusGLSurfaceView_13) {
            mo972b(WindowDecorActionBar.this.f1061a.getResources().getString(OplusGLSurfaceView_13));
        }

        @Override // androidx.appcompat.view.ActionMode
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo971b(int OplusGLSurfaceView_13) {
            mo968a((CharSequence) WindowDecorActionBar.this.f1061a.getResources().getString(OplusGLSurfaceView_13));
        }

        @Override // androidx.appcompat.view.ActionMode
        /* renamed from: COUIBaseListPopupWindow_12 */
        public CharSequence mo976f() {
            return WindowDecorActionBar.this.f1065e.getTitle();
        }

        @Override // androidx.appcompat.view.ActionMode
        /* renamed from: COUIBaseListPopupWindow_11 */
        public CharSequence mo977g() {
            return WindowDecorActionBar.this.f1065e.getSubtitle();
        }

        @Override // androidx.appcompat.view.ActionMode
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo969a(boolean z) {
            super.mo969a(z);
            WindowDecorActionBar.this.f1065e.setTitleOptional(z);
        }

        @Override // androidx.appcompat.view.ActionMode
        /* renamed from: COUIBaseListPopupWindow_10 */
        public boolean mo978h() {
            return WindowDecorActionBar.this.f1065e.m1223d();
        }

        @Override // androidx.appcompat.view.ActionMode
        /* renamed from: OplusGLSurfaceView_13 */
        public View mo979i() {
            WeakReference<View> weakReference = this.f1091e;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.PlatformImplementations.kt_3
        public boolean onMenuItemSelected(MenuBuilder c0236h, MenuItem menuItem) {
            ActionMode.PlatformImplementations.kt_3 aVar = this.f1090d;
            if (aVar != null) {
                return aVar.mo865a(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.PlatformImplementations.kt_3
        public void onMenuModeChange(MenuBuilder c0236h) {
            if (this.f1090d == null) {
                return;
            }
            mo974d();
            WindowDecorActionBar.this.f1065e.mo1220a();
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo887d(boolean z) {
        if (this.f1053A) {
            return;
        }
        mo880a(z);
    }

    @Override // androidx.appcompat.app.ActionBar
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo881a(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
        Menu menuMo970b;
        PlatformImplementations.kt_3 aVar = this.f1068h;
        if (aVar == null || (menuMo970b = aVar.mo970b()) == null) {
            return false;
        }
        menuMo970b.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuMo970b.performShortcut(OplusGLSurfaceView_13, keyEvent, 0);
    }
}
