package com.oplus.camera.p172ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.OrientationAnimation;
import com.oplus.camera.util.Util;

/* loaded from: classes2.dex */
public class CameraQrCodeJumpView extends LinearLayout {

    /* renamed from: PlatformImplementations.kt_3 */
    private String f17090a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean f17091b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f17092c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f17093d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f17094e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f17095f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f17096g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f17097h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f17098i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f17099j;

    /* renamed from: OplusGLSurfaceView_5 */
    private AnimationAnimationListenerC3087a f17100k;

    /* renamed from: OplusGLSurfaceView_14 */
    private OrientationAnimation f17101l;

    /* renamed from: OplusGLSurfaceView_6 */
    private Handler f17102m;

    /* renamed from: OplusGLSurfaceView_11 */
    private OrientationAnimation.PlatformImplementations.kt_3 f17103n;

    public CameraQrCodeJumpView(Context context) {
        super(context);
        this.f17090a = "CameraQrCodeJumpView";
        this.f17091b = false;
        this.f17092c = false;
        this.f17093d = 0;
        this.f17094e = 0;
        this.f17095f = 0;
        this.f17096g = 0;
        this.f17097h = 0;
        this.f17098i = 0;
        this.f17099j = 0;
        this.f17100k = new AnimationAnimationListenerC3087a();
        this.f17101l = null;
        this.f17102m = new Handler(Looper.getMainLooper()) { // from class: com.oplus.camera.ui.CameraQrCodeJumpView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                CameraLog.m12954a(CameraQrCodeJumpView.this.f17090a, "handleMessage, what: " + message.what);
                if (message.what != 1) {
                    return;
                }
                CameraQrCodeJumpView.this.m18000a(true);
            }
        };
        this.f17103n = new OrientationAnimation.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.CameraQrCodeJumpView.2
            @Override // com.oplus.camera.p172ui.OrientationAnimation.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo18007a(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
                CameraQrCodeJumpView.this.m17996f();
            }

            @Override // com.oplus.camera.p172ui.OrientationAnimation.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public boolean mo18008a() {
                return CameraQrCodeJumpView.this.getVisibility() == 0;
            }

            @Override // com.oplus.camera.p172ui.OrientationAnimation.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo18006a(float COUIBaseListPopupWindow_12) {
                CameraQrCodeJumpView.this.setAlpha(COUIBaseListPopupWindow_12);
            }
        };
    }

    public CameraQrCodeJumpView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17090a = "CameraQrCodeJumpView";
        this.f17091b = false;
        this.f17092c = false;
        this.f17093d = 0;
        this.f17094e = 0;
        this.f17095f = 0;
        this.f17096g = 0;
        this.f17097h = 0;
        this.f17098i = 0;
        this.f17099j = 0;
        this.f17100k = new AnimationAnimationListenerC3087a();
        this.f17101l = null;
        this.f17102m = new Handler(Looper.getMainLooper()) { // from class: com.oplus.camera.ui.CameraQrCodeJumpView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                CameraLog.m12954a(CameraQrCodeJumpView.this.f17090a, "handleMessage, what: " + message.what);
                if (message.what != 1) {
                    return;
                }
                CameraQrCodeJumpView.this.m18000a(true);
            }
        };
        this.f17103n = new OrientationAnimation.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.CameraQrCodeJumpView.2
            @Override // com.oplus.camera.p172ui.OrientationAnimation.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo18007a(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
                CameraQrCodeJumpView.this.m17996f();
            }

            @Override // com.oplus.camera.p172ui.OrientationAnimation.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public boolean mo18008a() {
                return CameraQrCodeJumpView.this.getVisibility() == 0;
            }

            @Override // com.oplus.camera.p172ui.OrientationAnimation.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo18006a(float COUIBaseListPopupWindow_12) {
                CameraQrCodeJumpView.this.setAlpha(COUIBaseListPopupWindow_12);
            }
        };
    }

    public CameraQrCodeJumpView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f17090a = "CameraQrCodeJumpView";
        this.f17091b = false;
        this.f17092c = false;
        this.f17093d = 0;
        this.f17094e = 0;
        this.f17095f = 0;
        this.f17096g = 0;
        this.f17097h = 0;
        this.f17098i = 0;
        this.f17099j = 0;
        this.f17100k = new AnimationAnimationListenerC3087a();
        this.f17101l = null;
        this.f17102m = new Handler(Looper.getMainLooper()) { // from class: com.oplus.camera.ui.CameraQrCodeJumpView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                CameraLog.m12954a(CameraQrCodeJumpView.this.f17090a, "handleMessage, what: " + message.what);
                if (message.what != 1) {
                    return;
                }
                CameraQrCodeJumpView.this.m18000a(true);
            }
        };
        this.f17103n = new OrientationAnimation.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.CameraQrCodeJumpView.2
            @Override // com.oplus.camera.p172ui.OrientationAnimation.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo18007a(int i2) throws Resources.NotFoundException {
                CameraQrCodeJumpView.this.m17996f();
            }

            @Override // com.oplus.camera.p172ui.OrientationAnimation.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public boolean mo18008a() {
                return CameraQrCodeJumpView.this.getVisibility() == 0;
            }

            @Override // com.oplus.camera.p172ui.OrientationAnimation.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo18006a(float COUIBaseListPopupWindow_12) {
                CameraQrCodeJumpView.this.setAlpha(COUIBaseListPopupWindow_12);
            }
        };
    }

    public CameraQrCodeJumpView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet, OplusGLSurfaceView_13, i2);
        this.f17090a = "CameraQrCodeJumpView";
        this.f17091b = false;
        this.f17092c = false;
        this.f17093d = 0;
        this.f17094e = 0;
        this.f17095f = 0;
        this.f17096g = 0;
        this.f17097h = 0;
        this.f17098i = 0;
        this.f17099j = 0;
        this.f17100k = new AnimationAnimationListenerC3087a();
        this.f17101l = null;
        this.f17102m = new Handler(Looper.getMainLooper()) { // from class: com.oplus.camera.ui.CameraQrCodeJumpView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                CameraLog.m12954a(CameraQrCodeJumpView.this.f17090a, "handleMessage, what: " + message.what);
                if (message.what != 1) {
                    return;
                }
                CameraQrCodeJumpView.this.m18000a(true);
            }
        };
        this.f17103n = new OrientationAnimation.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.CameraQrCodeJumpView.2
            @Override // com.oplus.camera.p172ui.OrientationAnimation.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo18007a(int i22) throws Resources.NotFoundException {
                CameraQrCodeJumpView.this.m17996f();
            }

            @Override // com.oplus.camera.p172ui.OrientationAnimation.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public boolean mo18008a() {
                return CameraQrCodeJumpView.this.getVisibility() == 0;
            }

            @Override // com.oplus.camera.p172ui.OrientationAnimation.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo18006a(float COUIBaseListPopupWindow_12) {
                CameraQrCodeJumpView.this.setAlpha(COUIBaseListPopupWindow_12);
            }
        };
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17999a(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        this.f17095f = OplusGLSurfaceView_13;
        this.f17096g = i2;
        this.f17097h = i3;
        this.f17098i = i4;
        this.f17099j = getResources().getDimensionPixelSize(R.dimen.pi_ultra_wide_hint_horizontal_margin);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18001a(boolean z, boolean z2) {
        CameraLog.m12954a(this.f17090a, "showQrCodeJumpView");
        if (this.f17092c) {
            return;
        }
        setVisibility(0);
        if (z2) {
            setAlpha(0.0f);
            this.f17100k.m18010a(0);
        }
        setOrientation(this.f17093d);
        if (z) {
            m17998a();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17998a() {
        CameraLog.m12954a(this.f17090a, "startHideDelay");
        this.f17102m.removeMessages(1);
        this.f17102m.sendEmptyMessageDelayed(1, 2500L);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18000a(boolean z) {
        CameraLog.m12954a(this.f17090a, "hideQrCodeJumpView");
        if (this.f17092c || !m18002b()) {
            return;
        }
        setAlpha(0.0f);
        setOrientation(this.f17093d);
        if (z) {
            this.f17100k.m18010a(1);
        } else {
            setVisibility(8);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m18002b() {
        return getVisibility() == 0;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m18003c() {
        this.f17092c = true;
        this.f17093d = -1;
        clearAnimation();
    }

    @Override // android.view.View
    public void clearAnimation() {
        this.f17091b = false;
        super.clearAnimation();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m18004d() {
        this.f17092c = false;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int OplusGLSurfaceView_13) {
        int i2 = this.f17093d;
        this.f17093d = OplusGLSurfaceView_13;
        if (this.f17101l == null) {
            m17997g();
        }
        if (-1 == OplusGLSurfaceView_13) {
            OplusGLSurfaceView_13 = 0;
        }
        if (OplusGLSurfaceView_13 % 180 == 0) {
            OplusGLSurfaceView_13 = 0;
        }
        if (i2 != OplusGLSurfaceView_13) {
            OrientationAnimation.PlatformImplementations.kt_3 aVar = this.f17103n;
            if (aVar != null && aVar.mo18008a() && !this.f17101l.m23904b() && this.f17101l.m23901a() != OplusGLSurfaceView_13) {
                startAnimation(this.f17101l);
            }
            this.f17101l.m23902a(OplusGLSurfaceView_13, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m17996f() throws Resources.NotFoundException {
        int OplusGLSurfaceView_13 = this.f17093d;
        if (-1 == OplusGLSurfaceView_13) {
            OplusGLSurfaceView_13 = 0;
        }
        this.f17093d = OplusGLSurfaceView_13;
        int i2 = this.f17093d;
        if (i2 % 180 == 0) {
            i2 = 0;
        }
        this.f17093d = i2;
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth <= 0 || measuredHeight <= 0) {
            measuredWidth = getContext().getResources().getDimensionPixelSize(R.dimen.qrcode_default_width);
            measuredHeight = getContext().getResources().getDimensionPixelSize(R.dimen.qrcode_default_height);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, getContext().getResources().getDimensionPixelSize(R.dimen.ai_notice_view_height));
        int i3 = this.f17093d;
        if (i3 == 90) {
            layoutParams.addRule(10);
            layoutParams.addRule(11);
            int i4 = measuredHeight / 2;
            layoutParams.topMargin = ((this.f17096g + (this.f17097h / 2)) - i4) + this.f17098i;
            layoutParams.rightMargin = ((this.f17099j + i4) + (measuredWidth / 2)) - measuredWidth;
            this.f17093d = 90;
        } else if (i3 == 180) {
            layoutParams.addRule(9);
            layoutParams.addRule(10);
            layoutParams.leftMargin = ((Util.getScreenWidth() / 2) - (measuredWidth / 2)) + this.f17098i;
            layoutParams.topMargin = this.f17095f;
            this.f17093d = 180;
        } else if (i3 == 270) {
            layoutParams.addRule(9);
            layoutParams.addRule(10);
            int i5 = measuredHeight / 2;
            layoutParams.topMargin = ((this.f17096g + (this.f17097h / 2)) - i5) + this.f17098i;
            layoutParams.leftMargin = ((this.f17099j + i5) + (measuredWidth / 2)) - measuredWidth;
            this.f17093d = 270;
        } else {
            layoutParams.addRule(9);
            layoutParams.addRule(10);
            layoutParams.leftMargin = ((Util.getScreenWidth() / 2) - (measuredWidth / 2)) + this.f17098i;
            layoutParams.topMargin = this.f17095f;
            this.f17093d = 0;
        }
        CameraLog.m12967f(this.f17090a, "mOrientation: " + this.f17093d + ", default: " + this.f17094e + ", width: " + measuredWidth + ", height: " + measuredHeight);
        setLayoutParams(layoutParams);
        setRotation((float) (-this.f17093d));
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m17997g() {
        this.f17101l = new OrientationAnimation(1.0f, 0.0f);
        this.f17101l.setDuration(300L);
        this.f17101l.m23903a(this.f17103n);
    }

    public void setDefaultPreviewHeight(int OplusGLSurfaceView_13) {
        this.f17094e = OplusGLSurfaceView_13;
    }

    @Override // android.widget.LinearLayout
    public int getOrientation() {
        return this.f17093d;
    }

    /* renamed from: com.oplus.camera.ui.CameraQrCodeJumpView$PlatformImplementations.kt_3 */
    private class AnimationAnimationListenerC3087a extends Animation implements Animation.AnimationListener {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private float f17107b = 1.0f;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private float f17108c = 0.0f;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private int f17109d = 0;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        public AnimationAnimationListenerC3087a() {
            setAnimationListener(this);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m18010a(int OplusGLSurfaceView_13) {
            CameraLog.m12954a(CameraQrCodeJumpView.this.f17090a, "startScreenAnimation, animationType: " + OplusGLSurfaceView_13);
            if (OplusGLSurfaceView_13 == 0) {
                CameraQrCodeJumpView.this.f17091b = false;
                m18009a(80, 330);
                setInterpolator(CameraQrCodeJumpView.this.getContext(), R.anim.hint_view_show_alpha_path_interpolator);
                this.f17108c = 0.0f;
                this.f17107b = 1.0f;
            } else if (OplusGLSurfaceView_13 == 1) {
                CameraQrCodeJumpView.this.f17091b = false;
                m18009a(0, 160);
                setInterpolator(CameraQrCodeJumpView.this.getContext(), R.anim.alpha_path_interpolator);
                this.f17108c = 1.0f;
                this.f17107b = 0.0f;
            } else {
                m18009a(0, 300);
            }
            this.f17109d = OplusGLSurfaceView_13;
            if (!CameraQrCodeJumpView.this.f17091b || CameraQrCodeJumpView.this.f17092c) {
                CameraQrCodeJumpView.this.f17091b = !r6.f17092c;
                if (CameraQrCodeJumpView.this.f17092c) {
                    CameraQrCodeJumpView.this.setAlpha(this.f17107b);
                    return;
                }
                CameraQrCodeJumpView.this.clearAnimation();
                CameraQrCodeJumpView cameraQrCodeJumpView = CameraQrCodeJumpView.this;
                cameraQrCodeJumpView.startAnimation(cameraQrCodeJumpView.f17100k);
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m18009a(int OplusGLSurfaceView_13, int i2) {
            setStartOffset(OplusGLSurfaceView_13);
            setDuration(i2);
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float COUIBaseListPopupWindow_12, Transformation transformation) {
            if (CameraQrCodeJumpView.this.f17092c) {
                return;
            }
            float f2 = this.f17108c;
            CameraQrCodeJumpView.this.setAlpha(f2 + ((this.f17107b - f2) * COUIBaseListPopupWindow_12));
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            CameraLog.m12954a(CameraQrCodeJumpView.this.f17090a, "onAnimationEnd(), mAnimationType: " + this.f17109d);
            int OplusGLSurfaceView_13 = this.f17109d;
            if (OplusGLSurfaceView_13 == 0) {
                CameraQrCodeJumpView.this.setAlpha(this.f17107b);
            } else {
                if (OplusGLSurfaceView_13 != 1) {
                    return;
                }
                CameraQrCodeJumpView.this.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            CameraLog.m12954a(CameraQrCodeJumpView.this.f17090a, "onAnimationStart(), mbActivityPause: " + CameraQrCodeJumpView.this.f17092c);
            if (CameraQrCodeJumpView.this.f17092c) {
                return;
            }
            CameraQrCodeJumpView.this.f17091b = true;
            CameraQrCodeJumpView.this.setAlpha(this.f17108c);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public int getLayoutDirection() {
        return getContext().getResources().getConfiguration().getLayoutDirection();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m18005e() {
        this.f17093d = -1;
    }
}
