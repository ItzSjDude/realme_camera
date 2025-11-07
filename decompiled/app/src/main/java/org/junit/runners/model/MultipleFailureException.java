package org.junit.runners.model;

/* loaded from: classes2.dex */
public class MultipleFailureException extends java.lang.Exception {
    private static final long serialVersionUID = 1;
    private final java.util.List<java.lang.Throwable> fErrors;

    public MultipleFailureException(java.util.List<java.lang.Throwable> list) {
        this.fErrors = new java.util.ArrayList(list);
    }

    public java.util.List<java.lang.Throwable> getFailures() {
        return java.util.Collections.unmodifiableList(this.fErrors);
    }

    @Override // java.lang.Throwable
    public java.lang.String getMessage() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.format("There were %d_renamed errors:", java.lang.Integer.valueOf(this.fErrors.size())));
        for (java.lang.Throwable th : this.fErrors) {
            sb.append(java.lang.String.format("\n_renamed  %s_renamed(%s_renamed)", th.getClass().getName(), th.getMessage()));
        }
        return sb.toString();
    }

    public static void assertEmpty(java.util.List<java.lang.Throwable> list) throws java.lang.Exception {
        if (list.isEmpty()) {
            return;
        }
        if (list.size() == 1) {
            throw org.junit.internal.Throwables.rethrowAsException(list.get(0));
        }
        throw new org.junit.internal.runners.model.MultipleFailureException(list);
    }
}
