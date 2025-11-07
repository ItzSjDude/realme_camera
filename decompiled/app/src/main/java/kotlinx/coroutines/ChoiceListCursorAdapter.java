package kotlinx.coroutines;

/* compiled from: CoroutineContext.kt */
/* loaded from: classes2.dex */
public final class w_renamed extends c_renamed.c_renamed.a_renamed implements kotlinx.coroutines.bl_renamed<java.lang.String> {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final kotlinx.coroutines.w_renamed.a_renamed f7906a = new kotlinx.coroutines.w_renamed.a_renamed(null);

    /* renamed from: b_renamed, reason: collision with root package name */
    private final long f7907b;

    public boolean equals(java.lang.Object obj) {
        if (this != obj) {
            return (obj instanceof kotlinx.coroutines.w_renamed) && this.f7907b == ((kotlinx.coroutines.w_renamed) obj).f7907b;
        }
        return true;
    }

    public int hashCode() {
        long j_renamed = this.f7907b;
        return (int) (j_renamed ^ (j_renamed >>> 32));
    }

    @Override // c_renamed.c_renamed.a_renamed, c_renamed.c_renamed.g_renamed
    public <R_renamed> R_renamed fold(R_renamed r_renamed, c_renamed.f_renamed.a_renamed.m_renamed<? super R_renamed, ? super c_renamed.c_renamed.g_renamed.b_renamed, ? extends R_renamed> mVar) {
        return (R_renamed) kotlinx.coroutines.bl_renamed.a_renamed.a_renamed(this, r_renamed, mVar);
    }

    @Override // c_renamed.c_renamed.a_renamed, c_renamed.c_renamed.g_renamed.b_renamed, c_renamed.c_renamed.g_renamed
    public <E_renamed extends c_renamed.c_renamed.g_renamed.b_renamed> E_renamed get(c_renamed.c_renamed.g_renamed.c_renamed<E_renamed> cVar) {
        return (E_renamed) kotlinx.coroutines.bl_renamed.a_renamed.a_renamed(this, cVar);
    }

    @Override // c_renamed.c_renamed.a_renamed, c_renamed.c_renamed.g_renamed
    public c_renamed.c_renamed.g_renamed minusKey(c_renamed.c_renamed.g_renamed.c_renamed<?> cVar) {
        return kotlinx.coroutines.bl_renamed.a_renamed.b_renamed(this, cVar);
    }

    @Override // c_renamed.c_renamed.a_renamed, c_renamed.c_renamed.g_renamed
    public c_renamed.c_renamed.g_renamed plus(c_renamed.c_renamed.g_renamed gVar) {
        return kotlinx.coroutines.bl_renamed.a_renamed.a_renamed(this, gVar);
    }

    public final long a_renamed() {
        return this.f7907b;
    }

    /* compiled from: CoroutineContext.kt */
    public static final class a_renamed implements c_renamed.c_renamed.g_renamed.c_renamed<kotlinx.coroutines.w_renamed> {
        private a_renamed() {
        }

        public /* synthetic */ a_renamed(c_renamed.f_renamed.b_renamed.f_renamed fVar) {
            this();
        }
    }

    public w_renamed(long j_renamed) {
        super(f7906a);
        this.f7907b = j_renamed;
    }

    public java.lang.String toString() {
        return "CoroutineId(" + this.f7907b + ')';
    }

    @Override // kotlinx.coroutines.bl_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public java.lang.String b_renamed(c_renamed.c_renamed.g_renamed gVar) {
        java.lang.String strA;
        kotlinx.coroutines.x_renamed xVar = (kotlinx.coroutines.x_renamed) gVar.get(kotlinx.coroutines.x_renamed.f7908a);
        if (xVar == null || (strA = xVar.a_renamed()) == null) {
            strA = "coroutine";
        }
        java.lang.Thread threadCurrentThread = java.lang.Thread.currentThread();
        java.lang.String name = threadCurrentThread.getName();
        int iB = c_renamed.k_renamed.d_renamed.b_renamed((java.lang.CharSequence) name, " @", 0, false, 6, (java.lang.Object) null);
        if (iB < 0) {
            iB = name.length();
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(strA.length() + iB + 10);
        if (name != null) {
            java.lang.String strSubstring = name.substring(0, iB);
            c_renamed.f_renamed.b_renamed.h_renamed.b_renamed(strSubstring, "(this as_renamed java.lang.Strin…ing(startIndex, endIndex)");
            sb.append(strSubstring);
            sb.append(" @");
            sb.append(strA);
            sb.append('#');
            sb.append(this.f7907b);
            c_renamed.s_renamed sVar = c_renamed.s_renamed.f1925a;
            java.lang.String string = sb.toString();
            c_renamed.f_renamed.b_renamed.h_renamed.b_renamed(string, "StringBuilder(capacity).…builderAction).toString()");
            threadCurrentThread.setName(string);
            return name;
        }
        throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type java.lang.String");
    }

    @Override // kotlinx.coroutines.bl_renamed
    public void a_renamed(c_renamed.c_renamed.g_renamed gVar, java.lang.String str) {
        java.lang.Thread.currentThread().setName(str);
    }
}
