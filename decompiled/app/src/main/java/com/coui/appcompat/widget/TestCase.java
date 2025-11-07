package com.coui.appcompat.widget;

/* compiled from: COUIErrorEditTextHelper.java */
/* loaded from: classes.dex */
class e_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final android.graphics.Rect f2896a = new android.graphics.Rect();

    /* renamed from: b_renamed, reason: collision with root package name */
    private final android.widget.EditText f2897b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final com.coui.appcompat.widget.d_renamed.a_renamed f2898c;
    private android.content.res.ColorStateList d_renamed;
    private int e_renamed;
    private int f_renamed;
    private int g_renamed;
    private com.coui.appcompat.widget.d_renamed h_renamed;
    private android.content.res.ColorStateList i_renamed;
    private android.content.res.ColorStateList j_renamed;
    private android.graphics.Paint k_renamed;
    private android.graphics.Paint l_renamed;
    private android.animation.AnimatorSet m_renamed;
    private boolean n_renamed;
    private java.util.ArrayList<com.coui.appcompat.widget.COUIEditText.c_renamed> o_renamed;
    private boolean p_renamed;
    private boolean q_renamed;
    private float r_renamed;
    private float s_renamed;
    private float t_renamed;
    private float u_renamed;
    private float v_renamed;

    e_renamed(android.widget.EditText editText) {
        this.f2897b = editText;
        this.f2898c = new com.coui.appcompat.widget.d_renamed.a_renamed(this.f2897b);
        this.f2898c.a_renamed(new android.view.animation.LinearInterpolator());
        this.f2898c.b_renamed(new android.view.animation.LinearInterpolator());
        this.f2898c.b_renamed(com.google.android.material.badge.BadgeDrawable.TOP_START);
    }

    void a_renamed(int i_renamed, int i2, int i3, float[] fArr, com.coui.appcompat.widget.d_renamed.a_renamed aVar) throws android.content.res.Resources.NotFoundException {
        this.d_renamed = this.f2897b.getTextColors();
        this.e_renamed = this.f2897b.getHighlightColor();
        this.f_renamed = i_renamed;
        this.g_renamed = i2;
        if (i3 == 2) {
            this.f2898c.a_renamed(android.graphics.Typeface.create("sans-serif-medium", 0));
        }
        this.f2898c.a_renamed(aVar.k_renamed());
        this.f2898c.b_renamed(aVar.g_renamed());
        this.f2898c.a_renamed(aVar.f_renamed());
        this.h_renamed = new com.coui.appcompat.widget.d_renamed();
        this.h_renamed.setCornerRadii(fArr);
        this.k_renamed = new android.graphics.Paint();
        this.k_renamed.setStrokeWidth(this.g_renamed);
        this.l_renamed = new android.graphics.Paint();
        c_renamed();
        this.f2897b.addTextChangedListener(new android.text.TextWatcher() { // from class: com.coui.appcompat.widget.e_renamed.1
            @Override // android.text.TextWatcher
            public void onTextChanged(java.lang.CharSequence charSequence, int i4, int i5, int i6) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(java.lang.CharSequence charSequence, int i4, int i5, int i6) {
                if (com.coui.appcompat.widget.e_renamed.this.v_renamed <= 0.0f) {
                    com.coui.appcompat.widget.e_renamed.this.v_renamed = r0.f2897b.getHeight();
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(android.text.Editable editable) {
                com.coui.appcompat.widget.e_renamed.this.a_renamed(false, false, false);
                android.text.Editable text = com.coui.appcompat.widget.e_renamed.this.f2897b.getText();
                int length = text.length();
                com.coui.appcompat.widget.e_renamed eVar = com.coui.appcompat.widget.e_renamed.this;
                eVar.u_renamed = eVar.f2897b.getPaint().measureText(text, 0, length);
            }
        });
        b_renamed(aVar);
        a_renamed(aVar);
    }

    void a_renamed(android.graphics.Canvas canvas, com.coui.appcompat.widget.d_renamed.a_renamed aVar) {
        this.f2898c.a_renamed(android.content.res.ColorStateList.valueOf(a_renamed(this.i_renamed.getDefaultColor(), this.f_renamed, this.r_renamed)));
        this.f2898c.b_renamed(android.content.res.ColorStateList.valueOf(a_renamed(this.j_renamed.getDefaultColor(), this.f_renamed, this.r_renamed)));
        this.f2898c.b_renamed(aVar.h_renamed());
        this.f2898c.a_renamed(canvas);
    }

    void a_renamed(android.graphics.Canvas canvas, android.graphics.drawable.GradientDrawable gradientDrawable, int i_renamed) {
        this.h_renamed.setBounds(gradientDrawable.getBounds());
        if (gradientDrawable instanceof com.coui.appcompat.widget.d_renamed) {
            this.h_renamed.a_renamed(((com.coui.appcompat.widget.d_renamed) gradientDrawable).b_renamed());
        }
        this.h_renamed.setStroke(this.g_renamed, a_renamed(i_renamed, this.f_renamed, this.r_renamed));
        this.h_renamed.draw(canvas);
    }

    void a_renamed(android.graphics.Canvas canvas, int i_renamed, int i2, int i3, android.graphics.Paint paint, android.graphics.Paint paint2) {
        this.k_renamed.setColor(a_renamed(paint.getColor(), this.f_renamed, this.r_renamed));
        float f_renamed = i_renamed;
        canvas.drawLine(0.0f, f_renamed, i2, f_renamed, this.k_renamed);
        this.k_renamed.setColor(a_renamed(paint2.getColor(), this.f_renamed, this.r_renamed));
        canvas.drawLine(0.0f, f_renamed, i3, f_renamed, this.k_renamed);
    }

    void a_renamed(android.graphics.Canvas canvas) {
        float f_renamed;
        float f2;
        if (this.p_renamed && this.n_renamed) {
            int iSave = canvas.save();
            if (!e_renamed()) {
                canvas.translate(this.s_renamed, 0.0f);
            } else {
                canvas.translate(-this.s_renamed, 0.0f);
            }
            int compoundPaddingStart = this.f2897b.getCompoundPaddingStart();
            int compoundPaddingEnd = this.f2897b.getCompoundPaddingEnd();
            int width = this.f2897b.getWidth() - compoundPaddingEnd;
            int i_renamed = width - compoundPaddingStart;
            float x_renamed = width + this.f2897b.getX() + this.f2897b.getScrollX();
            float f3 = i_renamed;
            float scrollX = (this.u_renamed - this.f2897b.getScrollX()) - f3;
            this.f2897b.getLineBounds(0, f2896a);
            int iSave2 = canvas.save();
            if (!e_renamed()) {
                canvas.translate(compoundPaddingStart, f2896a.top);
            } else {
                canvas.translate(compoundPaddingEnd, f2896a.top);
            }
            int iSave3 = canvas.save();
            if (this.f2897b.getBottom() - this.f2897b.getTop() == this.v_renamed && this.u_renamed > f3) {
                if (!e_renamed()) {
                    canvas.translate(-scrollX, 0.0f);
                    canvas.clipRect(this.f2897b.getScrollX(), 0.0f, x_renamed, this.v_renamed);
                } else {
                    canvas.clipRect(this.f2897b.getScrollX() + i_renamed, 0.0f, this.f2897b.getScrollX(), this.v_renamed);
                }
            }
            android.text.Layout layout = this.f2897b.getLayout();
            layout.getPaint().setColor(this.d_renamed.getDefaultColor());
            layout.draw(canvas);
            canvas.restoreToCount(iSave3);
            canvas.restoreToCount(iSave2);
            android.text.Layout.Alignment alignmentB = b_renamed();
            this.l_renamed.setColor(a_renamed(this.t_renamed));
            if ((alignmentB != android.text.Layout.Alignment.ALIGN_NORMAL || e_renamed()) && (!(alignmentB == android.text.Layout.Alignment.ALIGN_OPPOSITE && e_renamed()) && (!(alignmentB == android.text.Layout.Alignment.ALIGN_NORMAL && e_renamed()) && (alignmentB != android.text.Layout.Alignment.ALIGN_OPPOSITE || e_renamed())))) {
                float f4 = ((compoundPaddingStart + r4) - compoundPaddingEnd) / 2.0f;
                float f5 = this.u_renamed;
                float f6 = f4 - (f5 / 2.0f);
                f_renamed = f6;
                f2 = f6 + f5;
            } else {
                f_renamed = compoundPaddingStart;
                f2 = f_renamed;
            }
            canvas.drawRect(f_renamed, f2896a.top, f2, f2896a.bottom, this.l_renamed);
            canvas.restoreToCount(iSave);
        }
    }

    private android.text.Layout.Alignment b_renamed() {
        switch (this.f2897b.getTextAlignment()) {
            case 1:
                int gravity = this.f2897b.getGravity() & 8388615;
                if (gravity == 1) {
                    return android.text.Layout.Alignment.ALIGN_CENTER;
                }
                if (gravity == 3) {
                    return e_renamed() ? android.text.Layout.Alignment.ALIGN_OPPOSITE : android.text.Layout.Alignment.ALIGN_NORMAL;
                }
                if (gravity == 5) {
                    return e_renamed() ? android.text.Layout.Alignment.ALIGN_NORMAL : android.text.Layout.Alignment.ALIGN_OPPOSITE;
                }
                if (gravity == 8388611) {
                    return android.text.Layout.Alignment.ALIGN_NORMAL;
                }
                if (gravity == 8388613) {
                    return android.text.Layout.Alignment.ALIGN_OPPOSITE;
                }
                return android.text.Layout.Alignment.ALIGN_NORMAL;
            case 2:
                return android.text.Layout.Alignment.ALIGN_NORMAL;
            case 3:
                return android.text.Layout.Alignment.ALIGN_OPPOSITE;
            case 4:
                return android.text.Layout.Alignment.ALIGN_CENTER;
            case 5:
                return android.text.Layout.Alignment.ALIGN_NORMAL;
            case 6:
                return android.text.Layout.Alignment.ALIGN_OPPOSITE;
            default:
                return android.text.Layout.Alignment.ALIGN_NORMAL;
        }
    }

    private void c_renamed() throws android.content.res.Resources.NotFoundException {
        float dimension = this.f2897b.getResources().getDimension(coui.support.appcompat.R_renamed.dimen.coui_edit_text_shake_amplitude);
        android.view.animation.PathInterpolator pathInterpolator = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(pathInterpolator);
        valueAnimatorOfFloat.setDuration(217L);
        valueAnimatorOfFloat.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.widget.e_renamed.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.coui.appcompat.widget.e_renamed.this.r_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        android.animation.ValueAnimator valueAnimatorOfFloat2 = android.animation.ValueAnimator.ofFloat(0.0f, dimension);
        valueAnimatorOfFloat2.setInterpolator(new com.coui.appcompat.widget.e_renamed.a_renamed());
        valueAnimatorOfFloat2.setDuration(com.coui.appcompat.widget.e_renamed.a_renamed.f2905a);
        valueAnimatorOfFloat2.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.widget.e_renamed.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                if (com.coui.appcompat.widget.e_renamed.this.q_renamed) {
                    com.coui.appcompat.widget.e_renamed.this.s_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                }
                com.coui.appcompat.widget.e_renamed.this.f2897b.invalidate();
            }
        });
        android.animation.ValueAnimator valueAnimatorOfFloat3 = android.animation.ValueAnimator.ofFloat(0.0f, 0.3f);
        valueAnimatorOfFloat3.setInterpolator(pathInterpolator);
        valueAnimatorOfFloat3.setDuration(133L);
        valueAnimatorOfFloat3.setStartDelay(80L);
        valueAnimatorOfFloat3.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.widget.e_renamed.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                if (com.coui.appcompat.widget.e_renamed.this.q_renamed) {
                    com.coui.appcompat.widget.e_renamed.this.t_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                }
            }
        });
        this.m_renamed = new android.animation.AnimatorSet();
        this.m_renamed.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2, valueAnimatorOfFloat3);
        this.m_renamed.addListener(new android.animation.Animator.AnimatorListener() { // from class: com.coui.appcompat.widget.e_renamed.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                com.coui.appcompat.widget.e_renamed.this.f2897b.setSelection(com.coui.appcompat.widget.e_renamed.this.f2897b.length());
                if (com.coui.appcompat.widget.e_renamed.this.v_renamed <= 0.0f) {
                    com.coui.appcompat.widget.e_renamed.this.f2897b.post(new java.lang.Runnable() { // from class: com.coui.appcompat.widget.e_renamed.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.coui.appcompat.widget.e_renamed.this.v_renamed = com.coui.appcompat.widget.e_renamed.this.f2897b.getHeight();
                        }
                    });
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.coui.appcompat.widget.e_renamed.this.b_renamed(true, true, true);
                com.coui.appcompat.widget.e_renamed.this.c_renamed(true);
            }
        });
    }

    private int a_renamed(float f_renamed) {
        return android.graphics.Color.argb((int) (f_renamed * 255.0f), android.graphics.Color.red(this.f_renamed), android.graphics.Color.green(this.f_renamed), android.graphics.Color.blue(this.f_renamed));
    }

    private int a_renamed(int i_renamed, int i2, float f_renamed) {
        if (f_renamed <= 0.0f) {
            return i_renamed;
        }
        if (f_renamed >= 1.0f) {
            return i2;
        }
        float f2 = 1.0f - f_renamed;
        int iAlpha = (int) ((android.graphics.Color.alpha(i_renamed) * f2) + (android.graphics.Color.alpha(i2) * f_renamed));
        int iRed = (int) ((android.graphics.Color.red(i_renamed) * f2) + (android.graphics.Color.red(i2) * f_renamed));
        int iGreen = (int) ((android.graphics.Color.green(i_renamed) * f2) + (android.graphics.Color.green(i2) * f_renamed));
        int iBlue = (int) ((android.graphics.Color.blue(i_renamed) * f2) + (android.graphics.Color.blue(i2) * f_renamed));
        if (iAlpha > 255) {
            iAlpha = 255;
        }
        if (iRed > 255) {
            iRed = 255;
        }
        if (iGreen > 255) {
            iGreen = 255;
        }
        if (iBlue > 255) {
            iBlue = 255;
        }
        return android.graphics.Color.argb(iAlpha, iRed, iGreen, iBlue);
    }

    boolean a_renamed() {
        return this.n_renamed;
    }

    void a_renamed(boolean z_renamed) {
        a_renamed(z_renamed, true);
    }

    private void a_renamed(boolean z_renamed, boolean z2) {
        a_renamed(z_renamed, z2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(boolean z_renamed, boolean z2, boolean z3) {
        if (this.n_renamed == z_renamed) {
            return;
        }
        this.n_renamed = z_renamed;
        b_renamed(z_renamed);
        if (z2) {
            b_renamed(z_renamed, z3);
        } else {
            c_renamed(z_renamed, z3);
        }
    }

    private void b_renamed(boolean z_renamed, boolean z2) {
        if (z_renamed) {
            d_renamed();
            this.f2897b.setTextColor(0);
            this.f2897b.setHighlightColor(0);
            this.r_renamed = 0.0f;
            this.s_renamed = 0.0f;
            this.t_renamed = 0.0f;
            this.p_renamed = true;
            this.q_renamed = this.f2897b.isFocused();
            this.m_renamed.start();
            return;
        }
        d_renamed();
        b_renamed(false, false, z2);
    }

    private void c_renamed(boolean z_renamed, boolean z2) {
        if (z_renamed) {
            this.r_renamed = 1.0f;
            this.s_renamed = 0.0f;
            this.t_renamed = 0.0f;
            b_renamed(true, false, z2);
            return;
        }
        b_renamed(false, false, z2);
    }

    private void d_renamed() {
        if (this.m_renamed.isStarted()) {
            this.m_renamed.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b_renamed(boolean z_renamed, boolean z2, boolean z3) {
        this.p_renamed = false;
        if (z_renamed) {
            if (z2) {
                this.f2897b.setTextColor(this.d_renamed);
            }
            this.f2897b.setHighlightColor(a_renamed(0.3f));
            if (z3) {
                android.widget.EditText editText = this.f2897b;
                editText.setSelection(0, editText.getText().length());
                return;
            }
            return;
        }
        this.f2897b.setTextColor(this.d_renamed);
        this.f2897b.setHighlightColor(this.e_renamed);
    }

    private void b_renamed(boolean z_renamed) {
        if (this.o_renamed != null) {
            for (int i_renamed = 0; i_renamed < this.o_renamed.size(); i_renamed++) {
                this.o_renamed.get(i_renamed).a_renamed(z_renamed);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c_renamed(boolean z_renamed) {
        if (this.o_renamed != null) {
            for (int i_renamed = 0; i_renamed < this.o_renamed.size(); i_renamed++) {
                this.o_renamed.get(i_renamed).b_renamed(z_renamed);
            }
        }
    }

    private boolean e_renamed() {
        return this.f2897b.getLayoutDirection() == 1;
    }

    void a_renamed(com.coui.appcompat.widget.d_renamed.a_renamed aVar) {
        this.i_renamed = aVar.p_renamed();
        this.j_renamed = aVar.o_renamed();
        this.f2898c.a_renamed(this.i_renamed);
        this.f2898c.b_renamed(this.j_renamed);
    }

    void b_renamed(com.coui.appcompat.widget.d_renamed.a_renamed aVar) {
        this.f2898c.a_renamed(aVar.n_renamed());
    }

    void c_renamed(com.coui.appcompat.widget.d_renamed.a_renamed aVar) {
        android.graphics.Rect rectA = aVar.a_renamed();
        android.graphics.Rect rectB = aVar.b_renamed();
        this.f2898c.a_renamed(rectA.left, rectA.top, rectA.right, rectA.bottom);
        this.f2898c.b_renamed(rectB.left, rectB.top, rectB.right, rectB.bottom);
        this.f2898c.m_renamed();
    }

    void a_renamed(int[] iArr) {
        this.f2898c.a_renamed(iArr);
    }

    void a_renamed(int i_renamed, android.content.res.ColorStateList colorStateList) {
        this.f2898c.a_renamed(i_renamed, colorStateList);
    }

    void a_renamed(int i_renamed) {
        this.f_renamed = i_renamed;
    }

    /* compiled from: COUIErrorEditTextHelper.java */
    private static class a_renamed implements android.view.animation.Interpolator {
        private final android.view.animation.Interpolator e_renamed;

        /* renamed from: b_renamed, reason: collision with root package name */
        private static final float[] f2906b = {0.0f, -1.0f, 0.5f, -0.5f, 0.0f};

        /* renamed from: c_renamed, reason: collision with root package name */
        private static final int[] f2907c = {83, 133, 117, 117};

        /* renamed from: a_renamed, reason: collision with root package name */
        static final int f2905a = com.coui.appcompat.a_renamed.b_renamed.a_renamed(f2907c);
        private static final float[] d_renamed = new float[f2907c.length + 1];

        static {
            int i_renamed = 0;
            int i2 = 0;
            while (true) {
                int[] iArr = f2907c;
                if (i_renamed >= iArr.length) {
                    return;
                }
                i2 += iArr[i_renamed];
                i_renamed++;
                d_renamed[i_renamed] = i2 / f2905a;
            }
        }

        private a_renamed() {
            this.e_renamed = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f_renamed) {
            int i_renamed = 1;
            while (true) {
                float[] fArr = d_renamed;
                if (i_renamed >= fArr.length) {
                    return 0.0f;
                }
                if (f_renamed <= fArr[i_renamed]) {
                    int i2 = i_renamed - 1;
                    float interpolation = this.e_renamed.getInterpolation((f_renamed - fArr[i2]) / (fArr[i_renamed] - fArr[i2]));
                    float[] fArr2 = f2906b;
                    return (fArr2[i2] * (1.0f - interpolation)) + (fArr2[i_renamed] * interpolation);
                }
                i_renamed++;
            }
        }
    }
}
