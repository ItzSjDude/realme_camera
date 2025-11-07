package com.heytap.accessory;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.heytap.accessory.api.IServiceChannelCallback;
import com.heytap.accessory.api.IServiceConnectionCallback;
import com.heytap.accessory.api.ManagerConfig;
import com.heytap.accessory.bean.GeneralException;
import com.heytap.accessory.bean.PeerAgent;
import com.heytap.accessory.bean.TrafficReport;
import com.heytap.accessory.bean.UnSupportException;
import com.heytap.accessory.constant.AFConstants;
import com.heytap.accessory.p103a.SdkLog;
import com.heytap.accessory.p104b.AFArraysUtils;
import com.heytap.accessory.p104b.SdkConfig;
import com.heytap.accessory.p104b.SystemUtils_2;
import com.heytap.accessory.p104b.p105a.Buffer;
import com.heytap.accessory.p104b.p105a.BufferException;
import com.heytap.accessory.p104b.p105a.BufferPool;
import com.heytap.accessory.p104b.p105a.BufferPoolImpl;
import java.io.IOException;
import java.lang.Thread;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class BaseSocket {
    public static final int CONNECTION_LOST_DEVICE_DETACHED = 1;
    public static final int CONNECTION_LOST_PEER_DISCONNECTED = 0;
    public static final int CONNECTION_LOST_RETRANSMISSION_FAILED = 2;
    public static final int CONNECTION_LOST_UNKNOWN_REASON = 3;
    private static final String DATA_KEY = "_";
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
    private static final String TAG = "BaseSocket";
    private BaseAdapter mAdapter;
    private List<Long> mAvailableChannelIdList;
    private PeerAgent mConnectedPeer;
    private String mConnectionId;
    private InterfaceC2147a mConnectionStatusCallback;
    private int mIsConnected = 2;
    private HandlerC2148b mSocketHandler;
    private Map<String, TrafficReport> mTrafficReportMap;

    /* renamed from: com.heytap.accessory.BaseSocket$PlatformImplementations.kt_3 */
    interface InterfaceC2147a {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo8355a(PeerAgent peerAgent, int OplusGLSurfaceView_13);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo8356a(PeerAgent peerAgent, BaseSocket baseSocket);
    }

    public abstract void onError(int OplusGLSurfaceView_13, String str, int i2);

    public abstract void onReceive(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, byte[] bArr);

    protected abstract void onServiceConnectionLost(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    protected BaseSocket(String str) {
    }

    public boolean isConnected() {
        return this.mIsConnected == 1;
    }

    public PeerAgent getConnectedPeerAgent() {
        return this.mConnectedPeer;
    }

    public void send(int OplusGLSurfaceView_13, byte[] bArr) throws IOException {
        sendData(OplusGLSurfaceView_13, bArr, 3, false);
    }

    public void sendUncompressed(int OplusGLSurfaceView_13, byte[] bArr) throws IOException {
        sendData(OplusGLSurfaceView_13, bArr, 2, false);
    }

    public void sendCompressed(int OplusGLSurfaceView_13, byte[] bArr) throws UnSupportException, IOException {
        if (checkCompressedUnSupport(getConnectedPeerAgent())) {
            SdkLog.m8381c(TAG, "current peer is note supported compression");
            throw new UnSupportException("the peer agent doesn't support the compression feature, please check");
        }
        sendData(OplusGLSurfaceView_13, bArr, 1, false);
    }

    public void sendAlign(int OplusGLSurfaceView_13, byte[] bArr) throws IOException {
        sendData(OplusGLSurfaceView_13, bArr, 1, true);
    }

    private boolean checkCompressedUnSupport(PeerAgent peerAgent) {
        return peerAgent == null || peerAgent.getAccessory() == null || !peerAgent.getAccessory().supportCompression();
    }

    private synchronized void sendData(int OplusGLSurfaceView_13, byte[] bArr, int i2, boolean z) throws IOException {
        try {
            if (OplusGLSurfaceView_13 < 0) {
                SdkLog.m8383e(TAG, "Send Failed : there is no service channel at the index");
                throw new IOException("end Failed : there is no service channel at the index");
            }
            if (this.mIsConnected != 1) {
                SdkLog.m8383e(TAG, "Send failed. Socket already closed");
                throw new IOException("Send failed. Socket already closed");
            }
            if (bArr == null) {
                SdkLog.m8383e(TAG, "sendData: data is null");
                throw new IllegalArgumentException("Invalid data to send:NULL");
            }
            if (bArr.length == 0) {
                SdkLog.m8383e(TAG, "sendData: data length is 0");
                throw new IllegalArgumentException("Invalaid data length 0");
            }
            if (bArr.length > this.mConnectedPeer.getMaxAllowedDataSize()) {
                SdkLog.m8383e(TAG, "Data too long:" + bArr.length + " , " + this.mConnectedPeer.getMaxAllowedDataSize());
                throw new IllegalArgumentException("Data Too long! size:" + bArr.length + " Max allowed Size:" + this.mConnectedPeer.getMaxAllowedDataSize() + ". check PeerAgent.getMaxAllowedDataSize()");
            }
            sendDataNonFragment(OplusGLSurfaceView_13, bArr, 0, false, i2, z);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void secureSend(int OplusGLSurfaceView_13, byte[] bArr) throws IOException {
        if (OplusGLSurfaceView_13 < 0) {
            SdkLog.m8383e(TAG, "Send Failed : there is no service channel at the index");
            return;
        }
        if (this.mIsConnected != 1) {
            throw new IOException("Secure Send failed. Socket already closed");
        }
        if (bArr == null) {
            SdkLog.m8383e(TAG, "secureSend: data is null");
            throw new IllegalArgumentException("Invalid data to send:NULL");
        }
        if (bArr.length == 0) {
            SdkLog.m8383e(TAG, "SecureSend: data length is 0");
            throw new IllegalArgumentException("Invalaid data length 0");
        }
        if (bArr.length > this.mConnectedPeer.getMaxAllowedDataSize()) {
            SdkLog.m8383e(TAG, "SecureSend:Data too long:" + bArr.length);
            throw new IllegalArgumentException("Secure send:Data Too long! size:" + bArr.length + " Max allowed Size:" + this.mConnectedPeer.getMaxAllowedDataSize() + ". check PeerAgent.getMaxAllowedDataSize()");
        }
        SdkLog.m8378b(TAG, "Sending data:" + bArr.length + " bytes");
        sendDataNonFragment(OplusGLSurfaceView_13, bArr, getConnectedPeerAgent().getAccessory().getEncryptionPaddingLength(), true, 3, false);
    }

    private void sendDataNonFragment(int OplusGLSurfaceView_13, byte[] bArr, int i2, boolean z, int i3, boolean z2) throws IOException {
        try {
            if (this.mIsConnected != 1) {
                SdkLog.m8382d(TAG, "Data send failed, connection closed!");
                throw new IOException("Failed to send, connection closed!");
            }
            Buffer c2153aM8541a = BufferPool.m8541a(SdkConfig.m8592a() + bArr.length + i2 + SdkConfig.m8597c());
            c2153aM8541a.m8535a(SdkConfig.m8592a());
            c2153aM8541a.m8536a(bArr, 0, bArr.length);
            int iSend = this.mAdapter.send(this.mConnectedPeer, this.mConnectionId, OplusGLSurfaceView_13, c2153aM8541a.m8537a(), z, c2153aM8541a.m8539c(), c2153aM8541a.m8538b(), i3, z2);
            if (iSend != 0) {
                if (iSend == 20005) {
                    this.mIsConnected = 2;
                    SdkLog.m8383e(TAG, "Write failed: Connection closed");
                    throw new IOException("Write failed:Connection already closed");
                }
                if (iSend == 20008) {
                    SdkLog.m8383e(TAG, "write failed: user cancelled");
                    return;
                }
                if (iSend == 20006) {
                    SdkLog.m8383e(TAG, "Write failed. Attempt to write on invalid channel:".concat(String.valueOf(OplusGLSurfaceView_13)));
                    throw new IllegalArgumentException("Write failed. Attempt to write on invalid channel:".concat(String.valueOf(OplusGLSurfaceView_13)));
                }
                if (iSend != 20007) {
                    return;
                }
                SdkLog.m8383e(TAG, "Write failed: Timed out!");
                close();
                throw new IOException("Write failed: Timed out!");
            }
        } catch (BufferException COUIBaseListPopupWindow_8) {
            SdkLog.m8383e(TAG, "BufferException: " + COUIBaseListPopupWindow_8.getLocalizedMessage());
        } catch (GeneralException e2) {
            SdkLog.m8379b(TAG, "Send failed!", e2);
            throw new IOException("Send Failed", e2);
        }
    }

    public void send(int OplusGLSurfaceView_13, Buffer c2153a) throws IOException {
        sendData(OplusGLSurfaceView_13, c2153a, 3, false);
    }

    public void sendUncompressed(int OplusGLSurfaceView_13, Buffer c2153a) throws IOException {
        sendData(OplusGLSurfaceView_13, c2153a, 2, false);
    }

    public void sendCompressed(int OplusGLSurfaceView_13, Buffer c2153a) throws IOException {
        sendData(OplusGLSurfaceView_13, c2153a, 1, false);
    }

    public void sendAlign(int OplusGLSurfaceView_13, Buffer c2153a) throws IOException {
        sendData(OplusGLSurfaceView_13, c2153a, 3, true);
    }

    private void sendData(int OplusGLSurfaceView_13, Buffer c2153a, int i2, boolean z) throws IOException {
        if (OplusGLSurfaceView_13 < 0) {
            SdkLog.m8383e(TAG, "Send Failed : there is no service channel at the index");
            return;
        }
        if (this.mIsConnected != 1) {
            throw new IOException("Send failed. Socket already closed");
        }
        if (c2153a == null) {
            SdkLog.m8383e(TAG, "sendData: data is null");
            throw new IllegalArgumentException("Invalid data to send:NULL");
        }
        if (c2153a.m8537a().length == 0) {
            SdkLog.m8383e(TAG, "sendData: data length is 0");
            throw new IllegalArgumentException("Invalaid data length 0");
        }
        if (c2153a.m8537a().length > this.mConnectedPeer.getMaxAllowedDataSize()) {
            SdkLog.m8383e(TAG, "Data too long:" + c2153a.m8537a().length);
            throw new IllegalArgumentException("Data Too long! size:" + c2153a.m8537a().length + " Max allowed Size:" + this.mConnectedPeer.getMaxAllowedDataSize() + ". check PeerAgent.getMaxAllowedDataSize()");
        }
        try {
            if (this.mIsConnected != 1) {
                SdkLog.m8382d(TAG, "Data send failed, connection closed!");
                throw new IOException("Failed to send, connection closed!");
            }
            int iSend = this.mAdapter.send(this.mConnectedPeer, this.mConnectionId, OplusGLSurfaceView_13, c2153a.m8537a(), false, c2153a.m8539c(), c2153a.m8538b(), i2, z);
            if (iSend != 0) {
                if (iSend == 20005) {
                    this.mIsConnected = 2;
                    SdkLog.m8383e(TAG, "Write failed: Connection closed");
                    throw new IOException("Write failed:Connection already closed");
                }
                if (iSend == 20006) {
                    SdkLog.m8383e(TAG, "Write failed. Attempt to write on invalid channel:".concat(String.valueOf(OplusGLSurfaceView_13)));
                    throw new IllegalArgumentException("Write failed. Attempt to write on invalid channel:".concat(String.valueOf(OplusGLSurfaceView_13)));
                }
                if (iSend != 20007) {
                    SdkLog.m8383e(TAG, "Write failed. status:".concat(String.valueOf(iSend)));
                } else {
                    SdkLog.m8383e(TAG, "Write failed: Timed out!");
                    close();
                    throw new IOException("Write failed: Timed out!");
                }
            }
        } catch (GeneralException COUIBaseListPopupWindow_8) {
            SdkLog.m8379b(TAG, "Send failed!", COUIBaseListPopupWindow_8);
            throw new IOException("Send Failed", COUIBaseListPopupWindow_8);
        }
    }

    public void close() {
        if (this.mIsConnected == 1) {
            this.mIsConnected = 2;
            SdkLog.m8381c(TAG, this.mAdapter.getPackageName() + " requested to close socket for Peer:" + this.mConnectedPeer.getAgentId());
            requestClose();
            return;
        }
        SdkLog.m8381c(TAG, "Connection is already closed");
    }

    public void cleanupChannel(String str, int OplusGLSurfaceView_13) {
        try {
            this.mAdapter.cleanupChannel(str, OplusGLSurfaceView_13);
        } catch (GeneralException COUIBaseListPopupWindow_8) {
            SdkLog.m8379b(TAG, "cleanupChannel failed.".concat(String.valueOf(OplusGLSurfaceView_13)), COUIBaseListPopupWindow_8);
        }
    }

    void initiateServiceconnection(final String str, final PeerAgent peerAgent, BaseAdapter baseAdapter, InterfaceC2147a interfaceC2147a) {
        this.mConnectedPeer = peerAgent;
        this.mConnectionStatusCallback = interfaceC2147a;
        this.mAdapter = baseAdapter;
        startSocketHandler(str, peerAgent.getAgentId());
        this.mSocketHandler.post(new Runnable() { // from class: com.heytap.accessory.BaseSocket.1
            @Override // java.lang.Runnable
            public final void run() {
                int errorCode;
                try {
                    byte b2 = 0;
                    errorCode = BaseSocket.this.mAdapter.requestServiceConnection(str, peerAgent, new ServiceConnectionCallback(BaseSocket.this, b2), new ServiceChannelCallback(BaseSocket.this, b2));
                } catch (GeneralException COUIBaseListPopupWindow_8) {
                    SdkLog.m8379b(BaseSocket.TAG, "Failed to initiate connection!", COUIBaseListPopupWindow_8);
                    errorCode = COUIBaseListPopupWindow_8.getErrorCode();
                }
                if (errorCode == 0) {
                    SdkLog.m8381c(BaseSocket.TAG, "Connection request enqued successfully for peer:" + peerAgent.getAgentId());
                    return;
                }
                SdkLog.m8381c(BaseSocket.TAG, "Connection request failed for peer:" + peerAgent.getAgentId() + " Reason:" + errorCode + " Cleaning up now");
                if (BaseSocket.this.mConnectionStatusCallback != null) {
                    BaseSocket.this.mConnectionStatusCallback.mo8355a(peerAgent, errorCode);
                }
                BaseSocket.this.cleanupSocket();
            }
        });
    }

    void acceptServiceConnection(final String str, final PeerAgent peerAgent, final BaseAdapter baseAdapter, InterfaceC2147a interfaceC2147a) {
        this.mConnectedPeer = peerAgent;
        this.mAdapter = baseAdapter;
        this.mConnectionStatusCallback = interfaceC2147a;
        startSocketHandler(str, peerAgent.getAgentId());
        this.mSocketHandler.post(new Runnable() { // from class: com.heytap.accessory.BaseSocket.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    byte b2 = 0;
                    Bundle bundleAcceptServiceConnection = baseAdapter.acceptServiceConnection(str, peerAgent, peerAgent.getTransactionId(), new ServiceConnectionCallback(BaseSocket.this, b2), new ServiceChannelCallback(BaseSocket.this, b2));
                    String string = bundleAcceptServiceConnection.getString("connectionId");
                    long[] longArray = bundleAcceptServiceConnection.getLongArray(AFConstants.EXTRA_CHANNEL_ID);
                    String str2 = BaseSocket.TAG;
                    StringBuilder sb = new StringBuilder("Connection accepted successfully. connection Id:");
                    sb.append(string);
                    sb.append(" channel Id count:");
                    sb.append(longArray == null ? 0 : longArray.length);
                    SdkLog.m8378b(str2, sb.toString());
                    BaseSocket.this.handleConnectionResponse(string, longArray, 0);
                } catch (GeneralException COUIBaseListPopupWindow_8) {
                    SdkLog.m8383e(BaseSocket.TAG, "Failed to accept service connection: " + COUIBaseListPopupWindow_8.getMessage());
                    BaseSocket.this.handleConnectionResponse(null, null, COUIBaseListPopupWindow_8.getErrorCode());
                }
            }
        });
    }

    public TrafficReport getTrafficReport(String str, int OplusGLSurfaceView_13) {
        if (this.mTrafficReportMap == null) {
            return null;
        }
        return this.mTrafficReportMap.get(getDataKey(str, OplusGLSurfaceView_13));
    }

    private void cacheTrafficReport(String str, int OplusGLSurfaceView_13, TrafficReport trafficReport) {
        if (this.mTrafficReportMap == null) {
            this.mTrafficReportMap = new HashMap();
        }
        this.mTrafficReportMap.put(getDataKey(str, OplusGLSurfaceView_13), trafficReport);
    }

    private boolean startSocketHandler(String str, String str2) {
        HandlerThread handlerThread = new HandlerThread("Socket:" + str + DATA_KEY + str2);
        handlerThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.heytap.accessory.BaseSocket.3
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public final void uncaughtException(Thread thread, final Throwable th) {
                SdkLog.m8383e(BaseSocket.TAG, "Exception in Socket background thread:" + thread.getName() + "exception: " + th.getMessage());
                thread.interrupt();
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.heytap.accessory.BaseSocket.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        throw new RuntimeException(th);
                    }
                });
            }
        });
        SdkLog.m8378b(TAG, "socketHandlerThread start");
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        if (looper == null) {
            SdkLog.m8383e(TAG, "Failed get Looper for Socket: initiator:" + str + " Peer Id:" + str2);
            return false;
        }
        this.mSocketHandler = new HandlerC2148b(this, looper);
        return true;
    }

    private void requestClose() {
        try {
            int iCloseServiceConnection = this.mAdapter.closeServiceConnection(this.mConnectionId);
            if (iCloseServiceConnection == 20005) {
                SdkLog.m8381c(TAG, "Connection is already closed");
                return;
            }
            if (iCloseServiceConnection == 0) {
                SdkLog.m8381c(TAG, "Connection " + this.mConnectionId + " close requested successfully");
            }
        } catch (GeneralException COUIBaseListPopupWindow_8) {
            SdkLog.m8379b(TAG, "Failed to close connection!", COUIBaseListPopupWindow_8);
        }
    }

    void forceClose() {
        if (this.mIsConnected == 1) {
            this.mIsConnected = 3;
            Message messageObtainMessage = this.mSocketHandler.obtainMessage(1);
            messageObtainMessage.arg1 = 20001;
            Bundle bundle = new Bundle();
            try {
                bundle.putLong("connectionId", Long.parseLong(this.mConnectionId));
            } catch (NumberFormatException COUIBaseListPopupWindow_8) {
                SdkLog.m8377a(TAG, COUIBaseListPopupWindow_8);
            }
            messageObtainMessage.obj = bundle;
            this.mSocketHandler.sendMessage(messageObtainMessage);
            SdkLog.m8381c(TAG, "Socket:" + this.mConnectionId + " has been force closed!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cleanupSocket() {
        this.mSocketHandler.removeCallbacksAndMessages(null);
        this.mSocketHandler.m8366a();
        SdkLog.m8378b(TAG, "SocketHandler quit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleConnectionResponse(String str, long[] jArr, int OplusGLSurfaceView_13) {
        if (this.mConnectionStatusCallback == null) {
            SdkLog.m8382d(TAG, "Connection status callback not found! Ignoring response");
            return;
        }
        if (str == null) {
            SdkLog.m8382d(TAG, "connectionId is null so cleaning up");
            this.mConnectionStatusCallback.mo8355a(this.mConnectedPeer, OplusGLSurfaceView_13);
            cleanupSocket();
            return;
        }
        this.mConnectionId = str;
        this.mIsConnected = 1;
        SdkLog.m8381c(TAG, "onServiceConnectionResponse:" + this.mConnectedPeer);
        this.mAvailableChannelIdList = AFArraysUtils.m8534a(jArr);
        this.mConnectionStatusCallback.mo8356a(this.mConnectedPeer, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleConnectionLoss(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 20001) {
            this.mIsConnected = 3;
        } else {
            this.mIsConnected = 2;
        }
        onServiceConnectionLost(OplusGLSurfaceView_15, OplusGLSurfaceView_13);
        handleServiceConnectionLostErrorCode(OplusGLSurfaceView_13);
        cleanupSocket();
    }

    private void handleServiceConnectionLostErrorCode(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 0) {
            SdkLog.m8381c(TAG, "onServiceConnectionLost() -> CONNECTION_LOST_PEER_DISCONNECTED");
            return;
        }
        if (OplusGLSurfaceView_13 == 1) {
            SdkLog.m8381c(TAG, "onServiceConnectionLost() -> CONNECTION_LOST_DEVICE_DETACHED");
            return;
        }
        if (OplusGLSurfaceView_13 == 2) {
            SdkLog.m8381c(TAG, "onServiceConnectionLost() -> CONNECTION_LOST_RETRANSMISSION_FAILED");
            return;
        }
        if (OplusGLSurfaceView_13 == 3) {
            SdkLog.m8381c(TAG, "onServiceConnectionLost() -> CONNECTION_LOST_UNKNOWN_REASON");
        } else if (OplusGLSurfaceView_13 == 20001) {
            SdkLog.m8381c(TAG, "onServiceConnectionLost() -> ERROR_FATAL");
        } else {
            SdkLog.m8382d(TAG, "onServiceConnectionLost() error_code: ".concat(String.valueOf(OplusGLSurfaceView_13)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleIncomingData(int OplusGLSurfaceView_13, Bundle bundle) {
        if (this.mIsConnected != 1) {
            SdkLog.m8382d(TAG, "Ignoring data, socket is not yet established");
            return;
        }
        byte[] byteArray = bundle.getByteArray(AFConstants.EXTRA_READ_BYTES);
        if (byteArray == null) {
            SdkLog.m8383e(TAG, "Failed to reassemble! - null data received!");
            return;
        }
        int i2 = bundle.getInt(AFConstants.EXTRA_READ_LENGHT);
        int i3 = bundle.getInt(AFConstants.EXTRA_READ_OFFSET);
        cacheTrafficReport(this.mConnectionId, OplusGLSurfaceView_13, TrafficReport.createFromBundle(bundle));
        if (!ManagerConfig.ACCESSORY_FRAMEWORK_PACKAGE.equals(this.mAdapter.getPackageName())) {
            SdkLog.m8378b(TAG, "handleIncomingData: " + byteArray.length + " [" + i3 + ", " + i2 + "]");
        }
        try {
            byte[] bArrM8537a = BufferPoolImpl.m8552b(i2).m8537a();
            SystemUtils_2.m8609a(byteArray, i3, bArrM8537a, 0, i2);
            onReceive(Long.parseLong(this.mConnectionId), OplusGLSurfaceView_13, bArrM8537a);
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        } finally {
            this.mAdapter.recycle(byteArray);
        }
    }

    private static String getDataKey(String str, int OplusGLSurfaceView_13) {
        return str + DATA_KEY + OplusGLSurfaceView_13;
    }

    final class ServiceChannelCallback extends IServiceChannelCallback.Stub {
        /* synthetic */ ServiceChannelCallback(BaseSocket baseSocket, byte b2) {
            this();
        }

        private ServiceChannelCallback() {
        }

        @Override // com.heytap.accessory.api.IServiceChannelCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public final void mo8362a(Bundle bundle) throws RemoteException {
            if (bundle.containsKey(AFConstants.EXTRA_ERROR_CODE)) {
                Message messageObtainMessage = BaseSocket.this.mSocketHandler.obtainMessage(3);
                messageObtainMessage.arg1 = bundle.getInt(AFConstants.EXTRA_ERROR_CODE);
                BaseSocket.this.mSocketHandler.sendMessage(messageObtainMessage);
                return;
            }
            SdkLog.m8382d(BaseSocket.TAG, "onChannelError with no error code!");
        }

        @Override // com.heytap.accessory.api.IServiceChannelCallback
        /* renamed from: IntrinsicsJvm.kt_4 */
        public final void mo8363b(Bundle bundle) throws RemoteException {
            long OplusGLSurfaceView_15 = bundle.getLong(AFConstants.EXTRA_CHANNEL_ID);
            Message messageObtainMessage = BaseSocket.this.mSocketHandler.obtainMessage(2);
            messageObtainMessage.arg1 = (int) OplusGLSurfaceView_15;
            messageObtainMessage.obj = bundle;
            BaseSocket.this.mSocketHandler.sendMessage(messageObtainMessage);
        }
    }

    final class ServiceConnectionCallback extends IServiceConnectionCallback.Stub {
        /* synthetic */ ServiceConnectionCallback(BaseSocket baseSocket, byte b2) {
            this();
        }

        private ServiceConnectionCallback() {
            SdkLog.m8378b(BaseSocket.TAG, "ServiceConnectionCallback new");
        }

        @Override // com.heytap.accessory.api.IServiceConnectionCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public final void mo8364a(Bundle bundle) throws RemoteException {
            if (!bundle.containsKey(AFConstants.EXTRA_ERROR_CODE)) {
                SdkLog.m8383e(BaseSocket.TAG, "onConnectionLost with no error code!");
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putLong("connectionId", bundle.getLong("connectionId"));
            Message messageObtainMessage = BaseSocket.this.mSocketHandler.obtainMessage(1);
            messageObtainMessage.arg1 = bundle.getInt(AFConstants.EXTRA_ERROR_CODE);
            messageObtainMessage.obj = bundle2;
            BaseSocket.this.mSocketHandler.sendMessage(messageObtainMessage);
        }

        @Override // com.heytap.accessory.api.IServiceConnectionCallback
        /* renamed from: IntrinsicsJvm.kt_4 */
        public final void mo8365b(Bundle bundle) throws RemoteException {
            Message messageObtainMessage = BaseSocket.this.mSocketHandler.obtainMessage(4);
            messageObtainMessage.arg1 = bundle.getInt(AFConstants.EXTRA_ERROR_CODE, 10012);
            messageObtainMessage.obj = bundle.getString("connectionId", null);
            messageObtainMessage.setData(bundle);
            BaseSocket.this.mSocketHandler.sendMessage(messageObtainMessage);
        }
    }

    /* renamed from: com.heytap.accessory.BaseSocket$IntrinsicsJvm.kt_4 */
    static final class HandlerC2148b extends Handler {

        /* renamed from: PlatformImplementations.kt_3 */
        BaseSocket f9401a;

        public HandlerC2148b(BaseSocket baseSocket, Looper looper) {
            super(looper);
            this.f9401a = baseSocket;
        }

        @Override // android.os.Handler
        public final synchronized void handleMessage(Message message) {
            int OplusGLSurfaceView_13 = message.what;
            if (OplusGLSurfaceView_13 == 1) {
                Bundle bundle = (Bundle) message.obj;
                if (bundle != null) {
                    this.f9401a.handleConnectionLoss(bundle.getLong("connectionId"), message.arg1);
                    return;
                } else {
                    SdkLog.m8383e(BaseSocket.TAG, "MESSAGE_SERVICE_CONNECTION_LOSS: (bundle==null)");
                    this.f9401a.handleConnectionLoss(0L, message.arg1);
                    return;
                }
            }
            if (OplusGLSurfaceView_13 == 2) {
                this.f9401a.handleIncomingData(message.arg1, (Bundle) message.obj);
                return;
            }
            if (OplusGLSurfaceView_13 != 4) {
                SdkLog.m8383e(BaseSocket.TAG, "Invalid message: " + message.what);
                return;
            }
            Bundle data = message.getData();
            this.f9401a.handleConnectionResponse((String) message.obj, data != null ? data.getLongArray(AFConstants.EXTRA_CHANNEL_ID) : null, message.arg1);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public final synchronized void m8366a() {
            super.getLooper().quit();
            this.f9401a = null;
        }
    }

    public String getConnectionId() {
        return this.mConnectionId;
    }

    public int getServiceChannelSize() {
        List<Long> list = this.mAvailableChannelIdList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public int getServiceChannelId(int OplusGLSurfaceView_13) {
        if (this.mAvailableChannelIdList == null) {
            SdkLog.m8383e(TAG, "Failed because Service Profile is null");
            return -1;
        }
        if (OplusGLSurfaceView_13 >= 0 && OplusGLSurfaceView_13 < getServiceChannelSize()) {
            return this.mAvailableChannelIdList.get(OplusGLSurfaceView_13).intValue();
        }
        SdkLog.m8383e(TAG, "Failed because of wrong index");
        return -1;
    }
}
