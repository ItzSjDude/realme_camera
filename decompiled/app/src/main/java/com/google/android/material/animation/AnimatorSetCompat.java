package com.google.android.material.animation;

/* loaded from: classes.dex */
public class AnimatorSetCompat {
    public static void playTogether(android.animation.AnimatorSet animatorSet, java.util.List<android.animation.Animator> list) {
        int size = list.size();
        long jMax = 0;
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            android.animation.Animator animator = list.get(i_renamed);
            jMax = java.lang.Math.max(jMax, animator.getStartDelay() + animator.getDuration());
        }
        android.animation.ValueAnimator valueAnimatorOfInt = android.animation.ValueAnimator.ofInt(0, 0);
        valueAnimatorOfInt.setDuration(jMax);
        list.add(0, valueAnimatorOfInt);
        animatorSet.playTogether(list);
    }
}
