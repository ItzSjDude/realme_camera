package com.oplus.camera.ui;

/* compiled from: CameraUITool.java */
/* loaded from: classes2.dex */
public class e_renamed {
    public static int a_renamed(java.lang.String str, java.util.ArrayList<com.oplus.camera.ui.menu.e_renamed> arrayList) {
        if (str == null || arrayList == null) {
            return -1;
        }
        for (int i_renamed = 0; i_renamed < arrayList.size(); i_renamed++) {
            if (a_renamed(str, arrayList.get(i_renamed).c_renamed())) {
                return i_renamed;
            }
        }
        return -1;
    }

    public static boolean a_renamed(java.lang.Object obj, java.lang.Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static boolean b_renamed(java.lang.String str, java.util.ArrayList<com.oplus.camera.ui.menu.e_renamed> arrayList) {
        if (str != null && arrayList != null) {
            for (int i_renamed = 0; i_renamed < arrayList.size(); i_renamed++) {
                if (a_renamed(str, arrayList.get(i_renamed).c_renamed())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean a_renamed(com.oplus.camera.ui.menu.b_renamed bVar) {
        if (bVar == null) {
            com.oplus.camera.e_renamed.a_renamed("CameraUITool", "checkCameraMenuOptionInfo, mCameraMenuOptionInfo is_renamed null.");
            return false;
        }
        if (bVar.getOptionKey() == null || bVar.getOptionKey().equals("")) {
            com.oplus.camera.e_renamed.a_renamed("CameraUITool", "checkCameraMenuOptionInfo, mCameraMenuOptionInfo.mOptionKey is_renamed null.");
            return false;
        }
        if (bVar.getOptionItems() == null || bVar.getOptionItems().size() <= 0) {
            com.oplus.camera.e_renamed.a_renamed("CameraUITool", "checkCameraMenuOptionInfo, mCameraMenuOptionInfo has no items.");
            return false;
        }
        if (bVar.getOptionTitle() != null && !bVar.getOptionTitle().equals("")) {
            return true;
        }
        com.oplus.camera.e_renamed.a_renamed("CameraUITool", "checkCameraMenuOptionInfo, mCameraMenuOptionInfo.mOptionTitle is_renamed null.");
        return true;
    }
}
