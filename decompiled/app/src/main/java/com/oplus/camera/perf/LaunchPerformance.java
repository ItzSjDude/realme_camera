package com.oplus.camera.perf;

@androidx.annotation.Keep
/* loaded from: classes2.dex */
public class LaunchPerformance {
    private static final long LAUNCH_TIME_LIMIT = 1200;
    private static final long MB2BYTE = 1048576;
    private static final java.lang.String TAG = "LaunchPerformance";
    private static long sCameraOpenedTime = 0;
    private static java.lang.String sCpuInfo = "";
    private static long sCreateSessionTime;
    private static long sFirstFrameAvailableTime;
    private static long sFirstFrameDrawTime;
    private static int sMemBeforeCreate;
    private static long sOnCreateTime;
    private static long sOpenCameraTime;
    private static long sRequestRepeatingTime;
    private static long sSessionConfiguredTime;

    @androidx.annotation.Keep
    public static class LaunchPerformanceData {
        private long mDurationS1 = 0;
        private long mDurationS2 = 0;
        private long mDurationS3 = 0;
        private long mDurationS4 = 0;
        private long mDurationS5 = 0;
        private long mDurationS6 = 0;
        private long mDurationS7 = 0;
        private int mMemBeforeCreate = 0;
        private java.lang.String mCpuInfo = "";

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
            return launchTime() > com.oplus.camera.perf.LaunchPerformance.LAUNCH_TIME_LIMIT;
        }
    }

    public static void setOnCreateTime(long j_renamed) {
        sOnCreateTime = j_renamed;
    }

    public static void setOpenCameraTime(long j_renamed) {
        sOpenCameraTime = j_renamed;
    }

    public static void setCameraOpenedTime(long j_renamed) {
        sCameraOpenedTime = j_renamed;
    }

    public static void setCreateSessionTime(long j_renamed) {
        sCreateSessionTime = j_renamed;
    }

    public static void setSessionConfiguredTime(long j_renamed) {
        sSessionConfiguredTime = j_renamed;
    }

    public static void setRequestRepeatingTime(long j_renamed) {
        if (sRequestRepeatingTime > 0 || sSessionConfiguredTime <= 0) {
            return;
        }
        sRequestRepeatingTime = j_renamed;
    }

    public static void setFirstFrameAvailableTime(long j_renamed) {
        sFirstFrameAvailableTime = j_renamed;
    }

    public static void setFirstFrameDrawTime(long j_renamed) {
        sFirstFrameDrawTime = j_renamed;
        onEnd();
    }

    public static void setMemBeforeCreate(long j_renamed) {
        sMemBeforeCreate = (int) (j_renamed / 1048576);
    }

    public static void setLaunchCpuInfo(java.lang.String str) {
        sCpuInfo = str;
    }

    private static void onEnd() {
        com.oplus.camera.perf.LaunchPerformance.LaunchPerformanceData launchPerformanceData = new com.oplus.camera.perf.LaunchPerformance.LaunchPerformanceData();
        launchPerformanceData.mDurationS1 = sOpenCameraTime - sOnCreateTime;
        launchPerformanceData.mDurationS2 = sCameraOpenedTime - sOpenCameraTime;
        launchPerformanceData.mDurationS3 = sCreateSessionTime - sCameraOpenedTime;
        launchPerformanceData.mDurationS4 = sSessionConfiguredTime - sCreateSessionTime;
        launchPerformanceData.mDurationS5 = sRequestRepeatingTime - sSessionConfiguredTime;
        launchPerformanceData.mDurationS6 = sFirstFrameAvailableTime - sRequestRepeatingTime;
        launchPerformanceData.mDurationS7 = sFirstFrameDrawTime - sFirstFrameAvailableTime;
        launchPerformanceData.mMemBeforeCreate = sMemBeforeCreate;
        launchPerformanceData.mCpuInfo = sCpuInfo;
        com.oplus.camera.e_renamed.f_renamed(TAG, "onEnd, launch time, s1: " + launchPerformanceData.mDurationS1 + ", s2: " + launchPerformanceData.mDurationS2 + ", s3: " + launchPerformanceData.mDurationS3 + ", s4: " + launchPerformanceData.mDurationS4 + ", s5: " + launchPerformanceData.mDurationS5 + ", s6: " + launchPerformanceData.mDurationS6 + ", s7: " + launchPerformanceData.mDurationS7 + ", memBeforeCreate: " + launchPerformanceData.mMemBeforeCreate + ", cpuInfo: " + launchPerformanceData.mCpuInfo);
        if (launchPerformanceData.isValid() && sOnCreateTime > 0 && sOpenCameraTime > 0 && sCameraOpenedTime > 0 && sCreateSessionTime > 0 && sSessionConfiguredTime > 0 && sRequestRepeatingTime > 0 && sFirstFrameAvailableTime > 0 && sFirstFrameDrawTime > 0) {
            com.oplus.camera.perf.Performance.add(launchPerformanceData);
        } else {
            com.oplus.camera.e_renamed.a_renamed(TAG, "onEnd, not valid");
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
