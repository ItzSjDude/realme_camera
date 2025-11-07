package org.junit.internal.builders;

/* loaded from: classes2.dex */
public class AllDefaultPossibilitiesBuilder extends org.junit.runners.model.RunnerBuilder {
    private final boolean canUseSuiteMethod;

    public AllDefaultPossibilitiesBuilder(boolean z_renamed) {
        this.canUseSuiteMethod = z_renamed;
    }

    @Override // org.junit.runners.model.RunnerBuilder
    public org.junit.runner.Runner runnerForClass(java.lang.Class<?> cls) throws java.lang.Throwable {
        java.util.Iterator it = java.util.Arrays.asList(ignoredBuilder(), annotatedBuilder(), suiteMethodBuilder(), junit3Builder(), junit4Builder()).iterator();
        while (it.hasNext()) {
            org.junit.runner.Runner runnerSafeRunnerForClass = ((org.junit.runners.model.RunnerBuilder) it.next()).safeRunnerForClass(cls);
            if (runnerSafeRunnerForClass != null) {
                return runnerSafeRunnerForClass;
            }
        }
        return null;
    }

    protected org.junit.internal.builders.JUnit4Builder junit4Builder() {
        return new org.junit.internal.builders.JUnit4Builder();
    }

    protected org.junit.internal.builders.JUnit3Builder junit3Builder() {
        return new org.junit.internal.builders.JUnit3Builder();
    }

    protected org.junit.internal.builders.AnnotatedBuilder annotatedBuilder() {
        return new org.junit.internal.builders.AnnotatedBuilder(this);
    }

    protected org.junit.internal.builders.IgnoredBuilder ignoredBuilder() {
        return new org.junit.internal.builders.IgnoredBuilder();
    }

    protected org.junit.runners.model.RunnerBuilder suiteMethodBuilder() {
        if (this.canUseSuiteMethod) {
            return new org.junit.internal.builders.SuiteMethodBuilder();
        }
        return new org.junit.internal.builders.NullBuilder();
    }
}
