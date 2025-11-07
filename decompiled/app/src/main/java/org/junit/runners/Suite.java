package org.junit.runners;

/* loaded from: classes2.dex */
public class Suite extends org.junit.runners.ParentRunner<org.junit.runner.Runner> {
    private final java.util.List<org.junit.runner.Runner> runners;

    @java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE})
    @java.lang.annotation.Inherited
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
    public @interface SuiteClasses {
        java.lang.Class<?>[] value();
    }

    public static org.junit.runner.Runner emptySuite() {
        try {
            return new org.junit.runners.Suite((java.lang.Class<?>) null, (java.lang.Class<?>[]) new java.lang.Class[0]);
        } catch (org.junit.runners.model.InitializationError unused) {
            throw new java.lang.RuntimeException("This shouldn't_renamed be_renamed possible");
        }
    }

    private static java.lang.Class<?>[] getAnnotatedClasses(java.lang.Class<?> cls) throws org.junit.runners.model.InitializationError {
        org.junit.runners.Suite.SuiteClasses suiteClasses = (org.junit.runners.Suite.SuiteClasses) cls.getAnnotation(org.junit.runners.Suite.SuiteClasses.class);
        if (suiteClasses == null) {
            throw new org.junit.runners.model.InitializationError(java.lang.String.format("class '%s_renamed' must have a_renamed SuiteClasses annotation", cls.getName()));
        }
        return suiteClasses.value();
    }

    public Suite(java.lang.Class<?> cls, org.junit.runners.model.RunnerBuilder runnerBuilder) throws org.junit.runners.model.InitializationError {
        this(runnerBuilder, cls, getAnnotatedClasses(cls));
    }

    public Suite(org.junit.runners.model.RunnerBuilder runnerBuilder, java.lang.Class<?>[] clsArr) throws org.junit.runners.model.InitializationError {
        this((java.lang.Class<?>) null, runnerBuilder.runners((java.lang.Class<?>) null, clsArr));
    }

    protected Suite(java.lang.Class<?> cls, java.lang.Class<?>[] clsArr) throws org.junit.runners.model.InitializationError {
        this(new org.junit.internal.builders.AllDefaultPossibilitiesBuilder(true), cls, clsArr);
    }

    protected Suite(org.junit.runners.model.RunnerBuilder runnerBuilder, java.lang.Class<?> cls, java.lang.Class<?>[] clsArr) throws org.junit.runners.model.InitializationError {
        this(cls, runnerBuilder.runners(cls, clsArr));
    }

    protected Suite(java.lang.Class<?> cls, java.util.List<org.junit.runner.Runner> list) throws org.junit.runners.model.InitializationError {
        super(cls);
        this.runners = java.util.Collections.unmodifiableList(list);
    }

    @Override // org.junit.runners.ParentRunner
    protected java.util.List<org.junit.runner.Runner> getChildren() {
        return this.runners;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.junit.runners.ParentRunner
    public org.junit.runner.Description describeChild(org.junit.runner.Runner runner) {
        return runner.getDescription();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.junit.runners.ParentRunner
    public void runChild(org.junit.runner.Runner runner, org.junit.runner.notification.RunNotifier runNotifier) {
        runner.run(runNotifier);
    }
}
