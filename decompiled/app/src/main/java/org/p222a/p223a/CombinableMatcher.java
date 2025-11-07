package org.p222a.p223a;

import org.p222a.TypeSafeDiagnosingMatcher;
import org.p222a.Description;
import org.p222a.Matcher;
import org.p222a.SelfDescribing;

/* compiled from: CombinableMatcher.java */
/* renamed from: org.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class CombinableMatcher<T> extends TypeSafeDiagnosingMatcher<T> {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Matcher<? super T> f24779a;

    @Override // org.p222a.TypeSafeDiagnosingMatcher
    /* renamed from: PlatformImplementations.kt_3 */
    protected boolean mo26027a(T t, Description interfaceC4037d) {
        if (this.f24779a.matches(t)) {
            return true;
        }
        this.f24779a.describeMismatch(t, interfaceC4037d);
        return false;
    }

    @Override // org.p222a.SelfDescribing
    public void describeTo(Description interfaceC4037d) {
        interfaceC4037d.mo26020a((SelfDescribing) this.f24779a);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static <LHS> PlatformImplementations.kt_3<LHS> m26025a(Matcher<? super LHS> interfaceC4039f) {
        return new PlatformImplementations.kt_3<>(interfaceC4039f);
    }

    /* compiled from: CombinableMatcher.java */
    /* renamed from: org.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
    public static final class PlatformImplementations.kt_3<X> {

        /* renamed from: PlatformImplementations.kt_3 */
        private final Matcher<? super X> f24780a;

        public PlatformImplementations.kt_3(Matcher<? super X> interfaceC4039f) {
            this.f24780a = interfaceC4039f;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static <LHS> IntrinsicsJvm.kt_4<LHS> m26026b(Matcher<? super LHS> interfaceC4039f) {
        return new IntrinsicsJvm.kt_4<>(interfaceC4039f);
    }

    /* compiled from: CombinableMatcher.java */
    /* renamed from: org.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4$IntrinsicsJvm.kt_4 */
    public static final class IntrinsicsJvm.kt_4<X> {

        /* renamed from: PlatformImplementations.kt_3 */
        private final Matcher<? super X> f24781a;

        public IntrinsicsJvm.kt_4(Matcher<? super X> interfaceC4039f) {
            this.f24781a = interfaceC4039f;
        }
    }
}
