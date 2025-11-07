package com.oplus.statistics.p201c;

import android.content.Context;
import com.oplus.statistics.p200b.TrackEvent;
import com.oplus.statistics.p204f.VersionUtil;

/* compiled from: ProxyRecorder.java */
/* renamed from: com.oplus.statistics.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class ProxyRecorder implements IRecorder {

    /* renamed from: PlatformImplementations.kt_3 */
    private IRecorder f23832a;

    /* compiled from: ProxyRecorder.java */
    /* renamed from: com.oplus.statistics.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_5$PlatformImplementations.kt_3 */
    private static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        private static ProxyRecorder f23833a = new ProxyRecorder();
    }

    private ProxyRecorder() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static ProxyRecorder m25337a() {
        return PlatformImplementations.kt_3.f23833a;
    }

    @Override // com.oplus.statistics.p201c.IRecorder
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo25336a(Context context, TrackEvent abstractC3733m) {
        m25338a(context);
        this.f23832a.mo25336a(context, abstractC3733m);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m25338a(Context context) {
        if (this.f23832a != null) {
            return;
        }
        if (VersionUtil.m25440b(context)) {
            this.f23832a = new ContentProviderRecorder();
        } else {
            this.f23832a = new ServiceRecorder();
        }
    }
}
