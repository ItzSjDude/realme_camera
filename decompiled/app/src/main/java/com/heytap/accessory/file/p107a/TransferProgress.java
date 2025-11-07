package com.heytap.accessory.file.p107a;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TransferProgress.java */
/* renamed from: com.heytap.accessory.file.PlatformImplementations.kt_3.OplusGLSurfaceView_15 */
/* loaded from: classes2.dex */
public class TransferProgress {

    /* renamed from: PlatformImplementations.kt_3 */
    private long f9639a = -1;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f9640b = -1;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private long f9641c = 0;

    /* renamed from: PlatformImplementations.kt_3 */
    public long m8681a() {
        return this.f9639a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m8683b() {
        return this.f9640b;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public long m8684c() {
        return this.f9641c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8682a(Object obj) throws JSONException {
        JSONObject jSONObject = new JSONObject((String) obj);
        this.f9639a = jSONObject.getLong("connectionId");
        this.f9640b = jSONObject.getInt("transactionId");
        this.f9641c = jSONObject.getLong("progress");
    }
}
