package androidx.transition;

/* compiled from: Fade.java */
/* loaded from: classes.dex */
public class d_renamed extends androidx.transition.ak_renamed {
    public d_renamed(int i_renamed) {
        a_renamed(i_renamed);
    }

    public d_renamed() {
    }

    @Override // androidx.transition.ak_renamed, androidx.transition.m_renamed
    public void captureStartValues(androidx.transition.t_renamed tVar) {
        super.captureStartValues(tVar);
        tVar.f1754a.put("android:fade:transitionAlpha", java.lang.Float.valueOf(androidx.transition.ad_renamed.c_renamed(tVar.f1755b)));
    }

    private android.animation.Animator a_renamed(final android.view.View view, float f_renamed, float f2) {
        if (f_renamed == f2) {
            return null;
        }
        androidx.transition.ad_renamed.a_renamed(view, f_renamed);
        android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(view, androidx.transition.ad_renamed.f1666a, f2);
        objectAnimatorOfFloat.addListener(new androidx.transition.d_renamed.a_renamed(view));
        addListener(new androidx.transition.n_renamed() { // from class: androidx.transition.d_renamed.1
            @Override // androidx.transition.n_renamed, androidx.transition.m_renamed.d_renamed
            public void b_renamed(androidx.transition.m_renamed mVar) {
                androidx.transition.ad_renamed.a_renamed(view, 1.0f);
                androidx.transition.ad_renamed.e_renamed(view);
                mVar.removeListener(this);
            }
        });
        return objectAnimatorOfFloat;
    }

    @Override // androidx.transition.ak_renamed
    public android.animation.Animator a_renamed(android.view.ViewGroup viewGroup, android.view.View view, androidx.transition.t_renamed tVar, androidx.transition.t_renamed tVar2) {
        float fA_renamed = a_renamed(tVar, 0.0f);
        return a_renamed(view, fA_renamed != 1.0f ? fA_renamed : 0.0f, 1.0f);
    }

    @Override // androidx.transition.ak_renamed
    public android.animation.Animator b_renamed(android.view.ViewGroup viewGroup, android.view.View view, androidx.transition.t_renamed tVar, androidx.transition.t_renamed tVar2) {
        androidx.transition.ad_renamed.d_renamed(view);
        return a_renamed(view, a_renamed(tVar, 1.0f), 0.0f);
    }

    private static float a_renamed(androidx.transition.t_renamed tVar, float f_renamed) {
        java.lang.Float f2;
        return (tVar == null || (f2 = (java.lang.Float) tVar.f1754a.get("android:fade:transitionAlpha")) == null) ? f_renamed : f2.floatValue();
    }

    /* compiled from: Fade.java */
    private static class a_renamed extends android.animation.AnimatorListenerAdapter {

        /* renamed from: a_renamed, reason: collision with root package name */
        private final android.view.View f1711a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private boolean f1712b = false;

        a_renamed(android.view.View view) {
            this.f1711a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(android.animation.Animator animator) {
            if (androidx.core.h_renamed.v_renamed.u_renamed(this.f1711a) && this.f1711a.getLayerType() == 0) {
                this.f1712b = true;
                this.f1711a.setLayerType(2, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            androidx.transition.ad_renamed.a_renamed(this.f1711a, 1.0f);
            if (this.f1712b) {
                this.f1711a.setLayerType(0, null);
            }
        }
    }
}
