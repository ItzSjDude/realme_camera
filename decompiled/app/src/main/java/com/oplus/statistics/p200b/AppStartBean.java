package com.oplus.statistics.p200b;

import android.content.Context;

/* compiled from: AppStartBean.java */
/* renamed from: com.oplus.statistics.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class AppStartBean extends TrackEvent {

    /* renamed from: PlatformImplementations.kt_3 */
    private String f23797a;

    @Override // com.oplus.statistics.p200b.TrackEvent
    /* renamed from: IntrinsicsJvm.kt_4 */
    public int mo25267b() {
        return 1000;
    }

    public AppStartBean(Context context, String str) {
        super(context);
        this.f23797a = "0";
        this.f23797a = str;
        m25312a("loginTime", this.f23797a);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m25277a() {
        return this.f23797a;
    }

    public String toString() {
        return "loginTime is :" + m25277a() + "\OplusGLSurfaceView_11";
    }
}
