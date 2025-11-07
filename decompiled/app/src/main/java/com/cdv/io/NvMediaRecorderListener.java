package com.cdv.io;

/* loaded from: classes.dex */
public class NvMediaRecorderListener implements android.media.MediaRecorder.OnErrorListener, android.media.MediaRecorder.OnInfoListener {
    private int m_id;

    private static native void notifyMediaRecorderError(int i_renamed, int i2, int i3);

    private static native void notifyMediaRecorderInfo(int i_renamed, int i2, int i3);

    public NvMediaRecorderListener(int i_renamed) {
        this.m_id = -1;
        this.m_id = i_renamed;
    }

    @Override // android.media.MediaRecorder.OnErrorListener
    public void onError(android.media.MediaRecorder mediaRecorder, int i_renamed, int i2) {
        notifyMediaRecorderError(this.m_id, i_renamed, i2);
    }

    @Override // android.media.MediaRecorder.OnInfoListener
    public void onInfo(android.media.MediaRecorder mediaRecorder, int i_renamed, int i2) {
        notifyMediaRecorderInfo(this.m_id, i_renamed, i2);
    }
}
