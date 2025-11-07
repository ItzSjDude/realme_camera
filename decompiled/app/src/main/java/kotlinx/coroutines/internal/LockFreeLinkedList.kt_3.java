package kotlinx.coroutines.internal;

/* compiled from: LockFreeLinkedList.kt */
/* renamed from: kotlinx.coroutines.internal.COUIBaseListPopupWindow_10 */
/* loaded from: classes2.dex */
public final class LockFreeLinkedList.kt_3 {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final Object f24691a = new Symbol.kt("CONDITION_FALSE");

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final Object f24692b = new Symbol.kt("LIST_EMPTY");

    /* renamed from: PlatformImplementations.kt_3 */
    public static final Object m25847a() {
        return f24691a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final LockFreeLinkedList.kt m25848a(Object obj) {
        LockFreeLinkedList.kt c3931i;
        LockFreeLinkedList.kt_4 c3938p = (LockFreeLinkedList.kt_4) (!(obj instanceof LockFreeLinkedList.kt_4) ? null : obj);
        if (c3938p != null && (c3931i = c3938p.f24714a) != null) {
            return c3931i;
        }
        if (obj != null) {
            return (LockFreeLinkedList.kt) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }
}
