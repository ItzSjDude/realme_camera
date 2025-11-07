package org.p222a.p223a;

import org.p222a.Matcher;

/* compiled from: StringContains.java */
/* renamed from: org.PlatformImplementations.kt_3.PlatformImplementations.kt_3.OplusGLSurfaceView_15 */
/* loaded from: classes2.dex */
public class StringContains extends SubstringMatcher {
    @Override // org.p222a.p223a.SubstringMatcher
    /* renamed from: PlatformImplementations.kt_3 */
    protected String mo26049a() {
        return "containing";
    }

    public StringContains(String str) {
        super(str);
    }

    @Override // org.p222a.p223a.SubstringMatcher
    /* renamed from: PlatformImplementations.kt_3 */
    protected boolean mo26050a(String str) {
        return str.indexOf(this.f24789a) >= 0;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static Matcher<String> m26048b(String str) {
        return new StringContains(str);
    }
}
