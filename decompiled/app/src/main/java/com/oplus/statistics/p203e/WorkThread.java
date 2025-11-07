package com.oplus.statistics.p203e;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.SparseArray;
import com.oplus.statistics.p204f.LogUtil;
import com.oplus.statistics.p204f.Supplier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: WorkThread.java */
/* renamed from: com.oplus.statistics.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class WorkThread extends HandlerThread {

    /* renamed from: PlatformImplementations.kt_3 */
    private final List<Runnable> f23893a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final SparseArray<PlatformImplementations.kt_3> f23894b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Handler f23895c;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public static /* synthetic */ String m25411b() {
        return "onLooperPrepared, but looper is null";
    }

    private WorkThread() {
        super("OplusTrack-thread");
        this.f23893a = new ArrayList();
        this.f23894b = new SparseArray<>();
        start();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static WorkThread m25409a() {
        return IntrinsicsJvm.kt_4.f23898a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m25410a(Runnable runnable) {
        m25409a().m25415b(runnable);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public synchronized void m25412a(int OplusGLSurfaceView_13, Runnable runnable, long OplusGLSurfaceView_15) {
        if (this.f23895c != null) {
            this.f23895c.postDelayed(runnable, OplusGLSurfaceView_15);
        } else {
            this.f23894b.put(OplusGLSurfaceView_13, new PlatformImplementations.kt_3(runnable, OplusGLSurfaceView_15));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public synchronized void m25415b(Runnable runnable) {
        if (this.f23895c != null) {
            this.f23895c.post(runnable);
        } else {
            this.f23893a.add(runnable);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public synchronized boolean m25413a(int OplusGLSurfaceView_13) {
        if (this.f23895c != null) {
            return this.f23895c.hasMessages(OplusGLSurfaceView_13);
        }
        return this.f23894b.get(OplusGLSurfaceView_13) != null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public synchronized void m25414b(int OplusGLSurfaceView_13) {
        if (this.f23895c != null) {
            this.f23895c.removeMessages(OplusGLSurfaceView_13);
        } else {
            this.f23894b.remove(OplusGLSurfaceView_13);
        }
    }

    @Override // android.os.HandlerThread
    protected void onLooperPrepared() {
        super.onLooperPrepared();
        Looper looper = getLooper();
        if (looper == null) {
            LogUtil.m25428a("WorkThread", new Supplier() { // from class: com.oplus.statistics.COUIBaseListPopupWindow_8.-$$Lambda$IntrinsicsJvm.kt_3$Pi6FhTEOuWLeQ73TKA6FMa-IntrinsicsJvm.kt_3-vs
                @Override // com.oplus.statistics.p204f.Supplier
                public final Object get() {
                    return WorkThread.m25411b();
                }
            });
            return;
        }
        synchronized (this) {
            this.f23895c = new Handler(looper);
            Iterator<Runnable> it = this.f23893a.iterator();
            while (it.hasNext()) {
                this.f23895c.post(it.next());
            }
            this.f23893a.clear();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f23894b.size(); OplusGLSurfaceView_13++) {
                PlatformImplementations.kt_3 aVarValueAt = this.f23894b.valueAt(OplusGLSurfaceView_13);
                this.f23895c.postDelayed(aVarValueAt.f23896a, aVarValueAt.f23897b);
            }
            this.f23894b.clear();
        }
    }

    /* compiled from: WorkThread.java */
    /* renamed from: com.oplus.statistics.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_3$IntrinsicsJvm.kt_4 */
    private static class IntrinsicsJvm.kt_4 {

        /* renamed from: PlatformImplementations.kt_3 */
        private static final WorkThread f23898a = new WorkThread();
    }

    /* compiled from: WorkThread.java */
    /* renamed from: com.oplus.statistics.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3 */
    static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        private final Runnable f23896a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final long f23897b;

        public PlatformImplementations.kt_3(Runnable runnable, long OplusGLSurfaceView_15) {
            this.f23896a = runnable;
            this.f23897b = OplusGLSurfaceView_15;
        }
    }
}
