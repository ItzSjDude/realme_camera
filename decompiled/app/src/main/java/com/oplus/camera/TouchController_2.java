package com.oplus.camera;

/* compiled from: FrontCameraZoomManager.java */
/* loaded from: classes2.dex */
public class m_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private volatile int f4861a = 0;

    /* renamed from: b_renamed, reason: collision with root package name */
    private volatile int f4862b = 0;

    /* renamed from: c_renamed, reason: collision with root package name */
    private volatile int f4863c = 0;
    private int d_renamed = 1;
    private volatile long e_renamed = 0;
    private android.os.ConditionVariable f_renamed = new android.os.ConditionVariable();
    private volatile float g_renamed = 1.17f;
    private volatile boolean h_renamed = false;
    private java.lang.String i_renamed = null;
    private android.animation.ValueAnimator j_renamed = null;
    private com.oplus.camera.ag_renamed.a_renamed k_renamed = null;
    private com.oplus.camera.capmode.a_renamed l_renamed = null;
    private float m_renamed = 0.0f;

    private boolean c_renamed(float f_renamed) {
        return f_renamed == 1.0f;
    }

    public float a_renamed() {
        float fB_renamed = b_renamed(false);
        this.g_renamed = fB_renamed;
        return fB_renamed;
    }

    public void a_renamed(int i_renamed) {
        final int i2 = this.f4861a;
        this.f4861a = i_renamed;
        if (this.f4861a == i2 || this.h_renamed) {
            return;
        }
        com.oplus.camera.w_renamed.d_renamed.a_renamed().a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.m_renamed.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (com.oplus.camera.m_renamed.this) {
                    if (com.oplus.camera.m_renamed.this.k_renamed.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FRONT_ZOOM_SWITCH)) {
                        com.oplus.camera.m_renamed.this.f4862b = 2;
                        if (com.oplus.camera.m_renamed.this.f4861a != i2) {
                            com.oplus.camera.m_renamed.this.g_renamed();
                        }
                    }
                }
            }
        }, "FrontCameraZoomManager");
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:32:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a_renamed(android.hardware.camera2.params.Face[] r12) {
        /*
            r11 = this;
            boolean r0 = r11.h_renamed
            if (r0 == 0) goto L5
            return
        L5:
            int r0 = r11.f4863c
            int r1 = r12.length
            r11.f4863c = r1
            int r1 = r12.length
            r2 = 2
            r3 = 0
            r4 = 1
            if (r1 < r2) goto L75
            int r1 = r12.length
            r5 = 0
            r6 = r3
            r7 = r5
            r8 = r7
        L15:
            if (r6 >= r1) goto L3a
            r9 = r12[r6]
            android.graphics.Rect r10 = r9.getBounds()
            int r10 = r10.width()
            android.graphics.Rect r9 = r9.getBounds()
            int r9 = r9.height()
            int r10 = r10 * r9
            float r9 = (float) r10
            int r10 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r10 < 0) goto L32
            r8 = r7
            r7 = r9
            goto L37
        L32:
            int r10 = (r9 > r8 ? 1 : (r9 == r8 ? 0 : -1))
            if (r10 <= 0) goto L37
            r8 = r9
        L37:
            int r6 = r6 + 1
            goto L15
        L3a:
            int r12 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r12 == 0) goto L75
            int r12 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r12 == 0) goto L75
            float r12 = r11.g_renamed
            r1 = 1065353216(0x3f800000, float:1.0)
            int r12 = java.lang.Float.compare(r12, r1)
            if (r12 != 0) goto L60
            float r12 = r8 / r7
            r1 = 1028443341(0x3d4ccccd, float:0.05)
            int r12 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r12 >= 0) goto L73
            float r12 = r11.m_renamed
            float r8 = r8 / r12
            r12 = 1001158290(0x3bac7692, float:0.005263158)
            int r12 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r12 < 0) goto L75
            goto L73
        L60:
            float r12 = r8 / r7
            r1 = 1034594987(0x3daaaaab, float:0.083333336)
            int r12 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r12 >= 0) goto L73
            float r12 = r11.m_renamed
            float r8 = r8 / r12
            r12 = 1003277517(0x3bcccccd, float:0.00625)
            int r12 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r12 < 0) goto L75
        L73:
            r12 = r3
            goto L76
        L75:
            r12 = r4
        L76:
            if (r12 == 0) goto L7a
            r11.f4863c = r4
        L7a:
            int r12 = r11.f4863c
            if (r12 < r2) goto L80
            r12 = r4
            goto L81
        L80:
            r12 = r3
        L81:
            if (r0 < r2) goto L84
            r3 = r4
        L84:
            if (r12 == r3) goto La1
            int r12 = r11.f4861a
            r1 = 90
            if (r12 == r1) goto La1
            int r12 = r11.f4861a
            r1 = 270(0x10e, float:3.78E-43)
            if (r12 != r1) goto L93
            goto La1
        L93:
            com.oplus.camera.w_renamed.d_renamed r12 = com.oplus.camera.w_renamed.d_renamed.a_renamed()
            com.oplus.camera.m_renamed$2 r1 = new com.oplus.camera.m_renamed$2
            r1.<init>()
            java.lang.String r11 = "FrontCameraZoomManager"
            r12.a_renamed(r1, r11)
        La1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.m_renamed.a_renamed(android.hardware.camera2.params.Face[]):void");
    }

    public void a_renamed(final boolean z_renamed) {
        com.oplus.camera.w_renamed.d_renamed.a_renamed().a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.m_renamed.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (com.oplus.camera.m_renamed.this) {
                    com.oplus.camera.m_renamed.this.f4862b = 5;
                    com.oplus.camera.m_renamed.this.h_renamed = true;
                    float f_renamed = com.oplus.camera.m_renamed.this.g_renamed;
                    if (z_renamed) {
                        com.oplus.camera.m_renamed.this.g_renamed = 1.0f;
                    } else {
                        com.oplus.camera.m_renamed.this.g_renamed = 1.17f;
                    }
                    com.oplus.camera.m_renamed.this.c_renamed(1);
                    if (f_renamed != com.oplus.camera.m_renamed.this.g_renamed) {
                        com.oplus.camera.m_renamed.this.b_renamed(f_renamed);
                    }
                }
            }
        }, "FrontCameraZoomManager");
    }

    public void b_renamed() {
        this.h_renamed = false;
        this.f4863c = 0;
    }

    private boolean e_renamed() {
        return this.f4863c >= 2;
    }

    public void a_renamed(int i_renamed, com.oplus.camera.capmode.a_renamed aVar) {
        this.d_renamed = i_renamed;
        this.l_renamed = aVar;
        if (this.d_renamed == 5) {
            b_renamed();
        }
    }

    public void c_renamed() {
        this.f4863c = 0;
    }

    public float d_renamed() {
        return this.g_renamed;
    }

    public void a_renamed(float f_renamed) {
        this.m_renamed = f_renamed;
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as_renamed a_renamed decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B_renamed:30:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:56:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private float b_renamed(boolean r11) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.m_renamed.b_renamed(boolean):float");
    }

    public void a_renamed(java.lang.String str) {
        if (str.equals(this.i_renamed)) {
            return;
        }
        b_renamed();
    }

    private boolean f_renamed() {
        return this.f4862b == 1 && android.os.SystemClock.uptimeMillis() - this.e_renamed <= 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g_renamed() {
        float fB_renamed = b_renamed(true);
        if (fB_renamed != this.g_renamed) {
            float f_renamed = this.g_renamed;
            if (f_renamed()) {
                h_renamed();
            } else {
                this.g_renamed = fB_renamed;
                com.oplus.camera.util.i_renamed.a_renamed().a_renamed("KEY_DELAY_CHANGE_FRONT_CAMERA_ZOOM");
                b_renamed(f_renamed);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b_renamed(float f_renamed) {
        if (this.k_renamed.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FRONT_ZOOM_SWITCH)) {
            if (f_renamed == this.g_renamed) {
                com.oplus.camera.e_renamed.c_renamed("FrontCameraZoomManager", "startValue == mZoomValue");
                return;
            }
            this.f_renamed.close();
            this.j_renamed = android.animation.ValueAnimator.ofFloat(f_renamed, this.g_renamed);
            this.j_renamed.setDuration(350L);
            this.j_renamed.setInterpolator(com.oplus.camera.professional.t_renamed.f5228b);
            this.j_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.-$$Lambda$m_renamed$-VNIbSUZb54EkMk5XQOpGZuugvY
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    this.f_renamed$0.a_renamed(valueAnimator);
                }
            });
            this.j_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.m_renamed.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    super.onAnimationEnd(animator);
                    com.oplus.camera.m_renamed.this.k_renamed.a_renamed(com.oplus.camera.m_renamed.this.g_renamed, true);
                    com.oplus.camera.m_renamed.this.f_renamed.open();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(android.animation.Animator animator) {
                    super.onAnimationCancel(animator);
                    com.oplus.camera.m_renamed.this.f_renamed.open();
                }
            });
            com.oplus.camera.util.Util.ay_renamed().post(new java.lang.Runnable() { // from class: com.oplus.camera.-$$Lambda$m_renamed$uPNUy8QN44h0doCdbZxo3BS44-o_renamed
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.k_renamed();
                }
            });
            this.f_renamed.block();
            this.e_renamed = android.os.SystemClock.uptimeMillis();
            this.f4862b = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a_renamed(android.animation.ValueAnimator valueAnimator) {
        this.k_renamed.a_renamed(((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k_renamed() {
        this.k_renamed.d_renamed(c_renamed(this.g_renamed));
        this.j_renamed.start();
        this.e_renamed = android.os.SystemClock.uptimeMillis();
    }

    private void h_renamed() {
        com.oplus.camera.util.i_renamed.a_renamed().a_renamed(1000L, "KEY_DELAY_CHANGE_FRONT_CAMERA_ZOOM", new java.lang.Runnable() { // from class: com.oplus.camera.-$$Lambda$m_renamed$59JZ0NHH8sz8S5OulanjXsPPWMA
            @Override // java.lang.Runnable
            public final void run() {
                this.f_renamed$0.j_renamed();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j_renamed() {
        synchronized (this) {
            float fB_renamed = b_renamed(true);
            if (fB_renamed != this.g_renamed) {
                float f_renamed = this.g_renamed;
                this.g_renamed = fB_renamed;
                b_renamed(f_renamed);
            }
        }
    }

    private boolean i_renamed() {
        return (this.f4861a == 0 || this.f4861a == 180) ? false : true;
    }

    public void a_renamed(com.oplus.camera.ag_renamed.a_renamed aVar) {
        this.k_renamed = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c_renamed(int i_renamed) {
        if (this.l_renamed != null) {
            com.oplus.camera.statistics.model.ZoomAdjustMsgData zoomAdjustMsgData = new com.oplus.camera.statistics.model.ZoomAdjustMsgData(com.oplus.camera.MyApplication.d_renamed());
            zoomAdjustMsgData.mCaptureType = !this.k_renamed.l_renamed() ? 1 : 0;
            zoomAdjustMsgData.mCaptureMode = this.k_renamed.n_renamed();
            zoomAdjustMsgData.mOrientation = this.f4861a;
            zoomAdjustMsgData.mZoomType = i_renamed;
            zoomAdjustMsgData.mZoomValue = java.lang.String.valueOf(this.g_renamed);
            zoomAdjustMsgData.mbVideoRecording = this.l_renamed.ao_renamed();
            if (this.l_renamed.i_renamed()) {
                zoomAdjustMsgData.mCameraEnterType = java.lang.String.valueOf(1);
            } else if (this.l_renamed.m_renamed()) {
                zoomAdjustMsgData.mCameraEnterType = java.lang.String.valueOf(3);
            } else {
                zoomAdjustMsgData.mCameraEnterType = java.lang.String.valueOf(2);
            }
            zoomAdjustMsgData.mCameraId = 1;
            zoomAdjustMsgData.mRearOrFront = com.oplus.camera.statistics.model.DcsMsgData.FRONT;
            if (!android.text.TextUtils.isEmpty(zoomAdjustMsgData.mCaptureMode) && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_QUICK_VIDEO_SUPPORT) && com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_COMMON.equals(zoomAdjustMsgData.mCaptureMode) && this.l_renamed.ay_renamed()) {
                zoomAdjustMsgData.mCaptureMode = com.oplus.camera.aps.constant.ApsConstant.REC_MODE_QUICK_VIDEO;
                zoomAdjustMsgData.mCaptureType = 1;
            }
            zoomAdjustMsgData.report();
        }
    }

    public void b_renamed(int i_renamed) {
        this.f4861a = i_renamed;
    }
}
