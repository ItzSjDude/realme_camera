package com.oplus.camera.perf;

import androidx.annotation.Keep;
import com.oplus.camera.CameraLog;

@Keep
/* loaded from: classes2.dex */
public class CameraExitPerformance {
    private static final long MB2BYTE = 1048576;
    private static final String TAG = "CameraExitPerformance";
    private static long sOnPauseStartTime;
    private static long sOnStopEndTime;
    private static int sOnStopMem;
    private static long sOnStopStartTime;

    @Keep
    public static class CameraExitPerformanceData {
        private long mOnPauseTime = 0;
        private long mOnStopTime = 0;
        private int mOnStopMem = 0;

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isValid() {
            return this.mOnPauseTime > 0 && this.mOnStopTime > 0 && this.mOnStopMem > 0;
        }
    }

    public static void setOnPauseStartTime(long OplusGLSurfaceView_15) {
        sOnPauseStartTime = OplusGLSurfaceView_15;
    }

    public static void setOnStopStartTime(long OplusGLSurfaceView_15) {
        sOnStopStartTime = OplusGLSurfaceView_15;
    }

    public static void setsOnStopEndTime(long OplusGLSurfaceView_15) {
        sOnStopEndTime = OplusGLSurfaceView_15;
        onEnd();
    }

    public static void setOnStopMemory(long OplusGLSurfaceView_15) {
        sOnStopMem = (int) (OplusGLSurfaceView_15 / 1048576);
    }

    private static void onEnd() {
        CameraExitPerformanceData cameraExitPerformanceData = new CameraExitPerformanceData();
        cameraExitPerformanceData.mOnPauseTime = sOnStopStartTime - sOnPauseStartTime;
        cameraExitPerformanceData.mOnStopTime = sOnStopEndTime - sOnStopStartTime;
        cameraExitPerformanceData.mOnStopMem = sOnStopMem;
        CameraLog.m12967f(TAG, "onEnd, camera exit time, onPauseTime: " + cameraExitPerformanceData.mOnPauseTime + ", onStopTime: " + cameraExitPerformanceData.mOnStopTime + ", onStopAvailMem: " + sOnStopMem);
        if (cameraExitPerformanceData.isValid() && sOnPauseStartTime > 0 && sOnStopStartTime > 0 && sOnStopEndTime > 0) {
            Performance.add(cameraExitPerformanceData);
        } else {
            CameraLog.m12954a(TAG, "onEnd, not valid");
        }
        clear();
    }

    private static void clear() {
        sOnPauseStartTime = -1L;
        sOnStopStartTime = -1L;
        sOnStopEndTime = -1L;
    }
}
