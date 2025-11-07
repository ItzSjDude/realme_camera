package com.oplus.camera.screen.out;

/* compiled from: ReEntryPresentation.java */
/* loaded from: classes2.dex */
public class f_renamed extends android.app.Presentation implements android.view.View.OnClickListener {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.view.View f5397a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.airbnb.lottie.LottieAnimationView f5398b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.view.View f5399c;
    private com.oplus.camera.screen.out.f_renamed.a_renamed d_renamed;

    /* compiled from: ReEntryPresentation.java */
    public interface a_renamed {
        void onExitButtonClick();
    }

    public f_renamed(android.content.Context context, android.view.Display display) {
        super(context, display);
        this.f5397a = null;
        this.f5398b = null;
        this.f5399c = null;
        this.d_renamed = null;
    }

    public void a_renamed(com.oplus.camera.screen.out.f_renamed.a_renamed aVar) {
        this.d_renamed = aVar;
    }

    @Override // android.app.Dialog
    protected void onCreate(android.os.Bundle bundle) {
        com.oplus.camera.e_renamed.b_renamed("ReEntryPresentation", "onCreate");
        getWindow().getDecorView().setSystemUiVisibility(5636);
        android.view.WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.layoutInDisplayCutoutMode = 1;
        getWindow().setAttributes(attributes);
        super.onCreate(bundle);
        setContentView(com.oplus.camera.R_renamed.layout.presentation_re_entry);
        this.f5397a = findViewById(com.oplus.camera.R_renamed.id_renamed.root);
        this.f5398b = (com.airbnb.lottie.LottieAnimationView) findViewById(com.oplus.camera.R_renamed.id_renamed.guide_anim);
        this.f5398b.setAnimation(com.oplus.camera.R_renamed.raw.out_capture_exit_guide);
        this.f5398b.a_renamed();
        this.f5399c = findViewById(com.oplus.camera.R_renamed.id_renamed.exit_button);
        this.f5399c.setOnClickListener(this);
        final long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        com.oplus.camera.e_renamed.b_renamed("ReEntryPresentation", "onCreate, schedule ts: " + jCurrentTimeMillis);
        new java.util.Timer().schedule(new java.util.TimerTask() { // from class: com.oplus.camera.screen.out.f_renamed.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() throws android.content.res.Resources.NotFoundException {
                android.view.animation.Animation animationLoadAnimation = android.view.animation.AnimationUtils.loadAnimation(com.oplus.camera.screen.out.f_renamed.this.getContext(), com.oplus.camera.R_renamed.anim.out_capture_guide_hide);
                animationLoadAnimation.setAnimationListener(new android.view.animation.Animation.AnimationListener() { // from class: com.oplus.camera.screen.out.f_renamed.1.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(android.view.animation.Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(android.view.animation.Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(android.view.animation.Animation animation) {
                        if (com.oplus.camera.screen.out.f_renamed.this.isShowing()) {
                            com.oplus.camera.screen.out.f_renamed.this.dismiss();
                            com.oplus.camera.e_renamed.b_renamed("ReEntryPresentation", "schedule, requestDeviceFolded ts: " + jCurrentTimeMillis);
                            com.oplus.camera.util.e_renamed.a_renamed(-1, false, jCurrentTimeMillis);
                        }
                    }
                });
                com.oplus.camera.screen.out.f_renamed.this.f5397a.startAnimation(animationLoadAnimation);
            }
        }, 10000L);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        com.oplus.camera.screen.out.f_renamed.a_renamed aVar;
        if (view.getId() != com.oplus.camera.R_renamed.id_renamed.exit_button || (aVar = this.d_renamed) == null) {
            return;
        }
        aVar.onExitButtonClick();
    }
}
