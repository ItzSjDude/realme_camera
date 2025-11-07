package androidx.recyclerview.widget;

/* compiled from: DefaultItemAnimator.java */
/* loaded from: classes.dex */
public class e_renamed extends androidx.recyclerview.widget.r_renamed {
    private static android.animation.TimeInterpolator i_renamed;
    private java.util.ArrayList<androidx.recyclerview.widget.RecyclerView.w_renamed> j_renamed = new java.util.ArrayList<>();
    private java.util.ArrayList<androidx.recyclerview.widget.RecyclerView.w_renamed> k_renamed = new java.util.ArrayList<>();
    private java.util.ArrayList<androidx.recyclerview.widget.e_renamed.b_renamed> l_renamed = new java.util.ArrayList<>();
    private java.util.ArrayList<androidx.recyclerview.widget.e_renamed.a_renamed> m_renamed = new java.util.ArrayList<>();

    /* renamed from: a_renamed, reason: collision with root package name */
    java.util.ArrayList<java.util.ArrayList<androidx.recyclerview.widget.RecyclerView.w_renamed>> f1470a = new java.util.ArrayList<>();

    /* renamed from: b_renamed, reason: collision with root package name */
    java.util.ArrayList<java.util.ArrayList<androidx.recyclerview.widget.e_renamed.b_renamed>> f1471b = new java.util.ArrayList<>();

    /* renamed from: c_renamed, reason: collision with root package name */
    java.util.ArrayList<java.util.ArrayList<androidx.recyclerview.widget.e_renamed.a_renamed>> f1472c = new java.util.ArrayList<>();
    java.util.ArrayList<androidx.recyclerview.widget.RecyclerView.w_renamed> d_renamed = new java.util.ArrayList<>();
    java.util.ArrayList<androidx.recyclerview.widget.RecyclerView.w_renamed> e_renamed = new java.util.ArrayList<>();
    java.util.ArrayList<androidx.recyclerview.widget.RecyclerView.w_renamed> f_renamed = new java.util.ArrayList<>();
    java.util.ArrayList<androidx.recyclerview.widget.RecyclerView.w_renamed> g_renamed = new java.util.ArrayList<>();

    /* compiled from: DefaultItemAnimator.java */
    private static class b_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public androidx.recyclerview.widget.RecyclerView.w_renamed f1497a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public int f1498b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public int f1499c;
        public int d_renamed;
        public int e_renamed;

        b_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar, int i_renamed, int i2, int i3, int i4) {
            this.f1497a = wVar;
            this.f1498b = i_renamed;
            this.f1499c = i2;
            this.d_renamed = i3;
            this.e_renamed = i4;
        }
    }

    /* compiled from: DefaultItemAnimator.java */
    private static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public androidx.recyclerview.widget.RecyclerView.w_renamed f1494a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public androidx.recyclerview.widget.RecyclerView.w_renamed f1495b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public int f1496c;
        public int d_renamed;
        public int e_renamed;
        public int f_renamed;

        private a_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar, androidx.recyclerview.widget.RecyclerView.w_renamed wVar2) {
            this.f1494a = wVar;
            this.f1495b = wVar2;
        }

        a_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar, androidx.recyclerview.widget.RecyclerView.w_renamed wVar2, int i_renamed, int i2, int i3, int i4) {
            this(wVar, wVar2);
            this.f1496c = i_renamed;
            this.d_renamed = i2;
            this.e_renamed = i3;
            this.f_renamed = i4;
        }

        public java.lang.String toString() {
            return "ChangeInfo{oldHolder=" + this.f1494a + ", newHolder=" + this.f1495b + ", fromX=" + this.f1496c + ", fromY=" + this.d_renamed + ", toX=" + this.e_renamed + ", toY=" + this.f_renamed + '}';
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f_renamed
    public void a_renamed() {
        boolean z_renamed = !this.j_renamed.isEmpty();
        boolean z2 = !this.l_renamed.isEmpty();
        boolean z3 = !this.m_renamed.isEmpty();
        boolean z4 = !this.k_renamed.isEmpty();
        if (z_renamed || z2 || z4 || z3) {
            java.util.Iterator<androidx.recyclerview.widget.RecyclerView.w_renamed> it = this.j_renamed.iterator();
            while (it.hasNext()) {
                u_renamed(it.next());
            }
            this.j_renamed.clear();
            if (z2) {
                final java.util.ArrayList<androidx.recyclerview.widget.e_renamed.b_renamed> arrayList = new java.util.ArrayList<>();
                arrayList.addAll(this.l_renamed);
                this.f1471b.add(arrayList);
                this.l_renamed.clear();
                java.lang.Runnable runnable = new java.lang.Runnable() { // from class: androidx.recyclerview.widget.e_renamed.1
                    @Override // java.lang.Runnable
                    public void run() {
                        java.util.Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            androidx.recyclerview.widget.e_renamed.b_renamed bVar = (androidx.recyclerview.widget.e_renamed.b_renamed) it2.next();
                            androidx.recyclerview.widget.e_renamed.this.b_renamed(bVar.f1497a, bVar.f1498b, bVar.f1499c, bVar.d_renamed, bVar.e_renamed);
                        }
                        arrayList.clear();
                        androidx.recyclerview.widget.e_renamed.this.f1471b.remove(arrayList);
                    }
                };
                if (z_renamed) {
                    androidx.core.h_renamed.v_renamed.a_renamed(arrayList.get(0).f1497a.itemView, runnable, g_renamed());
                } else {
                    runnable.run();
                }
            }
            if (z3) {
                final java.util.ArrayList<androidx.recyclerview.widget.e_renamed.a_renamed> arrayList2 = new java.util.ArrayList<>();
                arrayList2.addAll(this.m_renamed);
                this.f1472c.add(arrayList2);
                this.m_renamed.clear();
                java.lang.Runnable runnable2 = new java.lang.Runnable() { // from class: androidx.recyclerview.widget.e_renamed.2
                    @Override // java.lang.Runnable
                    public void run() {
                        java.util.Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            androidx.recyclerview.widget.e_renamed.this.a_renamed((androidx.recyclerview.widget.e_renamed.a_renamed) it2.next());
                        }
                        arrayList2.clear();
                        androidx.recyclerview.widget.e_renamed.this.f1472c.remove(arrayList2);
                    }
                };
                if (z_renamed) {
                    androidx.core.h_renamed.v_renamed.a_renamed(arrayList2.get(0).f1494a.itemView, runnable2, g_renamed());
                } else {
                    runnable2.run();
                }
            }
            if (z4) {
                final java.util.ArrayList<androidx.recyclerview.widget.RecyclerView.w_renamed> arrayList3 = new java.util.ArrayList<>();
                arrayList3.addAll(this.k_renamed);
                this.f1470a.add(arrayList3);
                this.k_renamed.clear();
                java.lang.Runnable runnable3 = new java.lang.Runnable() { // from class: androidx.recyclerview.widget.e_renamed.3
                    @Override // java.lang.Runnable
                    public void run() {
                        java.util.Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            androidx.recyclerview.widget.e_renamed.this.c_renamed((androidx.recyclerview.widget.RecyclerView.w_renamed) it2.next());
                        }
                        arrayList3.clear();
                        androidx.recyclerview.widget.e_renamed.this.f1470a.remove(arrayList3);
                    }
                };
                if (z_renamed || z2 || z3) {
                    androidx.core.h_renamed.v_renamed.a_renamed(arrayList3.get(0).itemView, runnable3, (z_renamed ? g_renamed() : 0L) + java.lang.Math.max(z2 ? e_renamed() : 0L, z3 ? h_renamed() : 0L));
                } else {
                    runnable3.run();
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.r_renamed
    public boolean a_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
        v_renamed(wVar);
        this.j_renamed.add(wVar);
        return true;
    }

    private void u_renamed(final androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
        final android.view.View view = wVar.itemView;
        final android.view.ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f_renamed.add(wVar);
        viewPropertyAnimatorAnimate.setDuration(g_renamed()).alpha(0.0f).setListener(new android.animation.AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.e_renamed.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                androidx.recyclerview.widget.e_renamed.this.l_renamed(wVar);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                view.setAlpha(1.0f);
                androidx.recyclerview.widget.e_renamed.this.i_renamed(wVar);
                androidx.recyclerview.widget.e_renamed.this.f_renamed.remove(wVar);
                androidx.recyclerview.widget.e_renamed.this.c_renamed();
            }
        }).start();
    }

    @Override // androidx.recyclerview.widget.r_renamed
    public boolean b_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
        v_renamed(wVar);
        wVar.itemView.setAlpha(0.0f);
        this.k_renamed.add(wVar);
        return true;
    }

    void c_renamed(final androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
        final android.view.View view = wVar.itemView;
        final android.view.ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.d_renamed.add(wVar);
        viewPropertyAnimatorAnimate.alpha(1.0f).setDuration(f_renamed()).setListener(new android.animation.AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.e_renamed.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                androidx.recyclerview.widget.e_renamed.this.n_renamed(wVar);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
                view.setAlpha(1.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                androidx.recyclerview.widget.e_renamed.this.k_renamed(wVar);
                androidx.recyclerview.widget.e_renamed.this.d_renamed.remove(wVar);
                androidx.recyclerview.widget.e_renamed.this.c_renamed();
            }
        }).start();
    }

    @Override // androidx.recyclerview.widget.r_renamed
    public boolean a_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar, int i2, int i3, int i4, int i5) {
        android.view.View view = wVar.itemView;
        int translationX = i2 + ((int) wVar.itemView.getTranslationX());
        int translationY = i3 + ((int) wVar.itemView.getTranslationY());
        v_renamed(wVar);
        int i6 = i4 - translationX;
        int i7 = i5 - translationY;
        if (i6 == 0 && i7 == 0) {
            j_renamed(wVar);
            return false;
        }
        if (i6 != 0) {
            view.setTranslationX(-i6);
        }
        if (i7 != 0) {
            view.setTranslationY(-i7);
        }
        this.l_renamed.add(new androidx.recyclerview.widget.e_renamed.b_renamed(wVar, translationX, translationY, i4, i5));
        return true;
    }

    void b_renamed(final androidx.recyclerview.widget.RecyclerView.w_renamed wVar, int i2, int i3, int i4, int i5) {
        final android.view.View view = wVar.itemView;
        final int i6 = i4 - i2;
        final int i7 = i5 - i3;
        if (i6 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i7 != 0) {
            view.animate().translationY(0.0f);
        }
        final android.view.ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.e_renamed.add(wVar);
        viewPropertyAnimatorAnimate.setDuration(e_renamed()).setListener(new android.animation.AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.e_renamed.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                androidx.recyclerview.widget.e_renamed.this.m_renamed(wVar);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
                if (i6 != 0) {
                    view.setTranslationX(0.0f);
                }
                if (i7 != 0) {
                    view.setTranslationY(0.0f);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                androidx.recyclerview.widget.e_renamed.this.j_renamed(wVar);
                androidx.recyclerview.widget.e_renamed.this.e_renamed.remove(wVar);
                androidx.recyclerview.widget.e_renamed.this.c_renamed();
            }
        }).start();
    }

    @Override // androidx.recyclerview.widget.r_renamed
    public boolean a_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar, androidx.recyclerview.widget.RecyclerView.w_renamed wVar2, int i2, int i3, int i4, int i5) {
        if (wVar == wVar2) {
            return a_renamed(wVar, i2, i3, i4, i5);
        }
        float translationX = wVar.itemView.getTranslationX();
        float translationY = wVar.itemView.getTranslationY();
        float alpha = wVar.itemView.getAlpha();
        v_renamed(wVar);
        int i6 = (int) ((i4 - i2) - translationX);
        int i7 = (int) ((i5 - i3) - translationY);
        wVar.itemView.setTranslationX(translationX);
        wVar.itemView.setTranslationY(translationY);
        wVar.itemView.setAlpha(alpha);
        if (wVar2 != null) {
            v_renamed(wVar2);
            wVar2.itemView.setTranslationX(-i6);
            wVar2.itemView.setTranslationY(-i7);
            wVar2.itemView.setAlpha(0.0f);
        }
        this.m_renamed.add(new androidx.recyclerview.widget.e_renamed.a_renamed(wVar, wVar2, i2, i3, i4, i5));
        return true;
    }

    void a_renamed(final androidx.recyclerview.widget.e_renamed.a_renamed aVar) {
        androidx.recyclerview.widget.RecyclerView.w_renamed wVar = aVar.f1494a;
        final android.view.View view = wVar == null ? null : wVar.itemView;
        androidx.recyclerview.widget.RecyclerView.w_renamed wVar2 = aVar.f1495b;
        final android.view.View view2 = wVar2 != null ? wVar2.itemView : null;
        if (view != null) {
            final android.view.ViewPropertyAnimator duration = view.animate().setDuration(h_renamed());
            this.g_renamed.add(aVar.f1494a);
            duration.translationX(aVar.e_renamed - aVar.f1496c);
            duration.translationY(aVar.f_renamed - aVar.d_renamed);
            duration.alpha(0.0f).setListener(new android.animation.AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.e_renamed.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator) {
                    androidx.recyclerview.widget.e_renamed.this.b_renamed(aVar.f1494a, true);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    duration.setListener(null);
                    view.setAlpha(1.0f);
                    view.setTranslationX(0.0f);
                    view.setTranslationY(0.0f);
                    androidx.recyclerview.widget.e_renamed.this.a_renamed(aVar.f1494a, true);
                    androidx.recyclerview.widget.e_renamed.this.g_renamed.remove(aVar.f1494a);
                    androidx.recyclerview.widget.e_renamed.this.c_renamed();
                }
            }).start();
        }
        if (view2 != null) {
            final android.view.ViewPropertyAnimator viewPropertyAnimatorAnimate = view2.animate();
            this.g_renamed.add(aVar.f1495b);
            viewPropertyAnimatorAnimate.translationX(0.0f).translationY(0.0f).setDuration(h_renamed()).alpha(1.0f).setListener(new android.animation.AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.e_renamed.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator) {
                    androidx.recyclerview.widget.e_renamed.this.b_renamed(aVar.f1495b, false);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    viewPropertyAnimatorAnimate.setListener(null);
                    view2.setAlpha(1.0f);
                    view2.setTranslationX(0.0f);
                    view2.setTranslationY(0.0f);
                    androidx.recyclerview.widget.e_renamed.this.a_renamed(aVar.f1495b, false);
                    androidx.recyclerview.widget.e_renamed.this.g_renamed.remove(aVar.f1495b);
                    androidx.recyclerview.widget.e_renamed.this.c_renamed();
                }
            }).start();
        }
    }

    private void a_renamed(java.util.List<androidx.recyclerview.widget.e_renamed.a_renamed> list, androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            androidx.recyclerview.widget.e_renamed.a_renamed aVar = list.get(size);
            if (a_renamed(aVar, wVar) && aVar.f1494a == null && aVar.f1495b == null) {
                list.remove(aVar);
            }
        }
    }

    private void b_renamed(androidx.recyclerview.widget.e_renamed.a_renamed aVar) {
        if (aVar.f1494a != null) {
            a_renamed(aVar, aVar.f1494a);
        }
        if (aVar.f1495b != null) {
            a_renamed(aVar, aVar.f1495b);
        }
    }

    private boolean a_renamed(androidx.recyclerview.widget.e_renamed.a_renamed aVar, androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
        boolean z_renamed = false;
        if (aVar.f1495b == wVar) {
            aVar.f1495b = null;
        } else {
            if (aVar.f1494a != wVar) {
                return false;
            }
            aVar.f1494a = null;
            z_renamed = true;
        }
        wVar.itemView.setAlpha(1.0f);
        wVar.itemView.setTranslationX(0.0f);
        wVar.itemView.setTranslationY(0.0f);
        a_renamed(wVar, z_renamed);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f_renamed
    public void d_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
        android.view.View view = wVar.itemView;
        view.animate().cancel();
        int size = this.l_renamed.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (this.l_renamed.get(size).f1497a == wVar) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                j_renamed(wVar);
                this.l_renamed.remove(size);
            }
        }
        a_renamed(this.m_renamed, wVar);
        if (this.j_renamed.remove(wVar)) {
            view.setAlpha(1.0f);
            i_renamed(wVar);
        }
        if (this.k_renamed.remove(wVar)) {
            view.setAlpha(1.0f);
            k_renamed(wVar);
        }
        for (int size2 = this.f1472c.size() - 1; size2 >= 0; size2--) {
            java.util.ArrayList<androidx.recyclerview.widget.e_renamed.a_renamed> arrayList = this.f1472c.get(size2);
            a_renamed(arrayList, wVar);
            if (arrayList.isEmpty()) {
                this.f1472c.remove(size2);
            }
        }
        for (int size3 = this.f1471b.size() - 1; size3 >= 0; size3--) {
            java.util.ArrayList<androidx.recyclerview.widget.e_renamed.b_renamed> arrayList2 = this.f1471b.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (arrayList2.get(size4).f1497a == wVar) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    j_renamed(wVar);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f1471b.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f1470a.size() - 1; size5 >= 0; size5--) {
            java.util.ArrayList<androidx.recyclerview.widget.RecyclerView.w_renamed> arrayList3 = this.f1470a.get(size5);
            if (arrayList3.remove(wVar)) {
                view.setAlpha(1.0f);
                k_renamed(wVar);
                if (arrayList3.isEmpty()) {
                    this.f1470a.remove(size5);
                }
            }
        }
        this.f_renamed.remove(wVar);
        this.d_renamed.remove(wVar);
        this.g_renamed.remove(wVar);
        this.e_renamed.remove(wVar);
        c_renamed();
    }

    private void v_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
        if (i_renamed == null) {
            i_renamed = new android.animation.ValueAnimator().getInterpolator();
        }
        wVar.itemView.animate().setInterpolator(i_renamed);
        d_renamed(wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f_renamed
    public boolean b_renamed() {
        return (this.k_renamed.isEmpty() && this.m_renamed.isEmpty() && this.l_renamed.isEmpty() && this.j_renamed.isEmpty() && this.e_renamed.isEmpty() && this.f_renamed.isEmpty() && this.d_renamed.isEmpty() && this.g_renamed.isEmpty() && this.f1471b.isEmpty() && this.f1470a.isEmpty() && this.f1472c.isEmpty()) ? false : true;
    }

    void c_renamed() {
        if (b_renamed()) {
            return;
        }
        i_renamed();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f_renamed
    public void d_renamed() {
        int size = this.l_renamed.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            androidx.recyclerview.widget.e_renamed.b_renamed bVar = this.l_renamed.get(size);
            android.view.View view = bVar.f1497a.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            j_renamed(bVar.f1497a);
            this.l_renamed.remove(size);
        }
        for (int size2 = this.j_renamed.size() - 1; size2 >= 0; size2--) {
            i_renamed(this.j_renamed.get(size2));
            this.j_renamed.remove(size2);
        }
        int size3 = this.k_renamed.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            androidx.recyclerview.widget.RecyclerView.w_renamed wVar = this.k_renamed.get(size3);
            wVar.itemView.setAlpha(1.0f);
            k_renamed(wVar);
            this.k_renamed.remove(size3);
        }
        for (int size4 = this.m_renamed.size() - 1; size4 >= 0; size4--) {
            b_renamed(this.m_renamed.get(size4));
        }
        this.m_renamed.clear();
        if (b_renamed()) {
            for (int size5 = this.f1471b.size() - 1; size5 >= 0; size5--) {
                java.util.ArrayList<androidx.recyclerview.widget.e_renamed.b_renamed> arrayList = this.f1471b.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    androidx.recyclerview.widget.e_renamed.b_renamed bVar2 = arrayList.get(size6);
                    android.view.View view2 = bVar2.f1497a.itemView;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    j_renamed(bVar2.f1497a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f1471b.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f1470a.size() - 1; size7 >= 0; size7--) {
                java.util.ArrayList<androidx.recyclerview.widget.RecyclerView.w_renamed> arrayList2 = this.f1470a.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    androidx.recyclerview.widget.RecyclerView.w_renamed wVar2 = arrayList2.get(size8);
                    wVar2.itemView.setAlpha(1.0f);
                    k_renamed(wVar2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f1470a.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.f1472c.size() - 1; size9 >= 0; size9--) {
                java.util.ArrayList<androidx.recyclerview.widget.e_renamed.a_renamed> arrayList3 = this.f1472c.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    b_renamed(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.f1472c.remove(arrayList3);
                    }
                }
            }
            a_renamed(this.f_renamed);
            a_renamed(this.e_renamed);
            a_renamed(this.d_renamed);
            a_renamed(this.g_renamed);
            i_renamed();
        }
    }

    void a_renamed(java.util.List<androidx.recyclerview.widget.RecyclerView.w_renamed> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).itemView.animate().cancel();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f_renamed
    public boolean a_renamed(androidx.recyclerview.widget.RecyclerView.w_renamed wVar, java.util.List<java.lang.Object> list) {
        return !list.isEmpty() || super.a_renamed(wVar, list);
    }
}
