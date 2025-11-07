package com.oplus.camera.doubleexposure;

import android.content.Context;
import android.os.Environment;
import com.oplus.camera.CameraLog;
import com.oplus.camera.aps.util.CameraApsResult;
import com.oplus.camera.util.Util;
import com.oplus.ocs.camera.HumanEffectDoubleExposureApiHelper;

/* compiled from: DoubleExposureManager.java */
/* renamed from: com.oplus.camera.doubleexposure.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class DoubleExposureManager {

    /* renamed from: PlatformImplementations.kt_3 */
    private Context f13187a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private HumanEffectDoubleExposureApiHelper f13188b;

    public DoubleExposureManager(Context context) {
        this.f13187a = null;
        this.f13188b = null;
        this.f13187a = context;
        this.f13188b = HumanEffectDoubleExposureApiHelper.getInstance();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m12909d() {
        HumanEffectDoubleExposureApiHelper.getInstance().preInit();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m12910a() throws Throwable {
        try {
            m12909d();
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.f13188b.setLogLevel(4);
            int iInitByConfig = this.f13188b.initByConfig(true, Util.m24471k("/odm/etc/camera/doubleexposure/model.data"), Environment.getDataDirectory().getAbsolutePath(), "/odm/lib64;/odm/lib/rfsa/adsp", false);
            CameraLog.m12954a("DoubleExposureManager", "init, initByConfig result: " + iInitByConfig + ", cost time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
            return iInitByConfig;
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return -1;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m12913b() {
        HumanEffectDoubleExposureApiHelper humanEffectDoubleExposureApiHelper = this.f13188b;
        if (humanEffectDoubleExposureApiHelper != null) {
            CameraLog.m12954a("DoubleExposureManager", "attachGL, result: " + humanEffectDoubleExposureApiHelper.attachGL());
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12912a(int OplusGLSurfaceView_13) {
        float COUIBaseListPopupWindow_12 = 0.0f;
        if (OplusGLSurfaceView_13 != 4 && OplusGLSurfaceView_13 == 5) {
            COUIBaseListPopupWindow_12 = 1.0f;
        }
        this.f13188b.setParams(COUIBaseListPopupWindow_12);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m12914c() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        CameraLog.m12954a("DoubleExposureManager", "release, releaseResult: " + this.f13188b.release() + ", time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m12911a(int OplusGLSurfaceView_13, int i2, int i3, boolean z, int i4, boolean z2, CameraApsResult cameraApsResult, int i5, int i6, boolean z3) {
        return this.f13188b.process(OplusGLSurfaceView_13, i2, i3, z, i4, z2, cameraApsResult.getHardwareBuffer(), cameraApsResult.mWidth, cameraApsResult.mHeight, i5, i6, z3, cameraApsResult.mHeight % 64 == 0 ? cameraApsResult.mHeight : ((cameraApsResult.mHeight / 64) + 1) * 64);
    }
}
