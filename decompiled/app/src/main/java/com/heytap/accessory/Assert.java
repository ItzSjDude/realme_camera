package com.heytap.accessory;

/* loaded from: classes2.dex */
public abstract class BaseSocket {
    public static final int CONNECTION_LOST_DEVICE_DETACHED = 1;
    public static final int CONNECTION_LOST_PEER_DISCONNECTED = 0;
    public static final int CONNECTION_LOST_RETRANSMISSION_FAILED = 2;
    public static final int CONNECTION_LOST_UNKNOWN_REASON = 3;
    private static final java.lang.String DATA_KEY = "_";
    public static final int ERROR_CANCELLED = 20008;
    public static final int ERROR_CONNECTION_ALREADY_CLOSED = 20005;
    public static final int ERROR_FATAL = 20001;
    public static final int ERROR_INTERNAL_ERROR = 20003;
    public static final int ERROR_INVALID_CHANNEL = 20006;
    public static final int ERROR_INVALID_PARAMS = 20002;
    public static final int ERROR_WRITE_TIMEDOUT = 20007;
    private static final int SOCKET_CONNECTED = 1;
    private static final int SOCKET_DISCONNECTED = 2;
    private static final int SOCKET_FORCE_CLOSED = 3;
    private static final java.lang.String TAG = "BaseSocket";
    private com.heytap.accessory.BaseAdapter mAdapter;
    private java.util.List<java.lang.Long> mAvailableChannelIdList;
    private com.heytap.accessory.bean.PeerAgent mConnectedPeer;
    private java.lang.String mConnectionId;
    private com.heytap.accessory.BaseSocket.a_renamed mConnectionStatusCallback;
    private int mIsConnected = 2;
    private com.heytap.accessory.BaseSocket.b_renamed mSocketHandler;
    private java.util.Map<java.lang.String, com.heytap.accessory.bean.TrafficReport> mTrafficReportMap;

    interface a_renamed {
        void a_renamed(com.heytap.accessory.bean.PeerAgent peerAgent, int i_renamed);

        void a_renamed(com.heytap.accessory.bean.PeerAgent peerAgent, com.heytap.accessory.BaseSocket baseSocket);
    }

    public abstract void onError(int i_renamed, java.lang.String str, int i2);

    public abstract void onReceive(long j_renamed, int i_renamed, byte[] bArr);

    protected abstract void onServiceConnectionLost(long j_renamed, int i_renamed);

    protected BaseSocket(java.lang.String str) {
    }

    public boolean isConnected() {
        return this.mIsConnected == 1;
    }

    public com.heytap.accessory.bean.PeerAgent getConnectedPeerAgent() {
        return this.mConnectedPeer;
    }

    public void send(int i_renamed, byte[] bArr) throws java.io.IOException {
        sendData(i_renamed, bArr, 3, false);
    }

    public void sendUncompressed(int i_renamed, byte[] bArr) throws java.io.IOException {
        sendData(i_renamed, bArr, 2, false);
    }

    public void sendCompressed(int i_renamed, byte[] bArr) throws com.heytap.accessory.bean.UnSupportException, java.io.IOException {
        if (checkCompressedUnSupport(getConnectedPeerAgent())) {
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "current peer is_renamed note supported compression");
            throw new com.heytap.accessory.bean.UnSupportException("the peer agent doesn't_renamed support the compression feature, please check");
        }
        sendData(i_renamed, bArr, 1, false);
    }

    public void sendAlign(int i_renamed, byte[] bArr) throws java.io.IOException {
        sendData(i_renamed, bArr, 1, true);
    }

    private boolean checkCompressedUnSupport(com.heytap.accessory.bean.PeerAgent peerAgent) {
        return peerAgent == null || peerAgent.getAccessory() == null || !peerAgent.getAccessory().supportCompression();
    }

    private synchronized void sendData(int i_renamed, byte[] bArr, int i2, boolean z_renamed) throws java.io.IOException {
        try {
            if (i_renamed < 0) {
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Send Failed : there is_renamed no service channel at_renamed the index");
                throw new java.io.IOException("end Failed : there is_renamed no service channel at_renamed the index");
            }
            if (this.mIsConnected != 1) {
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Send failed. Socket already closed");
                throw new java.io.IOException("Send failed. Socket already closed");
            }
            if (bArr == null) {
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "sendData: data is_renamed null");
                throw new java.lang.IllegalArgumentException("Invalid data to send:NULL");
            }
            if (bArr.length == 0) {
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "sendData: data length is_renamed 0");
                throw new java.lang.IllegalArgumentException("Invalaid data length 0");
            }
            if (bArr.length > this.mConnectedPeer.getMaxAllowedDataSize()) {
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Data too long:" + bArr.length + " , " + this.mConnectedPeer.getMaxAllowedDataSize());
                throw new java.lang.IllegalArgumentException("Data Too long! size:" + bArr.length + " Max allowed Size:" + this.mConnectedPeer.getMaxAllowedDataSize() + ". check PeerAgent.getMaxAllowedDataSize()");
            }
            sendDataNonFragment(i_renamed, bArr, 0, false, i2, z_renamed);
        } catch (java.lang.Throwable th) {
            throw th;
        }
    }

    public synchronized void secureSend(int i_renamed, byte[] bArr) throws java.io.IOException {
        if (i_renamed < 0) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Send Failed : there is_renamed no service channel at_renamed the index");
            return;
        }
        if (this.mIsConnected != 1) {
            throw new java.io.IOException("Secure Send failed. Socket already closed");
        }
        if (bArr == null) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "secureSend: data is_renamed null");
            throw new java.lang.IllegalArgumentException("Invalid data to send:NULL");
        }
        if (bArr.length == 0) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "SecureSend: data length is_renamed 0");
            throw new java.lang.IllegalArgumentException("Invalaid data length 0");
        }
        if (bArr.length > this.mConnectedPeer.getMaxAllowedDataSize()) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "SecureSend:Data too long:" + bArr.length);
            throw new java.lang.IllegalArgumentException("Secure send:Data Too long! size:" + bArr.length + " Max allowed Size:" + this.mConnectedPeer.getMaxAllowedDataSize() + ". check PeerAgent.getMaxAllowedDataSize()");
        }
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "Sending data:" + bArr.length + " bytes");
        sendDataNonFragment(i_renamed, bArr, getConnectedPeerAgent().getAccessory().getEncryptionPaddingLength(), true, 3, false);
    }

    private void sendDataNonFragment(int i_renamed, byte[] bArr, int i2, boolean z_renamed, int i3, boolean z2) throws java.io.IOException {
        try {
            if (this.mIsConnected != 1) {
                com.heytap.accessory.a_renamed.a_renamed.d_renamed(TAG, "Data send failed, connection closed!");
                throw new java.io.IOException("Failed to send, connection closed!");
            }
            com.heytap.accessory.b_renamed.a_renamed.a_renamed aVarA = com.heytap.accessory.b_renamed.a_renamed.c_renamed.a_renamed(com.heytap.accessory.b_renamed.g_renamed.a_renamed() + bArr.length + i2 + com.heytap.accessory.b_renamed.g_renamed.c_renamed());
            aVarA.a_renamed(com.heytap.accessory.b_renamed.g_renamed.a_renamed());
            aVarA.a_renamed(bArr, 0, bArr.length);
            int iSend = this.mAdapter.send(this.mConnectedPeer, this.mConnectionId, i_renamed, aVarA.a_renamed(), z_renamed, aVarA.c_renamed(), aVarA.b_renamed(), i3, z2);
            if (iSend != 0) {
                if (iSend == 20005) {
                    this.mIsConnected = 2;
                    com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Write failed: Connection closed");
                    throw new java.io.IOException("Write failed:Connection already closed");
                }
                if (iSend == 20008) {
                    com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "write failed: user cancelled");
                    return;
                }
                if (iSend == 20006) {
                    com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Write failed. Attempt to write on_renamed invalid channel:".concat(java.lang.String.valueOf(i_renamed)));
                    throw new java.lang.IllegalArgumentException("Write failed. Attempt to write on_renamed invalid channel:".concat(java.lang.String.valueOf(i_renamed)));
                }
                if (iSend != 20007) {
                    return;
                }
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Write failed: Timed out!");
                close();
                throw new java.io.IOException("Write failed: Timed out!");
            }
        } catch (com.heytap.accessory.b_renamed.a_renamed.b_renamed e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "BufferException: " + e_renamed.getLocalizedMessage());
        } catch (com.heytap.accessory.bean.GeneralException e2) {
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "Send failed!", e2);
            throw new java.io.IOException("Send Failed", e2);
        }
    }

    public void send(int i_renamed, com.heytap.accessory.b_renamed.a_renamed.a_renamed aVar) throws java.io.IOException {
        sendData(i_renamed, aVar, 3, false);
    }

    public void sendUncompressed(int i_renamed, com.heytap.accessory.b_renamed.a_renamed.a_renamed aVar) throws java.io.IOException {
        sendData(i_renamed, aVar, 2, false);
    }

    public void sendCompressed(int i_renamed, com.heytap.accessory.b_renamed.a_renamed.a_renamed aVar) throws java.io.IOException {
        sendData(i_renamed, aVar, 1, false);
    }

    public void sendAlign(int i_renamed, com.heytap.accessory.b_renamed.a_renamed.a_renamed aVar) throws java.io.IOException {
        sendData(i_renamed, aVar, 3, true);
    }

    private void sendData(int i_renamed, com.heytap.accessory.b_renamed.a_renamed.a_renamed aVar, int i2, boolean z_renamed) throws java.io.IOException {
        if (i_renamed < 0) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Send Failed : there is_renamed no service channel at_renamed the index");
            return;
        }
        if (this.mIsConnected != 1) {
            throw new java.io.IOException("Send failed. Socket already closed");
        }
        if (aVar == null) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "sendData: data is_renamed null");
            throw new java.lang.IllegalArgumentException("Invalid data to send:NULL");
        }
        if (aVar.a_renamed().length == 0) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "sendData: data length is_renamed 0");
            throw new java.lang.IllegalArgumentException("Invalaid data length 0");
        }
        if (aVar.a_renamed().length > this.mConnectedPeer.getMaxAllowedDataSize()) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Data too long:" + aVar.a_renamed().length);
            throw new java.lang.IllegalArgumentException("Data Too long! size:" + aVar.a_renamed().length + " Max allowed Size:" + this.mConnectedPeer.getMaxAllowedDataSize() + ". check PeerAgent.getMaxAllowedDataSize()");
        }
        try {
            if (this.mIsConnected != 1) {
                com.heytap.accessory.a_renamed.a_renamed.d_renamed(TAG, "Data send failed, connection closed!");
                throw new java.io.IOException("Failed to send, connection closed!");
            }
            int iSend = this.mAdapter.send(this.mConnectedPeer, this.mConnectionId, i_renamed, aVar.a_renamed(), false, aVar.c_renamed(), aVar.b_renamed(), i2, z_renamed);
            if (iSend != 0) {
                if (iSend == 20005) {
                    this.mIsConnected = 2;
                    com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Write failed: Connection closed");
                    throw new java.io.IOException("Write failed:Connection already closed");
                }
                if (iSend == 20006) {
                    com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Write failed. Attempt to write on_renamed invalid channel:".concat(java.lang.String.valueOf(i_renamed)));
                    throw new java.lang.IllegalArgumentException("Write failed. Attempt to write on_renamed invalid channel:".concat(java.lang.String.valueOf(i_renamed)));
                }
                if (iSend != 20007) {
                    com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Write failed. status:".concat(java.lang.String.valueOf(iSend)));
                } else {
                    com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Write failed: Timed out!");
                    close();
                    throw new java.io.IOException("Write failed: Timed out!");
                }
            }
        } catch (com.heytap.accessory.bean.GeneralException e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "Send failed!", e_renamed);
            throw new java.io.IOException("Send Failed", e_renamed);
        }
    }

    public void close() {
        if (this.mIsConnected == 1) {
            this.mIsConnected = 2;
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, this.mAdapter.getPackageName() + " requested to close socket for Peer:" + this.mConnectedPeer.getAgentId());
            requestClose();
            return;
        }
        com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "Connection is_renamed already closed");
    }

    public void cleanupChannel(java.lang.String str, int i_renamed) {
        try {
            this.mAdapter.cleanupChannel(str, i_renamed);
        } catch (com.heytap.accessory.bean.GeneralException e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "cleanupChannel failed.".concat(java.lang.String.valueOf(i_renamed)), e_renamed);
        }
    }

    void initiateServiceconnection(final java.lang.String str, final com.heytap.accessory.bean.PeerAgent peerAgent, com.heytap.accessory.BaseAdapter baseAdapter, com.heytap.accessory.BaseSocket.a_renamed aVar) {
        this.mConnectedPeer = peerAgent;
        this.mConnectionStatusCallback = aVar;
        this.mAdapter = baseAdapter;
        startSocketHandler(str, peerAgent.getAgentId());
        this.mSocketHandler.post(new java.lang.Runnable() { // from class: com.heytap.accessory.BaseSocket.1
            @Override // java.lang.Runnable
            public final void run() {
                int errorCode;
                try {
                    byte b2 = 0;
                    errorCode = com.heytap.accessory.BaseSocket.this.mAdapter.requestServiceConnection(str, peerAgent, new com.heytap.accessory.BaseSocket.ServiceConnectionCallback(com.heytap.accessory.BaseSocket.this, b2), new com.heytap.accessory.BaseSocket.ServiceChannelCallback(com.heytap.accessory.BaseSocket.this, b2));
                } catch (com.heytap.accessory.bean.GeneralException e_renamed) {
                    com.heytap.accessory.a_renamed.a_renamed.b_renamed(com.heytap.accessory.BaseSocket.TAG, "Failed to initiate connection!", e_renamed);
                    errorCode = e_renamed.getErrorCode();
                }
                if (errorCode == 0) {
                    com.heytap.accessory.a_renamed.a_renamed.c_renamed(com.heytap.accessory.BaseSocket.TAG, "Connection request enqued successfully for peer:" + peerAgent.getAgentId());
                    return;
                }
                com.heytap.accessory.a_renamed.a_renamed.c_renamed(com.heytap.accessory.BaseSocket.TAG, "Connection request failed for peer:" + peerAgent.getAgentId() + " Reason:" + errorCode + " Cleaning up_renamed now");
                if (com.heytap.accessory.BaseSocket.this.mConnectionStatusCallback != null) {
                    com.heytap.accessory.BaseSocket.this.mConnectionStatusCallback.a_renamed(peerAgent, errorCode);
                }
                com.heytap.accessory.BaseSocket.this.cleanupSocket();
            }
        });
    }

    void acceptServiceConnection(final java.lang.String str, final com.heytap.accessory.bean.PeerAgent peerAgent, final com.heytap.accessory.BaseAdapter baseAdapter, com.heytap.accessory.BaseSocket.a_renamed aVar) {
        this.mConnectedPeer = peerAgent;
        this.mAdapter = baseAdapter;
        this.mConnectionStatusCallback = aVar;
        startSocketHandler(str, peerAgent.getAgentId());
        this.mSocketHandler.post(new java.lang.Runnable() { // from class: com.heytap.accessory.BaseSocket.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    byte b2 = 0;
                    android.os.Bundle bundleAcceptServiceConnection = baseAdapter.acceptServiceConnection(str, peerAgent, peerAgent.getTransactionId(), new com.heytap.accessory.BaseSocket.ServiceConnectionCallback(com.heytap.accessory.BaseSocket.this, b2), new com.heytap.accessory.BaseSocket.ServiceChannelCallback(com.heytap.accessory.BaseSocket.this, b2));
                    java.lang.String string = bundleAcceptServiceConnection.getString("connectionId");
                    long[] longArray = bundleAcceptServiceConnection.getLongArray(com.heytap.accessory.constant.AFConstants.EXTRA_CHANNEL_ID);
                    java.lang.String str2 = com.heytap.accessory.BaseSocket.TAG;
                    java.lang.StringBuilder sb = new java.lang.StringBuilder("Connection accepted successfully. connection Id:");
                    sb.append(string);
                    sb.append(" channel Id count:");
                    sb.append(longArray == null ? 0 : longArray.length);
                    com.heytap.accessory.a_renamed.a_renamed.b_renamed(str2, sb.toString());
                    com.heytap.accessory.BaseSocket.this.handleConnectionResponse(string, longArray, 0);
                } catch (com.heytap.accessory.bean.GeneralException e_renamed) {
                    com.heytap.accessory.a_renamed.a_renamed.e_renamed(com.heytap.accessory.BaseSocket.TAG, "Failed to accept service connection: " + e_renamed.getMessage());
                    com.heytap.accessory.BaseSocket.this.handleConnectionResponse(null, null, e_renamed.getErrorCode());
                }
            }
        });
    }

    public com.heytap.accessory.bean.TrafficReport getTrafficReport(java.lang.String str, int i_renamed) {
        if (this.mTrafficReportMap == null) {
            return null;
        }
        return this.mTrafficReportMap.get(getDataKey(str, i_renamed));
    }

    private void cacheTrafficReport(java.lang.String str, int i_renamed, com.heytap.accessory.bean.TrafficReport trafficReport) {
        if (this.mTrafficReportMap == null) {
            this.mTrafficReportMap = new java.util.HashMap();
        }
        this.mTrafficReportMap.put(getDataKey(str, i_renamed), trafficReport);
    }

    private boolean startSocketHandler(java.lang.String str, java.lang.String str2) {
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("Socket:" + str + DATA_KEY + str2);
        handlerThread.setUncaughtExceptionHandler(new java.lang.Thread.UncaughtExceptionHandler() { // from class: com.heytap.accessory.BaseSocket.3
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public final void uncaughtException(java.lang.Thread thread, final java.lang.Throwable th) {
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(com.heytap.accessory.BaseSocket.TAG, "Exception in_renamed Socket background thread:" + thread.getName() + "exception: " + th.getMessage());
                thread.interrupt();
                new android.os.Handler(android.os.Looper.getMainLooper()).post(new java.lang.Runnable() { // from class: com.heytap.accessory.BaseSocket.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        throw new java.lang.RuntimeException(th);
                    }
                });
            }
        });
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "socketHandlerThread start");
        handlerThread.start();
        android.os.Looper looper = handlerThread.getLooper();
        if (looper == null) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Failed get Looper for Socket: initiator:" + str + " Peer Id:" + str2);
            return false;
        }
        this.mSocketHandler = new com.heytap.accessory.BaseSocket.b_renamed(this, looper);
        return true;
    }

    private void requestClose() {
        try {
            int iCloseServiceConnection = this.mAdapter.closeServiceConnection(this.mConnectionId);
            if (iCloseServiceConnection == 20005) {
                com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "Connection is_renamed already closed");
                return;
            }
            if (iCloseServiceConnection == 0) {
                com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "Connection " + this.mConnectionId + " close requested successfully");
            }
        } catch (com.heytap.accessory.bean.GeneralException e_renamed) {
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "Failed to close connection!", e_renamed);
        }
    }

    void forceClose() {
        if (this.mIsConnected == 1) {
            this.mIsConnected = 3;
            android.os.Message messageObtainMessage = this.mSocketHandler.obtainMessage(1);
            messageObtainMessage.arg1 = 20001;
            android.os.Bundle bundle = new android.os.Bundle();
            try {
                bundle.putLong("connectionId", java.lang.Long.parseLong(this.mConnectionId));
            } catch (java.lang.NumberFormatException e_renamed) {
                com.heytap.accessory.a_renamed.a_renamed.a_renamed(TAG, e_renamed);
            }
            messageObtainMessage.obj = bundle;
            this.mSocketHandler.sendMessage(messageObtainMessage);
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "Socket:" + this.mConnectionId + " has been force closed!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cleanupSocket() {
        this.mSocketHandler.removeCallbacksAndMessages(null);
        this.mSocketHandler.a_renamed();
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "SocketHandler quit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleConnectionResponse(java.lang.String str, long[] jArr, int i_renamed) {
        if (this.mConnectionStatusCallback == null) {
            com.heytap.accessory.a_renamed.a_renamed.d_renamed(TAG, "Connection status callback not found! Ignoring response");
            return;
        }
        if (str == null) {
            com.heytap.accessory.a_renamed.a_renamed.d_renamed(TAG, "connectionId is_renamed null so cleaning up_renamed");
            this.mConnectionStatusCallback.a_renamed(this.mConnectedPeer, i_renamed);
            cleanupSocket();
            return;
        }
        this.mConnectionId = str;
        this.mIsConnected = 1;
        com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onServiceConnectionResponse:" + this.mConnectedPeer);
        this.mAvailableChannelIdList = com.heytap.accessory.b_renamed.a_renamed.a_renamed(jArr);
        this.mConnectionStatusCallback.a_renamed(this.mConnectedPeer, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleConnectionLoss(long j_renamed, int i_renamed) {
        if (i_renamed == 20001) {
            this.mIsConnected = 3;
        } else {
            this.mIsConnected = 2;
        }
        onServiceConnectionLost(j_renamed, i_renamed);
        handleServiceConnectionLostErrorCode(i_renamed);
        cleanupSocket();
    }

    private void handleServiceConnectionLostErrorCode(int i_renamed) {
        if (i_renamed == 0) {
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onServiceConnectionLost() -> CONNECTION_LOST_PEER_DISCONNECTED");
            return;
        }
        if (i_renamed == 1) {
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onServiceConnectionLost() -> CONNECTION_LOST_DEVICE_DETACHED");
            return;
        }
        if (i_renamed == 2) {
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onServiceConnectionLost() -> CONNECTION_LOST_RETRANSMISSION_FAILED");
            return;
        }
        if (i_renamed == 3) {
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onServiceConnectionLost() -> CONNECTION_LOST_UNKNOWN_REASON");
        } else if (i_renamed == 20001) {
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onServiceConnectionLost() -> ERROR_FATAL");
        } else {
            com.heytap.accessory.a_renamed.a_renamed.d_renamed(TAG, "onServiceConnectionLost() error_code: ".concat(java.lang.String.valueOf(i_renamed)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleIncomingData(int i_renamed, android.os.Bundle bundle) {
        if (this.mIsConnected != 1) {
            com.heytap.accessory.a_renamed.a_renamed.d_renamed(TAG, "Ignoring data, socket is_renamed not yet established");
            return;
        }
        byte[] byteArray = bundle.getByteArray(com.heytap.accessory.constant.AFConstants.EXTRA_READ_BYTES);
        if (byteArray == null) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Failed to reassemble! - null data received!");
            return;
        }
        int i2 = bundle.getInt(com.heytap.accessory.constant.AFConstants.EXTRA_READ_LENGHT);
        int i3 = bundle.getInt(com.heytap.accessory.constant.AFConstants.EXTRA_READ_OFFSET);
        cacheTrafficReport(this.mConnectionId, i_renamed, com.heytap.accessory.bean.TrafficReport.createFromBundle(bundle));
        if (!com.heytap.accessory.api.ManagerConfig.ACCESSORY_FRAMEWORK_PACKAGE.equals(this.mAdapter.getPackageName())) {
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "handleIncomingData: " + byteArray.length + " [" + i3 + ", " + i2 + "]");
        }
        try {
            byte[] bArrA = com.heytap.accessory.b_renamed.a_renamed.e_renamed.b_renamed(i2).a_renamed();
            com.heytap.accessory.b_renamed.i_renamed.a_renamed(byteArray, i3, bArrA, 0, i2);
            onReceive(java.lang.Long.parseLong(this.mConnectionId), i_renamed, bArrA);
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
        } finally {
            this.mAdapter.recycle(byteArray);
        }
    }

    private static java.lang.String getDataKey(java.lang.String str, int i_renamed) {
        return str + DATA_KEY + i_renamed;
    }

    final class ServiceChannelCallback extends com.heytap.accessory.api.IServiceChannelCallback.Stub {
        /* synthetic */ ServiceChannelCallback(com.heytap.accessory.BaseSocket baseSocket, byte b2) {
            this();
        }

        private ServiceChannelCallback() {
        }

        @Override // com.heytap.accessory.api.IServiceChannelCallback
        public final void a_renamed(android.os.Bundle bundle) throws android.os.RemoteException {
            if (bundle.containsKey(com.heytap.accessory.constant.AFConstants.EXTRA_ERROR_CODE)) {
                android.os.Message messageObtainMessage = com.heytap.accessory.BaseSocket.this.mSocketHandler.obtainMessage(3);
                messageObtainMessage.arg1 = bundle.getInt(com.heytap.accessory.constant.AFConstants.EXTRA_ERROR_CODE);
                com.heytap.accessory.BaseSocket.this.mSocketHandler.sendMessage(messageObtainMessage);
                return;
            }
            com.heytap.accessory.a_renamed.a_renamed.d_renamed(com.heytap.accessory.BaseSocket.TAG, "onChannelError with no error code!");
        }

        @Override // com.heytap.accessory.api.IServiceChannelCallback
        public final void b_renamed(android.os.Bundle bundle) throws android.os.RemoteException {
            long j_renamed = bundle.getLong(com.heytap.accessory.constant.AFConstants.EXTRA_CHANNEL_ID);
            android.os.Message messageObtainMessage = com.heytap.accessory.BaseSocket.this.mSocketHandler.obtainMessage(2);
            messageObtainMessage.arg1 = (int) j_renamed;
            messageObtainMessage.obj = bundle;
            com.heytap.accessory.BaseSocket.this.mSocketHandler.sendMessage(messageObtainMessage);
        }
    }

    final class ServiceConnectionCallback extends com.heytap.accessory.api.IServiceConnectionCallback.Stub {
        /* synthetic */ ServiceConnectionCallback(com.heytap.accessory.BaseSocket baseSocket, byte b2) {
            this();
        }

        private ServiceConnectionCallback() {
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(com.heytap.accessory.BaseSocket.TAG, "ServiceConnectionCallback new");
        }

        @Override // com.heytap.accessory.api.IServiceConnectionCallback
        public final void a_renamed(android.os.Bundle bundle) throws android.os.RemoteException {
            if (!bundle.containsKey(com.heytap.accessory.constant.AFConstants.EXTRA_ERROR_CODE)) {
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(com.heytap.accessory.BaseSocket.TAG, "onConnectionLost with no error code!");
                return;
            }
            android.os.Bundle bundle2 = new android.os.Bundle();
            bundle2.putLong("connectionId", bundle.getLong("connectionId"));
            android.os.Message messageObtainMessage = com.heytap.accessory.BaseSocket.this.mSocketHandler.obtainMessage(1);
            messageObtainMessage.arg1 = bundle.getInt(com.heytap.accessory.constant.AFConstants.EXTRA_ERROR_CODE);
            messageObtainMessage.obj = bundle2;
            com.heytap.accessory.BaseSocket.this.mSocketHandler.sendMessage(messageObtainMessage);
        }

        @Override // com.heytap.accessory.api.IServiceConnectionCallback
        public final void b_renamed(android.os.Bundle bundle) throws android.os.RemoteException {
            android.os.Message messageObtainMessage = com.heytap.accessory.BaseSocket.this.mSocketHandler.obtainMessage(4);
            messageObtainMessage.arg1 = bundle.getInt(com.heytap.accessory.constant.AFConstants.EXTRA_ERROR_CODE, 10012);
            messageObtainMessage.obj = bundle.getString("connectionId", null);
            messageObtainMessage.setData(bundle);
            com.heytap.accessory.BaseSocket.this.mSocketHandler.sendMessage(messageObtainMessage);
        }
    }

    static final class b_renamed extends android.os.Handler {

        /* renamed from: a_renamed, reason: collision with root package name */
        com.heytap.accessory.BaseSocket f3197a;

        public b_renamed(com.heytap.accessory.BaseSocket baseSocket, android.os.Looper looper) {
            super(looper);
            this.f3197a = baseSocket;
        }

        @Override // android.os.Handler
        public final synchronized void handleMessage(android.os.Message message) {
            int i_renamed = message.what;
            if (i_renamed == 1) {
                android.os.Bundle bundle = (android.os.Bundle) message.obj;
                if (bundle != null) {
                    this.f3197a.handleConnectionLoss(bundle.getLong("connectionId"), message.arg1);
                    return;
                } else {
                    com.heytap.accessory.a_renamed.a_renamed.e_renamed(com.heytap.accessory.BaseSocket.TAG, "MESSAGE_SERVICE_CONNECTION_LOSS: (bundle==null)");
                    this.f3197a.handleConnectionLoss(0L, message.arg1);
                    return;
                }
            }
            if (i_renamed == 2) {
                this.f3197a.handleIncomingData(message.arg1, (android.os.Bundle) message.obj);
                return;
            }
            if (i_renamed != 4) {
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(com.heytap.accessory.BaseSocket.TAG, "Invalid message: " + message.what);
                return;
            }
            android.os.Bundle data = message.getData();
            this.f3197a.handleConnectionResponse((java.lang.String) message.obj, data != null ? data.getLongArray(com.heytap.accessory.constant.AFConstants.EXTRA_CHANNEL_ID) : null, message.arg1);
        }

        public final synchronized void a_renamed() {
            super.getLooper().quit();
            this.f3197a = null;
        }
    }

    public java.lang.String getConnectionId() {
        return this.mConnectionId;
    }

    public int getServiceChannelSize() {
        java.util.List<java.lang.Long> list = this.mAvailableChannelIdList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public int getServiceChannelId(int i_renamed) {
        if (this.mAvailableChannelIdList == null) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Failed because Service Profile is_renamed null");
            return -1;
        }
        if (i_renamed >= 0 && i_renamed < getServiceChannelSize()) {
            return this.mAvailableChannelIdList.get(i_renamed).intValue();
        }
        com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Failed because of_renamed wrong index");
        return -1;
    }
}
