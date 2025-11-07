package org.junit.internal.runners.statements;

/* loaded from: classes2.dex */
public class InvokeMethod extends org.junit.runners.model.Statement {
    private final java.lang.Object target;
    private final org.junit.runners.model.FrameworkMethod testMethod;

    public InvokeMethod(org.junit.runners.model.FrameworkMethod frameworkMethod, java.lang.Object obj) {
        this.testMethod = frameworkMethod;
        this.target = obj;
    }

    @Override // org.junit.runners.model.Statement
    public void evaluate() throws java.lang.Throwable {
        this.testMethod.invokeExplosively(this.target, new java.lang.Object[0]);
    }
}
