package com.heytap.accessory.file.a_renamed;

/* compiled from: FileReceiveEntity.java */
/* loaded from: classes2.dex */
public class e_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f3362a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.lang.String f3363b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.lang.String f3364c;
    private boolean d_renamed;
    private long e_renamed;

    public e_renamed() {
    }

    public e_renamed(long j_renamed, int i_renamed, java.lang.String str, java.lang.String str2, boolean z_renamed) {
        this.e_renamed = j_renamed;
        this.f3362a = i_renamed;
        this.f3363b = str;
        this.d_renamed = z_renamed;
        this.f3364c = str2;
    }

    public org.json.JSONObject a_renamed() throws org.json.JSONException {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        jSONObject.put(com.google.android.exoplayer2.text.ttml.TtmlNode.ATTR_ID, this.f3362a);
        jSONObject.put("path", this.f3363b);
        jSONObject.put("fileuri", this.f3364c);
        jSONObject.put("accepted", this.d_renamed);
        jSONObject.put("connectionId", this.e_renamed);
        return jSONObject;
    }
}
