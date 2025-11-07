package kotlinx.coroutines;

/* compiled from: AbstractCoroutine.kt */
/* loaded from: classes2.dex */
public abstract class a_renamed<T_renamed> extends kotlinx.coroutines.bc_renamed implements c_renamed.c_renamed.d_renamed<T_renamed>, kotlinx.coroutines.ay_renamed, kotlinx.coroutines.y_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    protected final c_renamed.c_renamed.g_renamed f7780a;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final c_renamed.c_renamed.g_renamed f7781c;

    protected void a_renamed(T_renamed t_renamed) {
    }

    protected void a_renamed(java.lang.Throwable th, boolean z_renamed) {
    }

    protected void d_renamed() {
    }

    public a_renamed(c_renamed.c_renamed.g_renamed gVar, boolean z_renamed) {
        super(z_renamed);
        this.f7780a = gVar;
        this.f7781c = this.f7780a.plus(this);
    }

    @Override // c_renamed.c_renamed.d_renamed
    public final c_renamed.c_renamed.g_renamed getContext() {
        return this.f7781c;
    }

    @Override // kotlinx.coroutines.y_renamed
    public c_renamed.c_renamed.g_renamed a_renamed() {
        return this.f7781c;
    }

    @Override // kotlinx.coroutines.bc_renamed, kotlinx.coroutines.ay_renamed
    public boolean b_renamed() {
        return super.b_renamed();
    }

    public final void c_renamed() {
        a_renamed((kotlinx.coroutines.ay_renamed) this.f7780a.get(kotlinx.coroutines.ay_renamed.f7812b));
    }

    @Override // kotlinx.coroutines.bc_renamed
    public final void e_renamed() {
        d_renamed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.bc_renamed
    public java.lang.String f_renamed() {
        return kotlinx.coroutines.ad_renamed.b_renamed(this) + " was cancelled";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.bc_renamed
    protected final void b_renamed(java.lang.Object obj) {
        if (obj instanceof kotlinx.coroutines.l_renamed) {
            kotlinx.coroutines.l_renamed lVar = (kotlinx.coroutines.l_renamed) obj;
            a_renamed(lVar.f7899a, lVar.b_renamed());
        } else {
            a_renamed((kotlinx.coroutines.a_renamed<T_renamed>) obj);
        }
    }

    @Override // c_renamed.c_renamed.d_renamed
    public final void resumeWith(java.lang.Object obj) {
        java.lang.Object objE = e_renamed(kotlinx.coroutines.m_renamed.a_renamed(obj));
        if (objE == kotlinx.coroutines.bd_renamed.f7842a) {
            return;
        }
        c_renamed(objE);
    }

    protected void c_renamed(java.lang.Object obj) {
        f_renamed(obj);
    }

    @Override // kotlinx.coroutines.bc_renamed
    public final void a_renamed(java.lang.Throwable th) {
        kotlinx.coroutines.v_renamed.a_renamed(this.f7781c, th);
    }

    @Override // kotlinx.coroutines.bc_renamed
    public java.lang.String g_renamed() {
        java.lang.String strA = kotlinx.coroutines.s_renamed.a_renamed(this.f7781c);
        if (strA == null) {
            return super.g_renamed();
        }
        return '\"' + strA + "\":" + super.g_renamed();
    }

    public final <R_renamed> void a_renamed(kotlinx.coroutines.z_renamed zVar, R_renamed r_renamed, c_renamed.f_renamed.a_renamed.m_renamed<? super R_renamed, ? super c_renamed.c_renamed.d_renamed<? super T_renamed>, ? extends java.lang.Object> mVar) {
        c_renamed();
        zVar.invoke(mVar, r_renamed, this);
    }
}
