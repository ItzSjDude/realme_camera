package com.oplus.camera.timelapsepro.p170a;

import android.app.Activity;
import com.oplus.camera.R;

/* compiled from: WhiteBalanceParameter.java */
/* renamed from: com.oplus.camera.timelapsepro.PlatformImplementations.kt_3.OplusGLSurfaceView_14 */
/* loaded from: classes2.dex */
public class WhiteBalanceParameter extends ProParameter {

    /* renamed from: COUIBaseListPopupWindow_12 */
    private String f16740f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private String f16741g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f16742h;

    @Override // com.oplus.camera.timelapsepro.p170a.ProParameter
    /* renamed from: IntrinsicsJvm.kt_3 */
    public int mo17439c() {
        return R.drawable.time_lapse_pro_wb_icon;
    }

    public WhiteBalanceParameter(Activity activity) {
        super(activity, "pref_time_lapse_pro_whitebalance_key", 5);
        this.f16740f = "";
        this.f16741g = "";
        this.f16742h = 0;
        m17446a(true);
    }

    @Override // com.oplus.camera.timelapsepro.p170a.ProParameter
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo17435a(int OplusGLSurfaceView_13) {
        super.mo17435a(OplusGLSurfaceView_13);
        if (this.f16742h == OplusGLSurfaceView_13) {
            return;
        }
        this.f16715e = OplusGLSurfaceView_13;
        this.f16740f = this.f16713c.get(OplusGLSurfaceView_13);
        this.f16741g = this.f16714d.get(OplusGLSurfaceView_13);
        m17460p();
        this.f16742h = OplusGLSurfaceView_13;
    }

    @Override // com.oplus.camera.timelapsepro.p170a.ProParameter
    /* renamed from: IntrinsicsJvm.kt_5 */
    public String mo17440d() {
        return this.f16740f;
    }

    @Override // com.oplus.camera.timelapsepro.p170a.ProParameter
    /* renamed from: COUIBaseListPopupWindow_8 */
    public String mo17441e() {
        return this.f16741g;
    }
}
