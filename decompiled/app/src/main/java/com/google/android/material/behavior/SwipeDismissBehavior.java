package com.google.android.material.behavior;

/* loaded from: classes.dex */
public class SwipeDismissBehavior<V_renamed extends android.view.View> extends androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed<V_renamed> {
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
    com.google.android.material.behavior.SwipeDismissBehavior.OnDismissListener listener;
    private boolean sensitivitySet;
    androidx.customview.a_renamed.c_renamed viewDragHelper;
    private float sensitivity = DEFAULT_ALPHA_START_DISTANCE;
    int swipeDirection = 2;
    float dragDismissThreshold = 0.5f;
    float alphaStartSwipeDistance = DEFAULT_ALPHA_START_DISTANCE;
    float alphaEndSwipeDistance = 0.5f;
    private final androidx.customview.a_renamed.c_renamed.a_renamed dragCallback = new androidx.customview.a_renamed.c_renamed.a_renamed() { // from class: com.google.android.material.behavior.SwipeDismissBehavior.1
        private static final int INVALID_POINTER_ID = -1;
        private int activePointerId = -1;
        private int originalCapturedViewLeft;

        @Override // androidx.customview.a_renamed.c_renamed.a_renamed
        public boolean tryCaptureView(android.view.View view, int i_renamed) {
            int i2 = this.activePointerId;
            return (i2 == -1 || i2 == i_renamed) && com.google.android.material.behavior.SwipeDismissBehavior.this.canSwipeDismissView(view);
        }

        @Override // androidx.customview.a_renamed.c_renamed.a_renamed
        public void onViewCaptured(android.view.View view, int i_renamed) {
            this.activePointerId = i_renamed;
            this.originalCapturedViewLeft = view.getLeft();
            android.view.ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // androidx.customview.a_renamed.c_renamed.a_renamed
        public void onViewDragStateChanged(int i_renamed) {
            if (com.google.android.material.behavior.SwipeDismissBehavior.this.listener != null) {
                com.google.android.material.behavior.SwipeDismissBehavior.this.listener.onDragStateChanged(i_renamed);
            }
        }

        @Override // androidx.customview.a_renamed.c_renamed.a_renamed
        public void onViewReleased(android.view.View view, float f_renamed, float f2) {
            int i_renamed;
            boolean z_renamed;
            this.activePointerId = -1;
            int width = view.getWidth();
            if (shouldDismiss(view, f_renamed)) {
                int left = view.getLeft();
                int i2 = this.originalCapturedViewLeft;
                i_renamed = left < i2 ? i2 - width : i2 + width;
                z_renamed = true;
            } else {
                i_renamed = this.originalCapturedViewLeft;
                z_renamed = false;
            }
            if (com.google.android.material.behavior.SwipeDismissBehavior.this.viewDragHelper.a_renamed(i_renamed, view.getTop())) {
                androidx.core.h_renamed.v_renamed.a_renamed(view, new com.google.android.material.behavior.SwipeDismissBehavior.SettleRunnable(view, z_renamed));
            } else {
                if (!z_renamed || com.google.android.material.behavior.SwipeDismissBehavior.this.listener == null) {
                    return;
                }
                com.google.android.material.behavior.SwipeDismissBehavior.this.listener.onDismiss(view);
            }
        }

        private boolean shouldDismiss(android.view.View view, float f_renamed) {
            if (f_renamed == com.google.android.material.behavior.SwipeDismissBehavior.DEFAULT_ALPHA_START_DISTANCE) {
                return java.lang.Math.abs(view.getLeft() - this.originalCapturedViewLeft) >= java.lang.Math.round(((float) view.getWidth()) * com.google.android.material.behavior.SwipeDismissBehavior.this.dragDismissThreshold);
            }
            boolean z_renamed = androidx.core.h_renamed.v_renamed.g_renamed(view) == 1;
            if (com.google.android.material.behavior.SwipeDismissBehavior.this.swipeDirection == 2) {
                return true;
            }
            if (com.google.android.material.behavior.SwipeDismissBehavior.this.swipeDirection == 0) {
                if (z_renamed) {
                    if (f_renamed >= com.google.android.material.behavior.SwipeDismissBehavior.DEFAULT_ALPHA_START_DISTANCE) {
                        return false;
                    }
                } else if (f_renamed <= com.google.android.material.behavior.SwipeDismissBehavior.DEFAULT_ALPHA_START_DISTANCE) {
                    return false;
                }
                return true;
            }
            if (com.google.android.material.behavior.SwipeDismissBehavior.this.swipeDirection != 1) {
                return false;
            }
            if (z_renamed) {
                if (f_renamed <= com.google.android.material.behavior.SwipeDismissBehavior.DEFAULT_ALPHA_START_DISTANCE) {
                    return false;
                }
            } else if (f_renamed >= com.google.android.material.behavior.SwipeDismissBehavior.DEFAULT_ALPHA_START_DISTANCE) {
                return false;
            }
            return true;
        }

        @Override // androidx.customview.a_renamed.c_renamed.a_renamed
        public int getViewHorizontalDragRange(android.view.View view) {
            return view.getWidth();
        }

        @Override // androidx.customview.a_renamed.c_renamed.a_renamed
        public int clampViewPositionHorizontal(android.view.View view, int i_renamed, int i2) {
            int width;
            int width2;
            int width3;
            boolean z_renamed = androidx.core.h_renamed.v_renamed.g_renamed(view) == 1;
            if (com.google.android.material.behavior.SwipeDismissBehavior.this.swipeDirection == 0) {
                if (z_renamed) {
                    width = this.originalCapturedViewLeft - view.getWidth();
                    width2 = this.originalCapturedViewLeft;
                } else {
                    width = this.originalCapturedViewLeft;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                }
            } else if (com.google.android.material.behavior.SwipeDismissBehavior.this.swipeDirection != 1) {
                width = this.originalCapturedViewLeft - view.getWidth();
                width2 = this.originalCapturedViewLeft + view.getWidth();
            } else if (z_renamed) {
                width = this.originalCapturedViewLeft;
                width3 = view.getWidth();
                width2 = width3 + width;
            } else {
                width = this.originalCapturedViewLeft - view.getWidth();
                width2 = this.originalCapturedViewLeft;
            }
            return com.google.android.material.behavior.SwipeDismissBehavior.clamp(width, i_renamed, width2);
        }

        @Override // androidx.customview.a_renamed.c_renamed.a_renamed
        public int clampViewPositionVertical(android.view.View view, int i_renamed, int i2) {
            return view.getTop();
        }

        @Override // androidx.customview.a_renamed.c_renamed.a_renamed
        public void onViewPositionChanged(android.view.View view, int i_renamed, int i2, int i3, int i4) {
            float width = this.originalCapturedViewLeft + (view.getWidth() * com.google.android.material.behavior.SwipeDismissBehavior.this.alphaStartSwipeDistance);
            float width2 = this.originalCapturedViewLeft + (view.getWidth() * com.google.android.material.behavior.SwipeDismissBehavior.this.alphaEndSwipeDistance);
            float f_renamed = i_renamed;
            if (f_renamed <= width) {
                view.setAlpha(1.0f);
            } else if (f_renamed >= width2) {
                view.setAlpha(com.google.android.material.behavior.SwipeDismissBehavior.DEFAULT_ALPHA_START_DISTANCE);
            } else {
                view.setAlpha(com.google.android.material.behavior.SwipeDismissBehavior.clamp(com.google.android.material.behavior.SwipeDismissBehavior.DEFAULT_ALPHA_START_DISTANCE, 1.0f - com.google.android.material.behavior.SwipeDismissBehavior.fraction(width, width2, f_renamed), 1.0f));
            }
        }
    };

    public interface OnDismissListener {
        void onDismiss(android.view.View view);

        void onDragStateChanged(int i_renamed);
    }

    static float fraction(float f_renamed, float f2, float f3) {
        return (f3 - f_renamed) / (f2 - f_renamed);
    }

    public boolean canSwipeDismissView(android.view.View view) {
        return true;
    }

    public void setListener(com.google.android.material.behavior.SwipeDismissBehavior.OnDismissListener onDismissListener) {
        this.listener = onDismissListener;
    }

    public com.google.android.material.behavior.SwipeDismissBehavior.OnDismissListener getListener() {
        return this.listener;
    }

    public void setSwipeDirection(int i_renamed) {
        this.swipeDirection = i_renamed;
    }

    public void setDragDismissDistance(float f_renamed) {
        this.dragDismissThreshold = clamp(DEFAULT_ALPHA_START_DISTANCE, f_renamed, 1.0f);
    }

    public void setStartAlphaSwipeDistance(float f_renamed) {
        this.alphaStartSwipeDistance = clamp(DEFAULT_ALPHA_START_DISTANCE, f_renamed, 1.0f);
    }

    public void setEndAlphaSwipeDistance(float f_renamed) {
        this.alphaEndSwipeDistance = clamp(DEFAULT_ALPHA_START_DISTANCE, f_renamed, 1.0f);
    }

    public void setSensitivity(float f_renamed) {
        this.sensitivity = f_renamed;
        this.sensitivitySet = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
    public boolean onLayoutChild(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V_renamed v_renamed, int i_renamed) {
        boolean zOnLayoutChild = super.onLayoutChild(coordinatorLayout, v_renamed, i_renamed);
        if (androidx.core.h_renamed.v_renamed.f_renamed(v_renamed) == 0) {
            androidx.core.h_renamed.v_renamed.b_renamed((android.view.View) v_renamed, 1);
            updateAccessibilityActions(v_renamed);
        }
        return zOnLayoutChild;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
    public boolean onInterceptTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V_renamed v_renamed, android.view.MotionEvent motionEvent) {
        boolean z_renamed = this.interceptingEvents;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.interceptingEvents = coordinatorLayout.isPointInChildBounds(v_renamed, (int) motionEvent.getX(), (int) motionEvent.getY());
            z_renamed = this.interceptingEvents;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.interceptingEvents = false;
        }
        if (!z_renamed) {
            return false;
        }
        ensureViewDragHelper(coordinatorLayout);
        return this.viewDragHelper.a_renamed(motionEvent);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
    public boolean onTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V_renamed v_renamed, android.view.MotionEvent motionEvent) {
        androidx.customview.a_renamed.c_renamed cVar = this.viewDragHelper;
        if (cVar == null) {
            return false;
        }
        cVar.b_renamed(motionEvent);
        return true;
    }

    private void ensureViewDragHelper(android.view.ViewGroup viewGroup) {
        androidx.customview.a_renamed.c_renamed cVarA;
        if (this.viewDragHelper == null) {
            if (this.sensitivitySet) {
                cVarA = androidx.customview.a_renamed.c_renamed.a_renamed(viewGroup, this.sensitivity, this.dragCallback);
            } else {
                cVarA = androidx.customview.a_renamed.c_renamed.a_renamed(viewGroup, this.dragCallback);
            }
            this.viewDragHelper = cVarA;
        }
    }

    private class SettleRunnable implements java.lang.Runnable {
        private final boolean dismiss;
        private final android.view.View view;

        SettleRunnable(android.view.View view, boolean z_renamed) {
            this.view = view;
            this.dismiss = z_renamed;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.google.android.material.behavior.SwipeDismissBehavior.this.viewDragHelper != null && com.google.android.material.behavior.SwipeDismissBehavior.this.viewDragHelper.a_renamed(true)) {
                androidx.core.h_renamed.v_renamed.a_renamed(this.view, this);
            } else {
                if (!this.dismiss || com.google.android.material.behavior.SwipeDismissBehavior.this.listener == null) {
                    return;
                }
                com.google.android.material.behavior.SwipeDismissBehavior.this.listener.onDismiss(this.view);
            }
        }
    }

    private void updateAccessibilityActions(android.view.View view) {
        androidx.core.h_renamed.v_renamed.c_renamed(view, com.google.android.exoplayer2.source.ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES);
        if (canSwipeDismissView(view)) {
            androidx.core.h_renamed.v_renamed.a_renamed(view, androidx.core.h_renamed.a_renamed.d_renamed.a_renamed.u_renamed, null, new androidx.core.h_renamed.a_renamed.g_renamed() { // from class: com.google.android.material.behavior.SwipeDismissBehavior.2
                @Override // androidx.core.h_renamed.a_renamed.g_renamed
                public boolean perform(android.view.View view2, androidx.core.h_renamed.a_renamed.g_renamed.a_renamed aVar) {
                    boolean z_renamed = false;
                    if (!com.google.android.material.behavior.SwipeDismissBehavior.this.canSwipeDismissView(view2)) {
                        return false;
                    }
                    boolean z2 = androidx.core.h_renamed.v_renamed.g_renamed(view2) == 1;
                    if ((com.google.android.material.behavior.SwipeDismissBehavior.this.swipeDirection == 0 && z2) || (com.google.android.material.behavior.SwipeDismissBehavior.this.swipeDirection == 1 && !z2)) {
                        z_renamed = true;
                    }
                    androidx.core.h_renamed.v_renamed.f_renamed(view2, z_renamed ? -view2.getWidth() : view2.getWidth());
                    view2.setAlpha(com.google.android.material.behavior.SwipeDismissBehavior.DEFAULT_ALPHA_START_DISTANCE);
                    if (com.google.android.material.behavior.SwipeDismissBehavior.this.listener != null) {
                        com.google.android.material.behavior.SwipeDismissBehavior.this.listener.onDismiss(view2);
                    }
                    return true;
                }
            });
        }
    }

    static float clamp(float f_renamed, float f2, float f3) {
        return java.lang.Math.min(java.lang.Math.max(f_renamed, f2), f3);
    }

    static int clamp(int i_renamed, int i2, int i3) {
        return java.lang.Math.min(java.lang.Math.max(i_renamed, i2), i3);
    }

    public int getDragState() {
        androidx.customview.a_renamed.c_renamed cVar = this.viewDragHelper;
        if (cVar != null) {
            return cVar.a_renamed();
        }
        return 0;
    }
}
