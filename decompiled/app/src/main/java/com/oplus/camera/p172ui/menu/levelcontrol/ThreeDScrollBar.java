package com.oplus.camera.p172ui.menu.levelcontrol;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import com.oplus.camera.CameraLog;
import com.oplus.camera.p172ui.inverse.InverseManager;
import com.oplus.camera.util.Util;

/* loaded from: classes2.dex */
public class ThreeDScrollBar extends BaseScrollBar {

    /* renamed from: A */
    private float f19558A;

    /* renamed from: w */
    private Interpolator f19559w;

    /* renamed from: x */
    private VelocityTracker f19560x;

    /* renamed from: y */
    private float f19561y;

    /* renamed from: z */
    private float f19562z;

    public ThreeDScrollBar(Context context) {
        this(context, null);
    }

    public ThreeDScrollBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19559w = new PathInterpolator(0.0f, 0.1f, 0.4f, 0.7f);
        this.f19561y = 0.0f;
        this.f19562z = 0.0f;
        this.f19558A = 0.0f;
        this.f19599c = new GLProducerRender3D(context);
        InverseManager.INS.registerInverse(context, this.f19599c);
        this.f19599c.m20955a(this.f19618v);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float COUIBaseListPopupWindow_12;
        float x = motionEvent.getX();
        if (this.f19601e) {
            if (motionEvent.getActionMasked() == 0) {
                CameraLog.m12954a("ThreeDScrollBar", "onTouchEvent, click scrolling, reset touch x");
                this.f19562z = x;
                this.f19561y = x;
                this.f19560x = VelocityTracker.obtain();
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
            this.f19562z = x;
            this.f19561y = x;
            this.f19560x = VelocityTracker.obtain();
        } else if (actionMasked == 1) {
            float xVelocity = 0.0f;
            VelocityTracker velocityTracker = this.f19560x;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
                this.f19560x.computeCurrentVelocity(1000);
                xVelocity = this.f19560x.getXVelocity();
                this.f19560x.clear();
            }
            if (Math.abs(xVelocity) >= 1000.0f) {
                mo20775b(xVelocity);
            } else if (Math.abs(x - this.f19562z) > 2.0f) {
                mo20779l();
            } else {
                mo20776b(motionEvent);
            }
        } else if (actionMasked == 2) {
            if (motionEvent.getPointerId(motionEvent.getActionIndex()) == 1) {
                COUIBaseListPopupWindow_12 = x - this.f19558A;
                this.f19558A = x;
            } else {
                COUIBaseListPopupWindow_12 = x - this.f19561y;
                this.f19561y = x;
            }
            VelocityTracker velocityTracker2 = this.f19560x;
            if (velocityTracker2 != null) {
                velocityTracker2.addMovement(motionEvent);
            }
            mo20773a(COUIBaseListPopupWindow_12);
        } else if (actionMasked == 3) {
            VelocityTracker velocityTracker3 = this.f19560x;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.f19560x = null;
            }
            if (Math.abs(x - this.f19562z) > 2.0f) {
                mo20779l();
            } else {
                mo20776b(motionEvent);
            }
        } else if (actionMasked == 5) {
            m20823j();
            mo20774a(motionEvent);
            this.f19560x = VelocityTracker.obtain();
        } else if (actionMasked == 6) {
            mo20774a(motionEvent);
        }
        return true;
    }

    @Override // com.oplus.camera.p172ui.menu.levelcontrol.BaseScrollBar
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo20774a(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 0) {
            this.f19561y = motionEvent.getX(motionEvent.findPointerIndex(motionEvent.getPointerId(0)));
        }
        if (1 < motionEvent.getPointerCount()) {
            this.f19558A = motionEvent.getX(motionEvent.findPointerIndex(motionEvent.getPointerId(1)));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x003d A[PHI: r8
      0x003d: PHI (r8v4 float) = (r8v3 float), (r8v7 float) binds: [B:10:0x0052, B:5:0x003b] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.oplus.camera.p172ui.menu.levelcontrol.BaseScrollBar
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void mo20773a(float r8) {
        /*
            r7 = this;
            double r0 = com.oplus.camera.p172ui.menu.levelcontrol.MathUtil.m20982a()
            float r0 = (float) r0
            r1 = 1073741824(0x40000000, float:2.0)
            float r0 = r0 / r1
            com.oplus.camera.ui.menu.levelcontrol.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 r1 = r7.f19600d
            int r1 = r1.mo20836d()
            float r1 = r7.mo20778d(r1)
            int r2 = r7.getModelNum()
            r3 = 1
            int r2 = r2 - r3
            float r2 = r7.mo20778d(r2)
            float r4 = r7.getCurrPosition()
            float r5 = com.oplus.camera.p172ui.menu.levelcontrol.MathUtil.m20997f(r8)
            float r4 = r4 + r5
            int r5 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            r6 = 1053609165(0x3ecccccd, float:0.4)
            if (r5 <= 0) goto L3f
            float r2 = r7.getCurrPosition()
            float r8 = com.oplus.camera.p172ui.menu.levelcontrol.MathUtil.m20997f(r8)
            float r8 = r8 * r6
            float r4 = r2 + r8
            float r8 = r1 + r0
            int r0 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r0 <= 0) goto L55
        L3d:
            r4 = r8
            goto L55
        L3f:
            int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r1 > 0) goto L55
            float r1 = r7.getCurrPosition()
            float r8 = com.oplus.camera.p172ui.menu.levelcontrol.MathUtil.m20997f(r8)
            float r8 = r8 * r6
            float r4 = r1 + r8
            float r8 = r2 - r0
            int r0 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r0 >= 0) goto L55
            goto L3d
        L55:
            r7.m20806a(r4, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.menu.levelcontrol.ThreeDScrollBar.mo20773a(float):void");
    }

    @Override // com.oplus.camera.p172ui.menu.levelcontrol.BaseScrollBar
    /* renamed from: OplusGLSurfaceView_14 */
    protected void mo20779l() {
        int iMo20836d = this.f19600d != null ? this.f19600d.mo20836d() : 0;
        float currPosition = getCurrPosition();
        float fMo20778d = mo20778d(iMo20836d);
        if (currPosition <= fMo20778d) {
            fMo20778d = currPosition;
        }
        float fMo20778d2 = mo20778d(mo20777c(fMo20778d));
        CameraLog.m12954a("ThreeDScrollBar", "scrollNear, angle: " + getCurrPosition() + " -> " + fMo20778d2);
        m20812a(fMo20778d2, 26, this.f19603g, this.f19615s);
    }

    @Override // com.oplus.camera.p172ui.menu.levelcontrol.BaseScrollBar
    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void mo20776b(MotionEvent motionEvent) {
        if (!m20824k()) {
            CameraLog.m12967f("ThreeDScrollBar", "scrollToByClick, texture not init, so return");
            mo20779l();
            return;
        }
        float fM20997f = MathUtil.m20997f((Util.getScreenWidth() / 2) - motionEvent.getX());
        float fMo20778d = mo20778d(0) + (MathUtil.m20994e() / 2.0f);
        float fMo20778d2 = mo20778d(getModelNum() - 1) - (MathUtil.m20994e() / 2.0f);
        float currPosition = getCurrPosition() + fM20997f;
        if (currPosition > fMo20778d || currPosition <= fMo20778d2) {
            mo20779l();
            return;
        }
        int iMo20777c = mo20777c(currPosition);
        CameraLog.m12954a("ThreeDScrollBar", "scrollToByClick, toYAngle: " + currPosition + ", index: " + this.f19602f + " -> " + iMo20777c);
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
            CameraLog.m12967f("ThreeDScrollBar", "scrollToByFling, texture not init, so return");
            mo20779l();
            return;
        }
        float fM20997f = MathUtil.m20997f(0.08f * COUIBaseListPopupWindow_12);
        float fM20994e = MathUtil.m20994e() * Math.abs(COUIBaseListPopupWindow_12 / 30000.0f);
        float fMo20778d = mo20778d(this.f19600d.mo20836d());
        float fMo20778d2 = mo20778d(getModelNum() - 1);
        float currPosition = getCurrPosition() + fM20997f;
        int iAbs = 26;
        if (getCurrPosition() > fMo20778d || getCurrPosition() <= fMo20778d2) {
            mo20779l();
        } else if (currPosition > fMo20778d) {
            float f2 = fMo20778d + fM20994e;
            if (currPosition > f2) {
                currPosition = f2;
            }
            iAbs = Math.abs(mo20777c(getCurrPosition()) - mo20777c(currPosition)) * 2;
            m20812a(currPosition, iAbs, this.f19559w, this.f19617u);
        } else if (currPosition <= fMo20778d2) {
            float f3 = fMo20778d2 - fM20994e;
            if (currPosition < f3) {
                currPosition = f3;
            }
            iAbs = Math.abs(mo20777c(getCurrPosition()) - mo20777c(currPosition)) * 2;
            m20812a(currPosition, iAbs, this.f19559w, this.f19617u);
        } else {
            iAbs = 26 + (Math.abs(mo20777c(getCurrPosition()) - mo20777c(currPosition)) * 2);
            m20812a(mo20778d(mo20777c(currPosition)), iAbs, this.f19603g, this.f19615s);
        }
        CameraLog.m12954a("ThreeDScrollBar", "scrollToByFling, toYAngle: " + currPosition + ", positiveLimit: " + fMo20778d + ", negativeLimit: " + fMo20778d2 + ", animFrame: " + iAbs + ", velocityX: " + COUIBaseListPopupWindow_12 + ", outLimitDiff: " + fM20994e);
    }

    @Override // com.oplus.camera.p172ui.menu.levelcontrol.BaseScrollBar
    /* renamed from: IntrinsicsJvm.kt_5 */
    protected float mo20778d(int OplusGLSurfaceView_13) {
        return (-OplusGLSurfaceView_13) * MathUtil.m20998g();
    }

    @Override // com.oplus.camera.p172ui.menu.levelcontrol.BaseScrollBar
    /* renamed from: IntrinsicsJvm.kt_3 */
    protected int mo20777c(float COUIBaseListPopupWindow_12) {
        if (!m20824k()) {
            CameraLog.m12967f("ThreeDScrollBar", "convertPositionToIndex, texture not init, so return");
            return 0;
        }
        float fMo20778d = mo20778d(0);
        float fMo20778d2 = mo20778d(getModelNum() - 1);
        int iRound = Math.round(Math.abs(COUIBaseListPopupWindow_12 / MathUtil.m20998g()));
        if (iRound < 0 || COUIBaseListPopupWindow_12 > fMo20778d) {
            return 0;
        }
        return (iRound >= getModelNum() || COUIBaseListPopupWindow_12 <= fMo20778d2) ? getModelNum() - 1 : iRound;
    }
}
