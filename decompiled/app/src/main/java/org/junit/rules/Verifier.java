package org.junit.rules;

/* loaded from: classes2.dex */
public abstract class Verifier implements org.junit.rules.TestRule {
    protected void verify() throws java.lang.Throwable {
    }

    @Override // org.junit.rules.TestRule
    public org.junit.runners.model.Statement apply(final org.junit.runners.model.Statement statement, org.junit.runner.Description description) {
        return new org.junit.runners.model.Statement() { // from class: org.junit.rules.Verifier.1
            @Override // org.junit.runners.model.Statement
            public void evaluate() throws java.lang.Throwable {
                statement.evaluate();
                org.junit.rules.Verifier.this.verify();
            }
        };
    }
}
