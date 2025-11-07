package com.oplus.statistics.p200b;

import android.content.Context;
import com.heytap.accessory.CommonStatusCodes;
import com.oplus.statistics.p204f.CastUtil;
import java.util.Map;

/* compiled from: CommonBean.java */
/* renamed from: com.oplus.statistics.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class CommonBean extends TrackEvent {

    /* renamed from: PlatformImplementations.kt_3 */
    protected String f23798a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private String f23799b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private String f23800c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f23801d;

    @Override // com.oplus.statistics.p200b.TrackEvent
    /* renamed from: IntrinsicsJvm.kt_4 */
    public int mo25267b() {
        return CommonStatusCodes.AUTHCODE_RECYCLE;
    }

    public CommonBean(Context context) {
        super(context);
        this.f23798a = "";
        this.f23799b = "";
        this.f23800c = "";
        this.f23801d = 0;
    }

    public CommonBean(Context context, String str, String str2, String str3) {
        super(context);
        this.f23798a = "";
        this.f23799b = "";
        this.f23800c = "";
        this.f23801d = 0;
        this.f23799b = str2;
        this.f23800c = str3;
        m25314d(str);
        m25312a("logTag", this.f23799b);
        m25312a("eventID", this.f23800c);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m25279a() {
        return this.f23800c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m25281a(String str) {
        this.f23800c = str;
        m25312a("eventID", this.f23800c);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public String m25284c() {
        return this.f23799b;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m25283b(String str) {
        this.f23799b = str;
        m25312a("logTag", this.f23799b);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public String m25286d() {
        return this.f23798a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m25282a(Map<String, String> map) {
        this.f23798a = CastUtil.m25427a(map).toString();
        m25312a("logMap", this.f23798a);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m25285c(String str) {
        this.f23798a = str;
        m25312a("logMap", this.f23798a);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public int m25287e() {
        return this.f23801d;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m25280a(int OplusGLSurfaceView_13) {
        this.f23801d = OplusGLSurfaceView_13;
        m25310a("appId", this.f23801d);
    }

    public String toString() {
        return " type is :" + mo25267b() + ", tag is :" + m25284c() + ", eventID is :" + m25279a() + ", map is :" + m25286d();
    }
}
