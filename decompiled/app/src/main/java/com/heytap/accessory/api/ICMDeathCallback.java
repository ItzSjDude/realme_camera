package com.heytap.accessory.api;

/* loaded from: classes2.dex */
public interface ICMDeathCallback extends android.os.IInterface {

    public static class Default implements com.heytap.accessory.api.ICMDeathCallback {
        @Override // com.heytap.accessory.api.ICMDeathCallback
        public java.lang.String a_renamed() throws android.os.RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }
    }

    java.lang.String a_renamed() throws android.os.RemoteException;

    public static abstract class Stub extends android.os.Binder implements com.heytap.accessory.api.ICMDeathCallback {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.ICMDeathCallback");
        }

        public static com.heytap.accessory.api.ICMDeathCallback a_renamed(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.ICMDeathCallback");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof com.heytap.accessory.api.ICMDeathCallback)) {
                return (com.heytap.accessory.api.ICMDeathCallback) iInterfaceQueryLocalInterface;
            }
            return new com.heytap.accessory.api.ICMDeathCallback.Stub.Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i_renamed, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i_renamed == 1598968902) {
                parcel2.writeString("com.heytap.accessory.api.ICMDeathCallback");
                return true;
            }
            if (i_renamed == 1) {
                parcel.enforceInterface("com.heytap.accessory.api.ICMDeathCallback");
                java.lang.String strA = a_renamed();
                parcel2.writeNoException();
                parcel2.writeString(strA);
                return true;
            }
            return super.onTransact(i_renamed, parcel, parcel2, i2);
        }

        static class Proxy implements com.heytap.accessory.api.ICMDeathCallback {

            /* renamed from: a_renamed, reason: collision with root package name */
            public static com.heytap.accessory.api.ICMDeathCallback f3209a;

            /* renamed from: b_renamed, reason: collision with root package name */
            private android.os.IBinder f3210b;

            Proxy(android.os.IBinder iBinder) {
                this.f3210b = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.f3210b;
            }

            @Override // com.heytap.accessory.api.ICMDeathCallback
            public java.lang.String a_renamed() throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.ICMDeathCallback");
                    if (!this.f3210b.transact(1, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.ICMDeathCallback.Stub.b_renamed() != null) {
                        return com.heytap.accessory.api.ICMDeathCallback.Stub.b_renamed().a_renamed();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static com.heytap.accessory.api.ICMDeathCallback b_renamed() {
            return com.heytap.accessory.api.ICMDeathCallback.Stub.Proxy.f3209a;
        }
    }
}
