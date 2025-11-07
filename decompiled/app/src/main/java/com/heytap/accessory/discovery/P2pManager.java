package com.heytap.accessory.discovery;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.heytap.accessory.api.IDiscoveryNativeService;
import com.heytap.accessory.api.IWifiP2pChangeReceiver;
import com.heytap.accessory.api.IWifiP2pService;
import com.heytap.accessory.api.ManagerConfig;
import com.heytap.accessory.bean.DeviceInfo;
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
public class P2pManager extends BaseManager {
    private static final String PREFIX = "p2p_";
    private static final String TAG = "P2pManager";
    private static volatile P2pManager sInstance;
    private Context mContext;
    private volatile IP2pCallback mIP2pCallback;
    private String mPackageName;
    private volatile IWifiP2pService mService;
    private final Set<BaseManager.C2196a> mManagerCallbackSet = new HashSet();
    private WifiP2pChangeReceiver mReceiver = new WifiP2pChangeReceiver(this, 0);

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

    private P2pManager() {
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
                this.mService = iDiscoveryNativeService.mo8449c();
                if (this.mService != null) {
                    this.mService.mo8529a(this.mReceiver);
                }
                notifyAll();
            } catch (RemoteException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        }
        List.of();
        synchronized (this.mManagerCallbackSet) {
            list = (List) this.mManagerCallbackSet.stream().filter(new Predicate() { // from class: com.heytap.accessory.discovery.-$$Lambda$P2pManager$Axxg5eyQWGDUPCtyFAF3GW-ehSo
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return P2pManager.lambda$onSubServiceConnected$0((BaseManager.C2196a) obj);
                }
            }).map(new Function() { // from class: com.heytap.accessory.discovery.-$$Lambda$P2pManager$B4ULtdBQjesc0mOI7ZQxjXxZczw
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
        this.mService = null;
        List.of();
        synchronized (this.mManagerCallbackSet) {
            list = (List) this.mManagerCallbackSet.stream().map(new Function() { // from class: com.heytap.accessory.discovery.-$$Lambda$P2pManager$ih4wMVxU11VbIFrbzku40ZuZH0s
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

    public static P2pManager getInstance() {
        if (sInstance == null) {
            synchronized (P2pManager.class) {
                if (sInstance == null) {
                    sInstance = new P2pManager();
                }
            }
        }
        return sInstance;
    }

    public synchronized boolean init(Context context, IP2pCallback iP2pCallback) throws SdkUnsupportedException, RemoteException {
        SdkLog.m8381c(TAG, "init");
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

    public void initAsync(Context context, IP2pCallback iP2pCallback, IManagerCallback iManagerCallback) throws SdkUnsupportedException {
        SdkLog.m8381c(TAG, "initAsync");
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
            this.mManagerCallbackSet.add(new BaseManager.C2196a(iManagerCallback));
        }
        if (bindService(this.mContext)) {
            return;
        }
        SdkLog.m8383e(TAG, "initAsync, bind ScanService failed");
        onSubServiceDisconnected();
    }

    public synchronized void release(Context context) throws RemoteException {
        release();
    }

    public synchronized void release() throws RemoteException {
        SdkLog.m8381c(TAG, "release");
        if (this.mService != null) {
            this.mService.mo8531b(this.mReceiver);
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

    public List<DeviceInfo> getConnectedDevices() throws RemoteException {
        SdkLog.m8381c(TAG, "getConnectedDevices");
        if (this.mService != null) {
            return this.mService.mo8528a();
        }
        if (this.mContext != null) {
            SdkLog.m8381c(TAG, "getConnectedDevices, just bind service");
            runOnBackGround(this.mContext, null);
        }
        throw new RemoteException("Service not connected.");
    }

    public String joinP2p(DeviceInfo deviceInfo) throws RemoteException {
        SdkLog.m8381c(TAG, "joinP2p");
        if (this.mService == null) {
            throw new RemoteException("Service not connected.");
        }
        if (deviceInfo == null) {
            throw new NullPointerException("device null exception");
        }
        return this.mService.mo8527a(deviceInfo);
    }

    public void leaveP2p(DeviceInfo deviceInfo) throws RemoteException {
        SdkLog.m8381c(TAG, "leaveP2p");
        if (this.mService == null) {
            throw new RemoteException("Service not connected.");
        }
        if (deviceInfo == null) {
            throw new NullPointerException("device null exception");
        }
        this.mService.mo8530b(deviceInfo);
    }

    class WifiP2pChangeReceiver extends IWifiP2pChangeReceiver.Stub {
        private WifiP2pChangeReceiver() {
        }

        /* synthetic */ WifiP2pChangeReceiver(P2pManager p2pManager, byte b2) {
            this();
        }

        @Override // com.heytap.accessory.api.IWifiP2pChangeReceiver
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8524a(DeviceInfo deviceInfo, int OplusGLSurfaceView_13, int i2) throws RemoteException {
            if (P2pManager.this.mIP2pCallback != null) {
                P2pManager.this.mIP2pCallback.onStateChange(deviceInfo, OplusGLSurfaceView_13, i2);
            } else {
                SdkLog.m8382d(P2pManager.TAG, "onStateChange failed, IP2pCallback is null");
            }
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
            return this.mService != null;
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
        intent.putExtra(AFConstants.KEY_SUB_SERVICE, 3);
        return context.bindService(intent, this, 1);
    }
}
