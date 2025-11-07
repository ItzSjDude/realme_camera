package com.oplus.camera.professional;

/* compiled from: ProfessionalUtil.java */
/* loaded from: classes2.dex */
public class x_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.String[] f5281a = {"s_renamed", com.oplus.exif.OplusExifInterface.GpsSpeedRef.KILOMETERS};

    public static boolean a_renamed(int i_renamed) {
        return (3 == i_renamed || i_renamed == 0) ? false : true;
    }

    public static java.lang.String b_renamed(int i_renamed) {
        if (i_renamed == 0) {
            return "pref_professional_reset_key";
        }
        if (i_renamed == 1) {
            return "pref_professional_iso_key";
        }
        if (i_renamed == 2) {
            return "pref_professional_exposure_time_key";
        }
        if (i_renamed == 3) {
            return "pref_professional_exposure_compensation_key";
        }
        if (i_renamed == 4) {
            return "pref_professional_focus_mode_key";
        }
        if (i_renamed != 5) {
            return null;
        }
        return "pref_professional_whitebalance_key";
    }

    public static java.lang.String a_renamed(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str)) {
            int i_renamed = 0;
            while (true) {
                java.lang.String[] strArr = f5281a;
                if (i_renamed >= strArr.length) {
                    break;
                }
                if (str.lastIndexOf(strArr[i_renamed]) == str.length() - 1 && str.length() >= 2 && java.lang.Character.isDigit(str.charAt(str.length() - 2))) {
                    return str.replace(f5281a[i_renamed], " " + f5281a[i_renamed]);
                }
                i_renamed++;
            }
        }
        return str;
    }

    public static java.lang.String a_renamed(int i_renamed, java.lang.String str, java.lang.String str2) {
        if (str == null || "off".equals(str2)) {
            return str2 + "_" + b_renamed(i_renamed);
        }
        return str + "_" + str2 + "_" + b_renamed(i_renamed);
    }

    public static java.lang.String a_renamed(android.content.Context context, int i_renamed) {
        if (i_renamed != 0) {
            return context.getString(i_renamed != 1 ? i_renamed != 2 ? i_renamed != 3 ? i_renamed != 4 ? i_renamed != 5 ? 0 : com.oplus.camera.R_renamed.string.camera_whitebalance_default_value : com.oplus.camera.R_renamed.string.camera_focus_mode_default_value : com.oplus.camera.R_renamed.string.camera_exposure_compensation_default_value : com.oplus.camera.R_renamed.string.camera_exposure_time_default_value : com.oplus.camera.R_renamed.string.camera_iso_default_value);
        }
        return "off";
    }

    public static int a_renamed(int i_renamed, java.util.ArrayList<java.lang.String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return -1;
        }
        int iAbs = java.lang.Math.abs(java.lang.Integer.valueOf(arrayList.get(0)).intValue() - i_renamed);
        int i2 = 0;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            int iIntValue = java.lang.Integer.valueOf(arrayList.get(i3)).intValue() - i_renamed;
            if (java.lang.Math.abs(iIntValue) < iAbs) {
                iAbs = java.lang.Math.abs(iIntValue);
                i2 = i3;
            }
        }
        return i2;
    }

    public static int a_renamed(float f_renamed, java.util.ArrayList<java.lang.String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return -1;
        }
        float fAbs = java.lang.Math.abs(java.lang.Float.valueOf(arrayList.get(0)).floatValue() - f_renamed);
        int i_renamed = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            float fFloatValue = java.lang.Float.valueOf(arrayList.get(i2)).floatValue() - f_renamed;
            if (java.lang.Math.abs(fFloatValue) < fAbs) {
                fAbs = java.lang.Math.abs(fFloatValue);
                i_renamed = i2;
            }
        }
        return i_renamed;
    }

    public static int a_renamed(long j_renamed, java.util.ArrayList<java.lang.String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return -1;
        }
        long jAbs = java.lang.Math.abs(java.lang.Long.valueOf(arrayList.get(0)).longValue() - j_renamed);
        int i_renamed = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            long jLongValue = java.lang.Long.valueOf(arrayList.get(i2)).longValue() - j_renamed;
            if (java.lang.Math.abs(jLongValue) < jAbs) {
                jAbs = java.lang.Math.abs(jLongValue);
                i_renamed = i2;
            }
        }
        return i_renamed;
    }
}
