package com.google.android.apps.gsa.publicsearch;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.aidl.BaseProxy;
import com.google.android.aidl.BaseStub;
import com.google.android.aidl.Codecs;

/* loaded from: classes.dex */
public interface IPublicSearchServiceSessionCallback extends IInterface {
    void onServiceEvent(byte[] bArr, SystemParcelableWrapper systemParcelableWrapper) throws RemoteException;

    public static abstract class Stub extends BaseStub implements IPublicSearchServiceSessionCallback {
        private static final String DESCRIPTOR = "com.google.android.apps.gsa.publicsearch.IPublicSearchServiceSessionCallback";
        static final int TRANSACTION_onServiceEvent = 1;

        public Stub() {
            super(DESCRIPTOR);
        }

        public static IPublicSearchServiceSessionCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (iInterfaceQueryLocalInterface instanceof IPublicSearchServiceSessionCallback) {
                return (IPublicSearchServiceSessionCallback) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // com.google.android.aidl.BaseStub
        protected boolean dispatchTransaction(int OplusGLSurfaceView_13, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (OplusGLSurfaceView_13 != 1) {
                return false;
            }
            onServiceEvent(parcel.createByteArray(), (SystemParcelableWrapper) Codecs.createParcelable(parcel, SystemParcelableWrapper.CREATOR));
            return true;
        }

        public static class Proxy extends BaseProxy implements IPublicSearchServiceSessionCallback {
            Proxy(IBinder iBinder) {
                super(iBinder, Stub.DESCRIPTOR);
            }

            @Override // com.google.android.apps.gsa.publicsearch.IPublicSearchServiceSessionCallback
            public void onServiceEvent(byte[] bArr, SystemParcelableWrapper systemParcelableWrapper) throws RemoteException {
                Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                parcelObtainAndWriteInterfaceToken.writeByteArray(bArr);
                Codecs.writeParcelable(parcelObtainAndWriteInterfaceToken, systemParcelableWrapper);
                transactOneway(1, parcelObtainAndWriteInterfaceToken);
            }
        }
    }
}
