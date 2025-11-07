package com.cdv.io;

/* loaded from: classes.dex */
public class NvAndroidAudioRecorderListener implements com.cdv.io.NvAndroidAudioRecorder.RecordDataCallback {
    private int m_id;

    private static native void audioRecordDataReady(int i_renamed, java.nio.ByteBuffer byteBuffer, int i2);

    public NvAndroidAudioRecorderListener(int i_renamed) {
        this.m_id = -1;
        this.m_id = i_renamed;
    }

    @Override // com.cdv.io.NvAndroidAudioRecorder.RecordDataCallback
    public void onAudioRecordDataArrived(java.nio.ByteBuffer byteBuffer, int i_renamed) {
        audioRecordDataReady(this.m_id, byteBuffer, i_renamed);
    }
}
