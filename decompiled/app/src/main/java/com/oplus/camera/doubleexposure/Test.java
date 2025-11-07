package com.oplus.camera.doubleexposure;

/* compiled from: DoubleExposureManager.java */
/* loaded from: classes2.dex */
public class d_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.content.Context f4392a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.oplus.ocs.camera.HumanEffectDoubleExposureApiHelper f4393b;

    public d_renamed(android.content.Context context) {
        this.f4392a = null;
        this.f4393b = null;
        this.f4392a = context;
        this.f4393b = com.oplus.ocs.camera.HumanEffectDoubleExposureApiHelper.getInstance();
    }

    private void d_renamed() {
        com.oplus.ocs.camera.HumanEffectDoubleExposureApiHelper.getInstance().preInit();
    }

    public int a_renamed() throws java.lang.Throwable {
        try {
            d_renamed();
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            this.f4393b.setLogLevel(4);
            int iInitByConfig = this.f4393b.initByConfig(true, com.oplus.camera.util.Util.k_renamed("/odm/etc/camera/doubleexposure/model.data"), android.os.Environment.getDataDirectory().getAbsolutePath(), "/odm/lib64;/odm/lib/rfsa/adsp", false);
            com.oplus.camera.e_renamed.a_renamed("DoubleExposureManager", "init, initByConfig result: " + iInitByConfig + ", cost time: " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
            return iInitByConfig;
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            return -1;
        }
    }

    public void b_renamed() {
        com.oplus.ocs.camera.HumanEffectDoubleExposureApiHelper humanEffectDoubleExposureApiHelper = this.f4393b;
        if (humanEffectDoubleExposureApiHelper != null) {
            com.oplus.camera.e_renamed.a_renamed("DoubleExposureManager", "attachGL, result: " + humanEffectDoubleExposureApiHelper.attachGL());
        }
    }

    public void a_renamed(int i_renamed) {
        float f_renamed = 0.0f;
        if (i_renamed != 4 && i_renamed == 5) {
            f_renamed = 1.0f;
        }
        this.f4393b.setParams(f_renamed);
    }

    public void c_renamed() {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        com.oplus.camera.e_renamed.a_renamed("DoubleExposureManager", "release, releaseResult: " + this.f4393b.release() + ", time: " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
    }

    public int a_renamed(int i_renamed, int i2, int i3, boolean z_renamed, int i4, boolean z2, com.oplus.camera.aps.util.CameraApsResult cameraApsResult, int i5, int i6, boolean z3) {
        return this.f4393b.process(i_renamed, i2, i3, z_renamed, i4, z2, cameraApsResult.getHardwareBuffer(), cameraApsResult.mWidth, cameraApsResult.mHeight, i5, i6, z3, cameraApsResult.mHeight % 64 == 0 ? cameraApsResult.mHeight : ((cameraApsResult.mHeight / 64) + 1) * 64);
    }
}
