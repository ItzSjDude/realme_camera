package com.oplus.camera.ui.preview;

/* loaded from: classes2.dex */
public class NightTimeView extends android.widget.LinearLayout {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static android.graphics.Typeface f6809a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final android.view.animation.PathInterpolator f6810b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.widget.TextView f6811c;
    private android.widget.TextView d_renamed;
    private android.widget.TextView e_renamed;
    private android.widget.TextView f_renamed;
    private android.animation.ObjectAnimator g_renamed;
    private android.animation.ObjectAnimator h_renamed;

    public NightTimeView(android.content.Context context) {
        this(context, null);
    }

    public NightTimeView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NightTimeView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f6810b = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f6811c = null;
        this.d_renamed = null;
        this.e_renamed = null;
        this.f_renamed = null;
        this.g_renamed = null;
        this.h_renamed = null;
    }

    public void a_renamed() {
        this.f6811c = (android.widget.TextView) findViewById(com.oplus.camera.R_renamed.id_renamed.night_count_down_time_value_text_hundreds);
        this.d_renamed = (android.widget.TextView) findViewById(com.oplus.camera.R_renamed.id_renamed.night_count_down_time_value_text_tens);
        this.e_renamed = (android.widget.TextView) findViewById(com.oplus.camera.R_renamed.id_renamed.night_count_down_time_value_text_digits);
        this.f_renamed = (android.widget.TextView) findViewById(com.oplus.camera.R_renamed.id_renamed.night_count_down_time_value_text_decimal);
        android.widget.TextView textView = (android.widget.TextView) findViewById(com.oplus.camera.R_renamed.id_renamed.night_count_down_time_suffix_text);
        android.widget.TextView textView2 = (android.widget.TextView) findViewById(com.oplus.camera.R_renamed.id_renamed.night_count_down_time_value_text_decimal_point);
        android.graphics.Typeface fontTypeface = getFontTypeface();
        this.f6811c.setTypeface(fontTypeface);
        this.d_renamed.setTypeface(fontTypeface);
        this.e_renamed.setTypeface(fontTypeface);
        this.f_renamed.setTypeface(fontTypeface);
        textView.setTypeface(fontTypeface);
        textView2.setTypeface(fontTypeface);
    }

    public static android.graphics.Typeface getFontTypeface() {
        android.graphics.Typeface typeface = f6809a;
        if (typeface != null) {
            return typeface;
        }
        try {
            android.graphics.Typeface.Builder builder = new android.graphics.Typeface.Builder("sys-sans-en_renamed");
            builder.setFontVariationSettings("'wght' 750");
            f6809a = builder.build();
        } catch (java.lang.Exception unused) {
            f6809a = android.graphics.Typeface.DEFAULT;
            com.oplus.camera.e_renamed.f_renamed("NightTimeView", "getFontTypeface, create special typeface fail");
        }
        return f6809a;
    }

    public void a_renamed(long j_renamed) {
        long j2 = j_renamed / 100000;
        long j3 = (j_renamed % 100000) / 10000;
        long j4 = j_renamed % 10000;
        long j5 = j4 / 1000;
        long j6 = (j4 % 1000) / 100;
        if (j2 > 0) {
            this.f6811c.setVisibility(0);
            this.f6811c.setText(java.lang.String.valueOf(j2));
            if (j3 >= 0) {
                this.d_renamed.setVisibility(0);
                this.d_renamed.setText(java.lang.String.valueOf(j3));
            } else {
                this.d_renamed.setVisibility(8);
            }
        } else {
            this.f6811c.setVisibility(8);
            if (j3 > 0) {
                this.d_renamed.setVisibility(0);
                this.d_renamed.setText(java.lang.String.valueOf(j3));
            } else {
                this.d_renamed.setVisibility(8);
            }
        }
        this.e_renamed.setText(java.lang.String.valueOf(j5));
        this.f_renamed.setText(java.lang.String.valueOf(j6));
    }

    public void a_renamed(int i_renamed, boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("NightTimeView", "setVisibility, visibility: " + i_renamed + ", needAnim: " + z_renamed);
        if (i_renamed == 0) {
            a_renamed(z_renamed);
        } else {
            b_renamed(z_renamed);
        }
    }

    private void a_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("NightTimeView", "show, needAnim: " + z_renamed);
        android.animation.ObjectAnimator objectAnimator = this.h_renamed;
        if (objectAnimator != null && objectAnimator.isStarted()) {
            this.h_renamed.cancel();
        } else if (isShown()) {
            return;
        }
        if (z_renamed) {
            if (this.g_renamed == null) {
                this.g_renamed = android.animation.ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
                this.g_renamed.setInterpolator(this.f6810b);
                this.g_renamed.setDuration(250L);
                this.g_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.preview.NightTimeView.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(android.animation.Animator animator) {
                        com.oplus.camera.ui.preview.NightTimeView.this.setVisibility(0);
                        com.oplus.camera.ui.preview.NightTimeView.this.setAlpha(0.0f);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(android.animation.Animator animator) {
                        com.oplus.camera.ui.preview.NightTimeView.this.setAlpha(1.0f);
                    }
                });
                this.g_renamed.setStartDelay(150L);
            }
            this.g_renamed.start();
            return;
        }
        setVisibility(0);
        setAlpha(1.0f);
    }

    private void b_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("NightTimeView", "hide, needAnim: " + z_renamed);
        android.animation.ObjectAnimator objectAnimator = this.g_renamed;
        if (objectAnimator != null && objectAnimator.isStarted()) {
            this.g_renamed.cancel();
        } else if (!isShown()) {
            return;
        }
        if (z_renamed) {
            if (this.h_renamed == null) {
                this.h_renamed = android.animation.ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f);
                this.h_renamed.setInterpolator(this.f6810b);
                this.h_renamed.setDuration(250L);
                this.h_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.preview.NightTimeView.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(android.animation.Animator animator) {
                        com.oplus.camera.ui.preview.NightTimeView.this.setVisibility(0);
                        com.oplus.camera.ui.preview.NightTimeView.this.setAlpha(1.0f);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(android.animation.Animator animator) {
                        com.oplus.camera.ui.preview.NightTimeView.this.setVisibility(8);
                    }
                });
            }
            this.h_renamed.start();
            return;
        }
        setVisibility(8);
    }
}
