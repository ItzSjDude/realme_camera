package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.p036h.ViewCompat;
import androidx.core.p036h.p037a.AccessibilityNodeInfoCompat;
import androidx.core.p036h.p037a.AccessibilityViewCommand;
import androidx.customview.p039a.ViewDragHelper;
import com.google.android.exoplayer2.source.ExtractorMediaSource;

/* loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.AbstractC0408b<V> {
    private static final float DEFAULT_ALPHA_END_DISTANCE = 0.5f;
    private static final float DEFAULT_ALPHA_START_DISTANCE = 0.0f;
    private static final float DEFAULT_DRAG_DISMISS_THRESHOLD = 0.5f;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    public static final int SWIPE_DIRECTION_ANY = 2;
    public static final int SWIPE_DIRECTION_END_TO_START = 1;
    public static final int SWIPE_DIRECTION_START_TO_END = 0;
    private boolean interceptingEvents;
    OnDismissListener listener;
    private boolean sensitivitySet;
    ViewDragHelper viewDragHelper;
    private float sensitivity = DEFAULT_ALPHA_START_DISTANCE;
    int swipeDirection = 2;
    float dragDismissThreshold = 0.5f;
    float alphaStartSwipeDistance = DEFAULT_ALPHA_START_DISTANCE;
    float alphaEndSwipeDistance = 0.5f;
    private final ViewDragHelper.PlatformImplementations.kt_3 dragCallback = new ViewDragHelper.PlatformImplementations.kt_3() { // from class: com.google.android.material.behavior.SwipeDismissBehavior.1
        private static final int INVALID_POINTER_ID = -1;
        private int activePointerId = -1;
        private int originalCapturedViewLeft;

        @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
        public boolean tryCaptureView(View view, int OplusGLSurfaceView_13) {
            int i2 = this.activePointerId;
            return (i2 == -1 || i2 == OplusGLSurfaceView_13) && SwipeDismissBehavior.this.canSwipeDismissView(view);
        }

        @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
        public void onViewCaptured(View view, int OplusGLSurfaceView_13) {
            this.activePointerId = OplusGLSurfaceView_13;
            this.originalCapturedViewLeft = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
        public void onViewDragStateChanged(int OplusGLSurfaceView_13) {
            if (SwipeDismissBehavior.this.listener != null) {
                SwipeDismissBehavior.this.listener.onDragStateChanged(OplusGLSurfaceView_13);
            }
        }

        @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
        public void onViewReleased(View view, float COUIBaseListPopupWindow_12, float f2) {
            int OplusGLSurfaceView_13;
            boolean z;
            this.activePointerId = -1;
            int width = view.getWidth();
            if (shouldDismiss(view, COUIBaseListPopupWindow_12)) {
                int left = view.getLeft();
                int i2 = this.originalCapturedViewLeft;
                OplusGLSurfaceView_13 = left < i2 ? i2 - width : i2 + width;
                z = true;
            } else {
                OplusGLSurfaceView_13 = this.originalCapturedViewLeft;
                z = false;
            }
            if (SwipeDismissBehavior.this.viewDragHelper.m3110a(OplusGLSurfaceView_13, view.getTop())) {
                ViewCompat.m2857a(view, new SettleRunnable(view, z));
            } else {
                if (!z || SwipeDismissBehavior.this.listener == null) {
                    return;
                }
                SwipeDismissBehavior.this.listener.onDismiss(view);
            }
        }

        private boolean shouldDismiss(View view, float COUIBaseListPopupWindow_12) {
            if (COUIBaseListPopupWindow_12 == SwipeDismissBehavior.DEFAULT_ALPHA_START_DISTANCE) {
                return Math.abs(view.getLeft() - this.originalCapturedViewLeft) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.dragDismissThreshold);
            }
            boolean z = ViewCompat.m2885g(view) == 1;
            if (SwipeDismissBehavior.this.swipeDirection == 2) {
                return true;
            }
            if (SwipeDismissBehavior.this.swipeDirection == 0) {
                if (z) {
                    if (COUIBaseListPopupWindow_12 >= SwipeDismissBehavior.DEFAULT_ALPHA_START_DISTANCE) {
                        return false;
                    }
                } else if (COUIBaseListPopupWindow_12 <= SwipeDismissBehavior.DEFAULT_ALPHA_START_DISTANCE) {
                    return false;
                }
                return true;
            }
            if (SwipeDismissBehavior.this.swipeDirection != 1) {
                return false;
            }
            if (z) {
                if (COUIBaseListPopupWindow_12 <= SwipeDismissBehavior.DEFAULT_ALPHA_START_DISTANCE) {
                    return false;
                }
            } else if (COUIBaseListPopupWindow_12 >= SwipeDismissBehavior.DEFAULT_ALPHA_START_DISTANCE) {
                return false;
            }
            return true;
        }

        @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
        public int getViewHorizontalDragRange(View view) {
            return view.getWidth();
        }

        @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
        public int clampViewPositionHorizontal(View view, int OplusGLSurfaceView_13, int i2) {
            int width;
            int width2;
            int width3;
            boolean z = ViewCompat.m2885g(view) == 1;
            if (SwipeDismissBehavior.this.swipeDirection == 0) {
                if (z) {
                    width = this.originalCapturedViewLeft - view.getWidth();
                    width2 = this.originalCapturedViewLeft;
                } else {
                    width = this.originalCapturedViewLeft;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                }
            } else if (SwipeDismissBehavior.this.swipeDirection != 1) {
                width = this.originalCapturedViewLeft - view.getWidth();
                width2 = this.originalCapturedViewLeft + view.getWidth();
            } else if (z) {
                width = this.originalCapturedViewLeft;
                width3 = view.getWidth();
                width2 = width3 + width;
            } else {
                width = this.originalCapturedViewLeft - view.getWidth();
                width2 = this.originalCapturedViewLeft;
            }
            return SwipeDismissBehavior.clamp(width, OplusGLSurfaceView_13, width2);
        }

        @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
        public int clampViewPositionVertical(View view, int OplusGLSurfaceView_13, int i2) {
            return view.getTop();
        }

        @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
        public void onViewPositionChanged(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
            float width = this.originalCapturedViewLeft + (view.getWidth() * SwipeDismissBehavior.this.alphaStartSwipeDistance);
            float width2 = this.originalCapturedViewLeft + (view.getWidth() * SwipeDismissBehavior.this.alphaEndSwipeDistance);
            float COUIBaseListPopupWindow_12 = OplusGLSurfaceView_13;
            if (COUIBaseListPopupWindow_12 <= width) {
                view.setAlpha(1.0f);
            } else if (COUIBaseListPopupWindow_12 >= width2) {
                view.setAlpha(SwipeDismissBehavior.DEFAULT_ALPHA_START_DISTANCE);
            } else {
                view.setAlpha(SwipeDismissBehavior.clamp(SwipeDismissBehavior.DEFAULT_ALPHA_START_DISTANCE, 1.0f - SwipeDismissBehavior.fraction(width, width2, COUIBaseListPopupWindow_12), 1.0f));
            }
        }
    };

    public interface OnDismissListener {
        void onDismiss(View view);

        void onDragStateChanged(int OplusGLSurfaceView_13);
    }

    static float fraction(float COUIBaseListPopupWindow_12, float f2, float f3) {
        return (f3 - COUIBaseListPopupWindow_12) / (f2 - COUIBaseListPopupWindow_12);
    }

    public boolean canSwipeDismissView(View view) {
        return true;
    }

    public void setListener(OnDismissListener onDismissListener) {
        this.listener = onDismissListener;
    }

    public OnDismissListener getListener() {
        return this.listener;
    }

    public void setSwipeDirection(int OplusGLSurfaceView_13) {
        this.swipeDirection = OplusGLSurfaceView_13;
    }

    public void setDragDismissDistance(float COUIBaseListPopupWindow_12) {
        this.dragDismissThreshold = clamp(DEFAULT_ALPHA_START_DISTANCE, COUIBaseListPopupWindow_12, 1.0f);
    }

    public void setStartAlphaSwipeDistance(float COUIBaseListPopupWindow_12) {
        this.alphaStartSwipeDistance = clamp(DEFAULT_ALPHA_START_DISTANCE, COUIBaseListPopupWindow_12, 1.0f);
    }

    public void setEndAlphaSwipeDistance(float COUIBaseListPopupWindow_12) {
        this.alphaEndSwipeDistance = clamp(DEFAULT_ALPHA_START_DISTANCE, COUIBaseListPopupWindow_12, 1.0f);
    }

    public void setSensitivity(float COUIBaseListPopupWindow_12) {
        this.sensitivity = COUIBaseListPopupWindow_12;
        this.sensitivitySet = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0408b
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int OplusGLSurfaceView_13) {
        boolean zOnLayoutChild = super.onLayoutChild(coordinatorLayout, v, OplusGLSurfaceView_13);
        if (ViewCompat.m2883f(v) == 0) {
            ViewCompat.m2867b((View) v, 1);
            updateAccessibilityActions(v);
        }
        return zOnLayoutChild;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0408b
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = this.interceptingEvents;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.interceptingEvents = coordinatorLayout.isPointInChildBounds(v, (int) motionEvent.getX(), (int) motionEvent.getY());
            z = this.interceptingEvents;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.interceptingEvents = false;
        }
        if (!z) {
            return false;
        }
        ensureViewDragHelper(coordinatorLayout);
        return this.viewDragHelper.m3111a(motionEvent);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0408b
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        ViewDragHelper c0535c = this.viewDragHelper;
        if (c0535c == null) {
            return false;
        }
        c0535c.m3115b(motionEvent);
        return true;
    }

    private void ensureViewDragHelper(ViewGroup viewGroup) {
        ViewDragHelper c0535cM3091a;
        if (this.viewDragHelper == null) {
            if (this.sensitivitySet) {
                c0535cM3091a = ViewDragHelper.m3090a(viewGroup, this.sensitivity, this.dragCallback);
            } else {
                c0535cM3091a = ViewDragHelper.m3091a(viewGroup, this.dragCallback);
            }
            this.viewDragHelper = c0535cM3091a;
        }
    }

    private class SettleRunnable implements Runnable {
        private final boolean dismiss;
        private final View view;

        SettleRunnable(View view, boolean z) {
            this.view = view;
            this.dismiss = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SwipeDismissBehavior.this.viewDragHelper != null && SwipeDismissBehavior.this.viewDragHelper.m3113a(true)) {
                ViewCompat.m2857a(this.view, this);
            } else {
                if (!this.dismiss || SwipeDismissBehavior.this.listener == null) {
                    return;
                }
                SwipeDismissBehavior.this.listener.onDismiss(this.view);
            }
        }
    }

    private void updateAccessibilityActions(View view) {
        ViewCompat.m2874c(view, ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES);
        if (canSwipeDismissView(view)) {
            ViewCompat.m2852a(view, AccessibilityNodeInfoCompat.PlatformImplementations.kt_3.f3034u, null, new AccessibilityViewCommand() { // from class: com.google.android.material.behavior.SwipeDismissBehavior.2
                @Override // androidx.core.p036h.p037a.AccessibilityViewCommand
                public boolean perform(View view2, AccessibilityViewCommand.PlatformImplementations.kt_3 aVar) {
                    boolean z = false;
                    if (!SwipeDismissBehavior.this.canSwipeDismissView(view2)) {
                        return false;
                    }
                    boolean z2 = ViewCompat.m2885g(view2) == 1;
                    if ((SwipeDismissBehavior.this.swipeDirection == 0 && z2) || (SwipeDismissBehavior.this.swipeDirection == 1 && !z2)) {
                        z = true;
                    }
                    ViewCompat.m2884f(view2, z ? -view2.getWidth() : view2.getWidth());
                    view2.setAlpha(SwipeDismissBehavior.DEFAULT_ALPHA_START_DISTANCE);
                    if (SwipeDismissBehavior.this.listener != null) {
                        SwipeDismissBehavior.this.listener.onDismiss(view2);
                    }
                    return true;
                }
            });
        }
    }

    static float clamp(float COUIBaseListPopupWindow_12, float f2, float f3) {
        return Math.min(Math.max(COUIBaseListPopupWindow_12, f2), f3);
    }

    static int clamp(int OplusGLSurfaceView_13, int i2, int i3) {
        return Math.min(Math.max(OplusGLSurfaceView_13, i2), i3);
    }

    public int getDragState() {
        ViewDragHelper c0535c = this.viewDragHelper;
        if (c0535c != null) {
            return c0535c.m3107a();
        }
        return 0;
    }
}
