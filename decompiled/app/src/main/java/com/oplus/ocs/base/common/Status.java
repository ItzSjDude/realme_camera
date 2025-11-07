package com.oplus.ocs.base.common;

/* loaded from: classes2.dex */
public class Status extends com.oplus.ocs.base.internal.safeparcel.AbstractSafeParcelable {
    public static final android.os.Parcelable.Creator<com.oplus.ocs.base.common.Status> CREATOR = new com.oplus.ocs.base.common.c_renamed();

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f7527a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f7528b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.lang.String f7529c;
    private android.app.PendingIntent d_renamed;

    Status(int i_renamed, int i2, java.lang.String str, android.app.PendingIntent pendingIntent) {
        this.f7527a = i_renamed;
        this.f7528b = i2;
        this.f7529c = str;
        this.d_renamed = pendingIntent;
    }

    public int hashCode() {
        return java.util.Arrays.hashCode(new java.lang.Object[]{java.lang.Integer.valueOf(this.f7527a), java.lang.Integer.valueOf(this.f7528b), this.f7529c, this.d_renamed});
    }

    public java.lang.String toString() {
        com.oplus.ocs.base.b_renamed.e_renamed.a_renamed aVarA = com.oplus.ocs.base.b_renamed.e_renamed.a_renamed(this);
        java.lang.String strA = this.f7529c;
        if (strA == null) {
            strA = com.oplus.ocs.base.common.a_renamed.a_renamed.a_renamed(this.f7528b);
        }
        return aVarA.a_renamed("statusCode", strA).a_renamed("resolution", this.d_renamed).toString();
    }

    public boolean equals(java.lang.Object obj) {
        if (obj instanceof com.oplus.ocs.base.common.Status) {
            com.oplus.ocs.base.common.Status status = (com.oplus.ocs.base.common.Status) obj;
            if (this.f7527a == status.f7527a && this.f7528b == status.f7528b && com.oplus.ocs.base.b_renamed.e_renamed.a_renamed(this.f7529c, status.f7529c) && com.oplus.ocs.base.b_renamed.e_renamed.a_renamed(this.d_renamed, status.d_renamed)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        int iB = com.oplus.ocs.base.internal.safeparcel.b_renamed.b_renamed(parcel, 20293);
        com.oplus.ocs.base.internal.safeparcel.b_renamed.a_renamed(parcel, 1, this.f7528b);
        com.oplus.ocs.base.internal.safeparcel.b_renamed.a_renamed(parcel, 1000, this.f7527a);
        java.lang.String str = this.f7529c;
        if (str != null) {
            int iB2 = com.oplus.ocs.base.internal.safeparcel.b_renamed.b_renamed(parcel, 2);
            parcel.writeString(str);
            com.oplus.ocs.base.internal.safeparcel.b_renamed.a_renamed(parcel, iB2);
        }
        android.app.PendingIntent pendingIntent = this.d_renamed;
        if (pendingIntent != null) {
            int iB3 = com.oplus.ocs.base.internal.safeparcel.b_renamed.b_renamed(parcel, 3);
            pendingIntent.writeToParcel(parcel, i_renamed);
            com.oplus.ocs.base.internal.safeparcel.b_renamed.a_renamed(parcel, iB3);
        }
        com.oplus.ocs.base.internal.safeparcel.b_renamed.a_renamed(parcel, iB);
    }
}
