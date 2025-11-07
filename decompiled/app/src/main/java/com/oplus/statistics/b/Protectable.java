package com.oplus.statistics.b_renamed;

/* compiled from: CommonBatchBean.java */
/* loaded from: classes2.dex */
public class c_renamed extends com.oplus.statistics.b_renamed.d_renamed {
    @Override // com.oplus.statistics.b_renamed.d_renamed, com.oplus.statistics.b_renamed.m_renamed
    public int b_renamed() {
        return com.heytap.accessory.CommonStatusCodes.PERMISSION_DENIAL;
    }

    public c_renamed(android.content.Context context) {
        super(context);
    }

    public void a_renamed(java.util.List<java.util.Map<java.lang.String, java.lang.String>> list) throws com.oplus.statistics.a_renamed {
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        java.util.Iterator<java.util.Map<java.lang.String, java.lang.String>> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(com.oplus.statistics.f_renamed.c_renamed.a_renamed(it.next()));
        }
        java.lang.String string = jSONArray.toString();
        if (string.length() >= 131072) {
            final java.lang.String str = "DataOverSizeException :" + g_renamed() + ", " + c_renamed() + ", " + a_renamed();
            str.getClass();
            com.oplus.statistics.f_renamed.d_renamed.b_renamed("CommonBatchBean", new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.b_renamed.-$$Lambda$oM9guskQ-Ngpr3mxKxCbKFcfZwA
                @Override // com.oplus.statistics.f_renamed.e_renamed
                public final java.lang.Object get() {
                    return str.toString();
                }
            });
            throw new com.oplus.statistics.a_renamed(str);
        }
        this.f7650a = string;
        a_renamed("mapList", this.f7650a);
    }
}
