package androidx.activity;

/* loaded from: classes.dex */
public final class OnBackPressedDispatcher {

    /* renamed from: a_renamed, reason: collision with root package name */
    final java.util.ArrayDeque<androidx.activity.c_renamed> f181a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.lang.Runnable f182b;

    public OnBackPressedDispatcher() {
        this(null);
    }

    public OnBackPressedDispatcher(java.lang.Runnable runnable) {
        this.f181a = new java.util.ArrayDeque<>();
        this.f182b = runnable;
    }

    androidx.activity.a_renamed a_renamed(androidx.activity.c_renamed cVar) {
        this.f181a.add(cVar);
        androidx.activity.OnBackPressedDispatcher.a_renamed aVar = new androidx.activity.OnBackPressedDispatcher.a_renamed(cVar);
        cVar.a_renamed(aVar);
        return aVar;
    }

    public void a_renamed(androidx.lifecycle.h_renamed hVar, androidx.activity.c_renamed cVar) {
        androidx.lifecycle.e_renamed lifecycle = hVar.getLifecycle();
        if (lifecycle.a_renamed() == androidx.lifecycle.e_renamed.b_renamed.DESTROYED) {
            return;
        }
        cVar.a_renamed(new androidx.activity.OnBackPressedDispatcher.LifecycleOnBackPressedCancellable(lifecycle, cVar));
    }

    public void a_renamed() {
        java.util.Iterator<androidx.activity.c_renamed> itDescendingIterator = this.f181a.descendingIterator();
        while (itDescendingIterator.hasNext()) {
            androidx.activity.c_renamed next = itDescendingIterator.next();
            if (next.a_renamed()) {
                next.c_renamed();
                return;
            }
        }
        java.lang.Runnable runnable = this.f182b;
        if (runnable != null) {
            runnable.run();
        }
    }

    private class a_renamed implements androidx.activity.a_renamed {

        /* renamed from: b_renamed, reason: collision with root package name */
        private final androidx.activity.c_renamed f187b;

        a_renamed(androidx.activity.c_renamed cVar) {
            this.f187b = cVar;
        }

        @Override // androidx.activity.a_renamed
        public void a_renamed() {
            androidx.activity.OnBackPressedDispatcher.this.f181a.remove(this.f187b);
            this.f187b.b_renamed(this);
        }
    }

    private class LifecycleOnBackPressedCancellable implements androidx.activity.a_renamed, androidx.lifecycle.f_renamed {

        /* renamed from: b_renamed, reason: collision with root package name */
        private final androidx.lifecycle.e_renamed f184b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private final androidx.activity.c_renamed f185c;
        private androidx.activity.a_renamed d_renamed;

        LifecycleOnBackPressedCancellable(androidx.lifecycle.e_renamed eVar, androidx.activity.c_renamed cVar) {
            this.f184b = eVar;
            this.f185c = cVar;
            eVar.a_renamed(this);
        }

        @Override // androidx.lifecycle.f_renamed
        public void a_renamed(androidx.lifecycle.h_renamed hVar, androidx.lifecycle.e_renamed.a_renamed aVar) {
            if (aVar == androidx.lifecycle.e_renamed.a_renamed.ON_START) {
                this.d_renamed = androidx.activity.OnBackPressedDispatcher.this.a_renamed(this.f185c);
                return;
            }
            if (aVar == androidx.lifecycle.e_renamed.a_renamed.ON_STOP) {
                androidx.activity.a_renamed aVar2 = this.d_renamed;
                if (aVar2 != null) {
                    aVar2.a_renamed();
                    return;
                }
                return;
            }
            if (aVar == androidx.lifecycle.e_renamed.a_renamed.ON_DESTROY) {
                a_renamed();
            }
        }

        @Override // androidx.activity.a_renamed
        public void a_renamed() {
            this.f184b.b_renamed(this);
            this.f185c.b_renamed(this);
            androidx.activity.a_renamed aVar = this.d_renamed;
            if (aVar != null) {
                aVar.a_renamed();
                this.d_renamed = null;
            }
        }
    }
}
