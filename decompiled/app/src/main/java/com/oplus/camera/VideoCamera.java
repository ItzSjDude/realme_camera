package com.oplus.camera;

/* loaded from: classes2.dex */
public class VideoCamera extends android.app.Activity {
    @Override // android.app.Activity
    protected void onCreate(android.os.Bundle bundle) {
        com.oplus.camera.e_renamed.a_renamed("VideoCamera", "onCreate");
        super.onCreate(bundle);
        if (com.oplus.camera.util.Util.ao_renamed()) {
            setTheme(com.oplus.camera.R_renamed.style.ThemeCameraMoon);
        }
        com.oplus.camera.util.Util.b_renamed((android.app.Activity) this);
        if (isInMultiWindowMode()) {
            android.widget.Toast.makeText(this, getString(com.oplus.camera.R_renamed.string.camera_in_multiwindow_cannot_use), 0).show();
            finish();
            return;
        }
        android.os.Bundle extras = getIntent().getExtras();
        java.lang.String str = "android.media.action.VIDEO_CAPTURE".equals(getIntent().getAction()) ? "com.oplus.action.VIDEO_CAPTURE" : "com.oplus.action.VIDEO_CAMERA";
        android.content.Intent intent = new android.content.Intent(str);
        intent.setComponent(new android.content.ComponentName(this, (java.lang.Class<?>) com.oplus.camera.Camera.class));
        if ("com.oplus.action.VIDEO_CAMERA".equals(str)) {
            intent.addFlags(268468224);
        }
        android.net.Uri referrer = null;
        try {
            referrer = getReferrer();
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
        }
        if (referrer != null && !android.text.TextUtils.isEmpty(referrer.getHost())) {
            intent.putExtra("extra_key_caller_package_name", referrer.getHost());
        }
        if (extras != null) {
            try {
                com.oplus.camera.e_renamed.a_renamed("VideoCamera", "onCreate, save uri: " + extras.getParcelable("output") + ", crop value: " + extras.getString("crop"));
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
            intent.putExtras(extras);
        }
        startActivityForResult(intent, com.heytap.accessory.CommonStatusCodes.TIME_EXPIRED);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i_renamed, int i2, android.content.Intent intent) {
        com.oplus.camera.e_renamed.a_renamed("VideoCamera", "onActivityResult(), requestCode: " + i_renamed + ", resultCode: " + i2);
        super.onActivityResult(i_renamed, i2, intent);
        if (i_renamed == 1003) {
            setResult(i2, intent);
            finish();
            overridePendingTransition(com.oplus.camera.R_renamed.anim.coui_close_slide_enter, com.oplus.camera.R_renamed.anim.coui_close_slide_exit);
        }
    }
}
