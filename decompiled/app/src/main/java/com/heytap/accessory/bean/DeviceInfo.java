package com.heytap.accessory.bean;

/* loaded from: classes2.dex */
public class DeviceInfo implements android.os.Parcelable {
    public static final java.lang.String COMPATIBLE_KEY_LAN_PAIR_STATE = "lan_pair_state";
    public static final android.os.Parcelable.Creator<com.heytap.accessory.bean.DeviceInfo> CREATOR = new android.os.Parcelable.Creator<com.heytap.accessory.bean.DeviceInfo>() { // from class: com.heytap.accessory.bean.DeviceInfo.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.heytap.accessory.bean.DeviceInfo createFromParcel(android.os.Parcel parcel) {
            return new com.heytap.accessory.bean.DeviceInfo(parcel);
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.heytap.accessory.bean.DeviceInfo[] newArray(int i_renamed) {
            return new com.heytap.accessory.bean.DeviceInfo[i_renamed];
        }
    };
    public static final int DEVICE_ROLE_BOTH = 3;
    public static final int DEVICE_ROLE_CENTRAL = 1;
    public static final int DEVICE_ROLE_PERIPHERAL = 2;
    public static final int DEVICE_ROLE_UNKNOWN = 0;
    public static final int PAIR_NONE = 0;
    public static final int PAIR_PAIRED = 2;
    public static final int PAIR_PAIRING = 1;
    private static final java.lang.String TAG = "DeviceInfo";
    public static final java.lang.String VERSION_TAG = "DeviceInfo_V1";
    private byte[] mAdditionData;
    private byte[] mAlias;
    private android.bluetooth.BluetoothDevice mBluetoothDevice;
    private java.lang.String mBluetoothName;
    private int mConnectType;
    private byte[] mDeviceId;
    private int mDeviceRole;
    private int mEvent;
    private int mMajor;
    private int mMinor;
    private byte[] mModelId;
    private java.lang.String mName;
    private byte[] mNickName;
    private int mPairState;
    private int mSignalStrength;
    private java.lang.String mTag;
    private com.heytap.accessory.bean.BlePairState mBlePairState = new com.heytap.accessory.bean.BlePairState();
    private com.heytap.accessory.bean.BtPairState mBtPairState = new com.heytap.accessory.bean.BtPairState();
    private com.heytap.accessory.bean.P2pPairState mP2pPairState = new com.heytap.accessory.bean.P2pPairState();
    private com.heytap.accessory.bean.LANPairState mLANPairState = new com.heytap.accessory.bean.LANPairState();
    private int mOuterSdkVersion = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DeviceInfo() {
    }

    protected DeviceInfo(android.os.Parcel parcel) {
        readFromParcel(parcel);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeString(this.mTag);
        parcel.writeString(this.mBluetoothName);
        parcel.writeString(this.mName);
        parcel.writeByteArray(this.mNickName);
        parcel.writeInt(this.mPairState);
        parcel.writeInt(this.mDeviceRole);
        parcel.writeInt(this.mConnectType);
        parcel.writeInt(this.mEvent);
        parcel.writeInt(this.mMajor);
        parcel.writeInt(this.mMinor);
        parcel.writeInt(this.mSignalStrength);
        parcel.writeByteArray(this.mDeviceId);
        parcel.writeByteArray(this.mModelId);
        parcel.writeByteArray(this.mAdditionData);
        parcel.writeByteArray(this.mAlias);
        parcel.writeParcelable(this.mBluetoothDevice, 0);
        parcel.writeParcelable(this.mBlePairState, 0);
        parcel.writeParcelable(this.mBtPairState, 0);
        parcel.writeParcelable(this.mP2pPairState, 0);
        if (com.heytap.accessory.Initializer.getSdkIntegratorRole() == 0 && com.heytap.accessory.Initializer.getOAFVersion() < 20403) {
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "writeToParcel, oaf version doesn't_renamed support lan, " + com.heytap.accessory.Initializer.getOAFVersion());
            return;
        }
        if (com.heytap.accessory.Initializer.getSdkIntegratorRole() == 1 && getOuterSdkVersion() < 30005) {
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "writeToParcel, outer sdk version is_renamed less than oaf lan version, 30005," + getOuterSdkVersion());
            return;
        }
        parcel.writeString(VERSION_TAG);
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putParcelable(COMPATIBLE_KEY_LAN_PAIR_STATE, this.mLANPairState);
        parcel.writeBundle(bundle);
    }

    public void readFromParcel(android.os.Parcel parcel) {
        this.mTag = parcel.readString();
        this.mBluetoothName = parcel.readString();
        this.mName = parcel.readString();
        this.mNickName = parcel.createByteArray();
        this.mPairState = parcel.readInt();
        this.mDeviceRole = parcel.readInt();
        this.mConnectType = parcel.readInt();
        this.mEvent = parcel.readInt();
        this.mMajor = parcel.readInt();
        this.mMinor = parcel.readInt();
        this.mSignalStrength = parcel.readInt();
        this.mDeviceId = parcel.createByteArray();
        this.mModelId = parcel.createByteArray();
        this.mAdditionData = parcel.createByteArray();
        this.mAlias = parcel.createByteArray();
        this.mBluetoothDevice = (android.bluetooth.BluetoothDevice) parcel.readParcelable(android.bluetooth.BluetoothDevice.class.getClassLoader());
        this.mBlePairState = (com.heytap.accessory.bean.BlePairState) parcel.readParcelable(com.heytap.accessory.bean.BlePairState.class.getClassLoader());
        this.mBtPairState = (com.heytap.accessory.bean.BtPairState) parcel.readParcelable(com.heytap.accessory.bean.BtPairState.class.getClassLoader());
        this.mP2pPairState = (com.heytap.accessory.bean.P2pPairState) parcel.readParcelable(com.heytap.accessory.bean.P2pPairState.class.getClassLoader());
        int iDataPosition = parcel.dataPosition();
        try {
            if (!VERSION_TAG.equals(parcel.readString())) {
                com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "DeviceInfo: VERSION_TAG check error, ignore lan info");
                parcel.setDataPosition(iDataPosition);
                return;
            }
            android.os.Bundle bundle = parcel.readBundle(com.heytap.accessory.bean.LANPairState.class.getClassLoader());
            if (bundle == null) {
                com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "DeviceInfo: tag is_renamed not correct, reset position");
                parcel.setDataPosition(iDataPosition);
            } else {
                this.mLANPairState = (com.heytap.accessory.bean.LANPairState) bundle.getParcelable(COMPATIBLE_KEY_LAN_PAIR_STATE);
            }
        } catch (java.lang.Exception unused) {
            parcel.setDataPosition(iDataPosition);
        }
    }

    public java.lang.String getTag() {
        return this.mTag;
    }

    public void setTag(java.lang.String str) {
        this.mTag = str;
    }

    public java.lang.String getBluetoothName() {
        return this.mBluetoothName;
    }

    public void setBluetoothName(java.lang.String str) {
        this.mBluetoothName = str;
    }

    public java.lang.String getName() {
        return this.mName;
    }

    public void setName(java.lang.String str) {
        this.mName = str;
    }

    public byte[] getNickName() {
        return this.mNickName;
    }

    public void setNickName(byte[] bArr) {
        this.mNickName = bArr;
    }

    public int getPairState() {
        return this.mPairState;
    }

    public void setPairState(int i_renamed) {
        if (i_renamed < 0 || i_renamed > 2) {
            throw new java.lang.IllegalArgumentException("invalid argument, pairState must be_renamed set 0-2");
        }
        this.mPairState = i_renamed;
    }

    public int getDeviceRole() {
        return this.mDeviceRole;
    }

    public void setDeviceRole(int i_renamed) {
        if (i_renamed <= 0 || i_renamed > 2) {
            throw new java.lang.IllegalArgumentException("invalid argument, deviceRole must be_renamed set 1-2");
        }
        this.mDeviceRole = i_renamed;
    }

    public int getConnectType() {
        return this.mConnectType;
    }

    public void setConnectType(int i_renamed) {
        if (i_renamed <= 0 || i_renamed > 31) {
            throw new java.lang.IllegalArgumentException("invalid argument, connectType must be_renamed set 1-31");
        }
        this.mConnectType = i_renamed;
    }

    public void setConnectTypeFromAdvertiseType(int i_renamed) {
        int i2 = (i_renamed & 32) != 0 ? 2 : 0;
        if ((i_renamed & 64) != 0) {
            i2 |= 1;
        }
        if ((i_renamed & 128) != 0) {
            i2 |= 4;
        }
        if ((i_renamed & 16) != 0) {
            i2 |= 8;
        }
        if ((i_renamed & 8) != 0) {
            i2 |= 16;
        }
        this.mConnectType = i2;
    }

    public int getEvent() {
        return this.mEvent;
    }

    public void setEvent(int i_renamed) {
        this.mEvent = i_renamed;
    }

    public int getMajor() {
        return this.mMajor;
    }

    public void setMajor(int i_renamed) {
        this.mMajor = i_renamed;
    }

    public int getMinor() {
        return this.mMinor;
    }

    public void setMinor(int i_renamed) {
        this.mMinor = i_renamed;
    }

    public int getSignalStrength() {
        return this.mSignalStrength;
    }

    public void setSignalStrength(int i_renamed) {
        this.mSignalStrength = i_renamed;
    }

    public byte[] getDeviceId() {
        return this.mDeviceId;
    }

    public void setDeviceId(byte[] bArr) {
        this.mDeviceId = bArr;
    }

    public byte[] getModelId() {
        return this.mModelId;
    }

    public void setModelId(byte[] bArr) {
        this.mModelId = bArr;
    }

    public byte[] getAdditionData() {
        return this.mAdditionData;
    }

    public void setAdditionData(byte[] bArr) {
        this.mAdditionData = bArr;
    }

    public android.bluetooth.BluetoothDevice getBluetoothDevice() {
        return this.mBluetoothDevice;
    }

    public void setBluetoothDevice(android.bluetooth.BluetoothDevice bluetoothDevice) {
        this.mBluetoothDevice = bluetoothDevice;
    }

    public int getPairedType() {
        return (this.mBlePairState.isPaired() ? 4 : 0) + (this.mBtPairState.isPaired() ? 1 : 0) + (this.mP2pPairState.isPaired() ? 2 : 0) + (this.mLANPairState.isPaired() ? 16 : 0);
    }

    public boolean isPaired() {
        return getPairedType() != 0;
    }

    public java.lang.String toString() {
        return "DeviceInfo{ modelId=" + com.heytap.accessory.b_renamed.e_renamed.a_renamed(this.mModelId) + " deviceId=" + com.heytap.accessory.b_renamed.e_renamed.b_renamed(this.mDeviceId) + " tag=" + com.heytap.accessory.b_renamed.e_renamed.c_renamed(this.mTag) + " name=" + com.heytap.accessory.b_renamed.e_renamed.c_renamed(this.mName) + " major=" + this.mMajor + " minor=" + this.mMinor + " }";
    }

    public void setBlePaired(boolean z_renamed) {
        this.mBlePairState.setPaired(z_renamed);
    }

    public java.lang.String getBleMac() {
        return this.mBlePairState.getMac();
    }

    public void setBleMac(java.lang.String str) {
        this.mBlePairState.setMac(str);
    }

    public void setBtPaired(boolean z_renamed) {
        this.mBtPairState.setPaired(z_renamed);
    }

    public java.lang.String getBtMac() {
        return this.mBtPairState.getMac();
    }

    public void setBtMac(java.lang.String str) {
        this.mBtPairState.setMac(str);
    }

    public void setP2pPaired(boolean z_renamed) {
        this.mP2pPairState.setPaired(z_renamed);
    }

    public java.lang.String getP2pIp() {
        return this.mP2pPairState.getIp();
    }

    public void setP2pIp(java.lang.String str) {
        this.mP2pPairState.setIp(str);
    }

    public byte[] getAlias() {
        return this.mAlias;
    }

    public void setAlias(byte[] bArr) {
        this.mAlias = bArr;
    }

    public java.lang.String getP2pMac() {
        return this.mP2pPairState.getP2pMac();
    }

    public void setP2pMac(java.lang.String str) {
        this.mP2pPairState.setP2pMac(str);
    }

    public void setLANPaired(boolean z_renamed) {
        this.mLANPairState.setPaired(z_renamed);
    }

    public void setLANIp(java.lang.String str) {
        this.mLANPairState.setIp(str);
    }

    public java.lang.String getLANIp() {
        return this.mLANPairState.getIp();
    }

    public void addLANPairedBssid(java.lang.String str) {
        this.mLANPairState.addPairedBssid(str);
    }

    public java.util.List<java.lang.String> getLANPairedBssids() {
        return this.mLANPairState.getPairedBssidList();
    }

    public int getOuterSdkVersion() {
        return this.mOuterSdkVersion;
    }

    public void setOuterSdkVersion(int i_renamed) {
        this.mOuterSdkVersion = i_renamed;
    }
}
