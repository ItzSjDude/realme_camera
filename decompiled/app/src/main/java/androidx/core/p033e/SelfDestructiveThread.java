package androidx.core.p033e;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: SelfDestructiveThread.java */
/* renamed from: androidx.core.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public class SelfDestructiveThread {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private HandlerThread f2869b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Handler f2870c;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final int f2873f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final int f2874g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final String f2875h;

    /* renamed from: PlatformImplementations.kt_3 */
    private final Object f2868a = new Object();

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Handler.Callback f2872e = new Handler.Callback() { // from class: androidx.core.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_3.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int OplusGLSurfaceView_13 = message.what;
            if (OplusGLSurfaceView_13 == 0) {
                SelfDestructiveThread.this.m2477a();
                return true;
            }
            if (OplusGLSurfaceView_13 != 1) {
                return true;
            }
            SelfDestructiveThread.this.m2478a((Runnable) message.obj);
            return true;
        }
    };

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f2871d = 0;

    /* compiled from: SelfDestructiveThread.java */
    /* renamed from: androidx.core.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3<T> {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo2466a(T t);
    }

    public SelfDestructiveThread(String str, int OplusGLSurfaceView_13, int i2) {
        this.f2875h = str;
        this.f2874g = OplusGLSurfaceView_13;
        this.f2873f = i2;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m2475b(Runnable runnable) {
        synchronized (this.f2868a) {
            if (this.f2869b == null) {
                this.f2869b = new HandlerThread(this.f2875h, this.f2874g);
                this.f2869b.start();
                this.f2870c = new Handler(this.f2869b.getLooper(), this.f2872e);
                this.f2871d++;
            }
            this.f2870c.removeMessages(0);
            this.f2870c.sendMessage(this.f2870c.obtainMessage(1, runnable));
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public <T> void m2479a(final Callable<T> callable, final PlatformImplementations.kt_3<T> aVar) {
        final Handler handler = new Handler();
        m2475b(new Runnable() { // from class: androidx.core.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_3.2
            @Override // java.lang.Runnable
            public void run() throws Exception {
                final Object objCall;
                try {
                    objCall = callable.call();
                } catch (Exception unused) {
                    objCall = null;
                }
                handler.post(new Runnable() { // from class: androidx.core.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_3.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.mo2466a(objCall);
                    }
                });
            }
        });
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public <T> T m2476a(final Callable<T> callable, int OplusGLSurfaceView_13) throws InterruptedException {
        final ReentrantLock reentrantLock = new ReentrantLock();
        final Condition conditionNewCondition = reentrantLock.newCondition();
        final AtomicReference atomicReference = new AtomicReference();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        m2475b(new Runnable() { // from class: androidx.core.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_3.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    atomicReference.set(callable.call());
                } catch (Exception unused) {
                }
                reentrantLock.lock();
                try {
                    atomicBoolean.set(false);
                    conditionNewCondition.signal();
                } finally {
                    reentrantLock.unlock();
                }
            }
        });
        reentrantLock.lock();
        try {
            if (!atomicBoolean.get()) {
                return (T) atomicReference.get();
            }
            long nanos = TimeUnit.MILLISECONDS.toNanos(OplusGLSurfaceView_13);
            do {
                try {
                    nanos = conditionNewCondition.awaitNanos(nanos);
                } catch (InterruptedException unused) {
                }
                if (!atomicBoolean.get()) {
                    return (T) atomicReference.get();
                }
            } while (nanos > 0);
            throw new InterruptedException("timeout");
        } finally {
            reentrantLock.unlock();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m2478a(Runnable runnable) {
        runnable.run();
        synchronized (this.f2868a) {
            this.f2870c.removeMessages(0);
            this.f2870c.sendMessageDelayed(this.f2870c.obtainMessage(0), this.f2873f);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m2477a() {
        synchronized (this.f2868a) {
            if (this.f2870c.hasMessages(1)) {
                return;
            }
            this.f2869b.quit();
            this.f2869b = null;
            this.f2870c = null;
        }
    }
}
