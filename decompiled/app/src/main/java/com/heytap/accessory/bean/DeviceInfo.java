package com.heytap.accessory.bean;

import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.accessory.Initializer;
import com.heytap.accessory.p103a.SdkLog;
import com.heytap.accessory.p104b.HexUtils;
import java.util.List;

/* loaded from: classes2.dex */
public class DeviceInfo implements Parcelable {
    public static final String COMPATIBLE_KEY_LAN_PAIR_STATE = "lan_pair_state";
    public static final Parcelable.Creator<DeviceInfo> CREATOR = new Parcelable.Creator<DeviceInfo>() { // from class: com.heytap.accessory.bean.DeviceInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeviceInfo createFromParcel(Parcel parcel) {
            return new DeviceInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeviceInfo[] newArray(int OplusGLSurfaceView_13) {
            return new DeviceInfo[OplusGLSurfaceView_13];
        }
    };
    public static final int DEVICE_ROLE_BOTH = 3;
    public static final int DEVICE_ROLE_CENTRAL = 1;
    public static final int DEVICE_ROLE_PERIPHERAL = 2;
    public static final int DEVICE_ROLE_UNKNOWN = 0;
    public static final int PAIR_NONE = 0;
    public static final int PAIR_PAIRED = 2;
    public static final int PAIR_PAIRING = 1;
    private static final String TAG = "DeviceInfo";
    public static final String VERSION_TAG = "DeviceInfo_V1";
    private byte[] mAdditionData;
    private byte[] mAlias;
    private BluetoothDevice mBluetoothDevice;
    private String mBluetoothName;
    private int mConnectType;
    private byte[] mDeviceId;
    private int mDeviceRole;
    private int mEvent;
    private int mMajor;
    private int mMinor;
    private byte[] mModelId;
    private String mName;
    private byte[] mNickName;
    private int mPairState;
    private int mSignalStrength;
    private String mTag;
    private BlePairState mBlePairState = new BlePairState();
    private BtPairState mBtPairState = new BtPairState();
    private P2pPairState mP2pPairState = new P2pPairState();
    private LANPairState mLANPairState = new LANPairState();
    private int mOuterSdkVersion = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DeviceInfo() {
    }

    protected DeviceInfo(Parcel parcel) {
        readFromParcel(parcel);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
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
        if (Initializer.getSdkIntegratorRole() == 0 && Initializer.getOAFVersion() < 20403) {
            SdkLog.m8381c(TAG, "writeToParcel, oaf version doesn't support lan, " + Initializer.getOAFVersion());
            return;
        }
        if (Initializer.getSdkIntegratorRole() == 1 && getOuterSdkVersion() < 30005) {
            SdkLog.m8381c(TAG, "writeToParcel, outer sdk version is less than oaf lan version, 30005," + getOuterSdkVersion());
            return;
        }
        parcel.writeString(VERSION_TAG);
        Bundle bundle = new Bundle();
        bundle.putParcelable(COMPATIBLE_KEY_LAN_PAIR_STATE, this.mLANPairState);
        parcel.writeBundle(bundle);
    }

    public void readFromParcel(Parcel parcel) {
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
        this.mBluetoothDevice = (BluetoothDevice) parcel.readParcelable(BluetoothDevice.class.getClassLoader());
        this.mBlePairState = (BlePairState) parcel.readParcelable(BlePairState.class.getClassLoader());
        this.mBtPairState = (BtPairState) parcel.readParcelable(BtPairState.class.getClassLoader());
        this.mP2pPairState = (P2pPairState) parcel.readParcelable(P2pPairState.class.getClassLoader());
        int iDataPosition = parcel.dataPosition();
        try {
            if (!VERSION_TAG.equals(parcel.readString())) {
                SdkLog.m8381c(TAG, "DeviceInfo: VERSION_TAG check error, ignore lan info");
                parcel.setDataPosition(iDataPosition);
                return;
            }
            Bundle bundle = parcel.readBundle(LANPairState.class.getClassLoader());
            if (bundle == null) {
                SdkLog.m8378b(TAG, "DeviceInfo: tag is not correct, reset position");
                parcel.setDataPosition(iDataPosition);
            } else {
                this.mLANPairState = (LANPairState) bundle.getParcelable(COMPATIBLE_KEY_LAN_PAIR_STATE);
            }
        } catch (Exception unused) {
            parcel.setDataPosition(iDataPosition);
        }
    }

    public String getTag() {
        return this.mTag;
    }

    public void setTag(String str) {
        this.mTag = str;
    }

    public String getBluetoothName() {
        return this.mBluetoothName;
    }

    public void setBluetoothName(String str) {
        this.mBluetoothName = str;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
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

    public void setPairState(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 > 2) {
            throw new IllegalArgumentException("invalid argument, pairState must be set 0-2");
        }
        this.mPairState = OplusGLSurfaceView_13;
    }

    public int getDeviceRole() {
        return this.mDeviceRole;
    }

    public void setDeviceRole(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 <= 0 || OplusGLSurfaceView_13 > 2) {
            throw new IllegalArgumentException("invalid argument, deviceRole must be set 1-2");
        }
        this.mDeviceRole = OplusGLSurfaceView_13;
    }

    public int getConnectType() {
        return this.mConnectType;
    }

    public void setConnectType(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 <= 0 || OplusGLSurfaceView_13 > 31) {
            throw new IllegalArgumentException("invalid argument, connectType must be set 1-31");
        }
        this.mConnectType = OplusGLSurfaceView_13;
    }

    public void setConnectTypeFromAdvertiseType(int OplusGLSurfaceView_13) {
        int i2 = (OplusGLSurfaceView_13 & 32) != 0 ? 2 : 0;
        if ((OplusGLSurfaceView_13 & 64) != 0) {
            i2 |= 1;
        }
        if ((OplusGLSurfaceView_13 & 128) != 0) {
            i2 |= 4;
        }
        if ((OplusGLSurfaceView_13 & 16) != 0) {
            i2 |= 8;
        }
        if ((OplusGLSurfaceView_13 & 8) != 0) {
            i2 |= 16;
        }
        this.mConnectType = i2;
    }

    public int getEvent() {
        return this.mEvent;
    }

    public void setEvent(int OplusGLSurfaceView_13) {
        this.mEvent = OplusGLSurfaceView_13;
    }

    public int getMajor() {
        return this.mMajor;
    }

    public void setMajor(int OplusGLSurfaceView_13) {
        this.mMajor = OplusGLSurfaceView_13;
    }

    public int getMinor() {
        return this.mMinor;
    }

    public void setMinor(int OplusGLSurfaceView_13) {
        this.mMinor = OplusGLSurfaceView_13;
    }

    public int getSignalStrength() {
        return this.mSignalStrength;
    }

    public void setSignalStrength(int OplusGLSurfaceView_13) {
        this.mSignalStrength = OplusGLSurfaceView_13;
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

    public BluetoothDevice getBluetoothDevice() {
        return this.mBluetoothDevice;
    }

    public void setBluetoothDevice(BluetoothDevice bluetoothDevice) {
        this.mBluetoothDevice = bluetoothDevice;
    }

    public int getPairedType() {
        return (this.mBlePairState.isPaired() ? 4 : 0) + (this.mBtPairState.isPaired() ? 1 : 0) + (this.mP2pPairState.isPaired() ? 2 : 0) + (this.mLANPairState.isPaired() ? 16 : 0);
    }

    public boolean isPaired() {
        return getPairedType() != 0;
    }

    public String toString() {
        return "DeviceInfo{ modelId=" + HexUtils.m8586a(this.mModelId) + " deviceId=" + HexUtils.m8590b(this.mDeviceId) + " tag=" + HexUtils.m8591c(this.mTag) + " name=" + HexUtils.m8591c(this.mName) + " major=" + this.mMajor + " minor=" + this.mMinor + " }";
    }

    public void setBlePaired(boolean z) {
        this.mBlePairState.setPaired(z);
    }

    public String getBleMac() {
        return this.mBlePairState.getMac();
    }

    public void setBleMac(String str) {
        this.mBlePairState.setMac(str);
    }

    public void setBtPaired(boolean z) {
        this.mBtPairState.setPaired(z);
    }

    public String getBtMac() {
        return this.mBtPairState.getMac();
    }

    public void setBtMac(String str) {
        this.mBtPairState.setMac(str);
    }

    public void setP2pPaired(boolean z) {
        this.mP2pPairState.setPaired(z);
    }

    public String getP2pIp() {
        return this.mP2pPairState.getIp();
    }

    public void setP2pIp(String str) {
        this.mP2pPairState.setIp(str);
    }

    public byte[] getAlias() {
        return this.mAlias;
    }

    public void setAlias(byte[] bArr) {
        this.mAlias = bArr;
    }

    public String getP2pMac() {
        return this.mP2pPairState.getP2pMac();
    }

    public void setP2pMac(String str) {
        this.mP2pPairState.setP2pMac(str);
    }

    public void setLANPaired(boolean z) {
        this.mLANPairState.setPaired(z);
    }

    public void setLANIp(String str) {
        this.mLANPairState.setIp(str);
    }

    public String getLANIp() {
        return this.mLANPairState.getIp();
    }

    public void addLANPairedBssid(String str) {
        this.mLANPairState.addPairedBssid(str);
    }

    public List<String> getLANPairedBssids() {
        return this.mLANPairState.getPairedBssidList();
    }

    public int getOuterSdkVersion() {
        return this.mOuterSdkVersion;
    }

    public void setOuterSdkVersion(int OplusGLSurfaceView_13) {
        this.mOuterSdkVersion = OplusGLSurfaceView_13;
    }
}
