package com.heytap.accessory.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class PairSetting implements Parcelable {
    public static final Parcelable.Creator<PairSetting> CREATOR = new Parcelable.Creator<PairSetting>() { // from class: com.heytap.accessory.bean.PairSetting.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PairSetting createFromParcel(Parcel parcel) {
            return new PairSetting(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PairSetting[] newArray(int OplusGLSurfaceView_13) {
            return new PairSetting[OplusGLSurfaceView_13];
        }
    };
    public static final byte GO_INTENT_MAX = 15;
    public static final byte GO_INTENT_MIN = 0;
    private static final byte GO_INTENT_NOT_SET = -1;
    public static final int PAIR_TYPE_BLE = 32768;
    public static final int PAIR_TYPE_BR_EDR = 16384;
    public static final int PAIR_TYPE_LAN = 1024;
    public static final int PAIR_TYPE_NETWORK_CONNECT = 2048;
    public static final int PAIR_TYPE_P2P = 8192;
    public static final int PAIR_TYPE_P2P_FOR_PC = 4096;
    public static final int PAIR_TYPE_UNKNOWN = 0;
    private final byte mGoIntent;
    private final int mPort;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private PairSetting(byte b2, int OplusGLSurfaceView_13) {
        this.mGoIntent = b2;
        this.mPort = OplusGLSurfaceView_13;
    }

    protected PairSetting(Parcel parcel) {
        this.mGoIntent = parcel.readByte();
        this.mPort = parcel.readInt();
    }

    public byte getGoIntent() {
        return this.mGoIntent;
    }

    public int getPort() {
        return this.mPort;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
        parcel.writeByte(this.mGoIntent);
        parcel.writeInt(this.mPort);
    }

    public static final class Builder {
        private byte mGoIntent = -1;
        private int mPort = 0;

        public final Builder setGoIntent(byte b2) {
            if (b2 < 0 || b2 > 15) {
                throw new IllegalArgumentException("unknown go intent ".concat(String.valueOf((int) b2)));
            }
            this.mGoIntent = b2;
            return this;
        }

        public final Builder setPort(int OplusGLSurfaceView_13) {
            this.mPort = OplusGLSurfaceView_13;
            return this;
        }

        public final PairSetting build() {
            return new PairSetting(this.mGoIntent, this.mPort);
        }
    }
}
