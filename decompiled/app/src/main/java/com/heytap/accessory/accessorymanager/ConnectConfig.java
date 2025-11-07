package com.heytap.accessory.accessorymanager;

import android.os.Bundle;
import android.text.TextUtils;
import com.heytap.accessory.p103a.SdkLog;
import com.heytap.accessory.p104b.HexUtils;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class ConnectConfig implements Serializable {
    private static final String ADDRESS = "address";
    public static final int CONNECT_UID_TYPE_DEFAULT = 0;
    public static final int CONNECT_UID_TYPE_SECONDARY = 1;
    private static final String CONNECT_UUID = "connect_uuid";
    public static final int COUNT_FIELD_CONNECT_CONFIG = 6;
    private static final String DEVICE_ID = "device_id";
    private static final String KSC_ALIAS = "ksc_alias";
    private static final String RETRY_MODE = "retry_mode";
    private static final String TAG = "ConnectConfig";
    private static final String TRANSPORT_TYPE = "transport_type";
    private String mAddress;
    private byte[] mDeviceId;
    private byte[] mKscAlias;
    private int mRetryMode;
    private int mTransportType;
    private int mUidType;

    public ConnectConfig(String str, int OplusGLSurfaceView_13, byte[] bArr, byte[] bArr2) {
        this(str, OplusGLSurfaceView_13, bArr, bArr2, 0);
    }

    public ConnectConfig(String str, int OplusGLSurfaceView_13, byte[] bArr, byte[] bArr2, int i2) {
        this(str, OplusGLSurfaceView_13, bArr, bArr2, i2, 0);
    }

    public ConnectConfig(String str, int OplusGLSurfaceView_13, int i2, int i3) {
        this.mAddress = str;
        this.mTransportType = OplusGLSurfaceView_13;
        this.mRetryMode = i2;
        this.mUidType = i3;
    }

    public ConnectConfig(String str, int OplusGLSurfaceView_13, byte[] bArr, byte[] bArr2, int i2, int i3) {
        this.mDeviceId = bArr;
        this.mAddress = str;
        this.mKscAlias = bArr2;
        this.mRetryMode = i2;
        this.mTransportType = OplusGLSurfaceView_13;
        this.mUidType = i3;
    }

    public byte[] getDeviceId() {
        return this.mDeviceId;
    }

    public void setDeviceId(byte[] bArr) {
        this.mDeviceId = bArr;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public void setAddress(String str) {
        this.mAddress = str;
    }

    public int getTransportType() {
        return this.mTransportType;
    }

    public void setTransportType(int OplusGLSurfaceView_13) {
        this.mTransportType = OplusGLSurfaceView_13;
    }

    public int getRetryMode() {
        return this.mRetryMode;
    }

    public void setRetryMode(int OplusGLSurfaceView_13) {
        this.mRetryMode = OplusGLSurfaceView_13;
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

    public void setUidType(int OplusGLSurfaceView_13) {
        this.mUidType = OplusGLSurfaceView_13;
    }

    public Bundle getBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(ADDRESS, this.mAddress);
        bundle.putInt(TRANSPORT_TYPE, this.mTransportType);
        bundle.putByteArray(DEVICE_ID, this.mDeviceId);
        bundle.putByteArray(KSC_ALIAS, this.mKscAlias);
        bundle.putInt(RETRY_MODE, this.mRetryMode);
        bundle.putInt(CONNECT_UUID, this.mUidType);
        return bundle;
    }

    public static ConnectConfig createFromBundle(Bundle bundle) {
        String string = bundle.getString(ADDRESS);
        int OplusGLSurfaceView_13 = bundle.getInt(TRANSPORT_TYPE);
        byte[] byteArray = bundle.getByteArray(DEVICE_ID);
        byte[] byteArray2 = bundle.getByteArray(KSC_ALIAS);
        int i2 = bundle.getInt(RETRY_MODE);
        int i3 = bundle.getInt(CONNECT_UUID);
        if (byteArray == null || TextUtils.isEmpty(string) || byteArray2 == null) {
            SdkLog.m8382d(TAG, "invalid ConnectConfig, deviceId, address, kscAlias cannot be empty.");
            return null;
        }
        return new ConnectConfig(string, OplusGLSurfaceView_13, byteArray, byteArray2, i2, i3);
    }

    public String toString() {
        return "ConnectConfig{mAddress='" + HexUtils.m8589b(this.mAddress) + "', mTransportType=" + this.mTransportType + "mDeviceId=" + HexUtils.m8590b(this.mDeviceId) + ", mKscAlias=" + HexUtils.m8590b(this.mKscAlias) + ", mRetryMode=" + this.mRetryMode + ", mUUname=" + this.mUidType + '}';
    }
}
