package com.oplus.tingle.ipc;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ShellCallback;
import com.oplus.shield.p198b.SystemUtils;
import com.oplus.tingle.Constants_2;
import java.io.FileDescriptor;
import java.util.Objects;

/* compiled from: SlaveBinder.java */
/* renamed from: com.oplus.tingle.ipc.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class SlaveBinder implements IBinder {

    /* renamed from: PlatformImplementations.kt_3 */
    private IBinder f24152a;

    @Override // android.os.IBinder
    public IInterface queryLocalInterface(String str) {
        return null;
    }

    public void shellCommand(FileDescriptor fileDescriptor, FileDescriptor fileDescriptor2, FileDescriptor fileDescriptor3, String[] strArr, ShellCallback shellCallback, ResultReceiver resultReceiver) throws RemoteException {
    }

    public SlaveBinder(IBinder iBinder) {
        this.f24152a = (IBinder) Objects.requireNonNull(iBinder);
    }

    @Override // android.os.IBinder
    public boolean transact(int OplusGLSurfaceView_13, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(Constants_2.m25458a());
            parcelObtain.writeStrongBinder(this.f24152a);
            parcelObtain.writeInt(OplusGLSurfaceView_13);
            parcelObtain.writeStringArray(SystemUtils.m25214a());
            parcelObtain.appendFrom(parcel, 0, parcel.dataSize());
            Slave.m25479a(parcelObtain, parcel2, i2);
            parcelObtain.recycle();
            return true;
        } catch (Throwable th) {
            parcelObtain.recycle();
            throw th;
        }
    }

    @Override // android.os.IBinder
    public String getInterfaceDescriptor() {
        try {
            return this.f24152a.getInterfaceDescriptor();
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            throw new IllegalStateException(COUIBaseListPopupWindow_8.getClass().getSimpleName(), COUIBaseListPopupWindow_8);
        }
    }

    @Override // android.os.IBinder
    public boolean pingBinder() {
        return this.f24152a.pingBinder();
    }

    @Override // android.os.IBinder
    public boolean isBinderAlive() {
        return this.f24152a.isBinderAlive();
    }

    @Override // android.os.IBinder
    public void dump(FileDescriptor fileDescriptor, String[] strArr) throws RemoteException {
        try {
            this.f24152a.dump(fileDescriptor, strArr);
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            throw new IllegalStateException(COUIBaseListPopupWindow_8.getClass().getSimpleName(), COUIBaseListPopupWindow_8);
        }
    }

    @Override // android.os.IBinder
    public void dumpAsync(FileDescriptor fileDescriptor, String[] strArr) throws RemoteException {
        try {
            this.f24152a.dumpAsync(fileDescriptor, strArr);
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            throw new IllegalStateException(COUIBaseListPopupWindow_8.getClass().getSimpleName(), COUIBaseListPopupWindow_8);
        }
    }

    @Override // android.os.IBinder
    public void linkToDeath(IBinder.DeathRecipient deathRecipient, int OplusGLSurfaceView_13) throws RemoteException {
        try {
            this.f24152a.linkToDeath(deathRecipient, OplusGLSurfaceView_13);
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            throw new IllegalStateException(COUIBaseListPopupWindow_8.getClass().getSimpleName(), COUIBaseListPopupWindow_8);
        }
    }

    @Override // android.os.IBinder
    public boolean unlinkToDeath(IBinder.DeathRecipient deathRecipient, int OplusGLSurfaceView_13) {
        return this.f24152a.unlinkToDeath(deathRecipient, OplusGLSurfaceView_13);
    }
}
