package com.oplus.gallery.bitmap;

/* loaded from: classes2.dex */
public interface ICameraTransBitmap extends android.os.IInterface {

    public static class Default implements com.oplus.gallery.bitmap.ICameraTransBitmap {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.oplus.gallery.bitmap.ICameraTransBitmap
        public java.util.Map<java.lang.String, android.graphics.Bitmap> b_renamed() throws android.os.RemoteException {
            return null;
        }
    }

    java.util.Map<java.lang.String, android.graphics.Bitmap> b_renamed() throws android.os.RemoteException;

    public static abstract class Stub extends android.os.Binder implements com.oplus.gallery.bitmap.ICameraTransBitmap {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.oplus.gallery.bitmap.ICameraTransBitmap");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a_renamed(android.os.Parcel parcel, java.lang.String str, android.graphics.Bitmap bitmap) {
            parcel.writeString(str);
            if (bitmap != null) {
                parcel.writeInt(1);
                bitmap.writeToParcel(parcel, 1);
            } else {
                parcel.writeInt(0);
            }
        }

        @Override // android.os.Binder
        public boolean onTransact(int i_renamed, android.os.Parcel parcel, final android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i_renamed == 1598968902) {
                parcel2.writeString("com.oplus.gallery.bitmap.ICameraTransBitmap");
                return true;
            }
            if (i_renamed == 1) {
                parcel.enforceInterface("com.oplus.gallery.bitmap.ICameraTransBitmap");
                java.util.Map<java.lang.String, android.graphics.Bitmap> mapB = b_renamed();
                parcel2.writeNoException();
                if (mapB == null) {
                    parcel2.writeInt(-1);
                } else {
                    parcel2.writeInt(mapB.size());
                    mapB.forEach(new java.util.function.BiConsumer() { // from class: com.oplus.gallery.bitmap.-$$Lambda$ICameraTransBitmap$Stub$PvuMtMJF5-q5c8fSsGQy225h-48
                        @Override // java.util.function.BiConsumer
                        public final void accept(java.lang.Object obj, java.lang.Object obj2) {
                            com.oplus.gallery.bitmap.ICameraTransBitmap.Stub.a_renamed(parcel2, (java.lang.String) obj, (android.graphics.Bitmap) obj2);
                        }
                    });
                }
                return true;
            }
            return super.onTransact(i_renamed, parcel, parcel2, i2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        static class Proxy implements com.oplus.gallery.bitmap.ICameraTransBitmap {

            /* renamed from: a_renamed, reason: collision with root package name */
            public static com.oplus.gallery.bitmap.ICameraTransBitmap f7502a;

            /* renamed from: b_renamed, reason: collision with root package name */
            private android.os.IBinder f7503b;

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.f7503b;
            }

            @Override // com.oplus.gallery.bitmap.ICameraTransBitmap
            public java.util.Map<java.lang.String, android.graphics.Bitmap> b_renamed() throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                final android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.oplus.gallery.bitmap.ICameraTransBitmap");
                    if (!this.f7503b.transact(1, parcelObtain, parcelObtain2, 0) && com.oplus.gallery.bitmap.ICameraTransBitmap.Stub.c_renamed() != null) {
                        return com.oplus.gallery.bitmap.ICameraTransBitmap.Stub.c_renamed().b_renamed();
                    }
                    parcelObtain2.readException();
                    int i_renamed = parcelObtain2.readInt();
                    final java.util.HashMap map = i_renamed < 0 ? null : new java.util.HashMap();
                    java.util.stream.IntStream.range(0, i_renamed).forEach(new java.util.function.IntConsumer() { // from class: com.oplus.gallery.bitmap.-$$Lambda$ICameraTransBitmap$Stub$Proxy$9GjBTDcsqv9NmtIOqnhMOhXBmjw
                        @Override // java.util.function.IntConsumer
                        public final void accept(int i2) {
                            com.oplus.gallery.bitmap.ICameraTransBitmap.Stub.Proxy.a_renamed(parcelObtain2, map, i2);
                        }
                    });
                    return map;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void a_renamed(android.os.Parcel parcel, java.util.Map map, int i_renamed) {
                map.put(parcel.readString(), parcel.readInt() != 0 ? (android.graphics.Bitmap) android.graphics.Bitmap.CREATOR.createFromParcel(parcel) : null);
            }
        }

        public static com.oplus.gallery.bitmap.ICameraTransBitmap c_renamed() {
            return com.oplus.gallery.bitmap.ICameraTransBitmap.Stub.Proxy.f7502a;
        }
    }
}
