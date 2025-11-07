package com.heytap.accessory.core;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.ResultReceiver;

/* loaded from: classes2.dex */
public interface IStreamManager extends IInterface {

    public static class Default implements IStreamManager {
        @Override // com.heytap.accessory.core.IStreamManager
        /* renamed from: PlatformImplementations.kt_3 */
        public Bundle mo8621a(String str, Bundle bundle) throws RemoteException {
            return null;
        }

        @Override // com.heytap.accessory.core.IStreamManager
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo8622a(int OplusGLSurfaceView_13, ResultReceiver resultReceiver) throws RemoteException {
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    Bundle mo8621a(String str, Bundle bundle) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    boolean mo8622a(int OplusGLSurfaceView_13, ResultReceiver resultReceiver) throws RemoteException;

    public static abstract class Stub extends Binder implements IStreamManager {
        public Stub() {
            attachInterface(this, "com.heytap.accessory.core.IStreamManager");
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static IStreamManager m8624a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.core.IStreamManager");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IStreamManager)) {
                return (IStreamManager) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int OplusGLSurfaceView_13, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (OplusGLSurfaceView_13 == 1598968902) {
                parcel2.writeString("com.heytap.accessory.core.IStreamManager");
                return true;
            }
            if (OplusGLSurfaceView_13 == 1) {
                parcel.enforceInterface("com.heytap.accessory.core.IStreamManager");
                boolean zA = mo8622a(parcel.readInt(), parcel.readInt() != 0 ? (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeInt(zA ? 1 : 0);
                return true;
            }
            if (OplusGLSurfaceView_13 == 2) {
                parcel.enforceInterface("com.heytap.accessory.core.IStreamManager");
                Bundle bundleA = mo8621a(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
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

        static class Proxy implements IStreamManager {

            /* renamed from: PlatformImplementations.kt_3 */
            public static IStreamManager f9509a;

            /* renamed from: IntrinsicsJvm.kt_4 */
            private IBinder f9510b;

            Proxy(IBinder iBinder) {
                this.f9510b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9510b;
            }

            @Override // com.heytap.accessory.core.IStreamManager
            /* renamed from: PlatformImplementations.kt_3 */
            public boolean mo8622a(int OplusGLSurfaceView_13, ResultReceiver resultReceiver) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.core.IStreamManager");
                    parcelObtain.writeInt(OplusGLSurfaceView_13);
                    if (resultReceiver != null) {
                        parcelObtain.writeInt(1);
                        resultReceiver.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f9510b.transact(1, parcelObtain, parcelObtain2, 0) && Stub.m8623a() != null) {
                        return Stub.m8623a().mo8622a(OplusGLSurfaceView_13, resultReceiver);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.core.IStreamManager
            /* renamed from: PlatformImplementations.kt_3 */
            public Bundle mo8621a(String str, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.core.IStreamManager");
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f9510b.transact(2, parcelObtain, parcelObtain2, 0) && Stub.m8623a() != null) {
                        return Stub.m8623a().mo8621a(str, bundle);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static IStreamManager m8623a() {
            return Proxy.f9509a;
        }
    }
}
