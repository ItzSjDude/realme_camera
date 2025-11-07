package com.heytap.accessory.bean;

/* loaded from: classes2.dex */
public class PairSetting implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.heytap.accessory.bean.PairSetting> CREATOR = new android.os.Parcelable.Creator<com.heytap.accessory.bean.PairSetting>() { // from class: com.heytap.accessory.bean.PairSetting.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.heytap.accessory.bean.PairSetting createFromParcel(android.os.Parcel parcel) {
            return new com.heytap.accessory.bean.PairSetting(parcel);
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.heytap.accessory.bean.PairSetting[] newArray(int i_renamed) {
            return new com.heytap.accessory.bean.PairSetting[i_renamed];
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

    private PairSetting(byte b2, int i_renamed) {
        this.mGoIntent = b2;
        this.mPort = i_renamed;
    }

    protected PairSetting(android.os.Parcel parcel) {
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
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeByte(this.mGoIntent);
        parcel.writeInt(this.mPort);
    }

    public static final class Builder {
        private byte mGoIntent = -1;
        private int mPort = 0;

        public final com.heytap.accessory.bean.PairSetting.Builder setGoIntent(byte b2) {
            if (b2 < 0 || b2 > 15) {
                throw new java.lang.IllegalArgumentException("unknown go_renamed intent ".concat(java.lang.String.valueOf((int) b2)));
            }
            this.mGoIntent = b2;
            return this;
        }

        public final com.heytap.accessory.bean.PairSetting.Builder setPort(int i_renamed) {
            this.mPort = i_renamed;
            return this;
        }

        public final com.heytap.accessory.bean.PairSetting build() {
            return new com.heytap.accessory.bean.PairSetting(this.mGoIntent, this.mPort);
        }
    }
}
