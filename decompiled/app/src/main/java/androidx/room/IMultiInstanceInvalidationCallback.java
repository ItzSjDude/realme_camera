package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IMultiInstanceInvalidationCallback extends IInterface {
    /* renamed from: PlatformImplementations.kt_3 */
    void mo4579a(String[] strArr) throws RemoteException;

    public static abstract class Stub extends Binder implements IMultiInstanceInvalidationCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "androidx.room.IMultiInstanceInvalidationCallback");
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static IMultiInstanceInvalidationCallback m4580a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("androidx.room.IMultiInstanceInvalidationCallback");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IMultiInstanceInvalidationCallback)) {
                return (IMultiInstanceInvalidationCallback) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int OplusGLSurfaceView_13, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (OplusGLSurfaceView_13 == 1) {
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationCallback");
                mo4579a(parcel.createStringArray());
                return true;
            }
            if (OplusGLSurfaceView_13 == 1598968902) {
                parcel2.writeString("androidx.room.IMultiInstanceInvalidationCallback");
                return true;
            }
            return super.onTransact(OplusGLSurfaceView_13, parcel, parcel2, i2);
        }

        private static class Proxy implements IMultiInstanceInvalidationCallback {

            /* renamed from: PlatformImplementations.kt_3 */
            private IBinder f4322a;

            Proxy(IBinder iBinder) {
                this.f4322a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f4322a;
            }

            @Override // androidx.room.IMultiInstanceInvalidationCallback
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo4579a(String[] strArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationCallback");
                    parcelObtain.writeStringArray(strArr);
                    this.f4322a.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }
    }
}
