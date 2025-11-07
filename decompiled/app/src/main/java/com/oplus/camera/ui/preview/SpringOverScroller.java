package com.oplus.camera.ui.preview;

/* compiled from: SatCrossAnimManager.java */
/* loaded from: classes2.dex */
public class y_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private boolean f7160a = false;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f7161b = 1;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f7162c = 0;
    private int d_renamed = Integer.MIN_VALUE;
    private com.oplus.camera.gl_renamed.s_renamed e_renamed = null;
    private com.oplus.camera.gl_renamed.s_renamed f_renamed = null;
    private int g_renamed = 0;
    private int h_renamed = 0;
    private com.oplus.camera.ui.preview.a_renamed.t_renamed i_renamed = null;
    private com.oplus.camera.ui.preview.h_renamed.b_renamed j_renamed = null;

    public void a_renamed(com.oplus.camera.ui.preview.a_renamed.t_renamed tVar) {
        this.i_renamed = tVar;
    }

    public void a_renamed(com.oplus.camera.ui.preview.h_renamed.b_renamed bVar) {
        this.j_renamed = bVar;
    }

    public void a_renamed(int i_renamed, int i2) {
        this.g_renamed = i_renamed;
        this.h_renamed = i2;
    }

    private int[] a_renamed(android.hardware.camera2.CaptureResult.Key<?> key, android.hardware.camera2.CaptureResult captureResult) {
        java.lang.Object objA = com.oplus.camera.e_renamed.b_renamed.a_renamed(captureResult, key);
        if (objA == null || !(objA instanceof int[])) {
            return null;
        }
        int[] iArr = (int[]) objA;
        if (iArr.length > 0) {
            return iArr;
        }
        return null;
    }

    private int a_renamed(com.oplus.camera.aps.util.CameraApsResult cameraApsResult) {
        int[] iArrA;
        if (cameraApsResult == null || (iArrA = a_renamed((android.hardware.camera2.CaptureResult.Key<?>) com.oplus.camera.e_renamed.b_renamed.by_renamed, cameraApsResult.getCaptureResult())) == null || iArrA.length <= 0) {
            return -1;
        }
        return iArrA[0];
    }

    private float[] a_renamed() {
        android.renderscript.Matrix4f matrix4f = new android.renderscript.Matrix4f();
        matrix4f.scale(1.0f, -1.0f, 1.0f);
        matrix4f.translate(0.0f, -1.0f, 0.0f);
        return matrix4f.getArray();
    }

    public void a_renamed(com.oplus.camera.aps.util.CameraApsResult cameraApsResult, com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar) {
        if (this.j_renamed == null || this.i_renamed == null || gVar == null) {
            return;
        }
        int iA = a_renamed(cameraApsResult);
        int i_renamed = this.d_renamed;
        if (iA != i_renamed && iA >= 0 && i_renamed >= 0 && this.j_renamed.a_renamed() && !this.f7160a) {
            this.f7160a = true;
            float fHashCode = Float.MIN_VALUE;
            if (cameraApsResult != null && cameraApsResult.getCaptureResult() != null && cameraApsResult.getCaptureResult().getRequest() != null) {
                android.hardware.camera2.CaptureRequest request = cameraApsResult.getCaptureResult().getRequest();
                if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SAT_NEED_SET_ZOOMRATIO) && request.get(android.hardware.camera2.CaptureRequest.CONTROL_ZOOM_RATIO) != null) {
                    fHashCode = ((java.lang.Float) request.get(android.hardware.camera2.CaptureRequest.CONTROL_ZOOM_RATIO)).floatValue();
                } else if (request.get(android.hardware.camera2.CaptureRequest.SCALER_CROP_REGION) != null) {
                    fHashCode = ((android.graphics.Rect) request.get(android.hardware.camera2.CaptureRequest.SCALER_CROP_REGION)).hashCode();
                }
            }
            float fA_renamed = this.j_renamed.a_renamed(fHashCode);
            if (fA_renamed > 0.0f) {
                this.f7162c = fA_renamed <= 200.0f ? 8 : 4;
            } else {
                this.f7162c = 4;
            }
        }
        if (this.f7160a && 1 == this.f7161b) {
            if (this.e_renamed == null) {
                this.e_renamed = new com.oplus.camera.gl_renamed.s_renamed(this.g_renamed, this.h_renamed, true);
            }
            this.e_renamed = this.i_renamed.a_renamed(hVar, gVar, this.e_renamed, false);
        }
        this.d_renamed = iA;
    }

    public void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.g_renamed gVar, int i_renamed, int i2, int i3, int i4) {
        if (this.j_renamed == null || this.i_renamed == null || gVar == null) {
            return;
        }
        if (this.f7160a && this.f7161b <= this.f7162c) {
            if (this.f_renamed == null) {
                this.f_renamed = new com.oplus.camera.gl_renamed.s_renamed(this.g_renamed, this.h_renamed, true);
            }
            this.f_renamed = this.i_renamed.a_renamed(hVar, gVar, this.f_renamed, false);
            float f_renamed = this.f7161b / this.f7162c;
            hVar.a_renamed(this.e_renamed, this.f_renamed, 1.0f - f_renamed, f_renamed, a_renamed(), i_renamed, i2, i3, i4);
            com.oplus.camera.gl_renamed.i_renamed.i_renamed();
            com.oplus.camera.e_renamed.b_renamed("SatCrossAnimManager", "doSatCrossAnim, mSatAnimFrameIndex: " + this.f7161b + ", mSatAnimNums: " + this.f7162c);
            int i5 = this.f7161b;
            if (i5 == this.f7162c) {
                this.f7160a = false;
                this.f7161b = 1;
                this.f7162c = 0;
            } else {
                this.f7161b = i5 + 1;
            }
        }
        if (this.j_renamed.a_renamed()) {
            return;
        }
        this.f7160a = false;
        this.f7161b = 1;
        this.f7162c = 0;
        com.oplus.camera.gl_renamed.s_renamed sVar = this.e_renamed;
        if (sVar != null) {
            sVar.o_renamed();
            this.e_renamed = null;
        }
        com.oplus.camera.gl_renamed.s_renamed sVar2 = this.f_renamed;
        if (sVar2 != null) {
            sVar2.o_renamed();
            this.f_renamed = null;
        }
        this.j_renamed.b_renamed();
    }
}
