package com.oplus.tingle.ipc;

import android.os.Build;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.system.Os;
import com.oplus.shield.PermissionCheck;
import com.oplus.tingle.Constants_2;
import com.oplus.tingle.ipc.IMaster;
import com.oplus.tingle.ipc.p213c.Logger;

/* loaded from: classes2.dex */
public class Master extends IMaster.Stub {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final Object f24134a = new Object();

    private Master() {
    }

    @Override // com.oplus.tingle.ipc.IMaster.Stub, android.os.Binder
    public boolean onTransact(int OplusGLSurfaceView_13, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (OplusGLSurfaceView_13 == 1) {
            parcel.enforceInterface(Constants_2.m25458a());
            m25470a(parcel, parcel2, i2);
            return true;
        }
        return super.onTransact(OplusGLSurfaceView_13, parcel, parcel2, i2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m25470a(Parcel parcel, Parcel parcel2, int OplusGLSurfaceView_13) throws RemoteException {
        IBinder strongBinder = parcel.readStrongBinder();
        int i2 = parcel.readInt();
        parcel.readStringArray();
        if (PermissionCheck.m25179b().m25180a() && !PermissionCheck.m25179b().m25181a(strongBinder.getInterfaceDescriptor(), i2)) {
            throw new SecurityException("Tingle Authentication Failed.");
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.appendFrom(parcel, parcel.dataPosition(), parcel.dataAvail());
            try {
                long jClearCallingIdentity = clearCallingIdentity();
                strongBinder.transact(i2, parcelObtain, parcel2, OplusGLSurfaceView_13);
                restoreCallingIdentity(jClearCallingIdentity);
            } finally {
                parcelObtain.recycle();
            }
        } catch (Throwable th) {
            Logger.m25514b("Master", "appendFrom failed: " + th.toString(), new Object[0]);
        }
    }

    @Override // com.oplus.tingle.ipc.IMaster
    /* renamed from: PlatformImplementations.kt_3 */
    public int mo25468a() throws RemoteException {
        if (Build.VERSION.SDK_INT >= 21) {
            return Os.getuid();
        }
        return -1;
    }
}
