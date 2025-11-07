package com.heytap.accessory.api;

/* loaded from: classes2.dex */
public interface IPermissionCallback extends android.os.IInterface {

    public static class Default implements com.heytap.accessory.api.IPermissionCallback {
        @Override // com.heytap.accessory.api.IPermissionCallback
        public void a_renamed() throws android.os.RemoteException {
        }

        @Override // com.heytap.accessory.api.IPermissionCallback
        public void a_renamed(int i_renamed) throws android.os.RemoteException {
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }
    }

    void a_renamed() throws android.os.RemoteException;

    void a_renamed(int i_renamed) throws android.os.RemoteException;

    public static abstract class Stub extends android.os.Binder implements com.heytap.accessory.api.IPermissionCallback {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.IPermissionCallback");
        }

        public static com.heytap.accessory.api.IPermissionCallback a_renamed(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.IPermissionCallback");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof com.heytap.accessory.api.IPermissionCallback)) {
                return (com.heytap.accessory.api.IPermissionCallback) iInterfaceQueryLocalInterface;
            }
            return new com.heytap.accessory.api.IPermissionCallback.Stub.Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i_renamed, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i_renamed == 1598968902) {
                parcel2.writeString("com.heytap.accessory.api.IPermissionCallback");
                return true;
            }
            if (i_renamed == 1) {
                parcel.enforceInterface("com.heytap.accessory.api.IPermissionCallback");
                a_renamed();
                parcel2.writeNoException();
                return true;
            }
            if (i_renamed == 2) {
                parcel.enforceInterface("com.heytap.accessory.api.IPermissionCallback");
                a_renamed(parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            return super.onTransact(i_renamed, parcel, parcel2, i2);
        }

        static class Proxy implements com.heytap.accessory.api.IPermissionCallback {

            /* renamed from: a_renamed, reason: collision with root package name */
            public static com.heytap.accessory.api.IPermissionCallback f3241a;

            /* renamed from: b_renamed, reason: collision with root package name */
            private android.os.IBinder f3242b;

            Proxy(android.os.IBinder iBinder) {
                this.f3242b = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.f3242b;
            }

            @Override // com.heytap.accessory.api.IPermissionCallback
            public void a_renamed() throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IPermissionCallback");
                    if (!this.f3242b.transact(1, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.IPermissionCallback.Stub.b_renamed() != null) {
                        com.heytap.accessory.api.IPermissionCallback.Stub.b_renamed().a_renamed();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IPermissionCallback
            public void a_renamed(int i_renamed) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IPermissionCallback");
                    parcelObtain.writeInt(i_renamed);
                    if (!this.f3242b.transact(2, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.IPermissionCallback.Stub.b_renamed() != null) {
                        com.heytap.accessory.api.IPermissionCallback.Stub.b_renamed().a_renamed(i_renamed);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static com.heytap.accessory.api.IPermissionCallback b_renamed() {
            return com.heytap.accessory.api.IPermissionCallback.Stub.Proxy.f3241a;
        }
    }
}
