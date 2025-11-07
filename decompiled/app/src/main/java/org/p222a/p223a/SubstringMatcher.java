package org.p222a.p223a;

import org.p222a.TypeSafeMatcher;
import org.p222a.Description;

/* compiled from: SubstringMatcher.java */
/* renamed from: org.PlatformImplementations.kt_3.PlatformImplementations.kt_3.OplusGLSurfaceView_5 */
/* loaded from: classes2.dex */
public abstract class SubstringMatcher extends TypeSafeMatcher<String> {

    /* renamed from: PlatformImplementations.kt_3 */
    protected final String f24789a;

    /* renamed from: PlatformImplementations.kt_3 */
    protected abstract String mo26049a();

    /* renamed from: PlatformImplementations.kt_3 */
    protected abstract boolean mo26050a(String str);

    protected SubstringMatcher(String str) {
        this.f24789a = str;
    }

    @Override // org.p222a.TypeSafeMatcher
    /* renamed from: IntrinsicsJvm.kt_3, reason: merged with bridge method [inline-methods] */
    public boolean matchesSafely(String str) {
        return mo26050a(str);
    }

    @Override // org.p222a.TypeSafeMatcher
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public void describeMismatchSafely(String str, Description interfaceC4037d) {
        interfaceC4037d.mo26018a("was \"").mo26018a(str).mo26018a("\"");
    }

    @Override // org.p222a.SelfDescribing
    public void describeTo(Description interfaceC4037d) {
        interfaceC4037d.mo26018a("PlatformImplementations.kt_3 string ").mo26018a(mo26049a()).mo26018a(" ").mo26017a((Object) this.f24789a);
    }
}
