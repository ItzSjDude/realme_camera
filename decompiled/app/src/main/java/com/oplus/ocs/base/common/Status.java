package com.oplus.ocs.base.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.oplus.ocs.base.common.p194a.C3651a;
import com.oplus.ocs.base.internal.safeparcel.AbstractSafeParcelable;
import com.oplus.ocs.base.internal.safeparcel.C3678b;
import com.oplus.ocs.base.p193b.C3646e;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class Status extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Status> CREATOR = new C3675c();

    /* renamed from: PlatformImplementations.kt_3 */
    private int f23400a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f23401b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private String f23402c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private PendingIntent f23403d;

    Status(int OplusGLSurfaceView_13, int i2, String str, PendingIntent pendingIntent) {
        this.f23400a = OplusGLSurfaceView_13;
        this.f23401b = i2;
        this.f23402c = str;
        this.f23403d = pendingIntent;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f23400a), Integer.valueOf(this.f23401b), this.f23402c, this.f23403d});
    }

    public String toString() {
        C3646e.PlatformImplementations.kt_3 aVarM25033a = C3646e.m25033a(this);
        String strM25036a = this.f23402c;
        if (strM25036a == null) {
            strM25036a = C3651a.m25036a(this.f23401b);
        }
        return aVarM25033a.m25035a("statusCode", strM25036a).m25035a("resolution", this.f23403d).toString();
    }

    public boolean equals(Object obj) {
        if (obj instanceof Status) {
            Status status = (Status) obj;
            if (this.f23400a == status.f23400a && this.f23401b == status.f23401b && C3646e.m25034a(this.f23402c, status.f23402c) && C3646e.m25034a(this.f23403d, status.f23403d)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
        int iM25116b = C3678b.m25116b(parcel, 20293);
        C3678b.m25115a(parcel, 1, this.f23401b);
        C3678b.m25115a(parcel, 1000, this.f23400a);
        String str = this.f23402c;
        if (str != null) {
            int iM25116b2 = C3678b.m25116b(parcel, 2);
            parcel.writeString(str);
            C3678b.m25114a(parcel, iM25116b2);
        }
        PendingIntent pendingIntent = this.f23403d;
        if (pendingIntent != null) {
            int iM25116b3 = C3678b.m25116b(parcel, 3);
            pendingIntent.writeToParcel(parcel, OplusGLSurfaceView_13);
            C3678b.m25114a(parcel, iM25116b3);
        }
        C3678b.m25114a(parcel, iM25116b);
    }
}
