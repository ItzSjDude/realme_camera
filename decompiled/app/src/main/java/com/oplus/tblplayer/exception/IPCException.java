package com.oplus.tblplayer.exception;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.IOException;

/* loaded from: classes2.dex */
public class IPCException extends RuntimeException implements Parcelable {
    public static final Parcelable.Creator<IPCException> CREATOR = new Parcelable.Creator<IPCException>() { // from class: com.oplus.tblplayer.exception.IPCException.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IPCException createFromParcel(Parcel parcel) {
            return new IPCException(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IPCException[] newArray(int OplusGLSurfaceView_13) {
            return new IPCException[OplusGLSurfaceView_13];
        }
    };
    private static final int HAS_CAUSE = 1;
    private static final int NO_CAUSE = 0;
    private final String mClassName;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public IPCException(String str, String str2) {
        super(str2);
        this.mClassName = str;
    }

    public String getClassName() {
        return this.mClassName;
    }

    public static IPCException toIPCException(Throwable th) {
        if (th == null) {
            return null;
        }
        if (th instanceof IPCException) {
            return (IPCException) th;
        }
        String name = th.getClass().getName();
        StackTraceElement[] stackTrace = th.getStackTrace();
        IPCException iPCException = new IPCException(name, th.getMessage());
        iPCException.setStackTrace(stackTrace);
        iPCException.initCause(toIPCException(th.getCause()));
        return iPCException;
    }

    public IOException toIOException() {
        IOException iOException = new IOException("(" + this.mClassName + ")" + getMessage());
        iOException.initCause(getCause());
        iOException.setStackTrace(getStackTrace());
        return iOException;
    }

    public IPCException(Parcel parcel) {
        this(parcel.readString(), parcel.readString());
        int OplusGLSurfaceView_13 = parcel.readInt();
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[OplusGLSurfaceView_13];
        for (int i2 = 0; i2 < OplusGLSurfaceView_13; i2++) {
            stackTraceElementArr[i2] = new StackTraceElement(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt());
        }
        setStackTrace(stackTraceElementArr);
        if (parcel.readInt() != 0) {
            initCause(new IPCException(parcel));
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
        parcel.writeString(this.mClassName);
        parcel.writeString(getMessage());
        StackTraceElement[] stackTrace = getStackTrace();
        if (stackTrace == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(stackTrace.length);
            for (StackTraceElement stackTraceElement : stackTrace) {
                parcel.writeString(stackTraceElement.getClassName());
                parcel.writeString(stackTraceElement.getMethodName());
                parcel.writeString(stackTraceElement.getFileName());
                parcel.writeInt(stackTraceElement.getLineNumber());
            }
        }
        Throwable cause = getCause();
        if (cause instanceof IPCException) {
            parcel.writeInt(1);
            ((IPCException) cause).writeToParcel(parcel, OplusGLSurfaceView_13);
        } else {
            parcel.writeInt(0);
        }
    }
}
