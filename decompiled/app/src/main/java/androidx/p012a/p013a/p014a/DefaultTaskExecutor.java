package androidx.p012a.p013a.p014a;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: DefaultTaskExecutor.java */
/* renamed from: androidx.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public class DefaultTaskExecutor extends TaskExecutor {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Object f695a = new Object();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final ExecutorService f696b = Executors.newFixedThreadPool(4, new ThreadFactory() { // from class: androidx.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.1

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final AtomicInteger f699b = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format("arch_disk_io_%IntrinsicsJvm.kt_5", Integer.valueOf(this.f699b.getAndIncrement())));
            return thread;
        }
    });

    /* renamed from: IntrinsicsJvm.kt_3 */
    private volatile Handler f697c;

    @Override // androidx.p012a.p013a.p014a.TaskExecutor
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo693a(Runnable runnable) {
        this.f696b.execute(runnable);
    }

    @Override // androidx.p012a.p013a.p014a.TaskExecutor
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo694b(Runnable runnable) {
        if (this.f697c == null) {
            synchronized (this.f695a) {
                if (this.f697c == null) {
                    this.f697c = m696a(Looper.getMainLooper());
                }
            }
        }
        this.f697c.post(runnable);
    }

    @Override // androidx.p012a.p013a.p014a.TaskExecutor
    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean mo695c() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static Handler m696a(Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Handler.createAsync(looper);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, true);
            } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
            } catch (InvocationTargetException unused2) {
                return new Handler(looper);
            }
        }
        return new Handler(looper);
    }
}
