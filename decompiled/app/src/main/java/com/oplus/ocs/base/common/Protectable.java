package com.oplus.ocs.base.common;

/* loaded from: classes2.dex */
final class c_renamed implements android.os.Parcelable.Creator<com.oplus.ocs.base.common.Status> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ com.oplus.ocs.base.common.Status[] newArray(int i_renamed) {
        return new com.oplus.ocs.base.common.Status[i_renamed];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ com.oplus.ocs.base.common.Status createFromParcel(android.os.Parcel parcel) {
        android.os.Parcelable parcelable;
        int i_renamed = parcel.readInt();
        int iB = com.oplus.ocs.base.internal.safeparcel.a_renamed.b_renamed(parcel, i_renamed);
        int iDataPosition = parcel.dataPosition();
        if ((i_renamed & com.meicam.sdk.NvsMediaFileConvertor.CONVERTOR_ERROR_UNKNOWN) != 20293) {
            throw new com.oplus.ocs.base.internal.safeparcel.a_renamed.C0144a("Expected object header. Got 0x" + java.lang.Integer.toHexString(i_renamed));
        }
        int i2 = iB + iDataPosition;
        if (i2 >= iDataPosition && i2 <= parcel.dataSize()) {
            int iA = 0;
            int iA2 = 0;
            java.lang.String str = null;
            android.app.PendingIntent pendingIntent = null;
            while (parcel.dataPosition() < i2) {
                int i3 = parcel.readInt();
                int i4 = i3 & com.meicam.sdk.NvsMediaFileConvertor.CONVERTOR_ERROR_UNKNOWN;
                if (i4 == 1) {
                    iA2 = com.oplus.ocs.base.internal.safeparcel.a_renamed.a_renamed(parcel, i3);
                } else if (i4 == 2) {
                    int iB2 = com.oplus.ocs.base.internal.safeparcel.a_renamed.b_renamed(parcel, i3);
                    int iDataPosition2 = parcel.dataPosition();
                    if (iB2 == 0) {
                        str = null;
                    } else {
                        java.lang.String string = parcel.readString();
                        parcel.setDataPosition(iDataPosition2 + iB2);
                        str = string;
                    }
                } else if (i4 == 3) {
                    android.os.Parcelable.Creator creator = android.app.PendingIntent.CREATOR;
                    int iB3 = com.oplus.ocs.base.internal.safeparcel.a_renamed.b_renamed(parcel, i3);
                    int iDataPosition3 = parcel.dataPosition();
                    if (iB3 == 0) {
                        parcelable = null;
                    } else {
                        parcelable = (android.os.Parcelable) creator.createFromParcel(parcel);
                        parcel.setDataPosition(iDataPosition3 + iB3);
                    }
                    pendingIntent = (android.app.PendingIntent) parcelable;
                } else if (i4 == 1000) {
                    iA = com.oplus.ocs.base.internal.safeparcel.a_renamed.a_renamed(parcel, i3);
                } else {
                    parcel.setDataPosition(parcel.dataPosition() + com.oplus.ocs.base.internal.safeparcel.a_renamed.b_renamed(parcel, i3));
                }
            }
            if (parcel.dataPosition() != i2) {
                throw new com.oplus.ocs.base.internal.safeparcel.a_renamed.C0144a("Overread allowed size end=".concat(java.lang.String.valueOf(i2)));
            }
            return new com.oplus.ocs.base.common.Status(iA, iA2, str, pendingIntent);
        }
        throw new com.oplus.ocs.base.internal.safeparcel.a_renamed.C0144a("Size read is_renamed invalid start=" + iDataPosition + " end=" + i2);
    }
}
