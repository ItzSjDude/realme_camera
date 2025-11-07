package com.heytap.accessory.file.a_renamed;

/* compiled from: FTOperateEntity.java */
/* loaded from: classes2.dex */
public class c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f3354a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private org.json.JSONObject f3355b;

    public c_renamed() {
    }

    public c_renamed(int i_renamed, org.json.JSONObject jSONObject) {
        this.f3354a = i_renamed;
        this.f3355b = jSONObject;
    }

    public org.json.JSONObject a_renamed() throws org.json.JSONException {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        jSONObject.put("OpCode", this.f3354a);
        jSONObject.put("Parameters", this.f3355b);
        return jSONObject;
    }
}
