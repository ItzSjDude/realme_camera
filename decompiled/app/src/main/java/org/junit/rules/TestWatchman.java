package org.junit.rules;

@java.lang.Deprecated
/* loaded from: classes2.dex */
public class TestWatchman implements org.junit.rules.MethodRule {
    public void failed(java.lang.Throwable th, org.junit.runners.model.FrameworkMethod frameworkMethod) {
    }

    public void finished(org.junit.runners.model.FrameworkMethod frameworkMethod) {
    }

    public void starting(org.junit.runners.model.FrameworkMethod frameworkMethod) {
    }

    public void succeeded(org.junit.runners.model.FrameworkMethod frameworkMethod) {
    }

    @Override // org.junit.rules.MethodRule
    public org.junit.runners.model.Statement apply(final org.junit.runners.model.Statement statement, final org.junit.runners.model.FrameworkMethod frameworkMethod, java.lang.Object obj) {
        return new org.junit.runners.model.Statement() { // from class: org.junit.rules.TestWatchman.1
            @Override // org.junit.runners.model.Statement
            public void evaluate() throws java.lang.Throwable {
                org.junit.rules.TestWatchman.this.starting(frameworkMethod);
                try {
                    try {
                        statement.evaluate();
                        org.junit.rules.TestWatchman.this.succeeded(frameworkMethod);
                    } catch (org.junit.internal.AssumptionViolatedException e_renamed) {
                        throw e_renamed;
                    } catch (java.lang.Throwable th) {
                        org.junit.rules.TestWatchman.this.failed(th, frameworkMethod);
                        throw th;
                    }
                } finally {
                    org.junit.rules.TestWatchman.this.finished(frameworkMethod);
                }
            }
        };
    }
}
