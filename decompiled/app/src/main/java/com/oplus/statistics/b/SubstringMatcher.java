package com.oplus.statistics.b_renamed;

/* compiled from: SettingKeyDataBean.java */
/* loaded from: classes2.dex */
public class k_renamed extends com.oplus.statistics.b_renamed.d_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    private final int f7666b;

    public k_renamed(android.content.Context context) {
        super(context);
        this.f7666b = com.oplus.statistics.f_renamed.g_renamed.a_renamed(context) ? 1020 : com.heytap.accessory.CommonStatusCodes.AUTHCODE_RECYCLE;
        a_renamed("dataType", this.f7666b);
    }

    @Override // com.oplus.statistics.b_renamed.d_renamed, com.oplus.statistics.b_renamed.m_renamed
    public int b_renamed() {
        return this.f7666b;
    }

    public void a_renamed(java.util.List<com.oplus.statistics.b_renamed.j_renamed> list) {
        super.c_renamed(com.oplus.statistics.a_renamed.i_renamed.a_renamed(list).toString());
    }

    @Override // com.oplus.statistics.b_renamed.d_renamed
    public java.lang.String toString() {
        return " type is_renamed :" + b_renamed() + ", tag is_renamed :" + c_renamed() + ", eventID is_renamed :" + a_renamed() + ", map is_renamed :" + d_renamed();
    }
}
