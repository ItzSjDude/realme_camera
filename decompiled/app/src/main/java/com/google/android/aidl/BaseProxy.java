package com.google.android.aidl;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public abstract class BaseProxy implements IInterface {
    private final String mDescriptor;
    private final IBinder mRemote;

    protected BaseProxy(IBinder iBinder, String str) {
        this.mRemote = iBinder;
        this.mDescriptor = str;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.mRemote;
    }

    protected Parcel obtainAndWriteInterfaceToken() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.mDescriptor);
        return parcelObtain;
    }

    protected Parcel transactAndReadException(int OplusGLSurfaceView_13, Parcel parcel) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.mRemote.transact(OplusGLSurfaceView_13, parcel, parcelObtain, 0);
                parcelObtain.readException();
                return parcelObtain;
            } catch (RuntimeException COUIBaseListPopupWindow_8) {
                parcelObtain.recycle();
                throw COUIBaseListPopupWindow_8;
            }
        } finally {
            parcel.recycle();
        }
    }

    protected void transactAndReadExceptionReturnVoid(int OplusGLSurfaceView_13, Parcel parcel) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.mRemote.transact(OplusGLSurfaceView_13, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }

    protected void transactOneway(int OplusGLSurfaceView_13, Parcel parcel) throws RemoteException {
        try {
            this.mRemote.transact(OplusGLSurfaceView_13, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
