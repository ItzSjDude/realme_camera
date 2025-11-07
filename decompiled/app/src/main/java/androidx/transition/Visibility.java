package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import androidx.transition.AnimatorUtils;
import java.lang.reflect.InvocationTargetException;

/* compiled from: Visibility.java */
/* renamed from: androidx.transition.ak */
/* loaded from: classes.dex */
public abstract class Visibility extends Transition {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String[] f4542a = {"android:visibility:visibility", "android:visibility:parent"};

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f4543b = 3;

    /* renamed from: PlatformImplementations.kt_3 */
    public Animator mo4752a(ViewGroup viewGroup, View view, TransitionValues c0797t, TransitionValues c0797t2) {
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public Animator mo4755b(ViewGroup viewGroup, View view, TransitionValues c0797t, TransitionValues c0797t2) {
        return null;
    }

    /* compiled from: Visibility.java */
    /* renamed from: androidx.transition.ak$IntrinsicsJvm.kt_4 */
    private static class IntrinsicsJvm.kt_4 {

        /* renamed from: PlatformImplementations.kt_3 */
        boolean f4554a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        boolean f4555b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        int f4556c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        int f4557d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        ViewGroup f4558e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        ViewGroup f4559f;

        IntrinsicsJvm.kt_4() {
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m4754a(int OplusGLSurfaceView_13) {
        if ((OplusGLSurfaceView_13 & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.f4543b = OplusGLSurfaceView_13;
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return f4542a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m4751a(TransitionValues c0797t) {
        c0797t.f4663a.put("android:visibility:visibility", Integer.valueOf(c0797t.f4664b.getVisibility()));
        c0797t.f4663a.put("android:visibility:parent", c0797t.f4664b.getParent());
        int[] iArr = new int[2];
        c0797t.f4664b.getLocationOnScreen(iArr);
        c0797t.f4663a.put("android:visibility:screenLocation", iArr);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(TransitionValues c0797t) {
        m4751a(c0797t);
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(TransitionValues c0797t) {
        m4751a(c0797t);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private IntrinsicsJvm.kt_4 m4750a(TransitionValues c0797t, TransitionValues c0797t2) {
        IntrinsicsJvm.kt_4 bVar = new IntrinsicsJvm.kt_4();
        bVar.f4554a = false;
        bVar.f4555b = false;
        if (c0797t != null && c0797t.f4663a.containsKey("android:visibility:visibility")) {
            bVar.f4556c = ((Integer) c0797t.f4663a.get("android:visibility:visibility")).intValue();
            bVar.f4558e = (ViewGroup) c0797t.f4663a.get("android:visibility:parent");
        } else {
            bVar.f4556c = -1;
            bVar.f4558e = null;
        }
        if (c0797t2 != null && c0797t2.f4663a.containsKey("android:visibility:visibility")) {
            bVar.f4557d = ((Integer) c0797t2.f4663a.get("android:visibility:visibility")).intValue();
            bVar.f4559f = (ViewGroup) c0797t2.f4663a.get("android:visibility:parent");
        } else {
            bVar.f4557d = -1;
            bVar.f4559f = null;
        }
        if (c0797t != null && c0797t2 != null) {
            if (bVar.f4556c == bVar.f4557d && bVar.f4558e == bVar.f4559f) {
                return bVar;
            }
            if (bVar.f4556c != bVar.f4557d) {
                if (bVar.f4556c == 0) {
                    bVar.f4555b = false;
                    bVar.f4554a = true;
                } else if (bVar.f4557d == 0) {
                    bVar.f4555b = true;
                    bVar.f4554a = true;
                }
            } else if (bVar.f4559f == null) {
                bVar.f4555b = false;
                bVar.f4554a = true;
            } else if (bVar.f4558e == null) {
                bVar.f4555b = true;
                bVar.f4554a = true;
            }
        } else if (c0797t == null && bVar.f4557d == 0) {
            bVar.f4555b = true;
            bVar.f4554a = true;
        } else if (c0797t2 == null && bVar.f4556c == 0) {
            bVar.f4555b = false;
            bVar.f4554a = true;
        }
        return bVar;
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, TransitionValues c0797t, TransitionValues c0797t2) {
        IntrinsicsJvm.kt_4 bVarM4750a = m4750a(c0797t, c0797t2);
        if (!bVarM4750a.f4554a) {
            return null;
        }
        if (bVarM4750a.f4558e == null && bVarM4750a.f4559f == null) {
            return null;
        }
        if (bVarM4750a.f4555b) {
            return m4753a(viewGroup, c0797t, bVarM4750a.f4556c, c0797t2, bVarM4750a.f4557d);
        }
        return m4756b(viewGroup, c0797t, bVarM4750a.f4556c, c0797t2, bVarM4750a.f4557d);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Animator m4753a(ViewGroup viewGroup, TransitionValues c0797t, int OplusGLSurfaceView_13, TransitionValues c0797t2, int i2) {
        if ((this.f4543b & 1) != 1 || c0797t2 == null) {
            return null;
        }
        if (c0797t == null) {
            View view = (View) c0797t2.f4664b.getParent();
            if (m4750a(getMatchedTransitionValues(view, false), getTransitionValues(view, false)).f4554a) {
                return null;
            }
        }
        return mo4752a(viewGroup, c0797t2.f4664b, c0797t, c0797t2);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0082  */
    /* renamed from: IntrinsicsJvm.kt_4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.animation.Animator m4756b(final android.view.ViewGroup r10, androidx.transition.TransitionValues r11, int r12, androidx.transition.TransitionValues r13, int r14) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Visibility.m4756b(android.view.ViewGroup, androidx.transition.t, int, androidx.transition.t, int):android.animation.Animator");
    }

    @Override // androidx.transition.Transition
    public boolean isTransitionRequired(TransitionValues c0797t, TransitionValues c0797t2) {
        if (c0797t == null && c0797t2 == null) {
            return false;
        }
        if (c0797t != null && c0797t2 != null && c0797t2.f4663a.containsKey("android:visibility:visibility") != c0797t.f4663a.containsKey("android:visibility:visibility")) {
            return false;
        }
        IntrinsicsJvm.kt_4 bVarM4750a = m4750a(c0797t, c0797t2);
        if (bVarM4750a.f4554a) {
            return bVarM4750a.f4556c == 0 || bVarM4750a.f4557d == 0;
        }
        return false;
    }

    /* compiled from: Visibility.java */
    /* renamed from: androidx.transition.ak$PlatformImplementations.kt_3 */
    private static class PlatformImplementations.kt_3 extends AnimatorListenerAdapter implements AnimatorUtils.PlatformImplementations.kt_3, Transition.IntrinsicsJvm.kt_5 {

        /* renamed from: PlatformImplementations.kt_3 */
        boolean f4548a = false;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final View f4549b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private final int f4550c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private final ViewGroup f4551d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private final boolean f4552e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private boolean f4553f;

        @Override // androidx.transition.Transition.IntrinsicsJvm.kt_5
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo4762a(Transition abstractC0791m) {
        }

        @Override // androidx.transition.Transition.IntrinsicsJvm.kt_5
        /* renamed from: COUIBaseListPopupWindow_8 */
        public void mo4763e(Transition abstractC0791m) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        PlatformImplementations.kt_3(View view, int OplusGLSurfaceView_13, boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.f4549b = view;
            this.f4550c = OplusGLSurfaceView_13;
            this.f4551d = (ViewGroup) view.getParent();
            this.f4552e = z;
            m4761a(true);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, androidx.transition.AnimatorUtils.PlatformImplementations.kt_3
        public void onAnimationPause(Animator animator) throws IllegalAccessException, IllegalArgumentException {
            if (this.f4548a) {
                return;
            }
            ViewUtils.m4729a(this.f4549b, this.f4550c);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, androidx.transition.AnimatorUtils.PlatformImplementations.kt_3
        public void onAnimationResume(Animator animator) throws IllegalAccessException, IllegalArgumentException {
            if (this.f4548a) {
                return;
            }
            ViewUtils.m4729a(this.f4549b, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f4548a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            m4760a();
        }

        @Override // androidx.transition.Transition.IntrinsicsJvm.kt_5
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo4757b(Transition abstractC0791m) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            m4760a();
            abstractC0791m.removeListener(this);
        }

        @Override // androidx.transition.Transition.IntrinsicsJvm.kt_5
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo4758c(Transition abstractC0791m) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            m4761a(false);
        }

        @Override // androidx.transition.Transition.IntrinsicsJvm.kt_5
        /* renamed from: IntrinsicsJvm.kt_5 */
        public void mo4759d(Transition abstractC0791m) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            m4761a(true);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m4760a() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (!this.f4548a) {
                ViewUtils.m4729a(this.f4549b, this.f4550c);
                ViewGroup viewGroup = this.f4551d;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            m4761a(false);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m4761a(boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            ViewGroup viewGroup;
            if (!this.f4552e || this.f4553f == z || (viewGroup = this.f4551d) == null) {
                return;
            }
            this.f4553f = z;
            ViewGroupUtils.m4832a(viewGroup, z);
        }
    }
}
