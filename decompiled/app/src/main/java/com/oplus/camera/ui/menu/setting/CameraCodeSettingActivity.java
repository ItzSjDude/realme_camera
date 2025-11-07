package com.oplus.camera.ui.menu.setting;

/* loaded from: classes2.dex */
public class CameraCodeSettingActivity extends com.oplus.camera.ui.menu.setting.l_renamed {
    private com.coui.appcompat.widget.toolbar.COUIToolbar k_renamed = null;
    private com.google.android.material.appbar.AppBarLayout l_renamed = null;

    @Override // com.oplus.camera.ui.menu.setting.l_renamed, androidx.appcompat.app.c_renamed, androidx.fragment.app.c_renamed, androidx.activity.b_renamed, androidx.core.app.e_renamed, android.app.Activity
    public void onCreate(android.os.Bundle bundle) throws android.content.res.Resources.NotFoundException, java.lang.ClassNotFoundException {
        super.onCreate(bundle);
        if (com.oplus.camera.util.Util.ao_renamed()) {
            setTheme(com.oplus.camera.R_renamed.style.AppNoTitleMoonTheme_PreferenceFragment);
        }
        setContentView(com.oplus.camera.R_renamed.layout.camera_setting_video_resolution_activity_layout);
        com.oplus.camera.ui.menu.setting.d_renamed dVar = new com.oplus.camera.ui.menu.setting.d_renamed();
        j_renamed().a_renamed().a_renamed(com.oplus.camera.R_renamed.id_renamed.list_container, dVar).b_renamed();
        this.k_renamed = (com.coui.appcompat.widget.toolbar.COUIToolbar) findViewById(com.oplus.camera.R_renamed.id_renamed.toolbar);
        a_renamed(this.k_renamed);
        this.l_renamed = (com.google.android.material.appbar.AppBarLayout) findViewById(com.oplus.camera.R_renamed.id_renamed.appBarLayout);
        this.l_renamed.setPadding(0, getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.preference_topbar_padding_top), 0, 0);
        setTitle(com.oplus.camera.R_renamed.string.camera_codec_title);
        android.content.Intent intent = getIntent();
        if ("oplus.intent.action.APP_CODE_SETTING".equals(intent.getAction())) {
            dVar.setArguments(intent.getBundleExtra("camera_intent_data"));
            c_renamed(true);
        }
    }
}
