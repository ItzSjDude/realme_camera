package com.google.android.apps.gsa.publicsearch;

/* loaded from: classes.dex */
public interface IPublicSearchService extends android.os.IInterface {
    com.google.android.apps.gsa.publicsearch.IPublicSearchServiceSession beginSession(java.lang.String str, com.google.android.apps.gsa.publicsearch.IPublicSearchServiceSessionCallback iPublicSearchServiceSessionCallback, byte[] bArr) throws android.os.RemoteException;

    public static abstract class Stub extends com.google.android.aidl.BaseStub implements com.google.android.apps.gsa.publicsearch.IPublicSearchService {
        private static final java.lang.String DESCRIPTOR = "com.google.android.apps.gsa.publicsearch.IPublicSearchService";
        static final int TRANSACTION_beginSession = 1;

        public Stub() {
            super(DESCRIPTOR);
        }

        public static com.google.android.apps.gsa.publicsearch.IPublicSearchService asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (iInterfaceQueryLocalInterface instanceof com.google.android.apps.gsa.publicsearch.IPublicSearchService) {
                return (com.google.android.apps.gsa.publicsearch.IPublicSearchService) iInterfaceQueryLocalInterface;
            }
            return new com.google.android.apps.gsa.publicsearch.IPublicSearchService.Stub.Proxy(iBinder);
        }

        @Override // com.google.android.aidl.BaseStub
        protected boolean dispatchTransaction(int i_renamed, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i_renamed != 1) {
                return false;
            }
            com.google.android.apps.gsa.publicsearch.IPublicSearchServiceSession iPublicSearchServiceSessionBeginSession = beginSession(parcel.readString(), com.google.android.apps.gsa.publicsearch.IPublicSearchServiceSessionCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.createByteArray());
            parcel2.writeNoException();
            com.google.android.aidl.Codecs.writeStrongBinder(parcel2, iPublicSearchServiceSessionBeginSession);
            return true;
        }

        public static class Proxy extends com.google.android.aidl.BaseProxy implements com.google.android.apps.gsa.publicsearch.IPublicSearchService {
            Proxy(android.os.IBinder iBinder) {
                super(iBinder, com.google.android.apps.gsa.publicsearch.IPublicSearchService.Stub.DESCRIPTOR);
            }

            @Override // com.google.android.apps.gsa.publicsearch.IPublicSearchService
            public com.google.android.apps.gsa.publicsearch.IPublicSearchServiceSession beginSession(java.lang.String str, com.google.android.apps.gsa.publicsearch.IPublicSearchServiceSessionCallback iPublicSearchServiceSessionCallback, byte[] bArr) throws android.os.RemoteException {
                android.os.Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                parcelObtainAndWriteInterfaceToken.writeString(str);
                com.google.android.aidl.Codecs.writeStrongBinder(parcelObtainAndWriteInterfaceToken, iPublicSearchServiceSessionCallback);
                parcelObtainAndWriteInterfaceToken.writeByteArray(bArr);
                android.os.Parcel parcelTransactAndReadException = transactAndReadException(1, parcelObtainAndWriteInterfaceToken);
                com.google.android.apps.gsa.publicsearch.IPublicSearchServiceSession iPublicSearchServiceSessionAsInterface = com.google.android.apps.gsa.publicsearch.IPublicSearchServiceSession.Stub.asInterface(parcelTransactAndReadException.readStrongBinder());
                parcelTransactAndReadException.recycle();
                return iPublicSearchServiceSessionAsInterface;
            }
        }
    }
}
