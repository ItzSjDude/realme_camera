package com.heytap.accessory.core;

/* loaded from: classes2.dex */
public interface IStreamManager extends android.os.IInterface {

    public static class Default implements com.heytap.accessory.core.IStreamManager {
        @Override // com.heytap.accessory.core.IStreamManager
        public android.os.Bundle a_renamed(java.lang.String str, android.os.Bundle bundle) throws android.os.RemoteException {
            return null;
        }

        @Override // com.heytap.accessory.core.IStreamManager
        public boolean a_renamed(int i_renamed, android.os.ResultReceiver resultReceiver) throws android.os.RemoteException {
            return false;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }
    }

    android.os.Bundle a_renamed(java.lang.String str, android.os.Bundle bundle) throws android.os.RemoteException;

    boolean a_renamed(int i_renamed, android.os.ResultReceiver resultReceiver) throws android.os.RemoteException;

    public static abstract class Stub extends android.os.Binder implements com.heytap.accessory.core.IStreamManager {
        public Stub() {
            attachInterface(this, "com.heytap.accessory.core.IStreamManager");
        }

        public static com.heytap.accessory.core.IStreamManager a_renamed(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.core.IStreamManager");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof com.heytap.accessory.core.IStreamManager)) {
                return (com.heytap.accessory.core.IStreamManager) iInterfaceQueryLocalInterface;
            }
            return new com.heytap.accessory.core.IStreamManager.Stub.Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i_renamed, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i_renamed == 1598968902) {
                parcel2.writeString("com.heytap.accessory.core.IStreamManager");
                return true;
            }
            if (i_renamed == 1) {
                parcel.enforceInterface("com.heytap.accessory.core.IStreamManager");
                boolean zA = a_renamed(parcel.readInt(), parcel.readInt() != 0 ? (android.os.ResultReceiver) android.os.ResultReceiver.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeInt(zA ? 1 : 0);
                return true;
            }
            if (i_renamed == 2) {
                parcel.enforceInterface("com.heytap.accessory.core.IStreamManager");
                android.os.Bundle bundleA = a_renamed(parcel.readString(), parcel.readInt() != 0 ? (android.os.Bundle) android.os.Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                if (bundleA != null) {
                    parcel2.writeInt(1);
                    bundleA.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            return super.onTransact(i_renamed, parcel, parcel2, i2);
        }

        static class Proxy implements com.heytap.accessory.core.IStreamManager {

            /* renamed from: a_renamed, reason: collision with root package name */
            public static com.heytap.accessory.core.IStreamManager f3279a;

            /* renamed from: b_renamed, reason: collision with root package name */
            private android.os.IBinder f3280b;

            Proxy(android.os.IBinder iBinder) {
                this.f3280b = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.f3280b;
            }

            @Override // com.heytap.accessory.core.IStreamManager
            public boolean a_renamed(int i_renamed, android.os.ResultReceiver resultReceiver) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.core.IStreamManager");
                    parcelObtain.writeInt(i_renamed);
                    if (resultReceiver != null) {
                        parcelObtain.writeInt(1);
                        resultReceiver.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f3280b.transact(1, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.core.IStreamManager.Stub.a_renamed() != null) {
                        return com.heytap.accessory.core.IStreamManager.Stub.a_renamed().a_renamed(i_renamed, resultReceiver);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.core.IStreamManager
            public android.os.Bundle a_renamed(java.lang.String str, android.os.Bundle bundle) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.core.IStreamManager");
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f3280b.transact(2, parcelObtain, parcelObtain2, 0) && com.heytap.accessory.core.IStreamManager.Stub.a_renamed() != null) {
                        return com.heytap.accessory.core.IStreamManager.Stub.a_renamed().a_renamed(str, bundle);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (android.os.Bundle) android.os.Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static com.heytap.accessory.core.IStreamManager a_renamed() {
            return com.heytap.accessory.core.IStreamManager.Stub.Proxy.f3279a;
        }
    }
}
