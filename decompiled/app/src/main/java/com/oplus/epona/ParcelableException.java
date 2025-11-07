package com.oplus.epona;

/* loaded from: classes2.dex */
final class ParcelableException extends java.lang.RuntimeException {
    private static final java.lang.String TAG = "ParcelableException";

    private ParcelableException(java.lang.Throwable th) {
        super(th);
    }

    static com.oplus.epona.ParcelableException create(com.oplus.epona.ExceptionInfo exceptionInfo) throws java.lang.ClassNotFoundException {
        java.lang.String name = exceptionInfo.getName();
        java.lang.String message = exceptionInfo.getMessage();
        try {
            java.lang.Class<?> cls = java.lang.Class.forName(name);
            if (java.lang.Throwable.class.isAssignableFrom(cls)) {
                return new com.oplus.epona.ParcelableException((java.lang.Throwable) cls.getConstructor(java.lang.String.class).newInstance(message));
            }
        } catch (java.lang.ReflectiveOperationException e_renamed) {
            com.oplus.epona.utils.Logger.e_renamed(TAG, e_renamed.toString(), new java.lang.Object[0]);
        }
        return new com.oplus.epona.ParcelableException(new java.lang.RuntimeException(name + ": " + message));
    }

    <T_renamed extends java.lang.Throwable> void maybeRethrow(java.lang.Class<T_renamed> cls) throws java.lang.Throwable {
        if (cls.isAssignableFrom(getCause().getClass())) {
            throw getCause();
        }
    }
}
