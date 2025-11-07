package com.google.android.material.bottomsheet;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.p031c.MathUtils;
import androidx.core.p036h.ViewCompat;
import androidx.core.p036h.p037a.AccessibilityNodeInfoCompat;
import androidx.core.p036h.p037a.AccessibilityViewCommand;
import androidx.customview.p039a.ViewDragHelper;
import androidx.customview.view.AbsSavedState;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.material.C1694R;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.sensetime.stmobile.STMobileHumanActionNative;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.AbstractC0408b<V> {
    private static final int CORNER_ANIMATION_DURATION = 500;
    private static final int DEF_STYLE_RES = C1694R.style.Widget_Design_BottomSheet_Modal;
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
    private static final String TAG = "BottomSheetBehavior";
    int activePointerId;
    private final ArrayList<BottomSheetCallback> callbacks;
    int collapsedOffset;
    private final ViewDragHelper.PlatformImplementations.kt_3 dragCallback;
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
    private Map<View, Integer> importantForAccessibilityMap;
    private int initialY;
    private ValueAnimator interpolatorAnimator;
    private boolean isShapeExpanded;
    private int lastNestedScrollDy;
    private MaterialShapeDrawable materialShapeDrawable;
    private float maximumVelocity;
    private boolean nestedScrolled;
    WeakReference<View> nestedScrollingChildRef;
    int parentHeight;
    int parentWidth;
    private int peekHeight;
    private boolean peekHeightAuto;
    private int peekHeightMin;
    private int saveFlags;
    private BottomSheetBehavior<V>.SettleRunnable settleRunnable;
    private ShapeAppearanceModel shapeAppearanceModelDefault;
    private boolean shapeThemingEnabled;
    private boolean skipCollapsed;
    int state;
    boolean touchingScrollingChild;
    private boolean updateImportantForAccessibilityOnSiblings;
    private VelocityTracker velocityTracker;
    ViewDragHelper viewDragHelper;
    WeakReference<V> viewRef;

    public static abstract class BottomSheetCallback {
        public abstract void onSlide(View view, float COUIBaseListPopupWindow_12);

        public abstract void onStateChanged(View view, int OplusGLSurfaceView_13);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SaveFlags {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0408b
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int[] iArr) {
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
        this.callbacks = new ArrayList<>();
        this.dragCallback = new ViewDragHelper.PlatformImplementations.kt_3() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.3
            @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
            public boolean tryCaptureView(View view, int OplusGLSurfaceView_13) {
                if (BottomSheetBehavior.this.state == 1 || BottomSheetBehavior.this.touchingScrollingChild) {
                    return false;
                }
                if (BottomSheetBehavior.this.state == 3 && BottomSheetBehavior.this.activePointerId == OplusGLSurfaceView_13) {
                    View view2 = BottomSheetBehavior.this.nestedScrollingChildRef != null ? BottomSheetBehavior.this.nestedScrollingChildRef.get() : null;
                    if (view2 != null && view2.canScrollVertically(-1)) {
                        return false;
                    }
                }
                return BottomSheetBehavior.this.viewRef != null && BottomSheetBehavior.this.viewRef.get() == view;
            }

            @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
            public void onViewPositionChanged(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
                BottomSheetBehavior.this.dispatchOnSlide(i2);
            }

            @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
            public void onViewDragStateChanged(int OplusGLSurfaceView_13) {
                if (OplusGLSurfaceView_13 == 1 && BottomSheetBehavior.this.draggable) {
                    BottomSheetBehavior.this.setStateInternal(1);
                }
            }

            private boolean releasedLow(View view) {
                return view.getTop() > (BottomSheetBehavior.this.parentHeight + BottomSheetBehavior.this.getExpandedOffset()) / 2;
            }

            @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
            public void onViewReleased(View view, float COUIBaseListPopupWindow_12, float f2) {
                int OplusGLSurfaceView_13;
                int i2 = 4;
                if (f2 < 0.0f) {
                    if (BottomSheetBehavior.this.fitToContents) {
                        OplusGLSurfaceView_13 = BottomSheetBehavior.this.fitToContentsOffset;
                    } else if (view.getTop() > BottomSheetBehavior.this.halfExpandedOffset) {
                        OplusGLSurfaceView_13 = BottomSheetBehavior.this.halfExpandedOffset;
                        i2 = 6;
                    } else {
                        OplusGLSurfaceView_13 = BottomSheetBehavior.this.expandedOffset;
                    }
                    i2 = 3;
                } else if (BottomSheetBehavior.this.hideable && BottomSheetBehavior.this.shouldHide(view, f2)) {
                    if ((Math.abs(COUIBaseListPopupWindow_12) >= Math.abs(f2) || f2 <= 500.0f) && !releasedLow(view)) {
                        if (BottomSheetBehavior.this.fitToContents) {
                            OplusGLSurfaceView_13 = BottomSheetBehavior.this.fitToContentsOffset;
                        } else if (Math.abs(view.getTop() - BottomSheetBehavior.this.expandedOffset) < Math.abs(view.getTop() - BottomSheetBehavior.this.halfExpandedOffset)) {
                            OplusGLSurfaceView_13 = BottomSheetBehavior.this.expandedOffset;
                        } else {
                            OplusGLSurfaceView_13 = BottomSheetBehavior.this.halfExpandedOffset;
                            i2 = 6;
                        }
                        i2 = 3;
                    } else {
                        OplusGLSurfaceView_13 = BottomSheetBehavior.this.parentHeight;
                        i2 = 5;
                    }
                } else if (f2 != 0.0f && Math.abs(COUIBaseListPopupWindow_12) <= Math.abs(f2)) {
                    if (BottomSheetBehavior.this.fitToContents) {
                        OplusGLSurfaceView_13 = BottomSheetBehavior.this.collapsedOffset;
                    } else {
                        int top = view.getTop();
                        if (Math.abs(top - BottomSheetBehavior.this.halfExpandedOffset) < Math.abs(top - BottomSheetBehavior.this.collapsedOffset)) {
                            OplusGLSurfaceView_13 = BottomSheetBehavior.this.halfExpandedOffset;
                            i2 = 6;
                        } else {
                            OplusGLSurfaceView_13 = BottomSheetBehavior.this.collapsedOffset;
                        }
                    }
                } else {
                    int top2 = view.getTop();
                    if (BottomSheetBehavior.this.fitToContents) {
                        if (Math.abs(top2 - BottomSheetBehavior.this.fitToContentsOffset) < Math.abs(top2 - BottomSheetBehavior.this.collapsedOffset)) {
                            OplusGLSurfaceView_13 = BottomSheetBehavior.this.fitToContentsOffset;
                            i2 = 3;
                        } else {
                            OplusGLSurfaceView_13 = BottomSheetBehavior.this.collapsedOffset;
                        }
                    } else {
                        if (top2 < BottomSheetBehavior.this.halfExpandedOffset) {
                            if (top2 < Math.abs(top2 - BottomSheetBehavior.this.collapsedOffset)) {
                                OplusGLSurfaceView_13 = BottomSheetBehavior.this.expandedOffset;
                                i2 = 3;
                            } else {
                                OplusGLSurfaceView_13 = BottomSheetBehavior.this.halfExpandedOffset;
                            }
                        } else if (Math.abs(top2 - BottomSheetBehavior.this.halfExpandedOffset) < Math.abs(top2 - BottomSheetBehavior.this.collapsedOffset)) {
                            OplusGLSurfaceView_13 = BottomSheetBehavior.this.halfExpandedOffset;
                        } else {
                            OplusGLSurfaceView_13 = BottomSheetBehavior.this.collapsedOffset;
                        }
                        i2 = 6;
                    }
                }
                BottomSheetBehavior.this.startSettlingAnimation(view, i2, OplusGLSurfaceView_13, true);
            }

            @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
            public int clampViewPositionVertical(View view, int OplusGLSurfaceView_13, int i2) {
                return MathUtils.m2447a(OplusGLSurfaceView_13, BottomSheetBehavior.this.getExpandedOffset(), BottomSheetBehavior.this.hideable ? BottomSheetBehavior.this.parentHeight : BottomSheetBehavior.this.collapsedOffset);
            }

            @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
            public int clampViewPositionHorizontal(View view, int OplusGLSurfaceView_13, int i2) {
                return view.getLeft();
            }

            @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
            public int getViewVerticalDragRange(View view) {
                if (BottomSheetBehavior.this.hideable) {
                    return BottomSheetBehavior.this.parentHeight;
                }
                return BottomSheetBehavior.this.collapsedOffset;
            }
        };
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.saveFlags = 0;
        this.fitToContents = true;
        this.updateImportantForAccessibilityOnSiblings = false;
        this.settleRunnable = null;
        this.halfExpandedRatio = HIDE_THRESHOLD;
        this.elevation = -1.0f;
        this.draggable = true;
        this.state = 4;
        this.callbacks = new ArrayList<>();
        this.dragCallback = new ViewDragHelper.PlatformImplementations.kt_3() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.3
            @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
            public boolean tryCaptureView(View view, int OplusGLSurfaceView_13) {
                if (BottomSheetBehavior.this.state == 1 || BottomSheetBehavior.this.touchingScrollingChild) {
                    return false;
                }
                if (BottomSheetBehavior.this.state == 3 && BottomSheetBehavior.this.activePointerId == OplusGLSurfaceView_13) {
                    View view2 = BottomSheetBehavior.this.nestedScrollingChildRef != null ? BottomSheetBehavior.this.nestedScrollingChildRef.get() : null;
                    if (view2 != null && view2.canScrollVertically(-1)) {
                        return false;
                    }
                }
                return BottomSheetBehavior.this.viewRef != null && BottomSheetBehavior.this.viewRef.get() == view;
            }

            @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
            public void onViewPositionChanged(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
                BottomSheetBehavior.this.dispatchOnSlide(i2);
            }

            @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
            public void onViewDragStateChanged(int OplusGLSurfaceView_13) {
                if (OplusGLSurfaceView_13 == 1 && BottomSheetBehavior.this.draggable) {
                    BottomSheetBehavior.this.setStateInternal(1);
                }
            }

            private boolean releasedLow(View view) {
                return view.getTop() > (BottomSheetBehavior.this.parentHeight + BottomSheetBehavior.this.getExpandedOffset()) / 2;
            }

            @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
            public void onViewReleased(View view, float COUIBaseListPopupWindow_12, float f2) {
                int OplusGLSurfaceView_13;
                int i2 = 4;
                if (f2 < 0.0f) {
                    if (BottomSheetBehavior.this.fitToContents) {
                        OplusGLSurfaceView_13 = BottomSheetBehavior.this.fitToContentsOffset;
                    } else if (view.getTop() > BottomSheetBehavior.this.halfExpandedOffset) {
                        OplusGLSurfaceView_13 = BottomSheetBehavior.this.halfExpandedOffset;
                        i2 = 6;
                    } else {
                        OplusGLSurfaceView_13 = BottomSheetBehavior.this.expandedOffset;
                    }
                    i2 = 3;
                } else if (BottomSheetBehavior.this.hideable && BottomSheetBehavior.this.shouldHide(view, f2)) {
                    if ((Math.abs(COUIBaseListPopupWindow_12) >= Math.abs(f2) || f2 <= 500.0f) && !releasedLow(view)) {
                        if (BottomSheetBehavior.this.fitToContents) {
                            OplusGLSurfaceView_13 = BottomSheetBehavior.this.fitToContentsOffset;
                        } else if (Math.abs(view.getTop() - BottomSheetBehavior.this.expandedOffset) < Math.abs(view.getTop() - BottomSheetBehavior.this.halfExpandedOffset)) {
                            OplusGLSurfaceView_13 = BottomSheetBehavior.this.expandedOffset;
                        } else {
                            OplusGLSurfaceView_13 = BottomSheetBehavior.this.halfExpandedOffset;
                            i2 = 6;
                        }
                        i2 = 3;
                    } else {
                        OplusGLSurfaceView_13 = BottomSheetBehavior.this.parentHeight;
                        i2 = 5;
                    }
                } else if (f2 != 0.0f && Math.abs(COUIBaseListPopupWindow_12) <= Math.abs(f2)) {
                    if (BottomSheetBehavior.this.fitToContents) {
                        OplusGLSurfaceView_13 = BottomSheetBehavior.this.collapsedOffset;
                    } else {
                        int top = view.getTop();
                        if (Math.abs(top - BottomSheetBehavior.this.halfExpandedOffset) < Math.abs(top - BottomSheetBehavior.this.collapsedOffset)) {
                            OplusGLSurfaceView_13 = BottomSheetBehavior.this.halfExpandedOffset;
                            i2 = 6;
                        } else {
                            OplusGLSurfaceView_13 = BottomSheetBehavior.this.collapsedOffset;
                        }
                    }
                } else {
                    int top2 = view.getTop();
                    if (BottomSheetBehavior.this.fitToContents) {
                        if (Math.abs(top2 - BottomSheetBehavior.this.fitToContentsOffset) < Math.abs(top2 - BottomSheetBehavior.this.collapsedOffset)) {
                            OplusGLSurfaceView_13 = BottomSheetBehavior.this.fitToContentsOffset;
                            i2 = 3;
                        } else {
                            OplusGLSurfaceView_13 = BottomSheetBehavior.this.collapsedOffset;
                        }
                    } else {
                        if (top2 < BottomSheetBehavior.this.halfExpandedOffset) {
                            if (top2 < Math.abs(top2 - BottomSheetBehavior.this.collapsedOffset)) {
                                OplusGLSurfaceView_13 = BottomSheetBehavior.this.expandedOffset;
                                i2 = 3;
                            } else {
                                OplusGLSurfaceView_13 = BottomSheetBehavior.this.halfExpandedOffset;
                            }
                        } else if (Math.abs(top2 - BottomSheetBehavior.this.halfExpandedOffset) < Math.abs(top2 - BottomSheetBehavior.this.collapsedOffset)) {
                            OplusGLSurfaceView_13 = BottomSheetBehavior.this.halfExpandedOffset;
                        } else {
                            OplusGLSurfaceView_13 = BottomSheetBehavior.this.collapsedOffset;
                        }
                        i2 = 6;
                    }
                }
                BottomSheetBehavior.this.startSettlingAnimation(view, i2, OplusGLSurfaceView_13, true);
            }

            @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
            public int clampViewPositionVertical(View view, int OplusGLSurfaceView_13, int i2) {
                return MathUtils.m2447a(OplusGLSurfaceView_13, BottomSheetBehavior.this.getExpandedOffset(), BottomSheetBehavior.this.hideable ? BottomSheetBehavior.this.parentHeight : BottomSheetBehavior.this.collapsedOffset);
            }

            @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
            public int clampViewPositionHorizontal(View view, int OplusGLSurfaceView_13, int i2) {
                return view.getLeft();
            }

            @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
            public int getViewVerticalDragRange(View view) {
                if (BottomSheetBehavior.this.hideable) {
                    return BottomSheetBehavior.this.parentHeight;
                }
                return BottomSheetBehavior.this.collapsedOffset;
            }
        };
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1694R.styleable.BottomSheetBehavior_Layout);
        this.shapeThemingEnabled = typedArrayObtainStyledAttributes.hasValue(C1694R.styleable.BottomSheetBehavior_Layout_shapeAppearance);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(C1694R.styleable.BottomSheetBehavior_Layout_backgroundTint);
        if (zHasValue) {
            createMaterialShapeDrawable(context, attributeSet, zHasValue, MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, C1694R.styleable.BottomSheetBehavior_Layout_backgroundTint));
        } else {
            createMaterialShapeDrawable(context, attributeSet, zHasValue);
        }
        createShapeValueAnimator();
        if (Build.VERSION.SDK_INT >= 21) {
            this.elevation = typedArrayObtainStyledAttributes.getDimension(C1694R.styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        }
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(C1694R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (typedValuePeekValue != null && typedValuePeekValue.data == -1) {
            setPeekHeight(typedValuePeekValue.data);
        } else {
            setPeekHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(C1694R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        }
        setHideable(typedArrayObtainStyledAttributes.getBoolean(C1694R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        setGestureInsetBottomIgnored(typedArrayObtainStyledAttributes.getBoolean(C1694R.styleable.f9179xed791f57, false));
        setFitToContents(typedArrayObtainStyledAttributes.getBoolean(C1694R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        setSkipCollapsed(typedArrayObtainStyledAttributes.getBoolean(C1694R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        setDraggable(typedArrayObtainStyledAttributes.getBoolean(C1694R.styleable.BottomSheetBehavior_Layout_behavior_draggable, true));
        setSaveFlags(typedArrayObtainStyledAttributes.getInt(C1694R.styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        setHalfExpandedRatio(typedArrayObtainStyledAttributes.getFloat(C1694R.styleable.f9178x40da2d0e, HIDE_THRESHOLD));
        TypedValue typedValuePeekValue2 = typedArrayObtainStyledAttributes.peekValue(C1694R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset);
        if (typedValuePeekValue2 != null && typedValuePeekValue2.type == 16) {
            setExpandedOffset(typedValuePeekValue2.data);
        } else {
            setExpandedOffset(typedArrayObtainStyledAttributes.getDimensionPixelOffset(C1694R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset, 0));
        }
        typedArrayObtainStyledAttributes.recycle();
        this.maximumVelocity = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0408b
    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v), (BottomSheetBehavior<?>) this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0408b
    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v, savedState.getSuperState());
        restoreOptionalState(savedState);
        if (savedState.state == 1 || savedState.state == 2) {
            this.state = 4;
        } else {
            this.state = savedState.state;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0408b
    public void onAttachedToLayoutParams(CoordinatorLayout.C0411e c0411e) {
        super.onAttachedToLayoutParams(c0411e);
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0408b
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0408b
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int OplusGLSurfaceView_13) {
        MaterialShapeDrawable materialShapeDrawable;
        if (ViewCompat.m2901t(coordinatorLayout) && !ViewCompat.m2901t(v)) {
            v.setFitsSystemWindows(true);
        }
        if (this.viewRef == null) {
            this.peekHeightMin = coordinatorLayout.getResources().getDimensionPixelSize(C1694R.dimen.design_bottom_sheet_peek_height_min);
            setSystemGestureInsets(coordinatorLayout);
            this.viewRef = new WeakReference<>(v);
            if (this.shapeThemingEnabled && (materialShapeDrawable = this.materialShapeDrawable) != null) {
                ViewCompat.m2850a(v, materialShapeDrawable);
            }
            MaterialShapeDrawable materialShapeDrawable2 = this.materialShapeDrawable;
            if (materialShapeDrawable2 != null) {
                float fM2896o = this.elevation;
                if (fM2896o == -1.0f) {
                    fM2896o = ViewCompat.m2896o(v);
                }
                materialShapeDrawable2.setElevation(fM2896o);
                this.isShapeExpanded = this.state == 3;
                this.materialShapeDrawable.setInterpolation(this.isShapeExpanded ? 0.0f : 1.0f);
            }
            updateAccessibilityActions();
            if (ViewCompat.m2883f(v) == 0) {
                ViewCompat.m2867b((View) v, 1);
            }
        }
        if (this.viewDragHelper == null) {
            this.viewDragHelper = ViewDragHelper.m3091a(coordinatorLayout, this.dragCallback);
        }
        int top = v.getTop();
        coordinatorLayout.onLayoutChild(v, OplusGLSurfaceView_13);
        this.parentWidth = coordinatorLayout.getWidth();
        this.parentHeight = coordinatorLayout.getHeight();
        this.fitToContentsOffset = Math.max(0, this.parentHeight - v.getHeight());
        calculateHalfExpandedOffset();
        calculateCollapsedOffset();
        int i2 = this.state;
        if (i2 == 3) {
            ViewCompat.m2882e(v, getExpandedOffset());
        } else if (i2 == 6) {
            ViewCompat.m2882e(v, this.halfExpandedOffset);
        } else if (this.hideable && i2 == 5) {
            ViewCompat.m2882e(v, this.parentHeight);
        } else {
            int i3 = this.state;
            if (i3 == 4) {
                ViewCompat.m2882e(v, this.collapsedOffset);
            } else if (i3 == 1 || i3 == 2) {
                ViewCompat.m2882e(v, top - v.getTop());
            }
        }
        this.nestedScrollingChildRef = new WeakReference<>(findScrollingChild(v));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0408b
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        ViewDragHelper c0535c;
        if (!v.isShown() || !this.draggable) {
            this.ignoreEvents = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            reset();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x = (int) motionEvent.getX();
            this.initialY = (int) motionEvent.getY();
            if (this.state != 2) {
                WeakReference<View> weakReference = this.nestedScrollingChildRef;
                View view = weakReference != null ? weakReference.get() : null;
                if (view != null && coordinatorLayout.isPointInChildBounds(view, x, this.initialY)) {
                    this.activePointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.touchingScrollingChild = true;
                }
            }
            this.ignoreEvents = this.activePointerId == -1 && !coordinatorLayout.isPointInChildBounds(v, x, this.initialY);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.touchingScrollingChild = false;
            this.activePointerId = -1;
            if (this.ignoreEvents) {
                this.ignoreEvents = false;
                return false;
            }
        }
        if (!this.ignoreEvents && (c0535c = this.viewDragHelper) != null && c0535c.m3111a(motionEvent)) {
            return true;
        }
        WeakReference<View> weakReference2 = this.nestedScrollingChildRef;
        View view2 = weakReference2 != null ? weakReference2.get() : null;
        return (actionMasked != 2 || view2 == null || this.ignoreEvents || this.state == 1 || coordinatorLayout.isPointInChildBounds(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.viewDragHelper == null || Math.abs(((float) this.initialY) - motionEvent.getY()) <= ((float) this.viewDragHelper.m3123d())) ? false : true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0408b
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.state == 1 && actionMasked == 0) {
            return true;
        }
        ViewDragHelper c0535c = this.viewDragHelper;
        if (c0535c != null) {
            c0535c.m3115b(motionEvent);
        }
        if (actionMasked == 0) {
            reset();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        if (actionMasked == 2 && !this.ignoreEvents && Math.abs(this.initialY - motionEvent.getY()) > this.viewDragHelper.m3123d()) {
            this.viewDragHelper.m3109a(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.ignoreEvents;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0408b
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int OplusGLSurfaceView_13, int i2) {
        this.lastNestedScrollDy = 0;
        this.nestedScrolled = false;
        return (OplusGLSurfaceView_13 & 2) != 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0408b
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int OplusGLSurfaceView_13, int i2, int[] iArr, int i3) {
        if (i3 == 1) {
            return;
        }
        WeakReference<View> weakReference = this.nestedScrollingChildRef;
        if (view != (weakReference != null ? weakReference.get() : null)) {
            return;
        }
        int top = v.getTop();
        int i4 = top - i2;
        if (i2 > 0) {
            if (i4 < getExpandedOffset()) {
                iArr[1] = top - getExpandedOffset();
                ViewCompat.m2882e(v, -iArr[1]);
                setStateInternal(3);
            } else {
                if (!this.draggable) {
                    return;
                }
                iArr[1] = i2;
                ViewCompat.m2882e(v, -i2);
                setStateInternal(1);
            }
        } else if (i2 < 0 && !view.canScrollVertically(-1)) {
            int i5 = this.collapsedOffset;
            if (i4 <= i5 || this.hideable) {
                if (!this.draggable) {
                    return;
                }
                iArr[1] = i2;
                ViewCompat.m2882e(v, -i2);
                setStateInternal(1);
            } else {
                iArr[1] = top - i5;
                ViewCompat.m2882e(v, -iArr[1]);
                setStateInternal(4);
            }
        }
        dispatchOnSlide(v.getTop());
        this.lastNestedScrollDy = i2;
        this.nestedScrolled = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0408b
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int OplusGLSurfaceView_13) {
        int i2;
        int i3 = 3;
        if (v.getTop() == getExpandedOffset()) {
            setStateInternal(3);
            return;
        }
        WeakReference<View> weakReference = this.nestedScrollingChildRef;
        if (weakReference != null && view == weakReference.get() && this.nestedScrolled) {
            if (this.lastNestedScrollDy > 0) {
                if (this.fitToContents) {
                    i2 = this.fitToContentsOffset;
                } else {
                    int top = v.getTop();
                    int i4 = this.halfExpandedOffset;
                    if (top > i4) {
                        i2 = i4;
                        i3 = 6;
                    } else {
                        i2 = this.expandedOffset;
                    }
                }
            } else if (this.hideable && shouldHide(v, getYVelocity())) {
                i2 = this.parentHeight;
                i3 = 5;
            } else if (this.lastNestedScrollDy == 0) {
                int top2 = v.getTop();
                if (this.fitToContents) {
                    if (Math.abs(top2 - this.fitToContentsOffset) < Math.abs(top2 - this.collapsedOffset)) {
                        i2 = this.fitToContentsOffset;
                    } else {
                        i2 = this.collapsedOffset;
                        i3 = 4;
                    }
                } else {
                    int i5 = this.halfExpandedOffset;
                    if (top2 < i5) {
                        if (top2 < Math.abs(top2 - this.collapsedOffset)) {
                            i2 = this.expandedOffset;
                        } else {
                            i2 = this.halfExpandedOffset;
                        }
                    } else if (Math.abs(top2 - i5) < Math.abs(top2 - this.collapsedOffset)) {
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
                    int top3 = v.getTop();
                    if (Math.abs(top3 - this.halfExpandedOffset) < Math.abs(top3 - this.collapsedOffset)) {
                        i2 = this.halfExpandedOffset;
                        i3 = 6;
                    } else {
                        i2 = this.collapsedOffset;
                    }
                }
                i3 = 4;
            }
            startSettlingAnimation(v, i3, i2, false);
            this.nestedScrolled = false;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0408b
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v, View view, float COUIBaseListPopupWindow_12, float f2) {
        WeakReference<View> weakReference = this.nestedScrollingChildRef;
        if (weakReference == null || view != weakReference.get()) {
            return false;
        }
        return this.state != 3 || super.onNestedPreFling(coordinatorLayout, v, view, COUIBaseListPopupWindow_12, f2);
    }

    public boolean isFitToContents() {
        return this.fitToContents;
    }

    public void setFitToContents(boolean z) {
        if (this.fitToContents == z) {
            return;
        }
        this.fitToContents = z;
        if (this.viewRef != null) {
            calculateCollapsedOffset();
        }
        setStateInternal((this.fitToContents && this.state == 6) ? 3 : this.state);
        updateAccessibilityActions();
    }

    public void setPeekHeight(int OplusGLSurfaceView_13) {
        setPeekHeight(OplusGLSurfaceView_13, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0015  */
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
            java.lang.ref.WeakReference<V extends android.view.View> r4 = r3.viewRef
            if (r4 == 0) goto L42
            r3.calculateCollapsedOffset()
            int r4 = r3.state
            r0 = 4
            if (r4 != r0) goto L42
            java.lang.ref.WeakReference<V extends android.view.View> r4 = r3.viewRef
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

    public void setHalfExpandedRatio(float COUIBaseListPopupWindow_12) {
        if (COUIBaseListPopupWindow_12 <= 0.0f || COUIBaseListPopupWindow_12 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be PlatformImplementations.kt_3 float value between 0 and 1");
        }
        this.halfExpandedRatio = COUIBaseListPopupWindow_12;
        if (this.viewRef != null) {
            calculateHalfExpandedOffset();
        }
    }

    public float getHalfExpandedRatio() {
        return this.halfExpandedRatio;
    }

    public void setExpandedOffset(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0) {
            throw new IllegalArgumentException("offset must be greater than or equal to 0");
        }
        this.expandedOffset = OplusGLSurfaceView_13;
    }

    public int getExpandedOffset() {
        return this.fitToContents ? this.fitToContentsOffset : this.expandedOffset;
    }

    public void setHideable(boolean z) {
        if (this.hideable != z) {
            this.hideable = z;
            if (!z && this.state == 5) {
                setState(4);
            }
            updateAccessibilityActions();
        }
    }

    public boolean isHideable() {
        return this.hideable;
    }

    public void setSkipCollapsed(boolean z) {
        this.skipCollapsed = z;
    }

    public boolean getSkipCollapsed() {
        return this.skipCollapsed;
    }

    public void setDraggable(boolean z) {
        this.draggable = z;
    }

    public boolean isDraggable() {
        return this.draggable;
    }

    public void setSaveFlags(int OplusGLSurfaceView_13) {
        this.saveFlags = OplusGLSurfaceView_13;
    }

    public int getSaveFlags() {
        return this.saveFlags;
    }

    @Deprecated
    public void setBottomSheetCallback(BottomSheetCallback bottomSheetCallback) {
        Log.w(TAG, "BottomSheetBehavior now supports multiple callbacks. `setBottomSheetCallback()` removes all existing callbacks, including ones set internally by library authors, which may result in unintended behavior. This may change in the future. Please use `addBottomSheetCallback()` and `removeBottomSheetCallback()` instead to set your own callbacks.");
        this.callbacks.clear();
        if (bottomSheetCallback != null) {
            this.callbacks.add(bottomSheetCallback);
        }
    }

    public void addBottomSheetCallback(BottomSheetCallback bottomSheetCallback) {
        if (this.callbacks.contains(bottomSheetCallback)) {
            return;
        }
        this.callbacks.add(bottomSheetCallback);
    }

    public void removeBottomSheetCallback(BottomSheetCallback bottomSheetCallback) {
        this.callbacks.remove(bottomSheetCallback);
    }

    public void setState(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == this.state) {
            return;
        }
        if (this.viewRef == null) {
            if (OplusGLSurfaceView_13 == 4 || OplusGLSurfaceView_13 == 3 || OplusGLSurfaceView_13 == 6 || (this.hideable && OplusGLSurfaceView_13 == 5)) {
                this.state = OplusGLSurfaceView_13;
                return;
            }
            return;
        }
        settleToStatePendingLayout(OplusGLSurfaceView_13);
    }

    public void setGestureInsetBottomIgnored(boolean z) {
        this.gestureInsetBottomIgnored = z;
    }

    public boolean isGestureInsetBottomIgnored() {
        return this.gestureInsetBottomIgnored;
    }

    private void settleToStatePendingLayout(final int OplusGLSurfaceView_13) {
        final V v = this.viewRef.get();
        if (v == null) {
            return;
        }
        ViewParent parent = v.getParent();
        if (parent != null && parent.isLayoutRequested() && ViewCompat.m2826D(v)) {
            v.post(new Runnable() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.1
                @Override // java.lang.Runnable
                public void run() {
                    BottomSheetBehavior.this.settleToState(v, OplusGLSurfaceView_13);
                }
            });
        } else {
            settleToState(v, OplusGLSurfaceView_13);
        }
    }

    public int getState() {
        return this.state;
    }

    void setStateInternal(int OplusGLSurfaceView_13) {
        V v;
        if (this.state == OplusGLSurfaceView_13) {
            return;
        }
        this.state = OplusGLSurfaceView_13;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null || (v = weakReference.get()) == null) {
            return;
        }
        if (OplusGLSurfaceView_13 == 3) {
            updateImportantForAccessibility(true);
        } else if (OplusGLSurfaceView_13 == 6 || OplusGLSurfaceView_13 == 5 || OplusGLSurfaceView_13 == 4) {
            updateImportantForAccessibility(false);
        }
        updateDrawableForTargetState(OplusGLSurfaceView_13);
        for (int i2 = 0; i2 < this.callbacks.size(); i2++) {
            this.callbacks.get(i2).onStateChanged(v, OplusGLSurfaceView_13);
        }
        updateAccessibilityActions();
    }

    private void updateDrawableForTargetState(int OplusGLSurfaceView_13) {
        ValueAnimator valueAnimator;
        if (OplusGLSurfaceView_13 == 2) {
            return;
        }
        boolean z = OplusGLSurfaceView_13 == 3;
        if (this.isShapeExpanded != z) {
            this.isShapeExpanded = z;
            if (this.materialShapeDrawable == null || (valueAnimator = this.interpolatorAnimator) == null) {
                return;
            }
            if (valueAnimator.isRunning()) {
                this.interpolatorAnimator.reverse();
                return;
            }
            float COUIBaseListPopupWindow_12 = z ? 0.0f : 1.0f;
            this.interpolatorAnimator.setFloatValues(1.0f - COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12);
            this.interpolatorAnimator.start();
        }
    }

    private int calculatePeekHeight() {
        if (this.peekHeightAuto) {
            return Math.max(this.peekHeightMin, this.parentHeight - ((this.parentWidth * 9) / 16));
        }
        return this.peekHeight;
    }

    private void calculateCollapsedOffset() {
        int iCalculatePeekHeight = calculatePeekHeight();
        if (this.fitToContents) {
            this.collapsedOffset = Math.max(this.parentHeight - iCalculatePeekHeight, this.fitToContentsOffset);
        } else {
            this.collapsedOffset = this.parentHeight - iCalculatePeekHeight;
        }
    }

    private void calculateHalfExpandedOffset() {
        this.halfExpandedOffset = (int) (this.parentHeight * (1.0f - this.halfExpandedRatio));
    }

    private void reset() {
        this.activePointerId = -1;
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.velocityTracker = null;
        }
    }

    private void restoreOptionalState(SavedState savedState) {
        int OplusGLSurfaceView_13 = this.saveFlags;
        if (OplusGLSurfaceView_13 == 0) {
            return;
        }
        if (OplusGLSurfaceView_13 == -1 || (OplusGLSurfaceView_13 & 1) == 1) {
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

    boolean shouldHide(View view, float COUIBaseListPopupWindow_12) {
        if (this.skipCollapsed) {
            return true;
        }
        if (view.getTop() < this.collapsedOffset) {
            return false;
        }
        return Math.abs((((float) view.getTop()) + (COUIBaseListPopupWindow_12 * 0.1f)) - ((float) this.collapsedOffset)) / ((float) calculatePeekHeight()) > HIDE_THRESHOLD;
    }

    View findScrollingChild(View view) {
        if (ViewCompat.m2906y(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            View viewFindScrollingChild = findScrollingChild(viewGroup.getChildAt(OplusGLSurfaceView_13));
            if (viewFindScrollingChild != null) {
                return viewFindScrollingChild;
            }
        }
        return null;
    }

    private void createMaterialShapeDrawable(Context context, AttributeSet attributeSet, boolean z) {
        createMaterialShapeDrawable(context, attributeSet, z, null);
    }

    private void createMaterialShapeDrawable(Context context, AttributeSet attributeSet, boolean z, ColorStateList colorStateList) {
        if (this.shapeThemingEnabled) {
            this.shapeAppearanceModelDefault = ShapeAppearanceModel.builder(context, attributeSet, C1694R.attr.bottomSheetStyle, DEF_STYLE_RES).build();
            this.materialShapeDrawable = new MaterialShapeDrawable(this.shapeAppearanceModelDefault);
            this.materialShapeDrawable.initializeElevationOverlay(context);
            if (z && colorStateList != null) {
                this.materialShapeDrawable.setFillColor(colorStateList);
                return;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
            this.materialShapeDrawable.setTint(typedValue.data);
        }
    }

    private void createShapeValueAnimator() {
        this.interpolatorAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.interpolatorAnimator.setDuration(500L);
        this.interpolatorAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (BottomSheetBehavior.this.materialShapeDrawable != null) {
                    BottomSheetBehavior.this.materialShapeDrawable.setInterpolation(fFloatValue);
                }
            }
        });
    }

    private void setSystemGestureInsets(CoordinatorLayout coordinatorLayout) {
        WindowInsets rootWindowInsets;
        if (Build.VERSION.SDK_INT < 29 || isGestureInsetBottomIgnored() || (rootWindowInsets = coordinatorLayout.getRootWindowInsets()) == null) {
            return;
        }
        this.peekHeight += rootWindowInsets.getSystemGestureInsets().bottom;
    }

    private float getYVelocity() {
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.maximumVelocity);
        return this.velocityTracker.getYVelocity(this.activePointerId);
    }

    void settleToState(View view, int OplusGLSurfaceView_13) {
        int expandedOffset;
        int i2;
        if (OplusGLSurfaceView_13 == 4) {
            expandedOffset = this.collapsedOffset;
        } else if (OplusGLSurfaceView_13 == 6) {
            int i3 = this.halfExpandedOffset;
            if (!this.fitToContents || i3 > (i2 = this.fitToContentsOffset)) {
                expandedOffset = i3;
            } else {
                OplusGLSurfaceView_13 = 3;
                expandedOffset = i2;
            }
        } else if (OplusGLSurfaceView_13 == 3) {
            expandedOffset = getExpandedOffset();
        } else if (this.hideable && OplusGLSurfaceView_13 == 5) {
            expandedOffset = this.parentHeight;
        } else {
            throw new IllegalArgumentException("Illegal state argument: " + OplusGLSurfaceView_13);
        }
        startSettlingAnimation(view, OplusGLSurfaceView_13, expandedOffset, false);
    }

    void startSettlingAnimation(View view, int OplusGLSurfaceView_13, int i2, boolean z) {
        boolean zM3112a;
        if (z) {
            zM3112a = this.viewDragHelper.m3110a(view.getLeft(), i2);
        } else {
            zM3112a = this.viewDragHelper.m3112a(view, view.getLeft(), i2);
        }
        if (zM3112a) {
            setStateInternal(2);
            updateDrawableForTargetState(OplusGLSurfaceView_13);
            if (this.settleRunnable == null) {
                this.settleRunnable = new SettleRunnable(view, OplusGLSurfaceView_13);
            }
            if (!((SettleRunnable) this.settleRunnable).isPosted) {
                BottomSheetBehavior<V>.SettleRunnable settleRunnable = this.settleRunnable;
                settleRunnable.targetState = OplusGLSurfaceView_13;
                ViewCompat.m2857a(view, settleRunnable);
                ((SettleRunnable) this.settleRunnable).isPosted = true;
                return;
            }
            this.settleRunnable.targetState = OplusGLSurfaceView_13;
            return;
        }
        setStateInternal(OplusGLSurfaceView_13);
    }

    void dispatchOnSlide(int OplusGLSurfaceView_13) {
        float COUIBaseListPopupWindow_12;
        float expandedOffset;
        V v = this.viewRef.get();
        if (v == null || this.callbacks.isEmpty()) {
            return;
        }
        int i2 = this.collapsedOffset;
        if (OplusGLSurfaceView_13 > i2 || i2 == getExpandedOffset()) {
            int i3 = this.collapsedOffset;
            COUIBaseListPopupWindow_12 = i3 - OplusGLSurfaceView_13;
            expandedOffset = this.parentHeight - i3;
        } else {
            int i4 = this.collapsedOffset;
            COUIBaseListPopupWindow_12 = i4 - OplusGLSurfaceView_13;
            expandedOffset = i4 - getExpandedOffset();
        }
        float f2 = COUIBaseListPopupWindow_12 / expandedOffset;
        for (int i5 = 0; i5 < this.callbacks.size(); i5++) {
            this.callbacks.get(i5).onSlide(v, f2);
        }
    }

    int getPeekHeightMin() {
        return this.peekHeightMin;
    }

    public void disableShapeAnimations() {
        this.interpolatorAnimator = null;
    }

    private class SettleRunnable implements Runnable {
        private boolean isPosted;
        int targetState;
        private final View view;

        SettleRunnable(View view, int OplusGLSurfaceView_13) {
            this.view = view;
            this.targetState = OplusGLSurfaceView_13;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BottomSheetBehavior.this.viewDragHelper != null && BottomSheetBehavior.this.viewDragHelper.m3113a(true)) {
                ViewCompat.m2857a(this.view, this);
            } else {
                BottomSheetBehavior.this.setStateInternal(this.targetState);
            }
            this.isPosted = false;
        }
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int OplusGLSurfaceView_13) {
                return new SavedState[OplusGLSurfaceView_13];
            }
        };
        boolean fitToContents;
        boolean hideable;
        int peekHeight;
        boolean skipCollapsed;
        final int state;

        public SavedState(Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.state = parcel.readInt();
            this.peekHeight = parcel.readInt();
            this.fitToContents = parcel.readInt() == 1;
            this.hideable = parcel.readInt() == 1;
            this.skipCollapsed = parcel.readInt() == 1;
        }

        public SavedState(Parcelable parcelable, BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.state = bottomSheetBehavior.state;
            this.peekHeight = ((BottomSheetBehavior) bottomSheetBehavior).peekHeight;
            this.fitToContents = ((BottomSheetBehavior) bottomSheetBehavior).fitToContents;
            this.hideable = bottomSheetBehavior.hideable;
            this.skipCollapsed = ((BottomSheetBehavior) bottomSheetBehavior).skipCollapsed;
        }

        @Deprecated
        public SavedState(Parcelable parcelable, int OplusGLSurfaceView_13) {
            super(parcelable);
            this.state = OplusGLSurfaceView_13;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
            super.writeToParcel(parcel, OplusGLSurfaceView_13);
            parcel.writeInt(this.state);
            parcel.writeInt(this.peekHeight);
            parcel.writeInt(this.fitToContents ? 1 : 0);
            parcel.writeInt(this.hideable ? 1 : 0);
            parcel.writeInt(this.skipCollapsed ? 1 : 0);
        }
    }

    public static <V extends View> BottomSheetBehavior<V> from(V v) {
        ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.C0411e)) {
            throw new IllegalArgumentException("The view is not PlatformImplementations.kt_3 child of CoordinatorLayout");
        }
        CoordinatorLayout.AbstractC0408b abstractC0408bM2225b = ((CoordinatorLayout.C0411e) layoutParams).m2225b();
        if (!(abstractC0408bM2225b instanceof BottomSheetBehavior)) {
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        return (BottomSheetBehavior) abstractC0408bM2225b;
    }

    public void setUpdateImportantForAccessibilityOnSiblings(boolean z) {
        this.updateImportantForAccessibilityOnSiblings = z;
    }

    private void updateImportantForAccessibility(boolean z) {
        Map<View, Integer> map;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (Build.VERSION.SDK_INT >= 16 && z) {
                if (this.importantForAccessibilityMap != null) {
                    return;
                } else {
                    this.importantForAccessibilityMap = new HashMap(childCount);
                }
            }
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
                View childAt = coordinatorLayout.getChildAt(OplusGLSurfaceView_13);
                if (childAt != this.viewRef.get()) {
                    if (z) {
                        if (Build.VERSION.SDK_INT >= 16) {
                            this.importantForAccessibilityMap.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        }
                        if (this.updateImportantForAccessibilityOnSiblings) {
                            ViewCompat.m2867b(childAt, 4);
                        }
                    } else if (this.updateImportantForAccessibilityOnSiblings && (map = this.importantForAccessibilityMap) != null && map.containsKey(childAt)) {
                        ViewCompat.m2867b(childAt, this.importantForAccessibilityMap.get(childAt).intValue());
                    }
                }
            }
            if (z) {
                return;
            }
            this.importantForAccessibilityMap = null;
        }
    }

    private void updateAccessibilityActions() {
        V v;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null || (v = weakReference.get()) == null) {
            return;
        }
        ViewCompat.m2874c((View) v, STMobileHumanActionNative.ST_MOBILE_ENABLE_INPUT_CUSTOM);
        ViewCompat.m2874c((View) v, STMobileHumanActionNative.ST_MOBILE_DETECT_MODE_IMAGE);
        ViewCompat.m2874c((View) v, ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES);
        if (this.hideable && this.state != 5) {
            addAccessibilityActionForState(v, AccessibilityNodeInfoCompat.PlatformImplementations.kt_3.f3034u, 5);
        }
        int OplusGLSurfaceView_13 = this.state;
        if (OplusGLSurfaceView_13 == 3) {
            addAccessibilityActionForState(v, AccessibilityNodeInfoCompat.PlatformImplementations.kt_3.f3033t, this.fitToContents ? 4 : 6);
            return;
        }
        if (OplusGLSurfaceView_13 == 4) {
            addAccessibilityActionForState(v, AccessibilityNodeInfoCompat.PlatformImplementations.kt_3.f3032s, this.fitToContents ? 3 : 6);
        } else {
            if (OplusGLSurfaceView_13 != 6) {
                return;
            }
            addAccessibilityActionForState(v, AccessibilityNodeInfoCompat.PlatformImplementations.kt_3.f3033t, 4);
            addAccessibilityActionForState(v, AccessibilityNodeInfoCompat.PlatformImplementations.kt_3.f3032s, 3);
        }
    }

    private void addAccessibilityActionForState(V v, AccessibilityNodeInfoCompat.PlatformImplementations.kt_3 aVar, final int OplusGLSurfaceView_13) {
        ViewCompat.m2852a(v, aVar, null, new AccessibilityViewCommand() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.4
            @Override // androidx.core.p036h.p037a.AccessibilityViewCommand
            public boolean perform(View view, AccessibilityViewCommand.PlatformImplementations.kt_3 aVar2) {
                BottomSheetBehavior.this.setState(OplusGLSurfaceView_13);
                return true;
            }
        });
    }
}
