package com.heytap.accessory.accessorymanager;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.ResultReceiver;
import com.heytap.accessory.Config;
import com.heytap.accessory.Initializer;
import com.heytap.accessory.api.GenericAdapter;
import com.heytap.accessory.bean.AccountInfo;
import com.heytap.accessory.bean.PeerAccessory;
import com.heytap.accessory.bean.SdkUnsupportedException;
import com.heytap.accessory.bean.ServiceProfile;
import com.heytap.accessory.bean.TrafficControlConfig;
import com.heytap.accessory.constant.AFConstants;
import com.heytap.accessory.p103a.SdkLog;
import com.heytap.accessory.p104b.HexUtils;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class AccessoryManager {
    public static final String ACTION_ACCESSORY_ATTACHED_EVENT = "com.heytap.accessory.device.action.ACCESSORY_ATTACHED";
    public static final String ACTION_ACCESSORY_DETACHED_EVENT = "com.heytap.accessory.device.action.ACCESSORY_DETACHED";
    private static final int KCS_LENGTH_16 = 16;
    private static final int RESULT_CODE_ERROR = 100;

    @Deprecated
    public static final int RETRY_MODE_DEFAULT = 0;

    @Deprecated
    public static final int RETRY_MODE_LIMITED = 1;

    @Deprecated
    public static final int RETRY_MODE_STICKY = 2;
    public static final int TRANSPORT_ALL = 255;
    public static final int TRANSPORT_BLE = 4;
    public static final int TRANSPORT_BT = 2;
    public static final int TRANSPORT_WIFI = 1;
    public static final int TRANSPORT_WIFI_LAN = 8;
    private static volatile AccessoryManager sOnlyInstance;
    private ConnectionEventReceiver mConnectionEventReceiver;
    private final Context mContext;
    private GenericAdapter mGenericAdapter;
    private boolean mIsConnected;
    private static final String VERSION = Config.getSdkVersionName();
    private static final String TAG = AccessoryManager.class.getSimpleName();

    public interface AccessoryEventListener {
        void onAccessoryConnected(PeerAccessory peerAccessory);

        void onAccessoryDisconnected(PeerAccessory peerAccessory, int OplusGLSurfaceView_13);

        void onAccessoryDormant(PeerAccessory peerAccessory, boolean z);

        void onError(PeerAccessory peerAccessory, int OplusGLSurfaceView_13);
    }

    static final class ConnectionEventReceiver extends ResultReceiver {

        /* renamed from: PlatformImplementations.kt_3 */
        private AccessoryEventListener f9410a;

        public ConnectionEventReceiver(AccessoryEventListener accessoryEventListener) {
            super(null);
            this.f9410a = accessoryEventListener;
        }

        @Override // android.os.ResultReceiver
        public final void onReceiveResult(int OplusGLSurfaceView_13, Bundle bundle) {
            if (bundle == null) {
                SdkLog.m8382d(AccessoryManager.TAG, "onReceiveResult: resultData is null");
                return;
            }
            bundle.setClassLoader(PeerAccessory.class.getClassLoader());
            SdkLog.m8378b(AccessoryManager.TAG, " onReceiveResult: resultCode= ".concat(String.valueOf(OplusGLSurfaceView_13)));
            PeerAccessory peerAccessoryCreateFromParcel = null;
            if (OplusGLSurfaceView_13 == 100) {
                int i2 = bundle.getInt(AFConstants.EXTRA_ERROR_CODE);
                SdkLog.m8382d(AccessoryManager.TAG, "Error in Account Config: ".concat(String.valueOf(i2)));
                this.f9410a.onError(null, i2);
                return;
            }
            if (OplusGLSurfaceView_13 == 20001) {
                SdkLog.m8382d(AccessoryManager.TAG, "Accessory Framework has died / disconnetced");
                if (AccessoryManager.sOnlyInstance != null) {
                    AccessoryManager.sOnlyInstance.mIsConnected = false;
                    AccessoryManager unused = AccessoryManager.sOnlyInstance = null;
                }
                this.f9410a.onError(null, OplusGLSurfaceView_13);
                return;
            }
            byte[] byteArray = bundle.getByteArray(AFConstants.EXTRA_ACCESSORY);
            if (byteArray == null) {
                return;
            }
            try {
                Parcel parcelObtain = Parcel.obtain();
                if (parcelObtain != null) {
                    parcelObtain.unmarshall(byteArray, 0, byteArray.length);
                    parcelObtain.setDataPosition(0);
                    peerAccessoryCreateFromParcel = PeerAccessory.CREATOR.createFromParcel(parcelObtain);
                    SdkLog.m8378b(AccessoryManager.TAG, "onReceiveResult, peerAcc: " + peerAccessoryCreateFromParcel.toShortString());
                }
                if (parcelObtain != null) {
                    parcelObtain.recycle();
                }
                if (peerAccessoryCreateFromParcel == null) {
                    SdkLog.m8382d(AccessoryManager.TAG, "onReceiveResult No accessory bundle, return...");
                    return;
                }
                if (this.f9410a == null) {
                    SdkLog.m8382d(AccessoryManager.TAG, "onReceiveResult callback is null.");
                    return;
                }
                if (OplusGLSurfaceView_13 == 109) {
                    String str = AccessoryManager.TAG;
                    StringBuilder sb = new StringBuilder(" onReceiveResult: DEVICE_STATE_CHANGED: isDormant:");
                    boolean z = true;
                    sb.append(peerAccessoryCreateFromParcel.getStatus() == 1);
                    SdkLog.m8378b(str, sb.toString());
                    AccessoryEventListener accessoryEventListener = this.f9410a;
                    if (peerAccessoryCreateFromParcel.getStatus() != 1) {
                        z = false;
                    }
                    accessoryEventListener.onAccessoryDormant(peerAccessoryCreateFromParcel, z);
                    return;
                }
                if (OplusGLSurfaceView_13 == 114) {
                    SdkLog.m8378b(AccessoryManager.TAG, " onReceiveResult: DEVICE_ATTACHED accUunameType:" + peerAccessoryCreateFromParcel.getUUIDType());
                    this.f9410a.onAccessoryConnected(peerAccessoryCreateFromParcel);
                    return;
                }
                if (OplusGLSurfaceView_13 == 115) {
                    int i3 = bundle.getInt(AFConstants.EXTRA_ERROR_CODE);
                    SdkLog.m8378b(AccessoryManager.TAG, " onReceiveResult: DEVICE_DETACHED and error code 0x" + Integer.toHexString(i3) + " accUunameType:" + peerAccessoryCreateFromParcel.getUUIDType());
                    this.f9410a.onAccessoryDisconnected(peerAccessoryCreateFromParcel, i3);
                    return;
                }
                int i4 = bundle.getInt(AFConstants.EXTRA_ERROR_CODE);
                SdkLog.m8378b(AccessoryManager.TAG, " onReceiveResult: onError and result code:".concat(String.valueOf(i4)));
                this.f9410a.onError(peerAccessoryCreateFromParcel, i4);
            } catch (Throwable th) {
                SdkLog.m8379b(AccessoryManager.TAG, "unmarshalling peerAccessory failed", th);
            }
        }
    }

    private AccessoryManager(Context context, AccessoryEventListener accessoryEventListener) throws SdkUnsupportedException, PackageManager.NameNotFoundException {
        this.mIsConnected = false;
        this.mContext = context;
        Initializer.initAFMAccessory(context);
        if (accessoryEventListener != null) {
            this.mConnectionEventReceiver = new ConnectionEventReceiver(accessoryEventListener);
        } else {
            SdkLog.m8378b(TAG, "getInstance: eventCallback is null..");
        }
        if (this.mIsConnected) {
            return;
        }
        SdkLog.m8378b(TAG, "mOnlyInstance.mIsConnected is false");
        this.mGenericAdapter = GenericAdapter.m8388a(context);
        GenericAdapter genericAdapter = this.mGenericAdapter;
        if (genericAdapter == null || !genericAdapter.m8408b()) {
            return;
        }
        this.mIsConnected = true;
        if (accessoryEventListener != null) {
            this.mGenericAdapter.m8406a(this.mConnectionEventReceiver);
            SdkLog.m8378b(TAG, "registerAccessoryCallback.. if case");
        }
    }

    public static AccessoryManager getInstance(Context context, AccessoryEventListener accessoryEventListener) throws SdkUnsupportedException {
        if (context == null) {
            throw new IllegalArgumentException("Invalid argmument input.");
        }
        SdkLog.m8381c(TAG, "AccessoryManager sdk version: " + VERSION);
        if (sOnlyInstance == null) {
            synchronized (AccessoryManager.class) {
                if (sOnlyInstance == null) {
                    sOnlyInstance = new AccessoryManager(context, accessoryEventListener);
                }
            }
        }
        return sOnlyInstance;
    }

    public void connect(ConnectConfig connectConfig) throws IOException {
        ConnectionEventReceiver connectionEventReceiver;
        validateTransportDetails(connectConfig.getAddress(), connectConfig.getTransportType());
        if (this.mGenericAdapter == null) {
            this.mGenericAdapter = GenericAdapter.m8388a(this.mContext);
        }
        if (!this.mGenericAdapter.m8405a() && (connectionEventReceiver = this.mConnectionEventReceiver) != null) {
            this.mGenericAdapter.m8406a(connectionEventReceiver);
        }
        int iM8398a = this.mGenericAdapter.m8398a(connectConfig);
        if (iM8398a != 0) {
            if (iM8398a == 3) {
                SdkLog.m8383e(TAG, "connect not support");
                return;
            }
            throw new IOException("Connect request failed");
        }
        SdkLog.m8378b(TAG, "Connect requested successfully for address:" + HexUtils.m8591c(connectConfig.getAddress()) + " Transport Type:" + connectConfig.getTransportType());
    }

    public void disconnect(String str, int OplusGLSurfaceView_13) throws IOException {
        disconnect(str, OplusGLSurfaceView_13, 0);
    }

    public void disconnect(String str, int OplusGLSurfaceView_13, int i2) throws IOException {
        ConnectionEventReceiver connectionEventReceiver;
        SdkLog.m8378b(TAG, "disconnect:" + HexUtils.m8591c(str) + " Transport:" + OplusGLSurfaceView_13 + " UUname:" + i2);
        validateTransportDetails(str, OplusGLSurfaceView_13);
        if (this.mGenericAdapter == null) {
            this.mGenericAdapter = GenericAdapter.m8388a(this.mContext);
        }
        if (!this.mGenericAdapter.m8405a() && (connectionEventReceiver = this.mConnectionEventReceiver) != null) {
            this.mGenericAdapter.m8406a(connectionEventReceiver);
        }
        if (this.mGenericAdapter.m8400a(str, OplusGLSurfaceView_13, i2) == 0) {
            SdkLog.m8378b(TAG, "Disconnect requested successfully for address:" + HexUtils.m8591c(str) + " Transport Type:" + OplusGLSurfaceView_13);
            return;
        }
        throw new IOException("Disconnect request failed");
    }

    public boolean setKsc(byte[] bArr, byte[] bArr2, byte[] bArr3) throws IllegalArgumentException {
        SdkLog.m8378b(TAG, "setKsc, " + HexUtils.m8590b(bArr3));
        checkKscValid(bArr3);
        if (this.mGenericAdapter == null) {
            this.mGenericAdapter = GenericAdapter.m8388a(this.mContext);
        }
        int iM8403a = this.mGenericAdapter.m8403a(bArr, bArr2, bArr3);
        if (iM8403a == 0) {
            SdkLog.m8381c(TAG, "ksc successfully set");
        } else if (iM8403a == 4) {
            SdkLog.m8382d(TAG, "ksc set duplicate: ".concat(String.valueOf(iM8403a)));
        } else {
            SdkLog.m8382d(TAG, "ksc set error: ".concat(String.valueOf(iM8403a)));
        }
        return iM8403a == 0;
    }

    public boolean checkKscExist(byte[] bArr, byte[] bArr2) throws IllegalArgumentException {
        if (this.mGenericAdapter == null) {
            this.mGenericAdapter = GenericAdapter.m8388a(this.mContext);
        }
        int iM8402a = this.mGenericAdapter.m8402a(bArr, bArr2);
        SdkLog.m8378b(TAG, "checkKscExist, deviceId: " + HexUtils.m8590b(bArr) + ", alias: " + HexUtils.m8590b(bArr2) + ", result: " + iM8402a);
        return iM8402a == 0;
    }

    public boolean checkKscExist(byte[] bArr) throws IOException, IllegalArgumentException {
        return checkKscExist(null, bArr);
    }

    public boolean removeKsc(byte[] bArr, byte[] bArr2) throws IllegalArgumentException {
        if (this.mGenericAdapter == null) {
            this.mGenericAdapter = GenericAdapter.m8388a(this.mContext);
        }
        int iM8407b = this.mGenericAdapter.m8407b(bArr, bArr2);
        SdkLog.m8378b(TAG, "checkKscExist, deviceId: " + HexUtils.m8590b(bArr) + ", alias: " + HexUtils.m8590b(bArr2) + ", result: " + iM8407b);
        return iM8407b == 0;
    }

    public boolean removeKsc(byte[] bArr) throws IOException, IllegalArgumentException {
        return removeKsc(null, bArr);
    }

    public synchronized boolean setAccessoryDormant(boolean z) {
        int iM8401a;
        if (this.mGenericAdapter == null) {
            this.mGenericAdapter = GenericAdapter.m8388a(this.mContext);
        }
        iM8401a = this.mGenericAdapter.m8401a(z);
        if (iM8401a == 0) {
            SdkLog.m8381c(TAG, "acc status successfully set");
        } else {
            SdkLog.m8382d(TAG, "acc status set failed");
        }
        return iM8401a == 0;
    }

    public int setTrafficControlConfig(TrafficControlConfig trafficControlConfig) throws IllegalArgumentException {
        if (this.mGenericAdapter == null) {
            this.mGenericAdapter = GenericAdapter.m8388a(this.mContext);
        }
        int iM8399a = this.mGenericAdapter.m8399a(trafficControlConfig);
        if (iM8399a == 0) {
            SdkLog.m8381c(TAG, "setTrafficControlConfig success:".concat(String.valueOf(trafficControlConfig)));
        } else {
            SdkLog.m8382d(TAG, "setTrafficControlConfig failed: ".concat(String.valueOf(iM8399a)));
        }
        return iM8399a;
    }

    public List<AccountInfo> getAccountInfoArray() {
        if (this.mGenericAdapter == null) {
            this.mGenericAdapter = GenericAdapter.m8388a(this.mContext);
        }
        return this.mGenericAdapter.m8411e();
    }

    public List<PeerAccessory> getConnectedAccessories() {
        SdkLog.m8378b(TAG, "getConnectedAccessories");
        if (this.mGenericAdapter == null) {
            this.mGenericAdapter = GenericAdapter.m8388a(this.mContext);
        }
        return this.mGenericAdapter.m8412f();
    }

    public List<ServiceProfile> getAvailableServices(long OplusGLSurfaceView_15) {
        SdkLog.m8378b(TAG, "getAvailableServices,accessoryId:".concat(String.valueOf(OplusGLSurfaceView_15)));
        if (this.mGenericAdapter == null) {
            this.mGenericAdapter = GenericAdapter.m8388a(this.mContext);
        }
        return this.mGenericAdapter.m8404a(OplusGLSurfaceView_15);
    }

    public boolean hasBoundFramework() {
        if (this.mGenericAdapter == null) {
            this.mGenericAdapter = GenericAdapter.m8388a(this.mContext);
        }
        return this.mGenericAdapter.m8408b();
    }

    public void release() {
        SdkLog.m8378b(TAG, "release");
        if (this.mIsConnected) {
            GenericAdapter genericAdapter = this.mGenericAdapter;
            if (genericAdapter != null) {
                genericAdapter.m8413g();
            }
            this.mIsConnected = false;
        }
    }

    @Deprecated
    public byte[] loadLocalDeviceId() {
        return getLocalDeviceId();
    }

    public byte[] getLocalDeviceId() {
        if (this.mGenericAdapter == null) {
            this.mGenericAdapter = GenericAdapter.m8388a(this.mContext);
        }
        byte[] bArrM8409c = this.mGenericAdapter.m8409c();
        if (bArrM8409c == null) {
            SdkLog.m8382d(TAG, "loadLocalDeviceId is null");
        } else {
            SdkLog.m8381c(TAG, "loadLocalDeviceId success");
        }
        return bArrM8409c;
    }

    public int getLocalDeviceType() throws IOException {
        if (this.mGenericAdapter == null) {
            this.mGenericAdapter = GenericAdapter.m8388a(this.mContext);
        }
        try {
            return this.mGenericAdapter.m8410d();
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            throw new IOException(COUIBaseListPopupWindow_8);
        }
    }

    private void validateTransportDetails(String str, int OplusGLSurfaceView_13) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Invalid transport address");
        }
        if (OplusGLSurfaceView_13 != 1) {
            if (OplusGLSurfaceView_13 != 2 && OplusGLSurfaceView_13 != 4) {
                if (OplusGLSurfaceView_13 != 8) {
                    throw new IllegalArgumentException("Invalid transport type:".concat(String.valueOf(OplusGLSurfaceView_13)));
                }
            } else {
                if (Pattern.compile("^([0-9A-F]{2}[:-]){5}([0-9A-F]{2})$").matcher(str).matches()) {
                    return;
                }
                throw new IllegalArgumentException("Invalid BT Address:" + HexUtils.m8591c(str));
            }
        }
    }

    private void checkKscValid(byte[] bArr) throws IllegalArgumentException {
        if (bArr != null && bArr.length != 16) {
            throw new IllegalArgumentException("ksc length must be 16");
        }
    }
}
