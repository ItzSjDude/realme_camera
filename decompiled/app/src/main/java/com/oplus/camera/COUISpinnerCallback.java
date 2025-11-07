package com.oplus.camera;

/* compiled from: HistogramProcessorManager.java */
/* loaded from: classes2.dex */
public class p_renamed {
    private android.content.res.Resources e_renamed;
    private android.view.ViewGroup f_renamed;
    private com.oplus.camera.p_renamed.a_renamed g_renamed;
    private android.content.Context o_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f4916a = 0;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f4917b = 0;

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f4918c = false;
    private android.os.Handler d_renamed = null;
    private android.animation.Animator h_renamed = null;
    private android.widget.FrameLayout i_renamed = null;
    private com.oplus.camera.ui.m_renamed j_renamed = null;
    private android.animation.ValueAnimator k_renamed = null;
    private android.animation.ValueAnimator l_renamed = null;
    private final java.lang.Object m_renamed = new java.lang.Object();
    private android.renderscript.RenderScript n_renamed = null;
    private android.renderscript.ScriptIntrinsicYuvToRGB p_renamed = null;
    private android.renderscript.Allocation q_renamed = null;
    private android.renderscript.Allocation r_renamed = null;
    private byte[] s_renamed = null;
    private float[] t_renamed = null;
    private float[] u_renamed = null;
    private float[] v_renamed = null;
    private float[] w_renamed = null;
    private com.oplus.camera.jni.FormatConverter x_renamed = new com.oplus.camera.jni.FormatConverter();
    private android.os.Handler y_renamed = null;
    private android.widget.RelativeLayout.LayoutParams z_renamed = null;

    /* compiled from: HistogramProcessorManager.java */
    public static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public int f4922a = 0;

        /* renamed from: b_renamed, reason: collision with root package name */
        public int f4923b = 0;

        /* renamed from: c_renamed, reason: collision with root package name */
        public int f4924c = 0;
        public int d_renamed = 0;
        public int e_renamed = 0;
    }

    public p_renamed(android.content.Context context, android.view.View view, com.oplus.camera.p_renamed.a_renamed aVar) {
        this.e_renamed = null;
        this.f_renamed = null;
        this.g_renamed = null;
        this.o_renamed = null;
        this.o_renamed = context;
        this.e_renamed = context.getResources();
        this.f_renamed = (android.view.ViewGroup) view;
        this.g_renamed = aVar;
    }

    private void a_renamed(android.widget.RelativeLayout.LayoutParams layoutParams, boolean z_renamed, boolean z2) {
        if (layoutParams == null) {
            return;
        }
        layoutParams.addRule(this.g_renamed.f4922a);
        layoutParams.addRule(20);
        if (!z_renamed) {
            layoutParams.topMargin = this.g_renamed.f4923b;
        }
        if (!z2) {
            if (1 == androidx.core.f_renamed.f_renamed.a_renamed(java.util.Locale.getDefault())) {
                layoutParams.rightMargin = this.g_renamed.d_renamed;
            } else {
                layoutParams.leftMargin = this.g_renamed.d_renamed;
            }
        }
        layoutParams.bottomMargin = this.g_renamed.f4924c;
    }

    private void c_renamed(com.oplus.camera.professional.u_renamed.a_renamed aVar) {
        if (aVar == null) {
            return;
        }
        android.animation.Animator animator = this.h_renamed;
        if (animator != null) {
            animator.cancel();
            this.h_renamed = null;
        }
        this.h_renamed = com.oplus.camera.professional.u_renamed.a_renamed(this.i_renamed, aVar);
    }

    public void a_renamed(int i_renamed) {
        android.widget.FrameLayout frameLayout = this.i_renamed;
        if (frameLayout != null) {
            frameLayout.setId(i_renamed);
        }
    }

    public void a_renamed(com.oplus.camera.professional.u_renamed.a_renamed aVar) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.e_renamed.a_renamed("HistogramProcessorManager", "showHistogram");
        if (this.i_renamed == null) {
            this.i_renamed = new android.widget.FrameLayout(this.o_renamed);
            this.i_renamed.setBackgroundResource(com.oplus.camera.R_renamed.drawable.film_histogram_bg);
            int dimensionPixelSize = this.e_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.histogram_bg_radius);
            this.i_renamed.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        }
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(this.f_renamed.getLayoutParams());
        layoutParams.width = this.e_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.histogram_graph_view_width);
        layoutParams.height = this.e_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.histogram_graph_view_height);
        a_renamed(layoutParams, false, false);
        this.f_renamed.removeView(this.i_renamed);
        this.f_renamed.addView(this.i_renamed, layoutParams);
        if (this.j_renamed == null) {
            this.j_renamed = new com.oplus.camera.ui.m_renamed(this.o_renamed);
            this.i_renamed.removeAllViews();
            this.i_renamed.addView(this.j_renamed);
        }
        this.f4918c = true;
        this.i_renamed.setRotation(this.g_renamed.e_renamed);
        this.i_renamed.setVisibility(0);
        this.i_renamed.invalidate();
        if (aVar != null) {
            c_renamed(aVar);
        }
    }

    public void a_renamed(com.oplus.camera.p_renamed.a_renamed aVar, boolean z_renamed) {
        a_renamed(aVar, z_renamed, false, 0L);
    }

    public void a_renamed(com.oplus.camera.p_renamed.a_renamed aVar, boolean z_renamed, boolean z2) {
        a_renamed(aVar, z_renamed, z2, 0L);
    }

    public void a_renamed(com.oplus.camera.p_renamed.a_renamed aVar, boolean z_renamed, boolean z2, long j_renamed) {
        android.widget.FrameLayout frameLayout;
        if (aVar == null || (frameLayout = this.i_renamed) == null) {
            return;
        }
        this.z_renamed = (android.widget.RelativeLayout.LayoutParams) frameLayout.getLayoutParams();
        a_renamed(this.z_renamed, z_renamed, z2);
        this.i_renamed.setLayoutParams(this.z_renamed);
        this.i_renamed.setRotation(aVar.e_renamed);
        this.i_renamed.invalidate();
        if (z_renamed) {
            int i_renamed = this.g_renamed.f4923b;
            int i2 = this.z_renamed.topMargin;
            android.animation.ValueAnimator valueAnimator = this.k_renamed;
            if (valueAnimator == null) {
                this.k_renamed = android.animation.ValueAnimator.ofInt(i2, i_renamed);
                this.k_renamed.setDuration(350L);
                this.k_renamed.setInterpolator(com.oplus.camera.professional.t_renamed.f5228b);
                this.k_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.p_renamed.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator2) {
                        com.oplus.camera.p_renamed.this.z_renamed.topMargin = ((java.lang.Integer) valueAnimator2.getAnimatedValue()).intValue();
                        com.oplus.camera.p_renamed.this.i_renamed.setLayoutParams(com.oplus.camera.p_renamed.this.z_renamed);
                    }
                });
            } else {
                valueAnimator.setIntValues(i2, i_renamed);
            }
            if (!this.k_renamed.isRunning()) {
                this.k_renamed.setStartDelay(j_renamed);
                this.k_renamed.start();
            }
        } else {
            android.animation.ValueAnimator valueAnimator2 = this.k_renamed;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
                this.k_renamed = null;
            }
        }
        if (z2) {
            int i3 = this.g_renamed.d_renamed;
            int i4 = this.z_renamed.leftMargin;
            android.animation.ValueAnimator valueAnimator3 = this.l_renamed;
            if (valueAnimator3 == null) {
                this.l_renamed = android.animation.ValueAnimator.ofInt(i4, i3);
                this.l_renamed.setDuration(350L);
                this.l_renamed.setInterpolator(com.oplus.camera.professional.t_renamed.f5228b);
                this.l_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.p_renamed.2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator4) {
                        com.oplus.camera.p_renamed.this.z_renamed.leftMargin = ((java.lang.Integer) valueAnimator4.getAnimatedValue()).intValue();
                        com.oplus.camera.p_renamed.this.i_renamed.setLayoutParams(com.oplus.camera.p_renamed.this.z_renamed);
                    }
                });
            } else {
                valueAnimator3.setIntValues(i4, i3);
            }
            if (!this.l_renamed.isRunning()) {
                this.l_renamed.setStartDelay(j_renamed);
                this.l_renamed.start();
            }
        } else {
            android.animation.ValueAnimator valueAnimator4 = this.l_renamed;
            if (valueAnimator4 != null) {
                valueAnimator4.cancel();
                this.l_renamed = null;
            }
        }
        this.g_renamed = aVar;
    }

    public void a_renamed() {
        com.oplus.camera.e_renamed.a_renamed("HistogramProcessorManager", "updateHistogramLayout");
        if (this.i_renamed == null || !e_renamed()) {
            return;
        }
        android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) this.i_renamed.getLayoutParams();
        a_renamed(layoutParams, false, false);
        this.i_renamed.setLayoutParams(layoutParams);
    }

    public boolean b_renamed() {
        return this.f4918c;
    }

    private boolean e_renamed() {
        android.widget.FrameLayout frameLayout;
        return this.f4918c && this.f_renamed.indexOfChild(this.i_renamed) != -1 && (frameLayout = this.i_renamed) != null && frameLayout.getVisibility() == 0;
    }

    @android.annotation.SuppressLint({"HandlerLeak"})
    public void a_renamed(android.util.Size size) {
        this.f4916a = size.getHeight();
        this.f4917b = size.getWidth();
        com.oplus.camera.e_renamed.a_renamed("HistogramProcessorManager", "HistogramProcessorManager onOpen, mSizeHeight: " + this.f4916a + ", mSizeWidth: " + this.f4917b);
        synchronized (this.m_renamed) {
            this.n_renamed = android.renderscript.RenderScript.create(this.o_renamed);
            this.p_renamed = android.renderscript.ScriptIntrinsicYuvToRGB.create(this.n_renamed, android.renderscript.Element.U8_4(this.n_renamed));
            this.q_renamed = android.renderscript.Allocation.createTyped(this.n_renamed, new android.renderscript.Type.Builder(this.n_renamed, android.renderscript.Element.U8(this.n_renamed)).setX(((this.f4917b * this.f4916a) * 3) / 2).create(), 1);
            this.r_renamed = android.renderscript.Allocation.createTyped(this.n_renamed, new android.renderscript.Type.Builder(this.n_renamed, android.renderscript.Element.RGBA_8888(this.n_renamed)).setX(this.f4917b).setY(this.f4916a).create(), 1);
            this.s_renamed = new byte[this.f4917b * this.f4916a * 4];
            this.t_renamed = new float[1];
            this.u_renamed = new float[256];
            this.v_renamed = new float[256];
            this.w_renamed = new float[256];
        }
        if (this.y_renamed == null) {
            this.y_renamed = new com.oplus.camera.p_renamed.b_renamed();
        }
        if (this.d_renamed == null) {
            this.d_renamed = new android.os.Handler(android.os.Looper.getMainLooper());
        }
    }

    public void b_renamed(com.oplus.camera.professional.u_renamed.a_renamed aVar) {
        com.oplus.camera.e_renamed.a_renamed("HistogramProcessorManager", "stopAndHideHistogram");
        android.animation.ValueAnimator valueAnimator = this.k_renamed;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.k_renamed = null;
        }
        android.animation.ValueAnimator valueAnimator2 = this.l_renamed;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
            this.l_renamed = null;
        }
        android.view.ViewGroup viewGroup = this.f_renamed;
        if (viewGroup != null) {
            if (aVar != null) {
                c_renamed(aVar);
            } else {
                viewGroup.removeView(this.i_renamed);
            }
        }
        this.f4918c = false;
        android.os.Handler handler = this.y_renamed;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        android.os.Handler handler2 = this.d_renamed;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
    }

    public void c_renamed() {
        com.oplus.camera.e_renamed.a_renamed("HistogramProcessorManager", "HistogramProcessorManager onClose");
        b_renamed((com.oplus.camera.professional.u_renamed.a_renamed) null);
        synchronized (this.m_renamed) {
            if (this.r_renamed == null) {
                return;
            }
            if (this.q_renamed != null) {
                this.q_renamed.destroy();
            }
            if (this.r_renamed != null) {
                this.r_renamed.destroy();
            }
            this.r_renamed = null;
            this.q_renamed = null;
            if (this.n_renamed != null) {
                this.n_renamed.destroy();
                this.n_renamed = null;
            }
            this.s_renamed = null;
            this.t_renamed = null;
            this.u_renamed = null;
            this.w_renamed = null;
            this.v_renamed = null;
            this.y_renamed = null;
            this.d_renamed = null;
            android.animation.Animator animator = this.h_renamed;
            if (animator != null) {
                animator.cancel();
                this.h_renamed = null;
            }
        }
    }

    public void a_renamed(byte[] bArr) {
        android.os.Handler handler;
        synchronized (this.m_renamed) {
            if (this.r_renamed == null) {
                return;
            }
            if (!e_renamed() && (handler = this.d_renamed) != null) {
                handler.post(new java.lang.Runnable() { // from class: com.oplus.camera.p_renamed.3
                    @Override // java.lang.Runnable
                    public void run() throws android.content.res.Resources.NotFoundException {
                        com.oplus.camera.p_renamed.this.a_renamed((com.oplus.camera.professional.u_renamed.a_renamed) null);
                    }
                });
            }
            android.os.Handler handler2 = this.y_renamed;
            if (handler2 != null) {
                android.os.Message messageObtainMessage = handler2.obtainMessage(1);
                messageObtainMessage.obj = bArr;
                this.y_renamed.removeMessages(1);
                this.y_renamed.sendMessage(messageObtainMessage);
            }
        }
    }

    public void d_renamed() {
        int i_renamed;
        com.oplus.camera.p_renamed.a_renamed aVar = this.g_renamed;
        if (aVar != null) {
            if (com.oplus.camera.util.Util.u_renamed()) {
                i_renamed = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_rack_movie_histogram_margin_bottom);
            } else {
                i_renamed = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.movie_histogram_margin_bottom) + com.oplus.camera.util.Util.aG_renamed();
            }
            aVar.f4924c = i_renamed;
        }
    }

    /* compiled from: HistogramProcessorManager.java */
    private class b_renamed extends android.os.Handler {
        private b_renamed() {
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            if (message.what != 1) {
                return;
            }
            synchronized (com.oplus.camera.p_renamed.this.m_renamed) {
                try {
                } catch (android.renderscript.RSIllegalArgumentException e_renamed) {
                    e_renamed.printStackTrace();
                    com.oplus.camera.e_renamed.f_renamed("HistogramProcessorManager", "Array too small for allocation type.");
                }
                if (com.oplus.camera.p_renamed.this.q_renamed == null) {
                    return;
                }
                com.oplus.camera.p_renamed.this.q_renamed.copyFrom((byte[]) message.obj);
                com.oplus.camera.p_renamed.this.p_renamed.setInput(com.oplus.camera.p_renamed.this.q_renamed);
                com.oplus.camera.p_renamed.this.p_renamed.forEach(com.oplus.camera.p_renamed.this.r_renamed);
                com.oplus.camera.p_renamed.this.r_renamed.copyTo(com.oplus.camera.p_renamed.this.s_renamed);
                com.oplus.camera.p_renamed.this.x_renamed.statisticsHistogramRGB(com.oplus.camera.p_renamed.this.s_renamed, com.oplus.camera.p_renamed.this.t_renamed, com.oplus.camera.p_renamed.this.f4916a, com.oplus.camera.p_renamed.this.f4917b, 8, com.oplus.camera.p_renamed.this.u_renamed, com.oplus.camera.p_renamed.this.v_renamed, com.oplus.camera.p_renamed.this.w_renamed);
                com.oplus.camera.p_renamed.this.d_renamed.post(new java.lang.Runnable() { // from class: com.oplus.camera.p_renamed.b_renamed.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.oplus.camera.p_renamed.this.j_renamed != null) {
                            com.oplus.camera.p_renamed.this.j_renamed.a_renamed(com.oplus.camera.p_renamed.this.u_renamed, com.oplus.camera.p_renamed.this.v_renamed, com.oplus.camera.p_renamed.this.w_renamed, com.oplus.camera.p_renamed.this.t_renamed[0]);
                        }
                    }
                });
            }
        }
    }

    public static android.util.Size a_renamed(int i_renamed, int i2) {
        int i3 = i_renamed / 3;
        int i4 = i2 / 3;
        if (i3 % 2 != 0) {
            i3++;
        }
        if (i4 % 2 != 0) {
            i4++;
        }
        return new android.util.Size(i3, i4);
    }
}
