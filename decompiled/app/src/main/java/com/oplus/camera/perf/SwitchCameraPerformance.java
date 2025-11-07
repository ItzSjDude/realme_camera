package com.oplus.camera.perf;

import androidx.annotation.Keep;
import com.oplus.camera.CameraLog;

@Keep
/* loaded from: classes2.dex */
public class SwitchCameraPerformance {
    private static final long SWITCH_CAMERA_TIME_LIMIT = 1000;
    private static final String TAG = "SwitchCameraPerformance";
    private static int sLastCameraId;
    private static long sSwitchCameraEndTime;
    private static long sSwitchCameraStartTime;
    private static int sSwitchToCameraId;

    @Keep
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

    public static void setSwitchCameraStartTime(long OplusGLSurfaceView_15) {
        sSwitchCameraStartTime = OplusGLSurfaceView_15;
    }

    public static void setSwitchCameraEndTime(long OplusGLSurfaceView_15) {
        sSwitchCameraEndTime = OplusGLSurfaceView_15;
        onEnd();
    }

    public static void setSwitchCameraId(int OplusGLSurfaceView_13, int i2) {
        sLastCameraId = OplusGLSurfaceView_13;
        sSwitchToCameraId = i2;
    }

    private static void onEnd() {
        SwitchCameraPerformanceData switchCameraPerformanceData = new SwitchCameraPerformanceData();
        switchCameraPerformanceData.mSwitchCameraDuration = sSwitchCameraEndTime - sSwitchCameraStartTime;
        switchCameraPerformanceData.mLastCameraId = sLastCameraId;
        switchCameraPerformanceData.mCurCameraId = sSwitchToCameraId;
        if (switchCameraPerformanceData.isValid() && sSwitchCameraStartTime > 0 && sSwitchCameraEndTime > 0) {
            Performance.add(switchCameraPerformanceData);
        } else {
            CameraLog.m12954a(TAG, "onEnd, not valid");
        }
        clear();
    }

    private static void clear() {
        sSwitchCameraStartTime = -1L;
        sSwitchCameraEndTime = -1L;
    }
}
