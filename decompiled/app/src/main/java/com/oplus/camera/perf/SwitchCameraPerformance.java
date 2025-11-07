package com.oplus.camera.perf;

@androidx.annotation.Keep
/* loaded from: classes2.dex */
public class SwitchCameraPerformance {
    private static final long SWITCH_CAMERA_TIME_LIMIT = 1000;
    private static final java.lang.String TAG = "SwitchCameraPerformance";
    private static int sLastCameraId;
    private static long sSwitchCameraEndTime;
    private static long sSwitchCameraStartTime;
    private static int sSwitchToCameraId;

    @androidx.annotation.Keep
    public static class SwitchCameraPerformanceData {
        private int mCurCameraId;
        private int mLastCameraId;
        private long mSwitchCameraDuration;

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isValid() {
            return this.mSwitchCameraDuration > 0;
        }

        public boolean isNeedReport() {
            return this.mSwitchCameraDuration > 1000;
        }
    }

    public static void setSwitchCameraStartTime(long j_renamed) {
        sSwitchCameraStartTime = j_renamed;
    }

    public static void setSwitchCameraEndTime(long j_renamed) {
        sSwitchCameraEndTime = j_renamed;
        onEnd();
    }

    public static void setSwitchCameraId(int i_renamed, int i2) {
        sLastCameraId = i_renamed;
        sSwitchToCameraId = i2;
    }

    private static void onEnd() {
        com.oplus.camera.perf.SwitchCameraPerformance.SwitchCameraPerformanceData switchCameraPerformanceData = new com.oplus.camera.perf.SwitchCameraPerformance.SwitchCameraPerformanceData();
        switchCameraPerformanceData.mSwitchCameraDuration = sSwitchCameraEndTime - sSwitchCameraStartTime;
        switchCameraPerformanceData.mLastCameraId = sLastCameraId;
        switchCameraPerformanceData.mCurCameraId = sSwitchToCameraId;
        if (switchCameraPerformanceData.isValid() && sSwitchCameraStartTime > 0 && sSwitchCameraEndTime > 0) {
            com.oplus.camera.perf.Performance.add(switchCameraPerformanceData);
        } else {
            com.oplus.camera.e_renamed.a_renamed(TAG, "onEnd, not valid");
        }
        clear();
    }

    private static void clear() {
        sSwitchCameraStartTime = -1L;
        sSwitchCameraEndTime = -1L;
    }
}
