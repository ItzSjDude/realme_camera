package com.oplus.camera.statistics.model;

import android.content.Context;
import com.google.gson.Gson;
import com.oplus.camera.perf.CameraExitPerformance;
import com.oplus.camera.perf.CapturePerformance;
import com.oplus.camera.perf.ComprehensivePerformance;
import com.oplus.camera.perf.ContinuousCapturePerformance;
import com.oplus.camera.perf.FluencyPerformance;
import com.oplus.camera.perf.LaunchPerformance;
import com.oplus.camera.perf.PictureSavePerformance;
import com.oplus.camera.perf.SwitchCameraPerformance;
import com.oplus.camera.perf.SwitchModePerformance;
import com.oplus.camera.perf.VideoRecordPerformance;
import com.oplus.camera.perf.VideoSavePerformance;

/* loaded from: classes2.dex */
public class PerfMonitorMsgData extends DcsMsgData {
    private static final String EVENT_PERFORMANCE = "performance";
    private static final String KEY_CAMERA_EXIT = "cameraExit";
    private static final String KEY_CAPTURE = "capture";
    private static final String KEY_COMPREHENSIVE_CAPTURE = "comprehensiveCapture";
    private static final String KEY_CONTINUOUS_CAPTURE = "continuousCapture";
    private static final String KEY_LAUNCH = "launch";
    private static final String KEY_PICTURE_SAVE = "pictureSave";
    private static final String KEY_RENDER_FLUENCY = "renderFluency";
    private static final String KEY_START_VIDEO_RECORD = "startVideoRecord";
    private static final String KEY_SWITCH_CAMERA = "switchCamera";
    private static final String KEY_SWITCH_MODE = "switchMode";
    private static final String KEY_VIDEO_SAVE = "videoSave";
    private static final String LOG_TAG_PERFORMANCE = "204";
    private static final String TAG = "PerformanceMsgData";
    private static Gson sGson = new Gson();
    private String mCameraExit;
    private String mCapture;
    private String mComprehensive;
    private String mContinuousCapture;
    private String mFluency;
    private String mLaunch;
    private String mPictureSave;
    private String mStartVideoRecord;
    private String mSwitchCamera;
    private String mSwitchMode;
    private String mVideoSave;

    public PerfMonitorMsgData(Context context) {
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

    public static void reportLaunch(Context context, LaunchPerformance.LaunchPerformanceData launchPerformanceData) {
        if (context == null) {
            return;
        }
        PerfMonitorMsgData perfMonitorMsgData = new PerfMonitorMsgData(context);
        perfMonitorMsgData.mLaunch = sGson.toJson(launchPerformanceData);
        perfMonitorMsgData.report();
    }

    public static void reportCapture(Context context, CapturePerformance.CapturePerformanceData capturePerformanceData) {
        if (context == null) {
            return;
        }
        PerfMonitorMsgData perfMonitorMsgData = new PerfMonitorMsgData(context);
        perfMonitorMsgData.mCapture = sGson.toJson(capturePerformanceData);
        perfMonitorMsgData.report();
    }

    public static void reportSwitchCamera(Context context, SwitchCameraPerformance.SwitchCameraPerformanceData switchCameraPerformanceData) {
        if (context == null) {
            return;
        }
        PerfMonitorMsgData perfMonitorMsgData = new PerfMonitorMsgData(context);
        perfMonitorMsgData.mSwitchCamera = sGson.toJson(switchCameraPerformanceData);
        perfMonitorMsgData.report();
    }

    public static void reportSwitchMode(Context context, SwitchModePerformance.SwitchModePerformanceData switchModePerformanceData) {
        if (context == null) {
            return;
        }
        PerfMonitorMsgData perfMonitorMsgData = new PerfMonitorMsgData(context);
        perfMonitorMsgData.mSwitchMode = sGson.toJson(switchModePerformanceData);
        perfMonitorMsgData.report();
    }

    public static void reportStartVideoRecord(Context context, VideoRecordPerformance.VideoRecordPerformanceData videoRecordPerformanceData) {
        if (context == null) {
            return;
        }
        PerfMonitorMsgData perfMonitorMsgData = new PerfMonitorMsgData(context);
        perfMonitorMsgData.mStartVideoRecord = sGson.toJson(videoRecordPerformanceData);
        perfMonitorMsgData.report();
    }

    public static void reportVideoSave(Context context, VideoSavePerformance.VideoSavePerformanceData videoSavePerformanceData) {
        if (context == null) {
            return;
        }
        PerfMonitorMsgData perfMonitorMsgData = new PerfMonitorMsgData(context);
        perfMonitorMsgData.mVideoSave = sGson.toJson(videoSavePerformanceData);
        perfMonitorMsgData.report();
    }

    public static void reportPictureSave(Context context, PictureSavePerformance.PictureSavePerformanceData pictureSavePerformanceData) {
        if (context == null) {
            return;
        }
        PerfMonitorMsgData perfMonitorMsgData = new PerfMonitorMsgData(context);
        perfMonitorMsgData.mPictureSave = sGson.toJson(pictureSavePerformanceData);
        perfMonitorMsgData.report();
    }

    public static void reportCameraExit(Context context, CameraExitPerformance.CameraExitPerformanceData cameraExitPerformanceData) {
        if (context == null) {
            return;
        }
        PerfMonitorMsgData perfMonitorMsgData = new PerfMonitorMsgData(context);
        perfMonitorMsgData.mCameraExit = sGson.toJson(cameraExitPerformanceData);
        perfMonitorMsgData.report();
    }

    public static void reportContinuousCapture(Context context, ContinuousCapturePerformance.ContinuousCapturePerformanceData continuousCapturePerformanceData) {
        if (context == null) {
            return;
        }
        PerfMonitorMsgData perfMonitorMsgData = new PerfMonitorMsgData(context);
        perfMonitorMsgData.mContinuousCapture = sGson.toJson(continuousCapturePerformanceData);
        perfMonitorMsgData.report();
    }

    public static void reportComprehensive(Context context, ComprehensivePerformance.PerformanceRecordData performanceRecordData) {
        if (context == null) {
            return;
        }
        PerfMonitorMsgData perfMonitorMsgData = new PerfMonitorMsgData(context);
        perfMonitorMsgData.mComprehensive = sGson.toJson(performanceRecordData);
        perfMonitorMsgData.report();
    }

    public static void reportFluency(Context context, FluencyPerformance.FluencyPerformanceData fluencyPerformanceData) {
        if (context == null) {
            return;
        }
        PerfMonitorMsgData perfMonitorMsgData = new PerfMonitorMsgData(context);
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
