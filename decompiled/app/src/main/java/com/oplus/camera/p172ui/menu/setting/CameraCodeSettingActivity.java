package com.oplus.camera.p172ui.menu.setting;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.coui.appcompat.widget.toolbar.COUIToolbar;
import com.google.android.material.appbar.AppBarLayout;
import com.oplus.camera.R;
import com.oplus.camera.util.Util;

/* loaded from: classes2.dex */
public class CameraCodeSettingActivity extends CameraSettingBaseActivity {

    /* renamed from: OplusGLSurfaceView_5 */
    private COUIToolbar f19893k = null;

    /* renamed from: OplusGLSurfaceView_14 */
    private AppBarLayout f19894l = null;

    @Override // com.oplus.camera.p172ui.menu.setting.CameraSettingBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity_3, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws Resources.NotFoundException, ClassNotFoundException {
        super.onCreate(bundle);
        if (Util.m24352ao()) {
            setTheme(R.style.AppNoTitleMoonTheme_PreferenceFragment);
        }
        setContentView(R.layout.camera_setting_video_resolution_activity_layout);
        CameraCodeSettingFragment c3317d = new CameraCodeSettingFragment();
        m3341j().mo3389a().m3540a(R.id_renamed.list_container, c3317d).mo3319b();
        this.f19893k = (COUIToolbar) findViewById(R.id_renamed.toolbar);
        m908a(this.f19893k);
        this.f19894l = (AppBarLayout) findViewById(R.id_renamed.appBarLayout);
        this.f19894l.setPadding(0, getResources().getDimensionPixelSize(R.dimen.preference_topbar_padding_top), 0, 0);
        setTitle(R.string.camera_codec_title);
        Intent intent = getIntent();
        if ("oplus.intent.action.APP_CODE_SETTING".equals(intent.getAction())) {
            c3317d.setArguments(intent.getBundleExtra("camera_intent_data"));
            m21512c(true);
        }
    }
}
