package com.heytap.accessory.api;

/* loaded from: classes2.dex */
public interface IServiceConnectionIndicationCallback extends android.os.IInterface {

    public static class Default implements com.heytap.accessory.api.IServiceConnectionIndicationCallback {
        @Override // com.heytap.accessory.api.IServiceConnectionIndicationCallback
        public void a_renamed(android.os.Bundle bundle) throws android.os.RemoteException {
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }
    }

    void a_renamed(android.os.Bundle bundle) throws android.os.RemoteException;

    public static abstract class Stub extends android.os.Binder implements com.heytap.accessory.api.IServiceConnectionIndicationCallback {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.IServiceConnectionIndicationCallback");
        }

        public static com.heytap.accessory.api.IServiceConnectionIndicationCallback a_renamed(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.IServiceConnectionIndicationCallback");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof com.heytap.accessory.api.IServiceConnectionIndicationCallback)) {
                return (com.heytap.accessory.api.IServiceConnectionIndicationCallback) iInterfaceQueryLocalInterface;
            }
            return new com.heytap.accessory.api.IServiceConnectionIndicationCallback.Stub.Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i_renamed, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i_renamed == 1598968902) {
                parcel2.writeString("com.heytap.accessory.api.IServiceConnectionIndicationCallback");
                return true;
            }
            if (i_renamed == 1) {
                parcel.enforceInterface("com.heytap.accessory.api.IServiceConnectionIndicationCallback");
                a_renamed(parcel.readInt() != 0 ? (android.os.Bundle) android.os.Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            return super.onTransact(i_renamed, parcel, parcel2, i2);
        }

        static class Proxy implements com.heytap.accessory.api.IServiceConnectionIndicationCallback {

            /* renamed from: a_renamed, reason: collision with root package name */
            public static com.heytap.accessory.api.IServiceConnectionIndicationCallback f3247a;

            /* renamed from: b_renamed, reason: collision with root package name */
            private android.os.IBinder f3248b;

            Proxy(android.os.IBinder iBinder) {
                this.f3248b = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.f3248b;
            }

            @Override // com.heytap.accessory.api.IServiceConnectionIndicationCallback
            public void a_renamed(android.os.Bundle bundle) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IServiceConnectionIndicationCallback");
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f3248b.transact(1, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.IServiceConnectionIndicationCallback.Stub.a_renamed() != null) {
                        com.heytap.accessory.api.IServiceConnectionIndicationCallback.Stub.a_renamed().a_renamed(bundle);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static com.heytap.accessory.api.IServiceConnectionIndicationCallback a_renamed() {
            return com.heytap.accessory.api.IServiceConnectionIndicationCallback.Stub.Proxy.f3247a;
        }
    }
}
