package com.oplus.camera.professional;

import android.app.Activity;
import android.view.animation.Animation;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.capmode.CameraInterface;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.professional.PanelContainer;
import com.oplus.camera.util.Util;
import java.util.HashMap;

/* compiled from: NightProMenuManager.java */
/* renamed from: com.oplus.camera.professional.o */
/* loaded from: classes2.dex */
public class NightProMenuManager extends ProMenuManager {
    public NightProMenuManager(Activity activity, CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface, String str) {
        super(activity, interfaceC2646a, cameraUIInterface, str);
    }

    @Override // com.oplus.camera.professional.ProMenuManager
    /* renamed from: PlatformImplementations.kt_3 */
    public HashMap<String, String> mo15713a() {
        HashMap<String, String> map = new HashMap<>();
        map.put("pref_professional_iso_key", "100");
        map.put("pref_professional_exposure_time_key", "1/50s");
        map.put("pref_professional_whitebalance_key", "2000");
        map.put("pref_professional_focus_mode_key", "0.00");
        return map;
    }

    @Override // com.oplus.camera.professional.ProMenuManager
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo15775d() {
        this.f15658g = new NightPanelContainer(this.f15654c, this.f15656e);
        this.f15658g.mo15728a(CameraCharacteristicsUtil.m12971a(this.f15662k, this.f15653b), this.f15657f, m15773y());
    }

    /* renamed from: y */
    private PanelContainer.PlatformImplementations.kt_3 m15773y() {
        PanelContainer.PlatformImplementations.kt_3 configData = this.f15658g.getConfigData();
        configData.f15650b = 15625000L;
        return configData;
    }

    @Override // com.oplus.camera.professional.ProMenuManager
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo15776e() {
        if (this.f15661j != null) {
            this.f15661j.setVisibility(0);
        }
        m15872b(0);
        this.f15656e.mo10563d(true);
        m15887k();
    }

    @Override // com.oplus.camera.professional.ProMenuManager
    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean mo15717c() {
        CameraLog.m12954a("NightProMenuManager", "onBackPressed");
        if (this.f15660i == null || !this.f15660i.isSelected()) {
            return false;
        }
        this.f15660i.m15381a();
        this.f15658g.m15832e();
        this.f15656e.mo10492a(true, true);
        this.f15656e.mo10563d(true);
        if (!this.f15659h.mo12486i()) {
            this.f15655d.mo18068a(0, 1);
        }
        this.f15655d.mo18070a(R.string.camera_scene_night_pro_fixed_tips_oplus_r, -1, false, false, true);
        this.f15655d.mo18193d(0);
        this.f15655d.mo18200d(true, false);
        this.f15659h.mo12484g();
        this.f15659h.mo12475b(true);
        return true;
    }

    @Override // com.oplus.camera.professional.ProMenuManager
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo15774a(final boolean z) {
        if (this.f15658g != null && this.f15658g.m15835g()) {
            CameraLog.m12962c("NightProMenuManager", "onBeforeSnapping, levelPanelScrolling");
            return false;
        }
        if (!z && this.f15658g != null && (!this.f15658g.m15836g(1) || !this.f15658g.m15836g(2))) {
            return false;
        }
        this.f15654c.runOnUiThread(new Runnable() { // from class: com.oplus.camera.professional.o.1
            @Override // java.lang.Runnable
            public void run() {
                CameraLog.m12954a("NightProMenuManager", "onBeforeSnapping isInNightProProcess: " + z);
                if (z && NightProMenuManager.this.f15659h.mo12476b()) {
                    Util.m24270a(NightProMenuManager.this.f15661j, 4, (Animation.AnimationListener) null, 300L);
                }
                NightProMenuManager.this.f15661j.setTouchState(false);
            }
        });
        return true;
    }

    @Override // com.oplus.camera.professional.ProMenuManager
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo15714a(long OplusGLSurfaceView_15) {
        this.f15659h.mo12468a(OplusGLSurfaceView_15);
    }

    @Override // com.oplus.camera.professional.ProMenuManager
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo15715a(byte[] bArr, boolean z, boolean z2) {
        CameraLog.m12954a("NightProMenuManager", "onAfterPictureTaken isInNightProProcess: " + z2 + ", mbNeedShowMenuAfterTakePicture: " + this.f15652a);
        if (z2) {
            m15876c(0);
            this.f15655d.mo18155as();
            if (this.f15659h.mo12476b()) {
                Util.m24270a(this.f15661j, 0, (Animation.AnimationListener) null, 300L);
                m15865a(0, false);
            }
            this.f15655d.mo18217g(true);
            this.f15655d.mo18092a(this.f15659h.mo12485h(), false);
            if (!m15885i()) {
                if (!this.f15655d.mo18201d() && !this.f15659h.mo12486i()) {
                    this.f15655d.mo18068a(0, 1);
                }
                this.f15655d.mo18193d(0);
                this.f15656e.mo10492a(true, false);
            }
        }
        this.f15655d.mo18200d(true, false);
        if (this.f15652a) {
            if (this.f15659h.mo12476b()) {
                Util.m24270a(this.f15661j, 0, (Animation.AnimationListener) null, 300L);
            }
            this.f15652a = false;
        }
        this.f15661j.setTouchState(true);
    }
}
