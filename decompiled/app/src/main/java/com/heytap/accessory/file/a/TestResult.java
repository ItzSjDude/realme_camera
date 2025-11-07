package com.heytap.accessory.file.a_renamed;

/* compiled from: TransferCompleteMsg.java */
/* loaded from: classes2.dex */
public class h_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private long f3371a = 0;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f3372b = 0;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.lang.String f3373c = "";
    private java.lang.String d_renamed = "";

    public long a_renamed() {
        return this.f3371a;
    }

    public int b_renamed() {
        return this.f3372b;
    }

    public java.lang.String c_renamed() {
        return this.f3373c;
    }

    public java.lang.String d_renamed() {
        return this.d_renamed;
    }

    public void a_renamed(java.lang.Object obj) throws org.json.JSONException {
        org.json.JSONObject jSONObject = new org.json.JSONObject((java.lang.String) obj);
        this.f3371a = jSONObject.getLong("connectionId");
        this.f3372b = jSONObject.getInt("transactionId");
        this.f3373c = jSONObject.getString("sourcePath");
        this.d_renamed = jSONObject.getString("destPath");
    }
}
