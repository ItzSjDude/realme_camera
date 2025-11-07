package androidx.room;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* compiled from: TransactionExecutor.java */
/* renamed from: androidx.room.OplusGLSurfaceView_11 */
/* loaded from: classes.dex */
class TransactionExecutor implements Executor {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Executor f4478a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final ArrayDeque<Runnable> f4479b = new ArrayDeque<>();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Runnable f4480c;

    TransactionExecutor(Executor executor) {
        this.f4478a = executor;
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(final Runnable runnable) {
        this.f4479b.offer(new Runnable() { // from class: androidx.room.OplusGLSurfaceView_11.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    runnable.run();
                } finally {
                    TransactionExecutor.this.m4684a();
                }
            }
        });
        if (this.f4480c == null) {
            m4684a();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    synchronized void m4684a() {
        Runnable runnablePoll = this.f4479b.poll();
        this.f4480c = runnablePoll;
        if (runnablePoll != null) {
            this.f4478a.execute(this.f4480c);
        }
    }
}
