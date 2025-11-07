package com.oplus.statistics.p203e;

import android.os.SystemClock;
import android.util.LruCache;
import com.oplus.statistics.p204f.LogUtil;
import com.oplus.statistics.p204f.Supplier;
import java.util.LinkedList;
import java.util.Queue;

/* compiled from: RequestFireWall.java */
/* renamed from: com.oplus.statistics.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class RequestFireWall {

    /* renamed from: PlatformImplementations.kt_3 */
    private final int f23888a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final long f23889b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final LruCache<String, Queue<Long>> f23890c;

    private RequestFireWall(PlatformImplementations.kt_3 aVar) {
        this.f23888a = aVar.f23891a;
        this.f23889b = aVar.f23892b;
        this.f23890c = new LruCache<>(100);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m25405a(final String str) {
        Queue<Long> queueM25404b = m25404b(str);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        queueM25404b.add(Long.valueOf(jElapsedRealtime));
        final long jM25402a = m25402a(queueM25404b, jElapsedRealtime);
        boolean z = jM25402a <= ((long) this.f23888a);
        if (!z && jM25402a % 10 == 1) {
            LogUtil.m25431b("FireWall", new Supplier() { // from class: com.oplus.statistics.COUIBaseListPopupWindow_8.-$$Lambda$IntrinsicsJvm.kt_4$mJV6E4up8K7LpAxaQqVSo8EFHmA
                @Override // com.oplus.statistics.p204f.Supplier
                public final Object get() {
                    return this.COUIBaseListPopupWindow_12$0.m25403a(str, jM25402a);
                }
            });
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ String m25403a(String str, long OplusGLSurfaceView_15) {
        return "Chatty!!! Allow " + this.f23888a + "/" + this.f23889b + "ms, but " + str + " request " + OplusGLSurfaceView_15 + " in the recent period.";
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private long m25402a(Queue<Long> queue, long OplusGLSurfaceView_15) {
        Long lPeek = queue.peek();
        while (lPeek != null && lPeek.longValue() < OplusGLSurfaceView_15 - this.f23889b) {
            queue.poll();
            lPeek = queue.peek();
        }
        return queue.size();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Queue<Long> m25404b(String str) {
        Queue<Long> queue = this.f23890c.get(str);
        if (queue != null) {
            return queue;
        }
        LinkedList linkedList = new LinkedList();
        this.f23890c.put(str, linkedList);
        return linkedList;
    }

    /* compiled from: RequestFireWall.java */
    /* renamed from: com.oplus.statistics.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
    public static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        private final int f23891a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final long f23892b;

        public PlatformImplementations.kt_3(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
            this.f23891a = Math.max(OplusGLSurfaceView_13, 0);
            this.f23892b = Math.max(OplusGLSurfaceView_15, 0L);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public RequestFireWall m25408a() {
            return new RequestFireWall(this);
        }
    }
}
