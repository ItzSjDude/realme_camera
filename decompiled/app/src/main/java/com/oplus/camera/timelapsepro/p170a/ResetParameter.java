package com.oplus.camera.timelapsepro.p170a;

import android.app.Activity;
import com.oplus.camera.MyApplication;
import com.oplus.camera.R;

/* compiled from: ResetParameter.java */
/* renamed from: com.oplus.camera.timelapsepro.PlatformImplementations.kt_3.COUIBaseListPopupWindow_12 */
/* loaded from: classes2.dex */
public class ResetParameter extends ProParameter {
    @Override // com.oplus.camera.timelapsepro.p170a.ProParameter
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo17437a() {
        return false;
    }

    @Override // com.oplus.camera.timelapsepro.p170a.ProParameter
    /* renamed from: IntrinsicsJvm.kt_3 */
    public int mo17439c() {
        return R.drawable.time_lapse_pro_reset_icon;
    }

    @Override // com.oplus.camera.timelapsepro.p170a.ProParameter
    /* renamed from: IntrinsicsJvm.kt_5 */
    public String mo17440d() {
        return "";
    }

    @Override // com.oplus.camera.timelapsepro.p170a.ProParameter
    /* renamed from: OplusGLSurfaceView_14 */
    public int mo17456l() {
        return R.raw.pro_reset_animation;
    }

    @Override // com.oplus.camera.timelapsepro.p170a.ProParameter
    /* renamed from: OplusGLSurfaceView_6 */
    public boolean mo17457m() {
        return true;
    }

    public ResetParameter(Activity activity) {
        super(activity, "pref_time_lapse_pro_reset_key", 0);
        m17447b(false);
    }

    @Override // com.oplus.camera.timelapsepro.p170a.ProParameter
    /* renamed from: COUIBaseListPopupWindow_8 */
    public String mo17441e() {
        return MyApplication.m11092d().getResources().getString(R.string.camera_face_beauty_menu_reset);
    }
}
