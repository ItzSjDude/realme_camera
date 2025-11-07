package kotlinx.coroutines.b_renamed;

/* compiled from: Dispatcher.kt */
/* loaded from: classes2.dex */
public final class c_renamed extends kotlinx.coroutines.b_renamed.d_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    public static final kotlinx.coroutines.b_renamed.c_renamed f7822b;
    private static final kotlinx.coroutines.t_renamed e_renamed;

    @Override // kotlinx.coroutines.b_renamed.d_renamed, kotlinx.coroutines.t_renamed
    public java.lang.String toString() {
        return "Dispatchers.Default";
    }

    static {
        kotlinx.coroutines.b_renamed.c_renamed cVar = new kotlinx.coroutines.b_renamed.c_renamed();
        f7822b = cVar;
        e_renamed = new kotlinx.coroutines.b_renamed.f_renamed(cVar, kotlinx.coroutines.internal.u_renamed.a_renamed("kotlinx.coroutines.io.parallelism", c_renamed.h_renamed.d_renamed.b_renamed(64, kotlinx.coroutines.internal.s_renamed.a_renamed()), 0, 0, 12, (java.lang.Object) null), "Dispatchers.IO", 1);
    }

    private c_renamed() {
        super(0, 0, null, 7, null);
    }

    public final kotlinx.coroutines.t_renamed a_renamed() {
        return e_renamed;
    }

    @Override // kotlinx.coroutines.b_renamed.d_renamed, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new java.lang.UnsupportedOperationException("Dispatchers.Default cannot be_renamed closed");
    }
}
