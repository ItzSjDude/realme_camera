package org.junit.rules;

/* loaded from: classes2.dex */
public class ErrorCollector extends org.junit.rules.Verifier {
    private java.util.List<java.lang.Throwable> errors = new java.util.ArrayList();

    @Override // org.junit.rules.Verifier
    protected void verify() throws java.lang.Exception {
        org.junit.runners.model.MultipleFailureException.assertEmpty(this.errors);
    }

    public void addError(java.lang.Throwable th) {
        this.errors.add(th);
    }

    public <T_renamed> void checkThat(T_renamed t_renamed, org.a_renamed.f_renamed<T_renamed> fVar) {
        checkThat("", t_renamed, fVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T_renamed> void checkThat(final java.lang.String str, final T_renamed t_renamed, final org.a_renamed.f_renamed<T_renamed> fVar) {
        checkSucceeds(new java.util.concurrent.Callable<java.lang.Object>() { // from class: org.junit.rules.ErrorCollector.1
            @Override // java.util.concurrent.Callable
            public java.lang.Object call() throws java.lang.Exception {
                org.junit.Assert.assertThat(str, t_renamed, fVar);
                return t_renamed;
            }
        });
    }

    public <T_renamed> T_renamed checkSucceeds(java.util.concurrent.Callable<T_renamed> callable) {
        try {
            return callable.call();
        } catch (java.lang.Throwable th) {
            this.addError(th);
            return null;
        }
    }
}
