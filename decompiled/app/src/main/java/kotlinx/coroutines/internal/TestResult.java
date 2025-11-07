package kotlinx.coroutines.internal;

/* compiled from: LockFreeLinkedList.kt */
/* loaded from: classes2.dex */
public final class h_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.Object f7869a = new kotlinx.coroutines.internal.r_renamed("CONDITION_FALSE");

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final java.lang.Object f7870b = new kotlinx.coroutines.internal.r_renamed("LIST_EMPTY");

    public static final java.lang.Object a_renamed() {
        return f7869a;
    }

    public static final kotlinx.coroutines.internal.i_renamed a_renamed(java.lang.Object obj) {
        kotlinx.coroutines.internal.i_renamed iVar;
        kotlinx.coroutines.internal.p_renamed pVar = (kotlinx.coroutines.internal.p_renamed) (!(obj instanceof kotlinx.coroutines.internal.p_renamed) ? null : obj);
        if (pVar != null && (iVar = pVar.f7883a) != null) {
            return iVar;
        }
        if (obj != null) {
            return (kotlinx.coroutines.internal.i_renamed) obj;
        }
        throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }
}
