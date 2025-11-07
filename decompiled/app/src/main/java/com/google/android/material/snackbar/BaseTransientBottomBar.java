package com.google.android.material.snackbar;

/* loaded from: classes.dex */
public abstract class BaseTransientBottomBar<B_renamed extends com.google.android.material.snackbar.BaseTransientBottomBar<B_renamed>> {
    static final int ANIMATION_DURATION = 250;
    static final int ANIMATION_FADE_DURATION = 180;
    private static final int ANIMATION_FADE_IN_DURATION = 150;
    private static final int ANIMATION_FADE_OUT_DURATION = 75;
    public static final int ANIMATION_MODE_FADE = 1;
    public static final int ANIMATION_MODE_SLIDE = 0;
    private static final float ANIMATION_SCALE_FROM_VALUE = 0.8f;
    public static final int LENGTH_INDEFINITE = -2;
    public static final int LENGTH_LONG = 0;
    public static final int LENGTH_SHORT = -1;
    static final int MSG_DISMISS = 1;
    static final int MSG_SHOW = 0;
    private static final int[] SNACKBAR_STYLE_ATTR;
    private static final java.lang.String TAG;
    private static final boolean USE_OFFSET_API;
    static final android.os.Handler handler;
    private final android.view.accessibility.AccessibilityManager accessibilityManager;
    private android.view.View anchorView;
    private com.google.android.material.snackbar.BaseTransientBottomBar.Behavior behavior;
    private java.util.List<com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback<B_renamed>> callbacks;
    private final com.google.android.material.snackbar.ContentViewCallback contentViewCallback;
    private final android.content.Context context;
    private int duration;
    private int extraBottomMarginAnchorView;
    private int extraBottomMarginGestureInset;
    private int extraBottomMarginWindowInset;
    private int extraLeftMarginWindowInset;
    private int extraRightMarginWindowInset;
    private boolean gestureInsetBottomIgnored;
    private android.graphics.Rect originalMargins;
    private final android.view.ViewGroup targetParent;
    protected final com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout view;
    private final java.lang.Runnable bottomMarginGestureInsetRunnable = new java.lang.Runnable() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.2
        @Override // java.lang.Runnable
        public void run() {
            int screenHeight;
            if (com.google.android.material.snackbar.BaseTransientBottomBar.this.view == null || com.google.android.material.snackbar.BaseTransientBottomBar.this.context == null || (screenHeight = (com.google.android.material.snackbar.BaseTransientBottomBar.this.getScreenHeight() - com.google.android.material.snackbar.BaseTransientBottomBar.this.getViewAbsoluteBottom()) + ((int) com.google.android.material.snackbar.BaseTransientBottomBar.this.view.getTranslationY())) >= com.google.android.material.snackbar.BaseTransientBottomBar.this.extraBottomMarginGestureInset) {
                return;
            }
            android.view.ViewGroup.LayoutParams layoutParams = com.google.android.material.snackbar.BaseTransientBottomBar.this.view.getLayoutParams();
            if (!(layoutParams instanceof android.view.ViewGroup.MarginLayoutParams)) {
                android.util.Log.w_renamed(com.google.android.material.snackbar.BaseTransientBottomBar.TAG, "Unable to apply gesture inset because layout params are not MarginLayoutParams");
                return;
            }
            ((android.view.ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += com.google.android.material.snackbar.BaseTransientBottomBar.this.extraBottomMarginGestureInset - screenHeight;
            com.google.android.material.snackbar.BaseTransientBottomBar.this.view.requestLayout();
        }
    };
    com.google.android.material.snackbar.SnackbarManager.Callback managerCallback = new com.google.android.material.snackbar.SnackbarManager.Callback() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.5
        @Override // com.google.android.material.snackbar.SnackbarManager.Callback
        public void show() {
            com.google.android.material.snackbar.BaseTransientBottomBar.handler.sendMessage(com.google.android.material.snackbar.BaseTransientBottomBar.handler.obtainMessage(0, com.google.android.material.snackbar.BaseTransientBottomBar.this));
        }

        @Override // com.google.android.material.snackbar.SnackbarManager.Callback
        public void dismiss(int i_renamed) {
            com.google.android.material.snackbar.BaseTransientBottomBar.handler.sendMessage(com.google.android.material.snackbar.BaseTransientBottomBar.handler.obtainMessage(1, i_renamed, 0, com.google.android.material.snackbar.BaseTransientBottomBar.this));
        }
    };

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface AnimationMode {
    }

    public static abstract class BaseCallback<B_renamed> {
        public static final int DISMISS_EVENT_ACTION = 1;
        public static final int DISMISS_EVENT_CONSECUTIVE = 4;
        public static final int DISMISS_EVENT_MANUAL = 3;
        public static final int DISMISS_EVENT_SWIPE = 0;
        public static final int DISMISS_EVENT_TIMEOUT = 2;

        @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
        public @interface DismissEvent {
        }

        public void onDismissed(B_renamed b2, int i_renamed) {
        }

        public void onShown(B_renamed b2) {
        }
    }

    @java.lang.Deprecated
    public interface ContentViewCallback extends com.google.android.material.snackbar.ContentViewCallback {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Duration {
    }

    protected interface OnAttachStateChangeListener {
        void onViewAttachedToWindow(android.view.View view);

        void onViewDetachedFromWindow(android.view.View view);
    }

    protected interface OnLayoutChangeListener {
        void onLayoutChange(android.view.View view, int i_renamed, int i2, int i3, int i4);
    }

    static {
        USE_OFFSET_API = android.os.Build.VERSION.SDK_INT >= 16 && android.os.Build.VERSION.SDK_INT <= 19;
        SNACKBAR_STYLE_ATTR = new int[]{com.google.android.material.R_renamed.attr.snackbarStyle};
        TAG = com.google.android.material.snackbar.BaseTransientBottomBar.class.getSimpleName();
        handler = new android.os.Handler(android.os.Looper.getMainLooper(), new android.os.Handler.Callback() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(android.os.Message message) {
                int i_renamed = message.what;
                if (i_renamed == 0) {
                    ((com.google.android.material.snackbar.BaseTransientBottomBar) message.obj).showView();
                    return true;
                }
                if (i_renamed != 1) {
                    return false;
                }
                ((com.google.android.material.snackbar.BaseTransientBottomBar) message.obj).hideView(message.arg1);
                return true;
            }
        });
    }

    protected BaseTransientBottomBar(android.view.ViewGroup viewGroup, android.view.View view, com.google.android.material.snackbar.ContentViewCallback contentViewCallback) {
        if (viewGroup == null) {
            throw new java.lang.IllegalArgumentException("Transient bottom bar must have non-null parent");
        }
        if (view == null) {
            throw new java.lang.IllegalArgumentException("Transient bottom bar must have non-null content");
        }
        if (contentViewCallback == null) {
            throw new java.lang.IllegalArgumentException("Transient bottom bar must have non-null callback");
        }
        this.targetParent = viewGroup;
        this.contentViewCallback = contentViewCallback;
        this.context = viewGroup.getContext();
        com.google.android.material.internal.ThemeEnforcement.checkAppCompatTheme(this.context);
        this.view = (com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout) android.view.LayoutInflater.from(this.context).inflate(getSnackbarBaseLayoutResId(), this.targetParent, false);
        if (view instanceof com.google.android.material.snackbar.SnackbarContentLayout) {
            ((com.google.android.material.snackbar.SnackbarContentLayout) view).updateActionTextColorAlphaIfNeeded(this.view.getActionTextColorAlpha());
        }
        this.view.addView(view);
        android.view.ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
        if (layoutParams instanceof android.view.ViewGroup.MarginLayoutParams) {
            android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) layoutParams;
            this.originalMargins = new android.graphics.Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }
        androidx.core.h_renamed.v_renamed.d_renamed(this.view, 1);
        androidx.core.h_renamed.v_renamed.b_renamed((android.view.View) this.view, 1);
        androidx.core.h_renamed.v_renamed.b_renamed((android.view.View) this.view, true);
        androidx.core.h_renamed.v_renamed.a_renamed(this.view, new androidx.core.h_renamed.q_renamed() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.3
            @Override // androidx.core.h_renamed.q_renamed
            public androidx.core.h_renamed.ad_renamed onApplyWindowInsets(android.view.View view2, androidx.core.h_renamed.ad_renamed adVar) {
                com.google.android.material.snackbar.BaseTransientBottomBar.this.extraBottomMarginWindowInset = adVar.d_renamed();
                com.google.android.material.snackbar.BaseTransientBottomBar.this.extraLeftMarginWindowInset = adVar.a_renamed();
                com.google.android.material.snackbar.BaseTransientBottomBar.this.extraRightMarginWindowInset = adVar.c_renamed();
                com.google.android.material.snackbar.BaseTransientBottomBar.this.updateMargins();
                return adVar;
            }
        });
        androidx.core.h_renamed.v_renamed.a_renamed(this.view, new androidx.core.h_renamed.a_renamed() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.4
            @Override // androidx.core.h_renamed.a_renamed
            public void onInitializeAccessibilityNodeInfo(android.view.View view2, androidx.core.h_renamed.a_renamed.d_renamed dVar) {
                super.onInitializeAccessibilityNodeInfo(view2, dVar);
                dVar.a_renamed(com.google.android.exoplayer2.source.ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES);
                dVar.j_renamed(true);
            }

            @Override // androidx.core.h_renamed.a_renamed
            public boolean performAccessibilityAction(android.view.View view2, int i_renamed, android.os.Bundle bundle) {
                if (i_renamed == 1048576) {
                    com.google.android.material.snackbar.BaseTransientBottomBar.this.dismiss();
                    return true;
                }
                return super.performAccessibilityAction(view2, i_renamed, bundle);
            }
        });
        this.accessibilityManager = (android.view.accessibility.AccessibilityManager) this.context.getSystemService("accessibility");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMargins() {
        android.view.ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
        if (!(layoutParams instanceof android.view.ViewGroup.MarginLayoutParams) || this.originalMargins == null) {
            android.util.Log.w_renamed(TAG, "Unable to update margins because layout params are not MarginLayoutParams");
            return;
        }
        android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.bottomMargin = this.originalMargins.bottom + (this.anchorView != null ? this.extraBottomMarginAnchorView : this.extraBottomMarginWindowInset);
        marginLayoutParams.leftMargin = this.originalMargins.left + this.extraLeftMarginWindowInset;
        marginLayoutParams.rightMargin = this.originalMargins.right + this.extraRightMarginWindowInset;
        this.view.requestLayout();
        if (android.os.Build.VERSION.SDK_INT < 29 || !shouldUpdateGestureInset()) {
            return;
        }
        this.view.removeCallbacks(this.bottomMarginGestureInsetRunnable);
        this.view.post(this.bottomMarginGestureInsetRunnable);
    }

    private boolean shouldUpdateGestureInset() {
        return this.extraBottomMarginGestureInset > 0 && !this.gestureInsetBottomIgnored && isSwipeDismissable();
    }

    private boolean isSwipeDismissable() {
        android.view.ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
        return (layoutParams instanceof androidx.coordinatorlayout.widget.CoordinatorLayout.e_renamed) && (((androidx.coordinatorlayout.widget.CoordinatorLayout.e_renamed) layoutParams).b_renamed() instanceof com.google.android.material.behavior.SwipeDismissBehavior);
    }

    protected int getSnackbarBaseLayoutResId() {
        return hasSnackbarStyleAttr() ? com.google.android.material.R_renamed.layout.mtrl_layout_snackbar : com.google.android.material.R_renamed.layout.design_layout_snackbar;
    }

    protected boolean hasSnackbarStyleAttr() {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = this.context.obtainStyledAttributes(SNACKBAR_STYLE_ATTR);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != -1;
    }

    public B_renamed setDuration(int i_renamed) {
        this.duration = i_renamed;
        return this;
    }

    public int getDuration() {
        return this.duration;
    }

    public B_renamed setGestureInsetBottomIgnored(boolean z_renamed) {
        this.gestureInsetBottomIgnored = z_renamed;
        return this;
    }

    public boolean isGestureInsetBottomIgnored() {
        return this.gestureInsetBottomIgnored;
    }

    public int getAnimationMode() {
        return this.view.getAnimationMode();
    }

    public B_renamed setAnimationMode(int i_renamed) {
        this.view.setAnimationMode(i_renamed);
        return this;
    }

    public android.view.View getAnchorView() {
        return this.anchorView;
    }

    public B_renamed setAnchorView(android.view.View view) {
        this.anchorView = view;
        return this;
    }

    public B_renamed setAnchorView(int i_renamed) {
        this.anchorView = this.targetParent.findViewById(i_renamed);
        if (this.anchorView != null) {
            return this;
        }
        throw new java.lang.IllegalArgumentException("Unable to find anchor view with id_renamed: " + i_renamed);
    }

    public B_renamed setBehavior(com.google.android.material.snackbar.BaseTransientBottomBar.Behavior behavior) {
        this.behavior = behavior;
        return this;
    }

    public com.google.android.material.snackbar.BaseTransientBottomBar.Behavior getBehavior() {
        return this.behavior;
    }

    public android.content.Context getContext() {
        return this.context;
    }

    public android.view.View getView() {
        return this.view;
    }

    public void show() {
        com.google.android.material.snackbar.SnackbarManager.getInstance().show(getDuration(), this.managerCallback);
    }

    public void dismiss() {
        dispatchDismiss(3);
    }

    protected void dispatchDismiss(int i_renamed) {
        com.google.android.material.snackbar.SnackbarManager.getInstance().dismiss(this.managerCallback, i_renamed);
    }

    public B_renamed addCallback(com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback<B_renamed> baseCallback) {
        if (baseCallback == null) {
            return this;
        }
        if (this.callbacks == null) {
            this.callbacks = new java.util.ArrayList();
        }
        this.callbacks.add(baseCallback);
        return this;
    }

    public B_renamed removeCallback(com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback<B_renamed> baseCallback) {
        java.util.List<com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback<B_renamed>> list;
        if (baseCallback == null || (list = this.callbacks) == null) {
            return this;
        }
        list.remove(baseCallback);
        return this;
    }

    public boolean isShown() {
        return com.google.android.material.snackbar.SnackbarManager.getInstance().isCurrent(this.managerCallback);
    }

    public boolean isShownOrQueued() {
        return com.google.android.material.snackbar.SnackbarManager.getInstance().isCurrentOrNext(this.managerCallback);
    }

    protected com.google.android.material.behavior.SwipeDismissBehavior<? extends android.view.View> getNewBehavior() {
        return new com.google.android.material.snackbar.BaseTransientBottomBar.Behavior();
    }

    final void showView() {
        this.view.setOnAttachStateChangeListener(new com.google.android.material.snackbar.BaseTransientBottomBar.OnAttachStateChangeListener() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.6
            @Override // com.google.android.material.snackbar.BaseTransientBottomBar.OnAttachStateChangeListener
            public void onViewAttachedToWindow(android.view.View view) {
                android.view.WindowInsets rootWindowInsets;
                if (android.os.Build.VERSION.SDK_INT < 29 || (rootWindowInsets = com.google.android.material.snackbar.BaseTransientBottomBar.this.view.getRootWindowInsets()) == null) {
                    return;
                }
                com.google.android.material.snackbar.BaseTransientBottomBar.this.extraBottomMarginGestureInset = rootWindowInsets.getMandatorySystemGestureInsets().bottom;
                com.google.android.material.snackbar.BaseTransientBottomBar.this.updateMargins();
            }

            @Override // com.google.android.material.snackbar.BaseTransientBottomBar.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(android.view.View view) {
                if (com.google.android.material.snackbar.BaseTransientBottomBar.this.isShownOrQueued()) {
                    com.google.android.material.snackbar.BaseTransientBottomBar.handler.post(new java.lang.Runnable() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.google.android.material.snackbar.BaseTransientBottomBar.this.onViewHidden(3);
                        }
                    });
                }
            }
        });
        if (this.view.getParent() == null) {
            android.view.ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
            if (layoutParams instanceof androidx.coordinatorlayout.widget.CoordinatorLayout.e_renamed) {
                setUpBehavior((androidx.coordinatorlayout.widget.CoordinatorLayout.e_renamed) layoutParams);
            }
            this.extraBottomMarginAnchorView = calculateBottomMarginForAnchorView();
            updateMargins();
            this.view.setVisibility(4);
            this.targetParent.addView(this.view);
        }
        if (androidx.core.h_renamed.v_renamed.A_renamed(this.view)) {
            showViewImpl();
        } else {
            this.view.setOnLayoutChangeListener(new com.google.android.material.snackbar.BaseTransientBottomBar.OnLayoutChangeListener() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.7
                @Override // com.google.android.material.snackbar.BaseTransientBottomBar.OnLayoutChangeListener
                public void onLayoutChange(android.view.View view, int i_renamed, int i2, int i3, int i4) {
                    com.google.android.material.snackbar.BaseTransientBottomBar.this.view.setOnLayoutChangeListener(null);
                    com.google.android.material.snackbar.BaseTransientBottomBar.this.showViewImpl();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showViewImpl() {
        if (shouldAnimate()) {
            animateViewIn();
        } else {
            this.view.setVisibility(0);
            onViewShown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getViewAbsoluteBottom() {
        int[] iArr = new int[2];
        this.view.getLocationOnScreen(iArr);
        return iArr[1] + this.view.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getScreenHeight() {
        android.view.WindowManager windowManager = (android.view.WindowManager) this.context.getSystemService("window");
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    private void setUpBehavior(androidx.coordinatorlayout.widget.CoordinatorLayout.e_renamed eVar) {
        com.google.android.material.behavior.SwipeDismissBehavior<? extends android.view.View> newBehavior = this.behavior;
        if (newBehavior == null) {
            newBehavior = getNewBehavior();
        }
        if (newBehavior instanceof com.google.android.material.snackbar.BaseTransientBottomBar.Behavior) {
            ((com.google.android.material.snackbar.BaseTransientBottomBar.Behavior) newBehavior).setBaseTransientBottomBar(this);
        }
        newBehavior.setListener(new com.google.android.material.behavior.SwipeDismissBehavior.OnDismissListener() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.8
            @Override // com.google.android.material.behavior.SwipeDismissBehavior.OnDismissListener
            public void onDismiss(android.view.View view) {
                view.setVisibility(8);
                com.google.android.material.snackbar.BaseTransientBottomBar.this.dispatchDismiss(0);
            }

            @Override // com.google.android.material.behavior.SwipeDismissBehavior.OnDismissListener
            public void onDragStateChanged(int i_renamed) {
                if (i_renamed == 0) {
                    com.google.android.material.snackbar.SnackbarManager.getInstance().restoreTimeoutIfPaused(com.google.android.material.snackbar.BaseTransientBottomBar.this.managerCallback);
                } else if (i_renamed == 1 || i_renamed == 2) {
                    com.google.android.material.snackbar.SnackbarManager.getInstance().pauseTimeout(com.google.android.material.snackbar.BaseTransientBottomBar.this.managerCallback);
                }
            }
        });
        eVar.a_renamed(newBehavior);
        if (this.anchorView == null) {
            eVar.g_renamed = 80;
        }
    }

    private int calculateBottomMarginForAnchorView() {
        android.view.View view = this.anchorView;
        if (view == null) {
            return 0;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i_renamed = iArr[1];
        int[] iArr2 = new int[2];
        this.targetParent.getLocationOnScreen(iArr2);
        return (iArr2[1] + this.targetParent.getHeight()) - i_renamed;
    }

    void animateViewIn() {
        this.view.post(new java.lang.Runnable() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.9
            @Override // java.lang.Runnable
            public void run() {
                if (com.google.android.material.snackbar.BaseTransientBottomBar.this.view == null) {
                    return;
                }
                com.google.android.material.snackbar.BaseTransientBottomBar.this.view.setVisibility(0);
                if (com.google.android.material.snackbar.BaseTransientBottomBar.this.view.getAnimationMode() == 1) {
                    com.google.android.material.snackbar.BaseTransientBottomBar.this.startFadeInAnimation();
                } else {
                    com.google.android.material.snackbar.BaseTransientBottomBar.this.startSlideInAnimation();
                }
            }
        });
    }

    private void animateViewOut(int i_renamed) {
        if (this.view.getAnimationMode() == 1) {
            startFadeOutAnimation(i_renamed);
        } else {
            startSlideOutAnimation(i_renamed);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startFadeInAnimation() {
        android.animation.ValueAnimator alphaAnimator = getAlphaAnimator(0.0f, 1.0f);
        android.animation.ValueAnimator scaleAnimator = getScaleAnimator(ANIMATION_SCALE_FROM_VALUE, 1.0f);
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        animatorSet.playTogether(alphaAnimator, scaleAnimator);
        animatorSet.setDuration(150L);
        animatorSet.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.10
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.google.android.material.snackbar.BaseTransientBottomBar.this.onViewShown();
            }
        });
        animatorSet.start();
    }

    private void startFadeOutAnimation(final int i_renamed) {
        android.animation.ValueAnimator alphaAnimator = getAlphaAnimator(1.0f, 0.0f);
        alphaAnimator.setDuration(75L);
        alphaAnimator.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.11
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.google.android.material.snackbar.BaseTransientBottomBar.this.onViewHidden(i_renamed);
            }
        });
        alphaAnimator.start();
    }

    private android.animation.ValueAnimator getAlphaAnimator(float... fArr) {
        android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(com.google.android.material.animation.AnimationUtils.LINEAR_INTERPOLATOR);
        valueAnimatorOfFloat.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.12
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.google.android.material.snackbar.BaseTransientBottomBar.this.view.setAlpha(((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        return valueAnimatorOfFloat;
    }

    private android.animation.ValueAnimator getScaleAnimator(float... fArr) {
        android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(com.google.android.material.animation.AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        valueAnimatorOfFloat.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                float fFloatValue = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                com.google.android.material.snackbar.BaseTransientBottomBar.this.view.setScaleX(fFloatValue);
                com.google.android.material.snackbar.BaseTransientBottomBar.this.view.setScaleY(fFloatValue);
            }
        });
        return valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSlideInAnimation() {
        final int translationYBottom = getTranslationYBottom();
        if (USE_OFFSET_API) {
            androidx.core.h_renamed.v_renamed.e_renamed(this.view, translationYBottom);
        } else {
            this.view.setTranslationY(translationYBottom);
        }
        android.animation.ValueAnimator valueAnimator = new android.animation.ValueAnimator();
        valueAnimator.setIntValues(translationYBottom, 0);
        valueAnimator.setInterpolator(com.google.android.material.animation.AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.14
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                com.google.android.material.snackbar.BaseTransientBottomBar.this.contentViewCallback.animateContentIn(70, 180);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.google.android.material.snackbar.BaseTransientBottomBar.this.onViewShown();
            }
        });
        valueAnimator.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.15
            private int previousAnimatedIntValue;

            {
                this.previousAnimatedIntValue = translationYBottom;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator2) {
                int iIntValue = ((java.lang.Integer) valueAnimator2.getAnimatedValue()).intValue();
                if (com.google.android.material.snackbar.BaseTransientBottomBar.USE_OFFSET_API) {
                    androidx.core.h_renamed.v_renamed.e_renamed(com.google.android.material.snackbar.BaseTransientBottomBar.this.view, iIntValue - this.previousAnimatedIntValue);
                } else {
                    com.google.android.material.snackbar.BaseTransientBottomBar.this.view.setTranslationY(iIntValue);
                }
                this.previousAnimatedIntValue = iIntValue;
            }
        });
        valueAnimator.start();
    }

    private void startSlideOutAnimation(final int i_renamed) {
        android.animation.ValueAnimator valueAnimator = new android.animation.ValueAnimator();
        valueAnimator.setIntValues(0, getTranslationYBottom());
        valueAnimator.setInterpolator(com.google.android.material.animation.AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.16
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                com.google.android.material.snackbar.BaseTransientBottomBar.this.contentViewCallback.animateContentOut(0, 180);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.google.android.material.snackbar.BaseTransientBottomBar.this.onViewHidden(i_renamed);
            }
        });
        valueAnimator.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.17
            private int previousAnimatedIntValue = 0;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator2) {
                int iIntValue = ((java.lang.Integer) valueAnimator2.getAnimatedValue()).intValue();
                if (com.google.android.material.snackbar.BaseTransientBottomBar.USE_OFFSET_API) {
                    androidx.core.h_renamed.v_renamed.e_renamed(com.google.android.material.snackbar.BaseTransientBottomBar.this.view, iIntValue - this.previousAnimatedIntValue);
                } else {
                    com.google.android.material.snackbar.BaseTransientBottomBar.this.view.setTranslationY(iIntValue);
                }
                this.previousAnimatedIntValue = iIntValue;
            }
        });
        valueAnimator.start();
    }

    private int getTranslationYBottom() {
        int height = this.view.getHeight();
        android.view.ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
        return layoutParams instanceof android.view.ViewGroup.MarginLayoutParams ? height + ((android.view.ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
    }

    final void hideView(int i_renamed) {
        if (shouldAnimate() && this.view.getVisibility() == 0) {
            animateViewOut(i_renamed);
        } else {
            onViewHidden(i_renamed);
        }
    }

    void onViewShown() {
        com.google.android.material.snackbar.SnackbarManager.getInstance().onShown(this.managerCallback);
        java.util.List<com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback<B_renamed>> list = this.callbacks;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.callbacks.get(size).onShown(this);
            }
        }
    }

    void onViewHidden(int i_renamed) {
        com.google.android.material.snackbar.SnackbarManager.getInstance().onDismissed(this.managerCallback);
        java.util.List<com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback<B_renamed>> list = this.callbacks;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.callbacks.get(size).onDismissed(this, i_renamed);
            }
        }
        android.view.ViewParent parent = this.view.getParent();
        if (parent instanceof android.view.ViewGroup) {
            ((android.view.ViewGroup) parent).removeView(this.view);
        }
    }

    boolean shouldAnimate() {
        java.util.List<android.accessibilityservice.AccessibilityServiceInfo> enabledAccessibilityServiceList = this.accessibilityManager.getEnabledAccessibilityServiceList(1);
        return enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.isEmpty();
    }

    protected static class SnackbarBaseLayout extends android.widget.FrameLayout {
        private static final android.view.View.OnTouchListener consumeAllTouchListener = new android.view.View.OnTouchListener() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout.1
            @Override // android.view.View.OnTouchListener
            @android.annotation.SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
                return true;
            }
        };
        private final float actionTextColorAlpha;
        private int animationMode;
        private final float backgroundOverlayColorAlpha;
        private android.content.res.ColorStateList backgroundTint;
        private android.graphics.PorterDuff.Mode backgroundTintMode;
        private com.google.android.material.snackbar.BaseTransientBottomBar.OnAttachStateChangeListener onAttachStateChangeListener;
        private com.google.android.material.snackbar.BaseTransientBottomBar.OnLayoutChangeListener onLayoutChangeListener;

        protected SnackbarBaseLayout(android.content.Context context) {
            this(context, null);
        }

        protected SnackbarBaseLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
            super(com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(context, attributeSet, 0, 0), attributeSet);
            android.content.Context context2 = getContext();
            android.content.res.TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, com.google.android.material.R_renamed.styleable.SnackbarLayout);
            if (typedArrayObtainStyledAttributes.hasValue(com.google.android.material.R_renamed.styleable.SnackbarLayout_elevation)) {
                androidx.core.h_renamed.v_renamed.a_renamed(this, typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R_renamed.styleable.SnackbarLayout_elevation, 0));
            }
            this.animationMode = typedArrayObtainStyledAttributes.getInt(com.google.android.material.R_renamed.styleable.SnackbarLayout_animationMode, 0);
            this.backgroundOverlayColorAlpha = typedArrayObtainStyledAttributes.getFloat(com.google.android.material.R_renamed.styleable.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
            setBackgroundTintList(com.google.android.material.resources.MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.SnackbarLayout_backgroundTint));
            setBackgroundTintMode(com.google.android.material.internal.ViewUtils.parseTintMode(typedArrayObtainStyledAttributes.getInt(com.google.android.material.R_renamed.styleable.SnackbarLayout_backgroundTintMode, -1), android.graphics.PorterDuff.Mode.SRC_IN));
            this.actionTextColorAlpha = typedArrayObtainStyledAttributes.getFloat(com.google.android.material.R_renamed.styleable.SnackbarLayout_actionTextColorAlpha, 1.0f);
            typedArrayObtainStyledAttributes.recycle();
            setOnTouchListener(consumeAllTouchListener);
            setFocusable(true);
            if (getBackground() == null) {
                androidx.core.h_renamed.v_renamed.a_renamed(this, createThemedBackground());
            }
        }

        @Override // android.view.View
        public void setBackground(android.graphics.drawable.Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(android.graphics.drawable.Drawable drawable) {
            if (drawable != null && this.backgroundTint != null) {
                drawable = androidx.core.graphics.drawable.a_renamed.g_renamed(drawable.mutate());
                androidx.core.graphics.drawable.a_renamed.a_renamed(drawable, this.backgroundTint);
                androidx.core.graphics.drawable.a_renamed.a_renamed(drawable, this.backgroundTintMode);
            }
            super.setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundTintList(android.content.res.ColorStateList colorStateList) {
            this.backgroundTint = colorStateList;
            if (getBackground() != null) {
                android.graphics.drawable.Drawable drawableG = androidx.core.graphics.drawable.a_renamed.g_renamed(getBackground().mutate());
                androidx.core.graphics.drawable.a_renamed.a_renamed(drawableG, colorStateList);
                androidx.core.graphics.drawable.a_renamed.a_renamed(drawableG, this.backgroundTintMode);
                if (drawableG != getBackground()) {
                    super.setBackgroundDrawable(drawableG);
                }
            }
        }

        @Override // android.view.View
        public void setBackgroundTintMode(android.graphics.PorterDuff.Mode mode) {
            this.backgroundTintMode = mode;
            if (getBackground() != null) {
                android.graphics.drawable.Drawable drawableG = androidx.core.graphics.drawable.a_renamed.g_renamed(getBackground().mutate());
                androidx.core.graphics.drawable.a_renamed.a_renamed(drawableG, mode);
                if (drawableG != getBackground()) {
                    super.setBackgroundDrawable(drawableG);
                }
            }
        }

        @Override // android.view.View
        public void setOnClickListener(android.view.View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : consumeAllTouchListener);
            super.setOnClickListener(onClickListener);
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z_renamed, int i_renamed, int i2, int i3, int i4) {
            super.onLayout(z_renamed, i_renamed, i2, i3, i4);
            com.google.android.material.snackbar.BaseTransientBottomBar.OnLayoutChangeListener onLayoutChangeListener = this.onLayoutChangeListener;
            if (onLayoutChangeListener != null) {
                onLayoutChangeListener.onLayoutChange(this, i_renamed, i2, i3, i4);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            com.google.android.material.snackbar.BaseTransientBottomBar.OnAttachStateChangeListener onAttachStateChangeListener = this.onAttachStateChangeListener;
            if (onAttachStateChangeListener != null) {
                onAttachStateChangeListener.onViewAttachedToWindow(this);
            }
            androidx.core.h_renamed.v_renamed.s_renamed(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            com.google.android.material.snackbar.BaseTransientBottomBar.OnAttachStateChangeListener onAttachStateChangeListener = this.onAttachStateChangeListener;
            if (onAttachStateChangeListener != null) {
                onAttachStateChangeListener.onViewDetachedFromWindow(this);
            }
        }

        void setOnLayoutChangeListener(com.google.android.material.snackbar.BaseTransientBottomBar.OnLayoutChangeListener onLayoutChangeListener) {
            this.onLayoutChangeListener = onLayoutChangeListener;
        }

        void setOnAttachStateChangeListener(com.google.android.material.snackbar.BaseTransientBottomBar.OnAttachStateChangeListener onAttachStateChangeListener) {
            this.onAttachStateChangeListener = onAttachStateChangeListener;
        }

        int getAnimationMode() {
            return this.animationMode;
        }

        void setAnimationMode(int i_renamed) {
            this.animationMode = i_renamed;
        }

        float getBackgroundOverlayColorAlpha() {
            return this.backgroundOverlayColorAlpha;
        }

        float getActionTextColorAlpha() {
            return this.actionTextColorAlpha;
        }

        private android.graphics.drawable.Drawable createThemedBackground() throws android.content.res.Resources.NotFoundException {
            float dimension = getResources().getDimension(com.google.android.material.R_renamed.dimen.mtrl_snackbar_background_corner_radius);
            android.graphics.drawable.GradientDrawable gradientDrawable = new android.graphics.drawable.GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(dimension);
            gradientDrawable.setColor(com.google.android.material.color.MaterialColors.layer(this, com.google.android.material.R_renamed.attr.colorSurface, com.google.android.material.R_renamed.attr.colorOnSurface, getBackgroundOverlayColorAlpha()));
            if (this.backgroundTint != null) {
                android.graphics.drawable.Drawable drawableG = androidx.core.graphics.drawable.a_renamed.g_renamed(gradientDrawable);
                androidx.core.graphics.drawable.a_renamed.a_renamed(drawableG, this.backgroundTint);
                return drawableG;
            }
            return androidx.core.graphics.drawable.a_renamed.g_renamed(gradientDrawable);
        }
    }

    public static class Behavior extends com.google.android.material.behavior.SwipeDismissBehavior<android.view.View> {
        private final com.google.android.material.snackbar.BaseTransientBottomBar.BehaviorDelegate delegate = new com.google.android.material.snackbar.BaseTransientBottomBar.BehaviorDelegate(this);

        /* JADX INFO: Access modifiers changed from: private */
        public void setBaseTransientBottomBar(com.google.android.material.snackbar.BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.delegate.setBaseTransientBottomBar(baseTransientBottomBar);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean canSwipeDismissView(android.view.View view) {
            return this.delegate.canSwipeDismissView(view);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
        public boolean onInterceptTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, android.view.View view, android.view.MotionEvent motionEvent) {
            this.delegate.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
            return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
        }
    }

    public static class BehaviorDelegate {
        private com.google.android.material.snackbar.SnackbarManager.Callback managerCallback;

        public BehaviorDelegate(com.google.android.material.behavior.SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.setStartAlphaSwipeDistance(0.1f);
            swipeDismissBehavior.setEndAlphaSwipeDistance(0.6f);
            swipeDismissBehavior.setSwipeDirection(0);
        }

        public void setBaseTransientBottomBar(com.google.android.material.snackbar.BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.managerCallback = baseTransientBottomBar.managerCallback;
        }

        public boolean canSwipeDismissView(android.view.View view) {
            return view instanceof com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout;
        }

        public void onInterceptTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, android.view.View view, android.view.MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                if (coordinatorLayout.isPointInChildBounds(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    com.google.android.material.snackbar.SnackbarManager.getInstance().pauseTimeout(this.managerCallback);
                }
            } else if (actionMasked == 1 || actionMasked == 3) {
                com.google.android.material.snackbar.SnackbarManager.getInstance().restoreTimeoutIfPaused(this.managerCallback);
            }
        }
    }
}
