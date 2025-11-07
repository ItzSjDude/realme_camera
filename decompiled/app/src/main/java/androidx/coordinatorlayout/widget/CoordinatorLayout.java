package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.R;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.p027a.ContextCompat;
import androidx.core.p035g.ObjectsCompat;
import androidx.core.p035g.Pools;
import androidx.core.p036h.WindowInsetsCompat;
import androidx.core.p036h.GravityCompat;
import androidx.core.p036h.NestedScrollingParentHelper;
import androidx.core.p036h.ViewCompat;
import androidx.core.p036h.NestedScrollingParent2;
import androidx.core.p036h.NestedScrollingParent3;
import androidx.core.p036h.OnApplyWindowInsetsListener;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.badge.BadgeDrawable;
import com.oplus.camera.capmode.VideoMode;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements NestedScrollingParent2, NestedScrollingParent3 {
    static final Class<?>[] CONSTRUCTOR_PARAMS;
    static final int EVENT_NESTED_SCROLL = 1;
    static final int EVENT_PRE_DRAW = 0;
    static final int EVENT_VIEW_REMOVED = 2;
    static final String TAG = "CoordinatorLayout";
    static final Comparator<View> TOP_SORTED_CHILDREN_COMPARATOR;
    private static final int TYPE_ON_INTERCEPT = 0;
    private static final int TYPE_ON_TOUCH = 1;
    static final String WIDGET_PACKAGE_NAME;
    static final ThreadLocal<Map<String, Constructor<AbstractC0408b>>> sConstructors;
    private static final Pools.PlatformImplementations.kt_3<Rect> sRectPool;
    private OnApplyWindowInsetsListener mApplyWindowInsetsListener;
    private final int[] mBehaviorConsumed;
    private View mBehaviorTouchView;
    private final DirectedAcyclicGraph<View> mChildDag;
    private final List<View> mDependencySortedChildren;
    private boolean mDisallowInterceptReset;
    private boolean mDrawStatusBarBackground;
    private boolean mIsAttachedToWindow;
    private int[] mKeylines;
    private WindowInsetsCompat mLastInsets;
    private boolean mNeedsPreDrawListener;
    private final NestedScrollingParentHelper mNestedScrollingParentHelper;
    private View mNestedScrollingTarget;
    private final int[] mNestedScrollingV2ConsumedCompat;
    ViewGroup.OnHierarchyChangeListener mOnHierarchyChangeListener;
    private ViewTreeObserverOnPreDrawListenerC0412f mOnPreDrawListener;
    private Paint mScrimPaint;
    private Drawable mStatusBarBackground;
    private final List<View> mTempDependenciesList;
    private final List<View> mTempList1;

    /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$PlatformImplementations.kt_3 */
    public interface InterfaceC0407a {
        AbstractC0408b getBehavior();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Deprecated
    /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$IntrinsicsJvm.kt_3 */
    public @interface InterfaceC0409c {
        /* renamed from: PlatformImplementations.kt_3 */
        Class<? extends AbstractC0408b> m2212a();
    }

    private static int clamp(int OplusGLSurfaceView_13, int i2, int i3) {
        return OplusGLSurfaceView_13 < i2 ? i2 : OplusGLSurfaceView_13 > i3 ? i3 : OplusGLSurfaceView_13;
    }

    private static int resolveAnchoredChildGravity(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 0) {
            return 17;
        }
        return OplusGLSurfaceView_13;
    }

    private static int resolveGravity(int OplusGLSurfaceView_13) {
        if ((OplusGLSurfaceView_13 & 7) == 0) {
            OplusGLSurfaceView_13 |= 8388611;
        }
        return (OplusGLSurfaceView_13 & 112) == 0 ? OplusGLSurfaceView_13 | 48 : OplusGLSurfaceView_13;
    }

    private static int resolveKeylineGravity(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 == 0 ? BadgeDrawable.TOP_END : OplusGLSurfaceView_13;
    }

    static {
        Package r0 = CoordinatorLayout.class.getPackage();
        WIDGET_PACKAGE_NAME = r0 != null ? r0.getName() : null;
        if (Build.VERSION.SDK_INT >= 21) {
            TOP_SORTED_CHILDREN_COMPARATOR = new C0413g();
        } else {
            TOP_SORTED_CHILDREN_COMPARATOR = null;
        }
        CONSTRUCTOR_PARAMS = new Class[]{Context.class, AttributeSet.class};
        sConstructors = new ThreadLocal<>();
        sRectPool = new Pools.IntrinsicsJvm.kt_3(12);
    }

    private static Rect acquireTempRect() {
        Rect rectMo2532a = sRectPool.mo2532a();
        return rectMo2532a == null ? new Rect() : rectMo2532a;
    }

    private static void releaseTempRect(Rect rect) {
        rect.setEmpty();
        sRectPool.mo2533a(rect);
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.coordinatorLayoutStyle);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        TypedArray typedArrayObtainStyledAttributes;
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.mDependencySortedChildren = new ArrayList();
        this.mChildDag = new DirectedAcyclicGraph<>();
        this.mTempList1 = new ArrayList();
        this.mTempDependenciesList = new ArrayList();
        this.mBehaviorConsumed = new int[2];
        this.mNestedScrollingV2ConsumedCompat = new int[2];
        this.mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        if (OplusGLSurfaceView_13 == 0) {
            typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout, 0, R.style.Widget_Support_CoordinatorLayout);
        } else {
            typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout, OplusGLSurfaceView_13, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            if (OplusGLSurfaceView_13 == 0) {
                saveAttributeDataForStyleable(context, R.styleable.CoordinatorLayout, attributeSet, typedArrayObtainStyledAttributes, 0, R.style.Widget_Support_CoordinatorLayout);
            } else {
                saveAttributeDataForStyleable(context, R.styleable.CoordinatorLayout, attributeSet, typedArrayObtainStyledAttributes, OplusGLSurfaceView_13, 0);
            }
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.mKeylines = resources.getIntArray(resourceId);
            float COUIBaseListPopupWindow_12 = resources.getDisplayMetrics().density;
            int length = this.mKeylines.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.mKeylines[i2] = (int) (r12[i2] * COUIBaseListPopupWindow_12);
            }
        }
        this.mStatusBarBackground = typedArrayObtainStyledAttributes.getDrawable(R.styleable.CoordinatorLayout_statusBarBackground);
        typedArrayObtainStyledAttributes.recycle();
        setupForInsets();
        super.setOnHierarchyChangeListener(new ViewGroupOnHierarchyChangeListenerC0410d());
        if (ViewCompat.m2883f(this) == 0) {
            ViewCompat.m2867b((View) this, 1);
        }
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.mOnHierarchyChangeListener = onHierarchyChangeListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        resetTouchBehaviors(false);
        if (this.mNeedsPreDrawListener) {
            if (this.mOnPreDrawListener == null) {
                this.mOnPreDrawListener = new ViewTreeObserverOnPreDrawListenerC0412f();
            }
            getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        }
        if (this.mLastInsets == null && ViewCompat.m2901t(this)) {
            ViewCompat.m2900s(this);
        }
        this.mIsAttachedToWindow = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        resetTouchBehaviors(false);
        if (this.mNeedsPreDrawListener && this.mOnPreDrawListener != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        }
        View view = this.mNestedScrollingTarget;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.mIsAttachedToWindow = false;
    }

    public void setStatusBarBackground(Drawable drawable) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Drawable drawable2 = this.mStatusBarBackground;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            this.mStatusBarBackground = drawable != null ? drawable.mutate() : null;
            Drawable drawable3 = this.mStatusBarBackground;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.mStatusBarBackground.setState(getDrawableState());
                }
                DrawableCompat.m2576b(this.mStatusBarBackground, ViewCompat.m2885g(this));
                this.mStatusBarBackground.setVisible(getVisibility() == 0, false);
                this.mStatusBarBackground.setCallback(this);
            }
            ViewCompat.m2881e(this);
        }
    }

    public Drawable getStatusBarBackground() {
        return this.mStatusBarBackground;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.mStatusBarBackground;
        boolean state = false;
        if (drawable != null && drawable.isStateful()) {
            state = false | drawable.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mStatusBarBackground;
    }

    @Override // android.view.View
    public void setVisibility(int OplusGLSurfaceView_13) {
        super.setVisibility(OplusGLSurfaceView_13);
        boolean z = OplusGLSurfaceView_13 == 0;
        Drawable drawable = this.mStatusBarBackground;
        if (drawable == null || drawable.isVisible() == z) {
            return;
        }
        this.mStatusBarBackground.setVisible(z, false);
    }

    public void setStatusBarBackgroundResource(int OplusGLSurfaceView_13) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        setStatusBarBackground(OplusGLSurfaceView_13 != 0 ? ContextCompat.m2248a(getContext(), OplusGLSurfaceView_13) : null);
    }

    public void setStatusBarBackgroundColor(int OplusGLSurfaceView_13) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        setStatusBarBackground(new ColorDrawable(OplusGLSurfaceView_13));
    }

    final WindowInsetsCompat setWindowInsets(WindowInsetsCompat c0490ad) {
        if (ObjectsCompat.m2530a(this.mLastInsets, c0490ad)) {
            return c0490ad;
        }
        this.mLastInsets = c0490ad;
        this.mDrawStatusBarBackground = c0490ad != null && c0490ad.m2761b() > 0;
        setWillNotDraw(!this.mDrawStatusBarBackground && getBackground() == null);
        WindowInsetsCompat c0490adDispatchApplyWindowInsetsToBehaviors = dispatchApplyWindowInsetsToBehaviors(c0490ad);
        requestLayout();
        return c0490adDispatchApplyWindowInsetsToBehaviors;
    }

    public final WindowInsetsCompat getLastWindowInsets() {
        return this.mLastInsets;
    }

    private void resetTouchBehaviors(boolean z) {
        int childCount = getChildCount();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            View childAt = getChildAt(OplusGLSurfaceView_13);
            AbstractC0408b abstractC0408bM2225b = ((C0411e) childAt.getLayoutParams()).m2225b();
            if (abstractC0408bM2225b != null) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z) {
                    abstractC0408bM2225b.onInterceptTouchEvent(this, childAt, motionEventObtain);
                } else {
                    abstractC0408bM2225b.onTouchEvent(this, childAt, motionEventObtain);
                }
                motionEventObtain.recycle();
            }
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            ((C0411e) getChildAt(i2).getLayoutParams()).m2230f();
        }
        this.mBehaviorTouchView = null;
        this.mDisallowInterceptReset = false;
    }

    private void getTopSortedChildren(List<View> list) {
        list.clear();
        boolean zIsChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int OplusGLSurfaceView_13 = childCount - 1; OplusGLSurfaceView_13 >= 0; OplusGLSurfaceView_13--) {
            list.add(getChildAt(zIsChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, OplusGLSurfaceView_13) : OplusGLSurfaceView_13));
        }
        Comparator<View> comparator = TOP_SORTED_CHILDREN_COMPARATOR;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    private boolean performIntercept(MotionEvent motionEvent, int OplusGLSurfaceView_13) {
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.mTempList1;
        getTopSortedChildren(list);
        int size = list.size();
        boolean zOnInterceptTouchEvent = false;
        boolean z = false;
        MotionEvent motionEventObtain = null;
        for (int i2 = 0; i2 < size; i2++) {
            View view = list.get(i2);
            C0411e c0411e = (C0411e) view.getLayoutParams();
            AbstractC0408b abstractC0408bM2225b = c0411e.m2225b();
            if (!(zOnInterceptTouchEvent || z) || actionMasked == 0) {
                if (!zOnInterceptTouchEvent && abstractC0408bM2225b != null) {
                    if (OplusGLSurfaceView_13 == 0) {
                        zOnInterceptTouchEvent = abstractC0408bM2225b.onInterceptTouchEvent(this, view, motionEvent);
                    } else if (OplusGLSurfaceView_13 == 1) {
                        zOnInterceptTouchEvent = abstractC0408bM2225b.onTouchEvent(this, view, motionEvent);
                    }
                    if (zOnInterceptTouchEvent) {
                        this.mBehaviorTouchView = view;
                    }
                }
                boolean zM2229e = c0411e.m2229e();
                boolean zM2222a = c0411e.m2222a(this, view);
                boolean z2 = zM2222a && !zM2229e;
                if (zM2222a && !z2) {
                    break;
                }
                z = z2;
            } else if (abstractC0408bM2225b != null) {
                if (motionEventObtain == null) {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (OplusGLSurfaceView_13 == 0) {
                    abstractC0408bM2225b.onInterceptTouchEvent(this, view, motionEventObtain);
                } else if (OplusGLSurfaceView_13 == 1) {
                    abstractC0408bM2225b.onTouchEvent(this, view, motionEventObtain);
                }
            }
        }
        list.clear();
        return zOnInterceptTouchEvent;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            resetTouchBehaviors(true);
        }
        boolean zPerformIntercept = performIntercept(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            resetTouchBehaviors(true);
        }
        return zPerformIntercept;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002b A[PHI: r3
      0x002b: PHI (r3v4 boolean) = (r3v2 boolean), (r3v5 boolean) binds: [B:9:0x0022, B:5:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0054  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            android.view.View r3 = r0.mBehaviorTouchView
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L15
            boolean r3 = r0.performIntercept(r1, r4)
            if (r3 == 0) goto L2b
            goto L16
        L15:
            r3 = r5
        L16:
            android.view.View r6 = r0.mBehaviorTouchView
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$COUIBaseListPopupWindow_8 r6 = (androidx.coordinatorlayout.widget.CoordinatorLayout.C0411e) r6
            androidx.coordinatorlayout.widget.CoordinatorLayout$IntrinsicsJvm.kt_4 r6 = r6.m2225b()
            if (r6 == 0) goto L2b
            android.view.View r7 = r0.mBehaviorTouchView
            boolean r6 = r6.onTouchEvent(r0, r7, r1)
            goto L2c
        L2b:
            r6 = r5
        L2c:
            android.view.View r7 = r0.mBehaviorTouchView
            r8 = 0
            if (r7 != 0) goto L37
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L4a
        L37:
            if (r3 == 0) goto L4a
            long r11 = android.os.SystemClock.uptimeMillis()
            r13 = 3
            r14 = 0
            r15 = 0
            r16 = 0
            r9 = r11
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L4a:
            if (r8 == 0) goto L4f
            r8.recycle()
        L4f:
            if (r2 == r4) goto L54
            r1 = 3
            if (r2 != r1) goto L57
        L54:
            r0.resetTouchBehaviors(r5)
        L57:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (!z || this.mDisallowInterceptReset) {
            return;
        }
        resetTouchBehaviors(false);
        this.mDisallowInterceptReset = true;
    }

    private int getKeyline(int OplusGLSurfaceView_13) {
        int[] iArr = this.mKeylines;
        if (iArr == null) {
            Log.COUIBaseListPopupWindow_8(TAG, "No keylines defined for " + this + " - attempted index lookup " + OplusGLSurfaceView_13);
            return 0;
        }
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 >= iArr.length) {
            Log.COUIBaseListPopupWindow_8(TAG, "Keyline index " + OplusGLSurfaceView_13 + " out of range for " + this);
            return 0;
        }
        return iArr[OplusGLSurfaceView_13];
    }

    /* JADX WARN: Multi-variable type inference failed */
    static AbstractC0408b parseBehavior(Context context, AttributeSet attributeSet, String str) throws NoSuchMethodException, SecurityException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(WIDGET_PACKAGE_NAME)) {
            str = WIDGET_PACKAGE_NAME + '.' + str;
        }
        try {
            Map<String, Constructor<AbstractC0408b>> map = sConstructors.get();
            if (map == null) {
                map = new HashMap<>();
                sConstructors.set(map);
            }
            Constructor<AbstractC0408b> constructor = map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, false, context.getClassLoader()).getConstructor(CONSTRUCTOR_PARAMS);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return constructor.newInstance(context, attributeSet);
        } catch (Exception COUIBaseListPopupWindow_8) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, COUIBaseListPopupWindow_8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    C0411e getResolvedLayoutParams(View view) {
        C0411e c0411e = (C0411e) view.getLayoutParams();
        if (!c0411e.f2662b) {
            if (view instanceof InterfaceC0407a) {
                AbstractC0408b behavior = ((InterfaceC0407a) view).getBehavior();
                if (behavior == null) {
                    Log.COUIBaseListPopupWindow_8(TAG, "Attached behavior class is null");
                }
                c0411e.m2220a(behavior);
                c0411e.f2662b = true;
            } else {
                InterfaceC0409c interfaceC0409c = null;
                for (Class<?> superclass = view.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                    interfaceC0409c = (InterfaceC0409c) superclass.getAnnotation(InterfaceC0409c.class);
                    if (interfaceC0409c != null) {
                        break;
                    }
                }
                if (interfaceC0409c != null) {
                    try {
                        c0411e.m2220a(interfaceC0409c.m2212a().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception COUIBaseListPopupWindow_8) {
                        Log.COUIBaseListPopupWindow_8(TAG, "Default behavior class " + interfaceC0409c.m2212a().getName() + " could not be instantiated. Did you forget PlatformImplementations.kt_3 default constructor?", COUIBaseListPopupWindow_8);
                    }
                }
                c0411e.f2662b = true;
            }
        }
        return c0411e;
    }

    private void prepareChildren() {
        this.mDependencySortedChildren.clear();
        this.mChildDag.m2237a();
        int childCount = getChildCount();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            View childAt = getChildAt(OplusGLSurfaceView_13);
            C0411e resolvedLayoutParams = getResolvedLayoutParams(childAt);
            resolvedLayoutParams.m2224b(this, childAt);
            this.mChildDag.m2238a((DirectedAcyclicGraph<View>) childAt);
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i2 != OplusGLSurfaceView_13) {
                    View childAt2 = getChildAt(i2);
                    if (resolvedLayoutParams.m2223a(this, childAt, childAt2)) {
                        if (!this.mChildDag.m2241b(childAt2)) {
                            this.mChildDag.m2238a((DirectedAcyclicGraph<View>) childAt2);
                        }
                        this.mChildDag.m2239a(childAt2, childAt);
                    }
                }
            }
        }
        this.mDependencySortedChildren.addAll(this.mChildDag.m2240b());
        Collections.reverse(this.mDependencySortedChildren);
    }

    void getDescendantRect(View view, Rect rect) {
        ViewGroupUtils_2.m2247b(this, view, rect);
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    public void onMeasureChild(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        measureChildWithMargins(view, OplusGLSurfaceView_13, i2, i3, i4);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x011c  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r31, int r32) {
        /*
            Method dump skipped, instructions count: 390
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    private WindowInsetsCompat dispatchApplyWindowInsetsToBehaviors(WindowInsetsCompat c0490ad) {
        AbstractC0408b abstractC0408bM2225b;
        if (c0490ad.m2765f()) {
            return c0490ad;
        }
        int childCount = getChildCount();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            View childAt = getChildAt(OplusGLSurfaceView_13);
            if (ViewCompat.m2901t(childAt) && (abstractC0408bM2225b = ((C0411e) childAt.getLayoutParams()).m2225b()) != null) {
                c0490ad = abstractC0408bM2225b.onApplyWindowInsets(this, childAt, c0490ad);
                if (c0490ad.m2765f()) {
                    break;
                }
            }
        }
        return c0490ad;
    }

    public void onLayoutChild(View view, int OplusGLSurfaceView_13) {
        C0411e c0411e = (C0411e) view.getLayoutParams();
        if (c0411e.m2228d()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        if (c0411e.f2671k != null) {
            layoutChildWithAnchor(view, c0411e.f2671k, OplusGLSurfaceView_13);
        } else if (c0411e.f2665e >= 0) {
            layoutChildWithKeyline(view, c0411e.f2665e, OplusGLSurfaceView_13);
        } else {
            layoutChild(view, OplusGLSurfaceView_13);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        AbstractC0408b abstractC0408bM2225b;
        int iM2885g = ViewCompat.m2885g(this);
        int size = this.mDependencySortedChildren.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = this.mDependencySortedChildren.get(i5);
            if (view.getVisibility() != 8 && ((abstractC0408bM2225b = ((C0411e) view.getLayoutParams()).m2225b()) == null || !abstractC0408bM2225b.onLayoutChild(this, view, iM2885g))) {
                onLayoutChild(view, iM2885g);
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.mDrawStatusBarBackground || this.mStatusBarBackground == null) {
            return;
        }
        WindowInsetsCompat c0490ad = this.mLastInsets;
        int iM2761b = c0490ad != null ? c0490ad.m2761b() : 0;
        if (iM2761b > 0) {
            this.mStatusBarBackground.setBounds(0, 0, getWidth(), iM2761b);
            this.mStatusBarBackground.draw(canvas);
        }
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        setupForInsets();
    }

    void recordLastChildRect(View view, Rect rect) {
        ((C0411e) view.getLayoutParams()).m2219a(rect);
    }

    void getLastChildRect(View view, Rect rect) {
        rect.set(((C0411e) view.getLayoutParams()).m2227c());
    }

    void getChildRect(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z) {
            getDescendantRect(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    private void getDesiredAnchoredChildRectWithoutConstraints(View view, int OplusGLSurfaceView_13, Rect rect, Rect rect2, C0411e c0411e, int i2, int i3) {
        int iWidth;
        int iHeight;
        int iM2773a = GravityCompat.m2773a(resolveAnchoredChildGravity(c0411e.f2663c), OplusGLSurfaceView_13);
        int iM2773a2 = GravityCompat.m2773a(resolveGravity(c0411e.f2664d), OplusGLSurfaceView_13);
        int i4 = iM2773a & 7;
        int i5 = iM2773a & 112;
        int i6 = iM2773a2 & 7;
        int i7 = iM2773a2 & 112;
        if (i6 == 1) {
            iWidth = rect.left + (rect.width() / 2);
        } else if (i6 != 5) {
            iWidth = rect.left;
        } else {
            iWidth = rect.right;
        }
        if (i7 == 16) {
            iHeight = rect.top + (rect.height() / 2);
        } else if (i7 != 80) {
            iHeight = rect.top;
        } else {
            iHeight = rect.bottom;
        }
        if (i4 == 1) {
            iWidth -= i2 / 2;
        } else if (i4 != 5) {
            iWidth -= i2;
        }
        if (i5 == 16) {
            iHeight -= i3 / 2;
        } else if (i5 != 80) {
            iHeight -= i3;
        }
        rect2.set(iWidth, iHeight, i2 + iWidth, i3 + iHeight);
    }

    private void constrainChildRect(C0411e c0411e, Rect rect, int OplusGLSurfaceView_13, int i2) {
        int width = getWidth();
        int height = getHeight();
        int iMax = Math.max(getPaddingLeft() + c0411e.leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - OplusGLSurfaceView_13) - c0411e.rightMargin));
        int iMax2 = Math.max(getPaddingTop() + c0411e.topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i2) - c0411e.bottomMargin));
        rect.set(iMax, iMax2, OplusGLSurfaceView_13 + iMax, i2 + iMax2);
    }

    void getDesiredAnchoredChildRect(View view, int OplusGLSurfaceView_13, Rect rect, Rect rect2) {
        C0411e c0411e = (C0411e) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        getDesiredAnchoredChildRectWithoutConstraints(view, OplusGLSurfaceView_13, rect, rect2, c0411e, measuredWidth, measuredHeight);
        constrainChildRect(c0411e, rect2, measuredWidth, measuredHeight);
    }

    private void layoutChildWithAnchor(View view, View view2, int OplusGLSurfaceView_13) {
        Rect rectAcquireTempRect = acquireTempRect();
        Rect rectAcquireTempRect2 = acquireTempRect();
        try {
            getDescendantRect(view2, rectAcquireTempRect);
            getDesiredAnchoredChildRect(view, OplusGLSurfaceView_13, rectAcquireTempRect, rectAcquireTempRect2);
            view.layout(rectAcquireTempRect2.left, rectAcquireTempRect2.top, rectAcquireTempRect2.right, rectAcquireTempRect2.bottom);
        } finally {
            releaseTempRect(rectAcquireTempRect);
            releaseTempRect(rectAcquireTempRect2);
        }
    }

    private void layoutChildWithKeyline(View view, int OplusGLSurfaceView_13, int i2) {
        C0411e c0411e = (C0411e) view.getLayoutParams();
        int iM2773a = GravityCompat.m2773a(resolveKeylineGravity(c0411e.f2663c), i2);
        int i3 = iM2773a & 7;
        int i4 = iM2773a & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i2 == 1) {
            OplusGLSurfaceView_13 = width - OplusGLSurfaceView_13;
        }
        int keyline = getKeyline(OplusGLSurfaceView_13) - measuredWidth;
        int i5 = 0;
        if (i3 == 1) {
            keyline += measuredWidth / 2;
        } else if (i3 == 5) {
            keyline += measuredWidth;
        }
        if (i4 == 16) {
            i5 = 0 + (measuredHeight / 2);
        } else if (i4 == 80) {
            i5 = measuredHeight + 0;
        }
        int iMax = Math.max(getPaddingLeft() + c0411e.leftMargin, Math.min(keyline, ((width - getPaddingRight()) - measuredWidth) - c0411e.rightMargin));
        int iMax2 = Math.max(getPaddingTop() + c0411e.topMargin, Math.min(i5, ((height - getPaddingBottom()) - measuredHeight) - c0411e.bottomMargin));
        view.layout(iMax, iMax2, measuredWidth + iMax, measuredHeight + iMax2);
    }

    private void layoutChild(View view, int OplusGLSurfaceView_13) {
        C0411e c0411e = (C0411e) view.getLayoutParams();
        Rect rectAcquireTempRect = acquireTempRect();
        rectAcquireTempRect.set(getPaddingLeft() + c0411e.leftMargin, getPaddingTop() + c0411e.topMargin, (getWidth() - getPaddingRight()) - c0411e.rightMargin, (getHeight() - getPaddingBottom()) - c0411e.bottomMargin);
        if (this.mLastInsets != null && ViewCompat.m2901t(this) && !ViewCompat.m2901t(view)) {
            rectAcquireTempRect.left += this.mLastInsets.m2759a();
            rectAcquireTempRect.top += this.mLastInsets.m2761b();
            rectAcquireTempRect.right -= this.mLastInsets.m2762c();
            rectAcquireTempRect.bottom -= this.mLastInsets.m2763d();
        }
        Rect rectAcquireTempRect2 = acquireTempRect();
        GravityCompat.m2774a(resolveGravity(c0411e.f2663c), view.getMeasuredWidth(), view.getMeasuredHeight(), rectAcquireTempRect, rectAcquireTempRect2, OplusGLSurfaceView_13);
        view.layout(rectAcquireTempRect2.left, rectAcquireTempRect2.top, rectAcquireTempRect2.right, rectAcquireTempRect2.bottom);
        releaseTempRect(rectAcquireTempRect);
        releaseTempRect(rectAcquireTempRect2);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long OplusGLSurfaceView_15) {
        C0411e c0411e = (C0411e) view.getLayoutParams();
        if (c0411e.f2661a != null) {
            float scrimOpacity = c0411e.f2661a.getScrimOpacity(this, view);
            if (scrimOpacity > 0.0f) {
                if (this.mScrimPaint == null) {
                    this.mScrimPaint = new Paint();
                }
                this.mScrimPaint.setColor(c0411e.f2661a.getScrimColor(this, view));
                this.mScrimPaint.setAlpha(clamp(Math.round(scrimOpacity * 255.0f), 0, 255));
                int iSave = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.mScrimPaint);
                canvas.restoreToCount(iSave);
            }
        }
        return super.drawChild(canvas, view, OplusGLSurfaceView_15);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final void onChildViewsChanged(int r18) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onChildViewsChanged(int):void");
    }

    private void offsetChildByInset(View view, Rect rect, int OplusGLSurfaceView_13) {
        boolean z;
        boolean z2;
        int width;
        int i2;
        int height;
        int i3;
        if (ViewCompat.m2823A(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            C0411e c0411e = (C0411e) view.getLayoutParams();
            AbstractC0408b abstractC0408bM2225b = c0411e.m2225b();
            Rect rectAcquireTempRect = acquireTempRect();
            Rect rectAcquireTempRect2 = acquireTempRect();
            rectAcquireTempRect2.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (abstractC0408bM2225b != null && abstractC0408bM2225b.getInsetDodgeRect(this, view, rectAcquireTempRect)) {
                if (!rectAcquireTempRect2.contains(rectAcquireTempRect)) {
                    throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + rectAcquireTempRect.toShortString() + " | Bounds:" + rectAcquireTempRect2.toShortString());
                }
            } else {
                rectAcquireTempRect.set(rectAcquireTempRect2);
            }
            releaseTempRect(rectAcquireTempRect2);
            if (rectAcquireTempRect.isEmpty()) {
                releaseTempRect(rectAcquireTempRect);
                return;
            }
            int iM2773a = GravityCompat.m2773a(c0411e.f2668h, OplusGLSurfaceView_13);
            if ((iM2773a & 48) != 48 || (i3 = (rectAcquireTempRect.top - c0411e.topMargin) - c0411e.f2670j) >= rect.top) {
                z = false;
            } else {
                setInsetOffsetY(view, rect.top - i3);
                z = true;
            }
            if ((iM2773a & 80) == 80 && (height = ((getHeight() - rectAcquireTempRect.bottom) - c0411e.bottomMargin) + c0411e.f2670j) < rect.bottom) {
                setInsetOffsetY(view, height - rect.bottom);
                z = true;
            }
            if (!z) {
                setInsetOffsetY(view, 0);
            }
            if ((iM2773a & 3) != 3 || (i2 = (rectAcquireTempRect.left - c0411e.leftMargin) - c0411e.f2669i) >= rect.left) {
                z2 = false;
            } else {
                setInsetOffsetX(view, rect.left - i2);
                z2 = true;
            }
            if ((iM2773a & 5) == 5 && (width = ((getWidth() - rectAcquireTempRect.right) - c0411e.rightMargin) + c0411e.f2669i) < rect.right) {
                setInsetOffsetX(view, width - rect.right);
                z2 = true;
            }
            if (!z2) {
                setInsetOffsetX(view, 0);
            }
            releaseTempRect(rectAcquireTempRect);
        }
    }

    private void setInsetOffsetX(View view, int OplusGLSurfaceView_13) {
        C0411e c0411e = (C0411e) view.getLayoutParams();
        if (c0411e.f2669i != OplusGLSurfaceView_13) {
            ViewCompat.m2884f(view, OplusGLSurfaceView_13 - c0411e.f2669i);
            c0411e.f2669i = OplusGLSurfaceView_13;
        }
    }

    private void setInsetOffsetY(View view, int OplusGLSurfaceView_13) {
        C0411e c0411e = (C0411e) view.getLayoutParams();
        if (c0411e.f2670j != OplusGLSurfaceView_13) {
            ViewCompat.m2882e(view, OplusGLSurfaceView_13 - c0411e.f2670j);
            c0411e.f2670j = OplusGLSurfaceView_13;
        }
    }

    public void dispatchDependentViewsChanged(View view) {
        List listM2242c = this.mChildDag.m2242c(view);
        if (listM2242c == null || listM2242c.isEmpty()) {
            return;
        }
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < listM2242c.size(); OplusGLSurfaceView_13++) {
            View view2 = (View) listM2242c.get(OplusGLSurfaceView_13);
            AbstractC0408b abstractC0408bM2225b = ((C0411e) view2.getLayoutParams()).m2225b();
            if (abstractC0408bM2225b != null) {
                abstractC0408bM2225b.onDependentViewChanged(this, view2, view);
            }
        }
    }

    public List<View> getDependencies(View view) {
        List<View> listM2243d = this.mChildDag.m2243d(view);
        this.mTempDependenciesList.clear();
        if (listM2243d != null) {
            this.mTempDependenciesList.addAll(listM2243d);
        }
        return this.mTempDependenciesList;
    }

    public List<View> getDependents(View view) {
        List listM2242c = this.mChildDag.m2242c(view);
        this.mTempDependenciesList.clear();
        if (listM2242c != null) {
            this.mTempDependenciesList.addAll(listM2242c);
        }
        return this.mTempDependenciesList;
    }

    final List<View> getDependencySortedChildren() {
        prepareChildren();
        return Collections.unmodifiableList(this.mDependencySortedChildren);
    }

    void ensurePreDrawListener() {
        int childCount = getChildCount();
        boolean z = false;
        int OplusGLSurfaceView_13 = 0;
        while (true) {
            if (OplusGLSurfaceView_13 >= childCount) {
                break;
            }
            if (hasDependencies(getChildAt(OplusGLSurfaceView_13))) {
                z = true;
                break;
            }
            OplusGLSurfaceView_13++;
        }
        if (z != this.mNeedsPreDrawListener) {
            if (z) {
                addPreDrawListener();
            } else {
                removePreDrawListener();
            }
        }
    }

    private boolean hasDependencies(View view) {
        return this.mChildDag.m2244e(view);
    }

    void addPreDrawListener() {
        if (this.mIsAttachedToWindow) {
            if (this.mOnPreDrawListener == null) {
                this.mOnPreDrawListener = new ViewTreeObserverOnPreDrawListenerC0412f();
            }
            getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        }
        this.mNeedsPreDrawListener = true;
    }

    void removePreDrawListener() {
        if (this.mIsAttachedToWindow && this.mOnPreDrawListener != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        }
        this.mNeedsPreDrawListener = false;
    }

    void offsetChildToAnchor(View view, int OplusGLSurfaceView_13) {
        AbstractC0408b abstractC0408bM2225b;
        C0411e c0411e = (C0411e) view.getLayoutParams();
        if (c0411e.f2671k != null) {
            Rect rectAcquireTempRect = acquireTempRect();
            Rect rectAcquireTempRect2 = acquireTempRect();
            Rect rectAcquireTempRect3 = acquireTempRect();
            getDescendantRect(c0411e.f2671k, rectAcquireTempRect);
            getChildRect(view, false, rectAcquireTempRect2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            getDesiredAnchoredChildRectWithoutConstraints(view, OplusGLSurfaceView_13, rectAcquireTempRect, rectAcquireTempRect3, c0411e, measuredWidth, measuredHeight);
            boolean z = (rectAcquireTempRect3.left == rectAcquireTempRect2.left && rectAcquireTempRect3.top == rectAcquireTempRect2.top) ? false : true;
            constrainChildRect(c0411e, rectAcquireTempRect3, measuredWidth, measuredHeight);
            int i2 = rectAcquireTempRect3.left - rectAcquireTempRect2.left;
            int i3 = rectAcquireTempRect3.top - rectAcquireTempRect2.top;
            if (i2 != 0) {
                ViewCompat.m2884f(view, i2);
            }
            if (i3 != 0) {
                ViewCompat.m2882e(view, i3);
            }
            if (z && (abstractC0408bM2225b = c0411e.m2225b()) != null) {
                abstractC0408bM2225b.onDependentViewChanged(this, view, c0411e.f2671k);
            }
            releaseTempRect(rectAcquireTempRect);
            releaseTempRect(rectAcquireTempRect2);
            releaseTempRect(rectAcquireTempRect3);
        }
    }

    public boolean isPointInChildBounds(View view, int OplusGLSurfaceView_13, int i2) {
        Rect rectAcquireTempRect = acquireTempRect();
        getDescendantRect(view, rectAcquireTempRect);
        try {
            return rectAcquireTempRect.contains(OplusGLSurfaceView_13, i2);
        } finally {
            releaseTempRect(rectAcquireTempRect);
        }
    }

    public boolean doViewsOverlap(View view, View view2) {
        boolean z = false;
        if (view.getVisibility() != 0 || view2.getVisibility() != 0) {
            return false;
        }
        Rect rectAcquireTempRect = acquireTempRect();
        getChildRect(view, view.getParent() != this, rectAcquireTempRect);
        Rect rectAcquireTempRect2 = acquireTempRect();
        getChildRect(view2, view2.getParent() != this, rectAcquireTempRect2);
        try {
            if (rectAcquireTempRect.left <= rectAcquireTempRect2.right && rectAcquireTempRect.top <= rectAcquireTempRect2.bottom && rectAcquireTempRect.right >= rectAcquireTempRect2.left) {
                if (rectAcquireTempRect.bottom >= rectAcquireTempRect2.top) {
                    z = true;
                }
            }
            return z;
        } finally {
            releaseTempRect(rectAcquireTempRect);
            releaseTempRect(rectAcquireTempRect2);
        }
    }

    @Override // android.view.ViewGroup
    public C0411e generateLayoutParams(AttributeSet attributeSet) {
        return new C0411e(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public C0411e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof C0411e) {
            return new C0411e((C0411e) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new C0411e((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new C0411e(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public C0411e generateDefaultLayoutParams() {
        return new C0411e(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof C0411e) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.p036h.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int OplusGLSurfaceView_13) {
        return onStartNestedScroll(view, view2, OplusGLSurfaceView_13, 0);
    }

    @Override // androidx.core.p036h.NestedScrollingParent2
    public boolean onStartNestedScroll(View view, View view2, int OplusGLSurfaceView_13, int i2) {
        int childCount = getChildCount();
        boolean z = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                C0411e c0411e = (C0411e) childAt.getLayoutParams();
                AbstractC0408b abstractC0408bM2225b = c0411e.m2225b();
                if (abstractC0408bM2225b != null) {
                    boolean zOnStartNestedScroll = abstractC0408bM2225b.onStartNestedScroll(this, childAt, view, view2, OplusGLSurfaceView_13, i2);
                    c0411e.m2218a(i2, zOnStartNestedScroll);
                    z |= zOnStartNestedScroll;
                } else {
                    c0411e.m2218a(i2, false);
                }
            }
        }
        return z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.p036h.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int OplusGLSurfaceView_13) {
        onNestedScrollAccepted(view, view2, OplusGLSurfaceView_13, 0);
    }

    @Override // androidx.core.p036h.NestedScrollingParent2
    public void onNestedScrollAccepted(View view, View view2, int OplusGLSurfaceView_13, int i2) {
        AbstractC0408b abstractC0408bM2225b;
        this.mNestedScrollingParentHelper.m2818a(view, view2, OplusGLSurfaceView_13, i2);
        this.mNestedScrollingTarget = view2;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            C0411e c0411e = (C0411e) childAt.getLayoutParams();
            if (c0411e.m2226b(i2) && (abstractC0408bM2225b = c0411e.m2225b()) != null) {
                abstractC0408bM2225b.onNestedScrollAccepted(this, childAt, view, view2, OplusGLSurfaceView_13, i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.p036h.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    @Override // androidx.core.p036h.NestedScrollingParent2
    public void onStopNestedScroll(View view, int OplusGLSurfaceView_13) {
        this.mNestedScrollingParentHelper.m2816a(view, OplusGLSurfaceView_13);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            C0411e c0411e = (C0411e) childAt.getLayoutParams();
            if (c0411e.m2226b(OplusGLSurfaceView_13)) {
                AbstractC0408b abstractC0408bM2225b = c0411e.m2225b();
                if (abstractC0408bM2225b != null) {
                    abstractC0408bM2225b.onStopNestedScroll(this, childAt, view, OplusGLSurfaceView_13);
                }
                c0411e.m2217a(OplusGLSurfaceView_13);
                c0411e.m2232h();
            }
        }
        this.mNestedScrollingTarget = null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.p036h.NestedScrollingParent
    public void onNestedScroll(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        onNestedScroll(view, OplusGLSurfaceView_13, i2, i3, i4, 0);
    }

    @Override // androidx.core.p036h.NestedScrollingParent2
    public void onNestedScroll(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5) {
        onNestedScroll(view, OplusGLSurfaceView_13, i2, i3, i4, 0, this.mNestedScrollingV2ConsumedCompat);
    }

    @Override // androidx.core.p036h.NestedScrollingParent3
    public void onNestedScroll(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int[] iArr) {
        AbstractC0408b abstractC0408bM2225b;
        int iMin;
        boolean z;
        int iMin2;
        int childCount = getChildCount();
        boolean z2 = false;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                C0411e c0411e = (C0411e) childAt.getLayoutParams();
                if (c0411e.m2226b(i5) && (abstractC0408bM2225b = c0411e.m2225b()) != null) {
                    int[] iArr2 = this.mBehaviorConsumed;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    abstractC0408bM2225b.onNestedScroll(this, childAt, view, OplusGLSurfaceView_13, i2, i3, i4, i5, iArr2);
                    if (i3 > 0) {
                        iMin = Math.max(i6, this.mBehaviorConsumed[0]);
                    } else {
                        iMin = Math.min(i6, this.mBehaviorConsumed[0]);
                    }
                    if (i4 > 0) {
                        z = true;
                        iMin2 = Math.max(i7, this.mBehaviorConsumed[1]);
                    } else {
                        z = true;
                        iMin2 = Math.min(i7, this.mBehaviorConsumed[1]);
                    }
                    i6 = iMin;
                    i7 = iMin2;
                    z2 = z;
                }
            }
        }
        iArr[0] = iArr[0] + i6;
        iArr[1] = iArr[1] + i7;
        if (z2) {
            onChildViewsChanged(1);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.p036h.NestedScrollingParent
    public void onNestedPreScroll(View view, int OplusGLSurfaceView_13, int i2, int[] iArr) {
        onNestedPreScroll(view, OplusGLSurfaceView_13, i2, iArr, 0);
    }

    @Override // androidx.core.p036h.NestedScrollingParent2
    public void onNestedPreScroll(View view, int OplusGLSurfaceView_13, int i2, int[] iArr, int i3) {
        AbstractC0408b abstractC0408bM2225b;
        int iMin;
        int iMin2;
        int childCount = getChildCount();
        boolean z = false;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                C0411e c0411e = (C0411e) childAt.getLayoutParams();
                if (c0411e.m2226b(i3) && (abstractC0408bM2225b = c0411e.m2225b()) != null) {
                    int[] iArr2 = this.mBehaviorConsumed;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    abstractC0408bM2225b.onNestedPreScroll(this, childAt, view, OplusGLSurfaceView_13, i2, iArr2, i3);
                    if (OplusGLSurfaceView_13 > 0) {
                        iMin = Math.max(i4, this.mBehaviorConsumed[0]);
                    } else {
                        iMin = Math.min(i4, this.mBehaviorConsumed[0]);
                    }
                    if (i2 > 0) {
                        iMin2 = Math.max(i5, this.mBehaviorConsumed[1]);
                    } else {
                        iMin2 = Math.min(i5, this.mBehaviorConsumed[1]);
                    }
                    i4 = iMin;
                    i5 = iMin2;
                    z = true;
                }
            }
        }
        iArr[0] = i4;
        iArr[1] = i5;
        if (z) {
            onChildViewsChanged(1);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.p036h.NestedScrollingParent
    public boolean onNestedFling(View view, float COUIBaseListPopupWindow_12, float f2, boolean z) {
        AbstractC0408b abstractC0408bM2225b;
        int childCount = getChildCount();
        boolean zOnNestedFling = false;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            View childAt = getChildAt(OplusGLSurfaceView_13);
            if (childAt.getVisibility() != 8) {
                C0411e c0411e = (C0411e) childAt.getLayoutParams();
                if (c0411e.m2226b(0) && (abstractC0408bM2225b = c0411e.m2225b()) != null) {
                    zOnNestedFling |= abstractC0408bM2225b.onNestedFling(this, childAt, view, COUIBaseListPopupWindow_12, f2, z);
                }
            }
        }
        if (zOnNestedFling) {
            onChildViewsChanged(1);
        }
        return zOnNestedFling;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.p036h.NestedScrollingParent
    public boolean onNestedPreFling(View view, float COUIBaseListPopupWindow_12, float f2) {
        AbstractC0408b abstractC0408bM2225b;
        int childCount = getChildCount();
        boolean zOnNestedPreFling = false;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            View childAt = getChildAt(OplusGLSurfaceView_13);
            if (childAt.getVisibility() != 8) {
                C0411e c0411e = (C0411e) childAt.getLayoutParams();
                if (c0411e.m2226b(0) && (abstractC0408bM2225b = c0411e.m2225b()) != null) {
                    zOnNestedPreFling |= abstractC0408bM2225b.onNestedPreFling(this, childAt, view, COUIBaseListPopupWindow_12, f2);
                }
            }
        }
        return zOnNestedPreFling;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.m2815a();
    }

    /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$COUIBaseListPopupWindow_12 */
    class ViewTreeObserverOnPreDrawListenerC0412f implements ViewTreeObserver.OnPreDrawListener {
        ViewTreeObserverOnPreDrawListenerC0412f() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CoordinatorLayout.this.onChildViewsChanged(0);
            return true;
        }
    }

    /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$COUIBaseListPopupWindow_11 */
    static class C0413g implements Comparator<View> {
        C0413g() {
        }

        @Override // java.util.Comparator
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            float fM2824B = ViewCompat.m2824B(view);
            float fM2824B2 = ViewCompat.m2824B(view2);
            if (fM2824B > fM2824B2) {
                return -1;
            }
            return fM2824B < fM2824B2 ? 1 : 0;
        }
    }

    /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$IntrinsicsJvm.kt_4 */
    public static abstract class AbstractC0408b<V extends View> {
        public boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, V v, Rect rect) {
            return false;
        }

        public int getScrimColor(CoordinatorLayout coordinatorLayout, V v) {
            return -16777216;
        }

        public float getScrimOpacity(CoordinatorLayout coordinatorLayout, V v) {
            return 0.0f;
        }

        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public WindowInsetsCompat onApplyWindowInsets(CoordinatorLayout coordinatorLayout, V v, WindowInsetsCompat c0490ad) {
            return c0490ad;
        }

        public void onAttachedToLayoutParams(C0411e c0411e) {
        }

        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public void onDependentViewRemoved(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public void onDetachedFromLayoutParams() {
        }

        public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int OplusGLSurfaceView_13) {
            return false;
        }

        public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, V v, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
            return false;
        }

        public boolean onNestedFling(CoordinatorLayout coordinatorLayout, V v, View view, float COUIBaseListPopupWindow_12, float f2, boolean z) {
            return false;
        }

        public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v, View view, float COUIBaseListPopupWindow_12, float f2) {
            return false;
        }

        @Deprecated
        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int OplusGLSurfaceView_13, int i2, int[] iArr) {
        }

        @Deprecated
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        }

        @Deprecated
        public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int OplusGLSurfaceView_13) {
        }

        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, V v, Rect rect, boolean z) {
            return false;
        }

        public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        @Deprecated
        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int OplusGLSurfaceView_13) {
            return false;
        }

        @Deprecated
        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public AbstractC0408b() {
        }

        public AbstractC0408b(Context context, AttributeSet attributeSet) {
        }

        public boolean blocksInteractionBelow(CoordinatorLayout coordinatorLayout, V v) {
            return getScrimOpacity(coordinatorLayout, v) > 0.0f;
        }

        public static void setTag(View view, Object obj) {
            ((C0411e) view.getLayoutParams()).f2674n = obj;
        }

        public static Object getTag(View view) {
            return ((C0411e) view.getLayoutParams()).f2674n;
        }

        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int OplusGLSurfaceView_13, int i2) {
            if (i2 == 0) {
                return onStartNestedScroll(coordinatorLayout, v, view, view2, OplusGLSurfaceView_13);
            }
            return false;
        }

        public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int OplusGLSurfaceView_13, int i2) {
            if (i2 == 0) {
                onNestedScrollAccepted(coordinatorLayout, v, view, view2, OplusGLSurfaceView_13);
            }
        }

        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 == 0) {
                onStopNestedScroll(coordinatorLayout, v, view);
            }
        }

        @Deprecated
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5) {
            if (i5 == 0) {
                onNestedScroll(coordinatorLayout, v, view, OplusGLSurfaceView_13, i2, i3, i4);
            }
        }

        public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int[] iArr) {
            iArr[0] = iArr[0] + i3;
            iArr[1] = iArr[1] + i4;
            onNestedScroll(coordinatorLayout, v, view, OplusGLSurfaceView_13, i2, i3, i4, i5);
        }

        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int OplusGLSurfaceView_13, int i2, int[] iArr, int i3) {
            if (i3 == 0) {
                onNestedPreScroll(coordinatorLayout, v, view, OplusGLSurfaceView_13, i2, iArr);
            }
        }

        public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v) {
            return View.BaseSavedState.EMPTY_STATE;
        }
    }

    /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$COUIBaseListPopupWindow_8 */
    public static class C0411e extends ViewGroup.MarginLayoutParams {

        /* renamed from: PlatformImplementations.kt_3 */
        AbstractC0408b f2661a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        boolean f2662b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public int f2663c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        public int f2664d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        public int f2665e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        int f2666f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        public int f2667g;

        /* renamed from: COUIBaseListPopupWindow_10 */
        public int f2668h;

        /* renamed from: OplusGLSurfaceView_13 */
        int f2669i;

        /* renamed from: OplusGLSurfaceView_15 */
        int f2670j;

        /* renamed from: OplusGLSurfaceView_5 */
        View f2671k;

        /* renamed from: OplusGLSurfaceView_14 */
        View f2672l;

        /* renamed from: OplusGLSurfaceView_6 */
        final Rect f2673m;

        /* renamed from: OplusGLSurfaceView_11 */
        Object f2674n;

        /* renamed from: o */
        private boolean f2675o;

        /* renamed from: p */
        private boolean f2676p;

        /* renamed from: q */
        private boolean f2677q;

        /* renamed from: r */
        private boolean f2678r;

        public C0411e(int OplusGLSurfaceView_13, int i2) {
            super(OplusGLSurfaceView_13, i2);
            this.f2662b = false;
            this.f2663c = 0;
            this.f2664d = 0;
            this.f2665e = -1;
            this.f2666f = -1;
            this.f2667g = 0;
            this.f2668h = 0;
            this.f2673m = new Rect();
        }

        C0411e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2662b = false;
            this.f2663c = 0;
            this.f2664d = 0;
            this.f2665e = -1;
            this.f2666f = -1;
            this.f2667g = 0;
            this.f2668h = 0;
            this.f2673m = new Rect();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout_Layout);
            this.f2663c = typedArrayObtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f2666f = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CoordinatorLayout_Layout_layout_anchor, -1);
            this.f2664d = typedArrayObtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.f2665e = typedArrayObtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_layout_keyline, -1);
            this.f2667g = typedArrayObtainStyledAttributes.getInt(R.styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.f2668h = typedArrayObtainStyledAttributes.getInt(R.styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            this.f2662b = typedArrayObtainStyledAttributes.hasValue(R.styleable.CoordinatorLayout_Layout_layout_behavior);
            if (this.f2662b) {
                this.f2661a = CoordinatorLayout.parseBehavior(context, attributeSet, typedArrayObtainStyledAttributes.getString(R.styleable.CoordinatorLayout_Layout_layout_behavior));
            }
            typedArrayObtainStyledAttributes.recycle();
            AbstractC0408b abstractC0408b = this.f2661a;
            if (abstractC0408b != null) {
                abstractC0408b.onAttachedToLayoutParams(this);
            }
        }

        public C0411e(C0411e c0411e) {
            super((ViewGroup.MarginLayoutParams) c0411e);
            this.f2662b = false;
            this.f2663c = 0;
            this.f2664d = 0;
            this.f2665e = -1;
            this.f2666f = -1;
            this.f2667g = 0;
            this.f2668h = 0;
            this.f2673m = new Rect();
        }

        public C0411e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f2662b = false;
            this.f2663c = 0;
            this.f2664d = 0;
            this.f2665e = -1;
            this.f2666f = -1;
            this.f2667g = 0;
            this.f2668h = 0;
            this.f2673m = new Rect();
        }

        public C0411e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2662b = false;
            this.f2663c = 0;
            this.f2664d = 0;
            this.f2665e = -1;
            this.f2666f = -1;
            this.f2667g = 0;
            this.f2668h = 0;
            this.f2673m = new Rect();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public int m2216a() {
            return this.f2666f;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public AbstractC0408b m2225b() {
            return this.f2661a;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m2220a(AbstractC0408b abstractC0408b) {
            AbstractC0408b abstractC0408b2 = this.f2661a;
            if (abstractC0408b2 != abstractC0408b) {
                if (abstractC0408b2 != null) {
                    abstractC0408b2.onDetachedFromLayoutParams();
                }
                this.f2661a = abstractC0408b;
                this.f2674n = null;
                this.f2662b = true;
                if (abstractC0408b != null) {
                    abstractC0408b.onAttachedToLayoutParams(this);
                }
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m2219a(Rect rect) {
            this.f2673m.set(rect);
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        Rect m2227c() {
            return this.f2673m;
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        boolean m2228d() {
            return this.f2671k == null && this.f2666f != -1;
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        boolean m2229e() {
            if (this.f2661a == null) {
                this.f2675o = false;
            }
            return this.f2675o;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        boolean m2222a(CoordinatorLayout coordinatorLayout, View view) {
            boolean z = this.f2675o;
            if (z) {
                return true;
            }
            AbstractC0408b abstractC0408b = this.f2661a;
            boolean zBlocksInteractionBelow = (abstractC0408b != null ? abstractC0408b.blocksInteractionBelow(coordinatorLayout, view) : false) | z;
            this.f2675o = zBlocksInteractionBelow;
            return zBlocksInteractionBelow;
        }

        /* renamed from: COUIBaseListPopupWindow_12 */
        void m2230f() {
            this.f2675o = false;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m2217a(int OplusGLSurfaceView_13) {
            m2218a(OplusGLSurfaceView_13, false);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m2218a(int OplusGLSurfaceView_13, boolean z) {
            if (OplusGLSurfaceView_13 == 0) {
                this.f2676p = z;
            } else {
                if (OplusGLSurfaceView_13 != 1) {
                    return;
                }
                this.f2677q = z;
            }
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        boolean m2226b(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 == 0) {
                return this.f2676p;
            }
            if (OplusGLSurfaceView_13 != 1) {
                return false;
            }
            return this.f2677q;
        }

        /* renamed from: COUIBaseListPopupWindow_11 */
        boolean m2231g() {
            return this.f2678r;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m2221a(boolean z) {
            this.f2678r = z;
        }

        /* renamed from: COUIBaseListPopupWindow_10 */
        void m2232h() {
            this.f2678r = false;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        boolean m2223a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            AbstractC0408b abstractC0408b;
            return view2 == this.f2672l || m2214a(view2, ViewCompat.m2885g(coordinatorLayout)) || ((abstractC0408b = this.f2661a) != null && abstractC0408b.layoutDependsOn(coordinatorLayout, view, view2));
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        View m2224b(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f2666f == -1) {
                this.f2672l = null;
                this.f2671k = null;
                return null;
            }
            if (this.f2671k == null || !m2215b(view, coordinatorLayout)) {
                m2213a(view, coordinatorLayout);
            }
            return this.f2671k;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m2213a(View view, CoordinatorLayout coordinatorLayout) {
            this.f2671k = coordinatorLayout.findViewById(this.f2666f);
            View view2 = this.f2671k;
            if (view2 == null) {
                if (coordinatorLayout.isInEditMode()) {
                    this.f2672l = null;
                    this.f2671k = null;
                    return;
                }
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id_renamed " + coordinatorLayout.getResources().getResourceName(this.f2666f) + " to anchor view " + view);
            }
            if (view2 == coordinatorLayout) {
                if (coordinatorLayout.isInEditMode()) {
                    this.f2672l = null;
                    this.f2671k = null;
                    return;
                }
                throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
            }
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout && parent != null; parent = parent.getParent()) {
                if (parent == view) {
                    if (coordinatorLayout.isInEditMode()) {
                        this.f2672l = null;
                        this.f2671k = null;
                        return;
                    }
                    throw new IllegalStateException("Anchor must not be PlatformImplementations.kt_3 descendant of the anchored view");
                }
                if (parent instanceof View) {
                    view2 = parent;
                }
            }
            this.f2672l = view2;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        private boolean m2215b(View view, CoordinatorLayout coordinatorLayout) {
            if (this.f2671k.getId() != this.f2666f) {
                return false;
            }
            View view2 = this.f2671k;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent == null || parent == view) {
                    this.f2672l = null;
                    this.f2671k = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = parent;
                }
            }
            this.f2672l = view2;
            return true;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private boolean m2214a(View view, int OplusGLSurfaceView_13) {
            int iM2773a = GravityCompat.m2773a(((C0411e) view.getLayoutParams()).f2667g, OplusGLSurfaceView_13);
            return iM2773a != 0 && (GravityCompat.m2773a(this.f2668h, OplusGLSurfaceView_13) & iM2773a) == iM2773a;
        }
    }

    /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$IntrinsicsJvm.kt_5 */
    private class ViewGroupOnHierarchyChangeListenerC0410d implements ViewGroup.OnHierarchyChangeListener {
        ViewGroupOnHierarchyChangeListenerC0410d() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            if (CoordinatorLayout.this.mOnHierarchyChangeListener != null) {
                CoordinatorLayout.this.mOnHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.onChildViewsChanged(2);
            if (CoordinatorLayout.this.mOnHierarchyChangeListener != null) {
                CoordinatorLayout.this.mOnHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        SparseArray<Parcelable> sparseArray = savedState.behaviorStates;
        int childCount = getChildCount();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            View childAt = getChildAt(OplusGLSurfaceView_13);
            int id_renamed = childAt.getId();
            AbstractC0408b abstractC0408bM2225b = getResolvedLayoutParams(childAt).m2225b();
            if (id_renamed != -1 && abstractC0408bM2225b != null && (parcelable2 = sparseArray.get(id_renamed)) != null) {
                abstractC0408bM2225b.onRestoreInstanceState(this, childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            View childAt = getChildAt(OplusGLSurfaceView_13);
            int id_renamed = childAt.getId();
            AbstractC0408b abstractC0408bM2225b = ((C0411e) childAt.getLayoutParams()).m2225b();
            if (id_renamed != -1 && abstractC0408bM2225b != null && (parcelableOnSaveInstanceState = abstractC0408bM2225b.onSaveInstanceState(this, childAt)) != null) {
                sparseArray.append(id_renamed, parcelableOnSaveInstanceState);
            }
        }
        savedState.behaviorStates = sparseArray;
        return savedState;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        AbstractC0408b abstractC0408bM2225b = ((C0411e) view.getLayoutParams()).m2225b();
        if (abstractC0408bM2225b == null || !abstractC0408bM2225b.onRequestChildRectangleOnScreen(this, view, rect, z)) {
            return super.requestChildRectangleOnScreen(view, rect, z);
        }
        return true;
    }

    private void setupForInsets() {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (ViewCompat.m2901t(this)) {
            if (this.mApplyWindowInsetsListener == null) {
                this.mApplyWindowInsetsListener = new OnApplyWindowInsetsListener() { // from class: androidx.coordinatorlayout.widget.CoordinatorLayout.1
                    @Override // androidx.core.p036h.OnApplyWindowInsetsListener
                    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat c0490ad) {
                        return CoordinatorLayout.this.setWindowInsets(c0490ad);
                    }
                };
            }
            ViewCompat.m2855a(this, this.mApplyWindowInsetsListener);
            setSystemUiVisibility(VideoMode.VIDEO_720P_WIDTH);
            return;
        }
        ViewCompat.m2855a(this, (OnApplyWindowInsetsListener) null);
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.coordinatorlayout.widget.CoordinatorLayout.SavedState.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int OplusGLSurfaceView_13) {
                return new SavedState[OplusGLSurfaceView_13];
            }
        };
        SparseArray<Parcelable> behaviorStates;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int OplusGLSurfaceView_13 = parcel.readInt();
            int[] iArr = new int[OplusGLSurfaceView_13];
            parcel.readIntArray(iArr);
            Parcelable[] parcelableArray = parcel.readParcelableArray(classLoader);
            this.behaviorStates = new SparseArray<>(OplusGLSurfaceView_13);
            for (int i2 = 0; i2 < OplusGLSurfaceView_13; i2++) {
                this.behaviorStates.append(iArr[i2], parcelableArray[i2]);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
            super.writeToParcel(parcel, OplusGLSurfaceView_13);
            SparseArray<Parcelable> sparseArray = this.behaviorStates;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i2 = 0; i2 < size; i2++) {
                iArr[i2] = this.behaviorStates.keyAt(i2);
                parcelableArr[i2] = this.behaviorStates.valueAt(i2);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, OplusGLSurfaceView_13);
        }
    }
}
