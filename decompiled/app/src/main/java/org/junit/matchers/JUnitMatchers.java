package org.junit.matchers;

/* loaded from: classes2.dex */
public class JUnitMatchers {
    @java.lang.Deprecated
    public static <T_renamed> org.a_renamed.f_renamed<java.lang.Iterable<? super T_renamed>> hasItem(T_renamed t_renamed) {
        return org.a_renamed.c_renamed.b_renamed(t_renamed);
    }

    @java.lang.Deprecated
    public static <T_renamed> org.a_renamed.f_renamed<java.lang.Iterable<? super T_renamed>> hasItem(org.a_renamed.f_renamed<? super T_renamed> fVar) {
        return org.a_renamed.c_renamed.d_renamed(fVar);
    }

    @java.lang.Deprecated
    public static <T_renamed> org.a_renamed.f_renamed<java.lang.Iterable<T_renamed>> hasItems(T_renamed... tArr) {
        return org.a_renamed.c_renamed.a_renamed((java.lang.Object[]) tArr);
    }

    @java.lang.Deprecated
    public static <T_renamed> org.a_renamed.f_renamed<java.lang.Iterable<T_renamed>> hasItems(org.a_renamed.f_renamed<? super T_renamed>... fVarArr) {
        return org.a_renamed.c_renamed.a_renamed((org.a_renamed.f_renamed[]) fVarArr);
    }

    @java.lang.Deprecated
    public static <T_renamed> org.a_renamed.f_renamed<java.lang.Iterable<T_renamed>> everyItem(org.a_renamed.f_renamed<T_renamed> fVar) {
        return org.a_renamed.c_renamed.c_renamed(fVar);
    }

    @java.lang.Deprecated
    public static org.a_renamed.f_renamed<java.lang.String> containsString(java.lang.String str) {
        return org.a_renamed.c_renamed.a_renamed(str);
    }

    @java.lang.Deprecated
    public static <T_renamed> org.a_renamed.a_renamed.b_renamed.a_renamed<T_renamed> both(org.a_renamed.f_renamed<? super T_renamed> fVar) {
        return org.a_renamed.c_renamed.a_renamed((org.a_renamed.f_renamed) fVar);
    }

    @java.lang.Deprecated
    public static <T_renamed> org.a_renamed.a_renamed.b_renamed.CombinableMatcher_3<T_renamed> either(org.a_renamed.f_renamed<? super T_renamed> fVar) {
        return org.a_renamed.c_renamed.b_renamed((org.a_renamed.f_renamed) fVar);
    }

    public static <T_renamed extends java.lang.Throwable> org.a_renamed.f_renamed<T_renamed> isThrowable(org.a_renamed.f_renamed<T_renamed> fVar) {
        return org.junit.internal.matchers.StacktracePrintingMatcher.isThrowable(fVar);
    }

    public static <T_renamed extends java.lang.Exception> org.a_renamed.f_renamed<T_renamed> isException(org.a_renamed.f_renamed<T_renamed> fVar) {
        return org.junit.internal.matchers.StacktracePrintingMatcher.isException(fVar);
    }
}
