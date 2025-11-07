package org.junit;

import java.util.Arrays;
import org.p222a.CoreMatchers;
import org.p222a.Matcher;

/* loaded from: classes2.dex */
public class Assume {
    public static void assumeTrue(boolean z) {
        assumeThat(Boolean.valueOf(z), CoreMatchers.m26062a(true));
    }

    public static void assumeFalse(boolean z) {
        assumeTrue(!z);
    }

    public static void assumeTrue(String str, boolean z) {
        if (!z) {
            throw new AssumptionViolatedException(str);
        }
    }

    public static void assumeFalse(String str, boolean z) {
        assumeTrue(str, !z);
    }

    public static void assumeNotNull(Object... objArr) {
        assumeThat(Arrays.asList(objArr), CoreMatchers.m26069c(CoreMatchers.m26067b()));
    }

    public static <T> void assumeThat(T t, Matcher<T> interfaceC4039f) {
        if (!interfaceC4039f.matches(t)) {
            throw new AssumptionViolatedException(t, interfaceC4039f);
        }
    }

    public static <T> void assumeThat(String str, T t, Matcher<T> interfaceC4039f) {
        if (!interfaceC4039f.matches(t)) {
            throw new AssumptionViolatedException(str, t, interfaceC4039f);
        }
    }

    public static void assumeNoException(Throwable th) {
        assumeThat(th, CoreMatchers.m26059a());
    }

    public static void assumeNoException(String str, Throwable th) {
        assumeThat(str, th, CoreMatchers.m26059a());
    }
}
