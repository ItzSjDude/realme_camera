package com.oplus.camera.ui.menu.setting;

/* loaded from: classes2.dex */
public class CameraOpenSourceSettingActivity extends com.oplus.camera.ui.menu.setting.l_renamed {
    private android.widget.TextView k_renamed = null;
    private android.widget.ScrollView l_renamed = null;
    private com.coui.appcompat.widget.toolbar.COUIToolbar m_renamed;
    private com.google.android.material.appbar.AppBarLayout n_renamed;

    @Override // com.oplus.camera.ui.menu.setting.l_renamed, androidx.appcompat.app.c_renamed, androidx.fragment.app.c_renamed, androidx.activity.b_renamed, androidx.core.app.e_renamed, android.app.Activity
    @android.annotation.SuppressLint({"PrivateResource"})
    protected void onCreate(android.os.Bundle bundle) throws android.content.res.Resources.NotFoundException, java.lang.ClassNotFoundException {
        super.onCreate(bundle);
        if (com.oplus.camera.util.Util.ao_renamed()) {
            setTheme(com.oplus.camera.R_renamed.style.AppNoTitleMoonTheme_PreferenceFragment);
        }
        setContentView(com.oplus.camera.R_renamed.layout.setting_open_source_layout);
        this.m_renamed = (com.coui.appcompat.widget.toolbar.COUIToolbar) findViewById(com.oplus.camera.R_renamed.id_renamed.toolbar);
        this.n_renamed = (com.google.android.material.appbar.AppBarLayout) findViewById(com.oplus.camera.R_renamed.id_renamed.appBarLayout);
        this.l_renamed = (android.widget.ScrollView) findViewById(com.oplus.camera.R_renamed.id_renamed.scrollView);
        this.k_renamed = (android.widget.TextView) findViewById(com.oplus.camera.R_renamed.id_renamed.txt_code_license_content);
        this.m_renamed.setNavigationIcon(com.oplus.camera.R_renamed.drawable.coui_back_arrow);
        this.m_renamed.setNavigationContentDescription(com.oplus.camera.R_renamed.string.abc_action_bar_up_description);
        this.m_renamed.setNavigationOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.ui.menu.setting.CameraOpenSourceSettingActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                com.oplus.camera.ui.menu.setting.CameraOpenSourceSettingActivity.this.onBackPressed();
            }
        });
        androidx.core.h_renamed.v_renamed.c_renamed((android.view.View) this.l_renamed, true);
        this.l_renamed.setBackgroundColor(getResources().getColor(com.oplus.camera.R_renamed.color.coui_list_overscroll_background_color));
        this.m_renamed.setTitle(com.oplus.camera.R_renamed.string.camera_sub_setting_open_source_license);
        this.n_renamed.setPadding(0, getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.preference_topbar_padding_top), 0, 0);
        this.l_renamed.setPadding(0, this.n_renamed.getHeight(), 0, 0);
        this.k_renamed.setText(k_renamed());
    }

    public java.lang.String k_renamed() throws java.io.IOException {
        java.io.BufferedReader bufferedReader;
        java.lang.Exception e_renamed;
        java.io.InputStreamReader inputStreamReader;
        com.oplus.camera.e_renamed.a_renamed("CameraOpenSourceSettingActivity", "getNoticeString, NOTICE_FILE_NAME: notice");
        try {
            inputStreamReader = new java.io.InputStreamReader(getResources().getAssets().open("notice"));
            try {
                bufferedReader = new java.io.BufferedReader(inputStreamReader);
                try {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    while (true) {
                        java.lang.String line = bufferedReader.readLine();
                        if (line != null) {
                            sb.append(line);
                            sb.append("\r_renamed\n_renamed");
                        } else {
                            a_renamed(bufferedReader);
                            a_renamed(inputStreamReader);
                            return sb.toString();
                        }
                    }
                } catch (java.lang.Exception e2) {
                    e_renamed = e2;
                    com.oplus.camera.e_renamed.f_renamed("CameraOpenSourceSettingActivity", "getNoticeString, error: " + e_renamed.getMessage());
                    e_renamed.printStackTrace();
                    this.a_renamed(bufferedReader);
                    this.a_renamed(inputStreamReader);
                    return "notice";
                }
            } catch (java.lang.Exception e3) {
                bufferedReader = null;
                e_renamed = e3;
            }
        } catch (java.lang.Exception e4) {
            bufferedReader = null;
            e_renamed = e4;
            inputStreamReader = null;
        }
    }

    private void a_renamed(java.io.Closeable closeable) throws java.io.IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.io.IOException e_renamed) {
                e_renamed.printStackTrace();
            }
        }
    }
}
