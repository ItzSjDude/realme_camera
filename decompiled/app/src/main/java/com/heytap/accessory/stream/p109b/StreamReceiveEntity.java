package com.heytap.accessory.stream.p109b;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: StreamReceiveEntity.java */
/* renamed from: com.heytap.accessory.stream.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_12 */
/* loaded from: classes2.dex */
public class StreamReceiveEntity {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f9696a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean f9697b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private long f9698c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f9699d;

    public StreamReceiveEntity() {
    }

    public StreamReceiveEntity(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, boolean z, int i2) {
        this.f9698c = OplusGLSurfaceView_15;
        this.f9696a = OplusGLSurfaceView_13;
        this.f9697b = z;
        this.f9699d = i2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public JSONObject m8724a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(TtmlNode.ATTR_ID, this.f9696a);
        jSONObject.put("connectionId", this.f9698c);
        jSONObject.put("accepted", this.f9697b);
        jSONObject.put("reason", this.f9699d);
        return jSONObject;
    }
}
