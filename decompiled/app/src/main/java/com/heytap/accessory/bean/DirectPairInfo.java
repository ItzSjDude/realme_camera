package com.heytap.accessory.bean;

/* loaded from: classes2.dex */
public class DirectPairInfo implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.heytap.accessory.bean.DirectPairInfo> CREATOR = new android.os.Parcelable.Creator<com.heytap.accessory.bean.DirectPairInfo>() { // from class: com.heytap.accessory.bean.DirectPairInfo.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.heytap.accessory.bean.DirectPairInfo createFromParcel(android.os.Parcel parcel) {
            return new com.heytap.accessory.bean.DirectPairInfo(parcel);
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.heytap.accessory.bean.DirectPairInfo[] newArray(int i_renamed) {
            return new com.heytap.accessory.bean.DirectPairInfo[i_renamed];
        }
    };
    private static final java.lang.String INTENT_EXTRA_MODELID = "extra_modelid";
    private static final java.lang.String INTENT_EXTRA_SSID = "extra_ssid";
    private android.os.Bundle mBundle;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void setSsid(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException("ssid is_renamed invalid");
        }
        this.mBundle.putString("extra_ssid", str);
    }

    public java.lang.String getSsid() {
        return this.mBundle.getString("extra_ssid");
    }

    public void setModelId(byte[] bArr) {
        this.mBundle.putByteArray(INTENT_EXTRA_MODELID, bArr);
    }

    public byte[] getModelId() {
        return this.mBundle.getByteArray(INTENT_EXTRA_MODELID);
    }

    public DirectPairInfo() {
        this.mBundle = new android.os.Bundle();
    }

    protected DirectPairInfo(android.os.Parcel parcel) {
        this.mBundle = parcel.readBundle();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeBundle(this.mBundle);
    }

    public java.lang.String toString() {
        return "DirectPairInfo{ssname=" + this.mBundle.getString("extra_ssid") + '}';
    }
}
