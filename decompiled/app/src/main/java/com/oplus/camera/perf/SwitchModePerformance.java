package com.oplus.camera.perf;

@androidx.annotation.Keep
/* loaded from: classes2.dex */
public class SwitchModePerformance {
    private static final long SWITCH_MODE_TIME_LIMIT = 1000;
    private static final java.lang.String TAG = "SwitchModePerformance";
    private static java.lang.String sLastMode;
    private static long sSwitchModeEndTime;
    private static long sSwitchModeStartTime;
    private static java.lang.String sSwitchToMode;

    @androidx.annotation.Keep
    public static class SwitchModePerformanceData {
        private java.lang.String mCurMode;
        private java.lang.String mLastMode;
        private long mSwitchModeDuration;

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isValid() {
            return this.mSwitchModeDuration > 0;
        }

        public boolean isNeedReport() {
            return this.mSwitchModeDuration > 1000;
        }
    }

    public static void setSwitchModeStartTime(long j_renamed) {
        sSwitchModeStartTime = j_renamed;
    }

    public static void setSwitchModeEndTime(long j_renamed) {
        sSwitchModeEndTime = j_renamed;
        onEnd();
    }

    public static void setSwitchMode(java.lang.String str, java.lang.String str2) {
        sLastMode = str;
        sSwitchToMode = str2;
    }

    private static void onEnd() {
        com.oplus.camera.perf.SwitchModePerformance.SwitchModePerformanceData switchModePerformanceData = new com.oplus.camera.perf.SwitchModePerformance.SwitchModePerformanceData();
        switchModePerformanceData.mSwitchModeDuration = sSwitchModeEndTime - sSwitchModeStartTime;
        switchModePerformanceData.mLastMode = sLastMode;
        switchModePerformanceData.mCurMode = sSwitchToMode;
        if (switchModePerformanceData.isValid() && sSwitchModeStartTime > 0 && sSwitchModeEndTime > 0) {
            com.oplus.camera.perf.Performance.add(switchModePerformanceData);
        } else {
            com.oplus.camera.e_renamed.a_renamed(TAG, "onEnd, not valid");
        }
        clear();
    }

    private static void clear() {
        sSwitchModeStartTime = -1L;
        sSwitchModeEndTime = -1L;
    }
}
