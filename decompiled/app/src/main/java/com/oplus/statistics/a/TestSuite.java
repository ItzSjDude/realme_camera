package com.oplus.statistics.a_renamed;

/* compiled from: StaticPeriodDataRecord.java */
/* loaded from: classes2.dex */
public class i_renamed extends com.oplus.statistics.a_renamed.c_renamed {
    public static void a_renamed(android.content.Context context, com.oplus.statistics.b_renamed.i_renamed iVar) {
        com.oplus.statistics.c_renamed.d_renamed.a_renamed().a_renamed(context, iVar);
    }

    public static void a_renamed(android.content.Context context, com.oplus.statistics.b_renamed.k_renamed kVar) {
        com.oplus.statistics.c_renamed.d_renamed.a_renamed().a_renamed(context, kVar);
    }

    public static org.json.JSONArray a_renamed(java.util.List<com.oplus.statistics.b_renamed.j_renamed> list) throws org.json.JSONException {
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        if (list != null && !list.isEmpty()) {
            try {
                for (com.oplus.statistics.b_renamed.j_renamed jVar : list) {
                    if (jVar != null) {
                        org.json.JSONObject jSONObject = new org.json.JSONObject();
                        jSONObject.put("setting_key", jVar.a_renamed());
                        jSONObject.put("http_post_key", jVar.b_renamed());
                        jSONObject.put("method_name", jVar.c_renamed());
                        jSONObject.put("default_value", jVar.d_renamed());
                        jSONArray.put(jSONObject);
                    }
                }
            } catch (java.lang.Exception e_renamed) {
                e_renamed.getClass();
                com.oplus.statistics.f_renamed.d_renamed.a_renamed("StaticPeriodDataRecord", new com.oplus.statistics.a_renamed.$$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(e_renamed));
            }
        }
        return jSONArray;
    }
}
