package com.oplus.camera.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.location.Address;
import android.location.Location;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.oplus.camera.CameraLog;
import com.oplus.camera.LocationManager;
import com.oplus.camera.MyApplication;
import com.oplus.camera.R;
import com.oplus.camera.p153l.RegionCommonFeatureAdapter;
import com.oplus.camera.statistics.CameraStatisticsUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LocationHelper.java */
/* renamed from: com.oplus.camera.util.COUIBaseListPopupWindow_10 */
/* loaded from: classes2.dex */
public class LocationHelper {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final ArrayList<String> f23072a = new ArrayList<>(Arrays.asList("guizhou", "gansu", "qinghai", "hainan"));

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final ArrayList<String> f23073b = new ArrayList<>(Arrays.asList("thailand"));

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final ArrayList<String> f23074c = new ArrayList<>(Arrays.asList("goa", "tokyo", "tôkyô", "kyoto", "kyôto", "xinjiang", "tibet"));

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static final ArrayList<String> f23075d = new ArrayList<>(Arrays.asList("xinjiang uygur zizhiqu", "xizang zizhiqu"));

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static final AtomicBoolean f23076e = new AtomicBoolean(false);

    /* renamed from: COUIBaseListPopupWindow_12 */
    private static final PlatformImplementations.kt_3 f23077f = new PlatformImplementations.kt_3();

    /* renamed from: PlatformImplementations.kt_3 */
    public static LocationManager.PlatformImplementations.kt_3 m24549a(Context context, Location location) {
        Address address = null;
        if (location == null || context == null) {
            return null;
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            CameraLog.m12966e("LocationHelper", "parceLastKnownLocation, geo is null");
            return null;
        }
        Parcelable parcelable = extras.getParcelable("address");
        if (parcelable instanceof Address) {
            address = (Address) parcelable;
            CameraLog.m12959b("LocationHelper", "parceLastKnownLocation");
        }
        return m24550a(address);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static LocationManager.PlatformImplementations.kt_3 m24550a(Address address) {
        if (address == null) {
            CameraLog.m12966e("LocationHelper", "getCameraAddress, address is null");
            return null;
        }
        LocationManager.PlatformImplementations.kt_3 aVar = new LocationManager.PlatformImplementations.kt_3();
        aVar.m16185a(address.getCountryName());
        aVar.m16186b(address.getAdminArea());
        aVar.m16187c(address.getSubAdminArea());
        aVar.m16188d(address.getLocality());
        aVar.m16189e(address.getSubLocality());
        aVar.m16190f(address.getThoroughfare());
        aVar.m16191g(address.getSubThoroughfare());
        aVar.m16192h(address.getCountryCode());
        return aVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m24551a(Context context, LocationManager.PlatformImplementations.kt_3 aVar) {
        String strM24570g;
        if (aVar == null) {
            CameraLog.m12954a("LocationHelper", "getAddressInfoByAddress address is null");
            return "";
        }
        if (m24562d(context, aVar) || m24566e(context, aVar)) {
            return aVar.f15841c;
        }
        if (m24569f(context, aVar)) {
            return context.getResources().getString(R.string.camera_hongkong_shown);
        }
        if (m24559c(context, aVar)) {
            return context.getResources().getString(R.string.camera_macao_shown);
        }
        if (aVar.f15845g != null && aVar.f15844f != null && aVar.f15843e != null) {
            aVar.f15842d = null;
        }
        if (!Util.m24348ak()) {
            strM24570g = RegionCommonFeatureAdapter.m14522a(context, aVar, f23077f.f23080c, f23077f.f23081d, f23076e.get() ? f23077f.f23079b : null);
        } else {
            strM24570g = m24570g(context, aVar);
        }
        CameraLog.m12959b("LocationHelper", "getAdressInfoByAddress, currentAdress: " + strM24570g);
        return strM24570g;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private static String m24570g(Context context, LocationManager.PlatformImplementations.kt_3 aVar) {
        StringBuilder sb = new StringBuilder();
        String[] strArr = {aVar.f15842d, aVar.f15843e, aVar.f15844f, aVar.f15845g};
        String[] strArr2 = {aVar.f15843e, aVar.f15844f};
        if (m24556b(context, aVar)) {
            strArr = strArr2;
        } else if (!TextUtils.isEmpty(aVar.f15844f) || !TextUtils.isEmpty(aVar.f15843e) || !TextUtils.isEmpty(aVar.f15842d)) {
            strArr[3] = null;
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                if (!sb.toString().isEmpty()) {
                    sb.append(", ");
                }
                sb.append(str);
            }
        }
        if (TextUtils.isEmpty(sb.toString())) {
            for (String str2 : new String[]{aVar.f15839a, aVar.f15840b, aVar.f15841c}) {
                if (!TextUtils.isEmpty(str2)) {
                    if (!sb.toString().isEmpty()) {
                        sb.append(", ");
                    }
                    sb.append(str2);
                }
            }
        }
        return sb.toString();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static boolean m24556b(Context context, LocationManager.PlatformImplementations.kt_3 aVar) throws Resources.NotFoundException {
        if (aVar == null) {
            return false;
        }
        if ("TW".equals(aVar.f15846h)) {
            return true;
        }
        String string = context.getResources().getString(R.string.camera_taiwan);
        return (!TextUtils.isEmpty(aVar.f15845g) && aVar.f15845g.contains(string)) || (!TextUtils.isEmpty(aVar.f15844f) && aVar.f15844f.contains(string));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m24552a(LocationManager.PlatformImplementations.kt_3 aVar) {
        CameraLog.m12959b("LocationHelper", "getCurrentCity, mCameraAddress, " + aVar);
        if (m24554a(aVar.f15844f.toLowerCase()) || m24563d(aVar.f15844f.toLowerCase())) {
            return aVar.f15844f;
        }
        if (m24557b(aVar.f15845g.toLowerCase())) {
            return aVar.f15845g;
        }
        if (m24560c(aVar.f15844f.toLowerCase())) {
            return aVar.f15844f;
        }
        if (!TextUtils.isEmpty(aVar.f15842d)) {
            return aVar.f15842d;
        }
        if (!TextUtils.isEmpty(aVar.f15843e)) {
            return aVar.f15843e;
        }
        return aVar.f15844f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean m24554a(String str) {
        if (str == null) {
            return false;
        }
        return f23072a.contains(str);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static boolean m24557b(String str) {
        if (str == null) {
            return false;
        }
        return f23073b.contains(str);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static boolean m24560c(String str) {
        if (str == null) {
            return false;
        }
        return f23074c.contains(str);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static boolean m24563d(String str) {
        if (str == null) {
            return false;
        }
        return f23075d.contains(str);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static boolean m24559c(Context context, LocationManager.PlatformImplementations.kt_3 aVar) throws Resources.NotFoundException {
        if (aVar == null) {
            return false;
        }
        if ("MO".equals(aVar.f15846h)) {
            return true;
        }
        Resources resources = context.getResources();
        String string = resources.getString(R.string.camera_macao);
        if ((!TextUtils.isEmpty(aVar.f15845g) && aVar.f15845g.contains(string)) || (!TextUtils.isEmpty(aVar.f15844f) && aVar.f15844f.contains(string))) {
            return true;
        }
        for (String str : resources.getStringArray(R.array.location_mo)) {
            if ((!TextUtils.isEmpty(aVar.f15845g) && aVar.f15845g.contains(str)) || (!TextUtils.isEmpty(aVar.f15844f) && aVar.f15844f.contains(str))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static boolean m24562d(Context context, LocationManager.PlatformImplementations.kt_3 aVar) throws Resources.NotFoundException {
        Resources resources = context.getResources();
        for (String str : resources.getStringArray(R.array.fujian_to_match)) {
            if (!TextUtils.isEmpty(aVar.f15844f) && aVar.f15844f.contains(str)) {
                for (String str2 : resources.getStringArray(R.array.kinmen_to_match)) {
                    if (!TextUtils.isEmpty(aVar.f15841c) && aVar.f15841c.contains(str2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static boolean m24566e(Context context, LocationManager.PlatformImplementations.kt_3 aVar) throws Resources.NotFoundException {
        Resources resources = context.getResources();
        for (String str : resources.getStringArray(R.array.fujian_to_match)) {
            if (!TextUtils.isEmpty(aVar.f15844f) && aVar.f15844f.contains(str)) {
                for (String str2 : resources.getStringArray(R.array.lianjiang_to_match)) {
                    if (!TextUtils.isEmpty(aVar.f15841c) && aVar.f15841c.contains(str2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public static boolean m24569f(Context context, LocationManager.PlatformImplementations.kt_3 aVar) throws Resources.NotFoundException {
        if (aVar == null) {
            return false;
        }
        if ("HK".equals(aVar.f15846h)) {
            return true;
        }
        Resources resources = context.getResources();
        String string = resources.getString(R.string.camera_hongkong);
        if ((!TextUtils.isEmpty(aVar.f15845g) && aVar.f15845g.contains(string)) || (!TextUtils.isEmpty(aVar.f15844f) && aVar.f15844f.contains(string))) {
            return true;
        }
        for (String str : resources.getStringArray(R.array.location_hk)) {
            if ((!TextUtils.isEmpty(aVar.f15845g) && aVar.f15845g.contains(str)) || (!TextUtils.isEmpty(aVar.f15844f) && aVar.f15844f.contains(str))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24553a() {
        Util.m24279a(new Runnable() { // from class: com.oplus.camera.util.COUIBaseListPopupWindow_10.1
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                try {
                    CameraLog.m12954a("LocationHelper", "parseSensorAreaList");
                    if (!LocationHelper.f23076e.getAndSet(false)) {
                        LocationHelper.m24564e();
                    }
                    LocationHelper.m24567f();
                    LocationHelper.f23076e.set(true);
                    CameraLog.m12954a("LocationHelper", "parseSensorAreaList X");
                } catch (Exception COUIBaseListPopupWindow_8) {
                    LocationHelper.f23076e.set(false);
                    COUIBaseListPopupWindow_8.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_8 */
    public static void m24564e() throws Throwable {
        CameraLog.m12954a("LocationHelper", "parseSensorAreaConfigFromAsset");
        String strM24429d = Util.m24429d("sensor_area.json");
        String strM24429d2 = Util.m24429d("sensor_area_replace.json");
        m24565e(strM24429d);
        m24568f(strM24429d2);
        CameraLog.m12954a("LocationHelper", "parseSensorAreaConfigFromAsset X");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_12 */
    public static void m24567f() throws JSONException, NumberFormatException {
        SharedPreferences sharedPreferences = MyApplication.m11092d().getSharedPreferences("rom_update_info", 0);
        if (sharedPreferences == null) {
            return;
        }
        m24565e(sharedPreferences.getString("sensor_area", null));
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static void m24565e(String str) throws JSONException, NumberFormatException {
        if (str == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject(str);
        int OplusGLSurfaceView_13 = Integer.parseInt(jSONObject.getString(CameraStatisticsUtil.RUS_FILE_VERSION));
        CameraLog.m12954a("LocationHelper", "updateSensorAreaConfigFromJson, sSensorAreaConfig.version: " + f23077f.f23078a + ", jsonVersion: " + OplusGLSurfaceView_13);
        if (f23077f.f23078a >= OplusGLSurfaceView_13) {
            return;
        }
        JSONArray jSONArray = jSONObject.getJSONArray("areas");
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONArray jSONArray2 = jSONArray.getJSONObject(i2).getJSONArray("disputingParty");
            int length2 = jSONArray2.length();
            for (int i3 = 0; i3 < length2; i3++) {
                arrayList.add(jSONArray2.getString(i3));
            }
        }
        f23077f.f23078a = OplusGLSurfaceView_13;
        f23077f.f23079b = arrayList;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private static void m24568f(String str) throws JSONException {
        if (str == null) {
            return;
        }
        JSONArray jSONArray = new JSONObject(str).getJSONArray("areas");
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        int length = jSONArray.length();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length; OplusGLSurfaceView_13++) {
            String lowerCase = jSONArray.getJSONObject(OplusGLSurfaceView_13).getString("keyWords").toLowerCase();
            String string = jSONArray.getJSONObject(OplusGLSurfaceView_13).getString("areaReplace");
            String string2 = jSONArray.getJSONObject(OplusGLSurfaceView_13).getString("areaReplaceExport");
            map.put(lowerCase, string);
            map2.put(lowerCase, string2);
        }
        f23077f.f23080c = map;
        f23077f.f23081d = map2;
    }

    /* compiled from: LocationHelper.java */
    /* renamed from: com.oplus.camera.util.COUIBaseListPopupWindow_10$PlatformImplementations.kt_3 */
    private static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        private int f23078a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private List<String> f23079b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private Map<String, String> f23080c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private Map<String, String> f23081d;

        private PlatformImplementations.kt_3() {
            this.f23078a = -1;
            this.f23079b = new ArrayList();
            this.f23080c = new HashMap();
            this.f23081d = new HashMap();
        }
    }
}
