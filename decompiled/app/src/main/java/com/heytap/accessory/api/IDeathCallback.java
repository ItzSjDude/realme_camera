package com.heytap.accessory.api;

/* loaded from: classes2.dex */
public interface IDeathCallback extends android.os.IInterface {

    public static class Default implements com.heytap.accessory.api.IDeathCallback {
        @Override // com.heytap.accessory.api.IDeathCallback
        public java.lang.String a_renamed() throws android.os.RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }
    }

    java.lang.String a_renamed() throws android.os.RemoteException;

    public static abstract class Stub extends android.os.Binder implements com.heytap.accessory.api.IDeathCallback {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.IDeathCallback");
        }

        public static com.heytap.accessory.api.IDeathCallback a_renamed(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.IDeathCallback");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof com.heytap.accessory.api.IDeathCallback)) {
                return (com.heytap.accessory.api.IDeathCallback) iInterfaceQueryLocalInterface;
            }
            return new com.heytap.accessory.api.IDeathCallback.Stub.Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i_renamed, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i_renamed == 1598968902) {
                parcel2.writeString("com.heytap.accessory.api.IDeathCallback");
                return true;
            }
            if (i_renamed == 1) {
                parcel.enforceInterface("com.heytap.accessory.api.IDeathCallback");
                java.lang.String strA = a_renamed();
                parcel2.writeNoException();
                parcel2.writeString(strA);
                return true;
            }
            return super.onTransact(i_renamed, parcel, parcel2, i2);
        }

        static class Proxy implements com.heytap.accessory.api.IDeathCallback {

            /* renamed from: a_renamed, reason: collision with root package name */
            public static com.heytap.accessory.api.IDeathCallback f3213a;

            /* renamed from: b_renamed, reason: collision with root package name */
            private android.os.IBinder f3214b;

            Proxy(android.os.IBinder iBinder) {
                this.f3214b = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.f3214b;
            }

            @Override // com.heytap.accessory.api.IDeathCallback
            public java.lang.String a_renamed() throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IDeathCallback");
                    if (!this.f3214b.transact(1, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.IDeathCallback.Stub.b_renamed() != null) {
                        return com.heytap.accessory.api.IDeathCallback.Stub.b_renamed().a_renamed();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static com.heytap.accessory.api.IDeathCallback b_renamed() {
            return com.heytap.accessory.api.IDeathCallback.Stub.Proxy.f3213a;
        }
    }
}
