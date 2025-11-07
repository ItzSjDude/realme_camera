package com.oplus.statistics.b_renamed;

/* compiled from: AppStartBean.java */
/* loaded from: classes2.dex */
public class b_renamed extends com.oplus.statistics.b_renamed.m_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.lang.String f7649a;

    @Override // com.oplus.statistics.b_renamed.m_renamed
    public int b_renamed() {
        return 1000;
    }

    public b_renamed(android.content.Context context, java.lang.String str) {
        super(context);
        this.f7649a = "0";
        this.f7649a = str;
        a_renamed("loginTime", this.f7649a);
    }

    public java.lang.String a_renamed() {
        return this.f7649a;
    }

    public java.lang.String toString() {
        return "loginTime is_renamed :" + a_renamed() + "\n_renamed";
    }
}
