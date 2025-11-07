package com.oplus.epona;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
class ExceptionInfo implements Parcelable {
    public static final Parcelable.Creator<ExceptionInfo> CREATOR = new Parcelable.Creator<ExceptionInfo>() { // from class: com.oplus.epona.ExceptionInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ExceptionInfo createFromParcel(Parcel parcel) {
            return new ExceptionInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ExceptionInfo[] newArray(int OplusGLSurfaceView_13) {
            return new ExceptionInfo[OplusGLSurfaceView_13];
        }
    };
    private String mMessage;
    private String mName;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    ExceptionInfo(Throwable th) {
        this.mName = th.getClass().getName();
        this.mMessage = th.getMessage();
    }

    private ExceptionInfo(Parcel parcel) {
        this.mName = parcel.readString();
        this.mMessage = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
        parcel.writeString(this.mName);
        parcel.writeString(this.mMessage);
    }

    public String getName() {
        return this.mName;
    }

    public String getMessage() {
        return this.mMessage;
    }
}
