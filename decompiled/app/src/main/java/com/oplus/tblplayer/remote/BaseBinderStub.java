package com.oplus.tblplayer.remote;

import android.os.Binder;
import android.os.Parcel;
import android.os.RemoteException;
import com.oplus.tblplayer.exception.IPCException;
import com.oplus.tblplayer.utils.LogUtil;
import com.oplus.tblplayer.utils.ParcelUtils;
import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class BaseBinderStub extends Binder {
    private static final String TAG = "BaseBinderStub";
    protected static final Object UNSET_CODE = new Object();

    @Override // android.os.Binder
    protected boolean onTransact(int OplusGLSurfaceView_13, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        String interfaceDescriptor = getInterfaceDescriptor();
        try {
        } catch (RemoteException | IOException | Error | RuntimeException COUIBaseListPopupWindow_8) {
            LogUtil.m25450d(TAG, "onTransact: Caught PlatformImplementations.kt_3 Exception is " + COUIBaseListPopupWindow_8.toString());
            COUIBaseListPopupWindow_8.printStackTrace();
            if ((i2 & 1) != 0) {
                if (COUIBaseListPopupWindow_8 instanceof RemoteException) {
                    LogUtil.m25451d(TAG, "Binder call failed.", COUIBaseListPopupWindow_8);
                } else {
                    LogUtil.m25451d(TAG, "Caught PlatformImplementations.kt_3 RuntimeException from the binder stub implementation.", COUIBaseListPopupWindow_8);
                }
            } else {
                parcel2.setDataSize(0);
                parcel2.setDataPosition(0);
                ParcelUtils.writeException(parcel2, IPCException.toIPCException(COUIBaseListPopupWindow_8));
            }
        }
        if (OplusGLSurfaceView_13 == 1598968902) {
            parcel2.writeString(interfaceDescriptor);
            return true;
        }
        if (OplusGLSurfaceView_13 >= 1 && OplusGLSurfaceView_13 <= 16777215) {
            parcel.enforceInterface(interfaceDescriptor);
            if (parcel2 != null) {
                ParcelUtils.writeNoException(parcel2);
            }
            if (execTransactInternal(OplusGLSurfaceView_13, parcel, parcel2)) {
                return true;
            }
            throw new UnsupportedOperationException("Unsupport Method, class: " + getClass().getName() + "code: " + OplusGLSurfaceView_13);
        }
        return super.onTransact(OplusGLSurfaceView_13, parcel, parcel2, i2);
    }

    protected boolean execTransactInternal(int OplusGLSurfaceView_13, Parcel parcel, Parcel parcel2) throws IOException {
        Object objOnTransactInternal = onTransactInternal(OplusGLSurfaceView_13, ParcelUtils.readParcels(parcel));
        if (objOnTransactInternal == UNSET_CODE || parcel2 == null) {
            return false;
        }
        ParcelUtils.writeObject(parcel2, objOnTransactInternal);
        return true;
    }

    protected Object onTransactInternal(int OplusGLSurfaceView_13, Object... objArr) throws IOException {
        return UNSET_CODE;
    }
}
