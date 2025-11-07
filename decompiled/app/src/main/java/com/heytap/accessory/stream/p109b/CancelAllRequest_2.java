package com.heytap.accessory.stream.p109b;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CancelAllRequest.java */
/* renamed from: com.heytap.accessory.stream.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class CancelAllRequest_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private String f9687a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private long f9688b;

    public CancelAllRequest_2() {
    }

    public CancelAllRequest_2(String str, long OplusGLSurfaceView_15) {
        this.f9687a = str;
        this.f9688b = OplusGLSurfaceView_15;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public JSONObject m8718a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("AgentId", this.f9687a);
        jSONObject.put("ConnectionId", this.f9688b);
        return jSONObject;
    }
}
