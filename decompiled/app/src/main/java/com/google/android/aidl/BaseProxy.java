package com.google.android.aidl;

/* loaded from: classes.dex */
public abstract class BaseProxy implements android.os.IInterface {
    private final java.lang.String mDescriptor;
    private final android.os.IBinder mRemote;

    protected BaseProxy(android.os.IBinder iBinder, java.lang.String str) {
        this.mRemote = iBinder;
        this.mDescriptor = str;
    }

    @Override // android.os.IInterface
    public android.os.IBinder asBinder() {
        return this.mRemote;
    }

    protected android.os.Parcel obtainAndWriteInterfaceToken() {
        android.os.Parcel parcelObtain = android.os.Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.mDescriptor);
        return parcelObtain;
    }

    protected android.os.Parcel transactAndReadException(int i_renamed, android.os.Parcel parcel) throws android.os.RemoteException {
        android.os.Parcel parcelObtain = android.os.Parcel.obtain();
        try {
            try {
                this.mRemote.transact(i_renamed, parcel, parcelObtain, 0);
                parcelObtain.readException();
                return parcelObtain;
            } catch (java.lang.RuntimeException e_renamed) {
                parcelObtain.recycle();
                throw e_renamed;
            }
        } finally {
            parcel.recycle();
        }
    }

    protected void transactAndReadExceptionReturnVoid(int i_renamed, android.os.Parcel parcel) throws android.os.RemoteException {
        android.os.Parcel parcelObtain = android.os.Parcel.obtain();
        try {
            this.mRemote.transact(i_renamed, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }

    protected void transactOneway(int i_renamed, android.os.Parcel parcel) throws android.os.RemoteException {
        try {
            this.mRemote.transact(i_renamed, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
