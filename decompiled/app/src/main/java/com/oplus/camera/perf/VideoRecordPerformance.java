package com.oplus.camera.perf;

import androidx.annotation.Keep;
import com.oplus.camera.CameraLog;

@Keep
/* loaded from: classes2.dex */
public class VideoRecordPerformance {
    private static final String TAG = "VideoRecordPerformance";
    private static long sStartVideoRecordEndTime;
    private static long sStartVideoRecordStartTime;

    @Keep
    public static class VideoRecordPerformanceData {
        private long mStartVideoRecordTime;

        public VideoRecordPerformanceData(long OplusGLSurfaceView_15) {
            this.mStartVideoRecordTime = OplusGLSurfaceView_15;
        }
    }

    public static void setStartVideoRecordStartTime(long OplusGLSurfaceView_15) {
        sStartVideoRecordStartTime = OplusGLSurfaceView_15;
    }

    public static void setStartVideoRecordEndTime(long OplusGLSurfaceView_15) {
        sStartVideoRecordEndTime = OplusGLSurfaceView_15;
        onEnd();
    }

    private static void onEnd() {
        long OplusGLSurfaceView_15 = sStartVideoRecordEndTime;
        long j2 = sStartVideoRecordStartTime;
        long j3 = OplusGLSurfaceView_15 - j2;
        if (j3 > 0 && j2 > 0 && OplusGLSurfaceView_15 > 0) {
            Performance.add(new VideoRecordPerformanceData(j3));
        } else {
            CameraLog.m12954a(TAG, "onEnd, not valid");
        }
        clear();
    }

    private static void clear() {
        sStartVideoRecordStartTime = -1L;
        sStartVideoRecordEndTime = -1L;
    }
}
