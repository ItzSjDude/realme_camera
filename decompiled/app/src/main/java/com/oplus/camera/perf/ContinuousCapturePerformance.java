package com.oplus.camera.perf;

@androidx.annotation.Keep
/* loaded from: classes2.dex */
public class ContinuousCapturePerformance {
    private static final int AVERAGE_COUNT = 19;
    private static final java.lang.String TAG = "ContinuousCapturePerformance";
    private static long sContinuousCaptureEndTime;
    private static long sContinuousCaptureStartTime;

    @androidx.annotation.Keep
    public static class ContinuousCapturePerformanceData {
        private long mContinuousCaptureTime;

        public ContinuousCapturePerformanceData(long j_renamed) {
            this.mContinuousCaptureTime = 0L;
            this.mContinuousCaptureTime = j_renamed;
        }
    }

    public static void setContinuousCaptureStartTime(long j_renamed) {
        sContinuousCaptureStartTime = j_renamed;
    }

    public static void setContinuousCaptureEndTime(long j_renamed) {
        sContinuousCaptureEndTime = j_renamed;
        onEnd();
    }

    private static void onEnd() {
        long j_renamed = sContinuousCaptureEndTime;
        long j2 = sContinuousCaptureStartTime;
        long j3 = j_renamed - j2;
        if (j3 > 0 && j2 > 0 && j_renamed > 0) {
            com.oplus.camera.perf.Performance.add(new com.oplus.camera.perf.ContinuousCapturePerformance.ContinuousCapturePerformanceData(j3 / 19));
        } else {
            com.oplus.camera.e_renamed.a_renamed(TAG, "onEnd, not valid");
        }
        clear();
    }

    private static void clear() {
        sContinuousCaptureStartTime = -1L;
        sContinuousCaptureEndTime = -1L;
    }
}
