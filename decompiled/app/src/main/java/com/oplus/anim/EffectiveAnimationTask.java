package com.oplus.anim;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.heytap.accessory.CommonStatusCodes;
import com.oplus.anim.p121f.OplusLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* compiled from: EffectiveAnimationTask.java */
/* renamed from: com.oplus.anim.COUIBaseListPopupWindow_12 */
/* loaded from: classes2.dex */
public class EffectiveAnimationTask<T> {

    /* renamed from: PlatformImplementations.kt_3 */
    public static Executor f10364a = Executors.newCachedThreadPool();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Set<EffectiveAnimationListener<T>> f10365b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final Set<EffectiveAnimationListener<Throwable>> f10366c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final Handler f10367d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private volatile EffectiveAnimationResult<T> f10368e;

    public EffectiveAnimationTask(Callable<EffectiveAnimationResult<T>> callable) {
        this(callable, false);
    }

    EffectiveAnimationTask(Callable<EffectiveAnimationResult<T>> callable, boolean z) {
        this.f10365b = new LinkedHashSet(1);
        this.f10366c = new LinkedHashSet(1);
        this.f10367d = new Handler(Looper.getMainLooper()) { // from class: com.oplus.anim.COUIBaseListPopupWindow_12.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 1001) {
                    return;
                }
                EffectiveAnimationTask.this.m9236d();
            }
        };
        this.f10368e = null;
        if (z) {
            try {
                m9230a((EffectiveAnimationResult) callable.call());
                return;
            } catch (Throwable th) {
                m9230a((EffectiveAnimationResult) new EffectiveAnimationResult<>(th));
                return;
            }
        }
        f10364a.execute(new PlatformImplementations.kt_3(callable));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m9230a(EffectiveAnimationResult<T> c2365e) {
        if (this.f10368e != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.f10368e = c2365e;
        OplusLog.m9286b("Load anim composition done,setting result!!!");
        m9235c();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public synchronized EffectiveAnimationTask<T> m9238a(EffectiveAnimationListener<T> interfaceC2312c) {
        if (this.f10368e != null && this.f10368e.m9154a() != null) {
            OplusLog.m9286b("EffectiveAnimationTask addListener listener.onResult");
            interfaceC2312c.mo8781a(this.f10368e.m9154a());
            return this;
        }
        this.f10365b.add(interfaceC2312c);
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public synchronized EffectiveAnimationTask<T> m9240b(EffectiveAnimationListener<Throwable> interfaceC2312c) {
        if (this.f10368e != null && this.f10368e.m9155b() != null) {
            interfaceC2312c.mo8781a(this.f10368e.m9155b());
            return this;
        }
        this.f10366c.add(interfaceC2312c);
        return this;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public synchronized EffectiveAnimationTask<T> m9237a() {
        this.f10366c.clear();
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public synchronized EffectiveAnimationTask<T> m9239b() {
        this.f10365b.clear();
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m9235c() {
        Message messageObtainMessage = this.f10367d.obtainMessage(CommonStatusCodes.AUTHENTICATE_SUCCESS);
        messageObtainMessage.setAsynchronous(true);
        this.f10367d.sendMessageAtFrontOfQueue(messageObtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m9236d() {
        boolean z = Looper.getMainLooper() == Looper.myLooper();
        if (this.f10368e == null || !z) {
            return;
        }
        EffectiveAnimationResult<T> c2365e = this.f10368e;
        if (c2365e.m9154a() != null) {
            m9233a((EffectiveAnimationTask<T>) c2365e.m9154a());
        } else {
            m9234a(c2365e.m9155b());
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private synchronized void m9233a(T t) {
        Iterator it = new ArrayList(this.f10365b).iterator();
        while (it.hasNext()) {
            ((EffectiveAnimationListener) it.next()).mo8781a(t);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private synchronized void m9234a(Throwable th) {
        ArrayList arrayList = new ArrayList(this.f10366c);
        if (arrayList.isEmpty()) {
            Log.w("EffectiveAnimation", "EffectiveAnimation encountered an error but no failure listener was added.", th);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((EffectiveAnimationListener) it.next()).mo8781a(th);
        }
    }

    /* compiled from: EffectiveAnimationTask.java */
    /* renamed from: com.oplus.anim.COUIBaseListPopupWindow_12$PlatformImplementations.kt_3 */
    private class PlatformImplementations.kt_3 extends FutureTask<EffectiveAnimationResult<T>> {
        PlatformImplementations.kt_3(Callable<EffectiveAnimationResult<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            if (isCancelled()) {
                return;
            }
            try {
                EffectiveAnimationTask.this.m9230a((EffectiveAnimationResult) get());
            } catch (InterruptedException | ExecutionException COUIBaseListPopupWindow_8) {
                EffectiveAnimationTask.this.m9230a(new EffectiveAnimationResult(COUIBaseListPopupWindow_8));
            }
        }
    }
}
