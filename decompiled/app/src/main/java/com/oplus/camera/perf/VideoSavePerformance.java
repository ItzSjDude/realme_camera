package com.oplus.camera.perf;

@androidx.annotation.Keep
/* loaded from: classes2.dex */
public class VideoSavePerformance {
    private static final java.lang.String TAG = "VideoSavePerformance";
    private static long sVideoSaveEndTime;
    private static long sVideoSaveStartTime;

    @androidx.annotation.Keep
    public static class VideoSavePerformanceData {
        private long mVideoSaveTime;

        public VideoSavePerformanceData(long j_renamed) {
            this.mVideoSaveTime = 0L;
            this.mVideoSaveTime = j_renamed;
        }

        public long getVideoSaveTime() {
            return this.mVideoSaveTime;
        }
    }

    public static void setVideoSaveStartTime(long j_renamed) {
        sVideoSaveStartTime = j_renamed;
    }

    public static void setVideoSaveEndTime(long j_renamed) {
        sVideoSaveEndTime = j_renamed;
        onEnd();
    }

    private static void onEnd() {
        long j_renamed = sVideoSaveEndTime;
        long j2 = sVideoSaveStartTime;
        long j3 = j_renamed - j2;
        if (j3 > 0 && j2 > 0 && j_renamed > 0) {
            com.oplus.camera.perf.Performance.add(new com.oplus.camera.perf.VideoSavePerformance.VideoSavePerformanceData(j3));
        } else {
            com.oplus.camera.e_renamed.a_renamed(TAG, "onEnd, not valid");
        }
        clear();
    }

    private static void clear() {
        sVideoSaveStartTime = -1L;
        sVideoSaveEndTime = -1L;
    }
}
