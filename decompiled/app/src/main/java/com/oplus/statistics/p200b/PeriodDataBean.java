package com.oplus.statistics.p200b;

import android.content.Context;
import com.heytap.accessory.CommonStatusCodes;
import com.oplus.statistics.p204f.VersionUtil;

/* compiled from: PeriodDataBean.java */
/* renamed from: com.oplus.statistics.IntrinsicsJvm.kt_4.OplusGLSurfaceView_13 */
/* loaded from: classes2.dex */
public class PeriodDataBean extends CommonBean {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final int f23811b;

    public PeriodDataBean(Context context) {
        super(context);
        this.f23811b = VersionUtil.m25439a(context) ? 1019 : CommonStatusCodes.AUTHCODE_RECYCLE;
        m25310a("dataType", this.f23811b);
    }

    @Override // com.oplus.statistics.p200b.CommonBean, com.oplus.statistics.p200b.TrackEvent
    /* renamed from: IntrinsicsJvm.kt_4 */
    public int mo25267b() {
        return this.f23811b;
    }

    @Override // com.oplus.statistics.p200b.CommonBean
    public String toString() {
        return " type is :" + mo25267b() + ", tag is :" + m25284c() + ", eventID is :" + m25279a() + ", map is :" + m25286d();
    }
}
