package kotlinx.coroutines;

/* compiled from: Unconfined.kt */
/* loaded from: classes2.dex */
public final class bq_renamed extends kotlinx.coroutines.t_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    public static final kotlinx.coroutines.bq_renamed f7850b = new kotlinx.coroutines.bq_renamed();

    @Override // kotlinx.coroutines.t_renamed
    public boolean a_renamed(c_renamed.c_renamed.g_renamed gVar) {
        return false;
    }

    @Override // kotlinx.coroutines.t_renamed
    public java.lang.String toString() {
        return "Dispatchers.Unconfined";
    }

    private bq_renamed() {
    }

    @Override // kotlinx.coroutines.t_renamed
    public void a_renamed(c_renamed.c_renamed.g_renamed gVar, java.lang.Runnable runnable) {
        kotlinx.coroutines.br_renamed brVar = (kotlinx.coroutines.br_renamed) gVar.get(kotlinx.coroutines.br_renamed.f7851b);
        if (brVar != null) {
            brVar.f7852a = true;
            return;
        }
        throw new java.lang.UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be_renamed used by_renamed the yield function. If you wrap Unconfined dispatcher in_renamed your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
    }
}
