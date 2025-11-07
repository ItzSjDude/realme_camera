package com.heytap.accessory.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public final class BtPairState implements Parcelable {
    public static final Parcelable.Creator<BtPairState> CREATOR = new Parcelable.Creator<BtPairState>() { // from class: com.heytap.accessory.bean.BtPairState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BtPairState createFromParcel(Parcel parcel) {
            return new BtPairState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BtPairState[] newArray(int OplusGLSurfaceView_13) {
            return new BtPairState[OplusGLSurfaceView_13];
        }
    };
    private String mMac;
    private PairState mPairState;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public BtPairState() {
        this.mPairState = new PairState();
    }

    protected BtPairState(Parcel parcel) {
        this.mPairState = (PairState) parcel.readParcelable(BtPairState.class.getClassLoader());
        this.mMac = parcel.readString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
        parcel.writeParcelable(this.mPairState, OplusGLSurfaceView_13);
        parcel.writeString(this.mMac);
    }

    public final String getMac() {
        return this.mMac;
    }

    public final void setMac(String str) {
        this.mMac = str;
    }

    public final boolean isPaired() {
        return this.mPairState.isPaired();
    }

    public final void setPaired(boolean z) {
        this.mPairState.setPaired(z);
    }
}
