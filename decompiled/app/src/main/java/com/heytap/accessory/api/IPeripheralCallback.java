package com.heytap.accessory.api;

/* loaded from: classes2.dex */
public interface IPeripheralCallback extends android.os.IInterface {

    public static class Default implements com.heytap.accessory.api.IPeripheralCallback {
        @Override // com.heytap.accessory.api.IPeripheralCallback
        public void a_renamed() throws android.os.RemoteException {
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        public void a_renamed(int i_renamed) throws android.os.RemoteException {
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        public void a_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo) throws android.os.RemoteException {
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        public void a_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo, com.heytap.accessory.bean.Message message) throws android.os.RemoteException {
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        public void a_renamed(com.heytap.accessory.bean.Message message) throws android.os.RemoteException {
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        public void b_renamed() throws android.os.RemoteException {
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        public void b_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo, com.heytap.accessory.bean.Message message) throws android.os.RemoteException {
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        public void c_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo, com.heytap.accessory.bean.Message message) throws android.os.RemoteException {
        }
    }

    void a_renamed() throws android.os.RemoteException;

    void a_renamed(int i_renamed) throws android.os.RemoteException;

    void a_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo) throws android.os.RemoteException;

    void a_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo, com.heytap.accessory.bean.Message message) throws android.os.RemoteException;

    void a_renamed(com.heytap.accessory.bean.Message message) throws android.os.RemoteException;

    void b_renamed() throws android.os.RemoteException;

    void b_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo, com.heytap.accessory.bean.Message message) throws android.os.RemoteException;

    void c_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo, com.heytap.accessory.bean.Message message) throws android.os.RemoteException;

    public static abstract class Stub extends android.os.Binder implements com.heytap.accessory.api.IPeripheralCallback {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.IPeripheralCallback");
        }

        public static com.heytap.accessory.api.IPeripheralCallback a_renamed(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.IPeripheralCallback");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof com.heytap.accessory.api.IPeripheralCallback)) {
                return (com.heytap.accessory.api.IPeripheralCallback) iInterfaceQueryLocalInterface;
            }
            return new com.heytap.accessory.api.IPeripheralCallback.Stub.Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i_renamed, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i_renamed == 1598968902) {
                parcel2.writeString("com.heytap.accessory.api.IPeripheralCallback");
                return true;
            }
            switch (i_renamed) {
                case 1:
                    parcel.enforceInterface("com.heytap.accessory.api.IPeripheralCallback");
                    a_renamed();
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.heytap.accessory.api.IPeripheralCallback");
                    a_renamed(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.heytap.accessory.api.IPeripheralCallback");
                    b_renamed();
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.heytap.accessory.api.IPeripheralCallback");
                    com.heytap.accessory.bean.DeviceInfo deviceInfoCreateFromParcel = parcel.readInt() != 0 ? com.heytap.accessory.bean.DeviceInfo.CREATOR.createFromParcel(parcel) : null;
                    com.heytap.accessory.bean.Message messageCreateFromParcel = parcel.readInt() != 0 ? com.heytap.accessory.bean.Message.CREATOR.createFromParcel(parcel) : null;
                    a_renamed(deviceInfoCreateFromParcel, messageCreateFromParcel);
                    parcel2.writeNoException();
                    if (messageCreateFromParcel != null) {
                        parcel2.writeInt(1);
                        messageCreateFromParcel.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 5:
                    parcel.enforceInterface("com.heytap.accessory.api.IPeripheralCallback");
                    com.heytap.accessory.bean.DeviceInfo deviceInfoCreateFromParcel2 = parcel.readInt() != 0 ? com.heytap.accessory.bean.DeviceInfo.CREATOR.createFromParcel(parcel) : null;
                    com.heytap.accessory.bean.Message messageCreateFromParcel2 = parcel.readInt() != 0 ? com.heytap.accessory.bean.Message.CREATOR.createFromParcel(parcel) : null;
                    b_renamed(deviceInfoCreateFromParcel2, messageCreateFromParcel2);
                    parcel2.writeNoException();
                    if (messageCreateFromParcel2 != null) {
                        parcel2.writeInt(1);
                        messageCreateFromParcel2.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 6:
                    parcel.enforceInterface("com.heytap.accessory.api.IPeripheralCallback");
                    a_renamed(parcel.readInt() != 0 ? com.heytap.accessory.bean.DeviceInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.heytap.accessory.api.IPeripheralCallback");
                    c_renamed(parcel.readInt() != 0 ? com.heytap.accessory.bean.DeviceInfo.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? com.heytap.accessory.bean.Message.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.heytap.accessory.api.IPeripheralCallback");
                    a_renamed(parcel.readInt() != 0 ? com.heytap.accessory.bean.Message.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i_renamed, parcel, parcel2, i2);
            }
        }

        static class Proxy implements com.heytap.accessory.api.IPeripheralCallback {

            /* renamed from: a_renamed, reason: collision with root package name */
            public static com.heytap.accessory.api.IPeripheralCallback f3237a;

            /* renamed from: b_renamed, reason: collision with root package name */
            private android.os.IBinder f3238b;

            Proxy(android.os.IBinder iBinder) {
                this.f3238b = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.f3238b;
            }

            @Override // com.heytap.accessory.api.IPeripheralCallback
            public void a_renamed() throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IPeripheralCallback");
                    if (!this.f3238b.transact(1, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.IPeripheralCallback.Stub.c_renamed() != null) {
                        com.heytap.accessory.api.IPeripheralCallback.Stub.c_renamed().a_renamed();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IPeripheralCallback
            public void a_renamed(int i_renamed) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IPeripheralCallback");
                    parcelObtain.writeInt(i_renamed);
                    if (!this.f3238b.transact(2, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.IPeripheralCallback.Stub.c_renamed() != null) {
                        com.heytap.accessory.api.IPeripheralCallback.Stub.c_renamed().a_renamed(i_renamed);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IPeripheralCallback
            public void b_renamed() throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IPeripheralCallback");
                    if (!this.f3238b.transact(3, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.IPeripheralCallback.Stub.c_renamed() != null) {
                        com.heytap.accessory.api.IPeripheralCallback.Stub.c_renamed().b_renamed();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IPeripheralCallback
            public void a_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo, com.heytap.accessory.bean.Message message) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IPeripheralCallback");
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
                    if (!this.f3238b.transact(4, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.IPeripheralCallback.Stub.c_renamed() != null) {
                        com.heytap.accessory.api.IPeripheralCallback.Stub.c_renamed().a_renamed(deviceInfo, message);
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

            @Override // com.heytap.accessory.api.IPeripheralCallback
            public void b_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo, com.heytap.accessory.bean.Message message) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IPeripheralCallback");
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
                    if (!this.f3238b.transact(5, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.IPeripheralCallback.Stub.c_renamed() != null) {
                        com.heytap.accessory.api.IPeripheralCallback.Stub.c_renamed().b_renamed(deviceInfo, message);
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

            @Override // com.heytap.accessory.api.IPeripheralCallback
            public void a_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IPeripheralCallback");
                    if (deviceInfo != null) {
                        parcelObtain.writeInt(1);
                        deviceInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f3238b.transact(6, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.IPeripheralCallback.Stub.c_renamed() != null) {
                        com.heytap.accessory.api.IPeripheralCallback.Stub.c_renamed().a_renamed(deviceInfo);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IPeripheralCallback
            public void c_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo, com.heytap.accessory.bean.Message message) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IPeripheralCallback");
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
                    if (!this.f3238b.transact(7, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.IPeripheralCallback.Stub.c_renamed() != null) {
                        com.heytap.accessory.api.IPeripheralCallback.Stub.c_renamed().c_renamed(deviceInfo, message);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IPeripheralCallback
            public void a_renamed(com.heytap.accessory.bean.Message message) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IPeripheralCallback");
                    if (message != null) {
                        parcelObtain.writeInt(1);
                        message.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f3238b.transact(8, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.IPeripheralCallback.Stub.c_renamed() != null) {
                        com.heytap.accessory.api.IPeripheralCallback.Stub.c_renamed().a_renamed(message);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static com.heytap.accessory.api.IPeripheralCallback c_renamed() {
            return com.heytap.accessory.api.IPeripheralCallback.Stub.Proxy.f3237a;
        }
    }
}
