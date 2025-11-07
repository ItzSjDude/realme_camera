package androidx.transition;

/* compiled from: AnimatorUtils.java */
/* loaded from: classes.dex */
class a_renamed {

    /* compiled from: AnimatorUtils.java */
    /* renamed from: androidx.transition.a_renamed$a_renamed, reason: collision with other inner class name */
    interface AnimatorUtils_2 {
        void onAnimationPause(android.animation.Animator animator);

        void onAnimationResume(android.animation.Animator animator);
    }

    static void a_renamed(android.animation.Animator animator, android.animation.AnimatorListenerAdapter animatorListenerAdapter) {
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            animator.addPauseListener(animatorListenerAdapter);
        }
    }

    static void a_renamed(android.animation.Animator animator) {
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            animator.pause();
            return;
        }
        java.util.ArrayList<android.animation.Animator.AnimatorListener> listeners = animator.getListeners();
        if (listeners != null) {
            int size = listeners.size();
            for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                android.animation.Animator.AnimatorListener animatorListener = listeners.get(i_renamed);
                if (animatorListener instanceof androidx.transition.a_renamed.AnimatorUtils_2) {
                    ((androidx.transition.a_renamed.AnimatorUtils_2) animatorListener).onAnimationPause(animator);
                }
            }
        }
    }

    static void b_renamed(android.animation.Animator animator) {
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            animator.resume();
            return;
        }
        java.util.ArrayList<android.animation.Animator.AnimatorListener> listeners = animator.getListeners();
        if (listeners != null) {
            int size = listeners.size();
            for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                android.animation.Animator.AnimatorListener animatorListener = listeners.get(i_renamed);
                if (animatorListener instanceof androidx.transition.a_renamed.AnimatorUtils_2) {
                    ((androidx.transition.a_renamed.AnimatorUtils_2) animatorListener).onAnimationResume(animator);
                }
            }
        }
    }
}
