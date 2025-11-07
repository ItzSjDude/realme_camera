package com.heytap.accessory.file.p107a;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FileReceiveEntity.java */
/* renamed from: com.heytap.accessory.file.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class FileReceiveEntity {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f9612a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private String f9613b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private String f9614c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f9615d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private long f9616e;

    public FileReceiveEntity() {
    }

    public FileReceiveEntity(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, String str, String str2, boolean z) {
        this.f9616e = OplusGLSurfaceView_15;
        this.f9612a = OplusGLSurfaceView_13;
        this.f9613b = str;
        this.f9615d = z;
        this.f9614c = str2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public JSONObject m8667a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(TtmlNode.ATTR_ID, this.f9612a);
        jSONObject.put("path", this.f9613b);
        jSONObject.put("fileuri", this.f9614c);
        jSONObject.put("accepted", this.f9615d);
        jSONObject.put("connectionId", this.f9616e);
        return jSONObject;
    }
}
