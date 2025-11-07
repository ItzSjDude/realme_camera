package com.oplus.camera.timelapsepro;

/* loaded from: classes2.dex */
public class ParameterItem extends android.widget.RelativeLayout {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.widget.ImageView f5624a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final android.widget.RelativeLayout f5625b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final com.oplus.camera.ui.RotateLottieAnimationView f5626c;
    private final android.widget.TextView d_renamed;
    private final android.widget.ImageView e_renamed;
    private com.oplus.camera.timelapsepro.a_renamed.e_renamed f_renamed;
    private android.animation.AnimatorSet g_renamed;
    private boolean h_renamed;
    private android.os.Handler i_renamed;

    public ParameterItem(android.content.Context context) {
        this(context, null);
    }

    public ParameterItem(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ParameterItem(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) throws android.content.res.Resources.NotFoundException {
        super(context, attributeSet, i_renamed);
        this.h_renamed = false;
        this.i_renamed = null;
        android.view.View viewInflate = android.view.LayoutInflater.from(context).inflate(com.oplus.camera.R_renamed.layout.time_lapse_pro_param_item, this);
        setLayoutParams(new android.widget.RelativeLayout.LayoutParams(getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_param_item_width), getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_param_item_height)));
        setClipChildren(false);
        setClipToPadding(false);
        this.f5624a = (android.widget.ImageView) viewInflate.findViewById(com.oplus.camera.R_renamed.id_renamed.icon_select);
        this.f5625b = (android.widget.RelativeLayout) viewInflate.findViewById(com.oplus.camera.R_renamed.id_renamed.icon_bg);
        this.f5626c = (com.oplus.camera.ui.RotateLottieAnimationView) viewInflate.findViewById(com.oplus.camera.R_renamed.id_renamed.icon);
        this.d_renamed = (android.widget.TextView) viewInflate.findViewById(com.oplus.camera.R_renamed.id_renamed.name);
        this.e_renamed = (android.widget.ImageView) viewInflate.findViewById(com.oplus.camera.R_renamed.id_renamed.auto);
        this.d_renamed.setShadowLayer(getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.camera_time_split_shadow_radius_size), getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.camera_time_split_shadow_dx), getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.camera_time_split_shadow_dy), androidx.core.a_renamed.a_renamed.c_renamed(context, com.oplus.camera.R_renamed.color.color_black_with_full_percent_transparency));
        this.i_renamed = new android.os.Handler(android.os.Looper.getMainLooper());
        d_renamed();
    }

    private void d_renamed() {
        final com.a_renamed.a_renamed.f_renamed fVarA = com.oplus.camera.professional.u_renamed.a_renamed();
        setOnTouchListener(new android.view.View.OnTouchListener() { // from class: com.oplus.camera.timelapsepro.ParameterItem.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    com.oplus.camera.professional.u_renamed.a_renamed((android.view.View) com.oplus.camera.timelapsepro.ParameterItem.this.f5624a, fVarA, true);
                    com.oplus.camera.professional.u_renamed.a_renamed((android.view.View) com.oplus.camera.timelapsepro.ParameterItem.this.f5625b, fVarA, true);
                } else if (action == 1 || action == 3) {
                    com.oplus.camera.professional.u_renamed.a_renamed((android.view.View) com.oplus.camera.timelapsepro.ParameterItem.this.f5624a, fVarA, false);
                    com.oplus.camera.professional.u_renamed.a_renamed((android.view.View) com.oplus.camera.timelapsepro.ParameterItem.this.f5625b, fVarA, false);
                }
                return false;
            }
        });
    }

    public void a_renamed(com.oplus.camera.timelapsepro.a_renamed.e_renamed eVar, com.oplus.camera.timelapsepro.a_renamed.e_renamed.b_renamed bVar) {
        com.oplus.camera.e_renamed.a_renamed("ParameterItem", "setData, parameter: " + eVar + ", callback: " + bVar);
        this.f_renamed = eVar;
        this.f5626c.setImageResource(eVar.c_renamed());
        this.d_renamed.setText(eVar.e_renamed());
        this.e_renamed.setVisibility((eVar.a_renamed() && eVar.g_renamed()) ? 0 : 8);
        if (this.f_renamed.h_renamed() != isEnabled()) {
            setItemEnabled(this.f_renamed.h_renamed());
        }
        if (this.f_renamed.m_renamed()) {
            this.f5626c.setAnimation(this.f_renamed.l_renamed());
            this.h_renamed = true;
        }
        this.f_renamed.a_renamed(new com.oplus.camera.timelapsepro.ParameterItem.XPanMode_2());
        this.f_renamed.a_renamed(bVar);
    }

    /* renamed from: com.oplus.camera.timelapsepro.ParameterItem$2, reason: invalid class name */
    class XPanMode_2 implements com.oplus.camera.timelapsepro.a_renamed.e_renamed.a_renamed {
        XPanMode_2() {
        }

        @Override // com.oplus.camera.timelapsepro.a_renamed.e_renamed.a_renamed
        public void a_renamed() {
            if (com.oplus.camera.timelapsepro.ParameterItem.this.i_renamed != null) {
                com.oplus.camera.timelapsepro.ParameterItem.this.i_renamed.post(new java.lang.Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$ParameterItem$2$Yon49sGBhrE7ih-hoRJBGdFHYSQ
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f_renamed$0.b_renamed();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b_renamed() {
            com.oplus.camera.timelapsepro.ParameterItem.this.c_renamed();
        }
    }

    public void a_renamed() {
        com.oplus.camera.timelapsepro.a_renamed.e_renamed eVar = this.f_renamed;
        if (eVar != null) {
            eVar.a_renamed((com.oplus.camera.timelapsepro.a_renamed.e_renamed.a_renamed) null);
            this.f_renamed.a_renamed((com.oplus.camera.timelapsepro.a_renamed.e_renamed.b_renamed) null);
        }
        android.os.Handler handler = this.i_renamed;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.i_renamed = null;
        }
    }

    public void b_renamed() {
        if (this.h_renamed) {
            this.f5626c.a_renamed();
        }
    }

    public com.oplus.camera.timelapsepro.a_renamed.e_renamed getProParameter() {
        return this.f_renamed;
    }

    public void c_renamed() {
        com.oplus.camera.util.Util.a_renamed(this.f5624a, this.f_renamed.i_renamed() ? 0 : 4, (android.view.animation.Animation.AnimationListener) null, this.f_renamed.i_renamed() ? 280L : 150L, 0L, com.oplus.camera.professional.t_renamed.f5227a);
        this.d_renamed.setText(this.f_renamed.e_renamed());
        com.oplus.camera.util.Util.a_renamed(this.e_renamed, (this.f_renamed.a_renamed() && this.f_renamed.g_renamed()) ? 0 : 8, (android.view.animation.Animation.AnimationListener) null, 250L);
        if (this.f_renamed.h_renamed() != isEnabled()) {
            setItemEnabled(this.f_renamed.h_renamed());
        }
    }

    public void setItemEnabled(final boolean z_renamed) {
        android.animation.ObjectAnimator objectAnimatorOfFloat;
        setEnabled(z_renamed);
        if (z_renamed && this.f_renamed.m_renamed()) {
            this.f5626c.f_renamed();
            this.f5626c.setProgress(0.0f);
        }
        android.animation.AnimatorSet animatorSet = this.g_renamed;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.g_renamed.end();
        }
        if (z_renamed) {
            objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.f5626c, "alpha", 0.2f, 1.0f);
        } else {
            objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.f5626c, "alpha", 1.0f, 0.2f);
        }
        objectAnimatorOfFloat.setInterpolator(com.oplus.camera.professional.t_renamed.f5227a);
        objectAnimatorOfFloat.setDuration(250L);
        objectAnimatorOfFloat.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.timelapsepro.ParameterItem.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.oplus.camera.timelapsepro.ParameterItem.this.f5626c.setAlpha(z_renamed ? 1.0f : 0.2f);
            }
        });
        this.g_renamed = new android.animation.AnimatorSet();
        this.g_renamed.play(objectAnimatorOfFloat);
        this.g_renamed.start();
    }

    public void setText(java.lang.String str) {
        this.d_renamed.setText(str);
    }

    public void a_renamed(int i_renamed, int i2, boolean z_renamed) {
        android.view.ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (i_renamed == 1) {
            this.f5625b.setSelected(true);
            layoutParams.width = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_param_item_width);
            layoutParams.height = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_param_item_height_full_screen);
            return;
        }
        if (i_renamed == 2) {
            this.f5625b.setSelected(false);
            layoutParams.width = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_param_item_width);
            layoutParams.height = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_param_item_height);
        } else if (i_renamed == 3) {
            this.f5625b.setSelected(false);
            layoutParams.width = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_param_item_width_rack);
            layoutParams.height = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_param_item_height);
        } else {
            if (i_renamed != 4) {
                return;
            }
            this.f5625b.setSelected(!z_renamed);
            layoutParams.width = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_param_item_width);
            layoutParams.height = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_param_item_height);
        }
    }
}
