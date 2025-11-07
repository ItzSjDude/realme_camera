package com.heytap.accessory.api;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.heytap.accessory.api.ICMDeathCallback;

/* loaded from: classes2.dex */
public interface IGenFrameworkManager extends IInterface {

    public static class Default implements IGenFrameworkManager {
        @Override // com.heytap.accessory.api.IGenFrameworkManager
        /* renamed from: PlatformImplementations.kt_3 */
        public Bundle mo8480a(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, Bundle bundle) throws RemoteException {
            return null;
        }

        @Override // com.heytap.accessory.api.IGenFrameworkManager
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8481a(long OplusGLSurfaceView_15, ICMDeathCallback iCMDeathCallback) throws RemoteException {
        }

        @Override // com.heytap.accessory.api.IGenFrameworkManager
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo8482a(int OplusGLSurfaceView_13, String str) throws RemoteException {
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    Bundle mo8480a(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, Bundle bundle) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    void mo8481a(long OplusGLSurfaceView_15, ICMDeathCallback iCMDeathCallback) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    boolean mo8482a(int OplusGLSurfaceView_13, String str) throws RemoteException;

    public static abstract class Stub extends Binder implements IGenFrameworkManager {
        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.IGenFrameworkManager");
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static IGenFrameworkManager m8484a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.IGenFrameworkManager");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IGenFrameworkManager)) {
                return (IGenFrameworkManager) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int OplusGLSurfaceView_13, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (OplusGLSurfaceView_13 == 1598968902) {
                parcel2.writeString("com.heytap.accessory.api.IGenFrameworkManager");
                return true;
            }
            if (OplusGLSurfaceView_13 == 1) {
                parcel.enforceInterface("com.heytap.accessory.api.IGenFrameworkManager");
                mo8481a(parcel.readLong(), ICMDeathCallback.Stub.m8415a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (OplusGLSurfaceView_13 != 2) {
                if (OplusGLSurfaceView_13 == 3) {
                    parcel.enforceInterface("com.heytap.accessory.api.IGenFrameworkManager");
                    boolean zA = mo8482a(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zA ? 1 : 0);
                    return true;
                }
                return super.onTransact(OplusGLSurfaceView_13, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.heytap.accessory.api.IGenFrameworkManager");
            Bundle bundleA = mo8480a(parcel.readLong(), parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            if (bundleA != null) {
                parcel2.writeInt(1);
                bundleA.writeToParcel(parcel2, 1);
            } else {
                parcel2.writeInt(0);
            }
            return true;
        }

        static class Proxy implements IGenFrameworkManager {

            /* renamed from: PlatformImplementations.kt_3 */
            public static IGenFrameworkManager f9437a;

            /* renamed from: IntrinsicsJvm.kt_4 */
            private IBinder f9438b;

            Proxy(IBinder iBinder) {
                this.f9438b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9438b;
            }

            @Override // com.heytap.accessory.api.IGenFrameworkManager
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo8481a(long OplusGLSurfaceView_15, ICMDeathCallback iCMDeathCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IGenFrameworkManager");
                    parcelObtain.writeLong(OplusGLSurfaceView_15);
                    parcelObtain.writeStrongBinder(iCMDeathCallback != null ? iCMDeathCallback.asBinder() : null);
                    if (!this.f9438b.transact(1, parcelObtain, parcelObtain2, 0) && Stub.m8483a() != null) {
                        Stub.m8483a().mo8481a(OplusGLSurfaceView_15, iCMDeathCallback);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IGenFrameworkManager
            /* renamed from: PlatformImplementations.kt_3 */
            public Bundle mo8480a(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IGenFrameworkManager");
                    parcelObtain.writeLong(OplusGLSurfaceView_15);
                    parcelObtain.writeInt(OplusGLSurfaceView_13);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f9438b.transact(2, parcelObtain, parcelObtain2, 0) && Stub.m8483a() != null) {
                        return Stub.m8483a().mo8480a(OplusGLSurfaceView_15, OplusGLSurfaceView_13, bundle);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IGenFrameworkManager
            /* renamed from: PlatformImplementations.kt_3 */
            public boolean mo8482a(int OplusGLSurfaceView_13, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IGenFrameworkManager");
                    parcelObtain.writeInt(OplusGLSurfaceView_13);
                    parcelObtain.writeString(str);
                    if (!this.f9438b.transact(3, parcelObtain, parcelObtain2, 0) && Stub.m8483a() != null) {
                        return Stub.m8483a().mo8482a(OplusGLSurfaceView_13, str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static IGenFrameworkManager m8483a() {
            return Proxy.f9437a;
        }
    }
}
