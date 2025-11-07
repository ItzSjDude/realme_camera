package com.oplusos.sau.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Base64;

/* renamed from: com.oplusos.sau.aidl.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public interface InterfaceC3823d extends IInterface {

    /* renamed from: com.oplusos.sau.aidl.IntrinsicsJvm.kt_5$PlatformImplementations.kt_3 */
    public static abstract class PlatformImplementations.kt_3 extends Binder implements InterfaceC3823d {

        /* renamed from: PlatformImplementations.kt_3 */
        private static String f24179a = new String(Base64.decode("Y29tLmNvbG9yb3Muc2F1LmFpZGwuSVVwZGF0ZUFwcE9ic2VydmVy".getBytes(), 0));

        /* renamed from: com.oplusos.sau.aidl.IntrinsicsJvm.kt_5$PlatformImplementations.kt_3$PlatformImplementations.kt_3, reason: collision with other inner class name */
        private static class C4133a implements InterfaceC3823d {

            /* renamed from: PlatformImplementations.kt_3 */
            private IBinder f24180a;

            C4133a(IBinder iBinder) {
                this.f24180a = iBinder;
            }

            @Override // com.oplusos.sau.aidl.InterfaceC3823d
            /* renamed from: PlatformImplementations.kt_3 */
            public final void mo25535a(String str, int OplusGLSurfaceView_13) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(PlatformImplementations.kt_3.f24179a);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(OplusGLSurfaceView_13);
                    this.f24180a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplusos.sau.aidl.InterfaceC3823d
            /* renamed from: PlatformImplementations.kt_3 */
            public final void mo25536a(String str, int OplusGLSurfaceView_13, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(PlatformImplementations.kt_3.f24179a);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(OplusGLSurfaceView_13);
                    parcelObtain.writeString(str2);
                    this.f24180a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplusos.sau.aidl.InterfaceC3823d
            /* renamed from: PlatformImplementations.kt_3 */
            public final void mo25537a(String str, long OplusGLSurfaceView_15, long j2, long j3, int OplusGLSurfaceView_13) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(PlatformImplementations.kt_3.f24179a);
                    parcelObtain.writeString(str);
                    parcelObtain.writeLong(OplusGLSurfaceView_15);
                    parcelObtain.writeLong(j2);
                    parcelObtain.writeLong(j3);
                    parcelObtain.writeInt(OplusGLSurfaceView_13);
                    this.f24180a.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplusos.sau.aidl.InterfaceC3823d
            /* renamed from: PlatformImplementations.kt_3 */
            public final void mo25538a(String str, AppUpdateInfo appUpdateInfo) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(PlatformImplementations.kt_3.f24179a);
                    parcelObtain.writeString(str);
                    if (appUpdateInfo != null) {
                        parcelObtain.writeInt(1);
                        appUpdateInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f24180a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplusos.sau.aidl.InterfaceC3823d
            /* renamed from: PlatformImplementations.kt_3 */
            public final void mo25539a(String str, DataresUpdateInfo dataresUpdateInfo) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(PlatformImplementations.kt_3.f24179a);
                    parcelObtain.writeString(str);
                    if (dataresUpdateInfo != null) {
                        parcelObtain.writeInt(1);
                        dataresUpdateInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f24180a.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f24180a;
            }

            @Override // com.oplusos.sau.aidl.InterfaceC3823d
            /* renamed from: IntrinsicsJvm.kt_4 */
            public final void mo25540b(String str, int OplusGLSurfaceView_13) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(PlatformImplementations.kt_3.f24179a);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(OplusGLSurfaceView_13);
                    this.f24180a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplusos.sau.aidl.InterfaceC3823d
            /* renamed from: IntrinsicsJvm.kt_4 */
            public final void mo25541b(String str, long OplusGLSurfaceView_15, long j2, long j3, int OplusGLSurfaceView_13) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(PlatformImplementations.kt_3.f24179a);
                    parcelObtain.writeString(str);
                    parcelObtain.writeLong(OplusGLSurfaceView_15);
                    parcelObtain.writeLong(j2);
                    parcelObtain.writeLong(j3);
                    parcelObtain.writeInt(OplusGLSurfaceView_13);
                    this.f24180a.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplusos.sau.aidl.InterfaceC3823d
            /* renamed from: IntrinsicsJvm.kt_3 */
            public final void mo25542c(String str, int OplusGLSurfaceView_13) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(PlatformImplementations.kt_3.f24179a);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(OplusGLSurfaceView_13);
                    this.f24180a.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.oplusos.sau.aidl.InterfaceC3823d
            /* renamed from: IntrinsicsJvm.kt_5 */
            public final void mo25543d(String str, int OplusGLSurfaceView_13) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(PlatformImplementations.kt_3.f24179a);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(OplusGLSurfaceView_13);
                    this.f24180a.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public PlatformImplementations.kt_3() {
            attachInterface(this, f24179a);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static InterfaceC3823d m25544a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f24179a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC3823d)) ? new C4133a(iBinder) : (InterfaceC3823d) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int OplusGLSurfaceView_13, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String str = f24179a;
            if (OplusGLSurfaceView_13 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            switch (OplusGLSurfaceView_13) {
                case 1:
                    parcel.enforceInterface(str);
                    mo25536a(parcel.readString(), parcel.readInt(), parcel.readString());
                    break;
                case 2:
                    parcel.enforceInterface(str);
                    mo25535a(parcel.readString(), parcel.readInt());
                    break;
                case 3:
                    parcel.enforceInterface(str);
                    mo25538a(parcel.readString(), parcel.readInt() != 0 ? (AppUpdateInfo) AppUpdateInfo.CREATOR.createFromParcel(parcel) : null);
                    break;
                case 4:
                    parcel.enforceInterface(str);
                    mo25540b(parcel.readString(), parcel.readInt());
                    break;
                case 5:
                    parcel.enforceInterface(str);
                    mo25537a(parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readLong(), parcel.readInt());
                    break;
                case 6:
                    parcel.enforceInterface(str);
                    mo25542c(parcel.readString(), parcel.readInt());
                    break;
                case 7:
                    parcel.enforceInterface(str);
                    mo25539a(parcel.readString(), parcel.readInt() != 0 ? (DataresUpdateInfo) DataresUpdateInfo.CREATOR.createFromParcel(parcel) : null);
                    break;
                case 8:
                    parcel.enforceInterface(str);
                    mo25541b(parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readLong(), parcel.readInt());
                    break;
                case 9:
                    parcel.enforceInterface(str);
                    mo25543d(parcel.readString(), parcel.readInt());
                    break;
                default:
                    return super.onTransact(OplusGLSurfaceView_13, parcel, parcel2, i2);
            }
            parcel2.writeNoException();
            return true;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void mo25535a(String str, int OplusGLSurfaceView_13) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    void mo25536a(String str, int OplusGLSurfaceView_13, String str2) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    void mo25537a(String str, long OplusGLSurfaceView_15, long j2, long j3, int OplusGLSurfaceView_13) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    void mo25538a(String str, AppUpdateInfo appUpdateInfo) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    void mo25539a(String str, DataresUpdateInfo dataresUpdateInfo) throws RemoteException;

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo25540b(String str, int OplusGLSurfaceView_13) throws RemoteException;

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo25541b(String str, long OplusGLSurfaceView_15, long j2, long j3, int OplusGLSurfaceView_13) throws RemoteException;

    /* renamed from: IntrinsicsJvm.kt_3 */
    void mo25542c(String str, int OplusGLSurfaceView_13) throws RemoteException;

    /* renamed from: IntrinsicsJvm.kt_5 */
    void mo25543d(String str, int OplusGLSurfaceView_13) throws RemoteException;
}
