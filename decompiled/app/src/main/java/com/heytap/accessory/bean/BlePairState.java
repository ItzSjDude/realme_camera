package com.heytap.accessory.bean;

/* loaded from: classes2.dex */
public final class BlePairState implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.heytap.accessory.bean.BlePairState> CREATOR = new android.os.Parcelable.Creator<com.heytap.accessory.bean.BlePairState>() { // from class: com.heytap.accessory.bean.BlePairState.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.heytap.accessory.bean.BlePairState createFromParcel(android.os.Parcel parcel) {
            return new com.heytap.accessory.bean.BlePairState(parcel);
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.heytap.accessory.bean.BlePairState[] newArray(int i_renamed) {
            return new com.heytap.accessory.bean.BlePairState[i_renamed];
        }
    };
    private java.lang.String mMac;
    private com.heytap.accessory.bean.PairState mPairState;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public BlePairState() {
        this.mPairState = new com.heytap.accessory.bean.PairState();
    }

    protected BlePairState(android.os.Parcel parcel) {
        this.mPairState = (com.heytap.accessory.bean.PairState) parcel.readParcelable(com.heytap.accessory.bean.PairState.class.getClassLoader());
        this.mMac = parcel.readString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeParcelable(this.mPairState, i_renamed);
        parcel.writeString(this.mMac);
    }

    public final java.lang.String getMac() {
        return this.mMac;
    }

    public final void setMac(java.lang.String str) {
        this.mMac = str;
    }

    public final boolean isPaired() {
        return this.mPairState.isPaired();
    }

    public final void setPaired(boolean z_renamed) {
        this.mPairState.setPaired(z_renamed);
    }
}
