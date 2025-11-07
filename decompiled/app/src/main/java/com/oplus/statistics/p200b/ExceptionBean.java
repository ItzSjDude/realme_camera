package com.oplus.statistics.p200b;

import android.content.Context;
import com.heytap.accessory.CommonStatusCodes;

/* compiled from: ExceptionBean.java */
/* renamed from: com.oplus.statistics.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_11 */
/* loaded from: classes2.dex */
public class ExceptionBean extends TrackEvent {

    /* renamed from: PlatformImplementations.kt_3 */
    private long f23805a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private String f23806b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f23807c;

    @Override // com.oplus.statistics.p200b.TrackEvent
    /* renamed from: IntrinsicsJvm.kt_4 */
    public int mo25267b() {
        return CommonStatusCodes.AUTHCODE_EXPECTED;
    }

    public ExceptionBean(Context context) {
        super(context);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public long m25290a() {
        return this.f23805a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m25292a(long OplusGLSurfaceView_15) {
        this.f23805a = OplusGLSurfaceView_15;
        m25311a("time", this.f23805a);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public String m25294c() {
        return this.f23806b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m25293a(String str) {
        this.f23806b = str;
        m25312a("exception", this.f23806b);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public int m25295d() {
        return this.f23807c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m25291a(int OplusGLSurfaceView_13) {
        this.f23807c = OplusGLSurfaceView_13;
        m25310a("time", this.f23807c);
    }

    public String toString() {
        return "exception is :" + m25294c() + "\ncount is :" + m25295d() + "\ntime is :" + m25290a() + "\OplusGLSurfaceView_11";
    }
}
