package com.heytap.accessory.api;

/* loaded from: classes2.dex */
public interface IPeripheralService extends android.os.IInterface {

    public static class Default implements com.heytap.accessory.api.IPeripheralService {
        @Override // com.heytap.accessory.api.IPeripheralService
        public void a_renamed() throws android.os.RemoteException {
        }

        @Override // com.heytap.accessory.api.IPeripheralService
        public void a_renamed(com.heytap.accessory.api.IPeripheralCallback iPeripheralCallback) throws android.os.RemoteException {
        }

        @Override // com.heytap.accessory.api.IPeripheralService
        public void a_renamed(com.heytap.accessory.bean.AdvertiseSetting advertiseSetting, com.heytap.accessory.api.IPeripheralCallback iPeripheralCallback) throws android.os.RemoteException {
        }

        @Override // com.heytap.accessory.api.IPeripheralService
        public void a_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo, int i_renamed) throws android.os.RemoteException {
        }

        @Override // com.heytap.accessory.api.IPeripheralService
        public void a_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo, boolean z_renamed) throws android.os.RemoteException {
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }
    }

    void a_renamed() throws android.os.RemoteException;

    void a_renamed(com.heytap.accessory.api.IPeripheralCallback iPeripheralCallback) throws android.os.RemoteException;

    void a_renamed(com.heytap.accessory.bean.AdvertiseSetting advertiseSetting, com.heytap.accessory.api.IPeripheralCallback iPeripheralCallback) throws android.os.RemoteException;

    void a_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo, int i_renamed) throws android.os.RemoteException;

    void a_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo, boolean z_renamed) throws android.os.RemoteException;

    public static abstract class Stub extends android.os.Binder implements com.heytap.accessory.api.IPeripheralService {
        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.IPeripheralService");
        }

        public static com.heytap.accessory.api.IPeripheralService a_renamed(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.IPeripheralService");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof com.heytap.accessory.api.IPeripheralService)) {
                return (com.heytap.accessory.api.IPeripheralService) iInterfaceQueryLocalInterface;
            }
            return new com.heytap.accessory.api.IPeripheralService.Stub.Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i_renamed, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i_renamed == 1598968902) {
                parcel2.writeString("com.heytap.accessory.api.IPeripheralService");
                return true;
            }
            if (i_renamed == 1) {
                parcel.enforceInterface("com.heytap.accessory.api.IPeripheralService");
                a_renamed(parcel.readInt() != 0 ? com.heytap.accessory.bean.AdvertiseSetting.CREATOR.createFromParcel(parcel) : null, com.heytap.accessory.api.IPeripheralCallback.Stub.a_renamed(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i_renamed == 2) {
                parcel.enforceInterface("com.heytap.accessory.api.IPeripheralService");
                a_renamed();
                parcel2.writeNoException();
                return true;
            }
            if (i_renamed == 3) {
                parcel.enforceInterface("com.heytap.accessory.api.IPeripheralService");
                a_renamed(parcel.readInt() != 0 ? com.heytap.accessory.bean.DeviceInfo.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            if (i_renamed == 4) {
                parcel.enforceInterface("com.heytap.accessory.api.IPeripheralService");
                a_renamed(parcel.readInt() != 0 ? com.heytap.accessory.bean.DeviceInfo.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0);
                parcel2.writeNoException();
                return true;
            }
            if (i_renamed == 5) {
                parcel.enforceInterface("com.heytap.accessory.api.IPeripheralService");
                a_renamed(com.heytap.accessory.api.IPeripheralCallback.Stub.a_renamed(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            return super.onTransact(i_renamed, parcel, parcel2, i2);
        }

        static class Proxy implements com.heytap.accessory.api.IPeripheralService {

            /* renamed from: a_renamed, reason: collision with root package name */
            public static com.heytap.accessory.api.IPeripheralService f3239a;

            /* renamed from: b_renamed, reason: collision with root package name */
            private android.os.IBinder f3240b;

            Proxy(android.os.IBinder iBinder) {
                this.f3240b = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.f3240b;
            }

            @Override // com.heytap.accessory.api.IPeripheralService
            public void a_renamed(com.heytap.accessory.bean.AdvertiseSetting advertiseSetting, com.heytap.accessory.api.IPeripheralCallback iPeripheralCallback) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IPeripheralService");
                    if (advertiseSetting != null) {
                        parcelObtain.writeInt(1);
                        advertiseSetting.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iPeripheralCallback != null ? iPeripheralCallback.asBinder() : null);
                    if (!this.f3240b.transact(1, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.IPeripheralService.Stub.b_renamed() != null) {
                        com.heytap.accessory.api.IPeripheralService.Stub.b_renamed().a_renamed(advertiseSetting, iPeripheralCallback);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IPeripheralService
            public void a_renamed() throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IPeripheralService");
                    if (!this.f3240b.transact(2, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.IPeripheralService.Stub.b_renamed() != null) {
                        com.heytap.accessory.api.IPeripheralService.Stub.b_renamed().a_renamed();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IPeripheralService
            public void a_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo, int i_renamed) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IPeripheralService");
                    if (deviceInfo != null) {
                        parcelObtain.writeInt(1);
                        deviceInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeInt(i_renamed);
                    if (!this.f3240b.transact(3, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.IPeripheralService.Stub.b_renamed() != null) {
                        com.heytap.accessory.api.IPeripheralService.Stub.b_renamed().a_renamed(deviceInfo, i_renamed);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IPeripheralService
            public void a_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo, boolean z_renamed) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IPeripheralService");
                    int i_renamed = 1;
                    if (deviceInfo != null) {
                        parcelObtain.writeInt(1);
                        deviceInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!z_renamed) {
                        i_renamed = 0;
                    }
                    parcelObtain.writeInt(i_renamed);
                    if (!this.f3240b.transact(4, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.IPeripheralService.Stub.b_renamed() != null) {
                        com.heytap.accessory.api.IPeripheralService.Stub.b_renamed().a_renamed(deviceInfo, z_renamed);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IPeripheralService
            public void a_renamed(com.heytap.accessory.api.IPeripheralCallback iPeripheralCallback) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IPeripheralService");
                    parcelObtain.writeStrongBinder(iPeripheralCallback != null ? iPeripheralCallback.asBinder() : null);
                    if (!this.f3240b.transact(5, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.IPeripheralService.Stub.b_renamed() != null) {
                        com.heytap.accessory.api.IPeripheralService.Stub.b_renamed().a_renamed(iPeripheralCallback);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static com.heytap.accessory.api.IPeripheralService b_renamed() {
            return com.heytap.accessory.api.IPeripheralService.Stub.Proxy.f3239a;
        }
    }
}
