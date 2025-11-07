package com.heytap.accessory.file.p107a;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TransferCompleteMsg.java */
/* renamed from: com.heytap.accessory.file.PlatformImplementations.kt_3.COUIBaseListPopupWindow_10 */
/* loaded from: classes2.dex */
public class TransferCompleteMsg {

    /* renamed from: PlatformImplementations.kt_3 */
    private long f9631a = 0;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f9632b = 0;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private String f9633c = "";

    /* renamed from: IntrinsicsJvm.kt_5 */
    private String f9634d = "";

    /* renamed from: PlatformImplementations.kt_3 */
    public long m8672a() {
        return this.f9631a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m8674b() {
        return this.f9632b;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public String m8675c() {
        return this.f9633c;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public String m8676d() {
        return this.f9634d;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8673a(Object obj) throws JSONException {
        JSONObject jSONObject = new JSONObject((String) obj);
        this.f9631a = jSONObject.getLong("connectionId");
        this.f9632b = jSONObject.getInt("transactionId");
        this.f9633c = jSONObject.getString("sourcePath");
        this.f9634d = jSONObject.getString("destPath");
    }
}
