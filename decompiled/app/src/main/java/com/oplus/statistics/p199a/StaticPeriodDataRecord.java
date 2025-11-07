package com.oplus.statistics.p199a;

import android.content.Context;
import com.oplus.statistics.p200b.PeriodDataBean;
import com.oplus.statistics.p200b.SettingKeyBean;
import com.oplus.statistics.p200b.SettingKeyDataBean;
import com.oplus.statistics.p201c.ProxyRecorder;
import com.oplus.statistics.p204f.LogUtil;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: StaticPeriodDataRecord.java */
/* renamed from: com.oplus.statistics.PlatformImplementations.kt_3.OplusGLSurfaceView_13 */
/* loaded from: classes2.dex */
public class StaticPeriodDataRecord extends BaseAgent {
    /* renamed from: PlatformImplementations.kt_3 */
    public static void m25256a(Context context, PeriodDataBean c3729i) {
        ProxyRecorder.m25337a().mo25336a(context, c3729i);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m25257a(Context context, SettingKeyDataBean c3731k) {
        ProxyRecorder.m25337a().mo25336a(context, c3731k);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static JSONArray m25255a(List<SettingKeyBean> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        if (list != null && !list.isEmpty()) {
            try {
                for (SettingKeyBean c3730j : list) {
                    if (c3730j != null) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("setting_key", c3730j.m25302a());
                        jSONObject.put("http_post_key", c3730j.m25303b());
                        jSONObject.put("method_name", c3730j.m25304c());
                        jSONObject.put("default_value", c3730j.m25305d());
                        jSONArray.put(jSONObject);
                    }
                }
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.getClass();
                LogUtil.m25428a("StaticPeriodDataRecord", new $$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(COUIBaseListPopupWindow_8));
            }
        }
        return jSONArray;
    }
}
