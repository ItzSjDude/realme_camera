package com.oplus.camera.perf;

import androidx.annotation.Keep;
import com.oplus.camera.CameraLog;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.p146gl.Utils_3;
import java.util.ArrayDeque;

@Keep
/* loaded from: classes2.dex */
public class CapturePerformance {
    private static final long CAPTURE_THUMBNAIL_TIME_LIMIT = 1500;
    private static final long CAPTURE_TIME_LIMIT = 4000;
    private static final String TAG = "CapturePerformance";
    private static ArrayDeque<Long> sShutterTimeQueue = new ArrayDeque<>();
    private static ArrayDeque<Long> sShowThumbnailQueue = new ArrayDeque<>();
    private static String sCurrentMode = ApsConstant.CAPTURE_MODE_COMMON;

    @Keep
    public static class CapturePerformanceData {
        private long mCaptureTime;

        public CapturePerformanceData(long OplusGLSurfaceView_15) {
            this.mCaptureTime = OplusGLSurfaceView_15;
        }

        public boolean isModeNeedReport() {
            return (ApsConstant.CAPTURE_MODE_NIGHT.equals(CapturePerformance.sCurrentMode) || ApsConstant.CAPTURE_MODE_PANORAMA.equals(CapturePerformance.sCurrentMode)) ? false : true;
        }

        public boolean isNeedReport() {
            return isModeNeedReport() && this.mCaptureTime > CapturePerformance.CAPTURE_THUMBNAIL_TIME_LIMIT;
        }
    }

    public static void setCurrentMode(String str) {
        CameraLog.m12959b(TAG, "setCurrentMode, mode: " + str);
        if (str == null) {
            str = sCurrentMode;
        }
        sCurrentMode = str;
    }

    public static void addClickShutterTime(long OplusGLSurfaceView_15) {
        CameraLog.m12954a(TAG, "addClickShutterTime, clickShutterTime: " + Utils_3.m14288a(OplusGLSurfaceView_15));
        sShutterTimeQueue.add(Long.valueOf(OplusGLSurfaceView_15));
    }

    public static void addShowThumbnailTime(long OplusGLSurfaceView_15) {
        sShowThumbnailQueue.add(Long.valueOf(OplusGLSurfaceView_15));
        CameraLog.m12954a(TAG, "addShowThumbnailTime, sShutterTimeQueue.size: " + sShutterTimeQueue.size() + ", sShowThumbnailQueue.size: " + sShowThumbnailQueue.size());
        Long lPoll = sShutterTimeQueue.poll();
        sShutterTimeQueue.clear();
        if (lPoll != null) {
            onEnd(lPoll, sShowThumbnailQueue.poll());
        } else {
            clear();
        }
    }

    private static void onEnd(Long OplusGLSurfaceView_14, Long l2) {
        if (OplusGLSurfaceView_14 == null || l2 == null) {
            return;
        }
        long jLongValue = l2.longValue() - OplusGLSurfaceView_14.longValue();
        CameraLog.m12954a(TAG, "onEnd, clickShutterTime: " + Utils_3.m14288a(OplusGLSurfaceView_14.longValue()) + ", showThumbnailTime: " + Utils_3.m14288a(l2.longValue()) + ", time: " + jLongValue);
        if (jLongValue > 0 && CAPTURE_TIME_LIMIT > jLongValue) {
            Performance.add(OplusGLSurfaceView_14.longValue(), new CapturePerformanceData(jLongValue));
        } else {
            clear();
        }
    }

    private static void clear() {
        sShutterTimeQueue.clear();
        sShowThumbnailQueue.clear();
    }
}
