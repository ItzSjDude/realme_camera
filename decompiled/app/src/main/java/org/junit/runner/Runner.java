package org.junit.runner;

/* loaded from: classes2.dex */
public abstract class Runner implements org.junit.runner.Describable {
    @Override // org.junit.runner.Describable
    public abstract org.junit.runner.Description getDescription();

    public abstract void run(org.junit.runner.notification.RunNotifier runNotifier);

    public int testCount() {
        return getDescription().testCount();
    }
}
