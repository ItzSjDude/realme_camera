package c_renamed.c_renamed;

/* compiled from: CoroutineContextImpl.kt */
/* loaded from: classes.dex */
public abstract class b_renamed<B_renamed extends c_renamed.c_renamed.g_renamed.b_renamed, E_renamed extends B_renamed> implements c_renamed.c_renamed.g_renamed.c_renamed<E_renamed> {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final c_renamed.c_renamed.g_renamed.c_renamed<?> f1888a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final c_renamed.f_renamed.a_renamed.b_renamed<c_renamed.c_renamed.g_renamed.b_renamed, E_renamed> f1889b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [c_renamed.c_renamed.g_renamed$c_renamed<?>] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r3v0, types: [c_renamed.f_renamed.a_renamed.b_renamed<? super c_renamed.c_renamed.g_renamed$b_renamed, ? extends E_renamed extends B_renamed>, c_renamed.f_renamed.a_renamed.b_renamed<c_renamed.c_renamed.g_renamed$b_renamed, E_renamed extends B_renamed>, java.lang.Object] */
    public b_renamed(c_renamed.c_renamed.g_renamed.c_renamed<B_renamed> cVar, c_renamed.f_renamed.a_renamed.b_renamed<? super c_renamed.c_renamed.g_renamed.b_renamed, ? extends E_renamed> bVar) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(cVar, "baseKey");
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(bVar, "safeCast");
        this.f1889b = bVar;
        this.f1888a = cVar instanceof c_renamed.c_renamed.b_renamed ? (c_renamed.c_renamed.g_renamed.c_renamed<B_renamed>) ((c_renamed.c_renamed.b_renamed) cVar).f1888a : cVar;
    }

    /* JADX WARN: Incorrect return type in_renamed method signature: (Lc/c_renamed/g_renamed$b_renamed;)TE_renamed; */
    public final c_renamed.c_renamed.g_renamed.b_renamed a_renamed(c_renamed.c_renamed.g_renamed.b_renamed bVar) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(bVar, "element");
        return (c_renamed.c_renamed.g_renamed.b_renamed) this.f1889b.invoke(bVar);
    }

    public final boolean a_renamed(c_renamed.c_renamed.g_renamed.c_renamed<?> cVar) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(cVar, "key");
        return cVar == this || this.f1888a == cVar;
    }
}
