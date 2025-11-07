package com.oplus.camera.professional;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.capmode.CameraInterface;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.SwitchButton;
import com.oplus.camera.util.Util;

/* compiled from: ProSwitchButtonManager.java */
/* renamed from: com.oplus.camera.professional.s */
/* loaded from: classes2.dex */
public class ProSwitchButtonManager {

    /* renamed from: PlatformImplementations.kt_3 */
    private Activity f15682a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private CameraUIInterface f15683b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private CameraInterface f15684c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private SharedPreferences f15685d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private SwitchButton.InterfaceC3112a f15686e = null;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private SwitchButton f15687f = null;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private String f15688g = null;

    public ProSwitchButtonManager(Activity activity, CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface) {
        this.f15682a = activity;
        this.f15683b = cameraUIInterface;
        this.f15684c = interfaceC2646a;
        this.f15685d = this.f15684c.mo10590t();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15914a(boolean z) {
        CameraLog.m12959b("ProSwitchButtonManager", "setChecked: " + z);
        SwitchButton switchButton = this.f15687f;
        if (switchButton == null) {
            return;
        }
        switchButton.setChecked(z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15911a() {
        CameraLog.m12959b("ProSwitchButtonManager", "unInit");
        m15912a(8, false);
        if (this.f15687f != null) {
            this.f15683b.mo18163b().removeView(this.f15687f);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15912a(final int OplusGLSurfaceView_13, final boolean z) {
        CameraLog.m12959b("ProSwitchButtonManager", "setVisibility: " + OplusGLSurfaceView_13);
        this.f15682a.runOnUiThread(new Runnable() { // from class: com.oplus.camera.professional.s.1
            @Override // java.lang.Runnable
            public void run() {
                if (OplusGLSurfaceView_13 == 0) {
                    ProSwitchButtonManager.this.m15905b(z);
                } else {
                    ProSwitchButtonManager.this.m15907c(z);
                }
            }
        });
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m15915b() {
        SwitchButton switchButton = this.f15687f;
        return switchButton != null && switchButton.getVisibility() == 0;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m15916c() {
        CameraLog.m12959b("ProSwitchButtonManager", "onAfterStartPreview");
        if ((1 == Integer.parseInt(this.f15685d.getString(CameraUIInterface.KEY_CAMERA_ID, String.valueOf(0)))) || this.f15683b.mo18159aw() || this.f15683b.mo18023A()) {
            return;
        }
        m15912a(0, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m15905b(boolean z) {
        CameraLog.m12959b("ProSwitchButtonManager", "showSwitch, needAnimation: " + z);
        if (this.f15683b.mo18163b() == null || this.f15683b.mo18057R()) {
            return;
        }
        if (this.f15687f == null) {
            m15910g();
        }
        if (z) {
            Util.m24270a(this.f15687f, 0, (Animation.AnimationListener) null, 300L);
        } else {
            this.f15687f.setVisibility(0);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15913a(String str) {
        this.f15688g = str;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m15910g() {
        CameraLog.m12959b("ProSwitchButtonManager", "initSwitchButton");
        this.f15687f = new SwitchButton(this.f15682a.getApplicationContext());
        this.f15687f.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f15682a.getResources().getDimensionPixelSize(R.dimen.super_eis_switch_width), this.f15682a.getResources().getDimensionPixelSize(R.dimen.super_eis_switch_height));
        layoutParams.addRule(20);
        layoutParams.addRule(2, R.id_renamed.control_panel_layout);
        boolean zEquals = "on".equals(this.f15685d.getString(this.f15688g, "off"));
        if (zEquals) {
            layoutParams.bottomMargin = this.f15682a.getResources().getDimensionPixelOffset(R.dimen.night_pro_switch_on_margin_bottom);
        } else {
            layoutParams.bottomMargin = this.f15682a.getResources().getDimensionPixelOffset(R.dimen.night_pro_switch_off_margin_bottom);
        }
        layoutParams.setMarginStart(this.f15682a.getResources().getDimensionPixelSize(R.dimen.super_eis_switch_margin_left));
        this.f15687f.setChecked(zEquals);
        this.f15687f.m18376a(Util.m24216a((Context) this.f15682a, R.drawable.switch_button_pro_mode), Util.m24216a((Context) this.f15682a, R.drawable.switch_button_pro_mode_bg));
        if (this.f15683b.mo18163b().indexOfChild(this.f15687f) == -1) {
            this.f15683b.mo18163b().addView(this.f15687f, layoutParams);
        }
        this.f15687f.setSwitchClickableListener(new SwitchButton.InterfaceC3114c() { // from class: com.oplus.camera.professional.s.2
            @Override // com.oplus.camera.p172ui.SwitchButton.InterfaceC3114c
            /* renamed from: PlatformImplementations.kt_3 */
            public boolean mo15920a() {
                return (!ProSwitchButtonManager.this.f15684c.mo10469Y() || ProSwitchButtonManager.this.f15687f.m18379a() || ProSwitchButtonManager.this.f15684c.mo10463S()) ? false : true;
            }
        });
        this.f15687f.setOnCheckedChangeListener(new SwitchButton.InterfaceC3112a() { // from class: com.oplus.camera.professional.s.3
            @Override // com.oplus.camera.p172ui.SwitchButton.InterfaceC3112a
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo15921a(SwitchButton switchButton, boolean z) {
                CameraLog.m12954a("ProSwitchButtonManager", "initSwitchButton, onCheckedChanged, isChecked: " + z);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) ProSwitchButtonManager.this.f15687f.getLayoutParams();
                if (z) {
                    layoutParams2.bottomMargin = ProSwitchButtonManager.this.f15682a.getResources().getDimensionPixelOffset(R.dimen.night_pro_switch_on_margin_bottom);
                } else {
                    layoutParams2.bottomMargin = ProSwitchButtonManager.this.f15682a.getResources().getDimensionPixelOffset(R.dimen.night_pro_switch_off_margin_bottom);
                }
                ProSwitchButtonManager.this.f15687f.setLayoutParams(layoutParams2);
                ProSwitchButtonManager.this.f15685d.edit().putString(ProSwitchButtonManager.this.f15688g, z ? "on" : "off").apply();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m15907c(boolean z) {
        CameraLog.m12959b("ProSwitchButtonManager", "hideSwitch, needAnimation: " + z);
        if (this.f15687f == null) {
            CameraLog.m12959b("ProSwitchButtonManager", "hideSwitch, mProSwitchButton is null");
            return;
        }
        if (this.f15683b.mo18163b() == null) {
            CameraLog.m12967f("ProSwitchButtonManager", "hideSwitch, mCameraRootView is null");
        } else if (z) {
            Util.m24270a(this.f15687f, 8, (Animation.AnimationListener) null, 300L);
        } else {
            this.f15687f.setVisibility(8);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m15917d() {
        SwitchButton switchButton = this.f15687f;
        if (switchButton != null) {
            switchButton.setClickable(false);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m15918e() {
        SwitchButton switchButton = this.f15687f;
        if (switchButton != null) {
            switchButton.setClickable(true);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m15919f() {
        SwitchButton switchButton = this.f15687f;
        if (switchButton != null) {
            switchButton.setClickable(true);
        }
    }
}
