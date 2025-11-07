package com.airbnb.lottie;

/* compiled from: LottieTask.java */
/* loaded from: classes.dex */
public class m_renamed<T_renamed> {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static java.util.concurrent.Executor f2282a = java.util.concurrent.Executors.newCachedThreadPool();

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.util.Set<com.airbnb.lottie.h_renamed<T_renamed>> f2283b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final java.util.Set<com.airbnb.lottie.h_renamed<java.lang.Throwable>> f2284c;
    private final android.os.Handler d_renamed;
    private volatile com.airbnb.lottie.l_renamed<T_renamed> e_renamed;

    public m_renamed(java.util.concurrent.Callable<com.airbnb.lottie.l_renamed<T_renamed>> callable) {
        this(callable, false);
    }

    m_renamed(java.util.concurrent.Callable<com.airbnb.lottie.l_renamed<T_renamed>> callable, boolean z_renamed) {
        this.f2283b = new java.util.LinkedHashSet(1);
        this.f2284c = new java.util.LinkedHashSet(1);
        this.d_renamed = new android.os.Handler(android.os.Looper.getMainLooper());
        this.e_renamed = null;
        if (z_renamed) {
            try {
                a_renamed((com.airbnb.lottie.l_renamed) callable.call());
                return;
            } catch (java.lang.Throwable th) {
                a_renamed((com.airbnb.lottie.l_renamed) new com.airbnb.lottie.l_renamed<>(th));
                return;
            }
        }
        f2282a.execute(new com.airbnb.lottie.m_renamed.a_renamed(callable));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(com.airbnb.lottie.l_renamed<T_renamed> lVar) {
        if (this.e_renamed != null) {
            throw new java.lang.IllegalStateException("A_renamed task may only be_renamed set once.");
        }
        this.e_renamed = lVar;
        a_renamed();
    }

    public synchronized com.airbnb.lottie.m_renamed<T_renamed> a_renamed(com.airbnb.lottie.h_renamed<T_renamed> hVar) {
        if (this.e_renamed != null && this.e_renamed.a_renamed() != null) {
            hVar.a_renamed(this.e_renamed.a_renamed());
        }
        this.f2283b.add(hVar);
        return this;
    }

    public synchronized com.airbnb.lottie.m_renamed<T_renamed> b_renamed(com.airbnb.lottie.h_renamed<T_renamed> hVar) {
        this.f2283b.remove(hVar);
        return this;
    }

    public synchronized com.airbnb.lottie.m_renamed<T_renamed> c_renamed(com.airbnb.lottie.h_renamed<java.lang.Throwable> hVar) {
        if (this.e_renamed != null && this.e_renamed.b_renamed() != null) {
            hVar.a_renamed(this.e_renamed.b_renamed());
        }
        this.f2284c.add(hVar);
        return this;
    }

    public synchronized com.airbnb.lottie.m_renamed<T_renamed> d_renamed(com.airbnb.lottie.h_renamed<java.lang.Throwable> hVar) {
        this.f2284c.remove(hVar);
        return this;
    }

    private void a_renamed() {
        this.d_renamed.post(new java.lang.Runnable() { // from class: com.airbnb.lottie.m_renamed.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.airbnb.lottie.m_renamed.this.e_renamed == null) {
                    return;
                }
                com.airbnb.lottie.l_renamed lVar = com.airbnb.lottie.m_renamed.this.e_renamed;
                if (lVar.a_renamed() != null) {
                    com.airbnb.lottie.m_renamed.this.a_renamed((com.airbnb.lottie.m_renamed) lVar.a_renamed());
                } else {
                    com.airbnb.lottie.m_renamed.this.a_renamed(lVar.b_renamed());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a_renamed(T_renamed t_renamed) {
        java.util.Iterator it = new java.util.ArrayList(this.f2283b).iterator();
        while (it.hasNext()) {
            ((com.airbnb.lottie.h_renamed) it.next()).a_renamed(t_renamed);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a_renamed(java.lang.Throwable th) {
        java.util.ArrayList arrayList = new java.util.ArrayList(this.f2284c);
        if (arrayList.isEmpty()) {
            com.airbnb.lottie.f_renamed.d_renamed.a_renamed("Lottie encountered an_renamed error but no failure listener was added:", th);
            return;
        }
        java.util.Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((com.airbnb.lottie.h_renamed) it.next()).a_renamed(th);
        }
    }

    /* compiled from: LottieTask.java */
    private class a_renamed extends java.util.concurrent.FutureTask<com.airbnb.lottie.l_renamed<T_renamed>> {
        a_renamed(java.util.concurrent.Callable<com.airbnb.lottie.l_renamed<T_renamed>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            if (isCancelled()) {
                return;
            }
            try {
                com.airbnb.lottie.m_renamed.this.a_renamed((com.airbnb.lottie.l_renamed) get());
            } catch (java.lang.InterruptedException | java.util.concurrent.ExecutionException e_renamed) {
                com.airbnb.lottie.m_renamed.this.a_renamed(new com.airbnb.lottie.l_renamed(e_renamed));
            }
        }
    }
}
