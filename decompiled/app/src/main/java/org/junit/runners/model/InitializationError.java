package org.junit.runners.model;

/* loaded from: classes2.dex */
public class InitializationError extends java.lang.Exception {
    private static final long serialVersionUID = 1;
    private final java.util.List<java.lang.Throwable> fErrors;

    public InitializationError(java.util.List<java.lang.Throwable> list) {
        this.fErrors = list;
    }

    public InitializationError(java.lang.Throwable th) {
        this((java.util.List<java.lang.Throwable>) java.util.Arrays.asList(th));
    }

    public InitializationError(java.lang.String str) {
        this(new java.lang.Exception(str));
    }

    public java.util.List<java.lang.Throwable> getCauses() {
        return this.fErrors;
    }
}
