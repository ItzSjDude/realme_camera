package androidx.fragment.app;

/* compiled from: FragmentManagerImpl.java */
/* loaded from: classes.dex */
final class i_renamed extends androidx.fragment.app.h_renamed implements android.view.LayoutInflater.Factory2 {
    static final android.view.animation.Interpolator D_renamed = new android.view.animation.DecelerateInterpolator(2.5f);
    static final android.view.animation.Interpolator E_renamed = new android.view.animation.DecelerateInterpolator(1.5f);

    /* renamed from: b_renamed, reason: collision with root package name */
    static boolean f1142b;
    java.util.ArrayList<androidx.fragment.app.i_renamed.g_renamed> B_renamed;
    private androidx.activity.OnBackPressedDispatcher F_renamed;
    private androidx.fragment.app.j_renamed I_renamed;

    /* renamed from: c_renamed, reason: collision with root package name */
    java.util.ArrayList<androidx.fragment.app.i_renamed.e_renamed> f1143c;
    boolean d_renamed;
    java.util.ArrayList<androidx.fragment.app.a_renamed> h_renamed;
    java.util.ArrayList<androidx.fragment.app.Fragment> i_renamed;
    java.util.ArrayList<androidx.fragment.app.a_renamed> j_renamed;
    java.util.ArrayList<java.lang.Integer> k_renamed;
    java.util.ArrayList<androidx.fragment.app.h_renamed.b_renamed> l_renamed;
    androidx.fragment.app.g_renamed n_renamed;
    androidx.fragment.app.d_renamed o_renamed;
    androidx.fragment.app.Fragment p_renamed;
    androidx.fragment.app.Fragment q_renamed;
    boolean r_renamed;
    boolean s_renamed;
    boolean t_renamed;
    boolean u_renamed;
    boolean v_renamed;
    java.util.ArrayList<androidx.fragment.app.a_renamed> w_renamed;
    java.util.ArrayList<java.lang.Boolean> x_renamed;
    java.util.ArrayList<androidx.fragment.app.Fragment> y_renamed;
    int e_renamed = 0;
    final java.util.ArrayList<androidx.fragment.app.Fragment> f_renamed = new java.util.ArrayList<>();
    final java.util.HashMap<java.lang.String, androidx.fragment.app.Fragment> g_renamed = new java.util.HashMap<>();
    private final androidx.activity.c_renamed G_renamed = new androidx.activity.c_renamed(false) { // from class: androidx.fragment.app.i_renamed.1
        @Override // androidx.activity.c_renamed
        public void c_renamed() {
            androidx.fragment.app.i_renamed.this.h_renamed();
        }
    };
    private final java.util.concurrent.CopyOnWriteArrayList<androidx.fragment.app.i_renamed.c_renamed> H_renamed = new java.util.concurrent.CopyOnWriteArrayList<>();
    int m_renamed = 0;
    android.os.Bundle z_renamed = null;
    android.util.SparseArray<android.os.Parcelable> A_renamed = null;
    java.lang.Runnable C_renamed = new java.lang.Runnable() { // from class: androidx.fragment.app.i_renamed.2
        @Override // java.lang.Runnable
        public void run() {
            androidx.fragment.app.i_renamed.this.l_renamed();
        }
    };

    /* compiled from: FragmentManagerImpl.java */
    static class d_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public static final int[] f1164a = {android.R_renamed.attr.name, android.R_renamed.attr.id_renamed, android.R_renamed.attr.tag};
    }

    /* compiled from: FragmentManagerImpl.java */
    interface e_renamed {
        boolean a_renamed(java.util.ArrayList<androidx.fragment.app.a_renamed> arrayList, java.util.ArrayList<java.lang.Boolean> arrayList2);
    }

    public static int b_renamed(int i_renamed, boolean z_renamed) {
        if (i_renamed == 4097) {
            return z_renamed ? 1 : 2;
        }
        if (i_renamed == 4099) {
            return z_renamed ? 5 : 6;
        }
        if (i_renamed != 8194) {
            return -1;
        }
        return z_renamed ? 3 : 4;
    }

    public static int d_renamed(int i_renamed) {
        if (i_renamed == 4097) {
            return 8194;
        }
        if (i_renamed != 4099) {
            return i_renamed != 8194 ? 0 : 4097;
        }
        return 4099;
    }

    android.view.LayoutInflater.Factory2 C_renamed() {
        return this;
    }

    i_renamed() {
    }

    /* compiled from: FragmentManagerImpl.java */
    private static final class c_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        final androidx.fragment.app.h_renamed.a_renamed f1162a;

        /* renamed from: b_renamed, reason: collision with root package name */
        final boolean f1163b;

        c_renamed(androidx.fragment.app.h_renamed.a_renamed aVar, boolean z_renamed) {
            this.f1162a = aVar;
            this.f1163b = z_renamed;
        }
    }

    private void a_renamed(java.lang.RuntimeException runtimeException) {
        android.util.Log.e_renamed("FragmentManager", runtimeException.getMessage());
        android.util.Log.e_renamed("FragmentManager", "Activity state:");
        java.io.PrintWriter printWriter = new java.io.PrintWriter(new androidx.core.g_renamed.b_renamed("FragmentManager"));
        androidx.fragment.app.g_renamed gVar = this.n_renamed;
        if (gVar != null) {
            try {
                gVar.a_renamed("  ", (java.io.FileDescriptor) null, printWriter, new java.lang.String[0]);
                throw runtimeException;
            } catch (java.lang.Exception e2) {
                android.util.Log.e_renamed("FragmentManager", "Failed dumping state", e2);
                throw runtimeException;
            }
        }
        try {
            a_renamed("  ", (java.io.FileDescriptor) null, printWriter, new java.lang.String[0]);
            throw runtimeException;
        } catch (java.lang.Exception e3) {
            android.util.Log.e_renamed("FragmentManager", "Failed dumping state", e3);
            throw runtimeException;
        }
    }

    @Override // androidx.fragment.app.h_renamed
    public androidx.fragment.app.k_renamed a_renamed() {
        return new androidx.fragment.app.a_renamed(this);
    }

    @Override // androidx.fragment.app.h_renamed
    public boolean b_renamed() throws android.content.res.Resources.NotFoundException {
        boolean zL = l_renamed();
        G_renamed();
        return zL;
    }

    private void D_renamed() {
        java.util.ArrayList<androidx.fragment.app.i_renamed.e_renamed> arrayList = this.f1143c;
        if (arrayList != null && !arrayList.isEmpty()) {
            this.G_renamed.a_renamed(true);
        } else {
            this.G_renamed.a_renamed(i_renamed() > 0 && a_renamed(this.p_renamed));
        }
    }

    boolean a_renamed(androidx.fragment.app.Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        androidx.fragment.app.i_renamed iVar = fragment.mFragmentManager;
        return fragment == iVar.A_renamed() && a_renamed(iVar.p_renamed);
    }

    void h_renamed() {
        l_renamed();
        if (this.G_renamed.a_renamed()) {
            c_renamed();
        } else {
            this.F_renamed.a_renamed();
        }
    }

    @Override // androidx.fragment.app.h_renamed
    public boolean c_renamed() {
        E_renamed();
        return a_renamed((java.lang.String) null, -1, 0);
    }

    @Override // androidx.fragment.app.h_renamed
    public void a_renamed(int i_renamed, int i2) {
        if (i_renamed < 0) {
            throw new java.lang.IllegalArgumentException("Bad id_renamed: " + i_renamed);
        }
        a_renamed((androidx.fragment.app.i_renamed.e_renamed) new androidx.fragment.app.i_renamed.f_renamed(null, i_renamed, i2), false);
    }

    private boolean a_renamed(java.lang.String str, int i_renamed, int i2) {
        l_renamed();
        c_renamed(true);
        androidx.fragment.app.Fragment fragment = this.q_renamed;
        if (fragment != null && i_renamed < 0 && str == null && fragment.getChildFragmentManager().c_renamed()) {
            return true;
        }
        boolean zA = a_renamed(this.w_renamed, this.x_renamed, str, i_renamed, i2);
        if (zA) {
            this.d_renamed = true;
            try {
                b_renamed(this.w_renamed, this.x_renamed);
            } finally {
                F_renamed();
            }
        }
        D_renamed();
        m_renamed();
        I_renamed();
        return zA;
    }

    public int i_renamed() {
        java.util.ArrayList<androidx.fragment.app.a_renamed> arrayList = this.h_renamed;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public void a_renamed(android.os.Bundle bundle, java.lang.String str, androidx.fragment.app.Fragment fragment) {
        if (fragment.mFragmentManager != this) {
            a_renamed(new java.lang.IllegalStateException("Fragment " + fragment + " is_renamed not currently in_renamed the FragmentManager"));
        }
        bundle.putString(str, fragment.mWho);
    }

    public androidx.fragment.app.Fragment a_renamed(android.os.Bundle bundle, java.lang.String str) {
        java.lang.String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        androidx.fragment.app.Fragment fragment = this.g_renamed.get(string);
        if (fragment == null) {
            a_renamed(new java.lang.IllegalStateException("Fragment no longer exists for key " + str + ": unique id_renamed " + string));
        }
        return fragment;
    }

    @Override // androidx.fragment.app.h_renamed
    public java.util.List<androidx.fragment.app.Fragment> d_renamed() {
        java.util.List<androidx.fragment.app.Fragment> list;
        if (this.f_renamed.isEmpty()) {
            return java.util.Collections.emptyList();
        }
        synchronized (this.f_renamed) {
            list = (java.util.List) this.f_renamed.clone();
        }
        return list;
    }

    androidx.lifecycle.s_renamed b_renamed(androidx.fragment.app.Fragment fragment) {
        return this.I_renamed.e_renamed(fragment);
    }

    androidx.fragment.app.j_renamed c_renamed(androidx.fragment.app.Fragment fragment) {
        return this.I_renamed.d_renamed(fragment);
    }

    void d_renamed(androidx.fragment.app.Fragment fragment) {
        if (g_renamed()) {
            if (f1142b) {
                android.util.Log.v_renamed("FragmentManager", "Ignoring addRetainedFragment as_renamed the state is_renamed already saved");
            }
        } else if (this.I_renamed.a_renamed(fragment) && f1142b) {
            android.util.Log.v_renamed("FragmentManager", "Updating retained Fragments: Added " + fragment);
        }
    }

    void e_renamed(androidx.fragment.app.Fragment fragment) {
        if (g_renamed()) {
            if (f1142b) {
                android.util.Log.v_renamed("FragmentManager", "Ignoring removeRetainedFragment as_renamed the state is_renamed already saved");
            }
        } else if (this.I_renamed.c_renamed(fragment) && f1142b) {
            android.util.Log.v_renamed("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    @Override // androidx.fragment.app.h_renamed
    public boolean e_renamed() {
        return this.u_renamed;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(java.lang.Integer.toHexString(java.lang.System.identityHashCode(this)));
        sb.append(" in_renamed ");
        androidx.fragment.app.Fragment fragment = this.p_renamed;
        if (fragment != null) {
            androidx.core.g_renamed.a_renamed.a_renamed(fragment, sb);
        } else {
            androidx.core.g_renamed.a_renamed.a_renamed(this.n_renamed, sb);
        }
        sb.append("}}");
        return sb.toString();
    }

    @Override // androidx.fragment.app.h_renamed
    public void a_renamed(java.lang.String str, java.io.FileDescriptor fileDescriptor, java.io.PrintWriter printWriter, java.lang.String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        java.lang.String str2 = str + "    ";
        if (!this.g_renamed.isEmpty()) {
            printWriter.print(str);
            printWriter.print("Active Fragments in_renamed ");
            printWriter.print(java.lang.Integer.toHexString(java.lang.System.identityHashCode(this)));
            printWriter.println(":");
            for (androidx.fragment.app.Fragment fragment : this.g_renamed.values()) {
                printWriter.print(str);
                printWriter.println(fragment);
                if (fragment != null) {
                    fragment.dump(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        int size5 = this.f_renamed.size();
        if (size5 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i_renamed = 0; i_renamed < size5; i_renamed++) {
                androidx.fragment.app.Fragment fragment2 = this.f_renamed.get(i_renamed);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i_renamed);
                printWriter.print(": ");
                printWriter.println(fragment2.toString());
            }
        }
        java.util.ArrayList<androidx.fragment.app.Fragment> arrayList = this.i_renamed;
        if (arrayList != null && (size4 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < size4; i2++) {
                androidx.fragment.app.Fragment fragment3 = this.i_renamed.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment3.toString());
            }
        }
        java.util.ArrayList<androidx.fragment.app.a_renamed> arrayList2 = this.h_renamed;
        if (arrayList2 != null && (size3 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i3 = 0; i3 < size3; i3++) {
                androidx.fragment.app.a_renamed aVar = this.h_renamed.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.a_renamed(str2, printWriter);
            }
        }
        synchronized (this) {
            if (this.j_renamed != null && (size2 = this.j_renamed.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                for (int i4 = 0; i4 < size2; i4++) {
                    java.lang.Object obj = (androidx.fragment.app.a_renamed) this.j_renamed.get(i4);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i4);
                    printWriter.print(": ");
                    printWriter.println(obj);
                }
            }
            if (this.k_renamed != null && this.k_renamed.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(java.util.Arrays.toString(this.k_renamed.toArray()));
            }
        }
        java.util.ArrayList<androidx.fragment.app.i_renamed.e_renamed> arrayList3 = this.f1143c;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i5 = 0; i5 < size; i5++) {
                java.lang.Object obj2 = (androidx.fragment.app.i_renamed.e_renamed) this.f1143c.get(i5);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i5);
                printWriter.print(": ");
                printWriter.println(obj2);
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.n_renamed);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.o_renamed);
        if (this.p_renamed != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.p_renamed);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.m_renamed);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.s_renamed);
        printWriter.print(" mStopped=");
        printWriter.print(this.t_renamed);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.u_renamed);
        if (this.r_renamed) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.r_renamed);
        }
    }

    static androidx.fragment.app.i_renamed.a_renamed a_renamed(float f2, float f3, float f4, float f5) {
        android.view.animation.AnimationSet animationSet = new android.view.animation.AnimationSet(false);
        android.view.animation.ScaleAnimation scaleAnimation = new android.view.animation.ScaleAnimation(f2, f3, f2, f3, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(D_renamed);
        scaleAnimation.setDuration(220L);
        animationSet.addAnimation(scaleAnimation);
        android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(f4, f5);
        alphaAnimation.setInterpolator(E_renamed);
        alphaAnimation.setDuration(220L);
        animationSet.addAnimation(alphaAnimation);
        return new androidx.fragment.app.i_renamed.a_renamed(animationSet);
    }

    static androidx.fragment.app.i_renamed.a_renamed a_renamed(float f2, float f3) {
        android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(f2, f3);
        alphaAnimation.setInterpolator(E_renamed);
        alphaAnimation.setDuration(220L);
        return new androidx.fragment.app.i_renamed.a_renamed(alphaAnimation);
    }

    androidx.fragment.app.i_renamed.a_renamed a_renamed(androidx.fragment.app.Fragment fragment, int i_renamed, boolean z_renamed, int i2) throws android.content.res.Resources.NotFoundException {
        int iB;
        int nextAnim = fragment.getNextAnim();
        boolean z2 = false;
        fragment.setNextAnim(0);
        if (fragment.mContainer != null && fragment.mContainer.getLayoutTransition() != null) {
            return null;
        }
        android.view.animation.Animation animationOnCreateAnimation = fragment.onCreateAnimation(i_renamed, z_renamed, nextAnim);
        if (animationOnCreateAnimation != null) {
            return new androidx.fragment.app.i_renamed.a_renamed(animationOnCreateAnimation);
        }
        android.animation.Animator animatorOnCreateAnimator = fragment.onCreateAnimator(i_renamed, z_renamed, nextAnim);
        if (animatorOnCreateAnimator != null) {
            return new androidx.fragment.app.i_renamed.a_renamed(animatorOnCreateAnimator);
        }
        if (nextAnim != 0) {
            boolean zEquals = "anim".equals(this.n_renamed.j_renamed().getResources().getResourceTypeName(nextAnim));
            if (zEquals) {
                try {
                    android.view.animation.Animation animationLoadAnimation = android.view.animation.AnimationUtils.loadAnimation(this.n_renamed.j_renamed(), nextAnim);
                    if (animationLoadAnimation != null) {
                        return new androidx.fragment.app.i_renamed.a_renamed(animationLoadAnimation);
                    }
                    z2 = true;
                } catch (android.content.res.Resources.NotFoundException e2) {
                    throw e2;
                } catch (java.lang.RuntimeException unused) {
                }
            }
            if (!z2) {
                try {
                    android.animation.Animator animatorLoadAnimator = android.animation.AnimatorInflater.loadAnimator(this.n_renamed.j_renamed(), nextAnim);
                    if (animatorLoadAnimator != null) {
                        return new androidx.fragment.app.i_renamed.a_renamed(animatorLoadAnimator);
                    }
                } catch (java.lang.RuntimeException e3) {
                    if (zEquals) {
                        throw e3;
                    }
                    android.view.animation.Animation animationLoadAnimation2 = android.view.animation.AnimationUtils.loadAnimation(this.n_renamed.j_renamed(), nextAnim);
                    if (animationLoadAnimation2 != null) {
                        return new androidx.fragment.app.i_renamed.a_renamed(animationLoadAnimation2);
                    }
                }
            }
        }
        if (i_renamed == 0 || (iB = b_renamed(i_renamed, z_renamed)) < 0) {
            return null;
        }
        switch (iB) {
            case 1:
                return a_renamed(1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return a_renamed(1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return a_renamed(0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return a_renamed(1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return a_renamed(0.0f, 1.0f);
            case 6:
                return a_renamed(1.0f, 0.0f);
            default:
                if (i2 == 0 && this.n_renamed.f_renamed()) {
                    i2 = this.n_renamed.g_renamed();
                }
                if (i2 == 0) {
                }
                return null;
        }
    }

    public void f_renamed(androidx.fragment.app.Fragment fragment) {
        if (fragment.mDeferStart) {
            if (this.d_renamed) {
                this.v_renamed = true;
            } else {
                fragment.mDeferStart = false;
                a_renamed(fragment, this.m_renamed, 0, 0, false);
            }
        }
    }

    boolean a_renamed(int i_renamed) {
        return this.m_renamed >= i_renamed;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B_renamed:150:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:156:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:220:0x0429  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:275:0x04ff  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:279:? A_renamed[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void a_renamed(androidx.fragment.app.Fragment r19, int r20, int r21, int r22, boolean r23) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 1320
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.i_renamed.a_renamed(androidx.fragment.app.Fragment, int, int, int, boolean):void");
    }

    private void a_renamed(final androidx.fragment.app.Fragment fragment, androidx.fragment.app.i_renamed.a_renamed aVar, int i_renamed) {
        final android.view.View view = fragment.mView;
        final android.view.ViewGroup viewGroup = fragment.mContainer;
        viewGroup.startViewTransition(view);
        fragment.setStateAfterAnimating(i_renamed);
        if (aVar.f1157a != null) {
            androidx.fragment.app.i_renamed.b_renamed bVar = new androidx.fragment.app.i_renamed.b_renamed(aVar.f1157a, viewGroup, view);
            fragment.setAnimatingAway(fragment.mView);
            bVar.setAnimationListener(new android.view.animation.Animation.AnimationListener() { // from class: androidx.fragment.app.i_renamed.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(android.view.animation.Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(android.view.animation.Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(android.view.animation.Animation animation) {
                    viewGroup.post(new java.lang.Runnable() { // from class: androidx.fragment.app.i_renamed.3.1
                        @Override // java.lang.Runnable
                        public void run() throws android.content.res.Resources.NotFoundException {
                            if (fragment.getAnimatingAway() != null) {
                                fragment.setAnimatingAway(null);
                                androidx.fragment.app.i_renamed.this.a_renamed(fragment, fragment.getStateAfterAnimating(), 0, 0, false);
                            }
                        }
                    });
                }
            });
            fragment.mView.startAnimation(bVar);
            return;
        }
        android.animation.Animator animator = aVar.f1158b;
        fragment.setAnimator(aVar.f1158b);
        animator.addListener(new android.animation.AnimatorListenerAdapter() { // from class: androidx.fragment.app.i_renamed.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator2) throws android.content.res.Resources.NotFoundException {
                viewGroup.endViewTransition(view);
                android.animation.Animator animator3 = fragment.getAnimator();
                fragment.setAnimator(null);
                if (animator3 == null || viewGroup.indexOfChild(view) >= 0) {
                    return;
                }
                androidx.fragment.app.i_renamed iVar = androidx.fragment.app.i_renamed.this;
                androidx.fragment.app.Fragment fragment2 = fragment;
                iVar.a_renamed(fragment2, fragment2.getStateAfterAnimating(), 0, 0, false);
            }
        });
        animator.setTarget(fragment.mView);
        animator.start();
    }

    void g_renamed(androidx.fragment.app.Fragment fragment) throws android.content.res.Resources.NotFoundException {
        a_renamed(fragment, this.m_renamed, 0, 0, false);
    }

    void h_renamed(androidx.fragment.app.Fragment fragment) {
        if (!fragment.mFromLayout || fragment.mPerformedCreateView) {
            return;
        }
        fragment.performCreateView(fragment.performGetLayoutInflater(fragment.mSavedFragmentState), null, fragment.mSavedFragmentState);
        if (fragment.mView != null) {
            fragment.mInnerView = fragment.mView;
            fragment.mView.setSaveFromParentEnabled(false);
            if (fragment.mHidden) {
                fragment.mView.setVisibility(8);
            }
            fragment.onViewCreated(fragment.mView, fragment.mSavedFragmentState);
            a_renamed(fragment, fragment.mView, fragment.mSavedFragmentState, false);
            return;
        }
        fragment.mInnerView = null;
    }

    void i_renamed(final androidx.fragment.app.Fragment fragment) throws android.content.res.Resources.NotFoundException {
        if (fragment.mView != null) {
            androidx.fragment.app.i_renamed.a_renamed aVarA = a_renamed(fragment, fragment.getNextTransition(), !fragment.mHidden, fragment.getNextTransitionStyle());
            if (aVarA != null && aVarA.f1158b != null) {
                aVarA.f1158b.setTarget(fragment.mView);
                if (fragment.mHidden) {
                    if (fragment.isHideReplaced()) {
                        fragment.setHideReplaced(false);
                    } else {
                        final android.view.ViewGroup viewGroup = fragment.mContainer;
                        final android.view.View view = fragment.mView;
                        viewGroup.startViewTransition(view);
                        aVarA.f1158b.addListener(new android.animation.AnimatorListenerAdapter() { // from class: androidx.fragment.app.i_renamed.5
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(android.animation.Animator animator) {
                                viewGroup.endViewTransition(view);
                                animator.removeListener(this);
                                if (fragment.mView == null || !fragment.mHidden) {
                                    return;
                                }
                                fragment.mView.setVisibility(8);
                            }
                        });
                    }
                } else {
                    fragment.mView.setVisibility(0);
                }
                aVarA.f1158b.start();
            } else {
                if (aVarA != null) {
                    fragment.mView.startAnimation(aVarA.f1157a);
                    aVarA.f1157a.start();
                }
                fragment.mView.setVisibility((!fragment.mHidden || fragment.isHideReplaced()) ? 0 : 8);
                if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                }
            }
        }
        if (fragment.mAdded && w_renamed(fragment)) {
            this.r_renamed = true;
        }
        fragment.mHiddenChanged = false;
        fragment.onHiddenChanged(fragment.mHidden);
    }

    void j_renamed(androidx.fragment.app.Fragment fragment) throws android.content.res.Resources.NotFoundException {
        if (fragment == null) {
            return;
        }
        if (!this.g_renamed.containsKey(fragment.mWho)) {
            if (f1142b) {
                android.util.Log.v_renamed("FragmentManager", "Ignoring moving " + fragment + " to state " + this.m_renamed + "since it is_renamed not added to " + this);
                return;
            }
            return;
        }
        int iMin = this.m_renamed;
        if (fragment.mRemoving) {
            if (fragment.isInBackStack()) {
                iMin = java.lang.Math.min(iMin, 1);
            } else {
                iMin = java.lang.Math.min(iMin, 0);
            }
        }
        a_renamed(fragment, iMin, fragment.getNextTransition(), fragment.getNextTransitionStyle(), false);
        if (fragment.mView != null) {
            androidx.fragment.app.Fragment fragmentU = u_renamed(fragment);
            if (fragmentU != null) {
                android.view.View view = fragmentU.mView;
                android.view.ViewGroup viewGroup = fragment.mContainer;
                int iIndexOfChild = viewGroup.indexOfChild(view);
                int iIndexOfChild2 = viewGroup.indexOfChild(fragment.mView);
                if (iIndexOfChild2 < iIndexOfChild) {
                    viewGroup.removeViewAt(iIndexOfChild2);
                    viewGroup.addView(fragment.mView, iIndexOfChild);
                }
            }
            if (fragment.mIsNewlyAdded && fragment.mContainer != null) {
                if (fragment.mPostponedAlpha > 0.0f) {
                    fragment.mView.setAlpha(fragment.mPostponedAlpha);
                }
                fragment.mPostponedAlpha = 0.0f;
                fragment.mIsNewlyAdded = false;
                androidx.fragment.app.i_renamed.a_renamed aVarA = a_renamed(fragment, fragment.getNextTransition(), true, fragment.getNextTransitionStyle());
                if (aVarA != null) {
                    if (aVarA.f1157a != null) {
                        fragment.mView.startAnimation(aVarA.f1157a);
                    } else {
                        aVarA.f1158b.setTarget(fragment.mView);
                        aVarA.f1158b.start();
                    }
                }
            }
        }
        if (fragment.mHiddenChanged) {
            i_renamed(fragment);
        }
    }

    void a_renamed(int i_renamed, boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        androidx.fragment.app.g_renamed gVar;
        if (this.n_renamed == null && i_renamed != 0) {
            throw new java.lang.IllegalStateException("No activity");
        }
        if (z_renamed || i_renamed != this.m_renamed) {
            this.m_renamed = i_renamed;
            int size = this.f_renamed.size();
            for (int i2 = 0; i2 < size; i2++) {
                j_renamed(this.f_renamed.get(i2));
            }
            for (androidx.fragment.app.Fragment fragment : this.g_renamed.values()) {
                if (fragment != null && (fragment.mRemoving || fragment.mDetached)) {
                    if (!fragment.mIsNewlyAdded) {
                        j_renamed(fragment);
                    }
                }
            }
            j_renamed();
            if (this.r_renamed && (gVar = this.n_renamed) != null && this.m_renamed == 4) {
                gVar.e_renamed();
                this.r_renamed = false;
            }
        }
    }

    void j_renamed() {
        for (androidx.fragment.app.Fragment fragment : this.g_renamed.values()) {
            if (fragment != null) {
                f_renamed(fragment);
            }
        }
    }

    void k_renamed(androidx.fragment.app.Fragment fragment) {
        if (this.g_renamed.get(fragment.mWho) != null) {
            return;
        }
        this.g_renamed.put(fragment.mWho, fragment);
        if (fragment.mRetainInstanceChangedWhileDetached) {
            if (fragment.mRetainInstance) {
                d_renamed(fragment);
            } else {
                e_renamed(fragment);
            }
            fragment.mRetainInstanceChangedWhileDetached = false;
        }
        if (f1142b) {
            android.util.Log.v_renamed("FragmentManager", "Added fragment to active set " + fragment);
        }
    }

    void l_renamed(androidx.fragment.app.Fragment fragment) {
        if (this.g_renamed.get(fragment.mWho) == null) {
            return;
        }
        if (f1142b) {
            android.util.Log.v_renamed("FragmentManager", "Removed fragment from active set " + fragment);
        }
        for (androidx.fragment.app.Fragment fragment2 : this.g_renamed.values()) {
            if (fragment2 != null && fragment.mWho.equals(fragment2.mTargetWho)) {
                fragment2.mTarget = fragment;
                fragment2.mTargetWho = null;
            }
        }
        this.g_renamed.put(fragment.mWho, null);
        e_renamed(fragment);
        if (fragment.mTargetWho != null) {
            fragment.mTarget = this.g_renamed.get(fragment.mTargetWho);
        }
        fragment.initState();
    }

    public void a_renamed(androidx.fragment.app.Fragment fragment, boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        if (f1142b) {
            android.util.Log.v_renamed("FragmentManager", "add: " + fragment);
        }
        k_renamed(fragment);
        if (fragment.mDetached) {
            return;
        }
        if (this.f_renamed.contains(fragment)) {
            throw new java.lang.IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.f_renamed) {
            this.f_renamed.add(fragment);
        }
        fragment.mAdded = true;
        fragment.mRemoving = false;
        if (fragment.mView == null) {
            fragment.mHiddenChanged = false;
        }
        if (w_renamed(fragment)) {
            this.r_renamed = true;
        }
        if (z_renamed) {
            g_renamed(fragment);
        }
    }

    public void m_renamed(androidx.fragment.app.Fragment fragment) {
        if (f1142b) {
            android.util.Log.v_renamed("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean z_renamed = !fragment.isInBackStack();
        if (!fragment.mDetached || z_renamed) {
            synchronized (this.f_renamed) {
                this.f_renamed.remove(fragment);
            }
            if (w_renamed(fragment)) {
                this.r_renamed = true;
            }
            fragment.mAdded = false;
            fragment.mRemoving = true;
        }
    }

    public void n_renamed(androidx.fragment.app.Fragment fragment) {
        if (f1142b) {
            android.util.Log.v_renamed("FragmentManager", "hide: " + fragment);
        }
        if (fragment.mHidden) {
            return;
        }
        fragment.mHidden = true;
        fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
    }

    public void o_renamed(androidx.fragment.app.Fragment fragment) {
        if (f1142b) {
            android.util.Log.v_renamed("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    public void p_renamed(androidx.fragment.app.Fragment fragment) {
        if (f1142b) {
            android.util.Log.v_renamed("FragmentManager", "detach: " + fragment);
        }
        if (fragment.mDetached) {
            return;
        }
        fragment.mDetached = true;
        if (fragment.mAdded) {
            if (f1142b) {
                android.util.Log.v_renamed("FragmentManager", "remove from detach: " + fragment);
            }
            synchronized (this.f_renamed) {
                this.f_renamed.remove(fragment);
            }
            if (w_renamed(fragment)) {
                this.r_renamed = true;
            }
            fragment.mAdded = false;
        }
    }

    public void q_renamed(androidx.fragment.app.Fragment fragment) {
        if (f1142b) {
            android.util.Log.v_renamed("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            if (this.f_renamed.contains(fragment)) {
                throw new java.lang.IllegalStateException("Fragment already added: " + fragment);
            }
            if (f1142b) {
                android.util.Log.v_renamed("FragmentManager", "add from attach: " + fragment);
            }
            synchronized (this.f_renamed) {
                this.f_renamed.add(fragment);
            }
            fragment.mAdded = true;
            if (w_renamed(fragment)) {
                this.r_renamed = true;
            }
        }
    }

    public androidx.fragment.app.Fragment b_renamed(int i_renamed) {
        for (int size = this.f_renamed.size() - 1; size >= 0; size--) {
            androidx.fragment.app.Fragment fragment = this.f_renamed.get(size);
            if (fragment != null && fragment.mFragmentId == i_renamed) {
                return fragment;
            }
        }
        for (androidx.fragment.app.Fragment fragment2 : this.g_renamed.values()) {
            if (fragment2 != null && fragment2.mFragmentId == i_renamed) {
                return fragment2;
            }
        }
        return null;
    }

    @Override // androidx.fragment.app.h_renamed
    public androidx.fragment.app.Fragment a_renamed(java.lang.String str) {
        if (str != null) {
            for (int size = this.f_renamed.size() - 1; size >= 0; size--) {
                androidx.fragment.app.Fragment fragment = this.f_renamed.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (androidx.fragment.app.Fragment fragment2 : this.g_renamed.values()) {
            if (fragment2 != null && str.equals(fragment2.mTag)) {
                return fragment2;
            }
        }
        return null;
    }

    public androidx.fragment.app.Fragment b_renamed(java.lang.String str) {
        androidx.fragment.app.Fragment fragmentFindFragmentByWho;
        for (androidx.fragment.app.Fragment fragment : this.g_renamed.values()) {
            if (fragment != null && (fragmentFindFragmentByWho = fragment.findFragmentByWho(str)) != null) {
                return fragmentFindFragmentByWho;
            }
        }
        return null;
    }

    private void E_renamed() {
        if (g_renamed()) {
            throw new java.lang.IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    @Override // androidx.fragment.app.h_renamed
    public boolean g_renamed() {
        return this.s_renamed || this.t_renamed;
    }

    public void a_renamed(androidx.fragment.app.i_renamed.e_renamed eVar, boolean z_renamed) {
        if (!z_renamed) {
            E_renamed();
        }
        synchronized (this) {
            if (!this.u_renamed && this.n_renamed != null) {
                if (this.f1143c == null) {
                    this.f1143c = new java.util.ArrayList<>();
                }
                this.f1143c.add(eVar);
                k_renamed();
                return;
            }
            if (!z_renamed) {
                throw new java.lang.IllegalStateException("Activity has been destroyed");
            }
        }
    }

    void k_renamed() {
        synchronized (this) {
            boolean z_renamed = false;
            boolean z2 = (this.B_renamed == null || this.B_renamed.isEmpty()) ? false : true;
            if (this.f1143c != null && this.f1143c.size() == 1) {
                z_renamed = true;
            }
            if (z2 || z_renamed) {
                this.n_renamed.k_renamed().removeCallbacks(this.C_renamed);
                this.n_renamed.k_renamed().post(this.C_renamed);
                D_renamed();
            }
        }
    }

    public int a_renamed(androidx.fragment.app.a_renamed aVar) {
        synchronized (this) {
            if (this.k_renamed != null && this.k_renamed.size() > 0) {
                int iIntValue = this.k_renamed.remove(this.k_renamed.size() - 1).intValue();
                if (f1142b) {
                    android.util.Log.v_renamed("FragmentManager", "Adding back stack index " + iIntValue + " with " + aVar);
                }
                this.j_renamed.set(iIntValue, aVar);
                return iIntValue;
            }
            if (this.j_renamed == null) {
                this.j_renamed = new java.util.ArrayList<>();
            }
            int size = this.j_renamed.size();
            if (f1142b) {
                android.util.Log.v_renamed("FragmentManager", "Setting back stack index " + size + " to " + aVar);
            }
            this.j_renamed.add(aVar);
            return size;
        }
    }

    public void a_renamed(int i_renamed, androidx.fragment.app.a_renamed aVar) {
        synchronized (this) {
            if (this.j_renamed == null) {
                this.j_renamed = new java.util.ArrayList<>();
            }
            int size = this.j_renamed.size();
            if (i_renamed < size) {
                if (f1142b) {
                    android.util.Log.v_renamed("FragmentManager", "Setting back stack index " + i_renamed + " to " + aVar);
                }
                this.j_renamed.set(i_renamed, aVar);
            } else {
                while (size < i_renamed) {
                    this.j_renamed.add(null);
                    if (this.k_renamed == null) {
                        this.k_renamed = new java.util.ArrayList<>();
                    }
                    if (f1142b) {
                        android.util.Log.v_renamed("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.k_renamed.add(java.lang.Integer.valueOf(size));
                    size++;
                }
                if (f1142b) {
                    android.util.Log.v_renamed("FragmentManager", "Adding back stack index " + i_renamed + " with " + aVar);
                }
                this.j_renamed.add(aVar);
            }
        }
    }

    public void c_renamed(int i_renamed) {
        synchronized (this) {
            this.j_renamed.set(i_renamed, null);
            if (this.k_renamed == null) {
                this.k_renamed = new java.util.ArrayList<>();
            }
            if (f1142b) {
                android.util.Log.v_renamed("FragmentManager", "Freeing back stack index " + i_renamed);
            }
            this.k_renamed.add(java.lang.Integer.valueOf(i_renamed));
        }
    }

    private void c_renamed(boolean z_renamed) {
        if (this.d_renamed) {
            throw new java.lang.IllegalStateException("FragmentManager is_renamed already executing transactions");
        }
        if (this.n_renamed == null) {
            throw new java.lang.IllegalStateException("Fragment host has been destroyed");
        }
        if (android.os.Looper.myLooper() != this.n_renamed.k_renamed().getLooper()) {
            throw new java.lang.IllegalStateException("Must be_renamed called from main thread of_renamed fragment host");
        }
        if (!z_renamed) {
            E_renamed();
        }
        if (this.w_renamed == null) {
            this.w_renamed = new java.util.ArrayList<>();
            this.x_renamed = new java.util.ArrayList<>();
        }
        this.d_renamed = true;
        try {
            a_renamed((java.util.ArrayList<androidx.fragment.app.a_renamed>) null, (java.util.ArrayList<java.lang.Boolean>) null);
        } finally {
            this.d_renamed = false;
        }
    }

    public void b_renamed(androidx.fragment.app.i_renamed.e_renamed eVar, boolean z_renamed) {
        if (z_renamed && (this.n_renamed == null || this.u_renamed)) {
            return;
        }
        c_renamed(z_renamed);
        if (eVar.a_renamed(this.w_renamed, this.x_renamed)) {
            this.d_renamed = true;
            try {
                b_renamed(this.w_renamed, this.x_renamed);
            } finally {
                F_renamed();
            }
        }
        D_renamed();
        m_renamed();
        I_renamed();
    }

    private void F_renamed() {
        this.d_renamed = false;
        this.x_renamed.clear();
        this.w_renamed.clear();
    }

    public boolean l_renamed() {
        c_renamed(true);
        boolean z_renamed = false;
        while (c_renamed(this.w_renamed, this.x_renamed)) {
            this.d_renamed = true;
            try {
                b_renamed(this.w_renamed, this.x_renamed);
                F_renamed();
                z_renamed = true;
            } catch (java.lang.Throwable th) {
                F_renamed();
                throw th;
            }
        }
        D_renamed();
        m_renamed();
        I_renamed();
        return z_renamed;
    }

    private void a_renamed(java.util.ArrayList<androidx.fragment.app.a_renamed> arrayList, java.util.ArrayList<java.lang.Boolean> arrayList2) throws android.content.res.Resources.NotFoundException {
        int iIndexOf;
        int iIndexOf2;
        java.util.ArrayList<androidx.fragment.app.i_renamed.g_renamed> arrayList3 = this.B_renamed;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i_renamed = 0;
        while (i_renamed < size) {
            androidx.fragment.app.i_renamed.g_renamed gVar = this.B_renamed.get(i_renamed);
            if (arrayList != null && !gVar.f1168a && (iIndexOf2 = arrayList.indexOf(gVar.f1169b)) != -1 && arrayList2.get(iIndexOf2).booleanValue()) {
                this.B_renamed.remove(i_renamed);
                i_renamed--;
                size--;
                gVar.e_renamed();
            } else if (gVar.c_renamed() || (arrayList != null && gVar.f1169b.a_renamed(arrayList, 0, arrayList.size()))) {
                this.B_renamed.remove(i_renamed);
                i_renamed--;
                size--;
                if (arrayList != null && !gVar.f1168a && (iIndexOf = arrayList.indexOf(gVar.f1169b)) != -1 && arrayList2.get(iIndexOf).booleanValue()) {
                    gVar.e_renamed();
                } else {
                    gVar.d_renamed();
                }
            }
            i_renamed++;
        }
    }

    private void b_renamed(java.util.ArrayList<androidx.fragment.app.a_renamed> arrayList, java.util.ArrayList<java.lang.Boolean> arrayList2) throws android.content.res.Resources.NotFoundException {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (arrayList2 == null || arrayList.size() != arrayList2.size()) {
            throw new java.lang.IllegalStateException("Internal error with the back stack records");
        }
        a_renamed(arrayList, arrayList2);
        int size = arrayList.size();
        int i_renamed = 0;
        int i2 = 0;
        while (i_renamed < size) {
            if (!arrayList.get(i_renamed).t_renamed) {
                if (i2 != i_renamed) {
                    a_renamed(arrayList, arrayList2, i2, i_renamed);
                }
                i2 = i_renamed + 1;
                if (arrayList2.get(i_renamed).booleanValue()) {
                    while (i2 < size && arrayList2.get(i2).booleanValue() && !arrayList.get(i2).t_renamed) {
                        i2++;
                    }
                }
                a_renamed(arrayList, arrayList2, i_renamed, i2);
                i_renamed = i2 - 1;
            }
            i_renamed++;
        }
        if (i2 != size) {
            a_renamed(arrayList, arrayList2, i2, size);
        }
    }

    private void a_renamed(java.util.ArrayList<androidx.fragment.app.a_renamed> arrayList, java.util.ArrayList<java.lang.Boolean> arrayList2, int i_renamed, int i2) throws android.content.res.Resources.NotFoundException {
        int i3;
        int i4 = i_renamed;
        boolean z_renamed = arrayList.get(i4).t_renamed;
        java.util.ArrayList<androidx.fragment.app.Fragment> arrayList3 = this.y_renamed;
        if (arrayList3 == null) {
            this.y_renamed = new java.util.ArrayList<>();
        } else {
            arrayList3.clear();
        }
        this.y_renamed.addAll(this.f_renamed);
        androidx.fragment.app.Fragment fragmentA = A_renamed();
        boolean z2 = false;
        for (int i5 = i4; i5 < i2; i5++) {
            androidx.fragment.app.a_renamed aVar = arrayList.get(i5);
            if (!arrayList2.get(i5).booleanValue()) {
                fragmentA = aVar.a_renamed(this.y_renamed, fragmentA);
            } else {
                fragmentA = aVar.b_renamed(this.y_renamed, fragmentA);
            }
            z2 = z2 || aVar.k_renamed;
        }
        this.y_renamed.clear();
        if (!z_renamed) {
            androidx.fragment.app.l_renamed.a_renamed(this, arrayList, arrayList2, i_renamed, i2, false);
        }
        b_renamed(arrayList, arrayList2, i_renamed, i2);
        if (z_renamed) {
            androidx.collection.ArraySet<androidx.fragment.app.Fragment> arraySet = new androidx.collection.ArraySet<>();
            b_renamed(arraySet);
            int iA = a_renamed(arrayList, arrayList2, i_renamed, i2, arraySet);
            a_renamed(arraySet);
            i3 = iA;
        } else {
            i3 = i2;
        }
        if (i3 != i4 && z_renamed) {
            androidx.fragment.app.l_renamed.a_renamed(this, arrayList, arrayList2, i_renamed, i3, true);
            a_renamed(this.m_renamed, true);
        }
        while (i4 < i2) {
            androidx.fragment.app.a_renamed aVar2 = arrayList.get(i4);
            if (arrayList2.get(i4).booleanValue() && aVar2.f1132c >= 0) {
                c_renamed(aVar2.f1132c);
                aVar2.f1132c = -1;
            }
            aVar2.a_renamed();
            i4++;
        }
        if (z2) {
            n_renamed();
        }
    }

    private void a_renamed(androidx.collection.ArraySet<androidx.fragment.app.Fragment> arraySet) {
        int size = arraySet.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            androidx.fragment.app.Fragment fragmentValueAt = arraySet.valueAt(i_renamed);
            if (!fragmentValueAt.mAdded) {
                android.view.View viewRequireView = fragmentValueAt.requireView();
                fragmentValueAt.mPostponedAlpha = viewRequireView.getAlpha();
                viewRequireView.setAlpha(0.0f);
            }
        }
    }

    private int a_renamed(java.util.ArrayList<androidx.fragment.app.a_renamed> arrayList, java.util.ArrayList<java.lang.Boolean> arrayList2, int i_renamed, int i2, androidx.collection.ArraySet<androidx.fragment.app.Fragment> arraySet) throws android.content.res.Resources.NotFoundException {
        int i3 = i2;
        for (int i4 = i2 - 1; i4 >= i_renamed; i4--) {
            androidx.fragment.app.a_renamed aVar = arrayList.get(i4);
            boolean zBooleanValue = arrayList2.get(i4).booleanValue();
            if (aVar.f_renamed() && !aVar.a_renamed(arrayList, i4 + 1, i2)) {
                if (this.B_renamed == null) {
                    this.B_renamed = new java.util.ArrayList<>();
                }
                androidx.fragment.app.i_renamed.g_renamed gVar = new androidx.fragment.app.i_renamed.g_renamed(aVar, zBooleanValue);
                this.B_renamed.add(gVar);
                aVar.a_renamed(gVar);
                if (zBooleanValue) {
                    aVar.e_renamed();
                } else {
                    aVar.b_renamed(false);
                }
                i3--;
                if (i4 != i3) {
                    arrayList.remove(i4);
                    arrayList.add(i3, aVar);
                }
                b_renamed(arraySet);
            }
        }
        return i3;
    }

    void a_renamed(androidx.fragment.app.a_renamed aVar, boolean z_renamed, boolean z2, boolean z3) throws android.content.res.Resources.NotFoundException {
        if (z_renamed) {
            aVar.b_renamed(z3);
        } else {
            aVar.e_renamed();
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(1);
        java.util.ArrayList arrayList2 = new java.util.ArrayList(1);
        arrayList.add(aVar);
        arrayList2.add(java.lang.Boolean.valueOf(z_renamed));
        if (z2) {
            androidx.fragment.app.l_renamed.a_renamed(this, (java.util.ArrayList<androidx.fragment.app.a_renamed>) arrayList, (java.util.ArrayList<java.lang.Boolean>) arrayList2, 0, 1, true);
        }
        if (z3) {
            a_renamed(this.m_renamed, true);
        }
        for (androidx.fragment.app.Fragment fragment : this.g_renamed.values()) {
            if (fragment != null && fragment.mView != null && fragment.mIsNewlyAdded && aVar.b_renamed(fragment.mContainerId)) {
                if (fragment.mPostponedAlpha > 0.0f) {
                    fragment.mView.setAlpha(fragment.mPostponedAlpha);
                }
                if (z3) {
                    fragment.mPostponedAlpha = 0.0f;
                } else {
                    fragment.mPostponedAlpha = -1.0f;
                    fragment.mIsNewlyAdded = false;
                }
            }
        }
    }

    private androidx.fragment.app.Fragment u_renamed(androidx.fragment.app.Fragment fragment) {
        android.view.ViewGroup viewGroup = fragment.mContainer;
        android.view.View view = fragment.mView;
        if (viewGroup != null && view != null) {
            for (int iIndexOf = this.f_renamed.indexOf(fragment) - 1; iIndexOf >= 0; iIndexOf--) {
                androidx.fragment.app.Fragment fragment2 = this.f_renamed.get(iIndexOf);
                if (fragment2.mContainer == viewGroup && fragment2.mView != null) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    private static void b_renamed(java.util.ArrayList<androidx.fragment.app.a_renamed> arrayList, java.util.ArrayList<java.lang.Boolean> arrayList2, int i_renamed, int i2) {
        while (i_renamed < i2) {
            androidx.fragment.app.a_renamed aVar = arrayList.get(i_renamed);
            if (arrayList2.get(i_renamed).booleanValue()) {
                aVar.a_renamed(-1);
                aVar.b_renamed(i_renamed == i2 + (-1));
            } else {
                aVar.a_renamed(1);
                aVar.e_renamed();
            }
            i_renamed++;
        }
    }

    private void b_renamed(androidx.collection.ArraySet<androidx.fragment.app.Fragment> arraySet) throws android.content.res.Resources.NotFoundException {
        int i_renamed = this.m_renamed;
        if (i_renamed < 1) {
            return;
        }
        int iMin = java.lang.Math.min(i_renamed, 3);
        int size = this.f_renamed.size();
        for (int i2 = 0; i2 < size; i2++) {
            androidx.fragment.app.Fragment fragment = this.f_renamed.get(i2);
            if (fragment.mState < iMin) {
                a_renamed(fragment, iMin, fragment.getNextAnim(), fragment.getNextTransition(), false);
                if (fragment.mView != null && !fragment.mHidden && fragment.mIsNewlyAdded) {
                    arraySet.add(fragment);
                }
            }
        }
    }

    private void G_renamed() throws android.content.res.Resources.NotFoundException {
        if (this.B_renamed != null) {
            while (!this.B_renamed.isEmpty()) {
                this.B_renamed.remove(0).d_renamed();
            }
        }
    }

    private void H_renamed() throws android.content.res.Resources.NotFoundException {
        for (androidx.fragment.app.Fragment fragment : this.g_renamed.values()) {
            if (fragment != null) {
                if (fragment.getAnimatingAway() != null) {
                    int stateAfterAnimating = fragment.getStateAfterAnimating();
                    android.view.View animatingAway = fragment.getAnimatingAway();
                    android.view.animation.Animation animation = animatingAway.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        animatingAway.clearAnimation();
                    }
                    fragment.setAnimatingAway(null);
                    a_renamed(fragment, stateAfterAnimating, 0, 0, false);
                } else if (fragment.getAnimator() != null) {
                    fragment.getAnimator().end();
                }
            }
        }
    }

    private boolean c_renamed(java.util.ArrayList<androidx.fragment.app.a_renamed> arrayList, java.util.ArrayList<java.lang.Boolean> arrayList2) {
        synchronized (this) {
            if (this.f1143c != null && this.f1143c.size() != 0) {
                int size = this.f1143c.size();
                boolean zA = false;
                for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                    zA |= this.f1143c.get(i_renamed).a_renamed(arrayList, arrayList2);
                }
                this.f1143c.clear();
                this.n_renamed.k_renamed().removeCallbacks(this.C_renamed);
                return zA;
            }
            return false;
        }
    }

    void m_renamed() {
        if (this.v_renamed) {
            this.v_renamed = false;
            j_renamed();
        }
    }

    void n_renamed() {
        if (this.l_renamed != null) {
            for (int i_renamed = 0; i_renamed < this.l_renamed.size(); i_renamed++) {
                this.l_renamed.get(i_renamed).a_renamed();
            }
        }
    }

    void b_renamed(androidx.fragment.app.a_renamed aVar) {
        if (this.h_renamed == null) {
            this.h_renamed = new java.util.ArrayList<>();
        }
        this.h_renamed.add(aVar);
    }

    boolean a_renamed(java.util.ArrayList<androidx.fragment.app.a_renamed> arrayList, java.util.ArrayList<java.lang.Boolean> arrayList2, java.lang.String str, int i_renamed, int i2) {
        int size;
        java.util.ArrayList<androidx.fragment.app.a_renamed> arrayList3 = this.h_renamed;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i_renamed < 0 && (i2 & 1) == 0) {
            int size2 = arrayList3.size() - 1;
            if (size2 < 0) {
                return false;
            }
            arrayList.add(this.h_renamed.remove(size2));
            arrayList2.add(true);
        } else {
            if (str != null || i_renamed >= 0) {
                size = this.h_renamed.size() - 1;
                while (size >= 0) {
                    androidx.fragment.app.a_renamed aVar = this.h_renamed.get(size);
                    if ((str != null && str.equals(aVar.g_renamed())) || (i_renamed >= 0 && i_renamed == aVar.f1132c)) {
                        break;
                    }
                    size--;
                }
                if (size < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    while (true) {
                        size--;
                        if (size < 0) {
                            break;
                        }
                        androidx.fragment.app.a_renamed aVar2 = this.h_renamed.get(size);
                        if (str == null || !str.equals(aVar2.g_renamed())) {
                            if (i_renamed < 0 || i_renamed != aVar2.f1132c) {
                                break;
                            }
                        }
                    }
                }
            } else {
                size = -1;
            }
            if (size == this.h_renamed.size() - 1) {
                return false;
            }
            for (int size3 = this.h_renamed.size() - 1; size3 > size; size3--) {
                arrayList.add(this.h_renamed.remove(size3));
                arrayList2.add(true);
            }
        }
        return true;
    }

    void r_renamed(androidx.fragment.app.Fragment fragment) {
        if (fragment.mInnerView == null) {
            return;
        }
        android.util.SparseArray<android.os.Parcelable> sparseArray = this.A_renamed;
        if (sparseArray == null) {
            this.A_renamed = new android.util.SparseArray<>();
        } else {
            sparseArray.clear();
        }
        fragment.mInnerView.saveHierarchyState(this.A_renamed);
        if (this.A_renamed.size() > 0) {
            fragment.mSavedViewState = this.A_renamed;
            this.A_renamed = null;
        }
    }

    android.os.Bundle s_renamed(androidx.fragment.app.Fragment fragment) {
        android.os.Bundle bundle;
        if (this.z_renamed == null) {
            this.z_renamed = new android.os.Bundle();
        }
        fragment.performSaveInstanceState(this.z_renamed);
        d_renamed(fragment, this.z_renamed, false);
        if (this.z_renamed.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.z_renamed;
            this.z_renamed = null;
        }
        if (fragment.mView != null) {
            r_renamed(fragment);
        }
        if (fragment.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new android.os.Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.mSavedViewState);
        }
        if (!fragment.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new android.os.Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.mUserVisibleHint);
        }
        return bundle;
    }

    android.os.Parcelable o_renamed() {
        java.util.ArrayList<java.lang.String> arrayList;
        int size;
        G_renamed();
        H_renamed();
        l_renamed();
        this.s_renamed = true;
        androidx.fragment.app.BackStackState[] backStackStateArr = null;
        if (this.g_renamed.isEmpty()) {
            return null;
        }
        java.util.ArrayList<androidx.fragment.app.FragmentState> arrayList2 = new java.util.ArrayList<>(this.g_renamed.size());
        boolean z_renamed = false;
        for (androidx.fragment.app.Fragment fragment : this.g_renamed.values()) {
            if (fragment != null) {
                if (fragment.mFragmentManager != this) {
                    a_renamed(new java.lang.IllegalStateException("Failure saving state: active " + fragment + " was removed from the FragmentManager"));
                }
                androidx.fragment.app.FragmentState fragmentState = new androidx.fragment.app.FragmentState(fragment);
                arrayList2.add(fragmentState);
                if (fragment.mState > 0 && fragmentState.mSavedFragmentState == null) {
                    fragmentState.mSavedFragmentState = s_renamed(fragment);
                    if (fragment.mTargetWho != null) {
                        androidx.fragment.app.Fragment fragment2 = this.g_renamed.get(fragment.mTargetWho);
                        if (fragment2 == null) {
                            a_renamed(new java.lang.IllegalStateException("Failure saving state: " + fragment + " has target not in_renamed fragment manager: " + fragment.mTargetWho));
                        }
                        if (fragmentState.mSavedFragmentState == null) {
                            fragmentState.mSavedFragmentState = new android.os.Bundle();
                        }
                        a_renamed(fragmentState.mSavedFragmentState, "android:target_state", fragment2);
                        if (fragment.mTargetRequestCode != 0) {
                            fragmentState.mSavedFragmentState.putInt("android:target_req_state", fragment.mTargetRequestCode);
                        }
                    }
                } else {
                    fragmentState.mSavedFragmentState = fragment.mSavedFragmentState;
                }
                if (f1142b) {
                    android.util.Log.v_renamed("FragmentManager", "Saved state of_renamed " + fragment + ": " + fragmentState.mSavedFragmentState);
                }
                z_renamed = true;
            }
        }
        if (!z_renamed) {
            if (f1142b) {
                android.util.Log.v_renamed("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        int size2 = this.f_renamed.size();
        if (size2 > 0) {
            arrayList = new java.util.ArrayList<>(size2);
            java.util.Iterator<androidx.fragment.app.Fragment> it = this.f_renamed.iterator();
            while (it.hasNext()) {
                androidx.fragment.app.Fragment next = it.next();
                arrayList.add(next.mWho);
                if (next.mFragmentManager != this) {
                    a_renamed(new java.lang.IllegalStateException("Failure saving state: active " + next + " was removed from the FragmentManager"));
                }
                if (f1142b) {
                    android.util.Log.v_renamed("FragmentManager", "saveAllState: adding fragment (" + next.mWho + "): " + next);
                }
            }
        } else {
            arrayList = null;
        }
        java.util.ArrayList<androidx.fragment.app.a_renamed> arrayList3 = this.h_renamed;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            backStackStateArr = new androidx.fragment.app.BackStackState[size];
            for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                backStackStateArr[i_renamed] = new androidx.fragment.app.BackStackState(this.h_renamed.get(i_renamed));
                if (f1142b) {
                    android.util.Log.v_renamed("FragmentManager", "saveAllState: adding back stack #" + i_renamed + ": " + this.h_renamed.get(i_renamed));
                }
            }
        }
        androidx.fragment.app.FragmentManagerState fragmentManagerState = new androidx.fragment.app.FragmentManagerState();
        fragmentManagerState.mActive = arrayList2;
        fragmentManagerState.mAdded = arrayList;
        fragmentManagerState.mBackStack = backStackStateArr;
        androidx.fragment.app.Fragment fragment3 = this.q_renamed;
        if (fragment3 != null) {
            fragmentManagerState.mPrimaryNavActiveWho = fragment3.mWho;
        }
        fragmentManagerState.mNextFragmentIndex = this.e_renamed;
        return fragmentManagerState;
    }

    void a_renamed(android.os.Parcelable parcelable) {
        androidx.fragment.app.FragmentState next;
        if (parcelable == null) {
            return;
        }
        androidx.fragment.app.FragmentManagerState fragmentManagerState = (androidx.fragment.app.FragmentManagerState) parcelable;
        if (fragmentManagerState.mActive == null) {
            return;
        }
        for (androidx.fragment.app.Fragment fragment : this.I_renamed.c_renamed()) {
            if (f1142b) {
                android.util.Log.v_renamed("FragmentManager", "restoreSaveState: re-attaching retained " + fragment);
            }
            java.util.Iterator<androidx.fragment.app.FragmentState> it = fragmentManagerState.mActive.iterator();
            while (true) {
                if (it.hasNext()) {
                    next = it.next();
                    if (next.mWho.equals(fragment.mWho)) {
                        break;
                    }
                } else {
                    next = null;
                    break;
                }
            }
            if (next == null) {
                if (f1142b) {
                    android.util.Log.v_renamed("FragmentManager", "Discarding retained Fragment " + fragment + " that was not found in_renamed the set of_renamed active Fragments " + fragmentManagerState.mActive);
                }
                a_renamed(fragment, 1, 0, 0, false);
                fragment.mRemoving = true;
                a_renamed(fragment, 0, 0, 0, false);
            } else {
                next.mInstance = fragment;
                fragment.mSavedViewState = null;
                fragment.mBackStackNesting = 0;
                fragment.mInLayout = false;
                fragment.mAdded = false;
                fragment.mTargetWho = fragment.mTarget != null ? fragment.mTarget.mWho : null;
                fragment.mTarget = null;
                if (next.mSavedFragmentState != null) {
                    next.mSavedFragmentState.setClassLoader(this.n_renamed.j_renamed().getClassLoader());
                    fragment.mSavedViewState = next.mSavedFragmentState.getSparseParcelableArray("android:view_state");
                    fragment.mSavedFragmentState = next.mSavedFragmentState;
                }
            }
        }
        this.g_renamed.clear();
        java.util.Iterator<androidx.fragment.app.FragmentState> it2 = fragmentManagerState.mActive.iterator();
        while (it2.hasNext()) {
            androidx.fragment.app.FragmentState next2 = it2.next();
            if (next2 != null) {
                androidx.fragment.app.Fragment fragmentInstantiate = next2.instantiate(this.n_renamed.j_renamed().getClassLoader(), f_renamed());
                fragmentInstantiate.mFragmentManager = this;
                if (f1142b) {
                    android.util.Log.v_renamed("FragmentManager", "restoreSaveState: active (" + fragmentInstantiate.mWho + "): " + fragmentInstantiate);
                }
                this.g_renamed.put(fragmentInstantiate.mWho, fragmentInstantiate);
                next2.mInstance = null;
            }
        }
        this.f_renamed.clear();
        if (fragmentManagerState.mAdded != null) {
            java.util.Iterator<java.lang.String> it3 = fragmentManagerState.mAdded.iterator();
            while (it3.hasNext()) {
                java.lang.String next3 = it3.next();
                androidx.fragment.app.Fragment fragment2 = this.g_renamed.get(next3);
                if (fragment2 == null) {
                    a_renamed(new java.lang.IllegalStateException("No instantiated fragment for (" + next3 + ")"));
                }
                fragment2.mAdded = true;
                if (f1142b) {
                    android.util.Log.v_renamed("FragmentManager", "restoreSaveState: added (" + next3 + "): " + fragment2);
                }
                if (this.f_renamed.contains(fragment2)) {
                    throw new java.lang.IllegalStateException("Already added " + fragment2);
                }
                synchronized (this.f_renamed) {
                    this.f_renamed.add(fragment2);
                }
            }
        }
        if (fragmentManagerState.mBackStack != null) {
            this.h_renamed = new java.util.ArrayList<>(fragmentManagerState.mBackStack.length);
            for (int i_renamed = 0; i_renamed < fragmentManagerState.mBackStack.length; i_renamed++) {
                androidx.fragment.app.a_renamed aVarInstantiate = fragmentManagerState.mBackStack[i_renamed].instantiate(this);
                if (f1142b) {
                    android.util.Log.v_renamed("FragmentManager", "restoreAllState: back stack #" + i_renamed + " (index " + aVarInstantiate.f1132c + "): " + aVarInstantiate);
                    java.io.PrintWriter printWriter = new java.io.PrintWriter(new androidx.core.g_renamed.b_renamed("FragmentManager"));
                    aVarInstantiate.a_renamed("  ", printWriter, false);
                    printWriter.close();
                }
                this.h_renamed.add(aVarInstantiate);
                if (aVarInstantiate.f1132c >= 0) {
                    a_renamed(aVarInstantiate.f1132c, aVarInstantiate);
                }
            }
        } else {
            this.h_renamed = null;
        }
        if (fragmentManagerState.mPrimaryNavActiveWho != null) {
            this.q_renamed = this.g_renamed.get(fragmentManagerState.mPrimaryNavActiveWho);
            v_renamed(this.q_renamed);
        }
        this.e_renamed = fragmentManagerState.mNextFragmentIndex;
    }

    private void I_renamed() {
        this.g_renamed.values().removeAll(java.util.Collections.singleton(null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a_renamed(androidx.fragment.app.g_renamed gVar, androidx.fragment.app.d_renamed dVar, androidx.fragment.app.Fragment fragment) {
        if (this.n_renamed != null) {
            throw new java.lang.IllegalStateException("Already attached");
        }
        this.n_renamed = gVar;
        this.o_renamed = dVar;
        this.p_renamed = fragment;
        if (this.p_renamed != null) {
            D_renamed();
        }
        if (gVar instanceof androidx.activity.d_renamed) {
            androidx.activity.d_renamed dVar2 = (androidx.activity.d_renamed) gVar;
            this.F_renamed = dVar2.b_renamed();
            androidx.fragment.app.Fragment fragment2 = dVar2;
            if (fragment != null) {
                fragment2 = fragment;
            }
            this.F_renamed.a_renamed(fragment2, this.G_renamed);
        }
        if (fragment != null) {
            this.I_renamed = fragment.mFragmentManager.c_renamed(fragment);
        } else if (gVar instanceof androidx.lifecycle.t_renamed) {
            this.I_renamed = androidx.fragment.app.j_renamed.a_renamed(((androidx.lifecycle.t_renamed) gVar).getViewModelStore());
        } else {
            this.I_renamed = new androidx.fragment.app.j_renamed(false);
        }
    }

    public void p_renamed() {
        this.s_renamed = false;
        this.t_renamed = false;
        int size = this.f_renamed.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            androidx.fragment.app.Fragment fragment = this.f_renamed.get(i_renamed);
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    public void q_renamed() {
        this.s_renamed = false;
        this.t_renamed = false;
        e_renamed(1);
    }

    public void r_renamed() {
        this.s_renamed = false;
        this.t_renamed = false;
        e_renamed(2);
    }

    public void s_renamed() {
        this.s_renamed = false;
        this.t_renamed = false;
        e_renamed(3);
    }

    public void t_renamed() {
        this.s_renamed = false;
        this.t_renamed = false;
        e_renamed(4);
    }

    public void u_renamed() {
        e_renamed(3);
    }

    public void v_renamed() {
        this.t_renamed = true;
        e_renamed(2);
    }

    public void w_renamed() {
        e_renamed(1);
    }

    public void x_renamed() {
        this.u_renamed = true;
        l_renamed();
        e_renamed(0);
        this.n_renamed = null;
        this.o_renamed = null;
        this.p_renamed = null;
        if (this.F_renamed != null) {
            this.G_renamed.b_renamed();
            this.F_renamed = null;
        }
    }

    private void e_renamed(int i_renamed) {
        try {
            this.d_renamed = true;
            a_renamed(i_renamed, false);
            this.d_renamed = false;
            l_renamed();
        } catch (java.lang.Throwable th) {
            this.d_renamed = false;
            throw th;
        }
    }

    public void a_renamed(boolean z_renamed) {
        for (int size = this.f_renamed.size() - 1; size >= 0; size--) {
            androidx.fragment.app.Fragment fragment = this.f_renamed.get(size);
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z_renamed);
            }
        }
    }

    public void b_renamed(boolean z_renamed) {
        for (int size = this.f_renamed.size() - 1; size >= 0; size--) {
            androidx.fragment.app.Fragment fragment = this.f_renamed.get(size);
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z_renamed);
            }
        }
    }

    public void a_renamed(android.content.res.Configuration configuration) {
        for (int i_renamed = 0; i_renamed < this.f_renamed.size(); i_renamed++) {
            androidx.fragment.app.Fragment fragment = this.f_renamed.get(i_renamed);
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
            }
        }
    }

    public void y_renamed() {
        for (int i_renamed = 0; i_renamed < this.f_renamed.size(); i_renamed++) {
            androidx.fragment.app.Fragment fragment = this.f_renamed.get(i_renamed);
            if (fragment != null) {
                fragment.performLowMemory();
            }
        }
    }

    public boolean a_renamed(android.view.Menu menu, android.view.MenuInflater menuInflater) {
        if (this.m_renamed < 1) {
            return false;
        }
        java.util.ArrayList<androidx.fragment.app.Fragment> arrayList = null;
        boolean z_renamed = false;
        for (int i_renamed = 0; i_renamed < this.f_renamed.size(); i_renamed++) {
            androidx.fragment.app.Fragment fragment = this.f_renamed.get(i_renamed);
            if (fragment != null && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new java.util.ArrayList<>();
                }
                arrayList.add(fragment);
                z_renamed = true;
            }
        }
        if (this.i_renamed != null) {
            for (int i2 = 0; i2 < this.i_renamed.size(); i2++) {
                androidx.fragment.app.Fragment fragment2 = this.i_renamed.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.i_renamed = arrayList;
        return z_renamed;
    }

    public boolean a_renamed(android.view.Menu menu) {
        if (this.m_renamed < 1) {
            return false;
        }
        boolean z_renamed = false;
        for (int i_renamed = 0; i_renamed < this.f_renamed.size(); i_renamed++) {
            androidx.fragment.app.Fragment fragment = this.f_renamed.get(i_renamed);
            if (fragment != null && fragment.performPrepareOptionsMenu(menu)) {
                z_renamed = true;
            }
        }
        return z_renamed;
    }

    public boolean a_renamed(android.view.MenuItem menuItem) {
        if (this.m_renamed < 1) {
            return false;
        }
        for (int i_renamed = 0; i_renamed < this.f_renamed.size(); i_renamed++) {
            androidx.fragment.app.Fragment fragment = this.f_renamed.get(i_renamed);
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public boolean b_renamed(android.view.MenuItem menuItem) {
        if (this.m_renamed < 1) {
            return false;
        }
        for (int i_renamed = 0; i_renamed < this.f_renamed.size(); i_renamed++) {
            androidx.fragment.app.Fragment fragment = this.f_renamed.get(i_renamed);
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void b_renamed(android.view.Menu menu) {
        if (this.m_renamed < 1) {
            return;
        }
        for (int i_renamed = 0; i_renamed < this.f_renamed.size(); i_renamed++) {
            androidx.fragment.app.Fragment fragment = this.f_renamed.get(i_renamed);
            if (fragment != null) {
                fragment.performOptionsMenuClosed(menu);
            }
        }
    }

    public void t_renamed(androidx.fragment.app.Fragment fragment) {
        if (fragment != null && (this.g_renamed.get(fragment.mWho) != fragment || (fragment.mHost != null && fragment.getFragmentManager() != this))) {
            throw new java.lang.IllegalArgumentException("Fragment " + fragment + " is_renamed not an_renamed active fragment of_renamed FragmentManager " + this);
        }
        androidx.fragment.app.Fragment fragment2 = this.q_renamed;
        this.q_renamed = fragment;
        v_renamed(fragment2);
        v_renamed(this.q_renamed);
    }

    private void v_renamed(androidx.fragment.app.Fragment fragment) {
        if (fragment == null || this.g_renamed.get(fragment.mWho) != fragment) {
            return;
        }
        fragment.performPrimaryNavigationFragmentChanged();
    }

    void z_renamed() {
        D_renamed();
        v_renamed(this.q_renamed);
    }

    public androidx.fragment.app.Fragment A_renamed() {
        return this.q_renamed;
    }

    public void a_renamed(androidx.fragment.app.Fragment fragment, androidx.lifecycle.e_renamed.b_renamed bVar) {
        if (this.g_renamed.get(fragment.mWho) != fragment || (fragment.mHost != null && fragment.getFragmentManager() != this)) {
            throw new java.lang.IllegalArgumentException("Fragment " + fragment + " is_renamed not an_renamed active fragment of_renamed FragmentManager " + this);
        }
        fragment.mMaxState = bVar;
    }

    @Override // androidx.fragment.app.h_renamed
    public androidx.fragment.app.f_renamed f_renamed() {
        if (super.f_renamed() == f1140a) {
            androidx.fragment.app.Fragment fragment = this.p_renamed;
            if (fragment != null) {
                return fragment.mFragmentManager.f_renamed();
            }
            a_renamed(new androidx.fragment.app.f_renamed() { // from class: androidx.fragment.app.i_renamed.6
                @Override // androidx.fragment.app.f_renamed
                public androidx.fragment.app.Fragment c_renamed(java.lang.ClassLoader classLoader, java.lang.String str) {
                    return androidx.fragment.app.i_renamed.this.n_renamed.a_renamed(androidx.fragment.app.i_renamed.this.n_renamed.j_renamed(), str, (android.os.Bundle) null);
                }
            });
        }
        return super.f_renamed();
    }

    @Override // androidx.fragment.app.h_renamed
    public void a_renamed(androidx.fragment.app.h_renamed.a_renamed aVar, boolean z_renamed) {
        this.H_renamed.add(new androidx.fragment.app.i_renamed.c_renamed(aVar, z_renamed));
    }

    @Override // androidx.fragment.app.h_renamed
    public void a_renamed(androidx.fragment.app.h_renamed.a_renamed aVar) {
        synchronized (this.H_renamed) {
            int i_renamed = 0;
            int size = this.H_renamed.size();
            while (true) {
                if (i_renamed >= size) {
                    break;
                }
                if (this.H_renamed.get(i_renamed).f1162a == aVar) {
                    this.H_renamed.remove(i_renamed);
                    break;
                }
                i_renamed++;
            }
        }
    }

    void a_renamed(androidx.fragment.app.Fragment fragment, android.content.Context context, boolean z_renamed) {
        androidx.fragment.app.Fragment fragment2 = this.p_renamed;
        if (fragment2 != null) {
            androidx.fragment.app.h_renamed fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof androidx.fragment.app.i_renamed) {
                ((androidx.fragment.app.i_renamed) fragmentManager).a_renamed(fragment, context, true);
            }
        }
        java.util.Iterator<androidx.fragment.app.i_renamed.c_renamed> it = this.H_renamed.iterator();
        while (it.hasNext()) {
            androidx.fragment.app.i_renamed.c_renamed next = it.next();
            if (!z_renamed || next.f1163b) {
                next.f1162a.a_renamed(this, fragment, context);
            }
        }
    }

    void b_renamed(androidx.fragment.app.Fragment fragment, android.content.Context context, boolean z_renamed) {
        androidx.fragment.app.Fragment fragment2 = this.p_renamed;
        if (fragment2 != null) {
            androidx.fragment.app.h_renamed fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof androidx.fragment.app.i_renamed) {
                ((androidx.fragment.app.i_renamed) fragmentManager).b_renamed(fragment, context, true);
            }
        }
        java.util.Iterator<androidx.fragment.app.i_renamed.c_renamed> it = this.H_renamed.iterator();
        while (it.hasNext()) {
            androidx.fragment.app.i_renamed.c_renamed next = it.next();
            if (!z_renamed || next.f1163b) {
                next.f1162a.b_renamed(this, fragment, context);
            }
        }
    }

    void a_renamed(androidx.fragment.app.Fragment fragment, android.os.Bundle bundle, boolean z_renamed) {
        androidx.fragment.app.Fragment fragment2 = this.p_renamed;
        if (fragment2 != null) {
            androidx.fragment.app.h_renamed fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof androidx.fragment.app.i_renamed) {
                ((androidx.fragment.app.i_renamed) fragmentManager).a_renamed(fragment, bundle, true);
            }
        }
        java.util.Iterator<androidx.fragment.app.i_renamed.c_renamed> it = this.H_renamed.iterator();
        while (it.hasNext()) {
            androidx.fragment.app.i_renamed.c_renamed next = it.next();
            if (!z_renamed || next.f1163b) {
                next.f1162a.a_renamed(this, fragment, bundle);
            }
        }
    }

    void b_renamed(androidx.fragment.app.Fragment fragment, android.os.Bundle bundle, boolean z_renamed) {
        androidx.fragment.app.Fragment fragment2 = this.p_renamed;
        if (fragment2 != null) {
            androidx.fragment.app.h_renamed fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof androidx.fragment.app.i_renamed) {
                ((androidx.fragment.app.i_renamed) fragmentManager).b_renamed(fragment, bundle, true);
            }
        }
        java.util.Iterator<androidx.fragment.app.i_renamed.c_renamed> it = this.H_renamed.iterator();
        while (it.hasNext()) {
            androidx.fragment.app.i_renamed.c_renamed next = it.next();
            if (!z_renamed || next.f1163b) {
                next.f1162a.b_renamed(this, fragment, bundle);
            }
        }
    }

    void c_renamed(androidx.fragment.app.Fragment fragment, android.os.Bundle bundle, boolean z_renamed) {
        androidx.fragment.app.Fragment fragment2 = this.p_renamed;
        if (fragment2 != null) {
            androidx.fragment.app.h_renamed fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof androidx.fragment.app.i_renamed) {
                ((androidx.fragment.app.i_renamed) fragmentManager).c_renamed(fragment, bundle, true);
            }
        }
        java.util.Iterator<androidx.fragment.app.i_renamed.c_renamed> it = this.H_renamed.iterator();
        while (it.hasNext()) {
            androidx.fragment.app.i_renamed.c_renamed next = it.next();
            if (!z_renamed || next.f1163b) {
                next.f1162a.c_renamed(this, fragment, bundle);
            }
        }
    }

    void a_renamed(androidx.fragment.app.Fragment fragment, android.view.View view, android.os.Bundle bundle, boolean z_renamed) {
        androidx.fragment.app.Fragment fragment2 = this.p_renamed;
        if (fragment2 != null) {
            androidx.fragment.app.h_renamed fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof androidx.fragment.app.i_renamed) {
                ((androidx.fragment.app.i_renamed) fragmentManager).a_renamed(fragment, view, bundle, true);
            }
        }
        java.util.Iterator<androidx.fragment.app.i_renamed.c_renamed> it = this.H_renamed.iterator();
        while (it.hasNext()) {
            androidx.fragment.app.i_renamed.c_renamed next = it.next();
            if (!z_renamed || next.f1163b) {
                next.f1162a.a_renamed(this, fragment, view, bundle);
            }
        }
    }

    void b_renamed(androidx.fragment.app.Fragment fragment, boolean z_renamed) {
        androidx.fragment.app.Fragment fragment2 = this.p_renamed;
        if (fragment2 != null) {
            androidx.fragment.app.h_renamed fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof androidx.fragment.app.i_renamed) {
                ((androidx.fragment.app.i_renamed) fragmentManager).b_renamed(fragment, true);
            }
        }
        java.util.Iterator<androidx.fragment.app.i_renamed.c_renamed> it = this.H_renamed.iterator();
        while (it.hasNext()) {
            androidx.fragment.app.i_renamed.c_renamed next = it.next();
            if (!z_renamed || next.f1163b) {
                next.f1162a.a_renamed(this, fragment);
            }
        }
    }

    void c_renamed(androidx.fragment.app.Fragment fragment, boolean z_renamed) {
        androidx.fragment.app.Fragment fragment2 = this.p_renamed;
        if (fragment2 != null) {
            androidx.fragment.app.h_renamed fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof androidx.fragment.app.i_renamed) {
                ((androidx.fragment.app.i_renamed) fragmentManager).c_renamed(fragment, true);
            }
        }
        java.util.Iterator<androidx.fragment.app.i_renamed.c_renamed> it = this.H_renamed.iterator();
        while (it.hasNext()) {
            androidx.fragment.app.i_renamed.c_renamed next = it.next();
            if (!z_renamed || next.f1163b) {
                next.f1162a.b_renamed(this, fragment);
            }
        }
    }

    void d_renamed(androidx.fragment.app.Fragment fragment, boolean z_renamed) {
        androidx.fragment.app.Fragment fragment2 = this.p_renamed;
        if (fragment2 != null) {
            androidx.fragment.app.h_renamed fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof androidx.fragment.app.i_renamed) {
                ((androidx.fragment.app.i_renamed) fragmentManager).d_renamed(fragment, true);
            }
        }
        java.util.Iterator<androidx.fragment.app.i_renamed.c_renamed> it = this.H_renamed.iterator();
        while (it.hasNext()) {
            androidx.fragment.app.i_renamed.c_renamed next = it.next();
            if (!z_renamed || next.f1163b) {
                next.f1162a.c_renamed(this, fragment);
            }
        }
    }

    void e_renamed(androidx.fragment.app.Fragment fragment, boolean z_renamed) {
        androidx.fragment.app.Fragment fragment2 = this.p_renamed;
        if (fragment2 != null) {
            androidx.fragment.app.h_renamed fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof androidx.fragment.app.i_renamed) {
                ((androidx.fragment.app.i_renamed) fragmentManager).e_renamed(fragment, true);
            }
        }
        java.util.Iterator<androidx.fragment.app.i_renamed.c_renamed> it = this.H_renamed.iterator();
        while (it.hasNext()) {
            androidx.fragment.app.i_renamed.c_renamed next = it.next();
            if (!z_renamed || next.f1163b) {
                next.f1162a.d_renamed(this, fragment);
            }
        }
    }

    void d_renamed(androidx.fragment.app.Fragment fragment, android.os.Bundle bundle, boolean z_renamed) {
        androidx.fragment.app.Fragment fragment2 = this.p_renamed;
        if (fragment2 != null) {
            androidx.fragment.app.h_renamed fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof androidx.fragment.app.i_renamed) {
                ((androidx.fragment.app.i_renamed) fragmentManager).d_renamed(fragment, bundle, true);
            }
        }
        java.util.Iterator<androidx.fragment.app.i_renamed.c_renamed> it = this.H_renamed.iterator();
        while (it.hasNext()) {
            androidx.fragment.app.i_renamed.c_renamed next = it.next();
            if (!z_renamed || next.f1163b) {
                next.f1162a.d_renamed(this, fragment, bundle);
            }
        }
    }

    void f_renamed(androidx.fragment.app.Fragment fragment, boolean z_renamed) {
        androidx.fragment.app.Fragment fragment2 = this.p_renamed;
        if (fragment2 != null) {
            androidx.fragment.app.h_renamed fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof androidx.fragment.app.i_renamed) {
                ((androidx.fragment.app.i_renamed) fragmentManager).f_renamed(fragment, true);
            }
        }
        java.util.Iterator<androidx.fragment.app.i_renamed.c_renamed> it = this.H_renamed.iterator();
        while (it.hasNext()) {
            androidx.fragment.app.i_renamed.c_renamed next = it.next();
            if (!z_renamed || next.f1163b) {
                next.f1162a.e_renamed(this, fragment);
            }
        }
    }

    void g_renamed(androidx.fragment.app.Fragment fragment, boolean z_renamed) {
        androidx.fragment.app.Fragment fragment2 = this.p_renamed;
        if (fragment2 != null) {
            androidx.fragment.app.h_renamed fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof androidx.fragment.app.i_renamed) {
                ((androidx.fragment.app.i_renamed) fragmentManager).g_renamed(fragment, true);
            }
        }
        java.util.Iterator<androidx.fragment.app.i_renamed.c_renamed> it = this.H_renamed.iterator();
        while (it.hasNext()) {
            androidx.fragment.app.i_renamed.c_renamed next = it.next();
            if (!z_renamed || next.f1163b) {
                next.f1162a.f_renamed(this, fragment);
            }
        }
    }

    void h_renamed(androidx.fragment.app.Fragment fragment, boolean z_renamed) {
        androidx.fragment.app.Fragment fragment2 = this.p_renamed;
        if (fragment2 != null) {
            androidx.fragment.app.h_renamed fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof androidx.fragment.app.i_renamed) {
                ((androidx.fragment.app.i_renamed) fragmentManager).h_renamed(fragment, true);
            }
        }
        java.util.Iterator<androidx.fragment.app.i_renamed.c_renamed> it = this.H_renamed.iterator();
        while (it.hasNext()) {
            androidx.fragment.app.i_renamed.c_renamed next = it.next();
            if (!z_renamed || next.f1163b) {
                next.f1162a.g_renamed(this, fragment);
            }
        }
    }

    boolean B_renamed() {
        boolean zW = false;
        for (androidx.fragment.app.Fragment fragment : this.g_renamed.values()) {
            if (fragment != null) {
                zW = w_renamed(fragment);
            }
            if (zW) {
                return true;
            }
        }
        return false;
    }

    private boolean w_renamed(androidx.fragment.app.Fragment fragment) {
        return (fragment.mHasMenu && fragment.mMenuVisible) || fragment.mChildFragmentManager.B_renamed();
    }

    @Override // android.view.LayoutInflater.Factory2
    public android.view.View onCreateView(android.view.View view, java.lang.String str, android.content.Context context, android.util.AttributeSet attributeSet) throws android.content.res.Resources.NotFoundException {
        androidx.fragment.app.Fragment fragment;
        if (!"fragment".equals(str)) {
            return null;
        }
        java.lang.String attributeValue = attributeSet.getAttributeValue(null, "class");
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.fragment.app.i_renamed.d_renamed.f1164a);
        if (attributeValue == null) {
            attributeValue = typedArrayObtainStyledAttributes.getString(0);
        }
        java.lang.String str2 = attributeValue;
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(1, -1);
        java.lang.String string = typedArrayObtainStyledAttributes.getString(2);
        typedArrayObtainStyledAttributes.recycle();
        if (str2 == null || !androidx.fragment.app.f_renamed.a_renamed(context.getClassLoader(), str2)) {
            return null;
        }
        int id_renamed = view != null ? view.getId() : 0;
        if (id_renamed == -1 && resourceId == -1 && string == null) {
            throw new java.lang.IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id_renamed, android:tag, or have a_renamed parent with an_renamed id_renamed for " + str2);
        }
        androidx.fragment.app.Fragment fragmentB = resourceId != -1 ? b_renamed(resourceId) : null;
        if (fragmentB == null && string != null) {
            fragmentB = a_renamed(string);
        }
        if (fragmentB == null && id_renamed != -1) {
            fragmentB = b_renamed(id_renamed);
        }
        if (f1142b) {
            android.util.Log.v_renamed("FragmentManager", "onCreateView: id_renamed=0x" + java.lang.Integer.toHexString(resourceId) + " fname=" + str2 + " existing=" + fragmentB);
        }
        if (fragmentB == null) {
            androidx.fragment.app.Fragment fragmentC = f_renamed().c_renamed(context.getClassLoader(), str2);
            fragmentC.mFromLayout = true;
            fragmentC.mFragmentId = resourceId != 0 ? resourceId : id_renamed;
            fragmentC.mContainerId = id_renamed;
            fragmentC.mTag = string;
            fragmentC.mInLayout = true;
            fragmentC.mFragmentManager = this;
            androidx.fragment.app.g_renamed gVar = this.n_renamed;
            fragmentC.mHost = gVar;
            fragmentC.onInflate(gVar.j_renamed(), attributeSet, fragmentC.mSavedFragmentState);
            a_renamed(fragmentC, true);
            fragment = fragmentC;
        } else {
            if (fragmentB.mInLayout) {
                throw new java.lang.IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id_renamed 0x" + java.lang.Integer.toHexString(resourceId) + ", tag " + string + ", or parent id_renamed 0x" + java.lang.Integer.toHexString(id_renamed) + " with another fragment for " + str2);
            }
            fragmentB.mInLayout = true;
            androidx.fragment.app.g_renamed gVar2 = this.n_renamed;
            fragmentB.mHost = gVar2;
            fragmentB.onInflate(gVar2.j_renamed(), attributeSet, fragmentB.mSavedFragmentState);
            fragment = fragmentB;
        }
        if (this.m_renamed < 1 && fragment.mFromLayout) {
            a_renamed(fragment, 1, 0, 0, false);
        } else {
            g_renamed(fragment);
        }
        if (fragment.mView == null) {
            throw new java.lang.IllegalStateException("Fragment " + str2 + " did not create a_renamed view.");
        }
        if (resourceId != 0) {
            fragment.mView.setId(resourceId);
        }
        if (fragment.mView.getTag() == null) {
            fragment.mView.setTag(string);
        }
        return fragment.mView;
    }

    @Override // android.view.LayoutInflater.Factory
    public android.view.View onCreateView(java.lang.String str, android.content.Context context, android.util.AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    /* compiled from: FragmentManagerImpl.java */
    private class f_renamed implements androidx.fragment.app.i_renamed.e_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        final java.lang.String f1165a;

        /* renamed from: b_renamed, reason: collision with root package name */
        final int f1166b;

        /* renamed from: c_renamed, reason: collision with root package name */
        final int f1167c;

        f_renamed(java.lang.String str, int i_renamed, int i2) {
            this.f1165a = str;
            this.f1166b = i_renamed;
            this.f1167c = i2;
        }

        @Override // androidx.fragment.app.i_renamed.e_renamed
        public boolean a_renamed(java.util.ArrayList<androidx.fragment.app.a_renamed> arrayList, java.util.ArrayList<java.lang.Boolean> arrayList2) {
            if (androidx.fragment.app.i_renamed.this.q_renamed == null || this.f1166b >= 0 || this.f1165a != null || !androidx.fragment.app.i_renamed.this.q_renamed.getChildFragmentManager().c_renamed()) {
                return androidx.fragment.app.i_renamed.this.a_renamed(arrayList, arrayList2, this.f1165a, this.f1166b, this.f1167c);
            }
            return false;
        }
    }

    /* compiled from: FragmentManagerImpl.java */
    static class g_renamed implements androidx.fragment.app.Fragment.c_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        final boolean f1168a;

        /* renamed from: b_renamed, reason: collision with root package name */
        final androidx.fragment.app.a_renamed f1169b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private int f1170c;

        g_renamed(androidx.fragment.app.a_renamed aVar, boolean z_renamed) {
            this.f1168a = z_renamed;
            this.f1169b = aVar;
        }

        @Override // androidx.fragment.app.Fragment.c_renamed
        public void a_renamed() {
            this.f1170c--;
            if (this.f1170c != 0) {
                return;
            }
            this.f1169b.f1130a.k_renamed();
        }

        @Override // androidx.fragment.app.Fragment.c_renamed
        public void b_renamed() {
            this.f1170c++;
        }

        public boolean c_renamed() {
            return this.f1170c == 0;
        }

        public void d_renamed() throws android.content.res.Resources.NotFoundException {
            boolean z_renamed = this.f1170c > 0;
            androidx.fragment.app.i_renamed iVar = this.f1169b.f1130a;
            int size = iVar.f_renamed.size();
            for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                androidx.fragment.app.Fragment fragment = iVar.f_renamed.get(i_renamed);
                fragment.setOnStartEnterTransitionListener(null);
                if (z_renamed && fragment.isPostponed()) {
                    fragment.startPostponedEnterTransition();
                }
            }
            this.f1169b.f1130a.a_renamed(this.f1169b, this.f1168a, !z_renamed, true);
        }

        public void e_renamed() throws android.content.res.Resources.NotFoundException {
            this.f1169b.f1130a.a_renamed(this.f1169b, this.f1168a, false, false);
        }
    }

    /* compiled from: FragmentManagerImpl.java */
    private static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public final android.view.animation.Animation f1157a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public final android.animation.Animator f1158b;

        a_renamed(android.view.animation.Animation animation) {
            this.f1157a = animation;
            this.f1158b = null;
            if (animation == null) {
                throw new java.lang.IllegalStateException("Animation cannot be_renamed null");
            }
        }

        a_renamed(android.animation.Animator animator) {
            this.f1157a = null;
            this.f1158b = animator;
            if (animator == null) {
                throw new java.lang.IllegalStateException("Animator cannot be_renamed null");
            }
        }
    }

    /* compiled from: FragmentManagerImpl.java */
    private static class b_renamed extends android.view.animation.AnimationSet implements java.lang.Runnable {

        /* renamed from: a_renamed, reason: collision with root package name */
        private final android.view.ViewGroup f1159a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private final android.view.View f1160b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private boolean f1161c;
        private boolean d_renamed;
        private boolean e_renamed;

        b_renamed(android.view.animation.Animation animation, android.view.ViewGroup viewGroup, android.view.View view) {
            super(false);
            this.e_renamed = true;
            this.f1159a = viewGroup;
            this.f1160b = view;
            addAnimation(animation);
            this.f1159a.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j_renamed, android.view.animation.Transformation transformation) {
            this.e_renamed = true;
            if (this.f1161c) {
                return !this.d_renamed;
            }
            if (!super.getTransformation(j_renamed, transformation)) {
                this.f1161c = true;
                androidx.core.h_renamed.r_renamed.a_renamed(this.f1159a, this);
            }
            return true;
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j_renamed, android.view.animation.Transformation transformation, float f_renamed) {
            this.e_renamed = true;
            if (this.f1161c) {
                return !this.d_renamed;
            }
            if (!super.getTransformation(j_renamed, transformation, f_renamed)) {
                this.f1161c = true;
                androidx.core.h_renamed.r_renamed.a_renamed(this.f1159a, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f1161c && this.e_renamed) {
                this.e_renamed = false;
                this.f1159a.post(this);
            } else {
                this.f1159a.endViewTransition(this.f1160b);
                this.d_renamed = true;
            }
        }
    }
}
