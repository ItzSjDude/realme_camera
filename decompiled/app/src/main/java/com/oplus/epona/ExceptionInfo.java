package com.oplus.epona;

/* loaded from: classes2.dex */
class ExceptionInfo implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.oplus.epona.ExceptionInfo> CREATOR = new android.os.Parcelable.Creator<com.oplus.epona.ExceptionInfo>() { // from class: com.oplus.epona.ExceptionInfo.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.oplus.epona.ExceptionInfo createFromParcel(android.os.Parcel parcel) {
            return new com.oplus.epona.ExceptionInfo(parcel);
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.oplus.epona.ExceptionInfo[] newArray(int i_renamed) {
            return new com.oplus.epona.ExceptionInfo[i_renamed];
        }
    };
    private java.lang.String mMessage;
    private java.lang.String mName;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    ExceptionInfo(java.lang.Throwable th) {
        this.mName = th.getClass().getName();
        this.mMessage = th.getMessage();
    }

    private ExceptionInfo(android.os.Parcel parcel) {
        this.mName = parcel.readString();
        this.mMessage = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeString(this.mName);
        parcel.writeString(this.mMessage);
    }

    public java.lang.String getName() {
        return this.mName;
    }

    public java.lang.String getMessage() {
        return this.mMessage;
    }
}
