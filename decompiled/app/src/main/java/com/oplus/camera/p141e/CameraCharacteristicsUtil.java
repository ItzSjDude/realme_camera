package com.oplus.camera.p141e;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.text.TextUtils;
import android.util.SparseArray;
import com.oplus.camera.CameraLog;
import com.oplus.camera.MyApplication;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.screen.p163a.OutCaptureManager;
import com.oplus.camera.util.Util;
import com.oplus.ocs.camera.CameraDeviceInfo;
import com.oplus.ocs.camera.CameraUnitClient;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: CameraCharacteristicsUtil.java */
/* renamed from: com.oplus.camera.COUIBaseListPopupWindow_8.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class CameraCharacteristicsUtil {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final ArrayList<String> f13215a = new ArrayList<>();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final ArrayList<String> f13216b = new ArrayList<>();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final SparseArray<String> f13217c = new SparseArray<>();

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static final HashMap<String, OplusCameraCharacteristics> f13218d = new HashMap<>();

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static PlatformImplementations.kt_3 f13219e = null;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private static PlatformImplementations.kt_3 f13220f = null;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private static final Object f13221g = new Object();

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static boolean m12980c(int OplusGLSurfaceView_13) {
        return 100 == OplusGLSurfaceView_13 || 101 == OplusGLSurfaceView_13;
    }

    /* compiled from: CameraCharacteristicsUtil.java */
    /* renamed from: com.oplus.camera.COUIBaseListPopupWindow_8.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    public static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        public int f13229a = 0;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public int f13230b = 0;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public float f13231c = 0.0f;

        /* renamed from: IntrinsicsJvm.kt_5 */
        public float f13232d = 0.0f;

        /* renamed from: COUIBaseListPopupWindow_8 */
        public float f13233e = 0.0f;

        /* renamed from: COUIBaseListPopupWindow_12 */
        public float f13234f = 0.0f;

        /* renamed from: PlatformImplementations.kt_3 */
        public boolean m13004a() {
            return (this.f13229a == 0 && this.f13230b == 0 && Float.compare(this.f13231c, 0.0f) == 0 && Float.compare(this.f13232d, 0.0f) == 0 && Float.compare(this.f13233e, 0.0f) == 0 && Float.compare(this.f13234f, 0.0f) == 0) ? false : true;
        }

        public String toString() {
            return "mFrameWidth: " + this.f13229a + ", mFrameHeight: " + this.f13230b + ", mCameraFx: " + this.f13231c + ", mCameraFy: " + this.f13232d + ", mCameraCx: " + this.f13233e + ", mCameraCy: " + this.f13234f;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static synchronized void m12973a(Context context) {
        CameraLog.m12954a("CameraCharacteristicsUtil", "initialize");
        CameraLog.m12952a("initializeBokehParamAndCameraInfo");
        m12997t();
        m12972a();
        CameraLog.m12958b("initializeBokehParamAndCameraInfo");
        CameraLog.m12954a("CameraCharacteristicsUtil", "initialize, X");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static synchronized void m12972a() {
        if (f13217c.size() > 0) {
            return;
        }
        CameraUnitClient cameraUnitClientM11095f = MyApplication.m11095f();
        if (cameraUnitClientM11095f == null) {
            CameraLog.m12967f("CameraCharacteristicsUtil", "initCameraInfo, cameraUnitClient is null!");
            return;
        }
        List<String> allSupportCameraType = cameraUnitClientM11095f.getAllSupportCameraType();
        if (allSupportCameraType != null && allSupportCameraType.size() != 0) {
            Map<String, List<String>> allSupportCameraMode = cameraUnitClientM11095f.getAllSupportCameraMode();
            if (allSupportCameraMode != null && allSupportCameraMode.size() != 0) {
                for (String str : allSupportCameraType) {
                    List<String> list = allSupportCameraMode.get(str);
                    int iM12976b = m12976b(str);
                    if (-1 == iM12976b || list == null || list.size() <= 0) {
                        CameraLog.m12967f("CameraCharacteristicsUtil", "initCameraInfo, cameraType: " + str + ", cameraId: " + iM12976b);
                    } else {
                        boolean z = false;
                        CameraDeviceInfo cameraDeviceInfo = cameraUnitClientM11095f.getCameraDeviceInfo(str, list.get(0));
                        Object obj = cameraDeviceInfo != null ? cameraDeviceInfo.get(CameraCharacteristics.LENS_FACING) : null;
                        if (obj != null && ((Integer) obj).intValue() == 0) {
                            z = true;
                        }
                        CameraLog.m12962c("CameraCharacteristicsUtil", "initCameraInfo, cameraType: " + str + ", cameraId: " + iM12976b + ", isFront: " + z);
                        if (z) {
                            f13216b.add(str);
                        } else {
                            f13215a.add(str);
                        }
                        f13217c.put(iM12976b, str);
                    }
                }
                return;
            }
            CameraLog.m12967f("CameraCharacteristicsUtil", "initCameraInfo, modeMap is null!");
            return;
        }
        CameraLog.m12967f("CameraCharacteristicsUtil", "initCameraInfo, supportedList is null!");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00e2  */
    /* renamed from: IntrinsicsJvm.kt_4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int m12976b(java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 372
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p141e.CameraCharacteristicsUtil.m12976b(java.lang.String):int");
    }

    /* renamed from: t */
    private static void m12997t() {
        if (f13219e == null || f13220f == null) {
            CameraLog.m12952a("fillBokehParam");
            byte[] bArrM24307a = Util.m24307a(new File("/persist/camera/stereoParams.bin"));
            if (f13219e == null) {
                f13219e = new PlatformImplementations.kt_3();
            }
            f13219e.f13230b = Util.m24447f(bArrM24307a, 4130, 4133);
            f13219e.f13229a = Util.m24447f(bArrM24307a, 4134, 4137);
            f13219e.f13231c = Util.m24365b(bArrM24307a, 4138);
            f13219e.f13232d = Util.m24365b(bArrM24307a, 4142);
            f13219e.f13233e = Util.m24365b(bArrM24307a, 4146);
            f13219e.f13234f = Util.m24365b(bArrM24307a, 4150);
            if (f13220f == null) {
                f13220f = new PlatformImplementations.kt_3();
            }
            f13220f.f13230b = Util.m24447f(bArrM24307a, 17, 20);
            f13220f.f13229a = Util.m24447f(bArrM24307a, 21, 24);
            f13220f.f13231c = Util.m24365b(bArrM24307a, 25);
            f13220f.f13232d = Util.m24365b(bArrM24307a, 29);
            f13220f.f13233e = Util.m24365b(bArrM24307a, 33);
            f13220f.f13234f = Util.m24365b(bArrM24307a, 37);
            CameraLog.m12958b("fillBokehParam");
            CameraLog.m12954a("CameraCharacteristicsUtil", "fillBokehParam, sMasterCalibParam: " + f13219e.toString() + ", sDepthCalibParam: " + f13220f.toString());
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static PlatformImplementations.kt_3 m12977b() {
        return f13219e;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static PlatformImplementations.kt_3 m12979c() {
        return f13220f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static synchronized OplusCameraCharacteristics m12971a(String str, int OplusGLSurfaceView_13) {
        String strM12978b = m12978b(OplusGLSurfaceView_13);
        if (strM12978b == null || CameraUnitClient.CameraType.REAR_MAIN_FRONT_MAIN.equals(strM12978b) || CameraUnitClient.CameraType.REAR_MAIN_FRONT_SUB.equals(strM12978b)) {
            CameraLog.m12967f("CameraCharacteristicsUtil", "getCameraInfo, cameraType is null or cameraType equals REAR_MAIN_FRONT_MAIN, logicId: " + OplusGLSurfaceView_13);
            strM12978b = CameraUnitClient.CameraType.REAR_MAIN;
        }
        if (TextUtils.isEmpty(str)) {
            str = ApsConstant.CAPTURE_MODE_COMMON;
        }
        String strM24475l = Util.m24475l(str);
        String str2 = strM24475l + "_" + strM12978b;
        OplusCameraCharacteristics c2698h = f13218d.get(str2);
        if (c2698h == null) {
            CameraUnitClient cameraUnitClientM11095f = MyApplication.m11095f();
            if (cameraUnitClientM11095f == null) {
                CameraLog.m12967f("CameraCharacteristicsUtil", "getCameraInfo, cameraUnitClient is null!");
                return null;
            }
            CameraDeviceInfo cameraDeviceInfo = cameraUnitClientM11095f.getCameraDeviceInfo(strM12978b, strM24475l);
            c2698h = new OplusCameraCharacteristics(cameraDeviceInfo);
            f13218d.put(str2, c2698h);
            CameraLog.m12959b("CameraCharacteristicsUtil", "getCameraInfo, key: " + str2 + ", cameraDeviceInfo: " + cameraDeviceInfo);
        }
        return c2698h;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m12969a(OplusCameraCharacteristics c2698h, int OplusGLSurfaceView_13) {
        if (c2698h == null) {
            return 0;
        }
        if (c2698h.m13267c() == 0) {
            return (360 - ((c2698h.m13264b() + OplusGLSurfaceView_13) % 360)) % 360;
        }
        return ((c2698h.m13264b() - OplusGLSurfaceView_13) + 360) % 360;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m12968a(OplusCameraCharacteristics c2698h) {
        if (c2698h != null) {
            return c2698h.m13264b();
        }
        return 0;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static int m12975b(OplusCameraCharacteristics c2698h, int OplusGLSurfaceView_13) {
        int iM13264b;
        if (c2698h == null) {
            iM13264b = 0;
        } else if (OplusGLSurfaceView_13 != -1) {
            if (c2698h.m13267c() == 0 || OutCaptureManager.m16423g()) {
                iM13264b = ((c2698h.m13264b() - OplusGLSurfaceView_13) + 360) % 360;
            } else {
                iM13264b = (c2698h.m13264b() + OplusGLSurfaceView_13) % 360;
            }
        } else {
            iM13264b = c2698h.m13264b();
        }
        CameraLog.m12954a("CameraCharacteristicsUtil", "getJpegOrientation, orientation: " + OplusGLSurfaceView_13 + ", rotation: " + iM13264b + ", characteristics: " + c2698h);
        return iM13264b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m12974a(int OplusGLSurfaceView_13) {
        return f13216b.contains(m12978b(OplusGLSurfaceView_13));
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static boolean m12981d() {
        return f13215a.size() >= 3;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static boolean m12982e() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_FRONT_DUAL_CAMERA_SUPPORT);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public static boolean m12983f() {
        return f13215a.contains(CameraUnitClient.CameraType.REAR_SAT);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public static boolean m12984g() {
        return f13215a.contains(CameraUnitClient.CameraType.REAR_WIDE);
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public static int m12985h() {
        int iIndexOfValue;
        int iIndexOfValue2 = f13217c.indexOfValue(CameraUnitClient.CameraType.REAR_MAIN);
        if (iIndexOfValue2 >= 0) {
            return f13217c.keyAt(iIndexOfValue2);
        }
        if (f13215a.size() <= 0 || (iIndexOfValue = f13217c.indexOfValue(f13215a.get(0))) < 0) {
            return 0;
        }
        return f13217c.keyAt(iIndexOfValue);
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public static int m12986i() {
        int iIndexOfValue;
        if (Util.m24451g() == 0) {
            CameraLog.m12954a("CameraCharacteristicsUtil", "getFrontMainCameraId, id_renamed: 4");
            return 4;
        }
        int iIndexOfValue2 = f13217c.indexOfValue(CameraUnitClient.CameraType.FRONT_MAIN);
        if (iIndexOfValue2 >= 0) {
            return f13217c.keyAt(iIndexOfValue2);
        }
        if (f13216b.size() <= 0 || (iIndexOfValue = f13217c.indexOfValue(f13216b.get(0))) < 0) {
            return 0;
        }
        return f13217c.keyAt(iIndexOfValue);
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public static int m12987j() {
        int iIndexOfValue = f13217c.indexOfValue(CameraUnitClient.CameraType.REAR_WIDE);
        if (iIndexOfValue >= 0) {
            return f13217c.keyAt(iIndexOfValue);
        }
        if (f13215a.size() <= 2) {
            return 0;
        }
        SparseArray<String> sparseArray = f13217c;
        ArrayList<String> arrayList = f13215a;
        int iIndexOfValue2 = sparseArray.indexOfValue(arrayList.get(arrayList.size() - 2));
        if (iIndexOfValue2 >= 0) {
            return f13217c.keyAt(iIndexOfValue2);
        }
        return 0;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public static int m12988k() {
        int iIndexOfValue = f13217c.indexOfValue(CameraUnitClient.CameraType.FRONT_WIDE);
        if (iIndexOfValue >= 0) {
            int iKeyAt = f13217c.keyAt(iIndexOfValue);
            CameraLog.m12954a("CameraCharacteristicsUtil", "getFrontSubCameraId, id_renamed: " + iKeyAt);
            return iKeyAt;
        }
        if (f13216b.size() > 2) {
            SparseArray<String> sparseArray = f13217c;
            ArrayList<String> arrayList = f13216b;
            int iIndexOfValue2 = sparseArray.indexOfValue(arrayList.get(arrayList.size() - 2));
            return iIndexOfValue2 >= 0 ? f13217c.keyAt(iIndexOfValue2) : m12986i();
        }
        return m12986i();
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public static int m12989l() {
        int iIndexOfValue = f13217c.indexOfValue(CameraUnitClient.CameraType.REAR_PORTRAIT);
        if (iIndexOfValue >= 0) {
            return f13217c.keyAt(iIndexOfValue);
        }
        if (f13215a.size() <= 1) {
            return 0;
        }
        SparseArray<String> sparseArray = f13217c;
        ArrayList<String> arrayList = f13215a;
        int iIndexOfValue2 = sparseArray.indexOfValue(arrayList.get(arrayList.size() - 1));
        if (iIndexOfValue2 >= 0) {
            return f13217c.keyAt(iIndexOfValue2);
        }
        return 0;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public static int m12990m() {
        int iIndexOfValue = f13217c.indexOfValue(CameraUnitClient.CameraType.REAR_SECOND_PORTRAIT);
        if (iIndexOfValue >= 0) {
            return f13217c.keyAt(iIndexOfValue);
        }
        return 0;
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public static int m12991n() {
        int iIndexOfValue = f13217c.indexOfValue(CameraUnitClient.CameraType.FRONT_DUAL);
        if (iIndexOfValue >= 0) {
            return f13217c.keyAt(iIndexOfValue);
        }
        if (f13216b.size() <= 1) {
            return 0;
        }
        SparseArray<String> sparseArray = f13217c;
        ArrayList<String> arrayList = f13216b;
        int iIndexOfValue2 = sparseArray.indexOfValue(arrayList.get(arrayList.size() - 1));
        return iIndexOfValue2 >= 0 ? f13217c.keyAt(iIndexOfValue2) : m12986i();
    }

    /* renamed from: o */
    public static int m12992o() {
        int iIndexOfValue = f13217c.indexOfValue(CameraUnitClient.CameraType.REAR_TELE);
        if (iIndexOfValue >= 0) {
            return f13217c.keyAt(iIndexOfValue);
        }
        return 0;
    }

    /* renamed from: p */
    public static int m12993p() {
        int iIndexOfValue = f13217c.indexOfValue(CameraUnitClient.CameraType.REAR_SAT);
        if (iIndexOfValue >= 0) {
            return f13217c.keyAt(iIndexOfValue);
        }
        return 0;
    }

    /* renamed from: q */
    public static int m12994q() {
        int iIndexOfValue = f13217c.indexOfValue(CameraUnitClient.CameraType.REAR_MICROSCOPE);
        if (iIndexOfValue >= 0) {
            return f13217c.keyAt(iIndexOfValue);
        }
        return 0;
    }

    /* renamed from: r */
    public static int m12995r() {
        int iIndexOfValue = f13217c.indexOfValue(CameraUnitClient.CameraType.REAR_MACRO);
        if (iIndexOfValue >= 0) {
            return f13217c.keyAt(iIndexOfValue);
        }
        return 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m12970a(String str) {
        int iIndexOfValue = f13217c.indexOfValue(str);
        if (iIndexOfValue >= 0) {
            return f13217c.keyAt(iIndexOfValue);
        }
        return 0;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static String m12978b(int OplusGLSurfaceView_13) {
        String str = f13217c.get(OplusGLSurfaceView_13);
        CameraLog.m12959b("CameraCharacteristicsUtil", "getCameraType, cameraType: " + str + ", cameraId: " + OplusGLSurfaceView_13);
        return str;
    }

    /* renamed from: s */
    public static int m12996s() {
        int iIndexOfValue = f13217c.indexOfValue(CameraUnitClient.CameraType.REAR_MAIN_FRONT_MAIN);
        if (Util.m24451g() == 0) {
            iIndexOfValue = f13217c.indexOfValue(CameraUnitClient.CameraType.REAR_MAIN_FRONT_SUB);
        }
        if (iIndexOfValue >= 0) {
            return f13217c.keyAt(iIndexOfValue);
        }
        return 0;
    }
}
