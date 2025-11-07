package com.oplus.camera.statistics.model;

/* loaded from: classes2.dex */
public class PerfMonitorMsgData extends com.oplus.camera.statistics.model.DcsMsgData {
    private static final java.lang.String EVENT_PERFORMANCE = "performance";
    private static final java.lang.String KEY_CAMERA_EXIT = "cameraExit";
    private static final java.lang.String KEY_CAPTURE = "capture";
    private static final java.lang.String KEY_COMPREHENSIVE_CAPTURE = "comprehensiveCapture";
    private static final java.lang.String KEY_CONTINUOUS_CAPTURE = "continuousCapture";
    private static final java.lang.String KEY_LAUNCH = "launch";
    private static final java.lang.String KEY_PICTURE_SAVE = "pictureSave";
    private static final java.lang.String KEY_RENDER_FLUENCY = "renderFluency";
    private static final java.lang.String KEY_START_VIDEO_RECORD = "startVideoRecord";
    private static final java.lang.String KEY_SWITCH_CAMERA = "switchCamera";
    private static final java.lang.String KEY_SWITCH_MODE = "switchMode";
    private static final java.lang.String KEY_VIDEO_SAVE = "videoSave";
    private static final java.lang.String LOG_TAG_PERFORMANCE = "204";
    private static final java.lang.String TAG = "PerformanceMsgData";
    private static com.google.gson.Gson sGson = new com.google.gson.Gson();
    private java.lang.String mCameraExit;
    private java.lang.String mCapture;
    private java.lang.String mComprehensive;
    private java.lang.String mContinuousCapture;
    private java.lang.String mFluency;
    private java.lang.String mLaunch;
    private java.lang.String mPictureSave;
    private java.lang.String mStartVideoRecord;
    private java.lang.String mSwitchCamera;
    private java.lang.String mSwitchMode;
    private java.lang.String mVideoSave;

    public PerfMonitorMsgData(android.content.Context context) {
        super(context, LOG_TAG_PERFORMANCE, EVENT_PERFORMANCE);
        this.mLaunch = "";
        this.mCapture = "";
        this.mSwitchCamera = "";
        this.mSwitchMode = "";
        this.mStartVideoRecord = "";
        this.mVideoSave = "";
        this.mPictureSave = "";
        this.mCameraExit = "";
        this.mContinuousCapture = "";
        this.mComprehensive = "";
        this.mFluency = "";
    }

    public static void reportLaunch(android.content.Context context, com.oplus.camera.perf.LaunchPerformance.LaunchPerformanceData launchPerformanceData) {
        if (context == null) {
            return;
        }
        com.oplus.camera.statistics.model.PerfMonitorMsgData perfMonitorMsgData = new com.oplus.camera.statistics.model.PerfMonitorMsgData(context);
        perfMonitorMsgData.mLaunch = sGson.toJson(launchPerformanceData);
        perfMonitorMsgData.report();
    }

    public static void reportCapture(android.content.Context context, com.oplus.camera.perf.CapturePerformance.CapturePerformanceData capturePerformanceData) {
        if (context == null) {
            return;
        }
        com.oplus.camera.statistics.model.PerfMonitorMsgData perfMonitorMsgData = new com.oplus.camera.statistics.model.PerfMonitorMsgData(context);
        perfMonitorMsgData.mCapture = sGson.toJson(capturePerformanceData);
        perfMonitorMsgData.report();
    }

    public static void reportSwitchCamera(android.content.Context context, com.oplus.camera.perf.SwitchCameraPerformance.SwitchCameraPerformanceData switchCameraPerformanceData) {
        if (context == null) {
            return;
        }
        com.oplus.camera.statistics.model.PerfMonitorMsgData perfMonitorMsgData = new com.oplus.camera.statistics.model.PerfMonitorMsgData(context);
        perfMonitorMsgData.mSwitchCamera = sGson.toJson(switchCameraPerformanceData);
        perfMonitorMsgData.report();
    }

    public static void reportSwitchMode(android.content.Context context, com.oplus.camera.perf.SwitchModePerformance.SwitchModePerformanceData switchModePerformanceData) {
        if (context == null) {
            return;
        }
        com.oplus.camera.statistics.model.PerfMonitorMsgData perfMonitorMsgData = new com.oplus.camera.statistics.model.PerfMonitorMsgData(context);
        perfMonitorMsgData.mSwitchMode = sGson.toJson(switchModePerformanceData);
        perfMonitorMsgData.report();
    }

    public static void reportStartVideoRecord(android.content.Context context, com.oplus.camera.perf.VideoRecordPerformance.VideoRecordPerformanceData videoRecordPerformanceData) {
        if (context == null) {
            return;
        }
        com.oplus.camera.statistics.model.PerfMonitorMsgData perfMonitorMsgData = new com.oplus.camera.statistics.model.PerfMonitorMsgData(context);
        perfMonitorMsgData.mStartVideoRecord = sGson.toJson(videoRecordPerformanceData);
        perfMonitorMsgData.report();
    }

    public static void reportVideoSave(android.content.Context context, com.oplus.camera.perf.VideoSavePerformance.VideoSavePerformanceData videoSavePerformanceData) {
        if (context == null) {
            return;
        }
        com.oplus.camera.statistics.model.PerfMonitorMsgData perfMonitorMsgData = new com.oplus.camera.statistics.model.PerfMonitorMsgData(context);
        perfMonitorMsgData.mVideoSave = sGson.toJson(videoSavePerformanceData);
        perfMonitorMsgData.report();
    }

    public static void reportPictureSave(android.content.Context context, com.oplus.camera.perf.PictureSavePerformance.PictureSavePerformanceData pictureSavePerformanceData) {
        if (context == null) {
            return;
        }
        com.oplus.camera.statistics.model.PerfMonitorMsgData perfMonitorMsgData = new com.oplus.camera.statistics.model.PerfMonitorMsgData(context);
        perfMonitorMsgData.mPictureSave = sGson.toJson(pictureSavePerformanceData);
        perfMonitorMsgData.report();
    }

    public static void reportCameraExit(android.content.Context context, com.oplus.camera.perf.CameraExitPerformance.CameraExitPerformanceData cameraExitPerformanceData) {
        if (context == null) {
            return;
        }
        com.oplus.camera.statistics.model.PerfMonitorMsgData perfMonitorMsgData = new com.oplus.camera.statistics.model.PerfMonitorMsgData(context);
        perfMonitorMsgData.mCameraExit = sGson.toJson(cameraExitPerformanceData);
        perfMonitorMsgData.report();
    }

    public static void reportContinuousCapture(android.content.Context context, com.oplus.camera.perf.ContinuousCapturePerformance.ContinuousCapturePerformanceData continuousCapturePerformanceData) {
        if (context == null) {
            return;
        }
        com.oplus.camera.statistics.model.PerfMonitorMsgData perfMonitorMsgData = new com.oplus.camera.statistics.model.PerfMonitorMsgData(context);
        perfMonitorMsgData.mContinuousCapture = sGson.toJson(continuousCapturePerformanceData);
        perfMonitorMsgData.report();
    }

    public static void reportComprehensive(android.content.Context context, com.oplus.camera.perf.ComprehensivePerformance.PerformanceRecordData performanceRecordData) {
        if (context == null) {
            return;
        }
        com.oplus.camera.statistics.model.PerfMonitorMsgData perfMonitorMsgData = new com.oplus.camera.statistics.model.PerfMonitorMsgData(context);
        perfMonitorMsgData.mComprehensive = sGson.toJson(performanceRecordData);
        perfMonitorMsgData.report();
    }

    public static void reportFluency(android.content.Context context, com.oplus.camera.perf.FluencyPerformance.FluencyPerformanceData fluencyPerformanceData) {
        if (context == null) {
            return;
        }
        com.oplus.camera.statistics.model.PerfMonitorMsgData perfMonitorMsgData = new com.oplus.camera.statistics.model.PerfMonitorMsgData(context);
        perfMonitorMsgData.mFluency = sGson.toJson(fluencyPerformanceData);
        perfMonitorMsgData.report();
    }

    @Override // com.oplus.camera.statistics.model.DcsMsgData
    public void report() {
        checkEmptyCondition(KEY_LAUNCH, this.mLaunch);
        checkEmptyCondition(KEY_CAPTURE, this.mCapture);
        checkEmptyCondition(KEY_SWITCH_CAMERA, this.mSwitchCamera);
        checkEmptyCondition(KEY_SWITCH_MODE, this.mSwitchMode);
        checkEmptyCondition(KEY_START_VIDEO_RECORD, this.mStartVideoRecord);
        checkEmptyCondition(KEY_VIDEO_SAVE, this.mVideoSave);
        checkEmptyCondition(KEY_PICTURE_SAVE, this.mPictureSave);
        checkEmptyCondition(KEY_CAMERA_EXIT, this.mCameraExit);
        checkEmptyCondition(KEY_CONTINUOUS_CAPTURE, this.mContinuousCapture);
        checkEmptyCondition(KEY_COMPREHENSIVE_CAPTURE, this.mComprehensive);
        checkEmptyCondition(KEY_RENDER_FLUENCY, this.mFluency);
        super.report();
    }
}
