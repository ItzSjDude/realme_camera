package org.p222a.p223a;

import org.p222a.DiagnosingMatcher;
import org.p222a.Description;
import org.p222a.Matcher;

/* compiled from: IsInstanceOf.java */
/* renamed from: org.PlatformImplementations.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_11 */
/* loaded from: classes2.dex */
public class IsInstanceOf extends DiagnosingMatcher<Object> {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Class<?> f24786a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Class<?> f24787b;

    public IsInstanceOf(Class<?> cls) {
        this.f24786a = cls;
        this.f24787b = m26044b(cls);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static Class<?> m26044b(Class<?> cls) {
        return Boolean.TYPE.equals(cls) ? Boolean.class : Byte.TYPE.equals(cls) ? Byte.class : Character.TYPE.equals(cls) ? Character.class : Double.TYPE.equals(cls) ? Double.class : Float.TYPE.equals(cls) ? Float.class : Integer.TYPE.equals(cls) ? Integer.class : Long.TYPE.equals(cls) ? Long.class : Short.TYPE.equals(cls) ? Short.class : cls;
    }

    @Override // org.p222a.DiagnosingMatcher
    /* renamed from: PlatformImplementations.kt_3 */
    protected boolean mo26024a(Object obj, Description interfaceC4037d) {
        if (obj == null) {
            interfaceC4037d.mo26018a("null");
            return false;
        }
        if (this.f24787b.isInstance(obj)) {
            return true;
        }
        interfaceC4037d.mo26017a(obj).mo26018a(" is PlatformImplementations.kt_3 " + obj.getClass().getName());
        return false;
    }

    @Override // org.p222a.SelfDescribing
    public void describeTo(Description interfaceC4037d) {
        interfaceC4037d.mo26018a("an instance of ").mo26018a(this.f24786a.getName());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static <T> Matcher<T> m26043a(Class<?> cls) {
        return new IsInstanceOf(cls);
    }
}
