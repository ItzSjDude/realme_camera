package com.oplus.camera.professional;

/* compiled from: ProfessionalAnimUtil.java */
/* loaded from: classes2.dex */
public class u_renamed {

    /* compiled from: ProfessionalAnimUtil.java */
    public static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public boolean f5239a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public int f5240b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public int f5241c;
        public float d_renamed;
        public float e_renamed;
        public int f_renamed;
        public int g_renamed;
        public java.lang.String h_renamed = "translationY";
    }

    public static void a_renamed(android.widget.ImageView imageView, int i_renamed, int i2, int i3, android.view.animation.Interpolator interpolator, android.animation.Animator.AnimatorListener animatorListener) {
        if (imageView == null || i3 < 0) {
            return;
        }
        if (i3 == 0) {
            imageView.setColorFilter(i2);
            return;
        }
        android.animation.ObjectAnimator objectAnimatorOfObject = android.animation.ObjectAnimator.ofObject(imageView, "colorFilter", new android.animation.ArgbEvaluator(), java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(i2));
        objectAnimatorOfObject.setDuration(i3);
        objectAnimatorOfObject.setInterpolator(interpolator);
        if (animatorListener != null) {
            objectAnimatorOfObject.addListener(animatorListener);
        }
        objectAnimatorOfObject.start();
    }

    public static void a_renamed(android.widget.TextView textView, int i_renamed, int i2, int i3, android.view.animation.Interpolator interpolator, android.animation.Animator.AnimatorListener animatorListener) {
        if (textView == null || i3 < 0) {
            return;
        }
        if (i3 == 0) {
            textView.setTextColor(i2);
            return;
        }
        android.animation.ObjectAnimator objectAnimatorOfObject = android.animation.ObjectAnimator.ofObject(textView, "textColor", new android.animation.ArgbEvaluator(), java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(i2));
        objectAnimatorOfObject.setDuration(i3);
        objectAnimatorOfObject.setInterpolator(interpolator);
        if (animatorListener != null) {
            objectAnimatorOfObject.addListener(animatorListener);
        }
        objectAnimatorOfObject.start();
    }

    public static void a_renamed(android.widget.ImageView imageView, float f_renamed, float f2, int i_renamed, android.animation.Animator.AnimatorListener animatorListener) {
        if (imageView == null || i_renamed < 0) {
            return;
        }
        if (i_renamed == 0) {
            imageView.setImageAlpha((int) (f2 * 255.0f));
            return;
        }
        android.animation.ObjectAnimator objectAnimatorOfObject = android.animation.ObjectAnimator.ofObject(imageView, "imageAlpha", new android.animation.IntEvaluator(), java.lang.Integer.valueOf((int) (f_renamed * 255.0f)), java.lang.Integer.valueOf((int) (f2 * 255.0f)));
        objectAnimatorOfObject.setDuration(i_renamed);
        objectAnimatorOfObject.setInterpolator(com.oplus.camera.professional.t_renamed.f5227a);
        if (animatorListener != null) {
            objectAnimatorOfObject.addListener(animatorListener);
        }
        objectAnimatorOfObject.start();
    }

    public static void a_renamed(final android.view.View view, boolean z_renamed, int i_renamed) {
        if (view == null || view.getBackground() == null) {
            return;
        }
        final float f_renamed = z_renamed ? 0.0f : 1.0f;
        final float f2 = z_renamed ? 1.0f : 0.0f;
        view.animate().cancel();
        view.animate().setInterpolator(com.oplus.camera.professional.t_renamed.f5227a).setUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.professional.u_renamed.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                java.lang.Float f3 = (java.lang.Float) valueAnimator.getAnimatedValue();
                float f4 = f_renamed;
                int iFloatValue = (int) ((f4 + ((f2 - f4) * f3.floatValue())) * 255.0f);
                android.view.View view2 = view;
                if (view2 == null || view2.getBackground() == null) {
                    return;
                }
                view.getBackground().setAlpha(iFloatValue);
            }
        }).setDuration(i_renamed).start();
    }

    public static com.a_renamed.a_renamed.f_renamed a_renamed() {
        return com.a_renamed.a_renamed.j_renamed.c_renamed().b_renamed().a_renamed(com.a_renamed.a_renamed.g_renamed.b_renamed(5.0d, 10.0d));
    }

    public static void a_renamed(final android.view.View view, com.a_renamed.a_renamed.f_renamed fVar, final boolean z_renamed) {
        if (view == null || fVar == null) {
            return;
        }
        fVar.a_renamed(new com.a_renamed.a_renamed.e_renamed() { // from class: com.oplus.camera.professional.u_renamed.2
            @Override // com.a_renamed.a_renamed.e_renamed, com.a_renamed.a_renamed.h_renamed
            public void a_renamed(com.a_renamed.a_renamed.f_renamed fVar2) {
                float fA_renamed = (float) com.a_renamed.a_renamed.l_renamed.a_renamed(fVar2.c_renamed(), 0.0d, 1.0d, z_renamed ? 1.0f : 0.92f, z_renamed ? 0.92f : 1.0f);
                view.setScaleX(fA_renamed);
                view.setScaleY(fA_renamed);
            }
        }).a_renamed(0.0d).b_renamed(1.0d);
    }

    public static android.animation.Animator a_renamed(final android.view.View view, final com.oplus.camera.professional.u_renamed.a_renamed aVar) {
        android.animation.ObjectAnimator objectAnimatorOfObject;
        android.animation.ObjectAnimator objectAnimatorOfObject2;
        if (view == null || aVar == null) {
            return null;
        }
        float f_renamed = aVar.f5239a ? 0.0f : 1.0f;
        final float f2 = aVar.f5239a ? 1.0f : 0.0f;
        if (aVar.f5241c > 0) {
            objectAnimatorOfObject = android.animation.ObjectAnimator.ofObject(view, "alpha", new android.animation.FloatEvaluator(), java.lang.Float.valueOf(f_renamed), java.lang.Float.valueOf(f2));
            objectAnimatorOfObject.setStartDelay(aVar.f5240b);
            objectAnimatorOfObject.setDuration(aVar.f5241c);
            objectAnimatorOfObject.setInterpolator(com.oplus.camera.professional.t_renamed.f5227a);
            objectAnimatorOfObject.addListener(new android.animation.Animator.AnimatorListener() { // from class: com.oplus.camera.professional.u_renamed.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(android.animation.Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator) {
                    view.setVisibility(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    view.setAlpha(f2);
                    view.setVisibility(aVar.f5239a ? 0 : 4);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(android.animation.Animator animator) {
                    view.setAlpha(f2);
                    view.setVisibility(aVar.f5239a ? 0 : 4);
                }
            });
        } else {
            view.setAlpha(f2);
            objectAnimatorOfObject = null;
        }
        if (aVar.g_renamed > 0) {
            objectAnimatorOfObject2 = android.animation.ObjectAnimator.ofObject(view, aVar.h_renamed, new android.animation.FloatEvaluator(), java.lang.Float.valueOf(aVar.d_renamed), java.lang.Float.valueOf(aVar.e_renamed));
            objectAnimatorOfObject2.setStartDelay(aVar.f_renamed);
            objectAnimatorOfObject2.setDuration(aVar.g_renamed);
            objectAnimatorOfObject2.setInterpolator(com.oplus.camera.professional.t_renamed.f5228b);
            objectAnimatorOfObject2.addListener(new android.animation.Animator.AnimatorListener() { // from class: com.oplus.camera.professional.u_renamed.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(android.animation.Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator) {
                    if ("translationY".equals(aVar.h_renamed)) {
                        view.setTranslationY(aVar.d_renamed);
                    } else {
                        view.setTranslationX(aVar.d_renamed);
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    if ("translationY".equals(aVar.h_renamed)) {
                        view.setTranslationY(aVar.e_renamed);
                    } else {
                        view.setTranslationX(aVar.e_renamed);
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(android.animation.Animator animator) {
                    if ("translationY".equals(aVar.h_renamed)) {
                        view.setTranslationY(aVar.e_renamed);
                    } else {
                        view.setTranslationX(aVar.e_renamed);
                    }
                }
            });
        } else {
            if ("translationY".equals(aVar.h_renamed)) {
                view.setTranslationY(aVar.e_renamed);
            } else {
                view.setTranslationX(aVar.e_renamed);
            }
            objectAnimatorOfObject2 = null;
        }
        if (objectAnimatorOfObject != null && objectAnimatorOfObject2 == null) {
            objectAnimatorOfObject.start();
            return objectAnimatorOfObject;
        }
        if (objectAnimatorOfObject == null && objectAnimatorOfObject2 != null) {
            objectAnimatorOfObject2.start();
            return objectAnimatorOfObject2;
        }
        if (objectAnimatorOfObject == null && objectAnimatorOfObject2 == null) {
            return null;
        }
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfObject, objectAnimatorOfObject2);
        animatorSet.start();
        return animatorSet;
    }
}
