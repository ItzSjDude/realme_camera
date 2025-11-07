package com.oplus.camera.perf;

@androidx.annotation.Keep
/* loaded from: classes2.dex */
public class CameraExitPerformance {
    private static final long MB2BYTE = 1048576;
    private static final java.lang.String TAG = "CameraExitPerformance";
    private static long sOnPauseStartTime;
    private static long sOnStopEndTime;
    private static int sOnStopMem;
    private static long sOnStopStartTime;

    @androidx.annotation.Keep
    public static class CameraExitPerformanceData {
        private long mOnPauseTime = 0;
        private long mOnStopTime = 0;
        private int mOnStopMem = 0;

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isValid() {
            return this.mOnPauseTime > 0 && this.mOnStopTime > 0 && this.mOnStopMem > 0;
        }
    }

    public static void setOnPauseStartTime(long j_renamed) {
        sOnPauseStartTime = j_renamed;
    }

    public static void setOnStopStartTime(long j_renamed) {
        sOnStopStartTime = j_renamed;
    }

    public static void setsOnStopEndTime(long j_renamed) {
        sOnStopEndTime = j_renamed;
        onEnd();
    }

    public static void setOnStopMemory(long j_renamed) {
        sOnStopMem = (int) (j_renamed / 1048576);
    }

    private static void onEnd() {
        com.oplus.camera.perf.CameraExitPerformance.CameraExitPerformanceData cameraExitPerformanceData = new com.oplus.camera.perf.CameraExitPerformance.CameraExitPerformanceData();
        cameraExitPerformanceData.mOnPauseTime = sOnStopStartTime - sOnPauseStartTime;
        cameraExitPerformanceData.mOnStopTime = sOnStopEndTime - sOnStopStartTime;
        cameraExitPerformanceData.mOnStopMem = sOnStopMem;
        com.oplus.camera.e_renamed.f_renamed(TAG, "onEnd, camera exit time, onPauseTime: " + cameraExitPerformanceData.mOnPauseTime + ", onStopTime: " + cameraExitPerformanceData.mOnStopTime + ", onStopAvailMem: " + sOnStopMem);
        if (cameraExitPerformanceData.isValid() && sOnPauseStartTime > 0 && sOnStopStartTime > 0 && sOnStopEndTime > 0) {
            com.oplus.camera.perf.Performance.add(cameraExitPerformanceData);
        } else {
            com.oplus.camera.e_renamed.a_renamed(TAG, "onEnd, not valid");
        }
        clear();
    }

    private static void clear() {
        sOnPauseStartTime = -1L;
        sOnStopStartTime = -1L;
        sOnStopEndTime = -1L;
    }
}
