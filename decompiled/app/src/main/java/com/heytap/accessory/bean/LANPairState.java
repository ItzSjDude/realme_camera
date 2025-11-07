package com.heytap.accessory.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class LANPairState implements Parcelable {
    public static final Parcelable.Creator<LANPairState> CREATOR = new Parcelable.Creator<LANPairState>() { // from class: com.heytap.accessory.bean.LANPairState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LANPairState createFromParcel(Parcel parcel) {
            return new LANPairState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LANPairState[] newArray(int OplusGLSurfaceView_13) {
            return new LANPairState[OplusGLSurfaceView_13];
        }
    };
    private String mIp;
    private PairState mPairState;
    private List<String> mPairedBssidList;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LANPairState() {
        this.mPairState = new PairState();
        this.mPairedBssidList = new ArrayList();
    }

    protected LANPairState(Parcel parcel) {
        this.mPairState = (PairState) parcel.readParcelable(PairState.class.getClassLoader());
        this.mIp = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
        parcel.writeParcelable(this.mPairState, OplusGLSurfaceView_13);
        parcel.writeString(this.mIp);
    }

    public String getIp() {
        return this.mIp;
    }

    public void setIp(String str) {
        this.mIp = str;
    }

    public boolean isPaired() {
        return this.mPairState.isPaired();
    }

    public void setPaired(boolean z) {
        this.mPairState.setPaired(z);
    }

    public void addPairedBssid(String str) {
        if (this.mPairedBssidList.contains(str)) {
            return;
        }
        this.mPairedBssidList.add(str);
    }

    public List<String> getPairedBssidList() {
        return this.mPairedBssidList;
    }
}
