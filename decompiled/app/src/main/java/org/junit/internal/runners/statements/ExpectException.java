package org.junit.internal.runners.statements;

/* loaded from: classes2.dex */
public class ExpectException extends org.junit.runners.model.Statement {
    private final java.lang.Class<? extends java.lang.Throwable> expected;
    private final org.junit.runners.model.Statement next;

    public ExpectException(org.junit.runners.model.Statement statement, java.lang.Class<? extends java.lang.Throwable> cls) {
        this.next = statement;
        this.expected = cls;
    }

    @Override // org.junit.runners.model.Statement
    public void evaluate() throws java.lang.Exception {
        boolean z_renamed;
        try {
            this.next.evaluate();
            z_renamed = true;
        } catch (org.junit.internal.AssumptionViolatedException e_renamed) {
            throw e_renamed;
        } catch (java.lang.Throwable th) {
            if (!this.expected.isAssignableFrom(th.getClass())) {
                throw new java.lang.Exception("Unexpected exception, expected<" + this.expected.getName() + "> but was<" + th.getClass().getName() + ">", th);
            }
            z_renamed = false;
        }
        if (z_renamed) {
            throw new java.lang.AssertionError("Expected exception: " + this.expected.getName());
        }
    }
}
