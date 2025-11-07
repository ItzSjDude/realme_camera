package com.google.android.apps.gsa.publicsearch;

/* loaded from: classes.dex */
public interface IPublicSearchServiceSessionCallback extends android.os.IInterface {
    void onServiceEvent(byte[] bArr, com.google.android.apps.gsa.publicsearch.SystemParcelableWrapper systemParcelableWrapper) throws android.os.RemoteException;

    public static abstract class Stub extends com.google.android.aidl.BaseStub implements com.google.android.apps.gsa.publicsearch.IPublicSearchServiceSessionCallback {
        private static final java.lang.String DESCRIPTOR = "com.google.android.apps.gsa.publicsearch.IPublicSearchServiceSessionCallback";
        static final int TRANSACTION_onServiceEvent = 1;

        public Stub() {
            super(DESCRIPTOR);
        }

        public static com.google.android.apps.gsa.publicsearch.IPublicSearchServiceSessionCallback asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (iInterfaceQueryLocalInterface instanceof com.google.android.apps.gsa.publicsearch.IPublicSearchServiceSessionCallback) {
                return (com.google.android.apps.gsa.publicsearch.IPublicSearchServiceSessionCallback) iInterfaceQueryLocalInterface;
            }
            return new com.google.android.apps.gsa.publicsearch.IPublicSearchServiceSessionCallback.Stub.Proxy(iBinder);
        }

        @Override // com.google.android.aidl.BaseStub
        protected boolean dispatchTransaction(int i_renamed, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i_renamed != 1) {
                return false;
            }
            onServiceEvent(parcel.createByteArray(), (com.google.android.apps.gsa.publicsearch.SystemParcelableWrapper) com.google.android.aidl.Codecs.createParcelable(parcel, com.google.android.apps.gsa.publicsearch.SystemParcelableWrapper.CREATOR));
            return true;
        }

        public static class Proxy extends com.google.android.aidl.BaseProxy implements com.google.android.apps.gsa.publicsearch.IPublicSearchServiceSessionCallback {
            Proxy(android.os.IBinder iBinder) {
                super(iBinder, com.google.android.apps.gsa.publicsearch.IPublicSearchServiceSessionCallback.Stub.DESCRIPTOR);
            }

            @Override // com.google.android.apps.gsa.publicsearch.IPublicSearchServiceSessionCallback
            public void onServiceEvent(byte[] bArr, com.google.android.apps.gsa.publicsearch.SystemParcelableWrapper systemParcelableWrapper) throws android.os.RemoteException {
                android.os.Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                parcelObtainAndWriteInterfaceToken.writeByteArray(bArr);
                com.google.android.aidl.Codecs.writeParcelable(parcelObtainAndWriteInterfaceToken, systemParcelableWrapper);
                transactOneway(1, parcelObtainAndWriteInterfaceToken);
            }
        }
    }
}
