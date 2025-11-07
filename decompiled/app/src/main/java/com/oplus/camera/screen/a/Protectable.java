package com.oplus.camera.screen.a_renamed;

/* compiled from: OutPreviewManager.java */
/* loaded from: classes2.dex */
public class c_renamed {
    private android.os.Handler e_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private com.oplus.camera.screen.out.e_renamed f5346a = null;

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.oplus.camera.screen.a_renamed.c_renamed.b_renamed f5347b = null;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.airbnb.lottie.LottieAnimationView f5348c = null;
    private android.animation.ValueAnimator d_renamed = null;
    private boolean f_renamed = true;
    private boolean g_renamed = false;
    private boolean h_renamed = false;

    /* compiled from: OutPreviewManager.java */
    public interface a_renamed {
        void call();
    }

    /* compiled from: OutPreviewManager.java */
    public interface b_renamed {
        void a_renamed();

        void a_renamed(com.oplus.camera.screen.out.e_renamed eVar);

        boolean a_renamed(int i_renamed, android.view.KeyEvent keyEvent);

        void b_renamed();

        void b_renamed(com.oplus.camera.screen.out.e_renamed eVar);

        boolean b_renamed(int i_renamed, android.view.KeyEvent keyEvent);

        void c_renamed();
    }

    public c_renamed() {
        this.e_renamed = null;
        this.e_renamed = new android.os.Handler();
    }

    public void a_renamed(android.app.Activity activity, com.oplus.camera.screen.a_renamed.c_renamed.b_renamed bVar) {
        com.oplus.camera.e_renamed.b_renamed("OutPreviewManager", "switchOutPresentation");
        this.f5347b = bVar;
        if (this.f5346a != null) {
            a_renamed(false);
        } else if (this.g_renamed) {
            com.oplus.camera.e_renamed.b_renamed("OutPreviewManager", "switchOutPresentation, highTemperature");
            com.oplus.camera.util.o_renamed.c_renamed(com.oplus.camera.MyApplication.d_renamed(), com.oplus.camera.R_renamed.string.camera_high_temperature_out_small_preview_disable);
        } else if (this.f_renamed) {
            com.oplus.camera.e_renamed.b_renamed("OutPreviewManager", "switchOutPresentation, enable");
            com.oplus.camera.screen.a_renamed.c_renamed.b_renamed bVar2 = this.f5347b;
            if (bVar2 != null) {
                bVar2.c_renamed();
            }
            com.oplus.camera.util.e_renamed.a_renamed(-1, true, java.lang.System.currentTimeMillis());
            this.f5346a = new com.oplus.camera.screen.out.e_renamed(activity, ((android.hardware.display.DisplayManager) activity.getSystemService("display")).getDisplay(4096));
            this.f5346a.a_renamed(this.f5347b);
            this.f5346a.a_renamed(this.h_renamed);
            this.f5346a.show();
            if (this.f5347b != null) {
                com.oplus.camera.e_renamed.b_renamed("OutPreviewManager", "switchOutPresentation, onPreviewShow");
                this.f5347b.a_renamed(this.f5346a);
            }
        }
        com.oplus.camera.e_renamed.b_renamed("OutPreviewManager", "switchOutPresentation X_renamed");
    }

    public void a_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.b_renamed("OutPreviewManager", "closeOutPresentation");
        if (this.f5346a != null) {
            if (this.f5347b != null) {
                com.oplus.camera.e_renamed.b_renamed("OutPreviewManager", "closeOutPresentation, onPreviewDismiss");
                this.f5347b.b_renamed(this.f5346a);
            }
            this.f5346a.dismiss();
            this.f5346a = null;
            final long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            if (z_renamed) {
                com.oplus.camera.e_renamed.b_renamed("OutPreviewManager", "closeOutPresentation, requestDeviceFolded ts: " + jCurrentTimeMillis);
                this.e_renamed.postDelayed(new java.lang.Runnable() { // from class: com.oplus.camera.screen.a_renamed.-$$Lambda$c_renamed$Cm6Af0vjVb-VKxbX--kENdyNAZE
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.oplus.camera.util.e_renamed.a_renamed(-1, false, jCurrentTimeMillis);
                    }
                }, 500L);
            } else {
                com.oplus.camera.e_renamed.b_renamed("OutPreviewManager", "closeOutPresentation, requestDeviceFolded");
                com.oplus.camera.util.e_renamed.a_renamed(-1, false, jCurrentTimeMillis);
            }
            if (this.g_renamed) {
                com.oplus.camera.util.o_renamed.c_renamed(com.oplus.camera.MyApplication.d_renamed(), com.oplus.camera.R_renamed.string.camera_high_temperature_out_small_preview_disable);
                if (this.f5347b != null) {
                    com.oplus.camera.e_renamed.b_renamed("OutPreviewManager", "closeOutPresentation, onHighTemperatureDisabled");
                    this.f5347b.b_renamed();
                }
            }
        }
        com.oplus.camera.e_renamed.b_renamed("OutPreviewManager", "closeOutPresentation X_renamed");
    }

    public void a_renamed() {
        a_renamed(true);
    }

    public void b_renamed(boolean z_renamed) {
        this.f_renamed = z_renamed;
        if (this.f_renamed) {
            return;
        }
        a_renamed(false);
    }

    public void a_renamed(int i_renamed) {
        this.g_renamed = i_renamed >= com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_OUT_PREVIEW_DISABLE_TEMPERATURE);
        if (this.g_renamed) {
            a_renamed(false);
        }
    }

    public void c_renamed(boolean z_renamed) {
        this.h_renamed = z_renamed;
        com.oplus.camera.screen.out.e_renamed eVar = this.f5346a;
        if (eVar != null) {
            eVar.a_renamed(z_renamed);
        }
    }

    public boolean b_renamed() {
        return this.f5346a != null;
    }

    public void a_renamed(android.app.Activity activity, android.view.ViewGroup viewGroup) {
        if (this.f5348c == null) {
            this.f5348c = new com.airbnb.lottie.LottieAnimationView(activity);
            this.f5348c.setAnimation(com.oplus.camera.R_renamed.raw.out_preview_guide);
            this.f5348c.a_renamed(new com.oplus.camera.screen.a_renamed.c_renamed.SceneLoader_2());
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(activity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.out_preview_guide_anim_width), activity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.out_preview_guide_anim_height));
            layoutParams.addRule(14);
            layoutParams.topMargin = activity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.out_preview_guide_anim_margin_top);
            viewGroup.addView(this.f5348c, layoutParams);
        }
        this.f5348c.setVisibility(0);
        this.f5348c.setProgress(0.0f);
        a_renamed(this.f5348c, 0, 1, new com.oplus.camera.screen.a_renamed.c_renamed.a_renamed() { // from class: com.oplus.camera.screen.a_renamed.-$$Lambda$c_renamed$ci5aV7K14Bk4rZE3d0tOxljxgVU
            @Override // com.oplus.camera.screen.a_renamed.c_renamed.a_renamed
            public final void call() {
                this.f_renamed$0.d_renamed();
            }
        });
    }

    /* compiled from: OutPreviewManager.java */
    /* renamed from: com.oplus.camera.screen.a_renamed.c_renamed$1, reason: invalid class name */
    class SceneLoader_2 implements android.animation.Animator.AnimatorListener {
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(android.animation.Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(android.animation.Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(android.animation.Animator animator) {
        }

        SceneLoader_2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a_renamed() {
            com.oplus.camera.screen.a_renamed.c_renamed.this.f5348c.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            com.oplus.camera.screen.a_renamed.c_renamed cVar = com.oplus.camera.screen.a_renamed.c_renamed.this;
            cVar.a_renamed(cVar.f5348c, 1, 0, new com.oplus.camera.screen.a_renamed.c_renamed.a_renamed() { // from class: com.oplus.camera.screen.a_renamed.-$$Lambda$c_renamed$1$d_renamed-bpmb5zncn0a7E3oaDGzHV4Am8
                @Override // com.oplus.camera.screen.a_renamed.c_renamed.a_renamed
                public final void call() {
                    this.f_renamed$0.a_renamed();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d_renamed() {
        this.f5348c.a_renamed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(final android.view.View view, int i_renamed, int i2, final com.oplus.camera.screen.a_renamed.c_renamed.a_renamed aVar) {
        this.d_renamed = android.animation.ValueAnimator.ofFloat(i_renamed, i2).setDuration(500L);
        this.d_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.screen.a_renamed.-$$Lambda$c_renamed$8Y_yUgSg7Bud2SYWxOlWBwpqo-o_renamed
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.screen.a_renamed.c_renamed.a_renamed(view, valueAnimator);
            }
        });
        this.d_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.screen.a_renamed.c_renamed.2

            /* renamed from: c_renamed, reason: collision with root package name */
            private boolean f5352c = false;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
                this.f5352c = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                if (this.f5352c) {
                    return;
                }
                aVar.call();
            }
        });
        this.d_renamed.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a_renamed(android.view.View view, android.animation.ValueAnimator valueAnimator) {
        view.setAlpha(((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public void c_renamed() {
        android.animation.ValueAnimator valueAnimator = this.d_renamed;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        com.airbnb.lottie.LottieAnimationView lottieAnimationView = this.f5348c;
        if (lottieAnimationView != null) {
            lottieAnimationView.e_renamed();
            this.f5348c.setVisibility(8);
        }
    }
}
