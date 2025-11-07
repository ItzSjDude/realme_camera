package com.heytap.accessory.file.a_renamed;

/* compiled from: FileSendEntity.java */
/* loaded from: classes2.dex */
public class f_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.lang.String f3365a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.lang.String f3366b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.lang.String f3367c;
    private java.lang.String d_renamed;
    private long e_renamed;
    private long f_renamed;
    private java.lang.String g_renamed;
    private java.lang.String h_renamed;
    private java.lang.String i_renamed;
    private java.lang.String j_renamed;
    private java.lang.String k_renamed;

    public f_renamed() {
    }

    public f_renamed(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, long j_renamed, long j2, java.lang.String str6, java.lang.String str7, java.lang.String str8, java.lang.String str9) {
        this.f3365a = str;
        this.f3366b = str2;
        this.k_renamed = str3;
        this.f3367c = str4;
        this.d_renamed = str5;
        this.e_renamed = j_renamed;
        this.f_renamed = j2;
        this.g_renamed = str6;
        this.h_renamed = str7;
        this.i_renamed = str8;
        this.j_renamed = str9;
    }

    public org.json.JSONObject a_renamed() throws org.json.JSONException {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        jSONObject.put("SourcePath", this.f3365a);
        jSONObject.put("DestinationPath", this.f3366b);
        jSONObject.put("PeerId", this.f3367c);
        jSONObject.put("ContainerId", this.d_renamed);
        jSONObject.put("AccessoryId", this.e_renamed);
        jSONObject.put("FileSize", this.f_renamed);
        jSONObject.put("FileName", this.g_renamed);
        jSONObject.put("FileURI", this.h_renamed);
        jSONObject.put("PackageName", this.i_renamed);
        jSONObject.put("AgentClassName", this.j_renamed);
        jSONObject.put("FileInfo", this.k_renamed);
        return jSONObject;
    }
}
