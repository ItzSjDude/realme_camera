package org.junit.internal.builders;

/* loaded from: classes2.dex */
public class NullBuilder extends org.junit.runners.model.RunnerBuilder {
    @Override // org.junit.runners.model.RunnerBuilder
    public org.junit.runner.Runner runnerForClass(java.lang.Class<?> cls) throws java.lang.Throwable {
        return null;
    }
}
