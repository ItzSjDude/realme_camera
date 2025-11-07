package com.oplus.camera.perf;

@androidx.annotation.Keep
/* loaded from: classes2.dex */
public class PictureSavePerformance {
    private static final java.lang.String TAG = "PictureSavePerformance";
    private static long sPictureSaveEndTime;
    private static long sPictureSaveStartTime;

    @androidx.annotation.Keep
    public static class PictureSavePerformanceData {
        private long mPictureSaveTime;

        public PictureSavePerformanceData(long j_renamed) {
            this.mPictureSaveTime = 0L;
            this.mPictureSaveTime = j_renamed;
        }

        public long getPictureSaveTime() {
            return this.mPictureSaveTime;
        }
    }

    public static void setPictureSaveStartTime(long j_renamed) {
        sPictureSaveStartTime = j_renamed;
    }

    public static void setPictureSaveEndTime(long j_renamed) {
        sPictureSaveEndTime = j_renamed;
        onEnd();
    }

    private static void onEnd() {
        long j_renamed = sPictureSaveEndTime;
        long j2 = sPictureSaveStartTime;
        long j3 = j_renamed - j2;
        if (j3 > 0 && j2 > 0 && j_renamed > 0) {
            com.oplus.camera.perf.Performance.add(new com.oplus.camera.perf.PictureSavePerformance.PictureSavePerformanceData(j3));
        } else {
            com.oplus.camera.e_renamed.a_renamed(TAG, "onEnd, not valid");
        }
        clear();
    }

    private static void clear() {
        sPictureSaveStartTime = -1L;
        sPictureSaveEndTime = -1L;
    }
}
