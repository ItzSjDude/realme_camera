package com.heytap.accessory.api;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.ResultReceiver;
import com.heytap.accessory.api.IDeathCallback;
import com.heytap.accessory.api.IMsgExpCallback;
import com.heytap.accessory.api.IPeerAgentAuthCallback;
import com.heytap.accessory.api.IPeerAgentCallback;
import com.heytap.accessory.api.IServiceChannelCallback;
import com.heytap.accessory.api.IServiceConnectionCallback;
import com.heytap.accessory.api.IServiceConnectionIndicationCallback;
import com.heytap.accessory.bean.PeerAgent;

/* loaded from: classes2.dex */
public interface IFrameworkManager extends IInterface {

    public static class Default implements IFrameworkManager {
        @Override // com.heytap.accessory.api.IFrameworkManager
        /* renamed from: PlatformImplementations.kt_3 */
        public int mo8452a() throws RemoteException {
            return 0;
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        /* renamed from: PlatformImplementations.kt_3 */
        public int mo8453a(int OplusGLSurfaceView_13) throws RemoteException {
            return 0;
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        /* renamed from: PlatformImplementations.kt_3 */
        public int mo8454a(long OplusGLSurfaceView_15) throws RemoteException {
            return 0;
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        /* renamed from: PlatformImplementations.kt_3 */
        public int mo8455a(long OplusGLSurfaceView_15, long j2, String str, IPeerAgentCallback iPeerAgentCallback) throws RemoteException {
            return 0;
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        /* renamed from: PlatformImplementations.kt_3 */
        public int mo8456a(long OplusGLSurfaceView_15, String str, long j2, String str2, long j3, byte[] bArr, boolean z, int OplusGLSurfaceView_13, int i2, int i3, boolean z2) throws RemoteException {
            return 0;
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        /* renamed from: PlatformImplementations.kt_3 */
        public int mo8457a(long OplusGLSurfaceView_15, String str, long j2, byte[] bArr, boolean z, int OplusGLSurfaceView_13, int i2, int i3) throws RemoteException {
            return 0;
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        /* renamed from: PlatformImplementations.kt_3 */
        public int mo8458a(long OplusGLSurfaceView_15, String str, PeerAgent peerAgent, long j2) throws RemoteException {
            return 0;
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        /* renamed from: PlatformImplementations.kt_3 */
        public int mo8459a(long OplusGLSurfaceView_15, String str, PeerAgent peerAgent, IPeerAgentAuthCallback iPeerAgentAuthCallback, long j2) throws RemoteException {
            return 0;
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        /* renamed from: PlatformImplementations.kt_3 */
        public int mo8460a(long OplusGLSurfaceView_15, String str, PeerAgent peerAgent, IServiceConnectionCallback iServiceConnectionCallback, IServiceChannelCallback iServiceChannelCallback) throws RemoteException {
            return 0;
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        /* renamed from: PlatformImplementations.kt_3 */
        public int mo8461a(long OplusGLSurfaceView_15, String str, String str2, long j2, byte[] bArr, boolean z, int OplusGLSurfaceView_13, int i2) throws RemoteException {
            return 0;
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        /* renamed from: PlatformImplementations.kt_3 */
        public Bundle mo8462a(int OplusGLSurfaceView_13, String str, IDeathCallback iDeathCallback, int i2, IServiceConnectionIndicationCallback iServiceConnectionIndicationCallback) throws RemoteException {
            return null;
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        /* renamed from: PlatformImplementations.kt_3 */
        public Bundle mo8463a(long OplusGLSurfaceView_15, String str) throws RemoteException {
            return null;
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        /* renamed from: PlatformImplementations.kt_3 */
        public Bundle mo8464a(long OplusGLSurfaceView_15, String str, PeerAgent peerAgent, long j2, IServiceConnectionCallback iServiceConnectionCallback, IServiceChannelCallback iServiceChannelCallback) throws RemoteException {
            return null;
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        /* renamed from: PlatformImplementations.kt_3 */
        public String mo8465a(long OplusGLSurfaceView_15, String str, String str2) throws RemoteException {
            return null;
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8466a(long OplusGLSurfaceView_15, long j2, int OplusGLSurfaceView_13, int i2) throws RemoteException {
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8467a(long OplusGLSurfaceView_15, long j2, String str, int OplusGLSurfaceView_13, int i2) throws RemoteException {
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8468a(long OplusGLSurfaceView_15, String str, long j2) throws RemoteException {
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8469a(long OplusGLSurfaceView_15, String str, IMsgExpCallback iMsgExpCallback) throws RemoteException {
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8470a(long OplusGLSurfaceView_15, byte[] bArr) throws RemoteException {
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo8471a(int OplusGLSurfaceView_13, String str) throws RemoteException {
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        /* renamed from: IntrinsicsJvm.kt_4 */
        public int mo8472b(long OplusGLSurfaceView_15, String str) throws RemoteException {
            return 0;
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        /* renamed from: IntrinsicsJvm.kt_4 */
        public ResultReceiver mo8473b(long OplusGLSurfaceView_15) throws RemoteException {
            return null;
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        /* renamed from: IntrinsicsJvm.kt_3 */
        public Bundle mo8474c(long OplusGLSurfaceView_15, String str) throws RemoteException {
            return null;
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        /* renamed from: IntrinsicsJvm.kt_5 */
        public boolean mo8475d(long OplusGLSurfaceView_15, String str) throws RemoteException {
            return false;
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        /* renamed from: COUIBaseListPopupWindow_8 */
        public void mo8476e(long OplusGLSurfaceView_15, String str) throws RemoteException {
        }

        @Override // com.heytap.accessory.api.IFrameworkManager
        /* renamed from: COUIBaseListPopupWindow_12 */
        public void mo8477f(long OplusGLSurfaceView_15, String str) throws RemoteException {
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    int mo8452a() throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    int mo8453a(int OplusGLSurfaceView_13) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    int mo8454a(long OplusGLSurfaceView_15) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    int mo8455a(long OplusGLSurfaceView_15, long j2, String str, IPeerAgentCallback iPeerAgentCallback) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    int mo8456a(long OplusGLSurfaceView_15, String str, long j2, String str2, long j3, byte[] bArr, boolean z, int OplusGLSurfaceView_13, int i2, int i3, boolean z2) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    int mo8457a(long OplusGLSurfaceView_15, String str, long j2, byte[] bArr, boolean z, int OplusGLSurfaceView_13, int i2, int i3) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    int mo8458a(long OplusGLSurfaceView_15, String str, PeerAgent peerAgent, long j2) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    int mo8459a(long OplusGLSurfaceView_15, String str, PeerAgent peerAgent, IPeerAgentAuthCallback iPeerAgentAuthCallback, long j2) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    int mo8460a(long OplusGLSurfaceView_15, String str, PeerAgent peerAgent, IServiceConnectionCallback iServiceConnectionCallback, IServiceChannelCallback iServiceChannelCallback) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    int mo8461a(long OplusGLSurfaceView_15, String str, String str2, long j2, byte[] bArr, boolean z, int OplusGLSurfaceView_13, int i2) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    Bundle mo8462a(int OplusGLSurfaceView_13, String str, IDeathCallback iDeathCallback, int i2, IServiceConnectionIndicationCallback iServiceConnectionIndicationCallback) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    Bundle mo8463a(long OplusGLSurfaceView_15, String str) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    Bundle mo8464a(long OplusGLSurfaceView_15, String str, PeerAgent peerAgent, long j2, IServiceConnectionCallback iServiceConnectionCallback, IServiceChannelCallback iServiceChannelCallback) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    String mo8465a(long OplusGLSurfaceView_15, String str, String str2) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    void mo8466a(long OplusGLSurfaceView_15, long j2, int OplusGLSurfaceView_13, int i2) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    void mo8467a(long OplusGLSurfaceView_15, long j2, String str, int OplusGLSurfaceView_13, int i2) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    void mo8468a(long OplusGLSurfaceView_15, String str, long j2) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    void mo8469a(long OplusGLSurfaceView_15, String str, IMsgExpCallback iMsgExpCallback) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    void mo8470a(long OplusGLSurfaceView_15, byte[] bArr) throws RemoteException;

    /* renamed from: PlatformImplementations.kt_3 */
    boolean mo8471a(int OplusGLSurfaceView_13, String str) throws RemoteException;

    /* renamed from: IntrinsicsJvm.kt_4 */
    int mo8472b(long OplusGLSurfaceView_15, String str) throws RemoteException;

    /* renamed from: IntrinsicsJvm.kt_4 */
    ResultReceiver mo8473b(long OplusGLSurfaceView_15) throws RemoteException;

    /* renamed from: IntrinsicsJvm.kt_3 */
    Bundle mo8474c(long OplusGLSurfaceView_15, String str) throws RemoteException;

    /* renamed from: IntrinsicsJvm.kt_5 */
    boolean mo8475d(long OplusGLSurfaceView_15, String str) throws RemoteException;

    /* renamed from: COUIBaseListPopupWindow_8 */
    void mo8476e(long OplusGLSurfaceView_15, String str) throws RemoteException;

    /* renamed from: COUIBaseListPopupWindow_12 */
    void mo8477f(long OplusGLSurfaceView_15, String str) throws RemoteException;

    public static abstract class Stub extends Binder implements IFrameworkManager {
        public Stub() {
            attachInterface(this, "com.heytap.accessory.api.IFrameworkManager");
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static IFrameworkManager m8478a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.accessory.api.IFrameworkManager");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IFrameworkManager)) {
                return (IFrameworkManager) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int OplusGLSurfaceView_13, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (OplusGLSurfaceView_13 == 1598968902) {
                parcel2.writeString("com.heytap.accessory.api.IFrameworkManager");
                return true;
            }
            switch (OplusGLSurfaceView_13) {
                case 1:
                    parcel.enforceInterface("com.heytap.accessory.api.IFrameworkManager");
                    Bundle bundleA = mo8462a(parcel.readInt(), parcel.readString(), IDeathCallback.Stub.m8431a(parcel.readStrongBinder()), parcel.readInt(), IServiceConnectionIndicationCallback.Stub.m8523a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (bundleA != null) {
                        parcel2.writeInt(1);
                        bundleA.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 2:
                    parcel.enforceInterface("com.heytap.accessory.api.IFrameworkManager");
                    mo8470a(parcel.readLong(), parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.heytap.accessory.api.IFrameworkManager");
                    Bundle bundleA2 = mo8463a(parcel.readLong(), parcel.readString());
                    parcel2.writeNoException();
                    if (bundleA2 != null) {
                        parcel2.writeInt(1);
                        bundleA2.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 4:
                    parcel.enforceInterface("com.heytap.accessory.api.IFrameworkManager");
                    int iA = mo8455a(parcel.readLong(), parcel.readLong(), parcel.readString(), IPeerAgentCallback.Stub.m8496a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iA);
                    return true;
                case 5:
                    parcel.enforceInterface("com.heytap.accessory.api.IFrameworkManager");
                    int iA2 = mo8459a(parcel.readLong(), parcel.readString(), parcel.readInt() != 0 ? PeerAgent.CREATOR.createFromParcel(parcel) : null, IPeerAgentAuthCallback.Stub.m8494a(parcel.readStrongBinder()), parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(iA2);
                    return true;
                case 6:
                    parcel.enforceInterface("com.heytap.accessory.api.IFrameworkManager");
                    int iA3 = mo8460a(parcel.readLong(), parcel.readString(), parcel.readInt() != 0 ? PeerAgent.CREATOR.createFromParcel(parcel) : null, IServiceConnectionCallback.Stub.m8521a(parcel.readStrongBinder()), IServiceChannelCallback.Stub.m8519a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iA3);
                    return true;
                case 7:
                    parcel.enforceInterface("com.heytap.accessory.api.IFrameworkManager");
                    Bundle bundleA3 = mo8464a(parcel.readLong(), parcel.readString(), parcel.readInt() != 0 ? PeerAgent.CREATOR.createFromParcel(parcel) : null, parcel.readLong(), IServiceConnectionCallback.Stub.m8521a(parcel.readStrongBinder()), IServiceChannelCallback.Stub.m8519a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (bundleA3 != null) {
                        parcel2.writeInt(1);
                        bundleA3.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 8:
                    parcel.enforceInterface("com.heytap.accessory.api.IFrameworkManager");
                    int iA4 = mo8458a(parcel.readLong(), parcel.readString(), parcel.readInt() != 0 ? PeerAgent.CREATOR.createFromParcel(parcel) : null, parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(iA4);
                    return true;
                case 9:
                    parcel.enforceInterface("com.heytap.accessory.api.IFrameworkManager");
                    int iB = mo8472b(parcel.readLong(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(iB);
                    return true;
                case 10:
                    parcel.enforceInterface("com.heytap.accessory.api.IFrameworkManager");
                    Bundle bundleC = mo8474c(parcel.readLong(), parcel.readString());
                    parcel2.writeNoException();
                    if (bundleC != null) {
                        parcel2.writeInt(1);
                        bundleC.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 11:
                    parcel.enforceInterface("com.heytap.accessory.api.IFrameworkManager");
                    int iA5 = mo8454a(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(iA5);
                    return true;
                case 12:
                    parcel.enforceInterface("com.heytap.accessory.api.IFrameworkManager");
                    boolean zD = mo8475d(parcel.readLong(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zD ? 1 : 0);
                    return true;
                case 13:
                    parcel.enforceInterface("com.heytap.accessory.api.IFrameworkManager");
                    ResultReceiver resultReceiverB = mo8473b(parcel.readLong());
                    parcel2.writeNoException();
                    if (resultReceiverB != null) {
                        parcel2.writeInt(1);
                        resultReceiverB.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 14:
                    parcel.enforceInterface("com.heytap.accessory.api.IFrameworkManager");
                    mo8469a(parcel.readLong(), parcel.readString(), IMsgExpCallback.Stub.m8489a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface("com.heytap.accessory.api.IFrameworkManager");
                    mo8476e(parcel.readLong(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface("com.heytap.accessory.api.IFrameworkManager");
                    int iA6 = mo8461a(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readLong(), parcel.createByteArray(), parcel.readInt() != 0, parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(iA6);
                    return true;
                case 17:
                    parcel.enforceInterface("com.heytap.accessory.api.IFrameworkManager");
                    mo8466a(parcel.readLong(), parcel.readLong(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 18:
                    parcel.enforceInterface("com.heytap.accessory.api.IFrameworkManager");
                    mo8477f(parcel.readLong(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 19:
                    parcel.enforceInterface("com.heytap.accessory.api.IFrameworkManager");
                    String strA = mo8465a(parcel.readLong(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strA);
                    return true;
                case 20:
                    parcel.enforceInterface("com.heytap.accessory.api.IFrameworkManager");
                    int iA7 = mo8457a(parcel.readLong(), parcel.readString(), parcel.readLong(), parcel.createByteArray(), parcel.readInt() != 0, parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(iA7);
                    return true;
                case 21:
                    parcel.enforceInterface("com.heytap.accessory.api.IFrameworkManager");
                    int iA8 = mo8452a();
                    parcel2.writeNoException();
                    parcel2.writeInt(iA8);
                    return true;
                case 22:
                    parcel.enforceInterface("com.heytap.accessory.api.IFrameworkManager");
                    int iA9 = mo8453a(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(iA9);
                    return true;
                case 23:
                    parcel.enforceInterface("com.heytap.accessory.api.IFrameworkManager");
                    boolean zA = mo8471a(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zA ? 1 : 0);
                    return true;
                case 24:
                    parcel.enforceInterface("com.heytap.accessory.api.IFrameworkManager");
                    int iA10 = mo8456a(parcel.readLong(), parcel.readString(), parcel.readLong(), parcel.readString(), parcel.readLong(), parcel.createByteArray(), parcel.readInt() != 0, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    parcel2.writeInt(iA10);
                    return true;
                case 25:
                    parcel.enforceInterface("com.heytap.accessory.api.IFrameworkManager");
                    mo8467a(parcel.readLong(), parcel.readLong(), parcel.readString(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 26:
                    parcel.enforceInterface("com.heytap.accessory.api.IFrameworkManager");
                    mo8468a(parcel.readLong(), parcel.readString(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(OplusGLSurfaceView_13, parcel, parcel2, i2);
            }
        }

        static class Proxy implements IFrameworkManager {

            /* renamed from: PlatformImplementations.kt_3 */
            public static IFrameworkManager f9435a;

            /* renamed from: IntrinsicsJvm.kt_4 */
            private IBinder f9436b;

            Proxy(IBinder iBinder) {
                this.f9436b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9436b;
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            /* renamed from: PlatformImplementations.kt_3 */
            public Bundle mo8462a(int OplusGLSurfaceView_13, String str, IDeathCallback iDeathCallback, int i2, IServiceConnectionIndicationCallback iServiceConnectionIndicationCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    parcelObtain.writeInt(OplusGLSurfaceView_13);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iDeathCallback != null ? iDeathCallback.asBinder() : null);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeStrongBinder(iServiceConnectionIndicationCallback != null ? iServiceConnectionIndicationCallback.asBinder() : null);
                    if (!this.f9436b.transact(1, parcelObtain, parcelObtain2, 0) && Stub.m8479b() != null) {
                        return Stub.m8479b().mo8462a(OplusGLSurfaceView_13, str, iDeathCallback, i2, iServiceConnectionIndicationCallback);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo8470a(long OplusGLSurfaceView_15, byte[] bArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    parcelObtain.writeLong(OplusGLSurfaceView_15);
                    parcelObtain.writeByteArray(bArr);
                    if (!this.f9436b.transact(2, parcelObtain, parcelObtain2, 0) && Stub.m8479b() != null) {
                        Stub.m8479b().mo8470a(OplusGLSurfaceView_15, bArr);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            /* renamed from: PlatformImplementations.kt_3 */
            public Bundle mo8463a(long OplusGLSurfaceView_15, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    parcelObtain.writeLong(OplusGLSurfaceView_15);
                    parcelObtain.writeString(str);
                    if (!this.f9436b.transact(3, parcelObtain, parcelObtain2, 0) && Stub.m8479b() != null) {
                        return Stub.m8479b().mo8463a(OplusGLSurfaceView_15, str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            /* renamed from: PlatformImplementations.kt_3 */
            public int mo8455a(long OplusGLSurfaceView_15, long j2, String str, IPeerAgentCallback iPeerAgentCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    parcelObtain.writeLong(OplusGLSurfaceView_15);
                    parcelObtain.writeLong(j2);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iPeerAgentCallback != null ? iPeerAgentCallback.asBinder() : null);
                    if (!this.f9436b.transact(4, parcelObtain, parcelObtain2, 0) && Stub.m8479b() != null) {
                        return Stub.m8479b().mo8455a(OplusGLSurfaceView_15, j2, str, iPeerAgentCallback);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            /* renamed from: PlatformImplementations.kt_3 */
            public int mo8459a(long OplusGLSurfaceView_15, String str, PeerAgent peerAgent, IPeerAgentAuthCallback iPeerAgentAuthCallback, long j2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    parcelObtain.writeLong(OplusGLSurfaceView_15);
                    parcelObtain.writeString(str);
                    if (peerAgent != null) {
                        parcelObtain.writeInt(1);
                        peerAgent.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iPeerAgentAuthCallback != null ? iPeerAgentAuthCallback.asBinder() : null);
                    parcelObtain.writeLong(j2);
                    if (!this.f9436b.transact(5, parcelObtain, parcelObtain2, 0) && Stub.m8479b() != null) {
                        return Stub.m8479b().mo8459a(OplusGLSurfaceView_15, str, peerAgent, iPeerAgentAuthCallback, j2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            /* renamed from: PlatformImplementations.kt_3 */
            public int mo8460a(long OplusGLSurfaceView_15, String str, PeerAgent peerAgent, IServiceConnectionCallback iServiceConnectionCallback, IServiceChannelCallback iServiceChannelCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    parcelObtain.writeLong(OplusGLSurfaceView_15);
                    parcelObtain.writeString(str);
                    if (peerAgent != null) {
                        parcelObtain.writeInt(1);
                        peerAgent.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iServiceConnectionCallback != null ? iServiceConnectionCallback.asBinder() : null);
                    parcelObtain.writeStrongBinder(iServiceChannelCallback != null ? iServiceChannelCallback.asBinder() : null);
                    if (!this.f9436b.transact(6, parcelObtain, parcelObtain2, 0) && Stub.m8479b() != null) {
                        return Stub.m8479b().mo8460a(OplusGLSurfaceView_15, str, peerAgent, iServiceConnectionCallback, iServiceChannelCallback);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            /* renamed from: PlatformImplementations.kt_3 */
            public Bundle mo8464a(long OplusGLSurfaceView_15, String str, PeerAgent peerAgent, long j2, IServiceConnectionCallback iServiceConnectionCallback, IServiceChannelCallback iServiceChannelCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    parcelObtain.writeLong(OplusGLSurfaceView_15);
                    parcelObtain.writeString(str);
                    if (peerAgent != null) {
                        parcelObtain.writeInt(1);
                        peerAgent.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeLong(j2);
                    parcelObtain.writeStrongBinder(iServiceConnectionCallback != null ? iServiceConnectionCallback.asBinder() : null);
                    parcelObtain.writeStrongBinder(iServiceChannelCallback != null ? iServiceChannelCallback.asBinder() : null);
                    if (!this.f9436b.transact(7, parcelObtain, parcelObtain2, 0) && Stub.m8479b() != null) {
                        return Stub.m8479b().mo8464a(OplusGLSurfaceView_15, str, peerAgent, j2, iServiceConnectionCallback, iServiceChannelCallback);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            /* renamed from: PlatformImplementations.kt_3 */
            public int mo8458a(long OplusGLSurfaceView_15, String str, PeerAgent peerAgent, long j2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    parcelObtain.writeLong(OplusGLSurfaceView_15);
                    parcelObtain.writeString(str);
                    if (peerAgent != null) {
                        parcelObtain.writeInt(1);
                        peerAgent.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeLong(j2);
                    if (!this.f9436b.transact(8, parcelObtain, parcelObtain2, 0) && Stub.m8479b() != null) {
                        return Stub.m8479b().mo8458a(OplusGLSurfaceView_15, str, peerAgent, j2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            /* renamed from: IntrinsicsJvm.kt_4 */
            public int mo8472b(long OplusGLSurfaceView_15, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    parcelObtain.writeLong(OplusGLSurfaceView_15);
                    parcelObtain.writeString(str);
                    if (!this.f9436b.transact(9, parcelObtain, parcelObtain2, 0) && Stub.m8479b() != null) {
                        return Stub.m8479b().mo8472b(OplusGLSurfaceView_15, str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            /* renamed from: IntrinsicsJvm.kt_3 */
            public Bundle mo8474c(long OplusGLSurfaceView_15, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    parcelObtain.writeLong(OplusGLSurfaceView_15);
                    parcelObtain.writeString(str);
                    if (!this.f9436b.transact(10, parcelObtain, parcelObtain2, 0) && Stub.m8479b() != null) {
                        return Stub.m8479b().mo8474c(OplusGLSurfaceView_15, str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            /* renamed from: PlatformImplementations.kt_3 */
            public int mo8454a(long OplusGLSurfaceView_15) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    parcelObtain.writeLong(OplusGLSurfaceView_15);
                    if (!this.f9436b.transact(11, parcelObtain, parcelObtain2, 0) && Stub.m8479b() != null) {
                        return Stub.m8479b().mo8454a(OplusGLSurfaceView_15);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            /* renamed from: IntrinsicsJvm.kt_5 */
            public boolean mo8475d(long OplusGLSurfaceView_15, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    parcelObtain.writeLong(OplusGLSurfaceView_15);
                    parcelObtain.writeString(str);
                    if (!this.f9436b.transact(12, parcelObtain, parcelObtain2, 0) && Stub.m8479b() != null) {
                        return Stub.m8479b().mo8475d(OplusGLSurfaceView_15, str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            /* renamed from: IntrinsicsJvm.kt_4 */
            public ResultReceiver mo8473b(long OplusGLSurfaceView_15) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    parcelObtain.writeLong(OplusGLSurfaceView_15);
                    if (!this.f9436b.transact(13, parcelObtain, parcelObtain2, 0) && Stub.m8479b() != null) {
                        return Stub.m8479b().mo8473b(OplusGLSurfaceView_15);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo8469a(long OplusGLSurfaceView_15, String str, IMsgExpCallback iMsgExpCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    parcelObtain.writeLong(OplusGLSurfaceView_15);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iMsgExpCallback != null ? iMsgExpCallback.asBinder() : null);
                    if (!this.f9436b.transact(14, parcelObtain, parcelObtain2, 0) && Stub.m8479b() != null) {
                        Stub.m8479b().mo8469a(OplusGLSurfaceView_15, str, iMsgExpCallback);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            /* renamed from: COUIBaseListPopupWindow_8 */
            public void mo8476e(long OplusGLSurfaceView_15, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    parcelObtain.writeLong(OplusGLSurfaceView_15);
                    parcelObtain.writeString(str);
                    if (!this.f9436b.transact(15, parcelObtain, parcelObtain2, 0) && Stub.m8479b() != null) {
                        Stub.m8479b().mo8476e(OplusGLSurfaceView_15, str);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            /* renamed from: PlatformImplementations.kt_3 */
            public int mo8461a(long OplusGLSurfaceView_15, String str, String str2, long j2, byte[] bArr, boolean z, int OplusGLSurfaceView_13, int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    parcelObtain.writeLong(OplusGLSurfaceView_15);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeLong(j2);
                    parcelObtain.writeByteArray(bArr);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeInt(OplusGLSurfaceView_13);
                    parcelObtain.writeInt(i2);
                    if (!this.f9436b.transact(16, parcelObtain, parcelObtain2, 0) && Stub.m8479b() != null) {
                        return Stub.m8479b().mo8461a(OplusGLSurfaceView_15, str, str2, j2, bArr, z, OplusGLSurfaceView_13, i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo8466a(long OplusGLSurfaceView_15, long j2, int OplusGLSurfaceView_13, int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    parcelObtain.writeLong(OplusGLSurfaceView_15);
                    parcelObtain.writeLong(j2);
                    parcelObtain.writeInt(OplusGLSurfaceView_13);
                    parcelObtain.writeInt(i2);
                    if (!this.f9436b.transact(17, parcelObtain, parcelObtain2, 0) && Stub.m8479b() != null) {
                        Stub.m8479b().mo8466a(OplusGLSurfaceView_15, j2, OplusGLSurfaceView_13, i2);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            /* renamed from: COUIBaseListPopupWindow_12 */
            public void mo8477f(long OplusGLSurfaceView_15, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    parcelObtain.writeLong(OplusGLSurfaceView_15);
                    parcelObtain.writeString(str);
                    if (!this.f9436b.transact(18, parcelObtain, parcelObtain2, 0) && Stub.m8479b() != null) {
                        Stub.m8479b().mo8477f(OplusGLSurfaceView_15, str);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            /* renamed from: PlatformImplementations.kt_3 */
            public String mo8465a(long OplusGLSurfaceView_15, String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    parcelObtain.writeLong(OplusGLSurfaceView_15);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.f9436b.transact(19, parcelObtain, parcelObtain2, 0) && Stub.m8479b() != null) {
                        return Stub.m8479b().mo8465a(OplusGLSurfaceView_15, str, str2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            /* renamed from: PlatformImplementations.kt_3 */
            public int mo8457a(long OplusGLSurfaceView_15, String str, long j2, byte[] bArr, boolean z, int OplusGLSurfaceView_13, int i2, int i3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    parcelObtain.writeLong(OplusGLSurfaceView_15);
                    parcelObtain.writeString(str);
                    parcelObtain.writeLong(j2);
                    parcelObtain.writeByteArray(bArr);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeInt(OplusGLSurfaceView_13);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    if (!this.f9436b.transact(20, parcelObtain, parcelObtain2, 0) && Stub.m8479b() != null) {
                        return Stub.m8479b().mo8457a(OplusGLSurfaceView_15, str, j2, bArr, z, OplusGLSurfaceView_13, i2, i3);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            /* renamed from: PlatformImplementations.kt_3 */
            public int mo8452a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    if (!this.f9436b.transact(21, parcelObtain, parcelObtain2, 0) && Stub.m8479b() != null) {
                        return Stub.m8479b().mo8452a();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            /* renamed from: PlatformImplementations.kt_3 */
            public int mo8453a(int OplusGLSurfaceView_13) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    parcelObtain.writeInt(OplusGLSurfaceView_13);
                    if (!this.f9436b.transact(22, parcelObtain, parcelObtain2, 0) && Stub.m8479b() != null) {
                        return Stub.m8479b().mo8453a(OplusGLSurfaceView_13);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            /* renamed from: PlatformImplementations.kt_3 */
            public boolean mo8471a(int OplusGLSurfaceView_13, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    parcelObtain.writeInt(OplusGLSurfaceView_13);
                    parcelObtain.writeString(str);
                    if (!this.f9436b.transact(23, parcelObtain, parcelObtain2, 0) && Stub.m8479b() != null) {
                        return Stub.m8479b().mo8471a(OplusGLSurfaceView_13, str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            /* renamed from: PlatformImplementations.kt_3 */
            public int mo8456a(long OplusGLSurfaceView_15, String str, long j2, String str2, long j3, byte[] bArr, boolean z, int OplusGLSurfaceView_13, int i2, int i3, boolean z2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    parcelObtain.writeLong(OplusGLSurfaceView_15);
                    parcelObtain.writeString(str);
                    parcelObtain.writeLong(j2);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeLong(j3);
                    parcelObtain.writeByteArray(bArr);
                    int i4 = 1;
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeInt(OplusGLSurfaceView_13);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    if (!z2) {
                        i4 = 0;
                    }
                    parcelObtain.writeInt(i4);
                    if (!this.f9436b.transact(24, parcelObtain, parcelObtain2, 0) && Stub.m8479b() != null) {
                        return Stub.m8479b().mo8456a(OplusGLSurfaceView_15, str, j2, str2, j3, bArr, z, OplusGLSurfaceView_13, i2, i3, z2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo8467a(long OplusGLSurfaceView_15, long j2, String str, int OplusGLSurfaceView_13, int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    parcelObtain.writeLong(OplusGLSurfaceView_15);
                    parcelObtain.writeLong(j2);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(OplusGLSurfaceView_13);
                    parcelObtain.writeInt(i2);
                    if (!this.f9436b.transact(25, parcelObtain, parcelObtain2, 0) && Stub.m8479b() != null) {
                        Stub.m8479b().mo8467a(OplusGLSurfaceView_15, j2, str, OplusGLSurfaceView_13, i2);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.accessory.api.IFrameworkManager
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo8468a(long OplusGLSurfaceView_15, String str, long j2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.accessory.api.IFrameworkManager");
                    parcelObtain.writeLong(OplusGLSurfaceView_15);
                    parcelObtain.writeString(str);
                    parcelObtain.writeLong(j2);
                    if (!this.f9436b.transact(26, parcelObtain, parcelObtain2, 0) && Stub.m8479b() != null) {
                        Stub.m8479b().mo8468a(OplusGLSurfaceView_15, str, j2);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public static IFrameworkManager m8479b() {
            return Proxy.f9435a;
        }
    }
}
