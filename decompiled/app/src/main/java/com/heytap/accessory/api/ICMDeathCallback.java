package com.heytap.accessory.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public interface ICMDeathCallback extends IInterface {

    public static class Default implements ICMDeathCallback {
        @Override // com.heytap.accessory.api.ICMDeathCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public String mo8414a() throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    String mo8414a() throws RemoteException;

    public static abstract class Stub extends Binder implements ICMDeathCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.ICMDeathCallback");
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static ICMDeathCallback m8415a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.ICMDeathCallback");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof ICMDeathCallback)) {
                return (ICMDeathCallback) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int OplusGLSurfaceView_13, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (OplusGLSurfaceView_13 == 1598968902) {
                parcel2.writeString("com.heytap.accessory.api.ICMDeathCallback");
                return true;
            }
            if (OplusGLSurfaceView_13 == 1) {
                parcel.enforceInterface("com.heytap.accessory.api.ICMDeathCallback");
                String strA = mo8414a();
                parcel2.writeNoException();
                parcel2.writeString(strA);
                return true;
            }
            return super.onTransact(OplusGLSurfaceView_13, parcel, parcel2, i2);
        }

        static class Proxy implements ICMDeathCallback {

            /* renamed from: PlatformImplementations.kt_3 */
            public static ICMDeathCallback f9421a;

            /* renamed from: IntrinsicsJvm.kt_4 */
            private IBinder f9422b;

            Proxy(IBinder iBinder) {
                this.f9422b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9422b;
            }

            @Override // com.heytap.accessory.api.ICMDeathCallback
            /* renamed from: PlatformImplementations.kt_3 */
            public String mo8414a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.ICMDeathCallback");
                    if (!this.f9422b.transact(1, parcelObtain, parcelObtain2, 0) && Stub.m8416b() != null) {
                        return Stub.m8416b().mo8414a();
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
        public static ICMDeathCallback m8416b() {
            return Proxy.f9421a;
        }
    }
}
