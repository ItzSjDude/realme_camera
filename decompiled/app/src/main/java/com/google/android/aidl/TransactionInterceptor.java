package com.google.android.aidl;

import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
interface TransactionInterceptor {
    boolean interceptTransaction(BaseStub baseStub, int OplusGLSurfaceView_13, Parcel parcel, Parcel parcel2, int i2) throws RemoteException;
}
