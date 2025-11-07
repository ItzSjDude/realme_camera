package com.google.android.material.bottomsheet;

/* loaded from: classes.dex */
public class BottomSheetBehavior<V_renamed extends android.view.View> extends androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed<V_renamed> {
    private static final int CORNER_ANIMATION_DURATION = 500;
    private static final int DEF_STYLE_RES = com.google.android.material.R_renamed.style.Widget_Design_BottomSheet_Modal;
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    public static final int PEEK_HEIGHT_AUTO = -1;
    public static final int SAVE_ALL = -1;
    public static final int SAVE_FIT_TO_CONTENTS = 2;
    public static final int SAVE_HIDEABLE = 4;
    public static final int SAVE_NONE = 0;
    public static final int SAVE_PEEK_HEIGHT = 1;
    public static final int SAVE_SKIP_COLLAPSED = 8;
    private static final int SIGNIFICANT_VEL_THRESHOLD = 500;
    public static final int STATE_COLLAPSED = 4;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_EXPANDED = 3;
    public static final int STATE_HALF_EXPANDED = 6;
    public static final int STATE_HIDDEN = 5;
    public static final int STATE_SETTLING = 2;
    private static final java.lang.String TAG = "BottomSheetBehavior";
    int activePointerId;
    private final java.util.ArrayList<com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback> callbacks;
    int collapsedOffset;
    private final androidx.customview.a_renamed.c_renamed.a_renamed dragCallback;
    private boolean draggable;
    float elevation;
    int expandedOffset;
    private boolean fitToContents;
    int fitToContentsOffset;
    private boolean gestureInsetBottomIgnored;
    int halfExpandedOffset;
    float halfExpandedRatio;
    boolean hideable;
    private boolean ignoreEvents;
    private java.util.Map<android.view.View, java.lang.Integer> importantForAccessibilityMap;
    private int initialY;
    private android.animation.ValueAnimator interpolatorAnimator;
    private boolean isShapeExpanded;
    private int lastNestedScrollDy;
    private com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable;
    private float maximumVelocity;
    private boolean nestedScrolled;
    java.lang.ref.WeakReference<android.view.View> nestedScrollingChildRef;
    int parentHeight;
    int parentWidth;
    private int peekHeight;
    private boolean peekHeightAuto;
    private int peekHeightMin;
    private int saveFlags;
    private com.google.android.material.bottomsheet.BottomSheetBehavior<V_renamed>.SettleRunnable settleRunnable;
    private com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModelDefault;
    private boolean shapeThemingEnabled;
    private boolean skipCollapsed;
    int state;
    boolean touchingScrollingChild;
    private boolean updateImportantForAccessibilityOnSiblings;
    private android.view.VelocityTracker velocityTracker;
    androidx.customview.a_renamed.c_renamed viewDragHelper;
    java.lang.ref.WeakReference<V_renamed> viewRef;

    public static abstract class BottomSheetCallback {
        public abstract void onSlide(android.view.View view, float f_renamed);

        public abstract void onStateChanged(android.view.View view, int i_renamed);
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface SaveFlags {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface State {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
    public void onNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V_renamed v_renamed, android.view.View view, int i_renamed, int i2, int i3, int i4, int i5, int[] iArr) {
    }

    public BottomSheetBehavior() {
        this.saveFlags = 0;
        this.fitToContents = true;
        this.updateImportantForAccessibilityOnSiblings = false;
        this.settleRunnable = null;
        this.halfExpandedRatio = HIDE_THRESHOLD;
        this.elevation = -1.0f;
        this.draggable = true;
        this.state = 4;
        this.callbacks = new java.util.ArrayList<>();
        this.dragCallback = new androidx.customview.a_renamed.c_renamed.a_renamed() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.3
            @Override // androidx.customview.a_renamed.c_renamed.a_renamed
            public boolean tryCaptureView(android.view.View view, int i_renamed) {
                if (com.google.android.material.bottomsheet.BottomSheetBehavior.this.state == 1 || com.google.android.material.bottomsheet.BottomSheetBehavior.this.touchingScrollingChild) {
                    return false;
                }
                if (com.google.android.material.bottomsheet.BottomSheetBehavior.this.state == 3 && com.google.android.material.bottomsheet.BottomSheetBehavior.this.activePointerId == i_renamed) {
                    android.view.View view2 = com.google.android.material.bottomsheet.BottomSheetBehavior.this.nestedScrollingChildRef != null ? com.google.android.material.bottomsheet.BottomSheetBehavior.this.nestedScrollingChildRef.get() : null;
                    if (view2 != null && view2.canScrollVertically(-1)) {
                        return false;
                    }
                }
                return com.google.android.material.bottomsheet.BottomSheetBehavior.this.viewRef != null && com.google.android.material.bottomsheet.BottomSheetBehavior.this.viewRef.get() == view;
            }

            @Override // androidx.customview.a_renamed.c_renamed.a_renamed
            public void onViewPositionChanged(android.view.View view, int i_renamed, int i2, int i3, int i4) {
                com.google.android.material.bottomsheet.BottomSheetBehavior.this.dispatchOnSlide(i2);
            }

            @Override // androidx.customview.a_renamed.c_renamed.a_renamed
            public void onViewDragStateChanged(int i_renamed) {
                if (i_renamed == 1 && com.google.android.material.bottomsheet.BottomSheetBehavior.this.draggable) {
                    com.google.android.material.bottomsheet.BottomSheetBehavior.this.setStateInternal(1);
                }
            }

            private boolean releasedLow(android.view.View view) {
                return view.getTop() > (com.google.android.material.bottomsheet.BottomSheetBehavior.this.parentHeight + com.google.android.material.bottomsheet.BottomSheetBehavior.this.getExpandedOffset()) / 2;
            }

            @Override // androidx.customview.a_renamed.c_renamed.a_renamed
            public void onViewReleased(android.view.View view, float f_renamed, float f2) {
                int i_renamed;
                int i2 = 4;
                if (f2 < 0.0f) {
                    if (com.google.android.material.bottomsheet.BottomSheetBehavior.this.fitToContents) {
                        i_renamed = com.google.android.material.bottomsheet.BottomSheetBehavior.this.fitToContentsOffset;
                    } else if (view.getTop() > com.google.android.material.bottomsheet.BottomSheetBehavior.this.halfExpandedOffset) {
                        i_renamed = com.google.android.material.bottomsheet.BottomSheetBehavior.this.halfExpandedOffset;
                        i2 = 6;
                    } else {
                        i_renamed = com.google.android.material.bottomsheet.BottomSheetBehavior.this.expandedOffset;
                    }
                    i2 = 3;
                } else if (com.google.android.material.bottomsheet.BottomSheetBehavior.this.hideable && com.google.android.material.bottomsheet.BottomSheetBehavior.this.shouldHide(view, f2)) {
                    if ((java.lang.Math.abs(f_renamed) >= java.lang.Math.abs(f2) || f2 <= 500.0f) && !releasedLow(view)) {
                        if (com.google.android.material.bottomsheet.BottomSheetBehavior.this.fitToContents) {
                            i_renamed = com.google.android.material.bottomsheet.BottomSheetBehavior.this.fitToContentsOffset;
                        } else if (java.lang.Math.abs(view.getTop() - com.google.android.material.bottomsheet.BottomSheetBehavior.this.expandedOffset) < java.lang.Math.abs(view.getTop() - com.google.android.material.bottomsheet.BottomSheetBehavior.this.halfExpandedOffset)) {
                            i_renamed = com.google.android.material.bottomsheet.BottomSheetBehavior.this.expandedOffset;
                        } else {
                            i_renamed = com.google.android.material.bottomsheet.BottomSheetBehavior.this.halfExpandedOffset;
                            i2 = 6;
                        }
                        i2 = 3;
                    } else {
                        i_renamed = com.google.android.material.bottomsheet.BottomSheetBehavior.this.parentHeight;
                        i2 = 5;
                    }
                } else if (f2 != 0.0f && java.lang.Math.abs(f_renamed) <= java.lang.Math.abs(f2)) {
                    if (com.google.android.material.bottomsheet.BottomSheetBehavior.this.fitToContents) {
                        i_renamed = com.google.android.material.bottomsheet.BottomSheetBehavior.this.collapsedOffset;
                    } else {
                        int top = view.getTop();
                        if (java.lang.Math.abs(top - com.google.android.material.bottomsheet.BottomSheetBehavior.this.halfExpandedOffset) < java.lang.Math.abs(top - com.google.android.material.bottomsheet.BottomSheetBehavior.this.collapsedOffset)) {
                            i_renamed = com.google.android.material.bottomsheet.BottomSheetBehavior.this.halfExpandedOffset;
                            i2 = 6;
                        } else {
                            i_renamed = com.google.android.material.bottomsheet.BottomSheetBehavior.this.collapsedOffset;
                        }
                    }
                } else {
                    int top2 = view.getTop();
                    if (com.google.android.material.bottomsheet.BottomSheetBehavior.this.fitToContents) {
                        if (java.lang.Math.abs(top2 - com.google.android.material.bottomsheet.BottomSheetBehavior.this.fitToContentsOffset) < java.lang.Math.abs(top2 - com.google.android.material.bottomsheet.BottomSheetBehavior.this.collapsedOffset)) {
                            i_renamed = com.google.android.material.bottomsheet.BottomSheetBehavior.this.fitToContentsOffset;
                            i2 = 3;
                        } else {
                            i_renamed = com.google.android.material.bottomsheet.BottomSheetBehavior.this.collapsedOffset;
                        }
                    } else {
                        if (top2 < com.google.android.material.bottomsheet.BottomSheetBehavior.this.halfExpandedOffset) {
                            if (top2 < java.lang.Math.abs(top2 - com.google.android.material.bottomsheet.BottomSheetBehavior.this.collapsedOffset)) {
                                i_renamed = com.google.android.material.bottomsheet.BottomSheetBehavior.this.expandedOffset;
                                i2 = 3;
                            } else {
                                i_renamed = com.google.android.material.bottomsheet.BottomSheetBehavior.this.halfExpandedOffset;
                            }
                        } else if (java.lang.Math.abs(top2 - com.google.android.material.bottomsheet.BottomSheetBehavior.this.halfExpandedOffset) < java.lang.Math.abs(top2 - com.google.android.material.bottomsheet.BottomSheetBehavior.this.collapsedOffset)) {
                            i_renamed = com.google.android.material.bottomsheet.BottomSheetBehavior.this.halfExpandedOffset;
                        } else {
                            i_renamed = com.google.android.material.bottomsheet.BottomSheetBehavior.this.collapsedOffset;
                        }
                        i2 = 6;
                    }
                }
                com.google.android.material.bottomsheet.BottomSheetBehavior.this.startSettlingAnimation(view, i2, i_renamed, true);
            }

            @Override // androidx.customview.a_renamed.c_renamed.a_renamed
            public int clampViewPositionVertical(android.view.View view, int i_renamed, int i2) {
                return androidx.core.c_renamed.a_renamed.a_renamed(i_renamed, com.google.android.material.bottomsheet.BottomSheetBehavior.this.getExpandedOffset(), com.google.android.material.bottomsheet.BottomSheetBehavior.this.hideable ? com.google.android.material.bottomsheet.BottomSheetBehavior.this.parentHeight : com.google.android.material.bottomsheet.BottomSheetBehavior.this.collapsedOffset);
            }

            @Override // androidx.customview.a_renamed.c_renamed.a_renamed
            public int clampViewPositionHorizontal(android.view.View view, int i_renamed, int i2) {
                return view.getLeft();
            }

            @Override // androidx.customview.a_renamed.c_renamed.a_renamed
            public int getViewVerticalDragRange(android.view.View view) {
                if (com.google.android.material.bottomsheet.BottomSheetBehavior.this.hideable) {
                    return com.google.android.material.bottomsheet.BottomSheetBehavior.this.parentHeight;
                }
                return com.google.android.material.bottomsheet.BottomSheetBehavior.this.collapsedOffset;
            }
        };
    }

    public BottomSheetBehavior(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.saveFlags = 0;
        this.fitToContents = true;
        this.updateImportantForAccessibilityOnSiblings = false;
        this.settleRunnable = null;
        this.halfExpandedRatio = HIDE_THRESHOLD;
        this.elevation = -1.0f;
        this.draggable = true;
        this.state = 4;
        this.callbacks = new java.util.ArrayList<>();
        this.dragCallback = new androidx.customview.a_renamed.c_renamed.a_renamed() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.3
            @Override // androidx.customview.a_renamed.c_renamed.a_renamed
            public boolean tryCaptureView(android.view.View view, int i_renamed) {
                if (com.google.android.material.bottomsheet.BottomSheetBehavior.this.state == 1 || com.google.android.material.bottomsheet.BottomSheetBehavior.this.touchingScrollingChild) {
                    return false;
                }
                if (com.google.android.material.bottomsheet.BottomSheetBehavior.this.state == 3 && com.google.android.material.bottomsheet.BottomSheetBehavior.this.activePointerId == i_renamed) {
                    android.view.View view2 = com.google.android.material.bottomsheet.BottomSheetBehavior.this.nestedScrollingChildRef != null ? com.google.android.material.bottomsheet.BottomSheetBehavior.this.nestedScrollingChildRef.get() : null;
                    if (view2 != null && view2.canScrollVertically(-1)) {
                        return false;
                    }
                }
                return com.google.android.material.bottomsheet.BottomSheetBehavior.this.viewRef != null && com.google.android.material.bottomsheet.BottomSheetBehavior.this.viewRef.get() == view;
            }

            @Override // androidx.customview.a_renamed.c_renamed.a_renamed
            public void onViewPositionChanged(android.view.View view, int i_renamed, int i2, int i3, int i4) {
                com.google.android.material.bottomsheet.BottomSheetBehavior.this.dispatchOnSlide(i2);
            }

            @Override // androidx.customview.a_renamed.c_renamed.a_renamed
            public void onViewDragStateChanged(int i_renamed) {
                if (i_renamed == 1 && com.google.android.material.bottomsheet.BottomSheetBehavior.this.draggable) {
                    com.google.android.material.bottomsheet.BottomSheetBehavior.this.setStateInternal(1);
                }
            }

            private boolean releasedLow(android.view.View view) {
                return view.getTop() > (com.google.android.material.bottomsheet.BottomSheetBehavior.this.parentHeight + com.google.android.material.bottomsheet.BottomSheetBehavior.this.getExpandedOffset()) / 2;
            }

            @Override // androidx.customview.a_renamed.c_renamed.a_renamed
            public void onViewReleased(android.view.View view, float f_renamed, float f2) {
                int i_renamed;
                int i2 = 4;
                if (f2 < 0.0f) {
                    if (com.google.android.material.bottomsheet.BottomSheetBehavior.this.fitToContents) {
                        i_renamed = com.google.android.material.bottomsheet.BottomSheetBehavior.this.fitToContentsOffset;
                    } else if (view.getTop() > com.google.android.material.bottomsheet.BottomSheetBehavior.this.halfExpandedOffset) {
                        i_renamed = com.google.android.material.bottomsheet.BottomSheetBehavior.this.halfExpandedOffset;
                        i2 = 6;
                    } else {
                        i_renamed = com.google.android.material.bottomsheet.BottomSheetBehavior.this.expandedOffset;
                    }
                    i2 = 3;
                } else if (com.google.android.material.bottomsheet.BottomSheetBehavior.this.hideable && com.google.android.material.bottomsheet.BottomSheetBehavior.this.shouldHide(view, f2)) {
                    if ((java.lang.Math.abs(f_renamed) >= java.lang.Math.abs(f2) || f2 <= 500.0f) && !releasedLow(view)) {
                        if (com.google.android.material.bottomsheet.BottomSheetBehavior.this.fitToContents) {
                            i_renamed = com.google.android.material.bottomsheet.BottomSheetBehavior.this.fitToContentsOffset;
                        } else if (java.lang.Math.abs(view.getTop() - com.google.android.material.bottomsheet.BottomSheetBehavior.this.expandedOffset) < java.lang.Math.abs(view.getTop() - com.google.android.material.bottomsheet.BottomSheetBehavior.this.halfExpandedOffset)) {
                            i_renamed = com.google.android.material.bottomsheet.BottomSheetBehavior.this.expandedOffset;
                        } else {
                            i_renamed = com.google.android.material.bottomsheet.BottomSheetBehavior.this.halfExpandedOffset;
                            i2 = 6;
                        }
                        i2 = 3;
                    } else {
                        i_renamed = com.google.android.material.bottomsheet.BottomSheetBehavior.this.parentHeight;
                        i2 = 5;
                    }
                } else if (f2 != 0.0f && java.lang.Math.abs(f_renamed) <= java.lang.Math.abs(f2)) {
                    if (com.google.android.material.bottomsheet.BottomSheetBehavior.this.fitToContents) {
                        i_renamed = com.google.android.material.bottomsheet.BottomSheetBehavior.this.collapsedOffset;
                    } else {
                        int top = view.getTop();
                        if (java.lang.Math.abs(top - com.google.android.material.bottomsheet.BottomSheetBehavior.this.halfExpandedOffset) < java.lang.Math.abs(top - com.google.android.material.bottomsheet.BottomSheetBehavior.this.collapsedOffset)) {
                            i_renamed = com.google.android.material.bottomsheet.BottomSheetBehavior.this.halfExpandedOffset;
                            i2 = 6;
                        } else {
                            i_renamed = com.google.android.material.bottomsheet.BottomSheetBehavior.this.collapsedOffset;
                        }
                    }
                } else {
                    int top2 = view.getTop();
                    if (com.google.android.material.bottomsheet.BottomSheetBehavior.this.fitToContents) {
                        if (java.lang.Math.abs(top2 - com.google.android.material.bottomsheet.BottomSheetBehavior.this.fitToContentsOffset) < java.lang.Math.abs(top2 - com.google.android.material.bottomsheet.BottomSheetBehavior.this.collapsedOffset)) {
                            i_renamed = com.google.android.material.bottomsheet.BottomSheetBehavior.this.fitToContentsOffset;
                            i2 = 3;
                        } else {
                            i_renamed = com.google.android.material.bottomsheet.BottomSheetBehavior.this.collapsedOffset;
                        }
                    } else {
                        if (top2 < com.google.android.material.bottomsheet.BottomSheetBehavior.this.halfExpandedOffset) {
                            if (top2 < java.lang.Math.abs(top2 - com.google.android.material.bottomsheet.BottomSheetBehavior.this.collapsedOffset)) {
                                i_renamed = com.google.android.material.bottomsheet.BottomSheetBehavior.this.expandedOffset;
                                i2 = 3;
                            } else {
                                i_renamed = com.google.android.material.bottomsheet.BottomSheetBehavior.this.halfExpandedOffset;
                            }
                        } else if (java.lang.Math.abs(top2 - com.google.android.material.bottomsheet.BottomSheetBehavior.this.halfExpandedOffset) < java.lang.Math.abs(top2 - com.google.android.material.bottomsheet.BottomSheetBehavior.this.collapsedOffset)) {
                            i_renamed = com.google.android.material.bottomsheet.BottomSheetBehavior.this.halfExpandedOffset;
                        } else {
                            i_renamed = com.google.android.material.bottomsheet.BottomSheetBehavior.this.collapsedOffset;
                        }
                        i2 = 6;
                    }
                }
                com.google.android.material.bottomsheet.BottomSheetBehavior.this.startSettlingAnimation(view, i2, i_renamed, true);
            }

            @Override // androidx.customview.a_renamed.c_renamed.a_renamed
            public int clampViewPositionVertical(android.view.View view, int i_renamed, int i2) {
                return androidx.core.c_renamed.a_renamed.a_renamed(i_renamed, com.google.android.material.bottomsheet.BottomSheetBehavior.this.getExpandedOffset(), com.google.android.material.bottomsheet.BottomSheetBehavior.this.hideable ? com.google.android.material.bottomsheet.BottomSheetBehavior.this.parentHeight : com.google.android.material.bottomsheet.BottomSheetBehavior.this.collapsedOffset);
            }

            @Override // androidx.customview.a_renamed.c_renamed.a_renamed
            public int clampViewPositionHorizontal(android.view.View view, int i_renamed, int i2) {
                return view.getLeft();
            }

            @Override // androidx.customview.a_renamed.c_renamed.a_renamed
            public int getViewVerticalDragRange(android.view.View view) {
                if (com.google.android.material.bottomsheet.BottomSheetBehavior.this.hideable) {
                    return com.google.android.material.bottomsheet.BottomSheetBehavior.this.parentHeight;
                }
                return com.google.android.material.bottomsheet.BottomSheetBehavior.this.collapsedOffset;
            }
        };
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.google.android.material.R_renamed.styleable.BottomSheetBehavior_Layout);
        this.shapeThemingEnabled = typedArrayObtainStyledAttributes.hasValue(com.google.android.material.R_renamed.styleable.BottomSheetBehavior_Layout_shapeAppearance);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(com.google.android.material.R_renamed.styleable.BottomSheetBehavior_Layout_backgroundTint);
        if (zHasValue) {
            createMaterialShapeDrawable(context, attributeSet, zHasValue, com.google.android.material.resources.MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.BottomSheetBehavior_Layout_backgroundTint));
        } else {
            createMaterialShapeDrawable(context, attributeSet, zHasValue);
        }
        createShapeValueAnimator();
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            this.elevation = typedArrayObtainStyledAttributes.getDimension(com.google.android.material.R_renamed.styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        }
        android.util.TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(com.google.android.material.R_renamed.styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (typedValuePeekValue != null && typedValuePeekValue.data == -1) {
            setPeekHeight(typedValuePeekValue.data);
        } else {
            setPeekHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R_renamed.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        }
        setHideable(typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R_renamed.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        setGestureInsetBottomIgnored(typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R_renamed.styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false));
        setFitToContents(typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R_renamed.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        setSkipCollapsed(typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R_renamed.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        setDraggable(typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R_renamed.styleable.BottomSheetBehavior_Layout_behavior_draggable, true));
        setSaveFlags(typedArrayObtainStyledAttributes.getInt(com.google.android.material.R_renamed.styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        setHalfExpandedRatio(typedArrayObtainStyledAttributes.getFloat(com.google.android.material.R_renamed.styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, HIDE_THRESHOLD));
        android.util.TypedValue typedValuePeekValue2 = typedArrayObtainStyledAttributes.peekValue(com.google.android.material.R_renamed.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset);
        if (typedValuePeekValue2 != null && typedValuePeekValue2.type == 16) {
            setExpandedOffset(typedValuePeekValue2.data);
        } else {
            setExpandedOffset(typedArrayObtainStyledAttributes.getDimensionPixelOffset(com.google.android.material.R_renamed.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset, 0));
        }
        typedArrayObtainStyledAttributes.recycle();
        this.maximumVelocity = android.view.ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
    public android.os.Parcelable onSaveInstanceState(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V_renamed v_renamed) {
        return new com.google.android.material.bottomsheet.BottomSheetBehavior.SavedState(super.onSaveInstanceState(coordinatorLayout, v_renamed), (com.google.android.material.bottomsheet.BottomSheetBehavior<?>) this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
    public void onRestoreInstanceState(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V_renamed v_renamed, android.os.Parcelable parcelable) {
        com.google.android.material.bottomsheet.BottomSheetBehavior.SavedState savedState = (com.google.android.material.bottomsheet.BottomSheetBehavior.SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v_renamed, savedState.getSuperState());
        restoreOptionalState(savedState);
        if (savedState.state == 1 || savedState.state == 2) {
            this.state = 4;
        } else {
            this.state = savedState.state;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
    public void onAttachedToLayoutParams(androidx.coordinatorlayout.widget.CoordinatorLayout.e_renamed eVar) {
        super.onAttachedToLayoutParams(eVar);
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
    public boolean onLayoutChild(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V_renamed v_renamed, int i_renamed) {
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable;
        if (androidx.core.h_renamed.v_renamed.t_renamed(coordinatorLayout) && !androidx.core.h_renamed.v_renamed.t_renamed(v_renamed)) {
            v_renamed.setFitsSystemWindows(true);
        }
        if (this.viewRef == null) {
            this.peekHeightMin = coordinatorLayout.getResources().getDimensionPixelSize(com.google.android.material.R_renamed.dimen.design_bottom_sheet_peek_height_min);
            setSystemGestureInsets(coordinatorLayout);
            this.viewRef = new java.lang.ref.WeakReference<>(v_renamed);
            if (this.shapeThemingEnabled && (materialShapeDrawable = this.materialShapeDrawable) != null) {
                androidx.core.h_renamed.v_renamed.a_renamed(v_renamed, materialShapeDrawable);
            }
            com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable2 = this.materialShapeDrawable;
            if (materialShapeDrawable2 != null) {
                float fO_renamed = this.elevation;
                if (fO_renamed == -1.0f) {
                    fO_renamed = androidx.core.h_renamed.v_renamed.o_renamed(v_renamed);
                }
                materialShapeDrawable2.setElevation(fO_renamed);
                this.isShapeExpanded = this.state == 3;
                this.materialShapeDrawable.setInterpolation(this.isShapeExpanded ? 0.0f : 1.0f);
            }
            updateAccessibilityActions();
            if (androidx.core.h_renamed.v_renamed.f_renamed(v_renamed) == 0) {
                androidx.core.h_renamed.v_renamed.b_renamed((android.view.View) v_renamed, 1);
            }
        }
        if (this.viewDragHelper == null) {
            this.viewDragHelper = androidx.customview.a_renamed.c_renamed.a_renamed(coordinatorLayout, this.dragCallback);
        }
        int top = v_renamed.getTop();
        coordinatorLayout.onLayoutChild(v_renamed, i_renamed);
        this.parentWidth = coordinatorLayout.getWidth();
        this.parentHeight = coordinatorLayout.getHeight();
        this.fitToContentsOffset = java.lang.Math.max(0, this.parentHeight - v_renamed.getHeight());
        calculateHalfExpandedOffset();
        calculateCollapsedOffset();
        int i2 = this.state;
        if (i2 == 3) {
            androidx.core.h_renamed.v_renamed.e_renamed(v_renamed, getExpandedOffset());
        } else if (i2 == 6) {
            androidx.core.h_renamed.v_renamed.e_renamed(v_renamed, this.halfExpandedOffset);
        } else if (this.hideable && i2 == 5) {
            androidx.core.h_renamed.v_renamed.e_renamed(v_renamed, this.parentHeight);
        } else {
            int i3 = this.state;
            if (i3 == 4) {
                androidx.core.h_renamed.v_renamed.e_renamed(v_renamed, this.collapsedOffset);
            } else if (i3 == 1 || i3 == 2) {
                androidx.core.h_renamed.v_renamed.e_renamed(v_renamed, top - v_renamed.getTop());
            }
        }
        this.nestedScrollingChildRef = new java.lang.ref.WeakReference<>(findScrollingChild(v_renamed));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
    public boolean onInterceptTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V_renamed v_renamed, android.view.MotionEvent motionEvent) {
        androidx.customview.a_renamed.c_renamed cVar;
        if (!v_renamed.isShown() || !this.draggable) {
            this.ignoreEvents = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            reset();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = android.view.VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x_renamed = (int) motionEvent.getX();
            this.initialY = (int) motionEvent.getY();
            if (this.state != 2) {
                java.lang.ref.WeakReference<android.view.View> weakReference = this.nestedScrollingChildRef;
                android.view.View view = weakReference != null ? weakReference.get() : null;
                if (view != null && coordinatorLayout.isPointInChildBounds(view, x_renamed, this.initialY)) {
                    this.activePointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.touchingScrollingChild = true;
                }
            }
            this.ignoreEvents = this.activePointerId == -1 && !coordinatorLayout.isPointInChildBounds(v_renamed, x_renamed, this.initialY);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.touchingScrollingChild = false;
            this.activePointerId = -1;
            if (this.ignoreEvents) {
                this.ignoreEvents = false;
                return false;
            }
        }
        if (!this.ignoreEvents && (cVar = this.viewDragHelper) != null && cVar.a_renamed(motionEvent)) {
            return true;
        }
        java.lang.ref.WeakReference<android.view.View> weakReference2 = this.nestedScrollingChildRef;
        android.view.View view2 = weakReference2 != null ? weakReference2.get() : null;
        return (actionMasked != 2 || view2 == null || this.ignoreEvents || this.state == 1 || coordinatorLayout.isPointInChildBounds(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.viewDragHelper == null || java.lang.Math.abs(((float) this.initialY) - motionEvent.getY()) <= ((float) this.viewDragHelper.d_renamed())) ? false : true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
    public boolean onTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V_renamed v_renamed, android.view.MotionEvent motionEvent) {
        if (!v_renamed.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.state == 1 && actionMasked == 0) {
            return true;
        }
        androidx.customview.a_renamed.c_renamed cVar = this.viewDragHelper;
        if (cVar != null) {
            cVar.b_renamed(motionEvent);
        }
        if (actionMasked == 0) {
            reset();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = android.view.VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        if (actionMasked == 2 && !this.ignoreEvents && java.lang.Math.abs(this.initialY - motionEvent.getY()) > this.viewDragHelper.d_renamed()) {
            this.viewDragHelper.a_renamed(v_renamed, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.ignoreEvents;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
    public boolean onStartNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V_renamed v_renamed, android.view.View view, android.view.View view2, int i_renamed, int i2) {
        this.lastNestedScrollDy = 0;
        this.nestedScrolled = false;
        return (i_renamed & 2) != 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
    public void onNestedPreScroll(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V_renamed v_renamed, android.view.View view, int i_renamed, int i2, int[] iArr, int i3) {
        if (i3 == 1) {
            return;
        }
        java.lang.ref.WeakReference<android.view.View> weakReference = this.nestedScrollingChildRef;
        if (view != (weakReference != null ? weakReference.get() : null)) {
            return;
        }
        int top = v_renamed.getTop();
        int i4 = top - i2;
        if (i2 > 0) {
            if (i4 < getExpandedOffset()) {
                iArr[1] = top - getExpandedOffset();
                androidx.core.h_renamed.v_renamed.e_renamed(v_renamed, -iArr[1]);
                setStateInternal(3);
            } else {
                if (!this.draggable) {
                    return;
                }
                iArr[1] = i2;
                androidx.core.h_renamed.v_renamed.e_renamed(v_renamed, -i2);
                setStateInternal(1);
            }
        } else if (i2 < 0 && !view.canScrollVertically(-1)) {
            int i5 = this.collapsedOffset;
            if (i4 <= i5 || this.hideable) {
                if (!this.draggable) {
                    return;
                }
                iArr[1] = i2;
                androidx.core.h_renamed.v_renamed.e_renamed(v_renamed, -i2);
                setStateInternal(1);
            } else {
                iArr[1] = top - i5;
                androidx.core.h_renamed.v_renamed.e_renamed(v_renamed, -iArr[1]);
                setStateInternal(4);
            }
        }
        dispatchOnSlide(v_renamed.getTop());
        this.lastNestedScrollDy = i2;
        this.nestedScrolled = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
    public void onStopNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V_renamed v_renamed, android.view.View view, int i_renamed) {
        int i2;
        int i3 = 3;
        if (v_renamed.getTop() == getExpandedOffset()) {
            setStateInternal(3);
            return;
        }
        java.lang.ref.WeakReference<android.view.View> weakReference = this.nestedScrollingChildRef;
        if (weakReference != null && view == weakReference.get() && this.nestedScrolled) {
            if (this.lastNestedScrollDy > 0) {
                if (this.fitToContents) {
                    i2 = this.fitToContentsOffset;
                } else {
                    int top = v_renamed.getTop();
                    int i4 = this.halfExpandedOffset;
                    if (top > i4) {
                        i2 = i4;
                        i3 = 6;
                    } else {
                        i2 = this.expandedOffset;
                    }
                }
            } else if (this.hideable && shouldHide(v_renamed, getYVelocity())) {
                i2 = this.parentHeight;
                i3 = 5;
            } else if (this.lastNestedScrollDy == 0) {
                int top2 = v_renamed.getTop();
                if (this.fitToContents) {
                    if (java.lang.Math.abs(top2 - this.fitToContentsOffset) < java.lang.Math.abs(top2 - this.collapsedOffset)) {
                        i2 = this.fitToContentsOffset;
                    } else {
                        i2 = this.collapsedOffset;
                        i3 = 4;
                    }
                } else {
                    int i5 = this.halfExpandedOffset;
                    if (top2 < i5) {
                        if (top2 < java.lang.Math.abs(top2 - this.collapsedOffset)) {
                            i2 = this.expandedOffset;
                        } else {
                            i2 = this.halfExpandedOffset;
                        }
                    } else if (java.lang.Math.abs(top2 - i5) < java.lang.Math.abs(top2 - this.collapsedOffset)) {
                        i2 = this.halfExpandedOffset;
                    } else {
                        i2 = this.collapsedOffset;
                        i3 = 4;
                    }
                    i3 = 6;
                }
            } else {
                if (this.fitToContents) {
                    i2 = this.collapsedOffset;
                } else {
                    int top3 = v_renamed.getTop();
                    if (java.lang.Math.abs(top3 - this.halfExpandedOffset) < java.lang.Math.abs(top3 - this.collapsedOffset)) {
                        i2 = this.halfExpandedOffset;
                        i3 = 6;
                    } else {
                        i2 = this.collapsedOffset;
                    }
                }
                i3 = 4;
            }
            startSettlingAnimation(v_renamed, i3, i2, false);
            this.nestedScrolled = false;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
    public boolean onNestedPreFling(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V_renamed v_renamed, android.view.View view, float f_renamed, float f2) {
        java.lang.ref.WeakReference<android.view.View> weakReference = this.nestedScrollingChildRef;
        if (weakReference == null || view != weakReference.get()) {
            return false;
        }
        return this.state != 3 || super.onNestedPreFling(coordinatorLayout, v_renamed, view, f_renamed, f2);
    }

    public boolean isFitToContents() {
        return this.fitToContents;
    }

    public void setFitToContents(boolean z_renamed) {
        if (this.fitToContents == z_renamed) {
            return;
        }
        this.fitToContents = z_renamed;
        if (this.viewRef != null) {
            calculateCollapsedOffset();
        }
        setStateInternal((this.fitToContents && this.state == 6) ? 3 : this.state);
        updateAccessibilityActions();
    }

    public void setPeekHeight(int i_renamed) {
        setPeekHeight(i_renamed, false);
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:12:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void setPeekHeight(int r4, boolean r5) {
        /*
            r3 = this;
            r0 = 1
            r1 = 0
            r2 = -1
            if (r4 != r2) goto Lc
            boolean r4 = r3.peekHeightAuto
            if (r4 != 0) goto L15
            r3.peekHeightAuto = r0
            goto L1f
        Lc:
            boolean r2 = r3.peekHeightAuto
            if (r2 != 0) goto L17
            int r2 = r3.peekHeight
            if (r2 == r4) goto L15
            goto L17
        L15:
            r0 = r1
            goto L1f
        L17:
            r3.peekHeightAuto = r1
            int r4 = java.lang.Math.max(r1, r4)
            r3.peekHeight = r4
        L1f:
            if (r0 == 0) goto L42
            java.lang.ref.WeakReference<V_renamed extends android.view.View> r4 = r3.viewRef
            if (r4 == 0) goto L42
            r3.calculateCollapsedOffset()
            int r4 = r3.state
            r0 = 4
            if (r4 != r0) goto L42
            java.lang.ref.WeakReference<V_renamed extends android.view.View> r4 = r3.viewRef
            java.lang.Object r4 = r4.get()
            android.view.View r4 = (android.view.View) r4
            if (r4 == 0) goto L42
            if (r5 == 0) goto L3f
            int r4 = r3.state
            r3.settleToStatePendingLayout(r4)
            goto L42
        L3f:
            r4.requestLayout()
        L42:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.setPeekHeight(int, boolean):void");
    }

    public int getPeekHeight() {
        if (this.peekHeightAuto) {
            return -1;
        }
        return this.peekHeight;
    }

    public void setHalfExpandedRatio(float f_renamed) {
        if (f_renamed <= 0.0f || f_renamed >= 1.0f) {
            throw new java.lang.IllegalArgumentException("ratio must be_renamed a_renamed float value between 0 and 1");
        }
        this.halfExpandedRatio = f_renamed;
        if (this.viewRef != null) {
            calculateHalfExpandedOffset();
        }
    }

    public float getHalfExpandedRatio() {
        return this.halfExpandedRatio;
    }

    public void setExpandedOffset(int i_renamed) {
        if (i_renamed < 0) {
            throw new java.lang.IllegalArgumentException("offset must be_renamed greater than or equal to 0");
        }
        this.expandedOffset = i_renamed;
    }

    public int getExpandedOffset() {
        return this.fitToContents ? this.fitToContentsOffset : this.expandedOffset;
    }

    public void setHideable(boolean z_renamed) {
        if (this.hideable != z_renamed) {
            this.hideable = z_renamed;
            if (!z_renamed && this.state == 5) {
                setState(4);
            }
            updateAccessibilityActions();
        }
    }

    public boolean isHideable() {
        return this.hideable;
    }

    public void setSkipCollapsed(boolean z_renamed) {
        this.skipCollapsed = z_renamed;
    }

    public boolean getSkipCollapsed() {
        return this.skipCollapsed;
    }

    public void setDraggable(boolean z_renamed) {
        this.draggable = z_renamed;
    }

    public boolean isDraggable() {
        return this.draggable;
    }

    public void setSaveFlags(int i_renamed) {
        this.saveFlags = i_renamed;
    }

    public int getSaveFlags() {
        return this.saveFlags;
    }

    @java.lang.Deprecated
    public void setBottomSheetCallback(com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback bottomSheetCallback) {
        android.util.Log.w_renamed(TAG, "BottomSheetBehavior now supports multiple callbacks. `setBottomSheetCallback()` removes all existing callbacks, including ones set internally by_renamed library authors, which may result in_renamed unintended behavior. This may change in_renamed the future. Please use `addBottomSheetCallback()` and `removeBottomSheetCallback()` instead to set your own callbacks.");
        this.callbacks.clear();
        if (bottomSheetCallback != null) {
            this.callbacks.add(bottomSheetCallback);
        }
    }

    public void addBottomSheetCallback(com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback bottomSheetCallback) {
        if (this.callbacks.contains(bottomSheetCallback)) {
            return;
        }
        this.callbacks.add(bottomSheetCallback);
    }

    public void removeBottomSheetCallback(com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback bottomSheetCallback) {
        this.callbacks.remove(bottomSheetCallback);
    }

    public void setState(int i_renamed) {
        if (i_renamed == this.state) {
            return;
        }
        if (this.viewRef == null) {
            if (i_renamed == 4 || i_renamed == 3 || i_renamed == 6 || (this.hideable && i_renamed == 5)) {
                this.state = i_renamed;
                return;
            }
            return;
        }
        settleToStatePendingLayout(i_renamed);
    }

    public void setGestureInsetBottomIgnored(boolean z_renamed) {
        this.gestureInsetBottomIgnored = z_renamed;
    }

    public boolean isGestureInsetBottomIgnored() {
        return this.gestureInsetBottomIgnored;
    }

    private void settleToStatePendingLayout(final int i_renamed) {
        final V_renamed v_renamed = this.viewRef.get();
        if (v_renamed == null) {
            return;
        }
        android.view.ViewParent parent = v_renamed.getParent();
        if (parent != null && parent.isLayoutRequested() && androidx.core.h_renamed.v_renamed.D_renamed(v_renamed)) {
            v_renamed.post(new java.lang.Runnable() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.1
                @Override // java.lang.Runnable
                public void run() {
                    com.google.android.material.bottomsheet.BottomSheetBehavior.this.settleToState(v_renamed, i_renamed);
                }
            });
        } else {
            settleToState(v_renamed, i_renamed);
        }
    }

    public int getState() {
        return this.state;
    }

    void setStateInternal(int i_renamed) {
        V_renamed v_renamed;
        if (this.state == i_renamed) {
            return;
        }
        this.state = i_renamed;
        java.lang.ref.WeakReference<V_renamed> weakReference = this.viewRef;
        if (weakReference == null || (v_renamed = weakReference.get()) == null) {
            return;
        }
        if (i_renamed == 3) {
            updateImportantForAccessibility(true);
        } else if (i_renamed == 6 || i_renamed == 5 || i_renamed == 4) {
            updateImportantForAccessibility(false);
        }
        updateDrawableForTargetState(i_renamed);
        for (int i2 = 0; i2 < this.callbacks.size(); i2++) {
            this.callbacks.get(i2).onStateChanged(v_renamed, i_renamed);
        }
        updateAccessibilityActions();
    }

    private void updateDrawableForTargetState(int i_renamed) {
        android.animation.ValueAnimator valueAnimator;
        if (i_renamed == 2) {
            return;
        }
        boolean z_renamed = i_renamed == 3;
        if (this.isShapeExpanded != z_renamed) {
            this.isShapeExpanded = z_renamed;
            if (this.materialShapeDrawable == null || (valueAnimator = this.interpolatorAnimator) == null) {
                return;
            }
            if (valueAnimator.isRunning()) {
                this.interpolatorAnimator.reverse();
                return;
            }
            float f_renamed = z_renamed ? 0.0f : 1.0f;
            this.interpolatorAnimator.setFloatValues(1.0f - f_renamed, f_renamed);
            this.interpolatorAnimator.start();
        }
    }

    private int calculatePeekHeight() {
        if (this.peekHeightAuto) {
            return java.lang.Math.max(this.peekHeightMin, this.parentHeight - ((this.parentWidth * 9) / 16));
        }
        return this.peekHeight;
    }

    private void calculateCollapsedOffset() {
        int iCalculatePeekHeight = calculatePeekHeight();
        if (this.fitToContents) {
            this.collapsedOffset = java.lang.Math.max(this.parentHeight - iCalculatePeekHeight, this.fitToContentsOffset);
        } else {
            this.collapsedOffset = this.parentHeight - iCalculatePeekHeight;
        }
    }

    private void calculateHalfExpandedOffset() {
        this.halfExpandedOffset = (int) (this.parentHeight * (1.0f - this.halfExpandedRatio));
    }

    private void reset() {
        this.activePointerId = -1;
        android.view.VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.velocityTracker = null;
        }
    }

    private void restoreOptionalState(com.google.android.material.bottomsheet.BottomSheetBehavior.SavedState savedState) {
        int i_renamed = this.saveFlags;
        if (i_renamed == 0) {
            return;
        }
        if (i_renamed == -1 || (i_renamed & 1) == 1) {
            this.peekHeight = savedState.peekHeight;
        }
        int i2 = this.saveFlags;
        if (i2 == -1 || (i2 & 2) == 2) {
            this.fitToContents = savedState.fitToContents;
        }
        int i3 = this.saveFlags;
        if (i3 == -1 || (i3 & 4) == 4) {
            this.hideable = savedState.hideable;
        }
        int i4 = this.saveFlags;
        if (i4 == -1 || (i4 & 8) == 8) {
            this.skipCollapsed = savedState.skipCollapsed;
        }
    }

    boolean shouldHide(android.view.View view, float f_renamed) {
        if (this.skipCollapsed) {
            return true;
        }
        if (view.getTop() < this.collapsedOffset) {
            return false;
        }
        return java.lang.Math.abs((((float) view.getTop()) + (f_renamed * 0.1f)) - ((float) this.collapsedOffset)) / ((float) calculatePeekHeight()) > HIDE_THRESHOLD;
    }

    android.view.View findScrollingChild(android.view.View view) {
        if (androidx.core.h_renamed.v_renamed.y_renamed(view)) {
            return view;
        }
        if (!(view instanceof android.view.ViewGroup)) {
            return null;
        }
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
            android.view.View viewFindScrollingChild = findScrollingChild(viewGroup.getChildAt(i_renamed));
            if (viewFindScrollingChild != null) {
                return viewFindScrollingChild;
            }
        }
        return null;
    }

    private void createMaterialShapeDrawable(android.content.Context context, android.util.AttributeSet attributeSet, boolean z_renamed) {
        createMaterialShapeDrawable(context, attributeSet, z_renamed, null);
    }

    private void createMaterialShapeDrawable(android.content.Context context, android.util.AttributeSet attributeSet, boolean z_renamed, android.content.res.ColorStateList colorStateList) {
        if (this.shapeThemingEnabled) {
            this.shapeAppearanceModelDefault = com.google.android.material.shape.ShapeAppearanceModel.builder(context, attributeSet, com.google.android.material.R_renamed.attr.bottomSheetStyle, DEF_STYLE_RES).build();
            this.materialShapeDrawable = new com.google.android.material.shape.MaterialShapeDrawable(this.shapeAppearanceModelDefault);
            this.materialShapeDrawable.initializeElevationOverlay(context);
            if (z_renamed && colorStateList != null) {
                this.materialShapeDrawable.setFillColor(colorStateList);
                return;
            }
            android.util.TypedValue typedValue = new android.util.TypedValue();
            context.getTheme().resolveAttribute(android.R_renamed.attr.colorBackground, typedValue, true);
            this.materialShapeDrawable.setTint(typedValue.data);
        }
    }

    private void createShapeValueAnimator() {
        this.interpolatorAnimator = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
        this.interpolatorAnimator.setDuration(500L);
        this.interpolatorAnimator.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                float fFloatValue = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                if (com.google.android.material.bottomsheet.BottomSheetBehavior.this.materialShapeDrawable != null) {
                    com.google.android.material.bottomsheet.BottomSheetBehavior.this.materialShapeDrawable.setInterpolation(fFloatValue);
                }
            }
        });
    }

    private void setSystemGestureInsets(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout) {
        android.view.WindowInsets rootWindowInsets;
        if (android.os.Build.VERSION.SDK_INT < 29 || isGestureInsetBottomIgnored() || (rootWindowInsets = coordinatorLayout.getRootWindowInsets()) == null) {
            return;
        }
        this.peekHeight += rootWindowInsets.getSystemGestureInsets().bottom;
    }

    private float getYVelocity() {
        android.view.VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.maximumVelocity);
        return this.velocityTracker.getYVelocity(this.activePointerId);
    }

    void settleToState(android.view.View view, int i_renamed) {
        int expandedOffset;
        int i2;
        if (i_renamed == 4) {
            expandedOffset = this.collapsedOffset;
        } else if (i_renamed == 6) {
            int i3 = this.halfExpandedOffset;
            if (!this.fitToContents || i3 > (i2 = this.fitToContentsOffset)) {
                expandedOffset = i3;
            } else {
                i_renamed = 3;
                expandedOffset = i2;
            }
        } else if (i_renamed == 3) {
            expandedOffset = getExpandedOffset();
        } else if (this.hideable && i_renamed == 5) {
            expandedOffset = this.parentHeight;
        } else {
            throw new java.lang.IllegalArgumentException("Illegal state argument: " + i_renamed);
        }
        startSettlingAnimation(view, i_renamed, expandedOffset, false);
    }

    void startSettlingAnimation(android.view.View view, int i_renamed, int i2, boolean z_renamed) {
        boolean zA;
        if (z_renamed) {
            zA = this.viewDragHelper.a_renamed(view.getLeft(), i2);
        } else {
            zA = this.viewDragHelper.a_renamed(view, view.getLeft(), i2);
        }
        if (zA) {
            setStateInternal(2);
            updateDrawableForTargetState(i_renamed);
            if (this.settleRunnable == null) {
                this.settleRunnable = new com.google.android.material.bottomsheet.BottomSheetBehavior.SettleRunnable(view, i_renamed);
            }
            if (!((com.google.android.material.bottomsheet.BottomSheetBehavior.SettleRunnable) this.settleRunnable).isPosted) {
                com.google.android.material.bottomsheet.BottomSheetBehavior<V_renamed>.SettleRunnable settleRunnable = this.settleRunnable;
                settleRunnable.targetState = i_renamed;
                androidx.core.h_renamed.v_renamed.a_renamed(view, settleRunnable);
                ((com.google.android.material.bottomsheet.BottomSheetBehavior.SettleRunnable) this.settleRunnable).isPosted = true;
                return;
            }
            this.settleRunnable.targetState = i_renamed;
            return;
        }
        setStateInternal(i_renamed);
    }

    void dispatchOnSlide(int i_renamed) {
        float f_renamed;
        float expandedOffset;
        V_renamed v_renamed = this.viewRef.get();
        if (v_renamed == null || this.callbacks.isEmpty()) {
            return;
        }
        int i2 = this.collapsedOffset;
        if (i_renamed > i2 || i2 == getExpandedOffset()) {
            int i3 = this.collapsedOffset;
            f_renamed = i3 - i_renamed;
            expandedOffset = this.parentHeight - i3;
        } else {
            int i4 = this.collapsedOffset;
            f_renamed = i4 - i_renamed;
            expandedOffset = i4 - getExpandedOffset();
        }
        float f2 = f_renamed / expandedOffset;
        for (int i5 = 0; i5 < this.callbacks.size(); i5++) {
            this.callbacks.get(i5).onSlide(v_renamed, f2);
        }
    }

    int getPeekHeightMin() {
        return this.peekHeightMin;
    }

    public void disableShapeAnimations() {
        this.interpolatorAnimator = null;
    }

    private class SettleRunnable implements java.lang.Runnable {
        private boolean isPosted;
        int targetState;
        private final android.view.View view;

        SettleRunnable(android.view.View view, int i_renamed) {
            this.view = view;
            this.targetState = i_renamed;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.google.android.material.bottomsheet.BottomSheetBehavior.this.viewDragHelper != null && com.google.android.material.bottomsheet.BottomSheetBehavior.this.viewDragHelper.a_renamed(true)) {
                androidx.core.h_renamed.v_renamed.a_renamed(this.view, this);
            } else {
                com.google.android.material.bottomsheet.BottomSheetBehavior.this.setStateInternal(this.targetState);
            }
            this.isPosted = false;
        }
    }

    protected static class SavedState extends androidx.customview.view.AbsSavedState {
        public static final android.os.Parcelable.Creator<com.google.android.material.bottomsheet.BottomSheetBehavior.SavedState> CREATOR = new android.os.Parcelable.ClassLoaderCreator<com.google.android.material.bottomsheet.BottomSheetBehavior.SavedState>() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.SavedState.1
            /* JADX WARN: Can't_renamed rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public com.google.android.material.bottomsheet.BottomSheetBehavior.SavedState createFromParcel(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
                return new com.google.android.material.bottomsheet.BottomSheetBehavior.SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public com.google.android.material.bottomsheet.BottomSheetBehavior.SavedState createFromParcel(android.os.Parcel parcel) {
                return new com.google.android.material.bottomsheet.BottomSheetBehavior.SavedState(parcel, (java.lang.ClassLoader) null);
            }

            @Override // android.os.Parcelable.Creator
            public com.google.android.material.bottomsheet.BottomSheetBehavior.SavedState[] newArray(int i_renamed) {
                return new com.google.android.material.bottomsheet.BottomSheetBehavior.SavedState[i_renamed];
            }
        };
        boolean fitToContents;
        boolean hideable;
        int peekHeight;
        boolean skipCollapsed;
        final int state;

        public SavedState(android.os.Parcel parcel) {
            this(parcel, (java.lang.ClassLoader) null);
        }

        public SavedState(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
            super(parcel, classLoader);
            this.state = parcel.readInt();
            this.peekHeight = parcel.readInt();
            this.fitToContents = parcel.readInt() == 1;
            this.hideable = parcel.readInt() == 1;
            this.skipCollapsed = parcel.readInt() == 1;
        }

        public SavedState(android.os.Parcelable parcelable, com.google.android.material.bottomsheet.BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.state = bottomSheetBehavior.state;
            this.peekHeight = ((com.google.android.material.bottomsheet.BottomSheetBehavior) bottomSheetBehavior).peekHeight;
            this.fitToContents = ((com.google.android.material.bottomsheet.BottomSheetBehavior) bottomSheetBehavior).fitToContents;
            this.hideable = bottomSheetBehavior.hideable;
            this.skipCollapsed = ((com.google.android.material.bottomsheet.BottomSheetBehavior) bottomSheetBehavior).skipCollapsed;
        }

        @java.lang.Deprecated
        public SavedState(android.os.Parcelable parcelable, int i_renamed) {
            super(parcelable);
            this.state = i_renamed;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
            super.writeToParcel(parcel, i_renamed);
            parcel.writeInt(this.state);
            parcel.writeInt(this.peekHeight);
            parcel.writeInt(this.fitToContents ? 1 : 0);
            parcel.writeInt(this.hideable ? 1 : 0);
            parcel.writeInt(this.skipCollapsed ? 1 : 0);
        }
    }

    public static <V_renamed extends android.view.View> com.google.android.material.bottomsheet.BottomSheetBehavior<V_renamed> from(V_renamed v_renamed) {
        android.view.ViewGroup.LayoutParams layoutParams = v_renamed.getLayoutParams();
        if (!(layoutParams instanceof androidx.coordinatorlayout.widget.CoordinatorLayout.e_renamed)) {
            throw new java.lang.IllegalArgumentException("The view is_renamed not a_renamed child of_renamed CoordinatorLayout");
        }
        androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed bVarB = ((androidx.coordinatorlayout.widget.CoordinatorLayout.e_renamed) layoutParams).b_renamed();
        if (!(bVarB instanceof com.google.android.material.bottomsheet.BottomSheetBehavior)) {
            throw new java.lang.IllegalArgumentException("The view is_renamed not associated with BottomSheetBehavior");
        }
        return (com.google.android.material.bottomsheet.BottomSheetBehavior) bVarB;
    }

    public void setUpdateImportantForAccessibilityOnSiblings(boolean z_renamed) {
        this.updateImportantForAccessibilityOnSiblings = z_renamed;
    }

    private void updateImportantForAccessibility(boolean z_renamed) {
        java.util.Map<android.view.View, java.lang.Integer> map;
        java.lang.ref.WeakReference<V_renamed> weakReference = this.viewRef;
        if (weakReference == null) {
            return;
        }
        android.view.ViewParent parent = weakReference.get().getParent();
        if (parent instanceof androidx.coordinatorlayout.widget.CoordinatorLayout) {
            androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout = (androidx.coordinatorlayout.widget.CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (android.os.Build.VERSION.SDK_INT >= 16 && z_renamed) {
                if (this.importantForAccessibilityMap != null) {
                    return;
                } else {
                    this.importantForAccessibilityMap = new java.util.HashMap(childCount);
                }
            }
            for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
                android.view.View childAt = coordinatorLayout.getChildAt(i_renamed);
                if (childAt != this.viewRef.get()) {
                    if (z_renamed) {
                        if (android.os.Build.VERSION.SDK_INT >= 16) {
                            this.importantForAccessibilityMap.put(childAt, java.lang.Integer.valueOf(childAt.getImportantForAccessibility()));
                        }
                        if (this.updateImportantForAccessibilityOnSiblings) {
                            androidx.core.h_renamed.v_renamed.b_renamed(childAt, 4);
                        }
                    } else if (this.updateImportantForAccessibilityOnSiblings && (map = this.importantForAccessibilityMap) != null && map.containsKey(childAt)) {
                        androidx.core.h_renamed.v_renamed.b_renamed(childAt, this.importantForAccessibilityMap.get(childAt).intValue());
                    }
                }
            }
            if (z_renamed) {
                return;
            }
            this.importantForAccessibilityMap = null;
        }
    }

    private void updateAccessibilityActions() {
        V_renamed v_renamed;
        java.lang.ref.WeakReference<V_renamed> weakReference = this.viewRef;
        if (weakReference == null || (v_renamed = weakReference.get()) == null) {
            return;
        }
        androidx.core.h_renamed.v_renamed.c_renamed((android.view.View) v_renamed, com.sensetime.stmobile.STMobileHumanActionNative.ST_MOBILE_ENABLE_INPUT_CUSTOM);
        androidx.core.h_renamed.v_renamed.c_renamed((android.view.View) v_renamed, com.sensetime.stmobile.STMobileHumanActionNative.ST_MOBILE_DETECT_MODE_IMAGE);
        androidx.core.h_renamed.v_renamed.c_renamed((android.view.View) v_renamed, com.google.android.exoplayer2.source.ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES);
        if (this.hideable && this.state != 5) {
            addAccessibilityActionForState(v_renamed, androidx.core.h_renamed.a_renamed.d_renamed.a_renamed.u_renamed, 5);
        }
        int i_renamed = this.state;
        if (i_renamed == 3) {
            addAccessibilityActionForState(v_renamed, androidx.core.h_renamed.a_renamed.d_renamed.a_renamed.t_renamed, this.fitToContents ? 4 : 6);
            return;
        }
        if (i_renamed == 4) {
            addAccessibilityActionForState(v_renamed, androidx.core.h_renamed.a_renamed.d_renamed.a_renamed.s_renamed, this.fitToContents ? 3 : 6);
        } else {
            if (i_renamed != 6) {
                return;
            }
            addAccessibilityActionForState(v_renamed, androidx.core.h_renamed.a_renamed.d_renamed.a_renamed.t_renamed, 4);
            addAccessibilityActionForState(v_renamed, androidx.core.h_renamed.a_renamed.d_renamed.a_renamed.s_renamed, 3);
        }
    }

    private void addAccessibilityActionForState(V_renamed v_renamed, androidx.core.h_renamed.a_renamed.d_renamed.a_renamed aVar, final int i_renamed) {
        androidx.core.h_renamed.v_renamed.a_renamed(v_renamed, aVar, null, new androidx.core.h_renamed.a_renamed.g_renamed() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.4
            @Override // androidx.core.h_renamed.a_renamed.g_renamed
            public boolean perform(android.view.View view, androidx.core.h_renamed.a_renamed.g_renamed.a_renamed aVar2) {
                com.google.android.material.bottomsheet.BottomSheetBehavior.this.setState(i_renamed);
                return true;
            }
        });
    }
}
