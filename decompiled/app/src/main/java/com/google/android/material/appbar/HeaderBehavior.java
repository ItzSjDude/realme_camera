package com.google.android.material.appbar;

/* loaded from: classes.dex */
abstract class HeaderBehavior<V_renamed extends android.view.View> extends com.google.android.material.appbar.ViewOffsetBehavior<V_renamed> {
    private static final int INVALID_POINTER = -1;
    private int activePointerId;
    private java.lang.Runnable flingRunnable;
    private boolean isBeingDragged;
    private int lastMotionY;
    android.widget.OverScroller scroller;
    private int touchSlop;
    private android.view.VelocityTracker velocityTracker;

    boolean canDragView(V_renamed v_renamed) {
        return false;
    }

    void onFlingFinished(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V_renamed v_renamed) {
    }

    public HeaderBehavior() {
        this.activePointerId = -1;
        this.touchSlop = -1;
    }

    public HeaderBehavior(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.activePointerId = -1;
        this.touchSlop = -1;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
    public boolean onInterceptTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V_renamed v_renamed, android.view.MotionEvent motionEvent) {
        int iFindPointerIndex;
        if (this.touchSlop < 0) {
            this.touchSlop = android.view.ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.isBeingDragged) {
            int i_renamed = this.activePointerId;
            if (i_renamed == -1 || (iFindPointerIndex = motionEvent.findPointerIndex(i_renamed)) == -1) {
                return false;
            }
            int y_renamed = (int) motionEvent.getY(iFindPointerIndex);
            if (java.lang.Math.abs(y_renamed - this.lastMotionY) > this.touchSlop) {
                this.lastMotionY = y_renamed;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.activePointerId = -1;
            int x_renamed = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            this.isBeingDragged = canDragView(v_renamed) && coordinatorLayout.isPointInChildBounds(v_renamed, x_renamed, y2);
            if (this.isBeingDragged) {
                this.lastMotionY = y2;
                this.activePointerId = motionEvent.getPointerId(0);
                ensureVelocityTracker();
                android.widget.OverScroller overScroller = this.scroller;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.scroller.abortAnimation();
                    return true;
                }
            }
        }
        android.view.VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:27:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:30:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:33:0x008c A_renamed[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:37:? A_renamed[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout r12, V_renamed r13, android.view.MotionEvent r14) {
        /*
            r11 = this;
            int r0 = r14.getActionMasked()
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 == r2) goto L4e
            r4 = 2
            if (r0 == r4) goto L2d
            r12 = 3
            if (r0 == r12) goto L72
            r12 = 6
            if (r0 == r12) goto L13
            goto L4c
        L13:
            int r12 = r14.getActionIndex()
            if (r12 != 0) goto L1b
            r12 = r2
            goto L1c
        L1b:
            r12 = r3
        L1c:
            int r13 = r14.getPointerId(r12)
            r11.activePointerId = r13
            float r12 = r14.getY(r12)
            r13 = 1056964608(0x3f000000, float:0.5)
            float r12 = r12 + r13
            int r12 = (int) r12
            r11.lastMotionY = r12
            goto L4c
        L2d:
            int r0 = r11.activePointerId
            int r0 = r14.findPointerIndex(r0)
            if (r0 != r1) goto L36
            return r3
        L36:
            float r0 = r14.getY(r0)
            int r0 = (int) r0
            int r1 = r11.lastMotionY
            int r7 = r1 - r0
            r11.lastMotionY = r0
            int r8 = r11.getMaxDragOffset(r13)
            r9 = 0
            r4 = r11
            r5 = r12
            r6 = r13
            r4.scroll(r5, r6, r7, r8, r9)
        L4c:
            r12 = r3
            goto L81
        L4e:
            android.view.VelocityTracker r0 = r11.velocityTracker
            if (r0 == 0) goto L72
            r0.addMovement(r14)
            android.view.VelocityTracker r0 = r11.velocityTracker
            r4 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r4)
            android.view.VelocityTracker r0 = r11.velocityTracker
            int r4 = r11.activePointerId
            float r10 = r0.getYVelocity(r4)
            int r0 = r11.getScrollRangeForDragFling(r13)
            int r8 = -r0
            r9 = 0
            r5 = r11
            r6 = r12
            r7 = r13
            r5.fling(r6, r7, r8, r9, r10)
            r12 = r2
            goto L73
        L72:
            r12 = r3
        L73:
            r11.isBeingDragged = r3
            r11.activePointerId = r1
            android.view.VelocityTracker r13 = r11.velocityTracker
            if (r13 == 0) goto L81
            r13.recycle()
            r13 = 0
            r11.velocityTracker = r13
        L81:
            android.view.VelocityTracker r13 = r11.velocityTracker
            if (r13 == 0) goto L88
            r13.addMovement(r14)
        L88:
            boolean r11 = r11.isBeingDragged
            if (r11 != 0) goto L90
            if (r12 == 0) goto L8f
            goto L90
        L8f:
            r2 = r3
        L90:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.HeaderBehavior.onTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    int setHeaderTopBottomOffset(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V_renamed v_renamed, int i_renamed) {
        return setHeaderTopBottomOffset(coordinatorLayout, v_renamed, i_renamed, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    int setHeaderTopBottomOffset(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V_renamed v_renamed, int i_renamed, int i2, int i3) {
        int iA;
        int topAndBottomOffset = getTopAndBottomOffset();
        if (i2 == 0 || topAndBottomOffset < i2 || topAndBottomOffset > i3 || topAndBottomOffset == (iA = androidx.core.c_renamed.a_renamed.a_renamed(i_renamed, i2, i3))) {
            return 0;
        }
        setTopAndBottomOffset(iA);
        return topAndBottomOffset - iA;
    }

    int getTopBottomOffsetForScrollingSibling() {
        return getTopAndBottomOffset();
    }

    final int scroll(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V_renamed v_renamed, int i_renamed, int i2, int i3) {
        return setHeaderTopBottomOffset(coordinatorLayout, v_renamed, getTopBottomOffsetForScrollingSibling() - i_renamed, i2, i3);
    }

    final boolean fling(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V_renamed v_renamed, int i_renamed, int i2, float f_renamed) {
        java.lang.Runnable runnable = this.flingRunnable;
        if (runnable != null) {
            v_renamed.removeCallbacks(runnable);
            this.flingRunnable = null;
        }
        if (this.scroller == null) {
            this.scroller = new android.widget.OverScroller(v_renamed.getContext());
        }
        this.scroller.fling(0, getTopAndBottomOffset(), 0, java.lang.Math.round(f_renamed), 0, 0, i_renamed, i2);
        if (this.scroller.computeScrollOffset()) {
            this.flingRunnable = new com.google.android.material.appbar.HeaderBehavior.FlingRunnable(coordinatorLayout, v_renamed);
            androidx.core.h_renamed.v_renamed.a_renamed(v_renamed, this.flingRunnable);
            return true;
        }
        onFlingFinished(coordinatorLayout, v_renamed);
        return false;
    }

    int getMaxDragOffset(V_renamed v_renamed) {
        return -v_renamed.getHeight();
    }

    int getScrollRangeForDragFling(V_renamed v_renamed) {
        return v_renamed.getHeight();
    }

    private void ensureVelocityTracker() {
        if (this.velocityTracker == null) {
            this.velocityTracker = android.view.VelocityTracker.obtain();
        }
    }

    private class FlingRunnable implements java.lang.Runnable {
        private final V_renamed layout;
        private final androidx.coordinatorlayout.widget.CoordinatorLayout parent;

        FlingRunnable(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V_renamed v_renamed) {
            this.parent = coordinatorLayout;
            this.layout = v_renamed;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.layout == null || com.google.android.material.appbar.HeaderBehavior.this.scroller == null) {
                return;
            }
            if (com.google.android.material.appbar.HeaderBehavior.this.scroller.computeScrollOffset()) {
                com.google.android.material.appbar.HeaderBehavior headerBehavior = com.google.android.material.appbar.HeaderBehavior.this;
                headerBehavior.setHeaderTopBottomOffset(this.parent, this.layout, headerBehavior.scroller.getCurrY());
                androidx.core.h_renamed.v_renamed.a_renamed(this.layout, this);
                return;
            }
            com.google.android.material.appbar.HeaderBehavior.this.onFlingFinished(this.parent, this.layout);
        }
    }
}
