package com.heytap.accessory;

/* loaded from: classes2.dex */
public abstract class BaseJobAgent {
    public static final java.lang.String ACTION_REGISTRATION_REQUIRED = "com.heytap.accessory.action.REGISTER_AGENT";
    public static final java.lang.String ACTION_SERVICE_CONNECTION_REQUESTED = "com.heytap.accessory.action.SERVICE_CONNECTION_REQUESTED";
    public static final int AUTHENTICATION_FAILURE_PEER_AGENT_NOT_SUPPORTED = 1546;
    public static final int AUTHENTICATION_FAILURE_TOKEN_NOT_GENERATED = 1545;
    public static final int AUTHENTICATION_SUCCESS = 0;
    private static final int CLEANUP_WAIT_MAX_RETRY = 4;
    private static final long CLEANUP_WAIT_TIME = 500;
    public static final int CONNECTION_ALREADY_EXIST = 10005;
    public static final int CONNECTION_DUPLICATE_REQUEST = 10009;
    public static final int CONNECTION_FAILURE_ACC_DORMANT = 10014;
    public static final int CONNECTION_FAILURE_DEVICE_UNREACHABLE = 10004;
    public static final int CONNECTION_FAILURE_INVALID_PEER_AGENT = 10008;
    private static final int CONNECTION_FAILURE_LOCAL_AGENT_NOT_FOUND = 1034;
    public static final int CONNECTION_FAILURE_NETWORK = 10012;
    public static final int CONNECTION_FAILURE_PEERAGENT_NO_RESPONSE = 10006;
    public static final int CONNECTION_FAILURE_PEERAGENT_REJECTED = 10007;
    public static final int CONNECTION_FAILURE_SERVICE_LIMIT_REACHED = 10010;
    public static final int CONNECTION_SUCCESS = 0;
    private static final int DEFAULT_GET_AGENT_ID_RETRY_COUNT = 2;
    public static final int ERROR_AGENT_REQUEST_IN_PROGRESS = 2564;
    public static final int ERROR_CLASS_NOT_FOUND = 2561;
    public static final int ERROR_CONNECTION_INVALID_PARAM = 1025;
    public static final int ERROR_CONSTRUCTOR_EXCEPTION = 2563;
    public static final int ERROR_CONSTRUCTOR_NOT_FOUND = 2562;
    public static final int ERROR_FATAL = 20001;
    public static final int ERROR_PERMISSION_DENIED = 20003;
    public static final int ERROR_PERMISSION_FAILED = 20004;
    public static final int ERROR_SDK_NOT_INITIALIZED = 20002;
    public static final int FIND_PEER_DEVICE_NOT_CONNECTED = 10001;
    public static final int FIND_PEER_DUPLICATE_REQUEST = 10003;
    public static final int FIND_PEER_SERVICE_NOT_FOUND = 10002;
    public static final int FIND_PEER_TIMEOUT = 10010;
    public static final int PEER_AGENT_AVAILABLE = 1;
    private static final int PEER_AGENT_AVAILABLE_THIN = 105;
    public static final int PEER_AGENT_FOUND = 0;
    public static final int PEER_AGENT_UNAVAILABLE = 2;
    private static final int PEER_AGENT_UNAVAILABLE_THIN = 106;
    private static final int SERVICE_RECORD_NOT_FOUND = 10016;
    private static final java.lang.String TAG = "BaseJobAgent";
    private static com.heytap.accessory.BaseJobAgent.InstanceHandler sInstanceHandler;
    com.heytap.accessory.BaseAdapter mAdapter;
    private com.heytap.accessory.BaseJobAgent.AgentCallbackImpl mAgentCallback;
    private java.lang.String mAgentId;
    com.heytap.accessory.BaseJobAgent.AgentHandler mBackgroundWorker;
    private com.heytap.accessory.BaseJobAgent.ConnectionCallback mConnectionCallback;
    private android.content.Context mContext;
    private com.heytap.accessory.BaseMessage mMessage;
    private java.lang.String mName;
    private com.heytap.accessory.BaseJobAgent.PeerAgentCallback mPeerAgentCallback;
    private com.heytap.accessory.BaseJobAgent.AuthenticationCallback mPeerAuthCallback;
    private java.util.Set<com.heytap.accessory.bean.PeerAgent> mPendingRequests;
    private volatile boolean mProcessingCleanup;
    private java.lang.Class<? extends com.heytap.accessory.BaseSocket> mSocketImpl;
    private java.util.List<com.heytap.accessory.BaseSocket> mSuccessfulConnections;
    private static final java.util.concurrent.locks.ReentrantLock INSTANCE_LOCK = new java.util.concurrent.locks.ReentrantLock();
    private static java.util.Map<java.lang.String, com.heytap.accessory.BaseJobAgent> sAgentsMap = new java.util.concurrent.ConcurrentHashMap();
    private java.lang.Object mLock = new java.lang.Object();
    private com.heytap.accessory.bean.ServiceProfile mServiceProfile = null;
    private int mGetAgentIdRetryCount = 0;

    public interface RequestAgentCallback {
        void onAgentAvailable(com.heytap.accessory.BaseJobAgent baseJobAgent);

        void onError(int i_renamed, java.lang.String str);
    }

    protected BaseJobAgent(java.lang.String str, android.content.Context context) {
        if (str != null && !"".equalsIgnoreCase(str)) {
            if (!INSTANCE_LOCK.isHeldByCurrentThread()) {
                throw new java.lang.IllegalArgumentException("Constructor should not be_renamed called for initializing " + str + ". Call requestAgent API instead");
            }
            this.mName = str;
            this.mContext = context;
            initializeAgent();
            return;
        }
        throw new java.lang.IllegalArgumentException("Invalid parameter name:".concat(java.lang.String.valueOf(str)));
    }

    protected BaseJobAgent(java.lang.String str, android.content.Context context, java.lang.Class<? extends com.heytap.accessory.BaseSocket> cls) throws java.lang.NoSuchMethodException, java.lang.SecurityException {
        if (str != null && !"".equalsIgnoreCase(str)) {
            if (!INSTANCE_LOCK.isHeldByCurrentThread()) {
                throw new java.lang.IllegalArgumentException("Constructor should not be_renamed called for initializing " + str + ". Call requestAgent API instead");
            }
            this.mName = str;
            this.mContext = context;
            validateSocketImplementation(cls);
            this.mSocketImpl = cls;
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "Thread Name:" + this.mName + "BaseSocket Imple class:" + cls.getName());
            initializeAgent();
            return;
        }
        throw new java.lang.IllegalArgumentException("Invalid parameter name:".concat(java.lang.String.valueOf(str)));
    }

    public static void requestAgent(android.content.Context context, java.lang.String str, com.heytap.accessory.BaseJobAgent.RequestAgentCallback requestAgentCallback) {
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "requestAgent");
        com.heytap.accessory.BaseJobAgent.InstanceCreator instanceCreator = new com.heytap.accessory.BaseJobAgent.InstanceCreator(context, str, requestAgentCallback);
        if (sInstanceHandler == null) {
            android.os.HandlerThread handlerThread = new android.os.HandlerThread("instance");
            handlerThread.start();
            com.heytap.accessory.BaseJobAgent.InstanceHandler unused = sInstanceHandler = new com.heytap.accessory.BaseJobAgent.InstanceHandler(handlerThread.getLooper());
        }
        android.os.Message messageObtainMessage = sInstanceHandler.obtainMessage(1);
        messageObtainMessage.obj = instanceCreator;
        messageObtainMessage.sendToTarget();
    }

    public void releaseAgent() {
        android.os.Message messageObtainMessage = sInstanceHandler.obtainMessage(2);
        messageObtainMessage.obj = this;
        messageObtainMessage.sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isProcessingCleanup() {
        boolean z_renamed;
        synchronized (this.mLock) {
            z_renamed = this.mProcessingCleanup;
        }
        return z_renamed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void destroy() {
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "BaseJobAgent - onDestroy:" + getClass().getSimpleName());
        synchronized (this.mLock) {
            this.mProcessingCleanup = true;
        }
        com.heytap.accessory.BaseJobAgent.AgentHandler agentHandler = this.mBackgroundWorker;
        if (agentHandler != null) {
            agentHandler.obtainMessage(14).sendToTarget();
        }
    }

    private static void putAgent(java.lang.String str, com.heytap.accessory.BaseJobAgent baseJobAgent) {
        if (sAgentsMap.containsKey(str)) {
            return;
        }
        sAgentsMap.put(str, baseJobAgent);
    }

    private void initializeAgent() {
        try {
            new com.heytap.accessory.b_renamed.g_renamed(getApplicationContext());
        } catch (com.heytap.accessory.bean.GeneralException e_renamed) {
            e_renamed.printStackTrace();
        }
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "BaseJobAgent - initialize:" + getClass().getSimpleName());
        this.mSuccessfulConnections = java.util.Collections.synchronizedList(new java.util.ArrayList());
        this.mPendingRequests = java.util.Collections.synchronizedSet(new java.util.HashSet());
        android.os.HandlerThread handlerThread = new android.os.HandlerThread(this.mName);
        handlerThread.setUncaughtExceptionHandler(new java.lang.Thread.UncaughtExceptionHandler() { // from class: com.heytap.accessory.BaseJobAgent.1
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(java.lang.Thread thread, final java.lang.Throwable th) {
                com.heytap.accessory.a_renamed.a_renamed.b_renamed(com.heytap.accessory.BaseJobAgent.TAG, "Exception in_renamed background thread:" + thread.getName(), th);
                new android.os.Handler(android.os.Looper.getMainLooper()).post(new java.lang.Runnable() { // from class: com.heytap.accessory.BaseJobAgent.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        throw new java.lang.RuntimeException(th);
                    }
                });
            }
        });
        handlerThread.start();
        android.os.Looper looper = handlerThread.getLooper();
        if (looper == null) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Unable to start Agent thread.");
            throw new java.lang.RuntimeException("Unable to start Agent.Worker thread creation failed");
        }
        this.mBackgroundWorker = new com.heytap.accessory.BaseJobAgent.AgentHandler(this, looper);
        try {
            com.heytap.accessory.Initializer.initBufferPool(getApplicationContext());
        } catch (com.heytap.accessory.bean.SdkUnsupportedException e2) {
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "SDK initialization failed!", e2);
            android.os.Message messageObtainMessage = this.mBackgroundWorker.obtainMessage(12);
            messageObtainMessage.arg1 = 20002;
            this.mBackgroundWorker.sendMessage(messageObtainMessage);
        }
        putAgent(getClass().getName(), this);
        this.mAdapter = com.heytap.accessory.BaseAdapter.getDefaultAdapter(getApplicationContext(), this.mBackgroundWorker);
        byte b2 = 0;
        this.mPeerAuthCallback = new com.heytap.accessory.BaseJobAgent.AuthenticationCallback(this, b2);
        this.mPeerAgentCallback = new com.heytap.accessory.BaseJobAgent.PeerAgentCallback(this, b2);
        this.mConnectionCallback = new com.heytap.accessory.BaseJobAgent.ConnectionCallback(this, b2);
        this.mAgentCallback = new com.heytap.accessory.BaseJobAgent.AgentCallbackImpl(this);
        this.mBackgroundWorker.sendEmptyMessage(0);
        fetchServiceProfile();
    }

    public android.content.Context getApplicationContext() {
        return this.mContext.getApplicationContext();
    }

    protected void onFindPeerAgentsResponse(com.heytap.accessory.bean.PeerAgent[] peerAgentArr, int i_renamed) {
        com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Invalid implementation of_renamed BaseJobAgent.onFindPeerAgentsResponse(PeerAgent[], int) should be_renamed overrided!");
    }

    protected void onPeerAgentsUpdated(com.heytap.accessory.bean.PeerAgent[] peerAgentArr, int i_renamed) {
        com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Invalid implementation of_renamed BaseJobAgent.onPeerAgentsUpdated(PeerAgent[], int) should be_renamed overrided!");
    }

    protected void onServiceConnectionRequested(com.heytap.accessory.bean.PeerAgent peerAgent) {
        if (peerAgent != null) {
            com.heytap.accessory.a_renamed.a_renamed.a_renamed(TAG, "Accepting connection request by_renamed default from Peer:" + peerAgent.getAgentId() + " Transaction:" + peerAgent.getTransactionId());
        }
        acceptServiceConnectionRequest(peerAgent);
    }

    protected void onServiceConnectionResponse(com.heytap.accessory.bean.PeerAgent peerAgent, com.heytap.accessory.BaseSocket baseSocket, int i_renamed) {
        com.heytap.accessory.a_renamed.a_renamed.d_renamed(TAG, "No Implementaion for onServiceConnectionResponse(PeerAgent peerAgent, BaseSocket socket, int result)!");
    }

    protected void onAuthenticationResponse(com.heytap.accessory.bean.PeerAgent peerAgent, com.heytap.accessory.bean.AuthenticationToken authenticationToken, int i_renamed) {
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "Peer authentication response received:".concat(java.lang.String.valueOf(i_renamed)));
    }

    protected void onLowMemory() {
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "Service Low Memory");
    }

    protected void onError(com.heytap.accessory.bean.PeerAgent peerAgent, java.lang.String str, int i_renamed) {
        if (peerAgent == null) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "ACCEPT_STATE_ERROR: " + i_renamed + ": " + str + " PeerAgent: null");
            return;
        }
        com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "ACCEPT_STATE_ERROR: " + i_renamed + ": " + str + " PeerAgent: " + peerAgent.getAgentId());
    }

    protected final synchronized void findPeerAgents() {
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "findPeer request received by_renamed:" + getClass().getName());
        try {
            com.heytap.accessory.Initializer.initBufferPool(getApplicationContext());
            if (this.mBackgroundWorker != null) {
                android.os.Message messageObtainMessage = this.mBackgroundWorker.obtainMessage();
                messageObtainMessage.what = 2;
                this.mBackgroundWorker.sendMessage(messageObtainMessage);
                return;
            }
            com.heytap.accessory.a_renamed.a_renamed.d_renamed(TAG, "findPeerAgents: mBackgroundWorker is_renamed null!");
        } catch (com.heytap.accessory.bean.SdkUnsupportedException e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "exception: ", e_renamed);
            handleError(20002, null);
        }
    }

    protected final void requestServiceConnection(com.heytap.accessory.bean.PeerAgent peerAgent) {
        if (peerAgent == null) {
            throw new java.lang.IllegalArgumentException("Illegal argument peerAgent:".concat(java.lang.String.valueOf(peerAgent)));
        }
        try {
            com.heytap.accessory.Initializer.initBufferPool(getApplicationContext());
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "Service connection requested for peer:" + peerAgent.getAgentId());
            com.heytap.accessory.BaseJobAgent.AgentHandler agentHandler = this.mBackgroundWorker;
            if (agentHandler != null) {
                android.os.Message messageObtainMessage = agentHandler.obtainMessage(7);
                messageObtainMessage.obj = peerAgent;
                this.mBackgroundWorker.sendMessage(messageObtainMessage);
                return;
            }
            com.heytap.accessory.a_renamed.a_renamed.d_renamed(TAG, "requestServiceConection: mBackgroundWorker is_renamed null!");
        } catch (com.heytap.accessory.bean.SdkUnsupportedException e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "exception: " + e_renamed.getMessage());
            handleError(20002, peerAgent);
        }
    }

    protected void acceptServiceConnectionRequest(com.heytap.accessory.bean.PeerAgent peerAgent) {
        if (peerAgent == null) {
            throw new java.lang.IllegalArgumentException("Illegal argument peerAgent:".concat(java.lang.String.valueOf(peerAgent)));
        }
        try {
            com.heytap.accessory.Initializer.initBufferPool(getApplicationContext());
            if (this.mPendingRequests.remove(peerAgent)) {
                com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "Trying to Accept service connection request from peer:" + peerAgent.getAgentId() + " Transaction:" + peerAgent.getTransactionId());
                com.heytap.accessory.BaseJobAgent.AgentHandler agentHandler = this.mBackgroundWorker;
                if (agentHandler != null) {
                    android.os.Message messageObtainMessage = agentHandler.obtainMessage(8);
                    messageObtainMessage.obj = peerAgent;
                    this.mBackgroundWorker.sendMessage(messageObtainMessage);
                    return;
                }
                com.heytap.accessory.a_renamed.a_renamed.d_renamed(TAG, "acceptServiceConnection: mBackgroundWorker is_renamed null!");
            }
        } catch (com.heytap.accessory.bean.SdkUnsupportedException e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "exception: " + e_renamed.getMessage());
            handleError(20002, peerAgent);
        }
    }

    protected void rejectServiceConnectionRequest(com.heytap.accessory.bean.PeerAgent peerAgent) {
        if (peerAgent == null) {
            throw new java.lang.IllegalArgumentException("Illegal argument peerAgent:".concat(java.lang.String.valueOf(peerAgent)));
        }
        try {
            com.heytap.accessory.Initializer.initBufferPool(getApplicationContext());
            if (this.mPendingRequests.remove(peerAgent)) {
                com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "Trying to reject connection request from peer:" + peerAgent.getAgentId() + " Transaction:" + peerAgent.getTransactionId());
                com.heytap.accessory.BaseJobAgent.AgentHandler agentHandler = this.mBackgroundWorker;
                if (agentHandler != null) {
                    android.os.Message messageObtainMessage = agentHandler.obtainMessage(9);
                    messageObtainMessage.obj = peerAgent;
                    this.mBackgroundWorker.sendMessage(messageObtainMessage);
                    return;
                }
                com.heytap.accessory.a_renamed.a_renamed.d_renamed(TAG, "rejectServiceConnection: mBackgroundWorker is_renamed null!");
                return;
            }
            com.heytap.accessory.a_renamed.a_renamed.d_renamed(TAG, "Rejecting service connection with invalid peer agent:" + peerAgent.toString());
            handleInvalidPeerAction(peerAgent);
        } catch (com.heytap.accessory.bean.SdkUnsupportedException e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "exception: " + e_renamed.getMessage());
            handleError(20002, peerAgent);
        }
    }

    protected void authenticatePeerAgent(com.heytap.accessory.bean.PeerAgent peerAgent) {
        if (peerAgent == null) {
            throw new java.lang.IllegalArgumentException("Illegal argument peerAgent:".concat(java.lang.String.valueOf(peerAgent)));
        }
        try {
            com.heytap.accessory.Initializer.initBufferPool(getApplicationContext());
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "Authentication requested for peer:" + peerAgent.getAgentId());
            com.heytap.accessory.BaseJobAgent.AgentHandler agentHandler = this.mBackgroundWorker;
            if (agentHandler != null) {
                android.os.Message messageObtainMessage = agentHandler.obtainMessage(10);
                messageObtainMessage.obj = peerAgent;
                this.mBackgroundWorker.sendMessage(messageObtainMessage);
                return;
            }
            com.heytap.accessory.a_renamed.a_renamed.d_renamed(TAG, "authenticatePeerAgent: mBackgroundWorker is_renamed null!");
        } catch (com.heytap.accessory.bean.SdkUnsupportedException e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "exception: " + e_renamed.getMessage());
            handleError(20002, peerAgent);
        }
    }

    public java.lang.String getServiceProfileId() {
        com.heytap.accessory.bean.ServiceProfile serviceProfile = this.mServiceProfile;
        if (serviceProfile == null) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Failed because Service Profile is_renamed null");
            return null;
        }
        return serviceProfile.getId();
    }

    public java.lang.String getServiceProfileName() {
        com.heytap.accessory.bean.ServiceProfile serviceProfile = this.mServiceProfile;
        if (serviceProfile == null) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Failed because Service Profile is_renamed null");
            return null;
        }
        return serviceProfile.getName();
    }

    public int getServiceChannelSize() {
        com.heytap.accessory.bean.ServiceProfile serviceProfile = this.mServiceProfile;
        if (serviceProfile == null) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Failed because Service Profile is_renamed null");
            return -1;
        }
        return serviceProfile.getServiceChannelList().size();
    }

    public int getServiceChannelId(int i_renamed) {
        if (this.mServiceProfile == null) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Failed because Service Profile is_renamed null");
            return -1;
        }
        if (i_renamed >= 0 && i_renamed < getServiceChannelSize()) {
            return this.mServiceProfile.getServiceChannelList().get(i_renamed).getChannelId();
        }
        com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Failed because of_renamed wrong index");
        return -1;
    }

    public java.util.List<com.heytap.accessory.BaseSocket> getSuccessfulConnections() {
        return this.mSuccessfulConnections;
    }

    java.lang.String registerMessageInstance(com.heytap.accessory.BaseMessage baseMessage) {
        this.mMessage = baseMessage;
        return this.mAgentId;
    }

    android.os.Handler getAgentHandler() {
        return this.mBackgroundWorker;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindToFramework() throws java.util.concurrent.ExecutionException, java.lang.InterruptedException, com.heytap.accessory.bean.GeneralException {
        this.mAdapter.registerAgentCallback(this.mAgentCallback);
        this.mAdapter.bindToFramework();
        loadAgentId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAgentId() throws java.util.concurrent.ExecutionException, java.lang.InterruptedException, com.heytap.accessory.bean.GeneralException {
        android.content.SharedPreferences sharedPreferences;
        java.lang.String localAgentId = getLocalAgentId();
        if (localAgentId == null) {
            handleError(20001, null);
            return;
        }
        if (android.os.Build.VERSION.SDK_INT > 26) {
            sharedPreferences = this.mContext.createDeviceProtectedStorageContext().getSharedPreferences("AccessoryPreferences", 0);
        } else {
            sharedPreferences = this.mContext.getApplicationContext().getSharedPreferences("AccessoryPreferences", 0);
        }
        android.content.SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString(localAgentId, getClass().getName());
        editorEdit.putString(getClass().getName(), localAgentId);
        editorEdit.apply();
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "save AgentId className:" + getClass().getName() + ",agentId: " + localAgentId);
        this.mAgentId = localAgentId;
        registerMexAgent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerMexAgent() throws com.heytap.accessory.bean.GeneralException {
        java.lang.String str;
        com.heytap.accessory.BaseMessage baseMessage = this.mMessage;
        if (baseMessage == null || (str = this.mAgentId) == null) {
            return;
        }
        baseMessage.registerAgent(str);
    }

    private void validateSocketImplementation(java.lang.Class<? extends com.heytap.accessory.BaseSocket> cls) throws java.lang.NoSuchMethodException, java.lang.SecurityException {
        if (cls == null) {
            throw new java.lang.IllegalArgumentException("Invalid socketClass param");
        }
        try {
            if (!java.lang.reflect.Modifier.toString(cls.getModifiers()).contains("static") && cls.getEnclosingClass() != null) {
                cls.getDeclaredConstructor(cls.getEnclosingClass());
            } else {
                cls.getDeclaredConstructor(new java.lang.Class[0]);
            }
        } catch (java.lang.NoSuchMethodException e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "exception: " + e_renamed.getMessage(), e_renamed);
            throw new java.lang.RuntimeException("Invalid implemetation of_renamed BaseSocket. Provider a_renamed public default constructor in_renamed the implementation class.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerService() throws java.util.concurrent.ExecutionException, java.lang.InterruptedException {
        com.heytap.accessory.a_renamed aVar = new com.heytap.accessory.a_renamed(getApplicationContext());
        java.util.concurrent.Future<java.lang.Void> futureA = aVar.a_renamed();
        aVar.b_renamed();
        try {
            futureA.get();
        } catch (java.lang.InterruptedException unused) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Regisration failed! : InterruptedException");
        } catch (java.util.concurrent.ExecutionException unused2) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Registration failed! : ExecutionException");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestPeerAgents() throws java.util.concurrent.ExecutionException, java.lang.InterruptedException {
        java.lang.String localAgentId = getLocalAgentId();
        if (localAgentId == null) {
            handleError(20001, null);
            return;
        }
        try {
            int iFindPeerAgents = this.mAdapter.findPeerAgents(localAgentId, this.mPeerAgentCallback);
            if (iFindPeerAgents == 0) {
                com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "Find peer request successfully enqueued.");
                return;
            }
            com.heytap.accessory.a_renamed.a_renamed.d_renamed(TAG, "Find peer request failed:" + iFindPeerAgents + " for service " + getClass().getName());
            onFindPeerAgentsResponse(null, iFindPeerAgents);
            handleFindPeerErrorCode(iFindPeerAgents);
        } catch (com.heytap.accessory.bean.GeneralException e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Find Peer request failed!");
            handleError(e_renamed.getErrorCode(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFindPeerErrorCode(int i_renamed) {
        if (i_renamed == 0) {
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onFindPeerAgentsResponse() -> PEER_AGENT_FOUND");
            return;
        }
        if (i_renamed != 10010) {
            switch (i_renamed) {
                case 10001:
                    com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onFindPeerAgentsResponse() -> FIND_PEER_DEVICE_NOT_CONNECTED");
                    break;
                case 10002:
                    com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onFindPeerAgentsResponse() -> FIND_PEER_SERVICE_NOT_FOUND");
                    break;
                case 10003:
                    com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onFindPeerAgentsResponse() -> FIND_PEER_DUPLICATE_REQUEST");
                    break;
                default:
                    com.heytap.accessory.a_renamed.a_renamed.d_renamed(TAG, "onFindPeerAgentsResponse() errorCode: ".concat(java.lang.String.valueOf(i_renamed)));
                    break;
            }
            return;
        }
        com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onFindPeerAgentsResponse() -> FIND_PEER_TIMEOUT");
    }

    private void handleAuthErrorCode(int i_renamed) {
        if (i_renamed == 0) {
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onAuthenticationResponse() -> AUTHENTICATION_SUCCESS");
            return;
        }
        if (i_renamed == 1545) {
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onAuthenticationResponse() -> AUTHENTICATION_FAILURE_TOKEN_NOT_GENERATED");
        } else if (i_renamed == 1546) {
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onAuthenticationResponse() -> AUTHENTICATION_FAILURE_PEER_AGENT_NOT_SUPPORTED");
        } else {
            com.heytap.accessory.a_renamed.a_renamed.d_renamed(TAG, "onAuthenticationResponse() errorCode: ".concat(java.lang.String.valueOf(i_renamed)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleServiceConnectionErrorCode(int i_renamed) {
        if (i_renamed == 0) {
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onServiceConnectionResponse() -> CONNECTION_SUCCESS");
            return;
        }
        if (i_renamed != 10012) {
            switch (i_renamed) {
                case 10004:
                    com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onServiceConnectionResponse() -> CONNECTION_FAILURE_DEVICE_UNREACHABLE");
                    break;
                case 10005:
                    com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onServiceConnectionResponse() -> CONNECTION_ALREADY_EXIST");
                    break;
                case 10006:
                    com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onServiceConnectionResponse() -> CONNECTION_FAILURE_PEERAGENT_NO_RESPONSE");
                    break;
                case 10007:
                    com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onServiceConnectionResponse() -> CONNECTION_FAILURE_PEERAGENT_REJECTED");
                    break;
                case 10008:
                    com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onServiceConnectionResponse() -> CONNECTION_FAILURE_INVALID_PEER_AGENT");
                    break;
                case 10009:
                    com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onServiceConnectionResponse() -> CONNECTION_DUPLICATE_REQUEST");
                    break;
                case 10010:
                    com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onServiceConnectionResponse() -> CONNECTION_FAILURE_SERVICE_LIMIT_REACHED");
                    break;
                default:
                    com.heytap.accessory.a_renamed.a_renamed.d_renamed(TAG, "onServiceConnectionResponse() errorCode: ".concat(java.lang.String.valueOf(i_renamed)));
                    break;
            }
            return;
        }
        com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onServiceConnectionResponse() -> CONNECTION_FAILURE_NETWORK");
    }

    private void handleOnErrorCode(int i_renamed) {
        if (i_renamed == 1025) {
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onError() -> ERROR_CONNECTION_INVALID_PARAM");
            return;
        }
        switch (i_renamed) {
            case 20001:
                com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onError() -> ERROR_FATAL");
                break;
            case 20002:
                com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onError() -> ERROR_SDK_NOT_INITIALIZED");
                break;
            case 20003:
                com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onError() -> ERROR_PERMISSION_DENIED");
                break;
            case 20004:
                com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onError() -> ERROR_PERMISSION_FAILED");
                break;
            default:
                com.heytap.accessory.a_renamed.a_renamed.d_renamed(TAG, "onError() errorCode: ".concat(java.lang.String.valueOf(i_renamed)));
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePeerAgentUpdateErrorCode(int i_renamed) {
        if (i_renamed == 1) {
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onPeerAgentUpdated() -> PEER_AGENT_AVAILABLE");
        } else if (i_renamed == 2) {
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onPeerAgentUpdated() -> PEER_AGENT_UNAVAILABLE");
        } else {
            com.heytap.accessory.a_renamed.a_renamed.d_renamed(TAG, "onPeerAgentUpdated() errorCode: ".concat(java.lang.String.valueOf(i_renamed)));
        }
    }

    java.lang.String getLocalAgentId() throws java.util.concurrent.ExecutionException, java.lang.InterruptedException {
        if (this.mAdapter == null) {
            com.heytap.accessory.a_renamed.a_renamed.d_renamed(TAG, "BaseAdapter is_renamed null,just return!");
            return null;
        }
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "mGetAgentIdRetryCount = " + this.mGetAgentIdRetryCount);
        if (this.mGetAgentIdRetryCount >= 2) {
            this.mGetAgentIdRetryCount = 0;
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Failed to retrieve service record, retry 2");
            return null;
        }
        try {
            java.lang.String localAgentId = this.mAdapter.getLocalAgentId(getClass().getName());
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "Agent ID_renamed retrieved successfully for " + getClass().getName() + " Agent ID_renamed:" + localAgentId);
            return localAgentId;
        } catch (com.heytap.accessory.bean.GeneralException e_renamed) {
            if (e_renamed.getErrorCode() == 10016) {
                this.mGetAgentIdRetryCount++;
                com.heytap.accessory.a_renamed.a_renamed.d_renamed(TAG, "Service record was not found in_renamed Accessory Framework.Registering service again!");
                try {
                    registerService();
                    com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "Trying to fetch agent ID_renamed after re-registration");
                    return this.mAdapter.getLocalAgentId(getClass().getName());
                } catch (com.heytap.accessory.bean.GeneralException unused) {
                    com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "Failed to retrieve service record after re-registration", e_renamed);
                    return null;
                }
            }
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "Failed to retrieve service record", e_renamed);
            return null;
        }
    }

    void handleConnectionRequest(android.content.Intent intent) {
        android.os.Message messageObtainMessage = this.mBackgroundWorker.obtainMessage();
        messageObtainMessage.what = 5;
        messageObtainMessage.obj = intent;
        this.mBackgroundWorker.sendMessage(messageObtainMessage);
    }

    @android.annotation.TargetApi(21)
    void handleConnectionRequest(android.app.job.JobParameters jobParameters, com.heytap.accessory.IJobListener iJobListener) {
        android.os.Message messageObtainMessage = this.mBackgroundWorker.obtainMessage();
        messageObtainMessage.what = 6;
        messageObtainMessage.obj = iJobListener;
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putParcelable(com.heytap.accessory.constant.AFConstants.EXTRA_PARAMS, jobParameters);
        messageObtainMessage.setData(bundle);
        this.mBackgroundWorker.sendMessage(messageObtainMessage);
    }

    static void handleLowMemory() {
        synchronized (sAgentsMap) {
            java.util.Iterator<com.heytap.accessory.BaseJobAgent> it = sAgentsMap.values().iterator();
            while (it.hasNext()) {
                it.next().handleAgentLowMemory();
            }
        }
    }

    void handleAgentLowMemory() {
        this.mBackgroundWorker.sendEmptyMessage(18);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyConnectionRequest(android.content.Intent intent) {
        if (intent == null) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Invalid service connection indication.Intent:null.Ignoring reqeuset");
            return;
        }
        notifyConnectionRequest(intent.getLongExtra("transactionId", 0L), intent.getStringExtra(com.heytap.accessory.constant.AFConstants.EXTRA_AGENT_ID), (com.heytap.accessory.bean.PeerAgent) intent.getParcelableExtra(com.heytap.accessory.constant.AFConstants.EXTRA_PEER_AGENT));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @android.annotation.TargetApi(21)
    public void notifyConnectionRequest(android.os.PersistableBundle persistableBundle) {
        if (persistableBundle == null) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Invalid service connection indication.Intent:null.Ignoring reqeuset");
            return;
        }
        long j_renamed = persistableBundle.getLong("transactionId", 0L);
        java.lang.String[] strArr = new java.lang.String[0];
        java.lang.String[] stringArray = persistableBundle.getStringArray(com.heytap.accessory.constant.AFConstants.EXTRA_PEER_AGENT);
        if (stringArray == null) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Invalid initiator peer agent. Ignoring connection request");
        } else {
            notifyConnectionRequest(j_renamed, persistableBundle.getString(com.heytap.accessory.constant.AFConstants.EXTRA_AGENT_ID), new com.heytap.accessory.bean.PeerAgent((java.util.List<java.lang.String>) java.util.Arrays.asList(stringArray)));
        }
    }

    private void notifyConnectionRequest(long j_renamed, java.lang.String str, com.heytap.accessory.bean.PeerAgent peerAgent) {
        if (peerAgent == null) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Invalid initiator peer agent:null. Ignoring connection request");
            return;
        }
        if (str == null) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Invalid local agent Id:null .Ignoring connection request");
            return;
        }
        peerAgent.setTransactionId(j_renamed);
        com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "Connection initiated by_renamed peer: " + peerAgent.getAgentId() + " on_renamed Accessory: " + peerAgent.getAccessory().getPeerId() + " Transaction: " + j_renamed);
        this.mPendingRequests.add(peerAgent);
        onServiceConnectionRequested(peerAgent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestConnection(com.heytap.accessory.bean.PeerAgent peerAgent) throws java.util.concurrent.ExecutionException, java.lang.InterruptedException {
        java.lang.String localAgentId = getLocalAgentId();
        if (localAgentId == null) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Failed to retrieve service description.Ignoring service connection request");
            handleError(20001, peerAgent);
        } else {
            instantiateSocket().initiateServiceconnection(localAgentId, peerAgent, this.mAdapter, this.mConnectionCallback);
        }
    }

    private com.heytap.accessory.BaseSocket instantiateSocket() throws java.lang.NoSuchMethodException, java.lang.SecurityException {
        validateSocketImplementation(this.mSocketImpl);
        try {
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "Instantiating BaseSocket: " + this.mSocketImpl.getName());
            if (!java.lang.reflect.Modifier.toString(this.mSocketImpl.getModifiers()).contains("static") && this.mSocketImpl.getEnclosingClass() != null && com.heytap.accessory.BaseJobAgent.class.isAssignableFrom(this.mSocketImpl.getEnclosingClass())) {
                java.lang.reflect.Constructor<? extends com.heytap.accessory.BaseSocket> declaredConstructor = this.mSocketImpl.getDeclaredConstructor(this.mSocketImpl.getEnclosingClass());
                declaredConstructor.setAccessible(true);
                return declaredConstructor.newInstance(this);
            }
            java.lang.reflect.Constructor<? extends com.heytap.accessory.BaseSocket> declaredConstructor2 = this.mSocketImpl.getDeclaredConstructor(new java.lang.Class[0]);
            declaredConstructor2.setAccessible(true);
            return declaredConstructor2.newInstance(new java.lang.Object[0]);
        } catch (java.lang.IllegalAccessException | java.lang.IllegalArgumentException | java.lang.InstantiationException | java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Invalid implementation of_renamed BaseSocket. Provider a_renamed public default constructor." + e_renamed.getClass().getSimpleName() + " " + e_renamed.getMessage());
            throw new java.lang.RuntimeException("Invalid implementation of_renamed BaseSocket. Provider a_renamed public default constructor.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acceptServiceConnectionInternal(com.heytap.accessory.bean.PeerAgent peerAgent) throws java.util.concurrent.ExecutionException, java.lang.InterruptedException {
        java.lang.String localAgentId = getLocalAgentId();
        if (localAgentId == null) {
            handleError(20001, peerAgent);
        } else {
            instantiateSocket().acceptServiceConnection(localAgentId, peerAgent, this.mAdapter, this.mConnectionCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rejectServiceConnectionInternal(com.heytap.accessory.bean.PeerAgent peerAgent) throws java.util.concurrent.ExecutionException, java.lang.InterruptedException {
        java.lang.String localAgentId = getLocalAgentId();
        if (localAgentId == null) {
            handleError(20001, peerAgent);
            return;
        }
        try {
            this.mAdapter.rejectServiceConnection(localAgentId, peerAgent, peerAgent.getTransactionId());
        } catch (com.heytap.accessory.bean.GeneralException e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "Failed to reject Service connection!", e_renamed);
            handleError(e_renamed.getErrorCode(), peerAgent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestPeerAuthInternal(com.heytap.accessory.bean.PeerAgent peerAgent) throws java.util.concurrent.ExecutionException, java.lang.InterruptedException {
        java.lang.String localAgentId = getLocalAgentId();
        if (localAgentId == null) {
            handleError(20001, peerAgent);
            return;
        }
        try {
            int iAuthenticatePeeragent = this.mAdapter.authenticatePeeragent(localAgentId, peerAgent, this.mPeerAuthCallback, peerAgent.getTransactionId());
            if (iAuthenticatePeeragent == 0) {
                com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "Auth. request for peer: " + peerAgent.getAgentId() + " done successfully");
                return;
            }
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Auth. request for peer: " + peerAgent.getAgentId() + " failed as_renamed reason: " + iAuthenticatePeeragent);
            onAuthenticationResponse(peerAgent, null, iAuthenticatePeeragent);
            handleAuthErrorCode(iAuthenticatePeeragent);
        } catch (com.heytap.accessory.bean.GeneralException e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "Failed to request peer authentication!", e_renamed);
            handleError(e_renamed.getErrorCode(), peerAgent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAuthResponse(android.os.Bundle bundle) {
        bundle.setClassLoader(com.heytap.accessory.bean.PeerAgent.class.getClassLoader());
        byte[] byteArray = bundle.getByteArray(com.heytap.accessory.constant.AFConstants.EXTRA_PEER_AUTH_KEY);
        int i_renamed = bundle.getInt(com.heytap.accessory.constant.AFConstants.EXTRA_CERTIFICATE_TYPE);
        com.heytap.accessory.bean.PeerAgent peerAgent = (com.heytap.accessory.bean.PeerAgent) bundle.getParcelable(com.heytap.accessory.constant.AFConstants.EXTRA_PEER_AGENT);
        long j_renamed = bundle.getLong("transactionId");
        if (peerAgent == null) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Invalid response from framework! No peer agent in_renamed auth response.Ignoring response");
            return;
        }
        peerAgent.setTransactionId(j_renamed);
        int i2 = 0;
        if (byteArray == null) {
            i2 = AUTHENTICATION_FAILURE_TOKEN_NOT_GENERATED;
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Authentication failed error:1545 Peer Id:" + peerAgent.getAgentId());
        } else {
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "Authentication success status: 0 for peer: " + peerAgent.getAgentId());
        }
        onAuthenticationResponse(peerAgent, new com.heytap.accessory.bean.AuthenticationToken(i_renamed, byteArray), i2);
        handleAuthErrorCode(i2);
    }

    java.lang.String getId() throws java.util.concurrent.ExecutionException, java.lang.InterruptedException {
        java.lang.String localAgentId = getLocalAgentId();
        if (localAgentId == null) {
            handleError(20001, null);
        }
        return localAgentId;
    }

    private void handleInvalidPeerAction(com.heytap.accessory.bean.PeerAgent peerAgent) {
        synchronized (this.mPendingRequests) {
            java.util.Iterator<com.heytap.accessory.bean.PeerAgent> it = this.mPendingRequests.iterator();
            while (it.hasNext()) {
                rejectServiceConnectionInternal(it.next());
            }
            if (this.mBackgroundWorker != null) {
                android.os.Message messageObtainMessage = this.mBackgroundWorker.obtainMessage(12);
                messageObtainMessage.arg1 = 10008;
                messageObtainMessage.obj = peerAgent;
                this.mBackgroundWorker.sendMessage(messageObtainMessage);
            } else {
                com.heytap.accessory.a_renamed.a_renamed.d_renamed(TAG, "handle Invalid PeerAction: mBackgroundWorker is_renamed null!");
            }
        }
    }

    void handleError(int i_renamed, com.heytap.accessory.bean.PeerAgent peerAgent) {
        if (i_renamed == 10008) {
            onServiceConnectionResponse(peerAgent, null, 10008);
            handleServiceConnectionErrorCode(10008);
            return;
        }
        switch (i_renamed) {
            case 20001:
                cleanupConnections(true);
                onError(null, "Oplus Accessory Framework has died!!", i_renamed);
                handleOnErrorCode(i_renamed);
                break;
            case 20002:
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Oplus Accessory SDK cannot be_renamed initialized");
                onError(null, "Oplus Accessory SDK cannot be_renamed initialized. Device or Build not compatible.", i_renamed);
                handleOnErrorCode(i_renamed);
                break;
            case 20003:
            case 20004:
                onError(null, "Permission error!", i_renamed);
                handleOnErrorCode(i_renamed);
                break;
            default:
                com.heytap.accessory.a_renamed.a_renamed.d_renamed(TAG, "Unknown error: ".concat(java.lang.String.valueOf(i_renamed)));
                break;
        }
    }

    public void cleanup() throws java.util.concurrent.ExecutionException, java.lang.InterruptedException {
        com.heytap.accessory.a_renamed.a_renamed.d_renamed(TAG, "Performing agent cleanup");
        if (this.mAdapter != null) {
            cleanupConnections(false);
            java.lang.String localAgentId = getLocalAgentId();
            if (localAgentId != null) {
                this.mAdapter.cleanupAgent(localAgentId);
            }
            this.mAdapter.unregisterAgentCallback(this.mAgentCallback);
            com.heytap.accessory.BaseMessage baseMessage = this.mMessage;
            if (baseMessage != null) {
                baseMessage.unregisterAgent();
            }
        }
        com.heytap.accessory.BaseJobAgent.AgentHandler agentHandler = this.mBackgroundWorker;
        if (agentHandler != null) {
            agentHandler.getLooper().quit();
            agentHandler.f3172a = null;
            this.mBackgroundWorker = null;
        }
        sAgentsMap.remove(getClass().getName());
        synchronized (this.mLock) {
            this.mProcessingCleanup = false;
        }
    }

    private void cleanupConnections(boolean z_renamed) {
        synchronized (this.mSuccessfulConnections) {
            for (com.heytap.accessory.BaseSocket baseSocket : this.mSuccessfulConnections) {
                if (z_renamed) {
                    baseSocket.forceClose();
                } else {
                    baseSocket.close();
                }
            }
        }
        this.mSuccessfulConnections.clear();
        com.heytap.accessory.Initializer.clearSdkConfig();
    }

    public boolean runOnBackgroundThread(java.lang.Runnable runnable) {
        return this.mBackgroundWorker.post(runnable);
    }

    private synchronized void fetchServiceProfile() {
        com.heytap.accessory.b_renamed.d_renamed dVarA = com.heytap.accessory.b_renamed.d_renamed.a_renamed(getApplicationContext());
        if (dVarA != null) {
            this.mServiceProfile = dVarA.a_renamed(getClass().getName());
            if (this.mServiceProfile == null) {
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "fetch service profile description failed !!");
            }
        } else {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "config  util defualt instance  creation failed !!");
        }
    }

    class PeerAgentCallback extends com.heytap.accessory.api.IPeerAgentCallback.Stub {
        /* synthetic */ PeerAgentCallback(com.heytap.accessory.BaseJobAgent baseJobAgent, byte b2) {
            this();
        }

        private PeerAgentCallback() {
        }

        @Override // com.heytap.accessory.api.IPeerAgentCallback
        public void a_renamed(android.os.Bundle bundle) throws android.os.RemoteException {
            com.heytap.accessory.a_renamed.a_renamed.a_renamed(com.heytap.accessory.BaseJobAgent.TAG, "FindPeer response received.");
            bundle.setClassLoader(com.heytap.accessory.bean.PeerAgent.class.getClassLoader());
            if (bundle.containsKey(com.heytap.accessory.constant.AFConstants.EXTRA_ERROR_CODE)) {
                int i_renamed = bundle.getInt(com.heytap.accessory.constant.AFConstants.EXTRA_ERROR_CODE);
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(com.heytap.accessory.BaseJobAgent.TAG, "Peer Not Found(" + i_renamed + ") for: " + getClass().getName());
                if (com.heytap.accessory.BaseJobAgent.this.mBackgroundWorker != null) {
                    android.os.Message messageObtainMessage = com.heytap.accessory.BaseJobAgent.this.mBackgroundWorker.obtainMessage();
                    messageObtainMessage.what = 3;
                    messageObtainMessage.arg1 = i_renamed;
                    com.heytap.accessory.BaseJobAgent.this.mBackgroundWorker.sendMessage(messageObtainMessage);
                    return;
                }
                com.heytap.accessory.a_renamed.a_renamed.d_renamed(com.heytap.accessory.BaseJobAgent.TAG, "onPeersAgentsFound: mBackgroundWorker is_renamed null!");
                return;
            }
            java.util.ArrayList<com.heytap.accessory.bean.PeerAgent> parcelableArrayList = bundle.getParcelableArrayList(com.heytap.accessory.constant.AFConstants.EXTRA_PEER_AGENTS);
            if (parcelableArrayList == null) {
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(com.heytap.accessory.BaseJobAgent.TAG, "Find Peer - invalid response from Accessory Framework");
                return;
            }
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(com.heytap.accessory.BaseJobAgent.TAG, parcelableArrayList.size() + " Peer agent(s_renamed) found for:" + getClass().getName());
            for (com.heytap.accessory.bean.PeerAgent peerAgent : parcelableArrayList) {
                com.heytap.accessory.a_renamed.a_renamed.c_renamed(com.heytap.accessory.BaseJobAgent.TAG, "Peer ID_renamed:" + peerAgent.getAgentId() + "Container Id:" + peerAgent.getAppName() + " Accessory" + peerAgent.getAccessory().getPeerId() + " Transport:" + peerAgent.getAccessory().getTransportType());
            }
            if (com.heytap.accessory.BaseJobAgent.this.mBackgroundWorker != null) {
                android.os.Message messageObtainMessage2 = com.heytap.accessory.BaseJobAgent.this.mBackgroundWorker.obtainMessage();
                messageObtainMessage2.what = 3;
                messageObtainMessage2.arg1 = 0;
                messageObtainMessage2.obj = parcelableArrayList.toArray(new com.heytap.accessory.bean.PeerAgent[0]);
                com.heytap.accessory.BaseJobAgent.this.mBackgroundWorker.sendMessage(messageObtainMessage2);
                return;
            }
            com.heytap.accessory.a_renamed.a_renamed.d_renamed(com.heytap.accessory.BaseJobAgent.TAG, "onPeerAgentsFound: mBackgroundWorker is_renamed null!");
        }

        @Override // com.heytap.accessory.api.IPeerAgentCallback
        public void b_renamed(android.os.Bundle bundle) throws android.os.RemoteException {
            com.heytap.accessory.a_renamed.a_renamed.a_renamed(com.heytap.accessory.BaseJobAgent.TAG, "Received peer agent update");
            bundle.setClassLoader(com.heytap.accessory.bean.PeerAgent.class.getClassLoader());
            if (!bundle.containsKey(com.heytap.accessory.constant.AFConstants.EXTRA_PEER_AGENTS)) {
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(com.heytap.accessory.BaseJobAgent.TAG, "No peer agents in_renamed PeerAgent update callback!");
                return;
            }
            java.util.ArrayList<com.heytap.accessory.bean.PeerAgent> parcelableArrayList = bundle.getParcelableArrayList(com.heytap.accessory.constant.AFConstants.EXTRA_PEER_AGENTS);
            int i_renamed = bundle.getInt(com.heytap.accessory.constant.AFConstants.EXTRA_PEER_AGENT_STATUS);
            if (parcelableArrayList == null) {
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(com.heytap.accessory.BaseJobAgent.TAG, "Peer Update - invalid peer agent list from Accessory Framework");
                return;
            }
            if (i_renamed != 105 && i_renamed != 106) {
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(com.heytap.accessory.BaseJobAgent.TAG, "Peer Update - invalid peer status from Accessory Framework:".concat(java.lang.String.valueOf(i_renamed)));
                return;
            }
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(com.heytap.accessory.BaseJobAgent.TAG, parcelableArrayList.size() + " Peer agent(s_renamed) updated for:" + getClass().getName());
            for (com.heytap.accessory.bean.PeerAgent peerAgent : parcelableArrayList) {
                com.heytap.accessory.a_renamed.a_renamed.c_renamed(com.heytap.accessory.BaseJobAgent.TAG, "Peer ID_renamed:" + peerAgent.getAgentId() + "Container Id:" + peerAgent.getAppName() + " Accessory" + peerAgent.getAccessory().getPeerId());
            }
            if (com.heytap.accessory.BaseJobAgent.this.mBackgroundWorker != null) {
                android.os.Message messageObtainMessage = com.heytap.accessory.BaseJobAgent.this.mBackgroundWorker.obtainMessage();
                messageObtainMessage.what = 4;
                if (i_renamed == 105) {
                    messageObtainMessage.arg1 = 1;
                } else {
                    messageObtainMessage.arg1 = 2;
                }
                messageObtainMessage.obj = parcelableArrayList.toArray(new com.heytap.accessory.bean.PeerAgent[0]);
                com.heytap.accessory.BaseJobAgent.this.mBackgroundWorker.sendMessage(messageObtainMessage);
                return;
            }
            com.heytap.accessory.a_renamed.a_renamed.d_renamed(com.heytap.accessory.BaseJobAgent.TAG, "onPeerAgentUpdated: mBackgroundWorker is_renamed null!");
        }
    }

    static class AgentCallbackImpl implements com.heytap.accessory.BaseAdapter.b_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private com.heytap.accessory.BaseJobAgent f3171a;

        public AgentCallbackImpl(com.heytap.accessory.BaseJobAgent baseJobAgent) {
            this.f3171a = baseJobAgent;
        }

        @Override // com.heytap.accessory.BaseAdapter.b_renamed
        public final void a_renamed() {
            if (this.f3171a.mBackgroundWorker != null) {
                android.os.Message messageObtainMessage = this.f3171a.mBackgroundWorker.obtainMessage(12);
                messageObtainMessage.arg1 = 20001;
                this.f3171a.mBackgroundWorker.sendMessage(messageObtainMessage);
                return;
            }
            com.heytap.accessory.a_renamed.a_renamed.d_renamed(com.heytap.accessory.BaseJobAgent.TAG, "onFrameworkDisconnected: mBackgroundWorker is_renamed null!");
        }

        @Override // com.heytap.accessory.BaseAdapter.b_renamed
        public final void b_renamed() {
            try {
                this.f3171a.registerMexAgent();
            } catch (com.heytap.accessory.bean.GeneralException e_renamed) {
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(com.heytap.accessory.BaseJobAgent.TAG, "onFrameworkConnected() - Failed to register agent with message! " + e_renamed.getMessage());
            }
        }

        @Override // com.heytap.accessory.BaseAdapter.b_renamed
        public final void c_renamed() throws com.heytap.accessory.bean.GeneralException {
            this.f3171a.mBackgroundWorker.sendEmptyMessage(15);
        }
    }

    class AuthenticationCallback extends com.heytap.accessory.api.IPeerAgentAuthCallback.Stub {
        /* synthetic */ AuthenticationCallback(com.heytap.accessory.BaseJobAgent baseJobAgent, byte b2) {
            this();
        }

        private AuthenticationCallback() {
        }

        @Override // com.heytap.accessory.api.IPeerAgentAuthCallback
        public void a_renamed(android.os.Bundle bundle) throws android.os.RemoteException {
            com.heytap.accessory.a_renamed.a_renamed.a_renamed(com.heytap.accessory.BaseJobAgent.TAG, "Received Authentication response");
            if (com.heytap.accessory.BaseJobAgent.this.mBackgroundWorker != null) {
                android.os.Message messageObtainMessage = com.heytap.accessory.BaseJobAgent.this.mBackgroundWorker.obtainMessage(11);
                messageObtainMessage.setData(bundle);
                com.heytap.accessory.BaseJobAgent.this.mBackgroundWorker.sendMessage(messageObtainMessage);
                return;
            }
            com.heytap.accessory.a_renamed.a_renamed.d_renamed(com.heytap.accessory.BaseJobAgent.TAG, "onPeerAgentAuthenticated: mBackgroundWorker is_renamed null!");
        }
    }

    class ConnectionCallback implements com.heytap.accessory.BaseSocket.a_renamed {
        /* synthetic */ ConnectionCallback(com.heytap.accessory.BaseJobAgent baseJobAgent, byte b2) {
            this();
        }

        private ConnectionCallback() {
        }

        @Override // com.heytap.accessory.BaseSocket.a_renamed
        public final void a_renamed(com.heytap.accessory.bean.PeerAgent peerAgent, com.heytap.accessory.BaseSocket baseSocket) {
            com.heytap.accessory.BaseJobAgent.this.mSuccessfulConnections.add(baseSocket);
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(com.heytap.accessory.BaseJobAgent.TAG, "Connection success with peer:" + peerAgent.getAgentId());
            com.heytap.accessory.BaseJobAgent.this.onServiceConnectionResponse(peerAgent, baseSocket, 0);
            com.heytap.accessory.BaseJobAgent.this.handleServiceConnectionErrorCode(0);
        }

        @Override // com.heytap.accessory.BaseSocket.a_renamed
        public final void a_renamed(com.heytap.accessory.bean.PeerAgent peerAgent, int i_renamed) {
            if (i_renamed == 20001) {
                com.heytap.accessory.a_renamed.a_renamed.d_renamed(com.heytap.accessory.BaseJobAgent.TAG, "Framework disconnected during connection process!");
                com.heytap.accessory.BaseJobAgent.this.handleError(i_renamed, peerAgent);
                return;
            }
            if (com.heytap.accessory.BaseJobAgent.this.mBackgroundWorker != null) {
                if (i_renamed == com.heytap.accessory.BaseJobAgent.CONNECTION_FAILURE_LOCAL_AGENT_NOT_FOUND) {
                    i_renamed = 10008;
                    com.heytap.accessory.BaseJobAgent.this.mBackgroundWorker.sendMessage(com.heytap.accessory.BaseJobAgent.this.mBackgroundWorker.obtainMessage(1));
                }
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(com.heytap.accessory.BaseJobAgent.TAG, "Connection attempt failed wih peer:" + peerAgent.getAgentId() + " reason:" + i_renamed);
                android.os.Message messageObtainMessage = com.heytap.accessory.BaseJobAgent.this.mBackgroundWorker.obtainMessage(13);
                messageObtainMessage.arg1 = i_renamed;
                messageObtainMessage.obj = peerAgent;
                com.heytap.accessory.BaseJobAgent.this.mBackgroundWorker.sendMessage(messageObtainMessage);
                return;
            }
            com.heytap.accessory.a_renamed.a_renamed.d_renamed(com.heytap.accessory.BaseJobAgent.TAG, "onConnectionFailure: mBackgroundWorker is_renamed null!");
        }
    }

    static class InstanceHandler extends android.os.Handler {
        public InstanceHandler(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            int i_renamed = message.what;
            if (i_renamed != 1) {
                if (i_renamed != 2) {
                    return;
                }
                com.heytap.accessory.BaseJobAgent baseJobAgent = (com.heytap.accessory.BaseJobAgent) message.obj;
                if (com.heytap.accessory.BaseJobAgent.sAgentsMap.get(baseJobAgent.getClass().getName()) == baseJobAgent) {
                    baseJobAgent.destroy();
                    return;
                } else {
                    com.heytap.accessory.a_renamed.a_renamed.d_renamed(com.heytap.accessory.BaseJobAgent.TAG, "Stale agent entry. Agent already destroyed. Ignoring...");
                    return;
                }
            }
            com.heytap.accessory.BaseJobAgent.InstanceCreator instanceCreator = (com.heytap.accessory.BaseJobAgent.InstanceCreator) message.obj;
            android.content.Context context = instanceCreator.f3175a;
            java.lang.String str = instanceCreator.f3176b;
            com.heytap.accessory.BaseJobAgent.RequestAgentCallback requestAgentCallback = instanceCreator.f3177c;
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(com.heytap.accessory.BaseJobAgent.TAG, "CREATE_AGENT: ".concat(java.lang.String.valueOf(str)));
            int i2 = message.arg1;
            com.heytap.accessory.BaseJobAgent baseJobAgent2 = (com.heytap.accessory.BaseJobAgent) com.heytap.accessory.BaseJobAgent.sAgentsMap.get(str);
            if (baseJobAgent2 != null) {
                com.heytap.accessory.a_renamed.a_renamed.b_renamed(com.heytap.accessory.BaseJobAgent.TAG, "CREATE_AGENT, but sAgentMap already exist");
                if (!baseJobAgent2.isProcessingCleanup()) {
                    if (requestAgentCallback != null) {
                        requestAgentCallback.onAgentAvailable(baseJobAgent2);
                        return;
                    }
                    return;
                } else {
                    if (i2 == 4) {
                        requestAgentCallback.onError(com.heytap.accessory.BaseJobAgent.ERROR_AGENT_REQUEST_IN_PROGRESS, "Class could not be_renamed initialized: " + str + ". Error occurred while releasing agent.");
                        return;
                    }
                    android.os.Message messageObtainMessage = obtainMessage(1);
                    messageObtainMessage.arg1 = i2 + 1;
                    messageObtainMessage.obj = instanceCreator;
                    sendMessageDelayed(messageObtainMessage, com.heytap.accessory.BaseJobAgent.CLEANUP_WAIT_TIME);
                    return;
                }
            }
            com.heytap.accessory.BaseJobAgent.INSTANCE_LOCK.lock();
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(com.heytap.accessory.BaseJobAgent.TAG, "CREATE_AGENT, create it by_renamed reflection: ".concat(java.lang.String.valueOf(str)));
            try {
                try {
                    try {
                        try {
                            try {
                                try {
                                    java.lang.reflect.Constructor<?> declaredConstructor = java.lang.Class.forName(str).getDeclaredConstructor(android.content.Context.class);
                                    declaredConstructor.setAccessible(true);
                                    declaredConstructor.newInstance(context);
                                    com.heytap.accessory.BaseJobAgent.INSTANCE_LOCK.unlock();
                                    com.heytap.accessory.BaseJobAgent baseJobAgent3 = (com.heytap.accessory.BaseJobAgent) com.heytap.accessory.BaseJobAgent.sAgentsMap.get(str);
                                    if (baseJobAgent3 != null) {
                                        if (requestAgentCallback != null) {
                                            requestAgentCallback.onAgentAvailable(baseJobAgent3);
                                        }
                                    } else {
                                        requestAgentCallback.onError(com.heytap.accessory.BaseJobAgent.ERROR_CONSTRUCTOR_EXCEPTION, "Class could not be_renamed initialized: " + str + ". Call super inside constructor.");
                                    }
                                } catch (java.lang.IllegalArgumentException e_renamed) {
                                    e_renamed.printStackTrace();
                                    requestAgentCallback.onError(com.heytap.accessory.BaseJobAgent.ERROR_CONSTRUCTOR_EXCEPTION, "Class instantiation error: " + str + ". Invalid context passed.");
                                    com.heytap.accessory.BaseJobAgent.INSTANCE_LOCK.unlock();
                                }
                            } catch (java.lang.NoSuchMethodException e2) {
                                e2.printStackTrace();
                                requestAgentCallback.onError(2562, "Constructor with Context argument not found: ".concat(java.lang.String.valueOf(str)));
                                com.heytap.accessory.BaseJobAgent.INSTANCE_LOCK.unlock();
                            }
                        } catch (java.lang.ClassNotFoundException e3) {
                            e3.printStackTrace();
                            requestAgentCallback.onError(2561, "Class not found: ".concat(java.lang.String.valueOf(str)));
                            com.heytap.accessory.BaseJobAgent.INSTANCE_LOCK.unlock();
                        }
                    } catch (java.lang.InstantiationException e4) {
                        e4.printStackTrace();
                        requestAgentCallback.onError(com.heytap.accessory.BaseJobAgent.ERROR_CONSTRUCTOR_EXCEPTION, "Class instantiation error: ".concat(java.lang.String.valueOf(str)));
                        com.heytap.accessory.BaseJobAgent.INSTANCE_LOCK.unlock();
                    }
                } catch (java.lang.IllegalAccessException e5) {
                    e5.printStackTrace();
                    requestAgentCallback.onError(com.heytap.accessory.BaseJobAgent.ERROR_CONSTRUCTOR_EXCEPTION, "Class constructor not accessible: ".concat(java.lang.String.valueOf(str)));
                    com.heytap.accessory.BaseJobAgent.INSTANCE_LOCK.unlock();
                } catch (java.lang.reflect.InvocationTargetException e6) {
                    e6.printStackTrace();
                    requestAgentCallback.onError(com.heytap.accessory.BaseJobAgent.ERROR_CONSTRUCTOR_EXCEPTION, "Exception occurred while calling constructor of_renamed class: ".concat(java.lang.String.valueOf(str)));
                    com.heytap.accessory.BaseJobAgent.INSTANCE_LOCK.unlock();
                }
            } catch (java.lang.Throwable th) {
                com.heytap.accessory.BaseJobAgent.INSTANCE_LOCK.unlock();
                throw th;
            }
        }
    }

    static class InstanceCreator {

        /* renamed from: a_renamed, reason: collision with root package name */
        private android.content.Context f3175a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private java.lang.String f3176b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private com.heytap.accessory.BaseJobAgent.RequestAgentCallback f3177c;

        public InstanceCreator(android.content.Context context, java.lang.String str, com.heytap.accessory.BaseJobAgent.RequestAgentCallback requestAgentCallback) {
            this.f3175a = context;
            this.f3176b = str;
            this.f3177c = requestAgentCallback;
        }
    }

    static class AgentHandler extends android.os.Handler {

        /* renamed from: a_renamed, reason: collision with root package name */
        com.heytap.accessory.BaseJobAgent f3172a;

        public AgentHandler(com.heytap.accessory.BaseJobAgent baseJobAgent, android.os.Looper looper) {
            super(looper);
            this.f3172a = baseJobAgent;
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) throws java.util.concurrent.ExecutionException, java.lang.InterruptedException {
            if (this.f3172a.mAdapter != null) {
                switch (message.what) {
                    case 0:
                        try {
                            this.f3172a.bindToFramework();
                            break;
                        } catch (com.heytap.accessory.bean.GeneralException e_renamed) {
                            com.heytap.accessory.a_renamed.a_renamed.b_renamed(com.heytap.accessory.BaseJobAgent.TAG, "Binding to Accessory Framework failed", e_renamed);
                            this.f3172a.handleError(e_renamed.getErrorCode(), null);
                            return;
                        }
                    case 1:
                        this.f3172a.registerService();
                        break;
                    case 2:
                        this.f3172a.requestPeerAgents();
                        break;
                    case 3:
                        int i_renamed = message.arg1;
                        if (i_renamed != 0) {
                            this.f3172a.handleFindPeerErrorCode(message.arg1);
                            this.f3172a.onFindPeerAgentsResponse(null, message.arg1);
                            break;
                        } else {
                            com.heytap.accessory.BaseJobAgent baseJobAgent = this.f3172a;
                            if (!(baseJobAgent instanceof com.heytap.accessory.NativeAgent)) {
                                baseJobAgent.handleFindPeerErrorCode(0);
                                this.f3172a.onFindPeerAgentsResponse((com.heytap.accessory.bean.PeerAgent[]) message.obj, 0);
                                break;
                            } else {
                                ((com.heytap.accessory.NativeAgent) baseJobAgent).a_renamed(i_renamed, java.util.Arrays.asList((com.heytap.accessory.bean.PeerAgent[]) message.obj));
                                break;
                            }
                        }
                    case 4:
                        this.f3172a.onPeerAgentsUpdated((com.heytap.accessory.bean.PeerAgent[]) message.obj, message.arg1);
                        this.f3172a.handlePeerAgentUpdateErrorCode(message.arg1);
                        break;
                    case 5:
                        this.f3172a.notifyConnectionRequest((android.content.Intent) message.obj);
                        break;
                    case 6:
                        com.heytap.accessory.a_renamed.a_renamed.b_renamed(com.heytap.accessory.BaseJobAgent.TAG, "MESSAGE_CONNECTION_INDICATION_JOB");
                        com.heytap.accessory.IJobListener iJobListener = (com.heytap.accessory.IJobListener) message.obj;
                        android.app.job.JobParameters jobParameters = (android.app.job.JobParameters) message.getData().get(com.heytap.accessory.constant.AFConstants.EXTRA_PARAMS);
                        this.f3172a.notifyConnectionRequest(jobParameters.getExtras());
                        iJobListener.onJobFinished(jobParameters);
                        break;
                    case 7:
                        this.f3172a.requestConnection((com.heytap.accessory.bean.PeerAgent) message.obj);
                        break;
                    case 8:
                        this.f3172a.acceptServiceConnectionInternal((com.heytap.accessory.bean.PeerAgent) message.obj);
                        break;
                    case 9:
                        this.f3172a.rejectServiceConnectionInternal((com.heytap.accessory.bean.PeerAgent) message.obj);
                        break;
                    case 10:
                        this.f3172a.requestPeerAuthInternal((com.heytap.accessory.bean.PeerAgent) message.obj);
                        break;
                    case 11:
                        this.f3172a.handleAuthResponse(message.getData());
                        break;
                    case 12:
                        this.f3172a.handleError(message.arg1, message.obj instanceof com.heytap.accessory.bean.PeerAgent ? (com.heytap.accessory.bean.PeerAgent) message.obj : null);
                        break;
                    case 13:
                        this.f3172a.onServiceConnectionResponse(message.obj instanceof com.heytap.accessory.bean.PeerAgent ? (com.heytap.accessory.bean.PeerAgent) message.obj : null, null, message.arg1);
                        this.f3172a.handleServiceConnectionErrorCode(message.arg1);
                        break;
                    case 14:
                        this.f3172a.cleanup();
                        break;
                    case 15:
                        try {
                            this.f3172a.loadAgentId();
                            break;
                        } catch (com.heytap.accessory.bean.GeneralException e2) {
                            com.heytap.accessory.a_renamed.a_renamed.b_renamed(com.heytap.accessory.BaseJobAgent.TAG, "Retrieving agent id_renamed failed", e2);
                            this.f3172a.handleError(e2.getErrorCode(), null);
                            return;
                        }
                    default:
                        com.heytap.accessory.a_renamed.a_renamed.d_renamed(com.heytap.accessory.BaseJobAgent.TAG, "Invalid msg received: " + message.what);
                        break;
                }
            }
            com.heytap.accessory.a_renamed.a_renamed.d_renamed(com.heytap.accessory.BaseJobAgent.TAG, "BaseApdater is_renamed null, return!");
        }
    }
}
