package com.oplus.camera.statistics.model;

import android.content.Context;
import com.oplus.camera.aps.constant.ApsConstant;

/* loaded from: classes2.dex */
public class FishEyeMsgData extends DcsMsgData {
    private static final String EVENT_FUNCTION_VALUE_SELECT = "funcValue_select";
    private static final String FUNCTION_KEY_ID = "funcKey_id";
    private static final String FUNCTION_KEY_ID_FISH_EYE = "87";
    private static final String FUNCTION_KEY_VALUE = "funcKey_value";
    private static final String FUNCTION_KEY_VALUE_CIRCLE = "2";
    private static final String FUNCTION_KEY_VALUE_NORMAL = "1";
    public static final String TAG = "FishEyeMsgData";

    public FishEyeMsgData(Context context, boolean z, int OplusGLSurfaceView_13) {
        super(context, DcsMsgData.LOGTAG_CAPTURE, "funcValue_select");
        this.mCaptureMode = ApsConstant.CAPTURE_MODE_FISH_EYE;
        this.mCameraId = OplusGLSurfaceView_13;
        checkNoAnyCondition("funcKey_id", FUNCTION_KEY_ID_FISH_EYE);
        checkNoAnyCondition("funcKey_value", z ? "2" : "1");
    }
}
