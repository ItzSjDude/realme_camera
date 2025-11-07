package com.oplus.statistics.b_renamed;

/* compiled from: CommonBean.java */
/* loaded from: classes2.dex */
public class d_renamed extends com.oplus.statistics.b_renamed.m_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    protected java.lang.String f7650a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.lang.String f7651b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.lang.String f7652c;
    private int d_renamed;

    @Override // com.oplus.statistics.b_renamed.m_renamed
    public int b_renamed() {
        return com.heytap.accessory.CommonStatusCodes.AUTHCODE_RECYCLE;
    }

    public d_renamed(android.content.Context context) {
        super(context);
        this.f7650a = "";
        this.f7651b = "";
        this.f7652c = "";
        this.d_renamed = 0;
    }

    public d_renamed(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        super(context);
        this.f7650a = "";
        this.f7651b = "";
        this.f7652c = "";
        this.d_renamed = 0;
        this.f7651b = str2;
        this.f7652c = str3;
        d_renamed(str);
        a_renamed("logTag", this.f7651b);
        a_renamed("eventID", this.f7652c);
    }

    public java.lang.String a_renamed() {
        return this.f7652c;
    }

    public void a_renamed(java.lang.String str) {
        this.f7652c = str;
        a_renamed("eventID", this.f7652c);
    }

    public java.lang.String c_renamed() {
        return this.f7651b;
    }

    public void b_renamed(java.lang.String str) {
        this.f7651b = str;
        a_renamed("logTag", this.f7651b);
    }

    public java.lang.String d_renamed() {
        return this.f7650a;
    }

    public void a_renamed(java.util.Map<java.lang.String, java.lang.String> map) {
        this.f7650a = com.oplus.statistics.f_renamed.c_renamed.a_renamed(map).toString();
        a_renamed("logMap", this.f7650a);
    }

    public void c_renamed(java.lang.String str) {
        this.f7650a = str;
        a_renamed("logMap", this.f7650a);
    }

    public int e_renamed() {
        return this.d_renamed;
    }

    public void a_renamed(int i_renamed) {
        this.d_renamed = i_renamed;
        a_renamed("appId", this.d_renamed);
    }

    public java.lang.String toString() {
        return " type is_renamed :" + b_renamed() + ", tag is_renamed :" + c_renamed() + ", eventID is_renamed :" + a_renamed() + ", map is_renamed :" + d_renamed();
    }
}
