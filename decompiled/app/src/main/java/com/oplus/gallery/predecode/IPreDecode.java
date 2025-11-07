package com.oplus.gallery.predecode;

/* loaded from: classes2.dex */
public interface IPreDecode extends android.os.IInterface {

    public static class Default implements com.oplus.gallery.predecode.IPreDecode {
        @Override // com.oplus.gallery.predecode.IPreDecode
        public android.graphics.Bitmap a_renamed(android.os.ParcelFileDescriptor parcelFileDescriptor, int i_renamed, int i2) throws android.os.RemoteException {
            return null;
        }

        @Override // com.oplus.gallery.predecode.IPreDecode
        public android.graphics.Bitmap a_renamed(java.lang.String str, int i_renamed, int i2) throws android.os.RemoteException {
            return null;
        }

        @Override // com.oplus.gallery.predecode.IPreDecode
        public android.graphics.Bitmap a_renamed(java.lang.String str, java.lang.String str2, long j_renamed, int i_renamed) throws android.os.RemoteException {
            return null;
        }

        @Override // com.oplus.gallery.predecode.IPreDecode
        public void a_renamed(java.lang.String str, java.lang.String str2, long j_renamed, boolean z_renamed) throws android.os.RemoteException {
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }
    }

    android.graphics.Bitmap a_renamed(android.os.ParcelFileDescriptor parcelFileDescriptor, int i_renamed, int i2) throws android.os.RemoteException;

    android.graphics.Bitmap a_renamed(java.lang.String str, int i_renamed, int i2) throws android.os.RemoteException;

    android.graphics.Bitmap a_renamed(java.lang.String str, java.lang.String str2, long j_renamed, int i_renamed) throws android.os.RemoteException;

    void a_renamed(java.lang.String str, java.lang.String str2, long j_renamed, boolean z_renamed) throws android.os.RemoteException;

    public static abstract class Stub extends android.os.Binder implements com.oplus.gallery.predecode.IPreDecode {
        public Stub() {
            attachInterface(this, "com.oplus.gallery.predecode.IPreDecode");
        }

        public static com.oplus.gallery.predecode.IPreDecode a_renamed(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.oplus.gallery.predecode.IPreDecode");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof com.oplus.gallery.predecode.IPreDecode)) {
                return (com.oplus.gallery.predecode.IPreDecode) iInterfaceQueryLocalInterface;
            }
            return new com.oplus.gallery.predecode.IPreDecode.Stub.Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i_renamed, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i_renamed == 1598968902) {
                parcel2.writeString("com.oplus.gallery.predecode.IPreDecode");
                return true;
            }
            if (i_renamed == 1) {
                parcel.enforceInterface("com.oplus.gallery.predecode.IPreDecode");
                a_renamed(parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readInt() != 0);
                return true;
            }
            if (i_renamed == 2) {
                parcel.enforceInterface("com.oplus.gallery.predecode.IPreDecode");
                android.graphics.Bitmap bitmapA = a_renamed(parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readInt());
                parcel2.writeNoException();
                if (bitmapA != null) {
                    parcel2.writeInt(1);
                    bitmapA.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            if (i_renamed == 3) {
                parcel.enforceInterface("com.oplus.gallery.predecode.IPreDecode");
                android.graphics.Bitmap bitmapA2 = a_renamed(parcel.readString(), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                if (bitmapA2 != null) {
                    parcel2.writeInt(1);
                    bitmapA2.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            if (i_renamed == 4) {
                parcel.enforceInterface("com.oplus.gallery.predecode.IPreDecode");
                android.graphics.Bitmap bitmapA3 = a_renamed(parcel.readInt() != 0 ? (android.os.ParcelFileDescriptor) android.os.ParcelFileDescriptor.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                if (bitmapA3 != null) {
                    parcel2.writeInt(1);
                    bitmapA3.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            return super.onTransact(i_renamed, parcel, parcel2, i2);
        }

        private static class Proxy implements com.oplus.gallery.predecode.IPreDecode {

            /* renamed from: a_renamed, reason: collision with root package name */
            public static com.oplus.gallery.predecode.IPreDecode f7504a;

            /* renamed from: b_renamed, reason: collision with root package name */
            private android.os.IBinder f7505b;

            Proxy(android.os.IBinder iBinder) {
                this.f7505b = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.f7505b;
            }

            @Override // com.oplus.gallery.predecode.IPreDecode
            public void a_renamed(java.lang.String str, java.lang.String str2, long j_renamed, boolean z_renamed) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.oplus.gallery.predecode.IPreDecode");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeLong(j_renamed);
                    parcelObtain.writeInt(z_renamed ? 1 : 0);
                    if (this.f7505b.transact(1, parcelObtain, null, 1) || com.oplus.gallery.predecode.IPreDecode.Stub.a_renamed() == null) {
                        return;
                    }
                    com.oplus.gallery.predecode.IPreDecode.Stub.a_renamed().a_renamed(str, str2, j_renamed, z_renamed);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplus.gallery.predecode.IPreDecode
            public android.graphics.Bitmap a_renamed(java.lang.String str, java.lang.String str2, long j_renamed, int i_renamed) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.oplus.gallery.predecode.IPreDecode");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeLong(j_renamed);
                    parcelObtain.writeInt(i_renamed);
                    if (!this.f7505b.transact(2, parcelObtain, parcelObtain2, 0) && com.oplus.gallery.predecode.IPreDecode.Stub.a_renamed() != null) {
                        return com.oplus.gallery.predecode.IPreDecode.Stub.a_renamed().a_renamed(str, str2, j_renamed, i_renamed);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (android.graphics.Bitmap) android.graphics.Bitmap.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplus.gallery.predecode.IPreDecode
            public android.graphics.Bitmap a_renamed(java.lang.String str, int i_renamed, int i2) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.oplus.gallery.predecode.IPreDecode");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i_renamed);
                    parcelObtain.writeInt(i2);
                    if (!this.f7505b.transact(3, parcelObtain, parcelObtain2, 0) && com.oplus.gallery.predecode.IPreDecode.Stub.a_renamed() != null) {
                        return com.oplus.gallery.predecode.IPreDecode.Stub.a_renamed().a_renamed(str, i_renamed, i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (android.graphics.Bitmap) android.graphics.Bitmap.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplus.gallery.predecode.IPreDecode
            public android.graphics.Bitmap a_renamed(android.os.ParcelFileDescriptor parcelFileDescriptor, int i_renamed, int i2) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.oplus.gallery.predecode.IPreDecode");
                    if (parcelFileDescriptor != null) {
                        parcelObtain.writeInt(1);
                        parcelFileDescriptor.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeInt(i_renamed);
                    parcelObtain.writeInt(i2);
                    if (!this.f7505b.transact(4, parcelObtain, parcelObtain2, 0) && com.oplus.gallery.predecode.IPreDecode.Stub.a_renamed() != null) {
                        return com.oplus.gallery.predecode.IPreDecode.Stub.a_renamed().a_renamed(parcelFileDescriptor, i_renamed, i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (android.graphics.Bitmap) android.graphics.Bitmap.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static com.oplus.gallery.predecode.IPreDecode a_renamed() {
            return com.oplus.gallery.predecode.IPreDecode.Stub.Proxy.f7504a;
        }
    }
}
