package com.oplus.camera.p172ui.control;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.widget.RelativeLayout;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.RotableTextView;
import com.oplus.camera.p172ui.preview.PreviewFrameLayout;
import com.oplus.camera.util.Util;

/* compiled from: RecordingStopCountDownTimer.java */
/* renamed from: com.oplus.camera.ui.control.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class RecordingStopCountDownTimer {

    /* renamed from: PlatformImplementations.kt_3 */
    private static Typeface f18254a;

    /* renamed from: OplusGLSurfaceView_14 */
    private PlatformImplementations.kt_3 f18265l;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private float f18255b = 0.0f;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private float f18256c = 0.0f;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f18257d = 0;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f18258e = 0;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f18259f = 0;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f18260g = 0;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f18261h = false;

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f18262i = false;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f18263j = 0;

    /* renamed from: OplusGLSurfaceView_5 */
    private IntrinsicsJvm.kt_4 f18264k = null;

    /* renamed from: OplusGLSurfaceView_6 */
    private RotableTextView f18266m = null;

    /* renamed from: OplusGLSurfaceView_11 */
    private ValueAnimator f18267n = null;

    /* compiled from: RecordingStopCountDownTimer.java */
    /* renamed from: com.oplus.camera.ui.control.IntrinsicsJvm.kt_5$IntrinsicsJvm.kt_4 */
    public interface IntrinsicsJvm.kt_4 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo11042a();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    static /* synthetic */ int m19248b(RecordingStopCountDownTimer c3202d, int OplusGLSurfaceView_13) {
        int i2 = c3202d.f18263j - OplusGLSurfaceView_13;
        c3202d.f18263j = i2;
        return i2;
    }

    public RecordingStopCountDownTimer() {
        this.f18265l = null;
        this.f18265l = new PlatformImplementations.kt_3();
    }

    /* compiled from: RecordingStopCountDownTimer.java */
    /* renamed from: com.oplus.camera.ui.control.IntrinsicsJvm.kt_5$PlatformImplementations.kt_3 */
    private class PlatformImplementations.kt_3 extends Handler {
        private PlatformImplementations.kt_3() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            CameraLog.m12954a("RecordingStopCountDownTimer", "handleMessage, what: " + message.what);
            int OplusGLSurfaceView_13 = message.what;
            if (OplusGLSurfaceView_13 == 1) {
                m19262c();
                m19259a(1000);
            } else if (OplusGLSurfaceView_13 == 2 && !m19260a()) {
                m19259a(1000);
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private boolean m19260a() {
            if (RecordingStopCountDownTimer.this.f18263j > 0) {
                return false;
            }
            if (RecordingStopCountDownTimer.this.f18264k != null) {
                RecordingStopCountDownTimer.this.f18262i = true;
                RecordingStopCountDownTimer.this.f18264k.mo11042a();
            }
            return true;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m19259a(int OplusGLSurfaceView_13) {
            int iCeil;
            if (RecordingStopCountDownTimer.this.f18266m != null && (iCeil = (int) Math.ceil((RecordingStopCountDownTimer.this.f18263j * 1.0d) / 1000.0d)) != RecordingStopCountDownTimer.this.f18260g) {
                RecordingStopCountDownTimer.this.f18266m.setAlpha(1.0f);
                RecordingStopCountDownTimer.this.f18266m.setText(Util.m24474l(iCeil));
                RecordingStopCountDownTimer.this.f18260g = iCeil;
                m19261b();
            }
            RecordingStopCountDownTimer.m19248b(RecordingStopCountDownTimer.this, OplusGLSurfaceView_13);
            removeMessages(2);
            sendMessageDelayed(obtainMessage(2), OplusGLSurfaceView_13);
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        private void m19261b() {
            if (RecordingStopCountDownTimer.this.f18267n != null) {
                RecordingStopCountDownTimer.this.f18267n.cancel();
                RecordingStopCountDownTimer.this.f18267n.start();
            }
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        private void m19262c() {
            RecordingStopCountDownTimer.this.f18267n = ValueAnimator.ofFloat(1.0f, 0.0f).setDuration(1000L);
            RecordingStopCountDownTimer.this.f18267n.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.IntrinsicsJvm.kt_5.PlatformImplementations.kt_3.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (RecordingStopCountDownTimer.this.f18266m != null) {
                        RecordingStopCountDownTimer.this.f18266m.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        RecordingStopCountDownTimer.this.f18266m.postInvalidate();
                    }
                }
            });
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19256a(IntrinsicsJvm.kt_4 bVar) {
        this.f18264k = bVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m19246a(Activity activity) throws Resources.NotFoundException {
        if (this.f18266m != null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        PreviewFrameLayout previewFrameLayout = (PreviewFrameLayout) activity.findViewById(R.id_renamed.frame_layout);
        float dimension = activity.getResources().getDimension(R.dimen.time_snapshot_indicator_shadow_radius_size);
        float dimension2 = activity.getResources().getDimension(R.dimen.time_snapshot_indicator_shadow_radius_dx);
        float dimension3 = activity.getResources().getDimension(R.dimen.time_snapshot_indicator_shadow_radius_dy);
        this.f18255b = activity.getResources().getDimension(R.dimen.time_snapshot_indicator_text_size);
        this.f18256c = activity.getResources().getDimension(R.dimen.time_snapshot_indicator_text_size_corner);
        this.f18257d = (int) activity.getResources().getDimension(R.dimen.time_snapshot_indicator_text_margin_horizontal);
        this.f18258e = Util.m24186N();
        this.f18266m = new RotableTextView(activity);
        this.f18266m.setShadowLayer(dimension, dimension2, dimension3, 0);
        if (f18254a == null) {
            f18254a = Util.m24473l(activity);
        }
        this.f18266m.setTypeface(f18254a);
        this.f18266m.setTextSize(0, this.f18255b);
        this.f18266m.setTextColor(-1);
        previewFrameLayout.addView(this.f18266m, layoutParams);
        this.f18266m.setVisibility(8);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19253a() {
        this.f18266m = null;
        this.f18265l = null;
        ValueAnimator valueAnimator = this.f18267n;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.f18267n = null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19255a(int OplusGLSurfaceView_13, Activity activity, int i2) {
        CameraLog.m12954a("RecordingStopCountDownTimer", "startTimer, time: " + OplusGLSurfaceView_13 + ", orientation: " + i2);
        this.f18263j = OplusGLSurfaceView_13 * 1000;
        m19246a(activity);
        RotableTextView rotableTextView = this.f18266m;
        if (rotableTextView != null) {
            rotableTextView.setVisibility(0);
            this.f18266m.m18344a(i2, false);
            this.f18259f = i2;
        }
        this.f18261h = true;
        this.f18265l.removeMessages(1);
        PlatformImplementations.kt_3 aVar = this.f18265l;
        aVar.sendMessage(aVar.obtainMessage(1));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19254a(int OplusGLSurfaceView_13) {
        if (this.f18266m == null || this.f18259f == OplusGLSurfaceView_13) {
            return;
        }
        CameraLog.m12954a("RecordingStopCountDownTimer", "updateTextOrientation, mLastOrientation: " + this.f18259f + ", orientation: " + OplusGLSurfaceView_13);
        this.f18266m.m18344a(OplusGLSurfaceView_13, true);
        this.f18259f = OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m19257b() {
        return this.f18261h;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m19258c() {
        this.f18265l.removeMessages(2);
        this.f18261h = false;
        RotableTextView rotableTextView = this.f18266m;
        if (rotableTextView != null) {
            rotableTextView.clearAnimation();
            this.f18266m.setVisibility(8);
        }
        this.f18262i = false;
        this.f18263j = 0;
    }
}
