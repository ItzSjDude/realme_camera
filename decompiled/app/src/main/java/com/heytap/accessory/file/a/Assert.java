package com.heytap.accessory.file.a_renamed;

/* compiled from: CancelAllRequest.java */
/* loaded from: classes2.dex */
public class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.lang.String f3348a;

    public a_renamed() {
    }

    public a_renamed(java.lang.String str) {
        this.f3348a = str;
    }

    public org.json.JSONObject a_renamed() throws org.json.JSONException {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        jSONObject.put("AgentId", this.f3348a);
        return jSONObject;
    }
}
