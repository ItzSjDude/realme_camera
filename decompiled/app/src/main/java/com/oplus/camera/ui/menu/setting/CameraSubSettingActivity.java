package com.oplus.camera.ui.menu.setting;

/* loaded from: classes2.dex */
public class CameraSubSettingActivity extends com.oplus.camera.ui.menu.setting.l_renamed {
    private int k_renamed = 0;

    @Override // com.oplus.camera.ui.menu.setting.l_renamed, androidx.appcompat.app.c_renamed, androidx.fragment.app.c_renamed, androidx.activity.b_renamed, androidx.core.app.e_renamed, android.app.Activity
    public void onCreate(android.os.Bundle bundle) throws android.content.res.Resources.NotFoundException, java.lang.ClassNotFoundException {
        super.onCreate(bundle);
        if (com.oplus.camera.util.Util.ao_renamed()) {
            setTheme(com.oplus.camera.R_renamed.style.AppNoTitleMoonTheme_PreferenceFragment);
        }
        setContentView(com.oplus.camera.R_renamed.layout.setting_delegate_layout);
        androidx.fragment.app.h_renamed hVarJ = j_renamed();
        com.oplus.camera.ui.menu.setting.p_renamed pVar = (com.oplus.camera.ui.menu.setting.p_renamed) hVarJ.a_renamed("com.oplus.camera.ui.menu.setting.CameraSubSettingActivity");
        if (pVar == null) {
            pVar = new com.oplus.camera.ui.menu.setting.p_renamed();
        }
        hVarJ.a_renamed().b_renamed(com.oplus.camera.R_renamed.id_renamed.fragment_container, pVar, "com.oplus.camera.ui.menu.setting.CameraSubSettingActivity").b_renamed();
        com.oplus.camera.e_renamed.a_renamed.a_renamed(getApplicationContext());
        com.oplus.camera.util.Util.c_renamed(getApplicationContext());
        android.content.Intent intent = getIntent();
        if ("oplus.intent.action.APP_SUB_SETTING".equals(intent.getAction())) {
            android.os.Bundle bundleExtra = intent.getBundleExtra("camera_intent_data");
            pVar.setArguments(bundleExtra);
            c_renamed(true);
            if (bundleExtra != null) {
                this.k_renamed = bundleExtra.getInt("camera_sub_setting_from");
                setTitle(k_renamed());
            }
        }
    }

    private java.lang.String k_renamed() {
        int i_renamed = this.k_renamed;
        if (1 == i_renamed) {
            return getString(com.oplus.camera.R_renamed.string.camera_setting_shooting_way);
        }
        if (2 == i_renamed) {
            return getString(com.oplus.camera.R_renamed.string.camera_setting_water_mark);
        }
        if (i_renamed == 0) {
            return getString(com.oplus.camera.R_renamed.string.camera_setting_advanced_setting);
        }
        if (3 == i_renamed) {
            return getString(com.oplus.camera.R_renamed.string.camera_video_sound_title);
        }
        if (5 == i_renamed) {
            return getString(com.oplus.camera.R_renamed.string.camera_setting_about);
        }
        return getString(com.oplus.camera.R_renamed.string.camera_setting_build_image);
    }
}
