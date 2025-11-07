package c_renamed.d_renamed;

/* compiled from: PlatformImplementations.kt */
/* loaded from: classes.dex */
public class a_renamed {

    /* compiled from: PlatformImplementations.kt */
    /* renamed from: c_renamed.d_renamed.a_renamed$a_renamed, reason: collision with other inner class name */
    private static final class PlatformImplementations.kt_2 {

        /* renamed from: a_renamed, reason: collision with root package name */
        public static final java.lang.reflect.Method f1899a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public static final java.lang.reflect.Method f1900b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public static final c_renamed.d_renamed.a_renamed.PlatformImplementations.kt_2 f1901c = new c_renamed.d_renamed.a_renamed.PlatformImplementations.kt_2();

        /* JADX WARN: Removed duplicated region for block: B_renamed:10:0x0042  */
        static {
            /*
                c_renamed.d_renamed.a_renamed$a_renamed r0 = new c_renamed.d_renamed.a_renamed$a_renamed
                r0.<init>()
                c_renamed.d_renamed.a_renamed.PlatformImplementations.kt_2.f1901c = r0
                java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
                java.lang.reflect.Method[] r1 = r0.getMethods()
                java.lang.String r2 = "throwableMethods"
                c_renamed.f_renamed.b_renamed.h_renamed.b_renamed(r1, r2)
                int r2 = r1.length
                r3 = 0
                r4 = r3
            L15:
                java.lang.String r5 = "it"
                r6 = 0
                if (r4 >= r2) goto L49
                r7 = r1[r4]
                c_renamed.f_renamed.b_renamed.h_renamed.b_renamed(r7, r5)
                java.lang.String r8 = r7.getName()
                java.lang.String r9 = "addSuppressed"
                boolean r8 = c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(r8, r9)
                if (r8 == 0) goto L42
                java.lang.Class[] r8 = r7.getParameterTypes()
                java.lang.String r9 = "it.parameterTypes"
                c_renamed.f_renamed.b_renamed.h_renamed.b_renamed(r8, r9)
                java.lang.Object r8 = c_renamed.a_renamed.b_renamed.b_renamed(r8)
                java.lang.Class r8 = (java.lang.Class) r8
                boolean r8 = c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(r8, r0)
                if (r8 == 0) goto L42
                r8 = 1
                goto L43
            L42:
                r8 = r3
            L43:
                if (r8 == 0) goto L46
                goto L4a
            L46:
                int r4 = r4 + 1
                goto L15
            L49:
                r7 = r6
            L4a:
                c_renamed.d_renamed.a_renamed.PlatformImplementations.kt_2.f1899a = r7
                int r0 = r1.length
            L4d:
                if (r3 >= r0) goto L64
                r2 = r1[r3]
                c_renamed.f_renamed.b_renamed.h_renamed.b_renamed(r2, r5)
                java.lang.String r4 = r2.getName()
                java.lang.String r7 = "getSuppressed"
                boolean r4 = c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(r4, r7)
                if (r4 == 0) goto L61
                goto L65
            L61:
                int r3 = r3 + 1
                goto L4d
            L64:
                r2 = r6
            L65:
                c_renamed.d_renamed.a_renamed.PlatformImplementations.kt_2.f1900b = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: c_renamed.d_renamed.a_renamed.PlatformImplementations.kt_2.<clinit>():void");
        }

        private PlatformImplementations.kt_2() {
        }
    }

    public void a_renamed(java.lang.Throwable th, java.lang.Throwable th2) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(th, "cause");
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(th2, "exception");
        java.lang.reflect.Method method = c_renamed.d_renamed.a_renamed.PlatformImplementations.kt_2.f1899a;
        if (method != null) {
            method.invoke(th, th2);
        }
    }

    public c_renamed.g_renamed.c_renamed a_renamed() {
        return new c_renamed.g_renamed.b_renamed();
    }
}
