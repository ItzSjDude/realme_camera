package androidx.room;

/* loaded from: classes.dex */
public class MultiInstanceInvalidationService extends android.app.Service {

    /* renamed from: a_renamed, reason: collision with root package name */
    int f1570a = 0;

    /* renamed from: b_renamed, reason: collision with root package name */
    final java.util.HashMap<java.lang.Integer, java.lang.String> f1571b = new java.util.HashMap<>();

    /* renamed from: c_renamed, reason: collision with root package name */
    final android.os.RemoteCallbackList<androidx.room.IMultiInstanceInvalidationCallback> f1572c = new android.os.RemoteCallbackList<androidx.room.IMultiInstanceInvalidationCallback>() { // from class: androidx.room.MultiInstanceInvalidationService.1
        @Override // android.os.RemoteCallbackList
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public void onCallbackDied(androidx.room.IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, java.lang.Object obj) {
            androidx.room.MultiInstanceInvalidationService.this.f1571b.remove(java.lang.Integer.valueOf(((java.lang.Integer) obj).intValue()));
        }
    };
    private final androidx.room.IMultiInstanceInvalidationService.Stub d_renamed = new androidx.room.IMultiInstanceInvalidationService.Stub() { // from class: androidx.room.MultiInstanceInvalidationService.2
        @Override // androidx.room.IMultiInstanceInvalidationService
        public int a_renamed(androidx.room.IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, java.lang.String str) {
            if (str == null) {
                return 0;
            }
            synchronized (androidx.room.MultiInstanceInvalidationService.this.f1572c) {
                androidx.room.MultiInstanceInvalidationService multiInstanceInvalidationService = androidx.room.MultiInstanceInvalidationService.this;
                int i_renamed = multiInstanceInvalidationService.f1570a + 1;
                multiInstanceInvalidationService.f1570a = i_renamed;
                if (androidx.room.MultiInstanceInvalidationService.this.f1572c.register(iMultiInstanceInvalidationCallback, java.lang.Integer.valueOf(i_renamed))) {
                    androidx.room.MultiInstanceInvalidationService.this.f1571b.put(java.lang.Integer.valueOf(i_renamed), str);
                    return i_renamed;
                }
                androidx.room.MultiInstanceInvalidationService multiInstanceInvalidationService2 = androidx.room.MultiInstanceInvalidationService.this;
                multiInstanceInvalidationService2.f1570a--;
                return 0;
            }
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public void a_renamed(androidx.room.IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, int i_renamed) {
            synchronized (androidx.room.MultiInstanceInvalidationService.this.f1572c) {
                androidx.room.MultiInstanceInvalidationService.this.f1572c.unregister(iMultiInstanceInvalidationCallback);
                androidx.room.MultiInstanceInvalidationService.this.f1571b.remove(java.lang.Integer.valueOf(i_renamed));
            }
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public void a_renamed(int i_renamed, java.lang.String[] strArr) {
            synchronized (androidx.room.MultiInstanceInvalidationService.this.f1572c) {
                java.lang.String str = androidx.room.MultiInstanceInvalidationService.this.f1571b.get(java.lang.Integer.valueOf(i_renamed));
                if (str == null) {
                    android.util.Log.w_renamed("ROOM", "Remote invalidation client ID_renamed not registered");
                    return;
                }
                int iBeginBroadcast = androidx.room.MultiInstanceInvalidationService.this.f1572c.beginBroadcast();
                for (int i2 = 0; i2 < iBeginBroadcast; i2++) {
                    try {
                        int iIntValue = ((java.lang.Integer) androidx.room.MultiInstanceInvalidationService.this.f1572c.getBroadcastCookie(i2)).intValue();
                        java.lang.String str2 = androidx.room.MultiInstanceInvalidationService.this.f1571b.get(java.lang.Integer.valueOf(iIntValue));
                        if (i_renamed != iIntValue && str.equals(str2)) {
                            try {
                                ((androidx.room.IMultiInstanceInvalidationCallback) androidx.room.MultiInstanceInvalidationService.this.f1572c.getBroadcastItem(i2)).a_renamed(strArr);
                            } catch (android.os.RemoteException e_renamed) {
                                android.util.Log.w_renamed("ROOM", "Error invoking a_renamed remote callback", e_renamed);
                            }
                        }
                    } finally {
                        androidx.room.MultiInstanceInvalidationService.this.f1572c.finishBroadcast();
                    }
                }
            }
        }
    };

    @Override // android.app.Service
    public android.os.IBinder onBind(android.content.Intent intent) {
        return this.d_renamed;
    }
}
