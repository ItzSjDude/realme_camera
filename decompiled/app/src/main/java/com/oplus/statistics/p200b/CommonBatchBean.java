package com.oplus.statistics.p200b;

import android.content.Context;
import com.heytap.accessory.CommonStatusCodes;
import com.oplus.statistics.DataOverSizeException;
import com.oplus.statistics.p204f.CastUtil;
import com.oplus.statistics.p204f.LogUtil;
import com.oplus.statistics.p204f.Supplier;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* compiled from: CommonBatchBean.java */
/* renamed from: com.oplus.statistics.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class CommonBatchBean extends CommonBean {
    @Override // com.oplus.statistics.p200b.CommonBean, com.oplus.statistics.p200b.TrackEvent
    /* renamed from: IntrinsicsJvm.kt_4 */
    public int mo25267b() {
        return CommonStatusCodes.PERMISSION_DENIAL;
    }

    public CommonBatchBean(Context context) {
        super(context);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m25278a(List<Map<String, String>> list) throws DataOverSizeException {
        JSONArray jSONArray = new JSONArray();
        Iterator<Map<String, String>> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(CastUtil.m25427a(it.next()));
        }
        String string = jSONArray.toString();
        if (string.length() >= 131072) {
            final String str = "DataOverSizeException :" + m25316g() + ", " + m25284c() + ", " + m25279a();
            str.getClass();
            LogUtil.m25431b("CommonBatchBean", new Supplier() { // from class: com.oplus.statistics.IntrinsicsJvm.kt_4.-$$Lambda$oM9guskQ-Ngpr3mxKxCbKFcfZwA
                @Override // com.oplus.statistics.p204f.Supplier
                public final Object get() {
                    return str.toString();
                }
            });
            throw new DataOverSizeException(str);
        }
        this.f23798a = string;
        m25312a("mapList", this.f23798a);
    }
}
