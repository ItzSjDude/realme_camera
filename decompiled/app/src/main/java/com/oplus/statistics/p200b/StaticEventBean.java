package com.oplus.statistics.p200b;

import android.content.Context;
import com.heytap.accessory.CommonStatusCodes;

/* compiled from: StaticEventBean.java */
/* renamed from: com.oplus.statistics.IntrinsicsJvm.kt_4.OplusGLSurfaceView_14 */
/* loaded from: classes2.dex */
public class StaticEventBean extends TrackEvent {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f23817a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private String f23818b;

    @Override // com.oplus.statistics.p200b.TrackEvent
    /* renamed from: IntrinsicsJvm.kt_4 */
    public int mo25267b() {
        return CommonStatusCodes.CAPABILITY_EXCEPTION;
    }

    public StaticEventBean(Context context, int OplusGLSurfaceView_13, String str) {
        super(context);
        this.f23817a = 0;
        this.f23818b = "";
        this.f23817a = OplusGLSurfaceView_13;
        this.f23818b = str;
        m25310a("uploadMode", this.f23817a);
        m25312a("eventBody", this.f23818b);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m25307a() {
        return this.f23818b;
    }

    public String toString() {
        return "uploadMode is :" + this.f23817a + "\nbody is :" + m25307a() + "\OplusGLSurfaceView_11";
    }
}
