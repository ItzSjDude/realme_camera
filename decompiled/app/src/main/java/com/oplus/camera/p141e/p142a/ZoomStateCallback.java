package com.oplus.camera.p141e.p142a;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import com.oplus.camera.p141e.CameraMetadataKey;

/* compiled from: ZoomStateCallback.java */
/* renamed from: com.oplus.camera.COUIBaseListPopupWindow_8.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class ZoomStateCallback {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f13222a = 0;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean f13223b = false;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f13224c = false;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f13225d = false;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f13226e = false;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f13227f = false;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private long f13228g = 0;

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo12998a() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12999a(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
        Object objM13005a = captureResult != null ? CameraMetadataKey.m13005a(captureResult, CameraMetadataKey.f13244J) : null;
        if (objM13005a != null && (objM13005a instanceof int[])) {
            long frameNumber = captureResult.getFrameNumber();
            int[] iArr = (int[]) objM13005a;
            int OplusGLSurfaceView_13 = iArr.length > 0 ? iArr[0] : 0;
            if ((!this.f13225d || this.f13226e) && OplusGLSurfaceView_13 == 1) {
                this.f13225d = true;
                this.f13226e = false;
                this.f13228g = frameNumber;
            }
            this.f13227f = frameNumber - this.f13228g > 30;
            this.f13223b = OplusGLSurfaceView_13 == 1;
            if (this.f13222a == 1 && (OplusGLSurfaceView_13 == 0 || this.f13227f)) {
                this.f13225d = false;
                mo12998a();
            }
            this.f13222a = OplusGLSurfaceView_13;
            return;
        }
        m13003d();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13000a(boolean z) {
        this.f13224c = z;
        this.f13226e = z;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m13001b() {
        return this.f13224c;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m13002c() {
        return this.f13223b && !this.f13227f;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m13003d() {
        this.f13223b = false;
        this.f13224c = false;
        this.f13227f = false;
        this.f13226e = false;
        this.f13225d = false;
        this.f13228g = 0L;
        this.f13222a = 0;
    }
}
