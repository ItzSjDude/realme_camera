package com.heytap.accessory.stream.p109b;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CancelStreamRequest.java */
/* renamed from: com.heytap.accessory.stream.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class CancelStreamRequest {

    /* renamed from: PlatformImplementations.kt_3 */
    private long f9689a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f9690b;

    public CancelStreamRequest() {
    }

    public CancelStreamRequest(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
        this.f9689a = OplusGLSurfaceView_15;
        this.f9690b = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public JSONObject m8719a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("connectionId", this.f9689a);
        jSONObject.put("TransactionId", this.f9690b);
        return jSONObject;
    }
}
