package com.oplus.tblplayer;

/* loaded from: classes2.dex */
public interface IRemoteObservable extends android.os.IInterface {

    public static class Default implements com.oplus.tblplayer.IRemoteObservable {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyBufferingUpdate(int i_renamed) throws android.os.RemoteException {
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyCompletion() throws android.os.RemoteException {
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyDownstreamSizeChanged(int i_renamed, int i2, int i3, float f_renamed) throws android.os.RemoteException {
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public boolean notifyError(int i_renamed, int i2, java.lang.String str) throws android.os.RemoteException {
            return false;
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public boolean notifyInfo(int i_renamed, int i2) throws android.os.RemoteException {
            return false;
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyIsPlayingChanged(boolean z_renamed) throws android.os.RemoteException {
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyPlaybackResult(com.oplus.tblplayer.monitor.Report report) throws android.os.RemoteException {
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyPlayerStateChanged(int i_renamed) throws android.os.RemoteException {
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyPrepared() throws android.os.RemoteException {
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifySeekComplete() throws android.os.RemoteException {
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyTimedText(com.oplus.tblplayer.misc.TBLTimedText tBLTimedText) throws android.os.RemoteException {
        }

        @Override // com.oplus.tblplayer.IRemoteObservable
        public void notifyVideoSizeChanged(int i_renamed, int i2, int i3, float f_renamed) throws android.os.RemoteException {
        }
    }

    void notifyBufferingUpdate(int i_renamed) throws android.os.RemoteException;

    void notifyCompletion() throws android.os.RemoteException;

    void notifyDownstreamSizeChanged(int i_renamed, int i2, int i3, float f_renamed) throws android.os.RemoteException;

    boolean notifyError(int i_renamed, int i2, java.lang.String str) throws android.os.RemoteException;

    boolean notifyInfo(int i_renamed, int i2) throws android.os.RemoteException;

    void notifyIsPlayingChanged(boolean z_renamed) throws android.os.RemoteException;

    void notifyPlaybackResult(com.oplus.tblplayer.monitor.Report report) throws android.os.RemoteException;

    void notifyPlayerStateChanged(int i_renamed) throws android.os.RemoteException;

    void notifyPrepared() throws android.os.RemoteException;

    void notifySeekComplete() throws android.os.RemoteException;

    void notifyTimedText(com.oplus.tblplayer.misc.TBLTimedText tBLTimedText) throws android.os.RemoteException;

    void notifyVideoSizeChanged(int i_renamed, int i2, int i3, float f_renamed) throws android.os.RemoteException;

    public static abstract class Stub extends android.os.Binder implements com.oplus.tblplayer.IRemoteObservable {
        private static final java.lang.String DESCRIPTOR = "com.oplus.tblplayer.IRemoteObservable";
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
        public android.os.IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static com.oplus.tblplayer.IRemoteObservable asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof com.oplus.tblplayer.IRemoteObservable)) {
                return (com.oplus.tblplayer.IRemoteObservable) iInterfaceQueryLocalInterface;
            }
            return new com.oplus.tblplayer.IRemoteObservable.Stub.Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i_renamed, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i_renamed == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            switch (i_renamed) {
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
                    notifyTimedText(parcel.readInt() != 0 ? com.oplus.tblplayer.misc.TBLTimedText.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    notifyPlaybackResult(parcel.readInt() != 0 ? com.oplus.tblplayer.monitor.Report.CREATOR.createFromParcel(parcel) : null);
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
                    return super.onTransact(i_renamed, parcel, parcel2, i2);
            }
        }

        private static class Proxy implements com.oplus.tblplayer.IRemoteObservable {
            public static com.oplus.tblplayer.IRemoteObservable sDefaultImpl;
            private android.os.IBinder mRemote;

            public java.lang.String getInterfaceDescriptor() {
                return com.oplus.tblplayer.IRemoteObservable.Stub.DESCRIPTOR;
            }

            Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.oplus.tblplayer.IRemoteObservable
            public void notifyPrepared() throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.oplus.tblplayer.IRemoteObservable.Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) && com.oplus.tblplayer.IRemoteObservable.Stub.getDefaultImpl() != null) {
                        com.oplus.tblplayer.IRemoteObservable.Stub.getDefaultImpl().notifyPrepared();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplus.tblplayer.IRemoteObservable
            public void notifyCompletion() throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.oplus.tblplayer.IRemoteObservable.Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) && com.oplus.tblplayer.IRemoteObservable.Stub.getDefaultImpl() != null) {
                        com.oplus.tblplayer.IRemoteObservable.Stub.getDefaultImpl().notifyCompletion();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplus.tblplayer.IRemoteObservable
            public void notifyBufferingUpdate(int i_renamed) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.oplus.tblplayer.IRemoteObservable.Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i_renamed);
                    if (!this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) && com.oplus.tblplayer.IRemoteObservable.Stub.getDefaultImpl() != null) {
                        com.oplus.tblplayer.IRemoteObservable.Stub.getDefaultImpl().notifyBufferingUpdate(i_renamed);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplus.tblplayer.IRemoteObservable
            public void notifySeekComplete() throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.oplus.tblplayer.IRemoteObservable.Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(4, parcelObtain, parcelObtain2, 0) && com.oplus.tblplayer.IRemoteObservable.Stub.getDefaultImpl() != null) {
                        com.oplus.tblplayer.IRemoteObservable.Stub.getDefaultImpl().notifySeekComplete();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplus.tblplayer.IRemoteObservable
            public void notifyVideoSizeChanged(int i_renamed, int i2, int i3, float f_renamed) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.oplus.tblplayer.IRemoteObservable.Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i_renamed);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeFloat(f_renamed);
                    if (!this.mRemote.transact(5, parcelObtain, parcelObtain2, 0) && com.oplus.tblplayer.IRemoteObservable.Stub.getDefaultImpl() != null) {
                        com.oplus.tblplayer.IRemoteObservable.Stub.getDefaultImpl().notifyVideoSizeChanged(i_renamed, i2, i3, f_renamed);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplus.tblplayer.IRemoteObservable
            public boolean notifyError(int i_renamed, int i2, java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.oplus.tblplayer.IRemoteObservable.Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i_renamed);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeString(str);
                    if (!this.mRemote.transact(6, parcelObtain, parcelObtain2, 0) && com.oplus.tblplayer.IRemoteObservable.Stub.getDefaultImpl() != null) {
                        return com.oplus.tblplayer.IRemoteObservable.Stub.getDefaultImpl().notifyError(i_renamed, i2, str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplus.tblplayer.IRemoteObservable
            public boolean notifyInfo(int i_renamed, int i2) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.oplus.tblplayer.IRemoteObservable.Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i_renamed);
                    parcelObtain.writeInt(i2);
                    if (!this.mRemote.transact(7, parcelObtain, parcelObtain2, 0) && com.oplus.tblplayer.IRemoteObservable.Stub.getDefaultImpl() != null) {
                        return com.oplus.tblplayer.IRemoteObservable.Stub.getDefaultImpl().notifyInfo(i_renamed, i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplus.tblplayer.IRemoteObservable
            public void notifyTimedText(com.oplus.tblplayer.misc.TBLTimedText tBLTimedText) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.oplus.tblplayer.IRemoteObservable.Stub.DESCRIPTOR);
                    if (tBLTimedText != null) {
                        parcelObtain.writeInt(1);
                        tBLTimedText.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(8, parcelObtain, parcelObtain2, 0) && com.oplus.tblplayer.IRemoteObservable.Stub.getDefaultImpl() != null) {
                        com.oplus.tblplayer.IRemoteObservable.Stub.getDefaultImpl().notifyTimedText(tBLTimedText);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplus.tblplayer.IRemoteObservable
            public void notifyPlaybackResult(com.oplus.tblplayer.monitor.Report report) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.oplus.tblplayer.IRemoteObservable.Stub.DESCRIPTOR);
                    if (report != null) {
                        parcelObtain.writeInt(1);
                        report.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(9, parcelObtain, parcelObtain2, 0) && com.oplus.tblplayer.IRemoteObservable.Stub.getDefaultImpl() != null) {
                        com.oplus.tblplayer.IRemoteObservable.Stub.getDefaultImpl().notifyPlaybackResult(report);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplus.tblplayer.IRemoteObservable
            public void notifyPlayerStateChanged(int i_renamed) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.oplus.tblplayer.IRemoteObservable.Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i_renamed);
                    if (!this.mRemote.transact(10, parcelObtain, parcelObtain2, 0) && com.oplus.tblplayer.IRemoteObservable.Stub.getDefaultImpl() != null) {
                        com.oplus.tblplayer.IRemoteObservable.Stub.getDefaultImpl().notifyPlayerStateChanged(i_renamed);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplus.tblplayer.IRemoteObservable
            public void notifyIsPlayingChanged(boolean z_renamed) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.oplus.tblplayer.IRemoteObservable.Stub.DESCRIPTOR);
                    parcelObtain.writeInt(z_renamed ? 1 : 0);
                    if (!this.mRemote.transact(11, parcelObtain, parcelObtain2, 0) && com.oplus.tblplayer.IRemoteObservable.Stub.getDefaultImpl() != null) {
                        com.oplus.tblplayer.IRemoteObservable.Stub.getDefaultImpl().notifyIsPlayingChanged(z_renamed);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplus.tblplayer.IRemoteObservable
            public void notifyDownstreamSizeChanged(int i_renamed, int i2, int i3, float f_renamed) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.oplus.tblplayer.IRemoteObservable.Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i_renamed);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeFloat(f_renamed);
                    if (!this.mRemote.transact(12, parcelObtain, parcelObtain2, 0) && com.oplus.tblplayer.IRemoteObservable.Stub.getDefaultImpl() != null) {
                        com.oplus.tblplayer.IRemoteObservable.Stub.getDefaultImpl().notifyDownstreamSizeChanged(i_renamed, i2, i3, f_renamed);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(com.oplus.tblplayer.IRemoteObservable iRemoteObservable) {
            if (com.oplus.tblplayer.IRemoteObservable.Stub.Proxy.sDefaultImpl != null || iRemoteObservable == null) {
                return false;
            }
            com.oplus.tblplayer.IRemoteObservable.Stub.Proxy.sDefaultImpl = iRemoteObservable;
            return true;
        }

        public static com.oplus.tblplayer.IRemoteObservable getDefaultImpl() {
            return com.oplus.tblplayer.IRemoteObservable.Stub.Proxy.sDefaultImpl;
        }
    }
}
