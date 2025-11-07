package com.oplus.tingle.ipc;

/* compiled from: SlaveBinder.java */
/* loaded from: classes2.dex */
public class c_renamed implements android.os.IBinder {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.os.IBinder f7752a;

    @Override // android.os.IBinder
    public android.os.IInterface queryLocalInterface(java.lang.String str) {
        return null;
    }

    public void shellCommand(java.io.FileDescriptor fileDescriptor, java.io.FileDescriptor fileDescriptor2, java.io.FileDescriptor fileDescriptor3, java.lang.String[] strArr, android.os.ShellCallback shellCallback, android.os.ResultReceiver resultReceiver) throws android.os.RemoteException {
    }

    public c_renamed(android.os.IBinder iBinder) {
        this.f7752a = (android.os.IBinder) java.util.Objects.requireNonNull(iBinder);
    }

    @Override // android.os.IBinder
    public boolean transact(int i_renamed, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
        android.os.Parcel parcelObtain = android.os.Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(com.oplus.tingle.a_renamed.a_renamed());
            parcelObtain.writeStrongBinder(this.f7752a);
            parcelObtain.writeInt(i_renamed);
            parcelObtain.writeStringArray(com.oplus.shield.b_renamed.h_renamed.a_renamed());
            parcelObtain.appendFrom(parcel, 0, parcel.dataSize());
            com.oplus.tingle.ipc.b_renamed.a_renamed(parcelObtain, parcel2, i2);
            parcelObtain.recycle();
            return true;
        } catch (java.lang.Throwable th) {
            parcelObtain.recycle();
            throw th;
        }
    }

    @Override // android.os.IBinder
    public java.lang.String getInterfaceDescriptor() {
        try {
            return this.f7752a.getInterfaceDescriptor();
        } catch (android.os.RemoteException e_renamed) {
            throw new java.lang.IllegalStateException(e_renamed.getClass().getSimpleName(), e_renamed);
        }
    }

    @Override // android.os.IBinder
    public boolean pingBinder() {
        return this.f7752a.pingBinder();
    }

    @Override // android.os.IBinder
    public boolean isBinderAlive() {
        return this.f7752a.isBinderAlive();
    }

    @Override // android.os.IBinder
    public void dump(java.io.FileDescriptor fileDescriptor, java.lang.String[] strArr) throws android.os.RemoteException {
        try {
            this.f7752a.dump(fileDescriptor, strArr);
        } catch (android.os.RemoteException e_renamed) {
            throw new java.lang.IllegalStateException(e_renamed.getClass().getSimpleName(), e_renamed);
        }
    }

    @Override // android.os.IBinder
    public void dumpAsync(java.io.FileDescriptor fileDescriptor, java.lang.String[] strArr) throws android.os.RemoteException {
        try {
            this.f7752a.dumpAsync(fileDescriptor, strArr);
        } catch (android.os.RemoteException e_renamed) {
            throw new java.lang.IllegalStateException(e_renamed.getClass().getSimpleName(), e_renamed);
        }
    }

    @Override // android.os.IBinder
    public void linkToDeath(android.os.IBinder.DeathRecipient deathRecipient, int i_renamed) throws android.os.RemoteException {
        try {
            this.f7752a.linkToDeath(deathRecipient, i_renamed);
        } catch (android.os.RemoteException e_renamed) {
            throw new java.lang.IllegalStateException(e_renamed.getClass().getSimpleName(), e_renamed);
        }
    }

    @Override // android.os.IBinder
    public boolean unlinkToDeath(android.os.IBinder.DeathRecipient deathRecipient, int i_renamed) {
        return this.f7752a.unlinkToDeath(deathRecipient, i_renamed);
    }
}
