package com.heytap.accessory.accessorymanager;

/* loaded from: classes2.dex */
public class AccessoryManager {
    public static final java.lang.String ACTION_ACCESSORY_ATTACHED_EVENT = "com.heytap.accessory.device.action.ACCESSORY_ATTACHED";
    public static final java.lang.String ACTION_ACCESSORY_DETACHED_EVENT = "com.heytap.accessory.device.action.ACCESSORY_DETACHED";
    private static final int KCS_LENGTH_16 = 16;
    private static final int RESULT_CODE_ERROR = 100;

    @java.lang.Deprecated
    public static final int RETRY_MODE_DEFAULT = 0;

    @java.lang.Deprecated
    public static final int RETRY_MODE_LIMITED = 1;

    @java.lang.Deprecated
    public static final int RETRY_MODE_STICKY = 2;
    public static final int TRANSPORT_ALL = 255;
    public static final int TRANSPORT_BLE = 4;
    public static final int TRANSPORT_BT = 2;
    public static final int TRANSPORT_WIFI = 1;
    public static final int TRANSPORT_WIFI_LAN = 8;
    private static volatile com.heytap.accessory.accessorymanager.AccessoryManager sOnlyInstance;
    private com.heytap.accessory.accessorymanager.AccessoryManager.ConnectionEventReceiver mConnectionEventReceiver;
    private final android.content.Context mContext;
    private com.heytap.accessory.api.GenericAdapter mGenericAdapter;
    private boolean mIsConnected;
    private static final java.lang.String VERSION = com.heytap.accessory.Config.getSdkVersionName();
    private static final java.lang.String TAG = com.heytap.accessory.accessorymanager.AccessoryManager.class.getSimpleName();

    public interface AccessoryEventListener {
        void onAccessoryConnected(com.heytap.accessory.bean.PeerAccessory peerAccessory);

        void onAccessoryDisconnected(com.heytap.accessory.bean.PeerAccessory peerAccessory, int i_renamed);

        void onAccessoryDormant(com.heytap.accessory.bean.PeerAccessory peerAccessory, boolean z_renamed);

        void onError(com.heytap.accessory.bean.PeerAccessory peerAccessory, int i_renamed);
    }

    static final class ConnectionEventReceiver extends android.os.ResultReceiver {

        /* renamed from: a_renamed, reason: collision with root package name */
        private com.heytap.accessory.accessorymanager.AccessoryManager.AccessoryEventListener f3204a;

        public ConnectionEventReceiver(com.heytap.accessory.accessorymanager.AccessoryManager.AccessoryEventListener accessoryEventListener) {
            super(null);
            this.f3204a = accessoryEventListener;
        }

        @Override // android.os.ResultReceiver
        public final void onReceiveResult(int i_renamed, android.os.Bundle bundle) {
            if (bundle == null) {
                com.heytap.accessory.a_renamed.a_renamed.d_renamed(com.heytap.accessory.accessorymanager.AccessoryManager.TAG, "onReceiveResult: resultData is_renamed null");
                return;
            }
            bundle.setClassLoader(com.heytap.accessory.bean.PeerAccessory.class.getClassLoader());
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(com.heytap.accessory.accessorymanager.AccessoryManager.TAG, " onReceiveResult: resultCode= ".concat(java.lang.String.valueOf(i_renamed)));
            com.heytap.accessory.bean.PeerAccessory peerAccessoryCreateFromParcel = null;
            if (i_renamed == 100) {
                int i2 = bundle.getInt(com.heytap.accessory.constant.AFConstants.EXTRA_ERROR_CODE);
                com.heytap.accessory.a_renamed.a_renamed.d_renamed(com.heytap.accessory.accessorymanager.AccessoryManager.TAG, "Error in_renamed Account Config: ".concat(java.lang.String.valueOf(i2)));
                this.f3204a.onError(null, i2);
                return;
            }
            if (i_renamed == 20001) {
                com.heytap.accessory.a_renamed.a_renamed.d_renamed(com.heytap.accessory.accessorymanager.AccessoryManager.TAG, "Accessory Framework has died / disconnetced");
                if (com.heytap.accessory.accessorymanager.AccessoryManager.sOnlyInstance != null) {
                    com.heytap.accessory.accessorymanager.AccessoryManager.sOnlyInstance.mIsConnected = false;
                    com.heytap.accessory.accessorymanager.AccessoryManager unused = com.heytap.accessory.accessorymanager.AccessoryManager.sOnlyInstance = null;
                }
                this.f3204a.onError(null, i_renamed);
                return;
            }
            byte[] byteArray = bundle.getByteArray(com.heytap.accessory.constant.AFConstants.EXTRA_ACCESSORY);
            if (byteArray == null) {
                return;
            }
            try {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                if (parcelObtain != null) {
                    parcelObtain.unmarshall(byteArray, 0, byteArray.length);
                    parcelObtain.setDataPosition(0);
                    peerAccessoryCreateFromParcel = com.heytap.accessory.bean.PeerAccessory.CREATOR.createFromParcel(parcelObtain);
                    com.heytap.accessory.a_renamed.a_renamed.b_renamed(com.heytap.accessory.accessorymanager.AccessoryManager.TAG, "onReceiveResult, peerAcc: " + peerAccessoryCreateFromParcel.toShortString());
                }
                if (parcelObtain != null) {
                    parcelObtain.recycle();
                }
                if (peerAccessoryCreateFromParcel == null) {
                    com.heytap.accessory.a_renamed.a_renamed.d_renamed(com.heytap.accessory.accessorymanager.AccessoryManager.TAG, "onReceiveResult No accessory bundle, return...");
                    return;
                }
                if (this.f3204a == null) {
                    com.heytap.accessory.a_renamed.a_renamed.d_renamed(com.heytap.accessory.accessorymanager.AccessoryManager.TAG, "onReceiveResult callback is_renamed null.");
                    return;
                }
                if (i_renamed == 109) {
                    java.lang.String str = com.heytap.accessory.accessorymanager.AccessoryManager.TAG;
                    java.lang.StringBuilder sb = new java.lang.StringBuilder(" onReceiveResult: DEVICE_STATE_CHANGED: isDormant:");
                    boolean z_renamed = true;
                    sb.append(peerAccessoryCreateFromParcel.getStatus() == 1);
                    com.heytap.accessory.a_renamed.a_renamed.b_renamed(str, sb.toString());
                    com.heytap.accessory.accessorymanager.AccessoryManager.AccessoryEventListener accessoryEventListener = this.f3204a;
                    if (peerAccessoryCreateFromParcel.getStatus() != 1) {
                        z_renamed = false;
                    }
                    accessoryEventListener.onAccessoryDormant(peerAccessoryCreateFromParcel, z_renamed);
                    return;
                }
                if (i_renamed == 114) {
                    com.heytap.accessory.a_renamed.a_renamed.b_renamed(com.heytap.accessory.accessorymanager.AccessoryManager.TAG, " onReceiveResult: DEVICE_ATTACHED accUunameType:" + peerAccessoryCreateFromParcel.getUUIDType());
                    this.f3204a.onAccessoryConnected(peerAccessoryCreateFromParcel);
                    return;
                }
                if (i_renamed == 115) {
                    int i3 = bundle.getInt(com.heytap.accessory.constant.AFConstants.EXTRA_ERROR_CODE);
                    com.heytap.accessory.a_renamed.a_renamed.b_renamed(com.heytap.accessory.accessorymanager.AccessoryManager.TAG, " onReceiveResult: DEVICE_DETACHED and error code 0x" + java.lang.Integer.toHexString(i3) + " accUunameType:" + peerAccessoryCreateFromParcel.getUUIDType());
                    this.f3204a.onAccessoryDisconnected(peerAccessoryCreateFromParcel, i3);
                    return;
                }
                int i4 = bundle.getInt(com.heytap.accessory.constant.AFConstants.EXTRA_ERROR_CODE);
                com.heytap.accessory.a_renamed.a_renamed.b_renamed(com.heytap.accessory.accessorymanager.AccessoryManager.TAG, " onReceiveResult: onError and result code:".concat(java.lang.String.valueOf(i4)));
                this.f3204a.onError(peerAccessoryCreateFromParcel, i4);
            } catch (java.lang.Throwable th) {
                com.heytap.accessory.a_renamed.a_renamed.b_renamed(com.heytap.accessory.accessorymanager.AccessoryManager.TAG, "unmarshalling peerAccessory failed", th);
            }
        }
    }

    private AccessoryManager(android.content.Context context, com.heytap.accessory.accessorymanager.AccessoryManager.AccessoryEventListener accessoryEventListener) throws com.heytap.accessory.bean.SdkUnsupportedException, android.content.pm.PackageManager.NameNotFoundException {
        this.mIsConnected = false;
        this.mContext = context;
        com.heytap.accessory.Initializer.initAFMAccessory(context);
        if (accessoryEventListener != null) {
            this.mConnectionEventReceiver = new com.heytap.accessory.accessorymanager.AccessoryManager.ConnectionEventReceiver(accessoryEventListener);
        } else {
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "getInstance: eventCallback is_renamed null..");
        }
        if (this.mIsConnected) {
            return;
        }
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "mOnlyInstance.mIsConnected is_renamed false");
        this.mGenericAdapter = com.heytap.accessory.api.GenericAdapter.a_renamed(context);
        com.heytap.accessory.api.GenericAdapter genericAdapter = this.mGenericAdapter;
        if (genericAdapter == null || !genericAdapter.b_renamed()) {
            return;
        }
        this.mIsConnected = true;
        if (accessoryEventListener != null) {
            this.mGenericAdapter.a_renamed(this.mConnectionEventReceiver);
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "registerAccessoryCallback.. if case");
        }
    }

    public static com.heytap.accessory.accessorymanager.AccessoryManager getInstance(android.content.Context context, com.heytap.accessory.accessorymanager.AccessoryManager.AccessoryEventListener accessoryEventListener) throws com.heytap.accessory.bean.SdkUnsupportedException {
        if (context == null) {
            throw new java.lang.IllegalArgumentException("Invalid argmument input.");
        }
        com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "AccessoryManager sdk version: " + VERSION);
        if (sOnlyInstance == null) {
            synchronized (com.heytap.accessory.accessorymanager.AccessoryManager.class) {
                if (sOnlyInstance == null) {
                    sOnlyInstance = new com.heytap.accessory.accessorymanager.AccessoryManager(context, accessoryEventListener);
                }
            }
        }
        return sOnlyInstance;
    }

    public void connect(com.heytap.accessory.accessorymanager.ConnectConfig connectConfig) throws java.io.IOException {
        com.heytap.accessory.accessorymanager.AccessoryManager.ConnectionEventReceiver connectionEventReceiver;
        validateTransportDetails(connectConfig.getAddress(), connectConfig.getTransportType());
        if (this.mGenericAdapter == null) {
            this.mGenericAdapter = com.heytap.accessory.api.GenericAdapter.a_renamed(this.mContext);
        }
        if (!this.mGenericAdapter.a_renamed() && (connectionEventReceiver = this.mConnectionEventReceiver) != null) {
            this.mGenericAdapter.a_renamed(connectionEventReceiver);
        }
        int iA = this.mGenericAdapter.a_renamed(connectConfig);
        if (iA != 0) {
            if (iA == 3) {
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "connect not support");
                return;
            }
            throw new java.io.IOException("Connect request failed");
        }
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "Connect requested successfully for address:" + com.heytap.accessory.b_renamed.e_renamed.c_renamed(connectConfig.getAddress()) + " Transport Type:" + connectConfig.getTransportType());
    }

    public void disconnect(java.lang.String str, int i_renamed) throws java.io.IOException {
        disconnect(str, i_renamed, 0);
    }

    public void disconnect(java.lang.String str, int i_renamed, int i2) throws java.io.IOException {
        com.heytap.accessory.accessorymanager.AccessoryManager.ConnectionEventReceiver connectionEventReceiver;
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "disconnect:" + com.heytap.accessory.b_renamed.e_renamed.c_renamed(str) + " Transport:" + i_renamed + " UUname:" + i2);
        validateTransportDetails(str, i_renamed);
        if (this.mGenericAdapter == null) {
            this.mGenericAdapter = com.heytap.accessory.api.GenericAdapter.a_renamed(this.mContext);
        }
        if (!this.mGenericAdapter.a_renamed() && (connectionEventReceiver = this.mConnectionEventReceiver) != null) {
            this.mGenericAdapter.a_renamed(connectionEventReceiver);
        }
        if (this.mGenericAdapter.a_renamed(str, i_renamed, i2) == 0) {
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "Disconnect requested successfully for address:" + com.heytap.accessory.b_renamed.e_renamed.c_renamed(str) + " Transport Type:" + i_renamed);
            return;
        }
        throw new java.io.IOException("Disconnect request failed");
    }

    public boolean setKsc(byte[] bArr, byte[] bArr2, byte[] bArr3) throws java.lang.IllegalArgumentException {
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "setKsc, " + com.heytap.accessory.b_renamed.e_renamed.b_renamed(bArr3));
        checkKscValid(bArr3);
        if (this.mGenericAdapter == null) {
            this.mGenericAdapter = com.heytap.accessory.api.GenericAdapter.a_renamed(this.mContext);
        }
        int iA = this.mGenericAdapter.a_renamed(bArr, bArr2, bArr3);
        if (iA == 0) {
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "ksc successfully set");
        } else if (iA == 4) {
            com.heytap.accessory.a_renamed.a_renamed.d_renamed(TAG, "ksc set duplicate: ".concat(java.lang.String.valueOf(iA)));
        } else {
            com.heytap.accessory.a_renamed.a_renamed.d_renamed(TAG, "ksc set error: ".concat(java.lang.String.valueOf(iA)));
        }
        return iA == 0;
    }

    public boolean checkKscExist(byte[] bArr, byte[] bArr2) throws java.lang.IllegalArgumentException {
        if (this.mGenericAdapter == null) {
            this.mGenericAdapter = com.heytap.accessory.api.GenericAdapter.a_renamed(this.mContext);
        }
        int iA = this.mGenericAdapter.a_renamed(bArr, bArr2);
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "checkKscExist, deviceId: " + com.heytap.accessory.b_renamed.e_renamed.b_renamed(bArr) + ", alias: " + com.heytap.accessory.b_renamed.e_renamed.b_renamed(bArr2) + ", result: " + iA);
        return iA == 0;
    }

    public boolean checkKscExist(byte[] bArr) throws java.io.IOException, java.lang.IllegalArgumentException {
        return checkKscExist(null, bArr);
    }

    public boolean removeKsc(byte[] bArr, byte[] bArr2) throws java.lang.IllegalArgumentException {
        if (this.mGenericAdapter == null) {
            this.mGenericAdapter = com.heytap.accessory.api.GenericAdapter.a_renamed(this.mContext);
        }
        int iB = this.mGenericAdapter.b_renamed(bArr, bArr2);
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "checkKscExist, deviceId: " + com.heytap.accessory.b_renamed.e_renamed.b_renamed(bArr) + ", alias: " + com.heytap.accessory.b_renamed.e_renamed.b_renamed(bArr2) + ", result: " + iB);
        return iB == 0;
    }

    public boolean removeKsc(byte[] bArr) throws java.io.IOException, java.lang.IllegalArgumentException {
        return removeKsc(null, bArr);
    }

    public synchronized boolean setAccessoryDormant(boolean z_renamed) {
        int iA;
        if (this.mGenericAdapter == null) {
            this.mGenericAdapter = com.heytap.accessory.api.GenericAdapter.a_renamed(this.mContext);
        }
        iA = this.mGenericAdapter.a_renamed(z_renamed);
        if (iA == 0) {
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "acc status successfully set");
        } else {
            com.heytap.accessory.a_renamed.a_renamed.d_renamed(TAG, "acc status set failed");
        }
        return iA == 0;
    }

    public int setTrafficControlConfig(com.heytap.accessory.bean.TrafficControlConfig trafficControlConfig) throws java.lang.IllegalArgumentException {
        if (this.mGenericAdapter == null) {
            this.mGenericAdapter = com.heytap.accessory.api.GenericAdapter.a_renamed(this.mContext);
        }
        int iA = this.mGenericAdapter.a_renamed(trafficControlConfig);
        if (iA == 0) {
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "setTrafficControlConfig success:".concat(java.lang.String.valueOf(trafficControlConfig)));
        } else {
            com.heytap.accessory.a_renamed.a_renamed.d_renamed(TAG, "setTrafficControlConfig failed: ".concat(java.lang.String.valueOf(iA)));
        }
        return iA;
    }

    public java.util.List<com.heytap.accessory.bean.AccountInfo> getAccountInfoArray() {
        if (this.mGenericAdapter == null) {
            this.mGenericAdapter = com.heytap.accessory.api.GenericAdapter.a_renamed(this.mContext);
        }
        return this.mGenericAdapter.e_renamed();
    }

    public java.util.List<com.heytap.accessory.bean.PeerAccessory> getConnectedAccessories() {
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "getConnectedAccessories");
        if (this.mGenericAdapter == null) {
            this.mGenericAdapter = com.heytap.accessory.api.GenericAdapter.a_renamed(this.mContext);
        }
        return this.mGenericAdapter.f_renamed();
    }

    public java.util.List<com.heytap.accessory.bean.ServiceProfile> getAvailableServices(long j_renamed) {
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "getAvailableServices,accessoryId:".concat(java.lang.String.valueOf(j_renamed)));
        if (this.mGenericAdapter == null) {
            this.mGenericAdapter = com.heytap.accessory.api.GenericAdapter.a_renamed(this.mContext);
        }
        return this.mGenericAdapter.a_renamed(j_renamed);
    }

    public boolean hasBoundFramework() {
        if (this.mGenericAdapter == null) {
            this.mGenericAdapter = com.heytap.accessory.api.GenericAdapter.a_renamed(this.mContext);
        }
        return this.mGenericAdapter.b_renamed();
    }

    public void release() {
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "release");
        if (this.mIsConnected) {
            com.heytap.accessory.api.GenericAdapter genericAdapter = this.mGenericAdapter;
            if (genericAdapter != null) {
                genericAdapter.g_renamed();
            }
            this.mIsConnected = false;
        }
    }

    @java.lang.Deprecated
    public byte[] loadLocalDeviceId() {
        return getLocalDeviceId();
    }

    public byte[] getLocalDeviceId() {
        if (this.mGenericAdapter == null) {
            this.mGenericAdapter = com.heytap.accessory.api.GenericAdapter.a_renamed(this.mContext);
        }
        byte[] bArrC = this.mGenericAdapter.c_renamed();
        if (bArrC == null) {
            com.heytap.accessory.a_renamed.a_renamed.d_renamed(TAG, "loadLocalDeviceId is_renamed null");
        } else {
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "loadLocalDeviceId success");
        }
        return bArrC;
    }

    public int getLocalDeviceType() throws java.io.IOException {
        if (this.mGenericAdapter == null) {
            this.mGenericAdapter = com.heytap.accessory.api.GenericAdapter.a_renamed(this.mContext);
        }
        try {
            return this.mGenericAdapter.d_renamed();
        } catch (android.os.RemoteException e_renamed) {
            throw new java.io.IOException(e_renamed);
        }
    }

    private void validateTransportDetails(java.lang.String str, int i_renamed) {
        if (str == null || str.length() == 0) {
            throw new java.lang.IllegalArgumentException("Invalid transport address");
        }
        if (i_renamed != 1) {
            if (i_renamed != 2 && i_renamed != 4) {
                if (i_renamed != 8) {
                    throw new java.lang.IllegalArgumentException("Invalid transport type:".concat(java.lang.String.valueOf(i_renamed)));
                }
            } else {
                if (java.util.regex.Pattern.compile("^([0-9A-F_renamed]{2}[:-]){5}([0-9A-F_renamed]{2})$").matcher(str).matches()) {
                    return;
                }
                throw new java.lang.IllegalArgumentException("Invalid BT Address:" + com.heytap.accessory.b_renamed.e_renamed.c_renamed(str));
            }
        }
    }

    private void checkKscValid(byte[] bArr) throws java.lang.IllegalArgumentException {
        if (bArr != null && bArr.length != 16) {
            throw new java.lang.IllegalArgumentException("ksc length must be_renamed 16");
        }
    }
}
