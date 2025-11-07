package com.heytap.accessory.file;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.os.RemoteException;
import com.android.providers.downloads.Downloads;
import com.heytap.accessory.BaseAgent;
import com.heytap.accessory.BaseJobAgent;
import com.heytap.accessory.bean.GeneralException;
import com.heytap.accessory.bean.PeerAgent;
import com.heytap.accessory.bean.SdkUnsupportedException;
import com.heytap.accessory.bean.UnSupportException;
import com.heytap.accessory.file.CallingAgentInfo;
import com.heytap.accessory.file.p107a.CancelFileRequest;
import com.heytap.accessory.file.p107a.FTOperateEntity;
import com.heytap.accessory.file.p107a.FileDescription;
import com.heytap.accessory.p103a.SdkLog;
import com.heytap.accessory.p104b.BroadcastUtils;
import com.oplus.camera.statistics.CameraStatisticsUtil;
import com.oplus.ocs.camera.CameraParameter;
import java.io.File;
import java.lang.Thread;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;

/* loaded from: classes2.dex */
public class FileTransfer {
    public static final String ACTION_AFP_FILE_TRANSFER_REQUESTED = "com.heytap.accessory.ftconnection";
    private static final boolean COVERED_MODE = true;
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
    public static final int ERROR_REQUEST_NOT_QUEUED = -1;
    public static final int ERROR_SPACE_NOT_AVAILABLE = 11;
    public static final int ERROR_TRANSACTION_NOT_FOUND = 13;
    private static final String FILE_PROVIDER = "androidx.core.content.FileProvider";
    private static final String FILE_PROVIDER_V4 = "androidx.core.content.FileProvider";
    private static final int FT_CANCEL_TRANS_ID = -1;
    private static final int FT_DEFAULT_CONNECTION_ID = 0;
    private static final int FT_DEFAULT_TRANS_ID = 0;
    private static final String INTERNAL_FTREQUEST_ACTION = "com.heytap.accessory.ftconnection.internal";
    private static final String TAG = "FileTransfer";
    private String mAgentName;
    private Object mCallingAgent;
    private CallingAgentInfo mCallingAgentInfo;
    private Context mContext;
    private EventListener mEventListener;
    private HandlerThread mFileTransferHandlerThread;
    private HandlerC2217b mHandler;
    InterfaceC2218c mLocalCallback;
    private ConcurrentHashMap<Long, ConcurrentHashMap<Integer, CallingAgentInfo.PlatformImplementations.kt_3>> mTransactionsMap;
    private ConcurrentHashMap<Long, ConcurrentHashMap<Integer, Boolean>> mTransferRequestMap;

    public interface EventListener {
        void onCancelAllCompleted(int OplusGLSurfaceView_13, int i2);

        void onProgressChanged(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, int i2);

        void onTransferCompleted(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, String str, int i2);

        void onTransferRequested(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, int i2, FileDescription c2226d);
    }

    /* renamed from: com.heytap.accessory.file.FileTransfer$IntrinsicsJvm.kt_3 */
    protected interface InterfaceC2218c {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo8630a();

        /* renamed from: PlatformImplementations.kt_3 */
        void mo8631a(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, int i2);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo8632a(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, String str, int i2);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo8633a(int[] iArr, int OplusGLSurfaceView_13);
    }

    public FileTransfer(BaseAgent baseAgent, EventListener eventListener) throws SdkUnsupportedException {
        this(baseAgent, baseAgent.getApplicationContext(), eventListener);
    }

    public FileTransfer(BaseJobAgent baseJobAgent, EventListener eventListener) throws SdkUnsupportedException {
        this(baseJobAgent, baseJobAgent.getApplicationContext(), eventListener);
    }

    public FileTransfer(Object obj, Context context, EventListener eventListener) throws SdkUnsupportedException {
        this.mTransactionsMap = new ConcurrentHashMap<>();
        this.mTransferRequestMap = new ConcurrentHashMap<>();
        this.mLocalCallback = new InterfaceC2218c() { // from class: com.heytap.accessory.file.FileTransfer.1
            @Override // com.heytap.accessory.file.FileTransfer.InterfaceC2218c
            /* renamed from: PlatformImplementations.kt_3 */
            public final void mo8631a(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, int i2) {
                ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) FileTransfer.this.mTransactionsMap.get(Long.valueOf(OplusGLSurfaceView_15));
                if (concurrentHashMap == null) {
                    SdkLog.m8382d(FileTransfer.TAG, "detailsMap == null");
                    return;
                }
                for (Map.Entry entry : concurrentHashMap.entrySet()) {
                    if (((CallingAgentInfo.PlatformImplementations.kt_3) entry.getValue()).f9599b == OplusGLSurfaceView_13 && FileTransfer.this.mEventListener != null) {
                        FileTransfer.this.mEventListener.onProgressChanged(OplusGLSurfaceView_15, ((Integer) entry.getKey()).intValue(), i2);
                        return;
                    }
                }
            }

            @Override // com.heytap.accessory.file.FileTransfer.InterfaceC2218c
            /* renamed from: PlatformImplementations.kt_3 */
            public final void mo8632a(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, String str, int i2) {
                ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) FileTransfer.this.mTransactionsMap.get(Long.valueOf(OplusGLSurfaceView_15));
                if (concurrentHashMap == null) {
                    SdkLog.m8382d(FileTransfer.TAG, "onTransferCompleted detailsMap == null");
                    return;
                }
                for (Map.Entry entry : concurrentHashMap.entrySet()) {
                    CallingAgentInfo.PlatformImplementations.kt_3 aVar = (CallingAgentInfo.PlatformImplementations.kt_3) entry.getValue();
                    if (aVar.f9599b == OplusGLSurfaceView_13 && FileTransfer.this.mEventListener != null) {
                        if (aVar.f9600c != null && i2 != 0) {
                            File file = new File(aVar.f9600c + "_temp_" + OplusGLSurfaceView_13);
                            if (!file.isFile() || !file.exists()) {
                                SdkLog.m8383e(FileTransfer.TAG, "temp file could not be deleted - " + aVar.f9600c);
                            } else if (file.delete()) {
                                SdkLog.m8375a(FileTransfer.TAG, "temp file deleted successfully - " + aVar.f9600c);
                            } else {
                                SdkLog.m8383e(FileTransfer.TAG, "temp file could not be deleted - " + aVar.f9600c);
                            }
                            aVar.f9600c = null;
                        }
                        FileTransfer.this.handleOnTransferCompletedErrorCode(i2);
                        FileTransfer.this.mEventListener.onTransferCompleted(OplusGLSurfaceView_15, ((Integer) entry.getKey()).intValue(), str, i2);
                        FileTransfer.this.removeTransaction(OplusGLSurfaceView_15, ((Integer) entry.getKey()).intValue());
                        FileTransfer.this.removeTransactionRequest(OplusGLSurfaceView_15, OplusGLSurfaceView_13);
                        return;
                    }
                }
                if (!FileTransfer.this.getTransactionRequestState(OplusGLSurfaceView_15, OplusGLSurfaceView_13) || i2 != 9) {
                    if (!FileTransfer.this.containsTransactionRequestKey(OplusGLSurfaceView_15, OplusGLSurfaceView_13) || FileTransfer.this.containsTransactionKey(OplusGLSurfaceView_15, OplusGLSurfaceView_13) || FileTransfer.this.mEventListener == null) {
                        return;
                    }
                    FileTransfer.this.handleOnTransferCompletedErrorCode(i2);
                    FileTransfer.this.mEventListener.onTransferCompleted(OplusGLSurfaceView_15, OplusGLSurfaceView_13, str, i2);
                    FileTransfer.this.removeTransactionRequest(OplusGLSurfaceView_15, OplusGLSurfaceView_13);
                    return;
                }
                SdkLog.m8378b(FileTransfer.TAG, "Ignoring onTransferCompleted because setup in progress");
            }

            @Override // com.heytap.accessory.file.FileTransfer.InterfaceC2218c
            /* renamed from: PlatformImplementations.kt_3 */
            public final void mo8630a() {
                SdkLog.m8378b(FileTransfer.TAG, "onTransferRequested");
            }

            @Override // com.heytap.accessory.file.FileTransfer.InterfaceC2218c
            /* renamed from: PlatformImplementations.kt_3 */
            public final void mo8633a(int[] iArr, int OplusGLSurfaceView_13) {
                for (int i2 : iArr) {
                    Iterator it = FileTransfer.this.mTransactionsMap.keySet().iterator();
                    while (it.hasNext()) {
                        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) FileTransfer.this.mTransactionsMap.get(Long.valueOf(((Long) it.next()).longValue()));
                        if (concurrentHashMap != null) {
                            for (Map.Entry entry : concurrentHashMap.entrySet()) {
                                if (((CallingAgentInfo.PlatformImplementations.kt_3) entry.getValue()).f9599b == i2 && FileTransfer.this.mEventListener != null) {
                                    FileTransfer.this.removeTransactionByTransId(((Integer) entry.getKey()).intValue());
                                }
                            }
                        }
                    }
                }
                if (FileTransfer.this.mEventListener != null) {
                    FileTransfer.this.handleOnCancelAllCompletedErrorCode(OplusGLSurfaceView_13);
                    FileTransfer.this.mEventListener.onCancelAllCompleted(-1, OplusGLSurfaceView_13);
                }
            }
        };
        if (obj != null && eventListener != null) {
            this.mCallingAgent = obj;
            this.mContext = context;
            this.mAgentName = obj.getClass().getName();
            this.mEventListener = eventListener;
            FTInitializer.init(this.mContext);
            if (register()) {
                return;
            }
            SdkLog.m8378b(TAG, "Agent already registered");
            this.mCallingAgentInfo = FileTransferManager.m8645b(this.mAgentName);
            CallingAgentInfo c2222a = this.mCallingAgentInfo;
            if (c2222a != null) {
                this.mFileTransferHandlerThread = c2222a.f9594c;
                this.mHandler = (HandlerC2217b) this.mCallingAgentInfo.f9595d;
                this.mTransactionsMap = this.mCallingAgentInfo.f9596e;
                CallingAgentInfo c2222a2 = this.mCallingAgentInfo;
                c2222a2.f9592a = this.mEventListener;
                c2222a2.f9593b = this.mLocalCallback;
                return;
            }
            return;
        }
        throw new IllegalArgumentException("FileEventCallback parameter cannot be null");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int send(com.heytap.accessory.bean.PeerAgent r13, java.lang.String r14) throws com.heytap.accessory.bean.UnSupportException {
        /*
            r12 = this;
            boolean r0 = r12.validateParam(r13)
            r1 = -1
            if (r0 == 0) goto Lbd
            r12.checkSource(r14)
            android.content.Context r0 = r12.mContext
            java.lang.String r0 = com.heytap.accessory.file.FTInitializer.getFileTransferPackageName(r0)
            java.lang.String r2 = r12.getContentURIAuthority()
            r3 = 0
            java.lang.String r4 = "FileTransfer"
            if (r0 == 0) goto L6f
            if (r2 == 0) goto L6f
            java.lang.String r5 = "Cannot create the content URI !"
            if (r14 != 0) goto L25
            java.lang.String r0 = "File path is wrong!!"
            com.heytap.accessory.p103a.SdkLog.m8383e(r4, r0)     // Catch: java.lang.NullPointerException -> L4a java.lang.IllegalArgumentException -> L4c
            return r1
        L25:
            java.lang.String r6 = "File :"
            java.lang.String r7 = java.lang.String.valueOf(r14)     // Catch: java.lang.NullPointerException -> L4a java.lang.IllegalArgumentException -> L4c
            java.lang.String r6 = r6.concat(r7)     // Catch: java.lang.NullPointerException -> L4a java.lang.IllegalArgumentException -> L4c
            com.heytap.accessory.p103a.SdkLog.m8375a(r4, r6)     // Catch: java.lang.NullPointerException -> L4a java.lang.IllegalArgumentException -> L4c
            java.io.File r6 = new java.io.File     // Catch: java.lang.NullPointerException -> L4a java.lang.IllegalArgumentException -> L4c
            r6.<init>(r14)     // Catch: java.lang.NullPointerException -> L4a java.lang.IllegalArgumentException -> L4c
            android.content.Context r7 = r12.mContext     // Catch: java.lang.NullPointerException -> L4a java.lang.IllegalArgumentException -> L4c
            android.net.Uri r2 = androidx.core.p027a.FileProvider.m2326a(r7, r2, r6)     // Catch: java.lang.NullPointerException -> L4a java.lang.IllegalArgumentException -> L4c
            if (r2 != 0) goto L43
            com.heytap.accessory.p103a.SdkLog.m8383e(r4, r5)     // Catch: java.lang.NullPointerException -> L4a java.lang.IllegalArgumentException -> L4c
            goto L5e
        L43:
            android.content.Context r6 = r12.mContext     // Catch: java.lang.NullPointerException -> L4a java.lang.IllegalArgumentException -> L4c
            r7 = 1
            r6.grantUriPermission(r0, r2, r7)     // Catch: java.lang.NullPointerException -> L4a java.lang.IllegalArgumentException -> L4c
            goto L5e
        L4a:
            r0 = move-exception
            goto L4e
        L4c:
            r0 = move-exception
            goto L57
        L4e:
            r0.printStackTrace()
            java.lang.String r0 = "Cannot create the content URI !! "
            com.heytap.accessory.p103a.SdkLog.m8383e(r4, r0)
            goto L5d
        L57:
            r0.printStackTrace()
            com.heytap.accessory.p103a.SdkLog.m8383e(r4, r5)
        L5d:
            r2 = r3
        L5e:
            if (r2 != 0) goto L75
            boolean r0 = r12.isInternalPath(r14)
            if (r0 != 0) goto L67
            goto L75
        L67:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.String r13 = "content uri needs to be implemented for sending from internal folders.Please check file-transfer sdk documentation for more details"
            r12.<init>(r13)
            throw r12
        L6f:
            java.lang.String r0 = "FTCore version doesnot support content uri"
            com.heytap.accessory.p103a.SdkLog.m8375a(r4, r0)
            r2 = r3
        L75:
            com.heytap.accessory.file.PlatformImplementations.kt_3$PlatformImplementations.kt_3 r0 = new com.heytap.accessory.file.PlatformImplementations.kt_3$PlatformImplementations.kt_3
            r0.<init>()
            if (r2 == 0) goto L80
            java.lang.String r3 = r2.toString()
        L80:
            r10 = r3
            java.lang.String r2 = java.lang.String.valueOf(r10)
            java.lang.String r3 = "FTCore strURI="
            java.lang.String r2 = r3.concat(r2)
            com.heytap.accessory.p103a.SdkLog.m8375a(r4, r2)
            android.content.Context r2 = r12.mContext     // Catch: java.lang.Throwable -> La3
            java.lang.String r3 = r12.mAgentName     // Catch: java.lang.Throwable -> La3
            com.heytap.accessory.file.FileTransferManager r5 = com.heytap.accessory.file.FileTransferManager.m8637a(r2, r3)     // Catch: java.lang.Throwable -> La3
            android.content.Context r6 = r12.mContext     // Catch: java.lang.Throwable -> La3
            java.lang.String r7 = r12.mAgentName     // Catch: java.lang.Throwable -> La3
            com.heytap.accessory.file.FileTransfer$IntrinsicsJvm.kt_3 r8 = r12.mLocalCallback     // Catch: java.lang.Throwable -> La3
            r9 = r13
            r11 = r14
            int r1 = r5.m8651a(r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> La3
            goto La7
        La3:
            r13 = move-exception
            r13.printStackTrace()
        La7:
            java.lang.String r13 = java.lang.String.valueOf(r1)
            java.lang.String r2 = "received tx from FTCore"
            java.lang.String r13 = r2.concat(r13)
            com.heytap.accessory.p103a.SdkLog.m8378b(r4, r13)
            r0.f9599b = r1
            r0.f9601d = r14
            r13 = 0
            r12.putTransaction(r13, r1, r0)
        Lbd:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.heytap.accessory.file.FileTransfer.send(com.heytap.accessory.bean.PeerAgent, java.lang.String):int");
    }

    public int send(PeerAgent peerAgent, Uri uri) throws UnSupportException {
        int iM8652a = -1;
        if (validateParam(peerAgent)) {
            String fileTransferPackageName = FTInitializer.getFileTransferPackageName(this.mContext);
            if (fileTransferPackageName != null) {
                try {
                    if (uri == null) {
                        SdkLog.m8383e(TAG, "File path is wrong!!");
                        return -1;
                    }
                    SdkLog.m8375a(TAG, "File :".concat(String.valueOf(uri)));
                    this.mContext.grantUriPermission(fileTransferPackageName, uri, 1);
                } catch (Exception COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                    SdkLog.m8383e(TAG, "Error grantUriPermission!!");
                }
            } else {
                SdkLog.m8375a(TAG, "FTCore version doesnot support content uri");
            }
            CallingAgentInfo.PlatformImplementations.kt_3 aVar = new CallingAgentInfo.PlatformImplementations.kt_3();
            try {
                iM8652a = FileTransferManager.m8637a(this.mContext, this.mAgentName).m8652a(this.mContext, this.mAgentName, "", this.mLocalCallback, peerAgent, uri);
            } catch (GeneralException | IllegalAccessException e2) {
                e2.printStackTrace();
            }
            SdkLog.m8378b(TAG, "received tx from FTCore".concat(String.valueOf(iM8652a)));
            aVar.f9599b = iM8652a;
            aVar.f9601d = uri.toString();
            putTransaction(0L, iM8652a, aVar);
        }
        return iM8652a;
    }

    public int send(PeerAgent peerAgent, Uri uri, String str) throws UnSupportException {
        int iM8652a = -1;
        if (validateParam(peerAgent)) {
            SdkLog.m8378b(TAG, "peerAgent:".concat(String.valueOf(peerAgent)));
            String fileTransferPackageName = FTInitializer.getFileTransferPackageName(this.mContext);
            if (fileTransferPackageName != null) {
                try {
                    if (uri == null) {
                        SdkLog.m8383e(TAG, "File path is wrong!!");
                        return -1;
                    }
                    SdkLog.m8375a(TAG, "File :".concat(String.valueOf(uri)));
                    this.mContext.grantUriPermission(fileTransferPackageName, uri, 1);
                } catch (Exception COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                    SdkLog.m8383e(TAG, "Error grantUriPermission!!");
                }
            } else {
                SdkLog.m8375a(TAG, "FTCore version doesnot support content uri");
            }
            CallingAgentInfo.PlatformImplementations.kt_3 aVar = new CallingAgentInfo.PlatformImplementations.kt_3();
            try {
                iM8652a = FileTransferManager.m8637a(this.mContext, this.mAgentName).m8652a(this.mContext, this.mAgentName, str, this.mLocalCallback, peerAgent, uri);
            } catch (GeneralException | IllegalAccessException e2) {
                e2.printStackTrace();
            }
            SdkLog.m8378b(TAG, "received tx from FTCore".concat(String.valueOf(iM8652a)));
            aVar.f9599b = iM8652a;
            aVar.f9601d = uri.toString();
            putTransaction(0L, iM8652a, aVar);
        }
        return iM8652a;
    }

    private boolean validateParam(PeerAgent peerAgent) {
        if (peerAgent == null) {
            throw new IllegalArgumentException("PeerAgent cannot be null");
        }
        Object obj = this.mCallingAgent;
        if (obj == null || this.mEventListener == null) {
            SdkLog.m8383e(TAG, "Using invalid instance of FileTransfer(). Please re-register.");
            return false;
        }
        if (obj == null) {
            return true;
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

    /* JADX WARN: Removed duplicated region for block: B:43:0x00ea A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0124  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void receive(final long r17, final int r19, final java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 355
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.heytap.accessory.file.FileTransfer.receive(long, int, java.lang.String):void");
    }

    public void receive(final long OplusGLSurfaceView_15, final int OplusGLSurfaceView_13, final Uri uri) {
        SdkLog.m8381c(TAG, "receive receiveFileUri: " + uri + ", connectionId:" + OplusGLSurfaceView_15 + ", transactionId:" + OplusGLSurfaceView_13 + ", " + hashCode());
        if (this.mCallingAgent != null && this.mEventListener != null) {
            if (containsTransactionRequestKey(OplusGLSurfaceView_15, OplusGLSurfaceView_13)) {
                CallingAgentInfo.PlatformImplementations.kt_3 aVar = new CallingAgentInfo.PlatformImplementations.kt_3();
                aVar.f9598a = OplusGLSurfaceView_15;
                aVar.f9599b = OplusGLSurfaceView_13;
                aVar.f9601d = uri.toString();
                putTransaction(OplusGLSurfaceView_15, OplusGLSurfaceView_13, aVar);
                String fileTransferPackageName = FTInitializer.getFileTransferPackageName(this.mContext);
                if (fileTransferPackageName != null) {
                    try {
                        aVar.f9600c = uri.toString();
                        this.mContext.grantUriPermission(fileTransferPackageName, uri, 2);
                    } catch (Exception COUIBaseListPopupWindow_8) {
                        COUIBaseListPopupWindow_8.printStackTrace();
                        SdkLog.m8383e(TAG, "Error grantUriPermission!!");
                    }
                } else {
                    SdkLog.m8375a(TAG, "Accessory Framework doesn't support content URI !!");
                }
                this.mHandler.post(new Runnable() { // from class: com.heytap.accessory.file.FileTransfer.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            try {
                                FileTransferManager.m8637a(FileTransfer.this.mContext, FileTransfer.this.mAgentName).m8653a(FileTransfer.this.mLocalCallback, OplusGLSurfaceView_15, OplusGLSurfaceView_13, uri, true);
                            } catch (GeneralException | IllegalAccessException e2) {
                                e2.printStackTrace();
                            }
                        } finally {
                            FileTransfer.this.putTransactionRequest(OplusGLSurfaceView_15, OplusGLSurfaceView_13, false);
                        }
                    }
                });
                return;
            }
            SdkLog.m8378b(TAG, "TransactionId: Given[" + OplusGLSurfaceView_13 + "] not exist");
            putTransactionRequest(OplusGLSurfaceView_15, OplusGLSurfaceView_13, false);
            throw new IllegalArgumentException("Wrong filepath or transaction id_renamed used");
        }
        SdkLog.m8378b(TAG, "Using invalid instance of FileTransfer(). Please re-register.");
        putTransactionRequest(OplusGLSurfaceView_15, OplusGLSurfaceView_13, false);
    }

    public void reject(final long OplusGLSurfaceView_15, final int OplusGLSurfaceView_13) {
        SdkLog.m8378b(TAG, "file reject, connId: " + OplusGLSurfaceView_15 + ", transId: " + OplusGLSurfaceView_13);
        if (this.mCallingAgent != null && this.mEventListener != null) {
            if (checkReceiveParams("", OplusGLSurfaceView_15, OplusGLSurfaceView_13) && containsTransactionRequestKey(OplusGLSurfaceView_15, OplusGLSurfaceView_13)) {
                CallingAgentInfo.PlatformImplementations.kt_3 aVar = new CallingAgentInfo.PlatformImplementations.kt_3();
                aVar.f9599b = OplusGLSurfaceView_13;
                aVar.f9601d = "";
                removeTransaction(OplusGLSurfaceView_15, OplusGLSurfaceView_13);
                this.mHandler.post(new Runnable() { // from class: com.heytap.accessory.file.FileTransfer.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            FileTransferManager.m8637a(FileTransfer.this.mContext, FileTransfer.this.mAgentName).m8653a(null, OplusGLSurfaceView_15, OplusGLSurfaceView_13, null, false);
                        } catch (GeneralException | IllegalAccessException COUIBaseListPopupWindow_8) {
                            COUIBaseListPopupWindow_8.printStackTrace();
                        }
                    }
                });
                return;
            }
            throw new IllegalArgumentException("Wrong transaction id_renamed used in reject()");
        }
        SdkLog.m8378b(TAG, "Using invalid instance of FileTransfer(). Please re-register.");
    }

    public void cancel(final long OplusGLSurfaceView_15, final int OplusGLSurfaceView_13) {
        if (this.mCallingAgent != null && this.mEventListener != null) {
            if (!containsTransactionKey(OplusGLSurfaceView_15, OplusGLSurfaceView_13)) {
                throw new IllegalArgumentException("Wrong connection(" + OplusGLSurfaceView_15 + ") transaction id_renamed(" + OplusGLSurfaceView_13 + ") used for cancel.");
            }
            this.mHandler.post(new Runnable() { // from class: com.heytap.accessory.file.FileTransfer.5
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        CallingAgentInfo.PlatformImplementations.kt_3 transaction = FileTransfer.this.getTransaction(OplusGLSurfaceView_15, OplusGLSurfaceView_13);
                        if (transaction == null) {
                            SdkLog.m8378b(FileTransfer.TAG, "cancelFile aborted because service connection or transaction already closed.");
                            return;
                        }
                        if (transaction.f9599b == 0) {
                            transaction.f9599b = -1;
                            SdkLog.m8378b(FileTransfer.TAG, "Cancel called before transaction id_renamed is genereated" + OplusGLSurfaceView_13);
                            return;
                        }
                        if (transaction.f9599b != -1) {
                            FileTransferManager fileTransferManagerM8637a = FileTransferManager.m8637a(FileTransfer.this.mContext, FileTransfer.this.mAgentName);
                            try {
                                try {
                                    FTOperateEntity c2225c = new FTOperateEntity(3, new CancelFileRequest(OplusGLSurfaceView_15, transaction.f9599b).m8658a());
                                    if (fileTransferManagerM8637a.f9583b != null) {
                                        fileTransferManagerM8637a.f9583b.f9589a.mo8615a(c2225c.m8659a().toString());
                                        return;
                                    }
                                    return;
                                } catch (JSONException COUIBaseListPopupWindow_8) {
                                    COUIBaseListPopupWindow_8.printStackTrace();
                                    return;
                                }
                            } catch (RemoteException e2) {
                                e2.printStackTrace();
                                return;
                            }
                        }
                        SdkLog.m8378b(FileTransfer.TAG, "Cancel called again before transaction id_renamed is genereated" + OplusGLSurfaceView_13);
                    } catch (GeneralException | IllegalAccessException e3) {
                        e3.printStackTrace();
                    }
                }
            });
            return;
        }
        SdkLog.m8378b(TAG, "Using invalid instance of FileTransfer(). Please re-register.");
    }

    public void cancelAll() {
        SharedPreferences sharedPreferences;
        if (this.mCallingAgent != null && this.mEventListener != null) {
            if (Build.VERSION.SDK_INT > 26) {
                sharedPreferences = this.mContext.createDeviceProtectedStorageContext().getSharedPreferences("AccessoryPreferences", 0);
            } else {
                sharedPreferences = this.mContext.getApplicationContext().getSharedPreferences("AccessoryPreferences", 0);
            }
            final String string = sharedPreferences.getString(this.mAgentName, null);
            if (string == null) {
                SdkLog.m8383e(TAG, "Your service was not found. Please re-register");
                return;
            } else {
                this.mHandler.post(new Runnable() { // from class: com.heytap.accessory.file.FileTransfer.6
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            int iM8656c = FileTransferManager.m8637a(FileTransfer.this.mContext, FileTransfer.this.mAgentName).m8656c(string);
                            SdkLog.m8378b(FileTransfer.TAG, "cancel status ".concat(String.valueOf(iM8656c)));
                            EventListener eventListener = FileTransfer.this.mEventListener;
                            if (eventListener == null) {
                                SdkLog.m8382d(FileTransfer.TAG, "[cancelAll] listener is null.");
                                return;
                            }
                            if (iM8656c == 0) {
                                FileTransfer.this.handleOnCancelAllCompletedErrorCode(12);
                                eventListener.onCancelAllCompleted(-1, 12);
                            } else if (iM8656c == 13) {
                                FileTransfer.this.handleOnCancelAllCompletedErrorCode(13);
                                eventListener.onCancelAllCompleted(-1, 13);
                            } else if (iM8656c == 1) {
                                FileTransfer.this.handleOnCancelAllCompletedErrorCode(0);
                                eventListener.onCancelAllCompleted(-1, 0);
                            }
                        } catch (GeneralException | IllegalAccessException COUIBaseListPopupWindow_8) {
                            COUIBaseListPopupWindow_8.printStackTrace();
                        }
                    }
                });
                return;
            }
        }
        SdkLog.m8378b(TAG, "Using invalid instance of  Please re-register.");
    }

    public void close() {
        if (this.mCallingAgent != null && this.mEventListener != null) {
            SdkLog.m8378b(TAG, "stopFileTransferService() called by : " + this.mAgentName);
            FileTransferManager.m8639a(this.mAgentName);
            ConcurrentHashMap<Long, ConcurrentHashMap<Integer, CallingAgentInfo.PlatformImplementations.kt_3>> concurrentHashMap = this.mTransactionsMap;
            if (concurrentHashMap != null) {
                concurrentHashMap.clear();
            }
            HandlerC2217b handlerC2217b = this.mHandler;
            if (handlerC2217b != null) {
                handlerC2217b.removeCallbacksAndMessages(null);
                this.mHandler.getLooper().quit();
            }
            this.mCallingAgent = null;
            this.mEventListener = null;
            return;
        }
        SdkLog.m8378b(TAG, "Using invalid instance of FileTransfer(). Please re-register.");
    }

    private boolean register() {
        FileTransferManager.m8642a(this, this.mAgentName);
        this.mFileTransferHandlerThread = new HandlerThread("FileTransferHandlerThread");
        this.mFileTransferHandlerThread.setUncaughtExceptionHandler(new C2216a((byte) 0));
        this.mFileTransferHandlerThread.start();
        SdkLog.m8378b(TAG, "FileTransferHandlerThread started");
        Looper looper = this.mFileTransferHandlerThread.getLooper();
        if (looper != null) {
            this.mHandler = new HandlerC2217b(looper);
        }
        if (this.mHandler == null) {
            return false;
        }
        this.mTransactionsMap = new ConcurrentHashMap<>();
        this.mCallingAgentInfo = new CallingAgentInfo(this.mEventListener, this.mFileTransferHandlerThread, this.mHandler, this.mLocalCallback, this.mTransactionsMap);
        FileTransferManager.m8640a(this.mAgentName, this.mCallingAgentInfo);
        this.mHandler.post(new Runnable() { // from class: com.heytap.accessory.file.FileTransfer.7
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    FileTransferManager.m8637a(FileTransfer.this.mContext, FileTransfer.this.mAgentName);
                } catch (GeneralException | IllegalAccessException COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                }
            }
        });
        return true;
    }

    private String getContentURIAuthority() {
        List<ProviderInfo> listQueryContentProviders;
        try {
            listQueryContentProviders = this.mContext.getPackageManager().queryContentProviders(this.mContext.getPackageName(), Process.myUid(), 0);
        } catch (RuntimeException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            listQueryContentProviders = null;
        }
        if (listQueryContentProviders != null) {
            for (ProviderInfo providerInfo : listQueryContentProviders) {
                if ("androidx.core.content.FileProvider".equalsIgnoreCase(providerInfo.name)) {
                    SdkLog.m8378b(TAG, "Authority:" + providerInfo.authority);
                    return providerInfo.authority;
                }
                if ("androidx.core.content.FileProvider".equalsIgnoreCase(providerInfo.name)) {
                    SdkLog.m8378b(TAG, "Authority:" + providerInfo.authority);
                    return providerInfo.authority;
                }
            }
        }
        return null;
    }

    public void informIncomingFTRequest(Context context, Intent intent) throws NumberFormatException {
        SharedPreferences sharedPreferences;
        final int intExtra = intent.getIntExtra("transId", -1);
        String stringExtra = intent.getStringExtra("agentClass");
        final long longExtra = intent.getLongExtra("connectionId", 0L);
        final int OplusGLSurfaceView_13 = Integer.parseInt(intent.getStringExtra("contId"));
        final long longExtra2 = intent.getLongExtra("fileSize", 0L);
        SdkLog.m8378b(TAG, "receive incoming FTRequest; transactionId = " + intExtra + "; connectionId = " + longExtra + "; implClass = " + stringExtra + "; fileSize = " + longExtra2 + "; peerAgentId = " + OplusGLSurfaceView_13);
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
        final CallingAgentInfo c2222aM8645b = FileTransferManager.m8645b(stringExtra);
        if (c2222aM8645b == null) {
            SdkLog.m8383e(TAG, "AgentInfo is NULL! Re-Registering");
            register();
            informIncomingFTRequest(context, intent);
        } else {
            if (c2222aM8645b.f9592a == null) {
                SdkLog.m8383e(TAG, "callback is not registered for ".concat(String.valueOf(stringExtra)));
                return;
            }
            final String stringExtra2 = intent.getStringExtra(CameraParameter.WaterMarkParamKeys.FILE_PATH);
            final String stringExtra3 = intent.getStringExtra(CameraStatisticsUtil.RUS_FILE_NAME);
            SdkLog.m8378b(TAG, "Informing app of incoming file transfer request on registered callback-tid: ".concat(String.valueOf(intExtra)));
            this.mHandler.post(new Runnable() { // from class: com.heytap.accessory.file.FileTransfer.8
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        FileTransferManager.m8637a(FileTransfer.this.mContext, FileTransfer.this.mAgentName).m8655a(FileTransfer.this.mLocalCallback, intExtra);
                        FileTransfer.this.putTransactionRequest(longExtra, intExtra, true);
                        c2222aM8645b.f9592a.onTransferRequested(longExtra, OplusGLSurfaceView_13, intExtra, new FileDescription.PlatformImplementations.kt_3().m8664a(stringExtra3).m8663a(longExtra2).m8666b(stringExtra2).m8665a());
                    } catch (GeneralException | IllegalAccessException COUIBaseListPopupWindow_8) {
                        COUIBaseListPopupWindow_8.printStackTrace();
                    }
                }
            });
        }
    }

    private void checkSource(String str) {
        if (str == null) {
            throw new IllegalArgumentException("localSrc must not be null!");
        }
        if (str.length() != 0 && checkPathPermission(str)) {
            try {
                SdkLog.m8375a(TAG, "File has PlatformImplementations.kt_3 valid extentsion: ".concat(String.valueOf(str.substring(str.lastIndexOf(".")))));
                Uri uri = Uri.parse(str);
                if ("file".equalsIgnoreCase(uri.getScheme())) {
                    str = uri.getPath();
                    if (str != null) {
                        SdkLog.m8375a(TAG, "URI scheme is SCHEME_FILE  File Path : ".concat(String.valueOf(str)));
                    }
                } else if ("content".equalsIgnoreCase(uri.getScheme())) {
                    Cursor cursorQuery = this.mContext.getContentResolver().query(uri, new String[]{Downloads.Impl._DATA}, null, null, null);
                    if (cursorQuery != null && cursorQuery.moveToFirst()) {
                        try {
                            str = cursorQuery.getString(0);
                            if (str != null) {
                                SdkLog.m8375a(TAG, "URI ContentResolver is SCHEME_CONTENT File Path : ".concat(String.valueOf(str)));
                            }
                            cursorQuery.close();
                            cursorQuery = null;
                        } finally {
                            cursorQuery.close();
                        }
                    }
                    if (cursorQuery != null) {
                    }
                }
                if (str == null) {
                    SdkLog.m8383e(TAG, "srcToSend is null");
                    return;
                }
                File file = new File(str);
                if (!file.exists()) {
                    throw new IllegalArgumentException("File doesnot exist");
                }
                if (file.isDirectory()) {
                    throw new IllegalArgumentException("File is PlatformImplementations.kt_3 directory");
                }
                if (file.length() == 0) {
                    throw new IllegalArgumentException("File length is 0");
                }
                SdkLog.m8375a(TAG, "File is valid !!");
                return;
            } catch (StringIndexOutOfBoundsException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
                throw new IllegalArgumentException("Wrong file..does not have extension");
            }
        }
        throw new IllegalArgumentException("Wrong file path");
    }

    private boolean checkReceiveParams(String str, long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
        boolean zExists = true;
        if (str == null) {
            zExists = false;
        } else if (str.length() != 0) {
            if (!checkPathPermission(str)) {
                SdkLog.m8378b(TAG, "checkReceiveParams return false, internal path");
                return false;
            }
            File file = new File(str);
            if (file.isDirectory()) {
                SdkLog.m8378b(TAG, "given path is PlatformImplementations.kt_3 directory");
            } else {
                String strSubstring = str.substring(str.lastIndexOf("/") + 1);
                if (!strSubstring.contains(".")) {
                    SdkLog.m8378b(TAG, "No extension provided");
                    return false;
                }
                if (strSubstring.charAt(strSubstring.length() - 1) == '.') {
                    SdkLog.m8378b(TAG, "extension length is 0");
                    return false;
                }
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    zExists = parentFile.exists();
                    if (!zExists) {
                        SdkLog.m8378b(TAG, "Directory does not exist!");
                    }
                } else {
                    SdkLog.m8378b(TAG, "getParentFile() is null ");
                }
            }
            zExists = false;
        }
        if (!zExists || !containsTransactionKey(OplusGLSurfaceView_15, OplusGLSurfaceView_13)) {
            return zExists;
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
        if (OplusGLSurfaceView_13 != 20001) {
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
        SdkLog.m8381c(TAG, "onTransferCompleted() -> ERROR_FATAL");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnCancelAllCompletedErrorCode(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 12) {
            SdkLog.m8381c(TAG, "onCancelAllCompleted() -> ERROR_NOT_SUPPORTED");
        } else if (OplusGLSurfaceView_13 == 13) {
            SdkLog.m8381c(TAG, "onCancelAllCompleted() -> ERROR_TRANSACTION_NOT_FOUND");
        } else {
            SdkLog.m8382d(TAG, "onCancelAllCompleted() error_code: ".concat(String.valueOf(OplusGLSurfaceView_13)));
        }
    }

    private boolean changeFileName(String str, String str2) {
        File file = new File(str2);
        if (file.isFile() && file.exists()) {
            String str3 = str2.substring(0, str2.lastIndexOf("/") + 1) + str2.substring(str.lastIndexOf("/") + 1, str2.lastIndexOf(".")) + System.currentTimeMillis() + str2.substring(str2.lastIndexOf("."));
            if (file.renameTo(new File(str3))) {
                SdkLog.m8375a(TAG, "File successfully renamed ".concat(String.valueOf(str3)));
                file.delete();
            } else {
                SdkLog.m8383e(TAG, "File rename failed");
                return false;
            }
        } else if (new File(str).renameTo(new File(str2))) {
            SdkLog.m8375a(TAG, "File successfully renamed: ".concat(String.valueOf(str2)));
        } else {
            SdkLog.m8383e(TAG, "File rename failed");
            return false;
        }
        return true;
    }

    boolean checkPathPermission(String str) {
        SdkLog.m8378b(TAG, "checkPathPermission calling pkg: " + this.mContext.getPackageName() + " file Path:" + str);
        if (str == null) {
            return false;
        }
        if (str.startsWith("/data/data")) {
            return str.contains(this.mContext.getPackageName());
        }
        return true;
    }

    boolean isInternalPath(String str) {
        return str.startsWith("/data/data");
    }

    /* renamed from: com.heytap.accessory.file.FileTransfer$PlatformImplementations.kt_3 */
    static class C2216a implements Thread.UncaughtExceptionHandler {
        /* synthetic */ C2216a(byte b2) {
            this();
        }

        private C2216a() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public final void uncaughtException(final Thread thread, final Throwable th) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.heytap.accessory.file.FileTransfer.PlatformImplementations.kt_3.1
                @Override // java.lang.Runnable
                public final void run() {
                    SdkLog.m8383e(FileTransfer.TAG, "Exception in FileTransfer Handler thread :" + thread.getName());
                    throw new RuntimeException(th);
                }
            });
        }
    }

    /* renamed from: com.heytap.accessory.file.FileTransfer$IntrinsicsJvm.kt_4 */
    static class HandlerC2217b extends Handler {
        public HandlerC2217b(Looper looper) {
            super(looper);
        }
    }

    private synchronized void putTransaction(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, CallingAgentInfo.PlatformImplementations.kt_3 aVar) {
        if (this.mTransactionsMap != null) {
            ConcurrentHashMap<Integer, CallingAgentInfo.PlatformImplementations.kt_3> concurrentHashMap = this.mTransactionsMap.get(Long.valueOf(OplusGLSurfaceView_15));
            if (concurrentHashMap == null) {
                concurrentHashMap = new ConcurrentHashMap<>();
                this.mTransactionsMap.put(Long.valueOf(OplusGLSurfaceView_15), concurrentHashMap);
            }
            concurrentHashMap.put(Integer.valueOf(OplusGLSurfaceView_13), aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized CallingAgentInfo.PlatformImplementations.kt_3 getTransaction(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
        CallingAgentInfo.PlatformImplementations.kt_3 aVar;
        ConcurrentHashMap<Integer, CallingAgentInfo.PlatformImplementations.kt_3> concurrentHashMap;
        aVar = null;
        if (this.mTransactionsMap != null && (concurrentHashMap = this.mTransactionsMap.get(Long.valueOf(OplusGLSurfaceView_15))) != null) {
            aVar = concurrentHashMap.get(Integer.valueOf(OplusGLSurfaceView_13));
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void removeTransaction(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
        ConcurrentHashMap<Integer, CallingAgentInfo.PlatformImplementations.kt_3> concurrentHashMap;
        if (this.mTransactionsMap != null && (concurrentHashMap = this.mTransactionsMap.get(Long.valueOf(OplusGLSurfaceView_15))) != null) {
            concurrentHashMap.remove(Integer.valueOf(OplusGLSurfaceView_13));
            if (concurrentHashMap.isEmpty()) {
                this.mTransactionsMap.remove(Long.valueOf(OplusGLSurfaceView_15));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void removeTransactionByTransId(int OplusGLSurfaceView_13) {
        Set<Long> setKeySet;
        if (this.mTransactionsMap != null && (setKeySet = this.mTransactionsMap.keySet()) != null) {
            Iterator<Long> it = setKeySet.iterator();
            while (it.hasNext()) {
                removeTransaction(it.next().longValue(), OplusGLSurfaceView_13);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean containsTransactionKey(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
        boolean zContainsKey;
        ConcurrentHashMap<Integer, CallingAgentInfo.PlatformImplementations.kt_3> concurrentHashMap;
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
        SdkLog.m8378b(TAG, "TransferRequest : , connectionId: " + OplusGLSurfaceView_15 + ", transactionId: " + OplusGLSurfaceView_13 + ", isRequest: " + z + ", state: " + getTransactionRequestState(OplusGLSurfaceView_15, OplusGLSurfaceView_13));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean getTransactionRequestState(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
        ConcurrentHashMap<Integer, Boolean> concurrentHashMap = this.mTransferRequestMap.get(Long.valueOf(OplusGLSurfaceView_15));
        if (concurrentHashMap == null) {
            return false;
        }
        return concurrentHashMap.get(Integer.valueOf(OplusGLSurfaceView_13)).booleanValue();
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

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean containsTransactionRequestKey(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
        boolean zContainsKey;
        zContainsKey = false;
        ConcurrentHashMap<Integer, Boolean> concurrentHashMap = this.mTransferRequestMap.get(Long.valueOf(OplusGLSurfaceView_15));
        if (concurrentHashMap != null) {
            zContainsKey = concurrentHashMap.containsKey(Integer.valueOf(OplusGLSurfaceView_13));
        } else {
            SdkLog.m8378b(TAG, "TransferRequest record null");
        }
        return zContainsKey;
    }
}
