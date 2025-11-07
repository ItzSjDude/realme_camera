package com.heytap.accessory.file.a_renamed;

/* compiled from: CancelFileRequest.java */
/* loaded from: classes2.dex */
public class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private long f3352a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f3353b;

    public b_renamed() {
    }

    public b_renamed(long j_renamed, int i_renamed) {
        this.f3352a = j_renamed;
        this.f3353b = i_renamed;
    }

    public org.json.JSONObject a_renamed() throws org.json.JSONException {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        jSONObject.put("connectionId", this.f3352a);
        jSONObject.put("TransactionId", this.f3353b);
        return jSONObject;
    }
}
