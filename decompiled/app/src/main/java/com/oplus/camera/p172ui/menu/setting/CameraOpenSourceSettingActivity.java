package com.oplus.camera.p172ui.menu.setting;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.p036h.ViewCompat;
import com.coui.appcompat.widget.toolbar.COUIToolbar;
import com.google.android.material.appbar.AppBarLayout;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.util.Util;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;

/* loaded from: classes2.dex */
public class CameraOpenSourceSettingActivity extends CameraSettingBaseActivity {

    /* renamed from: OplusGLSurfaceView_5 */
    private TextView f19954k = null;

    /* renamed from: OplusGLSurfaceView_14 */
    private ScrollView f19955l = null;

    /* renamed from: OplusGLSurfaceView_6 */
    private COUIToolbar f19956m;

    /* renamed from: OplusGLSurfaceView_11 */
    private AppBarLayout f19957n;

    @Override // com.oplus.camera.p172ui.menu.setting.CameraSettingBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity_3, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"PrivateResource"})
    protected void onCreate(Bundle bundle) throws Resources.NotFoundException, ClassNotFoundException {
        super.onCreate(bundle);
        if (Util.m24352ao()) {
            setTheme(R.style.AppNoTitleMoonTheme_PreferenceFragment);
        }
        setContentView(R.layout.setting_open_source_layout);
        this.f19956m = (COUIToolbar) findViewById(R.id_renamed.toolbar);
        this.f19957n = (AppBarLayout) findViewById(R.id_renamed.appBarLayout);
        this.f19955l = (ScrollView) findViewById(R.id_renamed.scrollView);
        this.f19954k = (TextView) findViewById(R.id_renamed.txt_code_license_content);
        this.f19956m.setNavigationIcon(R.drawable.coui_back_arrow);
        this.f19956m.setNavigationContentDescription(R.string.abc_action_bar_up_description);
        this.f19956m.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.ui.menu.setting.CameraOpenSourceSettingActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CameraOpenSourceSettingActivity.this.onBackPressed();
            }
        });
        ViewCompat.m2875c((View) this.f19955l, true);
        this.f19955l.setBackgroundColor(getResources().getColor(R.color.coui_list_overscroll_background_color));
        this.f19956m.setTitle(R.string.camera_sub_setting_open_source_license);
        this.f19957n.setPadding(0, getResources().getDimensionPixelSize(R.dimen.preference_topbar_padding_top), 0, 0);
        this.f19955l.setPadding(0, this.f19957n.getHeight(), 0, 0);
        this.f19954k.setText(m21193k());
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public String m21193k() throws IOException {
        BufferedReader bufferedReader;
        Exception COUIBaseListPopupWindow_8;
        InputStreamReader inputStreamReader;
        CameraLog.m12954a("CameraOpenSourceSettingActivity", "getNoticeString, NOTICE_FILE_NAME: notice");
        try {
            inputStreamReader = new InputStreamReader(getResources().getAssets().open("notice"));
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line != null) {
                            sb.append(line);
                            sb.append("\r\OplusGLSurfaceView_11");
                        } else {
                            m21192a(bufferedReader);
                            m21192a(inputStreamReader);
                            return sb.toString();
                        }
                    }
                } catch (Exception e2) {
                    COUIBaseListPopupWindow_8 = e2;
                    CameraLog.m12967f("CameraOpenSourceSettingActivity", "getNoticeString, error: " + COUIBaseListPopupWindow_8.getMessage());
                    COUIBaseListPopupWindow_8.printStackTrace();
                    this.m21192a(bufferedReader);
                    this.m21192a(inputStreamReader);
                    return "notice";
                }
            } catch (Exception e3) {
                bufferedReader = null;
                COUIBaseListPopupWindow_8 = e3;
            }
        } catch (Exception e4) {
            bufferedReader = null;
            COUIBaseListPopupWindow_8 = e4;
            inputStreamReader = null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m21192a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        }
    }
}
