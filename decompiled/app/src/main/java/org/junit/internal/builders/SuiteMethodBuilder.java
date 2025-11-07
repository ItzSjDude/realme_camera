package org.junit.internal.builders;

/* loaded from: classes2.dex */
public class SuiteMethodBuilder extends org.junit.runners.model.RunnerBuilder {
    @Override // org.junit.runners.model.RunnerBuilder
    public org.junit.runner.Runner runnerForClass(java.lang.Class<?> cls) throws java.lang.Throwable {
        if (hasSuiteMethod(cls)) {
            return new org.junit.internal.runners.SuiteMethod(cls);
        }
        return null;
    }

    public boolean hasSuiteMethod(java.lang.Class<?> cls) throws java.lang.NoSuchMethodException, java.lang.SecurityException {
        try {
            cls.getMethod("suite", new java.lang.Class[0]);
            return true;
        } catch (java.lang.NoSuchMethodException unused) {
            return false;
        }
    }
}
