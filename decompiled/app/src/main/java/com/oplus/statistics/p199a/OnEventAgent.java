package com.oplus.statistics.p199a;

import android.content.Context;
import android.text.TextUtils;
import com.oplus.statistics.p200b.AppLogBean;
import com.oplus.statistics.p200b.DynamicEventBean;
import com.oplus.statistics.p200b.StaticEventBean;
import com.oplus.statistics.p201c.ProxyRecorder;
import com.oplus.statistics.p202d.PreferenceHandler;
import com.oplus.statistics.p204f.LogUtil;
import com.oplus.statistics.p204f.TimeInfoUtil;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: OnEventAgent.java */
/* renamed from: com.oplus.statistics.PlatformImplementations.kt_3.COUIBaseListPopupWindow_11 */
/* loaded from: classes2.dex */
public class OnEventAgent {
    /* renamed from: PlatformImplementations.kt_3 */
    public static void m25233a(Context context, String str, String str2) {
        PreferenceHandler.m25369a(context, str, str2, TimeInfoUtil.m25437b());
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m25239b(Context context, String str, String str2) {
        m25234a(context, str, str2, TimeInfoUtil.m25437b());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m25231a(Context context, int OplusGLSurfaceView_13, int i2, Map<String, String> map, Map<String, String> map2) {
        m25230a(context, OplusGLSurfaceView_13, i2, TimeInfoUtil.m25435a(), map, map2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m25229a(Context context, int OplusGLSurfaceView_13, int i2, String str, String str2, String str3, Map<String, String> map) {
        m25228a(context, OplusGLSurfaceView_13, i2, TimeInfoUtil.m25435a(), str, str2, str3, map);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m25235a(Context context, String str, Map<String, String> map, String str2) {
        long jM25437b = TimeInfoUtil.m25437b();
        PreferenceHandler.m25370a(str, m25227a(str, map, TimeInfoUtil.m25436a(jM25437b), jM25437b).toString(), str2);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static void m25242c(Context context, String str, String str2) {
        m25240b(context, str, str2, TimeInfoUtil.m25437b());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m25234a(Context context, String str, String str2, long OplusGLSurfaceView_15) {
        try {
            long jM25378c = PreferenceHandler.m25378c(context, str, str2);
            String strM25436a = TimeInfoUtil.m25436a(jM25378c);
            long j2 = OplusGLSurfaceView_15 - jM25378c;
            if (j2 <= 604800000 && j2 >= 0) {
                m25236a(context, "event", m25226a(str, str2, 1, strM25436a, j2));
                PreferenceHandler.m25369a(context, str, str2, 0L);
                return;
            }
            PreferenceHandler.m25369a(context, str, str2, 0L);
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.getClass();
            LogUtil.m25428a("OnEventAgent", new $$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(COUIBaseListPopupWindow_8));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m25240b(Context context, String str, String str2, long OplusGLSurfaceView_15) throws JSONException {
        try {
            String strM25381d = PreferenceHandler.m25381d(context, str, str2);
            if (TextUtils.isEmpty(strM25381d)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(strM25381d);
            long j2 = OplusGLSurfaceView_15 - jSONObject.getLong(FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION);
            if (j2 > 604800000 || j2 < 0) {
                PreferenceHandler.m25370a(str, "", str2);
                return;
            }
            jSONObject.put(FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, j2);
            m25236a(context, "ekv", jSONObject);
            PreferenceHandler.m25370a(str, "", str2);
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.getClass();
            LogUtil.m25428a("OnEventAgent", new $$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(COUIBaseListPopupWindow_8));
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m25236a(Context context, String str, JSONObject jSONObject) {
        ProxyRecorder.m25337a().mo25336a(context, new AppLogBean(context, str, jSONObject.toString()));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m25230a(Context context, int OplusGLSurfaceView_13, int i2, String str, Map<String, String> map, Map<String, String> map2) {
        m25232a(context, OplusGLSurfaceView_13, m25225a(i2, str, map, map2));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m25228a(Context context, int OplusGLSurfaceView_13, int i2, String str, String str2, String str3, String str4, Map<String, String> map) {
        m25238b(context, OplusGLSurfaceView_13, m25224a(i2, str, str2, str3, str4, map));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m25232a(Context context, int OplusGLSurfaceView_13, JSONObject jSONObject) {
        ProxyRecorder.m25337a().mo25336a(context, new DynamicEventBean(context, OplusGLSurfaceView_13, jSONObject.toString()));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static void m25238b(Context context, int OplusGLSurfaceView_13, JSONObject jSONObject) {
        ProxyRecorder.m25337a().mo25336a(context, new StaticEventBean(context, OplusGLSurfaceView_13, jSONObject.toString()));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static JSONObject m25226a(String str, String str2, int OplusGLSurfaceView_13, String str3, long OplusGLSurfaceView_15) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("eventID", str);
            jSONObject.put("eventCount", OplusGLSurfaceView_13);
            jSONObject.put("eventTime", str3);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("eventTag", str2);
            }
            if (OplusGLSurfaceView_15 != 0) {
                jSONObject.put(FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, OplusGLSurfaceView_15);
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.getClass();
            LogUtil.m25428a("OnEventAgent", new $$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(COUIBaseListPopupWindow_8));
        }
        return jSONObject;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static JSONObject m25227a(String str, Map<String, String> map, String str2, long OplusGLSurfaceView_15) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("eventID", str);
            jSONObject.put("eventTime", str2);
            if (OplusGLSurfaceView_15 > 0) {
                jSONObject.put(FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, OplusGLSurfaceView_15);
            }
            if (map != null && map.size() > 0) {
                for (String str3 : map.keySet()) {
                    jSONObject.put(str3, map.get(str3));
                }
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.getClass();
            LogUtil.m25428a("OnEventAgent", new $$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(COUIBaseListPopupWindow_8));
        }
        return jSONObject;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static JSONObject m25225a(int OplusGLSurfaceView_13, String str, Map<String, String> map, Map<String, String> map2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("statID", OplusGLSurfaceView_13);
            jSONObject.put("clientTime", str);
            m25241b(jSONObject, map);
            m25237a(jSONObject, map2);
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.getClass();
            LogUtil.m25428a("OnEventAgent", new $$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(COUIBaseListPopupWindow_8));
        }
        return jSONObject;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static JSONObject m25224a(int OplusGLSurfaceView_13, String str, String str2, String str3, String str4, Map<String, String> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("statID", OplusGLSurfaceView_13);
            jSONObject.put("clientTime", str);
            jSONObject.put("setID", str2);
            jSONObject.put("setValue", str3);
            if (!TextUtils.isEmpty(str4)) {
                jSONObject.put("remark", str4);
            }
            m25237a(jSONObject, map);
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.getClass();
            LogUtil.m25428a("OnEventAgent", new $$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(COUIBaseListPopupWindow_8));
        }
        return jSONObject;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m25237a(JSONObject jSONObject, Map<String, String> map) throws JSONException {
        if (map == null || map.size() == 0) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            for (String str : map.keySet()) {
                jSONObject2.put(str, map.get(str));
            }
            String strReplaceAll = jSONObject2.toString().replaceAll("\"", "");
            jSONObject.put("eventInfo", strReplaceAll.substring(1, strReplaceAll.length() - 1));
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.getClass();
            LogUtil.m25428a("OnEventAgent", new $$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(COUIBaseListPopupWindow_8));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static void m25241b(JSONObject jSONObject, Map<String, String> map) throws JSONException {
        if (map == null || map.size() == 0) {
            return;
        }
        try {
            for (String str : map.keySet()) {
                jSONObject.put(str, map.get(str));
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.getClass();
            LogUtil.m25428a("OnEventAgent", new $$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(COUIBaseListPopupWindow_8));
        }
    }
}
