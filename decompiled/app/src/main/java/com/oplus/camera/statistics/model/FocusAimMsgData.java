package com.oplus.camera.statistics.model;

import android.content.Context;
import android.text.TextUtils;
import com.oplus.camera.aps.constant.ApsConstant;

/* loaded from: classes2.dex */
public class FocusAimMsgData extends DcsMsgData {
    public static final String EVENT_FOCUS_AIM = "focus_aim";
    private static final String KEY_ACT_TYPE = "act_type";
    public static final String KEY_ADJUST_EXPOSURE = "2";
    private static final String KEY_AE_AF_LOCK = "ae_af_lock";
    public static final String KEY_EXPOSURE_LOCK = "3";
    public static final String KEY_HYPER_LAPSE_FOCUS_TYPE = "4";
    public static final String KEY_INTELLIGENCE_VIEW_FOCUS_TYPE = "10";
    private static final String KEY_IS_RECORDING = "is_recording";
    public static final String KEY_MANUAL_FOCUS = "1";
    public static final String KEY_MULTI_VIDEO_DRAG_SCREEN_FOCUS_TYPE = "8";
    public static final String KEY_MULTI_VIDEO_FOCUS_TYPE = "7";
    public static final String KEY_MULTI_VIDEO_SWITCH_SCREEN_FOCUS_TYPE = "9";
    public static final String KEY_SEPARATE_METERING_FOCUS = "11";
    private static final String KEY_TOUCH_EV = "touch_ev";
    private static final String KEY_TOUCH_HYPER_LAPSE_FOCUS_VIEW_XY = "hyper_lapse_focus_view";
    public static final String KEY_TOUCH_TAKE_PICTURE = "6";
    private static final String KEY_TOUCH_XY = "touchXY";
    private static final String KEY_TOUCH_XY_EV = "touchXY_ev";
    public static final String KEY_TRACKING_FOCUS = "7";
    private static final String TAG = "FocusAimMsgData";
    public String mActType;
    public String mAeAfLock;
    public String mHyperLapseFocusViewXY;
    public String mSubScreenValue;
    public String mTouchEV;
    public String mTouchEVXY;
    public String mTouchXY;
    public boolean mbVideoRecording;

    public FocusAimMsgData(Context context) {
        super(context, EVENT_FOCUS_AIM);
        this.mTouchXY = "";
        this.mTouchEVXY = "";
        this.mbVideoRecording = false;
        this.mAeAfLock = "";
        this.mTouchEV = "";
        this.mHyperLapseFocusViewXY = "";
        this.mActType = "";
        this.mSubScreenValue = "";
    }

    @Override // com.oplus.camera.statistics.model.DcsMsgData
    public void report() {
        if (!TextUtils.isEmpty(this.mCaptureMode) && ApsConstant.CAPTURE_MODE_STICKER.equals(this.mCaptureMode)) {
            this.mCaptureType = 2;
        }
        prepareLogTagByCaptureType();
        checkEmptyCondition("ae_af_lock", this.mAeAfLock);
        if (this.mCaptureType == 1) {
            this.mEventMap.put(KEY_IS_RECORDING, String.valueOf(this.mbVideoRecording));
        }
        checkEmptyCondition(KEY_TOUCH_XY, this.mTouchXY);
        checkEmptyCondition(KEY_TOUCH_XY_EV, this.mTouchEVXY);
        checkEmptyCondition("touch_ev", this.mTouchEV);
        checkEmptyCondition(KEY_TOUCH_HYPER_LAPSE_FOCUS_VIEW_XY, this.mHyperLapseFocusViewXY);
        checkEmptyCondition(KEY_ACT_TYPE, this.mActType);
        checkEmptyCondition("subscreen_value", this.mSubScreenValue);
        super.report();
    }
}
