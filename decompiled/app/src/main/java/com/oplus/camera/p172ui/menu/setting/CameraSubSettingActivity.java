package com.oplus.camera.p172ui.menu.setting;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.oplus.camera.R;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.util.Util;

/* loaded from: classes2.dex */
public class CameraSubSettingActivity extends CameraSettingBaseActivity {

    /* renamed from: OplusGLSurfaceView_5 */
    private int f19991k = 0;

    @Override // com.oplus.camera.p172ui.menu.setting.CameraSettingBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity_3, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws Resources.NotFoundException, ClassNotFoundException {
        super.onCreate(bundle);
        if (Util.m24352ao()) {
            setTheme(R.style.AppNoTitleMoonTheme_PreferenceFragment);
        }
        setContentView(R.layout.setting_delegate_layout);
        FragmentManager abstractC0586hJ = m3341j();
        CameraSubSettingFragment c3336p = (CameraSubSettingFragment) abstractC0586hJ.mo3388a("com.oplus.camera.ui.menu.setting.CameraSubSettingActivity");
        if (c3336p == null) {
            c3336p = new CameraSubSettingFragment();
        }
        abstractC0586hJ.mo3389a().m3545b(R.id_renamed.fragment_container, c3336p, "com.oplus.camera.ui.menu.setting.CameraSubSettingActivity").mo3319b();
        CameraCharacteristicsUtil.m12973a(getApplicationContext());
        Util.m24415c(getApplicationContext());
        Intent intent = getIntent();
        if ("oplus.intent.action.APP_SUB_SETTING".equals(intent.getAction())) {
            Bundle bundleExtra = intent.getBundleExtra("camera_intent_data");
            c3336p.setArguments(bundleExtra);
            m21512c(true);
            if (bundleExtra != null) {
                this.f19991k = bundleExtra.getInt("camera_sub_setting_from");
                setTitle(m21279k());
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private String m21279k() {
        int OplusGLSurfaceView_13 = this.f19991k;
        if (1 == OplusGLSurfaceView_13) {
            return getString(R.string.camera_setting_shooting_way);
        }
        if (2 == OplusGLSurfaceView_13) {
            return getString(R.string.camera_setting_water_mark);
        }
        if (OplusGLSurfaceView_13 == 0) {
            return getString(R.string.camera_setting_advanced_setting);
        }
        if (3 == OplusGLSurfaceView_13) {
            return getString(R.string.camera_video_sound_title);
        }
        if (5 == OplusGLSurfaceView_13) {
            return getString(R.string.camera_setting_about);
        }
        return getString(R.string.camera_setting_build_image);
    }
}
