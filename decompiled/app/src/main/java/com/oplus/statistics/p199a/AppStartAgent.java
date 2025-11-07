package com.oplus.statistics.p199a;

import android.content.Context;
import com.oplus.statistics.p200b.AppStartBean;
import com.oplus.statistics.p201c.ProxyRecorder;
import com.oplus.statistics.p204f.LogUtil;
import com.oplus.statistics.p204f.TimeInfoUtil;
import com.oplus.statistics.p204f.Supplier;

/* compiled from: AppStartAgent.java */
/* renamed from: com.oplus.statistics.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class AppStartAgent {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ String m25216a() {
        return "调用AppStart";
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m25217a(Context context) {
        LogUtil.m25432c("AppStartAgent", new Supplier() { // from class: com.oplus.statistics.PlatformImplementations.kt_3.-$$Lambda$PlatformImplementations.kt_3$Wbh1WA7HgB25vE4c6balhv5x3Cs
            @Override // com.oplus.statistics.p204f.Supplier
            public final Object get() {
                return AppStartAgent.m25216a();
            }
        });
        ProxyRecorder.m25337a().mo25336a(context, new AppStartBean(context, TimeInfoUtil.m25435a()));
    }
}
