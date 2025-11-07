package com.heytap.accessory.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.heytap.accessory.bean.DeviceInfo;
import com.heytap.accessory.bean.Message;

/* loaded from: classes2.dex */
public interface IDirectPairCallback extends IInterface {

    public static class Default implements IDirectPairCallback {
        @Override // com.heytap.accessory.api.IDirectPairCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8433a(DeviceInfo deviceInfo, Message message) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.accessory.api.IDirectPairCallback
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo8434b(DeviceInfo deviceInfo, Message message) throws RemoteException {
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void mo8433a(DeviceInfo deviceInfo, Message message) throws RemoteException;

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo8434b(DeviceInfo deviceInfo, Message message) throws RemoteException;

    public static abstract class Stub extends Binder implements IDirectPairCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.IDirectPairCallback");
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static IDirectPairCallback m8436a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.IDirectPairCallback");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IDirectPairCallback)) {
                return (IDirectPairCallback) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int OplusGLSurfaceView_13, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (OplusGLSurfaceView_13 == 1598968902) {
                parcel2.writeString("com.heytap.accessory.api.IDirectPairCallback");
                return true;
            }
            if (OplusGLSurfaceView_13 == 1) {
                parcel.enforceInterface("com.heytap.accessory.api.IDirectPairCallback");
                mo8433a(parcel.readInt() != 0 ? DeviceInfo.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? Message.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (OplusGLSurfaceView_13 == 2) {
                parcel.enforceInterface("com.heytap.accessory.api.IDirectPairCallback");
                mo8434b(parcel.readInt() != 0 ? DeviceInfo.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? Message.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            return super.onTransact(OplusGLSurfaceView_13, parcel, parcel2, i2);
        }

        static class Proxy implements IDirectPairCallback {

            /* renamed from: PlatformImplementations.kt_3 */
            public static IDirectPairCallback f9427a;

            /* renamed from: IntrinsicsJvm.kt_4 */
            private IBinder f9428b;

            Proxy(IBinder iBinder) {
                this.f9428b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9428b;
            }

            @Override // com.heytap.accessory.api.IDirectPairCallback
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo8433a(DeviceInfo deviceInfo, Message message) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IDirectPairCallback");
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
                    if (!this.f9428b.transact(1, parcelObtain, parcelObtain2, 0) && Stub.m8435a() != null) {
                        Stub.m8435a().mo8433a(deviceInfo, message);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IDirectPairCallback
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo8434b(DeviceInfo deviceInfo, Message message) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IDirectPairCallback");
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
                    if (!this.f9428b.transact(2, parcelObtain, parcelObtain2, 0) && Stub.m8435a() != null) {
                        Stub.m8435a().mo8434b(deviceInfo, message);
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
        public static IDirectPairCallback m8435a() {
            return Proxy.f9427a;
        }
    }
}
