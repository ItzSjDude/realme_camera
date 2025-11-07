package com.oplus.camera;

/* loaded from: classes2.dex */
public class CameraImageActivity extends android.app.Activity {

    /* renamed from: a_renamed, reason: collision with root package name */
    private com.oplus.camera.h_renamed f3845a = null;

    /* renamed from: b_renamed, reason: collision with root package name */
    private boolean f3846b = false;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f3847c = 0;
    private java.lang.String d_renamed = null;
    private android.os.Handler e_renamed = new android.os.Handler();

    @Override // android.app.Activity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        if (com.oplus.camera.util.Util.ao_renamed()) {
            setTheme(com.oplus.camera.R_renamed.style.ThemeCameraMoon);
        }
        com.oplus.camera.util.Util.b_renamed((android.app.Activity) this);
        boolean zIsKeyguardLocked = ((android.app.KeyguardManager) getApplicationContext().getSystemService("keyguard")).isKeyguardLocked();
        boolean zAa = com.oplus.camera.util.Util.aa_renamed();
        this.d_renamed = a_renamed();
        com.oplus.camera.e_renamed.c_renamed("CameraImageActivity", "onCreate, this: " + this + ", isKeyguardLocked: " + zIsKeyguardLocked + ", hasNavigationBar: " + zAa + ", mCallerHost: " + this.d_renamed);
        if (zIsKeyguardLocked && "com.android.systemui".equals(this.d_renamed) && !zAa) {
            this.f3847c = 0;
        } else {
            b_renamed();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        com.oplus.camera.e_renamed.a_renamed("CameraImageActivity", "onResume, this: " + this + ", launched: " + this.f3846b);
        if (this.f3846b) {
            return;
        }
        this.f3847c++;
        com.oplus.camera.e_renamed.a_renamed("CameraImageActivity", "onResume, this: " + this + ", lifecycleCount: " + this.f3847c);
        if (this.f3847c > 1) {
            this.e_renamed.removeCallbacksAndMessages(null);
            b_renamed();
        } else {
            this.e_renamed.postDelayed(new java.lang.Runnable() { // from class: com.oplus.camera.CameraImageActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.e_renamed.a_renamed("CameraImageActivity", "run post delayed task, launch camera.");
                    com.oplus.camera.CameraImageActivity.this.b_renamed();
                }
            }, 500L);
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        com.oplus.camera.e_renamed.a_renamed("CameraImageActivity", "onStop, this: " + this + ", lifecycleCount: " + this.f3847c + ", launched: " + this.f3846b);
        if (this.f3846b) {
            finish();
            this.f3847c = 0;
        }
    }

    private java.lang.String a_renamed() {
        android.net.Uri referrer;
        try {
            referrer = getReferrer();
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            referrer = null;
        }
        if (referrer == null || android.text.TextUtils.isEmpty(referrer.getHost())) {
            return null;
        }
        return referrer.getHost();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b_renamed() {
        boolean booleanExtra;
        if (this.f3846b) {
            com.oplus.camera.e_renamed.a_renamed("CameraImageActivity", "launchCameraActivity, mbLaunchCameraActivity: " + this.f3846b);
            return;
        }
        com.oplus.camera.e_renamed.a_renamed("CameraImageActivity", "launchCameraActivity, isVoiceInteractionRoot: " + isVoiceInteractionRoot());
        try {
            booleanExtra = getIntent().getBooleanExtra("com.oplus.camera.extra.IS_VOICE_INTERACTION_ROOT", false);
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            booleanExtra = false;
        }
        if (isVoiceInteractionRoot()) {
            getIntent().addFlags(276824064);
            getIntent().putExtra("com.oplus.camera.extra.IS_VOICE_INTERACTION_ROOT", true);
        } else if (booleanExtra) {
            getIntent().putExtra("com.oplus.camera.extra.IS_VOICE_INTERACTION_ROOT", false);
        }
        this.f3845a = new com.oplus.camera.h_renamed(this, null);
        if (!this.f3845a.e_renamed()) {
            getIntent().addFlags(268468224);
            com.oplus.camera.e_renamed.a_renamed("CameraImageActivity", "onCreate, has no necessaryPermissions so clean task");
        }
        if (this.d_renamed != null) {
            getIntent().putExtra("extra_key_caller_package_name", this.d_renamed);
        }
        getIntent().setComponent(new android.content.ComponentName(this, (java.lang.Class<?>) com.oplus.camera.Camera.class));
        startActivity(getIntent());
        overridePendingTransition(com.oplus.camera.R_renamed.anim.coui_fade_in_fast, com.oplus.camera.R_renamed.anim.coui_fade_out_fast);
        this.f3846b = true;
    }
}
