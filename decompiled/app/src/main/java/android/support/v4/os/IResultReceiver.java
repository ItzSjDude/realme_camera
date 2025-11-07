package android.support.v4.os;

/* loaded from: classes.dex */
public interface IResultReceiver extends android.os.IInterface {

    public static class Default implements android.support.v4.os.IResultReceiver {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // android.support.v4.os.IResultReceiver
        public void send(int i_renamed, android.os.Bundle bundle) throws android.os.RemoteException {
        }
    }

    void send(int i_renamed, android.os.Bundle bundle) throws android.os.RemoteException;

    public static abstract class Stub extends android.os.Binder implements android.support.v4.os.IResultReceiver {
        private static final java.lang.String DESCRIPTOR = "android.support.v4.os.IResultReceiver";
        static final int TRANSACTION_send = 1;

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static android.support.v4.os.IResultReceiver asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof android.support.v4.os.IResultReceiver)) {
                return (android.support.v4.os.IResultReceiver) iInterfaceQueryLocalInterface;
            }
            return new android.support.v4.os.IResultReceiver.Stub.Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i_renamed, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i_renamed == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                send(parcel.readInt(), parcel.readInt() != 0 ? (android.os.Bundle) android.os.Bundle.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i_renamed == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i_renamed, parcel, parcel2, i2);
        }

        private static class Proxy implements android.support.v4.os.IResultReceiver {
            public static android.support.v4.os.IResultReceiver sDefaultImpl;
            private android.os.IBinder mRemote;

            public java.lang.String getInterfaceDescriptor() {
                return android.support.v4.os.IResultReceiver.Stub.DESCRIPTOR;
            }

            Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            @Override // android.support.v4.os.IResultReceiver
            public void send(int i_renamed, android.os.Bundle bundle) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.os.IResultReceiver.Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i_renamed);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(1, parcelObtain, null, 1) || android.support.v4.os.IResultReceiver.Stub.getDefaultImpl() == null) {
                        return;
                    }
                    android.support.v4.os.IResultReceiver.Stub.getDefaultImpl().send(i_renamed, bundle);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(android.support.v4.os.IResultReceiver iResultReceiver) {
            if (android.support.v4.os.IResultReceiver.Stub.Proxy.sDefaultImpl != null || iResultReceiver == null) {
                return false;
            }
            android.support.v4.os.IResultReceiver.Stub.Proxy.sDefaultImpl = iResultReceiver;
            return true;
        }

        public static android.support.v4.os.IResultReceiver getDefaultImpl() {
            return android.support.v4.os.IResultReceiver.Stub.Proxy.sDefaultImpl;
        }
    }
}
