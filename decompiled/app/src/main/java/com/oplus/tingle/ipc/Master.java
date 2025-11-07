package com.oplus.tingle.ipc;

/* loaded from: classes2.dex */
public class Master extends com.oplus.tingle.ipc.IMaster.Stub {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.Object f7742a = new java.lang.Object();

    private Master() {
    }

    @Override // com.oplus.tingle.ipc.IMaster.Stub, android.os.Binder
    public boolean onTransact(int i_renamed, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
        if (i_renamed == 1) {
            parcel.enforceInterface(com.oplus.tingle.a_renamed.a_renamed());
            a_renamed(parcel, parcel2, i2);
            return true;
        }
        return super.onTransact(i_renamed, parcel, parcel2, i2);
    }

    private void a_renamed(android.os.Parcel parcel, android.os.Parcel parcel2, int i_renamed) throws android.os.RemoteException {
        android.os.IBinder strongBinder = parcel.readStrongBinder();
        int i2 = parcel.readInt();
        parcel.readStringArray();
        if (com.oplus.shield.b_renamed.b_renamed().a_renamed() && !com.oplus.shield.b_renamed.b_renamed().a_renamed(strongBinder.getInterfaceDescriptor(), i2)) {
            throw new java.lang.SecurityException("Tingle Authentication Failed.");
        }
        android.os.Parcel parcelObtain = android.os.Parcel.obtain();
        try {
            parcelObtain.appendFrom(parcel, parcel.dataPosition(), parcel.dataAvail());
            try {
                long jClearCallingIdentity = clearCallingIdentity();
                strongBinder.transact(i2, parcelObtain, parcel2, i_renamed);
                restoreCallingIdentity(jClearCallingIdentity);
            } finally {
                parcelObtain.recycle();
            }
        } catch (java.lang.Throwable th) {
            com.oplus.tingle.ipc.c_renamed.a_renamed.b_renamed("Master", "appendFrom failed: " + th.toString(), new java.lang.Object[0]);
        }
    }

    @Override // com.oplus.tingle.ipc.IMaster
    public int a_renamed() throws android.os.RemoteException {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            return android.system.Os.getuid();
        }
        return -1;
    }
}
