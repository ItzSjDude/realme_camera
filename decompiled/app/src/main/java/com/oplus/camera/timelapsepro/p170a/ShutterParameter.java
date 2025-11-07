package com.oplus.camera.timelapsepro.p170a;

import android.app.Activity;
import com.oplus.camera.R;
import java.util.Arrays;

/* compiled from: ShutterParameter.java */
/* renamed from: com.oplus.camera.timelapsepro.PlatformImplementations.kt_3.COUIBaseListPopupWindow_10 */
/* loaded from: classes2.dex */
public class ShutterParameter extends ProParameter {

    /* renamed from: COUIBaseListPopupWindow_12 */
    private String f16730f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private String f16731g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f16732h;

    @Override // com.oplus.camera.timelapsepro.p170a.ProParameter
    /* renamed from: IntrinsicsJvm.kt_3 */
    public int mo17439c() {
        return R.drawable.time_lapse_pro_shutter_icon;
    }

    public ShutterParameter(Activity activity) {
        super(activity, "pref_time_lapse_pro_exposure_time_key", 2);
        this.f16730f = "";
        this.f16731g = "";
        this.f16732h = 0;
        this.f16713c.addAll(Arrays.asList(this.f16711a.getStringArray(R.array.professional_exposure_time_values)));
        this.f16714d.addAll(Arrays.asList(this.f16711a.getStringArray(R.array.professional_exposure_time_names)));
        m17446a(true);
    }

    @Override // com.oplus.camera.timelapsepro.p170a.ProParameter
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo17435a(int OplusGLSurfaceView_13) {
        super.mo17435a(OplusGLSurfaceView_13);
        if (this.f16732h == OplusGLSurfaceView_13) {
            return;
        }
        this.f16715e = OplusGLSurfaceView_13;
        this.f16730f = this.f16713c.get(OplusGLSurfaceView_13);
        this.f16731g = this.f16714d.get(OplusGLSurfaceView_13);
        m17460p();
        this.f16732h = OplusGLSurfaceView_13;
    }

    @Override // com.oplus.camera.timelapsepro.p170a.ProParameter
    /* renamed from: IntrinsicsJvm.kt_5 */
    public String mo17440d() {
        return this.f16730f;
    }

    @Override // com.oplus.camera.timelapsepro.p170a.ProParameter
    /* renamed from: COUIBaseListPopupWindow_8 */
    public String mo17441e() {
        return this.f16731g;
    }
}
