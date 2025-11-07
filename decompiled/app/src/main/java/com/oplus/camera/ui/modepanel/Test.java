package com.oplus.camera.ui.modepanel;

/* compiled from: FloatView.java */
/* loaded from: classes2.dex */
public class d_renamed extends android.widget.RelativeLayout {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final float f6718a = com.oplus.camera.k_renamed.f_renamed() / com.oplus.camera.k_renamed.m_renamed();

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final float f6719b = com.oplus.camera.k_renamed.m_renamed() / com.oplus.camera.k_renamed.f_renamed();

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final float f6720c = (com.oplus.camera.k_renamed.f_renamed() * 1.27f) / com.oplus.camera.k_renamed.m_renamed();
    private final android.view.animation.Interpolator d_renamed;
    private final android.view.animation.Interpolator e_renamed;
    private final android.view.animation.Interpolator f_renamed;
    private android.text.TextPaint g_renamed;
    private android.text.TextPaint h_renamed;
    private int i_renamed;
    private int j_renamed;
    private int k_renamed;
    private int l_renamed;
    private int m_renamed;
    private int n_renamed;
    private android.widget.ImageView o_renamed;
    private android.widget.TextView p_renamed;
    private android.animation.AnimatorSet q_renamed;
    private int r_renamed;
    private int s_renamed;
    private boolean t_renamed;
    private int u_renamed;
    private int v_renamed;

    protected d_renamed(android.content.Context context) {
        this(context, null);
    }

    protected d_renamed(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected d_renamed(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.d_renamed = androidx.core.h_renamed.b_renamed.b_renamed.a_renamed(0.4f, 0.0f, 0.2f, 1.0f);
        this.e_renamed = androidx.core.h_renamed.b_renamed.b_renamed.a_renamed(0.33f, 0.0f, 0.67f, 1.0f);
        this.f_renamed = androidx.core.h_renamed.b_renamed.b_renamed.a_renamed(0.3f, 0.0f, 0.1f, 1.0f);
        this.g_renamed = null;
        this.h_renamed = null;
        this.i_renamed = 0;
        this.j_renamed = 0;
        this.k_renamed = 0;
        this.l_renamed = 0;
        this.m_renamed = 0;
        this.n_renamed = 0;
        this.o_renamed = null;
        this.p_renamed = null;
        this.q_renamed = new android.animation.AnimatorSet();
        this.r_renamed = 0;
        this.s_renamed = 0;
        this.t_renamed = false;
        this.u_renamed = 0;
        this.v_renamed = 90;
        inflate(context, com.oplus.camera.R_renamed.layout.float_view_layout, this);
        this.o_renamed = (android.widget.ImageView) findViewById(com.oplus.camera.R_renamed.id_renamed.float_item_icon);
        this.p_renamed = (android.widget.TextView) findViewById(com.oplus.camera.R_renamed.id_renamed.float_item_text);
        this.m_renamed = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.more_item_top_padding);
        this.i_renamed = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.more_icon_title_spacing);
        d_renamed();
    }

    private void d_renamed() {
        this.g_renamed = new android.text.TextPaint();
        this.g_renamed.setTextSize(com.oplus.camera.k_renamed.f_renamed());
        this.g_renamed.setColor(this.k_renamed);
        this.g_renamed.setStyle(android.graphics.Paint.Style.FILL);
        this.g_renamed.setFlags(1);
        this.g_renamed.setTypeface(com.oplus.camera.util.Util.l_renamed(getContext()));
        this.h_renamed = new android.text.TextPaint();
        this.h_renamed.setTextSize(com.oplus.camera.k_renamed.m_renamed());
        this.h_renamed.setColor(this.k_renamed);
        this.h_renamed.setStyle(android.graphics.Paint.Style.FILL);
        this.h_renamed.setFlags(1);
        this.h_renamed.setTypeface(com.oplus.camera.util.Util.l_renamed(getContext()));
    }

    private void setGradientAlpha(float f_renamed) {
        if (this.t_renamed) {
            return;
        }
        int iArgb = android.graphics.Color.argb(f_renamed, 1.0f, 1.0f, 1.0f);
        android.graphics.drawable.GradientDrawable gradientDrawable = (android.graphics.drawable.GradientDrawable) this.p_renamed.getBackground();
        gradientDrawable.setColor(iArgb);
        this.p_renamed.setBackground(gradientDrawable);
    }

    protected int getModeId() {
        return this.n_renamed;
    }

    protected void a_renamed(com.oplus.camera.ui.modepanel.k_renamed kVar, int i_renamed) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.e_renamed.a_renamed("FloatView", "initChildren, id_renamed: " + kVar.b_renamed() + ", type: " + i_renamed);
        android.graphics.Bitmap bitmapA = com.oplus.camera.util.Util.a_renamed(getContext(), kVar.c_renamed());
        this.o_renamed.setImageBitmap(bitmapA);
        android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) this.o_renamed.getLayoutParams();
        layoutParams.topMargin = (int) (((float) this.m_renamed) + (((float) (com.oplus.camera.k_renamed.o_renamed() - bitmapA.getHeight())) * 0.5f));
        this.o_renamed.setLayoutParams(layoutParams);
        this.p_renamed.setText(kVar.a_renamed());
        this.p_renamed.setTypeface(com.oplus.camera.util.Util.c_renamed(true));
        this.n_renamed = kVar.b_renamed();
        if (1 != i_renamed) {
            if (2 == i_renamed) {
                this.o_renamed.setVisibility(4);
                this.o_renamed.setAlpha(0.0f);
                android.widget.RelativeLayout.LayoutParams layoutParams2 = (android.widget.RelativeLayout.LayoutParams) this.p_renamed.getLayoutParams();
                layoutParams2.width = (int) java.lang.Math.ceil(this.h_renamed.measureText(kVar.a_renamed()) + (com.oplus.camera.k_renamed.g_renamed() * 2));
                layoutParams2.addRule(13);
                this.p_renamed.setLayoutParams(layoutParams2);
                this.p_renamed.setTextSize(0, com.oplus.camera.k_renamed.m_renamed());
                android.graphics.drawable.GradientDrawable gradientDrawable = (android.graphics.drawable.GradientDrawable) this.p_renamed.getBackground();
                gradientDrawable.setColor(android.graphics.Color.argb(0.1f, 1.0f, 1.0f, 1.0f));
                this.p_renamed.setBackground(gradientDrawable);
                return;
            }
            return;
        }
        float fA_renamed = a_renamed(kVar.a_renamed(), this.g_renamed);
        this.p_renamed.setTag(com.oplus.camera.R_renamed.id_renamed.tag_float_view_text_margin_top, java.lang.Float.valueOf(fA_renamed));
        this.p_renamed.setTextSize(0, com.oplus.camera.k_renamed.f_renamed());
        android.widget.RelativeLayout.LayoutParams layoutParams3 = (android.widget.RelativeLayout.LayoutParams) this.p_renamed.getLayoutParams();
        android.graphics.Paint.FontMetrics fontMetrics = this.g_renamed.getFontMetrics();
        int dimensionPixelSize = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.float_view_top_margin_offset);
        if (((java.lang.Integer) getTag(com.oplus.camera.R_renamed.id_renamed.tag_float_view_measure_width)).intValue() > com.oplus.camera.k_renamed.d_renamed()) {
            layoutParams3.topMargin = ((int) (((this.m_renamed + com.oplus.camera.k_renamed.o_renamed()) + this.i_renamed) - fA_renamed)) + dimensionPixelSize;
        } else {
            layoutParams3.topMargin = ((int) ((((this.m_renamed + com.oplus.camera.k_renamed.o_renamed()) + this.i_renamed) - fA_renamed) - ((com.oplus.camera.k_renamed.a_renamed() - (fontMetrics.bottom - fontMetrics.top)) / 2.0f))) + dimensionPixelSize;
        }
        layoutParams3.addRule(14);
        layoutParams3.width = (int) java.lang.Math.ceil(this.g_renamed.measureText(kVar.a_renamed()) + (com.oplus.camera.k_renamed.g_renamed() * 2));
        this.p_renamed.setLayoutParams(layoutParams3);
        android.graphics.drawable.GradientDrawable gradientDrawable2 = (android.graphics.drawable.GradientDrawable) this.p_renamed.getBackground();
        gradientDrawable2.setColor(android.graphics.Color.argb(0.0f, 1.0f, 1.0f, 1.0f));
        this.p_renamed.setBackground(gradientDrawable2);
    }

    private float a_renamed(java.lang.String str, android.text.TextPaint textPaint) {
        android.text.StaticLayout.Builder.obtain(str, 0, str.length(), textPaint, this.l_renamed).setMaxLines(this.j_renamed).setAlignment(android.text.Layout.Alignment.ALIGN_CENTER).setEllipsize(android.text.TextUtils.TruncateAt.END).setTextDirection(android.text.TextDirectionHeuristics.LOCALE).build();
        return textPaint.getFontMetrics().ascent - textPaint.getFontMetrics().top;
    }

    protected void a_renamed() {
        if (0.0f == this.o_renamed.getAlpha()) {
            return;
        }
        if (getTag(com.oplus.camera.R_renamed.id_renamed.tag_float_view_anim_headline) == null || !((android.animation.Animator) getTag(com.oplus.camera.R_renamed.id_renamed.tag_float_view_anim_headline)).isRunning()) {
            this.o_renamed.setAlpha(1.0f);
            android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(1.0f, 0.0f);
            valueAnimatorOfFloat.setInterpolator(this.e_renamed);
            valueAnimatorOfFloat.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.modepanel.-$$Lambda$d_renamed$VE8tu2SVc_4pOVveeZwOVeLHUOo
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    this.f_renamed$0.f_renamed(valueAnimator);
                }
            });
            valueAnimatorOfFloat.setDuration(200L);
            valueAnimatorOfFloat.start();
            setTag(com.oplus.camera.R_renamed.id_renamed.tag_float_view_anim_headline, valueAnimatorOfFloat);
            float f_renamed = 1 == ((java.lang.Integer) getTag(com.oplus.camera.R_renamed.id_renamed.tag_float_view_type_from)).intValue() ? 1.27f : f6720c;
            android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this, (android.util.Property<com.oplus.camera.ui.modepanel.d_renamed, java.lang.Float>) SCALE_X, getScaleX(), f_renamed);
            android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(this, (android.util.Property<com.oplus.camera.ui.modepanel.d_renamed, java.lang.Float>) SCALE_Y, getScaleY(), f_renamed);
            objectAnimatorOfFloat.setDuration(200L).start();
            objectAnimatorOfFloat2.setDuration(200L).start();
            android.animation.ObjectAnimator objectAnimatorOfFloat3 = android.animation.ObjectAnimator.ofFloat(this.p_renamed, (android.util.Property<android.widget.TextView, java.lang.Float>) TRANSLATION_Y, this.p_renamed.getTranslationY(), ((getHeight() / 2) - (this.p_renamed.getHeight() / 2)) - this.p_renamed.getTop());
            objectAnimatorOfFloat3.setDuration(200L);
            objectAnimatorOfFloat3.start();
            if (1 == ((java.lang.Integer) getTag(com.oplus.camera.R_renamed.id_renamed.tag_float_view_type_from)).intValue()) {
                int iCeil = (int) java.lang.Math.ceil(this.g_renamed.measureText(this.p_renamed.getText().toString()) + (com.oplus.camera.k_renamed.g_renamed() * 2));
                if (iCeil > com.oplus.camera.k_renamed.d_renamed()) {
                    android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) getLayoutParams();
                    layoutParams.width = iCeil;
                    setLayoutParams(layoutParams);
                    android.widget.RelativeLayout.LayoutParams layoutParams2 = (android.widget.RelativeLayout.LayoutParams) this.p_renamed.getLayoutParams();
                    layoutParams2.width = iCeil;
                    this.p_renamed.setLayoutParams(layoutParams2);
                    return;
                }
                return;
            }
            int iIntValue = ((java.lang.Integer) getTag(com.oplus.camera.R_renamed.id_renamed.tag_float_view_measure_width)).intValue();
            android.widget.FrameLayout.LayoutParams layoutParams3 = (android.widget.FrameLayout.LayoutParams) getLayoutParams();
            layoutParams3.width = java.lang.Math.max(iIntValue, com.oplus.camera.k_renamed.d_renamed());
            setLayoutParams(layoutParams3);
            android.widget.RelativeLayout.LayoutParams layoutParams4 = (android.widget.RelativeLayout.LayoutParams) this.p_renamed.getLayoutParams();
            layoutParams4.width = iIntValue;
            this.p_renamed.setLayoutParams(layoutParams4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f_renamed(android.animation.ValueAnimator valueAnimator) {
        float fFloatValue = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
        this.o_renamed.setAlpha(fFloatValue);
        android.graphics.drawable.GradientDrawable gradientDrawable = (android.graphics.drawable.GradientDrawable) this.p_renamed.getBackground();
        gradientDrawable.setColor(android.graphics.Color.argb((1.0f - fFloatValue) * 0.1f, 1.0f, 1.0f, 1.0f));
        this.p_renamed.setBackground(gradientDrawable);
    }

    protected void b_renamed() {
        if (1.0f == this.o_renamed.getAlpha()) {
            return;
        }
        if (getTag(com.oplus.camera.R_renamed.id_renamed.tag_float_view_anim_modelist) == null || !((android.animation.Animator) getTag(com.oplus.camera.R_renamed.id_renamed.tag_float_view_anim_modelist)).isRunning()) {
            this.t_renamed = true;
            this.o_renamed.setVisibility(0);
            float fFloatValue = 0.0f;
            this.o_renamed.setAlpha(0.0f);
            android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimatorOfFloat.setInterpolator(this.e_renamed);
            valueAnimatorOfFloat.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.modepanel.-$$Lambda$d_renamed$RZo5pF01pvDdmgFjWb2gxsQ7T2M
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    this.f_renamed$0.e_renamed(valueAnimator);
                }
            });
            valueAnimatorOfFloat.setDuration(200L);
            valueAnimatorOfFloat.start();
            setTag(com.oplus.camera.R_renamed.id_renamed.tag_float_view_anim_modelist, valueAnimatorOfFloat);
            if (1 != ((java.lang.Integer) getTag(com.oplus.camera.R_renamed.id_renamed.tag_float_view_type_from)).intValue()) {
                if (this.p_renamed.getTag(com.oplus.camera.R_renamed.id_renamed.tag_float_view_text_margin_top) == null) {
                    if (((java.lang.Integer) getTag(com.oplus.camera.R_renamed.id_renamed.tag_float_view_measure_width)).intValue() > com.oplus.camera.k_renamed.d_renamed()) {
                        fFloatValue = (((this.m_renamed + com.oplus.camera.k_renamed.o_renamed()) + this.i_renamed) - this.p_renamed.getTop()) + this.h_renamed.getFontMetrics().descent;
                    } else {
                        android.graphics.Paint.FontMetrics fontMetrics = this.h_renamed.getFontMetrics();
                        fFloatValue = ((((this.m_renamed + com.oplus.camera.k_renamed.o_renamed()) + this.i_renamed) - a_renamed(this.p_renamed.getText().toString(), this.h_renamed)) - this.p_renamed.getTop()) - ((this.p_renamed.getHeight() - (fontMetrics.bottom - fontMetrics.top)) / 2.0f);
                    }
                    this.p_renamed.setTag(com.oplus.camera.R_renamed.id_renamed.tag_float_view_text_margin_top, java.lang.Float.valueOf(fFloatValue));
                } else {
                    fFloatValue = ((java.lang.Float) this.p_renamed.getTag(com.oplus.camera.R_renamed.id_renamed.tag_float_view_text_margin_top)).floatValue();
                }
            }
            android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.p_renamed, (android.util.Property<android.widget.TextView, java.lang.Float>) TRANSLATION_Y, this.p_renamed.getTranslationY(), fFloatValue);
            objectAnimatorOfFloat.setDuration(200L);
            objectAnimatorOfFloat.start();
            float f_renamed = 1 != ((java.lang.Integer) getTag(com.oplus.camera.R_renamed.id_renamed.tag_float_view_type_from)).intValue() ? (com.oplus.camera.k_renamed.f_renamed() * 1.15f) / com.oplus.camera.k_renamed.m_renamed() : 1.0f;
            android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(this.p_renamed, (android.util.Property<android.widget.TextView, java.lang.Float>) SCALE_X, this.p_renamed.getScaleX(), f_renamed);
            android.animation.ObjectAnimator objectAnimatorOfFloat3 = android.animation.ObjectAnimator.ofFloat(this.p_renamed, (android.util.Property<android.widget.TextView, java.lang.Float>) SCALE_Y, this.p_renamed.getScaleY(), f_renamed);
            objectAnimatorOfFloat2.setDuration(200L).start();
            objectAnimatorOfFloat3.setDuration(200L).start();
            int iIntValue = ((java.lang.Integer) getTag(com.oplus.camera.R_renamed.id_renamed.tag_float_view_measure_width)).intValue();
            if (iIntValue > com.oplus.camera.k_renamed.d_renamed()) {
                android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) getLayoutParams();
                android.widget.RelativeLayout.LayoutParams layoutParams2 = (android.widget.RelativeLayout.LayoutParams) this.p_renamed.getLayoutParams();
                if (4 == this.u_renamed) {
                    layoutParams.width = iIntValue;
                    layoutParams.height = com.oplus.camera.k_renamed.e_renamed();
                    layoutParams2.width = iIntValue;
                } else {
                    layoutParams.width = com.oplus.camera.k_renamed.d_renamed();
                    layoutParams.height = com.oplus.camera.k_renamed.e_renamed();
                    layoutParams2.width = com.oplus.camera.k_renamed.d_renamed();
                }
                setLayoutParams(layoutParams);
                this.p_renamed.setLayoutParams(layoutParams2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e_renamed(android.animation.ValueAnimator valueAnimator) {
        float fFloatValue = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
        this.o_renamed.setAlpha(fFloatValue);
        android.graphics.drawable.GradientDrawable gradientDrawable = (android.graphics.drawable.GradientDrawable) this.p_renamed.getBackground();
        gradientDrawable.setColor(android.graphics.Color.argb((1.0f - fFloatValue) * 0.1f, 1.0f, 1.0f, 1.0f));
        this.p_renamed.setBackground(gradientDrawable);
    }

    protected android.graphics.Rect getFloatLocation() {
        if (0.0f == this.o_renamed.getAlpha()) {
            return com.oplus.camera.ui.modepanel.c_renamed.c_renamed(this.p_renamed, this.u_renamed, this.v_renamed);
        }
        return com.oplus.camera.ui.modepanel.c_renamed.c_renamed(this, this.u_renamed, this.v_renamed);
    }

    protected void a_renamed(int i_renamed) {
        setTag(com.oplus.camera.R_renamed.id_renamed.tag_float_view_type_from, java.lang.Integer.valueOf(i_renamed));
        this.t_renamed = false;
        if (1 == i_renamed) {
            android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this, (android.util.Property<com.oplus.camera.ui.modepanel.d_renamed, java.lang.Float>) SCALE_X, 1.0f, f6718a);
            android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(this, (android.util.Property<com.oplus.camera.ui.modepanel.d_renamed, java.lang.Float>) SCALE_Y, 1.0f, f6718a);
            android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
            animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
            animatorSet.setInterpolator(this.d_renamed);
            animatorSet.setDuration(200L).start();
            postDelayed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.modepanel.-$$Lambda$d_renamed$fzODbe1bIMXJ558ukT1zXA7elzo
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.f_renamed();
                }
            }, 200L);
            return;
        }
        if (2 == i_renamed) {
            android.animation.ObjectAnimator objectAnimatorOfFloat3 = android.animation.ObjectAnimator.ofFloat(this, (android.util.Property<com.oplus.camera.ui.modepanel.d_renamed, java.lang.Float>) SCALE_X, 1.0f, 0.9f);
            objectAnimatorOfFloat3.setInterpolator(this.d_renamed);
            android.animation.ObjectAnimator objectAnimatorOfFloat4 = android.animation.ObjectAnimator.ofFloat(this, (android.util.Property<com.oplus.camera.ui.modepanel.d_renamed, java.lang.Float>) SCALE_Y, 1.0f, 0.9f);
            objectAnimatorOfFloat4.setInterpolator(this.d_renamed);
            android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(0.1f, 0.7f);
            valueAnimatorOfFloat.setInterpolator(this.e_renamed);
            valueAnimatorOfFloat.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.modepanel.-$$Lambda$d_renamed$QYYfPHf2NKQ0Jf_i_Cuz6rTWWVc
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    this.f_renamed$0.d_renamed(valueAnimator);
                }
            });
            android.animation.AnimatorSet animatorSet2 = new android.animation.AnimatorSet();
            animatorSet2.playTogether(objectAnimatorOfFloat3, objectAnimatorOfFloat4, valueAnimatorOfFloat);
            animatorSet2.setDuration(200L).start();
            postDelayed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.modepanel.-$$Lambda$d_renamed$Mz_5tnuj8Geg4crOWA4lfVZXrwI
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.e_renamed();
                }
            }, 200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f_renamed() {
        android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this, (android.util.Property<com.oplus.camera.ui.modepanel.d_renamed, java.lang.Float>) SCALE_X, f6718a, 1.15f);
        android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(this, (android.util.Property<com.oplus.camera.ui.modepanel.d_renamed, java.lang.Float>) SCALE_Y, f6718a, 1.15f);
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        animatorSet.setInterpolator(this.d_renamed);
        animatorSet.setDuration(200L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d_renamed(android.animation.ValueAnimator valueAnimator) {
        setGradientAlpha(((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e_renamed() {
        android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this, (android.util.Property<com.oplus.camera.ui.modepanel.d_renamed, java.lang.Float>) SCALE_X, 0.9f, f6720c);
        objectAnimatorOfFloat.setInterpolator(this.d_renamed);
        android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(this, (android.util.Property<com.oplus.camera.ui.modepanel.d_renamed, java.lang.Float>) SCALE_Y, 0.9f, f6720c);
        objectAnimatorOfFloat2.setInterpolator(this.d_renamed);
        android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(0.7f, 0.1f);
        valueAnimatorOfFloat.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.modepanel.-$$Lambda$d_renamed$iNYon3EQJoADA4b47HfwaSkTx_E
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                this.f_renamed$0.c_renamed(valueAnimator);
            }
        });
        valueAnimatorOfFloat.setInterpolator(this.e_renamed);
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, valueAnimatorOfFloat);
        animatorSet.setDuration(200L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c_renamed(android.animation.ValueAnimator valueAnimator) {
        setGradientAlpha(((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    protected void a_renamed(android.graphics.Rect rect, int i_renamed) {
        if (this.q_renamed.isRunning()) {
            this.q_renamed.end();
        }
        this.q_renamed.removeAllListeners();
        this.r_renamed = 0;
        this.s_renamed = 0;
        android.graphics.Rect rectC = com.oplus.camera.ui.modepanel.c_renamed.c_renamed(this, this.u_renamed, this.v_renamed);
        int i2 = this.u_renamed;
        if (1 == i2 || 4 == i2) {
            rectC = a_renamed(rectC);
        }
        if (rectC.width() == 0 || rectC.height() == 0) {
            rectC = rect;
        }
        int iCenterX = rect.centerX() - rectC.centerX();
        int iCenterY = rect.centerY() - rectC.centerY();
        android.animation.ValueAnimator valueAnimatorOfInt = android.animation.ValueAnimator.ofInt(0, iCenterX);
        valueAnimatorOfInt.setInterpolator(this.f_renamed);
        valueAnimatorOfInt.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.modepanel.-$$Lambda$d_renamed$Kf8E8CG25W5CtT39bhXmxo1xC60
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                this.f_renamed$0.b_renamed(valueAnimator);
            }
        });
        android.animation.ValueAnimator valueAnimatorOfInt2 = android.animation.ValueAnimator.ofInt(0, iCenterY);
        valueAnimatorOfInt2.setInterpolator(this.f_renamed);
        valueAnimatorOfInt2.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.modepanel.-$$Lambda$d_renamed$uM_cHLhT-Xp6YeTW1SM_LYar1RE
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                this.f_renamed$0.a_renamed(valueAnimator);
            }
        });
        float f_renamed = 1.0f;
        if (2 == i_renamed) {
            if (1 == ((java.lang.Integer) getTag(com.oplus.camera.R_renamed.id_renamed.tag_float_view_type_from)).intValue()) {
                f_renamed = f6719b;
                final android.graphics.drawable.GradientDrawable gradientDrawable = (android.graphics.drawable.GradientDrawable) this.p_renamed.getBackground();
                android.graphics.Rect bounds = gradientDrawable.getBounds();
                final int i3 = bounds.right;
                final int i4 = bounds.bottom;
                android.animation.ValueAnimator valueAnimatorOfInt3 = android.animation.ValueAnimator.ofInt(0, (int) (bounds.height() * 0.06f));
                valueAnimatorOfInt3.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.modepanel.-$$Lambda$d_renamed$Z63t23L2aCR7p2BAOlmeuAx_eNY
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                        this.f_renamed$0.a_renamed(gradientDrawable, i3, i4, valueAnimator);
                    }
                });
                valueAnimatorOfInt3.setDuration(200L).start();
            }
        } else if (2 == ((java.lang.Integer) getTag(com.oplus.camera.R_renamed.id_renamed.tag_float_view_type_from)).intValue()) {
            android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.p_renamed, (android.util.Property<android.widget.TextView, java.lang.Float>) SCALE_X, this.p_renamed.getScaleX(), f6718a);
            android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(this.p_renamed, (android.util.Property<android.widget.TextView, java.lang.Float>) SCALE_Y, this.p_renamed.getScaleY(), f6718a);
            objectAnimatorOfFloat.setDuration(200L).start();
            objectAnimatorOfFloat2.setDuration(200L).start();
        }
        android.animation.ObjectAnimator objectAnimatorOfFloat3 = android.animation.ObjectAnimator.ofFloat(this, (android.util.Property<com.oplus.camera.ui.modepanel.d_renamed, java.lang.Float>) SCALE_X, getScaleX(), f_renamed);
        android.animation.ObjectAnimator objectAnimatorOfFloat4 = android.animation.ObjectAnimator.ofFloat(this, (android.util.Property<com.oplus.camera.ui.modepanel.d_renamed, java.lang.Float>) SCALE_Y, getScaleY(), f_renamed);
        objectAnimatorOfFloat3.setInterpolator(this.d_renamed);
        objectAnimatorOfFloat4.setInterpolator(this.d_renamed);
        this.q_renamed.playTogether(valueAnimatorOfInt, valueAnimatorOfInt2, objectAnimatorOfFloat3, objectAnimatorOfFloat4);
        this.q_renamed.setDuration(200L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b_renamed(android.animation.ValueAnimator valueAnimator) {
        int iIntValue = ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue();
        int i_renamed = iIntValue - this.r_renamed;
        this.r_renamed = iIntValue;
        a_renamed(i_renamed, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a_renamed(android.animation.ValueAnimator valueAnimator) {
        int iIntValue = ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue();
        int i_renamed = iIntValue - this.s_renamed;
        this.s_renamed = iIntValue;
        a_renamed(0.0f, i_renamed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a_renamed(android.graphics.drawable.GradientDrawable gradientDrawable, int i_renamed, int i2, android.animation.ValueAnimator valueAnimator) {
        int iIntValue = ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue();
        gradientDrawable.setBounds(iIntValue, iIntValue, i_renamed - iIntValue, i2 - iIntValue);
        this.p_renamed.setBackground(gradientDrawable);
    }

    protected void a_renamed(float f_renamed, float f2) {
        if (0.0f != f_renamed) {
            setX(getX() + f_renamed);
        }
        if (0.0f != f2) {
            setY(getY() + f2);
        }
    }

    protected boolean c_renamed() {
        java.lang.Object tag = getTag(com.oplus.camera.R_renamed.id_renamed.tag_float_view_anim_headline);
        java.lang.Object tag2 = getTag(com.oplus.camera.R_renamed.id_renamed.tag_float_view_anim_modelist);
        if (tag == null || !((android.animation.Animator) tag).isRunning()) {
            return tag2 != null && ((android.animation.Animator) tag2).isRunning();
        }
        return true;
    }

    protected float getTextTranslationY() {
        android.widget.TextView textView = this.p_renamed;
        if (textView == null) {
            return 0.0f;
        }
        textView.getTranslationY();
        return 0.0f;
    }

    protected float a_renamed(java.lang.String str, int i_renamed) {
        if (1 == i_renamed) {
            return this.g_renamed.measureText(str);
        }
        if (2 == i_renamed) {
            return this.h_renamed.measureText(str);
        }
        return 0.0f;
    }

    public void a_renamed(int i_renamed, int i2) {
        this.u_renamed = i_renamed;
        this.v_renamed = i2;
        if (i_renamed == 1) {
            this.i_renamed = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.vertical_more_icon_title_spacing);
            this.m_renamed = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.vertical_more_item_top_padding);
        } else {
            this.i_renamed = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.more_icon_title_spacing);
            this.m_renamed = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.more_item_top_padding);
        }
    }

    public android.graphics.Rect a_renamed(android.graphics.Rect rect) {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        int i_renamed = this.u_renamed;
        if (1 != i_renamed && 4 != i_renamed) {
            return rect;
        }
        int i2 = this.v_renamed;
        if (270 == i2) {
            return new android.graphics.Rect(iArr[0], iArr[1] - ((int) (getHeight() * getScaleY())), iArr[0] + ((int) (getWidth() * getScaleX())), iArr[1]);
        }
        return 90 == i2 ? new android.graphics.Rect(iArr[0] - ((int) (getWidth() * getScaleX())), iArr[1], iArr[0], iArr[1] + ((int) (getHeight() * getScaleY()))) : rect;
    }
}
