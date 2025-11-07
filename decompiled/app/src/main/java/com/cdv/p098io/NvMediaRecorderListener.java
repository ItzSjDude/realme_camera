package com.cdv.p098io;

import android.media.MediaRecorder;

/* loaded from: classes.dex */
public class NvMediaRecorderListener implements MediaRecorder.OnErrorListener, MediaRecorder.OnInfoListener {
    private int m_id;

    private static native void notifyMediaRecorderError(int OplusGLSurfaceView_13, int i2, int i3);

    private static native void notifyMediaRecorderInfo(int OplusGLSurfaceView_13, int i2, int i3);

    public NvMediaRecorderListener(int OplusGLSurfaceView_13) {
        this.m_id = -1;
        this.m_id = OplusGLSurfaceView_13;
    }

    @Override // android.media.MediaRecorder.OnErrorListener
    public void onError(MediaRecorder mediaRecorder, int OplusGLSurfaceView_13, int i2) {
        notifyMediaRecorderError(this.m_id, OplusGLSurfaceView_13, i2);
    }

    @Override // android.media.MediaRecorder.OnInfoListener
    public void onInfo(MediaRecorder mediaRecorder, int OplusGLSurfaceView_13, int i2) {
        notifyMediaRecorderInfo(this.m_id, OplusGLSurfaceView_13, i2);
    }
}
