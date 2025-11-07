package com.heytap.accessory.discovery;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.heytap.accessory.api.IDiscoveryNativeService;
import com.heytap.accessory.api.IPeripheralCallback;
import com.heytap.accessory.api.IPeripheralService;
import com.heytap.accessory.api.ManagerConfig;
import com.heytap.accessory.bean.AdvertiseSetting;
import com.heytap.accessory.bean.AuthenticateMessage;
import com.heytap.accessory.bean.ConnectMessage;
import com.heytap.accessory.bean.DeviceInfo;
import com.heytap.accessory.bean.DiscoveryException;
import com.heytap.accessory.bean.Message;
import com.heytap.accessory.bean.SdkUnsupportedException;
import com.heytap.accessory.constant.AFConstants;
import com.heytap.accessory.discovery.BaseManager;
import com.heytap.accessory.p103a.SdkLog;
import com.heytap.accessory.p104b.HexUtils;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/* loaded from: classes2.dex */
public class PeripheralManager extends BaseManager {
    public static final int ADVERTISE_FAILED_ALREADY_STARTED = 3;
    public static final int ADVERTISE_FAILED_DATA_TOO_LARGE = 1;
    public static final int ADVERTISE_FAILED_FEATURE_UNSUPPORTED = 5;
    public static final int ADVERTISE_FAILED_INTERNAL_ERROR = 4;
    public static final int ADVERTISE_FAILED_SETUP_SERVER = 100;
    public static final int ADVERTISE_FAILED_TOO_MANY_ADVERTISERS = 2;
    public static final int CONNECT_RESULT_AGREE = 1;
    public static final int CONNECT_RESULT_AUTH_CUSTOMIZE = 4;
    public static final int CONNECT_RESULT_AUTH_PIN = 3;
    public static final int CONNECT_RESULT_REJECT = 2;
    public static final int ERROR_AUTHENTICATION_FAILED = 1;
    public static final int ERROR_DEVICE = 2;
    public static final int ERROR_NONE = 0;
    public static final int ERROR_PAIR_CONNECT_FAILED = 3;
    private static final String PREFIX = "ppl_";
    private static final String TAG = "PeripheralManager";
    private static volatile PeripheralManager sInstance;
    private Context mContext;
    private final Set<BaseManager.C2196a> mManagerCallbackSet = new HashSet();
    private String mPackageName;
    private byte[] mPreRdi;
    private volatile IPeripheralService mService;

    @Override // com.heytap.accessory.discovery.BaseManager
    public /* bridge */ /* synthetic */ int getFpCoreVersion() {
        return super.getFpCoreVersion();
    }

    @Override // com.heytap.accessory.discovery.BaseManager
    public /* bridge */ /* synthetic */ int getServiceVersion() {
        return super.getServiceVersion();
    }

    @Override // com.heytap.accessory.discovery.BaseManager, android.content.ServiceConnection
    public /* bridge */ /* synthetic */ void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        super.onServiceConnected(componentName, iBinder);
    }

    @Override // com.heytap.accessory.discovery.BaseManager, android.content.ServiceConnection
    public /* bridge */ /* synthetic */ void onServiceDisconnected(ComponentName componentName) {
        super.onServiceDisconnected(componentName);
    }

    private PeripheralManager() {
    }

    @Override // com.heytap.accessory.discovery.BaseManager
    protected String getPackageName() {
        return PREFIX + this.mPackageName;
    }

    @Override // com.heytap.accessory.discovery.BaseManager
    protected void onSubServiceConnected(IDiscoveryNativeService iDiscoveryNativeService) {
        List list;
        SdkLog.m8381c(TAG, "onSubServiceConnected");
        synchronized (this) {
            try {
                this.mService = iDiscoveryNativeService.mo8448b();
                notifyAll();
            } catch (RemoteException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        }
        List.of();
        synchronized (this.mManagerCallbackSet) {
            list = (List) this.mManagerCallbackSet.stream().filter(new Predicate() { // from class: com.heytap.accessory.discovery.-$$Lambda$PeripheralManager$AGx5qn1vbXBcUeyTAlEwCyNZv7I
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return PeripheralManager.lambda$onSubServiceConnected$0((BaseManager.C2196a) obj);
                }
            }).map(new Function() { // from class: com.heytap.accessory.discovery.-$$Lambda$PeripheralManager$7EAhaF8vq3z9OBu-CxK0MtRR8xo
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ((BaseManager.C2196a) obj).f9514b;
                }
            }).collect(Collectors.toList());
        }
        list.forEach($$Lambda$jao6ooJJhKIvmFGirPbP16Y1xA.INSTANCE);
    }

    static /* synthetic */ boolean lambda$onSubServiceConnected$0(BaseManager.C2196a c2196a) {
        boolean z = !c2196a.f9513a;
        c2196a.f9513a = true;
        return z;
    }

    @Override // com.heytap.accessory.discovery.BaseManager
    protected void onSubServiceDisconnected() {
        List list;
        SdkLog.m8381c(TAG, "onSubServiceDisconnected");
        this.mService = null;
        List.of();
        synchronized (this.mManagerCallbackSet) {
            list = (List) this.mManagerCallbackSet.stream().map(new Function() { // from class: com.heytap.accessory.discovery.-$$Lambda$PeripheralManager$pK0QK3PW7tCLUI2vmeZa7nNZEhE
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ((BaseManager.C2196a) obj).f9514b;
                }
            }).collect(Collectors.toList());
            this.mManagerCallbackSet.clear();
        }
        list.forEach($$Lambda$x6LUMI97ky_K7TrH0qnHNFk4Ol8.INSTANCE);
    }

    @Override // com.heytap.accessory.discovery.BaseManager
    protected void onSubBindService(Context context) {
        bindServiceSync(context);
    }

    public static PeripheralManager getInstance() {
        PeripheralManager peripheralManager = sInstance;
        if (peripheralManager == null) {
            synchronized (PeripheralManager.class) {
                peripheralManager = sInstance;
                if (peripheralManager == null) {
                    peripheralManager = new PeripheralManager();
                    sInstance = peripheralManager;
                }
            }
        }
        return peripheralManager;
    }

    public synchronized boolean init(Context context) throws SdkUnsupportedException {
        SdkLog.m8381c(TAG, "init");
        if (this.mService != null) {
            return true;
        }
        this.mContext = context.getApplicationContext();
        initAFMAccessory(this.mContext);
        this.mPackageName = this.mContext.getPackageName();
        if (bindServiceSync(this.mContext)) {
            return this.mService != null;
        }
        return false;
    }

    public void initAsync(Context context, IManagerCallback iManagerCallback) throws SdkUnsupportedException {
        SdkLog.m8381c(TAG, "initAsync");
        if (this.mService != null) {
            iManagerCallback.onInited();
            return;
        }
        this.mContext = context.getApplicationContext();
        initAFMAccessory(this.mContext);
        this.mPackageName = this.mContext.getPackageName();
        synchronized (this.mManagerCallbackSet) {
            this.mManagerCallbackSet.add(new BaseManager.C2196a(iManagerCallback));
        }
        if (bindService(this.mContext)) {
            return;
        }
        SdkLog.m8383e(TAG, "initAsync, bind ScanService failed");
        onSubServiceDisconnected();
    }

    public synchronized void release(Context context) {
        release();
    }

    public synchronized void release() {
        SdkLog.m8381c(TAG, "release");
        if (this.mContext != null) {
            this.mContext.unbindService(this);
        }
        this.mService = null;
        this.mContext = null;
        synchronized (this.mManagerCallbackSet) {
            this.mManagerCallbackSet.clear();
        }
    }

    public int startAdvertise(AdvertiseSetting advertiseSetting, final IPeplCallback iPeplCallback) throws DiscoveryException {
        if (advertiseSetting == null) {
            throw DiscoveryException.create(3, "setting shouldn't be null");
        }
        if (iPeplCallback == null) {
            throw DiscoveryException.create(3, "callback shouldn't be null");
        }
        final AdvertiseSetting advertiseSettingRebuildSetting = rebuildSetting(advertiseSetting);
        advertiseSettingRebuildSetting.setServiceVersion(getServiceVersion());
        if (this.mService != null) {
            startAdvertisingInternal(advertiseSettingRebuildSetting, iPeplCallback);
            return 0;
        }
        Context context = this.mContext;
        if (context != null) {
            runOnBackGround(context, new IJob() { // from class: com.heytap.accessory.discovery.PeripheralManager.1
                @Override // com.heytap.accessory.discovery.IJob
                /* renamed from: PlatformImplementations.kt_3 */
                public final void mo8625a() {
                    PeripheralManager.this.startAdvertisingInternal(advertiseSettingRebuildSetting, iPeplCallback);
                }
            });
            return 0;
        }
        throw DiscoveryException.create(2, "startAdvertise failed, service and context is null");
    }

    public void stopAdvertise() throws DiscoveryException {
        if (this.mService != null) {
            stopAdvertisingInternal();
            return;
        }
        Context context = this.mContext;
        if (context != null) {
            runOnBackGround(context, new IJob() { // from class: com.heytap.accessory.discovery.PeripheralManager.2
                @Override // com.heytap.accessory.discovery.IJob
                /* renamed from: PlatformImplementations.kt_3 */
                public final void mo8625a() {
                    PeripheralManager.this.stopAdvertisingInternal();
                }
            });
            return;
        }
        throw DiscoveryException.create(2, "stopAdvertise failed, service and context is null");
    }

    public boolean responseConnect(DeviceInfo deviceInfo, int OplusGLSurfaceView_13) throws DiscoveryException {
        SdkLog.m8381c(TAG, "responseConnect, deviceInfo: " + deviceInfo + ", result: " + OplusGLSurfaceView_13);
        if (deviceInfo == null) {
            throw DiscoveryException.create(3, "deviceInfo shouldn't be null");
        }
        if (OplusGLSurfaceView_13 <= 0 || OplusGLSurfaceView_13 > 4) {
            throw DiscoveryException.create(3, "unknown connect result: ".concat(String.valueOf(OplusGLSurfaceView_13)));
        }
        if (this.mService == null) {
            throw DiscoveryException.create(2, "responseConnect failed, service is null");
        }
        try {
            this.mService.mo8510a(deviceInfo, OplusGLSurfaceView_13);
            return true;
        } catch (Exception COUIBaseListPopupWindow_8) {
            SdkLog.m8380b(TAG, COUIBaseListPopupWindow_8);
            throw DiscoveryException.create(1, COUIBaseListPopupWindow_8.getMessage());
        }
    }

    public boolean responseAuthenticate(DeviceInfo deviceInfo, boolean z) throws DiscoveryException {
        SdkLog.m8381c(TAG, "responseAuthenticate, deviceInfo: " + deviceInfo + ", agree: " + z);
        if (deviceInfo == null) {
            throw DiscoveryException.create(3, "deviceInfo shouldn't be null");
        }
        if (this.mService == null) {
            throw DiscoveryException.create(2, "responseAuthenticate failed, service is null");
        }
        try {
            this.mService.mo8511a(deviceInfo, z);
            return true;
        } catch (Exception COUIBaseListPopupWindow_8) {
            SdkLog.m8380b(TAG, COUIBaseListPopupWindow_8);
            throw DiscoveryException.create(1, COUIBaseListPopupWindow_8.getMessage());
        }
    }

    public void createGroup(IPeplCallback iPeplCallback) throws DiscoveryException {
        SdkLog.m8381c(TAG, "disable createGroup without debug");
    }

    class PeripheralCallbackNative extends IPeripheralCallback.Stub {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final IPeplCallback f9543b;

        PeripheralCallbackNative(IPeplCallback iPeplCallback) {
            this.f9543b = iPeplCallback;
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8501a(Message message) throws RemoteException {
            PeripheralManager.this.mPreRdi = message.getBundle().getByteArray(Message.KEY_MSG_RDI);
            StringBuilder sb = new StringBuilder("onAdvertiseSuccess preRdi : ");
            sb.append(PeripheralManager.this.mPreRdi != null ? HexUtils.m8586a(PeripheralManager.this.mPreRdi) : null);
            SdkLog.m8378b(PeripheralManager.TAG, sb.toString());
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8497a() throws RemoteException {
            SdkLog.m8381c(PeripheralManager.TAG, "onAdvertiseSuccess");
            try {
                this.f9543b.onAdvertiseSuccess();
            } catch (Exception COUIBaseListPopupWindow_8) {
                SdkLog.m8380b(PeripheralManager.TAG, COUIBaseListPopupWindow_8);
            }
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8498a(int OplusGLSurfaceView_13) throws RemoteException {
            SdkLog.m8381c(PeripheralManager.TAG, "onAdvertiseFailure, err: ".concat(String.valueOf(OplusGLSurfaceView_13)));
            try {
                this.f9543b.onAdvertiseFailure();
            } catch (Exception COUIBaseListPopupWindow_8) {
                SdkLog.m8380b(PeripheralManager.TAG, COUIBaseListPopupWindow_8);
            }
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo8502b() throws RemoteException {
            try {
                this.f9543b.onAdvertiseStopped();
            } catch (Exception COUIBaseListPopupWindow_8) {
                SdkLog.m8380b(PeripheralManager.TAG, COUIBaseListPopupWindow_8);
            }
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8500a(DeviceInfo deviceInfo, Message message) throws RemoteException {
            Bundle bundle = message.getBundle();
            if (bundle == null) {
                SdkLog.m8383e(PeripheralManager.TAG, "onRequestConnect failed, bundle is null");
                return;
            }
            try {
                this.f9543b.onRequestConnect(deviceInfo, new ConnectMessage(bundle.getByteArray(Message.KEY_MSG_CONNECT_DATA)));
            } catch (Exception COUIBaseListPopupWindow_8) {
                SdkLog.m8380b(PeripheralManager.TAG, COUIBaseListPopupWindow_8);
            }
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo8503b(DeviceInfo deviceInfo, Message message) throws RemoteException {
            Bundle bundle = message.getBundle();
            if (bundle == null) {
                SdkLog.m8383e(PeripheralManager.TAG, "onRequestAuthenticate failed, bundle is null");
                return;
            }
            try {
                this.f9543b.onRequestAuthenticate(deviceInfo, new AuthenticateMessage(bundle.getByteArray(Message.KEY_MSG_AUTH_DATA)));
            } catch (Exception COUIBaseListPopupWindow_8) {
                SdkLog.m8380b(PeripheralManager.TAG, COUIBaseListPopupWindow_8);
            }
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8499a(DeviceInfo deviceInfo) throws RemoteException {
            try {
                this.f9543b.onPairSuccess(deviceInfo);
            } catch (Exception COUIBaseListPopupWindow_8) {
                SdkLog.m8380b(PeripheralManager.TAG, COUIBaseListPopupWindow_8);
            }
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo8504c(DeviceInfo deviceInfo, Message message) throws RemoteException {
            Bundle bundle = message.getBundle();
            if (bundle == null) {
                SdkLog.m8383e(PeripheralManager.TAG, "onPairFailure failed, bundle is null");
                return;
            }
            try {
                this.f9543b.onPairFailure(deviceInfo, bundle.getInt(Message.KEY_MSG_ERROR_CODE));
            } catch (Exception COUIBaseListPopupWindow_8) {
                SdkLog.m8380b(PeripheralManager.TAG, COUIBaseListPopupWindow_8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAdvertisingInternal(AdvertiseSetting advertiseSetting, IPeplCallback iPeplCallback) {
        SdkLog.m8381c(TAG, "startAdvertisingInternal");
        if (this.mService == null) {
            SdkLog.m8383e(TAG, "service is null");
            return;
        }
        try {
            this.mService.mo8509a(advertiseSetting, new PeripheralCallbackNative(iPeplCallback));
        } catch (Exception COUIBaseListPopupWindow_8) {
            SdkLog.m8380b(TAG, COUIBaseListPopupWindow_8);
            iPeplCallback.onAdvertiseFailure();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopAdvertisingInternal() {
        if (this.mService == null) {
            SdkLog.m8383e(TAG, "service is null");
            return;
        }
        try {
            this.mService.mo8507a();
        } catch (Exception COUIBaseListPopupWindow_8) {
            SdkLog.m8380b(TAG, COUIBaseListPopupWindow_8);
        }
    }

    private synchronized boolean bindServiceSync(Context context) {
        String str;
        String str2;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!bindService(context)) {
            SdkLog.m8383e(TAG, "bindServiceSync failed");
            return false;
        }
        try {
            try {
                wait(9000L);
                str = TAG;
                str2 = "bind service cost: " + (System.currentTimeMillis() - jCurrentTimeMillis);
            } catch (InterruptedException COUIBaseListPopupWindow_8) {
                SdkLog.m8383e(TAG, "bindServiceSync failed, InterruptedException: " + COUIBaseListPopupWindow_8.getMessage());
                COUIBaseListPopupWindow_8.printStackTrace();
                str = TAG;
                str2 = "bind service cost: " + (System.currentTimeMillis() - jCurrentTimeMillis);
            }
            SdkLog.m8381c(str, str2);
            return true;
        } catch (Throwable th) {
            SdkLog.m8381c(TAG, "bind service cost: " + (System.currentTimeMillis() - jCurrentTimeMillis));
            throw th;
        }
    }

    private boolean bindService(Context context) {
        if (this.mService != null) {
            SdkLog.m8381c(TAG, "already bind service");
            return true;
        }
        Intent intent = new Intent(AFConstants.SCAN_SERVICE_INTENT);
        intent.setPackage(ManagerConfig.ACCESSORY_FRAMEWORK_PACKAGE);
        intent.putExtra(AFConstants.KEY_SUB_SERVICE, 2);
        return context.bindService(intent, this, 1);
    }

    private AdvertiseSetting rebuildSetting(AdvertiseSetting advertiseSetting) {
        AdvertiseSetting.Builder builder = new AdvertiseSetting.Builder();
        if (this.mPreRdi == null) {
            return advertiseSetting;
        }
        builder.setAdditionData(advertiseSetting.getAdditionData()).setAdvertiseMode(advertiseSetting.getAdvertiseMode()).setAdvertiseType(advertiseSetting.getAdvertiseType()).setConnectType(advertiseSetting.getConnectType()).setDurationMillis(advertiseSetting.getDurationMillis()).setGoIntent(advertiseSetting.getGoIntent()).setIsCancelAdv(advertiseSetting.getIsCancelAdv()).setKeyType(advertiseSetting.getKeyType()).setMajor(advertiseSetting.getMajor()).setModelId(advertiseSetting.getModelId()).setNickName(advertiseSetting.getNickName()).setPort(advertiseSetting.getPort());
        byte[] bArr = {0, 0, 0, 0, 0, 0};
        if (advertiseSetting.getRdi() == null || Arrays.equals(advertiseSetting.getRdi(), bArr)) {
            builder.setRdi(this.mPreRdi);
        } else {
            builder.setRdi(advertiseSetting.getRdi());
        }
        return builder.build();
    }
}
