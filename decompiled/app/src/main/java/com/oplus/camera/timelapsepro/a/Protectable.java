package com.oplus.camera.timelapsepro.a_renamed;

/* compiled from: FocusParameter.java */
/* loaded from: classes2.dex */
public class c_renamed extends com.oplus.camera.timelapsepro.a_renamed.e_renamed {
    private java.lang.String f_renamed;
    private java.lang.String g_renamed;
    private int h_renamed;

    @Override // com.oplus.camera.timelapsepro.a_renamed.e_renamed
    public int c_renamed() {
        return com.oplus.camera.R_renamed.drawable.time_lapse_pro_focus_icon;
    }

    public c_renamed(android.app.Activity activity) {
        super(activity, "pref_time_lapse_pro_focus_mode_key", 4);
        this.f_renamed = "";
        this.g_renamed = "";
        this.h_renamed = 0;
        a_renamed(true);
    }

    @Override // com.oplus.camera.timelapsepro.a_renamed.e_renamed
    public void a_renamed(int i_renamed) {
        super.a_renamed(i_renamed);
        if (this.h_renamed == i_renamed) {
            return;
        }
        this.e_renamed = i_renamed;
        this.f_renamed = this.f5644c.get(i_renamed);
        this.g_renamed = this.d_renamed.get(i_renamed);
        p_renamed();
        this.h_renamed = i_renamed;
    }

    @Override // com.oplus.camera.timelapsepro.a_renamed.e_renamed
    public java.lang.String d_renamed() {
        return this.f_renamed;
    }

    @Override // com.oplus.camera.timelapsepro.a_renamed.e_renamed
    public java.lang.String e_renamed() {
        return this.g_renamed;
    }
}
