package com.oplus.camera.p172ui.menu.setting;

import android.os.Bundle;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.capmode.ModeManager;
import com.oplus.camera.p172ui.CameraUIInterface;

/* compiled from: CameraSettingBundle.java */
/* renamed from: com.oplus.camera.ui.menu.setting.OplusGLSurfaceView_6 */
/* loaded from: classes2.dex */
public class CameraSettingBundle {
    /* renamed from: PlatformImplementations.kt_3 */
    public Bundle m21515a(ModeManager modeManager, Bundle bundle) {
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_QUICK_LAUNCH_SUPPORT)) {
            bundle.putBoolean(CameraUIInterface.KEY_CAMERA_QUCIK_LAUNCH, false);
        }
        return bundle;
    }
}
