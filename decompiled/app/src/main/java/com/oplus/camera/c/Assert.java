package com.oplus.camera.c_renamed;

/* compiled from: ApertureControllerCallback.java */
/* loaded from: classes2.dex */
public class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f4180a = 0;

    /* renamed from: b_renamed, reason: collision with root package name */
    private boolean f4181b = false;

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f4182c = false;
    private boolean d_renamed = false;
    private boolean e_renamed = false;
    private long f_renamed = 0;

    public void a_renamed() {
    }

    public void a_renamed(android.hardware.camera2.CameraCaptureSession cameraCaptureSession, android.hardware.camera2.CaptureRequest captureRequest, android.hardware.camera2.CaptureResult captureResult) {
        java.lang.Object objA = captureResult != null ? com.oplus.camera.e_renamed.b_renamed.a_renamed(captureResult, com.oplus.camera.e_renamed.b_renamed.E_renamed) : null;
        if (objA == null || !(objA instanceof int[])) {
            return;
        }
        long frameNumber = captureResult.getFrameNumber();
        int[] iArr = (int[]) objA;
        int i_renamed = iArr.length > 0 ? iArr[0] : 0;
        if (!this.d_renamed && i_renamed == 1) {
            this.d_renamed = true;
            this.f_renamed = frameNumber;
        }
        this.e_renamed = frameNumber - this.f_renamed > 15;
        this.f4181b = i_renamed == 1;
        if (this.f4180a == 1 && (i_renamed == 0 || this.e_renamed)) {
            this.d_renamed = false;
            a_renamed();
        }
        this.f4180a = i_renamed;
    }

    public void a_renamed(boolean z_renamed) {
        this.f4182c = z_renamed;
    }

    public boolean b_renamed() {
        return this.f4182c;
    }
}
