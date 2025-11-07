package kotlinx.coroutines.internal;

/* compiled from: ThreadContext.kt */
/* loaded from: classes2.dex */
final class y_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.lang.Object[] f7892a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f7893b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final c_renamed.c_renamed.g_renamed f7894c;

    public y_renamed(c_renamed.c_renamed.g_renamed gVar, int i_renamed) {
        this.f7894c = gVar;
        this.f7892a = new java.lang.Object[i_renamed];
    }

    public final c_renamed.c_renamed.g_renamed c_renamed() {
        return this.f7894c;
    }

    public final void a_renamed(java.lang.Object obj) {
        java.lang.Object[] objArr = this.f7892a;
        int i_renamed = this.f7893b;
        this.f7893b = i_renamed + 1;
        objArr[i_renamed] = obj;
    }

    public final java.lang.Object a_renamed() {
        java.lang.Object[] objArr = this.f7892a;
        int i_renamed = this.f7893b;
        this.f7893b = i_renamed + 1;
        return objArr[i_renamed];
    }

    public final void b_renamed() {
        this.f7893b = 0;
    }
}
