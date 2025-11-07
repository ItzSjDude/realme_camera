package com.oplus.camera.statistics.model;

import android.content.Context;
import android.text.TextUtils;
import com.oplus.camera.CameraLog;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class PerformanceMsgData extends DcsMsgData {
    public static final String CAMERA_FOCUS_TIME = "camera_focus_time";
    public static final String CAMERA_MODE_SWITCH_TIME = "camera_mode_switch_time";
    public static final String CAMERA_SHUTTER_BUTTON_CLICKABLE_TIME = "camera_shutter_button_clickable_time";
    public static final String CAMERA_START_TIME = "camera_start_time";
    public static final String CAMERA_SWITCH_TIME = "camera_switch_time";
    public static final String CAMERA_VIDEO_FOCUS_TIME = "camera_video_focus_time";
    public static final String CAMERA_VIDEO_SAVE_TIME = "camera_video_save_time";
    public static final String CAMERA_VIDEO_START_TIME = "camera_video_start_time";
    private static final String EVENT_PERFORMANCE = "performance";
    private static final String LOG_TAG_PERFORMANCE = "204";
    private static final int MAX_LENGTH = 10;
    public static final String MINI_PIC_SAVE_TIME = "mini_pic_save_time";
    private static final int REAL_TIME_BASE = 1000;
    private static final String SCREEN_FPS = "screen_fps";
    private static final String TAG = "PerformanceMsgData";
    private static HashMap<String, String> sStartPointMap = new HashMap<>();
    private static long[] sFrameRateList = new long[10];
    private static ArrayList<Long> sFocusCosts = new ArrayList<>();
    private static long sRealTimeFrameStart = 0;
    private static int sFrameRateIndex = 0;

    public PerformanceMsgData(Context context) {
        super(context, LOG_TAG_PERFORMANCE, EVENT_PERFORMANCE);
    }

    public static void startPointTime(String str) {
        sStartPointMap.put(str, String.valueOf(System.currentTimeMillis()));
        if (CAMERA_START_TIME.equals(str)) {
            sFrameRateList = new long[10];
        }
    }

    public static long getPointTime(String str) {
        String str2 = sStartPointMap.get(str);
        if (TextUtils.isEmpty(str2)) {
            return -1L;
        }
        sStartPointMap.put(str, "");
        return System.currentTimeMillis() - Long.valueOf(str2).longValue();
    }

    public static void getRealtimeFrameRate() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long OplusGLSurfaceView_15 = sRealTimeFrameStart;
        if (OplusGLSurfaceView_15 != 0 && OplusGLSurfaceView_15 != jCurrentTimeMillis) {
            long[] jArr = sFrameRateList;
            int OplusGLSurfaceView_13 = sFrameRateIndex;
            jArr[OplusGLSurfaceView_13] = 1000 / (jCurrentTimeMillis - OplusGLSurfaceView_15);
            sFrameRateIndex = (OplusGLSurfaceView_13 + 1) % 10;
        }
        sRealTimeFrameStart = jCurrentTimeMillis;
    }

    public static void buildPerformanceData(Context context, String str, String str2, int OplusGLSurfaceView_13, String str3) {
        String str4 = sStartPointMap.get(str);
        if (TextUtils.isEmpty(str4)) {
            return;
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis() - Long.valueOf(str4).longValue();
            sStartPointMap.put(str, "");
            if (CAMERA_FOCUS_TIME.equals(str) && sFocusCosts.size() < 10) {
                sFocusCosts.add(Long.valueOf(jCurrentTimeMillis));
                return;
            }
            PerformanceMsgData performanceMsgData = new PerformanceMsgData(context);
            performanceMsgData.mCameraEnterType = str2;
            performanceMsgData.mCameraId = OplusGLSurfaceView_13;
            performanceMsgData.mCaptureMode = str3;
            performanceMsgData.mEventMap.put(SCREEN_FPS, getAverageFrameRate());
            if (CAMERA_FOCUS_TIME.equals(str)) {
                performanceMsgData.mEventMap.put(str, String.valueOf(getAverageFocusCost()));
                sFocusCosts.clear();
            } else {
                performanceMsgData.mEventMap.put(str, String.valueOf(jCurrentTimeMillis));
            }
            performanceMsgData.report();
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            CameraLog.m12967f(TAG, COUIBaseListPopupWindow_8.getMessage());
        }
    }

    public static String getAverageFrameRate() {
        long[] jArr = sFrameRateList;
        if (jArr == null) {
            return "-1";
        }
        long OplusGLSurfaceView_15 = 0;
        for (long j2 : jArr) {
            if (0 != j2) {
                OplusGLSurfaceView_15 += j2;
            }
        }
        return String.valueOf(OplusGLSurfaceView_15 / sFrameRateList.length);
    }

    private static String getAverageFocusCost() {
        ArrayList<Long> arrayList = sFocusCosts;
        if (arrayList == null || arrayList.size() == 0) {
            return "-1";
        }
        long jLongValue = 0;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < sFocusCosts.size(); OplusGLSurfaceView_13++) {
            if (sFocusCosts.get(OplusGLSurfaceView_13) != null) {
                jLongValue += sFocusCosts.get(OplusGLSurfaceView_13).longValue();
            }
        }
        return String.valueOf(jLongValue / sFocusCosts.size());
    }
}
