package com.heytap.accessory.file;

/* loaded from: classes2.dex */
public class FileTransferManager {

    /* renamed from: a_renamed, reason: collision with root package name */
    static final java.lang.String f3337a = "FileTransferManager";
    private static com.heytap.accessory.file.FileTransferManager d_renamed;
    private static final java.util.List<java.lang.String> e_renamed = new java.util.concurrent.CopyOnWriteArrayList();
    private static final java.util.Map<java.lang.String, com.heytap.accessory.file.FileTransfer> f_renamed = new java.util.concurrent.ConcurrentHashMap();
    private static final java.util.concurrent.ConcurrentHashMap<java.lang.String, com.heytap.accessory.file.a_renamed> g_renamed = new java.util.concurrent.ConcurrentHashMap<>();
    private static boolean h_renamed = false;
    private static com.heytap.accessory.file.FileTransferManager.b_renamed i_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    com.heytap.accessory.file.FileTransferManager.a_renamed f3338b;

    /* renamed from: c_renamed, reason: collision with root package name */
    android.content.ServiceConnection f3339c = new android.content.ServiceConnection() { // from class: com.heytap.accessory.file.FileTransferManager.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            if (iBinder != null) {
                com.heytap.accessory.a_renamed.a_renamed.c_renamed(com.heytap.accessory.file.FileTransferManager.f3337a, "inside onServiceConnected mFTServiceConn");
                com.heytap.accessory.core.IFileManager iFileManagerA = com.heytap.accessory.core.IFileManager.Stub.a_renamed(iBinder);
                com.heytap.accessory.file.FileTransferManager fileTransferManager = com.heytap.accessory.file.FileTransferManager.this;
                fileTransferManager.f3338b = new com.heytap.accessory.file.FileTransferManager.a_renamed(fileTransferManager.j_renamed, com.heytap.accessory.file.FileTransferManager.this.j_renamed.getPackageName(), iFileManagerA);
                android.os.HandlerThread handlerThread = new android.os.HandlerThread("FileUpdateReceiverThread");
                handlerThread.start();
                if (handlerThread.getLooper() != null) {
                    com.heytap.accessory.file.FileTransferManager.b_renamed unused = com.heytap.accessory.file.FileTransferManager.i_renamed = new com.heytap.accessory.file.FileTransferManager.b_renamed(handlerThread.getLooper());
                }
                synchronized (com.heytap.accessory.file.FileTransferManager.d_renamed) {
                    boolean unused2 = com.heytap.accessory.file.FileTransferManager.h_renamed = true;
                    com.heytap.accessory.file.FileTransferManager.d_renamed.notifyAll();
                    com.heytap.accessory.a_renamed.a_renamed.c_renamed(com.heytap.accessory.file.FileTransferManager.f3337a, "onServiceConnected: File Transfer service connected");
                }
                return;
            }
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(com.heytap.accessory.file.FileTransferManager.f3337a, "onServiceConnected: File Transfer service not created");
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(android.content.ComponentName componentName) {
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(com.heytap.accessory.file.FileTransferManager.f3337a, "onServiceDisconnected: File Transfer service disconnected");
            if (com.heytap.accessory.file.FileTransferManager.d_renamed != null) {
                com.heytap.accessory.file.FileTransferManager.d_renamed.j_renamed.unbindService(this);
                com.heytap.accessory.file.FileTransferManager.d_renamed.f3338b = null;
                com.heytap.accessory.file.FileTransferManager.c_renamed();
            }
            boolean unused = com.heytap.accessory.file.FileTransferManager.h_renamed = false;
            if (com.heytap.accessory.file.FileTransferManager.i_renamed != null) {
                com.heytap.accessory.file.FileTransferManager.i_renamed.getLooper().quit();
                com.heytap.accessory.file.FileTransferManager.b_renamed unused2 = com.heytap.accessory.file.FileTransferManager.i_renamed = null;
            }
            java.util.Iterator it = com.heytap.accessory.file.FileTransferManager.g_renamed.entrySet().iterator();
            while (it.hasNext()) {
                com.heytap.accessory.file.a_renamed aVar = (com.heytap.accessory.file.a_renamed) ((java.util.Map.Entry) it.next()).getValue();
                if (aVar != null) {
                    java.util.concurrent.ConcurrentHashMap<java.lang.Long, java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.heytap.accessory.file.a_renamed.CallingAgentInfo_2>> concurrentHashMap = aVar.e_renamed;
                    java.util.Iterator<java.util.Map.Entry<java.lang.Long, java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.heytap.accessory.file.a_renamed.CallingAgentInfo_2>>> it2 = concurrentHashMap.entrySet().iterator();
                    while (it2.hasNext()) {
                        for (com.heytap.accessory.file.a_renamed.CallingAgentInfo_2 c0069a : it2.next().getValue().values()) {
                            aVar.f3346b.a_renamed(c0069a.f3349a, c0069a.f3350b, c0069a.d_renamed, 20001);
                        }
                    }
                    concurrentHashMap.clear();
                }
            }
        }
    };
    private android.content.Context j_renamed;
    private com.heytap.accessory.api.IDeathCallback k_renamed;

    static /* synthetic */ com.heytap.accessory.file.FileTransferManager c_renamed() {
        d_renamed = null;
        return null;
    }

    static synchronized com.heytap.accessory.file.FileTransferManager a_renamed(android.content.Context context, java.lang.String str) throws java.lang.IllegalAccessException, com.heytap.accessory.bean.GeneralException {
        com.heytap.accessory.file.FileTransferManager fileTransferManager;
        synchronized (com.heytap.accessory.file.FileTransferManager.class) {
            if (d_renamed == null || d_renamed.f3338b == null) {
                com.heytap.accessory.file.FileTransferManager fileTransferManager2 = new com.heytap.accessory.file.FileTransferManager();
                d_renamed = fileTransferManager2;
                fileTransferManager2.j_renamed = context;
                synchronized (d_renamed) {
                    android.content.Intent intent = new android.content.Intent(com.heytap.accessory.file.FTInitializer.FILE_TRANSFER_SERVICE_INTENT);
                    java.lang.String fileTransferPackageName = com.heytap.accessory.file.FTInitializer.getFileTransferPackageName(d_renamed.j_renamed);
                    if (fileTransferPackageName == null) {
                        throw new com.heytap.accessory.bean.GeneralException(20001, "Package name is_renamed null!");
                    }
                    intent.setPackage(fileTransferPackageName);
                    com.heytap.accessory.a_renamed.a_renamed.c_renamed(f3337a, "getInstance: bindService before".concat(java.lang.String.valueOf(intent)));
                    if (d_renamed.j_renamed.bindService(intent, d_renamed.f3339c, 1)) {
                        try {
                            com.heytap.accessory.a_renamed.a_renamed.c_renamed(f3337a, "SAFTAdapter: About start waiting");
                            d_renamed.wait(com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
                        } catch (java.lang.InterruptedException e2) {
                            e2.printStackTrace();
                        }
                        if (h_renamed) {
                            com.heytap.accessory.a_renamed.a_renamed.c_renamed(f3337a, "getInstance: Woken up_renamed , FTService Connected");
                        } else {
                            throw new com.heytap.accessory.bean.GeneralException(20001, "Timed out trying to bind to FT Service!");
                        }
                    } else {
                        com.heytap.accessory.a_renamed.a_renamed.e_renamed(f3337a, "getInstance: FTService Connection Failed");
                    }
                }
            }
            if (str == null) {
                throw new java.lang.IllegalAccessException("Calling agent was cleared from record. Please re-register your service.");
            }
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(f3337a, str + " is_renamed using FTService");
            fileTransferManager = d_renamed;
        }
        return fileTransferManager;
        return fileTransferManager;
    }

    static boolean a_renamed(com.heytap.accessory.file.FileTransfer fileTransfer, java.lang.String str) {
        if (!e_renamed.contains(str)) {
            e_renamed.add(str);
            f_renamed.put(str, fileTransfer);
            return true;
        }
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(f3337a, "file register : exist");
        return true;
    }

    static void a_renamed(java.lang.String str) {
        e_renamed.remove(str);
        f_renamed.remove(str);
        if (d_renamed != null) {
            if (e_renamed.isEmpty()) {
                com.heytap.accessory.file.FileTransferManager fileTransferManager = d_renamed;
                fileTransferManager.j_renamed.unbindService(fileTransferManager.f3339c);
                d_renamed.f3338b = null;
                h_renamed = false;
                com.heytap.accessory.file.FileTransferManager.b_renamed bVar = i_renamed;
                if (bVar != null) {
                    bVar.getLooper().quit();
                    i_renamed = null;
                }
                com.heytap.accessory.a_renamed.a_renamed.b_renamed(f3337a, "File transfer service disconnected");
                return;
            }
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(f3337a, "Other applications are still using this FT binding");
            return;
        }
        com.heytap.accessory.a_renamed.a_renamed.e_renamed(f3337a, "FT already unbound for this package. Please check whether the calling agent was registered");
    }

    final int a_renamed(android.content.Context context, java.lang.String str, com.heytap.accessory.file.FileTransfer.c_renamed cVar, com.heytap.accessory.bean.PeerAgent peerAgent, java.lang.String str2, java.lang.String str3) throws com.heytap.accessory.bean.UnSupportException {
        com.heytap.accessory.file.a_renamed.c_renamed cVar2;
        int i2;
        if (a_renamed(peerAgent)) {
            throw new com.heytap.accessory.bean.UnSupportException("the peer agent doesn't_renamed support the file feature, please check");
        }
        java.lang.String strB = b_renamed(context, str);
        android.os.Bundle bundleA = null;
        if (str2 != null) {
            java.io.File file = new java.io.File(str3);
            try {
                cVar2 = new com.heytap.accessory.file.a_renamed.c_renamed(4, new com.heytap.accessory.file.a_renamed.f_renamed(str3, "", "", peerAgent.getAgentId(), strB, peerAgent.getAccessoryId(), file.length(), file.getName(), str2, context.getPackageName(), str).a_renamed());
            } catch (org.json.JSONException e2) {
                e2.printStackTrace();
            }
        } else {
            cVar2 = null;
        }
        try {
            if (this.f3338b != null && cVar2 != null) {
                bundleA = this.f3338b.f3342a.a_renamed(cVar2.a_renamed().toString());
            } else {
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(f3337a, "sendFile: invalid state or req is_renamed null");
            }
        } catch (android.os.RemoteException | org.json.JSONException e3) {
            e3.printStackTrace();
        }
        android.os.Bundle bundle = bundleA;
        boolean z_renamed = false;
        if (bundle != null) {
            z_renamed = bundle.getBoolean("STATUS");
            i2 = bundle.getInt("ID_renamed");
        } else {
            i2 = 0;
        }
        if (!a_renamed(java.lang.Long.parseLong(strB), 0L)) {
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(f3337a, "Register death callback fail.");
        }
        if (!z_renamed || !a_renamed(cVar, i2)) {
            return -1;
        }
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(f3337a, "File Pushed and Callback registered");
        return i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B_renamed:36:0x0099 A_renamed[PHI: r3 r4 r10
      0x0099: PHI (r3v13 android.database.Cursor) = (r3v12 android.database.Cursor), (r3v17 android.database.Cursor) binds: [B_renamed:35:0x0097, B_renamed:26:0x0086] A_renamed[DONT_GENERATE, DONT_INLINE]
      0x0099: PHI (r4v5 long) = (r4v4 long), (r4v13 long) binds: [B_renamed:35:0x0097, B_renamed:26:0x0086] A_renamed[DONT_GENERATE, DONT_INLINE]
      0x0099: PHI (r10v2 java.lang.String) = (r10v1 java.lang.String), (r10v4 java.lang.String) binds: [B_renamed:35:0x0097, B_renamed:26:0x0086] A_renamed[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:44:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:51:0x00f3 A_renamed[Catch: RemoteException | JSONException -> 0x00fb, TRY_LEAVE, TryCatch #3 {RemoteException | JSONException -> 0x00fb, blocks: (B_renamed:47:0x00dc, B_renamed:50:0x00e2, B_renamed:51:0x00f3), top: B_renamed:77:0x00dc }] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:57:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:58:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:61:0x011f  */
    /* JADX WARN: Type inference failed for: r0v7, types: [android.os.Bundle] */
    /* JADX WARN: Type inference failed for: r18v2, types: [android.os.Bundle] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final int a_renamed(android.content.Context r21, java.lang.String r22, java.lang.String r23, com.heytap.accessory.file.FileTransfer.c_renamed r24, com.heytap.accessory.bean.PeerAgent r25, android.net.Uri r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 337
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.heytap.accessory.file.FileTransferManager.a_renamed(android.content.Context, java.lang.String, java.lang.String, com.heytap.accessory.file.FileTransfer$c_renamed, com.heytap.accessory.bean.PeerAgent, android.net.Uri):int");
    }

    private java.lang.String b_renamed(android.content.Context context, java.lang.String str) {
        android.content.SharedPreferences sharedPreferences;
        if (android.os.Build.VERSION.SDK_INT > 26) {
            sharedPreferences = this.j_renamed.createDeviceProtectedStorageContext().getSharedPreferences("AccessoryPreferences", 0);
        } else {
            sharedPreferences = this.j_renamed.getApplicationContext().getSharedPreferences("AccessoryPreferences", 0);
        }
        java.lang.String string = sharedPreferences.getString(str, null);
        if (string == null) {
            com.heytap.accessory.a_renamed.a_renamed.d_renamed(f3337a, "Agent id_renamed was not found in_renamed prefs! Fetching from framework,agentName:".concat(java.lang.String.valueOf(str)));
            try {
                string = com.heytap.accessory.BaseAdapter.getDefaultAdapter(context.getApplicationContext()).getLocalAgentId(str);
            } catch (com.heytap.accessory.bean.GeneralException unused) {
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(f3337a, "Fetching from framework failed ");
                string = "";
            }
        }
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(f3337a, "getAgentId :".concat(java.lang.String.valueOf(string)));
        return string;
    }

    private static boolean a_renamed(com.heytap.accessory.bean.PeerAgent peerAgent) {
        return peerAgent == null || peerAgent.getAccessory() == null || !peerAgent.getAccessory().supportFile();
    }

    final boolean a_renamed(com.heytap.accessory.file.FileTransfer.c_renamed cVar, int i2) {
        if (cVar == null) {
            return false;
        }
        try {
            if (this.f3338b != null) {
                return this.f3338b.f3342a.a_renamed(i2, new com.heytap.accessory.file.FileCallbackReceiver(i_renamed, cVar));
            }
            return false;
        } catch (android.os.RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    static final class DeathCallbackStub extends com.heytap.accessory.api.IDeathCallback.Stub {

        /* renamed from: a_renamed, reason: collision with root package name */
        private final java.lang.String f3341a;

        public DeathCallbackStub(java.lang.String str) {
            if (str == null) {
                throw new java.lang.IllegalArgumentException("Invalid packageName:null");
            }
            this.f3341a = str;
        }

        @Override // com.heytap.accessory.api.IDeathCallback
        public final java.lang.String a_renamed() throws android.os.RemoteException {
            return this.f3341a;
        }
    }

    final boolean a_renamed(long j_renamed, long j2) {
        if (this.k_renamed == null) {
            this.k_renamed = new com.heytap.accessory.file.FileTransferManager.DeathCallbackStub(d_renamed.j_renamed.getPackageName());
        }
        try {
            if (this.f3338b != null) {
                return this.f3338b.f3342a.a_renamed(this.k_renamed, j_renamed, j2);
            }
            return false;
        } catch (android.os.RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    static com.heytap.accessory.file.a_renamed b_renamed(java.lang.String str) {
        return g_renamed.get(str);
    }

    final void a_renamed(com.heytap.accessory.file.FileTransfer.c_renamed cVar, long j_renamed, int i2, android.net.Uri uri, boolean z_renamed) {
        com.heytap.accessory.file.a_renamed.c_renamed cVar2;
        if (z_renamed) {
            try {
                if (!a_renamed(cVar, i2)) {
                    com.heytap.accessory.a_renamed.a_renamed.b_renamed(f3337a, "Could not register file event callback. Declining transfer.");
                    cVar.a_renamed(j_renamed, i2, uri.toString(), 3);
                    return;
                }
            } catch (android.os.RemoteException e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (!a_renamed(0L, j_renamed)) {
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(f3337a, "Register death callback fail.");
        }
        try {
            if (uri != null) {
                cVar2 = new com.heytap.accessory.file.a_renamed.c_renamed(5, new com.heytap.accessory.file.a_renamed.e_renamed(j_renamed, i2, uri.toString(), uri.toString(), z_renamed).a_renamed());
            } else {
                cVar2 = new com.heytap.accessory.file.a_renamed.c_renamed(5, new com.heytap.accessory.file.a_renamed.e_renamed(j_renamed, i2, "", "", false).a_renamed());
            }
            android.os.Bundle bundleA = this.f3338b != null ? this.f3338b.f3342a.a_renamed(cVar2.a_renamed().toString()) : null;
            if (bundleA != null) {
                com.heytap.accessory.a_renamed.a_renamed.c_renamed(f3337a, "receiveStatus:".concat(java.lang.String.valueOf(bundleA.getInt("receiveStatus"))));
            } else {
                com.heytap.accessory.a_renamed.a_renamed.c_renamed(f3337a, "File Transfer Daemon could not queue request");
            }
        } catch (org.json.JSONException e3) {
            e3.printStackTrace();
        }
    }

    static void a_renamed(java.lang.String str, com.heytap.accessory.file.a_renamed aVar) {
        g_renamed.put(str, aVar);
    }

    final int c_renamed(java.lang.String str) throws android.os.RemoteException {
        try {
            com.heytap.accessory.file.a_renamed.a_renamed aVar = new com.heytap.accessory.file.a_renamed.a_renamed(str);
            android.os.Bundle bundleA = null;
            try {
                com.heytap.accessory.file.a_renamed.c_renamed cVar = new com.heytap.accessory.file.a_renamed.c_renamed(6, aVar.a_renamed());
                if (this.f3338b != null) {
                    bundleA = this.f3338b.f3342a.a_renamed(cVar.a_renamed().toString());
                }
            } catch (org.json.JSONException e2) {
                e2.printStackTrace();
            }
            if (bundleA != null) {
                return bundleA.getInt("receiveStatus");
            }
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(f3337a, "File Transfer Daemon could not queue request");
            return 1;
        } catch (android.os.RemoteException e3) {
            e3.printStackTrace();
            return 1;
        }
    }

    public static com.heytap.accessory.file.FileTransfer d_renamed(java.lang.String str) {
        return f_renamed.get(str);
    }

    static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        final com.heytap.accessory.core.IFileManager f3342a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private final java.lang.String f3343b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private final android.content.Context f3344c;

        a_renamed(android.content.Context context, java.lang.String str, com.heytap.accessory.core.IFileManager iFileManager) {
            this.f3343b = str;
            this.f3344c = context;
            this.f3342a = iFileManager;
        }
    }

    static class b_renamed extends android.os.Handler {
        public b_renamed(android.os.Looper looper) {
            super(looper);
        }
    }
}
