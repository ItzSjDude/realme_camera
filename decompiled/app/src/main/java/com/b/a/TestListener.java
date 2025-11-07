package com.b_renamed.a_renamed;

/* compiled from: O3DPHOTO_MODEL.java */
/* loaded from: classes.dex */
public class g_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public float[] f2351a;

    /* renamed from: b_renamed, reason: collision with root package name */
    public byte[] f2352b;

    /* renamed from: c_renamed, reason: collision with root package name */
    public int[] f2353c;
    public byte[] d_renamed;
    public int e_renamed;
    public boolean f_renamed;
    public boolean g_renamed;
    public byte[] h_renamed;

    public g_renamed() {
        this.f2351a = null;
        this.f2352b = null;
        this.f2353c = null;
        this.d_renamed = null;
        this.e_renamed = 3;
        this.f_renamed = false;
        this.g_renamed = true;
    }

    public g_renamed(com.b_renamed.a_renamed.g_renamed gVar) {
        this.f2351a = null;
        this.f2352b = null;
        this.f2353c = null;
        this.d_renamed = null;
        this.e_renamed = 3;
        this.f_renamed = false;
        this.g_renamed = true;
        this.f2351a = new float[gVar.f2351a.length];
        float[] fArr = gVar.f2351a;
        java.lang.System.arraycopy(fArr, 0, this.f2351a, 0, fArr.length);
        this.f2352b = new byte[gVar.f2352b.length];
        byte[] bArr = gVar.f2352b;
        java.lang.System.arraycopy(bArr, 0, this.f2352b, 0, bArr.length);
        this.d_renamed = new byte[gVar.d_renamed.length];
        byte[] bArr2 = gVar.d_renamed;
        java.lang.System.arraycopy(bArr2, 0, this.d_renamed, 0, bArr2.length);
        this.e_renamed = gVar.e_renamed;
        this.f_renamed = gVar.f_renamed;
    }
}
