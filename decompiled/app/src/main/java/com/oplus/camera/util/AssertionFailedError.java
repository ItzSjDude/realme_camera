package com.oplus.camera.util;

/* compiled from: AnimUtil.java */
/* loaded from: classes2.dex */
public class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final android.view.animation.PathInterpolator f7321a = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);

    /* JADX WARN: Removed duplicated region for block: B_renamed:18:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:21:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:27:0x0088 A_renamed[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:28:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.animation.Animator a_renamed(android.widget.ImageView r10, int r11, int r12) {
        /*
            r0 = 0
            if (r10 != 0) goto L4_renamed
            return r0
        L4_renamed:
            r1 = 2131296655(0x7f09018f, float:1.8211233E38)
            java.lang.Object r2 = r10.getTag(r1)
            java.lang.Integer r2 = (java.lang.Integer) r2
            if (r2 != 0) goto L24
            android.graphics.drawable.Drawable r2 = r10.getDrawable()
            if (r2 == 0) goto L45
            android.graphics.drawable.Drawable r2 = r10.getDrawable()
            r2.setTint(r11)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r10.setTag(r1, r11)
            goto L45
        L24:
            int r3 = r2.intValue()
            if (r3 == r11) goto L45
            android.graphics.drawable.Drawable r4 = r10.getDrawable()
            int r5 = r2.intValue()
            r7 = 250(0xfa, double:1.235E-321)
            android.view.animation.PathInterpolator r9 = com.oplus.camera.util.b_renamed.f7321a
            r6 = r11
            android.animation.Animator r2 = a_renamed(r4, r5, r6, r7, r9)
            if (r2 == 0) goto L46
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r10.setTag(r1, r11)
            goto L46
        L45:
            r2 = r0
        L46:
            r11 = 2131296357(0x7f090065, float:1.8210628E38)
            java.lang.Object r1 = r10.getTag(r11)
            java.lang.Integer r1 = (java.lang.Integer) r1
            if (r1 != 0) goto L66
            android.graphics.drawable.Drawable r1 = r10.getBackground()
            if (r1 == 0) goto L86
            android.graphics.drawable.Drawable r1 = r10.getBackground()
            r1.setTint(r12)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r10.setTag(r11, r12)
            goto L86
        L66:
            int r3 = r1.intValue()
            if (r3 == r12) goto L86
            android.graphics.drawable.Drawable r4 = r10.getBackground()
            int r5 = r1.intValue()
            r7 = 250(0xfa, double:1.235E-321)
            android.view.animation.PathInterpolator r9 = com.oplus.camera.util.b_renamed.f7321a
            r6 = r12
            android.animation.Animator r0 = a_renamed(r4, r5, r6, r7, r9)
            if (r0 == 0) goto L86
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r10.setTag(r11, r12)
        L86:
            if (r2 != 0) goto L89
            return r0
        L89:
            if (r0 != 0) goto L8c
            return r2
        L8c:
            android.animation.AnimatorSet r10 = new android.animation.AnimatorSet
            r10.<init>()
            r11 = 2
            android.animation.Animator[] r11 = new android.animation.Animator[r11]
            r12 = 0
            r11[r12] = r2
            r12 = 1
            r11[r12] = r0
            r10.playTogether(r11)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.util.b_renamed.a_renamed(android.widget.ImageView, int, int):android.animation.Animator");
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:16:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:19:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:25:0x007b A_renamed[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:26:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.animation.Animator a_renamed(android.widget.TextView r10, int r11, int r12) {
        /*
            r0 = 0
            if (r10 != 0) goto L4_renamed
            return r0
        L4_renamed:
            r1 = 2131296655(0x7f09018f, float:1.8211233E38)
            java.lang.Object r2 = r10.getTag(r1)
            java.lang.Integer r2 = (java.lang.Integer) r2
            if (r2 != 0) goto L1a
            r10.setTextColor(r11)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r10.setTag(r1, r11)
            goto L38
        L1a:
            int r3 = r2.intValue()
            if (r3 == r11) goto L38
            int r5 = r2.intValue()
            r7 = 250(0xfa, double:1.235E-321)
            android.view.animation.PathInterpolator r9 = com.oplus.camera.util.b_renamed.f7321a
            r4 = r10
            r6 = r11
            android.animation.Animator r2 = a_renamed(r4, r5, r6, r7, r9)
            if (r2 == 0) goto L39
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r10.setTag(r1, r11)
            goto L39
        L38:
            r2 = r0
        L39:
            r11 = 2131296357(0x7f090065, float:1.8210628E38)
            java.lang.Object r1 = r10.getTag(r11)
            java.lang.Integer r1 = (java.lang.Integer) r1
            if (r1 != 0) goto L59
            android.graphics.drawable.Drawable r1 = r10.getBackground()
            if (r1 == 0) goto L79
            android.graphics.drawable.Drawable r1 = r10.getBackground()
            r1.setTint(r12)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r10.setTag(r11, r12)
            goto L79
        L59:
            int r3 = r1.intValue()
            if (r3 == r12) goto L79
            android.graphics.drawable.Drawable r4 = r10.getBackground()
            int r5 = r1.intValue()
            r7 = 250(0xfa, double:1.235E-321)
            android.view.animation.PathInterpolator r9 = com.oplus.camera.util.b_renamed.f7321a
            r6 = r12
            android.animation.Animator r0 = a_renamed(r4, r5, r6, r7, r9)
            if (r0 == 0) goto L79
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r10.setTag(r11, r12)
        L79:
            if (r2 != 0) goto L7c
            return r0
        L7c:
            if (r0 != 0) goto L7f
            return r2
        L7f:
            android.animation.AnimatorSet r10 = new android.animation.AnimatorSet
            r10.<init>()
            r11 = 2
            android.animation.Animator[] r11 = new android.animation.Animator[r11]
            r12 = 0
            r11[r12] = r2
            r12 = 1
            r11[r12] = r0
            r10.playTogether(r11)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.util.b_renamed.a_renamed(android.widget.TextView, int, int):android.animation.Animator");
    }

    public static android.animation.Animator a_renamed(final android.graphics.drawable.Drawable drawable, int i_renamed, final int i2, long j_renamed, android.view.animation.Interpolator interpolator) {
        if (drawable == null) {
            return null;
        }
        android.animation.ObjectAnimator objectAnimatorOfObject = android.animation.ObjectAnimator.ofObject(drawable, "tint", new android.animation.ArgbEvaluator(), java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(i2));
        objectAnimatorOfObject.setDuration(j_renamed);
        objectAnimatorOfObject.setInterpolator(interpolator);
        objectAnimatorOfObject.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.util.b_renamed.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                drawable.setTint(i2);
            }
        });
        return objectAnimatorOfObject;
    }

    public static android.animation.Animator a_renamed(final android.widget.TextView textView, int i_renamed, final int i2, long j_renamed, android.view.animation.Interpolator interpolator) {
        if (textView == null) {
            return null;
        }
        android.animation.ObjectAnimator objectAnimatorOfObject = android.animation.ObjectAnimator.ofObject(textView, "textColor", new android.animation.ArgbEvaluator(), java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(i2));
        objectAnimatorOfObject.setDuration(j_renamed);
        objectAnimatorOfObject.setInterpolator(interpolator);
        objectAnimatorOfObject.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.util.b_renamed.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                textView.setTextColor(i2);
            }
        });
        return objectAnimatorOfObject;
    }

    public static void a_renamed(final android.content.Context context, com.airbnb.lottie.LottieAnimationView lottieAnimationView, int i_renamed, final android.animation.Animator.AnimatorListener animatorListener) {
        if (lottieAnimationView == null) {
            return;
        }
        if (i_renamed <= 0) {
            if (animatorListener != null) {
                animatorListener.onAnimationCancel(null);
                return;
            }
            return;
        }
        java.lang.Integer num = (java.lang.Integer) lottieAnimationView.getTag(com.oplus.camera.R_renamed.id_renamed.lottie_animation_resource);
        if (num != null && num.intValue() == i_renamed) {
            if (animatorListener != null) {
                animatorListener.onAnimationCancel(null);
                return;
            }
            return;
        }
        lottieAnimationView.setTag(com.oplus.camera.R_renamed.id_renamed.lottie_animation_resource, java.lang.Integer.valueOf(i_renamed));
        lottieAnimationView.setCacheComposition(true);
        lottieAnimationView.setAnimation(i_renamed);
        lottieAnimationView.a_renamed(new com.airbnb.lottie.c_renamed.e_renamed("OIS yellow", "**"), (com.airbnb.lottie.c_renamed.e_renamed) com.airbnb.lottie.k_renamed.E_renamed, (com.airbnb.lottie.g_renamed.e_renamed<com.airbnb.lottie.c_renamed.e_renamed>) new com.airbnb.lottie.g_renamed.e_renamed<android.graphics.ColorFilter>() { // from class: com.oplus.camera.util.b_renamed.3
            @Override // com.airbnb.lottie.g_renamed.e_renamed
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public android.graphics.ColorFilter getValue(com.airbnb.lottie.g_renamed.b_renamed<android.graphics.ColorFilter> bVar) {
                return new android.graphics.PorterDuffColorFilter(com.oplus.camera.util.Util.A_renamed(context), android.graphics.PorterDuff.Mode.SRC_ATOP);
            }
        });
        lottieAnimationView.c_renamed();
        lottieAnimationView.a_renamed(new android.animation.Animator.AnimatorListener() { // from class: com.oplus.camera.util.b_renamed.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                android.animation.Animator.AnimatorListener animatorListener2 = animatorListener;
                if (animatorListener2 != null) {
                    animatorListener2.onAnimationStart(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                android.animation.Animator.AnimatorListener animatorListener2 = animatorListener;
                if (animatorListener2 != null) {
                    animatorListener2.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
                android.animation.Animator.AnimatorListener animatorListener2 = animatorListener;
                if (animatorListener2 != null) {
                    animatorListener2.onAnimationCancel(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(android.animation.Animator animator) {
                android.animation.Animator.AnimatorListener animatorListener2 = animatorListener;
                if (animatorListener2 != null) {
                    animatorListener2.onAnimationRepeat(animator);
                }
            }
        });
        lottieAnimationView.a_renamed();
    }
}
