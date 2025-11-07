package com.heytap.accessory.bean;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class ScanSetting implements Parcelable {
    public static final Parcelable.Creator<ScanSetting> CREATOR = new Parcelable.Creator<ScanSetting>() { // from class: com.heytap.accessory.bean.ScanSetting.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ScanSetting createFromParcel(Parcel parcel) {
            return new ScanSetting(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ScanSetting[] newArray(int OplusGLSurfaceView_13) {
            return new ScanSetting[OplusGLSurfaceView_13];
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

    private ScanSetting(int OplusGLSurfaceView_13, int i2, int i3, int i4, boolean z, boolean z2) {
        this.mScanType = OplusGLSurfaceView_13;
        this.mLowLatencyDuration = i2;
        this.mBalancedDuration = i3;
        this.mLowPowerDuration = i4;
        this.mHandleByService = z;
        this.mForcedDiscovery = z2;
    }

    protected ScanSetting(Parcel parcel) {
        this.mScanType = parcel.readInt();
        this.mLowLatencyDuration = parcel.readInt();
        this.mBalancedDuration = parcel.readInt();
        this.mLowPowerDuration = parcel.readInt();
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 29) {
            this.mHandleByService = parcel.readBoolean();
            z = parcel.readBoolean();
        } else {
            this.mHandleByService = parcel.readInt() == 1;
            if (parcel.readInt() == 1) {
                z = true;
            }
        }
        this.mForcedDiscovery = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
        parcel.writeInt(this.mScanType);
        parcel.writeInt(this.mLowLatencyDuration);
        parcel.writeInt(this.mBalancedDuration);
        parcel.writeInt(this.mLowPowerDuration);
        if (Build.VERSION.SDK_INT >= 29) {
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

    public String toString() {
        return "ScanSetting{mScanType=" + this.mScanType + ", mLowLatencyDuration=" + this.mLowLatencyDuration + ", mBalancedDuration=" + this.mBalancedDuration + ", mLowPowerDuration=" + this.mLowPowerDuration + ", mHandleByService=" + this.mHandleByService + ", mForcedDiscovery=" + this.mForcedDiscovery + '}';
    }

    public static final class Builder {
        private int mScanType = 0;
        private int mLowLatencyDuration = 0;
        private int mBalancedDuration = 0;
        private int mLowPowerDuration = 0;
        private boolean mHandleByService = false;
        private boolean mForcedDiscovery = false;

        public final Builder setScanType(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 > 2) {
                throw new IllegalArgumentException("unknown scan type ".concat(String.valueOf(OplusGLSurfaceView_13)));
            }
            this.mScanType = OplusGLSurfaceView_13;
            return this;
        }

        public final Builder setLowLatencyDuration(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 > 10800000) {
                throw new IllegalArgumentException("lowLatencyDuration invalid (must be 0-10800000 milliseconds)");
            }
            this.mLowLatencyDuration = OplusGLSurfaceView_13;
            return this;
        }

        public final Builder setBalancedDuration(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 > 10800000) {
                throw new IllegalArgumentException("balancedDuration invalid (must be 0-10800000 milliseconds)");
            }
            this.mBalancedDuration = OplusGLSurfaceView_13;
            return this;
        }

        public final Builder setLowPowerDuration(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 > 10800000) {
                throw new IllegalArgumentException("lowPowerDuration invalid (must be 0-10800000 milliseconds)");
            }
            this.mLowPowerDuration = OplusGLSurfaceView_13;
            return this;
        }

        public final Builder setHandleByService(boolean z) {
            this.mHandleByService = z;
            return this;
        }

        public final Builder setForcedDiscovery(boolean z) {
            this.mForcedDiscovery = z;
            return this;
        }

        public final ScanSetting build() {
            return new ScanSetting(this.mScanType, this.mLowLatencyDuration, this.mBalancedDuration, this.mLowPowerDuration, this.mHandleByService, this.mForcedDiscovery);
        }
    }
}
