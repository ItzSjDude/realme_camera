package org.junit.internal.builders;

/* loaded from: classes2.dex */
public class IgnoredBuilder extends org.junit.runners.model.RunnerBuilder {
    @Override // org.junit.runners.model.RunnerBuilder
    public org.junit.runner.Runner runnerForClass(java.lang.Class<?> cls) {
        if (cls.getAnnotation(org.junit.Ignore.class) != null) {
            return new org.junit.internal.builders.IgnoredClassRunner(cls);
        }
        return null;
    }
}
