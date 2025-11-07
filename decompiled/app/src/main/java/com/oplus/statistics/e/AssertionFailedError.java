package com.oplus.statistics.e_renamed;

/* compiled from: RequestFireWall.java */
/* loaded from: classes2.dex */
public class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final int f7726a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final long f7727b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final android.util.LruCache<java.lang.String, java.util.Queue<java.lang.Long>> f7728c;

    private b_renamed(com.oplus.statistics.e_renamed.b_renamed.a_renamed aVar) {
        this.f7726a = aVar.f7729a;
        this.f7727b = aVar.f7730b;
        this.f7728c = new android.util.LruCache<>(100);
    }

    public boolean a_renamed(final java.lang.String str) {
        java.util.Queue<java.lang.Long> queueB = b_renamed(str);
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
        queueB.add(java.lang.Long.valueOf(jElapsedRealtime));
        final long jA = a_renamed(queueB, jElapsedRealtime);
        boolean z_renamed = jA <= ((long) this.f7726a);
        if (!z_renamed && jA % 10 == 1) {
            com.oplus.statistics.f_renamed.d_renamed.b_renamed("FireWall", new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.e_renamed.-$$Lambda$b_renamed$mJV6E4up8K7LpAxaQqVSo8EFHmA
                @Override // com.oplus.statistics.f_renamed.e_renamed
                public final java.lang.Object get() {
                    return this.f_renamed$0.a_renamed(str, jA);
                }
            });
        }
        return z_renamed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.String a_renamed(java.lang.String str, long j_renamed) {
        return "Chatty!!! Allow " + this.f7726a + "/" + this.f7727b + "ms, but " + str + " request " + j_renamed + " in_renamed the recent period.";
    }

    private long a_renamed(java.util.Queue<java.lang.Long> queue, long j_renamed) {
        java.lang.Long lPeek = queue.peek();
        while (lPeek != null && lPeek.longValue() < j_renamed - this.f7727b) {
            queue.poll();
            lPeek = queue.peek();
        }
        return queue.size();
    }

    private java.util.Queue<java.lang.Long> b_renamed(java.lang.String str) {
        java.util.Queue<java.lang.Long> queue = this.f7728c.get(str);
        if (queue != null) {
            return queue;
        }
        java.util.LinkedList linkedList = new java.util.LinkedList();
        this.f7728c.put(str, linkedList);
        return linkedList;
    }

    /* compiled from: RequestFireWall.java */
    public static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private final int f7729a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private final long f7730b;

        public a_renamed(int i_renamed, long j_renamed) {
            this.f7729a = java.lang.Math.max(i_renamed, 0);
            this.f7730b = java.lang.Math.max(j_renamed, 0L);
        }

        public com.oplus.statistics.e_renamed.b_renamed a_renamed() {
            return new com.oplus.statistics.e_renamed.b_renamed(this);
        }
    }
}
