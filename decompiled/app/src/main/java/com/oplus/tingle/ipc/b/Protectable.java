package com.oplus.tingle.ipc.b_renamed;

/* compiled from: SystemServiceProxy.java */
/* loaded from: classes2.dex */
public abstract class c_renamed<T_renamed> implements com.oplus.tingle.ipc.b_renamed.b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    protected static java.lang.String f7749a;

    /* renamed from: b_renamed, reason: collision with root package name */
    protected T_renamed f7750b;

    /* renamed from: c_renamed, reason: collision with root package name */
    protected com.oplus.tingle.ipc.c_renamed f7751c;
    protected T_renamed d_renamed;
    protected java.lang.String f_renamed;
    protected boolean g_renamed;
    protected java.lang.ThreadLocal<java.lang.String> e_renamed = new java.lang.ThreadLocal<>();
    private final java.util.concurrent.locks.ReentrantLock h_renamed = new java.util.concurrent.locks.ReentrantLock(true);

    protected abstract void a_renamed(android.content.Context context);

    protected abstract void a_renamed(android.content.Context context, java.lang.Object obj);

    protected c_renamed() {
        f7749a = getClass().getName();
        this.g_renamed = true;
    }

    protected void b_renamed(android.content.Context context, java.lang.Object obj) {
        if (!this.g_renamed) {
            a_renamed(context, obj);
            return;
        }
        if (obj instanceof java.lang.reflect.Proxy) {
            this.h_renamed.lock();
            try {
                a_renamed(context, obj);
                return;
            } catch (java.lang.Exception e_renamed) {
                com.oplus.tingle.ipc.c_renamed.a_renamed.b_renamed(f7749a, "LOCK Exception : " + e_renamed, new java.lang.Object[0]);
                this.h_renamed.unlock();
                return;
            }
        }
        try {
            a_renamed(context, obj);
        } finally {
            if (this.h_renamed.isHeldByCurrentThread()) {
                this.h_renamed.unlock();
            }
        }
    }

    protected java.lang.Object d_renamed(android.content.Context context) {
        return context.getSystemService(this.f_renamed);
    }

    @Override // com.oplus.tingle.ipc.b_renamed.b_renamed
    public boolean a_renamed(java.lang.String str) {
        return android.text.TextUtils.equals(str, this.f_renamed);
    }

    @Override // com.oplus.tingle.ipc.b_renamed.b_renamed
    public java.lang.Object b_renamed(android.content.Context context) {
        e_renamed(context);
        return d_renamed(context);
    }

    private void e_renamed(android.content.Context context) {
        synchronized (this) {
            if (this.f7751c == null) {
                if (context.getApplicationContext() != null) {
                    a_renamed(context.getApplicationContext());
                } else {
                    a_renamed(context);
                }
            }
            this.e_renamed.set(java.lang.Thread.currentThread().getName());
            b_renamed(context, this.d_renamed);
        }
    }

    @Override // com.oplus.tingle.ipc.b_renamed.b_renamed
    public void c_renamed(android.content.Context context) {
        com.oplus.tingle.ipc.c_renamed.a_renamed.a_renamed(f7749a, "Default Service [" + this.f_renamed + "] do not need reset IBinder to origin.", new java.lang.Object[0]);
    }
}
