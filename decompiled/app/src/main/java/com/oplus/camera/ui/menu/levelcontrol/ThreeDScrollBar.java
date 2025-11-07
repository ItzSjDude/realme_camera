package com.oplus.camera.ui.menu.levelcontrol;

/* loaded from: classes2.dex */
public class ThreeDScrollBar extends com.oplus.camera.ui.menu.levelcontrol.b_renamed {
    private float A_renamed;
    private android.view.animation.Interpolator w_renamed;
    private android.view.VelocityTracker x_renamed;
    private float y_renamed;
    private float z_renamed;

    public ThreeDScrollBar(android.content.Context context) {
        this(context, null);
    }

    public ThreeDScrollBar(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.w_renamed = new android.view.animation.PathInterpolator(0.0f, 0.1f, 0.4f, 0.7f);
        this.y_renamed = 0.0f;
        this.z_renamed = 0.0f;
        this.A_renamed = 0.0f;
        this.f6477c = new com.oplus.camera.ui.menu.levelcontrol.n_renamed(context);
        com.oplus.camera.ui.inverse.e_renamed.INS.registerInverse(context, this.f6477c);
        this.f6477c.a_renamed(this.v_renamed);
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        float f_renamed;
        float x_renamed = motionEvent.getX();
        if (this.e_renamed) {
            if (motionEvent.getActionMasked() == 0) {
                com.oplus.camera.e_renamed.a_renamed("ThreeDScrollBar", "onTouchEvent, click scrolling, reset touch x_renamed");
                this.z_renamed = x_renamed;
                this.y_renamed = x_renamed;
                this.x_renamed = android.view.VelocityTracker.obtain();
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
            this.z_renamed = x_renamed;
            this.y_renamed = x_renamed;
            this.x_renamed = android.view.VelocityTracker.obtain();
        } else if (actionMasked == 1) {
            float xVelocity = 0.0f;
            android.view.VelocityTracker velocityTracker = this.x_renamed;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
                this.x_renamed.computeCurrentVelocity(1000);
                xVelocity = this.x_renamed.getXVelocity();
                this.x_renamed.clear();
            }
            if (java.lang.Math.abs(xVelocity) >= 1000.0f) {
                b_renamed(xVelocity);
            } else if (java.lang.Math.abs(x_renamed - this.z_renamed) > 2.0f) {
                l_renamed();
            } else {
                b_renamed(motionEvent);
            }
        } else if (actionMasked == 2) {
            if (motionEvent.getPointerId(motionEvent.getActionIndex()) == 1) {
                f_renamed = x_renamed - this.A_renamed;
                this.A_renamed = x_renamed;
            } else {
                f_renamed = x_renamed - this.y_renamed;
                this.y_renamed = x_renamed;
            }
            android.view.VelocityTracker velocityTracker2 = this.x_renamed;
            if (velocityTracker2 != null) {
                velocityTracker2.addMovement(motionEvent);
            }
            a_renamed(f_renamed);
        } else if (actionMasked == 3) {
            android.view.VelocityTracker velocityTracker3 = this.x_renamed;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.x_renamed = null;
            }
            if (java.lang.Math.abs(x_renamed - this.z_renamed) > 2.0f) {
                l_renamed();
            } else {
                b_renamed(motionEvent);
            }
        } else if (actionMasked == 5) {
            j_renamed();
            a_renamed(motionEvent);
            this.x_renamed = android.view.VelocityTracker.obtain();
        } else if (actionMasked == 6) {
            a_renamed(motionEvent);
        }
        return true;
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.b_renamed
    protected void a_renamed(android.view.MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 0) {
            this.y_renamed = motionEvent.getX(motionEvent.findPointerIndex(motionEvent.getPointerId(0)));
        }
        if (1 < motionEvent.getPointerCount()) {
            this.A_renamed = motionEvent.getX(motionEvent.findPointerIndex(motionEvent.getPointerId(1)));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:6:0x003d A_renamed[PHI: r8
      0x003d: PHI (r8v4 float) = (r8v3 float), (r8v7 float) binds: [B_renamed:10:0x0052, B_renamed:5:0x003b] A_renamed[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.oplus.camera.ui.menu.levelcontrol.b_renamed
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void a_renamed(float r8) {
        /*
            r7 = this;
            double r0 = com.oplus.camera.ui.menu.levelcontrol.o_renamed.a_renamed()
            float r0 = (float) r0
            r1 = 1073741824(0x40000000, float:2.0)
            float r0 = r0 / r1
            com.oplus.camera.ui.menu.levelcontrol.b_renamed$a_renamed r1 = r7.d_renamed
            int r1 = r1.d_renamed()
            float r1 = r7.d_renamed(r1)
            int r2 = r7.getModelNum()
            r3 = 1
            int r2 = r2 - r3
            float r2 = r7.d_renamed(r2)
            float r4 = r7.getCurrPosition()
            float r5 = com.oplus.camera.ui.menu.levelcontrol.o_renamed.f_renamed(r8)
            float r4 = r4 + r5
            int r5 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            r6 = 1053609165(0x3ecccccd, float:0.4)
            if (r5 <= 0) goto L3f
            float r2 = r7.getCurrPosition()
            float r8 = com.oplus.camera.ui.menu.levelcontrol.o_renamed.f_renamed(r8)
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
            float r8 = com.oplus.camera.ui.menu.levelcontrol.o_renamed.f_renamed(r8)
            float r8 = r8 * r6
            float r4 = r1 + r8
            float r8 = r2 - r0
            int r0 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r0 >= 0) goto L55
            goto L3d
        L55:
            r7.a_renamed(r4, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.menu.levelcontrol.ThreeDScrollBar.a_renamed(float):void");
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.b_renamed
    protected void l_renamed() {
        int iD = this.d_renamed != null ? this.d_renamed.d_renamed() : 0;
        float currPosition = getCurrPosition();
        float fD_renamed = d_renamed(iD);
        if (currPosition <= fD_renamed) {
            fD_renamed = currPosition;
        }
        float fD2 = d_renamed(c_renamed(fD_renamed));
        com.oplus.camera.e_renamed.a_renamed("ThreeDScrollBar", "scrollNear, angle: " + getCurrPosition() + " -> " + fD2);
        a_renamed(fD2, 26, this.g_renamed, this.s_renamed);
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.b_renamed
    protected void b_renamed(android.view.MotionEvent motionEvent) {
        if (!k_renamed()) {
            com.oplus.camera.e_renamed.f_renamed("ThreeDScrollBar", "scrollToByClick, texture not init, so return");
            l_renamed();
            return;
        }
        float f_renamed = com.oplus.camera.ui.menu.levelcontrol.o_renamed.f_renamed((com.oplus.camera.util.Util.getScreenWidth() / 2) - motionEvent.getX());
        float fD_renamed = d_renamed(0) + (com.oplus.camera.ui.menu.levelcontrol.o_renamed.e_renamed() / 2.0f);
        float fD2 = d_renamed(getModelNum() - 1) - (com.oplus.camera.ui.menu.levelcontrol.o_renamed.e_renamed() / 2.0f);
        float currPosition = getCurrPosition() + f_renamed;
        if (currPosition > fD_renamed || currPosition <= fD2) {
            l_renamed();
            return;
        }
        int iC = c_renamed(currPosition);
        com.oplus.camera.e_renamed.a_renamed("ThreeDScrollBar", "scrollToByClick, toYAngle: " + currPosition + ", index: " + this.f_renamed + " -> " + iC);
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
            com.oplus.camera.e_renamed.f_renamed("ThreeDScrollBar", "scrollToByFling, texture not init, so return");
            l_renamed();
            return;
        }
        float f2 = com.oplus.camera.ui.menu.levelcontrol.o_renamed.f_renamed(0.08f * f_renamed);
        float fE_renamed = com.oplus.camera.ui.menu.levelcontrol.o_renamed.e_renamed() * java.lang.Math.abs(f_renamed / 30000.0f);
        float fD_renamed = d_renamed(this.d_renamed.d_renamed());
        float fD2 = d_renamed(getModelNum() - 1);
        float currPosition = getCurrPosition() + f2;
        int iAbs = 26;
        if (getCurrPosition() > fD_renamed || getCurrPosition() <= fD2) {
            l_renamed();
        } else if (currPosition > fD_renamed) {
            float f3 = fD_renamed + fE_renamed;
            if (currPosition > f3) {
                currPosition = f3;
            }
            iAbs = java.lang.Math.abs(c_renamed(getCurrPosition()) - c_renamed(currPosition)) * 2;
            a_renamed(currPosition, iAbs, this.w_renamed, this.u_renamed);
        } else if (currPosition <= fD2) {
            float f4 = fD2 - fE_renamed;
            if (currPosition < f4) {
                currPosition = f4;
            }
            iAbs = java.lang.Math.abs(c_renamed(getCurrPosition()) - c_renamed(currPosition)) * 2;
            a_renamed(currPosition, iAbs, this.w_renamed, this.u_renamed);
        } else {
            iAbs = 26 + (java.lang.Math.abs(c_renamed(getCurrPosition()) - c_renamed(currPosition)) * 2);
            a_renamed(d_renamed(c_renamed(currPosition)), iAbs, this.g_renamed, this.s_renamed);
        }
        com.oplus.camera.e_renamed.a_renamed("ThreeDScrollBar", "scrollToByFling, toYAngle: " + currPosition + ", positiveLimit: " + fD_renamed + ", negativeLimit: " + fD2 + ", animFrame: " + iAbs + ", velocityX: " + f_renamed + ", outLimitDiff: " + fE_renamed);
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.b_renamed
    protected float d_renamed(int i_renamed) {
        return (-i_renamed) * com.oplus.camera.ui.menu.levelcontrol.o_renamed.g_renamed();
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.b_renamed
    protected int c_renamed(float f_renamed) {
        if (!k_renamed()) {
            com.oplus.camera.e_renamed.f_renamed("ThreeDScrollBar", "convertPositionToIndex, texture not init, so return");
            return 0;
        }
        float fD_renamed = d_renamed(0);
        float fD2 = d_renamed(getModelNum() - 1);
        int iRound = java.lang.Math.round(java.lang.Math.abs(f_renamed / com.oplus.camera.ui.menu.levelcontrol.o_renamed.g_renamed()));
        if (iRound < 0 || f_renamed > fD_renamed) {
            return 0;
        }
        return (iRound >= getModelNum() || f_renamed <= fD2) ? getModelNum() - 1 : iRound;
    }
}
