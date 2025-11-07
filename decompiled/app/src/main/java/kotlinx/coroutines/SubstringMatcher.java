package kotlinx.coroutines;

/* compiled from: CommonPool.kt */
/* loaded from: classes2.dex */
public final class k_renamed extends kotlinx.coroutines.ar_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    public static final kotlinx.coroutines.k_renamed f7895b = new kotlinx.coroutines.k_renamed();
    private static final int e_renamed;
    private static boolean f_renamed;
    private static volatile java.util.concurrent.Executor pool;

    /* compiled from: CommonPool.kt */
    static final class b_renamed implements java.lang.Runnable {

        /* renamed from: a_renamed, reason: collision with root package name */
        public static final kotlinx.coroutines.k_renamed.b_renamed f7897a = new kotlinx.coroutines.k_renamed.b_renamed();

        b_renamed() {
        }

        @Override // java.lang.Runnable
        public final void run() {
        }
    }

    @Override // kotlinx.coroutines.t_renamed
    public java.lang.String toString() {
        return "CommonPool";
    }

    static {
        java.lang.String property;
        int iIntValue;
        kotlinx.coroutines.k_renamed kVar = f7895b;
        try {
            property = java.lang.System.getProperty("kotlinx.coroutines.default.parallelism");
        } catch (java.lang.Throwable unused) {
            property = null;
        }
        if (property != null) {
            java.lang.Integer numA = c_renamed.k_renamed.d_renamed.a_renamed(property);
            if (numA == null || numA.intValue() < 1) {
                throw new java.lang.IllegalStateException(("Expected positive number in_renamed kotlinx.coroutines.default.parallelism, but has " + property).toString());
            }
            iIntValue = numA.intValue();
        } else {
            iIntValue = -1;
        }
        e_renamed = iIntValue;
    }

    private k_renamed() {
    }

    private final int a_renamed() {
        java.lang.Integer numValueOf = java.lang.Integer.valueOf(e_renamed);
        if (!(numValueOf.intValue() > 0)) {
            numValueOf = null;
        }
        return numValueOf != null ? numValueOf.intValue() : c_renamed.h_renamed.d_renamed.b_renamed(java.lang.Runtime.getRuntime().availableProcessors() - 1, 1);
    }

    private final java.util.concurrent.ExecutorService b_renamed() {
        java.lang.Class<?> cls;
        java.util.concurrent.ExecutorService executorService;
        if (java.lang.System.getSecurityManager() != null) {
            return c_renamed();
        }
        java.util.concurrent.ExecutorService executorService2 = null;
        try {
            cls = java.lang.Class.forName("java.util.concurrent.ForkJoinPool");
        } catch (java.lang.Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return c_renamed();
        }
        if (!f_renamed && e_renamed < 0) {
            try {
                java.lang.reflect.Method method = cls.getMethod("commonPool", new java.lang.Class[0]);
                java.lang.Object objInvoke = method != null ? method.invoke(null, new java.lang.Object[0]) : null;
                if (!(objInvoke instanceof java.util.concurrent.ExecutorService)) {
                    objInvoke = null;
                }
                executorService = (java.util.concurrent.ExecutorService) objInvoke;
            } catch (java.lang.Throwable unused2) {
                executorService = null;
            }
            if (executorService != null) {
                if (!f7895b.a_renamed(cls, executorService)) {
                    executorService = null;
                }
                if (executorService != null) {
                    return executorService;
                }
            }
        }
        try {
            java.lang.Object objNewInstance = cls.getConstructor(java.lang.Integer.TYPE).newInstance(java.lang.Integer.valueOf(f7895b.a_renamed()));
            if (!(objNewInstance instanceof java.util.concurrent.ExecutorService)) {
                objNewInstance = null;
            }
            executorService2 = (java.util.concurrent.ExecutorService) objNewInstance;
        } catch (java.lang.Throwable unused3) {
        }
        return executorService2 != null ? executorService2 : c_renamed();
    }

    public final boolean a_renamed(java.lang.Class<?> cls, java.util.concurrent.ExecutorService executorService) {
        executorService.submit(kotlinx.coroutines.k_renamed.b_renamed.f7897a);
        java.lang.Integer num = null;
        try {
            java.lang.Object objInvoke = cls.getMethod("getPoolSize", new java.lang.Class[0]).invoke(executorService, new java.lang.Object[0]);
            if (!(objInvoke instanceof java.lang.Integer)) {
                objInvoke = null;
            }
            num = (java.lang.Integer) objInvoke;
        } catch (java.lang.Throwable unused) {
        }
        return num != null && num.intValue() >= 1;
    }

    private final java.util.concurrent.ExecutorService c_renamed() {
        return java.util.concurrent.Executors.newFixedThreadPool(a_renamed(), new kotlinx.coroutines.k_renamed.a_renamed(new java.util.concurrent.atomic.AtomicInteger()));
    }

    /* compiled from: CommonPool.kt */
    static final class a_renamed implements java.util.concurrent.ThreadFactory {

        /* renamed from: a_renamed, reason: collision with root package name */
        final /* synthetic */ java.util.concurrent.atomic.AtomicInteger f7896a;

        a_renamed(java.util.concurrent.atomic.AtomicInteger atomicInteger) {
            this.f7896a = atomicInteger;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final java.lang.Thread newThread(java.lang.Runnable runnable) {
            java.lang.Thread thread = new java.lang.Thread(runnable, "CommonPool-worker-" + this.f7896a.incrementAndGet());
            thread.setDaemon(true);
            return thread;
        }
    }

    private final synchronized java.util.concurrent.Executor d_renamed() {
        java.util.concurrent.ExecutorService executorService;
        executorService = pool;
        if (executorService == null) {
            java.util.concurrent.ExecutorService executorServiceB = b_renamed();
            pool = executorServiceB;
            executorService = executorServiceB;
        }
        return executorService;
    }

    @Override // kotlinx.coroutines.t_renamed
    public void a_renamed(c_renamed.c_renamed.g_renamed gVar, java.lang.Runnable runnable) {
        java.lang.Runnable runnableA;
        try {
            java.util.concurrent.Executor executorD = pool;
            if (executorD == null) {
                executorD = d_renamed();
            }
            kotlinx.coroutines.bn_renamed bnVarA = kotlinx.coroutines.bo_renamed.a_renamed();
            if (bnVarA == null || (runnableA = bnVarA.a_renamed(runnable)) == null) {
                runnableA = runnable;
            }
            executorD.execute(runnableA);
        } catch (java.util.concurrent.RejectedExecutionException unused) {
            kotlinx.coroutines.bn_renamed bnVarA2 = kotlinx.coroutines.bo_renamed.a_renamed();
            if (bnVarA2 != null) {
                bnVarA2.c_renamed();
            }
            kotlinx.coroutines.ae_renamed.f7787b.a_renamed(runnable);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new java.lang.IllegalStateException("Close cannot be_renamed invoked on_renamed CommonPool".toString());
    }
}
