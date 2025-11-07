package com.heytap.accessory.discovery;

/* loaded from: classes2.dex */
public class CentralManager extends com.heytap.accessory.discovery.BaseManager {
    public static final int AUTHENTICATION_MODE_CUSTOMIZE = 2;
    public static final int AUTHENTICATION_MODE_PIN = 1;
    public static final int ERROR_AUTHENTICATION_FAILED = -1;
    public static final int ERROR_DEVICE = -2;
    public static final int ERROR_NONE = 0;
    public static final int ERROR_PAIR_CONNECT_FAILED = -3;
    private static final java.lang.String PREFIX = "ctl_";
    private static final java.lang.String TAG = "CentralManager";
    private static volatile com.heytap.accessory.discovery.CentralManager sInstance;
    private android.content.Context mContext;
    private final java.util.Set<com.heytap.accessory.discovery.BaseManager.a_renamed> mManagerCallbackSet = new java.util.HashSet();
    private java.lang.String mPackageName;
    private volatile com.heytap.accessory.api.ICentralService mService;

    @Override // com.heytap.accessory.discovery.BaseManager
    public /* bridge */ /* synthetic */ int getFpCoreVersion() {
        return super.getFpCoreVersion();
    }

    @Override // com.heytap.accessory.discovery.BaseManager
    public /* bridge */ /* synthetic */ int getServiceVersion() {
        return super.getServiceVersion();
    }

    @Override // com.heytap.accessory.discovery.BaseManager, android.content.ServiceConnection
    public /* bridge */ /* synthetic */ void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
        super.onServiceConnected(componentName, iBinder);
    }

    @Override // com.heytap.accessory.discovery.BaseManager, android.content.ServiceConnection
    public /* bridge */ /* synthetic */ void onServiceDisconnected(android.content.ComponentName componentName) {
        super.onServiceDisconnected(componentName);
    }

    private CentralManager() {
    }

    public static com.heytap.accessory.discovery.CentralManager getInstance() {
        if (sInstance == null) {
            synchronized (com.heytap.accessory.discovery.CentralManager.class) {
                if (sInstance == null) {
                    sInstance = new com.heytap.accessory.discovery.CentralManager();
                }
            }
        }
        return sInstance;
    }

    @Override // com.heytap.accessory.discovery.BaseManager
    protected java.lang.String getPackageName() {
        return PREFIX + this.mPackageName;
    }

    @Override // com.heytap.accessory.discovery.BaseManager
    protected void onSubServiceConnected(com.heytap.accessory.api.IDiscoveryNativeService iDiscoveryNativeService) {
        java.util.List list;
        com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onSubServiceConnected");
        synchronized (this) {
            try {
                this.mService = iDiscoveryNativeService.a_renamed();
                notifyAll();
            } catch (android.os.RemoteException e_renamed) {
                e_renamed.printStackTrace();
            }
        }
        java.util.List.of_renamed();
        synchronized (this.mManagerCallbackSet) {
            list = (java.util.List) this.mManagerCallbackSet.stream().filter(new java.util.function.Predicate() { // from class: com.heytap.accessory.discovery.-$$Lambda$CentralManager$RexlCtuHx2Grww1FiUYykr8VhcM
                @Override // java.util.function.Predicate
                public final boolean test(java.lang.Object obj) {
                    return com.heytap.accessory.discovery.CentralManager.lambda$onSubServiceConnected$0((com.heytap.accessory.discovery.BaseManager.a_renamed) obj);
                }
            }).map(new java.util.function.Function() { // from class: com.heytap.accessory.discovery.-$$Lambda$CentralManager$MGKx_lPPrfGOX3h9iad0BOKGRcE
                @Override // java.util.function.Function
                public final java.lang.Object apply(java.lang.Object obj) {
                    return ((com.heytap.accessory.discovery.BaseManager.a_renamed) obj).f3284b;
                }
            }).collect(java.util.stream.Collectors.toList());
        }
        list.forEach(com.heytap.accessory.discovery.$$Lambda$jao6ooJJhKIvmFGirPbP16Y1xA.INSTANCE);
    }

    static /* synthetic */ boolean lambda$onSubServiceConnected$0(com.heytap.accessory.discovery.BaseManager.a_renamed aVar) {
        boolean z_renamed = !aVar.f3283a;
        aVar.f3283a = true;
        return z_renamed;
    }

    @Override // com.heytap.accessory.discovery.BaseManager
    protected void onSubServiceDisconnected() {
        java.util.List list;
        com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onSubServiceDisconnected");
        this.mService = null;
        java.util.List.of_renamed();
        synchronized (this.mManagerCallbackSet) {
            list = (java.util.List) this.mManagerCallbackSet.stream().map(new java.util.function.Function() { // from class: com.heytap.accessory.discovery.-$$Lambda$CentralManager$solQWTHdIRfSIlj_yFef7AL3Jhg
                @Override // java.util.function.Function
                public final java.lang.Object apply(java.lang.Object obj) {
                    return ((com.heytap.accessory.discovery.BaseManager.a_renamed) obj).f3284b;
                }
            }).collect(java.util.stream.Collectors.toList());
            this.mManagerCallbackSet.clear();
        }
        list.forEach(com.heytap.accessory.discovery.$$Lambda$x6LUMI97ky_K7TrH0qnHNFk4Ol8.INSTANCE);
    }

    @Override // com.heytap.accessory.discovery.BaseManager
    protected void onSubBindService(android.content.Context context) {
        bindServiceSync(context);
    }

    public synchronized boolean init(android.content.Context context) throws com.heytap.accessory.bean.SdkUnsupportedException {
        com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "init");
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

    public void initAsync(android.content.Context context, com.heytap.accessory.discovery.IManagerCallback iManagerCallback) throws com.heytap.accessory.bean.SdkUnsupportedException {
        com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "initAsync");
        if (this.mService != null) {
            iManagerCallback.onInited();
            return;
        }
        this.mContext = context.getApplicationContext();
        initAFMAccessory(this.mContext);
        this.mPackageName = this.mContext.getPackageName();
        synchronized (this.mManagerCallbackSet) {
            this.mManagerCallbackSet.add(new com.heytap.accessory.discovery.BaseManager.a_renamed(iManagerCallback));
        }
        if (bindService(this.mContext)) {
            return;
        }
        com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "initAsync, bind ScanService failed");
        onSubServiceDisconnected();
    }

    public synchronized void release(android.content.Context context) {
        release();
    }

    public synchronized void release() {
        com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "release");
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

    public int startScan(final com.heytap.accessory.bean.ScanSetting scanSetting, final java.util.List<com.heytap.accessory.discovery.IScanFilter> list, final com.heytap.accessory.discovery.IScanCallback iScanCallback) throws com.heytap.accessory.bean.DiscoveryException {
        if (scanSetting == null) {
            throw com.heytap.accessory.bean.DiscoveryException.create(3, "setting shouldn't_renamed be_renamed null");
        }
        if (iScanCallback == null) {
            throw com.heytap.accessory.bean.DiscoveryException.create(2, "startScan failed, callback is_renamed null");
        }
        if (this.mService != null) {
            return startScanInternal(scanSetting, list, iScanCallback);
        }
        android.content.Context context = this.mContext;
        if (context != null) {
            runOnBackGround(context, new com.heytap.accessory.discovery.d_renamed() { // from class: com.heytap.accessory.discovery.CentralManager.1
                @Override // com.heytap.accessory.discovery.d_renamed
                public final void a_renamed() {
                    com.heytap.accessory.discovery.CentralManager.this.startScanInternal(scanSetting, list, iScanCallback);
                }
            });
            return 0;
        }
        throw com.heytap.accessory.bean.DiscoveryException.create(2, "startScan failed, service and context is_renamed null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int startScanInternal(com.heytap.accessory.bean.ScanSetting scanSetting, java.util.List<com.heytap.accessory.discovery.IScanFilter> list, com.heytap.accessory.discovery.IScanCallback iScanCallback) {
        int iA;
        if (this.mService == null) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "service is_renamed null");
            return 1;
        }
        try {
            iA = this.mService.a_renamed(scanSetting, packFilterBundle(list), new com.heytap.accessory.discovery.CentralManager.ScanCallbackNative(iScanCallback));
        } catch (java.lang.Exception e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, e_renamed);
            iA = 2;
        }
        if (iA != 0) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "startScan failed, err: ".concat(java.lang.String.valueOf(iA)));
            iScanCallback.onCancel();
        }
        return iA;
    }

    public void cancelScan() throws com.heytap.accessory.bean.DiscoveryException {
        if (this.mService != null) {
            cancelScanInternal();
            return;
        }
        android.content.Context context = this.mContext;
        if (context != null) {
            runOnBackGround(context, new com.heytap.accessory.discovery.d_renamed() { // from class: com.heytap.accessory.discovery.CentralManager.2
                @Override // com.heytap.accessory.discovery.d_renamed
                public final void a_renamed() {
                    com.heytap.accessory.discovery.CentralManager.this.cancelScanInternal();
                }
            });
            return;
        }
        throw com.heytap.accessory.bean.DiscoveryException.create(2, "cancelScan failed, service and context is_renamed null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelScanInternal() {
        if (this.mService == null) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "service is_renamed null");
            return;
        }
        try {
            this.mService.a_renamed();
        } catch (java.lang.Exception e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, e_renamed);
        }
    }

    public int earlyPair(com.heytap.accessory.bean.DeviceInfo deviceInfo) throws com.heytap.accessory.bean.DiscoveryException {
        if (deviceInfo == null) {
            throw com.heytap.accessory.bean.DiscoveryException.create(3, "deviceInfo shouldn't_renamed be_renamed null");
        }
        if (this.mService != null) {
            return earlyPairInternal(deviceInfo);
        }
        throw com.heytap.accessory.bean.DiscoveryException.create(2, "earlyPair failed, service and context is_renamed null");
    }

    private int earlyPairInternal(com.heytap.accessory.bean.DeviceInfo deviceInfo) {
        int iB;
        if (this.mService == null) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "service is_renamed null");
            return 1;
        }
        try {
            iB = this.mService.b_renamed(deviceInfo);
        } catch (java.lang.Exception e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, e_renamed);
            iB = 7;
        }
        if (iB != 0) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "earlyPair failed, err: ".concat(java.lang.String.valueOf(iB)));
        }
        return iB;
    }

    public int startPair(com.heytap.accessory.bean.DeviceInfo deviceInfo, com.heytap.accessory.discovery.IPairCallback iPairCallback) throws com.heytap.accessory.bean.DiscoveryException {
        return startPair(new com.heytap.accessory.bean.PairSetting.Builder().build(), deviceInfo, iPairCallback);
    }

    public int startPair(com.heytap.accessory.bean.PairSetting pairSetting, com.heytap.accessory.bean.DeviceInfo deviceInfo, com.heytap.accessory.discovery.IPairCallback iPairCallback) throws com.heytap.accessory.bean.DiscoveryException {
        com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "startPair, deviceInfo: ".concat(java.lang.String.valueOf(deviceInfo)));
        if (pairSetting == null) {
            throw com.heytap.accessory.bean.DiscoveryException.create(3, "setting shouldn't_renamed be_renamed null");
        }
        if (deviceInfo == null) {
            throw com.heytap.accessory.bean.DiscoveryException.create(3, "deviceInfo shouldn't_renamed be_renamed null");
        }
        if (iPairCallback == null) {
            throw com.heytap.accessory.bean.DiscoveryException.create(3, "callback shouldn't_renamed be_renamed null");
        }
        if (this.mService != null) {
            return startPairInternal(pairSetting, deviceInfo, iPairCallback);
        }
        throw com.heytap.accessory.bean.DiscoveryException.create(2, "startPair failed, service and context is_renamed null");
    }

    private int startPairInternal(com.heytap.accessory.bean.PairSetting pairSetting, com.heytap.accessory.bean.DeviceInfo deviceInfo, com.heytap.accessory.discovery.IPairCallback iPairCallback) {
        int iA;
        if (this.mService == null) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "service is_renamed null");
            return 1;
        }
        try {
            iA = this.mService.a_renamed(pairSetting, deviceInfo, new com.heytap.accessory.discovery.CentralManager.PairCallbackNative(iPairCallback));
        } catch (java.lang.Exception e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, e_renamed);
            iA = 7;
        }
        if (iA != 0) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "startPair failed, err: ".concat(java.lang.String.valueOf(iA)));
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putInt(com.heytap.accessory.bean.Message.KEY_MSG_ERROR_CODE, iA);
            iPairCallback.onPairFailure(deviceInfo, bundle);
        }
        return iA;
    }

    public void cancelPair(final com.heytap.accessory.bean.DeviceInfo deviceInfo) throws com.heytap.accessory.bean.DiscoveryException {
        com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "cancelPair, deviceInfo: ".concat(java.lang.String.valueOf(deviceInfo)));
        if (deviceInfo == null) {
            throw com.heytap.accessory.bean.DiscoveryException.create(3, "deviceInfo shouldn't_renamed be_renamed null");
        }
        if (this.mService != null) {
            cancelPairInternal(deviceInfo);
            return;
        }
        android.content.Context context = this.mContext;
        if (context != null) {
            runOnBackGround(context, new com.heytap.accessory.discovery.d_renamed() { // from class: com.heytap.accessory.discovery.CentralManager.3
                @Override // com.heytap.accessory.discovery.d_renamed
                public final void a_renamed() {
                    com.heytap.accessory.discovery.CentralManager.this.cancelPairInternal(deviceInfo);
                }
            });
            return;
        }
        throw com.heytap.accessory.bean.DiscoveryException.create(2, "cancelPair failed, service and context is_renamed null");
    }

    public void checkLocationIsAvailable(com.heytap.accessory.discovery.c_renamed cVar) throws com.heytap.accessory.bean.DiscoveryException {
        com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "checkPresentIsAvailable");
        if (cVar == null) {
            throw com.heytap.accessory.bean.DiscoveryException.create(3, "grantCallback shouldn't_renamed be_renamed null");
        }
        if (this.mService != null) {
            checkLocationIsAvailableInternal(cVar);
            return;
        }
        throw com.heytap.accessory.bean.DiscoveryException.create(2, "checkLocationIsAvailable fail");
    }

    private void checkLocationIsAvailableInternal(com.heytap.accessory.discovery.c_renamed cVar) {
        if (this.mService == null) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "service is_renamed null");
            return;
        }
        try {
            this.mService.a_renamed(new com.heytap.accessory.discovery.CentralManager.GrantPermissionCallbackNative(cVar));
        } catch (java.lang.Exception e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, e_renamed);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelPairInternal(com.heytap.accessory.bean.DeviceInfo deviceInfo) {
        if (this.mService == null) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "service is_renamed null");
            return;
        }
        try {
            this.mService.a_renamed(deviceInfo);
        } catch (java.lang.Exception e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, e_renamed);
        }
    }

    public void enableDiscoverability(final int i_renamed, final boolean z_renamed) throws com.heytap.accessory.bean.DiscoveryException {
        com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "enableDiscoverability, major: " + i_renamed + ", enable: " + z_renamed);
        if (this.mService != null) {
            enableDiscoverabilityInternal(i_renamed, z_renamed);
            return;
        }
        android.content.Context context = this.mContext;
        if (context != null) {
            runOnBackGround(context, new com.heytap.accessory.discovery.d_renamed() { // from class: com.heytap.accessory.discovery.CentralManager.4
                @Override // com.heytap.accessory.discovery.d_renamed
                public final void a_renamed() {
                    com.heytap.accessory.discovery.CentralManager.this.enableDiscoverabilityInternal(i_renamed, z_renamed);
                }
            });
            return;
        }
        throw com.heytap.accessory.bean.DiscoveryException.create(2, "enableDiscoverability failed, service and context is_renamed null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enableDiscoverabilityInternal(int i_renamed, boolean z_renamed) {
        if (this.mService == null) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "service is_renamed null");
            return;
        }
        try {
            this.mService.a_renamed(i_renamed, z_renamed);
        } catch (java.lang.Exception e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, e_renamed);
        }
    }

    public boolean checkDiscoverability(int i_renamed) throws com.heytap.accessory.bean.DiscoveryException {
        if (this.mService == null) {
            throw com.heytap.accessory.bean.DiscoveryException.create(2, "checkDiscoverability failed, service is_renamed null");
        }
        try {
            return this.mService.a_renamed(i_renamed);
        } catch (java.lang.Exception e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, e_renamed);
            throw com.heytap.accessory.bean.DiscoveryException.create(1, e_renamed.getMessage());
        }
    }

    public int directPair(final com.heytap.accessory.bean.DirectPairInfo directPairInfo, final com.heytap.accessory.discovery.IDirectCallback iDirectCallback) throws com.heytap.accessory.bean.DiscoveryException {
        if (directPairInfo == null) {
            throw com.heytap.accessory.bean.DiscoveryException.create(3, "directPairInfo shouldn't_renamed be_renamed null");
        }
        if (iDirectCallback == null) {
            throw com.heytap.accessory.bean.DiscoveryException.create(3, "callback shouldn't_renamed be_renamed null");
        }
        if (this.mService != null) {
            return directPairInternal(directPairInfo, iDirectCallback);
        }
        android.content.Context context = this.mContext;
        if (context != null) {
            runOnBackGround(context, new com.heytap.accessory.discovery.d_renamed() { // from class: com.heytap.accessory.discovery.CentralManager.5
                @Override // com.heytap.accessory.discovery.d_renamed
                public final void a_renamed() {
                    com.heytap.accessory.discovery.CentralManager.this.directPairInternal(directPairInfo, iDirectCallback);
                }
            });
            return 0;
        }
        throw com.heytap.accessory.bean.DiscoveryException.create(2, "directPair failed, service is_renamed null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int directPairInternal(com.heytap.accessory.bean.DirectPairInfo directPairInfo, com.heytap.accessory.discovery.IDirectCallback iDirectCallback) {
        int iA;
        if (this.mService == null) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "service is_renamed null");
            return 1;
        }
        try {
            iA = this.mService.a_renamed(directPairInfo, new com.heytap.accessory.discovery.CentralManager.DirectPairCallbackNative(iDirectCallback));
        } catch (java.lang.Exception e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, e_renamed);
            iA = 7;
        }
        if (iA != 0) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "directPair failed, err: ".concat(java.lang.String.valueOf(iA)));
            com.heytap.accessory.bean.Message message = new com.heytap.accessory.bean.Message();
            message.getBundle().putInt(com.heytap.accessory.bean.Message.KEY_MSG_ERROR_CODE, iA);
            iDirectCallback.onPairFailure(new com.heytap.accessory.bean.DeviceInfo(), message);
        }
        return iA;
    }

    public void getLanCacheIp(java.lang.String str, com.heytap.accessory.discovery.a_renamed aVar) throws com.heytap.accessory.bean.DiscoveryException {
        if (this.mService == null) {
            throw com.heytap.accessory.bean.DiscoveryException.create(2, "directPair failed, service is_renamed null");
        }
        try {
            this.mService.a_renamed(str, new com.heytap.accessory.discovery.CentralManager.ILanCacheIpNative(aVar));
        } catch (java.lang.Exception e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, e_renamed);
        }
    }

    public void findPairedLanDevices(com.heytap.accessory.discovery.b_renamed bVar) throws com.heytap.accessory.bean.DiscoveryException {
        if (this.mService == null) {
            throw com.heytap.accessory.bean.DiscoveryException.create(2, "directPair failed, service is_renamed null");
        }
        try {
            this.mService.a_renamed(new com.heytap.accessory.discovery.CentralManager.INsdDevicesNative(bVar));
        } catch (java.lang.Exception e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, e_renamed);
        }
    }

    private android.os.Bundle packFilterBundle(java.util.List<com.heytap.accessory.discovery.IScanFilter> list) {
        android.os.Bundle bundle = new android.os.Bundle();
        if (list != null) {
            for (com.heytap.accessory.discovery.IScanFilter iScanFilter : list) {
                bundle.putParcelable(iScanFilter.getKey(), iScanFilter);
            }
        }
        return bundle;
    }

    private boolean bindService(android.content.Context context) {
        if (this.mService != null) {
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "already bind service");
            return true;
        }
        android.content.Intent intent = new android.content.Intent(com.heytap.accessory.constant.AFConstants.SCAN_SERVICE_INTENT);
        intent.setPackage(com.heytap.accessory.api.ManagerConfig.ACCESSORY_FRAMEWORK_PACKAGE);
        intent.putExtra(com.heytap.accessory.constant.AFConstants.KEY_SUB_SERVICE, 1);
        return context.bindService(intent, this, 1);
    }

    private synchronized boolean bindServiceSync(android.content.Context context) {
        java.lang.String str;
        java.lang.String str2;
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        if (!bindService(context)) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "bindServiceSync failed");
            return false;
        }
        try {
            try {
                wait(9000L);
                str = TAG;
                str2 = "bind service cost: " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis);
            } catch (java.lang.InterruptedException e_renamed) {
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "bindServiceSync failed, InterruptedException: " + e_renamed.getMessage());
                e_renamed.printStackTrace();
                str = TAG;
                str2 = "bind service cost: " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis);
            }
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(str, str2);
            return true;
        } catch (java.lang.Throwable th) {
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "bind service cost: " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
            throw th;
        }
    }

    static class DirectPairCallbackNative extends com.heytap.accessory.api.IDirectPairCallback.Stub {

        /* renamed from: a_renamed, reason: collision with root package name */
        private final com.heytap.accessory.discovery.IDirectCallback f3297a;

        DirectPairCallbackNative(com.heytap.accessory.discovery.IDirectCallback iDirectCallback) {
            this.f3297a = iDirectCallback;
        }

        @Override // com.heytap.accessory.api.IDirectPairCallback
        public void a_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo, com.heytap.accessory.bean.Message message) throws android.os.RemoteException {
            this.f3297a.onPairSuccess(deviceInfo, message);
        }

        @Override // com.heytap.accessory.api.IDirectPairCallback
        public void b_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo, com.heytap.accessory.bean.Message message) throws android.os.RemoteException {
            this.f3297a.onPairFailure(deviceInfo, message);
        }
    }

    class ScanCallbackNative extends com.heytap.accessory.api.IDisScanCallback.Stub {

        /* renamed from: b_renamed, reason: collision with root package name */
        private final com.heytap.accessory.discovery.IScanCallback f3305b;

        ScanCallbackNative(com.heytap.accessory.discovery.IScanCallback iScanCallback) {
            this.f3305b = iScanCallback;
        }

        @Override // com.heytap.accessory.api.IDisScanCallback
        public void a_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo) throws android.os.RemoteException {
            try {
                this.f3305b.onDeviceFound(deviceInfo);
            } catch (java.lang.Exception e_renamed) {
                com.heytap.accessory.a_renamed.a_renamed.b_renamed(com.heytap.accessory.discovery.CentralManager.TAG, e_renamed);
            }
        }

        @Override // com.heytap.accessory.api.IDisScanCallback
        public void a_renamed() throws android.os.RemoteException {
            try {
                this.f3305b.onCancel();
            } catch (java.lang.Exception e_renamed) {
                com.heytap.accessory.a_renamed.a_renamed.b_renamed(com.heytap.accessory.discovery.CentralManager.TAG, e_renamed);
            }
        }
    }

    class PairCallbackNative extends com.heytap.accessory.api.IDisPairCallback.Stub {

        /* renamed from: b_renamed, reason: collision with root package name */
        private final com.heytap.accessory.discovery.IPairCallback f3303b;

        PairCallbackNative(com.heytap.accessory.discovery.IPairCallback iPairCallback) {
            this.f3303b = iPairCallback;
        }

        @Override // com.heytap.accessory.api.IDisPairCallback
        public void a_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo, com.heytap.accessory.bean.Message message) throws android.os.RemoteException {
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(com.heytap.accessory.discovery.CentralManager.TAG, "onPairSuccess, deviceInfo: ".concat(java.lang.String.valueOf(deviceInfo)));
            try {
                this.f3303b.onPairSuccess(deviceInfo, message.getBundle());
            } catch (java.lang.Exception e_renamed) {
                com.heytap.accessory.a_renamed.a_renamed.b_renamed(com.heytap.accessory.discovery.CentralManager.TAG, e_renamed);
            }
        }

        @Override // com.heytap.accessory.api.IDisPairCallback
        public void b_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo, com.heytap.accessory.bean.Message message) throws android.os.RemoteException {
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(com.heytap.accessory.discovery.CentralManager.TAG, "onPairMessage, deviceInfo: ".concat(java.lang.String.valueOf(deviceInfo)));
            android.os.Bundle bundle = message.getBundle();
            if (bundle == null) {
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(com.heytap.accessory.discovery.CentralManager.TAG, "onPairMessage failed, bundle is_renamed null");
                return;
            }
            bundle.putInt(com.heytap.accessory.bean.Message.SDK_VERSION, com.heytap.accessory.Config.getSdkVersionCode());
            try {
                int fpCoreVersion = com.heytap.accessory.discovery.CentralManager.this.getFpCoreVersion();
                com.heytap.accessory.a_renamed.a_renamed.c_renamed(com.heytap.accessory.discovery.CentralManager.TAG, "getFpCoreVersion: ".concat(java.lang.String.valueOf(fpCoreVersion)));
                if (fpCoreVersion < 10200) {
                    bundle.putByteArray(com.heytap.accessory.bean.Message.KEY_MSG_AUTH_DATA, this.f3303b.onPairData(deviceInfo, bundle));
                    return;
                }
                if (fpCoreVersion >= 10200) {
                    if (!bundle.containsKey(com.heytap.accessory.bean.Message.KEY_MSG_AUTH_MODE) && !bundle.containsKey(com.heytap.accessory.bean.Message.KEY_MSG_AUTH_LIMIT_LENGTH)) {
                        if (bundle.containsKey(com.heytap.accessory.bean.Message.KEY_MSG_TYPE_PAIR_TYPE_RECEIVED)) {
                            bundle.putInt(com.heytap.accessory.bean.Message.KEY_MSG_TYPE_PAIR_TYPE_RECEIVED, this.f3303b.onPairTypeReceived(deviceInfo, bundle));
                            return;
                        }
                        return;
                    }
                    bundle.putByteArray(com.heytap.accessory.bean.Message.KEY_MSG_AUTH_DATA, this.f3303b.onPairData(deviceInfo, bundle));
                }
            } catch (java.lang.Exception e_renamed) {
                com.heytap.accessory.a_renamed.a_renamed.b_renamed(com.heytap.accessory.discovery.CentralManager.TAG, e_renamed);
            }
        }

        @Override // com.heytap.accessory.api.IDisPairCallback
        public void c_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo, com.heytap.accessory.bean.Message message) throws android.os.RemoteException {
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(com.heytap.accessory.discovery.CentralManager.TAG, "onPairFailure, deviceInfo: ".concat(java.lang.String.valueOf(deviceInfo)));
            try {
                this.f3303b.onPairFailure(deviceInfo, message.getBundle());
            } catch (java.lang.Exception e_renamed) {
                com.heytap.accessory.a_renamed.a_renamed.b_renamed(com.heytap.accessory.discovery.CentralManager.TAG, e_renamed);
            }
        }
    }

    class GrantPermissionCallbackNative extends com.heytap.accessory.api.IPermissionCallback.Stub {

        /* renamed from: b_renamed, reason: collision with root package name */
        private final com.heytap.accessory.discovery.c_renamed f3299b;

        GrantPermissionCallbackNative(com.heytap.accessory.discovery.c_renamed cVar) {
            this.f3299b = cVar;
        }

        @Override // com.heytap.accessory.api.IPermissionCallback
        public void a_renamed() throws android.os.RemoteException {
            this.f3299b.a_renamed();
        }

        @Override // com.heytap.accessory.api.IPermissionCallback
        public void a_renamed(int i_renamed) throws android.os.RemoteException {
            this.f3299b.a_renamed(i_renamed);
        }
    }

    static class ILanCacheIpNative extends com.heytap.accessory.api.ILanCacheIpServiceCallback.Stub {

        /* renamed from: a_renamed, reason: collision with root package name */
        private final com.heytap.accessory.discovery.a_renamed f3300a;

        ILanCacheIpNative(com.heytap.accessory.discovery.a_renamed aVar) {
            this.f3300a = aVar;
        }

        @Override // com.heytap.accessory.api.ILanCacheIpServiceCallback
        public void a_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo, com.heytap.accessory.bean.Message message) throws android.os.RemoteException {
            this.f3300a.a_renamed(deviceInfo, message);
        }
    }

    static class INsdDevicesNative extends com.heytap.accessory.api.INsdDevicesCallback.Stub {

        /* renamed from: a_renamed, reason: collision with root package name */
        private final com.heytap.accessory.discovery.b_renamed f3301a;

        INsdDevicesNative(com.heytap.accessory.discovery.b_renamed bVar) {
            this.f3301a = bVar;
        }

        @Override // com.heytap.accessory.api.INsdDevicesCallback
        public void a_renamed(java.util.List<com.heytap.accessory.bean.DeviceInfo> list) throws android.os.RemoteException {
            this.f3301a.a_renamed(list);
        }
    }

    public void saveModelId(byte[] bArr, byte[] bArr2) {
        try {
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "save modelId and remoteDeviceId");
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putInt(com.heytap.accessory.constant.AFConstants.KEY_BUSINESS_TYPE, 1);
            bundle.putByteArray(com.heytap.accessory.constant.AFConstants.KEY_MODEL_ID, bArr2);
            bundle.putByteArray(com.heytap.accessory.constant.AFConstants.KEY_REMOTE_DEVICE_ID, bArr);
            this.mService.a_renamed(bundle);
        } catch (android.os.RemoteException e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, e_renamed.toString());
            e_renamed.printStackTrace();
        }
    }
}
