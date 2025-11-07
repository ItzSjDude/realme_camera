package com.oplus.tblplayer;

/* loaded from: classes2.dex */
public interface IRemoteLinker extends android.os.IInterface {

    public static class Default implements com.oplus.tblplayer.IRemoteLinker {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.oplus.tblplayer.IRemoteLinker
        public android.os.IBinder create() throws android.os.RemoteException {
            return null;
        }
    }

    android.os.IBinder create() throws android.os.RemoteException;

    public static abstract class Stub extends android.os.Binder implements com.oplus.tblplayer.IRemoteLinker {
        private static final java.lang.String DESCRIPTOR = "com.oplus.tblplayer.IRemoteLinker";
        static final int TRANSACTION_create = 1;

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static com.oplus.tblplayer.IRemoteLinker asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof com.oplus.tblplayer.IRemoteLinker)) {
                return (com.oplus.tblplayer.IRemoteLinker) iInterfaceQueryLocalInterface;
            }
            return new com.oplus.tblplayer.IRemoteLinker.Stub.Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i_renamed, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i_renamed != 1) {
                if (i_renamed == 1598968902) {
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(i_renamed, parcel, parcel2, i2);
            }
            parcel.enforceInterface(DESCRIPTOR);
            android.os.IBinder iBinderCreate = create();
            parcel2.writeNoException();
            parcel2.writeStrongBinder(iBinderCreate);
            return true;
        }

        private static class Proxy implements com.oplus.tblplayer.IRemoteLinker {
            public static com.oplus.tblplayer.IRemoteLinker sDefaultImpl;
            private android.os.IBinder mRemote;

            public java.lang.String getInterfaceDescriptor() {
                return com.oplus.tblplayer.IRemoteLinker.Stub.DESCRIPTOR;
            }

            Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.oplus.tblplayer.IRemoteLinker
            public android.os.IBinder create() throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.oplus.tblplayer.IRemoteLinker.Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) && com.oplus.tblplayer.IRemoteLinker.Stub.getDefaultImpl() != null) {
                        return com.oplus.tblplayer.IRemoteLinker.Stub.getDefaultImpl().create();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readStrongBinder();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(com.oplus.tblplayer.IRemoteLinker iRemoteLinker) {
            if (com.oplus.tblplayer.IRemoteLinker.Stub.Proxy.sDefaultImpl != null || iRemoteLinker == null) {
                return false;
            }
            com.oplus.tblplayer.IRemoteLinker.Stub.Proxy.sDefaultImpl = iRemoteLinker;
            return true;
        }

        public static com.oplus.tblplayer.IRemoteLinker getDefaultImpl() {
            return com.oplus.tblplayer.IRemoteLinker.Stub.Proxy.sDefaultImpl;
        }
    }
}
