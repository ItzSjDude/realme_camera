package kotlinx.coroutines.internal;

/* compiled from: MainDispatchers.kt */
/* loaded from: classes2.dex */
public final class l_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final kotlinx.coroutines.bf_renamed f7878a;

    /* renamed from: b_renamed, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.l_renamed f7879b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final boolean f7880c;

    static {
        kotlinx.coroutines.internal.l_renamed lVar = new kotlinx.coroutines.internal.l_renamed();
        f7879b = lVar;
        f7880c = kotlinx.coroutines.internal.s_renamed.a_renamed("kotlinx.coroutines.fast.service.loader", true);
        f7878a = lVar.a_renamed();
    }

    private l_renamed() {
    }

    private final kotlinx.coroutines.bf_renamed a_renamed() {
        java.lang.Object next;
        kotlinx.coroutines.bf_renamed bfVarA;
        try {
            java.util.List<kotlinx.coroutines.internal.MainDispatcherFactory.kt> listA = f7880c ? kotlinx.coroutines.internal.e_renamed.f7867a.a_renamed() : c_renamed.j_renamed.c_renamed.b_renamed(c_renamed.j_renamed.c_renamed.a_renamed(java.util.ServiceLoader.load(kotlinx.coroutines.internal.MainDispatcherFactory.kt.class, kotlinx.coroutines.internal.MainDispatcherFactory.kt.class.getClassLoader()).iterator()));
            java.util.Iterator<T_renamed> it = listA.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int loadPriority = ((kotlinx.coroutines.internal.MainDispatcherFactory.kt) next).getLoadPriority();
                    do {
                        java.lang.Object next2 = it.next();
                        int loadPriority2 = ((kotlinx.coroutines.internal.MainDispatcherFactory.kt) next2).getLoadPriority();
                        if (loadPriority < loadPriority2) {
                            next = next2;
                            loadPriority = loadPriority2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            kotlinx.coroutines.internal.MainDispatcherFactory.kt mainDispatcherFactory = (kotlinx.coroutines.internal.MainDispatcherFactory.kt) next;
            return (mainDispatcherFactory == null || (bfVarA = kotlinx.coroutines.internal.m_renamed.a_renamed(mainDispatcherFactory, listA)) == null) ? kotlinx.coroutines.internal.m_renamed.a_renamed(null, null, 3, null) : bfVarA;
        } catch (java.lang.Throwable th) {
            return kotlinx.coroutines.internal.m_renamed.a_renamed(th, null, 2, null);
        }
    }
}
