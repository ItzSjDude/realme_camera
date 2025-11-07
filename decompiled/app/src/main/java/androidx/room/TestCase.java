package androidx.room;

/* compiled from: MultiInstanceInvalidationClient.java */
/* loaded from: classes.dex */
class e_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    final android.content.Context f1609a;

    /* renamed from: b_renamed, reason: collision with root package name */
    final java.lang.String f1610b;

    /* renamed from: c_renamed, reason: collision with root package name */
    int f1611c;
    final androidx.room.d_renamed d_renamed;
    final androidx.room.d_renamed.b_renamed e_renamed;
    androidx.room.IMultiInstanceInvalidationService f_renamed;
    final java.util.concurrent.Executor g_renamed;
    final androidx.room.IMultiInstanceInvalidationCallback h_renamed = new androidx.room.IMultiInstanceInvalidationCallback.Stub() { // from class: androidx.room.MultiInstanceInvalidationClient$1
        @Override // androidx.room.IMultiInstanceInvalidationCallback
        public void a_renamed(final java.lang.String[] strArr) {
            this.f1567a.g_renamed.execute(new java.lang.Runnable() { // from class: androidx.room.MultiInstanceInvalidationClient$1.1
                @Override // java.lang.Runnable
                public void run() {
                    androidx.room.MultiInstanceInvalidationClient$1.this.f1567a.d_renamed.a_renamed(strArr);
                }
            });
        }
    };
    final java.util.concurrent.atomic.AtomicBoolean i_renamed = new java.util.concurrent.atomic.AtomicBoolean(false);
    final android.content.ServiceConnection j_renamed = new android.content.ServiceConnection() { // from class: androidx.room.e_renamed.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            androidx.room.e_renamed.this.f_renamed = androidx.room.IMultiInstanceInvalidationService.Stub.a_renamed(iBinder);
            androidx.room.e_renamed.this.g_renamed.execute(androidx.room.e_renamed.this.k_renamed);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(android.content.ComponentName componentName) {
            androidx.room.e_renamed.this.g_renamed.execute(androidx.room.e_renamed.this.l_renamed);
            androidx.room.e_renamed.this.f_renamed = null;
        }
    };
    final java.lang.Runnable k_renamed = new java.lang.Runnable() { // from class: androidx.room.e_renamed.2
        @Override // java.lang.Runnable
        public void run() {
            try {
                androidx.room.IMultiInstanceInvalidationService iMultiInstanceInvalidationService = androidx.room.e_renamed.this.f_renamed;
                if (iMultiInstanceInvalidationService != null) {
                    androidx.room.e_renamed.this.f1611c = iMultiInstanceInvalidationService.a_renamed(androidx.room.e_renamed.this.h_renamed, androidx.room.e_renamed.this.f1610b);
                    androidx.room.e_renamed.this.d_renamed.a_renamed(androidx.room.e_renamed.this.e_renamed);
                }
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.w_renamed("ROOM", "Cannot register multi-instance invalidation callback", e_renamed);
            }
        }
    };
    final java.lang.Runnable l_renamed = new java.lang.Runnable() { // from class: androidx.room.e_renamed.3
        @Override // java.lang.Runnable
        public void run() {
            androidx.room.e_renamed.this.d_renamed.b_renamed(androidx.room.e_renamed.this.e_renamed);
        }
    };
    private final java.lang.Runnable m_renamed = new java.lang.Runnable() { // from class: androidx.room.e_renamed.4
        @Override // java.lang.Runnable
        public void run() {
            androidx.room.e_renamed.this.d_renamed.b_renamed(androidx.room.e_renamed.this.e_renamed);
            try {
                androidx.room.IMultiInstanceInvalidationService iMultiInstanceInvalidationService = androidx.room.e_renamed.this.f_renamed;
                if (iMultiInstanceInvalidationService != null) {
                    iMultiInstanceInvalidationService.a_renamed(androidx.room.e_renamed.this.h_renamed, androidx.room.e_renamed.this.f1611c);
                }
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.w_renamed("ROOM", "Cannot unregister multi-instance invalidation callback", e_renamed);
            }
            androidx.room.e_renamed.this.f1609a.unbindService(androidx.room.e_renamed.this.j_renamed);
        }
    };

    e_renamed(android.content.Context context, java.lang.String str, androidx.room.d_renamed dVar, java.util.concurrent.Executor executor) {
        this.f1609a = context.getApplicationContext();
        this.f1610b = str;
        this.d_renamed = dVar;
        this.g_renamed = executor;
        this.e_renamed = new androidx.room.d_renamed.b_renamed((java.lang.String[]) dVar.f1598a.keySet().toArray(new java.lang.String[0])) { // from class: androidx.room.e_renamed.5
            @Override // androidx.room.d_renamed.b_renamed
            boolean a_renamed() {
                return true;
            }

            @Override // androidx.room.d_renamed.b_renamed
            public void a_renamed(java.util.Set<java.lang.String> set) {
                if (androidx.room.e_renamed.this.i_renamed.get()) {
                    return;
                }
                try {
                    androidx.room.IMultiInstanceInvalidationService iMultiInstanceInvalidationService = androidx.room.e_renamed.this.f_renamed;
                    if (iMultiInstanceInvalidationService != null) {
                        iMultiInstanceInvalidationService.a_renamed(androidx.room.e_renamed.this.f1611c, (java.lang.String[]) set.toArray(new java.lang.String[0]));
                    }
                } catch (android.os.RemoteException e_renamed) {
                    android.util.Log.w_renamed("ROOM", "Cannot broadcast invalidation", e_renamed);
                }
            }
        };
        this.f1609a.bindService(new android.content.Intent(this.f1609a, (java.lang.Class<?>) androidx.room.MultiInstanceInvalidationService.class), this.j_renamed, 1);
    }
}
