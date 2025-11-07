package androidx.transition;

/* compiled from: TransitionManager.java */
/* loaded from: classes.dex */
public class o_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    private static androidx.transition.m_renamed f1739b = new androidx.transition.b_renamed();

    /* renamed from: c_renamed, reason: collision with root package name */
    private static java.lang.ThreadLocal<java.lang.ref.WeakReference<androidx.collection.ArrayMap<android.view.ViewGroup, java.util.ArrayList<androidx.transition.m_renamed>>>> f1740c = new java.lang.ThreadLocal<>();

    /* renamed from: a_renamed, reason: collision with root package name */
    static java.util.ArrayList<android.view.ViewGroup> f1738a = new java.util.ArrayList<>();

    static androidx.collection.ArrayMap<android.view.ViewGroup, java.util.ArrayList<androidx.transition.m_renamed>> a_renamed() {
        androidx.collection.ArrayMap<android.view.ViewGroup, java.util.ArrayList<androidx.transition.m_renamed>> arrayMap;
        java.lang.ref.WeakReference<androidx.collection.ArrayMap<android.view.ViewGroup, java.util.ArrayList<androidx.transition.m_renamed>>> weakReference = f1740c.get();
        if (weakReference != null && (arrayMap = weakReference.get()) != null) {
            return arrayMap;
        }
        androidx.collection.ArrayMap<android.view.ViewGroup, java.util.ArrayList<androidx.transition.m_renamed>> arrayMap2 = new androidx.collection.ArrayMap<>();
        f1740c.set(new java.lang.ref.WeakReference<>(arrayMap2));
        return arrayMap2;
    }

    private static void b_renamed(android.view.ViewGroup viewGroup, androidx.transition.m_renamed mVar) {
        if (mVar == null || viewGroup == null) {
            return;
        }
        androidx.transition.o_renamed.a_renamed aVar = new androidx.transition.o_renamed.a_renamed(mVar, viewGroup);
        viewGroup.addOnAttachStateChangeListener(aVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
    }

    /* compiled from: TransitionManager.java */
    private static class a_renamed implements android.view.View.OnAttachStateChangeListener, android.view.ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a_renamed, reason: collision with root package name */
        androidx.transition.m_renamed f1741a;

        /* renamed from: b_renamed, reason: collision with root package name */
        android.view.ViewGroup f1742b;

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(android.view.View view) {
        }

        a_renamed(androidx.transition.m_renamed mVar, android.view.ViewGroup viewGroup) {
            this.f1741a = mVar;
            this.f1742b = viewGroup;
        }

        private void a_renamed() {
            this.f1742b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f1742b.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(android.view.View view) {
            a_renamed();
            androidx.transition.o_renamed.f1738a.remove(this.f1742b);
            java.util.ArrayList<androidx.transition.m_renamed> arrayList = androidx.transition.o_renamed.a_renamed().get(this.f1742b);
            if (arrayList != null && arrayList.size() > 0) {
                java.util.Iterator<androidx.transition.m_renamed> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().resume(this.f1742b);
                }
            }
            this.f1741a.clearValues(true);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a_renamed();
            if (!androidx.transition.o_renamed.f1738a.remove(this.f1742b)) {
                return true;
            }
            final androidx.collection.ArrayMap<android.view.ViewGroup, java.util.ArrayList<androidx.transition.m_renamed>> arrayMapA = androidx.transition.o_renamed.a_renamed();
            java.util.ArrayList<androidx.transition.m_renamed> arrayList = arrayMapA.get(this.f1742b);
            java.util.ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new java.util.ArrayList<>();
                arrayMapA.put(this.f1742b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new java.util.ArrayList(arrayList);
            }
            arrayList.add(this.f1741a);
            this.f1741a.addListener(new androidx.transition.n_renamed() { // from class: androidx.transition.o_renamed.a_renamed.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // androidx.transition.n_renamed, androidx.transition.m_renamed.d_renamed
                public void b_renamed(androidx.transition.m_renamed mVar) {
                    ((java.util.ArrayList) arrayMapA.get(androidx.transition.o_renamed.a_renamed.this.f1742b)).remove(mVar);
                    mVar.removeListener(this);
                }
            });
            this.f1741a.captureValues(this.f1742b, false);
            if (arrayList2 != null) {
                java.util.Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((androidx.transition.m_renamed) it.next()).resume(this.f1742b);
                }
            }
            this.f1741a.playTransition(this.f1742b);
            return true;
        }
    }

    private static void c_renamed(android.view.ViewGroup viewGroup, androidx.transition.m_renamed mVar) {
        java.util.ArrayList<androidx.transition.m_renamed> arrayList = a_renamed().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            java.util.Iterator<androidx.transition.m_renamed> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().pause(viewGroup);
            }
        }
        if (mVar != null) {
            mVar.captureValues(viewGroup, true);
        }
        androidx.transition.k_renamed kVarA = androidx.transition.k_renamed.a_renamed(viewGroup);
        if (kVarA != null) {
            kVarA.a_renamed();
        }
    }

    public static void a_renamed(android.view.ViewGroup viewGroup, androidx.transition.m_renamed mVar) {
        if (f1738a.contains(viewGroup) || !androidx.core.h_renamed.v_renamed.A_renamed(viewGroup)) {
            return;
        }
        f1738a.add(viewGroup);
        if (mVar == null) {
            mVar = f1739b;
        }
        androidx.transition.m_renamed mVarMo2clone = mVar.mo2clone();
        c_renamed(viewGroup, mVarMo2clone);
        androidx.transition.k_renamed.a_renamed(viewGroup, null);
        b_renamed(viewGroup, mVarMo2clone);
    }
}
