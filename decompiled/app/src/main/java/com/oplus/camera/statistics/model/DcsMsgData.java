package com.oplus.camera.statistics.model;

/* loaded from: classes2.dex */
public abstract class DcsMsgData {
    public static final int CAPTURE_TYPE = 0;
    public static final int CONDITION_FACE_JAW = -51;
    public static final int CONDITION_NAGATIVE_ONE = -1;
    public static final int CONDITION_ZERO = 0;
    private static boolean DEBUG = false;
    public static final java.lang.String DIVIDER = "|";
    public static final java.lang.String FRONT = "front";
    public static final java.lang.String FRONT_INNER = "front_inner";
    public static final java.lang.String FULL = "full";
    public static final java.lang.String INNER = "inner";
    public static final int KB_IN_BYTES = 1024;
    private static final java.lang.String KEY_ANC_FILTER_TYPE = "microscope_type";
    private static final java.lang.String KEY_BLUR_LEVEL = "blur_level";
    protected static final java.lang.String KEY_CAMERA_ID = "camera_id";
    protected static final java.lang.String KEY_CAPTURE_MODE = "capture_mode";
    private static final java.lang.String KEY_CHIP_STATUS = "chip_status";
    private static final java.lang.String KEY_CLIENT_TIMESTAMP = "client_timestamp";
    private static final java.lang.String KEY_ENTER_TIMESTAMP = "enter_timestamp";
    private static final java.lang.String KEY_ENTER_TYPE = "enter_type";
    private static final java.lang.String KEY_FILTER_TYPE = "filter_type";
    private static final java.lang.String KEY_FLASH_MODE = "flash_mode";
    private static final java.lang.String KEY_FLASH_TRIGGER = "flash_trigger";
    private static final java.lang.String KEY_FOLD_TYPE = "fold_type";
    protected static final java.lang.String KEY_HIGH_BRIGHTNESS = "screen_highlight";
    private static final java.lang.String KEY_IS_MIRROR = "is_mirror";
    protected static final java.lang.String KEY_MAGNETIC_SHELL_FUNC_STATUS = "is_phone_case_light";
    public static final java.lang.String KEY_MAKEUP_DREAM = "makeup_wishing_star";
    public static final java.lang.String KEY_MAKEUP_FIRST_LOVE = "makeup_first_love";
    public static final java.lang.String KEY_MAKEUP_GROOMED = "makeup_groomed";
    public static final java.lang.String KEY_MAKEUP_MIDNIGHT = "makeup_midnight";
    public static final java.lang.String KEY_MAKEUP_NONE = "makeup_type_none";
    public static final java.lang.String KEY_MAKEUP_ORANGE_CRUSH = "makeup_orange_crush";
    public static final java.lang.String KEY_MAKEUP_PEACH_PINK = "makeup_peach_pink";
    public static final java.lang.String KEY_MAKEUP_RED_VELVET = "makeup_red_velvet";
    public static final java.lang.String KEY_MAKEUP_ROSY_NUDE = "makeup_rosy_nude";
    public static final java.lang.String KEY_MAKEUP_SMOKEY = "makeup_smokey";
    public static final java.lang.String KEY_MAKEUP_SNOW = "makeup_twilight_snow";
    public static final java.lang.String KEY_MAKEUP_SPARKLING_SEA = "makeup_sparkling_sea";
    public static final java.lang.String KEY_MAKEUP_TYPE = "makeup_type";
    public static final java.lang.String KEY_MAKEUP_UNIQUE_EYES = "makeup_unique_eyes";
    public static final java.lang.String KEY_MAKEUP_VALUE = "makeup_value";
    public static final java.lang.String KEY_MAKEUP_VIOLET_SHIMMER = "makeup_violet_shimmer";
    private static final java.lang.String KEY_NIGHT_STYLE_TYPE = "night_style_type";
    protected static final java.lang.String KEY_ORIENTATION = "orientation";
    private static final java.lang.String KEY_PORTRAIT_NEW_STYLE_TYPE = "portrait_new_style_type";
    private static final java.lang.String KEY_REAR_FRONT = "rear_front";
    protected static final java.lang.String KEY_SCREEN_BRIGHTNESS = "screen_brightness";
    private static final java.lang.String KEY_SCREEN_PATTERN = "screen_pattern";
    private static final java.lang.String KEY_SCREEN_TYPE = "screen_type";
    private static final java.lang.String KEY_SECOND_SCREEN_STATUS = "second_screen_status";
    public static final java.lang.String KEY_SMOOTH_CUBE = "self_smooth_cube";
    public static final java.lang.String KEY_SMOOTH_DERMABRASION = "self_smooth_dermabrasion";
    public static final java.lang.String KEY_SMOOTH_EYE_BIG = "self_smooth_eye_big";
    public static final java.lang.String KEY_SMOOTH_FACE_JAW = "self_smooth_face_jaw";
    public static final java.lang.String KEY_SMOOTH_FACE_LEAN = "self_smooth_face_lean";
    public static final java.lang.String KEY_SMOOTH_FACE_SMALL = "self_smooth_face_small";
    public static final java.lang.String KEY_SMOOTH_FRESHEN_UP = "self_smooth_freshen_up";
    public static final java.lang.String KEY_SMOOTH_NOSE_LEAN = "self_smooth_nose_lean";
    private static final java.lang.String KEY_SMOOTH_VALUE = "smooth_value";
    protected static final java.lang.String KEY_SUBSCREEN_VALUE = "subscreen_value";
    private static final java.lang.String KEY_VERSION_DATE = "version_date";
    protected static final java.lang.String KEY_ZOOM_VALUE = "zoom_value";
    public static final java.lang.String LOGTAG_CAPTURE = "200";
    protected static final java.lang.String LOGTAG_QRCODE = "206";
    protected static final java.lang.String LOGTAG_STICKER = "205";
    protected static final java.lang.String LOGTAG_UPGRADE = "204";
    public static final java.lang.String LOGTAG_VIDEO = "202";
    public static final java.lang.String OFF = "off";
    public static final java.lang.String ON_renamed = "on_renamed";
    public static final java.lang.String OUTER = "outer";
    public static final java.lang.String REAR = "rear";
    public static final int SECOND_SCREEN_CAPTURE = 1;
    public static final int SECOND_SCREEN_CLOSE = 0;
    public static final int SECOND_SCREEN_PREVIEW = 2;
    private static final int SESSION_TIME_OUT = 10;
    public static final java.lang.String SHUTTER_MODE_DONE = "end";
    public static final java.lang.String SPLIT = "split";
    public static final int STICKER_TYPE = 2;
    protected static final java.lang.String TAG = "DcsMsgData";
    private static final java.lang.String VERSION_DATE = "20190823";
    public static final int VIDEO_TYPE = 1;
    public static java.util.List<java.lang.String> sKeyMakeupList;
    public java.lang.String mAncFilterType;
    public int mBlurLevel;
    public java.lang.String mCameraEnterTimeStamp;
    public java.lang.String mCameraEnterType;
    public int mCameraId;
    public java.lang.String mCaptureMode;
    public int mCaptureType;
    public int mChipStatus;
    public java.lang.String mClientTimeStamp;
    private android.content.Context mContext;
    public java.lang.String mEventId;
    protected java.util.HashMap<java.lang.String, java.lang.String> mEventMap;
    public java.lang.String mFilterType;
    public java.lang.String mFlashMode;
    public java.lang.String mFlashTrigger;
    public int mFoldType;
    public java.lang.String mIsMirror;
    public java.lang.String mLogTag;
    public java.lang.String mMagneticShellStatus;
    public java.lang.String mMakeupType;
    public int mMakeupValue;
    public java.lang.String mNightStyleType;
    public int mOrientation;
    public java.lang.String mPortraitNewStyleType;
    public java.lang.String mRearOrFront;
    public int mScreenBrightness;
    public java.lang.String mScreenHighLight;
    public java.lang.String mScreenPattern;
    public java.lang.String mScreenType;
    public int mSecondScreenStatus;
    public int mSmooth;
    public int mSmoothCube;
    public int mSmoothDermabrasion;
    public int mSmoothEyeBig;
    public int mSmoothFaceJaw;
    public int mSmoothFaceLean;
    public int mSmoothFaceSmall;
    public int mSmoothFreshenUp;
    public int mSmoothNoseLean;
    public java.lang.String mZoomValue;

    static {
        try {
            DEBUG = com.oplus.compat.os.SystemPropertiesNative.getBoolean("persist.sys.assert.panic", false);
        } catch (com.oplus.compat.b_renamed.a_renamed.b_renamed e_renamed) {
            e_renamed.printStackTrace();
        }
        sKeyMakeupList = new java.util.ArrayList();
    }

    public static void initMakeupList() {
        if (sKeyMakeupList.size() != 0) {
            return;
        }
        sKeyMakeupList.add(KEY_MAKEUP_NONE);
        sKeyMakeupList.add(KEY_MAKEUP_ROSY_NUDE);
        sKeyMakeupList.add(KEY_MAKEUP_ORANGE_CRUSH);
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_CUSTOM_MAKEUP_TYPE_SNOW)) {
            sKeyMakeupList.add(KEY_MAKEUP_SNOW);
        }
        sKeyMakeupList.add(KEY_MAKEUP_FIRST_LOVE);
        sKeyMakeupList.add(KEY_MAKEUP_PEACH_PINK);
        sKeyMakeupList.add(KEY_MAKEUP_RED_VELVET);
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_CUSTOM_MAKEUP_TYPE_DREAM)) {
            sKeyMakeupList.add(KEY_MAKEUP_DREAM);
        }
        sKeyMakeupList.add(KEY_MAKEUP_SPARKLING_SEA);
        sKeyMakeupList.add(KEY_MAKEUP_UNIQUE_EYES);
        sKeyMakeupList.add(KEY_MAKEUP_MIDNIGHT);
        sKeyMakeupList.add(KEY_MAKEUP_VIOLET_SHIMMER);
        sKeyMakeupList.add(KEY_MAKEUP_SMOKEY);
        sKeyMakeupList.add(KEY_MAKEUP_GROOMED);
    }

    public DcsMsgData(android.content.Context context, java.lang.String str, java.lang.String str2) {
        this.mEventMap = null;
        this.mEventId = null;
        this.mLogTag = null;
        this.mCaptureMode = null;
        this.mCameraId = -1;
        this.mOrientation = -1;
        this.mCaptureType = 0;
        this.mScreenBrightness = -1;
        this.mSmooth = -1;
        this.mFlashTrigger = "";
        this.mFilterType = "";
        this.mAncFilterType = "";
        this.mIsMirror = "";
        this.mPortraitNewStyleType = "";
        this.mNightStyleType = "";
        this.mFlashMode = "";
        this.mBlurLevel = 0;
        this.mZoomValue = "";
        this.mCameraEnterTimeStamp = java.lang.String.valueOf(com.oplus.camera.entry.b_renamed.o_renamed());
        this.mCameraEnterType = java.lang.String.valueOf(1);
        this.mClientTimeStamp = java.lang.String.valueOf(java.lang.System.currentTimeMillis());
        this.mRearOrFront = "";
        this.mScreenHighLight = "";
        this.mMagneticShellStatus = "";
        this.mFoldType = -1;
        this.mScreenType = "";
        this.mScreenPattern = "";
        this.mSecondScreenStatus = -1;
        this.mChipStatus = -1;
        this.mSmoothDermabrasion = -1;
        this.mSmoothFaceLean = -1;
        this.mSmoothFaceSmall = -1;
        this.mSmoothFaceJaw = -51;
        this.mSmoothEyeBig = -1;
        this.mSmoothNoseLean = -1;
        this.mSmoothFreshenUp = -1;
        this.mSmoothCube = -1;
        this.mMakeupType = "";
        this.mMakeupValue = -1;
        this.mContext = context;
        this.mLogTag = str;
        this.mEventId = str2;
        if (DEBUG) {
            this.mEventMap = new java.util.LinkedHashMap();
        } else {
            this.mEventMap = new java.util.HashMap<>();
        }
    }

    public DcsMsgData(android.content.Context context, java.lang.String str) {
        this.mEventMap = null;
        this.mEventId = null;
        this.mLogTag = null;
        this.mCaptureMode = null;
        this.mCameraId = -1;
        this.mOrientation = -1;
        this.mCaptureType = 0;
        this.mScreenBrightness = -1;
        this.mSmooth = -1;
        this.mFlashTrigger = "";
        this.mFilterType = "";
        this.mAncFilterType = "";
        this.mIsMirror = "";
        this.mPortraitNewStyleType = "";
        this.mNightStyleType = "";
        this.mFlashMode = "";
        this.mBlurLevel = 0;
        this.mZoomValue = "";
        this.mCameraEnterTimeStamp = java.lang.String.valueOf(com.oplus.camera.entry.b_renamed.o_renamed());
        this.mCameraEnterType = java.lang.String.valueOf(1);
        this.mClientTimeStamp = java.lang.String.valueOf(java.lang.System.currentTimeMillis());
        this.mRearOrFront = "";
        this.mScreenHighLight = "";
        this.mMagneticShellStatus = "";
        this.mFoldType = -1;
        this.mScreenType = "";
        this.mScreenPattern = "";
        this.mSecondScreenStatus = -1;
        this.mChipStatus = -1;
        this.mSmoothDermabrasion = -1;
        this.mSmoothFaceLean = -1;
        this.mSmoothFaceSmall = -1;
        this.mSmoothFaceJaw = -51;
        this.mSmoothEyeBig = -1;
        this.mSmoothNoseLean = -1;
        this.mSmoothFreshenUp = -1;
        this.mSmoothCube = -1;
        this.mMakeupType = "";
        this.mMakeupValue = -1;
        this.mContext = context;
        this.mEventId = str;
        if (DEBUG) {
            this.mEventMap = new java.util.LinkedHashMap();
        } else {
            this.mEventMap = new java.util.HashMap<>();
        }
    }

    public static void init(android.content.Context context) {
        if (com.oplus.camera.util.Util.ae_renamed()) {
            com.oplus.camera.e_renamed.b_renamed(TAG, "init, monkey is_renamed running do not init");
            return;
        }
        com.oplus.camera.statistics.CameraStatisticsUtil.init(context);
        com.oplus.camera.statistics.CameraStatisticsUtil.onError(context);
        com.oplus.camera.statistics.CameraStatisticsUtil.onDebug(context, DEBUG);
        com.oplus.camera.statistics.CameraStatisticsUtil.setSessionTimeOut(context, 10);
    }

    public void parseFaceBeauty(int[] iArr) {
        if (iArr == null) {
            return;
        }
        try {
            this.mSmoothDermabrasion = iArr[0];
            this.mSmoothFaceLean = iArr[1];
            this.mSmoothEyeBig = iArr[2];
            this.mSmoothNoseLean = iArr[3];
            this.mSmoothFaceJaw = iArr[4];
            this.mSmoothFaceSmall = iArr[5];
            this.mSmoothFreshenUp = iArr[6];
            this.mSmoothCube = iArr[7];
        } catch (java.lang.IndexOutOfBoundsException e_renamed) {
            e_renamed.printStackTrace();
        }
    }

    public void report() {
        beforeReport();
        if (isValid()) {
            checkGreatCondition("blur_level", this.mBlurLevel, 0);
            checkGreatCondition("camera_id", this.mCameraId, -1);
            checkEmptyCondition("capture_mode", this.mCaptureMode);
            checkEmptyCondition(KEY_CLIENT_TIMESTAMP, this.mClientTimeStamp);
            checkEmptyCondition(KEY_ENTER_TIMESTAMP, this.mCameraEnterTimeStamp);
            checkEmptyCondition(KEY_ENTER_TYPE, this.mCameraEnterType);
            checkEmptyCondition("filter_type", this.mFilterType);
            checkEmptyCondition(KEY_ANC_FILTER_TYPE, this.mAncFilterType);
            checkEmptyCondition(KEY_FLASH_MODE, this.mFlashMode);
            checkEmptyCondition(KEY_FLASH_TRIGGER, this.mFlashTrigger);
            checkEmptyCondition("is_mirror", this.mIsMirror);
            checkGreatCondition("orientation", this.mOrientation, -1);
            checkEmptyCondition("portrait_new_style_type", this.mPortraitNewStyleType);
            checkEmptyCondition(KEY_NIGHT_STYLE_TYPE, this.mNightStyleType);
            checkGreatCondition("screen_brightness", this.mScreenBrightness, 0);
            checkGreatCondition(KEY_SMOOTH_VALUE, this.mSmooth, -1);
            checkEmptyCondition(KEY_VERSION_DATE, VERSION_DATE);
            checkEmptyCondition(KEY_ZOOM_VALUE, this.mZoomValue);
            checkEmptyCondition(KEY_REAR_FRONT, this.mRearOrFront);
            checkEmptyCondition(KEY_HIGH_BRIGHTNESS, this.mScreenHighLight);
            checkEmptyCondition(KEY_MAKEUP_TYPE, this.mMakeupType);
            checkGreatCondition(KEY_MAKEUP_VALUE, this.mMakeupValue, -1);
            checkEmptyCondition(KEY_MAGNETIC_SHELL_FUNC_STATUS, this.mMagneticShellStatus);
            checkGreatCondition(KEY_FOLD_TYPE, this.mFoldType, 0);
            checkEmptyCondition(KEY_SCREEN_TYPE, this.mScreenType);
            checkEmptyCondition(KEY_SCREEN_PATTERN, this.mScreenPattern);
            checkGreatCondition(KEY_SECOND_SCREEN_STATUS, this.mSecondScreenStatus, -1);
            checkGreatCondition(KEY_CHIP_STATUS, this.mChipStatus, -1);
            if (DEBUG) {
                com.oplus.camera.e_renamed.b_renamed(TAG, "report, mLogTag: " + this.mLogTag + ", mEventId: " + this.mEventId);
            }
            android.content.Context context = this.mContext;
            if (context != null) {
                com.oplus.statistics.d_renamed.onCommon(context, this.mLogTag, this.mEventId, this.mEventMap);
            }
        }
    }

    protected void beforeReport() {
        com.oplus.camera.statistics.DcsUtil.fillScreenStatus(this);
    }

    public boolean isValid() {
        if (!com.oplus.camera.util.Util.ae_renamed()) {
            return (android.text.TextUtils.isEmpty(this.mLogTag) && android.text.TextUtils.isEmpty(this.mEventId)) ? false : true;
        }
        com.oplus.camera.e_renamed.b_renamed(TAG, "isValid, monkey is_renamed running do not report");
        return false;
    }

    public void checkNoAnyCondition(java.lang.String str, java.lang.String str2) {
        this.mEventMap.put(str, str2);
    }

    public void checkEmptyCondition(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        this.mEventMap.put(str, str2);
    }

    public void checkGreatCondition(java.lang.String str, int i_renamed, int i2) {
        if (i_renamed > i2) {
            this.mEventMap.put(str, java.lang.String.valueOf(i_renamed));
        }
    }

    public void checkGreatCondition(java.lang.String str, long j_renamed, int i_renamed) {
        if (j_renamed > i_renamed) {
            this.mEventMap.put(str, java.lang.String.valueOf(j_renamed));
        }
    }

    public void checkGreatCondition(java.lang.String str, float f_renamed, float f2) {
        if (java.lang.Float.compare(f_renamed, f2) > 0) {
            this.mEventMap.put(str, java.lang.String.valueOf(f_renamed));
        }
    }

    public void onResume() {
        if (com.oplus.camera.util.Util.ae_renamed()) {
            com.oplus.camera.e_renamed.b_renamed(TAG, "onResume, monkey is_renamed running do not onResume");
        } else {
            com.oplus.camera.statistics.CameraStatisticsUtil.onResume(this.mContext);
        }
    }

    public void onPause() {
        if (com.oplus.camera.util.Util.ae_renamed()) {
            com.oplus.camera.e_renamed.b_renamed(TAG, "onPause, monkey is_renamed running do not onPause");
        } else {
            com.oplus.camera.statistics.CameraStatisticsUtil.onPause(this.mContext);
        }
    }

    public void destroy() {
        this.mContext = null;
    }

    public void put(java.lang.String str, java.lang.String str2) {
        this.mEventMap.put(str, str2);
    }

    protected void prepareLogTagByCaptureType() {
        int i_renamed = this.mCaptureType;
        if (i_renamed == 0) {
            this.mLogTag = LOGTAG_CAPTURE;
        } else if (i_renamed == 1) {
            this.mLogTag = LOGTAG_VIDEO;
        } else {
            if (i_renamed != 2) {
                return;
            }
            this.mLogTag = LOGTAG_STICKER;
        }
    }
}
