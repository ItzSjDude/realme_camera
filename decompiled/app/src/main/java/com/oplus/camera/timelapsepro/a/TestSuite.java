package com.oplus.camera.timelapsepro.a_renamed;

/* compiled from: SpeedWrapper.java */
/* loaded from: classes2.dex */
public class i_renamed extends com.oplus.camera.timelapsepro.a_renamed.g_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.text.DecimalFormat f5648a = new java.text.DecimalFormat("###################.###########");

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.lang.String f5649b;

    public i_renamed(java.lang.String str) throws android.content.res.Resources.NotFoundException, java.lang.NumberFormatException {
        java.lang.String string;
        this.f5649b = str;
        this.f5647c = str;
        this.d_renamed = "x_renamed";
        double d_renamed = java.lang.Double.parseDouble(str) / 30.0d;
        int i_renamed = java.lang.Integer.parseInt(this.f5649b);
        com.oplus.camera.MyApplication.d_renamed().getResources().getString(com.oplus.camera.R_renamed.string.time_lapse_pro_setting_of_speed_desc_secsond);
        if (i_renamed <= java.lang.Integer.parseInt(com.oplus.camera.MyApplication.d_renamed().getResources().getString(com.oplus.camera.R_renamed.string.time_lapse_pro_speed_90x))) {
            string = com.oplus.camera.MyApplication.d_renamed().getResources().getString(com.oplus.camera.R_renamed.string.camera_time_lapse_pro_setting_of_shooting_interval_city_tips);
        } else if (i_renamed <= java.lang.Integer.parseInt(com.oplus.camera.MyApplication.d_renamed().getResources().getString(com.oplus.camera.R_renamed.string.time_lapse_pro_speed_150x))) {
            string = com.oplus.camera.MyApplication.d_renamed().getResources().getString(com.oplus.camera.R_renamed.string.camera_time_lapse_pro_setting_of_shooting_interval_sun_tips);
        } else if (i_renamed <= java.lang.Integer.parseInt(com.oplus.camera.MyApplication.d_renamed().getResources().getString(com.oplus.camera.R_renamed.string.time_lapse_pro_speed_450x))) {
            string = com.oplus.camera.MyApplication.d_renamed().getResources().getString(com.oplus.camera.R_renamed.string.camera_time_lapse_pro_setting_of_shooting_interval_cloud_tips);
        } else if (i_renamed <= java.lang.Integer.parseInt(com.oplus.camera.MyApplication.d_renamed().getResources().getString(com.oplus.camera.R_renamed.string.time_lapse_pro_speed_900x))) {
            string = com.oplus.camera.MyApplication.d_renamed().getResources().getString(com.oplus.camera.R_renamed.string.camera_time_lapse_pro_setting_of_shooting_interval_star_tips);
        } else {
            string = com.oplus.camera.MyApplication.d_renamed().getResources().getString(com.oplus.camera.R_renamed.string.camera_time_lapse_pro_setting_of_shooting_interval_flower_tips);
        }
        this.e_renamed = java.lang.String.format(string, f5648a.format(d_renamed));
    }

    public java.lang.String d_renamed() {
        return this.f5649b;
    }
}
