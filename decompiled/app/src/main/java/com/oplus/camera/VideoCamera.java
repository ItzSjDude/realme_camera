package com.oplus.camera;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.heytap.accessory.CommonStatusCodes;
import com.oplus.camera.util.Util;

/* loaded from: classes2.dex */
public class VideoCamera extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        CameraLog.m12954a("VideoCamera", "onCreate");
        super.onCreate(bundle);
        if (Util.m24352ao()) {
            setTheme(R.style.ThemeCameraMoon);
        }
        Util.m24384b((Activity) this);
        if (isInMultiWindowMode()) {
            Toast.makeText(this, getString(R.string.camera_in_multiwindow_cannot_use), 0).show();
            finish();
            return;
        }
        Bundle extras = getIntent().getExtras();
        String str = "android.media.action.VIDEO_CAPTURE".equals(getIntent().getAction()) ? "com.oplus.action.VIDEO_CAPTURE" : "com.oplus.action.VIDEO_CAMERA";
        Intent intent = new Intent(str);
        intent.setComponent(new ComponentName(this, (Class<?>) Camera.class));
        if ("com.oplus.action.VIDEO_CAMERA".equals(str)) {
            intent.addFlags(268468224);
        }
        Uri referrer = null;
        try {
            referrer = getReferrer();
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        if (referrer != null && !TextUtils.isEmpty(referrer.getHost())) {
            intent.putExtra("extra_key_caller_package_name", referrer.getHost());
        }
        if (extras != null) {
            try {
                CameraLog.m12954a("VideoCamera", "onCreate, save uri: " + extras.getParcelable("output") + ", crop value: " + extras.getString("crop"));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            intent.putExtras(extras);
        }
        startActivityForResult(intent, CommonStatusCodes.TIME_EXPIRED);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int OplusGLSurfaceView_13, int i2, Intent intent) {
        CameraLog.m12954a("VideoCamera", "onActivityResult(), requestCode: " + OplusGLSurfaceView_13 + ", resultCode: " + i2);
        super.onActivityResult(OplusGLSurfaceView_13, i2, intent);
        if (OplusGLSurfaceView_13 == 1003) {
            setResult(i2, intent);
            finish();
            overridePendingTransition(R.anim.coui_close_slide_enter, R.anim.coui_close_slide_exit);
        }
    }
}
