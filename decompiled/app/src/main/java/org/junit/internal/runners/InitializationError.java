package org.junit.internal.runners;

@java.lang.Deprecated
/* loaded from: classes2.dex */
public class InitializationError extends java.lang.Exception {
    private static final long serialVersionUID = 1;
    private final java.util.List<java.lang.Throwable> fErrors;

    public InitializationError(java.util.List<java.lang.Throwable> list) {
        this.fErrors = list;
    }

    public InitializationError(java.lang.Throwable... thArr) {
        this((java.util.List<java.lang.Throwable>) java.util.Arrays.asList(thArr));
    }

    public InitializationError(java.lang.String str) {
        this(new java.lang.Exception(str));
    }

    public java.util.List<java.lang.Throwable> getCauses() {
        return this.fErrors;
    }
}
