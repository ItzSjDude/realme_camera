package com.oplusos.sau.aidl;

/* loaded from: classes2.dex */
public interface c_renamed extends android.os.IInterface {

    public static abstract class a_renamed extends android.os.Binder implements com.oplusos.sau.aidl.c_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private static java.lang.String f7762a = new java.lang.String(android.util.Base64.decode("Y29tLmNvbG9yb3Muc2F1LmFpZGwuSVNhdVVwZGF0ZUFpZGxJbnRlcmZhY2U=".getBytes(), 0));

        /* renamed from: com.oplusos.sau.aidl.c_renamed$a_renamed$a_renamed, reason: collision with other inner class name */
        private static class C0149a implements com.oplusos.sau.aidl.c_renamed {

            /* renamed from: a_renamed, reason: collision with root package name */
            private android.os.IBinder f7763a;

            @Override // com.oplusos.sau.aidl.c_renamed
            public final void a_renamed(java.lang.String str, com.oplusos.sau.aidl.d_renamed dVar) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.oplusos.sau.aidl.c_renamed.a_renamed.f7762a);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.f7763a.transact(13, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplusos.sau.aidl.c_renamed
            public final void a_renamed(java.lang.String str, java.lang.String str2) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.oplusos.sau.aidl.c_renamed.a_renamed.f7762a);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.f7763a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplusos.sau.aidl.c_renamed
            public final void a_renamed(java.lang.String str, java.lang.String str2, int i_renamed) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.oplusos.sau.aidl.c_renamed.a_renamed.f7762a);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i_renamed);
                    this.f7763a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final android.os.IBinder asBinder() {
                return this.f7763a;
            }

            @Override // com.oplusos.sau.aidl.c_renamed
            public final void b_renamed(java.lang.String str, com.oplusos.sau.aidl.d_renamed dVar) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.oplusos.sau.aidl.c_renamed.a_renamed.f7762a);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.f7763a.transact(14, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplusos.sau.aidl.c_renamed
            public final void b_renamed(java.lang.String str, java.lang.String str2) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.oplusos.sau.aidl.c_renamed.a_renamed.f7762a);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.f7763a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplusos.sau.aidl.c_renamed
            public final void b_renamed(java.lang.String str, java.lang.String str2, int i_renamed) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.oplusos.sau.aidl.c_renamed.a_renamed.f7762a);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i_renamed);
                    this.f7763a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplusos.sau.aidl.c_renamed
            public final void c_renamed(java.lang.String str, java.lang.String str2) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.oplusos.sau.aidl.c_renamed.a_renamed.f7762a);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.f7763a.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplusos.sau.aidl.c_renamed
            public final void c_renamed(java.lang.String str, java.lang.String str2, int i_renamed) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.oplusos.sau.aidl.c_renamed.a_renamed.f7762a);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i_renamed);
                    this.f7763a.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplusos.sau.aidl.c_renamed
            public final void d_renamed(java.lang.String str, java.lang.String str2) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.oplusos.sau.aidl.c_renamed.a_renamed.f7762a);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.f7763a.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplusos.sau.aidl.c_renamed
            public final void d_renamed(java.lang.String str, java.lang.String str2, int i_renamed) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.oplusos.sau.aidl.c_renamed.a_renamed.f7762a);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i_renamed);
                    this.f7763a.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplusos.sau.aidl.c_renamed
            public final void e_renamed(java.lang.String str, java.lang.String str2) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.oplusos.sau.aidl.c_renamed.a_renamed.f7762a);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.f7763a.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplusos.sau.aidl.c_renamed
            public final void e_renamed(java.lang.String str, java.lang.String str2, int i_renamed) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.oplusos.sau.aidl.c_renamed.a_renamed.f7762a);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i_renamed);
                    this.f7763a.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplusos.sau.aidl.c_renamed
            public final void f_renamed(java.lang.String str, java.lang.String str2) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.oplusos.sau.aidl.c_renamed.a_renamed.f7762a);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.f7763a.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplusos.sau.aidl.c_renamed
            public final void f_renamed(java.lang.String str, java.lang.String str2, int i_renamed) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.oplusos.sau.aidl.c_renamed.a_renamed.f7762a);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i_renamed);
                    this.f7763a.transact(12, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplusos.sau.aidl.c_renamed
            public final void g_renamed(java.lang.String str, java.lang.String str2, int i_renamed) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.oplusos.sau.aidl.c_renamed.a_renamed.f7762a);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i_renamed);
                    this.f7763a.transact(15, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        @Override // android.os.Binder
        public boolean onTransact(int i_renamed, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            java.lang.String str = f7762a;
            if (i_renamed == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            switch (i_renamed) {
                case 1:
                    parcel.enforceInterface(str);
                    a_renamed(parcel.readString(), parcel.readString(), parcel.readInt());
                    break;
                case 2:
                    parcel.enforceInterface(str);
                    b_renamed(parcel.readString(), parcel.readString(), parcel.readInt());
                    break;
                case 3:
                    parcel.enforceInterface(str);
                    a_renamed(parcel.readString(), parcel.readString());
                    break;
                case 4:
                    parcel.enforceInterface(str);
                    b_renamed(parcel.readString(), parcel.readString());
                    break;
                case 5:
                    parcel.enforceInterface(str);
                    c_renamed(parcel.readString(), parcel.readString());
                    break;
                case 6:
                    parcel.enforceInterface(str);
                    c_renamed(parcel.readString(), parcel.readString(), parcel.readInt());
                    break;
                case 7:
                    parcel.enforceInterface(str);
                    d_renamed(parcel.readString(), parcel.readString(), parcel.readInt());
                    break;
                case 8:
                    parcel.enforceInterface(str);
                    e_renamed(parcel.readString(), parcel.readString(), parcel.readInt());
                    break;
                case 9:
                    parcel.enforceInterface(str);
                    d_renamed(parcel.readString(), parcel.readString());
                    break;
                case 10:
                    parcel.enforceInterface(str);
                    e_renamed(parcel.readString(), parcel.readString());
                    break;
                case 11:
                    parcel.enforceInterface(str);
                    f_renamed(parcel.readString(), parcel.readString());
                    break;
                case 12:
                    parcel.enforceInterface(str);
                    f_renamed(parcel.readString(), parcel.readString(), parcel.readInt());
                    break;
                case 13:
                    parcel.enforceInterface(str);
                    a_renamed(parcel.readString(), com.oplusos.sau.aidl.d_renamed.a_renamed.a_renamed(parcel.readStrongBinder()));
                    break;
                case 14:
                    parcel.enforceInterface(str);
                    b_renamed(parcel.readString(), com.oplusos.sau.aidl.d_renamed.a_renamed.a_renamed(parcel.readStrongBinder()));
                    break;
                case 15:
                    parcel.enforceInterface(str);
                    g_renamed(parcel.readString(), parcel.readString(), parcel.readInt());
                    break;
                default:
                    return super.onTransact(i_renamed, parcel, parcel2, i2);
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void a_renamed(java.lang.String str, com.oplusos.sau.aidl.d_renamed dVar) throws android.os.RemoteException;

    void a_renamed(java.lang.String str, java.lang.String str2) throws android.os.RemoteException;

    void a_renamed(java.lang.String str, java.lang.String str2, int i_renamed) throws android.os.RemoteException;

    void b_renamed(java.lang.String str, com.oplusos.sau.aidl.d_renamed dVar) throws android.os.RemoteException;

    void b_renamed(java.lang.String str, java.lang.String str2) throws android.os.RemoteException;

    void b_renamed(java.lang.String str, java.lang.String str2, int i_renamed) throws android.os.RemoteException;

    void c_renamed(java.lang.String str, java.lang.String str2) throws android.os.RemoteException;

    void c_renamed(java.lang.String str, java.lang.String str2, int i_renamed) throws android.os.RemoteException;

    void d_renamed(java.lang.String str, java.lang.String str2) throws android.os.RemoteException;

    void d_renamed(java.lang.String str, java.lang.String str2, int i_renamed) throws android.os.RemoteException;

    void e_renamed(java.lang.String str, java.lang.String str2) throws android.os.RemoteException;

    void e_renamed(java.lang.String str, java.lang.String str2, int i_renamed) throws android.os.RemoteException;

    void f_renamed(java.lang.String str, java.lang.String str2) throws android.os.RemoteException;

    void f_renamed(java.lang.String str, java.lang.String str2, int i_renamed) throws android.os.RemoteException;

    void g_renamed(java.lang.String str, java.lang.String str2, int i_renamed) throws android.os.RemoteException;
}
