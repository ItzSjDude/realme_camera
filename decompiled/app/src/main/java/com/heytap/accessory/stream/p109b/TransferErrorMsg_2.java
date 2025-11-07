package com.heytap.accessory.stream.p109b;

import com.android.providers.downloads.Downloads;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TransferErrorMsg.java */
/* renamed from: com.heytap.accessory.stream.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_10 */
/* loaded from: classes2.dex */
public class TransferErrorMsg_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private long f9705a = -1;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f9706b = -1;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f9707c = -1;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private String f9708d = "";

    /* renamed from: PlatformImplementations.kt_3 */
    public long m8726a() {
        return this.f9705a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m8728b() {
        return this.f9706b;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int m8729c() {
        return this.f9707c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8727a(Object obj) throws JSONException {
        JSONObject jSONObject = new JSONObject((String) obj);
        this.f9705a = jSONObject.getLong("connectionId");
        this.f9706b = jSONObject.getInt("transactionId");
        this.f9707c = jSONObject.getInt("errorCode");
        this.f9708d = jSONObject.getString(Downloads.Impl.COLUMN_ERROR_MSG);
    }
}
