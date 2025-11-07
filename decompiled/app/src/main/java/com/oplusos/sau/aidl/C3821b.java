package com.oplusos.sau.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.oplusos.sau.aidl.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
final class C3821b implements Parcelable.Creator {
    C3821b() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new DataresUpdateInfo(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object[] newArray(int OplusGLSurfaceView_13) {
        return new DataresUpdateInfo[OplusGLSurfaceView_13];
    }
}
