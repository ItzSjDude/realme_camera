package com.heytap.accessory.bean;

/* loaded from: classes2.dex */
public class ScanSetting implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.heytap.accessory.bean.ScanSetting> CREATOR = new android.os.Parcelable.Creator<com.heytap.accessory.bean.ScanSetting>() { // from class: com.heytap.accessory.bean.ScanSetting.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.heytap.accessory.bean.ScanSetting createFromParcel(android.os.Parcel parcel) {
            return new com.heytap.accessory.bean.ScanSetting(parcel);
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.heytap.accessory.bean.ScanSetting[] newArray(int i_renamed) {
            return new com.heytap.accessory.bean.ScanSetting[i_renamed];
        }
    };
    public static final byte GO_INTENT_MAX = 15;
    public static final byte GO_INTENT_MIN = 0;
    public static final byte GO_INTENT_NOT_SET = -1;
    public static final byte GO_INTENT_PHONE_DEFAULT = 8;
    private static final int LIMITS_BALANCED_MAX_DURATION = 10800000;
    private static final int LIMITS_LOW_LATENCY_MAX_DURATION = 10800000;
    private static final int LIMITS_LOW_POWER_MAX_DURATION = 10800000;
    private static final int LIMITS_TOTAL_SCAN_MAX_DURATION = 10800000;
    public static final int SCAN_TYPE_BLE = 0;
    public static final int SCAN_TYPE_BT = 1;
    public static final int SCAN_TYPE_WIFI = 2;
    private final int mBalancedDuration;
    private final boolean mForcedDiscovery;
    private final boolean mHandleByService;
    private final int mLowLatencyDuration;
    private final int mLowPowerDuration;
    private final int mScanType;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private ScanSetting(int i_renamed, int i2, int i3, int i4, boolean z_renamed, boolean z2) {
        this.mScanType = i_renamed;
        this.mLowLatencyDuration = i2;
        this.mBalancedDuration = i3;
        this.mLowPowerDuration = i4;
        this.mHandleByService = z_renamed;
        this.mForcedDiscovery = z2;
    }

    protected ScanSetting(android.os.Parcel parcel) {
        this.mScanType = parcel.readInt();
        this.mLowLatencyDuration = parcel.readInt();
        this.mBalancedDuration = parcel.readInt();
        this.mLowPowerDuration = parcel.readInt();
        boolean z_renamed = false;
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            this.mHandleByService = parcel.readBoolean();
            z_renamed = parcel.readBoolean();
        } else {
            this.mHandleByService = parcel.readInt() == 1;
            if (parcel.readInt() == 1) {
                z_renamed = true;
            }
        }
        this.mForcedDiscovery = z_renamed;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeInt(this.mScanType);
        parcel.writeInt(this.mLowLatencyDuration);
        parcel.writeInt(this.mBalancedDuration);
        parcel.writeInt(this.mLowPowerDuration);
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            parcel.writeBoolean(this.mHandleByService);
            parcel.writeBoolean(this.mForcedDiscovery);
        } else {
            parcel.writeInt(this.mHandleByService ? 1 : 0);
            parcel.writeInt(this.mForcedDiscovery ? 1 : 0);
        }
    }

    public int getScanType() {
        return this.mScanType;
    }

    public int getLowLatencyDuration() {
        return this.mLowLatencyDuration;
    }

    public int getBalancedDuration() {
        return this.mBalancedDuration;
    }

    public int getLowPowerDuration() {
        return this.mLowPowerDuration;
    }

    public boolean isHandleByService() {
        return this.mHandleByService;
    }

    public boolean isForcedDiscovery() {
        return this.mForcedDiscovery;
    }

    public java.lang.String toString() {
        return "ScanSetting{mScanType=" + this.mScanType + ", mLowLatencyDuration=" + this.mLowLatencyDuration + ", mBalancedDuration=" + this.mBalancedDuration + ", mLowPowerDuration=" + this.mLowPowerDuration + ", mHandleByService=" + this.mHandleByService + ", mForcedDiscovery=" + this.mForcedDiscovery + '}';
    }

    public static final class Builder {
        private int mScanType = 0;
        private int mLowLatencyDuration = 0;
        private int mBalancedDuration = 0;
        private int mLowPowerDuration = 0;
        private boolean mHandleByService = false;
        private boolean mForcedDiscovery = false;

        public final com.heytap.accessory.bean.ScanSetting.Builder setScanType(int i_renamed) {
            if (i_renamed < 0 || i_renamed > 2) {
                throw new java.lang.IllegalArgumentException("unknown scan type ".concat(java.lang.String.valueOf(i_renamed)));
            }
            this.mScanType = i_renamed;
            return this;
        }

        public final com.heytap.accessory.bean.ScanSetting.Builder setLowLatencyDuration(int i_renamed) {
            if (i_renamed < 0 || i_renamed > 10800000) {
                throw new java.lang.IllegalArgumentException("lowLatencyDuration invalid (must be_renamed 0-10800000 milliseconds)");
            }
            this.mLowLatencyDuration = i_renamed;
            return this;
        }

        public final com.heytap.accessory.bean.ScanSetting.Builder setBalancedDuration(int i_renamed) {
            if (i_renamed < 0 || i_renamed > 10800000) {
                throw new java.lang.IllegalArgumentException("balancedDuration invalid (must be_renamed 0-10800000 milliseconds)");
            }
            this.mBalancedDuration = i_renamed;
            return this;
        }

        public final com.heytap.accessory.bean.ScanSetting.Builder setLowPowerDuration(int i_renamed) {
            if (i_renamed < 0 || i_renamed > 10800000) {
                throw new java.lang.IllegalArgumentException("lowPowerDuration invalid (must be_renamed 0-10800000 milliseconds)");
            }
            this.mLowPowerDuration = i_renamed;
            return this;
        }

        public final com.heytap.accessory.bean.ScanSetting.Builder setHandleByService(boolean z_renamed) {
            this.mHandleByService = z_renamed;
            return this;
        }

        public final com.heytap.accessory.bean.ScanSetting.Builder setForcedDiscovery(boolean z_renamed) {
            this.mForcedDiscovery = z_renamed;
            return this;
        }

        public final com.heytap.accessory.bean.ScanSetting build() {
            return new com.heytap.accessory.bean.ScanSetting(this.mScanType, this.mLowLatencyDuration, this.mBalancedDuration, this.mLowPowerDuration, this.mHandleByService, this.mForcedDiscovery);
        }
    }
}
