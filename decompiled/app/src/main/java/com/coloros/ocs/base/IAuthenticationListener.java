package com.coloros.ocs.base;

/* loaded from: classes.dex */
public interface IAuthenticationListener extends android.os.IInterface {

    public static class Default implements com.coloros.ocs.base.IAuthenticationListener {
        @Override // com.coloros.ocs.base.IAuthenticationListener
        public void a_renamed(int i_renamed) throws android.os.RemoteException {
        }

        @Override // com.coloros.ocs.base.IAuthenticationListener
        public void a_renamed(com.oplus.ocs.base.common.CapabilityInfo capabilityInfo) throws android.os.RemoteException {
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }
    }

    void a_renamed(int i_renamed) throws android.os.RemoteException;

    void a_renamed(com.oplus.ocs.base.common.CapabilityInfo capabilityInfo) throws android.os.RemoteException;

    public static abstract class Stub extends android.os.Binder implements com.coloros.ocs.base.IAuthenticationListener {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.coloros.ocs.base.IAuthenticationListener");
        }

        public static com.coloros.ocs.base.IAuthenticationListener a_renamed(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.coloros.ocs.base.IAuthenticationListener");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof com.coloros.ocs.base.IAuthenticationListener)) {
                return (com.coloros.ocs.base.IAuthenticationListener) iInterfaceQueryLocalInterface;
            }
            return new com.coloros.ocs.base.IAuthenticationListener.Stub.Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i_renamed, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i_renamed == 1598968902) {
                parcel2.writeString("com.coloros.ocs.base.IAuthenticationListener");
                return true;
            }
            if (i_renamed == 1) {
                parcel.enforceInterface("com.coloros.ocs.base.IAuthenticationListener");
                a_renamed(parcel.readInt() != 0 ? com.oplus.ocs.base.common.CapabilityInfo.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i_renamed == 2) {
                parcel.enforceInterface("com.coloros.ocs.base.IAuthenticationListener");
                a_renamed(parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            return super.onTransact(i_renamed, parcel, parcel2, i2);
        }

        static class Proxy implements com.coloros.ocs.base.IAuthenticationListener {

            /* renamed from: a_renamed, reason: collision with root package name */
            public static com.coloros.ocs.base.IAuthenticationListener f2381a;

            /* renamed from: b_renamed, reason: collision with root package name */
            private android.os.IBinder f2382b;

            Proxy(android.os.IBinder iBinder) {
                this.f2382b = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.f2382b;
            }

            @Override // com.coloros.ocs.base.IAuthenticationListener
            public void a_renamed(com.oplus.ocs.base.common.CapabilityInfo capabilityInfo) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coloros.ocs.base.IAuthenticationListener");
                    if (capabilityInfo != null) {
                        parcelObtain.writeInt(1);
                        capabilityInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f2382b.transact(1, parcelObtain, parcelObtain2, 0) && com.coloros.ocs.base.IAuthenticationListener.Stub.a_renamed() != null) {
                        com.coloros.ocs.base.IAuthenticationListener.Stub.a_renamed().a_renamed(capabilityInfo);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.coloros.ocs.base.IAuthenticationListener
            public void a_renamed(int i_renamed) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coloros.ocs.base.IAuthenticationListener");
                    parcelObtain.writeInt(i_renamed);
                    if (!this.f2382b.transact(2, parcelObtain, parcelObtain2, 0) && com.coloros.ocs.base.IAuthenticationListener.Stub.a_renamed() != null) {
                        com.coloros.ocs.base.IAuthenticationListener.Stub.a_renamed().a_renamed(i_renamed);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static com.coloros.ocs.base.IAuthenticationListener a_renamed() {
            return com.coloros.ocs.base.IAuthenticationListener.Stub.Proxy.f2381a;
        }
    }
}
