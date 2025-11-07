package com.oplus.camera.aps.service;

/* loaded from: classes2.dex */
public class CameraCaptureResult {
    private android.hardware.camera2.CaptureResult mCaptureResult;
    public long mIdentity = 0;
    public long mNightCaptureTotaltime = 0;
    public long mFirstExposureTime = 0;
    public long mMeshPtr = 0;
    private com.oplus.camera.e_renamed.c_renamed mRequestTag = null;

    public CameraCaptureResult(android.hardware.camera2.CaptureResult captureResult) {
        this.mCaptureResult = null;
        this.mCaptureResult = captureResult;
    }

    public android.hardware.camera2.CaptureResult getCaptureResult() {
        return this.mCaptureResult;
    }

    public com.oplus.camera.e_renamed.c_renamed getRequestTag() {
        return this.mRequestTag;
    }

    public void setRequestTag(com.oplus.camera.e_renamed.c_renamed cVar) {
        this.mRequestTag = cVar;
    }
}
