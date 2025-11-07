package com.oplus.camera.statistics.model;

/* loaded from: classes2.dex */
public class FilmModeMsgData extends com.oplus.camera.statistics.model.DcsMsgData {
    public static final java.lang.String EVENT_FUNCTION_MENU_CLICK = "funcKey_click";
    public static final java.lang.String EVENT_FUNCTION_PARAMS_SELECT = "funcValue_select";
    public static final java.lang.String EVENT_FUNCTION_VIDEO_RECORD = "videoRecord";
    public static final java.lang.String FUNC_KEY_ID_EIS = "38";
    public static final java.lang.String FUNC_KEY_ID_EV = "43";
    public static final java.lang.String FUNC_KEY_ID_FLASH = "3";
    public static final java.lang.String FUNC_KEY_ID_FOCUS = "42";
    public static final java.lang.String FUNC_KEY_ID_GRID = "37";
    public static final java.lang.String FUNC_KEY_ID_HDR = "69";
    public static final java.lang.String FUNC_KEY_ID_HISTOGRAM = "58";
    public static final java.lang.String FUNC_KEY_ID_ISO = "44";
    public static final java.lang.String FUNC_KEY_ID_LOG = "57";
    public static final java.lang.String FUNC_KEY_ID_MENU_RESOLUTION = "60";
    public static final java.lang.String FUNC_KEY_ID_MENU_SWITCH = "59";
    public static final java.lang.String FUNC_KEY_ID_SHUTTER = "40";
    public static final java.lang.String FUNC_KEY_ID_SUBMENU = "26";
    public static final java.lang.String FUNC_KEY_ID_SWITCH_CAMERA = "39";
    public static final java.lang.String FUNC_KEY_ID_WB = "41";
    public static final java.lang.String FUNC_KEY_RESULT_OFF = "2";
    public static final java.lang.String FUNC_KEY_RESULT_ON = "1";
    private static final java.lang.String KEY_FUNC_KEY_ID = "funcKey_id";
    private static final java.lang.String KEY_FUNC_KEY_RESULT = "funcKey_result";
    private static final java.lang.String KEY_FUNC_KEY_VALUE = "funckey_value";
    private static final java.lang.String KEY_MOVIE_CAMERA_ID = "movie_camera_id";
    public java.lang.String mFuncKeyId;
    public java.lang.String mFuncKeyResult;
    public java.lang.String mFuncKeyValue;
    public java.lang.String mIsAssistantLine;
    public java.lang.String mMovieCameraId;

    public void buildEventId(java.lang.String str) {
        this.mEventId = str;
    }

    public FilmModeMsgData(android.content.Context context) {
        super(context, com.oplus.camera.statistics.model.DcsMsgData.LOGTAG_VIDEO, "");
        this.mFuncKeyId = "";
        this.mFuncKeyResult = "";
        this.mFuncKeyValue = "";
        this.mIsAssistantLine = "";
        this.mMovieCameraId = "";
    }

    @Override // com.oplus.camera.statistics.model.DcsMsgData
    public void report() {
        if ("funcKey_click".equals(this.mEventId)) {
            checkEmptyCondition("funcKey_id", this.mFuncKeyId);
            checkEmptyCondition(KEY_FUNC_KEY_RESULT, this.mFuncKeyResult);
        }
        if ("funcValue_select".equals(this.mEventId)) {
            checkEmptyCondition("funcKey_id", this.mFuncKeyId);
            checkEmptyCondition(KEY_MOVIE_CAMERA_ID, this.mMovieCameraId);
            checkEmptyCondition(KEY_FUNC_KEY_VALUE, this.mFuncKeyValue);
        }
        super.report();
    }
}
