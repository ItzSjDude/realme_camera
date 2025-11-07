package com.oplus.statistics.b_renamed;

/* compiled from: DynamicEventBean.java */
/* loaded from: classes2.dex */
public class f_renamed extends com.oplus.statistics.b_renamed.m_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.lang.String f7654a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f7655b;

    @Override // com.oplus.statistics.b_renamed.m_renamed
    public int b_renamed() {
        return com.heytap.accessory.CommonStatusCodes.AUTHCODE_INVALID;
    }

    public f_renamed(android.content.Context context, int i_renamed, java.lang.String str) {
        super(context);
        this.f7654a = "";
        this.f7655b = 0;
        this.f7655b = i_renamed;
        this.f7654a = str;
        a_renamed("uploadMode", this.f7655b);
        a_renamed("eventBody", this.f7654a);
    }

    public java.lang.String a_renamed() {
        return this.f7654a;
    }

    public java.lang.String toString() {
        return "uploadMode is_renamed :" + this.f7655b + "\nbody is_renamed :" + a_renamed() + "\n_renamed";
    }
}
