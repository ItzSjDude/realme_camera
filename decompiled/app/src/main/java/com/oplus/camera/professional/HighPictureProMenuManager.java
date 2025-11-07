package com.oplus.camera.professional;

import android.app.Activity;
import com.oplus.camera.capmode.CameraInterface;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.professional.ProMenuManager;
import java.util.HashMap;

/* compiled from: HighPictureProMenuManager.java */
/* renamed from: com.oplus.camera.professional.OplusGLSurfaceView_15 */
/* loaded from: classes2.dex */
public class HighPictureProMenuManager extends ProMenuManager {

    /* compiled from: HighPictureProMenuManager.java */
    /* renamed from: com.oplus.camera.professional.OplusGLSurfaceView_15$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 extends ProMenuManager.IntrinsicsJvm.kt_4 {
        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo12473b(long OplusGLSurfaceView_15);
    }

    public HighPictureProMenuManager(Activity activity, CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface, String str) {
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
        map.put("pref_professional_exposure_compensation_key", "0.00");
        return map;
    }

    @Override // com.oplus.camera.professional.ProMenuManager
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo15716b() {
        if (this.f15658g != null) {
            this.f15658g.scrollTo(3, this.f15658g.m15824c(3).indexOf(ProfessionalUtil.m16135a(this.f15654c, 3)));
        }
    }

    @Override // com.oplus.camera.professional.ProMenuManager
    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean mo15717c() {
        if (this.f15660i == null || !this.f15660i.isSelected()) {
            return false;
        }
        if (!this.f15659h.mo12486i()) {
            this.f15655d.mo18068a(0, 1);
        }
        this.f15658g.m15832e();
        this.f15660i.m15381a();
        this.f15659h.mo12484g();
        this.f15659h.mo12475b(true);
        return true;
    }

    @Override // com.oplus.camera.professional.ProMenuManager
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo15714a(long OplusGLSurfaceView_15) {
        ((PlatformImplementations.kt_3) this.f15659h).mo12473b(OplusGLSurfaceView_15);
        super.mo15714a(OplusGLSurfaceView_15);
    }

    @Override // com.oplus.camera.professional.ProMenuManager
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo15715a(byte[] bArr, boolean z, boolean z2) {
        if (m15881d(m15899w()) && !m15885i()) {
            this.f15655d.mo18068a(0, 1);
        }
        super.mo15715a(bArr, z, z2);
    }
}
