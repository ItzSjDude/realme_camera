package com.heytap.accessory.file;

/* loaded from: classes2.dex */
public class FileTransfer {
    public static final java.lang.String ACTION_AFP_FILE_TRANSFER_REQUESTED = "com.heytap.accessory.ftconnection";
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
    private static final java.lang.String FILE_PROVIDER = "androidx.core.content.FileProvider";
    private static final java.lang.String FILE_PROVIDER_V4 = "androidx.core.content.FileProvider";
    private static final int FT_CANCEL_TRANS_ID = -1;
    private static final int FT_DEFAULT_CONNECTION_ID = 0;
    private static final int FT_DEFAULT_TRANS_ID = 0;
    private static final java.lang.String INTERNAL_FTREQUEST_ACTION = "com.heytap.accessory.ftconnection.internal";
    private static final java.lang.String TAG = "FileTransfer";
    private java.lang.String mAgentName;
    private java.lang.Object mCallingAgent;
    private com.heytap.accessory.file.a_renamed mCallingAgentInfo;
    private android.content.Context mContext;
    private com.heytap.accessory.file.FileTransfer.EventListener mEventListener;
    private android.os.HandlerThread mFileTransferHandlerThread;
    private com.heytap.accessory.file.FileTransfer.b_renamed mHandler;
    com.heytap.accessory.file.FileTransfer.c_renamed mLocalCallback;
    private java.util.concurrent.ConcurrentHashMap<java.lang.Long, java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.heytap.accessory.file.a_renamed.CallingAgentInfo_2>> mTransactionsMap;
    private java.util.concurrent.ConcurrentHashMap<java.lang.Long, java.util.concurrent.ConcurrentHashMap<java.lang.Integer, java.lang.Boolean>> mTransferRequestMap;

    public interface EventListener {
        void onCancelAllCompleted(int i_renamed, int i2);

        void onProgressChanged(long j_renamed, int i_renamed, int i2);

        void onTransferCompleted(long j_renamed, int i_renamed, java.lang.String str, int i2);

        void onTransferRequested(long j_renamed, int i_renamed, int i2, com.heytap.accessory.file.a_renamed.d_renamed dVar);
    }

    protected interface c_renamed {
        void a_renamed();

        void a_renamed(long j_renamed, int i_renamed, int i2);

        void a_renamed(long j_renamed, int i_renamed, java.lang.String str, int i2);

        void a_renamed(int[] iArr, int i_renamed);
    }

    public FileTransfer(com.heytap.accessory.BaseAgent baseAgent, com.heytap.accessory.file.FileTransfer.EventListener eventListener) throws com.heytap.accessory.bean.SdkUnsupportedException {
        this(baseAgent, baseAgent.getApplicationContext(), eventListener);
    }

    public FileTransfer(com.heytap.accessory.BaseJobAgent baseJobAgent, com.heytap.accessory.file.FileTransfer.EventListener eventListener) throws com.heytap.accessory.bean.SdkUnsupportedException {
        this(baseJobAgent, baseJobAgent.getApplicationContext(), eventListener);
    }

    public FileTransfer(java.lang.Object obj, android.content.Context context, com.heytap.accessory.file.FileTransfer.EventListener eventListener) throws com.heytap.accessory.bean.SdkUnsupportedException {
        this.mTransactionsMap = new java.util.concurrent.ConcurrentHashMap<>();
        this.mTransferRequestMap = new java.util.concurrent.ConcurrentHashMap<>();
        this.mLocalCallback = new com.heytap.accessory.file.FileTransfer.c_renamed() { // from class: com.heytap.accessory.file.FileTransfer.1
            @Override // com.heytap.accessory.file.FileTransfer.c_renamed
            public final void a_renamed(long j_renamed, int i_renamed, int i2) {
                java.util.concurrent.ConcurrentHashMap concurrentHashMap = (java.util.concurrent.ConcurrentHashMap) com.heytap.accessory.file.FileTransfer.this.mTransactionsMap.get(java.lang.Long.valueOf(j_renamed));
                if (concurrentHashMap == null) {
                    com.heytap.accessory.a_renamed.a_renamed.d_renamed(com.heytap.accessory.file.FileTransfer.TAG, "detailsMap == null");
                    return;
                }
                for (java.util.Map.Entry entry : concurrentHashMap.entrySet()) {
                    if (((com.heytap.accessory.file.a_renamed.CallingAgentInfo_2) entry.getValue()).f3350b == i_renamed && com.heytap.accessory.file.FileTransfer.this.mEventListener != null) {
                        com.heytap.accessory.file.FileTransfer.this.mEventListener.onProgressChanged(j_renamed, ((java.lang.Integer) entry.getKey()).intValue(), i2);
                        return;
                    }
                }
            }

            @Override // com.heytap.accessory.file.FileTransfer.c_renamed
            public final void a_renamed(long j_renamed, int i_renamed, java.lang.String str, int i2) {
                java.util.concurrent.ConcurrentHashMap concurrentHashMap = (java.util.concurrent.ConcurrentHashMap) com.heytap.accessory.file.FileTransfer.this.mTransactionsMap.get(java.lang.Long.valueOf(j_renamed));
                if (concurrentHashMap == null) {
                    com.heytap.accessory.a_renamed.a_renamed.d_renamed(com.heytap.accessory.file.FileTransfer.TAG, "onTransferCompleted detailsMap == null");
                    return;
                }
                for (java.util.Map.Entry entry : concurrentHashMap.entrySet()) {
                    com.heytap.accessory.file.a_renamed.CallingAgentInfo_2 c0069a = (com.heytap.accessory.file.a_renamed.CallingAgentInfo_2) entry.getValue();
                    if (c0069a.f3350b == i_renamed && com.heytap.accessory.file.FileTransfer.this.mEventListener != null) {
                        if (c0069a.f3351c != null && i2 != 0) {
                            java.io.File file = new java.io.File(c0069a.f3351c + "_temp_" + i_renamed);
                            if (!file.isFile() || !file.exists()) {
                                com.heytap.accessory.a_renamed.a_renamed.e_renamed(com.heytap.accessory.file.FileTransfer.TAG, "temp file could not be_renamed deleted - " + c0069a.f3351c);
                            } else if (file.delete()) {
                                com.heytap.accessory.a_renamed.a_renamed.a_renamed(com.heytap.accessory.file.FileTransfer.TAG, "temp file deleted successfully - " + c0069a.f3351c);
                            } else {
                                com.heytap.accessory.a_renamed.a_renamed.e_renamed(com.heytap.accessory.file.FileTransfer.TAG, "temp file could not be_renamed deleted - " + c0069a.f3351c);
                            }
                            c0069a.f3351c = null;
                        }
                        com.heytap.accessory.file.FileTransfer.this.handleOnTransferCompletedErrorCode(i2);
                        com.heytap.accessory.file.FileTransfer.this.mEventListener.onTransferCompleted(j_renamed, ((java.lang.Integer) entry.getKey()).intValue(), str, i2);
                        com.heytap.accessory.file.FileTransfer.this.removeTransaction(j_renamed, ((java.lang.Integer) entry.getKey()).intValue());
                        com.heytap.accessory.file.FileTransfer.this.removeTransactionRequest(j_renamed, i_renamed);
                        return;
                    }
                }
                if (!com.heytap.accessory.file.FileTransfer.this.getTransactionRequestState(j_renamed, i_renamed) || i2 != 9) {
                    if (!com.heytap.accessory.file.FileTransfer.this.containsTransactionRequestKey(j_renamed, i_renamed) || com.heytap.accessory.file.FileTransfer.this.containsTransactionKey(j_renamed, i_renamed) || com.heytap.accessory.file.FileTransfer.this.mEventListener == null) {
                        return;
                    }
                    com.heytap.accessory.file.FileTransfer.this.handleOnTransferCompletedErrorCode(i2);
                    com.heytap.accessory.file.FileTransfer.this.mEventListener.onTransferCompleted(j_renamed, i_renamed, str, i2);
                    com.heytap.accessory.file.FileTransfer.this.removeTransactionRequest(j_renamed, i_renamed);
                    return;
                }
                com.heytap.accessory.a_renamed.a_renamed.b_renamed(com.heytap.accessory.file.FileTransfer.TAG, "Ignoring onTransferCompleted because setup in_renamed progress");
            }

            @Override // com.heytap.accessory.file.FileTransfer.c_renamed
            public final void a_renamed() {
                com.heytap.accessory.a_renamed.a_renamed.b_renamed(com.heytap.accessory.file.FileTransfer.TAG, "onTransferRequested");
            }

            @Override // com.heytap.accessory.file.FileTransfer.c_renamed
            public final void a_renamed(int[] iArr, int i_renamed) {
                for (int i2 : iArr) {
                    java.util.Iterator it = com.heytap.accessory.file.FileTransfer.this.mTransactionsMap.keySet().iterator();
                    while (it.hasNext()) {
                        java.util.concurrent.ConcurrentHashMap concurrentHashMap = (java.util.concurrent.ConcurrentHashMap) com.heytap.accessory.file.FileTransfer.this.mTransactionsMap.get(java.lang.Long.valueOf(((java.lang.Long) it.next()).longValue()));
                        if (concurrentHashMap != null) {
                            for (java.util.Map.Entry entry : concurrentHashMap.entrySet()) {
                                if (((com.heytap.accessory.file.a_renamed.CallingAgentInfo_2) entry.getValue()).f3350b == i2 && com.heytap.accessory.file.FileTransfer.this.mEventListener != null) {
                                    com.heytap.accessory.file.FileTransfer.this.removeTransactionByTransId(((java.lang.Integer) entry.getKey()).intValue());
                                }
                            }
                        }
                    }
                }
                if (com.heytap.accessory.file.FileTransfer.this.mEventListener != null) {
                    com.heytap.accessory.file.FileTransfer.this.handleOnCancelAllCompletedErrorCode(i_renamed);
                    com.heytap.accessory.file.FileTransfer.this.mEventListener.onCancelAllCompleted(-1, i_renamed);
                }
            }
        };
        if (obj != null && eventListener != null) {
            this.mCallingAgent = obj;
            this.mContext = context;
            this.mAgentName = obj.getClass().getName();
            this.mEventListener = eventListener;
            com.heytap.accessory.file.FTInitializer.init(this.mContext);
            if (register()) {
                return;
            }
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "Agent already registered");
            this.mCallingAgentInfo = com.heytap.accessory.file.FileTransferManager.b_renamed(this.mAgentName);
            com.heytap.accessory.file.a_renamed aVar = this.mCallingAgentInfo;
            if (aVar != null) {
                this.mFileTransferHandlerThread = aVar.f3347c;
                this.mHandler = (com.heytap.accessory.file.FileTransfer.b_renamed) this.mCallingAgentInfo.d_renamed;
                this.mTransactionsMap = this.mCallingAgentInfo.e_renamed;
                com.heytap.accessory.file.a_renamed aVar2 = this.mCallingAgentInfo;
                aVar2.f3345a = this.mEventListener;
                aVar2.f3346b = this.mLocalCallback;
                return;
            }
            return;
        }
        throw new java.lang.IllegalArgumentException("FileEventCallback parameter cannot be_renamed null");
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:24:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:32:0x007c  */
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
            java.lang.String r0 = "File path is_renamed wrong!!"
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(r4, r0)     // Catch: java.lang.NullPointerException -> L4a java.lang.IllegalArgumentException -> L4c
            return r1
        L25:
            java.lang.String r6 = "File :"
            java.lang.String r7 = java.lang.String.valueOf(r14)     // Catch: java.lang.NullPointerException -> L4a java.lang.IllegalArgumentException -> L4c
            java.lang.String r6 = r6.concat(r7)     // Catch: java.lang.NullPointerException -> L4a java.lang.IllegalArgumentException -> L4c
            com.heytap.accessory.a_renamed.a_renamed.a_renamed(r4, r6)     // Catch: java.lang.NullPointerException -> L4a java.lang.IllegalArgumentException -> L4c
            java.io.File r6 = new java.io.File     // Catch: java.lang.NullPointerException -> L4a java.lang.IllegalArgumentException -> L4c
            r6.<init>(r14)     // Catch: java.lang.NullPointerException -> L4a java.lang.IllegalArgumentException -> L4c
            android.content.Context r7 = r12.mContext     // Catch: java.lang.NullPointerException -> L4a java.lang.IllegalArgumentException -> L4c
            android.net.Uri r2 = androidx.core.a_renamed.b_renamed.a_renamed(r7, r2, r6)     // Catch: java.lang.NullPointerException -> L4a java.lang.IllegalArgumentException -> L4c
            if (r2 != 0) goto L43
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(r4, r5)     // Catch: java.lang.NullPointerException -> L4a java.lang.IllegalArgumentException -> L4c
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
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(r4, r0)
            goto L5d
        L57:
            r0.printStackTrace()
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(r4, r5)
        L5d:
            r2 = r3
        L5e:
            if (r2 != 0) goto L75
            boolean r0 = r12.isInternalPath(r14)
            if (r0 != 0) goto L67
            goto L75
        L67:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.String r13 = "content uri needs to be_renamed implemented for sending from internal folders.Please check file-transfer sdk documentation for more details"
            r12.<init>(r13)
            throw r12
        L6f:
            java.lang.String r0 = "FTCore version doesnot support content uri"
            com.heytap.accessory.a_renamed.a_renamed.a_renamed(r4, r0)
            r2 = r3
        L75:
            com.heytap.accessory.file.a_renamed$a_renamed r0 = new com.heytap.accessory.file.a_renamed$a_renamed
            r0.<init>()
            if (r2 == 0) goto L80
            java.lang.String r3 = r2.toString()
        L80:
            r10 = r3
            java.lang.String r2 = java.lang.String.valueOf(r10)
            java.lang.String r3 = "FTCore strURI="
            java.lang.String r2 = r3.concat(r2)
            com.heytap.accessory.a_renamed.a_renamed.a_renamed(r4, r2)
            android.content.Context r2 = r12.mContext     // Catch: java.lang.Throwable -> La3
            java.lang.String r3 = r12.mAgentName     // Catch: java.lang.Throwable -> La3
            com.heytap.accessory.file.FileTransferManager r5 = com.heytap.accessory.file.FileTransferManager.a_renamed(r2, r3)     // Catch: java.lang.Throwable -> La3
            android.content.Context r6 = r12.mContext     // Catch: java.lang.Throwable -> La3
            java.lang.String r7 = r12.mAgentName     // Catch: java.lang.Throwable -> La3
            com.heytap.accessory.file.FileTransfer$c_renamed r8 = r12.mLocalCallback     // Catch: java.lang.Throwable -> La3
            r9 = r13
            r11 = r14
            int r1 = r5.a_renamed(r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> La3
            goto La7
        La3:
            r13 = move-exception
            r13.printStackTrace()
        La7:
            java.lang.String r13 = java.lang.String.valueOf(r1)
            java.lang.String r2 = "received tx_renamed from FTCore"
            java.lang.String r13 = r2.concat(r13)
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(r4, r13)
            r0.f3350b = r1
            r0.d_renamed = r14
            r13 = 0
            r12.putTransaction(r13, r1, r0)
        Lbd:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.heytap.accessory.file.FileTransfer.send(com.heytap.accessory.bean.PeerAgent, java.lang.String):int");
    }

    public int send(com.heytap.accessory.bean.PeerAgent peerAgent, android.net.Uri uri) throws com.heytap.accessory.bean.UnSupportException {
        int iA = -1;
        if (validateParam(peerAgent)) {
            java.lang.String fileTransferPackageName = com.heytap.accessory.file.FTInitializer.getFileTransferPackageName(this.mContext);
            if (fileTransferPackageName != null) {
                try {
                    if (uri == null) {
                        com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "File path is_renamed wrong!!");
                        return -1;
                    }
                    com.heytap.accessory.a_renamed.a_renamed.a_renamed(TAG, "File :".concat(java.lang.String.valueOf(uri)));
                    this.mContext.grantUriPermission(fileTransferPackageName, uri, 1);
                } catch (java.lang.Exception e_renamed) {
                    e_renamed.printStackTrace();
                    com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Error grantUriPermission!!");
                }
            } else {
                com.heytap.accessory.a_renamed.a_renamed.a_renamed(TAG, "FTCore version doesnot support content uri");
            }
            com.heytap.accessory.file.a_renamed.CallingAgentInfo_2 c0069a = new com.heytap.accessory.file.a_renamed.CallingAgentInfo_2();
            try {
                iA = com.heytap.accessory.file.FileTransferManager.a_renamed(this.mContext, this.mAgentName).a_renamed(this.mContext, this.mAgentName, "", this.mLocalCallback, peerAgent, uri);
            } catch (com.heytap.accessory.bean.GeneralException | java.lang.IllegalAccessException e2) {
                e2.printStackTrace();
            }
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "received tx_renamed from FTCore".concat(java.lang.String.valueOf(iA)));
            c0069a.f3350b = iA;
            c0069a.d_renamed = uri.toString();
            putTransaction(0L, iA, c0069a);
        }
        return iA;
    }

    public int send(com.heytap.accessory.bean.PeerAgent peerAgent, android.net.Uri uri, java.lang.String str) throws com.heytap.accessory.bean.UnSupportException {
        int iA = -1;
        if (validateParam(peerAgent)) {
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "peerAgent:".concat(java.lang.String.valueOf(peerAgent)));
            java.lang.String fileTransferPackageName = com.heytap.accessory.file.FTInitializer.getFileTransferPackageName(this.mContext);
            if (fileTransferPackageName != null) {
                try {
                    if (uri == null) {
                        com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "File path is_renamed wrong!!");
                        return -1;
                    }
                    com.heytap.accessory.a_renamed.a_renamed.a_renamed(TAG, "File :".concat(java.lang.String.valueOf(uri)));
                    this.mContext.grantUriPermission(fileTransferPackageName, uri, 1);
                } catch (java.lang.Exception e_renamed) {
                    e_renamed.printStackTrace();
                    com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Error grantUriPermission!!");
                }
            } else {
                com.heytap.accessory.a_renamed.a_renamed.a_renamed(TAG, "FTCore version doesnot support content uri");
            }
            com.heytap.accessory.file.a_renamed.CallingAgentInfo_2 c0069a = new com.heytap.accessory.file.a_renamed.CallingAgentInfo_2();
            try {
                iA = com.heytap.accessory.file.FileTransferManager.a_renamed(this.mContext, this.mAgentName).a_renamed(this.mContext, this.mAgentName, str, this.mLocalCallback, peerAgent, uri);
            } catch (com.heytap.accessory.bean.GeneralException | java.lang.IllegalAccessException e2) {
                e2.printStackTrace();
            }
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "received tx_renamed from FTCore".concat(java.lang.String.valueOf(iA)));
            c0069a.f3350b = iA;
            c0069a.d_renamed = uri.toString();
            putTransaction(0L, iA, c0069a);
        }
        return iA;
    }

    private boolean validateParam(com.heytap.accessory.bean.PeerAgent peerAgent) {
        if (peerAgent == null) {
            throw new java.lang.IllegalArgumentException("PeerAgent cannot be_renamed null");
        }
        java.lang.Object obj = this.mCallingAgent;
        if (obj == null || this.mEventListener == null) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Using invalid instance of_renamed FileTransfer(). Please re-register.");
            return false;
        }
        if (obj == null) {
            return true;
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

    /* JADX WARN: Removed duplicated region for block: B_renamed:43:0x00ea A_renamed[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:50:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:51:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:53:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:60:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:61:0x0124  */
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

    public void receive(final long j_renamed, final int i_renamed, final android.net.Uri uri) {
        com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "receive receiveFileUri: " + uri + ", connectionId:" + j_renamed + ", transactionId:" + i_renamed + ", " + hashCode());
        if (this.mCallingAgent != null && this.mEventListener != null) {
            if (containsTransactionRequestKey(j_renamed, i_renamed)) {
                com.heytap.accessory.file.a_renamed.CallingAgentInfo_2 c0069a = new com.heytap.accessory.file.a_renamed.CallingAgentInfo_2();
                c0069a.f3349a = j_renamed;
                c0069a.f3350b = i_renamed;
                c0069a.d_renamed = uri.toString();
                putTransaction(j_renamed, i_renamed, c0069a);
                java.lang.String fileTransferPackageName = com.heytap.accessory.file.FTInitializer.getFileTransferPackageName(this.mContext);
                if (fileTransferPackageName != null) {
                    try {
                        c0069a.f3351c = uri.toString();
                        this.mContext.grantUriPermission(fileTransferPackageName, uri, 2);
                    } catch (java.lang.Exception e_renamed) {
                        e_renamed.printStackTrace();
                        com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Error grantUriPermission!!");
                    }
                } else {
                    com.heytap.accessory.a_renamed.a_renamed.a_renamed(TAG, "Accessory Framework doesn't_renamed support content URI !!");
                }
                this.mHandler.post(new java.lang.Runnable() { // from class: com.heytap.accessory.file.FileTransfer.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            try {
                                com.heytap.accessory.file.FileTransferManager.a_renamed(com.heytap.accessory.file.FileTransfer.this.mContext, com.heytap.accessory.file.FileTransfer.this.mAgentName).a_renamed(com.heytap.accessory.file.FileTransfer.this.mLocalCallback, j_renamed, i_renamed, uri, true);
                            } catch (com.heytap.accessory.bean.GeneralException | java.lang.IllegalAccessException e2) {
                                e2.printStackTrace();
                            }
                        } finally {
                            com.heytap.accessory.file.FileTransfer.this.putTransactionRequest(j_renamed, i_renamed, false);
                        }
                    }
                });
                return;
            }
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "TransactionId: Given[" + i_renamed + "] not exist");
            putTransactionRequest(j_renamed, i_renamed, false);
            throw new java.lang.IllegalArgumentException("Wrong filepath or transaction id_renamed used");
        }
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "Using invalid instance of_renamed FileTransfer(). Please re-register.");
        putTransactionRequest(j_renamed, i_renamed, false);
    }

    public void reject(final long j_renamed, final int i_renamed) {
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "file reject, connId: " + j_renamed + ", transId: " + i_renamed);
        if (this.mCallingAgent != null && this.mEventListener != null) {
            if (checkReceiveParams("", j_renamed, i_renamed) && containsTransactionRequestKey(j_renamed, i_renamed)) {
                com.heytap.accessory.file.a_renamed.CallingAgentInfo_2 c0069a = new com.heytap.accessory.file.a_renamed.CallingAgentInfo_2();
                c0069a.f3350b = i_renamed;
                c0069a.d_renamed = "";
                removeTransaction(j_renamed, i_renamed);
                this.mHandler.post(new java.lang.Runnable() { // from class: com.heytap.accessory.file.FileTransfer.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            com.heytap.accessory.file.FileTransferManager.a_renamed(com.heytap.accessory.file.FileTransfer.this.mContext, com.heytap.accessory.file.FileTransfer.this.mAgentName).a_renamed(null, j_renamed, i_renamed, null, false);
                        } catch (com.heytap.accessory.bean.GeneralException | java.lang.IllegalAccessException e_renamed) {
                            e_renamed.printStackTrace();
                        }
                    }
                });
                return;
            }
            throw new java.lang.IllegalArgumentException("Wrong transaction id_renamed used in_renamed reject()");
        }
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "Using invalid instance of_renamed FileTransfer(). Please re-register.");
    }

    public void cancel(final long j_renamed, final int i_renamed) {
        if (this.mCallingAgent != null && this.mEventListener != null) {
            if (!containsTransactionKey(j_renamed, i_renamed)) {
                throw new java.lang.IllegalArgumentException("Wrong connection(" + j_renamed + ") transaction id_renamed(" + i_renamed + ") used for cancel.");
            }
            this.mHandler.post(new java.lang.Runnable() { // from class: com.heytap.accessory.file.FileTransfer.5
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        com.heytap.accessory.file.a_renamed.CallingAgentInfo_2 transaction = com.heytap.accessory.file.FileTransfer.this.getTransaction(j_renamed, i_renamed);
                        if (transaction == null) {
                            com.heytap.accessory.a_renamed.a_renamed.b_renamed(com.heytap.accessory.file.FileTransfer.TAG, "cancelFile aborted because service connection or transaction already closed.");
                            return;
                        }
                        if (transaction.f3350b == 0) {
                            transaction.f3350b = -1;
                            com.heytap.accessory.a_renamed.a_renamed.b_renamed(com.heytap.accessory.file.FileTransfer.TAG, "Cancel called before transaction id_renamed is_renamed genereated" + i_renamed);
                            return;
                        }
                        if (transaction.f3350b != -1) {
                            com.heytap.accessory.file.FileTransferManager fileTransferManagerA = com.heytap.accessory.file.FileTransferManager.a_renamed(com.heytap.accessory.file.FileTransfer.this.mContext, com.heytap.accessory.file.FileTransfer.this.mAgentName);
                            try {
                                try {
                                    com.heytap.accessory.file.a_renamed.c_renamed cVar = new com.heytap.accessory.file.a_renamed.c_renamed(3, new com.heytap.accessory.file.a_renamed.b_renamed(j_renamed, transaction.f3350b).a_renamed());
                                    if (fileTransferManagerA.f3338b != null) {
                                        fileTransferManagerA.f3338b.f3342a.a_renamed(cVar.a_renamed().toString());
                                        return;
                                    }
                                    return;
                                } catch (org.json.JSONException e_renamed) {
                                    e_renamed.printStackTrace();
                                    return;
                                }
                            } catch (android.os.RemoteException e2) {
                                e2.printStackTrace();
                                return;
                            }
                        }
                        com.heytap.accessory.a_renamed.a_renamed.b_renamed(com.heytap.accessory.file.FileTransfer.TAG, "Cancel called again before transaction id_renamed is_renamed genereated" + i_renamed);
                    } catch (com.heytap.accessory.bean.GeneralException | java.lang.IllegalAccessException e3) {
                        e3.printStackTrace();
                    }
                }
            });
            return;
        }
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "Using invalid instance of_renamed FileTransfer(). Please re-register.");
    }

    public void cancelAll() {
        android.content.SharedPreferences sharedPreferences;
        if (this.mCallingAgent != null && this.mEventListener != null) {
            if (android.os.Build.VERSION.SDK_INT > 26) {
                sharedPreferences = this.mContext.createDeviceProtectedStorageContext().getSharedPreferences("AccessoryPreferences", 0);
            } else {
                sharedPreferences = this.mContext.getApplicationContext().getSharedPreferences("AccessoryPreferences", 0);
            }
            final java.lang.String string = sharedPreferences.getString(this.mAgentName, null);
            if (string == null) {
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "Your service was not found. Please re-register");
                return;
            } else {
                this.mHandler.post(new java.lang.Runnable() { // from class: com.heytap.accessory.file.FileTransfer.6
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            int iC = com.heytap.accessory.file.FileTransferManager.a_renamed(com.heytap.accessory.file.FileTransfer.this.mContext, com.heytap.accessory.file.FileTransfer.this.mAgentName).c_renamed(string);
                            com.heytap.accessory.a_renamed.a_renamed.b_renamed(com.heytap.accessory.file.FileTransfer.TAG, "cancel status ".concat(java.lang.String.valueOf(iC)));
                            com.heytap.accessory.file.FileTransfer.EventListener eventListener = com.heytap.accessory.file.FileTransfer.this.mEventListener;
                            if (eventListener == null) {
                                com.heytap.accessory.a_renamed.a_renamed.d_renamed(com.heytap.accessory.file.FileTransfer.TAG, "[cancelAll] listener is_renamed null.");
                                return;
                            }
                            if (iC == 0) {
                                com.heytap.accessory.file.FileTransfer.this.handleOnCancelAllCompletedErrorCode(12);
                                eventListener.onCancelAllCompleted(-1, 12);
                            } else if (iC == 13) {
                                com.heytap.accessory.file.FileTransfer.this.handleOnCancelAllCompletedErrorCode(13);
                                eventListener.onCancelAllCompleted(-1, 13);
                            } else if (iC == 1) {
                                com.heytap.accessory.file.FileTransfer.this.handleOnCancelAllCompletedErrorCode(0);
                                eventListener.onCancelAllCompleted(-1, 0);
                            }
                        } catch (com.heytap.accessory.bean.GeneralException | java.lang.IllegalAccessException e_renamed) {
                            e_renamed.printStackTrace();
                        }
                    }
                });
                return;
            }
        }
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "Using invalid instance of_renamed  Please re-register.");
    }

    public void close() {
        if (this.mCallingAgent != null && this.mEventListener != null) {
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "stopFileTransferService() called by_renamed : " + this.mAgentName);
            com.heytap.accessory.file.FileTransferManager.a_renamed(this.mAgentName);
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.heytap.accessory.file.a_renamed.CallingAgentInfo_2>> concurrentHashMap = this.mTransactionsMap;
            if (concurrentHashMap != null) {
                concurrentHashMap.clear();
            }
            com.heytap.accessory.file.FileTransfer.b_renamed bVar = this.mHandler;
            if (bVar != null) {
                bVar.removeCallbacksAndMessages(null);
                this.mHandler.getLooper().quit();
            }
            this.mCallingAgent = null;
            this.mEventListener = null;
            return;
        }
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "Using invalid instance of_renamed FileTransfer(). Please re-register.");
    }

    private boolean register() {
        com.heytap.accessory.file.FileTransferManager.a_renamed(this, this.mAgentName);
        this.mFileTransferHandlerThread = new android.os.HandlerThread("FileTransferHandlerThread");
        this.mFileTransferHandlerThread.setUncaughtExceptionHandler(new com.heytap.accessory.file.FileTransfer.a_renamed((byte) 0));
        this.mFileTransferHandlerThread.start();
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "FileTransferHandlerThread started");
        android.os.Looper looper = this.mFileTransferHandlerThread.getLooper();
        if (looper != null) {
            this.mHandler = new com.heytap.accessory.file.FileTransfer.b_renamed(looper);
        }
        if (this.mHandler == null) {
            return false;
        }
        this.mTransactionsMap = new java.util.concurrent.ConcurrentHashMap<>();
        this.mCallingAgentInfo = new com.heytap.accessory.file.a_renamed(this.mEventListener, this.mFileTransferHandlerThread, this.mHandler, this.mLocalCallback, this.mTransactionsMap);
        com.heytap.accessory.file.FileTransferManager.a_renamed(this.mAgentName, this.mCallingAgentInfo);
        this.mHandler.post(new java.lang.Runnable() { // from class: com.heytap.accessory.file.FileTransfer.7
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    com.heytap.accessory.file.FileTransferManager.a_renamed(com.heytap.accessory.file.FileTransfer.this.mContext, com.heytap.accessory.file.FileTransfer.this.mAgentName);
                } catch (com.heytap.accessory.bean.GeneralException | java.lang.IllegalAccessException e_renamed) {
                    e_renamed.printStackTrace();
                }
            }
        });
        return true;
    }

    private java.lang.String getContentURIAuthority() {
        java.util.List<android.content.pm.ProviderInfo> listQueryContentProviders;
        try {
            listQueryContentProviders = this.mContext.getPackageManager().queryContentProviders(this.mContext.getPackageName(), android.os.Process.myUid(), 0);
        } catch (java.lang.RuntimeException e_renamed) {
            e_renamed.printStackTrace();
            listQueryContentProviders = null;
        }
        if (listQueryContentProviders != null) {
            for (android.content.pm.ProviderInfo providerInfo : listQueryContentProviders) {
                if ("androidx.core.content.FileProvider".equalsIgnoreCase(providerInfo.name)) {
                    com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "Authority:" + providerInfo.authority);
                    return providerInfo.authority;
                }
                if ("androidx.core.content.FileProvider".equalsIgnoreCase(providerInfo.name)) {
                    com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "Authority:" + providerInfo.authority);
                    return providerInfo.authority;
                }
            }
        }
        return null;
    }

    public void informIncomingFTRequest(android.content.Context context, android.content.Intent intent) throws java.lang.NumberFormatException {
        android.content.SharedPreferences sharedPreferences;
        final int intExtra = intent.getIntExtra("transId", -1);
        java.lang.String stringExtra = intent.getStringExtra("agentClass");
        final long longExtra = intent.getLongExtra("connectionId", 0L);
        final int i_renamed = java.lang.Integer.parseInt(intent.getStringExtra("contId"));
        final long longExtra2 = intent.getLongExtra("fileSize", 0L);
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "receive incoming FTRequest; transactionId = " + intExtra + "; connectionId = " + longExtra + "; implClass = " + stringExtra + "; fileSize = " + longExtra2 + "; peerAgentId = " + i_renamed);
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
        final com.heytap.accessory.file.a_renamed aVarB = com.heytap.accessory.file.FileTransferManager.b_renamed(stringExtra);
        if (aVarB == null) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "AgentInfo is_renamed NULL! Re-Registering");
            register();
            informIncomingFTRequest(context, intent);
        } else {
            if (aVarB.f3345a == null) {
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "callback is_renamed not registered for ".concat(java.lang.String.valueOf(stringExtra)));
                return;
            }
            final java.lang.String stringExtra2 = intent.getStringExtra(com.oplus.ocs.camera.CameraParameter.WaterMarkParamKeys.FILE_PATH);
            final java.lang.String stringExtra3 = intent.getStringExtra(com.oplus.camera.statistics.CameraStatisticsUtil.RUS_FILE_NAME);
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "Informing app of_renamed incoming file transfer request on_renamed registered callback-tid: ".concat(java.lang.String.valueOf(intExtra)));
            this.mHandler.post(new java.lang.Runnable() { // from class: com.heytap.accessory.file.FileTransfer.8
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        com.heytap.accessory.file.FileTransferManager.a_renamed(com.heytap.accessory.file.FileTransfer.this.mContext, com.heytap.accessory.file.FileTransfer.this.mAgentName).a_renamed(com.heytap.accessory.file.FileTransfer.this.mLocalCallback, intExtra);
                        com.heytap.accessory.file.FileTransfer.this.putTransactionRequest(longExtra, intExtra, true);
                        aVarB.f3345a.onTransferRequested(longExtra, i_renamed, intExtra, new com.heytap.accessory.file.a_renamed.d_renamed.a_renamed().a_renamed(stringExtra3).a_renamed(longExtra2).b_renamed(stringExtra2).a_renamed());
                    } catch (com.heytap.accessory.bean.GeneralException | java.lang.IllegalAccessException e_renamed) {
                        e_renamed.printStackTrace();
                    }
                }
            });
        }
    }

    private void checkSource(java.lang.String str) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("localSrc must not be_renamed null!");
        }
        if (str.length() != 0 && checkPathPermission(str)) {
            try {
                com.heytap.accessory.a_renamed.a_renamed.a_renamed(TAG, "File has a_renamed valid extentsion: ".concat(java.lang.String.valueOf(str.substring(str.lastIndexOf(".")))));
                android.net.Uri uri = android.net.Uri.parse(str);
                if ("file".equalsIgnoreCase(uri.getScheme())) {
                    str = uri.getPath();
                    if (str != null) {
                        com.heytap.accessory.a_renamed.a_renamed.a_renamed(TAG, "URI scheme is_renamed SCHEME_FILE  File Path : ".concat(java.lang.String.valueOf(str)));
                    }
                } else if ("content".equalsIgnoreCase(uri.getScheme())) {
                    android.database.Cursor cursorQuery = this.mContext.getContentResolver().query(uri, new java.lang.String[]{com.android.providers.downloads.Downloads.Impl._DATA}, null, null, null);
                    if (cursorQuery != null && cursorQuery.moveToFirst()) {
                        try {
                            str = cursorQuery.getString(0);
                            if (str != null) {
                                com.heytap.accessory.a_renamed.a_renamed.a_renamed(TAG, "URI ContentResolver is_renamed SCHEME_CONTENT File Path : ".concat(java.lang.String.valueOf(str)));
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
                    com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "srcToSend is_renamed null");
                    return;
                }
                java.io.File file = new java.io.File(str);
                if (!file.exists()) {
                    throw new java.lang.IllegalArgumentException("File doesnot exist");
                }
                if (file.isDirectory()) {
                    throw new java.lang.IllegalArgumentException("File is_renamed a_renamed directory");
                }
                if (file.length() == 0) {
                    throw new java.lang.IllegalArgumentException("File length is_renamed 0");
                }
                com.heytap.accessory.a_renamed.a_renamed.a_renamed(TAG, "File is_renamed valid !!");
                return;
            } catch (java.lang.StringIndexOutOfBoundsException e_renamed) {
                e_renamed.printStackTrace();
                throw new java.lang.IllegalArgumentException("Wrong file..does not have extension");
            }
        }
        throw new java.lang.IllegalArgumentException("Wrong file path");
    }

    private boolean checkReceiveParams(java.lang.String str, long j_renamed, int i_renamed) {
        boolean zExists = true;
        if (str == null) {
            zExists = false;
        } else if (str.length() != 0) {
            if (!checkPathPermission(str)) {
                com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "checkReceiveParams return false, internal path");
                return false;
            }
            java.io.File file = new java.io.File(str);
            if (file.isDirectory()) {
                com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "given path is_renamed a_renamed directory");
            } else {
                java.lang.String strSubstring = str.substring(str.lastIndexOf("/") + 1);
                if (!strSubstring.contains(".")) {
                    com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "No extension provided");
                    return false;
                }
                if (strSubstring.charAt(strSubstring.length() - 1) == '.') {
                    com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "extension length is_renamed 0");
                    return false;
                }
                java.io.File parentFile = file.getParentFile();
                if (parentFile != null) {
                    zExists = parentFile.exists();
                    if (!zExists) {
                        com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "Directory does not exist!");
                    }
                } else {
                    com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "getParentFile() is_renamed null ");
                }
            }
            zExists = false;
        }
        if (!zExists || !containsTransactionKey(j_renamed, i_renamed)) {
            return zExists;
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
        if (i_renamed != 20001) {
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
        com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onTransferCompleted() -> ERROR_FATAL");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnCancelAllCompletedErrorCode(int i_renamed) {
        if (i_renamed == 12) {
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onCancelAllCompleted() -> ERROR_NOT_SUPPORTED");
        } else if (i_renamed == 13) {
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(TAG, "onCancelAllCompleted() -> ERROR_TRANSACTION_NOT_FOUND");
        } else {
            com.heytap.accessory.a_renamed.a_renamed.d_renamed(TAG, "onCancelAllCompleted() error_code: ".concat(java.lang.String.valueOf(i_renamed)));
        }
    }

    private boolean changeFileName(java.lang.String str, java.lang.String str2) {
        java.io.File file = new java.io.File(str2);
        if (file.isFile() && file.exists()) {
            java.lang.String str3 = str2.substring(0, str2.lastIndexOf("/") + 1) + str2.substring(str.lastIndexOf("/") + 1, str2.lastIndexOf(".")) + java.lang.System.currentTimeMillis() + str2.substring(str2.lastIndexOf("."));
            if (file.renameTo(new java.io.File(str3))) {
                com.heytap.accessory.a_renamed.a_renamed.a_renamed(TAG, "File successfully renamed ".concat(java.lang.String.valueOf(str3)));
                file.delete();
            } else {
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "File rename failed");
                return false;
            }
        } else if (new java.io.File(str).renameTo(new java.io.File(str2))) {
            com.heytap.accessory.a_renamed.a_renamed.a_renamed(TAG, "File successfully renamed: ".concat(java.lang.String.valueOf(str2)));
        } else {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(TAG, "File rename failed");
            return false;
        }
        return true;
    }

    boolean checkPathPermission(java.lang.String str) {
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "checkPathPermission calling pkg: " + this.mContext.getPackageName() + " file Path:" + str);
        if (str == null) {
            return false;
        }
        if (str.startsWith("/data/data")) {
            return str.contains(this.mContext.getPackageName());
        }
        return true;
    }

    boolean isInternalPath(java.lang.String str) {
        return str.startsWith("/data/data");
    }

    static class a_renamed implements java.lang.Thread.UncaughtExceptionHandler {
        /* synthetic */ a_renamed(byte b2) {
            this();
        }

        private a_renamed() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public final void uncaughtException(final java.lang.Thread thread, final java.lang.Throwable th) {
            new android.os.Handler(android.os.Looper.getMainLooper()).post(new java.lang.Runnable() { // from class: com.heytap.accessory.file.FileTransfer.a_renamed.1
                @Override // java.lang.Runnable
                public final void run() {
                    com.heytap.accessory.a_renamed.a_renamed.e_renamed(com.heytap.accessory.file.FileTransfer.TAG, "Exception in_renamed FileTransfer Handler thread :" + thread.getName());
                    throw new java.lang.RuntimeException(th);
                }
            });
        }
    }

    static class b_renamed extends android.os.Handler {
        public b_renamed(android.os.Looper looper) {
            super(looper);
        }
    }

    private synchronized void putTransaction(long j_renamed, int i_renamed, com.heytap.accessory.file.a_renamed.CallingAgentInfo_2 c0069a) {
        if (this.mTransactionsMap != null) {
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.heytap.accessory.file.a_renamed.CallingAgentInfo_2> concurrentHashMap = this.mTransactionsMap.get(java.lang.Long.valueOf(j_renamed));
            if (concurrentHashMap == null) {
                concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<>();
                this.mTransactionsMap.put(java.lang.Long.valueOf(j_renamed), concurrentHashMap);
            }
            concurrentHashMap.put(java.lang.Integer.valueOf(i_renamed), c0069a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized com.heytap.accessory.file.a_renamed.CallingAgentInfo_2 getTransaction(long j_renamed, int i_renamed) {
        com.heytap.accessory.file.a_renamed.CallingAgentInfo_2 c0069a;
        java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.heytap.accessory.file.a_renamed.CallingAgentInfo_2> concurrentHashMap;
        c0069a = null;
        if (this.mTransactionsMap != null && (concurrentHashMap = this.mTransactionsMap.get(java.lang.Long.valueOf(j_renamed))) != null) {
            c0069a = concurrentHashMap.get(java.lang.Integer.valueOf(i_renamed));
        }
        return c0069a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void removeTransaction(long j_renamed, int i_renamed) {
        java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.heytap.accessory.file.a_renamed.CallingAgentInfo_2> concurrentHashMap;
        if (this.mTransactionsMap != null && (concurrentHashMap = this.mTransactionsMap.get(java.lang.Long.valueOf(j_renamed))) != null) {
            concurrentHashMap.remove(java.lang.Integer.valueOf(i_renamed));
            if (concurrentHashMap.isEmpty()) {
                this.mTransactionsMap.remove(java.lang.Long.valueOf(j_renamed));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void removeTransactionByTransId(int i_renamed) {
        java.util.Set<java.lang.Long> setKeySet;
        if (this.mTransactionsMap != null && (setKeySet = this.mTransactionsMap.keySet()) != null) {
            java.util.Iterator<java.lang.Long> it = setKeySet.iterator();
            while (it.hasNext()) {
                removeTransaction(it.next().longValue(), i_renamed);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean containsTransactionKey(long j_renamed, int i_renamed) {
        boolean zContainsKey;
        java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.heytap.accessory.file.a_renamed.CallingAgentInfo_2> concurrentHashMap;
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
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "TransferRequest : , connectionId: " + j_renamed + ", transactionId: " + i_renamed + ", isRequest: " + z_renamed + ", state: " + getTransactionRequestState(j_renamed, i_renamed));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean getTransactionRequestState(long j_renamed, int i_renamed) {
        java.util.concurrent.ConcurrentHashMap<java.lang.Integer, java.lang.Boolean> concurrentHashMap = this.mTransferRequestMap.get(java.lang.Long.valueOf(j_renamed));
        if (concurrentHashMap == null) {
            return false;
        }
        return concurrentHashMap.get(java.lang.Integer.valueOf(i_renamed)).booleanValue();
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

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean containsTransactionRequestKey(long j_renamed, int i_renamed) {
        boolean zContainsKey;
        zContainsKey = false;
        java.util.concurrent.ConcurrentHashMap<java.lang.Integer, java.lang.Boolean> concurrentHashMap = this.mTransferRequestMap.get(java.lang.Long.valueOf(j_renamed));
        if (concurrentHashMap != null) {
            zContainsKey = concurrentHashMap.containsKey(java.lang.Integer.valueOf(i_renamed));
        } else {
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(TAG, "TransferRequest record null");
        }
        return zContainsKey;
    }
}
