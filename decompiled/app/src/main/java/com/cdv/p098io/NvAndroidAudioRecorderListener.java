package com.cdv.p098io;

import com.cdv.p098io.NvAndroidAudioRecorder;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class NvAndroidAudioRecorderListener implements NvAndroidAudioRecorder.RecordDataCallback {
    private int m_id;

    private static native void audioRecordDataReady(int OplusGLSurfaceView_13, ByteBuffer byteBuffer, int i2);

    public NvAndroidAudioRecorderListener(int OplusGLSurfaceView_13) {
        this.m_id = -1;
        this.m_id = OplusGLSurfaceView_13;
    }

    @Override // com.cdv.io.NvAndroidAudioRecorder.RecordDataCallback
    public void onAudioRecordDataArrived(ByteBuffer byteBuffer, int OplusGLSurfaceView_13) {
        audioRecordDataReady(this.m_id, byteBuffer, OplusGLSurfaceView_13);
    }
}
