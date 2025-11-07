package com.sensetime.faceapi;

/* loaded from: classes2.dex */
public abstract class FaceHandleBase {
    protected byte[] mBuffer;
    protected long mCvFaceHandle;
    protected int[] mResultCode = new int[1];

    protected abstract void releaseHandle();

    protected boolean isHandleInitialized() {
        return this.mCvFaceHandle != 0;
    }

    protected void checkResultCode(int i_renamed) {
        if (i_renamed == com.sensetime.faceapi.model.ResultCode.OK.getValue()) {
            return;
        }
        throw new java.lang.RuntimeException("Calling native method failed! ResultCode : " + i_renamed + " Reason : " + com.sensetime.faceapi.model.ResultCode.getDescription(i_renamed));
    }

    protected void checkResultCode() {
        checkResultCode(this.mResultCode[0]);
    }

    protected byte[] createBufferIfNeed(int i_renamed, int i2) {
        int i3 = i_renamed * i2 * 4;
        byte[] bArr = this.mBuffer;
        if (bArr != null && bArr.length == i3) {
            return bArr;
        }
        this.mBuffer = new byte[i3];
        return this.mBuffer;
    }

    protected void finalize() throws java.lang.Throwable {
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
