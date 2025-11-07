package com.oplus.camera.e_renamed.a_renamed;

/* compiled from: ZoomStateCallback.java */
/* loaded from: classes2.dex */
public class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f4414a = 0;

    /* renamed from: b_renamed, reason: collision with root package name */
    private boolean f4415b = false;

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f4416c = false;
    private boolean d_renamed = false;
    private boolean e_renamed = false;
    private boolean f_renamed = false;
    private long g_renamed = 0;

    public void a_renamed() {
    }

    public void a_renamed(android.hardware.camera2.CameraCaptureSession cameraCaptureSession, android.hardware.camera2.CaptureRequest captureRequest, android.hardware.camera2.CaptureResult captureResult) {
        java.lang.Object objA = captureResult != null ? com.oplus.camera.e_renamed.b_renamed.a_renamed(captureResult, com.oplus.camera.e_renamed.b_renamed.J_renamed) : null;
        if (objA != null && (objA instanceof int[])) {
            long frameNumber = captureResult.getFrameNumber();
            int[] iArr = (int[]) objA;
            int i_renamed = iArr.length > 0 ? iArr[0] : 0;
            if ((!this.d_renamed || this.e_renamed) && i_renamed == 1) {
                this.d_renamed = true;
                this.e_renamed = false;
                this.g_renamed = frameNumber;
            }
            this.f_renamed = frameNumber - this.g_renamed > 30;
            this.f4415b = i_renamed == 1;
            if (this.f4414a == 1 && (i_renamed == 0 || this.f_renamed)) {
                this.d_renamed = false;
                a_renamed();
            }
            this.f4414a = i_renamed;
            return;
        }
        d_renamed();
    }

    public void a_renamed(boolean z_renamed) {
        this.f4416c = z_renamed;
        this.e_renamed = z_renamed;
    }

    public boolean b_renamed() {
        return this.f4416c;
    }

    public boolean c_renamed() {
        return this.f4415b && !this.f_renamed;
    }

    public void d_renamed() {
        this.f4415b = false;
        this.f4416c = false;
        this.f_renamed = false;
        this.e_renamed = false;
        this.d_renamed = false;
        this.g_renamed = 0L;
        this.f4414a = 0;
    }
}
