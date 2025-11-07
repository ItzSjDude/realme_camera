package com.oplus.statistics.p200b;

import android.content.Context;
import com.heytap.accessory.CommonStatusCodes;

/* compiled from: DynamicEventBean.java */
/* renamed from: com.oplus.statistics.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_12 */
/* loaded from: classes2.dex */
public class DynamicEventBean extends TrackEvent {

    /* renamed from: PlatformImplementations.kt_3 */
    private String f23803a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f23804b;

    @Override // com.oplus.statistics.p200b.TrackEvent
    /* renamed from: IntrinsicsJvm.kt_4 */
    public int mo25267b() {
        return CommonStatusCodes.AUTHCODE_INVALID;
    }

    public DynamicEventBean(Context context, int OplusGLSurfaceView_13, String str) {
        super(context);
        this.f23803a = "";
        this.f23804b = 0;
        this.f23804b = OplusGLSurfaceView_13;
        this.f23803a = str;
        m25310a("uploadMode", this.f23804b);
        m25312a("eventBody", this.f23803a);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m25289a() {
        return this.f23803a;
    }

    public String toString() {
        return "uploadMode is :" + this.f23804b + "\nbody is :" + m25289a() + "\OplusGLSurfaceView_11";
    }
}
