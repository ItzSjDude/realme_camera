package com.heytap.accessory;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.Process;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.TransactionTooLargeException;
import com.heytap.accessory.api.IDeathCallback;
import com.heytap.accessory.api.IFrameworkManager;
import com.heytap.accessory.api.IMsgExpCallback;
import com.heytap.accessory.api.IPeerAgentAuthCallback;
import com.heytap.accessory.api.IPeerAgentCallback;
import com.heytap.accessory.api.IServiceChannelCallback;
import com.heytap.accessory.api.IServiceConnectionCallback;
import com.heytap.accessory.api.IServiceConnectionIndicationCallback;
import com.heytap.accessory.api.ManagerConfig;
import com.heytap.accessory.bean.GeneralException;
import com.heytap.accessory.bean.PeerAgent;
import com.heytap.accessory.bean.ServiceProfile;
import com.heytap.accessory.constant.AFConstants;
import com.heytap.accessory.p103a.SdkLog;
import com.heytap.accessory.p104b.ClassUtils;
import com.heytap.accessory.p104b.ConfigUtil;
import com.heytap.accessory.p104b.SdkConfig;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
public final class BaseAdapter {
    public static final String ACTION_ACCESSORY_STATUS_CHANGED = "com.heytap.accessory.action.ACCESSORY_STATUS_CHANGED";
    public static final String ACTION_SERVICE_CONNECTION_REQUESTED = "com.heytap.accessory.action.SERVICE_CONNECTION_REQUESTED";
    private static final int BIND_SERVICE_MAX_ATTEMPTS = 5;
    private static final int ERROR_FATAL = 20001;
    private static final int ERROR_PERMISSION_DENIED = 20003;
    private static final int ERROR_PERMISSION_FAILED = 20004;
    private static final String TAG = "BaseAdapter";
    private static BaseAdapter sAdapter;
    private Handler mBackgroundHandler;
    private final ServiceConnectionC2135a mConnection;
    private final Context mContext;
    private final IDeathCallback mDeathCallback;
    private ResultReceiver mProxyReceiver;
    private final ServiceConnectionIndicationCallback mScIndicationCallback;
    private IFrameworkManager mServiceProxy;
    private long mClientId = -1;
    private int mState = 0;
    private final Set<InterfaceC2136b> mAgentCallbacks = new HashSet();

    /* renamed from: com.heytap.accessory.BaseAdapter$IntrinsicsJvm.kt_4 */
    interface InterfaceC2136b {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo8349a();

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo8350b();

        /* renamed from: IntrinsicsJvm.kt_3 */
        void mo8351c() throws GeneralException;
    }

    private BaseAdapter(Context context, Handler handler) {
        this.mContext = context;
        byte b2 = 0;
        this.mConnection = new ServiceConnectionC2135a(b2);
        this.mDeathCallback = new DeathCallbackStub(context.getPackageName());
        this.mScIndicationCallback = new ServiceConnectionIndicationCallback(this, b2);
        this.mBackgroundHandler = handler;
    }

    public static synchronized BaseAdapter getDefaultAdapter(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (sAdapter == null) {
            sAdapter = new BaseAdapter(applicationContext, null);
        }
        return sAdapter;
    }

    static synchronized BaseAdapter getDefaultAdapter(Context context, Handler handler) {
        Context applicationContext = context.getApplicationContext();
        if (sAdapter == null) {
            sAdapter = new BaseAdapter(applicationContext, handler);
        }
        return sAdapter;
    }

    final void bindToFramework() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            SdkLog.m8382d(TAG, "It's in main thread,need to switch to sub thread!");
            Handler handler = this.mBackgroundHandler;
            if (handler == null) {
                SdkLog.m8378b(TAG, "BackgroundHandler is null, so just return!");
                return;
            } else {
                handler.post(new Runnable() { // from class: com.heytap.accessory.BaseAdapter.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            BaseAdapter.this.doBindFramework();
                        } catch (GeneralException COUIBaseListPopupWindow_8) {
                            SdkLog.m8379b(BaseAdapter.TAG, "bindToFramework failed!", COUIBaseListPopupWindow_8);
                        }
                    }
                });
                return;
            }
        }
        try {
            doBindFramework();
        } catch (GeneralException COUIBaseListPopupWindow_8) {
            SdkLog.m8379b(TAG, "bindToFramework failed!", COUIBaseListPopupWindow_8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void doBindFramework() throws GeneralException {
        if (sAdapter.mServiceProxy == null) {
            setState(0);
            try {
                SdkLog.m8381c(TAG, "context packageName - " + this.mContext.getPackageName());
                SdkLog.m8381c(TAG, "adapter context packageName - " + sAdapter.mContext.getPackageName());
                Intent intent = new Intent("com.heytap.accessory.action.FRAMEWORK_MANAGER");
                if (Initializer.useOAFApp()) {
                    intent.setPackage(ManagerConfig.ACCESSORY_FRAMEWORK_PACKAGE);
                } else {
                    intent.setPackage(this.mContext.getPackageName());
                }
                intent.putExtra("accessory_framework_request_package", this.mContext.getPackageName());
                for (int OplusGLSurfaceView_13 = 1; sAdapter.mClientId == -1 && getState() == 0 && OplusGLSurfaceView_13 <= 5; OplusGLSurfaceView_13++) {
                    if (!this.mContext.bindService(intent, sAdapter.mConnection, 1)) {
                        SdkLog.m8383e(TAG, "getDefaultAdapter: Binding to Accessory service failed!");
                        setState(-1);
                        throw new GeneralException(20001, "Is the Accessory Service Framework installed?!");
                    }
                    try {
                        SdkLog.m8381c(TAG, "getDefaultAdapter: About start waiting");
                        sAdapter.wait(10000L);
                    } catch (InterruptedException COUIBaseListPopupWindow_8) {
                        setState(-1);
                        throw new GeneralException(20001, "Failed to Bind to Accessory Framework - Action interrupted!", COUIBaseListPopupWindow_8);
                    }
                }
                if (sAdapter.mServiceProxy == null) {
                    SdkLog.m8383e(TAG, "getDefaultAdapter: Service Connection proxy is null!");
                    setState(-1);
                    throw new GeneralException(20001, "Unable to bind to Accessory Service!");
                }
                SdkLog.m8381c(TAG, "Application is now connected to Accessory Framework!");
            } catch (SecurityException unused) {
                SdkLog.m8383e(TAG, "getDefaultAdapter: Permission denied! Binding to Accessory service failed!");
                setState(-1);
                if (SdkConfig.m8594a(this.mContext)) {
                    throw new GeneralException(20004, "Permission validation failed to bind to  Accessory Service! Please re-install the application and try again.");
                }
                throw new GeneralException(20003, "Permission denied to bind to Accessory Service! Please add permission and try again.");
            }
        }
    }

    final synchronized void registerAgentCallback(InterfaceC2136b interfaceC2136b) {
        this.mAgentCallbacks.add(interfaceC2136b);
        SdkLog.m8378b(TAG, "Agent callback added. Current size - " + this.mAgentCallbacks.size());
    }

    final synchronized void unregisterAgentCallback(InterfaceC2136b interfaceC2136b) {
        this.mAgentCallbacks.remove(interfaceC2136b);
        SdkLog.m8378b(TAG, "Agent callback removed. Current size - " + this.mAgentCallbacks.size());
        if (this.mAgentCallbacks.isEmpty()) {
            SdkLog.m8381c(TAG, "All clients have unregistered.Disconnection from Accessory Framework.");
            cleanup(true);
        }
    }

    final synchronized int getState() {
        return this.mState;
    }

    final synchronized void setState(int OplusGLSurfaceView_13) {
        this.mState = OplusGLSurfaceView_13;
    }

    final int getVersion() throws GeneralException {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        try {
            if (sAdapter.mServiceProxy != null) {
                return sAdapter.mServiceProxy.mo8452a();
            }
            throw new GeneralException(20001, "getVersion:mServiceProxy is null");
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            SdkLog.m8376a(TAG, "Failed to get version", COUIBaseListPopupWindow_8);
            notifyDisconnection(COUIBaseListPopupWindow_8);
            throw new GeneralException(20001, "getVersion:Remote call failed");
        }
    }

    final synchronized int checkAuthentication() throws GeneralException {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        try {
            if (sAdapter.mServiceProxy == null) {
                return CommonStatusCodes.INTERNAL_EXCEPTION;
            }
            return sAdapter.mServiceProxy.mo8453a(Config.getSdkVersionCode());
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            SdkLog.m8376a(TAG, "Service authenticate failed", COUIBaseListPopupWindow_8);
            notifyDisconnection(COUIBaseListPopupWindow_8);
            throw new GeneralException(20001, "authenticate:Remote call failed");
        }
    }

    final synchronized boolean checkAuthentication(String str) throws GeneralException {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        try {
            if (sAdapter.mServiceProxy == null) {
                return false;
            }
            return sAdapter.mServiceProxy.mo8471a(Config.getSdkVersionCode(), str);
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            SdkLog.m8376a(TAG, "Service authenticate failed", COUIBaseListPopupWindow_8);
            notifyDisconnection(COUIBaseListPopupWindow_8);
            throw new GeneralException(20001, "authenticate:Remote call failed");
        }
    }

    final synchronized void registerServices(byte[] bArr) throws GeneralException {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        try {
            if (sAdapter.mServiceProxy != null) {
                sAdapter.mServiceProxy.mo8470a(this.mClientId, bArr);
            }
            Iterator<InterfaceC2136b> it = this.mAgentCallbacks.iterator();
            while (it.hasNext()) {
                it.next().mo8351c();
            }
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            SdkLog.m8376a(TAG, "Service registration call failed", COUIBaseListPopupWindow_8);
            notifyDisconnection(COUIBaseListPopupWindow_8);
            throw new GeneralException(20001, "registerServices:Remote call failed");
        }
    }

    public final synchronized String getLocalAgentId(String str) throws GeneralException {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        try {
            Bundle bundleMo8463a = sAdapter.mServiceProxy != null ? sAdapter.mServiceProxy.mo8463a(this.mClientId, str) : null;
            if (bundleMo8463a == null) {
                SdkLog.m8379b(TAG, "getLocalAgentId failed", new RuntimeException("Get Local agent ID:Invalid response from accessory framework - null"));
            } else if (bundleMo8463a.containsKey(AFConstants.EXTRA_ERROR_CODE)) {
                int OplusGLSurfaceView_13 = bundleMo8463a.getInt(AFConstants.EXTRA_ERROR_CODE);
                SdkLog.m8379b(TAG, "getLocalAgentId failed", new GeneralException(OplusGLSurfaceView_13, "Failed to fetch localAgent ID, errorCode = ".concat(String.valueOf(OplusGLSurfaceView_13))));
            } else {
                String string = bundleMo8463a.getString(AFConstants.EXTRA_AGENT_ID);
                if (string != null) {
                    return string;
                }
                SdkLog.m8379b(TAG, "getLocalAgentId failed", new RuntimeException("Get Local agent ID:Invalid response - localAgentID:null"));
            }
            return null;
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            SdkLog.m8376a(TAG, "Failed to fetch localAgent ID", COUIBaseListPopupWindow_8);
            notifyDisconnection(COUIBaseListPopupWindow_8);
            throw new GeneralException(20001, "getLocalAgentId:Remote call failed");
        }
    }

    final String getAgentId(String str, String str2) throws GeneralException {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        try {
            if (sAdapter.mServiceProxy != null) {
                return sAdapter.mServiceProxy.mo8465a(this.mClientId, str, str2);
            }
            throw new GeneralException(20001, "getAgentId:mServiceProxy is null");
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            SdkLog.m8376a(TAG, "Failed to fetch agent ID", COUIBaseListPopupWindow_8);
            notifyDisconnection(COUIBaseListPopupWindow_8);
            throw new GeneralException(20001, "getAgentId:Remote call failed");
        }
    }

    final int findPeerAgents(String str, IPeerAgentCallback iPeerAgentCallback) throws GeneralException {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        try {
            if (sAdapter.mServiceProxy != null) {
                return sAdapter.mServiceProxy.mo8455a(this.mClientId, -1L, str, iPeerAgentCallback);
            }
            throw new GeneralException(20001, "findPeerAgents:mServiceProxy is null");
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            SdkLog.m8376a(TAG, "Failed to initiate peer discovery", COUIBaseListPopupWindow_8);
            notifyDisconnection(COUIBaseListPopupWindow_8);
            throw new GeneralException(20001, "findPeerAgents:Remote call failed");
        }
    }

    final int requestServiceConnection(String str, PeerAgent peerAgent, IServiceConnectionCallback iServiceConnectionCallback, IServiceChannelCallback iServiceChannelCallback) throws GeneralException {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        try {
            return this.mServiceProxy.mo8460a(this.mClientId, str, peerAgent, iServiceConnectionCallback, iServiceChannelCallback);
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            SdkLog.m8376a(TAG, "Failed to request service connection", COUIBaseListPopupWindow_8);
            this.notifyDisconnection(COUIBaseListPopupWindow_8);
            throw new GeneralException(20001, "requestServiceConnection:Remote call failed");
        }
    }

    final Bundle acceptServiceConnection(String str, PeerAgent peerAgent, long OplusGLSurfaceView_15, IServiceConnectionCallback iServiceConnectionCallback, IServiceChannelCallback iServiceChannelCallback) throws GeneralException {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        try {
            Bundle bundleMo8464a = this.mServiceProxy.mo8464a(this.mClientId, str, peerAgent, OplusGLSurfaceView_15, iServiceConnectionCallback, iServiceChannelCallback);
            if (bundleMo8464a == null) {
                SdkLog.m8383e(TAG, "acceptServiceConnection:Invalid response from Accessory Framework:".concat(String.valueOf(bundleMo8464a)));
                throw new RuntimeException("acceptServiceConnection:Invalid response from Accessory Framework:".concat(String.valueOf(bundleMo8464a)));
            }
            if (bundleMo8464a.containsKey(AFConstants.EXTRA_ERROR_CODE)) {
                throw new GeneralException(bundleMo8464a.getInt(AFConstants.EXTRA_ERROR_CODE), "Failed to accept connection request!");
            }
            String string = bundleMo8464a.getString("connectionId");
            if (string != null) {
                return bundleMo8464a;
            }
            SdkLog.m8383e(TAG, "acceptServiceConnection:Invalid response from Accessory Framework- connectionId:".concat(String.valueOf(string)));
            throw new RuntimeException("acceptServiceConnection:Invalid response from Accessory Framework- connectionId:".concat(String.valueOf(string)));
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            SdkLog.m8376a(TAG, "Failed to accept service connection", COUIBaseListPopupWindow_8);
            notifyDisconnection(COUIBaseListPopupWindow_8);
            throw new GeneralException(20001, "acceptServiceConnection:Remote call failed");
        }
    }

    final int rejectServiceConnection(String str, PeerAgent peerAgent, long OplusGLSurfaceView_15) throws GeneralException {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        try {
            return this.mServiceProxy.mo8458a(this.mClientId, str, peerAgent, OplusGLSurfaceView_15);
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            SdkLog.m8376a(TAG, "Failed to reject service connection", COUIBaseListPopupWindow_8);
            this.notifyDisconnection(COUIBaseListPopupWindow_8);
            throw new GeneralException(20001, "rejectServiceConnection:Remote call failed");
        }
    }

    final int closeServiceConnection(String str) throws GeneralException {
        if (sAdapter.mServiceProxy == null) {
            return BaseSocket.ERROR_CONNECTION_ALREADY_CLOSED;
        }
        try {
            return this.mServiceProxy.mo8472b(this.mClientId, str);
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            SdkLog.m8376a(TAG, "Failed to close service connection", COUIBaseListPopupWindow_8);
            this.notifyDisconnection(COUIBaseListPopupWindow_8);
            throw new GeneralException(20001, "closeServiceConnection:Remote call failed");
        }
    }

    final int send(PeerAgent peerAgent, String str, int OplusGLSurfaceView_13, byte[] bArr, boolean z, int i2, int i3, int i4, boolean z2) throws GeneralException {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        try {
            String str2 = TAG;
            StringBuilder sb = new StringBuilder("sendData,connectionId:");
            try {
                sb.append(str);
                sb.append(",channelId:");
                sb.append(OplusGLSurfaceView_13);
                sb.append(",dataLen:");
                sb.append(bArr.length);
                sb.append(",compatibleVersion:");
                sb.append(SdkConfig.m8603f());
                SdkLog.m8375a(str2, sb.toString());
                if (SdkConfig.m8603f() > 0) {
                    return this.mServiceProxy.mo8456a(peerAgent.getAccessoryId(), peerAgent.getAgentId(), this.mClientId, str, OplusGLSurfaceView_13, bArr, z, i2, i3, i4, z2);
                }
                return this.mServiceProxy.mo8457a(this.mClientId, str, OplusGLSurfaceView_13, bArr, z, i2, i3, i4);
            } catch (RemoteException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8 = COUIBaseListPopupWindow_8;
                SdkLog.m8376a(TAG, "Failed send data for connection:".concat(String.valueOf(str)), COUIBaseListPopupWindow_8);
                notifyDisconnection(COUIBaseListPopupWindow_8);
                throw new GeneralException(20001, "send: Remote call failed");
            }
        } catch (RemoteException e2) {
            COUIBaseListPopupWindow_8 = e2;
        }
    }

    final boolean isSocketConnected(String str) throws GeneralException {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        try {
            return this.mServiceProxy.mo8475d(this.mClientId, str);
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            SdkLog.m8376a(TAG, "Failed to fetch socket connection status", COUIBaseListPopupWindow_8);
            this.notifyDisconnection(COUIBaseListPopupWindow_8);
            throw new GeneralException(20001, "isSocketConnected:Remote call failed");
        }
    }

    final int authenticatePeeragent(String str, PeerAgent peerAgent, IPeerAgentAuthCallback iPeerAgentAuthCallback, long OplusGLSurfaceView_15) throws GeneralException {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        try {
            return this.mServiceProxy.mo8459a(this.mClientId, str, peerAgent, iPeerAgentAuthCallback, OplusGLSurfaceView_15);
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            SdkLog.m8376a(TAG, "Failed to request peer authentication", COUIBaseListPopupWindow_8);
            this.notifyDisconnection(COUIBaseListPopupWindow_8);
            throw new GeneralException(20001, "authenticatePeeragent:Remote call failed");
        }
    }

    final void cleanupAgent(String str) {
        if (sAdapter.mServiceProxy == null) {
            SdkLog.m8382d(TAG, "Binding to framework does not exists");
            return;
        }
        try {
            this.mServiceProxy.mo8477f(this.mClientId, str);
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            SdkLog.m8376a(TAG, "Failed to cleanup agent details", COUIBaseListPopupWindow_8);
        }
    }

    final void cleanupChannel(String str, int OplusGLSurfaceView_13) throws GeneralException {
        if (sAdapter.mServiceProxy == null) {
            SdkLog.m8382d(TAG, "cleanupChannel failed, Binding to framework does not exists");
            return;
        }
        try {
            this.mServiceProxy.mo8468a(this.mClientId, str, OplusGLSurfaceView_13);
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            SdkLog.m8376a(TAG, "Failed to cleanupChannelCache", COUIBaseListPopupWindow_8);
            throw new GeneralException(20001, "authenticatePeeragent:Remote call failed");
        }
    }

    final Bundle getAgentDetails(String str) throws GeneralException {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        try {
            return this.mServiceProxy.mo8474c(this.mClientId, str);
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            SdkLog.m8376a(TAG, "Failed to get agent details", COUIBaseListPopupWindow_8);
            this.notifyDisconnection(COUIBaseListPopupWindow_8);
            throw new GeneralException(20001, "getAgentDetails: Remote call failed");
        }
    }

    final String getPackageName() {
        return this.mContext.getPackageName();
    }

    final synchronized void recycle(byte[] bArr) {
        if (sAdapter.mProxyReceiver != null) {
            Bundle bundle = new Bundle();
            bundle.putByteArray(AFConstants.EXTRA_READ_BYTES, bArr);
            sAdapter.mProxyReceiver.send(0, bundle);
        }
    }

    private synchronized void tearFrameworkconnection() {
        if (this.mServiceProxy == null) {
            SdkLog.m8381c(TAG, "Binding to framework does not exists");
            return;
        }
        try {
            this.mServiceProxy.mo8454a(this.mClientId);
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            SdkLog.m8376a(TAG, "Failed to tear framework connection", COUIBaseListPopupWindow_8);
        } finally {
            cleanup(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0031 A[Catch: all -> 0x003d, LOOP:0: B:9:0x002b->B:11:0x0031, LOOP_END, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:5:0x0006, B:7:0x000d, B:8:0x0014, B:9:0x002b, B:11:0x0031), top: B:18:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000d A[Catch: all -> 0x003d, TryCatch #0 {, blocks: (B:4:0x0003, B:5:0x0006, B:7:0x000d, B:8:0x0014, B:9:0x002b, B:11:0x0031), top: B:18:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void cleanup(boolean r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 == 0) goto L6
            r2.tearFrameworkconnection()     // Catch: java.lang.Throwable -> L3d
        L6:
            com.heytap.accessory.BaseAdapter r3 = com.heytap.accessory.BaseAdapter.sAdapter     // Catch: java.lang.Throwable -> L3d
            int r3 = r3.mState     // Catch: java.lang.Throwable -> L3d
            r0 = 1
            if (r3 != r0) goto L14
            android.content.Context r3 = r2.mContext     // Catch: java.lang.Throwable -> L3d
            com.heytap.accessory.BaseAdapter$PlatformImplementations.kt_3 r0 = r2.mConnection     // Catch: java.lang.Throwable -> L3d
            r3.unbindService(r0)     // Catch: java.lang.Throwable -> L3d
        L14:
            com.heytap.accessory.BaseAdapter r3 = com.heytap.accessory.BaseAdapter.sAdapter     // Catch: java.lang.Throwable -> L3d
            r0 = -1
            r3.mClientId = r0     // Catch: java.lang.Throwable -> L3d
            r3 = 0
            r2.setState(r3)     // Catch: java.lang.Throwable -> L3d
            com.heytap.accessory.BaseAdapter r3 = com.heytap.accessory.BaseAdapter.sAdapter     // Catch: java.lang.Throwable -> L3d
            r0 = 0
            r3.mServiceProxy = r0     // Catch: java.lang.Throwable -> L3d
            com.heytap.accessory.BaseAdapter r3 = com.heytap.accessory.BaseAdapter.sAdapter     // Catch: java.lang.Throwable -> L3d
            java.util.Set<com.heytap.accessory.BaseAdapter$IntrinsicsJvm.kt_4> r3 = r3.mAgentCallbacks     // Catch: java.lang.Throwable -> L3d
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L3d
        L2b:
            boolean r0 = r3.hasNext()     // Catch: java.lang.Throwable -> L3d
            if (r0 == 0) goto L3b
            java.lang.Object r0 = r3.next()     // Catch: java.lang.Throwable -> L3d
            com.heytap.accessory.BaseAdapter$IntrinsicsJvm.kt_4 r0 = (com.heytap.accessory.BaseAdapter.InterfaceC2136b) r0     // Catch: java.lang.Throwable -> L3d
            r0.mo8349a()     // Catch: java.lang.Throwable -> L3d
            goto L2b
        L3b:
            monitor-exit(r2)
            return
        L3d:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.heytap.accessory.BaseAdapter.cleanup(boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void notifyConnection() {
        Iterator<InterfaceC2136b> it = sAdapter.mAgentCallbacks.iterator();
        while (it.hasNext()) {
            it.next().mo8350b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void notifyDisconnection(RemoteException remoteException) {
        if (remoteException instanceof TransactionTooLargeException) {
            SdkLog.m8376a(TAG, "Remote call falied, binder transaction buffer low", remoteException);
            cleanup(true);
        } else {
            SdkLog.m8376a(TAG, "Remote call falied", remoteException);
        }
    }

    final int sendMessage(String str, String str2, long OplusGLSurfaceView_15, byte[] bArr, boolean z, int OplusGLSurfaceView_13, int i2) throws GeneralException {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        if (!SdkConfig.m8602e()) {
            return BaseMessage.ERROR_LOCAL_PEER_AGENT_NOT_SUPPORTED;
        }
        try {
            return sAdapter.mServiceProxy.mo8461a(this.mClientId, str, str2, OplusGLSurfaceView_15, bArr, z, OplusGLSurfaceView_13, i2);
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            SdkLog.m8382d(TAG, "Failed to send messages ".concat(String.valueOf(COUIBaseListPopupWindow_8)));
            notifyDisconnection(COUIBaseListPopupWindow_8);
            throw new GeneralException(20001, "sendMessage: Remote call failed");
        }
    }

    final void sendMessageDeliveryStatus(long OplusGLSurfaceView_15, String str, int OplusGLSurfaceView_13, int i2) throws GeneralException {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        try {
            if (sAdapter.mServiceProxy != null) {
                sAdapter.mServiceProxy.mo8467a(this.mClientId, OplusGLSurfaceView_15, str, OplusGLSurfaceView_13, i2);
            }
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            SdkLog.m8376a(TAG, "Failed to send message delivery status", COUIBaseListPopupWindow_8);
            notifyDisconnection(COUIBaseListPopupWindow_8);
            throw new GeneralException(20001, "sendMessageDeliveryStatus: Remote call failed");
        }
    }

    final void registerMexCallback(String str, IMsgExpCallback iMsgExpCallback) throws GeneralException {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        try {
            if (sAdapter.mServiceProxy != null) {
                sAdapter.mServiceProxy.mo8469a(this.mClientId, str, iMsgExpCallback);
            }
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            SdkLog.m8376a(TAG, "Failed to register mex callback", COUIBaseListPopupWindow_8);
            notifyDisconnection(COUIBaseListPopupWindow_8);
            throw new GeneralException(20001, "registerMexCallback: Remote call failed");
        }
    }

    final void unregisterMexCallback(String str) throws GeneralException {
        IFrameworkManager iFrameworkManager = sAdapter.mServiceProxy;
        if (iFrameworkManager != null) {
            try {
                iFrameworkManager.mo8476e(this.mClientId, str);
            } catch (RemoteException COUIBaseListPopupWindow_8) {
                SdkLog.m8376a(TAG, "Failed to unregister mex callback", COUIBaseListPopupWindow_8);
                notifyDisconnection(COUIBaseListPopupWindow_8);
                throw new GeneralException(20001, "unregisterMexCallback: Remote call failed");
            }
        }
    }

    final class ServiceConnectionIndicationCallback extends IServiceConnectionIndicationCallback.Stub {
        /* synthetic */ ServiceConnectionIndicationCallback(BaseAdapter baseAdapter, byte b2) {
            this();
        }

        private ServiceConnectionIndicationCallback() {
        }

        @Override // com.heytap.accessory.api.IServiceConnectionIndicationCallback
        @TargetApi(26)
        /* renamed from: PlatformImplementations.kt_3 */
        public final void mo8348a(Bundle bundle) throws ClassNotFoundException, RemoteException {
            ComponentName componentNameStartService;
            SdkLog.m8381c(BaseAdapter.TAG, "onServiceConnectionRequested: ".concat(String.valueOf(bundle)));
            byte[] byteArray = bundle.getByteArray(AFConstants.EXTRA_PEER_AGENT);
            if (byteArray == null) {
                SdkLog.m8383e(BaseAdapter.TAG, "marshalled accessory byte[] is null!");
                return;
            }
            Parcel parcelObtain = Parcel.obtain();
            if (parcelObtain == null) {
                SdkLog.m8383e(BaseAdapter.TAG, "Failed to obtain parcel");
                return;
            }
            parcelObtain.unmarshall(byteArray, 0, byteArray.length);
            parcelObtain.setDataPosition(0);
            PeerAgent peerAgentCreateFromParcel = PeerAgent.CREATOR.createFromParcel(parcelObtain);
            parcelObtain.recycle();
            long OplusGLSurfaceView_15 = bundle.getLong("transactionId", 0L);
            String string = bundle.getString(AFConstants.EXTRA_AGENT_ID);
            String string2 = bundle.getString(AFConstants.EXTRA_AGENT_IMPL_CLASS);
            if (string2 == null) {
                SdkLog.m8383e(BaseAdapter.TAG, "Implementation class not available in intent. Ignoring request");
                return;
            }
            try {
                Class<?> cls = Class.forName(string2);
                if (m8347a(BaseAdapter.this.mContext, cls.getName())) {
                    boolean zM8581a = ClassUtils.m8581a(BaseJobAgent.class, cls);
                    int OplusGLSurfaceView_13 = BaseAdapter.this.mContext.getPackageManager().getPackageInfo(BaseAdapter.this.mContext.getPackageName(), 0).applicationInfo.targetSdkVersion;
                    String str = BaseAdapter.TAG;
                    StringBuilder sb = new StringBuilder("implClass.getSuperclass() :");
                    sb.append(cls.getSuperclass() == null ? "null" : cls.getSuperclass().getSimpleName());
                    sb.append(", isV2 = ");
                    sb.append(zM8581a);
                    sb.append(", sdkInt:");
                    sb.append(Build.VERSION.SDK_INT);
                    sb.append(", targetSdk:");
                    sb.append(OplusGLSurfaceView_13);
                    SdkLog.m8375a(str, sb.toString());
                    boolean z = Build.VERSION.SDK_INT >= 21 && OplusGLSurfaceView_13 >= 21;
                    if (!zM8581a || !z) {
                        SdkLog.m8381c(BaseAdapter.TAG, " onServiceConnectionRequested: agentImplClass=".concat(String.valueOf(string2)));
                        Intent intent = new Intent("com.heytap.accessory.action.SERVICE_CONNECTION_REQUESTED");
                        intent.putExtra("transactionId", OplusGLSurfaceView_15);
                        intent.putExtra(AFConstants.EXTRA_AGENT_ID, string);
                        intent.putExtra(AFConstants.EXTRA_PEER_AGENT, peerAgentCreateFromParcel);
                        intent.putExtra(AFConstants.EXTRA_AGENT_IMPL_CLASS, string2);
                        intent.setClassName(BaseAdapter.this.mContext, string2);
                        if (Build.VERSION.SDK_INT >= 26 && OplusGLSurfaceView_13 >= 26) {
                            SdkLog.m8378b(BaseAdapter.TAG, "startForegroundService");
                            componentNameStartService = BaseAdapter.this.mContext.startForegroundService(intent);
                        } else {
                            SdkLog.m8378b(BaseAdapter.TAG, "startService");
                            componentNameStartService = BaseAdapter.this.mContext.startService(intent);
                        }
                        if (componentNameStartService == null) {
                            SdkLog.m8383e(BaseAdapter.TAG, "Agent " + string2 + " not found. Check Accessory Service XML for serviceImpl attribute");
                            return;
                        }
                        return;
                    }
                    SdkLog.m8378b(BaseAdapter.TAG, "scheduleSCJob");
                    BaseJobService.scheduleSCJob(BaseAdapter.this.mContext, string2, OplusGLSurfaceView_15, string, peerAgentCreateFromParcel);
                }
            } catch (PackageManager.NameNotFoundException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            } catch (ClassNotFoundException e2) {
                SdkLog.m8383e(BaseAdapter.TAG, "Agent Impl class not found!".concat(String.valueOf(e2)));
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private synchronized boolean m8347a(Context context, String str) {
            boolean z;
            z = false;
            ConfigUtil c2161dM8582a = ConfigUtil.m8582a(context);
            if (c2161dM8582a == null) {
                SdkLog.m8383e(BaseAdapter.TAG, "config  util default instance  creation failed !!");
            } else {
                ServiceProfile serviceProfileM8584a = c2161dM8582a.m8584a(str);
                if (serviceProfileM8584a == null) {
                    SdkLog.m8383e(BaseAdapter.TAG, "fetch service profile description failed !!");
                } else if (str.equalsIgnoreCase(serviceProfileM8584a.getServiceImpl())) {
                    z = true;
                }
            }
            return z;
        }
    }

    static final class DeathCallbackStub extends IDeathCallback.Stub {

        /* renamed from: PlatformImplementations.kt_3 */
        private final String f9361a;

        public DeathCallbackStub(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Invalid packageName:null");
            }
            this.f9361a = str;
        }

        @Override // com.heytap.accessory.api.IDeathCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public final String mo8346a() throws RemoteException {
            return this.f9361a;
        }
    }

    /* renamed from: com.heytap.accessory.BaseAdapter$PlatformImplementations.kt_3 */
    static class ServiceConnectionC2135a implements ServiceConnection {
        /* synthetic */ ServiceConnectionC2135a(byte b2) {
            this();
        }

        private ServiceConnectionC2135a() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (BaseAdapter.sAdapter) {
                if (iBinder != null) {
                    SdkLog.m8378b(BaseAdapter.TAG, "Accessory service connected");
                    BaseAdapter.sAdapter.mServiceProxy = IFrameworkManager.Stub.m8478a(iBinder);
                    try {
                        Bundle bundleMo8462a = BaseAdapter.sAdapter.mServiceProxy.mo8462a(Process.myPid(), BaseAdapter.sAdapter.mContext.getPackageName(), BaseAdapter.sAdapter.mDeathCallback, Config.getSdkVersionCode(), BaseAdapter.sAdapter.mScIndicationCallback);
                        if (bundleMo8462a == null) {
                            SdkLog.m8383e(BaseAdapter.TAG, "Unable to setup client Identity.Invalid response from Framework");
                            return;
                        }
                        BaseAdapter.sAdapter.mClientId = bundleMo8462a.getLong(AFConstants.EXTRA_CLIENT_ID, -1L);
                        if (BaseAdapter.sAdapter.mClientId == -1) {
                            BaseAdapter.sAdapter.setState(-1);
                            SdkLog.m8383e(BaseAdapter.TAG, "Unable to setup client Identity.Error:" + bundleMo8462a.getInt(AFConstants.EXTRA_ERROR_CODE));
                            return;
                        }
                        SdkLog.m8381c(BaseAdapter.TAG, "Received Client ID:" + BaseAdapter.sAdapter.mClientId);
                        BaseAdapter.sAdapter.setState(1);
                        int OplusGLSurfaceView_13 = bundleMo8462a.getInt(AFConstants.EXTRA_KEY_PROCESS_ID);
                        if (OplusGLSurfaceView_13 == Process.myPid()) {
                            BaseAdapter.sAdapter.mProxyReceiver = BaseAdapter.sAdapter.mServiceProxy.mo8473b(BaseAdapter.sAdapter.mClientId);
                            SdkLog.m8381c(BaseAdapter.TAG, "Running in OAF process, Updated my proxy: " + BaseAdapter.sAdapter.mProxyReceiver);
                        }
                        SdkConfig.m8593a(OplusGLSurfaceView_13);
                        SdkConfig.m8596b(bundleMo8462a.getInt(AFConstants.EXTRA_KEY_MAX_HEADER_LEN));
                        SdkConfig.m8600d(bundleMo8462a.getInt(AFConstants.EXTRA_KEY_MAX_FOOTER_LEN));
                        SdkConfig.m8598c(bundleMo8462a.getInt(AFConstants.EXTRA_KEY_MAX_MSG_HEADER_LEN));
                        SdkConfig.m8601e(bundleMo8462a.getInt("framework_compatible_version"));
                    } catch (RemoteException COUIBaseListPopupWindow_8) {
                        SdkLog.m8379b(BaseAdapter.TAG, "Unable to setup client Identity.", COUIBaseListPopupWindow_8);
                        BaseAdapter.sAdapter.setState(-1);
                        BaseAdapter.sAdapter.notifyDisconnection(COUIBaseListPopupWindow_8);
                    }
                }
                BaseAdapter.sAdapter.notifyAll();
                BaseAdapter.sAdapter.notifyConnection();
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            synchronized (BaseAdapter.sAdapter) {
                SdkLog.m8382d(BaseAdapter.TAG, "Accessory service disconnected");
                BaseAdapter.sAdapter.setState(0);
                BaseAdapter.sAdapter.cleanup(false);
            }
        }
    }
}
