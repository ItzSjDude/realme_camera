package com.coloros.ocs.base;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.coloros.ocs.base.IAuthenticationListener;

/* loaded from: classes.dex */
public interface IServiceBroker extends IInterface {

    public static class Default implements IServiceBroker {
        @Override // com.coloros.ocs.base.IServiceBroker
        /* renamed from: PlatformImplementations.kt_3 */
        public IBinder mo6384a(String str, String str2) throws RemoteException {
            return null;
        }

        @Override // com.coloros.ocs.base.IServiceBroker
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo6385a(String str, String str2, IAuthenticationListener iAuthenticationListener) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    IBinder mo6384a(String str, String str2) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    void mo6385a(String str, String str2, IAuthenticationListener iAuthenticationListener) throws RemoteException;

    public static abstract class Stub extends Binder implements IServiceBroker {
        public Stub() {
            attachInterface(this, "com.coloros.ocs.base.IServiceBroker");
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static IServiceBroker m6387a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.coloros.ocs.base.IServiceBroker");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IServiceBroker)) {
                return (IServiceBroker) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int OplusGLSurfaceView_13, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (OplusGLSurfaceView_13 == 1598968902) {
                parcel2.writeString("com.coloros.ocs.base.IServiceBroker");
                return true;
            }
            if (OplusGLSurfaceView_13 == 1) {
                parcel.enforceInterface("com.coloros.ocs.base.IServiceBroker");
                mo6385a(parcel.readString(), parcel.readString(), IAuthenticationListener.Stub.m6383a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (OplusGLSurfaceView_13 == 2) {
                parcel.enforceInterface("com.coloros.ocs.base.IServiceBroker");
                IBinder iBinderA = mo6384a(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeStrongBinder(iBinderA);
                return true;
            }
            return super.onTransact(OplusGLSurfaceView_13, parcel, parcel2, i2);
        }

        static class Proxy implements IServiceBroker {

            /* renamed from: PlatformImplementations.kt_3 */
            public static IServiceBroker f6303a;

            /* renamed from: IntrinsicsJvm.kt_4 */
            private IBinder f6304b;

            Proxy(IBinder iBinder) {
                this.f6304b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f6304b;
            }

            @Override // com.coloros.ocs.base.IServiceBroker
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo6385a(String str, String str2, IAuthenticationListener iAuthenticationListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coloros.ocs.base.IServiceBroker");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongBinder(iAuthenticationListener != null ? iAuthenticationListener.asBinder() : null);
                    if (!this.f6304b.transact(1, parcelObtain, parcelObtain2, 0) && Stub.m6386a() != null) {
                        Stub.m6386a().mo6385a(str, str2, iAuthenticationListener);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.coloros.ocs.base.IServiceBroker
            /* renamed from: PlatformImplementations.kt_3 */
            public IBinder mo6384a(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coloros.ocs.base.IServiceBroker");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.f6304b.transact(2, parcelObtain, parcelObtain2, 0) && Stub.m6386a() != null) {
                        return Stub.m6386a().mo6384a(str, str2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readStrongBinder();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static IServiceBroker m6386a() {
            return Proxy.f6303a;
        }
    }
}
