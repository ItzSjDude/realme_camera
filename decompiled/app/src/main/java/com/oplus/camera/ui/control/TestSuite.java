package com.oplus.camera.ui.control;

/* compiled from: TimerSnapShotManager.java */
/* loaded from: classes2.dex */
public class i_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static android.graphics.Typeface f6076a;
    private com.oplus.camera.ui.control.i_renamed.a_renamed n_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    private float f6077b = 0.0f;

    /* renamed from: c_renamed, reason: collision with root package name */
    private float f6078c = 0.0f;
    private int d_renamed = 0;
    private int e_renamed = 0;
    private boolean f_renamed = false;
    private boolean g_renamed = false;
    private boolean h_renamed = false;
    private boolean i_renamed = false;
    private int j_renamed = 0;
    private int k_renamed = 0;
    private long l_renamed = 0;
    private com.oplus.camera.ui.control.i_renamed.b_renamed m_renamed = null;
    private com.oplus.camera.ui.RotableTextView o_renamed = null;
    private android.animation.ValueAnimator p_renamed = null;

    /* compiled from: TimerSnapShotManager.java */
    public interface b_renamed {
        void a_renamed();

        void a_renamed(boolean z_renamed);

        void b_renamed(boolean z_renamed);

        void c_renamed(boolean z_renamed);

        void d_renamed(boolean z_renamed);
    }

    static /* synthetic */ int a_renamed(com.oplus.camera.ui.control.i_renamed iVar, int i_renamed) {
        int i2 = iVar.j_renamed - i_renamed;
        iVar.j_renamed = i2;
        return i2;
    }

    public i_renamed() {
        this.n_renamed = null;
        this.n_renamed = new com.oplus.camera.ui.control.i_renamed.a_renamed();
    }

    /* compiled from: TimerSnapShotManager.java */
    private class a_renamed extends android.os.Handler {

        /* renamed from: b_renamed, reason: collision with root package name */
        private boolean f6080b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private int f6081c;
        private int d_renamed;
        private int e_renamed;

        private a_renamed() {
            this.f6080b = false;
            this.f6081c = 0;
            this.d_renamed = 0;
            this.e_renamed = 0;
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            com.oplus.camera.e_renamed.a_renamed("TimerSnapShotManager", "handleMessage, what: " + message.what);
            int i_renamed = message.what;
            if (i_renamed == 1) {
                int iIntValue = ((java.lang.Integer) message.obj).intValue();
                if (com.oplus.camera.ui.control.i_renamed.this.o_renamed != null) {
                    com.oplus.camera.ui.control.i_renamed.this.o_renamed.a_renamed(iIntValue, false);
                }
                this.e_renamed = iIntValue;
                this.f6080b = true;
                this.f6081c = 0;
                this.d_renamed = 0;
                return;
            }
            if (i_renamed == 2) {
                if (b_renamed()) {
                    return;
                }
                c_renamed(((java.lang.Integer) message.obj).intValue());
            } else {
                if (i_renamed != 3) {
                    return;
                }
                a_renamed(((java.lang.Boolean) message.obj).booleanValue() ? 1 : 2, message.arg1);
                if (this.f6080b) {
                    com.oplus.camera.e_renamed.a_renamed("TimerSnapShotManager", "handleMessage, MSG_UPDATE_POSITION, mbFirstPreview");
                    this.f6080b = false;
                    c_renamed(1000);
                }
            }
        }

        public void a_renamed() {
            this.f6080b = false;
        }

        private boolean b_renamed() {
            if (com.oplus.camera.ui.control.i_renamed.this.j_renamed > 0) {
                return false;
            }
            if (com.oplus.camera.ui.control.i_renamed.this.m_renamed != null) {
                com.oplus.camera.ui.control.i_renamed.this.g_renamed = true;
                com.oplus.camera.ui.control.i_renamed.this.m_renamed.a_renamed(com.oplus.camera.ui.control.i_renamed.this.i_renamed);
            }
            return true;
        }

        private void a_renamed(int i_renamed, int i2) {
            if (com.oplus.camera.ui.control.i_renamed.this.o_renamed != null) {
                int i3 = this.d_renamed;
                if (i3 == 0) {
                    b_renamed(i_renamed);
                    this.d_renamed = i_renamed;
                } else if (i3 != i_renamed) {
                    b_renamed(i_renamed);
                    if (this.d_renamed == 1) {
                        a_renamed(com.oplus.camera.ui.control.i_renamed.this.o_renamed, (com.oplus.camera.ui.control.i_renamed.this.f6077b * 1.0f) / com.oplus.camera.ui.control.i_renamed.this.f6078c, this.d_renamed, i_renamed);
                    } else if (i_renamed == 1) {
                        a_renamed(com.oplus.camera.ui.control.i_renamed.this.o_renamed, (com.oplus.camera.ui.control.i_renamed.this.f6078c * 1.0f) / com.oplus.camera.ui.control.i_renamed.this.f6077b, this.d_renamed, i_renamed);
                    }
                    this.d_renamed = i_renamed;
                }
                if (this.e_renamed != i2) {
                    com.oplus.camera.ui.control.i_renamed.this.o_renamed.a_renamed(i2, true);
                    this.e_renamed = i2;
                }
            }
        }

        private void a_renamed(android.view.View view, float f_renamed, int i_renamed, int i2) {
            int i3;
            android.graphics.PointF pointFA = a_renamed(i_renamed);
            android.graphics.PointF pointFA2 = a_renamed(i2);
            view.setScaleX(f_renamed);
            view.setScaleY(f_renamed);
            if (!com.oplus.camera.util.Util.u_renamed() || (i3 = this.e_renamed) == 0) {
                view.setTranslationY(pointFA.y_renamed - pointFA2.y_renamed);
                view.setTranslationX(pointFA.x_renamed - pointFA2.x_renamed);
            } else if (270 == i3) {
                view.setTranslationY(pointFA2.y_renamed - pointFA.y_renamed);
                view.setTranslationX(pointFA.x_renamed - pointFA2.x_renamed);
            } else {
                view.setTranslationY(pointFA.y_renamed - pointFA2.y_renamed);
                view.setTranslationX(pointFA2.x_renamed - pointFA.x_renamed);
            }
            view.animate().setDuration(500L).scaleX(1.0f).scaleY(1.0f).translationX(1.0f).translationY(1.0f);
        }

        private android.graphics.PointF a_renamed(int i_renamed) {
            float height;
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) com.oplus.camera.ui.control.i_renamed.this.o_renamed.getParent();
            float width = 0.0f;
            if (i_renamed == 1) {
                width = viewGroup.getWidth() / 2.0f;
                height = viewGroup.getHeight() / 2.0f;
            } else if (i_renamed != 2) {
                height = 0.0f;
            } else {
                int i2 = (!com.oplus.camera.ui.control.i_renamed.this.h_renamed || com.oplus.camera.util.Util.u_renamed()) ? 0 : com.oplus.camera.ui.control.i_renamed.this.e_renamed;
                if (com.oplus.camera.util.Util.u_renamed() && this.e_renamed != 0) {
                    i2 = com.oplus.camera.ui.control.i_renamed.this.d_renamed;
                }
                width = (viewGroup.getWidth() - (com.oplus.camera.ui.control.i_renamed.this.f6078c / 2.0f)) - com.oplus.camera.ui.control.i_renamed.this.d_renamed;
                height = (com.oplus.camera.ui.control.i_renamed.this.f6078c / 2.0f) + i2;
            }
            return new android.graphics.PointF(width, height);
        }

        private void b_renamed(int i_renamed) {
            int i2;
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            if (i_renamed == 1) {
                layoutParams.addRule(13);
                com.oplus.camera.ui.control.i_renamed.this.o_renamed.setTextSize(0, com.oplus.camera.ui.control.i_renamed.this.f6077b);
                com.oplus.camera.ui.control.i_renamed.this.o_renamed.setTextColor(-1);
            } else if (i_renamed == 2) {
                if (!com.oplus.camera.util.Util.u_renamed() || (i2 = this.e_renamed) == 0) {
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    layoutParams.rightMargin = com.oplus.camera.ui.control.i_renamed.this.d_renamed;
                    if (com.oplus.camera.ui.control.i_renamed.this.h_renamed && !com.oplus.camera.util.Util.u_renamed()) {
                        layoutParams.topMargin = com.oplus.camera.ui.control.i_renamed.this.e_renamed;
                    }
                } else if (270 == i2) {
                    layoutParams.addRule(12);
                    layoutParams.addRule(11);
                    layoutParams.rightMargin = com.oplus.camera.ui.control.i_renamed.this.d_renamed;
                    layoutParams.bottomMargin = com.oplus.camera.ui.control.i_renamed.this.d_renamed;
                } else if (90 == i2) {
                    layoutParams.addRule(10);
                    layoutParams.addRule(9);
                    layoutParams.leftMargin = com.oplus.camera.ui.control.i_renamed.this.d_renamed;
                    layoutParams.topMargin = com.oplus.camera.ui.control.i_renamed.this.d_renamed;
                }
                com.oplus.camera.ui.control.i_renamed.this.o_renamed.setTextSize(0, com.oplus.camera.ui.control.i_renamed.this.f6078c);
                com.oplus.camera.ui.control.i_renamed.this.o_renamed.setTextColor(com.oplus.camera.ui.inverse.e_renamed.INS.isInverseColor(com.oplus.camera.ui.control.i_renamed.this.o_renamed.getContext().hashCode()) ? com.oplus.camera.ui.control.i_renamed.this.o_renamed.getContext().getColor(com.oplus.camera.R_renamed.color.inverse_text_color) : -1);
            }
            com.oplus.camera.ui.control.i_renamed.this.o_renamed.setLayoutParams(layoutParams);
        }

        private void c_renamed(int i_renamed) {
            int iCeil;
            if (com.oplus.camera.ui.control.i_renamed.this.o_renamed != null && (iCeil = (int) java.lang.Math.ceil((com.oplus.camera.ui.control.i_renamed.this.j_renamed * 1.0d) / 1000.0d)) != this.f6081c) {
                com.oplus.camera.ui.control.i_renamed.this.o_renamed.setAlpha(1.0f);
                com.oplus.camera.ui.control.i_renamed.this.o_renamed.setText(com.oplus.camera.util.Util.l_renamed(iCeil));
                this.f6081c = iCeil;
                c_renamed();
            }
            com.oplus.camera.ui.control.i_renamed.a_renamed(com.oplus.camera.ui.control.i_renamed.this, i_renamed);
            com.oplus.camera.ui.control.i_renamed.this.m_renamed.a_renamed();
            int i2 = 1000;
            if (com.oplus.camera.ui.control.i_renamed.this.k_renamed > 3000 && com.oplus.camera.ui.control.i_renamed.this.j_renamed <= 3000) {
                i2 = com.oplus.camera.ui.control.i_renamed.this.j_renamed <= 1000 ? 125 : 250;
            }
            removeMessages(2);
            sendMessageDelayed(obtainMessage(2, java.lang.Integer.valueOf(i2)), i_renamed);
        }

        private void c_renamed() {
            if (com.oplus.camera.ui.control.i_renamed.this.p_renamed == null) {
                d_renamed();
            }
            com.oplus.camera.ui.control.i_renamed.this.p_renamed.cancel();
            com.oplus.camera.ui.control.i_renamed.this.p_renamed.start();
        }

        private void d_renamed() {
            com.oplus.camera.ui.control.i_renamed.this.p_renamed = android.animation.ValueAnimator.ofFloat(1.0f, 0.0f).setDuration(1000L);
            com.oplus.camera.ui.control.i_renamed.this.p_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.i_renamed.a_renamed.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    if (com.oplus.camera.ui.control.i_renamed.this.o_renamed != null) {
                        com.oplus.camera.ui.control.i_renamed.this.o_renamed.setAlpha(((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue());
                        com.oplus.camera.ui.control.i_renamed.this.o_renamed.postInvalidate();
                    }
                }
            });
        }
    }

    public void a_renamed(com.oplus.camera.ui.control.i_renamed.b_renamed bVar) {
        this.m_renamed = bVar;
    }

    private void a_renamed(android.app.Activity activity) throws android.content.res.Resources.NotFoundException {
        if (this.o_renamed != null) {
            return;
        }
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        com.oplus.camera.ui.preview.PreviewFrameLayout previewFrameLayout = (com.oplus.camera.ui.preview.PreviewFrameLayout) activity.findViewById(com.oplus.camera.R_renamed.id_renamed.frame_layout);
        float dimension = activity.getResources().getDimension(com.oplus.camera.R_renamed.dimen.time_snapshot_indicator_shadow_radius_size);
        float dimension2 = activity.getResources().getDimension(com.oplus.camera.R_renamed.dimen.time_snapshot_indicator_shadow_radius_dx);
        float dimension3 = activity.getResources().getDimension(com.oplus.camera.R_renamed.dimen.time_snapshot_indicator_shadow_radius_dy);
        this.f6077b = activity.getResources().getDimension(com.oplus.camera.R_renamed.dimen.time_snapshot_indicator_text_size);
        this.f6078c = activity.getResources().getDimension(com.oplus.camera.R_renamed.dimen.time_snapshot_indicator_text_size_corner);
        this.d_renamed = (int) activity.getResources().getDimension(com.oplus.camera.R_renamed.dimen.time_snapshot_indicator_text_margin_horizontal);
        this.e_renamed = com.oplus.camera.util.Util.N_renamed();
        this.o_renamed = new com.oplus.camera.ui.RotableTextView(activity);
        this.o_renamed.setShadowLayer(dimension, dimension2, dimension3, 0);
        if (f6076a == null) {
            f6076a = com.oplus.camera.util.Util.l_renamed(activity);
        }
        this.o_renamed.setTypeface(f6076a);
        this.o_renamed.setTextSize(0, this.f6077b);
        previewFrameLayout.addView(this.o_renamed, layoutParams);
        this.o_renamed.setVisibility(8);
    }

    public void a_renamed() {
        this.o_renamed = null;
        this.n_renamed = null;
        android.animation.ValueAnimator valueAnimator = this.p_renamed;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.p_renamed = null;
        }
    }

    public java.lang.String b_renamed() {
        if (this.o_renamed == null) {
            return null;
        }
        return this.o_renamed.getWidth() + "x_renamed" + this.o_renamed.getHeight();
    }

    public java.lang.String c_renamed() {
        if (this.o_renamed == null) {
            return null;
        }
        return this.o_renamed.getLeft() + "," + this.o_renamed.getTop() + "," + this.o_renamed.getRight() + "," + this.o_renamed.getBottom();
    }

    public void a_renamed(int i_renamed, android.app.Activity activity, int i2, boolean z_renamed, boolean z2) {
        com.oplus.camera.e_renamed.a_renamed("TimerSnapShotManager", "startTimerSnapShot, time: " + i_renamed);
        this.i_renamed = z2;
        this.h_renamed = z_renamed;
        this.j_renamed = i_renamed * 1000;
        this.k_renamed = this.j_renamed;
        a_renamed(activity);
        this.f_renamed = true;
        com.oplus.camera.ui.RotableTextView rotableTextView = this.o_renamed;
        if (rotableTextView != null) {
            rotableTextView.setVisibility(0);
        }
        this.n_renamed.removeMessages(1);
        com.oplus.camera.ui.control.i_renamed.a_renamed aVar = this.n_renamed;
        aVar.sendMessage(aVar.obtainMessage(1, java.lang.Integer.valueOf(i2)));
        this.m_renamed.b_renamed(this.i_renamed);
    }

    public boolean d_renamed() {
        return this.f_renamed;
    }

    public boolean e_renamed() {
        return this.g_renamed;
    }

    public void f_renamed() {
        this.n_renamed.removeMessages(2);
        this.n_renamed.removeMessages(3);
        this.n_renamed.a_renamed();
        this.f_renamed = false;
        this.i_renamed = false;
        com.oplus.camera.ui.RotableTextView rotableTextView = this.o_renamed;
        if (rotableTextView != null) {
            rotableTextView.clearAnimation();
            this.o_renamed.setVisibility(8);
        }
        com.oplus.camera.ui.control.i_renamed.b_renamed bVar = this.m_renamed;
        if (bVar != null) {
            bVar.c_renamed(this.g_renamed);
        }
        this.g_renamed = false;
        this.j_renamed = 0;
        this.k_renamed = 0;
        this.l_renamed = 0L;
    }

    public void a_renamed(android.graphics.Rect rect, android.hardware.camera2.params.Face[] faceArr, int i_renamed) {
        if (java.lang.System.currentTimeMillis() - this.l_renamed > 500) {
            this.l_renamed = java.lang.System.currentTimeMillis();
            boolean zA = a_renamed(rect, faceArr);
            this.n_renamed.removeMessages(3);
            android.os.Message messageObtainMessage = this.n_renamed.obtainMessage(3);
            messageObtainMessage.obj = java.lang.Boolean.valueOf(zA);
            messageObtainMessage.arg1 = i_renamed;
            this.n_renamed.sendMessage(messageObtainMessage);
            com.oplus.camera.ui.control.i_renamed.b_renamed bVar = this.m_renamed;
            if (bVar != null) {
                bVar.d_renamed(zA);
            }
        }
    }

    private boolean a_renamed(android.graphics.Rect rect, android.hardware.camera2.params.Face[] faceArr) {
        if (faceArr == null || faceArr.length <= 0) {
            return true;
        }
        int iWidth = (rect.width() * rect.height()) / 16;
        for (android.hardware.camera2.params.Face face : faceArr) {
            if (a_renamed(face, iWidth)) {
                return true;
            }
        }
        return false;
    }

    private boolean a_renamed(android.hardware.camera2.params.Face face, int i_renamed) {
        if (face == null) {
            return false;
        }
        android.graphics.Rect bounds = face.getBounds();
        return bounds.width() * bounds.height() <= i_renamed;
    }
}
