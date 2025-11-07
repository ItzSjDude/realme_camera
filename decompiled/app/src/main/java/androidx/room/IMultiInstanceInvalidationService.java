package androidx.room;

/* loaded from: classes.dex */
public interface IMultiInstanceInvalidationService extends android.os.IInterface {
    int a_renamed(androidx.room.IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, java.lang.String str) throws android.os.RemoteException;

    void a_renamed(int i_renamed, java.lang.String[] strArr) throws android.os.RemoteException;

    void a_renamed(androidx.room.IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, int i_renamed) throws android.os.RemoteException;

    public static abstract class Stub extends android.os.Binder implements androidx.room.IMultiInstanceInvalidationService {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "androidx.room.IMultiInstanceInvalidationService");
        }

        public static androidx.room.IMultiInstanceInvalidationService a_renamed(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("androidx.room.IMultiInstanceInvalidationService");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof androidx.room.IMultiInstanceInvalidationService)) {
                return (androidx.room.IMultiInstanceInvalidationService) iInterfaceQueryLocalInterface;
            }
            return new androidx.room.IMultiInstanceInvalidationService.Stub.Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i_renamed, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i_renamed == 1) {
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
                int iA = a_renamed(androidx.room.IMultiInstanceInvalidationCallback.Stub.a_renamed(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(iA);
                return true;
            }
            if (i_renamed == 2) {
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
                a_renamed(androidx.room.IMultiInstanceInvalidationCallback.Stub.a_renamed(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            if (i_renamed == 3) {
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
                a_renamed(parcel.readInt(), parcel.createStringArray());
                return true;
            }
            if (i_renamed == 1598968902) {
                parcel2.writeString("androidx.room.IMultiInstanceInvalidationService");
                return true;
            }
            return super.onTransact(i_renamed, parcel, parcel2, i2);
        }

        private static class Proxy implements androidx.room.IMultiInstanceInvalidationService {

            /* renamed from: a_renamed, reason: collision with root package name */
            private android.os.IBinder f1566a;

            Proxy(android.os.IBinder iBinder) {
                this.f1566a = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.f1566a;
            }

            @Override // androidx.room.IMultiInstanceInvalidationService
            public int a_renamed(androidx.room.IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
                    parcelObtain.writeStrongBinder(iMultiInstanceInvalidationCallback != null ? iMultiInstanceInvalidationCallback.asBinder() : null);
                    parcelObtain.writeString(str);
                    this.f1566a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.room.IMultiInstanceInvalidationService
            public void a_renamed(androidx.room.IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, int i_renamed) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
                    parcelObtain.writeStrongBinder(iMultiInstanceInvalidationCallback != null ? iMultiInstanceInvalidationCallback.asBinder() : null);
                    parcelObtain.writeInt(i_renamed);
                    this.f1566a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.room.IMultiInstanceInvalidationService
            public void a_renamed(int i_renamed, java.lang.String[] strArr) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
                    parcelObtain.writeInt(i_renamed);
                    parcelObtain.writeStringArray(strArr);
                    this.f1566a.transact(3, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }
    }
}
