package com.oplus.camera.perf;

import androidx.annotation.Keep;
import com.oplus.camera.CameraLog;

@Keep
/* loaded from: classes2.dex */
public class PictureSavePerformance {
    private static final String TAG = "PictureSavePerformance";
    private static long sPictureSaveEndTime;
    private static long sPictureSaveStartTime;

    @Keep
    public static class PictureSavePerformanceData {
        private long mPictureSaveTime;

        public PictureSavePerformanceData(long OplusGLSurfaceView_15) {
            this.mPictureSaveTime = 0L;
            this.mPictureSaveTime = OplusGLSurfaceView_15;
        }

        public long getPictureSaveTime() {
            return this.mPictureSaveTime;
        }
    }

    public static void setPictureSaveStartTime(long OplusGLSurfaceView_15) {
        sPictureSaveStartTime = OplusGLSurfaceView_15;
    }

    public static void setPictureSaveEndTime(long OplusGLSurfaceView_15) {
        sPictureSaveEndTime = OplusGLSurfaceView_15;
        onEnd();
    }

    private static void onEnd() {
        long OplusGLSurfaceView_15 = sPictureSaveEndTime;
        long j2 = sPictureSaveStartTime;
        long j3 = OplusGLSurfaceView_15 - j2;
        if (j3 > 0 && j2 > 0 && OplusGLSurfaceView_15 > 0) {
            Performance.add(new PictureSavePerformanceData(j3));
        } else {
            CameraLog.m12954a(TAG, "onEnd, not valid");
        }
        clear();
    }

    private static void clear() {
        sPictureSaveStartTime = -1L;
        sPictureSaveEndTime = -1L;
    }
}
