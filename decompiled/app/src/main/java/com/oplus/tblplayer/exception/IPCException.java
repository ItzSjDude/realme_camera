package com.oplus.tblplayer.exception;

/* loaded from: classes2.dex */
public class IPCException extends java.lang.RuntimeException implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.oplus.tblplayer.exception.IPCException> CREATOR = new android.os.Parcelable.Creator<com.oplus.tblplayer.exception.IPCException>() { // from class: com.oplus.tblplayer.exception.IPCException.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.oplus.tblplayer.exception.IPCException createFromParcel(android.os.Parcel parcel) {
            return new com.oplus.tblplayer.exception.IPCException(parcel);
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.oplus.tblplayer.exception.IPCException[] newArray(int i_renamed) {
            return new com.oplus.tblplayer.exception.IPCException[i_renamed];
        }
    };
    private static final int HAS_CAUSE = 1;
    private static final int NO_CAUSE = 0;
    private final java.lang.String mClassName;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public IPCException(java.lang.String str, java.lang.String str2) {
        super(str2);
        this.mClassName = str;
    }

    public java.lang.String getClassName() {
        return this.mClassName;
    }

    public static com.oplus.tblplayer.exception.IPCException toIPCException(java.lang.Throwable th) {
        if (th == null) {
            return null;
        }
        if (th instanceof com.oplus.tblplayer.exception.IPCException) {
            return (com.oplus.tblplayer.exception.IPCException) th;
        }
        java.lang.String name = th.getClass().getName();
        java.lang.StackTraceElement[] stackTrace = th.getStackTrace();
        com.oplus.tblplayer.exception.IPCException iPCException = new com.oplus.tblplayer.exception.IPCException(name, th.getMessage());
        iPCException.setStackTrace(stackTrace);
        iPCException.initCause(toIPCException(th.getCause()));
        return iPCException;
    }

    public java.io.IOException toIOException() {
        java.io.IOException iOException = new java.io.IOException("(" + this.mClassName + ")" + getMessage());
        iOException.initCause(getCause());
        iOException.setStackTrace(getStackTrace());
        return iOException;
    }

    public IPCException(android.os.Parcel parcel) {
        this(parcel.readString(), parcel.readString());
        int i_renamed = parcel.readInt();
        java.lang.StackTraceElement[] stackTraceElementArr = new java.lang.StackTraceElement[i_renamed];
        for (int i2 = 0; i2 < i_renamed; i2++) {
            stackTraceElementArr[i2] = new java.lang.StackTraceElement(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt());
        }
        setStackTrace(stackTraceElementArr);
        if (parcel.readInt() != 0) {
            initCause(new com.oplus.tblplayer.exception.IPCException(parcel));
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeString(this.mClassName);
        parcel.writeString(getMessage());
        java.lang.StackTraceElement[] stackTrace = getStackTrace();
        if (stackTrace == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(stackTrace.length);
            for (java.lang.StackTraceElement stackTraceElement : stackTrace) {
                parcel.writeString(stackTraceElement.getClassName());
                parcel.writeString(stackTraceElement.getMethodName());
                parcel.writeString(stackTraceElement.getFileName());
                parcel.writeInt(stackTraceElement.getLineNumber());
            }
        }
        java.lang.Throwable cause = getCause();
        if (cause instanceof com.oplus.tblplayer.exception.IPCException) {
            parcel.writeInt(1);
            ((com.oplus.tblplayer.exception.IPCException) cause).writeToParcel(parcel, i_renamed);
        } else {
            parcel.writeInt(0);
        }
    }
}
