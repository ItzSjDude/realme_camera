package com.cdv.io;

/* loaded from: classes.dex */
public class NvAndroidAudioRecorder {
    private static final java.lang.String TAG = "NvAndroidAudioRecorder";
    private static final int m_audioFormat = 2;
    private static final int m_channelConfig = 16;
    private static final int m_chunkSizeInBytes = 2048;
    private static final int m_sampleCountInChunk = 1024;
    private static final int m_sampleRateInHz = 44100;
    private static final int m_sampleSizeInBytes = 2;
    private static final boolean m_verbose = false;
    private java.nio.ByteBuffer m_chunkBuffer;
    private android.media.AudioRecord m_recorder;
    private com.cdv.io.NvAndroidAudioRecorder.RecordDataCallback m_recordDataCallback = null;
    private boolean m_isRecording = false;
    private java.lang.Thread m_recordingThread = null;
    private java.util.concurrent.atomic.AtomicInteger m_exitingRecordingThread = new java.util.concurrent.atomic.AtomicInteger(0);

    public interface RecordDataCallback {
        void onAudioRecordDataArrived(java.nio.ByteBuffer byteBuffer, int i_renamed);
    }

    public NvAndroidAudioRecorder() {
        this.m_chunkBuffer = null;
        int minBufferSize = android.media.AudioRecord.getMinBufferSize(m_sampleRateInHz, 16, 2);
        int i_renamed = 32768 < minBufferSize ? minBufferSize : 32768;
        int i2 = android.os.Build.MODEL.equals("Redmi Note 2") ? 7 : 1;
        try {
            this.m_chunkBuffer = java.nio.ByteBuffer.allocateDirect(2048);
            this.m_recorder = new android.media.AudioRecord(i2, m_sampleRateInHz, 16, 2, i_renamed);
            if (this.m_recorder.getState() == 0) {
                android.util.Log.e_renamed(TAG, "Failed to initialize AudioRecord object!");
                this.m_recorder.release();
                this.m_recorder = null;
            }
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed(TAG, "" + e_renamed.getMessage());
            e_renamed.printStackTrace();
        }
    }

    public void releaseAudioRecorder() {
        android.media.AudioRecord audioRecord = this.m_recorder;
        if (audioRecord != null) {
            audioRecord.release();
            this.m_recorder = null;
        }
    }

    public boolean startRecord(com.cdv.io.NvAndroidAudioRecorder.RecordDataCallback recordDataCallback) throws java.lang.IllegalStateException {
        if (this.m_isRecording) {
            return false;
        }
        try {
            this.m_recorder.startRecording();
            this.m_isRecording = true;
            this.m_recordDataCallback = recordDataCallback;
            this.m_recordingThread = new java.lang.Thread(new java.lang.Runnable() { // from class: com.cdv.io.NvAndroidAudioRecorder.1
                @Override // java.lang.Runnable
                public void run() throws java.lang.InterruptedException {
                    com.cdv.io.NvAndroidAudioRecorder.this.readAudioData();
                }
            }, "Audio Recorder");
            this.m_recordingThread.start();
            return true;
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed(TAG, "" + e_renamed.getMessage());
            e_renamed.printStackTrace();
            if (this.m_isRecording) {
                this.m_recorder.stop();
                this.m_isRecording = false;
            }
            this.m_recordDataCallback = null;
            return false;
        }
    }

    public boolean stopRecord() throws java.lang.IllegalStateException, java.lang.InterruptedException {
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
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed(TAG, "" + e_renamed.getMessage());
            e_renamed.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void readAudioData() throws java.lang.InterruptedException {
        while (true) {
            try {
                int i_renamed = 0;
                this.m_chunkBuffer.position(0);
                while (this.m_exitingRecordingThread.get() == 0) {
                    int i2 = 2048 - i_renamed;
                    int i3 = this.m_recorder.read(this.m_chunkBuffer, i2);
                    if (i3 < 0) {
                        android.util.Log.e_renamed(TAG, "read() failed! errno=" + i3);
                        java.lang.Thread.sleep(4L);
                    } else {
                        if (i3 != 0) {
                            i_renamed += i3;
                            this.m_chunkBuffer.position(i_renamed);
                        }
                        if (i3 != i2) {
                            java.lang.Thread.sleep(4L);
                        } else if (this.m_recordDataCallback != null) {
                            this.m_recordDataCallback.onAudioRecordDataArrived(this.m_chunkBuffer, 1024);
                        }
                    }
                }
                return;
            } catch (java.lang.Exception e_renamed) {
                android.util.Log.e_renamed(TAG, "" + e_renamed.getMessage());
                e_renamed.printStackTrace();
                return;
            }
        }
    }
}
