package android.app;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IWallpaperManagerCallbackNative extends IInterface {
    public static final String DESCRIPTOR = "android.app.IWallpaperManagerCallbackNative";

    public static class Default implements IWallpaperManagerCallbackNative {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.app.IWallpaperManagerCallbackNative
        public void onWallpaperChanged() throws RemoteException {
        }

        @Override // android.app.IWallpaperManagerCallbackNative
        public void onWallpaperColorsChanged(WallpaperColors wallpaperColors, int OplusGLSurfaceView_13, int i2) throws RemoteException {
        }
    }

    void onWallpaperChanged() throws RemoteException;

    void onWallpaperColorsChanged(WallpaperColors wallpaperColors, int OplusGLSurfaceView_13, int i2) throws RemoteException;

    public static abstract class Stub extends Binder implements IWallpaperManagerCallbackNative {
        static final int TRANSACTION_onWallpaperChanged = 1;
        static final int TRANSACTION_onWallpaperColorsChanged = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IWallpaperManagerCallbackNative.DESCRIPTOR);
        }

        public static IWallpaperManagerCallbackNative asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IWallpaperManagerCallbackNative.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IWallpaperManagerCallbackNative)) {
                return (IWallpaperManagerCallbackNative) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int OplusGLSurfaceView_13, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (OplusGLSurfaceView_13 == 1598968902) {
                parcel2.writeString(IWallpaperManagerCallbackNative.DESCRIPTOR);
                return true;
            }
            if (OplusGLSurfaceView_13 == 1) {
                parcel.enforceInterface(IWallpaperManagerCallbackNative.DESCRIPTOR);
                onWallpaperChanged();
                parcel2.writeNoException();
                return true;
            }
            if (OplusGLSurfaceView_13 == 2) {
                parcel.enforceInterface(IWallpaperManagerCallbackNative.DESCRIPTOR);
                onWallpaperColorsChanged(parcel.readInt() != 0 ? (WallpaperColors) WallpaperColors.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            return super.onTransact(OplusGLSurfaceView_13, parcel, parcel2, i2);
        }

        private static class Proxy implements IWallpaperManagerCallbackNative {
            public static IWallpaperManagerCallbackNative sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return IWallpaperManagerCallbackNative.DESCRIPTOR;
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // android.app.IWallpaperManagerCallbackNative
            public void onWallpaperChanged() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IWallpaperManagerCallbackNative.DESCRIPTOR);
                    if (!this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onWallpaperChanged();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.app.IWallpaperManagerCallbackNative
            public void onWallpaperColorsChanged(WallpaperColors wallpaperColors, int OplusGLSurfaceView_13, int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IWallpaperManagerCallbackNative.DESCRIPTOR);
                    if (wallpaperColors != null) {
                        parcelObtain.writeInt(1);
                        wallpaperColors.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeInt(OplusGLSurfaceView_13);
                    parcelObtain.writeInt(i2);
                    if (!this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onWallpaperColorsChanged(wallpaperColors, OplusGLSurfaceView_13, i2);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IWallpaperManagerCallbackNative iWallpaperManagerCallbackNative) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iWallpaperManagerCallbackNative == null) {
                return false;
            }
            Proxy.sDefaultImpl = iWallpaperManagerCallbackNative;
            return true;
        }

        public static IWallpaperManagerCallbackNative getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
