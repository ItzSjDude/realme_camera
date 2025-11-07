package com.oplus.camera.p172ui.p174b;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.Size;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.oplus.camera.CameraLog;
import com.oplus.camera.CameraConstant;
import com.oplus.camera.p172ui.CameraUIListener;
import com.oplus.camera.p172ui.control.Thumbnail;
import com.oplus.camera.p172ui.control.ThumbImageView;
import com.oplus.camera.p172ui.control.CameraControlUI;
import com.oplus.camera.p172ui.widget.RoundImageView;
import com.oplus.camera.util.Util;
import com.p078a.p079a.SimpleSpringListener;
import com.p078a.p079a.Spring;
import com.p078a.p079a.SpringConfig;
import com.p078a.p079a.SpringSystem;

/* compiled from: CameraSuperTextUI.java */
/* renamed from: com.oplus.camera.ui.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class CameraSuperTextUI implements CameraConstant {

    /* renamed from: COUIBaseListPopupWindow_11 */
    private Activity f17584g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private CameraUIListener f17585h;

    /* renamed from: OplusGLSurfaceView_13 */
    private CameraControlUI f17586i;

    /* renamed from: OplusGLSurfaceView_15 */
    private ViewGroup f17587j = null;

    /* renamed from: OplusGLSurfaceView_5 */
    private Bitmap f17588k = null;

    /* renamed from: OplusGLSurfaceView_14 */
    private Bitmap f17589l = null;

    /* renamed from: OplusGLSurfaceView_6 */
    private Thumbnail f17590m = null;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f17591n = false;

    /* renamed from: o */
    private RoundImageView f17592o = null;

    /* renamed from: p */
    private SpringSystem f17593p = SpringSystem.m5492c();

    /* renamed from: q */
    private ObjectAnimator f17594q = null;

    /* renamed from: r */
    private ObjectAnimator f17595r = null;

    /* renamed from: s */
    private boolean f17596s = false;

    /* renamed from: t */
    private boolean f17597t = false;

    /* renamed from: u */
    private int f17598u = 0;

    /* renamed from: v */
    private int f17599v = 0;

    /* renamed from: w */
    @SuppressLint({"HandlerLeak"})
    private Handler f17600w = new Handler() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.1
        @Override // android.os.Handler
        public void handleMessage(Message message) throws Resources.NotFoundException {
            CameraLog.m12954a("CameraSuperTextUI", "handleMessage, msg: " + message.what);
            if (message.what != 101) {
                return;
            }
            CameraSuperTextUI.this.m18556d();
        }
    };

    public CameraSuperTextUI(Activity activity, CameraUIListener cameraUIListener, CameraControlUI viewOnClickListenerC3199a) {
        this.f17584g = null;
        this.f17585h = null;
        this.f17586i = null;
        this.f17584g = activity;
        this.f17585h = cameraUIListener;
        this.f17586i = viewOnClickListenerC3199a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18565a(ViewGroup viewGroup) {
        this.f17587j = viewGroup;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18562a() {
        this.f17591n = false;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m18566b() {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        this.f17591n = true;
        if (this.f17596s && (objectAnimator2 = this.f17594q) != null) {
            objectAnimator2.end();
            this.f17594q = null;
        }
        if (this.f17597t && (objectAnimator = this.f17595r) != null) {
            objectAnimator.end();
            this.f17595r = null;
        }
        this.f17587j.removeView(this.f17592o);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m18567c() {
        Handler handler = this.f17600w;
        if (handler != null) {
            handler.removeMessages(101);
            this.f17600w = null;
        }
        this.f17584g = null;
        this.f17587j = null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18564a(Bitmap bitmap, Thumbnail c3203e, int OplusGLSurfaceView_13, boolean z) {
        CameraLog.m12967f("CameraSuperTextUI", "showSuperTextResultView start");
        this.f17588k = bitmap;
        this.f17590m = c3203e;
        this.f17599v = OplusGLSurfaceView_13;
        ThumbImageView thumbImageViewM19208s = this.f17586i.m19208s();
        if (this.f17591n || !z) {
            CameraLog.m12962c("CameraSuperTextUI", "showSuperTextResultView, mbPaused: " + this.f17591n + ", needShowResult: " + z);
            m18550a(thumbImageViewM19208s, c3203e, bitmap);
            return;
        }
        Size sizeMo10674a = this.f17585h.mo10674a(1.3333333333333333d);
        if (sizeMo10674a == null) {
            return;
        }
        int iM24186N = Util.m24186N() + (sizeMo10674a.getWidth() / 2);
        CameraLog.m12954a("CameraSuperTextUI", "showSuperTextResultView, size.width: " + sizeMo10674a.getWidth() + ", size.height: " + sizeMo10674a.getHeight() + ", topBarHeight: " + Util.m24186N() + ", bitmap.width: " + bitmap.getWidth() + ", bitmap.height: " + bitmap.getHeight());
        m18547a(bitmap, iM24186N);
        StringBuilder sb = new StringBuilder();
        sb.append("showSuperTextResultView, bitmapWidth: ");
        sb.append(bitmap.getWidth());
        sb.append(", bitmapHeight: ");
        sb.append(bitmap.getHeight());
        CameraLog.m12967f("CameraSuperTextUI", sb.toString());
        final Spring c1032fB = this.f17593p.m5449b();
        c1032fB.m5472a(SpringConfig.m5490b(5.0d, 8.0d));
        c1032fB.m5474a(false);
        c1032fB.m5473a(new SimpleSpringListener() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.2
            @Override // com.p078a.p079a.SimpleSpringListener, com.p078a.p079a.SpringListener
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo5464a(Spring c1032f) {
                super.mo5464a(c1032f);
                float fM5478c = (float) c1032f.m5478c();
                CameraLog.m12954a("CameraSuperTextUI", "onSpringUpdate, currentScaleValue: " + fM5478c);
                CameraSuperTextUI.this.f17592o.setAlpha(fM5478c);
                float COUIBaseListPopupWindow_12 = (fM5478c * 0.38f) + 0.72f;
                CameraSuperTextUI.this.f17592o.setScaleX(COUIBaseListPopupWindow_12);
                CameraSuperTextUI.this.f17592o.setScaleY(COUIBaseListPopupWindow_12);
            }

            @Override // com.p078a.p079a.SimpleSpringListener, com.p078a.p079a.SpringListener
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo5465b(Spring c1032f) {
                super.mo5465b(c1032f);
                c1032fB.m5475a();
                if (CameraSuperTextUI.this.f17600w != null) {
                    CameraSuperTextUI.this.f17600w.sendEmptyMessageDelayed(101, 500L);
                }
            }
        });
        c1032fB.m5476b(1.0d);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m18547a(Bitmap bitmap, int OplusGLSurfaceView_13) {
        this.f17589l = m18546a(bitmap);
        this.f17592o = new RoundImageView(this.f17584g);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f17589l.getWidth(), this.f17589l.getHeight());
        if (Util.m24498u()) {
            layoutParams.addRule(13);
        } else {
            layoutParams.addRule(9);
            layoutParams.addRule(10);
            layoutParams.topMargin = OplusGLSurfaceView_13 - (this.f17589l.getHeight() / 2);
            layoutParams.leftMargin = 0;
        }
        this.f17592o.setLayoutParams(layoutParams);
        this.f17592o.setBitmap(this.f17589l);
        this.f17587j.addView(this.f17592o);
        this.f17592o.setVisibility(0);
        this.f17592o.setAlpha(0.0f);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Bitmap m18546a(Bitmap bitmap) {
        int screenWidth;
        int width;
        Size sizeMo10745ax = this.f17585h.mo10745ax();
        if (sizeMo10745ax == null) {
            CameraLog.m12967f("CameraSuperTextUI", "createAnimBitmap, preview size is null");
            return bitmap;
        }
        if (Util.m24498u()) {
            float width2 = sizeMo10745ax.getWidth() / sizeMo10745ax.getHeight();
            width = Util.getScreenHeight();
            screenWidth = (int) (width / width2);
        } else {
            screenWidth = Util.getScreenWidth();
            width = (sizeMo10745ax.getWidth() * screenWidth) / sizeMo10745ax.getHeight();
        }
        CameraLog.m12959b("CameraSuperTextUI", "createAnimBitmap, previewFrameWidth: " + screenWidth + ", previewFrameHeight: " + width);
        Bitmap bitmapM24215a = Util.m24215a(screenWidth, width, Bitmap.Config.ARGB_8888);
        bitmapM24215a.eraseColor(0);
        Canvas canvas = new Canvas(bitmapM24215a);
        canvas.drawBitmap(bitmap, ((float) (bitmapM24215a.getWidth() - bitmap.getWidth())) / 2.0f, ((float) (bitmapM24215a.getHeight() - bitmap.getHeight())) / 2.0f, (Paint) null);
        canvas.save();
        canvas.restore();
        CameraLog.m12959b("CameraSuperTextUI", "createAnimBitmap, result width: " + bitmapM24215a.getWidth() + ", height: " + bitmapM24215a.getHeight());
        return bitmapM24215a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m18550a(ThumbImageView thumbImageView, Thumbnail c3203e, Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled() || thumbImageView == null) {
            return;
        }
        CameraLog.m12954a("CameraSuperTextUI", "updateThumbnailWithoutAnimation");
        if (!Util.m24498u()) {
            bitmap = Util.m24373b(thumbImageView.m18982a(bitmap, false, false), this.f17599v);
        }
        CameraControlUI viewOnClickListenerC3199a = this.f17586i;
        if (viewOnClickListenerC3199a != null) {
            viewOnClickListenerC3199a.m19144b(c3203e);
            this.f17586i.m19098a(c3203e);
            this.f17586i.m19088a(bitmap, 0, false);
        }
        thumbImageView.m18986a(bitmap, 0, false, true);
        this.f17585h.mo10813c(false);
        this.f17585h.mo10742au();
        m18558e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01a8  */
    /* renamed from: IntrinsicsJvm.kt_5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m18556d() throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 552
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.p174b.CameraSuperTextUI.m18556d():void");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18563a(int OplusGLSurfaceView_13) {
        this.f17598u = OplusGLSurfaceView_13;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m18558e() {
        Bitmap bitmap = this.f17588k;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f17588k.recycle();
        }
        Bitmap bitmap2 = this.f17589l;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.f17589l.recycle();
        }
        this.f17588k = null;
        this.f17589l = null;
    }
}
