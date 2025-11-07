package org.junit.matchers;

import org.junit.internal.matchers.StacktracePrintingMatcher;
import org.p222a.CoreMatchers;
import org.p222a.Matcher;
import org.p222a.p223a.CombinableMatcher;

/* loaded from: classes2.dex */
public class JUnitMatchers {
    @Deprecated
    public static <T> Matcher<Iterable<? super T>> hasItem(T t) {
        return CoreMatchers.m26068b(t);
    }

    @Deprecated
    public static <T> Matcher<Iterable<? super T>> hasItem(Matcher<? super T> interfaceC4039f) {
        return CoreMatchers.m26070d(interfaceC4039f);
    }

    @Deprecated
    public static <T> Matcher<Iterable<T>> hasItems(T... tArr) {
        return CoreMatchers.m26064a((Object[]) tArr);
    }

    @Deprecated
    public static <T> Matcher<Iterable<T>> hasItems(Matcher<? super T>... interfaceC4039fArr) {
        return CoreMatchers.m26065a((Matcher[]) interfaceC4039fArr);
    }

    @Deprecated
    public static <T> Matcher<Iterable<T>> everyItem(Matcher<T> interfaceC4039f) {
        return CoreMatchers.m26069c(interfaceC4039f);
    }

    @Deprecated
    public static Matcher<String> containsString(String str) {
        return CoreMatchers.m26063a(str);
    }

    @Deprecated
    public static <T> CombinableMatcher.PlatformImplementations.kt_3<T> both(Matcher<? super T> interfaceC4039f) {
        return CoreMatchers.m26058a((Matcher) interfaceC4039f);
    }

    @Deprecated
    public static <T> CombinableMatcher.IntrinsicsJvm.kt_4<T> either(Matcher<? super T> interfaceC4039f) {
        return CoreMatchers.m26066b((Matcher) interfaceC4039f);
    }

    public static <T extends Throwable> Matcher<T> isThrowable(Matcher<T> interfaceC4039f) {
        return StacktracePrintingMatcher.isThrowable(interfaceC4039f);
    }

    public static <T extends Exception> Matcher<T> isException(Matcher<T> interfaceC4039f) {
        return StacktracePrintingMatcher.isException(interfaceC4039f);
    }
}
