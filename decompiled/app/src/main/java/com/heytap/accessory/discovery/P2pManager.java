package com.heytap.accessory.discovery;

/* loaded from: classes2.dex */
public class P2pManager extends com.heytap.accessory.discovery.BaseManager {
    private static final java.lang.String PREFIX = "p2p_";
    private static final java.lang.String TAG = "P2pManager";
    private static volatile com.heytap.accessory.discovery.P2pManager sInstance;
    private android.content.Context mContext;
    private volatile com.heytap.accessory.discovery.IP2pCallback mIP2pCallback;
    private java.lang.String mPackageName;
    private volatile com.heytap.accessory.api.IWifiP2pService mService;
    private final java.util.Set<com.heytap.accessory.discovery.BaseManager.a_renamed> mManagerCallbackSet = new java.util.HashSet();
    private com.heytap.accessory.discovery.P2pManager.WifiP2pChangeReceiver mReceiver = new com.heytap.accessory.discovery.P2pManager.WifiP2pChangeReceiver(this, 0);

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

    private P2pManager() {
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
                this.mService = iDiscoveryNativeService.c_renamed();
                if (this.mService != null) {
                    this.mService.a_renamed(this.mReceiver);
                }
                notifyAll();
            } catch (android.os.RemoteException e_renamed) {
                e_renamed.printStackTrace();
            }
        }
        java.util.List.of_renamed();
        synchronized (this.mManagerCallbackSet) {
            list = (java.util.List) this.mManagerCallbackSet.stream().filter(new java.util.function.Predicate() { // from class: com.heytap.accessory.discovery.-$$Lambda$P2pManager$Axxg5eyQWGDUPCtyFAF3GW-ehSo
                @Override // java.util.function.Predicate
                public final boolean test(java.lang.Object obj) {
                    return com.heytap.accessory.discovery.P2pManager.lambda$onSubServiceConnected$0((com.heytap.accessory.discovery.BaseManager.a_renamed) obj);
                }
            }).map(new java.util.function.Function() { // from class: com.heytap.accessory.discovery.-$$Lambda$P2pManager$B4ULtdBQjesc0mOI7ZQxjXxZczw
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
        this.mService = null;
        java.util.List.of_renamed();
        synchronized (this.mManagerCallbackSet) {
            list = (java.util.List) this.mManagerCallbackSet.stream().map(new java.util.function.Function() { // from class: com.heytap.accessory.discovery.-$$Lambda$P2pManager$ih4wMVxU11VbIFrbzku40ZuZH0s
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

    public static com.heytap.accessory.discovery.P2pManager getInstance() {
        if (sInstance == null) {
            synchronized (com.heytap.accessory.discovery.P2pManager.class) {
                if (sInstance == null) {
                    sInstance = new com.heytap.accessory.discovery.P2pManager();
                }
            }
        }
        return sInstance;
    }

    public synchronized boolean init(android.content.Context context, com.heytap.accessory.discovery.IP2pCallback iP2pCallback) throws com.heytap.accessory.bean.SdkUnsupportedException, android.os.RemoteException {
        com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "init");
        if (this.mIP2pCallback != iP2pCallback) {
            this.mIP2pCallback = iP2pCallback;
        }
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

    public void initAsync(android.content.Context context, com.heytap.accessory.discovery.IP2pCallback iP2pCallback, com.heytap.accessory.discovery.IManagerCallback iManagerCallback) throws com.heytap.accessory.bean.SdkUnsupportedException {
        com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "initAsync");
        if (this.mIP2pCallback != iP2pCallback) {
            this.mIP2pCallback = iP2pCallback;
        }
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

    public synchronized void release(android.content.Context context) throws android.os.RemoteException {
        release();
    }

    public synchronized void release() throws android.os.RemoteException {
        com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "release");
        if (this.mService != null) {
            this.mService.b_renamed(this.mReceiver);
        }
        if (this.mContext != null) {
            this.mContext.unbindService(this);
        }
        this.mService = null;
        this.mContext = null;
        synchronized (this.mManagerCallbackSet) {
            this.mManagerCallbackSet.clear();
        }
    }

    public java.util.List<com.heytap.accessory.bean.DeviceInfo> getConnectedDevices() throws android.os.RemoteException {
        com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "getConnectedDevices");
        if (this.mService != null) {
            return this.mService.a_renamed();
        }
        if (this.mContext != null) {
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "getConnectedDevices, just bind service");
            runOnBackGround(this.mContext, null);
        }
        throw new android.os.RemoteException("Service not connected.");
    }

    public java.lang.String joinP2p(com.heytap.accessory.bean.DeviceInfo deviceInfo) throws android.os.RemoteException {
        com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "joinP2p");
        if (this.mService == null) {
            throw new android.os.RemoteException("Service not connected.");
        }
        if (deviceInfo == null) {
            throw new java.lang.NullPointerException("device null exception");
        }
        return this.mService.a_renamed(deviceInfo);
    }

    public void leaveP2p(com.heytap.accessory.bean.DeviceInfo deviceInfo) throws android.os.RemoteException {
        com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "leaveP2p");
        if (this.mService == null) {
            throw new android.os.RemoteException("Service not connected.");
        }
        if (deviceInfo == null) {
            throw new java.lang.NullPointerException("device null exception");
        }
        this.mService.b_renamed(deviceInfo);
    }

    class WifiP2pChangeReceiver extends com.heytap.accessory.api.IWifiP2pChangeReceiver.Stub {
        private WifiP2pChangeReceiver() {
        }

        /* synthetic */ WifiP2pChangeReceiver(com.heytap.accessory.discovery.P2pManager p2pManager, byte b2) {
            this();
        }

        @Override // com.heytap.accessory.api.IWifiP2pChangeReceiver
        public void a_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo, int i_renamed, int i2) throws android.os.RemoteException {
            if (com.heytap.accessory.discovery.P2pManager.this.mIP2pCallback != null) {
                com.heytap.accessory.discovery.P2pManager.this.mIP2pCallback.onStateChange(deviceInfo, i_renamed, i2);
            } else {
                com.heytap.accessory.a_renamed.a_renamed.d_renamed(com.heytap.accessory.discovery.P2pManager.TAG, "onStateChange failed, IP2pCallback is_renamed null");
            }
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
            return this.mService != null;
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
        intent.putExtra(com.heytap.accessory.constant.AFConstants.KEY_SUB_SERVICE, 3);
        return context.bindService(intent, this, 1);
    }
}
