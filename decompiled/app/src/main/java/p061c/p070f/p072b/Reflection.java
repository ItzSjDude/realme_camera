package p061c.p070f.p072b;

import p061c.p075i.KClass.kt;

/* compiled from: Reflection.java */
/* renamed from: IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_12.IntrinsicsJvm.kt_4.OplusGLSurfaceView_5 */
/* loaded from: classes.dex */
public class Reflection {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final ReflectionFactory f5053a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final KClass.kt[] f5054b;

    static {
        ReflectionFactory c0976l = null;
        try {
            c0976l = (ReflectionFactory) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (c0976l == null) {
            c0976l = new ReflectionFactory();
        }
        f5053a = c0976l;
        f5054b = new KClass.kt[0];
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static KClass.kt m5308a(Class cls) {
        return f5053a.m5311a(cls);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m5310a(Lambda.kt abstractC0973i) {
        return f5053a.m5313a(abstractC0973i);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m5309a(FunctionBase.kt interfaceC0971g) {
        return f5053a.m5312a(interfaceC0971g);
    }
}
