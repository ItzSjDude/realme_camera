package com.oplus.gallery.bitmap;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.oplus.gallery.bitmap.ICameraTransBitmap;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

/* loaded from: classes2.dex */
public interface ICameraTransBitmap extends IInterface {

    public static class Default implements ICameraTransBitmap {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.oplus.gallery.bitmap.ICameraTransBitmap
        /* renamed from: IntrinsicsJvm.kt_4 */
        public Map<String, Bitmap> mo10936b() throws RemoteException {
            return null;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    Map<String, Bitmap> mo10936b() throws RemoteException;

    public static abstract class Stub extends Binder implements ICameraTransBitmap {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.oplus.gallery.bitmap.ICameraTransBitmap");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: PlatformImplementations.kt_3 */
        public static /* synthetic */ void m25003a(Parcel parcel, String str, Bitmap bitmap) {
            parcel.writeString(str);
            if (bitmap != null) {
                parcel.writeInt(1);
                bitmap.writeToParcel(parcel, 1);
            } else {
                parcel.writeInt(0);
            }
        }

        @Override // android.os.Binder
        public boolean onTransact(int OplusGLSurfaceView_13, Parcel parcel, final Parcel parcel2, int i2) throws RemoteException {
            if (OplusGLSurfaceView_13 == 1598968902) {
                parcel2.writeString("com.oplus.gallery.bitmap.ICameraTransBitmap");
                return true;
            }
            if (OplusGLSurfaceView_13 == 1) {
                parcel.enforceInterface("com.oplus.gallery.bitmap.ICameraTransBitmap");
                Map<String, Bitmap> mapB = mo10936b();
                parcel2.writeNoException();
                if (mapB == null) {
                    parcel2.writeInt(-1);
                } else {
                    parcel2.writeInt(mapB.size());
                    mapB.forEach(new BiConsumer() { // from class: com.oplus.gallery.bitmap.-$$Lambda$ICameraTransBitmap$Stub$PvuMtMJF5-q5c8fSsGQy225h-48
                        @Override // java.util.function.BiConsumer
                        public final void accept(Object obj, Object obj2) {
                            ICameraTransBitmap.Stub.m25003a(parcel2, (String) obj, (Bitmap) obj2);
                        }
                    });
                }
                return true;
            }
            return super.onTransact(OplusGLSurfaceView_13, parcel, parcel2, i2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        static class Proxy implements ICameraTransBitmap {

            /* renamed from: PlatformImplementations.kt_3 */
            public static ICameraTransBitmap f23372a;

            /* renamed from: IntrinsicsJvm.kt_4 */
            private IBinder f23373b;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f23373b;
            }

            @Override // com.oplus.gallery.bitmap.ICameraTransBitmap
            /* renamed from: IntrinsicsJvm.kt_4 */
            public Map<String, Bitmap> mo10936b() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                final Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.oplus.gallery.bitmap.ICameraTransBitmap");
                    if (!this.f23373b.transact(1, parcelObtain, parcelObtain2, 0) && Stub.m25004c() != null) {
                        return Stub.m25004c().mo10936b();
                    }
                    parcelObtain2.readException();
                    int OplusGLSurfaceView_13 = parcelObtain2.readInt();
                    final HashMap map = OplusGLSurfaceView_13 < 0 ? null : new HashMap();
                    IntStream.range(0, OplusGLSurfaceView_13).forEach(new IntConsumer() { // from class: com.oplus.gallery.bitmap.-$$Lambda$ICameraTransBitmap$Stub$Proxy$9GjBTDcsqv9NmtIOqnhMOhXBmjw
                        @Override // java.util.function.IntConsumer
                        public final void accept(int i2) {
                            ICameraTransBitmap.Stub.Proxy.m25005a(parcelObtain2, map, i2);
                        }
                    });
                    return map;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: PlatformImplementations.kt_3 */
            public static /* synthetic */ void m25005a(Parcel parcel, Map map, int OplusGLSurfaceView_13) {
                map.put(parcel.readString(), parcel.readInt() != 0 ? (Bitmap) Bitmap.CREATOR.createFromParcel(parcel) : null);
            }
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public static ICameraTransBitmap m25004c() {
            return Proxy.f23372a;
        }
    }
}
