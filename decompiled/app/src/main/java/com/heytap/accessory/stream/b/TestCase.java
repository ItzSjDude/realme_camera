package com.heytap.accessory.stream.b_renamed;

/* compiled from: STOperateEntity.java */
/* loaded from: classes2.dex */
public class e_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f3421a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private org.json.JSONObject f3422b;

    public e_renamed() {
    }

    public e_renamed(int i_renamed, org.json.JSONObject jSONObject) {
        this.f3421a = i_renamed;
        this.f3422b = jSONObject;
    }

    public org.json.JSONObject a_renamed() throws org.json.JSONException {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        jSONObject.put("OpCode", this.f3421a);
        jSONObject.put("Parameters", this.f3422b);
        return jSONObject;
    }
}
