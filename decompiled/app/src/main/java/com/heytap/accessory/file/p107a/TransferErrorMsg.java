package com.heytap.accessory.file.p107a;

import com.android.providers.downloads.Downloads;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TransferErrorMsg.java */
/* renamed from: com.heytap.accessory.file.PlatformImplementations.kt_3.OplusGLSurfaceView_13 */
/* loaded from: classes2.dex */
public class TransferErrorMsg {

    /* renamed from: PlatformImplementations.kt_3 */
    private long f9635a = -1;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f9636b = -1;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f9637c = -1;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private String f9638d = "";

    /* renamed from: PlatformImplementations.kt_3 */
    public long m8677a() {
        return this.f9635a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m8679b() {
        return this.f9636b;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int m8680c() {
        return this.f9637c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8678a(Object obj) throws JSONException {
        JSONObject jSONObject = new JSONObject((String) obj);
        this.f9635a = jSONObject.getLong("connectionId");
        this.f9636b = jSONObject.getInt("transactionId");
        this.f9637c = jSONObject.getInt("errorCode");
        this.f9638d = jSONObject.getString(Downloads.Impl.COLUMN_ERROR_MSG);
    }
}
