package com.meicam.sdk;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class NvsWaveformDataGenerator {
    private float[] m_tmpLeftWaveformData;
    private float[] m_tmpRightWaveformData;
    private WaveformDataCallback m_waveformDataCallback;
    private long m_waveformDataGenerator;
    private final String TAG = "Meicam";
    private long m_nextTaskId = 1;
    private boolean m_fetchingWaveformData = false;
    private long m_tmpSamplesPerGroup = 0;
    private HashMap<Long, Task> m_taskMap = new HashMap<>();

    public interface WaveformDataCallback {
        void onWaveformDataGenerationFailed(long OplusGLSurfaceView_15, String str, long j2);

        void onWaveformDataReady(long OplusGLSurfaceView_15, String str, long j2, long j3, float[] fArr, float[] fArr2);
    }

    private native void nativeCancelTask(long OplusGLSurfaceView_15);

    private native void nativeClose(long OplusGLSurfaceView_15);

    private native long nativeFetchWaveformData(long OplusGLSurfaceView_15, String str, long j2, long j3, long j4);

    private native long nativeGetAudioFileDuration(String str);

    private native long nativeGetAudioFileSampleCount(String str);

    private native long nativeInit();

    private static class Task {
        public String m_audioFilePath;
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
        NvsUtils.checkFunctionInMainThread();
        this.m_waveformDataGenerator = nativeInit();
    }

    public void release() {
        NvsUtils.checkFunctionInMainThread();
        if (isReleased()) {
            return;
        }
        Iterator<Map.Entry<Long, Task>> it = this.m_taskMap.entrySet().iterator();
        while (it.hasNext()) {
            nativeCancelTask(it.next().getValue().waveformTaskId);
        }
        this.m_taskMap.clear();
        this.m_waveformDataCallback = null;
        nativeClose(this.m_waveformDataGenerator);
        this.m_waveformDataGenerator = 0L;
    }

    public boolean isReleased() {
        NvsUtils.checkFunctionInMainThread();
        return this.m_waveformDataGenerator == 0;
    }

    public void setWaveformDataCallback(WaveformDataCallback waveformDataCallback) {
        NvsUtils.checkFunctionInMainThread();
        this.m_waveformDataCallback = waveformDataCallback;
    }

    public long getAudioFileDuration(String str) {
        NvsUtils.checkFunctionInMainThread();
        if (str == null) {
            return 0L;
        }
        return nativeGetAudioFileDuration(str);
    }

    public long getAudioFileSampleCount(String str) {
        NvsUtils.checkFunctionInMainThread();
        if (str == null) {
            return 0L;
        }
        return nativeGetAudioFileSampleCount(str);
    }

    public long generateWaveformData(String str, long OplusGLSurfaceView_15, long j2, long j3, int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        if (isReleased() || str == null || OplusGLSurfaceView_15 <= 0) {
            return 0L;
        }
        long jNativeGetAudioFileSampleCount = nativeGetAudioFileSampleCount(str);
        if (jNativeGetAudioFileSampleCount <= 0) {
            return 0L;
        }
        this.m_fetchingWaveformData = true;
        long jNativeFetchWaveformData = nativeFetchWaveformData(this.m_waveformDataGenerator, str, OplusGLSurfaceView_15, j2, j3);
        this.m_fetchingWaveformData = false;
        if (jNativeFetchWaveformData == 0) {
            return 0L;
        }
        Task task = new Task();
        long j4 = this.m_nextTaskId;
        this.m_nextTaskId = 1 + j4;
        task.taskId = j4;
        task.waveformTaskId = jNativeFetchWaveformData;
        task.m_audioFilePath = str;
        task.m_audioFileSampleCount = jNativeGetAudioFileSampleCount;
        task.m_samplesPerGroup = OplusGLSurfaceView_15;
        if (this.m_tmpSamplesPerGroup > 0) {
            task.m_leftWaveformData = this.m_tmpLeftWaveformData;
            task.m_rightWaveformData = this.m_tmpRightWaveformData;
            task.m_samplesPerGroup = this.m_tmpSamplesPerGroup;
            this.m_tmpLeftWaveformData = null;
            this.m_tmpRightWaveformData = null;
            this.m_tmpSamplesPerGroup = 0L;
        }
        this.m_taskMap.put(Long.valueOf(task.taskId), task);
        if (task.m_leftWaveformData != null) {
            finishWaveformDataFetchingTask(task.taskId, true);
        }
        return task.taskId;
    }

    public void cancelTask(long OplusGLSurfaceView_15) {
        NvsUtils.checkFunctionInMainThread();
        Task task = this.m_taskMap.get(Long.valueOf(OplusGLSurfaceView_15));
        if (task != null) {
            if (!isReleased()) {
                nativeCancelTask(task.waveformTaskId);
            }
            this.m_taskMap.remove(Long.valueOf(OplusGLSurfaceView_15));
        }
    }

    protected void notifyWaveformDataReady(long OplusGLSurfaceView_15, long j2, long j3, float[] fArr, float[] fArr2) {
        long j4;
        if (!this.m_fetchingWaveformData) {
            Iterator<Map.Entry<Long, Task>> it = this.m_taskMap.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    j4 = 0;
                    break;
                }
                Task value = it.next().getValue();
                if (value.waveformTaskId == OplusGLSurfaceView_15) {
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

    private void finishWaveformDataFetchingTask(final long OplusGLSurfaceView_15, boolean z) {
        final WaveformDataCallback waveformDataCallback;
        Task task = this.m_taskMap.get(Long.valueOf(OplusGLSurfaceView_15));
        this.m_taskMap.remove(Long.valueOf(OplusGLSurfaceView_15));
        if (task == null || (waveformDataCallback = this.m_waveformDataCallback) == null) {
            return;
        }
        final String str = task.m_audioFilePath;
        final long j2 = task.m_audioFileSampleCount;
        final long j3 = task.m_samplesPerGroup;
        final float[] fArr = task.m_leftWaveformData;
        final float[] fArr2 = task.m_rightWaveformData;
        if (!z) {
            waveformDataCallback.onWaveformDataReady(OplusGLSurfaceView_15, str, j2, j3, fArr, fArr2);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.meicam.sdk.NvsWaveformDataGenerator.1
                @Override // java.lang.Runnable
                public void run() {
                    waveformDataCallback.onWaveformDataReady(OplusGLSurfaceView_15, str, j2, j3, fArr, fArr2);
                }
            });
        }
    }
}
