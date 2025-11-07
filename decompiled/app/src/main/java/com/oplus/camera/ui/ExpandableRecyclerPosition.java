package com.oplus.camera.ui;

/* compiled from: ZoomClickChangeView.java */
/* loaded from: classes2.dex */
public class x_renamed extends android.widget.LinearLayout {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.String f7291a = "x_renamed";

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.oplus.camera.ui.x_renamed.a_renamed f7292b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.text.DecimalFormat f7293c;
    private com.oplus.camera.ah_renamed d_renamed;
    private boolean e_renamed;
    private android.view.animation.Animation f_renamed;
    private android.view.animation.Animation g_renamed;
    private boolean h_renamed;
    private float i_renamed;
    private boolean j_renamed;
    private long k_renamed;
    private float l_renamed;
    private java.util.List<java.lang.Float> m_renamed;
    private java.util.List<com.oplus.camera.ui.RotableTextView> n_renamed;
    private android.animation.ValueAnimator o_renamed;
    private int p_renamed;

    /* compiled from: ZoomClickChangeView.java */
    public interface a_renamed {
        void a_renamed(float f_renamed);

        void a_renamed(float f_renamed, boolean z_renamed);

        boolean a_renamed();

        void b_renamed();

        void b_renamed(float f_renamed);

        boolean c_renamed();
    }

    public x_renamed(android.content.Context context) {
        this(context, null);
    }

    public x_renamed(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public x_renamed(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f7292b = null;
        this.f7293c = null;
        this.d_renamed = null;
        this.e_renamed = false;
        this.f_renamed = null;
        this.g_renamed = null;
        this.h_renamed = false;
        this.i_renamed = 0.0f;
        this.j_renamed = false;
        this.k_renamed = 0L;
        this.l_renamed = 0.0f;
        this.m_renamed = null;
        this.n_renamed = null;
        this.o_renamed = null;
        this.p_renamed = 1;
        a_renamed(context);
    }

    private void a_renamed(android.content.Context context) {
        setOrientation(0);
        setGravity(17);
        this.f7293c = new java.text.DecimalFormat("#.#");
        setClickable(true);
    }

    public void setListener(com.oplus.camera.ui.x_renamed.a_renamed aVar) {
        this.f7292b = aVar;
    }

    public void a_renamed(int i_renamed, boolean z_renamed) {
        java.util.List<com.oplus.camera.ui.RotableTextView> list = this.n_renamed;
        if (list == null || list.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < this.n_renamed.size(); i2++) {
            this.n_renamed.get(i2).a_renamed(i_renamed, z_renamed);
        }
    }

    public void a_renamed(float f_renamed, java.util.List<java.lang.Float> list, int i_renamed, int i2) throws android.content.res.Resources.NotFoundException {
        java.util.ArrayList arrayList = new java.util.ArrayList(list);
        this.i_renamed = f_renamed;
        this.m_renamed = arrayList;
        this.p_renamed = i2;
        removeAllViews();
        this.n_renamed = new java.util.ArrayList();
        this.d_renamed = new com.oplus.camera.ah_renamed();
        com.oplus.camera.e_renamed.a_renamed(f7291a, "init, points: " + arrayList.toString());
        java.util.Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            final float fFloatValue = ((java.lang.Float) it.next()).floatValue();
            com.oplus.camera.ui.RotableTextView ahVar = new com.oplus.camera.ui.preview.ah_renamed(getContext());
            int dimensionPixelSize = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_mark_button_size);
            android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
            layoutParams.leftMargin = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_mark_button_margin);
            layoutParams.rightMargin = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_mark_button_margin);
            ahVar.setLayoutParams(layoutParams);
            ahVar.setGravity(17);
            boolean z_renamed = false;
            ahVar.setTextSize(0, getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_mark_button_text_size));
            ahVar.setBackground(getResources().getDrawable(com.oplus.camera.R_renamed.drawable.zoom_mark_button_background, null).mutate());
            ahVar.setText(a_renamed(fFloatValue));
            ahVar.setTypeface(com.oplus.camera.util.Util.A_renamed());
            ahVar.setPadding(0, 0, 2, 0);
            ahVar.a_renamed(i_renamed, false);
            ahVar.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.ui.-$$Lambda$x_renamed$6pzU-Ovaa-G2AxJjB6f2woQDqc8
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f_renamed$0.a_renamed(fFloatValue, view);
                }
            });
            addView(ahVar);
            if (!com.oplus.camera.util.Util.u_renamed() && a_renamed(fFloatValue, f_renamed)) {
                z_renamed = true;
            }
            ahVar.setSelected(z_renamed);
            this.n_renamed.add(ahVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a_renamed(float f_renamed, android.view.View view) {
        a_renamed(f_renamed, true);
    }

    public void a_renamed(float f_renamed, boolean z_renamed) {
        com.oplus.camera.ui.x_renamed.a_renamed aVar = this.f7292b;
        if (aVar == null || aVar.a_renamed() || this.h_renamed) {
            return;
        }
        if (!(java.lang.Float.compare(this.i_renamed, f_renamed) == 0 && 0.0f == this.l_renamed) && 200 <= java.lang.System.currentTimeMillis() - this.k_renamed && this.f7292b.c_renamed() && java.lang.Float.compare(this.l_renamed, f_renamed) != 0) {
            this.l_renamed = f_renamed;
            this.f7292b.b_renamed(f_renamed);
            this.j_renamed = z_renamed;
            if (this.j_renamed) {
                a_renamed();
            }
            this.f7292b.a_renamed(f_renamed, this.j_renamed);
            android.animation.ValueAnimator valueAnimator = this.o_renamed;
            if (valueAnimator == null) {
                this.o_renamed = android.animation.ValueAnimator.ofFloat(this.i_renamed, f_renamed);
                this.o_renamed.setDuration(300L);
                this.o_renamed.setInterpolator(android.view.animation.AnimationUtils.loadInterpolator(getContext(), com.oplus.camera.R_renamed.anim.zoom_interpolator_in));
                this.o_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.-$$Lambda$x_renamed$DYtMIOCHyDHYrYGV8HECcFWaflE
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator2) {
                        this.f_renamed$0.a_renamed(valueAnimator2);
                    }
                });
                this.o_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.x_renamed.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(android.animation.Animator animator) {
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(android.animation.Animator animator) {
                        if (com.oplus.camera.ui.x_renamed.this.f7292b != null) {
                            com.oplus.camera.ui.x_renamed.this.f7292b.b_renamed();
                            com.oplus.camera.ui.x_renamed.this.f7292b.b_renamed(-1.0f);
                        }
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(android.animation.Animator animator) {
                        if (com.oplus.camera.ui.x_renamed.this.f7292b != null) {
                            com.oplus.camera.ui.x_renamed.this.f7292b.b_renamed();
                            com.oplus.camera.ui.x_renamed.this.f7292b.b_renamed(-1.0f);
                        }
                    }
                });
            } else {
                if (valueAnimator.isRunning()) {
                    this.o_renamed.cancel();
                }
                this.o_renamed.setFloatValues(this.i_renamed, f_renamed);
            }
            this.o_renamed.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a_renamed(android.animation.ValueAnimator valueAnimator) {
        float fFloatValue = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
        if (com.oplus.camera.ag_renamed.f4106a > fFloatValue) {
            fFloatValue = com.oplus.camera.ag_renamed.f4106a;
        }
        this.f7292b.a_renamed(fFloatValue);
    }

    public java.lang.String a_renamed(float f_renamed) {
        return this.d_renamed.a_renamed(this.e_renamed, f_renamed);
    }

    @Override // android.view.View
    public void setVisibility(int i_renamed) {
        super.setVisibility(i_renamed == 0 ? 0 : 4);
    }

    public void b_renamed(int i_renamed, boolean z_renamed) {
        android.view.animation.Animation animation;
        if (z_renamed) {
            setVisibility(i_renamed);
            if (i_renamed == 0) {
                if (this.f_renamed == null) {
                    this.f_renamed = android.view.animation.AnimationUtils.loadAnimation(getContext(), com.oplus.camera.R_renamed.anim.zoom_button_in);
                    this.f_renamed.setAnimationListener(new android.view.animation.Animation.AnimationListener() { // from class: com.oplus.camera.ui.x_renamed.2
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(android.view.animation.Animation animation2) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(android.view.animation.Animation animation2) {
                            com.oplus.camera.ui.x_renamed.this.h_renamed = true;
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(android.view.animation.Animation animation2) {
                            com.oplus.camera.ui.x_renamed.this.h_renamed = false;
                        }
                    });
                }
                animation = this.f_renamed;
            } else {
                if (this.g_renamed == null) {
                    this.g_renamed = android.view.animation.AnimationUtils.loadAnimation(getContext(), com.oplus.camera.R_renamed.anim.zoom_button_out);
                    this.g_renamed.setAnimationListener(new android.view.animation.Animation.AnimationListener() { // from class: com.oplus.camera.ui.x_renamed.3
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(android.view.animation.Animation animation2) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(android.view.animation.Animation animation2) {
                            com.oplus.camera.ui.x_renamed.this.h_renamed = true;
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(android.view.animation.Animation animation2) {
                            com.oplus.camera.ui.x_renamed.this.h_renamed = false;
                            com.oplus.camera.ui.x_renamed.this.k_renamed = java.lang.System.currentTimeMillis();
                        }
                    });
                }
                animation = this.g_renamed;
            }
            startAnimation(animation);
            return;
        }
        setVisibility(i_renamed);
    }

    public void a_renamed(float f_renamed, boolean z_renamed, boolean z2) {
        this.i_renamed = f_renamed;
        if (z2 || !this.j_renamed) {
            for (int i_renamed = 0; i_renamed < this.m_renamed.size(); i_renamed++) {
                this.n_renamed.get(i_renamed).setSelected(z_renamed && a_renamed(this.m_renamed.get(i_renamed).floatValue(), f_renamed));
            }
            this.l_renamed = 0.0f;
        }
    }

    public void a_renamed() {
        for (int i_renamed = 0; i_renamed < this.m_renamed.size(); i_renamed++) {
            this.n_renamed.get(i_renamed).setSelected(this.j_renamed && java.lang.Float.compare(this.m_renamed.get(i_renamed).floatValue(), this.l_renamed) == 0);
        }
        this.l_renamed = 0.0f;
    }

    public void setZoomUnit(boolean z_renamed) {
        this.e_renamed = z_renamed;
    }

    @Override // android.view.View
    public void setEnabled(boolean z_renamed) {
        super.setEnabled(z_renamed);
        if (this.m_renamed == null) {
            return;
        }
        for (int i_renamed = 0; i_renamed < this.m_renamed.size(); i_renamed++) {
            this.n_renamed.get(i_renamed).setEnabled(z_renamed);
        }
    }

    private boolean a_renamed(float f_renamed, float f2) {
        boolean zB = b_renamed(f_renamed, f2);
        if (zB) {
            float f3 = this.l_renamed;
            if (f3 > 0.0f) {
                boolean zB2 = b_renamed(f_renamed, f3);
                if (zB2) {
                    this.l_renamed = 0.0f;
                }
                return zB2;
            }
        }
        return zB;
    }

    private boolean b_renamed(float f_renamed, float f2) {
        return f_renamed == com.oplus.camera.ag_renamed.a_renamed(f2, this.p_renamed);
    }

    public void setFromClickView(boolean z_renamed) {
        this.j_renamed = z_renamed;
    }
}
