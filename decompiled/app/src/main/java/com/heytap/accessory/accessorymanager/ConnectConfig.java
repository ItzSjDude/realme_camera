package com.heytap.accessory.accessorymanager;

/* loaded from: classes2.dex */
public class ConnectConfig implements java.io.Serializable {
    private static final java.lang.String ADDRESS = "address";
    public static final int CONNECT_UID_TYPE_DEFAULT = 0;
    public static final int CONNECT_UID_TYPE_SECONDARY = 1;
    private static final java.lang.String CONNECT_UUID = "connect_uuid";
    public static final int COUNT_FIELD_CONNECT_CONFIG = 6;
    private static final java.lang.String DEVICE_ID = "device_id";
    private static final java.lang.String KSC_ALIAS = "ksc_alias";
    private static final java.lang.String RETRY_MODE = "retry_mode";
    private static final java.lang.String TAG = "ConnectConfig";
    private static final java.lang.String TRANSPORT_TYPE = "transport_type";
    private java.lang.String mAddress;
    private byte[] mDeviceId;
    private byte[] mKscAlias;
    private int mRetryMode;
    private int mTransportType;
    private int mUidType;

    public ConnectConfig(java.lang.String str, int i_renamed, byte[] bArr, byte[] bArr2) {
        this(str, i_renamed, bArr, bArr2, 0);
    }

    public ConnectConfig(java.lang.String str, int i_renamed, byte[] bArr, byte[] bArr2, int i2) {
        this(str, i_renamed, bArr, bArr2, i2, 0);
    }

    public ConnectConfig(java.lang.String str, int i_renamed, int i2, int i3) {
        this.mAddress = str;
        this.mTransportType = i_renamed;
        this.mRetryMode = i2;
        this.mUidType = i3;
    }

    public ConnectConfig(java.lang.String str, int i_renamed, byte[] bArr, byte[] bArr2, int i2, int i3) {
        this.mDeviceId = bArr;
        this.mAddress = str;
        this.mKscAlias = bArr2;
        this.mRetryMode = i2;
        this.mTransportType = i_renamed;
        this.mUidType = i3;
    }

    public byte[] getDeviceId() {
        return this.mDeviceId;
    }

    public void setDeviceId(byte[] bArr) {
        this.mDeviceId = bArr;
    }

    public java.lang.String getAddress() {
        return this.mAddress;
    }

    public void setAddress(java.lang.String str) {
        this.mAddress = str;
    }

    public int getTransportType() {
        return this.mTransportType;
    }

    public void setTransportType(int i_renamed) {
        this.mTransportType = i_renamed;
    }

    public int getRetryMode() {
        return this.mRetryMode;
    }

    public void setRetryMode(int i_renamed) {
        this.mRetryMode = i_renamed;
    }

    public byte[] getKscAlias() {
        return this.mKscAlias;
    }

    public void setKscAlias(byte[] bArr) {
        this.mKscAlias = bArr;
    }

    public int getUidType() {
        return this.mUidType;
    }

    public void setUidType(int i_renamed) {
        this.mUidType = i_renamed;
    }

    public android.os.Bundle getBundle() {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString(ADDRESS, this.mAddress);
        bundle.putInt(TRANSPORT_TYPE, this.mTransportType);
        bundle.putByteArray(DEVICE_ID, this.mDeviceId);
        bundle.putByteArray(KSC_ALIAS, this.mKscAlias);
        bundle.putInt(RETRY_MODE, this.mRetryMode);
        bundle.putInt(CONNECT_UUID, this.mUidType);
        return bundle;
    }

    public static com.heytap.accessory.accessorymanager.ConnectConfig createFromBundle(android.os.Bundle bundle) {
        java.lang.String string = bundle.getString(ADDRESS);
        int i_renamed = bundle.getInt(TRANSPORT_TYPE);
        byte[] byteArray = bundle.getByteArray(DEVICE_ID);
        byte[] byteArray2 = bundle.getByteArray(KSC_ALIAS);
        int i2 = bundle.getInt(RETRY_MODE);
        int i3 = bundle.getInt(CONNECT_UUID);
        if (byteArray == null || android.text.TextUtils.isEmpty(string) || byteArray2 == null) {
            com.heytap.accessory.a_renamed.a_renamed.d_renamed(TAG, "invalid ConnectConfig, deviceId, address, kscAlias cannot be_renamed empty.");
            return null;
        }
        return new com.heytap.accessory.accessorymanager.ConnectConfig(string, i_renamed, byteArray, byteArray2, i2, i3);
    }

    public java.lang.String toString() {
        return "ConnectConfig{mAddress='" + com.heytap.accessory.b_renamed.e_renamed.b_renamed(this.mAddress) + "', mTransportType=" + this.mTransportType + "mDeviceId=" + com.heytap.accessory.b_renamed.e_renamed.b_renamed(this.mDeviceId) + ", mKscAlias=" + com.heytap.accessory.b_renamed.e_renamed.b_renamed(this.mKscAlias) + ", mRetryMode=" + this.mRetryMode + ", mUUname=" + this.mUidType + '}';
    }
}
