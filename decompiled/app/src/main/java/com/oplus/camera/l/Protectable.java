package com.oplus.camera.l_renamed;

/* compiled from: RegionCommonFeatureAdapter.java */
/* loaded from: classes2.dex */
public class c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.String f4789a = "c_renamed";

    public static void a_renamed(android.app.Activity activity) {
    }

    public static void a_renamed(android.app.Activity activity, boolean z_renamed, com.oplus.camera.ComboPreferences comboPreferences, int i_renamed) {
    }

    public static void a_renamed(com.oplus.camera.statistics.model.CaptureMsgData captureMsgData, boolean z_renamed, com.oplus.camera.q_renamed qVar) {
    }

    public static void a_renamed(com.oplus.camera.statistics.model.VideoRecordMsgData videoRecordMsgData, boolean z_renamed, android.location.Location location) {
    }

    public static boolean a_renamed() {
        return true;
    }

    public static boolean b_renamed() {
        return true;
    }

    public static boolean c_renamed() {
        return true;
    }

    public static boolean d_renamed() {
        return true;
    }

    public static boolean e_renamed() {
        return false;
    }

    public static boolean f_renamed() {
        return false;
    }

    public static boolean g_renamed() {
        return false;
    }

    public static boolean h_renamed() {
        return false;
    }

    public static boolean i_renamed() {
        return false;
    }

    public static java.lang.String j_renamed() {
        return null;
    }

    public static void a_renamed(android.content.ContentResolver contentResolver, int i_renamed) {
        com.oplus.d_renamed.a_renamed.d_renamed.c_renamed(contentResolver, com.oplus.camera.capmode.w_renamed.KEY_IS_CAMERA_RECORDING, i_renamed);
    }

    public static java.lang.String a_renamed(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        return java.lang.String.valueOf(str.toLowerCase(java.util.Locale.US).hashCode());
    }

    public static java.lang.String a_renamed(android.content.Context context, com.oplus.camera.q_renamed.a_renamed aVar, java.util.Map<java.lang.String, java.lang.String> map, java.util.Map<java.lang.String, java.lang.String> map2, java.util.List<java.lang.String> list) {
        return a_renamed(context, aVar, map2, list);
    }

    private static java.lang.String a_renamed(android.content.Context context, com.oplus.camera.q_renamed.a_renamed aVar, java.util.Map<java.lang.String, java.lang.String> map, java.util.List<java.lang.String> list) throws android.content.res.Resources.NotFoundException {
        java.lang.StringBuilder sb;
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        int i_renamed = 0;
        java.lang.String[] strArr = {aVar.d_renamed, aVar.e_renamed, aVar.f_renamed};
        java.lang.String[] strArr2 = {aVar.e_renamed, aVar.f_renamed, aVar.g_renamed};
        boolean zT = com.oplus.camera.util.Util.t_renamed(com.oplus.camera.util.Util.l_renamed());
        if (zT) {
            strArr = new java.lang.String[]{aVar.f_renamed, aVar.e_renamed, aVar.d_renamed};
            strArr2 = new java.lang.String[]{aVar.g_renamed, aVar.f_renamed, aVar.e_renamed};
        }
        boolean zA = a_renamed(context, aVar);
        if (zA) {
            java.lang.String string = context.getResources().getString(com.oplus.camera.R_renamed.string.camera_taiwan_shown);
            if (android.text.TextUtils.isEmpty(aVar.e_renamed)) {
                return string;
            }
            if (zT) {
                sb = new java.lang.StringBuilder();
                sb.append(string);
                sb.append("，");
                string = aVar.e_renamed;
            } else {
                sb = new java.lang.StringBuilder();
                sb.append(aVar.e_renamed);
                sb.append(",");
            }
            sb.append(string);
            return sb.toString();
        }
        if (zA) {
            strArr = strArr2;
        }
        if (zT) {
            int i2 = 0;
            for (int length = strArr.length - 1; length >= 0; length--) {
                java.lang.String str = strArr[length];
                if (!android.text.TextUtils.isEmpty(str)) {
                    if (!zA && 2 == i2) {
                        break;
                    }
                    if (!sb2.toString().isEmpty()) {
                        sb2.append("，");
                    }
                    sb2.append(str);
                    i2++;
                }
            }
        } else {
            int i3 = 0;
            for (java.lang.String str2 : strArr) {
                if (!android.text.TextUtils.isEmpty(str2)) {
                    if (!zA && 1 < i3) {
                        break;
                    }
                    if (!sb2.toString().isEmpty()) {
                        sb2.append(", ");
                    }
                    sb2.append(str2);
                    i3++;
                }
            }
        }
        if (android.text.TextUtils.isEmpty(sb2.toString())) {
            java.lang.String[] strArr3 = {aVar.f5294c, aVar.g_renamed};
            int length2 = strArr3.length;
            while (true) {
                if (i_renamed >= length2) {
                    break;
                }
                java.lang.String str3 = strArr3[i_renamed];
                if (!android.text.TextUtils.isEmpty(str3)) {
                    sb2.append(str3);
                    break;
                }
                i_renamed++;
            }
        }
        if (list == null) {
            com.oplus.camera.e_renamed.a_renamed(f4789a, "parseExportVersionAddress, sensor area is_renamed loading");
            return "";
        }
        java.lang.String string2 = sb2.toString();
        for (java.lang.String str4 : list) {
            if (string2.toLowerCase().contains(str4.toLowerCase())) {
                com.oplus.camera.e_renamed.a_renamed(f4789a, "parseExportVersionAddress, here is_renamed sensor area");
                return map.containsKey(str4.toLowerCase()) ? map.get(str4.toLowerCase()) : "";
            }
        }
        return string2;
    }

    public static boolean a_renamed(android.content.Context context, com.oplus.camera.q_renamed.a_renamed aVar) throws android.content.res.Resources.NotFoundException {
        if (aVar == null) {
            return false;
        }
        if ("TW".equals(aVar.h_renamed)) {
            return true;
        }
        android.content.res.Resources resources = context.getResources();
        java.lang.String string = resources.getString(com.oplus.camera.R_renamed.string.camera_taiwan);
        if ((!android.text.TextUtils.isEmpty(aVar.g_renamed) && aVar.g_renamed.contains(string)) || (!android.text.TextUtils.isEmpty(aVar.f_renamed) && aVar.f_renamed.contains(string))) {
            return true;
        }
        for (java.lang.String str : resources.getStringArray(com.oplus.camera.R_renamed.array.taiwan_to_match)) {
            if ((!android.text.TextUtils.isEmpty(aVar.g_renamed) && aVar.g_renamed.contains(str)) || (!android.text.TextUtils.isEmpty(aVar.f_renamed) && aVar.f_renamed.contains(str))) {
                return true;
            }
        }
        return false;
    }

    public static void a_renamed(com.coui.appcompat.preference.COUIPreferenceCategory cOUIPreferenceCategory, com.coui.appcompat.preference.COUIJumpPreference cOUIJumpPreference) {
        cOUIPreferenceCategory.d_renamed(cOUIJumpPreference);
    }

    public static void a_renamed(android.os.Bundle bundle, com.coui.appcompat.dialog.app.b_renamed bVar, com.coui.appcompat.dialog.app.b_renamed bVar2, com.coui.appcompat.dialog.app.b_renamed bVar3) {
        bundle.putBoolean("key_location_guide_dialog_show", bVar != null && bVar.isShowing());
    }
}
