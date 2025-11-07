package com.oplus.camera.r_renamed;

/* compiled from: SLVModeFactory.java */
/* loaded from: classes2.dex */
public class f_renamed {
    public static java.lang.String a_renamed(int i_renamed) {
        if (i_renamed == 120) {
            return com.oplus.camera.aps.config.ConfigDataBase.KEY_SLOW_VIDEO_HFR_120FPS_VIDOETYPE;
        }
        if (i_renamed == 240) {
            return com.oplus.camera.aps.config.ConfigDataBase.KEY_SLOW_VIDEO_HFR_240FPS_VIDOETYPE;
        }
        if (i_renamed == 480) {
            return com.oplus.camera.aps.config.ConfigDataBase.KEY_SLOW_VIDEO_HFR_480FPS_VIDOETYPE;
        }
        if (i_renamed != 960) {
            return null;
        }
        return com.oplus.camera.aps.config.ConfigDataBase.KEY_SLOW_VIDEO_HFR_960FPS_VIDOETYPE;
    }

    public static java.lang.String b_renamed(int i_renamed) {
        java.lang.String[] configStringArrayValue = com.oplus.camera.aps.config.CameraConfig.getConfigStringArrayValue(a_renamed(i_renamed));
        return (configStringArrayValue == null || configStringArrayValue.length != 2) ? "" : configStringArrayValue[0];
    }

    public static java.lang.String c_renamed(int i_renamed) {
        java.lang.String[] configStringArrayValue = com.oplus.camera.aps.config.CameraConfig.getConfigStringArrayValue(a_renamed(i_renamed));
        return (configStringArrayValue == null || configStringArrayValue.length != 2) ? "" : configStringArrayValue[1];
    }

    public static com.oplus.camera.r_renamed.a_renamed a_renamed(int i_renamed, android.app.Activity activity, com.oplus.camera.ui.CameraUIInterface cameraUIInterface) {
        com.oplus.camera.e_renamed.a_renamed("SLVModeFactory", "getSLVFpsMode fpsMode: " + i_renamed);
        if (i_renamed == 120) {
            return new com.oplus.camera.r_renamed.b_renamed(activity, cameraUIInterface);
        }
        if (i_renamed == 240) {
            return new com.oplus.camera.r_renamed.c_renamed(activity, cameraUIInterface);
        }
        if (i_renamed == 480) {
            return new com.oplus.camera.r_renamed.d_renamed(activity, cameraUIInterface);
        }
        if (i_renamed == 960) {
            return new com.oplus.camera.r_renamed.e_renamed(activity, cameraUIInterface);
        }
        throw new java.lang.Error("Invalid fpsMode " + i_renamed);
    }
}
