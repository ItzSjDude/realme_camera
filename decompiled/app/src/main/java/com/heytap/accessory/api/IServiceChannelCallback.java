package com.heytap.accessory.api;

/* loaded from: classes2.dex */
public interface IServiceChannelCallback extends android.os.IInterface {

    public static class Default implements com.heytap.accessory.api.IServiceChannelCallback {
        @Override // com.heytap.accessory.api.IServiceChannelCallback
        public void a_renamed(android.os.Bundle bundle) throws android.os.RemoteException {
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.accessory.api.IServiceChannelCallback
        public void b_renamed(android.os.Bundle bundle) throws android.os.RemoteException {
        }
    }

    void a_renamed(android.os.Bundle bundle) throws android.os.RemoteException;

    void b_renamed(android.os.Bundle bundle) throws android.os.RemoteException;

    public static abstract class Stub extends android.os.Binder implements com.heytap.accessory.api.IServiceChannelCallback {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.IServiceChannelCallback");
        }

        public static com.heytap.accessory.api.IServiceChannelCallback a_renamed(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.IServiceChannelCallback");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof com.heytap.accessory.api.IServiceChannelCallback)) {
                return (com.heytap.accessory.api.IServiceChannelCallback) iInterfaceQueryLocalInterface;
            }
            return new com.heytap.accessory.api.IServiceChannelCallback.Stub.Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i_renamed, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i_renamed == 1598968902) {
                parcel2.writeString("com.heytap.accessory.api.IServiceChannelCallback");
                return true;
            }
            if (i_renamed == 1) {
                parcel.enforceInterface("com.heytap.accessory.api.IServiceChannelCallback");
                b_renamed(parcel.readInt() != 0 ? (android.os.Bundle) android.os.Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i_renamed == 2) {
                parcel.enforceInterface("com.heytap.accessory.api.IServiceChannelCallback");
                a_renamed(parcel.readInt() != 0 ? (android.os.Bundle) android.os.Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            return super.onTransact(i_renamed, parcel, parcel2, i2);
        }

        static class Proxy implements com.heytap.accessory.api.IServiceChannelCallback {

            /* renamed from: a_renamed, reason: collision with root package name */
            public static com.heytap.accessory.api.IServiceChannelCallback f3243a;

            /* renamed from: b_renamed, reason: collision with root package name */
            private android.os.IBinder f3244b;

            Proxy(android.os.IBinder iBinder) {
                this.f3244b = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.f3244b;
            }

            @Override // com.heytap.accessory.api.IServiceChannelCallback
            public void b_renamed(android.os.Bundle bundle) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IServiceChannelCallback");
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f3244b.transact(1, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.IServiceChannelCallback.Stub.a_renamed() != null) {
                        com.heytap.accessory.api.IServiceChannelCallback.Stub.a_renamed().b_renamed(bundle);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IServiceChannelCallback
            public void a_renamed(android.os.Bundle bundle) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IServiceChannelCallback");
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f3244b.transact(2, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.IServiceChannelCallback.Stub.a_renamed() != null) {
                        com.heytap.accessory.api.IServiceChannelCallback.Stub.a_renamed().a_renamed(bundle);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static com.heytap.accessory.api.IServiceChannelCallback a_renamed() {
            return com.heytap.accessory.api.IServiceChannelCallback.Stub.Proxy.f3243a;
        }
    }
}
