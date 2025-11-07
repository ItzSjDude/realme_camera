package c_renamed.c_renamed.b_renamed.a_renamed;

/* compiled from: DebugMetadata.kt */
/* loaded from: classes.dex */
final class h_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static c_renamed.c_renamed.b_renamed.a_renamed.h_renamed.a_renamed f1891a;

    /* renamed from: b_renamed, reason: collision with root package name */
    public static final c_renamed.c_renamed.b_renamed.a_renamed.h_renamed f1892b = new c_renamed.c_renamed.b_renamed.a_renamed.h_renamed();

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final c_renamed.c_renamed.b_renamed.a_renamed.h_renamed.a_renamed f1893c = new c_renamed.c_renamed.b_renamed.a_renamed.h_renamed.a_renamed(null, null, null);

    /* compiled from: DebugMetadata.kt */
    private static final class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public final java.lang.reflect.Method f1894a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public final java.lang.reflect.Method f1895b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public final java.lang.reflect.Method f1896c;

        public a_renamed(java.lang.reflect.Method method, java.lang.reflect.Method method2, java.lang.reflect.Method method3) {
            this.f1894a = method;
            this.f1895b = method2;
            this.f1896c = method3;
        }
    }

    private h_renamed() {
    }

    public final java.lang.String a_renamed(c_renamed.c_renamed.b_renamed.a_renamed.a_renamed aVar) {
        java.lang.reflect.Method method;
        java.lang.Object objInvoke;
        java.lang.reflect.Method method2;
        java.lang.Object objInvoke2;
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(aVar, "continuation");
        c_renamed.c_renamed.b_renamed.a_renamed.h_renamed.a_renamed aVarB = f1891a;
        if (aVarB == null) {
            aVarB = b_renamed(aVar);
        }
        if (aVarB == f1893c || (method = aVarB.f1894a) == null || (objInvoke = method.invoke(aVar.getClass(), new java.lang.Object[0])) == null || (method2 = aVarB.f1895b) == null || (objInvoke2 = method2.invoke(objInvoke, new java.lang.Object[0])) == null) {
            return null;
        }
        java.lang.reflect.Method method3 = aVarB.f1896c;
        java.lang.Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, new java.lang.Object[0]) : null;
        if (!(objInvoke3 instanceof java.lang.String)) {
            objInvoke3 = null;
        }
        return (java.lang.String) objInvoke3;
    }

    private final c_renamed.c_renamed.b_renamed.a_renamed.h_renamed.a_renamed b_renamed(c_renamed.c_renamed.b_renamed.a_renamed.a_renamed aVar) {
        try {
            c_renamed.c_renamed.b_renamed.a_renamed.h_renamed.a_renamed aVar2 = new c_renamed.c_renamed.b_renamed.a_renamed.h_renamed.a_renamed(java.lang.Class.class.getDeclaredMethod("getModule", new java.lang.Class[0]), aVar.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new java.lang.Class[0]), aVar.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new java.lang.Class[0]));
            f1891a = aVar2;
            return aVar2;
        } catch (java.lang.Exception unused) {
            c_renamed.c_renamed.b_renamed.a_renamed.h_renamed.a_renamed aVar3 = f1893c;
            f1891a = aVar3;
            return aVar3;
        }
    }
}
