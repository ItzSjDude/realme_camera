package com.oplus.camera.p172ui.menu.levelcontrol;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import com.oplus.camera.CameraLog;
import com.oplus.camera.p172ui.inverse.InverseManager;

/* loaded from: classes2.dex */
public class VerticalScrollBar extends BaseScrollBar {

    /* renamed from: A */
    private Interpolator f19563A;

    /* renamed from: w */
    private VelocityTracker f19564w;

    /* renamed from: x */
    private float f19565x;

    /* renamed from: y */
    private float f19566y;

    /* renamed from: z */
    private float f19567z;

    public VerticalScrollBar(Context context) {
        this(context, null, 0);
    }

    public VerticalScrollBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VerticalScrollBar(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f19565x = 0.0f;
        this.f19566y = 0.0f;
        this.f19567z = 0.0f;
        this.f19563A = new PathInterpolator(0.0f, 0.1f, 0.4f, 0.7f);
        this.f19599c = new GLProducerRender2DVertical(context, this.f19604h, this.f19605i);
        InverseManager.INS.registerInverse(context, this.f19599c);
        this.f19599c.m20955a(this.f19618v);
    }

    @Override // com.oplus.camera.p172ui.menu.levelcontrol.BaseScrollBar
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo20774a(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 0) {
            this.f19567z = motionEvent.getY(motionEvent.findPointerIndex(motionEvent.getPointerId(0)));
        }
        if (1 < motionEvent.getPointerCount()) {
            this.f19565x = motionEvent.getY(motionEvent.findPointerIndex(motionEvent.getPointerId(1)));
        }
    }

    @Override // com.oplus.camera.p172ui.menu.levelcontrol.BaseScrollBar
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo20773a(float COUIBaseListPopupWindow_12) {
        float positiveLimit = getPositiveLimit();
        float negativeLimit = getNegativeLimit();
        float currPosition = getCurrPosition() + COUIBaseListPopupWindow_12;
        if (currPosition > positiveLimit || currPosition <= negativeLimit) {
            float currPosition2 = getCurrPosition();
            currPosition = currPosition2 + (COUIBaseListPopupWindow_12 * 0.4f);
        }
        m20806a(currPosition, true);
    }

    @Override // com.oplus.camera.p172ui.menu.levelcontrol.BaseScrollBar
    /* renamed from: OplusGLSurfaceView_14 */
    protected void mo20779l() {
        int iMo20836d = this.f19600d != null ? this.f19600d.mo20836d() : 0;
        float currPosition = getCurrPosition();
        float fMo20778d = mo20778d(iMo20836d);
        float fMo20778d2 = mo20778d(mo20777c(Math.min(currPosition, fMo20778d)));
        CameraLog.m12954a("VerticalScrollBar", "scrollNear, limitPos: " + fMo20778d + ", currPos: " + getCurrPosition() + " -> " + fMo20778d2);
        m20812a(fMo20778d2, 26, this.f19603g, this.f19615s);
    }

    @Override // com.oplus.camera.p172ui.menu.levelcontrol.BaseScrollBar
    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void mo20776b(MotionEvent motionEvent) {
        if (!m20824k()) {
            CameraLog.m12967f("VerticalScrollBar", "scrollToByClick, texture not init, so return");
            mo20779l();
            return;
        }
        float y = this.f19607k - motionEvent.getY();
        float positiveLimit = getPositiveLimit();
        float negativeLimit = getNegativeLimit();
        float currPosition = getCurrPosition() + y;
        if (currPosition > positiveLimit || currPosition <= negativeLimit) {
            mo20779l();
            return;
        }
        int iMo20777c = mo20777c(currPosition);
        CameraLog.m12954a("VerticalScrollBar", "scrollToByClick, toPos: " + currPosition + ", index: " + this.f19602f + " -> " + iMo20777c);
        if (this.f19600d == null || this.f19600d.mo20833a(iMo20777c)) {
            return;
        }
        if (this.f19599c != null && Float.compare(currPosition - getCurrPosition(), 0.0f) != 0) {
            this.f19601e = true;
            m20810a(iMo20777c, false);
        }
        m20812a(mo20778d(iMo20777c), 26, this.f19603g, this.f19616t);
    }

    @Override // com.oplus.camera.p172ui.menu.levelcontrol.BaseScrollBar
    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void mo20775b(float COUIBaseListPopupWindow_12) {
        if (!m20824k()) {
            CameraLog.m12967f("VerticalScrollBar", "scrollToByFling, texture not init, so return");
            mo20779l();
            return;
        }
        float elementHeight = getElementHeight() * Math.abs(COUIBaseListPopupWindow_12 / 30000.0f);
        float positiveLimit = getPositiveLimit();
        float negativeLimit = getNegativeLimit();
        float currPosition = getCurrPosition() + (0.08f * COUIBaseListPopupWindow_12);
        int iAbs = 26;
        if (getCurrPosition() > positiveLimit || getCurrPosition() <= negativeLimit) {
            mo20779l();
        } else if (currPosition > positiveLimit) {
            float f2 = positiveLimit + elementHeight;
            if (currPosition > f2) {
                currPosition = f2;
            }
            iAbs = Math.abs(mo20777c(getCurrPosition()) - mo20777c(currPosition)) * 2;
            m20812a(currPosition, iAbs, this.f19563A, this.f19617u);
        } else if (currPosition <= negativeLimit) {
            float f3 = negativeLimit - elementHeight;
            if (currPosition < f3) {
                currPosition = f3;
            }
            iAbs = Math.abs(mo20777c(getCurrPosition()) - mo20777c(currPosition)) * 2;
            m20812a(currPosition, iAbs, this.f19563A, this.f19617u);
        } else {
            iAbs = 26 + (Math.abs(mo20777c(getCurrPosition()) - mo20777c(currPosition)) * 2);
            m20812a(mo20778d(mo20777c(currPosition)), iAbs, this.f19603g, this.f19615s);
        }
        CameraLog.m12954a("VerticalScrollBar", "scrollToByFling, toPos: " + currPosition + ", positiveLimit: " + positiveLimit + ", negativeLimit: " + negativeLimit + ", animFrame: " + iAbs + ", velocityY: " + COUIBaseListPopupWindow_12 + ", outLimitDiff: " + elementHeight);
    }

    @Override // com.oplus.camera.p172ui.menu.levelcontrol.BaseScrollBar
    /* renamed from: IntrinsicsJvm.kt_5 */
    protected float mo20778d(int OplusGLSurfaceView_13) {
        return (((((m20780m() ? getElementHeight() : getElementWidth()) + getElementGap()) * ((getModelNum() / 2.0f) - OplusGLSurfaceView_13)) - (getElementImageSize() / 2.0f)) - getElementGap()) - this.f19613q;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean m20780m() {
        return this.f19605i == 0;
    }

    @Override // com.oplus.camera.p172ui.menu.levelcontrol.BaseScrollBar
    /* renamed from: IntrinsicsJvm.kt_3 */
    protected int mo20777c(float COUIBaseListPopupWindow_12) {
        if (!m20824k()) {
            CameraLog.m12967f("VerticalScrollBar", "convertPositionToIndex, texture not init, so return");
            return 0;
        }
        float positiveLimit = getPositiveLimit();
        float negativeLimit = getNegativeLimit();
        int iRound = Math.round((getModelNum() / 2.0f) - ((this.f19613q + COUIBaseListPopupWindow_12) / ((m20780m() ? getElementHeight() : getElementWidth()) + getElementGap())));
        if (iRound < 0 || COUIBaseListPopupWindow_12 > positiveLimit) {
            return 0;
        }
        return (iRound >= getModelNum() || COUIBaseListPopupWindow_12 <= negativeLimit) ? getModelNum() - 1 : iRound;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float COUIBaseListPopupWindow_12;
        float y = motionEvent.getY();
        if (this.f19601e) {
            if (motionEvent.getActionMasked() == 0) {
                CameraLog.m12954a("VerticalScrollBar", "onTouchEvent, click scrolling, reset touch y");
                this.f19566y = y;
                this.f19567z = y;
                this.f19564w = VelocityTracker.obtain();
            }
            return true;
        }
        if (!this.f19600d.mo20834b()) {
            mo20779l();
            if (motionEvent.getActionMasked() == 0) {
                mo20774a(motionEvent);
            }
            return true;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            m20823j();
            this.f19566y = y;
            this.f19567z = y;
            this.f19564w = VelocityTracker.obtain();
        } else if (actionMasked == 1) {
            float yVelocity = 0.0f;
            VelocityTracker velocityTracker = this.f19564w;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
                this.f19564w.computeCurrentVelocity(1000);
                yVelocity = this.f19564w.getYVelocity();
                this.f19564w.clear();
            }
            if (Math.abs(yVelocity) >= 1000.0f) {
                mo20775b(yVelocity);
            } else if (Math.abs(y - this.f19566y) > 2.0f) {
                mo20779l();
            } else {
                mo20776b(motionEvent);
            }
        } else if (actionMasked == 2) {
            if (motionEvent.getPointerId(motionEvent.getActionIndex()) == 1) {
                COUIBaseListPopupWindow_12 = y - this.f19565x;
                this.f19565x = y;
            } else {
                COUIBaseListPopupWindow_12 = y - this.f19567z;
                this.f19567z = y;
            }
            VelocityTracker velocityTracker2 = this.f19564w;
            if (velocityTracker2 != null) {
                velocityTracker2.addMovement(motionEvent);
            }
            mo20773a(COUIBaseListPopupWindow_12);
        } else if (actionMasked == 3) {
            VelocityTracker velocityTracker3 = this.f19564w;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.f19564w = null;
            }
            if (Math.abs(y - this.f19566y) > 2.0f) {
                mo20779l();
            } else {
                mo20776b(motionEvent);
            }
        } else if (actionMasked == 5) {
            m20823j();
            mo20774a(motionEvent);
            this.f19564w = VelocityTracker.obtain();
        } else if (actionMasked == 6) {
            mo20774a(motionEvent);
        }
        return true;
    }

    private float getPositiveLimit() {
        return mo20778d(0) + this.f19610n;
    }

    private float getNegativeLimit() {
        return mo20778d(getModelNum() - 1) - this.f19611o;
    }
}
