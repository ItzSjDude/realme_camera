package com.oplus.camera.statistics.model;

import android.content.Context;

/* loaded from: classes2.dex */
public class TimeLapseProMsgData extends DcsMsgData {
    public static final String AUTO = "auto";
    public static final String EVENT_FUNCTION_KEY_CLICK = "funcKey_click";
    public static final String EVENT_FUNCTION_MENU_CLICK = "funcMenu_select";
    public static final String EVENT_FUNCTION_VALUE_SELECT = "funcValue_select";
    public static final String EVENT_FUNCTION_VIDEO_RECORD = "videoRecord";
    public static final String FUNC_KEY_HIDE_PANEL = "2";
    public static final String FUNC_KEY_ID_PARAMS = "85";
    public static final String FUNC_KEY_ID_TEMPLATE = "84";
    public static final String FUNC_KEY_SHOW_PANEL = "1";
    private static final String GENERATE_TIME = "generate_time";
    public static final String INTERVAL_1200X = "1200X";
    public static final String INTERVAL_120X = "120X";
    public static final String INTERVAL_150X = "150X";
    public static final String INTERVAL_15X = "15X";
    public static final String INTERVAL_1800X = "1800X";
    public static final String INTERVAL_300X = "300X";
    public static final String INTERVAL_30X = "30X";
    public static final String INTERVAL_450X = "450X";
    public static final String INTERVAL_45X = "45X";
    public static final String INTERVAL_600X = "600X";
    public static final String INTERVAL_60X = "60X";
    public static final String INTERVAL_900X = "900X";
    public static final String INTERVAL_90X = "90X";
    public static final String KEY_CAR_TEMPLATE = "1";
    public static final String KEY_CCT = "cct_value";
    public static final String KEY_CLOUD_TEMPLATE = "3";
    public static final String KEY_CUSTOMEIZE = "customize";
    public static final String KEY_EXP = "exp_value";
    private static final String KEY_FUNC_KEY_ID = "funcKey_id";
    private static final String KEY_FUNC_KEY_ITEM = "funcKey_item";
    private static final String KEY_FUNC_KEY_RESULT = "funcKey_result";
    private static final String KEY_FUNC_KEY_VALUE = "funcKey_value";
    public static final String KEY_ISO = "iso_value";
    public static final String KEY_LUX = "lux_value";
    public static final String KEY_NO_TEMPLATE = "default";
    public static final String KEY_STAR_TEMPLATE = "2";
    public static final String KEY_TIMELAPSEPRO_EXPOSURE_COMPENSATION = "time_lapse_ev";
    public static final String KEY_TIMELAPSEPRO_EXPOSURE_TIME = "time_lapse_exp";
    public static final String KEY_TIMELAPSEPRO_FOCUS_VALUE = "time_lapse_focus";
    public static final String KEY_TIMELAPSEPRO_INTERVAL = "time_lapse_interval";
    public static final String KEY_TIMELAPSEPRO_ISO_VALUE = "time_lapse_iso";
    public static final String KEY_TIMELAPSEPRO_PARAMETER = "time_lapse_parameter";
    public static final String KEY_TIMELAPSEPRO_TIMER = "time_lapse_timer";
    public static final String KEY_TIMELAPSEPRO_VALUE_CLEAR = "value_clear";
    public static final String KEY_TIMELAPSEPRO_WHITE_BALANCE = "time_lapse_wb";
    public static final String KEY_VIDEO_MODE = "video_mode";
    private static final String POSTERIZE_TIME = "posterize_time";
    private static final String TIMELAPSEPRO_TYPE = "time_lapse_type";
    private static final String VIDEO_TIME = "video_time";
    public String mCct;
    public String mExp;
    public String mFuncKeyId;
    public String mFuncKeyItem;
    public String mFuncKeyResult;
    public String mFuncKeyValue;
    public String mGenerateTime;
    public String mIso;
    public String mLux;
    public String mPosterizeTime;
    public String mTimeLapseEV;
    public String mTimeLapseEXP;
    public String mTimeLapseFocus;
    public String mTimeLapseISO;
    public String mTimeLapseType;
    public String mTimeLapseWB;
    public String mVideoTime;

    public String getTemplateValue(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 != 1 ? OplusGLSurfaceView_13 != 2 ? OplusGLSurfaceView_13 != 3 ? "default" : "3" : "2" : "1";
    }

    public TimeLapseProMsgData(Context context, String str) {
        super(context, DcsMsgData.LOGTAG_VIDEO, "");
        this.mFuncKeyId = "";
        this.mFuncKeyResult = "";
        this.mFuncKeyValue = "";
        this.mFuncKeyItem = "";
        this.mTimeLapseType = "";
        this.mPosterizeTime = "";
        this.mVideoTime = "";
        this.mGenerateTime = "";
        this.mTimeLapseISO = "";
        this.mTimeLapseEXP = "";
        this.mTimeLapseEV = "";
        this.mTimeLapseFocus = "";
        this.mTimeLapseWB = "";
        this.mLux = "";
        this.mIso = "";
        this.mExp = "";
        this.mCct = "";
        this.mCaptureMode = str;
    }

    public void buildEventId(String str) {
        this.mEventId = str;
    }

    @Override // com.oplus.camera.statistics.model.DcsMsgData
    public void report() {
        if ("funcKey_click".equals(this.mEventId)) {
            checkEmptyCondition("funcKey_id", this.mFuncKeyId);
            checkEmptyCondition(KEY_FUNC_KEY_RESULT, this.mFuncKeyResult);
        }
        if ("funcValue_select".equals(this.mEventId)) {
            checkEmptyCondition("funcKey_id", this.mFuncKeyId);
            checkEmptyCondition("funcKey_item", this.mFuncKeyItem);
            checkEmptyCondition("funcKey_value", this.mFuncKeyResult);
        }
        if ("funcMenu_select".equals(this.mEventId)) {
            checkEmptyCondition("funcKey_id", this.mFuncKeyId);
            checkEmptyCondition("funcKey_value", this.mFuncKeyValue);
        }
        if ("videoRecord".equals(this.mEventId)) {
            checkEmptyCondition("video_mode", this.mCaptureMode);
            checkEmptyCondition(TIMELAPSEPRO_TYPE, this.mTimeLapseType);
            checkEmptyCondition(POSTERIZE_TIME, this.mPosterizeTime);
            checkEmptyCondition("video_time", this.mVideoTime);
            checkEmptyCondition(GENERATE_TIME, this.mGenerateTime);
            checkEmptyCondition(KEY_TIMELAPSEPRO_ISO_VALUE, this.mTimeLapseISO);
            checkEmptyCondition(KEY_TIMELAPSEPRO_EXPOSURE_TIME, this.mTimeLapseEXP);
            checkEmptyCondition(KEY_TIMELAPSEPRO_EXPOSURE_COMPENSATION, this.mTimeLapseEV);
            checkEmptyCondition(KEY_TIMELAPSEPRO_FOCUS_VALUE, this.mTimeLapseFocus);
            checkEmptyCondition(KEY_TIMELAPSEPRO_WHITE_BALANCE, this.mTimeLapseWB);
            checkEmptyCondition(KEY_LUX, this.mLux);
            checkEmptyCondition(KEY_ISO, this.mIso);
            checkEmptyCondition(KEY_EXP, this.mExp);
            checkEmptyCondition(KEY_CCT, this.mCct);
        }
        super.report();
    }
}
