package com.heytap.accessory.api;

/* loaded from: classes2.dex */
public interface IDisPairCallback extends android.os.IInterface {

    public static class Default implements com.heytap.accessory.api.IDisPairCallback {
        @Override // com.heytap.accessory.api.IDisPairCallback
        public void a_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo, com.heytap.accessory.bean.Message message) throws android.os.RemoteException {
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.accessory.api.IDisPairCallback
        public void b_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo, com.heytap.accessory.bean.Message message) throws android.os.RemoteException {
        }

        @Override // com.heytap.accessory.api.IDisPairCallback
        public void c_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo, com.heytap.accessory.bean.Message message) throws android.os.RemoteException {
        }
    }

    void a_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo, com.heytap.accessory.bean.Message message) throws android.os.RemoteException;

    void b_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo, com.heytap.accessory.bean.Message message) throws android.os.RemoteException;

    void c_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo, com.heytap.accessory.bean.Message message) throws android.os.RemoteException;

    public static abstract class Stub extends android.os.Binder implements com.heytap.accessory.api.IDisPairCallback {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.IDisPairCallback");
        }

        public static com.heytap.accessory.api.IDisPairCallback a_renamed(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.IDisPairCallback");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof com.heytap.accessory.api.IDisPairCallback)) {
                return (com.heytap.accessory.api.IDisPairCallback) iInterfaceQueryLocalInterface;
            }
            return new com.heytap.accessory.api.IDisPairCallback.Stub.Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i_renamed, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i_renamed == 1598968902) {
                parcel2.writeString("com.heytap.accessory.api.IDisPairCallback");
                return true;
            }
            if (i_renamed == 1) {
                parcel.enforceInterface("com.heytap.accessory.api.IDisPairCallback");
                a_renamed(parcel.readInt() != 0 ? com.heytap.accessory.bean.DeviceInfo.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? com.heytap.accessory.bean.Message.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i_renamed != 2) {
                if (i_renamed == 3) {
                    parcel.enforceInterface("com.heytap.accessory.api.IDisPairCallback");
                    c_renamed(parcel.readInt() != 0 ? com.heytap.accessory.bean.DeviceInfo.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? com.heytap.accessory.bean.Message.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                }
                return super.onTransact(i_renamed, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.heytap.accessory.api.IDisPairCallback");
            com.heytap.accessory.bean.DeviceInfo deviceInfoCreateFromParcel = parcel.readInt() != 0 ? com.heytap.accessory.bean.DeviceInfo.CREATOR.createFromParcel(parcel) : null;
            com.heytap.accessory.bean.Message messageCreateFromParcel = parcel.readInt() != 0 ? com.heytap.accessory.bean.Message.CREATOR.createFromParcel(parcel) : null;
            b_renamed(deviceInfoCreateFromParcel, messageCreateFromParcel);
            parcel2.writeNoException();
            if (messageCreateFromParcel != null) {
                parcel2.writeInt(1);
                messageCreateFromParcel.writeToParcel(parcel2, 1);
            } else {
                parcel2.writeInt(0);
            }
            return true;
        }

        static class Proxy implements com.heytap.accessory.api.IDisPairCallback {

            /* renamed from: a_renamed, reason: collision with root package name */
            public static com.heytap.accessory.api.IDisPairCallback f3217a;

            /* renamed from: b_renamed, reason: collision with root package name */
            private android.os.IBinder f3218b;

            Proxy(android.os.IBinder iBinder) {
                this.f3218b = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.f3218b;
            }

            @Override // com.heytap.accessory.api.IDisPairCallback
            public void a_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo, com.heytap.accessory.bean.Message message) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IDisPairCallback");
                    if (deviceInfo != null) {
                        parcelObtain.writeInt(1);
                        deviceInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (message != null) {
                        parcelObtain.writeInt(1);
                        message.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f3218b.transact(1, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.IDisPairCallback.Stub.a_renamed() != null) {
                        com.heytap.accessory.api.IDisPairCallback.Stub.a_renamed().a_renamed(deviceInfo, message);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IDisPairCallback
            public void b_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo, com.heytap.accessory.bean.Message message) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IDisPairCallback");
                    if (deviceInfo != null) {
                        parcelObtain.writeInt(1);
                        deviceInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (message != null) {
                        parcelObtain.writeInt(1);
                        message.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f3218b.transact(2, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.IDisPairCallback.Stub.a_renamed() != null) {
                        com.heytap.accessory.api.IDisPairCallback.Stub.a_renamed().b_renamed(deviceInfo, message);
                    } else {
                        parcelObtain2.readException();
                        if (parcelObtain2.readInt() != 0) {
                            message.readFromParcel(parcelObtain2);
                        }
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IDisPairCallback
            public void c_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo, com.heytap.accessory.bean.Message message) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IDisPairCallback");
                    if (deviceInfo != null) {
                        parcelObtain.writeInt(1);
                        deviceInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (message != null) {
                        parcelObtain.writeInt(1);
                        message.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f3218b.transact(3, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.IDisPairCallback.Stub.a_renamed() != null) {
                        com.heytap.accessory.api.IDisPairCallback.Stub.a_renamed().c_renamed(deviceInfo, message);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static com.heytap.accessory.api.IDisPairCallback a_renamed() {
            return com.heytap.accessory.api.IDisPairCallback.Stub.Proxy.f3217a;
        }
    }
}
