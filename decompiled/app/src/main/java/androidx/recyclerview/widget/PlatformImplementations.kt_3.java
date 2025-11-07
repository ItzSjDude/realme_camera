package androidx.recyclerview.widget;

import android.R;
import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.p032d.TraceCompat;
import androidx.core.p035g.Preconditions;
import androidx.core.p036h.AccessibilityDelegateCompat;
import androidx.core.p036h.MotionEventCompat;
import androidx.core.p036h.NestedScrollingChildHelper;
import androidx.core.p036h.ViewCompat;
import androidx.core.p036h.ViewConfigurationCompat;
import androidx.core.p036h.InterfaceC0501j;
import androidx.core.p036h.InterfaceC0502k;
import androidx.core.p036h.ScrollingView;
import androidx.core.p036h.p037a.AccessibilityEventCompat;
import androidx.core.p036h.p037a.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.widget.AdapterHelper;
import androidx.recyclerview.widget.ChildHelper;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import androidx.recyclerview.widget.ViewBoundsCheck;
import androidx.recyclerview.widget.ViewInfoStore;
import androidx.recyclerview.widget.GapWorker;
import com.sensetime.stmobile.STMobileHumanActionNative;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements InterfaceC0501j, InterfaceC0502k, ScrollingView {
    static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC;
    static final boolean ALLOW_THREAD_GAP_WORK;
    static final boolean DEBUG = false;
    static final int DEFAULT_ORIENTATION = 1;
    static final boolean DISPATCH_TEMP_DETACH = false;
    private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION;
    static final boolean FORCE_INVALIDATE_DISPLAY_LIST;
    static final long FOREVER_NS = Long.MAX_VALUE;
    public static final int HORIZONTAL = 0;
    private static final boolean IGNORE_DETACHED_FOCUSED_CHILD;
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
    static final int MAX_SCROLL_DURATION = 2000;
    private static final int[] NESTED_SCROLLING_ATTRS = {R.attr.nestedScrollingEnabled};
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    static final boolean POST_UPDATES_ON_ANIMATION;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
    static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    static final String TRACE_NESTED_PREFETCH_TAG = "RV Nested Prefetch";
    private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    static final String TRACE_PREFETCH_TAG = "RV Prefetch";
    static final String TRACE_SCROLL_TAG = "RV Scroll";
    public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
    static final boolean VERBOSE_TRACING = false;
    public static final int VERTICAL = 1;
    static final Interpolator sQuinticInterpolator;
    RecyclerViewAccessibilityDelegate mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    AbstractC0685a mAdapter;
    AdapterHelper mAdapterHelper;
    boolean mAdapterUpdateDuringMeasure;
    private EdgeEffect mBottomGlow;
    private InterfaceC0688d mChildDrawingOrderCallback;
    ChildHelper mChildHelper;
    boolean mClipToPadding;
    boolean mDataSetHasChangedAfterLayout;
    boolean mDispatchItemsChangedEvent;
    private int mDispatchScrollCounter;
    private int mEatenAccessibilityChangeFlags;
    private C0689e mEdgeEffectFactory;
    boolean mEnableFastScroller;
    boolean mFirstLayoutComplete;
    GapWorker mGapWorker;
    boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mInterceptRequestLayoutDepth;
    private InterfaceC0697m mInterceptingOnItemTouchListener;
    boolean mIsAttached;
    AbstractC0690f mItemAnimator;
    private AbstractC0690f.IntrinsicsJvm.kt_4 mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    final ArrayList<AbstractC0692h> mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastTouchX;
    private int mLastTouchY;
    AbstractC0693i mLayout;
    private int mLayoutOrScrollCounter;
    boolean mLayoutSuppressed;
    boolean mLayoutWasDefered;
    private EdgeEffect mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final C0702r mObserver;
    private List<InterfaceC0695k> mOnChildAttachStateListeners;
    private AbstractC0696l mOnFlingListener;
    private final ArrayList<InterfaceC0697m> mOnItemTouchListeners;
    final List<AbstractC0707w> mPendingAccessibilityImportanceChange;
    SavedState mPendingSavedState;
    boolean mPostedAnimatorRunner;
    GapWorker.PlatformImplementations.kt_3 mPrefetchRegistry;
    private boolean mPreserveFocusAfterLayout;
    final C0700p mRecycler;
    InterfaceC0701q mRecyclerListener;
    final int[] mReusableIntPair;
    private EdgeEffect mRightGlow;
    private float mScaledHorizontalScrollFactor;
    private float mScaledVerticalScrollFactor;
    private AbstractC0698n mScrollListener;
    private List<AbstractC0698n> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private NestedScrollingChildHelper mScrollingChildHelper;
    final C0704t mState;
    final Rect mTempRect;
    private final Rect mTempRect2;
    final RectF mTempRectF;
    private EdgeEffect mTopGlow;
    private int mTouchSlop;
    final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    final RunnableC0706v mViewFlinger;
    private final ViewInfoStore.IntrinsicsJvm.kt_4 mViewInfoProcessCallback;
    final ViewInfoStore mViewInfoStore;

    /* renamed from: androidx.recyclerview.widget.RecyclerView$IntrinsicsJvm.kt_5 */
    public interface InterfaceC0688d {
        /* renamed from: PlatformImplementations.kt_3 */
        int m4119a(int OplusGLSurfaceView_13, int i2);
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$OplusGLSurfaceView_5 */
    public interface InterfaceC0695k {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo4160a(View view);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo4161b(View view);
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$OplusGLSurfaceView_14 */
    public static abstract class AbstractC0696l {
        /* renamed from: PlatformImplementations.kt_3 */
        public abstract boolean mo4162a(int OplusGLSurfaceView_13, int i2);
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$OplusGLSurfaceView_6 */
    public interface InterfaceC0697m {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo4163a(boolean z);

        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo4164a(RecyclerView recyclerView, MotionEvent motionEvent);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo4165b(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$OplusGLSurfaceView_11 */
    public static abstract class AbstractC0698n {
        public void onScrollStateChanged(RecyclerView recyclerView, int OplusGLSurfaceView_13) {
        }

        public void onScrolled(RecyclerView recyclerView, int OplusGLSurfaceView_13, int i2) {
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$q */
    public interface InterfaceC0701q {
        /* renamed from: PlatformImplementations.kt_3 */
        void m4217a(AbstractC0707w abstractC0707w);
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$u */
    public static abstract class AbstractC0705u {
        /* renamed from: PlatformImplementations.kt_3 */
        public abstract View m4231a(C0700p c0700p, int OplusGLSurfaceView_13, int i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public void onChildAttachedToWindow(View view) {
    }

    public void onChildDetachedFromWindow(View view) {
    }

    public void onScrollStateChanged(int OplusGLSurfaceView_13) {
    }

    public void onScrolled(int OplusGLSurfaceView_13, int i2) {
    }

    static {
        FORCE_INVALIDATE_DISPLAY_LIST = Build.VERSION.SDK_INT == 18 || Build.VERSION.SDK_INT == 19 || Build.VERSION.SDK_INT == 20;
        ALLOW_SIZE_IN_UNSPECIFIED_SPEC = Build.VERSION.SDK_INT >= 23;
        POST_UPDATES_ON_ANIMATION = Build.VERSION.SDK_INT >= 16;
        ALLOW_THREAD_GAP_WORK = Build.VERSION.SDK_INT >= 21;
        FORCE_ABS_FOCUS_SEARCH_DIRECTION = Build.VERSION.SDK_INT <= 15;
        IGNORE_DETACHED_FOCUSED_CHILD = Build.VERSION.SDK_INT <= 15;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
        sQuinticInterpolator = new Interpolator() { // from class: androidx.recyclerview.widget.RecyclerView.3
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float COUIBaseListPopupWindow_12) {
                float f2 = COUIBaseListPopupWindow_12 - 1.0f;
                return (f2 * f2 * f2 * f2 * f2) + 1.0f;
            }
        };
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.recyclerview.R.attr.recyclerViewStyle);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) throws NoSuchMethodException, SecurityException {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.mObserver = new C0702r();
        this.mRecycler = new C0700p();
        this.mViewInfoStore = new ViewInfoStore();
        this.mUpdateChildViewsRunnable = new Runnable() { // from class: androidx.recyclerview.widget.RecyclerView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!RecyclerView.this.mFirstLayoutComplete || RecyclerView.this.isLayoutRequested()) {
                    return;
                }
                if (!RecyclerView.this.mIsAttached) {
                    RecyclerView.this.requestLayout();
                } else if (RecyclerView.this.mLayoutSuppressed) {
                    RecyclerView.this.mLayoutWasDefered = true;
                } else {
                    RecyclerView.this.consumePendingUpdateOperations();
                }
            }
        };
        this.mTempRect = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRectF = new RectF();
        this.mItemDecorations = new ArrayList<>();
        this.mOnItemTouchListeners = new ArrayList<>();
        this.mInterceptRequestLayoutDepth = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        this.mEdgeEffectFactory = new C0689e();
        this.mItemAnimator = new DefaultItemAnimator();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        boolean z = true;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new RunnableC0706v();
        this.mPrefetchRegistry = ALLOW_THREAD_GAP_WORK ? new GapWorker.PlatformImplementations.kt_3() : null;
        this.mState = new C0704t();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new C0691g();
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
        this.mReusableIntPair = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList();
        this.mItemAnimatorRunner = new Runnable() { // from class: androidx.recyclerview.widget.RecyclerView.2
            @Override // java.lang.Runnable
            public void run() {
                if (RecyclerView.this.mItemAnimator != null) {
                    RecyclerView.this.mItemAnimator.mo4124a();
                }
                RecyclerView.this.mPostedAnimatorRunner = false;
            }
        };
        this.mViewInfoProcessCallback = new ViewInfoStore.IntrinsicsJvm.kt_4() { // from class: androidx.recyclerview.widget.RecyclerView.4
            @Override // androidx.recyclerview.widget.ViewInfoStore.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo4085a(AbstractC0707w abstractC0707w, AbstractC0690f.IntrinsicsJvm.kt_3 cVar, AbstractC0690f.IntrinsicsJvm.kt_3 cVar2) {
                RecyclerView.this.mRecycler.m4205c(abstractC0707w);
                RecyclerView.this.animateDisappearance(abstractC0707w, cVar, cVar2);
            }

            @Override // androidx.recyclerview.widget.ViewInfoStore.IntrinsicsJvm.kt_4
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo4086b(AbstractC0707w abstractC0707w, AbstractC0690f.IntrinsicsJvm.kt_3 cVar, AbstractC0690f.IntrinsicsJvm.kt_3 cVar2) {
                RecyclerView.this.animateAppearance(abstractC0707w, cVar, cVar2);
            }

            @Override // androidx.recyclerview.widget.ViewInfoStore.IntrinsicsJvm.kt_4
            /* renamed from: IntrinsicsJvm.kt_3 */
            public void mo4087c(AbstractC0707w abstractC0707w, AbstractC0690f.IntrinsicsJvm.kt_3 cVar, AbstractC0690f.IntrinsicsJvm.kt_3 cVar2) {
                abstractC0707w.setIsRecyclable(false);
                if (RecyclerView.this.mDataSetHasChangedAfterLayout) {
                    if (RecyclerView.this.mItemAnimator.mo4128a(abstractC0707w, abstractC0707w, cVar, cVar2)) {
                        RecyclerView.this.postAnimationRunner();
                    }
                } else if (RecyclerView.this.mItemAnimator.mo4132c(abstractC0707w, cVar, cVar2)) {
                    RecyclerView.this.postAnimationRunner();
                }
            }

            @Override // androidx.recyclerview.widget.ViewInfoStore.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo4084a(AbstractC0707w abstractC0707w) {
                RecyclerView.this.mLayout.removeAndRecycleView(abstractC0707w.itemView, RecyclerView.this.mRecycler);
            }
        };
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mScaledHorizontalScrollFactor = ViewConfigurationCompat.m2930a(viewConfiguration, context);
        this.mScaledVerticalScrollFactor = ViewConfigurationCompat.m2932b(viewConfiguration, context);
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.mItemAnimator.m4126a(this.mItemAnimatorListener);
        initAdapterManager();
        initChildrenHelper();
        initAutofill();
        if (ViewCompat.m2883f(this) == 0) {
            ViewCompat.m2867b((View) this, 1);
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.recyclerview.R.styleable.RecyclerView, OplusGLSurfaceView_13, 0);
        ViewCompat.m2845a(this, context, androidx.recyclerview.R.styleable.RecyclerView, attributeSet, typedArrayObtainStyledAttributes, OplusGLSurfaceView_13, 0);
        String string = typedArrayObtainStyledAttributes.getString(androidx.recyclerview.R.styleable.RecyclerView_layoutManager);
        if (typedArrayObtainStyledAttributes.getInt(androidx.recyclerview.R.styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
            setDescendantFocusability(STMobileHumanActionNative.ST_MOBILE_DETECT_MODE_IMAGE);
        }
        this.mClipToPadding = typedArrayObtainStyledAttributes.getBoolean(androidx.recyclerview.R.styleable.RecyclerView_android_clipToPadding, true);
        this.mEnableFastScroller = typedArrayObtainStyledAttributes.getBoolean(androidx.recyclerview.R.styleable.RecyclerView_fastScrollEnabled, false);
        if (this.mEnableFastScroller) {
            initFastScroller((StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(androidx.recyclerview.R.styleable.RecyclerView_fastScrollVerticalThumbDrawable), typedArrayObtainStyledAttributes.getDrawable(androidx.recyclerview.R.styleable.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(androidx.recyclerview.R.styleable.RecyclerView_fastScrollHorizontalThumbDrawable), typedArrayObtainStyledAttributes.getDrawable(androidx.recyclerview.R.styleable.RecyclerView_fastScrollHorizontalTrackDrawable));
        }
        typedArrayObtainStyledAttributes.recycle();
        createLayoutManager(context, string, attributeSet, OplusGLSurfaceView_13, 0);
        if (Build.VERSION.SDK_INT >= 21) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, NESTED_SCROLLING_ATTRS, OplusGLSurfaceView_13, 0);
            ViewCompat.m2845a(this, context, NESTED_SCROLLING_ATTRS, attributeSet, typedArrayObtainStyledAttributes2, OplusGLSurfaceView_13, 0);
            z = typedArrayObtainStyledAttributes2.getBoolean(0, true);
            typedArrayObtainStyledAttributes2.recycle();
        }
        setNestedScrollingEnabled(z);
    }

    String exceptionLabel() {
        return " " + super.toString() + ", adapter:" + this.mAdapter + ", layout:" + this.mLayout + ", context:" + getContext();
    }

    @SuppressLint({"InlinedApi"})
    private void initAutofill() {
        if (ViewCompat.m2838a(this) == 0) {
            ViewCompat.m2842a((View) this, 8);
        }
    }

    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void setAccessibilityDelegateCompat(RecyclerViewAccessibilityDelegate c0729p) {
        this.mAccessibilityDelegate = c0729p;
        ViewCompat.m2854a(this, this.mAccessibilityDelegate);
    }

    private void createLayoutManager(Context context, String str, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) throws NoSuchMethodException, SecurityException {
        ClassLoader classLoader;
        Constructor constructor;
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.isEmpty()) {
                return;
            }
            String fullClassName = getFullClassName(context, strTrim);
            try {
                if (isInEditMode()) {
                    classLoader = getClass().getClassLoader();
                } else {
                    classLoader = context.getClassLoader();
                }
                Class<? extends U> clsAsSubclass = Class.forName(fullClassName, false, classLoader).asSubclass(AbstractC0693i.class);
                Object[] objArr = null;
                try {
                    constructor = clsAsSubclass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                    objArr = new Object[]{context, attributeSet, Integer.valueOf(OplusGLSurfaceView_13), Integer.valueOf(i2)};
                } catch (NoSuchMethodException COUIBaseListPopupWindow_8) {
                    try {
                        constructor = clsAsSubclass.getConstructor(new Class[0]);
                    } catch (NoSuchMethodException e2) {
                        e2.initCause(COUIBaseListPopupWindow_8);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + fullClassName, e2);
                    }
                }
                constructor.setAccessible(true);
                setLayoutManager((AbstractC0693i) constructor.newInstance(objArr));
            } catch (ClassCastException e3) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not PlatformImplementations.kt_3 LayoutManager " + fullClassName, e3);
            } catch (ClassNotFoundException e4) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + fullClassName, e4);
            } catch (IllegalAccessException e5) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + fullClassName, e5);
            } catch (InstantiationException e6) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e6);
            } catch (InvocationTargetException e7) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e7);
            }
        }
    }

    private String getFullClassName(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        if (str.contains(".")) {
            return str;
        }
        return RecyclerView.class.getPackage().getName() + '.' + str;
    }

    private void initChildrenHelper() {
        this.mChildHelper = new ChildHelper(new ChildHelper.IntrinsicsJvm.kt_4() { // from class: androidx.recyclerview.widget.RecyclerView.5
            @Override // androidx.recyclerview.widget.ChildHelper.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3 */
            public int mo4088a() {
                return RecyclerView.this.getChildCount();
            }

            @Override // androidx.recyclerview.widget.ChildHelper.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo4091a(View view, int OplusGLSurfaceView_13) {
                RecyclerView.this.addView(view, OplusGLSurfaceView_13);
                RecyclerView.this.dispatchChildAttached(view);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3 */
            public int mo4089a(View view) {
                return RecyclerView.this.indexOfChild(view);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo4090a(int OplusGLSurfaceView_13) {
                View childAt = RecyclerView.this.getChildAt(OplusGLSurfaceView_13);
                if (childAt != null) {
                    RecyclerView.this.dispatchChildDetached(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeViewAt(OplusGLSurfaceView_13);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.IntrinsicsJvm.kt_4
            /* renamed from: IntrinsicsJvm.kt_4 */
            public View mo4093b(int OplusGLSurfaceView_13) {
                return RecyclerView.this.getChildAt(OplusGLSurfaceView_13);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.IntrinsicsJvm.kt_4
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo4095b() {
                int iMo4088a = mo4088a();
                for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < iMo4088a; OplusGLSurfaceView_13++) {
                    View viewMo4093b = mo4093b(OplusGLSurfaceView_13);
                    RecyclerView.this.dispatchChildDetached(viewMo4093b);
                    viewMo4093b.clearAnimation();
                }
                RecyclerView.this.removeAllViews();
            }

            @Override // androidx.recyclerview.widget.ChildHelper.IntrinsicsJvm.kt_4
            /* renamed from: IntrinsicsJvm.kt_4 */
            public AbstractC0707w mo4094b(View view) {
                return RecyclerView.getChildViewHolderInt(view);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo4092a(View view, int OplusGLSurfaceView_13, ViewGroup.LayoutParams layoutParams) {
                AbstractC0707w childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    if (!childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                        throw new IllegalArgumentException("Called attach on PlatformImplementations.kt_3 child which is not detached: " + childViewHolderInt + RecyclerView.this.exceptionLabel());
                    }
                    childViewHolderInt.clearTmpDetachFlag();
                }
                RecyclerView.this.attachViewToParent(view, OplusGLSurfaceView_13, layoutParams);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.IntrinsicsJvm.kt_4
            /* renamed from: IntrinsicsJvm.kt_3 */
            public void mo4096c(int OplusGLSurfaceView_13) {
                AbstractC0707w childViewHolderInt;
                View viewMo4093b = mo4093b(OplusGLSurfaceView_13);
                if (viewMo4093b != null && (childViewHolderInt = RecyclerView.getChildViewHolderInt(viewMo4093b)) != null) {
                    if (childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                        throw new IllegalArgumentException("called detach on an already detached child " + childViewHolderInt + RecyclerView.this.exceptionLabel());
                    }
                    childViewHolderInt.addFlags(256);
                }
                RecyclerView.this.detachViewFromParent(OplusGLSurfaceView_13);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.IntrinsicsJvm.kt_4
            /* renamed from: IntrinsicsJvm.kt_3 */
            public void mo4097c(View view) {
                AbstractC0707w childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    childViewHolderInt.onEnteredHiddenState(RecyclerView.this);
                }
            }

            @Override // androidx.recyclerview.widget.ChildHelper.IntrinsicsJvm.kt_4
            /* renamed from: IntrinsicsJvm.kt_5 */
            public void mo4098d(View view) {
                AbstractC0707w childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    childViewHolderInt.onLeftHiddenState(RecyclerView.this);
                }
            }
        });
    }

    void initAdapterManager() {
        this.mAdapterHelper = new AdapterHelper(new AdapterHelper.PlatformImplementations.kt_3() { // from class: androidx.recyclerview.widget.RecyclerView.6
            @Override // androidx.recyclerview.widget.AdapterHelper.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public AbstractC0707w mo4099a(int OplusGLSurfaceView_13) {
                AbstractC0707w abstractC0707wFindViewHolderForPosition = RecyclerView.this.findViewHolderForPosition(OplusGLSurfaceView_13, true);
                if (abstractC0707wFindViewHolderForPosition == null || RecyclerView.this.mChildHelper.m4389c(abstractC0707wFindViewHolderForPosition.itemView)) {
                    return null;
                }
                return abstractC0707wFindViewHolderForPosition;
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo4100a(int OplusGLSurfaceView_13, int i2) {
                RecyclerView.this.offsetPositionRecordsForRemove(OplusGLSurfaceView_13, i2, true);
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.mItemsAddedOrRemoved = true;
                recyclerView.mState.f4068c += i2;
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.PlatformImplementations.kt_3
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo4103b(int OplusGLSurfaceView_13, int i2) {
                RecyclerView.this.offsetPositionRecordsForRemove(OplusGLSurfaceView_13, i2, false);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo4101a(int OplusGLSurfaceView_13, int i2, Object obj) {
                RecyclerView.this.viewRangeUpdate(OplusGLSurfaceView_13, i2, obj);
                RecyclerView.this.mItemsChanged = true;
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo4102a(AdapterHelper.IntrinsicsJvm.kt_4 bVar) {
                m4106c(bVar);
            }

            /* renamed from: IntrinsicsJvm.kt_3 */
            void m4106c(AdapterHelper.IntrinsicsJvm.kt_4 bVar) {
                int OplusGLSurfaceView_13 = bVar.f4140a;
                if (OplusGLSurfaceView_13 == 1) {
                    RecyclerView.this.mLayout.onItemsAdded(RecyclerView.this, bVar.f4141b, bVar.f4143d);
                    return;
                }
                if (OplusGLSurfaceView_13 == 2) {
                    RecyclerView.this.mLayout.onItemsRemoved(RecyclerView.this, bVar.f4141b, bVar.f4143d);
                } else if (OplusGLSurfaceView_13 == 4) {
                    RecyclerView.this.mLayout.onItemsUpdated(RecyclerView.this, bVar.f4141b, bVar.f4143d, bVar.f4142c);
                } else {
                    if (OplusGLSurfaceView_13 != 8) {
                        return;
                    }
                    RecyclerView.this.mLayout.onItemsMoved(RecyclerView.this, bVar.f4141b, bVar.f4143d, 1);
                }
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.PlatformImplementations.kt_3
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo4104b(AdapterHelper.IntrinsicsJvm.kt_4 bVar) {
                m4106c(bVar);
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.PlatformImplementations.kt_3
            /* renamed from: IntrinsicsJvm.kt_3 */
            public void mo4105c(int OplusGLSurfaceView_13, int i2) {
                RecyclerView.this.offsetPositionRecordsForInsert(OplusGLSurfaceView_13, i2);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.PlatformImplementations.kt_3
            /* renamed from: IntrinsicsJvm.kt_5 */
            public void mo4107d(int OplusGLSurfaceView_13, int i2) {
                RecyclerView.this.offsetPositionRecordsForMove(OplusGLSurfaceView_13, i2);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }
        });
    }

    public void setHasFixedSize(boolean z) {
        this.mHasFixedSize = z;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        if (z != this.mClipToPadding) {
            invalidateGlows();
        }
        this.mClipToPadding = z;
        super.setClipToPadding(z);
        if (this.mFirstLayoutComplete) {
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    public void setScrollingTouchSlop(int OplusGLSurfaceView_13) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (OplusGLSurfaceView_13 != 0) {
            if (OplusGLSurfaceView_13 != 1) {
                Log.w(TAG, "setScrollingTouchSlop(): bad argument constant " + OplusGLSurfaceView_13 + "; using default value");
            } else {
                this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
        }
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public void swapAdapter(AbstractC0685a abstractC0685a, boolean z) {
        setLayoutFrozen(false);
        setAdapterInternal(abstractC0685a, true, z);
        processDataSetCompletelyChanged(true);
        requestLayout();
    }

    public void setAdapter(AbstractC0685a abstractC0685a) {
        setLayoutFrozen(false);
        setAdapterInternal(abstractC0685a, false, true);
        processDataSetCompletelyChanged(false);
        requestLayout();
    }

    void removeAndRecycleViews() {
        AbstractC0690f abstractC0690f = this.mItemAnimator;
        if (abstractC0690f != null) {
            abstractC0690f.mo4133d();
        }
        AbstractC0693i abstractC0693i = this.mLayout;
        if (abstractC0693i != null) {
            abstractC0693i.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        }
        this.mRecycler.m4185a();
    }

    private void setAdapterInternal(AbstractC0685a abstractC0685a, boolean z, boolean z2) {
        AbstractC0685a abstractC0685a2 = this.mAdapter;
        if (abstractC0685a2 != null) {
            abstractC0685a2.unregisterAdapterDataObserver(this.mObserver);
            this.mAdapter.onDetachedFromRecyclerView(this);
        }
        if (!z || z2) {
            removeAndRecycleViews();
        }
        this.mAdapterHelper.m4353a();
        AbstractC0685a abstractC0685a3 = this.mAdapter;
        this.mAdapter = abstractC0685a;
        if (abstractC0685a != null) {
            abstractC0685a.registerAdapterDataObserver(this.mObserver);
            abstractC0685a.onAttachedToRecyclerView(this);
        }
        AbstractC0693i abstractC0693i = this.mLayout;
        if (abstractC0693i != null) {
            abstractC0693i.onAdapterChanged(abstractC0685a3, this.mAdapter);
        }
        this.mRecycler.m4190a(abstractC0685a3, this.mAdapter, z);
        this.mState.f4071f = true;
    }

    public AbstractC0685a getAdapter() {
        return this.mAdapter;
    }

    public void setRecyclerListener(InterfaceC0701q interfaceC0701q) {
        this.mRecyclerListener = interfaceC0701q;
    }

    @Override // android.view.View
    public int getBaseline() {
        AbstractC0693i abstractC0693i = this.mLayout;
        if (abstractC0693i != null) {
            return abstractC0693i.getBaseline();
        }
        return super.getBaseline();
    }

    public void addOnChildAttachStateChangeListener(InterfaceC0695k interfaceC0695k) {
        if (this.mOnChildAttachStateListeners == null) {
            this.mOnChildAttachStateListeners = new ArrayList();
        }
        this.mOnChildAttachStateListeners.add(interfaceC0695k);
    }

    public void removeOnChildAttachStateChangeListener(InterfaceC0695k interfaceC0695k) {
        List<InterfaceC0695k> list = this.mOnChildAttachStateListeners;
        if (list == null) {
            return;
        }
        list.remove(interfaceC0695k);
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<InterfaceC0695k> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void setLayoutManager(AbstractC0693i abstractC0693i) {
        if (abstractC0693i == this.mLayout) {
            return;
        }
        stopScroll();
        if (this.mLayout != null) {
            AbstractC0690f abstractC0690f = this.mItemAnimator;
            if (abstractC0690f != null) {
                abstractC0690f.mo4133d();
            }
            this.mLayout.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
            this.mRecycler.m4185a();
            if (this.mIsAttached) {
                this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
            }
            this.mLayout.setRecyclerView(null);
            this.mLayout = null;
        } else {
            this.mRecycler.m4185a();
        }
        this.mChildHelper.m4378a();
        this.mLayout = abstractC0693i;
        if (abstractC0693i != null) {
            if (abstractC0693i.mRecyclerView != null) {
                throw new IllegalArgumentException("LayoutManager " + abstractC0693i + " is already attached to PlatformImplementations.kt_3 RecyclerView:" + abstractC0693i.mRecyclerView.exceptionLabel());
            }
            this.mLayout.setRecyclerView(this);
            if (this.mIsAttached) {
                this.mLayout.dispatchAttachedToWindow(this);
            }
        }
        this.mRecycler.m4197b();
        requestLayout();
    }

    public void setOnFlingListener(AbstractC0696l abstractC0696l) {
        this.mOnFlingListener = abstractC0696l;
    }

    public AbstractC0696l getOnFlingListener() {
        return this.mOnFlingListener;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.mPendingSavedState;
        if (savedState2 != null) {
            savedState.copyFrom(savedState2);
        } else {
            AbstractC0693i abstractC0693i = this.mLayout;
            if (abstractC0693i != null) {
                savedState.mLayoutState = abstractC0693i.onSaveInstanceState();
            } else {
                savedState.mLayoutState = null;
            }
        }
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        this.mPendingSavedState = (SavedState) parcelable;
        super.onRestoreInstanceState(this.mPendingSavedState.getSuperState());
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    private void addAnimatingView(AbstractC0707w abstractC0707w) {
        View view = abstractC0707w.itemView;
        boolean z = view.getParent() == this;
        this.mRecycler.m4205c(getChildViewHolder(view));
        if (abstractC0707w.isTmpDetached()) {
            this.mChildHelper.m4381a(view, -1, view.getLayoutParams(), true);
        } else if (!z) {
            this.mChildHelper.m4383a(view, true);
        } else {
            this.mChildHelper.m4391d(view);
        }
    }

    boolean removeAnimatingView(View view) {
        startInterceptRequestLayout();
        boolean zM4394f = this.mChildHelper.m4394f(view);
        if (zM4394f) {
            AbstractC0707w childViewHolderInt = getChildViewHolderInt(view);
            this.mRecycler.m4205c(childViewHolderInt);
            this.mRecycler.m4200b(childViewHolderInt);
        }
        stopInterceptRequestLayout(!zM4394f);
        return zM4394f;
    }

    public AbstractC0693i getLayoutManager() {
        return this.mLayout;
    }

    public C0699o getRecycledViewPool() {
        return this.mRecycler.m4213g();
    }

    public void setRecycledViewPool(C0699o c0699o) {
        this.mRecycler.m4191a(c0699o);
    }

    public void setViewCacheExtension(AbstractC0705u abstractC0705u) {
        this.mRecycler.m4192a(abstractC0705u);
    }

    public void setItemViewCacheSize(int OplusGLSurfaceView_13) {
        this.mRecycler.m4186a(OplusGLSurfaceView_13);
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    void setScrollState(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == this.mScrollState) {
            return;
        }
        this.mScrollState = OplusGLSurfaceView_13;
        if (OplusGLSurfaceView_13 != 2) {
            stopScrollersInternal();
        }
        dispatchOnScrollStateChanged(OplusGLSurfaceView_13);
    }

    public void addItemDecoration(AbstractC0692h abstractC0692h, int OplusGLSurfaceView_13) {
        AbstractC0693i abstractC0693i = this.mLayout;
        if (abstractC0693i != null) {
            abstractC0693i.assertNotInLayoutOrScroll("Cannot add item decoration during PlatformImplementations.kt_3 scroll  or layout");
        }
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(false);
        }
        if (OplusGLSurfaceView_13 < 0) {
            this.mItemDecorations.add(abstractC0692h);
        } else {
            this.mItemDecorations.add(OplusGLSurfaceView_13, abstractC0692h);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void addItemDecoration(AbstractC0692h abstractC0692h) {
        addItemDecoration(abstractC0692h, -1);
    }

    public AbstractC0692h getItemDecorationAt(int OplusGLSurfaceView_13) {
        int itemDecorationCount = getItemDecorationCount();
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 >= itemDecorationCount) {
            throw new IndexOutOfBoundsException(OplusGLSurfaceView_13 + " is an invalid index for size " + itemDecorationCount);
        }
        return this.mItemDecorations.get(OplusGLSurfaceView_13);
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    public void removeItemDecorationAt(int OplusGLSurfaceView_13) {
        int itemDecorationCount = getItemDecorationCount();
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 >= itemDecorationCount) {
            throw new IndexOutOfBoundsException(OplusGLSurfaceView_13 + " is an invalid index for size " + itemDecorationCount);
        }
        removeItemDecoration(getItemDecorationAt(OplusGLSurfaceView_13));
    }

    public void removeItemDecoration(AbstractC0692h abstractC0692h) {
        AbstractC0693i abstractC0693i = this.mLayout;
        if (abstractC0693i != null) {
            abstractC0693i.assertNotInLayoutOrScroll("Cannot remove item decoration during PlatformImplementations.kt_3 scroll  or layout");
        }
        this.mItemDecorations.remove(abstractC0692h);
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void setChildDrawingOrderCallback(InterfaceC0688d interfaceC0688d) {
        if (interfaceC0688d == this.mChildDrawingOrderCallback) {
            return;
        }
        this.mChildDrawingOrderCallback = interfaceC0688d;
        setChildrenDrawingOrderEnabled(this.mChildDrawingOrderCallback != null);
    }

    @Deprecated
    public void setOnScrollListener(AbstractC0698n abstractC0698n) {
        this.mScrollListener = abstractC0698n;
    }

    public void addOnScrollListener(AbstractC0698n abstractC0698n) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList();
        }
        this.mScrollListeners.add(abstractC0698n);
    }

    public void removeOnScrollListener(AbstractC0698n abstractC0698n) {
        List<AbstractC0698n> list = this.mScrollListeners;
        if (list != null) {
            list.remove(abstractC0698n);
        }
    }

    public void clearOnScrollListeners() {
        List<AbstractC0698n> list = this.mScrollListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void scrollToPosition(int OplusGLSurfaceView_13) {
        if (this.mLayoutSuppressed) {
            return;
        }
        stopScroll();
        AbstractC0693i abstractC0693i = this.mLayout;
        if (abstractC0693i == null) {
            Log.COUIBaseListPopupWindow_8(TAG, "Cannot scroll to position PlatformImplementations.kt_3 LayoutManager set. Call setLayoutManager with PlatformImplementations.kt_3 non-null argument.");
        } else {
            abstractC0693i.scrollToPosition(OplusGLSurfaceView_13);
            awakenScrollBars();
        }
    }

    void jumpToPositionForSmoothScroller(int OplusGLSurfaceView_13) {
        if (this.mLayout == null) {
            return;
        }
        setScrollState(2);
        this.mLayout.scrollToPosition(OplusGLSurfaceView_13);
        awakenScrollBars();
    }

    public void smoothScrollToPosition(int OplusGLSurfaceView_13) {
        if (this.mLayoutSuppressed) {
            return;
        }
        AbstractC0693i abstractC0693i = this.mLayout;
        if (abstractC0693i == null) {
            Log.COUIBaseListPopupWindow_8(TAG, "Cannot smooth scroll without PlatformImplementations.kt_3 LayoutManager set. Call setLayoutManager with PlatformImplementations.kt_3 non-null argument.");
        } else {
            abstractC0693i.smoothScrollToPosition(this, this.mState, OplusGLSurfaceView_13);
        }
    }

    @Override // android.view.View
    public void scrollTo(int OplusGLSurfaceView_13, int i2) {
        Log.w(TAG, "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View
    public void scrollBy(int OplusGLSurfaceView_13, int i2) {
        AbstractC0693i abstractC0693i = this.mLayout;
        if (abstractC0693i == null) {
            Log.COUIBaseListPopupWindow_8(TAG, "Cannot scroll without PlatformImplementations.kt_3 LayoutManager set. Call setLayoutManager with PlatformImplementations.kt_3 non-null argument.");
            return;
        }
        if (this.mLayoutSuppressed) {
            return;
        }
        boolean zCanScrollHorizontally = abstractC0693i.canScrollHorizontally();
        boolean zCanScrollVertically = this.mLayout.canScrollVertically();
        if (zCanScrollHorizontally || zCanScrollVertically) {
            if (!zCanScrollHorizontally) {
                OplusGLSurfaceView_13 = 0;
            }
            if (!zCanScrollVertically) {
                i2 = 0;
            }
            scrollByInternal(OplusGLSurfaceView_13, i2, null);
        }
    }

    void scrollStep(int OplusGLSurfaceView_13, int i2, int[] iArr) {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        TraceCompat.m2449a(TRACE_SCROLL_TAG);
        fillRemainingScrollValues(this.mState);
        int iScrollHorizontallyBy = OplusGLSurfaceView_13 != 0 ? this.mLayout.scrollHorizontallyBy(OplusGLSurfaceView_13, this.mRecycler, this.mState) : 0;
        int iScrollVerticallyBy = i2 != 0 ? this.mLayout.scrollVerticallyBy(i2, this.mRecycler, this.mState) : 0;
        TraceCompat.m2448a();
        repositionShadowingViews();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        if (iArr != null) {
            iArr[0] = iScrollHorizontallyBy;
            iArr[1] = iScrollVerticallyBy;
        }
    }

    void consumePendingUpdateOperations() {
        if (!this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout) {
            TraceCompat.m2449a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
            dispatchLayout();
            TraceCompat.m2448a();
            return;
        }
        if (this.mAdapterHelper.m4366d()) {
            if (this.mAdapterHelper.m4357a(4) && !this.mAdapterHelper.m4357a(11)) {
                TraceCompat.m2449a(TRACE_HANDLE_ADAPTER_UPDATES_TAG);
                startInterceptRequestLayout();
                onEnterLayoutOrScroll();
                this.mAdapterHelper.m4361b();
                if (!this.mLayoutWasDefered) {
                    if (hasUpdatedView()) {
                        dispatchLayout();
                    } else {
                        this.mAdapterHelper.m4364c();
                    }
                }
                stopInterceptRequestLayout(true);
                onExitLayoutOrScroll();
                TraceCompat.m2448a();
                return;
            }
            if (this.mAdapterHelper.m4366d()) {
                TraceCompat.m2449a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
                dispatchLayout();
                TraceCompat.m2448a();
            }
        }
    }

    private boolean hasUpdatedView() {
        int iM4384b = this.mChildHelper.m4384b();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < iM4384b; OplusGLSurfaceView_13++) {
            AbstractC0707w childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m4386b(OplusGLSurfaceView_13));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.isUpdated()) {
                return true;
            }
        }
        return false;
    }

    boolean scrollByInternal(int OplusGLSurfaceView_13, int i2, MotionEvent motionEvent) {
        int i3;
        int i4;
        int i5;
        int i6;
        consumePendingUpdateOperations();
        if (this.mAdapter != null) {
            int[] iArr = this.mReusableIntPair;
            iArr[0] = 0;
            iArr[1] = 0;
            scrollStep(OplusGLSurfaceView_13, i2, iArr);
            int[] iArr2 = this.mReusableIntPair;
            int i7 = iArr2[0];
            int i8 = iArr2[1];
            i4 = i8;
            i3 = i7;
            i5 = OplusGLSurfaceView_13 - i7;
            i6 = i2 - i8;
        } else {
            i3 = 0;
            i4 = 0;
            i5 = 0;
            i6 = 0;
        }
        if (!this.mItemDecorations.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.mReusableIntPair;
        iArr3[0] = 0;
        iArr3[1] = 0;
        int i9 = i3;
        dispatchNestedScroll(i3, i4, i5, i6, this.mScrollOffset, 0, iArr3);
        int[] iArr4 = this.mReusableIntPair;
        int i10 = i5 - iArr4[0];
        int i11 = i6 - iArr4[1];
        boolean z = (iArr4[0] == 0 && iArr4[1] == 0) ? false : true;
        int i12 = this.mLastTouchX;
        int[] iArr5 = this.mScrollOffset;
        this.mLastTouchX = i12 - iArr5[0];
        this.mLastTouchY -= iArr5[1];
        int[] iArr6 = this.mNestedOffsets;
        iArr6[0] = iArr6[0] + iArr5[0];
        iArr6[1] = iArr6[1] + iArr5[1];
        if (getOverScrollMode() != 2) {
            if (motionEvent != null && !MotionEventCompat.m2795a(motionEvent, 8194)) {
                pullGlows(motionEvent.getX(), i10, motionEvent.getY(), i11);
            }
            considerReleasingGlowsOnScroll(OplusGLSurfaceView_13, i2);
        }
        if (i9 != 0 || i4 != 0) {
            dispatchOnScrolled(i9, i4);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (!z && i9 == 0 && i4 == 0) ? false : true;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        AbstractC0693i abstractC0693i = this.mLayout;
        if (abstractC0693i != null && abstractC0693i.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollOffset(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        AbstractC0693i abstractC0693i = this.mLayout;
        if (abstractC0693i != null && abstractC0693i.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollExtent(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        AbstractC0693i abstractC0693i = this.mLayout;
        if (abstractC0693i != null && abstractC0693i.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollRange(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        AbstractC0693i abstractC0693i = this.mLayout;
        if (abstractC0693i != null && abstractC0693i.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollOffset(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        AbstractC0693i abstractC0693i = this.mLayout;
        if (abstractC0693i != null && abstractC0693i.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollExtent(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        AbstractC0693i abstractC0693i = this.mLayout;
        if (abstractC0693i != null && abstractC0693i.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollRange(this.mState);
        }
        return 0;
    }

    void startInterceptRequestLayout() {
        this.mInterceptRequestLayoutDepth++;
        if (this.mInterceptRequestLayoutDepth != 1 || this.mLayoutSuppressed) {
            return;
        }
        this.mLayoutWasDefered = false;
    }

    void stopInterceptRequestLayout(boolean z) {
        if (this.mInterceptRequestLayoutDepth < 1) {
            this.mInterceptRequestLayoutDepth = 1;
        }
        if (!z && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
        if (this.mInterceptRequestLayoutDepth == 1) {
            if (z && this.mLayoutWasDefered && !this.mLayoutSuppressed && this.mLayout != null && this.mAdapter != null) {
                dispatchLayout();
            }
            if (!this.mLayoutSuppressed) {
                this.mLayoutWasDefered = false;
            }
        }
        this.mInterceptRequestLayoutDepth--;
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z) {
        if (z != this.mLayoutSuppressed) {
            assertNotInLayoutOrScroll("Do not suppressLayout in layout or scroll");
            if (!z) {
                this.mLayoutSuppressed = false;
                if (this.mLayoutWasDefered && this.mLayout != null && this.mAdapter != null) {
                    requestLayout();
                }
                this.mLayoutWasDefered = false;
                return;
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
            this.mLayoutSuppressed = true;
            this.mIgnoreMotionEventTillDown = true;
            stopScroll();
        }
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.mLayoutSuppressed;
    }

    @Deprecated
    public void setLayoutFrozen(boolean z) {
        suppressLayout(z);
    }

    @Deprecated
    public boolean isLayoutFrozen() {
        return isLayoutSuppressed();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (Build.VERSION.SDK_INT < 18) {
            if (layoutTransition == null) {
                suppressLayout(false);
                return;
            } else if (layoutTransition.getAnimator(0) == null && layoutTransition.getAnimator(1) == null && layoutTransition.getAnimator(2) == null && layoutTransition.getAnimator(3) == null && layoutTransition.getAnimator(4) == null) {
                suppressLayout(true);
                return;
            }
        }
        if (layoutTransition == null) {
            super.setLayoutTransition(null);
            return;
        }
        throw new IllegalArgumentException("Providing PlatformImplementations.kt_3 LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    }

    public void smoothScrollBy(int OplusGLSurfaceView_13, int i2) {
        smoothScrollBy(OplusGLSurfaceView_13, i2, null);
    }

    public void smoothScrollBy(int OplusGLSurfaceView_13, int i2, Interpolator interpolator) {
        smoothScrollBy(OplusGLSurfaceView_13, i2, interpolator, Integer.MIN_VALUE);
    }

    public void smoothScrollBy(int OplusGLSurfaceView_13, int i2, Interpolator interpolator, int i3) {
        smoothScrollBy(OplusGLSurfaceView_13, i2, interpolator, i3, false);
    }

    void smoothScrollBy(int OplusGLSurfaceView_13, int i2, Interpolator interpolator, int i3, boolean z) {
        AbstractC0693i abstractC0693i = this.mLayout;
        if (abstractC0693i == null) {
            Log.COUIBaseListPopupWindow_8(TAG, "Cannot smooth scroll without PlatformImplementations.kt_3 LayoutManager set. Call setLayoutManager with PlatformImplementations.kt_3 non-null argument.");
            return;
        }
        if (this.mLayoutSuppressed) {
            return;
        }
        if (!abstractC0693i.canScrollHorizontally()) {
            OplusGLSurfaceView_13 = 0;
        }
        if (!this.mLayout.canScrollVertically()) {
            i2 = 0;
        }
        if (OplusGLSurfaceView_13 == 0 && i2 == 0) {
            return;
        }
        if (i3 == Integer.MIN_VALUE || i3 > 0) {
            if (z) {
                int i4 = OplusGLSurfaceView_13 != 0 ? 1 : 0;
                if (i2 != 0) {
                    i4 |= 2;
                }
                startNestedScroll(i4, 1);
            }
            this.mViewFlinger.m4237a(OplusGLSurfaceView_13, i2, i3, interpolator);
            return;
        }
        scrollBy(OplusGLSurfaceView_13, i2);
    }

    public boolean fling(int OplusGLSurfaceView_13, int i2) {
        AbstractC0693i abstractC0693i = this.mLayout;
        if (abstractC0693i == null) {
            Log.COUIBaseListPopupWindow_8(TAG, "Cannot fling without PlatformImplementations.kt_3 LayoutManager set. Call setLayoutManager with PlatformImplementations.kt_3 non-null argument.");
            return false;
        }
        if (this.mLayoutSuppressed) {
            return false;
        }
        boolean zCanScrollHorizontally = abstractC0693i.canScrollHorizontally();
        boolean zCanScrollVertically = this.mLayout.canScrollVertically();
        if (!zCanScrollHorizontally || Math.abs(OplusGLSurfaceView_13) < this.mMinFlingVelocity) {
            OplusGLSurfaceView_13 = 0;
        }
        if (!zCanScrollVertically || Math.abs(i2) < this.mMinFlingVelocity) {
            i2 = 0;
        }
        if (OplusGLSurfaceView_13 == 0 && i2 == 0) {
            return false;
        }
        float COUIBaseListPopupWindow_12 = OplusGLSurfaceView_13;
        float f2 = i2;
        if (!dispatchNestedPreFling(COUIBaseListPopupWindow_12, f2)) {
            boolean z = zCanScrollHorizontally || zCanScrollVertically;
            dispatchNestedFling(COUIBaseListPopupWindow_12, f2, z);
            AbstractC0696l abstractC0696l = this.mOnFlingListener;
            if (abstractC0696l != null && abstractC0696l.mo4162a(OplusGLSurfaceView_13, i2)) {
                return true;
            }
            if (z) {
                int i3 = zCanScrollHorizontally ? 1 : 0;
                if (zCanScrollVertically) {
                    i3 |= 2;
                }
                startNestedScroll(i3, 1);
                int i4 = this.mMaxFlingVelocity;
                int iMax = Math.max(-i4, Math.min(OplusGLSurfaceView_13, i4));
                int i5 = this.mMaxFlingVelocity;
                this.mViewFlinger.m4236a(iMax, Math.max(-i5, Math.min(i2, i5)));
                return true;
            }
        }
        return false;
    }

    public void stopScroll() {
        setScrollState(0);
        stopScrollersInternal();
    }

    private void stopScrollersInternal() {
        this.mViewFlinger.m4238b();
        AbstractC0693i abstractC0693i = this.mLayout;
        if (abstractC0693i != null) {
            abstractC0693i.stopSmoothScroller();
        }
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void pullGlows(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 0
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 1
            if (r1 >= 0) goto L21
            r6.ensureLeftGlow()
            android.widget.EdgeEffect r1 = r6.mLeftGlow
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r2 - r9
            androidx.core.widget.EdgeEffectCompat.m3034a(r1, r4, r9)
        L1f:
            r9 = r3
            goto L3c
        L21:
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r1 <= 0) goto L3b
            r6.ensureRightGlow()
            android.widget.EdgeEffect r1 = r6.mRightGlow
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            androidx.core.widget.EdgeEffectCompat.m3034a(r1, r4, r9)
            goto L1f
        L3b:
            r9 = 0
        L3c:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L56
            r6.ensureTopGlow()
            android.widget.EdgeEffect r9 = r6.mTopGlow
            float r1 = -r10
            int r2 = r6.getHeight()
            float r2 = (float) r2
            float r1 = r1 / r2
            int r2 = r6.getWidth()
            float r2 = (float) r2
            float r7 = r7 / r2
            androidx.core.widget.EdgeEffectCompat.m3034a(r9, r1, r7)
            goto L72
        L56:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 <= 0) goto L71
            r6.ensureBottomGlow()
            android.widget.EdgeEffect r9 = r6.mBottomGlow
            int r1 = r6.getHeight()
            float r1 = (float) r1
            float r1 = r10 / r1
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r2 = r2 - r7
            androidx.core.widget.EdgeEffectCompat.m3034a(r9, r1, r2)
            goto L72
        L71:
            r3 = r9
        L72:
            if (r3 != 0) goto L7c
            int r7 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r7 != 0) goto L7c
            int r7 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r7 == 0) goto L7f
        L7c:
            androidx.core.p036h.ViewCompat.m2881e(r6)
        L7f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.pullGlows(float, float, float, float):void");
    }

    private void releaseGlows() {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.mLeftGlow.isFinished();
        } else {
            zIsFinished = false;
        }
        EdgeEffect edgeEffect2 = this.mTopGlow;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mRightGlow;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.mBottomGlow.isFinished();
        }
        if (zIsFinished) {
            ViewCompat.m2881e(this);
        }
    }

    void considerReleasingGlowsOnScroll(int OplusGLSurfaceView_13, int i2) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished() || OplusGLSurfaceView_13 <= 0) {
            zIsFinished = false;
        } else {
            this.mLeftGlow.onRelease();
            zIsFinished = this.mLeftGlow.isFinished();
        }
        EdgeEffect edgeEffect2 = this.mRightGlow;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && OplusGLSurfaceView_13 < 0) {
            this.mRightGlow.onRelease();
            zIsFinished |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i2 > 0) {
            this.mTopGlow.onRelease();
            zIsFinished |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i2 < 0) {
            this.mBottomGlow.onRelease();
            zIsFinished |= this.mBottomGlow.isFinished();
        }
        if (zIsFinished) {
            ViewCompat.m2881e(this);
        }
    }

    void absorbGlows(int OplusGLSurfaceView_13, int i2) {
        if (OplusGLSurfaceView_13 < 0) {
            ensureLeftGlow();
            if (this.mLeftGlow.isFinished()) {
                this.mLeftGlow.onAbsorb(-OplusGLSurfaceView_13);
            }
        } else if (OplusGLSurfaceView_13 > 0) {
            ensureRightGlow();
            if (this.mRightGlow.isFinished()) {
                this.mRightGlow.onAbsorb(OplusGLSurfaceView_13);
            }
        }
        if (i2 < 0) {
            ensureTopGlow();
            if (this.mTopGlow.isFinished()) {
                this.mTopGlow.onAbsorb(-i2);
            }
        } else if (i2 > 0) {
            ensureBottomGlow();
            if (this.mBottomGlow.isFinished()) {
                this.mBottomGlow.onAbsorb(i2);
            }
        }
        if (OplusGLSurfaceView_13 == 0 && i2 == 0) {
            return;
        }
        ViewCompat.m2881e(this);
    }

    void ensureLeftGlow() {
        if (this.mLeftGlow != null) {
            return;
        }
        this.mLeftGlow = this.mEdgeEffectFactory.m4120a(this, 0);
        if (this.mClipToPadding) {
            this.mLeftGlow.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            this.mLeftGlow.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    void ensureRightGlow() {
        if (this.mRightGlow != null) {
            return;
        }
        this.mRightGlow = this.mEdgeEffectFactory.m4120a(this, 2);
        if (this.mClipToPadding) {
            this.mRightGlow.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            this.mRightGlow.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    void ensureTopGlow() {
        if (this.mTopGlow != null) {
            return;
        }
        this.mTopGlow = this.mEdgeEffectFactory.m4120a(this, 1);
        if (this.mClipToPadding) {
            this.mTopGlow.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            this.mTopGlow.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    void ensureBottomGlow() {
        if (this.mBottomGlow != null) {
            return;
        }
        this.mBottomGlow = this.mEdgeEffectFactory.m4120a(this, 3);
        if (this.mClipToPadding) {
            this.mBottomGlow.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            this.mBottomGlow.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public void setEdgeEffectFactory(C0689e c0689e) {
        Preconditions.m2536a(c0689e);
        this.mEdgeEffectFactory = c0689e;
        invalidateGlows();
    }

    public C0689e getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int OplusGLSurfaceView_13) {
        View viewOnFocusSearchFailed;
        boolean z;
        View viewOnInterceptFocusSearch = this.mLayout.onInterceptFocusSearch(view, OplusGLSurfaceView_13);
        if (viewOnInterceptFocusSearch != null) {
            return viewOnInterceptFocusSearch;
        }
        boolean z2 = (this.mAdapter == null || this.mLayout == null || isComputingLayout() || this.mLayoutSuppressed) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z2 && (OplusGLSurfaceView_13 == 2 || OplusGLSurfaceView_13 == 1)) {
            if (this.mLayout.canScrollVertically()) {
                int i2 = OplusGLSurfaceView_13 == 2 ? 130 : 33;
                z = focusFinder.findNextFocus(this, view, i2) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    OplusGLSurfaceView_13 = i2;
                }
            } else {
                z = false;
            }
            if (!z && this.mLayout.canScrollHorizontally()) {
                int i3 = (this.mLayout.getLayoutDirection() == 1) ^ (OplusGLSurfaceView_13 == 2) ? 66 : 17;
                z = focusFinder.findNextFocus(this, view, i3) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    OplusGLSurfaceView_13 = i3;
                }
            }
            if (z) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                this.mLayout.onFocusSearchFailed(view, OplusGLSurfaceView_13, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            }
            viewOnFocusSearchFailed = focusFinder.findNextFocus(this, view, OplusGLSurfaceView_13);
        } else {
            View viewFindNextFocus = focusFinder.findNextFocus(this, view, OplusGLSurfaceView_13);
            if (viewFindNextFocus == null && z2) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                viewOnFocusSearchFailed = this.mLayout.onFocusSearchFailed(view, OplusGLSurfaceView_13, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            } else {
                viewOnFocusSearchFailed = viewFindNextFocus;
            }
        }
        if (viewOnFocusSearchFailed == null || viewOnFocusSearchFailed.hasFocusable()) {
            return isPreferredNextFocus(view, viewOnFocusSearchFailed, OplusGLSurfaceView_13) ? viewOnFocusSearchFailed : super.focusSearch(view, OplusGLSurfaceView_13);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, OplusGLSurfaceView_13);
        }
        requestChildOnScreen(viewOnFocusSearchFailed, null);
        return view;
    }

    private boolean isPreferredNextFocus(View view, View view2, int OplusGLSurfaceView_13) {
        int i2;
        if (view2 == null || view2 == this || findContainingItemView(view2) == null) {
            return false;
        }
        if (view == null || findContainingItemView(view) == null) {
            return true;
        }
        this.mTempRect.set(0, 0, view.getWidth(), view.getHeight());
        this.mTempRect2.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        offsetDescendantRectToMyCoords(view2, this.mTempRect2);
        char c2 = 65535;
        int i3 = this.mLayout.getLayoutDirection() == 1 ? -1 : 1;
        if ((this.mTempRect.left < this.mTempRect2.left || this.mTempRect.right <= this.mTempRect2.left) && this.mTempRect.right < this.mTempRect2.right) {
            i2 = 1;
        } else {
            i2 = ((this.mTempRect.right > this.mTempRect2.right || this.mTempRect.left >= this.mTempRect2.right) && this.mTempRect.left > this.mTempRect2.left) ? -1 : 0;
        }
        if ((this.mTempRect.top < this.mTempRect2.top || this.mTempRect.bottom <= this.mTempRect2.top) && this.mTempRect.bottom < this.mTempRect2.bottom) {
            c2 = 1;
        } else if ((this.mTempRect.bottom <= this.mTempRect2.bottom && this.mTempRect.top < this.mTempRect2.bottom) || this.mTempRect.top <= this.mTempRect2.top) {
            c2 = 0;
        }
        if (OplusGLSurfaceView_13 == 1) {
            return c2 < 0 || (c2 == 0 && i2 * i3 <= 0);
        }
        if (OplusGLSurfaceView_13 == 2) {
            return c2 > 0 || (c2 == 0 && i2 * i3 >= 0);
        }
        if (OplusGLSurfaceView_13 == 17) {
            return i2 < 0;
        }
        if (OplusGLSurfaceView_13 == 33) {
            return c2 < 0;
        }
        if (OplusGLSurfaceView_13 == 66) {
            return i2 > 0;
        }
        if (OplusGLSurfaceView_13 == 130) {
            return c2 > 0;
        }
        throw new IllegalArgumentException("Invalid direction: " + OplusGLSurfaceView_13 + exceptionLabel());
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.mLayout.onRequestChildFocus(this, this.mState, view, view2) && view2 != null) {
            requestChildOnScreen(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    private void requestChildOnScreen(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.mTempRect.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof C0694j) {
            C0694j c0694j = (C0694j) layoutParams;
            if (!c0694j.f4041e) {
                Rect rect = c0694j.f4040d;
                this.mTempRect.left -= rect.left;
                this.mTempRect.right += rect.right;
                this.mTempRect.top -= rect.top;
                this.mTempRect.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
            offsetRectIntoDescendantCoords(view, this.mTempRect);
        }
        this.mLayout.requestChildRectangleOnScreen(this, view, this.mTempRect, !this.mFirstLayoutComplete, view2 == null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.mLayout.requestChildRectangleOnScreen(this, view, rect, z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int OplusGLSurfaceView_13, int i2) {
        AbstractC0693i abstractC0693i = this.mLayout;
        if (abstractC0693i == null || !abstractC0693i.onAddFocusables(this, arrayList, OplusGLSurfaceView_13, i2)) {
            super.addFocusables(arrayList, OplusGLSurfaceView_13, i2);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int OplusGLSurfaceView_13, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(OplusGLSurfaceView_13, rect);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0052  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onAttachedToWindow() {
        /*
            r4 = this;
            super.onAttachedToWindow()
            r0 = 0
            r4.mLayoutOrScrollCounter = r0
            r1 = 1
            r4.mIsAttached = r1
            boolean r2 = r4.mFirstLayoutComplete
            if (r2 == 0) goto L14
            boolean r2 = r4.isLayoutRequested()
            if (r2 != 0) goto L14
            goto L15
        L14:
            r1 = r0
        L15:
            r4.mFirstLayoutComplete = r1
            androidx.recyclerview.widget.RecyclerView$OplusGLSurfaceView_13 r1 = r4.mLayout
            if (r1 == 0) goto L1e
            r1.dispatchAttachedToWindow(r4)
        L1e:
            r4.mPostedAnimatorRunner = r0
            boolean r0 = androidx.recyclerview.widget.RecyclerView.ALLOW_THREAD_GAP_WORK
            if (r0 == 0) goto L68
            java.lang.ThreadLocal<androidx.recyclerview.widget.COUIBaseListPopupWindow_10> r0 = androidx.recyclerview.widget.GapWorker.f4267a
            java.lang.Object r0 = r0.get()
            androidx.recyclerview.widget.COUIBaseListPopupWindow_10 r0 = (androidx.recyclerview.widget.GapWorker) r0
            r4.mGapWorker = r0
            androidx.recyclerview.widget.COUIBaseListPopupWindow_10 r0 = r4.mGapWorker
            if (r0 != 0) goto L63
            androidx.recyclerview.widget.COUIBaseListPopupWindow_10 r0 = new androidx.recyclerview.widget.COUIBaseListPopupWindow_10
            r0.<init>()
            r4.mGapWorker = r0
            android.view.Display r0 = androidx.core.p036h.ViewCompat.m2828F(r4)
            r1 = 1114636288(0x42700000, float:60.0)
            boolean r2 = r4.isInEditMode()
            if (r2 != 0) goto L52
            if (r0 == 0) goto L52
            float r0 = r0.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 < 0) goto L52
            goto L53
        L52:
            r0 = r1
        L53:
            androidx.recyclerview.widget.COUIBaseListPopupWindow_10 r1 = r4.mGapWorker
            r2 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r2 = r2 / r0
            long r2 = (long) r2
            r1.f4271d = r2
            java.lang.ThreadLocal<androidx.recyclerview.widget.COUIBaseListPopupWindow_10> r0 = androidx.recyclerview.widget.GapWorker.f4267a
            androidx.recyclerview.widget.COUIBaseListPopupWindow_10 r1 = r4.mGapWorker
            r0.set(r1)
        L63:
            androidx.recyclerview.widget.COUIBaseListPopupWindow_10 r0 = r4.mGapWorker
            r0.m4469a(r4)
        L68:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        GapWorker runnableC0721h;
        super.onDetachedFromWindow();
        AbstractC0690f abstractC0690f = this.mItemAnimator;
        if (abstractC0690f != null) {
            abstractC0690f.mo4133d();
        }
        stopScroll();
        this.mIsAttached = false;
        AbstractC0693i abstractC0693i = this.mLayout;
        if (abstractC0693i != null) {
            abstractC0693i.dispatchDetachedFromWindow(this, this.mRecycler);
        }
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        this.mViewInfoStore.m4567b();
        if (!ALLOW_THREAD_GAP_WORK || (runnableC0721h = this.mGapWorker) == null) {
            return;
        }
        runnableC0721h.m4471b(this);
        this.mGapWorker = null;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    void assertInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException("Cannot call this method unless RecyclerView is computing PlatformImplementations.kt_3 layout or scrolling" + exceptionLabel());
        }
        throw new IllegalStateException(str + exceptionLabel());
    }

    void assertNotInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing PlatformImplementations.kt_3 layout or scrolling" + exceptionLabel());
            }
            throw new IllegalStateException(str);
        }
        if (this.mDispatchScrollCounter > 0) {
            Log.w(TAG, "Cannot call this method in PlatformImplementations.kt_3 scroll callback. Scroll callbacks mightbe run during PlatformImplementations.kt_3 measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + exceptionLabel()));
        }
    }

    public void addOnItemTouchListener(InterfaceC0697m interfaceC0697m) {
        this.mOnItemTouchListeners.add(interfaceC0697m);
    }

    public void removeOnItemTouchListener(InterfaceC0697m interfaceC0697m) {
        this.mOnItemTouchListeners.remove(interfaceC0697m);
        if (this.mInterceptingOnItemTouchListener == interfaceC0697m) {
            this.mInterceptingOnItemTouchListener = null;
        }
    }

    private boolean dispatchToOnItemTouchListeners(MotionEvent motionEvent) {
        InterfaceC0697m interfaceC0697m = this.mInterceptingOnItemTouchListener;
        if (interfaceC0697m == null) {
            if (motionEvent.getAction() == 0) {
                return false;
            }
            return findInterceptingOnItemTouchListener(motionEvent);
        }
        interfaceC0697m.mo4165b(this, motionEvent);
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.mInterceptingOnItemTouchListener = null;
        }
        return true;
    }

    private boolean findInterceptingOnItemTouchListener(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.mOnItemTouchListeners.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            InterfaceC0697m interfaceC0697m = this.mOnItemTouchListeners.get(OplusGLSurfaceView_13);
            if (interfaceC0697m.mo4164a(this, motionEvent) && action != 3) {
                this.mInterceptingOnItemTouchListener = interfaceC0697m;
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.mLayoutSuppressed) {
            return false;
        }
        this.mInterceptingOnItemTouchListener = null;
        if (findInterceptingOnItemTouchListener(motionEvent)) {
            cancelScroll();
            return true;
        }
        AbstractC0693i abstractC0693i = this.mLayout;
        if (abstractC0693i == null) {
            return false;
        }
        boolean zCanScrollHorizontally = abstractC0693i.canScrollHorizontally();
        boolean zCanScrollVertically = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.mIgnoreMotionEventTillDown) {
                this.mIgnoreMotionEventTillDown = false;
            }
            this.mScrollPointerId = motionEvent.getPointerId(0);
            int x = (int) (motionEvent.getX() + 0.5f);
            this.mLastTouchX = x;
            this.mInitialTouchX = x;
            int y = (int) (motionEvent.getY() + 0.5f);
            this.mLastTouchY = y;
            this.mInitialTouchY = y;
            if (this.mScrollState == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                stopNestedScroll(1);
            }
            int[] iArr = this.mNestedOffsets;
            iArr[1] = 0;
            iArr[0] = 0;
            int OplusGLSurfaceView_13 = zCanScrollHorizontally ? 1 : 0;
            if (zCanScrollVertically) {
                OplusGLSurfaceView_13 |= 2;
            }
            startNestedScroll(OplusGLSurfaceView_13, 0);
        } else if (actionMasked == 1) {
            this.mVelocityTracker.clear();
            stopNestedScroll(0);
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
            if (iFindPointerIndex < 0) {
                Log.COUIBaseListPopupWindow_8(TAG, "Error processing scroll; pointer index for id_renamed " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x2 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y2 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            if (this.mScrollState != 1) {
                int i2 = x2 - this.mInitialTouchX;
                int i3 = y2 - this.mInitialTouchY;
                if (!zCanScrollHorizontally || Math.abs(i2) <= this.mTouchSlop) {
                    z = false;
                } else {
                    this.mLastTouchX = x2;
                    z = true;
                }
                if (zCanScrollVertically && Math.abs(i3) > this.mTouchSlop) {
                    this.mLastTouchY = y2;
                    z = true;
                }
                if (z) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            cancelScroll();
        } else if (actionMasked == 5) {
            this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
            int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.mLastTouchX = x3;
            this.mInitialTouchX = x3;
            int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.mLastTouchY = y3;
            this.mInitialTouchY = y3;
        } else if (actionMasked == 6) {
            onPointerUp(motionEvent);
        }
        return this.mScrollState == 1;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.mOnItemTouchListeners.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            this.mOnItemTouchListeners.get(OplusGLSurfaceView_13).mo4163a(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00df A[PHI: r0
      0x00df: PHI (r0v42 int) = (r0v31 int), (r0v46 int) binds: [B:41:0x00c8, B:45:0x00db] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f8  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 490
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private void resetScroll() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        stopNestedScroll(0);
        releaseGlows();
    }

    private void cancelScroll() {
        resetScroll();
        setScrollState(0);
    }

    private void onPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mScrollPointerId) {
            int OplusGLSurfaceView_13 = actionIndex == 0 ? 1 : 0;
            this.mScrollPointerId = motionEvent.getPointerId(OplusGLSurfaceView_13);
            int x = (int) (motionEvent.getX(OplusGLSurfaceView_13) + 0.5f);
            this.mLastTouchX = x;
            this.mInitialTouchX = x;
            int y = (int) (motionEvent.getY(OplusGLSurfaceView_13) + 0.5f);
            this.mLastTouchY = y;
            this.mInitialTouchY = y;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006c  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            androidx.recyclerview.widget.RecyclerView$OplusGLSurfaceView_13 r0 = r5.mLayout
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r0 = r5.mLayoutSuppressed
            if (r0 == 0) goto Lb
            return r1
        Lb:
            int r0 = r6.getAction()
            r2 = 8
            if (r0 != r2) goto L77
            int r0 = r6.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L3e
            androidx.recyclerview.widget.RecyclerView$OplusGLSurfaceView_13 r0 = r5.mLayout
            boolean r0 = r0.canScrollVertically()
            if (r0 == 0) goto L2c
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2d
        L2c:
            r0 = r2
        L2d:
            androidx.recyclerview.widget.RecyclerView$OplusGLSurfaceView_13 r3 = r5.mLayout
            boolean r3 = r3.canScrollHorizontally()
            if (r3 == 0) goto L3c
            r3 = 10
            float r3 = r6.getAxisValue(r3)
            goto L64
        L3c:
            r3 = r2
            goto L64
        L3e:
            int r0 = r6.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L62
            r0 = 26
            float r0 = r6.getAxisValue(r0)
            androidx.recyclerview.widget.RecyclerView$OplusGLSurfaceView_13 r3 = r5.mLayout
            boolean r3 = r3.canScrollVertically()
            if (r3 == 0) goto L57
            float r0 = -r0
            goto L3c
        L57:
            androidx.recyclerview.widget.RecyclerView$OplusGLSurfaceView_13 r3 = r5.mLayout
            boolean r3 = r3.canScrollHorizontally()
            if (r3 == 0) goto L62
            r3 = r0
            r0 = r2
            goto L64
        L62:
            r0 = r2
            r3 = r0
        L64:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L6c
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L77
        L6c:
            float r2 = r5.mScaledHorizontalScrollFactor
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.mScaledVerticalScrollFactor
            float r0 = r0 * r3
            int r0 = (int) r0
            r5.scrollByInternal(r2, r0, r6)
        L77:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        AbstractC0693i abstractC0693i = this.mLayout;
        if (abstractC0693i == null) {
            defaultOnMeasure(OplusGLSurfaceView_13, i2);
            return;
        }
        boolean z = false;
        if (abstractC0693i.isAutoMeasureEnabled()) {
            int mode = View.MeasureSpec.getMode(OplusGLSurfaceView_13);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.mLayout.onMeasure(this.mRecycler, this.mState, OplusGLSurfaceView_13, i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            if (z || this.mAdapter == null) {
                return;
            }
            if (this.mState.f4069d == 1) {
                dispatchLayoutStep1();
            }
            this.mLayout.setMeasureSpecs(OplusGLSurfaceView_13, i2);
            this.mState.f4074i = true;
            dispatchLayoutStep2();
            this.mLayout.setMeasuredDimensionFromChildren(OplusGLSurfaceView_13, i2);
            if (this.mLayout.shouldMeasureTwice()) {
                this.mLayout.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.mState.f4074i = true;
                dispatchLayoutStep2();
                this.mLayout.setMeasuredDimensionFromChildren(OplusGLSurfaceView_13, i2);
                return;
            }
            return;
        }
        if (this.mHasFixedSize) {
            this.mLayout.onMeasure(this.mRecycler, this.mState, OplusGLSurfaceView_13, i2);
            return;
        }
        if (this.mAdapterUpdateDuringMeasure) {
            startInterceptRequestLayout();
            onEnterLayoutOrScroll();
            processAdapterUpdatesAndSetAnimationFlags();
            onExitLayoutOrScroll();
            if (this.mState.f4076k) {
                this.mState.f4072g = true;
            } else {
                this.mAdapterHelper.m4367e();
                this.mState.f4072g = false;
            }
            this.mAdapterUpdateDuringMeasure = false;
            stopInterceptRequestLayout(false);
        } else if (this.mState.f4076k) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        AbstractC0685a abstractC0685a = this.mAdapter;
        if (abstractC0685a != null) {
            this.mState.f4070e = abstractC0685a.getItemCount();
        } else {
            this.mState.f4070e = 0;
        }
        startInterceptRequestLayout();
        this.mLayout.onMeasure(this.mRecycler, this.mState, OplusGLSurfaceView_13, i2);
        stopInterceptRequestLayout(false);
        this.mState.f4072g = false;
    }

    void defaultOnMeasure(int OplusGLSurfaceView_13, int i2) {
        setMeasuredDimension(AbstractC0693i.chooseSize(OplusGLSurfaceView_13, getPaddingLeft() + getPaddingRight(), ViewCompat.m2893l(this)), AbstractC0693i.chooseSize(i2, getPaddingTop() + getPaddingBottom(), ViewCompat.m2894m(this)));
    }

    @Override // android.view.View
    protected void onSizeChanged(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        super.onSizeChanged(OplusGLSurfaceView_13, i2, i3, i4);
        if (OplusGLSurfaceView_13 == i3 && i2 == i4) {
            return;
        }
        invalidateGlows();
    }

    public void setItemAnimator(AbstractC0690f abstractC0690f) {
        AbstractC0690f abstractC0690f2 = this.mItemAnimator;
        if (abstractC0690f2 != null) {
            abstractC0690f2.mo4133d();
            this.mItemAnimator.m4126a((AbstractC0690f.IntrinsicsJvm.kt_4) null);
        }
        this.mItemAnimator = abstractC0690f;
        AbstractC0690f abstractC0690f3 = this.mItemAnimator;
        if (abstractC0690f3 != null) {
            abstractC0690f3.m4126a(this.mItemAnimatorListener);
        }
    }

    void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    void onExitLayoutOrScroll() {
        onExitLayoutOrScroll(true);
    }

    void onExitLayoutOrScroll(boolean z) {
        this.mLayoutOrScrollCounter--;
        if (this.mLayoutOrScrollCounter < 1) {
            this.mLayoutOrScrollCounter = 0;
            if (z) {
                dispatchContentChangedIfNecessary();
                dispatchPendingImportantForAccessibilityChanges();
            }
        }
    }

    boolean isAccessibilityEnabled() {
        AccessibilityManager accessibilityManager = this.mAccessibilityManager;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    private void dispatchContentChangedIfNecessary() {
        int OplusGLSurfaceView_13 = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if (OplusGLSurfaceView_13 == 0 || !isAccessibilityEnabled()) {
            return;
        }
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
        accessibilityEventObtain.setEventType(2048);
        AccessibilityEventCompat.m2657a(accessibilityEventObtain, OplusGLSurfaceView_13);
        sendAccessibilityEventUnchecked(accessibilityEventObtain);
    }

    public boolean isComputingLayout() {
        return this.mLayoutOrScrollCounter > 0;
    }

    boolean shouldDeferAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (!isComputingLayout()) {
            return false;
        }
        int iM2656a = accessibilityEvent != null ? AccessibilityEventCompat.m2656a(accessibilityEvent) : 0;
        if (iM2656a == 0) {
            iM2656a = 0;
        }
        this.mEatenAccessibilityChangeFlags = iM2656a | this.mEatenAccessibilityChangeFlags;
        return true;
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (shouldDeferAccessibilityEvent(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    public AbstractC0690f getItemAnimator() {
        return this.mItemAnimator;
    }

    void postAnimationRunner() {
        if (this.mPostedAnimatorRunner || !this.mIsAttached) {
            return;
        }
        ViewCompat.m2857a(this, this.mItemAnimatorRunner);
        this.mPostedAnimatorRunner = true;
    }

    private boolean predictiveItemAnimationsEnabled() {
        return this.mItemAnimator != null && this.mLayout.supportsPredictiveItemAnimations();
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        if (this.mDataSetHasChangedAfterLayout) {
            this.mAdapterHelper.m4353a();
            if (this.mDispatchItemsChangedEvent) {
                this.mLayout.onItemsChanged(this);
            }
        }
        if (predictiveItemAnimationsEnabled()) {
            this.mAdapterHelper.m4361b();
        } else {
            this.mAdapterHelper.m4367e();
        }
        boolean z = false;
        boolean z2 = this.mItemsAddedOrRemoved || this.mItemsChanged;
        this.mState.f4075j = this.mFirstLayoutComplete && this.mItemAnimator != null && (this.mDataSetHasChangedAfterLayout || z2 || this.mLayout.mRequestedSimpleAnimations) && (!this.mDataSetHasChangedAfterLayout || this.mAdapter.hasStableIds());
        C0704t c0704t = this.mState;
        if (c0704t.f4075j && z2 && !this.mDataSetHasChangedAfterLayout && predictiveItemAnimationsEnabled()) {
            z = true;
        }
        c0704t.f4076k = z;
    }

    void dispatchLayout() {
        if (this.mAdapter == null) {
            Log.COUIBaseListPopupWindow_8(TAG, "No adapter attached; skipping layout");
            return;
        }
        if (this.mLayout == null) {
            Log.COUIBaseListPopupWindow_8(TAG, "No layout manager attached; skipping layout");
            return;
        }
        C0704t c0704t = this.mState;
        c0704t.f4074i = false;
        if (c0704t.f4069d == 1) {
            dispatchLayoutStep1();
            this.mLayout.setExactMeasureSpecsFrom(this);
            dispatchLayoutStep2();
        } else if (this.mAdapterHelper.m4368f() || this.mLayout.getWidth() != getWidth() || this.mLayout.getHeight() != getHeight()) {
            this.mLayout.setExactMeasureSpecsFrom(this);
            dispatchLayoutStep2();
        } else {
            this.mLayout.setExactMeasureSpecsFrom(this);
        }
        dispatchLayoutStep3();
    }

    private void saveFocusInfo() {
        int absoluteAdapterPosition;
        View focusedChild = (this.mPreserveFocusAfterLayout && hasFocus() && this.mAdapter != null) ? getFocusedChild() : null;
        AbstractC0707w abstractC0707wFindContainingViewHolder = focusedChild != null ? findContainingViewHolder(focusedChild) : null;
        if (abstractC0707wFindContainingViewHolder == null) {
            resetFocusInfo();
            return;
        }
        this.mState.f4078m = this.mAdapter.hasStableIds() ? abstractC0707wFindContainingViewHolder.getItemId() : -1L;
        C0704t c0704t = this.mState;
        if (this.mDataSetHasChangedAfterLayout) {
            absoluteAdapterPosition = -1;
        } else {
            absoluteAdapterPosition = abstractC0707wFindContainingViewHolder.isRemoved() ? abstractC0707wFindContainingViewHolder.mOldPosition : abstractC0707wFindContainingViewHolder.getAbsoluteAdapterPosition();
        }
        c0704t.f4077l = absoluteAdapterPosition;
        this.mState.f4079n = getDeepestFocusedViewWithId(abstractC0707wFindContainingViewHolder.itemView);
    }

    private void resetFocusInfo() {
        C0704t c0704t = this.mState;
        c0704t.f4078m = -1L;
        c0704t.f4077l = -1;
        c0704t.f4079n = -1;
    }

    private View findNextViewToFocus() {
        AbstractC0707w abstractC0707wFindViewHolderForAdapterPosition;
        int OplusGLSurfaceView_13 = this.mState.f4077l != -1 ? this.mState.f4077l : 0;
        int iM4230e = this.mState.m4230e();
        for (int i2 = OplusGLSurfaceView_13; i2 < iM4230e; i2++) {
            AbstractC0707w abstractC0707wFindViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i2);
            if (abstractC0707wFindViewHolderForAdapterPosition2 == null) {
                break;
            }
            if (abstractC0707wFindViewHolderForAdapterPosition2.itemView.hasFocusable()) {
                return abstractC0707wFindViewHolderForAdapterPosition2.itemView;
            }
        }
        int iMin = Math.min(iM4230e, OplusGLSurfaceView_13);
        do {
            iMin--;
            if (iMin < 0 || (abstractC0707wFindViewHolderForAdapterPosition = findViewHolderForAdapterPosition(iMin)) == null) {
                return null;
            }
        } while (!abstractC0707wFindViewHolderForAdapterPosition.itemView.hasFocusable());
        return abstractC0707wFindViewHolderForAdapterPosition.itemView;
    }

    private void recoverFocusFromState() {
        View viewFindViewById;
        if (!this.mPreserveFocusAfterLayout || this.mAdapter == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (IGNORE_DETACHED_FOCUSED_CHILD && (focusedChild.getParent() == null || !focusedChild.hasFocus())) {
                if (this.mChildHelper.m4384b() == 0) {
                    requestFocus();
                    return;
                }
            } else if (!this.mChildHelper.m4389c(focusedChild)) {
                return;
            }
        }
        View viewFindNextViewToFocus = null;
        AbstractC0707w abstractC0707wFindViewHolderForItemId = (this.mState.f4078m == -1 || !this.mAdapter.hasStableIds()) ? null : findViewHolderForItemId(this.mState.f4078m);
        if (abstractC0707wFindViewHolderForItemId == null || this.mChildHelper.m4389c(abstractC0707wFindViewHolderForItemId.itemView) || !abstractC0707wFindViewHolderForItemId.itemView.hasFocusable()) {
            if (this.mChildHelper.m4384b() > 0) {
                viewFindNextViewToFocus = findNextViewToFocus();
            }
        } else {
            viewFindNextViewToFocus = abstractC0707wFindViewHolderForItemId.itemView;
        }
        if (viewFindNextViewToFocus != null) {
            if (this.mState.f4079n == -1 || (viewFindViewById = viewFindNextViewToFocus.findViewById(this.mState.f4079n)) == null || !viewFindViewById.isFocusable()) {
                viewFindViewById = viewFindNextViewToFocus;
            }
            viewFindViewById.requestFocus();
        }
    }

    private int getDeepestFocusedViewWithId(View view) {
        int id_renamed = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id_renamed = view.getId();
            }
        }
        return id_renamed;
    }

    final void fillRemainingScrollValues(C0704t c0704t) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.mViewFlinger.f4083a;
            c0704t.f4080o = overScroller.getFinalX() - overScroller.getCurrX();
            c0704t.f4081p = overScroller.getFinalY() - overScroller.getCurrY();
        } else {
            c0704t.f4080o = 0;
            c0704t.f4081p = 0;
        }
    }

    private void dispatchLayoutStep1() {
        this.mState.m4224a(1);
        fillRemainingScrollValues(this.mState);
        this.mState.f4074i = false;
        startInterceptRequestLayout();
        this.mViewInfoStore.m4561a();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        saveFocusInfo();
        C0704t c0704t = this.mState;
        c0704t.f4073h = c0704t.f4075j && this.mItemsChanged;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        C0704t c0704t2 = this.mState;
        c0704t2.f4072g = c0704t2.f4076k;
        this.mState.f4070e = this.mAdapter.getItemCount();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.f4075j) {
            int iM4384b = this.mChildHelper.m4384b();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < iM4384b; OplusGLSurfaceView_13++) {
                AbstractC0707w childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m4386b(OplusGLSurfaceView_13));
                if (!childViewHolderInt.shouldIgnore() && (!childViewHolderInt.isInvalid() || this.mAdapter.hasStableIds())) {
                    this.mViewInfoStore.m4563a(childViewHolderInt, this.mItemAnimator.m4123a(this.mState, childViewHolderInt, AbstractC0690f.m4121e(childViewHolderInt), childViewHolderInt.getUnmodifiedPayloads()));
                    if (this.mState.f4073h && childViewHolderInt.isUpdated() && !childViewHolderInt.isRemoved() && !childViewHolderInt.shouldIgnore() && !childViewHolderInt.isInvalid()) {
                        this.mViewInfoStore.m4562a(getChangedHolderKey(childViewHolderInt), childViewHolderInt);
                    }
                }
            }
        }
        if (this.mState.f4076k) {
            saveOldPositions();
            boolean z = this.mState.f4071f;
            C0704t c0704t3 = this.mState;
            c0704t3.f4071f = false;
            this.mLayout.onLayoutChildren(this.mRecycler, c0704t3);
            this.mState.f4071f = z;
            for (int i2 = 0; i2 < this.mChildHelper.m4384b(); i2++) {
                AbstractC0707w childViewHolderInt2 = getChildViewHolderInt(this.mChildHelper.m4386b(i2));
                if (!childViewHolderInt2.shouldIgnore() && !this.mViewInfoStore.m4571d(childViewHolderInt2)) {
                    int iM4121e = AbstractC0690f.m4121e(childViewHolderInt2);
                    boolean zHasAnyOfTheFlags = childViewHolderInt2.hasAnyOfTheFlags(8192);
                    if (!zHasAnyOfTheFlags) {
                        iM4121e |= 4096;
                    }
                    AbstractC0690f.IntrinsicsJvm.kt_3 cVarM4123a = this.mItemAnimator.m4123a(this.mState, childViewHolderInt2, iM4121e, childViewHolderInt2.getUnmodifiedPayloads());
                    if (zHasAnyOfTheFlags) {
                        recordAnimationInfoIfBouncedHiddenView(childViewHolderInt2, cVarM4123a);
                    } else {
                        this.mViewInfoStore.m4568b(childViewHolderInt2, cVarM4123a);
                    }
                }
            }
            clearOldPositions();
        } else {
            clearOldPositions();
        }
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mState.f4069d = 2;
    }

    private void dispatchLayoutStep2() {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.m4224a(6);
        this.mAdapterHelper.m4367e();
        this.mState.f4070e = this.mAdapter.getItemCount();
        this.mState.f4068c = 0;
        if (this.mPendingSavedState != null && this.mAdapter.canRestoreState()) {
            if (this.mPendingSavedState.mLayoutState != null) {
                this.mLayout.onRestoreInstanceState(this.mPendingSavedState.mLayoutState);
            }
            this.mPendingSavedState = null;
        }
        C0704t c0704t = this.mState;
        c0704t.f4072g = false;
        this.mLayout.onLayoutChildren(this.mRecycler, c0704t);
        C0704t c0704t2 = this.mState;
        c0704t2.f4071f = false;
        c0704t2.f4075j = c0704t2.f4075j && this.mItemAnimator != null;
        this.mState.f4069d = 4;
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
    }

    private void dispatchLayoutStep3() {
        this.mState.m4224a(4);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        C0704t c0704t = this.mState;
        c0704t.f4069d = 1;
        if (c0704t.f4075j) {
            for (int iM4384b = this.mChildHelper.m4384b() - 1; iM4384b >= 0; iM4384b--) {
                AbstractC0707w childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m4386b(iM4384b));
                if (!childViewHolderInt.shouldIgnore()) {
                    long changedHolderKey = getChangedHolderKey(childViewHolderInt);
                    AbstractC0690f.IntrinsicsJvm.kt_3 cVarM4122a = this.mItemAnimator.m4122a(this.mState, childViewHolderInt);
                    AbstractC0707w abstractC0707wM4560a = this.mViewInfoStore.m4560a(changedHolderKey);
                    if (abstractC0707wM4560a != null && !abstractC0707wM4560a.shouldIgnore()) {
                        boolean zM4565a = this.mViewInfoStore.m4565a(abstractC0707wM4560a);
                        boolean zM4565a2 = this.mViewInfoStore.m4565a(childViewHolderInt);
                        if (zM4565a && abstractC0707wM4560a == childViewHolderInt) {
                            this.mViewInfoStore.m4570c(childViewHolderInt, cVarM4122a);
                        } else {
                            AbstractC0690f.IntrinsicsJvm.kt_3 cVarM4566b = this.mViewInfoStore.m4566b(abstractC0707wM4560a);
                            this.mViewInfoStore.m4570c(childViewHolderInt, cVarM4122a);
                            AbstractC0690f.IntrinsicsJvm.kt_3 cVarM4569c = this.mViewInfoStore.m4569c(childViewHolderInt);
                            if (cVarM4566b == null) {
                                handleMissingPreInfoForChangeError(changedHolderKey, childViewHolderInt, abstractC0707wM4560a);
                            } else {
                                animateChange(abstractC0707wM4560a, childViewHolderInt, cVarM4566b, cVarM4569c, zM4565a, zM4565a2);
                            }
                        }
                    } else {
                        this.mViewInfoStore.m4570c(childViewHolderInt, cVarM4122a);
                    }
                }
            }
            this.mViewInfoStore.m4564a(this.mViewInfoProcessCallback);
        }
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        C0704t c0704t2 = this.mState;
        c0704t2.f4067b = c0704t2.f4070e;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        C0704t c0704t3 = this.mState;
        c0704t3.f4075j = false;
        c0704t3.f4076k = false;
        this.mLayout.mRequestedSimpleAnimations = false;
        if (this.mRecycler.f4050b != null) {
            this.mRecycler.f4050b.clear();
        }
        if (this.mLayout.mPrefetchMaxObservedInInitialPrefetch) {
            AbstractC0693i abstractC0693i = this.mLayout;
            abstractC0693i.mPrefetchMaxCountObserved = 0;
            abstractC0693i.mPrefetchMaxObservedInInitialPrefetch = false;
            this.mRecycler.m4197b();
        }
        this.mLayout.onLayoutCompleted(this.mState);
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mViewInfoStore.m4561a();
        int[] iArr = this.mMinMaxLayoutPositions;
        if (didChildRangeChange(iArr[0], iArr[1])) {
            dispatchOnScrolled(0, 0);
        }
        recoverFocusFromState();
        resetFocusInfo();
    }

    private void handleMissingPreInfoForChangeError(long OplusGLSurfaceView_15, AbstractC0707w abstractC0707w, AbstractC0707w abstractC0707w2) {
        int iM4384b = this.mChildHelper.m4384b();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < iM4384b; OplusGLSurfaceView_13++) {
            AbstractC0707w childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m4386b(OplusGLSurfaceView_13));
            if (childViewHolderInt != abstractC0707w && getChangedHolderKey(childViewHolderInt) == OplusGLSurfaceView_15) {
                AbstractC0685a abstractC0685a = this.mAdapter;
                if (abstractC0685a != null && abstractC0685a.hasStableIds()) {
                    throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\OplusGLSurfaceView_11 ViewHolder 1:" + childViewHolderInt + " \OplusGLSurfaceView_11 View Holder 2:" + abstractC0707w + exceptionLabel());
                }
                throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\OplusGLSurfaceView_11 ViewHolder 1:" + childViewHolderInt + " \OplusGLSurfaceView_11 View Holder 2:" + abstractC0707w + exceptionLabel());
            }
        }
        Log.COUIBaseListPopupWindow_8(TAG, "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + abstractC0707w2 + " cannot be found but it is necessary for " + abstractC0707w + exceptionLabel());
    }

    void recordAnimationInfoIfBouncedHiddenView(AbstractC0707w abstractC0707w, AbstractC0690f.IntrinsicsJvm.kt_3 cVar) {
        abstractC0707w.setFlags(0, 8192);
        if (this.mState.f4073h && abstractC0707w.isUpdated() && !abstractC0707w.isRemoved() && !abstractC0707w.shouldIgnore()) {
            this.mViewInfoStore.m4562a(getChangedHolderKey(abstractC0707w), abstractC0707w);
        }
        this.mViewInfoStore.m4563a(abstractC0707w, cVar);
    }

    private void findMinMaxChildLayoutPositions(int[] iArr) {
        int iM4384b = this.mChildHelper.m4384b();
        if (iM4384b == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int OplusGLSurfaceView_13 = Integer.MIN_VALUE;
        int i2 = Integer.MAX_VALUE;
        for (int i3 = 0; i3 < iM4384b; i3++) {
            AbstractC0707w childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m4386b(i3));
            if (!childViewHolderInt.shouldIgnore()) {
                int layoutPosition = childViewHolderInt.getLayoutPosition();
                if (layoutPosition < i2) {
                    i2 = layoutPosition;
                }
                if (layoutPosition > OplusGLSurfaceView_13) {
                    OplusGLSurfaceView_13 = layoutPosition;
                }
            }
        }
        iArr[0] = i2;
        iArr[1] = OplusGLSurfaceView_13;
    }

    private boolean didChildRangeChange(int OplusGLSurfaceView_13, int i2) {
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        int[] iArr = this.mMinMaxLayoutPositions;
        return (iArr[0] == OplusGLSurfaceView_13 && iArr[1] == i2) ? false : true;
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z) {
        AbstractC0707w childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.isTmpDetached()) {
                childViewHolderInt.clearTmpDetachFlag();
            } else if (!childViewHolderInt.shouldIgnore()) {
                throw new IllegalArgumentException("Called removeDetachedView with PlatformImplementations.kt_3 view which is not flagged as tmp detached." + childViewHolderInt + exceptionLabel());
            }
        }
        view.clearAnimation();
        dispatchChildDetached(view);
        super.removeDetachedView(view, z);
    }

    long getChangedHolderKey(AbstractC0707w abstractC0707w) {
        return this.mAdapter.hasStableIds() ? abstractC0707w.getItemId() : abstractC0707w.mPosition;
    }

    void animateAppearance(AbstractC0707w abstractC0707w, AbstractC0690f.IntrinsicsJvm.kt_3 cVar, AbstractC0690f.IntrinsicsJvm.kt_3 cVar2) {
        abstractC0707w.setIsRecyclable(false);
        if (this.mItemAnimator.mo4131b(abstractC0707w, cVar, cVar2)) {
            postAnimationRunner();
        }
    }

    void animateDisappearance(AbstractC0707w abstractC0707w, AbstractC0690f.IntrinsicsJvm.kt_3 cVar, AbstractC0690f.IntrinsicsJvm.kt_3 cVar2) {
        addAnimatingView(abstractC0707w);
        abstractC0707w.setIsRecyclable(false);
        if (this.mItemAnimator.mo4127a(abstractC0707w, cVar, cVar2)) {
            postAnimationRunner();
        }
    }

    private void animateChange(AbstractC0707w abstractC0707w, AbstractC0707w abstractC0707w2, AbstractC0690f.IntrinsicsJvm.kt_3 cVar, AbstractC0690f.IntrinsicsJvm.kt_3 cVar2, boolean z, boolean z2) {
        abstractC0707w.setIsRecyclable(false);
        if (z) {
            addAnimatingView(abstractC0707w);
        }
        if (abstractC0707w != abstractC0707w2) {
            if (z2) {
                addAnimatingView(abstractC0707w2);
            }
            abstractC0707w.mShadowedHolder = abstractC0707w2;
            addAnimatingView(abstractC0707w);
            this.mRecycler.m4205c(abstractC0707w);
            abstractC0707w2.setIsRecyclable(false);
            abstractC0707w2.mShadowingHolder = abstractC0707w;
        }
        if (this.mItemAnimator.mo4128a(abstractC0707w, abstractC0707w2, cVar, cVar2)) {
            postAnimationRunner();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        TraceCompat.m2449a(TRACE_ON_LAYOUT_TAG);
        dispatchLayout();
        TraceCompat.m2448a();
        this.mFirstLayoutComplete = true;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mInterceptRequestLayoutDepth == 0 && !this.mLayoutSuppressed) {
            super.requestLayout();
        } else {
            this.mLayoutWasDefered = true;
        }
    }

    void markItemDecorInsetsDirty() {
        int iM4387c = this.mChildHelper.m4387c();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < iM4387c; OplusGLSurfaceView_13++) {
            ((C0694j) this.mChildHelper.m4390d(OplusGLSurfaceView_13).getLayoutParams()).f4041e = true;
        }
        this.mRecycler.m4216j();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z;
        boolean z2;
        super.draw(canvas);
        int size = this.mItemDecorations.size();
        boolean z3 = false;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            this.mItemDecorations.get(OplusGLSurfaceView_13).onDrawOver(canvas, this, this.mState);
        }
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.mClipToPadding ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.mLeftGlow;
            z = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.mClipToPadding) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.mTopGlow;
            z |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.mRightGlow;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.mClipToPadding ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            EdgeEffect edgeEffect6 = this.mRightGlow;
            z |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.mBottomGlow;
        if (edgeEffect7 == null || edgeEffect7.isFinished()) {
            z2 = z;
        } else {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.mClipToPadding) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.mBottomGlow;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z3 = true;
            }
            z2 = z3 | z;
            canvas.restoreToCount(iSave4);
        }
        if (!z2 && this.mItemAnimator != null && this.mItemDecorations.size() > 0 && this.mItemAnimator.mo4130b()) {
            z2 = true;
        }
        if (z2) {
            ViewCompat.m2881e(this);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.mItemDecorations.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            this.mItemDecorations.get(OplusGLSurfaceView_13).onDraw(canvas, this, this.mState);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof C0694j) && this.mLayout.checkLayoutParams((C0694j) layoutParams);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        AbstractC0693i abstractC0693i = this.mLayout;
        if (abstractC0693i == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
        }
        return abstractC0693i.generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        AbstractC0693i abstractC0693i = this.mLayout;
        if (abstractC0693i == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
        }
        return abstractC0693i.generateLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        AbstractC0693i abstractC0693i = this.mLayout;
        if (abstractC0693i == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
        }
        return abstractC0693i.generateLayoutParams(layoutParams);
    }

    public boolean isAnimating() {
        AbstractC0690f abstractC0690f = this.mItemAnimator;
        return abstractC0690f != null && abstractC0690f.mo4130b();
    }

    void saveOldPositions() {
        int iM4387c = this.mChildHelper.m4387c();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < iM4387c; OplusGLSurfaceView_13++) {
            AbstractC0707w childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m4390d(OplusGLSurfaceView_13));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.saveOldPosition();
            }
        }
    }

    void clearOldPositions() {
        int iM4387c = this.mChildHelper.m4387c();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < iM4387c; OplusGLSurfaceView_13++) {
            AbstractC0707w childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m4390d(OplusGLSurfaceView_13));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.clearOldPosition();
            }
        }
        this.mRecycler.m4215i();
    }

    void offsetPositionRecordsForMove(int OplusGLSurfaceView_13, int i2) {
        int i3;
        int i4;
        int i5;
        int iM4387c = this.mChildHelper.m4387c();
        if (OplusGLSurfaceView_13 < i2) {
            i3 = i2;
            i5 = -1;
            i4 = OplusGLSurfaceView_13;
        } else {
            i3 = OplusGLSurfaceView_13;
            i4 = i2;
            i5 = 1;
        }
        for (int i6 = 0; i6 < iM4387c; i6++) {
            AbstractC0707w childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m4390d(i6));
            if (childViewHolderInt != null && childViewHolderInt.mPosition >= i4 && childViewHolderInt.mPosition <= i3) {
                if (childViewHolderInt.mPosition == OplusGLSurfaceView_13) {
                    childViewHolderInt.offsetPosition(i2 - OplusGLSurfaceView_13, false);
                } else {
                    childViewHolderInt.offsetPosition(i5, false);
                }
                this.mState.f4071f = true;
            }
        }
        this.mRecycler.m4187a(OplusGLSurfaceView_13, i2);
        requestLayout();
    }

    void offsetPositionRecordsForInsert(int OplusGLSurfaceView_13, int i2) {
        int iM4387c = this.mChildHelper.m4387c();
        for (int i3 = 0; i3 < iM4387c; i3++) {
            AbstractC0707w childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m4390d(i3));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= OplusGLSurfaceView_13) {
                childViewHolderInt.offsetPosition(i2, false);
                this.mState.f4071f = true;
            }
        }
        this.mRecycler.m4198b(OplusGLSurfaceView_13, i2);
        requestLayout();
    }

    void offsetPositionRecordsForRemove(int OplusGLSurfaceView_13, int i2, boolean z) {
        int i3 = OplusGLSurfaceView_13 + i2;
        int iM4387c = this.mChildHelper.m4387c();
        for (int i4 = 0; i4 < iM4387c; i4++) {
            AbstractC0707w childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m4390d(i4));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                if (childViewHolderInt.mPosition >= i3) {
                    childViewHolderInt.offsetPosition(-i2, z);
                    this.mState.f4071f = true;
                } else if (childViewHolderInt.mPosition >= OplusGLSurfaceView_13) {
                    childViewHolderInt.flagRemovedAndOffsetPosition(OplusGLSurfaceView_13 - 1, -i2, z);
                    this.mState.f4071f = true;
                }
            }
        }
        this.mRecycler.m4188a(OplusGLSurfaceView_13, i2, z);
        requestLayout();
    }

    void viewRangeUpdate(int OplusGLSurfaceView_13, int i2, Object obj) {
        int iM4387c = this.mChildHelper.m4387c();
        int i3 = OplusGLSurfaceView_13 + i2;
        for (int i4 = 0; i4 < iM4387c; i4++) {
            View viewM4390d = this.mChildHelper.m4390d(i4);
            AbstractC0707w childViewHolderInt = getChildViewHolderInt(viewM4390d);
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= OplusGLSurfaceView_13 && childViewHolderInt.mPosition < i3) {
                childViewHolderInt.addFlags(2);
                childViewHolderInt.addChangePayload(obj);
                ((C0694j) viewM4390d.getLayoutParams()).f4041e = true;
            }
        }
        this.mRecycler.m4203c(OplusGLSurfaceView_13, i2);
    }

    boolean canReuseUpdatedViewHolder(AbstractC0707w abstractC0707w) {
        AbstractC0690f abstractC0690f = this.mItemAnimator;
        return abstractC0690f == null || abstractC0690f.mo4129a(abstractC0707w, abstractC0707w.getUnmodifiedPayloads());
    }

    void processDataSetCompletelyChanged(boolean z) {
        this.mDispatchItemsChangedEvent = z | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        markKnownViewsInvalid();
    }

    void markKnownViewsInvalid() {
        int iM4387c = this.mChildHelper.m4387c();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < iM4387c; OplusGLSurfaceView_13++) {
            AbstractC0707w childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m4390d(OplusGLSurfaceView_13));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.addFlags(6);
            }
        }
        markItemDecorInsetsDirty();
        this.mRecycler.m4214h();
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() == 0) {
            return;
        }
        AbstractC0693i abstractC0693i = this.mLayout;
        if (abstractC0693i != null) {
            abstractC0693i.assertNotInLayoutOrScroll("Cannot invalidate item decorations during PlatformImplementations.kt_3 scroll or layout");
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.mPreserveFocusAfterLayout = z;
    }

    public AbstractC0707w getChildViewHolder(View view) {
        ViewParent parent = view.getParent();
        if (parent != null && parent != this) {
            throw new IllegalArgumentException("View " + view + " is not PlatformImplementations.kt_3 direct child of " + this);
        }
        return getChildViewHolderInt(view);
    }

    public View findContainingItemView(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public AbstractC0707w findContainingViewHolder(View view) {
        View viewFindContainingItemView = findContainingItemView(view);
        if (viewFindContainingItemView == null) {
            return null;
        }
        return getChildViewHolder(viewFindContainingItemView);
    }

    static AbstractC0707w getChildViewHolderInt(View view) {
        if (view == null) {
            return null;
        }
        return ((C0694j) view.getLayoutParams()).f4039c;
    }

    @Deprecated
    public int getChildPosition(View view) {
        return getChildAdapterPosition(view);
    }

    public int getChildAdapterPosition(View view) {
        AbstractC0707w childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getAbsoluteAdapterPosition();
        }
        return -1;
    }

    public int getChildLayoutPosition(View view) {
        AbstractC0707w childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getLayoutPosition();
        }
        return -1;
    }

    public long getChildItemId(View view) {
        AbstractC0707w childViewHolderInt;
        AbstractC0685a abstractC0685a = this.mAdapter;
        if (abstractC0685a == null || !abstractC0685a.hasStableIds() || (childViewHolderInt = getChildViewHolderInt(view)) == null) {
            return -1L;
        }
        return childViewHolderInt.getItemId();
    }

    @Deprecated
    public AbstractC0707w findViewHolderForPosition(int OplusGLSurfaceView_13) {
        return findViewHolderForPosition(OplusGLSurfaceView_13, false);
    }

    public AbstractC0707w findViewHolderForLayoutPosition(int OplusGLSurfaceView_13) {
        return findViewHolderForPosition(OplusGLSurfaceView_13, false);
    }

    public AbstractC0707w findViewHolderForAdapterPosition(int OplusGLSurfaceView_13) {
        AbstractC0707w abstractC0707w = null;
        if (this.mDataSetHasChangedAfterLayout) {
            return null;
        }
        int iM4387c = this.mChildHelper.m4387c();
        for (int i2 = 0; i2 < iM4387c; i2++) {
            AbstractC0707w childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m4390d(i2));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && getAdapterPositionInRecyclerView(childViewHolderInt) == OplusGLSurfaceView_13) {
                if (!this.mChildHelper.m4389c(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                abstractC0707w = childViewHolderInt;
            }
        }
        return abstractC0707w;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    androidx.recyclerview.widget.RecyclerView.AbstractC0707w findViewHolderForPosition(int r6, boolean r7) {
        /*
            r5 = this;
            androidx.recyclerview.widget.IntrinsicsJvm.kt_5 r0 = r5.mChildHelper
            int r0 = r0.m4387c()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L3a
            androidx.recyclerview.widget.IntrinsicsJvm.kt_5 r3 = r5.mChildHelper
            android.view.View r3 = r3.m4390d(r2)
            androidx.recyclerview.widget.RecyclerView$w r3 = getChildViewHolderInt(r3)
            if (r3 == 0) goto L37
            boolean r4 = r3.isRemoved()
            if (r4 != 0) goto L37
            if (r7 == 0) goto L23
            int r4 = r3.mPosition
            if (r4 == r6) goto L2a
            goto L37
        L23:
            int r4 = r3.getLayoutPosition()
            if (r4 == r6) goto L2a
            goto L37
        L2a:
            androidx.recyclerview.widget.IntrinsicsJvm.kt_5 r1 = r5.mChildHelper
            android.view.View r4 = r3.itemView
            boolean r1 = r1.m4389c(r4)
            if (r1 == 0) goto L36
            r1 = r3
            goto L37
        L36:
            return r3
        L37:
            int r2 = r2 + 1
            goto L8
        L3a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.findViewHolderForPosition(int, boolean):androidx.recyclerview.widget.RecyclerView$w");
    }

    public AbstractC0707w findViewHolderForItemId(long OplusGLSurfaceView_15) {
        AbstractC0685a abstractC0685a = this.mAdapter;
        AbstractC0707w abstractC0707w = null;
        if (abstractC0685a != null && abstractC0685a.hasStableIds()) {
            int iM4387c = this.mChildHelper.m4387c();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < iM4387c; OplusGLSurfaceView_13++) {
                AbstractC0707w childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m4390d(OplusGLSurfaceView_13));
                if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && childViewHolderInt.getItemId() == OplusGLSurfaceView_15) {
                    if (!this.mChildHelper.m4389c(childViewHolderInt.itemView)) {
                        return childViewHolderInt;
                    }
                    abstractC0707w = childViewHolderInt;
                }
            }
        }
        return abstractC0707w;
    }

    public View findChildViewUnder(float COUIBaseListPopupWindow_12, float f2) {
        for (int iM4384b = this.mChildHelper.m4384b() - 1; iM4384b >= 0; iM4384b--) {
            View viewM4386b = this.mChildHelper.m4386b(iM4384b);
            float translationX = viewM4386b.getTranslationX();
            float translationY = viewM4386b.getTranslationY();
            if (COUIBaseListPopupWindow_12 >= viewM4386b.getLeft() + translationX && COUIBaseListPopupWindow_12 <= viewM4386b.getRight() + translationX && f2 >= viewM4386b.getTop() + translationY && f2 <= viewM4386b.getBottom() + translationY) {
                return viewM4386b;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long OplusGLSurfaceView_15) {
        return super.drawChild(canvas, view, OplusGLSurfaceView_15);
    }

    public void offsetChildrenVertical(int OplusGLSurfaceView_13) {
        int iM4384b = this.mChildHelper.m4384b();
        for (int i2 = 0; i2 < iM4384b; i2++) {
            this.mChildHelper.m4386b(i2).offsetTopAndBottom(OplusGLSurfaceView_13);
        }
    }

    public void offsetChildrenHorizontal(int OplusGLSurfaceView_13) {
        int iM4384b = this.mChildHelper.m4384b();
        for (int i2 = 0; i2 < iM4384b; i2++) {
            this.mChildHelper.m4386b(i2).offsetLeftAndRight(OplusGLSurfaceView_13);
        }
    }

    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        getDecoratedBoundsWithMarginsInt(view, rect);
    }

    static void getDecoratedBoundsWithMarginsInt(View view, Rect rect) {
        C0694j c0694j = (C0694j) view.getLayoutParams();
        Rect rect2 = c0694j.f4040d;
        rect.set((view.getLeft() - rect2.left) - c0694j.leftMargin, (view.getTop() - rect2.top) - c0694j.topMargin, view.getRight() + rect2.right + c0694j.rightMargin, view.getBottom() + rect2.bottom + c0694j.bottomMargin);
    }

    Rect getItemDecorInsetsForChild(View view) {
        C0694j c0694j = (C0694j) view.getLayoutParams();
        if (!c0694j.f4041e) {
            return c0694j.f4040d;
        }
        if (this.mState.m4226a() && (c0694j.m4156e() || c0694j.m4154c())) {
            return c0694j.f4040d;
        }
        Rect rect = c0694j.f4040d;
        rect.set(0, 0, 0, 0);
        int size = this.mItemDecorations.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            this.mTempRect.set(0, 0, 0, 0);
            this.mItemDecorations.get(OplusGLSurfaceView_13).getItemOffsets(this.mTempRect, view, this, this.mState);
            rect.left += this.mTempRect.left;
            rect.top += this.mTempRect.top;
            rect.right += this.mTempRect.right;
            rect.bottom += this.mTempRect.bottom;
        }
        c0694j.f4041e = false;
        return rect;
    }

    void dispatchOnScrolled(int OplusGLSurfaceView_13, int i2) {
        this.mDispatchScrollCounter++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - OplusGLSurfaceView_13, scrollY - i2);
        onScrolled(OplusGLSurfaceView_13, i2);
        AbstractC0698n abstractC0698n = this.mScrollListener;
        if (abstractC0698n != null) {
            abstractC0698n.onScrolled(this, OplusGLSurfaceView_13, i2);
        }
        List<AbstractC0698n> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrolled(this, OplusGLSurfaceView_13, i2);
            }
        }
        this.mDispatchScrollCounter--;
    }

    void dispatchOnScrollStateChanged(int OplusGLSurfaceView_13) {
        AbstractC0693i abstractC0693i = this.mLayout;
        if (abstractC0693i != null) {
            abstractC0693i.onScrollStateChanged(OplusGLSurfaceView_13);
        }
        onScrollStateChanged(OplusGLSurfaceView_13);
        AbstractC0698n abstractC0698n = this.mScrollListener;
        if (abstractC0698n != null) {
            abstractC0698n.onScrollStateChanged(this, OplusGLSurfaceView_13);
        }
        List<AbstractC0698n> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrollStateChanged(this, OplusGLSurfaceView_13);
            }
        }
    }

    public boolean hasPendingAdapterUpdates() {
        return !this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout || this.mAdapterHelper.m4366d();
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$v */
    class RunnableC0706v implements Runnable {

        /* renamed from: PlatformImplementations.kt_3 */
        OverScroller f4083a;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private int f4086d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private int f4087e;

        /* renamed from: IntrinsicsJvm.kt_4 */
        Interpolator f4084b = RecyclerView.sQuinticInterpolator;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private boolean f4088f = false;

        /* renamed from: COUIBaseListPopupWindow_11 */
        private boolean f4089g = false;

        RunnableC0706v() {
            this.f4083a = new OverScroller(RecyclerView.this.getContext(), RecyclerView.sQuinticInterpolator);
        }

        @Override // java.lang.Runnable
        public void run() {
            int OplusGLSurfaceView_13;
            int i2;
            if (RecyclerView.this.mLayout == null) {
                m4238b();
                return;
            }
            this.f4089g = false;
            this.f4088f = true;
            RecyclerView.this.consumePendingUpdateOperations();
            OverScroller overScroller = this.f4083a;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i3 = currX - this.f4086d;
                int i4 = currY - this.f4087e;
                this.f4086d = currX;
                this.f4087e = currY;
                RecyclerView.this.mReusableIntPair[0] = 0;
                RecyclerView.this.mReusableIntPair[1] = 0;
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.dispatchNestedPreScroll(i3, i4, recyclerView.mReusableIntPair, null, 1)) {
                    i3 -= RecyclerView.this.mReusableIntPair[0];
                    i4 -= RecyclerView.this.mReusableIntPair[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.considerReleasingGlowsOnScroll(i3, i4);
                }
                if (RecyclerView.this.mAdapter != null) {
                    RecyclerView.this.mReusableIntPair[0] = 0;
                    RecyclerView.this.mReusableIntPair[1] = 0;
                    RecyclerView recyclerView2 = RecyclerView.this;
                    recyclerView2.scrollStep(i3, i4, recyclerView2.mReusableIntPair);
                    OplusGLSurfaceView_13 = RecyclerView.this.mReusableIntPair[0];
                    i2 = RecyclerView.this.mReusableIntPair[1];
                    i3 -= OplusGLSurfaceView_13;
                    i4 -= i2;
                    AbstractC0703s abstractC0703s = RecyclerView.this.mLayout.mSmoothScroller;
                    if (abstractC0703s != null && !abstractC0703s.isPendingInitialRun() && abstractC0703s.isRunning()) {
                        int iM4230e = RecyclerView.this.mState.m4230e();
                        if (iM4230e == 0) {
                            abstractC0703s.stop();
                        } else if (abstractC0703s.getTargetPosition() >= iM4230e) {
                            abstractC0703s.setTargetPosition(iM4230e - 1);
                            abstractC0703s.onAnimation(OplusGLSurfaceView_13, i2);
                        } else {
                            abstractC0703s.onAnimation(OplusGLSurfaceView_13, i2);
                        }
                    }
                } else {
                    OplusGLSurfaceView_13 = 0;
                    i2 = 0;
                }
                if (!RecyclerView.this.mItemDecorations.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView.this.mReusableIntPair[0] = 0;
                RecyclerView.this.mReusableIntPair[1] = 0;
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.dispatchNestedScroll(OplusGLSurfaceView_13, i2, i3, i4, null, 1, recyclerView3.mReusableIntPair);
                int i5 = i3 - RecyclerView.this.mReusableIntPair[0];
                int i6 = i4 - RecyclerView.this.mReusableIntPair[1];
                if (OplusGLSurfaceView_13 != 0 || i2 != 0) {
                    RecyclerView.this.dispatchOnScrolled(OplusGLSurfaceView_13, i2);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i5 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i6 != 0));
                AbstractC0703s abstractC0703s2 = RecyclerView.this.mLayout.mSmoothScroller;
                if (!(abstractC0703s2 != null && abstractC0703s2.isPendingInitialRun()) && z) {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i7 = i5 < 0 ? -currVelocity : i5 > 0 ? currVelocity : 0;
                        if (i6 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i6 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.absorbGlows(i7, currVelocity);
                    }
                    if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                        RecyclerView.this.mPrefetchRegistry.m4473a();
                    }
                } else {
                    m4235a();
                    if (RecyclerView.this.mGapWorker != null) {
                        RecyclerView.this.mGapWorker.m4470a(RecyclerView.this, OplusGLSurfaceView_13, i2);
                    }
                }
            }
            AbstractC0703s abstractC0703s3 = RecyclerView.this.mLayout.mSmoothScroller;
            if (abstractC0703s3 != null && abstractC0703s3.isPendingInitialRun()) {
                abstractC0703s3.onAnimation(0, 0);
            }
            this.f4088f = false;
            if (this.f4089g) {
                m4234c();
            } else {
                RecyclerView.this.setScrollState(0);
                RecyclerView.this.stopNestedScroll(1);
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m4235a() {
            if (this.f4088f) {
                this.f4089g = true;
            } else {
                m4234c();
            }
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        private void m4234c() {
            RecyclerView.this.removeCallbacks(this);
            ViewCompat.m2857a(RecyclerView.this, this);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m4236a(int OplusGLSurfaceView_13, int i2) {
            RecyclerView.this.setScrollState(2);
            this.f4087e = 0;
            this.f4086d = 0;
            if (this.f4084b != RecyclerView.sQuinticInterpolator) {
                this.f4084b = RecyclerView.sQuinticInterpolator;
                this.f4083a = new OverScroller(RecyclerView.this.getContext(), RecyclerView.sQuinticInterpolator);
            }
            this.f4083a.fling(0, 0, OplusGLSurfaceView_13, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            m4235a();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m4237a(int OplusGLSurfaceView_13, int i2, int i3, Interpolator interpolator) {
            if (i3 == Integer.MIN_VALUE) {
                i3 = m4233a(OplusGLSurfaceView_13, i2, 0, 0);
            }
            int i4 = i3;
            if (interpolator == null) {
                interpolator = RecyclerView.sQuinticInterpolator;
            }
            if (this.f4084b != interpolator) {
                this.f4084b = interpolator;
                this.f4083a = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.f4087e = 0;
            this.f4086d = 0;
            RecyclerView.this.setScrollState(2);
            this.f4083a.startScroll(0, 0, OplusGLSurfaceView_13, i2, i4);
            if (Build.VERSION.SDK_INT < 23) {
                this.f4083a.computeScrollOffset();
            }
            m4235a();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private float m4232a(float COUIBaseListPopupWindow_12) {
            return (float) Math.sin((COUIBaseListPopupWindow_12 - 0.5f) * 0.47123894f);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private int m4233a(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
            int iRound;
            int iAbs = Math.abs(OplusGLSurfaceView_13);
            int iAbs2 = Math.abs(i2);
            boolean z = iAbs > iAbs2;
            int iSqrt = (int) Math.sqrt((i3 * i3) + (i4 * i4));
            int iSqrt2 = (int) Math.sqrt((OplusGLSurfaceView_13 * OplusGLSurfaceView_13) + (i2 * i2));
            int width = z ? RecyclerView.this.getWidth() : RecyclerView.this.getHeight();
            int i5 = width / 2;
            float COUIBaseListPopupWindow_12 = width;
            float f2 = i5;
            float fM4232a = f2 + (m4232a(Math.min(1.0f, (iSqrt2 * 1.0f) / COUIBaseListPopupWindow_12)) * f2);
            if (iSqrt > 0) {
                iRound = Math.round(Math.abs(fM4232a / iSqrt) * 1000.0f) * 4;
            } else {
                if (!z) {
                    iAbs = iAbs2;
                }
                iRound = (int) (((iAbs / COUIBaseListPopupWindow_12) + 1.0f) * 300.0f);
            }
            return Math.min(iRound, 2000);
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m4238b() {
            RecyclerView.this.removeCallbacks(this);
            this.f4083a.abortAnimation();
        }
    }

    void repositionShadowingViews() {
        int iM4384b = this.mChildHelper.m4384b();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < iM4384b; OplusGLSurfaceView_13++) {
            View viewM4386b = this.mChildHelper.m4386b(OplusGLSurfaceView_13);
            AbstractC0707w childViewHolder = getChildViewHolder(viewM4386b);
            if (childViewHolder != null && childViewHolder.mShadowingHolder != null) {
                View view = childViewHolder.mShadowingHolder.itemView;
                int left = viewM4386b.getLeft();
                int top = viewM4386b.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$r */
    private class C0702r extends AbstractC0687c {
        C0702r() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0687c
        public void onChanged() {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            RecyclerView.this.mState.f4071f = true;
            RecyclerView.this.processDataSetCompletelyChanged(true);
            if (RecyclerView.this.mAdapterHelper.m4366d()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0687c
        public void onItemRangeChanged(int OplusGLSurfaceView_13, int i2, Object obj) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.m4359a(OplusGLSurfaceView_13, i2, obj)) {
                m4218a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0687c
        public void onItemRangeInserted(int OplusGLSurfaceView_13, int i2) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.m4362b(OplusGLSurfaceView_13, i2)) {
                m4218a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0687c
        public void onItemRangeRemoved(int OplusGLSurfaceView_13, int i2) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.m4365c(OplusGLSurfaceView_13, i2)) {
                m4218a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0687c
        public void onItemRangeMoved(int OplusGLSurfaceView_13, int i2, int i3) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.m4358a(OplusGLSurfaceView_13, i2, i3)) {
                m4218a();
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m4218a() {
            if (RecyclerView.POST_UPDATES_ON_ANIMATION && RecyclerView.this.mHasFixedSize && RecyclerView.this.mIsAttached) {
                RecyclerView recyclerView = RecyclerView.this;
                ViewCompat.m2857a(recyclerView, recyclerView.mUpdateChildViewsRunnable);
            } else {
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.mAdapterUpdateDuringMeasure = true;
                recyclerView2.requestLayout();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0687c
        public void onStateRestorationPolicyChanged() {
            AbstractC0685a abstractC0685a;
            if (RecyclerView.this.mPendingSavedState == null || (abstractC0685a = RecyclerView.this.mAdapter) == null || !abstractC0685a.canRestoreState()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$COUIBaseListPopupWindow_8 */
    public static class C0689e {
        /* renamed from: PlatformImplementations.kt_3 */
        protected EdgeEffect m4120a(RecyclerView recyclerView, int OplusGLSurfaceView_13) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$o */
    public static class C0699o {

        /* renamed from: PlatformImplementations.kt_3 */
        SparseArray<PlatformImplementations.kt_3> f4043a = new SparseArray<>();

        /* renamed from: IntrinsicsJvm.kt_4 */
        private int f4044b = 0;

        /* renamed from: androidx.recyclerview.widget.RecyclerView$o$PlatformImplementations.kt_3 */
        static class PlatformImplementations.kt_3 {

            /* renamed from: PlatformImplementations.kt_3 */
            final ArrayList<AbstractC0707w> f4045a = new ArrayList<>();

            /* renamed from: IntrinsicsJvm.kt_4 */
            int f4046b = 5;

            /* renamed from: IntrinsicsJvm.kt_3 */
            long f4047c = 0;

            /* renamed from: IntrinsicsJvm.kt_5 */
            long f4048d = 0;

            PlatformImplementations.kt_3() {
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m4169a() {
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f4043a.size(); OplusGLSurfaceView_13++) {
                this.f4043a.valueAt(OplusGLSurfaceView_13).f4045a.clear();
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public AbstractC0707w m4168a(int OplusGLSurfaceView_13) {
            PlatformImplementations.kt_3 aVar = this.f4043a.get(OplusGLSurfaceView_13);
            if (aVar == null || aVar.f4045a.isEmpty()) {
                return null;
            }
            ArrayList<AbstractC0707w> arrayList = aVar.f4045a;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!arrayList.get(size).isAttachedToTransitionOverlay()) {
                    return arrayList.remove(size);
                }
            }
            return null;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m4172a(AbstractC0707w abstractC0707w) {
            int itemViewType = abstractC0707w.getItemViewType();
            ArrayList<AbstractC0707w> arrayList = m4166b(itemViewType).f4045a;
            if (this.f4043a.get(itemViewType).f4046b <= arrayList.size()) {
                return;
            }
            abstractC0707w.resetInternal();
            arrayList.add(abstractC0707w);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        long m4167a(long OplusGLSurfaceView_15, long j2) {
            return OplusGLSurfaceView_15 == 0 ? j2 : ((OplusGLSurfaceView_15 / 4) * 3) + (j2 / 4);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m4170a(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
            PlatformImplementations.kt_3 aVarM4166b = m4166b(OplusGLSurfaceView_13);
            aVarM4166b.f4047c = m4167a(aVarM4166b.f4047c, OplusGLSurfaceView_15);
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        void m4175b(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
            PlatformImplementations.kt_3 aVarM4166b = m4166b(OplusGLSurfaceView_13);
            aVarM4166b.f4048d = m4167a(aVarM4166b.f4048d, OplusGLSurfaceView_15);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        boolean m4173a(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15, long j2) {
            long j3 = m4166b(OplusGLSurfaceView_13).f4047c;
            return j3 == 0 || OplusGLSurfaceView_15 + j3 < j2;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        boolean m4176b(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15, long j2) {
            long j3 = m4166b(OplusGLSurfaceView_13).f4048d;
            return j3 == 0 || OplusGLSurfaceView_15 + j3 < j2;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        void m4174b() {
            this.f4044b++;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        void m4177c() {
            this.f4044b--;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m4171a(AbstractC0685a abstractC0685a, AbstractC0685a abstractC0685a2, boolean z) {
            if (abstractC0685a != null) {
                m4177c();
            }
            if (!z && this.f4044b == 0) {
                m4169a();
            }
            if (abstractC0685a2 != null) {
                m4174b();
            }
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        private PlatformImplementations.kt_3 m4166b(int OplusGLSurfaceView_13) {
            PlatformImplementations.kt_3 aVar = this.f4043a.get(OplusGLSurfaceView_13);
            if (aVar != null) {
                return aVar;
            }
            PlatformImplementations.kt_3 aVar2 = new PlatformImplementations.kt_3();
            this.f4043a.put(OplusGLSurfaceView_13, aVar2);
            return aVar2;
        }
    }

    static RecyclerView findNestedRecyclerView(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            RecyclerView recyclerViewFindNestedRecyclerView = findNestedRecyclerView(viewGroup.getChildAt(OplusGLSurfaceView_13));
            if (recyclerViewFindNestedRecyclerView != null) {
                return recyclerViewFindNestedRecyclerView;
            }
        }
        return null;
    }

    static void clearNestedRecyclerViewIfNotNested(AbstractC0707w abstractC0707w) {
        if (abstractC0707w.mNestedRecyclerView != null) {
            RecyclerView recyclerView = abstractC0707w.mNestedRecyclerView.get();
            while (recyclerView != null) {
                if (recyclerView == abstractC0707w.itemView) {
                    return;
                }
                Object parent = recyclerView.getParent();
                recyclerView = parent instanceof View ? (View) parent : null;
            }
            abstractC0707w.mNestedRecyclerView = null;
        }
    }

    long getNanoTime() {
        if (ALLOW_THREAD_GAP_WORK) {
            return System.nanoTime();
        }
        return 0L;
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$p */
    public final class C0700p {

        /* renamed from: COUIBaseListPopupWindow_8 */
        C0699o f4053e;

        /* renamed from: OplusGLSurfaceView_13 */
        private AbstractC0705u f4057i;

        /* renamed from: PlatformImplementations.kt_3 */
        final ArrayList<AbstractC0707w> f4049a = new ArrayList<>();

        /* renamed from: IntrinsicsJvm.kt_4 */
        ArrayList<AbstractC0707w> f4050b = null;

        /* renamed from: IntrinsicsJvm.kt_3 */
        final ArrayList<AbstractC0707w> f4051c = new ArrayList<>();

        /* renamed from: COUIBaseListPopupWindow_11 */
        private final List<AbstractC0707w> f4055g = Collections.unmodifiableList(this.f4049a);

        /* renamed from: COUIBaseListPopupWindow_10 */
        private int f4056h = 2;

        /* renamed from: IntrinsicsJvm.kt_5 */
        int f4052d = 2;

        public C0700p() {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m4185a() {
            this.f4049a.clear();
            m4206d();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m4186a(int OplusGLSurfaceView_13) {
            this.f4056h = OplusGLSurfaceView_13;
            m4197b();
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        void m4197b() {
            this.f4052d = this.f4056h + (RecyclerView.this.mLayout != null ? RecyclerView.this.mLayout.mPrefetchMaxCountObserved : 0);
            for (int size = this.f4051c.size() - 1; size >= 0 && this.f4051c.size() > this.f4052d; size--) {
                m4207d(size);
            }
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public List<AbstractC0707w> m4202c() {
            return this.f4055g;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        boolean m4194a(AbstractC0707w abstractC0707w) {
            if (abstractC0707w.isRemoved()) {
                return RecyclerView.this.mState.m4226a();
            }
            if (abstractC0707w.mPosition < 0 || abstractC0707w.mPosition >= RecyclerView.this.mAdapter.getItemCount()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + abstractC0707w + RecyclerView.this.exceptionLabel());
            }
            if (RecyclerView.this.mState.m4226a() || RecyclerView.this.mAdapter.getItemViewType(abstractC0707w.mPosition) == abstractC0707w.getItemViewType()) {
                return !RecyclerView.this.mAdapter.hasStableIds() || abstractC0707w.getItemId() == RecyclerView.this.mAdapter.getItemId(abstractC0707w.mPosition);
            }
            return false;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private boolean m4179a(AbstractC0707w abstractC0707w, int OplusGLSurfaceView_13, int i2, long OplusGLSurfaceView_15) {
            abstractC0707w.mBindingAdapter = null;
            abstractC0707w.mOwnerRecyclerView = RecyclerView.this;
            int itemViewType = abstractC0707w.getItemViewType();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (OplusGLSurfaceView_15 != Long.MAX_VALUE && !this.f4053e.m4176b(itemViewType, nanoTime, OplusGLSurfaceView_15)) {
                return false;
            }
            RecyclerView.this.mAdapter.bindViewHolder(abstractC0707w, OplusGLSurfaceView_13);
            this.f4053e.m4175b(abstractC0707w.getItemViewType(), RecyclerView.this.getNanoTime() - nanoTime);
            m4180e(abstractC0707w);
            if (!RecyclerView.this.mState.m4226a()) {
                return true;
            }
            abstractC0707w.mPreLayoutPosition = i2;
            return true;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public int m4195b(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 >= 0 && OplusGLSurfaceView_13 < RecyclerView.this.mState.m4230e()) {
                return !RecyclerView.this.mState.m4226a() ? OplusGLSurfaceView_13 : RecyclerView.this.mAdapterHelper.m4360b(OplusGLSurfaceView_13);
            }
            throw new IndexOutOfBoundsException("invalid position " + OplusGLSurfaceView_13 + ". State item count is " + RecyclerView.this.mState.m4230e() + RecyclerView.this.exceptionLabel());
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public View m4201c(int OplusGLSurfaceView_13) {
            return m4182a(OplusGLSurfaceView_13, false);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        View m4182a(int OplusGLSurfaceView_13, boolean z) {
            return m4183a(OplusGLSurfaceView_13, z, Long.MAX_VALUE).itemView;
        }

        /* JADX WARN: Removed duplicated region for block: B:105:0x022b A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:107:0x022e  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x0182 A[PHI: r1 r4
          0x0182: PHI (r1v12 androidx.recyclerview.widget.RecyclerView$w) = (r1v11 androidx.recyclerview.widget.RecyclerView$w), (r1v31 androidx.recyclerview.widget.RecyclerView$w) binds: [B:28:0x005d, B:58:0x0101] A[DONT_GENERATE, DONT_INLINE]
          0x0182: PHI (r4v3 boolean) = (r4v2 boolean), (r4v7 boolean) binds: [B:28:0x005d, B:58:0x0101] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:81:0x01a3  */
        /* JADX WARN: Removed duplicated region for block: B:87:0x01d1  */
        /* JADX WARN: Removed duplicated region for block: B:98:0x0201  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x020f  */
        /* renamed from: PlatformImplementations.kt_3 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        androidx.recyclerview.widget.RecyclerView.AbstractC0707w m4183a(int r17, boolean r18, long r19) {
            /*
                Method dump skipped, instructions count: 618
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.C0700p.m4183a(int, boolean, long):androidx.recyclerview.widget.RecyclerView$w");
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        private void m4180e(AbstractC0707w abstractC0707w) {
            if (RecyclerView.this.isAccessibilityEnabled()) {
                View view = abstractC0707w.itemView;
                if (ViewCompat.m2883f(view) == 0) {
                    ViewCompat.m2867b(view, 1);
                }
                if (RecyclerView.this.mAccessibilityDelegate == null) {
                    return;
                }
                AccessibilityDelegateCompat itemDelegate = RecyclerView.this.mAccessibilityDelegate.getItemDelegate();
                if (itemDelegate instanceof RecyclerViewAccessibilityDelegate.PlatformImplementations.kt_3) {
                    ((RecyclerViewAccessibilityDelegate.PlatformImplementations.kt_3) itemDelegate).m4523a(view);
                }
                ViewCompat.m2854a(view, itemDelegate);
            }
        }

        /* renamed from: COUIBaseListPopupWindow_12 */
        private void m4181f(AbstractC0707w abstractC0707w) {
            if (abstractC0707w.itemView instanceof ViewGroup) {
                m4178a((ViewGroup) abstractC0707w.itemView, false);
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m4178a(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    m4178a((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                } else {
                    int visibility = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(visibility);
                }
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m4189a(View view) {
            AbstractC0707w childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (childViewHolderInt.isScrap()) {
                childViewHolderInt.unScrap();
            } else if (childViewHolderInt.wasReturnedFromScrap()) {
                childViewHolderInt.clearReturnedFromScrapFlag();
            }
            m4200b(childViewHolderInt);
            if (RecyclerView.this.mItemAnimator == null || childViewHolderInt.isRecyclable()) {
                return;
            }
            RecyclerView.this.mItemAnimator.mo4134d(childViewHolderInt);
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        void m4206d() {
            for (int size = this.f4051c.size() - 1; size >= 0; size--) {
                m4207d(size);
            }
            this.f4051c.clear();
            if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                RecyclerView.this.mPrefetchRegistry.m4473a();
            }
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        void m4207d(int OplusGLSurfaceView_13) {
            m4193a(this.f4051c.get(OplusGLSurfaceView_13), true);
            this.f4051c.remove(OplusGLSurfaceView_13);
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        void m4200b(AbstractC0707w abstractC0707w) {
            boolean z;
            if (abstractC0707w.isScrap() || abstractC0707w.itemView.getParent() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(abstractC0707w.isScrap());
                sb.append(" isAttached:");
                sb.append(abstractC0707w.itemView.getParent() != null);
                sb.append(RecyclerView.this.exceptionLabel());
                throw new IllegalArgumentException(sb.toString());
            }
            if (abstractC0707w.isTmpDetached()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + abstractC0707w + RecyclerView.this.exceptionLabel());
            }
            if (abstractC0707w.shouldIgnore()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.exceptionLabel());
            }
            boolean zDoesTransientStatePreventRecycling = abstractC0707w.doesTransientStatePreventRecycling();
            if ((RecyclerView.this.mAdapter != null && zDoesTransientStatePreventRecycling && RecyclerView.this.mAdapter.onFailedToRecycleView(abstractC0707w)) || abstractC0707w.isRecyclable()) {
                if (this.f4052d <= 0 || abstractC0707w.hasAnyOfTheFlags(526)) {
                    z = false;
                } else {
                    int size = this.f4051c.size();
                    if (size >= this.f4052d && size > 0) {
                        m4207d(0);
                        size--;
                    }
                    if (RecyclerView.ALLOW_THREAD_GAP_WORK && size > 0 && !RecyclerView.this.mPrefetchRegistry.m4476a(abstractC0707w.mPosition)) {
                        int OplusGLSurfaceView_13 = size - 1;
                        while (OplusGLSurfaceView_13 >= 0) {
                            if (!RecyclerView.this.mPrefetchRegistry.m4476a(this.f4051c.get(OplusGLSurfaceView_13).mPosition)) {
                                break;
                            } else {
                                OplusGLSurfaceView_13--;
                            }
                        }
                        size = OplusGLSurfaceView_13 + 1;
                    }
                    this.f4051c.add(size, abstractC0707w);
                    z = true;
                }
                if (!z) {
                    m4193a(abstractC0707w, true);
                    z = true;
                }
            } else {
                z = false;
            }
            RecyclerView.this.mViewInfoStore.m4574g(abstractC0707w);
            if (z || z || !zDoesTransientStatePreventRecycling) {
                return;
            }
            abstractC0707w.mBindingAdapter = null;
            abstractC0707w.mOwnerRecyclerView = null;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m4193a(AbstractC0707w abstractC0707w, boolean z) {
            RecyclerView.clearNestedRecyclerViewIfNotNested(abstractC0707w);
            View view = abstractC0707w.itemView;
            if (RecyclerView.this.mAccessibilityDelegate != null) {
                AccessibilityDelegateCompat itemDelegate = RecyclerView.this.mAccessibilityDelegate.getItemDelegate();
                ViewCompat.m2854a(view, itemDelegate instanceof RecyclerViewAccessibilityDelegate.PlatformImplementations.kt_3 ? ((RecyclerViewAccessibilityDelegate.PlatformImplementations.kt_3) itemDelegate).m4524b(view) : null);
            }
            if (z) {
                m4208d(abstractC0707w);
            }
            abstractC0707w.mBindingAdapter = null;
            abstractC0707w.mOwnerRecyclerView = null;
            m4213g().m4172a(abstractC0707w);
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        void m4199b(View view) {
            AbstractC0707w childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.mScrapContainer = null;
            childViewHolderInt.mInChangeScrap = false;
            childViewHolderInt.clearReturnedFromScrapFlag();
            m4200b(childViewHolderInt);
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        void m4204c(View view) {
            AbstractC0707w childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.hasAnyOfTheFlags(12) || !childViewHolderInt.isUpdated() || RecyclerView.this.canReuseUpdatedViewHolder(childViewHolderInt)) {
                if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !RecyclerView.this.mAdapter.hasStableIds()) {
                    throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.exceptionLabel());
                }
                childViewHolderInt.setScrapContainer(this, false);
                this.f4049a.add(childViewHolderInt);
                return;
            }
            if (this.f4050b == null) {
                this.f4050b = new ArrayList<>();
            }
            childViewHolderInt.setScrapContainer(this, true);
            this.f4050b.add(childViewHolderInt);
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        void m4205c(AbstractC0707w abstractC0707w) {
            if (abstractC0707w.mInChangeScrap) {
                this.f4050b.remove(abstractC0707w);
            } else {
                this.f4049a.remove(abstractC0707w);
            }
            abstractC0707w.mScrapContainer = null;
            abstractC0707w.mInChangeScrap = false;
            abstractC0707w.clearReturnedFromScrapFlag();
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        int m4209e() {
            return this.f4049a.size();
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        View m4210e(int OplusGLSurfaceView_13) {
            return this.f4049a.get(OplusGLSurfaceView_13).itemView;
        }

        /* renamed from: COUIBaseListPopupWindow_12 */
        void m4212f() {
            this.f4049a.clear();
            ArrayList<AbstractC0707w> arrayList = this.f4050b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        /* renamed from: COUIBaseListPopupWindow_12 */
        AbstractC0707w m4211f(int OplusGLSurfaceView_13) {
            int size;
            int iM4360b;
            ArrayList<AbstractC0707w> arrayList = this.f4050b;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    AbstractC0707w abstractC0707w = this.f4050b.get(i2);
                    if (!abstractC0707w.wasReturnedFromScrap() && abstractC0707w.getLayoutPosition() == OplusGLSurfaceView_13) {
                        abstractC0707w.addFlags(32);
                        return abstractC0707w;
                    }
                }
                if (RecyclerView.this.mAdapter.hasStableIds() && (iM4360b = RecyclerView.this.mAdapterHelper.m4360b(OplusGLSurfaceView_13)) > 0 && iM4360b < RecyclerView.this.mAdapter.getItemCount()) {
                    long itemId = RecyclerView.this.mAdapter.getItemId(iM4360b);
                    for (int i3 = 0; i3 < size; i3++) {
                        AbstractC0707w abstractC0707w2 = this.f4050b.get(i3);
                        if (!abstractC0707w2.wasReturnedFromScrap() && abstractC0707w2.getItemId() == itemId) {
                            abstractC0707w2.addFlags(32);
                            return abstractC0707w2;
                        }
                    }
                }
            }
            return null;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        AbstractC0707w m4196b(int OplusGLSurfaceView_13, boolean z) {
            View viewM4388c;
            int size = this.f4049a.size();
            for (int i2 = 0; i2 < size; i2++) {
                AbstractC0707w abstractC0707w = this.f4049a.get(i2);
                if (!abstractC0707w.wasReturnedFromScrap() && abstractC0707w.getLayoutPosition() == OplusGLSurfaceView_13 && !abstractC0707w.isInvalid() && (RecyclerView.this.mState.f4072g || !abstractC0707w.isRemoved())) {
                    abstractC0707w.addFlags(32);
                    return abstractC0707w;
                }
            }
            if (!z && (viewM4388c = RecyclerView.this.mChildHelper.m4388c(OplusGLSurfaceView_13)) != null) {
                AbstractC0707w childViewHolderInt = RecyclerView.getChildViewHolderInt(viewM4388c);
                RecyclerView.this.mChildHelper.m4393e(viewM4388c);
                int iM4385b = RecyclerView.this.mChildHelper.m4385b(viewM4388c);
                if (iM4385b == -1) {
                    throw new IllegalStateException("layout index should not be -1 after unhiding PlatformImplementations.kt_3 view:" + childViewHolderInt + RecyclerView.this.exceptionLabel());
                }
                RecyclerView.this.mChildHelper.m4392e(iM4385b);
                m4204c(viewM4388c);
                childViewHolderInt.addFlags(8224);
                return childViewHolderInt;
            }
            int size2 = this.f4051c.size();
            for (int i3 = 0; i3 < size2; i3++) {
                AbstractC0707w abstractC0707w2 = this.f4051c.get(i3);
                if (!abstractC0707w2.isInvalid() && abstractC0707w2.getLayoutPosition() == OplusGLSurfaceView_13 && !abstractC0707w2.isAttachedToTransitionOverlay()) {
                    if (!z) {
                        this.f4051c.remove(i3);
                    }
                    return abstractC0707w2;
                }
            }
            return null;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        AbstractC0707w m4184a(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, boolean z) {
            for (int size = this.f4049a.size() - 1; size >= 0; size--) {
                AbstractC0707w abstractC0707w = this.f4049a.get(size);
                if (abstractC0707w.getItemId() == OplusGLSurfaceView_15 && !abstractC0707w.wasReturnedFromScrap()) {
                    if (OplusGLSurfaceView_13 == abstractC0707w.getItemViewType()) {
                        abstractC0707w.addFlags(32);
                        if (abstractC0707w.isRemoved() && !RecyclerView.this.mState.m4226a()) {
                            abstractC0707w.setFlags(2, 14);
                        }
                        return abstractC0707w;
                    }
                    if (!z) {
                        this.f4049a.remove(size);
                        RecyclerView.this.removeDetachedView(abstractC0707w.itemView, false);
                        m4199b(abstractC0707w.itemView);
                    }
                }
            }
            int size2 = this.f4051c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                AbstractC0707w abstractC0707w2 = this.f4051c.get(size2);
                if (abstractC0707w2.getItemId() == OplusGLSurfaceView_15 && !abstractC0707w2.isAttachedToTransitionOverlay()) {
                    if (OplusGLSurfaceView_13 == abstractC0707w2.getItemViewType()) {
                        if (!z) {
                            this.f4051c.remove(size2);
                        }
                        return abstractC0707w2;
                    }
                    if (!z) {
                        m4207d(size2);
                        return null;
                    }
                }
            }
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        void m4208d(AbstractC0707w abstractC0707w) {
            if (RecyclerView.this.mRecyclerListener != null) {
                RecyclerView.this.mRecyclerListener.m4217a(abstractC0707w);
            }
            if (RecyclerView.this.mAdapter != null) {
                RecyclerView.this.mAdapter.onViewRecycled(abstractC0707w);
            }
            if (RecyclerView.this.mState != null) {
                RecyclerView.this.mViewInfoStore.m4574g(abstractC0707w);
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m4190a(AbstractC0685a abstractC0685a, AbstractC0685a abstractC0685a2, boolean z) {
            m4185a();
            m4213g().m4171a(abstractC0685a, abstractC0685a2, z);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m4187a(int OplusGLSurfaceView_13, int i2) {
            int i3;
            int i4;
            int i5;
            if (OplusGLSurfaceView_13 < i2) {
                i3 = i2;
                i4 = -1;
                i5 = OplusGLSurfaceView_13;
            } else {
                i3 = OplusGLSurfaceView_13;
                i4 = 1;
                i5 = i2;
            }
            int size = this.f4051c.size();
            for (int i6 = 0; i6 < size; i6++) {
                AbstractC0707w abstractC0707w = this.f4051c.get(i6);
                if (abstractC0707w != null && abstractC0707w.mPosition >= i5 && abstractC0707w.mPosition <= i3) {
                    if (abstractC0707w.mPosition == OplusGLSurfaceView_13) {
                        abstractC0707w.offsetPosition(i2 - OplusGLSurfaceView_13, false);
                    } else {
                        abstractC0707w.offsetPosition(i4, false);
                    }
                }
            }
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        void m4198b(int OplusGLSurfaceView_13, int i2) {
            int size = this.f4051c.size();
            for (int i3 = 0; i3 < size; i3++) {
                AbstractC0707w abstractC0707w = this.f4051c.get(i3);
                if (abstractC0707w != null && abstractC0707w.mPosition >= OplusGLSurfaceView_13) {
                    abstractC0707w.offsetPosition(i2, true);
                }
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m4188a(int OplusGLSurfaceView_13, int i2, boolean z) {
            int i3 = OplusGLSurfaceView_13 + i2;
            for (int size = this.f4051c.size() - 1; size >= 0; size--) {
                AbstractC0707w abstractC0707w = this.f4051c.get(size);
                if (abstractC0707w != null) {
                    if (abstractC0707w.mPosition >= i3) {
                        abstractC0707w.offsetPosition(-i2, z);
                    } else if (abstractC0707w.mPosition >= OplusGLSurfaceView_13) {
                        abstractC0707w.addFlags(8);
                        m4207d(size);
                    }
                }
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m4192a(AbstractC0705u abstractC0705u) {
            this.f4057i = abstractC0705u;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m4191a(C0699o c0699o) {
            C0699o c0699o2 = this.f4053e;
            if (c0699o2 != null) {
                c0699o2.m4177c();
            }
            this.f4053e = c0699o;
            if (this.f4053e == null || RecyclerView.this.getAdapter() == null) {
                return;
            }
            this.f4053e.m4174b();
        }

        /* renamed from: COUIBaseListPopupWindow_11 */
        C0699o m4213g() {
            if (this.f4053e == null) {
                this.f4053e = new C0699o();
            }
            return this.f4053e;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        void m4203c(int OplusGLSurfaceView_13, int i2) {
            int i3;
            int i4 = i2 + OplusGLSurfaceView_13;
            for (int size = this.f4051c.size() - 1; size >= 0; size--) {
                AbstractC0707w abstractC0707w = this.f4051c.get(size);
                if (abstractC0707w != null && (i3 = abstractC0707w.mPosition) >= OplusGLSurfaceView_13 && i3 < i4) {
                    abstractC0707w.addFlags(2);
                    m4207d(size);
                }
            }
        }

        /* renamed from: COUIBaseListPopupWindow_10 */
        void m4214h() {
            int size = this.f4051c.size();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                AbstractC0707w abstractC0707w = this.f4051c.get(OplusGLSurfaceView_13);
                if (abstractC0707w != null) {
                    abstractC0707w.addFlags(6);
                    abstractC0707w.addChangePayload(null);
                }
            }
            if (RecyclerView.this.mAdapter == null || !RecyclerView.this.mAdapter.hasStableIds()) {
                m4206d();
            }
        }

        /* renamed from: OplusGLSurfaceView_13 */
        void m4215i() {
            int size = this.f4051c.size();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                this.f4051c.get(OplusGLSurfaceView_13).clearOldPosition();
            }
            int size2 = this.f4049a.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.f4049a.get(i2).clearOldPosition();
            }
            ArrayList<AbstractC0707w> arrayList = this.f4050b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    this.f4050b.get(i3).clearOldPosition();
                }
            }
        }

        /* renamed from: OplusGLSurfaceView_15 */
        void m4216j() {
            int size = this.f4051c.size();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                C0694j c0694j = (C0694j) this.f4051c.get(OplusGLSurfaceView_13).itemView.getLayoutParams();
                if (c0694j != null) {
                    c0694j.f4041e = true;
                }
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$PlatformImplementations.kt_3 */
    public static abstract class AbstractC0685a<VH extends AbstractC0707w> {
        private final C0686b mObservable = new C0686b();
        private boolean mHasStableIds = false;
        private PlatformImplementations.kt_3 mStateRestorationPolicy = PlatformImplementations.kt_3.ALLOW;

        /* renamed from: androidx.recyclerview.widget.RecyclerView$PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
        public enum PlatformImplementations.kt_3 {
            ALLOW,
            PREVENT_WHEN_EMPTY,
            PREVENT
        }

        public int findRelativeAdapterPositionIn(AbstractC0685a<? extends AbstractC0707w> abstractC0685a, AbstractC0707w abstractC0707w, int OplusGLSurfaceView_13) {
            if (abstractC0685a == this) {
                return OplusGLSurfaceView_13;
            }
            return -1;
        }

        public abstract int getItemCount();

        public long getItemId(int OplusGLSurfaceView_13) {
            return -1L;
        }

        public int getItemViewType(int OplusGLSurfaceView_13) {
            return 0;
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        }

        public abstract void onBindViewHolder(VH vh, int OplusGLSurfaceView_13);

        public abstract VH onCreateViewHolder(ViewGroup viewGroup, int OplusGLSurfaceView_13);

        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        }

        public boolean onFailedToRecycleView(VH vh) {
            return false;
        }

        public void onViewAttachedToWindow(VH vh) {
        }

        public void onViewDetachedFromWindow(VH vh) {
        }

        public void onViewRecycled(VH vh) {
        }

        public void onBindViewHolder(VH vh, int OplusGLSurfaceView_13, List<Object> list) {
            onBindViewHolder(vh, OplusGLSurfaceView_13);
        }

        public final VH createViewHolder(ViewGroup viewGroup, int OplusGLSurfaceView_13) {
            try {
                TraceCompat.m2449a(RecyclerView.TRACE_CREATE_VIEW_TAG);
                VH vh = (VH) onCreateViewHolder(viewGroup, OplusGLSurfaceView_13);
                if (vh.itemView.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                vh.mItemViewType = OplusGLSurfaceView_13;
                return vh;
            } finally {
                TraceCompat.m2448a();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void bindViewHolder(VH vh, int OplusGLSurfaceView_13) {
            boolean z = vh.mBindingAdapter == null;
            if (z) {
                vh.mPosition = OplusGLSurfaceView_13;
                if (hasStableIds()) {
                    vh.mItemId = getItemId(OplusGLSurfaceView_13);
                }
                vh.setFlags(1, 519);
                TraceCompat.m2449a(RecyclerView.TRACE_BIND_VIEW_TAG);
            }
            vh.mBindingAdapter = this;
            onBindViewHolder(vh, OplusGLSurfaceView_13, vh.getUnmodifiedPayloads());
            if (z) {
                vh.clearPayload();
                ViewGroup.LayoutParams layoutParams = vh.itemView.getLayoutParams();
                if (layoutParams instanceof C0694j) {
                    ((C0694j) layoutParams).f4041e = true;
                }
                TraceCompat.m2448a();
            }
        }

        public void setHasStableIds(boolean z) {
            if (hasObservers()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.mHasStableIds = z;
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final boolean hasObservers() {
            return this.mObservable.m4113a();
        }

        public void registerAdapterDataObserver(AbstractC0687c abstractC0687c) {
            this.mObservable.registerObserver(abstractC0687c);
        }

        public void unregisterAdapterDataObserver(AbstractC0687c abstractC0687c) {
            this.mObservable.unregisterObserver(abstractC0687c);
        }

        public final void notifyDataSetChanged() {
            this.mObservable.m4114b();
        }

        public final void notifyItemChanged(int OplusGLSurfaceView_13) {
            this.mObservable.m4111a(OplusGLSurfaceView_13, 1);
        }

        public final void notifyItemChanged(int OplusGLSurfaceView_13, Object obj) {
            this.mObservable.m4112a(OplusGLSurfaceView_13, 1, obj);
        }

        public final void notifyItemRangeChanged(int OplusGLSurfaceView_13, int i2) {
            this.mObservable.m4111a(OplusGLSurfaceView_13, i2);
        }

        public final void notifyItemRangeChanged(int OplusGLSurfaceView_13, int i2, Object obj) {
            this.mObservable.m4112a(OplusGLSurfaceView_13, i2, obj);
        }

        public final void notifyItemInserted(int OplusGLSurfaceView_13) {
            this.mObservable.m4115b(OplusGLSurfaceView_13, 1);
        }

        public final void notifyItemMoved(int OplusGLSurfaceView_13, int i2) {
            this.mObservable.m4118d(OplusGLSurfaceView_13, i2);
        }

        public final void notifyItemRangeInserted(int OplusGLSurfaceView_13, int i2) {
            this.mObservable.m4115b(OplusGLSurfaceView_13, i2);
        }

        public final void notifyItemRemoved(int OplusGLSurfaceView_13) {
            this.mObservable.m4117c(OplusGLSurfaceView_13, 1);
        }

        public final void notifyItemRangeRemoved(int OplusGLSurfaceView_13, int i2) {
            this.mObservable.m4117c(OplusGLSurfaceView_13, i2);
        }

        public void setStateRestorationPolicy(PlatformImplementations.kt_3 aVar) {
            this.mStateRestorationPolicy = aVar;
            this.mObservable.m4116c();
        }

        public final PlatformImplementations.kt_3 getStateRestorationPolicy() {
            return this.mStateRestorationPolicy;
        }

        boolean canRestoreState() {
            int OplusGLSurfaceView_13 = C06837.f4021a[this.mStateRestorationPolicy.ordinal()];
            if (OplusGLSurfaceView_13 != 1) {
                return OplusGLSurfaceView_13 != 2 || getItemCount() > 0;
            }
            return false;
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$7 */
    static /* synthetic */ class C06837 {

        /* renamed from: PlatformImplementations.kt_3 */
        static final /* synthetic */ int[] f4021a = new int[AbstractC0685a.PlatformImplementations.kt_3.values().length];

        static {
            try {
                f4021a[AbstractC0685a.PlatformImplementations.kt_3.PREVENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4021a[AbstractC0685a.PlatformImplementations.kt_3.PREVENT_WHEN_EMPTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    void dispatchChildDetached(View view) {
        AbstractC0707w childViewHolderInt = getChildViewHolderInt(view);
        onChildDetachedFromWindow(view);
        AbstractC0685a abstractC0685a = this.mAdapter;
        if (abstractC0685a != null && childViewHolderInt != null) {
            abstractC0685a.onViewDetachedFromWindow(childViewHolderInt);
        }
        List<InterfaceC0695k> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).mo4161b(view);
            }
        }
    }

    void dispatchChildAttached(View view) {
        AbstractC0707w childViewHolderInt = getChildViewHolderInt(view);
        onChildAttachedToWindow(view);
        AbstractC0685a abstractC0685a = this.mAdapter;
        if (abstractC0685a != null && childViewHolderInt != null) {
            abstractC0685a.onViewAttachedToWindow(childViewHolderInt);
        }
        List<InterfaceC0695k> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).mo4160a(view);
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$OplusGLSurfaceView_13 */
    public static abstract class AbstractC0693i {
        ChildHelper mChildHelper;
        private int mHeight;
        private int mHeightMode;
        int mPrefetchMaxCountObserved;
        boolean mPrefetchMaxObservedInInitialPrefetch;
        RecyclerView mRecyclerView;
        AbstractC0703s mSmoothScroller;
        private int mWidth;
        private int mWidthMode;
        private final ViewBoundsCheck.IntrinsicsJvm.kt_4 mHorizontalBoundCheckCallback = new ViewBoundsCheck.IntrinsicsJvm.kt_4() { // from class: androidx.recyclerview.widget.RecyclerView.OplusGLSurfaceView_13.1
            @Override // androidx.recyclerview.widget.ViewBoundsCheck.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3 */
            public View mo4150a(int OplusGLSurfaceView_13) {
                return AbstractC0693i.this.getChildAt(OplusGLSurfaceView_13);
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3 */
            public int mo4148a() {
                return AbstractC0693i.this.getPaddingLeft();
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.IntrinsicsJvm.kt_4
            /* renamed from: IntrinsicsJvm.kt_4 */
            public int mo4151b() {
                return AbstractC0693i.this.getWidth() - AbstractC0693i.this.getPaddingRight();
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3 */
            public int mo4149a(View view) {
                return AbstractC0693i.this.getDecoratedLeft(view) - ((C0694j) view.getLayoutParams()).leftMargin;
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.IntrinsicsJvm.kt_4
            /* renamed from: IntrinsicsJvm.kt_4 */
            public int mo4152b(View view) {
                return AbstractC0693i.this.getDecoratedRight(view) + ((C0694j) view.getLayoutParams()).rightMargin;
            }
        };
        private final ViewBoundsCheck.IntrinsicsJvm.kt_4 mVerticalBoundCheckCallback = new ViewBoundsCheck.IntrinsicsJvm.kt_4() { // from class: androidx.recyclerview.widget.RecyclerView.OplusGLSurfaceView_13.2
            @Override // androidx.recyclerview.widget.ViewBoundsCheck.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3 */
            public View mo4150a(int OplusGLSurfaceView_13) {
                return AbstractC0693i.this.getChildAt(OplusGLSurfaceView_13);
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3 */
            public int mo4148a() {
                return AbstractC0693i.this.getPaddingTop();
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.IntrinsicsJvm.kt_4
            /* renamed from: IntrinsicsJvm.kt_4 */
            public int mo4151b() {
                return AbstractC0693i.this.getHeight() - AbstractC0693i.this.getPaddingBottom();
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3 */
            public int mo4149a(View view) {
                return AbstractC0693i.this.getDecoratedTop(view) - ((C0694j) view.getLayoutParams()).topMargin;
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.IntrinsicsJvm.kt_4
            /* renamed from: IntrinsicsJvm.kt_4 */
            public int mo4152b(View view) {
                return AbstractC0693i.this.getDecoratedBottom(view) + ((C0694j) view.getLayoutParams()).bottomMargin;
            }
        };
        ViewBoundsCheck mHorizontalBoundCheck = new ViewBoundsCheck(this.mHorizontalBoundCheckCallback);
        ViewBoundsCheck mVerticalBoundCheck = new ViewBoundsCheck(this.mVerticalBoundCheckCallback);
        boolean mRequestedSimpleAnimations = false;
        boolean mIsAttachedToWindow = false;
        boolean mAutoMeasure = false;
        private boolean mMeasurementCacheEnabled = true;
        private boolean mItemPrefetchEnabled = true;

        /* renamed from: androidx.recyclerview.widget.RecyclerView$OplusGLSurfaceView_13$PlatformImplementations.kt_3 */
        public interface PlatformImplementations.kt_3 {
            /* renamed from: IntrinsicsJvm.kt_4 */
            void mo4153b(int OplusGLSurfaceView_13, int i2);
        }

        /* renamed from: androidx.recyclerview.widget.RecyclerView$OplusGLSurfaceView_13$IntrinsicsJvm.kt_4 */
        public static class IntrinsicsJvm.kt_4 {

            /* renamed from: PlatformImplementations.kt_3 */
            public int f4035a;

            /* renamed from: IntrinsicsJvm.kt_4 */
            public int f4036b;

            /* renamed from: IntrinsicsJvm.kt_3 */
            public boolean f4037c;

            /* renamed from: IntrinsicsJvm.kt_5 */
            public boolean f4038d;
        }

        public boolean canScrollHorizontally() {
            return false;
        }

        public boolean canScrollVertically() {
            return false;
        }

        public boolean checkLayoutParams(C0694j c0694j) {
            return c0694j != null;
        }

        public void collectAdjacentPrefetchPositions(int OplusGLSurfaceView_13, int i2, C0704t c0704t, PlatformImplementations.kt_3 aVar) {
        }

        public void collectInitialPrefetchPositions(int OplusGLSurfaceView_13, PlatformImplementations.kt_3 aVar) {
        }

        public int computeHorizontalScrollExtent(C0704t c0704t) {
            return 0;
        }

        public int computeHorizontalScrollOffset(C0704t c0704t) {
            return 0;
        }

        public int computeHorizontalScrollRange(C0704t c0704t) {
            return 0;
        }

        public int computeVerticalScrollExtent(C0704t c0704t) {
            return 0;
        }

        public int computeVerticalScrollOffset(C0704t c0704t) {
            return 0;
        }

        public int computeVerticalScrollRange(C0704t c0704t) {
            return 0;
        }

        public abstract C0694j generateDefaultLayoutParams();

        public int getBaseline() {
            return -1;
        }

        public int getColumnCountForAccessibility(C0700p c0700p, C0704t c0704t) {
            return -1;
        }

        public int getRowCountForAccessibility(C0700p c0700p, C0704t c0704t) {
            return -1;
        }

        public int getSelectionModeForAccessibility(C0700p c0700p, C0704t c0704t) {
            return 0;
        }

        public boolean isLayoutHierarchical(C0700p c0700p, C0704t c0704t) {
            return false;
        }

        public void onAdapterChanged(AbstractC0685a abstractC0685a, AbstractC0685a abstractC0685a2) {
        }

        public boolean onAddFocusables(RecyclerView recyclerView, ArrayList<View> arrayList, int OplusGLSurfaceView_13, int i2) {
            return false;
        }

        public void onAttachedToWindow(RecyclerView recyclerView) {
        }

        @Deprecated
        public void onDetachedFromWindow(RecyclerView recyclerView) {
        }

        public View onFocusSearchFailed(View view, int OplusGLSurfaceView_13, C0700p c0700p, C0704t c0704t) {
            return null;
        }

        public void onInitializeAccessibilityNodeInfoForItem(C0700p c0700p, C0704t c0704t, View view, AccessibilityNodeInfoCompat c0483d) {
        }

        public View onInterceptFocusSearch(View view, int OplusGLSurfaceView_13) {
            return null;
        }

        public void onItemsAdded(RecyclerView recyclerView, int OplusGLSurfaceView_13, int i2) {
        }

        public void onItemsChanged(RecyclerView recyclerView) {
        }

        public void onItemsMoved(RecyclerView recyclerView, int OplusGLSurfaceView_13, int i2, int i3) {
        }

        public void onItemsRemoved(RecyclerView recyclerView, int OplusGLSurfaceView_13, int i2) {
        }

        public void onItemsUpdated(RecyclerView recyclerView, int OplusGLSurfaceView_13, int i2) {
        }

        public void onLayoutCompleted(C0704t c0704t) {
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onScrollStateChanged(int OplusGLSurfaceView_13) {
        }

        public boolean performAccessibilityActionForItem(C0700p c0700p, C0704t c0704t, View view, int OplusGLSurfaceView_13, Bundle bundle) {
            return false;
        }

        public int scrollHorizontallyBy(int OplusGLSurfaceView_13, C0700p c0700p, C0704t c0704t) {
            return 0;
        }

        public void scrollToPosition(int OplusGLSurfaceView_13) {
        }

        public int scrollVerticallyBy(int OplusGLSurfaceView_13, C0700p c0700p, C0704t c0704t) {
            return 0;
        }

        boolean shouldMeasureTwice() {
            return false;
        }

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }

        void setRecyclerView(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.mRecyclerView = null;
                this.mChildHelper = null;
                this.mWidth = 0;
                this.mHeight = 0;
            } else {
                this.mRecyclerView = recyclerView;
                this.mChildHelper = recyclerView.mChildHelper;
                this.mWidth = recyclerView.getWidth();
                this.mHeight = recyclerView.getHeight();
            }
            this.mWidthMode = 1073741824;
            this.mHeightMode = 1073741824;
        }

        void setMeasureSpecs(int OplusGLSurfaceView_13, int i2) {
            this.mWidth = View.MeasureSpec.getSize(OplusGLSurfaceView_13);
            this.mWidthMode = View.MeasureSpec.getMode(OplusGLSurfaceView_13);
            if (this.mWidthMode == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.mWidth = 0;
            }
            this.mHeight = View.MeasureSpec.getSize(i2);
            this.mHeightMode = View.MeasureSpec.getMode(i2);
            if (this.mHeightMode != 0 || RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                return;
            }
            this.mHeight = 0;
        }

        void setMeasuredDimensionFromChildren(int OplusGLSurfaceView_13, int i2) {
            int childCount = getChildCount();
            if (childCount == 0) {
                this.mRecyclerView.defaultOnMeasure(OplusGLSurfaceView_13, i2);
                return;
            }
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MIN_VALUE;
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MAX_VALUE;
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                Rect rect = this.mRecyclerView.mTempRect;
                getDecoratedBoundsWithMargins(childAt, rect);
                if (rect.left < i3) {
                    i3 = rect.left;
                }
                if (rect.right > i4) {
                    i4 = rect.right;
                }
                if (rect.top < i6) {
                    i6 = rect.top;
                }
                if (rect.bottom > i5) {
                    i5 = rect.bottom;
                }
            }
            this.mRecyclerView.mTempRect.set(i3, i6, i4, i5);
            setMeasuredDimension(this.mRecyclerView.mTempRect, OplusGLSurfaceView_13, i2);
        }

        public void setMeasuredDimension(Rect rect, int OplusGLSurfaceView_13, int i2) {
            setMeasuredDimension(chooseSize(OplusGLSurfaceView_13, rect.width() + getPaddingLeft() + getPaddingRight(), getMinimumWidth()), chooseSize(i2, rect.height() + getPaddingTop() + getPaddingBottom(), getMinimumHeight()));
        }

        public void requestLayout() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public void assertInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertInLayoutOrScroll(str);
            }
        }

        public static int chooseSize(int OplusGLSurfaceView_13, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(OplusGLSurfaceView_13);
            int size = View.MeasureSpec.getSize(OplusGLSurfaceView_13);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i2, i3) : size;
            }
            return Math.min(size, Math.max(i2, i3));
        }

        public void assertNotInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertNotInLayoutOrScroll(str);
            }
        }

        @Deprecated
        public void setAutoMeasureEnabled(boolean z) {
            this.mAutoMeasure = z;
        }

        public boolean isAutoMeasureEnabled() {
            return this.mAutoMeasure;
        }

        public final void setItemPrefetchEnabled(boolean z) {
            if (z != this.mItemPrefetchEnabled) {
                this.mItemPrefetchEnabled = z;
                this.mPrefetchMaxCountObserved = 0;
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView != null) {
                    recyclerView.mRecycler.m4197b();
                }
            }
        }

        public final boolean isItemPrefetchEnabled() {
            return this.mItemPrefetchEnabled;
        }

        void dispatchAttachedToWindow(RecyclerView recyclerView) {
            this.mIsAttachedToWindow = true;
            onAttachedToWindow(recyclerView);
        }

        void dispatchDetachedFromWindow(RecyclerView recyclerView, C0700p c0700p) {
            this.mIsAttachedToWindow = false;
            onDetachedFromWindow(recyclerView, c0700p);
        }

        public boolean isAttachedToWindow() {
            return this.mIsAttachedToWindow;
        }

        public void postOnAnimation(Runnable runnable) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                ViewCompat.m2857a(recyclerView, runnable);
            }
        }

        public boolean removeCallbacks(Runnable runnable) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void onDetachedFromWindow(RecyclerView recyclerView, C0700p c0700p) {
            onDetachedFromWindow(recyclerView);
        }

        public boolean getClipToPadding() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.mClipToPadding;
        }

        public void onLayoutChildren(C0700p c0700p, C0704t c0704t) {
            Log.COUIBaseListPopupWindow_8(RecyclerView.TAG, "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public C0694j generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof C0694j) {
                return new C0694j((C0694j) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new C0694j((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new C0694j(layoutParams);
        }

        public C0694j generateLayoutParams(Context context, AttributeSet attributeSet) {
            return new C0694j(context, attributeSet);
        }

        public void smoothScrollToPosition(RecyclerView recyclerView, C0704t c0704t, int OplusGLSurfaceView_13) {
            Log.COUIBaseListPopupWindow_8(RecyclerView.TAG, "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void startSmoothScroll(AbstractC0703s abstractC0703s) {
            AbstractC0703s abstractC0703s2 = this.mSmoothScroller;
            if (abstractC0703s2 != null && abstractC0703s != abstractC0703s2 && abstractC0703s2.isRunning()) {
                this.mSmoothScroller.stop();
            }
            this.mSmoothScroller = abstractC0703s;
            this.mSmoothScroller.start(this.mRecyclerView, this);
        }

        public boolean isSmoothScrolling() {
            AbstractC0703s abstractC0703s = this.mSmoothScroller;
            return abstractC0703s != null && abstractC0703s.isRunning();
        }

        public int getLayoutDirection() {
            return ViewCompat.m2885g(this.mRecyclerView);
        }

        public void endAnimation(View view) {
            if (this.mRecyclerView.mItemAnimator != null) {
                this.mRecyclerView.mItemAnimator.mo4134d(RecyclerView.getChildViewHolderInt(view));
            }
        }

        public void addDisappearingView(View view) {
            addDisappearingView(view, -1);
        }

        public void addDisappearingView(View view, int OplusGLSurfaceView_13) {
            addViewInt(view, OplusGLSurfaceView_13, true);
        }

        public void addView(View view) {
            addView(view, -1);
        }

        public void addView(View view, int OplusGLSurfaceView_13) {
            addViewInt(view, OplusGLSurfaceView_13, false);
        }

        private void addViewInt(View view, int OplusGLSurfaceView_13, boolean z) {
            AbstractC0707w childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (z || childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.m4572e(childViewHolderInt);
            } else {
                this.mRecyclerView.mViewInfoStore.m4573f(childViewHolderInt);
            }
            C0694j c0694j = (C0694j) view.getLayoutParams();
            if (childViewHolderInt.wasReturnedFromScrap() || childViewHolderInt.isScrap()) {
                if (childViewHolderInt.isScrap()) {
                    childViewHolderInt.unScrap();
                } else {
                    childViewHolderInt.clearReturnedFromScrapFlag();
                }
                this.mChildHelper.m4381a(view, OplusGLSurfaceView_13, view.getLayoutParams(), false);
            } else if (view.getParent() == this.mRecyclerView) {
                int iM4385b = this.mChildHelper.m4385b(view);
                if (OplusGLSurfaceView_13 == -1) {
                    OplusGLSurfaceView_13 = this.mChildHelper.m4384b();
                }
                if (iM4385b == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not PlatformImplementations.kt_3 real child. Unfiltered index:" + this.mRecyclerView.indexOfChild(view) + this.mRecyclerView.exceptionLabel());
                }
                if (iM4385b != OplusGLSurfaceView_13) {
                    this.mRecyclerView.mLayout.moveView(iM4385b, OplusGLSurfaceView_13);
                }
            } else {
                this.mChildHelper.m4382a(view, OplusGLSurfaceView_13, false);
                c0694j.f4041e = true;
                AbstractC0703s abstractC0703s = this.mSmoothScroller;
                if (abstractC0703s != null && abstractC0703s.isRunning()) {
                    this.mSmoothScroller.onChildAttachedToWindow(view);
                }
            }
            if (c0694j.f4042f) {
                childViewHolderInt.itemView.invalidate();
                c0694j.f4042f = false;
            }
        }

        public void removeView(View view) {
            this.mChildHelper.m4380a(view);
        }

        public void removeViewAt(int OplusGLSurfaceView_13) {
            if (getChildAt(OplusGLSurfaceView_13) != null) {
                this.mChildHelper.m4379a(OplusGLSurfaceView_13);
            }
        }

        public void removeAllViews() {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                this.mChildHelper.m4379a(childCount);
            }
        }

        public int getPosition(View view) {
            return ((C0694j) view.getLayoutParams()).m4157f();
        }

        public int getItemViewType(View view) {
            return RecyclerView.getChildViewHolderInt(view).getItemViewType();
        }

        public View findContainingItemView(View view) {
            View viewFindContainingItemView;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (viewFindContainingItemView = recyclerView.findContainingItemView(view)) == null || this.mChildHelper.m4389c(viewFindContainingItemView)) {
                return null;
            }
            return viewFindContainingItemView;
        }

        public View findViewByPosition(int OplusGLSurfaceView_13) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                AbstractC0707w childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt);
                if (childViewHolderInt != null && childViewHolderInt.getLayoutPosition() == OplusGLSurfaceView_13 && !childViewHolderInt.shouldIgnore() && (this.mRecyclerView.mState.m4226a() || !childViewHolderInt.isRemoved())) {
                    return childAt;
                }
            }
            return null;
        }

        public void detachView(View view) {
            int iM4385b = this.mChildHelper.m4385b(view);
            if (iM4385b >= 0) {
                detachViewInternal(iM4385b, view);
            }
        }

        public void detachViewAt(int OplusGLSurfaceView_13) {
            detachViewInternal(OplusGLSurfaceView_13, getChildAt(OplusGLSurfaceView_13));
        }

        private void detachViewInternal(int OplusGLSurfaceView_13, View view) {
            this.mChildHelper.m4392e(OplusGLSurfaceView_13);
        }

        public void attachView(View view, int OplusGLSurfaceView_13, C0694j c0694j) {
            AbstractC0707w childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.m4572e(childViewHolderInt);
            } else {
                this.mRecyclerView.mViewInfoStore.m4573f(childViewHolderInt);
            }
            this.mChildHelper.m4381a(view, OplusGLSurfaceView_13, c0694j, childViewHolderInt.isRemoved());
        }

        public void attachView(View view, int OplusGLSurfaceView_13) {
            attachView(view, OplusGLSurfaceView_13, (C0694j) view.getLayoutParams());
        }

        public void attachView(View view) {
            attachView(view, -1);
        }

        public void removeDetachedView(View view) {
            this.mRecyclerView.removeDetachedView(view, false);
        }

        public void moveView(int OplusGLSurfaceView_13, int i2) {
            View childAt = getChildAt(OplusGLSurfaceView_13);
            if (childAt == null) {
                throw new IllegalArgumentException("Cannot move PlatformImplementations.kt_3 child from non-existing index:" + OplusGLSurfaceView_13 + this.mRecyclerView.toString());
            }
            detachViewAt(OplusGLSurfaceView_13);
            attachView(childAt, i2);
        }

        public void detachAndScrapView(View view, C0700p c0700p) {
            scrapOrRecycleView(c0700p, this.mChildHelper.m4385b(view), view);
        }

        public void detachAndScrapViewAt(int OplusGLSurfaceView_13, C0700p c0700p) {
            scrapOrRecycleView(c0700p, OplusGLSurfaceView_13, getChildAt(OplusGLSurfaceView_13));
        }

        public void removeAndRecycleView(View view, C0700p c0700p) {
            removeView(view);
            c0700p.m4189a(view);
        }

        public void removeAndRecycleViewAt(int OplusGLSurfaceView_13, C0700p c0700p) {
            View childAt = getChildAt(OplusGLSurfaceView_13);
            removeViewAt(OplusGLSurfaceView_13);
            c0700p.m4189a(childAt);
        }

        public int getChildCount() {
            ChildHelper c0717d = this.mChildHelper;
            if (c0717d != null) {
                return c0717d.m4384b();
            }
            return 0;
        }

        public View getChildAt(int OplusGLSurfaceView_13) {
            ChildHelper c0717d = this.mChildHelper;
            if (c0717d != null) {
                return c0717d.m4386b(OplusGLSurfaceView_13);
            }
            return null;
        }

        public int getWidthMode() {
            return this.mWidthMode;
        }

        public int getHeightMode() {
            return this.mHeightMode;
        }

        public int getWidth() {
            return this.mWidth;
        }

        public int getHeight() {
            return this.mHeight;
        }

        public int getPaddingLeft() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int getPaddingTop() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int getPaddingRight() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int getPaddingBottom() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public int getPaddingStart() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return ViewCompat.m2891j(recyclerView);
            }
            return 0;
        }

        public int getPaddingEnd() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return ViewCompat.m2892k(recyclerView);
            }
            return 0;
        }

        public boolean isFocused() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.isFocused();
        }

        public boolean hasFocus() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.hasFocus();
        }

        public View getFocusedChild() {
            View focusedChild;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.mChildHelper.m4389c(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public int getItemCount() {
            RecyclerView recyclerView = this.mRecyclerView;
            AbstractC0685a adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        public void offsetChildrenHorizontal(int OplusGLSurfaceView_13) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenHorizontal(OplusGLSurfaceView_13);
            }
        }

        public void offsetChildrenVertical(int OplusGLSurfaceView_13) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenVertical(OplusGLSurfaceView_13);
            }
        }

        public void ignoreView(View view) {
            ViewParent parent = view.getParent();
            RecyclerView recyclerView = this.mRecyclerView;
            if (parent != recyclerView || recyclerView.indexOfChild(view) == -1) {
                throw new IllegalArgumentException("View should be fully attached to be ignored" + this.mRecyclerView.exceptionLabel());
            }
            AbstractC0707w childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.addFlags(128);
            this.mRecyclerView.mViewInfoStore.m4574g(childViewHolderInt);
        }

        public void stopIgnoringView(View view) {
            AbstractC0707w childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.stopIgnoring();
            childViewHolderInt.resetInternal();
            childViewHolderInt.addFlags(4);
        }

        public void detachAndScrapAttachedViews(C0700p c0700p) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                scrapOrRecycleView(c0700p, childCount, getChildAt(childCount));
            }
        }

        private void scrapOrRecycleView(C0700p c0700p, int OplusGLSurfaceView_13, View view) {
            AbstractC0707w childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.shouldIgnore()) {
                return;
            }
            if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !this.mRecyclerView.mAdapter.hasStableIds()) {
                removeViewAt(OplusGLSurfaceView_13);
                c0700p.m4200b(childViewHolderInt);
            } else {
                detachViewAt(OplusGLSurfaceView_13);
                c0700p.m4204c(view);
                this.mRecyclerView.mViewInfoStore.m4575h(childViewHolderInt);
            }
        }

        void removeAndRecycleScrapInt(C0700p c0700p) {
            int iM4209e = c0700p.m4209e();
            for (int OplusGLSurfaceView_13 = iM4209e - 1; OplusGLSurfaceView_13 >= 0; OplusGLSurfaceView_13--) {
                View viewM4210e = c0700p.m4210e(OplusGLSurfaceView_13);
                AbstractC0707w childViewHolderInt = RecyclerView.getChildViewHolderInt(viewM4210e);
                if (!childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.setIsRecyclable(false);
                    if (childViewHolderInt.isTmpDetached()) {
                        this.mRecyclerView.removeDetachedView(viewM4210e, false);
                    }
                    if (this.mRecyclerView.mItemAnimator != null) {
                        this.mRecyclerView.mItemAnimator.mo4134d(childViewHolderInt);
                    }
                    childViewHolderInt.setIsRecyclable(true);
                    c0700p.m4199b(viewM4210e);
                }
            }
            c0700p.m4212f();
            if (iM4209e > 0) {
                this.mRecyclerView.invalidate();
            }
        }

        public void measureChild(View view, int OplusGLSurfaceView_13, int i2) {
            C0694j c0694j = (C0694j) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i3 = OplusGLSurfaceView_13 + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right;
            int i4 = i2 + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + i3, c0694j.width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + i4, c0694j.height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, c0694j)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        boolean shouldReMeasureChild(View view, int OplusGLSurfaceView_13, int i2, C0694j c0694j) {
            return (this.mMeasurementCacheEnabled && isMeasurementUpToDate(view.getMeasuredWidth(), OplusGLSurfaceView_13, c0694j.width) && isMeasurementUpToDate(view.getMeasuredHeight(), i2, c0694j.height)) ? false : true;
        }

        boolean shouldMeasureChild(View view, int OplusGLSurfaceView_13, int i2, C0694j c0694j) {
            return (!view.isLayoutRequested() && this.mMeasurementCacheEnabled && isMeasurementUpToDate(view.getWidth(), OplusGLSurfaceView_13, c0694j.width) && isMeasurementUpToDate(view.getHeight(), i2, c0694j.height)) ? false : true;
        }

        public boolean isMeasurementCacheEnabled() {
            return this.mMeasurementCacheEnabled;
        }

        public void setMeasurementCacheEnabled(boolean z) {
            this.mMeasurementCacheEnabled = z;
        }

        private static boolean isMeasurementUpToDate(int OplusGLSurfaceView_13, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 > 0 && OplusGLSurfaceView_13 != i3) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= OplusGLSurfaceView_13;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == OplusGLSurfaceView_13;
            }
            return true;
        }

        public void measureChildWithMargins(View view, int OplusGLSurfaceView_13, int i2) {
            C0694j c0694j = (C0694j) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i3 = OplusGLSurfaceView_13 + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right;
            int i4 = i2 + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + c0694j.leftMargin + c0694j.rightMargin + i3, c0694j.width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + c0694j.topMargin + c0694j.bottomMargin + i4, c0694j.height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, c0694j)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
        
            if (r3 >= 0) goto L8;
         */
        @java.lang.Deprecated
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int getChildMeasureSpec(int r1, int r2, int r3, boolean r4) {
            /*
                int r1 = r1 - r2
                r2 = 0
                int r1 = java.lang.Math.max(r2, r1)
                r0 = 1073741824(0x40000000, float:2.0)
                if (r4 == 0) goto Lf
                if (r3 < 0) goto Ld
                goto L11
            Ld:
                r1 = r2
                goto L1d
            Lf:
                if (r3 < 0) goto L14
            L11:
                r1 = r3
            L12:
                r2 = r0
                goto L1d
            L14:
                r4 = -1
                if (r3 != r4) goto L18
                goto L12
            L18:
                r4 = -2
                if (r3 != r4) goto Ld
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
            L1d:
                int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.AbstractC0693i.getChildMeasureSpec(int, int, int, boolean):int");
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0031  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int getChildMeasureSpec(int r4, int r5, int r6, int r7, boolean r8) {
            /*
                int r4 = r4 - r6
                r6 = 0
                int r4 = java.lang.Math.max(r6, r4)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L20
                if (r7 < 0) goto L11
                goto L22
            L11:
                if (r7 != r1) goto L31
                if (r5 == r2) goto L1c
                if (r5 == 0) goto L19
                if (r5 == r3) goto L1c
            L19:
                r5 = r6
                r7 = r5
                goto L1d
            L1c:
                r7 = r4
            L1d:
                r6 = r5
                r4 = r7
                goto L32
            L20:
                if (r7 < 0) goto L25
            L22:
                r4 = r7
                r6 = r3
                goto L32
            L25:
                if (r7 != r1) goto L29
                r6 = r5
                goto L32
            L29:
                if (r7 != r0) goto L31
                if (r5 == r2) goto L2f
                if (r5 != r3) goto L32
            L2f:
                r6 = r2
                goto L32
            L31:
                r4 = r6
            L32:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r6)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.AbstractC0693i.getChildMeasureSpec(int, int, int, int, boolean):int");
        }

        public int getDecoratedMeasuredWidth(View view) {
            Rect rect = ((C0694j) view.getLayoutParams()).f4040d;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int getDecoratedMeasuredHeight(View view) {
            Rect rect = ((C0694j) view.getLayoutParams()).f4040d;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void layoutDecorated(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
            Rect rect = ((C0694j) view.getLayoutParams()).f4040d;
            view.layout(OplusGLSurfaceView_13 + rect.left, i2 + rect.top, i3 - rect.right, i4 - rect.bottom);
        }

        public void layoutDecoratedWithMargins(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
            C0694j c0694j = (C0694j) view.getLayoutParams();
            Rect rect = c0694j.f4040d;
            view.layout(OplusGLSurfaceView_13 + rect.left + c0694j.leftMargin, i2 + rect.top + c0694j.topMargin, (i3 - rect.right) - c0694j.rightMargin, (i4 - rect.bottom) - c0694j.bottomMargin);
        }

        public void getTransformedBoundingBox(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((C0694j) view.getLayoutParams()).f4040d;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.mRecyclerView != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.mRecyclerView.mTempRectF;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void getDecoratedBoundsWithMargins(View view, Rect rect) {
            RecyclerView.getDecoratedBoundsWithMarginsInt(view, rect);
        }

        public int getDecoratedLeft(View view) {
            return view.getLeft() - getLeftDecorationWidth(view);
        }

        public int getDecoratedTop(View view) {
            return view.getTop() - getTopDecorationHeight(view);
        }

        public int getDecoratedRight(View view) {
            return view.getRight() + getRightDecorationWidth(view);
        }

        public int getDecoratedBottom(View view) {
            return view.getBottom() + getBottomDecorationHeight(view);
        }

        public void calculateItemDecorationsForChild(View view, Rect rect) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.getItemDecorInsetsForChild(view));
            }
        }

        public int getTopDecorationHeight(View view) {
            return ((C0694j) view.getLayoutParams()).f4040d.top;
        }

        public int getBottomDecorationHeight(View view) {
            return ((C0694j) view.getLayoutParams()).f4040d.bottom;
        }

        public int getLeftDecorationWidth(View view) {
            return ((C0694j) view.getLayoutParams()).f4040d.left;
        }

        public int getRightDecorationWidth(View view) {
            return ((C0694j) view.getLayoutParams()).f4040d.right;
        }

        private int[] getChildRectangleOnScreenScrollAmount(View view, Rect rect) {
            int[] iArr = new int[2];
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int iWidth = rect.width() + left;
            int iHeight = rect.height() + top;
            int OplusGLSurfaceView_13 = left - paddingLeft;
            int iMin = Math.min(0, OplusGLSurfaceView_13);
            int i2 = top - paddingTop;
            int iMin2 = Math.min(0, i2);
            int i3 = iWidth - width;
            int iMax = Math.max(0, i3);
            int iMax2 = Math.max(0, iHeight - height);
            if (getLayoutDirection() != 1) {
                if (iMin == 0) {
                    iMin = Math.min(OplusGLSurfaceView_13, iMax);
                }
                iMax = iMin;
            } else if (iMax == 0) {
                iMax = Math.max(iMin, i3);
            }
            if (iMin2 == 0) {
                iMin2 = Math.min(i2, iMax2);
            }
            iArr[0] = iMax;
            iArr[1] = iMin2;
            return iArr;
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return requestChildRectangleOnScreen(recyclerView, view, rect, z, false);
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] childRectangleOnScreenScrollAmount = getChildRectangleOnScreenScrollAmount(view, rect);
            int OplusGLSurfaceView_13 = childRectangleOnScreenScrollAmount[0];
            int i2 = childRectangleOnScreenScrollAmount[1];
            if ((z2 && !isFocusedChildVisibleAfterScrolling(recyclerView, OplusGLSurfaceView_13, i2)) || (OplusGLSurfaceView_13 == 0 && i2 == 0)) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(OplusGLSurfaceView_13, i2);
            } else {
                recyclerView.smoothScrollBy(OplusGLSurfaceView_13, i2);
            }
            return true;
        }

        public boolean isViewPartiallyVisible(View view, boolean z, boolean z2) {
            boolean z3 = this.mHorizontalBoundCheck.m4553a(view, 24579) && this.mVerticalBoundCheck.m4553a(view, 24579);
            return z ? z3 : !z3;
        }

        private boolean isFocusedChildVisibleAfterScrolling(RecyclerView recyclerView, int OplusGLSurfaceView_13, int i2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            Rect rect = this.mRecyclerView.mTempRect;
            getDecoratedBoundsWithMargins(focusedChild, rect);
            return rect.left - OplusGLSurfaceView_13 < width && rect.right - OplusGLSurfaceView_13 > paddingLeft && rect.top - i2 < height && rect.bottom - i2 > paddingTop;
        }

        @Deprecated
        public boolean onRequestChildFocus(RecyclerView recyclerView, View view, View view2) {
            return isSmoothScrolling() || recyclerView.isComputingLayout();
        }

        public boolean onRequestChildFocus(RecyclerView recyclerView, C0704t c0704t, View view, View view2) {
            return onRequestChildFocus(recyclerView, view, view2);
        }

        public void onItemsUpdated(RecyclerView recyclerView, int OplusGLSurfaceView_13, int i2, Object obj) {
            onItemsUpdated(recyclerView, OplusGLSurfaceView_13, i2);
        }

        public void onMeasure(C0700p c0700p, C0704t c0704t, int OplusGLSurfaceView_13, int i2) {
            this.mRecyclerView.defaultOnMeasure(OplusGLSurfaceView_13, i2);
        }

        public void setMeasuredDimension(int OplusGLSurfaceView_13, int i2) {
            this.mRecyclerView.setMeasuredDimension(OplusGLSurfaceView_13, i2);
        }

        public int getMinimumWidth() {
            return ViewCompat.m2893l(this.mRecyclerView);
        }

        public int getMinimumHeight() {
            return ViewCompat.m2894m(this.mRecyclerView);
        }

        void stopSmoothScroller() {
            AbstractC0703s abstractC0703s = this.mSmoothScroller;
            if (abstractC0703s != null) {
                abstractC0703s.stop();
            }
        }

        void onSmoothScrollerStopped(AbstractC0703s abstractC0703s) {
            if (this.mSmoothScroller == abstractC0703s) {
                this.mSmoothScroller = null;
            }
        }

        public void removeAndRecycleAllViews(C0700p c0700p) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (!RecyclerView.getChildViewHolderInt(getChildAt(childCount)).shouldIgnore()) {
                    removeAndRecycleViewAt(childCount, c0700p);
                }
            }
        }

        void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat c0483d) {
            onInitializeAccessibilityNodeInfo(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, c0483d);
        }

        public void onInitializeAccessibilityNodeInfo(C0700p c0700p, C0704t c0704t, AccessibilityNodeInfoCompat c0483d) {
            if (this.mRecyclerView.canScrollVertically(-1) || this.mRecyclerView.canScrollHorizontally(-1)) {
                c0483d.m2676a(8192);
                c0483d.m2715i(true);
            }
            if (this.mRecyclerView.canScrollVertically(1) || this.mRecyclerView.canScrollHorizontally(1)) {
                c0483d.m2676a(4096);
                c0483d.m2715i(true);
            }
            c0483d.m2683a(AccessibilityNodeInfoCompat.IntrinsicsJvm.kt_4.m2741a(getRowCountForAccessibility(c0700p, c0704t), getColumnCountForAccessibility(c0700p, c0704t), isLayoutHierarchical(c0700p, c0704t), getSelectionModeForAccessibility(c0700p, c0704t)));
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            onInitializeAccessibilityEvent(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, accessibilityEvent);
        }

        public void onInitializeAccessibilityEvent(C0700p c0700p, C0704t c0704t, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z = true;
            if (!recyclerView.canScrollVertically(1) && !this.mRecyclerView.canScrollVertically(-1) && !this.mRecyclerView.canScrollHorizontally(-1) && !this.mRecyclerView.canScrollHorizontally(1)) {
                z = false;
            }
            accessibilityEvent.setScrollable(z);
            if (this.mRecyclerView.mAdapter != null) {
                accessibilityEvent.setItemCount(this.mRecyclerView.mAdapter.getItemCount());
            }
        }

        void onInitializeAccessibilityNodeInfoForItem(View view, AccessibilityNodeInfoCompat c0483d) {
            AbstractC0707w childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt == null || childViewHolderInt.isRemoved() || this.mChildHelper.m4389c(childViewHolderInt.itemView)) {
                return;
            }
            onInitializeAccessibilityNodeInfoForItem(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, view, c0483d);
        }

        public void requestSimpleAnimationsInNextLayout() {
            this.mRequestedSimpleAnimations = true;
        }

        boolean performAccessibilityAction(int OplusGLSurfaceView_13, Bundle bundle) {
            return performAccessibilityAction(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, OplusGLSurfaceView_13, bundle);
        }

        public boolean performAccessibilityAction(C0700p c0700p, C0704t c0704t, int OplusGLSurfaceView_13, Bundle bundle) {
            int height;
            int width;
            int i2;
            int i3;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                return false;
            }
            if (OplusGLSurfaceView_13 == 4096) {
                height = recyclerView.canScrollVertically(1) ? (getHeight() - getPaddingTop()) - getPaddingBottom() : 0;
                if (this.mRecyclerView.canScrollHorizontally(1)) {
                    width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                    i2 = height;
                    i3 = width;
                }
                i2 = height;
                i3 = 0;
            } else if (OplusGLSurfaceView_13 != 8192) {
                i3 = 0;
                i2 = 0;
            } else {
                height = recyclerView.canScrollVertically(-1) ? -((getHeight() - getPaddingTop()) - getPaddingBottom()) : 0;
                if (this.mRecyclerView.canScrollHorizontally(-1)) {
                    width = -((getWidth() - getPaddingLeft()) - getPaddingRight());
                    i2 = height;
                    i3 = width;
                }
                i2 = height;
                i3 = 0;
            }
            if (i2 == 0 && i3 == 0) {
                return false;
            }
            this.mRecyclerView.smoothScrollBy(i3, i2, null, Integer.MIN_VALUE, true);
            return true;
        }

        boolean performAccessibilityActionForItem(View view, int OplusGLSurfaceView_13, Bundle bundle) {
            return performAccessibilityActionForItem(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, view, OplusGLSurfaceView_13, bundle);
        }

        public static IntrinsicsJvm.kt_4 getProperties(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
            IntrinsicsJvm.kt_4 bVar = new IntrinsicsJvm.kt_4();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.recyclerview.R.styleable.RecyclerView, OplusGLSurfaceView_13, i2);
            bVar.f4035a = typedArrayObtainStyledAttributes.getInt(androidx.recyclerview.R.styleable.RecyclerView_android_orientation, 1);
            bVar.f4036b = typedArrayObtainStyledAttributes.getInt(androidx.recyclerview.R.styleable.RecyclerView_spanCount, 1);
            bVar.f4037c = typedArrayObtainStyledAttributes.getBoolean(androidx.recyclerview.R.styleable.RecyclerView_reverseLayout, false);
            bVar.f4038d = typedArrayObtainStyledAttributes.getBoolean(androidx.recyclerview.R.styleable.RecyclerView_stackFromEnd, false);
            typedArrayObtainStyledAttributes.recycle();
            return bVar;
        }

        void setExactMeasureSpecsFrom(RecyclerView recyclerView) {
            setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        boolean hasFlexibleChildInBothOrientations() {
            int childCount = getChildCount();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
                ViewGroup.LayoutParams layoutParams = getChildAt(OplusGLSurfaceView_13).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$COUIBaseListPopupWindow_10 */
    public static abstract class AbstractC0692h {
        @Deprecated
        public void onDraw(Canvas canvas, RecyclerView recyclerView) {
        }

        @Deprecated
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView) {
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, C0704t c0704t) {
            onDraw(canvas, recyclerView);
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, C0704t c0704t) {
            onDrawOver(canvas, recyclerView);
        }

        @Deprecated
        public void getItemOffsets(Rect rect, int OplusGLSurfaceView_13, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, C0704t c0704t) {
            getItemOffsets(rect, ((C0694j) view.getLayoutParams()).m4157f(), recyclerView);
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$w */
    public static abstract class AbstractC0707w {
        static final int FLAG_ADAPTER_FULLUPDATE = 1024;
        static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
        static final int FLAG_BOUND = 1;
        static final int FLAG_IGNORE = 128;
        static final int FLAG_INVALID = 4;
        static final int FLAG_MOVED = 2048;
        static final int FLAG_NOT_RECYCLABLE = 16;
        static final int FLAG_REMOVED = 8;
        static final int FLAG_RETURNED_FROM_SCRAP = 32;
        static final int FLAG_TMP_DETACHED = 256;
        static final int FLAG_UPDATE = 2;
        private static final List<Object> FULLUPDATE_PAYLOADS = Collections.emptyList();
        static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
        public final View itemView;
        AbstractC0685a<? extends AbstractC0707w> mBindingAdapter;
        int mFlags;
        WeakReference<RecyclerView> mNestedRecyclerView;
        RecyclerView mOwnerRecyclerView;
        int mPosition = -1;
        int mOldPosition = -1;
        long mItemId = -1;
        int mItemViewType = -1;
        int mPreLayoutPosition = -1;
        AbstractC0707w mShadowedHolder = null;
        AbstractC0707w mShadowingHolder = null;
        List<Object> mPayloads = null;
        List<Object> mUnmodifiedPayloads = null;
        private int mIsRecyclableCount = 0;
        C0700p mScrapContainer = null;
        boolean mInChangeScrap = false;
        private int mWasImportantForAccessibilityBeforeHidden = 0;
        int mPendingAccessibilityState = -1;

        public AbstractC0707w(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.itemView = view;
        }

        void flagRemovedAndOffsetPosition(int OplusGLSurfaceView_13, int i2, boolean z) {
            addFlags(8);
            offsetPosition(i2, z);
            this.mPosition = OplusGLSurfaceView_13;
        }

        void offsetPosition(int OplusGLSurfaceView_13, boolean z) {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == -1) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (z) {
                this.mPreLayoutPosition += OplusGLSurfaceView_13;
            }
            this.mPosition += OplusGLSurfaceView_13;
            if (this.itemView.getLayoutParams() != null) {
                ((C0694j) this.itemView.getLayoutParams()).f4041e = true;
            }
        }

        void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        void saveOldPosition() {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
        }

        boolean shouldIgnore() {
            return (this.mFlags & 128) != 0;
        }

        @Deprecated
        public final int getPosition() {
            int OplusGLSurfaceView_13 = this.mPreLayoutPosition;
            return OplusGLSurfaceView_13 == -1 ? this.mPosition : OplusGLSurfaceView_13;
        }

        public final int getLayoutPosition() {
            int OplusGLSurfaceView_13 = this.mPreLayoutPosition;
            return OplusGLSurfaceView_13 == -1 ? this.mPosition : OplusGLSurfaceView_13;
        }

        @Deprecated
        public final int getAdapterPosition() {
            return getBindingAdapterPosition();
        }

        public final int getBindingAdapterPosition() {
            RecyclerView recyclerView;
            AbstractC0685a adapter;
            int adapterPositionInRecyclerView;
            if (this.mBindingAdapter == null || (recyclerView = this.mOwnerRecyclerView) == null || (adapter = recyclerView.getAdapter()) == null || (adapterPositionInRecyclerView = this.mOwnerRecyclerView.getAdapterPositionInRecyclerView(this)) == -1) {
                return -1;
            }
            return adapter.findRelativeAdapterPositionIn(this.mBindingAdapter, this, adapterPositionInRecyclerView);
        }

        public final int getAbsoluteAdapterPosition() {
            RecyclerView recyclerView = this.mOwnerRecyclerView;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.getAdapterPositionInRecyclerView(this);
        }

        public final AbstractC0685a<? extends AbstractC0707w> getBindingAdapter() {
            return this.mBindingAdapter;
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        boolean isScrap() {
            return this.mScrapContainer != null;
        }

        void unScrap() {
            this.mScrapContainer.m4205c(this);
        }

        boolean wasReturnedFromScrap() {
            return (this.mFlags & 32) != 0;
        }

        void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        void stopIgnoring() {
            this.mFlags &= -129;
        }

        void setScrapContainer(C0700p c0700p, boolean z) {
            this.mScrapContainer = c0700p;
            this.mInChangeScrap = z;
        }

        boolean isInvalid() {
            return (this.mFlags & 4) != 0;
        }

        boolean needsUpdate() {
            return (this.mFlags & 2) != 0;
        }

        boolean isBound() {
            return (this.mFlags & 1) != 0;
        }

        boolean isRemoved() {
            return (this.mFlags & 8) != 0;
        }

        boolean hasAnyOfTheFlags(int OplusGLSurfaceView_13) {
            return (this.mFlags & OplusGLSurfaceView_13) != 0;
        }

        boolean isTmpDetached() {
            return (this.mFlags & 256) != 0;
        }

        boolean isAttachedToTransitionOverlay() {
            return (this.itemView.getParent() == null || this.itemView.getParent() == this.mOwnerRecyclerView) ? false : true;
        }

        boolean isAdapterPositionUnknown() {
            return (this.mFlags & 512) != 0 || isInvalid();
        }

        void setFlags(int OplusGLSurfaceView_13, int i2) {
            this.mFlags = (OplusGLSurfaceView_13 & i2) | (this.mFlags & (~i2));
        }

        void addFlags(int OplusGLSurfaceView_13) {
            this.mFlags = OplusGLSurfaceView_13 | this.mFlags;
        }

        void addChangePayload(Object obj) {
            if (obj == null) {
                addFlags(1024);
            } else if ((1024 & this.mFlags) == 0) {
                createPayloadsIfNeeded();
                this.mPayloads.add(obj);
            }
        }

        private void createPayloadsIfNeeded() {
            if (this.mPayloads == null) {
                this.mPayloads = new ArrayList();
                this.mUnmodifiedPayloads = Collections.unmodifiableList(this.mPayloads);
            }
        }

        void clearPayload() {
            List<Object> list = this.mPayloads;
            if (list != null) {
                list.clear();
            }
            this.mFlags &= -1025;
        }

        List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & 1024) == 0) {
                List<Object> list = this.mPayloads;
                if (list == null || list.size() == 0) {
                    return FULLUPDATE_PAYLOADS;
                }
                return this.mUnmodifiedPayloads;
            }
            return FULLUPDATE_PAYLOADS;
        }

        void resetInternal() {
            this.mFlags = 0;
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1L;
            this.mPreLayoutPosition = -1;
            this.mIsRecyclableCount = 0;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            clearPayload();
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            RecyclerView.clearNestedRecyclerViewIfNotNested(this);
        }

        void onEnteredHiddenState(RecyclerView recyclerView) {
            int OplusGLSurfaceView_13 = this.mPendingAccessibilityState;
            if (OplusGLSurfaceView_13 != -1) {
                this.mWasImportantForAccessibilityBeforeHidden = OplusGLSurfaceView_13;
            } else {
                this.mWasImportantForAccessibilityBeforeHidden = ViewCompat.m2883f(this.itemView);
            }
            recyclerView.setChildImportantForAccessibilityInternal(this, 4);
        }

        void onLeftHiddenState(RecyclerView recyclerView) {
            recyclerView.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder((getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName()) + "{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id_renamed=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
            if (isScrap()) {
                sb.append(" scrap ");
                sb.append(this.mInChangeScrap ? "[changeScrap]" : "[attachedScrap]");
            }
            if (isInvalid()) {
                sb.append(" invalid");
            }
            if (!isBound()) {
                sb.append(" unbound");
            }
            if (needsUpdate()) {
                sb.append(" update");
            }
            if (isRemoved()) {
                sb.append(" removed");
            }
            if (shouldIgnore()) {
                sb.append(" ignored");
            }
            if (isTmpDetached()) {
                sb.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                sb.append(" not recyclable(" + this.mIsRecyclableCount + ")");
            }
            if (isAdapterPositionUnknown()) {
                sb.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public final void setIsRecyclable(boolean z) {
            this.mIsRecyclableCount = z ? this.mIsRecyclableCount - 1 : this.mIsRecyclableCount + 1;
            int OplusGLSurfaceView_13 = this.mIsRecyclableCount;
            if (OplusGLSurfaceView_13 < 0) {
                this.mIsRecyclableCount = 0;
                Log.COUIBaseListPopupWindow_8("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                return;
            }
            if (!z && OplusGLSurfaceView_13 == 1) {
                this.mFlags |= 16;
            } else if (z && this.mIsRecyclableCount == 0) {
                this.mFlags &= -17;
            }
        }

        public final boolean isRecyclable() {
            return (this.mFlags & 16) == 0 && !ViewCompat.m2879d(this.itemView);
        }

        boolean shouldBeKeptAsChild() {
            return (this.mFlags & 16) != 0;
        }

        boolean doesTransientStatePreventRecycling() {
            return (this.mFlags & 16) == 0 && ViewCompat.m2879d(this.itemView);
        }

        boolean isUpdated() {
            return (this.mFlags & 2) != 0;
        }
    }

    boolean setChildImportantForAccessibilityInternal(AbstractC0707w abstractC0707w, int OplusGLSurfaceView_13) {
        if (isComputingLayout()) {
            abstractC0707w.mPendingAccessibilityState = OplusGLSurfaceView_13;
            this.mPendingAccessibilityImportanceChange.add(abstractC0707w);
            return false;
        }
        ViewCompat.m2867b(abstractC0707w.itemView, OplusGLSurfaceView_13);
        return true;
    }

    void dispatchPendingImportantForAccessibilityChanges() {
        int OplusGLSurfaceView_13;
        for (int size = this.mPendingAccessibilityImportanceChange.size() - 1; size >= 0; size--) {
            AbstractC0707w abstractC0707w = this.mPendingAccessibilityImportanceChange.get(size);
            if (abstractC0707w.itemView.getParent() == this && !abstractC0707w.shouldIgnore() && (OplusGLSurfaceView_13 = abstractC0707w.mPendingAccessibilityState) != -1) {
                ViewCompat.m2867b(abstractC0707w.itemView, OplusGLSurfaceView_13);
                abstractC0707w.mPendingAccessibilityState = -1;
            }
        }
        this.mPendingAccessibilityImportanceChange.clear();
    }

    int getAdapterPositionInRecyclerView(AbstractC0707w abstractC0707w) {
        if (abstractC0707w.hasAnyOfTheFlags(524) || !abstractC0707w.isBound()) {
            return -1;
        }
        return this.mAdapterHelper.m4363c(abstractC0707w.mPosition);
    }

    void initFastScroller(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + exceptionLabel());
        }
        Resources resources = getContext().getResources();
        new FastScroller(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(androidx.recyclerview.R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(androidx.recyclerview.R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(androidx.recyclerview.R.dimen.fastscroll_margin));
    }

    @Override // android.view.View, androidx.core.p036h.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().m2801a(z);
    }

    @Override // android.view.View, androidx.core.p036h.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().m2802a();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int OplusGLSurfaceView_13) {
        return getScrollingChildHelper().m2812b(OplusGLSurfaceView_13);
    }

    public boolean startNestedScroll(int OplusGLSurfaceView_13, int i2) {
        return getScrollingChildHelper().m2806a(OplusGLSurfaceView_13, i2);
    }

    @Override // android.view.View, androidx.core.p036h.NestedScrollingChild
    public void stopNestedScroll() {
        getScrollingChildHelper().m2813c();
    }

    public void stopNestedScroll(int OplusGLSurfaceView_13) {
        getScrollingChildHelper().m2814c(OplusGLSurfaceView_13);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().m2811b();
    }

    public boolean hasNestedScrollingParent(int OplusGLSurfaceView_13) {
        return getScrollingChildHelper().m2805a(OplusGLSurfaceView_13);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int OplusGLSurfaceView_13, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().m2807a(OplusGLSurfaceView_13, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedScroll(int OplusGLSurfaceView_13, int i2, int i3, int i4, int[] iArr, int i5) {
        return getScrollingChildHelper().m2808a(OplusGLSurfaceView_13, i2, i3, i4, iArr, i5);
    }

    public final void dispatchNestedScroll(int OplusGLSurfaceView_13, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        getScrollingChildHelper().m2800a(OplusGLSurfaceView_13, i2, i3, i4, iArr, i5, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int OplusGLSurfaceView_13, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().m2809a(OplusGLSurfaceView_13, i2, iArr, iArr2);
    }

    public boolean dispatchNestedPreScroll(int OplusGLSurfaceView_13, int i2, int[] iArr, int[] iArr2, int i3) {
        return getScrollingChildHelper().m2810a(OplusGLSurfaceView_13, i2, iArr, iArr2, i3);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float COUIBaseListPopupWindow_12, float f2, boolean z) {
        return getScrollingChildHelper().m2804a(COUIBaseListPopupWindow_12, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float COUIBaseListPopupWindow_12, float f2) {
        return getScrollingChildHelper().m2803a(COUIBaseListPopupWindow_12, f2);
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$OplusGLSurfaceView_15 */
    public static class C0694j extends ViewGroup.MarginLayoutParams {

        /* renamed from: IntrinsicsJvm.kt_3 */
        AbstractC0707w f4039c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        final Rect f4040d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        boolean f4041e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        boolean f4042f;

        public C0694j(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f4040d = new Rect();
            this.f4041e = true;
            this.f4042f = false;
        }

        public C0694j(int OplusGLSurfaceView_13, int i2) {
            super(OplusGLSurfaceView_13, i2);
            this.f4040d = new Rect();
            this.f4041e = true;
            this.f4042f = false;
        }

        public C0694j(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f4040d = new Rect();
            this.f4041e = true;
            this.f4042f = false;
        }

        public C0694j(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f4040d = new Rect();
            this.f4041e = true;
            this.f4042f = false;
        }

        public C0694j(C0694j c0694j) {
            super((ViewGroup.LayoutParams) c0694j);
            this.f4040d = new Rect();
            this.f4041e = true;
            this.f4042f = false;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public boolean m4154c() {
            return this.f4039c.isInvalid();
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        public boolean m4155d() {
            return this.f4039c.isRemoved();
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        public boolean m4156e() {
            return this.f4039c.isUpdated();
        }

        /* renamed from: COUIBaseListPopupWindow_12 */
        public int m4157f() {
            return this.f4039c.getLayoutPosition();
        }

        @Deprecated
        /* renamed from: COUIBaseListPopupWindow_11 */
        public int m4158g() {
            return this.f4039c.getBindingAdapterPosition();
        }

        /* renamed from: COUIBaseListPopupWindow_10 */
        public int m4159h() {
            return this.f4039c.getBindingAdapterPosition();
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$IntrinsicsJvm.kt_3 */
    public static abstract class AbstractC0687c {
        public void onChanged() {
        }

        public void onItemRangeChanged(int OplusGLSurfaceView_13, int i2) {
        }

        public void onItemRangeInserted(int OplusGLSurfaceView_13, int i2) {
        }

        public void onItemRangeMoved(int OplusGLSurfaceView_13, int i2, int i3) {
        }

        public void onItemRangeRemoved(int OplusGLSurfaceView_13, int i2) {
        }

        public void onStateRestorationPolicyChanged() {
        }

        public void onItemRangeChanged(int OplusGLSurfaceView_13, int i2, Object obj) {
            onItemRangeChanged(OplusGLSurfaceView_13, i2);
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$s */
    public static abstract class AbstractC0703s {
        private AbstractC0693i mLayoutManager;
        private boolean mPendingInitialRun;
        private RecyclerView mRecyclerView;
        private boolean mRunning;
        private boolean mStarted;
        private View mTargetView;
        private int mTargetPosition = -1;
        private final PlatformImplementations.kt_3 mRecyclingAction = new PlatformImplementations.kt_3(0, 0);

        /* renamed from: androidx.recyclerview.widget.RecyclerView$s$IntrinsicsJvm.kt_4 */
        public interface IntrinsicsJvm.kt_4 {
            PointF computeScrollVectorForPosition(int OplusGLSurfaceView_13);
        }

        protected abstract void onSeekTargetStep(int OplusGLSurfaceView_13, int i2, C0704t c0704t, PlatformImplementations.kt_3 aVar);

        protected abstract void onStart();

        protected abstract void onStop();

        protected abstract void onTargetFound(View view, C0704t c0704t, PlatformImplementations.kt_3 aVar);

        void start(RecyclerView recyclerView, AbstractC0693i abstractC0693i) {
            recyclerView.mViewFlinger.m4238b();
            if (this.mStarted) {
                Log.w(RecyclerView.TAG, "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create PlatformImplementations.kt_3 new instance for each use.");
            }
            this.mRecyclerView = recyclerView;
            this.mLayoutManager = abstractC0693i;
            if (this.mTargetPosition == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            this.mRecyclerView.mState.f4066a = this.mTargetPosition;
            this.mRunning = true;
            this.mPendingInitialRun = true;
            this.mTargetView = findViewByPosition(getTargetPosition());
            onStart();
            this.mRecyclerView.mViewFlinger.m4235a();
            this.mStarted = true;
        }

        public void setTargetPosition(int OplusGLSurfaceView_13) {
            this.mTargetPosition = OplusGLSurfaceView_13;
        }

        public PointF computeScrollVectorForPosition(int OplusGLSurfaceView_13) {
            Object layoutManager = getLayoutManager();
            if (layoutManager instanceof IntrinsicsJvm.kt_4) {
                return ((IntrinsicsJvm.kt_4) layoutManager).computeScrollVectorForPosition(OplusGLSurfaceView_13);
            }
            Log.w(RecyclerView.TAG, "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + IntrinsicsJvm.kt_4.class.getCanonicalName());
            return null;
        }

        public AbstractC0693i getLayoutManager() {
            return this.mLayoutManager;
        }

        protected final void stop() {
            if (this.mRunning) {
                this.mRunning = false;
                onStop();
                this.mRecyclerView.mState.f4066a = -1;
                this.mTargetView = null;
                this.mTargetPosition = -1;
                this.mPendingInitialRun = false;
                this.mLayoutManager.onSmoothScrollerStopped(this);
                this.mLayoutManager = null;
                this.mRecyclerView = null;
            }
        }

        public boolean isPendingInitialRun() {
            return this.mPendingInitialRun;
        }

        public boolean isRunning() {
            return this.mRunning;
        }

        public int getTargetPosition() {
            return this.mTargetPosition;
        }

        void onAnimation(int OplusGLSurfaceView_13, int i2) {
            PointF pointFComputeScrollVectorForPosition;
            RecyclerView recyclerView = this.mRecyclerView;
            if (this.mTargetPosition == -1 || recyclerView == null) {
                stop();
            }
            if (this.mPendingInitialRun && this.mTargetView == null && this.mLayoutManager != null && (pointFComputeScrollVectorForPosition = computeScrollVectorForPosition(this.mTargetPosition)) != null && (pointFComputeScrollVectorForPosition.x != 0.0f || pointFComputeScrollVectorForPosition.y != 0.0f)) {
                recyclerView.scrollStep((int) Math.signum(pointFComputeScrollVectorForPosition.x), (int) Math.signum(pointFComputeScrollVectorForPosition.y), null);
            }
            this.mPendingInitialRun = false;
            View view = this.mTargetView;
            if (view != null) {
                if (getChildPosition(view) == this.mTargetPosition) {
                    onTargetFound(this.mTargetView, recyclerView.mState, this.mRecyclingAction);
                    this.mRecyclingAction.m4222a(recyclerView);
                    stop();
                } else {
                    Log.COUIBaseListPopupWindow_8(RecyclerView.TAG, "Passed over target position while smooth scrolling.");
                    this.mTargetView = null;
                }
            }
            if (this.mRunning) {
                onSeekTargetStep(OplusGLSurfaceView_13, i2, recyclerView.mState, this.mRecyclingAction);
                boolean zM4223a = this.mRecyclingAction.m4223a();
                this.mRecyclingAction.m4222a(recyclerView);
                if (zM4223a && this.mRunning) {
                    this.mPendingInitialRun = true;
                    recyclerView.mViewFlinger.m4235a();
                }
            }
        }

        public int getChildPosition(View view) {
            return this.mRecyclerView.getChildLayoutPosition(view);
        }

        public int getChildCount() {
            return this.mRecyclerView.mLayout.getChildCount();
        }

        public View findViewByPosition(int OplusGLSurfaceView_13) {
            return this.mRecyclerView.mLayout.findViewByPosition(OplusGLSurfaceView_13);
        }

        @Deprecated
        public void instantScrollToPosition(int OplusGLSurfaceView_13) {
            this.mRecyclerView.scrollToPosition(OplusGLSurfaceView_13);
        }

        protected void onChildAttachedToWindow(View view) {
            if (getChildPosition(view) == getTargetPosition()) {
                this.mTargetView = view;
            }
        }

        protected void normalize(PointF pointF) {
            float fSqrt = (float) Math.sqrt((pointF.x * pointF.x) + (pointF.y * pointF.y));
            pointF.x /= fSqrt;
            pointF.y /= fSqrt;
        }

        /* renamed from: androidx.recyclerview.widget.RecyclerView$s$PlatformImplementations.kt_3 */
        public static class PlatformImplementations.kt_3 {

            /* renamed from: PlatformImplementations.kt_3 */
            private int f4059a;

            /* renamed from: IntrinsicsJvm.kt_4 */
            private int f4060b;

            /* renamed from: IntrinsicsJvm.kt_3 */
            private int f4061c;

            /* renamed from: IntrinsicsJvm.kt_5 */
            private int f4062d;

            /* renamed from: COUIBaseListPopupWindow_8 */
            private Interpolator f4063e;

            /* renamed from: COUIBaseListPopupWindow_12 */
            private boolean f4064f;

            /* renamed from: COUIBaseListPopupWindow_11 */
            private int f4065g;

            public PlatformImplementations.kt_3(int OplusGLSurfaceView_13, int i2) {
                this(OplusGLSurfaceView_13, i2, Integer.MIN_VALUE, null);
            }

            public PlatformImplementations.kt_3(int OplusGLSurfaceView_13, int i2, int i3, Interpolator interpolator) {
                this.f4062d = -1;
                this.f4064f = false;
                this.f4065g = 0;
                this.f4059a = OplusGLSurfaceView_13;
                this.f4060b = i2;
                this.f4061c = i3;
                this.f4063e = interpolator;
            }

            /* renamed from: PlatformImplementations.kt_3 */
            public void m4220a(int OplusGLSurfaceView_13) {
                this.f4062d = OplusGLSurfaceView_13;
            }

            /* renamed from: PlatformImplementations.kt_3 */
            boolean m4223a() {
                return this.f4062d >= 0;
            }

            /* renamed from: PlatformImplementations.kt_3 */
            void m4222a(RecyclerView recyclerView) {
                int OplusGLSurfaceView_13 = this.f4062d;
                if (OplusGLSurfaceView_13 >= 0) {
                    this.f4062d = -1;
                    recyclerView.jumpToPositionForSmoothScroller(OplusGLSurfaceView_13);
                    this.f4064f = false;
                } else {
                    if (this.f4064f) {
                        m4219b();
                        recyclerView.mViewFlinger.m4237a(this.f4059a, this.f4060b, this.f4061c, this.f4063e);
                        this.f4065g++;
                        if (this.f4065g > 10) {
                            Log.COUIBaseListPopupWindow_8(RecyclerView.TAG, "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                        }
                        this.f4064f = false;
                        return;
                    }
                    this.f4065g = 0;
                }
            }

            /* renamed from: IntrinsicsJvm.kt_4 */
            private void m4219b() {
                if (this.f4063e != null && this.f4061c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set PlatformImplementations.kt_3 positive duration");
                }
                if (this.f4061c < 1) {
                    throw new IllegalStateException("Scroll duration must be PlatformImplementations.kt_3 positive number");
                }
            }

            /* renamed from: PlatformImplementations.kt_3 */
            public void m4221a(int OplusGLSurfaceView_13, int i2, int i3, Interpolator interpolator) {
                this.f4059a = OplusGLSurfaceView_13;
                this.f4060b = i2;
                this.f4061c = i3;
                this.f4063e = interpolator;
                this.f4064f = true;
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$IntrinsicsJvm.kt_4 */
    static class C0686b extends Observable<AbstractC0687c> {
        C0686b() {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public boolean m4113a() {
            return !this.mObservers.isEmpty();
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m4114b() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AbstractC0687c) this.mObservers.get(size)).onChanged();
            }
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public void m4116c() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AbstractC0687c) this.mObservers.get(size)).onStateRestorationPolicyChanged();
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m4111a(int OplusGLSurfaceView_13, int i2) {
            m4112a(OplusGLSurfaceView_13, i2, null);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m4112a(int OplusGLSurfaceView_13, int i2, Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AbstractC0687c) this.mObservers.get(size)).onItemRangeChanged(OplusGLSurfaceView_13, i2, obj);
            }
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m4115b(int OplusGLSurfaceView_13, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AbstractC0687c) this.mObservers.get(size)).onItemRangeInserted(OplusGLSurfaceView_13, i2);
            }
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public void m4117c(int OplusGLSurfaceView_13, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AbstractC0687c) this.mObservers.get(size)).onItemRangeRemoved(OplusGLSurfaceView_13, i2);
            }
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        public void m4118d(int OplusGLSurfaceView_13, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AbstractC0687c) this.mObservers.get(size)).onItemRangeMoved(OplusGLSurfaceView_13, i2, 1);
            }
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.recyclerview.widget.RecyclerView.SavedState.1
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
        Parcelable mLayoutState;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.mLayoutState = parcel.readParcelable(classLoader == null ? AbstractC0693i.class.getClassLoader() : classLoader);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
            super.writeToParcel(parcel, OplusGLSurfaceView_13);
            parcel.writeParcelable(this.mLayoutState, 0);
        }

        void copyFrom(SavedState savedState) {
            this.mLayoutState = savedState.mLayoutState;
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$t */
    public static class C0704t {

        /* renamed from: PlatformImplementations.kt_3 */
        int f4066a = -1;

        /* renamed from: IntrinsicsJvm.kt_4 */
        int f4067b = 0;

        /* renamed from: IntrinsicsJvm.kt_3 */
        int f4068c = 0;

        /* renamed from: IntrinsicsJvm.kt_5 */
        int f4069d = 1;

        /* renamed from: COUIBaseListPopupWindow_8 */
        int f4070e = 0;

        /* renamed from: COUIBaseListPopupWindow_12 */
        boolean f4071f = false;

        /* renamed from: COUIBaseListPopupWindow_11 */
        boolean f4072g = false;

        /* renamed from: COUIBaseListPopupWindow_10 */
        boolean f4073h = false;

        /* renamed from: OplusGLSurfaceView_13 */
        boolean f4074i = false;

        /* renamed from: OplusGLSurfaceView_15 */
        boolean f4075j = false;

        /* renamed from: OplusGLSurfaceView_5 */
        boolean f4076k = false;

        /* renamed from: OplusGLSurfaceView_14 */
        int f4077l;

        /* renamed from: OplusGLSurfaceView_6 */
        long f4078m;

        /* renamed from: OplusGLSurfaceView_11 */
        int f4079n;

        /* renamed from: o */
        int f4080o;

        /* renamed from: p */
        int f4081p;

        /* renamed from: q */
        private SparseArray<Object> f4082q;

        /* renamed from: PlatformImplementations.kt_3 */
        void m4224a(int OplusGLSurfaceView_13) {
            if ((this.f4069d & OplusGLSurfaceView_13) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(OplusGLSurfaceView_13) + " but it is " + Integer.toBinaryString(this.f4069d));
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m4225a(AbstractC0685a abstractC0685a) {
            this.f4069d = 1;
            this.f4070e = abstractC0685a.getItemCount();
            this.f4072g = false;
            this.f4073h = false;
            this.f4074i = false;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public boolean m4226a() {
            return this.f4072g;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public boolean m4227b() {
            return this.f4076k;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public int m4228c() {
            return this.f4066a;
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        public boolean m4229d() {
            return this.f4066a != -1;
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        public int m4230e() {
            if (this.f4072g) {
                return this.f4067b - this.f4068c;
            }
            return this.f4070e;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f4066a + ", mData=" + this.f4082q + ", mItemCount=" + this.f4070e + ", mIsMeasuring=" + this.f4074i + ", mPreviousLayoutItemCount=" + this.f4067b + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f4068c + ", mStructureChanged=" + this.f4071f + ", mInPreLayout=" + this.f4072g + ", mRunSimpleAnimations=" + this.f4075j + ", mRunPredictiveAnimations=" + this.f4076k + '}';
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$COUIBaseListPopupWindow_11 */
    private class C0691g implements AbstractC0690f.IntrinsicsJvm.kt_4 {
        C0691g() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0690f.IntrinsicsJvm.kt_4
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo4145a(AbstractC0707w abstractC0707w) {
            abstractC0707w.setIsRecyclable(true);
            if (abstractC0707w.mShadowedHolder != null && abstractC0707w.mShadowingHolder == null) {
                abstractC0707w.mShadowedHolder = null;
            }
            abstractC0707w.mShadowingHolder = null;
            if (abstractC0707w.shouldBeKeptAsChild() || RecyclerView.this.removeAnimatingView(abstractC0707w.itemView) || !abstractC0707w.isTmpDetached()) {
                return;
            }
            RecyclerView.this.removeDetachedView(abstractC0707w.itemView, false);
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$COUIBaseListPopupWindow_12 */
    public static abstract class AbstractC0690f {

        /* renamed from: PlatformImplementations.kt_3 */
        private IntrinsicsJvm.kt_4 f4022a = null;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private ArrayList<PlatformImplementations.kt_3> f4023b = new ArrayList<>();

        /* renamed from: IntrinsicsJvm.kt_3 */
        private long f4024c = 120;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private long f4025d = 120;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private long f4026e = 250;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private long f4027f = 250;

        /* renamed from: androidx.recyclerview.widget.RecyclerView$COUIBaseListPopupWindow_12$PlatformImplementations.kt_3 */
        public interface PlatformImplementations.kt_3 {
            /* renamed from: PlatformImplementations.kt_3 */
            void m4144a();
        }

        /* renamed from: androidx.recyclerview.widget.RecyclerView$COUIBaseListPopupWindow_12$IntrinsicsJvm.kt_4 */
        interface IntrinsicsJvm.kt_4 {
            /* renamed from: PlatformImplementations.kt_3 */
            void mo4145a(AbstractC0707w abstractC0707w);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public abstract void mo4124a();

        /* renamed from: PlatformImplementations.kt_3 */
        public abstract boolean mo4127a(AbstractC0707w abstractC0707w, IntrinsicsJvm.kt_3 cVar, IntrinsicsJvm.kt_3 cVar2);

        /* renamed from: PlatformImplementations.kt_3 */
        public abstract boolean mo4128a(AbstractC0707w abstractC0707w, AbstractC0707w abstractC0707w2, IntrinsicsJvm.kt_3 cVar, IntrinsicsJvm.kt_3 cVar2);

        /* renamed from: IntrinsicsJvm.kt_4 */
        public abstract boolean mo4130b();

        /* renamed from: IntrinsicsJvm.kt_4 */
        public abstract boolean mo4131b(AbstractC0707w abstractC0707w, IntrinsicsJvm.kt_3 cVar, IntrinsicsJvm.kt_3 cVar2);

        /* renamed from: IntrinsicsJvm.kt_3 */
        public abstract boolean mo4132c(AbstractC0707w abstractC0707w, IntrinsicsJvm.kt_3 cVar, IntrinsicsJvm.kt_3 cVar2);

        /* renamed from: IntrinsicsJvm.kt_5 */
        public abstract void mo4133d();

        /* renamed from: IntrinsicsJvm.kt_5 */
        public abstract void mo4134d(AbstractC0707w abstractC0707w);

        /* renamed from: COUIBaseListPopupWindow_11 */
        public void m4139g(AbstractC0707w abstractC0707w) {
        }

        /* renamed from: COUIBaseListPopupWindow_10 */
        public boolean mo4141h(AbstractC0707w abstractC0707w) {
            return true;
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        public long m4135e() {
            return this.f4026e;
        }

        /* renamed from: COUIBaseListPopupWindow_12 */
        public long m4136f() {
            return this.f4024c;
        }

        /* renamed from: COUIBaseListPopupWindow_11 */
        public long m4138g() {
            return this.f4025d;
        }

        /* renamed from: COUIBaseListPopupWindow_10 */
        public long m4140h() {
            return this.f4027f;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m4125a(long OplusGLSurfaceView_15) {
            this.f4027f = OplusGLSurfaceView_15;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m4126a(IntrinsicsJvm.kt_4 bVar) {
            this.f4022a = bVar;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public IntrinsicsJvm.kt_3 m4123a(C0704t c0704t, AbstractC0707w abstractC0707w, int OplusGLSurfaceView_13, List<Object> list) {
            return m4143j().m4146a(abstractC0707w);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public IntrinsicsJvm.kt_3 m4122a(C0704t c0704t, AbstractC0707w abstractC0707w) {
            return m4143j().m4146a(abstractC0707w);
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        static int m4121e(AbstractC0707w abstractC0707w) {
            int OplusGLSurfaceView_13 = abstractC0707w.mFlags & 14;
            if (abstractC0707w.isInvalid()) {
                return 4;
            }
            if ((OplusGLSurfaceView_13 & 4) != 0) {
                return OplusGLSurfaceView_13;
            }
            int oldPosition = abstractC0707w.getOldPosition();
            int absoluteAdapterPosition = abstractC0707w.getAbsoluteAdapterPosition();
            return (oldPosition == -1 || absoluteAdapterPosition == -1 || oldPosition == absoluteAdapterPosition) ? OplusGLSurfaceView_13 : OplusGLSurfaceView_13 | 2048;
        }

        /* renamed from: COUIBaseListPopupWindow_12 */
        public final void m4137f(AbstractC0707w abstractC0707w) {
            m4139g(abstractC0707w);
            IntrinsicsJvm.kt_4 bVar = this.f4022a;
            if (bVar != null) {
                bVar.mo4145a(abstractC0707w);
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo4129a(AbstractC0707w abstractC0707w, List<Object> list) {
            return mo4141h(abstractC0707w);
        }

        /* renamed from: OplusGLSurfaceView_13 */
        public final void m4142i() {
            int size = this.f4023b.size();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                this.f4023b.get(OplusGLSurfaceView_13).m4144a();
            }
            this.f4023b.clear();
        }

        /* renamed from: OplusGLSurfaceView_15 */
        public IntrinsicsJvm.kt_3 m4143j() {
            return new IntrinsicsJvm.kt_3();
        }

        /* renamed from: androidx.recyclerview.widget.RecyclerView$COUIBaseListPopupWindow_12$IntrinsicsJvm.kt_3 */
        public static class IntrinsicsJvm.kt_3 {

            /* renamed from: PlatformImplementations.kt_3 */
            public int f4028a;

            /* renamed from: IntrinsicsJvm.kt_4 */
            public int f4029b;

            /* renamed from: IntrinsicsJvm.kt_3 */
            public int f4030c;

            /* renamed from: IntrinsicsJvm.kt_5 */
            public int f4031d;

            /* renamed from: PlatformImplementations.kt_3 */
            public IntrinsicsJvm.kt_3 m4146a(AbstractC0707w abstractC0707w) {
                return m4147a(abstractC0707w, 0);
            }

            /* renamed from: PlatformImplementations.kt_3 */
            public IntrinsicsJvm.kt_3 m4147a(AbstractC0707w abstractC0707w, int OplusGLSurfaceView_13) {
                View view = abstractC0707w.itemView;
                this.f4028a = view.getLeft();
                this.f4029b = view.getTop();
                this.f4030c = view.getRight();
                this.f4031d = view.getBottom();
                return this;
            }
        }
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int OplusGLSurfaceView_13, int i2) {
        InterfaceC0688d interfaceC0688d = this.mChildDrawingOrderCallback;
        if (interfaceC0688d == null) {
            return super.getChildDrawingOrder(OplusGLSurfaceView_13, i2);
        }
        return interfaceC0688d.m4119a(OplusGLSurfaceView_13, i2);
    }

    private NestedScrollingChildHelper getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            this.mScrollingChildHelper = new NestedScrollingChildHelper(this);
        }
        return this.mScrollingChildHelper;
    }
}
