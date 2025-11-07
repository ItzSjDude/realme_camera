package com.oplus.camera.statistics.model;

/* loaded from: classes2.dex */
public class PerformanceMsgData extends com.oplus.camera.statistics.model.DcsMsgData {
    public static final java.lang.String CAMERA_FOCUS_TIME = "camera_focus_time";
    public static final java.lang.String CAMERA_MODE_SWITCH_TIME = "camera_mode_switch_time";
    public static final java.lang.String CAMERA_SHUTTER_BUTTON_CLICKABLE_TIME = "camera_shutter_button_clickable_time";
    public static final java.lang.String CAMERA_START_TIME = "camera_start_time";
    public static final java.lang.String CAMERA_SWITCH_TIME = "camera_switch_time";
    public static final java.lang.String CAMERA_VIDEO_FOCUS_TIME = "camera_video_focus_time";
    public static final java.lang.String CAMERA_VIDEO_SAVE_TIME = "camera_video_save_time";
    public static final java.lang.String CAMERA_VIDEO_START_TIME = "camera_video_start_time";
    private static final java.lang.String EVENT_PERFORMANCE = "performance";
    private static final java.lang.String LOG_TAG_PERFORMANCE = "204";
    private static final int MAX_LENGTH = 10;
    public static final java.lang.String MINI_PIC_SAVE_TIME = "mini_pic_save_time";
    private static final int REAL_TIME_BASE = 1000;
    private static final java.lang.String SCREEN_FPS = "screen_fps";
    private static final java.lang.String TAG = "PerformanceMsgData";
    private static java.util.HashMap<java.lang.String, java.lang.String> sStartPointMap = new java.util.HashMap<>();
    private static long[] sFrameRateList = new long[10];
    private static java.util.ArrayList<java.lang.Long> sFocusCosts = new java.util.ArrayList<>();
    private static long sRealTimeFrameStart = 0;
    private static int sFrameRateIndex = 0;

    public PerformanceMsgData(android.content.Context context) {
        super(context, LOG_TAG_PERFORMANCE, EVENT_PERFORMANCE);
    }

    public static void startPointTime(java.lang.String str) {
        sStartPointMap.put(str, java.lang.String.valueOf(java.lang.System.currentTimeMillis()));
        if (CAMERA_START_TIME.equals(str)) {
            sFrameRateList = new long[10];
        }
    }

    public static long getPointTime(java.lang.String str) {
        java.lang.String str2 = sStartPointMap.get(str);
        if (android.text.TextUtils.isEmpty(str2)) {
            return -1L;
        }
        sStartPointMap.put(str, "");
        return java.lang.System.currentTimeMillis() - java.lang.Long.valueOf(str2).longValue();
    }

    public static void getRealtimeFrameRate() {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        long j_renamed = sRealTimeFrameStart;
        if (j_renamed != 0 && j_renamed != jCurrentTimeMillis) {
            long[] jArr = sFrameRateList;
            int i_renamed = sFrameRateIndex;
            jArr[i_renamed] = 1000 / (jCurrentTimeMillis - j_renamed);
            sFrameRateIndex = (i_renamed + 1) % 10;
        }
        sRealTimeFrameStart = jCurrentTimeMillis;
    }

    public static void buildPerformanceData(android.content.Context context, java.lang.String str, java.lang.String str2, int i_renamed, java.lang.String str3) {
        java.lang.String str4 = sStartPointMap.get(str);
        if (android.text.TextUtils.isEmpty(str4)) {
            return;
        }
        try {
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis() - java.lang.Long.valueOf(str4).longValue();
            sStartPointMap.put(str, "");
            if (CAMERA_FOCUS_TIME.equals(str) && sFocusCosts.size() < 10) {
                sFocusCosts.add(java.lang.Long.valueOf(jCurrentTimeMillis));
                return;
            }
            com.oplus.camera.statistics.model.PerformanceMsgData performanceMsgData = new com.oplus.camera.statistics.model.PerformanceMsgData(context);
            performanceMsgData.mCameraEnterType = str2;
            performanceMsgData.mCameraId = i_renamed;
            performanceMsgData.mCaptureMode = str3;
            performanceMsgData.mEventMap.put(SCREEN_FPS, getAverageFrameRate());
            if (CAMERA_FOCUS_TIME.equals(str)) {
                performanceMsgData.mEventMap.put(str, java.lang.String.valueOf(getAverageFocusCost()));
                sFocusCosts.clear();
            } else {
                performanceMsgData.mEventMap.put(str, java.lang.String.valueOf(jCurrentTimeMillis));
            }
            performanceMsgData.report();
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            com.oplus.camera.e_renamed.f_renamed(TAG, e_renamed.getMessage());
        }
    }

    public static java.lang.String getAverageFrameRate() {
        long[] jArr = sFrameRateList;
        if (jArr == null) {
            return "-1";
        }
        long j_renamed = 0;
        for (long j2 : jArr) {
            if (0 != j2) {
                j_renamed += j2;
            }
        }
        return java.lang.String.valueOf(j_renamed / sFrameRateList.length);
    }

    private static java.lang.String getAverageFocusCost() {
        java.util.ArrayList<java.lang.Long> arrayList = sFocusCosts;
        if (arrayList == null || arrayList.size() == 0) {
            return "-1";
        }
        long jLongValue = 0;
        for (int i_renamed = 0; i_renamed < sFocusCosts.size(); i_renamed++) {
            if (sFocusCosts.get(i_renamed) != null) {
                jLongValue += sFocusCosts.get(i_renamed).longValue();
            }
        }
        return java.lang.String.valueOf(jLongValue / sFocusCosts.size());
    }
}
