package com.oplus.camera.p153l;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.coui.appcompat.dialog.app.COUIAlertDialog;
import com.coui.appcompat.preference.COUIJumpPreference;
import com.coui.appcompat.preference.COUIPreferenceCategory;
import com.oplus.camera.CameraLog;
import com.oplus.camera.LocationManager;
import com.oplus.camera.ComboPreferences;
import com.oplus.camera.R;
import com.oplus.camera.capmode.VideoMode;
import com.oplus.camera.statistics.model.CaptureMsgData;
import com.oplus.camera.statistics.model.VideoRecordMsgData;
import com.oplus.camera.util.Util;
import com.oplus.p188d.AppSettings;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* compiled from: RegionCommonFeatureAdapter.java */
/* renamed from: com.oplus.camera.OplusGLSurfaceView_14.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class RegionCommonFeatureAdapter {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String f14504a = "IntrinsicsJvm.kt_3";

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m14524a(Activity activity) {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m14525a(Activity activity, boolean z, ComboPreferences comboPreferences, int OplusGLSurfaceView_13) {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m14529a(CaptureMsgData captureMsgData, boolean z, LocationManager c2909q) {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m14530a(VideoRecordMsgData videoRecordMsgData, boolean z, Location location) {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m14531a() {
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static boolean m14533b() {
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static boolean m14534c() {
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static boolean m14535d() {
        return true;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static boolean m14536e() {
        return false;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public static boolean m14537f() {
        return false;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public static boolean m14538g() {
        return false;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public static boolean m14539h() {
        return false;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public static boolean m14540i() {
        return false;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public static String m14541j() {
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m14526a(ContentResolver contentResolver, int OplusGLSurfaceView_13) {
        AppSettings.IntrinsicsJvm.kt_5.m24996c(contentResolver, VideoMode.KEY_IS_CAMERA_RECORDING, OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m14523a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return String.valueOf(str.toLowerCase(Locale.US).hashCode());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m14522a(Context context, LocationManager.PlatformImplementations.kt_3 aVar, Map<String, String> map, Map<String, String> map2, List<String> list) {
        return m14521a(context, aVar, map2, list);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static String m14521a(Context context, LocationManager.PlatformImplementations.kt_3 aVar, Map<String, String> map, List<String> list) throws Resources.NotFoundException {
        StringBuilder sb;
        StringBuilder sb2 = new StringBuilder();
        int OplusGLSurfaceView_13 = 0;
        String[] strArr = {aVar.f15842d, aVar.f15843e, aVar.f15844f};
        String[] strArr2 = {aVar.f15843e, aVar.f15844f, aVar.f15845g};
        boolean zM24496t = Util.m24496t(Util.m24472l());
        if (zM24496t) {
            strArr = new String[]{aVar.f15844f, aVar.f15843e, aVar.f15842d};
            strArr2 = new String[]{aVar.f15845g, aVar.f15844f, aVar.f15843e};
        }
        boolean zM14532a = m14532a(context, aVar);
        if (zM14532a) {
            String string = context.getResources().getString(R.string.camera_taiwan_shown);
            if (TextUtils.isEmpty(aVar.f15843e)) {
                return string;
            }
            if (zM24496t) {
                sb = new StringBuilder();
                sb.append(string);
                sb.append("，");
                string = aVar.f15843e;
            } else {
                sb = new StringBuilder();
                sb.append(aVar.f15843e);
                sb.append(",");
            }
            sb.append(string);
            return sb.toString();
        }
        if (zM14532a) {
            strArr = strArr2;
        }
        if (zM24496t) {
            int i2 = 0;
            for (int length = strArr.length - 1; length >= 0; length--) {
                String str = strArr[length];
                if (!TextUtils.isEmpty(str)) {
                    if (!zM14532a && 2 == i2) {
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
            for (String str2 : strArr) {
                if (!TextUtils.isEmpty(str2)) {
                    if (!zM14532a && 1 < i3) {
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
        if (TextUtils.isEmpty(sb2.toString())) {
            String[] strArr3 = {aVar.f15841c, aVar.f15845g};
            int length2 = strArr3.length;
            while (true) {
                if (OplusGLSurfaceView_13 >= length2) {
                    break;
                }
                String str3 = strArr3[OplusGLSurfaceView_13];
                if (!TextUtils.isEmpty(str3)) {
                    sb2.append(str3);
                    break;
                }
                OplusGLSurfaceView_13++;
            }
        }
        if (list == null) {
            CameraLog.m12954a(f14504a, "parseExportVersionAddress, sensor area is loading");
            return "";
        }
        String string2 = sb2.toString();
        for (String str4 : list) {
            if (string2.toLowerCase().contains(str4.toLowerCase())) {
                CameraLog.m12954a(f14504a, "parseExportVersionAddress, here is sensor area");
                return map.containsKey(str4.toLowerCase()) ? map.get(str4.toLowerCase()) : "";
            }
        }
        return string2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m14532a(Context context, LocationManager.PlatformImplementations.kt_3 aVar) throws Resources.NotFoundException {
        if (aVar == null) {
            return false;
        }
        if ("TW".equals(aVar.f15846h)) {
            return true;
        }
        Resources resources = context.getResources();
        String string = resources.getString(R.string.camera_taiwan);
        if ((!TextUtils.isEmpty(aVar.f15845g) && aVar.f15845g.contains(string)) || (!TextUtils.isEmpty(aVar.f15844f) && aVar.f15844f.contains(string))) {
            return true;
        }
        for (String str : resources.getStringArray(R.array.taiwan_to_match)) {
            if ((!TextUtils.isEmpty(aVar.f15845g) && aVar.f15845g.contains(str)) || (!TextUtils.isEmpty(aVar.f15844f) && aVar.f15844f.contains(str))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m14528a(COUIPreferenceCategory cOUIPreferenceCategory, COUIJumpPreference cOUIJumpPreference) {
        cOUIPreferenceCategory.m3871d(cOUIJumpPreference);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m14527a(Bundle bundle, COUIAlertDialog dialogInterfaceC1289b, COUIAlertDialog dialogInterfaceC1289b2, COUIAlertDialog dialogInterfaceC1289b3) {
        bundle.putBoolean("key_location_guide_dialog_show", dialogInterfaceC1289b != null && dialogInterfaceC1289b.isShowing());
    }
}
