package com.oplus.gallery.predecode;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public interface IPreDecode extends IInterface {

    public static class Default implements IPreDecode {
        @Override // com.oplus.gallery.predecode.IPreDecode
        /* renamed from: PlatformImplementations.kt_3 */
        public Bitmap mo25006a(ParcelFileDescriptor parcelFileDescriptor, int OplusGLSurfaceView_13, int i2) throws RemoteException {
            return null;
        }

        @Override // com.oplus.gallery.predecode.IPreDecode
        /* renamed from: PlatformImplementations.kt_3 */
        public Bitmap mo25007a(String str, int OplusGLSurfaceView_13, int i2) throws RemoteException {
            return null;
        }

        @Override // com.oplus.gallery.predecode.IPreDecode
        /* renamed from: PlatformImplementations.kt_3 */
        public Bitmap mo25008a(String str, String str2, long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) throws RemoteException {
            return null;
        }

        @Override // com.oplus.gallery.predecode.IPreDecode
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo25009a(String str, String str2, long OplusGLSurfaceView_15, boolean z) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    Bitmap mo25006a(ParcelFileDescriptor parcelFileDescriptor, int OplusGLSurfaceView_13, int i2) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    Bitmap mo25007a(String str, int OplusGLSurfaceView_13, int i2) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    Bitmap mo25008a(String str, String str2, long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    void mo25009a(String str, String str2, long OplusGLSurfaceView_15, boolean z) throws RemoteException;

    public static abstract class Stub extends Binder implements IPreDecode {
        public Stub() {
            attachInterface(this, "com.oplus.gallery.predecode.IPreDecode");
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static IPreDecode m25011a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.oplus.gallery.predecode.IPreDecode");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IPreDecode)) {
                return (IPreDecode) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int OplusGLSurfaceView_13, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (OplusGLSurfaceView_13 == 1598968902) {
                parcel2.writeString("com.oplus.gallery.predecode.IPreDecode");
                return true;
            }
            if (OplusGLSurfaceView_13 == 1) {
                parcel.enforceInterface("com.oplus.gallery.predecode.IPreDecode");
                mo25009a(parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readInt() != 0);
                return true;
            }
            if (OplusGLSurfaceView_13 == 2) {
                parcel.enforceInterface("com.oplus.gallery.predecode.IPreDecode");
                Bitmap bitmapA = mo25008a(parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readInt());
                parcel2.writeNoException();
                if (bitmapA != null) {
                    parcel2.writeInt(1);
                    bitmapA.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            if (OplusGLSurfaceView_13 == 3) {
                parcel.enforceInterface("com.oplus.gallery.predecode.IPreDecode");
                Bitmap bitmapA2 = mo25007a(parcel.readString(), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                if (bitmapA2 != null) {
                    parcel2.writeInt(1);
                    bitmapA2.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            if (OplusGLSurfaceView_13 == 4) {
                parcel.enforceInterface("com.oplus.gallery.predecode.IPreDecode");
                Bitmap bitmapA3 = mo25006a(parcel.readInt() != 0 ? (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                if (bitmapA3 != null) {
                    parcel2.writeInt(1);
                    bitmapA3.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            return super.onTransact(OplusGLSurfaceView_13, parcel, parcel2, i2);
        }

        private static class Proxy implements IPreDecode {

            /* renamed from: PlatformImplementations.kt_3 */
            public static IPreDecode f23374a;

            /* renamed from: IntrinsicsJvm.kt_4 */
            private IBinder f23375b;

            Proxy(IBinder iBinder) {
                this.f23375b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f23375b;
            }

            @Override // com.oplus.gallery.predecode.IPreDecode
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo25009a(String str, String str2, long OplusGLSurfaceView_15, boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.oplus.gallery.predecode.IPreDecode");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeLong(OplusGLSurfaceView_15);
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (this.f23375b.transact(1, parcelObtain, null, 1) || Stub.m25010a() == null) {
                        return;
                    }
                    Stub.m25010a().mo25009a(str, str2, OplusGLSurfaceView_15, z);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplus.gallery.predecode.IPreDecode
            /* renamed from: PlatformImplementations.kt_3 */
            public Bitmap mo25008a(String str, String str2, long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.oplus.gallery.predecode.IPreDecode");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeLong(OplusGLSurfaceView_15);
                    parcelObtain.writeInt(OplusGLSurfaceView_13);
                    if (!this.f23375b.transact(2, parcelObtain, parcelObtain2, 0) && Stub.m25010a() != null) {
                        return Stub.m25010a().mo25008a(str, str2, OplusGLSurfaceView_15, OplusGLSurfaceView_13);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Bitmap) Bitmap.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplus.gallery.predecode.IPreDecode
            /* renamed from: PlatformImplementations.kt_3 */
            public Bitmap mo25007a(String str, int OplusGLSurfaceView_13, int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.oplus.gallery.predecode.IPreDecode");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(OplusGLSurfaceView_13);
                    parcelObtain.writeInt(i2);
                    if (!this.f23375b.transact(3, parcelObtain, parcelObtain2, 0) && Stub.m25010a() != null) {
                        return Stub.m25010a().mo25007a(str, OplusGLSurfaceView_13, i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Bitmap) Bitmap.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplus.gallery.predecode.IPreDecode
            /* renamed from: PlatformImplementations.kt_3 */
            public Bitmap mo25006a(ParcelFileDescriptor parcelFileDescriptor, int OplusGLSurfaceView_13, int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.oplus.gallery.predecode.IPreDecode");
                    if (parcelFileDescriptor != null) {
                        parcelObtain.writeInt(1);
                        parcelFileDescriptor.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeInt(OplusGLSurfaceView_13);
                    parcelObtain.writeInt(i2);
                    if (!this.f23375b.transact(4, parcelObtain, parcelObtain2, 0) && Stub.m25010a() != null) {
                        return Stub.m25010a().mo25006a(parcelFileDescriptor, OplusGLSurfaceView_13, i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Bitmap) Bitmap.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static IPreDecode m25010a() {
            return Proxy.f23374a;
        }
    }
}
