package com.oplusos.sau.aidl;

/* loaded from: classes2.dex */
public class DataresUpdateInfo implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator CREATOR = new com.oplusos.sau.aidl.b_renamed();

    /* renamed from: a_renamed, reason: collision with root package name */
    public java.lang.String f7759a;

    /* renamed from: b_renamed, reason: collision with root package name */
    public int f7760b;

    /* renamed from: c_renamed, reason: collision with root package name */
    public int f7761c;
    public long d_renamed;
    public long e_renamed;
    public long f_renamed;
    public int g_renamed;
    public int h_renamed;

    public DataresUpdateInfo() {
        this.g_renamed = -1;
    }

    protected DataresUpdateInfo(android.os.Parcel parcel) {
        this.g_renamed = -1;
        this.f7759a = parcel.readString();
        this.f7760b = parcel.readInt();
        this.f7761c = parcel.readInt();
        this.d_renamed = parcel.readLong();
        this.e_renamed = parcel.readLong();
        this.f_renamed = parcel.readLong();
        this.g_renamed = parcel.readInt();
        this.h_renamed = parcel.readInt();
    }

    public DataresUpdateInfo(com.oplusos.sau.aidl.DataresUpdateInfo dataresUpdateInfo) {
        this.g_renamed = -1;
        this.f7759a = dataresUpdateInfo.f7759a;
        this.f7760b = dataresUpdateInfo.f7760b;
        this.f7761c = dataresUpdateInfo.f7761c;
        this.e_renamed = dataresUpdateInfo.e_renamed;
        this.d_renamed = dataresUpdateInfo.d_renamed;
        this.f_renamed = dataresUpdateInfo.f_renamed;
        this.g_renamed = dataresUpdateInfo.g_renamed;
        this.h_renamed = dataresUpdateInfo.h_renamed;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.lang.String toString() {
        return "busCode=" + this.f7759a + ", currentVersion=" + this.f7760b + ", newVersion=" + this.f7761c + ", currentSize=" + this.d_renamed + ", downloadSpeed=" + this.f_renamed + ", downloadStatus=" + this.g_renamed + ", flag=" + this.h_renamed;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeString(this.f7759a);
        parcel.writeInt(this.f7760b);
        parcel.writeInt(this.f7761c);
        parcel.writeLong(this.d_renamed);
        parcel.writeLong(this.e_renamed);
        parcel.writeLong(this.f_renamed);
        parcel.writeInt(this.g_renamed);
        parcel.writeInt(this.h_renamed);
    }
}
