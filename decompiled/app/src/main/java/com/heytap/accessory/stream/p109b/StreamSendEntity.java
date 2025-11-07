package com.heytap.accessory.stream.p109b;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: StreamSendEntity.java */
/* renamed from: com.heytap.accessory.stream.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_11 */
/* loaded from: classes2.dex */
public class StreamSendEntity {

    /* renamed from: PlatformImplementations.kt_3 */
    private String f9700a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private String f9701b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private long f9702c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private String f9703d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private String f9704e;

    public StreamSendEntity() {
    }

    public StreamSendEntity(String str, String str2, long OplusGLSurfaceView_15, String str3, String str4) {
        this.f9700a = str;
        this.f9701b = str2;
        this.f9702c = OplusGLSurfaceView_15;
        this.f9703d = str3;
        this.f9704e = str4;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public JSONObject m8725a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("PeerId", this.f9700a);
        jSONObject.put("ContainerId", this.f9701b);
        jSONObject.put("AccessoryId", this.f9702c);
        jSONObject.put("PackageName", this.f9703d);
        jSONObject.put("AgentClassName", this.f9704e);
        return jSONObject;
    }
}
