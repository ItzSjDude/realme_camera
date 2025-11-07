package com.oplus.camera.timelapsepro.a_renamed;

/* compiled from: ResetParameter.java */
/* loaded from: classes2.dex */
public class f_renamed extends com.oplus.camera.timelapsepro.a_renamed.e_renamed {
    @Override // com.oplus.camera.timelapsepro.a_renamed.e_renamed
    public boolean a_renamed() {
        return false;
    }

    @Override // com.oplus.camera.timelapsepro.a_renamed.e_renamed
    public int c_renamed() {
        return com.oplus.camera.R_renamed.drawable.time_lapse_pro_reset_icon;
    }

    @Override // com.oplus.camera.timelapsepro.a_renamed.e_renamed
    public java.lang.String d_renamed() {
        return "";
    }

    @Override // com.oplus.camera.timelapsepro.a_renamed.e_renamed
    public int l_renamed() {
        return com.oplus.camera.R_renamed.raw.pro_reset_animation;
    }

    @Override // com.oplus.camera.timelapsepro.a_renamed.e_renamed
    public boolean m_renamed() {
        return true;
    }

    public f_renamed(android.app.Activity activity) {
        super(activity, "pref_time_lapse_pro_reset_key", 0);
        b_renamed(false);
    }

    @Override // com.oplus.camera.timelapsepro.a_renamed.e_renamed
    public java.lang.String e_renamed() {
        return com.oplus.camera.MyApplication.d_renamed().getResources().getString(com.oplus.camera.R_renamed.string.camera_face_beauty_menu_reset);
    }
}
