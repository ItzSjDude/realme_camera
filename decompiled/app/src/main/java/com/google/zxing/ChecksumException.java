package com.google.zxing;

/* loaded from: classes.dex */
public final class ChecksumException extends com.google.zxing.ReaderException {
    private static final com.google.zxing.ChecksumException INSTANCE;

    static {
        com.google.zxing.ChecksumException checksumException = new com.google.zxing.ChecksumException();
        INSTANCE = checksumException;
        checksumException.setStackTrace(NO_TRACE);
    }

    private ChecksumException() {
    }

    private ChecksumException(java.lang.Throwable th) {
        super(th);
    }

    public static com.google.zxing.ChecksumException getChecksumInstance() {
        return isStackTrace ? new com.google.zxing.ChecksumException() : INSTANCE;
    }

    public static com.google.zxing.ChecksumException getChecksumInstance(java.lang.Throwable th) {
        return isStackTrace ? new com.google.zxing.ChecksumException(th) : INSTANCE;
    }
}
