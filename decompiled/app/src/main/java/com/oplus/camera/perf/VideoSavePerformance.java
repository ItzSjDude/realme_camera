package com.oplus.camera.perf;

import androidx.annotation.Keep;
import com.oplus.camera.CameraLog;

@Keep
/* loaded from: classes2.dex */
public class VideoSavePerformance {
    private static final String TAG = "VideoSavePerformance";
    private static long sVideoSaveEndTime;
    private static long sVideoSaveStartTime;

    @Keep
    public static class VideoSavePerformanceData {
        private long mVideoSaveTime;

        public VideoSavePerformanceData(long OplusGLSurfaceView_15) {
            this.mVideoSaveTime = 0L;
            this.mVideoSaveTime = OplusGLSurfaceView_15;
        }

        public long getVideoSaveTime() {
            return this.mVideoSaveTime;
        }
    }

    public static void setVideoSaveStartTime(long OplusGLSurfaceView_15) {
        sVideoSaveStartTime = OplusGLSurfaceView_15;
    }

    public static void setVideoSaveEndTime(long OplusGLSurfaceView_15) {
        sVideoSaveEndTime = OplusGLSurfaceView_15;
        onEnd();
    }

    private static void onEnd() {
        long OplusGLSurfaceView_15 = sVideoSaveEndTime;
        long j2 = sVideoSaveStartTime;
        long j3 = OplusGLSurfaceView_15 - j2;
        if (j3 > 0 && j2 > 0 && OplusGLSurfaceView_15 > 0) {
            Performance.add(new VideoSavePerformanceData(j3));
        } else {
            CameraLog.m12954a(TAG, "onEnd, not valid");
        }
        clear();
    }

    private static void clear() {
        sVideoSaveStartTime = -1L;
        sVideoSaveEndTime = -1L;
    }
}
