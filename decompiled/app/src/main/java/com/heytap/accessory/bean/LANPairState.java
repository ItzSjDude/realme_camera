package com.heytap.accessory.bean;

/* loaded from: classes2.dex */
public class LANPairState implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.heytap.accessory.bean.LANPairState> CREATOR = new android.os.Parcelable.Creator<com.heytap.accessory.bean.LANPairState>() { // from class: com.heytap.accessory.bean.LANPairState.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.heytap.accessory.bean.LANPairState createFromParcel(android.os.Parcel parcel) {
            return new com.heytap.accessory.bean.LANPairState(parcel);
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.heytap.accessory.bean.LANPairState[] newArray(int i_renamed) {
            return new com.heytap.accessory.bean.LANPairState[i_renamed];
        }
    };
    private java.lang.String mIp;
    private com.heytap.accessory.bean.PairState mPairState;
    private java.util.List<java.lang.String> mPairedBssidList;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LANPairState() {
        this.mPairState = new com.heytap.accessory.bean.PairState();
        this.mPairedBssidList = new java.util.ArrayList();
    }

    protected LANPairState(android.os.Parcel parcel) {
        this.mPairState = (com.heytap.accessory.bean.PairState) parcel.readParcelable(com.heytap.accessory.bean.PairState.class.getClassLoader());
        this.mIp = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeParcelable(this.mPairState, i_renamed);
        parcel.writeString(this.mIp);
    }

    public java.lang.String getIp() {
        return this.mIp;
    }

    public void setIp(java.lang.String str) {
        this.mIp = str;
    }

    public boolean isPaired() {
        return this.mPairState.isPaired();
    }

    public void setPaired(boolean z_renamed) {
        this.mPairState.setPaired(z_renamed);
    }

    public void addPairedBssid(java.lang.String str) {
        if (this.mPairedBssidList.contains(str)) {
            return;
        }
        this.mPairedBssidList.add(str);
    }

    public java.util.List<java.lang.String> getPairedBssidList() {
        return this.mPairedBssidList;
    }
}
