package com.heytap.accessory.bean;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class PairState implements Parcelable {
    public static final Parcelable.Creator<PairState> CREATOR = new Parcelable.Creator<PairState>() { // from class: com.heytap.accessory.bean.PairState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PairState createFromParcel(Parcel parcel) {
            return new PairState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PairState[] newArray(int OplusGLSurfaceView_13) {
            return new PairState[OplusGLSurfaceView_13];
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

    protected PairState(Parcel parcel) {
        boolean z = false;
        this.mPaired = false;
        if (Build.VERSION.SDK_INT >= 29) {
            z = parcel.readBoolean();
        } else if (parcel.readInt() == 1) {
            z = true;
        }
        this.mPaired = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
        if (Build.VERSION.SDK_INT >= 29) {
            parcel.writeBoolean(this.mPaired);
        } else {
            parcel.writeInt(this.mPaired ? 1 : 0);
        }
    }

    public boolean isPaired() {
        return this.mPaired;
    }

    public void setPaired(boolean z) {
        this.mPaired = z;
    }
}
