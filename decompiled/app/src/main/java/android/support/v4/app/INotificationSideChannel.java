package android.support.v4.app;

/* loaded from: classes.dex */
public interface INotificationSideChannel extends android.os.IInterface {

    public static class Default implements android.support.v4.app.INotificationSideChannel {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void cancel(java.lang.String str, int i_renamed, java.lang.String str2) throws android.os.RemoteException {
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void cancelAll(java.lang.String str) throws android.os.RemoteException {
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void notify(java.lang.String str, int i_renamed, java.lang.String str2, android.app.Notification notification) throws android.os.RemoteException {
        }
    }

    void cancel(java.lang.String str, int i_renamed, java.lang.String str2) throws android.os.RemoteException;

    void cancelAll(java.lang.String str) throws android.os.RemoteException;

    void notify(java.lang.String str, int i_renamed, java.lang.String str2, android.app.Notification notification) throws android.os.RemoteException;

    public static abstract class Stub extends android.os.Binder implements android.support.v4.app.INotificationSideChannel {
        private static final java.lang.String DESCRIPTOR = "android.support.v4.app.INotificationSideChannel";
        static final int TRANSACTION_cancel = 2;
        static final int TRANSACTION_cancelAll = 3;
        static final int TRANSACTION_notify = 1;

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static android.support.v4.app.INotificationSideChannel asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof android.support.v4.app.INotificationSideChannel)) {
                return (android.support.v4.app.INotificationSideChannel) iInterfaceQueryLocalInterface;
            }
            return new android.support.v4.app.INotificationSideChannel.Stub.Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i_renamed, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i_renamed == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                notify(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt() != 0 ? (android.app.Notification) android.app.Notification.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i_renamed == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                cancel(parcel.readString(), parcel.readInt(), parcel.readString());
                return true;
            }
            if (i_renamed == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                cancelAll(parcel.readString());
                return true;
            }
            if (i_renamed == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i_renamed, parcel, parcel2, i2);
        }

        private static class Proxy implements android.support.v4.app.INotificationSideChannel {
            public static android.support.v4.app.INotificationSideChannel sDefaultImpl;
            private android.os.IBinder mRemote;

            public java.lang.String getInterfaceDescriptor() {
                return android.support.v4.app.INotificationSideChannel.Stub.DESCRIPTOR;
            }

            Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            @Override // android.support.v4.app.INotificationSideChannel
            public void notify(java.lang.String str, int i_renamed, java.lang.String str2, android.app.Notification notification) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.app.INotificationSideChannel.Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i_renamed);
                    parcelObtain.writeString(str2);
                    if (notification != null) {
                        parcelObtain.writeInt(1);
                        notification.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(1, parcelObtain, null, 1) || android.support.v4.app.INotificationSideChannel.Stub.getDefaultImpl() == null) {
                        return;
                    }
                    android.support.v4.app.INotificationSideChannel.Stub.getDefaultImpl().notify(str, i_renamed, str2, notification);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.app.INotificationSideChannel
            public void cancel(java.lang.String str, int i_renamed, java.lang.String str2) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.app.INotificationSideChannel.Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i_renamed);
                    parcelObtain.writeString(str2);
                    if (this.mRemote.transact(2, parcelObtain, null, 1) || android.support.v4.app.INotificationSideChannel.Stub.getDefaultImpl() == null) {
                        return;
                    }
                    android.support.v4.app.INotificationSideChannel.Stub.getDefaultImpl().cancel(str, i_renamed, str2);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.app.INotificationSideChannel
            public void cancelAll(java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.app.INotificationSideChannel.Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(3, parcelObtain, null, 1) || android.support.v4.app.INotificationSideChannel.Stub.getDefaultImpl() == null) {
                        return;
                    }
                    android.support.v4.app.INotificationSideChannel.Stub.getDefaultImpl().cancelAll(str);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(android.support.v4.app.INotificationSideChannel iNotificationSideChannel) {
            if (android.support.v4.app.INotificationSideChannel.Stub.Proxy.sDefaultImpl != null || iNotificationSideChannel == null) {
                return false;
            }
            android.support.v4.app.INotificationSideChannel.Stub.Proxy.sDefaultImpl = iNotificationSideChannel;
            return true;
        }

        public static android.support.v4.app.INotificationSideChannel getDefaultImpl() {
            return android.support.v4.app.INotificationSideChannel.Stub.Proxy.sDefaultImpl;
        }
    }
}
