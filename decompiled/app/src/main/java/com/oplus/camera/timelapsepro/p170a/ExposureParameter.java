package com.oplus.camera.timelapsepro.p170a;

import android.app.Activity;
import com.oplus.camera.R;

/* compiled from: ExposureParameter.java */
/* renamed from: com.oplus.camera.timelapsepro.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class ExposureParameter extends ProParameter {

    /* renamed from: COUIBaseListPopupWindow_12 */
    private String f16702f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private String f16703g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f16704h;

    @Override // com.oplus.camera.timelapsepro.p170a.ProParameter
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo17437a() {
        return false;
    }

    @Override // com.oplus.camera.timelapsepro.p170a.ProParameter
    /* renamed from: IntrinsicsJvm.kt_3 */
    public int mo17439c() {
        return R.drawable.time_lapse_pro_ev_icon;
    }

    public ExposureParameter(Activity activity) {
        super(activity, "pref_time_lapse_pro_exposure_compensation_key", 3);
        this.f16702f = "";
        this.f16703g = "";
        this.f16704h = 0;
        m17446a(false);
    }

    @Override // com.oplus.camera.timelapsepro.p170a.ProParameter
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo17435a(int OplusGLSurfaceView_13) {
        super.mo17435a(OplusGLSurfaceView_13);
        if (this.f16704h == OplusGLSurfaceView_13) {
            return;
        }
        this.f16715e = OplusGLSurfaceView_13;
        this.f16702f = this.f16713c.get(OplusGLSurfaceView_13);
        this.f16703g = this.f16714d.get(OplusGLSurfaceView_13);
        m17460p();
        this.f16704h = OplusGLSurfaceView_13;
    }

    @Override // com.oplus.camera.timelapsepro.p170a.ProParameter
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo17438b() {
        this.f16715e = this.f16713c.size() / 2;
        this.f16702f = this.f16713c.get(this.f16715e);
        this.f16703g = this.f16714d.get(this.f16715e);
        m17460p();
    }

    @Override // com.oplus.camera.timelapsepro.p170a.ProParameter
    /* renamed from: IntrinsicsJvm.kt_5 */
    public String mo17440d() {
        return this.f16702f;
    }

    @Override // com.oplus.camera.timelapsepro.p170a.ProParameter
    /* renamed from: COUIBaseListPopupWindow_8 */
    public String mo17441e() {
        return this.f16703g;
    }

    @Override // com.oplus.camera.timelapsepro.p170a.ProParameter
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo17436a(String str) {
        if (str != null) {
            this.f16703g = str;
        } else {
            this.f16703g = this.f16714d.get(this.f16715e);
        }
    }
}
