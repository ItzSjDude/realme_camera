package com.heytap.accessory.stream.b_renamed;

/* compiled from: StreamSendEntity.java */
/* loaded from: classes2.dex */
public class g_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.lang.String f3426a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.lang.String f3427b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private long f3428c;
    private java.lang.String d_renamed;
    private java.lang.String e_renamed;

    public g_renamed() {
    }

    public g_renamed(java.lang.String str, java.lang.String str2, long j_renamed, java.lang.String str3, java.lang.String str4) {
        this.f3426a = str;
        this.f3427b = str2;
        this.f3428c = j_renamed;
        this.d_renamed = str3;
        this.e_renamed = str4;
    }

    public org.json.JSONObject a_renamed() throws org.json.JSONException {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        jSONObject.put("PeerId", this.f3426a);
        jSONObject.put("ContainerId", this.f3427b);
        jSONObject.put("AccessoryId", this.f3428c);
        jSONObject.put("PackageName", this.d_renamed);
        jSONObject.put("AgentClassName", this.e_renamed);
        return jSONObject;
    }
}
