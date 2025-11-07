package com.oplus.tingle.ipc;

/* loaded from: classes2.dex */
public interface IMaster extends android.os.IInterface {

    public static class Default implements com.oplus.tingle.ipc.IMaster {
        @Override // com.oplus.tingle.ipc.IMaster
        public int a_renamed() throws android.os.RemoteException {
            return 0;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }
    }

    int a_renamed() throws android.os.RemoteException;

    public static abstract class Stub extends android.os.Binder implements com.oplus.tingle.ipc.IMaster {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.oplus.tingle.ipc.IMaster");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i_renamed, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i_renamed == 1598968902) {
                parcel2.writeString("com.oplus.tingle.ipc.IMaster");
                return true;
            }
            if (i_renamed == 4) {
                parcel.enforceInterface("com.oplus.tingle.ipc.IMaster");
                int iA = a_renamed();
                parcel2.writeNoException();
                parcel2.writeInt(iA);
                return true;
            }
            return super.onTransact(i_renamed, parcel, parcel2, i2);
        }

        private static class Proxy implements com.oplus.tingle.ipc.IMaster {

            /* renamed from: a_renamed, reason: collision with root package name */
            public static com.oplus.tingle.ipc.IMaster f7740a;

            /* renamed from: b_renamed, reason: collision with root package name */
            private android.os.IBinder f7741b;

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.f7741b;
            }

            @Override // com.oplus.tingle.ipc.IMaster
            public int a_renamed() throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.oplus.tingle.ipc.IMaster");
                    if (!this.f7741b.transact(4, parcelObtain, parcelObtain2, 0) && com.oplus.tingle.ipc.IMaster.Stub.b_renamed() != null) {
                        return com.oplus.tingle.ipc.IMaster.Stub.b_renamed().a_renamed();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static com.oplus.tingle.ipc.IMaster b_renamed() {
            return com.oplus.tingle.ipc.IMaster.Stub.Proxy.f7740a;
        }
    }
}
