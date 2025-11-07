package org.junit.rules;

/* loaded from: classes2.dex */
public class TestName extends org.junit.rules.TestWatcher {
    private java.lang.String name;

    @Override // org.junit.rules.TestWatcher
    protected void starting(org.junit.runner.Description description) {
        this.name = description.getMethodName();
    }

    public java.lang.String getMethodName() {
        return this.name;
    }
}
