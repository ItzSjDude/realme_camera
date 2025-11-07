package com.oplus.statistics.b_renamed;

/* compiled from: PeriodDataBean.java */
/* loaded from: classes2.dex */
public class i_renamed extends com.oplus.statistics.b_renamed.d_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    private final int f7662b;

    public i_renamed(android.content.Context context) {
        super(context);
        this.f7662b = com.oplus.statistics.f_renamed.g_renamed.a_renamed(context) ? 1019 : com.heytap.accessory.CommonStatusCodes.AUTHCODE_RECYCLE;
        a_renamed("dataType", this.f7662b);
    }

    @Override // com.oplus.statistics.b_renamed.d_renamed, com.oplus.statistics.b_renamed.m_renamed
    public int b_renamed() {
        return this.f7662b;
    }

    @Override // com.oplus.statistics.b_renamed.d_renamed
    public java.lang.String toString() {
        return " type is_renamed :" + b_renamed() + ", tag is_renamed :" + c_renamed() + ", eventID is_renamed :" + a_renamed() + ", map is_renamed :" + d_renamed();
    }
}
