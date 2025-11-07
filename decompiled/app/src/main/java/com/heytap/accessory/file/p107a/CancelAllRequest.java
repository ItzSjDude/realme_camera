package com.heytap.accessory.file.p107a;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CancelAllRequest.java */
/* renamed from: com.heytap.accessory.file.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class CancelAllRequest {

    /* renamed from: PlatformImplementations.kt_3 */
    private String f9597a;

    public CancelAllRequest() {
    }

    public CancelAllRequest(String str) {
        this.f9597a = str;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public JSONObject m8657a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("AgentId", this.f9597a);
        return jSONObject;
    }
}
