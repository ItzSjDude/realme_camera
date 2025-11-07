package com.heytap.accessory.stream;

/* loaded from: classes2.dex */
public class StreamTransfer {
    public static final java.lang.String ACTION_STREAM_TRANSFER_REQUESTED = "com.heytap.accessory.streamconnection";
    public static final int ERROR_CANCEL_ACC_SLEEPING = 17;
    public static final int ERROR_CHANNEL_IO = 1;
    public static final int ERROR_COMMAND_DROPPED = 3;
    public static final int ERROR_CONNECTION_LOST = 5;
    public static final int ERROR_FATAL = 20001;
    public static final int ERROR_FILE_IO = 2;
    public static final int ERROR_NONE = 0;
    public static final int ERROR_NOT_SUPPORTED = 12;
    public static final int ERROR_PEER_AGENT_BUSY = 8;
    public static final int ERROR_PEER_AGENT_NO_RESPONSE = 4;
    public static final int ERROR_PEER_AGENT_REJECTED = 9;
    public static final int ERROR_RECEIVER_MEMORY_LACKING = 15;
    public static final int ERROR_RECEIVER_WAIT_TILL_TIMEOUT = 16;
    public static final int ERROR_REQUEST_NOT_QUEUED = -1;
    public static final int ERROR_SPACE_NOT_AVAILABLE = 11;
    public static final int ERROR_TRANSACTION_NOT_FOUND = 13;
    public static final java.lang.String RECEIVE_PFD = "receivePfd";
    private static final int ST_CANCEL_TRANS_ID = -1;
    private static final int ST_DEFAULT_CONNECTION_ID = 0;
    private static final int ST_DEFAULT_TRANS_ID = 0;
    private static final java.lang.String TAG = "StreamTransfer";
    private java.lang.String mAgentName;
    private java.lang.Object mCallingAgent;
    private com.heytap.accessory.stream.b_renamed.a_renamed mCallingAgentInfo;
    private java.util.concurrent.ConcurrentHashMap<java.lang.Long, java.lang.Boolean> mConnectionMap;
    private android.content.Context mContext;
    private com.heytap.accessory.stream.StreamTransfer.EventListener mEventListener;
    private com.heytap.accessory.stream.StreamTransfer.c_renamed mHandler;
    private com.heytap.accessory.stream.StreamTransfer.b_renamed mLocalCallback;
    private android.os.HandlerThread mStreamTransferHandlerThread;
    private java.util.concurrent.ConcurrentHashMap<java.lang.Long, java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.heytap.accessory.stream.b_renamed.a_renamed.CallingAgentInfo_4>> mTransactionsMap;
    private java.util.concurrent.ConcurrentHashMap<java.lang.Long, java.util.concurrent.ConcurrentHashMap<java.lang.Integer, java.lang.Boolean>> mTransferRequestMap;

    public interface EventListener {
        void onCancelAllCompleted(int i_renamed, int i2);

        void onStreamReceived(long j_renamed, int i_renamed, java.io.InputStream inputStream);

        void onTransferCompleted(long j_renamed, int i_renamed, int i2);

        void onTransferRequested(long j_renamed, int i_renamed, int i2);
    }

    public interface b_renamed {
        void a_renamed(long j_renamed, int i_renamed, int i2);

        void a_renamed(int[] iArr, int i_renamed);
    }

    public StreamTransfer(com.heytap.accessory.BaseAgent baseAgent, com.heytap.accessory.stream.StreamTransfer.EventListener eventListener) throws com.heytap.accessory.bean.SdkUnsupportedException {
        this(baseAgent, baseAgent.getApplicationContext(), eventListener);
    }

    public StreamTransfer(com.heytap.accessory.BaseJobAgent baseJobAgent, com.heytap.accessory.stream.StreamTransfer.EventListener eventListener) throws com.heytap.accessory.bean.SdkUnsupportedException {
        this(baseJobAgent, baseJobAgent.getApplicationContext(), eventListener);
    }

    public StreamTransfer(java.lang.Object obj, android.content.Context context, com.heytap.accessory.stream.StreamTransfer.EventListener eventListener) throws com.heytap.accessory.bean.SdkUnsupportedException {
        this.mTransactionsMap = new java.util.concurrent.ConcurrentHashMap<>();
        this.mConnectionMap = new java.util.concurrent.ConcurrentHashMap<>();
        this.mTransferRequestMap = new java.util.concurrent.ConcurrentHashMap<>();
        this.mLocalCallback = new com.heytap.accessory.stream.StreamTransfer.b_renamed() { // from class: com.heytap.accessory.stream.StreamTransfer.1
            @Override // com.heytap.accessory.stream.StreamTransfer.b_renamed
            public final void a_renamed(long j_renamed, int i_renamed, int i2) {
                java.util.concurrent.ConcurrentHashMap concurrentHashMap = (java.util.concurrent.ConcurrentHashMap) com.heytap.accessory.stream.StreamTransfer.this.mTransactionsMap.get(java.lang.Long.valueOf(j_renamed));
                if (concurrentHashMap != null) {
                    com.heytap.accessory.stream.StreamTransfer.EventListener eventListener2 = com.heytap.accessory.stream.StreamTransfer.this.mEventListener;
                    for (java.util.Map.Entry entry : concurrentHashMap.entrySet()) {
                        if (((com.heytap.accessory.stream.b_renamed.a_renamed.CallingAgentInfo_4) entry.getValue()).f3413b == i_renamed && eventListener2 != null) {
                            com.heytap.accessory.stream.StreamTransfer.this.handleOnTransferCompletedErrorCode(i2);
                            eventListener2.onTransferCompleted(j_renamed, ((java.lang.Integer) entry.getKey()).intValue(), i2);
                            com.heytap.accessory.stream.StreamTransfer.this.removeTransaction(j_renamed, ((java.lang.Integer) entry.getKey()).intValue());
                            com.heytap.accessory.stream.StreamTransfer.this.removeTransactionRequest(j_renamed, i_renamed);
                            return;
                        }
                    }
                    if (!com.heytap.accessory.stream.StreamTransfer.this.getTransactionRequestState(j_renamed, i_renamed) || i2 != 9) {
                        if (!com.heytap.accessory.stream.StreamTransfer.this.containsTransactionRequestKey(j_renamed, i_renamed) || com.heytap.accessory.stream.StreamTransfer.this.containsTransactionKey(j_renamed, i_renamed) || eventListener2 == null) {
                            return;
                        }
                        com.heytap.accessory.stream.StreamTransfer.this.handleOnTransferCompletedErrorCode(i2);
                        eventListener2.onTransferCompleted(j_renamed, i_renamed, i2);
                        com.heytap.accessory.stream.StreamTransfer.this.removeTransactionRequest(j_renamed, i_renamed);
                        com.heytap.accessory.stream.StreamTransfer.this.removeTransactionByTransId(i_renamed);
                        return;
                    }
                    com.heytap.accessory.a_renamed.a_renamed.b_renamed(com.heytap.accessory.stream.StreamTransfer.TAG, "Ignoring onTransferCompleted because setup in_renamed progress");
                    return;
                }
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(com.heytap.accessory.stream.StreamTransfer.TAG, "connectionId =" + j_renamed + "not exits");
            }

            @Override // com.heytap.accessory.stream.StreamTransfer.b_renamed
            public final void a_renamed(int[] iArr, int i_renamed) {
                for (int i2 : iArr) {
                    java.util.Iterator it = com.heytap.accessory.stream.StreamTransfer.this.mTransactionsMap.keySet().iterator();
                    while (it.hasNext()) {
                        java.util.concurrent.ConcurrentHashMap concurrentHashMap = (java.util.concurrent.ConcurrentHashMap) com.heytap.accessory.stream.StreamTransfer.this.mTransactionsMap.get(java.lang.Long.valueOf(((java.lang.Long) it.next()).longValue()));
                        if (concurrentHashMap != null) {
                            for (java.util.Map.Entry entry : concurrentHashMap.entrySet()) {
                                if (((com.heytap.accessory.stream.b_renamed.a_renamed.CallingAgentInfo_4) entry.getValue()).f3413b == i2 && com.heytap.accessory.stream.StreamTransfer.this.mEventListener != null) {
                                    com.heytap.accessory.stream.StreamTransfer.this.removeTransactionByTransId(((java.lang.Integer) entry.getKey()).intValue());
                                }
                            }
                        }
                    }
                }
                com.heytap.accessory.stream.StreamTransfer.EventListener eventListener2 = com.heytap.accessory.stream.StreamTransfer.this.mEventListener;
                if (eventListener2 != null) {
                    com.heytap.accessory.stream.StreamTransfer.this.handleOnCancelAllCompletedErrorCode(i_renamed);
                    eventListener2.onCancelAllCompleted(-1, i_renamed);
                }
            }
        };
        if (obj != null && eventListener != null) {
            this.mCallingAgent = obj;
            this.mContext = context;
            this.mAgentName = obj.getClass().getName();
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "new StreamTransfer: " + this.mAgentName + ", hashcode:" + hashCode());
            this.mEventListener = eventListener;
            com.heytap.accessory.stream.StreamInitializer.initialize(this.mContext);
            if (register()) {
                return;
            }
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "Agent already registered");
            this.mCallingAgentInfo = com.heytap.accessory.stream.a_renamed.b_renamed(this.mAgentName);
            com.heytap.accessory.stream.b_renamed.a_renamed aVar = this.mCallingAgentInfo;
            if (aVar != null) {
                this.mStreamTransferHandlerThread = aVar.c_renamed();
                this.mHandler = (com.heytap.accessory.stream.StreamTransfer.c_renamed) this.mCallingAgentInfo.d_renamed();
                this.mTransactionsMap = this.mCallingAgentInfo.e_renamed();
                this.mCallingAgentInfo.a_renamed(this.mEventListener);
                this.mCallingAgentInfo.a_renamed(this.mLocalCallback);
                return;
            }
            return;
        }
        throw new java.lang.IllegalArgumentException("StreamEventCallback parameter cannot be_renamed null");
    }

    @java.lang.Deprecated
    public int send(com.heytap.accessory.bean.PeerAgent peerAgent, java.io.InputStream inputStream, int i_renamed) throws com.heytap.accessory.bean.UnSupportException {
        return send(peerAgent, inputStream, (java.io.FileDescriptor) null);
    }

    @java.lang.Deprecated
    public int send(com.heytap.accessory.bean.PeerAgent peerAgent, java.io.FileDescriptor fileDescriptor, int i_renamed) throws com.heytap.accessory.bean.UnSupportException {
        return send(peerAgent, (java.io.InputStream) null, fileDescriptor);
    }

    public int send(com.heytap.accessory.bean.PeerAgent peerAgent, java.io.InputStream inputStream) throws com.heytap.accessory.bean.UnSupportException {
        return send(peerAgent, inputStream, (java.io.FileDescriptor) null);
    }

    public int send(com.heytap.accessory.bean.PeerAgent peerAgent, java.io.FileDescriptor fileDescriptor) throws com.heytap.accessory.bean.UnSupportException {
        return send(peerAgent, (java.io.InputStream) null, fileDescriptor);
    }

    private int send(com.heytap.accessory.bean.PeerAgent peerAgent, java.io.InputStream inputStream, java.io.FileDescriptor fileDescriptor) throws com.heytap.accessory.bean.UnSupportException {
        int iA = -1;
        if (validateParam(peerAgent)) {
            if (com.heytap.accessory.stream.StreamInitializer.getStreamMsgPackageName(this.mContext) == null) {
                com.heytap.accessory.a_renamed.a_renamed.a_renamed(TAG, "FTCore version doesnot support content uri");
            } else if (inputStream == null && fileDescriptor == null) {
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "input source is_renamed wrong!!");
                return -1;
            }
            com.heytap.accessory.stream.b_renamed.a_renamed.CallingAgentInfo_4 c0072a = new com.heytap.accessory.stream.b_renamed.a_renamed.CallingAgentInfo_4();
            try {
                if (inputStream == null) {
                    iA = com.heytap.accessory.stream.a_renamed.a_renamed(this.mContext, this.mAgentName).a_renamed(this.mContext, this.mAgentName, this.mLocalCallback, peerAgent, fileDescriptor);
                } else {
                    iA = com.heytap.accessory.stream.a_renamed.a_renamed(this.mContext, this.mAgentName).a_renamed(this.mContext, this.mAgentName, this.mLocalCallback, peerAgent, inputStream);
                }
            } catch (com.heytap.accessory.bean.GeneralException | java.lang.IllegalAccessException e_renamed) {
                e_renamed.printStackTrace();
            }
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "received tx_renamed from STCore".concat(java.lang.String.valueOf(iA)));
            c0072a.f3413b = iA;
            putTransaction(0L, iA, c0072a);
        }
        return iA;
    }

    private boolean validateParam(com.heytap.accessory.bean.PeerAgent peerAgent) throws com.heytap.accessory.bean.UnSupportException {
        if (peerAgent == null) {
            throw new java.lang.IllegalArgumentException("PeerAgent cannot be_renamed null");
        }
        if (checkStreamUnSupport(peerAgent)) {
            throw new com.heytap.accessory.bean.UnSupportException("the peer agent doesn't_renamed support the stream feature, please check");
        }
        java.lang.Object obj = this.mCallingAgent;
        if (obj == null || this.mEventListener == null) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Using invalid instance of_renamed StreamTransfer(). Please re-register.");
            return false;
        }
        if (obj instanceof com.heytap.accessory.BaseJobAgent) {
            if (!((com.heytap.accessory.BaseJobAgent) obj).getSuccessfulConnections().isEmpty()) {
                return true;
            }
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "current baseJobAgent has not setup service connection, please connect service first");
            return false;
        }
        if (!(obj instanceof com.heytap.accessory.BaseAgent) || !((com.heytap.accessory.BaseAgent) obj).getSuccessfulConnections().isEmpty()) {
            return true;
        }
        com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "current baseAgent has not setup service connection, please connect service first");
        return false;
    }

    private boolean checkStreamUnSupport(com.heytap.accessory.bean.PeerAgent peerAgent) {
        return peerAgent == null || peerAgent.getAccessory() == null || !peerAgent.getAccessory().supportStream();
    }

    public void receive(final long j_renamed, final int i_renamed) {
        com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "receive task connectionId: " + j_renamed + " ,transactionId:" + i_renamed + ",hashCode:, " + hashCode());
        if (this.mCallingAgent == null || this.mEventListener == null) {
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "Using invalid instance of_renamed StreamTransfer(). Please re-register.");
            putTransactionRequest(j_renamed, i_renamed, false);
            return;
        }
        if (!checkReceiveParams(j_renamed, i_renamed) || !containsTransactionRequestKey(j_renamed, i_renamed)) {
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "TransactionId: Given[" + i_renamed + "] not exist");
            putTransactionRequest(j_renamed, i_renamed, false);
            throw new java.lang.IllegalArgumentException("Wrong filepath or transaction id_renamed used");
        }
        com.heytap.accessory.stream.b_renamed.a_renamed.CallingAgentInfo_4 c0072a = new com.heytap.accessory.stream.b_renamed.a_renamed.CallingAgentInfo_4();
        c0072a.f3412a = j_renamed;
        c0072a.f3413b = i_renamed;
        putTransaction(j_renamed, i_renamed, c0072a);
        putConnectionRequest(j_renamed, true);
        if (com.heytap.accessory.stream.StreamInitializer.getStreamMsgPackageName(this.mContext) == null) {
            com.heytap.accessory.a_renamed.a_renamed.a_renamed(TAG, "Accessory Framework doesn't_renamed support content URI !!");
        }
        this.mHandler.post(new java.lang.Runnable() { // from class: com.heytap.accessory.stream.StreamTransfer.2
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r9v3, types: [int] */
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    try {
                        android.os.ParcelFileDescriptor parcelFileDescriptorA = com.heytap.accessory.stream.a_renamed.a_renamed(com.heytap.accessory.stream.StreamTransfer.this.mContext, com.heytap.accessory.stream.StreamTransfer.this.mAgentName).a_renamed(com.heytap.accessory.stream.StreamTransfer.this.mLocalCallback, j_renamed, i_renamed, true);
                        if (parcelFileDescriptorA != null && com.heytap.accessory.stream.StreamTransfer.this.mEventListener != null) {
                            com.heytap.accessory.stream.StreamTransfer.this.mEventListener.onStreamReceived(j_renamed, i_renamed, new android.os.ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptorA));
                        }
                    } catch (java.lang.Exception e_renamed) {
                        e_renamed.printStackTrace();
                    }
                } finally {
                    com.heytap.accessory.stream.StreamTransfer.this.putTransactionRequest(j_renamed, i_renamed, false);
                }
            }
        });
    }

    public void reject(final long j_renamed, final int i_renamed) {
        if (this.mCallingAgent != null && this.mEventListener != null) {
            if (checkReceiveParams(j_renamed, i_renamed) && containsTransactionRequestKey(j_renamed, i_renamed)) {
                new com.heytap.accessory.stream.b_renamed.a_renamed.CallingAgentInfo_4().f3413b = i_renamed;
                removeTransaction(j_renamed, i_renamed);
                this.mHandler.post(new java.lang.Runnable() { // from class: com.heytap.accessory.stream.StreamTransfer.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            com.heytap.accessory.stream.a_renamed.a_renamed(com.heytap.accessory.stream.StreamTransfer.this.mContext, com.heytap.accessory.stream.StreamTransfer.this.mAgentName).a_renamed(null, j_renamed, i_renamed, false);
                        } catch (com.heytap.accessory.bean.GeneralException | java.lang.IllegalAccessException e_renamed) {
                            e_renamed.printStackTrace();
                        }
                    }
                });
                return;
            }
            throw new java.lang.IllegalArgumentException("Wrong transaction id_renamed used in_renamed reject()");
        }
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "Using invalid instance of_renamed StreamTransfer(). Please re-register.");
    }

    public void cancel(long j_renamed, int i_renamed) {
        if (this.mCallingAgent != null && this.mEventListener != null) {
            if (!containsTransactionKey(j_renamed, i_renamed)) {
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Wrong transaction id_renamed used for cancel");
                return;
            }
            try {
                com.heytap.accessory.stream.b_renamed.a_renamed.CallingAgentInfo_4 transaction = getTransaction(j_renamed, i_renamed);
                if (transaction == null) {
                    com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "cancelStream aborted because service connection or transaction already closed.");
                } else if (transaction.f3413b == 0) {
                    transaction.f3413b = -1;
                    com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "Cancel called before transaction id_renamed is_renamed genereated".concat(java.lang.String.valueOf(i_renamed)));
                } else if (transaction.f3413b == -1) {
                    com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "Cancel called again before transaction id_renamed is_renamed genereated".concat(java.lang.String.valueOf(i_renamed)));
                } else {
                    com.heytap.accessory.stream.a_renamed aVarA = com.heytap.accessory.stream.a_renamed.a_renamed(this.mContext, this.mAgentName);
                    try {
                        try {
                            com.heytap.accessory.stream.b_renamed.e_renamed eVar = new com.heytap.accessory.stream.b_renamed.e_renamed(3, new com.heytap.accessory.stream.b_renamed.c_renamed(j_renamed, transaction.f3413b).a_renamed());
                            if (aVarA.f3399a != null) {
                                aVarA.f3399a.f3402a.a_renamed(eVar.a_renamed().toString(), new android.os.Bundle());
                            }
                        } catch (org.json.JSONException e_renamed) {
                            e_renamed.printStackTrace();
                        }
                    } catch (android.os.RemoteException e2) {
                        e2.printStackTrace();
                    }
                }
                synchronized (this) {
                    this.mConnectionMap.remove(java.lang.Long.valueOf(j_renamed));
                }
                return;
            } catch (com.heytap.accessory.bean.GeneralException | java.lang.IllegalAccessException e3) {
                e3.printStackTrace();
                return;
            }
        }
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "Using invalid instance of_renamed StreamTransfer(). Please re-register.");
    }

    public void cancelAll() {
        android.content.SharedPreferences sharedPreferences;
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "[cancelAll] Stream");
        if (this.mCallingAgent != null && this.mEventListener != null) {
            if (android.os.Build.VERSION.SDK_INT > 26) {
                sharedPreferences = this.mContext.createDeviceProtectedStorageContext().getSharedPreferences("AccessoryPreferences", 0);
            } else {
                sharedPreferences = this.mContext.getApplicationContext().getSharedPreferences("AccessoryPreferences", 0);
            }
            final java.lang.String string = sharedPreferences.getString(this.mAgentName, null);
            if (string == null) {
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "[cancelAll] Your service was not found. Please re-register");
                return;
            } else {
                this.mHandler.post(new java.lang.Runnable() { // from class: com.heytap.accessory.stream.StreamTransfer.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            synchronized (com.heytap.accessory.stream.StreamTransfer.this) {
                                for (java.lang.Long l_renamed : com.heytap.accessory.stream.StreamTransfer.this.mTransactionsMap.keySet()) {
                                    java.lang.Boolean bool = (java.lang.Boolean) com.heytap.accessory.stream.StreamTransfer.this.mConnectionMap.get(l_renamed);
                                    int iA = (bool == null || !bool.booleanValue()) ? com.heytap.accessory.stream.a_renamed.a_renamed(com.heytap.accessory.stream.StreamTransfer.this.mContext, com.heytap.accessory.stream.StreamTransfer.this.mAgentName).a_renamed(string, 0L) : com.heytap.accessory.stream.a_renamed.a_renamed(com.heytap.accessory.stream.StreamTransfer.this.mContext, com.heytap.accessory.stream.StreamTransfer.this.mAgentName).a_renamed("0", l_renamed.longValue());
                                    com.heytap.accessory.stream.StreamTransfer.EventListener eventListener = com.heytap.accessory.stream.StreamTransfer.this.mEventListener;
                                    if (eventListener == null) {
                                        com.heytap.accessory.a_renamed.a_renamed.d_renamed(com.heytap.accessory.stream.StreamTransfer.TAG, "[cancelAll] listener is_renamed null.");
                                        return;
                                    }
                                    com.heytap.accessory.a_renamed.a_renamed.b_renamed(com.heytap.accessory.stream.StreamTransfer.TAG, "[cancelAll] cancel status ".concat(java.lang.String.valueOf(iA)));
                                    if (iA == 0) {
                                        com.heytap.accessory.stream.StreamTransfer.this.handleOnCancelAllCompletedErrorCode(12);
                                        eventListener.onCancelAllCompleted(-1, 12);
                                    } else if (iA == 13) {
                                        com.heytap.accessory.stream.StreamTransfer.this.handleOnCancelAllCompletedErrorCode(13);
                                        eventListener.onCancelAllCompleted(-1, 13);
                                    } else if (iA == 17) {
                                        com.heytap.accessory.stream.StreamTransfer.this.handleOnCancelAllCompletedErrorCode(17);
                                        eventListener.onCancelAllCompleted(-1, 17);
                                    }
                                }
                                com.heytap.accessory.stream.StreamTransfer.this.mConnectionMap.clear();
                            }
                        } catch (com.heytap.accessory.bean.GeneralException e_renamed) {
                            com.heytap.accessory.a_renamed.a_renamed.e_renamed(com.heytap.accessory.stream.StreamTransfer.TAG, "[cancelAll]".concat(java.lang.String.valueOf(e_renamed)));
                            e_renamed.printStackTrace();
                        } catch (java.lang.IllegalAccessException e2) {
                            e2.printStackTrace();
                            com.heytap.accessory.a_renamed.a_renamed.e_renamed(com.heytap.accessory.stream.StreamTransfer.TAG, "[cancelAll]".concat(java.lang.String.valueOf(e2)));
                        }
                    }
                });
                return;
            }
        }
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "[cancelAll] Using invalid instance of_renamed  Please re-register.");
    }

    public void close() {
        if (this.mCallingAgent != null && this.mEventListener != null) {
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "stopStreamTransferService() called by_renamed : " + this.mAgentName);
            cancelAll();
            com.heytap.accessory.stream.a_renamed.a_renamed(this.mAgentName);
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.heytap.accessory.stream.b_renamed.a_renamed.CallingAgentInfo_4>> concurrentHashMap = this.mTransactionsMap;
            if (concurrentHashMap != null) {
                concurrentHashMap.clear();
            }
            com.heytap.accessory.stream.StreamTransfer.c_renamed cVar = this.mHandler;
            if (cVar != null) {
                cVar.removeCallbacksAndMessages(null);
                this.mHandler.getLooper().quit();
            }
            this.mCallingAgent = null;
            this.mEventListener = null;
            return;
        }
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "Using invalid instance of_renamed StreamTransfer(). Please re-register.");
    }

    private boolean register() {
        com.heytap.accessory.stream.a_renamed.a_renamed(this, this.mAgentName);
        this.mStreamTransferHandlerThread = new android.os.HandlerThread("StreamTransferHandlerThread");
        this.mStreamTransferHandlerThread.setUncaughtExceptionHandler(new com.heytap.accessory.stream.StreamTransfer.a_renamed((byte) 0));
        this.mStreamTransferHandlerThread.start();
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "StreamTransferHandlerThread started");
        android.os.Looper looper = this.mStreamTransferHandlerThread.getLooper();
        if (looper != null) {
            this.mHandler = new com.heytap.accessory.stream.StreamTransfer.c_renamed(looper);
        }
        if (this.mHandler == null) {
            return false;
        }
        this.mTransactionsMap = new java.util.concurrent.ConcurrentHashMap<>();
        this.mCallingAgentInfo = new com.heytap.accessory.stream.b_renamed.a_renamed(this.mEventListener, this.mStreamTransferHandlerThread, this.mHandler, this.mLocalCallback, this.mTransactionsMap);
        com.heytap.accessory.stream.a_renamed.a_renamed(this.mAgentName, this.mCallingAgentInfo);
        this.mHandler.post(new java.lang.Runnable() { // from class: com.heytap.accessory.stream.StreamTransfer.5
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    com.heytap.accessory.stream.a_renamed.a_renamed(com.heytap.accessory.stream.StreamTransfer.this.mContext, com.heytap.accessory.stream.StreamTransfer.this.mAgentName);
                } catch (com.heytap.accessory.bean.GeneralException | java.lang.IllegalAccessException e_renamed) {
                    e_renamed.printStackTrace();
                }
            }
        });
        return true;
    }

    public void informIncomingSTRequest(android.content.Context context, android.content.Intent intent) throws java.lang.NumberFormatException {
        android.content.SharedPreferences sharedPreferences;
        final int intExtra = intent.getIntExtra("transId", -1);
        java.lang.String stringExtra = intent.getStringExtra("agentClass");
        final long longExtra = intent.getLongExtra("connectionId", 0L);
        final int i_renamed = java.lang.Integer.parseInt(intent.getStringExtra("contId"));
        if (stringExtra == null) {
            if (android.os.Build.VERSION.SDK_INT > 26) {
                sharedPreferences = this.mContext.createDeviceProtectedStorageContext().getSharedPreferences("AccessoryPreferences", 0);
            } else {
                sharedPreferences = this.mContext.getApplicationContext().getSharedPreferences("AccessoryPreferences", 0);
            }
            stringExtra = sharedPreferences.getString(intent.getStringExtra("peerId"), null);
        }
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "class now:" + stringExtra + " , " + hashCode());
        if (stringExtra == null) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Target agent was cleared. Re-registering");
            context.sendBroadcast(com.heytap.accessory.b_renamed.b_renamed.a_renamed(context.getPackageName()));
            return;
        }
        if (this.mCallingAgent == null) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Calling agent was cleared");
            return;
        }
        if (!stringExtra.equalsIgnoreCase(this.mAgentName)) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Class name not matched with " + this.mAgentName);
            return;
        }
        final com.heytap.accessory.stream.b_renamed.a_renamed aVarB = com.heytap.accessory.stream.a_renamed.b_renamed(stringExtra);
        if (aVarB == null) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "AgentInfo is_renamed NULL! Re-Registering");
            register();
            informIncomingSTRequest(context, intent);
        } else if (aVarB.a_renamed() == null) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "callback is_renamed not registered for ".concat(java.lang.String.valueOf(stringExtra)));
        } else {
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "Informing app of_renamed incoming stream transfer request on_renamed registered callback-tid: ".concat(java.lang.String.valueOf(intExtra)));
            this.mHandler.post(new java.lang.Runnable() { // from class: com.heytap.accessory.stream.StreamTransfer.6
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        com.heytap.accessory.stream.a_renamed.a_renamed(com.heytap.accessory.stream.StreamTransfer.this.mContext, com.heytap.accessory.stream.StreamTransfer.this.mAgentName).a_renamed(com.heytap.accessory.stream.StreamTransfer.this.mLocalCallback, intExtra);
                        com.heytap.accessory.stream.StreamTransfer.this.putTransactionRequest(longExtra, intExtra, true);
                        aVarB.a_renamed().onTransferRequested(longExtra, i_renamed, intExtra);
                    } catch (com.heytap.accessory.bean.GeneralException | java.lang.IllegalAccessException e_renamed) {
                        e_renamed.printStackTrace();
                    }
                }
            });
        }
    }

    private boolean checkReceiveParams(long j_renamed, int i_renamed) {
        if (!containsTransactionKey(j_renamed, i_renamed)) {
            return true;
        }
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "transactionId already exist");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnTransferCompletedErrorCode(int i_renamed) {
        if (i_renamed == 8) {
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onTransferCompleted() -> ERROR_PEER_AGENT_BUSY");
            return;
        }
        if (i_renamed == 9) {
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onTransferCompleted() -> ERROR_PEER_AGENT_REJECTED");
            return;
        }
        if (i_renamed == 11) {
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onTransferCompleted() -> ERROR_SPACE_NOT_AVAILABLE");
            return;
        }
        if (i_renamed == 20001) {
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onTransferCompleted() -> ERROR_FATAL");
            return;
        }
        if (i_renamed == 15) {
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onTransferCompleted() -> ERROR_RECEIVER_MEMORY_LACKING");
            return;
        }
        if (i_renamed != 16) {
            switch (i_renamed) {
                case -1:
                    com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onTransferCompleted() -> ERROR_REQUEST_NOT_QUEUED");
                    break;
                case 0:
                    com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onTransferCompleted() -> ERROR_NONE");
                    break;
                case 1:
                    com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onTransferCompleted() -> ERROR_CHANNEL_IO");
                    break;
                case 2:
                    com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onTransferCompleted() -> ERROR_FILE_IO");
                    break;
                case 3:
                    com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onTransferCompleted() -> ERROR_COMMAND_DROPPED");
                    break;
                case 4:
                    com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onTransferCompleted() -> ERROR_PEER_AGENT_NO_RESPONSE");
                    break;
                case 5:
                    com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onTransferCompleted() -> ERROR_CONNECTION_LOST");
                    break;
                default:
                    com.heytap.accessory.a_renamed.a_renamed.d_renamed(TAG, "onTransferCompleted() error_code: ".concat(java.lang.String.valueOf(i_renamed)));
                    break;
            }
            return;
        }
        com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onTransferCompleted() -> ERROR_RECEIVER_WAIT_TILL_TIMEOUT");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnCancelAllCompletedErrorCode(int i_renamed) {
        if (i_renamed == 12) {
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onCancelAllCompleted() -> ERROR_NOT_SUPPORTED");
            return;
        }
        if (i_renamed == 13) {
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onCancelAllCompleted() -> ERROR_TRANSACTION_NOT_FOUND");
        } else if (i_renamed == 17) {
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onCancelAllCompleted() -> ERROR_CANCEL_ACC_SLEEPING");
        } else {
            com.heytap.accessory.a_renamed.a_renamed.d_renamed(TAG, "onCancelAllCompleted() error_code: ".concat(java.lang.String.valueOf(i_renamed)));
        }
    }

    static class a_renamed implements java.lang.Thread.UncaughtExceptionHandler {
        /* synthetic */ a_renamed(byte b2) {
            this();
        }

        private a_renamed() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public final void uncaughtException(final java.lang.Thread thread, final java.lang.Throwable th) {
            new android.os.Handler(android.os.Looper.getMainLooper()).post(new java.lang.Runnable() { // from class: com.heytap.accessory.stream.StreamTransfer.a_renamed.1
                @Override // java.lang.Runnable
                public final void run() {
                    com.heytap.accessory.a_renamed.a_renamed.e_renamed(com.heytap.accessory.stream.StreamTransfer.TAG, "Exception in_renamed StreamTransfer Handler thread :" + thread.getName());
                    throw new java.lang.RuntimeException(th);
                }
            });
        }
    }

    static class c_renamed extends android.os.Handler {
        public c_renamed(android.os.Looper looper) {
            super(looper);
        }
    }

    private synchronized void putTransaction(long j_renamed, int i_renamed, com.heytap.accessory.stream.b_renamed.a_renamed.CallingAgentInfo_4 c0072a) {
        com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG + hashCode(), "putTransaction: connectionId:" + j_renamed + ",transactionId:" + i_renamed);
        if (this.mTransactionsMap != null) {
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.heytap.accessory.stream.b_renamed.a_renamed.CallingAgentInfo_4> concurrentHashMap = this.mTransactionsMap.get(java.lang.Long.valueOf(j_renamed));
            if (concurrentHashMap == null) {
                concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<>();
                this.mTransactionsMap.put(java.lang.Long.valueOf(j_renamed), concurrentHashMap);
            }
            if (c0072a != null) {
                concurrentHashMap.put(java.lang.Integer.valueOf(i_renamed), c0072a);
            }
        }
    }

    private synchronized com.heytap.accessory.stream.b_renamed.a_renamed.CallingAgentInfo_4 getTransaction(long j_renamed, int i_renamed) {
        com.heytap.accessory.stream.b_renamed.a_renamed.CallingAgentInfo_4 c0072a;
        java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.heytap.accessory.stream.b_renamed.a_renamed.CallingAgentInfo_4> concurrentHashMap;
        c0072a = null;
        if (this.mTransactionsMap != null && (concurrentHashMap = this.mTransactionsMap.get(java.lang.Long.valueOf(j_renamed))) != null) {
            c0072a = concurrentHashMap.get(java.lang.Integer.valueOf(i_renamed));
        }
        return c0072a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void removeTransaction(long j_renamed, int i_renamed) {
        java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.heytap.accessory.stream.b_renamed.a_renamed.CallingAgentInfo_4> concurrentHashMap;
        if (this.mTransactionsMap != null && (concurrentHashMap = this.mTransactionsMap.get(java.lang.Long.valueOf(j_renamed))) != null) {
            concurrentHashMap.remove(java.lang.Integer.valueOf(i_renamed));
            if (concurrentHashMap.isEmpty()) {
                com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "removeTransaction:" + j_renamed + " " + i_renamed);
                this.mTransactionsMap.remove(java.lang.Long.valueOf(j_renamed));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void removeTransactionByTransId(int i_renamed) {
        if (this.mTransactionsMap != null) {
            java.util.Iterator<java.lang.Long> it = this.mTransactionsMap.keySet().iterator();
            while (it.hasNext()) {
                removeTransaction(it.next().longValue(), i_renamed);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean containsTransactionKey(long j_renamed, int i_renamed) {
        boolean zContainsKey;
        java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.heytap.accessory.stream.b_renamed.a_renamed.CallingAgentInfo_4> concurrentHashMap;
        zContainsKey = false;
        if (this.mTransactionsMap != null && (concurrentHashMap = this.mTransactionsMap.get(java.lang.Long.valueOf(j_renamed))) != null) {
            zContainsKey = concurrentHashMap.containsKey(java.lang.Integer.valueOf(i_renamed));
        }
        return zContainsKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void putTransactionRequest(long j_renamed, int i_renamed, boolean z_renamed) {
        java.util.concurrent.ConcurrentHashMap<java.lang.Integer, java.lang.Boolean> concurrentHashMap = this.mTransferRequestMap.get(java.lang.Long.valueOf(j_renamed));
        if (concurrentHashMap == null) {
            concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<>();
        }
        concurrentHashMap.put(java.lang.Integer.valueOf(i_renamed), java.lang.Boolean.valueOf(z_renamed));
        this.mTransferRequestMap.put(java.lang.Long.valueOf(j_renamed), concurrentHashMap);
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG + hashCode(), "putTransactionRequest connectionId: " + j_renamed + " ,transactionId: " + i_renamed + " , " + z_renamed + " , " + getTransactionRequestState(j_renamed, i_renamed));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean getTransactionRequestState(long j_renamed, int i_renamed) {
        java.util.concurrent.ConcurrentHashMap<java.lang.Integer, java.lang.Boolean> concurrentHashMap = this.mTransferRequestMap.get(java.lang.Long.valueOf(j_renamed));
        if (concurrentHashMap == null) {
            return false;
        }
        if (concurrentHashMap.get(java.lang.Integer.valueOf(i_renamed)) != null) {
            if (concurrentHashMap.get(java.lang.Integer.valueOf(i_renamed)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void removeTransactionRequest(long j_renamed, int i_renamed) {
        java.util.concurrent.ConcurrentHashMap<java.lang.Integer, java.lang.Boolean> concurrentHashMap = this.mTransferRequestMap.get(java.lang.Long.valueOf(j_renamed));
        if (concurrentHashMap != null) {
            concurrentHashMap.remove(java.lang.Integer.valueOf(i_renamed));
            if (concurrentHashMap.isEmpty()) {
                this.mTransferRequestMap.remove(java.lang.Long.valueOf(j_renamed));
            }
        }
    }

    private synchronized void putConnectionRequest(long j_renamed, boolean z_renamed) {
        this.mConnectionMap.put(java.lang.Long.valueOf(j_renamed), java.lang.Boolean.valueOf(z_renamed));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean containsTransactionRequestKey(long j_renamed, int i_renamed) {
        boolean zContainsKey;
        zContainsKey = false;
        java.util.concurrent.ConcurrentHashMap<java.lang.Integer, java.lang.Boolean> concurrentHashMap = this.mTransferRequestMap.get(java.lang.Long.valueOf(j_renamed));
        if (concurrentHashMap != null) {
            zContainsKey = concurrentHashMap.containsKey(java.lang.Integer.valueOf(i_renamed));
        } else {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG + hashCode(), "mTransferRequestMap not contains connectionId:" + j_renamed + ",transactionId:" + i_renamed);
        }
        return zContainsKey;
    }
}
