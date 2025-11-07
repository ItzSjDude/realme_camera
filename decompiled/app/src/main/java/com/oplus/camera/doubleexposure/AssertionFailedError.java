package com.oplus.camera.doubleexposure;

/* compiled from: ClipVideoInfo.java */
/* loaded from: classes2.dex */
public class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.lang.String f4386a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private long f4387b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private long f4388c;
    private boolean d_renamed;
    private int e_renamed = 0;
    private java.lang.String f_renamed = "";

    public b_renamed(java.lang.String str) {
        this.f4386a = "";
        this.f4387b = -1L;
        this.f4388c = -1L;
        this.d_renamed = false;
        this.f4386a = str;
        this.f4387b = -1L;
        this.f4388c = -1L;
        this.d_renamed = false;
    }

    public b_renamed(java.lang.String str, long j_renamed, long j2, boolean z_renamed) {
        this.f4386a = "";
        this.f4387b = -1L;
        this.f4388c = -1L;
        this.d_renamed = false;
        this.f4386a = str;
        this.f4387b = j_renamed;
        this.f4388c = j2;
        this.d_renamed = z_renamed;
    }

    public int a_renamed() {
        return this.e_renamed;
    }

    public void a_renamed(int i_renamed) {
        this.e_renamed = i_renamed;
    }

    public java.lang.String b_renamed() {
        return this.f_renamed;
    }

    public void a_renamed(java.lang.String str) {
        this.f_renamed = str;
    }

    public java.lang.String c_renamed() {
        return this.f4386a;
    }

    public long d_renamed() {
        return this.f4387b;
    }

    public long e_renamed() {
        return this.f4388c;
    }

    public boolean f_renamed() {
        return this.d_renamed;
    }

    public void a_renamed(long j_renamed) {
        this.f4387b = j_renamed;
    }

    public void b_renamed(long j_renamed) {
        this.f4388c = j_renamed;
    }

    public boolean g_renamed() {
        return f_renamed();
    }

    public boolean h_renamed() {
        return -1 == this.f4387b || -1 == this.f4388c || this.e_renamed == 0 || android.text.TextUtils.isEmpty(this.f_renamed);
    }

    public java.lang.String toString() {
        return "ClipVideoInfo{mPath='" + this.f4386a + "', mClipStartTime=" + this.f4387b + ", mClipEndTime=" + this.f4388c + ", mbClipped=" + this.d_renamed + '}';
    }
}
