package com.heytap.accessory.stream.p109b;

import com.android.providers.downloads.Downloads;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: MultiTransferErrorMsg.java */
/* renamed from: com.heytap.accessory.stream.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class MultiTransferErrorMsg_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private int[] f9691a = null;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f9692b = -1;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private String f9693c = "";

    /* renamed from: PlatformImplementations.kt_3 */
    public int[] m8721a() {
        return this.f9691a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m8722b() {
        return this.f9692b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8720a(Object obj) throws JSONException {
        JSONObject jSONObject = new JSONObject((String) obj);
        JSONArray jSONArray = jSONObject.getJSONArray(TtmlNode.ATTR_ID);
        this.f9692b = jSONObject.getInt("errorCode");
        this.f9693c = jSONObject.getString(Downloads.Impl.COLUMN_ERROR_MSG);
        this.f9691a = new int[jSONArray.length()];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < jSONArray.length(); OplusGLSurfaceView_13++) {
            this.f9691a[OplusGLSurfaceView_13] = jSONArray.getInt(OplusGLSurfaceView_13);
        }
    }
}
