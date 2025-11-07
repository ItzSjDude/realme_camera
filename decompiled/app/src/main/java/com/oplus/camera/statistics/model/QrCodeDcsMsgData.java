package com.oplus.camera.statistics.model;

/* loaded from: classes2.dex */
public class QrCodeDcsMsgData extends com.oplus.camera.statistics.model.DcsMsgData {
    public static final java.lang.String EVENT_FUNCTION_CLICK_QR_CODE = "click_qr_code";
    public static final java.lang.String EVENT_FUNCTION_SCAN_QR_CODE = "scan_qr_code";
    public static final java.lang.String KEY_CODE_RESULT = "code_result";
    public static final java.lang.String KEY_PROTOCOL = "protocol";
    public static final int PARAMS_RESULT_QR_CODE = 1;
    public static final java.lang.String TAG = "QrCodeDcsMsgData";
    public static final int TYPE_JUMP_HTTP = 1;
    public static final int TYPE_JUMP_INSTANT = 2;
    public static final int TYPE_JUMP_NONE = 4;
    public static final int TYPE_JUMP_WIFI = 3;
    public int mCodeResult;
    public int mProtocol;

    public QrCodeDcsMsgData(android.content.Context context) {
        super(context, "206", "");
        this.mCodeResult = 1;
        this.mProtocol = -1;
    }

    public void buildEventId(boolean z_renamed) {
        this.mEventId = z_renamed ? EVENT_FUNCTION_CLICK_QR_CODE : EVENT_FUNCTION_SCAN_QR_CODE;
    }

    @Override // com.oplus.camera.statistics.model.DcsMsgData
    public void report() {
        if (EVENT_FUNCTION_SCAN_QR_CODE.equals(this.mEventId)) {
            checkGreatCondition(KEY_CODE_RESULT, this.mCodeResult, -1);
        }
        if (EVENT_FUNCTION_CLICK_QR_CODE.equals(this.mEventId)) {
            checkGreatCondition(KEY_CODE_RESULT, this.mCodeResult, -1);
            checkEmptyCondition(KEY_PROTOCOL, java.lang.String.valueOf(this.mProtocol));
        }
        super.report();
    }
}
