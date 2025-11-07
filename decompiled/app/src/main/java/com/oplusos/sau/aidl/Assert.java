package com.oplusos.sau.aidl;

/* loaded from: classes2.dex */
final class a_renamed implements android.os.Parcelable.Creator {
    a_renamed() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel parcel) {
        return new com.oplusos.sau.aidl.AppUpdateInfo(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ java.lang.Object[] newArray(int i_renamed) {
        return new com.oplusos.sau.aidl.AppUpdateInfo[i_renamed];
    }
}
