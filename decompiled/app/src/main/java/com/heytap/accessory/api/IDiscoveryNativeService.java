package com.heytap.accessory.api;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.heytap.accessory.api.ICentralService;
import com.heytap.accessory.api.IDeathCallback;
import com.heytap.accessory.api.IPeripheralService;
import com.heytap.accessory.api.IServiceConnectionIndicationCallback;
import com.heytap.accessory.api.IWifiP2pService;

/* loaded from: classes2.dex */
public interface IDiscoveryNativeService extends IInterface {

    public static class Default implements IDiscoveryNativeService {
        @Override // com.heytap.accessory.api.IDiscoveryNativeService
        /* renamed from: PlatformImplementations.kt_3 */
        public Bundle mo8446a(int OplusGLSurfaceView_13, String str, IDeathCallback iDeathCallback, int i2, IServiceConnectionIndicationCallback iServiceConnectionIndicationCallback) throws RemoteException {
            return null;
        }

        @Override // com.heytap.accessory.api.IDiscoveryNativeService
        /* renamed from: PlatformImplementations.kt_3 */
        public ICentralService mo8447a() throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.accessory.api.IDiscoveryNativeService
        /* renamed from: IntrinsicsJvm.kt_4 */
        public IPeripheralService mo8448b() throws RemoteException {
            return null;
        }

        @Override // com.heytap.accessory.api.IDiscoveryNativeService
        /* renamed from: IntrinsicsJvm.kt_3 */
        public IWifiP2pService mo8449c() throws RemoteException {
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    Bundle mo8446a(int OplusGLSurfaceView_13, String str, IDeathCallback iDeathCallback, int i2, IServiceConnectionIndicationCallback iServiceConnectionIndicationCallback) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    ICentralService mo8447a() throws RemoteException;

    /* renamed from: IntrinsicsJvm.kt_4 */
    IPeripheralService mo8448b() throws RemoteException;

    /* renamed from: IntrinsicsJvm.kt_3 */
    IWifiP2pService mo8449c() throws RemoteException;

    public static abstract class Stub extends Binder implements IDiscoveryNativeService {
        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.IDiscoveryNativeService");
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static IDiscoveryNativeService m8450a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.IDiscoveryNativeService");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IDiscoveryNativeService)) {
                return (IDiscoveryNativeService) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int OplusGLSurfaceView_13, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (OplusGLSurfaceView_13 == 1598968902) {
                parcel2.writeString("com.heytap.accessory.api.IDiscoveryNativeService");
                return true;
            }
            if (OplusGLSurfaceView_13 == 1) {
                parcel.enforceInterface("com.heytap.accessory.api.IDiscoveryNativeService");
                ICentralService iCentralServiceA = mo8447a();
                parcel2.writeNoException();
                parcel2.writeStrongBinder(iCentralServiceA != null ? iCentralServiceA.asBinder() : null);
                return true;
            }
            if (OplusGLSurfaceView_13 == 2) {
                parcel.enforceInterface("com.heytap.accessory.api.IDiscoveryNativeService");
                IPeripheralService iPeripheralServiceB = mo8448b();
                parcel2.writeNoException();
                parcel2.writeStrongBinder(iPeripheralServiceB != null ? iPeripheralServiceB.asBinder() : null);
                return true;
            }
            if (OplusGLSurfaceView_13 == 3) {
                parcel.enforceInterface("com.heytap.accessory.api.IDiscoveryNativeService");
                IWifiP2pService iWifiP2pServiceC = mo8449c();
                parcel2.writeNoException();
                parcel2.writeStrongBinder(iWifiP2pServiceC != null ? iWifiP2pServiceC.asBinder() : null);
                return true;
            }
            if (OplusGLSurfaceView_13 == 4) {
                parcel.enforceInterface("com.heytap.accessory.api.IDiscoveryNativeService");
                Bundle bundleA = mo8446a(parcel.readInt(), parcel.readString(), IDeathCallback.Stub.m8431a(parcel.readStrongBinder()), parcel.readInt(), IServiceConnectionIndicationCallback.Stub.m8523a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                if (bundleA != null) {
                    parcel2.writeInt(1);
                    bundleA.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            return super.onTransact(OplusGLSurfaceView_13, parcel, parcel2, i2);
        }

        static class Proxy implements IDiscoveryNativeService {

            /* renamed from: PlatformImplementations.kt_3 */
            public static IDiscoveryNativeService f9433a;

            /* renamed from: IntrinsicsJvm.kt_4 */
            private IBinder f9434b;

            Proxy(IBinder iBinder) {
                this.f9434b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9434b;
            }

            @Override // com.heytap.accessory.api.IDiscoveryNativeService
            /* renamed from: PlatformImplementations.kt_3 */
            public ICentralService mo8447a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IDiscoveryNativeService");
                    if (!this.f9434b.transact(1, parcelObtain, parcelObtain2, 0) && Stub.m8451d() != null) {
                        return Stub.m8451d().mo8447a();
                    }
                    parcelObtain2.readException();
                    return ICentralService.Stub.m8429a(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IDiscoveryNativeService
            /* renamed from: IntrinsicsJvm.kt_4 */
            public IPeripheralService mo8448b() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IDiscoveryNativeService");
                    if (!this.f9434b.transact(2, parcelObtain, parcelObtain2, 0) && Stub.m8451d() != null) {
                        return Stub.m8451d().mo8448b();
                    }
                    parcelObtain2.readException();
                    return IPeripheralService.Stub.m8512a(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IDiscoveryNativeService
            /* renamed from: IntrinsicsJvm.kt_3 */
            public IWifiP2pService mo8449c() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IDiscoveryNativeService");
                    if (!this.f9434b.transact(3, parcelObtain, parcelObtain2, 0) && Stub.m8451d() != null) {
                        return Stub.m8451d().mo8449c();
                    }
                    parcelObtain2.readException();
                    return IWifiP2pService.Stub.m8532a(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IDiscoveryNativeService
            /* renamed from: PlatformImplementations.kt_3 */
            public Bundle mo8446a(int OplusGLSurfaceView_13, String str, IDeathCallback iDeathCallback, int i2, IServiceConnectionIndicationCallback iServiceConnectionIndicationCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IDiscoveryNativeService");
                    parcelObtain.writeInt(OplusGLSurfaceView_13);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iDeathCallback != null ? iDeathCallback.asBinder() : null);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeStrongBinder(iServiceConnectionIndicationCallback != null ? iServiceConnectionIndicationCallback.asBinder() : null);
                    if (!this.f9434b.transact(4, parcelObtain, parcelObtain2, 0) && Stub.m8451d() != null) {
                        return Stub.m8451d().mo8446a(OplusGLSurfaceView_13, str, iDeathCallback, i2, iServiceConnectionIndicationCallback);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        public static IDiscoveryNativeService m8451d() {
            return Proxy.f9433a;
        }
    }
}
