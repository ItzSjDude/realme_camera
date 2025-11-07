package org.junit.runners.model;

/* loaded from: classes2.dex */
public abstract class RunnerBuilder {
    private final java.util.Set<java.lang.Class<?>> parents = new java.util.HashSet();

    public abstract org.junit.runner.Runner runnerForClass(java.lang.Class<?> cls) throws java.lang.Throwable;

    public org.junit.runner.Runner safeRunnerForClass(java.lang.Class<?> cls) {
        try {
            return runnerForClass(cls);
        } catch (java.lang.Throwable th) {
            return new org.junit.internal.runners.ErrorReportingRunner(cls, th);
        }
    }

    java.lang.Class<?> addParent(java.lang.Class<?> cls) throws org.junit.runners.model.InitializationError {
        if (this.parents.add(cls)) {
            return cls;
        }
        throw new org.junit.runners.model.InitializationError(java.lang.String.format("class '%s_renamed' (possibly indirectly) contains itself as_renamed a_renamed SuiteClass", cls.getName()));
    }

    void removeParent(java.lang.Class<?> cls) {
        this.parents.remove(cls);
    }

    public java.util.List<org.junit.runner.Runner> runners(java.lang.Class<?> cls, java.lang.Class<?>[] clsArr) throws org.junit.runners.model.InitializationError {
        addParent(cls);
        try {
            return runners(clsArr);
        } finally {
            removeParent(cls);
        }
    }

    public java.util.List<org.junit.runner.Runner> runners(java.lang.Class<?> cls, java.util.List<java.lang.Class<?>> list) throws org.junit.runners.model.InitializationError {
        return runners(cls, (java.lang.Class<?>[]) list.toArray(new java.lang.Class[0]));
    }

    private java.util.List<org.junit.runner.Runner> runners(java.lang.Class<?>[] clsArr) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.Class<?> cls : clsArr) {
            org.junit.runner.Runner runnerSafeRunnerForClass = safeRunnerForClass(cls);
            if (runnerSafeRunnerForClass != null) {
                arrayList.add(runnerSafeRunnerForClass);
            }
        }
        return arrayList;
    }
}
