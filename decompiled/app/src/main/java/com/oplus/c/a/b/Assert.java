package com.oplus.c_renamed.a_renamed.b_renamed;

/* compiled from: MediaItem.kt */
/* loaded from: classes2.dex */
public final class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f3754a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f3755b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f3756c;
    private java.lang.String d_renamed;
    private final java.lang.String e_renamed;
    private final java.lang.String f_renamed;
    private final android.net.Uri g_renamed;
    private final int h_renamed;
    private final long i_renamed;
    private final boolean j_renamed;
    private final boolean k_renamed;

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.oplus.c_renamed.a_renamed.b_renamed.a_renamed)) {
            return false;
        }
        com.oplus.c_renamed.a_renamed.b_renamed.a_renamed aVar = (com.oplus.c_renamed.a_renamed.b_renamed.a_renamed) obj;
        return c_renamed.f_renamed.b_renamed.h_renamed.a_renamed((java.lang.Object) this.e_renamed, (java.lang.Object) aVar.e_renamed) && c_renamed.f_renamed.b_renamed.h_renamed.a_renamed((java.lang.Object) this.f_renamed, (java.lang.Object) aVar.f_renamed) && c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(this.g_renamed, aVar.g_renamed) && this.h_renamed == aVar.h_renamed && this.i_renamed == aVar.i_renamed && this.j_renamed == aVar.j_renamed && this.k_renamed == aVar.k_renamed;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        java.lang.String str = this.e_renamed;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        java.lang.String str2 = this.f_renamed;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        android.net.Uri uri = this.g_renamed;
        int iHashCode3 = (((((iHashCode2 + (uri != null ? uri.hashCode() : 0)) * 31) + java.lang.Integer.hashCode(this.h_renamed)) * 31) + java.lang.Long.hashCode(this.i_renamed)) * 31;
        boolean z_renamed = this.j_renamed;
        int i_renamed = z_renamed;
        if (z_renamed != 0) {
            i_renamed = 1;
        }
        int i2 = (iHashCode3 + i_renamed) * 31;
        boolean z2 = this.k_renamed;
        int i3 = z2;
        if (z2 != 0) {
            i3 = 1;
        }
        return i2 + i3;
    }

    public java.lang.String toString() {
        return "MediaItem(mediaId=" + this.e_renamed + ", filePath=" + this.f_renamed + ", uri=" + this.g_renamed + ", orientation=" + this.h_renamed + ", dateModifiedInSec=" + this.i_renamed + ", isVideo=" + this.j_renamed + ", isCshot=" + this.k_renamed + ")";
    }

    public a_renamed(java.lang.String str, java.lang.String str2, android.net.Uri uri, int i_renamed, long j_renamed, boolean z_renamed, boolean z2) {
        c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(str, "mediaId");
        c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(str2, com.oplus.ocs.camera.CameraParameter.WaterMarkParamKeys.FILE_PATH);
        c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(uri, com.android.providers.downloads.Downloads.Impl.COLUMN_URI);
        this.e_renamed = str;
        this.f_renamed = str2;
        this.g_renamed = uri;
        this.h_renamed = i_renamed;
        this.i_renamed = j_renamed;
        this.j_renamed = z_renamed;
        this.k_renamed = z2;
        this.d_renamed = "";
    }

    public final java.lang.String e_renamed() {
        return this.e_renamed;
    }

    public final java.lang.String f_renamed() {
        return this.f_renamed;
    }

    public final android.net.Uri g_renamed() {
        return this.g_renamed;
    }

    public final int h_renamed() {
        return this.h_renamed;
    }

    public final long i_renamed() {
        return this.i_renamed;
    }

    public final boolean j_renamed() {
        return this.j_renamed;
    }

    public final boolean k_renamed() {
        return this.k_renamed;
    }

    public final int a_renamed() {
        return this.f3754a;
    }

    public final void a_renamed(int i_renamed) {
        this.f3754a = i_renamed;
    }

    public final int b_renamed() {
        return this.f3755b;
    }

    public final void b_renamed(int i_renamed) {
        this.f3755b = i_renamed;
    }

    public final int c_renamed() {
        return this.f3756c;
    }

    public final void c_renamed(int i_renamed) {
        this.f3756c = i_renamed;
    }

    public final void a_renamed(java.lang.String str) {
        c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(str, "<set-?>");
        this.d_renamed = str;
    }

    public final java.lang.String d_renamed() {
        return this.d_renamed;
    }
}
