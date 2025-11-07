package com.oplus.statistics.b_renamed;

/* compiled from: ExceptionBean.java */
/* loaded from: classes2.dex */
public class g_renamed extends com.oplus.statistics.b_renamed.m_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private long f7656a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.lang.String f7657b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f7658c;

    @Override // com.oplus.statistics.b_renamed.m_renamed
    public int b_renamed() {
        return com.heytap.accessory.CommonStatusCodes.AUTHCODE_EXPECTED;
    }

    public g_renamed(android.content.Context context) {
        super(context);
    }

    public long a_renamed() {
        return this.f7656a;
    }

    public void a_renamed(long j_renamed) {
        this.f7656a = j_renamed;
        a_renamed("time", this.f7656a);
    }

    public java.lang.String c_renamed() {
        return this.f7657b;
    }

    public void a_renamed(java.lang.String str) {
        this.f7657b = str;
        a_renamed("exception", this.f7657b);
    }

    public int d_renamed() {
        return this.f7658c;
    }

    public void a_renamed(int i_renamed) {
        this.f7658c = i_renamed;
        a_renamed("time", this.f7658c);
    }

    public java.lang.String toString() {
        return "exception is_renamed :" + c_renamed() + "\ncount is_renamed :" + d_renamed() + "\ntime is_renamed :" + a_renamed() + "\n_renamed";
    }
}
