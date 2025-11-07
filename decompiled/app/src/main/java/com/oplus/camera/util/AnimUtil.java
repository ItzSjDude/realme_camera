package com.oplus.camera.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.TextView;
import com.airbnb.lottie.InterfaceC1205k;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.p084c.KeyPath_2;
import com.airbnb.lottie.p092g.LottieFrameInfo;
import com.airbnb.lottie.p092g.SimpleLottieValueCallback;
import com.oplus.camera.R;

/* compiled from: AnimUtil.java */
/* renamed from: com.oplus.camera.util.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class AnimUtil {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final PathInterpolator f23053a = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);

    /* JADX WARN: Removed duplicated region for block: B:18:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0088 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0089  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.animation.Animator m24517a(android.widget.ImageView r10, int r11, int r12) {
        /*
            r0 = 0
            if (r10 != 0) goto L4
            return r0
        L4:
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
            android.view.animation.PathInterpolator r9 = com.oplus.camera.util.AnimUtil.f23053a
            r6 = r11
            android.animation.Animator r2 = m24516a(r4, r5, r6, r7, r9)
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
            android.view.animation.PathInterpolator r9 = com.oplus.camera.util.AnimUtil.f23053a
            r6 = r12
            android.animation.Animator r0 = m24516a(r4, r5, r6, r7, r9)
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
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.util.AnimUtil.m24517a(android.widget.ImageView, int, int):android.animation.Animator");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007c  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.animation.Animator m24518a(android.widget.TextView r10, int r11, int r12) {
        /*
            r0 = 0
            if (r10 != 0) goto L4
            return r0
        L4:
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
            android.view.animation.PathInterpolator r9 = com.oplus.camera.util.AnimUtil.f23053a
            r4 = r10
            r6 = r11
            android.animation.Animator r2 = m24519a(r4, r5, r6, r7, r9)
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
            android.view.animation.PathInterpolator r9 = com.oplus.camera.util.AnimUtil.f23053a
            r6 = r12
            android.animation.Animator r0 = m24516a(r4, r5, r6, r7, r9)
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
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.util.AnimUtil.m24518a(android.widget.TextView, int, int):android.animation.Animator");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Animator m24516a(final Drawable drawable, int OplusGLSurfaceView_13, final int i2, long OplusGLSurfaceView_15, Interpolator interpolator) {
        if (drawable == null) {
            return null;
        }
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(drawable, "tint", new ArgbEvaluator(), Integer.valueOf(OplusGLSurfaceView_13), Integer.valueOf(i2));
        objectAnimatorOfObject.setDuration(OplusGLSurfaceView_15);
        objectAnimatorOfObject.setInterpolator(interpolator);
        objectAnimatorOfObject.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.util.IntrinsicsJvm.kt_4.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                drawable.setTint(i2);
            }
        });
        return objectAnimatorOfObject;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Animator m24519a(final TextView textView, int OplusGLSurfaceView_13, final int i2, long OplusGLSurfaceView_15, Interpolator interpolator) {
        if (textView == null) {
            return null;
        }
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(textView, "textColor", new ArgbEvaluator(), Integer.valueOf(OplusGLSurfaceView_13), Integer.valueOf(i2));
        objectAnimatorOfObject.setDuration(OplusGLSurfaceView_15);
        objectAnimatorOfObject.setInterpolator(interpolator);
        objectAnimatorOfObject.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.util.IntrinsicsJvm.kt_4.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                textView.setTextColor(i2);
            }
        });
        return objectAnimatorOfObject;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24520a(final Context context, LottieAnimationView lottieAnimationView, int OplusGLSurfaceView_13, final Animator.AnimatorListener animatorListener) {
        if (lottieAnimationView == null) {
            return;
        }
        if (OplusGLSurfaceView_13 <= 0) {
            if (animatorListener != null) {
                animatorListener.onAnimationCancel(null);
                return;
            }
            return;
        }
        Integer num = (Integer) lottieAnimationView.getTag(R.id_renamed.lottie_animation_resource);
        if (num != null && num.intValue() == OplusGLSurfaceView_13) {
            if (animatorListener != null) {
                animatorListener.onAnimationCancel(null);
                return;
            }
            return;
        }
        lottieAnimationView.setTag(R.id_renamed.lottie_animation_resource, Integer.valueOf(OplusGLSurfaceView_13));
        lottieAnimationView.setCacheComposition(true);
        lottieAnimationView.setAnimation(OplusGLSurfaceView_13);
        lottieAnimationView.m5510a(new KeyPath_2("OIS yellow", "**"), (KeyPath_2) InterfaceC1205k.f5926E, (SimpleLottieValueCallback<KeyPath_2>) new SimpleLottieValueCallback<ColorFilter>() { // from class: com.oplus.camera.util.IntrinsicsJvm.kt_4.3
            @Override // com.airbnb.lottie.p092g.SimpleLottieValueCallback
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public ColorFilter getValue(LottieFrameInfo<ColorFilter> c1198b) {
                return new PorterDuffColorFilter(Util.m24164A(context), PorterDuff.Mode.SRC_ATOP);
            }
        });
        lottieAnimationView.m5516c();
        lottieAnimationView.m5508a(new Animator.AnimatorListener() { // from class: com.oplus.camera.util.IntrinsicsJvm.kt_4.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Animator.AnimatorListener animatorListener2 = animatorListener;
                if (animatorListener2 != null) {
                    animatorListener2.onAnimationStart(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Animator.AnimatorListener animatorListener2 = animatorListener;
                if (animatorListener2 != null) {
                    animatorListener2.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Animator.AnimatorListener animatorListener2 = animatorListener;
                if (animatorListener2 != null) {
                    animatorListener2.onAnimationCancel(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Animator.AnimatorListener animatorListener2 = animatorListener;
                if (animatorListener2 != null) {
                    animatorListener2.onAnimationRepeat(animator);
                }
            }
        });
        lottieAnimationView.m5507a();
    }
}
