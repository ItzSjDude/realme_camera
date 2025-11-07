package com.heytap.accessory.discovery;

/* loaded from: classes2.dex */
public class PeripheralManager extends com.heytap.accessory.discovery.BaseManager {
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
    private static final java.lang.String PREFIX = "ppl_";
    private static final java.lang.String TAG = "PeripheralManager";
    private static volatile com.heytap.accessory.discovery.PeripheralManager sInstance;
    private android.content.Context mContext;
    private final java.util.Set<com.heytap.accessory.discovery.BaseManager.a_renamed> mManagerCallbackSet = new java.util.HashSet();
    private java.lang.String mPackageName;
    private byte[] mPreRdi;
    private volatile com.heytap.accessory.api.IPeripheralService mService;

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

    private PeripheralManager() {
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
                this.mService = iDiscoveryNativeService.b_renamed();
                notifyAll();
            } catch (android.os.RemoteException e_renamed) {
                e_renamed.printStackTrace();
            }
        }
        java.util.List.of_renamed();
        synchronized (this.mManagerCallbackSet) {
            list = (java.util.List) this.mManagerCallbackSet.stream().filter(new java.util.function.Predicate() { // from class: com.heytap.accessory.discovery.-$$Lambda$PeripheralManager$AGx5qn1vbXBcUeyTAlEwCyNZv7I
                @Override // java.util.function.Predicate
                public final boolean test(java.lang.Object obj) {
                    return com.heytap.accessory.discovery.PeripheralManager.lambda$onSubServiceConnected$0((com.heytap.accessory.discovery.BaseManager.a_renamed) obj);
                }
            }).map(new java.util.function.Function() { // from class: com.heytap.accessory.discovery.-$$Lambda$PeripheralManager$7EAhaF8vq3z9OBu-CxK0MtRR8xo
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
            list = (java.util.List) this.mManagerCallbackSet.stream().map(new java.util.function.Function() { // from class: com.heytap.accessory.discovery.-$$Lambda$PeripheralManager$pK0QK3PW7tCLUI2vmeZa7nNZEhE
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

    public static com.heytap.accessory.discovery.PeripheralManager getInstance() {
        com.heytap.accessory.discovery.PeripheralManager peripheralManager = sInstance;
        if (peripheralManager == null) {
            synchronized (com.heytap.accessory.discovery.PeripheralManager.class) {
                peripheralManager = sInstance;
                if (peripheralManager == null) {
                    peripheralManager = new com.heytap.accessory.discovery.PeripheralManager();
                    sInstance = peripheralManager;
                }
            }
        }
        return peripheralManager;
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
        if (this.mContext != null) {
            this.mContext.unbindService(this);
        }
        this.mService = null;
        this.mContext = null;
        synchronized (this.mManagerCallbackSet) {
            this.mManagerCallbackSet.clear();
        }
    }

    public int startAdvertise(com.heytap.accessory.bean.AdvertiseSetting advertiseSetting, final com.heytap.accessory.discovery.IPeplCallback iPeplCallback) throws com.heytap.accessory.bean.DiscoveryException {
        if (advertiseSetting == null) {
            throw com.heytap.accessory.bean.DiscoveryException.create(3, "setting shouldn't_renamed be_renamed null");
        }
        if (iPeplCallback == null) {
            throw com.heytap.accessory.bean.DiscoveryException.create(3, "callback shouldn't_renamed be_renamed null");
        }
        final com.heytap.accessory.bean.AdvertiseSetting advertiseSettingRebuildSetting = rebuildSetting(advertiseSetting);
        advertiseSettingRebuildSetting.setServiceVersion(getServiceVersion());
        if (this.mService != null) {
            startAdvertisingInternal(advertiseSettingRebuildSetting, iPeplCallback);
            return 0;
        }
        android.content.Context context = this.mContext;
        if (context != null) {
            runOnBackGround(context, new com.heytap.accessory.discovery.d_renamed() { // from class: com.heytap.accessory.discovery.PeripheralManager.1
                @Override // com.heytap.accessory.discovery.d_renamed
                public final void a_renamed() {
                    com.heytap.accessory.discovery.PeripheralManager.this.startAdvertisingInternal(advertiseSettingRebuildSetting, iPeplCallback);
                }
            });
            return 0;
        }
        throw com.heytap.accessory.bean.DiscoveryException.create(2, "startAdvertise failed, service and context is_renamed null");
    }

    public void stopAdvertise() throws com.heytap.accessory.bean.DiscoveryException {
        if (this.mService != null) {
            stopAdvertisingInternal();
            return;
        }
        android.content.Context context = this.mContext;
        if (context != null) {
            runOnBackGround(context, new com.heytap.accessory.discovery.d_renamed() { // from class: com.heytap.accessory.discovery.PeripheralManager.2
                @Override // com.heytap.accessory.discovery.d_renamed
                public final void a_renamed() {
                    com.heytap.accessory.discovery.PeripheralManager.this.stopAdvertisingInternal();
                }
            });
            return;
        }
        throw com.heytap.accessory.bean.DiscoveryException.create(2, "stopAdvertise failed, service and context is_renamed null");
    }

    public boolean responseConnect(com.heytap.accessory.bean.DeviceInfo deviceInfo, int i_renamed) throws com.heytap.accessory.bean.DiscoveryException {
        com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "responseConnect, deviceInfo: " + deviceInfo + ", result: " + i_renamed);
        if (deviceInfo == null) {
            throw com.heytap.accessory.bean.DiscoveryException.create(3, "deviceInfo shouldn't_renamed be_renamed null");
        }
        if (i_renamed <= 0 || i_renamed > 4) {
            throw com.heytap.accessory.bean.DiscoveryException.create(3, "unknown connect result: ".concat(java.lang.String.valueOf(i_renamed)));
        }
        if (this.mService == null) {
            throw com.heytap.accessory.bean.DiscoveryException.create(2, "responseConnect failed, service is_renamed null");
        }
        try {
            this.mService.a_renamed(deviceInfo, i_renamed);
            return true;
        } catch (java.lang.Exception e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, e_renamed);
            throw com.heytap.accessory.bean.DiscoveryException.create(1, e_renamed.getMessage());
        }
    }

    public boolean responseAuthenticate(com.heytap.accessory.bean.DeviceInfo deviceInfo, boolean z_renamed) throws com.heytap.accessory.bean.DiscoveryException {
        com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "responseAuthenticate, deviceInfo: " + deviceInfo + ", agree: " + z_renamed);
        if (deviceInfo == null) {
            throw com.heytap.accessory.bean.DiscoveryException.create(3, "deviceInfo shouldn't_renamed be_renamed null");
        }
        if (this.mService == null) {
            throw com.heytap.accessory.bean.DiscoveryException.create(2, "responseAuthenticate failed, service is_renamed null");
        }
        try {
            this.mService.a_renamed(deviceInfo, z_renamed);
            return true;
        } catch (java.lang.Exception e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, e_renamed);
            throw com.heytap.accessory.bean.DiscoveryException.create(1, e_renamed.getMessage());
        }
    }

    public void createGroup(com.heytap.accessory.discovery.IPeplCallback iPeplCallback) throws com.heytap.accessory.bean.DiscoveryException {
        com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "disable createGroup without debug");
    }

    class PeripheralCallbackNative extends com.heytap.accessory.api.IPeripheralCallback.Stub {

        /* renamed from: b_renamed, reason: collision with root package name */
        private final com.heytap.accessory.discovery.IPeplCallback f3312b;

        PeripheralCallbackNative(com.heytap.accessory.discovery.IPeplCallback iPeplCallback) {
            this.f3312b = iPeplCallback;
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        public void a_renamed(com.heytap.accessory.bean.Message message) throws android.os.RemoteException {
            com.heytap.accessory.discovery.PeripheralManager.this.mPreRdi = message.getBundle().getByteArray(com.heytap.accessory.bean.Message.KEY_MSG_RDI);
            java.lang.StringBuilder sb = new java.lang.StringBuilder("onAdvertiseSuccess preRdi : ");
            sb.append(com.heytap.accessory.discovery.PeripheralManager.this.mPreRdi != null ? com.heytap.accessory.b_renamed.e_renamed.a_renamed(com.heytap.accessory.discovery.PeripheralManager.this.mPreRdi) : null);
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(com.heytap.accessory.discovery.PeripheralManager.TAG, sb.toString());
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        public void a_renamed() throws android.os.RemoteException {
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(com.heytap.accessory.discovery.PeripheralManager.TAG, "onAdvertiseSuccess");
            try {
                this.f3312b.onAdvertiseSuccess();
            } catch (java.lang.Exception e_renamed) {
                com.heytap.accessory.a_renamed.a_renamed.b_renamed(com.heytap.accessory.discovery.PeripheralManager.TAG, e_renamed);
            }
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        public void a_renamed(int i_renamed) throws android.os.RemoteException {
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(com.heytap.accessory.discovery.PeripheralManager.TAG, "onAdvertiseFailure, err: ".concat(java.lang.String.valueOf(i_renamed)));
            try {
                this.f3312b.onAdvertiseFailure();
            } catch (java.lang.Exception e_renamed) {
                com.heytap.accessory.a_renamed.a_renamed.b_renamed(com.heytap.accessory.discovery.PeripheralManager.TAG, e_renamed);
            }
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        public void b_renamed() throws android.os.RemoteException {
            try {
                this.f3312b.onAdvertiseStopped();
            } catch (java.lang.Exception e_renamed) {
                com.heytap.accessory.a_renamed.a_renamed.b_renamed(com.heytap.accessory.discovery.PeripheralManager.TAG, e_renamed);
            }
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        public void a_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo, com.heytap.accessory.bean.Message message) throws android.os.RemoteException {
            android.os.Bundle bundle = message.getBundle();
            if (bundle == null) {
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(com.heytap.accessory.discovery.PeripheralManager.TAG, "onRequestConnect failed, bundle is_renamed null");
                return;
            }
            try {
                this.f3312b.onRequestConnect(deviceInfo, new com.heytap.accessory.bean.ConnectMessage(bundle.getByteArray(com.heytap.accessory.bean.Message.KEY_MSG_CONNECT_DATA)));
            } catch (java.lang.Exception e_renamed) {
                com.heytap.accessory.a_renamed.a_renamed.b_renamed(com.heytap.accessory.discovery.PeripheralManager.TAG, e_renamed);
            }
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        public void b_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo, com.heytap.accessory.bean.Message message) throws android.os.RemoteException {
            android.os.Bundle bundle = message.getBundle();
            if (bundle == null) {
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(com.heytap.accessory.discovery.PeripheralManager.TAG, "onRequestAuthenticate failed, bundle is_renamed null");
                return;
            }
            try {
                this.f3312b.onRequestAuthenticate(deviceInfo, new com.heytap.accessory.bean.AuthenticateMessage(bundle.getByteArray(com.heytap.accessory.bean.Message.KEY_MSG_AUTH_DATA)));
            } catch (java.lang.Exception e_renamed) {
                com.heytap.accessory.a_renamed.a_renamed.b_renamed(com.heytap.accessory.discovery.PeripheralManager.TAG, e_renamed);
            }
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        public void a_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo) throws android.os.RemoteException {
            try {
                this.f3312b.onPairSuccess(deviceInfo);
            } catch (java.lang.Exception e_renamed) {
                com.heytap.accessory.a_renamed.a_renamed.b_renamed(com.heytap.accessory.discovery.PeripheralManager.TAG, e_renamed);
            }
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        public void c_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo, com.heytap.accessory.bean.Message message) throws android.os.RemoteException {
            android.os.Bundle bundle = message.getBundle();
            if (bundle == null) {
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(com.heytap.accessory.discovery.PeripheralManager.TAG, "onPairFailure failed, bundle is_renamed null");
                return;
            }
            try {
                this.f3312b.onPairFailure(deviceInfo, bundle.getInt(com.heytap.accessory.bean.Message.KEY_MSG_ERROR_CODE));
            } catch (java.lang.Exception e_renamed) {
                com.heytap.accessory.a_renamed.a_renamed.b_renamed(com.heytap.accessory.discovery.PeripheralManager.TAG, e_renamed);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAdvertisingInternal(com.heytap.accessory.bean.AdvertiseSetting advertiseSetting, com.heytap.accessory.discovery.IPeplCallback iPeplCallback) {
        com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "startAdvertisingInternal");
        if (this.mService == null) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "service is_renamed null");
            return;
        }
        try {
            this.mService.a_renamed(advertiseSetting, new com.heytap.accessory.discovery.PeripheralManager.PeripheralCallbackNative(iPeplCallback));
        } catch (java.lang.Exception e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, e_renamed);
            iPeplCallback.onAdvertiseFailure();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopAdvertisingInternal() {
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

    private boolean bindService(android.content.Context context) {
        if (this.mService != null) {
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "already bind service");
            return true;
        }
        android.content.Intent intent = new android.content.Intent(com.heytap.accessory.constant.AFConstants.SCAN_SERVICE_INTENT);
        intent.setPackage(com.heytap.accessory.api.ManagerConfig.ACCESSORY_FRAMEWORK_PACKAGE);
        intent.putExtra(com.heytap.accessory.constant.AFConstants.KEY_SUB_SERVICE, 2);
        return context.bindService(intent, this, 1);
    }

    private com.heytap.accessory.bean.AdvertiseSetting rebuildSetting(com.heytap.accessory.bean.AdvertiseSetting advertiseSetting) {
        com.heytap.accessory.bean.AdvertiseSetting.Builder builder = new com.heytap.accessory.bean.AdvertiseSetting.Builder();
        if (this.mPreRdi == null) {
            return advertiseSetting;
        }
        builder.setAdditionData(advertiseSetting.getAdditionData()).setAdvertiseMode(advertiseSetting.getAdvertiseMode()).setAdvertiseType(advertiseSetting.getAdvertiseType()).setConnectType(advertiseSetting.getConnectType()).setDurationMillis(advertiseSetting.getDurationMillis()).setGoIntent(advertiseSetting.getGoIntent()).setIsCancelAdv(advertiseSetting.getIsCancelAdv()).setKeyType(advertiseSetting.getKeyType()).setMajor(advertiseSetting.getMajor()).setModelId(advertiseSetting.getModelId()).setNickName(advertiseSetting.getNickName()).setPort(advertiseSetting.getPort());
        byte[] bArr = {0, 0, 0, 0, 0, 0};
        if (advertiseSetting.getRdi() == null || java.util.Arrays.equals(advertiseSetting.getRdi(), bArr)) {
            builder.setRdi(this.mPreRdi);
        } else {
            builder.setRdi(advertiseSetting.getRdi());
        }
        return builder.build();
    }
}
