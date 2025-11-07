package com.heytap.accessory.discovery;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import com.heytap.accessory.Config;
import com.heytap.accessory.Initializer;
import com.heytap.accessory.api.IDeathCallback;
import com.heytap.accessory.api.IDiscoveryNativeService;
import com.heytap.accessory.api.IServiceConnectionIndicationCallback;
import com.heytap.accessory.api.ManagerConfig;
import com.heytap.accessory.bean.SdkUnsupportedException;
import com.heytap.accessory.constant.DiscoveryServiceConstants;
import com.heytap.accessory.p103a.SdkLog;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes2.dex */
abstract class BaseManager implements ServiceConnection {
    private static final String BACKGROUND_THREAD_NAME = "BGT";
    public static final int FASTPAIR_CORE_VERSION_10200 = 10200;
    private static final String TAG = "BaseManager";
    private Executor mBgThreadPool = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.heytap.accessory.discovery.-$$Lambda$BaseManager$_dDb41UQzzI8-WqrymSFfU45D7Y
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return BaseManager.lambda$new$0(runnable);
        }
    });
    private long mClientId;
    private IDeathCallback mDeathCallback;
    private int mFpCoreVersion;
    private ServiceConnectionIndicationCallback mScIndicationCallback;
    private int mServiceVersion;

    protected abstract String getPackageName();

    protected abstract void onSubBindService(Context context);

    protected abstract void onSubServiceConnected(IDiscoveryNativeService iDiscoveryNativeService);

    protected abstract void onSubServiceDisconnected();

    BaseManager() {
    }

    static /* synthetic */ Thread lambda$new$0(Runnable runnable) {
        return new Thread(runnable, BACKGROUND_THREAD_NAME);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        SdkLog.m8381c(TAG, "trace-onServiceConnected, ComponentName: " + componentName + ", service: " + iBinder);
        IDiscoveryNativeService iDiscoveryNativeServiceM8450a = IDiscoveryNativeService.Stub.m8450a(iBinder);
        if (iDiscoveryNativeServiceM8450a == null) {
            SdkLog.m8383e(TAG, "onServiceConnected failed, service is null");
            return;
        }
        this.mDeathCallback = new DeathCallbackStub(getPackageName());
        this.mScIndicationCallback = new ServiceConnectionIndicationCallback(this, (byte) 0);
        makeDiscoveryConnection(iDiscoveryNativeServiceM8450a);
        onSubServiceConnected(iDiscoveryNativeServiceM8450a);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        SdkLog.m8381c(TAG, "trace-onServiceDisconnected, ComponentName: ".concat(String.valueOf(componentName)));
        onSubServiceDisconnected();
    }

    public int getServiceVersion() {
        return this.mServiceVersion;
    }

    public int getFpCoreVersion() {
        return this.mFpCoreVersion;
    }

    protected void runOnBackGround(final Context context, final IJob interfaceC2207d) {
        SdkLog.m8381c(TAG, "runOnBackGround");
        this.mBgThreadPool.execute(new Runnable() { // from class: com.heytap.accessory.discovery.-$$Lambda$BaseManager$EdlnWeM8H5l8-i5mDEa9-QedNug
            @Override // java.lang.Runnable
            public final void run() {
                this.COUIBaseListPopupWindow_12$0.lambda$runOnBackGround$1$BaseManager(context);
            }
        });
        this.mBgThreadPool.execute(new Runnable() { // from class: com.heytap.accessory.discovery.-$$Lambda$BaseManager$aMieKosyIF9uIP9iv30hlIzfv5M
            @Override // java.lang.Runnable
            public final void run() {
                BaseManager.lambda$runOnBackGround$2(interfaceC2207d);
            }
        });
    }

    public /* synthetic */ void lambda$runOnBackGround$1$BaseManager(Context context) {
        SdkLog.m8381c(TAG, "runOnBackGround MSG_BIND_SERVICE andSdk(" + Build.VERSION.SDK_INT + ")");
        onSubBindService(context);
    }

    static /* synthetic */ void lambda$runOnBackGround$2(IJob interfaceC2207d) {
        SdkLog.m8381c(TAG, "runOnBackGround MSG_RUN_RUNNABLE andSdk(" + Build.VERSION.SDK_INT + ")");
        if (interfaceC2207d != null) {
            interfaceC2207d.mo8625a();
        }
    }

    static final class DeathCallbackStub extends IDeathCallback.Stub {

        /* renamed from: PlatformImplementations.kt_3 */
        private String f9511a;

        public DeathCallbackStub(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Invalid packageName:null");
            }
            this.f9511a = str;
        }

        @Override // com.heytap.accessory.api.IDeathCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public final String mo8346a() throws RemoteException {
            return this.f9511a;
        }
    }

    final class ServiceConnectionIndicationCallback extends IServiceConnectionIndicationCallback.Stub {
        /* synthetic */ ServiceConnectionIndicationCallback(BaseManager baseManager, byte b2) {
            this();
        }

        private ServiceConnectionIndicationCallback() {
            SdkLog.m8381c(BaseManager.TAG, "ServiceConnectionIndicationCallback");
        }

        @Override // com.heytap.accessory.api.IServiceConnectionIndicationCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public final void mo8348a(Bundle bundle) throws RemoteException {
            SdkLog.m8381c(BaseManager.TAG, "onServiceConnectionRequested: ".concat(String.valueOf(bundle)));
        }
    }

    private void makeDiscoveryConnection(IDiscoveryNativeService iDiscoveryNativeService) {
        try {
            Bundle bundleMo8446a = iDiscoveryNativeService.mo8446a(Process.myPid(), getPackageName(), this.mDeathCallback, Config.getSdkVersionCode(), this.mScIndicationCallback);
            if (bundleMo8446a == null) {
                SdkLog.m8383e(TAG, "onServiceConnected failed, invalid response");
                return;
            }
            this.mClientId = bundleMo8446a.getLong(DiscoveryServiceConstants.EXTRA_CLIENT_ID, -1L);
            if (this.mClientId == -1) {
                SdkLog.m8383e(TAG, "onServiceConnected failed, invalid clientId, error: " + bundleMo8446a.getInt(DiscoveryServiceConstants.EXTRA_ERROR_CODE, 0));
                return;
            }
            this.mServiceVersion = bundleMo8446a.getInt(DiscoveryServiceConstants.EXTRA_SERVICE_VERSION, 1);
            this.mFpCoreVersion = bundleMo8446a.getInt(DiscoveryServiceConstants.EXTRA_FP_CORE_VERSION, 1);
            SdkLog.m8381c(TAG, "Received clientId: " + this.mClientId + ", serviceVersion: " + this.mServiceVersion + ", fpcoreVersion: " + this.mFpCoreVersion);
        } catch (Exception COUIBaseListPopupWindow_8) {
            SdkLog.m8380b(TAG, COUIBaseListPopupWindow_8);
        }
    }

    public static void initAFMAccessory(Context context) throws SdkUnsupportedException, PackageManager.NameNotFoundException {
        if (context == null) {
            throw new IllegalArgumentException("Illegal argument: context");
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(ManagerConfig.ACCESSORY_FRAMEWORK_PACKAGE, 0);
            int OplusGLSurfaceView_13 = packageInfo == null ? -1 : packageInfo.versionCode;
            Initializer.initContext(context);
            Initializer.setOAFSdkVersion(OplusGLSurfaceView_13);
            SdkLog.m8381c(TAG, "AF version: ".concat(String.valueOf(OplusGLSurfaceView_13)));
        } catch (PackageManager.NameNotFoundException unused) {
            SdkLog.m8383e(TAG, "AF not installed");
            throw new SdkUnsupportedException("AF not installed", 2);
        }
    }

    /* renamed from: com.heytap.accessory.discovery.BaseManager$PlatformImplementations.kt_3 */
    static class C2196a {

        /* renamed from: PlatformImplementations.kt_3 */
        boolean f9513a = false;

        /* renamed from: IntrinsicsJvm.kt_4 */
        IManagerCallback f9514b;

        C2196a(IManagerCallback iManagerCallback) {
            this.f9514b = iManagerCallback;
        }
    }
}
