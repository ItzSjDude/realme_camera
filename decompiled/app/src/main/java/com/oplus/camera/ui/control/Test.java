package com.oplus.camera.ui.control;

/* compiled from: RecordingStopCountDownTimer.java */
/* loaded from: classes2.dex */
public class d_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static android.graphics.Typeface f6053a;
    private com.oplus.camera.ui.control.d_renamed.a_renamed l_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    private float f6054b = 0.0f;

    /* renamed from: c_renamed, reason: collision with root package name */
    private float f6055c = 0.0f;
    private int d_renamed = 0;
    private int e_renamed = 0;
    private int f_renamed = 0;
    private int g_renamed = 0;
    private boolean h_renamed = false;
    private boolean i_renamed = false;
    private int j_renamed = 0;
    private com.oplus.camera.ui.control.d_renamed.b_renamed k_renamed = null;
    private com.oplus.camera.ui.RotableTextView m_renamed = null;
    private android.animation.ValueAnimator n_renamed = null;

    /* compiled from: RecordingStopCountDownTimer.java */
    public interface b_renamed {
        void a_renamed();
    }

    static /* synthetic */ int b_renamed(com.oplus.camera.ui.control.d_renamed dVar, int i_renamed) {
        int i2 = dVar.j_renamed - i_renamed;
        dVar.j_renamed = i2;
        return i2;
    }

    public d_renamed() {
        this.l_renamed = null;
        this.l_renamed = new com.oplus.camera.ui.control.d_renamed.a_renamed();
    }

    /* compiled from: RecordingStopCountDownTimer.java */
    private class a_renamed extends android.os.Handler {
        private a_renamed() {
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            com.oplus.camera.e_renamed.a_renamed("RecordingStopCountDownTimer", "handleMessage, what: " + message.what);
            int i_renamed = message.what;
            if (i_renamed == 1) {
                c_renamed();
                a_renamed(1000);
            } else if (i_renamed == 2 && !a_renamed()) {
                a_renamed(1000);
            }
        }

        private boolean a_renamed() {
            if (com.oplus.camera.ui.control.d_renamed.this.j_renamed > 0) {
                return false;
            }
            if (com.oplus.camera.ui.control.d_renamed.this.k_renamed != null) {
                com.oplus.camera.ui.control.d_renamed.this.i_renamed = true;
                com.oplus.camera.ui.control.d_renamed.this.k_renamed.a_renamed();
            }
            return true;
        }

        private void a_renamed(int i_renamed) {
            int iCeil;
            if (com.oplus.camera.ui.control.d_renamed.this.m_renamed != null && (iCeil = (int) java.lang.Math.ceil((com.oplus.camera.ui.control.d_renamed.this.j_renamed * 1.0d) / 1000.0d)) != com.oplus.camera.ui.control.d_renamed.this.g_renamed) {
                com.oplus.camera.ui.control.d_renamed.this.m_renamed.setAlpha(1.0f);
                com.oplus.camera.ui.control.d_renamed.this.m_renamed.setText(com.oplus.camera.util.Util.l_renamed(iCeil));
                com.oplus.camera.ui.control.d_renamed.this.g_renamed = iCeil;
                b_renamed();
            }
            com.oplus.camera.ui.control.d_renamed.b_renamed(com.oplus.camera.ui.control.d_renamed.this, i_renamed);
            removeMessages(2);
            sendMessageDelayed(obtainMessage(2), i_renamed);
        }

        private void b_renamed() {
            if (com.oplus.camera.ui.control.d_renamed.this.n_renamed != null) {
                com.oplus.camera.ui.control.d_renamed.this.n_renamed.cancel();
                com.oplus.camera.ui.control.d_renamed.this.n_renamed.start();
            }
        }

        private void c_renamed() {
            com.oplus.camera.ui.control.d_renamed.this.n_renamed = android.animation.ValueAnimator.ofFloat(1.0f, 0.0f).setDuration(1000L);
            com.oplus.camera.ui.control.d_renamed.this.n_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.d_renamed.a_renamed.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    if (com.oplus.camera.ui.control.d_renamed.this.m_renamed != null) {
                        com.oplus.camera.ui.control.d_renamed.this.m_renamed.setAlpha(((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue());
                        com.oplus.camera.ui.control.d_renamed.this.m_renamed.postInvalidate();
                    }
                }
            });
        }
    }

    public void a_renamed(com.oplus.camera.ui.control.d_renamed.b_renamed bVar) {
        this.k_renamed = bVar;
    }

    private void a_renamed(android.app.Activity activity) throws android.content.res.Resources.NotFoundException {
        if (this.m_renamed != null) {
            return;
        }
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        com.oplus.camera.ui.preview.PreviewFrameLayout previewFrameLayout = (com.oplus.camera.ui.preview.PreviewFrameLayout) activity.findViewById(com.oplus.camera.R_renamed.id_renamed.frame_layout);
        float dimension = activity.getResources().getDimension(com.oplus.camera.R_renamed.dimen.time_snapshot_indicator_shadow_radius_size);
        float dimension2 = activity.getResources().getDimension(com.oplus.camera.R_renamed.dimen.time_snapshot_indicator_shadow_radius_dx);
        float dimension3 = activity.getResources().getDimension(com.oplus.camera.R_renamed.dimen.time_snapshot_indicator_shadow_radius_dy);
        this.f6054b = activity.getResources().getDimension(com.oplus.camera.R_renamed.dimen.time_snapshot_indicator_text_size);
        this.f6055c = activity.getResources().getDimension(com.oplus.camera.R_renamed.dimen.time_snapshot_indicator_text_size_corner);
        this.d_renamed = (int) activity.getResources().getDimension(com.oplus.camera.R_renamed.dimen.time_snapshot_indicator_text_margin_horizontal);
        this.e_renamed = com.oplus.camera.util.Util.N_renamed();
        this.m_renamed = new com.oplus.camera.ui.RotableTextView(activity);
        this.m_renamed.setShadowLayer(dimension, dimension2, dimension3, 0);
        if (f6053a == null) {
            f6053a = com.oplus.camera.util.Util.l_renamed(activity);
        }
        this.m_renamed.setTypeface(f6053a);
        this.m_renamed.setTextSize(0, this.f6054b);
        this.m_renamed.setTextColor(-1);
        previewFrameLayout.addView(this.m_renamed, layoutParams);
        this.m_renamed.setVisibility(8);
    }

    public void a_renamed() {
        this.m_renamed = null;
        this.l_renamed = null;
        android.animation.ValueAnimator valueAnimator = this.n_renamed;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.n_renamed = null;
        }
    }

    public void a_renamed(int i_renamed, android.app.Activity activity, int i2) {
        com.oplus.camera.e_renamed.a_renamed("RecordingStopCountDownTimer", "startTimer, time: " + i_renamed + ", orientation: " + i2);
        this.j_renamed = i_renamed * 1000;
        a_renamed(activity);
        com.oplus.camera.ui.RotableTextView rotableTextView = this.m_renamed;
        if (rotableTextView != null) {
            rotableTextView.setVisibility(0);
            this.m_renamed.a_renamed(i2, false);
            this.f_renamed = i2;
        }
        this.h_renamed = true;
        this.l_renamed.removeMessages(1);
        com.oplus.camera.ui.control.d_renamed.a_renamed aVar = this.l_renamed;
        aVar.sendMessage(aVar.obtainMessage(1));
    }

    public void a_renamed(int i_renamed) {
        if (this.m_renamed == null || this.f_renamed == i_renamed) {
            return;
        }
        com.oplus.camera.e_renamed.a_renamed("RecordingStopCountDownTimer", "updateTextOrientation, mLastOrientation: " + this.f_renamed + ", orientation: " + i_renamed);
        this.m_renamed.a_renamed(i_renamed, true);
        this.f_renamed = i_renamed;
    }

    public boolean b_renamed() {
        return this.h_renamed;
    }

    public void c_renamed() {
        this.l_renamed.removeMessages(2);
        this.h_renamed = false;
        com.oplus.camera.ui.RotableTextView rotableTextView = this.m_renamed;
        if (rotableTextView != null) {
            rotableTextView.clearAnimation();
            this.m_renamed.setVisibility(8);
        }
        this.i_renamed = false;
        this.j_renamed = 0;
    }
}
