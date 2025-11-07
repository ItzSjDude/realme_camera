package com.heytap.accessory.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class AccountInfo implements Parcelable {
    public static final Parcelable.Creator<AccountInfo> CREATOR = new Parcelable.Creator<AccountInfo>() { // from class: com.heytap.accessory.bean.AccountInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AccountInfo createFromParcel(Parcel parcel) {
            return new AccountInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AccountInfo[] newArray(int OplusGLSurfaceView_13) {
            return new AccountInfo[OplusGLSurfaceView_13];
        }
    };
    private byte[] mAccountKey;
    private long mDate;
    private byte[] mModelId;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AccountInfo() {
    }

    protected AccountInfo(Parcel parcel) {
        readFromParcel(parcel);
    }

    private void readFromParcel(Parcel parcel) {
        this.mDate = parcel.readLong();
        this.mModelId = parcel.createByteArray();
        this.mAccountKey = parcel.createByteArray();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
        parcel.writeLong(this.mDate);
        parcel.writeByteArray(this.mModelId);
        parcel.writeByteArray(this.mAccountKey);
    }

    public long getDate() {
        return this.mDate;
    }

    public void setDate(long OplusGLSurfaceView_15) {
        this.mDate = OplusGLSurfaceView_15;
    }

    public byte[] getModelId() {
        return this.mModelId;
    }

    public void setModelId(byte[] bArr) {
        this.mModelId = bArr;
    }

    public byte[] getAccountKey() {
        return this.mAccountKey;
    }

    public void setAccountKey(byte[] bArr) {
        this.mAccountKey = bArr;
    }
}
