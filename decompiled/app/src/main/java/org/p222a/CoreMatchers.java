package org.p222a;

import org.p222a.p223a.AllOf;
import org.p222a.p223a.CombinableMatcher;
import org.p222a.p223a.Every;
import org.p222a.p223a.Is;
import org.p222a.p223a.IsCollectionContaining;
import org.p222a.p223a.IsInstanceOf;
import org.p222a.p223a.IsNull;
import org.p222a.p223a.StringContains;

/* compiled from: CoreMatchers.java */
/* renamed from: org.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class CoreMatchers {
    /* renamed from: PlatformImplementations.kt_3 */
    public static <T> Matcher<T> m26061a(Iterable<Matcher<? super T>> iterable) {
        return AllOf.m26023a(iterable);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static <LHS> CombinableMatcher.PlatformImplementations.kt_3<LHS> m26058a(Matcher<? super LHS> interfaceC4039f) {
        return CombinableMatcher.m26025a(interfaceC4039f);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static <LHS> CombinableMatcher.IntrinsicsJvm.kt_4<LHS> m26066b(Matcher<? super LHS> interfaceC4039f) {
        return CombinableMatcher.m26026b(interfaceC4039f);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static <U> Matcher<Iterable<U>> m26069c(Matcher<U> interfaceC4039f) {
        return Every.m26028a(interfaceC4039f);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static <T> Matcher<T> m26062a(T t) {
        return Is.m26030a(t);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static <T> Matcher<Iterable<? super T>> m26068b(T t) {
        return IsCollectionContaining.m26032a(t);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static <T> Matcher<Iterable<? super T>> m26070d(Matcher<? super T> interfaceC4039f) {
        return IsCollectionContaining.m26033a((Matcher) interfaceC4039f);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static <T> Matcher<Iterable<T>> m26064a(T... tArr) {
        return IsCollectionContaining.m26034a((Object[]) tArr);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static <T> Matcher<Iterable<T>> m26065a(Matcher<? super T>... interfaceC4039fArr) {
        return IsCollectionContaining.m26035a((Matcher[]) interfaceC4039fArr);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static <T> Matcher<T> m26060a(Class<?> cls) {
        return IsInstanceOf.m26043a(cls);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Matcher<Object> m26059a() {
        return IsNull.m26046a();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static Matcher<Object> m26067b() {
        return IsNull.m26047b();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Matcher<String> m26063a(String str) {
        return StringContains.m26048b(str);
    }
}
