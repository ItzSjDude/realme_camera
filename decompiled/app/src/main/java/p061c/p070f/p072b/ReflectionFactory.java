package p061c.p070f.p072b;

import p061c.p075i.KClass.kt;

/* compiled from: ReflectionFactory.java */
/* renamed from: IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_12.IntrinsicsJvm.kt_4.OplusGLSurfaceView_14 */
/* loaded from: classes.dex */
public class ReflectionFactory {
    /* renamed from: PlatformImplementations.kt_3 */
    public KClass.kt m5311a(Class cls) {
        return new ClassReference.kt(cls);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m5313a(Lambda.kt abstractC0973i) {
        return m5312a((FunctionBase.kt) abstractC0973i);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m5312a(FunctionBase.kt interfaceC0971g) {
        String string = interfaceC0971g.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith("kotlin.jvm.functions.") ? string.substring(21) : string;
    }
}
