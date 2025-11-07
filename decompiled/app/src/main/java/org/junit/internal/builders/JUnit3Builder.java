package org.junit.internal.builders;

/* loaded from: classes2.dex */
public class JUnit3Builder extends org.junit.runners.model.RunnerBuilder {
    @Override // org.junit.runners.model.RunnerBuilder
    public org.junit.runner.Runner runnerForClass(java.lang.Class<?> cls) throws java.lang.Throwable {
        if (isPre4Test(cls)) {
            return new org.junit.internal.runners.JUnit38ClassRunner(cls);
        }
        return null;
    }

    boolean isPre4Test(java.lang.Class<?> cls) {
        return b_renamed.b_renamed.e_renamed.class.isAssignableFrom(cls);
    }
}
