package com.oplus.statistics.p200b;

import android.content.Context;

/* compiled from: AppLogBean.java */
/* renamed from: com.oplus.statistics.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class AppLogBean extends TrackEvent {

    /* renamed from: PlatformImplementations.kt_3 */
    private String f23790a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private String f23791b;

    @Override // com.oplus.statistics.p200b.TrackEvent
    /* renamed from: IntrinsicsJvm.kt_4 */
    public int mo25267b() {
        return 1002;
    }

    public AppLogBean(Context context, String str, String str2) {
        super(context);
        this.f23790a = "";
        this.f23791b = "";
        this.f23790a = str;
        this.f23791b = str2;
        m25312a("eventType", this.f23790a);
        m25312a("eventBody", this.f23791b);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m25266a() {
        return this.f23791b;
    }

    public String toString() {
        return "type is :" + mo25267b() + "\nbody is :" + m25266a() + "\OplusGLSurfaceView_11";
    }
}
