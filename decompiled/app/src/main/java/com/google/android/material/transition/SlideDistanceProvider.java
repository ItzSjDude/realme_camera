package com.google.android.material.transition;

/* loaded from: classes.dex */
public class SlideDistanceProvider implements com.google.android.material.transition.VisibilityAnimatorProvider {
    private static final int DEFAULT_DISTANCE = -1;
    private int slideDistance = -1;
    private int slideEdge;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface GravityFlag {
    }

    public SlideDistanceProvider(int i_renamed) {
        this.slideEdge = i_renamed;
    }

    public int getSlideEdge() {
        return this.slideEdge;
    }

    public void setSlideEdge(int i_renamed) {
        this.slideEdge = i_renamed;
    }

    public int getSlideDistance() {
        return this.slideDistance;
    }

    public void setSlideDistance(int i_renamed) {
        if (i_renamed < 0) {
            throw new java.lang.IllegalArgumentException("Slide distance must be_renamed positive. If attempting to reverse the direction of_renamed the slide, use setSlideEdge(int) instead.");
        }
        this.slideDistance = i_renamed;
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    public android.animation.Animator createAppear(android.view.ViewGroup viewGroup, android.view.View view, android.transition.TransitionValues transitionValues, android.transition.TransitionValues transitionValues2) {
        return createTranslationAppearAnimator(viewGroup, view, this.slideEdge, getSlideDistanceOrDefault(view.getContext()));
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    public android.animation.Animator createDisappear(android.view.ViewGroup viewGroup, android.view.View view, android.transition.TransitionValues transitionValues, android.transition.TransitionValues transitionValues2) {
        return createTranslationDisappearAnimator(viewGroup, view, this.slideEdge, getSlideDistanceOrDefault(view.getContext()));
    }

    private int getSlideDistanceOrDefault(android.content.Context context) {
        int i_renamed = this.slideDistance;
        return i_renamed != -1 ? i_renamed : context.getResources().getDimensionPixelSize(com.google.android.material.R_renamed.dimen.mtrl_transition_shared_axis_slide_distance);
    }

    private static android.animation.Animator createTranslationAppearAnimator(android.view.View view, android.view.View view2, int i_renamed, int i2) {
        if (i_renamed == 3) {
            return createTranslationXAnimator(view2, i2, 0.0f);
        }
        if (i_renamed == 5) {
            return createTranslationXAnimator(view2, -i2, 0.0f);
        }
        if (i_renamed == 48) {
            return createTranslationYAnimator(view2, -i2, 0.0f);
        }
        if (i_renamed == 80) {
            return createTranslationYAnimator(view2, i2, 0.0f);
        }
        if (i_renamed == 8388611) {
            return createTranslationXAnimator(view2, isRtl(view) ? i2 : -i2, 0.0f);
        }
        if (i_renamed == 8388613) {
            return createTranslationXAnimator(view2, isRtl(view) ? -i2 : i2, 0.0f);
        }
        throw new java.lang.IllegalArgumentException("Invalid slide direction: " + i_renamed);
    }

    private static android.animation.Animator createTranslationDisappearAnimator(android.view.View view, android.view.View view2, int i_renamed, int i2) {
        if (i_renamed == 3) {
            return createTranslationXAnimator(view2, 0.0f, -i2);
        }
        if (i_renamed == 5) {
            return createTranslationXAnimator(view2, 0.0f, i2);
        }
        if (i_renamed == 48) {
            return createTranslationYAnimator(view2, 0.0f, i2);
        }
        if (i_renamed == 80) {
            return createTranslationYAnimator(view2, 0.0f, -i2);
        }
        if (i_renamed == 8388611) {
            return createTranslationXAnimator(view2, 0.0f, isRtl(view) ? -i2 : i2);
        }
        if (i_renamed == 8388613) {
            return createTranslationXAnimator(view2, 0.0f, isRtl(view) ? i2 : -i2);
        }
        throw new java.lang.IllegalArgumentException("Invalid slide direction: " + i_renamed);
    }

    private static android.animation.Animator createTranslationXAnimator(android.view.View view, float f_renamed, float f2) {
        return android.animation.ObjectAnimator.ofPropertyValuesHolder(view, android.animation.PropertyValuesHolder.ofFloat((android.util.Property<?, java.lang.Float>) android.view.View.TRANSLATION_X, f_renamed, f2));
    }

    private static android.animation.Animator createTranslationYAnimator(android.view.View view, float f_renamed, float f2) {
        return android.animation.ObjectAnimator.ofPropertyValuesHolder(view, android.animation.PropertyValuesHolder.ofFloat((android.util.Property<?, java.lang.Float>) android.view.View.TRANSLATION_Y, f_renamed, f2));
    }

    private static boolean isRtl(android.view.View view) {
        return androidx.core.h_renamed.v_renamed.g_renamed(view) == 1;
    }
}
