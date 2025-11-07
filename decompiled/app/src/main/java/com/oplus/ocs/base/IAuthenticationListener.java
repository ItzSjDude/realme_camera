package com.oplus.ocs.base;

/* loaded from: classes2.dex */
public interface IAuthenticationListener extends android.os.IInterface {

    public static class Default implements com.oplus.ocs.base.IAuthenticationListener {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.oplus.ocs.base.IAuthenticationListener
        public void onFail(int i_renamed) throws android.os.RemoteException {
        }

        @Override // com.oplus.ocs.base.IAuthenticationListener
        public void onSuccess(com.oplus.ocs.base.common.CapabilityInfo capabilityInfo) throws android.os.RemoteException {
        }
    }

    void onFail(int i_renamed) throws android.os.RemoteException;

    void onSuccess(com.oplus.ocs.base.common.CapabilityInfo capabilityInfo) throws android.os.RemoteException;

    public static abstract class Stub extends android.os.Binder implements com.oplus.ocs.base.IAuthenticationListener {
        static final int TRANSACTION_onFail = 2;
        static final int TRANSACTION_onSuccess = 1;

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.oplus.ocs.base.IAuthenticationListener");
        }

        public static com.oplus.ocs.base.IAuthenticationListener asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.oplus.ocs.base.IAuthenticationListener");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof com.oplus.ocs.base.IAuthenticationListener)) {
                return (com.oplus.ocs.base.IAuthenticationListener) iInterfaceQueryLocalInterface;
            }
            return new com.oplus.ocs.base.IAuthenticationListener.Stub.Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i_renamed, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i_renamed == 1598968902) {
                parcel2.writeString("com.oplus.ocs.base.IAuthenticationListener");
                return true;
            }
            if (i_renamed == 1) {
                parcel.enforceInterface("com.oplus.ocs.base.IAuthenticationListener");
                onSuccess(parcel.readInt() != 0 ? com.oplus.ocs.base.common.CapabilityInfo.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i_renamed == 2) {
                parcel.enforceInterface("com.oplus.ocs.base.IAuthenticationListener");
                onFail(parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            return super.onTransact(i_renamed, parcel, parcel2, i2);
        }

        static class Proxy implements com.oplus.ocs.base.IAuthenticationListener {

            /* renamed from: a_renamed, reason: collision with root package name */
            public static com.oplus.ocs.base.IAuthenticationListener f7506a;

            /* renamed from: b_renamed, reason: collision with root package name */
            private android.os.IBinder f7507b;

            Proxy(android.os.IBinder iBinder) {
                this.f7507b = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.f7507b;
            }

            @Override // com.oplus.ocs.base.IAuthenticationListener
            public void onSuccess(com.oplus.ocs.base.common.CapabilityInfo capabilityInfo) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.oplus.ocs.base.IAuthenticationListener");
                    if (capabilityInfo != null) {
                        parcelObtain.writeInt(1);
                        capabilityInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f7507b.transact(1, parcelObtain, parcelObtain2, 0) && com.oplus.ocs.base.IAuthenticationListener.Stub.getDefaultImpl() != null) {
                        com.oplus.ocs.base.IAuthenticationListener.Stub.getDefaultImpl().onSuccess(capabilityInfo);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplus.ocs.base.IAuthenticationListener
            public void onFail(int i_renamed) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.oplus.ocs.base.IAuthenticationListener");
                    parcelObtain.writeInt(i_renamed);
                    if (!this.f7507b.transact(2, parcelObtain, parcelObtain2, 0) && com.oplus.ocs.base.IAuthenticationListener.Stub.getDefaultImpl() != null) {
                        com.oplus.ocs.base.IAuthenticationListener.Stub.getDefaultImpl().onFail(i_renamed);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(com.oplus.ocs.base.IAuthenticationListener iAuthenticationListener) {
            if (com.oplus.ocs.base.IAuthenticationListener.Stub.Proxy.f7506a != null) {
                throw new java.lang.IllegalStateException("setDefaultImpl() called twice");
            }
            if (iAuthenticationListener == null) {
                return false;
            }
            com.oplus.ocs.base.IAuthenticationListener.Stub.Proxy.f7506a = iAuthenticationListener;
            return true;
        }

        public static com.oplus.ocs.base.IAuthenticationListener getDefaultImpl() {
            return com.oplus.ocs.base.IAuthenticationListener.Stub.Proxy.f7506a;
        }
    }
}
