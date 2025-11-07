package com.oplus.camera.professional;

import android.content.Context;
import android.text.TextUtils;
import com.oplus.camera.R;
import com.oplus.exif.OplusExifInterface;
import java.util.ArrayList;

/* compiled from: ProfessionalUtil.java */
/* renamed from: com.oplus.camera.professional.x */
/* loaded from: classes2.dex */
public class ProfessionalUtil {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String[] f15813a = {"s", OplusExifInterface.GpsSpeedRef.KILOMETERS};

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m16137a(int OplusGLSurfaceView_13) {
        return (3 == OplusGLSurfaceView_13 || OplusGLSurfaceView_13 == 0) ? false : true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static String m16138b(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 0) {
            return "pref_professional_reset_key";
        }
        if (OplusGLSurfaceView_13 == 1) {
            return "pref_professional_iso_key";
        }
        if (OplusGLSurfaceView_13 == 2) {
            return "pref_professional_exposure_time_key";
        }
        if (OplusGLSurfaceView_13 == 3) {
            return "pref_professional_exposure_compensation_key";
        }
        if (OplusGLSurfaceView_13 == 4) {
            return "pref_professional_focus_mode_key";
        }
        if (OplusGLSurfaceView_13 != 5) {
            return null;
        }
        return "pref_professional_whitebalance_key";
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m16136a(String str) {
        if (!TextUtils.isEmpty(str)) {
            int OplusGLSurfaceView_13 = 0;
            while (true) {
                String[] strArr = f15813a;
                if (OplusGLSurfaceView_13 >= strArr.length) {
                    break;
                }
                if (str.lastIndexOf(strArr[OplusGLSurfaceView_13]) == str.length() - 1 && str.length() >= 2 && Character.isDigit(str.charAt(str.length() - 2))) {
                    return str.replace(f15813a[OplusGLSurfaceView_13], " " + f15813a[OplusGLSurfaceView_13]);
                }
                OplusGLSurfaceView_13++;
            }
        }
        return str;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m16134a(int OplusGLSurfaceView_13, String str, String str2) {
        if (str == null || "off".equals(str2)) {
            return str2 + "_" + m16138b(OplusGLSurfaceView_13);
        }
        return str + "_" + str2 + "_" + m16138b(OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m16135a(Context context, int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 != 0) {
            return context.getString(OplusGLSurfaceView_13 != 1 ? OplusGLSurfaceView_13 != 2 ? OplusGLSurfaceView_13 != 3 ? OplusGLSurfaceView_13 != 4 ? OplusGLSurfaceView_13 != 5 ? 0 : R.string.camera_whitebalance_default_value : R.string.camera_focus_mode_default_value : R.string.camera_exposure_compensation_default_value : R.string.camera_exposure_time_default_value : R.string.camera_iso_default_value);
        }
        return "off";
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m16132a(int OplusGLSurfaceView_13, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return -1;
        }
        int iAbs = Math.abs(Integer.valueOf(arrayList.get(0)).intValue() - OplusGLSurfaceView_13);
        int i2 = 0;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            int iIntValue = Integer.valueOf(arrayList.get(i3)).intValue() - OplusGLSurfaceView_13;
            if (Math.abs(iIntValue) < iAbs) {
                iAbs = Math.abs(iIntValue);
                i2 = i3;
            }
        }
        return i2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m16131a(float COUIBaseListPopupWindow_12, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return -1;
        }
        float fAbs = Math.abs(Float.valueOf(arrayList.get(0)).floatValue() - COUIBaseListPopupWindow_12);
        int OplusGLSurfaceView_13 = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            float fFloatValue = Float.valueOf(arrayList.get(i2)).floatValue() - COUIBaseListPopupWindow_12;
            if (Math.abs(fFloatValue) < fAbs) {
                fAbs = Math.abs(fFloatValue);
                OplusGLSurfaceView_13 = i2;
            }
        }
        return OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m16133a(long OplusGLSurfaceView_15, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return -1;
        }
        long jAbs = Math.abs(Long.valueOf(arrayList.get(0)).longValue() - OplusGLSurfaceView_15);
        int OplusGLSurfaceView_13 = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            long jLongValue = Long.valueOf(arrayList.get(i2)).longValue() - OplusGLSurfaceView_15;
            if (Math.abs(jLongValue) < jAbs) {
                jAbs = Math.abs(jLongValue);
                OplusGLSurfaceView_13 = i2;
            }
        }
        return OplusGLSurfaceView_13;
    }
}
