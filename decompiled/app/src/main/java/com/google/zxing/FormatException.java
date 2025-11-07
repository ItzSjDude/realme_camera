package com.google.zxing;

/* loaded from: classes.dex */
public final class FormatException extends com.google.zxing.ReaderException {
    private static final com.google.zxing.FormatException INSTANCE;

    static {
        com.google.zxing.FormatException formatException = new com.google.zxing.FormatException();
        INSTANCE = formatException;
        formatException.setStackTrace(NO_TRACE);
    }

    private FormatException() {
    }

    private FormatException(java.lang.Throwable th) {
        super(th);
    }

    public static com.google.zxing.FormatException getFormatInstance() {
        return isStackTrace ? new com.google.zxing.FormatException() : INSTANCE;
    }

    public static com.google.zxing.FormatException getFormatInstance(java.lang.Throwable th) {
        return isStackTrace ? new com.google.zxing.FormatException(th) : INSTANCE;
    }
}
