package com.oplus.statistics.f_renamed;

/* compiled from: CastUtil.java */
/* loaded from: classes2.dex */
public class c_renamed {
    public static org.json.JSONObject a_renamed(java.util.Map<java.lang.String, java.lang.String> map) throws org.json.JSONException {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        if (map != null && !map.isEmpty()) {
            try {
                for (java.lang.String str : map.keySet()) {
                    jSONObject.put(str, map.get(str));
                }
            } catch (java.lang.Exception e_renamed) {
                e_renamed.getClass();
                com.oplus.statistics.f_renamed.d_renamed.a_renamed("CastUtil", new com.oplus.statistics.f_renamed.$$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(e_renamed));
            }
        }
        return jSONObject;
    }
}
