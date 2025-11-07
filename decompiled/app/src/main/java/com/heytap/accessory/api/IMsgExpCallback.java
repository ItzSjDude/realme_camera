package com.heytap.accessory.api;

/* loaded from: classes2.dex */
public interface IMsgExpCallback extends android.os.IInterface {

    public static class Default implements com.heytap.accessory.api.IMsgExpCallback {
        @Override // com.heytap.accessory.api.IMsgExpCallback
        public void a_renamed(android.os.Bundle bundle) throws android.os.RemoteException {
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.accessory.api.IMsgExpCallback
        public void b_renamed(android.os.Bundle bundle) throws android.os.RemoteException {
        }
    }

    void a_renamed(android.os.Bundle bundle) throws android.os.RemoteException;

    void b_renamed(android.os.Bundle bundle) throws android.os.RemoteException;

    public static abstract class Stub extends android.os.Binder implements com.heytap.accessory.api.IMsgExpCallback {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.IMsgExpCallback");
        }

        public static com.heytap.accessory.api.IMsgExpCallback a_renamed(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.IMsgExpCallback");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof com.heytap.accessory.api.IMsgExpCallback)) {
                return (com.heytap.accessory.api.IMsgExpCallback) iInterfaceQueryLocalInterface;
            }
            return new com.heytap.accessory.api.IMsgExpCallback.Stub.Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i_renamed, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i_renamed == 1598968902) {
                parcel2.writeString("com.heytap.accessory.api.IMsgExpCallback");
                return true;
            }
            if (i_renamed == 1) {
                parcel.enforceInterface("com.heytap.accessory.api.IMsgExpCallback");
                a_renamed(parcel.readInt() != 0 ? (android.os.Bundle) android.os.Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i_renamed == 2) {
                parcel.enforceInterface("com.heytap.accessory.api.IMsgExpCallback");
                b_renamed(parcel.readInt() != 0 ? (android.os.Bundle) android.os.Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            return super.onTransact(i_renamed, parcel, parcel2, i2);
        }

        static class Proxy implements com.heytap.accessory.api.IMsgExpCallback {

            /* renamed from: a_renamed, reason: collision with root package name */
            public static com.heytap.accessory.api.IMsgExpCallback f3229a;

            /* renamed from: b_renamed, reason: collision with root package name */
            private android.os.IBinder f3230b;

            Proxy(android.os.IBinder iBinder) {
                this.f3230b = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.f3230b;
            }

            @Override // com.heytap.accessory.api.IMsgExpCallback
            public void a_renamed(android.os.Bundle bundle) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IMsgExpCallback");
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f3230b.transact(1, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.IMsgExpCallback.Stub.a_renamed() != null) {
                        com.heytap.accessory.api.IMsgExpCallback.Stub.a_renamed().a_renamed(bundle);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IMsgExpCallback
            public void b_renamed(android.os.Bundle bundle) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IMsgExpCallback");
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f3230b.transact(2, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.IMsgExpCallback.Stub.a_renamed() != null) {
                        com.heytap.accessory.api.IMsgExpCallback.Stub.a_renamed().b_renamed(bundle);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static com.heytap.accessory.api.IMsgExpCallback a_renamed() {
            return com.heytap.accessory.api.IMsgExpCallback.Stub.Proxy.f3229a;
        }
    }
}
