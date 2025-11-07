package com.oplus.camera.professional;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.FloatEvaluator;
import android.animation.IntEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.p078a.p079a.SimpleSpringListener;
import com.p078a.p079a.Spring;
import com.p078a.p079a.SpringConfig;
import com.p078a.p079a.SpringSystem;
import com.p078a.p079a.SpringUtil;

/* compiled from: ProfessionalAnimUtil.java */
/* renamed from: com.oplus.camera.professional.u */
/* loaded from: classes2.dex */
public class ProfessionalAnimUtil {

    /* compiled from: ProfessionalAnimUtil.java */
    /* renamed from: com.oplus.camera.professional.u$PlatformImplementations.kt_3 */
    public static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        public boolean f15706a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public int f15707b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public int f15708c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        public float f15709d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        public float f15710e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        public int f15711f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        public int f15712g;

        /* renamed from: COUIBaseListPopupWindow_10 */
        public String f15713h = "translationY";
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m15927a(ImageView imageView, int OplusGLSurfaceView_13, int i2, int i3, Interpolator interpolator, Animator.AnimatorListener animatorListener) {
        if (imageView == null || i3 < 0) {
            return;
        }
        if (i3 == 0) {
            imageView.setColorFilter(i2);
            return;
        }
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(imageView, "colorFilter", new ArgbEvaluator(), Integer.valueOf(OplusGLSurfaceView_13), Integer.valueOf(i2));
        objectAnimatorOfObject.setDuration(i3);
        objectAnimatorOfObject.setInterpolator(interpolator);
        if (animatorListener != null) {
            objectAnimatorOfObject.addListener(animatorListener);
        }
        objectAnimatorOfObject.start();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m15928a(TextView textView, int OplusGLSurfaceView_13, int i2, int i3, Interpolator interpolator, Animator.AnimatorListener animatorListener) {
        if (textView == null || i3 < 0) {
            return;
        }
        if (i3 == 0) {
            textView.setTextColor(i2);
            return;
        }
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(textView, "textColor", new ArgbEvaluator(), Integer.valueOf(OplusGLSurfaceView_13), Integer.valueOf(i2));
        objectAnimatorOfObject.setDuration(i3);
        objectAnimatorOfObject.setInterpolator(interpolator);
        if (animatorListener != null) {
            objectAnimatorOfObject.addListener(animatorListener);
        }
        objectAnimatorOfObject.start();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m15926a(ImageView imageView, float COUIBaseListPopupWindow_12, float f2, int OplusGLSurfaceView_13, Animator.AnimatorListener animatorListener) {
        if (imageView == null || OplusGLSurfaceView_13 < 0) {
            return;
        }
        if (OplusGLSurfaceView_13 == 0) {
            imageView.setImageAlpha((int) (f2 * 255.0f));
            return;
        }
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(imageView, "imageAlpha", new IntEvaluator(), Integer.valueOf((int) (COUIBaseListPopupWindow_12 * 255.0f)), Integer.valueOf((int) (f2 * 255.0f)));
        objectAnimatorOfObject.setDuration(OplusGLSurfaceView_13);
        objectAnimatorOfObject.setInterpolator(ProfessionalAnimConstant.f15694a);
        if (animatorListener != null) {
            objectAnimatorOfObject.addListener(animatorListener);
        }
        objectAnimatorOfObject.start();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m15925a(final View view, boolean z, int OplusGLSurfaceView_13) {
        if (view == null || view.getBackground() == null) {
            return;
        }
        final float COUIBaseListPopupWindow_12 = z ? 0.0f : 1.0f;
        final float f2 = z ? 1.0f : 0.0f;
        view.animate().cancel();
        view.animate().setInterpolator(ProfessionalAnimConstant.f15694a).setUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.professional.u.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Float f3 = (Float) valueAnimator.getAnimatedValue();
                float f4 = COUIBaseListPopupWindow_12;
                int iFloatValue = (int) ((f4 + ((f2 - f4) * f3.floatValue())) * 255.0f);
                View view2 = view;
                if (view2 == null || view2.getBackground() == null) {
                    return;
                }
                view.getBackground().setAlpha(iFloatValue);
            }
        }).setDuration(OplusGLSurfaceView_13).start();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Spring m15923a() {
        return SpringSystem.m5492c().m5449b().m5472a(SpringConfig.m5490b(5.0d, 10.0d));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m15924a(final View view, Spring c1032f, final boolean z) {
        if (view == null || c1032f == null) {
            return;
        }
        c1032f.m5473a(new SimpleSpringListener() { // from class: com.oplus.camera.professional.u.2
            @Override // com.p078a.p079a.SimpleSpringListener, com.p078a.p079a.SpringListener
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo5464a(Spring c1032f2) {
                float fM5495a = (float) SpringUtil.m5495a(c1032f2.m5478c(), 0.0d, 1.0d, z ? 1.0f : 0.92f, z ? 0.92f : 1.0f);
                view.setScaleX(fM5495a);
                view.setScaleY(fM5495a);
            }
        }).m5470a(0.0d).m5476b(1.0d);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Animator m15922a(final View view, final PlatformImplementations.kt_3 aVar) {
        ObjectAnimator objectAnimatorOfObject;
        ObjectAnimator objectAnimatorOfObject2;
        if (view == null || aVar == null) {
            return null;
        }
        float COUIBaseListPopupWindow_12 = aVar.f15706a ? 0.0f : 1.0f;
        final float f2 = aVar.f15706a ? 1.0f : 0.0f;
        if (aVar.f15708c > 0) {
            objectAnimatorOfObject = ObjectAnimator.ofObject(view, "alpha", new FloatEvaluator(), Float.valueOf(COUIBaseListPopupWindow_12), Float.valueOf(f2));
            objectAnimatorOfObject.setStartDelay(aVar.f15707b);
            objectAnimatorOfObject.setDuration(aVar.f15708c);
            objectAnimatorOfObject.setInterpolator(ProfessionalAnimConstant.f15694a);
            objectAnimatorOfObject.addListener(new Animator.AnimatorListener() { // from class: com.oplus.camera.professional.u.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    view.setVisibility(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    view.setAlpha(f2);
                    view.setVisibility(aVar.f15706a ? 0 : 4);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    view.setAlpha(f2);
                    view.setVisibility(aVar.f15706a ? 0 : 4);
                }
            });
        } else {
            view.setAlpha(f2);
            objectAnimatorOfObject = null;
        }
        if (aVar.f15712g > 0) {
            objectAnimatorOfObject2 = ObjectAnimator.ofObject(view, aVar.f15713h, new FloatEvaluator(), Float.valueOf(aVar.f15709d), Float.valueOf(aVar.f15710e));
            objectAnimatorOfObject2.setStartDelay(aVar.f15711f);
            objectAnimatorOfObject2.setDuration(aVar.f15712g);
            objectAnimatorOfObject2.setInterpolator(ProfessionalAnimConstant.f15695b);
            objectAnimatorOfObject2.addListener(new Animator.AnimatorListener() { // from class: com.oplus.camera.professional.u.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    if ("translationY".equals(aVar.f15713h)) {
                        view.setTranslationY(aVar.f15709d);
                    } else {
                        view.setTranslationX(aVar.f15709d);
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if ("translationY".equals(aVar.f15713h)) {
                        view.setTranslationY(aVar.f15710e);
                    } else {
                        view.setTranslationX(aVar.f15710e);
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    if ("translationY".equals(aVar.f15713h)) {
                        view.setTranslationY(aVar.f15710e);
                    } else {
                        view.setTranslationX(aVar.f15710e);
                    }
                }
            });
        } else {
            if ("translationY".equals(aVar.f15713h)) {
                view.setTranslationY(aVar.f15710e);
            } else {
                view.setTranslationX(aVar.f15710e);
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
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfObject, objectAnimatorOfObject2);
        animatorSet.start();
        return animatorSet;
    }
}
