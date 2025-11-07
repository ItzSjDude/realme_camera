package com.oplus.camera;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.text.TextUtils;
import com.oplus.camera.ZoomManager;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.capmode.CameraInterface;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p181w.CameraThreadExector;
import com.oplus.camera.professional.ProfessionalAnimConstant;
import com.oplus.camera.statistics.model.DcsMsgData;
import com.oplus.camera.statistics.model.ZoomAdjustMsgData;
import com.oplus.camera.util.MultipleTaskUtils;
import com.oplus.camera.util.Util;

/* compiled from: FrontCameraZoomManager.java */
/* renamed from: com.oplus.camera.OplusGLSurfaceView_6 */
/* loaded from: classes2.dex */
public class FrontCameraZoomManager {

    /* renamed from: PlatformImplementations.kt_3 */
    private volatile int f14677a = 0;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private volatile int f14678b = 0;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private volatile int f14679c = 0;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f14680d = 1;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private volatile long f14681e = 0;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private ConditionVariable f14682f = new ConditionVariable();

    /* renamed from: COUIBaseListPopupWindow_11 */
    private volatile float f14683g = 1.17f;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private volatile boolean f14684h = false;

    /* renamed from: OplusGLSurfaceView_13 */
    private String f14685i = null;

    /* renamed from: OplusGLSurfaceView_15 */
    private ValueAnimator f14686j = null;

    /* renamed from: OplusGLSurfaceView_5 */
    private ZoomManager.PlatformImplementations.kt_3 f14687k = null;

    /* renamed from: OplusGLSurfaceView_14 */
    private CameraInterface f14688l = null;

    /* renamed from: OplusGLSurfaceView_6 */
    private float f14689m = 0.0f;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean m14666c(float COUIBaseListPopupWindow_12) {
        return COUIBaseListPopupWindow_12 == 1.0f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public float m14677a() {
        float fM14659b = m14659b(false);
        this.f14683g = fM14659b;
        return fM14659b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14679a(int OplusGLSurfaceView_13) {
        final int i2 = this.f14677a;
        this.f14677a = OplusGLSurfaceView_13;
        if (this.f14677a == i2 || this.f14684h) {
            return;
        }
        CameraThreadExector.m24695a().m24696a(new Runnable() { // from class: com.oplus.camera.OplusGLSurfaceView_6.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (FrontCameraZoomManager.this) {
                    if (FrontCameraZoomManager.this.f14687k.mo10966a(CameraUIInterface.KEY_FRONT_ZOOM_SWITCH)) {
                        FrontCameraZoomManager.this.f14678b = 2;
                        if (FrontCameraZoomManager.this.f14677a != i2) {
                            FrontCameraZoomManager.this.m14672g();
                        }
                    }
                }
            }
        }, "FrontCameraZoomManager");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0075  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m14684a(android.hardware.camera2.params.Face[] r12) {
        /*
            r11 = this;
            boolean r0 = r11.f14684h
            if (r0 == 0) goto L5
            return
        L5:
            int r0 = r11.f14679c
            int r1 = r12.length
            r11.f14679c = r1
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
            float r12 = r11.f14683g
            r1 = 1065353216(0x3f800000, float:1.0)
            int r12 = java.lang.Float.compare(r12, r1)
            if (r12 != 0) goto L60
            float r12 = r8 / r7
            r1 = 1028443341(0x3d4ccccd, float:0.05)
            int r12 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r12 >= 0) goto L73
            float r12 = r11.f14689m
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
            float r12 = r11.f14689m
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
            r11.f14679c = r4
        L7a:
            int r12 = r11.f14679c
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
            int r12 = r11.f14677a
            r1 = 90
            if (r12 == r1) goto La1
            int r12 = r11.f14677a
            r1 = 270(0x10e, float:3.78E-43)
            if (r12 != r1) goto L93
            goto La1
        L93:
            com.oplus.camera.w.IntrinsicsJvm.kt_5 r12 = com.oplus.camera.p181w.CameraThreadExector.m24695a()
            com.oplus.camera.OplusGLSurfaceView_6$2 r1 = new com.oplus.camera.OplusGLSurfaceView_6$2
            r1.<init>()
            java.lang.String r11 = "FrontCameraZoomManager"
            r12.m24696a(r1, r11)
        La1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.FrontCameraZoomManager.m14684a(android.hardware.camera2.params.Face[]):void");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14683a(final boolean z) {
        CameraThreadExector.m24695a().m24696a(new Runnable() { // from class: com.oplus.camera.OplusGLSurfaceView_6.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (FrontCameraZoomManager.this) {
                    FrontCameraZoomManager.this.f14678b = 5;
                    FrontCameraZoomManager.this.f14684h = true;
                    float COUIBaseListPopupWindow_12 = FrontCameraZoomManager.this.f14683g;
                    if (z) {
                        FrontCameraZoomManager.this.f14683g = 1.0f;
                    } else {
                        FrontCameraZoomManager.this.f14683g = 1.17f;
                    }
                    FrontCameraZoomManager.this.m14664c(1);
                    if (COUIBaseListPopupWindow_12 != FrontCameraZoomManager.this.f14683g) {
                        FrontCameraZoomManager.this.m14661b(COUIBaseListPopupWindow_12);
                    }
                }
            }
        }, "FrontCameraZoomManager");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m14685b() {
        this.f14684h = false;
        this.f14679c = 0;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean m14669e() {
        return this.f14679c >= 2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14680a(int OplusGLSurfaceView_13, CameraInterface interfaceC2646a) {
        this.f14680d = OplusGLSurfaceView_13;
        this.f14688l = interfaceC2646a;
        if (this.f14680d == 5) {
            m14685b();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m14687c() {
        this.f14679c = 0;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public float m14688d() {
        return this.f14683g;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14678a(float COUIBaseListPopupWindow_12) {
        this.f14689m = COUIBaseListPopupWindow_12;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as PlatformImplementations.kt_3 decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a7  */
    /* renamed from: IntrinsicsJvm.kt_4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private float m14659b(boolean r11) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.FrontCameraZoomManager.m14659b(boolean):float");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14682a(String str) {
        if (str.equals(this.f14685i)) {
            return;
        }
        m14685b();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean m14671f() {
        return this.f14678b == 1 && SystemClock.uptimeMillis() - this.f14681e <= 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_11 */
    public synchronized void m14672g() {
        float fM14659b = m14659b(true);
        if (fM14659b != this.f14683g) {
            float COUIBaseListPopupWindow_12 = this.f14683g;
            if (m14671f()) {
                m14673h();
            } else {
                this.f14683g = fM14659b;
                MultipleTaskUtils.m24579a().m24581a("KEY_DELAY_CHANGE_FRONT_CAMERA_ZOOM");
                m14661b(COUIBaseListPopupWindow_12);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m14661b(float COUIBaseListPopupWindow_12) {
        if (this.f14687k.mo10966a(CameraUIInterface.KEY_FRONT_ZOOM_SWITCH)) {
            if (COUIBaseListPopupWindow_12 == this.f14683g) {
                CameraLog.m12962c("FrontCameraZoomManager", "startValue == mZoomValue");
                return;
            }
            this.f14682f.close();
            this.f14686j = ValueAnimator.ofFloat(COUIBaseListPopupWindow_12, this.f14683g);
            this.f14686j.setDuration(350L);
            this.f14686j.setInterpolator(ProfessionalAnimConstant.f15695b);
            this.f14686j.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.-$$Lambda$OplusGLSurfaceView_6$-VNIbSUZb54EkMk5XQOpGZuugvY
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.COUIBaseListPopupWindow_12$0.m14657a(valueAnimator);
                }
            });
            this.f14686j.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.OplusGLSurfaceView_6.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    FrontCameraZoomManager.this.f14687k.mo10960a(FrontCameraZoomManager.this.f14683g, true);
                    FrontCameraZoomManager.this.f14682f.open();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    super.onAnimationCancel(animator);
                    FrontCameraZoomManager.this.f14682f.open();
                }
            });
            Util.m24362ay().post(new Runnable() { // from class: com.oplus.camera.-$$Lambda$OplusGLSurfaceView_6$uPNUy8QN44h0doCdbZxo3BS44-o
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.m14676k();
                }
            });
            this.f14682f.block();
            this.f14681e = SystemClock.uptimeMillis();
            this.f14678b = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m14657a(ValueAnimator valueAnimator) {
        this.f14687k.mo10960a(((Float) valueAnimator.getAnimatedValue()).floatValue(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_5 */
    public /* synthetic */ void m14676k() {
        this.f14687k.mo10975d(m14666c(this.f14683g));
        this.f14686j.start();
        this.f14681e = SystemClock.uptimeMillis();
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m14673h() {
        MultipleTaskUtils.m24579a().m24580a(1000L, "KEY_DELAY_CHANGE_FRONT_CAMERA_ZOOM", new Runnable() { // from class: com.oplus.camera.-$$Lambda$OplusGLSurfaceView_6$59JZ0NHH8sz8S5OulanjXsPPWMA
            @Override // java.lang.Runnable
            public final void run() {
                this.COUIBaseListPopupWindow_12$0.m14675j();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_15 */
    public /* synthetic */ void m14675j() {
        synchronized (this) {
            float fM14659b = m14659b(true);
            if (fM14659b != this.f14683g) {
                float COUIBaseListPopupWindow_12 = this.f14683g;
                this.f14683g = fM14659b;
                m14661b(COUIBaseListPopupWindow_12);
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean m14674i() {
        return (this.f14677a == 0 || this.f14677a == 180) ? false : true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14681a(ZoomManager.PlatformImplementations.kt_3 aVar) {
        this.f14687k = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m14664c(int OplusGLSurfaceView_13) {
        if (this.f14688l != null) {
            ZoomAdjustMsgData zoomAdjustMsgData = new ZoomAdjustMsgData(MyApplication.m11092d());
            zoomAdjustMsgData.mCaptureType = !this.f14687k.mo10983l() ? 1 : 0;
            zoomAdjustMsgData.mCaptureMode = this.f14687k.mo10985n();
            zoomAdjustMsgData.mOrientation = this.f14677a;
            zoomAdjustMsgData.mZoomType = OplusGLSurfaceView_13;
            zoomAdjustMsgData.mZoomValue = String.valueOf(this.f14683g);
            zoomAdjustMsgData.mbVideoRecording = this.f14688l.mo10539ao();
            if (this.f14688l.mo10575i()) {
                zoomAdjustMsgData.mCameraEnterType = String.valueOf(1);
            } else if (this.f14688l.mo10583m()) {
                zoomAdjustMsgData.mCameraEnterType = String.valueOf(3);
            } else {
                zoomAdjustMsgData.mCameraEnterType = String.valueOf(2);
            }
            zoomAdjustMsgData.mCameraId = 1;
            zoomAdjustMsgData.mRearOrFront = DcsMsgData.FRONT;
            if (!TextUtils.isEmpty(zoomAdjustMsgData.mCaptureMode) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_QUICK_VIDEO_SUPPORT) && ApsConstant.CAPTURE_MODE_COMMON.equals(zoomAdjustMsgData.mCaptureMode) && this.f14688l.mo10549ay()) {
                zoomAdjustMsgData.mCaptureMode = ApsConstant.REC_MODE_QUICK_VIDEO;
                zoomAdjustMsgData.mCaptureType = 1;
            }
            zoomAdjustMsgData.report();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m14686b(int OplusGLSurfaceView_13) {
        this.f14677a = OplusGLSurfaceView_13;
    }
}
