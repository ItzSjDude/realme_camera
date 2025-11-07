package com.oplus.camera.ui.menu.levelcontrol;

/* loaded from: classes2.dex */
public class HorizontalScrollBar extends com.oplus.camera.ui.menu.levelcontrol.b_renamed {
    private int A_renamed;
    private final android.view.animation.Interpolator B_renamed;
    private float w_renamed;
    private float x_renamed;
    private float y_renamed;
    private android.view.VelocityTracker z_renamed;

    public HorizontalScrollBar(android.content.Context context) {
        this(context, null, 0);
    }

    public HorizontalScrollBar(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HorizontalScrollBar(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.w_renamed = 0.0f;
        this.x_renamed = 0.0f;
        this.y_renamed = 0.0f;
        this.A_renamed = 0;
        this.B_renamed = new android.view.animation.Interpolator() { // from class: com.oplus.camera.ui.menu.levelcontrol.HorizontalScrollBar.1
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f_renamed) {
                float f2 = f_renamed - 1.0f;
                return (f2 * f2 * f2 * f2 * f2) + 1.0f;
            }
        };
        this.f6477c = new com.oplus.camera.ui.menu.levelcontrol.l_renamed(context, this.h_renamed, this.i_renamed);
        com.oplus.camera.ui.inverse.e_renamed.INS.registerInverse(context, this.f6477c);
        this.f6477c.a_renamed(this.v_renamed);
        a_renamed(context);
    }

    public void setRearMirrorEnable(boolean z_renamed) {
        this.f6477c.a_renamed(z_renamed);
    }

    private void a_renamed(android.content.Context context) {
        this.A_renamed = android.view.ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.b_renamed
    protected void a_renamed(android.view.MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 0) {
            this.w_renamed = motionEvent.getX(motionEvent.findPointerIndex(motionEvent.getPointerId(0)));
        }
        if (1 < motionEvent.getPointerCount()) {
            this.y_renamed = motionEvent.getX(motionEvent.findPointerIndex(motionEvent.getPointerId(1)));
        }
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.b_renamed
    protected void a_renamed(float f_renamed) {
        float positiveLimit = getPositiveLimit();
        float negativeLimit = getNegativeLimit();
        float currPosition = getCurrPosition() - f_renamed;
        if (currPosition > positiveLimit || currPosition <= negativeLimit) {
            float currPosition2 = getCurrPosition();
            currPosition = currPosition2 - (f_renamed * 0.4f);
        }
        a_renamed(currPosition, true);
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.b_renamed
    protected void l_renamed() {
        int iD = this.d_renamed != null ? this.d_renamed.d_renamed() : 0;
        float currPosition = getCurrPosition();
        float positiveLimit = getPositiveLimit();
        float negativeLimit = getNegativeLimit();
        if (currPosition > positiveLimit || currPosition < negativeLimit) {
            performHapticFeedback(14);
        }
        float fD_renamed = d_renamed(iD);
        float fD2 = d_renamed(c_renamed(java.lang.Math.max(currPosition, fD_renamed)));
        com.oplus.camera.e_renamed.a_renamed("HorizontalScrollBar", "scrollNear, limitPos: " + fD_renamed + ", currPos: " + getCurrPosition() + " -> " + fD2);
        a_renamed(fD2, 26, this.g_renamed, this.s_renamed);
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.b_renamed
    protected void b_renamed(android.view.MotionEvent motionEvent) {
        if (!k_renamed()) {
            com.oplus.camera.e_renamed.f_renamed("HorizontalScrollBar", "scrollToByClick, texture not init, so return");
            l_renamed();
            return;
        }
        float x_renamed = this.j_renamed - motionEvent.getX();
        float elementWidth = getElementWidth() / 2.0f;
        float positiveLimit = (getPositiveLimit() - this.m_renamed) + elementWidth;
        float negativeLimit = (getNegativeLimit() + this.l_renamed) - elementWidth;
        float currPosition = getCurrPosition() - x_renamed;
        if (currPosition > positiveLimit || currPosition <= negativeLimit) {
            l_renamed();
            com.oplus.camera.e_renamed.b_renamed("HorizontalScrollBar", "scrollToByClick, toPos:" + currPosition + " greater than positiveLimit:" + positiveLimit + " or less than negativeLimit:" + negativeLimit + ", so return");
            return;
        }
        int iC = c_renamed(currPosition);
        com.oplus.camera.e_renamed.a_renamed("HorizontalScrollBar", "scrollToByClick, toPos: " + currPosition + ", index: " + this.f_renamed + " -> " + iC);
        float fD_renamed = d_renamed(iC);
        float elementWidth2 = fD_renamed - (getElementWidth() / 2.0f);
        float elementWidth3 = fD_renamed + (getElementWidth() / 2.0f);
        if (currPosition <= elementWidth2 || currPosition >= elementWidth3 || motionEvent.getY() > getElementWidth()) {
            l_renamed();
            return;
        }
        if (this.d_renamed == null || this.d_renamed.a_renamed(iC)) {
            return;
        }
        if (this.f6477c != null && java.lang.Float.compare(currPosition - getCurrPosition(), 0.0f) != 0) {
            this.e_renamed = true;
            a_renamed(iC, false);
        }
        a_renamed(d_renamed(iC), 26, this.B_renamed, this.t_renamed);
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.b_renamed
    protected void b_renamed(float f_renamed) {
        if (!k_renamed()) {
            com.oplus.camera.e_renamed.f_renamed("HorizontalScrollBar", "scrollToByFling, texture not init, so return");
            l_renamed();
            return;
        }
        float elementWidth = getElementWidth() / 2.0f;
        float positiveLimit = (getPositiveLimit() + elementWidth) - this.m_renamed;
        float negativeLimit = (getNegativeLimit() - elementWidth) + this.l_renamed;
        float currPosition = getCurrPosition() - (0.25f * f_renamed);
        int iAbs = 26;
        if (getCurrPosition() > positiveLimit || getCurrPosition() <= negativeLimit) {
            l_renamed();
        } else if (currPosition > positiveLimit) {
            float f2 = positiveLimit + elementWidth;
            if (currPosition > f2) {
                currPosition = f2;
            }
            iAbs = java.lang.Math.abs(c_renamed(getCurrPosition()) - c_renamed(currPosition)) * 2;
            performHapticFeedback(14);
            a_renamed(currPosition, iAbs, this.B_renamed, this.u_renamed);
        } else if (currPosition <= negativeLimit) {
            float f3 = negativeLimit - elementWidth;
            if (currPosition < f3) {
                currPosition = f3;
            }
            iAbs = java.lang.Math.abs(c_renamed(getCurrPosition()) - c_renamed(currPosition)) * 2;
            performHapticFeedback(14);
            a_renamed(currPosition, iAbs, this.B_renamed, this.u_renamed);
        } else {
            iAbs = 26 + (java.lang.Math.abs(c_renamed(getCurrPosition()) - c_renamed(currPosition)) * 2);
            a_renamed(d_renamed(c_renamed(currPosition)), iAbs, this.B_renamed, this.s_renamed);
        }
        com.oplus.camera.e_renamed.a_renamed("HorizontalScrollBar", "scrollToByFling, toPos: " + currPosition + ", positiveLimit: " + positiveLimit + ", negativeLimit: " + negativeLimit + ", animFrame: " + iAbs + ", velocityX: " + f_renamed + ", outLimitDiff: " + elementWidth);
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.b_renamed
    protected float d_renamed(int i_renamed) {
        return ((getElementWidth() + getElementGap()) * (i_renamed - (getModelNum() / 2.0f))) + (getElementWidth() / 2.0f) + getElementGap() + this.p_renamed;
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.b_renamed
    protected int c_renamed(float f_renamed) {
        if (!k_renamed()) {
            com.oplus.camera.e_renamed.f_renamed("HorizontalScrollBar", "convertPositionToIndex, texture not init, so return");
            return 0;
        }
        float positiveLimit = getPositiveLimit();
        float negativeLimit = getNegativeLimit();
        int iRound = java.lang.Math.round(((((f_renamed - (getElementWidth() / 2.0f)) - getElementGap()) - this.p_renamed) / (getElementWidth() + getElementGap())) + (getModelNum() / 2.0f));
        if (iRound < 0 || f_renamed <= negativeLimit) {
            return 0;
        }
        return (iRound >= getModelNum() || f_renamed > positiveLimit) ? getModelNum() - 1 : iRound;
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        float f_renamed;
        float x_renamed = motionEvent.getX();
        if (this.e_renamed) {
            if (motionEvent.getActionMasked() == 0) {
                com.oplus.camera.e_renamed.a_renamed("HorizontalScrollBar", "onTouchEvent, click scrolling, reset touch x_renamed");
                this.x_renamed = x_renamed;
                this.w_renamed = x_renamed;
                this.z_renamed = android.view.VelocityTracker.obtain();
            }
            return true;
        }
        if (!this.d_renamed.b_renamed()) {
            l_renamed();
            if (motionEvent.getActionMasked() == 0) {
                a_renamed(motionEvent);
            }
            return true;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            j_renamed();
            this.x_renamed = x_renamed;
            this.w_renamed = x_renamed;
            this.z_renamed = android.view.VelocityTracker.obtain();
        } else if (actionMasked == 1) {
            float xVelocity = 0.0f;
            android.view.VelocityTracker velocityTracker = this.z_renamed;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
                this.z_renamed.computeCurrentVelocity(1000, this.A_renamed);
                xVelocity = this.z_renamed.getXVelocity();
                this.z_renamed.clear();
            }
            if (java.lang.Math.abs(xVelocity) >= 1000.0f) {
                b_renamed(xVelocity);
            } else if (java.lang.Math.abs(x_renamed - this.x_renamed) > 2.0f) {
                l_renamed();
            } else {
                b_renamed(motionEvent);
            }
        } else if (actionMasked == 2) {
            if (motionEvent.getPointerId(motionEvent.getActionIndex()) == 1) {
                f_renamed = x_renamed - this.y_renamed;
                this.y_renamed = x_renamed;
            } else {
                f_renamed = x_renamed - this.w_renamed;
                this.w_renamed = x_renamed;
            }
            android.view.VelocityTracker velocityTracker2 = this.z_renamed;
            if (velocityTracker2 != null) {
                velocityTracker2.addMovement(motionEvent);
            }
            a_renamed(f_renamed);
        } else if (actionMasked == 3) {
            android.view.VelocityTracker velocityTracker3 = this.z_renamed;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.z_renamed = null;
            }
            if (java.lang.Math.abs(x_renamed - this.x_renamed) > 2.0f) {
                l_renamed();
            } else {
                b_renamed(motionEvent);
            }
        } else if (actionMasked == 5) {
            j_renamed();
            a_renamed(motionEvent);
            this.z_renamed = android.view.VelocityTracker.obtain();
        } else if (actionMasked == 6) {
            a_renamed(motionEvent);
        }
        return true;
    }

    private float getPositiveLimit() {
        return d_renamed(getModelNum() - 1) + this.m_renamed;
    }

    private float getNegativeLimit() {
        return d_renamed(0) - this.l_renamed;
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.b_renamed
    protected float getElementHeight() {
        if (this.i_renamed == 0) {
            return com.oplus.camera.ui.preview.a_renamed.j_renamed.B_renamed();
        }
        return com.oplus.camera.ui.preview.a_renamed.j_renamed.A_renamed();
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.b_renamed
    protected float getElementWidth() {
        if (this.i_renamed == 0) {
            return com.oplus.camera.ui.preview.a_renamed.j_renamed.A_renamed();
        }
        return com.oplus.camera.ui.preview.a_renamed.j_renamed.B_renamed();
    }
}
