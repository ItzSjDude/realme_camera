package com.oplus.anim;

/* compiled from: EffectiveAnimationTask.java */
/* loaded from: classes2.dex */
public class f_renamed<T_renamed> {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static java.util.concurrent.Executor f3663a = java.util.concurrent.Executors.newCachedThreadPool();

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.util.Set<com.oplus.anim.c_renamed<T_renamed>> f3664b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final java.util.Set<com.oplus.anim.c_renamed<java.lang.Throwable>> f3665c;
    private final android.os.Handler d_renamed;
    private volatile com.oplus.anim.e_renamed<T_renamed> e_renamed;

    public f_renamed(java.util.concurrent.Callable<com.oplus.anim.e_renamed<T_renamed>> callable) {
        this(callable, false);
    }

    f_renamed(java.util.concurrent.Callable<com.oplus.anim.e_renamed<T_renamed>> callable, boolean z_renamed) {
        this.f3664b = new java.util.LinkedHashSet(1);
        this.f3665c = new java.util.LinkedHashSet(1);
        this.d_renamed = new android.os.Handler(android.os.Looper.getMainLooper()) { // from class: com.oplus.anim.f_renamed.1
            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                if (message.what != 1001) {
                    return;
                }
                com.oplus.anim.f_renamed.this.d_renamed();
            }
        };
        this.e_renamed = null;
        if (z_renamed) {
            try {
                a_renamed((com.oplus.anim.e_renamed) callable.call());
                return;
            } catch (java.lang.Throwable th) {
                a_renamed((com.oplus.anim.e_renamed) new com.oplus.anim.e_renamed<>(th));
                return;
            }
        }
        f3663a.execute(new com.oplus.anim.f_renamed.a_renamed(callable));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(com.oplus.anim.e_renamed<T_renamed> eVar) {
        if (this.e_renamed != null) {
            throw new java.lang.IllegalStateException("A_renamed task may only be_renamed set once.");
        }
        this.e_renamed = eVar;
        com.oplus.anim.f_renamed.f_renamed.b_renamed("Load anim composition done,setting result!!!");
        c_renamed();
    }

    public synchronized com.oplus.anim.f_renamed<T_renamed> a_renamed(com.oplus.anim.c_renamed<T_renamed> cVar) {
        if (this.e_renamed != null && this.e_renamed.a_renamed() != null) {
            com.oplus.anim.f_renamed.f_renamed.b_renamed("EffectiveAnimationTask addListener listener.onResult");
            cVar.a_renamed(this.e_renamed.a_renamed());
            return this;
        }
        this.f3664b.add(cVar);
        return this;
    }

    public synchronized com.oplus.anim.f_renamed<T_renamed> b_renamed(com.oplus.anim.c_renamed<java.lang.Throwable> cVar) {
        if (this.e_renamed != null && this.e_renamed.b_renamed() != null) {
            cVar.a_renamed(this.e_renamed.b_renamed());
            return this;
        }
        this.f3665c.add(cVar);
        return this;
    }

    public synchronized com.oplus.anim.f_renamed<T_renamed> a_renamed() {
        this.f3665c.clear();
        return this;
    }

    public synchronized com.oplus.anim.f_renamed<T_renamed> b_renamed() {
        this.f3664b.clear();
        return this;
    }

    private void c_renamed() {
        android.os.Message messageObtainMessage = this.d_renamed.obtainMessage(com.heytap.accessory.CommonStatusCodes.AUTHENTICATE_SUCCESS);
        messageObtainMessage.setAsynchronous(true);
        this.d_renamed.sendMessageAtFrontOfQueue(messageObtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d_renamed() {
        boolean z_renamed = android.os.Looper.getMainLooper() == android.os.Looper.myLooper();
        if (this.e_renamed == null || !z_renamed) {
            return;
        }
        com.oplus.anim.e_renamed<T_renamed> eVar = this.e_renamed;
        if (eVar.a_renamed() != null) {
            a_renamed((com.oplus.anim.f_renamed<T_renamed>) eVar.a_renamed());
        } else {
            a_renamed(eVar.b_renamed());
        }
    }

    private synchronized void a_renamed(T_renamed t_renamed) {
        java.util.Iterator it = new java.util.ArrayList(this.f3664b).iterator();
        while (it.hasNext()) {
            ((com.oplus.anim.c_renamed) it.next()).a_renamed(t_renamed);
        }
    }

    private synchronized void a_renamed(java.lang.Throwable th) {
        java.util.ArrayList arrayList = new java.util.ArrayList(this.f3665c);
        if (arrayList.isEmpty()) {
            android.util.Log.w_renamed("EffectiveAnimation", "EffectiveAnimation encountered an_renamed error but no failure listener was added.", th);
            return;
        }
        java.util.Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((com.oplus.anim.c_renamed) it.next()).a_renamed(th);
        }
    }

    /* compiled from: EffectiveAnimationTask.java */
    private class a_renamed extends java.util.concurrent.FutureTask<com.oplus.anim.e_renamed<T_renamed>> {
        a_renamed(java.util.concurrent.Callable<com.oplus.anim.e_renamed<T_renamed>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            if (isCancelled()) {
                return;
            }
            try {
                com.oplus.anim.f_renamed.this.a_renamed((com.oplus.anim.e_renamed) get());
            } catch (java.lang.InterruptedException | java.util.concurrent.ExecutionException e_renamed) {
                com.oplus.anim.f_renamed.this.a_renamed(new com.oplus.anim.e_renamed(e_renamed));
            }
        }
    }
}
