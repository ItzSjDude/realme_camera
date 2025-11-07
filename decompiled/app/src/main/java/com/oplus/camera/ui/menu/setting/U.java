package com.oplus.camera.ui.menu.setting;

/* compiled from: CameraSettingFactory.java */
/* loaded from: classes2.dex */
public class n_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static com.oplus.camera.ui.menu.setting.m_renamed f6652a = new com.oplus.camera.ui.menu.setting.m_renamed();

    public static android.os.Bundle a_renamed(com.oplus.camera.capmode.ModeManager modeManager) {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_COUNTDOWN_EFFECT_SHUTTER, modeManager.j_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_COUNTDOWN_EFFECT_SHUTTER));
        bundle.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TAP_SHUTTER, modeManager.j_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TAP_SHUTTER));
        bundle.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_LENS_DIRTY_DETECTION, modeManager.j_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_LENS_DIRTY_DETECTION));
        bundle.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_GESTURE_SHUTTER, modeManager.j_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_GESTURE_SHUTTER));
        bundle.putString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO, modeManager.bA_renamed());
        bundle.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_IS_CAPTURE_MODE, modeManager.h_renamed());
        bundle.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_IS_VIDEO_MODE, modeManager.k_renamed());
        bundle.putString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_MODE, modeManager.n_renamed());
        bundle.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_AI_SCN, modeManager.j_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_AI_SCN));
        bundle.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_CLEAR_PORTRAIT, modeManager.cf_renamed());
        bundle.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_FACE_RECTIFY, modeManager.j_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FACE_RECTIFY) && modeManager.o_renamed());
        bundle.putBoolean(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION, modeManager.j_renamed(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION));
        bundle.putString(com.oplus.camera.ui.CameraUIInterface.KEY_FULL_PIC_SIZE_TYPE, modeManager.ad_renamed());
        bundle.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_RAW, modeManager.j_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_RAW));
        bundle.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_ASSIST_GRADIENTER, modeManager.j_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_ASSIST_GRADIENTER));
        bundle.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_TIME_LAPSE, modeManager.j_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_TIME_LAPSE));
        bundle.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_PICTURE_SIZE, modeManager.j_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_PICTURE_SIZE));
        bundle.putInt(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS, modeManager.bB_renamed());
        bundle.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_HIGH_FPS, modeManager.j_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_HIGH_FPS));
        bundle.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_SLOW_VIDEO_H265, modeManager.j_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_SLOW_VIDEO_H265));
        bundle.putBoolean(com.oplus.camera.aps.config.CameraFunction.KEY_VIDEO_SUPER_EIS_PROCESS, modeManager.j_renamed(com.oplus.camera.aps.config.CameraFunction.KEY_VIDEO_SUPER_EIS_PROCESS));
        bundle.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_RATIO_FPS, modeManager.j_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_RATIO_FPS));
        return f6652a.a_renamed(modeManager, bundle);
    }
}
