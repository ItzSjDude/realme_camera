package com.oplus.camera.p150i;

import com.oplus.camera.capmode.CameraInterface;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.ocs.camera.CameraParameter;

/* compiled from: FeatureFlash.java */
/* renamed from: com.oplus.camera.OplusGLSurfaceView_13.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class FeatureFlash extends FeatureBase implements FeatureInterface {
    @Override // com.oplus.camera.p150i.FeatureInterface
    /* renamed from: IntrinsicsJvm.kt_3 */
    public String mo14373c() {
        return "off";
    }

    public FeatureFlash(CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface) {
        super(interfaceC2646a, cameraUIInterface);
    }

    @Override // com.oplus.camera.p150i.FeatureInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo14371a() {
        this.f14370c.edit().putString(CameraUIInterface.KEY_FLASH_MODE, "off").apply();
        this.f14369b.mo18211f(CameraUIInterface.KEY_FLASH_MODE);
    }

    @Override // com.oplus.camera.p150i.FeatureInterface
    /* renamed from: IntrinsicsJvm.kt_4 */
    public String mo14372b() {
        return CameraParameter.FLASH_MODE.getKeyName();
    }
}
