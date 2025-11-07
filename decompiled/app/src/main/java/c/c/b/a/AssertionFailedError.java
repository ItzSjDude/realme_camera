package c_renamed.c_renamed.b_renamed.a_renamed;

/* compiled from: ContinuationImpl.kt */
/* loaded from: classes.dex */
public final class b_renamed implements c_renamed.c_renamed.d_renamed<java.lang.Object> {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final c_renamed.c_renamed.b_renamed.a_renamed.b_renamed f1890a = new c_renamed.c_renamed.b_renamed.a_renamed.b_renamed();

    public java.lang.String toString() {
        return "This continuation is_renamed already complete";
    }

    private b_renamed() {
    }

    @Override // c_renamed.c_renamed.d_renamed
    public c_renamed.c_renamed.g_renamed getContext() {
        throw new java.lang.IllegalStateException("This continuation is_renamed already complete".toString());
    }

    @Override // c_renamed.c_renamed.d_renamed
    public void resumeWith(java.lang.Object obj) {
        throw new java.lang.IllegalStateException("This continuation is_renamed already complete".toString());
    }
}
