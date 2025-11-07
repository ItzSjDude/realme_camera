package org.junit.internal.runners.model;

/* loaded from: classes2.dex */
public abstract class ReflectiveCallable {
    protected abstract java.lang.Object runReflectiveCall() throws java.lang.Throwable;

    public java.lang.Object run() throws java.lang.Throwable {
        try {
            return runReflectiveCall();
        } catch (java.lang.reflect.InvocationTargetException e_renamed) {
            throw e_renamed.getTargetException();
        }
    }
}
