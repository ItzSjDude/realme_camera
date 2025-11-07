package com.oplus.camera.ui;

/* loaded from: classes2.dex */
public class CameraQrCodeView extends android.view.View {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.lang.String f5754a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.graphics.Rect f5755b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f5756c;
    private int d_renamed;
    private android.view.animation.AlphaAnimation e_renamed;
    private boolean f_renamed;
    private android.graphics.drawable.Drawable g_renamed;
    private android.os.Handler h_renamed;

    public CameraQrCodeView(android.content.Context context) {
        super(context);
        this.f5754a = "CameraQrCodeView";
        this.f5755b = new android.graphics.Rect();
        this.f5756c = false;
        this.d_renamed = 0;
        this.e_renamed = null;
        this.f_renamed = false;
        this.g_renamed = null;
        this.h_renamed = new android.os.Handler(android.os.Looper.getMainLooper()) { // from class: com.oplus.camera.ui.CameraQrCodeView.1
            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                if (message.what == 300 && com.oplus.camera.ui.CameraQrCodeView.this.e_renamed != null && !com.oplus.camera.ui.CameraQrCodeView.this.f5756c && com.oplus.camera.ui.CameraQrCodeView.this.a_renamed()) {
                    com.oplus.camera.ui.CameraQrCodeView cameraQrCodeView = com.oplus.camera.ui.CameraQrCodeView.this;
                    cameraQrCodeView.startAnimation(cameraQrCodeView.e_renamed);
                }
            }
        };
        d_renamed();
    }

    public CameraQrCodeView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5754a = "CameraQrCodeView";
        this.f5755b = new android.graphics.Rect();
        this.f5756c = false;
        this.d_renamed = 0;
        this.e_renamed = null;
        this.f_renamed = false;
        this.g_renamed = null;
        this.h_renamed = new android.os.Handler(android.os.Looper.getMainLooper()) { // from class: com.oplus.camera.ui.CameraQrCodeView.1
            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                if (message.what == 300 && com.oplus.camera.ui.CameraQrCodeView.this.e_renamed != null && !com.oplus.camera.ui.CameraQrCodeView.this.f5756c && com.oplus.camera.ui.CameraQrCodeView.this.a_renamed()) {
                    com.oplus.camera.ui.CameraQrCodeView cameraQrCodeView = com.oplus.camera.ui.CameraQrCodeView.this;
                    cameraQrCodeView.startAnimation(cameraQrCodeView.e_renamed);
                }
            }
        };
        d_renamed();
    }

    public CameraQrCodeView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f5754a = "CameraQrCodeView";
        this.f5755b = new android.graphics.Rect();
        this.f5756c = false;
        this.d_renamed = 0;
        this.e_renamed = null;
        this.f_renamed = false;
        this.g_renamed = null;
        this.h_renamed = new android.os.Handler(android.os.Looper.getMainLooper()) { // from class: com.oplus.camera.ui.CameraQrCodeView.1
            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                if (message.what == 300 && com.oplus.camera.ui.CameraQrCodeView.this.e_renamed != null && !com.oplus.camera.ui.CameraQrCodeView.this.f5756c && com.oplus.camera.ui.CameraQrCodeView.this.a_renamed()) {
                    com.oplus.camera.ui.CameraQrCodeView cameraQrCodeView = com.oplus.camera.ui.CameraQrCodeView.this;
                    cameraQrCodeView.startAnimation(cameraQrCodeView.e_renamed);
                }
            }
        };
        d_renamed();
    }

    private void d_renamed() {
        this.g_renamed = getResources().getDrawable(com.oplus.camera.R_renamed.drawable.icon_face_detecte);
        this.d_renamed = com.oplus.camera.util.Util.getScreenWidth();
        e_renamed();
    }

    private void e_renamed() {
        this.e_renamed = new android.view.animation.AlphaAnimation(1.0f, 0.0f);
        this.e_renamed.setDuration(300L);
        this.e_renamed.setInterpolator(new android.view.animation.LinearInterpolator());
        this.e_renamed.setAnimationListener(new android.view.animation.Animation.AnimationListener() { // from class: com.oplus.camera.ui.CameraQrCodeView.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(android.view.animation.Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(android.view.animation.Animation animation) {
                com.oplus.camera.ui.CameraQrCodeView.this.f_renamed = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(android.view.animation.Animation animation) {
                com.oplus.camera.ui.CameraQrCodeView.this.setVisibility(4);
                com.oplus.camera.ui.CameraQrCodeView.this.f_renamed = false;
            }
        });
    }

    public void a_renamed(android.graphics.RectF rectF, int i_renamed, int i2) {
        com.oplus.camera.e_renamed.a_renamed(this.f5754a, "updateQrCodeSize  mbHideAnimationRunning: " + this.f_renamed + ", mPause: " + this.f5756c + ", qrCodeSize: " + rectF);
        if (rectF == null || this.f5756c) {
            return;
        }
        if (!b_renamed(rectF, i_renamed, i2)) {
            setVisibility(4);
            return;
        }
        this.h_renamed.removeMessages(300);
        setVisibility(0);
        float f_renamed = rectF.right - rectF.left;
        float f2 = rectF.bottom - rectF.top;
        this.f5755b.top = (int) rectF.left;
        this.f5755b.left = (int) ((this.d_renamed - rectF.top) - f2);
        this.f5755b.right = (int) (r4.left + f2);
        this.f5755b.bottom = (int) (r4.top + f_renamed);
        invalidate();
    }

    private boolean b_renamed(android.graphics.RectF rectF, int i_renamed, int i2) {
        int width = getWidth();
        int height = getHeight();
        if (height == 0 || width == 0) {
            return false;
        }
        float f_renamed = height * 1.0f;
        float f2 = width;
        float f3 = i_renamed;
        float f4 = i2;
        if (0.01d < java.lang.Math.abs((f_renamed / f2) - ((f3 * 1.0f) / f4))) {
            return false;
        }
        if (height == i_renamed && width == i2) {
            return true;
        }
        float f5 = f_renamed / f3;
        float f6 = (f2 * 1.0f) / f4;
        rectF.left *= f5;
        rectF.top *= f6;
        rectF.right *= f5;
        rectF.bottom *= f6;
        return true;
    }

    @Override // android.view.View
    public void setVisibility(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed(this.f5754a, "setVisibility, visibility: " + i_renamed);
        if (i_renamed != 0) {
            this.h_renamed.removeMessages(300);
        }
        super.setVisibility(i_renamed);
    }

    public void a_renamed(boolean z_renamed) {
        if (this.f_renamed || !a_renamed()) {
            return;
        }
        if (z_renamed) {
            this.h_renamed.removeMessages(300);
            this.h_renamed.sendEmptyMessageDelayed(300, 100L);
        } else {
            setVisibility(4);
        }
    }

    public boolean a_renamed() {
        return getVisibility() == 0;
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        android.graphics.Rect rect = this.f5755b;
        if (rect == null || this.f5756c) {
            return;
        }
        this.g_renamed.setBounds(rect);
        this.g_renamed.draw(canvas);
        super.onDraw(canvas);
    }

    public void b_renamed() {
        this.f5756c = true;
        setVisibility(4);
        this.h_renamed.removeCallbacksAndMessages(null);
        this.f_renamed = false;
        clearAnimation();
    }

    public void c_renamed() {
        this.f5756c = false;
        this.f_renamed = false;
    }
}
