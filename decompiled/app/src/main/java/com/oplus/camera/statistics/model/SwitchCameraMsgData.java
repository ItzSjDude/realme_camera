package com.oplus.camera.statistics.model;

/* loaded from: classes2.dex */
public class SwitchCameraMsgData extends com.oplus.camera.statistics.model.DcsMsgData {
    public static final java.lang.String EVENT_SWITCH_CAMERA = "switch_cameraId";
    private static final java.lang.String KEY_OPER_TYPE = "oper_type";
    private static final java.lang.String KEY_TO_CAPTURE_MODE = "to_capture_mode";
    public static final java.lang.String OPER_TYPE_MAGNETIC_SHELL_RISE = "2";
    public static final java.lang.String OPER_TYPE_SWITCH_CAMERA = "0";
    public static final java.lang.String OPER_TYPE_SWITCH_MODE = "1";
    private static final java.lang.String TAG = "SwitchCameraMsgData";
    public java.lang.String mOperType;
    public java.lang.String mToCaptureMode;

    public SwitchCameraMsgData(android.content.Context context) {
        super(context, EVENT_SWITCH_CAMERA);
        this.mToCaptureMode = "";
    }

    @Override // com.oplus.camera.statistics.model.DcsMsgData
    public void report() {
        prepareLogTagByCaptureType();
        checkEmptyCondition(KEY_TO_CAPTURE_MODE, this.mToCaptureMode);
        checkEmptyCondition(KEY_OPER_TYPE, this.mOperType);
        super.report();
    }
}
