package com.oplus.camera.screen.out;

/* compiled from: InnerPresentation.java */
/* loaded from: classes2.dex */
public class c_renamed extends android.app.Presentation implements android.view.View.OnClickListener {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.view.View f5387a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.airbnb.lottie.LottieAnimationView f5388b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.widget.Button f5389c;
    private com.oplus.camera.screen.out.c_renamed.a_renamed d_renamed;
    private boolean e_renamed;
    private java.util.Timer f_renamed;

    /* compiled from: InnerPresentation.java */
    public interface a_renamed {
        void onExitButtonClick();
    }

    public c_renamed(android.content.Context context, android.view.Display display) {
        super(context, display);
        this.f5387a = null;
        this.f5388b = null;
        this.f5389c = null;
        this.d_renamed = null;
        this.e_renamed = false;
        this.f_renamed = new java.util.Timer();
    }

    public void a_renamed(com.oplus.camera.screen.out.c_renamed.a_renamed aVar) {
        this.d_renamed = aVar;
    }

    @Override // android.app.Dialog
    protected void onCreate(android.os.Bundle bundle) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.e_renamed.b_renamed("InnerPresentation", "onCreate");
        getWindow().getDecorView().setSystemUiVisibility(5636);
        android.view.WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.layoutInDisplayCutoutMode = 1;
        getWindow().setAttributes(attributes);
        super.onCreate(bundle);
        setContentView(com.oplus.camera.R_renamed.layout.presentation_inner);
        this.f5387a = findViewById(com.oplus.camera.R_renamed.id_renamed.root);
        this.f5388b = (com.airbnb.lottie.LottieAnimationView) findViewById(com.oplus.camera.R_renamed.id_renamed.inner_guide_anim);
        this.f5388b.setAnimation(com.oplus.camera.R_renamed.raw.out_capture_guide2);
        this.f5389c = (android.widget.Button) findViewById(com.oplus.camera.R_renamed.id_renamed.exit_button);
        this.f5389c.setVisibility(this.e_renamed ? 0 : 8);
        this.f5389c.setOnClickListener(this);
        android.view.animation.Animation animationLoadAnimation = android.view.animation.AnimationUtils.loadAnimation(getContext(), com.oplus.camera.R_renamed.anim.out_capture_guide_show);
        animationLoadAnimation.setAnimationListener(new android.view.animation.Animation.AnimationListener() { // from class: com.oplus.camera.screen.out.c_renamed.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(android.view.animation.Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(android.view.animation.Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(android.view.animation.Animation animation) {
                com.oplus.camera.screen.out.c_renamed.this.f5388b.a_renamed();
            }
        });
        this.f5387a.startAnimation(animationLoadAnimation);
        final long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        com.oplus.camera.e_renamed.b_renamed("InnerPresentation", "onCreate, schedule ts: " + jCurrentTimeMillis);
        this.f_renamed.schedule(new java.util.TimerTask() { // from class: com.oplus.camera.screen.out.c_renamed.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() throws android.content.res.Resources.NotFoundException {
                android.view.animation.Animation animationLoadAnimation2 = android.view.animation.AnimationUtils.loadAnimation(com.oplus.camera.screen.out.c_renamed.this.getContext(), com.oplus.camera.R_renamed.anim.out_capture_guide_hide);
                animationLoadAnimation2.setAnimationListener(new android.view.animation.Animation.AnimationListener() { // from class: com.oplus.camera.screen.out.c_renamed.2.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(android.view.animation.Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(android.view.animation.Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(android.view.animation.Animation animation) {
                        if (com.oplus.camera.screen.out.c_renamed.this.isShowing()) {
                            com.oplus.camera.screen.out.c_renamed.this.dismiss();
                            com.oplus.camera.e_renamed.b_renamed("InnerPresentation", "schedule, requestDeviceFolded ts: " + jCurrentTimeMillis);
                            com.oplus.camera.util.e_renamed.a_renamed(0, false, jCurrentTimeMillis);
                        }
                    }
                });
                com.oplus.camera.screen.out.c_renamed.this.f5387a.startAnimation(animationLoadAnimation2);
            }
        }, 10000L);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        com.oplus.camera.screen.out.c_renamed.a_renamed aVar;
        if (view.getId() != com.oplus.camera.R_renamed.id_renamed.exit_button || (aVar = this.d_renamed) == null) {
            return;
        }
        aVar.onExitButtonClick();
    }

    public void a_renamed(boolean z_renamed) {
        this.e_renamed = z_renamed;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.f_renamed.cancel();
        super.dismiss();
    }
}
