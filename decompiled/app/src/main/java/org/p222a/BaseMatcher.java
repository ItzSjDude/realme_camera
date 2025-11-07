package org.p222a;

/* compiled from: BaseMatcher.java */
/* renamed from: org.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public abstract class BaseMatcher<T> implements Matcher<T> {
    @Deprecated
    /* renamed from: _dont_implement_Matcher___instead_extend_BaseMatcher_ */
    public final void m26053xa09681ce() {
    }

    @Override // org.p222a.Matcher
    public void describeMismatch(Object obj, Description interfaceC4037d) {
        interfaceC4037d.mo26018a("was ").mo26017a(obj);
    }

    public String toString() {
        return StringDescription.m26072b((SelfDescribing) this);
    }
}
