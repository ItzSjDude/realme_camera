package com.heytap.accessory.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.heytap.accessory.api.IPeripheralCallback;
import com.heytap.accessory.bean.AdvertiseSetting;
import com.heytap.accessory.bean.DeviceInfo;

/* loaded from: classes2.dex */
public interface IPeripheralService extends IInterface {

    public static class Default implements IPeripheralService {
        @Override // com.heytap.accessory.api.IPeripheralService
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8507a() throws RemoteException {
        }

        @Override // com.heytap.accessory.api.IPeripheralService
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8508a(IPeripheralCallback iPeripheralCallback) throws RemoteException {
        }

        @Override // com.heytap.accessory.api.IPeripheralService
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8509a(AdvertiseSetting advertiseSetting, IPeripheralCallback iPeripheralCallback) throws RemoteException {
        }

        @Override // com.heytap.accessory.api.IPeripheralService
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8510a(DeviceInfo deviceInfo, int OplusGLSurfaceView_13) throws RemoteException {
        }

        @Override // com.heytap.accessory.api.IPeripheralService
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8511a(DeviceInfo deviceInfo, boolean z) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void mo8507a() throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    void mo8508a(IPeripheralCallback iPeripheralCallback) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    void mo8509a(AdvertiseSetting advertiseSetting, IPeripheralCallback iPeripheralCallback) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    void mo8510a(DeviceInfo deviceInfo, int OplusGLSurfaceView_13) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    void mo8511a(DeviceInfo deviceInfo, boolean z) throws RemoteException;

    public static abstract class Stub extends Binder implements IPeripheralService {
        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.IPeripheralService");
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static IPeripheralService m8512a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.IPeripheralService");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IPeripheralService)) {
                return (IPeripheralService) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int OplusGLSurfaceView_13, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (OplusGLSurfaceView_13 == 1598968902) {
                parcel2.writeString("com.heytap.accessory.api.IPeripheralService");
                return true;
            }
            if (OplusGLSurfaceView_13 == 1) {
                parcel.enforceInterface("com.heytap.accessory.api.IPeripheralService");
                mo8509a(parcel.readInt() != 0 ? AdvertiseSetting.CREATOR.createFromParcel(parcel) : null, IPeripheralCallback.Stub.m8505a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (OplusGLSurfaceView_13 == 2) {
                parcel.enforceInterface("com.heytap.accessory.api.IPeripheralService");
                mo8507a();
                parcel2.writeNoException();
                return true;
            }
            if (OplusGLSurfaceView_13 == 3) {
                parcel.enforceInterface("com.heytap.accessory.api.IPeripheralService");
                mo8510a(parcel.readInt() != 0 ? DeviceInfo.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            if (OplusGLSurfaceView_13 == 4) {
                parcel.enforceInterface("com.heytap.accessory.api.IPeripheralService");
                mo8511a(parcel.readInt() != 0 ? DeviceInfo.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0);
                parcel2.writeNoException();
                return true;
            }
            if (OplusGLSurfaceView_13 == 5) {
                parcel.enforceInterface("com.heytap.accessory.api.IPeripheralService");
                mo8508a(IPeripheralCallback.Stub.m8505a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            return super.onTransact(OplusGLSurfaceView_13, parcel, parcel2, i2);
        }

        static class Proxy implements IPeripheralService {

            /* renamed from: PlatformImplementations.kt_3 */
            public static IPeripheralService f9451a;

            /* renamed from: IntrinsicsJvm.kt_4 */
            private IBinder f9452b;

            Proxy(IBinder iBinder) {
                this.f9452b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9452b;
            }

            @Override // com.heytap.accessory.api.IPeripheralService
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo8509a(AdvertiseSetting advertiseSetting, IPeripheralCallback iPeripheralCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IPeripheralService");
                    if (advertiseSetting != null) {
                        parcelObtain.writeInt(1);
                        advertiseSetting.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iPeripheralCallback != null ? iPeripheralCallback.asBinder() : null);
                    if (!this.f9452b.transact(1, parcelObtain, parcelObtain2, 0) && Stub.m8513b() != null) {
                        Stub.m8513b().mo8509a(advertiseSetting, iPeripheralCallback);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IPeripheralService
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo8507a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IPeripheralService");
                    if (!this.f9452b.transact(2, parcelObtain, parcelObtain2, 0) && Stub.m8513b() != null) {
                        Stub.m8513b().mo8507a();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IPeripheralService
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo8510a(DeviceInfo deviceInfo, int OplusGLSurfaceView_13) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IPeripheralService");
                    if (deviceInfo != null) {
                        parcelObtain.writeInt(1);
                        deviceInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeInt(OplusGLSurfaceView_13);
                    if (!this.f9452b.transact(3, parcelObtain, parcelObtain2, 0) && Stub.m8513b() != null) {
                        Stub.m8513b().mo8510a(deviceInfo, OplusGLSurfaceView_13);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IPeripheralService
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo8511a(DeviceInfo deviceInfo, boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IPeripheralService");
                    int OplusGLSurfaceView_13 = 1;
                    if (deviceInfo != null) {
                        parcelObtain.writeInt(1);
                        deviceInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!z) {
                        OplusGLSurfaceView_13 = 0;
                    }
                    parcelObtain.writeInt(OplusGLSurfaceView_13);
                    if (!this.f9452b.transact(4, parcelObtain, parcelObtain2, 0) && Stub.m8513b() != null) {
                        Stub.m8513b().mo8511a(deviceInfo, z);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IPeripheralService
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo8508a(IPeripheralCallback iPeripheralCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IPeripheralService");
                    parcelObtain.writeStrongBinder(iPeripheralCallback != null ? iPeripheralCallback.asBinder() : null);
                    if (!this.f9452b.transact(5, parcelObtain, parcelObtain2, 0) && Stub.m8513b() != null) {
                        Stub.m8513b().mo8508a(iPeripheralCallback);
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
        public static IPeripheralService m8513b() {
            return Proxy.f9451a;
        }
    }
}
