package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.OverScroller;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.p036h.NestedScrollingParentHelper;
import androidx.core.p036h.ViewCompat;
import androidx.core.p036h.NestedScrollingParent;
import androidx.core.p036h.NestedScrollingParent2;
import androidx.core.p036h.NestedScrollingParent3;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements DecorContentParent, NestedScrollingParent, NestedScrollingParent2, NestedScrollingParent3 {

    /* renamed from: COUIBaseListPopupWindow_8 */
    static final int[] f1471e = {R.attr.actionBarSize, android.R.attr.windowContentOverlay};

    /* renamed from: A */
    private final Runnable f1472A;

    /* renamed from: B */
    private final NestedScrollingParentHelper f1473B;

    /* renamed from: PlatformImplementations.kt_3 */
    ActionBarContainer f1474a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    boolean f1475b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    ViewPropertyAnimator f1476c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    final AnimatorListenerAdapter f1477d;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f1478f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f1479g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private ContentFrameLayout f1480h;

    /* renamed from: OplusGLSurfaceView_13 */
    private DecorToolbar f1481i;

    /* renamed from: OplusGLSurfaceView_15 */
    private Drawable f1482j;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f1483k;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f1484l;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f1485m;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f1486n;

    /* renamed from: o */
    private int f1487o;

    /* renamed from: p */
    private int f1488p;

    /* renamed from: q */
    private final Rect f1489q;

    /* renamed from: r */
    private final Rect f1490r;

    /* renamed from: s */
    private final Rect f1491s;

    /* renamed from: t */
    private final Rect f1492t;

    /* renamed from: u */
    private final Rect f1493u;

    /* renamed from: v */
    private final Rect f1494v;

    /* renamed from: w */
    private final Rect f1495w;

    /* renamed from: x */
    private InterfaceC0253a f1496x;

    /* renamed from: y */
    private OverScroller f1497y;

    /* renamed from: z */
    private final Runnable f1498z;

    /* renamed from: androidx.appcompat.widget.ActionBarOverlayLayout$PlatformImplementations.kt_3 */
    public interface InterfaceC0253a {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo952a(int OplusGLSurfaceView_13);

        /* renamed from: COUIBaseListPopupWindow_11 */
        void mo954g(boolean z);

        /* renamed from: OplusGLSurfaceView_15 */
        void mo959j();

        /* renamed from: OplusGLSurfaceView_5 */
        void mo961k();

        /* renamed from: OplusGLSurfaceView_14 */
        void mo962l();

        /* renamed from: OplusGLSurfaceView_6 */
        void mo963m();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.p036h.NestedScrollingParent
    public boolean onNestedPreFling(View view, float COUIBaseListPopupWindow_12, float f2) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.p036h.NestedScrollingParent
    public void onNestedPreScroll(View view, int OplusGLSurfaceView_13, int i2, int[] iArr) {
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int OplusGLSurfaceView_13) {
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1479g = 0;
        this.f1489q = new Rect();
        this.f1490r = new Rect();
        this.f1491s = new Rect();
        this.f1492t = new Rect();
        this.f1493u = new Rect();
        this.f1494v = new Rect();
        this.f1495w = new Rect();
        this.f1477d = new AnimatorListenerAdapter() { // from class: androidx.appcompat.widget.ActionBarOverlayLayout.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.f1476c = null;
                actionBarOverlayLayout.f1475b = false;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.f1476c = null;
                actionBarOverlayLayout.f1475b = false;
            }
        };
        this.f1498z = new Runnable() { // from class: androidx.appcompat.widget.ActionBarOverlayLayout.2
            @Override // java.lang.Runnable
            public void run() {
                ActionBarOverlayLayout.this.m1238d();
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.f1476c = actionBarOverlayLayout.f1474a.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.f1477d);
            }
        };
        this.f1472A = new Runnable() { // from class: androidx.appcompat.widget.ActionBarOverlayLayout.3
            @Override // java.lang.Runnable
            public void run() {
                ActionBarOverlayLayout.this.m1238d();
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.f1476c = actionBarOverlayLayout.f1474a.animate().translationY(-ActionBarOverlayLayout.this.f1474a.getHeight()).setListener(ActionBarOverlayLayout.this.f1477d);
            }
        };
        m1225a(context);
        this.f1473B = new NestedScrollingParentHelper(this);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m1225a(Context context) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f1471e);
        this.f1478f = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f1482j = typedArrayObtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.f1482j == null);
        typedArrayObtainStyledAttributes.recycle();
        this.f1483k = context.getApplicationInfo().targetSdkVersion < 19;
        this.f1497y = new OverScroller(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m1238d();
    }

    public void setActionBarVisibilityCallback(InterfaceC0253a interfaceC0253a) {
        this.f1496x = interfaceC0253a;
        if (getWindowToken() != null) {
            this.f1496x.mo952a(this.f1479g);
            int OplusGLSurfaceView_13 = this.f1488p;
            if (OplusGLSurfaceView_13 != 0) {
                onWindowSystemUiVisibilityChanged(OplusGLSurfaceView_13);
                ViewCompat.m2900s(this);
            }
        }
    }

    public void setOverlayMode(boolean z) {
        this.f1484l = z;
        this.f1483k = z && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m1235a() {
        return this.f1484l;
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.f1485m = z;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m1225a(getContext());
        ViewCompat.m2900s(this);
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int OplusGLSurfaceView_13) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(OplusGLSurfaceView_13);
        }
        m1237c();
        int i2 = this.f1488p ^ OplusGLSurfaceView_13;
        this.f1488p = OplusGLSurfaceView_13;
        boolean z = (OplusGLSurfaceView_13 & 4) == 0;
        boolean z2 = (OplusGLSurfaceView_13 & 256) != 0;
        InterfaceC0253a interfaceC0253a = this.f1496x;
        if (interfaceC0253a != null) {
            interfaceC0253a.mo954g(!z2);
            if (z || !z2) {
                this.f1496x.mo959j();
            } else {
                this.f1496x.mo961k();
            }
        }
        if ((i2 & 256) == 0 || this.f1496x == null) {
            return;
        }
        ViewCompat.m2900s(this);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int OplusGLSurfaceView_13) {
        super.onWindowVisibilityChanged(OplusGLSurfaceView_13);
        this.f1479g = OplusGLSurfaceView_13;
        InterfaceC0253a interfaceC0253a = this.f1496x;
        if (interfaceC0253a != null) {
            interfaceC0253a.mo952a(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m1227a(View view, Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5;
        C0254b c0254b = (C0254b) view.getLayoutParams();
        if (!z || c0254b.leftMargin == rect.left) {
            z5 = false;
        } else {
            c0254b.leftMargin = rect.left;
            z5 = true;
        }
        if (z2 && c0254b.topMargin != rect.top) {
            c0254b.topMargin = rect.top;
            z5 = true;
        }
        if (z4 && c0254b.rightMargin != rect.right) {
            c0254b.rightMargin = rect.right;
            z5 = true;
        }
        if (!z3 || c0254b.bottomMargin == rect.bottom) {
            return z5;
        }
        c0254b.bottomMargin = rect.bottom;
        return true;
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        m1237c();
        int iM2899r = ViewCompat.m2899r(this) & 256;
        boolean zM1227a = m1227a(this.f1474a, rect, true, true, false, true);
        this.f1492t.set(rect);
        ViewUtils_2.m1622a(this, this.f1492t, this.f1489q);
        if (!this.f1493u.equals(this.f1492t)) {
            this.f1493u.set(this.f1492t);
            zM1227a = true;
        }
        if (!this.f1490r.equals(this.f1489q)) {
            this.f1490r.set(this.f1489q);
            zM1227a = true;
        }
        if (zM1227a) {
            requestLayout();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: IntrinsicsJvm.kt_4, reason: merged with bridge method [inline-methods] */
    public C0254b generateDefaultLayoutParams() {
        return new C0254b(-1, -1);
    }

    @Override // android.view.ViewGroup
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public C0254b generateLayoutParams(AttributeSet attributeSet) {
        return new C0254b(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new C0254b(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0254b;
    }

    @Override // android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        int measuredHeight;
        m1237c();
        measureChildWithMargins(this.f1474a, OplusGLSurfaceView_13, 0, i2, 0);
        C0254b c0254b = (C0254b) this.f1474a.getLayoutParams();
        int iMax = Math.max(0, this.f1474a.getMeasuredWidth() + c0254b.leftMargin + c0254b.rightMargin);
        int iMax2 = Math.max(0, this.f1474a.getMeasuredHeight() + c0254b.topMargin + c0254b.bottomMargin);
        int iCombineMeasuredStates = View.combineMeasuredStates(0, this.f1474a.getMeasuredState());
        boolean z = (ViewCompat.m2899r(this) & 256) != 0;
        if (z) {
            measuredHeight = this.f1478f;
            if (this.f1485m && this.f1474a.getTabContainer() != null) {
                measuredHeight += this.f1478f;
            }
        } else {
            measuredHeight = this.f1474a.getVisibility() != 8 ? this.f1474a.getMeasuredHeight() : 0;
        }
        this.f1491s.set(this.f1489q);
        this.f1494v.set(this.f1492t);
        if (!this.f1484l && !z) {
            this.f1491s.top += measuredHeight;
            this.f1491s.bottom += 0;
        } else {
            this.f1494v.top += measuredHeight;
            this.f1494v.bottom += 0;
        }
        m1227a(this.f1480h, this.f1491s, true, true, true, true);
        if (!this.f1495w.equals(this.f1494v)) {
            this.f1495w.set(this.f1494v);
            this.f1480h.m1327a(this.f1494v);
        }
        measureChildWithMargins(this.f1480h, OplusGLSurfaceView_13, 0, i2, 0);
        C0254b c0254b2 = (C0254b) this.f1480h.getLayoutParams();
        int iMax3 = Math.max(iMax, this.f1480h.getMeasuredWidth() + c0254b2.leftMargin + c0254b2.rightMargin);
        int iMax4 = Math.max(iMax2, this.f1480h.getMeasuredHeight() + c0254b2.topMargin + c0254b2.bottomMargin);
        int iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f1480h.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), OplusGLSurfaceView_13, iCombineMeasuredStates2), View.resolveSizeAndState(Math.max(iMax4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        getPaddingRight();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                C0254b c0254b = (C0254b) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = c0254b.leftMargin + paddingLeft;
                int i7 = c0254b.topMargin + paddingTop;
                childAt.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
            }
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f1482j == null || this.f1483k) {
            return;
        }
        int bottom = this.f1474a.getVisibility() == 0 ? (int) (this.f1474a.getBottom() + this.f1474a.getTranslationY() + 0.5f) : 0;
        this.f1482j.setBounds(0, bottom, getWidth(), this.f1482j.getIntrinsicHeight() + bottom);
        this.f1482j.draw(canvas);
    }

    @Override // androidx.core.p036h.NestedScrollingParent3
    public void onNestedScroll(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int[] iArr) {
        onNestedScroll(view, OplusGLSurfaceView_13, i2, i3, i4, i5);
    }

    @Override // androidx.core.p036h.NestedScrollingParent2
    public boolean onStartNestedScroll(View view, View view2, int OplusGLSurfaceView_13, int i2) {
        return i2 == 0 && onStartNestedScroll(view, view2, OplusGLSurfaceView_13);
    }

    @Override // androidx.core.p036h.NestedScrollingParent2
    public void onNestedScrollAccepted(View view, View view2, int OplusGLSurfaceView_13, int i2) {
        if (i2 == 0) {
            onNestedScrollAccepted(view, view2, OplusGLSurfaceView_13);
        }
    }

    @Override // androidx.core.p036h.NestedScrollingParent2
    public void onStopNestedScroll(View view, int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // androidx.core.p036h.NestedScrollingParent2
    public void onNestedScroll(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            onNestedScroll(view, OplusGLSurfaceView_13, i2, i3, i4);
        }
    }

    @Override // androidx.core.p036h.NestedScrollingParent2
    public void onNestedPreScroll(View view, int OplusGLSurfaceView_13, int i2, int[] iArr, int i3) {
        if (i3 == 0) {
            onNestedPreScroll(view, OplusGLSurfaceView_13, i2, iArr);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.p036h.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int OplusGLSurfaceView_13) {
        if ((OplusGLSurfaceView_13 & 2) == 0 || this.f1474a.getVisibility() != 0) {
            return false;
        }
        return this.f1486n;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.p036h.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int OplusGLSurfaceView_13) {
        this.f1473B.m2817a(view, view2, OplusGLSurfaceView_13);
        this.f1487o = getActionBarHideOffset();
        m1238d();
        InterfaceC0253a interfaceC0253a = this.f1496x;
        if (interfaceC0253a != null) {
            interfaceC0253a.mo962l();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.p036h.NestedScrollingParent
    public void onNestedScroll(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        this.f1487o += i2;
        setActionBarHideOffset(this.f1487o);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.p036h.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        if (this.f1486n && !this.f1475b) {
            if (this.f1487o <= this.f1474a.getHeight()) {
                m1228l();
            } else {
                m1229m();
            }
        }
        InterfaceC0253a interfaceC0253a = this.f1496x;
        if (interfaceC0253a != null) {
            interfaceC0253a.mo963m();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.p036h.NestedScrollingParent
    public boolean onNestedFling(View view, float COUIBaseListPopupWindow_12, float f2, boolean z) {
        if (!this.f1486n || !z) {
            return false;
        }
        if (m1226a(COUIBaseListPopupWindow_12, f2)) {
            m1231o();
        } else {
            m1230n();
        }
        this.f1475b = true;
        return true;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f1473B.m2815a();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    void m1237c() {
        if (this.f1480h == null) {
            this.f1480h = (ContentFrameLayout) findViewById(R.id_renamed.action_bar_activity_content);
            this.f1474a = (ActionBarContainer) findViewById(R.id_renamed.action_bar_container);
            this.f1481i = m1224a(findViewById(R.id_renamed.action_bar));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: PlatformImplementations.kt_3 */
    private DecorToolbar m1224a(View view) {
        if (view instanceof DecorToolbar) {
            return (DecorToolbar) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make PlatformImplementations.kt_3 decor toolbar out of " + view.getClass().getSimpleName());
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.f1486n) {
            this.f1486n = z;
            if (z) {
                return;
            }
            m1238d();
            setActionBarHideOffset(0);
        }
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f1474a;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    public void setActionBarHideOffset(int OplusGLSurfaceView_13) {
        m1238d();
        this.f1474a.setTranslationY(-Math.max(0, Math.min(OplusGLSurfaceView_13, this.f1474a.getHeight())));
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    void m1238d() {
        removeCallbacks(this.f1498z);
        removeCallbacks(this.f1472A);
        ViewPropertyAnimator viewPropertyAnimator = this.f1476c;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private void m1228l() {
        m1238d();
        postDelayed(this.f1498z, 600L);
    }

    /* renamed from: OplusGLSurfaceView_6 */
    private void m1229m() {
        m1238d();
        postDelayed(this.f1472A, 600L);
    }

    /* renamed from: OplusGLSurfaceView_11 */
    private void m1230n() {
        m1238d();
        this.f1498z.run();
    }

    /* renamed from: o */
    private void m1231o() {
        m1238d();
        this.f1472A.run();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m1226a(float COUIBaseListPopupWindow_12, float f2) {
        this.f1497y.fling(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.f1497y.getFinalY() > this.f1474a.getHeight();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setWindowCallback(Window.Callback callback) {
        m1237c();
        this.f1481i.mo1573a(callback);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setWindowTitle(CharSequence charSequence) {
        m1237c();
        this.f1481i.mo1576a(charSequence);
    }

    public CharSequence getTitle() {
        m1237c();
        return this.f1481i.mo1590e();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo1233a(int OplusGLSurfaceView_13) {
        m1237c();
        if (OplusGLSurfaceView_13 == 2) {
            this.f1481i.mo1592f();
        } else if (OplusGLSurfaceView_13 == 5) {
            this.f1481i.mo1594g();
        } else {
            if (OplusGLSurfaceView_13 != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    public void setIcon(int OplusGLSurfaceView_13) {
        m1237c();
        this.f1481i.mo1569a(OplusGLSurfaceView_13);
    }

    public void setIcon(Drawable drawable) {
        m1237c();
        this.f1481i.mo1570a(drawable);
    }

    public void setLogo(int OplusGLSurfaceView_13) {
        m1237c();
        this.f1481i.mo1579b(OplusGLSurfaceView_13);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean mo1239e() {
        m1237c();
        return this.f1481i.mo1595h();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    /* renamed from: COUIBaseListPopupWindow_12 */
    public boolean mo1240f() {
        m1237c();
        return this.f1481i.mo1596i();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    /* renamed from: COUIBaseListPopupWindow_11 */
    public boolean mo1241g() {
        m1237c();
        return this.f1481i.mo1597j();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean mo1242h() {
        m1237c();
        return this.f1481i.mo1598k();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    /* renamed from: OplusGLSurfaceView_13 */
    public boolean mo1243i() {
        m1237c();
        return this.f1481i.mo1599l();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo1244j() {
        m1237c();
        this.f1481i.mo1600m();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo1234a(Menu menu, MenuPresenter.PlatformImplementations.kt_3 aVar) {
        m1237c();
        this.f1481i.mo1571a(menu, aVar);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    /* renamed from: OplusGLSurfaceView_5 */
    public void mo1245k() {
        m1237c();
        this.f1481i.mo1601n();
    }

    /* renamed from: androidx.appcompat.widget.ActionBarOverlayLayout$IntrinsicsJvm.kt_4 */
    public static class C0254b extends ViewGroup.MarginLayoutParams {
        public C0254b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0254b(int OplusGLSurfaceView_13, int i2) {
            super(OplusGLSurfaceView_13, i2);
        }

        public C0254b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}
