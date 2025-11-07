package com.heytap.accessory.discovery;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.heytap.accessory.Config;
import com.heytap.accessory.api.ICentralService;
import com.heytap.accessory.api.IDirectPairCallback;
import com.heytap.accessory.api.IDisPairCallback;
import com.heytap.accessory.api.IDisScanCallback;
import com.heytap.accessory.api.IDiscoveryNativeService;
import com.heytap.accessory.api.ILanCacheIpServiceCallback;
import com.heytap.accessory.api.INsdDevicesCallback;
import com.heytap.accessory.api.IPermissionCallback;
import com.heytap.accessory.api.ManagerConfig;
import com.heytap.accessory.bean.DeviceInfo;
import com.heytap.accessory.bean.DirectPairInfo;
import com.heytap.accessory.bean.DiscoveryException;
import com.heytap.accessory.bean.Message;
import com.heytap.accessory.bean.PairSetting;
import com.heytap.accessory.bean.ScanSetting;
import com.heytap.accessory.bean.SdkUnsupportedException;
import com.heytap.accessory.constant.AFConstants;
import com.heytap.accessory.discovery.BaseManager;
import com.heytap.accessory.p103a.SdkLog;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/* loaded from: classes2.dex */
public class CentralManager extends BaseManager {
    public static final int AUTHENTICATION_MODE_CUSTOMIZE = 2;
    public static final int AUTHENTICATION_MODE_PIN = 1;
    public static final int ERROR_AUTHENTICATION_FAILED = -1;
    public static final int ERROR_DEVICE = -2;
    public static final int ERROR_NONE = 0;
    public static final int ERROR_PAIR_CONNECT_FAILED = -3;
    private static final String PREFIX = "ctl_";
    private static final String TAG = "CentralManager";
    private static volatile CentralManager sInstance;
    private Context mContext;
    private final Set<BaseManager.C2196a> mManagerCallbackSet = new HashSet();
    private String mPackageName;
    private volatile ICentralService mService;

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

    private CentralManager() {
    }

    public static CentralManager getInstance() {
        if (sInstance == null) {
            synchronized (CentralManager.class) {
                if (sInstance == null) {
                    sInstance = new CentralManager();
                }
            }
        }
        return sInstance;
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
                this.mService = iDiscoveryNativeService.mo8447a();
                notifyAll();
            } catch (RemoteException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        }
        List.of();
        synchronized (this.mManagerCallbackSet) {
            list = (List) this.mManagerCallbackSet.stream().filter(new Predicate() { // from class: com.heytap.accessory.discovery.-$$Lambda$CentralManager$RexlCtuHx2Grww1FiUYykr8VhcM
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return CentralManager.lambda$onSubServiceConnected$0((BaseManager.C2196a) obj);
                }
            }).map(new Function() { // from class: com.heytap.accessory.discovery.-$$Lambda$CentralManager$MGKx_lPPrfGOX3h9iad0BOKGRcE
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
            list = (List) this.mManagerCallbackSet.stream().map(new Function() { // from class: com.heytap.accessory.discovery.-$$Lambda$CentralManager$solQWTHdIRfSIlj_yFef7AL3Jhg
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
        if (this.mService == null) {
            return;
        }
        this.mContext.unbindService(this);
        this.mService = null;
        this.mContext = null;
        synchronized (this.mManagerCallbackSet) {
            this.mManagerCallbackSet.clear();
        }
    }

    public int startScan(final ScanSetting scanSetting, final List<IScanFilter> list, final IScanCallback iScanCallback) throws DiscoveryException {
        if (scanSetting == null) {
            throw DiscoveryException.create(3, "setting shouldn't be null");
        }
        if (iScanCallback == null) {
            throw DiscoveryException.create(2, "startScan failed, callback is null");
        }
        if (this.mService != null) {
            return startScanInternal(scanSetting, list, iScanCallback);
        }
        Context context = this.mContext;
        if (context != null) {
            runOnBackGround(context, new IJob() { // from class: com.heytap.accessory.discovery.CentralManager.1
                @Override // com.heytap.accessory.discovery.IJob
                /* renamed from: PlatformImplementations.kt_3 */
                public final void mo8625a() {
                    CentralManager.this.startScanInternal(scanSetting, list, iScanCallback);
                }
            });
            return 0;
        }
        throw DiscoveryException.create(2, "startScan failed, service and context is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int startScanInternal(ScanSetting scanSetting, List<IScanFilter> list, IScanCallback iScanCallback) {
        int iMo8419a;
        if (this.mService == null) {
            SdkLog.m8383e(TAG, "service is null");
            return 1;
        }
        try {
            iMo8419a = this.mService.mo8419a(scanSetting, packFilterBundle(list), new ScanCallbackNative(iScanCallback));
        } catch (Exception COUIBaseListPopupWindow_8) {
            SdkLog.m8380b(TAG, COUIBaseListPopupWindow_8);
            iMo8419a = 2;
        }
        if (iMo8419a != 0) {
            SdkLog.m8383e(TAG, "startScan failed, err: ".concat(String.valueOf(iMo8419a)));
            iScanCallback.onCancel();
        }
        return iMo8419a;
    }

    public void cancelScan() throws DiscoveryException {
        if (this.mService != null) {
            cancelScanInternal();
            return;
        }
        Context context = this.mContext;
        if (context != null) {
            runOnBackGround(context, new IJob() { // from class: com.heytap.accessory.discovery.CentralManager.2
                @Override // com.heytap.accessory.discovery.IJob
                /* renamed from: PlatformImplementations.kt_3 */
                public final void mo8625a() {
                    CentralManager.this.cancelScanInternal();
                }
            });
            return;
        }
        throw DiscoveryException.create(2, "cancelScan failed, service and context is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelScanInternal() {
        if (this.mService == null) {
            SdkLog.m8383e(TAG, "service is null");
            return;
        }
        try {
            this.mService.mo8420a();
        } catch (Exception COUIBaseListPopupWindow_8) {
            SdkLog.m8380b(TAG, COUIBaseListPopupWindow_8);
        }
    }

    public int earlyPair(DeviceInfo deviceInfo) throws DiscoveryException {
        if (deviceInfo == null) {
            throw DiscoveryException.create(3, "deviceInfo shouldn't be null");
        }
        if (this.mService != null) {
            return earlyPairInternal(deviceInfo);
        }
        throw DiscoveryException.create(2, "earlyPair failed, service and context is null");
    }

    private int earlyPairInternal(DeviceInfo deviceInfo) {
        int iMo8428b;
        if (this.mService == null) {
            SdkLog.m8383e(TAG, "service is null");
            return 1;
        }
        try {
            iMo8428b = this.mService.mo8428b(deviceInfo);
        } catch (Exception COUIBaseListPopupWindow_8) {
            SdkLog.m8380b(TAG, COUIBaseListPopupWindow_8);
            iMo8428b = 7;
        }
        if (iMo8428b != 0) {
            SdkLog.m8383e(TAG, "earlyPair failed, err: ".concat(String.valueOf(iMo8428b)));
        }
        return iMo8428b;
    }

    public int startPair(DeviceInfo deviceInfo, IPairCallback iPairCallback) throws DiscoveryException {
        return startPair(new PairSetting.Builder().build(), deviceInfo, iPairCallback);
    }

    public int startPair(PairSetting pairSetting, DeviceInfo deviceInfo, IPairCallback iPairCallback) throws DiscoveryException {
        SdkLog.m8381c(TAG, "startPair, deviceInfo: ".concat(String.valueOf(deviceInfo)));
        if (pairSetting == null) {
            throw DiscoveryException.create(3, "setting shouldn't be null");
        }
        if (deviceInfo == null) {
            throw DiscoveryException.create(3, "deviceInfo shouldn't be null");
        }
        if (iPairCallback == null) {
            throw DiscoveryException.create(3, "callback shouldn't be null");
        }
        if (this.mService != null) {
            return startPairInternal(pairSetting, deviceInfo, iPairCallback);
        }
        throw DiscoveryException.create(2, "startPair failed, service and context is null");
    }

    private int startPairInternal(PairSetting pairSetting, DeviceInfo deviceInfo, IPairCallback iPairCallback) {
        int iMo8418a;
        if (this.mService == null) {
            SdkLog.m8383e(TAG, "service is null");
            return 1;
        }
        try {
            iMo8418a = this.mService.mo8418a(pairSetting, deviceInfo, new PairCallbackNative(iPairCallback));
        } catch (Exception COUIBaseListPopupWindow_8) {
            SdkLog.m8380b(TAG, COUIBaseListPopupWindow_8);
            iMo8418a = 7;
        }
        if (iMo8418a != 0) {
            SdkLog.m8383e(TAG, "startPair failed, err: ".concat(String.valueOf(iMo8418a)));
            Bundle bundle = new Bundle();
            bundle.putInt(Message.KEY_MSG_ERROR_CODE, iMo8418a);
            iPairCallback.onPairFailure(deviceInfo, bundle);
        }
        return iMo8418a;
    }

    public void cancelPair(final DeviceInfo deviceInfo) throws DiscoveryException {
        SdkLog.m8381c(TAG, "cancelPair, deviceInfo: ".concat(String.valueOf(deviceInfo)));
        if (deviceInfo == null) {
            throw DiscoveryException.create(3, "deviceInfo shouldn't be null");
        }
        if (this.mService != null) {
            cancelPairInternal(deviceInfo);
            return;
        }
        Context context = this.mContext;
        if (context != null) {
            runOnBackGround(context, new IJob() { // from class: com.heytap.accessory.discovery.CentralManager.3
                @Override // com.heytap.accessory.discovery.IJob
                /* renamed from: PlatformImplementations.kt_3 */
                public final void mo8625a() {
                    CentralManager.this.cancelPairInternal(deviceInfo);
                }
            });
            return;
        }
        throw DiscoveryException.create(2, "cancelPair failed, service and context is null");
    }

    public void checkLocationIsAvailable(IPermissionGrantCallback interfaceC2206c) throws DiscoveryException {
        SdkLog.m8381c(TAG, "checkPresentIsAvailable");
        if (interfaceC2206c == null) {
            throw DiscoveryException.create(3, "grantCallback shouldn't be null");
        }
        if (this.mService != null) {
            checkLocationIsAvailableInternal(interfaceC2206c);
            return;
        }
        throw DiscoveryException.create(2, "checkLocationIsAvailable fail");
    }

    private void checkLocationIsAvailableInternal(IPermissionGrantCallback interfaceC2206c) {
        if (this.mService == null) {
            SdkLog.m8383e(TAG, "service is null");
            return;
        }
        try {
            this.mService.mo8424a(new GrantPermissionCallbackNative(interfaceC2206c));
        } catch (Exception COUIBaseListPopupWindow_8) {
            SdkLog.m8380b(TAG, COUIBaseListPopupWindow_8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelPairInternal(DeviceInfo deviceInfo) {
        if (this.mService == null) {
            SdkLog.m8383e(TAG, "service is null");
            return;
        }
        try {
            this.mService.mo8425a(deviceInfo);
        } catch (Exception COUIBaseListPopupWindow_8) {
            SdkLog.m8380b(TAG, COUIBaseListPopupWindow_8);
        }
    }

    public void enableDiscoverability(final int OplusGLSurfaceView_13, final boolean z) throws DiscoveryException {
        SdkLog.m8381c(TAG, "enableDiscoverability, major: " + OplusGLSurfaceView_13 + ", enable: " + z);
        if (this.mService != null) {
            enableDiscoverabilityInternal(OplusGLSurfaceView_13, z);
            return;
        }
        Context context = this.mContext;
        if (context != null) {
            runOnBackGround(context, new IJob() { // from class: com.heytap.accessory.discovery.CentralManager.4
                @Override // com.heytap.accessory.discovery.IJob
                /* renamed from: PlatformImplementations.kt_3 */
                public final void mo8625a() {
                    CentralManager.this.enableDiscoverabilityInternal(OplusGLSurfaceView_13, z);
                }
            });
            return;
        }
        throw DiscoveryException.create(2, "enableDiscoverability failed, service and context is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enableDiscoverabilityInternal(int OplusGLSurfaceView_13, boolean z) {
        if (this.mService == null) {
            SdkLog.m8383e(TAG, "service is null");
            return;
        }
        try {
            this.mService.mo8421a(OplusGLSurfaceView_13, z);
        } catch (Exception COUIBaseListPopupWindow_8) {
            SdkLog.m8380b(TAG, COUIBaseListPopupWindow_8);
        }
    }

    public boolean checkDiscoverability(int OplusGLSurfaceView_13) throws DiscoveryException {
        if (this.mService == null) {
            throw DiscoveryException.create(2, "checkDiscoverability failed, service is null");
        }
        try {
            return this.mService.mo8427a(OplusGLSurfaceView_13);
        } catch (Exception COUIBaseListPopupWindow_8) {
            SdkLog.m8380b(TAG, COUIBaseListPopupWindow_8);
            throw DiscoveryException.create(1, COUIBaseListPopupWindow_8.getMessage());
        }
    }

    public int directPair(final DirectPairInfo directPairInfo, final IDirectCallback iDirectCallback) throws DiscoveryException {
        if (directPairInfo == null) {
            throw DiscoveryException.create(3, "directPairInfo shouldn't be null");
        }
        if (iDirectCallback == null) {
            throw DiscoveryException.create(3, "callback shouldn't be null");
        }
        if (this.mService != null) {
            return directPairInternal(directPairInfo, iDirectCallback);
        }
        Context context = this.mContext;
        if (context != null) {
            runOnBackGround(context, new IJob() { // from class: com.heytap.accessory.discovery.CentralManager.5
                @Override // com.heytap.accessory.discovery.IJob
                /* renamed from: PlatformImplementations.kt_3 */
                public final void mo8625a() {
                    CentralManager.this.directPairInternal(directPairInfo, iDirectCallback);
                }
            });
            return 0;
        }
        throw DiscoveryException.create(2, "directPair failed, service is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int directPairInternal(DirectPairInfo directPairInfo, IDirectCallback iDirectCallback) {
        int iMo8417a;
        if (this.mService == null) {
            SdkLog.m8383e(TAG, "service is null");
            return 1;
        }
        try {
            iMo8417a = this.mService.mo8417a(directPairInfo, new DirectPairCallbackNative(iDirectCallback));
        } catch (Exception COUIBaseListPopupWindow_8) {
            SdkLog.m8380b(TAG, COUIBaseListPopupWindow_8);
            iMo8417a = 7;
        }
        if (iMo8417a != 0) {
            SdkLog.m8383e(TAG, "directPair failed, err: ".concat(String.valueOf(iMo8417a)));
            Message message = new Message();
            message.getBundle().putInt(Message.KEY_MSG_ERROR_CODE, iMo8417a);
            iDirectCallback.onPairFailure(new DeviceInfo(), message);
        }
        return iMo8417a;
    }

    public void getLanCacheIp(String str, ILanCacheIpCallback interfaceC2204a) throws DiscoveryException {
        if (this.mService == null) {
            throw DiscoveryException.create(2, "directPair failed, service is null");
        }
        try {
            this.mService.mo8426a(str, new ILanCacheIpNative(interfaceC2204a));
        } catch (Exception COUIBaseListPopupWindow_8) {
            SdkLog.m8380b(TAG, COUIBaseListPopupWindow_8);
        }
    }

    public void findPairedLanDevices(ILanPairedDevicesCallback interfaceC2205b) throws DiscoveryException {
        if (this.mService == null) {
            throw DiscoveryException.create(2, "directPair failed, service is null");
        }
        try {
            this.mService.mo8423a(new INsdDevicesNative(interfaceC2205b));
        } catch (Exception COUIBaseListPopupWindow_8) {
            SdkLog.m8380b(TAG, COUIBaseListPopupWindow_8);
        }
    }

    private Bundle packFilterBundle(List<IScanFilter> list) {
        Bundle bundle = new Bundle();
        if (list != null) {
            for (IScanFilter iScanFilter : list) {
                bundle.putParcelable(iScanFilter.getKey(), iScanFilter);
            }
        }
        return bundle;
    }

    private boolean bindService(Context context) {
        if (this.mService != null) {
            SdkLog.m8381c(TAG, "already bind service");
            return true;
        }
        Intent intent = new Intent(AFConstants.SCAN_SERVICE_INTENT);
        intent.setPackage(ManagerConfig.ACCESSORY_FRAMEWORK_PACKAGE);
        intent.putExtra(AFConstants.KEY_SUB_SERVICE, 1);
        return context.bindService(intent, this, 1);
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

    static class DirectPairCallbackNative extends IDirectPairCallback.Stub {

        /* renamed from: PlatformImplementations.kt_3 */
        private final IDirectCallback f9528a;

        DirectPairCallbackNative(IDirectCallback iDirectCallback) {
            this.f9528a = iDirectCallback;
        }

        @Override // com.heytap.accessory.api.IDirectPairCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8433a(DeviceInfo deviceInfo, Message message) throws RemoteException {
            this.f9528a.onPairSuccess(deviceInfo, message);
        }

        @Override // com.heytap.accessory.api.IDirectPairCallback
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo8434b(DeviceInfo deviceInfo, Message message) throws RemoteException {
            this.f9528a.onPairFailure(deviceInfo, message);
        }
    }

    class ScanCallbackNative extends IDisScanCallback.Stub {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final IScanCallback f9536b;

        ScanCallbackNative(IScanCallback iScanCallback) {
            this.f9536b = iScanCallback;
        }

        @Override // com.heytap.accessory.api.IDisScanCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8443a(DeviceInfo deviceInfo) throws RemoteException {
            try {
                this.f9536b.onDeviceFound(deviceInfo);
            } catch (Exception COUIBaseListPopupWindow_8) {
                SdkLog.m8380b(CentralManager.TAG, COUIBaseListPopupWindow_8);
            }
        }

        @Override // com.heytap.accessory.api.IDisScanCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8442a() throws RemoteException {
            try {
                this.f9536b.onCancel();
            } catch (Exception COUIBaseListPopupWindow_8) {
                SdkLog.m8380b(CentralManager.TAG, COUIBaseListPopupWindow_8);
            }
        }
    }

    class PairCallbackNative extends IDisPairCallback.Stub {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final IPairCallback f9534b;

        PairCallbackNative(IPairCallback iPairCallback) {
            this.f9534b = iPairCallback;
        }

        @Override // com.heytap.accessory.api.IDisPairCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8437a(DeviceInfo deviceInfo, Message message) throws RemoteException {
            SdkLog.m8381c(CentralManager.TAG, "onPairSuccess, deviceInfo: ".concat(String.valueOf(deviceInfo)));
            try {
                this.f9534b.onPairSuccess(deviceInfo, message.getBundle());
            } catch (Exception COUIBaseListPopupWindow_8) {
                SdkLog.m8380b(CentralManager.TAG, COUIBaseListPopupWindow_8);
            }
        }

        @Override // com.heytap.accessory.api.IDisPairCallback
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo8438b(DeviceInfo deviceInfo, Message message) throws RemoteException {
            SdkLog.m8381c(CentralManager.TAG, "onPairMessage, deviceInfo: ".concat(String.valueOf(deviceInfo)));
            Bundle bundle = message.getBundle();
            if (bundle == null) {
                SdkLog.m8383e(CentralManager.TAG, "onPairMessage failed, bundle is null");
                return;
            }
            bundle.putInt(Message.SDK_VERSION, Config.getSdkVersionCode());
            try {
                int fpCoreVersion = CentralManager.this.getFpCoreVersion();
                SdkLog.m8381c(CentralManager.TAG, "getFpCoreVersion: ".concat(String.valueOf(fpCoreVersion)));
                if (fpCoreVersion < 10200) {
                    bundle.putByteArray(Message.KEY_MSG_AUTH_DATA, this.f9534b.onPairData(deviceInfo, bundle));
                    return;
                }
                if (fpCoreVersion >= 10200) {
                    if (!bundle.containsKey(Message.KEY_MSG_AUTH_MODE) && !bundle.containsKey(Message.KEY_MSG_AUTH_LIMIT_LENGTH)) {
                        if (bundle.containsKey(Message.KEY_MSG_TYPE_PAIR_TYPE_RECEIVED)) {
                            bundle.putInt(Message.KEY_MSG_TYPE_PAIR_TYPE_RECEIVED, this.f9534b.onPairTypeReceived(deviceInfo, bundle));
                            return;
                        }
                        return;
                    }
                    bundle.putByteArray(Message.KEY_MSG_AUTH_DATA, this.f9534b.onPairData(deviceInfo, bundle));
                }
            } catch (Exception COUIBaseListPopupWindow_8) {
                SdkLog.m8380b(CentralManager.TAG, COUIBaseListPopupWindow_8);
            }
        }

        @Override // com.heytap.accessory.api.IDisPairCallback
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo8439c(DeviceInfo deviceInfo, Message message) throws RemoteException {
            SdkLog.m8381c(CentralManager.TAG, "onPairFailure, deviceInfo: ".concat(String.valueOf(deviceInfo)));
            try {
                this.f9534b.onPairFailure(deviceInfo, message.getBundle());
            } catch (Exception COUIBaseListPopupWindow_8) {
                SdkLog.m8380b(CentralManager.TAG, COUIBaseListPopupWindow_8);
            }
        }
    }

    class GrantPermissionCallbackNative extends IPermissionCallback.Stub {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final IPermissionGrantCallback f9530b;

        GrantPermissionCallbackNative(IPermissionGrantCallback interfaceC2206c) {
            this.f9530b = interfaceC2206c;
        }

        @Override // com.heytap.accessory.api.IPermissionCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8514a() throws RemoteException {
            this.f9530b.m8628a();
        }

        @Override // com.heytap.accessory.api.IPermissionCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8515a(int OplusGLSurfaceView_13) throws RemoteException {
            this.f9530b.m8629a(OplusGLSurfaceView_13);
        }
    }

    static class ILanCacheIpNative extends ILanCacheIpServiceCallback.Stub {

        /* renamed from: PlatformImplementations.kt_3 */
        private final ILanCacheIpCallback f9531a;

        ILanCacheIpNative(ILanCacheIpCallback interfaceC2204a) {
            this.f9531a = interfaceC2204a;
        }

        @Override // com.heytap.accessory.api.ILanCacheIpServiceCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8485a(DeviceInfo deviceInfo, Message message) throws RemoteException {
            this.f9531a.m8626a(deviceInfo, message);
        }
    }

    static class INsdDevicesNative extends INsdDevicesCallback.Stub {

        /* renamed from: PlatformImplementations.kt_3 */
        private final ILanPairedDevicesCallback f9532a;

        INsdDevicesNative(ILanPairedDevicesCallback interfaceC2205b) {
            this.f9532a = interfaceC2205b;
        }

        @Override // com.heytap.accessory.api.INsdDevicesCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8490a(List<DeviceInfo> list) throws RemoteException {
            this.f9532a.m8627a(list);
        }
    }

    public void saveModelId(byte[] bArr, byte[] bArr2) {
        try {
            SdkLog.m8381c(TAG, "save modelId and remoteDeviceId");
            Bundle bundle = new Bundle();
            bundle.putInt(AFConstants.KEY_BUSINESS_TYPE, 1);
            bundle.putByteArray(AFConstants.KEY_MODEL_ID, bArr2);
            bundle.putByteArray(AFConstants.KEY_REMOTE_DEVICE_ID, bArr);
            this.mService.mo8422a(bundle);
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            SdkLog.m8383e(TAG, COUIBaseListPopupWindow_8.toString());
            COUIBaseListPopupWindow_8.printStackTrace();
        }
    }
}
