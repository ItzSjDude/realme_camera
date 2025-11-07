package org.junit.rules;

/* loaded from: classes2.dex */
public abstract class ExternalResource implements org.junit.rules.TestRule {
    protected void after() {
    }

    protected void before() throws java.lang.Throwable {
    }

    @Override // org.junit.rules.TestRule
    public org.junit.runners.model.Statement apply(org.junit.runners.model.Statement statement, org.junit.runner.Description description) {
        return statement(statement);
    }

    private org.junit.runners.model.Statement statement(final org.junit.runners.model.Statement statement) {
        return new org.junit.runners.model.Statement() { // from class: org.junit.rules.ExternalResource.1
            @Override // org.junit.runners.model.Statement
            public void evaluate() throws java.lang.Throwable {
                org.junit.rules.ExternalResource.this.before();
                try {
                    statement.evaluate();
                } finally {
                    org.junit.rules.ExternalResource.this.after();
                }
            }
        };
    }
}
