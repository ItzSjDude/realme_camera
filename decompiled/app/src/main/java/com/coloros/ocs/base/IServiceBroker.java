package com.coloros.ocs.base;

/* loaded from: classes.dex */
public interface IServiceBroker extends android.os.IInterface {

    public static class Default implements com.coloros.ocs.base.IServiceBroker {
        @Override // com.coloros.ocs.base.IServiceBroker
        public android.os.IBinder a_renamed(java.lang.String str, java.lang.String str2) throws android.os.RemoteException {
            return null;
        }

        @Override // com.coloros.ocs.base.IServiceBroker
        public void a_renamed(java.lang.String str, java.lang.String str2, com.coloros.ocs.base.IAuthenticationListener iAuthenticationListener) throws android.os.RemoteException {
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }
    }

    android.os.IBinder a_renamed(java.lang.String str, java.lang.String str2) throws android.os.RemoteException;

    void a_renamed(java.lang.String str, java.lang.String str2, com.coloros.ocs.base.IAuthenticationListener iAuthenticationListener) throws android.os.RemoteException;

    public static abstract class Stub extends android.os.Binder implements com.coloros.ocs.base.IServiceBroker {
        public Stub() {
            attachInterface(this, "com.coloros.ocs.base.IServiceBroker");
        }

        public static com.coloros.ocs.base.IServiceBroker a_renamed(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.coloros.ocs.base.IServiceBroker");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof com.coloros.ocs.base.IServiceBroker)) {
                return (com.coloros.ocs.base.IServiceBroker) iInterfaceQueryLocalInterface;
            }
            return new com.coloros.ocs.base.IServiceBroker.Stub.Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i_renamed, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i_renamed == 1598968902) {
                parcel2.writeString("com.coloros.ocs.base.IServiceBroker");
                return true;
            }
            if (i_renamed == 1) {
                parcel.enforceInterface("com.coloros.ocs.base.IServiceBroker");
                a_renamed(parcel.readString(), parcel.readString(), com.coloros.ocs.base.IAuthenticationListener.Stub.a_renamed(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i_renamed == 2) {
                parcel.enforceInterface("com.coloros.ocs.base.IServiceBroker");
                android.os.IBinder iBinderA = a_renamed(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeStrongBinder(iBinderA);
                return true;
            }
            return super.onTransact(i_renamed, parcel, parcel2, i2);
        }

        static class Proxy implements com.coloros.ocs.base.IServiceBroker {

            /* renamed from: a_renamed, reason: collision with root package name */
            public static com.coloros.ocs.base.IServiceBroker f2383a;

            /* renamed from: b_renamed, reason: collision with root package name */
            private android.os.IBinder f2384b;

            Proxy(android.os.IBinder iBinder) {
                this.f2384b = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.f2384b;
            }

            @Override // com.coloros.ocs.base.IServiceBroker
            public void a_renamed(java.lang.String str, java.lang.String str2, com.coloros.ocs.base.IAuthenticationListener iAuthenticationListener) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coloros.ocs.base.IServiceBroker");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongBinder(iAuthenticationListener != null ? iAuthenticationListener.asBinder() : null);
                    if (!this.f2384b.transact(1, parcelObtain, parcelObtain2, 0) && com.coloros.ocs.base.IServiceBroker.Stub.a_renamed() != null) {
                        com.coloros.ocs.base.IServiceBroker.Stub.a_renamed().a_renamed(str, str2, iAuthenticationListener);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.coloros.ocs.base.IServiceBroker
            public android.os.IBinder a_renamed(java.lang.String str, java.lang.String str2) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coloros.ocs.base.IServiceBroker");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.f2384b.transact(2, parcelObtain, parcelObtain2, 0) && com.coloros.ocs.base.IServiceBroker.Stub.a_renamed() != null) {
                        return com.coloros.ocs.base.IServiceBroker.Stub.a_renamed().a_renamed(str, str2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readStrongBinder();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static com.coloros.ocs.base.IServiceBroker a_renamed() {
            return com.coloros.ocs.base.IServiceBroker.Stub.Proxy.f2383a;
        }
    }
}
