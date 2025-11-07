package com.oplus.camera;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.oplus.camera.util.Util;

/* loaded from: classes2.dex */
public class CameraImageActivity extends Activity {

    /* renamed from: PlatformImplementations.kt_3 */
    private CameraPermission f10684a = null;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean f10685b = false;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f10686c = 0;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private String f10687d = null;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Handler f10688e = new Handler();

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Util.m24352ao()) {
            setTheme(R.style.ThemeCameraMoon);
        }
        Util.m24384b((Activity) this);
        boolean zIsKeyguardLocked = ((KeyguardManager) getApplicationContext().getSystemService("keyguard")).isKeyguardLocked();
        boolean zM24338aa = Util.m24338aa();
        this.f10687d = m9576a();
        CameraLog.m12962c("CameraImageActivity", "onCreate, this: " + this + ", isKeyguardLocked: " + zIsKeyguardLocked + ", hasNavigationBar: " + zM24338aa + ", mCallerHost: " + this.f10687d);
        if (zIsKeyguardLocked && "com.android.systemui".equals(this.f10687d) && !zM24338aa) {
            this.f10686c = 0;
        } else {
            m9578b();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        CameraLog.m12954a("CameraImageActivity", "onResume, this: " + this + ", launched: " + this.f10685b);
        if (this.f10685b) {
            return;
        }
        this.f10686c++;
        CameraLog.m12954a("CameraImageActivity", "onResume, this: " + this + ", lifecycleCount: " + this.f10686c);
        if (this.f10686c > 1) {
            this.f10688e.removeCallbacksAndMessages(null);
            m9578b();
        } else {
            this.f10688e.postDelayed(new Runnable() { // from class: com.oplus.camera.CameraImageActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    CameraLog.m12954a("CameraImageActivity", "run post delayed task, launch camera.");
                    CameraImageActivity.this.m9578b();
                }
            }, 500L);
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        CameraLog.m12954a("CameraImageActivity", "onStop, this: " + this + ", lifecycleCount: " + this.f10686c + ", launched: " + this.f10685b);
        if (this.f10685b) {
            finish();
            this.f10686c = 0;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private String m9576a() {
        Uri referrer;
        try {
            referrer = getReferrer();
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            referrer = null;
        }
        if (referrer == null || TextUtils.isEmpty(referrer.getHost())) {
            return null;
        }
        return referrer.getHost();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m9578b() {
        boolean booleanExtra;
        if (this.f10685b) {
            CameraLog.m12954a("CameraImageActivity", "launchCameraActivity, mbLaunchCameraActivity: " + this.f10685b);
            return;
        }
        CameraLog.m12954a("CameraImageActivity", "launchCameraActivity, isVoiceInteractionRoot: " + isVoiceInteractionRoot());
        try {
            booleanExtra = getIntent().getBooleanExtra("com.oplus.camera.extra.IS_VOICE_INTERACTION_ROOT", false);
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            booleanExtra = false;
        }
        if (isVoiceInteractionRoot()) {
            getIntent().addFlags(276824064);
            getIntent().putExtra("com.oplus.camera.extra.IS_VOICE_INTERACTION_ROOT", true);
        } else if (booleanExtra) {
            getIntent().putExtra("com.oplus.camera.extra.IS_VOICE_INTERACTION_ROOT", false);
        }
        this.f10684a = new CameraPermission(this, null);
        if (!this.f10684a.m14327e()) {
            getIntent().addFlags(268468224);
            CameraLog.m12954a("CameraImageActivity", "onCreate, has no necessaryPermissions so clean task");
        }
        if (this.f10687d != null) {
            getIntent().putExtra("extra_key_caller_package_name", this.f10687d);
        }
        getIntent().setComponent(new ComponentName(this, (Class<?>) Camera.class));
        startActivity(getIntent());
        overridePendingTransition(R.anim.coui_fade_in_fast, R.anim.coui_fade_out_fast);
        this.f10685b = true;
    }
}
