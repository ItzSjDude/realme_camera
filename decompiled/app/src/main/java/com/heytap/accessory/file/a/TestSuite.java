package com.heytap.accessory.file.a_renamed;

/* compiled from: TransferErrorMsg.java */
/* loaded from: classes2.dex */
public class i_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private long f3374a = -1;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f3375b = -1;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f3376c = -1;
    private java.lang.String d_renamed = "";

    public long a_renamed() {
        return this.f3374a;
    }

    public int b_renamed() {
        return this.f3375b;
    }

    public int c_renamed() {
        return this.f3376c;
    }

    public void a_renamed(java.lang.Object obj) throws org.json.JSONException {
        org.json.JSONObject jSONObject = new org.json.JSONObject((java.lang.String) obj);
        this.f3374a = jSONObject.getLong("connectionId");
        this.f3375b = jSONObject.getInt("transactionId");
        this.f3376c = jSONObject.getInt("errorCode");
        this.d_renamed = jSONObject.getString(com.android.providers.downloads.Downloads.Impl.COLUMN_ERROR_MSG);
    }
}
