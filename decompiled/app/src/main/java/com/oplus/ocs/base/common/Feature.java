package com.oplus.ocs.base.common;

/* loaded from: classes2.dex */
public class Feature implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.oplus.ocs.base.common.Feature> CREATOR = new android.os.Parcelable.Creator<com.oplus.ocs.base.common.Feature>() { // from class: com.oplus.ocs.base.common.Feature.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.oplus.ocs.base.common.Feature[] newArray(int i_renamed) {
            return new com.oplus.ocs.base.common.Feature[i_renamed];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.oplus.ocs.base.common.Feature createFromParcel(android.os.Parcel parcel) {
            return new com.oplus.ocs.base.common.Feature(parcel);
        }
    };

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.lang.String f7525a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private long f7526b;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Feature(java.lang.String str, long j_renamed) {
        this.f7525a = str;
        this.f7526b = j_renamed;
    }

    protected Feature(android.os.Parcel parcel) {
        this.f7525a = parcel.readString();
        this.f7526b = parcel.readLong();
    }

    public java.lang.String getName() {
        return this.f7525a;
    }

    public long getVersion() {
        long j_renamed = this.f7526b;
        if (j_renamed == -1) {
            return -1L;
        }
        return j_renamed;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeString(this.f7525a);
        parcel.writeLong(this.f7526b);
    }
}
