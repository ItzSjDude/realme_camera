package kotlinx.coroutines.internal;

/* compiled from: MainDispatchers.kt */
/* loaded from: classes2.dex */
final class n_renamed extends kotlinx.coroutines.bf_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.lang.Throwable f7882b;
    private final java.lang.String d_renamed;

    public n_renamed(java.lang.Throwable th, java.lang.String str) {
        this.f7882b = th;
        this.d_renamed = str;
    }

    @Override // kotlinx.coroutines.bf_renamed
    public kotlinx.coroutines.bf_renamed a_renamed() {
        return this;
    }

    @Override // kotlinx.coroutines.t_renamed
    public boolean a_renamed(c_renamed.c_renamed.g_renamed gVar) {
        c_renamed();
        throw new c_renamed.e_renamed();
    }

    @Override // kotlinx.coroutines.t_renamed
    /* renamed from: b_renamed, reason: merged with bridge method [inline-methods] */
    public java.lang.Void a_renamed(c_renamed.c_renamed.g_renamed gVar, java.lang.Runnable runnable) {
        c_renamed();
        throw new c_renamed.e_renamed();
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:9:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Void c_renamed() {
        /*
            r4 = this;
            java.lang.Throwable r0 = r4.f7882b
            if (r0 == 0) goto L39
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Module with the Main dispatcher had failed to initialize"
            r0.append(r1)
            java.lang.String r1 = r4.d_renamed
            if (r1 == 0) goto L26
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = ". "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            if (r1 == 0) goto L26
            goto L28
        L26:
            java.lang.String r1 = ""
        L28:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.Throwable r4 = r4.f7882b
            r1.<init>(r0, r4)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L39:
            kotlinx.coroutines.internal.m_renamed.a_renamed()
            c_renamed.e_renamed r4 = new c_renamed.e_renamed
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.n_renamed.c_renamed():java.lang.Void");
    }

    @Override // kotlinx.coroutines.bf_renamed, kotlinx.coroutines.t_renamed
    public java.lang.String toString() {
        java.lang.String str;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Dispatchers.Main[missing");
        if (this.f7882b != null) {
            str = ", cause=" + this.f7882b;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(']');
        return sb.toString();
    }
}
