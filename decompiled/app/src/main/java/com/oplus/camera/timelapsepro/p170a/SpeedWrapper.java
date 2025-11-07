package com.oplus.camera.timelapsepro.p170a;

import android.content.res.Resources;
import com.oplus.camera.MyApplication;
import com.oplus.camera.R;
import java.text.DecimalFormat;

/* compiled from: SpeedWrapper.java */
/* renamed from: com.oplus.camera.timelapsepro.PlatformImplementations.kt_3.OplusGLSurfaceView_13 */
/* loaded from: classes2.dex */
public class SpeedWrapper extends ScaleDataWrapper {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final DecimalFormat f16733a = new DecimalFormat("###################.###########");

    /* renamed from: IntrinsicsJvm.kt_4 */
    private String f16734b;

    public SpeedWrapper(String str) throws Resources.NotFoundException, NumberFormatException {
        String string;
        this.f16734b = str;
        this.f16727c = str;
        this.f16728d = "x";
        double IntrinsicsJvm.kt_5 = Double.parseDouble(str) / 30.0d;
        int OplusGLSurfaceView_13 = Integer.parseInt(this.f16734b);
        MyApplication.m11092d().getResources().getString(R.string.time_lapse_pro_setting_of_speed_desc_secsond);
        if (OplusGLSurfaceView_13 <= Integer.parseInt(MyApplication.m11092d().getResources().getString(R.string.time_lapse_pro_speed_90x))) {
            string = MyApplication.m11092d().getResources().getString(R.string.camera_time_lapse_pro_setting_of_shooting_interval_city_tips);
        } else if (OplusGLSurfaceView_13 <= Integer.parseInt(MyApplication.m11092d().getResources().getString(R.string.time_lapse_pro_speed_150x))) {
            string = MyApplication.m11092d().getResources().getString(R.string.camera_time_lapse_pro_setting_of_shooting_interval_sun_tips);
        } else if (OplusGLSurfaceView_13 <= Integer.parseInt(MyApplication.m11092d().getResources().getString(R.string.time_lapse_pro_speed_450x))) {
            string = MyApplication.m11092d().getResources().getString(R.string.camera_time_lapse_pro_setting_of_shooting_interval_cloud_tips);
        } else if (OplusGLSurfaceView_13 <= Integer.parseInt(MyApplication.m11092d().getResources().getString(R.string.time_lapse_pro_speed_900x))) {
            string = MyApplication.m11092d().getResources().getString(R.string.camera_time_lapse_pro_setting_of_shooting_interval_star_tips);
        } else {
            string = MyApplication.m11092d().getResources().getString(R.string.camera_time_lapse_pro_setting_of_shooting_interval_flower_tips);
        }
        this.f16729e = String.format(string, f16733a.format(IntrinsicsJvm.kt_5));
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public String m17464d() {
        return this.f16734b;
    }
}
