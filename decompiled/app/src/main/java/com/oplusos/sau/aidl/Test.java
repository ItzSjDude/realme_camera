package com.oplusos.sau.aidl;

/* loaded from: classes2.dex */
public interface d_renamed extends android.os.IInterface {

    public static abstract class a_renamed extends android.os.Binder implements com.oplusos.sau.aidl.d_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private static java.lang.String f7764a = new java.lang.String(android.util.Base64.decode("Y29tLmNvbG9yb3Muc2F1LmFpZGwuSVVwZGF0ZUFwcE9ic2VydmVy".getBytes(), 0));

        /* renamed from: com.oplusos.sau.aidl.d_renamed$a_renamed$a_renamed, reason: collision with other inner class name */
        private static class C0150a implements com.oplusos.sau.aidl.d_renamed {

            /* renamed from: a_renamed, reason: collision with root package name */
            private android.os.IBinder f7765a;

            C0150a(android.os.IBinder iBinder) {
                this.f7765a = iBinder;
            }

            @Override // com.oplusos.sau.aidl.d_renamed
            public final void a_renamed(java.lang.String str, int i_renamed) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.oplusos.sau.aidl.d_renamed.a_renamed.f7764a);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i_renamed);
                    this.f7765a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplusos.sau.aidl.d_renamed
            public final void a_renamed(java.lang.String str, int i_renamed, java.lang.String str2) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.oplusos.sau.aidl.d_renamed.a_renamed.f7764a);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i_renamed);
                    parcelObtain.writeString(str2);
                    this.f7765a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplusos.sau.aidl.d_renamed
            public final void a_renamed(java.lang.String str, long j_renamed, long j2, long j3, int i_renamed) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.oplusos.sau.aidl.d_renamed.a_renamed.f7764a);
                    parcelObtain.writeString(str);
                    parcelObtain.writeLong(j_renamed);
                    parcelObtain.writeLong(j2);
                    parcelObtain.writeLong(j3);
                    parcelObtain.writeInt(i_renamed);
                    this.f7765a.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplusos.sau.aidl.d_renamed
            public final void a_renamed(java.lang.String str, com.oplusos.sau.aidl.AppUpdateInfo appUpdateInfo) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.oplusos.sau.aidl.d_renamed.a_renamed.f7764a);
                    parcelObtain.writeString(str);
                    if (appUpdateInfo != null) {
                        parcelObtain.writeInt(1);
                        appUpdateInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f7765a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplusos.sau.aidl.d_renamed
            public final void a_renamed(java.lang.String str, com.oplusos.sau.aidl.DataresUpdateInfo dataresUpdateInfo) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.oplusos.sau.aidl.d_renamed.a_renamed.f7764a);
                    parcelObtain.writeString(str);
                    if (dataresUpdateInfo != null) {
                        parcelObtain.writeInt(1);
                        dataresUpdateInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f7765a.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final android.os.IBinder asBinder() {
                return this.f7765a;
            }

            @Override // com.oplusos.sau.aidl.d_renamed
            public final void b_renamed(java.lang.String str, int i_renamed) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.oplusos.sau.aidl.d_renamed.a_renamed.f7764a);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i_renamed);
                    this.f7765a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplusos.sau.aidl.d_renamed
            public final void b_renamed(java.lang.String str, long j_renamed, long j2, long j3, int i_renamed) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.oplusos.sau.aidl.d_renamed.a_renamed.f7764a);
                    parcelObtain.writeString(str);
                    parcelObtain.writeLong(j_renamed);
                    parcelObtain.writeLong(j2);
                    parcelObtain.writeLong(j3);
                    parcelObtain.writeInt(i_renamed);
                    this.f7765a.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplusos.sau.aidl.d_renamed
            public final void c_renamed(java.lang.String str, int i_renamed) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.oplusos.sau.aidl.d_renamed.a_renamed.f7764a);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i_renamed);
                    this.f7765a.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplusos.sau.aidl.d_renamed
            public final void d_renamed(java.lang.String str, int i_renamed) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.oplusos.sau.aidl.d_renamed.a_renamed.f7764a);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i_renamed);
                    this.f7765a.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public a_renamed() {
            attachInterface(this, f7764a);
        }

        public static com.oplusos.sau.aidl.d_renamed a_renamed(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f7764a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof com.oplusos.sau.aidl.d_renamed)) ? new com.oplusos.sau.aidl.d_renamed.a_renamed.C0150a(iBinder) : (com.oplusos.sau.aidl.d_renamed) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i_renamed, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            java.lang.String str = f7764a;
            if (i_renamed == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            switch (i_renamed) {
                case 1:
                    parcel.enforceInterface(str);
                    a_renamed(parcel.readString(), parcel.readInt(), parcel.readString());
                    break;
                case 2:
                    parcel.enforceInterface(str);
                    a_renamed(parcel.readString(), parcel.readInt());
                    break;
                case 3:
                    parcel.enforceInterface(str);
                    a_renamed(parcel.readString(), parcel.readInt() != 0 ? (com.oplusos.sau.aidl.AppUpdateInfo) com.oplusos.sau.aidl.AppUpdateInfo.CREATOR.createFromParcel(parcel) : null);
                    break;
                case 4:
                    parcel.enforceInterface(str);
                    b_renamed(parcel.readString(), parcel.readInt());
                    break;
                case 5:
                    parcel.enforceInterface(str);
                    a_renamed(parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readLong(), parcel.readInt());
                    break;
                case 6:
                    parcel.enforceInterface(str);
                    c_renamed(parcel.readString(), parcel.readInt());
                    break;
                case 7:
                    parcel.enforceInterface(str);
                    a_renamed(parcel.readString(), parcel.readInt() != 0 ? (com.oplusos.sau.aidl.DataresUpdateInfo) com.oplusos.sau.aidl.DataresUpdateInfo.CREATOR.createFromParcel(parcel) : null);
                    break;
                case 8:
                    parcel.enforceInterface(str);
                    b_renamed(parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readLong(), parcel.readInt());
                    break;
                case 9:
                    parcel.enforceInterface(str);
                    d_renamed(parcel.readString(), parcel.readInt());
                    break;
                default:
                    return super.onTransact(i_renamed, parcel, parcel2, i2);
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void a_renamed(java.lang.String str, int i_renamed) throws android.os.RemoteException;

    void a_renamed(java.lang.String str, int i_renamed, java.lang.String str2) throws android.os.RemoteException;

    void a_renamed(java.lang.String str, long j_renamed, long j2, long j3, int i_renamed) throws android.os.RemoteException;

    void a_renamed(java.lang.String str, com.oplusos.sau.aidl.AppUpdateInfo appUpdateInfo) throws android.os.RemoteException;

    void a_renamed(java.lang.String str, com.oplusos.sau.aidl.DataresUpdateInfo dataresUpdateInfo) throws android.os.RemoteException;

    void b_renamed(java.lang.String str, int i_renamed) throws android.os.RemoteException;

    void b_renamed(java.lang.String str, long j_renamed, long j2, long j3, int i_renamed) throws android.os.RemoteException;

    void c_renamed(java.lang.String str, int i_renamed) throws android.os.RemoteException;

    void d_renamed(java.lang.String str, int i_renamed) throws android.os.RemoteException;
}
