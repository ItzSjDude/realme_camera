package com.oplus.camera.timelapsepro.a_renamed;

/* compiled from: DurationWrapper.java */
/* loaded from: classes2.dex */
public class a_renamed extends com.oplus.camera.timelapsepro.a_renamed.g_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f5640a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private long f5641b = 0;

    public a_renamed(int i_renamed) {
        this.f5640a = i_renamed;
        if (i_renamed <= 0) {
            this.f5647c = com.oplus.camera.MyApplication.d_renamed().getResources().getString(com.oplus.camera.R_renamed.string.time_lapse_pro_duration_endless);
            this.d_renamed = "";
            this.e_renamed = com.oplus.camera.MyApplication.d_renamed().getResources().getString(com.oplus.camera.R_renamed.string.time_lapse_pro_unlimited_time);
        } else {
            this.f5647c = java.lang.String.valueOf(i_renamed);
            this.d_renamed = com.oplus.camera.MyApplication.d_renamed().getResources().getString(com.oplus.camera.R_renamed.string.time_lapse_pro_setting_of_duration_unit);
        }
    }

    public com.oplus.camera.timelapsepro.a_renamed.a_renamed a_renamed(com.oplus.camera.timelapsepro.a_renamed.i_renamed iVar) {
        if (this.f5640a > 0 && iVar != null) {
            a_renamed(iVar.d_renamed());
        }
        return this;
    }

    public void a_renamed(java.lang.String str) {
        double d_renamed = java.lang.Double.parseDouble(str);
        int i_renamed = this.f5640a;
        this.f5641b = (long) ((i_renamed * 60) / (d_renamed / 30.0d));
        this.e_renamed = java.lang.String.format(com.oplus.camera.MyApplication.d_renamed().getResources().getString(com.oplus.camera.R_renamed.string.time_lapse_pro_setting_of_duration_with_second), java.lang.Integer.valueOf((int) ((i_renamed * 60) / d_renamed)));
    }

    public long a_renamed() {
        return this.f5641b;
    }

    public int b_renamed() {
        return this.f5640a;
    }
}
