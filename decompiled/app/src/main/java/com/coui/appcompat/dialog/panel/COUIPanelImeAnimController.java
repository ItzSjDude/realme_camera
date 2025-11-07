package com.coui.appcompat.dialog.panel;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Insets;
import android.os.CancellationSignal;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import android.view.WindowInsetsController;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import java.lang.ref.WeakReference;

/* compiled from: COUIPanelImeAnimController.java */
/* renamed from: com.coui.appcompat.dialog.panel.COUIBaseListPopupWindow_12 */
/* loaded from: classes.dex */
public class COUIPanelImeAnimController {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final Interpolator f6873a = new PathInterpolator(0.0f, 0.0f, 0.15f, 1.0f);

    /* renamed from: IntrinsicsJvm.kt_4 */
    private WindowInsetsAnimationController f6874b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private CancellationSignal f6875c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private PlatformImplementations.kt_3 f6876d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private WeakReference<View> f6877e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f6878f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f6879g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f6880h;

    /* renamed from: OplusGLSurfaceView_13 */
    private WindowInsetsController.OnControllableInsetsChangedListener f6881i = new WindowInsetsController.OnControllableInsetsChangedListener() { // from class: com.coui.appcompat.dialog.panel.COUIBaseListPopupWindow_12.1
        @Override // android.view.WindowInsetsController.OnControllableInsetsChangedListener
        public void onControllableInsetsChanged(WindowInsetsController windowInsetsController, int OplusGLSurfaceView_13) {
            if ((WindowInsets.Type.ime() & OplusGLSurfaceView_13) != 0) {
                if (COUIPanelImeAnimController.this.f6876d == null || COUIPanelImeAnimController.this.f6876d.mo6819a(OplusGLSurfaceView_13)) {
                    windowInsetsController.controlWindowInsetsAnimation(WindowInsets.Type.ime(), -1L, new LinearInterpolator(), COUIPanelImeAnimController.this.f6875c, COUIPanelImeAnimController.this.f6882j);
                }
                windowInsetsController.removeOnControllableInsetsChangedListener(this);
            }
        }
    };

    /* renamed from: OplusGLSurfaceView_15 */
    private WindowInsetsAnimationControlListener f6882j = new WindowInsetsAnimationControlListener() { // from class: com.coui.appcompat.dialog.panel.COUIBaseListPopupWindow_12.2
        @Override // android.view.WindowInsetsAnimationControlListener
        public void onReady(WindowInsetsAnimationController windowInsetsAnimationController, int OplusGLSurfaceView_13) {
            COUIPanelImeAnimController.this.m6869a(windowInsetsAnimationController);
        }

        @Override // android.view.WindowInsetsAnimationControlListener
        public void onFinished(WindowInsetsAnimationController windowInsetsAnimationController) {
            COUIPanelImeAnimController.this.m6875i();
        }

        @Override // android.view.WindowInsetsAnimationControlListener
        public void onCancelled(WindowInsetsAnimationController windowInsetsAnimationController) {
            if (COUIPanelImeAnimController.this.f6876d != null) {
                COUIPanelImeAnimController.this.f6876d.mo6818a(windowInsetsAnimationController, false);
            }
            COUIPanelImeAnimController.this.m6875i();
        }
    };

    /* compiled from: COUIPanelImeAnimController.java */
    /* renamed from: com.coui.appcompat.dialog.panel.COUIBaseListPopupWindow_12$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo6818a(WindowInsetsAnimationController windowInsetsAnimationController, boolean z);

        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo6819a(int OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6878a(View view, PlatformImplementations.kt_3 aVar) {
        if (view != null) {
            this.f6877e = new WeakReference<>(view);
            WindowInsetsController windowInsetsController = view.getWindowInsetsController();
            if (windowInsetsController != null) {
                this.f6875c = new CancellationSignal();
                this.f6876d = aVar;
                windowInsetsController.addOnControllableInsetsChangedListener(this.f6881i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m6869a(WindowInsetsAnimationController windowInsetsAnimationController) {
        WindowInsets rootWindowInsets;
        this.f6879g = true;
        this.f6875c = null;
        this.f6874b = windowInsetsAnimationController;
        WeakReference<View> weakReference = this.f6877e;
        if (weakReference != null && (rootWindowInsets = weakReference.get().getRootWindowInsets()) != null) {
            this.f6878f = rootWindowInsets.isVisible(WindowInsets.Type.ime());
        }
        PlatformImplementations.kt_3 aVar = this.f6876d;
        if (aVar != null) {
            aVar.mo6818a(windowInsetsAnimationController, true);
            this.f6876d = null;
        }
        this.f6877e = null;
        m6876a(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_13 */
    public void m6875i() {
        this.f6879g = false;
        this.f6874b = null;
        this.f6875c = null;
        this.f6878f = false;
        this.f6876d = null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m6880a() {
        return this.f6874b != null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m6882b() {
        return this.f6875c != null;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m6883c() {
        return this.f6880h;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m6884d() {
        return this.f6879g;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m6876a(int OplusGLSurfaceView_13) {
        return m6877a(0, OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m6877a(int OplusGLSurfaceView_13, int i2) {
        if (this.f6874b == null) {
            return 0;
        }
        if (OplusGLSurfaceView_13 == 0) {
            return m6881b(m6886f() - i2);
        }
        return m6881b(m6887g() - i2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m6881b(int OplusGLSurfaceView_13) {
        if (this.f6874b != null) {
            int iM6888h = m6888h();
            int iM6887g = m6887g();
            int i2 = this.f6878f ? iM6887g : iM6888h;
            if ((this.f6878f ? iM6888h : iM6887g) != i2) {
                int iMax = Math.max(iM6888h, Math.min(OplusGLSurfaceView_13, iM6887g));
                int iM6886f = m6886f() - iMax;
                this.f6874b.setInsetsAndAlpha(Insets.of(0, 0, 0, iMax), 1.0f, (iMax - i2) / (r4 - i2));
                return iM6886f;
            }
        }
        return 0;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m6885e() {
        if (this.f6874b != null) {
            int iM6886f = m6886f();
            int iM6887g = m6887g();
            int iM6888h = m6888h();
            if (iM6886f == iM6887g) {
                this.f6874b.finish(true);
                return;
            }
            if (iM6886f == iM6888h) {
                this.f6874b.finish(false);
                return;
            } else if (this.f6874b.getCurrentFraction() >= 0.15f) {
                this.f6874b.finish(!this.f6878f);
                return;
            } else {
                this.f6874b.finish(this.f6878f);
                return;
            }
        }
        CancellationSignal cancellationSignal = this.f6875c;
        if (cancellationSignal != null) {
            cancellationSignal.cancel();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6879a(boolean z) {
        if (this.f6874b != null) {
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(m6886f(), z ? m6887g() : m6888h());
            valueAnimatorOfInt.setInterpolator(f6873a);
            valueAnimatorOfInt.setDuration(300L);
            valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.dialog.panel.COUIBaseListPopupWindow_12.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    COUIPanelImeAnimController.this.m6881b(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
            valueAnimatorOfInt.addListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.dialog.panel.COUIBaseListPopupWindow_12.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    COUIPanelImeAnimController.this.f6880h = true;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    super.onAnimationCancel(animator);
                    COUIPanelImeAnimController.this.f6880h = false;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    COUIPanelImeAnimController.this.f6880h = false;
                    COUIPanelImeAnimController.this.m6885e();
                }
            });
            valueAnimatorOfInt.start();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public int m6886f() {
        WindowInsetsAnimationController windowInsetsAnimationController = this.f6874b;
        if (windowInsetsAnimationController != null) {
            return windowInsetsAnimationController.getCurrentInsets().bottom;
        }
        return 0;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public int m6887g() {
        WindowInsetsAnimationController windowInsetsAnimationController = this.f6874b;
        if (windowInsetsAnimationController != null) {
            return windowInsetsAnimationController.getShownStateInsets().bottom;
        }
        return 0;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public int m6888h() {
        WindowInsetsAnimationController windowInsetsAnimationController = this.f6874b;
        if (windowInsetsAnimationController != null) {
            return windowInsetsAnimationController.getHiddenStateInsets().bottom;
        }
        return 0;
    }
}
