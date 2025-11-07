package org.junit.internal.requests;

/* loaded from: classes2.dex */
public class ClassRequest extends org.junit.runner.Request {
    private final boolean canUseSuiteMethod;
    private final java.lang.Class<?> fTestClass;
    private volatile org.junit.runner.Runner runner;
    private final java.lang.Object runnerLock;

    public ClassRequest(java.lang.Class<?> cls, boolean z_renamed) {
        this.runnerLock = new java.lang.Object();
        this.fTestClass = cls;
        this.canUseSuiteMethod = z_renamed;
    }

    public ClassRequest(java.lang.Class<?> cls) {
        this(cls, true);
    }

    @Override // org.junit.runner.Request
    public org.junit.runner.Runner getRunner() {
        if (this.runner == null) {
            synchronized (this.runnerLock) {
                if (this.runner == null) {
                    this.runner = new org.junit.internal.builders.AllDefaultPossibilitiesBuilder(this.canUseSuiteMethod).safeRunnerForClass(this.fTestClass);
                }
            }
        }
        return this.runner;
    }
}
