package com.heytap.accessory.file.p107a;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CancelFileRequest.java */
/* renamed from: com.heytap.accessory.file.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class CancelFileRequest {

    /* renamed from: PlatformImplementations.kt_3 */
    private long f9602a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f9603b;

    public CancelFileRequest() {
    }

    public CancelFileRequest(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
        this.f9602a = OplusGLSurfaceView_15;
        this.f9603b = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public JSONObject m8658a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("connectionId", this.f9602a);
        jSONObject.put("TransactionId", this.f9603b);
        return jSONObject;
    }
}
