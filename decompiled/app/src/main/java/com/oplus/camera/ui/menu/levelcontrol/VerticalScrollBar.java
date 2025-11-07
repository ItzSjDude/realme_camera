package com.oplus.camera.ui.menu.levelcontrol;

/* loaded from: classes2.dex */
public class VerticalScrollBar extends com.oplus.camera.ui.menu.levelcontrol.b_renamed {
    private android.view.animation.Interpolator A_renamed;
    private android.view.VelocityTracker w_renamed;
    private float x_renamed;
    private float y_renamed;
    private float z_renamed;

    public VerticalScrollBar(android.content.Context context) {
        this(context, null, 0);
    }

    public VerticalScrollBar(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VerticalScrollBar(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.x_renamed = 0.0f;
        this.y_renamed = 0.0f;
        this.z_renamed = 0.0f;
        this.A_renamed = new android.view.animation.PathInterpolator(0.0f, 0.1f, 0.4f, 0.7f);
        this.f6477c = new com.oplus.camera.ui.menu.levelcontrol.m_renamed(context, this.h_renamed, this.i_renamed);
        com.oplus.camera.ui.inverse.e_renamed.INS.registerInverse(context, this.f6477c);
        this.f6477c.a_renamed(this.v_renamed);
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.b_renamed
    protected void a_renamed(android.view.MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 0) {
            this.z_renamed = motionEvent.getY(motionEvent.findPointerIndex(motionEvent.getPointerId(0)));
        }
        if (1 < motionEvent.getPointerCount()) {
            this.x_renamed = motionEvent.getY(motionEvent.findPointerIndex(motionEvent.getPointerId(1)));
        }
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.b_renamed
    protected void a_renamed(float f_renamed) {
        float positiveLimit = getPositiveLimit();
        float negativeLimit = getNegativeLimit();
        float currPosition = getCurrPosition() + f_renamed;
        if (currPosition > positiveLimit || currPosition <= negativeLimit) {
            float currPosition2 = getCurrPosition();
            currPosition = currPosition2 + (f_renamed * 0.4f);
        }
        a_renamed(currPosition, true);
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.b_renamed
    protected void l_renamed() {
        int iD = this.d_renamed != null ? this.d_renamed.d_renamed() : 0;
        float currPosition = getCurrPosition();
        float fD_renamed = d_renamed(iD);
        float fD2 = d_renamed(c_renamed(java.lang.Math.min(currPosition, fD_renamed)));
        com.oplus.camera.e_renamed.a_renamed("VerticalScrollBar", "scrollNear, limitPos: " + fD_renamed + ", currPos: " + getCurrPosition() + " -> " + fD2);
        a_renamed(fD2, 26, this.g_renamed, this.s_renamed);
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.b_renamed
    protected void b_renamed(android.view.MotionEvent motionEvent) {
        if (!k_renamed()) {
            com.oplus.camera.e_renamed.f_renamed("VerticalScrollBar", "scrollToByClick, texture not init, so return");
            l_renamed();
            return;
        }
        float y_renamed = this.k_renamed - motionEvent.getY();
        float positiveLimit = getPositiveLimit();
        float negativeLimit = getNegativeLimit();
        float currPosition = getCurrPosition() + y_renamed;
        if (currPosition > positiveLimit || currPosition <= negativeLimit) {
            l_renamed();
            return;
        }
        int iC = c_renamed(currPosition);
        com.oplus.camera.e_renamed.a_renamed("VerticalScrollBar", "scrollToByClick, toPos: " + currPosition + ", index: " + this.f_renamed + " -> " + iC);
        if (this.d_renamed == null || this.d_renamed.a_renamed(iC)) {
            return;
        }
        if (this.f6477c != null && java.lang.Float.compare(currPosition - getCurrPosition(), 0.0f) != 0) {
            this.e_renamed = true;
            a_renamed(iC, false);
        }
        a_renamed(d_renamed(iC), 26, this.g_renamed, this.t_renamed);
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.b_renamed
    protected void b_renamed(float f_renamed) {
        if (!k_renamed()) {
            com.oplus.camera.e_renamed.f_renamed("VerticalScrollBar", "scrollToByFling, texture not init, so return");
            l_renamed();
            return;
        }
        float elementHeight = getElementHeight() * java.lang.Math.abs(f_renamed / 30000.0f);
        float positiveLimit = getPositiveLimit();
        float negativeLimit = getNegativeLimit();
        float currPosition = getCurrPosition() + (0.08f * f_renamed);
        int iAbs = 26;
        if (getCurrPosition() > positiveLimit || getCurrPosition() <= negativeLimit) {
            l_renamed();
        } else if (currPosition > positiveLimit) {
            float f2 = positiveLimit + elementHeight;
            if (currPosition > f2) {
                currPosition = f2;
            }
            iAbs = java.lang.Math.abs(c_renamed(getCurrPosition()) - c_renamed(currPosition)) * 2;
            a_renamed(currPosition, iAbs, this.A_renamed, this.u_renamed);
        } else if (currPosition <= negativeLimit) {
            float f3 = negativeLimit - elementHeight;
            if (currPosition < f3) {
                currPosition = f3;
            }
            iAbs = java.lang.Math.abs(c_renamed(getCurrPosition()) - c_renamed(currPosition)) * 2;
            a_renamed(currPosition, iAbs, this.A_renamed, this.u_renamed);
        } else {
            iAbs = 26 + (java.lang.Math.abs(c_renamed(getCurrPosition()) - c_renamed(currPosition)) * 2);
            a_renamed(d_renamed(c_renamed(currPosition)), iAbs, this.g_renamed, this.s_renamed);
        }
        com.oplus.camera.e_renamed.a_renamed("VerticalScrollBar", "scrollToByFling, toPos: " + currPosition + ", positiveLimit: " + positiveLimit + ", negativeLimit: " + negativeLimit + ", animFrame: " + iAbs + ", velocityY: " + f_renamed + ", outLimitDiff: " + elementHeight);
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.b_renamed
    protected float d_renamed(int i_renamed) {
        return (((((m_renamed() ? getElementHeight() : getElementWidth()) + getElementGap()) * ((getModelNum() / 2.0f) - i_renamed)) - (getElementImageSize() / 2.0f)) - getElementGap()) - this.q_renamed;
    }

    private boolean m_renamed() {
        return this.i_renamed == 0;
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.b_renamed
    protected int c_renamed(float f_renamed) {
        if (!k_renamed()) {
            com.oplus.camera.e_renamed.f_renamed("VerticalScrollBar", "convertPositionToIndex, texture not init, so return");
            return 0;
        }
        float positiveLimit = getPositiveLimit();
        float negativeLimit = getNegativeLimit();
        int iRound = java.lang.Math.round((getModelNum() / 2.0f) - ((this.q_renamed + f_renamed) / ((m_renamed() ? getElementHeight() : getElementWidth()) + getElementGap())));
        if (iRound < 0 || f_renamed > positiveLimit) {
            return 0;
        }
        return (iRound >= getModelNum() || f_renamed <= negativeLimit) ? getModelNum() - 1 : iRound;
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        float f_renamed;
        float y_renamed = motionEvent.getY();
        if (this.e_renamed) {
            if (motionEvent.getActionMasked() == 0) {
                com.oplus.camera.e_renamed.a_renamed("VerticalScrollBar", "onTouchEvent, click scrolling, reset touch y_renamed");
                this.y_renamed = y_renamed;
                this.z_renamed = y_renamed;
                this.w_renamed = android.view.VelocityTracker.obtain();
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
            this.y_renamed = y_renamed;
            this.z_renamed = y_renamed;
            this.w_renamed = android.view.VelocityTracker.obtain();
        } else if (actionMasked == 1) {
            float yVelocity = 0.0f;
            android.view.VelocityTracker velocityTracker = this.w_renamed;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
                this.w_renamed.computeCurrentVelocity(1000);
                yVelocity = this.w_renamed.getYVelocity();
                this.w_renamed.clear();
            }
            if (java.lang.Math.abs(yVelocity) >= 1000.0f) {
                b_renamed(yVelocity);
            } else if (java.lang.Math.abs(y_renamed - this.y_renamed) > 2.0f) {
                l_renamed();
            } else {
                b_renamed(motionEvent);
            }
        } else if (actionMasked == 2) {
            if (motionEvent.getPointerId(motionEvent.getActionIndex()) == 1) {
                f_renamed = y_renamed - this.x_renamed;
                this.x_renamed = y_renamed;
            } else {
                f_renamed = y_renamed - this.z_renamed;
                this.z_renamed = y_renamed;
            }
            android.view.VelocityTracker velocityTracker2 = this.w_renamed;
            if (velocityTracker2 != null) {
                velocityTracker2.addMovement(motionEvent);
            }
            a_renamed(f_renamed);
        } else if (actionMasked == 3) {
            android.view.VelocityTracker velocityTracker3 = this.w_renamed;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.w_renamed = null;
            }
            if (java.lang.Math.abs(y_renamed - this.y_renamed) > 2.0f) {
                l_renamed();
            } else {
                b_renamed(motionEvent);
            }
        } else if (actionMasked == 5) {
            j_renamed();
            a_renamed(motionEvent);
            this.w_renamed = android.view.VelocityTracker.obtain();
        } else if (actionMasked == 6) {
            a_renamed(motionEvent);
        }
        return true;
    }

    private float getPositiveLimit() {
        return d_renamed(0) + this.n_renamed;
    }

    private float getNegativeLimit() {
        return d_renamed(getModelNum() - 1) - this.o_renamed;
    }
}
