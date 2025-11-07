package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import com.airbnb.lottie.p091f.Logger_3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* compiled from: LottieTask.java */
/* renamed from: com.airbnb.lottie.OplusGLSurfaceView_6 */
/* loaded from: classes.dex */
public class LottieTask<T> {

    /* renamed from: PlatformImplementations.kt_3 */
    public static Executor f5956a = Executors.newCachedThreadPool();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Set<LottieListener<T>> f5957b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final Set<LottieListener<Throwable>> f5958c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final Handler f5959d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private volatile LottieResult<T> f5960e;

    public LottieTask(Callable<LottieResult<T>> callable) {
        this(callable, false);
    }

    LottieTask(Callable<LottieResult<T>> callable, boolean z) {
        this.f5957b = new LinkedHashSet(1);
        this.f5958c = new LinkedHashSet(1);
        this.f5959d = new Handler(Looper.getMainLooper());
        this.f5960e = null;
        if (z) {
            try {
                m6183a((LottieResult) callable.call());
                return;
            } catch (Throwable th) {
                m6183a((LottieResult) new LottieResult<>(th));
                return;
            }
        }
        f5956a.execute(new PlatformImplementations.kt_3(callable));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m6183a(LottieResult<T> c1206l) {
        if (this.f5960e != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.f5960e = c1206l;
        m6182a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public synchronized LottieTask<T> m6189a(LottieListener<T> interfaceC1202h) {
        if (this.f5960e != null && this.f5960e.m6179a() != null) {
            interfaceC1202h.mo5520a(this.f5960e.m6179a());
        }
        this.f5957b.add(interfaceC1202h);
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public synchronized LottieTask<T> m6190b(LottieListener<T> interfaceC1202h) {
        this.f5957b.remove(interfaceC1202h);
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public synchronized LottieTask<T> m6191c(LottieListener<Throwable> interfaceC1202h) {
        if (this.f5960e != null && this.f5960e.m6180b() != null) {
            interfaceC1202h.mo5520a(this.f5960e.m6180b());
        }
        this.f5958c.add(interfaceC1202h);
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public synchronized LottieTask<T> m6192d(LottieListener<Throwable> interfaceC1202h) {
        this.f5958c.remove(interfaceC1202h);
        return this;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m6182a() {
        this.f5959d.post(new Runnable() { // from class: com.airbnb.lottie.OplusGLSurfaceView_6.1
            @Override // java.lang.Runnable
            public void run() {
                if (LottieTask.this.f5960e == null) {
                    return;
                }
                LottieResult c1206l = LottieTask.this.f5960e;
                if (c1206l.m6179a() != null) {
                    LottieTask.this.m6187a((LottieTask) c1206l.m6179a());
                } else {
                    LottieTask.this.m6188a(c1206l.m6180b());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public synchronized void m6187a(T t) {
        Iterator it = new ArrayList(this.f5957b).iterator();
        while (it.hasNext()) {
            ((LottieListener) it.next()).mo5520a(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public synchronized void m6188a(Throwable th) {
        ArrayList arrayList = new ArrayList(this.f5958c);
        if (arrayList.isEmpty()) {
            Logger_3.m6099a("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((LottieListener) it.next()).mo5520a(th);
        }
    }

    /* compiled from: LottieTask.java */
    /* renamed from: com.airbnb.lottie.OplusGLSurfaceView_6$PlatformImplementations.kt_3 */
    private class PlatformImplementations.kt_3 extends FutureTask<LottieResult<T>> {
        PlatformImplementations.kt_3(Callable<LottieResult<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            if (isCancelled()) {
                return;
            }
            try {
                LottieTask.this.m6183a((LottieResult) get());
            } catch (InterruptedException | ExecutionException COUIBaseListPopupWindow_8) {
                LottieTask.this.m6183a(new LottieResult(COUIBaseListPopupWindow_8));
            }
        }
    }
}
