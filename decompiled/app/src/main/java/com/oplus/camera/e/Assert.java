package com.oplus.camera.e_renamed;

/* compiled from: CameraCharacteristicsUtil.java */
/* loaded from: classes2.dex */
public class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.util.ArrayList<java.lang.String> f4411a = new java.util.ArrayList<>();

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final java.util.ArrayList<java.lang.String> f4412b = new java.util.ArrayList<>();

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final android.util.SparseArray<java.lang.String> f4413c = new android.util.SparseArray<>();
    private static final java.util.HashMap<java.lang.String, com.oplus.camera.e_renamed.h_renamed> d_renamed = new java.util.HashMap<>();
    private static com.oplus.camera.e_renamed.a_renamed.CameraCharacteristicsUtil_2 e_renamed = null;
    private static com.oplus.camera.e_renamed.a_renamed.CameraCharacteristicsUtil_2 f_renamed = null;
    private static final java.lang.Object g_renamed = new java.lang.Object();

    public static boolean c_renamed(int i_renamed) {
        return 100 == i_renamed || 101 == i_renamed;
    }

    /* compiled from: CameraCharacteristicsUtil.java */
    /* renamed from: com.oplus.camera.e_renamed.a_renamed$a_renamed, reason: collision with other inner class name */
    public static class CameraCharacteristicsUtil_2 {

        /* renamed from: a_renamed, reason: collision with root package name */
        public int f4417a = 0;

        /* renamed from: b_renamed, reason: collision with root package name */
        public int f4418b = 0;

        /* renamed from: c_renamed, reason: collision with root package name */
        public float f4419c = 0.0f;
        public float d_renamed = 0.0f;
        public float e_renamed = 0.0f;
        public float f_renamed = 0.0f;

        public boolean a_renamed() {
            return (this.f4417a == 0 && this.f4418b == 0 && java.lang.Float.compare(this.f4419c, 0.0f) == 0 && java.lang.Float.compare(this.d_renamed, 0.0f) == 0 && java.lang.Float.compare(this.e_renamed, 0.0f) == 0 && java.lang.Float.compare(this.f_renamed, 0.0f) == 0) ? false : true;
        }

        public java.lang.String toString() {
            return "mFrameWidth: " + this.f4417a + ", mFrameHeight: " + this.f4418b + ", mCameraFx: " + this.f4419c + ", mCameraFy: " + this.d_renamed + ", mCameraCx: " + this.e_renamed + ", mCameraCy: " + this.f_renamed;
        }
    }

    public static synchronized void a_renamed(android.content.Context context) {
        com.oplus.camera.e_renamed.a_renamed("CameraCharacteristicsUtil", "initialize");
        com.oplus.camera.e_renamed.a_renamed("initializeBokehParamAndCameraInfo");
        t_renamed();
        a_renamed();
        com.oplus.camera.e_renamed.b_renamed("initializeBokehParamAndCameraInfo");
        com.oplus.camera.e_renamed.a_renamed("CameraCharacteristicsUtil", "initialize, X_renamed");
    }

    public static synchronized void a_renamed() {
        if (f4413c.size() > 0) {
            return;
        }
        com.oplus.ocs.camera.CameraUnitClient cameraUnitClientF = com.oplus.camera.MyApplication.f_renamed();
        if (cameraUnitClientF == null) {
            com.oplus.camera.e_renamed.f_renamed("CameraCharacteristicsUtil", "initCameraInfo, cameraUnitClient is_renamed null!");
            return;
        }
        java.util.List<java.lang.String> allSupportCameraType = cameraUnitClientF.getAllSupportCameraType();
        if (allSupportCameraType != null && allSupportCameraType.size() != 0) {
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> allSupportCameraMode = cameraUnitClientF.getAllSupportCameraMode();
            if (allSupportCameraMode != null && allSupportCameraMode.size() != 0) {
                for (java.lang.String str : allSupportCameraType) {
                    java.util.List<java.lang.String> list = allSupportCameraMode.get(str);
                    int iB = b_renamed(str);
                    if (-1 == iB || list == null || list.size() <= 0) {
                        com.oplus.camera.e_renamed.f_renamed("CameraCharacteristicsUtil", "initCameraInfo, cameraType: " + str + ", cameraId: " + iB);
                    } else {
                        boolean z_renamed = false;
                        com.oplus.ocs.camera.CameraDeviceInfo cameraDeviceInfo = cameraUnitClientF.getCameraDeviceInfo(str, list.get(0));
                        java.lang.Object obj = cameraDeviceInfo != null ? cameraDeviceInfo.get(android.hardware.camera2.CameraCharacteristics.LENS_FACING) : null;
                        if (obj != null && ((java.lang.Integer) obj).intValue() == 0) {
                            z_renamed = true;
                        }
                        com.oplus.camera.e_renamed.c_renamed("CameraCharacteristicsUtil", "initCameraInfo, cameraType: " + str + ", cameraId: " + iB + ", isFront: " + z_renamed);
                        if (z_renamed) {
                            f4412b.add(str);
                        } else {
                            f4411a.add(str);
                        }
                        f4413c.put(iB, str);
                    }
                }
                return;
            }
            com.oplus.camera.e_renamed.f_renamed("CameraCharacteristicsUtil", "initCameraInfo, modeMap is_renamed null!");
            return;
        }
        com.oplus.camera.e_renamed.f_renamed("CameraCharacteristicsUtil", "initCameraInfo, supportedList is_renamed null!");
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:59:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int b_renamed(java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 372
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.e_renamed.a_renamed.b_renamed(java.lang.String):int");
    }

    private static void t_renamed() {
        if (e_renamed == null || f_renamed == null) {
            com.oplus.camera.e_renamed.a_renamed("fillBokehParam");
            byte[] bArrA = com.oplus.camera.util.Util.a_renamed(new java.io.File("/persist/camera/stereoParams.bin"));
            if (e_renamed == null) {
                e_renamed = new com.oplus.camera.e_renamed.a_renamed.CameraCharacteristicsUtil_2();
            }
            e_renamed.f4418b = com.oplus.camera.util.Util.f_renamed(bArrA, 4130, 4133);
            e_renamed.f4417a = com.oplus.camera.util.Util.f_renamed(bArrA, 4134, 4137);
            e_renamed.f4419c = com.oplus.camera.util.Util.b_renamed(bArrA, 4138);
            e_renamed.d_renamed = com.oplus.camera.util.Util.b_renamed(bArrA, 4142);
            e_renamed.e_renamed = com.oplus.camera.util.Util.b_renamed(bArrA, 4146);
            e_renamed.f_renamed = com.oplus.camera.util.Util.b_renamed(bArrA, 4150);
            if (f_renamed == null) {
                f_renamed = new com.oplus.camera.e_renamed.a_renamed.CameraCharacteristicsUtil_2();
            }
            f_renamed.f4418b = com.oplus.camera.util.Util.f_renamed(bArrA, 17, 20);
            f_renamed.f4417a = com.oplus.camera.util.Util.f_renamed(bArrA, 21, 24);
            f_renamed.f4419c = com.oplus.camera.util.Util.b_renamed(bArrA, 25);
            f_renamed.d_renamed = com.oplus.camera.util.Util.b_renamed(bArrA, 29);
            f_renamed.e_renamed = com.oplus.camera.util.Util.b_renamed(bArrA, 33);
            f_renamed.f_renamed = com.oplus.camera.util.Util.b_renamed(bArrA, 37);
            com.oplus.camera.e_renamed.b_renamed("fillBokehParam");
            com.oplus.camera.e_renamed.a_renamed("CameraCharacteristicsUtil", "fillBokehParam, sMasterCalibParam: " + e_renamed.toString() + ", sDepthCalibParam: " + f_renamed.toString());
        }
    }

    public static com.oplus.camera.e_renamed.a_renamed.CameraCharacteristicsUtil_2 b_renamed() {
        return e_renamed;
    }

    public static com.oplus.camera.e_renamed.a_renamed.CameraCharacteristicsUtil_2 c_renamed() {
        return f_renamed;
    }

    public static synchronized com.oplus.camera.e_renamed.h_renamed a_renamed(java.lang.String str, int i_renamed) {
        java.lang.String strB = b_renamed(i_renamed);
        if (strB == null || com.oplus.ocs.camera.CameraUnitClient.CameraType.REAR_MAIN_FRONT_MAIN.equals(strB) || com.oplus.ocs.camera.CameraUnitClient.CameraType.REAR_MAIN_FRONT_SUB.equals(strB)) {
            com.oplus.camera.e_renamed.f_renamed("CameraCharacteristicsUtil", "getCameraInfo, cameraType is_renamed null or cameraType equals REAR_MAIN_FRONT_MAIN, logicId: " + i_renamed);
            strB = com.oplus.ocs.camera.CameraUnitClient.CameraType.REAR_MAIN;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            str = com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_COMMON;
        }
        java.lang.String strL = com.oplus.camera.util.Util.l_renamed(str);
        java.lang.String str2 = strL + "_" + strB;
        com.oplus.camera.e_renamed.h_renamed hVar = d_renamed.get(str2);
        if (hVar == null) {
            com.oplus.ocs.camera.CameraUnitClient cameraUnitClientF = com.oplus.camera.MyApplication.f_renamed();
            if (cameraUnitClientF == null) {
                com.oplus.camera.e_renamed.f_renamed("CameraCharacteristicsUtil", "getCameraInfo, cameraUnitClient is_renamed null!");
                return null;
            }
            com.oplus.ocs.camera.CameraDeviceInfo cameraDeviceInfo = cameraUnitClientF.getCameraDeviceInfo(strB, strL);
            hVar = new com.oplus.camera.e_renamed.h_renamed(cameraDeviceInfo);
            d_renamed.put(str2, hVar);
            com.oplus.camera.e_renamed.b_renamed("CameraCharacteristicsUtil", "getCameraInfo, key: " + str2 + ", cameraDeviceInfo: " + cameraDeviceInfo);
        }
        return hVar;
    }

    public static int a_renamed(com.oplus.camera.e_renamed.h_renamed hVar, int i_renamed) {
        if (hVar == null) {
            return 0;
        }
        if (hVar.c_renamed() == 0) {
            return (360 - ((hVar.b_renamed() + i_renamed) % 360)) % 360;
        }
        return ((hVar.b_renamed() - i_renamed) + 360) % 360;
    }

    public static int a_renamed(com.oplus.camera.e_renamed.h_renamed hVar) {
        if (hVar != null) {
            return hVar.b_renamed();
        }
        return 0;
    }

    public static int b_renamed(com.oplus.camera.e_renamed.h_renamed hVar, int i_renamed) {
        int iB;
        if (hVar == null) {
            iB = 0;
        } else if (i_renamed != -1) {
            if (hVar.c_renamed() == 0 || com.oplus.camera.screen.a_renamed.b_renamed.g_renamed()) {
                iB = ((hVar.b_renamed() - i_renamed) + 360) % 360;
            } else {
                iB = (hVar.b_renamed() + i_renamed) % 360;
            }
        } else {
            iB = hVar.b_renamed();
        }
        com.oplus.camera.e_renamed.a_renamed("CameraCharacteristicsUtil", "getJpegOrientation, orientation: " + i_renamed + ", rotation: " + iB + ", characteristics: " + hVar);
        return iB;
    }

    public static boolean a_renamed(int i_renamed) {
        return f4412b.contains(b_renamed(i_renamed));
    }

    public static boolean d_renamed() {
        return f4411a.size() >= 3;
    }

    public static boolean e_renamed() {
        return com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_FRONT_DUAL_CAMERA_SUPPORT);
    }

    public static boolean f_renamed() {
        return f4411a.contains(com.oplus.ocs.camera.CameraUnitClient.CameraType.REAR_SAT);
    }

    public static boolean g_renamed() {
        return f4411a.contains(com.oplus.ocs.camera.CameraUnitClient.CameraType.REAR_WIDE);
    }

    public static int h_renamed() {
        int iIndexOfValue;
        int iIndexOfValue2 = f4413c.indexOfValue(com.oplus.ocs.camera.CameraUnitClient.CameraType.REAR_MAIN);
        if (iIndexOfValue2 >= 0) {
            return f4413c.keyAt(iIndexOfValue2);
        }
        if (f4411a.size() <= 0 || (iIndexOfValue = f4413c.indexOfValue(f4411a.get(0))) < 0) {
            return 0;
        }
        return f4413c.keyAt(iIndexOfValue);
    }

    public static int i_renamed() {
        int iIndexOfValue;
        if (com.oplus.camera.util.Util.g_renamed() == 0) {
            com.oplus.camera.e_renamed.a_renamed("CameraCharacteristicsUtil", "getFrontMainCameraId, id_renamed: 4");
            return 4;
        }
        int iIndexOfValue2 = f4413c.indexOfValue(com.oplus.ocs.camera.CameraUnitClient.CameraType.FRONT_MAIN);
        if (iIndexOfValue2 >= 0) {
            return f4413c.keyAt(iIndexOfValue2);
        }
        if (f4412b.size() <= 0 || (iIndexOfValue = f4413c.indexOfValue(f4412b.get(0))) < 0) {
            return 0;
        }
        return f4413c.keyAt(iIndexOfValue);
    }

    public static int j_renamed() {
        int iIndexOfValue = f4413c.indexOfValue(com.oplus.ocs.camera.CameraUnitClient.CameraType.REAR_WIDE);
        if (iIndexOfValue >= 0) {
            return f4413c.keyAt(iIndexOfValue);
        }
        if (f4411a.size() <= 2) {
            return 0;
        }
        android.util.SparseArray<java.lang.String> sparseArray = f4413c;
        java.util.ArrayList<java.lang.String> arrayList = f4411a;
        int iIndexOfValue2 = sparseArray.indexOfValue(arrayList.get(arrayList.size() - 2));
        if (iIndexOfValue2 >= 0) {
            return f4413c.keyAt(iIndexOfValue2);
        }
        return 0;
    }

    public static int k_renamed() {
        int iIndexOfValue = f4413c.indexOfValue(com.oplus.ocs.camera.CameraUnitClient.CameraType.FRONT_WIDE);
        if (iIndexOfValue >= 0) {
            int iKeyAt = f4413c.keyAt(iIndexOfValue);
            com.oplus.camera.e_renamed.a_renamed("CameraCharacteristicsUtil", "getFrontSubCameraId, id_renamed: " + iKeyAt);
            return iKeyAt;
        }
        if (f4412b.size() > 2) {
            android.util.SparseArray<java.lang.String> sparseArray = f4413c;
            java.util.ArrayList<java.lang.String> arrayList = f4412b;
            int iIndexOfValue2 = sparseArray.indexOfValue(arrayList.get(arrayList.size() - 2));
            return iIndexOfValue2 >= 0 ? f4413c.keyAt(iIndexOfValue2) : i_renamed();
        }
        return i_renamed();
    }

    public static int l_renamed() {
        int iIndexOfValue = f4413c.indexOfValue(com.oplus.ocs.camera.CameraUnitClient.CameraType.REAR_PORTRAIT);
        if (iIndexOfValue >= 0) {
            return f4413c.keyAt(iIndexOfValue);
        }
        if (f4411a.size() <= 1) {
            return 0;
        }
        android.util.SparseArray<java.lang.String> sparseArray = f4413c;
        java.util.ArrayList<java.lang.String> arrayList = f4411a;
        int iIndexOfValue2 = sparseArray.indexOfValue(arrayList.get(arrayList.size() - 1));
        if (iIndexOfValue2 >= 0) {
            return f4413c.keyAt(iIndexOfValue2);
        }
        return 0;
    }

    public static int m_renamed() {
        int iIndexOfValue = f4413c.indexOfValue(com.oplus.ocs.camera.CameraUnitClient.CameraType.REAR_SECOND_PORTRAIT);
        if (iIndexOfValue >= 0) {
            return f4413c.keyAt(iIndexOfValue);
        }
        return 0;
    }

    public static int n_renamed() {
        int iIndexOfValue = f4413c.indexOfValue(com.oplus.ocs.camera.CameraUnitClient.CameraType.FRONT_DUAL);
        if (iIndexOfValue >= 0) {
            return f4413c.keyAt(iIndexOfValue);
        }
        if (f4412b.size() <= 1) {
            return 0;
        }
        android.util.SparseArray<java.lang.String> sparseArray = f4413c;
        java.util.ArrayList<java.lang.String> arrayList = f4412b;
        int iIndexOfValue2 = sparseArray.indexOfValue(arrayList.get(arrayList.size() - 1));
        return iIndexOfValue2 >= 0 ? f4413c.keyAt(iIndexOfValue2) : i_renamed();
    }

    public static int o_renamed() {
        int iIndexOfValue = f4413c.indexOfValue(com.oplus.ocs.camera.CameraUnitClient.CameraType.REAR_TELE);
        if (iIndexOfValue >= 0) {
            return f4413c.keyAt(iIndexOfValue);
        }
        return 0;
    }

    public static int p_renamed() {
        int iIndexOfValue = f4413c.indexOfValue(com.oplus.ocs.camera.CameraUnitClient.CameraType.REAR_SAT);
        if (iIndexOfValue >= 0) {
            return f4413c.keyAt(iIndexOfValue);
        }
        return 0;
    }

    public static int q_renamed() {
        int iIndexOfValue = f4413c.indexOfValue(com.oplus.ocs.camera.CameraUnitClient.CameraType.REAR_MICROSCOPE);
        if (iIndexOfValue >= 0) {
            return f4413c.keyAt(iIndexOfValue);
        }
        return 0;
    }

    public static int r_renamed() {
        int iIndexOfValue = f4413c.indexOfValue(com.oplus.ocs.camera.CameraUnitClient.CameraType.REAR_MACRO);
        if (iIndexOfValue >= 0) {
            return f4413c.keyAt(iIndexOfValue);
        }
        return 0;
    }

    public static int a_renamed(java.lang.String str) {
        int iIndexOfValue = f4413c.indexOfValue(str);
        if (iIndexOfValue >= 0) {
            return f4413c.keyAt(iIndexOfValue);
        }
        return 0;
    }

    public static java.lang.String b_renamed(int i_renamed) {
        java.lang.String str = f4413c.get(i_renamed);
        com.oplus.camera.e_renamed.b_renamed("CameraCharacteristicsUtil", "getCameraType, cameraType: " + str + ", cameraId: " + i_renamed);
        return str;
    }

    public static int s_renamed() {
        int iIndexOfValue = f4413c.indexOfValue(com.oplus.ocs.camera.CameraUnitClient.CameraType.REAR_MAIN_FRONT_MAIN);
        if (com.oplus.camera.util.Util.g_renamed() == 0) {
            iIndexOfValue = f4413c.indexOfValue(com.oplus.ocs.camera.CameraUnitClient.CameraType.REAR_MAIN_FRONT_SUB);
        }
        if (iIndexOfValue >= 0) {
            return f4413c.keyAt(iIndexOfValue);
        }
        return 0;
    }
}
