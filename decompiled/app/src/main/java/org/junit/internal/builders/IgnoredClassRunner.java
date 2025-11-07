package org.junit.internal.builders;

/* loaded from: classes2.dex */
public class IgnoredClassRunner extends org.junit.runner.Runner {
    private final java.lang.Class<?> clazz;

    public IgnoredClassRunner(java.lang.Class<?> cls) {
        this.clazz = cls;
    }

    @Override // org.junit.runner.Runner
    public void run(org.junit.runner.notification.RunNotifier runNotifier) {
        runNotifier.fireTestIgnored(getDescription());
    }

    @Override // org.junit.runner.Runner, org.junit.runner.Describable
    public org.junit.runner.Description getDescription() {
        return org.junit.runner.Description.createSuiteDescription(this.clazz);
    }
}
