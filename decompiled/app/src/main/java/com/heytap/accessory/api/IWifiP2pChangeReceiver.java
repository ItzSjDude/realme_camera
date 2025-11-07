package com.heytap.accessory.api;

/* loaded from: classes2.dex */
public interface IWifiP2pChangeReceiver extends android.os.IInterface {

    public static class Default implements com.heytap.accessory.api.IWifiP2pChangeReceiver {
        @Override // com.heytap.accessory.api.IWifiP2pChangeReceiver
        public void a_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo, int i_renamed, int i2) throws android.os.RemoteException {
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }
    }

    void a_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo, int i_renamed, int i2) throws android.os.RemoteException;

    public static abstract class Stub extends android.os.Binder implements com.heytap.accessory.api.IWifiP2pChangeReceiver {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.IWifiP2pChangeReceiver");
        }

        public static com.heytap.accessory.api.IWifiP2pChangeReceiver a_renamed(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.IWifiP2pChangeReceiver");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof com.heytap.accessory.api.IWifiP2pChangeReceiver)) {
                return (com.heytap.accessory.api.IWifiP2pChangeReceiver) iInterfaceQueryLocalInterface;
            }
            return new com.heytap.accessory.api.IWifiP2pChangeReceiver.Stub.Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i_renamed, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i_renamed == 1598968902) {
                parcel2.writeString("com.heytap.accessory.api.IWifiP2pChangeReceiver");
                return true;
            }
            if (i_renamed == 1) {
                parcel.enforceInterface("com.heytap.accessory.api.IWifiP2pChangeReceiver");
                a_renamed(parcel.readInt() != 0 ? com.heytap.accessory.bean.DeviceInfo.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            return super.onTransact(i_renamed, parcel, parcel2, i2);
        }

        static class Proxy implements com.heytap.accessory.api.IWifiP2pChangeReceiver {

            /* renamed from: a_renamed, reason: collision with root package name */
            public static com.heytap.accessory.api.IWifiP2pChangeReceiver f3249a;

            /* renamed from: b_renamed, reason: collision with root package name */
            private android.os.IBinder f3250b;

            Proxy(android.os.IBinder iBinder) {
                this.f3250b = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.f3250b;
            }

            @Override // com.heytap.accessory.api.IWifiP2pChangeReceiver
            public void a_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo, int i_renamed, int i2) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IWifiP2pChangeReceiver");
                    if (deviceInfo != null) {
                        parcelObtain.writeInt(1);
                        deviceInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeInt(i_renamed);
                    parcelObtain.writeInt(i2);
                    if (!this.f3250b.transact(1, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.IWifiP2pChangeReceiver.Stub.a_renamed() != null) {
                        com.heytap.accessory.api.IWifiP2pChangeReceiver.Stub.a_renamed().a_renamed(deviceInfo, i_renamed, i2);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static com.heytap.accessory.api.IWifiP2pChangeReceiver a_renamed() {
            return com.heytap.accessory.api.IWifiP2pChangeReceiver.Stub.Proxy.f3249a;
        }
    }
}
