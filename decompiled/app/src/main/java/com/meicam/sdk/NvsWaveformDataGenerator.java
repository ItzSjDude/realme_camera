package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsWaveformDataGenerator {
    private float[] m_tmpLeftWaveformData;
    private float[] m_tmpRightWaveformData;
    private com.meicam.sdk.NvsWaveformDataGenerator.WaveformDataCallback m_waveformDataCallback;
    private long m_waveformDataGenerator;
    private final java.lang.String TAG = "Meicam";
    private long m_nextTaskId = 1;
    private boolean m_fetchingWaveformData = false;
    private long m_tmpSamplesPerGroup = 0;
    private java.util.HashMap<java.lang.Long, com.meicam.sdk.NvsWaveformDataGenerator.Task> m_taskMap = new java.util.HashMap<>();

    public interface WaveformDataCallback {
        void onWaveformDataGenerationFailed(long j_renamed, java.lang.String str, long j2);

        void onWaveformDataReady(long j_renamed, java.lang.String str, long j2, long j3, float[] fArr, float[] fArr2);
    }

    private native void nativeCancelTask(long j_renamed);

    private native void nativeClose(long j_renamed);

    private native long nativeFetchWaveformData(long j_renamed, java.lang.String str, long j2, long j3, long j4);

    private native long nativeGetAudioFileDuration(java.lang.String str);

    private native long nativeGetAudioFileSampleCount(java.lang.String str);

    private native long nativeInit();

    private static class Task {
        public java.lang.String m_audioFilePath;
        public long m_audioFileSampleCount;
        private float[] m_leftWaveformData;
        private float[] m_rightWaveformData;
        private long m_samplesPerGroup;
        long taskId;
        long waveformTaskId;

        private Task() {
        }
    }

    public NvsWaveformDataGenerator() {
        this.m_waveformDataGenerator = 0L;
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        this.m_waveformDataGenerator = nativeInit();
    }

    public void release() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        if (isReleased()) {
            return;
        }
        java.util.Iterator<java.util.Map.Entry<java.lang.Long, com.meicam.sdk.NvsWaveformDataGenerator.Task>> it = this.m_taskMap.entrySet().iterator();
        while (it.hasNext()) {
            nativeCancelTask(it.next().getValue().waveformTaskId);
        }
        this.m_taskMap.clear();
        this.m_waveformDataCallback = null;
        nativeClose(this.m_waveformDataGenerator);
        this.m_waveformDataGenerator = 0L;
    }

    public boolean isReleased() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return this.m_waveformDataGenerator == 0;
    }

    public void setWaveformDataCallback(com.meicam.sdk.NvsWaveformDataGenerator.WaveformDataCallback waveformDataCallback) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        this.m_waveformDataCallback = waveformDataCallback;
    }

    public long getAudioFileDuration(java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        if (str == null) {
            return 0L;
        }
        return nativeGetAudioFileDuration(str);
    }

    public long getAudioFileSampleCount(java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        if (str == null) {
            return 0L;
        }
        return nativeGetAudioFileSampleCount(str);
    }

    public long generateWaveformData(java.lang.String str, long j_renamed, long j2, long j3, int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        if (isReleased() || str == null || j_renamed <= 0) {
            return 0L;
        }
        long jNativeGetAudioFileSampleCount = nativeGetAudioFileSampleCount(str);
        if (jNativeGetAudioFileSampleCount <= 0) {
            return 0L;
        }
        this.m_fetchingWaveformData = true;
        long jNativeFetchWaveformData = nativeFetchWaveformData(this.m_waveformDataGenerator, str, j_renamed, j2, j3);
        this.m_fetchingWaveformData = false;
        if (jNativeFetchWaveformData == 0) {
            return 0L;
        }
        com.meicam.sdk.NvsWaveformDataGenerator.Task task = new com.meicam.sdk.NvsWaveformDataGenerator.Task();
        long j4 = this.m_nextTaskId;
        this.m_nextTaskId = 1 + j4;
        task.taskId = j4;
        task.waveformTaskId = jNativeFetchWaveformData;
        task.m_audioFilePath = str;
        task.m_audioFileSampleCount = jNativeGetAudioFileSampleCount;
        task.m_samplesPerGroup = j_renamed;
        if (this.m_tmpSamplesPerGroup > 0) {
            task.m_leftWaveformData = this.m_tmpLeftWaveformData;
            task.m_rightWaveformData = this.m_tmpRightWaveformData;
            task.m_samplesPerGroup = this.m_tmpSamplesPerGroup;
            this.m_tmpLeftWaveformData = null;
            this.m_tmpRightWaveformData = null;
            this.m_tmpSamplesPerGroup = 0L;
        }
        this.m_taskMap.put(java.lang.Long.valueOf(task.taskId), task);
        if (task.m_leftWaveformData != null) {
            finishWaveformDataFetchingTask(task.taskId, true);
        }
        return task.taskId;
    }

    public void cancelTask(long j_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        com.meicam.sdk.NvsWaveformDataGenerator.Task task = this.m_taskMap.get(java.lang.Long.valueOf(j_renamed));
        if (task != null) {
            if (!isReleased()) {
                nativeCancelTask(task.waveformTaskId);
            }
            this.m_taskMap.remove(java.lang.Long.valueOf(j_renamed));
        }
    }

    protected void notifyWaveformDataReady(long j_renamed, long j2, long j3, float[] fArr, float[] fArr2) {
        long j4;
        if (!this.m_fetchingWaveformData) {
            java.util.Iterator<java.util.Map.Entry<java.lang.Long, com.meicam.sdk.NvsWaveformDataGenerator.Task>> it = this.m_taskMap.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    j4 = 0;
                    break;
                }
                com.meicam.sdk.NvsWaveformDataGenerator.Task value = it.next().getValue();
                if (value.waveformTaskId == j_renamed) {
                    value.m_samplesPerGroup = j2;
                    value.m_leftWaveformData = fArr;
                    value.m_rightWaveformData = fArr2;
                    j4 = value.taskId;
                    break;
                }
            }
            if (j4 != 0) {
                finishWaveformDataFetchingTask(j4, false);
                return;
            }
            return;
        }
        this.m_tmpSamplesPerGroup = j2;
        this.m_tmpLeftWaveformData = fArr;
        this.m_tmpRightWaveformData = fArr2;
    }

    private void finishWaveformDataFetchingTask(final long j_renamed, boolean z_renamed) {
        final com.meicam.sdk.NvsWaveformDataGenerator.WaveformDataCallback waveformDataCallback;
        com.meicam.sdk.NvsWaveformDataGenerator.Task task = this.m_taskMap.get(java.lang.Long.valueOf(j_renamed));
        this.m_taskMap.remove(java.lang.Long.valueOf(j_renamed));
        if (task == null || (waveformDataCallback = this.m_waveformDataCallback) == null) {
            return;
        }
        final java.lang.String str = task.m_audioFilePath;
        final long j2 = task.m_audioFileSampleCount;
        final long j3 = task.m_samplesPerGroup;
        final float[] fArr = task.m_leftWaveformData;
        final float[] fArr2 = task.m_rightWaveformData;
        if (!z_renamed) {
            waveformDataCallback.onWaveformDataReady(j_renamed, str, j2, j3, fArr, fArr2);
        } else {
            new android.os.Handler(android.os.Looper.getMainLooper()).post(new java.lang.Runnable() { // from class: com.meicam.sdk.NvsWaveformDataGenerator.1
                @Override // java.lang.Runnable
                public void run() {
                    waveformDataCallback.onWaveformDataReady(j_renamed, str, j2, j3, fArr, fArr2);
                }
            });
        }
    }
}
