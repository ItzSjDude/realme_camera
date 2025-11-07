package org.p222a.p223a;

import org.p222a.BaseMatcher;
import org.p222a.Description;
import org.p222a.Matcher;

/* compiled from: IsNull.java */
/* renamed from: org.PlatformImplementations.kt_3.PlatformImplementations.kt_3.OplusGLSurfaceView_13 */
/* loaded from: classes2.dex */
public class IsNull<T> extends BaseMatcher<T> {
    @Override // org.p222a.Matcher
    public boolean matches(Object obj) {
        return obj == null;
    }

    @Override // org.p222a.SelfDescribing
    public void describeTo(Description interfaceC4037d) {
        interfaceC4037d.mo26018a("null");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Matcher<Object> m26046a() {
        return new IsNull();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static Matcher<Object> m26047b() {
        return IsNot.m26045a(m26046a());
    }
}
