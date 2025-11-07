package androidx.transition;

/* compiled from: Visibility.java */
/* loaded from: classes.dex */
public abstract class ak_renamed extends androidx.transition.m_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.String[] f1678a = {"android:visibility:visibility", "android:visibility:parent"};

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f1679b = 3;

    public android.animation.Animator a_renamed(android.view.ViewGroup viewGroup, android.view.View view, androidx.transition.t_renamed tVar, androidx.transition.t_renamed tVar2) {
        return null;
    }

    public android.animation.Animator b_renamed(android.view.ViewGroup viewGroup, android.view.View view, androidx.transition.t_renamed tVar, androidx.transition.t_renamed tVar2) {
        return null;
    }

    /* compiled from: Visibility.java */
    private static class b_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        boolean f1686a;

        /* renamed from: b_renamed, reason: collision with root package name */
        boolean f1687b;

        /* renamed from: c_renamed, reason: collision with root package name */
        int f1688c;
        int d_renamed;
        android.view.ViewGroup e_renamed;
        android.view.ViewGroup f_renamed;

        b_renamed() {
        }
    }

    public void a_renamed(int i_renamed) {
        if ((i_renamed & (-4)) != 0) {
            throw new java.lang.IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.f1679b = i_renamed;
    }

    @Override // androidx.transition.m_renamed
    public java.lang.String[] getTransitionProperties() {
        return f1678a;
    }

    private void a_renamed(androidx.transition.t_renamed tVar) {
        tVar.f1754a.put("android:visibility:visibility", java.lang.Integer.valueOf(tVar.f1755b.getVisibility()));
        tVar.f1754a.put("android:visibility:parent", tVar.f1755b.getParent());
        int[] iArr = new int[2];
        tVar.f1755b.getLocationOnScreen(iArr);
        tVar.f1754a.put("android:visibility:screenLocation", iArr);
    }

    @Override // androidx.transition.m_renamed
    public void captureStartValues(androidx.transition.t_renamed tVar) {
        a_renamed(tVar);
    }

    @Override // androidx.transition.m_renamed
    public void captureEndValues(androidx.transition.t_renamed tVar) {
        a_renamed(tVar);
    }

    private androidx.transition.ak_renamed.b_renamed a_renamed(androidx.transition.t_renamed tVar, androidx.transition.t_renamed tVar2) {
        androidx.transition.ak_renamed.b_renamed bVar = new androidx.transition.ak_renamed.b_renamed();
        bVar.f1686a = false;
        bVar.f1687b = false;
        if (tVar != null && tVar.f1754a.containsKey("android:visibility:visibility")) {
            bVar.f1688c = ((java.lang.Integer) tVar.f1754a.get("android:visibility:visibility")).intValue();
            bVar.e_renamed = (android.view.ViewGroup) tVar.f1754a.get("android:visibility:parent");
        } else {
            bVar.f1688c = -1;
            bVar.e_renamed = null;
        }
        if (tVar2 != null && tVar2.f1754a.containsKey("android:visibility:visibility")) {
            bVar.d_renamed = ((java.lang.Integer) tVar2.f1754a.get("android:visibility:visibility")).intValue();
            bVar.f_renamed = (android.view.ViewGroup) tVar2.f1754a.get("android:visibility:parent");
        } else {
            bVar.d_renamed = -1;
            bVar.f_renamed = null;
        }
        if (tVar != null && tVar2 != null) {
            if (bVar.f1688c == bVar.d_renamed && bVar.e_renamed == bVar.f_renamed) {
                return bVar;
            }
            if (bVar.f1688c != bVar.d_renamed) {
                if (bVar.f1688c == 0) {
                    bVar.f1687b = false;
                    bVar.f1686a = true;
                } else if (bVar.d_renamed == 0) {
                    bVar.f1687b = true;
                    bVar.f1686a = true;
                }
            } else if (bVar.f_renamed == null) {
                bVar.f1687b = false;
                bVar.f1686a = true;
            } else if (bVar.e_renamed == null) {
                bVar.f1687b = true;
                bVar.f1686a = true;
            }
        } else if (tVar == null && bVar.d_renamed == 0) {
            bVar.f1687b = true;
            bVar.f1686a = true;
        } else if (tVar2 == null && bVar.f1688c == 0) {
            bVar.f1687b = false;
            bVar.f1686a = true;
        }
        return bVar;
    }

    @Override // androidx.transition.m_renamed
    public android.animation.Animator createAnimator(android.view.ViewGroup viewGroup, androidx.transition.t_renamed tVar, androidx.transition.t_renamed tVar2) {
        androidx.transition.ak_renamed.b_renamed bVarA = a_renamed(tVar, tVar2);
        if (!bVarA.f1686a) {
            return null;
        }
        if (bVarA.e_renamed == null && bVarA.f_renamed == null) {
            return null;
        }
        if (bVarA.f1687b) {
            return a_renamed(viewGroup, tVar, bVarA.f1688c, tVar2, bVarA.d_renamed);
        }
        return b_renamed(viewGroup, tVar, bVarA.f1688c, tVar2, bVarA.d_renamed);
    }

    public android.animation.Animator a_renamed(android.view.ViewGroup viewGroup, androidx.transition.t_renamed tVar, int i_renamed, androidx.transition.t_renamed tVar2, int i2) {
        if ((this.f1679b & 1) != 1 || tVar2 == null) {
            return null;
        }
        if (tVar == null) {
            android.view.View view = (android.view.View) tVar2.f1755b.getParent();
            if (a_renamed(getMatchedTransitionValues(view, false), getTransitionValues(view, false)).f1686a) {
                return null;
            }
        }
        return a_renamed(viewGroup, tVar2.f1755b, tVar, tVar2);
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:44:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.animation.Animator b_renamed(final android.view.ViewGroup r10, androidx.transition.t_renamed r11, int r12, androidx.transition.t_renamed r13, int r14) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.ak_renamed.b_renamed(android.view.ViewGroup, androidx.transition.t_renamed, int, androidx.transition.t_renamed, int):android.animation.Animator");
    }

    @Override // androidx.transition.m_renamed
    public boolean isTransitionRequired(androidx.transition.t_renamed tVar, androidx.transition.t_renamed tVar2) {
        if (tVar == null && tVar2 == null) {
            return false;
        }
        if (tVar != null && tVar2 != null && tVar2.f1754a.containsKey("android:visibility:visibility") != tVar.f1754a.containsKey("android:visibility:visibility")) {
            return false;
        }
        androidx.transition.ak_renamed.b_renamed bVarA = a_renamed(tVar, tVar2);
        if (bVarA.f1686a) {
            return bVarA.f1688c == 0 || bVarA.d_renamed == 0;
        }
        return false;
    }

    /* compiled from: Visibility.java */
    private static class a_renamed extends android.animation.AnimatorListenerAdapter implements androidx.transition.a_renamed.AnimatorUtils_2, androidx.transition.m_renamed.d_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        boolean f1683a = false;

        /* renamed from: b_renamed, reason: collision with root package name */
        private final android.view.View f1684b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private final int f1685c;
        private final android.view.ViewGroup d_renamed;
        private final boolean e_renamed;
        private boolean f_renamed;

        @Override // androidx.transition.m_renamed.d_renamed
        public void a_renamed(androidx.transition.m_renamed mVar) {
        }

        @Override // androidx.transition.m_renamed.d_renamed
        public void e_renamed(androidx.transition.m_renamed mVar) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(android.animation.Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(android.animation.Animator animator) {
        }

        a_renamed(android.view.View view, int i_renamed, boolean z_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            this.f1684b = view;
            this.f1685c = i_renamed;
            this.d_renamed = (android.view.ViewGroup) view.getParent();
            this.e_renamed = z_renamed;
            a_renamed(true);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, androidx.transition.a_renamed.AnimatorUtils_2
        public void onAnimationPause(android.animation.Animator animator) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
            if (this.f1683a) {
                return;
            }
            androidx.transition.ad_renamed.a_renamed(this.f1684b, this.f1685c);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, androidx.transition.a_renamed.AnimatorUtils_2
        public void onAnimationResume(android.animation.Animator animator) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
            if (this.f1683a) {
                return;
            }
            androidx.transition.ad_renamed.a_renamed(this.f1684b, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(android.animation.Animator animator) {
            this.f1683a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            a_renamed();
        }

        @Override // androidx.transition.m_renamed.d_renamed
        public void b_renamed(androidx.transition.m_renamed mVar) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            a_renamed();
            mVar.removeListener(this);
        }

        @Override // androidx.transition.m_renamed.d_renamed
        public void c_renamed(androidx.transition.m_renamed mVar) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            a_renamed(false);
        }

        @Override // androidx.transition.m_renamed.d_renamed
        public void d_renamed(androidx.transition.m_renamed mVar) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            a_renamed(true);
        }

        private void a_renamed() throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            if (!this.f1683a) {
                androidx.transition.ad_renamed.a_renamed(this.f1684b, this.f1685c);
                android.view.ViewGroup viewGroup = this.d_renamed;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            a_renamed(false);
        }

        private void a_renamed(boolean z_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            android.view.ViewGroup viewGroup;
            if (!this.e_renamed || this.f_renamed == z_renamed || (viewGroup = this.d_renamed) == null) {
                return;
            }
            this.f_renamed = z_renamed;
            androidx.transition.y_renamed.a_renamed(viewGroup, z_renamed);
        }
    }
}
