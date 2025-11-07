package org.junit.internal.runners.statements;

/* loaded from: classes2.dex */
public class Fail extends org.junit.runners.model.Statement {
    private final java.lang.Throwable error;

    public Fail(java.lang.Throwable th) {
        this.error = th;
    }

    @Override // org.junit.runners.model.Statement
    public void evaluate() throws java.lang.Throwable {
        throw this.error;
    }
}
