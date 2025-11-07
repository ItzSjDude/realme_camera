package org.junit.internal.runners.statements;

/* loaded from: classes2.dex */
public class RunBefores extends org.junit.runners.model.Statement {
    private final java.util.List<org.junit.runners.model.FrameworkMethod> befores;
    private final org.junit.runners.model.Statement next;
    private final java.lang.Object target;

    public RunBefores(org.junit.runners.model.Statement statement, java.util.List<org.junit.runners.model.FrameworkMethod> list, java.lang.Object obj) {
        this.next = statement;
        this.befores = list;
        this.target = obj;
    }

    @Override // org.junit.runners.model.Statement
    public void evaluate() throws java.lang.Throwable {
        java.util.Iterator<org.junit.runners.model.FrameworkMethod> it = this.befores.iterator();
        while (it.hasNext()) {
            it.next().invokeExplosively(this.target, new java.lang.Object[0]);
        }
        this.next.evaluate();
    }
}
