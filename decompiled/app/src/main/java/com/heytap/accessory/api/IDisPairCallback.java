package com.heytap.accessory.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.heytap.accessory.bean.DeviceInfo;
import com.heytap.accessory.bean.Message;

/* loaded from: classes2.dex */
public interface IDisPairCallback extends IInterface {

    public static class Default implements IDisPairCallback {
        @Override // com.heytap.accessory.api.IDisPairCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8437a(DeviceInfo deviceInfo, Message message) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.accessory.api.IDisPairCallback
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo8438b(DeviceInfo deviceInfo, Message message) throws RemoteException {
        }

        @Override // com.heytap.accessory.api.IDisPairCallback
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo8439c(DeviceInfo deviceInfo, Message message) throws RemoteException {
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void mo8437a(DeviceInfo deviceInfo, Message message) throws RemoteException;

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo8438b(DeviceInfo deviceInfo, Message message) throws RemoteException;

    /* renamed from: IntrinsicsJvm.kt_3 */
    void mo8439c(DeviceInfo deviceInfo, Message message) throws RemoteException;

    public static abstract class Stub extends Binder implements IDisPairCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.IDisPairCallback");
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static IDisPairCallback m8441a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.IDisPairCallback");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IDisPairCallback)) {
                return (IDisPairCallback) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int OplusGLSurfaceView_13, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (OplusGLSurfaceView_13 == 1598968902) {
                parcel2.writeString("com.heytap.accessory.api.IDisPairCallback");
                return true;
            }
            if (OplusGLSurfaceView_13 == 1) {
                parcel.enforceInterface("com.heytap.accessory.api.IDisPairCallback");
                mo8437a(parcel.readInt() != 0 ? DeviceInfo.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? Message.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (OplusGLSurfaceView_13 != 2) {
                if (OplusGLSurfaceView_13 == 3) {
                    parcel.enforceInterface("com.heytap.accessory.api.IDisPairCallback");
                    mo8439c(parcel.readInt() != 0 ? DeviceInfo.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? Message.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                }
                return super.onTransact(OplusGLSurfaceView_13, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.heytap.accessory.api.IDisPairCallback");
            DeviceInfo deviceInfoCreateFromParcel = parcel.readInt() != 0 ? DeviceInfo.CREATOR.createFromParcel(parcel) : null;
            Message messageCreateFromParcel = parcel.readInt() != 0 ? Message.CREATOR.createFromParcel(parcel) : null;
            mo8438b(deviceInfoCreateFromParcel, messageCreateFromParcel);
            parcel2.writeNoException();
            if (messageCreateFromParcel != null) {
                parcel2.writeInt(1);
                messageCreateFromParcel.writeToParcel(parcel2, 1);
            } else {
                parcel2.writeInt(0);
            }
            return true;
        }

        static class Proxy implements IDisPairCallback {

            /* renamed from: PlatformImplementations.kt_3 */
            public static IDisPairCallback f9429a;

            /* renamed from: IntrinsicsJvm.kt_4 */
            private IBinder f9430b;

            Proxy(IBinder iBinder) {
                this.f9430b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9430b;
            }

            @Override // com.heytap.accessory.api.IDisPairCallback
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo8437a(DeviceInfo deviceInfo, Message message) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IDisPairCallback");
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
                    if (!this.f9430b.transact(1, parcelObtain, parcelObtain2, 0) && Stub.m8440a() != null) {
                        Stub.m8440a().mo8437a(deviceInfo, message);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IDisPairCallback
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo8438b(DeviceInfo deviceInfo, Message message) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IDisPairCallback");
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
                    if (!this.f9430b.transact(2, parcelObtain, parcelObtain2, 0) && Stub.m8440a() != null) {
                        Stub.m8440a().mo8438b(deviceInfo, message);
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

            @Override // com.heytap.accessory.api.IDisPairCallback
            /* renamed from: IntrinsicsJvm.kt_3 */
            public void mo8439c(DeviceInfo deviceInfo, Message message) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IDisPairCallback");
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
                    if (!this.f9430b.transact(3, parcelObtain, parcelObtain2, 0) && Stub.m8440a() != null) {
                        Stub.m8440a().mo8439c(deviceInfo, message);
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
        public static IDisPairCallback m8440a() {
            return Proxy.f9429a;
        }
    }
}
