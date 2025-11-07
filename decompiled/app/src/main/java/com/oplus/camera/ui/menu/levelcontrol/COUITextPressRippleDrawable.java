package com.oplus.camera.ui.menu.levelcontrol;

/* compiled from: SwitchFilterMenu.java */
/* loaded from: classes2.dex */
public class r_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private com.oplus.camera.ui.menu.levelcontrol.r_renamed.a_renamed f6544a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.widget.TextView f6545b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.animation.ObjectAnimator f6546c;
    private android.animation.ObjectAnimator d_renamed;
    private android.os.Handler e_renamed;

    /* compiled from: SwitchFilterMenu.java */
    public interface a_renamed {
        void a_renamed(int i_renamed);

        java.lang.String b_renamed(int i_renamed);
    }

    public void a_renamed() {
        com.oplus.camera.e_renamed.a_renamed("SwitchFilterMenu", "cancelAnimator");
        if (this.e_renamed.hasMessages(1)) {
            this.e_renamed.removeMessages(1);
            this.f6545b.setAlpha(0.0f);
        }
        android.animation.ObjectAnimator objectAnimator = this.d_renamed;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.d_renamed.cancel();
            this.f6545b.setAlpha(0.0f);
        }
        android.animation.ObjectAnimator objectAnimator2 = this.f6546c;
        if (objectAnimator2 == null || !objectAnimator2.isRunning()) {
            return;
        }
        this.f6546c.cancel();
    }

    public void b_renamed() {
        com.oplus.camera.e_renamed.a_renamed("SwitchFilterMenu", "slideToPreviousFilter");
        a_renamed(2, (-com.oplus.camera.util.Util.getScreenWidth()) / 2.0f, 0.0f);
    }

    public void c_renamed() {
        com.oplus.camera.e_renamed.a_renamed("SwitchFilterMenu", "slideToNextFilter");
        a_renamed(1, com.oplus.camera.util.Util.getScreenWidth() / 2.0f, 0.0f);
    }

    private void a_renamed(int i_renamed, float f_renamed, float f2) {
        java.lang.String strB;
        com.oplus.camera.e_renamed.a_renamed("SwitchFilterMenu", "switchFilterAnimator, direction: " + i_renamed + ", startTranslationX: " + f_renamed + ", endTranslationX: " + f2);
        a_renamed();
        com.oplus.camera.ui.menu.levelcontrol.r_renamed.a_renamed aVar = this.f6544a;
        if (aVar != null && (strB = aVar.b_renamed(i_renamed)) != null) {
            this.f6545b.setText(strB);
        }
        android.widget.TextView textView = this.f6545b;
        if (textView != null && textView.getVisibility() != 0) {
            this.f6545b.setVisibility(0);
        }
        com.oplus.camera.ui.menu.levelcontrol.r_renamed.a_renamed aVar2 = this.f6544a;
        if (aVar2 != null) {
            aVar2.a_renamed(i_renamed);
        }
        android.widget.TextView textView2 = this.f6545b;
        if (textView2 != null) {
            textView2.setAlpha(1.0f);
        }
        this.f6546c = android.animation.ObjectAnimator.ofFloat(this.f6545b, (android.util.Property<android.widget.TextView, java.lang.Float>) android.view.View.TRANSLATION_X, f_renamed, f2);
        this.f6546c.setDuration(150L);
        this.f6546c.setInterpolator(new android.view.animation.AccelerateDecelerateInterpolator());
        this.f6546c.addListener(new android.animation.Animator.AnimatorListener() { // from class: com.oplus.camera.ui.menu.levelcontrol.r_renamed.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                com.oplus.camera.e_renamed.a_renamed("SwitchFilterMenu", "switchFilterAnimator, onAnimationStart");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.oplus.camera.e_renamed.a_renamed("SwitchFilterMenu", "switchFilterAnimator, onAnimationEnd");
                if (com.oplus.camera.ui.menu.levelcontrol.r_renamed.this.e_renamed != null) {
                    com.oplus.camera.ui.menu.levelcontrol.r_renamed.this.e_renamed.removeMessages(1);
                    com.oplus.camera.ui.menu.levelcontrol.r_renamed.this.e_renamed.sendEmptyMessageDelayed(1, 1000L);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
                com.oplus.camera.e_renamed.a_renamed("SwitchFilterMenu", "switchFilterAnimator, onAnimationCancel");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(android.animation.Animator animator) {
                com.oplus.camera.e_renamed.a_renamed("SwitchFilterMenu", "switchFilterAnimator, onAnimationRepeat");
            }
        });
        this.f6546c.start();
    }
}
