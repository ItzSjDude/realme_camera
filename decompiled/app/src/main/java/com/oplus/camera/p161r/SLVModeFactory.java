package com.oplus.camera.p161r;

import android.app.Activity;
import com.oplus.camera.CameraLog;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.p172ui.CameraUIInterface;

/* compiled from: SLVModeFactory.java */
/* renamed from: com.oplus.camera.r.COUIBaseListPopupWindow_12 */
/* loaded from: classes2.dex */
public class SLVModeFactory {
    /* renamed from: PlatformImplementations.kt_3 */
    public static String m16238a(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 120) {
            return ConfigDataBase.KEY_SLOW_VIDEO_HFR_120FPS_VIDOETYPE;
        }
        if (OplusGLSurfaceView_13 == 240) {
            return ConfigDataBase.KEY_SLOW_VIDEO_HFR_240FPS_VIDOETYPE;
        }
        if (OplusGLSurfaceView_13 == 480) {
            return ConfigDataBase.KEY_SLOW_VIDEO_HFR_480FPS_VIDOETYPE;
        }
        if (OplusGLSurfaceView_13 != 960) {
            return null;
        }
        return ConfigDataBase.KEY_SLOW_VIDEO_HFR_960FPS_VIDOETYPE;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static String m16239b(int OplusGLSurfaceView_13) {
        String[] configStringArrayValue = CameraConfig.getConfigStringArrayValue(m16238a(OplusGLSurfaceView_13));
        return (configStringArrayValue == null || configStringArrayValue.length != 2) ? "" : configStringArrayValue[0];
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static String m16240c(int OplusGLSurfaceView_13) {
        String[] configStringArrayValue = CameraConfig.getConfigStringArrayValue(m16238a(OplusGLSurfaceView_13));
        return (configStringArrayValue == null || configStringArrayValue.length != 2) ? "" : configStringArrayValue[1];
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static SLVBaseMode m16237a(int OplusGLSurfaceView_13, Activity activity, CameraUIInterface cameraUIInterface) {
        CameraLog.m12954a("SLVModeFactory", "getSLVFpsMode fpsMode: " + OplusGLSurfaceView_13);
        if (OplusGLSurfaceView_13 == 120) {
            return new SLVFps120Mode(activity, cameraUIInterface);
        }
        if (OplusGLSurfaceView_13 == 240) {
            return new SLVFps240Mode(activity, cameraUIInterface);
        }
        if (OplusGLSurfaceView_13 == 480) {
            return new SLVFps480Mode(activity, cameraUIInterface);
        }
        if (OplusGLSurfaceView_13 == 960) {
            return new SLVFps960Mode(activity, cameraUIInterface);
        }
        throw new Error("Invalid fpsMode " + OplusGLSurfaceView_13);
    }
}
