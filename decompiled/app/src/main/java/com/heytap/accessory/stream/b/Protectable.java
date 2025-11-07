package com.heytap.accessory.stream.b_renamed;

/* compiled from: CancelStreamRequest.java */
/* loaded from: classes2.dex */
public class c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private long f3416a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f3417b;

    public c_renamed() {
    }

    public c_renamed(long j_renamed, int i_renamed) {
        this.f3416a = j_renamed;
        this.f3417b = i_renamed;
    }

    public org.json.JSONObject a_renamed() throws org.json.JSONException {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        jSONObject.put("connectionId", this.f3416a);
        jSONObject.put("TransactionId", this.f3417b);
        return jSONObject;
    }
}
