package com.oplus.camera.ui.menu.setting;

/* compiled from: CameraSettingBundle.java */
/* loaded from: classes2.dex */
public class m_renamed {
    public android.os.Bundle a_renamed(com.oplus.camera.capmode.ModeManager modeManager, android.os.Bundle bundle) {
        if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_QUICK_LAUNCH_SUPPORT)) {
            bundle.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_QUCIK_LAUNCH, false);
        }
        return bundle;
    }
}
