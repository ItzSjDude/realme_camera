package androidx.viewpager2.adapter;

/* compiled from: FragmentStateAdapter.java */
/* loaded from: classes.dex */
public abstract class a_renamed extends androidx.recyclerview.widget.RecyclerView.a_renamed<androidx.viewpager2.adapter.b_renamed> implements androidx.viewpager2.adapter.c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    final androidx.lifecycle.e_renamed f1819a;

    /* renamed from: b_renamed, reason: collision with root package name */
    final androidx.fragment.app.h_renamed f1820b;

    /* renamed from: c_renamed, reason: collision with root package name */
    final androidx.collection.LongSparseArray<androidx.fragment.app.Fragment> f1821c;
    androidx.viewpager2.adapter.a_renamed.FragmentStateAdapter_3 d_renamed;
    private androidx.viewpager2.adapter.a_renamed.b_renamed e_renamed;

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    public long getItemId(int i_renamed) {
        return i_renamed;
    }

    void a_renamed(final androidx.viewpager2.adapter.b_renamed bVar) {
        androidx.fragment.app.Fragment fragment = this.f1821c.get(bVar.getItemId());
        if (fragment == null) {
            throw new java.lang.IllegalStateException("Design assumption violated.");
        }
        android.widget.FrameLayout frameLayoutA = bVar.a_renamed();
        android.view.View view = fragment.getView();
        if (!fragment.isAdded() && view != null) {
            throw new java.lang.IllegalStateException("Design assumption violated.");
        }
        if (fragment.isAdded() && view == null) {
            a_renamed(fragment, frameLayoutA);
            return;
        }
        if (fragment.isAdded() && view.getParent() != null) {
            if (view.getParent() != frameLayoutA) {
                a_renamed(view, frameLayoutA);
                return;
            }
            return;
        }
        if (fragment.isAdded()) {
            a_renamed(view, frameLayoutA);
            return;
        }
        if (!a_renamed()) {
            a_renamed(fragment, frameLayoutA);
            java.util.List<androidx.viewpager2.adapter.a_renamed.c_renamed.FragmentStateAdapter_5> listA = this.d_renamed.a_renamed(fragment);
            try {
                fragment.setMenuVisibility(false);
                this.f1820b.a_renamed().a_renamed(fragment, "f_renamed" + bVar.getItemId()).a_renamed(fragment, androidx.lifecycle.e_renamed.b_renamed.STARTED).d_renamed();
                this.e_renamed.a_renamed(false);
                return;
            } finally {
                this.d_renamed.a_renamed(listA);
            }
        }
        if (this.f1820b.e_renamed()) {
            return;
        }
        this.f1819a.a_renamed(new androidx.lifecycle.f_renamed() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter$2
            @Override // androidx.lifecycle.f_renamed
            public void a_renamed(androidx.lifecycle.h_renamed hVar, androidx.lifecycle.e_renamed.a_renamed aVar) {
                if (this.f1815b.a_renamed()) {
                    return;
                }
                hVar.getLifecycle().b_renamed(this);
                if (androidx.core.h_renamed.v_renamed.D_renamed(bVar.a_renamed())) {
                    this.f1815b.a_renamed(bVar);
                }
            }
        });
    }

    private void a_renamed(final androidx.fragment.app.Fragment fragment, final android.widget.FrameLayout frameLayout) {
        this.f1820b.a_renamed(new androidx.fragment.app.h_renamed.a_renamed() { // from class: androidx.viewpager2.adapter.a_renamed.1
            @Override // androidx.fragment.app.h_renamed.a_renamed
            public void a_renamed(androidx.fragment.app.h_renamed hVar, androidx.fragment.app.Fragment fragment2, android.view.View view, android.os.Bundle bundle) {
                if (fragment2 == fragment) {
                    hVar.a_renamed(this);
                    androidx.viewpager2.adapter.a_renamed.this.a_renamed(view, frameLayout);
                }
            }
        }, false);
    }

    void a_renamed(android.view.View view, android.widget.FrameLayout frameLayout) {
        if (frameLayout.getChildCount() > 1) {
            throw new java.lang.IllegalStateException("Design assumption violated.");
        }
        if (view.getParent() == frameLayout) {
            return;
        }
        if (frameLayout.getChildCount() > 0) {
            frameLayout.removeAllViews();
        }
        if (view.getParent() != null) {
            ((android.view.ViewGroup) view.getParent()).removeView(view);
        }
        frameLayout.addView(view);
    }

    boolean a_renamed() {
        return this.f1820b.g_renamed();
    }

    /* compiled from: FragmentStateAdapter.java */
    class b_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        final /* synthetic */ androidx.viewpager2.adapter.a_renamed f1826a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private androidx.viewpager2.widget.ViewPager2 f1827b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private long f1828c;

        void a_renamed(boolean z_renamed) {
            int currentItem;
            androidx.fragment.app.Fragment fragment;
            if (this.f1826a.a_renamed() || this.f1827b.getScrollState() != 0 || this.f1826a.f1821c.isEmpty() || this.f1826a.getItemCount() == 0 || (currentItem = this.f1827b.getCurrentItem()) >= this.f1826a.getItemCount()) {
                return;
            }
            long itemId = this.f1826a.getItemId(currentItem);
            if ((itemId != this.f1828c || z_renamed) && (fragment = this.f1826a.f1821c.get(itemId)) != null && fragment.isAdded()) {
                this.f1828c = itemId;
                androidx.fragment.app.k_renamed kVarA = this.f1826a.f1820b.a_renamed();
                java.util.ArrayList arrayList = new java.util.ArrayList();
                androidx.fragment.app.Fragment fragment2 = null;
                for (int i_renamed = 0; i_renamed < this.f1826a.f1821c.size(); i_renamed++) {
                    long jKeyAt = this.f1826a.f1821c.keyAt(i_renamed);
                    androidx.fragment.app.Fragment fragmentValueAt = this.f1826a.f1821c.valueAt(i_renamed);
                    if (fragmentValueAt.isAdded()) {
                        if (jKeyAt != this.f1828c) {
                            kVarA.a_renamed(fragmentValueAt, androidx.lifecycle.e_renamed.b_renamed.STARTED);
                            arrayList.add(this.f1826a.d_renamed.a_renamed(fragmentValueAt, androidx.lifecycle.e_renamed.b_renamed.STARTED));
                        } else {
                            fragment2 = fragmentValueAt;
                        }
                        fragmentValueAt.setMenuVisibility(jKeyAt == this.f1828c);
                    }
                }
                if (fragment2 != null) {
                    kVarA.a_renamed(fragment2, androidx.lifecycle.e_renamed.b_renamed.RESUMED);
                    arrayList.add(this.f1826a.d_renamed.a_renamed(fragment2, androidx.lifecycle.e_renamed.b_renamed.RESUMED));
                }
                if (kVarA.h_renamed()) {
                    return;
                }
                kVarA.d_renamed();
                java.util.Collections.reverse(arrayList);
                java.util.Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    this.f1826a.d_renamed.a_renamed((java.util.List<androidx.viewpager2.adapter.a_renamed.c_renamed.FragmentStateAdapter_5>) it.next());
                }
            }
        }
    }

    /* compiled from: FragmentStateAdapter.java */
    /* renamed from: androidx.viewpager2.adapter.a_renamed$a_renamed, reason: collision with other inner class name */
    static class FragmentStateAdapter_3 {

        /* renamed from: a_renamed, reason: collision with root package name */
        private java.util.List<androidx.viewpager2.adapter.a_renamed.c_renamed> f1825a;

        public java.util.List<androidx.viewpager2.adapter.a_renamed.c_renamed.FragmentStateAdapter_5> a_renamed(androidx.fragment.app.Fragment fragment, androidx.lifecycle.e_renamed.b_renamed bVar) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.Iterator<androidx.viewpager2.adapter.a_renamed.c_renamed> it = this.f1825a.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().a_renamed(fragment, bVar));
            }
            return arrayList;
        }

        public void a_renamed(java.util.List<androidx.viewpager2.adapter.a_renamed.c_renamed.FragmentStateAdapter_5> list) {
            java.util.Iterator<androidx.viewpager2.adapter.a_renamed.c_renamed.FragmentStateAdapter_5> it = list.iterator();
            while (it.hasNext()) {
                it.next().a_renamed();
            }
        }

        public java.util.List<androidx.viewpager2.adapter.a_renamed.c_renamed.FragmentStateAdapter_5> a_renamed(androidx.fragment.app.Fragment fragment) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.Iterator<androidx.viewpager2.adapter.a_renamed.c_renamed> it = this.f1825a.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().a_renamed(fragment));
            }
            return arrayList;
        }
    }

    /* compiled from: FragmentStateAdapter.java */
    public static abstract class c_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private static final androidx.viewpager2.adapter.a_renamed.c_renamed.FragmentStateAdapter_5 f1829a = new androidx.viewpager2.adapter.a_renamed.c_renamed.FragmentStateAdapter_5() { // from class: androidx.viewpager2.adapter.a_renamed.c_renamed.1
            @Override // androidx.viewpager2.adapter.a_renamed.c_renamed.FragmentStateAdapter_5
            public void a_renamed() {
            }
        };

        /* compiled from: FragmentStateAdapter.java */
        /* renamed from: androidx.viewpager2.adapter.a_renamed$c_renamed$a_renamed, reason: collision with other inner class name */
        public interface FragmentStateAdapter_5 {
            void a_renamed();
        }

        public androidx.viewpager2.adapter.a_renamed.c_renamed.FragmentStateAdapter_5 a_renamed(androidx.fragment.app.Fragment fragment) {
            return f1829a;
        }

        public androidx.viewpager2.adapter.a_renamed.c_renamed.FragmentStateAdapter_5 a_renamed(androidx.fragment.app.Fragment fragment, androidx.lifecycle.e_renamed.b_renamed bVar) {
            return f1829a;
        }
    }
}
