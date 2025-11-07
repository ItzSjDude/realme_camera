package com.oplus.camera.statistics.model;

/* loaded from: classes2.dex */
public class PreviewStaticInfoMsgData extends com.oplus.camera.statistics.model.DcsMsgData {
    public static final java.lang.String EVENT_STATIC_INFO = "static_info";
    private static final java.lang.String EVENT_STICKER_COUNT = "sticker_count";
    public static final int STICKER_COUNT_INIT = -1;
    public int mStickerCount;

    public PreviewStaticInfoMsgData(android.content.Context context) {
        super(context, com.oplus.camera.statistics.model.DcsMsgData.LOGTAG_CAPTURE, EVENT_STATIC_INFO);
        this.mStickerCount = -1;
    }

    @Override // com.oplus.camera.statistics.model.DcsMsgData
    public void report() {
        if (!android.text.TextUtils.isEmpty(this.mCaptureMode) && com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_STICKER.equals(this.mCaptureMode)) {
            this.mCaptureType = 2;
        }
        prepareLogTagByCaptureType();
        checkGreatCondition(EVENT_STICKER_COUNT, this.mStickerCount, -1);
        super.report();
    }
}
