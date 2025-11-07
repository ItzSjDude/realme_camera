package com.oplus.camera.perf;

import androidx.annotation.Keep;
import com.oplus.camera.CameraLog;

@Keep
/* loaded from: classes2.dex */
public class LaunchPerformance {
    private static final long LAUNCH_TIME_LIMIT = 1200;
    private static final long MB2BYTE = 1048576;
    private static final String TAG = "LaunchPerformance";
    private static long sCameraOpenedTime = 0;
    private static String sCpuInfo = "";
    private static long sCreateSessionTime;
    private static long sFirstFrameAvailableTime;
    private static long sFirstFrameDrawTime;
    private static int sMemBeforeCreate;
    private static long sOnCreateTime;
    private static long sOpenCameraTime;
    private static long sRequestRepeatingTime;
    private static long sSessionConfiguredTime;

    @Keep
    public static class LaunchPerformanceData {
        private long mDurationS1 = 0;
        private long mDurationS2 = 0;
        private long mDurationS3 = 0;
        private long mDurationS4 = 0;
        private long mDurationS5 = 0;
        private long mDurationS6 = 0;
        private long mDurationS7 = 0;
        private int mMemBeforeCreate = 0;
        private String mCpuInfo = "";

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isValid() {
            return this.mDurationS1 > 0 && this.mDurationS2 > 0 && this.mDurationS3 > 0 && this.mDurationS4 > 0 && this.mDurationS5 > 0 && this.mDurationS6 > 0 && this.mDurationS7 > 0 && this.mMemBeforeCreate > 0;
        }

        public long launchTime() {
            if (isValid()) {
                return this.mDurationS1 + this.mDurationS2 + this.mDurationS3 + this.mDurationS4 + this.mDurationS5 + this.mDurationS6 + this.mDurationS7;
            }
            return -1L;
        }

        public boolean isNeedReport() {
            return launchTime() > LaunchPerformance.LAUNCH_TIME_LIMIT;
        }
    }

    public static void setOnCreateTime(long OplusGLSurfaceView_15) {
        sOnCreateTime = OplusGLSurfaceView_15;
    }

    public static void setOpenCameraTime(long OplusGLSurfaceView_15) {
        sOpenCameraTime = OplusGLSurfaceView_15;
    }

    public static void setCameraOpenedTime(long OplusGLSurfaceView_15) {
        sCameraOpenedTime = OplusGLSurfaceView_15;
    }

    public static void setCreateSessionTime(long OplusGLSurfaceView_15) {
        sCreateSessionTime = OplusGLSurfaceView_15;
    }

    public static void setSessionConfiguredTime(long OplusGLSurfaceView_15) {
        sSessionConfiguredTime = OplusGLSurfaceView_15;
    }

    public static void setRequestRepeatingTime(long OplusGLSurfaceView_15) {
        if (sRequestRepeatingTime > 0 || sSessionConfiguredTime <= 0) {
            return;
        }
        sRequestRepeatingTime = OplusGLSurfaceView_15;
    }

    public static void setFirstFrameAvailableTime(long OplusGLSurfaceView_15) {
        sFirstFrameAvailableTime = OplusGLSurfaceView_15;
    }

    public static void setFirstFrameDrawTime(long OplusGLSurfaceView_15) {
        sFirstFrameDrawTime = OplusGLSurfaceView_15;
        onEnd();
    }

    public static void setMemBeforeCreate(long OplusGLSurfaceView_15) {
        sMemBeforeCreate = (int) (OplusGLSurfaceView_15 / 1048576);
    }

    public static void setLaunchCpuInfo(String str) {
        sCpuInfo = str;
    }

    private static void onEnd() {
        LaunchPerformanceData launchPerformanceData = new LaunchPerformanceData();
        launchPerformanceData.mDurationS1 = sOpenCameraTime - sOnCreateTime;
        launchPerformanceData.mDurationS2 = sCameraOpenedTime - sOpenCameraTime;
        launchPerformanceData.mDurationS3 = sCreateSessionTime - sCameraOpenedTime;
        launchPerformanceData.mDurationS4 = sSessionConfiguredTime - sCreateSessionTime;
        launchPerformanceData.mDurationS5 = sRequestRepeatingTime - sSessionConfiguredTime;
        launchPerformanceData.mDurationS6 = sFirstFrameAvailableTime - sRequestRepeatingTime;
        launchPerformanceData.mDurationS7 = sFirstFrameDrawTime - sFirstFrameAvailableTime;
        launchPerformanceData.mMemBeforeCreate = sMemBeforeCreate;
        launchPerformanceData.mCpuInfo = sCpuInfo;
        CameraLog.m12967f(TAG, "onEnd, launch time, s1: " + launchPerformanceData.mDurationS1 + ", s2: " + launchPerformanceData.mDurationS2 + ", s3: " + launchPerformanceData.mDurationS3 + ", s4: " + launchPerformanceData.mDurationS4 + ", s5: " + launchPerformanceData.mDurationS5 + ", s6: " + launchPerformanceData.mDurationS6 + ", s7: " + launchPerformanceData.mDurationS7 + ", memBeforeCreate: " + launchPerformanceData.mMemBeforeCreate + ", cpuInfo: " + launchPerformanceData.mCpuInfo);
        if (launchPerformanceData.isValid() && sOnCreateTime > 0 && sOpenCameraTime > 0 && sCameraOpenedTime > 0 && sCreateSessionTime > 0 && sSessionConfiguredTime > 0 && sRequestRepeatingTime > 0 && sFirstFrameAvailableTime > 0 && sFirstFrameDrawTime > 0) {
            Performance.add(launchPerformanceData);
        } else {
            CameraLog.m12954a(TAG, "onEnd, not valid");
        }
        clear();
    }

    private static void clear() {
        sOnCreateTime = -1L;
        sOpenCameraTime = -1L;
        sCameraOpenedTime = -1L;
        sCreateSessionTime = -1L;
        sSessionConfiguredTime = -1L;
        sRequestRepeatingTime = -1L;
        sFirstFrameAvailableTime = -1L;
        sFirstFrameDrawTime = -1L;
    }
}
