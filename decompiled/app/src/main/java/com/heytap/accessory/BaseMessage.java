package com.heytap.accessory;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import com.heytap.accessory.api.IMsgExpCallback;
import com.heytap.accessory.bean.GeneralException;
import com.heytap.accessory.bean.PeerAgent;
import com.heytap.accessory.bean.UnSupportException;
import com.heytap.accessory.constant.AFConstants;
import com.heytap.accessory.p103a.SdkLog;
import com.heytap.accessory.p104b.SdkConfig;
import com.heytap.accessory.p104b.SystemUtils_2;
import com.heytap.accessory.p104b.p105a.Buffer;
import com.heytap.accessory.p104b.p105a.BufferException;
import com.heytap.accessory.p104b.p105a.BufferPool;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public abstract class BaseMessage {
    public static final String ACTION_ACCESSORY_MESSAGE_DISABLED = "com.heytap.accessory.action.MESSAGE_DISABLED";
    public static final String ACTION_ACCESSORY_MESSAGE_ENABLED = "com.heytap.accessory.action.MESSAGE_ENABLED";
    public static final String ACTION_ACCESSORY_MESSAGE_RECEIVED = "com.heytap.accessory.action.MESSAGE_RECEIVED";
    public static final int ERROR_LOCAL_PEER_AGENT_NOT_SUPPORTED = 10104;
    public static final int ERROR_NONE = 0;
    public static final int ERROR_PEER_AGENT_INVALID = 10109;
    public static final int ERROR_PEER_AGENT_NOT_SUPPORTED = 10105;
    public static final int ERROR_PEER_AGENT_NO_RESPONSE = 10103;
    public static final int ERROR_PEER_AGENT_UNREACHABLE = 10102;
    public static final int ERROR_PEER_SERVICE_NOT_SUPPORTED = 10106;
    public static final int ERROR_SERVICE_NOT_SUPPORTED = 10107;
    public static final int ERROR_TIMED_OUT = 10108;
    public static final int ERROR_TRANSACTION_FAILED = 10110;
    public static final int ERROR_UNKNOWN = 10101;
    public static final String EXTRA_PEER_ACCESSORY = "com.heytap.accessory.device.extra.PeerAccessory";
    private static final int INVALID_ID = -1;
    private static final String MESSAGE_KEY = "_";
    private static final String TAG = "BaseMessage";
    private BaseAdapter mAdapter;
    private String mAgentId;
    private Handler mHandler;
    private MexCallback mMexCallback;

    int checkMexFeature(PeerAgent peerAgent) {
        return 0;
    }

    protected abstract void onError(PeerAgent peerAgent, int OplusGLSurfaceView_13, int i2);

    protected abstract void onReceive(PeerAgent peerAgent, byte[] bArr);

    protected abstract void onSent(PeerAgent peerAgent, int OplusGLSurfaceView_13);

    protected BaseMessage(BaseAgent baseAgent) {
        if (baseAgent == null) {
            SdkLog.m8383e(TAG, "BaseMessage() - empty agent instance!");
            throw new IllegalArgumentException("Message creation failed! - invalid agent instance supplied");
        }
        init(baseAgent.getApplicationContext(), baseAgent.getAgentHandler(), baseAgent.registerMessageInstance(this));
    }

    protected BaseMessage(BaseJobAgent baseJobAgent) {
        if (baseJobAgent == null) {
            SdkLog.m8383e(TAG, "BaseMessage() - empty agent instance!");
            throw new IllegalArgumentException("Message creation failed! - invalid agent instance supplied");
        }
        init(baseJobAgent.getApplicationContext(), baseJobAgent.getAgentHandler(), baseJobAgent.registerMessageInstance(this));
    }

    private void init(Context context, Handler handler, String str) {
        this.mAdapter = BaseAdapter.getDefaultAdapter(context);
        this.mMexCallback = new MexCallback(this);
        this.mHandler = handler;
        if (str != null) {
            try {
                registerAgent(str);
            } catch (GeneralException COUIBaseListPopupWindow_8) {
                SdkLog.m8383e(TAG, "Failed to create BaseMessage instance: " + COUIBaseListPopupWindow_8.getMessage());
            }
        }
    }

    public int send(PeerAgent peerAgent, byte[] bArr) throws UnSupportException, IOException {
        return sendMessage(peerAgent, bArr, false);
    }

    public int secureSend(PeerAgent peerAgent, byte[] bArr) throws UnSupportException, IOException {
        return sendMessage(peerAgent, bArr, true);
    }

    void registerAgent(String str) throws GeneralException {
        String str2 = this.mAgentId;
        if (str2 != null && !str.equalsIgnoreCase(str2)) {
            this.mAdapter.unregisterMexCallback(this.mAgentId);
        }
        this.mAgentId = str;
        this.mAdapter.registerMexCallback(str, this.mMexCallback);
    }

    void unregisterAgent() {
        try {
            if (this.mAgentId != null) {
                this.mAdapter.unregisterMexCallback(this.mAgentId);
            }
        } catch (GeneralException COUIBaseListPopupWindow_8) {
            SdkLog.m8383e(TAG, "Failed to un-register Mex callback! " + COUIBaseListPopupWindow_8.getLocalizedMessage());
        }
    }

    void postAsynch(Bundle bundle) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(new RunnableC2143a(this, bundle, true));
        }
    }

    private int sendMessage(PeerAgent peerAgent, byte[] bArr, boolean z) throws UnSupportException, IOException {
        int encryptionPaddingLength;
        if (peerAgent == null) {
            SdkLog.m8383e(TAG, "Send: peerAgent null");
            throw new IllegalArgumentException("Send Message Failed! - Peer Agent is invalid!");
        }
        if (bArr == null) {
            SdkLog.m8383e(TAG, "Send: data null");
            throw new IllegalArgumentException("Invalid data to send!");
        }
        if (bArr.length == 0) {
            SdkLog.m8383e(TAG, "Send: invalid data length 0");
            throw new IllegalArgumentException("Invalid data length 0");
        }
        if (bArr.length > peerAgent.getMaxAllowedDataSize()) {
            SdkLog.m8383e(TAG, "Send: Data too big:" + bArr.length);
            throw new IllegalArgumentException("Data Too long..! Data size:" + bArr.length + "Max allowed Size:" + peerAgent.getMaxAllowedDataSize() + " .Please check PeerAgent.getMaxAllowedDataSize()");
        }
        if (this.mAgentId == null) {
            SdkLog.m8383e(TAG, "Send: agentId not retrieved!");
            throw new IOException("Failed to send message - Agent info empty!");
        }
        int iCheckMexFeature = checkMexFeature(peerAgent);
        SdkLog.m8378b(TAG, "checkMexFeature ".concat(String.valueOf(iCheckMexFeature)));
        if (iCheckMexFeature != 0) {
            onError(peerAgent, -1, iCheckMexFeature);
            return -1;
        }
        if (checkMessageUnSupport(peerAgent)) {
            throw new UnSupportException("the peer agent doesn't support the message feature, please check");
        }
        int iSendMessage = ERROR_TRANSACTION_FAILED;
        Buffer c2153aM8541a = null;
        try {
            if (z) {
                try {
                    encryptionPaddingLength = peerAgent.getAccessory().getEncryptionPaddingLength();
                } catch (BufferException COUIBaseListPopupWindow_8) {
                    SdkLog.m8383e(TAG, "BufferException: " + COUIBaseListPopupWindow_8.getLocalizedMessage());
                    if (0 != 0) {
                    }
                } catch (IOException e2) {
                    SdkLog.m8383e(TAG, "Send Message Failed! <" + ERROR_TRANSACTION_FAILED + " " + e2.getLocalizedMessage());
                    throw e2;
                }
            } else {
                encryptionPaddingLength = 0;
            }
            c2153aM8541a = BufferPool.m8541a(SdkConfig.m8595b() + bArr.length + encryptionPaddingLength + SdkConfig.m8597c());
            c2153aM8541a.m8535a(SdkConfig.m8595b());
            c2153aM8541a.m8536a(bArr, 0, bArr.length);
            try {
                iSendMessage = this.mAdapter.sendMessage(this.mAgentId, peerAgent.getAgentId(), peerAgent.getAccessory().getId(), c2153aM8541a.m8537a(), z, bArr.length, c2153aM8541a.m8538b());
                if (iSendMessage <= 0) {
                    String strConcat = "Send Message Failed - internal error! transId ".concat(String.valueOf(iSendMessage));
                    SdkLog.m8378b(TAG, "transId : ".concat(String.valueOf(iSendMessage)));
                    throw new IOException(strConcat);
                }
                SdkLog.m8378b(TAG, "msg<" + iSendMessage + "> sent: " + bArr.length);
                if (c2153aM8541a != null) {
                    SdkLog.m8378b(TAG, "messageBuffer: recycle");
                    c2153aM8541a.m8540d();
                }
                return iSendMessage;
            } catch (GeneralException e3) {
                throw new IOException("Send Message Failed", e3);
            }
        } catch (Throwable th) {
            if (0 != 0) {
                SdkLog.m8378b(TAG, "messageBuffer: recycle");
                c2153aM8541a.m8540d();
            }
            throw th;
        }
    }

    private void sendMessageDeliveryStatus(long OplusGLSurfaceView_15, String str, int OplusGLSurfaceView_13, int i2) throws IOException {
        try {
            this.mAdapter.sendMessageDeliveryStatus(OplusGLSurfaceView_15, str, OplusGLSurfaceView_13, i2);
        } catch (GeneralException COUIBaseListPopupWindow_8) {
            SdkLog.m8383e(TAG, "Ack failed! ".concat(String.valueOf(COUIBaseListPopupWindow_8)));
            throw new IOException("Send Failed", COUIBaseListPopupWindow_8);
        }
    }

    private boolean checkMessageUnSupport(PeerAgent peerAgent) {
        return peerAgent == null || peerAgent.getAccessory() == null || !peerAgent.getAccessory().supportMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postStatusAsynch(Bundle bundle) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(new RunnableC2143a(this, bundle, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onMessageReceived(Bundle bundle) {
        if (this.mAgentId == null) {
            SdkLog.m8383e(TAG, "onMessageReceived(): Agent info empty!");
            return;
        }
        bundle.setClassLoader(PeerAgent.class.getClassLoader());
        byte[] byteArray = bundle.getByteArray(AFConstants.EXTRA_READ_BYTES);
        int OplusGLSurfaceView_13 = bundle.getInt(AFConstants.EXTRA_READ_LENGHT);
        int i2 = bundle.getInt(AFConstants.EXTRA_READ_OFFSET);
        PeerAgent peerAgent = (PeerAgent) bundle.getParcelable(AFConstants.EXTRA_PEER_AGENT);
        int i3 = bundle.getInt("transactionId");
        if (peerAgent != null && peerAgent.getAccessory() != null) {
            long id_renamed = peerAgent.getAccessory().getId();
            int i4 = 0;
            if (byteArray == null) {
                i4 = ERROR_UNKNOWN;
            } else {
                try {
                    SdkLog.m8378b(TAG, "onMessageReceived data:" + OplusGLSurfaceView_13 + " bytes length:" + byteArray.length + " bytes: " + new String(byteArray));
                    byte[] bArr = new byte[OplusGLSurfaceView_13];
                    SystemUtils_2.m8609a(byteArray, i2, bArr, 0, OplusGLSurfaceView_13);
                    onReceive(peerAgent, bArr);
                } catch (Exception COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                    return;
                } finally {
                    this.mAdapter.recycle(byteArray);
                }
            }
            int i5 = i4;
            try {
                SdkLog.m8378b(TAG, "onMessageReceived, sendMessageDeliveryStatus");
                sendMessageDeliveryStatus(id_renamed, peerAgent.getAgentId(), i3, i5);
                return;
            } catch (IOException e2) {
                SdkLog.m8383e(TAG, "Failed to send message status! " + e2.getLocalizedMessage());
                return;
            }
        }
        SdkLog.m8383e(TAG, "onMessageReceived(): PeerAgent is null!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStatusReceived(Bundle bundle) {
        bundle.setClassLoader(PeerAgent.class.getClassLoader());
        PeerAgent peerAgent = (PeerAgent) bundle.getParcelable(AFConstants.EXTRA_PEER_AGENT);
        int OplusGLSurfaceView_13 = bundle.getInt("transactionId");
        int i2 = bundle.getInt(AFConstants.EXTRA_ERROR_CODE);
        if (i2 == 0) {
            onSent(peerAgent, OplusGLSurfaceView_13);
        } else {
            onError(peerAgent, OplusGLSurfaceView_13, i2);
        }
    }

    private static String getMessageKey(String str, long OplusGLSurfaceView_15, String str2) {
        return str + MESSAGE_KEY + OplusGLSurfaceView_15 + MESSAGE_KEY + str2;
    }

    static class MexCallback extends IMsgExpCallback.Stub {

        /* renamed from: PlatformImplementations.kt_3 */
        private WeakReference<BaseMessage> f9385a;

        MexCallback(BaseMessage baseMessage) {
            this.f9385a = new WeakReference<>(baseMessage);
        }

        @Override // com.heytap.accessory.api.IMsgExpCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8360a(Bundle bundle) throws RemoteException {
            BaseMessage baseMessage = this.f9385a.get();
            if (baseMessage == null) {
                SdkLog.m8383e(BaseMessage.TAG, "onMessageReceived(): BaseMessage referecnce is null!");
            } else {
                baseMessage.postAsynch(bundle);
            }
        }

        @Override // com.heytap.accessory.api.IMsgExpCallback
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo8361b(Bundle bundle) throws RemoteException {
            BaseMessage baseMessage = this.f9385a.get();
            if (baseMessage == null) {
                SdkLog.m8383e(BaseMessage.TAG, "onMessageReceived(): BaseMessage referecnce is null!");
            } else {
                baseMessage.postStatusAsynch(bundle);
            }
        }
    }

    /* renamed from: com.heytap.accessory.BaseMessage$PlatformImplementations.kt_3 */
    static class RunnableC2143a implements Runnable {

        /* renamed from: PlatformImplementations.kt_3 */
        private WeakReference<BaseMessage> f9386a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private Bundle f9387b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private boolean f9388c;

        RunnableC2143a(BaseMessage baseMessage, Bundle bundle, boolean z) {
            this.f9386a = new WeakReference<>(baseMessage);
            this.f9387b = bundle;
            this.f9388c = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BaseMessage baseMessage = this.f9386a.get();
            if (baseMessage == null) {
                SdkLog.m8383e(BaseMessage.TAG, "run(): BaseMessage referecnce is null!");
            } else if (this.f9388c) {
                baseMessage.onMessageReceived(this.f9387b);
            } else {
                baseMessage.onStatusReceived(this.f9387b);
            }
        }
    }
}
