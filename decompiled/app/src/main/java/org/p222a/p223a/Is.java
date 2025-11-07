package org.p222a.p223a;

import org.p222a.BaseMatcher;
import org.p222a.Description;
import org.p222a.Matcher;
import org.p222a.SelfDescribing;

/* compiled from: Is.java */
/* renamed from: org.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class Is<T> extends BaseMatcher<T> {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Matcher<T> f24783a;

    public Is(Matcher<T> interfaceC4039f) {
        this.f24783a = interfaceC4039f;
    }

    @Override // org.p222a.Matcher
    public boolean matches(Object obj) {
        return this.f24783a.matches(obj);
    }

    @Override // org.p222a.SelfDescribing
    public void describeTo(Description interfaceC4037d) {
        interfaceC4037d.mo26018a("is ").mo26020a((SelfDescribing) this.f24783a);
    }

    @Override // org.p222a.BaseMatcher, org.p222a.Matcher
    public void describeMismatch(Object obj, Description interfaceC4037d) {
        this.f24783a.describeMismatch(obj, interfaceC4037d);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static <T> Matcher<T> m26031a(Matcher<T> interfaceC4039f) {
        return new Is(interfaceC4039f);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static <T> Matcher<T> m26030a(T t) {
        return m26031a(IsEqual.m26037a(t));
    }
}
