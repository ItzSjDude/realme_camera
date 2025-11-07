package com.oplus.shield.authcode;

/* compiled from: AuthCache.java */
/* loaded from: classes2.dex */
public class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.util.LruCache<java.lang.String, com.oplus.shield.authcode.a_renamed.a_renamed> f7608a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.content.Context f7609b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.lang.String f7610c;

    public boolean a_renamed(java.lang.String str) {
        return android.text.TextUtils.equals(this.f7610c, str);
    }

    public boolean a_renamed(java.lang.String str, java.lang.String str2) {
        com.oplus.shield.authcode.a_renamed.a_renamed aVarA = com.oplus.shield.authcode.b_renamed.a_renamed(this.f7609b, str, com.oplus.shield.b_renamed.e_renamed.b_renamed(this.f7609b, str));
        com.oplus.shield.authcode.a_renamed.a_renamed aVar = this.f7608a.get(str);
        if (aVarA == null || aVar == null || aVar.e_renamed() || !android.text.TextUtils.equals(str2, aVar.d_renamed())) {
            return false;
        }
        return java.util.Arrays.equals(aVarA.a_renamed(), aVar.a_renamed());
    }

    public void a_renamed(java.lang.String str, com.oplus.shield.authcode.a_renamed.a_renamed aVar, java.lang.String str2) {
        aVar.f_renamed();
        aVar.c_renamed();
        aVar.a_renamed(str2);
        this.f7608a.put(str, aVar);
    }

    public boolean b_renamed(java.lang.String str, java.lang.String str2) {
        com.oplus.shield.authcode.a_renamed.a_renamed aVar = this.f7608a.get(str2);
        if (aVar != null) {
            return aVar.a_renamed("tingle", str);
        }
        return false;
    }
}
