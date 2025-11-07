package com.oplus.camera.statistics.model;

import android.content.Context;
import android.text.TextUtils;
import com.oplus.camera.aps.constant.ApsConstant;

/* loaded from: classes2.dex */
public class ZoomAdjustMsgData extends DcsMsgData {
    public static final int CIRCLE_ZOOM_CLICK_TYPE = 7;
    public static final int DOUBLE_FINGER_TYPE = 4;
    public static final String EVENT_ZOOM_ADJUST = "zoom_adjust";
    private static final String KEY_INERTIAL_RATE_VALUE = "rate_value";
    private static final String KEY_IS_RECORDING = "is_recording";
    private static final String KEY_ZOOM_TYPE = "zoom_type";
    private static final String TAG = "ZoomAdjustMsgData";
    public static final int ULTRA_WIDE_ICON_CLICK_TYPE = 8;
    public static final int VOLUME_BUTTON_TYPE = 3;
    public static final int ZOOM_ARCSEEKBAR_CLICK_TYPE = 9;
    public static final int ZOOM_BUTTON_TYPE = 1;
    public static final int ZOOM_INERTIAL_BUTTON_CLICK_TYPE = 12;
    public static final int ZOOM_INERTIAL_DRAG_TYPE = 10;
    public static final int ZOOM_INERTIAL_LONG_CLICK_TYPE = 11;
    public static final int ZOOM_SEEKBAR_TYPE = 2;
    public String mRateValue;
    public int mZoomType;
    public String mZoomValue;
    public boolean mbVideoRecording;

    public ZoomAdjustMsgData(Context context) {
        super(context, EVENT_ZOOM_ADJUST);
        this.mZoomType = 1;
        this.mZoomValue = "";
        this.mbVideoRecording = false;
        this.mRateValue = "";
    }

    @Override // com.oplus.camera.statistics.model.DcsMsgData
    public void report() {
        if (!TextUtils.isEmpty(this.mCaptureMode) && ApsConstant.CAPTURE_MODE_STICKER.equals(this.mCaptureMode)) {
            this.mCaptureType = 2;
        }
        prepareLogTagByCaptureType();
        if (1 == this.mCaptureType) {
            checkNoAnyCondition(KEY_IS_RECORDING, String.valueOf(this.mbVideoRecording));
        }
        checkEmptyCondition("zoom_value", this.mZoomValue);
        checkNoAnyCondition(KEY_ZOOM_TYPE, String.valueOf(this.mZoomType));
        checkEmptyCondition(KEY_INERTIAL_RATE_VALUE, this.mRateValue);
        super.report();
    }
}
