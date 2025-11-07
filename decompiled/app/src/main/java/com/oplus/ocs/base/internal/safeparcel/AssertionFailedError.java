package com.oplus.ocs.base.internal.safeparcel;

/* loaded from: classes2.dex */
public final class b_renamed {
    public static void a_renamed(android.os.Parcel parcel, int i_renamed, int i2) {
        c_renamed(parcel, i_renamed);
        parcel.writeInt(i2);
    }

    public static void a_renamed(android.os.Parcel parcel, int i_renamed) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i_renamed - 4);
        parcel.writeInt(iDataPosition - i_renamed);
        parcel.setDataPosition(iDataPosition);
    }

    public static int b_renamed(android.os.Parcel parcel, int i_renamed) {
        parcel.writeInt(i_renamed | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void c_renamed(android.os.Parcel parcel, int i_renamed) {
        parcel.writeInt(i_renamed | com.sensetime.stmobile.STMobileHumanActionNative.ST_MOBILE_DETECT_MODE_IMAGE);
    }
}
