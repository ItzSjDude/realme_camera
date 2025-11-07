package com.oplus.camera.statistics;

import com.oplus.camera.statistics.model.DcsMsgData;
import com.oplus.camera.util.Util;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class DcsUtil {
    public static List<String> sEventList = new ArrayList();
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

    public static void fillScreenStatus(DcsMsgData dcsMsgData) {
        if (Util.m24495t()) {
            if (sEventList.contains(dcsMsgData.mLogTag + dcsMsgData.mEventId)) {
                int OplusGLSurfaceView_13 = sFoldType;
                if (OplusGLSurfaceView_13 == 21) {
                    dcsMsgData.mFoldType = 3;
                } else if (OplusGLSurfaceView_13 == 31) {
                    dcsMsgData.mFoldType = 2;
                } else {
                    dcsMsgData.mFoldType = OplusGLSurfaceView_13;
                }
                dcsMsgData.mScreenType = Util.m24498u() ? DcsMsgData.INNER : DcsMsgData.OUTER;
                String str = dcsMsgData.mRearOrFront;
                String str2 = DcsMsgData.FRONT;
                if (DcsMsgData.FRONT.equals(str)) {
                    if (Util.m24498u()) {
                        str2 = DcsMsgData.FRONT_INNER;
                    }
                    dcsMsgData.mRearOrFront = str2;
                }
            }
        }
    }

    public static void fillSecondScreenStatus(DcsMsgData dcsMsgData, boolean z, boolean z2) {
        if (Util.m24495t()) {
            dcsMsgData.mSecondScreenStatus = z ? 1 : z2 ? 2 : 0;
            int OplusGLSurfaceView_13 = sFoldType;
            if (3 == OplusGLSurfaceView_13 || 31 == OplusGLSurfaceView_13) {
                dcsMsgData.mScreenPattern = DcsMsgData.FULL;
            } else if (2 == OplusGLSurfaceView_13 || 21 == OplusGLSurfaceView_13) {
                dcsMsgData.mScreenPattern = DcsMsgData.SPLIT;
            }
        }
    }
}
