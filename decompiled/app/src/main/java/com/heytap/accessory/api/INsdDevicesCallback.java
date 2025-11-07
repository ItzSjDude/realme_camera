package com.heytap.accessory.api;

/* loaded from: classes2.dex */
public interface INsdDevicesCallback extends android.os.IInterface {

    public static class Default implements com.heytap.accessory.api.INsdDevicesCallback {
        @Override // com.heytap.accessory.api.INsdDevicesCallback
        public void a_renamed(java.util.List<com.heytap.accessory.bean.DeviceInfo> list) throws android.os.RemoteException {
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }
    }

    void a_renamed(java.util.List<com.heytap.accessory.bean.DeviceInfo> list) throws android.os.RemoteException;

    public static abstract class Stub extends android.os.Binder implements com.heytap.accessory.api.INsdDevicesCallback {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.INsdDevicesCallback");
        }

        public static com.heytap.accessory.api.INsdDevicesCallback a_renamed(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.INsdDevicesCallback");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof com.heytap.accessory.api.INsdDevicesCallback)) {
                return (com.heytap.accessory.api.INsdDevicesCallback) iInterfaceQueryLocalInterface;
            }
            return new com.heytap.accessory.api.INsdDevicesCallback.Stub.Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i_renamed, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i_renamed == 1598968902) {
                parcel2.writeString("com.heytap.accessory.api.INsdDevicesCallback");
                return true;
            }
            if (i_renamed == 1) {
                parcel.enforceInterface("com.heytap.accessory.api.INsdDevicesCallback");
                a_renamed(parcel.createTypedArrayList(com.heytap.accessory.bean.DeviceInfo.CREATOR));
                parcel2.writeNoException();
                return true;
            }
            return super.onTransact(i_renamed, parcel, parcel2, i2);
        }

        static class Proxy implements com.heytap.accessory.api.INsdDevicesCallback {

            /* renamed from: a_renamed, reason: collision with root package name */
            public static com.heytap.accessory.api.INsdDevicesCallback f3231a;

            /* renamed from: b_renamed, reason: collision with root package name */
            private android.os.IBinder f3232b;

            Proxy(android.os.IBinder iBinder) {
                this.f3232b = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.f3232b;
            }

            @Override // com.heytap.accessory.api.INsdDevicesCallback
            public void a_renamed(java.util.List<com.heytap.accessory.bean.DeviceInfo> list) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.INsdDevicesCallback");
                    parcelObtain.writeTypedList(list);
                    if (!this.f3232b.transact(1, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.INsdDevicesCallback.Stub.a_renamed() != null) {
                        com.heytap.accessory.api.INsdDevicesCallback.Stub.a_renamed().a_renamed(list);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static com.heytap.accessory.api.INsdDevicesCallback a_renamed() {
            return com.heytap.accessory.api.INsdDevicesCallback.Stub.Proxy.f3231a;
        }
    }
}
