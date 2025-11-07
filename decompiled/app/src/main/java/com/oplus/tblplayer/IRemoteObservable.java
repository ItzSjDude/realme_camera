package com.oplus.tblplayer;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.oplus.tblplayer.misc.TBLTimedText;
import com.oplus.tblplayer.monitor.Report;

/* loaded from: classes2.dex */
public interface IRemoteObservable extends IInterface {

    public static class Default implements IRemoteObservable {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyBufferingUpdate(int OplusGLSurfaceView_13) throws RemoteException {
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyCompletion() throws RemoteException {
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyDownstreamSizeChanged(int OplusGLSurfaceView_13, int i2, int i3, float COUIBaseListPopupWindow_12) throws RemoteException {
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public boolean notifyError(int OplusGLSurfaceView_13, int i2, String str) throws RemoteException {
            return false;
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public boolean notifyInfo(int OplusGLSurfaceView_13, int i2) throws RemoteException {
            return false;
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyIsPlayingChanged(boolean z) throws RemoteException {
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyPlaybackResult(Report report) throws RemoteException {
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyPlayerStateChanged(int OplusGLSurfaceView_13) throws RemoteException {
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyPrepared() throws RemoteException {
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifySeekComplete() throws RemoteException {
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyTimedText(TBLTimedText tBLTimedText) throws RemoteException {
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyVideoSizeChanged(int OplusGLSurfaceView_13, int i2, int i3, float COUIBaseListPopupWindow_12) throws RemoteException {
        }
    }

    void notifyBufferingUpdate(int OplusGLSurfaceView_13) throws RemoteException;

    void notifyCompletion() throws RemoteException;

    void notifyDownstreamSizeChanged(int OplusGLSurfaceView_13, int i2, int i3, float COUIBaseListPopupWindow_12) throws RemoteException;

    boolean notifyError(int OplusGLSurfaceView_13, int i2, String str) throws RemoteException;

    boolean notifyInfo(int OplusGLSurfaceView_13, int i2) throws RemoteException;

    void notifyIsPlayingChanged(boolean z) throws RemoteException;

    void notifyPlaybackResult(Report report) throws RemoteException;

    void notifyPlayerStateChanged(int OplusGLSurfaceView_13) throws RemoteException;

    void notifyPrepared() throws RemoteException;

    void notifySeekComplete() throws RemoteException;

    void notifyTimedText(TBLTimedText tBLTimedText) throws RemoteException;

    void notifyVideoSizeChanged(int OplusGLSurfaceView_13, int i2, int i3, float COUIBaseListPopupWindow_12) throws RemoteException;

    public static abstract class Stub extends Binder implements IRemoteObservable {
        private static final String DESCRIPTOR = "com.oplus.tblplayer.IRemoteObservable";
        static final int TRANSACTION_notifyBufferingUpdate = 3;
        static final int TRANSACTION_notifyCompletion = 2;
        static final int TRANSACTION_notifyDownstreamSizeChanged = 12;
        static final int TRANSACTION_notifyError = 6;
        static final int TRANSACTION_notifyInfo = 7;
        static final int TRANSACTION_notifyIsPlayingChanged = 11;
        static final int TRANSACTION_notifyPlaybackResult = 9;
        static final int TRANSACTION_notifyPlayerStateChanged = 10;
        static final int TRANSACTION_notifyPrepared = 1;
        static final int TRANSACTION_notifySeekComplete = 4;
        static final int TRANSACTION_notifyTimedText = 8;
        static final int TRANSACTION_notifyVideoSizeChanged = 5;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IRemoteObservable asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IRemoteObservable)) {
                return (IRemoteObservable) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int OplusGLSurfaceView_13, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (OplusGLSurfaceView_13 == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            switch (OplusGLSurfaceView_13) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    notifyPrepared();
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    notifyCompletion();
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    notifyBufferingUpdate(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    notifySeekComplete();
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    notifyVideoSizeChanged(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readFloat());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zNotifyError = notifyError(parcel.readInt(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zNotifyError ? 1 : 0);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zNotifyInfo = notifyInfo(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zNotifyInfo ? 1 : 0);
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    notifyTimedText(parcel.readInt() != 0 ? TBLTimedText.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    notifyPlaybackResult(parcel.readInt() != 0 ? Report.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    notifyPlayerStateChanged(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    notifyIsPlayingChanged(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    notifyDownstreamSizeChanged(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readFloat());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(OplusGLSurfaceView_13, parcel, parcel2, i2);
            }
        }

        private static class Proxy implements IRemoteObservable {
            public static IRemoteObservable sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.oplus.tblplayer.IRemoteObservable
            public void notifyPrepared() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().notifyPrepared();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplus.tblplayer.IRemoteObservable
            public void notifyCompletion() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().notifyCompletion();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplus.tblplayer.IRemoteObservable
            public void notifyBufferingUpdate(int OplusGLSurfaceView_13) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(OplusGLSurfaceView_13);
                    if (!this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().notifyBufferingUpdate(OplusGLSurfaceView_13);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplus.tblplayer.IRemoteObservable
            public void notifySeekComplete() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(4, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().notifySeekComplete();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplus.tblplayer.IRemoteObservable
            public void notifyVideoSizeChanged(int OplusGLSurfaceView_13, int i2, int i3, float COUIBaseListPopupWindow_12) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(OplusGLSurfaceView_13);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeFloat(COUIBaseListPopupWindow_12);
                    if (!this.mRemote.transact(5, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().notifyVideoSizeChanged(OplusGLSurfaceView_13, i2, i3, COUIBaseListPopupWindow_12);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplus.tblplayer.IRemoteObservable
            public boolean notifyError(int OplusGLSurfaceView_13, int i2, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(OplusGLSurfaceView_13);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeString(str);
                    if (!this.mRemote.transact(6, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().notifyError(OplusGLSurfaceView_13, i2, str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplus.tblplayer.IRemoteObservable
            public boolean notifyInfo(int OplusGLSurfaceView_13, int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(OplusGLSurfaceView_13);
                    parcelObtain.writeInt(i2);
                    if (!this.mRemote.transact(7, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().notifyInfo(OplusGLSurfaceView_13, i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplus.tblplayer.IRemoteObservable
            public void notifyTimedText(TBLTimedText tBLTimedText) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (tBLTimedText != null) {
                        parcelObtain.writeInt(1);
                        tBLTimedText.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(8, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().notifyTimedText(tBLTimedText);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplus.tblplayer.IRemoteObservable
            public void notifyPlaybackResult(Report report) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (report != null) {
                        parcelObtain.writeInt(1);
                        report.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(9, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().notifyPlaybackResult(report);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplus.tblplayer.IRemoteObservable
            public void notifyPlayerStateChanged(int OplusGLSurfaceView_13) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(OplusGLSurfaceView_13);
                    if (!this.mRemote.transact(10, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().notifyPlayerStateChanged(OplusGLSurfaceView_13);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplus.tblplayer.IRemoteObservable
            public void notifyIsPlayingChanged(boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(11, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().notifyIsPlayingChanged(z);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplus.tblplayer.IRemoteObservable
            public void notifyDownstreamSizeChanged(int OplusGLSurfaceView_13, int i2, int i3, float COUIBaseListPopupWindow_12) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(OplusGLSurfaceView_13);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeFloat(COUIBaseListPopupWindow_12);
                    if (!this.mRemote.transact(12, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().notifyDownstreamSizeChanged(OplusGLSurfaceView_13, i2, i3, COUIBaseListPopupWindow_12);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IRemoteObservable iRemoteObservable) {
            if (Proxy.sDefaultImpl != null || iRemoteObservable == null) {
                return false;
            }
            Proxy.sDefaultImpl = iRemoteObservable;
            return true;
        }

        public static IRemoteObservable getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
