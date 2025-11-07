package com.oplus.statistics.p200b;

import android.content.Context;
import com.heytap.accessory.CommonStatusCodes;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;

/* compiled from: PageVisitBean.java */
/* renamed from: com.oplus.statistics.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_10 */
/* loaded from: classes2.dex */
public class PageVisitBean extends TrackEvent {

    /* renamed from: PlatformImplementations.kt_3 */
    private String f23808a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private long f23809b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private String f23810c;

    @Override // com.oplus.statistics.p200b.TrackEvent
    /* renamed from: IntrinsicsJvm.kt_4 */
    public int mo25267b() {
        return CommonStatusCodes.TIME_EXPIRED;
    }

    public PageVisitBean(Context context) {
        super(context);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m25296a() {
        return this.f23808a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m25298a(String str) {
        this.f23808a = str;
        m25312a("time", this.f23808a);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public long m25300c() {
        return this.f23809b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m25297a(long OplusGLSurfaceView_15) {
        this.f23809b = OplusGLSurfaceView_15;
        m25311a(FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, this.f23809b);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public String m25301d() {
        return this.f23810c;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m25299b(String str) {
        this.f23810c = str;
        m25312a("activities", this.f23810c);
    }

    public String toString() {
        return "time is :" + m25296a() + "\nduration is :" + m25300c() + "\nactivities is :" + m25301d() + "\OplusGLSurfaceView_11";
    }
}
