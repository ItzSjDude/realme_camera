package com.oplus.camera.ui.menu.setting;

/* loaded from: classes2.dex */
public class CameraSettingActivity extends com.oplus.camera.ui.menu.setting.l_renamed {
    @Override // com.oplus.camera.ui.menu.setting.l_renamed, androidx.appcompat.app.c_renamed, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(android.content.Context context) {
        com.oplus.camera.e_renamed.b_renamed("CameraSettingActivity", "attachBaseContext, follow system dpi.");
        super.attachBaseContext(com.oplus.camera.util.Util.r_renamed(context));
    }

    @Override // androidx.appcompat.app.c_renamed, androidx.fragment.app.c_renamed, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.oplus.camera.e_renamed.e_renamed("CameraSettingActivity", "onConfigurationChanged, densityDpi: " + configuration.densityDpi + " -> " + com.oplus.camera.util.Util.f7298b + ", fontScale: " + configuration.fontScale + " -> " + com.oplus.camera.util.Util.f7299c);
        configuration.densityDpi = com.oplus.camera.util.Util.f7298b;
        configuration.fontScale = com.oplus.camera.util.Util.f7299c;
        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
    }

    @Override // com.oplus.camera.ui.menu.setting.l_renamed, androidx.appcompat.app.c_renamed, androidx.fragment.app.c_renamed, androidx.activity.b_renamed, androidx.core.app.e_renamed, android.app.Activity
    protected void onCreate(android.os.Bundle bundle) throws android.content.res.Resources.NotFoundException, android.content.pm.PackageManager.NameNotFoundException, java.lang.ClassNotFoundException {
        super.onCreate(bundle);
        if (com.oplus.camera.util.Util.ao_renamed()) {
            setTheme(com.oplus.camera.R_renamed.style.AppNoTitleMoonTheme_PreferenceFragment);
        }
        setContentView(com.oplus.camera.R_renamed.layout.setting_delegate_layout);
        androidx.fragment.app.h_renamed hVarJ = j_renamed();
        com.oplus.camera.ui.menu.setting.k_renamed kVar = (com.oplus.camera.ui.menu.setting.k_renamed) hVarJ.a_renamed("com.oplus.camera.ui.menu.setting.CameraSettingActivity");
        if (kVar == null) {
            kVar = new com.oplus.camera.ui.menu.setting.k_renamed();
        }
        hVarJ.a_renamed().b_renamed(com.oplus.camera.R_renamed.id_renamed.fragment_container, kVar, "com.oplus.camera.ui.menu.setting.CameraSettingActivity").b_renamed();
        android.content.Intent intent = getIntent();
        com.oplus.camera.e_renamed.a_renamed("CameraSettingActivity", "onCreate(), Action: " + intent.getAction());
        com.oplus.camera.util.j_renamed.a_renamed(this, intent, getString(com.oplus.camera.R_renamed.string.camera_setting_name));
        if ("com.oplus.camera.action.SETTING_MENU".equals(intent.getAction())) {
            kVar.setArguments(intent.getBundleExtra("camera_intent_data"));
            c_renamed(true);
        } else if ("oplus.intent.action.APP_SETTINGS".equals(intent.getAction()) || "android.intent.action.MAIN".equals(intent.getAction())) {
            a_renamed(true);
        }
    }
}
