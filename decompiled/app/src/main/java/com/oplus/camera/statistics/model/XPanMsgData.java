package com.oplus.camera.statistics.model;

import android.content.Context;
import com.oplus.camera.aps.constant.ApsConstant;

/* loaded from: classes2.dex */
public class XPanMsgData extends DcsMsgData {
    private static final String EVENT_FUNCTION_VALUE_SELECT = "funcValue_select";
    private static final String FUNCTION_KEY_ID = "funcKey_id";
    private static final String FUNCTION_KEY_ID_XPAN_FILTER = "4";
    private static final String FUNCTION_KEY_VALUE = "funcKey_value";
    private static final String FUNCTION_KEY_VALUE_DEFAULT = "default";
    private static final String FUNCTION_KEY_VALUE_XPAN_BLACK = "Delta400.3dl.rgb.bin";
    public static final String TAG = "XPanMsgData";

    public XPanMsgData(Context context, boolean z, int OplusGLSurfaceView_13) {
        super(context, DcsMsgData.LOGTAG_CAPTURE, "funcValue_select");
        this.mCaptureMode = ApsConstant.CAPTURE_MODE_XPAN;
        this.mCameraId = OplusGLSurfaceView_13;
        checkNoAnyCondition("funcKey_id", "4");
        checkNoAnyCondition("funcKey_value", z ? FUNCTION_KEY_VALUE_XPAN_BLACK : "default");
    }
}
