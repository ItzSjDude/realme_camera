package com.oplus.camera.ui.menu.setting;

/* compiled from: CameraSettingBaseActivity.java */
/* loaded from: classes2.dex */
public abstract class l_renamed extends androidx.appcompat.app.c_renamed implements com.oplus.camera.ui.menu.setting.a_renamed {
    private com.oplus.camera.ui.menu.setting.a_renamed.a_renamed k_renamed = null;
    private boolean l_renamed = false;
    private boolean m_renamed = false;
    private boolean n_renamed = false;
    private boolean o_renamed = false;
    private boolean p_renamed = false;

    @Override // com.oplus.camera.ui.menu.setting.a_renamed
    public boolean a_renamed() {
        return true;
    }

    @Override // com.oplus.camera.ui.menu.setting.a_renamed
    public int c_renamed() {
        return 3;
    }

    @Override // com.oplus.camera.ui.menu.setting.a_renamed
    public boolean h__renamed() {
        return true;
    }

    @Override // androidx.appcompat.app.c_renamed, androidx.fragment.app.c_renamed, androidx.activity.b_renamed, androidx.core.app.e_renamed, android.app.Activity
    protected void onCreate(android.os.Bundle bundle) throws android.content.res.Resources.NotFoundException, java.lang.ClassNotFoundException {
        com.oplus.camera.aps.config.CameraConfig.initialize(this);
        com.oplus.camera.util.Util.b_renamed((android.app.Activity) this);
        this.k_renamed = new com.oplus.camera.ui.menu.setting.a_renamed.a_renamed(this);
        this.k_renamed.a_renamed(h_renamed());
        if (!com.oplus.camera.util.Util.ao_renamed()) {
            com.coui.appcompat.a_renamed.t_renamed.a_renamed().a_renamed(this);
        }
        super.onCreate(bundle);
        android.os.Bundle bundleExtra = getIntent().getBundleExtra("camera_intent_data");
        if (bundleExtra != null) {
            this.p_renamed = bundleExtra.getBoolean("camera_enter_form_lock_screen", false);
        }
    }

    @Override // androidx.appcompat.app.c_renamed, android.app.Activity
    protected void onPostCreate(android.os.Bundle bundle) {
        super.onPostCreate(bundle);
        this.k_renamed.b_renamed(h_renamed());
    }

    @Override // androidx.appcompat.app.c_renamed, android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        super.onContentChanged();
        this.k_renamed.a_renamed();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(android.view.MenuItem menuItem) {
        this.k_renamed.a_renamed(menuItem);
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.fragment.app.c_renamed, android.app.Activity
    protected void onActivityResult(int i_renamed, int i2, android.content.Intent intent) {
        super.onActivityResult(i_renamed, i2, intent);
        if (com.oplus.camera.q_renamed.a_renamed.f5295a == i_renamed) {
            if (-1 == i2) {
                com.oplus.camera.q_renamed.a_renamed.a_renamed(intent);
            } else {
                com.oplus.camera.q_renamed.a_renamed.b_renamed();
            }
        }
    }

    @Override // android.app.Activity
    public void setShowWhenLocked(boolean z_renamed) {
        android.app.KeyguardManager keyguardManager = (android.app.KeyguardManager) getApplicationContext().getSystemService("keyguard");
        if (keyguardManager != null) {
            boolean z2 = keyguardManager.isKeyguardLocked() && z_renamed;
            super.setShowWhenLocked(z2);
            com.oplus.camera.e_renamed.b_renamed("SettingBaseActivity", "setShowWhenLocked: " + z2);
        }
    }

    @Override // androidx.activity.b_renamed, android.app.Activity
    public void onBackPressed() {
        com.oplus.camera.e_renamed.a_renamed("SettingBaseActivity", "onBackPressed");
        if (this.m_renamed) {
            this.o_renamed = true;
        }
        super.onBackPressed();
    }

    @Override // androidx.fragment.app.c_renamed, android.app.Activity
    protected void onResume() {
        com.oplus.camera.e_renamed.b_renamed("SettingBaseActivity", "onResume: " + this);
        super.onResume();
        setShowWhenLocked(this.m_renamed && this.p_renamed);
        this.o_renamed = false;
    }

    @Override // androidx.fragment.app.c_renamed, android.app.Activity
    protected void onPause() {
        com.oplus.camera.e_renamed.b_renamed("SettingBaseActivity", "onPause: " + this);
        super.onPause();
        if (!this.m_renamed || this.o_renamed) {
            return;
        }
        com.oplus.camera.g_renamed.a_renamed(getApplicationContext()).f_renamed();
    }

    @Override // androidx.appcompat.app.c_renamed, androidx.fragment.app.c_renamed, android.app.Activity
    protected void onStop() {
        com.oplus.camera.e_renamed.b_renamed("SettingBaseActivity", "onStop: " + this);
        super.onStop();
        if (this.o_renamed) {
            return;
        }
        setShowWhenLocked(false);
    }

    @Override // androidx.appcompat.app.c_renamed, androidx.fragment.app.c_renamed, android.app.Activity
    protected void onDestroy() {
        com.oplus.camera.e_renamed.b_renamed("SettingBaseActivity", "onDestroy: " + this);
        super.onDestroy();
        this.n_renamed = false;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:12:0x0018  */
    @Override // androidx.appcompat.app.c_renamed, androidx.core.app.e_renamed, android.app.Activity, android.view.Window.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean dispatchKeyEvent(android.view.KeyEvent r3) {
        /*
            r2 = this;
            int r0 = r3.getKeyCode()
            r1 = 57
            if (r0 == r1) goto L18
            r1 = 58
            if (r0 == r1) goto L18
            r1 = 82
            if (r0 == r1) goto L18
            r1 = 84
            if (r0 == r1) goto L18
            switch(r0) {
                case 19: goto L18;
                case 20: goto L18;
                case 21: goto L18;
                case 22: goto L18;
                case 23: goto L18;
                default: goto L17;
            }
        L17:
            goto L20
        L18:
            boolean r0 = com.oplus.camera.util.Util.ae_renamed()
            if (r0 == 0) goto L20
            r2 = 1
            return r2
        L20:
            boolean r2 = super.dispatchKeyEvent(r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.menu.setting.l_renamed.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    public boolean l_renamed() {
        return this.n_renamed;
    }

    public void a_renamed(boolean z_renamed) {
        this.n_renamed = z_renamed;
    }

    public void b_renamed(boolean z_renamed) {
        this.o_renamed = z_renamed;
    }

    public void c_renamed(boolean z_renamed) {
        this.m_renamed = z_renamed;
    }

    public boolean m_renamed() {
        android.app.KeyguardManager keyguardManager = (android.app.KeyguardManager) getApplicationContext().getSystemService("keyguard");
        if (keyguardManager != null) {
            return keyguardManager.isKeyguardLocked();
        }
        return false;
    }

    @Override // androidx.appcompat.app.c_renamed, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(android.content.Context context) {
        if (com.oplus.camera.util.Util.f7298b > 0) {
            android.content.res.Configuration configuration = new android.content.res.Configuration();
            configuration.densityDpi = com.oplus.camera.util.Util.f7298b;
            context.getResources().updateConfiguration(configuration, context.getResources().getDisplayMetrics());
        }
        super.attachBaseContext(context);
    }
}
