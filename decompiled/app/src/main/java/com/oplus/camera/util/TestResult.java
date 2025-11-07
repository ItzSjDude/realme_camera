package com.oplus.camera.util;

/* compiled from: LocationHelper.java */
/* loaded from: classes2.dex */
public class h_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.util.ArrayList<java.lang.String> f7340a = new java.util.ArrayList<>(java.util.Arrays.asList("guizhou", "gansu", "qinghai", "hainan"));

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final java.util.ArrayList<java.lang.String> f7341b = new java.util.ArrayList<>(java.util.Arrays.asList("thailand"));

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final java.util.ArrayList<java.lang.String> f7342c = new java.util.ArrayList<>(java.util.Arrays.asList("goa", "tokyo", "tôkyô", "kyoto", "kyôto", "xinjiang", "tibet"));
    private static final java.util.ArrayList<java.lang.String> d_renamed = new java.util.ArrayList<>(java.util.Arrays.asList("xinjiang uygur zizhiqu", "xizang zizhiqu"));
    private static final java.util.concurrent.atomic.AtomicBoolean e_renamed = new java.util.concurrent.atomic.AtomicBoolean(false);
    private static final com.oplus.camera.util.h_renamed.a_renamed f_renamed = new com.oplus.camera.util.h_renamed.a_renamed();

    public static com.oplus.camera.q_renamed.a_renamed a_renamed(android.content.Context context, android.location.Location location) {
        android.location.Address address = null;
        if (location == null || context == null) {
            return null;
        }
        android.os.Bundle extras = location.getExtras();
        if (extras == null) {
            com.oplus.camera.e_renamed.e_renamed("LocationHelper", "parceLastKnownLocation, geo is_renamed null");
            return null;
        }
        android.os.Parcelable parcelable = extras.getParcelable("address");
        if (parcelable instanceof android.location.Address) {
            address = (android.location.Address) parcelable;
            com.oplus.camera.e_renamed.b_renamed("LocationHelper", "parceLastKnownLocation");
        }
        return a_renamed(address);
    }

    public static com.oplus.camera.q_renamed.a_renamed a_renamed(android.location.Address address) {
        if (address == null) {
            com.oplus.camera.e_renamed.e_renamed("LocationHelper", "getCameraAddress, address is_renamed null");
            return null;
        }
        com.oplus.camera.q_renamed.a_renamed aVar = new com.oplus.camera.q_renamed.a_renamed();
        aVar.a_renamed(address.getCountryName());
        aVar.b_renamed(address.getAdminArea());
        aVar.c_renamed(address.getSubAdminArea());
        aVar.d_renamed(address.getLocality());
        aVar.e_renamed(address.getSubLocality());
        aVar.f_renamed(address.getThoroughfare());
        aVar.g_renamed(address.getSubThoroughfare());
        aVar.h_renamed(address.getCountryCode());
        return aVar;
    }

    public static java.lang.String a_renamed(android.content.Context context, com.oplus.camera.q_renamed.a_renamed aVar) {
        java.lang.String strG;
        if (aVar == null) {
            com.oplus.camera.e_renamed.a_renamed("LocationHelper", "getAddressInfoByAddress address is_renamed null");
            return "";
        }
        if (d_renamed(context, aVar) || e_renamed(context, aVar)) {
            return aVar.f5294c;
        }
        if (f_renamed(context, aVar)) {
            return context.getResources().getString(com.oplus.camera.R_renamed.string.camera_hongkong_shown);
        }
        if (c_renamed(context, aVar)) {
            return context.getResources().getString(com.oplus.camera.R_renamed.string.camera_macao_shown);
        }
        if (aVar.g_renamed != null && aVar.f_renamed != null && aVar.e_renamed != null) {
            aVar.d_renamed = null;
        }
        if (!com.oplus.camera.util.Util.ak_renamed()) {
            strG = com.oplus.camera.l_renamed.c_renamed.a_renamed(context, aVar, f_renamed.f7345c, f_renamed.d_renamed, e_renamed.get() ? f_renamed.f7344b : null);
        } else {
            strG = g_renamed(context, aVar);
        }
        com.oplus.camera.e_renamed.b_renamed("LocationHelper", "getAdressInfoByAddress, currentAdress: " + strG);
        return strG;
    }

    private static java.lang.String g_renamed(android.content.Context context, com.oplus.camera.q_renamed.a_renamed aVar) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.String[] strArr = {aVar.d_renamed, aVar.e_renamed, aVar.f_renamed, aVar.g_renamed};
        java.lang.String[] strArr2 = {aVar.e_renamed, aVar.f_renamed};
        if (b_renamed(context, aVar)) {
            strArr = strArr2;
        } else if (!android.text.TextUtils.isEmpty(aVar.f_renamed) || !android.text.TextUtils.isEmpty(aVar.e_renamed) || !android.text.TextUtils.isEmpty(aVar.d_renamed)) {
            strArr[3] = null;
        }
        for (java.lang.String str : strArr) {
            if (!android.text.TextUtils.isEmpty(str)) {
                if (!sb.toString().isEmpty()) {
                    sb.append(", ");
                }
                sb.append(str);
            }
        }
        if (android.text.TextUtils.isEmpty(sb.toString())) {
            for (java.lang.String str2 : new java.lang.String[]{aVar.f5292a, aVar.f5293b, aVar.f5294c}) {
                if (!android.text.TextUtils.isEmpty(str2)) {
                    if (!sb.toString().isEmpty()) {
                        sb.append(", ");
                    }
                    sb.append(str2);
                }
            }
        }
        return sb.toString();
    }

    public static boolean b_renamed(android.content.Context context, com.oplus.camera.q_renamed.a_renamed aVar) throws android.content.res.Resources.NotFoundException {
        if (aVar == null) {
            return false;
        }
        if ("TW".equals(aVar.h_renamed)) {
            return true;
        }
        java.lang.String string = context.getResources().getString(com.oplus.camera.R_renamed.string.camera_taiwan);
        return (!android.text.TextUtils.isEmpty(aVar.g_renamed) && aVar.g_renamed.contains(string)) || (!android.text.TextUtils.isEmpty(aVar.f_renamed) && aVar.f_renamed.contains(string));
    }

    public static java.lang.String a_renamed(com.oplus.camera.q_renamed.a_renamed aVar) {
        com.oplus.camera.e_renamed.b_renamed("LocationHelper", "getCurrentCity, mCameraAddress, " + aVar);
        if (a_renamed(aVar.f_renamed.toLowerCase()) || d_renamed(aVar.f_renamed.toLowerCase())) {
            return aVar.f_renamed;
        }
        if (b_renamed(aVar.g_renamed.toLowerCase())) {
            return aVar.g_renamed;
        }
        if (c_renamed(aVar.f_renamed.toLowerCase())) {
            return aVar.f_renamed;
        }
        if (!android.text.TextUtils.isEmpty(aVar.d_renamed)) {
            return aVar.d_renamed;
        }
        if (!android.text.TextUtils.isEmpty(aVar.e_renamed)) {
            return aVar.e_renamed;
        }
        return aVar.f_renamed;
    }

    private static boolean a_renamed(java.lang.String str) {
        if (str == null) {
            return false;
        }
        return f7340a.contains(str);
    }

    private static boolean b_renamed(java.lang.String str) {
        if (str == null) {
            return false;
        }
        return f7341b.contains(str);
    }

    private static boolean c_renamed(java.lang.String str) {
        if (str == null) {
            return false;
        }
        return f7342c.contains(str);
    }

    private static boolean d_renamed(java.lang.String str) {
        if (str == null) {
            return false;
        }
        return d_renamed.contains(str);
    }

    public static boolean c_renamed(android.content.Context context, com.oplus.camera.q_renamed.a_renamed aVar) throws android.content.res.Resources.NotFoundException {
        if (aVar == null) {
            return false;
        }
        if ("MO".equals(aVar.h_renamed)) {
            return true;
        }
        android.content.res.Resources resources = context.getResources();
        java.lang.String string = resources.getString(com.oplus.camera.R_renamed.string.camera_macao);
        if ((!android.text.TextUtils.isEmpty(aVar.g_renamed) && aVar.g_renamed.contains(string)) || (!android.text.TextUtils.isEmpty(aVar.f_renamed) && aVar.f_renamed.contains(string))) {
            return true;
        }
        for (java.lang.String str : resources.getStringArray(com.oplus.camera.R_renamed.array.location_mo)) {
            if ((!android.text.TextUtils.isEmpty(aVar.g_renamed) && aVar.g_renamed.contains(str)) || (!android.text.TextUtils.isEmpty(aVar.f_renamed) && aVar.f_renamed.contains(str))) {
                return true;
            }
        }
        return false;
    }

    public static boolean d_renamed(android.content.Context context, com.oplus.camera.q_renamed.a_renamed aVar) throws android.content.res.Resources.NotFoundException {
        android.content.res.Resources resources = context.getResources();
        for (java.lang.String str : resources.getStringArray(com.oplus.camera.R_renamed.array.fujian_to_match)) {
            if (!android.text.TextUtils.isEmpty(aVar.f_renamed) && aVar.f_renamed.contains(str)) {
                for (java.lang.String str2 : resources.getStringArray(com.oplus.camera.R_renamed.array.kinmen_to_match)) {
                    if (!android.text.TextUtils.isEmpty(aVar.f5294c) && aVar.f5294c.contains(str2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean e_renamed(android.content.Context context, com.oplus.camera.q_renamed.a_renamed aVar) throws android.content.res.Resources.NotFoundException {
        android.content.res.Resources resources = context.getResources();
        for (java.lang.String str : resources.getStringArray(com.oplus.camera.R_renamed.array.fujian_to_match)) {
            if (!android.text.TextUtils.isEmpty(aVar.f_renamed) && aVar.f_renamed.contains(str)) {
                for (java.lang.String str2 : resources.getStringArray(com.oplus.camera.R_renamed.array.lianjiang_to_match)) {
                    if (!android.text.TextUtils.isEmpty(aVar.f5294c) && aVar.f5294c.contains(str2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean f_renamed(android.content.Context context, com.oplus.camera.q_renamed.a_renamed aVar) throws android.content.res.Resources.NotFoundException {
        if (aVar == null) {
            return false;
        }
        if ("HK".equals(aVar.h_renamed)) {
            return true;
        }
        android.content.res.Resources resources = context.getResources();
        java.lang.String string = resources.getString(com.oplus.camera.R_renamed.string.camera_hongkong);
        if ((!android.text.TextUtils.isEmpty(aVar.g_renamed) && aVar.g_renamed.contains(string)) || (!android.text.TextUtils.isEmpty(aVar.f_renamed) && aVar.f_renamed.contains(string))) {
            return true;
        }
        for (java.lang.String str : resources.getStringArray(com.oplus.camera.R_renamed.array.location_hk)) {
            if ((!android.text.TextUtils.isEmpty(aVar.g_renamed) && aVar.g_renamed.contains(str)) || (!android.text.TextUtils.isEmpty(aVar.f_renamed) && aVar.f_renamed.contains(str))) {
                return true;
            }
        }
        return false;
    }

    public static void a_renamed() {
        com.oplus.camera.util.Util.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.util.h_renamed.1
            @Override // java.lang.Runnable
            public void run() throws java.lang.Throwable {
                try {
                    com.oplus.camera.e_renamed.a_renamed("LocationHelper", "parseSensorAreaList");
                    if (!com.oplus.camera.util.h_renamed.e_renamed.getAndSet(false)) {
                        com.oplus.camera.util.h_renamed.e_renamed();
                    }
                    com.oplus.camera.util.h_renamed.f_renamed();
                    com.oplus.camera.util.h_renamed.e_renamed.set(true);
                    com.oplus.camera.e_renamed.a_renamed("LocationHelper", "parseSensorAreaList X_renamed");
                } catch (java.lang.Exception e2) {
                    com.oplus.camera.util.h_renamed.e_renamed.set(false);
                    e2.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e_renamed() throws java.lang.Throwable {
        com.oplus.camera.e_renamed.a_renamed("LocationHelper", "parseSensorAreaConfigFromAsset");
        java.lang.String strD = com.oplus.camera.util.Util.d_renamed("sensor_area.json");
        java.lang.String strD2 = com.oplus.camera.util.Util.d_renamed("sensor_area_replace.json");
        e_renamed(strD);
        f_renamed(strD2);
        com.oplus.camera.e_renamed.a_renamed("LocationHelper", "parseSensorAreaConfigFromAsset X_renamed");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f_renamed() throws org.json.JSONException, java.lang.NumberFormatException {
        android.content.SharedPreferences sharedPreferences = com.oplus.camera.MyApplication.d_renamed().getSharedPreferences("rom_update_info", 0);
        if (sharedPreferences == null) {
            return;
        }
        e_renamed(sharedPreferences.getString("sensor_area", null));
    }

    private static void e_renamed(java.lang.String str) throws org.json.JSONException, java.lang.NumberFormatException {
        if (str == null) {
            return;
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject(str);
        int i_renamed = java.lang.Integer.parseInt(jSONObject.getString(com.oplus.camera.statistics.CameraStatisticsUtil.RUS_FILE_VERSION));
        com.oplus.camera.e_renamed.a_renamed("LocationHelper", "updateSensorAreaConfigFromJson, sSensorAreaConfig.version: " + f_renamed.f7343a + ", jsonVersion: " + i_renamed);
        if (f_renamed.f7343a >= i_renamed) {
            return;
        }
        org.json.JSONArray jSONArray = jSONObject.getJSONArray("areas");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            org.json.JSONArray jSONArray2 = jSONArray.getJSONObject(i2).getJSONArray("disputingParty");
            int length2 = jSONArray2.length();
            for (int i3 = 0; i3 < length2; i3++) {
                arrayList.add(jSONArray2.getString(i3));
            }
        }
        f_renamed.f7343a = i_renamed;
        f_renamed.f7344b = arrayList;
    }

    private static void f_renamed(java.lang.String str) throws org.json.JSONException {
        if (str == null) {
            return;
        }
        org.json.JSONArray jSONArray = new org.json.JSONObject(str).getJSONArray("areas");
        java.util.HashMap map = new java.util.HashMap();
        java.util.HashMap map2 = new java.util.HashMap();
        int length = jSONArray.length();
        for (int i_renamed = 0; i_renamed < length; i_renamed++) {
            java.lang.String lowerCase = jSONArray.getJSONObject(i_renamed).getString("keyWords").toLowerCase();
            java.lang.String string = jSONArray.getJSONObject(i_renamed).getString("areaReplace");
            java.lang.String string2 = jSONArray.getJSONObject(i_renamed).getString("areaReplaceExport");
            map.put(lowerCase, string);
            map2.put(lowerCase, string2);
        }
        f_renamed.f7345c = map;
        f_renamed.d_renamed = map2;
    }

    /* compiled from: LocationHelper.java */
    private static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private int f7343a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private java.util.List<java.lang.String> f7344b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private java.util.Map<java.lang.String, java.lang.String> f7345c;
        private java.util.Map<java.lang.String, java.lang.String> d_renamed;

        private a_renamed() {
            this.f7343a = -1;
            this.f7344b = new java.util.ArrayList();
            this.f7345c = new java.util.HashMap();
            this.d_renamed = new java.util.HashMap();
        }
    }
}
