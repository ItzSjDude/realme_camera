package com.oplusos.sau.aidl;

/* loaded from: classes2.dex */
public class AppUpdateInfo implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator CREATOR = new com.oplusos.sau.aidl.a_renamed();

    /* renamed from: a_renamed, reason: collision with root package name */
    public int f7756a;

    /* renamed from: b_renamed, reason: collision with root package name */
    public int f7757b;

    /* renamed from: c_renamed, reason: collision with root package name */
    public int f7758c;
    public int d_renamed;
    public int e_renamed;
    public int f_renamed;
    public int g_renamed;
    public long h_renamed;
    public long i_renamed;
    public long j_renamed;
    public java.lang.String k_renamed;
    public java.lang.String l_renamed;
    public java.lang.String m_renamed;

    public AppUpdateInfo() {
        this.e_renamed = -1;
    }

    protected AppUpdateInfo(android.os.Parcel parcel) {
        this.e_renamed = -1;
        this.k_renamed = parcel.readString();
        this.f7756a = parcel.readInt();
        this.l_renamed = parcel.readString();
        this.m_renamed = parcel.readString();
        this.h_renamed = parcel.readLong();
        this.i_renamed = parcel.readLong();
        this.j_renamed = parcel.readLong();
        this.f7757b = parcel.readInt();
        this.f7758c = parcel.readInt();
        this.d_renamed = parcel.readInt();
        this.e_renamed = parcel.readInt();
        this.f_renamed = parcel.readInt();
        this.g_renamed = parcel.readInt();
    }

    public AppUpdateInfo(com.oplusos.sau.aidl.AppUpdateInfo appUpdateInfo) {
        this.e_renamed = -1;
        this.k_renamed = appUpdateInfo.k_renamed;
        this.f7756a = appUpdateInfo.f7756a;
        this.l_renamed = appUpdateInfo.l_renamed;
        this.m_renamed = appUpdateInfo.m_renamed;
        this.h_renamed = appUpdateInfo.h_renamed;
        this.i_renamed = appUpdateInfo.i_renamed;
        this.j_renamed = appUpdateInfo.j_renamed;
        this.f7757b = appUpdateInfo.f7757b;
        this.f7758c = appUpdateInfo.f7758c;
        this.d_renamed = appUpdateInfo.d_renamed;
        this.e_renamed = appUpdateInfo.e_renamed;
        this.f_renamed = appUpdateInfo.f_renamed;
        this.g_renamed = appUpdateInfo.g_renamed;
    }

    public final boolean a_renamed() {
        return (this.f_renamed & 8) != 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.lang.String toString() {
        return "pkg=" + this.k_renamed + ",newVersion=" + this.f7756a + ",verName=" + this.l_renamed + ",currentSize=" + this.h_renamed + ",totalSize=" + this.i_renamed + ",downloadSpeed=" + this.j_renamed + ",downloadState=" + this.e_renamed + ",stateFlag=" + this.f_renamed + ",isAutoDownload=" + this.f7757b + ",isAutoInstall=" + this.f7758c + ",canUseOld=" + this.d_renamed + ",description=" + this.m_renamed;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeString(this.k_renamed);
        parcel.writeInt(this.f7756a);
        parcel.writeString(this.l_renamed);
        parcel.writeString(this.m_renamed);
        parcel.writeLong(this.h_renamed);
        parcel.writeLong(this.i_renamed);
        parcel.writeLong(this.j_renamed);
        parcel.writeInt(this.f7757b);
        parcel.writeInt(this.f7758c);
        parcel.writeInt(this.d_renamed);
        parcel.writeInt(this.e_renamed);
        parcel.writeInt(this.f_renamed);
        parcel.writeInt(this.g_renamed);
    }
}
