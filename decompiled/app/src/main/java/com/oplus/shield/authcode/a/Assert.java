package com.oplus.shield.authcode.a_renamed;

/* compiled from: AuthResult.java */
/* loaded from: classes2.dex */
public class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.lang.String f7611a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f7612b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private byte[] f7613c;
    private long d_renamed;
    private java.util.Map<java.lang.String, com.oplus.shield.authcode.d_renamed> e_renamed;
    private java.lang.String f_renamed;

    public a_renamed(java.lang.String str, int i_renamed, byte[] bArr) {
        this.f7611a = str;
        this.f7612b = i_renamed;
        this.f7613c = bArr;
    }

    public byte[] a_renamed() {
        return this.f7613c;
    }

    public int b_renamed() {
        return this.f7612b;
    }

    public void c_renamed() {
        this.d_renamed = java.lang.System.currentTimeMillis();
    }

    public void a_renamed(java.lang.String str) {
        this.f_renamed = str;
    }

    public java.lang.String d_renamed() {
        return this.f_renamed;
    }

    public boolean e_renamed() {
        return java.lang.System.currentTimeMillis() - this.d_renamed > com.oplus.shield.a_renamed.f7601a;
    }

    public void f_renamed() {
        this.e_renamed = new java.util.concurrent.ConcurrentHashMap();
        for (java.lang.String str : com.oplus.shield.b_renamed.h_renamed.a_renamed(new java.lang.String(this.f7613c), ";")) {
            int iIndexOf = str.indexOf(",");
            if (iIndexOf != -1) {
                java.lang.String strSubstring = str.substring(0, iIndexOf);
                java.lang.String strSubstring2 = str.substring(iIndexOf + 1);
                if (android.text.TextUtils.equals(strSubstring, "epona") || android.text.TextUtils.equals(strSubstring, "tingle")) {
                    this.e_renamed.put(strSubstring, new com.oplus.shield.authcode.d_renamed(strSubstring2));
                    com.oplus.shield.b_renamed.d_renamed.a_renamed("Package : " + this.f7611a + " Permission : type [" + strSubstring + "] -" + com.oplus.shield.b_renamed.h_renamed.a_renamed(strSubstring2, ","));
                }
            }
        }
    }

    public boolean a_renamed(java.lang.String str, java.lang.String str2) {
        com.oplus.shield.authcode.d_renamed dVar = this.e_renamed.get(str);
        if (dVar != null) {
            return dVar.a_renamed(str2);
        }
        return false;
    }
}
