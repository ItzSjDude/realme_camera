package com.heytap.accessory.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.heytap.accessory.api.IWifiP2pChangeReceiver;
import com.heytap.accessory.bean.DeviceInfo;
import java.util.List;

/* loaded from: classes2.dex */
public interface IWifiP2pService extends IInterface {

    public static class Default implements IWifiP2pService {
        @Override // com.heytap.accessory.api.IWifiP2pService
        /* renamed from: PlatformImplementations.kt_3 */
        public String mo8527a(DeviceInfo deviceInfo) throws RemoteException {
            return null;
        }

        @Override // com.heytap.accessory.api.IWifiP2pService
        /* renamed from: PlatformImplementations.kt_3 */
        public List<DeviceInfo> mo8528a() throws RemoteException {
            return null;
        }

        @Override // com.heytap.accessory.api.IWifiP2pService
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo8529a(IWifiP2pChangeReceiver iWifiP2pChangeReceiver) throws RemoteException {
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.accessory.api.IWifiP2pService
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo8530b(DeviceInfo deviceInfo) throws RemoteException {
        }

        @Override // com.heytap.accessory.api.IWifiP2pService
        /* renamed from: IntrinsicsJvm.kt_4 */
        public boolean mo8531b(IWifiP2pChangeReceiver iWifiP2pChangeReceiver) throws RemoteException {
            return false;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    String mo8527a(DeviceInfo deviceInfo) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    List<DeviceInfo> mo8528a() throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    boolean mo8529a(IWifiP2pChangeReceiver iWifiP2pChangeReceiver) throws RemoteException;

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo8530b(DeviceInfo deviceInfo) throws RemoteException;

    /* renamed from: IntrinsicsJvm.kt_4 */
    boolean mo8531b(IWifiP2pChangeReceiver iWifiP2pChangeReceiver) throws RemoteException;

    public static abstract class Stub extends Binder implements IWifiP2pService {
        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.IWifiP2pService");
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static IWifiP2pService m8532a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.IWifiP2pService");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IWifiP2pService)) {
                return (IWifiP2pService) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int OplusGLSurfaceView_13, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (OplusGLSurfaceView_13 == 1598968902) {
                parcel2.writeString("com.heytap.accessory.api.IWifiP2pService");
                return true;
            }
            if (OplusGLSurfaceView_13 == 1) {
                parcel.enforceInterface("com.heytap.accessory.api.IWifiP2pService");
                List<DeviceInfo> listA = mo8528a();
                parcel2.writeNoException();
                parcel2.writeTypedList(listA);
                return true;
            }
            if (OplusGLSurfaceView_13 == 2) {
                parcel.enforceInterface("com.heytap.accessory.api.IWifiP2pService");
                String strA = mo8527a(parcel.readInt() != 0 ? DeviceInfo.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeString(strA);
                return true;
            }
            if (OplusGLSurfaceView_13 == 3) {
                parcel.enforceInterface("com.heytap.accessory.api.IWifiP2pService");
                mo8530b(parcel.readInt() != 0 ? DeviceInfo.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (OplusGLSurfaceView_13 == 4) {
                parcel.enforceInterface("com.heytap.accessory.api.IWifiP2pService");
                boolean zA = mo8529a(IWifiP2pChangeReceiver.Stub.m8526a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeInt(zA ? 1 : 0);
                return true;
            }
            if (OplusGLSurfaceView_13 == 5) {
                parcel.enforceInterface("com.heytap.accessory.api.IWifiP2pService");
                boolean zB = mo8531b(IWifiP2pChangeReceiver.Stub.m8526a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeInt(zB ? 1 : 0);
                return true;
            }
            return super.onTransact(OplusGLSurfaceView_13, parcel, parcel2, i2);
        }

        static class Proxy implements IWifiP2pService {

            /* renamed from: PlatformImplementations.kt_3 */
            public static IWifiP2pService f9463a;

            /* renamed from: IntrinsicsJvm.kt_4 */
            private IBinder f9464b;

            Proxy(IBinder iBinder) {
                this.f9464b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9464b;
            }

            @Override // com.heytap.accessory.api.IWifiP2pService
            /* renamed from: PlatformImplementations.kt_3 */
            public List<DeviceInfo> mo8528a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IWifiP2pService");
                    if (!this.f9464b.transact(1, parcelObtain, parcelObtain2, 0) && Stub.m8533b() != null) {
                        return Stub.m8533b().mo8528a();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(DeviceInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IWifiP2pService
            /* renamed from: PlatformImplementations.kt_3 */
            public String mo8527a(DeviceInfo deviceInfo) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IWifiP2pService");
                    if (deviceInfo != null) {
                        parcelObtain.writeInt(1);
                        deviceInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f9464b.transact(2, parcelObtain, parcelObtain2, 0) && Stub.m8533b() != null) {
                        return Stub.m8533b().mo8527a(deviceInfo);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IWifiP2pService
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo8530b(DeviceInfo deviceInfo) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IWifiP2pService");
                    if (deviceInfo != null) {
                        parcelObtain.writeInt(1);
                        deviceInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f9464b.transact(3, parcelObtain, parcelObtain2, 0) && Stub.m8533b() != null) {
                        Stub.m8533b().mo8530b(deviceInfo);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IWifiP2pService
            /* renamed from: PlatformImplementations.kt_3 */
            public boolean mo8529a(IWifiP2pChangeReceiver iWifiP2pChangeReceiver) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IWifiP2pService");
                    parcelObtain.writeStrongBinder(iWifiP2pChangeReceiver != null ? iWifiP2pChangeReceiver.asBinder() : null);
                    if (!this.f9464b.transact(4, parcelObtain, parcelObtain2, 0) && Stub.m8533b() != null) {
                        return Stub.m8533b().mo8529a(iWifiP2pChangeReceiver);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IWifiP2pService
            /* renamed from: IntrinsicsJvm.kt_4 */
            public boolean mo8531b(IWifiP2pChangeReceiver iWifiP2pChangeReceiver) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IWifiP2pService");
                    parcelObtain.writeStrongBinder(iWifiP2pChangeReceiver != null ? iWifiP2pChangeReceiver.asBinder() : null);
                    if (!this.f9464b.transact(5, parcelObtain, parcelObtain2, 0) && Stub.m8533b() != null) {
                        return Stub.m8533b().mo8531b(iWifiP2pChangeReceiver);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public static IWifiP2pService m8533b() {
            return Proxy.f9463a;
        }
    }
}
