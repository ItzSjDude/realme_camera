package com.oplus.camera.longexposure;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Handler;
import com.oplus.camera.CameraLog;
import com.oplus.camera.capmode.CameraInterface;
import com.oplus.camera.p172ui.CameraUIInterface;

/* compiled from: LongExposureTimeControl.java */
/* renamed from: com.oplus.camera.longexposure.OplusGLSurfaceView_5 */
/* loaded from: classes2.dex */
public class LongExposureTimeControl {

    /* renamed from: PlatformImplementations.kt_3 */
    private Activity f14671a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private SharedPreferences f14672b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Handler f14673c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private CameraInterface f14674d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private CameraUIInterface f14675e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private LongExposureLevelPanel f14676f = null;

    public LongExposureTimeControl(Activity activity, SharedPreferences sharedPreferences, Handler handler, CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface) {
        this.f14671a = null;
        this.f14672b = null;
        this.f14673c = null;
        this.f14675e = null;
        this.f14671a = activity;
        this.f14672b = sharedPreferences;
        this.f14673c = handler;
        this.f14674d = interfaceC2646a;
        this.f14675e = cameraUIInterface;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14647a(int OplusGLSurfaceView_13) {
        if (this.f14676f == null) {
            Activity activity = this.f14671a;
            this.f14676f = new LongExposureLevelPanel(activity, activity, this.f14672b, this.f14673c, this.f14674d);
            this.f14676f.m14597a(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m14650b(int OplusGLSurfaceView_13) {
        this.f14676f.m14601b(OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14648a(int OplusGLSurfaceView_13, boolean z) {
        this.f14676f.m14598a(OplusGLSurfaceView_13, z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14649a(boolean z) {
        CameraLog.m12954a("LongExposureTimeControl", "showViewWithAnimation  isMoreModeShown: " + this.f14675e.mo18057R());
        if (this.f14675e.mo18057R()) {
            return;
        }
        this.f14676f.m14599a(z);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m14651b(boolean z) {
        this.f14676f.m14602b(z);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public float m14652c(int OplusGLSurfaceView_13) {
        return this.f14676f.m14603c(OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m14653d(int OplusGLSurfaceView_13) {
        this.f14676f.m14605d(OplusGLSurfaceView_13);
    }
}
