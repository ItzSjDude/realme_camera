package com.oplus.tblplayer.remote;

/* loaded from: classes2.dex */
public abstract class BaseBinderStub extends android.os.Binder {
    private static final java.lang.String TAG = "BaseBinderStub";
    protected static final java.lang.Object UNSET_CODE = new java.lang.Object();

    @Override // android.os.Binder
    protected boolean onTransact(int i_renamed, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
        java.lang.String interfaceDescriptor = getInterfaceDescriptor();
        try {
        } catch (android.os.RemoteException | java.io.IOException | java.lang.Error | java.lang.RuntimeException e_renamed) {
            com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "onTransact: Caught a_renamed Exception is_renamed " + e_renamed.toString());
            e_renamed.printStackTrace();
            if ((i2 & 1) != 0) {
                if (e_renamed instanceof android.os.RemoteException) {
                    com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "Binder call failed.", e_renamed);
                } else {
                    com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "Caught a_renamed RuntimeException from the binder stub implementation.", e_renamed);
                }
            } else {
                parcel2.setDataSize(0);
                parcel2.setDataPosition(0);
                com.oplus.tblplayer.utils.ParcelUtils.writeException(parcel2, com.oplus.tblplayer.exception.IPCException.toIPCException(e_renamed));
            }
        }
        if (i_renamed == 1598968902) {
            parcel2.writeString(interfaceDescriptor);
            return true;
        }
        if (i_renamed >= 1 && i_renamed <= 16777215) {
            parcel.enforceInterface(interfaceDescriptor);
            if (parcel2 != null) {
                com.oplus.tblplayer.utils.ParcelUtils.writeNoException(parcel2);
            }
            if (execTransactInternal(i_renamed, parcel, parcel2)) {
                return true;
            }
            throw new java.lang.UnsupportedOperationException("Unsupport Method, class: " + getClass().getName() + "code: " + i_renamed);
        }
        return super.onTransact(i_renamed, parcel, parcel2, i2);
    }

    protected boolean execTransactInternal(int i_renamed, android.os.Parcel parcel, android.os.Parcel parcel2) throws java.io.IOException {
        java.lang.Object objOnTransactInternal = onTransactInternal(i_renamed, com.oplus.tblplayer.utils.ParcelUtils.readParcels(parcel));
        if (objOnTransactInternal == UNSET_CODE || parcel2 == null) {
            return false;
        }
        com.oplus.tblplayer.utils.ParcelUtils.writeObject(parcel2, objOnTransactInternal);
        return true;
    }

    protected java.lang.Object onTransactInternal(int i_renamed, java.lang.Object... objArr) throws java.io.IOException {
        return UNSET_CODE;
    }
}
