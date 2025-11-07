package com.heytap.accessory.stream.p109b;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: STOperateEntity.java */
/* renamed from: com.heytap.accessory.stream.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class STOperateEntity {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f9694a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private JSONObject f9695b;

    public STOperateEntity() {
    }

    public STOperateEntity(int OplusGLSurfaceView_13, JSONObject jSONObject) {
        this.f9694a = OplusGLSurfaceView_13;
        this.f9695b = jSONObject;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public JSONObject m8723a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("OpCode", this.f9694a);
        jSONObject.put("Parameters", this.f9695b);
        return jSONObject;
    }
}
