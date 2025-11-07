package com.heytap.accessory.core;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.ResultReceiver;
import com.heytap.accessory.api.IDeathCallback;

/* loaded from: classes2.dex */
public interface IFileManager extends IInterface {

    public static class Default implements IFileManager {
        @Override // com.heytap.accessory.core.IFileManager
        /* renamed from: PlatformImplementations.kt_3 */
        public Bundle mo8615a(String str) throws RemoteException {
            return null;
        }

        @Override // com.heytap.accessory.core.IFileManager
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo8616a(int OplusGLSurfaceView_13, ResultReceiver resultReceiver) throws RemoteException {
            return false;
        }

        @Override // com.heytap.accessory.core.IFileManager
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo8617a(int OplusGLSurfaceView_13, String str) throws RemoteException {
            return false;
        }

        @Override // com.heytap.accessory.core.IFileManager
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo8618a(IDeathCallback iDeathCallback, long OplusGLSurfaceView_15, long j2) throws RemoteException {
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    Bundle mo8615a(String str) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    boolean mo8616a(int OplusGLSurfaceView_13, ResultReceiver resultReceiver) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    boolean mo8617a(int OplusGLSurfaceView_13, String str) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    boolean mo8618a(IDeathCallback iDeathCallback, long OplusGLSurfaceView_15, long j2) throws RemoteException;

    public static abstract class Stub extends Binder implements IFileManager {
        public Stub() {
            attachInterface(this, "com.heytap.accessory.core.IFileManager");
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static IFileManager m8620a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.core.IFileManager");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IFileManager)) {
                return (IFileManager) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int OplusGLSurfaceView_13, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (OplusGLSurfaceView_13 == 1598968902) {
                parcel2.writeString("com.heytap.accessory.core.IFileManager");
                return true;
            }
            if (OplusGLSurfaceView_13 == 1) {
                parcel.enforceInterface("com.heytap.accessory.core.IFileManager");
                boolean zA = mo8616a(parcel.readInt(), parcel.readInt() != 0 ? (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeInt(zA ? 1 : 0);
                return true;
            }
            if (OplusGLSurfaceView_13 == 2) {
                parcel.enforceInterface("com.heytap.accessory.core.IFileManager");
                Bundle bundleA = mo8615a(parcel.readString());
                parcel2.writeNoException();
                if (bundleA != null) {
                    parcel2.writeInt(1);
                    bundleA.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            if (OplusGLSurfaceView_13 == 3) {
                parcel.enforceInterface("com.heytap.accessory.core.IFileManager");
                boolean zA2 = mo8617a(parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(zA2 ? 1 : 0);
                return true;
            }
            if (OplusGLSurfaceView_13 == 4) {
                parcel.enforceInterface("com.heytap.accessory.core.IFileManager");
                boolean zA3 = mo8618a(IDeathCallback.Stub.m8431a(parcel.readStrongBinder()), parcel.readLong(), parcel.readLong());
                parcel2.writeNoException();
                parcel2.writeInt(zA3 ? 1 : 0);
                return true;
            }
            return super.onTransact(OplusGLSurfaceView_13, parcel, parcel2, i2);
        }

        static class Proxy implements IFileManager {

            /* renamed from: PlatformImplementations.kt_3 */
            public static IFileManager f9507a;

            /* renamed from: IntrinsicsJvm.kt_4 */
            private IBinder f9508b;

            Proxy(IBinder iBinder) {
                this.f9508b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9508b;
            }

            @Override // com.heytap.accessory.core.IFileManager
            /* renamed from: PlatformImplementations.kt_3 */
            public boolean mo8616a(int OplusGLSurfaceView_13, ResultReceiver resultReceiver) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.core.IFileManager");
                    parcelObtain.writeInt(OplusGLSurfaceView_13);
                    if (resultReceiver != null) {
                        parcelObtain.writeInt(1);
                        resultReceiver.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f9508b.transact(1, parcelObtain, parcelObtain2, 0) && Stub.m8619a() != null) {
                        return Stub.m8619a().mo8616a(OplusGLSurfaceView_13, resultReceiver);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.core.IFileManager
            /* renamed from: PlatformImplementations.kt_3 */
            public Bundle mo8615a(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.core.IFileManager");
                    parcelObtain.writeString(str);
                    if (!this.f9508b.transact(2, parcelObtain, parcelObtain2, 0) && Stub.m8619a() != null) {
                        return Stub.m8619a().mo8615a(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.core.IFileManager
            /* renamed from: PlatformImplementations.kt_3 */
            public boolean mo8617a(int OplusGLSurfaceView_13, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.core.IFileManager");
                    parcelObtain.writeInt(OplusGLSurfaceView_13);
                    parcelObtain.writeString(str);
                    if (!this.f9508b.transact(3, parcelObtain, parcelObtain2, 0) && Stub.m8619a() != null) {
                        return Stub.m8619a().mo8617a(OplusGLSurfaceView_13, str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.core.IFileManager
            /* renamed from: PlatformImplementations.kt_3 */
            public boolean mo8618a(IDeathCallback iDeathCallback, long OplusGLSurfaceView_15, long j2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.core.IFileManager");
                    parcelObtain.writeStrongBinder(iDeathCallback != null ? iDeathCallback.asBinder() : null);
                    parcelObtain.writeLong(OplusGLSurfaceView_15);
                    parcelObtain.writeLong(j2);
                    if (!this.f9508b.transact(4, parcelObtain, parcelObtain2, 0) && Stub.m8619a() != null) {
                        return Stub.m8619a().mo8618a(iDeathCallback, OplusGLSurfaceView_15, j2);
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
        public static IFileManager m8619a() {
            return Proxy.f9507a;
        }
    }
}
