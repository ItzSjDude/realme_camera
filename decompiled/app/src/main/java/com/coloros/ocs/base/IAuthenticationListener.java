package com.coloros.ocs.base;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.oplus.ocs.base.common.CapabilityInfo;

/* loaded from: classes.dex */
public interface IAuthenticationListener extends IInterface {

    public static class Default implements IAuthenticationListener {
        @Override // com.coloros.ocs.base.IAuthenticationListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo6380a(int OplusGLSurfaceView_13) throws RemoteException {
        }

        @Override // com.coloros.ocs.base.IAuthenticationListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo6381a(CapabilityInfo capabilityInfo) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void mo6380a(int OplusGLSurfaceView_13) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    void mo6381a(CapabilityInfo capabilityInfo) throws RemoteException;

    public static abstract class Stub extends Binder implements IAuthenticationListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.coloros.ocs.base.IAuthenticationListener");
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static IAuthenticationListener m6383a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.coloros.ocs.base.IAuthenticationListener");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IAuthenticationListener)) {
                return (IAuthenticationListener) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int OplusGLSurfaceView_13, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (OplusGLSurfaceView_13 == 1598968902) {
                parcel2.writeString("com.coloros.ocs.base.IAuthenticationListener");
                return true;
            }
            if (OplusGLSurfaceView_13 == 1) {
                parcel.enforceInterface("com.coloros.ocs.base.IAuthenticationListener");
                mo6381a(parcel.readInt() != 0 ? CapabilityInfo.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (OplusGLSurfaceView_13 == 2) {
                parcel.enforceInterface("com.coloros.ocs.base.IAuthenticationListener");
                mo6380a(parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            return super.onTransact(OplusGLSurfaceView_13, parcel, parcel2, i2);
        }

        static class Proxy implements IAuthenticationListener {

            /* renamed from: PlatformImplementations.kt_3 */
            public static IAuthenticationListener f6301a;

            /* renamed from: IntrinsicsJvm.kt_4 */
            private IBinder f6302b;

            Proxy(IBinder iBinder) {
                this.f6302b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f6302b;
            }

            @Override // com.coloros.ocs.base.IAuthenticationListener
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo6381a(CapabilityInfo capabilityInfo) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coloros.ocs.base.IAuthenticationListener");
                    if (capabilityInfo != null) {
                        parcelObtain.writeInt(1);
                        capabilityInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f6302b.transact(1, parcelObtain, parcelObtain2, 0) && Stub.m6382a() != null) {
                        Stub.m6382a().mo6381a(capabilityInfo);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.coloros.ocs.base.IAuthenticationListener
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo6380a(int OplusGLSurfaceView_13) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coloros.ocs.base.IAuthenticationListener");
                    parcelObtain.writeInt(OplusGLSurfaceView_13);
                    if (!this.f6302b.transact(2, parcelObtain, parcelObtain2, 0) && Stub.m6382a() != null) {
                        Stub.m6382a().mo6380a(OplusGLSurfaceView_13);
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
        public static IAuthenticationListener m6382a() {
            return Proxy.f6301a;
        }
    }
}
