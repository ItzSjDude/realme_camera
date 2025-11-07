package com.oplus.camera.statistics.model;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes2.dex */
public class EnterExitDcsMsgData extends DcsMsgData {
    public static final String ALWAYS_ON_SHOT = "always_on_shot";
    public static final String AUTO_FOCUS = "auto_focus";
    public static final String EVENT_AGREEMENT = "agreement";
    public static final String EVENT_ENTER = "enter";
    public static final String EVENT_EXIT = "exit";
    public static final String EVENT_PERMISSION = "permission";
    public static final String EVENT_PERMISSION_STATUS = "permission_status";
    public static final String EVENT_STATEMENT = "statement";
    public static final String IS_GESTURE_CAPTURE_TYPE = "is_gesture_capture_type";
    public static final String IS_MIRROR = "is_mirror";
    public static final String IS_SCAN_CODE = "is_scan_code";
    public static final String IS_SMOOTH_ZOOM = "is_smooth_zoom";
    public static final String IS_TAP_CAPTURE_TYPE = "is_tap_capture_type";
    private static final String KEY_ENTER_CALLER_PACKAGE = "enter_caller_package";
    private static final String KEY_ENTER_CAMERA_ENTER_TIME_GAP = "camera_enter_time_gap";
    private static final String KEY_ENTER_TEMPERATURE = "enter_temperature";
    private static final String KEY_EXIT_CALLER_PACKAGE = "exit_caller_package";
    private static final String KEY_EXIT_RESUME_PAUSE_DURATION_TIME = "resume_pause_time";
    private static final String KEY_EXIT_RESUME_PAUSE_VIDEO_TIME = "resume_pause_video_time";
    private static final String KEY_EXIT_TO_GALLERY = "to_gallery";
    public static final String KEY_EXT_MODE_ORDER = "ext_mode_order";
    private static final String KEY_IS_CAMERA = "is_camera";
    private static final String KEY_IS_IMEI = "is_imei";
    private static final String KEY_IS_LOCATION = "is_location";
    private static final String KEY_IS_RECORDER = "is_recorder";
    private static final String KEY_IS_STORAGE = "is_storage";
    public static final String KEY_MORE_MODE_ORDER = "more_mode_order";
    private static final String KEY_RESULT = "result";
    private static final String KEY_STATEMENT_TYPE = "statement_type";
    private static final String KEY_TIMING = "timing";
    private static final String LOCK_SUB_FIX = "LOCK";
    public static final String LOGTAG_ENTER = "201";
    public static final String PERMISSION_DISAGREE = "disagree_stop_ask";
    public static final String PERMISSION_NA = "na";
    public static final String PERMISSION_OFF = "off";
    public static final String PERMISSION_ON = "on";
    public static final String QUICK_TAKE = "quick_take";
    public static final String RESULT_AGREE = "agree";
    public static final String RESULT_CANCEL = "cancel";
    public static final String RESULT_EXIT = "exit";
    public static final String RESULT_SETTING = "setting";
    private static final String SEPARATOR = "_";
    public static final String SHARE_AND_EDIT = "share_and_edit";
    public static final String STATEMENT_TYPE_NETWORK = "network";
    public static final String STATEMENT_TYPE_PRIVACY = "privacy";
    private static final String TAG = "EnterExitDcsMsgData";
    public static final String TIMING_OPEN_CAMERA = "start_oplus_camera";
    public static final String TIMING_SETTING_LOCATION = "setting_location";
    public static final String TIMING_SETTING_LOCATION_SLOGAN = "setting_location_slogan";
    public static final String TIMING_VIDEO_RECORD = "video_record";
    public String mAlwaysOnShot;
    public String mAutoFocus;
    public long mCameraEnterTimeGap;
    public String mCameraGranted;
    public String mCameraPermission;
    public String mEnterCallPackage;
    public float mEnterTemperature;
    public String mExitCallPackage;
    public String mExtModeOrder;
    public String mImeiGranted;
    public String mImeiPermission;
    public String mIsGestureCaptureType;
    public String mIsMirror;
    public String mIsScanCode;
    public String mIsSmoothZoom;
    public String mIsTapCaptureType;
    public String mLocationGranted;
    public String mLocationPermission;
    public String mMoreModeOrder;
    public String mQuickTake;
    public String mRecorderGranted;
    public String mRecorderPermission;
    public String mResult;
    public long mResumePauseTime;
    public long mResumePauseVideoTime;
    public String mShareAndEdit;
    public String mShortcutType;
    public String mStatementType;
    public String mStorageGranted;
    public String mStoragePermission;
    public String mTiming;
    public boolean mbCamera;
    public boolean mbFromLock;
    public boolean mbImei;
    public boolean mbLocation;
    public boolean mbRecorder;
    public boolean mbStorage;
    public boolean mbToGallery;

    public EnterExitDcsMsgData(Context context, String str) {
        super(context, LOGTAG_ENTER, str);
        this.mEnterCallPackage = "";
        this.mExitCallPackage = "";
        this.mCameraEnterTimeGap = 0L;
        this.mShortcutType = "";
        this.mbToGallery = false;
        this.mbFromLock = false;
        this.mResumePauseTime = 0L;
        this.mResumePauseVideoTime = 0L;
        this.mEnterTemperature = -1.0f;
        this.mStatementType = "";
        this.mResult = "";
        this.mLocationPermission = PERMISSION_NA;
        this.mCameraPermission = PERMISSION_NA;
        this.mImeiPermission = PERMISSION_NA;
        this.mStoragePermission = PERMISSION_NA;
        this.mRecorderPermission = PERMISSION_NA;
        this.mTiming = "";
        this.mbLocation = false;
        this.mbCamera = false;
        this.mbImei = false;
        this.mbStorage = false;
        this.mbRecorder = false;
        this.mLocationGranted = null;
        this.mCameraGranted = null;
        this.mImeiGranted = null;
        this.mStorageGranted = null;
        this.mRecorderGranted = null;
        this.mIsMirror = "";
        this.mAutoFocus = "";
        this.mAlwaysOnShot = "";
        this.mShareAndEdit = "";
        this.mIsTapCaptureType = "";
        this.mIsGestureCaptureType = "";
        this.mQuickTake = "";
        this.mIsScanCode = "";
        this.mIsSmoothZoom = "";
        this.mExtModeOrder = "";
        this.mMoreModeOrder = "";
    }

    @Override // com.oplus.camera.statistics.model.DcsMsgData
    public void report() {
        if (!TextUtils.isEmpty(this.mEnterCallPackage)) {
            String str = this.mEnterCallPackage;
            if (this.mbFromLock) {
                str = str + "_LOCK";
            } else if (!TextUtils.isEmpty(this.mShortcutType)) {
                str = str + SEPARATOR + this.mShortcutType;
            }
            this.mEventMap.put(KEY_ENTER_CALLER_PACKAGE, str);
        }
        if (!TextUtils.isEmpty(this.mExitCallPackage)) {
            String str2 = this.mExitCallPackage;
            if (this.mbFromLock) {
                str2 = str2 + "_LOCK";
            } else if (!TextUtils.isEmpty(this.mShortcutType)) {
                str2 = str2 + SEPARATOR + this.mShortcutType;
            }
            this.mEventMap.put(KEY_EXIT_CALLER_PACKAGE, str2);
        }
        if (this.mCameraEnterTimeGap > 0 && "enter".equals(this.mEventId)) {
            this.mEventMap.put("camera_enter_time_gap", String.valueOf(this.mCameraEnterTimeGap));
        }
        if (this.mResumePauseTime > 0 && "exit".equals(this.mEventId)) {
            this.mEventMap.put("resume_pause_time", String.valueOf(this.mResumePauseTime));
        }
        if (this.mResumePauseVideoTime > 0 && "exit".equals(this.mEventId)) {
            this.mEventMap.put("resume_pause_video_time", String.valueOf(this.mResumePauseVideoTime));
        }
        if ("exit".equals(this.mEventId)) {
            this.mEventMap.put("to_gallery", String.valueOf(this.mbToGallery));
        }
        if ("enter".equals(this.mEventId)) {
            this.mEventMap.put(KEY_ENTER_TEMPERATURE, String.valueOf(this.mEnterTemperature));
        }
        if (EVENT_STATEMENT.equals(this.mEventId)) {
            checkEmptyCondition(KEY_STATEMENT_TYPE, this.mStatementType);
            checkEmptyCondition(KEY_RESULT, this.mResult);
        }
        if (EVENT_PERMISSION.equals(this.mEventId)) {
            checkEmptyCondition(KEY_IS_LOCATION, this.mLocationPermission);
            checkEmptyCondition(KEY_IS_CAMERA, this.mCameraPermission);
            checkEmptyCondition(KEY_IS_IMEI, this.mImeiPermission);
            checkEmptyCondition(KEY_IS_STORAGE, this.mStoragePermission);
            checkEmptyCondition(KEY_IS_RECORDER, this.mRecorderPermission);
            checkEmptyCondition(KEY_TIMING, this.mTiming);
        }
        if (EVENT_AGREEMENT.equals(this.mEventId)) {
            checkEmptyCondition(KEY_IS_LOCATION, String.valueOf(this.mbLocation));
            checkEmptyCondition(KEY_IS_CAMERA, String.valueOf(this.mbCamera));
            checkEmptyCondition(KEY_IS_IMEI, String.valueOf(this.mbImei));
            checkEmptyCondition(KEY_IS_STORAGE, String.valueOf(this.mbStorage));
            checkEmptyCondition(KEY_IS_RECORDER, String.valueOf(this.mbRecorder));
            checkEmptyCondition(KEY_RESULT, this.mResult);
            checkEmptyCondition(KEY_TIMING, this.mTiming);
        }
        if (EVENT_PERMISSION_STATUS.equals(this.mEventId)) {
            checkEmptyCondition(KEY_IS_LOCATION, this.mLocationGranted);
            checkEmptyCondition(KEY_IS_CAMERA, this.mCameraGranted);
            checkEmptyCondition(KEY_IS_IMEI, this.mImeiGranted);
            checkEmptyCondition(KEY_IS_STORAGE, this.mStorageGranted);
            checkEmptyCondition(KEY_IS_RECORDER, this.mRecorderGranted);
            checkEmptyCondition(IS_MIRROR, this.mIsMirror);
            checkEmptyCondition(AUTO_FOCUS, this.mAutoFocus);
            checkEmptyCondition(ALWAYS_ON_SHOT, this.mAlwaysOnShot);
            checkEmptyCondition(SHARE_AND_EDIT, this.mShareAndEdit);
            checkEmptyCondition(IS_TAP_CAPTURE_TYPE, this.mIsTapCaptureType);
            checkEmptyCondition(IS_GESTURE_CAPTURE_TYPE, this.mIsGestureCaptureType);
            checkEmptyCondition(QUICK_TAKE, this.mQuickTake);
            checkEmptyCondition(IS_SCAN_CODE, this.mIsScanCode);
            checkEmptyCondition(IS_SMOOTH_ZOOM, this.mIsSmoothZoom);
            checkEmptyCondition(KEY_EXT_MODE_ORDER, this.mExtModeOrder);
            checkEmptyCondition(KEY_MORE_MODE_ORDER, this.mMoreModeOrder);
        }
        super.report();
    }
}
