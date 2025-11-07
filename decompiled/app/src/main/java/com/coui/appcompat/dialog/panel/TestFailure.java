package com.coui.appcompat.dialog.panel;

/* compiled from: COUIPanelImeAnimController.java */
/* loaded from: classes.dex */
public class f_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final android.view.animation.Interpolator f2565a = new android.view.animation.PathInterpolator(0.0f, 0.0f, 0.15f, 1.0f);

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.view.WindowInsetsAnimationController f2566b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.os.CancellationSignal f2567c;
    private com.coui.appcompat.dialog.panel.f_renamed.a_renamed d_renamed;
    private java.lang.ref.WeakReference<android.view.View> e_renamed;
    private boolean f_renamed;
    private boolean g_renamed;
    private boolean h_renamed;
    private android.view.WindowInsetsController.OnControllableInsetsChangedListener i_renamed = new android.view.WindowInsetsController.OnControllableInsetsChangedListener() { // from class: com.coui.appcompat.dialog.panel.f_renamed.1
        @Override // android.view.WindowInsetsController.OnControllableInsetsChangedListener
        public void onControllableInsetsChanged(android.view.WindowInsetsController windowInsetsController, int i_renamed) {
            if ((android.view.WindowInsets.Type.ime() & i_renamed) != 0) {
                if (com.coui.appcompat.dialog.panel.f_renamed.this.d_renamed == null || com.coui.appcompat.dialog.panel.f_renamed.this.d_renamed.a_renamed(i_renamed)) {
                    windowInsetsController.controlWindowInsetsAnimation(android.view.WindowInsets.Type.ime(), -1L, new android.view.animation.LinearInterpolator(), com.coui.appcompat.dialog.panel.f_renamed.this.f2567c, com.coui.appcompat.dialog.panel.f_renamed.this.j_renamed);
                }
                windowInsetsController.removeOnControllableInsetsChangedListener(this);
            }
        }
    };
    private android.view.WindowInsetsAnimationControlListener j_renamed = new android.view.WindowInsetsAnimationControlListener() { // from class: com.coui.appcompat.dialog.panel.f_renamed.2
        @Override // android.view.WindowInsetsAnimationControlListener
        public void onReady(android.view.WindowInsetsAnimationController windowInsetsAnimationController, int i_renamed) {
            com.coui.appcompat.dialog.panel.f_renamed.this.a_renamed(windowInsetsAnimationController);
        }

        @Override // android.view.WindowInsetsAnimationControlListener
        public void onFinished(android.view.WindowInsetsAnimationController windowInsetsAnimationController) {
            com.coui.appcompat.dialog.panel.f_renamed.this.i_renamed();
        }

        @Override // android.view.WindowInsetsAnimationControlListener
        public void onCancelled(android.view.WindowInsetsAnimationController windowInsetsAnimationController) {
            if (com.coui.appcompat.dialog.panel.f_renamed.this.d_renamed != null) {
                com.coui.appcompat.dialog.panel.f_renamed.this.d_renamed.a_renamed(windowInsetsAnimationController, false);
            }
            com.coui.appcompat.dialog.panel.f_renamed.this.i_renamed();
        }
    };

    /* compiled from: COUIPanelImeAnimController.java */
    public interface a_renamed {
        void a_renamed(android.view.WindowInsetsAnimationController windowInsetsAnimationController, boolean z_renamed);

        boolean a_renamed(int i_renamed);
    }

    public void a_renamed(android.view.View view, com.coui.appcompat.dialog.panel.f_renamed.a_renamed aVar) {
        if (view != null) {
            this.e_renamed = new java.lang.ref.WeakReference<>(view);
            android.view.WindowInsetsController windowInsetsController = view.getWindowInsetsController();
            if (windowInsetsController != null) {
                this.f2567c = new android.os.CancellationSignal();
                this.d_renamed = aVar;
                windowInsetsController.addOnControllableInsetsChangedListener(this.i_renamed);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(android.view.WindowInsetsAnimationController windowInsetsAnimationController) {
        android.view.WindowInsets rootWindowInsets;
        this.g_renamed = true;
        this.f2567c = null;
        this.f2566b = windowInsetsAnimationController;
        java.lang.ref.WeakReference<android.view.View> weakReference = this.e_renamed;
        if (weakReference != null && (rootWindowInsets = weakReference.get().getRootWindowInsets()) != null) {
            this.f_renamed = rootWindowInsets.isVisible(android.view.WindowInsets.Type.ime());
        }
        com.coui.appcompat.dialog.panel.f_renamed.a_renamed aVar = this.d_renamed;
        if (aVar != null) {
            aVar.a_renamed(windowInsetsAnimationController, true);
            this.d_renamed = null;
        }
        this.e_renamed = null;
        a_renamed(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i_renamed() {
        this.g_renamed = false;
        this.f2566b = null;
        this.f2567c = null;
        this.f_renamed = false;
        this.d_renamed = null;
    }

    public boolean a_renamed() {
        return this.f2566b != null;
    }

    public boolean b_renamed() {
        return this.f2567c != null;
    }

    public boolean c_renamed() {
        return this.h_renamed;
    }

    public boolean d_renamed() {
        return this.g_renamed;
    }

    public int a_renamed(int i_renamed) {
        return a_renamed(0, i_renamed);
    }

    public int a_renamed(int i_renamed, int i2) {
        if (this.f2566b == null) {
            return 0;
        }
        if (i_renamed == 0) {
            return b_renamed(f_renamed() - i2);
        }
        return b_renamed(g_renamed() - i2);
    }

    public int b_renamed(int i_renamed) {
        if (this.f2566b != null) {
            int iH = h_renamed();
            int iG = g_renamed();
            int i2 = this.f_renamed ? iG : iH;
            if ((this.f_renamed ? iH : iG) != i2) {
                int iMax = java.lang.Math.max(iH, java.lang.Math.min(i_renamed, iG));
                int iF = f_renamed() - iMax;
                this.f2566b.setInsetsAndAlpha(android.graphics.Insets.of_renamed(0, 0, 0, iMax), 1.0f, (iMax - i2) / (r4 - i2));
                return iF;
            }
        }
        return 0;
    }

    public void e_renamed() {
        if (this.f2566b != null) {
            int iF = f_renamed();
            int iG = g_renamed();
            int iH = h_renamed();
            if (iF == iG) {
                this.f2566b.finish(true);
                return;
            }
            if (iF == iH) {
                this.f2566b.finish(false);
                return;
            } else if (this.f2566b.getCurrentFraction() >= 0.15f) {
                this.f2566b.finish(!this.f_renamed);
                return;
            } else {
                this.f2566b.finish(this.f_renamed);
                return;
            }
        }
        android.os.CancellationSignal cancellationSignal = this.f2567c;
        if (cancellationSignal != null) {
            cancellationSignal.cancel();
        }
    }

    public void a_renamed(boolean z_renamed) {
        if (this.f2566b != null) {
            android.animation.ValueAnimator valueAnimatorOfInt = android.animation.ValueAnimator.ofInt(f_renamed(), z_renamed ? g_renamed() : h_renamed());
            valueAnimatorOfInt.setInterpolator(f2565a);
            valueAnimatorOfInt.setDuration(300L);
            valueAnimatorOfInt.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.dialog.panel.f_renamed.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    com.coui.appcompat.dialog.panel.f_renamed.this.b_renamed(((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
            valueAnimatorOfInt.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.coui.appcompat.dialog.panel.f_renamed.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator) {
                    super.onAnimationStart(animator);
                    com.coui.appcompat.dialog.panel.f_renamed.this.h_renamed = true;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(android.animation.Animator animator) {
                    super.onAnimationCancel(animator);
                    com.coui.appcompat.dialog.panel.f_renamed.this.h_renamed = false;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    com.coui.appcompat.dialog.panel.f_renamed.this.h_renamed = false;
                    com.coui.appcompat.dialog.panel.f_renamed.this.e_renamed();
                }
            });
            valueAnimatorOfInt.start();
        }
    }

    public int f_renamed() {
        android.view.WindowInsetsAnimationController windowInsetsAnimationController = this.f2566b;
        if (windowInsetsAnimationController != null) {
            return windowInsetsAnimationController.getCurrentInsets().bottom;
        }
        return 0;
    }

    public int g_renamed() {
        android.view.WindowInsetsAnimationController windowInsetsAnimationController = this.f2566b;
        if (windowInsetsAnimationController != null) {
            return windowInsetsAnimationController.getShownStateInsets().bottom;
        }
        return 0;
    }

    public int h_renamed() {
        android.view.WindowInsetsAnimationController windowInsetsAnimationController = this.f2566b;
        if (windowInsetsAnimationController != null) {
            return windowInsetsAnimationController.getHiddenStateInsets().bottom;
        }
        return 0;
    }
}
