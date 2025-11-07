package kotlinx.coroutines;

/* compiled from: JobSupport.kt */
/* loaded from: classes2.dex */
public abstract class bb_renamed<J_renamed extends kotlinx.coroutines.ay_renamed> extends kotlinx.coroutines.p_renamed implements kotlinx.coroutines.ak_renamed, kotlinx.coroutines.au_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    public final J_renamed f7835b;

    @Override // kotlinx.coroutines.au_renamed
    public boolean b_renamed() {
        return true;
    }

    @Override // kotlinx.coroutines.au_renamed
    public kotlinx.coroutines.bg_renamed k__renamed() {
        return null;
    }

    public bb_renamed(J_renamed j_renamed) {
        this.f7835b = j_renamed;
    }

    @Override // kotlinx.coroutines.ak_renamed
    public void a_renamed() {
        J_renamed j_renamed = this.f7835b;
        if (j_renamed == null) {
            throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type kotlinx.coroutines.JobSupport");
        }
        ((kotlinx.coroutines.bc_renamed) j_renamed).a_renamed((kotlinx.coroutines.bb_renamed<?>) this);
    }
}
