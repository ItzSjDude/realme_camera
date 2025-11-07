package kotlinx.coroutines;

/* compiled from: EventLoop.common.kt */
/* loaded from: classes2.dex */
public final class bm_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final kotlinx.coroutines.bm_renamed f7847a = new kotlinx.coroutines.bm_renamed();

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final java.lang.ThreadLocal<kotlinx.coroutines.am_renamed> f7848b = new java.lang.ThreadLocal<>();

    private bm_renamed() {
    }

    public final kotlinx.coroutines.am_renamed a_renamed() {
        kotlinx.coroutines.am_renamed amVar = f7848b.get();
        if (amVar != null) {
            return amVar;
        }
        kotlinx.coroutines.am_renamed amVarA = kotlinx.coroutines.ap_renamed.a_renamed();
        f7848b.set(amVarA);
        return amVarA;
    }

    public final void b_renamed() {
        f7848b.set(null);
    }

    public final void a_renamed(kotlinx.coroutines.am_renamed amVar) {
        f7848b.set(amVar);
    }
}
