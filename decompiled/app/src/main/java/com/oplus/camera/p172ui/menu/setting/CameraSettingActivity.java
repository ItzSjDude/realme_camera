package com.oplus.camera.p172ui.menu.setting;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.util.NavigateUtils;
import com.oplus.camera.util.Util;

/* loaded from: classes2.dex */
public class CameraSettingActivity extends CameraSettingBaseActivity {
    @Override // com.oplus.camera.p172ui.menu.setting.CameraSettingBaseActivity, androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        CameraLog.m12959b("CameraSettingActivity", "attachBaseContext, follow system dpi.");
        super.attachBaseContext(Util.m24491r(context));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        CameraLog.m12966e("CameraSettingActivity", "onConfigurationChanged, densityDpi: " + configuration.densityDpi + " -> " + Util.f22994b + ", fontScale: " + configuration.fontScale + " -> " + Util.f22995c);
        configuration.densityDpi = Util.f22994b;
        configuration.fontScale = Util.f22995c;
        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraSettingBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity_3, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) throws Resources.NotFoundException, PackageManager.NameNotFoundException, ClassNotFoundException {
        super.onCreate(bundle);
        if (Util.m24352ao()) {
            setTheme(R.style.AppNoTitleMoonTheme_PreferenceFragment);
        }
        setContentView(R.layout.setting_delegate_layout);
        FragmentManager abstractC0586hJ = m3341j();
        CameraSettingActivityFragment c3331k = (CameraSettingActivityFragment) abstractC0586hJ.mo3388a("com.oplus.camera.ui.menu.setting.CameraSettingActivity");
        if (c3331k == null) {
            c3331k = new CameraSettingActivityFragment();
        }
        abstractC0586hJ.mo3389a().m3545b(R.id_renamed.fragment_container, c3331k, "com.oplus.camera.ui.menu.setting.CameraSettingActivity").mo3319b();
        Intent intent = getIntent();
        CameraLog.m12954a("CameraSettingActivity", "onCreate(), Action: " + intent.getAction());
        NavigateUtils.m24586a(this, intent, getString(R.string.camera_setting_name));
        if ("com.oplus.camera.action.SETTING_MENU".equals(intent.getAction())) {
            c3331k.setArguments(intent.getBundleExtra("camera_intent_data"));
            m21512c(true);
        } else if ("oplus.intent.action.APP_SETTINGS".equals(intent.getAction()) || "android.intent.action.MAIN".equals(intent.getAction())) {
            m21510a(true);
        }
    }
}
