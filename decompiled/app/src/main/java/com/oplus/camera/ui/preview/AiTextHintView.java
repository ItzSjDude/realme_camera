package com.oplus.camera.ui.preview;

/* loaded from: classes2.dex */
public class AiTextHintView extends android.widget.LinearLayout {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f6770a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f6771b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f6772c;
    private int d_renamed;
    private int e_renamed;
    private int f_renamed;
    private int g_renamed;
    private com.oplus.camera.ui.menu.OplusTextView h_renamed;
    private com.oplus.camera.ui.preview.AiTextHintView i_renamed;
    private com.oplus.camera.ui.CameraUIListener j_renamed;
    private android.widget.ImageView k_renamed;
    private android.widget.ImageView l_renamed;
    private android.content.Context m_renamed;

    public AiTextHintView(android.content.Context context) {
        this(context, null);
    }

    public AiTextHintView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AiTextHintView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f6770a = 0;
        this.f6771b = 0;
        this.f6772c = 0;
        this.d_renamed = 0;
        this.e_renamed = 0;
        this.f_renamed = 0;
        this.g_renamed = 0;
        this.h_renamed = null;
        this.i_renamed = null;
        this.j_renamed = null;
        this.k_renamed = null;
        this.l_renamed = null;
        this.m_renamed = null;
        this.m_renamed = context;
        setOnTouchListener(new com.oplus.camera.ui.widget.d_renamed());
    }

    public void a_renamed(int i_renamed, int i2, int i3, int i4, int i5, com.oplus.camera.ui.CameraUIListener cameraUIListener) {
        this.f6770a = i_renamed;
        this.f6771b = i2;
        this.f6772c = i3;
        this.d_renamed = i4;
        this.f_renamed = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.pi_ultra_wide_hint_horizontal_margin);
        this.j_renamed = cameraUIListener;
        this.g_renamed = i5;
        this.h_renamed = (com.oplus.camera.ui.menu.OplusTextView) findViewById(com.oplus.camera.R_renamed.id_renamed.ai_hint_bubble_text);
        this.i_renamed = (com.oplus.camera.ui.preview.AiTextHintView) findViewById(com.oplus.camera.R_renamed.id_renamed.ai_hint_hint_layout);
        this.k_renamed = (android.widget.ImageView) findViewById(com.oplus.camera.R_renamed.id_renamed.ai_hint_arrow_image);
        this.l_renamed = (android.widget.ImageView) findViewById(com.oplus.camera.R_renamed.id_renamed.ai_hint_icon);
        this.k_renamed.setRotation(1 == androidx.core.f_renamed.f_renamed.a_renamed(java.util.Locale.getDefault()) ? 180.0f : 0.0f);
        this.i_renamed.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.ui.preview.AiTextHintView.1
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                if (com.oplus.camera.ui.preview.AiTextHintView.this.j_renamed != null) {
                    com.oplus.camera.ui.preview.AiTextHintView.this.j_renamed.a_renamed(com.oplus.camera.ui.preview.AiTextHintView.this.g_renamed);
                }
            }
        });
    }

    public void a_renamed(int i_renamed, int i2, int i3, int i4) {
        com.oplus.camera.e_renamed.a_renamed("AiTextHintView", "showAiHintUI");
        this.e_renamed = i2;
        this.f6770a = i_renamed;
        this.h_renamed.setText(i3);
        setVisibility(0);
        int i5 = this.g_renamed;
        if (i5 == 0) {
            this.k_renamed.setVisibility(0);
        } else if (i5 == 1) {
            this.k_renamed.setVisibility(8);
        }
        this.l_renamed.setBackground(this.m_renamed.getDrawable(i4));
        c_renamed();
    }

    public void a_renamed() {
        if (8 == getVisibility()) {
            com.oplus.camera.e_renamed.b_renamed("AiTextHintView", "hideAiHintUI, return");
        } else {
            setVisibility(8);
        }
    }

    public boolean b_renamed() {
        return getVisibility() == 0;
    }

    private android.util.Size a_renamed(android.view.View view) {
        measure(com.oplus.camera.util.Util.getScreenWidth(), com.oplus.camera.util.Util.getScreenWidth());
        return new android.util.Size(view.getMeasuredWidth(), getContext().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.ai_notice_view_height));
    }

    private void c_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener;
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, getContext().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.ai_notice_view_height));
        android.util.Size sizeA = a_renamed((android.view.View) this);
        int i_renamed = this.e_renamed;
        int i2 = 270;
        if (i_renamed == 90) {
            layoutParams.addRule(10);
            layoutParams.addRule(11);
            layoutParams.topMargin = ((this.f6771b + (this.f6772c / 2)) - (sizeA.getHeight() / 2)) + this.d_renamed;
            layoutParams.rightMargin = ((this.f_renamed + (sizeA.getHeight() / 2)) + (sizeA.getWidth() / 2)) - sizeA.getWidth();
            i2 = 90;
        } else if (i_renamed == 180) {
            layoutParams.addRule(9);
            layoutParams.addRule(10);
            layoutParams.leftMargin = ((com.oplus.camera.util.Util.getScreenWidth() / 2) - (sizeA.getWidth() / 2)) + this.d_renamed;
            layoutParams.topMargin = this.f6770a;
            i2 = 180;
        } else if (i_renamed == 270) {
            layoutParams.addRule(9);
            layoutParams.addRule(10);
            layoutParams.topMargin = ((this.f6771b + (this.f6772c / 2)) - (sizeA.getHeight() / 2)) + this.d_renamed;
            layoutParams.leftMargin = ((this.f_renamed + (sizeA.getHeight() / 2)) + (sizeA.getWidth() / 2)) - sizeA.getWidth();
        } else {
            layoutParams.addRule(9);
            layoutParams.addRule(10);
            layoutParams.leftMargin = ((com.oplus.camera.util.Util.getScreenWidth() / 2) - (sizeA.getWidth() / 2)) + this.d_renamed;
            layoutParams.topMargin = this.f6770a;
            if (com.oplus.camera.util.Util.t_renamed() && (cameraUIListener = this.j_renamed) != null) {
                layoutParams.leftMargin = ((cameraUIListener.bN_renamed() / 2) - (sizeA.getWidth() / 2)) + this.d_renamed;
            }
            i2 = 0;
        }
        setLayoutParams(layoutParams);
        setRotation(-i2);
    }

    public android.view.animation.AnimationSet a_renamed(float f_renamed, float f2) {
        android.view.animation.AnimationSet animationSet = new android.view.animation.AnimationSet(true);
        animationSet.addAnimation(new android.view.animation.AlphaAnimation(f_renamed, f2));
        animationSet.setDuration(180L);
        animationSet.setInterpolator(this.m_renamed, com.oplus.camera.R_renamed.anim.ultra_wide_hint_alpha_path_interpolator);
        return animationSet;
    }
}
