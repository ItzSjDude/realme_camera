package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.room.IMultiInstanceInvalidationCallback;

/* loaded from: classes.dex */
public interface IMultiInstanceInvalidationService extends IInterface {
    /* renamed from: PlatformImplementations.kt_3 */
    int mo4581a(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, String str) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    void mo4582a(int OplusGLSurfaceView_13, String[] strArr) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    void mo4583a(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, int OplusGLSurfaceView_13) throws RemoteException;

    public static abstract class Stub extends Binder implements IMultiInstanceInvalidationService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "androidx.room.IMultiInstanceInvalidationService");
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static IMultiInstanceInvalidationService m4584a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("androidx.room.IMultiInstanceInvalidationService");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IMultiInstanceInvalidationService)) {
                return (IMultiInstanceInvalidationService) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int OplusGLSurfaceView_13, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (OplusGLSurfaceView_13 == 1) {
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
                int iA = mo4581a(IMultiInstanceInvalidationCallback.Stub.m4580a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(iA);
                return true;
            }
            if (OplusGLSurfaceView_13 == 2) {
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
                mo4583a(IMultiInstanceInvalidationCallback.Stub.m4580a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            if (OplusGLSurfaceView_13 == 3) {
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
                mo4582a(parcel.readInt(), parcel.createStringArray());
                return true;
            }
            if (OplusGLSurfaceView_13 == 1598968902) {
                parcel2.writeString("androidx.room.IMultiInstanceInvalidationService");
                return true;
            }
            return super.onTransact(OplusGLSurfaceView_13, parcel, parcel2, i2);
        }

        private static class Proxy implements IMultiInstanceInvalidationService {

            /* renamed from: PlatformImplementations.kt_3 */
            private IBinder f4323a;

            Proxy(IBinder iBinder) {
                this.f4323a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f4323a;
            }

            @Override // androidx.room.IMultiInstanceInvalidationService
            /* renamed from: PlatformImplementations.kt_3 */
            public int mo4581a(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
                    parcelObtain.writeStrongBinder(iMultiInstanceInvalidationCallback != null ? iMultiInstanceInvalidationCallback.asBinder() : null);
                    parcelObtain.writeString(str);
                    this.f4323a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.room.IMultiInstanceInvalidationService
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo4583a(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, int OplusGLSurfaceView_13) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
                    parcelObtain.writeStrongBinder(iMultiInstanceInvalidationCallback != null ? iMultiInstanceInvalidationCallback.asBinder() : null);
                    parcelObtain.writeInt(OplusGLSurfaceView_13);
                    this.f4323a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.room.IMultiInstanceInvalidationService
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo4582a(int OplusGLSurfaceView_13, String[] strArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
                    parcelObtain.writeInt(OplusGLSurfaceView_13);
                    parcelObtain.writeStringArray(strArr);
                    this.f4323a.transact(3, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }
    }
}
