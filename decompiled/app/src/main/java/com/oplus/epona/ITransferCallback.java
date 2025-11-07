package com.oplus.epona;

/* loaded from: classes2.dex */
public interface ITransferCallback extends android.os.IInterface {

    public static class Default implements com.oplus.epona.ITransferCallback {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.oplus.epona.ITransferCallback
        public void onReceive(com.oplus.epona.Response response) throws android.os.RemoteException {
        }
    }

    void onReceive(com.oplus.epona.Response response) throws android.os.RemoteException;

    public static abstract class Stub extends android.os.Binder implements com.oplus.epona.ITransferCallback {
        private static final java.lang.String DESCRIPTOR = "com.oplus.epona.ITransferCallback";
        static final int TRANSACTION_onReceive = 1;

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static com.oplus.epona.ITransferCallback asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof com.oplus.epona.ITransferCallback)) {
                return (com.oplus.epona.ITransferCallback) iInterfaceQueryLocalInterface;
            }
            return new com.oplus.epona.ITransferCallback.Stub.Proxy(iBinder);
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
            onReceive(parcel.readInt() != 0 ? com.oplus.epona.Response.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }

        private static class Proxy implements com.oplus.epona.ITransferCallback {
            public static com.oplus.epona.ITransferCallback sDefaultImpl;
            private android.os.IBinder mRemote;

            public java.lang.String getInterfaceDescriptor() {
                return com.oplus.epona.ITransferCallback.Stub.DESCRIPTOR;
            }

            Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.oplus.epona.ITransferCallback
            public void onReceive(com.oplus.epona.Response response) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.oplus.epona.ITransferCallback.Stub.DESCRIPTOR);
                    if (response != null) {
                        parcelObtain.writeInt(1);
                        response.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) && com.oplus.epona.ITransferCallback.Stub.getDefaultImpl() != null) {
                        com.oplus.epona.ITransferCallback.Stub.getDefaultImpl().onReceive(response);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(com.oplus.epona.ITransferCallback iTransferCallback) {
            if (com.oplus.epona.ITransferCallback.Stub.Proxy.sDefaultImpl != null || iTransferCallback == null) {
                return false;
            }
            com.oplus.epona.ITransferCallback.Stub.Proxy.sDefaultImpl = iTransferCallback;
            return true;
        }

        public static com.oplus.epona.ITransferCallback getDefaultImpl() {
            return com.oplus.epona.ITransferCallback.Stub.Proxy.sDefaultImpl;
        }
    }
}
