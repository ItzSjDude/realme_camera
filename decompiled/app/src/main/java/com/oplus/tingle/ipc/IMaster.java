package com.oplus.tingle.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public interface IMaster extends IInterface {

    public static class Default implements IMaster {
        @Override // com.oplus.tingle.ipc.IMaster
        /* renamed from: PlatformImplementations.kt_3 */
        public int mo25468a() throws RemoteException {
            return 0;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    int mo25468a() throws RemoteException;

    public static abstract class Stub extends Binder implements IMaster {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.oplus.tingle.ipc.IMaster");
        }

        @Override // android.os.Binder
        public boolean onTransact(int OplusGLSurfaceView_13, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (OplusGLSurfaceView_13 == 1598968902) {
                parcel2.writeString("com.oplus.tingle.ipc.IMaster");
                return true;
            }
            if (OplusGLSurfaceView_13 == 4) {
                parcel.enforceInterface("com.oplus.tingle.ipc.IMaster");
                int iA = mo25468a();
                parcel2.writeNoException();
                parcel2.writeInt(iA);
                return true;
            }
            return super.onTransact(OplusGLSurfaceView_13, parcel, parcel2, i2);
        }

        private static class Proxy implements IMaster {

            /* renamed from: PlatformImplementations.kt_3 */
            public static IMaster f24132a;

            /* renamed from: IntrinsicsJvm.kt_4 */
            private IBinder f24133b;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f24133b;
            }

            @Override // com.oplus.tingle.ipc.IMaster
            /* renamed from: PlatformImplementations.kt_3 */
            public int mo25468a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.oplus.tingle.ipc.IMaster");
                    if (!this.f24133b.transact(4, parcelObtain, parcelObtain2, 0) && Stub.m25469b() != null) {
                        return Stub.m25469b().mo25468a();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public static IMaster m25469b() {
            return Proxy.f24132a;
        }
    }
}
