package androidx.e_renamed.a_renamed;

/* compiled from: LocalBroadcastManager.java */
/* loaded from: classes.dex */
public final class a_renamed {
    private static final java.lang.Object f_renamed = new java.lang.Object();
    private static androidx.e_renamed.a_renamed.a_renamed g_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.content.Context f1084a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.util.HashMap<android.content.BroadcastReceiver, java.util.ArrayList<androidx.e_renamed.a_renamed.a_renamed.b_renamed>> f1085b = new java.util.HashMap<>();

    /* renamed from: c_renamed, reason: collision with root package name */
    private final java.util.HashMap<java.lang.String, java.util.ArrayList<androidx.e_renamed.a_renamed.a_renamed.b_renamed>> f1086c = new java.util.HashMap<>();
    private final java.util.ArrayList<androidx.e_renamed.a_renamed.a_renamed.LocalBroadcastManager_3> d_renamed = new java.util.ArrayList<>();
    private final android.os.Handler e_renamed;

    /* compiled from: LocalBroadcastManager.java */
    private static final class b_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        final android.content.IntentFilter f1090a;

        /* renamed from: b_renamed, reason: collision with root package name */
        final android.content.BroadcastReceiver f1091b;

        /* renamed from: c_renamed, reason: collision with root package name */
        boolean f1092c;
        boolean d_renamed;

        b_renamed(android.content.IntentFilter intentFilter, android.content.BroadcastReceiver broadcastReceiver) {
            this.f1090a = intentFilter;
            this.f1091b = broadcastReceiver;
        }

        public java.lang.String toString() {
            java.lang.StringBuilder sb = new java.lang.StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.f1091b);
            sb.append(" filter=");
            sb.append(this.f1090a);
            if (this.d_renamed) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    /* compiled from: LocalBroadcastManager.java */
    /* renamed from: androidx.e_renamed.a_renamed.a_renamed$a_renamed, reason: collision with other inner class name */
    private static final class LocalBroadcastManager_3 {

        /* renamed from: a_renamed, reason: collision with root package name */
        final android.content.Intent f1088a;

        /* renamed from: b_renamed, reason: collision with root package name */
        final java.util.ArrayList<androidx.e_renamed.a_renamed.a_renamed.b_renamed> f1089b;

        LocalBroadcastManager_3(android.content.Intent intent, java.util.ArrayList<androidx.e_renamed.a_renamed.a_renamed.b_renamed> arrayList) {
            this.f1088a = intent;
            this.f1089b = arrayList;
        }
    }

    public static androidx.e_renamed.a_renamed.a_renamed a_renamed(android.content.Context context) {
        androidx.e_renamed.a_renamed.a_renamed aVar;
        synchronized (f_renamed) {
            if (g_renamed == null) {
                g_renamed = new androidx.e_renamed.a_renamed.a_renamed(context.getApplicationContext());
            }
            aVar = g_renamed;
        }
        return aVar;
    }

    private a_renamed(android.content.Context context) {
        this.f1084a = context;
        this.e_renamed = new android.os.Handler(context.getMainLooper()) { // from class: androidx.e_renamed.a_renamed.a_renamed.1
            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                if (message.what == 1) {
                    androidx.e_renamed.a_renamed.a_renamed.this.a_renamed();
                } else {
                    super.handleMessage(message);
                }
            }
        };
    }

    public void a_renamed(android.content.BroadcastReceiver broadcastReceiver, android.content.IntentFilter intentFilter) {
        synchronized (this.f1085b) {
            androidx.e_renamed.a_renamed.a_renamed.b_renamed bVar = new androidx.e_renamed.a_renamed.a_renamed.b_renamed(intentFilter, broadcastReceiver);
            java.util.ArrayList<androidx.e_renamed.a_renamed.a_renamed.b_renamed> arrayList = this.f1085b.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new java.util.ArrayList<>(1);
                this.f1085b.put(broadcastReceiver, arrayList);
            }
            arrayList.add(bVar);
            for (int i_renamed = 0; i_renamed < intentFilter.countActions(); i_renamed++) {
                java.lang.String action = intentFilter.getAction(i_renamed);
                java.util.ArrayList<androidx.e_renamed.a_renamed.a_renamed.b_renamed> arrayList2 = this.f1086c.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new java.util.ArrayList<>(1);
                    this.f1086c.put(action, arrayList2);
                }
                arrayList2.add(bVar);
            }
        }
    }

    public void a_renamed(android.content.BroadcastReceiver broadcastReceiver) {
        synchronized (this.f1085b) {
            java.util.ArrayList<androidx.e_renamed.a_renamed.a_renamed.b_renamed> arrayListRemove = this.f1085b.remove(broadcastReceiver);
            if (arrayListRemove == null) {
                return;
            }
            for (int size = arrayListRemove.size() - 1; size >= 0; size--) {
                androidx.e_renamed.a_renamed.a_renamed.b_renamed bVar = arrayListRemove.get(size);
                bVar.d_renamed = true;
                for (int i_renamed = 0; i_renamed < bVar.f1090a.countActions(); i_renamed++) {
                    java.lang.String action = bVar.f1090a.getAction(i_renamed);
                    java.util.ArrayList<androidx.e_renamed.a_renamed.a_renamed.b_renamed> arrayList = this.f1086c.get(action);
                    if (arrayList != null) {
                        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                            androidx.e_renamed.a_renamed.a_renamed.b_renamed bVar2 = arrayList.get(size2);
                            if (bVar2.f1091b == broadcastReceiver) {
                                bVar2.d_renamed = true;
                                arrayList.remove(size2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            this.f1086c.remove(action);
                        }
                    }
                }
            }
        }
    }

    public boolean a_renamed(android.content.Intent intent) {
        java.lang.String str;
        java.util.ArrayList arrayList;
        int i_renamed;
        java.util.ArrayList<androidx.e_renamed.a_renamed.a_renamed.b_renamed> arrayList2;
        java.lang.String str2;
        synchronized (this.f1085b) {
            java.lang.String action = intent.getAction();
            java.lang.String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f1084a.getContentResolver());
            android.net.Uri data = intent.getData();
            java.lang.String scheme = intent.getScheme();
            java.util.Set<java.lang.String> categories = intent.getCategories();
            boolean z_renamed = (intent.getFlags() & 8) != 0;
            if (z_renamed) {
                android.util.Log.v_renamed("LocalBroadcastManager", "Resolving type " + strResolveTypeIfNeeded + " scheme " + scheme + " of_renamed intent " + intent);
            }
            java.util.ArrayList<androidx.e_renamed.a_renamed.a_renamed.b_renamed> arrayList3 = this.f1086c.get(intent.getAction());
            if (arrayList3 != null) {
                if (z_renamed) {
                    android.util.Log.v_renamed("LocalBroadcastManager", "Action list: " + arrayList3);
                }
                java.util.ArrayList arrayList4 = null;
                int i2 = 0;
                while (i2 < arrayList3.size()) {
                    androidx.e_renamed.a_renamed.a_renamed.b_renamed bVar = arrayList3.get(i2);
                    if (z_renamed) {
                        android.util.Log.v_renamed("LocalBroadcastManager", "Matching against filter " + bVar.f1090a);
                    }
                    if (bVar.f1092c) {
                        if (z_renamed) {
                            android.util.Log.v_renamed("LocalBroadcastManager", "  Filter's_renamed target already added");
                        }
                        i_renamed = i2;
                        arrayList2 = arrayList3;
                        str = action;
                        str2 = strResolveTypeIfNeeded;
                        arrayList = arrayList4;
                    } else {
                        str = action;
                        arrayList = arrayList4;
                        i_renamed = i2;
                        arrayList2 = arrayList3;
                        str2 = strResolveTypeIfNeeded;
                        int iMatch = bVar.f1090a.match(action, strResolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (iMatch >= 0) {
                            if (z_renamed) {
                                android.util.Log.v_renamed("LocalBroadcastManager", "  Filter matched!  match=0x" + java.lang.Integer.toHexString(iMatch));
                            }
                            arrayList4 = arrayList == null ? new java.util.ArrayList() : arrayList;
                            arrayList4.add(bVar);
                            bVar.f1092c = true;
                            i2 = i_renamed + 1;
                            action = str;
                            arrayList3 = arrayList2;
                            strResolveTypeIfNeeded = str2;
                        } else if (z_renamed) {
                            android.util.Log.v_renamed("LocalBroadcastManager", "  Filter did not match: " + (iMatch != -4 ? iMatch != -3 ? iMatch != -2 ? iMatch != -1 ? "unknown reason" : com.oplus.ocs.camera.CameraParameter.TiltShiftParamKeys.TYPE : "data" : com.heytap.accessory.constant.AFConstants.EXTRA_INTENT_ACTION : "category"));
                        }
                    }
                    arrayList4 = arrayList;
                    i2 = i_renamed + 1;
                    action = str;
                    arrayList3 = arrayList2;
                    strResolveTypeIfNeeded = str2;
                }
                java.util.ArrayList arrayList5 = arrayList4;
                if (arrayList5 != null) {
                    for (int i3 = 0; i3 < arrayList5.size(); i3++) {
                        ((androidx.e_renamed.a_renamed.a_renamed.b_renamed) arrayList5.get(i3)).f1092c = false;
                    }
                    this.d_renamed.add(new androidx.e_renamed.a_renamed.a_renamed.LocalBroadcastManager_3(intent, arrayList5));
                    if (!this.e_renamed.hasMessages(1)) {
                        this.e_renamed.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    void a_renamed() {
        androidx.e_renamed.a_renamed.a_renamed.LocalBroadcastManager_3[] c0029aArr;
        while (true) {
            synchronized (this.f1085b) {
                int size = this.d_renamed.size();
                if (size <= 0) {
                    return;
                }
                c0029aArr = new androidx.e_renamed.a_renamed.a_renamed.LocalBroadcastManager_3[size];
                this.d_renamed.toArray(c0029aArr);
                this.d_renamed.clear();
            }
            for (androidx.e_renamed.a_renamed.a_renamed.LocalBroadcastManager_3 c0029a : c0029aArr) {
                int size2 = c0029a.f1089b.size();
                for (int i_renamed = 0; i_renamed < size2; i_renamed++) {
                    androidx.e_renamed.a_renamed.a_renamed.b_renamed bVar = c0029a.f1089b.get(i_renamed);
                    if (!bVar.d_renamed) {
                        bVar.f1091b.onReceive(this.f1084a, c0029a.f1088a);
                    }
                }
            }
        }
    }
}
