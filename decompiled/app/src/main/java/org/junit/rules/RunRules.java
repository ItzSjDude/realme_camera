package org.junit.rules;

/* loaded from: classes2.dex */
public class RunRules extends org.junit.runners.model.Statement {
    private final org.junit.runners.model.Statement statement;

    public RunRules(org.junit.runners.model.Statement statement, java.lang.Iterable<org.junit.rules.TestRule> iterable, org.junit.runner.Description description) {
        this.statement = applyAll(statement, iterable, description);
    }

    @Override // org.junit.runners.model.Statement
    public void evaluate() throws java.lang.Throwable {
        this.statement.evaluate();
    }

    private static org.junit.runners.model.Statement applyAll(org.junit.runners.model.Statement statement, java.lang.Iterable<org.junit.rules.TestRule> iterable, org.junit.runner.Description description) {
        java.util.Iterator<org.junit.rules.TestRule> it = iterable.iterator();
        while (it.hasNext()) {
            statement = it.next().apply(statement, description);
        }
        return statement;
    }
}
