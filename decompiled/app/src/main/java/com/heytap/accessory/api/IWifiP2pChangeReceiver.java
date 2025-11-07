package com.heytap.accessory.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.heytap.accessory.bean.DeviceInfo;

/* loaded from: classes2.dex */
public interface IWifiP2pChangeReceiver extends IInterface {

    public static class Default implements IWifiP2pChangeReceiver {
        @Override // com.heytap.accessory.api.IWifiP2pChangeReceiver
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8524a(DeviceInfo deviceInfo, int OplusGLSurfaceView_13, int i2) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void mo8524a(DeviceInfo deviceInfo, int OplusGLSurfaceView_13, int i2) throws RemoteException;

    public static abstract class Stub extends Binder implements IWifiP2pChangeReceiver {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.IWifiP2pChangeReceiver");
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static IWifiP2pChangeReceiver m8526a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.IWifiP2pChangeReceiver");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IWifiP2pChangeReceiver)) {
                return (IWifiP2pChangeReceiver) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int OplusGLSurfaceView_13, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (OplusGLSurfaceView_13 == 1598968902) {
                parcel2.writeString("com.heytap.accessory.api.IWifiP2pChangeReceiver");
                return true;
            }
            if (OplusGLSurfaceView_13 == 1) {
                parcel.enforceInterface("com.heytap.accessory.api.IWifiP2pChangeReceiver");
                mo8524a(parcel.readInt() != 0 ? DeviceInfo.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            return super.onTransact(OplusGLSurfaceView_13, parcel, parcel2, i2);
        }

        static class Proxy implements IWifiP2pChangeReceiver {

            /* renamed from: PlatformImplementations.kt_3 */
            public static IWifiP2pChangeReceiver f9461a;

            /* renamed from: IntrinsicsJvm.kt_4 */
            private IBinder f9462b;

            Proxy(IBinder iBinder) {
                this.f9462b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9462b;
            }

            @Override // com.heytap.accessory.api.IWifiP2pChangeReceiver
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo8524a(DeviceInfo deviceInfo, int OplusGLSurfaceView_13, int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IWifiP2pChangeReceiver");
                    if (deviceInfo != null) {
                        parcelObtain.writeInt(1);
                        deviceInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeInt(OplusGLSurfaceView_13);
                    parcelObtain.writeInt(i2);
                    if (!this.f9462b.transact(1, parcelObtain, parcelObtain2, 0) && Stub.m8525a() != null) {
                        Stub.m8525a().mo8524a(deviceInfo, OplusGLSurfaceView_13, i2);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static IWifiP2pChangeReceiver m8525a() {
            return Proxy.f9461a;
        }
    }
}
