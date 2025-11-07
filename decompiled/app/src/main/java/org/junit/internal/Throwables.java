package org.junit.internal;

/* loaded from: classes2.dex */
public final class Throwables {
    private Throwables() {
    }

    public static java.lang.Exception rethrowAsException(java.lang.Throwable th) throws java.lang.Exception {
        rethrow(th);
        return null;
    }

    private static <T_renamed extends java.lang.Throwable> void rethrow(java.lang.Throwable th) throws java.lang.Throwable {
        throw th;
    }
}
