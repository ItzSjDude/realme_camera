package com.oplus.camera.statistics.model;

/* loaded from: classes2.dex */
public class ZoomAdjustMsgData extends com.oplus.camera.statistics.model.DcsMsgData {
    public static final int CIRCLE_ZOOM_CLICK_TYPE = 7;
    public static final int DOUBLE_FINGER_TYPE = 4;
    public static final java.lang.String EVENT_ZOOM_ADJUST = "zoom_adjust";
    private static final java.lang.String KEY_INERTIAL_RATE_VALUE = "rate_value";
    private static final java.lang.String KEY_IS_RECORDING = "is_recording";
    private static final java.lang.String KEY_ZOOM_TYPE = "zoom_type";
    private static final java.lang.String TAG = "ZoomAdjustMsgData";
    public static final int ULTRA_WIDE_ICON_CLICK_TYPE = 8;
    public static final int VOLUME_BUTTON_TYPE = 3;
    public static final int ZOOM_ARCSEEKBAR_CLICK_TYPE = 9;
    public static final int ZOOM_BUTTON_TYPE = 1;
    public static final int ZOOM_INERTIAL_BUTTON_CLICK_TYPE = 12;
    public static final int ZOOM_INERTIAL_DRAG_TYPE = 10;
    public static final int ZOOM_INERTIAL_LONG_CLICK_TYPE = 11;
    public static final int ZOOM_SEEKBAR_TYPE = 2;
    public java.lang.String mRateValue;
    public int mZoomType;
    public java.lang.String mZoomValue;
    public boolean mbVideoRecording;

    public ZoomAdjustMsgData(android.content.Context context) {
        super(context, EVENT_ZOOM_ADJUST);
        this.mZoomType = 1;
        this.mZoomValue = "";
        this.mbVideoRecording = false;
        this.mRateValue = "";
    }

    @Override // com.oplus.camera.statistics.model.DcsMsgData
    public void report() {
        if (!android.text.TextUtils.isEmpty(this.mCaptureMode) && com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_STICKER.equals(this.mCaptureMode)) {
            this.mCaptureType = 2;
        }
        prepareLogTagByCaptureType();
        if (1 == this.mCaptureType) {
            checkNoAnyCondition(KEY_IS_RECORDING, java.lang.String.valueOf(this.mbVideoRecording));
        }
        checkEmptyCondition("zoom_value", this.mZoomValue);
        checkNoAnyCondition(KEY_ZOOM_TYPE, java.lang.String.valueOf(this.mZoomType));
        checkEmptyCondition(KEY_INERTIAL_RATE_VALUE, this.mRateValue);
        super.report();
    }
}
