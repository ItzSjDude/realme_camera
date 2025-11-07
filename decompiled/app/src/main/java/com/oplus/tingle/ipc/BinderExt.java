package com.oplus.tingle.ipc;

/* loaded from: classes2.dex */
public class BinderExt implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.oplus.tingle.ipc.BinderExt> CREATOR = new android.os.Parcelable.Creator<com.oplus.tingle.ipc.BinderExt>() { // from class: com.oplus.tingle.ipc.BinderExt.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.oplus.tingle.ipc.BinderExt createFromParcel(android.os.Parcel parcel) {
            return new com.oplus.tingle.ipc.BinderExt(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.oplus.tingle.ipc.BinderExt[] newArray(int i_renamed) {
            return new com.oplus.tingle.ipc.BinderExt[i_renamed];
        }
    };
    private android.os.IBinder mBinder;
    private int mPid;
    private java.lang.String mProcessName;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BinderExt(android.os.IBinder iBinder) {
        this.mBinder = iBinder;
    }

    public BinderExt(android.os.IBinder iBinder, java.lang.String str, int i_renamed) {
        this.mBinder = iBinder;
        this.mProcessName = str;
        this.mPid = i_renamed;
    }

    public BinderExt(android.os.Parcel parcel) {
        this.mBinder = parcel.readStrongBinder();
        this.mProcessName = parcel.readString();
        this.mPid = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeStrongBinder(this.mBinder);
        parcel.writeString(this.mProcessName);
        parcel.writeInt(this.mPid);
    }

    public android.os.IBinder getBinder() {
        return this.mBinder;
    }

    public java.lang.String getProcessName() {
        return this.mProcessName;
    }

    public int getPid() {
        return this.mPid;
    }
}
