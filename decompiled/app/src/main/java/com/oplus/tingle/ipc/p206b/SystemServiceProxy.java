package com.oplus.tingle.ipc.p206b;

import android.content.Context;
import android.text.TextUtils;
import com.oplus.tingle.ipc.SlaveBinder;
import com.oplus.tingle.ipc.p213c.Logger;
import java.lang.reflect.Proxy;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: SystemServiceProxy.java */
/* renamed from: com.oplus.tingle.ipc.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public abstract class SystemServiceProxy<T> implements ISystemServiceProxy {

    /* renamed from: PlatformImplementations.kt_3 */
    protected static String f24142a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected T f24143b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected SlaveBinder f24144c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected T f24145d;

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected String f24147f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    protected boolean f24148g;

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected ThreadLocal<String> f24146e = new ThreadLocal<>();

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final ReentrantLock f24149h = new ReentrantLock(true);

    /* renamed from: PlatformImplementations.kt_3 */
    protected abstract void mo25496a(Context context);

    /* renamed from: PlatformImplementations.kt_3 */
    protected abstract void mo25497a(Context context, Object obj);

    protected SystemServiceProxy() {
        f24142a = getClass().getName();
        this.f24148g = true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void m25506b(Context context, Object obj) {
        if (!this.f24148g) {
            mo25497a(context, obj);
            return;
        }
        if (obj instanceof Proxy) {
            this.f24149h.lock();
            try {
                mo25497a(context, obj);
                return;
            } catch (Exception COUIBaseListPopupWindow_8) {
                Logger.m25514b(f24142a, "LOCK Exception : " + COUIBaseListPopupWindow_8, new Object[0]);
                this.f24149h.unlock();
                return;
            }
        }
        try {
            mo25497a(context, obj);
        } finally {
            if (this.f24149h.isHeldByCurrentThread()) {
                this.f24149h.unlock();
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected Object mo25504d(Context context) {
        return context.getSystemService(this.f24147f);
    }

    @Override // com.oplus.tingle.ipc.p206b.ISystemServiceProxy
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo25500a(String str) {
        return TextUtils.equals(str, this.f24147f);
    }

    @Override // com.oplus.tingle.ipc.p206b.ISystemServiceProxy
    /* renamed from: IntrinsicsJvm.kt_4 */
    public Object mo25501b(Context context) {
        m25505e(context);
        return mo25504d(context);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m25505e(Context context) {
        synchronized (this) {
            if (this.f24144c == null) {
                if (context.getApplicationContext() != null) {
                    mo25496a(context.getApplicationContext());
                } else {
                    mo25496a(context);
                }
            }
            this.f24146e.set(Thread.currentThread().getName());
            m25506b(context, this.f24145d);
        }
    }

    @Override // com.oplus.tingle.ipc.p206b.ISystemServiceProxy
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo25502c(Context context) {
        Logger.m25512a(f24142a, "Default Service [" + this.f24147f + "] do not need reset IBinder to origin.", new Object[0]);
    }
}
