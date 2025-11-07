package org.junit.runner;

/* loaded from: classes2.dex */
public class Computer {
    public static org.junit.runner.Computer serial() {
        return new org.junit.runner.Computer();
    }

    public org.junit.runner.Runner getSuite(final org.junit.runners.model.RunnerBuilder runnerBuilder, java.lang.Class<?>[] clsArr) throws org.junit.runners.model.InitializationError {
        return new org.junit.runners.Suite(new org.junit.runners.model.RunnerBuilder() { // from class: org.junit.runner.Computer.1
            @Override // org.junit.runners.model.RunnerBuilder
            public org.junit.runner.Runner runnerForClass(java.lang.Class<?> cls) throws java.lang.Throwable {
                return org.junit.runner.Computer.this.getRunner(runnerBuilder, cls);
            }
        }, clsArr);
    }

    protected org.junit.runner.Runner getRunner(org.junit.runners.model.RunnerBuilder runnerBuilder, java.lang.Class<?> cls) throws java.lang.Throwable {
        return runnerBuilder.runnerForClass(cls);
    }
}
