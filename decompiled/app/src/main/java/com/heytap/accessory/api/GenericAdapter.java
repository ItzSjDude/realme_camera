package com.heytap.accessory.api;

/* loaded from: classes2.dex */
public class GenericAdapter {

    /* renamed from: a_renamed, reason: collision with root package name */
    static android.content.ServiceConnection f3205a = new android.content.ServiceConnection() { // from class: com.heytap.accessory.api.GenericAdapter.1
        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(android.content.ComponentName componentName) {
            synchronized (com.heytap.accessory.api.GenericAdapter.f3207c) {
                com.heytap.accessory.a_renamed.a_renamed.c_renamed(com.heytap.accessory.api.GenericAdapter.f3206b, "Disconnected from Generic service");
                com.heytap.accessory.api.GenericAdapter.f3207c.i_renamed = null;
                com.heytap.accessory.api.GenericAdapter.f3207c.g_renamed = -1L;
                if (com.heytap.accessory.api.GenericAdapter.f3207c.f_renamed != null) {
                    com.heytap.accessory.api.GenericAdapter.f3207c.f_renamed.send(20001, new android.os.Bundle());
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B_renamed:20:0x00f1 A_renamed[Catch: all -> 0x0103, TryCatch #0 {, blocks: (B_renamed:4:0x0005, B_renamed:6:0x0053, B_renamed:8:0x0064, B_renamed:15:0x00b5, B_renamed:17:0x00bf, B_renamed:9:0x006e, B_renamed:11:0x0076, B_renamed:18:0x00ce, B_renamed:20:0x00f1, B_renamed:21:0x00f8, B_renamed:22:0x0101, B_renamed:14:0x009c), top: B_renamed:27:0x0005, inners: #1 }] */
        @Override // android.content.ServiceConnection
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onServiceConnected(android.content.ComponentName r4, android.os.IBinder r5) {
            /*
                r3 = this;
                com.heytap.accessory.api.GenericAdapter r3 = com.heytap.accessory.api.GenericAdapter.h_renamed()
                monitor-enter(r3)
                com.heytap.accessory.api.GenericAdapter r4 = com.heytap.accessory.api.GenericAdapter.h_renamed()     // Catch: java.lang.Throwable -> L103
                com.heytap.accessory.api.IGenFrameworkManager r5 = com.heytap.accessory.api.IGenFrameworkManager.Stub.a_renamed(r5)     // Catch: java.lang.Throwable -> L103
                com.heytap.accessory.api.GenericAdapter.a_renamed(r4, r5)     // Catch: java.lang.Throwable -> L103
                android.os.Bundle r4 = new android.os.Bundle     // Catch: java.lang.Throwable -> L103
                r4.<init>()     // Catch: java.lang.Throwable -> L103
                com.heytap.accessory.api.GenericAdapter r5 = com.heytap.accessory.api.GenericAdapter.h_renamed()     // Catch: java.lang.Throwable -> L103
                android.content.Context r5 = com.heytap.accessory.api.GenericAdapter.b_renamed(r5)     // Catch: java.lang.Throwable -> L103
                java.lang.String r5 = r5.getPackageName()     // Catch: java.lang.Throwable -> L103
                java.lang.String r0 = com.heytap.accessory.api.GenericAdapter.i_renamed()     // Catch: java.lang.Throwable -> L103
                java.lang.String r1 = "onServiceConnected: packageName: "
                java.lang.String r2 = java.lang.String.valueOf(r5)     // Catch: java.lang.Throwable -> L103
                java.lang.String r1 = r1.concat(r2)     // Catch: java.lang.Throwable -> L103
                com.heytap.accessory.a_renamed.a_renamed.b_renamed(r0, r1)     // Catch: java.lang.Throwable -> L103
                java.lang.String r0 = "packageName"
                r4.putString(r0, r5)     // Catch: java.lang.Throwable -> L103
                java.lang.String r5 = "sdkVersionCode"
                int r0 = com.heytap.accessory.Config.getSdkVersionCode()     // Catch: java.lang.Throwable -> L103
                r4.putInt(r5, r0)     // Catch: java.lang.Throwable -> L103
                java.lang.String r5 = com.heytap.accessory.api.GenericAdapter.i_renamed()     // Catch: java.lang.Throwable -> L103
                java.lang.String r0 = "Getting CMxmlreader instance"
                com.heytap.accessory.a_renamed.a_renamed.c_renamed(r5, r0)     // Catch: java.lang.Throwable -> L103
                com.heytap.accessory.api.GenericAdapter r5 = com.heytap.accessory.api.GenericAdapter.h_renamed()     // Catch: java.lang.Throwable -> L103
                com.heytap.accessory.api.IGenFrameworkManager r5 = com.heytap.accessory.api.GenericAdapter.c_renamed(r5)     // Catch: java.lang.Throwable -> L103
                if (r5 == 0) goto Lce
                com.heytap.accessory.api.GenericAdapter r5 = com.heytap.accessory.api.GenericAdapter.h_renamed()     // Catch: android.os.RemoteException -> L9b java.lang.Throwable -> L103
                com.heytap.accessory.api.IGenFrameworkManager r5 = com.heytap.accessory.api.GenericAdapter.c_renamed(r5)     // Catch: android.os.RemoteException -> L9b java.lang.Throwable -> L103
                r0 = -1
                r2 = 1
                android.os.Bundle r4 = r5.a_renamed(r0, r2, r4)     // Catch: android.os.RemoteException -> L9b java.lang.Throwable -> L103
                if (r4 != 0) goto L6e
                java.lang.String r4 = com.heytap.accessory.api.GenericAdapter.i_renamed()     // Catch: android.os.RemoteException -> L9b java.lang.Throwable -> L103
                java.lang.String r5 = "response is_renamed null"
                com.heytap.accessory.a_renamed.a_renamed.c_renamed(r4, r5)     // Catch: android.os.RemoteException -> L9b java.lang.Throwable -> L103
                goto Lb5
            L6e:
                java.lang.String r5 = "clientId"
                boolean r5 = r4.containsKey(r5)     // Catch: android.os.RemoteException -> L9b java.lang.Throwable -> L103
                if (r5 == 0) goto Lb5
                com.heytap.accessory.api.GenericAdapter r5 = com.heytap.accessory.api.GenericAdapter.h_renamed()     // Catch: android.os.RemoteException -> L9b java.lang.Throwable -> L103
                java.lang.String r0 = "clientId"
                long r0 = r4.getLong(r0)     // Catch: android.os.RemoteException -> L9b java.lang.Throwable -> L103
                com.heytap.accessory.api.GenericAdapter.a_renamed(r5, r0)     // Catch: android.os.RemoteException -> L9b java.lang.Throwable -> L103
                com.heytap.accessory.api.GenericAdapter r4 = com.heytap.accessory.api.GenericAdapter.h_renamed()     // Catch: android.os.RemoteException -> L9b java.lang.Throwable -> L103
                com.heytap.accessory.api.IGenFrameworkManager r4 = com.heytap.accessory.api.GenericAdapter.c_renamed(r4)     // Catch: android.os.RemoteException -> L9b java.lang.Throwable -> L103
                com.heytap.accessory.api.GenericAdapter r5 = com.heytap.accessory.api.GenericAdapter.h_renamed()     // Catch: android.os.RemoteException -> L9b java.lang.Throwable -> L103
                long r0 = com.heytap.accessory.api.GenericAdapter.d_renamed(r5)     // Catch: android.os.RemoteException -> L9b java.lang.Throwable -> L103
                com.heytap.accessory.api.ICMDeathCallback r5 = com.heytap.accessory.api.GenericAdapter.j_renamed()     // Catch: android.os.RemoteException -> L9b java.lang.Throwable -> L103
                r4.a_renamed(r0, r5)     // Catch: android.os.RemoteException -> L9b java.lang.Throwable -> L103
                goto Lb5
            L9b:
                r4 = move-exception
                java.lang.String r5 = com.heytap.accessory.api.GenericAdapter.i_renamed()     // Catch: java.lang.Throwable -> L103
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L103
                java.lang.String r1 = "exception: "
                r0.<init>(r1)     // Catch: java.lang.Throwable -> L103
                java.lang.String r4 = r4.getMessage()     // Catch: java.lang.Throwable -> L103
                r0.append(r4)     // Catch: java.lang.Throwable -> L103
                java.lang.String r4 = r0.toString()     // Catch: java.lang.Throwable -> L103
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(r5, r4)     // Catch: java.lang.Throwable -> L103
            Lb5:
                com.heytap.accessory.api.GenericAdapter r4 = com.heytap.accessory.api.GenericAdapter.h_renamed()     // Catch: java.lang.Throwable -> L103
                android.os.ResultReceiver r4 = com.heytap.accessory.api.GenericAdapter.a_renamed(r4)     // Catch: java.lang.Throwable -> L103
                if (r4 == 0) goto Lce
                com.heytap.accessory.api.GenericAdapter r4 = com.heytap.accessory.api.GenericAdapter.h_renamed()     // Catch: java.lang.Throwable -> L103
                com.heytap.accessory.api.GenericAdapter r5 = com.heytap.accessory.api.GenericAdapter.h_renamed()     // Catch: java.lang.Throwable -> L103
                android.os.ResultReceiver r5 = com.heytap.accessory.api.GenericAdapter.a_renamed(r5)     // Catch: java.lang.Throwable -> L103
                r4.a_renamed(r5)     // Catch: java.lang.Throwable -> L103
            Lce:
                java.lang.String r4 = com.heytap.accessory.api.GenericAdapter.i_renamed()     // Catch: java.lang.Throwable -> L103
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L103
                java.lang.String r0 = "Client ID_renamed:"
                r5.<init>(r0)     // Catch: java.lang.Throwable -> L103
                com.heytap.accessory.api.GenericAdapter r0 = com.heytap.accessory.api.GenericAdapter.h_renamed()     // Catch: java.lang.Throwable -> L103
                long r0 = com.heytap.accessory.api.GenericAdapter.d_renamed(r0)     // Catch: java.lang.Throwable -> L103
                r5.append(r0)     // Catch: java.lang.Throwable -> L103
                java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L103
                com.heytap.accessory.a_renamed.a_renamed.b_renamed(r4, r5)     // Catch: java.lang.Throwable -> L103
                java.util.concurrent.CountDownLatch r4 = com.heytap.accessory.api.GenericAdapter.k_renamed()     // Catch: java.lang.Throwable -> L103
                if (r4 == 0) goto Lf8
                java.util.concurrent.CountDownLatch r4 = com.heytap.accessory.api.GenericAdapter.k_renamed()     // Catch: java.lang.Throwable -> L103
                r4.countDown()     // Catch: java.lang.Throwable -> L103
            Lf8:
                java.lang.String r4 = com.heytap.accessory.api.GenericAdapter.i_renamed()     // Catch: java.lang.Throwable -> L103
                java.lang.String r5 = "onServiceConnected: Just notified"
                com.heytap.accessory.a_renamed.a_renamed.c_renamed(r4, r5)     // Catch: java.lang.Throwable -> L103
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L103
                return
            L103:
                r4 = move-exception
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L103
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.heytap.accessory.api.GenericAdapter.SceneLoader_2.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
        }
    };

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final java.lang.String f3206b = "GenericAdapter";

    /* renamed from: c_renamed, reason: collision with root package name */
    private static volatile com.heytap.accessory.api.GenericAdapter f3207c;
    private static com.heytap.accessory.api.ICMDeathCallback d_renamed;
    private static java.util.concurrent.CountDownLatch e_renamed;
    private android.os.ResultReceiver f_renamed;
    private long g_renamed = -1;
    private android.content.Context h_renamed;
    private com.heytap.accessory.api.IGenFrameworkManager i_renamed;

    private GenericAdapter(android.content.Context context) {
        this.h_renamed = context;
        d_renamed = new com.heytap.accessory.api.GenericAdapter.ICMDeathCallbackStub(context.getPackageName());
    }

    public static com.heytap.accessory.api.GenericAdapter a_renamed(android.content.Context context) throws java.lang.InterruptedException {
        if (f3207c == null) {
            synchronized (com.heytap.accessory.api.GenericAdapter.class) {
                if (f3207c == null) {
                    f3207c = new com.heytap.accessory.api.GenericAdapter(context);
                }
            }
        }
        if (f3207c.i_renamed == null) {
            e_renamed = new java.util.concurrent.CountDownLatch(1);
            android.content.Intent intent = new android.content.Intent(com.heytap.accessory.api.ManagerConfig.INTENT_BASE_FRAMEWORK_SERVICE);
            if (com.heytap.accessory.Initializer.useOAFApp()) {
                intent.setPackage(com.heytap.accessory.api.ManagerConfig.ACCESSORY_FRAMEWORK_PACKAGE);
            } else {
                intent.setPackage(context.getPackageName());
            }
            if (!context.bindService(intent, f3205a, 1)) {
                com.heytap.accessory.a_renamed.a_renamed.d_renamed(f3206b, "bind INTENT_BASE_FRAMEWORK_SERVICE failed!");
                if (f3207c.f_renamed != null) {
                    f3207c.f_renamed.send(20001, new android.os.Bundle());
                }
                return f3207c;
            }
            try {
                com.heytap.accessory.a_renamed.a_renamed.b_renamed(f3206b, "start count down latch");
                e_renamed.await(3000L, java.util.concurrent.TimeUnit.MILLISECONDS);
            } catch (java.lang.Exception unused) {
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(f3206b, "bind GAdapter error.");
            }
        }
        return f3207c;
    }

    public synchronized boolean a_renamed() {
        return f3207c.f_renamed != null;
    }

    public synchronized boolean b_renamed() {
        return this.i_renamed != null;
    }

    public synchronized boolean a_renamed(android.os.ResultReceiver resultReceiver) {
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(f3206b, "Register callback");
        android.os.Bundle bundle = new android.os.Bundle();
        f3207c.f_renamed = resultReceiver;
        bundle.putParcelable("resultReceiver", b_renamed(resultReceiver));
        try {
            if (a_renamed(this.i_renamed, this.g_renamed, 6, bundle).getInt("statusCode", -1) == 0) {
                return true;
            }
        } catch (android.os.RemoteException e2) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(f3206b, "exception: " + e2.getMessage());
        }
        return false;
    }

    public synchronized int a_renamed(com.heytap.accessory.accessorymanager.ConnectConfig connectConfig) {
        int i_renamed;
        i_renamed = -1;
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putAll(connectConfig.getBundle());
        try {
            i_renamed = a_renamed(this.i_renamed, this.g_renamed, 8, bundle).getInt("statusCode");
        } catch (android.os.RemoteException e2) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(f3206b, "exception: connect " + e2.getMessage());
            e2.printStackTrace();
        }
        return i_renamed;
    }

    private synchronized android.os.Bundle a_renamed(com.heytap.accessory.api.IGenFrameworkManager iGenFrameworkManager, long j_renamed, int i_renamed, android.os.Bundle bundle) throws android.os.RemoteException {
        android.os.Bundle bundle2 = new android.os.Bundle();
        if (iGenFrameworkManager == null) {
            bundle2.putInt("statusCode", -1);
            com.heytap.accessory.a_renamed.a_renamed.d_renamed(f3206b, "proxy is_renamed null, maybe you need to bind oaf service.");
            return bundle2;
        }
        android.os.Bundle bundleA = this.i_renamed.a_renamed(j_renamed, i_renamed, bundle);
        if (bundleA != null) {
            return bundleA;
        }
        throw new android.os.RemoteException("command not support:" + i_renamed + ", please update oaf.");
    }

    public synchronized int a_renamed(java.lang.String str, int i_renamed, int i2) {
        int i3;
        i3 = -1;
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("address", str);
        bundle.putInt("transportType", i_renamed);
        bundle.putInt(com.heytap.accessory.constant.AFConstants.EXTRA_UUID, i2);
        try {
            i3 = a_renamed(this.i_renamed, this.g_renamed, 3, bundle).getInt("statusCode");
        } catch (android.os.RemoteException e2) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(f3206b, "exception: disconnect " + e2.getMessage());
            e2.printStackTrace();
        }
        return i3;
    }

    public synchronized int a_renamed(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        android.os.Bundle bundle;
        bundle = new android.os.Bundle();
        bundle.putByteArray(com.heytap.accessory.constant.AFConstants.EXTRA_CONNECT_PARAM_DEVICE_ID, bArr);
        bundle.putByteArray(com.heytap.accessory.constant.AFConstants.EXTRA_CONNECT_PARAM_KSC_ALIAS, bArr2);
        bundle.putByteArray(com.heytap.accessory.constant.AFConstants.EXTRA_CONNECT_PARAM_KSC, bArr3);
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(f3206b, "adapter setKsc, deviceId:" + com.heytap.accessory.b_renamed.e_renamed.b_renamed(bArr) + ", alias:" + com.heytap.accessory.b_renamed.e_renamed.b_renamed(bArr2));
        try {
        } catch (android.os.RemoteException e2) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(f3206b, "exception: " + e2.getMessage());
            return -1;
        }
        return a_renamed(this.i_renamed, this.g_renamed, 9, bundle).getInt("statusCode");
    }

    public synchronized int a_renamed(byte[] bArr, byte[] bArr2) {
        android.os.Bundle bundle;
        bundle = new android.os.Bundle();
        bundle.putByteArray(com.heytap.accessory.constant.AFConstants.EXTRA_CONNECT_PARAM_DEVICE_ID, bArr);
        bundle.putByteArray(com.heytap.accessory.constant.AFConstants.EXTRA_CONNECT_PARAM_KSC_ALIAS, bArr2);
        try {
        } catch (android.os.RemoteException e2) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(f3206b, "exception: " + e2.getMessage());
            return -1;
        }
        return a_renamed(this.i_renamed, this.g_renamed, 20, bundle).getInt("statusCode");
    }

    public synchronized int b_renamed(byte[] bArr, byte[] bArr2) {
        android.os.Bundle bundle;
        bundle = new android.os.Bundle();
        bundle.putByteArray(com.heytap.accessory.constant.AFConstants.EXTRA_CONNECT_PARAM_DEVICE_ID, bArr);
        bundle.putByteArray(com.heytap.accessory.constant.AFConstants.EXTRA_CONNECT_PARAM_KSC_ALIAS, bArr2);
        try {
        } catch (android.os.RemoteException e2) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(f3206b, "exception: " + e2.getMessage());
            return -1;
        }
        return a_renamed(this.i_renamed, this.g_renamed, 21, bundle).getInt("statusCode");
    }

    public synchronized int a_renamed(com.heytap.accessory.bean.TrafficControlConfig trafficControlConfig) {
        android.os.Bundle bundle;
        bundle = trafficControlConfig.getBundle();
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(f3206b, "setTrafficControlConfig = ".concat(java.lang.String.valueOf(trafficControlConfig)));
        try {
        } catch (android.os.RemoteException e2) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(f3206b, "exception: " + e2.getMessage());
            return -1;
        }
        return a_renamed(this.i_renamed, this.g_renamed, 30, bundle).getInt("statusCode");
    }

    public synchronized int a_renamed(boolean z_renamed) {
        android.os.Bundle bundle;
        bundle = new android.os.Bundle();
        bundle.putBoolean(com.heytap.accessory.constant.AFConstants.EXTRA_DORMANT_STATE, z_renamed);
        try {
        } catch (android.os.RemoteException e2) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(f3206b, "exception: connect " + e2.getMessage());
            e2.printStackTrace();
            return -1;
        }
        return a_renamed(this.i_renamed, this.g_renamed, 11, bundle).getInt("statusCode");
    }

    public synchronized byte[] c_renamed() {
        byte[] byteArray;
        try {
            byteArray = a_renamed(this.i_renamed, this.g_renamed, 22, new android.os.Bundle()).getByteArray("extra_local_device_id");
            if (byteArray == null) {
                com.heytap.accessory.a_renamed.a_renamed.d_renamed(f3206b, "getPresentDeviceId null");
            } else {
                com.heytap.accessory.a_renamed.a_renamed.b_renamed(f3206b, "getPresentDeviceId success");
            }
        } catch (android.os.RemoteException e2) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(f3206b, "getPresentDeviceId exception: " + e2.getMessage());
            return null;
        }
        return byteArray;
    }

    public synchronized int d_renamed() throws android.os.RemoteException {
        return a_renamed(this.i_renamed, this.g_renamed, 23, new android.os.Bundle()).getInt(com.heytap.accessory.constant.AFConstants.EXTRA_LOCAL_DEVICE_TYPE);
    }

    public synchronized java.util.List<com.heytap.accessory.bean.AccountInfo> e_renamed() {
        android.os.Bundle bundleA;
        android.os.Bundle bundle = new android.os.Bundle();
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(f3206b, "adapter getAccountInfoArray = ".concat(java.lang.String.valueOf(bundle)));
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            bundleA = a_renamed(this.i_renamed, this.g_renamed, 10, bundle);
            bundleA.setClassLoader(com.heytap.accessory.bean.AccountInfo.class.getClassLoader());
        } catch (android.os.RemoteException e2) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(f3206b, "exception: " + e2.getMessage());
        }
        if (bundleA.getInt(com.heytap.accessory.constant.AFConstants.EXTRA_CONNECT_PARAM_ACCOUNT_SIZE) == 0) {
            return arrayList;
        }
        arrayList = bundleA.getParcelableArrayList(com.heytap.accessory.constant.AFConstants.EXTRA_CONNECT_PARAM_ACCOUNT_LIST);
        return arrayList;
    }

    public synchronized java.util.List<com.heytap.accessory.bean.PeerAccessory> f_renamed() {
        java.util.ArrayList arrayList;
        arrayList = new java.util.ArrayList();
        try {
            android.os.Bundle bundleA = a_renamed(this.i_renamed, this.g_renamed, 4, new android.os.Bundle());
            bundleA.setClassLoader(com.heytap.accessory.bean.PeerAccessory.class.getClassLoader());
            if (bundleA.getInt("statusCode", -1) == 0) {
                arrayList = bundleA.getParcelableArrayList("connectedAccessories");
            }
        } catch (android.os.RemoteException e2) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(f3206b, "exception: " + e2.getMessage());
        }
        return arrayList;
    }

    public synchronized java.util.List<com.heytap.accessory.bean.ServiceProfile> a_renamed(long j_renamed) {
        java.util.ArrayList arrayList;
        arrayList = new java.util.ArrayList();
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putLong("accessoryId", j_renamed);
        try {
            android.os.Bundle bundleA = a_renamed(this.i_renamed, this.g_renamed, 12, bundle);
            bundleA.setClassLoader(com.heytap.accessory.bean.ServiceProfile.class.getClassLoader());
            if (bundleA.getInt("statusCode", -1) == 0) {
                arrayList = bundleA.getParcelableArrayList("remoteServices");
            }
            java.lang.String str = f3206b;
            java.lang.StringBuilder sb = new java.lang.StringBuilder("return accessoryId:");
            sb.append(j_renamed);
            sb.append(" services size:");
            sb.append(arrayList != null ? java.lang.Integer.valueOf(arrayList.size()) : "null");
            com.heytap.accessory.a_renamed.a_renamed.b_renamed(str, sb.toString());
        } catch (android.os.RemoteException e2) {
            com.heytap.accessory.a_renamed.a_renamed.e_renamed(f3206b, "getAvailableServices exception: " + e2.getMessage());
        }
        return arrayList;
    }

    public synchronized void g_renamed() {
        android.os.Bundle bundle = new android.os.Bundle();
        if (f3207c.i_renamed != null) {
            try {
                if (a_renamed(f3207c.i_renamed, f3207c.g_renamed, 5, bundle).getInt("statusCode", -1) == 0) {
                    com.heytap.accessory.a_renamed.a_renamed.b_renamed(f3206b, "Framework connection terminated successfully.");
                }
            } catch (android.os.RemoteException e2) {
                com.heytap.accessory.a_renamed.a_renamed.e_renamed(f3206b, "exception: " + e2.getMessage());
            }
            if (f3207c.h_renamed != null) {
                try {
                    f3207c.h_renamed.unbindService(f3205a);
                } catch (java.lang.Exception e3) {
                    com.heytap.accessory.a_renamed.a_renamed.e_renamed(f3206b, "exception: unbind");
                    e3.printStackTrace();
                }
            }
            f3207c.i_renamed = null;
            f3207c.g_renamed = -1L;
            f3207c.f_renamed = null;
        }
    }

    private android.os.ResultReceiver b_renamed(android.os.ResultReceiver resultReceiver) {
        android.os.Parcel parcelObtain = android.os.Parcel.obtain();
        resultReceiver.writeToParcel(parcelObtain, 0);
        parcelObtain.setDataPosition(0);
        android.os.ResultReceiver resultReceiver2 = (android.os.ResultReceiver) android.os.ResultReceiver.CREATOR.createFromParcel(parcelObtain);
        parcelObtain.recycle();
        return resultReceiver2;
    }

    static final class ICMDeathCallbackStub extends com.heytap.accessory.api.ICMDeathCallback.Stub {

        /* renamed from: a_renamed, reason: collision with root package name */
        private java.lang.String f3208a;

        public ICMDeathCallbackStub(java.lang.String str) {
            if (str == null) {
                throw new java.lang.IllegalArgumentException("Invalid packageName:null");
            }
            this.f3208a = str;
        }

        @Override // com.heytap.accessory.api.ICMDeathCallback
        public final java.lang.String a_renamed() throws android.os.RemoteException {
            return this.f3208a;
        }
    }
}
