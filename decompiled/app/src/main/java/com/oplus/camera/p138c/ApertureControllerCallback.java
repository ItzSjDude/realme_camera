package com.oplus.camera.p138c;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import com.oplus.camera.p141e.CameraMetadataKey;

/* compiled from: ApertureControllerCallback.java */
/* renamed from: com.oplus.camera.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class ApertureControllerCallback {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f12623a = 0;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean f12624b = false;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f12625c = false;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f12626d = false;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f12627e = false;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private long f12628f = 0;

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo11733a() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11734a(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
        Object objM13005a = captureResult != null ? CameraMetadataKey.m13005a(captureResult, CameraMetadataKey.f13239E) : null;
        if (objM13005a == null || !(objM13005a instanceof int[])) {
            return;
        }
        long frameNumber = captureResult.getFrameNumber();
        int[] iArr = (int[]) objM13005a;
        int OplusGLSurfaceView_13 = iArr.length > 0 ? iArr[0] : 0;
        if (!this.f12626d && OplusGLSurfaceView_13 == 1) {
            this.f12626d = true;
            this.f12628f = frameNumber;
        }
        this.f12627e = frameNumber - this.f12628f > 15;
        this.f12624b = OplusGLSurfaceView_13 == 1;
        if (this.f12623a == 1 && (OplusGLSurfaceView_13 == 0 || this.f12627e)) {
            this.f12626d = false;
            mo11733a();
        }
        this.f12623a = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11735a(boolean z) {
        this.f12625c = z;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m11736b() {
        return this.f12625c;
    }
}
