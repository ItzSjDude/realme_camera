package c_renamed.j_renamed;

/* compiled from: SequencesJVM.kt */
/* loaded from: classes.dex */
public final class a_renamed<T_renamed> implements c_renamed.j_renamed.b_renamed<T_renamed> {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.util.concurrent.atomic.AtomicReference<c_renamed.j_renamed.b_renamed<T_renamed>> f1922a;

    public a_renamed(c_renamed.j_renamed.b_renamed<? extends T_renamed> bVar) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(bVar, "sequence");
        this.f1922a = new java.util.concurrent.atomic.AtomicReference<>(bVar);
    }

    @Override // c_renamed.j_renamed.b_renamed
    public java.util.Iterator<T_renamed> a_renamed() {
        c_renamed.j_renamed.b_renamed<T_renamed> andSet = this.f1922a.getAndSet(null);
        if (andSet == null) {
            throw new java.lang.IllegalStateException("This sequence can be_renamed consumed only once.");
        }
        return andSet.a_renamed();
    }
}
