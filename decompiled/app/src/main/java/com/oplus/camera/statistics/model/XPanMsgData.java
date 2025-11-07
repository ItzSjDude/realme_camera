package com.oplus.camera.statistics.model;

/* loaded from: classes2.dex */
public class XPanMsgData extends com.oplus.camera.statistics.model.DcsMsgData {
    private static final java.lang.String EVENT_FUNCTION_VALUE_SELECT = "funcValue_select";
    private static final java.lang.String FUNCTION_KEY_ID = "funcKey_id";
    private static final java.lang.String FUNCTION_KEY_ID_XPAN_FILTER = "4";
    private static final java.lang.String FUNCTION_KEY_VALUE = "funcKey_value";
    private static final java.lang.String FUNCTION_KEY_VALUE_DEFAULT = "default";
    private static final java.lang.String FUNCTION_KEY_VALUE_XPAN_BLACK = "Delta400.3dl.rgb.bin";
    public static final java.lang.String TAG = "XPanMsgData";

    public XPanMsgData(android.content.Context context, boolean z_renamed, int i_renamed) {
        super(context, com.oplus.camera.statistics.model.DcsMsgData.LOGTAG_CAPTURE, "funcValue_select");
        this.mCaptureMode = com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_XPAN;
        this.mCameraId = i_renamed;
        checkNoAnyCondition("funcKey_id", "4");
        checkNoAnyCondition("funcKey_value", z_renamed ? FUNCTION_KEY_VALUE_XPAN_BLACK : "default");
    }
}
