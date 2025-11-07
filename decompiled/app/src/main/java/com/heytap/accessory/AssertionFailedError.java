package com.heytap.accessory;

/* loaded from: classes2.dex */
public final class BaseAdapter {
    public static final java.lang.String ACTION_ACCESSORY_STATUS_CHANGED = "com.heytap.accessory.action.ACCESSORY_STATUS_CHANGED";
    public static final java.lang.String ACTION_SERVICE_CONNECTION_REQUESTED = "com.heytap.accessory.action.SERVICE_CONNECTION_REQUESTED";
    private static final int BIND_SERVICE_MAX_ATTEMPTS = 5;
    private static final int ERROR_FATAL = 20001;
    private static final int ERROR_PERMISSION_DENIED = 20003;
    private static final int ERROR_PERMISSION_FAILED = 20004;
    private static final java.lang.String TAG = "BaseAdapter";
    private static com.heytap.accessory.BaseAdapter sAdapter;
    private android.os.Handler mBackgroundHandler;
    private final com.heytap.accessory.BaseAdapter.a_renamed mConnection;
    private final android.content.Context mContext;
    private final com.heytap.accessory.api.IDeathCallback mDeathCallback;
    private android.os.ResultReceiver mProxyReceiver;
    private final com.heytap.accessory.BaseAdapter.ServiceConnectionIndicationCallback mScIndicationCallback;
    private com.heytap.accessory.api.IFrameworkManager mServiceProxy;
    private long mClientId = -1;
    private int mState = 0;
    private final java.util.Set<com.heytap.accessory.BaseAdapter.b_renamed> mAgentCallbacks = new java.util.HashSet();

    interface b_renamed {
        void a_renamed();

        void b_renamed();

        void c_renamed() throws com.heytap.accessory.bean.GeneralException;
    }

    private BaseAdapter(android.content.Context context, android.os.Handler handler) {
        this.mContext = context;
        byte b2 = 0;
        this.mConnection = new com.heytap.accessory.BaseAdapter.a_renamed(b2);
        this.mDeathCallback = new com.heytap.accessory.BaseAdapter.DeathCallbackStub(context.getPackageName());
        this.mScIndicationCallback = new com.heytap.accessory.BaseAdapter.ServiceConnectionIndicationCallback(this, b2);
        this.mBackgroundHandler = handler;
    }

    public static synchronized com.heytap.accessory.BaseAdapter getDefaultAdapter(android.content.Context context) {
        android.content.Context applicationContext = context.getApplicationContext();
        if (sAdapter == null) {
            sAdapter = new com.heytap.accessory.BaseAdapter(applicationContext, null);
        }
        return sAdapter;
    }

    static synchronized com.heytap.accessory.BaseAdapter getDefaultAdapter(android.content.Context context, android.os.Handler handler) {
        android.content.Context applicationContext = context.getApplicationContext();
        if (sAdapter == null) {
            sAdapter = new com.heytap.accessory.BaseAdapter(applicationContext, handler);
        }
        return sAdapter;
    }

    final void bindToFramework() {
        if (android.os.Looper.getMainLooper() == android.os.Looper.myLooper()) {
            com.heytap.accessory.a_renamed.a_renamed.d_renamed(TAG, "It's_renamed in_renamed main thread,need to switch to sub thread!");
            android.os.Handler handler = this.mBackgroundHandler;
            if (handler == null) {
                com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "BackgroundHandler is_renamed null, so just return!");
                return;
            } else {
                handler.post(new java.lang.Runnable() { // from class: com.heytap.accessory.BaseAdapter.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            com.heytap.accessory.BaseAdapter.this.doBindFramework();
                        } catch (com.heytap.accessory.bean.GeneralException e_renamed) {
                            com.heytap.accessory.a_renamed.a_renamed.b_renamed(com.heytap.accessory.BaseAdapter.TAG, "bindToFramework failed!", e_renamed);
                        }
                    }
                });
                return;
            }
        }
        try {
            doBindFramework();
        } catch (com.heytap.accessory.bean.GeneralException e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "bindToFramework failed!", e_renamed);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void doBindFramework() throws com.heytap.accessory.bean.GeneralException {
        if (sAdapter.mServiceProxy == null) {
            setState(0);
            try {
                com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "context packageName - " + this.mContext.getPackageName());
                com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "adapter context packageName - " + sAdapter.mContext.getPackageName());
                android.content.Intent intent = new android.content.Intent("com.heytap.accessory.action.FRAMEWORK_MANAGER");
                if (com.heytap.accessory.Initializer.useOAFApp()) {
                    intent.setPackage(com.heytap.accessory.api.ManagerConfig.ACCESSORY_FRAMEWORK_PACKAGE);
                } else {
                    intent.setPackage(this.mContext.getPackageName());
                }
                intent.putExtra("accessory_framework_request_package", this.mContext.getPackageName());
                for (int i_renamed = 1; sAdapter.mClientId == -1 && getState() == 0 && i_renamed <= 5; i_renamed++) {
                    if (!this.mContext.bindService(intent, sAdapter.mConnection, 1)) {
                        com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "getDefaultAdapter: Binding to Accessory service failed!");
                        setState(-1);
                        throw new com.heytap.accessory.bean.GeneralException(20001, "Is the Accessory Service Framework installed?!");
                    }
                    try {
                        com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "getDefaultAdapter: About start waiting");
                        sAdapter.wait(10000L);
                    } catch (java.lang.InterruptedException e_renamed) {
                        setState(-1);
                        throw new com.heytap.accessory.bean.GeneralException(20001, "Failed to Bind to Accessory Framework - Action interrupted!", e_renamed);
                    }
                }
                if (sAdapter.mServiceProxy == null) {
                    com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "getDefaultAdapter: Service Connection proxy is_renamed null!");
                    setState(-1);
                    throw new com.heytap.accessory.bean.GeneralException(20001, "Unable to bind to Accessory Service!");
                }
                com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "Application is_renamed now connected to Accessory Framework!");
            } catch (java.lang.SecurityException unused) {
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "getDefaultAdapter: Permission denied! Binding to Accessory service failed!");
                setState(-1);
                if (com.heytap.accessory.b_renamed.g_renamed.a_renamed(this.mContext)) {
                    throw new com.heytap.accessory.bean.GeneralException(20004, "Permission validation failed to bind to  Accessory Service! Please re-install the application and try again.");
                }
                throw new com.heytap.accessory.bean.GeneralException(20003, "Permission denied to bind to Accessory Service! Please add permission and try again.");
            }
        }
    }

    final synchronized void registerAgentCallback(com.heytap.accessory.BaseAdapter.b_renamed bVar) {
        this.mAgentCallbacks.add(bVar);
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "Agent callback added. Current size - " + this.mAgentCallbacks.size());
    }

    final synchronized void unregisterAgentCallback(com.heytap.accessory.BaseAdapter.b_renamed bVar) {
        this.mAgentCallbacks.remove(bVar);
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "Agent callback removed. Current size - " + this.mAgentCallbacks.size());
        if (this.mAgentCallbacks.isEmpty()) {
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "All clients have unregistered.Disconnection from Accessory Framework.");
            cleanup(true);
        }
    }

    final synchronized int getState() {
        return this.mState;
    }

    final synchronized void setState(int i_renamed) {
        this.mState = i_renamed;
    }

    final int getVersion() throws com.heytap.accessory.bean.GeneralException {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        try {
            if (sAdapter.mServiceProxy != null) {
                return sAdapter.mServiceProxy.a_renamed();
            }
            throw new com.heytap.accessory.bean.GeneralException(20001, "getVersion:mServiceProxy is_renamed null");
        } catch (android.os.RemoteException e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.a_renamed(TAG, "Failed to get version", e_renamed);
            notifyDisconnection(e_renamed);
            throw new com.heytap.accessory.bean.GeneralException(20001, "getVersion:Remote call failed");
        }
    }

    final synchronized int checkAuthentication() throws com.heytap.accessory.bean.GeneralException {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        try {
            if (sAdapter.mServiceProxy == null) {
                return com.heytap.accessory.CommonStatusCodes.INTERNAL_EXCEPTION;
            }
            return sAdapter.mServiceProxy.a_renamed(com.heytap.accessory.Config.getSdkVersionCode());
        } catch (android.os.RemoteException e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.a_renamed(TAG, "Service authenticate failed", e_renamed);
            notifyDisconnection(e_renamed);
            throw new com.heytap.accessory.bean.GeneralException(20001, "authenticate:Remote call failed");
        }
    }

    final synchronized boolean checkAuthentication(java.lang.String str) throws com.heytap.accessory.bean.GeneralException {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        try {
            if (sAdapter.mServiceProxy == null) {
                return false;
            }
            return sAdapter.mServiceProxy.a_renamed(com.heytap.accessory.Config.getSdkVersionCode(), str);
        } catch (android.os.RemoteException e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.a_renamed(TAG, "Service authenticate failed", e_renamed);
            notifyDisconnection(e_renamed);
            throw new com.heytap.accessory.bean.GeneralException(20001, "authenticate:Remote call failed");
        }
    }

    final synchronized void registerServices(byte[] bArr) throws com.heytap.accessory.bean.GeneralException {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        try {
            if (sAdapter.mServiceProxy != null) {
                sAdapter.mServiceProxy.a_renamed(this.mClientId, bArr);
            }
            java.util.Iterator<com.heytap.accessory.BaseAdapter.b_renamed> it = this.mAgentCallbacks.iterator();
            while (it.hasNext()) {
                it.next().c_renamed();
            }
        } catch (android.os.RemoteException e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.a_renamed(TAG, "Service registration call failed", e_renamed);
            notifyDisconnection(e_renamed);
            throw new com.heytap.accessory.bean.GeneralException(20001, "registerServices:Remote call failed");
        }
    }

    public final synchronized java.lang.String getLocalAgentId(java.lang.String str) throws com.heytap.accessory.bean.GeneralException {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        try {
            android.os.Bundle bundleA = sAdapter.mServiceProxy != null ? sAdapter.mServiceProxy.a_renamed(this.mClientId, str) : null;
            if (bundleA == null) {
                com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "getLocalAgentId failed", new java.lang.RuntimeException("Get Local agent ID_renamed:Invalid response from accessory framework - null"));
            } else if (bundleA.containsKey(com.heytap.accessory.constant.AFConstants.EXTRA_ERROR_CODE)) {
                int i_renamed = bundleA.getInt(com.heytap.accessory.constant.AFConstants.EXTRA_ERROR_CODE);
                com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "getLocalAgentId failed", new com.heytap.accessory.bean.GeneralException(i_renamed, "Failed to fetch localAgent ID_renamed, errorCode = ".concat(java.lang.String.valueOf(i_renamed))));
            } else {
                java.lang.String string = bundleA.getString(com.heytap.accessory.constant.AFConstants.EXTRA_AGENT_ID);
                if (string != null) {
                    return string;
                }
                com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "getLocalAgentId failed", new java.lang.RuntimeException("Get Local agent ID_renamed:Invalid response - localAgentID:null"));
            }
            return null;
        } catch (android.os.RemoteException e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.a_renamed(TAG, "Failed to fetch localAgent ID_renamed", e_renamed);
            notifyDisconnection(e_renamed);
            throw new com.heytap.accessory.bean.GeneralException(20001, "getLocalAgentId:Remote call failed");
        }
    }

    final java.lang.String getAgentId(java.lang.String str, java.lang.String str2) throws com.heytap.accessory.bean.GeneralException {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        try {
            if (sAdapter.mServiceProxy != null) {
                return sAdapter.mServiceProxy.a_renamed(this.mClientId, str, str2);
            }
            throw new com.heytap.accessory.bean.GeneralException(20001, "getAgentId:mServiceProxy is_renamed null");
        } catch (android.os.RemoteException e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.a_renamed(TAG, "Failed to fetch agent ID_renamed", e_renamed);
            notifyDisconnection(e_renamed);
            throw new com.heytap.accessory.bean.GeneralException(20001, "getAgentId:Remote call failed");
        }
    }

    final int findPeerAgents(java.lang.String str, com.heytap.accessory.api.IPeerAgentCallback iPeerAgentCallback) throws com.heytap.accessory.bean.GeneralException {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        try {
            if (sAdapter.mServiceProxy != null) {
                return sAdapter.mServiceProxy.a_renamed(this.mClientId, -1L, str, iPeerAgentCallback);
            }
            throw new com.heytap.accessory.bean.GeneralException(20001, "findPeerAgents:mServiceProxy is_renamed null");
        } catch (android.os.RemoteException e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.a_renamed(TAG, "Failed to initiate peer discovery", e_renamed);
            notifyDisconnection(e_renamed);
            throw new com.heytap.accessory.bean.GeneralException(20001, "findPeerAgents:Remote call failed");
        }
    }

    final int requestServiceConnection(java.lang.String str, com.heytap.accessory.bean.PeerAgent peerAgent, com.heytap.accessory.api.IServiceConnectionCallback iServiceConnectionCallback, com.heytap.accessory.api.IServiceChannelCallback iServiceChannelCallback) throws com.heytap.accessory.bean.GeneralException {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        try {
            return this.mServiceProxy.a_renamed(this.mClientId, str, peerAgent, iServiceConnectionCallback, iServiceChannelCallback);
        } catch (android.os.RemoteException e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.a_renamed(TAG, "Failed to request service connection", e_renamed);
            this.notifyDisconnection(e_renamed);
            throw new com.heytap.accessory.bean.GeneralException(20001, "requestServiceConnection:Remote call failed");
        }
    }

    final android.os.Bundle acceptServiceConnection(java.lang.String str, com.heytap.accessory.bean.PeerAgent peerAgent, long j_renamed, com.heytap.accessory.api.IServiceConnectionCallback iServiceConnectionCallback, com.heytap.accessory.api.IServiceChannelCallback iServiceChannelCallback) throws com.heytap.accessory.bean.GeneralException {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        try {
            android.os.Bundle bundleA = this.mServiceProxy.a_renamed(this.mClientId, str, peerAgent, j_renamed, iServiceConnectionCallback, iServiceChannelCallback);
            if (bundleA == null) {
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "acceptServiceConnection:Invalid response from Accessory Framework:".concat(java.lang.String.valueOf(bundleA)));
                throw new java.lang.RuntimeException("acceptServiceConnection:Invalid response from Accessory Framework:".concat(java.lang.String.valueOf(bundleA)));
            }
            if (bundleA.containsKey(com.heytap.accessory.constant.AFConstants.EXTRA_ERROR_CODE)) {
                throw new com.heytap.accessory.bean.GeneralException(bundleA.getInt(com.heytap.accessory.constant.AFConstants.EXTRA_ERROR_CODE), "Failed to accept connection request!");
            }
            java.lang.String string = bundleA.getString("connectionId");
            if (string != null) {
                return bundleA;
            }
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "acceptServiceConnection:Invalid response from Accessory Framework- connectionId:".concat(java.lang.String.valueOf(string)));
            throw new java.lang.RuntimeException("acceptServiceConnection:Invalid response from Accessory Framework- connectionId:".concat(java.lang.String.valueOf(string)));
        } catch (android.os.RemoteException e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.a_renamed(TAG, "Failed to accept service connection", e_renamed);
            notifyDisconnection(e_renamed);
            throw new com.heytap.accessory.bean.GeneralException(20001, "acceptServiceConnection:Remote call failed");
        }
    }

    final int rejectServiceConnection(java.lang.String str, com.heytap.accessory.bean.PeerAgent peerAgent, long j_renamed) throws com.heytap.accessory.bean.GeneralException {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        try {
            return this.mServiceProxy.a_renamed(this.mClientId, str, peerAgent, j_renamed);
        } catch (android.os.RemoteException e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.a_renamed(TAG, "Failed to reject service connection", e_renamed);
            this.notifyDisconnection(e_renamed);
            throw new com.heytap.accessory.bean.GeneralException(20001, "rejectServiceConnection:Remote call failed");
        }
    }

    final int closeServiceConnection(java.lang.String str) throws com.heytap.accessory.bean.GeneralException {
        if (sAdapter.mServiceProxy == null) {
            return com.heytap.accessory.BaseSocket.ERROR_CONNECTION_ALREADY_CLOSED;
        }
        try {
            return this.mServiceProxy.b_renamed(this.mClientId, str);
        } catch (android.os.RemoteException e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.a_renamed(TAG, "Failed to close service connection", e_renamed);
            this.notifyDisconnection(e_renamed);
            throw new com.heytap.accessory.bean.GeneralException(20001, "closeServiceConnection:Remote call failed");
        }
    }

    final int send(com.heytap.accessory.bean.PeerAgent peerAgent, java.lang.String str, int i_renamed, byte[] bArr, boolean z_renamed, int i2, int i3, int i4, boolean z2) throws com.heytap.accessory.bean.GeneralException {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        try {
            java.lang.String str2 = TAG;
            java.lang.StringBuilder sb = new java.lang.StringBuilder("sendData,connectionId:");
            try {
                sb.append(str);
                sb.append(",channelId:");
                sb.append(i_renamed);
                sb.append(",dataLen:");
                sb.append(bArr.length);
                sb.append(",compatibleVersion:");
                sb.append(com.heytap.accessory.b_renamed.g_renamed.f_renamed());
                com.heytap.accessory.a_renamed.a_renamed.a_renamed(str2, sb.toString());
                if (com.heytap.accessory.b_renamed.g_renamed.f_renamed() > 0) {
                    return this.mServiceProxy.a_renamed(peerAgent.getAccessoryId(), peerAgent.getAgentId(), this.mClientId, str, i_renamed, bArr, z_renamed, i2, i3, i4, z2);
                }
                return this.mServiceProxy.a_renamed(this.mClientId, str, i_renamed, bArr, z_renamed, i2, i3, i4);
            } catch (android.os.RemoteException e_renamed) {
                e_renamed = e_renamed;
                com.heytap.accessory.a_renamed.a_renamed.a_renamed(TAG, "Failed send data for connection:".concat(java.lang.String.valueOf(str)), e_renamed);
                notifyDisconnection(e_renamed);
                throw new com.heytap.accessory.bean.GeneralException(20001, "send: Remote call failed");
            }
        } catch (android.os.RemoteException e2) {
            e_renamed = e2;
        }
    }

    final boolean isSocketConnected(java.lang.String str) throws com.heytap.accessory.bean.GeneralException {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        try {
            return this.mServiceProxy.d_renamed(this.mClientId, str);
        } catch (android.os.RemoteException e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.a_renamed(TAG, "Failed to fetch socket connection status", e_renamed);
            this.notifyDisconnection(e_renamed);
            throw new com.heytap.accessory.bean.GeneralException(20001, "isSocketConnected:Remote call failed");
        }
    }

    final int authenticatePeeragent(java.lang.String str, com.heytap.accessory.bean.PeerAgent peerAgent, com.heytap.accessory.api.IPeerAgentAuthCallback iPeerAgentAuthCallback, long j_renamed) throws com.heytap.accessory.bean.GeneralException {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        try {
            return this.mServiceProxy.a_renamed(this.mClientId, str, peerAgent, iPeerAgentAuthCallback, j_renamed);
        } catch (android.os.RemoteException e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.a_renamed(TAG, "Failed to request peer authentication", e_renamed);
            this.notifyDisconnection(e_renamed);
            throw new com.heytap.accessory.bean.GeneralException(20001, "authenticatePeeragent:Remote call failed");
        }
    }

    final void cleanupAgent(java.lang.String str) {
        if (sAdapter.mServiceProxy == null) {
            com.heytap.accessory.a_renamed.a_renamed.d_renamed(TAG, "Binding to framework does not exists");
            return;
        }
        try {
            this.mServiceProxy.f_renamed(this.mClientId, str);
        } catch (android.os.RemoteException e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.a_renamed(TAG, "Failed to cleanup agent details", e_renamed);
        }
    }

    final void cleanupChannel(java.lang.String str, int i_renamed) throws com.heytap.accessory.bean.GeneralException {
        if (sAdapter.mServiceProxy == null) {
            com.heytap.accessory.a_renamed.a_renamed.d_renamed(TAG, "cleanupChannel failed, Binding to framework does not exists");
            return;
        }
        try {
            this.mServiceProxy.a_renamed(this.mClientId, str, i_renamed);
        } catch (android.os.RemoteException e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.a_renamed(TAG, "Failed to cleanupChannelCache", e_renamed);
            throw new com.heytap.accessory.bean.GeneralException(20001, "authenticatePeeragent:Remote call failed");
        }
    }

    final android.os.Bundle getAgentDetails(java.lang.String str) throws com.heytap.accessory.bean.GeneralException {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        try {
            return this.mServiceProxy.c_renamed(this.mClientId, str);
        } catch (android.os.RemoteException e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.a_renamed(TAG, "Failed to get agent details", e_renamed);
            this.notifyDisconnection(e_renamed);
            throw new com.heytap.accessory.bean.GeneralException(20001, "getAgentDetails: Remote call failed");
        }
    }

    final java.lang.String getPackageName() {
        return this.mContext.getPackageName();
    }

    final synchronized void recycle(byte[] bArr) {
        if (sAdapter.mProxyReceiver != null) {
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putByteArray(com.heytap.accessory.constant.AFConstants.EXTRA_READ_BYTES, bArr);
            sAdapter.mProxyReceiver.send(0, bundle);
        }
    }

    private synchronized void tearFrameworkconnection() {
        if (this.mServiceProxy == null) {
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "Binding to framework does not exists");
            return;
        }
        try {
            this.mServiceProxy.a_renamed(this.mClientId);
        } catch (android.os.RemoteException e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.a_renamed(TAG, "Failed to tear framework connection", e_renamed);
        } finally {
            cleanup(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B_renamed:11:0x0031 A_renamed[Catch: all -> 0x003d, LOOP:0: B_renamed:9:0x002b->B_renamed:11:0x0031, LOOP_END, TRY_LEAVE, TryCatch #0 {, blocks: (B_renamed:4:0x0003, B_renamed:5:0x0006, B_renamed:7:0x000d, B_renamed:8:0x0014, B_renamed:9:0x002b, B_renamed:11:0x0031), top: B_renamed:18:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:7:0x000d A_renamed[Catch: all -> 0x003d, TryCatch #0 {, blocks: (B_renamed:4:0x0003, B_renamed:5:0x0006, B_renamed:7:0x000d, B_renamed:8:0x0014, B_renamed:9:0x002b, B_renamed:11:0x0031), top: B_renamed:18:0x0003 }] */
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
            com.heytap.accessory.BaseAdapter$a_renamed r0 = r2.mConnection     // Catch: java.lang.Throwable -> L3d
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
            java.util.Set<com.heytap.accessory.BaseAdapter$b_renamed> r3 = r3.mAgentCallbacks     // Catch: java.lang.Throwable -> L3d
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L3d
        L2b:
            boolean r0 = r3.hasNext()     // Catch: java.lang.Throwable -> L3d
            if (r0 == 0) goto L3b
            java.lang.Object r0 = r3.next()     // Catch: java.lang.Throwable -> L3d
            com.heytap.accessory.BaseAdapter$b_renamed r0 = (com.heytap.accessory.BaseAdapter.b_renamed) r0     // Catch: java.lang.Throwable -> L3d
            r0.a_renamed()     // Catch: java.lang.Throwable -> L3d
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
        java.util.Iterator<com.heytap.accessory.BaseAdapter.b_renamed> it = sAdapter.mAgentCallbacks.iterator();
        while (it.hasNext()) {
            it.next().b_renamed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void notifyDisconnection(android.os.RemoteException remoteException) {
        if (remoteException instanceof android.os.TransactionTooLargeException) {
            com.heytap.accessory.a_renamed.a_renamed.a_renamed(TAG, "Remote call falied, binder transaction buffer low", remoteException);
            cleanup(true);
        } else {
            com.heytap.accessory.a_renamed.a_renamed.a_renamed(TAG, "Remote call falied", remoteException);
        }
    }

    final int sendMessage(java.lang.String str, java.lang.String str2, long j_renamed, byte[] bArr, boolean z_renamed, int i_renamed, int i2) throws com.heytap.accessory.bean.GeneralException {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        if (!com.heytap.accessory.b_renamed.g_renamed.e_renamed()) {
            return com.heytap.accessory.BaseMessage.ERROR_LOCAL_PEER_AGENT_NOT_SUPPORTED;
        }
        try {
            return sAdapter.mServiceProxy.a_renamed(this.mClientId, str, str2, j_renamed, bArr, z_renamed, i_renamed, i2);
        } catch (android.os.RemoteException e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.d_renamed(TAG, "Failed to send messages ".concat(java.lang.String.valueOf(e_renamed)));
            notifyDisconnection(e_renamed);
            throw new com.heytap.accessory.bean.GeneralException(20001, "sendMessage: Remote call failed");
        }
    }

    final void sendMessageDeliveryStatus(long j_renamed, java.lang.String str, int i_renamed, int i2) throws com.heytap.accessory.bean.GeneralException {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        try {
            if (sAdapter.mServiceProxy != null) {
                sAdapter.mServiceProxy.a_renamed(this.mClientId, j_renamed, str, i_renamed, i2);
            }
        } catch (android.os.RemoteException e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.a_renamed(TAG, "Failed to send message delivery status", e_renamed);
            notifyDisconnection(e_renamed);
            throw new com.heytap.accessory.bean.GeneralException(20001, "sendMessageDeliveryStatus: Remote call failed");
        }
    }

    final void registerMexCallback(java.lang.String str, com.heytap.accessory.api.IMsgExpCallback iMsgExpCallback) throws com.heytap.accessory.bean.GeneralException {
        if (sAdapter.mServiceProxy == null) {
            bindToFramework();
        }
        try {
            if (sAdapter.mServiceProxy != null) {
                sAdapter.mServiceProxy.a_renamed(this.mClientId, str, iMsgExpCallback);
            }
        } catch (android.os.RemoteException e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.a_renamed(TAG, "Failed to register mex callback", e_renamed);
            notifyDisconnection(e_renamed);
            throw new com.heytap.accessory.bean.GeneralException(20001, "registerMexCallback: Remote call failed");
        }
    }

    final void unregisterMexCallback(java.lang.String str) throws com.heytap.accessory.bean.GeneralException {
        com.heytap.accessory.api.IFrameworkManager iFrameworkManager = sAdapter.mServiceProxy;
        if (iFrameworkManager != null) {
            try {
                iFrameworkManager.e_renamed(this.mClientId, str);
            } catch (android.os.RemoteException e_renamed) {
                com.heytap.accessory.a_renamed.a_renamed.a_renamed(TAG, "Failed to unregister mex callback", e_renamed);
                notifyDisconnection(e_renamed);
                throw new com.heytap.accessory.bean.GeneralException(20001, "unregisterMexCallback: Remote call failed");
            }
        }
    }

    final class ServiceConnectionIndicationCallback extends com.heytap.accessory.api.IServiceConnectionIndicationCallback.Stub {
        /* synthetic */ ServiceConnectionIndicationCallback(com.heytap.accessory.BaseAdapter baseAdapter, byte b2) {
            this();
        }

        private ServiceConnectionIndicationCallback() {
        }

        @Override // com.heytap.accessory.api.IServiceConnectionIndicationCallback
        @android.annotation.TargetApi(26)
        public final void a_renamed(android.os.Bundle bundle) throws java.lang.ClassNotFoundException, android.os.RemoteException {
            android.content.ComponentName componentNameStartService;
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(com.heytap.accessory.BaseAdapter.TAG, "onServiceConnectionRequested: ".concat(java.lang.String.valueOf(bundle)));
            byte[] byteArray = bundle.getByteArray(com.heytap.accessory.constant.AFConstants.EXTRA_PEER_AGENT);
            if (byteArray == null) {
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(com.heytap.accessory.BaseAdapter.TAG, "marshalled accessory byte[] is_renamed null!");
                return;
            }
            android.os.Parcel parcelObtain = android.os.Parcel.obtain();
            if (parcelObtain == null) {
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(com.heytap.accessory.BaseAdapter.TAG, "Failed to obtain parcel");
                return;
            }
            parcelObtain.unmarshall(byteArray, 0, byteArray.length);
            parcelObtain.setDataPosition(0);
            com.heytap.accessory.bean.PeerAgent peerAgentCreateFromParcel = com.heytap.accessory.bean.PeerAgent.CREATOR.createFromParcel(parcelObtain);
            parcelObtain.recycle();
            long j_renamed = bundle.getLong("transactionId", 0L);
            java.lang.String string = bundle.getString(com.heytap.accessory.constant.AFConstants.EXTRA_AGENT_ID);
            java.lang.String string2 = bundle.getString(com.heytap.accessory.constant.AFConstants.EXTRA_AGENT_IMPL_CLASS);
            if (string2 == null) {
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(com.heytap.accessory.BaseAdapter.TAG, "Implementation class not available in_renamed intent. Ignoring request");
                return;
            }
            try {
                java.lang.Class<?> cls = java.lang.Class.forName(string2);
                if (a_renamed(com.heytap.accessory.BaseAdapter.this.mContext, cls.getName())) {
                    boolean zA = com.heytap.accessory.b_renamed.c_renamed.a_renamed(com.heytap.accessory.BaseJobAgent.class, cls);
                    int i_renamed = com.heytap.accessory.BaseAdapter.this.mContext.getPackageManager().getPackageInfo(com.heytap.accessory.BaseAdapter.this.mContext.getPackageName(), 0).applicationInfo.targetSdkVersion;
                    java.lang.String str = com.heytap.accessory.BaseAdapter.TAG;
                    java.lang.StringBuilder sb = new java.lang.StringBuilder("implClass.getSuperclass() :");
                    sb.append(cls.getSuperclass() == null ? "null" : cls.getSuperclass().getSimpleName());
                    sb.append(", isV2 = ");
                    sb.append(zA);
                    sb.append(", sdkInt:");
                    sb.append(android.os.Build.VERSION.SDK_INT);
                    sb.append(", targetSdk:");
                    sb.append(i_renamed);
                    com.heytap.accessory.a_renamed.a_renamed.a_renamed(str, sb.toString());
                    boolean z_renamed = android.os.Build.VERSION.SDK_INT >= 21 && i_renamed >= 21;
                    if (!zA || !z_renamed) {
                        com.heytap.accessory.a_renamed.a_renamed.c_renamed(com.heytap.accessory.BaseAdapter.TAG, " onServiceConnectionRequested: agentImplClass=".concat(java.lang.String.valueOf(string2)));
                        android.content.Intent intent = new android.content.Intent("com.heytap.accessory.action.SERVICE_CONNECTION_REQUESTED");
                        intent.putExtra("transactionId", j_renamed);
                        intent.putExtra(com.heytap.accessory.constant.AFConstants.EXTRA_AGENT_ID, string);
                        intent.putExtra(com.heytap.accessory.constant.AFConstants.EXTRA_PEER_AGENT, peerAgentCreateFromParcel);
                        intent.putExtra(com.heytap.accessory.constant.AFConstants.EXTRA_AGENT_IMPL_CLASS, string2);
                        intent.setClassName(com.heytap.accessory.BaseAdapter.this.mContext, string2);
                        if (android.os.Build.VERSION.SDK_INT >= 26 && i_renamed >= 26) {
                            com.heytap.accessory.a_renamed.a_renamed.b_renamed(com.heytap.accessory.BaseAdapter.TAG, "startForegroundService");
                            componentNameStartService = com.heytap.accessory.BaseAdapter.this.mContext.startForegroundService(intent);
                        } else {
                            com.heytap.accessory.a_renamed.a_renamed.b_renamed(com.heytap.accessory.BaseAdapter.TAG, "startService");
                            componentNameStartService = com.heytap.accessory.BaseAdapter.this.mContext.startService(intent);
                        }
                        if (componentNameStartService == null) {
                            com.heytap.accessory.a_renamed.a_renamed.e_renamed(com.heytap.accessory.BaseAdapter.TAG, "Agent " + string2 + " not found. Check Accessory Service XML for serviceImpl attribute");
                            return;
                        }
                        return;
                    }
                    com.heytap.accessory.a_renamed.a_renamed.b_renamed(com.heytap.accessory.BaseAdapter.TAG, "scheduleSCJob");
                    com.heytap.accessory.BaseJobService.scheduleSCJob(com.heytap.accessory.BaseAdapter.this.mContext, string2, j_renamed, string, peerAgentCreateFromParcel);
                }
            } catch (android.content.pm.PackageManager.NameNotFoundException e_renamed) {
                e_renamed.printStackTrace();
            } catch (java.lang.ClassNotFoundException e2) {
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(com.heytap.accessory.BaseAdapter.TAG, "Agent Impl class not found!".concat(java.lang.String.valueOf(e2)));
            }
        }

        private synchronized boolean a_renamed(android.content.Context context, java.lang.String str) {
            boolean z_renamed;
            z_renamed = false;
            com.heytap.accessory.b_renamed.d_renamed dVarA = com.heytap.accessory.b_renamed.d_renamed.a_renamed(context);
            if (dVarA == null) {
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(com.heytap.accessory.BaseAdapter.TAG, "config  util default instance  creation failed !!");
            } else {
                com.heytap.accessory.bean.ServiceProfile serviceProfileA = dVarA.a_renamed(str);
                if (serviceProfileA == null) {
                    com.heytap.accessory.a_renamed.a_renamed.e_renamed(com.heytap.accessory.BaseAdapter.TAG, "fetch service profile description failed !!");
                } else if (str.equalsIgnoreCase(serviceProfileA.getServiceImpl())) {
                    z_renamed = true;
                }
            }
            return z_renamed;
        }
    }

    static final class DeathCallbackStub extends com.heytap.accessory.api.IDeathCallback.Stub {

        /* renamed from: a_renamed, reason: collision with root package name */
        private final java.lang.String f3158a;

        public DeathCallbackStub(java.lang.String str) {
            if (str == null) {
                throw new java.lang.IllegalArgumentException("Invalid packageName:null");
            }
            this.f3158a = str;
        }

        @Override // com.heytap.accessory.api.IDeathCallback
        public final java.lang.String a_renamed() throws android.os.RemoteException {
            return this.f3158a;
        }
    }

    static class a_renamed implements android.content.ServiceConnection {
        /* synthetic */ a_renamed(byte b2) {
            this();
        }

        private a_renamed() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            synchronized (com.heytap.accessory.BaseAdapter.sAdapter) {
                if (iBinder != null) {
                    com.heytap.accessory.a_renamed.a_renamed.b_renamed(com.heytap.accessory.BaseAdapter.TAG, "Accessory service connected");
                    com.heytap.accessory.BaseAdapter.sAdapter.mServiceProxy = com.heytap.accessory.api.IFrameworkManager.Stub.a_renamed(iBinder);
                    try {
                        android.os.Bundle bundleA = com.heytap.accessory.BaseAdapter.sAdapter.mServiceProxy.a_renamed(android.os.Process.myPid(), com.heytap.accessory.BaseAdapter.sAdapter.mContext.getPackageName(), com.heytap.accessory.BaseAdapter.sAdapter.mDeathCallback, com.heytap.accessory.Config.getSdkVersionCode(), com.heytap.accessory.BaseAdapter.sAdapter.mScIndicationCallback);
                        if (bundleA == null) {
                            com.heytap.accessory.a_renamed.a_renamed.e_renamed(com.heytap.accessory.BaseAdapter.TAG, "Unable to setup client Identity.Invalid response from Framework");
                            return;
                        }
                        com.heytap.accessory.BaseAdapter.sAdapter.mClientId = bundleA.getLong(com.heytap.accessory.constant.AFConstants.EXTRA_CLIENT_ID, -1L);
                        if (com.heytap.accessory.BaseAdapter.sAdapter.mClientId == -1) {
                            com.heytap.accessory.BaseAdapter.sAdapter.setState(-1);
                            com.heytap.accessory.a_renamed.a_renamed.e_renamed(com.heytap.accessory.BaseAdapter.TAG, "Unable to setup client Identity.Error:" + bundleA.getInt(com.heytap.accessory.constant.AFConstants.EXTRA_ERROR_CODE));
                            return;
                        }
                        com.heytap.accessory.a_renamed.a_renamed.c_renamed(com.heytap.accessory.BaseAdapter.TAG, "Received Client ID_renamed:" + com.heytap.accessory.BaseAdapter.sAdapter.mClientId);
                        com.heytap.accessory.BaseAdapter.sAdapter.setState(1);
                        int i_renamed = bundleA.getInt(com.heytap.accessory.constant.AFConstants.EXTRA_KEY_PROCESS_ID);
                        if (i_renamed == android.os.Process.myPid()) {
                            com.heytap.accessory.BaseAdapter.sAdapter.mProxyReceiver = com.heytap.accessory.BaseAdapter.sAdapter.mServiceProxy.b_renamed(com.heytap.accessory.BaseAdapter.sAdapter.mClientId);
                            com.heytap.accessory.a_renamed.a_renamed.c_renamed(com.heytap.accessory.BaseAdapter.TAG, "Running in_renamed OAF process, Updated my proxy: " + com.heytap.accessory.BaseAdapter.sAdapter.mProxyReceiver);
                        }
                        com.heytap.accessory.b_renamed.g_renamed.a_renamed(i_renamed);
                        com.heytap.accessory.b_renamed.g_renamed.b_renamed(bundleA.getInt(com.heytap.accessory.constant.AFConstants.EXTRA_KEY_MAX_HEADER_LEN));
                        com.heytap.accessory.b_renamed.g_renamed.d_renamed(bundleA.getInt(com.heytap.accessory.constant.AFConstants.EXTRA_KEY_MAX_FOOTER_LEN));
                        com.heytap.accessory.b_renamed.g_renamed.c_renamed(bundleA.getInt(com.heytap.accessory.constant.AFConstants.EXTRA_KEY_MAX_MSG_HEADER_LEN));
                        com.heytap.accessory.b_renamed.g_renamed.e_renamed(bundleA.getInt("framework_compatible_version"));
                    } catch (android.os.RemoteException e_renamed) {
                        com.heytap.accessory.a_renamed.a_renamed.b_renamed(com.heytap.accessory.BaseAdapter.TAG, "Unable to setup client Identity.", e_renamed);
                        com.heytap.accessory.BaseAdapter.sAdapter.setState(-1);
                        com.heytap.accessory.BaseAdapter.sAdapter.notifyDisconnection(e_renamed);
                    }
                }
                com.heytap.accessory.BaseAdapter.sAdapter.notifyAll();
                com.heytap.accessory.BaseAdapter.sAdapter.notifyConnection();
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(android.content.ComponentName componentName) {
            synchronized (com.heytap.accessory.BaseAdapter.sAdapter) {
                com.heytap.accessory.a_renamed.a_renamed.d_renamed(com.heytap.accessory.BaseAdapter.TAG, "Accessory service disconnected");
                com.heytap.accessory.BaseAdapter.sAdapter.setState(0);
                com.heytap.accessory.BaseAdapter.sAdapter.cleanup(false);
            }
        }
    }
}
