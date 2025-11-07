package com.heytap.accessory.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public interface IPermissionCallback extends IInterface {

    public static class Default implements IPermissionCallback {
        @Override // com.heytap.accessory.api.IPermissionCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8514a() throws RemoteException {
        }

        @Override // com.heytap.accessory.api.IPermissionCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8515a(int OplusGLSurfaceView_13) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void mo8514a() throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    void mo8515a(int OplusGLSurfaceView_13) throws RemoteException;

    public static abstract class Stub extends Binder implements IPermissionCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.IPermissionCallback");
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static IPermissionCallback m8516a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.IPermissionCallback");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IPermissionCallback)) {
                return (IPermissionCallback) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int OplusGLSurfaceView_13, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (OplusGLSurfaceView_13 == 1598968902) {
                parcel2.writeString("com.heytap.accessory.api.IPermissionCallback");
                return true;
            }
            if (OplusGLSurfaceView_13 == 1) {
                parcel.enforceInterface("com.heytap.accessory.api.IPermissionCallback");
                mo8514a();
                parcel2.writeNoException();
                return true;
            }
            if (OplusGLSurfaceView_13 == 2) {
                parcel.enforceInterface("com.heytap.accessory.api.IPermissionCallback");
                mo8515a(parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            return super.onTransact(OplusGLSurfaceView_13, parcel, parcel2, i2);
        }

        static class Proxy implements IPermissionCallback {

            /* renamed from: PlatformImplementations.kt_3 */
            public static IPermissionCallback f9453a;

            /* renamed from: IntrinsicsJvm.kt_4 */
            private IBinder f9454b;

            Proxy(IBinder iBinder) {
                this.f9454b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9454b;
            }

            @Override // com.heytap.accessory.api.IPermissionCallback
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo8514a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IPermissionCallback");
                    if (!this.f9454b.transact(1, parcelObtain, parcelObtain2, 0) && Stub.m8517b() != null) {
                        Stub.m8517b().mo8514a();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IPermissionCallback
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo8515a(int OplusGLSurfaceView_13) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IPermissionCallback");
                    parcelObtain.writeInt(OplusGLSurfaceView_13);
                    if (!this.f9454b.transact(2, parcelObtain, parcelObtain2, 0) && Stub.m8517b() != null) {
                        Stub.m8517b().mo8515a(OplusGLSurfaceView_13);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public static IPermissionCallback m8517b() {
            return Proxy.f9453a;
        }
    }
}
