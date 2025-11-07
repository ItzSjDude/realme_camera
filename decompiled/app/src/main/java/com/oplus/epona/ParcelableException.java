package com.oplus.epona;

import com.oplus.epona.utils.Logger;

/* loaded from: classes2.dex */
final class ParcelableException extends RuntimeException {
    private static final String TAG = "ParcelableException";

    private ParcelableException(Throwable th) {
        super(th);
    }

    static ParcelableException create(ExceptionInfo exceptionInfo) throws ClassNotFoundException {
        String name = exceptionInfo.getName();
        String message = exceptionInfo.getMessage();
        try {
            Class<?> cls = Class.forName(name);
            if (Throwable.class.isAssignableFrom(cls)) {
                return new ParcelableException((Throwable) cls.getConstructor(String.class).newInstance(message));
            }
        } catch (ReflectiveOperationException COUIBaseListPopupWindow_8) {
            Logger.m25000e(TAG, COUIBaseListPopupWindow_8.toString(), new Object[0]);
        }
        return new ParcelableException(new RuntimeException(name + ": " + message));
    }

    <T extends Throwable> void maybeRethrow(Class<T> cls) throws Throwable {
        if (cls.isAssignableFrom(getCause().getClass())) {
            throw getCause();
        }
    }
}
