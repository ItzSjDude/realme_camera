package org.junit.internal;

/* loaded from: classes2.dex */
public class AssumptionViolatedException extends java.lang.RuntimeException implements org.a_renamed.h_renamed {
    private static final long serialVersionUID = 2;
    private final java.lang.String fAssumption;
    private final org.a_renamed.f_renamed<?> fMatcher;
    private final java.lang.Object fValue;
    private final boolean fValueMatcher;

    @java.lang.Deprecated
    public AssumptionViolatedException(java.lang.String str, boolean z_renamed, java.lang.Object obj, org.a_renamed.f_renamed<?> fVar) {
        this.fAssumption = str;
        this.fValue = obj;
        this.fMatcher = fVar;
        this.fValueMatcher = z_renamed;
        if (obj instanceof java.lang.Throwable) {
            initCause((java.lang.Throwable) obj);
        }
    }

    @java.lang.Deprecated
    public AssumptionViolatedException(java.lang.Object obj, org.a_renamed.f_renamed<?> fVar) {
        this(null, true, obj, fVar);
    }

    @java.lang.Deprecated
    public AssumptionViolatedException(java.lang.String str, java.lang.Object obj, org.a_renamed.f_renamed<?> fVar) {
        this(str, true, obj, fVar);
    }

    @java.lang.Deprecated
    public AssumptionViolatedException(java.lang.String str) {
        this(str, false, null, null);
    }

    @java.lang.Deprecated
    public AssumptionViolatedException(java.lang.String str, java.lang.Throwable th) {
        this(str, false, null, null);
        initCause(th);
    }

    @Override // java.lang.Throwable
    public java.lang.String getMessage() {
        return org.a_renamed.i_renamed.c_renamed(this);
    }

    @Override // org.a_renamed.h_renamed
    public void describeTo(org.a_renamed.d_renamed dVar) {
        java.lang.String str = this.fAssumption;
        if (str != null) {
            dVar.a_renamed(str);
        }
        if (this.fValueMatcher) {
            if (this.fAssumption != null) {
                dVar.a_renamed(": ");
            }
            dVar.a_renamed("got: ");
            dVar.a_renamed(this.fValue);
            if (this.fMatcher != null) {
                dVar.a_renamed(", expected: ");
                dVar.a_renamed((org.a_renamed.h_renamed) this.fMatcher);
            }
        }
    }
}
