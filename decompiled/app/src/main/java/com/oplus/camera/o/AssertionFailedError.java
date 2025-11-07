package com.oplus.camera.o_renamed;

/* compiled from: QrCodeResult.java */
/* loaded from: classes2.dex */
public class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.lang.String f4912a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.oplus.camera.o_renamed.b_renamed.a_renamed f4913b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.lang.String f4914c;
    private android.graphics.RectF d_renamed;
    private int e_renamed;
    private int f_renamed;
    private boolean g_renamed = false;

    /* compiled from: QrCodeResult.java */
    public enum a_renamed {
        HTTP,
        INSTANT,
        WIFI,
        NONE
    }

    public b_renamed(java.lang.String str, com.oplus.camera.o_renamed.b_renamed.a_renamed aVar, java.lang.String str2, android.graphics.RectF rectF, int i_renamed, int i2) {
        this.f4912a = "";
        this.f4913b = null;
        this.f4914c = "";
        this.d_renamed = null;
        this.e_renamed = 0;
        this.f_renamed = 0;
        this.f4912a = str;
        this.f4913b = aVar;
        this.f4914c = str2;
        this.d_renamed = rectF;
        this.e_renamed = i_renamed;
        this.f_renamed = i2;
    }

    public java.lang.String a_renamed() {
        return this.f4912a;
    }

    public java.lang.String b_renamed() {
        return this.f4914c;
    }

    public com.oplus.camera.o_renamed.b_renamed.a_renamed c_renamed() {
        return this.f4913b;
    }

    public android.graphics.RectF d_renamed() {
        return this.d_renamed;
    }

    public int e_renamed() {
        return this.e_renamed;
    }

    public int f_renamed() {
        return this.f_renamed;
    }

    public synchronized boolean g_renamed() {
        return this.g_renamed;
    }

    public synchronized void a_renamed(boolean z_renamed) {
        this.g_renamed = z_renamed;
    }

    public java.lang.String toString() {
        return "QrCodeResult{mContent='" + this.f4912a + "', mType=" + this.f4913b + ", mScanStatus='" + this.f4914c + "'}";
    }
}
