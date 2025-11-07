package com.heytap.accessory.api;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public interface IServiceConnectionIndicationCallback extends IInterface {

    public static class Default implements IServiceConnectionIndicationCallback {
        @Override // com.heytap.accessory.api.IServiceConnectionIndicationCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8348a(Bundle bundle) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void mo8348a(Bundle bundle) throws RemoteException;

    public static abstract class Stub extends Binder implements IServiceConnectionIndicationCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.IServiceConnectionIndicationCallback");
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static IServiceConnectionIndicationCallback m8523a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.IServiceConnectionIndicationCallback");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IServiceConnectionIndicationCallback)) {
                return (IServiceConnectionIndicationCallback) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int OplusGLSurfaceView_13, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (OplusGLSurfaceView_13 == 1598968902) {
                parcel2.writeString("com.heytap.accessory.api.IServiceConnectionIndicationCallback");
                return true;
            }
            if (OplusGLSurfaceView_13 == 1) {
                parcel.enforceInterface("com.heytap.accessory.api.IServiceConnectionIndicationCallback");
                mo8348a(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            return super.onTransact(OplusGLSurfaceView_13, parcel, parcel2, i2);
        }

        static class Proxy implements IServiceConnectionIndicationCallback {

            /* renamed from: PlatformImplementations.kt_3 */
            public static IServiceConnectionIndicationCallback f9459a;

            /* renamed from: IntrinsicsJvm.kt_4 */
            private IBinder f9460b;

            Proxy(IBinder iBinder) {
                this.f9460b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9460b;
            }

            @Override // com.heytap.accessory.api.IServiceConnectionIndicationCallback
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo8348a(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IServiceConnectionIndicationCallback");
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f9460b.transact(1, parcelObtain, parcelObtain2, 0) && Stub.m8522a() != null) {
                        Stub.m8522a().mo8348a(bundle);
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
        public static IServiceConnectionIndicationCallback m8522a() {
            return Proxy.f9459a;
        }
    }
}
