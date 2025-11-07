package p061c.p068d;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p061c.p070f.p072b.Intrinsics;
import p061c.p073g.Random.kt;
import p061c.p073g.PlatformRandom.kt;

/* compiled from: PlatformImplementations.kt */
/* renamed from: IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_5.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public class PlatformImplementations.kt_2 {

    /* compiled from: PlatformImplementations.kt */
    /* renamed from: IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_5.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    private static final class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        public static final Method f5039a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public static final Method f5040b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public static final PlatformImplementations.kt_3 f5041c = new PlatformImplementations.kt_3();

        /* JADX WARN: Removed duplicated region for block: B:10:0x0042  */
        static {
            /*
                IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_5.PlatformImplementations.kt_3$PlatformImplementations.kt_3 r0 = new IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_5.PlatformImplementations.kt_3$PlatformImplementations.kt_3
                r0.<init>()
                p061c.p068d.PlatformImplementations.kt_2.PlatformImplementations.kt_3.f5041c = r0
                java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
                java.lang.reflect.Method[] r1 = r0.getMethods()
                java.lang.String r2 = "throwableMethods"
                p061c.p070f.p072b.Intrinsics.m5301b(r1, r2)
                int r2 = r1.length
                r3 = 0
                r4 = r3
            L15:
                java.lang.String r5 = "it"
                r6 = 0
                if (r4 >= r2) goto L49
                r7 = r1[r4]
                p061c.p070f.p072b.Intrinsics.m5301b(r7, r5)
                java.lang.String r8 = r7.getName()
                java.lang.String r9 = "addSuppressed"
                boolean r8 = p061c.p070f.p072b.Intrinsics.m5299a(r8, r9)
                if (r8 == 0) goto L42
                java.lang.Class[] r8 = r7.getParameterTypes()
                java.lang.String r9 = "it.parameterTypes"
                p061c.p070f.p072b.Intrinsics.m5301b(r8, r9)
                java.lang.Object r8 = p061c.p062a.C0881b.m5221b(r8)
                java.lang.Class r8 = (java.lang.Class) r8
                boolean r8 = p061c.p070f.p072b.Intrinsics.m5299a(r8, r0)
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
                p061c.p068d.PlatformImplementations.kt_2.PlatformImplementations.kt_3.f5039a = r7
                int r0 = r1.length
            L4d:
                if (r3 >= r0) goto L64
                r2 = r1[r3]
                p061c.p070f.p072b.Intrinsics.m5301b(r2, r5)
                java.lang.String r4 = r2.getName()
                java.lang.String r7 = "getSuppressed"
                boolean r4 = p061c.p070f.p072b.Intrinsics.m5299a(r4, r7)
                if (r4 == 0) goto L61
                goto L65
            L61:
                int r3 = r3 + 1
                goto L4d
            L64:
                r2 = r6
            L65:
                p061c.p068d.PlatformImplementations.kt_2.PlatformImplementations.kt_3.f5040b = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p061c.p068d.PlatformImplementations.kt_2.PlatformImplementations.kt_3.<clinit>():void");
        }

        private PlatformImplementations.kt_3() {
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m5280a(Throwable th, Throwable th2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Intrinsics.m5305d(th, "cause");
        Intrinsics.m5305d(th2, "exception");
        Method method = PlatformImplementations.kt_3.f5039a;
        if (method != null) {
            method.invoke(th, th2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Random.kt m5279a() {
        return new PlatformRandom.kt();
    }
}
