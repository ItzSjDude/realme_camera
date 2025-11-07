package org.junit;

/* loaded from: classes2.dex */
public class AssumptionViolatedException extends org.junit.internal.AssumptionViolatedException {
    private static final long serialVersionUID = 1;

    public <T_renamed> AssumptionViolatedException(T_renamed t_renamed, org.a_renamed.f_renamed<T_renamed> fVar) {
        super((java.lang.Object) t_renamed, (org.a_renamed.f_renamed<?>) fVar);
    }

    public <T_renamed> AssumptionViolatedException(java.lang.String str, T_renamed t_renamed, org.a_renamed.f_renamed<T_renamed> fVar) {
        super(str, t_renamed, fVar);
    }

    public AssumptionViolatedException(java.lang.String str) {
        super(str);
    }

    public AssumptionViolatedException(java.lang.String str, java.lang.Throwable th) {
        super(str, th);
    }
}
