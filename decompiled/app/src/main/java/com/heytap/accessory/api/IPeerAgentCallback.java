package com.heytap.accessory.api;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public interface IPeerAgentCallback extends IInterface {

    public static class Default implements IPeerAgentCallback {
        @Override // com.heytap.accessory.api.IPeerAgentCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8353a(Bundle bundle) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.accessory.api.IPeerAgentCallback
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo8354b(Bundle bundle) throws RemoteException {
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void mo8353a(Bundle bundle) throws RemoteException;

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo8354b(Bundle bundle) throws RemoteException;

    public static abstract class Stub extends Binder implements IPeerAgentCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.IPeerAgentCallback");
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static IPeerAgentCallback m8496a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.IPeerAgentCallback");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IPeerAgentCallback)) {
                return (IPeerAgentCallback) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int OplusGLSurfaceView_13, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (OplusGLSurfaceView_13 == 1598968902) {
                parcel2.writeString("com.heytap.accessory.api.IPeerAgentCallback");
                return true;
            }
            if (OplusGLSurfaceView_13 == 1) {
                parcel.enforceInterface("com.heytap.accessory.api.IPeerAgentCallback");
                mo8353a(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (OplusGLSurfaceView_13 == 2) {
                parcel.enforceInterface("com.heytap.accessory.api.IPeerAgentCallback");
                mo8354b(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            return super.onTransact(OplusGLSurfaceView_13, parcel, parcel2, i2);
        }

        static class Proxy implements IPeerAgentCallback {

            /* renamed from: PlatformImplementations.kt_3 */
            public static IPeerAgentCallback f9447a;

            /* renamed from: IntrinsicsJvm.kt_4 */
            private IBinder f9448b;

            Proxy(IBinder iBinder) {
                this.f9448b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9448b;
            }

            @Override // com.heytap.accessory.api.IPeerAgentCallback
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo8353a(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IPeerAgentCallback");
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f9448b.transact(1, parcelObtain, parcelObtain2, 0) && Stub.m8495a() != null) {
                        Stub.m8495a().mo8353a(bundle);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IPeerAgentCallback
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo8354b(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IPeerAgentCallback");
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f9448b.transact(2, parcelObtain, parcelObtain2, 0) && Stub.m8495a() != null) {
                        Stub.m8495a().mo8354b(bundle);
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
        public static IPeerAgentCallback m8495a() {
            return Proxy.f9447a;
        }
    }
}
