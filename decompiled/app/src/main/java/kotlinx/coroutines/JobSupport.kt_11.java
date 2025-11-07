package kotlinx.coroutines;

/* compiled from: JobSupport.kt */
/* loaded from: classes2.dex */
final class al_renamed implements kotlinx.coroutines.au_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final boolean f7796a;

    @Override // kotlinx.coroutines.au_renamed
    public kotlinx.coroutines.bg_renamed k__renamed() {
        return null;
    }

    public al_renamed(boolean z_renamed) {
        this.f7796a = z_renamed;
    }

    @Override // kotlinx.coroutines.au_renamed
    public boolean b_renamed() {
        return this.f7796a;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Empty{");
        sb.append(b_renamed() ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}
