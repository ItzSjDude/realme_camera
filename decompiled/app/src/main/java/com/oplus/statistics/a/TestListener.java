package com.oplus.statistics.a_renamed;

/* compiled from: OnEventAgent.java */
/* loaded from: classes2.dex */
public class g_renamed {
    public static void a_renamed(android.content.Context context, java.lang.String str, java.lang.String str2) {
        com.oplus.statistics.d_renamed.b_renamed.a_renamed(context, str, str2, com.oplus.statistics.f_renamed.f_renamed.b_renamed());
    }

    public static void b_renamed(android.content.Context context, java.lang.String str, java.lang.String str2) {
        a_renamed(context, str, str2, com.oplus.statistics.f_renamed.f_renamed.b_renamed());
    }

    public static void a_renamed(android.content.Context context, int i_renamed, int i2, java.util.Map<java.lang.String, java.lang.String> map, java.util.Map<java.lang.String, java.lang.String> map2) {
        a_renamed(context, i_renamed, i2, com.oplus.statistics.f_renamed.f_renamed.a_renamed(), map, map2);
    }

    public static void a_renamed(android.content.Context context, int i_renamed, int i2, java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.Map<java.lang.String, java.lang.String> map) {
        a_renamed(context, i_renamed, i2, com.oplus.statistics.f_renamed.f_renamed.a_renamed(), str, str2, str3, map);
    }

    public static void a_renamed(android.content.Context context, java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str2) {
        long jB = com.oplus.statistics.f_renamed.f_renamed.b_renamed();
        com.oplus.statistics.d_renamed.b_renamed.a_renamed(str, a_renamed(str, map, com.oplus.statistics.f_renamed.f_renamed.a_renamed(jB), jB).toString(), str2);
    }

    public static void c_renamed(android.content.Context context, java.lang.String str, java.lang.String str2) {
        b_renamed(context, str, str2, com.oplus.statistics.f_renamed.f_renamed.b_renamed());
    }

    public static void a_renamed(android.content.Context context, java.lang.String str, java.lang.String str2, long j_renamed) {
        try {
            long jC = com.oplus.statistics.d_renamed.b_renamed.c_renamed(context, str, str2);
            java.lang.String strA = com.oplus.statistics.f_renamed.f_renamed.a_renamed(jC);
            long j2 = j_renamed - jC;
            if (j2 <= 604800000 && j2 >= 0) {
                a_renamed(context, "event", a_renamed(str, str2, 1, strA, j2));
                com.oplus.statistics.d_renamed.b_renamed.a_renamed(context, str, str2, 0L);
                return;
            }
            com.oplus.statistics.d_renamed.b_renamed.a_renamed(context, str, str2, 0L);
        } catch (java.lang.Exception e_renamed) {
            e_renamed.getClass();
            com.oplus.statistics.f_renamed.d_renamed.a_renamed("OnEventAgent", new com.oplus.statistics.a_renamed.$$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(e_renamed));
        }
    }

    public static void b_renamed(android.content.Context context, java.lang.String str, java.lang.String str2, long j_renamed) throws org.json.JSONException {
        try {
            java.lang.String strD = com.oplus.statistics.d_renamed.b_renamed.d_renamed(context, str, str2);
            if (android.text.TextUtils.isEmpty(strD)) {
                return;
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject(strD);
            long j2 = j_renamed - jSONObject.getLong(com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION);
            if (j2 > 604800000 || j2 < 0) {
                com.oplus.statistics.d_renamed.b_renamed.a_renamed(str, "", str2);
                return;
            }
            jSONObject.put(com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, j2);
            a_renamed(context, "ekv", jSONObject);
            com.oplus.statistics.d_renamed.b_renamed.a_renamed(str, "", str2);
        } catch (java.lang.Exception e_renamed) {
            e_renamed.getClass();
            com.oplus.statistics.f_renamed.d_renamed.a_renamed("OnEventAgent", new com.oplus.statistics.a_renamed.$$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(e_renamed));
        }
    }

    private static void a_renamed(android.content.Context context, java.lang.String str, org.json.JSONObject jSONObject) {
        com.oplus.statistics.c_renamed.d_renamed.a_renamed().a_renamed(context, new com.oplus.statistics.b_renamed.a_renamed(context, str, jSONObject.toString()));
    }

    public static void a_renamed(android.content.Context context, int i_renamed, int i2, java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, java.util.Map<java.lang.String, java.lang.String> map2) {
        a_renamed(context, i_renamed, a_renamed(i2, str, map, map2));
    }

    public static void a_renamed(android.content.Context context, int i_renamed, int i2, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.util.Map<java.lang.String, java.lang.String> map) {
        b_renamed(context, i_renamed, a_renamed(i2, str, str2, str3, str4, map));
    }

    private static void a_renamed(android.content.Context context, int i_renamed, org.json.JSONObject jSONObject) {
        com.oplus.statistics.c_renamed.d_renamed.a_renamed().a_renamed(context, new com.oplus.statistics.b_renamed.f_renamed(context, i_renamed, jSONObject.toString()));
    }

    private static void b_renamed(android.content.Context context, int i_renamed, org.json.JSONObject jSONObject) {
        com.oplus.statistics.c_renamed.d_renamed.a_renamed().a_renamed(context, new com.oplus.statistics.b_renamed.l_renamed(context, i_renamed, jSONObject.toString()));
    }

    public static org.json.JSONObject a_renamed(java.lang.String str, java.lang.String str2, int i_renamed, java.lang.String str3, long j_renamed) throws org.json.JSONException {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("eventID", str);
            jSONObject.put("eventCount", i_renamed);
            jSONObject.put("eventTime", str3);
            if (!android.text.TextUtils.isEmpty(str2)) {
                jSONObject.put("eventTag", str2);
            }
            if (j_renamed != 0) {
                jSONObject.put(com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, j_renamed);
            }
        } catch (java.lang.Exception e_renamed) {
            e_renamed.getClass();
            com.oplus.statistics.f_renamed.d_renamed.a_renamed("OnEventAgent", new com.oplus.statistics.a_renamed.$$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(e_renamed));
        }
        return jSONObject;
    }

    public static org.json.JSONObject a_renamed(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str2, long j_renamed) throws org.json.JSONException {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("eventID", str);
            jSONObject.put("eventTime", str2);
            if (j_renamed > 0) {
                jSONObject.put(com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, j_renamed);
            }
            if (map != null && map.size() > 0) {
                for (java.lang.String str3 : map.keySet()) {
                    jSONObject.put(str3, map.get(str3));
                }
            }
        } catch (java.lang.Exception e_renamed) {
            e_renamed.getClass();
            com.oplus.statistics.f_renamed.d_renamed.a_renamed("OnEventAgent", new com.oplus.statistics.a_renamed.$$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(e_renamed));
        }
        return jSONObject;
    }

    public static org.json.JSONObject a_renamed(int i_renamed, java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, java.util.Map<java.lang.String, java.lang.String> map2) throws org.json.JSONException {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("statID", i_renamed);
            jSONObject.put("clientTime", str);
            b_renamed(jSONObject, map);
            a_renamed(jSONObject, map2);
        } catch (java.lang.Exception e_renamed) {
            e_renamed.getClass();
            com.oplus.statistics.f_renamed.d_renamed.a_renamed("OnEventAgent", new com.oplus.statistics.a_renamed.$$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(e_renamed));
        }
        return jSONObject;
    }

    public static org.json.JSONObject a_renamed(int i_renamed, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.util.Map<java.lang.String, java.lang.String> map) throws org.json.JSONException {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("statID", i_renamed);
            jSONObject.put("clientTime", str);
            jSONObject.put("setID", str2);
            jSONObject.put("setValue", str3);
            if (!android.text.TextUtils.isEmpty(str4)) {
                jSONObject.put("remark", str4);
            }
            a_renamed(jSONObject, map);
        } catch (java.lang.Exception e_renamed) {
            e_renamed.getClass();
            com.oplus.statistics.f_renamed.d_renamed.a_renamed("OnEventAgent", new com.oplus.statistics.a_renamed.$$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(e_renamed));
        }
        return jSONObject;
    }

    private static void a_renamed(org.json.JSONObject jSONObject, java.util.Map<java.lang.String, java.lang.String> map) throws org.json.JSONException {
        if (map == null || map.size() == 0) {
            return;
        }
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        try {
            for (java.lang.String str : map.keySet()) {
                jSONObject2.put(str, map.get(str));
            }
            java.lang.String strReplaceAll = jSONObject2.toString().replaceAll("\"", "");
            jSONObject.put("eventInfo", strReplaceAll.substring(1, strReplaceAll.length() - 1));
        } catch (java.lang.Exception e_renamed) {
            e_renamed.getClass();
            com.oplus.statistics.f_renamed.d_renamed.a_renamed("OnEventAgent", new com.oplus.statistics.a_renamed.$$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(e_renamed));
        }
    }

    private static void b_renamed(org.json.JSONObject jSONObject, java.util.Map<java.lang.String, java.lang.String> map) throws org.json.JSONException {
        if (map == null || map.size() == 0) {
            return;
        }
        try {
            for (java.lang.String str : map.keySet()) {
                jSONObject.put(str, map.get(str));
            }
        } catch (java.lang.Exception e_renamed) {
            e_renamed.getClass();
            com.oplus.statistics.f_renamed.d_renamed.a_renamed("OnEventAgent", new com.oplus.statistics.a_renamed.$$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(e_renamed));
        }
    }
}
