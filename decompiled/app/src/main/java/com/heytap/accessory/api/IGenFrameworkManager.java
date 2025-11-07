package com.heytap.accessory.api;

/* loaded from: classes2.dex */
public interface IGenFrameworkManager extends android.os.IInterface {

    public static class Default implements com.heytap.accessory.api.IGenFrameworkManager {
        @Override // com.heytap.accessory.api.IGenFrameworkManager
        public android.os.Bundle a_renamed(long j_renamed, int i_renamed, android.os.Bundle bundle) throws android.os.RemoteException {
            return null;
        }

        @Override // com.heytap.accessory.api.IGenFrameworkManager
        public void a_renamed(long j_renamed, com.heytap.accessory.api.ICMDeathCallback iCMDeathCallback) throws android.os.RemoteException {
        }

        @Override // com.heytap.accessory.api.IGenFrameworkManager
        public boolean a_renamed(int i_renamed, java.lang.String str) throws android.os.RemoteException {
            return false;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }
    }

    android.os.Bundle a_renamed(long j_renamed, int i_renamed, android.os.Bundle bundle) throws android.os.RemoteException;

    void a_renamed(long j_renamed, com.heytap.accessory.api.ICMDeathCallback iCMDeathCallback) throws android.os.RemoteException;

    boolean a_renamed(int i_renamed, java.lang.String str) throws android.os.RemoteException;

    public static abstract class Stub extends android.os.Binder implements com.heytap.accessory.api.IGenFrameworkManager {
        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.IGenFrameworkManager");
        }

        public static com.heytap.accessory.api.IGenFrameworkManager a_renamed(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.IGenFrameworkManager");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof com.heytap.accessory.api.IGenFrameworkManager)) {
                return (com.heytap.accessory.api.IGenFrameworkManager) iInterfaceQueryLocalInterface;
            }
            return new com.heytap.accessory.api.IGenFrameworkManager.Stub.Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i_renamed, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i_renamed == 1598968902) {
                parcel2.writeString("com.heytap.accessory.api.IGenFrameworkManager");
                return true;
            }
            if (i_renamed == 1) {
                parcel.enforceInterface("com.heytap.accessory.api.IGenFrameworkManager");
                a_renamed(parcel.readLong(), com.heytap.accessory.api.ICMDeathCallback.Stub.a_renamed(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i_renamed != 2) {
                if (i_renamed == 3) {
                    parcel.enforceInterface("com.heytap.accessory.api.IGenFrameworkManager");
                    boolean zA = a_renamed(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zA ? 1 : 0);
                    return true;
                }
                return super.onTransact(i_renamed, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.heytap.accessory.api.IGenFrameworkManager");
            android.os.Bundle bundleA = a_renamed(parcel.readLong(), parcel.readInt(), parcel.readInt() != 0 ? (android.os.Bundle) android.os.Bundle.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            if (bundleA != null) {
                parcel2.writeInt(1);
                bundleA.writeToParcel(parcel2, 1);
            } else {
                parcel2.writeInt(0);
            }
            return true;
        }

        static class Proxy implements com.heytap.accessory.api.IGenFrameworkManager {

            /* renamed from: a_renamed, reason: collision with root package name */
            public static com.heytap.accessory.api.IGenFrameworkManager f3225a;

            /* renamed from: b_renamed, reason: collision with root package name */
            private android.os.IBinder f3226b;

            Proxy(android.os.IBinder iBinder) {
                this.f3226b = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.f3226b;
            }

            @Override // com.heytap.accessory.api.IGenFrameworkManager
            public void a_renamed(long j_renamed, com.heytap.accessory.api.ICMDeathCallback iCMDeathCallback) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IGenFrameworkManager");
                    parcelObtain.writeLong(j_renamed);
                    parcelObtain.writeStrongBinder(iCMDeathCallback != null ? iCMDeathCallback.asBinder() : null);
                    if (!this.f3226b.transact(1, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.IGenFrameworkManager.Stub.a_renamed() != null) {
                        com.heytap.accessory.api.IGenFrameworkManager.Stub.a_renamed().a_renamed(j_renamed, iCMDeathCallback);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IGenFrameworkManager
            public android.os.Bundle a_renamed(long j_renamed, int i_renamed, android.os.Bundle bundle) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IGenFrameworkManager");
                    parcelObtain.writeLong(j_renamed);
                    parcelObtain.writeInt(i_renamed);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f3226b.transact(2, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.IGenFrameworkManager.Stub.a_renamed() != null) {
                        return com.heytap.accessory.api.IGenFrameworkManager.Stub.a_renamed().a_renamed(j_renamed, i_renamed, bundle);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (android.os.Bundle) android.os.Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IGenFrameworkManager
            public boolean a_renamed(int i_renamed, java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IGenFrameworkManager");
                    parcelObtain.writeInt(i_renamed);
                    parcelObtain.writeString(str);
                    if (!this.f3226b.transact(3, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.api.IGenFrameworkManager.Stub.a_renamed() != null) {
                        return com.heytap.accessory.api.IGenFrameworkManager.Stub.a_renamed().a_renamed(i_renamed, str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static com.heytap.accessory.api.IGenFrameworkManager a_renamed() {
            return com.heytap.accessory.api.IGenFrameworkManager.Stub.Proxy.f3225a;
        }
    }
}
