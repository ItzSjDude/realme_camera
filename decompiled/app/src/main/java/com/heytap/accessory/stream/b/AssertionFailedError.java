package com.heytap.accessory.stream.b_renamed;

/* compiled from: CancelAllRequest.java */
/* loaded from: classes2.dex */
public class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.lang.String f3414a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private long f3415b;

    public b_renamed() {
    }

    public b_renamed(java.lang.String str, long j_renamed) {
        this.f3414a = str;
        this.f3415b = j_renamed;
    }

    public org.json.JSONObject a_renamed() throws org.json.JSONException {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        jSONObject.put("AgentId", this.f3414a);
        jSONObject.put("ConnectionId", this.f3415b);
        return jSONObject;
    }
}
