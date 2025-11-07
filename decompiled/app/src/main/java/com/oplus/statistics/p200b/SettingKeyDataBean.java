package com.oplus.statistics.p200b;

import android.content.Context;
import com.heytap.accessory.CommonStatusCodes;
import com.oplus.statistics.p199a.StaticPeriodDataRecord;
import com.oplus.statistics.p204f.VersionUtil;
import java.util.List;

/* compiled from: SettingKeyDataBean.java */
/* renamed from: com.oplus.statistics.IntrinsicsJvm.kt_4.OplusGLSurfaceView_5 */
/* loaded from: classes2.dex */
public class SettingKeyDataBean extends CommonBean {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final int f23816b;

    public SettingKeyDataBean(Context context) {
        super(context);
        this.f23816b = VersionUtil.m25439a(context) ? 1020 : CommonStatusCodes.AUTHCODE_RECYCLE;
        m25310a("dataType", this.f23816b);
    }

    @Override // com.oplus.statistics.p200b.CommonBean, com.oplus.statistics.p200b.TrackEvent
    /* renamed from: IntrinsicsJvm.kt_4 */
    public int mo25267b() {
        return this.f23816b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m25306a(List<SettingKeyBean> list) {
        super.m25285c(StaticPeriodDataRecord.m25255a(list).toString());
    }

    @Override // com.oplus.statistics.p200b.CommonBean
    public String toString() {
        return " type is :" + mo25267b() + ", tag is :" + m25284c() + ", eventID is :" + m25279a() + ", map is :" + m25286d();
    }
}
