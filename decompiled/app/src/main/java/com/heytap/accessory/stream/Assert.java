package com.heytap.accessory.stream;

/* compiled from: StreamTransferManager.java */
/* loaded from: classes2.dex */
public class a_renamed {

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final java.lang.String f3398c = "a_renamed";
    private static com.heytap.accessory.stream.a_renamed g_renamed;
    private static com.heytap.accessory.stream.a_renamed.b_renamed i_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    com.heytap.accessory.stream.a_renamed.StreamTransferManager_2 f3399a;

    /* renamed from: b_renamed, reason: collision with root package name */
    android.content.ServiceConnection f3400b = new android.content.ServiceConnection() { // from class: com.heytap.accessory.stream.a_renamed.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            if (iBinder != null) {
                com.heytap.accessory.a_renamed.a_renamed.c_renamed(com.heytap.accessory.stream.a_renamed.f3398c, "inside onServiceConnected mFTServiceConn");
                com.heytap.accessory.core.IStreamManager iStreamManagerA = com.heytap.accessory.core.IStreamManager.Stub.a_renamed(iBinder);
                com.heytap.accessory.stream.a_renamed aVar = com.heytap.accessory.stream.a_renamed.this;
                aVar.f3399a = new com.heytap.accessory.stream.a_renamed.StreamTransferManager_2(aVar.j_renamed, com.heytap.accessory.stream.a_renamed.this.j_renamed.getPackageName(), iStreamManagerA);
                android.os.HandlerThread handlerThread = new android.os.HandlerThread("StreamUpdateReceiverThread");
                handlerThread.start();
                if (handlerThread.getLooper() != null) {
                    com.heytap.accessory.stream.a_renamed.b_renamed unused = com.heytap.accessory.stream.a_renamed.i_renamed = new com.heytap.accessory.stream.a_renamed.b_renamed(handlerThread.getLooper());
                }
                if (com.heytap.accessory.stream.a_renamed.g_renamed != null) {
                    synchronized (com.heytap.accessory.stream.a_renamed.g_renamed) {
                        boolean unused2 = com.heytap.accessory.stream.a_renamed.h_renamed = true;
                        com.heytap.accessory.stream.a_renamed.g_renamed.notifyAll();
                        com.heytap.accessory.a_renamed.a_renamed.c_renamed(com.heytap.accessory.stream.a_renamed.f3398c, "onServiceConnected: Stream Transfer service connected");
                    }
                    return;
                }
                return;
            }
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(com.heytap.accessory.stream.a_renamed.f3398c, "onServiceConnected: Stream Transfer service not created");
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(android.content.ComponentName componentName) {
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(com.heytap.accessory.stream.a_renamed.f3398c, "onServiceDisconnected: Stream Transfer service disconnected");
            if (com.heytap.accessory.stream.a_renamed.g_renamed != null) {
                com.heytap.accessory.stream.a_renamed.g_renamed.j_renamed.unbindService(this);
                com.heytap.accessory.stream.a_renamed.g_renamed.f3399a = null;
                com.heytap.accessory.stream.a_renamed.c_renamed();
            }
            boolean unused = com.heytap.accessory.stream.a_renamed.h_renamed = false;
            if (com.heytap.accessory.stream.a_renamed.i_renamed != null) {
                com.heytap.accessory.stream.a_renamed.i_renamed.getLooper().quit();
                com.heytap.accessory.stream.a_renamed.b_renamed unused2 = com.heytap.accessory.stream.a_renamed.i_renamed = null;
            }
            java.util.Iterator it = com.heytap.accessory.stream.a_renamed.d_renamed.entrySet().iterator();
            while (it.hasNext()) {
                com.heytap.accessory.stream.b_renamed.a_renamed aVar = (com.heytap.accessory.stream.b_renamed.a_renamed) ((java.util.Map.Entry) it.next()).getValue();
                if (aVar != null) {
                    java.util.concurrent.ConcurrentHashMap<java.lang.Long, java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.heytap.accessory.stream.b_renamed.a_renamed.CallingAgentInfo_4>> concurrentHashMapE = aVar.e_renamed();
                    java.util.Iterator<java.util.Map.Entry<java.lang.Long, java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.heytap.accessory.stream.b_renamed.a_renamed.CallingAgentInfo_4>>> it2 = concurrentHashMapE.entrySet().iterator();
                    while (it2.hasNext()) {
                        for (com.heytap.accessory.stream.b_renamed.a_renamed.CallingAgentInfo_4 c0072a : it2.next().getValue().values()) {
                            aVar.b_renamed().a_renamed(c0072a.f3412a, c0072a.f3413b, 20001);
                        }
                    }
                    concurrentHashMapE.clear();
                }
            }
        }
    };
    private android.content.Context j_renamed;
    private static java.util.concurrent.ConcurrentHashMap<java.lang.String, com.heytap.accessory.stream.b_renamed.a_renamed> d_renamed = new java.util.concurrent.ConcurrentHashMap<>();
    private static java.util.List<java.lang.String> e_renamed = new java.util.concurrent.CopyOnWriteArrayList();
    private static java.util.Map<java.lang.String, com.heytap.accessory.stream.StreamTransfer> f_renamed = new java.util.concurrent.ConcurrentHashMap();
    private static boolean h_renamed = false;

    static /* synthetic */ com.heytap.accessory.stream.a_renamed c_renamed() {
        g_renamed = null;
        return null;
    }

    static synchronized com.heytap.accessory.stream.a_renamed a_renamed(android.content.Context context, java.lang.String str) throws java.lang.IllegalAccessException, com.heytap.accessory.bean.GeneralException {
        com.heytap.accessory.stream.a_renamed aVar;
        synchronized (com.heytap.accessory.stream.a_renamed.class) {
            if (g_renamed == null || g_renamed.f3399a == null) {
                com.heytap.accessory.stream.a_renamed aVar2 = new com.heytap.accessory.stream.a_renamed();
                g_renamed = aVar2;
                aVar2.j_renamed = context;
                synchronized (g_renamed) {
                    android.content.Intent intent = new android.content.Intent(com.heytap.accessory.stream.StreamInitializer.STREAM_TRANSFER_SERVICE_INTENT);
                    java.lang.String streamMsgPackageName = com.heytap.accessory.stream.StreamInitializer.getStreamMsgPackageName(g_renamed.j_renamed);
                    if (streamMsgPackageName == null) {
                        throw new com.heytap.accessory.bean.GeneralException(20001, "Package name is_renamed null!");
                    }
                    intent.setPackage(streamMsgPackageName);
                    com.heytap.accessory.a_renamed.a_renamed.c_renamed(f3398c, "getInstance: bindService before=".concat(java.lang.String.valueOf(intent)));
                    if (g_renamed.j_renamed.bindService(intent, g_renamed.f3400b, 1)) {
                        try {
                            com.heytap.accessory.a_renamed.a_renamed.c_renamed(f3398c, "About start waiting");
                            g_renamed.wait(com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
                        } catch (java.lang.InterruptedException e2) {
                            e2.printStackTrace();
                        }
                        if (h_renamed) {
                            com.heytap.accessory.a_renamed.a_renamed.c_renamed(f3398c, "getInstance: Woken up_renamed , StreamService Connected");
                        } else {
                            throw new com.heytap.accessory.bean.GeneralException(20001, "Timed out trying to bind to Stream Service!");
                        }
                    } else {
                        com.heytap.accessory.a_renamed.a_renamed.e_renamed(f3398c, "getInstance: FTService Connection Failed");
                    }
                }
            }
            if (str == null) {
                throw new java.lang.IllegalAccessException("Calling agent was cleared from record. Please re-register your service.");
            }
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(f3398c, str + " is_renamed using StreamService");
            aVar = g_renamed;
        }
        return aVar;
        return aVar;
    }

    final int a_renamed(android.content.Context context, java.lang.String str, com.heytap.accessory.stream.StreamTransfer.b_renamed bVar, com.heytap.accessory.bean.PeerAgent peerAgent, java.io.FileDescriptor fileDescriptor) {
        try {
            return a_renamed(context, str, bVar, peerAgent, android.os.ParcelFileDescriptor.dup(fileDescriptor));
        } catch (java.io.IOException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    final int a_renamed(android.content.Context context, java.lang.String str, com.heytap.accessory.stream.StreamTransfer.b_renamed bVar, com.heytap.accessory.bean.PeerAgent peerAgent, java.io.InputStream inputStream) {
        android.os.ParcelFileDescriptor parcelFileDescriptorA;
        if (inputStream != null) {
            try {
                parcelFileDescriptorA = com.heytap.accessory.stream.a_renamed.a_renamed.a_renamed(inputStream, peerAgent.getAccessory().getTransportType());
            } catch (java.io.IOException e2) {
                e2.printStackTrace();
                return -1;
            }
        } else {
            parcelFileDescriptorA = null;
        }
        return a_renamed(context, str, bVar, peerAgent, parcelFileDescriptorA);
    }

    static boolean a_renamed(com.heytap.accessory.stream.StreamTransfer streamTransfer, java.lang.String str) {
        if (!e_renamed.contains(str)) {
            e_renamed.add(str);
            f_renamed.put(str, streamTransfer);
            return true;
        }
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(f3398c, "stream register : exist");
        return true;
    }

    static void a_renamed(java.lang.String str) {
        com.heytap.accessory.a_renamed.a_renamed.c_renamed(f3398c, "unregister: remove agent in_renamed map:".concat(java.lang.String.valueOf(str)));
        f_renamed.remove(str);
        e_renamed.remove(str);
        if (g_renamed != null) {
            if (e_renamed.isEmpty()) {
                com.heytap.accessory.stream.a_renamed aVar = g_renamed;
                aVar.j_renamed.unbindService(aVar.f3400b);
                g_renamed.f3399a = null;
                h_renamed = false;
                com.heytap.accessory.stream.a_renamed.b_renamed bVar = i_renamed;
                if (bVar != null) {
                    bVar.getLooper().quit();
                    i_renamed = null;
                }
                com.heytap.accessory.a_renamed.a_renamed.b_renamed(f3398c, "Stream transfer service disconnected");
                return;
            }
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(f3398c, "Other applications are still using this FT binding");
            return;
        }
        com.heytap.accessory.a_renamed.a_renamed.e_renamed(f3398c, "FT already unbound for this package. Please check whether the calling agent was registered");
    }

    private int a_renamed(android.content.Context context, java.lang.String str, com.heytap.accessory.stream.StreamTransfer.b_renamed bVar, com.heytap.accessory.bean.PeerAgent peerAgent, android.os.ParcelFileDescriptor parcelFileDescriptor) {
        com.heytap.accessory.stream.b_renamed.e_renamed eVar;
        com.heytap.accessory.stream.b_renamed.g_renamed gVar = new com.heytap.accessory.stream.b_renamed.g_renamed(peerAgent.getAgentId(), b_renamed(context, str), peerAgent.getAccessoryId(), context.getPackageName(), str);
        android.os.Bundle bundleA = null;
        try {
            eVar = new com.heytap.accessory.stream.b_renamed.e_renamed(4, gVar.a_renamed());
        } catch (org.json.JSONException e2) {
            e2.printStackTrace();
            eVar = null;
        }
        try {
            if (this.f3399a != null && eVar != null) {
                android.os.Bundle bundle = new android.os.Bundle();
                bundle.putParcelable("BUNDLE_KEY_SOURCE", parcelFileDescriptor);
                bundleA = this.f3399a.f3402a.a_renamed(eVar.a_renamed().toString(), bundle);
            } else {
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(f3398c, "sendInputStream: invalid state or req is_renamed null");
            }
        } catch (android.os.RemoteException | org.json.JSONException e3) {
            e3.printStackTrace();
        }
        boolean z_renamed = false;
        int i2 = -1;
        if (bundleA != null) {
            z_renamed = bundleA.getBoolean("STATUS");
            i2 = bundleA.getInt("ID_renamed");
        }
        if (z_renamed && a_renamed(bVar, i2)) {
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(f3398c, "Stream Pushed and Callback registered");
        }
        return i2;
    }

    final boolean a_renamed(com.heytap.accessory.stream.StreamTransfer.b_renamed bVar, int i2) {
        if (bVar == null) {
            return false;
        }
        try {
            if (this.f3399a != null) {
                return this.f3399a.f3402a.a_renamed(i2, new com.heytap.accessory.stream.StreamCallbackReceiver(i_renamed, bVar));
            }
            return false;
        } catch (android.os.RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    static com.heytap.accessory.stream.b_renamed.a_renamed b_renamed(java.lang.String str) {
        return d_renamed.get(str);
    }

    final android.os.ParcelFileDescriptor a_renamed(com.heytap.accessory.stream.StreamTransfer.b_renamed bVar, long j_renamed, int i2, boolean z_renamed) {
        android.os.Bundle bundleA;
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(f3398c, "receiveStream connectionId:" + j_renamed + " +transId:" + i2 + " isAccept:" + z_renamed);
        if (z_renamed) {
            try {
                if (!a_renamed(bVar, i2)) {
                    com.heytap.accessory.a_renamed.a_renamed.b_renamed(f3398c, "Could not register stream event callback. Declining transfer.");
                    bVar.a_renamed(j_renamed, i2, 3);
                    return null;
                }
            } catch (android.os.RemoteException e2) {
                e2.printStackTrace();
            }
        }
        try {
            bundleA = this.f3399a != null ? this.f3399a.f3402a.a_renamed(new com.heytap.accessory.stream.b_renamed.e_renamed(5, new com.heytap.accessory.stream.b_renamed.f_renamed(j_renamed, i2, z_renamed, 0).a_renamed()).a_renamed().toString(), new android.os.Bundle()) : null;
        } catch (org.json.JSONException e3) {
            e3.printStackTrace();
        }
        if (bundleA != null) {
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(f3398c, "receiveStatus:".concat(java.lang.String.valueOf(bundleA.getInt("receiveStatus"))));
            return (android.os.ParcelFileDescriptor) bundleA.getParcelable(com.heytap.accessory.stream.StreamTransfer.RECEIVE_PFD);
        }
        com.heytap.accessory.a_renamed.a_renamed.c_renamed(f3398c, "Stream Transfer Daemon could not queue request");
        return null;
    }

    static void a_renamed(java.lang.String str, com.heytap.accessory.stream.b_renamed.a_renamed aVar) {
        d_renamed.put(str, aVar);
    }

    final int a_renamed(java.lang.String str, long j_renamed) throws android.os.RemoteException {
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(f3398c, "[cancelAll] cancelAllTransactions, agentId:" + str + ",connectionId:" + j_renamed);
        try {
            com.heytap.accessory.stream.b_renamed.b_renamed bVar = new com.heytap.accessory.stream.b_renamed.b_renamed(str, j_renamed);
            android.os.Bundle bundleA = null;
            try {
                com.heytap.accessory.stream.b_renamed.e_renamed eVar = new com.heytap.accessory.stream.b_renamed.e_renamed(6, bVar.a_renamed());
                if (this.f3399a != null) {
                    bundleA = this.f3399a.f3402a.a_renamed(eVar.a_renamed().toString(), new android.os.Bundle());
                }
            } catch (org.json.JSONException e2) {
                e2.printStackTrace();
            }
            if (bundleA != null) {
                return bundleA.getInt("receiveStatus");
            }
            com.heytap.accessory.a_renamed.a_renamed.c_renamed(f3398c, "Stream Transfer Daemon could not queue request");
            return 1;
        } catch (android.os.RemoteException e3) {
            e3.printStackTrace();
            return 1;
        }
    }

    public static com.heytap.accessory.stream.StreamTransfer c_renamed(java.lang.String str) {
        return f_renamed.get(str);
    }

    /* compiled from: StreamTransferManager.java */
    /* renamed from: com.heytap.accessory.stream.a_renamed$a_renamed, reason: collision with other inner class name */
    static class StreamTransferManager_2 {

        /* renamed from: a_renamed, reason: collision with root package name */
        com.heytap.accessory.core.IStreamManager f3402a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private java.lang.String f3403b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private android.content.Context f3404c;

        StreamTransferManager_2(android.content.Context context, java.lang.String str, com.heytap.accessory.core.IStreamManager iStreamManager) {
            this.f3403b = str;
            this.f3404c = context;
            this.f3402a = iStreamManager;
        }
    }

    /* compiled from: StreamTransferManager.java */
    static class b_renamed extends android.os.Handler {
        b_renamed(android.os.Looper looper) {
            super(looper);
        }
    }

    public java.lang.String b_renamed(android.content.Context context, java.lang.String str) {
        java.lang.String string = this.j_renamed.getApplicationContext().getSharedPreferences("AccessoryPreferences", 0).getString(str, null);
        if (string == null) {
            com.heytap.accessory.a_renamed.a_renamed.d_renamed(f3398c, "Agent id_renamed was not found in_renamed prefs! Fetching from framework,agentName:".concat(java.lang.String.valueOf(str)));
            try {
                string = com.heytap.accessory.BaseAdapter.getDefaultAdapter(context.getApplicationContext()).getLocalAgentId(str);
            } catch (com.heytap.accessory.bean.GeneralException unused) {
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(f3398c, "Fetching from framework failed ");
                string = "";
            }
        }
        com.heytap.accessory.a_renamed.a_renamed.d_renamed(f3398c, "getAgentId :".concat(java.lang.String.valueOf(string)));
        return string;
    }
}
