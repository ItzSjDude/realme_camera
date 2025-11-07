package com.oplus.camera.timelapsepro.p170a;

import android.app.Activity;
import com.oplus.camera.R;

/* compiled from: FocusParameter.java */
/* renamed from: com.oplus.camera.timelapsepro.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class FocusParameter extends ProParameter {

    /* renamed from: COUIBaseListPopupWindow_12 */
    private String f16705f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private String f16706g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f16707h;

    @Override // com.oplus.camera.timelapsepro.p170a.ProParameter
    /* renamed from: IntrinsicsJvm.kt_3 */
    public int mo17439c() {
        return R.drawable.time_lapse_pro_focus_icon;
    }

    public FocusParameter(Activity activity) {
        super(activity, "pref_time_lapse_pro_focus_mode_key", 4);
        this.f16705f = "";
        this.f16706g = "";
        this.f16707h = 0;
        m17446a(true);
    }

    @Override // com.oplus.camera.timelapsepro.p170a.ProParameter
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo17435a(int OplusGLSurfaceView_13) {
        super.mo17435a(OplusGLSurfaceView_13);
        if (this.f16707h == OplusGLSurfaceView_13) {
            return;
        }
        this.f16715e = OplusGLSurfaceView_13;
        this.f16705f = this.f16713c.get(OplusGLSurfaceView_13);
        this.f16706g = this.f16714d.get(OplusGLSurfaceView_13);
        m17460p();
        this.f16707h = OplusGLSurfaceView_13;
    }

    @Override // com.oplus.camera.timelapsepro.p170a.ProParameter
    /* renamed from: IntrinsicsJvm.kt_5 */
    public String mo17440d() {
        return this.f16705f;
    }

    @Override // com.oplus.camera.timelapsepro.p170a.ProParameter
    /* renamed from: COUIBaseListPopupWindow_8 */
    public String mo17441e() {
        return this.f16706g;
    }
}
