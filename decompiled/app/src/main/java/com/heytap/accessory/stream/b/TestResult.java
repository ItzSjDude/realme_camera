package com.heytap.accessory.stream.b_renamed;

/* compiled from: TransferErrorMsg.java */
/* loaded from: classes2.dex */
public class h_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private long f3429a = -1;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f3430b = -1;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f3431c = -1;
    private java.lang.String d_renamed = "";

    public long a_renamed() {
        return this.f3429a;
    }

    public int b_renamed() {
        return this.f3430b;
    }

    public int c_renamed() {
        return this.f3431c;
    }

    public void a_renamed(java.lang.Object obj) throws org.json.JSONException {
        org.json.JSONObject jSONObject = new org.json.JSONObject((java.lang.String) obj);
        this.f3429a = jSONObject.getLong("connectionId");
        this.f3430b = jSONObject.getInt("transactionId");
        this.f3431c = jSONObject.getInt("errorCode");
        this.d_renamed = jSONObject.getString(com.android.providers.downloads.Downloads.Impl.COLUMN_ERROR_MSG);
    }
}
