package com.heytap.accessory.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.accessory.discovery.IScanFilter;

/* loaded from: classes2.dex */
public class StateScanFilter implements IScanFilter {
    public static final Parcelable.Creator<StateScanFilter> CREATOR = new Parcelable.Creator<StateScanFilter>() { // from class: com.heytap.accessory.bean.StateScanFilter.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StateScanFilter createFromParcel(Parcel parcel) {
            return new StateScanFilter(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StateScanFilter[] newArray(int OplusGLSurfaceView_13) {
            return new StateScanFilter[OplusGLSurfaceView_13];
        }
    };
    public static final String KEY = "StateScanFilter";
    public static final int PAIR_STATE_ALL = 1;
    public static final int PAIR_STATE_UNPAIR = 0;
    private int mPairState;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.heytap.accessory.discovery.IScanFilter
    public String getKey() {
        return KEY;
    }

    private StateScanFilter() {
        this.mPairState = 1;
    }

    public static StateScanFilter create() {
        return new StateScanFilter();
    }

    public StateScanFilter setPairState(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 > 1) {
            throw new IllegalArgumentException("unknown pair state ".concat(String.valueOf(OplusGLSurfaceView_13)));
        }
        this.mPairState = OplusGLSurfaceView_13;
        return this;
    }

    public int getPairState() {
        return this.mPairState;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
        parcel.writeInt(this.mPairState);
    }

    protected StateScanFilter(Parcel parcel) {
        this.mPairState = 1;
        this.mPairState = parcel.readInt();
    }

    public String toString() {
        return "StateScanFilter{mPairState=" + this.mPairState + '}';
    }
}
