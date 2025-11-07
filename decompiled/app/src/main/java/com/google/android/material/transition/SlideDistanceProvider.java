package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.transition.TransitionValues;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.p036h.ViewCompat;
import com.google.android.material.C1694R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public class SlideDistanceProvider implements VisibilityAnimatorProvider {
    private static final int DEFAULT_DISTANCE = -1;
    private int slideDistance = -1;
    private int slideEdge;

    @Retention(RetentionPolicy.SOURCE)
    public @interface GravityFlag {
    }

    public SlideDistanceProvider(int OplusGLSurfaceView_13) {
        this.slideEdge = OplusGLSurfaceView_13;
    }

    public int getSlideEdge() {
        return this.slideEdge;
    }

    public void setSlideEdge(int OplusGLSurfaceView_13) {
        this.slideEdge = OplusGLSurfaceView_13;
    }

    public int getSlideDistance() {
        return this.slideDistance;
    }

    public void setSlideDistance(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0) {
            throw new IllegalArgumentException("Slide distance must be positive. If attempting to reverse the direction of the slide, use setSlideEdge(int) instead.");
        }
        this.slideDistance = OplusGLSurfaceView_13;
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    public Animator createAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return createTranslationAppearAnimator(viewGroup, view, this.slideEdge, getSlideDistanceOrDefault(view.getContext()));
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    public Animator createDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return createTranslationDisappearAnimator(viewGroup, view, this.slideEdge, getSlideDistanceOrDefault(view.getContext()));
    }

    private int getSlideDistanceOrDefault(Context context) {
        int OplusGLSurfaceView_13 = this.slideDistance;
        return OplusGLSurfaceView_13 != -1 ? OplusGLSurfaceView_13 : context.getResources().getDimensionPixelSize(C1694R.dimen.mtrl_transition_shared_axis_slide_distance);
    }

    private static Animator createTranslationAppearAnimator(View view, View view2, int OplusGLSurfaceView_13, int i2) {
        if (OplusGLSurfaceView_13 == 3) {
            return createTranslationXAnimator(view2, i2, 0.0f);
        }
        if (OplusGLSurfaceView_13 == 5) {
            return createTranslationXAnimator(view2, -i2, 0.0f);
        }
        if (OplusGLSurfaceView_13 == 48) {
            return createTranslationYAnimator(view2, -i2, 0.0f);
        }
        if (OplusGLSurfaceView_13 == 80) {
            return createTranslationYAnimator(view2, i2, 0.0f);
        }
        if (OplusGLSurfaceView_13 == 8388611) {
            return createTranslationXAnimator(view2, isRtl(view) ? i2 : -i2, 0.0f);
        }
        if (OplusGLSurfaceView_13 == 8388613) {
            return createTranslationXAnimator(view2, isRtl(view) ? -i2 : i2, 0.0f);
        }
        throw new IllegalArgumentException("Invalid slide direction: " + OplusGLSurfaceView_13);
    }

    private static Animator createTranslationDisappearAnimator(View view, View view2, int OplusGLSurfaceView_13, int i2) {
        if (OplusGLSurfaceView_13 == 3) {
            return createTranslationXAnimator(view2, 0.0f, -i2);
        }
        if (OplusGLSurfaceView_13 == 5) {
            return createTranslationXAnimator(view2, 0.0f, i2);
        }
        if (OplusGLSurfaceView_13 == 48) {
            return createTranslationYAnimator(view2, 0.0f, i2);
        }
        if (OplusGLSurfaceView_13 == 80) {
            return createTranslationYAnimator(view2, 0.0f, -i2);
        }
        if (OplusGLSurfaceView_13 == 8388611) {
            return createTranslationXAnimator(view2, 0.0f, isRtl(view) ? -i2 : i2);
        }
        if (OplusGLSurfaceView_13 == 8388613) {
            return createTranslationXAnimator(view2, 0.0f, isRtl(view) ? i2 : -i2);
        }
        throw new IllegalArgumentException("Invalid slide direction: " + OplusGLSurfaceView_13);
    }

    private static Animator createTranslationXAnimator(View view, float COUIBaseListPopupWindow_12, float f2) {
        return ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_X, COUIBaseListPopupWindow_12, f2));
    }

    private static Animator createTranslationYAnimator(View view, float COUIBaseListPopupWindow_12, float f2) {
        return ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_Y, COUIBaseListPopupWindow_12, f2));
    }

    private static boolean isRtl(View view) {
        return ViewCompat.m2885g(view) == 1;
    }
}
