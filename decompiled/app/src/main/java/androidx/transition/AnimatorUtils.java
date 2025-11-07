package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import java.util.ArrayList;

/* compiled from: AnimatorUtils.java */
/* renamed from: androidx.transition.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
class AnimatorUtils {

    /* compiled from: AnimatorUtils.java */
    /* renamed from: androidx.transition.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    interface PlatformImplementations.kt_3 {
        void onAnimationPause(Animator animator);

        void onAnimationResume(Animator animator);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static void m4714a(Animator animator, AnimatorListenerAdapter animatorListenerAdapter) {
        if (Build.VERSION.SDK_INT >= 19) {
            animator.addPauseListener(animatorListenerAdapter);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static void m4713a(Animator animator) {
        if (Build.VERSION.SDK_INT >= 19) {
            animator.pause();
            return;
        }
        ArrayList<Animator.AnimatorListener> listeners = animator.getListeners();
        if (listeners != null) {
            int size = listeners.size();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                Animator.AnimatorListener animatorListener = listeners.get(OplusGLSurfaceView_13);
                if (animatorListener instanceof PlatformImplementations.kt_3) {
                    ((PlatformImplementations.kt_3) animatorListener).onAnimationPause(animator);
                }
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    static void m4715b(Animator animator) {
        if (Build.VERSION.SDK_INT >= 19) {
            animator.resume();
            return;
        }
        ArrayList<Animator.AnimatorListener> listeners = animator.getListeners();
        if (listeners != null) {
            int size = listeners.size();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                Animator.AnimatorListener animatorListener = listeners.get(OplusGLSurfaceView_13);
                if (animatorListener instanceof PlatformImplementations.kt_3) {
                    ((PlatformImplementations.kt_3) animatorListener).onAnimationResume(animator);
                }
            }
        }
    }
}
