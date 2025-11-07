package com.oplus.camera.perf;

@androidx.annotation.Keep
/* loaded from: classes2.dex */
public class VideoRecordPerformance {
    private static final java.lang.String TAG = "VideoRecordPerformance";
    private static long sStartVideoRecordEndTime;
    private static long sStartVideoRecordStartTime;

    @androidx.annotation.Keep
    public static class VideoRecordPerformanceData {
        private long mStartVideoRecordTime;

        public VideoRecordPerformanceData(long j_renamed) {
            this.mStartVideoRecordTime = j_renamed;
        }
    }

    public static void setStartVideoRecordStartTime(long j_renamed) {
        sStartVideoRecordStartTime = j_renamed;
    }

    public static void setStartVideoRecordEndTime(long j_renamed) {
        sStartVideoRecordEndTime = j_renamed;
        onEnd();
    }

    private static void onEnd() {
        long j_renamed = sStartVideoRecordEndTime;
        long j2 = sStartVideoRecordStartTime;
        long j3 = j_renamed - j2;
        if (j3 > 0 && j2 > 0 && j_renamed > 0) {
            com.oplus.camera.perf.Performance.add(new com.oplus.camera.perf.VideoRecordPerformance.VideoRecordPerformanceData(j3));
        } else {
            com.oplus.camera.e_renamed.a_renamed(TAG, "onEnd, not valid");
        }
        clear();
    }

    private static void clear() {
        sStartVideoRecordStartTime = -1L;
        sStartVideoRecordEndTime = -1L;
    }
}
