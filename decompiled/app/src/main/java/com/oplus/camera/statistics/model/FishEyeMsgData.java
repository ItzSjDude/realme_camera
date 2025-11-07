package com.oplus.camera.statistics.model;

/* loaded from: classes2.dex */
public class FishEyeMsgData extends com.oplus.camera.statistics.model.DcsMsgData {
    private static final java.lang.String EVENT_FUNCTION_VALUE_SELECT = "funcValue_select";
    private static final java.lang.String FUNCTION_KEY_ID = "funcKey_id";
    private static final java.lang.String FUNCTION_KEY_ID_FISH_EYE = "87";
    private static final java.lang.String FUNCTION_KEY_VALUE = "funcKey_value";
    private static final java.lang.String FUNCTION_KEY_VALUE_CIRCLE = "2";
    private static final java.lang.String FUNCTION_KEY_VALUE_NORMAL = "1";
    public static final java.lang.String TAG = "FishEyeMsgData";

    public FishEyeMsgData(android.content.Context context, boolean z_renamed, int i_renamed) {
        super(context, com.oplus.camera.statistics.model.DcsMsgData.LOGTAG_CAPTURE, "funcValue_select");
        this.mCaptureMode = com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_FISH_EYE;
        this.mCameraId = i_renamed;
        checkNoAnyCondition("funcKey_id", FUNCTION_KEY_ID_FISH_EYE);
        checkNoAnyCondition("funcKey_value", z_renamed ? "2" : "1");
    }
}
