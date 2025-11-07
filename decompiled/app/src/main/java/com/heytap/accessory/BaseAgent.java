package com.heytap.accessory;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
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
import com.heytap.accessory.p104b.p105a.BufferPool;
import java.lang.Thread;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* loaded from: classes2.dex */
public abstract class BaseAgent extends Service {
    public static final int AUTHENTICATION_FAILURE_PEER_AGENT_NOT_SUPPORTED = 10015;
    public static final int AUTHENTICATION_FAILURE_TOKEN_NOT_GENERATED = 10014;
    public static final int AUTHENTICATION_SUCCESS = 0;
    public static final int CONNECTION_ALREADY_EXIST = 10005;
    public static final int CONNECTION_DUPLICATE_REQUEST = 10009;
    public static final int CONNECTION_FAILURE_ACC_DORMANT = 10018;
    public static final int CONNECTION_FAILURE_CHANNELID_MISMATCH = 10011;
    public static final int CONNECTION_FAILURE_DEVICE_UNREACHABLE = 10004;
    public static final int CONNECTION_FAILURE_INVALID_PEERAGENT = 10008;
    public static final int CONNECTION_FAILURE_LOCAL_AGENT_NOT_FOUND = 10017;
    public static final int CONNECTION_FAILURE_NETWORK = 10012;
    public static final int CONNECTION_FAILURE_PEERAGENT_NO_RESPONSE = 10006;
    public static final int CONNECTION_FAILURE_PEERAGENT_REJECTED = 10007;
    public static final int CONNECTION_FAILURE_SERVICE_LIMIT_REACHED = 10010;
    public static final int CONNECTION_SUCCESS = 0;
    private static final int DEFAULT_GET_AGENT_ID_RETRY_COUNT = 2;
    public static final int ERROR_CONNECTION_INVALID_PARAM = 10013;
    public static final int ERROR_FATAL = 20001;
    public static final int ERROR_PERMISSION_DENIED = 20003;
    public static final int ERROR_PERMISSION_FAILED = 20004;
    public static final int ERROR_SDK_NOT_INITIALIZED = 20002;
    public static final int FIND_PEER_DEVICE_NOT_CONNECTED = 10001;
    public static final int FIND_PEER_DUPLICATE_REQUEST = 10003;
    public static final int FIND_PEER_SERVICE_NOT_FOUND = 10002;
    public static final int FIND_PEER_TIMEOUT = 10010;
    public static final int ON_PEER_INSTALLED = 0;
    public static final int ON_PEER_UNINSTALLED = 1;
    public static final int PEER_AGENT_AVAILABLE = 1;
    public static final int PEER_AGENT_FOUND = 0;
    public static final int PEER_AGENT_UNAVAILABLE = 2;
    public static final int SERVICE_RECORD_NOT_FOUND = 10016;
    private static final String TAG = "BaseAgent";
    BaseAdapter mAdapter;
    private C2138a mAgentCallback;
    private String mAgentId;
    HandlerC2139b mBackgroundWorker;
    private C2140c mConnectionCallback;
    private BaseMessage mMessage;
    private String mName;
    private PeerAgentCallback mPeerAgentCallback;
    private AuthenticationCallback mPeerAuthCallback;
    private Set<PeerAgent> mPendingRequests;
    private Class<? extends BaseSocket> mSocketImpl;
    private List<BaseSocket> mSuccessfulConnections;
    private ServiceProfile mServiceProfile = null;
    private int mGetAgentIdRetryCount = 0;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        try {
            new SdkConfig(getApplicationContext());
        } catch (GeneralException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        SdkLog.m8378b(TAG, "BaseAgent - onCreate:" + getClass().getSimpleName());
        this.mSuccessfulConnections = Collections.synchronizedList(new ArrayList());
        this.mPendingRequests = Collections.synchronizedSet(new HashSet());
        HandlerThread handlerThread = new HandlerThread(this.mName);
        handlerThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.heytap.accessory.BaseAgent.1
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public final void uncaughtException(Thread thread, final Throwable th) {
                SdkLog.m8379b(BaseAgent.TAG, "Exception in background thread:" + thread.getName(), th);
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.heytap.accessory.BaseAgent.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
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
        this.mBackgroundWorker = new HandlerC2139b(this, looper);
        try {
            Initializer.initBufferPool(getApplicationContext());
        } catch (SdkUnsupportedException e2) {
            SdkLog.m8379b(TAG, "SDK initialization failed!", e2);
            Message messageObtainMessage = this.mBackgroundWorker.obtainMessage(11);
            messageObtainMessage.arg1 = 20002;
            this.mBackgroundWorker.sendMessage(messageObtainMessage);
        }
        this.mAdapter = BaseAdapter.getDefaultAdapter(getApplicationContext(), this.mBackgroundWorker);
        byte b2 = 0;
        this.mPeerAuthCallback = new AuthenticationCallback(this, b2);
        this.mPeerAgentCallback = new PeerAgentCallback(this, b2);
        this.mConnectionCallback = new C2140c(this, b2);
        this.mAgentCallback = new C2138a(this);
        this.mBackgroundWorker.sendEmptyMessage(0);
        fetchServiceProfile();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int OplusGLSurfaceView_13, int i2) {
        String action;
        if (intent == null || (action = intent.getAction()) == null) {
            return 2;
        }
        if ("com.heytap.accessory.action.SERVICE_CONNECTION_REQUESTED".equalsIgnoreCase(action)) {
            SdkLog.m8378b(TAG, "Received incoming connection request");
            HandlerC2139b handlerC2139b = this.mBackgroundWorker;
            if (handlerC2139b != null) {
                Message messageObtainMessage = handlerC2139b.obtainMessage();
                messageObtainMessage.what = 5;
                messageObtainMessage.arg1 = i2;
                messageObtainMessage.obj = intent;
                this.mBackgroundWorker.sendMessage(messageObtainMessage);
                return 2;
            }
            SdkLog.m8382d(TAG, "onStartCommand: mBackgroundWorker is null!");
            return 2;
        }
        if (BaseAdapter.ACTION_ACCESSORY_STATUS_CHANGED.equalsIgnoreCase(action)) {
            SdkLog.m8378b(TAG, "Received accessory status changed");
            HandlerC2139b handlerC2139b2 = this.mBackgroundWorker;
            if (handlerC2139b2 != null) {
                Message messageObtainMessage2 = handlerC2139b2.obtainMessage();
                messageObtainMessage2.what = 15;
                messageObtainMessage2.arg1 = i2;
                messageObtainMessage2.obj = intent;
                this.mBackgroundWorker.sendMessage(messageObtainMessage2);
                return 2;
            }
            SdkLog.m8382d(TAG, "onStartCommand: mBackgroundWorker is null!");
            return 2;
        }
        if (!BaseMessage.ACTION_ACCESSORY_MESSAGE_RECEIVED.equalsIgnoreCase(action)) {
            return 2;
        }
        SdkLog.m8378b(TAG, "Received incoming message ind");
        return 2;
    }

    @Override // android.app.Service
    public void onDestroy() {
        SdkLog.m8378b(TAG, "BaseAgent - onDestroy:" + getClass().getSimpleName());
        HandlerC2139b handlerC2139b = this.mBackgroundWorker;
        if (handlerC2139b != null) {
            handlerC2139b.obtainMessage(13).sendToTarget();
        }
        super.onDestroy();
    }

    @Override // android.app.Service, android.content.ComponentCallbacks2
    public void onTrimMemory(int OplusGLSurfaceView_13) {
        BufferPool.m8543b(OplusGLSurfaceView_13);
        super.onTrimMemory(OplusGLSurfaceView_13);
    }

    protected BaseAgent(String str, Class<? extends BaseSocket> cls) throws NoSuchMethodException, SecurityException {
        if (str != null && !"".equalsIgnoreCase(str)) {
            validateSocketImplementation(cls);
            this.mName = str;
            this.mSocketImpl = cls;
            SdkLog.m8378b(TAG, "Thread Name:" + this.mName + "BaseSocket Imple class:" + cls.getName());
            return;
        }
        throw new IllegalArgumentException("Invalid parameter name:".concat(String.valueOf(str)));
    }

    protected BaseAgent(String str) {
        if (str != null && !"".equalsIgnoreCase(str)) {
            this.mName = str;
            return;
        }
        throw new IllegalArgumentException("Invalid parameter name:".concat(String.valueOf(str)));
    }

    protected void onFindPeerAgentsResponse(PeerAgent[] peerAgentArr, int OplusGLSurfaceView_13) {
        SdkLog.m8383e(TAG, "Invalid implementation of BaseAgent.onFindPeerAgentsResponse(PeerAgent[], int) should be overrided!");
    }

    protected void onPeerAgentsUpdated(PeerAgent[] peerAgentArr, int OplusGLSurfaceView_13) {
        SdkLog.m8383e(TAG, "Invalid implementation of BaseAgent.onPeerAgentsUpdated(PeerAgent[], int) should be overrided!");
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
            SdkLog.m8383e(TAG, "exception: " + COUIBaseListPopupWindow_8.getMessage());
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
            HandlerC2139b handlerC2139b = this.mBackgroundWorker;
            if (handlerC2139b != null) {
                Message messageObtainMessage = handlerC2139b.obtainMessage(6);
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
                HandlerC2139b handlerC2139b = this.mBackgroundWorker;
                if (handlerC2139b != null) {
                    Message messageObtainMessage = handlerC2139b.obtainMessage(7);
                    messageObtainMessage.obj = peerAgent;
                    this.mBackgroundWorker.sendMessage(messageObtainMessage);
                    return;
                }
                SdkLog.m8382d(TAG, "acceptServiceConnection: mBackgroundWorker is null!");
                return;
            }
            SdkLog.m8382d(TAG, "Accepting service connection with invalid peer agent:" + peerAgent.toString());
            handleInvalidPeerAction(peerAgent);
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
                HandlerC2139b handlerC2139b = this.mBackgroundWorker;
                if (handlerC2139b != null) {
                    Message messageObtainMessage = handlerC2139b.obtainMessage(8);
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
            HandlerC2139b handlerC2139b = this.mBackgroundWorker;
            if (handlerC2139b != null) {
                Message messageObtainMessage = handlerC2139b.obtainMessage(9);
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
            sharedPreferences = createDeviceProtectedStorageContext().getSharedPreferences("AccessoryPreferences", 0);
        } else {
            sharedPreferences = getApplicationContext().getSharedPreferences("AccessoryPreferences", 0);
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString(localAgentId, getClass().getName());
        editorEdit.putString(getClass().getName(), localAgentId);
        SdkLog.m8378b(TAG, "save AgentId className:" + getClass().getName() + ",agentId: " + localAgentId);
        editorEdit.apply();
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
            throw new IllegalArgumentException("Invalid socketClass param:".concat(String.valueOf(cls)));
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
    }

    private void handleAuthErrorCode(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 0) {
            SdkLog.m8381c(TAG, "onAuthenticationResponse() -> AUTHENTICATION_SUCCESS");
            return;
        }
        if (OplusGLSurfaceView_13 == 10014) {
            SdkLog.m8381c(TAG, "onAuthenticationResponse() -> AUTHENTICATION_FAILURE_TOKEN_NOT_GENERATED");
        } else if (OplusGLSurfaceView_13 == 10015) {
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
        if (OplusGLSurfaceView_13 == 10012) {
            SdkLog.m8381c(TAG, "onServiceConnectionResponse() -> CONNECTION_FAILURE_NETWORK");
            return;
        }
        if (OplusGLSurfaceView_13 != 10018) {
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
        SdkLog.m8381c(TAG, "onServiceConnectionResponse() -> CONNECTION_FAILURE_ACC_DORMANT");
    }

    private void handleOnErrorCode(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 10013) {
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
                SdkLog.m8382d(TAG, "Service record was not found in Accessory Framework.Registering service again!");
                this.mGetAgentIdRetryCount++;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyConnectionRequest(Intent intent) {
        if (intent == null) {
            SdkLog.m8383e(TAG, "Invalid service connection indication.Intent:null.Ignoring reqeuset");
            return;
        }
        long longExtra = intent.getLongExtra("transactionId", 0L);
        PeerAgent peerAgent = (PeerAgent) intent.getParcelableExtra(AFConstants.EXTRA_PEER_AGENT);
        String stringExtra = intent.getStringExtra(AFConstants.EXTRA_AGENT_ID);
        if (peerAgent == null) {
            SdkLog.m8383e(TAG, "Invalid initiator peer agent:" + peerAgent + ". Ignoring connection request");
            return;
        }
        if (stringExtra == null) {
            SdkLog.m8383e(TAG, "Invalid local agent Id:" + stringExtra + ".Ignoring connection request");
            return;
        }
        peerAgent.setTransactionId(longExtra);
        SdkLog.m8381c(TAG, "Connection initiated by peer: " + peerAgent.getAgentId() + " on Accessory: " + peerAgent.getAccessory().getPeerId() + " Transaction: " + longExtra);
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
            if (!Modifier.toString(this.mSocketImpl.getModifiers()).contains("static") && this.mSocketImpl.getEnclosingClass() != null && BaseAgent.class.isAssignableFrom(this.mSocketImpl.getEnclosingClass())) {
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

    public int getVersion() {
        try {
            if (this.mAdapter != null) {
                return this.mAdapter.getVersion();
            }
            return 0;
        } catch (GeneralException COUIBaseListPopupWindow_8) {
            SdkLog.m8383e(TAG, "getVersion error ".concat(String.valueOf(COUIBaseListPopupWindow_8)));
            return 0;
        }
    }

    public int checkAuthentication() {
        try {
            return this.mAdapter != null ? this.mAdapter.checkAuthentication() : CommonStatusCodes.INTERNAL_EXCEPTION;
        } catch (GeneralException COUIBaseListPopupWindow_8) {
            SdkLog.m8383e(TAG, "check authentication error ".concat(String.valueOf(COUIBaseListPopupWindow_8)));
            return CommonStatusCodes.INTERNAL_EXCEPTION;
        }
    }

    public boolean checkAuthentication(String str) {
        try {
            return this.mAdapter.checkAuthentication(str);
        } catch (GeneralException COUIBaseListPopupWindow_8) {
            SdkLog.m8383e(TAG, "check authentication method error ".concat(String.valueOf(COUIBaseListPopupWindow_8)));
            return false;
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
            i2 = 10014;
            SdkLog.m8383e(TAG, "Authentication failed error:10014 Peer Id:" + peerAgent.getAgentId());
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
                Message messageObtainMessage = this.mBackgroundWorker.obtainMessage(11);
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
                onError(null, "Accessory Framework has died!!", OplusGLSurfaceView_13);
                handleOnErrorCode(OplusGLSurfaceView_13);
                break;
            case 20002:
                SdkLog.m8383e(TAG, "Accessory SDK cannot be initialized");
                onError(null, "Accessory SDK cannot be initialized. Device or Build not compatible.", OplusGLSurfaceView_13);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void cleanup() throws ExecutionException, InterruptedException {
        SdkLog.m8382d(TAG, "Performing agent cleanup");
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
        HandlerC2139b handlerC2139b = this.mBackgroundWorker;
        if (handlerC2139b != null) {
            handlerC2139b.getLooper().quit();
            handlerC2139b.f9369a = null;
            this.mBackgroundWorker = null;
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
        HandlerC2139b handlerC2139b = this.mBackgroundWorker;
        if (handlerC2139b != null) {
            return handlerC2139b.post(runnable);
        }
        SdkLog.m8382d(TAG, "runOnBackgroundThread: mBackgroundWorker is null!");
        return false;
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

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void handleAccessoryStatusChanged(Intent intent) {
        intent.getIntExtra("accessoryStatus", 0);
        intent.getParcelableExtra(AFConstants.EXTRA_PEER_AGENT);
    }

    class PeerAgentCallback extends IPeerAgentCallback.Stub {
        /* synthetic */ PeerAgentCallback(BaseAgent baseAgent, byte b2) {
            this();
        }

        private PeerAgentCallback() {
        }

        @Override // com.heytap.accessory.api.IPeerAgentCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8353a(Bundle bundle) {
            SdkLog.m8375a(BaseAgent.TAG, "FindPeer response received.");
            bundle.setClassLoader(PeerAgent.class.getClassLoader());
            if (bundle.containsKey(AFConstants.EXTRA_ERROR_CODE)) {
                int OplusGLSurfaceView_13 = bundle.getInt(AFConstants.EXTRA_ERROR_CODE);
                SdkLog.m8383e(BaseAgent.TAG, "Peer Not Found(" + OplusGLSurfaceView_13 + ") for: " + getClass().getName());
                if (BaseAgent.this.mBackgroundWorker == null) {
                    SdkLog.m8382d(BaseAgent.TAG, "onPeersAgentsFound: mBackgroundWorker is null!");
                    return;
                }
                Message messageObtainMessage = BaseAgent.this.mBackgroundWorker.obtainMessage();
                messageObtainMessage.what = 3;
                messageObtainMessage.arg1 = OplusGLSurfaceView_13;
                BaseAgent.this.mBackgroundWorker.sendMessage(messageObtainMessage);
                return;
            }
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(AFConstants.EXTRA_PEER_AGENTS);
            if (parcelableArrayList == null) {
                SdkLog.m8383e(BaseAgent.TAG, "Find Peer - invalid response from Accessory Framework");
                return;
            }
            SdkLog.m8381c(BaseAgent.TAG, parcelableArrayList.size() + " Peer agent(s) found for:" + getClass().getName());
            SdkLog.m8381c(BaseAgent.TAG, "Peer agent(s) ".concat(String.valueOf(parcelableArrayList)));
            if (BaseAgent.this.mBackgroundWorker == null) {
                SdkLog.m8382d(BaseAgent.TAG, "onPeerAgentsFound: mBackgroundWorker is null!");
                return;
            }
            Message messageObtainMessage2 = BaseAgent.this.mBackgroundWorker.obtainMessage();
            messageObtainMessage2.what = 3;
            messageObtainMessage2.arg1 = 0;
            messageObtainMessage2.obj = parcelableArrayList.toArray(new PeerAgent[parcelableArrayList.size()]);
            BaseAgent.this.mBackgroundWorker.sendMessage(messageObtainMessage2);
        }

        @Override // com.heytap.accessory.api.IPeerAgentCallback
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo8354b(Bundle bundle) {
            SdkLog.m8375a(BaseAgent.TAG, "Received peer agent update");
            bundle.setClassLoader(PeerAgent.class.getClassLoader());
            if (!bundle.containsKey(AFConstants.EXTRA_PEER_AGENTS)) {
                SdkLog.m8383e(BaseAgent.TAG, "No peer agents in PeerAgent update callback!");
                return;
            }
            ArrayList<PeerAgent> parcelableArrayList = bundle.getParcelableArrayList(AFConstants.EXTRA_PEER_AGENTS);
            int OplusGLSurfaceView_13 = bundle.getInt(AFConstants.EXTRA_PEER_AGENT_STATUS);
            if (parcelableArrayList == null) {
                SdkLog.m8383e(BaseAgent.TAG, "Peer Update - invalid peer agent list from Accessory Framework");
                return;
            }
            if (OplusGLSurfaceView_13 == 0 || OplusGLSurfaceView_13 == 1) {
                SdkLog.m8381c(BaseAgent.TAG, parcelableArrayList.size() + " Peer agent(s) updated for:" + getClass().getName());
                for (PeerAgent peerAgent : parcelableArrayList) {
                    SdkLog.m8381c(BaseAgent.TAG, "Peer ID:" + peerAgent.getAgentId() + "Container Id:" + peerAgent.getAppName() + " Accessory" + peerAgent.getAccessory().getPeerId());
                }
                if (BaseAgent.this.mBackgroundWorker == null) {
                    SdkLog.m8382d(BaseAgent.TAG, "onPeerAgentUpdated: mBackgroundWorker is null!");
                    return;
                }
                Message messageObtainMessage = BaseAgent.this.mBackgroundWorker.obtainMessage();
                messageObtainMessage.what = 4;
                if (OplusGLSurfaceView_13 == 0) {
                    messageObtainMessage.arg1 = 1;
                } else {
                    messageObtainMessage.arg1 = 2;
                }
                messageObtainMessage.obj = parcelableArrayList.toArray(new PeerAgent[0]);
                BaseAgent.this.mBackgroundWorker.sendMessage(messageObtainMessage);
                return;
            }
            SdkLog.m8383e(BaseAgent.TAG, "Peer Update - invalid peer status from Accessory Framework:".concat(String.valueOf(OplusGLSurfaceView_13)));
        }
    }

    /* renamed from: com.heytap.accessory.BaseAgent$PlatformImplementations.kt_3 */
    static class C2138a implements BaseAdapter.InterfaceC2136b {

        /* renamed from: PlatformImplementations.kt_3 */
        private BaseAgent f9368a;

        public C2138a(BaseAgent baseAgent) {
            this.f9368a = baseAgent;
        }

        @Override // com.heytap.accessory.BaseAdapter.InterfaceC2136b
        /* renamed from: PlatformImplementations.kt_3 */
        public final void mo8349a() {
            if (this.f9368a.mBackgroundWorker == null) {
                SdkLog.m8382d(BaseAgent.TAG, "onFrameworkDisconnected: mBackgroundWorker is null!");
                return;
            }
            Message messageObtainMessage = this.f9368a.mBackgroundWorker.obtainMessage(11);
            messageObtainMessage.arg1 = 20001;
            this.f9368a.mBackgroundWorker.sendMessage(messageObtainMessage);
        }

        @Override // com.heytap.accessory.BaseAdapter.InterfaceC2136b
        /* renamed from: IntrinsicsJvm.kt_4 */
        public final void mo8350b() {
            try {
                this.f9368a.registerMexAgent();
            } catch (GeneralException COUIBaseListPopupWindow_8) {
                SdkLog.m8383e(BaseAgent.TAG, "onFrameworkConnected() - Failed to register agent with message! " + COUIBaseListPopupWindow_8.getMessage());
            }
        }

        @Override // com.heytap.accessory.BaseAdapter.InterfaceC2136b
        /* renamed from: IntrinsicsJvm.kt_3 */
        public final void mo8351c() throws GeneralException {
            if (this.f9368a.mBackgroundWorker == null) {
                SdkLog.m8382d(BaseAgent.TAG, "onAgentRegistered: mBackgroundWorker is null!");
            } else {
                this.f9368a.mBackgroundWorker.sendEmptyMessage(14);
            }
        }
    }

    class AuthenticationCallback extends IPeerAgentAuthCallback.Stub {
        /* synthetic */ AuthenticationCallback(BaseAgent baseAgent, byte b2) {
            this();
        }

        private AuthenticationCallback() {
        }

        @Override // com.heytap.accessory.api.IPeerAgentAuthCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8352a(Bundle bundle) throws RemoteException {
            SdkLog.m8375a(BaseAgent.TAG, "Received Authentication response");
            if (BaseAgent.this.mBackgroundWorker == null) {
                SdkLog.m8382d(BaseAgent.TAG, "onPeerAgentAuthenticated: mBackgroundWorker is null!");
                return;
            }
            Message messageObtainMessage = BaseAgent.this.mBackgroundWorker.obtainMessage(10);
            messageObtainMessage.setData(bundle);
            BaseAgent.this.mBackgroundWorker.sendMessage(messageObtainMessage);
        }
    }

    /* renamed from: com.heytap.accessory.BaseAgent$IntrinsicsJvm.kt_3 */
    class C2140c implements BaseSocket.InterfaceC2147a {
        /* synthetic */ C2140c(BaseAgent baseAgent, byte b2) {
            this();
        }

        private C2140c() {
        }

        @Override // com.heytap.accessory.BaseSocket.InterfaceC2147a
        /* renamed from: PlatformImplementations.kt_3 */
        public final void mo8356a(PeerAgent peerAgent, BaseSocket baseSocket) {
            BaseAgent.this.mSuccessfulConnections.add(baseSocket);
            SdkLog.m8378b(BaseAgent.TAG, "Connection success with peer:" + peerAgent.getAgentId());
            BaseAgent.this.onServiceConnectionResponse(peerAgent, baseSocket, 0);
            BaseAgent.this.handleServiceConnectionErrorCode(0);
        }

        @Override // com.heytap.accessory.BaseSocket.InterfaceC2147a
        /* renamed from: PlatformImplementations.kt_3 */
        public final void mo8355a(PeerAgent peerAgent, int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 == 20001) {
                SdkLog.m8382d(BaseAgent.TAG, "Framework disconnected during connection process!");
                BaseAgent.this.handleError(OplusGLSurfaceView_13, peerAgent);
                return;
            }
            if (BaseAgent.this.mBackgroundWorker != null) {
                if (OplusGLSurfaceView_13 == 10017) {
                    OplusGLSurfaceView_13 = 10008;
                    BaseAgent.this.mBackgroundWorker.sendMessage(BaseAgent.this.mBackgroundWorker.obtainMessage(1));
                }
                SdkLog.m8383e(BaseAgent.TAG, "Connection attempt failed wih peer:" + peerAgent.getAgentId() + " reason:" + OplusGLSurfaceView_13);
                Message messageObtainMessage = BaseAgent.this.mBackgroundWorker.obtainMessage(12);
                messageObtainMessage.arg1 = OplusGLSurfaceView_13;
                messageObtainMessage.obj = peerAgent;
                BaseAgent.this.mBackgroundWorker.sendMessage(messageObtainMessage);
                return;
            }
            SdkLog.m8382d(BaseAgent.TAG, "onConnectionFailure: mBackgroundWorker is null!");
        }
    }

    /* renamed from: com.heytap.accessory.BaseAgent$IntrinsicsJvm.kt_4 */
    static class HandlerC2139b extends Handler {

        /* renamed from: PlatformImplementations.kt_3 */
        BaseAgent f9369a;

        public HandlerC2139b(BaseAgent baseAgent, Looper looper) {
            super(looper);
            this.f9369a = baseAgent;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) throws ExecutionException, InterruptedException {
            switch (message.what) {
                case 0:
                    try {
                        this.f9369a.bindToFramework();
                        break;
                    } catch (GeneralException COUIBaseListPopupWindow_8) {
                        SdkLog.m8379b(BaseAgent.TAG, "Binding to Accessory Framework failed", COUIBaseListPopupWindow_8);
                        this.f9369a.handleError(COUIBaseListPopupWindow_8.getErrorCode(), null);
                        return;
                    }
                case 1:
                    this.f9369a.registerService();
                    break;
                case 2:
                    this.f9369a.requestPeerAgents();
                    break;
                case 3:
                    if (message.arg1 == 0) {
                        this.f9369a.onFindPeerAgentsResponse((PeerAgent[]) message.obj, 0);
                        this.f9369a.handleFindPeerErrorCode(0);
                        break;
                    } else {
                        this.f9369a.onFindPeerAgentsResponse(null, message.arg1);
                        this.f9369a.handleFindPeerErrorCode(message.arg1);
                        break;
                    }
                case 4:
                    this.f9369a.onPeerAgentsUpdated((PeerAgent[]) message.obj, message.arg1);
                    this.f9369a.handlePeerAgentUpdateErrorCode(message.arg1);
                    break;
                case 5:
                    this.f9369a.notifyConnectionRequest((Intent) message.obj);
                    break;
                case 6:
                    this.f9369a.requestConnection((PeerAgent) message.obj);
                    break;
                case 7:
                    this.f9369a.acceptServiceConnectionInternal((PeerAgent) message.obj);
                    break;
                case 8:
                    this.f9369a.rejectServiceConnectionInternal((PeerAgent) message.obj);
                    break;
                case 9:
                    this.f9369a.requestPeerAuthInternal((PeerAgent) message.obj);
                    break;
                case 10:
                    this.f9369a.handleAuthResponse(message.getData());
                    break;
                case 11:
                    this.f9369a.handleError(message.arg1, message.obj instanceof PeerAgent ? (PeerAgent) message.obj : null);
                    break;
                case 12:
                    this.f9369a.onServiceConnectionResponse(message.obj instanceof PeerAgent ? (PeerAgent) message.obj : null, null, message.arg1);
                    this.f9369a.handleServiceConnectionErrorCode(message.arg1);
                    break;
                case 13:
                    this.f9369a.cleanup();
                    break;
                case 14:
                    try {
                        this.f9369a.loadAgentId();
                        break;
                    } catch (GeneralException e2) {
                        SdkLog.m8379b(BaseAgent.TAG, "Retrieving agent id_renamed failed", e2);
                        this.f9369a.handleError(e2.getErrorCode(), null);
                        return;
                    }
                case 15:
                    this.f9369a.handleAccessoryStatusChanged((Intent) message.obj);
                    break;
                default:
                    SdkLog.m8382d(BaseAgent.TAG, "Invalid msg received: " + message.what);
                    break;
            }
        }
    }
}
