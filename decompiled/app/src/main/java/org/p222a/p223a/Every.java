package org.p222a.p223a;

import org.p222a.TypeSafeDiagnosingMatcher;
import org.p222a.Description;
import org.p222a.Matcher;
import org.p222a.SelfDescribing;

/* compiled from: Every.java */
/* renamed from: org.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class Every<T> extends TypeSafeDiagnosingMatcher<Iterable<T>> {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Matcher<? super T> f24782a;

    public Every(Matcher<? super T> interfaceC4039f) {
        this.f24782a = interfaceC4039f;
    }

    @Override // org.p222a.TypeSafeDiagnosingMatcher
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public boolean mo26027a(Iterable<T> iterable, Description interfaceC4037d) {
        for (T t : iterable) {
            if (!this.f24782a.matches(t)) {
                interfaceC4037d.mo26018a("an item ");
                this.f24782a.describeMismatch(t, interfaceC4037d);
                return false;
            }
        }
        return true;
    }

    @Override // org.p222a.SelfDescribing
    public void describeTo(Description interfaceC4037d) {
        interfaceC4037d.mo26018a("every item is ").mo26020a((SelfDescribing) this.f24782a);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static <U> Matcher<Iterable<U>> m26028a(Matcher<U> interfaceC4039f) {
        return new Every(interfaceC4039f);
    }
}
