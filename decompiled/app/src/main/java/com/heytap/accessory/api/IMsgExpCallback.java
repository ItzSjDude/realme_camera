package com.heytap.accessory.api;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public interface IMsgExpCallback extends IInterface {

    public static class Default implements IMsgExpCallback {
        @Override // com.heytap.accessory.api.IMsgExpCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8360a(Bundle bundle) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.accessory.api.IMsgExpCallback
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo8361b(Bundle bundle) throws RemoteException {
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void mo8360a(Bundle bundle) throws RemoteException;

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo8361b(Bundle bundle) throws RemoteException;

    public static abstract class Stub extends Binder implements IMsgExpCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.IMsgExpCallback");
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static IMsgExpCallback m8489a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.IMsgExpCallback");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IMsgExpCallback)) {
                return (IMsgExpCallback) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int OplusGLSurfaceView_13, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (OplusGLSurfaceView_13 == 1598968902) {
                parcel2.writeString("com.heytap.accessory.api.IMsgExpCallback");
                return true;
            }
            if (OplusGLSurfaceView_13 == 1) {
                parcel.enforceInterface("com.heytap.accessory.api.IMsgExpCallback");
                mo8360a(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (OplusGLSurfaceView_13 == 2) {
                parcel.enforceInterface("com.heytap.accessory.api.IMsgExpCallback");
                mo8361b(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            return super.onTransact(OplusGLSurfaceView_13, parcel, parcel2, i2);
        }

        static class Proxy implements IMsgExpCallback {

            /* renamed from: PlatformImplementations.kt_3 */
            public static IMsgExpCallback f9441a;

            /* renamed from: IntrinsicsJvm.kt_4 */
            private IBinder f9442b;

            Proxy(IBinder iBinder) {
                this.f9442b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9442b;
            }

            @Override // com.heytap.accessory.api.IMsgExpCallback
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo8360a(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IMsgExpCallback");
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f9442b.transact(1, parcelObtain, parcelObtain2, 0) && Stub.m8488a() != null) {
                        Stub.m8488a().mo8360a(bundle);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IMsgExpCallback
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo8361b(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IMsgExpCallback");
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f9442b.transact(2, parcelObtain, parcelObtain2, 0) && Stub.m8488a() != null) {
                        Stub.m8488a().mo8361b(bundle);
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
        public static IMsgExpCallback m8488a() {
            return Proxy.f9441a;
        }
    }
}
