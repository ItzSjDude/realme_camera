package org.p222a.p223a;

import org.p222a.DiagnosingMatcher;
import org.p222a.Description;
import org.p222a.Matcher;
import org.p222a.SelfDescribing;

/* compiled from: AllOf.java */
/* renamed from: org.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class AllOf<T> extends DiagnosingMatcher<T> {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Iterable<Matcher<? super T>> f24778a;

    public AllOf(Iterable<Matcher<? super T>> iterable) {
        this.f24778a = iterable;
    }

    @Override // org.p222a.DiagnosingMatcher
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo26024a(Object obj, Description interfaceC4037d) {
        for (Matcher<? super T> interfaceC4039f : this.f24778a) {
            if (!interfaceC4039f.matches(obj)) {
                interfaceC4037d.mo26020a((SelfDescribing) interfaceC4039f).mo26018a(" ");
                interfaceC4039f.describeMismatch(obj, interfaceC4037d);
                return false;
            }
        }
        return true;
    }

    @Override // org.p222a.SelfDescribing
    public void describeTo(Description interfaceC4037d) {
        interfaceC4037d.mo26019a("(", " and ", ")", this.f24778a);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static <T> Matcher<T> m26023a(Iterable<Matcher<? super T>> iterable) {
        return new AllOf(iterable);
    }
}
