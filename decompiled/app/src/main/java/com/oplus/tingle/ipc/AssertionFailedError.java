package com.oplus.tingle.ipc;

/* compiled from: Slave.java */
/* loaded from: classes2.dex */
public class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static android.os.IBinder f7746a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static java.util.List<com.oplus.tingle.ipc.b_renamed.b_renamed> f7747b = new java.util.concurrent.CopyOnWriteArrayList();

    /* renamed from: c_renamed, reason: collision with root package name */
    private static android.app.Application f7748c;

    static void a_renamed(android.content.Context context) {
        if (context instanceof android.app.Application) {
            f7748c = (android.app.Application) context;
        } else {
            f7748c = (android.app.Application) context.getApplicationContext();
        }
        b_renamed();
    }

    private static void b_renamed() {
        f7747b.add(new com.oplus.tingle.ipc.b_renamed.a_renamed.a_renamed());
        f7747b.add(new com.oplus.tingle.ipc.b_renamed.d_renamed.a_renamed());
        f7747b.add(new com.oplus.tingle.ipc.b_renamed.a_renamed.b_renamed());
        f7747b.add(new com.oplus.tingle.ipc.b_renamed.e_renamed.a_renamed());
        f7747b.add(new com.oplus.tingle.ipc.b_renamed.c_renamed.a_renamed.a_renamed());
        f7747b.add(new com.oplus.tingle.ipc.b_renamed.b_renamed.a_renamed());
    }

    public static java.lang.Object a_renamed(android.content.Context context, java.lang.String str) {
        if (!a_renamed() && !b_renamed(context)) {
            com.oplus.tingle.ipc.c_renamed.a_renamed.b_renamed("Slave", "Error : Slave cannot connect master.", new java.lang.Object[0]);
            return context.getSystemService(str);
        }
        for (com.oplus.tingle.ipc.b_renamed.b_renamed bVar : f7747b) {
            if (bVar.a_renamed(str)) {
                return bVar.b_renamed(context);
            }
        }
        return a_renamed(str).b_renamed(context);
    }

    public static void b_renamed(android.content.Context context, java.lang.String str) {
        for (com.oplus.tingle.ipc.b_renamed.b_renamed bVar : f7747b) {
            if (bVar.a_renamed(str)) {
                bVar.c_renamed(context);
                return;
            }
        }
    }

    private static synchronized com.oplus.tingle.ipc.b_renamed.a_renamed a_renamed(java.lang.String str) {
        com.oplus.tingle.ipc.b_renamed.a_renamed aVar;
        aVar = new com.oplus.tingle.ipc.b_renamed.a_renamed(str);
        f7747b.add(aVar);
        return aVar;
    }

    static void a_renamed(android.os.Parcel parcel, android.os.Parcel parcel2, int i_renamed) throws android.os.RemoteException {
        c_renamed().transact(1, parcel, parcel2, i_renamed);
    }

    private static android.os.IBinder c_renamed() {
        if (f7746a == null && !b_renamed(f7748c)) {
            throw new java.lang.IllegalStateException("Can not find master... Try again");
        }
        return f7746a;
    }

    public static boolean a_renamed() {
        android.os.IBinder iBinder = f7746a;
        if (iBinder == null) {
            return false;
        }
        return iBinder.pingBinder();
    }

    private static boolean b_renamed(android.content.Context context) throws android.os.RemoteException {
        android.os.IBinder iBinderB = com.oplus.tingle.ipc.a_renamed.b_renamed(context);
        if (iBinderB != null) {
            try {
                iBinderB.linkToDeath(new android.os.IBinder.DeathRecipient() { // from class: com.oplus.tingle.ipc.-$$Lambda$b_renamed$kVmgh8SE5GuTM_G-VEnq9tEGzVI
                    @Override // android.os.IBinder.DeathRecipient
                    public final void binderDied() {
                        com.oplus.tingle.ipc.b_renamed.d_renamed();
                    }
                }, 0);
            } catch (android.os.RemoteException e_renamed) {
                com.oplus.tingle.ipc.c_renamed.a_renamed.b_renamed("Slave", "GetMaster linkToDeath Error : " + e_renamed, new java.lang.Object[0]);
            }
            f7746a = iBinderB;
        } else {
            f7746a = null;
            com.oplus.tingle.ipc.c_renamed.a_renamed.b_renamed("Slave", "Get Binder is_renamed null, reset sMaster = null.", new java.lang.Object[0]);
        }
        return f7746a != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d_renamed() {
        f7746a = null;
        com.oplus.tingle.ipc.c_renamed.a_renamed.b_renamed("Slave", "sMaster binder died.", new java.lang.Object[0]);
    }
}
