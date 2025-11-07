package com.oplus.camera.p172ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.util.Util;

/* loaded from: classes2.dex */
public class CameraQrCodeView extends View {

    /* renamed from: PlatformImplementations.kt_3 */
    private String f17110a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Rect f17111b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f17112c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f17113d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private AlphaAnimation f17114e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f17115f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private Drawable f17116g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private Handler f17117h;

    public CameraQrCodeView(Context context) {
        super(context);
        this.f17110a = "CameraQrCodeView";
        this.f17111b = new Rect();
        this.f17112c = false;
        this.f17113d = 0;
        this.f17114e = null;
        this.f17115f = false;
        this.f17116g = null;
        this.f17117h = new Handler(Looper.getMainLooper()) { // from class: com.oplus.camera.ui.CameraQrCodeView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 300 && CameraQrCodeView.this.f17114e != null && !CameraQrCodeView.this.f17112c && CameraQrCodeView.this.m18019a()) {
                    CameraQrCodeView cameraQrCodeView = CameraQrCodeView.this;
                    cameraQrCodeView.startAnimation(cameraQrCodeView.f17114e);
                }
            }
        };
        m18015d();
    }

    public CameraQrCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17110a = "CameraQrCodeView";
        this.f17111b = new Rect();
        this.f17112c = false;
        this.f17113d = 0;
        this.f17114e = null;
        this.f17115f = false;
        this.f17116g = null;
        this.f17117h = new Handler(Looper.getMainLooper()) { // from class: com.oplus.camera.ui.CameraQrCodeView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 300 && CameraQrCodeView.this.f17114e != null && !CameraQrCodeView.this.f17112c && CameraQrCodeView.this.m18019a()) {
                    CameraQrCodeView cameraQrCodeView = CameraQrCodeView.this;
                    cameraQrCodeView.startAnimation(cameraQrCodeView.f17114e);
                }
            }
        };
        m18015d();
    }

    public CameraQrCodeView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f17110a = "CameraQrCodeView";
        this.f17111b = new Rect();
        this.f17112c = false;
        this.f17113d = 0;
        this.f17114e = null;
        this.f17115f = false;
        this.f17116g = null;
        this.f17117h = new Handler(Looper.getMainLooper()) { // from class: com.oplus.camera.ui.CameraQrCodeView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 300 && CameraQrCodeView.this.f17114e != null && !CameraQrCodeView.this.f17112c && CameraQrCodeView.this.m18019a()) {
                    CameraQrCodeView cameraQrCodeView = CameraQrCodeView.this;
                    cameraQrCodeView.startAnimation(cameraQrCodeView.f17114e);
                }
            }
        };
        m18015d();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m18015d() {
        this.f17116g = getResources().getDrawable(R.drawable.icon_face_detecte);
        this.f17113d = Util.getScreenWidth();
        m18016e();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m18016e() {
        this.f17114e = new AlphaAnimation(1.0f, 0.0f);
        this.f17114e.setDuration(300L);
        this.f17114e.setInterpolator(new LinearInterpolator());
        this.f17114e.setAnimationListener(new Animation.AnimationListener() { // from class: com.oplus.camera.ui.CameraQrCodeView.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                CameraQrCodeView.this.f17115f = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                CameraQrCodeView.this.setVisibility(4);
                CameraQrCodeView.this.f17115f = false;
            }
        });
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18017a(RectF rectF, int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12954a(this.f17110a, "updateQrCodeSize  mbHideAnimationRunning: " + this.f17115f + ", mPause: " + this.f17112c + ", qrCodeSize: " + rectF);
        if (rectF == null || this.f17112c) {
            return;
        }
        if (!m18013b(rectF, OplusGLSurfaceView_13, i2)) {
            setVisibility(4);
            return;
        }
        this.f17117h.removeMessages(300);
        setVisibility(0);
        float COUIBaseListPopupWindow_12 = rectF.right - rectF.left;
        float f2 = rectF.bottom - rectF.top;
        this.f17111b.top = (int) rectF.left;
        this.f17111b.left = (int) ((this.f17113d - rectF.top) - f2);
        this.f17111b.right = (int) (r4.left + f2);
        this.f17111b.bottom = (int) (r4.top + COUIBaseListPopupWindow_12);
        invalidate();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m18013b(RectF rectF, int OplusGLSurfaceView_13, int i2) {
        int width = getWidth();
        int height = getHeight();
        if (height == 0 || width == 0) {
            return false;
        }
        float COUIBaseListPopupWindow_12 = height * 1.0f;
        float f2 = width;
        float f3 = OplusGLSurfaceView_13;
        float f4 = i2;
        if (0.01d < Math.abs((COUIBaseListPopupWindow_12 / f2) - ((f3 * 1.0f) / f4))) {
            return false;
        }
        if (height == OplusGLSurfaceView_13 && width == i2) {
            return true;
        }
        float f5 = COUIBaseListPopupWindow_12 / f3;
        float f6 = (f2 * 1.0f) / f4;
        rectF.left *= f5;
        rectF.top *= f6;
        rectF.right *= f5;
        rectF.bottom *= f6;
        return true;
    }

    @Override // android.view.View
    public void setVisibility(int OplusGLSurfaceView_13) {
        CameraLog.m12954a(this.f17110a, "setVisibility, visibility: " + OplusGLSurfaceView_13);
        if (OplusGLSurfaceView_13 != 0) {
            this.f17117h.removeMessages(300);
        }
        super.setVisibility(OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18018a(boolean z) {
        if (this.f17115f || !m18019a()) {
            return;
        }
        if (z) {
            this.f17117h.removeMessages(300);
            this.f17117h.sendEmptyMessageDelayed(300, 100L);
        } else {
            setVisibility(4);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m18019a() {
        return getVisibility() == 0;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Rect rect = this.f17111b;
        if (rect == null || this.f17112c) {
            return;
        }
        this.f17116g.setBounds(rect);
        this.f17116g.draw(canvas);
        super.onDraw(canvas);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m18020b() {
        this.f17112c = true;
        setVisibility(4);
        this.f17117h.removeCallbacksAndMessages(null);
        this.f17115f = false;
        clearAnimation();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m18021c() {
        this.f17112c = false;
        this.f17115f = false;
    }
}
