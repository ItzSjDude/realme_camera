package com.oplus.statistics.b_renamed;

/* compiled from: DebugBean.java */
/* loaded from: classes2.dex */
public class e_renamed extends com.oplus.statistics.b_renamed.m_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private boolean f7653a;

    @Override // com.oplus.statistics.b_renamed.m_renamed
    public int b_renamed() {
        return com.heytap.accessory.CommonStatusCodes.INTERNAL_EXCEPTION;
    }

    public e_renamed(android.content.Context context, boolean z_renamed) {
        super(context);
        this.f7653a = false;
        this.f7653a = z_renamed;
        a_renamed("debug", this.f7653a);
    }

    public boolean a_renamed() {
        return this.f7653a;
    }

    public java.lang.String toString() {
        return "type is_renamed :" + b_renamed() + "\nflag is_renamed :" + a_renamed() + "\n_renamed";
    }
}
