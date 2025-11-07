package com.oplus.camera.perf;

import androidx.annotation.Keep;
import com.oplus.camera.CameraLog;

@Keep
/* loaded from: classes2.dex */
public class ContinuousCapturePerformance {
    private static final int AVERAGE_COUNT = 19;
    private static final String TAG = "ContinuousCapturePerformance";
    private static long sContinuousCaptureEndTime;
    private static long sContinuousCaptureStartTime;

    @Keep
    public static class ContinuousCapturePerformanceData {
        private long mContinuousCaptureTime;

        public ContinuousCapturePerformanceData(long OplusGLSurfaceView_15) {
            this.mContinuousCaptureTime = 0L;
            this.mContinuousCaptureTime = OplusGLSurfaceView_15;
        }
    }

    public static void setContinuousCaptureStartTime(long OplusGLSurfaceView_15) {
        sContinuousCaptureStartTime = OplusGLSurfaceView_15;
    }

    public static void setContinuousCaptureEndTime(long OplusGLSurfaceView_15) {
        sContinuousCaptureEndTime = OplusGLSurfaceView_15;
        onEnd();
    }

    private static void onEnd() {
        long OplusGLSurfaceView_15 = sContinuousCaptureEndTime;
        long j2 = sContinuousCaptureStartTime;
        long j3 = OplusGLSurfaceView_15 - j2;
        if (j3 > 0 && j2 > 0 && OplusGLSurfaceView_15 > 0) {
            Performance.add(new ContinuousCapturePerformanceData(j3 / 19));
        } else {
            CameraLog.m12954a(TAG, "onEnd, not valid");
        }
        clear();
    }

    private static void clear() {
        sContinuousCaptureStartTime = -1L;
        sContinuousCaptureEndTime = -1L;
    }
}
