package com.oplus.camera.p172ui.preview;

import android.graphics.Rect;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.renderscript.Matrix4f;
import com.oplus.camera.CameraLog;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.util.CameraApsResult;
import com.oplus.camera.p141e.CameraMetadataKey;
import com.oplus.camera.p146gl.ExtTexture;
import com.oplus.camera.p146gl.GLES20Canvas;
import com.oplus.camera.p146gl.RawTexture;
import com.oplus.camera.p146gl.GLCanvas;
import com.oplus.camera.p172ui.preview.CameraScreenNail;
import com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess;

/* compiled from: SatCrossAnimManager.java */
/* renamed from: com.oplus.camera.ui.preview.y */
/* loaded from: classes2.dex */
public class SatCrossAnimManager {

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean f22458a = false;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f22459b = 1;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f22460c = 0;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f22461d = Integer.MIN_VALUE;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private RawTexture f22462e = null;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private RawTexture f22463f = null;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f22464g = 0;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f22465h = 0;

    /* renamed from: OplusGLSurfaceView_13 */
    private PreviewEffectProcess f22466i = null;

    /* renamed from: OplusGLSurfaceView_15 */
    private CameraScreenNail.IntrinsicsJvm.kt_4 f22467j = null;

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23893a(PreviewEffectProcess interfaceC3423t) {
        this.f22466i = interfaceC3423t;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23894a(CameraScreenNail.IntrinsicsJvm.kt_4 bVar) {
        this.f22467j = bVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23890a(int OplusGLSurfaceView_13, int i2) {
        this.f22464g = OplusGLSurfaceView_13;
        this.f22465h = i2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int[] m23889a(CaptureResult.Key<?> key, CaptureResult captureResult) {
        Object objM13005a = CameraMetadataKey.m13005a(captureResult, key);
        if (objM13005a == null || !(objM13005a instanceof int[])) {
            return null;
        }
        int[] iArr = (int[]) objM13005a;
        if (iArr.length > 0) {
            return iArr;
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m23887a(CameraApsResult cameraApsResult) {
        int[] iArrM23889a;
        if (cameraApsResult == null || (iArrM23889a = m23889a((CaptureResult.Key<?>) CameraMetadataKey.f13344by, cameraApsResult.getCaptureResult())) == null || iArrM23889a.length <= 0) {
            return -1;
        }
        return iArrM23889a[0];
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private float[] m23888a() {
        Matrix4f matrix4f = new Matrix4f();
        matrix4f.scale(1.0f, -1.0f, 1.0f);
        matrix4f.translate(0.0f, -1.0f, 0.0f);
        return matrix4f.getArray();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23891a(CameraApsResult cameraApsResult, GLCanvas interfaceC2757h, ExtTexture c2756g) {
        if (this.f22467j == null || this.f22466i == null || c2756g == null) {
            return;
        }
        int iM23887a = m23887a(cameraApsResult);
        int OplusGLSurfaceView_13 = this.f22461d;
        if (iM23887a != OplusGLSurfaceView_13 && iM23887a >= 0 && OplusGLSurfaceView_13 >= 0 && this.f22467j.mo23436a() && !this.f22458a) {
            this.f22458a = true;
            float fHashCode = Float.MIN_VALUE;
            if (cameraApsResult != null && cameraApsResult.getCaptureResult() != null && cameraApsResult.getCaptureResult().getRequest() != null) {
                CaptureRequest request = cameraApsResult.getCaptureResult().getRequest();
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SAT_NEED_SET_ZOOMRATIO) && request.get(CaptureRequest.CONTROL_ZOOM_RATIO) != null) {
                    fHashCode = ((Float) request.get(CaptureRequest.CONTROL_ZOOM_RATIO)).floatValue();
                } else if (request.get(CaptureRequest.SCALER_CROP_REGION) != null) {
                    fHashCode = ((Rect) request.get(CaptureRequest.SCALER_CROP_REGION)).hashCode();
                }
            }
            float fMo23435a = this.f22467j.mo23435a(fHashCode);
            if (fMo23435a > 0.0f) {
                this.f22460c = fMo23435a <= 200.0f ? 8 : 4;
            } else {
                this.f22460c = 4;
            }
        }
        if (this.f22458a && 1 == this.f22459b) {
            if (this.f22462e == null) {
                this.f22462e = new RawTexture(this.f22464g, this.f22465h, true);
            }
            this.f22462e = this.f22466i.mo22775a(interfaceC2757h, c2756g, this.f22462e, false);
        }
        this.f22461d = iM23887a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23892a(GLCanvas interfaceC2757h, ExtTexture c2756g, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        if (this.f22467j == null || this.f22466i == null || c2756g == null) {
            return;
        }
        if (this.f22458a && this.f22459b <= this.f22460c) {
            if (this.f22463f == null) {
                this.f22463f = new RawTexture(this.f22464g, this.f22465h, true);
            }
            this.f22463f = this.f22466i.mo22775a(interfaceC2757h, c2756g, this.f22463f, false);
            float COUIBaseListPopupWindow_12 = this.f22459b / this.f22460c;
            interfaceC2757h.mo13972a(this.f22462e, this.f22463f, 1.0f - COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12, m23888a(), OplusGLSurfaceView_13, i2, i3, i4);
            GLES20Canvas.m14010i();
            CameraLog.m12959b("SatCrossAnimManager", "doSatCrossAnim, mSatAnimFrameIndex: " + this.f22459b + ", mSatAnimNums: " + this.f22460c);
            int i5 = this.f22459b;
            if (i5 == this.f22460c) {
                this.f22458a = false;
                this.f22459b = 1;
                this.f22460c = 0;
            } else {
                this.f22459b = i5 + 1;
            }
        }
        if (this.f22467j.mo23436a()) {
            return;
        }
        this.f22458a = false;
        this.f22459b = 1;
        this.f22460c = 0;
        RawTexture c2768s = this.f22462e;
        if (c2768s != null) {
            c2768s.mo13944o();
            this.f22462e = null;
        }
        RawTexture c2768s2 = this.f22463f;
        if (c2768s2 != null) {
            c2768s2.mo13944o();
            this.f22463f = null;
        }
        this.f22467j.mo23437b();
    }
}
