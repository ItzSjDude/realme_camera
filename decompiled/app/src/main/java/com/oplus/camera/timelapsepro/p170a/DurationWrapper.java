package com.oplus.camera.timelapsepro.p170a;

import com.oplus.camera.MyApplication;
import com.oplus.camera.R;

/* compiled from: DurationWrapper.java */
/* renamed from: com.oplus.camera.timelapsepro.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class DurationWrapper extends ScaleDataWrapper {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f16700a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private long f16701b = 0;

    public DurationWrapper(int OplusGLSurfaceView_13) {
        this.f16700a = OplusGLSurfaceView_13;
        if (OplusGLSurfaceView_13 <= 0) {
            this.f16727c = MyApplication.m11092d().getResources().getString(R.string.time_lapse_pro_duration_endless);
            this.f16728d = "";
            this.f16729e = MyApplication.m11092d().getResources().getString(R.string.time_lapse_pro_unlimited_time);
        } else {
            this.f16727c = String.valueOf(OplusGLSurfaceView_13);
            this.f16728d = MyApplication.m11092d().getResources().getString(R.string.time_lapse_pro_setting_of_duration_unit);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public DurationWrapper m17432a(SpeedWrapper c3055i) {
        if (this.f16700a > 0 && c3055i != null) {
            m17433a(c3055i.m17464d());
        }
        return this;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17433a(String str) {
        double IntrinsicsJvm.kt_5 = Double.parseDouble(str);
        int OplusGLSurfaceView_13 = this.f16700a;
        this.f16701b = (long) ((OplusGLSurfaceView_13 * 60) / (IntrinsicsJvm.kt_5 / 30.0d));
        this.f16729e = String.format(MyApplication.m11092d().getResources().getString(R.string.time_lapse_pro_setting_of_duration_with_second), Integer.valueOf((int) ((OplusGLSurfaceView_13 * 60) / IntrinsicsJvm.kt_5)));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public long m17431a() {
        return this.f16701b;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m17434b() {
        return this.f16700a;
    }
}
