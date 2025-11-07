package com.oplus.camera.aps.service;

import android.hardware.camera2.CaptureResult;
import com.oplus.camera.p141e.CameraRequestTag;

/* loaded from: classes2.dex */
public class CameraCaptureResult {
    private CaptureResult mCaptureResult;
    public long mIdentity = 0;
    public long mNightCaptureTotaltime = 0;
    public long mFirstExposureTime = 0;
    public long mMeshPtr = 0;
    private CameraRequestTag mRequestTag = null;

    public CameraCaptureResult(CaptureResult captureResult) {
        this.mCaptureResult = null;
        this.mCaptureResult = captureResult;
    }

    public CaptureResult getCaptureResult() {
        return this.mCaptureResult;
    }

    public CameraRequestTag getRequestTag() {
        return this.mRequestTag;
    }

    public void setRequestTag(CameraRequestTag c2693c) {
        this.mRequestTag = c2693c;
    }
}
