package com.oplus.camera.p172ui.menu.setting;

import android.os.Bundle;
import com.oplus.camera.aps.config.CameraFunction;
import com.oplus.camera.capmode.ModeManager;
import com.oplus.camera.p172ui.CameraUIInterface;

/* compiled from: CameraSettingFactory.java */
/* renamed from: com.oplus.camera.ui.menu.setting.OplusGLSurfaceView_11 */
/* loaded from: classes2.dex */
public class CameraSettingFactory {

    /* renamed from: PlatformImplementations.kt_3 */
    private static CameraSettingBundle f20251a = new CameraSettingBundle();

    /* renamed from: PlatformImplementations.kt_3 */
    public static Bundle m21516a(ModeManager modeManager) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(CameraUIInterface.KEY_COUNTDOWN_EFFECT_SHUTTER, modeManager.m12091j(CameraUIInterface.KEY_COUNTDOWN_EFFECT_SHUTTER));
        bundle.putBoolean(CameraUIInterface.KEY_CAMERA_TAP_SHUTTER, modeManager.m12091j(CameraUIInterface.KEY_CAMERA_TAP_SHUTTER));
        bundle.putBoolean(CameraUIInterface.KEY_LENS_DIRTY_DETECTION, modeManager.m12091j(CameraUIInterface.KEY_LENS_DIRTY_DETECTION));
        bundle.putBoolean(CameraUIInterface.KEY_CAMERA_GESTURE_SHUTTER, modeManager.m12091j(CameraUIInterface.KEY_CAMERA_GESTURE_SHUTTER));
        bundle.putString(CameraUIInterface.KEY_PHOTO_RATIO, modeManager.m11904bA());
        bundle.putBoolean(CameraUIInterface.KEY_IS_CAPTURE_MODE, modeManager.m12082h());
        bundle.putBoolean(CameraUIInterface.KEY_IS_VIDEO_MODE, modeManager.m12095k());
        bundle.putString(CameraUIInterface.KEY_CAMERA_MODE, modeManager.m12105n());
        bundle.putBoolean(CameraUIInterface.KEY_AI_SCN, modeManager.m12091j(CameraUIInterface.KEY_AI_SCN));
        bundle.putBoolean(CameraUIInterface.KEY_SUPER_CLEAR_PORTRAIT, modeManager.m11997cf());
        bundle.putBoolean(CameraUIInterface.KEY_FACE_RECTIFY, modeManager.m12091j(CameraUIInterface.KEY_FACE_RECTIFY) && modeManager.m12110o());
        bundle.putBoolean(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION, modeManager.m12091j(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION));
        bundle.putString(CameraUIInterface.KEY_FULL_PIC_SIZE_TYPE, modeManager.m11869ad());
        bundle.putBoolean(CameraUIInterface.KEY_RAW, modeManager.m12091j(CameraUIInterface.KEY_RAW));
        bundle.putBoolean(CameraUIInterface.KEY_ASSIST_GRADIENTER, modeManager.m12091j(CameraUIInterface.KEY_ASSIST_GRADIENTER));
        bundle.putBoolean(CameraUIInterface.KEY_TIME_LAPSE, modeManager.m12091j(CameraUIInterface.KEY_TIME_LAPSE));
        bundle.putBoolean(CameraUIInterface.KEY_HIGH_PICTURE_SIZE, modeManager.m12091j(CameraUIInterface.KEY_HIGH_PICTURE_SIZE));
        bundle.putInt(CameraUIInterface.KEY_VIDEO_FPS, modeManager.m11905bB());
        bundle.putBoolean(CameraUIInterface.KEY_VIDEO_HIGH_FPS, modeManager.m12091j(CameraUIInterface.KEY_VIDEO_HIGH_FPS));
        bundle.putBoolean(CameraUIInterface.KEY_SUPPORT_SLOW_VIDEO_H265, modeManager.m12091j(CameraUIInterface.KEY_SUPPORT_SLOW_VIDEO_H265));
        bundle.putBoolean(CameraFunction.KEY_VIDEO_SUPER_EIS_PROCESS, modeManager.m12091j(CameraFunction.KEY_VIDEO_SUPER_EIS_PROCESS));
        bundle.putBoolean(CameraUIInterface.KEY_VIDEO_RATIO_FPS, modeManager.m12091j(CameraUIInterface.KEY_VIDEO_RATIO_FPS));
        return f20251a.m21515a(modeManager, bundle);
    }
}
