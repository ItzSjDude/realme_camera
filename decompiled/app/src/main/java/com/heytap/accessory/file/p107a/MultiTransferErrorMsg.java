package com.heytap.accessory.file.p107a;

import com.android.providers.downloads.Downloads;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: MultiTransferErrorMsg.java */
/* renamed from: com.heytap.accessory.file.PlatformImplementations.kt_3.COUIBaseListPopupWindow_11 */
/* loaded from: classes2.dex */
public class MultiTransferErrorMsg {

    /* renamed from: PlatformImplementations.kt_3 */
    private int[] f9628a = null;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f9629b = -1;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private String f9630c = "";

    /* renamed from: PlatformImplementations.kt_3 */
    public int[] m8670a() {
        return this.f9628a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m8671b() {
        return this.f9629b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8669a(Object obj) throws JSONException {
        JSONObject jSONObject = new JSONObject((String) obj);
        JSONArray jSONArray = jSONObject.getJSONArray(TtmlNode.ATTR_ID);
        this.f9629b = jSONObject.getInt("errorCode");
        this.f9630c = jSONObject.getString(Downloads.Impl.COLUMN_ERROR_MSG);
        this.f9628a = new int[jSONArray.length()];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < jSONArray.length(); OplusGLSurfaceView_13++) {
            this.f9628a[OplusGLSurfaceView_13] = jSONArray.getInt(OplusGLSurfaceView_13);
        }
    }
}
