package com.oplus.epona;

/* loaded from: classes2.dex */
public interface IRemoteTransfer extends android.os.IInterface {

    public static class Default implements com.oplus.epona.IRemoteTransfer {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.oplus.epona.IRemoteTransfer
        public void asyncCall(com.oplus.epona.Request request, com.oplus.epona.ITransferCallback iTransferCallback) throws android.os.RemoteException {
        }

        @Override // com.oplus.epona.IRemoteTransfer
        public com.oplus.epona.Response call(com.oplus.epona.Request request) throws android.os.RemoteException {
            return null;
        }
    }

    void asyncCall(com.oplus.epona.Request request, com.oplus.epona.ITransferCallback iTransferCallback) throws android.os.RemoteException;

    com.oplus.epona.Response call(com.oplus.epona.Request request) throws android.os.RemoteException;

    public static abstract class Stub extends android.os.Binder implements com.oplus.epona.IRemoteTransfer {
        private static final java.lang.String DESCRIPTOR = "com.oplus.epona.IRemoteTransfer";
        static final int TRANSACTION_asyncCall = 2;
        static final int TRANSACTION_call = 1;

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static com.oplus.epona.IRemoteTransfer asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof com.oplus.epona.IRemoteTransfer)) {
                return (com.oplus.epona.IRemoteTransfer) iInterfaceQueryLocalInterface;
            }
            return new com.oplus.epona.IRemoteTransfer.Stub.Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i_renamed, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i_renamed == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                com.oplus.epona.Response responseCall = call(parcel.readInt() != 0 ? com.oplus.epona.Request.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                if (responseCall != null) {
                    parcel2.writeInt(1);
                    responseCall.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            if (i_renamed != 2) {
                if (i_renamed == 1598968902) {
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(i_renamed, parcel, parcel2, i2);
            }
            parcel.enforceInterface(DESCRIPTOR);
            asyncCall(parcel.readInt() != 0 ? com.oplus.epona.Request.CREATOR.createFromParcel(parcel) : null, com.oplus.epona.ITransferCallback.Stub.asInterface(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        private static class Proxy implements com.oplus.epona.IRemoteTransfer {
            public static com.oplus.epona.IRemoteTransfer sDefaultImpl;
            private android.os.IBinder mRemote;

            public java.lang.String getInterfaceDescriptor() {
                return com.oplus.epona.IRemoteTransfer.Stub.DESCRIPTOR;
            }

            Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.oplus.epona.IRemoteTransfer
            public com.oplus.epona.Response call(com.oplus.epona.Request request) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.oplus.epona.IRemoteTransfer.Stub.DESCRIPTOR);
                    if (request != null) {
                        parcelObtain.writeInt(1);
                        request.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) && com.oplus.epona.IRemoteTransfer.Stub.getDefaultImpl() != null) {
                        return com.oplus.epona.IRemoteTransfer.Stub.getDefaultImpl().call(request);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? com.oplus.epona.Response.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplus.epona.IRemoteTransfer
            public void asyncCall(com.oplus.epona.Request request, com.oplus.epona.ITransferCallback iTransferCallback) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.oplus.epona.IRemoteTransfer.Stub.DESCRIPTOR);
                    if (request != null) {
                        parcelObtain.writeInt(1);
                        request.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iTransferCallback != null ? iTransferCallback.asBinder() : null);
                    if (!this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) && com.oplus.epona.IRemoteTransfer.Stub.getDefaultImpl() != null) {
                        com.oplus.epona.IRemoteTransfer.Stub.getDefaultImpl().asyncCall(request, iTransferCallback);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(com.oplus.epona.IRemoteTransfer iRemoteTransfer) {
            if (com.oplus.epona.IRemoteTransfer.Stub.Proxy.sDefaultImpl != null || iRemoteTransfer == null) {
                return false;
            }
            com.oplus.epona.IRemoteTransfer.Stub.Proxy.sDefaultImpl = iRemoteTransfer;
            return true;
        }

        public static com.oplus.epona.IRemoteTransfer getDefaultImpl() {
            return com.oplus.epona.IRemoteTransfer.Stub.Proxy.sDefaultImpl;
        }
    }
}
