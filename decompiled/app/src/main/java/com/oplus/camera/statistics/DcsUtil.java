package com.oplus.camera.statistics;

/* loaded from: classes2.dex */
public class DcsUtil {
    public static java.util.List<java.lang.String> sEventList = new java.util.ArrayList();
    public static int sFoldType;

    static {
        sEventList.add("201enter");
        sEventList.add("201exit");
        sEventList.add("200portrait");
        sEventList.add("200ai_effect_click");
        sEventList.add("200switch_cameraId");
        sEventList.add("200reminder");
        sEventList.add("200funcKey_click");
        sEventList.add("200funcValue_select");
        sEventList.add("200funcMenu_select");
        sEventList.add("200zoom_adjust");
        sEventList.add("200focus_aim");
        sEventList.add("200static_info");
        sEventList.add("202pause");
        sEventList.add("202video_playback");
        sEventList.add("202guide_page");
        sEventList.add("202video_clip");
        sEventList.add("202switch_cameraId");
        sEventList.add("202reminder");
        sEventList.add("202funcKey_click");
        sEventList.add("202funcValue_select");
        sEventList.add("202funcMenu_select");
        sEventList.add("202zoom_adjust");
        sEventList.add("202focus_aim");
        sEventList.add("202static_info");
        sEventList.add("202videoRecord");
    }

    public static void fillScreenStatus(com.oplus.camera.statistics.model.DcsMsgData dcsMsgData) {
        if (com.oplus.camera.util.Util.t_renamed()) {
            if (sEventList.contains(dcsMsgData.mLogTag + dcsMsgData.mEventId)) {
                int i_renamed = sFoldType;
                if (i_renamed == 21) {
                    dcsMsgData.mFoldType = 3;
                } else if (i_renamed == 31) {
                    dcsMsgData.mFoldType = 2;
                } else {
                    dcsMsgData.mFoldType = i_renamed;
                }
                dcsMsgData.mScreenType = com.oplus.camera.util.Util.u_renamed() ? com.oplus.camera.statistics.model.DcsMsgData.INNER : com.oplus.camera.statistics.model.DcsMsgData.OUTER;
                java.lang.String str = dcsMsgData.mRearOrFront;
                java.lang.String str2 = com.oplus.camera.statistics.model.DcsMsgData.FRONT;
                if (com.oplus.camera.statistics.model.DcsMsgData.FRONT.equals(str)) {
                    if (com.oplus.camera.util.Util.u_renamed()) {
                        str2 = com.oplus.camera.statistics.model.DcsMsgData.FRONT_INNER;
                    }
                    dcsMsgData.mRearOrFront = str2;
                }
            }
        }
    }

    public static void fillSecondScreenStatus(com.oplus.camera.statistics.model.DcsMsgData dcsMsgData, boolean z_renamed, boolean z2) {
        if (com.oplus.camera.util.Util.t_renamed()) {
            dcsMsgData.mSecondScreenStatus = z_renamed ? 1 : z2 ? 2 : 0;
            int i_renamed = sFoldType;
            if (3 == i_renamed || 31 == i_renamed) {
                dcsMsgData.mScreenPattern = com.oplus.camera.statistics.model.DcsMsgData.FULL;
            } else if (2 == i_renamed || 21 == i_renamed) {
                dcsMsgData.mScreenPattern = com.oplus.camera.statistics.model.DcsMsgData.SPLIT;
            }
        }
    }
}
