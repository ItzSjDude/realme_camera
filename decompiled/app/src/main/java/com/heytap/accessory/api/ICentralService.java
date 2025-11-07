package com.heytap.accessory.api;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.heytap.accessory.api.IDirectPairCallback;
import com.heytap.accessory.api.IDisPairCallback;
import com.heytap.accessory.api.IDisScanCallback;
import com.heytap.accessory.api.ILanCacheIpServiceCallback;
import com.heytap.accessory.api.INsdDevicesCallback;
import com.heytap.accessory.api.IPermissionCallback;
import com.heytap.accessory.bean.DeviceInfo;
import com.heytap.accessory.bean.DirectPairInfo;
import com.heytap.accessory.bean.PairSetting;
import com.heytap.accessory.bean.ScanSetting;

/* loaded from: classes2.dex */
public interface ICentralService extends IInterface {

    public static class Default implements ICentralService {
        @Override // com.heytap.accessory.api.ICentralService
        /* renamed from: PlatformImplementations.kt_3 */
        public int mo8417a(DirectPairInfo directPairInfo, IDirectPairCallback iDirectPairCallback) throws RemoteException {
            return 0;
        }

        @Override // com.heytap.accessory.api.ICentralService
        /* renamed from: PlatformImplementations.kt_3 */
        public int mo8418a(PairSetting pairSetting, DeviceInfo deviceInfo, IDisPairCallback iDisPairCallback) throws RemoteException {
            return 0;
        }

        @Override // com.heytap.accessory.api.ICentralService
        /* renamed from: PlatformImplementations.kt_3 */
        public int mo8419a(ScanSetting scanSetting, Bundle bundle, IDisScanCallback iDisScanCallback) throws RemoteException {
            return 0;
        }

        @Override // com.heytap.accessory.api.ICentralService
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8420a() throws RemoteException {
        }

        @Override // com.heytap.accessory.api.ICentralService
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8421a(int OplusGLSurfaceView_13, boolean z) throws RemoteException {
        }

        @Override // com.heytap.accessory.api.ICentralService
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8422a(Bundle bundle) throws RemoteException {
        }

        @Override // com.heytap.accessory.api.ICentralService
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8423a(INsdDevicesCallback iNsdDevicesCallback) throws RemoteException {
        }

        @Override // com.heytap.accessory.api.ICentralService
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8424a(IPermissionCallback iPermissionCallback) throws RemoteException {
        }

        @Override // com.heytap.accessory.api.ICentralService
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8425a(DeviceInfo deviceInfo) throws RemoteException {
        }

        @Override // com.heytap.accessory.api.ICentralService
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8426a(String str, ILanCacheIpServiceCallback iLanCacheIpServiceCallback) throws RemoteException {
        }

        @Override // com.heytap.accessory.api.ICentralService
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo8427a(int OplusGLSurfaceView_13) throws RemoteException {
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.accessory.api.ICentralService
        /* renamed from: IntrinsicsJvm.kt_4 */
        public int mo8428b(DeviceInfo deviceInfo) throws RemoteException {
            return 0;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    int mo8417a(DirectPairInfo directPairInfo, IDirectPairCallback iDirectPairCallback) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    int mo8418a(PairSetting pairSetting, DeviceInfo deviceInfo, IDisPairCallback iDisPairCallback) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    int mo8419a(ScanSetting scanSetting, Bundle bundle, IDisScanCallback iDisScanCallback) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    void mo8420a() throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    void mo8421a(int OplusGLSurfaceView_13, boolean z) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    void mo8422a(Bundle bundle) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    void mo8423a(INsdDevicesCallback iNsdDevicesCallback) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    void mo8424a(IPermissionCallback iPermissionCallback) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    void mo8425a(DeviceInfo deviceInfo) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    void mo8426a(String str, ILanCacheIpServiceCallback iLanCacheIpServiceCallback) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    boolean mo8427a(int OplusGLSurfaceView_13) throws RemoteException;

    /* renamed from: IntrinsicsJvm.kt_4 */
    int mo8428b(DeviceInfo deviceInfo) throws RemoteException;

    public static abstract class Stub extends Binder implements ICentralService {
        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.ICentralService");
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static ICentralService m8429a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.ICentralService");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof ICentralService)) {
                return (ICentralService) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int OplusGLSurfaceView_13, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (OplusGLSurfaceView_13 == 1598968902) {
                parcel2.writeString("com.heytap.accessory.api.ICentralService");
                return true;
            }
            switch (OplusGLSurfaceView_13) {
                case 1:
                    parcel.enforceInterface("com.heytap.accessory.api.ICentralService");
                    int iA = mo8419a(parcel.readInt() != 0 ? ScanSetting.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, IDisScanCallback.Stub.m8444a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iA);
                    return true;
                case 2:
                    parcel.enforceInterface("com.heytap.accessory.api.ICentralService");
                    mo8420a();
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.heytap.accessory.api.ICentralService");
                    PairSetting pairSettingCreateFromParcel = parcel.readInt() != 0 ? PairSetting.CREATOR.createFromParcel(parcel) : null;
                    DeviceInfo deviceInfoCreateFromParcel = parcel.readInt() != 0 ? DeviceInfo.CREATOR.createFromParcel(parcel) : null;
                    int iA2 = mo8418a(pairSettingCreateFromParcel, deviceInfoCreateFromParcel, IDisPairCallback.Stub.m8441a(parcel.readStrongBinder()));
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
                    DeviceInfo deviceInfoCreateFromParcel2 = parcel.readInt() != 0 ? DeviceInfo.CREATOR.createFromParcel(parcel) : null;
                    mo8425a(deviceInfoCreateFromParcel2);
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
                    mo8421a(parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.heytap.accessory.api.ICentralService");
                    DeviceInfo deviceInfoCreateFromParcel3 = parcel.readInt() != 0 ? DeviceInfo.CREATOR.createFromParcel(parcel) : null;
                    int iB = mo8428b(deviceInfoCreateFromParcel3);
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
                    boolean zA = mo8427a(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zA ? 1 : 0);
                    return true;
                case 8:
                    parcel.enforceInterface("com.heytap.accessory.api.ICentralService");
                    int iA3 = mo8417a(parcel.readInt() != 0 ? DirectPairInfo.CREATOR.createFromParcel(parcel) : null, IDirectPairCallback.Stub.m8436a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iA3);
                    return true;
                case 9:
                    parcel.enforceInterface("com.heytap.accessory.api.ICentralService");
                    mo8424a(IPermissionCallback.Stub.m8516a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.heytap.accessory.api.ICentralService");
                    mo8426a(parcel.readString(), ILanCacheIpServiceCallback.Stub.m8487a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.heytap.accessory.api.ICentralService");
                    mo8423a(INsdDevicesCallback.Stub.m8492a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.heytap.accessory.api.ICentralService");
                    mo8422a(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(OplusGLSurfaceView_13, parcel, parcel2, i2);
            }
        }

        static class Proxy implements ICentralService {

            /* renamed from: PlatformImplementations.kt_3 */
            public static ICentralService f9423a;

            /* renamed from: IntrinsicsJvm.kt_4 */
            private IBinder f9424b;

            Proxy(IBinder iBinder) {
                this.f9424b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9424b;
            }

            @Override // com.heytap.accessory.api.ICentralService
            /* renamed from: PlatformImplementations.kt_3 */
            public int mo8419a(ScanSetting scanSetting, Bundle bundle, IDisScanCallback iDisScanCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
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
                    if (!this.f9424b.transact(1, parcelObtain, parcelObtain2, 0) && Stub.m8430b() != null) {
                        return Stub.m8430b().mo8419a(scanSetting, bundle, iDisScanCallback);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.ICentralService
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo8420a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.ICentralService");
                    if (!this.f9424b.transact(2, parcelObtain, parcelObtain2, 0) && Stub.m8430b() != null) {
                        Stub.m8430b().mo8420a();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.ICentralService
            /* renamed from: PlatformImplementations.kt_3 */
            public int mo8418a(PairSetting pairSetting, DeviceInfo deviceInfo, IDisPairCallback iDisPairCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
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
                    if (!this.f9424b.transact(3, parcelObtain, parcelObtain2, 0) && Stub.m8430b() != null) {
                        return Stub.m8430b().mo8418a(pairSetting, deviceInfo, iDisPairCallback);
                    }
                    parcelObtain2.readException();
                    int OplusGLSurfaceView_13 = parcelObtain2.readInt();
                    if (parcelObtain2.readInt() != 0) {
                        deviceInfo.readFromParcel(parcelObtain2);
                    }
                    return OplusGLSurfaceView_13;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.ICentralService
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo8425a(DeviceInfo deviceInfo) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.ICentralService");
                    if (deviceInfo != null) {
                        parcelObtain.writeInt(1);
                        deviceInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f9424b.transact(4, parcelObtain, parcelObtain2, 0) && Stub.m8430b() != null) {
                        Stub.m8430b().mo8425a(deviceInfo);
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
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo8421a(int OplusGLSurfaceView_13, boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.ICentralService");
                    parcelObtain.writeInt(OplusGLSurfaceView_13);
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (!this.f9424b.transact(5, parcelObtain, parcelObtain2, 0) && Stub.m8430b() != null) {
                        Stub.m8430b().mo8421a(OplusGLSurfaceView_13, z);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.ICentralService
            /* renamed from: IntrinsicsJvm.kt_4 */
            public int mo8428b(DeviceInfo deviceInfo) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.ICentralService");
                    if (deviceInfo != null) {
                        parcelObtain.writeInt(1);
                        deviceInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f9424b.transact(6, parcelObtain, parcelObtain2, 0) && Stub.m8430b() != null) {
                        return Stub.m8430b().mo8428b(deviceInfo);
                    }
                    parcelObtain2.readException();
                    int OplusGLSurfaceView_13 = parcelObtain2.readInt();
                    if (parcelObtain2.readInt() != 0) {
                        deviceInfo.readFromParcel(parcelObtain2);
                    }
                    return OplusGLSurfaceView_13;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.ICentralService
            /* renamed from: PlatformImplementations.kt_3 */
            public boolean mo8427a(int OplusGLSurfaceView_13) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.ICentralService");
                    parcelObtain.writeInt(OplusGLSurfaceView_13);
                    if (!this.f9424b.transact(7, parcelObtain, parcelObtain2, 0) && Stub.m8430b() != null) {
                        return Stub.m8430b().mo8427a(OplusGLSurfaceView_13);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.ICentralService
            /* renamed from: PlatformImplementations.kt_3 */
            public int mo8417a(DirectPairInfo directPairInfo, IDirectPairCallback iDirectPairCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.ICentralService");
                    if (directPairInfo != null) {
                        parcelObtain.writeInt(1);
                        directPairInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iDirectPairCallback != null ? iDirectPairCallback.asBinder() : null);
                    if (!this.f9424b.transact(8, parcelObtain, parcelObtain2, 0) && Stub.m8430b() != null) {
                        return Stub.m8430b().mo8417a(directPairInfo, iDirectPairCallback);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.ICentralService
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo8424a(IPermissionCallback iPermissionCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.ICentralService");
                    parcelObtain.writeStrongBinder(iPermissionCallback != null ? iPermissionCallback.asBinder() : null);
                    if (!this.f9424b.transact(9, parcelObtain, parcelObtain2, 0) && Stub.m8430b() != null) {
                        Stub.m8430b().mo8424a(iPermissionCallback);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.ICentralService
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo8426a(String str, ILanCacheIpServiceCallback iLanCacheIpServiceCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.ICentralService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iLanCacheIpServiceCallback != null ? iLanCacheIpServiceCallback.asBinder() : null);
                    if (!this.f9424b.transact(10, parcelObtain, parcelObtain2, 0) && Stub.m8430b() != null) {
                        Stub.m8430b().mo8426a(str, iLanCacheIpServiceCallback);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.ICentralService
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo8423a(INsdDevicesCallback iNsdDevicesCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.ICentralService");
                    parcelObtain.writeStrongBinder(iNsdDevicesCallback != null ? iNsdDevicesCallback.asBinder() : null);
                    if (!this.f9424b.transact(11, parcelObtain, parcelObtain2, 0) && Stub.m8430b() != null) {
                        Stub.m8430b().mo8423a(iNsdDevicesCallback);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.ICentralService
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo8422a(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.ICentralService");
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f9424b.transact(12, parcelObtain, parcelObtain2, 0) && Stub.m8430b() != null) {
                        Stub.m8430b().mo8422a(bundle);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public static ICentralService m8430b() {
            return Proxy.f9423a;
        }
    }
}
