package kotlinx.coroutines;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import p061c.p064c.CoroutineContext.kt_4;
import p061c.p074h.C0987d;
import p061c.p077k.C1005d;

/* compiled from: CommonPool.kt */
/* renamed from: kotlinx.coroutines.OplusGLSurfaceView_5 */
/* loaded from: classes2.dex */
public final class CommonPool.kt extends Executors.kt {

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final CommonPool.kt f24728b = new CommonPool.kt();

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static final int f24729e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private static boolean f24730f;
    private static volatile Executor pool;

    /* compiled from: CommonPool.kt */
    /* renamed from: kotlinx.coroutines.OplusGLSurfaceView_5$IntrinsicsJvm.kt_4 */
    static final class IntrinsicsJvm.kt_4 implements Runnable {

        /* renamed from: PlatformImplementations.kt_3 */
        public static final IntrinsicsJvm.kt_4 f24732a = new IntrinsicsJvm.kt_4();

        IntrinsicsJvm.kt_4() {
        }

        @Override // java.lang.Runnable
        public final void run() {
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher.kt
    public String toString() {
        return "CommonPool";
    }

    static {
        String property;
        int iIntValue;
        CommonPool.kt c3949k = f24728b;
        try {
            property = System.getProperty("kotlinx.coroutines.default.parallelism");
        } catch (Throwable unused) {
            property = null;
        }
        if (property != null) {
            Integer numA = C1005d.m5350a(property);
            if (numA == null || numA.intValue() < 1) {
                throw new IllegalStateException(("Expected positive number in kotlinx.coroutines.default.parallelism, but has " + property).toString());
            }
            iIntValue = numA.intValue();
        } else {
            iIntValue = -1;
        }
        f24729e = iIntValue;
    }

    private CommonPool.kt() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private final int m25932a() {
        Integer numValueOf = Integer.valueOf(f24729e);
        if (!(numValueOf.intValue() > 0)) {
            numValueOf = null;
        }
        return numValueOf != null ? numValueOf.intValue() : C0987d.m5336b(Runtime.getRuntime().availableProcessors() - 1, 1);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final ExecutorService m25933b() {
        Class<?> cls;
        ExecutorService executorService;
        if (System.getSecurityManager() != null) {
            return m25934c();
        }
        ExecutorService executorService2 = null;
        try {
            cls = Class.forName("java.util.concurrent.ForkJoinPool");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return m25934c();
        }
        if (!f24730f && f24729e < 0) {
            try {
                Method method = cls.getMethod("commonPool", new Class[0]);
                Object objInvoke = method != null ? method.invoke(null, new Object[0]) : null;
                if (!(objInvoke instanceof ExecutorService)) {
                    objInvoke = null;
                }
                executorService = (ExecutorService) objInvoke;
            } catch (Throwable unused2) {
                executorService = null;
            }
            if (executorService != null) {
                if (!f24728b.m25936a(cls, executorService)) {
                    executorService = null;
                }
                if (executorService != null) {
                    return executorService;
                }
            }
        }
        try {
            Object objNewInstance = cls.getConstructor(Integer.TYPE).newInstance(Integer.valueOf(f24728b.m25932a()));
            if (!(objNewInstance instanceof ExecutorService)) {
                objNewInstance = null;
            }
            executorService2 = (ExecutorService) objNewInstance;
        } catch (Throwable unused3) {
        }
        return executorService2 != null ? executorService2 : m25934c();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final boolean m25936a(Class<?> cls, ExecutorService executorService) {
        executorService.submit(IntrinsicsJvm.kt_4.f24732a);
        Integer num = null;
        try {
            Object objInvoke = cls.getMethod("getPoolSize", new Class[0]).invoke(executorService, new Object[0]);
            if (!(objInvoke instanceof Integer)) {
                objInvoke = null;
            }
            num = (Integer) objInvoke;
        } catch (Throwable unused) {
        }
        return num != null && num.intValue() >= 1;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final ExecutorService m25934c() {
        return Executors.newFixedThreadPool(m25932a(), new PlatformImplementations.kt_3(new AtomicInteger()));
    }

    /* compiled from: CommonPool.kt */
    /* renamed from: kotlinx.coroutines.OplusGLSurfaceView_5$PlatformImplementations.kt_3 */
    static final class PlatformImplementations.kt_3 implements ThreadFactory {

        /* renamed from: PlatformImplementations.kt_3 */
        final /* synthetic */ AtomicInteger f24731a;

        PlatformImplementations.kt_3(AtomicInteger atomicInteger) {
            this.f24731a = atomicInteger;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "CommonPool-worker-" + this.f24731a.incrementAndGet());
            thread.setDaemon(true);
            return thread;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final synchronized Executor m25935d() {
        ExecutorService executorService;
        executorService = pool;
        if (executorService == null) {
            ExecutorService executorServiceM25933b = m25933b();
            pool = executorServiceM25933b;
            executorService = executorServiceM25933b;
        }
        return executorService;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher.kt
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo25629a(CoroutineContext.kt_4 interfaceC0932g, Runnable runnable) {
        Runnable runnableM25799a;
        try {
            Executor executorM25935d = pool;
            if (executorM25935d == null) {
                executorM25935d = m25935d();
            }
            TimeSource.kt interfaceC3911bnM25806a = TimeSource.kt_2.m25806a();
            if (interfaceC3911bnM25806a == null || (runnableM25799a = interfaceC3911bnM25806a.m25799a(runnable)) == null) {
                runnableM25799a = runnable;
            }
            executorM25935d.execute(runnableM25799a);
        } catch (RejectedExecutionException unused) {
            TimeSource.kt interfaceC3911bnM25806a2 = TimeSource.kt_2.m25806a();
            if (interfaceC3911bnM25806a2 != null) {
                interfaceC3911bnM25806a2.m25803c();
            }
            DefaultExecutor.kt.f24556b.m25630a(runnable);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on CommonPool".toString());
    }
}
