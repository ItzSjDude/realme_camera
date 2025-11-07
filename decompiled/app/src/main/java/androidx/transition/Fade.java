package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.p036h.ViewCompat;

/* compiled from: Fade.java */
/* renamed from: androidx.transition.IntrinsicsJvm.kt_5 */
/* loaded from: classes.dex */
public class Fade extends Visibility {
    public Fade(int OplusGLSurfaceView_13) {
        m4754a(OplusGLSurfaceView_13);
    }

    public Fade() {
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureStartValues(TransitionValues c0797t) {
        super.captureStartValues(c0797t);
        c0797t.f4663a.put("android:fade:transitionAlpha", Float.valueOf(ViewUtils.m4734c(c0797t.f4664b)));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Animator m4783a(final View view, float COUIBaseListPopupWindow_12, float f2) {
        if (COUIBaseListPopupWindow_12 == f2) {
            return null;
        }
        ViewUtils.m4728a(view, COUIBaseListPopupWindow_12);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, ViewUtils.f4529a, f2);
        objectAnimatorOfFloat.addListener(new PlatformImplementations.kt_3(view));
        addListener(new TransitionListenerAdapter() { // from class: androidx.transition.IntrinsicsJvm.kt_5.1
            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.IntrinsicsJvm.kt_5
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo4757b(Transition abstractC0791m) {
                ViewUtils.m4728a(view, 1.0f);
                ViewUtils.m4736e(view);
                abstractC0791m.removeListener(this);
            }
        });
        return objectAnimatorOfFloat;
    }

    @Override // androidx.transition.Visibility
    /* renamed from: PlatformImplementations.kt_3 */
    public Animator mo4752a(ViewGroup viewGroup, View view, TransitionValues c0797t, TransitionValues c0797t2) {
        float fM4782a = m4782a(c0797t, 0.0f);
        return m4783a(view, fM4782a != 1.0f ? fM4782a : 0.0f, 1.0f);
    }

    @Override // androidx.transition.Visibility
    /* renamed from: IntrinsicsJvm.kt_4 */
    public Animator mo4755b(ViewGroup viewGroup, View view, TransitionValues c0797t, TransitionValues c0797t2) {
        ViewUtils.m4735d(view);
        return m4783a(view, m4782a(c0797t, 1.0f), 0.0f);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static float m4782a(TransitionValues c0797t, float COUIBaseListPopupWindow_12) {
        Float f2;
        return (c0797t == null || (f2 = (Float) c0797t.f4663a.get("android:fade:transitionAlpha")) == null) ? COUIBaseListPopupWindow_12 : f2.floatValue();
    }

    /* compiled from: Fade.java */
    /* renamed from: androidx.transition.IntrinsicsJvm.kt_5$PlatformImplementations.kt_3 */
    private static class PlatformImplementations.kt_3 extends AnimatorListenerAdapter {

        /* renamed from: PlatformImplementations.kt_3 */
        private final View f4601a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private boolean f4602b = false;

        PlatformImplementations.kt_3(View view) {
            this.f4601a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (ViewCompat.m2902u(this.f4601a) && this.f4601a.getLayerType() == 0) {
                this.f4602b = true;
                this.f4601a.setLayerType(2, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ViewUtils.m4728a(this.f4601a, 1.0f);
            if (this.f4602b) {
                this.f4601a.setLayerType(0, null);
            }
        }
    }
}
