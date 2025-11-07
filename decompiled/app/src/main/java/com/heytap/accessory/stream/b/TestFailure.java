package com.heytap.accessory.stream.b_renamed;

/* compiled from: StreamReceiveEntity.java */
/* loaded from: classes2.dex */
public class f_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f3423a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private boolean f3424b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private long f3425c;
    private int d_renamed;

    public f_renamed() {
    }

    public f_renamed(long j_renamed, int i_renamed, boolean z_renamed, int i2) {
        this.f3425c = j_renamed;
        this.f3423a = i_renamed;
        this.f3424b = z_renamed;
        this.d_renamed = i2;
    }

    public org.json.JSONObject a_renamed() throws org.json.JSONException {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        jSONObject.put(com.google.android.exoplayer2.text.ttml.TtmlNode.ATTR_ID, this.f3423a);
        jSONObject.put("connectionId", this.f3425c);
        jSONObject.put("accepted", this.f3424b);
        jSONObject.put("reason", this.d_renamed);
        return jSONObject;
    }
}
