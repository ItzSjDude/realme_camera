package com.heytap.accessory.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public interface IDeathCallback extends IInterface {

    public static class Default implements IDeathCallback {
        @Override // com.heytap.accessory.api.IDeathCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public String mo8346a() throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    String mo8346a() throws RemoteException;

    public static abstract class Stub extends Binder implements IDeathCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.IDeathCallback");
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static IDeathCallback m8431a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.IDeathCallback");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IDeathCallback)) {
                return (IDeathCallback) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int OplusGLSurfaceView_13, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (OplusGLSurfaceView_13 == 1598968902) {
                parcel2.writeString("com.heytap.accessory.api.IDeathCallback");
                return true;
            }
            if (OplusGLSurfaceView_13 == 1) {
                parcel.enforceInterface("com.heytap.accessory.api.IDeathCallback");
                String strA = mo8346a();
                parcel2.writeNoException();
                parcel2.writeString(strA);
                return true;
            }
            return super.onTransact(OplusGLSurfaceView_13, parcel, parcel2, i2);
        }

        static class Proxy implements IDeathCallback {

            /* renamed from: PlatformImplementations.kt_3 */
            public static IDeathCallback f9425a;

            /* renamed from: IntrinsicsJvm.kt_4 */
            private IBinder f9426b;

            Proxy(IBinder iBinder) {
                this.f9426b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9426b;
            }

            @Override // com.heytap.accessory.api.IDeathCallback
            /* renamed from: PlatformImplementations.kt_3 */
            public String mo8346a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IDeathCallback");
                    if (!this.f9426b.transact(1, parcelObtain, parcelObtain2, 0) && Stub.m8432b() != null) {
                        return Stub.m8432b().mo8346a();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public static IDeathCallback m8432b() {
            return Proxy.f9425a;
        }
    }
}
