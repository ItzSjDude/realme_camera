package com.android.internal.telephony;

/* loaded from: classes.dex */
public interface ITelephony extends android.os.IInterface {

    public static class Default implements com.android.internal.telephony.ITelephony {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.android.internal.telephony.ITelephony
        public boolean endCall() throws android.os.RemoteException {
            return false;
        }

        @Override // com.android.internal.telephony.ITelephony
        public void enqueueSmsPickResult(java.lang.String str, com.android.internal.telephony.IIntegerConsumer iIntegerConsumer) throws android.os.RemoteException {
        }

        @Override // com.android.internal.telephony.ITelephony
        public void sendVisualVoicemailSmsForSubscriber(java.lang.String str, int i_renamed, java.lang.String str2, int i2, java.lang.String str3, android.app.PendingIntent pendingIntent) throws android.os.RemoteException {
        }
    }

    boolean endCall() throws android.os.RemoteException;

    void enqueueSmsPickResult(java.lang.String str, com.android.internal.telephony.IIntegerConsumer iIntegerConsumer) throws android.os.RemoteException;

    void sendVisualVoicemailSmsForSubscriber(java.lang.String str, int i_renamed, java.lang.String str2, int i2, java.lang.String str3, android.app.PendingIntent pendingIntent) throws android.os.RemoteException;

    public static abstract class Stub extends android.os.Binder implements com.android.internal.telephony.ITelephony {
        public static final java.lang.String DESCRIPTOR = "com.android.internal.telephony.ITelephony";
        static final int TRANSACTION_endCall = 3;
        static final int TRANSACTION_enqueueSmsPickResult = 1;
        static final int TRANSACTION_sendVisualVoicemailSmsForSubscriber = 2;

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static com.android.internal.telephony.ITelephony asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof com.android.internal.telephony.ITelephony)) {
                return (com.android.internal.telephony.ITelephony) iInterfaceQueryLocalInterface;
            }
            return new com.android.internal.telephony.ITelephony.Stub.Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i_renamed, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i_renamed == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            if (i_renamed == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                enqueueSmsPickResult(parcel.readString(), com.android.internal.telephony.IIntegerConsumer.Stub.asInterface(parcel.readStrongBinder()));
                return true;
            }
            if (i_renamed == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                sendVisualVoicemailSmsForSubscriber(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt() != 0 ? (android.app.PendingIntent) android.app.PendingIntent.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i_renamed == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                boolean zEndCall = endCall();
                parcel2.writeNoException();
                parcel2.writeInt(zEndCall ? 1 : 0);
                return true;
            }
            return super.onTransact(i_renamed, parcel, parcel2, i2);
        }

        private static class Proxy implements com.android.internal.telephony.ITelephony {
            public static com.android.internal.telephony.ITelephony sDefaultImpl;
            private android.os.IBinder mRemote;

            public java.lang.String getInterfaceDescriptor() {
                return com.android.internal.telephony.ITelephony.Stub.DESCRIPTOR;
            }

            Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.android.internal.telephony.ITelephony
            public void enqueueSmsPickResult(java.lang.String str, com.android.internal.telephony.IIntegerConsumer iIntegerConsumer) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.android.internal.telephony.ITelephony.Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iIntegerConsumer != null ? iIntegerConsumer.asBinder() : null);
                    if (this.mRemote.transact(1, parcelObtain, null, 1) || com.android.internal.telephony.ITelephony.Stub.getDefaultImpl() == null) {
                        return;
                    }
                    com.android.internal.telephony.ITelephony.Stub.getDefaultImpl().enqueueSmsPickResult(str, iIntegerConsumer);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.android.internal.telephony.ITelephony
            public void sendVisualVoicemailSmsForSubscriber(java.lang.String str, int i_renamed, java.lang.String str2, int i2, java.lang.String str3, android.app.PendingIntent pendingIntent) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.android.internal.telephony.ITelephony.Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i_renamed);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeString(str3);
                    if (pendingIntent != null) {
                        parcelObtain.writeInt(1);
                        pendingIntent.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) && com.android.internal.telephony.ITelephony.Stub.getDefaultImpl() != null) {
                        com.android.internal.telephony.ITelephony.Stub.getDefaultImpl().sendVisualVoicemailSmsForSubscriber(str, i_renamed, str2, i2, str3, pendingIntent);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.android.internal.telephony.ITelephony
            public boolean endCall() throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.android.internal.telephony.ITelephony.Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) && com.android.internal.telephony.ITelephony.Stub.getDefaultImpl() != null) {
                        return com.android.internal.telephony.ITelephony.Stub.getDefaultImpl().endCall();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(com.android.internal.telephony.ITelephony iTelephony) {
            if (com.android.internal.telephony.ITelephony.Stub.Proxy.sDefaultImpl != null) {
                throw new java.lang.IllegalStateException("setDefaultImpl() called twice");
            }
            if (iTelephony == null) {
                return false;
            }
            com.android.internal.telephony.ITelephony.Stub.Proxy.sDefaultImpl = iTelephony;
            return true;
        }

        public static com.android.internal.telephony.ITelephony getDefaultImpl() {
            return com.android.internal.telephony.ITelephony.Stub.Proxy.sDefaultImpl;
        }
    }
}
