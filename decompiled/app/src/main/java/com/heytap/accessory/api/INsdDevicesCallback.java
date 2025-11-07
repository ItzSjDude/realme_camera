package com.heytap.accessory.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.heytap.accessory.bean.DeviceInfo;
import java.util.List;

/* loaded from: classes2.dex */
public interface INsdDevicesCallback extends IInterface {

    public static class Default implements INsdDevicesCallback {
        @Override // com.heytap.accessory.api.INsdDevicesCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8490a(List<DeviceInfo> list) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void mo8490a(List<DeviceInfo> list) throws RemoteException;

    public static abstract class Stub extends Binder implements INsdDevicesCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.INsdDevicesCallback");
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static INsdDevicesCallback m8492a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.INsdDevicesCallback");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof INsdDevicesCallback)) {
                return (INsdDevicesCallback) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int OplusGLSurfaceView_13, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (OplusGLSurfaceView_13 == 1598968902) {
                parcel2.writeString("com.heytap.accessory.api.INsdDevicesCallback");
                return true;
            }
            if (OplusGLSurfaceView_13 == 1) {
                parcel.enforceInterface("com.heytap.accessory.api.INsdDevicesCallback");
                mo8490a(parcel.createTypedArrayList(DeviceInfo.CREATOR));
                parcel2.writeNoException();
                return true;
            }
            return super.onTransact(OplusGLSurfaceView_13, parcel, parcel2, i2);
        }

        static class Proxy implements INsdDevicesCallback {

            /* renamed from: PlatformImplementations.kt_3 */
            public static INsdDevicesCallback f9443a;

            /* renamed from: IntrinsicsJvm.kt_4 */
            private IBinder f9444b;

            Proxy(IBinder iBinder) {
                this.f9444b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9444b;
            }

            @Override // com.heytap.accessory.api.INsdDevicesCallback
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo8490a(List<DeviceInfo> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.INsdDevicesCallback");
                    parcelObtain.writeTypedList(list);
                    if (!this.f9444b.transact(1, parcelObtain, parcelObtain2, 0) && Stub.m8491a() != null) {
                        Stub.m8491a().mo8490a(list);
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
        public static INsdDevicesCallback m8491a() {
            return Proxy.f9443a;
        }
    }
}
