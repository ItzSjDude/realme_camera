package com.heytap.accessory.bean;

/* loaded from: classes2.dex */
public class AdvertiseSetting implements android.os.Parcelable {
    public static final int ADVERTISE_MODE_BALANCED = 1;
    public static final int ADVERTISE_MODE_LOW_LATENCY = 2;
    public static final int ADVERTISE_MODE_LOW_POWER = 0;
    public static final int ADVERTISE_TYPE_BLE = 128;
    public static final int ADVERTISE_TYPE_BR_EDR = 64;
    public static final int ADVERTISE_TYPE_FASTDISCOVERY = 0;
    public static final int ADVERTISE_TYPE_FASTPAIR_ACCOUNT = 2;
    public static final int ADVERTISE_TYPE_FASTPAIR_MODELID = 1;
    public static final int ADVERTISE_TYPE_LAN = 8;
    public static final int ADVERTISE_TYPE_NETWORK = 16;
    public static final int ADVERTISE_TYPE_P2P = 32;
    public static final int CONNECT_TYPE_BLE = 4;
    public static final int CONNECT_TYPE_BT = 1;
    public static final int CONNECT_TYPE_LAN = 16;
    public static final int CONNECT_TYPE_MAX = 31;
    public static final int CONNECT_TYPE_MINI = 1;
    public static final int CONNECT_TYPE_NETWORK_CONNECT = 8;
    public static final int CONNECT_TYPE_P2P = 2;
    public static final int CONNECT_TYPE_UNKNOWN = 0;

    @java.lang.Deprecated
    public static final int CONNECT_TYPE_WIFI = 2;
    public static final android.os.Parcelable.Creator<com.heytap.accessory.bean.AdvertiseSetting> CREATOR = new android.os.Parcelable.Creator<com.heytap.accessory.bean.AdvertiseSetting>() { // from class: com.heytap.accessory.bean.AdvertiseSetting.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.heytap.accessory.bean.AdvertiseSetting createFromParcel(android.os.Parcel parcel) {
            return new com.heytap.accessory.bean.AdvertiseSetting(parcel);
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.heytap.accessory.bean.AdvertiseSetting[] newArray(int i_renamed) {
            return new com.heytap.accessory.bean.AdvertiseSetting[i_renamed];
        }
    };
    private static final java.lang.String EXTRA_IS_CANCEL_ADV = "is_cancel_adv";
    private static final java.lang.String EXTRA_RDI = "rdi";
    public static final byte GO_INTENT_MAX = 15;
    public static final byte GO_INTENT_MIN = 0;
    public static final byte GO_INTENT_NOT_SET = -1;
    public static final byte GO_INTENT_PHONE_DEFAULT = 8;
    private static final int IS_CANCEL_ADV_BYTE = 1;
    private static final int IS_NOT_CANCEL_ADV_TYPE = 0;
    private static final int LIMITED_ADVETISING_MAX_MILLIS = 10800000;
    private static final int LIMITED_IS_CANCEL_BYTE_LENGTH = 1;
    private static final int LIMITED_MODELID_LENGTH = 3;
    private static final int LIMITED_NICKNAME_LENGTH = 9;
    private static final int LIMITED_RDI_LENGTH = 6;
    public static final int SECURE_KEY_TYPE_PRESET = 1;
    public static final int SECURE_KEY_TYPE_UKEY2_INVISIBLE = 2;
    private static final int SUPPORT_CANCEL_ADV_VERSION_CODE = 20400;
    private static final java.lang.String TAG = "AdvertiseSetting";
    private static final java.lang.String VERSION_TAG = "newAS_V1";
    private byte[] mAdditionData;
    private final int mAdvertiseMode;
    private final int mAdvertiseType;
    private final int mConnectType;
    private final int mDurationMillis;
    private final byte mGoIntent;
    private boolean mIsCancelAdv;
    private final int mKeyType;
    private final int mMajor;
    private byte[] mModelId;
    private byte[] mNickName;
    private final int mPort;
    private byte[] mRdi;
    private int mServiceVersion;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private AdvertiseSetting(int i_renamed, int i2, int i3, int i4, byte[] bArr, byte[] bArr2, byte[] bArr3, byte b2, int i5, int i6, int i7, boolean z_renamed, byte[] bArr4) {
        this.mAdvertiseType = i_renamed;
        this.mConnectType = i2;
        this.mDurationMillis = i3;
        this.mKeyType = i4;
        this.mModelId = bArr;
        this.mNickName = bArr2;
        this.mAdditionData = bArr3;
        this.mGoIntent = b2;
        this.mPort = i5;
        this.mMajor = i6;
        this.mAdvertiseMode = i7;
        this.mIsCancelAdv = z_renamed;
        this.mRdi = bArr4;
    }

    protected AdvertiseSetting(android.os.Parcel parcel) {
        this.mAdvertiseType = parcel.readInt();
        this.mConnectType = parcel.readInt();
        this.mDurationMillis = parcel.readInt();
        this.mKeyType = parcel.readInt();
        this.mModelId = parcel.createByteArray();
        this.mNickName = parcel.createByteArray();
        this.mAdditionData = parcel.createByteArray();
        this.mGoIntent = parcel.readByte();
        this.mPort = parcel.readInt();
        this.mMajor = parcel.readInt();
        this.mAdvertiseMode = parcel.readInt();
        int iDataPosition = parcel.dataPosition();
        try {
            if (!VERSION_TAG.equals(parcel.readString())) {
                parcel.setDataPosition(iDataPosition);
                return;
            }
            android.os.Bundle bundle = parcel.readBundle(com.heytap.accessory.bean.AdvertiseSetting.class.getClassLoader());
            if (bundle == null) {
                parcel.setDataPosition(iDataPosition);
            } else {
                this.mIsCancelAdv = bundle.getBoolean(EXTRA_IS_CANCEL_ADV, false);
                this.mRdi = bundle.getByteArray(EXTRA_RDI);
            }
        } catch (java.lang.Exception unused) {
            parcel.setDataPosition(iDataPosition);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeInt(this.mAdvertiseType);
        parcel.writeInt(this.mConnectType);
        parcel.writeInt(this.mDurationMillis);
        parcel.writeInt(this.mKeyType);
        parcel.writeByteArray(this.mModelId);
        parcel.writeByteArray(this.mNickName);
        parcel.writeByteArray(this.mAdditionData);
        parcel.writeByte(this.mGoIntent);
        parcel.writeInt(this.mPort);
        parcel.writeInt(this.mMajor);
        parcel.writeInt(this.mAdvertiseMode);
        if (this.mServiceVersion >= SUPPORT_CANCEL_ADV_VERSION_CODE) {
            parcel.writeString(VERSION_TAG);
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putBoolean(EXTRA_IS_CANCEL_ADV, this.mIsCancelAdv);
            bundle.putByteArray(EXTRA_RDI, this.mRdi);
            parcel.writeBundle(bundle);
        }
    }

    public int getAdvertiseType() {
        return this.mAdvertiseType;
    }

    public int getConnectType() {
        return this.mConnectType;
    }

    public int getDurationMillis() {
        return this.mDurationMillis;
    }

    public int getKeyType() {
        return this.mKeyType;
    }

    public byte[] getModelId() {
        return this.mModelId;
    }

    public byte[] getNickName() {
        return this.mNickName;
    }

    public byte[] getAdditionData() {
        return this.mAdditionData;
    }

    public byte getGoIntent() {
        return this.mGoIntent;
    }

    public int getPort() {
        return this.mPort;
    }

    public int getMajor() {
        return this.mMajor;
    }

    public int getAdvertiseMode() {
        return this.mAdvertiseMode;
    }

    public boolean getIsCancelAdv() {
        return this.mIsCancelAdv;
    }

    public byte[] getRdi() {
        return this.mRdi;
    }

    public static final class Builder {
        private boolean mIsCancelAdv;
        private byte[] mRdi;
        private int mAdvertiseType = 1;
        private int mConnectType = -1;
        private int mDurationMillis = 0;
        private int mKeyType = 2;
        private byte[] mModelId = null;
        private byte[] mNickName = null;
        private byte[] mAdditionData = null;
        private byte mGoIntent = -1;
        private int mPort = 0;
        private int mMajor = 3;
        private int mAdvertiseMode = 0;

        public final com.heytap.accessory.bean.AdvertiseSetting.Builder setAdvertiseType(int i_renamed) {
            if (i_renamed < 0 || i_renamed > 2) {
                throw new java.lang.IllegalArgumentException("unknown advertise type: ".concat(java.lang.String.valueOf(i_renamed)));
            }
            this.mAdvertiseType = i_renamed;
            return this;
        }

        public final com.heytap.accessory.bean.AdvertiseSetting.Builder setConnectType(int i_renamed) {
            if (i_renamed <= 0 || i_renamed > 31) {
                throw new java.lang.IllegalArgumentException("unknown connect type ".concat(java.lang.String.valueOf(i_renamed)));
            }
            this.mConnectType = i_renamed;
            return this;
        }

        public final com.heytap.accessory.bean.AdvertiseSetting.Builder setDurationMillis(int i_renamed) {
            if (i_renamed < 0 || i_renamed > com.heytap.accessory.bean.AdvertiseSetting.LIMITED_ADVETISING_MAX_MILLIS) {
                throw new java.lang.IllegalArgumentException("timeoutMillis invalid (must be_renamed 0-10800000 milliseconds)");
            }
            this.mDurationMillis = i_renamed;
            return this;
        }

        public final com.heytap.accessory.bean.AdvertiseSetting.Builder setKeyType(int i_renamed) {
            if (i_renamed <= 0 || i_renamed > 2) {
                throw new java.lang.IllegalArgumentException("keyType invalid");
            }
            this.mKeyType = i_renamed;
            return this;
        }

        public final com.heytap.accessory.bean.AdvertiseSetting.Builder setModelId(byte[] bArr) {
            java.util.Optional.ofNullable(bArr).ifPresent(new java.util.function.Consumer() { // from class: com.heytap.accessory.bean.-$$Lambda$AdvertiseSetting$Builder$EuXBymsn13ZdHKRe6BXQOgdHFZc
                @Override // java.util.function.Consumer
                public final void accept(java.lang.Object obj) {
                    com.heytap.accessory.bean.AdvertiseSetting.Builder.lambda$setModelId$0((byte[]) obj);
                }
            });
            this.mModelId = bArr;
            return this;
        }

        static /* synthetic */ void lambda$setModelId$0(byte[] bArr) {
            if (bArr.length != 3) {
                throw new java.lang.IllegalArgumentException("model id_renamed invalid (length must be_renamed 3 byte)");
            }
        }

        public final com.heytap.accessory.bean.AdvertiseSetting.Builder setNickName(byte[] bArr) {
            java.util.Optional.ofNullable(bArr).ifPresent(new java.util.function.Consumer() { // from class: com.heytap.accessory.bean.-$$Lambda$AdvertiseSetting$Builder$LY2CgSsllbYW6o244jrpQhdzPc0
                @Override // java.util.function.Consumer
                public final void accept(java.lang.Object obj) {
                    com.heytap.accessory.bean.AdvertiseSetting.Builder.lambda$setNickName$1((byte[]) obj);
                }
            });
            this.mNickName = bArr;
            return this;
        }

        static /* synthetic */ void lambda$setNickName$1(byte[] bArr) {
            if (bArr.length > 9) {
                throw new java.lang.IllegalArgumentException("nickName invalid (length must be_renamed 0-9 byte)");
            }
        }

        public final com.heytap.accessory.bean.AdvertiseSetting.Builder setAdditionData(byte[] bArr) {
            this.mAdditionData = bArr;
            return this;
        }

        public final com.heytap.accessory.bean.AdvertiseSetting.Builder setGoIntent(byte b2) {
            if (b2 < -1 || b2 > 15) {
                throw new java.lang.IllegalArgumentException("unknown go_renamed intent ".concat(java.lang.String.valueOf((int) b2)));
            }
            this.mGoIntent = b2;
            return this;
        }

        public final com.heytap.accessory.bean.AdvertiseSetting.Builder setPort(int i_renamed) {
            this.mPort = i_renamed;
            return this;
        }

        public final com.heytap.accessory.bean.AdvertiseSetting.Builder setMajor(int i_renamed) {
            if (i_renamed <= 0 || i_renamed > 8) {
                throw new java.lang.IllegalArgumentException("major invalid, must be_renamed 1-8");
            }
            this.mMajor = i_renamed;
            return this;
        }

        public final com.heytap.accessory.bean.AdvertiseSetting.Builder setAdvertiseMode(int i_renamed) {
            if (i_renamed < 0 || i_renamed > 2) {
                throw new java.lang.IllegalArgumentException("mode invalid, must be_renamed 0-2");
            }
            this.mAdvertiseMode = i_renamed;
            return this;
        }

        public final com.heytap.accessory.bean.AdvertiseSetting.Builder setIsCancelAdv(boolean z_renamed) {
            this.mIsCancelAdv = z_renamed;
            return this;
        }

        public final com.heytap.accessory.bean.AdvertiseSetting.Builder setRdi(byte[] bArr) {
            java.util.Optional.ofNullable(bArr).ifPresent(new java.util.function.Consumer() { // from class: com.heytap.accessory.bean.-$$Lambda$AdvertiseSetting$Builder$ZJD6kBviMnhtUlp-grQPT3PFP1s
                @Override // java.util.function.Consumer
                public final void accept(java.lang.Object obj) {
                    com.heytap.accessory.bean.AdvertiseSetting.Builder.lambda$setRdi$2((byte[]) obj);
                }
            });
            this.mRdi = bArr;
            return this;
        }

        static /* synthetic */ void lambda$setRdi$2(byte[] bArr) {
            if (bArr.length != 6) {
                throw new java.lang.IllegalArgumentException("rdi invalid (length must be_renamed 6 byte)");
            }
        }

        public final com.heytap.accessory.bean.AdvertiseSetting build() {
            byte[] bArr;
            int i_renamed = this.mAdvertiseType;
            if ((i_renamed == 0 || i_renamed == 1) && ((bArr = this.mModelId) == null || bArr.length != 3)) {
                throw new java.lang.IllegalArgumentException("model id_renamed invalid (length must be_renamed 3 byte)");
            }
            return new com.heytap.accessory.bean.AdvertiseSetting(this.mAdvertiseType, this.mConnectType, this.mDurationMillis, this.mKeyType, this.mModelId, this.mNickName, this.mAdditionData, this.mGoIntent, this.mPort, this.mMajor, this.mAdvertiseMode, this.mIsCancelAdv, this.mRdi);
        }
    }

    public void setServiceVersion(int i_renamed) {
        this.mServiceVersion = i_renamed;
    }
}
