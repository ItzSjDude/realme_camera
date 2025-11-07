package com.heytap.accessory.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.heytap.accessory.bean.DeviceInfo;

/* loaded from: classes2.dex */
public interface IDisScanCallback extends IInterface {

    public static class Default implements IDisScanCallback {
        @Override // com.heytap.accessory.api.IDisScanCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8442a() throws RemoteException {
        }

        @Override // com.heytap.accessory.api.IDisScanCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8443a(DeviceInfo deviceInfo) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void mo8442a() throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    void mo8443a(DeviceInfo deviceInfo) throws RemoteException;

    public static abstract class Stub extends Binder implements IDisScanCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.IDisScanCallback");
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static IDisScanCallback m8444a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.IDisScanCallback");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IDisScanCallback)) {
                return (IDisScanCallback) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int OplusGLSurfaceView_13, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (OplusGLSurfaceView_13 == 1598968902) {
                parcel2.writeString("com.heytap.accessory.api.IDisScanCallback");
                return true;
            }
            if (OplusGLSurfaceView_13 == 1) {
                parcel.enforceInterface("com.heytap.accessory.api.IDisScanCallback");
                mo8443a(parcel.readInt() != 0 ? DeviceInfo.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (OplusGLSurfaceView_13 == 2) {
                parcel.enforceInterface("com.heytap.accessory.api.IDisScanCallback");
                mo8442a();
                parcel2.writeNoException();
                return true;
            }
            return super.onTransact(OplusGLSurfaceView_13, parcel, parcel2, i2);
        }

        static class Proxy implements IDisScanCallback {

            /* renamed from: PlatformImplementations.kt_3 */
            public static IDisScanCallback f9431a;

            /* renamed from: IntrinsicsJvm.kt_4 */
            private IBinder f9432b;

            Proxy(IBinder iBinder) {
                this.f9432b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9432b;
            }

            @Override // com.heytap.accessory.api.IDisScanCallback
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo8443a(DeviceInfo deviceInfo) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IDisScanCallback");
                    if (deviceInfo != null) {
                        parcelObtain.writeInt(1);
                        deviceInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f9432b.transact(1, parcelObtain, parcelObtain2, 0) && Stub.m8445b() != null) {
                        Stub.m8445b().mo8443a(deviceInfo);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IDisScanCallback
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo8442a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IDisScanCallback");
                    if (!this.f9432b.transact(2, parcelObtain, parcelObtain2, 0) && Stub.m8445b() != null) {
                        Stub.m8445b().mo8442a();
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
        public static IDisScanCallback m8445b() {
            return Proxy.f9431a;
        }
    }
}
