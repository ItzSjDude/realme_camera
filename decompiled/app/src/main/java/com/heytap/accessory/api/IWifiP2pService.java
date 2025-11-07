package com.heytap.accessory.api;

/* loaded from: classes2.dex */
public interface IWifiP2pService extends android.os.IInterface {

    public static class Default implements com.heytap.accessory.api.IWifiP2pService {
        @Override // com.heytap.accessory.api.IWifiP2pService
        public java.lang.String a_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo) throws android.os.RemoteException {
            return null;
        }

        @Override // com.heytap.accessory.api.IWifiP2pService
        public java.util.List<com.heytap.accessory.bean.DeviceInfo> a_renamed() throws android.os.RemoteException {
            return null;
        }

        @Override // com.heytap.accessory.api.IWifiP2pService
        public boolean a_renamed(com.heytap.accessory.api.IWifiP2pChangeReceiver iWifiP2pChangeReceiver) throws android.os.RemoteException {
            return false;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.accessory.api.IWifiP2pService
        public void b_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo) throws android.os.RemoteException {
        }

        @Override // com.heytap.accessory.api.IWifiP2pService
        public boolean b_renamed(com.heytap.accessory.api.IWifiP2pChangeReceiver iWifiP2pChangeReceiver) throws android.os.RemoteException {
            return false;
        }
    }

    java.lang.String a_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo) throws android.os.RemoteException;

    java.util.List<com.heytap.accessory.bean.DeviceInfo> a_renamed() throws android.os.RemoteException;

    boolean a_renamed(com.heytap.accessory.api.IWifiP2pChangeReceiver iWifiP2pChangeReceiver) throws android.os.RemoteException;

    void b_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo) throws android.os.RemoteException;

    boolean b_renamed(com.heytap.accessory.api.IWifiP2pChangeReceiver iWifiP2pChangeReceiver) throws android.os.RemoteException;

    public static abstract class Stub extends android.os.Binder implements com.heytap.accessory.api.IWifiP2pService {
        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.IWifiP2pService");
        }

        public static com.heytap.accessory.api.IWifiP2pService a_renamed(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.IWifiP2pService");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof com.heytap.accessory.api.IWifiP2pService)) {
                return (com.heytap.accessory.api.IWifiP2pService) iInterfaceQueryLocalInterface;
            }
            return new com.heytap.accessory.api.IWifiP2pService.Stub.Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i_renamed, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i_renamed == 1598968902) {
                parcel2.writeString("com.heytap.accessory.api.IWifiP2pService");
                return true;
            }
            if (i_renamed == 1) {
                parcel.enforceInterface("com.heytap.accessory.api.IWifiP2pService");
                java.util.List<com.heytap.accessory.bean.DeviceInfo> listA = a_renamed();
                parcel2.writeNoException();
                parcel2.writeTypedList(listA);
                return true;
            }
            if (i_renamed == 2) {
                parcel.enforceInterface("com.heytap.accessory.api.IWifiP2pService");
                java.lang.String strA = a_renamed(parcel.readInt() != 0 ? com.heytap.accessory.bean.DeviceInfo.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeString(strA);
                return true;
            }
            if (i_renamed == 3) {
                parcel.enforceInterface("com.heytap.accessory.api.IWifiP2pService");
                b_renamed(parcel.readInt() != 0 ? com.heytap.accessory.bean.DeviceInfo.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i_renamed == 4) {
                parcel.enforceInterface("com.heytap.accessory.api.IWifiP2pService");
                boolean zA = a_renamed(com.heytap.accessory.api.IWifiP2pChangeReceiver.Stub.a_renamed(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeInt(zA ? 1 : 0);
                return true;
            }
            if (i_renamed == 5) {
                parcel.enforceInterface("com.heytap.accessory.api.IWifiP2pService");
                boolean zB = b_renamed(com.heytap.accessory.api.IWifiP2pChangeReceiver.Stub.a_renamed(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeInt(zB ? 1 : 0);
                return true;
            }
            return super.onTransact(i_renamed, parcel, parcel2, i2);
        }

        static class Proxy implements com.heytap.accessory.api.IWifiP2pService {

            /* renamed from: a_renamed, reason: collision with root package name */
            public static com.heytap.accessory.api.IWifiP2pService f3251a;

            /* renamed from: b_renamed, reason: collision with root package name */
            private android.os.IBinder f3252b;

            Proxy(android.os.IBinder iBinder) {
                this.f3252b = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.f3252b;
            }

            @Override // com.heytap.accessory.api.IWifiP2pService
            public java.util.List<com.heytap.accessory.bean.DeviceInfo> a_renamed() throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IWifiP2pService");
                    if (!this.f3252b.transact(1, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.IWifiP2pService.Stub.b_renamed() != null) {
                        return com.heytap.accessory.api.IWifiP2pService.Stub.b_renamed().a_renamed();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(com.heytap.accessory.bean.DeviceInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IWifiP2pService
            public java.lang.String a_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IWifiP2pService");
                    if (deviceInfo != null) {
                        parcelObtain.writeInt(1);
                        deviceInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f3252b.transact(2, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.IWifiP2pService.Stub.b_renamed() != null) {
                        return com.heytap.accessory.api.IWifiP2pService.Stub.b_renamed().a_renamed(deviceInfo);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IWifiP2pService
            public void b_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IWifiP2pService");
                    if (deviceInfo != null) {
                        parcelObtain.writeInt(1);
                        deviceInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f3252b.transact(3, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.IWifiP2pService.Stub.b_renamed() != null) {
                        com.heytap.accessory.api.IWifiP2pService.Stub.b_renamed().b_renamed(deviceInfo);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IWifiP2pService
            public boolean a_renamed(com.heytap.accessory.api.IWifiP2pChangeReceiver iWifiP2pChangeReceiver) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IWifiP2pService");
                    parcelObtain.writeStrongBinder(iWifiP2pChangeReceiver != null ? iWifiP2pChangeReceiver.asBinder() : null);
                    if (!this.f3252b.transact(4, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.IWifiP2pService.Stub.b_renamed() != null) {
                        return com.heytap.accessory.api.IWifiP2pService.Stub.b_renamed().a_renamed(iWifiP2pChangeReceiver);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IWifiP2pService
            public boolean b_renamed(com.heytap.accessory.api.IWifiP2pChangeReceiver iWifiP2pChangeReceiver) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IWifiP2pService");
                    parcelObtain.writeStrongBinder(iWifiP2pChangeReceiver != null ? iWifiP2pChangeReceiver.asBinder() : null);
                    if (!this.f3252b.transact(5, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.IWifiP2pService.Stub.b_renamed() != null) {
                        return com.heytap.accessory.api.IWifiP2pService.Stub.b_renamed().b_renamed(iWifiP2pChangeReceiver);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static com.heytap.accessory.api.IWifiP2pService b_renamed() {
            return com.heytap.accessory.api.IWifiP2pService.Stub.Proxy.f3251a;
        }
    }
}
