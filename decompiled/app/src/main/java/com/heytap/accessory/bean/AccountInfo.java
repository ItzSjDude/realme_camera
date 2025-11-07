package com.heytap.accessory.bean;

/* loaded from: classes2.dex */
public class AccountInfo implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.heytap.accessory.bean.AccountInfo> CREATOR = new android.os.Parcelable.Creator<com.heytap.accessory.bean.AccountInfo>() { // from class: com.heytap.accessory.bean.AccountInfo.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.heytap.accessory.bean.AccountInfo createFromParcel(android.os.Parcel parcel) {
            return new com.heytap.accessory.bean.AccountInfo(parcel);
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.heytap.accessory.bean.AccountInfo[] newArray(int i_renamed) {
            return new com.heytap.accessory.bean.AccountInfo[i_renamed];
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

    protected AccountInfo(android.os.Parcel parcel) {
        readFromParcel(parcel);
    }

    private void readFromParcel(android.os.Parcel parcel) {
        this.mDate = parcel.readLong();
        this.mModelId = parcel.createByteArray();
        this.mAccountKey = parcel.createByteArray();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeLong(this.mDate);
        parcel.writeByteArray(this.mModelId);
        parcel.writeByteArray(this.mAccountKey);
    }

    public long getDate() {
        return this.mDate;
    }

    public void setDate(long j_renamed) {
        this.mDate = j_renamed;
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
