package androidx.core.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.core.p036h.AccessibilityDelegateCompat;
import androidx.core.p036h.NestedScrollingChildHelper;
import androidx.core.p036h.NestedScrollingParentHelper;
import androidx.core.p036h.ViewCompat;
import androidx.core.p036h.InterfaceC0502k;
import androidx.core.p036h.NestedScrollingParent3;
import androidx.core.p036h.ScrollingView;
import androidx.core.p036h.p037a.AccessibilityNodeInfoCompat;
import androidx.core.p036h.p037a.AccessibilityRecordCompat;
import com.sensetime.stmobile.STMobileHumanActionNative;

/* loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements InterfaceC0502k, NestedScrollingParent3, ScrollingView {

    /* renamed from: w */
    private static final C0519a f3108w = new C0519a();

    /* renamed from: x */
    private static final int[] f3109x = {R.attr.fillViewport};

    /* renamed from: A */
    private float f3110A;

    /* renamed from: B */
    private InterfaceC0520b f3111B;

    /* renamed from: PlatformImplementations.kt_3 */
    private long f3112a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Rect f3113b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private OverScroller f3114c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private EdgeEffect f3115d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private EdgeEffect f3116e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f3117f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f3118g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f3119h;

    /* renamed from: OplusGLSurfaceView_13 */
    private View f3120i;

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean f3121j;

    /* renamed from: OplusGLSurfaceView_5 */
    private VelocityTracker f3122k;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f3123l;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f3124m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f3125n;

    /* renamed from: o */
    private int f3126o;

    /* renamed from: p */
    private int f3127p;

    /* renamed from: q */
    private int f3128q;

    /* renamed from: r */
    private final int[] f3129r;

    /* renamed from: s */
    private final int[] f3130s;

    /* renamed from: t */
    private int f3131t;

    /* renamed from: u */
    private int f3132u;

    /* renamed from: v */
    private SavedState f3133v;

    /* renamed from: y */
    private final NestedScrollingParentHelper f3134y;

    /* renamed from: z */
    private final NestedScrollingChildHelper f3135z;

    /* renamed from: androidx.core.widget.NestedScrollView$IntrinsicsJvm.kt_4 */
    public interface InterfaceC0520b {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo763a(NestedScrollView nestedScrollView, int OplusGLSurfaceView_13, int i2, int i3, int i4);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static int m2966b(int OplusGLSurfaceView_13, int i2, int i3) {
        if (i2 >= i3 || OplusGLSurfaceView_13 < 0) {
            return 0;
        }
        return i2 + OplusGLSurfaceView_13 > i3 ? i3 - i2 : OplusGLSurfaceView_13;
    }

    @Override // androidx.core.p036h.NestedScrollingParent2
    public boolean onStartNestedScroll(View view, View view2, int OplusGLSurfaceView_13, int i2) {
        return (OplusGLSurfaceView_13 & 2) != 0;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public NestedScrollView(Context context) {
        this(context, null);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f3113b = new Rect();
        this.f3118g = true;
        this.f3119h = false;
        this.f3120i = null;
        this.f3121j = false;
        this.f3124m = true;
        this.f3128q = -1;
        this.f3129r = new int[2];
        this.f3130s = new int[2];
        m2957a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f3109x, OplusGLSurfaceView_13, 0);
        setFillViewport(typedArrayObtainStyledAttributes.getBoolean(0, false));
        typedArrayObtainStyledAttributes.recycle();
        this.f3134y = new NestedScrollingParentHelper(this);
        this.f3135z = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        ViewCompat.m2854a(this, f3108w);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2980a(int OplusGLSurfaceView_13, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        this.f3135z.m2800a(OplusGLSurfaceView_13, i2, i3, i4, iArr, i5, iArr2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m2983a(int OplusGLSurfaceView_13, int i2) {
        return this.f3135z.m2806a(OplusGLSurfaceView_13, i2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2979a(int OplusGLSurfaceView_13) {
        this.f3135z.m2814c(OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m2988b(int OplusGLSurfaceView_13) {
        return this.f3135z.m2805a(OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m2985a(int OplusGLSurfaceView_13, int i2, int[] iArr, int[] iArr2, int i3) {
        return this.f3135z.m2810a(OplusGLSurfaceView_13, i2, iArr, iArr2, i3);
    }

    @Override // android.view.View, androidx.core.p036h.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.f3135z.m2801a(z);
    }

    @Override // android.view.View, androidx.core.p036h.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.f3135z.m2802a();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int OplusGLSurfaceView_13) {
        return m2983a(OplusGLSurfaceView_13, 0);
    }

    @Override // android.view.View, androidx.core.p036h.NestedScrollingChild
    public void stopNestedScroll() {
        m2979a(0);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return m2988b(0);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int OplusGLSurfaceView_13, int i2, int i3, int i4, int[] iArr) {
        return this.f3135z.m2807a(OplusGLSurfaceView_13, i2, i3, i4, iArr);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int OplusGLSurfaceView_13, int i2, int[] iArr, int[] iArr2) {
        return m2985a(OplusGLSurfaceView_13, i2, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float COUIBaseListPopupWindow_12, float f2, boolean z) {
        return this.f3135z.m2804a(COUIBaseListPopupWindow_12, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float COUIBaseListPopupWindow_12, float f2) {
        return this.f3135z.m2803a(COUIBaseListPopupWindow_12, f2);
    }

    @Override // androidx.core.p036h.NestedScrollingParent3
    public void onNestedScroll(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int[] iArr) {
        m2958a(i4, i5, iArr);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m2958a(int OplusGLSurfaceView_13, int i2, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, OplusGLSurfaceView_13);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.f3135z.m2800a(0, scrollY2, 0, OplusGLSurfaceView_13 - scrollY2, null, i2, iArr);
    }

    @Override // androidx.core.p036h.NestedScrollingParent2
    public void onNestedScrollAccepted(View view, View view2, int OplusGLSurfaceView_13, int i2) {
        this.f3134y.m2818a(view, view2, OplusGLSurfaceView_13, i2);
        m2983a(2, i2);
    }

    @Override // androidx.core.p036h.NestedScrollingParent2
    public void onStopNestedScroll(View view, int OplusGLSurfaceView_13) {
        this.f3134y.m2816a(view, OplusGLSurfaceView_13);
        m2979a(OplusGLSurfaceView_13);
    }

    @Override // androidx.core.p036h.NestedScrollingParent2
    public void onNestedScroll(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5) {
        m2958a(i4, i5, (int[]) null);
    }

    @Override // androidx.core.p036h.NestedScrollingParent2
    public void onNestedPreScroll(View view, int OplusGLSurfaceView_13, int i2, int[] iArr, int i3) {
        m2985a(OplusGLSurfaceView_13, i2, iArr, null, i3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.p036h.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int OplusGLSurfaceView_13) {
        return onStartNestedScroll(view, view2, OplusGLSurfaceView_13, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.p036h.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int OplusGLSurfaceView_13) {
        onNestedScrollAccepted(view, view2, OplusGLSurfaceView_13, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.p036h.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.p036h.NestedScrollingParent
    public void onNestedScroll(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        m2958a(i4, 0, (int[]) null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.p036h.NestedScrollingParent
    public void onNestedPreScroll(View view, int OplusGLSurfaceView_13, int i2, int[] iArr) {
        onNestedPreScroll(view, OplusGLSurfaceView_13, i2, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.p036h.NestedScrollingParent
    public boolean onNestedFling(View view, float COUIBaseListPopupWindow_12, float f2, boolean z) {
        if (z) {
            return false;
        }
        dispatchNestedFling(0.0f, f2, true);
        m2992f((int) f2);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.p036h.NestedScrollingParent
    public boolean onNestedPreFling(View view, float COUIBaseListPopupWindow_12, float f2) {
        return dispatchNestedPreFling(COUIBaseListPopupWindow_12, f2);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f3134y.m2815a();
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + layoutParams.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m2957a() {
        this.f3114c = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(STMobileHumanActionNative.ST_MOBILE_DETECT_MODE_IMAGE);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f3125n = viewConfiguration.getScaledTouchSlop();
        this.f3126o = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f3127p = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int OplusGLSurfaceView_13) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, OplusGLSurfaceView_13);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, layoutParams);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int OplusGLSurfaceView_13, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, OplusGLSurfaceView_13, layoutParams);
    }

    public void setOnScrollChangeListener(InterfaceC0520b interfaceC0520b) {
        this.f3111B = interfaceC0520b;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m2969b() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    public void setFillViewport(boolean z) {
        if (z != this.f3123l) {
            this.f3123l = z;
            requestLayout();
        }
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.f3124m = z;
    }

    @Override // android.view.View
    protected void onScrollChanged(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        super.onScrollChanged(OplusGLSurfaceView_13, i2, i3, i4);
        InterfaceC0520b interfaceC0520b = this.f3111B;
        if (interfaceC0520b != null) {
            interfaceC0520b.mo763a(this, OplusGLSurfaceView_13, i2, i3, i4);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        super.onMeasure(OplusGLSurfaceView_13, i2);
        if (this.f3123l && View.MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(getChildMeasureSpec(OplusGLSurfaceView_13, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || m2986a(keyEvent);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m2986a(KeyEvent keyEvent) {
        this.f3113b.setEmpty();
        if (!m2969b()) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
                return false;
            }
            View viewFindFocus = findFocus();
            if (viewFindFocus == this) {
                viewFindFocus = null;
            }
            View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, 130);
            return (viewFindNextFocus == null || viewFindNextFocus == this || !viewFindNextFocus.requestFocus(130)) ? false : true;
        }
        if (keyEvent.getAction() != 0) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 19) {
            if (!keyEvent.isAltPressed()) {
                return m2991e(33);
            }
            return m2990d(33);
        }
        if (keyCode == 20) {
            if (!keyEvent.isAltPressed()) {
                return m2991e(130);
            }
            return m2990d(130);
        }
        if (keyCode != 62) {
            return false;
        }
        m2989c(keyEvent.isShiftPressed() ? 33 : 130);
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean m2971c(int OplusGLSurfaceView_13, int i2) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        return i2 >= childAt.getTop() - scrollY && i2 < childAt.getBottom() - scrollY && OplusGLSurfaceView_13 >= childAt.getLeft() && OplusGLSurfaceView_13 < childAt.getRight();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m2970c() {
        VelocityTracker velocityTracker = this.f3122k;
        if (velocityTracker == null) {
            this.f3122k = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m2972d() {
        if (this.f3122k == null) {
            this.f3122k = VelocityTracker.obtain();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m2973e() {
        VelocityTracker velocityTracker = this.f3122k;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f3122k = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            m2973e();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x007d  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r12) {
        /*
            r11 = this;
            int r0 = r12.getAction()
            r1 = 2
            r2 = 1
            if (r0 != r1) goto Ld
            boolean r3 = r11.f3121j
            if (r3 == 0) goto Ld
            return r2
        Ld:
            r0 = r0 & 255(0xff, float:3.57E-43)
            r3 = 0
            if (r0 == 0) goto La2
            r4 = -1
            if (r0 == r2) goto L7d
            if (r0 == r1) goto L24
            r1 = 3
            if (r0 == r1) goto L7d
            r1 = 6
            if (r0 == r1) goto L1f
            goto Ld9
        L1f:
            r11.m2959a(r12)
            goto Ld9
        L24:
            int r0 = r11.f3128q
            if (r0 != r4) goto L2a
            goto Ld9
        L2a:
            int r5 = r12.findPointerIndex(r0)
            if (r5 != r4) goto L4d
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r1 = "Invalid pointerId="
            r12.append(r1)
            r12.append(r0)
            java.lang.String r0 = " in onInterceptTouchEvent"
            r12.append(r0)
            java.lang.String r12 = r12.toString()
            java.lang.String r0 = "NestedScrollView"
            android.util.Log.COUIBaseListPopupWindow_8(r0, r12)
            goto Ld9
        L4d:
            float r0 = r12.getY(r5)
            int r0 = (int) r0
            int r4 = r11.f3117f
            int r4 = r0 - r4
            int r4 = java.lang.Math.abs(r4)
            int r5 = r11.f3125n
            if (r4 <= r5) goto Ld9
            int r4 = r11.getNestedScrollAxes()
            r1 = r1 & r4
            if (r1 != 0) goto Ld9
            r11.f3121j = r2
            r11.f3117f = r0
            r11.m2972d()
            android.view.VelocityTracker r0 = r11.f3122k
            r0.addMovement(r12)
            r11.f3131t = r3
            android.view.ViewParent r12 = r11.getParent()
            if (r12 == 0) goto Ld9
            r12.requestDisallowInterceptTouchEvent(r2)
            goto Ld9
        L7d:
            r11.f3121j = r3
            r11.f3128q = r4
            r11.m2973e()
            android.widget.OverScroller r4 = r11.f3114c
            int r5 = r11.getScrollX()
            int r6 = r11.getScrollY()
            r7 = 0
            r8 = 0
            r9 = 0
            int r10 = r11.getScrollRange()
            boolean r12 = r4.springBack(r5, r6, r7, r8, r9, r10)
            if (r12 == 0) goto L9e
            androidx.core.p036h.ViewCompat.m2881e(r11)
        L9e:
            r11.m2979a(r3)
            goto Ld9
        La2:
            float r0 = r12.getY()
            int r0 = (int) r0
            float r4 = r12.getX()
            int r4 = (int) r4
            boolean r4 = r11.m2971c(r4, r0)
            if (r4 != 0) goto Lb8
            r11.f3121j = r3
            r11.m2973e()
            goto Ld9
        Lb8:
            r11.f3117f = r0
            int r0 = r12.getPointerId(r3)
            r11.f3128q = r0
            r11.m2970c()
            android.view.VelocityTracker r0 = r11.f3122k
            r0.addMovement(r12)
            android.widget.OverScroller r12 = r11.f3114c
            r12.computeScrollOffset()
            android.widget.OverScroller r12 = r11.f3114c
            boolean r12 = r12.isFinished()
            r12 = r12 ^ r2
            r11.f3121j = r12
            r11.m2983a(r1, r3)
        Ld9:
            boolean r11 = r11.f3121j
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        m2972d();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f3131t = 0;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(0.0f, this.f3131t);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.f3122k;
                velocityTracker.computeCurrentVelocity(1000, this.f3127p);
                int yVelocity = (int) velocityTracker.getYVelocity(this.f3128q);
                if (Math.abs(yVelocity) >= this.f3126o) {
                    int OplusGLSurfaceView_13 = -yVelocity;
                    float COUIBaseListPopupWindow_12 = OplusGLSurfaceView_13;
                    if (!dispatchNestedPreFling(0.0f, COUIBaseListPopupWindow_12)) {
                        dispatchNestedFling(0.0f, COUIBaseListPopupWindow_12, true);
                        m2992f(OplusGLSurfaceView_13);
                    }
                } else if (this.f3114c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    ViewCompat.m2881e(this);
                }
                this.f3128q = -1;
                m2975g();
            } else if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f3128q);
                if (iFindPointerIndex == -1) {
                    Log.COUIBaseListPopupWindow_8("NestedScrollView", "Invalid pointerId=" + this.f3128q + " in onTouchEvent");
                } else {
                    int y = (int) motionEvent.getY(iFindPointerIndex);
                    int i2 = this.f3117f - y;
                    if (!this.f3121j && Math.abs(i2) > this.f3125n) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f3121j = true;
                        i2 = i2 > 0 ? i2 - this.f3125n : i2 + this.f3125n;
                    }
                    int i3 = i2;
                    if (this.f3121j) {
                        if (m2985a(0, i3, this.f3130s, this.f3129r, 0)) {
                            i3 -= this.f3130s[1];
                            this.f3131t += this.f3129r[1];
                        }
                        int i4 = i3;
                        this.f3117f = y - this.f3129r[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange();
                        int overScrollMode = getOverScrollMode();
                        boolean z = overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0);
                        if (m2984a(0, i4, 0, getScrollY(), 0, scrollRange, 0, 0, true) && !m2988b(0)) {
                            this.f3122k.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        int[] iArr = this.f3130s;
                        iArr[1] = 0;
                        m2980a(0, scrollY2, 0, i4 - scrollY2, this.f3129r, 0, iArr);
                        int i5 = this.f3117f;
                        int[] iArr2 = this.f3129r;
                        this.f3117f = i5 - iArr2[1];
                        this.f3131t += iArr2[1];
                        if (z) {
                            int i6 = i4 - this.f3130s[1];
                            m2977h();
                            int i7 = scrollY + i6;
                            if (i7 < 0) {
                                EdgeEffectCompat.m3034a(this.f3115d, i6 / getHeight(), motionEvent.getX(iFindPointerIndex) / getWidth());
                                if (!this.f3116e.isFinished()) {
                                    this.f3116e.onRelease();
                                }
                            } else if (i7 > scrollRange) {
                                EdgeEffectCompat.m3034a(this.f3116e, i6 / getHeight(), 1.0f - (motionEvent.getX(iFindPointerIndex) / getWidth()));
                                if (!this.f3115d.isFinished()) {
                                    this.f3115d.onRelease();
                                }
                            }
                            EdgeEffect edgeEffect = this.f3115d;
                            if (edgeEffect != null && (!edgeEffect.isFinished() || !this.f3116e.isFinished())) {
                                ViewCompat.m2881e(this);
                            }
                        }
                    }
                }
            } else if (actionMasked == 3) {
                if (this.f3121j && getChildCount() > 0 && this.f3114c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    ViewCompat.m2881e(this);
                }
                this.f3128q = -1;
                m2975g();
            } else if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                this.f3117f = (int) motionEvent.getY(actionIndex);
                this.f3128q = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                m2959a(motionEvent);
                this.f3117f = (int) motionEvent.getY(motionEvent.findPointerIndex(this.f3128q));
            }
        } else {
            if (getChildCount() == 0) {
                return false;
            }
            boolean z2 = !this.f3114c.isFinished();
            this.f3121j = z2;
            if (z2 && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.f3114c.isFinished()) {
                m2974f();
            }
            this.f3117f = (int) motionEvent.getY();
            this.f3128q = motionEvent.getPointerId(0);
            m2983a(2, 0);
        }
        VelocityTracker velocityTracker2 = this.f3122k;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEventObtain);
        }
        motionEventObtain.recycle();
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m2959a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f3128q) {
            int OplusGLSurfaceView_13 = actionIndex == 0 ? 1 : 0;
            this.f3117f = (int) motionEvent.getY(OplusGLSurfaceView_13);
            this.f3128q = motionEvent.getPointerId(OplusGLSurfaceView_13);
            VelocityTracker velocityTracker = this.f3122k;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8 && !this.f3121j) {
            float axisValue = motionEvent.getAxisValue(9);
            if (axisValue != 0.0f) {
                int verticalScrollFactorCompat = (int) (axisValue * getVerticalScrollFactorCompat());
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int OplusGLSurfaceView_13 = scrollY - verticalScrollFactorCompat;
                if (OplusGLSurfaceView_13 < 0) {
                    OplusGLSurfaceView_13 = 0;
                } else if (OplusGLSurfaceView_13 > scrollRange) {
                    OplusGLSurfaceView_13 = scrollRange;
                }
                if (OplusGLSurfaceView_13 != scrollY) {
                    super.scrollTo(getScrollX(), OplusGLSurfaceView_13);
                    return true;
                }
            }
        }
        return false;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.f3110A == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.f3110A = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.f3110A;
    }

    @Override // android.view.View
    protected void onOverScrolled(int OplusGLSurfaceView_13, int i2, boolean z, boolean z2) {
        super.scrollTo(OplusGLSurfaceView_13, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x005a  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    boolean m2984a(int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, boolean r21) {
        /*
            r12 = this;
            r0 = r12
            int r1 = r12.getOverScrollMode()
            int r2 = r12.computeHorizontalScrollRange()
            int r3 = r12.computeHorizontalScrollExtent()
            r4 = 0
            r5 = 1
            if (r2 <= r3) goto L13
            r2 = r5
            goto L14
        L13:
            r2 = r4
        L14:
            int r3 = r12.computeVerticalScrollRange()
            int r6 = r12.computeVerticalScrollExtent()
            if (r3 <= r6) goto L20
            r3 = r5
            goto L21
        L20:
            r3 = r4
        L21:
            if (r1 == 0) goto L2a
            if (r1 != r5) goto L28
            if (r2 == 0) goto L28
            goto L2a
        L28:
            r2 = r4
            goto L2b
        L2a:
            r2 = r5
        L2b:
            if (r1 == 0) goto L34
            if (r1 != r5) goto L32
            if (r3 == 0) goto L32
            goto L34
        L32:
            r1 = r4
            goto L35
        L34:
            r1 = r5
        L35:
            int r3 = r15 + r13
            if (r2 != 0) goto L3b
            r2 = r4
            goto L3d
        L3b:
            r2 = r19
        L3d:
            int r6 = r16 + r14
            if (r1 != 0) goto L43
            r1 = r4
            goto L45
        L43:
            r1 = r20
        L45:
            int r7 = -r2
            int r2 = r2 + r17
            int r8 = -r1
            int r1 = r1 + r18
            if (r3 <= r2) goto L50
            r7 = r2
        L4e:
            r2 = r5
            goto L55
        L50:
            if (r3 >= r7) goto L53
            goto L4e
        L53:
            r7 = r3
            r2 = r4
        L55:
            if (r6 <= r1) goto L5a
            r6 = r1
            r1 = r5
            goto L60
        L5a:
            if (r6 >= r8) goto L5f
            r1 = r5
            r6 = r8
            goto L60
        L5f:
            r1 = r4
        L60:
            if (r1 == 0) goto L7f
            boolean r3 = r12.m2988b(r5)
            if (r3 != 0) goto L7f
            android.widget.OverScroller r3 = r0.f3114c
            r8 = 0
            r9 = 0
            r10 = 0
            int r11 = r12.getScrollRange()
            r13 = r3
            r14 = r7
            r15 = r6
            r16 = r8
            r17 = r9
            r18 = r10
            r19 = r11
            r13.springBack(r14, r15, r16, r17, r18, r19)
        L7f:
            r12.onOverScrolled(r7, r6, r2, r1)
            if (r2 != 0) goto L86
            if (r1 == 0) goto L87
        L86:
            r4 = r5
        L87:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.m2984a(int, int, int, int, int, int, int, int, boolean):boolean");
    }

    int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0050  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.view.View m2956a(boolean r12, int r13, int r14) {
        /*
            r11 = this;
            r0 = 2
            java.util.ArrayList r11 = r11.getFocusables(r0)
            int r0 = r11.size()
            r1 = 0
            r2 = 0
            r4 = r1
            r3 = r2
            r2 = r4
        Le:
            if (r2 >= r0) goto L54
            java.lang.Object r5 = r11.get(r2)
            android.view.View r5 = (android.view.View) r5
            int r6 = r5.getTop()
            int r7 = r5.getBottom()
            r8 = 1
            if (r13 >= r7) goto L51
            if (r6 >= r14) goto L51
            if (r13 >= r6) goto L29
            if (r7 >= r14) goto L29
            r9 = r8
            goto L2a
        L29:
            r9 = r1
        L2a:
            if (r3 != 0) goto L2f
            r3 = r5
            r4 = r9
            goto L51
        L2f:
            if (r12 == 0) goto L37
            int r10 = r3.getTop()
            if (r6 < r10) goto L3f
        L37:
            if (r12 != 0) goto L41
            int r6 = r3.getBottom()
            if (r7 <= r6) goto L41
        L3f:
            r6 = r8
            goto L42
        L41:
            r6 = r1
        L42:
            if (r4 == 0) goto L49
            if (r9 == 0) goto L51
            if (r6 == 0) goto L51
            goto L50
        L49:
            if (r9 == 0) goto L4e
            r3 = r5
            r4 = r8
            goto L51
        L4e:
            if (r6 == 0) goto L51
        L50:
            r3 = r5
        L51:
            int r2 = r2 + 1
            goto Le
        L54:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.m2956a(boolean, int, int):android.view.View");
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m2989c(int OplusGLSurfaceView_13) {
        boolean z = OplusGLSurfaceView_13 == 130;
        int height = getHeight();
        if (z) {
            this.f3113b.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                if (this.f3113b.top + height > bottom) {
                    this.f3113b.top = bottom - height;
                }
            }
        } else {
            this.f3113b.top = getScrollY() - height;
            if (this.f3113b.top < 0) {
                this.f3113b.top = 0;
            }
        }
        Rect rect = this.f3113b;
        rect.bottom = rect.top + height;
        return m2961a(OplusGLSurfaceView_13, this.f3113b.top, this.f3113b.bottom);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m2990d(int OplusGLSurfaceView_13) {
        int childCount;
        boolean z = OplusGLSurfaceView_13 == 130;
        int height = getHeight();
        Rect rect = this.f3113b;
        rect.top = 0;
        rect.bottom = height;
        if (z && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.f3113b.bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
            Rect rect2 = this.f3113b;
            rect2.top = rect2.bottom - height;
        }
        return m2961a(OplusGLSurfaceView_13, this.f3113b.top, this.f3113b.bottom);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m2961a(int OplusGLSurfaceView_13, int i2, int i3) {
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = height + scrollY;
        boolean z = false;
        boolean z2 = OplusGLSurfaceView_13 == 33;
        View viewM2956a = m2956a(z2, i2, i3);
        if (viewM2956a == null) {
            viewM2956a = this;
        }
        if (i2 < scrollY || i3 > i4) {
            m2976g(z2 ? i2 - scrollY : i3 - i4);
            z = true;
        }
        if (viewM2956a != findFocus()) {
            viewM2956a.requestFocus(OplusGLSurfaceView_13);
        }
        return z;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m2991e(int OplusGLSurfaceView_13) {
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, OplusGLSurfaceView_13);
        int maxScrollAmount = getMaxScrollAmount();
        if (viewFindNextFocus != null && m2964a(viewFindNextFocus, maxScrollAmount, getHeight())) {
            viewFindNextFocus.getDrawingRect(this.f3113b);
            offsetDescendantRectToMyCoords(viewFindNextFocus, this.f3113b);
            m2976g(m2978a(this.f3113b));
            viewFindNextFocus.requestFocus(OplusGLSurfaceView_13);
        } else {
            if (OplusGLSurfaceView_13 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (OplusGLSurfaceView_13 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (OplusGLSurfaceView_13 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            m2976g(maxScrollAmount);
        }
        if (viewFindFocus == null || !viewFindFocus.isFocused() || !m2963a(viewFindFocus)) {
            return true;
        }
        int descendantFocusability = getDescendantFocusability();
        setDescendantFocusability(131072);
        requestFocus();
        setDescendantFocusability(descendantFocusability);
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m2963a(View view) {
        return !m2964a(view, 0, getHeight());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m2964a(View view, int OplusGLSurfaceView_13, int i2) {
        view.getDrawingRect(this.f3113b);
        offsetDescendantRectToMyCoords(view, this.f3113b);
        return this.f3113b.bottom + OplusGLSurfaceView_13 >= getScrollY() && this.f3113b.top - OplusGLSurfaceView_13 <= getScrollY() + i2;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m2976g(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 != 0) {
            if (this.f3124m) {
                m2987b(0, OplusGLSurfaceView_13);
            } else {
                scrollBy(0, OplusGLSurfaceView_13);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public final void m2987b(int OplusGLSurfaceView_13, int i2) {
        m2967b(OplusGLSurfaceView_13, i2, 250, false);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m2967b(int OplusGLSurfaceView_13, int i2, int i3, boolean z) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.f3112a > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            this.f3114c.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(i2 + scrollY, Math.max(0, height - height2))) - scrollY, i3);
            m2960a(z);
        } else {
            if (!this.f3114c.isFinished()) {
                m2974f();
            }
            scrollBy(OplusGLSurfaceView_13, i2);
        }
        this.f3112a = AnimationUtils.currentAnimationTimeMillis();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m2982a(int OplusGLSurfaceView_13, int i2, boolean z) {
        m2981a(OplusGLSurfaceView_13, i2, 250, z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m2981a(int OplusGLSurfaceView_13, int i2, int i3, boolean z) {
        m2967b(OplusGLSurfaceView_13 - getScrollX(), i2 - getScrollY(), i3, z);
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int iMax = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > iMax ? bottom + (scrollY - iMax) : bottom;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.ViewGroup
    protected void measureChild(View view, int OplusGLSurfaceView_13, int i2) {
        view.measure(getChildMeasureSpec(OplusGLSurfaceView_13, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    protected void measureChildWithMargins(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(OplusGLSurfaceView_13, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f3114c.isFinished()) {
            return;
        }
        this.f3114c.computeScrollOffset();
        int currY = this.f3114c.getCurrY();
        int OplusGLSurfaceView_13 = currY - this.f3132u;
        this.f3132u = currY;
        int[] iArr = this.f3130s;
        boolean z = false;
        iArr[1] = 0;
        m2985a(0, OplusGLSurfaceView_13, iArr, null, 1);
        int i2 = OplusGLSurfaceView_13 - this.f3130s[1];
        int scrollRange = getScrollRange();
        if (i2 != 0) {
            int scrollY = getScrollY();
            m2984a(0, i2, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
            int scrollY2 = getScrollY() - scrollY;
            int i3 = i2 - scrollY2;
            int[] iArr2 = this.f3130s;
            iArr2[1] = 0;
            m2980a(0, scrollY2, 0, i3, this.f3129r, 1, iArr2);
            i2 = i3 - this.f3130s[1];
        }
        if (i2 != 0) {
            int overScrollMode = getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                z = true;
            }
            if (z) {
                m2977h();
                if (i2 < 0) {
                    if (this.f3115d.isFinished()) {
                        this.f3115d.onAbsorb((int) this.f3114c.getCurrVelocity());
                    }
                } else if (this.f3116e.isFinished()) {
                    this.f3116e.onAbsorb((int) this.f3114c.getCurrVelocity());
                }
            }
            m2974f();
        }
        if (!this.f3114c.isFinished()) {
            ViewCompat.m2881e(this);
        } else {
            m2979a(1);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m2960a(boolean z) {
        if (z) {
            m2983a(2, 1);
        } else {
            m2979a(1);
        }
        this.f3132u = getScrollY();
        ViewCompat.m2881e(this);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m2974f() {
        this.f3114c.abortAnimation();
        m2979a(1);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m2968b(View view) {
        view.getDrawingRect(this.f3113b);
        offsetDescendantRectToMyCoords(view, this.f3113b);
        int iM2978a = m2978a(this.f3113b);
        if (iM2978a != 0) {
            scrollBy(0, iM2978a);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m2962a(Rect rect, boolean z) {
        int iM2978a = m2978a(rect);
        boolean z2 = iM2978a != 0;
        if (z2) {
            if (z) {
                scrollBy(0, iM2978a);
            } else {
                m2987b(0, iM2978a);
            }
        }
        return z2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected int m2978a(Rect rect) {
        int OplusGLSurfaceView_13;
        int i2;
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i3 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i4 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i3 - verticalFadingEdgeLength : i3;
        if (rect.bottom > i4 && rect.top > scrollY) {
            if (rect.height() > height) {
                i2 = rect.top - scrollY;
            } else {
                i2 = rect.bottom - i4;
            }
            return Math.min(i2 + 0, (childAt.getBottom() + layoutParams.bottomMargin) - i3);
        }
        if (rect.top >= scrollY || rect.bottom >= i4) {
            return 0;
        }
        if (rect.height() > height) {
            OplusGLSurfaceView_13 = 0 - (i4 - rect.bottom);
        } else {
            OplusGLSurfaceView_13 = 0 - (scrollY - rect.top);
        }
        return Math.max(OplusGLSurfaceView_13, -getScrollY());
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.f3118g) {
            m2968b(view2);
        } else {
            this.f3120i = view2;
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int OplusGLSurfaceView_13, Rect rect) {
        View viewFindNextFocusFromRect;
        if (OplusGLSurfaceView_13 == 2) {
            OplusGLSurfaceView_13 = 130;
        } else if (OplusGLSurfaceView_13 == 1) {
            OplusGLSurfaceView_13 = 33;
        }
        if (rect == null) {
            viewFindNextFocusFromRect = FocusFinder.getInstance().findNextFocus(this, null, OplusGLSurfaceView_13);
        } else {
            viewFindNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(this, rect, OplusGLSurfaceView_13);
        }
        if (viewFindNextFocusFromRect == null || m2963a(viewFindNextFocusFromRect)) {
            return false;
        }
        return viewFindNextFocusFromRect.requestFocus(OplusGLSurfaceView_13, rect);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return m2962a(rect, z);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.f3118g = true;
        super.requestLayout();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        super.onLayout(z, OplusGLSurfaceView_13, i2, i3, i4);
        int measuredHeight = 0;
        this.f3118g = false;
        View view = this.f3120i;
        if (view != null && m2965a(view, this)) {
            m2968b(this.f3120i);
        }
        this.f3120i = null;
        if (!this.f3119h) {
            if (this.f3133v != null) {
                scrollTo(getScrollX(), this.f3133v.scrollPosition);
                this.f3133v = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                measuredHeight = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int iM2966b = m2966b(scrollY, paddingTop, measuredHeight);
            if (iM2966b != scrollY) {
                scrollTo(getScrollX(), iM2966b);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f3119h = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f3119h = false;
    }

    @Override // android.view.View
    protected void onSizeChanged(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        super.onSizeChanged(OplusGLSurfaceView_13, i2, i3, i4);
        View viewFindFocus = findFocus();
        if (viewFindFocus == null || this == viewFindFocus || !m2964a(viewFindFocus, 0, i4)) {
            return;
        }
        viewFindFocus.getDrawingRect(this.f3113b);
        offsetDescendantRectToMyCoords(viewFindFocus, this.f3113b);
        m2976g(m2978a(this.f3113b));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean m2965a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        Object parent = view.getParent();
        return (parent instanceof ViewGroup) && m2965a((View) parent, view2);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m2992f(int OplusGLSurfaceView_13) {
        if (getChildCount() > 0) {
            this.f3114c.fling(getScrollX(), getScrollY(), 0, OplusGLSurfaceView_13, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            m2960a(true);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m2975g() {
        this.f3121j = false;
        m2973e();
        m2979a(0);
        EdgeEffect edgeEffect = this.f3115d;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            this.f3116e.onRelease();
        }
    }

    @Override // android.view.View
    public void scrollTo(int OplusGLSurfaceView_13, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int iM2966b = m2966b(OplusGLSurfaceView_13, width, width2);
            int iM2966b2 = m2966b(i2, height, height2);
            if (iM2966b == getScrollX() && iM2966b2 == getScrollY()) {
                return;
            }
            super.scrollTo(iM2966b, iM2966b2);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m2977h() {
        if (getOverScrollMode() != 2) {
            if (this.f3115d == null) {
                Context context = getContext();
                this.f3115d = new EdgeEffect(context);
                this.f3116e = new EdgeEffect(context);
                return;
            }
            return;
        }
        this.f3115d = null;
        this.f3116e = null;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int paddingLeft;
        super.draw(canvas);
        if (this.f3115d != null) {
            int scrollY = getScrollY();
            int paddingLeft2 = 0;
            if (!this.f3115d.isFinished()) {
                int iSave = canvas.save();
                int width = getWidth();
                int height = getHeight();
                int iMin = Math.min(0, scrollY);
                if (Build.VERSION.SDK_INT < 21 || getClipToPadding()) {
                    width -= getPaddingLeft() + getPaddingRight();
                    paddingLeft = getPaddingLeft() + 0;
                } else {
                    paddingLeft = 0;
                }
                if (Build.VERSION.SDK_INT >= 21 && getClipToPadding()) {
                    height -= getPaddingTop() + getPaddingBottom();
                    iMin += getPaddingTop();
                }
                canvas.translate(paddingLeft, iMin);
                this.f3115d.setSize(width, height);
                if (this.f3115d.draw(canvas)) {
                    ViewCompat.m2881e(this);
                }
                canvas.restoreToCount(iSave);
            }
            if (this.f3116e.isFinished()) {
                return;
            }
            int iSave2 = canvas.save();
            int width2 = getWidth();
            int height2 = getHeight();
            int iMax = Math.max(getScrollRange(), scrollY) + height2;
            if (Build.VERSION.SDK_INT < 21 || getClipToPadding()) {
                width2 -= getPaddingLeft() + getPaddingRight();
                paddingLeft2 = 0 + getPaddingLeft();
            }
            if (Build.VERSION.SDK_INT >= 21 && getClipToPadding()) {
                height2 -= getPaddingTop() + getPaddingBottom();
                iMax -= getPaddingBottom();
            }
            canvas.translate(paddingLeft2 - width2, iMax);
            canvas.rotate(180.0f, width2, 0.0f);
            this.f3116e.setSize(width2, height2);
            if (this.f3116e.draw(canvas)) {
                ViewCompat.m2881e(this);
            }
            canvas.restoreToCount(iSave2);
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f3133v = savedState;
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.scrollPosition = getScrollY();
        return savedState;
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.core.widget.NestedScrollView.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int OplusGLSurfaceView_13) {
                return new SavedState[OplusGLSurfaceView_13];
            }
        };
        public int scrollPosition;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.scrollPosition = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
            super.writeToParcel(parcel, OplusGLSurfaceView_13);
            parcel.writeInt(this.scrollPosition);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.scrollPosition + "}";
        }
    }

    /* renamed from: androidx.core.widget.NestedScrollView$PlatformImplementations.kt_3 */
    static class C0519a extends AccessibilityDelegateCompat {
        C0519a() {
        }

        @Override // androidx.core.p036h.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int OplusGLSurfaceView_13, Bundle bundle) {
            if (super.performAccessibilityAction(view, OplusGLSurfaceView_13, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            if (OplusGLSurfaceView_13 != 4096) {
                if (OplusGLSurfaceView_13 == 8192 || OplusGLSurfaceView_13 == 16908344) {
                    int iMax = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (iMax == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.m2982a(0, iMax, true);
                    return true;
                }
                if (OplusGLSurfaceView_13 != 16908346) {
                    return false;
                }
            }
            int iMin = Math.min(nestedScrollView.getScrollY() + ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (iMin == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.m2982a(0, iMin, true);
            return true;
        }

        @Override // androidx.core.p036h.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat c0483d) {
            int scrollRange;
            super.onInitializeAccessibilityNodeInfo(view, c0483d);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            c0483d.m2690b((CharSequence) ScrollView.class.getName());
            if (!nestedScrollView.isEnabled() || (scrollRange = nestedScrollView.getScrollRange()) <= 0) {
                return;
            }
            c0483d.m2715i(true);
            if (nestedScrollView.getScrollY() > 0) {
                c0483d.m2679a(AccessibilityNodeInfoCompat.PlatformImplementations.kt_3.f3027n);
                c0483d.m2679a(AccessibilityNodeInfoCompat.PlatformImplementations.kt_3.f3038y);
            }
            if (nestedScrollView.getScrollY() < scrollRange) {
                c0483d.m2679a(AccessibilityNodeInfoCompat.PlatformImplementations.kt_3.f3026m);
                c0483d.m2679a(AccessibilityNodeInfoCompat.PlatformImplementations.kt_3.f3003A);
            }
        }

        @Override // androidx.core.p036h.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            AccessibilityRecordCompat.m2754a(accessibilityEvent, nestedScrollView.getScrollX());
            AccessibilityRecordCompat.m2756b(accessibilityEvent, nestedScrollView.getScrollRange());
        }
    }
}
