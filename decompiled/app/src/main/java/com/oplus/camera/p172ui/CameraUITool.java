package com.oplus.camera.p172ui;

import com.oplus.camera.CameraLog;
import com.oplus.camera.p172ui.menu.CameraMenuOptionInfo;
import com.oplus.camera.p172ui.menu.OptionItemInfo;
import java.util.ArrayList;

/* compiled from: CameraUITool.java */
/* renamed from: com.oplus.camera.ui.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class CameraUITool {
    /* renamed from: PlatformImplementations.kt_3 */
    public static int m20061a(String str, ArrayList<OptionItemInfo> arrayList) {
        if (str == null || arrayList == null) {
            return -1;
        }
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < arrayList.size(); OplusGLSurfaceView_13++) {
            if (m20063a(str, arrayList.get(OplusGLSurfaceView_13).m20483c())) {
                return OplusGLSurfaceView_13;
            }
        }
        return -1;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m20063a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static boolean m20064b(String str, ArrayList<OptionItemInfo> arrayList) {
        if (str != null && arrayList != null) {
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < arrayList.size(); OplusGLSurfaceView_13++) {
                if (m20063a(str, arrayList.get(OplusGLSurfaceView_13).m20483c())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m20062a(CameraMenuOptionInfo c3240b) {
        if (c3240b == null) {
            CameraLog.m12954a("CameraUITool", "checkCameraMenuOptionInfo, mCameraMenuOptionInfo is null.");
            return false;
        }
        if (c3240b.getOptionKey() == null || c3240b.getOptionKey().equals("")) {
            CameraLog.m12954a("CameraUITool", "checkCameraMenuOptionInfo, mCameraMenuOptionInfo.mOptionKey is null.");
            return false;
        }
        if (c3240b.getOptionItems() == null || c3240b.getOptionItems().size() <= 0) {
            CameraLog.m12954a("CameraUITool", "checkCameraMenuOptionInfo, mCameraMenuOptionInfo has no items.");
            return false;
        }
        if (c3240b.getOptionTitle() != null && !c3240b.getOptionTitle().equals("")) {
            return true;
        }
        CameraLog.m12954a("CameraUITool", "checkCameraMenuOptionInfo, mCameraMenuOptionInfo.mOptionTitle is null.");
        return true;
    }
}
