package com.oplus.ocs.base;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.oplus.ocs.base.IAuthenticationListener;

/* loaded from: classes2.dex */
public interface IServiceBroker extends IInterface {

    public static class Default implements IServiceBroker {
        @Override // com.oplus.ocs.base.IServiceBroker
        /* renamed from: PlatformImplementations.kt_3 */
        public IBinder mo25012a(String str, String str2) throws RemoteException {
            return null;
        }

        @Override // com.oplus.ocs.base.IServiceBroker
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo25013a(String str, String str2, IAuthenticationListener iAuthenticationListener) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    IBinder mo25012a(String str, String str2) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    void mo25013a(String str, String str2, IAuthenticationListener iAuthenticationListener) throws RemoteException;

    public static abstract class Stub extends Binder implements IServiceBroker {
        public Stub() {
            attachInterface(this, "com.oplus.ocs.base.IServiceBroker");
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static IServiceBroker m25015a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.oplus.ocs.base.IServiceBroker");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IServiceBroker)) {
                return (IServiceBroker) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int OplusGLSurfaceView_13, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (OplusGLSurfaceView_13 == 1598968902) {
                parcel2.writeString("com.oplus.ocs.base.IServiceBroker");
                return true;
            }
            if (OplusGLSurfaceView_13 == 1) {
                parcel.enforceInterface("com.oplus.ocs.base.IServiceBroker");
                mo25013a(parcel.readString(), parcel.readString(), IAuthenticationListener.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (OplusGLSurfaceView_13 == 2) {
                parcel.enforceInterface("com.oplus.ocs.base.IServiceBroker");
                IBinder iBinderA = mo25012a(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeStrongBinder(iBinderA);
                return true;
            }
            return super.onTransact(OplusGLSurfaceView_13, parcel, parcel2, i2);
        }

        static class Proxy implements IServiceBroker {

            /* renamed from: PlatformImplementations.kt_3 */
            public static IServiceBroker f23378a;

            /* renamed from: IntrinsicsJvm.kt_4 */
            private IBinder f23379b;

            Proxy(IBinder iBinder) {
                this.f23379b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f23379b;
            }

            @Override // com.oplus.ocs.base.IServiceBroker
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo25013a(String str, String str2, IAuthenticationListener iAuthenticationListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.oplus.ocs.base.IServiceBroker");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongBinder(iAuthenticationListener != null ? iAuthenticationListener.asBinder() : null);
                    if (!this.f23379b.transact(1, parcelObtain, parcelObtain2, 0) && Stub.m25014a() != null) {
                        Stub.m25014a().mo25013a(str, str2, iAuthenticationListener);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplus.ocs.base.IServiceBroker
            /* renamed from: PlatformImplementations.kt_3 */
            public IBinder mo25012a(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.oplus.ocs.base.IServiceBroker");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.f23379b.transact(2, parcelObtain, parcelObtain2, 0) && Stub.m25014a() != null) {
                        return Stub.m25014a().mo25012a(str, str2);
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
        public static IServiceBroker m25014a() {
            return Proxy.f23378a;
        }
    }
}
