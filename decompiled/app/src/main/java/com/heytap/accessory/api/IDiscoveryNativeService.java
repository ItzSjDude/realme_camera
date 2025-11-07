package com.heytap.accessory.api;

/* loaded from: classes2.dex */
public interface IDiscoveryNativeService extends android.os.IInterface {

    public static class Default implements com.heytap.accessory.api.IDiscoveryNativeService {
        @Override // com.heytap.accessory.api.IDiscoveryNativeService
        public android.os.Bundle a_renamed(int i_renamed, java.lang.String str, com.heytap.accessory.api.IDeathCallback iDeathCallback, int i2, com.heytap.accessory.api.IServiceConnectionIndicationCallback iServiceConnectionIndicationCallback) throws android.os.RemoteException {
            return null;
        }

        @Override // com.heytap.accessory.api.IDiscoveryNativeService
        public com.heytap.accessory.api.ICentralService a_renamed() throws android.os.RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.accessory.api.IDiscoveryNativeService
        public com.heytap.accessory.api.IPeripheralService b_renamed() throws android.os.RemoteException {
            return null;
        }

        @Override // com.heytap.accessory.api.IDiscoveryNativeService
        public com.heytap.accessory.api.IWifiP2pService c_renamed() throws android.os.RemoteException {
            return null;
        }
    }

    android.os.Bundle a_renamed(int i_renamed, java.lang.String str, com.heytap.accessory.api.IDeathCallback iDeathCallback, int i2, com.heytap.accessory.api.IServiceConnectionIndicationCallback iServiceConnectionIndicationCallback) throws android.os.RemoteException;

    com.heytap.accessory.api.ICentralService a_renamed() throws android.os.RemoteException;

    com.heytap.accessory.api.IPeripheralService b_renamed() throws android.os.RemoteException;

    com.heytap.accessory.api.IWifiP2pService c_renamed() throws android.os.RemoteException;

    public static abstract class Stub extends android.os.Binder implements com.heytap.accessory.api.IDiscoveryNativeService {
        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.IDiscoveryNativeService");
        }

        public static com.heytap.accessory.api.IDiscoveryNativeService a_renamed(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.IDiscoveryNativeService");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof com.heytap.accessory.api.IDiscoveryNativeService)) {
                return (com.heytap.accessory.api.IDiscoveryNativeService) iInterfaceQueryLocalInterface;
            }
            return new com.heytap.accessory.api.IDiscoveryNativeService.Stub.Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i_renamed, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i_renamed == 1598968902) {
                parcel2.writeString("com.heytap.accessory.api.IDiscoveryNativeService");
                return true;
            }
            if (i_renamed == 1) {
                parcel.enforceInterface("com.heytap.accessory.api.IDiscoveryNativeService");
                com.heytap.accessory.api.ICentralService iCentralServiceA = a_renamed();
                parcel2.writeNoException();
                parcel2.writeStrongBinder(iCentralServiceA != null ? iCentralServiceA.asBinder() : null);
                return true;
            }
            if (i_renamed == 2) {
                parcel.enforceInterface("com.heytap.accessory.api.IDiscoveryNativeService");
                com.heytap.accessory.api.IPeripheralService iPeripheralServiceB = b_renamed();
                parcel2.writeNoException();
                parcel2.writeStrongBinder(iPeripheralServiceB != null ? iPeripheralServiceB.asBinder() : null);
                return true;
            }
            if (i_renamed == 3) {
                parcel.enforceInterface("com.heytap.accessory.api.IDiscoveryNativeService");
                com.heytap.accessory.api.IWifiP2pService iWifiP2pServiceC = c_renamed();
                parcel2.writeNoException();
                parcel2.writeStrongBinder(iWifiP2pServiceC != null ? iWifiP2pServiceC.asBinder() : null);
                return true;
            }
            if (i_renamed == 4) {
                parcel.enforceInterface("com.heytap.accessory.api.IDiscoveryNativeService");
                android.os.Bundle bundleA = a_renamed(parcel.readInt(), parcel.readString(), com.heytap.accessory.api.IDeathCallback.Stub.a_renamed(parcel.readStrongBinder()), parcel.readInt(), com.heytap.accessory.api.IServiceConnectionIndicationCallback.Stub.a_renamed(parcel.readStrongBinder()));
                parcel2.writeNoException();
                if (bundleA != null) {
                    parcel2.writeInt(1);
                    bundleA.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            return super.onTransact(i_renamed, parcel, parcel2, i2);
        }

        static class Proxy implements com.heytap.accessory.api.IDiscoveryNativeService {

            /* renamed from: a_renamed, reason: collision with root package name */
            public static com.heytap.accessory.api.IDiscoveryNativeService f3221a;

            /* renamed from: b_renamed, reason: collision with root package name */
            private android.os.IBinder f3222b;

            Proxy(android.os.IBinder iBinder) {
                this.f3222b = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.f3222b;
            }

            @Override // com.heytap.accessory.api.IDiscoveryNativeService
            public com.heytap.accessory.api.ICentralService a_renamed() throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IDiscoveryNativeService");
                    if (!this.f3222b.transact(1, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.IDiscoveryNativeService.Stub.d_renamed() != null) {
                        return com.heytap.accessory.api.IDiscoveryNativeService.Stub.d_renamed().a_renamed();
                    }
                    parcelObtain2.readException();
                    return com.heytap.accessory.api.ICentralService.Stub.a_renamed(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IDiscoveryNativeService
            public com.heytap.accessory.api.IPeripheralService b_renamed() throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IDiscoveryNativeService");
                    if (!this.f3222b.transact(2, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.IDiscoveryNativeService.Stub.d_renamed() != null) {
                        return com.heytap.accessory.api.IDiscoveryNativeService.Stub.d_renamed().b_renamed();
                    }
                    parcelObtain2.readException();
                    return com.heytap.accessory.api.IPeripheralService.Stub.a_renamed(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IDiscoveryNativeService
            public com.heytap.accessory.api.IWifiP2pService c_renamed() throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IDiscoveryNativeService");
                    if (!this.f3222b.transact(3, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.IDiscoveryNativeService.Stub.d_renamed() != null) {
                        return com.heytap.accessory.api.IDiscoveryNativeService.Stub.d_renamed().c_renamed();
                    }
                    parcelObtain2.readException();
                    return com.heytap.accessory.api.IWifiP2pService.Stub.a_renamed(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IDiscoveryNativeService
            public android.os.Bundle a_renamed(int i_renamed, java.lang.String str, com.heytap.accessory.api.IDeathCallback iDeathCallback, int i2, com.heytap.accessory.api.IServiceConnectionIndicationCallback iServiceConnectionIndicationCallback) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IDiscoveryNativeService");
                    parcelObtain.writeInt(i_renamed);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iDeathCallback != null ? iDeathCallback.asBinder() : null);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeStrongBinder(iServiceConnectionIndicationCallback != null ? iServiceConnectionIndicationCallback.asBinder() : null);
                    if (!this.f3222b.transact(4, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.IDiscoveryNativeService.Stub.d_renamed() != null) {
                        return com.heytap.accessory.api.IDiscoveryNativeService.Stub.d_renamed().a_renamed(i_renamed, str, iDeathCallback, i2, iServiceConnectionIndicationCallback);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (android.os.Bundle) android.os.Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static com.heytap.accessory.api.IDiscoveryNativeService d_renamed() {
            return com.heytap.accessory.api.IDiscoveryNativeService.Stub.Proxy.f3221a;
        }
    }
}
