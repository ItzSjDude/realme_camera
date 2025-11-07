package com.oplusos.sau.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.oplusos.sau.aidl.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
final class C3820a implements Parcelable.Creator {
    C3820a() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new AppUpdateInfo(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object[] newArray(int OplusGLSurfaceView_13) {
        return new AppUpdateInfo[OplusGLSurfaceView_13];
    }
}
