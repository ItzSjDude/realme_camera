package com.cdv.p098io;

import android.media.AudioRecord;
import android.os.Build;
import android.util.Log;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class NvAndroidAudioRecorder {
    private static final String TAG = "NvAndroidAudioRecorder";
    private static final int m_audioFormat = 2;
    private static final int m_channelConfig = 16;
    private static final int m_chunkSizeInBytes = 2048;
    private static final int m_sampleCountInChunk = 1024;
    private static final int m_sampleRateInHz = 44100;
    private static final int m_sampleSizeInBytes = 2;
    private static final boolean m_verbose = false;
    private ByteBuffer m_chunkBuffer;
    private AudioRecord m_recorder;
    private RecordDataCallback m_recordDataCallback = null;
    private boolean m_isRecording = false;
    private Thread m_recordingThread = null;
    private AtomicInteger m_exitingRecordingThread = new AtomicInteger(0);

    public interface RecordDataCallback {
        void onAudioRecordDataArrived(ByteBuffer byteBuffer, int OplusGLSurfaceView_13);
    }

    public NvAndroidAudioRecorder() {
        this.m_chunkBuffer = null;
        int minBufferSize = AudioRecord.getMinBufferSize(m_sampleRateInHz, 16, 2);
        int OplusGLSurfaceView_13 = 32768 < minBufferSize ? minBufferSize : 32768;
        int i2 = Build.MODEL.equals("Redmi Note 2") ? 7 : 1;
        try {
            this.m_chunkBuffer = ByteBuffer.allocateDirect(2048);
            this.m_recorder = new AudioRecord(i2, m_sampleRateInHz, 16, 2, OplusGLSurfaceView_13);
            if (this.m_recorder.getState() == 0) {
                Log.COUIBaseListPopupWindow_8(TAG, "Failed to initialize AudioRecord object!");
                this.m_recorder.release();
                this.m_recorder = null;
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8(TAG, "" + COUIBaseListPopupWindow_8.getMessage());
            COUIBaseListPopupWindow_8.printStackTrace();
        }
    }

    public void releaseAudioRecorder() {
        AudioRecord audioRecord = this.m_recorder;
        if (audioRecord != null) {
            audioRecord.release();
            this.m_recorder = null;
        }
    }

    public boolean startRecord(RecordDataCallback recordDataCallback) throws IllegalStateException {
        if (this.m_isRecording) {
            return false;
        }
        try {
            this.m_recorder.startRecording();
            this.m_isRecording = true;
            this.m_recordDataCallback = recordDataCallback;
            this.m_recordingThread = new Thread(new Runnable() { // from class: com.cdv.io.NvAndroidAudioRecorder.1
                @Override // java.lang.Runnable
                public void run() throws InterruptedException {
                    NvAndroidAudioRecorder.this.readAudioData();
                }
            }, "Audio Recorder");
            this.m_recordingThread.start();
            return true;
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8(TAG, "" + COUIBaseListPopupWindow_8.getMessage());
            COUIBaseListPopupWindow_8.printStackTrace();
            if (this.m_isRecording) {
                this.m_recorder.stop();
                this.m_isRecording = false;
            }
            this.m_recordDataCallback = null;
            return false;
        }
    }

    public boolean stopRecord() throws IllegalStateException, InterruptedException {
        if (!this.m_isRecording) {
            return false;
        }
        try {
            this.m_exitingRecordingThread.set(1);
            this.m_recordingThread.join();
            this.m_exitingRecordingThread.set(0);
            this.m_recordingThread = null;
            this.m_recordDataCallback = null;
            this.m_recorder.stop();
            this.m_isRecording = false;
            return true;
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8(TAG, "" + COUIBaseListPopupWindow_8.getMessage());
            COUIBaseListPopupWindow_8.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void readAudioData() throws InterruptedException {
        while (true) {
            try {
                int OplusGLSurfaceView_13 = 0;
                this.m_chunkBuffer.position(0);
                while (this.m_exitingRecordingThread.get() == 0) {
                    int i2 = 2048 - OplusGLSurfaceView_13;
                    int i3 = this.m_recorder.read(this.m_chunkBuffer, i2);
                    if (i3 < 0) {
                        Log.COUIBaseListPopupWindow_8(TAG, "read() failed! errno=" + i3);
                        Thread.sleep(4L);
                    } else {
                        if (i3 != 0) {
                            OplusGLSurfaceView_13 += i3;
                            this.m_chunkBuffer.position(OplusGLSurfaceView_13);
                        }
                        if (i3 != i2) {
                            Thread.sleep(4L);
                        } else if (this.m_recordDataCallback != null) {
                            this.m_recordDataCallback.onAudioRecordDataArrived(this.m_chunkBuffer, 1024);
                        }
                    }
                }
                return;
            } catch (Exception COUIBaseListPopupWindow_8) {
                Log.COUIBaseListPopupWindow_8(TAG, "" + COUIBaseListPopupWindow_8.getMessage());
                COUIBaseListPopupWindow_8.printStackTrace();
                return;
            }
        }
    }
}
