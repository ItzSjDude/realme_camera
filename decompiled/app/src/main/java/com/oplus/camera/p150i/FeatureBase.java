package com.oplus.camera.p150i;

import android.content.SharedPreferences;
import com.oplus.camera.capmode.CameraInterface;
import com.oplus.camera.p172ui.CameraUIInterface;

/* compiled from: FeatureBase.java */
/* renamed from: com.oplus.camera.OplusGLSurfaceView_13.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public abstract class FeatureBase implements FeatureInterface {

    /* renamed from: PlatformImplementations.kt_3 */
    public CameraInterface f14368a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public CameraUIInterface f14369b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public SharedPreferences f14370c;

    public FeatureBase(CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface) {
        this.f14368a = null;
        this.f14369b = null;
        this.f14370c = null;
        this.f14368a = interfaceC2646a;
        this.f14369b = cameraUIInterface;
        this.f14370c = this.f14368a.mo10590t();
    }
}
