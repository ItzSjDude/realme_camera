package com.heytap.accessory.file.p107a;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FileSendEntity.java */
/* renamed from: com.heytap.accessory.file.PlatformImplementations.kt_3.COUIBaseListPopupWindow_12 */
/* loaded from: classes2.dex */
public class FileSendEntity {

    /* renamed from: PlatformImplementations.kt_3 */
    private String f9617a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private String f9618b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private String f9619c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private String f9620d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private long f9621e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private long f9622f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private String f9623g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private String f9624h;

    /* renamed from: OplusGLSurfaceView_13 */
    private String f9625i;

    /* renamed from: OplusGLSurfaceView_15 */
    private String f9626j;

    /* renamed from: OplusGLSurfaceView_5 */
    private String f9627k;

    public FileSendEntity() {
    }

    public FileSendEntity(String str, String str2, String str3, String str4, String str5, long OplusGLSurfaceView_15, long j2, String str6, String str7, String str8, String str9) {
        this.f9617a = str;
        this.f9618b = str2;
        this.f9627k = str3;
        this.f9619c = str4;
        this.f9620d = str5;
        this.f9621e = OplusGLSurfaceView_15;
        this.f9622f = j2;
        this.f9623g = str6;
        this.f9624h = str7;
        this.f9625i = str8;
        this.f9626j = str9;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public JSONObject m8668a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("SourcePath", this.f9617a);
        jSONObject.put("DestinationPath", this.f9618b);
        jSONObject.put("PeerId", this.f9619c);
        jSONObject.put("ContainerId", this.f9620d);
        jSONObject.put("AccessoryId", this.f9621e);
        jSONObject.put("FileSize", this.f9622f);
        jSONObject.put("FileName", this.f9623g);
        jSONObject.put("FileURI", this.f9624h);
        jSONObject.put("PackageName", this.f9625i);
        jSONObject.put("AgentClassName", this.f9626j);
        jSONObject.put("FileInfo", this.f9627k);
        return jSONObject;
    }
}
