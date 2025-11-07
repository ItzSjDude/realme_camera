package com.oplus.camera.statistics.model;

import android.content.Context;
import android.text.TextUtils;
import com.oplus.camera.aps.constant.ApsConstant;

/* loaded from: classes2.dex */
public class PreviewStaticInfoMsgData extends DcsMsgData {
    public static final String EVENT_STATIC_INFO = "static_info";
    private static final String EVENT_STICKER_COUNT = "sticker_count";
    public static final int STICKER_COUNT_INIT = -1;
    public int mStickerCount;

    public PreviewStaticInfoMsgData(Context context) {
        super(context, DcsMsgData.LOGTAG_CAPTURE, EVENT_STATIC_INFO);
        this.mStickerCount = -1;
    }

    @Override // com.oplus.camera.statistics.model.DcsMsgData
    public void report() {
        if (!TextUtils.isEmpty(this.mCaptureMode) && ApsConstant.CAPTURE_MODE_STICKER.equals(this.mCaptureMode)) {
            this.mCaptureType = 2;
        }
        prepareLogTagByCaptureType();
        checkGreatCondition(EVENT_STICKER_COUNT, this.mStickerCount, -1);
        super.report();
    }
}
