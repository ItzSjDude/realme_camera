package org.junit.internal.runners.statements;

/* loaded from: classes2.dex */
public class RunAfters extends org.junit.runners.model.Statement {
    private final java.util.List<org.junit.runners.model.FrameworkMethod> afters;
    private final org.junit.runners.model.Statement next;
    private final java.lang.Object target;

    public RunAfters(org.junit.runners.model.Statement statement, java.util.List<org.junit.runners.model.FrameworkMethod> list, java.lang.Object obj) {
        this.next = statement;
        this.afters = list;
        this.target = obj;
    }

    @Override // org.junit.runners.model.Statement
    public void evaluate() throws java.lang.Exception {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            try {
                this.next.evaluate();
                java.util.Iterator<org.junit.runners.model.FrameworkMethod> it = this.afters.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().invokeExplosively(this.target, new java.lang.Object[0]);
                    } catch (java.lang.Throwable th) {
                        arrayList.add(th);
                    }
                }
            } catch (java.lang.Throwable th2) {
                arrayList.add(th2);
                java.util.Iterator<org.junit.runners.model.FrameworkMethod> it2 = this.afters.iterator();
                while (it2.hasNext()) {
                    try {
                        it2.next().invokeExplosively(this.target, new java.lang.Object[0]);
                    } catch (java.lang.Throwable th3) {
                        arrayList.add(th3);
                    }
                }
            }
            org.junit.runners.model.MultipleFailureException.assertEmpty(arrayList);
        } catch (java.lang.Throwable th4) {
            java.util.Iterator<org.junit.runners.model.FrameworkMethod> it3 = this.afters.iterator();
            while (it3.hasNext()) {
                try {
                    it3.next().invokeExplosively(this.target, new java.lang.Object[0]);
                } catch (java.lang.Throwable th5) {
                    arrayList.add(th5);
                }
            }
            throw th4;
        }
    }
}
