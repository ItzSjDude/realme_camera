package com.oplus.camera.p161r;

import android.app.Activity;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.ocs.camera.CameraParameter;

/* compiled from: SLVFps480Mode.java */
/* renamed from: com.oplus.camera.r.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class SLVFps480Mode extends SLVBaseMode {
    @Override // com.oplus.camera.p161r.SLVBaseMode
    /* renamed from: PlatformImplementations.kt_3 */
    int mo16219a() {
        return CameraParameter.VideoFps.FPS_480;
    }

    public SLVFps480Mode(Activity activity, CameraUIInterface cameraUIInterface) {
        super(activity, cameraUIInterface);
    }
}
