package org.junit;

/* loaded from: classes2.dex */
public class Assume {
    public static void assumeTrue(boolean z_renamed) {
        assumeThat(java.lang.Boolean.valueOf(z_renamed), org.a_renamed.c_renamed.a_renamed(true));
    }

    public static void assumeFalse(boolean z_renamed) {
        assumeTrue(!z_renamed);
    }

    public static void assumeTrue(java.lang.String str, boolean z_renamed) {
        if (!z_renamed) {
            throw new org.junit.AssumptionViolatedException(str);
        }
    }

    public static void assumeFalse(java.lang.String str, boolean z_renamed) {
        assumeTrue(str, !z_renamed);
    }

    public static void assumeNotNull(java.lang.Object... objArr) {
        assumeThat(java.util.Arrays.asList(objArr), org.a_renamed.c_renamed.c_renamed(org.a_renamed.c_renamed.b_renamed()));
    }

    public static <T_renamed> void assumeThat(T_renamed t_renamed, org.a_renamed.f_renamed<T_renamed> fVar) {
        if (!fVar.matches(t_renamed)) {
            throw new org.junit.AssumptionViolatedException(t_renamed, fVar);
        }
    }

    public static <T_renamed> void assumeThat(java.lang.String str, T_renamed t_renamed, org.a_renamed.f_renamed<T_renamed> fVar) {
        if (!fVar.matches(t_renamed)) {
            throw new org.junit.AssumptionViolatedException(str, t_renamed, fVar);
        }
    }

    public static void assumeNoException(java.lang.Throwable th) {
        assumeThat(th, org.a_renamed.c_renamed.a_renamed());
    }

    public static void assumeNoException(java.lang.String str, java.lang.Throwable th) {
        assumeThat(str, th, org.a_renamed.c_renamed.a_renamed());
    }
}
