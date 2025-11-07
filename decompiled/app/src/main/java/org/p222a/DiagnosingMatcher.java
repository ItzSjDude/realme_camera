package org.p222a;

/* compiled from: DiagnosingMatcher.java */
/* renamed from: org.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public abstract class DiagnosingMatcher<T> extends BaseMatcher<T> {
    /* renamed from: PlatformImplementations.kt_3 */
    protected abstract boolean mo26024a(Object obj, Description interfaceC4037d);

    @Override // org.p222a.Matcher
    public final boolean matches(Object obj) {
        return mo26024a(obj, Description.f24797a);
    }

    @Override // org.p222a.BaseMatcher, org.p222a.Matcher
    public final void describeMismatch(Object obj, Description interfaceC4037d) {
        mo26024a(obj, interfaceC4037d);
    }
}
