package android.app;

/* loaded from: classes.dex */
public interface IWallpaperManagerCallbackNative extends android.os.IInterface {
    public static final java.lang.String DESCRIPTOR = "android.app.IWallpaperManagerCallbackNative";

    public static class Default implements android.app.IWallpaperManagerCallbackNative {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // android.app.IWallpaperManagerCallbackNative
        public void onWallpaperChanged() throws android.os.RemoteException {
        }

        @Override // android.app.IWallpaperManagerCallbackNative
        public void onWallpaperColorsChanged(android.app.WallpaperColors wallpaperColors, int i_renamed, int i2) throws android.os.RemoteException {
        }
    }

    void onWallpaperChanged() throws android.os.RemoteException;

    void onWallpaperColorsChanged(android.app.WallpaperColors wallpaperColors, int i_renamed, int i2) throws android.os.RemoteException;

    public static abstract class Stub extends android.os.Binder implements android.app.IWallpaperManagerCallbackNative {
        static final int TRANSACTION_onWallpaperChanged = 1;
        static final int TRANSACTION_onWallpaperColorsChanged = 2;

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, android.app.IWallpaperManagerCallbackNative.DESCRIPTOR);
        }

        public static android.app.IWallpaperManagerCallbackNative asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(android.app.IWallpaperManagerCallbackNative.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof android.app.IWallpaperManagerCallbackNative)) {
                return (android.app.IWallpaperManagerCallbackNative) iInterfaceQueryLocalInterface;
            }
            return new android.app.IWallpaperManagerCallbackNative.Stub.Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i_renamed, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i_renamed == 1598968902) {
                parcel2.writeString(android.app.IWallpaperManagerCallbackNative.DESCRIPTOR);
                return true;
            }
            if (i_renamed == 1) {
                parcel.enforceInterface(android.app.IWallpaperManagerCallbackNative.DESCRIPTOR);
                onWallpaperChanged();
                parcel2.writeNoException();
                return true;
            }
            if (i_renamed == 2) {
                parcel.enforceInterface(android.app.IWallpaperManagerCallbackNative.DESCRIPTOR);
                onWallpaperColorsChanged(parcel.readInt() != 0 ? (android.app.WallpaperColors) android.app.WallpaperColors.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            return super.onTransact(i_renamed, parcel, parcel2, i2);
        }

        private static class Proxy implements android.app.IWallpaperManagerCallbackNative {
            public static android.app.IWallpaperManagerCallbackNative sDefaultImpl;
            private android.os.IBinder mRemote;

            public java.lang.String getInterfaceDescriptor() {
                return android.app.IWallpaperManagerCallbackNative.DESCRIPTOR;
            }

            Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            @Override // android.app.IWallpaperManagerCallbackNative
            public void onWallpaperChanged() throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.app.IWallpaperManagerCallbackNative.DESCRIPTOR);
                    if (!this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) && android.app.IWallpaperManagerCallbackNative.Stub.getDefaultImpl() != null) {
                        android.app.IWallpaperManagerCallbackNative.Stub.getDefaultImpl().onWallpaperChanged();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.app.IWallpaperManagerCallbackNative
            public void onWallpaperColorsChanged(android.app.WallpaperColors wallpaperColors, int i_renamed, int i2) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.app.IWallpaperManagerCallbackNative.DESCRIPTOR);
                    if (wallpaperColors != null) {
                        parcelObtain.writeInt(1);
                        wallpaperColors.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeInt(i_renamed);
                    parcelObtain.writeInt(i2);
                    if (!this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) && android.app.IWallpaperManagerCallbackNative.Stub.getDefaultImpl() != null) {
                        android.app.IWallpaperManagerCallbackNative.Stub.getDefaultImpl().onWallpaperColorsChanged(wallpaperColors, i_renamed, i2);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(android.app.IWallpaperManagerCallbackNative iWallpaperManagerCallbackNative) {
            if (android.app.IWallpaperManagerCallbackNative.Stub.Proxy.sDefaultImpl != null) {
                throw new java.lang.IllegalStateException("setDefaultImpl() called twice");
            }
            if (iWallpaperManagerCallbackNative == null) {
                return false;
            }
            android.app.IWallpaperManagerCallbackNative.Stub.Proxy.sDefaultImpl = iWallpaperManagerCallbackNative;
            return true;
        }

        public static android.app.IWallpaperManagerCallbackNative getDefaultImpl() {
            return android.app.IWallpaperManagerCallbackNative.Stub.Proxy.sDefaultImpl;
        }
    }
}
