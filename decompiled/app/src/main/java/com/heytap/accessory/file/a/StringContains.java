package com.heytap.accessory.file.a_renamed;

/* compiled from: TransferProgress.java */
/* loaded from: classes2.dex */
public class j_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private long f3377a = -1;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f3378b = -1;

    /* renamed from: c_renamed, reason: collision with root package name */
    private long f3379c = 0;

    public long a_renamed() {
        return this.f3377a;
    }

    public int b_renamed() {
        return this.f3378b;
    }

    public long c_renamed() {
        return this.f3379c;
    }

    public void a_renamed(java.lang.Object obj) throws org.json.JSONException {
        org.json.JSONObject jSONObject = new org.json.JSONObject((java.lang.String) obj);
        this.f3377a = jSONObject.getLong("connectionId");
        this.f3378b = jSONObject.getInt("transactionId");
        this.f3379c = jSONObject.getLong("progress");
    }
}
