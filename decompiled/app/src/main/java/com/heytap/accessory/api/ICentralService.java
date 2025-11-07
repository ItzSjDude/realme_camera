package com.heytap.accessory.api;

/* loaded from: classes2.dex */
public interface ICentralService extends android.os.IInterface {

    public static class Default implements com.heytap.accessory.api.ICentralService {
        @Override // com.heytap.accessory.api.ICentralService
        public int a_renamed(com.heytap.accessory.bean.DirectPairInfo directPairInfo, com.heytap.accessory.api.IDirectPairCallback iDirectPairCallback) throws android.os.RemoteException {
            return 0;
        }

        @Override // com.heytap.accessory.api.ICentralService
        public int a_renamed(com.heytap.accessory.bean.PairSetting pairSetting, com.heytap.accessory.bean.DeviceInfo deviceInfo, com.heytap.accessory.api.IDisPairCallback iDisPairCallback) throws android.os.RemoteException {
            return 0;
        }

        @Override // com.heytap.accessory.api.ICentralService
        public int a_renamed(com.heytap.accessory.bean.ScanSetting scanSetting, android.os.Bundle bundle, com.heytap.accessory.api.IDisScanCallback iDisScanCallback) throws android.os.RemoteException {
            return 0;
        }

        @Override // com.heytap.accessory.api.ICentralService
        public void a_renamed() throws android.os.RemoteException {
        }

        @Override // com.heytap.accessory.api.ICentralService
        public void a_renamed(int i_renamed, boolean z_renamed) throws android.os.RemoteException {
        }

        @Override // com.heytap.accessory.api.ICentralService
        public void a_renamed(android.os.Bundle bundle) throws android.os.RemoteException {
        }

        @Override // com.heytap.accessory.api.ICentralService
        public void a_renamed(com.heytap.accessory.api.INsdDevicesCallback iNsdDevicesCallback) throws android.os.RemoteException {
        }

        @Override // com.heytap.accessory.api.ICentralService
        public void a_renamed(com.heytap.accessory.api.IPermissionCallback iPermissionCallback) throws android.os.RemoteException {
        }

        @Override // com.heytap.accessory.api.ICentralService
        public void a_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo) throws android.os.RemoteException {
        }

        @Override // com.heytap.accessory.api.ICentralService
        public void a_renamed(java.lang.String str, com.heytap.accessory.api.ILanCacheIpServiceCallback iLanCacheIpServiceCallback) throws android.os.RemoteException {
        }

        @Override // com.heytap.accessory.api.ICentralService
        public boolean a_renamed(int i_renamed) throws android.os.RemoteException {
            return false;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.accessory.api.ICentralService
        public int b_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo) throws android.os.RemoteException {
            return 0;
        }
    }

    int a_renamed(com.heytap.accessory.bean.DirectPairInfo directPairInfo, com.heytap.accessory.api.IDirectPairCallback iDirectPairCallback) throws android.os.RemoteException;

    int a_renamed(com.heytap.accessory.bean.PairSetting pairSetting, com.heytap.accessory.bean.DeviceInfo deviceInfo, com.heytap.accessory.api.IDisPairCallback iDisPairCallback) throws android.os.RemoteException;

    int a_renamed(com.heytap.accessory.bean.ScanSetting scanSetting, android.os.Bundle bundle, com.heytap.accessory.api.IDisScanCallback iDisScanCallback) throws android.os.RemoteException;

    void a_renamed() throws android.os.RemoteException;

    void a_renamed(int i_renamed, boolean z_renamed) throws android.os.RemoteException;

    void a_renamed(android.os.Bundle bundle) throws android.os.RemoteException;

    void a_renamed(com.heytap.accessory.api.INsdDevicesCallback iNsdDevicesCallback) throws android.os.RemoteException;

    void a_renamed(com.heytap.accessory.api.IPermissionCallback iPermissionCallback) throws android.os.RemoteException;

    void a_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo) throws android.os.RemoteException;

    void a_renamed(java.lang.String str, com.heytap.accessory.api.ILanCacheIpServiceCallback iLanCacheIpServiceCallback) throws android.os.RemoteException;

    boolean a_renamed(int i_renamed) throws android.os.RemoteException;

    int b_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo) throws android.os.RemoteException;

    public static abstract class Stub extends android.os.Binder implements com.heytap.accessory.api.ICentralService {
        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.ICentralService");
        }

        public static com.heytap.accessory.api.ICentralService a_renamed(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.ICentralService");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof com.heytap.accessory.api.ICentralService)) {
                return (com.heytap.accessory.api.ICentralService) iInterfaceQueryLocalInterface;
            }
            return new com.heytap.accessory.api.ICentralService.Stub.Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i_renamed, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i_renamed == 1598968902) {
                parcel2.writeString("com.heytap.accessory.api.ICentralService");
                return true;
            }
            switch (i_renamed) {
                case 1:
                    parcel.enforceInterface("com.heytap.accessory.api.ICentralService");
                    int iA = a_renamed(parcel.readInt() != 0 ? com.heytap.accessory.bean.ScanSetting.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (android.os.Bundle) android.os.Bundle.CREATOR.createFromParcel(parcel) : null, com.heytap.accessory.api.IDisScanCallback.Stub.a_renamed(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iA);
                    return true;
                case 2:
                    parcel.enforceInterface("com.heytap.accessory.api.ICentralService");
                    a_renamed();
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.heytap.accessory.api.ICentralService");
                    com.heytap.accessory.bean.PairSetting pairSettingCreateFromParcel = parcel.readInt() != 0 ? com.heytap.accessory.bean.PairSetting.CREATOR.createFromParcel(parcel) : null;
                    com.heytap.accessory.bean.DeviceInfo deviceInfoCreateFromParcel = parcel.readInt() != 0 ? com.heytap.accessory.bean.DeviceInfo.CREATOR.createFromParcel(parcel) : null;
                    int iA2 = a_renamed(pairSettingCreateFromParcel, deviceInfoCreateFromParcel, com.heytap.accessory.api.IDisPairCallback.Stub.a_renamed(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iA2);
                    if (deviceInfoCreateFromParcel != null) {
                        parcel2.writeInt(1);
                        deviceInfoCreateFromParcel.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 4:
                    parcel.enforceInterface("com.heytap.accessory.api.ICentralService");
                    com.heytap.accessory.bean.DeviceInfo deviceInfoCreateFromParcel2 = parcel.readInt() != 0 ? com.heytap.accessory.bean.DeviceInfo.CREATOR.createFromParcel(parcel) : null;
                    a_renamed(deviceInfoCreateFromParcel2);
                    parcel2.writeNoException();
                    if (deviceInfoCreateFromParcel2 != null) {
                        parcel2.writeInt(1);
                        deviceInfoCreateFromParcel2.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 5:
                    parcel.enforceInterface("com.heytap.accessory.api.ICentralService");
                    a_renamed(parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.heytap.accessory.api.ICentralService");
                    com.heytap.accessory.bean.DeviceInfo deviceInfoCreateFromParcel3 = parcel.readInt() != 0 ? com.heytap.accessory.bean.DeviceInfo.CREATOR.createFromParcel(parcel) : null;
                    int iB = b_renamed(deviceInfoCreateFromParcel3);
                    parcel2.writeNoException();
                    parcel2.writeInt(iB);
                    if (deviceInfoCreateFromParcel3 != null) {
                        parcel2.writeInt(1);
                        deviceInfoCreateFromParcel3.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 7:
                    parcel.enforceInterface("com.heytap.accessory.api.ICentralService");
                    boolean zA = a_renamed(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zA ? 1 : 0);
                    return true;
                case 8:
                    parcel.enforceInterface("com.heytap.accessory.api.ICentralService");
                    int iA3 = a_renamed(parcel.readInt() != 0 ? com.heytap.accessory.bean.DirectPairInfo.CREATOR.createFromParcel(parcel) : null, com.heytap.accessory.api.IDirectPairCallback.Stub.a_renamed(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iA3);
                    return true;
                case 9:
                    parcel.enforceInterface("com.heytap.accessory.api.ICentralService");
                    a_renamed(com.heytap.accessory.api.IPermissionCallback.Stub.a_renamed(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.heytap.accessory.api.ICentralService");
                    a_renamed(parcel.readString(), com.heytap.accessory.api.ILanCacheIpServiceCallback.Stub.a_renamed(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.heytap.accessory.api.ICentralService");
                    a_renamed(com.heytap.accessory.api.INsdDevicesCallback.Stub.a_renamed(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.heytap.accessory.api.ICentralService");
                    a_renamed(parcel.readInt() != 0 ? (android.os.Bundle) android.os.Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i_renamed, parcel, parcel2, i2);
            }
        }

        static class Proxy implements com.heytap.accessory.api.ICentralService {

            /* renamed from: a_renamed, reason: collision with root package name */
            public static com.heytap.accessory.api.ICentralService f3211a;

            /* renamed from: b_renamed, reason: collision with root package name */
            private android.os.IBinder f3212b;

            Proxy(android.os.IBinder iBinder) {
                this.f3212b = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.f3212b;
            }

            @Override // com.heytap.accessory.api.ICentralService
            public int a_renamed(com.heytap.accessory.bean.ScanSetting scanSetting, android.os.Bundle bundle, com.heytap.accessory.api.IDisScanCallback iDisScanCallback) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.ICentralService");
                    if (scanSetting != null) {
                        parcelObtain.writeInt(1);
                        scanSetting.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iDisScanCallback != null ? iDisScanCallback.asBinder() : null);
                    if (!this.f3212b.transact(1, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.ICentralService.Stub.b_renamed() != null) {
                        return com.heytap.accessory.api.ICentralService.Stub.b_renamed().a_renamed(scanSetting, bundle, iDisScanCallback);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.ICentralService
            public void a_renamed() throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.ICentralService");
                    if (!this.f3212b.transact(2, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.ICentralService.Stub.b_renamed() != null) {
                        com.heytap.accessory.api.ICentralService.Stub.b_renamed().a_renamed();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.ICentralService
            public int a_renamed(com.heytap.accessory.bean.PairSetting pairSetting, com.heytap.accessory.bean.DeviceInfo deviceInfo, com.heytap.accessory.api.IDisPairCallback iDisPairCallback) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.ICentralService");
                    if (pairSetting != null) {
                        parcelObtain.writeInt(1);
                        pairSetting.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (deviceInfo != null) {
                        parcelObtain.writeInt(1);
                        deviceInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iDisPairCallback != null ? iDisPairCallback.asBinder() : null);
                    if (!this.f3212b.transact(3, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.ICentralService.Stub.b_renamed() != null) {
                        return com.heytap.accessory.api.ICentralService.Stub.b_renamed().a_renamed(pairSetting, deviceInfo, iDisPairCallback);
                    }
                    parcelObtain2.readException();
                    int i_renamed = parcelObtain2.readInt();
                    if (parcelObtain2.readInt() != 0) {
                        deviceInfo.readFromParcel(parcelObtain2);
                    }
                    return i_renamed;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.ICentralService
            public void a_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.ICentralService");
                    if (deviceInfo != null) {
                        parcelObtain.writeInt(1);
                        deviceInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f3212b.transact(4, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.ICentralService.Stub.b_renamed() != null) {
                        com.heytap.accessory.api.ICentralService.Stub.b_renamed().a_renamed(deviceInfo);
                    } else {
                        parcelObtain2.readException();
                        if (parcelObtain2.readInt() != 0) {
                            deviceInfo.readFromParcel(parcelObtain2);
                        }
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.ICentralService
            public void a_renamed(int i_renamed, boolean z_renamed) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.ICentralService");
                    parcelObtain.writeInt(i_renamed);
                    parcelObtain.writeInt(z_renamed ? 1 : 0);
                    if (!this.f3212b.transact(5, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.ICentralService.Stub.b_renamed() != null) {
                        com.heytap.accessory.api.ICentralService.Stub.b_renamed().a_renamed(i_renamed, z_renamed);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.ICentralService
            public int b_renamed(com.heytap.accessory.bean.DeviceInfo deviceInfo) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.ICentralService");
                    if (deviceInfo != null) {
                        parcelObtain.writeInt(1);
                        deviceInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f3212b.transact(6, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.ICentralService.Stub.b_renamed() != null) {
                        return com.heytap.accessory.api.ICentralService.Stub.b_renamed().b_renamed(deviceInfo);
                    }
                    parcelObtain2.readException();
                    int i_renamed = parcelObtain2.readInt();
                    if (parcelObtain2.readInt() != 0) {
                        deviceInfo.readFromParcel(parcelObtain2);
                    }
                    return i_renamed;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.ICentralService
            public boolean a_renamed(int i_renamed) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.ICentralService");
                    parcelObtain.writeInt(i_renamed);
                    if (!this.f3212b.transact(7, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.ICentralService.Stub.b_renamed() != null) {
                        return com.heytap.accessory.api.ICentralService.Stub.b_renamed().a_renamed(i_renamed);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.ICentralService
            public int a_renamed(com.heytap.accessory.bean.DirectPairInfo directPairInfo, com.heytap.accessory.api.IDirectPairCallback iDirectPairCallback) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.ICentralService");
                    if (directPairInfo != null) {
                        parcelObtain.writeInt(1);
                        directPairInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iDirectPairCallback != null ? iDirectPairCallback.asBinder() : null);
                    if (!this.f3212b.transact(8, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.ICentralService.Stub.b_renamed() != null) {
                        return com.heytap.accessory.api.ICentralService.Stub.b_renamed().a_renamed(directPairInfo, iDirectPairCallback);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.ICentralService
            public void a_renamed(com.heytap.accessory.api.IPermissionCallback iPermissionCallback) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.ICentralService");
                    parcelObtain.writeStrongBinder(iPermissionCallback != null ? iPermissionCallback.asBinder() : null);
                    if (!this.f3212b.transact(9, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.ICentralService.Stub.b_renamed() != null) {
                        com.heytap.accessory.api.ICentralService.Stub.b_renamed().a_renamed(iPermissionCallback);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.ICentralService
            public void a_renamed(java.lang.String str, com.heytap.accessory.api.ILanCacheIpServiceCallback iLanCacheIpServiceCallback) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.ICentralService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iLanCacheIpServiceCallback != null ? iLanCacheIpServiceCallback.asBinder() : null);
                    if (!this.f3212b.transact(10, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.ICentralService.Stub.b_renamed() != null) {
                        com.heytap.accessory.api.ICentralService.Stub.b_renamed().a_renamed(str, iLanCacheIpServiceCallback);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.ICentralService
            public void a_renamed(com.heytap.accessory.api.INsdDevicesCallback iNsdDevicesCallback) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.ICentralService");
                    parcelObtain.writeStrongBinder(iNsdDevicesCallback != null ? iNsdDevicesCallback.asBinder() : null);
                    if (!this.f3212b.transact(11, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.ICentralService.Stub.b_renamed() != null) {
                        com.heytap.accessory.api.ICentralService.Stub.b_renamed().a_renamed(iNsdDevicesCallback);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.ICentralService
            public void a_renamed(android.os.Bundle bundle) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.ICentralService");
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f3212b.transact(12, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.ICentralService.Stub.b_renamed() != null) {
                        com.heytap.accessory.api.ICentralService.Stub.b_renamed().a_renamed(bundle);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static com.heytap.accessory.api.ICentralService b_renamed() {
            return com.heytap.accessory.api.ICentralService.Stub.Proxy.f3211a;
        }
    }
}
