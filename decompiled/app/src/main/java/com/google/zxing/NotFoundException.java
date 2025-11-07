package com.google.zxing;

/* loaded from: classes.dex */
public final class NotFoundException extends com.google.zxing.ReaderException {
    private static final com.google.zxing.NotFoundException INSTANCE;

    static {
        com.google.zxing.NotFoundException notFoundException = new com.google.zxing.NotFoundException();
        INSTANCE = notFoundException;
        notFoundException.setStackTrace(NO_TRACE);
    }

    private NotFoundException() {
    }

    public static com.google.zxing.NotFoundException getNotFoundInstance() {
        return INSTANCE;
    }
}
