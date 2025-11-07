package com.oplus.epona;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.oplus.epona.ITransferCallback;

/* loaded from: classes2.dex */
public interface IRemoteTransfer extends IInterface {

    public static class Default implements IRemoteTransfer {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.oplus.epona.IRemoteTransfer
        public void asyncCall(Request request, ITransferCallback iTransferCallback) throws RemoteException {
        }

        @Override // com.oplus.epona.IRemoteTransfer
        public Response call(Request request) throws RemoteException {
            return null;
        }
    }

    void asyncCall(Request request, ITransferCallback iTransferCallback) throws RemoteException;

    Response call(Request request) throws RemoteException;

    public static abstract class Stub extends Binder implements IRemoteTransfer {
        private static final String DESCRIPTOR = "com.oplus.epona.IRemoteTransfer";
        static final int TRANSACTION_asyncCall = 2;
        static final int TRANSACTION_call = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IRemoteTransfer asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IRemoteTransfer)) {
                return (IRemoteTransfer) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int OplusGLSurfaceView_13, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (OplusGLSurfaceView_13 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                Response responseCall = call(parcel.readInt() != 0 ? Request.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                if (responseCall != null) {
                    parcel2.writeInt(1);
                    responseCall.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            if (OplusGLSurfaceView_13 != 2) {
                if (OplusGLSurfaceView_13 == 1598968902) {
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(OplusGLSurfaceView_13, parcel, parcel2, i2);
            }
            parcel.enforceInterface(DESCRIPTOR);
            asyncCall(parcel.readInt() != 0 ? Request.CREATOR.createFromParcel(parcel) : null, ITransferCallback.Stub.asInterface(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        private static class Proxy implements IRemoteTransfer {
            public static IRemoteTransfer sDefaultImpl;
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

            @Override // com.oplus.epona.IRemoteTransfer
            public Response call(Request request) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (request != null) {
                        parcelObtain.writeInt(1);
                        request.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().call(request);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? Response.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplus.epona.IRemoteTransfer
            public void asyncCall(Request request, ITransferCallback iTransferCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (request != null) {
                        parcelObtain.writeInt(1);
                        request.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iTransferCallback != null ? iTransferCallback.asBinder() : null);
                    if (!this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().asyncCall(request, iTransferCallback);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IRemoteTransfer iRemoteTransfer) {
            if (Proxy.sDefaultImpl != null || iRemoteTransfer == null) {
                return false;
            }
            Proxy.sDefaultImpl = iRemoteTransfer;
            return true;
        }

        public static IRemoteTransfer getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
