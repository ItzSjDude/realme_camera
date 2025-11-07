package com.heytap.accessory.file.a_renamed;

/* compiled from: MultiTransferErrorMsg.java */
/* loaded from: classes2.dex */
public class g_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int[] f3368a = null;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f3369b = -1;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.lang.String f3370c = "";

    public int[] a_renamed() {
        return this.f3368a;
    }

    public int b_renamed() {
        return this.f3369b;
    }

    public void a_renamed(java.lang.Object obj) throws org.json.JSONException {
        org.json.JSONObject jSONObject = new org.json.JSONObject((java.lang.String) obj);
        org.json.JSONArray jSONArray = jSONObject.getJSONArray(com.google.android.exoplayer2.text.ttml.TtmlNode.ATTR_ID);
        this.f3369b = jSONObject.getInt("errorCode");
        this.f3370c = jSONObject.getString(com.android.providers.downloads.Downloads.Impl.COLUMN_ERROR_MSG);
        this.f3368a = new int[jSONArray.length()];
        for (int i_renamed = 0; i_renamed < jSONArray.length(); i_renamed++) {
            this.f3368a[i_renamed] = jSONArray.getInt(i_renamed);
        }
    }
}
