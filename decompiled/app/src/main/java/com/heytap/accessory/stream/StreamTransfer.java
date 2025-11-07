package com.heytap.accessory.stream;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.heytap.accessory.BaseAgent;
import com.heytap.accessory.BaseJobAgent;
import com.heytap.accessory.bean.GeneralException;
import com.heytap.accessory.bean.PeerAgent;
import com.heytap.accessory.bean.SdkUnsupportedException;
import com.heytap.accessory.bean.UnSupportException;
import com.heytap.accessory.p103a.SdkLog;
import com.heytap.accessory.p104b.BroadcastUtils;
import com.heytap.accessory.stream.p109b.CallingAgentInfo_3;
import com.heytap.accessory.stream.p109b.CancelStreamRequest;
import com.heytap.accessory.stream.p109b.STOperateEntity;
import java.io.FileDescriptor;
import java.io.InputStream;
import java.lang.Thread;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;

/* loaded from: classes2.dex */
public class StreamTransfer {
    public static final String ACTION_STREAM_TRANSFER_REQUESTED = "com.heytap.accessory.streamconnection";
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
    public static final String RECEIVE_PFD = "receivePfd";
    private static final int ST_CANCEL_TRANS_ID = -1;
    private static final int ST_DEFAULT_CONNECTION_ID = 0;
    private static final int ST_DEFAULT_TRANS_ID = 0;
    private static final String TAG = "StreamTransfer";
    private String mAgentName;
    private Object mCallingAgent;
    private CallingAgentInfo_3 mCallingAgentInfo;
    private ConcurrentHashMap<Long, Boolean> mConnectionMap;
    private Context mContext;
    private EventListener mEventListener;
    private HandlerC2242c mHandler;
    private InterfaceC2241b mLocalCallback;
    private HandlerThread mStreamTransferHandlerThread;
    private ConcurrentHashMap<Long, ConcurrentHashMap<Integer, CallingAgentInfo_3.PlatformImplementations.kt_3>> mTransactionsMap;
    private ConcurrentHashMap<Long, ConcurrentHashMap<Integer, Boolean>> mTransferRequestMap;

    public interface EventListener {
        void onCancelAllCompleted(int OplusGLSurfaceView_13, int i2);

        void onStreamReceived(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, InputStream inputStream);

        void onTransferCompleted(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, int i2);

        void onTransferRequested(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, int i2);
    }

    /* renamed from: com.heytap.accessory.stream.StreamTransfer$IntrinsicsJvm.kt_4 */
    public interface InterfaceC2241b {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo8685a(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, int i2);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo8686a(int[] iArr, int OplusGLSurfaceView_13);
    }

    public StreamTransfer(BaseAgent baseAgent, EventListener eventListener) throws SdkUnsupportedException {
        this(baseAgent, baseAgent.getApplicationContext(), eventListener);
    }

    public StreamTransfer(BaseJobAgent baseJobAgent, EventListener eventListener) throws SdkUnsupportedException {
        this(baseJobAgent, baseJobAgent.getApplicationContext(), eventListener);
    }

    public StreamTransfer(Object obj, Context context, EventListener eventListener) throws SdkUnsupportedException {
        this.mTransactionsMap = new ConcurrentHashMap<>();
        this.mConnectionMap = new ConcurrentHashMap<>();
        this.mTransferRequestMap = new ConcurrentHashMap<>();
        this.mLocalCallback = new InterfaceC2241b() { // from class: com.heytap.accessory.stream.StreamTransfer.1
            @Override // com.heytap.accessory.stream.StreamTransfer.InterfaceC2241b
            /* renamed from: PlatformImplementations.kt_3 */
            public final void mo8685a(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, int i2) {
                ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) StreamTransfer.this.mTransactionsMap.get(Long.valueOf(OplusGLSurfaceView_15));
                if (concurrentHashMap != null) {
                    EventListener eventListener2 = StreamTransfer.this.mEventListener;
                    for (Map.Entry entry : concurrentHashMap.entrySet()) {
                        if (((CallingAgentInfo_3.PlatformImplementations.kt_3) entry.getValue()).f9686b == OplusGLSurfaceView_13 && eventListener2 != null) {
                            StreamTransfer.this.handleOnTransferCompletedErrorCode(i2);
                            eventListener2.onTransferCompleted(OplusGLSurfaceView_15, ((Integer) entry.getKey()).intValue(), i2);
                            StreamTransfer.this.removeTransaction(OplusGLSurfaceView_15, ((Integer) entry.getKey()).intValue());
                            StreamTransfer.this.removeTransactionRequest(OplusGLSurfaceView_15, OplusGLSurfaceView_13);
                            return;
                        }
                    }
                    if (!StreamTransfer.this.getTransactionRequestState(OplusGLSurfaceView_15, OplusGLSurfaceView_13) || i2 != 9) {
                        if (!StreamTransfer.this.containsTransactionRequestKey(OplusGLSurfaceView_15, OplusGLSurfaceView_13) || StreamTransfer.this.containsTransactionKey(OplusGLSurfaceView_15, OplusGLSurfaceView_13) || eventListener2 == null) {
                            return;
                        }
                        StreamTransfer.this.handleOnTransferCompletedErrorCode(i2);
                        eventListener2.onTransferCompleted(OplusGLSurfaceView_15, OplusGLSurfaceView_13, i2);
                        StreamTransfer.this.removeTransactionRequest(OplusGLSurfaceView_15, OplusGLSurfaceView_13);
                        StreamTransfer.this.removeTransactionByTransId(OplusGLSurfaceView_13);
                        return;
                    }
                    SdkLog.m8378b(StreamTransfer.TAG, "Ignoring onTransferCompleted because setup in progress");
                    return;
                }
                SdkLog.m8383e(StreamTransfer.TAG, "connectionId =" + OplusGLSurfaceView_15 + "not exits");
            }

            @Override // com.heytap.accessory.stream.StreamTransfer.InterfaceC2241b
            /* renamed from: PlatformImplementations.kt_3 */
            public final void mo8686a(int[] iArr, int OplusGLSurfaceView_13) {
                for (int i2 : iArr) {
                    Iterator it = StreamTransfer.this.mTransactionsMap.keySet().iterator();
                    while (it.hasNext()) {
                        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) StreamTransfer.this.mTransactionsMap.get(Long.valueOf(((Long) it.next()).longValue()));
                        if (concurrentHashMap != null) {
                            for (Map.Entry entry : concurrentHashMap.entrySet()) {
                                if (((CallingAgentInfo_3.PlatformImplementations.kt_3) entry.getValue()).f9686b == i2 && StreamTransfer.this.mEventListener != null) {
                                    StreamTransfer.this.removeTransactionByTransId(((Integer) entry.getKey()).intValue());
                                }
                            }
                        }
                    }
                }
                EventListener eventListener2 = StreamTransfer.this.mEventListener;
                if (eventListener2 != null) {
                    StreamTransfer.this.handleOnCancelAllCompletedErrorCode(OplusGLSurfaceView_13);
                    eventListener2.onCancelAllCompleted(-1, OplusGLSurfaceView_13);
                }
            }
        };
        if (obj != null && eventListener != null) {
            this.mCallingAgent = obj;
            this.mContext = context;
            this.mAgentName = obj.getClass().getName();
            SdkLog.m8378b(TAG, "new StreamTransfer: " + this.mAgentName + ", hashcode:" + hashCode());
            this.mEventListener = eventListener;
            StreamInitializer.initialize(this.mContext);
            if (register()) {
                return;
            }
            SdkLog.m8378b(TAG, "Agent already registered");
            this.mCallingAgentInfo = StreamTransferManager.m8698b(this.mAgentName);
            CallingAgentInfo_3 c2245a = this.mCallingAgentInfo;
            if (c2245a != null) {
                this.mStreamTransferHandlerThread = c2245a.m8715c();
                this.mHandler = (HandlerC2242c) this.mCallingAgentInfo.m8716d();
                this.mTransactionsMap = this.mCallingAgentInfo.m8717e();
                this.mCallingAgentInfo.m8712a(this.mEventListener);
                this.mCallingAgentInfo.m8713a(this.mLocalCallback);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("StreamEventCallback parameter cannot be null");
    }

    @Deprecated
    public int send(PeerAgent peerAgent, InputStream inputStream, int OplusGLSurfaceView_13) throws UnSupportException {
        return send(peerAgent, inputStream, (FileDescriptor) null);
    }

    @Deprecated
    public int send(PeerAgent peerAgent, FileDescriptor fileDescriptor, int OplusGLSurfaceView_13) throws UnSupportException {
        return send(peerAgent, (InputStream) null, fileDescriptor);
    }

    public int send(PeerAgent peerAgent, InputStream inputStream) throws UnSupportException {
        return send(peerAgent, inputStream, (FileDescriptor) null);
    }

    public int send(PeerAgent peerAgent, FileDescriptor fileDescriptor) throws UnSupportException {
        return send(peerAgent, (InputStream) null, fileDescriptor);
    }

    private int send(PeerAgent peerAgent, InputStream inputStream, FileDescriptor fileDescriptor) throws UnSupportException {
        int iM8704a = -1;
        if (validateParam(peerAgent)) {
            if (StreamInitializer.getStreamMsgPackageName(this.mContext) == null) {
                SdkLog.m8375a(TAG, "FTCore version doesnot support content uri");
            } else if (inputStream == null && fileDescriptor == null) {
                SdkLog.m8383e(TAG, "input source is wrong!!");
                return -1;
            }
            CallingAgentInfo_3.PlatformImplementations.kt_3 aVar = new CallingAgentInfo_3.PlatformImplementations.kt_3();
            try {
                if (inputStream == null) {
                    iM8704a = StreamTransferManager.m8691a(this.mContext, this.mAgentName).m8703a(this.mContext, this.mAgentName, this.mLocalCallback, peerAgent, fileDescriptor);
                } else {
                    iM8704a = StreamTransferManager.m8691a(this.mContext, this.mAgentName).m8704a(this.mContext, this.mAgentName, this.mLocalCallback, peerAgent, inputStream);
                }
            } catch (GeneralException | IllegalAccessException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
            SdkLog.m8378b(TAG, "received tx from STCore".concat(String.valueOf(iM8704a)));
            aVar.f9686b = iM8704a;
            putTransaction(0L, iM8704a, aVar);
        }
        return iM8704a;
    }

    private boolean validateParam(PeerAgent peerAgent) throws UnSupportException {
        if (peerAgent == null) {
            throw new IllegalArgumentException("PeerAgent cannot be null");
        }
        if (checkStreamUnSupport(peerAgent)) {
            throw new UnSupportException("the peer agent doesn't support the stream feature, please check");
        }
        Object obj = this.mCallingAgent;
        if (obj == null || this.mEventListener == null) {
            SdkLog.m8383e(TAG, "Using invalid instance of StreamTransfer(). Please re-register.");
            return false;
        }
        if (obj instanceof BaseJobAgent) {
            if (!((BaseJobAgent) obj).getSuccessfulConnections().isEmpty()) {
                return true;
            }
            SdkLog.m8383e(TAG, "current baseJobAgent has not setup service connection, please connect service first");
            return false;
        }
        if (!(obj instanceof BaseAgent) || !((BaseAgent) obj).getSuccessfulConnections().isEmpty()) {
            return true;
        }
        SdkLog.m8383e(TAG, "current baseAgent has not setup service connection, please connect service first");
        return false;
    }

    private boolean checkStreamUnSupport(PeerAgent peerAgent) {
        return peerAgent == null || peerAgent.getAccessory() == null || !peerAgent.getAccessory().supportStream();
    }

    public void receive(final long OplusGLSurfaceView_15, final int OplusGLSurfaceView_13) {
        SdkLog.m8381c(TAG, "receive task connectionId: " + OplusGLSurfaceView_15 + " ,transactionId:" + OplusGLSurfaceView_13 + ",hashCode:, " + hashCode());
        if (this.mCallingAgent == null || this.mEventListener == null) {
            SdkLog.m8378b(TAG, "Using invalid instance of StreamTransfer(). Please re-register.");
            putTransactionRequest(OplusGLSurfaceView_15, OplusGLSurfaceView_13, false);
            return;
        }
        if (!checkReceiveParams(OplusGLSurfaceView_15, OplusGLSurfaceView_13) || !containsTransactionRequestKey(OplusGLSurfaceView_15, OplusGLSurfaceView_13)) {
            SdkLog.m8378b(TAG, "TransactionId: Given[" + OplusGLSurfaceView_13 + "] not exist");
            putTransactionRequest(OplusGLSurfaceView_15, OplusGLSurfaceView_13, false);
            throw new IllegalArgumentException("Wrong filepath or transaction id_renamed used");
        }
        CallingAgentInfo_3.PlatformImplementations.kt_3 aVar = new CallingAgentInfo_3.PlatformImplementations.kt_3();
        aVar.f9685a = OplusGLSurfaceView_15;
        aVar.f9686b = OplusGLSurfaceView_13;
        putTransaction(OplusGLSurfaceView_15, OplusGLSurfaceView_13, aVar);
        putConnectionRequest(OplusGLSurfaceView_15, true);
        if (StreamInitializer.getStreamMsgPackageName(this.mContext) == null) {
            SdkLog.m8375a(TAG, "Accessory Framework doesn't support content URI !!");
        }
        this.mHandler.post(new Runnable() { // from class: com.heytap.accessory.stream.StreamTransfer.2
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r9v3, types: [int] */
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    try {
                        ParcelFileDescriptor parcelFileDescriptorM8706a = StreamTransferManager.m8691a(StreamTransfer.this.mContext, StreamTransfer.this.mAgentName).m8706a(StreamTransfer.this.mLocalCallback, OplusGLSurfaceView_15, OplusGLSurfaceView_13, true);
                        if (parcelFileDescriptorM8706a != null && StreamTransfer.this.mEventListener != null) {
                            StreamTransfer.this.mEventListener.onStreamReceived(OplusGLSurfaceView_15, OplusGLSurfaceView_13, new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptorM8706a));
                        }
                    } catch (Exception COUIBaseListPopupWindow_8) {
                        COUIBaseListPopupWindow_8.printStackTrace();
                    }
                } finally {
                    StreamTransfer.this.putTransactionRequest(OplusGLSurfaceView_15, OplusGLSurfaceView_13, false);
                }
            }
        });
    }

    public void reject(final long OplusGLSurfaceView_15, final int OplusGLSurfaceView_13) {
        if (this.mCallingAgent != null && this.mEventListener != null) {
            if (checkReceiveParams(OplusGLSurfaceView_15, OplusGLSurfaceView_13) && containsTransactionRequestKey(OplusGLSurfaceView_15, OplusGLSurfaceView_13)) {
                new CallingAgentInfo_3.PlatformImplementations.kt_3().f9686b = OplusGLSurfaceView_13;
                removeTransaction(OplusGLSurfaceView_15, OplusGLSurfaceView_13);
                this.mHandler.post(new Runnable() { // from class: com.heytap.accessory.stream.StreamTransfer.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            StreamTransferManager.m8691a(StreamTransfer.this.mContext, StreamTransfer.this.mAgentName).m8706a(null, OplusGLSurfaceView_15, OplusGLSurfaceView_13, false);
                        } catch (GeneralException | IllegalAccessException COUIBaseListPopupWindow_8) {
                            COUIBaseListPopupWindow_8.printStackTrace();
                        }
                    }
                });
                return;
            }
            throw new IllegalArgumentException("Wrong transaction id_renamed used in reject()");
        }
        SdkLog.m8378b(TAG, "Using invalid instance of StreamTransfer(). Please re-register.");
    }

    public void cancel(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
        if (this.mCallingAgent != null && this.mEventListener != null) {
            if (!containsTransactionKey(OplusGLSurfaceView_15, OplusGLSurfaceView_13)) {
                SdkLog.m8383e(TAG, "Wrong transaction id_renamed used for cancel");
                return;
            }
            try {
                CallingAgentInfo_3.PlatformImplementations.kt_3 transaction = getTransaction(OplusGLSurfaceView_15, OplusGLSurfaceView_13);
                if (transaction == null) {
                    SdkLog.m8378b(TAG, "cancelStream aborted because service connection or transaction already closed.");
                } else if (transaction.f9686b == 0) {
                    transaction.f9686b = -1;
                    SdkLog.m8378b(TAG, "Cancel called before transaction id_renamed is genereated".concat(String.valueOf(OplusGLSurfaceView_13)));
                } else if (transaction.f9686b == -1) {
                    SdkLog.m8378b(TAG, "Cancel called again before transaction id_renamed is genereated".concat(String.valueOf(OplusGLSurfaceView_13)));
                } else {
                    StreamTransferManager c2243aM8691a = StreamTransferManager.m8691a(this.mContext, this.mAgentName);
                    try {
                        try {
                            STOperateEntity c2249e = new STOperateEntity(3, new CancelStreamRequest(OplusGLSurfaceView_15, transaction.f9686b).m8719a());
                            if (c2243aM8691a.f9669a != null) {
                                c2243aM8691a.f9669a.f9673a.mo8621a(c2249e.m8723a().toString(), new Bundle());
                            }
                        } catch (JSONException COUIBaseListPopupWindow_8) {
                            COUIBaseListPopupWindow_8.printStackTrace();
                        }
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                }
                synchronized (this) {
                    this.mConnectionMap.remove(Long.valueOf(OplusGLSurfaceView_15));
                }
                return;
            } catch (GeneralException | IllegalAccessException e3) {
                e3.printStackTrace();
                return;
            }
        }
        SdkLog.m8378b(TAG, "Using invalid instance of StreamTransfer(). Please re-register.");
    }

    public void cancelAll() {
        SharedPreferences sharedPreferences;
        SdkLog.m8378b(TAG, "[cancelAll] Stream");
        if (this.mCallingAgent != null && this.mEventListener != null) {
            if (Build.VERSION.SDK_INT > 26) {
                sharedPreferences = this.mContext.createDeviceProtectedStorageContext().getSharedPreferences("AccessoryPreferences", 0);
            } else {
                sharedPreferences = this.mContext.getApplicationContext().getSharedPreferences("AccessoryPreferences", 0);
            }
            final String string = sharedPreferences.getString(this.mAgentName, null);
            if (string == null) {
                SdkLog.m8383e(TAG, "[cancelAll] Your service was not found. Please re-register");
                return;
            } else {
                this.mHandler.post(new Runnable() { // from class: com.heytap.accessory.stream.StreamTransfer.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            synchronized (StreamTransfer.this) {
                                for (Long OplusGLSurfaceView_14 : StreamTransfer.this.mTransactionsMap.keySet()) {
                                    Boolean bool = (Boolean) StreamTransfer.this.mConnectionMap.get(OplusGLSurfaceView_14);
                                    int iM8705a = (bool == null || !bool.booleanValue()) ? StreamTransferManager.m8691a(StreamTransfer.this.mContext, StreamTransfer.this.mAgentName).m8705a(string, 0L) : StreamTransferManager.m8691a(StreamTransfer.this.mContext, StreamTransfer.this.mAgentName).m8705a("0", OplusGLSurfaceView_14.longValue());
                                    EventListener eventListener = StreamTransfer.this.mEventListener;
                                    if (eventListener == null) {
                                        SdkLog.m8382d(StreamTransfer.TAG, "[cancelAll] listener is null.");
                                        return;
                                    }
                                    SdkLog.m8378b(StreamTransfer.TAG, "[cancelAll] cancel status ".concat(String.valueOf(iM8705a)));
                                    if (iM8705a == 0) {
                                        StreamTransfer.this.handleOnCancelAllCompletedErrorCode(12);
                                        eventListener.onCancelAllCompleted(-1, 12);
                                    } else if (iM8705a == 13) {
                                        StreamTransfer.this.handleOnCancelAllCompletedErrorCode(13);
                                        eventListener.onCancelAllCompleted(-1, 13);
                                    } else if (iM8705a == 17) {
                                        StreamTransfer.this.handleOnCancelAllCompletedErrorCode(17);
                                        eventListener.onCancelAllCompleted(-1, 17);
                                    }
                                }
                                StreamTransfer.this.mConnectionMap.clear();
                            }
                        } catch (GeneralException COUIBaseListPopupWindow_8) {
                            SdkLog.m8383e(StreamTransfer.TAG, "[cancelAll]".concat(String.valueOf(COUIBaseListPopupWindow_8)));
                            COUIBaseListPopupWindow_8.printStackTrace();
                        } catch (IllegalAccessException e2) {
                            e2.printStackTrace();
                            SdkLog.m8383e(StreamTransfer.TAG, "[cancelAll]".concat(String.valueOf(e2)));
                        }
                    }
                });
                return;
            }
        }
        SdkLog.m8378b(TAG, "[cancelAll] Using invalid instance of  Please re-register.");
    }

    public void close() {
        if (this.mCallingAgent != null && this.mEventListener != null) {
            SdkLog.m8378b(TAG, "stopStreamTransferService() called by : " + this.mAgentName);
            cancelAll();
            StreamTransferManager.m8693a(this.mAgentName);
            ConcurrentHashMap<Long, ConcurrentHashMap<Integer, CallingAgentInfo_3.PlatformImplementations.kt_3>> concurrentHashMap = this.mTransactionsMap;
            if (concurrentHashMap != null) {
                concurrentHashMap.clear();
            }
            HandlerC2242c handlerC2242c = this.mHandler;
            if (handlerC2242c != null) {
                handlerC2242c.removeCallbacksAndMessages(null);
                this.mHandler.getLooper().quit();
            }
            this.mCallingAgent = null;
            this.mEventListener = null;
            return;
        }
        SdkLog.m8378b(TAG, "Using invalid instance of StreamTransfer(). Please re-register.");
    }

    private boolean register() {
        StreamTransferManager.m8695a(this, this.mAgentName);
        this.mStreamTransferHandlerThread = new HandlerThread("StreamTransferHandlerThread");
        this.mStreamTransferHandlerThread.setUncaughtExceptionHandler(new C2240a((byte) 0));
        this.mStreamTransferHandlerThread.start();
        SdkLog.m8378b(TAG, "StreamTransferHandlerThread started");
        Looper looper = this.mStreamTransferHandlerThread.getLooper();
        if (looper != null) {
            this.mHandler = new HandlerC2242c(looper);
        }
        if (this.mHandler == null) {
            return false;
        }
        this.mTransactionsMap = new ConcurrentHashMap<>();
        this.mCallingAgentInfo = new CallingAgentInfo_3(this.mEventListener, this.mStreamTransferHandlerThread, this.mHandler, this.mLocalCallback, this.mTransactionsMap);
        StreamTransferManager.m8694a(this.mAgentName, this.mCallingAgentInfo);
        this.mHandler.post(new Runnable() { // from class: com.heytap.accessory.stream.StreamTransfer.5
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    StreamTransferManager.m8691a(StreamTransfer.this.mContext, StreamTransfer.this.mAgentName);
                } catch (GeneralException | IllegalAccessException COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                }
            }
        });
        return true;
    }

    public void informIncomingSTRequest(Context context, Intent intent) throws NumberFormatException {
        SharedPreferences sharedPreferences;
        final int intExtra = intent.getIntExtra("transId", -1);
        String stringExtra = intent.getStringExtra("agentClass");
        final long longExtra = intent.getLongExtra("connectionId", 0L);
        final int OplusGLSurfaceView_13 = Integer.parseInt(intent.getStringExtra("contId"));
        if (stringExtra == null) {
            if (Build.VERSION.SDK_INT > 26) {
                sharedPreferences = this.mContext.createDeviceProtectedStorageContext().getSharedPreferences("AccessoryPreferences", 0);
            } else {
                sharedPreferences = this.mContext.getApplicationContext().getSharedPreferences("AccessoryPreferences", 0);
            }
            stringExtra = sharedPreferences.getString(intent.getStringExtra("peerId"), null);
        }
        SdkLog.m8378b(TAG, "class now:" + stringExtra + " , " + hashCode());
        if (stringExtra == null) {
            SdkLog.m8383e(TAG, "Target agent was cleared. Re-registering");
            context.sendBroadcast(BroadcastUtils.m8569a(context.getPackageName()));
            return;
        }
        if (this.mCallingAgent == null) {
            SdkLog.m8383e(TAG, "Calling agent was cleared");
            return;
        }
        if (!stringExtra.equalsIgnoreCase(this.mAgentName)) {
            SdkLog.m8383e(TAG, "Class name not matched with " + this.mAgentName);
            return;
        }
        final CallingAgentInfo_3 c2245aM8698b = StreamTransferManager.m8698b(stringExtra);
        if (c2245aM8698b == null) {
            SdkLog.m8383e(TAG, "AgentInfo is NULL! Re-Registering");
            register();
            informIncomingSTRequest(context, intent);
        } else if (c2245aM8698b.m8711a() == null) {
            SdkLog.m8383e(TAG, "callback is not registered for ".concat(String.valueOf(stringExtra)));
        } else {
            SdkLog.m8378b(TAG, "Informing app of incoming stream transfer request on registered callback-tid: ".concat(String.valueOf(intExtra)));
            this.mHandler.post(new Runnable() { // from class: com.heytap.accessory.stream.StreamTransfer.6
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        StreamTransferManager.m8691a(StreamTransfer.this.mContext, StreamTransfer.this.mAgentName).m8707a(StreamTransfer.this.mLocalCallback, intExtra);
                        StreamTransfer.this.putTransactionRequest(longExtra, intExtra, true);
                        c2245aM8698b.m8711a().onTransferRequested(longExtra, OplusGLSurfaceView_13, intExtra);
                    } catch (GeneralException | IllegalAccessException COUIBaseListPopupWindow_8) {
                        COUIBaseListPopupWindow_8.printStackTrace();
                    }
                }
            });
        }
    }

    private boolean checkReceiveParams(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
        if (!containsTransactionKey(OplusGLSurfaceView_15, OplusGLSurfaceView_13)) {
            return true;
        }
        SdkLog.m8378b(TAG, "transactionId already exist");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnTransferCompletedErrorCode(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 8) {
            SdkLog.m8381c(TAG, "onTransferCompleted() -> ERROR_PEER_AGENT_BUSY");
            return;
        }
        if (OplusGLSurfaceView_13 == 9) {
            SdkLog.m8381c(TAG, "onTransferCompleted() -> ERROR_PEER_AGENT_REJECTED");
            return;
        }
        if (OplusGLSurfaceView_13 == 11) {
            SdkLog.m8381c(TAG, "onTransferCompleted() -> ERROR_SPACE_NOT_AVAILABLE");
            return;
        }
        if (OplusGLSurfaceView_13 == 20001) {
            SdkLog.m8381c(TAG, "onTransferCompleted() -> ERROR_FATAL");
            return;
        }
        if (OplusGLSurfaceView_13 == 15) {
            SdkLog.m8381c(TAG, "onTransferCompleted() -> ERROR_RECEIVER_MEMORY_LACKING");
            return;
        }
        if (OplusGLSurfaceView_13 != 16) {
            switch (OplusGLSurfaceView_13) {
                case -1:
                    SdkLog.m8381c(TAG, "onTransferCompleted() -> ERROR_REQUEST_NOT_QUEUED");
                    break;
                case 0:
                    SdkLog.m8381c(TAG, "onTransferCompleted() -> ERROR_NONE");
                    break;
                case 1:
                    SdkLog.m8381c(TAG, "onTransferCompleted() -> ERROR_CHANNEL_IO");
                    break;
                case 2:
                    SdkLog.m8381c(TAG, "onTransferCompleted() -> ERROR_FILE_IO");
                    break;
                case 3:
                    SdkLog.m8381c(TAG, "onTransferCompleted() -> ERROR_COMMAND_DROPPED");
                    break;
                case 4:
                    SdkLog.m8381c(TAG, "onTransferCompleted() -> ERROR_PEER_AGENT_NO_RESPONSE");
                    break;
                case 5:
                    SdkLog.m8381c(TAG, "onTransferCompleted() -> ERROR_CONNECTION_LOST");
                    break;
                default:
                    SdkLog.m8382d(TAG, "onTransferCompleted() error_code: ".concat(String.valueOf(OplusGLSurfaceView_13)));
                    break;
            }
            return;
        }
        SdkLog.m8381c(TAG, "onTransferCompleted() -> ERROR_RECEIVER_WAIT_TILL_TIMEOUT");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnCancelAllCompletedErrorCode(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 12) {
            SdkLog.m8381c(TAG, "onCancelAllCompleted() -> ERROR_NOT_SUPPORTED");
            return;
        }
        if (OplusGLSurfaceView_13 == 13) {
            SdkLog.m8381c(TAG, "onCancelAllCompleted() -> ERROR_TRANSACTION_NOT_FOUND");
        } else if (OplusGLSurfaceView_13 == 17) {
            SdkLog.m8381c(TAG, "onCancelAllCompleted() -> ERROR_CANCEL_ACC_SLEEPING");
        } else {
            SdkLog.m8382d(TAG, "onCancelAllCompleted() error_code: ".concat(String.valueOf(OplusGLSurfaceView_13)));
        }
    }

    /* renamed from: com.heytap.accessory.stream.StreamTransfer$PlatformImplementations.kt_3 */
    static class C2240a implements Thread.UncaughtExceptionHandler {
        /* synthetic */ C2240a(byte b2) {
            this();
        }

        private C2240a() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public final void uncaughtException(final Thread thread, final Throwable th) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.heytap.accessory.stream.StreamTransfer.PlatformImplementations.kt_3.1
                @Override // java.lang.Runnable
                public final void run() {
                    SdkLog.m8383e(StreamTransfer.TAG, "Exception in StreamTransfer Handler thread :" + thread.getName());
                    throw new RuntimeException(th);
                }
            });
        }
    }

    /* renamed from: com.heytap.accessory.stream.StreamTransfer$IntrinsicsJvm.kt_3 */
    static class HandlerC2242c extends Handler {
        public HandlerC2242c(Looper looper) {
            super(looper);
        }
    }

    private synchronized void putTransaction(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, CallingAgentInfo_3.PlatformImplementations.kt_3 aVar) {
        SdkLog.m8381c(TAG + hashCode(), "putTransaction: connectionId:" + OplusGLSurfaceView_15 + ",transactionId:" + OplusGLSurfaceView_13);
        if (this.mTransactionsMap != null) {
            ConcurrentHashMap<Integer, CallingAgentInfo_3.PlatformImplementations.kt_3> concurrentHashMap = this.mTransactionsMap.get(Long.valueOf(OplusGLSurfaceView_15));
            if (concurrentHashMap == null) {
                concurrentHashMap = new ConcurrentHashMap<>();
                this.mTransactionsMap.put(Long.valueOf(OplusGLSurfaceView_15), concurrentHashMap);
            }
            if (aVar != null) {
                concurrentHashMap.put(Integer.valueOf(OplusGLSurfaceView_13), aVar);
            }
        }
    }

    private synchronized CallingAgentInfo_3.PlatformImplementations.kt_3 getTransaction(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
        CallingAgentInfo_3.PlatformImplementations.kt_3 aVar;
        ConcurrentHashMap<Integer, CallingAgentInfo_3.PlatformImplementations.kt_3> concurrentHashMap;
        aVar = null;
        if (this.mTransactionsMap != null && (concurrentHashMap = this.mTransactionsMap.get(Long.valueOf(OplusGLSurfaceView_15))) != null) {
            aVar = concurrentHashMap.get(Integer.valueOf(OplusGLSurfaceView_13));
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void removeTransaction(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
        ConcurrentHashMap<Integer, CallingAgentInfo_3.PlatformImplementations.kt_3> concurrentHashMap;
        if (this.mTransactionsMap != null && (concurrentHashMap = this.mTransactionsMap.get(Long.valueOf(OplusGLSurfaceView_15))) != null) {
            concurrentHashMap.remove(Integer.valueOf(OplusGLSurfaceView_13));
            if (concurrentHashMap.isEmpty()) {
                SdkLog.m8381c(TAG, "removeTransaction:" + OplusGLSurfaceView_15 + " " + OplusGLSurfaceView_13);
                this.mTransactionsMap.remove(Long.valueOf(OplusGLSurfaceView_15));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void removeTransactionByTransId(int OplusGLSurfaceView_13) {
        if (this.mTransactionsMap != null) {
            Iterator<Long> it = this.mTransactionsMap.keySet().iterator();
            while (it.hasNext()) {
                removeTransaction(it.next().longValue(), OplusGLSurfaceView_13);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean containsTransactionKey(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
        boolean zContainsKey;
        ConcurrentHashMap<Integer, CallingAgentInfo_3.PlatformImplementations.kt_3> concurrentHashMap;
        zContainsKey = false;
        if (this.mTransactionsMap != null && (concurrentHashMap = this.mTransactionsMap.get(Long.valueOf(OplusGLSurfaceView_15))) != null) {
            zContainsKey = concurrentHashMap.containsKey(Integer.valueOf(OplusGLSurfaceView_13));
        }
        return zContainsKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void putTransactionRequest(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, boolean z) {
        ConcurrentHashMap<Integer, Boolean> concurrentHashMap = this.mTransferRequestMap.get(Long.valueOf(OplusGLSurfaceView_15));
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap<>();
        }
        concurrentHashMap.put(Integer.valueOf(OplusGLSurfaceView_13), Boolean.valueOf(z));
        this.mTransferRequestMap.put(Long.valueOf(OplusGLSurfaceView_15), concurrentHashMap);
        SdkLog.m8378b(TAG + hashCode(), "putTransactionRequest connectionId: " + OplusGLSurfaceView_15 + " ,transactionId: " + OplusGLSurfaceView_13 + " , " + z + " , " + getTransactionRequestState(OplusGLSurfaceView_15, OplusGLSurfaceView_13));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean getTransactionRequestState(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
        ConcurrentHashMap<Integer, Boolean> concurrentHashMap = this.mTransferRequestMap.get(Long.valueOf(OplusGLSurfaceView_15));
        if (concurrentHashMap == null) {
            return false;
        }
        if (concurrentHashMap.get(Integer.valueOf(OplusGLSurfaceView_13)) != null) {
            if (concurrentHashMap.get(Integer.valueOf(OplusGLSurfaceView_13)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void removeTransactionRequest(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
        ConcurrentHashMap<Integer, Boolean> concurrentHashMap = this.mTransferRequestMap.get(Long.valueOf(OplusGLSurfaceView_15));
        if (concurrentHashMap != null) {
            concurrentHashMap.remove(Integer.valueOf(OplusGLSurfaceView_13));
            if (concurrentHashMap.isEmpty()) {
                this.mTransferRequestMap.remove(Long.valueOf(OplusGLSurfaceView_15));
            }
        }
    }

    private synchronized void putConnectionRequest(long OplusGLSurfaceView_15, boolean z) {
        this.mConnectionMap.put(Long.valueOf(OplusGLSurfaceView_15), Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean containsTransactionRequestKey(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
        boolean zContainsKey;
        zContainsKey = false;
        ConcurrentHashMap<Integer, Boolean> concurrentHashMap = this.mTransferRequestMap.get(Long.valueOf(OplusGLSurfaceView_15));
        if (concurrentHashMap != null) {
            zContainsKey = concurrentHashMap.containsKey(Integer.valueOf(OplusGLSurfaceView_13));
        } else {
            SdkLog.m8383e(TAG + hashCode(), "mTransferRequestMap not contains connectionId:" + OplusGLSurfaceView_15 + ",transactionId:" + OplusGLSurfaceView_13);
        }
        return zContainsKey;
    }
}
