package androidx.core.p036h;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* compiled from: ViewPropertyAnimatorCompat.java */
/* renamed from: androidx.core.COUIBaseListPopupWindow_10.z */
/* loaded from: classes.dex */
public final class ViewPropertyAnimatorCompat {

    /* renamed from: PlatformImplementations.kt_3 */
    Runnable f3096a = null;

    /* renamed from: IntrinsicsJvm.kt_4 */
    Runnable f3097b = null;

    /* renamed from: IntrinsicsJvm.kt_3 */
    int f3098c = -1;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private WeakReference<View> f3099d;

    ViewPropertyAnimatorCompat(View view) {
        this.f3099d = new WeakReference<>(view);
    }

    /* compiled from: ViewPropertyAnimatorCompat.java */
    /* renamed from: androidx.core.COUIBaseListPopupWindow_10.z$PlatformImplementations.kt_3 */
    static class PlatformImplementations.kt_3 implements ViewPropertyAnimatorListener {

        /* renamed from: PlatformImplementations.kt_3 */
        ViewPropertyAnimatorCompat f3106a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        boolean f3107b;

        PlatformImplementations.kt_3(ViewPropertyAnimatorCompat c0517z) {
            this.f3106a = c0517z;
        }

        @Override // androidx.core.p036h.ViewPropertyAnimatorListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo852a(View view) {
            this.f3107b = false;
            if (this.f3106a.f3098c > -1) {
                view.setLayerType(2, null);
            }
            if (this.f3106a.f3096a != null) {
                Runnable runnable = this.f3106a.f3096a;
                this.f3106a.f3096a = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            ViewPropertyAnimatorListener interfaceC0487aa = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
            if (interfaceC0487aa != null) {
                interfaceC0487aa.mo852a(view);
            }
        }

        @Override // androidx.core.p036h.ViewPropertyAnimatorListener
        @SuppressLint({"WrongConstant"})
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo853b(View view) {
            if (this.f3106a.f3098c > -1) {
                view.setLayerType(this.f3106a.f3098c, null);
                this.f3106a.f3098c = -1;
            }
            if (Build.VERSION.SDK_INT >= 16 || !this.f3107b) {
                if (this.f3106a.f3097b != null) {
                    Runnable runnable = this.f3106a.f3097b;
                    this.f3106a.f3097b = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                ViewPropertyAnimatorListener interfaceC0487aa = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
                if (interfaceC0487aa != null) {
                    interfaceC0487aa.mo853b(view);
                }
                this.f3107b = true;
            }
        }

        @Override // androidx.core.p036h.ViewPropertyAnimatorListener
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo1393c(View view) {
            Object tag = view.getTag(2113929216);
            ViewPropertyAnimatorListener interfaceC0487aa = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
            if (interfaceC0487aa != null) {
                interfaceC0487aa.mo1393c(view);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public ViewPropertyAnimatorCompat m2947a(long OplusGLSurfaceView_15) {
        View view = this.f3099d.get();
        if (view != null) {
            view.animate().setDuration(OplusGLSurfaceView_15);
        }
        return this;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public ViewPropertyAnimatorCompat m2946a(float COUIBaseListPopupWindow_12) {
        View view = this.f3099d.get();
        if (view != null) {
            view.animate().alpha(COUIBaseListPopupWindow_12);
        }
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public ViewPropertyAnimatorCompat m2951b(float COUIBaseListPopupWindow_12) {
        View view = this.f3099d.get();
        if (view != null) {
            view.animate().translationY(COUIBaseListPopupWindow_12);
        }
        return this;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public long m2945a() {
        View view = this.f3099d.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public ViewPropertyAnimatorCompat m2948a(Interpolator interpolator) {
        View view = this.f3099d.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public ViewPropertyAnimatorCompat m2952b(long OplusGLSurfaceView_15) {
        View view = this.f3099d.get();
        if (view != null) {
            view.animate().setStartDelay(OplusGLSurfaceView_15);
        }
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public ViewPropertyAnimatorCompat m2954c(float COUIBaseListPopupWindow_12) {
        View view = this.f3099d.get();
        if (view != null) {
            view.animate().rotation(COUIBaseListPopupWindow_12);
        }
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m2953b() {
        View view = this.f3099d.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m2955c() {
        View view = this.f3099d.get();
        if (view != null) {
            view.animate().start();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public ViewPropertyAnimatorCompat m2949a(ViewPropertyAnimatorListener interfaceC0487aa) {
        View view = this.f3099d.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                m2944a(view, interfaceC0487aa);
            } else {
                view.setTag(2113929216, interfaceC0487aa);
                m2944a(view, new PlatformImplementations.kt_3(this));
            }
        }
        return this;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m2944a(final View view, final ViewPropertyAnimatorListener interfaceC0487aa) {
        if (interfaceC0487aa != null) {
            view.animate().setListener(new AnimatorListenerAdapter() { // from class: androidx.core.COUIBaseListPopupWindow_10.z.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    interfaceC0487aa.mo1393c(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    interfaceC0487aa.mo853b(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    interfaceC0487aa.mo852a(view);
                }
            });
        } else {
            view.animate().setListener(null);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public ViewPropertyAnimatorCompat m2950a(final ViewPropertyAnimatorUpdateListener interfaceC0489ac) {
        final View view = this.f3099d.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            view.animate().setUpdateListener(interfaceC0489ac != null ? new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.core.COUIBaseListPopupWindow_10.z.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    interfaceC0489ac.mo964a(view);
                }
            } : null);
        }
        return this;
    }
}
