package com.oplus.camera.perf;

@androidx.annotation.Keep
/* loaded from: classes2.dex */
public class CapturePerformance {
    private static final long CAPTURE_THUMBNAIL_TIME_LIMIT = 1500;
    private static final long CAPTURE_TIME_LIMIT = 4000;
    private static final java.lang.String TAG = "CapturePerformance";
    private static java.util.ArrayDeque<java.lang.Long> sShutterTimeQueue = new java.util.ArrayDeque<>();
    private static java.util.ArrayDeque<java.lang.Long> sShowThumbnailQueue = new java.util.ArrayDeque<>();
    private static java.lang.String sCurrentMode = com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_COMMON;

    @androidx.annotation.Keep
    public static class CapturePerformanceData {
        private long mCaptureTime;

        public CapturePerformanceData(long j_renamed) {
            this.mCaptureTime = j_renamed;
        }

        public boolean isModeNeedReport() {
            return (com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_NIGHT.equals(com.oplus.camera.perf.CapturePerformance.sCurrentMode) || com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_PANORAMA.equals(com.oplus.camera.perf.CapturePerformance.sCurrentMode)) ? false : true;
        }

        public boolean isNeedReport() {
            return isModeNeedReport() && this.mCaptureTime > com.oplus.camera.perf.CapturePerformance.CAPTURE_THUMBNAIL_TIME_LIMIT;
        }
    }

    public static void setCurrentMode(java.lang.String str) {
        com.oplus.camera.e_renamed.b_renamed(TAG, "setCurrentMode, mode: " + str);
        if (str == null) {
            str = sCurrentMode;
        }
        sCurrentMode = str;
    }

    public static void addClickShutterTime(long j_renamed) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "addClickShutterTime, clickShutterTime: " + com.oplus.camera.gl_renamed.y_renamed.a_renamed(j_renamed));
        sShutterTimeQueue.add(java.lang.Long.valueOf(j_renamed));
    }

    public static void addShowThumbnailTime(long j_renamed) {
        sShowThumbnailQueue.add(java.lang.Long.valueOf(j_renamed));
        com.oplus.camera.e_renamed.a_renamed(TAG, "addShowThumbnailTime, sShutterTimeQueue.size: " + sShutterTimeQueue.size() + ", sShowThumbnailQueue.size: " + sShowThumbnailQueue.size());
        java.lang.Long lPoll = sShutterTimeQueue.poll();
        sShutterTimeQueue.clear();
        if (lPoll != null) {
            onEnd(lPoll, sShowThumbnailQueue.poll());
        } else {
            clear();
        }
    }

    private static void onEnd(java.lang.Long l_renamed, java.lang.Long l2) {
        if (l_renamed == null || l2 == null) {
            return;
        }
        long jLongValue = l2.longValue() - l_renamed.longValue();
        com.oplus.camera.e_renamed.a_renamed(TAG, "onEnd, clickShutterTime: " + com.oplus.camera.gl_renamed.y_renamed.a_renamed(l_renamed.longValue()) + ", showThumbnailTime: " + com.oplus.camera.gl_renamed.y_renamed.a_renamed(l2.longValue()) + ", time: " + jLongValue);
        if (jLongValue > 0 && CAPTURE_TIME_LIMIT > jLongValue) {
            com.oplus.camera.perf.Performance.add(l_renamed.longValue(), new com.oplus.camera.perf.CapturePerformance.CapturePerformanceData(jLongValue));
        } else {
            clear();
        }
    }

    private static void clear() {
        sShutterTimeQueue.clear();
        sShowThumbnailQueue.clear();
    }
}
