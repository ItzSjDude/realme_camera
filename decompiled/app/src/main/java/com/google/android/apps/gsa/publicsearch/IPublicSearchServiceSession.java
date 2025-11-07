package com.google.android.apps.gsa.publicsearch;

/* loaded from: classes.dex */
public interface IPublicSearchServiceSession extends android.os.IInterface {
    void onGenericClientEvent(byte[] bArr) throws android.os.RemoteException;

    void onGenericClientEventWithSystemParcelable(byte[] bArr, com.google.android.apps.gsa.publicsearch.SystemParcelableWrapper systemParcelableWrapper) throws android.os.RemoteException;

    public static abstract class Stub extends com.google.android.aidl.BaseStub implements com.google.android.apps.gsa.publicsearch.IPublicSearchServiceSession {
        private static final java.lang.String DESCRIPTOR = "com.google.android.apps.gsa.publicsearch.IPublicSearchServiceSession";
        static final int TRANSACTION_onGenericClientEvent = 1;
        static final int TRANSACTION_onGenericClientEventWithSystemParcelable = 2;

        public Stub() {
            super(DESCRIPTOR);
        }

        public static com.google.android.apps.gsa.publicsearch.IPublicSearchServiceSession asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (iInterfaceQueryLocalInterface instanceof com.google.android.apps.gsa.publicsearch.IPublicSearchServiceSession) {
                return (com.google.android.apps.gsa.publicsearch.IPublicSearchServiceSession) iInterfaceQueryLocalInterface;
            }
            return new com.google.android.apps.gsa.publicsearch.IPublicSearchServiceSession.Stub.Proxy(iBinder);
        }

        @Override // com.google.android.aidl.BaseStub
        protected boolean dispatchTransaction(int i_renamed, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i_renamed == 1) {
                onGenericClientEvent(parcel.createByteArray());
            } else {
                if (i_renamed != 2) {
                    return false;
                }
                onGenericClientEventWithSystemParcelable(parcel.createByteArray(), (com.google.android.apps.gsa.publicsearch.SystemParcelableWrapper) com.google.android.aidl.Codecs.createParcelable(parcel, com.google.android.apps.gsa.publicsearch.SystemParcelableWrapper.CREATOR));
            }
            return true;
        }

        public static class Proxy extends com.google.android.aidl.BaseProxy implements com.google.android.apps.gsa.publicsearch.IPublicSearchServiceSession {
            Proxy(android.os.IBinder iBinder) {
                super(iBinder, com.google.android.apps.gsa.publicsearch.IPublicSearchServiceSession.Stub.DESCRIPTOR);
            }

            @Override // com.google.android.apps.gsa.publicsearch.IPublicSearchServiceSession
            public void onGenericClientEvent(byte[] bArr) throws android.os.RemoteException {
                android.os.Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                parcelObtainAndWriteInterfaceToken.writeByteArray(bArr);
                transactOneway(1, parcelObtainAndWriteInterfaceToken);
            }

            @Override // com.google.android.apps.gsa.publicsearch.IPublicSearchServiceSession
            public void onGenericClientEventWithSystemParcelable(byte[] bArr, com.google.android.apps.gsa.publicsearch.SystemParcelableWrapper systemParcelableWrapper) throws android.os.RemoteException {
                android.os.Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                parcelObtainAndWriteInterfaceToken.writeByteArray(bArr);
                com.google.android.aidl.Codecs.writeParcelable(parcelObtainAndWriteInterfaceToken, systemParcelableWrapper);
                transactOneway(2, parcelObtainAndWriteInterfaceToken);
            }
        }
    }
}
