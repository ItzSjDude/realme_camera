package androidx.a_renamed.a_renamed.a_renamed;

/* compiled from: DefaultTaskExecutor.java */
/* loaded from: classes.dex */
public class b_renamed extends androidx.a_renamed.a_renamed.a_renamed.c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.Object f159a = new java.lang.Object();

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.util.concurrent.ExecutorService f160b = java.util.concurrent.Executors.newFixedThreadPool(4, new java.util.concurrent.ThreadFactory() { // from class: androidx.a_renamed.a_renamed.a_renamed.b_renamed.1

        /* renamed from: b_renamed, reason: collision with root package name */
        private final java.util.concurrent.atomic.AtomicInteger f163b = new java.util.concurrent.atomic.AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            java.lang.Thread thread = new java.lang.Thread(runnable);
            thread.setName(java.lang.String.format("arch_disk_io_%d_renamed", java.lang.Integer.valueOf(this.f163b.getAndIncrement())));
            return thread;
        }
    });

    /* renamed from: c_renamed, reason: collision with root package name */
    private volatile android.os.Handler f161c;

    @Override // androidx.a_renamed.a_renamed.a_renamed.c_renamed
    public void a_renamed(java.lang.Runnable runnable) {
        this.f160b.execute(runnable);
    }

    @Override // androidx.a_renamed.a_renamed.a_renamed.c_renamed
    public void b_renamed(java.lang.Runnable runnable) {
        if (this.f161c == null) {
            synchronized (this.f159a) {
                if (this.f161c == null) {
                    this.f161c = a_renamed(android.os.Looper.getMainLooper());
                }
            }
        }
        this.f161c.post(runnable);
    }

    @Override // androidx.a_renamed.a_renamed.a_renamed.c_renamed
    public boolean c_renamed() {
        return android.os.Looper.getMainLooper().getThread() == java.lang.Thread.currentThread();
    }

    private static android.os.Handler a_renamed(android.os.Looper looper) {
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            return android.os.Handler.createAsync(looper);
        }
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            try {
                return (android.os.Handler) android.os.Handler.class.getDeclaredConstructor(android.os.Looper.class, android.os.Handler.Callback.class, java.lang.Boolean.TYPE).newInstance(looper, null, true);
            } catch (java.lang.IllegalAccessException | java.lang.InstantiationException | java.lang.NoSuchMethodException unused) {
            } catch (java.lang.reflect.InvocationTargetException unused2) {
                return new android.os.Handler(looper);
            }
        }
        return new android.os.Handler(looper);
    }
}
