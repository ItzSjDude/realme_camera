package com.oplus.camera.statistics.model;

import android.content.Context;
import android.text.TextUtils;
import com.oplus.camera.CameraLog;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.entry.CameraEntry;
import com.oplus.camera.statistics.CameraStatisticsUtil;
import com.oplus.camera.statistics.DcsUtil;
import com.oplus.camera.util.Util;
import com.oplus.compat.p183b.p184a.UnSupportedApiVersionException;
import com.oplus.compat.p187os.SystemPropertiesNative;
import com.oplus.statistics.OplusTrack;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class DcsMsgData {
    public static final int CAPTURE_TYPE = 0;
    public static final int CONDITION_FACE_JAW = -51;
    public static final int CONDITION_NAGATIVE_ONE = -1;
    public static final int CONDITION_ZERO = 0;
    private static boolean DEBUG = false;
    public static final String DIVIDER = "|";
    public static final String FRONT = "front";
    public static final String FRONT_INNER = "front_inner";
    public static final String FULL = "full";
    public static final String INNER = "inner";
    public static final int KB_IN_BYTES = 1024;
    private static final String KEY_ANC_FILTER_TYPE = "microscope_type";
    private static final String KEY_BLUR_LEVEL = "blur_level";
    protected static final String KEY_CAMERA_ID = "camera_id";
    protected static final String KEY_CAPTURE_MODE = "capture_mode";
    private static final String KEY_CHIP_STATUS = "chip_status";
    private static final String KEY_CLIENT_TIMESTAMP = "client_timestamp";
    private static final String KEY_ENTER_TIMESTAMP = "enter_timestamp";
    private static final String KEY_ENTER_TYPE = "enter_type";
    private static final String KEY_FILTER_TYPE = "filter_type";
    private static final String KEY_FLASH_MODE = "flash_mode";
    private static final String KEY_FLASH_TRIGGER = "flash_trigger";
    private static final String KEY_FOLD_TYPE = "fold_type";
    protected static final String KEY_HIGH_BRIGHTNESS = "screen_highlight";
    private static final String KEY_IS_MIRROR = "is_mirror";
    protected static final String KEY_MAGNETIC_SHELL_FUNC_STATUS = "is_phone_case_light";
    public static final String KEY_MAKEUP_DREAM = "makeup_wishing_star";
    public static final String KEY_MAKEUP_FIRST_LOVE = "makeup_first_love";
    public static final String KEY_MAKEUP_GROOMED = "makeup_groomed";
    public static final String KEY_MAKEUP_MIDNIGHT = "makeup_midnight";
    public static final String KEY_MAKEUP_NONE = "makeup_type_none";
    public static final String KEY_MAKEUP_ORANGE_CRUSH = "makeup_orange_crush";
    public static final String KEY_MAKEUP_PEACH_PINK = "makeup_peach_pink";
    public static final String KEY_MAKEUP_RED_VELVET = "makeup_red_velvet";
    public static final String KEY_MAKEUP_ROSY_NUDE = "makeup_rosy_nude";
    public static final String KEY_MAKEUP_SMOKEY = "makeup_smokey";
    public static final String KEY_MAKEUP_SNOW = "makeup_twilight_snow";
    public static final String KEY_MAKEUP_SPARKLING_SEA = "makeup_sparkling_sea";
    public static final String KEY_MAKEUP_TYPE = "makeup_type";
    public static final String KEY_MAKEUP_UNIQUE_EYES = "makeup_unique_eyes";
    public static final String KEY_MAKEUP_VALUE = "makeup_value";
    public static final String KEY_MAKEUP_VIOLET_SHIMMER = "makeup_violet_shimmer";
    private static final String KEY_NIGHT_STYLE_TYPE = "night_style_type";
    protected static final String KEY_ORIENTATION = "orientation";
    private static final String KEY_PORTRAIT_NEW_STYLE_TYPE = "portrait_new_style_type";
    private static final String KEY_REAR_FRONT = "rear_front";
    protected static final String KEY_SCREEN_BRIGHTNESS = "screen_brightness";
    private static final String KEY_SCREEN_PATTERN = "screen_pattern";
    private static final String KEY_SCREEN_TYPE = "screen_type";
    private static final String KEY_SECOND_SCREEN_STATUS = "second_screen_status";
    public static final String KEY_SMOOTH_CUBE = "self_smooth_cube";
    public static final String KEY_SMOOTH_DERMABRASION = "self_smooth_dermabrasion";
    public static final String KEY_SMOOTH_EYE_BIG = "self_smooth_eye_big";
    public static final String KEY_SMOOTH_FACE_JAW = "self_smooth_face_jaw";
    public static final String KEY_SMOOTH_FACE_LEAN = "self_smooth_face_lean";
    public static final String KEY_SMOOTH_FACE_SMALL = "self_smooth_face_small";
    public static final String KEY_SMOOTH_FRESHEN_UP = "self_smooth_freshen_up";
    public static final String KEY_SMOOTH_NOSE_LEAN = "self_smooth_nose_lean";
    private static final String KEY_SMOOTH_VALUE = "smooth_value";
    protected static final String KEY_SUBSCREEN_VALUE = "subscreen_value";
    private static final String KEY_VERSION_DATE = "version_date";
    protected static final String KEY_ZOOM_VALUE = "zoom_value";
    public static final String LOGTAG_CAPTURE = "200";
    protected static final String LOGTAG_QRCODE = "206";
    protected static final String LOGTAG_STICKER = "205";
    protected static final String LOGTAG_UPGRADE = "204";
    public static final String LOGTAG_VIDEO = "202";
    public static final String OFF = "off";

    /* renamed from: ON */
    public static final String f16171ON = "on";
    public static final String OUTER = "outer";
    public static final String REAR = "rear";
    public static final int SECOND_SCREEN_CAPTURE = 1;
    public static final int SECOND_SCREEN_CLOSE = 0;
    public static final int SECOND_SCREEN_PREVIEW = 2;
    private static final int SESSION_TIME_OUT = 10;
    public static final String SHUTTER_MODE_DONE = "end";
    public static final String SPLIT = "split";
    public static final int STICKER_TYPE = 2;
    protected static final String TAG = "DcsMsgData";
    private static final String VERSION_DATE = "20190823";
    public static final int VIDEO_TYPE = 1;
    public static List<String> sKeyMakeupList;
    public String mAncFilterType;
    public int mBlurLevel;
    public String mCameraEnterTimeStamp;
    public String mCameraEnterType;
    public int mCameraId;
    public String mCaptureMode;
    public int mCaptureType;
    public int mChipStatus;
    public String mClientTimeStamp;
    private Context mContext;
    public String mEventId;
    protected HashMap<String, String> mEventMap;
    public String mFilterType;
    public String mFlashMode;
    public String mFlashTrigger;
    public int mFoldType;
    public String mIsMirror;
    public String mLogTag;
    public String mMagneticShellStatus;
    public String mMakeupType;
    public int mMakeupValue;
    public String mNightStyleType;
    public int mOrientation;
    public String mPortraitNewStyleType;
    public String mRearOrFront;
    public int mScreenBrightness;
    public String mScreenHighLight;
    public String mScreenPattern;
    public String mScreenType;
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
    public String mZoomValue;

    static {
        try {
            DEBUG = SystemPropertiesNative.getBoolean("persist.sys.assert.panic", false);
        } catch (UnSupportedApiVersionException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        sKeyMakeupList = new ArrayList();
    }

    public static void initMakeupList() {
        if (sKeyMakeupList.size() != 0) {
            return;
        }
        sKeyMakeupList.add(KEY_MAKEUP_NONE);
        sKeyMakeupList.add(KEY_MAKEUP_ROSY_NUDE);
        sKeyMakeupList.add(KEY_MAKEUP_ORANGE_CRUSH);
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_CUSTOM_MAKEUP_TYPE_SNOW)) {
            sKeyMakeupList.add(KEY_MAKEUP_SNOW);
        }
        sKeyMakeupList.add(KEY_MAKEUP_FIRST_LOVE);
        sKeyMakeupList.add(KEY_MAKEUP_PEACH_PINK);
        sKeyMakeupList.add(KEY_MAKEUP_RED_VELVET);
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_CUSTOM_MAKEUP_TYPE_DREAM)) {
            sKeyMakeupList.add(KEY_MAKEUP_DREAM);
        }
        sKeyMakeupList.add(KEY_MAKEUP_SPARKLING_SEA);
        sKeyMakeupList.add(KEY_MAKEUP_UNIQUE_EYES);
        sKeyMakeupList.add(KEY_MAKEUP_MIDNIGHT);
        sKeyMakeupList.add(KEY_MAKEUP_VIOLET_SHIMMER);
        sKeyMakeupList.add(KEY_MAKEUP_SMOKEY);
        sKeyMakeupList.add(KEY_MAKEUP_GROOMED);
    }

    public DcsMsgData(Context context, String str, String str2) {
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
        this.mCameraEnterTimeStamp = String.valueOf(CameraEntry.m13307o());
        this.mCameraEnterType = String.valueOf(1);
        this.mClientTimeStamp = String.valueOf(System.currentTimeMillis());
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
            this.mEventMap = new LinkedHashMap();
        } else {
            this.mEventMap = new HashMap<>();
        }
    }

    public DcsMsgData(Context context, String str) {
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
        this.mCameraEnterTimeStamp = String.valueOf(CameraEntry.m13307o());
        this.mCameraEnterType = String.valueOf(1);
        this.mClientTimeStamp = String.valueOf(System.currentTimeMillis());
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
            this.mEventMap = new LinkedHashMap();
        } else {
            this.mEventMap = new HashMap<>();
        }
    }

    public static void init(Context context) {
        if (Util.m24342ae()) {
            CameraLog.m12959b(TAG, "init, monkey is running do not init");
            return;
        }
        CameraStatisticsUtil.init(context);
        CameraStatisticsUtil.onError(context);
        CameraStatisticsUtil.onDebug(context, DEBUG);
        CameraStatisticsUtil.setSessionTimeOut(context, 10);
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
        } catch (IndexOutOfBoundsException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
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
                CameraLog.m12959b(TAG, "report, mLogTag: " + this.mLogTag + ", mEventId: " + this.mEventId);
            }
            Context context = this.mContext;
            if (context != null) {
                OplusTrack.onCommon(context, this.mLogTag, this.mEventId, this.mEventMap);
            }
        }
    }

    protected void beforeReport() {
        DcsUtil.fillScreenStatus(this);
    }

    public boolean isValid() {
        if (!Util.m24342ae()) {
            return (TextUtils.isEmpty(this.mLogTag) && TextUtils.isEmpty(this.mEventId)) ? false : true;
        }
        CameraLog.m12959b(TAG, "isValid, monkey is running do not report");
        return false;
    }

    public void checkNoAnyCondition(String str, String str2) {
        this.mEventMap.put(str, str2);
    }

    public void checkEmptyCondition(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.mEventMap.put(str, str2);
    }

    public void checkGreatCondition(String str, int OplusGLSurfaceView_13, int i2) {
        if (OplusGLSurfaceView_13 > i2) {
            this.mEventMap.put(str, String.valueOf(OplusGLSurfaceView_13));
        }
    }

    public void checkGreatCondition(String str, long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_15 > OplusGLSurfaceView_13) {
            this.mEventMap.put(str, String.valueOf(OplusGLSurfaceView_15));
        }
    }

    public void checkGreatCondition(String str, float COUIBaseListPopupWindow_12, float f2) {
        if (Float.compare(COUIBaseListPopupWindow_12, f2) > 0) {
            this.mEventMap.put(str, String.valueOf(COUIBaseListPopupWindow_12));
        }
    }

    public void onResume() {
        if (Util.m24342ae()) {
            CameraLog.m12959b(TAG, "onResume, monkey is running do not onResume");
        } else {
            CameraStatisticsUtil.onResume(this.mContext);
        }
    }

    public void onPause() {
        if (Util.m24342ae()) {
            CameraLog.m12959b(TAG, "onPause, monkey is running do not onPause");
        } else {
            CameraStatisticsUtil.onPause(this.mContext);
        }
    }

    public void destroy() {
        this.mContext = null;
    }

    public void put(String str, String str2) {
        this.mEventMap.put(str, str2);
    }

    protected void prepareLogTagByCaptureType() {
        int OplusGLSurfaceView_13 = this.mCaptureType;
        if (OplusGLSurfaceView_13 == 0) {
            this.mLogTag = LOGTAG_CAPTURE;
        } else if (OplusGLSurfaceView_13 == 1) {
            this.mLogTag = LOGTAG_VIDEO;
        } else {
            if (OplusGLSurfaceView_13 != 2) {
                return;
            }
            this.mLogTag = LOGTAG_STICKER;
        }
    }
}
