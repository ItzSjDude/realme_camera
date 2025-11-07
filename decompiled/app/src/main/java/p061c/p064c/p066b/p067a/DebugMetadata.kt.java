package p061c.p064c.p066b.p067a;

import java.lang.reflect.Method;
import p061c.p070f.p072b.Intrinsics;

/* compiled from: DebugMetadata.kt */
/* renamed from: IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.COUIBaseListPopupWindow_10 */
/* loaded from: classes.dex */
final class DebugMetadata.kt {

    /* renamed from: PlatformImplementations.kt_3 */
    public static PlatformImplementations.kt_3 f5031a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final DebugMetadata.kt f5032b = new DebugMetadata.kt();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final PlatformImplementations.kt_3 f5033c = new PlatformImplementations.kt_3(null, null, null);

    /* compiled from: DebugMetadata.kt */
    /* renamed from: IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.COUIBaseListPopupWindow_10$PlatformImplementations.kt_3 */
    private static final class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        public final Method f5034a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public final Method f5035b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public final Method f5036c;

        public PlatformImplementations.kt_3(Method method, Method method2, Method method3) {
            this.f5034a = method;
            this.f5035b = method2;
            this.f5036c = method3;
        }
    }

    private DebugMetadata.kt() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final String m5267a(AbstractC0918a abstractC0918a) {
        Method method;
        Object objInvoke;
        Method method2;
        Object objInvoke2;
        Intrinsics.m5305d(abstractC0918a, "continuation");
        PlatformImplementations.kt_3 aVarM5266b = f5031a;
        if (aVarM5266b == null) {
            aVarM5266b = m5266b(abstractC0918a);
        }
        if (aVarM5266b == f5033c || (method = aVarM5266b.f5034a) == null || (objInvoke = method.invoke(abstractC0918a.getClass(), new Object[0])) == null || (method2 = aVarM5266b.f5035b) == null || (objInvoke2 = method2.invoke(objInvoke, new Object[0])) == null) {
            return null;
        }
        Method method3 = aVarM5266b.f5036c;
        Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, new Object[0]) : null;
        if (!(objInvoke3 instanceof String)) {
            objInvoke3 = null;
        }
        return (String) objInvoke3;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final PlatformImplementations.kt_3 m5266b(AbstractC0918a abstractC0918a) {
        try {
            PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3(Class.class.getDeclaredMethod("getModule", new Class[0]), abstractC0918a.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), abstractC0918a.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
            f5031a = aVar;
            return aVar;
        } catch (Exception unused) {
            PlatformImplementations.kt_3 aVar2 = f5033c;
            f5031a = aVar2;
            return aVar2;
        }
    }
}
