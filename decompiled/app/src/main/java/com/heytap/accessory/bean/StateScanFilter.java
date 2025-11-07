package com.heytap.accessory.bean;

/* loaded from: classes2.dex */
public class StateScanFilter implements com.heytap.accessory.discovery.IScanFilter {
    public static final android.os.Parcelable.Creator<com.heytap.accessory.bean.StateScanFilter> CREATOR = new android.os.Parcelable.Creator<com.heytap.accessory.bean.StateScanFilter>() { // from class: com.heytap.accessory.bean.StateScanFilter.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.heytap.accessory.bean.StateScanFilter createFromParcel(android.os.Parcel parcel) {
            return new com.heytap.accessory.bean.StateScanFilter(parcel);
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.heytap.accessory.bean.StateScanFilter[] newArray(int i_renamed) {
            return new com.heytap.accessory.bean.StateScanFilter[i_renamed];
        }
    };
    public static final java.lang.String KEY = "StateScanFilter";
    public static final int PAIR_STATE_ALL = 1;
    public static final int PAIR_STATE_UNPAIR = 0;
    private int mPairState;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.heytap.accessory.discovery.IScanFilter
    public java.lang.String getKey() {
        return KEY;
    }

    private StateScanFilter() {
        this.mPairState = 1;
    }

    public static com.heytap.accessory.bean.StateScanFilter create() {
        return new com.heytap.accessory.bean.StateScanFilter();
    }

    public com.heytap.accessory.bean.StateScanFilter setPairState(int i_renamed) {
        if (i_renamed < 0 || i_renamed > 1) {
            throw new java.lang.IllegalArgumentException("unknown pair state ".concat(java.lang.String.valueOf(i_renamed)));
        }
        this.mPairState = i_renamed;
        return this;
    }

    public int getPairState() {
        return this.mPairState;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeInt(this.mPairState);
    }

    protected StateScanFilter(android.os.Parcel parcel) {
        this.mPairState = 1;
        this.mPairState = parcel.readInt();
    }

    public java.lang.String toString() {
        return "StateScanFilter{mPairState=" + this.mPairState + '}';
    }
}
