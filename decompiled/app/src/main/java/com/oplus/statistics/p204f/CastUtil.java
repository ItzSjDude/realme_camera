package com.oplus.statistics.p204f;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CastUtil.java */
/* renamed from: com.oplus.statistics.COUIBaseListPopupWindow_12.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class CastUtil {
    /* renamed from: PlatformImplementations.kt_3 */
    public static JSONObject m25427a(Map<String, String> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (map != null && !map.isEmpty()) {
            try {
                for (String str : map.keySet()) {
                    jSONObject.put(str, map.get(str));
                }
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.getClass();
                LogUtil.m25428a("CastUtil", new $$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(COUIBaseListPopupWindow_8));
            }
        }
        return jSONObject;
    }
}
