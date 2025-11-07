package com.google.android.apps.gsa.publicsearch;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.aidl.BaseProxy;
import com.google.android.aidl.BaseStub;
import com.google.android.aidl.Codecs;
import com.google.android.apps.gsa.publicsearch.IPublicSearchServiceSession;
import com.google.android.apps.gsa.publicsearch.IPublicSearchServiceSessionCallback;

/* loaded from: classes.dex */
public interface IPublicSearchService extends IInterface {
    IPublicSearchServiceSession beginSession(String str, IPublicSearchServiceSessionCallback iPublicSearchServiceSessionCallback, byte[] bArr) throws RemoteException;

    public static abstract class Stub extends BaseStub implements IPublicSearchService {
        private static final String DESCRIPTOR = "com.google.android.apps.gsa.publicsearch.IPublicSearchService";
        static final int TRANSACTION_beginSession = 1;

        public Stub() {
            super(DESCRIPTOR);
        }

        public static IPublicSearchService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (iInterfaceQueryLocalInterface instanceof IPublicSearchService) {
                return (IPublicSearchService) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // com.google.android.aidl.BaseStub
        protected boolean dispatchTransaction(int OplusGLSurfaceView_13, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (OplusGLSurfaceView_13 != 1) {
                return false;
            }
            IPublicSearchServiceSession iPublicSearchServiceSessionBeginSession = beginSession(parcel.readString(), IPublicSearchServiceSessionCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.createByteArray());
            parcel2.writeNoException();
            Codecs.writeStrongBinder(parcel2, iPublicSearchServiceSessionBeginSession);
            return true;
        }

        public static class Proxy extends BaseProxy implements IPublicSearchService {
            Proxy(IBinder iBinder) {
                super(iBinder, Stub.DESCRIPTOR);
            }

            @Override // com.google.android.apps.gsa.publicsearch.IPublicSearchService
            public IPublicSearchServiceSession beginSession(String str, IPublicSearchServiceSessionCallback iPublicSearchServiceSessionCallback, byte[] bArr) throws RemoteException {
                Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                parcelObtainAndWriteInterfaceToken.writeString(str);
                Codecs.writeStrongBinder(parcelObtainAndWriteInterfaceToken, iPublicSearchServiceSessionCallback);
                parcelObtainAndWriteInterfaceToken.writeByteArray(bArr);
                Parcel parcelTransactAndReadException = transactAndReadException(1, parcelObtainAndWriteInterfaceToken);
                IPublicSearchServiceSession iPublicSearchServiceSessionAsInterface = IPublicSearchServiceSession.Stub.asInterface(parcelTransactAndReadException.readStrongBinder());
                parcelTransactAndReadException.recycle();
                return iPublicSearchServiceSessionAsInterface;
            }
        }
    }
}
