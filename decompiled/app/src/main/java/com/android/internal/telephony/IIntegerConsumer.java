package com.android.internal.telephony;

/* loaded from: classes.dex */
public interface IIntegerConsumer extends android.os.IInterface {
    public static final java.lang.String DESCRIPTOR = "com.android.internal.telephony.IIntegerConsumer";

    public static class Default implements com.android.internal.telephony.IIntegerConsumer {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends android.os.Binder implements com.android.internal.telephony.IIntegerConsumer {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, com.android.internal.telephony.IIntegerConsumer.DESCRIPTOR);
        }

        public static com.android.internal.telephony.IIntegerConsumer asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(com.android.internal.telephony.IIntegerConsumer.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof com.android.internal.telephony.IIntegerConsumer)) {
                return (com.android.internal.telephony.IIntegerConsumer) iInterfaceQueryLocalInterface;
            }
            return new com.android.internal.telephony.IIntegerConsumer.Stub.Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i_renamed, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i_renamed == 1598968902) {
                parcel2.writeString(com.android.internal.telephony.IIntegerConsumer.DESCRIPTOR);
                return true;
            }
            return super.onTransact(i_renamed, parcel, parcel2, i2);
        }

        private static class Proxy implements com.android.internal.telephony.IIntegerConsumer {
            public static com.android.internal.telephony.IIntegerConsumer sDefaultImpl;
            private android.os.IBinder mRemote;

            public java.lang.String getInterfaceDescriptor() {
                return com.android.internal.telephony.IIntegerConsumer.DESCRIPTOR;
            }

            Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }
        }

        public static boolean setDefaultImpl(com.android.internal.telephony.IIntegerConsumer iIntegerConsumer) {
            if (com.android.internal.telephony.IIntegerConsumer.Stub.Proxy.sDefaultImpl != null) {
                throw new java.lang.IllegalStateException("setDefaultImpl() called twice");
            }
            if (iIntegerConsumer == null) {
                return false;
            }
            com.android.internal.telephony.IIntegerConsumer.Stub.Proxy.sDefaultImpl = iIntegerConsumer;
            return true;
        }

        public static com.android.internal.telephony.IIntegerConsumer getDefaultImpl() {
            return com.android.internal.telephony.IIntegerConsumer.Stub.Proxy.sDefaultImpl;
        }
    }
}
