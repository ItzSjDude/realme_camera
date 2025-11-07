package com.oplus.camera.p172ui.menu.setting;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import com.coui.appcompat.p099a.COUIThemeOverlay;
import com.oplus.camera.CameraLog;
import com.oplus.camera.CameraMotorManager;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.p160q.DocumentUtil;
import com.oplus.camera.p172ui.menu.setting.p176a.ActivityDelegate;
import com.oplus.camera.util.Util;

/* compiled from: CameraSettingBaseActivity.java */
/* renamed from: com.oplus.camera.ui.menu.setting.OplusGLSurfaceView_14 */
/* loaded from: classes2.dex */
public abstract class CameraSettingBaseActivity extends AppCompatActivity implements ActivityConfig {

    /* renamed from: OplusGLSurfaceView_5 */
    private ActivityDelegate f20245k = null;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f20246l = false;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f20247m = false;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f20248n = false;

    /* renamed from: o */
    private boolean f20249o = false;

    /* renamed from: p */
    private boolean f20250p = false;

    @Override // com.oplus.camera.p172ui.menu.setting.ActivityConfig
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo21280a() {
        return true;
    }

    @Override // com.oplus.camera.p172ui.menu.setting.ActivityConfig
    /* renamed from: IntrinsicsJvm.kt_3 */
    public int mo21281c() {
        return 3;
    }

    @Override // com.oplus.camera.p172ui.menu.setting.ActivityConfig
    /* renamed from: h_ */
    public boolean mo21282h_() {
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity_3, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) throws Resources.NotFoundException, ClassNotFoundException {
        CameraConfig.initialize(this);
        Util.m24384b((Activity) this);
        this.f20245k = new ActivityDelegate(this);
        this.f20245k.m21285a(m917h());
        if (!Util.m24352ao()) {
            COUIThemeOverlay.m6468a().m6479a(this);
        }
        super.onCreate(bundle);
        Bundle bundleExtra = getIntent().getBundleExtra("camera_intent_data");
        if (bundleExtra != null) {
            this.f20250p = bundleExtra.getBoolean("camera_enter_form_lock_screen", false);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.f20245k.m21286b(m917h());
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        super.onContentChanged();
        this.f20245k.m21283a();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        this.f20245k.m21284a(menuItem);
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int OplusGLSurfaceView_13, int i2, Intent intent) {
        super.onActivityResult(OplusGLSurfaceView_13, i2, intent);
        if (DocumentUtil.f15848a == OplusGLSurfaceView_13) {
            if (-1 == i2) {
                DocumentUtil.m16195a(intent);
            } else {
                DocumentUtil.m16200b();
            }
        }
    }

    @Override // android.app.Activity
    public void setShowWhenLocked(boolean z) {
        KeyguardManager keyguardManager = (KeyguardManager) getApplicationContext().getSystemService("keyguard");
        if (keyguardManager != null) {
            boolean z2 = keyguardManager.isKeyguardLocked() && z;
            super.setShowWhenLocked(z2);
            CameraLog.m12959b("SettingBaseActivity", "setShowWhenLocked: " + z2);
        }
    }

    @Override // androidx.activity.ComponentActivity_3, android.app.Activity
    public void onBackPressed() {
        CameraLog.m12954a("SettingBaseActivity", "onBackPressed");
        if (this.f20247m) {
            this.f20249o = true;
        }
        super.onBackPressed();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        CameraLog.m12959b("SettingBaseActivity", "onResume: " + this);
        super.onResume();
        setShowWhenLocked(this.f20247m && this.f20250p);
        this.f20249o = false;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        CameraLog.m12959b("SettingBaseActivity", "onPause: " + this);
        super.onPause();
        if (!this.f20247m || this.f20249o) {
            return;
        }
        CameraMotorManager.m13703a(getApplicationContext()).m13716f();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        CameraLog.m12959b("SettingBaseActivity", "onStop: " + this);
        super.onStop();
        if (this.f20249o) {
            return;
        }
        setShowWhenLocked(false);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        CameraLog.m12959b("SettingBaseActivity", "onDestroy: " + this);
        super.onDestroy();
        this.f20248n = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0018  */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
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
            boolean r0 = com.oplus.camera.util.Util.m24342ae()
            if (r0 == 0) goto L20
            r2 = 1
            return r2
        L20:
            boolean r2 = super.dispatchKeyEvent(r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.menu.setting.CameraSettingBaseActivity.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public boolean m21513l() {
        return this.f20248n;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21510a(boolean z) {
        this.f20248n = z;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m21511b(boolean z) {
        this.f20249o = z;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m21512c(boolean z) {
        this.f20247m = z;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public boolean m21514m() {
        KeyguardManager keyguardManager = (KeyguardManager) getApplicationContext().getSystemService("keyguard");
        if (keyguardManager != null) {
            return keyguardManager.isKeyguardLocked();
        }
        return false;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        if (Util.f22994b > 0) {
            Configuration configuration = new Configuration();
            configuration.densityDpi = Util.f22994b;
            context.getResources().updateConfiguration(configuration, context.getResources().getDisplayMetrics());
        }
        super.attachBaseContext(context);
    }
}
