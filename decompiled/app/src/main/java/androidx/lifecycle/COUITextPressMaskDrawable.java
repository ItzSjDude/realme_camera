package androidx.lifecycle;

/* compiled from: ViewModel.java */
/* loaded from: classes.dex */
public abstract class q_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.util.Map<java.lang.String, java.lang.Object> f1248a = new java.util.HashMap();

    /* renamed from: b_renamed, reason: collision with root package name */
    private volatile boolean f1249b = false;

    protected void a_renamed() {
    }

    final void d_renamed() {
        this.f1249b = true;
        java.util.Map<java.lang.String, java.lang.Object> map = this.f1248a;
        if (map != null) {
            synchronized (map) {
                java.util.Iterator<java.lang.Object> it = this.f1248a.values().iterator();
                while (it.hasNext()) {
                    a_renamed(it.next());
                }
            }
        }
        a_renamed();
    }

    private static void a_renamed(java.lang.Object obj) throws java.io.IOException {
        if (obj instanceof java.io.Closeable) {
            try {
                ((java.io.Closeable) obj).close();
            } catch (java.io.IOException e_renamed) {
                throw new java.lang.RuntimeException(e_renamed);
            }
        }
    }
}
