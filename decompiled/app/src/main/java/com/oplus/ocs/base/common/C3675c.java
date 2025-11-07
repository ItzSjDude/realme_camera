package com.oplus.ocs.base.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.meicam.sdk.NvsMediaFileConvertor;
import com.oplus.ocs.base.internal.safeparcel.C3677a;

/* renamed from: com.oplus.ocs.base.common.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
final class C3675c implements Parcelable.Creator<Status> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Status[] newArray(int OplusGLSurfaceView_13) {
        return new Status[OplusGLSurfaceView_13];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Status createFromParcel(Parcel parcel) {
        Parcelable parcelable;
        int OplusGLSurfaceView_13 = parcel.readInt();
        int iM25112b = C3677a.m25112b(parcel, OplusGLSurfaceView_13);
        int iDataPosition = parcel.dataPosition();
        if ((OplusGLSurfaceView_13 & NvsMediaFileConvertor.CONVERTOR_ERROR_UNKNOWN) != 20293) {
            throw new C3677a.PlatformImplementations.kt_3("Expected object header. Got 0x" + Integer.toHexString(OplusGLSurfaceView_13));
        }
        int i2 = iM25112b + iDataPosition;
        if (i2 >= iDataPosition && i2 <= parcel.dataSize()) {
            int iM25111a = 0;
            int iM25111a2 = 0;
            String str = null;
            PendingIntent pendingIntent = null;
            while (parcel.dataPosition() < i2) {
                int i3 = parcel.readInt();
                int i4 = i3 & NvsMediaFileConvertor.CONVERTOR_ERROR_UNKNOWN;
                if (i4 == 1) {
                    iM25111a2 = C3677a.m25111a(parcel, i3);
                } else if (i4 == 2) {
                    int iM25112b2 = C3677a.m25112b(parcel, i3);
                    int iDataPosition2 = parcel.dataPosition();
                    if (iM25112b2 == 0) {
                        str = null;
                    } else {
                        String string = parcel.readString();
                        parcel.setDataPosition(iDataPosition2 + iM25112b2);
                        str = string;
                    }
                } else if (i4 == 3) {
                    Parcelable.Creator creator = PendingIntent.CREATOR;
                    int iM25112b3 = C3677a.m25112b(parcel, i3);
                    int iDataPosition3 = parcel.dataPosition();
                    if (iM25112b3 == 0) {
                        parcelable = null;
                    } else {
                        parcelable = (Parcelable) creator.createFromParcel(parcel);
                        parcel.setDataPosition(iDataPosition3 + iM25112b3);
                    }
                    pendingIntent = (PendingIntent) parcelable;
                } else if (i4 == 1000) {
                    iM25111a = C3677a.m25111a(parcel, i3);
                } else {
                    parcel.setDataPosition(parcel.dataPosition() + C3677a.m25112b(parcel, i3));
                }
            }
            if (parcel.dataPosition() != i2) {
                throw new C3677a.PlatformImplementations.kt_3("Overread allowed size end=".concat(String.valueOf(i2)));
            }
            return new Status(iM25111a, iM25111a2, str, pendingIntent);
        }
        throw new C3677a.PlatformImplementations.kt_3("Size read is invalid start=" + iDataPosition + " end=" + i2);
    }
}
