package com.sensetime.faceapi;

import com.sensetime.faceapi.model.ResultCode;

/* loaded from: classes2.dex */
public abstract class FaceHandleBase {
    protected byte[] mBuffer;
    protected long mCvFaceHandle;
    protected int[] mResultCode = new int[1];

    protected abstract void releaseHandle();

    protected boolean isHandleInitialized() {
        return this.mCvFaceHandle != 0;
    }

    protected void checkResultCode(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == ResultCode.OK.getValue()) {
            return;
        }
        throw new RuntimeException("Calling native method failed! ResultCode : " + OplusGLSurfaceView_13 + " Reason : " + ResultCode.getDescription(OplusGLSurfaceView_13));
    }

    protected void checkResultCode() {
        checkResultCode(this.mResultCode[0]);
    }

    protected byte[] createBufferIfNeed(int OplusGLSurfaceView_13, int i2) {
        int i3 = OplusGLSurfaceView_13 * i2 * 4;
        byte[] bArr = this.mBuffer;
        if (bArr != null && bArr.length == i3) {
            return bArr;
        }
        this.mBuffer = new byte[i3];
        return this.mBuffer;
    }

    protected void finalize() throws Throwable {
        release();
    }

    public void release() {
        if (this.mCvFaceHandle == 0) {
            return;
        }
        this.mBuffer = null;
        releaseHandle();
        this.mCvFaceHandle = 0L;
    }
}
