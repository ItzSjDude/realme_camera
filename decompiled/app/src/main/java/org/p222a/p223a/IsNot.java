package org.p222a.p223a;

import org.p222a.BaseMatcher;
import org.p222a.Description;
import org.p222a.Matcher;
import org.p222a.SelfDescribing;

/* compiled from: IsNot.java */
/* renamed from: org.PlatformImplementations.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_10 */
/* loaded from: classes2.dex */
public class IsNot<T> extends BaseMatcher<T> {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Matcher<T> f24788a;

    public IsNot(Matcher<T> interfaceC4039f) {
        this.f24788a = interfaceC4039f;
    }

    @Override // org.p222a.Matcher
    public boolean matches(Object obj) {
        return !this.f24788a.matches(obj);
    }

    @Override // org.p222a.SelfDescribing
    public void describeTo(Description interfaceC4037d) {
        interfaceC4037d.mo26018a("not ").mo26020a((SelfDescribing) this.f24788a);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static <T> Matcher<T> m26045a(Matcher<T> interfaceC4039f) {
        return new IsNot(interfaceC4039f);
    }
}
