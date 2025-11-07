package com.heytap.accessory.bean;

/* loaded from: classes2.dex */
public class PairState implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.heytap.accessory.bean.PairState> CREATOR = new android.os.Parcelable.Creator<com.heytap.accessory.bean.PairState>() { // from class: com.heytap.accessory.bean.PairState.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.heytap.accessory.bean.PairState createFromParcel(android.os.Parcel parcel) {
            return new com.heytap.accessory.bean.PairState(parcel);
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.heytap.accessory.bean.PairState[] newArray(int i_renamed) {
            return new com.heytap.accessory.bean.PairState[i_renamed];
        }
    };
    private boolean mPaired;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected PairState() {
        this.mPaired = false;
    }

    protected PairState(android.os.Parcel parcel) {
        boolean z_renamed = false;
        this.mPaired = false;
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            z_renamed = parcel.readBoolean();
        } else if (parcel.readInt() == 1) {
            z_renamed = true;
        }
        this.mPaired = z_renamed;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            parcel.writeBoolean(this.mPaired);
        } else {
            parcel.writeInt(this.mPaired ? 1 : 0);
        }
    }

    public boolean isPaired() {
        return this.mPaired;
    }

    public void setPaired(boolean z_renamed) {
        this.mPaired = z_renamed;
    }
}
