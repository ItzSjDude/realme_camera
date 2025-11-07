package com.heytap.accessory.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.heytap.accessory.bean.DeviceInfo;
import com.heytap.accessory.bean.Message;

/* loaded from: classes2.dex */
public interface IPeripheralCallback extends IInterface {

    public static class Default implements IPeripheralCallback {
        @Override // com.heytap.accessory.api.IPeripheralCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8497a() throws RemoteException {
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8498a(int OplusGLSurfaceView_13) throws RemoteException {
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8499a(DeviceInfo deviceInfo) throws RemoteException {
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8500a(DeviceInfo deviceInfo, Message message) throws RemoteException {
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8501a(Message message) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo8502b() throws RemoteException {
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo8503b(DeviceInfo deviceInfo, Message message) throws RemoteException {
        }

        @Override // com.heytap.accessory.api.IPeripheralCallback
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo8504c(DeviceInfo deviceInfo, Message message) throws RemoteException {
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void mo8497a() throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    void mo8498a(int OplusGLSurfaceView_13) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    void mo8499a(DeviceInfo deviceInfo) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    void mo8500a(DeviceInfo deviceInfo, Message message) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    void mo8501a(Message message) throws RemoteException;

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo8502b() throws RemoteException;

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo8503b(DeviceInfo deviceInfo, Message message) throws RemoteException;

    /* renamed from: IntrinsicsJvm.kt_3 */
    void mo8504c(DeviceInfo deviceInfo, Message message) throws RemoteException;

    public static abstract class Stub extends Binder implements IPeripheralCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.IPeripheralCallback");
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static IPeripheralCallback m8505a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.IPeripheralCallback");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IPeripheralCallback)) {
                return (IPeripheralCallback) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int OplusGLSurfaceView_13, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (OplusGLSurfaceView_13 == 1598968902) {
                parcel2.writeString("com.heytap.accessory.api.IPeripheralCallback");
                return true;
            }
            switch (OplusGLSurfaceView_13) {
                case 1:
                    parcel.enforceInterface("com.heytap.accessory.api.IPeripheralCallback");
                    mo8497a();
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.heytap.accessory.api.IPeripheralCallback");
                    mo8498a(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.heytap.accessory.api.IPeripheralCallback");
                    mo8502b();
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.heytap.accessory.api.IPeripheralCallback");
                    DeviceInfo deviceInfoCreateFromParcel = parcel.readInt() != 0 ? DeviceInfo.CREATOR.createFromParcel(parcel) : null;
                    Message messageCreateFromParcel = parcel.readInt() != 0 ? Message.CREATOR.createFromParcel(parcel) : null;
                    mo8500a(deviceInfoCreateFromParcel, messageCreateFromParcel);
                    parcel2.writeNoException();
                    if (messageCreateFromParcel != null) {
                        parcel2.writeInt(1);
                        messageCreateFromParcel.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 5:
                    parcel.enforceInterface("com.heytap.accessory.api.IPeripheralCallback");
                    DeviceInfo deviceInfoCreateFromParcel2 = parcel.readInt() != 0 ? DeviceInfo.CREATOR.createFromParcel(parcel) : null;
                    Message messageCreateFromParcel2 = parcel.readInt() != 0 ? Message.CREATOR.createFromParcel(parcel) : null;
                    mo8503b(deviceInfoCreateFromParcel2, messageCreateFromParcel2);
                    parcel2.writeNoException();
                    if (messageCreateFromParcel2 != null) {
                        parcel2.writeInt(1);
                        messageCreateFromParcel2.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 6:
                    parcel.enforceInterface("com.heytap.accessory.api.IPeripheralCallback");
                    mo8499a(parcel.readInt() != 0 ? DeviceInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.heytap.accessory.api.IPeripheralCallback");
                    mo8504c(parcel.readInt() != 0 ? DeviceInfo.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? Message.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.heytap.accessory.api.IPeripheralCallback");
                    mo8501a(parcel.readInt() != 0 ? Message.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(OplusGLSurfaceView_13, parcel, parcel2, i2);
            }
        }

        static class Proxy implements IPeripheralCallback {

            /* renamed from: PlatformImplementations.kt_3 */
            public static IPeripheralCallback f9449a;

            /* renamed from: IntrinsicsJvm.kt_4 */
            private IBinder f9450b;

            Proxy(IBinder iBinder) {
                this.f9450b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9450b;
            }

            @Override // com.heytap.accessory.api.IPeripheralCallback
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo8497a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IPeripheralCallback");
                    if (!this.f9450b.transact(1, parcelObtain, parcelObtain2, 0) && Stub.m8506c() != null) {
                        Stub.m8506c().mo8497a();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IPeripheralCallback
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo8498a(int OplusGLSurfaceView_13) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IPeripheralCallback");
                    parcelObtain.writeInt(OplusGLSurfaceView_13);
                    if (!this.f9450b.transact(2, parcelObtain, parcelObtain2, 0) && Stub.m8506c() != null) {
                        Stub.m8506c().mo8498a(OplusGLSurfaceView_13);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IPeripheralCallback
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo8502b() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IPeripheralCallback");
                    if (!this.f9450b.transact(3, parcelObtain, parcelObtain2, 0) && Stub.m8506c() != null) {
                        Stub.m8506c().mo8502b();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IPeripheralCallback
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo8500a(DeviceInfo deviceInfo, Message message) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IPeripheralCallback");
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
                    if (!this.f9450b.transact(4, parcelObtain, parcelObtain2, 0) && Stub.m8506c() != null) {
                        Stub.m8506c().mo8500a(deviceInfo, message);
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

            @Override // com.heytap.accessory.api.IPeripheralCallback
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo8503b(DeviceInfo deviceInfo, Message message) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IPeripheralCallback");
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
                    if (!this.f9450b.transact(5, parcelObtain, parcelObtain2, 0) && Stub.m8506c() != null) {
                        Stub.m8506c().mo8503b(deviceInfo, message);
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

            @Override // com.heytap.accessory.api.IPeripheralCallback
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo8499a(DeviceInfo deviceInfo) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IPeripheralCallback");
                    if (deviceInfo != null) {
                        parcelObtain.writeInt(1);
                        deviceInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f9450b.transact(6, parcelObtain, parcelObtain2, 0) && Stub.m8506c() != null) {
                        Stub.m8506c().mo8499a(deviceInfo);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IPeripheralCallback
            /* renamed from: IntrinsicsJvm.kt_3 */
            public void mo8504c(DeviceInfo deviceInfo, Message message) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IPeripheralCallback");
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
                    if (!this.f9450b.transact(7, parcelObtain, parcelObtain2, 0) && Stub.m8506c() != null) {
                        Stub.m8506c().mo8504c(deviceInfo, message);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IPeripheralCallback
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo8501a(Message message) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IPeripheralCallback");
                    if (message != null) {
                        parcelObtain.writeInt(1);
                        message.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f9450b.transact(8, parcelObtain, parcelObtain2, 0) && Stub.m8506c() != null) {
                        Stub.m8506c().mo8501a(message);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public static IPeripheralCallback m8506c() {
            return Proxy.f9449a;
        }
    }
}
