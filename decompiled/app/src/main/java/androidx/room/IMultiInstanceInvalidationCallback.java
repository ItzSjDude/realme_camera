package androidx.room;

/* loaded from: classes.dex */
public interface IMultiInstanceInvalidationCallback extends android.os.IInterface {
    void a_renamed(java.lang.String[] strArr) throws android.os.RemoteException;

    public static abstract class Stub extends android.os.Binder implements androidx.room.IMultiInstanceInvalidationCallback {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "androidx.room.IMultiInstanceInvalidationCallback");
        }

        public static androidx.room.IMultiInstanceInvalidationCallback a_renamed(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("androidx.room.IMultiInstanceInvalidationCallback");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof androidx.room.IMultiInstanceInvalidationCallback)) {
                return (androidx.room.IMultiInstanceInvalidationCallback) iInterfaceQueryLocalInterface;
            }
            return new androidx.room.IMultiInstanceInvalidationCallback.Stub.Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i_renamed, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i_renamed == 1) {
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationCallback");
                a_renamed(parcel.createStringArray());
                return true;
            }
            if (i_renamed == 1598968902) {
                parcel2.writeString("androidx.room.IMultiInstanceInvalidationCallback");
                return true;
            }
            return super.onTransact(i_renamed, parcel, parcel2, i2);
        }

        private static class Proxy implements androidx.room.IMultiInstanceInvalidationCallback {

            /* renamed from: a_renamed, reason: collision with root package name */
            private android.os.IBinder f1565a;

            Proxy(android.os.IBinder iBinder) {
                this.f1565a = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.f1565a;
            }

            @Override // androidx.room.IMultiInstanceInvalidationCallback
            public void a_renamed(java.lang.String[] strArr) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationCallback");
                    parcelObtain.writeStringArray(strArr);
                    this.f1565a.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }
    }
}
