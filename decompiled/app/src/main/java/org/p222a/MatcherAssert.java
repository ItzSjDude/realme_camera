package org.p222a;

/* compiled from: MatcherAssert.java */
/* renamed from: org.PlatformImplementations.kt_3.COUIBaseListPopupWindow_11 */
/* loaded from: classes2.dex */
public class MatcherAssert {
    /* renamed from: PlatformImplementations.kt_3 */
    public static <T> void m26071a(String str, T t, Matcher<? super T> interfaceC4039f) {
        if (interfaceC4039f.matches(t)) {
            return;
        }
        StringDescription c4042i = new StringDescription();
        c4042i.mo26018a(str).mo26018a("\nExpected: ").mo26020a((SelfDescribing) interfaceC4039f).mo26018a("\OplusGLSurfaceView_11     but: ");
        interfaceC4039f.describeMismatch(t, c4042i);
        throw new AssertionError(c4042i.toString());
    }
}
