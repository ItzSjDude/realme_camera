package com.heytap.accessory;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.PersistableBundle;
import android.os.RemoteException;
import com.heytap.accessory.BaseAdapter;
import com.heytap.accessory.BaseSocket;
import com.heytap.accessory.api.IPeerAgentAuthCallback;
import com.heytap.accessory.api.IPeerAgentCallback;
import com.heytap.accessory.bean.AuthenticationToken;
import com.heytap.accessory.bean.GeneralException;
import com.heytap.accessory.bean.PeerAgent;
import com.heytap.accessory.bean.SdkUnsupportedException;
import com.heytap.accessory.bean.ServiceProfile;
import com.heytap.accessory.constant.AFConstants;
import com.heytap.accessory.p103a.SdkLog;
import com.heytap.accessory.p104b.ConfigUtil;
import com.heytap.accessory.p104b.SdkConfig;
import java.lang.Thread;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes2.dex */
public abstract class BaseJobAgent {
    public static final String ACTION_REGISTRATION_REQUIRED = "com.heytap.accessory.action.REGISTER_AGENT";
    public static final String ACTION_SERVICE_CONNECTION_REQUESTED = "com.heytap.accessory.action.SERVICE_CONNECTION_REQUESTED";
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
    private static final String TAG = "BaseJobAgent";
    private static InstanceHandler sInstanceHandler;
    BaseAdapter mAdapter;
    private AgentCallbackImpl mAgentCallback;
    private String mAgentId;
    AgentHandler mBackgroundWorker;
    private ConnectionCallback mConnectionCallback;
    private Context mContext;
    private BaseMessage mMessage;
    private String mName;
    private PeerAgentCallback mPeerAgentCallback;
    private AuthenticationCallback mPeerAuthCallback;
    private Set<PeerAgent> mPendingRequests;
    private volatile boolean mProcessingCleanup;
    private Class<? extends BaseSocket> mSocketImpl;
    private List<BaseSocket> mSuccessfulConnections;
    private static final ReentrantLock INSTANCE_LOCK = new ReentrantLock();
    private static Map<String, BaseJobAgent> sAgentsMap = new ConcurrentHashMap();
    private Object mLock = new Object();
    private ServiceProfile mServiceProfile = null;
    private int mGetAgentIdRetryCount = 0;

    public interface RequestAgentCallback {
        void onAgentAvailable(BaseJobAgent baseJobAgent);

        void onError(int OplusGLSurfaceView_13, String str);
    }

    protected BaseJobAgent(String str, Context context) {
        if (str != null && !"".equalsIgnoreCase(str)) {
            if (!INSTANCE_LOCK.isHeldByCurrentThread()) {
                throw new IllegalArgumentException("Constructor should not be called for initializing " + str + ". Call requestAgent API instead");
            }
            this.mName = str;
            this.mContext = context;
            initializeAgent();
            return;
        }
        throw new IllegalArgumentException("Invalid parameter name:".concat(String.valueOf(str)));
    }

    protected BaseJobAgent(String str, Context context, Class<? extends BaseSocket> cls) throws NoSuchMethodException, SecurityException {
        if (str != null && !"".equalsIgnoreCase(str)) {
            if (!INSTANCE_LOCK.isHeldByCurrentThread()) {
                throw new IllegalArgumentException("Constructor should not be called for initializing " + str + ". Call requestAgent API instead");
            }
            this.mName = str;
            this.mContext = context;
            validateSocketImplementation(cls);
            this.mSocketImpl = cls;
            SdkLog.m8378b(TAG, "Thread Name:" + this.mName + "BaseSocket Imple class:" + cls.getName());
            initializeAgent();
            return;
        }
        throw new IllegalArgumentException("Invalid parameter name:".concat(String.valueOf(str)));
    }

    public static void requestAgent(Context context, String str, RequestAgentCallback requestAgentCallback) {
        SdkLog.m8378b(TAG, "requestAgent");
        InstanceCreator instanceCreator = new InstanceCreator(context, str, requestAgentCallback);
        if (sInstanceHandler == null) {
            HandlerThread handlerThread = new HandlerThread("instance");
            handlerThread.start();
            InstanceHandler unused = sInstanceHandler = new InstanceHandler(handlerThread.getLooper());
        }
        Message messageObtainMessage = sInstanceHandler.obtainMessage(1);
        messageObtainMessage.obj = instanceCreator;
        messageObtainMessage.sendToTarget();
    }

    public void releaseAgent() {
        Message messageObtainMessage = sInstanceHandler.obtainMessage(2);
        messageObtainMessage.obj = this;
        messageObtainMessage.sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isProcessingCleanup() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mProcessingCleanup;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void destroy() {
        SdkLog.m8378b(TAG, "BaseJobAgent - onDestroy:" + getClass().getSimpleName());
        synchronized (this.mLock) {
            this.mProcessingCleanup = true;
        }
        AgentHandler agentHandler = this.mBackgroundWorker;
        if (agentHandler != null) {
            agentHandler.obtainMessage(14).sendToTarget();
        }
    }

    private static void putAgent(String str, BaseJobAgent baseJobAgent) {
        if (sAgentsMap.containsKey(str)) {
            return;
        }
        sAgentsMap.put(str, baseJobAgent);
    }

    private void initializeAgent() {
        try {
            new SdkConfig(getApplicationContext());
        } catch (GeneralException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        SdkLog.m8378b(TAG, "BaseJobAgent - initialize:" + getClass().getSimpleName());
        this.mSuccessfulConnections = Collections.synchronizedList(new ArrayList());
        this.mPendingRequests = Collections.synchronizedSet(new HashSet());
        HandlerThread handlerThread = new HandlerThread(this.mName);
        handlerThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.heytap.accessory.BaseJobAgent.1
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, final Throwable th) {
                SdkLog.m8379b(BaseJobAgent.TAG, "Exception in background thread:" + thread.getName(), th);
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.heytap.accessory.BaseJobAgent.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        throw new RuntimeException(th);
                    }
                });
            }
        });
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        if (looper == null) {
            SdkLog.m8383e(TAG, "Unable to start Agent thread.");
            throw new RuntimeException("Unable to start Agent.Worker thread creation failed");
        }
        this.mBackgroundWorker = new AgentHandler(this, looper);
        try {
            Initializer.initBufferPool(getApplicationContext());
        } catch (SdkUnsupportedException e2) {
            SdkLog.m8379b(TAG, "SDK initialization failed!", e2);
            Message messageObtainMessage = this.mBackgroundWorker.obtainMessage(12);
            messageObtainMessage.arg1 = 20002;
            this.mBackgroundWorker.sendMessage(messageObtainMessage);
        }
        putAgent(getClass().getName(), this);
        this.mAdapter = BaseAdapter.getDefaultAdapter(getApplicationContext(), this.mBackgroundWorker);
        byte b2 = 0;
        this.mPeerAuthCallback = new AuthenticationCallback(this, b2);
        this.mPeerAgentCallback = new PeerAgentCallback(this, b2);
        this.mConnectionCallback = new ConnectionCallback(this, b2);
        this.mAgentCallback = new AgentCallbackImpl(this);
        this.mBackgroundWorker.sendEmptyMessage(0);
        fetchServiceProfile();
    }

    public Context getApplicationContext() {
        return this.mContext.getApplicationContext();
    }

    protected void onFindPeerAgentsResponse(PeerAgent[] peerAgentArr, int OplusGLSurfaceView_13) {
        SdkLog.m8383e(TAG, "Invalid implementation of BaseJobAgent.onFindPeerAgentsResponse(PeerAgent[], int) should be overrided!");
    }

    protected void onPeerAgentsUpdated(PeerAgent[] peerAgentArr, int OplusGLSurfaceView_13) {
        SdkLog.m8383e(TAG, "Invalid implementation of BaseJobAgent.onPeerAgentsUpdated(PeerAgent[], int) should be overrided!");
    }

    protected void onServiceConnectionRequested(PeerAgent peerAgent) {
        if (peerAgent != null) {
            SdkLog.m8375a(TAG, "Accepting connection request by default from Peer:" + peerAgent.getAgentId() + " Transaction:" + peerAgent.getTransactionId());
        }
        acceptServiceConnectionRequest(peerAgent);
    }

    protected void onServiceConnectionResponse(PeerAgent peerAgent, BaseSocket baseSocket, int OplusGLSurfaceView_13) {
        SdkLog.m8382d(TAG, "No Implementaion for onServiceConnectionResponse(PeerAgent peerAgent, BaseSocket socket, int result)!");
    }

    protected void onAuthenticationResponse(PeerAgent peerAgent, AuthenticationToken authenticationToken, int OplusGLSurfaceView_13) {
        SdkLog.m8378b(TAG, "Peer authentication response received:".concat(String.valueOf(OplusGLSurfaceView_13)));
    }

    protected void onLowMemory() {
        SdkLog.m8378b(TAG, "Service Low Memory");
    }

    protected void onError(PeerAgent peerAgent, String str, int OplusGLSurfaceView_13) {
        if (peerAgent == null) {
            SdkLog.m8383e(TAG, "ACCEPT_STATE_ERROR: " + OplusGLSurfaceView_13 + ": " + str + " PeerAgent: null");
            return;
        }
        SdkLog.m8383e(TAG, "ACCEPT_STATE_ERROR: " + OplusGLSurfaceView_13 + ": " + str + " PeerAgent: " + peerAgent.getAgentId());
    }

    protected final synchronized void findPeerAgents() {
        SdkLog.m8378b(TAG, "findPeer request received by:" + getClass().getName());
        try {
            Initializer.initBufferPool(getApplicationContext());
            if (this.mBackgroundWorker != null) {
                Message messageObtainMessage = this.mBackgroundWorker.obtainMessage();
                messageObtainMessage.what = 2;
                this.mBackgroundWorker.sendMessage(messageObtainMessage);
                return;
            }
            SdkLog.m8382d(TAG, "findPeerAgents: mBackgroundWorker is null!");
        } catch (SdkUnsupportedException COUIBaseListPopupWindow_8) {
            SdkLog.m8379b(TAG, "exception: ", COUIBaseListPopupWindow_8);
            handleError(20002, null);
        }
    }

    protected final void requestServiceConnection(PeerAgent peerAgent) {
        if (peerAgent == null) {
            throw new IllegalArgumentException("Illegal argument peerAgent:".concat(String.valueOf(peerAgent)));
        }
        try {
            Initializer.initBufferPool(getApplicationContext());
            SdkLog.m8381c(TAG, "Service connection requested for peer:" + peerAgent.getAgentId());
            AgentHandler agentHandler = this.mBackgroundWorker;
            if (agentHandler != null) {
                Message messageObtainMessage = agentHandler.obtainMessage(7);
                messageObtainMessage.obj = peerAgent;
                this.mBackgroundWorker.sendMessage(messageObtainMessage);
                return;
            }
            SdkLog.m8382d(TAG, "requestServiceConection: mBackgroundWorker is null!");
        } catch (SdkUnsupportedException COUIBaseListPopupWindow_8) {
            SdkLog.m8383e(TAG, "exception: " + COUIBaseListPopupWindow_8.getMessage());
            handleError(20002, peerAgent);
        }
    }

    protected void acceptServiceConnectionRequest(PeerAgent peerAgent) {
        if (peerAgent == null) {
            throw new IllegalArgumentException("Illegal argument peerAgent:".concat(String.valueOf(peerAgent)));
        }
        try {
            Initializer.initBufferPool(getApplicationContext());
            if (this.mPendingRequests.remove(peerAgent)) {
                SdkLog.m8381c(TAG, "Trying to Accept service connection request from peer:" + peerAgent.getAgentId() + " Transaction:" + peerAgent.getTransactionId());
                AgentHandler agentHandler = this.mBackgroundWorker;
                if (agentHandler != null) {
                    Message messageObtainMessage = agentHandler.obtainMessage(8);
                    messageObtainMessage.obj = peerAgent;
                    this.mBackgroundWorker.sendMessage(messageObtainMessage);
                    return;
                }
                SdkLog.m8382d(TAG, "acceptServiceConnection: mBackgroundWorker is null!");
            }
        } catch (SdkUnsupportedException COUIBaseListPopupWindow_8) {
            SdkLog.m8383e(TAG, "exception: " + COUIBaseListPopupWindow_8.getMessage());
            handleError(20002, peerAgent);
        }
    }

    protected void rejectServiceConnectionRequest(PeerAgent peerAgent) {
        if (peerAgent == null) {
            throw new IllegalArgumentException("Illegal argument peerAgent:".concat(String.valueOf(peerAgent)));
        }
        try {
            Initializer.initBufferPool(getApplicationContext());
            if (this.mPendingRequests.remove(peerAgent)) {
                SdkLog.m8381c(TAG, "Trying to reject connection request from peer:" + peerAgent.getAgentId() + " Transaction:" + peerAgent.getTransactionId());
                AgentHandler agentHandler = this.mBackgroundWorker;
                if (agentHandler != null) {
                    Message messageObtainMessage = agentHandler.obtainMessage(9);
                    messageObtainMessage.obj = peerAgent;
                    this.mBackgroundWorker.sendMessage(messageObtainMessage);
                    return;
                }
                SdkLog.m8382d(TAG, "rejectServiceConnection: mBackgroundWorker is null!");
                return;
            }
            SdkLog.m8382d(TAG, "Rejecting service connection with invalid peer agent:" + peerAgent.toString());
            handleInvalidPeerAction(peerAgent);
        } catch (SdkUnsupportedException COUIBaseListPopupWindow_8) {
            SdkLog.m8383e(TAG, "exception: " + COUIBaseListPopupWindow_8.getMessage());
            handleError(20002, peerAgent);
        }
    }

    protected void authenticatePeerAgent(PeerAgent peerAgent) {
        if (peerAgent == null) {
            throw new IllegalArgumentException("Illegal argument peerAgent:".concat(String.valueOf(peerAgent)));
        }
        try {
            Initializer.initBufferPool(getApplicationContext());
            SdkLog.m8381c(TAG, "Authentication requested for peer:" + peerAgent.getAgentId());
            AgentHandler agentHandler = this.mBackgroundWorker;
            if (agentHandler != null) {
                Message messageObtainMessage = agentHandler.obtainMessage(10);
                messageObtainMessage.obj = peerAgent;
                this.mBackgroundWorker.sendMessage(messageObtainMessage);
                return;
            }
            SdkLog.m8382d(TAG, "authenticatePeerAgent: mBackgroundWorker is null!");
        } catch (SdkUnsupportedException COUIBaseListPopupWindow_8) {
            SdkLog.m8383e(TAG, "exception: " + COUIBaseListPopupWindow_8.getMessage());
            handleError(20002, peerAgent);
        }
    }

    public String getServiceProfileId() {
        ServiceProfile serviceProfile = this.mServiceProfile;
        if (serviceProfile == null) {
            SdkLog.m8383e(TAG, "Failed because Service Profile is null");
            return null;
        }
        return serviceProfile.getId();
    }

    public String getServiceProfileName() {
        ServiceProfile serviceProfile = this.mServiceProfile;
        if (serviceProfile == null) {
            SdkLog.m8383e(TAG, "Failed because Service Profile is null");
            return null;
        }
        return serviceProfile.getName();
    }

    public int getServiceChannelSize() {
        ServiceProfile serviceProfile = this.mServiceProfile;
        if (serviceProfile == null) {
            SdkLog.m8383e(TAG, "Failed because Service Profile is null");
            return -1;
        }
        return serviceProfile.getServiceChannelList().size();
    }

    public int getServiceChannelId(int OplusGLSurfaceView_13) {
        if (this.mServiceProfile == null) {
            SdkLog.m8383e(TAG, "Failed because Service Profile is null");
            return -1;
        }
        if (OplusGLSurfaceView_13 >= 0 && OplusGLSurfaceView_13 < getServiceChannelSize()) {
            return this.mServiceProfile.getServiceChannelList().get(OplusGLSurfaceView_13).getChannelId();
        }
        SdkLog.m8383e(TAG, "Failed because of wrong index");
        return -1;
    }

    public List<BaseSocket> getSuccessfulConnections() {
        return this.mSuccessfulConnections;
    }

    String registerMessageInstance(BaseMessage baseMessage) {
        this.mMessage = baseMessage;
        return this.mAgentId;
    }

    Handler getAgentHandler() {
        return this.mBackgroundWorker;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindToFramework() throws ExecutionException, InterruptedException, GeneralException {
        this.mAdapter.registerAgentCallback(this.mAgentCallback);
        this.mAdapter.bindToFramework();
        loadAgentId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAgentId() throws ExecutionException, InterruptedException, GeneralException {
        SharedPreferences sharedPreferences;
        String localAgentId = getLocalAgentId();
        if (localAgentId == null) {
            handleError(20001, null);
            return;
        }
        if (Build.VERSION.SDK_INT > 26) {
            sharedPreferences = this.mContext.createDeviceProtectedStorageContext().getSharedPreferences("AccessoryPreferences", 0);
        } else {
            sharedPreferences = this.mContext.getApplicationContext().getSharedPreferences("AccessoryPreferences", 0);
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString(localAgentId, getClass().getName());
        editorEdit.putString(getClass().getName(), localAgentId);
        editorEdit.apply();
        SdkLog.m8378b(TAG, "save AgentId className:" + getClass().getName() + ",agentId: " + localAgentId);
        this.mAgentId = localAgentId;
        registerMexAgent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerMexAgent() throws GeneralException {
        String str;
        BaseMessage baseMessage = this.mMessage;
        if (baseMessage == null || (str = this.mAgentId) == null) {
            return;
        }
        baseMessage.registerAgent(str);
    }

    private void validateSocketImplementation(Class<? extends BaseSocket> cls) throws NoSuchMethodException, SecurityException {
        if (cls == null) {
            throw new IllegalArgumentException("Invalid socketClass param");
        }
        try {
            if (!Modifier.toString(cls.getModifiers()).contains("static") && cls.getEnclosingClass() != null) {
                cls.getDeclaredConstructor(cls.getEnclosingClass());
            } else {
                cls.getDeclaredConstructor(new Class[0]);
            }
        } catch (NoSuchMethodException COUIBaseListPopupWindow_8) {
            SdkLog.m8379b(TAG, "exception: " + COUIBaseListPopupWindow_8.getMessage(), COUIBaseListPopupWindow_8);
            throw new RuntimeException("Invalid implemetation of BaseSocket. Provider PlatformImplementations.kt_3 public default constructor in the implementation class.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerService() throws ExecutionException, InterruptedException {
        RegistrationTask c2149a = new RegistrationTask(getApplicationContext());
        Future<Void> futureM8372a = c2149a.m8372a();
        c2149a.m8373b();
        try {
            futureM8372a.get();
        } catch (InterruptedException unused) {
            SdkLog.m8383e(TAG, "Regisration failed! : InterruptedException");
        } catch (ExecutionException unused2) {
            SdkLog.m8383e(TAG, "Registration failed! : ExecutionException");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestPeerAgents() throws ExecutionException, InterruptedException {
        String localAgentId = getLocalAgentId();
        if (localAgentId == null) {
            handleError(20001, null);
            return;
        }
        try {
            int iFindPeerAgents = this.mAdapter.findPeerAgents(localAgentId, this.mPeerAgentCallback);
            if (iFindPeerAgents == 0) {
                SdkLog.m8378b(TAG, "Find peer request successfully enqueued.");
                return;
            }
            SdkLog.m8382d(TAG, "Find peer request failed:" + iFindPeerAgents + " for service " + getClass().getName());
            onFindPeerAgentsResponse(null, iFindPeerAgents);
            handleFindPeerErrorCode(iFindPeerAgents);
        } catch (GeneralException COUIBaseListPopupWindow_8) {
            SdkLog.m8383e(TAG, "Find Peer request failed!");
            handleError(COUIBaseListPopupWindow_8.getErrorCode(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFindPeerErrorCode(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 0) {
            SdkLog.m8381c(TAG, "onFindPeerAgentsResponse() -> PEER_AGENT_FOUND");
            return;
        }
        if (OplusGLSurfaceView_13 != 10010) {
            switch (OplusGLSurfaceView_13) {
                case 10001:
                    SdkLog.m8381c(TAG, "onFindPeerAgentsResponse() -> FIND_PEER_DEVICE_NOT_CONNECTED");
                    break;
                case 10002:
                    SdkLog.m8381c(TAG, "onFindPeerAgentsResponse() -> FIND_PEER_SERVICE_NOT_FOUND");
                    break;
                case 10003:
                    SdkLog.m8381c(TAG, "onFindPeerAgentsResponse() -> FIND_PEER_DUPLICATE_REQUEST");
                    break;
                default:
                    SdkLog.m8382d(TAG, "onFindPeerAgentsResponse() errorCode: ".concat(String.valueOf(OplusGLSurfaceView_13)));
                    break;
            }
            return;
        }
        SdkLog.m8381c(TAG, "onFindPeerAgentsResponse() -> FIND_PEER_TIMEOUT");
    }

    private void handleAuthErrorCode(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 0) {
            SdkLog.m8381c(TAG, "onAuthenticationResponse() -> AUTHENTICATION_SUCCESS");
            return;
        }
        if (OplusGLSurfaceView_13 == 1545) {
            SdkLog.m8381c(TAG, "onAuthenticationResponse() -> AUTHENTICATION_FAILURE_TOKEN_NOT_GENERATED");
        } else if (OplusGLSurfaceView_13 == 1546) {
            SdkLog.m8381c(TAG, "onAuthenticationResponse() -> AUTHENTICATION_FAILURE_PEER_AGENT_NOT_SUPPORTED");
        } else {
            SdkLog.m8382d(TAG, "onAuthenticationResponse() errorCode: ".concat(String.valueOf(OplusGLSurfaceView_13)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleServiceConnectionErrorCode(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 0) {
            SdkLog.m8381c(TAG, "onServiceConnectionResponse() -> CONNECTION_SUCCESS");
            return;
        }
        if (OplusGLSurfaceView_13 != 10012) {
            switch (OplusGLSurfaceView_13) {
                case 10004:
                    SdkLog.m8381c(TAG, "onServiceConnectionResponse() -> CONNECTION_FAILURE_DEVICE_UNREACHABLE");
                    break;
                case 10005:
                    SdkLog.m8381c(TAG, "onServiceConnectionResponse() -> CONNECTION_ALREADY_EXIST");
                    break;
                case 10006:
                    SdkLog.m8381c(TAG, "onServiceConnectionResponse() -> CONNECTION_FAILURE_PEERAGENT_NO_RESPONSE");
                    break;
                case 10007:
                    SdkLog.m8381c(TAG, "onServiceConnectionResponse() -> CONNECTION_FAILURE_PEERAGENT_REJECTED");
                    break;
                case 10008:
                    SdkLog.m8381c(TAG, "onServiceConnectionResponse() -> CONNECTION_FAILURE_INVALID_PEER_AGENT");
                    break;
                case 10009:
                    SdkLog.m8381c(TAG, "onServiceConnectionResponse() -> CONNECTION_DUPLICATE_REQUEST");
                    break;
                case 10010:
                    SdkLog.m8381c(TAG, "onServiceConnectionResponse() -> CONNECTION_FAILURE_SERVICE_LIMIT_REACHED");
                    break;
                default:
                    SdkLog.m8382d(TAG, "onServiceConnectionResponse() errorCode: ".concat(String.valueOf(OplusGLSurfaceView_13)));
                    break;
            }
            return;
        }
        SdkLog.m8381c(TAG, "onServiceConnectionResponse() -> CONNECTION_FAILURE_NETWORK");
    }

    private void handleOnErrorCode(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 1025) {
            SdkLog.m8381c(TAG, "onError() -> ERROR_CONNECTION_INVALID_PARAM");
            return;
        }
        switch (OplusGLSurfaceView_13) {
            case 20001:
                SdkLog.m8381c(TAG, "onError() -> ERROR_FATAL");
                break;
            case 20002:
                SdkLog.m8381c(TAG, "onError() -> ERROR_SDK_NOT_INITIALIZED");
                break;
            case 20003:
                SdkLog.m8381c(TAG, "onError() -> ERROR_PERMISSION_DENIED");
                break;
            case 20004:
                SdkLog.m8381c(TAG, "onError() -> ERROR_PERMISSION_FAILED");
                break;
            default:
                SdkLog.m8382d(TAG, "onError() errorCode: ".concat(String.valueOf(OplusGLSurfaceView_13)));
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePeerAgentUpdateErrorCode(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 1) {
            SdkLog.m8381c(TAG, "onPeerAgentUpdated() -> PEER_AGENT_AVAILABLE");
        } else if (OplusGLSurfaceView_13 == 2) {
            SdkLog.m8381c(TAG, "onPeerAgentUpdated() -> PEER_AGENT_UNAVAILABLE");
        } else {
            SdkLog.m8382d(TAG, "onPeerAgentUpdated() errorCode: ".concat(String.valueOf(OplusGLSurfaceView_13)));
        }
    }

    String getLocalAgentId() throws ExecutionException, InterruptedException {
        if (this.mAdapter == null) {
            SdkLog.m8382d(TAG, "BaseAdapter is null,just return!");
            return null;
        }
        SdkLog.m8378b(TAG, "mGetAgentIdRetryCount = " + this.mGetAgentIdRetryCount);
        if (this.mGetAgentIdRetryCount >= 2) {
            this.mGetAgentIdRetryCount = 0;
            SdkLog.m8383e(TAG, "Failed to retrieve service record, retry 2");
            return null;
        }
        try {
            String localAgentId = this.mAdapter.getLocalAgentId(getClass().getName());
            SdkLog.m8381c(TAG, "Agent ID retrieved successfully for " + getClass().getName() + " Agent ID:" + localAgentId);
            return localAgentId;
        } catch (GeneralException COUIBaseListPopupWindow_8) {
            if (COUIBaseListPopupWindow_8.getErrorCode() == 10016) {
                this.mGetAgentIdRetryCount++;
                SdkLog.m8382d(TAG, "Service record was not found in Accessory Framework.Registering service again!");
                try {
                    registerService();
                    SdkLog.m8381c(TAG, "Trying to fetch agent ID after re-registration");
                    return this.mAdapter.getLocalAgentId(getClass().getName());
                } catch (GeneralException unused) {
                    SdkLog.m8379b(TAG, "Failed to retrieve service record after re-registration", COUIBaseListPopupWindow_8);
                    return null;
                }
            }
            SdkLog.m8379b(TAG, "Failed to retrieve service record", COUIBaseListPopupWindow_8);
            return null;
        }
    }

    void handleConnectionRequest(Intent intent) {
        Message messageObtainMessage = this.mBackgroundWorker.obtainMessage();
        messageObtainMessage.what = 5;
        messageObtainMessage.obj = intent;
        this.mBackgroundWorker.sendMessage(messageObtainMessage);
    }

    @TargetApi(21)
    void handleConnectionRequest(JobParameters jobParameters, IJobListener iJobListener) {
        Message messageObtainMessage = this.mBackgroundWorker.obtainMessage();
        messageObtainMessage.what = 6;
        messageObtainMessage.obj = iJobListener;
        Bundle bundle = new Bundle();
        bundle.putParcelable(AFConstants.EXTRA_PARAMS, jobParameters);
        messageObtainMessage.setData(bundle);
        this.mBackgroundWorker.sendMessage(messageObtainMessage);
    }

    static void handleLowMemory() {
        synchronized (sAgentsMap) {
            Iterator<BaseJobAgent> it = sAgentsMap.values().iterator();
            while (it.hasNext()) {
                it.next().handleAgentLowMemory();
            }
        }
    }

    void handleAgentLowMemory() {
        this.mBackgroundWorker.sendEmptyMessage(18);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyConnectionRequest(Intent intent) {
        if (intent == null) {
            SdkLog.m8383e(TAG, "Invalid service connection indication.Intent:null.Ignoring reqeuset");
            return;
        }
        notifyConnectionRequest(intent.getLongExtra("transactionId", 0L), intent.getStringExtra(AFConstants.EXTRA_AGENT_ID), (PeerAgent) intent.getParcelableExtra(AFConstants.EXTRA_PEER_AGENT));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(21)
    public void notifyConnectionRequest(PersistableBundle persistableBundle) {
        if (persistableBundle == null) {
            SdkLog.m8383e(TAG, "Invalid service connection indication.Intent:null.Ignoring reqeuset");
            return;
        }
        long OplusGLSurfaceView_15 = persistableBundle.getLong("transactionId", 0L);
        String[] strArr = new String[0];
        String[] stringArray = persistableBundle.getStringArray(AFConstants.EXTRA_PEER_AGENT);
        if (stringArray == null) {
            SdkLog.m8383e(TAG, "Invalid initiator peer agent. Ignoring connection request");
        } else {
            notifyConnectionRequest(OplusGLSurfaceView_15, persistableBundle.getString(AFConstants.EXTRA_AGENT_ID), new PeerAgent((List<String>) Arrays.asList(stringArray)));
        }
    }

    private void notifyConnectionRequest(long OplusGLSurfaceView_15, String str, PeerAgent peerAgent) {
        if (peerAgent == null) {
            SdkLog.m8383e(TAG, "Invalid initiator peer agent:null. Ignoring connection request");
            return;
        }
        if (str == null) {
            SdkLog.m8383e(TAG, "Invalid local agent Id:null .Ignoring connection request");
            return;
        }
        peerAgent.setTransactionId(OplusGLSurfaceView_15);
        SdkLog.m8381c(TAG, "Connection initiated by peer: " + peerAgent.getAgentId() + " on Accessory: " + peerAgent.getAccessory().getPeerId() + " Transaction: " + OplusGLSurfaceView_15);
        this.mPendingRequests.add(peerAgent);
        onServiceConnectionRequested(peerAgent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestConnection(PeerAgent peerAgent) throws ExecutionException, InterruptedException {
        String localAgentId = getLocalAgentId();
        if (localAgentId == null) {
            SdkLog.m8383e(TAG, "Failed to retrieve service description.Ignoring service connection request");
            handleError(20001, peerAgent);
        } else {
            instantiateSocket().initiateServiceconnection(localAgentId, peerAgent, this.mAdapter, this.mConnectionCallback);
        }
    }

    private BaseSocket instantiateSocket() throws NoSuchMethodException, SecurityException {
        validateSocketImplementation(this.mSocketImpl);
        try {
            SdkLog.m8378b(TAG, "Instantiating BaseSocket: " + this.mSocketImpl.getName());
            if (!Modifier.toString(this.mSocketImpl.getModifiers()).contains("static") && this.mSocketImpl.getEnclosingClass() != null && BaseJobAgent.class.isAssignableFrom(this.mSocketImpl.getEnclosingClass())) {
                Constructor<? extends BaseSocket> declaredConstructor = this.mSocketImpl.getDeclaredConstructor(this.mSocketImpl.getEnclosingClass());
                declaredConstructor.setAccessible(true);
                return declaredConstructor.newInstance(this);
            }
            Constructor<? extends BaseSocket> declaredConstructor2 = this.mSocketImpl.getDeclaredConstructor(new Class[0]);
            declaredConstructor2.setAccessible(true);
            return declaredConstructor2.newInstance(new Object[0]);
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | InvocationTargetException COUIBaseListPopupWindow_8) {
            SdkLog.m8383e(TAG, "Invalid implementation of BaseSocket. Provider PlatformImplementations.kt_3 public default constructor." + COUIBaseListPopupWindow_8.getClass().getSimpleName() + " " + COUIBaseListPopupWindow_8.getMessage());
            throw new RuntimeException("Invalid implementation of BaseSocket. Provider PlatformImplementations.kt_3 public default constructor.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acceptServiceConnectionInternal(PeerAgent peerAgent) throws ExecutionException, InterruptedException {
        String localAgentId = getLocalAgentId();
        if (localAgentId == null) {
            handleError(20001, peerAgent);
        } else {
            instantiateSocket().acceptServiceConnection(localAgentId, peerAgent, this.mAdapter, this.mConnectionCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rejectServiceConnectionInternal(PeerAgent peerAgent) throws ExecutionException, InterruptedException {
        String localAgentId = getLocalAgentId();
        if (localAgentId == null) {
            handleError(20001, peerAgent);
            return;
        }
        try {
            this.mAdapter.rejectServiceConnection(localAgentId, peerAgent, peerAgent.getTransactionId());
        } catch (GeneralException COUIBaseListPopupWindow_8) {
            SdkLog.m8379b(TAG, "Failed to reject Service connection!", COUIBaseListPopupWindow_8);
            handleError(COUIBaseListPopupWindow_8.getErrorCode(), peerAgent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestPeerAuthInternal(PeerAgent peerAgent) throws ExecutionException, InterruptedException {
        String localAgentId = getLocalAgentId();
        if (localAgentId == null) {
            handleError(20001, peerAgent);
            return;
        }
        try {
            int iAuthenticatePeeragent = this.mAdapter.authenticatePeeragent(localAgentId, peerAgent, this.mPeerAuthCallback, peerAgent.getTransactionId());
            if (iAuthenticatePeeragent == 0) {
                SdkLog.m8381c(TAG, "Auth. request for peer: " + peerAgent.getAgentId() + " done successfully");
                return;
            }
            SdkLog.m8383e(TAG, "Auth. request for peer: " + peerAgent.getAgentId() + " failed as reason: " + iAuthenticatePeeragent);
            onAuthenticationResponse(peerAgent, null, iAuthenticatePeeragent);
            handleAuthErrorCode(iAuthenticatePeeragent);
        } catch (GeneralException COUIBaseListPopupWindow_8) {
            SdkLog.m8379b(TAG, "Failed to request peer authentication!", COUIBaseListPopupWindow_8);
            handleError(COUIBaseListPopupWindow_8.getErrorCode(), peerAgent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAuthResponse(Bundle bundle) {
        bundle.setClassLoader(PeerAgent.class.getClassLoader());
        byte[] byteArray = bundle.getByteArray(AFConstants.EXTRA_PEER_AUTH_KEY);
        int OplusGLSurfaceView_13 = bundle.getInt(AFConstants.EXTRA_CERTIFICATE_TYPE);
        PeerAgent peerAgent = (PeerAgent) bundle.getParcelable(AFConstants.EXTRA_PEER_AGENT);
        long OplusGLSurfaceView_15 = bundle.getLong("transactionId");
        if (peerAgent == null) {
            SdkLog.m8383e(TAG, "Invalid response from framework! No peer agent in auth response.Ignoring response");
            return;
        }
        peerAgent.setTransactionId(OplusGLSurfaceView_15);
        int i2 = 0;
        if (byteArray == null) {
            i2 = AUTHENTICATION_FAILURE_TOKEN_NOT_GENERATED;
            SdkLog.m8383e(TAG, "Authentication failed error:1545 Peer Id:" + peerAgent.getAgentId());
        } else {
            SdkLog.m8381c(TAG, "Authentication success status: 0 for peer: " + peerAgent.getAgentId());
        }
        onAuthenticationResponse(peerAgent, new AuthenticationToken(OplusGLSurfaceView_13, byteArray), i2);
        handleAuthErrorCode(i2);
    }

    String getId() throws ExecutionException, InterruptedException {
        String localAgentId = getLocalAgentId();
        if (localAgentId == null) {
            handleError(20001, null);
        }
        return localAgentId;
    }

    private void handleInvalidPeerAction(PeerAgent peerAgent) {
        synchronized (this.mPendingRequests) {
            Iterator<PeerAgent> it = this.mPendingRequests.iterator();
            while (it.hasNext()) {
                rejectServiceConnectionInternal(it.next());
            }
            if (this.mBackgroundWorker != null) {
                Message messageObtainMessage = this.mBackgroundWorker.obtainMessage(12);
                messageObtainMessage.arg1 = 10008;
                messageObtainMessage.obj = peerAgent;
                this.mBackgroundWorker.sendMessage(messageObtainMessage);
            } else {
                SdkLog.m8382d(TAG, "handle Invalid PeerAction: mBackgroundWorker is null!");
            }
        }
    }

    void handleError(int OplusGLSurfaceView_13, PeerAgent peerAgent) {
        if (OplusGLSurfaceView_13 == 10008) {
            onServiceConnectionResponse(peerAgent, null, 10008);
            handleServiceConnectionErrorCode(10008);
            return;
        }
        switch (OplusGLSurfaceView_13) {
            case 20001:
                cleanupConnections(true);
                onError(null, "Oplus Accessory Framework has died!!", OplusGLSurfaceView_13);
                handleOnErrorCode(OplusGLSurfaceView_13);
                break;
            case 20002:
                SdkLog.m8383e(TAG, "Oplus Accessory SDK cannot be initialized");
                onError(null, "Oplus Accessory SDK cannot be initialized. Device or Build not compatible.", OplusGLSurfaceView_13);
                handleOnErrorCode(OplusGLSurfaceView_13);
                break;
            case 20003:
            case 20004:
                onError(null, "Permission error!", OplusGLSurfaceView_13);
                handleOnErrorCode(OplusGLSurfaceView_13);
                break;
            default:
                SdkLog.m8382d(TAG, "Unknown error: ".concat(String.valueOf(OplusGLSurfaceView_13)));
                break;
        }
    }

    public void cleanup() throws ExecutionException, InterruptedException {
        SdkLog.m8382d(TAG, "Performing agent cleanup");
        if (this.mAdapter != null) {
            cleanupConnections(false);
            String localAgentId = getLocalAgentId();
            if (localAgentId != null) {
                this.mAdapter.cleanupAgent(localAgentId);
            }
            this.mAdapter.unregisterAgentCallback(this.mAgentCallback);
            BaseMessage baseMessage = this.mMessage;
            if (baseMessage != null) {
                baseMessage.unregisterAgent();
            }
        }
        AgentHandler agentHandler = this.mBackgroundWorker;
        if (agentHandler != null) {
            agentHandler.getLooper().quit();
            agentHandler.f9375a = null;
            this.mBackgroundWorker = null;
        }
        sAgentsMap.remove(getClass().getName());
        synchronized (this.mLock) {
            this.mProcessingCleanup = false;
        }
    }

    private void cleanupConnections(boolean z) {
        synchronized (this.mSuccessfulConnections) {
            for (BaseSocket baseSocket : this.mSuccessfulConnections) {
                if (z) {
                    baseSocket.forceClose();
                } else {
                    baseSocket.close();
                }
            }
        }
        this.mSuccessfulConnections.clear();
        Initializer.clearSdkConfig();
    }

    public boolean runOnBackgroundThread(Runnable runnable) {
        return this.mBackgroundWorker.post(runnable);
    }

    private synchronized void fetchServiceProfile() {
        ConfigUtil c2161dM8582a = ConfigUtil.m8582a(getApplicationContext());
        if (c2161dM8582a != null) {
            this.mServiceProfile = c2161dM8582a.m8584a(getClass().getName());
            if (this.mServiceProfile == null) {
                SdkLog.m8383e(TAG, "fetch service profile description failed !!");
            }
        } else {
            SdkLog.m8383e(TAG, "config  util defualt instance  creation failed !!");
        }
    }

    class PeerAgentCallback extends IPeerAgentCallback.Stub {
        /* synthetic */ PeerAgentCallback(BaseJobAgent baseJobAgent, byte b2) {
            this();
        }

        private PeerAgentCallback() {
        }

        @Override // com.heytap.accessory.api.IPeerAgentCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8353a(Bundle bundle) throws RemoteException {
            SdkLog.m8375a(BaseJobAgent.TAG, "FindPeer response received.");
            bundle.setClassLoader(PeerAgent.class.getClassLoader());
            if (bundle.containsKey(AFConstants.EXTRA_ERROR_CODE)) {
                int OplusGLSurfaceView_13 = bundle.getInt(AFConstants.EXTRA_ERROR_CODE);
                SdkLog.m8383e(BaseJobAgent.TAG, "Peer Not Found(" + OplusGLSurfaceView_13 + ") for: " + getClass().getName());
                if (BaseJobAgent.this.mBackgroundWorker != null) {
                    Message messageObtainMessage = BaseJobAgent.this.mBackgroundWorker.obtainMessage();
                    messageObtainMessage.what = 3;
                    messageObtainMessage.arg1 = OplusGLSurfaceView_13;
                    BaseJobAgent.this.mBackgroundWorker.sendMessage(messageObtainMessage);
                    return;
                }
                SdkLog.m8382d(BaseJobAgent.TAG, "onPeersAgentsFound: mBackgroundWorker is null!");
                return;
            }
            ArrayList<PeerAgent> parcelableArrayList = bundle.getParcelableArrayList(AFConstants.EXTRA_PEER_AGENTS);
            if (parcelableArrayList == null) {
                SdkLog.m8383e(BaseJobAgent.TAG, "Find Peer - invalid response from Accessory Framework");
                return;
            }
            SdkLog.m8381c(BaseJobAgent.TAG, parcelableArrayList.size() + " Peer agent(s) found for:" + getClass().getName());
            for (PeerAgent peerAgent : parcelableArrayList) {
                SdkLog.m8381c(BaseJobAgent.TAG, "Peer ID:" + peerAgent.getAgentId() + "Container Id:" + peerAgent.getAppName() + " Accessory" + peerAgent.getAccessory().getPeerId() + " Transport:" + peerAgent.getAccessory().getTransportType());
            }
            if (BaseJobAgent.this.mBackgroundWorker != null) {
                Message messageObtainMessage2 = BaseJobAgent.this.mBackgroundWorker.obtainMessage();
                messageObtainMessage2.what = 3;
                messageObtainMessage2.arg1 = 0;
                messageObtainMessage2.obj = parcelableArrayList.toArray(new PeerAgent[0]);
                BaseJobAgent.this.mBackgroundWorker.sendMessage(messageObtainMessage2);
                return;
            }
            SdkLog.m8382d(BaseJobAgent.TAG, "onPeerAgentsFound: mBackgroundWorker is null!");
        }

        @Override // com.heytap.accessory.api.IPeerAgentCallback
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo8354b(Bundle bundle) throws RemoteException {
            SdkLog.m8375a(BaseJobAgent.TAG, "Received peer agent update");
            bundle.setClassLoader(PeerAgent.class.getClassLoader());
            if (!bundle.containsKey(AFConstants.EXTRA_PEER_AGENTS)) {
                SdkLog.m8383e(BaseJobAgent.TAG, "No peer agents in PeerAgent update callback!");
                return;
            }
            ArrayList<PeerAgent> parcelableArrayList = bundle.getParcelableArrayList(AFConstants.EXTRA_PEER_AGENTS);
            int OplusGLSurfaceView_13 = bundle.getInt(AFConstants.EXTRA_PEER_AGENT_STATUS);
            if (parcelableArrayList == null) {
                SdkLog.m8383e(BaseJobAgent.TAG, "Peer Update - invalid peer agent list from Accessory Framework");
                return;
            }
            if (OplusGLSurfaceView_13 != 105 && OplusGLSurfaceView_13 != 106) {
                SdkLog.m8383e(BaseJobAgent.TAG, "Peer Update - invalid peer status from Accessory Framework:".concat(String.valueOf(OplusGLSurfaceView_13)));
                return;
            }
            SdkLog.m8381c(BaseJobAgent.TAG, parcelableArrayList.size() + " Peer agent(s) updated for:" + getClass().getName());
            for (PeerAgent peerAgent : parcelableArrayList) {
                SdkLog.m8381c(BaseJobAgent.TAG, "Peer ID:" + peerAgent.getAgentId() + "Container Id:" + peerAgent.getAppName() + " Accessory" + peerAgent.getAccessory().getPeerId());
            }
            if (BaseJobAgent.this.mBackgroundWorker != null) {
                Message messageObtainMessage = BaseJobAgent.this.mBackgroundWorker.obtainMessage();
                messageObtainMessage.what = 4;
                if (OplusGLSurfaceView_13 == 105) {
                    messageObtainMessage.arg1 = 1;
                } else {
                    messageObtainMessage.arg1 = 2;
                }
                messageObtainMessage.obj = parcelableArrayList.toArray(new PeerAgent[0]);
                BaseJobAgent.this.mBackgroundWorker.sendMessage(messageObtainMessage);
                return;
            }
            SdkLog.m8382d(BaseJobAgent.TAG, "onPeerAgentUpdated: mBackgroundWorker is null!");
        }
    }

    static class AgentCallbackImpl implements BaseAdapter.InterfaceC2136b {

        /* renamed from: PlatformImplementations.kt_3 */
        private BaseJobAgent f9374a;

        public AgentCallbackImpl(BaseJobAgent baseJobAgent) {
            this.f9374a = baseJobAgent;
        }

        @Override // com.heytap.accessory.BaseAdapter.InterfaceC2136b
        /* renamed from: PlatformImplementations.kt_3 */
        public final void mo8349a() {
            if (this.f9374a.mBackgroundWorker != null) {
                Message messageObtainMessage = this.f9374a.mBackgroundWorker.obtainMessage(12);
                messageObtainMessage.arg1 = 20001;
                this.f9374a.mBackgroundWorker.sendMessage(messageObtainMessage);
                return;
            }
            SdkLog.m8382d(BaseJobAgent.TAG, "onFrameworkDisconnected: mBackgroundWorker is null!");
        }

        @Override // com.heytap.accessory.BaseAdapter.InterfaceC2136b
        /* renamed from: IntrinsicsJvm.kt_4 */
        public final void mo8350b() {
            try {
                this.f9374a.registerMexAgent();
            } catch (GeneralException COUIBaseListPopupWindow_8) {
                SdkLog.m8383e(BaseJobAgent.TAG, "onFrameworkConnected() - Failed to register agent with message! " + COUIBaseListPopupWindow_8.getMessage());
            }
        }

        @Override // com.heytap.accessory.BaseAdapter.InterfaceC2136b
        /* renamed from: IntrinsicsJvm.kt_3 */
        public final void mo8351c() throws GeneralException {
            this.f9374a.mBackgroundWorker.sendEmptyMessage(15);
        }
    }

    class AuthenticationCallback extends IPeerAgentAuthCallback.Stub {
        /* synthetic */ AuthenticationCallback(BaseJobAgent baseJobAgent, byte b2) {
            this();
        }

        private AuthenticationCallback() {
        }

        @Override // com.heytap.accessory.api.IPeerAgentAuthCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8352a(Bundle bundle) throws RemoteException {
            SdkLog.m8375a(BaseJobAgent.TAG, "Received Authentication response");
            if (BaseJobAgent.this.mBackgroundWorker != null) {
                Message messageObtainMessage = BaseJobAgent.this.mBackgroundWorker.obtainMessage(11);
                messageObtainMessage.setData(bundle);
                BaseJobAgent.this.mBackgroundWorker.sendMessage(messageObtainMessage);
                return;
            }
            SdkLog.m8382d(BaseJobAgent.TAG, "onPeerAgentAuthenticated: mBackgroundWorker is null!");
        }
    }

    class ConnectionCallback implements BaseSocket.InterfaceC2147a {
        /* synthetic */ ConnectionCallback(BaseJobAgent baseJobAgent, byte b2) {
            this();
        }

        private ConnectionCallback() {
        }

        @Override // com.heytap.accessory.BaseSocket.InterfaceC2147a
        /* renamed from: PlatformImplementations.kt_3 */
        public final void mo8356a(PeerAgent peerAgent, BaseSocket baseSocket) {
            BaseJobAgent.this.mSuccessfulConnections.add(baseSocket);
            SdkLog.m8381c(BaseJobAgent.TAG, "Connection success with peer:" + peerAgent.getAgentId());
            BaseJobAgent.this.onServiceConnectionResponse(peerAgent, baseSocket, 0);
            BaseJobAgent.this.handleServiceConnectionErrorCode(0);
        }

        @Override // com.heytap.accessory.BaseSocket.InterfaceC2147a
        /* renamed from: PlatformImplementations.kt_3 */
        public final void mo8355a(PeerAgent peerAgent, int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 == 20001) {
                SdkLog.m8382d(BaseJobAgent.TAG, "Framework disconnected during connection process!");
                BaseJobAgent.this.handleError(OplusGLSurfaceView_13, peerAgent);
                return;
            }
            if (BaseJobAgent.this.mBackgroundWorker != null) {
                if (OplusGLSurfaceView_13 == BaseJobAgent.CONNECTION_FAILURE_LOCAL_AGENT_NOT_FOUND) {
                    OplusGLSurfaceView_13 = 10008;
                    BaseJobAgent.this.mBackgroundWorker.sendMessage(BaseJobAgent.this.mBackgroundWorker.obtainMessage(1));
                }
                SdkLog.m8383e(BaseJobAgent.TAG, "Connection attempt failed wih peer:" + peerAgent.getAgentId() + " reason:" + OplusGLSurfaceView_13);
                Message messageObtainMessage = BaseJobAgent.this.mBackgroundWorker.obtainMessage(13);
                messageObtainMessage.arg1 = OplusGLSurfaceView_13;
                messageObtainMessage.obj = peerAgent;
                BaseJobAgent.this.mBackgroundWorker.sendMessage(messageObtainMessage);
                return;
            }
            SdkLog.m8382d(BaseJobAgent.TAG, "onConnectionFailure: mBackgroundWorker is null!");
        }
    }

    static class InstanceHandler extends Handler {
        public InstanceHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int OplusGLSurfaceView_13 = message.what;
            if (OplusGLSurfaceView_13 != 1) {
                if (OplusGLSurfaceView_13 != 2) {
                    return;
                }
                BaseJobAgent baseJobAgent = (BaseJobAgent) message.obj;
                if (BaseJobAgent.sAgentsMap.get(baseJobAgent.getClass().getName()) == baseJobAgent) {
                    baseJobAgent.destroy();
                    return;
                } else {
                    SdkLog.m8382d(BaseJobAgent.TAG, "Stale agent entry. Agent already destroyed. Ignoring...");
                    return;
                }
            }
            InstanceCreator instanceCreator = (InstanceCreator) message.obj;
            Context context = instanceCreator.f9378a;
            String str = instanceCreator.f9379b;
            RequestAgentCallback requestAgentCallback = instanceCreator.f9380c;
            SdkLog.m8378b(BaseJobAgent.TAG, "CREATE_AGENT: ".concat(String.valueOf(str)));
            int i2 = message.arg1;
            BaseJobAgent baseJobAgent2 = (BaseJobAgent) BaseJobAgent.sAgentsMap.get(str);
            if (baseJobAgent2 != null) {
                SdkLog.m8378b(BaseJobAgent.TAG, "CREATE_AGENT, but sAgentMap already exist");
                if (!baseJobAgent2.isProcessingCleanup()) {
                    if (requestAgentCallback != null) {
                        requestAgentCallback.onAgentAvailable(baseJobAgent2);
                        return;
                    }
                    return;
                } else {
                    if (i2 == 4) {
                        requestAgentCallback.onError(BaseJobAgent.ERROR_AGENT_REQUEST_IN_PROGRESS, "Class could not be initialized: " + str + ". Error occurred while releasing agent.");
                        return;
                    }
                    Message messageObtainMessage = obtainMessage(1);
                    messageObtainMessage.arg1 = i2 + 1;
                    messageObtainMessage.obj = instanceCreator;
                    sendMessageDelayed(messageObtainMessage, BaseJobAgent.CLEANUP_WAIT_TIME);
                    return;
                }
            }
            BaseJobAgent.INSTANCE_LOCK.lock();
            SdkLog.m8378b(BaseJobAgent.TAG, "CREATE_AGENT, create it by reflection: ".concat(String.valueOf(str)));
            try {
                try {
                    try {
                        try {
                            try {
                                try {
                                    Constructor<?> declaredConstructor = Class.forName(str).getDeclaredConstructor(Context.class);
                                    declaredConstructor.setAccessible(true);
                                    declaredConstructor.newInstance(context);
                                    BaseJobAgent.INSTANCE_LOCK.unlock();
                                    BaseJobAgent baseJobAgent3 = (BaseJobAgent) BaseJobAgent.sAgentsMap.get(str);
                                    if (baseJobAgent3 != null) {
                                        if (requestAgentCallback != null) {
                                            requestAgentCallback.onAgentAvailable(baseJobAgent3);
                                        }
                                    } else {
                                        requestAgentCallback.onError(BaseJobAgent.ERROR_CONSTRUCTOR_EXCEPTION, "Class could not be initialized: " + str + ". Call super inside constructor.");
                                    }
                                } catch (IllegalArgumentException COUIBaseListPopupWindow_8) {
                                    COUIBaseListPopupWindow_8.printStackTrace();
                                    requestAgentCallback.onError(BaseJobAgent.ERROR_CONSTRUCTOR_EXCEPTION, "Class instantiation error: " + str + ". Invalid context passed.");
                                    BaseJobAgent.INSTANCE_LOCK.unlock();
                                }
                            } catch (NoSuchMethodException e2) {
                                e2.printStackTrace();
                                requestAgentCallback.onError(2562, "Constructor with Context argument not found: ".concat(String.valueOf(str)));
                                BaseJobAgent.INSTANCE_LOCK.unlock();
                            }
                        } catch (ClassNotFoundException e3) {
                            e3.printStackTrace();
                            requestAgentCallback.onError(2561, "Class not found: ".concat(String.valueOf(str)));
                            BaseJobAgent.INSTANCE_LOCK.unlock();
                        }
                    } catch (InstantiationException e4) {
                        e4.printStackTrace();
                        requestAgentCallback.onError(BaseJobAgent.ERROR_CONSTRUCTOR_EXCEPTION, "Class instantiation error: ".concat(String.valueOf(str)));
                        BaseJobAgent.INSTANCE_LOCK.unlock();
                    }
                } catch (IllegalAccessException e5) {
                    e5.printStackTrace();
                    requestAgentCallback.onError(BaseJobAgent.ERROR_CONSTRUCTOR_EXCEPTION, "Class constructor not accessible: ".concat(String.valueOf(str)));
                    BaseJobAgent.INSTANCE_LOCK.unlock();
                } catch (InvocationTargetException e6) {
                    e6.printStackTrace();
                    requestAgentCallback.onError(BaseJobAgent.ERROR_CONSTRUCTOR_EXCEPTION, "Exception occurred while calling constructor of class: ".concat(String.valueOf(str)));
                    BaseJobAgent.INSTANCE_LOCK.unlock();
                }
            } catch (Throwable th) {
                BaseJobAgent.INSTANCE_LOCK.unlock();
                throw th;
            }
        }
    }

    static class InstanceCreator {

        /* renamed from: PlatformImplementations.kt_3 */
        private Context f9378a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private String f9379b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private RequestAgentCallback f9380c;

        public InstanceCreator(Context context, String str, RequestAgentCallback requestAgentCallback) {
            this.f9378a = context;
            this.f9379b = str;
            this.f9380c = requestAgentCallback;
        }
    }

    static class AgentHandler extends Handler {

        /* renamed from: PlatformImplementations.kt_3 */
        BaseJobAgent f9375a;

        public AgentHandler(BaseJobAgent baseJobAgent, Looper looper) {
            super(looper);
            this.f9375a = baseJobAgent;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws ExecutionException, InterruptedException {
            if (this.f9375a.mAdapter != null) {
                switch (message.what) {
                    case 0:
                        try {
                            this.f9375a.bindToFramework();
                            break;
                        } catch (GeneralException COUIBaseListPopupWindow_8) {
                            SdkLog.m8379b(BaseJobAgent.TAG, "Binding to Accessory Framework failed", COUIBaseListPopupWindow_8);
                            this.f9375a.handleError(COUIBaseListPopupWindow_8.getErrorCode(), null);
                            return;
                        }
                    case 1:
                        this.f9375a.registerService();
                        break;
                    case 2:
                        this.f9375a.requestPeerAgents();
                        break;
                    case 3:
                        int OplusGLSurfaceView_13 = message.arg1;
                        if (OplusGLSurfaceView_13 != 0) {
                            this.f9375a.handleFindPeerErrorCode(message.arg1);
                            this.f9375a.onFindPeerAgentsResponse(null, message.arg1);
                            break;
                        } else {
                            BaseJobAgent baseJobAgent = this.f9375a;
                            if (!(baseJobAgent instanceof NativeAgent)) {
                                baseJobAgent.handleFindPeerErrorCode(0);
                                this.f9375a.onFindPeerAgentsResponse((PeerAgent[]) message.obj, 0);
                                break;
                            } else {
                                ((NativeAgent) baseJobAgent).m8368a(OplusGLSurfaceView_13, Arrays.asList((PeerAgent[]) message.obj));
                                break;
                            }
                        }
                    case 4:
                        this.f9375a.onPeerAgentsUpdated((PeerAgent[]) message.obj, message.arg1);
                        this.f9375a.handlePeerAgentUpdateErrorCode(message.arg1);
                        break;
                    case 5:
                        this.f9375a.notifyConnectionRequest((Intent) message.obj);
                        break;
                    case 6:
                        SdkLog.m8378b(BaseJobAgent.TAG, "MESSAGE_CONNECTION_INDICATION_JOB");
                        IJobListener iJobListener = (IJobListener) message.obj;
                        JobParameters jobParameters = (JobParameters) message.getData().get(AFConstants.EXTRA_PARAMS);
                        this.f9375a.notifyConnectionRequest(jobParameters.getExtras());
                        iJobListener.onJobFinished(jobParameters);
                        break;
                    case 7:
                        this.f9375a.requestConnection((PeerAgent) message.obj);
                        break;
                    case 8:
                        this.f9375a.acceptServiceConnectionInternal((PeerAgent) message.obj);
                        break;
                    case 9:
                        this.f9375a.rejectServiceConnectionInternal((PeerAgent) message.obj);
                        break;
                    case 10:
                        this.f9375a.requestPeerAuthInternal((PeerAgent) message.obj);
                        break;
                    case 11:
                        this.f9375a.handleAuthResponse(message.getData());
                        break;
                    case 12:
                        this.f9375a.handleError(message.arg1, message.obj instanceof PeerAgent ? (PeerAgent) message.obj : null);
                        break;
                    case 13:
                        this.f9375a.onServiceConnectionResponse(message.obj instanceof PeerAgent ? (PeerAgent) message.obj : null, null, message.arg1);
                        this.f9375a.handleServiceConnectionErrorCode(message.arg1);
                        break;
                    case 14:
                        this.f9375a.cleanup();
                        break;
                    case 15:
                        try {
                            this.f9375a.loadAgentId();
                            break;
                        } catch (GeneralException e2) {
                            SdkLog.m8379b(BaseJobAgent.TAG, "Retrieving agent id_renamed failed", e2);
                            this.f9375a.handleError(e2.getErrorCode(), null);
                            return;
                        }
                    default:
                        SdkLog.m8382d(BaseJobAgent.TAG, "Invalid msg received: " + message.what);
                        break;
                }
            }
            SdkLog.m8382d(BaseJobAgent.TAG, "BaseApdater is null, return!");
        }
    }
}
