package androidx.recyclerview.widget;

/* loaded from: classes.dex */
public class RecyclerView extends android.view.ViewGroup implements androidx.core.h_renamed.j_renamed, androidx.core.h_renamed.k_renamed, androidx.core.h_renamed.t_renamed {
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
    private static final java.lang.Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
    static final int MAX_SCROLL_DURATION = 2000;
    private static final int[] NESTED_SCROLLING_ATTRS = {android.R_renamed.attr.nestedScrollingEnabled};
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    static final boolean POST_UPDATES_ON_ANIMATION;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static final java.lang.String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    static final java.lang.String TRACE_BIND_VIEW_TAG = "RV OnBindView";
    static final java.lang.String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    private static final java.lang.String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    static final java.lang.String TRACE_NESTED_PREFETCH_TAG = "RV Nested Prefetch";
    private static final java.lang.String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    private static final java.lang.String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    static final java.lang.String TRACE_PREFETCH_TAG = "RV Prefetch";
    static final java.lang.String TRACE_SCROLL_TAG = "RV Scroll";
    public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
    static final boolean VERBOSE_TRACING = false;
    public static final int VERTICAL = 1;
    static final android.view.animation.Interpolator sQuinticInterpolator;
    androidx.recyclerview.widget.p_renamed mAccessibilityDelegate;
    private final android.view.accessibility.AccessibilityManager mAccessibilityManager;
    androidx.recyclerview.widget.RecyclerView.a_renamed mAdapter;
    androidx.recyclerview.widget.a_renamed mAdapterHelper;
    boolean mAdapterUpdateDuringMeasure;
    private android.widget.EdgeEffect mBottomGlow;
    private androidx.recyclerview.widget.RecyclerView.d_renamed mChildDrawingOrderCallback;
    androidx.recyclerview.widget.d_renamed mChildHelper;
    boolean mClipToPadding;
    boolean mDataSetHasChangedAfterLayout;
    boolean mDispatchItemsChangedEvent;
    private int mDispatchScrollCounter;
    private int mEatenAccessibilityChangeFlags;
    private androidx.recyclerview.widget.RecyclerView.e_renamed mEdgeEffectFactory;
    boolean mEnableFastScroller;
    boolean mFirstLayoutComplete;
    androidx.recyclerview.widget.h_renamed mGapWorker;
    boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mInterceptRequestLayoutDepth;
    private androidx.recyclerview.widget.RecyclerView.m_renamed mInterceptingOnItemTouchListener;
    boolean mIsAttached;
    androidx.recyclerview.widget.RecyclerView.f_renamed mItemAnimator;
    private androidx.recyclerview.widget.RecyclerView.f_renamed.b_renamed mItemAnimatorListener;
    private java.lang.Runnable mItemAnimatorRunner;
    final java.util.ArrayList<androidx.recyclerview.widget.RecyclerView.h_renamed> mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastTouchX;
    private int mLastTouchY;
    androidx.recyclerview.widget.RecyclerView.i_renamed mLayout;
    private int mLayoutOrScrollCounter;
    boolean mLayoutSuppressed;
    boolean mLayoutWasDefered;
    private android.widget.EdgeEffect mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final androidx.recyclerview.widget.RecyclerView.r_renamed mObserver;
    private java.util.List<androidx.recyclerview.widget.RecyclerView.k_renamed> mOnChildAttachStateListeners;
    private androidx.recyclerview.widget.RecyclerView.l_renamed mOnFlingListener;
    private final java.util.ArrayList<androidx.recyclerview.widget.RecyclerView.m_renamed> mOnItemTouchListeners;
    final java.util.List<androidx.recyclerview.widget.RecyclerView.w_renamed> mPendingAccessibilityImportanceChange;
    androidx.recyclerview.widget.RecyclerView.SavedState mPendingSavedState;
    boolean mPostedAnimatorRunner;
    androidx.recyclerview.widget.h_renamed.a_renamed mPrefetchRegistry;
    private boolean mPreserveFocusAfterLayout;
    final androidx.recyclerview.widget.RecyclerView.p_renamed mRecycler;
    androidx.recyclerview.widget.RecyclerView.q_renamed mRecyclerListener;
    final int[] mReusableIntPair;
    private android.widget.EdgeEffect mRightGlow;
    private float mScaledHorizontalScrollFactor;
    private float mScaledVerticalScrollFactor;
    private androidx.recyclerview.widget.RecyclerView.n_renamed mScrollListener;
    private java.util.List<androidx.recyclerview.widget.RecyclerView.n_renamed> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private androidx.core.h_renamed.l_renamed mScrollingChildHelper;
    final androidx.recyclerview.widget.RecyclerView.t_renamed mState;
    final android.graphics.Rect mTempRect;
    private final android.graphics.Rect mTempRect2;
    final android.graphics.RectF mTempRectF;
    private android.widget.EdgeEffect mTopGlow;
    private int mTouchSlop;
    final java.lang.Runnable mUpdateChildViewsRunnable;
    private android.view.VelocityTracker mVelocityTracker;
    final androidx.recyclerview.widget.RecyclerView.v_renamed mViewFlinger;
    private final androidx.recyclerview.widget.u_renamed.b_renamed mViewInfoProcessCallback;
    final androidx.recyclerview.widget.u_renamed mViewInfoStore;

    public interface d_renamed {
        int a_renamed(int i_renamed, int i2);
    }

    public interface k_renamed {
        void a_renamed(android.view.View view);

        void b_renamed(android.view.View view);
    }

    public static abstract class l_renamed {
        public abstract boolean a_renamed(int i_renamed, int i2);
    }

    public interface m_renamed {
        void a_renamed(boolean z_renamed);

        boolean a_renamed(androidx.recyclerview.widget.RecyclerView recyclerView, android.view.MotionEvent motionEvent);

        void b_renamed(androidx.recyclerview.widget.RecyclerView recyclerView, android.view.MotionEvent motionEvent);
    }

    public static abstract class n_renamed {
        public void onScrollStateChanged(androidx.recyclerview.widget.RecyclerView recyclerView, int i_renamed) {
        }

        public void onScrolled(androidx.recyclerview.widget.RecyclerView recyclerView, int i_renamed, int i2) {
        }
    }

    public interface q_renamed {
        void a_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar);
    }

    public static abstract class u_renamed {
        public abstract android.view.View a_renamed(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, int i_renamed, int i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public java.lang.CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public void onChildAttachedToWindow(android.view.View view) {
    }

    public void onChildDetachedFromWindow(android.view.View view) {
    }

    public void onScrollStateChanged(int i2) {
    }

    public void onScrolled(int i2, int i3) {
    }

    static {
        FORCE_INVALIDATE_DISPLAY_LIST = android.os.Build.VERSION.SDK_INT == 18 || android.os.Build.VERSION.SDK_INT == 19 || android.os.Build.VERSION.SDK_INT == 20;
        ALLOW_SIZE_IN_UNSPECIFIED_SPEC = android.os.Build.VERSION.SDK_INT >= 23;
        POST_UPDATES_ON_ANIMATION = android.os.Build.VERSION.SDK_INT >= 16;
        ALLOW_THREAD_GAP_WORK = android.os.Build.VERSION.SDK_INT >= 21;
        FORCE_ABS_FOCUS_SEARCH_DIRECTION = android.os.Build.VERSION.SDK_INT <= 15;
        IGNORE_DETACHED_FOCUSED_CHILD = android.os.Build.VERSION.SDK_INT <= 15;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new java.lang.Class[]{android.content.Context.class, android.util.AttributeSet.class, java.lang.Integer.TYPE, java.lang.Integer.TYPE};
        sQuinticInterpolator = new android.view.animation.Interpolator() { // from class: androidx.recyclerview.widget.RecyclerView.3
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f2) {
                float f3 = f2 - 1.0f;
                return (f3 * f3 * f3 * f3 * f3) + 1.0f;
            }
        };
    }

    public RecyclerView(android.content.Context context) {
        this(context, null);
    }

    public RecyclerView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, androidx.recyclerview.R_renamed.attr.recyclerViewStyle);
    }

    public RecyclerView(android.content.Context context, android.util.AttributeSet attributeSet, int i2) throws java.lang.NoSuchMethodException, java.lang.SecurityException {
        super(context, attributeSet, i2);
        this.mObserver = new androidx.recyclerview.widget.RecyclerView.r_renamed();
        this.mRecycler = new androidx.recyclerview.widget.RecyclerView.p_renamed();
        this.mViewInfoStore = new androidx.recyclerview.widget.u_renamed();
        this.mUpdateChildViewsRunnable = new java.lang.Runnable() { // from class: androidx.recyclerview.widget.RecyclerView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!androidx.recyclerview.widget.RecyclerView.this.mFirstLayoutComplete || androidx.recyclerview.widget.RecyclerView.this.isLayoutRequested()) {
                    return;
                }
                if (!androidx.recyclerview.widget.RecyclerView.this.mIsAttached) {
                    androidx.recyclerview.widget.RecyclerView.this.requestLayout();
                } else if (androidx.recyclerview.widget.RecyclerView.this.mLayoutSuppressed) {
                    androidx.recyclerview.widget.RecyclerView.this.mLayoutWasDefered = true;
                } else {
                    androidx.recyclerview.widget.RecyclerView.this.consumePendingUpdateOperations();
                }
            }
        };
        this.mTempRect = new android.graphics.Rect();
        this.mTempRect2 = new android.graphics.Rect();
        this.mTempRectF = new android.graphics.RectF();
        this.mItemDecorations = new java.util.ArrayList<>();
        this.mOnItemTouchListeners = new java.util.ArrayList<>();
        this.mInterceptRequestLayoutDepth = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        this.mEdgeEffectFactory = new androidx.recyclerview.widget.RecyclerView.e_renamed();
        this.mItemAnimator = new androidx.recyclerview.widget.e_renamed();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        boolean z_renamed = true;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new androidx.recyclerview.widget.RecyclerView.v_renamed();
        this.mPrefetchRegistry = ALLOW_THREAD_GAP_WORK ? new androidx.recyclerview.widget.h_renamed.a_renamed() : null;
        this.mState = new androidx.recyclerview.widget.RecyclerView.t_renamed();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new androidx.recyclerview.widget.RecyclerView.g_renamed();
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
        this.mReusableIntPair = new int[2];
        this.mPendingAccessibilityImportanceChange = new java.util.ArrayList();
        this.mItemAnimatorRunner = new java.lang.Runnable() { // from class: androidx.recyclerview.widget.RecyclerView.2
            @Override // java.lang.Runnable
            public void run() {
                if (androidx.recyclerview.widget.RecyclerView.this.mItemAnimator != null) {
                    androidx.recyclerview.widget.RecyclerView.this.mItemAnimator.a_renamed();
                }
                androidx.recyclerview.widget.RecyclerView.this.mPostedAnimatorRunner = false;
            }
        };
        this.mViewInfoProcessCallback = new androidx.recyclerview.widget.u_renamed.b_renamed() { // from class: androidx.recyclerview.widget.RecyclerView.4
            @Override // androidx.recyclerview.widget.u_renamed.b_renamed
            public void a_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar, androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed cVar, androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed cVar2) {
                androidx.recyclerview.widget.RecyclerView.this.mRecycler.c_renamed(wVar);
                androidx.recyclerview.widget.RecyclerView.this.animateDisappearance(wVar, cVar, cVar2);
            }

            @Override // androidx.recyclerview.widget.u_renamed.b_renamed
            public void b_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar, androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed cVar, androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed cVar2) {
                androidx.recyclerview.widget.RecyclerView.this.animateAppearance(wVar, cVar, cVar2);
            }

            @Override // androidx.recyclerview.widget.u_renamed.b_renamed
            public void c_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar, androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed cVar, androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed cVar2) {
                wVar.setIsRecyclable(false);
                if (androidx.recyclerview.widget.RecyclerView.this.mDataSetHasChangedAfterLayout) {
                    if (androidx.recyclerview.widget.RecyclerView.this.mItemAnimator.a_renamed(wVar, wVar, cVar, cVar2)) {
                        androidx.recyclerview.widget.RecyclerView.this.postAnimationRunner();
                    }
                } else if (androidx.recyclerview.widget.RecyclerView.this.mItemAnimator.c_renamed(wVar, cVar, cVar2)) {
                    androidx.recyclerview.widget.RecyclerView.this.postAnimationRunner();
                }
            }

            @Override // androidx.recyclerview.widget.u_renamed.b_renamed
            public void a_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
                androidx.recyclerview.widget.RecyclerView.this.mLayout.removeAndRecycleView(wVar.itemView, androidx.recyclerview.widget.RecyclerView.this.mRecycler);
            }
        };
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        android.view.ViewConfiguration viewConfiguration = android.view.ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mScaledHorizontalScrollFactor = androidx.core.h_renamed.w_renamed.a_renamed(viewConfiguration, context);
        this.mScaledVerticalScrollFactor = androidx.core.h_renamed.w_renamed.b_renamed(viewConfiguration, context);
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.mItemAnimator.a_renamed(this.mItemAnimatorListener);
        initAdapterManager();
        initChildrenHelper();
        initAutofill();
        if (androidx.core.h_renamed.v_renamed.f_renamed(this) == 0) {
            androidx.core.h_renamed.v_renamed.b_renamed((android.view.View) this, 1);
        }
        this.mAccessibilityManager = (android.view.accessibility.AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new androidx.recyclerview.widget.p_renamed(this));
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.recyclerview.R_renamed.styleable.RecyclerView, i2, 0);
        androidx.core.h_renamed.v_renamed.a_renamed(this, context, androidx.recyclerview.R_renamed.styleable.RecyclerView, attributeSet, typedArrayObtainStyledAttributes, i2, 0);
        java.lang.String string = typedArrayObtainStyledAttributes.getString(androidx.recyclerview.R_renamed.styleable.RecyclerView_layoutManager);
        if (typedArrayObtainStyledAttributes.getInt(androidx.recyclerview.R_renamed.styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
            setDescendantFocusability(com.sensetime.stmobile.STMobileHumanActionNative.ST_MOBILE_DETECT_MODE_IMAGE);
        }
        this.mClipToPadding = typedArrayObtainStyledAttributes.getBoolean(androidx.recyclerview.R_renamed.styleable.RecyclerView_android_clipToPadding, true);
        this.mEnableFastScroller = typedArrayObtainStyledAttributes.getBoolean(androidx.recyclerview.R_renamed.styleable.RecyclerView_fastScrollEnabled, false);
        if (this.mEnableFastScroller) {
            initFastScroller((android.graphics.drawable.StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(androidx.recyclerview.R_renamed.styleable.RecyclerView_fastScrollVerticalThumbDrawable), typedArrayObtainStyledAttributes.getDrawable(androidx.recyclerview.R_renamed.styleable.RecyclerView_fastScrollVerticalTrackDrawable), (android.graphics.drawable.StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(androidx.recyclerview.R_renamed.styleable.RecyclerView_fastScrollHorizontalThumbDrawable), typedArrayObtainStyledAttributes.getDrawable(androidx.recyclerview.R_renamed.styleable.RecyclerView_fastScrollHorizontalTrackDrawable));
        }
        typedArrayObtainStyledAttributes.recycle();
        createLayoutManager(context, string, attributeSet, i2, 0);
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            android.content.res.TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, NESTED_SCROLLING_ATTRS, i2, 0);
            androidx.core.h_renamed.v_renamed.a_renamed(this, context, NESTED_SCROLLING_ATTRS, attributeSet, typedArrayObtainStyledAttributes2, i2, 0);
            z_renamed = typedArrayObtainStyledAttributes2.getBoolean(0, true);
            typedArrayObtainStyledAttributes2.recycle();
        }
        setNestedScrollingEnabled(z_renamed);
    }

    java.lang.String exceptionLabel() {
        return " " + super.toString() + ", adapter:" + this.mAdapter + ", layout:" + this.mLayout + ", context:" + getContext();
    }

    @android.annotation.SuppressLint({"InlinedApi"})
    private void initAutofill() {
        if (androidx.core.h_renamed.v_renamed.a_renamed(this) == 0) {
            androidx.core.h_renamed.v_renamed.a_renamed((android.view.View) this, 8);
        }
    }

    public androidx.recyclerview.widget.p_renamed getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void setAccessibilityDelegateCompat(androidx.recyclerview.widget.p_renamed pVar) {
        this.mAccessibilityDelegate = pVar;
        androidx.core.h_renamed.v_renamed.a_renamed(this, this.mAccessibilityDelegate);
    }

    private void createLayoutManager(android.content.Context context, java.lang.String str, android.util.AttributeSet attributeSet, int i2, int i3) throws java.lang.NoSuchMethodException, java.lang.SecurityException {
        java.lang.ClassLoader classLoader;
        java.lang.reflect.Constructor constructor;
        if (str != null) {
            java.lang.String strTrim = str.trim();
            if (strTrim.isEmpty()) {
                return;
            }
            java.lang.String fullClassName = getFullClassName(context, strTrim);
            try {
                if (isInEditMode()) {
                    classLoader = getClass().getClassLoader();
                } else {
                    classLoader = context.getClassLoader();
                }
                java.lang.Class<? extends U_renamed> clsAsSubclass = java.lang.Class.forName(fullClassName, false, classLoader).asSubclass(androidx.recyclerview.widget.RecyclerView.i_renamed.class);
                java.lang.Object[] objArr = null;
                try {
                    constructor = clsAsSubclass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                    objArr = new java.lang.Object[]{context, attributeSet, java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3)};
                } catch (java.lang.NoSuchMethodException e2) {
                    try {
                        constructor = clsAsSubclass.getConstructor(new java.lang.Class[0]);
                    } catch (java.lang.NoSuchMethodException e3) {
                        e3.initCause(e2);
                        throw new java.lang.IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + fullClassName, e3);
                    }
                }
                constructor.setAccessible(true);
                setLayoutManager((androidx.recyclerview.widget.RecyclerView.i_renamed) constructor.newInstance(objArr));
            } catch (java.lang.ClassCastException e4) {
                throw new java.lang.IllegalStateException(attributeSet.getPositionDescription() + ": Class is_renamed not a_renamed LayoutManager " + fullClassName, e4);
            } catch (java.lang.ClassNotFoundException e5) {
                throw new java.lang.IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + fullClassName, e5);
            } catch (java.lang.IllegalAccessException e6) {
                throw new java.lang.IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + fullClassName, e6);
            } catch (java.lang.InstantiationException e7) {
                throw new java.lang.IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e7);
            } catch (java.lang.reflect.InvocationTargetException e8) {
                throw new java.lang.IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e8);
            }
        }
    }

    private java.lang.String getFullClassName(android.content.Context context, java.lang.String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        if (str.contains(".")) {
            return str;
        }
        return androidx.recyclerview.widget.RecyclerView.class.getPackage().getName() + '.' + str;
    }

    private void initChildrenHelper() {
        this.mChildHelper = new androidx.recyclerview.widget.d_renamed(new androidx.recyclerview.widget.d_renamed.b_renamed() { // from class: androidx.recyclerview.widget.RecyclerView.5
            @Override // androidx.recyclerview.widget.d_renamed.b_renamed
            public int a_renamed() {
                return androidx.recyclerview.widget.RecyclerView.this.getChildCount();
            }

            @Override // androidx.recyclerview.widget.d_renamed.b_renamed
            public void a_renamed(android.view.View view, int i2) {
                androidx.recyclerview.widget.RecyclerView.this.addView(view, i2);
                androidx.recyclerview.widget.RecyclerView.this.dispatchChildAttached(view);
            }

            @Override // androidx.recyclerview.widget.d_renamed.b_renamed
            public int a_renamed(android.view.View view) {
                return androidx.recyclerview.widget.RecyclerView.this.indexOfChild(view);
            }

            @Override // androidx.recyclerview.widget.d_renamed.b_renamed
            public void a_renamed(int i2) {
                android.view.View childAt = androidx.recyclerview.widget.RecyclerView.this.getChildAt(i2);
                if (childAt != null) {
                    androidx.recyclerview.widget.RecyclerView.this.dispatchChildDetached(childAt);
                    childAt.clearAnimation();
                }
                androidx.recyclerview.widget.RecyclerView.this.removeViewAt(i2);
            }

            @Override // androidx.recyclerview.widget.d_renamed.b_renamed
            public android.view.View b_renamed(int i2) {
                return androidx.recyclerview.widget.RecyclerView.this.getChildAt(i2);
            }

            @Override // androidx.recyclerview.widget.d_renamed.b_renamed
            public void b_renamed() {
                int iA = a_renamed();
                for (int i2 = 0; i2 < iA; i2++) {
                    android.view.View viewB = b_renamed(i2);
                    androidx.recyclerview.widget.RecyclerView.this.dispatchChildDetached(viewB);
                    viewB.clearAnimation();
                }
                androidx.recyclerview.widget.RecyclerView.this.removeAllViews();
            }

            @Override // androidx.recyclerview.widget.d_renamed.b_renamed
            public androidx.recyclerview.widget.RecyclerView.w_renamed b_renamed(android.view.View view) {
                return androidx.recyclerview.widget.RecyclerView.getChildViewHolderInt(view);
            }

            @Override // androidx.recyclerview.widget.d_renamed.b_renamed
            public void a_renamed(android.view.View view, int i2, android.view.ViewGroup.LayoutParams layoutParams) {
                androidx.recyclerview.widget.RecyclerView.w_renamed childViewHolderInt = androidx.recyclerview.widget.RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    if (!childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                        throw new java.lang.IllegalArgumentException("Called attach on_renamed a_renamed child which is_renamed not detached: " + childViewHolderInt + androidx.recyclerview.widget.RecyclerView.this.exceptionLabel());
                    }
                    childViewHolderInt.clearTmpDetachFlag();
                }
                androidx.recyclerview.widget.RecyclerView.this.attachViewToParent(view, i2, layoutParams);
            }

            @Override // androidx.recyclerview.widget.d_renamed.b_renamed
            public void c_renamed(int i2) {
                androidx.recyclerview.widget.RecyclerView.w_renamed childViewHolderInt;
                android.view.View viewB = b_renamed(i2);
                if (viewB != null && (childViewHolderInt = androidx.recyclerview.widget.RecyclerView.getChildViewHolderInt(viewB)) != null) {
                    if (childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                        throw new java.lang.IllegalArgumentException("called detach on_renamed an_renamed already detached child " + childViewHolderInt + androidx.recyclerview.widget.RecyclerView.this.exceptionLabel());
                    }
                    childViewHolderInt.addFlags(256);
                }
                androidx.recyclerview.widget.RecyclerView.this.detachViewFromParent(i2);
            }

            @Override // androidx.recyclerview.widget.d_renamed.b_renamed
            public void c_renamed(android.view.View view) {
                androidx.recyclerview.widget.RecyclerView.w_renamed childViewHolderInt = androidx.recyclerview.widget.RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    childViewHolderInt.onEnteredHiddenState(androidx.recyclerview.widget.RecyclerView.this);
                }
            }

            @Override // androidx.recyclerview.widget.d_renamed.b_renamed
            public void d_renamed(android.view.View view) {
                androidx.recyclerview.widget.RecyclerView.w_renamed childViewHolderInt = androidx.recyclerview.widget.RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    childViewHolderInt.onLeftHiddenState(androidx.recyclerview.widget.RecyclerView.this);
                }
            }
        });
    }

    void initAdapterManager() {
        this.mAdapterHelper = new androidx.recyclerview.widget.a_renamed(new androidx.recyclerview.widget.a_renamed.AdapterHelper_2() { // from class: androidx.recyclerview.widget.RecyclerView.6
            @Override // androidx.recyclerview.widget.a_renamed.AdapterHelper_2
            public androidx.recyclerview.widget.RecyclerView.w_renamed a_renamed(int i2) {
                androidx.recyclerview.widget.RecyclerView.w_renamed wVarFindViewHolderForPosition = androidx.recyclerview.widget.RecyclerView.this.findViewHolderForPosition(i2, true);
                if (wVarFindViewHolderForPosition == null || androidx.recyclerview.widget.RecyclerView.this.mChildHelper.c_renamed(wVarFindViewHolderForPosition.itemView)) {
                    return null;
                }
                return wVarFindViewHolderForPosition;
            }

            @Override // androidx.recyclerview.widget.a_renamed.AdapterHelper_2
            public void a_renamed(int i2, int i3) {
                androidx.recyclerview.widget.RecyclerView.this.offsetPositionRecordsForRemove(i2, i3, true);
                androidx.recyclerview.widget.RecyclerView recyclerView = androidx.recyclerview.widget.RecyclerView.this;
                recyclerView.mItemsAddedOrRemoved = true;
                recyclerView.mState.f1437c += i3;
            }

            @Override // androidx.recyclerview.widget.a_renamed.AdapterHelper_2
            public void b_renamed(int i2, int i3) {
                androidx.recyclerview.widget.RecyclerView.this.offsetPositionRecordsForRemove(i2, i3, false);
                androidx.recyclerview.widget.RecyclerView.this.mItemsAddedOrRemoved = true;
            }

            @Override // androidx.recyclerview.widget.a_renamed.AdapterHelper_2
            public void a_renamed(int i2, int i3, java.lang.Object obj) {
                androidx.recyclerview.widget.RecyclerView.this.viewRangeUpdate(i2, i3, obj);
                androidx.recyclerview.widget.RecyclerView.this.mItemsChanged = true;
            }

            @Override // androidx.recyclerview.widget.a_renamed.AdapterHelper_2
            public void a_renamed(androidx.recyclerview.widget.a_renamed.b_renamed bVar) {
                c_renamed(bVar);
            }

            void c_renamed(androidx.recyclerview.widget.a_renamed.b_renamed bVar) {
                int i2 = bVar.f1458a;
                if (i2 == 1) {
                    androidx.recyclerview.widget.RecyclerView.this.mLayout.onItemsAdded(androidx.recyclerview.widget.RecyclerView.this, bVar.f1459b, bVar.d_renamed);
                    return;
                }
                if (i2 == 2) {
                    androidx.recyclerview.widget.RecyclerView.this.mLayout.onItemsRemoved(androidx.recyclerview.widget.RecyclerView.this, bVar.f1459b, bVar.d_renamed);
                } else if (i2 == 4) {
                    androidx.recyclerview.widget.RecyclerView.this.mLayout.onItemsUpdated(androidx.recyclerview.widget.RecyclerView.this, bVar.f1459b, bVar.d_renamed, bVar.f1460c);
                } else {
                    if (i2 != 8) {
                        return;
                    }
                    androidx.recyclerview.widget.RecyclerView.this.mLayout.onItemsMoved(androidx.recyclerview.widget.RecyclerView.this, bVar.f1459b, bVar.d_renamed, 1);
                }
            }

            @Override // androidx.recyclerview.widget.a_renamed.AdapterHelper_2
            public void b_renamed(androidx.recyclerview.widget.a_renamed.b_renamed bVar) {
                c_renamed(bVar);
            }

            @Override // androidx.recyclerview.widget.a_renamed.AdapterHelper_2
            public void c_renamed(int i2, int i3) {
                androidx.recyclerview.widget.RecyclerView.this.offsetPositionRecordsForInsert(i2, i3);
                androidx.recyclerview.widget.RecyclerView.this.mItemsAddedOrRemoved = true;
            }

            @Override // androidx.recyclerview.widget.a_renamed.AdapterHelper_2
            public void d_renamed(int i2, int i3) {
                androidx.recyclerview.widget.RecyclerView.this.offsetPositionRecordsForMove(i2, i3);
                androidx.recyclerview.widget.RecyclerView.this.mItemsAddedOrRemoved = true;
            }
        });
    }

    public void setHasFixedSize(boolean z_renamed) {
        this.mHasFixedSize = z_renamed;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z_renamed) {
        if (z_renamed != this.mClipToPadding) {
            invalidateGlows();
        }
        this.mClipToPadding = z_renamed;
        super.setClipToPadding(z_renamed);
        if (this.mFirstLayoutComplete) {
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    public void setScrollingTouchSlop(int i2) {
        android.view.ViewConfiguration viewConfiguration = android.view.ViewConfiguration.get(getContext());
        if (i2 != 0) {
            if (i2 != 1) {
                android.util.Log.w_renamed(TAG, "setScrollingTouchSlop(): bad argument constant " + i2 + "; using default value");
            } else {
                this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
        }
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public void swapAdapter(androidx.recyclerview.widget.RecyclerView.a_renamed aVar, boolean z_renamed) {
        setLayoutFrozen(false);
        setAdapterInternal(aVar, true, z_renamed);
        processDataSetCompletelyChanged(true);
        requestLayout();
    }

    public void setAdapter(androidx.recyclerview.widget.RecyclerView.a_renamed aVar) {
        setLayoutFrozen(false);
        setAdapterInternal(aVar, false, true);
        processDataSetCompletelyChanged(false);
        requestLayout();
    }

    void removeAndRecycleViews() {
        androidx.recyclerview.widget.RecyclerView.f_renamed fVar = this.mItemAnimator;
        if (fVar != null) {
            fVar.d_renamed();
        }
        androidx.recyclerview.widget.RecyclerView.i_renamed iVar = this.mLayout;
        if (iVar != null) {
            iVar.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        }
        this.mRecycler.a_renamed();
    }

    private void setAdapterInternal(androidx.recyclerview.widget.RecyclerView.a_renamed aVar, boolean z_renamed, boolean z2) {
        androidx.recyclerview.widget.RecyclerView.a_renamed aVar2 = this.mAdapter;
        if (aVar2 != null) {
            aVar2.unregisterAdapterDataObserver(this.mObserver);
            this.mAdapter.onDetachedFromRecyclerView(this);
        }
        if (!z_renamed || z2) {
            removeAndRecycleViews();
        }
        this.mAdapterHelper.a_renamed();
        androidx.recyclerview.widget.RecyclerView.a_renamed aVar3 = this.mAdapter;
        this.mAdapter = aVar;
        if (aVar != null) {
            aVar.registerAdapterDataObserver(this.mObserver);
            aVar.onAttachedToRecyclerView(this);
        }
        androidx.recyclerview.widget.RecyclerView.i_renamed iVar = this.mLayout;
        if (iVar != null) {
            iVar.onAdapterChanged(aVar3, this.mAdapter);
        }
        this.mRecycler.a_renamed(aVar3, this.mAdapter, z_renamed);
        this.mState.f_renamed = true;
    }

    public androidx.recyclerview.widget.RecyclerView.a_renamed getAdapter() {
        return this.mAdapter;
    }

    public void setRecyclerListener(androidx.recyclerview.widget.RecyclerView.q_renamed qVar) {
        this.mRecyclerListener = qVar;
    }

    @Override // android.view.View
    public int getBaseline() {
        androidx.recyclerview.widget.RecyclerView.i_renamed iVar = this.mLayout;
        if (iVar != null) {
            return iVar.getBaseline();
        }
        return super.getBaseline();
    }

    public void addOnChildAttachStateChangeListener(androidx.recyclerview.widget.RecyclerView.k_renamed kVar) {
        if (this.mOnChildAttachStateListeners == null) {
            this.mOnChildAttachStateListeners = new java.util.ArrayList();
        }
        this.mOnChildAttachStateListeners.add(kVar);
    }

    public void removeOnChildAttachStateChangeListener(androidx.recyclerview.widget.RecyclerView.k_renamed kVar) {
        java.util.List<androidx.recyclerview.widget.RecyclerView.k_renamed> list = this.mOnChildAttachStateListeners;
        if (list == null) {
            return;
        }
        list.remove(kVar);
    }

    public void clearOnChildAttachStateChangeListeners() {
        java.util.List<androidx.recyclerview.widget.RecyclerView.k_renamed> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void setLayoutManager(androidx.recyclerview.widget.RecyclerView.i_renamed iVar) {
        if (iVar == this.mLayout) {
            return;
        }
        stopScroll();
        if (this.mLayout != null) {
            androidx.recyclerview.widget.RecyclerView.f_renamed fVar = this.mItemAnimator;
            if (fVar != null) {
                fVar.d_renamed();
            }
            this.mLayout.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
            this.mRecycler.a_renamed();
            if (this.mIsAttached) {
                this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
            }
            this.mLayout.setRecyclerView(null);
            this.mLayout = null;
        } else {
            this.mRecycler.a_renamed();
        }
        this.mChildHelper.a_renamed();
        this.mLayout = iVar;
        if (iVar != null) {
            if (iVar.mRecyclerView != null) {
                throw new java.lang.IllegalArgumentException("LayoutManager " + iVar + " is_renamed already attached to a_renamed RecyclerView:" + iVar.mRecyclerView.exceptionLabel());
            }
            this.mLayout.setRecyclerView(this);
            if (this.mIsAttached) {
                this.mLayout.dispatchAttachedToWindow(this);
            }
        }
        this.mRecycler.b_renamed();
        requestLayout();
    }

    public void setOnFlingListener(androidx.recyclerview.widget.RecyclerView.l_renamed lVar) {
        this.mOnFlingListener = lVar;
    }

    public androidx.recyclerview.widget.RecyclerView.l_renamed getOnFlingListener() {
        return this.mOnFlingListener;
    }

    @Override // android.view.View
    protected android.os.Parcelable onSaveInstanceState() {
        androidx.recyclerview.widget.RecyclerView.SavedState savedState = new androidx.recyclerview.widget.RecyclerView.SavedState(super.onSaveInstanceState());
        androidx.recyclerview.widget.RecyclerView.SavedState savedState2 = this.mPendingSavedState;
        if (savedState2 != null) {
            savedState.copyFrom(savedState2);
        } else {
            androidx.recyclerview.widget.RecyclerView.i_renamed iVar = this.mLayout;
            if (iVar != null) {
                savedState.mLayoutState = iVar.onSaveInstanceState();
            } else {
                savedState.mLayoutState = null;
            }
        }
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(android.os.Parcelable parcelable) {
        if (!(parcelable instanceof androidx.recyclerview.widget.RecyclerView.SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        this.mPendingSavedState = (androidx.recyclerview.widget.RecyclerView.SavedState) parcelable;
        super.onRestoreInstanceState(this.mPendingSavedState.getSuperState());
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(android.util.SparseArray<android.os.Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(android.util.SparseArray<android.os.Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    private void addAnimatingView(androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
        android.view.View view = wVar.itemView;
        boolean z_renamed = view.getParent() == this;
        this.mRecycler.c_renamed(getChildViewHolder(view));
        if (wVar.isTmpDetached()) {
            this.mChildHelper.a_renamed(view, -1, view.getLayoutParams(), true);
        } else if (!z_renamed) {
            this.mChildHelper.a_renamed(view, true);
        } else {
            this.mChildHelper.d_renamed(view);
        }
    }

    boolean removeAnimatingView(android.view.View view) {
        startInterceptRequestLayout();
        boolean zF = this.mChildHelper.f_renamed(view);
        if (zF) {
            androidx.recyclerview.widget.RecyclerView.w_renamed childViewHolderInt = getChildViewHolderInt(view);
            this.mRecycler.c_renamed(childViewHolderInt);
            this.mRecycler.b_renamed(childViewHolderInt);
        }
        stopInterceptRequestLayout(!zF);
        return zF;
    }

    public androidx.recyclerview.widget.RecyclerView.i_renamed getLayoutManager() {
        return this.mLayout;
    }

    public androidx.recyclerview.widget.RecyclerView.o_renamed getRecycledViewPool() {
        return this.mRecycler.g_renamed();
    }

    public void setRecycledViewPool(androidx.recyclerview.widget.RecyclerView.o_renamed oVar) {
        this.mRecycler.a_renamed(oVar);
    }

    public void setViewCacheExtension(androidx.recyclerview.widget.RecyclerView.u_renamed uVar) {
        this.mRecycler.a_renamed(uVar);
    }

    public void setItemViewCacheSize(int i2) {
        this.mRecycler.a_renamed(i2);
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    void setScrollState(int i2) {
        if (i2 == this.mScrollState) {
            return;
        }
        this.mScrollState = i2;
        if (i2 != 2) {
            stopScrollersInternal();
        }
        dispatchOnScrollStateChanged(i2);
    }

    public void addItemDecoration(androidx.recyclerview.widget.RecyclerView.h_renamed hVar, int i2) {
        androidx.recyclerview.widget.RecyclerView.i_renamed iVar = this.mLayout;
        if (iVar != null) {
            iVar.assertNotInLayoutOrScroll("Cannot add item decoration during a_renamed scroll  or layout");
        }
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i2 < 0) {
            this.mItemDecorations.add(hVar);
        } else {
            this.mItemDecorations.add(i2, hVar);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void addItemDecoration(androidx.recyclerview.widget.RecyclerView.h_renamed hVar) {
        addItemDecoration(hVar, -1);
    }

    public androidx.recyclerview.widget.RecyclerView.h_renamed getItemDecorationAt(int i2) {
        int itemDecorationCount = getItemDecorationCount();
        if (i2 < 0 || i2 >= itemDecorationCount) {
            throw new java.lang.IndexOutOfBoundsException(i2 + " is_renamed an_renamed invalid index for size " + itemDecorationCount);
        }
        return this.mItemDecorations.get(i2);
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    public void removeItemDecorationAt(int i2) {
        int itemDecorationCount = getItemDecorationCount();
        if (i2 < 0 || i2 >= itemDecorationCount) {
            throw new java.lang.IndexOutOfBoundsException(i2 + " is_renamed an_renamed invalid index for size " + itemDecorationCount);
        }
        removeItemDecoration(getItemDecorationAt(i2));
    }

    public void removeItemDecoration(androidx.recyclerview.widget.RecyclerView.h_renamed hVar) {
        androidx.recyclerview.widget.RecyclerView.i_renamed iVar = this.mLayout;
        if (iVar != null) {
            iVar.assertNotInLayoutOrScroll("Cannot remove item decoration during a_renamed scroll  or layout");
        }
        this.mItemDecorations.remove(hVar);
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void setChildDrawingOrderCallback(androidx.recyclerview.widget.RecyclerView.d_renamed dVar) {
        if (dVar == this.mChildDrawingOrderCallback) {
            return;
        }
        this.mChildDrawingOrderCallback = dVar;
        setChildrenDrawingOrderEnabled(this.mChildDrawingOrderCallback != null);
    }

    @java.lang.Deprecated
    public void setOnScrollListener(androidx.recyclerview.widget.RecyclerView.n_renamed nVar) {
        this.mScrollListener = nVar;
    }

    public void addOnScrollListener(androidx.recyclerview.widget.RecyclerView.n_renamed nVar) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new java.util.ArrayList();
        }
        this.mScrollListeners.add(nVar);
    }

    public void removeOnScrollListener(androidx.recyclerview.widget.RecyclerView.n_renamed nVar) {
        java.util.List<androidx.recyclerview.widget.RecyclerView.n_renamed> list = this.mScrollListeners;
        if (list != null) {
            list.remove(nVar);
        }
    }

    public void clearOnScrollListeners() {
        java.util.List<androidx.recyclerview.widget.RecyclerView.n_renamed> list = this.mScrollListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void scrollToPosition(int i2) {
        if (this.mLayoutSuppressed) {
            return;
        }
        stopScroll();
        androidx.recyclerview.widget.RecyclerView.i_renamed iVar = this.mLayout;
        if (iVar == null) {
            android.util.Log.e_renamed(TAG, "Cannot scroll to position a_renamed LayoutManager set. Call setLayoutManager with a_renamed non-null argument.");
        } else {
            iVar.scrollToPosition(i2);
            awakenScrollBars();
        }
    }

    void jumpToPositionForSmoothScroller(int i2) {
        if (this.mLayout == null) {
            return;
        }
        setScrollState(2);
        this.mLayout.scrollToPosition(i2);
        awakenScrollBars();
    }

    public void smoothScrollToPosition(int i2) {
        if (this.mLayoutSuppressed) {
            return;
        }
        androidx.recyclerview.widget.RecyclerView.i_renamed iVar = this.mLayout;
        if (iVar == null) {
            android.util.Log.e_renamed(TAG, "Cannot smooth scroll without a_renamed LayoutManager set. Call setLayoutManager with a_renamed non-null argument.");
        } else {
            iVar.smoothScrollToPosition(this, this.mState, i2);
        }
    }

    @Override // android.view.View
    public void scrollTo(int i2, int i3) {
        android.util.Log.w_renamed(TAG, "RecyclerView does not support scrolling to an_renamed absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View
    public void scrollBy(int i2, int i3) {
        androidx.recyclerview.widget.RecyclerView.i_renamed iVar = this.mLayout;
        if (iVar == null) {
            android.util.Log.e_renamed(TAG, "Cannot scroll without a_renamed LayoutManager set. Call setLayoutManager with a_renamed non-null argument.");
            return;
        }
        if (this.mLayoutSuppressed) {
            return;
        }
        boolean zCanScrollHorizontally = iVar.canScrollHorizontally();
        boolean zCanScrollVertically = this.mLayout.canScrollVertically();
        if (zCanScrollHorizontally || zCanScrollVertically) {
            if (!zCanScrollHorizontally) {
                i2 = 0;
            }
            if (!zCanScrollVertically) {
                i3 = 0;
            }
            scrollByInternal(i2, i3, null);
        }
    }

    void scrollStep(int i2, int i3, int[] iArr) {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        androidx.core.d_renamed.a_renamed.a_renamed(TRACE_SCROLL_TAG);
        fillRemainingScrollValues(this.mState);
        int iScrollHorizontallyBy = i2 != 0 ? this.mLayout.scrollHorizontallyBy(i2, this.mRecycler, this.mState) : 0;
        int iScrollVerticallyBy = i3 != 0 ? this.mLayout.scrollVerticallyBy(i3, this.mRecycler, this.mState) : 0;
        androidx.core.d_renamed.a_renamed.a_renamed();
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
            androidx.core.d_renamed.a_renamed.a_renamed(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
            dispatchLayout();
            androidx.core.d_renamed.a_renamed.a_renamed();
            return;
        }
        if (this.mAdapterHelper.d_renamed()) {
            if (this.mAdapterHelper.a_renamed(4) && !this.mAdapterHelper.a_renamed(11)) {
                androidx.core.d_renamed.a_renamed.a_renamed(TRACE_HANDLE_ADAPTER_UPDATES_TAG);
                startInterceptRequestLayout();
                onEnterLayoutOrScroll();
                this.mAdapterHelper.b_renamed();
                if (!this.mLayoutWasDefered) {
                    if (hasUpdatedView()) {
                        dispatchLayout();
                    } else {
                        this.mAdapterHelper.c_renamed();
                    }
                }
                stopInterceptRequestLayout(true);
                onExitLayoutOrScroll();
                androidx.core.d_renamed.a_renamed.a_renamed();
                return;
            }
            if (this.mAdapterHelper.d_renamed()) {
                androidx.core.d_renamed.a_renamed.a_renamed(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
                dispatchLayout();
                androidx.core.d_renamed.a_renamed.a_renamed();
            }
        }
    }

    private boolean hasUpdatedView() {
        int iB = this.mChildHelper.b_renamed();
        for (int i2 = 0; i2 < iB; i2++) {
            androidx.recyclerview.widget.RecyclerView.w_renamed childViewHolderInt = getChildViewHolderInt(this.mChildHelper.b_renamed(i2));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.isUpdated()) {
                return true;
            }
        }
        return false;
    }

    boolean scrollByInternal(int i2, int i3, android.view.MotionEvent motionEvent) {
        int i4;
        int i5;
        int i6;
        int i7;
        consumePendingUpdateOperations();
        if (this.mAdapter != null) {
            int[] iArr = this.mReusableIntPair;
            iArr[0] = 0;
            iArr[1] = 0;
            scrollStep(i2, i3, iArr);
            int[] iArr2 = this.mReusableIntPair;
            int i8 = iArr2[0];
            int i9 = iArr2[1];
            i5 = i9;
            i4 = i8;
            i6 = i2 - i8;
            i7 = i3 - i9;
        } else {
            i4 = 0;
            i5 = 0;
            i6 = 0;
            i7 = 0;
        }
        if (!this.mItemDecorations.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.mReusableIntPair;
        iArr3[0] = 0;
        iArr3[1] = 0;
        int i10 = i4;
        dispatchNestedScroll(i4, i5, i6, i7, this.mScrollOffset, 0, iArr3);
        int[] iArr4 = this.mReusableIntPair;
        int i11 = i6 - iArr4[0];
        int i12 = i7 - iArr4[1];
        boolean z_renamed = (iArr4[0] == 0 && iArr4[1] == 0) ? false : true;
        int i13 = this.mLastTouchX;
        int[] iArr5 = this.mScrollOffset;
        this.mLastTouchX = i13 - iArr5[0];
        this.mLastTouchY -= iArr5[1];
        int[] iArr6 = this.mNestedOffsets;
        iArr6[0] = iArr6[0] + iArr5[0];
        iArr6[1] = iArr6[1] + iArr5[1];
        if (getOverScrollMode() != 2) {
            if (motionEvent != null && !androidx.core.h_renamed.h_renamed.a_renamed(motionEvent, 8194)) {
                pullGlows(motionEvent.getX(), i11, motionEvent.getY(), i12);
            }
            considerReleasingGlowsOnScroll(i2, i3);
        }
        if (i10 != 0 || i5 != 0) {
            dispatchOnScrolled(i10, i5);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (!z_renamed && i10 == 0 && i5 == 0) ? false : true;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        androidx.recyclerview.widget.RecyclerView.i_renamed iVar = this.mLayout;
        if (iVar != null && iVar.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollOffset(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        androidx.recyclerview.widget.RecyclerView.i_renamed iVar = this.mLayout;
        if (iVar != null && iVar.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollExtent(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        androidx.recyclerview.widget.RecyclerView.i_renamed iVar = this.mLayout;
        if (iVar != null && iVar.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollRange(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        androidx.recyclerview.widget.RecyclerView.i_renamed iVar = this.mLayout;
        if (iVar != null && iVar.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollOffset(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        androidx.recyclerview.widget.RecyclerView.i_renamed iVar = this.mLayout;
        if (iVar != null && iVar.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollExtent(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        androidx.recyclerview.widget.RecyclerView.i_renamed iVar = this.mLayout;
        if (iVar != null && iVar.canScrollVertically()) {
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

    void stopInterceptRequestLayout(boolean z_renamed) {
        if (this.mInterceptRequestLayoutDepth < 1) {
            this.mInterceptRequestLayoutDepth = 1;
        }
        if (!z_renamed && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
        if (this.mInterceptRequestLayoutDepth == 1) {
            if (z_renamed && this.mLayoutWasDefered && !this.mLayoutSuppressed && this.mLayout != null && this.mAdapter != null) {
                dispatchLayout();
            }
            if (!this.mLayoutSuppressed) {
                this.mLayoutWasDefered = false;
            }
        }
        this.mInterceptRequestLayoutDepth--;
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z_renamed) {
        if (z_renamed != this.mLayoutSuppressed) {
            assertNotInLayoutOrScroll("Do not suppressLayout in_renamed layout or scroll");
            if (!z_renamed) {
                this.mLayoutSuppressed = false;
                if (this.mLayoutWasDefered && this.mLayout != null && this.mAdapter != null) {
                    requestLayout();
                }
                this.mLayoutWasDefered = false;
                return;
            }
            long jUptimeMillis = android.os.SystemClock.uptimeMillis();
            onTouchEvent(android.view.MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
            this.mLayoutSuppressed = true;
            this.mIgnoreMotionEventTillDown = true;
            stopScroll();
        }
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.mLayoutSuppressed;
    }

    @java.lang.Deprecated
    public void setLayoutFrozen(boolean z_renamed) {
        suppressLayout(z_renamed);
    }

    @java.lang.Deprecated
    public boolean isLayoutFrozen() {
        return isLayoutSuppressed();
    }

    @Override // android.view.ViewGroup
    @java.lang.Deprecated
    public void setLayoutTransition(android.animation.LayoutTransition layoutTransition) {
        if (android.os.Build.VERSION.SDK_INT < 18) {
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
        throw new java.lang.IllegalArgumentException("Providing a_renamed LayoutTransition into RecyclerView is_renamed not supported. Please use setItemAnimator() instead for animating changes to the items in_renamed this RecyclerView");
    }

    public void smoothScrollBy(int i2, int i3) {
        smoothScrollBy(i2, i3, null);
    }

    public void smoothScrollBy(int i2, int i3, android.view.animation.Interpolator interpolator) {
        smoothScrollBy(i2, i3, interpolator, Integer.MIN_VALUE);
    }

    public void smoothScrollBy(int i2, int i3, android.view.animation.Interpolator interpolator, int i4) {
        smoothScrollBy(i2, i3, interpolator, i4, false);
    }

    void smoothScrollBy(int i2, int i3, android.view.animation.Interpolator interpolator, int i4, boolean z_renamed) {
        androidx.recyclerview.widget.RecyclerView.i_renamed iVar = this.mLayout;
        if (iVar == null) {
            android.util.Log.e_renamed(TAG, "Cannot smooth scroll without a_renamed LayoutManager set. Call setLayoutManager with a_renamed non-null argument.");
            return;
        }
        if (this.mLayoutSuppressed) {
            return;
        }
        if (!iVar.canScrollHorizontally()) {
            i2 = 0;
        }
        if (!this.mLayout.canScrollVertically()) {
            i3 = 0;
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        if (i4 == Integer.MIN_VALUE || i4 > 0) {
            if (z_renamed) {
                int i5 = i2 != 0 ? 1 : 0;
                if (i3 != 0) {
                    i5 |= 2;
                }
                startNestedScroll(i5, 1);
            }
            this.mViewFlinger.a_renamed(i2, i3, i4, interpolator);
            return;
        }
        scrollBy(i2, i3);
    }

    public boolean fling(int i2, int i3) {
        androidx.recyclerview.widget.RecyclerView.i_renamed iVar = this.mLayout;
        if (iVar == null) {
            android.util.Log.e_renamed(TAG, "Cannot fling without a_renamed LayoutManager set. Call setLayoutManager with a_renamed non-null argument.");
            return false;
        }
        if (this.mLayoutSuppressed) {
            return false;
        }
        boolean zCanScrollHorizontally = iVar.canScrollHorizontally();
        boolean zCanScrollVertically = this.mLayout.canScrollVertically();
        if (!zCanScrollHorizontally || java.lang.Math.abs(i2) < this.mMinFlingVelocity) {
            i2 = 0;
        }
        if (!zCanScrollVertically || java.lang.Math.abs(i3) < this.mMinFlingVelocity) {
            i3 = 0;
        }
        if (i2 == 0 && i3 == 0) {
            return false;
        }
        float f2 = i2;
        float f3 = i3;
        if (!dispatchNestedPreFling(f2, f3)) {
            boolean z_renamed = zCanScrollHorizontally || zCanScrollVertically;
            dispatchNestedFling(f2, f3, z_renamed);
            androidx.recyclerview.widget.RecyclerView.l_renamed lVar = this.mOnFlingListener;
            if (lVar != null && lVar.a_renamed(i2, i3)) {
                return true;
            }
            if (z_renamed) {
                int i4 = zCanScrollHorizontally ? 1 : 0;
                if (zCanScrollVertically) {
                    i4 |= 2;
                }
                startNestedScroll(i4, 1);
                int i5 = this.mMaxFlingVelocity;
                int iMax = java.lang.Math.max(-i5, java.lang.Math.min(i2, i5));
                int i6 = this.mMaxFlingVelocity;
                this.mViewFlinger.a_renamed(iMax, java.lang.Math.max(-i6, java.lang.Math.min(i3, i6)));
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
        this.mViewFlinger.b_renamed();
        androidx.recyclerview.widget.RecyclerView.i_renamed iVar = this.mLayout;
        if (iVar != null) {
            iVar.stopSmoothScroller();
        }
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:13:0x0056  */
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
            androidx.core.widget.d_renamed.a_renamed(r1, r4, r9)
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
            androidx.core.widget.d_renamed.a_renamed(r1, r4, r9)
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
            androidx.core.widget.d_renamed.a_renamed(r9, r1, r7)
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
            androidx.core.widget.d_renamed.a_renamed(r9, r1, r2)
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
            androidx.core.h_renamed.v_renamed.e_renamed(r6)
        L7f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.pullGlows(float, float, float, float):void");
    }

    private void releaseGlows() {
        boolean zIsFinished;
        android.widget.EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.mLeftGlow.isFinished();
        } else {
            zIsFinished = false;
        }
        android.widget.EdgeEffect edgeEffect2 = this.mTopGlow;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.mTopGlow.isFinished();
        }
        android.widget.EdgeEffect edgeEffect3 = this.mRightGlow;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.mRightGlow.isFinished();
        }
        android.widget.EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.mBottomGlow.isFinished();
        }
        if (zIsFinished) {
            androidx.core.h_renamed.v_renamed.e_renamed(this);
        }
    }

    void considerReleasingGlowsOnScroll(int i2, int i3) {
        boolean zIsFinished;
        android.widget.EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished() || i2 <= 0) {
            zIsFinished = false;
        } else {
            this.mLeftGlow.onRelease();
            zIsFinished = this.mLeftGlow.isFinished();
        }
        android.widget.EdgeEffect edgeEffect2 = this.mRightGlow;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i2 < 0) {
            this.mRightGlow.onRelease();
            zIsFinished |= this.mRightGlow.isFinished();
        }
        android.widget.EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i3 > 0) {
            this.mTopGlow.onRelease();
            zIsFinished |= this.mTopGlow.isFinished();
        }
        android.widget.EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i3 < 0) {
            this.mBottomGlow.onRelease();
            zIsFinished |= this.mBottomGlow.isFinished();
        }
        if (zIsFinished) {
            androidx.core.h_renamed.v_renamed.e_renamed(this);
        }
    }

    void absorbGlows(int i2, int i3) {
        if (i2 < 0) {
            ensureLeftGlow();
            if (this.mLeftGlow.isFinished()) {
                this.mLeftGlow.onAbsorb(-i2);
            }
        } else if (i2 > 0) {
            ensureRightGlow();
            if (this.mRightGlow.isFinished()) {
                this.mRightGlow.onAbsorb(i2);
            }
        }
        if (i3 < 0) {
            ensureTopGlow();
            if (this.mTopGlow.isFinished()) {
                this.mTopGlow.onAbsorb(-i3);
            }
        } else if (i3 > 0) {
            ensureBottomGlow();
            if (this.mBottomGlow.isFinished()) {
                this.mBottomGlow.onAbsorb(i3);
            }
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        androidx.core.h_renamed.v_renamed.e_renamed(this);
    }

    void ensureLeftGlow() {
        if (this.mLeftGlow != null) {
            return;
        }
        this.mLeftGlow = this.mEdgeEffectFactory.a_renamed(this, 0);
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
        this.mRightGlow = this.mEdgeEffectFactory.a_renamed(this, 2);
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
        this.mTopGlow = this.mEdgeEffectFactory.a_renamed(this, 1);
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
        this.mBottomGlow = this.mEdgeEffectFactory.a_renamed(this, 3);
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

    public void setEdgeEffectFactory(androidx.recyclerview.widget.RecyclerView.e_renamed eVar) {
        androidx.core.g_renamed.f_renamed.a_renamed(eVar);
        this.mEdgeEffectFactory = eVar;
        invalidateGlows();
    }

    public androidx.recyclerview.widget.RecyclerView.e_renamed getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public android.view.View focusSearch(android.view.View view, int i2) {
        android.view.View viewOnFocusSearchFailed;
        boolean z_renamed;
        android.view.View viewOnInterceptFocusSearch = this.mLayout.onInterceptFocusSearch(view, i2);
        if (viewOnInterceptFocusSearch != null) {
            return viewOnInterceptFocusSearch;
        }
        boolean z2 = (this.mAdapter == null || this.mLayout == null || isComputingLayout() || this.mLayoutSuppressed) ? false : true;
        android.view.FocusFinder focusFinder = android.view.FocusFinder.getInstance();
        if (z2 && (i2 == 2 || i2 == 1)) {
            if (this.mLayout.canScrollVertically()) {
                int i3 = i2 == 2 ? 130 : 33;
                z_renamed = focusFinder.findNextFocus(this, view, i3) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i2 = i3;
                }
            } else {
                z_renamed = false;
            }
            if (!z_renamed && this.mLayout.canScrollHorizontally()) {
                int i4 = (this.mLayout.getLayoutDirection() == 1) ^ (i2 == 2) ? 66 : 17;
                z_renamed = focusFinder.findNextFocus(this, view, i4) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i2 = i4;
                }
            }
            if (z_renamed) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                this.mLayout.onFocusSearchFailed(view, i2, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            }
            viewOnFocusSearchFailed = focusFinder.findNextFocus(this, view, i2);
        } else {
            android.view.View viewFindNextFocus = focusFinder.findNextFocus(this, view, i2);
            if (viewFindNextFocus == null && z2) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                viewOnFocusSearchFailed = this.mLayout.onFocusSearchFailed(view, i2, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            } else {
                viewOnFocusSearchFailed = viewFindNextFocus;
            }
        }
        if (viewOnFocusSearchFailed == null || viewOnFocusSearchFailed.hasFocusable()) {
            return isPreferredNextFocus(view, viewOnFocusSearchFailed, i2) ? viewOnFocusSearchFailed : super.focusSearch(view, i2);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i2);
        }
        requestChildOnScreen(viewOnFocusSearchFailed, null);
        return view;
    }

    private boolean isPreferredNextFocus(android.view.View view, android.view.View view2, int i2) {
        int i3;
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
        int i4 = this.mLayout.getLayoutDirection() == 1 ? -1 : 1;
        if ((this.mTempRect.left < this.mTempRect2.left || this.mTempRect.right <= this.mTempRect2.left) && this.mTempRect.right < this.mTempRect2.right) {
            i3 = 1;
        } else {
            i3 = ((this.mTempRect.right > this.mTempRect2.right || this.mTempRect.left >= this.mTempRect2.right) && this.mTempRect.left > this.mTempRect2.left) ? -1 : 0;
        }
        if ((this.mTempRect.top < this.mTempRect2.top || this.mTempRect.bottom <= this.mTempRect2.top) && this.mTempRect.bottom < this.mTempRect2.bottom) {
            c2 = 1;
        } else if ((this.mTempRect.bottom <= this.mTempRect2.bottom && this.mTempRect.top < this.mTempRect2.bottom) || this.mTempRect.top <= this.mTempRect2.top) {
            c2 = 0;
        }
        if (i2 == 1) {
            return c2 < 0 || (c2 == 0 && i3 * i4 <= 0);
        }
        if (i2 == 2) {
            return c2 > 0 || (c2 == 0 && i3 * i4 >= 0);
        }
        if (i2 == 17) {
            return i3 < 0;
        }
        if (i2 == 33) {
            return c2 < 0;
        }
        if (i2 == 66) {
            return i3 > 0;
        }
        if (i2 == 130) {
            return c2 > 0;
        }
        throw new java.lang.IllegalArgumentException("Invalid direction: " + i2 + exceptionLabel());
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(android.view.View view, android.view.View view2) {
        if (!this.mLayout.onRequestChildFocus(this, this.mState, view, view2) && view2 != null) {
            requestChildOnScreen(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    private void requestChildOnScreen(android.view.View view, android.view.View view2) {
        android.view.View view3 = view2 != null ? view2 : view;
        this.mTempRect.set(0, 0, view3.getWidth(), view3.getHeight());
        android.view.ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof androidx.recyclerview.widget.RecyclerView.j_renamed) {
            androidx.recyclerview.widget.RecyclerView.j_renamed jVar = (androidx.recyclerview.widget.RecyclerView.j_renamed) layoutParams;
            if (!jVar.e_renamed) {
                android.graphics.Rect rect = jVar.d_renamed;
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
    public boolean requestChildRectangleOnScreen(android.view.View view, android.graphics.Rect rect, boolean z_renamed) {
        return this.mLayout.requestChildRectangleOnScreen(this, view, rect, z_renamed);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(java.util.ArrayList<android.view.View> arrayList, int i2, int i3) {
        androidx.recyclerview.widget.RecyclerView.i_renamed iVar = this.mLayout;
        if (iVar == null || !iVar.onAddFocusables(this, arrayList, i2, i3)) {
            super.addFocusables(arrayList, i2, i3);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i2, android.graphics.Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:21:0x0052  */
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
            androidx.recyclerview.widget.RecyclerView$i_renamed r1 = r4.mLayout
            if (r1 == 0) goto L1e
            r1.dispatchAttachedToWindow(r4)
        L1e:
            r4.mPostedAnimatorRunner = r0
            boolean r0 = androidx.recyclerview.widget.RecyclerView.ALLOW_THREAD_GAP_WORK
            if (r0 == 0) goto L68
            java.lang.ThreadLocal<androidx.recyclerview.widget.h_renamed> r0 = androidx.recyclerview.widget.h_renamed.f1526a
            java.lang.Object r0 = r0.get()
            androidx.recyclerview.widget.h_renamed r0 = (androidx.recyclerview.widget.h_renamed) r0
            r4.mGapWorker = r0
            androidx.recyclerview.widget.h_renamed r0 = r4.mGapWorker
            if (r0 != 0) goto L63
            androidx.recyclerview.widget.h_renamed r0 = new androidx.recyclerview.widget.h_renamed
            r0.<init>()
            r4.mGapWorker = r0
            android.view.Display r0 = androidx.core.h_renamed.v_renamed.F_renamed(r4)
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
            androidx.recyclerview.widget.h_renamed r1 = r4.mGapWorker
            r2 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r2 = r2 / r0
            long r2 = (long) r2
            r1.d_renamed = r2
            java.lang.ThreadLocal<androidx.recyclerview.widget.h_renamed> r0 = androidx.recyclerview.widget.h_renamed.f1526a
            androidx.recyclerview.widget.h_renamed r1 = r4.mGapWorker
            r0.set(r1)
        L63:
            androidx.recyclerview.widget.h_renamed r0 = r4.mGapWorker
            r0.a_renamed(r4)
        L68:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        androidx.recyclerview.widget.h_renamed hVar;
        super.onDetachedFromWindow();
        androidx.recyclerview.widget.RecyclerView.f_renamed fVar = this.mItemAnimator;
        if (fVar != null) {
            fVar.d_renamed();
        }
        stopScroll();
        this.mIsAttached = false;
        androidx.recyclerview.widget.RecyclerView.i_renamed iVar = this.mLayout;
        if (iVar != null) {
            iVar.dispatchDetachedFromWindow(this, this.mRecycler);
        }
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        this.mViewInfoStore.b_renamed();
        if (!ALLOW_THREAD_GAP_WORK || (hVar = this.mGapWorker) == null) {
            return;
        }
        hVar.b_renamed(this);
        this.mGapWorker = null;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    void assertInLayoutOrScroll(java.lang.String str) {
        if (isComputingLayout()) {
            return;
        }
        if (str == null) {
            throw new java.lang.IllegalStateException("Cannot call this method unless RecyclerView is_renamed computing a_renamed layout or scrolling" + exceptionLabel());
        }
        throw new java.lang.IllegalStateException(str + exceptionLabel());
    }

    void assertNotInLayoutOrScroll(java.lang.String str) {
        if (isComputingLayout()) {
            if (str == null) {
                throw new java.lang.IllegalStateException("Cannot call this method while RecyclerView is_renamed computing a_renamed layout or scrolling" + exceptionLabel());
            }
            throw new java.lang.IllegalStateException(str);
        }
        if (this.mDispatchScrollCounter > 0) {
            android.util.Log.w_renamed(TAG, "Cannot call this method in_renamed a_renamed scroll callback. Scroll callbacks mightbe run during a_renamed measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be_renamed postponed tothe next frame.", new java.lang.IllegalStateException("" + exceptionLabel()));
        }
    }

    public void addOnItemTouchListener(androidx.recyclerview.widget.RecyclerView.m_renamed mVar) {
        this.mOnItemTouchListeners.add(mVar);
    }

    public void removeOnItemTouchListener(androidx.recyclerview.widget.RecyclerView.m_renamed mVar) {
        this.mOnItemTouchListeners.remove(mVar);
        if (this.mInterceptingOnItemTouchListener == mVar) {
            this.mInterceptingOnItemTouchListener = null;
        }
    }

    private boolean dispatchToOnItemTouchListeners(android.view.MotionEvent motionEvent) {
        androidx.recyclerview.widget.RecyclerView.m_renamed mVar = this.mInterceptingOnItemTouchListener;
        if (mVar == null) {
            if (motionEvent.getAction() == 0) {
                return false;
            }
            return findInterceptingOnItemTouchListener(motionEvent);
        }
        mVar.b_renamed(this, motionEvent);
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.mInterceptingOnItemTouchListener = null;
        }
        return true;
    }

    private boolean findInterceptingOnItemTouchListener(android.view.MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.mOnItemTouchListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            androidx.recyclerview.widget.RecyclerView.m_renamed mVar = this.mOnItemTouchListeners.get(i2);
            if (mVar.a_renamed(this, motionEvent) && action != 3) {
                this.mInterceptingOnItemTouchListener = mVar;
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        boolean z_renamed;
        if (this.mLayoutSuppressed) {
            return false;
        }
        this.mInterceptingOnItemTouchListener = null;
        if (findInterceptingOnItemTouchListener(motionEvent)) {
            cancelScroll();
            return true;
        }
        androidx.recyclerview.widget.RecyclerView.i_renamed iVar = this.mLayout;
        if (iVar == null) {
            return false;
        }
        boolean zCanScrollHorizontally = iVar.canScrollHorizontally();
        boolean zCanScrollVertically = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = android.view.VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.mIgnoreMotionEventTillDown) {
                this.mIgnoreMotionEventTillDown = false;
            }
            this.mScrollPointerId = motionEvent.getPointerId(0);
            int x_renamed = (int) (motionEvent.getX() + 0.5f);
            this.mLastTouchX = x_renamed;
            this.mInitialTouchX = x_renamed;
            int y_renamed = (int) (motionEvent.getY() + 0.5f);
            this.mLastTouchY = y_renamed;
            this.mInitialTouchY = y_renamed;
            if (this.mScrollState == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                stopNestedScroll(1);
            }
            int[] iArr = this.mNestedOffsets;
            iArr[1] = 0;
            iArr[0] = 0;
            int i2 = zCanScrollHorizontally ? 1 : 0;
            if (zCanScrollVertically) {
                i2 |= 2;
            }
            startNestedScroll(i2, 0);
        } else if (actionMasked == 1) {
            this.mVelocityTracker.clear();
            stopNestedScroll(0);
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
            if (iFindPointerIndex < 0) {
                android.util.Log.e_renamed(TAG, "Error processing scroll; pointer index for id_renamed " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x2 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y2 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            if (this.mScrollState != 1) {
                int i3 = x2 - this.mInitialTouchX;
                int i4 = y2 - this.mInitialTouchY;
                if (!zCanScrollHorizontally || java.lang.Math.abs(i3) <= this.mTouchSlop) {
                    z_renamed = false;
                } else {
                    this.mLastTouchX = x2;
                    z_renamed = true;
                }
                if (zCanScrollVertically && java.lang.Math.abs(i4) > this.mTouchSlop) {
                    this.mLastTouchY = y2;
                    z_renamed = true;
                }
                if (z_renamed) {
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
    public void requestDisallowInterceptTouchEvent(boolean z_renamed) {
        int size = this.mOnItemTouchListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mOnItemTouchListeners.get(i2).a_renamed(z_renamed);
        }
        super.requestDisallowInterceptTouchEvent(z_renamed);
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:47:0x00df A_renamed[PHI: r0
      0x00df: PHI (r0v42 int) = (r0v31 int), (r0v46 int) binds: [B_renamed:41:0x00c8, B_renamed:45:0x00db] A_renamed[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:49:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:55:0x00f8  */
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
        android.view.VelocityTracker velocityTracker = this.mVelocityTracker;
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

    private void onPointerUp(android.view.MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mScrollPointerId) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.mScrollPointerId = motionEvent.getPointerId(i2);
            int x_renamed = (int) (motionEvent.getX(i2) + 0.5f);
            this.mLastTouchX = x_renamed;
            this.mInitialTouchX = x_renamed;
            int y_renamed = (int) (motionEvent.getY(i2) + 0.5f);
            this.mLastTouchY = y_renamed;
            this.mInitialTouchY = y_renamed;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:28:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:31:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:33:0x006c  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            androidx.recyclerview.widget.RecyclerView$i_renamed r0 = r5.mLayout
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
            androidx.recyclerview.widget.RecyclerView$i_renamed r0 = r5.mLayout
            boolean r0 = r0.canScrollVertically()
            if (r0 == 0) goto L2c
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2d
        L2c:
            r0 = r2
        L2d:
            androidx.recyclerview.widget.RecyclerView$i_renamed r3 = r5.mLayout
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
            androidx.recyclerview.widget.RecyclerView$i_renamed r3 = r5.mLayout
            boolean r3 = r3.canScrollVertically()
            if (r3 == 0) goto L57
            float r0 = -r0
            goto L3c
        L57:
            androidx.recyclerview.widget.RecyclerView$i_renamed r3 = r5.mLayout
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
    protected void onMeasure(int i2, int i3) {
        androidx.recyclerview.widget.RecyclerView.i_renamed iVar = this.mLayout;
        if (iVar == null) {
            defaultOnMeasure(i2, i3);
            return;
        }
        boolean z_renamed = false;
        if (iVar.isAutoMeasureEnabled()) {
            int mode = android.view.View.MeasureSpec.getMode(i2);
            int mode2 = android.view.View.MeasureSpec.getMode(i3);
            this.mLayout.onMeasure(this.mRecycler, this.mState, i2, i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z_renamed = true;
            }
            if (z_renamed || this.mAdapter == null) {
                return;
            }
            if (this.mState.d_renamed == 1) {
                dispatchLayoutStep1();
            }
            this.mLayout.setMeasureSpecs(i2, i3);
            this.mState.i_renamed = true;
            dispatchLayoutStep2();
            this.mLayout.setMeasuredDimensionFromChildren(i2, i3);
            if (this.mLayout.shouldMeasureTwice()) {
                this.mLayout.setMeasureSpecs(android.view.View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), android.view.View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.mState.i_renamed = true;
                dispatchLayoutStep2();
                this.mLayout.setMeasuredDimensionFromChildren(i2, i3);
                return;
            }
            return;
        }
        if (this.mHasFixedSize) {
            this.mLayout.onMeasure(this.mRecycler, this.mState, i2, i3);
            return;
        }
        if (this.mAdapterUpdateDuringMeasure) {
            startInterceptRequestLayout();
            onEnterLayoutOrScroll();
            processAdapterUpdatesAndSetAnimationFlags();
            onExitLayoutOrScroll();
            if (this.mState.k_renamed) {
                this.mState.g_renamed = true;
            } else {
                this.mAdapterHelper.e_renamed();
                this.mState.g_renamed = false;
            }
            this.mAdapterUpdateDuringMeasure = false;
            stopInterceptRequestLayout(false);
        } else if (this.mState.k_renamed) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        androidx.recyclerview.widget.RecyclerView.a_renamed aVar = this.mAdapter;
        if (aVar != null) {
            this.mState.e_renamed = aVar.getItemCount();
        } else {
            this.mState.e_renamed = 0;
        }
        startInterceptRequestLayout();
        this.mLayout.onMeasure(this.mRecycler, this.mState, i2, i3);
        stopInterceptRequestLayout(false);
        this.mState.g_renamed = false;
    }

    void defaultOnMeasure(int i2, int i3) {
        setMeasuredDimension(androidx.recyclerview.widget.RecyclerView.i_renamed.chooseSize(i2, getPaddingLeft() + getPaddingRight(), androidx.core.h_renamed.v_renamed.l_renamed(this)), androidx.recyclerview.widget.RecyclerView.i_renamed.chooseSize(i3, getPaddingTop() + getPaddingBottom(), androidx.core.h_renamed.v_renamed.m_renamed(this)));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 == i4 && i3 == i5) {
            return;
        }
        invalidateGlows();
    }

    public void setItemAnimator(androidx.recyclerview.widget.RecyclerView.f_renamed fVar) {
        androidx.recyclerview.widget.RecyclerView.f_renamed fVar2 = this.mItemAnimator;
        if (fVar2 != null) {
            fVar2.d_renamed();
            this.mItemAnimator.a_renamed((androidx.recyclerview.widget.RecyclerView.f_renamed.b_renamed) null);
        }
        this.mItemAnimator = fVar;
        androidx.recyclerview.widget.RecyclerView.f_renamed fVar3 = this.mItemAnimator;
        if (fVar3 != null) {
            fVar3.a_renamed(this.mItemAnimatorListener);
        }
    }

    void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    void onExitLayoutOrScroll() {
        onExitLayoutOrScroll(true);
    }

    void onExitLayoutOrScroll(boolean z_renamed) {
        this.mLayoutOrScrollCounter--;
        if (this.mLayoutOrScrollCounter < 1) {
            this.mLayoutOrScrollCounter = 0;
            if (z_renamed) {
                dispatchContentChangedIfNecessary();
                dispatchPendingImportantForAccessibilityChanges();
            }
        }
    }

    boolean isAccessibilityEnabled() {
        android.view.accessibility.AccessibilityManager accessibilityManager = this.mAccessibilityManager;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    private void dispatchContentChangedIfNecessary() {
        int i2 = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if (i2 == 0 || !isAccessibilityEnabled()) {
            return;
        }
        android.view.accessibility.AccessibilityEvent accessibilityEventObtain = android.view.accessibility.AccessibilityEvent.obtain();
        accessibilityEventObtain.setEventType(2048);
        androidx.core.h_renamed.a_renamed.b_renamed.a_renamed(accessibilityEventObtain, i2);
        sendAccessibilityEventUnchecked(accessibilityEventObtain);
    }

    public boolean isComputingLayout() {
        return this.mLayoutOrScrollCounter > 0;
    }

    boolean shouldDeferAccessibilityEvent(android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        if (!isComputingLayout()) {
            return false;
        }
        int iA = accessibilityEvent != null ? androidx.core.h_renamed.a_renamed.b_renamed.a_renamed(accessibilityEvent) : 0;
        if (iA == 0) {
            iA = 0;
        }
        this.mEatenAccessibilityChangeFlags = iA | this.mEatenAccessibilityChangeFlags;
        return true;
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        if (shouldDeferAccessibilityEvent(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    public androidx.recyclerview.widget.RecyclerView.f_renamed getItemAnimator() {
        return this.mItemAnimator;
    }

    void postAnimationRunner() {
        if (this.mPostedAnimatorRunner || !this.mIsAttached) {
            return;
        }
        androidx.core.h_renamed.v_renamed.a_renamed(this, this.mItemAnimatorRunner);
        this.mPostedAnimatorRunner = true;
    }

    private boolean predictiveItemAnimationsEnabled() {
        return this.mItemAnimator != null && this.mLayout.supportsPredictiveItemAnimations();
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        if (this.mDataSetHasChangedAfterLayout) {
            this.mAdapterHelper.a_renamed();
            if (this.mDispatchItemsChangedEvent) {
                this.mLayout.onItemsChanged(this);
            }
        }
        if (predictiveItemAnimationsEnabled()) {
            this.mAdapterHelper.b_renamed();
        } else {
            this.mAdapterHelper.e_renamed();
        }
        boolean z_renamed = false;
        boolean z2 = this.mItemsAddedOrRemoved || this.mItemsChanged;
        this.mState.j_renamed = this.mFirstLayoutComplete && this.mItemAnimator != null && (this.mDataSetHasChangedAfterLayout || z2 || this.mLayout.mRequestedSimpleAnimations) && (!this.mDataSetHasChangedAfterLayout || this.mAdapter.hasStableIds());
        androidx.recyclerview.widget.RecyclerView.t_renamed tVar = this.mState;
        if (tVar.j_renamed && z2 && !this.mDataSetHasChangedAfterLayout && predictiveItemAnimationsEnabled()) {
            z_renamed = true;
        }
        tVar.k_renamed = z_renamed;
    }

    void dispatchLayout() {
        if (this.mAdapter == null) {
            android.util.Log.e_renamed(TAG, "No adapter attached; skipping layout");
            return;
        }
        if (this.mLayout == null) {
            android.util.Log.e_renamed(TAG, "No layout manager attached; skipping layout");
            return;
        }
        androidx.recyclerview.widget.RecyclerView.t_renamed tVar = this.mState;
        tVar.i_renamed = false;
        if (tVar.d_renamed == 1) {
            dispatchLayoutStep1();
            this.mLayout.setExactMeasureSpecsFrom(this);
            dispatchLayoutStep2();
        } else if (this.mAdapterHelper.f_renamed() || this.mLayout.getWidth() != getWidth() || this.mLayout.getHeight() != getHeight()) {
            this.mLayout.setExactMeasureSpecsFrom(this);
            dispatchLayoutStep2();
        } else {
            this.mLayout.setExactMeasureSpecsFrom(this);
        }
        dispatchLayoutStep3();
    }

    private void saveFocusInfo() {
        int absoluteAdapterPosition;
        android.view.View focusedChild = (this.mPreserveFocusAfterLayout && hasFocus() && this.mAdapter != null) ? getFocusedChild() : null;
        androidx.recyclerview.widget.RecyclerView.w_renamed wVarFindContainingViewHolder = focusedChild != null ? findContainingViewHolder(focusedChild) : null;
        if (wVarFindContainingViewHolder == null) {
            resetFocusInfo();
            return;
        }
        this.mState.m_renamed = this.mAdapter.hasStableIds() ? wVarFindContainingViewHolder.getItemId() : -1L;
        androidx.recyclerview.widget.RecyclerView.t_renamed tVar = this.mState;
        if (this.mDataSetHasChangedAfterLayout) {
            absoluteAdapterPosition = -1;
        } else {
            absoluteAdapterPosition = wVarFindContainingViewHolder.isRemoved() ? wVarFindContainingViewHolder.mOldPosition : wVarFindContainingViewHolder.getAbsoluteAdapterPosition();
        }
        tVar.l_renamed = absoluteAdapterPosition;
        this.mState.n_renamed = getDeepestFocusedViewWithId(wVarFindContainingViewHolder.itemView);
    }

    private void resetFocusInfo() {
        androidx.recyclerview.widget.RecyclerView.t_renamed tVar = this.mState;
        tVar.m_renamed = -1L;
        tVar.l_renamed = -1;
        tVar.n_renamed = -1;
    }

    private android.view.View findNextViewToFocus() {
        androidx.recyclerview.widget.RecyclerView.w_renamed wVarFindViewHolderForAdapterPosition;
        int i2 = this.mState.l_renamed != -1 ? this.mState.l_renamed : 0;
        int iE = this.mState.e_renamed();
        for (int i3 = i2; i3 < iE; i3++) {
            androidx.recyclerview.widget.RecyclerView.w_renamed wVarFindViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i3);
            if (wVarFindViewHolderForAdapterPosition2 == null) {
                break;
            }
            if (wVarFindViewHolderForAdapterPosition2.itemView.hasFocusable()) {
                return wVarFindViewHolderForAdapterPosition2.itemView;
            }
        }
        int iMin = java.lang.Math.min(iE, i2);
        do {
            iMin--;
            if (iMin < 0 || (wVarFindViewHolderForAdapterPosition = findViewHolderForAdapterPosition(iMin)) == null) {
                return null;
            }
        } while (!wVarFindViewHolderForAdapterPosition.itemView.hasFocusable());
        return wVarFindViewHolderForAdapterPosition.itemView;
    }

    private void recoverFocusFromState() {
        android.view.View viewFindViewById;
        if (!this.mPreserveFocusAfterLayout || this.mAdapter == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            android.view.View focusedChild = getFocusedChild();
            if (IGNORE_DETACHED_FOCUSED_CHILD && (focusedChild.getParent() == null || !focusedChild.hasFocus())) {
                if (this.mChildHelper.b_renamed() == 0) {
                    requestFocus();
                    return;
                }
            } else if (!this.mChildHelper.c_renamed(focusedChild)) {
                return;
            }
        }
        android.view.View viewFindNextViewToFocus = null;
        androidx.recyclerview.widget.RecyclerView.w_renamed wVarFindViewHolderForItemId = (this.mState.m_renamed == -1 || !this.mAdapter.hasStableIds()) ? null : findViewHolderForItemId(this.mState.m_renamed);
        if (wVarFindViewHolderForItemId == null || this.mChildHelper.c_renamed(wVarFindViewHolderForItemId.itemView) || !wVarFindViewHolderForItemId.itemView.hasFocusable()) {
            if (this.mChildHelper.b_renamed() > 0) {
                viewFindNextViewToFocus = findNextViewToFocus();
            }
        } else {
            viewFindNextViewToFocus = wVarFindViewHolderForItemId.itemView;
        }
        if (viewFindNextViewToFocus != null) {
            if (this.mState.n_renamed == -1 || (viewFindViewById = viewFindNextViewToFocus.findViewById(this.mState.n_renamed)) == null || !viewFindViewById.isFocusable()) {
                viewFindViewById = viewFindNextViewToFocus;
            }
            viewFindViewById.requestFocus();
        }
    }

    private int getDeepestFocusedViewWithId(android.view.View view) {
        int id_renamed = view.getId();
        while (!view.isFocused() && (view instanceof android.view.ViewGroup) && view.hasFocus()) {
            view = ((android.view.ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id_renamed = view.getId();
            }
        }
        return id_renamed;
    }

    final void fillRemainingScrollValues(androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        if (getScrollState() == 2) {
            android.widget.OverScroller overScroller = this.mViewFlinger.f1438a;
            tVar.o_renamed = overScroller.getFinalX() - overScroller.getCurrX();
            tVar.p_renamed = overScroller.getFinalY() - overScroller.getCurrY();
        } else {
            tVar.o_renamed = 0;
            tVar.p_renamed = 0;
        }
    }

    private void dispatchLayoutStep1() {
        this.mState.a_renamed(1);
        fillRemainingScrollValues(this.mState);
        this.mState.i_renamed = false;
        startInterceptRequestLayout();
        this.mViewInfoStore.a_renamed();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        saveFocusInfo();
        androidx.recyclerview.widget.RecyclerView.t_renamed tVar = this.mState;
        tVar.h_renamed = tVar.j_renamed && this.mItemsChanged;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        androidx.recyclerview.widget.RecyclerView.t_renamed tVar2 = this.mState;
        tVar2.g_renamed = tVar2.k_renamed;
        this.mState.e_renamed = this.mAdapter.getItemCount();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.j_renamed) {
            int iB = this.mChildHelper.b_renamed();
            for (int i2 = 0; i2 < iB; i2++) {
                androidx.recyclerview.widget.RecyclerView.w_renamed childViewHolderInt = getChildViewHolderInt(this.mChildHelper.b_renamed(i2));
                if (!childViewHolderInt.shouldIgnore() && (!childViewHolderInt.isInvalid() || this.mAdapter.hasStableIds())) {
                    this.mViewInfoStore.a_renamed(childViewHolderInt, this.mItemAnimator.a_renamed(this.mState, childViewHolderInt, androidx.recyclerview.widget.RecyclerView.f_renamed.e_renamed(childViewHolderInt), childViewHolderInt.getUnmodifiedPayloads()));
                    if (this.mState.h_renamed && childViewHolderInt.isUpdated() && !childViewHolderInt.isRemoved() && !childViewHolderInt.shouldIgnore() && !childViewHolderInt.isInvalid()) {
                        this.mViewInfoStore.a_renamed(getChangedHolderKey(childViewHolderInt), childViewHolderInt);
                    }
                }
            }
        }
        if (this.mState.k_renamed) {
            saveOldPositions();
            boolean z_renamed = this.mState.f_renamed;
            androidx.recyclerview.widget.RecyclerView.t_renamed tVar3 = this.mState;
            tVar3.f_renamed = false;
            this.mLayout.onLayoutChildren(this.mRecycler, tVar3);
            this.mState.f_renamed = z_renamed;
            for (int i3 = 0; i3 < this.mChildHelper.b_renamed(); i3++) {
                androidx.recyclerview.widget.RecyclerView.w_renamed childViewHolderInt2 = getChildViewHolderInt(this.mChildHelper.b_renamed(i3));
                if (!childViewHolderInt2.shouldIgnore() && !this.mViewInfoStore.d_renamed(childViewHolderInt2)) {
                    int iE = androidx.recyclerview.widget.RecyclerView.f_renamed.e_renamed(childViewHolderInt2);
                    boolean zHasAnyOfTheFlags = childViewHolderInt2.hasAnyOfTheFlags(8192);
                    if (!zHasAnyOfTheFlags) {
                        iE |= 4096;
                    }
                    androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed cVarA = this.mItemAnimator.a_renamed(this.mState, childViewHolderInt2, iE, childViewHolderInt2.getUnmodifiedPayloads());
                    if (zHasAnyOfTheFlags) {
                        recordAnimationInfoIfBouncedHiddenView(childViewHolderInt2, cVarA);
                    } else {
                        this.mViewInfoStore.b_renamed(childViewHolderInt2, cVarA);
                    }
                }
            }
            clearOldPositions();
        } else {
            clearOldPositions();
        }
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mState.d_renamed = 2;
    }

    private void dispatchLayoutStep2() {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.a_renamed(6);
        this.mAdapterHelper.e_renamed();
        this.mState.e_renamed = this.mAdapter.getItemCount();
        this.mState.f1437c = 0;
        if (this.mPendingSavedState != null && this.mAdapter.canRestoreState()) {
            if (this.mPendingSavedState.mLayoutState != null) {
                this.mLayout.onRestoreInstanceState(this.mPendingSavedState.mLayoutState);
            }
            this.mPendingSavedState = null;
        }
        androidx.recyclerview.widget.RecyclerView.t_renamed tVar = this.mState;
        tVar.g_renamed = false;
        this.mLayout.onLayoutChildren(this.mRecycler, tVar);
        androidx.recyclerview.widget.RecyclerView.t_renamed tVar2 = this.mState;
        tVar2.f_renamed = false;
        tVar2.j_renamed = tVar2.j_renamed && this.mItemAnimator != null;
        this.mState.d_renamed = 4;
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
    }

    private void dispatchLayoutStep3() {
        this.mState.a_renamed(4);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        androidx.recyclerview.widget.RecyclerView.t_renamed tVar = this.mState;
        tVar.d_renamed = 1;
        if (tVar.j_renamed) {
            for (int iB = this.mChildHelper.b_renamed() - 1; iB >= 0; iB--) {
                androidx.recyclerview.widget.RecyclerView.w_renamed childViewHolderInt = getChildViewHolderInt(this.mChildHelper.b_renamed(iB));
                if (!childViewHolderInt.shouldIgnore()) {
                    long changedHolderKey = getChangedHolderKey(childViewHolderInt);
                    androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed cVarA = this.mItemAnimator.a_renamed(this.mState, childViewHolderInt);
                    androidx.recyclerview.widget.RecyclerView.w_renamed wVarA = this.mViewInfoStore.a_renamed(changedHolderKey);
                    if (wVarA != null && !wVarA.shouldIgnore()) {
                        boolean zA = this.mViewInfoStore.a_renamed(wVarA);
                        boolean zA2 = this.mViewInfoStore.a_renamed(childViewHolderInt);
                        if (zA && wVarA == childViewHolderInt) {
                            this.mViewInfoStore.c_renamed(childViewHolderInt, cVarA);
                        } else {
                            androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed cVarB = this.mViewInfoStore.b_renamed(wVarA);
                            this.mViewInfoStore.c_renamed(childViewHolderInt, cVarA);
                            androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed cVarC = this.mViewInfoStore.c_renamed(childViewHolderInt);
                            if (cVarB == null) {
                                handleMissingPreInfoForChangeError(changedHolderKey, childViewHolderInt, wVarA);
                            } else {
                                animateChange(wVarA, childViewHolderInt, cVarB, cVarC, zA, zA2);
                            }
                        }
                    } else {
                        this.mViewInfoStore.c_renamed(childViewHolderInt, cVarA);
                    }
                }
            }
            this.mViewInfoStore.a_renamed(this.mViewInfoProcessCallback);
        }
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        androidx.recyclerview.widget.RecyclerView.t_renamed tVar2 = this.mState;
        tVar2.f1436b = tVar2.e_renamed;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        androidx.recyclerview.widget.RecyclerView.t_renamed tVar3 = this.mState;
        tVar3.j_renamed = false;
        tVar3.k_renamed = false;
        this.mLayout.mRequestedSimpleAnimations = false;
        if (this.mRecycler.f1429b != null) {
            this.mRecycler.f1429b.clear();
        }
        if (this.mLayout.mPrefetchMaxObservedInInitialPrefetch) {
            androidx.recyclerview.widget.RecyclerView.i_renamed iVar = this.mLayout;
            iVar.mPrefetchMaxCountObserved = 0;
            iVar.mPrefetchMaxObservedInInitialPrefetch = false;
            this.mRecycler.b_renamed();
        }
        this.mLayout.onLayoutCompleted(this.mState);
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mViewInfoStore.a_renamed();
        int[] iArr = this.mMinMaxLayoutPositions;
        if (didChildRangeChange(iArr[0], iArr[1])) {
            dispatchOnScrolled(0, 0);
        }
        recoverFocusFromState();
        resetFocusInfo();
    }

    private void handleMissingPreInfoForChangeError(long j2, androidx.recyclerview.widget.RecyclerView.w_renamed wVar, androidx.recyclerview.widget.RecyclerView.w_renamed wVar2) {
        int iB = this.mChildHelper.b_renamed();
        for (int i2 = 0; i2 < iB; i2++) {
            androidx.recyclerview.widget.RecyclerView.w_renamed childViewHolderInt = getChildViewHolderInt(this.mChildHelper.b_renamed(i2));
            if (childViewHolderInt != wVar && getChangedHolderKey(childViewHolderInt) == j2) {
                androidx.recyclerview.widget.RecyclerView.a_renamed aVar = this.mAdapter;
                if (aVar != null && aVar.hasStableIds()) {
                    throw new java.lang.IllegalStateException("Two different ViewHolders have the same stable ID_renamed. Stable IDs in_renamed your adapter MUST BE unique and SHOULD NOT change.\n_renamed ViewHolder 1:" + childViewHolderInt + " \n_renamed View Holder 2:" + wVar + exceptionLabel());
                }
                throw new java.lang.IllegalStateException("Two different ViewHolders have the same change ID_renamed. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n_renamed ViewHolder 1:" + childViewHolderInt + " \n_renamed View Holder 2:" + wVar + exceptionLabel());
            }
        }
        android.util.Log.e_renamed(TAG, "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + wVar2 + " cannot be_renamed found but it is_renamed necessary for " + wVar + exceptionLabel());
    }

    void recordAnimationInfoIfBouncedHiddenView(androidx.recyclerview.widget.RecyclerView.w_renamed wVar, androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed cVar) {
        wVar.setFlags(0, 8192);
        if (this.mState.h_renamed && wVar.isUpdated() && !wVar.isRemoved() && !wVar.shouldIgnore()) {
            this.mViewInfoStore.a_renamed(getChangedHolderKey(wVar), wVar);
        }
        this.mViewInfoStore.a_renamed(wVar, cVar);
    }

    private void findMinMaxChildLayoutPositions(int[] iArr) {
        int iB = this.mChildHelper.b_renamed();
        if (iB == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i2 = Integer.MIN_VALUE;
        int i3 = Integer.MAX_VALUE;
        for (int i4 = 0; i4 < iB; i4++) {
            androidx.recyclerview.widget.RecyclerView.w_renamed childViewHolderInt = getChildViewHolderInt(this.mChildHelper.b_renamed(i4));
            if (!childViewHolderInt.shouldIgnore()) {
                int layoutPosition = childViewHolderInt.getLayoutPosition();
                if (layoutPosition < i3) {
                    i3 = layoutPosition;
                }
                if (layoutPosition > i2) {
                    i2 = layoutPosition;
                }
            }
        }
        iArr[0] = i3;
        iArr[1] = i2;
    }

    private boolean didChildRangeChange(int i2, int i3) {
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        int[] iArr = this.mMinMaxLayoutPositions;
        return (iArr[0] == i2 && iArr[1] == i3) ? false : true;
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(android.view.View view, boolean z_renamed) {
        androidx.recyclerview.widget.RecyclerView.w_renamed childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.isTmpDetached()) {
                childViewHolderInt.clearTmpDetachFlag();
            } else if (!childViewHolderInt.shouldIgnore()) {
                throw new java.lang.IllegalArgumentException("Called removeDetachedView with a_renamed view which is_renamed not flagged as_renamed tmp detached." + childViewHolderInt + exceptionLabel());
            }
        }
        view.clearAnimation();
        dispatchChildDetached(view);
        super.removeDetachedView(view, z_renamed);
    }

    long getChangedHolderKey(androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
        return this.mAdapter.hasStableIds() ? wVar.getItemId() : wVar.mPosition;
    }

    void animateAppearance(androidx.recyclerview.widget.RecyclerView.w_renamed wVar, androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed cVar, androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed cVar2) {
        wVar.setIsRecyclable(false);
        if (this.mItemAnimator.b_renamed(wVar, cVar, cVar2)) {
            postAnimationRunner();
        }
    }

    void animateDisappearance(androidx.recyclerview.widget.RecyclerView.w_renamed wVar, androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed cVar, androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed cVar2) {
        addAnimatingView(wVar);
        wVar.setIsRecyclable(false);
        if (this.mItemAnimator.a_renamed(wVar, cVar, cVar2)) {
            postAnimationRunner();
        }
    }

    private void animateChange(androidx.recyclerview.widget.RecyclerView.w_renamed wVar, androidx.recyclerview.widget.RecyclerView.w_renamed wVar2, androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed cVar, androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed cVar2, boolean z_renamed, boolean z2) {
        wVar.setIsRecyclable(false);
        if (z_renamed) {
            addAnimatingView(wVar);
        }
        if (wVar != wVar2) {
            if (z2) {
                addAnimatingView(wVar2);
            }
            wVar.mShadowedHolder = wVar2;
            addAnimatingView(wVar);
            this.mRecycler.c_renamed(wVar);
            wVar2.setIsRecyclable(false);
            wVar2.mShadowingHolder = wVar;
        }
        if (this.mItemAnimator.a_renamed(wVar, wVar2, cVar, cVar2)) {
            postAnimationRunner();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z_renamed, int i2, int i3, int i4, int i5) {
        androidx.core.d_renamed.a_renamed.a_renamed(TRACE_ON_LAYOUT_TAG);
        dispatchLayout();
        androidx.core.d_renamed.a_renamed.a_renamed();
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
        int iC = this.mChildHelper.c_renamed();
        for (int i2 = 0; i2 < iC; i2++) {
            ((androidx.recyclerview.widget.RecyclerView.j_renamed) this.mChildHelper.d_renamed(i2).getLayoutParams()).e_renamed = true;
        }
        this.mRecycler.j_renamed();
    }

    @Override // android.view.View
    public void draw(android.graphics.Canvas canvas) {
        boolean z_renamed;
        boolean z2;
        super.draw(canvas);
        int size = this.mItemDecorations.size();
        boolean z3 = false;
        for (int i2 = 0; i2 < size; i2++) {
            this.mItemDecorations.get(i2).onDrawOver(canvas, this, this.mState);
        }
        android.widget.EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z_renamed = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.mClipToPadding ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            android.widget.EdgeEffect edgeEffect2 = this.mLeftGlow;
            z_renamed = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        android.widget.EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.mClipToPadding) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            android.widget.EdgeEffect edgeEffect4 = this.mTopGlow;
            z_renamed |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        android.widget.EdgeEffect edgeEffect5 = this.mRightGlow;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.mClipToPadding ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            android.widget.EdgeEffect edgeEffect6 = this.mRightGlow;
            z_renamed |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        android.widget.EdgeEffect edgeEffect7 = this.mBottomGlow;
        if (edgeEffect7 == null || edgeEffect7.isFinished()) {
            z2 = z_renamed;
        } else {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.mClipToPadding) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            android.widget.EdgeEffect edgeEffect8 = this.mBottomGlow;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z3 = true;
            }
            z2 = z3 | z_renamed;
            canvas.restoreToCount(iSave4);
        }
        if (!z2 && this.mItemAnimator != null && this.mItemDecorations.size() > 0 && this.mItemAnimator.b_renamed()) {
            z2 = true;
        }
        if (z2) {
            androidx.core.h_renamed.v_renamed.e_renamed(this);
        }
    }

    @Override // android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        int size = this.mItemDecorations.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mItemDecorations.get(i2).onDraw(canvas, this, this.mState);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof androidx.recyclerview.widget.RecyclerView.j_renamed) && this.mLayout.checkLayoutParams((androidx.recyclerview.widget.RecyclerView.j_renamed) layoutParams);
    }

    @Override // android.view.ViewGroup
    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        androidx.recyclerview.widget.RecyclerView.i_renamed iVar = this.mLayout;
        if (iVar == null) {
            throw new java.lang.IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
        }
        return iVar.generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    public android.view.ViewGroup.LayoutParams generateLayoutParams(android.util.AttributeSet attributeSet) {
        androidx.recyclerview.widget.RecyclerView.i_renamed iVar = this.mLayout;
        if (iVar == null) {
            throw new java.lang.IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
        }
        return iVar.generateLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        androidx.recyclerview.widget.RecyclerView.i_renamed iVar = this.mLayout;
        if (iVar == null) {
            throw new java.lang.IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
        }
        return iVar.generateLayoutParams(layoutParams);
    }

    public boolean isAnimating() {
        androidx.recyclerview.widget.RecyclerView.f_renamed fVar = this.mItemAnimator;
        return fVar != null && fVar.b_renamed();
    }

    void saveOldPositions() {
        int iC = this.mChildHelper.c_renamed();
        for (int i2 = 0; i2 < iC; i2++) {
            androidx.recyclerview.widget.RecyclerView.w_renamed childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d_renamed(i2));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.saveOldPosition();
            }
        }
    }

    void clearOldPositions() {
        int iC = this.mChildHelper.c_renamed();
        for (int i2 = 0; i2 < iC; i2++) {
            androidx.recyclerview.widget.RecyclerView.w_renamed childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d_renamed(i2));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.clearOldPosition();
            }
        }
        this.mRecycler.i_renamed();
    }

    void offsetPositionRecordsForMove(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int iC = this.mChildHelper.c_renamed();
        if (i2 < i3) {
            i4 = i3;
            i6 = -1;
            i5 = i2;
        } else {
            i4 = i2;
            i5 = i3;
            i6 = 1;
        }
        for (int i7 = 0; i7 < iC; i7++) {
            androidx.recyclerview.widget.RecyclerView.w_renamed childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d_renamed(i7));
            if (childViewHolderInt != null && childViewHolderInt.mPosition >= i5 && childViewHolderInt.mPosition <= i4) {
                if (childViewHolderInt.mPosition == i2) {
                    childViewHolderInt.offsetPosition(i3 - i2, false);
                } else {
                    childViewHolderInt.offsetPosition(i6, false);
                }
                this.mState.f_renamed = true;
            }
        }
        this.mRecycler.a_renamed(i2, i3);
        requestLayout();
    }

    void offsetPositionRecordsForInsert(int i2, int i3) {
        int iC = this.mChildHelper.c_renamed();
        for (int i4 = 0; i4 < iC; i4++) {
            androidx.recyclerview.widget.RecyclerView.w_renamed childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d_renamed(i4));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i2) {
                childViewHolderInt.offsetPosition(i3, false);
                this.mState.f_renamed = true;
            }
        }
        this.mRecycler.b_renamed(i2, i3);
        requestLayout();
    }

    void offsetPositionRecordsForRemove(int i2, int i3, boolean z_renamed) {
        int i4 = i2 + i3;
        int iC = this.mChildHelper.c_renamed();
        for (int i5 = 0; i5 < iC; i5++) {
            androidx.recyclerview.widget.RecyclerView.w_renamed childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d_renamed(i5));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                if (childViewHolderInt.mPosition >= i4) {
                    childViewHolderInt.offsetPosition(-i3, z_renamed);
                    this.mState.f_renamed = true;
                } else if (childViewHolderInt.mPosition >= i2) {
                    childViewHolderInt.flagRemovedAndOffsetPosition(i2 - 1, -i3, z_renamed);
                    this.mState.f_renamed = true;
                }
            }
        }
        this.mRecycler.a_renamed(i2, i3, z_renamed);
        requestLayout();
    }

    void viewRangeUpdate(int i2, int i3, java.lang.Object obj) {
        int iC = this.mChildHelper.c_renamed();
        int i4 = i2 + i3;
        for (int i5 = 0; i5 < iC; i5++) {
            android.view.View viewD = this.mChildHelper.d_renamed(i5);
            androidx.recyclerview.widget.RecyclerView.w_renamed childViewHolderInt = getChildViewHolderInt(viewD);
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i2 && childViewHolderInt.mPosition < i4) {
                childViewHolderInt.addFlags(2);
                childViewHolderInt.addChangePayload(obj);
                ((androidx.recyclerview.widget.RecyclerView.j_renamed) viewD.getLayoutParams()).e_renamed = true;
            }
        }
        this.mRecycler.c_renamed(i2, i3);
    }

    boolean canReuseUpdatedViewHolder(androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
        androidx.recyclerview.widget.RecyclerView.f_renamed fVar = this.mItemAnimator;
        return fVar == null || fVar.a_renamed(wVar, wVar.getUnmodifiedPayloads());
    }

    void processDataSetCompletelyChanged(boolean z_renamed) {
        this.mDispatchItemsChangedEvent = z_renamed | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        markKnownViewsInvalid();
    }

    void markKnownViewsInvalid() {
        int iC = this.mChildHelper.c_renamed();
        for (int i2 = 0; i2 < iC; i2++) {
            androidx.recyclerview.widget.RecyclerView.w_renamed childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d_renamed(i2));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.addFlags(6);
            }
        }
        markItemDecorInsetsDirty();
        this.mRecycler.h_renamed();
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() == 0) {
            return;
        }
        androidx.recyclerview.widget.RecyclerView.i_renamed iVar = this.mLayout;
        if (iVar != null) {
            iVar.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a_renamed scroll or layout");
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    public void setPreserveFocusAfterLayout(boolean z_renamed) {
        this.mPreserveFocusAfterLayout = z_renamed;
    }

    public androidx.recyclerview.widget.RecyclerView.w_renamed getChildViewHolder(android.view.View view) {
        android.view.ViewParent parent = view.getParent();
        if (parent != null && parent != this) {
            throw new java.lang.IllegalArgumentException("View " + view + " is_renamed not a_renamed direct child of_renamed " + this);
        }
        return getChildViewHolderInt(view);
    }

    public android.view.View findContainingItemView(android.view.View view) {
        android.view.ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof android.view.View)) {
            view = parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public androidx.recyclerview.widget.RecyclerView.w_renamed findContainingViewHolder(android.view.View view) {
        android.view.View viewFindContainingItemView = findContainingItemView(view);
        if (viewFindContainingItemView == null) {
            return null;
        }
        return getChildViewHolder(viewFindContainingItemView);
    }

    static androidx.recyclerview.widget.RecyclerView.w_renamed getChildViewHolderInt(android.view.View view) {
        if (view == null) {
            return null;
        }
        return ((androidx.recyclerview.widget.RecyclerView.j_renamed) view.getLayoutParams()).f1422c;
    }

    @java.lang.Deprecated
    public int getChildPosition(android.view.View view) {
        return getChildAdapterPosition(view);
    }

    public int getChildAdapterPosition(android.view.View view) {
        androidx.recyclerview.widget.RecyclerView.w_renamed childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getAbsoluteAdapterPosition();
        }
        return -1;
    }

    public int getChildLayoutPosition(android.view.View view) {
        androidx.recyclerview.widget.RecyclerView.w_renamed childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getLayoutPosition();
        }
        return -1;
    }

    public long getChildItemId(android.view.View view) {
        androidx.recyclerview.widget.RecyclerView.w_renamed childViewHolderInt;
        androidx.recyclerview.widget.RecyclerView.a_renamed aVar = this.mAdapter;
        if (aVar == null || !aVar.hasStableIds() || (childViewHolderInt = getChildViewHolderInt(view)) == null) {
            return -1L;
        }
        return childViewHolderInt.getItemId();
    }

    @java.lang.Deprecated
    public androidx.recyclerview.widget.RecyclerView.w_renamed findViewHolderForPosition(int i2) {
        return findViewHolderForPosition(i2, false);
    }

    public androidx.recyclerview.widget.RecyclerView.w_renamed findViewHolderForLayoutPosition(int i2) {
        return findViewHolderForPosition(i2, false);
    }

    public androidx.recyclerview.widget.RecyclerView.w_renamed findViewHolderForAdapterPosition(int i2) {
        androidx.recyclerview.widget.RecyclerView.w_renamed wVar = null;
        if (this.mDataSetHasChangedAfterLayout) {
            return null;
        }
        int iC = this.mChildHelper.c_renamed();
        for (int i3 = 0; i3 < iC; i3++) {
            androidx.recyclerview.widget.RecyclerView.w_renamed childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d_renamed(i3));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && getAdapterPositionInRecyclerView(childViewHolderInt) == i2) {
                if (!this.mChildHelper.c_renamed(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                wVar = childViewHolderInt;
            }
        }
        return wVar;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:15:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    androidx.recyclerview.widget.RecyclerView.w_renamed findViewHolderForPosition(int r6, boolean r7) {
        /*
            r5 = this;
            androidx.recyclerview.widget.d_renamed r0 = r5.mChildHelper
            int r0 = r0.c_renamed()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L3a
            androidx.recyclerview.widget.d_renamed r3 = r5.mChildHelper
            android.view.View r3 = r3.d_renamed(r2)
            androidx.recyclerview.widget.RecyclerView$w_renamed r3 = getChildViewHolderInt(r3)
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
            androidx.recyclerview.widget.d_renamed r1 = r5.mChildHelper
            android.view.View r4 = r3.itemView
            boolean r1 = r1.c_renamed(r4)
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.findViewHolderForPosition(int, boolean):androidx.recyclerview.widget.RecyclerView$w_renamed");
    }

    public androidx.recyclerview.widget.RecyclerView.w_renamed findViewHolderForItemId(long j2) {
        androidx.recyclerview.widget.RecyclerView.a_renamed aVar = this.mAdapter;
        androidx.recyclerview.widget.RecyclerView.w_renamed wVar = null;
        if (aVar != null && aVar.hasStableIds()) {
            int iC = this.mChildHelper.c_renamed();
            for (int i2 = 0; i2 < iC; i2++) {
                androidx.recyclerview.widget.RecyclerView.w_renamed childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d_renamed(i2));
                if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && childViewHolderInt.getItemId() == j2) {
                    if (!this.mChildHelper.c_renamed(childViewHolderInt.itemView)) {
                        return childViewHolderInt;
                    }
                    wVar = childViewHolderInt;
                }
            }
        }
        return wVar;
    }

    public android.view.View findChildViewUnder(float f2, float f3) {
        for (int iB = this.mChildHelper.b_renamed() - 1; iB >= 0; iB--) {
            android.view.View viewB = this.mChildHelper.b_renamed(iB);
            float translationX = viewB.getTranslationX();
            float translationY = viewB.getTranslationY();
            if (f2 >= viewB.getLeft() + translationX && f2 <= viewB.getRight() + translationX && f3 >= viewB.getTop() + translationY && f3 <= viewB.getBottom() + translationY) {
                return viewB;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(android.graphics.Canvas canvas, android.view.View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    public void offsetChildrenVertical(int i2) {
        int iB = this.mChildHelper.b_renamed();
        for (int i3 = 0; i3 < iB; i3++) {
            this.mChildHelper.b_renamed(i3).offsetTopAndBottom(i2);
        }
    }

    public void offsetChildrenHorizontal(int i2) {
        int iB = this.mChildHelper.b_renamed();
        for (int i3 = 0; i3 < iB; i3++) {
            this.mChildHelper.b_renamed(i3).offsetLeftAndRight(i2);
        }
    }

    public void getDecoratedBoundsWithMargins(android.view.View view, android.graphics.Rect rect) {
        getDecoratedBoundsWithMarginsInt(view, rect);
    }

    static void getDecoratedBoundsWithMarginsInt(android.view.View view, android.graphics.Rect rect) {
        androidx.recyclerview.widget.RecyclerView.j_renamed jVar = (androidx.recyclerview.widget.RecyclerView.j_renamed) view.getLayoutParams();
        android.graphics.Rect rect2 = jVar.d_renamed;
        rect.set((view.getLeft() - rect2.left) - jVar.leftMargin, (view.getTop() - rect2.top) - jVar.topMargin, view.getRight() + rect2.right + jVar.rightMargin, view.getBottom() + rect2.bottom + jVar.bottomMargin);
    }

    android.graphics.Rect getItemDecorInsetsForChild(android.view.View view) {
        androidx.recyclerview.widget.RecyclerView.j_renamed jVar = (androidx.recyclerview.widget.RecyclerView.j_renamed) view.getLayoutParams();
        if (!jVar.e_renamed) {
            return jVar.d_renamed;
        }
        if (this.mState.a_renamed() && (jVar.e_renamed() || jVar.c_renamed())) {
            return jVar.d_renamed;
        }
        android.graphics.Rect rect = jVar.d_renamed;
        rect.set(0, 0, 0, 0);
        int size = this.mItemDecorations.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mTempRect.set(0, 0, 0, 0);
            this.mItemDecorations.get(i2).getItemOffsets(this.mTempRect, view, this, this.mState);
            rect.left += this.mTempRect.left;
            rect.top += this.mTempRect.top;
            rect.right += this.mTempRect.right;
            rect.bottom += this.mTempRect.bottom;
        }
        jVar.e_renamed = false;
        return rect;
    }

    void dispatchOnScrolled(int i2, int i3) {
        this.mDispatchScrollCounter++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i2, scrollY - i3);
        onScrolled(i2, i3);
        androidx.recyclerview.widget.RecyclerView.n_renamed nVar = this.mScrollListener;
        if (nVar != null) {
            nVar.onScrolled(this, i2, i3);
        }
        java.util.List<androidx.recyclerview.widget.RecyclerView.n_renamed> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrolled(this, i2, i3);
            }
        }
        this.mDispatchScrollCounter--;
    }

    void dispatchOnScrollStateChanged(int i2) {
        androidx.recyclerview.widget.RecyclerView.i_renamed iVar = this.mLayout;
        if (iVar != null) {
            iVar.onScrollStateChanged(i2);
        }
        onScrollStateChanged(i2);
        androidx.recyclerview.widget.RecyclerView.n_renamed nVar = this.mScrollListener;
        if (nVar != null) {
            nVar.onScrollStateChanged(this, i2);
        }
        java.util.List<androidx.recyclerview.widget.RecyclerView.n_renamed> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrollStateChanged(this, i2);
            }
        }
    }

    public boolean hasPendingAdapterUpdates() {
        return !this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout || this.mAdapterHelper.d_renamed();
    }

    class v_renamed implements java.lang.Runnable {

        /* renamed from: a_renamed, reason: collision with root package name */
        android.widget.OverScroller f1438a;
        private int d_renamed;
        private int e_renamed;

        /* renamed from: b_renamed, reason: collision with root package name */
        android.view.animation.Interpolator f1439b = androidx.recyclerview.widget.RecyclerView.sQuinticInterpolator;
        private boolean f_renamed = false;
        private boolean g_renamed = false;

        v_renamed() {
            this.f1438a = new android.widget.OverScroller(androidx.recyclerview.widget.RecyclerView.this.getContext(), androidx.recyclerview.widget.RecyclerView.sQuinticInterpolator);
        }

        @Override // java.lang.Runnable
        public void run() {
            int i_renamed;
            int i2;
            if (androidx.recyclerview.widget.RecyclerView.this.mLayout == null) {
                b_renamed();
                return;
            }
            this.g_renamed = false;
            this.f_renamed = true;
            androidx.recyclerview.widget.RecyclerView.this.consumePendingUpdateOperations();
            android.widget.OverScroller overScroller = this.f1438a;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i3 = currX - this.d_renamed;
                int i4 = currY - this.e_renamed;
                this.d_renamed = currX;
                this.e_renamed = currY;
                androidx.recyclerview.widget.RecyclerView.this.mReusableIntPair[0] = 0;
                androidx.recyclerview.widget.RecyclerView.this.mReusableIntPair[1] = 0;
                androidx.recyclerview.widget.RecyclerView recyclerView = androidx.recyclerview.widget.RecyclerView.this;
                if (recyclerView.dispatchNestedPreScroll(i3, i4, recyclerView.mReusableIntPair, null, 1)) {
                    i3 -= androidx.recyclerview.widget.RecyclerView.this.mReusableIntPair[0];
                    i4 -= androidx.recyclerview.widget.RecyclerView.this.mReusableIntPair[1];
                }
                if (androidx.recyclerview.widget.RecyclerView.this.getOverScrollMode() != 2) {
                    androidx.recyclerview.widget.RecyclerView.this.considerReleasingGlowsOnScroll(i3, i4);
                }
                if (androidx.recyclerview.widget.RecyclerView.this.mAdapter != null) {
                    androidx.recyclerview.widget.RecyclerView.this.mReusableIntPair[0] = 0;
                    androidx.recyclerview.widget.RecyclerView.this.mReusableIntPair[1] = 0;
                    androidx.recyclerview.widget.RecyclerView recyclerView2 = androidx.recyclerview.widget.RecyclerView.this;
                    recyclerView2.scrollStep(i3, i4, recyclerView2.mReusableIntPair);
                    i_renamed = androidx.recyclerview.widget.RecyclerView.this.mReusableIntPair[0];
                    i2 = androidx.recyclerview.widget.RecyclerView.this.mReusableIntPair[1];
                    i3 -= i_renamed;
                    i4 -= i2;
                    androidx.recyclerview.widget.RecyclerView.s_renamed sVar = androidx.recyclerview.widget.RecyclerView.this.mLayout.mSmoothScroller;
                    if (sVar != null && !sVar.isPendingInitialRun() && sVar.isRunning()) {
                        int iE = androidx.recyclerview.widget.RecyclerView.this.mState.e_renamed();
                        if (iE == 0) {
                            sVar.stop();
                        } else if (sVar.getTargetPosition() >= iE) {
                            sVar.setTargetPosition(iE - 1);
                            sVar.onAnimation(i_renamed, i2);
                        } else {
                            sVar.onAnimation(i_renamed, i2);
                        }
                    }
                } else {
                    i_renamed = 0;
                    i2 = 0;
                }
                if (!androidx.recyclerview.widget.RecyclerView.this.mItemDecorations.isEmpty()) {
                    androidx.recyclerview.widget.RecyclerView.this.invalidate();
                }
                androidx.recyclerview.widget.RecyclerView.this.mReusableIntPair[0] = 0;
                androidx.recyclerview.widget.RecyclerView.this.mReusableIntPair[1] = 0;
                androidx.recyclerview.widget.RecyclerView recyclerView3 = androidx.recyclerview.widget.RecyclerView.this;
                recyclerView3.dispatchNestedScroll(i_renamed, i2, i3, i4, null, 1, recyclerView3.mReusableIntPair);
                int i5 = i3 - androidx.recyclerview.widget.RecyclerView.this.mReusableIntPair[0];
                int i6 = i4 - androidx.recyclerview.widget.RecyclerView.this.mReusableIntPair[1];
                if (i_renamed != 0 || i2 != 0) {
                    androidx.recyclerview.widget.RecyclerView.this.dispatchOnScrolled(i_renamed, i2);
                }
                if (!androidx.recyclerview.widget.RecyclerView.this.awakenScrollBars()) {
                    androidx.recyclerview.widget.RecyclerView.this.invalidate();
                }
                boolean z_renamed = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i5 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i6 != 0));
                androidx.recyclerview.widget.RecyclerView.s_renamed sVar2 = androidx.recyclerview.widget.RecyclerView.this.mLayout.mSmoothScroller;
                if (!(sVar2 != null && sVar2.isPendingInitialRun()) && z_renamed) {
                    if (androidx.recyclerview.widget.RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i7 = i5 < 0 ? -currVelocity : i5 > 0 ? currVelocity : 0;
                        if (i6 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i6 <= 0) {
                            currVelocity = 0;
                        }
                        androidx.recyclerview.widget.RecyclerView.this.absorbGlows(i7, currVelocity);
                    }
                    if (androidx.recyclerview.widget.RecyclerView.ALLOW_THREAD_GAP_WORK) {
                        androidx.recyclerview.widget.RecyclerView.this.mPrefetchRegistry.a_renamed();
                    }
                } else {
                    a_renamed();
                    if (androidx.recyclerview.widget.RecyclerView.this.mGapWorker != null) {
                        androidx.recyclerview.widget.RecyclerView.this.mGapWorker.a_renamed(androidx.recyclerview.widget.RecyclerView.this, i_renamed, i2);
                    }
                }
            }
            androidx.recyclerview.widget.RecyclerView.s_renamed sVar3 = androidx.recyclerview.widget.RecyclerView.this.mLayout.mSmoothScroller;
            if (sVar3 != null && sVar3.isPendingInitialRun()) {
                sVar3.onAnimation(0, 0);
            }
            this.f_renamed = false;
            if (this.g_renamed) {
                c_renamed();
            } else {
                androidx.recyclerview.widget.RecyclerView.this.setScrollState(0);
                androidx.recyclerview.widget.RecyclerView.this.stopNestedScroll(1);
            }
        }

        void a_renamed() {
            if (this.f_renamed) {
                this.g_renamed = true;
            } else {
                c_renamed();
            }
        }

        private void c_renamed() {
            androidx.recyclerview.widget.RecyclerView.this.removeCallbacks(this);
            androidx.core.h_renamed.v_renamed.a_renamed(androidx.recyclerview.widget.RecyclerView.this, this);
        }

        public void a_renamed(int i_renamed, int i2) {
            androidx.recyclerview.widget.RecyclerView.this.setScrollState(2);
            this.e_renamed = 0;
            this.d_renamed = 0;
            if (this.f1439b != androidx.recyclerview.widget.RecyclerView.sQuinticInterpolator) {
                this.f1439b = androidx.recyclerview.widget.RecyclerView.sQuinticInterpolator;
                this.f1438a = new android.widget.OverScroller(androidx.recyclerview.widget.RecyclerView.this.getContext(), androidx.recyclerview.widget.RecyclerView.sQuinticInterpolator);
            }
            this.f1438a.fling(0, 0, i_renamed, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            a_renamed();
        }

        public void a_renamed(int i_renamed, int i2, int i3, android.view.animation.Interpolator interpolator) {
            if (i3 == Integer.MIN_VALUE) {
                i3 = a_renamed(i_renamed, i2, 0, 0);
            }
            int i4 = i3;
            if (interpolator == null) {
                interpolator = androidx.recyclerview.widget.RecyclerView.sQuinticInterpolator;
            }
            if (this.f1439b != interpolator) {
                this.f1439b = interpolator;
                this.f1438a = new android.widget.OverScroller(androidx.recyclerview.widget.RecyclerView.this.getContext(), interpolator);
            }
            this.e_renamed = 0;
            this.d_renamed = 0;
            androidx.recyclerview.widget.RecyclerView.this.setScrollState(2);
            this.f1438a.startScroll(0, 0, i_renamed, i2, i4);
            if (android.os.Build.VERSION.SDK_INT < 23) {
                this.f1438a.computeScrollOffset();
            }
            a_renamed();
        }

        private float a_renamed(float f_renamed) {
            return (float) java.lang.Math.sin((f_renamed - 0.5f) * 0.47123894f);
        }

        private int a_renamed(int i_renamed, int i2, int i3, int i4) {
            int iRound;
            int iAbs = java.lang.Math.abs(i_renamed);
            int iAbs2 = java.lang.Math.abs(i2);
            boolean z_renamed = iAbs > iAbs2;
            int iSqrt = (int) java.lang.Math.sqrt((i3 * i3) + (i4 * i4));
            int iSqrt2 = (int) java.lang.Math.sqrt((i_renamed * i_renamed) + (i2 * i2));
            int width = z_renamed ? androidx.recyclerview.widget.RecyclerView.this.getWidth() : androidx.recyclerview.widget.RecyclerView.this.getHeight();
            int i5 = width / 2;
            float f_renamed = width;
            float f2 = i5;
            float fA_renamed = f2 + (a_renamed(java.lang.Math.min(1.0f, (iSqrt2 * 1.0f) / f_renamed)) * f2);
            if (iSqrt > 0) {
                iRound = java.lang.Math.round(java.lang.Math.abs(fA_renamed / iSqrt) * 1000.0f) * 4;
            } else {
                if (!z_renamed) {
                    iAbs = iAbs2;
                }
                iRound = (int) (((iAbs / f_renamed) + 1.0f) * 300.0f);
            }
            return java.lang.Math.min(iRound, 2000);
        }

        public void b_renamed() {
            androidx.recyclerview.widget.RecyclerView.this.removeCallbacks(this);
            this.f1438a.abortAnimation();
        }
    }

    void repositionShadowingViews() {
        int iB = this.mChildHelper.b_renamed();
        for (int i2 = 0; i2 < iB; i2++) {
            android.view.View viewB = this.mChildHelper.b_renamed(i2);
            androidx.recyclerview.widget.RecyclerView.w_renamed childViewHolder = getChildViewHolder(viewB);
            if (childViewHolder != null && childViewHolder.mShadowingHolder != null) {
                android.view.View view = childViewHolder.mShadowingHolder.itemView;
                int left = viewB.getLeft();
                int top = viewB.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    private class r_renamed extends androidx.recyclerview.widget.RecyclerView.c_renamed {
        r_renamed() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c_renamed
        public void onChanged() {
            androidx.recyclerview.widget.RecyclerView.this.assertNotInLayoutOrScroll(null);
            androidx.recyclerview.widget.RecyclerView.this.mState.f_renamed = true;
            androidx.recyclerview.widget.RecyclerView.this.processDataSetCompletelyChanged(true);
            if (androidx.recyclerview.widget.RecyclerView.this.mAdapterHelper.d_renamed()) {
                return;
            }
            androidx.recyclerview.widget.RecyclerView.this.requestLayout();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c_renamed
        public void onItemRangeChanged(int i_renamed, int i2, java.lang.Object obj) {
            androidx.recyclerview.widget.RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (androidx.recyclerview.widget.RecyclerView.this.mAdapterHelper.a_renamed(i_renamed, i2, obj)) {
                a_renamed();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c_renamed
        public void onItemRangeInserted(int i_renamed, int i2) {
            androidx.recyclerview.widget.RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (androidx.recyclerview.widget.RecyclerView.this.mAdapterHelper.b_renamed(i_renamed, i2)) {
                a_renamed();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c_renamed
        public void onItemRangeRemoved(int i_renamed, int i2) {
            androidx.recyclerview.widget.RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (androidx.recyclerview.widget.RecyclerView.this.mAdapterHelper.c_renamed(i_renamed, i2)) {
                a_renamed();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c_renamed
        public void onItemRangeMoved(int i_renamed, int i2, int i3) {
            androidx.recyclerview.widget.RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (androidx.recyclerview.widget.RecyclerView.this.mAdapterHelper.a_renamed(i_renamed, i2, i3)) {
                a_renamed();
            }
        }

        void a_renamed() {
            if (androidx.recyclerview.widget.RecyclerView.POST_UPDATES_ON_ANIMATION && androidx.recyclerview.widget.RecyclerView.this.mHasFixedSize && androidx.recyclerview.widget.RecyclerView.this.mIsAttached) {
                androidx.recyclerview.widget.RecyclerView recyclerView = androidx.recyclerview.widget.RecyclerView.this;
                androidx.core.h_renamed.v_renamed.a_renamed(recyclerView, recyclerView.mUpdateChildViewsRunnable);
            } else {
                androidx.recyclerview.widget.RecyclerView recyclerView2 = androidx.recyclerview.widget.RecyclerView.this;
                recyclerView2.mAdapterUpdateDuringMeasure = true;
                recyclerView2.requestLayout();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c_renamed
        public void onStateRestorationPolicyChanged() {
            androidx.recyclerview.widget.RecyclerView.a_renamed aVar;
            if (androidx.recyclerview.widget.RecyclerView.this.mPendingSavedState == null || (aVar = androidx.recyclerview.widget.RecyclerView.this.mAdapter) == null || !aVar.canRestoreState()) {
                return;
            }
            androidx.recyclerview.widget.RecyclerView.this.requestLayout();
        }
    }

    public static class e_renamed {
        protected android.widget.EdgeEffect a_renamed(androidx.recyclerview.widget.RecyclerView recyclerView, int i_renamed) {
            return new android.widget.EdgeEffect(recyclerView.getContext());
        }
    }

    public static class o_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        android.util.SparseArray<androidx.recyclerview.widget.RecyclerView.o_renamed.a_renamed> f1423a = new android.util.SparseArray<>();

        /* renamed from: b_renamed, reason: collision with root package name */
        private int f1424b = 0;

        static class a_renamed {

            /* renamed from: a_renamed, reason: collision with root package name */
            final java.util.ArrayList<androidx.recyclerview.widget.RecyclerView.w_renamed> f1425a = new java.util.ArrayList<>();

            /* renamed from: b_renamed, reason: collision with root package name */
            int f1426b = 5;

            /* renamed from: c_renamed, reason: collision with root package name */
            long f1427c = 0;
            long d_renamed = 0;

            a_renamed() {
            }
        }

        public void a_renamed() {
            for (int i_renamed = 0; i_renamed < this.f1423a.size(); i_renamed++) {
                this.f1423a.valueAt(i_renamed).f1425a.clear();
            }
        }

        public androidx.recyclerview.widget.RecyclerView.w_renamed a_renamed(int i_renamed) {
            androidx.recyclerview.widget.RecyclerView.o_renamed.a_renamed aVar = this.f1423a.get(i_renamed);
            if (aVar == null || aVar.f1425a.isEmpty()) {
                return null;
            }
            java.util.ArrayList<androidx.recyclerview.widget.RecyclerView.w_renamed> arrayList = aVar.f1425a;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!arrayList.get(size).isAttachedToTransitionOverlay()) {
                    return arrayList.remove(size);
                }
            }
            return null;
        }

        public void a_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
            int itemViewType = wVar.getItemViewType();
            java.util.ArrayList<androidx.recyclerview.widget.RecyclerView.w_renamed> arrayList = b_renamed(itemViewType).f1425a;
            if (this.f1423a.get(itemViewType).f1426b <= arrayList.size()) {
                return;
            }
            wVar.resetInternal();
            arrayList.add(wVar);
        }

        long a_renamed(long j_renamed, long j2) {
            return j_renamed == 0 ? j2 : ((j_renamed / 4) * 3) + (j2 / 4);
        }

        void a_renamed(int i_renamed, long j_renamed) {
            androidx.recyclerview.widget.RecyclerView.o_renamed.a_renamed aVarB = b_renamed(i_renamed);
            aVarB.f1427c = a_renamed(aVarB.f1427c, j_renamed);
        }

        void b_renamed(int i_renamed, long j_renamed) {
            androidx.recyclerview.widget.RecyclerView.o_renamed.a_renamed aVarB = b_renamed(i_renamed);
            aVarB.d_renamed = a_renamed(aVarB.d_renamed, j_renamed);
        }

        boolean a_renamed(int i_renamed, long j_renamed, long j2) {
            long j3 = b_renamed(i_renamed).f1427c;
            return j3 == 0 || j_renamed + j3 < j2;
        }

        boolean b_renamed(int i_renamed, long j_renamed, long j2) {
            long j3 = b_renamed(i_renamed).d_renamed;
            return j3 == 0 || j_renamed + j3 < j2;
        }

        void b_renamed() {
            this.f1424b++;
        }

        void c_renamed() {
            this.f1424b--;
        }

        void a_renamed(androidx.recyclerview.widget.RecyclerView.a_renamed aVar, androidx.recyclerview.widget.RecyclerView.a_renamed aVar2, boolean z_renamed) {
            if (aVar != null) {
                c_renamed();
            }
            if (!z_renamed && this.f1424b == 0) {
                a_renamed();
            }
            if (aVar2 != null) {
                b_renamed();
            }
        }

        private androidx.recyclerview.widget.RecyclerView.o_renamed.a_renamed b_renamed(int i_renamed) {
            androidx.recyclerview.widget.RecyclerView.o_renamed.a_renamed aVar = this.f1423a.get(i_renamed);
            if (aVar != null) {
                return aVar;
            }
            androidx.recyclerview.widget.RecyclerView.o_renamed.a_renamed aVar2 = new androidx.recyclerview.widget.RecyclerView.o_renamed.a_renamed();
            this.f1423a.put(i_renamed, aVar2);
            return aVar2;
        }
    }

    static androidx.recyclerview.widget.RecyclerView findNestedRecyclerView(android.view.View view) {
        if (!(view instanceof android.view.ViewGroup)) {
            return null;
        }
        if (view instanceof androidx.recyclerview.widget.RecyclerView) {
            return (androidx.recyclerview.widget.RecyclerView) view;
        }
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            androidx.recyclerview.widget.RecyclerView recyclerViewFindNestedRecyclerView = findNestedRecyclerView(viewGroup.getChildAt(i2));
            if (recyclerViewFindNestedRecyclerView != null) {
                return recyclerViewFindNestedRecyclerView;
            }
        }
        return null;
    }

    static void clearNestedRecyclerViewIfNotNested(androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
        if (wVar.mNestedRecyclerView != null) {
            androidx.recyclerview.widget.RecyclerView recyclerView = wVar.mNestedRecyclerView.get();
            while (recyclerView != null) {
                if (recyclerView == wVar.itemView) {
                    return;
                }
                java.lang.Object parent = recyclerView.getParent();
                recyclerView = parent instanceof android.view.View ? (android.view.View) parent : null;
            }
            wVar.mNestedRecyclerView = null;
        }
    }

    long getNanoTime() {
        if (ALLOW_THREAD_GAP_WORK) {
            return java.lang.System.nanoTime();
        }
        return 0L;
    }

    public final class p_renamed {
        androidx.recyclerview.widget.RecyclerView.o_renamed e_renamed;
        private androidx.recyclerview.widget.RecyclerView.u_renamed i_renamed;

        /* renamed from: a_renamed, reason: collision with root package name */
        final java.util.ArrayList<androidx.recyclerview.widget.RecyclerView.w_renamed> f1428a = new java.util.ArrayList<>();

        /* renamed from: b_renamed, reason: collision with root package name */
        java.util.ArrayList<androidx.recyclerview.widget.RecyclerView.w_renamed> f1429b = null;

        /* renamed from: c_renamed, reason: collision with root package name */
        final java.util.ArrayList<androidx.recyclerview.widget.RecyclerView.w_renamed> f1430c = new java.util.ArrayList<>();
        private final java.util.List<androidx.recyclerview.widget.RecyclerView.w_renamed> g_renamed = java.util.Collections.unmodifiableList(this.f1428a);
        private int h_renamed = 2;
        int d_renamed = 2;

        public p_renamed() {
        }

        public void a_renamed() {
            this.f1428a.clear();
            d_renamed();
        }

        public void a_renamed(int i_renamed) {
            this.h_renamed = i_renamed;
            b_renamed();
        }

        void b_renamed() {
            this.d_renamed = this.h_renamed + (androidx.recyclerview.widget.RecyclerView.this.mLayout != null ? androidx.recyclerview.widget.RecyclerView.this.mLayout.mPrefetchMaxCountObserved : 0);
            for (int size = this.f1430c.size() - 1; size >= 0 && this.f1430c.size() > this.d_renamed; size--) {
                d_renamed(size);
            }
        }

        public java.util.List<androidx.recyclerview.widget.RecyclerView.w_renamed> c_renamed() {
            return this.g_renamed;
        }

        boolean a_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
            if (wVar.isRemoved()) {
                return androidx.recyclerview.widget.RecyclerView.this.mState.a_renamed();
            }
            if (wVar.mPosition < 0 || wVar.mPosition >= androidx.recyclerview.widget.RecyclerView.this.mAdapter.getItemCount()) {
                throw new java.lang.IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + wVar + androidx.recyclerview.widget.RecyclerView.this.exceptionLabel());
            }
            if (androidx.recyclerview.widget.RecyclerView.this.mState.a_renamed() || androidx.recyclerview.widget.RecyclerView.this.mAdapter.getItemViewType(wVar.mPosition) == wVar.getItemViewType()) {
                return !androidx.recyclerview.widget.RecyclerView.this.mAdapter.hasStableIds() || wVar.getItemId() == androidx.recyclerview.widget.RecyclerView.this.mAdapter.getItemId(wVar.mPosition);
            }
            return false;
        }

        private boolean a_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar, int i_renamed, int i2, long j_renamed) {
            wVar.mBindingAdapter = null;
            wVar.mOwnerRecyclerView = androidx.recyclerview.widget.RecyclerView.this;
            int itemViewType = wVar.getItemViewType();
            long nanoTime = androidx.recyclerview.widget.RecyclerView.this.getNanoTime();
            if (j_renamed != Long.MAX_VALUE && !this.e_renamed.b_renamed(itemViewType, nanoTime, j_renamed)) {
                return false;
            }
            androidx.recyclerview.widget.RecyclerView.this.mAdapter.bindViewHolder(wVar, i_renamed);
            this.e_renamed.b_renamed(wVar.getItemViewType(), androidx.recyclerview.widget.RecyclerView.this.getNanoTime() - nanoTime);
            e_renamed(wVar);
            if (!androidx.recyclerview.widget.RecyclerView.this.mState.a_renamed()) {
                return true;
            }
            wVar.mPreLayoutPosition = i2;
            return true;
        }

        public int b_renamed(int i_renamed) {
            if (i_renamed >= 0 && i_renamed < androidx.recyclerview.widget.RecyclerView.this.mState.e_renamed()) {
                return !androidx.recyclerview.widget.RecyclerView.this.mState.a_renamed() ? i_renamed : androidx.recyclerview.widget.RecyclerView.this.mAdapterHelper.b_renamed(i_renamed);
            }
            throw new java.lang.IndexOutOfBoundsException("invalid position " + i_renamed + ". State item count is_renamed " + androidx.recyclerview.widget.RecyclerView.this.mState.e_renamed() + androidx.recyclerview.widget.RecyclerView.this.exceptionLabel());
        }

        public android.view.View c_renamed(int i_renamed) {
            return a_renamed(i_renamed, false);
        }

        android.view.View a_renamed(int i_renamed, boolean z_renamed) {
            return a_renamed(i_renamed, z_renamed, Long.MAX_VALUE).itemView;
        }

        /* JADX WARN: Removed duplicated region for block: B_renamed:105:0x022b A_renamed[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B_renamed:107:0x022e  */
        /* JADX WARN: Removed duplicated region for block: B_renamed:18:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B_renamed:27:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B_renamed:29:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B_renamed:72:0x0182 A_renamed[PHI: r1 r4
          0x0182: PHI (r1v12 androidx.recyclerview.widget.RecyclerView$w_renamed) = (r1v11 androidx.recyclerview.widget.RecyclerView$w_renamed), (r1v31 androidx.recyclerview.widget.RecyclerView$w_renamed) binds: [B_renamed:28:0x005d, B_renamed:58:0x0101] A_renamed[DONT_GENERATE, DONT_INLINE]
          0x0182: PHI (r4v3 boolean) = (r4v2 boolean), (r4v7 boolean) binds: [B_renamed:28:0x005d, B_renamed:58:0x0101] A_renamed[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B_renamed:81:0x01a3  */
        /* JADX WARN: Removed duplicated region for block: B_renamed:87:0x01d1  */
        /* JADX WARN: Removed duplicated region for block: B_renamed:98:0x0201  */
        /* JADX WARN: Removed duplicated region for block: B_renamed:99:0x020f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        androidx.recyclerview.widget.RecyclerView.w_renamed a_renamed(int r17, boolean r18, long r19) {
            /*
                Method dump skipped, instructions count: 618
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.p_renamed.a_renamed(int, boolean, long):androidx.recyclerview.widget.RecyclerView$w_renamed");
        }

        private void e_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
            if (androidx.recyclerview.widget.RecyclerView.this.isAccessibilityEnabled()) {
                android.view.View view = wVar.itemView;
                if (androidx.core.h_renamed.v_renamed.f_renamed(view) == 0) {
                    androidx.core.h_renamed.v_renamed.b_renamed(view, 1);
                }
                if (androidx.recyclerview.widget.RecyclerView.this.mAccessibilityDelegate == null) {
                    return;
                }
                androidx.core.h_renamed.a_renamed itemDelegate = androidx.recyclerview.widget.RecyclerView.this.mAccessibilityDelegate.getItemDelegate();
                if (itemDelegate instanceof androidx.recyclerview.widget.p_renamed.a_renamed) {
                    ((androidx.recyclerview.widget.p_renamed.a_renamed) itemDelegate).a_renamed(view);
                }
                androidx.core.h_renamed.v_renamed.a_renamed(view, itemDelegate);
            }
        }

        private void f_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
            if (wVar.itemView instanceof android.view.ViewGroup) {
                a_renamed((android.view.ViewGroup) wVar.itemView, false);
            }
        }

        private void a_renamed(android.view.ViewGroup viewGroup, boolean z_renamed) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                android.view.View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof android.view.ViewGroup) {
                    a_renamed((android.view.ViewGroup) childAt, true);
                }
            }
            if (z_renamed) {
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

        public void a_renamed(android.view.View view) {
            androidx.recyclerview.widget.RecyclerView.w_renamed childViewHolderInt = androidx.recyclerview.widget.RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isTmpDetached()) {
                androidx.recyclerview.widget.RecyclerView.this.removeDetachedView(view, false);
            }
            if (childViewHolderInt.isScrap()) {
                childViewHolderInt.unScrap();
            } else if (childViewHolderInt.wasReturnedFromScrap()) {
                childViewHolderInt.clearReturnedFromScrapFlag();
            }
            b_renamed(childViewHolderInt);
            if (androidx.recyclerview.widget.RecyclerView.this.mItemAnimator == null || childViewHolderInt.isRecyclable()) {
                return;
            }
            androidx.recyclerview.widget.RecyclerView.this.mItemAnimator.d_renamed(childViewHolderInt);
        }

        void d_renamed() {
            for (int size = this.f1430c.size() - 1; size >= 0; size--) {
                d_renamed(size);
            }
            this.f1430c.clear();
            if (androidx.recyclerview.widget.RecyclerView.ALLOW_THREAD_GAP_WORK) {
                androidx.recyclerview.widget.RecyclerView.this.mPrefetchRegistry.a_renamed();
            }
        }

        void d_renamed(int i_renamed) {
            a_renamed(this.f1430c.get(i_renamed), true);
            this.f1430c.remove(i_renamed);
        }

        void b_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
            boolean z_renamed;
            if (wVar.isScrap() || wVar.itemView.getParent() != null) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Scrapped or attached views may not be_renamed recycled. isScrap:");
                sb.append(wVar.isScrap());
                sb.append(" isAttached:");
                sb.append(wVar.itemView.getParent() != null);
                sb.append(androidx.recyclerview.widget.RecyclerView.this.exceptionLabel());
                throw new java.lang.IllegalArgumentException(sb.toString());
            }
            if (wVar.isTmpDetached()) {
                throw new java.lang.IllegalArgumentException("Tmp detached view should be_renamed removed from RecyclerView before it can be_renamed recycled: " + wVar + androidx.recyclerview.widget.RecyclerView.this.exceptionLabel());
            }
            if (wVar.shouldIgnore()) {
                throw new java.lang.IllegalArgumentException("Trying to recycle an_renamed ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + androidx.recyclerview.widget.RecyclerView.this.exceptionLabel());
            }
            boolean zDoesTransientStatePreventRecycling = wVar.doesTransientStatePreventRecycling();
            if ((androidx.recyclerview.widget.RecyclerView.this.mAdapter != null && zDoesTransientStatePreventRecycling && androidx.recyclerview.widget.RecyclerView.this.mAdapter.onFailedToRecycleView(wVar)) || wVar.isRecyclable()) {
                if (this.d_renamed <= 0 || wVar.hasAnyOfTheFlags(526)) {
                    z_renamed = false;
                } else {
                    int size = this.f1430c.size();
                    if (size >= this.d_renamed && size > 0) {
                        d_renamed(0);
                        size--;
                    }
                    if (androidx.recyclerview.widget.RecyclerView.ALLOW_THREAD_GAP_WORK && size > 0 && !androidx.recyclerview.widget.RecyclerView.this.mPrefetchRegistry.a_renamed(wVar.mPosition)) {
                        int i_renamed = size - 1;
                        while (i_renamed >= 0) {
                            if (!androidx.recyclerview.widget.RecyclerView.this.mPrefetchRegistry.a_renamed(this.f1430c.get(i_renamed).mPosition)) {
                                break;
                            } else {
                                i_renamed--;
                            }
                        }
                        size = i_renamed + 1;
                    }
                    this.f1430c.add(size, wVar);
                    z_renamed = true;
                }
                if (!z_renamed) {
                    a_renamed(wVar, true);
                    z_renamed = true;
                }
            } else {
                z_renamed = false;
            }
            androidx.recyclerview.widget.RecyclerView.this.mViewInfoStore.g_renamed(wVar);
            if (z_renamed || z_renamed || !zDoesTransientStatePreventRecycling) {
                return;
            }
            wVar.mBindingAdapter = null;
            wVar.mOwnerRecyclerView = null;
        }

        void a_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar, boolean z_renamed) {
            androidx.recyclerview.widget.RecyclerView.clearNestedRecyclerViewIfNotNested(wVar);
            android.view.View view = wVar.itemView;
            if (androidx.recyclerview.widget.RecyclerView.this.mAccessibilityDelegate != null) {
                androidx.core.h_renamed.a_renamed itemDelegate = androidx.recyclerview.widget.RecyclerView.this.mAccessibilityDelegate.getItemDelegate();
                androidx.core.h_renamed.v_renamed.a_renamed(view, itemDelegate instanceof androidx.recyclerview.widget.p_renamed.a_renamed ? ((androidx.recyclerview.widget.p_renamed.a_renamed) itemDelegate).b_renamed(view) : null);
            }
            if (z_renamed) {
                d_renamed(wVar);
            }
            wVar.mBindingAdapter = null;
            wVar.mOwnerRecyclerView = null;
            g_renamed().a_renamed(wVar);
        }

        void b_renamed(android.view.View view) {
            androidx.recyclerview.widget.RecyclerView.w_renamed childViewHolderInt = androidx.recyclerview.widget.RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.mScrapContainer = null;
            childViewHolderInt.mInChangeScrap = false;
            childViewHolderInt.clearReturnedFromScrapFlag();
            b_renamed(childViewHolderInt);
        }

        void c_renamed(android.view.View view) {
            androidx.recyclerview.widget.RecyclerView.w_renamed childViewHolderInt = androidx.recyclerview.widget.RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.hasAnyOfTheFlags(12) || !childViewHolderInt.isUpdated() || androidx.recyclerview.widget.RecyclerView.this.canReuseUpdatedViewHolder(childViewHolderInt)) {
                if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !androidx.recyclerview.widget.RecyclerView.this.mAdapter.hasStableIds()) {
                    throw new java.lang.IllegalArgumentException("Called scrap view with an_renamed invalid view. Invalid views cannot be_renamed reused from scrap, they should rebound from recycler pool." + androidx.recyclerview.widget.RecyclerView.this.exceptionLabel());
                }
                childViewHolderInt.setScrapContainer(this, false);
                this.f1428a.add(childViewHolderInt);
                return;
            }
            if (this.f1429b == null) {
                this.f1429b = new java.util.ArrayList<>();
            }
            childViewHolderInt.setScrapContainer(this, true);
            this.f1429b.add(childViewHolderInt);
        }

        void c_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
            if (wVar.mInChangeScrap) {
                this.f1429b.remove(wVar);
            } else {
                this.f1428a.remove(wVar);
            }
            wVar.mScrapContainer = null;
            wVar.mInChangeScrap = false;
            wVar.clearReturnedFromScrapFlag();
        }

        int e_renamed() {
            return this.f1428a.size();
        }

        android.view.View e_renamed(int i_renamed) {
            return this.f1428a.get(i_renamed).itemView;
        }

        void f_renamed() {
            this.f1428a.clear();
            java.util.ArrayList<androidx.recyclerview.widget.RecyclerView.w_renamed> arrayList = this.f1429b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        androidx.recyclerview.widget.RecyclerView.w_renamed f_renamed(int i_renamed) {
            int size;
            int iB;
            java.util.ArrayList<androidx.recyclerview.widget.RecyclerView.w_renamed> arrayList = this.f1429b;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    androidx.recyclerview.widget.RecyclerView.w_renamed wVar = this.f1429b.get(i2);
                    if (!wVar.wasReturnedFromScrap() && wVar.getLayoutPosition() == i_renamed) {
                        wVar.addFlags(32);
                        return wVar;
                    }
                }
                if (androidx.recyclerview.widget.RecyclerView.this.mAdapter.hasStableIds() && (iB = androidx.recyclerview.widget.RecyclerView.this.mAdapterHelper.b_renamed(i_renamed)) > 0 && iB < androidx.recyclerview.widget.RecyclerView.this.mAdapter.getItemCount()) {
                    long itemId = androidx.recyclerview.widget.RecyclerView.this.mAdapter.getItemId(iB);
                    for (int i3 = 0; i3 < size; i3++) {
                        androidx.recyclerview.widget.RecyclerView.w_renamed wVar2 = this.f1429b.get(i3);
                        if (!wVar2.wasReturnedFromScrap() && wVar2.getItemId() == itemId) {
                            wVar2.addFlags(32);
                            return wVar2;
                        }
                    }
                }
            }
            return null;
        }

        androidx.recyclerview.widget.RecyclerView.w_renamed b_renamed(int i_renamed, boolean z_renamed) {
            android.view.View viewC;
            int size = this.f1428a.size();
            for (int i2 = 0; i2 < size; i2++) {
                androidx.recyclerview.widget.RecyclerView.w_renamed wVar = this.f1428a.get(i2);
                if (!wVar.wasReturnedFromScrap() && wVar.getLayoutPosition() == i_renamed && !wVar.isInvalid() && (androidx.recyclerview.widget.RecyclerView.this.mState.g_renamed || !wVar.isRemoved())) {
                    wVar.addFlags(32);
                    return wVar;
                }
            }
            if (!z_renamed && (viewC = androidx.recyclerview.widget.RecyclerView.this.mChildHelper.c_renamed(i_renamed)) != null) {
                androidx.recyclerview.widget.RecyclerView.w_renamed childViewHolderInt = androidx.recyclerview.widget.RecyclerView.getChildViewHolderInt(viewC);
                androidx.recyclerview.widget.RecyclerView.this.mChildHelper.e_renamed(viewC);
                int iB = androidx.recyclerview.widget.RecyclerView.this.mChildHelper.b_renamed(viewC);
                if (iB == -1) {
                    throw new java.lang.IllegalStateException("layout index should not be_renamed -1 after unhiding a_renamed view:" + childViewHolderInt + androidx.recyclerview.widget.RecyclerView.this.exceptionLabel());
                }
                androidx.recyclerview.widget.RecyclerView.this.mChildHelper.e_renamed(iB);
                c_renamed(viewC);
                childViewHolderInt.addFlags(8224);
                return childViewHolderInt;
            }
            int size2 = this.f1430c.size();
            for (int i3 = 0; i3 < size2; i3++) {
                androidx.recyclerview.widget.RecyclerView.w_renamed wVar2 = this.f1430c.get(i3);
                if (!wVar2.isInvalid() && wVar2.getLayoutPosition() == i_renamed && !wVar2.isAttachedToTransitionOverlay()) {
                    if (!z_renamed) {
                        this.f1430c.remove(i3);
                    }
                    return wVar2;
                }
            }
            return null;
        }

        androidx.recyclerview.widget.RecyclerView.w_renamed a_renamed(long j_renamed, int i_renamed, boolean z_renamed) {
            for (int size = this.f1428a.size() - 1; size >= 0; size--) {
                androidx.recyclerview.widget.RecyclerView.w_renamed wVar = this.f1428a.get(size);
                if (wVar.getItemId() == j_renamed && !wVar.wasReturnedFromScrap()) {
                    if (i_renamed == wVar.getItemViewType()) {
                        wVar.addFlags(32);
                        if (wVar.isRemoved() && !androidx.recyclerview.widget.RecyclerView.this.mState.a_renamed()) {
                            wVar.setFlags(2, 14);
                        }
                        return wVar;
                    }
                    if (!z_renamed) {
                        this.f1428a.remove(size);
                        androidx.recyclerview.widget.RecyclerView.this.removeDetachedView(wVar.itemView, false);
                        b_renamed(wVar.itemView);
                    }
                }
            }
            int size2 = this.f1430c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                androidx.recyclerview.widget.RecyclerView.w_renamed wVar2 = this.f1430c.get(size2);
                if (wVar2.getItemId() == j_renamed && !wVar2.isAttachedToTransitionOverlay()) {
                    if (i_renamed == wVar2.getItemViewType()) {
                        if (!z_renamed) {
                            this.f1430c.remove(size2);
                        }
                        return wVar2;
                    }
                    if (!z_renamed) {
                        d_renamed(size2);
                        return null;
                    }
                }
            }
        }

        void d_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
            if (androidx.recyclerview.widget.RecyclerView.this.mRecyclerListener != null) {
                androidx.recyclerview.widget.RecyclerView.this.mRecyclerListener.a_renamed(wVar);
            }
            if (androidx.recyclerview.widget.RecyclerView.this.mAdapter != null) {
                androidx.recyclerview.widget.RecyclerView.this.mAdapter.onViewRecycled(wVar);
            }
            if (androidx.recyclerview.widget.RecyclerView.this.mState != null) {
                androidx.recyclerview.widget.RecyclerView.this.mViewInfoStore.g_renamed(wVar);
            }
        }

        void a_renamed(androidx.recyclerview.widget.RecyclerView.a_renamed aVar, androidx.recyclerview.widget.RecyclerView.a_renamed aVar2, boolean z_renamed) {
            a_renamed();
            g_renamed().a_renamed(aVar, aVar2, z_renamed);
        }

        void a_renamed(int i_renamed, int i2) {
            int i3;
            int i4;
            int i5;
            if (i_renamed < i2) {
                i3 = i2;
                i4 = -1;
                i5 = i_renamed;
            } else {
                i3 = i_renamed;
                i4 = 1;
                i5 = i2;
            }
            int size = this.f1430c.size();
            for (int i6 = 0; i6 < size; i6++) {
                androidx.recyclerview.widget.RecyclerView.w_renamed wVar = this.f1430c.get(i6);
                if (wVar != null && wVar.mPosition >= i5 && wVar.mPosition <= i3) {
                    if (wVar.mPosition == i_renamed) {
                        wVar.offsetPosition(i2 - i_renamed, false);
                    } else {
                        wVar.offsetPosition(i4, false);
                    }
                }
            }
        }

        void b_renamed(int i_renamed, int i2) {
            int size = this.f1430c.size();
            for (int i3 = 0; i3 < size; i3++) {
                androidx.recyclerview.widget.RecyclerView.w_renamed wVar = this.f1430c.get(i3);
                if (wVar != null && wVar.mPosition >= i_renamed) {
                    wVar.offsetPosition(i2, true);
                }
            }
        }

        void a_renamed(int i_renamed, int i2, boolean z_renamed) {
            int i3 = i_renamed + i2;
            for (int size = this.f1430c.size() - 1; size >= 0; size--) {
                androidx.recyclerview.widget.RecyclerView.w_renamed wVar = this.f1430c.get(size);
                if (wVar != null) {
                    if (wVar.mPosition >= i3) {
                        wVar.offsetPosition(-i2, z_renamed);
                    } else if (wVar.mPosition >= i_renamed) {
                        wVar.addFlags(8);
                        d_renamed(size);
                    }
                }
            }
        }

        void a_renamed(androidx.recyclerview.widget.RecyclerView.u_renamed uVar) {
            this.i_renamed = uVar;
        }

        void a_renamed(androidx.recyclerview.widget.RecyclerView.o_renamed oVar) {
            androidx.recyclerview.widget.RecyclerView.o_renamed oVar2 = this.e_renamed;
            if (oVar2 != null) {
                oVar2.c_renamed();
            }
            this.e_renamed = oVar;
            if (this.e_renamed == null || androidx.recyclerview.widget.RecyclerView.this.getAdapter() == null) {
                return;
            }
            this.e_renamed.b_renamed();
        }

        androidx.recyclerview.widget.RecyclerView.o_renamed g_renamed() {
            if (this.e_renamed == null) {
                this.e_renamed = new androidx.recyclerview.widget.RecyclerView.o_renamed();
            }
            return this.e_renamed;
        }

        void c_renamed(int i_renamed, int i2) {
            int i3;
            int i4 = i2 + i_renamed;
            for (int size = this.f1430c.size() - 1; size >= 0; size--) {
                androidx.recyclerview.widget.RecyclerView.w_renamed wVar = this.f1430c.get(size);
                if (wVar != null && (i3 = wVar.mPosition) >= i_renamed && i3 < i4) {
                    wVar.addFlags(2);
                    d_renamed(size);
                }
            }
        }

        void h_renamed() {
            int size = this.f1430c.size();
            for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                androidx.recyclerview.widget.RecyclerView.w_renamed wVar = this.f1430c.get(i_renamed);
                if (wVar != null) {
                    wVar.addFlags(6);
                    wVar.addChangePayload(null);
                }
            }
            if (androidx.recyclerview.widget.RecyclerView.this.mAdapter == null || !androidx.recyclerview.widget.RecyclerView.this.mAdapter.hasStableIds()) {
                d_renamed();
            }
        }

        void i_renamed() {
            int size = this.f1430c.size();
            for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                this.f1430c.get(i_renamed).clearOldPosition();
            }
            int size2 = this.f1428a.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.f1428a.get(i2).clearOldPosition();
            }
            java.util.ArrayList<androidx.recyclerview.widget.RecyclerView.w_renamed> arrayList = this.f1429b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    this.f1429b.get(i3).clearOldPosition();
                }
            }
        }

        void j_renamed() {
            int size = this.f1430c.size();
            for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                androidx.recyclerview.widget.RecyclerView.j_renamed jVar = (androidx.recyclerview.widget.RecyclerView.j_renamed) this.f1430c.get(i_renamed).itemView.getLayoutParams();
                if (jVar != null) {
                    jVar.e_renamed = true;
                }
            }
        }
    }

    public static abstract class a_renamed<VH extends androidx.recyclerview.widget.RecyclerView.w_renamed> {
        private final androidx.recyclerview.widget.RecyclerView.b_renamed mObservable = new androidx.recyclerview.widget.RecyclerView.b_renamed();
        private boolean mHasStableIds = false;
        private androidx.recyclerview.widget.RecyclerView.a_renamed.EnumC0036a mStateRestorationPolicy = androidx.recyclerview.widget.RecyclerView.a_renamed.EnumC0036a.ALLOW;

        /* renamed from: androidx.recyclerview.widget.RecyclerView$a_renamed$a_renamed, reason: collision with other inner class name */
        public enum EnumC0036a {
            ALLOW,
            PREVENT_WHEN_EMPTY,
            PREVENT
        }

        public int findRelativeAdapterPositionIn(androidx.recyclerview.widget.RecyclerView.a_renamed<? extends androidx.recyclerview.widget.RecyclerView.w_renamed> aVar, androidx.recyclerview.widget.RecyclerView.w_renamed wVar, int i_renamed) {
            if (aVar == this) {
                return i_renamed;
            }
            return -1;
        }

        public abstract int getItemCount();

        public long getItemId(int i_renamed) {
            return -1L;
        }

        public int getItemViewType(int i_renamed) {
            return 0;
        }

        public void onAttachedToRecyclerView(androidx.recyclerview.widget.RecyclerView recyclerView) {
        }

        public abstract void onBindViewHolder(VH vh, int i_renamed);

        public abstract VH onCreateViewHolder(android.view.ViewGroup viewGroup, int i_renamed);

        public void onDetachedFromRecyclerView(androidx.recyclerview.widget.RecyclerView recyclerView) {
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

        public void onBindViewHolder(VH vh, int i_renamed, java.util.List<java.lang.Object> list) {
            onBindViewHolder(vh, i_renamed);
        }

        public final VH createViewHolder(android.view.ViewGroup viewGroup, int i_renamed) {
            try {
                androidx.core.d_renamed.a_renamed.a_renamed(androidx.recyclerview.widget.RecyclerView.TRACE_CREATE_VIEW_TAG);
                VH vh = (VH) onCreateViewHolder(viewGroup, i_renamed);
                if (vh.itemView.getParent() != null) {
                    throw new java.lang.IllegalStateException("ViewHolder views must not be_renamed attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of_renamed LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                vh.mItemViewType = i_renamed;
                return vh;
            } finally {
                androidx.core.d_renamed.a_renamed.a_renamed();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void bindViewHolder(VH vh, int i_renamed) {
            boolean z_renamed = vh.mBindingAdapter == null;
            if (z_renamed) {
                vh.mPosition = i_renamed;
                if (hasStableIds()) {
                    vh.mItemId = getItemId(i_renamed);
                }
                vh.setFlags(1, 519);
                androidx.core.d_renamed.a_renamed.a_renamed(androidx.recyclerview.widget.RecyclerView.TRACE_BIND_VIEW_TAG);
            }
            vh.mBindingAdapter = this;
            onBindViewHolder(vh, i_renamed, vh.getUnmodifiedPayloads());
            if (z_renamed) {
                vh.clearPayload();
                android.view.ViewGroup.LayoutParams layoutParams = vh.itemView.getLayoutParams();
                if (layoutParams instanceof androidx.recyclerview.widget.RecyclerView.j_renamed) {
                    ((androidx.recyclerview.widget.RecyclerView.j_renamed) layoutParams).e_renamed = true;
                }
                androidx.core.d_renamed.a_renamed.a_renamed();
            }
        }

        public void setHasStableIds(boolean z_renamed) {
            if (hasObservers()) {
                throw new java.lang.IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.mHasStableIds = z_renamed;
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final boolean hasObservers() {
            return this.mObservable.a_renamed();
        }

        public void registerAdapterDataObserver(androidx.recyclerview.widget.RecyclerView.c_renamed cVar) {
            this.mObservable.registerObserver(cVar);
        }

        public void unregisterAdapterDataObserver(androidx.recyclerview.widget.RecyclerView.c_renamed cVar) {
            this.mObservable.unregisterObserver(cVar);
        }

        public final void notifyDataSetChanged() {
            this.mObservable.b_renamed();
        }

        public final void notifyItemChanged(int i_renamed) {
            this.mObservable.a_renamed(i_renamed, 1);
        }

        public final void notifyItemChanged(int i_renamed, java.lang.Object obj) {
            this.mObservable.a_renamed(i_renamed, 1, obj);
        }

        public final void notifyItemRangeChanged(int i_renamed, int i2) {
            this.mObservable.a_renamed(i_renamed, i2);
        }

        public final void notifyItemRangeChanged(int i_renamed, int i2, java.lang.Object obj) {
            this.mObservable.a_renamed(i_renamed, i2, obj);
        }

        public final void notifyItemInserted(int i_renamed) {
            this.mObservable.b_renamed(i_renamed, 1);
        }

        public final void notifyItemMoved(int i_renamed, int i2) {
            this.mObservable.d_renamed(i_renamed, i2);
        }

        public final void notifyItemRangeInserted(int i_renamed, int i2) {
            this.mObservable.b_renamed(i_renamed, i2);
        }

        public final void notifyItemRemoved(int i_renamed) {
            this.mObservable.c_renamed(i_renamed, 1);
        }

        public final void notifyItemRangeRemoved(int i_renamed, int i2) {
            this.mObservable.c_renamed(i_renamed, i2);
        }

        public void setStateRestorationPolicy(androidx.recyclerview.widget.RecyclerView.a_renamed.EnumC0036a enumC0036a) {
            this.mStateRestorationPolicy = enumC0036a;
            this.mObservable.c_renamed();
        }

        public final androidx.recyclerview.widget.RecyclerView.a_renamed.EnumC0036a getStateRestorationPolicy() {
            return this.mStateRestorationPolicy;
        }

        boolean canRestoreState() {
            int i_renamed = androidx.recyclerview.widget.RecyclerView.AnonymousClass7.f1409a[this.mStateRestorationPolicy.ordinal()];
            if (i_renamed != 1) {
                return i_renamed != 2 || getItemCount() > 0;
            }
            return false;
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$7, reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {

        /* renamed from: a_renamed, reason: collision with root package name */
        static final /* synthetic */ int[] f1409a = new int[androidx.recyclerview.widget.RecyclerView.a_renamed.EnumC0036a.values().length];

        static {
            try {
                f1409a[androidx.recyclerview.widget.RecyclerView.a_renamed.EnumC0036a.PREVENT.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                f1409a[androidx.recyclerview.widget.RecyclerView.a_renamed.EnumC0036a.PREVENT_WHEN_EMPTY.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
        }
    }

    void dispatchChildDetached(android.view.View view) {
        androidx.recyclerview.widget.RecyclerView.w_renamed childViewHolderInt = getChildViewHolderInt(view);
        onChildDetachedFromWindow(view);
        androidx.recyclerview.widget.RecyclerView.a_renamed aVar = this.mAdapter;
        if (aVar != null && childViewHolderInt != null) {
            aVar.onViewDetachedFromWindow(childViewHolderInt);
        }
        java.util.List<androidx.recyclerview.widget.RecyclerView.k_renamed> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).b_renamed(view);
            }
        }
    }

    void dispatchChildAttached(android.view.View view) {
        androidx.recyclerview.widget.RecyclerView.w_renamed childViewHolderInt = getChildViewHolderInt(view);
        onChildAttachedToWindow(view);
        androidx.recyclerview.widget.RecyclerView.a_renamed aVar = this.mAdapter;
        if (aVar != null && childViewHolderInt != null) {
            aVar.onViewAttachedToWindow(childViewHolderInt);
        }
        java.util.List<androidx.recyclerview.widget.RecyclerView.k_renamed> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).a_renamed(view);
            }
        }
    }

    public static abstract class i_renamed {
        androidx.recyclerview.widget.d_renamed mChildHelper;
        private int mHeight;
        private int mHeightMode;
        int mPrefetchMaxCountObserved;
        boolean mPrefetchMaxObservedInInitialPrefetch;
        androidx.recyclerview.widget.RecyclerView mRecyclerView;
        androidx.recyclerview.widget.RecyclerView.s_renamed mSmoothScroller;
        private int mWidth;
        private int mWidthMode;
        private final androidx.recyclerview.widget.t_renamed.b_renamed mHorizontalBoundCheckCallback = new androidx.recyclerview.widget.t_renamed.b_renamed() { // from class: androidx.recyclerview.widget.RecyclerView.i_renamed.1
            @Override // androidx.recyclerview.widget.t_renamed.b_renamed
            public android.view.View a_renamed(int i_renamed) {
                return androidx.recyclerview.widget.RecyclerView.i_renamed.this.getChildAt(i_renamed);
            }

            @Override // androidx.recyclerview.widget.t_renamed.b_renamed
            public int a_renamed() {
                return androidx.recyclerview.widget.RecyclerView.i_renamed.this.getPaddingLeft();
            }

            @Override // androidx.recyclerview.widget.t_renamed.b_renamed
            public int b_renamed() {
                return androidx.recyclerview.widget.RecyclerView.i_renamed.this.getWidth() - androidx.recyclerview.widget.RecyclerView.i_renamed.this.getPaddingRight();
            }

            @Override // androidx.recyclerview.widget.t_renamed.b_renamed
            public int a_renamed(android.view.View view) {
                return androidx.recyclerview.widget.RecyclerView.i_renamed.this.getDecoratedLeft(view) - ((androidx.recyclerview.widget.RecyclerView.j_renamed) view.getLayoutParams()).leftMargin;
            }

            @Override // androidx.recyclerview.widget.t_renamed.b_renamed
            public int b_renamed(android.view.View view) {
                return androidx.recyclerview.widget.RecyclerView.i_renamed.this.getDecoratedRight(view) + ((androidx.recyclerview.widget.RecyclerView.j_renamed) view.getLayoutParams()).rightMargin;
            }
        };
        private final androidx.recyclerview.widget.t_renamed.b_renamed mVerticalBoundCheckCallback = new androidx.recyclerview.widget.t_renamed.b_renamed() { // from class: androidx.recyclerview.widget.RecyclerView.i_renamed.2
            @Override // androidx.recyclerview.widget.t_renamed.b_renamed
            public android.view.View a_renamed(int i_renamed) {
                return androidx.recyclerview.widget.RecyclerView.i_renamed.this.getChildAt(i_renamed);
            }

            @Override // androidx.recyclerview.widget.t_renamed.b_renamed
            public int a_renamed() {
                return androidx.recyclerview.widget.RecyclerView.i_renamed.this.getPaddingTop();
            }

            @Override // androidx.recyclerview.widget.t_renamed.b_renamed
            public int b_renamed() {
                return androidx.recyclerview.widget.RecyclerView.i_renamed.this.getHeight() - androidx.recyclerview.widget.RecyclerView.i_renamed.this.getPaddingBottom();
            }

            @Override // androidx.recyclerview.widget.t_renamed.b_renamed
            public int a_renamed(android.view.View view) {
                return androidx.recyclerview.widget.RecyclerView.i_renamed.this.getDecoratedTop(view) - ((androidx.recyclerview.widget.RecyclerView.j_renamed) view.getLayoutParams()).topMargin;
            }

            @Override // androidx.recyclerview.widget.t_renamed.b_renamed
            public int b_renamed(android.view.View view) {
                return androidx.recyclerview.widget.RecyclerView.i_renamed.this.getDecoratedBottom(view) + ((androidx.recyclerview.widget.RecyclerView.j_renamed) view.getLayoutParams()).bottomMargin;
            }
        };
        androidx.recyclerview.widget.t_renamed mHorizontalBoundCheck = new androidx.recyclerview.widget.t_renamed(this.mHorizontalBoundCheckCallback);
        androidx.recyclerview.widget.t_renamed mVerticalBoundCheck = new androidx.recyclerview.widget.t_renamed(this.mVerticalBoundCheckCallback);
        boolean mRequestedSimpleAnimations = false;
        boolean mIsAttachedToWindow = false;
        boolean mAutoMeasure = false;
        private boolean mMeasurementCacheEnabled = true;
        private boolean mItemPrefetchEnabled = true;

        public interface a_renamed {
            void b_renamed(int i_renamed, int i2);
        }

        public static class b_renamed {

            /* renamed from: a_renamed, reason: collision with root package name */
            public int f1419a;

            /* renamed from: b_renamed, reason: collision with root package name */
            public int f1420b;

            /* renamed from: c_renamed, reason: collision with root package name */
            public boolean f1421c;
            public boolean d_renamed;
        }

        public boolean canScrollHorizontally() {
            return false;
        }

        public boolean canScrollVertically() {
            return false;
        }

        public boolean checkLayoutParams(androidx.recyclerview.widget.RecyclerView.j_renamed jVar) {
            return jVar != null;
        }

        public void collectAdjacentPrefetchPositions(int i_renamed, int i2, androidx.recyclerview.widget.RecyclerView.t_renamed tVar, androidx.recyclerview.widget.RecyclerView.i_renamed.a_renamed aVar) {
        }

        public void collectInitialPrefetchPositions(int i_renamed, androidx.recyclerview.widget.RecyclerView.i_renamed.a_renamed aVar) {
        }

        public int computeHorizontalScrollExtent(androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
            return 0;
        }

        public int computeHorizontalScrollOffset(androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
            return 0;
        }

        public int computeHorizontalScrollRange(androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
            return 0;
        }

        public int computeVerticalScrollExtent(androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
            return 0;
        }

        public int computeVerticalScrollOffset(androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
            return 0;
        }

        public int computeVerticalScrollRange(androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
            return 0;
        }

        public abstract androidx.recyclerview.widget.RecyclerView.j_renamed generateDefaultLayoutParams();

        public int getBaseline() {
            return -1;
        }

        public int getColumnCountForAccessibility(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
            return -1;
        }

        public int getRowCountForAccessibility(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
            return -1;
        }

        public int getSelectionModeForAccessibility(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
            return 0;
        }

        public boolean isLayoutHierarchical(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
            return false;
        }

        public void onAdapterChanged(androidx.recyclerview.widget.RecyclerView.a_renamed aVar, androidx.recyclerview.widget.RecyclerView.a_renamed aVar2) {
        }

        public boolean onAddFocusables(androidx.recyclerview.widget.RecyclerView recyclerView, java.util.ArrayList<android.view.View> arrayList, int i_renamed, int i2) {
            return false;
        }

        public void onAttachedToWindow(androidx.recyclerview.widget.RecyclerView recyclerView) {
        }

        @java.lang.Deprecated
        public void onDetachedFromWindow(androidx.recyclerview.widget.RecyclerView recyclerView) {
        }

        public android.view.View onFocusSearchFailed(android.view.View view, int i_renamed, androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
            return null;
        }

        public void onInitializeAccessibilityNodeInfoForItem(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar, android.view.View view, androidx.core.h_renamed.a_renamed.d_renamed dVar) {
        }

        public android.view.View onInterceptFocusSearch(android.view.View view, int i_renamed) {
            return null;
        }

        public void onItemsAdded(androidx.recyclerview.widget.RecyclerView recyclerView, int i_renamed, int i2) {
        }

        public void onItemsChanged(androidx.recyclerview.widget.RecyclerView recyclerView) {
        }

        public void onItemsMoved(androidx.recyclerview.widget.RecyclerView recyclerView, int i_renamed, int i2, int i3) {
        }

        public void onItemsRemoved(androidx.recyclerview.widget.RecyclerView recyclerView, int i_renamed, int i2) {
        }

        public void onItemsUpdated(androidx.recyclerview.widget.RecyclerView recyclerView, int i_renamed, int i2) {
        }

        public void onLayoutCompleted(androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        }

        public void onRestoreInstanceState(android.os.Parcelable parcelable) {
        }

        public android.os.Parcelable onSaveInstanceState() {
            return null;
        }

        public void onScrollStateChanged(int i_renamed) {
        }

        public boolean performAccessibilityActionForItem(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar, android.view.View view, int i_renamed, android.os.Bundle bundle) {
            return false;
        }

        public int scrollHorizontallyBy(int i_renamed, androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
            return 0;
        }

        public void scrollToPosition(int i_renamed) {
        }

        public int scrollVerticallyBy(int i_renamed, androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
            return 0;
        }

        boolean shouldMeasureTwice() {
            return false;
        }

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }

        void setRecyclerView(androidx.recyclerview.widget.RecyclerView recyclerView) {
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

        void setMeasureSpecs(int i_renamed, int i2) {
            this.mWidth = android.view.View.MeasureSpec.getSize(i_renamed);
            this.mWidthMode = android.view.View.MeasureSpec.getMode(i_renamed);
            if (this.mWidthMode == 0 && !androidx.recyclerview.widget.RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.mWidth = 0;
            }
            this.mHeight = android.view.View.MeasureSpec.getSize(i2);
            this.mHeightMode = android.view.View.MeasureSpec.getMode(i2);
            if (this.mHeightMode != 0 || androidx.recyclerview.widget.RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                return;
            }
            this.mHeight = 0;
        }

        void setMeasuredDimensionFromChildren(int i_renamed, int i2) {
            int childCount = getChildCount();
            if (childCount == 0) {
                this.mRecyclerView.defaultOnMeasure(i_renamed, i2);
                return;
            }
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MIN_VALUE;
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MAX_VALUE;
            for (int i7 = 0; i7 < childCount; i7++) {
                android.view.View childAt = getChildAt(i7);
                android.graphics.Rect rect = this.mRecyclerView.mTempRect;
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
            setMeasuredDimension(this.mRecyclerView.mTempRect, i_renamed, i2);
        }

        public void setMeasuredDimension(android.graphics.Rect rect, int i_renamed, int i2) {
            setMeasuredDimension(chooseSize(i_renamed, rect.width() + getPaddingLeft() + getPaddingRight(), getMinimumWidth()), chooseSize(i2, rect.height() + getPaddingTop() + getPaddingBottom(), getMinimumHeight()));
        }

        public void requestLayout() {
            androidx.recyclerview.widget.RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public void assertInLayoutOrScroll(java.lang.String str) {
            androidx.recyclerview.widget.RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertInLayoutOrScroll(str);
            }
        }

        public static int chooseSize(int i_renamed, int i2, int i3) {
            int mode = android.view.View.MeasureSpec.getMode(i_renamed);
            int size = android.view.View.MeasureSpec.getSize(i_renamed);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? java.lang.Math.max(i2, i3) : size;
            }
            return java.lang.Math.min(size, java.lang.Math.max(i2, i3));
        }

        public void assertNotInLayoutOrScroll(java.lang.String str) {
            androidx.recyclerview.widget.RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertNotInLayoutOrScroll(str);
            }
        }

        @java.lang.Deprecated
        public void setAutoMeasureEnabled(boolean z_renamed) {
            this.mAutoMeasure = z_renamed;
        }

        public boolean isAutoMeasureEnabled() {
            return this.mAutoMeasure;
        }

        public final void setItemPrefetchEnabled(boolean z_renamed) {
            if (z_renamed != this.mItemPrefetchEnabled) {
                this.mItemPrefetchEnabled = z_renamed;
                this.mPrefetchMaxCountObserved = 0;
                androidx.recyclerview.widget.RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView != null) {
                    recyclerView.mRecycler.b_renamed();
                }
            }
        }

        public final boolean isItemPrefetchEnabled() {
            return this.mItemPrefetchEnabled;
        }

        void dispatchAttachedToWindow(androidx.recyclerview.widget.RecyclerView recyclerView) {
            this.mIsAttachedToWindow = true;
            onAttachedToWindow(recyclerView);
        }

        void dispatchDetachedFromWindow(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.p_renamed pVar) {
            this.mIsAttachedToWindow = false;
            onDetachedFromWindow(recyclerView, pVar);
        }

        public boolean isAttachedToWindow() {
            return this.mIsAttachedToWindow;
        }

        public void postOnAnimation(java.lang.Runnable runnable) {
            androidx.recyclerview.widget.RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                androidx.core.h_renamed.v_renamed.a_renamed(recyclerView, runnable);
            }
        }

        public boolean removeCallbacks(java.lang.Runnable runnable) {
            androidx.recyclerview.widget.RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void onDetachedFromWindow(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.p_renamed pVar) {
            onDetachedFromWindow(recyclerView);
        }

        public boolean getClipToPadding() {
            androidx.recyclerview.widget.RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.mClipToPadding;
        }

        public void onLayoutChildren(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
            android.util.Log.e_renamed(androidx.recyclerview.widget.RecyclerView.TAG, "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public androidx.recyclerview.widget.RecyclerView.j_renamed generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof androidx.recyclerview.widget.RecyclerView.j_renamed) {
                return new androidx.recyclerview.widget.RecyclerView.j_renamed((androidx.recyclerview.widget.RecyclerView.j_renamed) layoutParams);
            }
            if (layoutParams instanceof android.view.ViewGroup.MarginLayoutParams) {
                return new androidx.recyclerview.widget.RecyclerView.j_renamed((android.view.ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new androidx.recyclerview.widget.RecyclerView.j_renamed(layoutParams);
        }

        public androidx.recyclerview.widget.RecyclerView.j_renamed generateLayoutParams(android.content.Context context, android.util.AttributeSet attributeSet) {
            return new androidx.recyclerview.widget.RecyclerView.j_renamed(context, attributeSet);
        }

        public void smoothScrollToPosition(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.t_renamed tVar, int i_renamed) {
            android.util.Log.e_renamed(androidx.recyclerview.widget.RecyclerView.TAG, "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void startSmoothScroll(androidx.recyclerview.widget.RecyclerView.s_renamed sVar) {
            androidx.recyclerview.widget.RecyclerView.s_renamed sVar2 = this.mSmoothScroller;
            if (sVar2 != null && sVar != sVar2 && sVar2.isRunning()) {
                this.mSmoothScroller.stop();
            }
            this.mSmoothScroller = sVar;
            this.mSmoothScroller.start(this.mRecyclerView, this);
        }

        public boolean isSmoothScrolling() {
            androidx.recyclerview.widget.RecyclerView.s_renamed sVar = this.mSmoothScroller;
            return sVar != null && sVar.isRunning();
        }

        public int getLayoutDirection() {
            return androidx.core.h_renamed.v_renamed.g_renamed(this.mRecyclerView);
        }

        public void endAnimation(android.view.View view) {
            if (this.mRecyclerView.mItemAnimator != null) {
                this.mRecyclerView.mItemAnimator.d_renamed(androidx.recyclerview.widget.RecyclerView.getChildViewHolderInt(view));
            }
        }

        public void addDisappearingView(android.view.View view) {
            addDisappearingView(view, -1);
        }

        public void addDisappearingView(android.view.View view, int i_renamed) {
            addViewInt(view, i_renamed, true);
        }

        public void addView(android.view.View view) {
            addView(view, -1);
        }

        public void addView(android.view.View view, int i_renamed) {
            addViewInt(view, i_renamed, false);
        }

        private void addViewInt(android.view.View view, int i_renamed, boolean z_renamed) {
            androidx.recyclerview.widget.RecyclerView.w_renamed childViewHolderInt = androidx.recyclerview.widget.RecyclerView.getChildViewHolderInt(view);
            if (z_renamed || childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.e_renamed(childViewHolderInt);
            } else {
                this.mRecyclerView.mViewInfoStore.f_renamed(childViewHolderInt);
            }
            androidx.recyclerview.widget.RecyclerView.j_renamed jVar = (androidx.recyclerview.widget.RecyclerView.j_renamed) view.getLayoutParams();
            if (childViewHolderInt.wasReturnedFromScrap() || childViewHolderInt.isScrap()) {
                if (childViewHolderInt.isScrap()) {
                    childViewHolderInt.unScrap();
                } else {
                    childViewHolderInt.clearReturnedFromScrapFlag();
                }
                this.mChildHelper.a_renamed(view, i_renamed, view.getLayoutParams(), false);
            } else if (view.getParent() == this.mRecyclerView) {
                int iB = this.mChildHelper.b_renamed(view);
                if (i_renamed == -1) {
                    i_renamed = this.mChildHelper.b_renamed();
                }
                if (iB == -1) {
                    throw new java.lang.IllegalStateException("Added View has RecyclerView as_renamed parent but view is_renamed not a_renamed real child. Unfiltered index:" + this.mRecyclerView.indexOfChild(view) + this.mRecyclerView.exceptionLabel());
                }
                if (iB != i_renamed) {
                    this.mRecyclerView.mLayout.moveView(iB, i_renamed);
                }
            } else {
                this.mChildHelper.a_renamed(view, i_renamed, false);
                jVar.e_renamed = true;
                androidx.recyclerview.widget.RecyclerView.s_renamed sVar = this.mSmoothScroller;
                if (sVar != null && sVar.isRunning()) {
                    this.mSmoothScroller.onChildAttachedToWindow(view);
                }
            }
            if (jVar.f_renamed) {
                childViewHolderInt.itemView.invalidate();
                jVar.f_renamed = false;
            }
        }

        public void removeView(android.view.View view) {
            this.mChildHelper.a_renamed(view);
        }

        public void removeViewAt(int i_renamed) {
            if (getChildAt(i_renamed) != null) {
                this.mChildHelper.a_renamed(i_renamed);
            }
        }

        public void removeAllViews() {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                this.mChildHelper.a_renamed(childCount);
            }
        }

        public int getPosition(android.view.View view) {
            return ((androidx.recyclerview.widget.RecyclerView.j_renamed) view.getLayoutParams()).f_renamed();
        }

        public int getItemViewType(android.view.View view) {
            return androidx.recyclerview.widget.RecyclerView.getChildViewHolderInt(view).getItemViewType();
        }

        public android.view.View findContainingItemView(android.view.View view) {
            android.view.View viewFindContainingItemView;
            androidx.recyclerview.widget.RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (viewFindContainingItemView = recyclerView.findContainingItemView(view)) == null || this.mChildHelper.c_renamed(viewFindContainingItemView)) {
                return null;
            }
            return viewFindContainingItemView;
        }

        public android.view.View findViewByPosition(int i_renamed) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                android.view.View childAt = getChildAt(i2);
                androidx.recyclerview.widget.RecyclerView.w_renamed childViewHolderInt = androidx.recyclerview.widget.RecyclerView.getChildViewHolderInt(childAt);
                if (childViewHolderInt != null && childViewHolderInt.getLayoutPosition() == i_renamed && !childViewHolderInt.shouldIgnore() && (this.mRecyclerView.mState.a_renamed() || !childViewHolderInt.isRemoved())) {
                    return childAt;
                }
            }
            return null;
        }

        public void detachView(android.view.View view) {
            int iB = this.mChildHelper.b_renamed(view);
            if (iB >= 0) {
                detachViewInternal(iB, view);
            }
        }

        public void detachViewAt(int i_renamed) {
            detachViewInternal(i_renamed, getChildAt(i_renamed));
        }

        private void detachViewInternal(int i_renamed, android.view.View view) {
            this.mChildHelper.e_renamed(i_renamed);
        }

        public void attachView(android.view.View view, int i_renamed, androidx.recyclerview.widget.RecyclerView.j_renamed jVar) {
            androidx.recyclerview.widget.RecyclerView.w_renamed childViewHolderInt = androidx.recyclerview.widget.RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.e_renamed(childViewHolderInt);
            } else {
                this.mRecyclerView.mViewInfoStore.f_renamed(childViewHolderInt);
            }
            this.mChildHelper.a_renamed(view, i_renamed, jVar, childViewHolderInt.isRemoved());
        }

        public void attachView(android.view.View view, int i_renamed) {
            attachView(view, i_renamed, (androidx.recyclerview.widget.RecyclerView.j_renamed) view.getLayoutParams());
        }

        public void attachView(android.view.View view) {
            attachView(view, -1);
        }

        public void removeDetachedView(android.view.View view) {
            this.mRecyclerView.removeDetachedView(view, false);
        }

        public void moveView(int i_renamed, int i2) {
            android.view.View childAt = getChildAt(i_renamed);
            if (childAt == null) {
                throw new java.lang.IllegalArgumentException("Cannot move a_renamed child from non-existing index:" + i_renamed + this.mRecyclerView.toString());
            }
            detachViewAt(i_renamed);
            attachView(childAt, i2);
        }

        public void detachAndScrapView(android.view.View view, androidx.recyclerview.widget.RecyclerView.p_renamed pVar) {
            scrapOrRecycleView(pVar, this.mChildHelper.b_renamed(view), view);
        }

        public void detachAndScrapViewAt(int i_renamed, androidx.recyclerview.widget.RecyclerView.p_renamed pVar) {
            scrapOrRecycleView(pVar, i_renamed, getChildAt(i_renamed));
        }

        public void removeAndRecycleView(android.view.View view, androidx.recyclerview.widget.RecyclerView.p_renamed pVar) {
            removeView(view);
            pVar.a_renamed(view);
        }

        public void removeAndRecycleViewAt(int i_renamed, androidx.recyclerview.widget.RecyclerView.p_renamed pVar) {
            android.view.View childAt = getChildAt(i_renamed);
            removeViewAt(i_renamed);
            pVar.a_renamed(childAt);
        }

        public int getChildCount() {
            androidx.recyclerview.widget.d_renamed dVar = this.mChildHelper;
            if (dVar != null) {
                return dVar.b_renamed();
            }
            return 0;
        }

        public android.view.View getChildAt(int i_renamed) {
            androidx.recyclerview.widget.d_renamed dVar = this.mChildHelper;
            if (dVar != null) {
                return dVar.b_renamed(i_renamed);
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
            androidx.recyclerview.widget.RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int getPaddingTop() {
            androidx.recyclerview.widget.RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int getPaddingRight() {
            androidx.recyclerview.widget.RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int getPaddingBottom() {
            androidx.recyclerview.widget.RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public int getPaddingStart() {
            androidx.recyclerview.widget.RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return androidx.core.h_renamed.v_renamed.j_renamed(recyclerView);
            }
            return 0;
        }

        public int getPaddingEnd() {
            androidx.recyclerview.widget.RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return androidx.core.h_renamed.v_renamed.k_renamed(recyclerView);
            }
            return 0;
        }

        public boolean isFocused() {
            androidx.recyclerview.widget.RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.isFocused();
        }

        public boolean hasFocus() {
            androidx.recyclerview.widget.RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.hasFocus();
        }

        public android.view.View getFocusedChild() {
            android.view.View focusedChild;
            androidx.recyclerview.widget.RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.mChildHelper.c_renamed(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public int getItemCount() {
            androidx.recyclerview.widget.RecyclerView recyclerView = this.mRecyclerView;
            androidx.recyclerview.widget.RecyclerView.a_renamed adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        public void offsetChildrenHorizontal(int i_renamed) {
            androidx.recyclerview.widget.RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenHorizontal(i_renamed);
            }
        }

        public void offsetChildrenVertical(int i_renamed) {
            androidx.recyclerview.widget.RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenVertical(i_renamed);
            }
        }

        public void ignoreView(android.view.View view) {
            android.view.ViewParent parent = view.getParent();
            androidx.recyclerview.widget.RecyclerView recyclerView = this.mRecyclerView;
            if (parent != recyclerView || recyclerView.indexOfChild(view) == -1) {
                throw new java.lang.IllegalArgumentException("View should be_renamed fully attached to be_renamed ignored" + this.mRecyclerView.exceptionLabel());
            }
            androidx.recyclerview.widget.RecyclerView.w_renamed childViewHolderInt = androidx.recyclerview.widget.RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.addFlags(128);
            this.mRecyclerView.mViewInfoStore.g_renamed(childViewHolderInt);
        }

        public void stopIgnoringView(android.view.View view) {
            androidx.recyclerview.widget.RecyclerView.w_renamed childViewHolderInt = androidx.recyclerview.widget.RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.stopIgnoring();
            childViewHolderInt.resetInternal();
            childViewHolderInt.addFlags(4);
        }

        public void detachAndScrapAttachedViews(androidx.recyclerview.widget.RecyclerView.p_renamed pVar) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                scrapOrRecycleView(pVar, childCount, getChildAt(childCount));
            }
        }

        private void scrapOrRecycleView(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, int i_renamed, android.view.View view) {
            androidx.recyclerview.widget.RecyclerView.w_renamed childViewHolderInt = androidx.recyclerview.widget.RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.shouldIgnore()) {
                return;
            }
            if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !this.mRecyclerView.mAdapter.hasStableIds()) {
                removeViewAt(i_renamed);
                pVar.b_renamed(childViewHolderInt);
            } else {
                detachViewAt(i_renamed);
                pVar.c_renamed(view);
                this.mRecyclerView.mViewInfoStore.h_renamed(childViewHolderInt);
            }
        }

        void removeAndRecycleScrapInt(androidx.recyclerview.widget.RecyclerView.p_renamed pVar) {
            int iE = pVar.e_renamed();
            for (int i_renamed = iE - 1; i_renamed >= 0; i_renamed--) {
                android.view.View viewE = pVar.e_renamed(i_renamed);
                androidx.recyclerview.widget.RecyclerView.w_renamed childViewHolderInt = androidx.recyclerview.widget.RecyclerView.getChildViewHolderInt(viewE);
                if (!childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.setIsRecyclable(false);
                    if (childViewHolderInt.isTmpDetached()) {
                        this.mRecyclerView.removeDetachedView(viewE, false);
                    }
                    if (this.mRecyclerView.mItemAnimator != null) {
                        this.mRecyclerView.mItemAnimator.d_renamed(childViewHolderInt);
                    }
                    childViewHolderInt.setIsRecyclable(true);
                    pVar.b_renamed(viewE);
                }
            }
            pVar.f_renamed();
            if (iE > 0) {
                this.mRecyclerView.invalidate();
            }
        }

        public void measureChild(android.view.View view, int i_renamed, int i2) {
            androidx.recyclerview.widget.RecyclerView.j_renamed jVar = (androidx.recyclerview.widget.RecyclerView.j_renamed) view.getLayoutParams();
            android.graphics.Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i3 = i_renamed + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right;
            int i4 = i2 + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + i3, jVar.width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + i4, jVar.height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, jVar)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        boolean shouldReMeasureChild(android.view.View view, int i_renamed, int i2, androidx.recyclerview.widget.RecyclerView.j_renamed jVar) {
            return (this.mMeasurementCacheEnabled && isMeasurementUpToDate(view.getMeasuredWidth(), i_renamed, jVar.width) && isMeasurementUpToDate(view.getMeasuredHeight(), i2, jVar.height)) ? false : true;
        }

        boolean shouldMeasureChild(android.view.View view, int i_renamed, int i2, androidx.recyclerview.widget.RecyclerView.j_renamed jVar) {
            return (!view.isLayoutRequested() && this.mMeasurementCacheEnabled && isMeasurementUpToDate(view.getWidth(), i_renamed, jVar.width) && isMeasurementUpToDate(view.getHeight(), i2, jVar.height)) ? false : true;
        }

        public boolean isMeasurementCacheEnabled() {
            return this.mMeasurementCacheEnabled;
        }

        public void setMeasurementCacheEnabled(boolean z_renamed) {
            this.mMeasurementCacheEnabled = z_renamed;
        }

        private static boolean isMeasurementUpToDate(int i_renamed, int i2, int i3) {
            int mode = android.view.View.MeasureSpec.getMode(i2);
            int size = android.view.View.MeasureSpec.getSize(i2);
            if (i3 > 0 && i_renamed != i3) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i_renamed;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i_renamed;
            }
            return true;
        }

        public void measureChildWithMargins(android.view.View view, int i_renamed, int i2) {
            androidx.recyclerview.widget.RecyclerView.j_renamed jVar = (androidx.recyclerview.widget.RecyclerView.j_renamed) view.getLayoutParams();
            android.graphics.Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i3 = i_renamed + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right;
            int i4 = i2 + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + jVar.leftMargin + jVar.rightMargin + i3, jVar.width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + jVar.topMargin + jVar.bottomMargin + i4, jVar.height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, jVar)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B_renamed:4:0x000a, code lost:
        
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
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.i_renamed.getChildMeasureSpec(int, int, int, boolean):int");
        }

        /* JADX WARN: Removed duplicated region for block: B_renamed:14:0x0022  */
        /* JADX WARN: Removed duplicated region for block: B_renamed:21:0x0031  */
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
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.i_renamed.getChildMeasureSpec(int, int, int, int, boolean):int");
        }

        public int getDecoratedMeasuredWidth(android.view.View view) {
            android.graphics.Rect rect = ((androidx.recyclerview.widget.RecyclerView.j_renamed) view.getLayoutParams()).d_renamed;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int getDecoratedMeasuredHeight(android.view.View view) {
            android.graphics.Rect rect = ((androidx.recyclerview.widget.RecyclerView.j_renamed) view.getLayoutParams()).d_renamed;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void layoutDecorated(android.view.View view, int i_renamed, int i2, int i3, int i4) {
            android.graphics.Rect rect = ((androidx.recyclerview.widget.RecyclerView.j_renamed) view.getLayoutParams()).d_renamed;
            view.layout(i_renamed + rect.left, i2 + rect.top, i3 - rect.right, i4 - rect.bottom);
        }

        public void layoutDecoratedWithMargins(android.view.View view, int i_renamed, int i2, int i3, int i4) {
            androidx.recyclerview.widget.RecyclerView.j_renamed jVar = (androidx.recyclerview.widget.RecyclerView.j_renamed) view.getLayoutParams();
            android.graphics.Rect rect = jVar.d_renamed;
            view.layout(i_renamed + rect.left + jVar.leftMargin, i2 + rect.top + jVar.topMargin, (i3 - rect.right) - jVar.rightMargin, (i4 - rect.bottom) - jVar.bottomMargin);
        }

        public void getTransformedBoundingBox(android.view.View view, boolean z_renamed, android.graphics.Rect rect) {
            android.graphics.Matrix matrix;
            if (z_renamed) {
                android.graphics.Rect rect2 = ((androidx.recyclerview.widget.RecyclerView.j_renamed) view.getLayoutParams()).d_renamed;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.mRecyclerView != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                android.graphics.RectF rectF = this.mRecyclerView.mTempRectF;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) java.lang.Math.floor(rectF.left), (int) java.lang.Math.floor(rectF.top), (int) java.lang.Math.ceil(rectF.right), (int) java.lang.Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void getDecoratedBoundsWithMargins(android.view.View view, android.graphics.Rect rect) {
            androidx.recyclerview.widget.RecyclerView.getDecoratedBoundsWithMarginsInt(view, rect);
        }

        public int getDecoratedLeft(android.view.View view) {
            return view.getLeft() - getLeftDecorationWidth(view);
        }

        public int getDecoratedTop(android.view.View view) {
            return view.getTop() - getTopDecorationHeight(view);
        }

        public int getDecoratedRight(android.view.View view) {
            return view.getRight() + getRightDecorationWidth(view);
        }

        public int getDecoratedBottom(android.view.View view) {
            return view.getBottom() + getBottomDecorationHeight(view);
        }

        public void calculateItemDecorationsForChild(android.view.View view, android.graphics.Rect rect) {
            androidx.recyclerview.widget.RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.getItemDecorInsetsForChild(view));
            }
        }

        public int getTopDecorationHeight(android.view.View view) {
            return ((androidx.recyclerview.widget.RecyclerView.j_renamed) view.getLayoutParams()).d_renamed.top;
        }

        public int getBottomDecorationHeight(android.view.View view) {
            return ((androidx.recyclerview.widget.RecyclerView.j_renamed) view.getLayoutParams()).d_renamed.bottom;
        }

        public int getLeftDecorationWidth(android.view.View view) {
            return ((androidx.recyclerview.widget.RecyclerView.j_renamed) view.getLayoutParams()).d_renamed.left;
        }

        public int getRightDecorationWidth(android.view.View view) {
            return ((androidx.recyclerview.widget.RecyclerView.j_renamed) view.getLayoutParams()).d_renamed.right;
        }

        private int[] getChildRectangleOnScreenScrollAmount(android.view.View view, android.graphics.Rect rect) {
            int[] iArr = new int[2];
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int iWidth = rect.width() + left;
            int iHeight = rect.height() + top;
            int i_renamed = left - paddingLeft;
            int iMin = java.lang.Math.min(0, i_renamed);
            int i2 = top - paddingTop;
            int iMin2 = java.lang.Math.min(0, i2);
            int i3 = iWidth - width;
            int iMax = java.lang.Math.max(0, i3);
            int iMax2 = java.lang.Math.max(0, iHeight - height);
            if (getLayoutDirection() != 1) {
                if (iMin == 0) {
                    iMin = java.lang.Math.min(i_renamed, iMax);
                }
                iMax = iMin;
            } else if (iMax == 0) {
                iMax = java.lang.Math.max(iMin, i3);
            }
            if (iMin2 == 0) {
                iMin2 = java.lang.Math.min(i2, iMax2);
            }
            iArr[0] = iMax;
            iArr[1] = iMin2;
            return iArr;
        }

        public boolean requestChildRectangleOnScreen(androidx.recyclerview.widget.RecyclerView recyclerView, android.view.View view, android.graphics.Rect rect, boolean z_renamed) {
            return requestChildRectangleOnScreen(recyclerView, view, rect, z_renamed, false);
        }

        public boolean requestChildRectangleOnScreen(androidx.recyclerview.widget.RecyclerView recyclerView, android.view.View view, android.graphics.Rect rect, boolean z_renamed, boolean z2) {
            int[] childRectangleOnScreenScrollAmount = getChildRectangleOnScreenScrollAmount(view, rect);
            int i_renamed = childRectangleOnScreenScrollAmount[0];
            int i2 = childRectangleOnScreenScrollAmount[1];
            if ((z2 && !isFocusedChildVisibleAfterScrolling(recyclerView, i_renamed, i2)) || (i_renamed == 0 && i2 == 0)) {
                return false;
            }
            if (z_renamed) {
                recyclerView.scrollBy(i_renamed, i2);
            } else {
                recyclerView.smoothScrollBy(i_renamed, i2);
            }
            return true;
        }

        public boolean isViewPartiallyVisible(android.view.View view, boolean z_renamed, boolean z2) {
            boolean z3 = this.mHorizontalBoundCheck.a_renamed(view, 24579) && this.mVerticalBoundCheck.a_renamed(view, 24579);
            return z_renamed ? z3 : !z3;
        }

        private boolean isFocusedChildVisibleAfterScrolling(androidx.recyclerview.widget.RecyclerView recyclerView, int i_renamed, int i2) {
            android.view.View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            android.graphics.Rect rect = this.mRecyclerView.mTempRect;
            getDecoratedBoundsWithMargins(focusedChild, rect);
            return rect.left - i_renamed < width && rect.right - i_renamed > paddingLeft && rect.top - i2 < height && rect.bottom - i2 > paddingTop;
        }

        @java.lang.Deprecated
        public boolean onRequestChildFocus(androidx.recyclerview.widget.RecyclerView recyclerView, android.view.View view, android.view.View view2) {
            return isSmoothScrolling() || recyclerView.isComputingLayout();
        }

        public boolean onRequestChildFocus(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.t_renamed tVar, android.view.View view, android.view.View view2) {
            return onRequestChildFocus(recyclerView, view, view2);
        }

        public void onItemsUpdated(androidx.recyclerview.widget.RecyclerView recyclerView, int i_renamed, int i2, java.lang.Object obj) {
            onItemsUpdated(recyclerView, i_renamed, i2);
        }

        public void onMeasure(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar, int i_renamed, int i2) {
            this.mRecyclerView.defaultOnMeasure(i_renamed, i2);
        }

        public void setMeasuredDimension(int i_renamed, int i2) {
            this.mRecyclerView.setMeasuredDimension(i_renamed, i2);
        }

        public int getMinimumWidth() {
            return androidx.core.h_renamed.v_renamed.l_renamed(this.mRecyclerView);
        }

        public int getMinimumHeight() {
            return androidx.core.h_renamed.v_renamed.m_renamed(this.mRecyclerView);
        }

        void stopSmoothScroller() {
            androidx.recyclerview.widget.RecyclerView.s_renamed sVar = this.mSmoothScroller;
            if (sVar != null) {
                sVar.stop();
            }
        }

        void onSmoothScrollerStopped(androidx.recyclerview.widget.RecyclerView.s_renamed sVar) {
            if (this.mSmoothScroller == sVar) {
                this.mSmoothScroller = null;
            }
        }

        public void removeAndRecycleAllViews(androidx.recyclerview.widget.RecyclerView.p_renamed pVar) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (!androidx.recyclerview.widget.RecyclerView.getChildViewHolderInt(getChildAt(childCount)).shouldIgnore()) {
                    removeAndRecycleViewAt(childCount, pVar);
                }
            }
        }

        void onInitializeAccessibilityNodeInfo(androidx.core.h_renamed.a_renamed.d_renamed dVar) {
            onInitializeAccessibilityNodeInfo(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, dVar);
        }

        public void onInitializeAccessibilityNodeInfo(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar, androidx.core.h_renamed.a_renamed.d_renamed dVar) {
            if (this.mRecyclerView.canScrollVertically(-1) || this.mRecyclerView.canScrollHorizontally(-1)) {
                dVar.a_renamed(8192);
                dVar.i_renamed(true);
            }
            if (this.mRecyclerView.canScrollVertically(1) || this.mRecyclerView.canScrollHorizontally(1)) {
                dVar.a_renamed(4096);
                dVar.i_renamed(true);
            }
            dVar.a_renamed(androidx.core.h_renamed.a_renamed.d_renamed.b_renamed.a_renamed(getRowCountForAccessibility(pVar, tVar), getColumnCountForAccessibility(pVar, tVar), isLayoutHierarchical(pVar, tVar), getSelectionModeForAccessibility(pVar, tVar)));
        }

        public void onInitializeAccessibilityEvent(android.view.accessibility.AccessibilityEvent accessibilityEvent) {
            onInitializeAccessibilityEvent(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, accessibilityEvent);
        }

        public void onInitializeAccessibilityEvent(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
            androidx.recyclerview.widget.RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z_renamed = true;
            if (!recyclerView.canScrollVertically(1) && !this.mRecyclerView.canScrollVertically(-1) && !this.mRecyclerView.canScrollHorizontally(-1) && !this.mRecyclerView.canScrollHorizontally(1)) {
                z_renamed = false;
            }
            accessibilityEvent.setScrollable(z_renamed);
            if (this.mRecyclerView.mAdapter != null) {
                accessibilityEvent.setItemCount(this.mRecyclerView.mAdapter.getItemCount());
            }
        }

        void onInitializeAccessibilityNodeInfoForItem(android.view.View view, androidx.core.h_renamed.a_renamed.d_renamed dVar) {
            androidx.recyclerview.widget.RecyclerView.w_renamed childViewHolderInt = androidx.recyclerview.widget.RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt == null || childViewHolderInt.isRemoved() || this.mChildHelper.c_renamed(childViewHolderInt.itemView)) {
                return;
            }
            onInitializeAccessibilityNodeInfoForItem(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, view, dVar);
        }

        public void requestSimpleAnimationsInNextLayout() {
            this.mRequestedSimpleAnimations = true;
        }

        boolean performAccessibilityAction(int i_renamed, android.os.Bundle bundle) {
            return performAccessibilityAction(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, i_renamed, bundle);
        }

        public boolean performAccessibilityAction(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar, int i_renamed, android.os.Bundle bundle) {
            int height;
            int width;
            int i2;
            int i3;
            androidx.recyclerview.widget.RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                return false;
            }
            if (i_renamed == 4096) {
                height = recyclerView.canScrollVertically(1) ? (getHeight() - getPaddingTop()) - getPaddingBottom() : 0;
                if (this.mRecyclerView.canScrollHorizontally(1)) {
                    width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                    i2 = height;
                    i3 = width;
                }
                i2 = height;
                i3 = 0;
            } else if (i_renamed != 8192) {
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

        boolean performAccessibilityActionForItem(android.view.View view, int i_renamed, android.os.Bundle bundle) {
            return performAccessibilityActionForItem(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, view, i_renamed, bundle);
        }

        public static androidx.recyclerview.widget.RecyclerView.i_renamed.b_renamed getProperties(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
            androidx.recyclerview.widget.RecyclerView.i_renamed.b_renamed bVar = new androidx.recyclerview.widget.RecyclerView.i_renamed.b_renamed();
            android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.recyclerview.R_renamed.styleable.RecyclerView, i_renamed, i2);
            bVar.f1419a = typedArrayObtainStyledAttributes.getInt(androidx.recyclerview.R_renamed.styleable.RecyclerView_android_orientation, 1);
            bVar.f1420b = typedArrayObtainStyledAttributes.getInt(androidx.recyclerview.R_renamed.styleable.RecyclerView_spanCount, 1);
            bVar.f1421c = typedArrayObtainStyledAttributes.getBoolean(androidx.recyclerview.R_renamed.styleable.RecyclerView_reverseLayout, false);
            bVar.d_renamed = typedArrayObtainStyledAttributes.getBoolean(androidx.recyclerview.R_renamed.styleable.RecyclerView_stackFromEnd, false);
            typedArrayObtainStyledAttributes.recycle();
            return bVar;
        }

        void setExactMeasureSpecsFrom(androidx.recyclerview.widget.RecyclerView recyclerView) {
            setMeasureSpecs(android.view.View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), android.view.View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        boolean hasFlexibleChildInBothOrientations() {
            int childCount = getChildCount();
            for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
                android.view.ViewGroup.LayoutParams layoutParams = getChildAt(i_renamed).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }
    }

    public static abstract class h_renamed {
        @java.lang.Deprecated
        public void onDraw(android.graphics.Canvas canvas, androidx.recyclerview.widget.RecyclerView recyclerView) {
        }

        @java.lang.Deprecated
        public void onDrawOver(android.graphics.Canvas canvas, androidx.recyclerview.widget.RecyclerView recyclerView) {
        }

        public void onDraw(android.graphics.Canvas canvas, androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
            onDraw(canvas, recyclerView);
        }

        public void onDrawOver(android.graphics.Canvas canvas, androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
            onDrawOver(canvas, recyclerView);
        }

        @java.lang.Deprecated
        public void getItemOffsets(android.graphics.Rect rect, int i_renamed, androidx.recyclerview.widget.RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void getItemOffsets(android.graphics.Rect rect, android.view.View view, androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
            getItemOffsets(rect, ((androidx.recyclerview.widget.RecyclerView.j_renamed) view.getLayoutParams()).f_renamed(), recyclerView);
        }
    }

    public static abstract class w_renamed {
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
        private static final java.util.List<java.lang.Object> FULLUPDATE_PAYLOADS = java.util.Collections.emptyList();
        static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
        public final android.view.View itemView;
        androidx.recyclerview.widget.RecyclerView.a_renamed<? extends androidx.recyclerview.widget.RecyclerView.w_renamed> mBindingAdapter;
        int mFlags;
        java.lang.ref.WeakReference<androidx.recyclerview.widget.RecyclerView> mNestedRecyclerView;
        androidx.recyclerview.widget.RecyclerView mOwnerRecyclerView;
        int mPosition = -1;
        int mOldPosition = -1;
        long mItemId = -1;
        int mItemViewType = -1;
        int mPreLayoutPosition = -1;
        androidx.recyclerview.widget.RecyclerView.w_renamed mShadowedHolder = null;
        androidx.recyclerview.widget.RecyclerView.w_renamed mShadowingHolder = null;
        java.util.List<java.lang.Object> mPayloads = null;
        java.util.List<java.lang.Object> mUnmodifiedPayloads = null;
        private int mIsRecyclableCount = 0;
        androidx.recyclerview.widget.RecyclerView.p_renamed mScrapContainer = null;
        boolean mInChangeScrap = false;
        private int mWasImportantForAccessibilityBeforeHidden = 0;
        int mPendingAccessibilityState = -1;

        public w_renamed(android.view.View view) {
            if (view == null) {
                throw new java.lang.IllegalArgumentException("itemView may not be_renamed null");
            }
            this.itemView = view;
        }

        void flagRemovedAndOffsetPosition(int i_renamed, int i2, boolean z_renamed) {
            addFlags(8);
            offsetPosition(i2, z_renamed);
            this.mPosition = i_renamed;
        }

        void offsetPosition(int i_renamed, boolean z_renamed) {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == -1) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (z_renamed) {
                this.mPreLayoutPosition += i_renamed;
            }
            this.mPosition += i_renamed;
            if (this.itemView.getLayoutParams() != null) {
                ((androidx.recyclerview.widget.RecyclerView.j_renamed) this.itemView.getLayoutParams()).e_renamed = true;
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

        @java.lang.Deprecated
        public final int getPosition() {
            int i_renamed = this.mPreLayoutPosition;
            return i_renamed == -1 ? this.mPosition : i_renamed;
        }

        public final int getLayoutPosition() {
            int i_renamed = this.mPreLayoutPosition;
            return i_renamed == -1 ? this.mPosition : i_renamed;
        }

        @java.lang.Deprecated
        public final int getAdapterPosition() {
            return getBindingAdapterPosition();
        }

        public final int getBindingAdapterPosition() {
            androidx.recyclerview.widget.RecyclerView recyclerView;
            androidx.recyclerview.widget.RecyclerView.a_renamed adapter;
            int adapterPositionInRecyclerView;
            if (this.mBindingAdapter == null || (recyclerView = this.mOwnerRecyclerView) == null || (adapter = recyclerView.getAdapter()) == null || (adapterPositionInRecyclerView = this.mOwnerRecyclerView.getAdapterPositionInRecyclerView(this)) == -1) {
                return -1;
            }
            return adapter.findRelativeAdapterPositionIn(this.mBindingAdapter, this, adapterPositionInRecyclerView);
        }

        public final int getAbsoluteAdapterPosition() {
            androidx.recyclerview.widget.RecyclerView recyclerView = this.mOwnerRecyclerView;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.getAdapterPositionInRecyclerView(this);
        }

        public final androidx.recyclerview.widget.RecyclerView.a_renamed<? extends androidx.recyclerview.widget.RecyclerView.w_renamed> getBindingAdapter() {
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
            this.mScrapContainer.c_renamed(this);
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

        void setScrapContainer(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, boolean z_renamed) {
            this.mScrapContainer = pVar;
            this.mInChangeScrap = z_renamed;
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

        boolean hasAnyOfTheFlags(int i_renamed) {
            return (this.mFlags & i_renamed) != 0;
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

        void setFlags(int i_renamed, int i2) {
            this.mFlags = (i_renamed & i2) | (this.mFlags & (~i2));
        }

        void addFlags(int i_renamed) {
            this.mFlags = i_renamed | this.mFlags;
        }

        void addChangePayload(java.lang.Object obj) {
            if (obj == null) {
                addFlags(1024);
            } else if ((1024 & this.mFlags) == 0) {
                createPayloadsIfNeeded();
                this.mPayloads.add(obj);
            }
        }

        private void createPayloadsIfNeeded() {
            if (this.mPayloads == null) {
                this.mPayloads = new java.util.ArrayList();
                this.mUnmodifiedPayloads = java.util.Collections.unmodifiableList(this.mPayloads);
            }
        }

        void clearPayload() {
            java.util.List<java.lang.Object> list = this.mPayloads;
            if (list != null) {
                list.clear();
            }
            this.mFlags &= -1025;
        }

        java.util.List<java.lang.Object> getUnmodifiedPayloads() {
            if ((this.mFlags & 1024) == 0) {
                java.util.List<java.lang.Object> list = this.mPayloads;
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
            androidx.recyclerview.widget.RecyclerView.clearNestedRecyclerViewIfNotNested(this);
        }

        void onEnteredHiddenState(androidx.recyclerview.widget.RecyclerView recyclerView) {
            int i_renamed = this.mPendingAccessibilityState;
            if (i_renamed != -1) {
                this.mWasImportantForAccessibilityBeforeHidden = i_renamed;
            } else {
                this.mWasImportantForAccessibilityBeforeHidden = androidx.core.h_renamed.v_renamed.f_renamed(this.itemView);
            }
            recyclerView.setChildImportantForAccessibilityInternal(this, 4);
        }

        void onLeftHiddenState(androidx.recyclerview.widget.RecyclerView recyclerView) {
            recyclerView.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        public java.lang.String toString() {
            java.lang.StringBuilder sb = new java.lang.StringBuilder((getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName()) + "{" + java.lang.Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id_renamed=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
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

        public final void setIsRecyclable(boolean z_renamed) {
            this.mIsRecyclableCount = z_renamed ? this.mIsRecyclableCount - 1 : this.mIsRecyclableCount + 1;
            int i_renamed = this.mIsRecyclableCount;
            if (i_renamed < 0) {
                this.mIsRecyclableCount = 0;
                android.util.Log.e_renamed("View", "isRecyclable decremented below 0: unmatched pair of_renamed setIsRecyable() calls for " + this);
                return;
            }
            if (!z_renamed && i_renamed == 1) {
                this.mFlags |= 16;
            } else if (z_renamed && this.mIsRecyclableCount == 0) {
                this.mFlags &= -17;
            }
        }

        public final boolean isRecyclable() {
            return (this.mFlags & 16) == 0 && !androidx.core.h_renamed.v_renamed.d_renamed(this.itemView);
        }

        boolean shouldBeKeptAsChild() {
            return (this.mFlags & 16) != 0;
        }

        boolean doesTransientStatePreventRecycling() {
            return (this.mFlags & 16) == 0 && androidx.core.h_renamed.v_renamed.d_renamed(this.itemView);
        }

        boolean isUpdated() {
            return (this.mFlags & 2) != 0;
        }
    }

    boolean setChildImportantForAccessibilityInternal(androidx.recyclerview.widget.RecyclerView.w_renamed wVar, int i2) {
        if (isComputingLayout()) {
            wVar.mPendingAccessibilityState = i2;
            this.mPendingAccessibilityImportanceChange.add(wVar);
            return false;
        }
        androidx.core.h_renamed.v_renamed.b_renamed(wVar.itemView, i2);
        return true;
    }

    void dispatchPendingImportantForAccessibilityChanges() {
        int i2;
        for (int size = this.mPendingAccessibilityImportanceChange.size() - 1; size >= 0; size--) {
            androidx.recyclerview.widget.RecyclerView.w_renamed wVar = this.mPendingAccessibilityImportanceChange.get(size);
            if (wVar.itemView.getParent() == this && !wVar.shouldIgnore() && (i2 = wVar.mPendingAccessibilityState) != -1) {
                androidx.core.h_renamed.v_renamed.b_renamed(wVar.itemView, i2);
                wVar.mPendingAccessibilityState = -1;
            }
        }
        this.mPendingAccessibilityImportanceChange.clear();
    }

    int getAdapterPositionInRecyclerView(androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
        if (wVar.hasAnyOfTheFlags(524) || !wVar.isBound()) {
            return -1;
        }
        return this.mAdapterHelper.c_renamed(wVar.mPosition);
    }

    void initFastScroller(android.graphics.drawable.StateListDrawable stateListDrawable, android.graphics.drawable.Drawable drawable, android.graphics.drawable.StateListDrawable stateListDrawable2, android.graphics.drawable.Drawable drawable2) {
        if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
            throw new java.lang.IllegalArgumentException("Trying to set fast scroller without both required drawables." + exceptionLabel());
        }
        android.content.res.Resources resources = getContext().getResources();
        new androidx.recyclerview.widget.g_renamed(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(androidx.recyclerview.R_renamed.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(androidx.recyclerview.R_renamed.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(androidx.recyclerview.R_renamed.dimen.fastscroll_margin));
    }

    @Override // android.view.View, androidx.core.h_renamed.i_renamed
    public void setNestedScrollingEnabled(boolean z_renamed) {
        getScrollingChildHelper().a_renamed(z_renamed);
    }

    @Override // android.view.View, androidx.core.h_renamed.i_renamed
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().a_renamed();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().b_renamed(i2);
    }

    public boolean startNestedScroll(int i2, int i3) {
        return getScrollingChildHelper().a_renamed(i2, i3);
    }

    @Override // android.view.View, androidx.core.h_renamed.i_renamed
    public void stopNestedScroll() {
        getScrollingChildHelper().c_renamed();
    }

    public void stopNestedScroll(int i2) {
        getScrollingChildHelper().c_renamed(i2);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().b_renamed();
    }

    public boolean hasNestedScrollingParent(int i2) {
        return getScrollingChildHelper().a_renamed(i2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().a_renamed(i2, i3, i4, i5, iArr);
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        return getScrollingChildHelper().a_renamed(i2, i3, i4, i5, iArr, i6);
    }

    public final void dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        getScrollingChildHelper().a_renamed(i2, i3, i4, i5, iArr, i6, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().a_renamed(i2, i3, iArr, iArr2);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return getScrollingChildHelper().a_renamed(i2, i3, iArr, iArr2, i4);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f2, float f3, boolean z_renamed) {
        return getScrollingChildHelper().a_renamed(f2, f3, z_renamed);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().a_renamed(f2, f3);
    }

    public static class j_renamed extends android.view.ViewGroup.MarginLayoutParams {

        /* renamed from: c_renamed, reason: collision with root package name */
        androidx.recyclerview.widget.RecyclerView.w_renamed f1422c;
        final android.graphics.Rect d_renamed;
        boolean e_renamed;
        boolean f_renamed;

        public j_renamed(android.content.Context context, android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
            this.d_renamed = new android.graphics.Rect();
            this.e_renamed = true;
            this.f_renamed = false;
        }

        public j_renamed(int i_renamed, int i2) {
            super(i_renamed, i2);
            this.d_renamed = new android.graphics.Rect();
            this.e_renamed = true;
            this.f_renamed = false;
        }

        public j_renamed(android.view.ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.d_renamed = new android.graphics.Rect();
            this.e_renamed = true;
            this.f_renamed = false;
        }

        public j_renamed(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.d_renamed = new android.graphics.Rect();
            this.e_renamed = true;
            this.f_renamed = false;
        }

        public j_renamed(androidx.recyclerview.widget.RecyclerView.j_renamed jVar) {
            super((android.view.ViewGroup.LayoutParams) jVar);
            this.d_renamed = new android.graphics.Rect();
            this.e_renamed = true;
            this.f_renamed = false;
        }

        public boolean c_renamed() {
            return this.f1422c.isInvalid();
        }

        public boolean d_renamed() {
            return this.f1422c.isRemoved();
        }

        public boolean e_renamed() {
            return this.f1422c.isUpdated();
        }

        public int f_renamed() {
            return this.f1422c.getLayoutPosition();
        }

        @java.lang.Deprecated
        public int g_renamed() {
            return this.f1422c.getBindingAdapterPosition();
        }

        public int h_renamed() {
            return this.f1422c.getBindingAdapterPosition();
        }
    }

    public static abstract class c_renamed {
        public void onChanged() {
        }

        public void onItemRangeChanged(int i_renamed, int i2) {
        }

        public void onItemRangeInserted(int i_renamed, int i2) {
        }

        public void onItemRangeMoved(int i_renamed, int i2, int i3) {
        }

        public void onItemRangeRemoved(int i_renamed, int i2) {
        }

        public void onStateRestorationPolicyChanged() {
        }

        public void onItemRangeChanged(int i_renamed, int i2, java.lang.Object obj) {
            onItemRangeChanged(i_renamed, i2);
        }
    }

    public static abstract class s_renamed {
        private androidx.recyclerview.widget.RecyclerView.i_renamed mLayoutManager;
        private boolean mPendingInitialRun;
        private androidx.recyclerview.widget.RecyclerView mRecyclerView;
        private boolean mRunning;
        private boolean mStarted;
        private android.view.View mTargetView;
        private int mTargetPosition = -1;
        private final androidx.recyclerview.widget.RecyclerView.s_renamed.a_renamed mRecyclingAction = new androidx.recyclerview.widget.RecyclerView.s_renamed.a_renamed(0, 0);

        public interface b_renamed {
            android.graphics.PointF computeScrollVectorForPosition(int i_renamed);
        }

        protected abstract void onSeekTargetStep(int i_renamed, int i2, androidx.recyclerview.widget.RecyclerView.t_renamed tVar, androidx.recyclerview.widget.RecyclerView.s_renamed.a_renamed aVar);

        protected abstract void onStart();

        protected abstract void onStop();

        protected abstract void onTargetFound(android.view.View view, androidx.recyclerview.widget.RecyclerView.t_renamed tVar, androidx.recyclerview.widget.RecyclerView.s_renamed.a_renamed aVar);

        void start(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.i_renamed iVar) {
            recyclerView.mViewFlinger.b_renamed();
            if (this.mStarted) {
                android.util.Log.w_renamed(androidx.recyclerview.widget.RecyclerView.TAG, "An instance of_renamed " + getClass().getSimpleName() + " was started more than once. Each instance of_renamed" + getClass().getSimpleName() + " is_renamed intended to only be_renamed used once. You should create a_renamed new instance for each use.");
            }
            this.mRecyclerView = recyclerView;
            this.mLayoutManager = iVar;
            if (this.mTargetPosition == -1) {
                throw new java.lang.IllegalArgumentException("Invalid target position");
            }
            this.mRecyclerView.mState.f1435a = this.mTargetPosition;
            this.mRunning = true;
            this.mPendingInitialRun = true;
            this.mTargetView = findViewByPosition(getTargetPosition());
            onStart();
            this.mRecyclerView.mViewFlinger.a_renamed();
            this.mStarted = true;
        }

        public void setTargetPosition(int i_renamed) {
            this.mTargetPosition = i_renamed;
        }

        public android.graphics.PointF computeScrollVectorForPosition(int i_renamed) {
            java.lang.Object layoutManager = getLayoutManager();
            if (layoutManager instanceof androidx.recyclerview.widget.RecyclerView.s_renamed.b_renamed) {
                return ((androidx.recyclerview.widget.RecyclerView.s_renamed.b_renamed) layoutManager).computeScrollVectorForPosition(i_renamed);
            }
            android.util.Log.w_renamed(androidx.recyclerview.widget.RecyclerView.TAG, "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + androidx.recyclerview.widget.RecyclerView.s_renamed.b_renamed.class.getCanonicalName());
            return null;
        }

        public androidx.recyclerview.widget.RecyclerView.i_renamed getLayoutManager() {
            return this.mLayoutManager;
        }

        protected final void stop() {
            if (this.mRunning) {
                this.mRunning = false;
                onStop();
                this.mRecyclerView.mState.f1435a = -1;
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

        void onAnimation(int i_renamed, int i2) {
            android.graphics.PointF pointFComputeScrollVectorForPosition;
            androidx.recyclerview.widget.RecyclerView recyclerView = this.mRecyclerView;
            if (this.mTargetPosition == -1 || recyclerView == null) {
                stop();
            }
            if (this.mPendingInitialRun && this.mTargetView == null && this.mLayoutManager != null && (pointFComputeScrollVectorForPosition = computeScrollVectorForPosition(this.mTargetPosition)) != null && (pointFComputeScrollVectorForPosition.x_renamed != 0.0f || pointFComputeScrollVectorForPosition.y_renamed != 0.0f)) {
                recyclerView.scrollStep((int) java.lang.Math.signum(pointFComputeScrollVectorForPosition.x_renamed), (int) java.lang.Math.signum(pointFComputeScrollVectorForPosition.y_renamed), null);
            }
            this.mPendingInitialRun = false;
            android.view.View view = this.mTargetView;
            if (view != null) {
                if (getChildPosition(view) == this.mTargetPosition) {
                    onTargetFound(this.mTargetView, recyclerView.mState, this.mRecyclingAction);
                    this.mRecyclingAction.a_renamed(recyclerView);
                    stop();
                } else {
                    android.util.Log.e_renamed(androidx.recyclerview.widget.RecyclerView.TAG, "Passed over target position while smooth scrolling.");
                    this.mTargetView = null;
                }
            }
            if (this.mRunning) {
                onSeekTargetStep(i_renamed, i2, recyclerView.mState, this.mRecyclingAction);
                boolean zA = this.mRecyclingAction.a_renamed();
                this.mRecyclingAction.a_renamed(recyclerView);
                if (zA && this.mRunning) {
                    this.mPendingInitialRun = true;
                    recyclerView.mViewFlinger.a_renamed();
                }
            }
        }

        public int getChildPosition(android.view.View view) {
            return this.mRecyclerView.getChildLayoutPosition(view);
        }

        public int getChildCount() {
            return this.mRecyclerView.mLayout.getChildCount();
        }

        public android.view.View findViewByPosition(int i_renamed) {
            return this.mRecyclerView.mLayout.findViewByPosition(i_renamed);
        }

        @java.lang.Deprecated
        public void instantScrollToPosition(int i_renamed) {
            this.mRecyclerView.scrollToPosition(i_renamed);
        }

        protected void onChildAttachedToWindow(android.view.View view) {
            if (getChildPosition(view) == getTargetPosition()) {
                this.mTargetView = view;
            }
        }

        protected void normalize(android.graphics.PointF pointF) {
            float fSqrt = (float) java.lang.Math.sqrt((pointF.x_renamed * pointF.x_renamed) + (pointF.y_renamed * pointF.y_renamed));
            pointF.x_renamed /= fSqrt;
            pointF.y_renamed /= fSqrt;
        }

        public static class a_renamed {

            /* renamed from: a_renamed, reason: collision with root package name */
            private int f1432a;

            /* renamed from: b_renamed, reason: collision with root package name */
            private int f1433b;

            /* renamed from: c_renamed, reason: collision with root package name */
            private int f1434c;
            private int d_renamed;
            private android.view.animation.Interpolator e_renamed;
            private boolean f_renamed;
            private int g_renamed;

            public a_renamed(int i_renamed, int i2) {
                this(i_renamed, i2, Integer.MIN_VALUE, null);
            }

            public a_renamed(int i_renamed, int i2, int i3, android.view.animation.Interpolator interpolator) {
                this.d_renamed = -1;
                this.f_renamed = false;
                this.g_renamed = 0;
                this.f1432a = i_renamed;
                this.f1433b = i2;
                this.f1434c = i3;
                this.e_renamed = interpolator;
            }

            public void a_renamed(int i_renamed) {
                this.d_renamed = i_renamed;
            }

            boolean a_renamed() {
                return this.d_renamed >= 0;
            }

            void a_renamed(androidx.recyclerview.widget.RecyclerView recyclerView) {
                int i_renamed = this.d_renamed;
                if (i_renamed >= 0) {
                    this.d_renamed = -1;
                    recyclerView.jumpToPositionForSmoothScroller(i_renamed);
                    this.f_renamed = false;
                } else {
                    if (this.f_renamed) {
                        b_renamed();
                        recyclerView.mViewFlinger.a_renamed(this.f1432a, this.f1433b, this.f1434c, this.e_renamed);
                        this.g_renamed++;
                        if (this.g_renamed > 10) {
                            android.util.Log.e_renamed(androidx.recyclerview.widget.RecyclerView.TAG, "Smooth Scroll action is_renamed being updated too frequently. Make sure you are not changing it unless necessary");
                        }
                        this.f_renamed = false;
                        return;
                    }
                    this.g_renamed = 0;
                }
            }

            private void b_renamed() {
                if (this.e_renamed != null && this.f1434c < 1) {
                    throw new java.lang.IllegalStateException("If you provide an_renamed interpolator, you must set a_renamed positive duration");
                }
                if (this.f1434c < 1) {
                    throw new java.lang.IllegalStateException("Scroll duration must be_renamed a_renamed positive number");
                }
            }

            public void a_renamed(int i_renamed, int i2, int i3, android.view.animation.Interpolator interpolator) {
                this.f1432a = i_renamed;
                this.f1433b = i2;
                this.f1434c = i3;
                this.e_renamed = interpolator;
                this.f_renamed = true;
            }
        }
    }

    static class b_renamed extends android.database.Observable<androidx.recyclerview.widget.RecyclerView.c_renamed> {
        b_renamed() {
        }

        public boolean a_renamed() {
            return !this.mObservers.isEmpty();
        }

        public void b_renamed() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((androidx.recyclerview.widget.RecyclerView.c_renamed) this.mObservers.get(size)).onChanged();
            }
        }

        public void c_renamed() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((androidx.recyclerview.widget.RecyclerView.c_renamed) this.mObservers.get(size)).onStateRestorationPolicyChanged();
            }
        }

        public void a_renamed(int i_renamed, int i2) {
            a_renamed(i_renamed, i2, null);
        }

        public void a_renamed(int i_renamed, int i2, java.lang.Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((androidx.recyclerview.widget.RecyclerView.c_renamed) this.mObservers.get(size)).onItemRangeChanged(i_renamed, i2, obj);
            }
        }

        public void b_renamed(int i_renamed, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((androidx.recyclerview.widget.RecyclerView.c_renamed) this.mObservers.get(size)).onItemRangeInserted(i_renamed, i2);
            }
        }

        public void c_renamed(int i_renamed, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((androidx.recyclerview.widget.RecyclerView.c_renamed) this.mObservers.get(size)).onItemRangeRemoved(i_renamed, i2);
            }
        }

        public void d_renamed(int i_renamed, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((androidx.recyclerview.widget.RecyclerView.c_renamed) this.mObservers.get(size)).onItemRangeMoved(i_renamed, i2, 1);
            }
        }
    }

    public static class SavedState extends androidx.customview.view.AbsSavedState {
        public static final android.os.Parcelable.Creator<androidx.recyclerview.widget.RecyclerView.SavedState> CREATOR = new android.os.Parcelable.ClassLoaderCreator<androidx.recyclerview.widget.RecyclerView.SavedState>() { // from class: androidx.recyclerview.widget.RecyclerView.SavedState.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public androidx.recyclerview.widget.RecyclerView.SavedState createFromParcel(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
                return new androidx.recyclerview.widget.RecyclerView.SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public androidx.recyclerview.widget.RecyclerView.SavedState createFromParcel(android.os.Parcel parcel) {
                return new androidx.recyclerview.widget.RecyclerView.SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public androidx.recyclerview.widget.RecyclerView.SavedState[] newArray(int i_renamed) {
                return new androidx.recyclerview.widget.RecyclerView.SavedState[i_renamed];
            }
        };
        android.os.Parcelable mLayoutState;

        SavedState(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
            super(parcel, classLoader);
            this.mLayoutState = parcel.readParcelable(classLoader == null ? androidx.recyclerview.widget.RecyclerView.i_renamed.class.getClassLoader() : classLoader);
        }

        SavedState(android.os.Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
            super.writeToParcel(parcel, i_renamed);
            parcel.writeParcelable(this.mLayoutState, 0);
        }

        void copyFrom(androidx.recyclerview.widget.RecyclerView.SavedState savedState) {
            this.mLayoutState = savedState.mLayoutState;
        }
    }

    public static class t_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        int f1435a = -1;

        /* renamed from: b_renamed, reason: collision with root package name */
        int f1436b = 0;

        /* renamed from: c_renamed, reason: collision with root package name */
        int f1437c = 0;
        int d_renamed = 1;
        int e_renamed = 0;
        boolean f_renamed = false;
        boolean g_renamed = false;
        boolean h_renamed = false;
        boolean i_renamed = false;
        boolean j_renamed = false;
        boolean k_renamed = false;
        int l_renamed;
        long m_renamed;
        int n_renamed;
        int o_renamed;
        int p_renamed;
        private android.util.SparseArray<java.lang.Object> q_renamed;

        void a_renamed(int i_renamed) {
            if ((this.d_renamed & i_renamed) != 0) {
                return;
            }
            throw new java.lang.IllegalStateException("Layout state should be_renamed one of_renamed " + java.lang.Integer.toBinaryString(i_renamed) + " but it is_renamed " + java.lang.Integer.toBinaryString(this.d_renamed));
        }

        void a_renamed(androidx.recyclerview.widget.RecyclerView.a_renamed aVar) {
            this.d_renamed = 1;
            this.e_renamed = aVar.getItemCount();
            this.g_renamed = false;
            this.h_renamed = false;
            this.i_renamed = false;
        }

        public boolean a_renamed() {
            return this.g_renamed;
        }

        public boolean b_renamed() {
            return this.k_renamed;
        }

        public int c_renamed() {
            return this.f1435a;
        }

        public boolean d_renamed() {
            return this.f1435a != -1;
        }

        public int e_renamed() {
            if (this.g_renamed) {
                return this.f1436b - this.f1437c;
            }
            return this.e_renamed;
        }

        public java.lang.String toString() {
            return "State{mTargetPosition=" + this.f1435a + ", mData=" + this.q_renamed + ", mItemCount=" + this.e_renamed + ", mIsMeasuring=" + this.i_renamed + ", mPreviousLayoutItemCount=" + this.f1436b + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f1437c + ", mStructureChanged=" + this.f_renamed + ", mInPreLayout=" + this.g_renamed + ", mRunSimpleAnimations=" + this.j_renamed + ", mRunPredictiveAnimations=" + this.k_renamed + '}';
        }
    }

    private class g_renamed implements androidx.recyclerview.widget.RecyclerView.f_renamed.b_renamed {
        g_renamed() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.f_renamed.b_renamed
        public void a_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
            wVar.setIsRecyclable(true);
            if (wVar.mShadowedHolder != null && wVar.mShadowingHolder == null) {
                wVar.mShadowedHolder = null;
            }
            wVar.mShadowingHolder = null;
            if (wVar.shouldBeKeptAsChild() || androidx.recyclerview.widget.RecyclerView.this.removeAnimatingView(wVar.itemView) || !wVar.isTmpDetached()) {
                return;
            }
            androidx.recyclerview.widget.RecyclerView.this.removeDetachedView(wVar.itemView, false);
        }
    }

    public static abstract class f_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private androidx.recyclerview.widget.RecyclerView.f_renamed.b_renamed f1410a = null;

        /* renamed from: b_renamed, reason: collision with root package name */
        private java.util.ArrayList<androidx.recyclerview.widget.RecyclerView.f_renamed.a_renamed> f1411b = new java.util.ArrayList<>();

        /* renamed from: c_renamed, reason: collision with root package name */
        private long f1412c = 120;
        private long d_renamed = 120;
        private long e_renamed = 250;
        private long f_renamed = 250;

        public interface a_renamed {
            void a_renamed();
        }

        interface b_renamed {
            void a_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar);
        }

        public abstract void a_renamed();

        public abstract boolean a_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar, androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed cVar, androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed cVar2);

        public abstract boolean a_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar, androidx.recyclerview.widget.RecyclerView.w_renamed wVar2, androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed cVar, androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed cVar2);

        public abstract boolean b_renamed();

        public abstract boolean b_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar, androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed cVar, androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed cVar2);

        public abstract boolean c_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar, androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed cVar, androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed cVar2);

        public abstract void d_renamed();

        public abstract void d_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar);

        public void g_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
        }

        public boolean h_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
            return true;
        }

        public long e_renamed() {
            return this.e_renamed;
        }

        public long f_renamed() {
            return this.f1412c;
        }

        public long g_renamed() {
            return this.d_renamed;
        }

        public long h_renamed() {
            return this.f_renamed;
        }

        public void a_renamed(long j_renamed) {
            this.f_renamed = j_renamed;
        }

        void a_renamed(androidx.recyclerview.widget.RecyclerView.f_renamed.b_renamed bVar) {
            this.f1410a = bVar;
        }

        public androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed a_renamed(androidx.recyclerview.widget.RecyclerView.t_renamed tVar, androidx.recyclerview.widget.RecyclerView.w_renamed wVar, int i_renamed, java.util.List<java.lang.Object> list) {
            return j_renamed().a_renamed(wVar);
        }

        public androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed a_renamed(androidx.recyclerview.widget.RecyclerView.t_renamed tVar, androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
            return j_renamed().a_renamed(wVar);
        }

        static int e_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
            int i_renamed = wVar.mFlags & 14;
            if (wVar.isInvalid()) {
                return 4;
            }
            if ((i_renamed & 4) != 0) {
                return i_renamed;
            }
            int oldPosition = wVar.getOldPosition();
            int absoluteAdapterPosition = wVar.getAbsoluteAdapterPosition();
            return (oldPosition == -1 || absoluteAdapterPosition == -1 || oldPosition == absoluteAdapterPosition) ? i_renamed : i_renamed | 2048;
        }

        public final void f_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
            g_renamed(wVar);
            androidx.recyclerview.widget.RecyclerView.f_renamed.b_renamed bVar = this.f1410a;
            if (bVar != null) {
                bVar.a_renamed(wVar);
            }
        }

        public boolean a_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar, java.util.List<java.lang.Object> list) {
            return h_renamed(wVar);
        }

        public final void i_renamed() {
            int size = this.f1411b.size();
            for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                this.f1411b.get(i_renamed).a_renamed();
            }
            this.f1411b.clear();
        }

        public androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed j_renamed() {
            return new androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed();
        }

        public static class c_renamed {

            /* renamed from: a_renamed, reason: collision with root package name */
            public int f1413a;

            /* renamed from: b_renamed, reason: collision with root package name */
            public int f1414b;

            /* renamed from: c_renamed, reason: collision with root package name */
            public int f1415c;
            public int d_renamed;

            public androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed a_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
                return a_renamed(wVar, 0);
            }

            public androidx.recyclerview.widget.RecyclerView.f_renamed.c_renamed a_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar, int i_renamed) {
                android.view.View view = wVar.itemView;
                this.f1413a = view.getLeft();
                this.f1414b = view.getTop();
                this.f1415c = view.getRight();
                this.d_renamed = view.getBottom();
                return this;
            }
        }
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i2, int i3) {
        androidx.recyclerview.widget.RecyclerView.d_renamed dVar = this.mChildDrawingOrderCallback;
        if (dVar == null) {
            return super.getChildDrawingOrder(i2, i3);
        }
        return dVar.a_renamed(i2, i3);
    }

    private androidx.core.h_renamed.l_renamed getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            this.mScrollingChildHelper = new androidx.core.h_renamed.l_renamed(this);
        }
        return this.mScrollingChildHelper;
    }
}
