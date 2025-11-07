package com.oplus.statistics.b_renamed;

/* compiled from: StaticEventBean.java */
/* loaded from: classes2.dex */
public class l_renamed extends com.oplus.statistics.b_renamed.m_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f7667a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.lang.String f7668b;

    @Override // com.oplus.statistics.b_renamed.m_renamed
    public int b_renamed() {
        return com.heytap.accessory.CommonStatusCodes.CAPABILITY_EXCEPTION;
    }

    public l_renamed(android.content.Context context, int i_renamed, java.lang.String str) {
        super(context);
        this.f7667a = 0;
        this.f7668b = "";
        this.f7667a = i_renamed;
        this.f7668b = str;
        a_renamed("uploadMode", this.f7667a);
        a_renamed("eventBody", this.f7668b);
    }

    public java.lang.String a_renamed() {
        return this.f7668b;
    }

    public java.lang.String toString() {
        return "uploadMode is_renamed :" + this.f7667a + "\nbody is_renamed :" + a_renamed() + "\n_renamed";
    }
}
