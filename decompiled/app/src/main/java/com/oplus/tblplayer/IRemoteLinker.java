package com.oplus.tblplayer;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public interface IRemoteLinker extends IInterface {

    public static class Default implements IRemoteLinker {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.oplus.tblplayer.IRemoteLinker
        public IBinder create() throws RemoteException {
            return null;
        }
    }

    IBinder create() throws RemoteException;

    public static abstract class Stub extends Binder implements IRemoteLinker {
        private static final String DESCRIPTOR = "com.oplus.tblplayer.IRemoteLinker";
        static final int TRANSACTION_create = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IRemoteLinker asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IRemoteLinker)) {
                return (IRemoteLinker) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int OplusGLSurfaceView_13, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (OplusGLSurfaceView_13 != 1) {
                if (OplusGLSurfaceView_13 == 1598968902) {
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(OplusGLSurfaceView_13, parcel, parcel2, i2);
            }
            parcel.enforceInterface(DESCRIPTOR);
            IBinder iBinderCreate = create();
            parcel2.writeNoException();
            parcel2.writeStrongBinder(iBinderCreate);
            return true;
        }

        private static class Proxy implements IRemoteLinker {
            public static IRemoteLinker sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.oplus.tblplayer.IRemoteLinker
            public IBinder create() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().create();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readStrongBinder();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IRemoteLinker iRemoteLinker) {
            if (Proxy.sDefaultImpl != null || iRemoteLinker == null) {
                return false;
            }
            Proxy.sDefaultImpl = iRemoteLinker;
            return true;
        }

        public static IRemoteLinker getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
