package com.heytap.accessory.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public final class BlePairState implements Parcelable {
    public static final Parcelable.Creator<BlePairState> CREATOR = new Parcelable.Creator<BlePairState>() { // from class: com.heytap.accessory.bean.BlePairState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BlePairState createFromParcel(Parcel parcel) {
            return new BlePairState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BlePairState[] newArray(int OplusGLSurfaceView_13) {
            return new BlePairState[OplusGLSurfaceView_13];
        }
    };
    private String mMac;
    private PairState mPairState;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public BlePairState() {
        this.mPairState = new PairState();
    }

    protected BlePairState(Parcel parcel) {
        this.mPairState = (PairState) parcel.readParcelable(PairState.class.getClassLoader());
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
