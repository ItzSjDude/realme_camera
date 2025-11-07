package com.heytap.accessory.file.p107a;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FTOperateEntity.java */
/* renamed from: com.heytap.accessory.file.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class FTOperateEntity {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f9604a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private JSONObject f9605b;

    public FTOperateEntity() {
    }

    public FTOperateEntity(int OplusGLSurfaceView_13, JSONObject jSONObject) {
        this.f9604a = OplusGLSurfaceView_13;
        this.f9605b = jSONObject;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public JSONObject m8659a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("OpCode", this.f9604a);
        jSONObject.put("Parameters", this.f9605b);
        return jSONObject;
    }
}
