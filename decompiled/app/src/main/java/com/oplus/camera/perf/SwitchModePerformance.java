package com.oplus.camera.perf;

import androidx.annotation.Keep;
import com.oplus.camera.CameraLog;

@Keep
/* loaded from: classes2.dex */
public class SwitchModePerformance {
    private static final long SWITCH_MODE_TIME_LIMIT = 1000;
    private static final String TAG = "SwitchModePerformance";
    private static String sLastMode;
    private static long sSwitchModeEndTime;
    private static long sSwitchModeStartTime;
    private static String sSwitchToMode;

    @Keep
    public static class SwitchModePerformanceData {
        private String mCurMode;
        private String mLastMode;
        private long mSwitchModeDuration;

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isValid() {
            return this.mSwitchModeDuration > 0;
        }

        public boolean isNeedReport() {
            return this.mSwitchModeDuration > 1000;
        }
    }

    public static void setSwitchModeStartTime(long OplusGLSurfaceView_15) {
        sSwitchModeStartTime = OplusGLSurfaceView_15;
    }

    public static void setSwitchModeEndTime(long OplusGLSurfaceView_15) {
        sSwitchModeEndTime = OplusGLSurfaceView_15;
        onEnd();
    }

    public static void setSwitchMode(String str, String str2) {
        sLastMode = str;
        sSwitchToMode = str2;
    }

    private static void onEnd() {
        SwitchModePerformanceData switchModePerformanceData = new SwitchModePerformanceData();
        switchModePerformanceData.mSwitchModeDuration = sSwitchModeEndTime - sSwitchModeStartTime;
        switchModePerformanceData.mLastMode = sLastMode;
        switchModePerformanceData.mCurMode = sSwitchToMode;
        if (switchModePerformanceData.isValid() && sSwitchModeStartTime > 0 && sSwitchModeEndTime > 0) {
            Performance.add(switchModePerformanceData);
        } else {
            CameraLog.m12954a(TAG, "onEnd, not valid");
        }
        clear();
    }

    private static void clear() {
        sSwitchModeStartTime = -1L;
        sSwitchModeEndTime = -1L;
    }
}
