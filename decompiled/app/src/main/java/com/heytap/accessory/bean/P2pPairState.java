package com.heytap.accessory.bean;

/* loaded from: classes2.dex */
public class P2pPairState implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.heytap.accessory.bean.P2pPairState> CREATOR = new android.os.Parcelable.Creator<com.heytap.accessory.bean.P2pPairState>() { // from class: com.heytap.accessory.bean.P2pPairState.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.heytap.accessory.bean.P2pPairState createFromParcel(android.os.Parcel parcel) {
            return new com.heytap.accessory.bean.P2pPairState(parcel);
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.heytap.accessory.bean.P2pPairState[] newArray(int i_renamed) {
            return new com.heytap.accessory.bean.P2pPairState[i_renamed];
        }
    };
    private java.lang.String mIp;
    private java.lang.String mP2pMac;
    private com.heytap.accessory.bean.PairState mPairState;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public P2pPairState() {
        this.mPairState = new com.heytap.accessory.bean.PairState();
    }

    protected P2pPairState(android.os.Parcel parcel) {
        this.mPairState = (com.heytap.accessory.bean.PairState) parcel.readParcelable(com.heytap.accessory.bean.PairState.class.getClassLoader());
        this.mIp = parcel.readString();
        this.mP2pMac = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeParcelable(this.mPairState, i_renamed);
        parcel.writeString(this.mIp);
        parcel.writeString(this.mP2pMac);
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

    public java.lang.String getP2pMac() {
        return this.mP2pMac;
    }

    public void setP2pMac(java.lang.String str) {
        this.mP2pMac = str;
    }
}
